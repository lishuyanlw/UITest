package com.tsc.test.tests.globalHeader;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;


public class GH_TC03_Global_Header_Verify_FlyoutHeadings extends BaseTest {

	@Test(groups={"GlobalHeader","Regression"})
	public void GH_TC03_Global_Header_Verify_FlyoutHeadings() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyouts all departments & it's URL before clicking it");
		if(System.getProperty("Device").equalsIgnoreCase("Desktop"))
			getglobalheaderPageThreadLocal().validateFlyout();
		else if(!(System.getProperty("Device").equalsIgnoreCase("Tablet") &&
				(System.getProperty("Browser").contains("ios") ||
						System.getProperty("chromeMobileDevice").contains("iPad"))))
			getglobalheaderPageThreadLocal().verifyWatchTSCAtPageBottom();
	}
}
