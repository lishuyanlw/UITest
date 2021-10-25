package com.tsc.test.tests.homePage;

import java.io.IOException;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC02_Global_Header_Verify_FlyoutHeadings extends BaseTest {

	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyouts all departments & it's URL");
		String flyoutHeading,lsUrl;
		for(int i=0; i<getglobalheaderPageThreadLocal().getFlyoutHeadingCount(); i++) {
			flyoutHeading = getglobalheaderPageThreadLocal().getFlyoutHeadings(i);
			lsUrl=getglobalheaderPageThreadLocal().getFlyoutLink(i);		
			reporter.softAssert(flyoutHeading, TestDataHandler.constantDataFile.getHeaderSection().getFlyout().getLst_FlyoutHeading().get(i),"Flyout display " + flyoutHeading + " department. It's text is visible and valid","Flyout display " + flyoutHeading + " department. It's text is visible and valid");
			//Verify href is not empty and full url before clicking Flyout link
			reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyouthref(i),"Flyout href is present for Link of "+flyoutHeading,"Flyout href is not present for link of "+flyoutHeading);
			reporter.softAssert(lsUrl.equals(lsBaseUrl+(TestDataHandler.constantDataFile.getHeaderSection().getFlyout().getLbl_FlyoutHeadingLandingPageLink())+(TestDataHandler.constantDataFile.getHeaderSection().getFlyout().getLnk_FlyoutHeaderLinkConstant().get(i))), flyoutHeading + "'s URL is correct", flyoutHeading + "'s URL is incorrect");
		}
	}
}
