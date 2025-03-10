package com.tsc.test.tests.myAccount;

import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MA_TC18_MyPreferences_MyNewsletters extends BaseTest {
    /*
     * CER-810
     * CER-884
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC18_MyPreferences_MyNewsletters() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage = new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        //Fetching test data from test data file
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());
        String accessToken = apiUserSessionData.get("access_token").toString();
        String customerEDP = apiUserSessionData.get("customerEDP").toString();
        AccountAPI accountAPI=new AccountAPI();
        AccountResponse accountResponse=getApiResponseThreadLocal().getUserDetailsFromCustomerEDP(customerEDP,accessToken);

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        String lsTestDevice = System.getProperty("Device").trim();
        String lsTestBrowser= System.getProperty("Browser").toLowerCase().trim();
        if((lsTestDevice.equalsIgnoreCase("Desktop"))||(lsTestDevice.equalsIgnoreCase("Tablet")&&lsTestBrowser.contains("ios"))){
            reporter.reportLog("Verify customer information");
            String customerNumber = accountResponse.getCustomerNo();
            String userCustomerNumber = getGlobalLoginPageThreadLocal().getCustomerNumberForLoggedInUser();
            if (customerNumber.equals(userCustomerNumber))
                getReporter().reportLogPass("User is successfully logged in with customer no: " + userCustomerNumber);
            else
                getReporter().reportLogFailWithScreenshot("User is not logged in with expected customer no: " + userCustomerNumber + " but with other customer no: " + customerNumber);

            if (basePage.getReusableActionsInstance().isElementVisible(getGlobalLoginPageThreadLocal().btnSignOut)) {
                reporter.reportLogPass("SignOut button is displaying correctly");
            }
            else {
                reporter.reportLogFailWithScreenshot("SignOut button is not displaying correctly");
            }
        }

        getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "My Newsletters", null);

        String lnk_URL = TestDataHandler.constantData.getMyAccount().getLnk_myAccountNewsLetterURL();
        String expectedURL = basePage.getBaseURL() + lnk_URL;
        if (basePage.URL().equalsIgnoreCase(expectedURL)) {
            reporter.reportLogPass("The navigated URL is equal to expected one:" + expectedURL);
        } else {
            reporter.reportLogFailWithScreenshot("The actual navigated URL:" + basePage.URL() + " is not equal to expected one:" + expectedURL);
        }

        if(lsTestBrowser.contains("ios")){
            reporter.reportLog("Test stops due to cross-origin frame issue for IOS device");
            return;
        }

        getMyAccountPageThreadLocal().getIntoMyNewsLettersIFrame();

        reporter.reportLog("Verify My NewsLetter Content");
        getMyAccountPageThreadLocal().verifyMyNewsLetterContent();

        reporter.reportLog("Verify Subscribe Messages");
        String  lsMyNewsLettersUpdateErrorMessage=TestDataHandler.constantData.getMyAccount().getLbl_myNewsLettersUpdateErrorMessage();
        String  lsMyNewsLettersUpdateAlertMessage=TestDataHandler.constantData.getMyAccount().getLbl_myNewsLettersUpdateAlertMessage();
        getMyAccountPageThreadLocal().verifySubscribeMessage(lsMyNewsLettersUpdateAlertMessage,lsMyNewsLettersUpdateErrorMessage);

        reporter.reportLog("Verify UnSubscribe Messages");
        String  lsMyNewsLettersUnSubscribeErrorMessage=TestDataHandler.constantData.getMyAccount().getLbl_myNewsLettersUnSubscribeErrorMessage();
        String  lsMyNewsLettersUnSubscribeAlertMessage=TestDataHandler.constantData.getMyAccount().getLbl_myNewsLettersUnSubscribeAlertMessage();
        getMyAccountPageThreadLocal().verifyUnSubscribeMessage(lsMyNewsLettersUnSubscribeAlertMessage,lsMyNewsLettersUnSubscribeErrorMessage);

        getMyAccountPageThreadLocal().getOutMyNewsLettersIFrame();

        String lsExpectedSubscriptionSuccessMessage=TestDataHandler.constantData.getMyAccount().getLbl_myNewsLettersSubscriptionSuccessMessage();
        reporter.reportLog("Check Today Show Stopper NewsLetter subscription");
        getMyAccountPageThreadLocal().verifyNewsLettersChangingSubscriptionSuccessMessage(getMyAccountPageThreadLocal().ckbMyNewsLettersTodayShowStopperNewsLetter,true,lsExpectedSubscriptionSuccessMessage);
        basePage.navigateBack();
        getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "My Newsletters", null);

        reporter.reportLog("Check Special Offer And Event NewsLetter subscription");
        getMyAccountPageThreadLocal().verifyNewsLettersChangingSubscriptionSuccessMessage(getMyAccountPageThreadLocal().ckbMyNewsLettersSpecialOfferAndEventNewsLetter,true,lsExpectedSubscriptionSuccessMessage);
        basePage.navigateBack();
        getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "My Newsletters", null);

        reporter.reportLog("Check Preferred Customer Offer subscription");
        getMyAccountPageThreadLocal().verifyNewsLettersChangingSubscriptionSuccessMessage(getMyAccountPageThreadLocal().ckbMyNewsLettersPreferredCustomerOffer,true,lsExpectedSubscriptionSuccessMessage);
        basePage.navigateBack();
        getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "My Newsletters", null);

        reporter.reportLog("Check Product Updates And Alerts subscription");
        getMyAccountPageThreadLocal().verifyNewsLettersChangingSubscriptionSuccessMessage(getMyAccountPageThreadLocal().ckbMyNewsLettersProductUpdatesAndAlerts,true,lsExpectedSubscriptionSuccessMessage);
        basePage.navigateBack();
        getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "My Newsletters", null);

        reporter.reportLog("Check Product UnSubscription");
        getMyAccountPageThreadLocal().verifyNewsLettersUnSubscriptionSuccessMessage(lsExpectedSubscriptionSuccessMessage);

    }
}
