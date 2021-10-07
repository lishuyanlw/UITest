package com.tsc.test.tests.globalHeader;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC01_Verify_Global_Header_VerifyFlyoutsViewAll extends BaseTest {

	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() throws IOException {
		getglobalheaderPageThreadLocal().closeadd();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		
		
	}

}
