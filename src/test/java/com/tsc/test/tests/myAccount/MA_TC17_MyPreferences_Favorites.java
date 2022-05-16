package com.tsc.test.tests.myAccount;

import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
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
     *CER-799
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC17_MyPreferences_Favorites() throws IOException, org.json.simple.parser.ParseException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage = new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        List<List<String>> lsKeywordDropdownList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        String lsTestDevice = System.getProperty("Device").trim();
        int favoriteItemAmount=getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "Favourites", getMyAccountPageThreadLocal().lblMyFavouritesTitle);
        if(favoriteItemAmount>0){
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
        getMyAccountPageThreadLocal().addFavoriteItemFromPRP(lsKeywordDropdownList.get(0).get(0), getProductResultsPageThreadLocal());
        getGlobalLoginPageThreadLocal().goToYourProfilePage();
        favoriteItemAmount=getMyAccountPageThreadLocal().openSubItemWindow("My Preferences", "Favourites", getMyAccountPageThreadLocal().lblMyFavouritesTitle);

        getMyAccountPageThreadLocal().verifyFavoritePageContent(favoriteItemAmount);

        getMyAccountPageThreadLocal().verifyFavoriteItemOnPDP(getProductDetailPageThreadLocal());


    }
}
