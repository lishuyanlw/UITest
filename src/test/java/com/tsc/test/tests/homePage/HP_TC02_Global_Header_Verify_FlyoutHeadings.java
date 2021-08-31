package com.tsc.test.tests.homePage;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

import io.appium.java_client.ios.ListensToSyslogMessages;

public class HP_TC02_Global_Header_Verify_FlyoutHeadings extends BaseTest {

		@Test(groups={"Home","Regression"})	    
		public void verifyFlyoutHeadings() throws IOException {
			getglobalheaderPageThreadLocal().closeadd();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyouts all departments & it's URL");
		String flyoutHeading,lsUrl;
			for(int i=0; i<getglobalheaderPageThreadLocal().getFlyoutHeadingCount(); i++) {
				flyoutHeading = getglobalheaderPageThreadLocal().getFlyoutHeadings(i);
				lsUrl=getglobalheaderPageThreadLocal().getFlyoutLink(i);		
				reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyoutHeadings(i),"Flyout heading is present for grid "+ (i+1) ,"Flyout heading is not present for grid "+ (i+1));
				reporter.softAssert(flyoutHeading, TestDataHandler.constantDataVariables.getlst_FlyoutHeading().get(i),"Flyout display " + flyoutHeading + " department. It's text is visible and valid","Flyout display " + flyoutHeading + " department. It's text is visible and valid");
			//Verify href is not empty and full url before clicking Flyout link
				reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyouthref(i),"Flyout href is present for Link of "+flyoutHeading,"Flyout href is not present for link of "+flyoutHeading);
				reporter.softAssert(lsUrl.contains(TestDataHandler.constantDataVariables.getlst_FlyoutLink().get(i)), flyoutHeading + "'s URL is correct", flyoutHeading + "'s URL is incorrect");
			}
		}
}
