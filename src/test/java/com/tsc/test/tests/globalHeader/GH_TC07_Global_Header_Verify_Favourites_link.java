package com.tsc.test.tests.globalHeader;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC07_Global_Header_Verify_Favourites_link extends BaseTest {
	
	@Test(groups={"SauceTunnelTest","Regression"})
	public void GH_TC07_Global_Header_Verify_Favourites_link() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());
		String lsBaseUrl=basePage.getBaseURL()+"/";
		//Declaring test variables and fetching data from data file to be used in test
		String urlFavoritesLandingpageLoggedInUser=null;
		String lsUserName=TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		Map<String, List<String>> headerLinks = TestDataHandler.constantData.headerSection.getLst_HeaderNameAndLinksMap();
		String urlFavoritesLandingpageAnonymousUser=TestDataHandler.constantData.getHeaderSection().getlbl_SignInLandingPage();
		String lblSignInpageHeading=TestDataHandler.constantData.getHeaderSection().getLbl_SignIn();
		WebElement lnkFavoriteElement =getglobalheaderPageThreadLocal().FavouriteslnkText;

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Home Page");

		//verify Favorite Link
		getglobalheaderPageThreadLocal().waitForPageLoad();
		String headerLinkName = lnkFavoriteElement.getText();

		if(headerLinks.get(headerLinkName).get(0).equalsIgnoreCase(headerLinkName)){
			urlFavoritesLandingpageLoggedInUser = headerLinks.get(headerLinkName).get(2);
		}

		//if(!System.getProperty("Device").equalsIgnoreCase("Tablet")){
			if(getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword)) {
				getglobalheaderPageThreadLocal().waitForPageLoad();
				String urlFavoritesLandingpageForLoggedinUser=getglobalheaderPageThreadLocal().getUrlForLandingpage(getglobalheaderPageThreadLocal().Favouriteslnk);
				getglobalheaderPageThreadLocal().getReusableActionsInstance().waitForPageLoad();
			/*
			boolean flag = getglobalheaderPageThreadLocal().verifyFavoritePageTitle(lsFirstname);
			if(flag)
				reporter.reportLogPass("Page Title for Favorite Page is as expected");
			else
				reporter.reportLogFail("Page Title for Favorite Page is as not as expected");
			 */
				reporter.softAssert(urlFavoritesLandingpageForLoggedinUser.contains(urlFavoritesLandingpageLoggedInUser), "Favourites link's Landing page url is correct for logged in user.", "Favourites link's Landing page url is incorrect for logged in user.");
			}else {
				reporter.reportLogFail("Login failed");
			}

			getglobalheaderPageThreadLocal().getReusableActionsInstance().waitForPageLoad();

			//verify Favorite Link for anonymous user
			if(getGlobalLoginPageThreadLocal().SignOut()) {
				String urlFavoritesLandingPageLoggedInUser=getglobalheaderPageThreadLocal().getUrlForLandingpage(lnkFavoriteElement);
				String PageHeadingSignin=getglobalheaderPageThreadLocal().getPageHeadingSignin();
				reporter.softAssert(urlFavoritesLandingPageLoggedInUser.contains(urlFavoritesLandingpageAnonymousUser), "Favourites link's Landing page url is correct for anonymous user.", "Favourites link's Landing page url is incorrect for anonymous user.");
				reporter.softAssert(PageHeadingSignin,lblSignInpageHeading, "Sign In page heading is correct for anonymous user.", "Sign In page heading  is incorrect for anonymous user.");
			}else {
				reporter.reportLogFail("SignOut failed");
			}
		//}
	}
}
