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
		
		String FOHeading,lsUrl;
		
		for(int i=0; i<getglobalheaderPageThreadLocal().getFlyoutHeadingCount(); i++) {
			FOHeading = getglobalheaderPageThreadLocal().getFlyoutHeadings(i);
			lsUrl=getglobalheaderPageThreadLocal().getFlyoutLink(i);		
			reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyoutHeadings(i),"Flyout heading is present for grid "+ (i+1) ,"Flyout heading is not present for grid "+ (i+1));
			reporter.softAssert(FOHeading, TestDataHandler.constantDataVariables.getlst_FlyoutHeading().get(i),"Flyout display " + FOHeading + " department. It's text is visible and valid","Flyout display " + FOHeading + " department. It's text is visible and valid");
			
			//Verify href is not empty and full url before clicking Flyout link
			reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyouthref(i),"Flyout href is present for Link of "+FOHeading,"Flyout href is not present for link of "+FOHeading);
			reporter.softAssert(lsUrl.contains(TestDataHandler.constantDataVariables.getlst_FlyoutLink().get(i)), FOHeading + "'s URL is correct", FOHeading + "'s URL is incorrect");
			
			}
		}

		
}
