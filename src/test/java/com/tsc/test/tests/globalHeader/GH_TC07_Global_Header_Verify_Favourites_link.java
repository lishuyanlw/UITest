package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.tsc.data.pojos.ConstantData;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC07_Global_Header_Verify_Favourites_link extends BaseTest {
	
	@Test(groups={"Home","Regression"})	    
	public void validateGlobalHeader_Favourites_Link() throws IOException {		
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());
		String lsBaseUrl=basePage.getBaseURL()+"/";
		//Declaring test variables and fetching data from data file to be used in test
		String urlFavoritesLandingpageLoggedInUser=null;
		String lsUserName=TestDataHandler.constantData.getLoginUser().getLbl_Username();
		String lsPassword=TestDataHandler.constantData.getLoginUser().getLbl_Password();
		Map<String, List<String>> headerLinks = TestDataHandler.constantData.headerSection.getLst_HeaderNameAndLinksMap();
		String urlFavoritesLandingpageAnonymousUser=TestDataHandler.constantData.getHeaderSection().getlbl_SignInLandingPage();
		String lblSignInpageHeading=TestDataHandler.constantData.getHeaderSection().getLbl_SignIn();
		WebElement lnkFavoriteElement =getglobalheaderPageThreadLocal().Favouriteslnk;

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Home Page");

		//verify Favorite Link for Logged in user
		String headerLinkName = lnkFavoriteElement.getText();

		if(headerLinks.get(headerLinkName).get(0).equalsIgnoreCase(headerLinkName)){
			urlFavoritesLandingpageLoggedInUser = headerLinks.get(headerLinkName).get(2);
		}

		if(getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword)) {
			String urlFavoritesLandingpageForLoggedinUser=getglobalheaderPageThreadLocal().getUrlForLandingpage(lnkFavoriteElement);
			reporter.softAssert(urlFavoritesLandingpageForLoggedinUser.contains(urlFavoritesLandingpageLoggedInUser), "Favourites link's Landing page url is correct for logged in user.", "Favourites link's Landing page url is incorrect for logged in user.");
		}else {
			reporter.reportLogFail("Login failed");
		}

		getglobalheaderPageThreadLocal().applyStaticWait(3000);

		//verify Favorite Link for anonymous user
		if(getGlobalLoginPageThreadLocal().SignOut()) {
			String urlFavoritesLandingPageLoggedInUser=getglobalheaderPageThreadLocal().getUrlForLandingpage(lnkFavoriteElement);
			String PageHeadingSignin=getglobalheaderPageThreadLocal().getPageHeadingSignin();
			reporter.softAssert(urlFavoritesLandingPageLoggedInUser.contains(urlFavoritesLandingpageAnonymousUser), "Favourites link's Landing page url is correct for anonymous user.", "Favourites link's Landing page url is incorrect for anonymous user.");
			reporter.softAssert(PageHeadingSignin,lblSignInpageHeading, "Sign In page heading is correct for anonymous user.", "Sign In page heading  is incorrect for anonymous user.");
		}else {
			reporter.reportLogFail("SignOut failed");
		}
	}
}
