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
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        String lblSignOutMessage = TestDataHandler.constantData.getLoginUser().getLbl_SignOutMessage();
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();

        reporter.reportLog("Go to SignIn page");
        getGlobalLoginPageThreadLocal().goToSignInPage();
        String lsSignInTitle=TestDataHandler.constantData.getLoginUser().getLbl_SignInTitleFromStartPage();
        String lsSignInFromStartPage=TestDataHandler.constantData.getLoginUser().getLbl_SignInButtonFromStartPage();

        getGlobalLoginPageThreadLocal().verifySignInTitle(lsSignInTitle);
        getGlobalLoginPageThreadLocal().verifyUserNameAndPassword();
        getGlobalLoginPageThreadLocal().verifyKeepMeSignedInFunction(lsSignInFromStartPage);
        getGlobalLoginPageThreadLocal().verifyConfidence();
        getGlobalLoginPageThreadLocal().verifyOtherFieldsForLeftPart();

        String lsSectionTitle=TestDataHandler.constantData.getLoginUser().getLbl_RightSideTitleSignInPage();
        String lsAsAnGuest=TestDataHandler.constantData.getLoginUser().getLst_RightSideSectionSignInPage().get(0);
        getGlobalLoginPageThreadLocal().verifyNewCustomerSignInRightSideSection(lsSectionTitle,lsAsAnGuest);

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().LoginWithoutWaitingTime(lblUserName,lblPassword);
        BasePage basePage=new BasePage(this.getDriver());
        basePage.waitForCondition(Driver->{return getGlobalLoginPageThreadLocal().lblSignInGlobalResponseBanner.isDisplayed();},300000);

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
