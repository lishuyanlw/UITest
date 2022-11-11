package com.tsc.test.tests.signIn;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SI_TC05_CreateAccount_ByCreateAccountInSignInMenuOnHeader extends BaseTest {
    /*
     * CER-914
     */
    @Test(groups={"SignIn","Regression"})
    public void SI_TC05_CreateAccount_ByCreateAccountInSignInMenuOnHeader() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());

        getGlobalLoginPageThreadLocal().goToCreateAccountPageThroughHeader();

        reporter.reportLog("Verify contents");
        getCreateAccountThreadLocal().verifyContents();

        reporter.reportLog("Verify show or hide password function");
        getCreateAccountThreadLocal().verifyShowOrHidePasswordFunction();

        reporter.reportLog("Verify error messages");
        List<String> lstErrorMessage=TestDataHandler.constantData.getLoginUser().getLstErrorMessageForCreateAccount();
        getCreateAccountThreadLocal().verifyErrorMessages(lstErrorMessage);

        reporter.reportLog("Verify create account with an existing email error message");
        String lblUserNameForExistingEmail = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPasswordForExistingEmail = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        String lsErrorMessageForExistingEmailFromYml=TestDataHandler.constantData.getLoginUser().getLblErrorMessageForExistingEmail();
        lsErrorMessageForExistingEmailFromYml=lsErrorMessageForExistingEmailFromYml.replace("<email>",lblUserNameForExistingEmail);
        Map<String,String> createdLoginMap=getCreateAccountThreadLocal().createNewAccount(lblUserNameForExistingEmail,lblPasswordForExistingEmail,true,true);
        String lsErrorMessageForExistingEmail=createdLoginMap.get("errorMessage");
        if(lsErrorMessageForExistingEmail.equalsIgnoreCase(lsErrorMessageForExistingEmailFromYml)){
            reporter.reportLogPass("The error message:'"+lsErrorMessageForExistingEmail+"' for existing email is the same as expected:'"+lsErrorMessageForExistingEmailFromYml+"'");
        }
        else{
            reporter.reportLogFail("The error message:'"+lsErrorMessageForExistingEmail+"' for existing email is not the same as expected:'"+lsErrorMessageForExistingEmailFromYml+"'");
        }

        reporter.reportLog("Verify create an new account with a valid email");
        createdLoginMap=getCreateAccountThreadLocal().createNewAccount(null,null,true,false);
        String lblUserName = createdLoginMap.get("email");
        String lblPassword = createdLoginMap.get("password");
        reporter.reportLog("Login with newly created email:"+lblUserName+" and password:"+lblPassword);
        boolean bSignIn=getGlobalLoginPageThreadLocal().checkSignInStatus();
        if(bSignIn){
            reporter.reportLogPass("Login successfully with newly created email:"+lblUserName+" and password:"+lblPassword);
        }
        else{
            reporter.reportLogFailWithScreenshot("Login failed with newly created email:"+lblUserName+" and password:"+lblPassword);
        }

    }
}
