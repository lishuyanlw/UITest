package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.GlobalHeaderPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class MA_TC12_SignOut_HeaderMenu extends BaseTest {
    /*
     *CER-789
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC12_SignOut_HeaderMenu() throws ParseException, IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getMyAccount().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getMyAccount().getLbl_Password();
        String lblFirstName = TestDataHandler.constantData.getMyAccount().getLbl_FirstName();
        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

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

        String lnk_landingViewURL=TestDataHandler.constantData.getMyAccount().getLnk_myAccountLandingViewURL();
        String expectedURL=basePage.getBaseURL()+lnk_landingViewURL;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated URL is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogPass("The actual navigated URL:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
        }

        if(!lsTestDevice.equalsIgnoreCase("Mobile")){
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

            basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getGlobalLoginPageThreadLocal().lblSignInPageTitle);
            String lsSignInPageTitle=getGlobalLoginPageThreadLocal().lblSignInPageTitle.getText();
            if(lsSignInPageTitle.toUpperCase().contains(lblFirstName.toUpperCase())){
                reporter.reportLogPass("The Title contains SignIn user's name");
            }
            else{
                reporter.reportLogFailWithScreenshot("The Title does not contain SignIn user's name");
            }

            if(basePage.getReusableActionsInstance().isElementVisible(getGlobalLoginPageThreadLocal().btnSignOut)){
                reporter.reportLogPass("SignOut button is displaying correctly");
            }
            else{
                reporter.reportLogFailWithScreenshot("SignOut button is not displaying correctly");
            }
        }

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

    }
}
