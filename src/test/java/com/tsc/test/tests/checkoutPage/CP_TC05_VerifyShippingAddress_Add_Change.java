package com.tsc.test.tests.checkoutPage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CP_TC05_VerifyShippingAddress_Add_Change extends BaseTest {
    /**
     CER-876 - Checkout - Shipping address - Verify dialog display, list of addresses and other options
     CER-877 - Checkout - Shipping address - Add new Address, required message, duplicate address message
     CER-878 - Checkout - Shipping address - Verify edit address
    */
    @Test(groups={"Regression","Checkout","CheckoutMobTab"})
    public void CP_TC05_VerifyShippingAddress_Add_Change() throws IOException, ParseException {
        getGlobalFooterPageThreadLocal().closePopupDialog();
        Map<String,Object> newAddedAddress = null;

        //Fetching Data from test data yaml file
        String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        List<String> expectedErrorMessage = TestDataHandler.constantData.getCheckOut().getAddShippingAddressErrorMessage();
        List<Map<String,String>> inputAddress = TestDataHandler.constantData.getCheckOut().getNewShippingAddressForUser();
        String billingAddress = TestDataHandler.constantData.getCheckOut().getLblBillingAddress();
        String existingAddressErrorMessage = TestDataHandler.constantData.getCheckOut().getLblExistingAddressErrorMessage();

        //Fetching test data from test data file
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();
        try{
            //Emptying Cart for test to run with right state
            getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);

            //Verifying that item exists in cart and if not, create a new cart for user
            List<Map<String, String>> keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
            List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,"all",true,0);
            if(data.size()==0){
                keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
                data = getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,"all",true,0);
            }

            //Verification that user has ShippingAddress associated and if not, add one to user
            getRegularCheckoutThreadLocal().deleteNewAddedAddressFromUser(null,customerEDP,accessToken);
            CartAPI cartAPI = new CartAPI();
            Response response = cartAPI.getAccountCartContentWithCustomerEDP(customerEDP,accessToken);
            CartResponse cartResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
            cartAPI.getShippingAddressForUser(cartResponse,customerEDP,accessToken);

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
            getRegularCheckoutThreadLocal().navigateToCheckoutPage();

            //getRegularCheckoutThreadLocal().deleteInputAddressForNextTestRunForUser(inputAddress,customerEDP,accessToken);
            //Verification of Shipping Address display on Checkout Page
            //Verify title, button and links
            getReporter().reportLog("Verification of Shipping Address display on Checkout Page");
            String shippingAddress = getRegularCheckoutThreadLocal().verifyShippingAddressDisplayOnCheckout();

            //Verification that billing address is same as Shipping Address
            getReporter().reportLog("Verifying that Billing Address is same as shipping address");
            getRegularCheckoutThreadLocal().verifyUserBillingAddress(billingAddress);

            //Verification of Add/Change Shipping Address dialog box display on page
            //Verify Shipping Address dialog is displayed
            getReporter().reportLog("Verification of Add/Change Shipping Address Dialog Box");
            getRegularCheckoutThreadLocal().openAddOrChangeAddressDialog();
            getRegularCheckoutThreadLocal().verifyAddOrChangeAddressDialogContents();

            //Verification of selected shipping address on Checkout is same as Add/Change Shipping Address Dialog
            getReporter().reportLog("Verification of selected shipping address on Checkout is same as Add/Change Shipping Address Dialog");
            getRegularCheckoutThreadLocal().verifyShippingAddressOnCheckoutWithSelectedAddressOnAddChangeDialog(shippingAddress,null);

            //Verification of Add New Shipping Address dialog box display on page
            //Edit link for selected address
            //Verify Add New Address display
            getReporter().reportLog("Verification of Add New Shipping Address Dialog Box");
            getRegularCheckoutThreadLocal().openAddOrEditAddressDialog(getRegularCheckoutThreadLocal().btnAddOrChangeShippingAddressDialogAddNewAddressButton);
            getRegularCheckoutThreadLocal().verifyAddOrEditAddressDialogContents();

            //Verification of error message on not entering mandatory information in Add New Shipping Address Dialog
            getReporter().reportLog("Verification of error message on not entering mandatory information in Add New Shipping Address Dialog");
            getRegularCheckoutThreadLocal().verifyErrorMessageOnAddNewShippingAddressDialog(expectedErrorMessage);
            getRegularCheckoutThreadLocal().closeAddOrEditAddressDialog(false);

            //Verification of addition of new shipping address for user
            //Verify new address is displayed on Checkout page after save
            getReporter().reportLog("Verification of addition of new shipping address for user");
            getRegularCheckoutThreadLocal().openAddOrEditAddressDialog(getRegularCheckoutThreadLocal().btnAddOrChangeShippingAddressDialogAddNewAddressButton);
            newAddedAddress = getRegularCheckoutThreadLocal().addOrEditShippingAddress(inputAddress.get(0),true,false);
            getRegularCheckoutThreadLocal().verifyShippingAddressOnCheckoutWithSelectedAddressOnAddChangeDialog(null,newAddedAddress);

            //Verification that billing address is not same as Shipping Address
            getReporter().reportLog("Verifying that Billing Address is different from shipping address");
            getRegularCheckoutThreadLocal().verifyUserBillingAddress(shippingAddress);

            //Verify new address is saved successfully and is shown in Shipping Address dialog and is displayed at first place and is selected
            //Above part is to be checked if we have to refresh page - Asha will confirm later.
            getShoppingCartThreadLocal().refresh();
            String newShippingAddress = getRegularCheckoutThreadLocal().getAddressFromCheckoutPage("shipping");
            //Click on Add/Change button on Checkout page
            getRegularCheckoutThreadLocal().openAddOrChangeAddressDialog();
            getRegularCheckoutThreadLocal().verifyShippingAddressOnCheckoutWithSelectedAddressOnAddChangeDialog(newShippingAddress,null);

            //Verify already existing address message by adding existing address
            getReporter().reportLog("Verification of error message while adding existing shipping address");
            //getRegularCheckoutThreadLocal().openAddOrChangeAddressDialog();
            getRegularCheckoutThreadLocal().openAddOrEditAddressDialog(getRegularCheckoutThreadLocal().btnAddOrChangeShippingAddressDialogAddNewAddressButton);
            newAddedAddress = getRegularCheckoutThreadLocal().addOrEditShippingAddress(inputAddress.get(0),true,true);
            if(newAddedAddress.get("errorMessage").equals(existingAddressErrorMessage))
                reporter.reportLogPass("Error Message is displayed as expected while adding same address: "+newAddedAddress.get("errorMessage"));
            else
                reporter.reportLogFailWithScreenshot("Error Message is not displayed on adding same address: "+newAddedAddress.get("address"));

            //Verifying editing the existing address
            getReporter().reportLog("Verifying the existing address edit functionality for shipping address");
            newAddedAddress = getRegularCheckoutThreadLocal().addOrEditShippingAddress(inputAddress.get(1),false,true);
            getRegularCheckoutThreadLocal().verifyAndReturnShippingAddressFromAddEditDialogOnAddChangeDialog(newAddedAddress);
        }finally {
            getRegularCheckoutThreadLocal().deleteNewAddedAddressFromUser(null,customerEDP,accessToken);
        }
    }
}
