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
		reporter.reportLog("Validating Flyouts all departments & it's URL after Clicking each category");
		
		String FOHeading,lsUrl,lsYmlNotFound,lsSuccessResult, lsFailResult;
		lsYmlNotFound=TestDataHandler.constantDataVariables.getlnk_NotFound();

		for(int i=0; i<getglobalheaderPageThreadLocal().getFlyoutHeadingCount(); i++) {
			FOHeading = getglobalheaderPageThreadLocal().getFlyoutHeadings(i);
			
			reporter.softAssert(FOHeading, TestDataHandler.constantDataVariables.getlst_FlyoutHeading().get(i),"Flyout display " + FOHeading + " department. It's text is visible and valid","Flyout display " + FOHeading + " department. It's text is visible and valid");
			//reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyoutLinks(i),"Flyout Link is present for "+FOHeading,"Flyout Link is not present for "+FOHeading);
			
			//Verify notfound and full url after clicking Flyout link
			lsUrl=getglobalheaderPageThreadLocal().getFlyoutLink(i);		
			lsSuccessResult=String.format("The href is not empty and is < %s > for url of " + FOHeading + " department", lsUrl,lsYmlNotFound);
			lsFailResult=String.format("The href is empty for url of" + FOHeading + " department", lsUrl,lsYmlNotFound);
			reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
			reporter.softAssert(lsUrl.contains(TestDataHandler.constantDataVariables.getlst_FlyoutLink().get(i)), FOHeading + "'s URL is correct", FOHeading + "'s URL is incorrect");
			
			}
		}
}
