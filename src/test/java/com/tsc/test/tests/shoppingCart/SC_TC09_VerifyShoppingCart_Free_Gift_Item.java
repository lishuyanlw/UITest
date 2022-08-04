package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.ApiResponse;
import com.tsc.api.apiBuilder.ConfigurationAPI;
import com.tsc.api.pojo.Configuration;
import com.tsc.api.pojo.Product;
import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SC_TC09_VerifyShoppingCart_Free_Gift_Item extends BaseTest {
    /*
     * CER-852 - Shopping Cart - Add item (having associate gift item) and check sub-total and order summary
     */
    @Test(groups={"Regression","ShoppingCart","SauceTunnelTest"})
    public void SC_TC09_VerifyShoppingCart_Free_Gift_Item() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //Fetching test data from test data file
        String lsUserName= TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        List<String> searchKeyword = TestDataHandler.constantData.searchResultPage.getLst_APISearchingKeyword();
        JSONObject creditCardData = new DataConverter().readJsonFileIntoJSONObject("test-data/CreditCard.json");

        List<Configuration> configurations = new ConfigurationAPI().getContentFulConfigurationForFreeItem();

        //Deleting all items from cart to be added again with free shipping item
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();
        try{
            getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);

            //Verifying configurations and adding necessary credit Card for user
            getShoppingCartThreadLocal().verifyAndUpdateCreditCardAsPerSystemConfiguration(configurations,creditCardData,customerEDP,accessToken);

            //Adding item to cart for user for dress keyword
            reporter.reportLog("Searching items for keyword dress : "+searchKeyword.get(0));
            Product.Products products = new ApiResponse().getProductOfPDPForAddToBagFromKeyword(searchKeyword.get(0));
            getShoppingCartThreadLocal().addAdvanceOrderOrSingleProductToCartForUser(products.getItemNo(),1,false,customerEDP,accessToken);

            //Login using valid username and password
            getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
            getShoppingCartThreadLocal().waitForCondition(Driver->{return Integer.valueOf(getglobalheaderPageThreadLocal().CartBagCounter.getText())>0;},6000);
            getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();

            reporter.reportLog("Verifying that free shipping item is added for user");
            getShoppingCartThreadLocal().verifyFreeShippingItemPresentInCart();

            reporter.reportLog("Verify OrderSummary and EasyPayment sections contents");
            int itemAmount=getShoppingCartThreadLocal().GetAddedItemAmount();
            float savingPrice=getShoppingCartThreadLocal().getSavingPriceFromShoppingCartHeader();
            float subTotal=getShoppingCartThreadLocal().getShoppingSubTotal();

            Map<String,Object> mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
            getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(itemAmount,savingPrice,subTotal,mapOrderSummary,null);
            getShoppingCartThreadLocal().verifyOrderSummaryContents();

        }finally {
            //Emptying Cart for next test to run with right state
            getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);
        }
    }
}
