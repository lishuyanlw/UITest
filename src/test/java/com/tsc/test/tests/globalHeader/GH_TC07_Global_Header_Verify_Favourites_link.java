package com.tsc.test.tests.globalHeader;

import java.io.IOException;
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
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLog("Home Page");
	
	//verify Favorite Link for Logged in user
	String lsUserName=TestDataHandler.constantData.getLoginUser().getLbl_Username();
	String lsPassword=TestDataHandler.constantData.getLoginUser().getLbl_Password();
	String urlFavoritesLandingpageloggedinuser=TestDataHandler.constantData.getHeaderSection().getlbl_FavouritesLandingPage();
	if(getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword)) {
		String urlFavoritesLandingpageForLoggedinUser=getglobalheaderPageThreadLocal().getUrlFavouriteslandingpage();
		reporter.softAssert(urlFavoritesLandingpageForLoggedinUser.contains(urlFavoritesLandingpageloggedinuser), "Favourites link's Landing page url is correct for logged in user.", "Favourites link's Landing page url is incorrect for logged in user.");
	}else {
		reporter.reportLogFail("Login failed");
	}
	
	getglobalheaderPageThreadLocal().applyStaticWait(3000);
	
	//verify Favorite Link for anonymous user
	if(getGlobalLoginPageThreadLocal().SignOut()) {
		String urlFavoritesLandingpageForLoggedinUser=getglobalheaderPageThreadLocal().getUrlFavouriteslandingpage();
		String urlFavoritesLandingpageanonymoususer=TestDataHandler.constantData.getHeaderSection().getlbl_SignInLandingPage();
		String lblsigninpageheading=TestDataHandler.constantData.getHeaderSection().getLbl_SignIn();
		String PageHeadingSignin=getglobalheaderPageThreadLocal().getPageHeadingSignin();
		reporter.softAssert(urlFavoritesLandingpageForLoggedinUser.contains(urlFavoritesLandingpageanonymoususer), "Favourites link's Landing page url is correct for anonymous user.", "Favourites link's Landing page url is incorrect for anonymous user.");
		reporter.softAssert(PageHeadingSignin,lblsigninpageheading, "Sign In page heading is correct for anonymous user.", "Sign In page heading  is incorrect for anonymous user.");
	}else {
			reporter.reportLogFail("SignOut failed");
		}
	}
}
