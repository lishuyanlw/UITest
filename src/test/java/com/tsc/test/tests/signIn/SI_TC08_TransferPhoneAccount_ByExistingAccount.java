package com.tsc.test.tests.signIn;

import com.tsc.api.pojo.AccountResponse;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SI_TC08_TransferPhoneAccount_ByExistingAccount extends BaseTest{
    /*
     * CER-917
     */
    @Test(groups={"Regression","SignIn","CreateAccount"})
    public void SI_TC08_TransferPhoneAccount_ByExistingAccount() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //Fetching test data from test data file
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());
        String accessToken = apiUserSessionData.get("access_token").toString();

        AccountResponse accountResponse=getCreateAccountThreadLocal().getNewUserAccountDetails(accessToken);
        String phoneNumber= accountResponse.getBillingAddress().getDayPhone();;
        String email= accountResponse.getEmail();
        String customerNumber= accountResponse.getCustomerNo();
        String firstName=accountResponse.getBillingAddress().getFirstName();

        reporter.reportLog("Go To Transfer Phone Account Page Through SignIn Page");
        getGlobalLoginPageThreadLocal().goToTransferPhoneAccountPageThroughSignInPage();

        reporter.reportLog("Verify Form Contents");
        getTransferPhoneAccountThreadLocal().verifyFormContents();

        reporter.reportLog("Verify Show Or Hide Password Function");
        getTransferPhoneAccountThreadLocal().verifyShowOrHidePasswordFunction();

        reporter.reportLog("Verify Forgot Customer Part Contents");
        getTransferPhoneAccountThreadLocal().verifyForgotCustomerPartContents();

        reporter.reportLog("Verify error messages");
        List<String> lstErrorMessage=TestDataHandler.constantData.getLoginUser().getLstErrorMessageForTransferPhoneAccount();
        getTransferPhoneAccountThreadLocal().verifyErrorMessages(lstErrorMessage);

        getTransferPhoneAccountThreadLocal().createNewAccount(customerNumber,phoneNumber,email,"qa1234",true,true);

        reporter.reportLog("Login with newly created email: "+email+" and password: qa1234");
        boolean bSignIn=getGlobalLoginPageThreadLocal().checkSignInStatus();
        if(bSignIn){
            reporter.reportLogPass("Login successfully with newly created email: "+email+" and password: qa1234");
        }
        else{
            reporter.reportLogFailWithScreenshot("Login failed with newly created email: "+email+" and password: qa1234");
        }

        String customerNumberOnMyAccountPage=getMyAccountPageThreadLocal().getCustomerNumberInHeader();
        if(customerNumber.equalsIgnoreCase(customerNumberOnMyAccountPage)){
            reporter.reportLogPass("The customer number:"+customerNumberOnMyAccountPage+" on MyAccount page is the same as the expected:"+customerNumber+" from API created account");
        }
        else{
            reporter.reportLogFail("The customer number:"+customerNumberOnMyAccountPage+" on MyAccount page is not the same as the expected:"+customerNumber+" from API created account");
        }

        String firstNameOnMyAccountPage=getMyAccountPageThreadLocal().getFirstNameInHeader();
        if(firstName.equalsIgnoreCase(firstNameOnMyAccountPage)){
            reporter.reportLogPass("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is the same as the expected:"+firstName+" from API created account");
        }
        else{
            reporter.reportLogFail("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is not the same as the expected:"+firstName+" from API created account");
        }

    }
}
