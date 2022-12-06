package com.tsc.test.tests.signIn;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class SI_TC05_CreateAccount_VerifyContents_ByCreateAccountInSignInMenuOnHeader extends BaseTest {
    /*
     * CER-914
     */
    @Test(groups={"SignIn","Regression","CreateAccount"})
    public void SI_TC05_CreateAccount_ByCreateAccountInSignInMenuOnHeader() {
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

        Map<String,String> createdLoginMap;
        try{
            createdLoginMap=getCreateAccountThreadLocal().createNewAccount(lblUserNameForExistingEmail,lblPasswordForExistingEmail,true,true);
        }
        catch(Exception ex){
            try{
                createdLoginMap=getCreateAccountThreadLocal().createNewAccount(lblUserNameForExistingEmail,lblPasswordForExistingEmail,true,true);
            }
            catch(Exception ex1){
                createdLoginMap=getCreateAccountThreadLocal().createNewAccount(lblUserNameForExistingEmail,lblPasswordForExistingEmail,true,true);
            }
        }

        String lsErrorMessageForExistingEmail=createdLoginMap.get("errorMessage");
        if(lsErrorMessageForExistingEmail.equalsIgnoreCase(lsErrorMessageForExistingEmailFromYml)){
            reporter.reportLogPass("The error message:'"+lsErrorMessageForExistingEmail+"' for existing email is the same as expected:'"+lsErrorMessageForExistingEmailFromYml+"'");
        }
        else{
            reporter.reportLogFail("The error message:'"+lsErrorMessageForExistingEmail+"' for existing email is not the same as expected:'"+lsErrorMessageForExistingEmailFromYml+"'");
        }

        reporter.reportLog("Verify create an new account and clicking cancel button");
        getCreateAccountThreadLocal().createNewAccount(null,null,false,false);
        String lsSignInUrlFromYml=basePage.getBaseURL()+TestDataHandler.constantData.getLoginUser().getLnkSignInPage();
        String currentUrl=basePage.URL();
        if(currentUrl.equalsIgnoreCase(lsSignInUrlFromYml)){
            reporter.reportLogPass("The navigated Url:'"+currentUrl+"' after clicking cancel button is the same as the expected:'"+lsSignInUrlFromYml+"'");
        }
        else{
            reporter.reportLogFail("The navigated Url:'"+currentUrl+"' after clicking cancel button is not the same as the expected:'"+lsSignInUrlFromYml+"'");
        }
    }
}
