package com.tsc.test.tests.homePage;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC02_Global_Header_Verify_FlyoutHeadings extends BaseTest {

	
		@Test(groups={"Home","Regression"})	    
		public void verifyFlyoutHeadings() throws IOException {
			getglobalheaderPageThreadLocal().closeadd();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyouts all departments & it's URL after Clicking each category");
		
			for(int i=0; i<getglobalheaderPageThreadLocal().getFlyoutHeadingCount(); i++) {
				reporter.softAssert(getglobalheaderPageThreadLocal().getFlyoutHeadings(i), TestDataHandler.constantDataVariables.getlst_FlyoutHeading().get(i),"Flyout display " + getglobalheaderPageThreadLocal().getFlyoutHeadings(i) + " department. It's text is visible and valid","Flyout display " + getglobalheaderPageThreadLocal().getFlyoutHeadings(i) + " department. It's text is visible and valid");
				reporter.softAssert(getglobalheaderPageThreadLocal().getURLafterClickFlyoutHeading(i), lsBaseUrl + TestDataHandler.constantDataVariables.getlst_FlyoutLinks().get(i), getglobalheaderPageThreadLocal().getFlyoutHeadings(i) + "'s URL is correct", getglobalheaderPageThreadLocal().getFlyoutHeadings(i) + "'s URL is incorrect");
			}
		}
}
