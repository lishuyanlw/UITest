package com.tsc.test.tests.myAccount;

import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.pojo.Product;
import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.GlobalHeaderPage;
import com.tsc.pages.ProductDetailPage;
import com.tsc.pages.ProductResultsPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MA_TC17_MyPreferences_Favorites extends BaseTest {
    /*
     *CER-808
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC17_MyPreferences_Favorites() throws IOException, org.json.simple.parser.ParseException {
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

        String lnk_URL = TestDataHandler.constantData.getMyAccount().getLnk_myAccountFavouritesURL();
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

        int favoriteItemAmount=getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "Favourites", getMyAccountPageThreadLocal().lblMyFavouritesTitle);
        if(favoriteItemAmount>0){
            reporter.reportLog("Clear all favorite history");
            getMyAccountPageThreadLocal().clearFavoriteHistory(false);
            if(getMyAccountPageThreadLocal().lstNoHistoryMessage.size()>0){
                reporter.reportLogPass("No history messages are displaying correctly");
            }
            else{
                reporter.reportLogFailWithScreenshot("No history messages are not displaying correctly");
            }

            if(basePage.getReusableActionsInstance().isElementVisible(getMyAccountPageThreadLocal().btnShoppingNow)){
                reporter.reportLogPass("Shopping Now button are displaying correctly");
            }
            else{
                reporter.reportLogFailWithScreenshot("Shopping Now button are not displaying correctly");
            }
        }

        reporter.reportLog("Add favorite item from PRP page");
        Map<String,String> map=getMyAccountPageThreadLocal().addFavoriteItemFromPRP(lsKeywordDropdownList.get(0).get(0), getProductResultsPageThreadLocal());
        getGlobalLoginPageThreadLocal().goToYourProfilePage();
        favoriteItemAmount=getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "Favourites", getMyAccountPageThreadLocal().lblMyFavouritesTitle);

        reporter.reportLog("Verify favorite item content");
        getMyAccountPageThreadLocal().verifyFavoritePageContent(map,favoriteItemAmount);

        reporter.reportLog("Verify favorite item on PDP page");
        getMyAccountPageThreadLocal().verifyFavoriteItemOnPDP(getProductDetailPageThreadLocal());

        reporter.reportLog("Cancel favorite item on PDP page");
        String lsProductName=getMyAccountPageThreadLocal().cancelFavoriteItemOnPDP(getProductDetailPageThreadLocal());

        reporter.reportLog("Verify PRP Favorite Icon After Cancel Action From PDP");
        getMyAccountPageThreadLocal().verifyPRPFavoriteIconAfterCancelActionFromPDP(lsProductName,getProductResultsPageThreadLocal());

        reporter.reportLog("Verify favorite page after cancel action");
        getGlobalLoginPageThreadLocal().goToYourProfilePage();
        favoriteItemAmount=getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "Favourites", getMyAccountPageThreadLocal().lblMyFavouritesTitle);
        if(favoriteItemAmount==0){
            reporter.reportLogPass("The favorite item amount is equal to 0");
        }
        else{
            reporter.reportLogPass("The favorite item amount is equal to 0");
        }
        if(getMyAccountPageThreadLocal().lstNoHistoryMessage.size()>0){
            reporter.reportLogPass("No history messages are displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("No history messages are not displaying correctly");
        }

        if(basePage.getReusableActionsInstance().isElementVisible(getMyAccountPageThreadLocal().btnShoppingNow)){
            reporter.reportLogPass("Shopping Now button are displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("Shopping Now button are not displaying correctly");
        }

        reporter.reportLog("Verify clear favorite history action");
        getMyAccountPageThreadLocal().addFavoriteItemFromPRP(lsKeywordDropdownList.get(0).get(0), getProductResultsPageThreadLocal());
        getGlobalLoginPageThreadLocal().goToYourProfilePage();
        favoriteItemAmount=getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "Favourites", getMyAccountPageThreadLocal().lblMyFavouritesTitle);
        if(favoriteItemAmount>0){
            reporter.reportLog("Clear all favorite history");
            getMyAccountPageThreadLocal().clearFavoriteHistory(false);
            if(getMyAccountPageThreadLocal().lstNoHistoryMessage.size()>0){
                reporter.reportLogPass("No history messages are displaying correctly");
            }
            else{
                reporter.reportLogFailWithScreenshot("No history messages are not displaying correctly");
            }

            if(basePage.getReusableActionsInstance().isElementVisible(getMyAccountPageThreadLocal().btnShoppingNow)){
                reporter.reportLogPass("Shopping Now button are displaying correctly");
            }
            else{
                reporter.reportLogFailWithScreenshot("Shopping Now button are not displaying correctly");
            }
        }
        else{
            reporter.reportLogPassWithScreenshot("Add favorite action failed");
        }

    }
}
