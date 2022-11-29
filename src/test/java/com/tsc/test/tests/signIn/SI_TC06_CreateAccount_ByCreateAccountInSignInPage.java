package com.tsc.test.tests.signIn;

import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.util.Map;

public class SI_TC06_CreateAccount_ByCreateAccountInSignInPage extends BaseTest {
    /*
     * CER-914
     */
    @Test(groups={"SignIn","Regression","CreateAccount"})
    public void SI_TC06_CreateAccount_ByCreateAccountInSignInPage() {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());

        getGlobalLoginPageThreadLocal().goToCreateAccountPageThroughSignInPage();

        reporter.reportLog("Verify create an new account with a valid email");
        Map<String,String> createdLoginMap=getCreateAccountThreadLocal().createNewAccount(null,null,true,false);
        String lblUserName = createdLoginMap.get("email");
        String lblPassword = createdLoginMap.get("password");
        String firstName = createdLoginMap.get("firstName");

        reporter.reportLog("Login with newly created email:"+lblUserName+" and password:"+lblPassword);
        boolean bSignIn=getGlobalLoginPageThreadLocal().checkSignInStatus();
        if(bSignIn){
            reporter.reportLogPass("Login successfully with newly created email:"+lblUserName+" and password:"+lblPassword);
        }
        else{
            reporter.reportLogFailWithScreenshot("Login failed with newly created email:"+lblUserName+" and password:"+lblPassword);
        }

        String firstNameOnMyAccountPage=getMyAccountPageThreadLocal().getFirstNameInHeader();
        if(firstName.equalsIgnoreCase(firstNameOnMyAccountPage)){
            reporter.reportLogPass("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is the same as the expected:"+firstName+" for creating new account");
        }
        else{
            reporter.reportLogFail("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is not the same as the expected:"+firstName+" for creating new account");
        }

    }
}
