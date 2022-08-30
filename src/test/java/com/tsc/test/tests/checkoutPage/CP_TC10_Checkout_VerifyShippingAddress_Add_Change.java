package com.tsc.test.tests.checkoutPage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class CP_TC10_Checkout_VerifyShippingAddress_Add_Change extends BaseTest {
    /**
     CER-876 - Checkout - Shipping address - Verify dialog display, list of addresses and other options
    */
    @Test(groups={"Regression","Checkout"})
    public void CP_TC10_Checkout_VerifyShippingAddress_Add_Change() throws IOException, ParseException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        //Fetching test data from test data file
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();

        //Verification that user has ShippingAddress associated and if not, add one to user
        AccountAPI accountAPI = new AccountAPI();
        Response response = accountAPI.getAccountDetailsFromCustomerEDP(customerEDP,accessToken);
        AccountResponse accountResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<AccountResponse>() {});
        List<AccountResponse.AddressClass> getShippingAddressForUser = accountAPI.getShippingAddressForUser(accountResponse,customerEDP,accessToken);
    }
}
