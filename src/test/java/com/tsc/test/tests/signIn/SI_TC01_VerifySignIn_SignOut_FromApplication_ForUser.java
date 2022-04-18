package com.tsc.test.tests.signIn;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SI_TC01_VerifySignIn_SignOut_FromApplication_ForUser extends BaseTest {
    @Test(groups={"SignIn","Regression"})
    public void SI_TC01_VerifySignIn_SignOut_FromApplication_ForUser() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();
        //Fetching test data from test data file
        String lblUserName = TestDataHandler.constantData.getLoginUser().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getLoginUser().getLbl_Password();
        String lblFirstName = TestDataHandler.constantData.getLoginUser().getLbl_FirstName();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName,lblPassword,lblFirstName);

        //Assert - user is landed on My Account Page
        getGlobalLoginPageThreadLocal().validateCurrentUrlContains("myaccount");

        //Sign out functionality

    }
}
