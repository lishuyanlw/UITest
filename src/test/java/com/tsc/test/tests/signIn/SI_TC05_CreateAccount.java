package com.tsc.test.tests.signIn;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SI_TC05_CreateAccount extends BaseTest {
    /*
     *CER-789
     */
    @Test(groups={"MyAccount","Regression"})
    public void SI_TC05_CreateAccount() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());

        getGlobalLoginPageThreadLocal().goToCreateAccountPageThroughHeader();
        getCreateAccountThreadLocal().verifyContents();
        Map<String,String> createdLoginMap=getCreateAccountThreadLocal().createNewAccount(null,null,true);

        String lblUserName = createdLoginMap.get("email");
        String lblPassword = createdLoginMap.get("password");

        boolean bSignIn=getGlobalLoginPageThreadLocal().checkSignInStatus();
        if(bSignIn){
            reporter.reportLogPass("Login successfully with newly created email:"+lblUserName+" and password:"+lblPassword);
        }
        else{
            reporter.reportLogFailWithScreenshot("Login failed with newly created email:"+lblUserName+" and password:"+lblPassword);
        }

    }
}
