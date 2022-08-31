package com.tsc.test.tests.checkoutPage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
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


public class CP_TC10_Checkout_VerifyShippingAddress_Add_Change extends BaseTest {
    /**
     CER-876 - Checkout - Shipping address - Verify dialog display, list of addresses and other options
    */
    @Test(groups={"Regression","Checkout"})
    public void CP_TC10_Checkout_VerifyShippingAddress_Add_Change() throws IOException, ParseException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        List<String> expectedErrorMessage = TestDataHandler.constantData.getCheckOut().getAddShippingAddressErrorMessage();

        //Fetching test data from test data file
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();

        //Verifying that item exists in cart and if not, create a new cart for user
        List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
        List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,true);

        //Verification that user has ShippingAddress associated and if not, add one to user
        AccountAPI accountAPI = new AccountAPI();
        Response response = accountAPI.getAccountDetailsFromCustomerEDP(customerEDP,accessToken);
        AccountResponse accountResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<AccountResponse>() {});
        List<AccountResponse.AddressClass> getShippingAddressForUser = accountAPI.getShippingAddressForUser(accountResponse,customerEDP,accessToken);

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

        //Verification of Shipping Address display on Checkout Page
        getReporter().reportLog("Verification of Shipping Address display on Checkout Page");
        String shippingAddress = getRegularCheckoutThreadLocal().verifyShippingAddressDisplayOnCheckout();

        //Verification of Add/Change Shipping Address dialog box display on page
        getReporter().reportLog("Verification of Add/Change Shipping Address Dialog Box");
        getRegularCheckoutThreadLocal().openAddOrChangeAddressDialog();
        getRegularCheckoutThreadLocal().verifyAddOrChangeAddressDialogContents();

        //Verification of Add New Shipping Address dialog box display on page
        getReporter().reportLog("Verification of Add New Shipping Address Dialog Box");
        getRegularCheckoutThreadLocal().openAddOrEditAddressDialog(getRegularCheckoutThreadLocal().btnAddOrChangeShippingAddressDialogAddNewAddressButton);
        getRegularCheckoutThreadLocal().verifyAddOrEditAddressDialogContents();

        //Verification of error message on not entering mandatory information in Add New Shipping Address Dialog
        getReporter().reportLog("Verification of error message on not entering mandatory information in Add New Shipping Address Dialog");
        getRegularCheckoutThreadLocal().verifyErrorMessageOnAddNewShippingAddressDialog(expectedErrorMessage);
    }
}
