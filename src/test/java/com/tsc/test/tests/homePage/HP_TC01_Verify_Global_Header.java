package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.test.base.BaseTest;

import com.tsc.pages.base.BasePage;

public class HP_TC01_Verify_Global_Header extends BaseTest {
	
	@Test(groups={"Home","Regression"})	    
		public void validateGlobalHeaderLinks() throws IOException {
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().DynamicEventLinkVisible(), "Dynamic Event Link is visible", "Dynamic Event Link is not visible");
		
		reporter.reportLog(getglobalheaderPageThreadLocal().validateDynamicEventLink());
		
	
		validateText(getglobalheaderPageThreadLocal().validateTSLink(), "Today's Showstopper™", "TS Link is present & Text is visible");

		validateText(getglobalheaderPageThreadLocal().validateDealsLink(), "Deals", "Deals Link is present & Text is visible");

		validateText(getglobalheaderPageThreadLocal().validateOnAirLink(), "On Air Products", "On Air Products Link is present & Text is visible");

		validateText(getglobalheaderPageThreadLocal().validateProgramGuideLink(), "Program Guide", "Program Guide Link is present & Text is visible");

		validateText(getglobalheaderPageThreadLocal().validateWatchUsLiveLink(), "Watch Us Live", "Watch Us Live Link is present & Text is visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateProgramGuideIconVisible(), "Program Guide icon is visible", "Program Guide icon is not visible");

		reporter.softAssert(getglobalheaderPageThreadLocal().validateWatchUsLiveIconVisible(), "Watch Us icon is visible", "Watch Us icon is  not visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateTSCLogo(), "TSC icon is visible", "TSC icon is not visible");

		validateText(getglobalheaderPageThreadLocal().validateFavouritesLink(), "Favourites", "Favourites Link is present & Text is visible");

		validateText(getglobalheaderPageThreadLocal().validateSearchbox(), "Search", "Search box is visible");
		reporter.softAssert(getglobalheaderPageThreadLocal().validateSearchSubmitbtn(), "Search submit button is visible", "Search submit button is not visible");

		validateText(getglobalheaderPageThreadLocal().validateMinicartLink(), "Bag", "Mini cart Link is present & Text is visible");
		reporter.softAssert(getglobalheaderPageThreadLocal().validateMinicartIcon(), "Mini cart icon is visible", "Mini cart icon is not visible");
		reporter.softAssert(getglobalheaderPageThreadLocal().validateMinicartBagCounter(), "Mini cart Bag counter is visible", "Mini cart Bag counter is not visible");
		
	}
		
		/**
		 * This method will validate Url After Clicking OnAir link
		 *
		 * @author Wei.Li
		 */	
		@Test(groups={"Home","Regression"})    
		public void validateUrlAfterClickingOnAirLink() throws IOException {
			reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
			reporter.reportLogWithScreenshot("Home Page");
			
			reporter.softAssert(getglobalheaderPageThreadLocal().validateUrlAfterClickingOnAirLink(), "The link of <On Air Link> is valid", "The link of <On Air Link> is invalid");
		}
		
		/**
		 * This method will validate Url After Clicking On TodayShowstopper link
		 *
		 * @author Wei.Li
		 */	
		@Test(groups={"Home","Regression"})    
		public void validateUrlAfterClickingTodayShowstopperLink() throws IOException {
			reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
			reporter.reportLogWithScreenshot("Home Page");
			
			reporter.softAssert(getglobalheaderPageThreadLocal().validateUrlAfterClickingTodayShowstopperLink(), "The link of <On Air Link> is valid", "The link of <On Air Link> is invalid");
		}	
		
		/**
		 * This method will validate Url After Clicking On WatchUsLive link
		 *
		 * @author Wei.Li
		 */	
		@Test(groups={"Home","Regression"})    
		public void validateUrlAfterClickingWatchUsLiveLink() throws IOException {
			reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
			reporter.reportLogWithScreenshot("Home Page");
			
			reporter.softAssert(getglobalheaderPageThreadLocal().validateUrlAfterClickingWatchUsLiveLink(), "The link of <WatchUsLive> is valid", "The link of <WatchUsLive> is invalid");
		}
		
		/**
		 * This method will validate clicking TSCLogo can navigate To HomePage.
		 *
		 * @author Wei.Li
		 */	
		@Test(groups={"Home","Regression"})    
		public void validateTSCLogoNavigateToHomePage() throws IOException {
			reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
			reporter.reportLogWithScreenshot("Home Page");
			
			reporter.softAssert(getglobalheaderPageThreadLocal().validateTSCLogoNavigateToHomePage(), "TSCLogo can navigate To HomePage", "TSCLogo cannot navigate To HomePage");
		}
		
		/**
		 * This method will validate url pattern of new windows after clicking ProgramGuide link.
		 *
		 * @author Wei.Li
		 */	
		@Test(groups={"Home","Regression"})    
		public void validateUrlPatternAfterClickingProgramGuideLink() throws IOException {
			reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
			reporter.reportLogWithScreenshot("Home Page");
			
			reporter.softAssert(getglobalheaderPageThreadLocal().validateUrlPatternAfterClickingProgramGuideLink(), "The Url is equal to the exepcted Url after clicking ProgramGuide link", "The Url isn't equal to the exepcted Url after clicking ProgramGuide link");
		}
		
		/**
		 * This method will validate url pattern of new windows after clicking Deals link.
		 *
		 * @author Wei.Li
		 */	
		@Test(groups={"Home","Regression"})    
		public void validateUrlPatternAfterClickingDealsLink() throws IOException {
			reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
			reporter.reportLogWithScreenshot("Home Page");
			
			reporter.softAssert(getglobalheaderPageThreadLocal().validateUrlPatternAfterClickingDealsLink(), "The Url contains the exepcted keyword list after clicking Deals link", "The Url doesn't contain the exepcted keyword list after clicking Deals link");
		}

}
