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


public class CP_TC08_VerifyBillingAddress extends BaseTest {
    /**
     * CER-885
    */
    @Test(groups={"Regression","Checkout"})
    public void CP_TC08_VerifyBillingAddress() throws IOException, ParseException {
        getGlobalFooterPageThreadLocal().closePopupDialog();
        Map<String,Object> newAddedAddress = null;

        //Fetching Data from test data yaml file
        String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        List<String> expectedErrorMessage = TestDataHandler.constantData.getCheckOut().getAddShippingAddressErrorMessage();
        List<Map<String,String>> inputAddress = TestDataHandler.constantData.getCheckOut().getNewShippingAddressForUser();
        String billingAddress = TestDataHandler.constantData.getCheckOut().getLblBillingAddress();
        String existingAddressErrorMessage = TestDataHandler.constantData.getCheckOut().getLblExistingAddressErrorMessage();
        boolean addressFlagForEnvironmentCleanUp = false;

        //Fetching test data from test data file
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();

        //Emptying Cart for test to run with right state
        getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);

        //Verifying that item exists in cart and if not, create a new cart for user
        List<Map<String, String>> keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
        getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,true);

        //Verification that user has ShippingAddress associated and if not, add one to user
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

        getRegularCheckoutThreadLocal().openChangeBillingAddressDialog();
        reporter.reportLog("verify changing Billing address dialog Contents");
        getRegularCheckoutThreadLocal().verifyAddOrEditAddressDialogContents();


        getRegularCheckoutThreadLocal().closeChangeBillingAddressDialog(false);

    }
}
