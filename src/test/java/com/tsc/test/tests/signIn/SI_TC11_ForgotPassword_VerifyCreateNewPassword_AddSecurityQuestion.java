package com.tsc.test.tests.signIn;

import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.test.base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SI_TC11_ForgotPassword_VerifyCreateNewPassword_AddSecurityQuestion extends BaseTest{
    /*
     * CER-924
     */
    @Test(groups={"Regression","SignIn"})
    public void SI_TC11_ForgotPassword_VerifyCreateNewPassword_AddSecurityQuestion() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //Fetching test data from test data file
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());
        String accessToken = apiUserSessionData.get("access_token").toString();

        AccountResponse accountResponse=getCreateAccountThreadLocal().getNewUserAccountDetails(accessToken);
        String phoneNumber= accountResponse.getBillingAddress().getDayPhone();
        String postalCode=accountResponse.getBillingAddress().getZipCode();
        String email= accountResponse.getEmail();
        String customerNumber= accountResponse.getCustomerNo();
        String firstName=accountResponse.getBillingAddress().getFirstName();
        JSONObject requestParams= DataConverter.readJsonFileIntoJSONObject("test-data/NewUser.json");
        String password= (String) requestParams.get("Password");

        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(email,password,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());
        accessToken = apiUserSessionData.get("access_token").toString();
        String customerEDP = apiUserSessionData.get("customerEDP").toString();
        Map<String,Object> presetSecurityQuestionMap=getForgotPasswordPageThreadLocal().changeUserSecurityQuestion(customerEDP,accessToken);
        String presetSecurityQuestionAnswer= (String) presetSecurityQuestionMap.get("Answer");

        reporter.reportLog("Go To Forgot Password Page");
        getGlobalLoginPageThreadLocal().goToSignInPage();
        getGlobalLoginPageThreadLocal().goToForgotPasswordPage(null);

        reporter.reportLog("Go To Answer Security Questions Page With Registered Email");
        getForgotPasswordPageThreadLocal().goToAnswerSecurityQuestionsPageWithRegisteredEmail(email);

        reporter.reportLog("Go To Rest Password Page");
        getForgotPasswordPageThreadLocal().fillAnswerSecurityQuestionsForm(phoneNumber,postalCode,presetSecurityQuestionAnswer);
        getForgotPasswordPageThreadLocal().goToRestPasswordPage();

        reporter.reportLog("Verify Create New Password Page Contents");
        getForgotPasswordPageThreadLocal().verifyCreateNewPasswordPageContents();

        reporter.reportLog("Verify Show Or Hide Password Function");
        getForgotPasswordPageThreadLocal().verifyShowOrHidePasswordFunction();

        reporter.reportLog("Verify Error Messages For Blank Password Input");
        List<String> lstErrorMessageFromYmlForBlankPassword=TestDataHandler.constantData.getLoginUser().getLstErrorMessageForResetPasswordForForgotPassword();
        getForgotPasswordPageThreadLocal().verifyErrorMessagesForBlankPasswordInput(lstErrorMessageFromYmlForBlankPassword);

        reporter.reportLog("Verify Error Messages For Not Matched Passwords Input");
        String lsErrorMessageFromYmlForNotMatchedPassword=TestDataHandler.constantData.getLoginUser().getLblErrorMessageForPasswordsNotMatchForForgotPassword();
        getForgotPasswordPageThreadLocal().verifyErrorMessageForNotMatchedPasswordsInput(lsErrorMessageFromYmlForNotMatchedPassword);

        reporter.reportLog("Go To Add Security Question For New Password Page");
        String newPassword="qa123456";
        getForgotPasswordPageThreadLocal().fillNewPasswordForm(newPassword);
        getForgotPasswordPageThreadLocal().goToAddSecurityQuestionForNewPasswordPage();

        reporter.reportLog("Verify Add Security Question Page Contents");
        getForgotPasswordPageThreadLocal().verifyAddSecurityQuestionPageContents();

        reporter.reportLog("Verify Show Or Hide Security Question Answer Function");
        getForgotPasswordPageThreadLocal().verifyShowOrHideSecurityQuestionAnswerFunction();

        String newSecurityQuestionAnswer="1234";
        getForgotPasswordPageThreadLocal().fillAddSecurityQuestionForm(newSecurityQuestionAnswer);
        getForgotPasswordPageThreadLocal().clickingSaveButtonOnAddSecurityQuestionPage();

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

        reporter.reportLog("SignOut and SignIn again with email:"+email);
        getGlobalLoginPageThreadLocal().signOut();
        getGlobalLoginPageThreadLocal().Login(email,newPassword);
        customerNumberOnMyAccountPage=getMyAccountPageThreadLocal().getCustomerNumberInHeader();
        if(customerNumber.equalsIgnoreCase(customerNumberOnMyAccountPage)){
            reporter.reportLogPass("The customer number:"+customerNumberOnMyAccountPage+" on MyAccount page is the same as the expected:"+customerNumber+" from API created account");
        }
        else{
            reporter.reportLogFail("The customer number:"+customerNumberOnMyAccountPage+" on MyAccount page is not the same as the expected:"+customerNumber+" from API created account");
        }

        firstNameOnMyAccountPage=getMyAccountPageThreadLocal().getFirstNameInHeader();
        if(firstName.equalsIgnoreCase(firstNameOnMyAccountPage)){
            reporter.reportLogPass("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is the same as the expected:"+firstName+" from API created account");
        }
        else{
            reporter.reportLogFail("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is not the same as the expected:"+firstName+" from API created account");
        }
    }
}
