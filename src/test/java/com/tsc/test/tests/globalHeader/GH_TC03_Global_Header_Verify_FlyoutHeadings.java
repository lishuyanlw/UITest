package com.tsc.test.tests.globalHeader;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;


public class GH_TC03_Global_Header_Verify_FlyoutHeadings extends BaseTest {

	@Test(groups={"Home","Regression","GlobalHeader","GlobalHeader_Mobile","GlobalHeader_Tablet"})
	public void verifyFlyoutHeadingURL() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyouts all departments & it's URL before clicking it");
		if(System.getProperty("Device").equalsIgnoreCase("Desktop"))
			validateFlyout();
		else
			reporter.reportLog("This test is not required for other device as heading is a button and not a link");
	}
		
	public void validateFlyout() {
		List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		for(WebElement lsHeading:headingsElement) {
			getglobalheaderPageThreadLocal().scrolltoWebElement(lsHeading);
			getGlobalFooterPageThreadLocal().applyStaticWait(3000);
			String flyoutHeading =lsHeading.getText();
			if(System.getProperty("Device").equalsIgnoreCase("Desktop")){
				reporter.softAssert(getglobalheaderPageThreadLocal().verifyhrefFlyoutHeading(lsHeading), "Href is present for Flyout Heading "+flyoutHeading, "Href is not preset for "+flyoutHeading);
			}
		}
	}
}
