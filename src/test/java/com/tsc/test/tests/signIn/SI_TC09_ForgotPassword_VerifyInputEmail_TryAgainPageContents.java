package com.tsc.test.tests.signIn;

import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.test.base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class SI_TC09_ForgotPassword_VerifyInputEmail_TryAgainPageContents extends BaseTest{
    /*
     * CER-919
     */
    @Test(groups={"Regression","SignIn"})
    public void SI_TC09_ForgotPassword_VerifyInputEmail_TryAgainPageContents() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        getGlobalLoginPageThreadLocal().goToSignInPage();

        String lsForgotPasswordPageUrl=TestDataHandler.constantData.getLoginUser().getLnkForgotPasswordPage();
        getGlobalLoginPageThreadLocal().goToForgotPasswordPage(lsForgotPasswordPageUrl);

        String lsUrlForSignInFromYml=TestDataHandler.constantData.getLoginUser().getLnkSignInPage();
        getForgotPasswordPageThreadLocal().verifyClickingCancelButtonOnInputEmailPage(lsUrlForSignInFromYml);

        reporter.reportLog("Go To Forgot Password Page");
        getGlobalLoginPageThreadLocal().goToForgotPasswordPage(lsForgotPasswordPageUrl);

        reporter.reportLog("Verify Input Email Page Contents");
        getForgotPasswordPageThreadLocal().verifyInputEmailPageContents();

        reporter.reportLog("Verify Error Messages for Invalid Email Input");
        String expectedErrorMessageForBlankEmailCheckingFromYml=TestDataHandler.constantData.getLoginUser().getLblErrorMessageForBlankEmailCheckingForForgotPassword();
        String expectedErrorMessageForInvalidEmailFormatCheckingFromYml=TestDataHandler.constantData.getLoginUser().getLblErrorMessageForInvalidEmailFormatCheckingForForgotPassword();
        getForgotPasswordPageThreadLocal().verifyInvalidEmailInputErrorMessages(expectedErrorMessageForBlankEmailCheckingFromYml,expectedErrorMessageForInvalidEmailFormatCheckingFromYml);

        reporter.reportLog("Go To TryAgain Page With Not Registered Email");
        getForgotPasswordPageThreadLocal().goToTryAgainPageWithNotRegisteredEmail();

        reporter.reportLog("Verify Input Not Registered Email Page Contents On TryAgain Page");
        getForgotPasswordPageThreadLocal().verifyInputNotRegisteredEmailPageContents();

        reporter.reportLog("Verify Create Account Button Link On TryAgain Page");
        String lsExpectedCreateNewAccountUrlFromYml=TestDataHandler.constantData.getLoginUser().getLnkCreateAccountPage();
        getForgotPasswordPageThreadLocal().verifyCreateAccountButtonLinkOnTryAgainPage(lsExpectedCreateNewAccountUrlFromYml);

        reporter.reportLog("Verify Transfer Phone Account Button Link On TryAgain Page");
        String lsExpectedTransferMyPhoneAccountUrlFromYml=TestDataHandler.constantData.getLoginUser().getLnkTransferPhoneAccountPage();
        getForgotPasswordPageThreadLocal().verifyTransferPhoneAccountButtonLinkOnTryAgainPage(lsExpectedTransferMyPhoneAccountUrlFromYml);

        reporter.reportLog("Verify Clicking TryAgain Button On TryAgain Page");
        getForgotPasswordPageThreadLocal().verifyClickingTryAgainButtonOnTryAgainPage();

    }
}
