package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.ConfigurationAPI;
import com.tsc.api.apiBuilder.ProductAPI;
import com.tsc.api.pojo.Configuration;
import com.tsc.api.pojo.Product;
import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SC_TC09_VerifyShoppingCart_Free_Gift_Item_And_Blue_Jay_Donation_With_PayPal_Checkout extends BaseTest {
    /*
     * CER-852 - Shopping Cart - Add item (having associate gift item) and check sub-total and order summary
     * CER-870 - Shopping Cart - Verify blue jays donation addition
     * CER-866 - Shopping Cart - Verify PayPal button functionality
     * CER-864 - Global Header - Verify display of global header on all pages
     * CER-865 - Global Footer - Verify display of global footer on all pages
     */
    @Test(groups={"Regression","ShoppingCart","SauceTunnelTest"})
    public void SC_TC09_VerifyShoppingCart_Free_Gift_Item_And_Blue_Jay_Donation_With_PayPal_Checkout() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //Fetching test data from test data file
        String lsUserName= TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword= TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        String apiEndPoint = TestDataHandler.constantData.getContentfulApiParams().getLbl_apiEndPoint();
        String authorization = TestDataHandler.constantData.getContentfulApiParams().getLbl_authorization();
        String jayCareFoundationMessage = TestDataHandler.constantData.getShoppingCart().getLblJayCareFoundationDonationMessage();

        //Verification of Header Menu Items on Page
        reporter.reportLog("Verification of Global Header on Page");
        getglobalheaderPageThreadLocal().verifyHeaderItemsOnPage();

        JSONObject creditCardData = new DataConverter().readJsonFileIntoJSONObject("test-data/CreditCard.json");

        List<Configuration> configurations = new ConfigurationAPI().getContentFulConfigurationForFreeItem(apiEndPoint,authorization);
        if(configurations==null)
            reporter.reportLogFail("Configurations are not returned by system");

        //Deleting all items from cart to be added again with free shipping item
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();
        try{
            getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);

            //Verifying configurations and adding necessary credit Card for user
            getShoppingCartThreadLocal().verifyAndUpdateCreditCardAsPerSystemConfiguration(configurations,creditCardData,customerEDP,accessToken);

            //Adding item to cart for user for dimensionId fetched from configuration
            Map<String,Object> configData = getShoppingCartThreadLocal().getRequiredDetailsFromContentFulConfiguration(configurations, Arrays.asList("GWPCategoryFacetIdsIncluded","GWPCartSubTotalThreshold","GWPItemNosIncluded"));
            if(configData.get("GWPCategoryFacetIdsIncluded")!=null){
                List<Product.edps> edpNoForFreeShippingProduct = null;
                String[] dimensionIds = configData.get("GWPCategoryFacetIdsIncluded").toString().split(",");
                for(String dimensionId:dimensionIds){
                    edpNoForFreeShippingProduct = new ProductAPI().getEDPNoForFreeShippingProduct(dimensionId,1);
                    if(edpNoForFreeShippingProduct.size()>0){
                        //Calling api to get product item no to be added to bag for user that has free shipping condition satisfied
                        getShoppingCartThreadLocal().addAdvanceOrderOrSingleProductToCartForUser(edpNoForFreeShippingProduct.get(0).getItemNo(),1,false,customerEDP,accessToken);
                        break;
                    }
                }
                if(edpNoForFreeShippingProduct.size()==0)
                    reporter.reportLogFail("Product is not fetched from dimension number fetched from configuration api");
            }else{
                String itemNoToBeAddedForFreeShipping = configData.get("GWPItemNosIncluded").toString();
                getShoppingCartThreadLocal().addAdvanceOrderOrSingleProductToCartForUser(itemNoToBeAddedForFreeShipping,1,false,customerEDP,accessToken);
            }

            //Login using valid username and password
            getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
            try {
                getShoppingCartThreadLocal().waitForCondition(Driver -> {
                    return Integer.valueOf(getglobalheaderPageThreadLocal().CartBagCounter.getText()) > 0;
                }, 6000);
            }
            catch(Exception e){
                (new BasePage(this.getDriver())).applyStaticWait(3000);
            }
            getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();
            Map<String,Object> shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("mandatory");

            reporter.reportLog("Verifying that free shipping item is added for user");
            getShoppingCartThreadLocal().verifyFreeGiftItemPresentInCart(shoppingCartMap, Integer.valueOf(getShoppingCartThreadLocal().getKeyValueFromContentfulConfiguration(configurations,"GWPGiftItemEdp").toString()));

            reporter.reportLog("Verify OrderSummary and EasyPayment sections contents");
            float subTotal=getShoppingCartThreadLocal().getSubTotalFromShoppingList((List<Map<String,Object>>)shoppingCartMap.get("shoppingList"));

            Map<String,Object> mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
            getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(subTotal,mapOrderSummary,null);
            getShoppingCartThreadLocal().verifyOrderSummaryContents();

            reporter.reportLog("Verify Blue Jay Donation Addition to cart for user");
            String selectedDonation = getShoppingCartThreadLocal().selectAndGetTextForBlueJayCare();
            getShoppingCartThreadLocal().verifyBlueJayDonationAdditionInCart(selectedDonation,jayCareFoundationMessage);

            reporter.reportLog("Verify OrderSummary after adding Blue Jay Donation amount");
            itemAmount=getShoppingCartThreadLocal().GetAddedItemAmount();
            savingPrice=getShoppingCartThreadLocal().getSavingPriceFromShoppingCartHeader();
            float donationAmountAddedToCart = Float.valueOf(selectedDonation.split("\\$")[1]);
            subTotal=subTotal+donationAmountAddedToCart;

            if(mapOrderSummary.size()>0)
                mapOrderSummary.clear();
            mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
            getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(itemAmount,savingPrice,subTotal,mapOrderSummary,null);
            getShoppingCartThreadLocal().verifyOrderSummaryContents();

            //Verification of PayPal button functionality
            if(System.getProperty("Browser").contains("ios") &&
                    (System.getProperty("Device").equalsIgnoreCase("Mobile") ||
                            System.getProperty("Device").equalsIgnoreCase("Tablet")))
                reporter.reportLog("PayPal Button not checked for ios mobile as it is blocked due to cross origin!");
            else{
                reporter.reportLog("Verification of PayPal Button functionality");
                getShoppingCartThreadLocal().verifyPayPalPopUpExistenceOnClick();
            }

            reporter.reportLog("Verify Global Footer on Page");
            getGlobalFooterPageThreadLocal().verifyFooterItemsOnPage();
        }finally {
            //Emptying Cart for next test to run with right state
            getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);
        }
    }
}
