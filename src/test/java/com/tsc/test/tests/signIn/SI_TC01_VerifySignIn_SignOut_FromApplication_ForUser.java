package com.tsc.test.tests.signIn;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.GlobalHeaderPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class SI_TC01_VerifySignIn_SignOut_FromApplication_ForUser extends BaseTest {
    /*
     * CER-784
     * CER-794
     * CER-781
     */
    @Test(groups={"SignIn","Regression"})
    public void SI_TC01_VerifySignIn_SignOut_FromApplication_ForUser() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();
        //Fetching test data from test data file
        String lblUserName = TestDataHandler.constantData.getLoginUser().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getLoginUser().getLbl_Password();
        String lblFirstName = TestDataHandler.constantData.getLoginUser().getLbl_FirstName();
        String lblSignOutMessage = TestDataHandler.constantData.getLoginUser().getLbl_SignOutMessage();
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName,lblPassword);

        BasePage basePage=new BasePage(this.getDriver());
        String lsTestDevice = System.getProperty("Device").trim();
        if(lsTestDevice.equalsIgnoreCase("Desktop")) {
            WebElement item=(new GlobalHeaderPage(this.getDriver())).Signinlnk;
            basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            if(item.getText().trim().toUpperCase().contains(lblFirstName.trim().toUpperCase())) {
                reporter.reportLogPass("The SignIn in the header contains SignIn first name");
            }
            else{
                reporter.reportLogFailWithScreenshot("The SignIn in the header does not contain SignIn first name");
            }
        }

        //Assert - user is landed on My Account Page
        getGlobalLoginPageThreadLocal().validateCurrentUrlContains("myaccount");
        String customerNumber = getApiResponseThreadLocal().getUserDetailsFromCustomerEDP(customerEDP,accessToken).getCustomerNo();
        String userCustomerNumber = getGlobalLoginPageThreadLocal().getCustomerNumberForLoggedInUser();
        if(customerNumber.equals(userCustomerNumber))
            getReporter().reportLogPass("User is successfully logged in with customer no: "+userCustomerNumber);
        else
            getReporter().reportLogFailWithScreenshot("User is not logged in with expected customer no: "+userCustomerNumber+" but with other customer no: "+customerNumber);

        //Sign out functionality
        getGlobalLoginPageThreadLocal().SignOut();
        getGlobalLoginPageThreadLocal().validateCurrentUrlContains("signin");
        getGlobalLoginPageThreadLocal().verifySignOutMessage(lblSignOutMessage);
    }
}
