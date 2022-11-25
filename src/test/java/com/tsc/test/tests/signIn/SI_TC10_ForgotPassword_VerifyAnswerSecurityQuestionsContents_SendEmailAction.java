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

public class SI_TC10_ForgotPassword_VerifyAnswerSecurityQuestionsContents_SendEmailAction extends BaseTest{
    /*
     * CER-923
     */
    @Test(groups={"Regression","SignIn","ForgotPassword"})
    public void SI_TC10_ForgotPassword_VerifyAnswerSecurityQuestionsContents_SendEmailAction() throws IOException {
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
        getForgotPasswordPageThreadLocal().changeUserSecurityQuestion(customerEDP,accessToken);

        reporter.reportLog("Go To Forgot Password Page");
        getGlobalLoginPageThreadLocal().goToSignInPage();
        getGlobalLoginPageThreadLocal().goToForgotPasswordPage(null);

        reporter.reportLog("Go To Answer Security Questions Page With Registered Email");
        getForgotPasswordPageThreadLocal().goToAnswerSecurityQuestionsPageWithRegisteredEmail(email);

        reporter.reportLog("Verify Security Questions And Reset By Email Contents By Input Registered Email");
        getForgotPasswordPageThreadLocal().verifySecurityQuestionsAndResetByEmailContentsByInputRegisteredEmail();

        reporter.reportLog("Verify Error Messages For Blank Answers For Security Questions");
        List<String> lstErrorMessageFromYmlForBlankInput= TestDataHandler.constantData.getLoginUser().getLstErrorMessageForAnswerSecurityQuestionsForForgotPassword();
        getForgotPasswordPageThreadLocal().verifyErrorMessagesForBlankAnswersForSecurityQuestions(lstErrorMessageFromYmlForBlankInput);

        reporter.reportLog("Verify Error Messages For Invalid Answers For Security Questions");
        String lsErrorMessageFromYmlForInvalidSecurityQuestionAnswer= TestDataHandler.constantData.getLoginUser().getLblErrorMessageForInvalidSecurityQuestionAnswerForForgotPassword();
        getForgotPasswordPageThreadLocal().verifyErrorMessagesForInvalidAnswersForSecurityQuestions(phoneNumber,postalCode,lsErrorMessageFromYmlForInvalidSecurityQuestionAnswer);

        reporter.reportLog("Verify Clicking Cancel Button On Answer Security Question Page");
        String lsExpectedUrlFromYmlForSignInPage=TestDataHandler.constantData.getLoginUser().getLnkSignInPage();
        getForgotPasswordPageThreadLocal().verifyClickingCancelButtonOnAnswerSecurityQuestionPage(lsExpectedUrlFromYmlForSignInPage);

        reporter.reportLog("Go back To Forgot Password Page");
        getGlobalLoginPageThreadLocal().goToForgotPasswordPage(null);

        reporter.reportLog("Go back To Answer Security Questions Page With Registered Email");
        getForgotPasswordPageThreadLocal().goToAnswerSecurityQuestionsPageWithRegisteredEmail(email);

        reporter.reportLog("Go To Send Email Page");
        getForgotPasswordPageThreadLocal().goToSendEmailPage();

        reporter.reportLog("Verify Sent Email Page Contents");
        getForgotPasswordPageThreadLocal().verifySentEmailPageContents();

    }
}
