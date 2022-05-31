package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MA_TC19_SignOut_HeaderMenu extends BaseTest {
    /*
     *CER-789
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC19_SignOut_HeaderMenu() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        String lnk_landingViewURL=TestDataHandler.constantData.getMyAccount().getLnk_myAccountLandingViewURL();
        String expectedURL=basePage.getBaseURL()+lnk_landingViewURL;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated URL is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogPass("The actual navigated URL:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
        }

        reporter.reportLog("Verify customer information");
        //Fetching test data from test data file
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());

        String accessToken = apiUserSessionData.get("access_token").toString();
        String customerEDP = apiUserSessionData.get("customerEDP").toString();
        String customerNumber = getApiResponseThreadLocal().getUserDetailsFromCustomerEDP(customerEDP,accessToken).getCustomerNo();
        String userCustomerNumber = getGlobalLoginPageThreadLocal().getCustomerNumberForLoggedInUser();
        if(customerNumber.equals(userCustomerNumber))
            getReporter().reportLogPass("User is successfully logged in with customer no: "+userCustomerNumber);
        else
            getReporter().reportLogFailWithScreenshot("User is not logged in with expected customer no: "+userCustomerNumber+" but with other customer no: "+customerNumber);

        boolean value = getGlobalLoginPageThreadLocal().verifySignOutButtonVisibilityOnPage();
        if(value)
            reporter.reportLogPass("SignOut button is displaying correctly");
        else
            reporter.reportLogFailWithScreenshot("SignOut button is not displaying correctly");

        reporter.reportLog("Verify SignOut");
        getGlobalLoginPageThreadLocal().SignOut();

        String lnk_urlAfterSignOut=TestDataHandler.constantData.getMyAccount().getLnk_URLAfterSignOut();
        expectedURL=basePage.getBaseURL()+lnk_urlAfterSignOut;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated URL after SignOut is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogPass("The actual navigated URL after SignOut:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
        }

        String lblSignOutMessage = TestDataHandler.constantData.getLoginUser().getLbl_SignOutMessage();
        getGlobalLoginPageThreadLocal().verifySignOutMessage(lblSignOutMessage);

        String lsSignInTitle=TestDataHandler.constantData.getLoginUser().getLbl_SignInTitleFromStartPage();
        getGlobalLoginPageThreadLocal().verifySignInTitle(lsSignInTitle);

        getGlobalLoginPageThreadLocal().verifyUserNameAndPassword();

        String lsSignInButton=TestDataHandler.constantData.getLoginUser().getLbl_SignInButtonFromStartPage();
        getGlobalLoginPageThreadLocal().verifyKeepMeSignedInFunction(lsSignInButton);

        getGlobalLoginPageThreadLocal().verifyConfidence();

        getGlobalLoginPageThreadLocal().verifyOtherFieldsForLeftPart();

        String lsSectionTitle=TestDataHandler.constantData.getLoginUser().getLbl_RightSideTitleSignInPage();
        String lsCreateNewAccount=TestDataHandler.constantData.getLoginUser().getLst_RightSideSectionSignInPage().get(0);
        getGlobalLoginPageThreadLocal().verifyNewCustomerSignInRightSideSection(lsSectionTitle,lsCreateNewAccount);

    }
}
