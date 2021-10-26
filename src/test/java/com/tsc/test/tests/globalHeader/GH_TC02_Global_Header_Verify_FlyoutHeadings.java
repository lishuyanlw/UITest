package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

import io.appium.java_client.ios.ListensToSyslogMessages;

public class GH_TC02_Global_Header_Verify_FlyoutHeadings extends BaseTest {

	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() throws IOException {
		getglobalheaderPageThreadLocal().closeadd();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyouts all departments & it's URL");
		List<String>flyoutHeading = getglobalheaderPageThreadLocal().getFlyoutHeadings();
		reporter.softAssert((TestDataHandler.constantDataVariables.getlst_FlyoutHeading().containsAll(flyoutHeading)),"Flyout diplyas drpartment: "+flyoutHeading+" and they all are validated.","Flyout is not displaying heading properly");
		for(String lsHeading:flyoutHeading) {
			reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyouthref(lsHeading),"href is present for Flyout Link "+lsHeading,"href is not present for Flyout link "+lsHeading);
		}
	}
}
