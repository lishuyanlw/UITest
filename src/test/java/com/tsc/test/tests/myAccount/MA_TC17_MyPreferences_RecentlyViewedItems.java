package com.tsc.test.tests.myAccount;

import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.pojo.Product;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.ProductDetailPage;
import com.tsc.pages.ProductResultsPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MA_TC17_MyPreferences_RecentlyViewedItems extends BaseTest {
    /*
     *CER-809
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC17_MyPreferences_RecentlyViewedItems() throws IOException, org.json.simple.parser.ParseException {
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

        List<List<String>> lsKeywordDropdownList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        String lnk_URL = TestDataHandler.constantData.getMyAccount().getLnk_myAccountRecentlyViewedURL();
        String expectedURL = basePage.getBaseURL() + lnk_URL;
        if (basePage.URL().equalsIgnoreCase(expectedURL)) {
            reporter.reportLogPass("The navigated URL is equal to expected one:" + expectedURL);
        } else {
            reporter.reportLogPass("The actual navigated URL:+" + basePage.URL() + " is not equal to expected one:" + expectedURL);
        }

        String lsTestDevice = System.getProperty("Device").trim();
        if (!lsTestDevice.equalsIgnoreCase("Mobile")) {
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

        getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "Recently viewed items", getMyAccountPageThreadLocal().lblRecentlyViewedTitle);
        if(getMyAccountPageThreadLocal().checkViewedHistoryExisting()){
            reporter.reportLog("Clear all viewed history");
            getMyAccountPageThreadLocal().clearViewingHistory();

            if(basePage.getReusableActionsInstance().isElementVisible(getMyAccountPageThreadLocal().btnShoppingNow)){
                reporter.reportLogPass("Clearing viewed history successfully");
            }
            else{
                reporter.reportLogFailWithScreenshot("Clearing viewed history failed");
            }
        }

        reporter.reportLog("Add Viewed history item from PRP page");
        Map<String,String> productMap=getProductResultsPageThreadLocal().navigateFromPRPToPDP(lsKeywordDropdownList.get(0).get(0), false);
        getGlobalLoginPageThreadLocal().goToYourProfilePage();
        getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "Recently viewed items", getMyAccountPageThreadLocal().lblRecentlyViewedTitle);
        if(getMyAccountPageThreadLocal().lstRecentlyViewedItemContainerList.size()==1){
            reporter.reportLogPass("Adding viewed item successfully");
        }
        else{
            reporter.reportLogPass("Adding viewed item failed");
        }

        reporter.reportLog("Verify Viewed history page");
        getMyAccountPageThreadLocal().verifyRecentlyViewingHistoryContent(productMap);

    }
}
