package com.tsc.test.tests.globalHeader;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;


public class GH_TC03_Global_Header_Verify_FlyoutHeadings extends BaseTest {

	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyouts all departments & it's URL before clicking it");
		
		List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		for(WebElement lsHeading:headingsElement) {
			getglobalheaderPageThreadLocal().scrolltoWebElement(lsHeading);
			getGlobalFooterPageThreadLocal().applyStaticWait(3000);
			String flyoutHeading =lsHeading.getText();
			reporter.softAssert((TestDataHandler.constantData.headerSection.getFlyout().getLst_FlyoutHeadingAndNameMap().get(flyoutHeading).contains(flyoutHeading)),"Flyout displays drpartment  "+flyoutHeading+" and it's validated.","Flyout is not displaying heading properly for "+flyoutHeading);
			reporter.softAssert(getglobalheaderPageThreadLocal().verifyhrefFlyoutHeading(lsHeading), "Href is present for Flyout Heading "+flyoutHeading, "Href is not preset for "+flyoutHeading);
		}
	}	
}
