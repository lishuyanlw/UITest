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

public class CP_TC10_VerifyPaymentMethod_Add_Update_Remove extends BaseTest {
    /**
     CER-882 - Checkout - Payment Method - Add new/change payment method, required message, fields display, Remove Card
     */
    @Test(groups={"Regression","Checkout"})
    public void CP_TC10_VerifyPaymentMethod_Add_Update_Remove() throws IOException, ParseException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //Fetching test data from test data file
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();
        String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        try{
            //Emptying Cart for test to run with right state
            getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);

            //Verifying that item exists in cart and if not, create a new cart for user
            List<Map<String, String>> keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
            getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,true);

            //Setting up initial test environment by deleting all cards associated with user and cart
            CartAPI cartAPI = new CartAPI();
            Response response = cartAPI.getAccountCartContentWithCustomerEDP(customerEDP,accessToken);
            CartResponse cartResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
            getRegularCheckoutThreadLocal().deleteCreditCardForUserAndFromCart(cartResponse,customerEDP,accessToken);

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



        }finally{
            //Emptying Cart for test to run with right state
            getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);
        }
    }
}
