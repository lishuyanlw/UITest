package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.test.base.BaseTest;

public class HP_TC01_Verify_Global_Header extends BaseTest {
	
	
	@Test(groups={"Home","Regression"})
	    
		public void validateGlobalHeaderLinks() throws IOException {
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL("https://qa-tsc.tsc.ca/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().DynamicEventLinkVisible(), "Dynamic Event Link is visible", "Dynamic Event Link is not visible");
		
		reporter.reportLog(getglobalheaderPageThreadLocal().validateDynamicEventLink());
		
	
		validateText(getglobalheaderPageThreadLocal().validateTSLink(), "Today's Showstopper™", "TS Link is present & Text is visible");

		validateText(getglobalheaderPageThreadLocal().validateDealsLink(), "Deals", "Deals Link is present & Text is visible");

		validateText(getglobalheaderPageThreadLocal().validateOnAirLink(), "On Air Products", "On Air Products Link is present & Text is visible");

		validateText(getglobalheaderPageThreadLocal().validateProgramGuideLink(), "Program Guide", "Program Guide Link is present & Text is visible");

		validateText(getglobalheaderPageThreadLocal().validateWatchUsLiveLink(), "Watch Us Live", "Watch Us Live Link is present & Text is visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateTSCLogo(), "TSC icon is visible", "TSC icon is not visible");

		validateText(getglobalheaderPageThreadLocal().validateFavouritesLink(), "Favourites", "Favourites Link is present & Text is visible");

		validateText(getglobalheaderPageThreadLocal().validateSearchbox(), "Search", "Search box is visible");
		reporter.softAssert(getglobalheaderPageThreadLocal().validateSearchsubmitbtn(), "Search submit button is visible", "Search submit button is not visible");

		validateText(getglobalheaderPageThreadLocal().validateMinicartLink(), "Bag", "Mini cart Link is present & Text is visible");
		reporter.softAssert(getglobalheaderPageThreadLocal().validateMinicartIcon(), "Mini cart icon is visible", "Mini cart icon is not visible");
		reporter.softAssert(getglobalheaderPageThreadLocal().validateMinicartBagCounter(), "Mini cart Bag counter is visible", "Mini cart Bag counter is not visible");
				
		
		}
}
