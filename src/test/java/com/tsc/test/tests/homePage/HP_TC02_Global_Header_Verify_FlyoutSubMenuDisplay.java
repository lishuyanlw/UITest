package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC02_Global_Header_Verify_FlyoutSubMenuDisplay extends BaseTest {
	
	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyout display all department & it's URL after Clicking each category");
		String flyoutHeading,lsUrl,lsYmlNotFound,lsSuccessResult, lsFailResult;
		lsYmlNotFound=TestDataHandler.constantDataFile.getHeaderSection().getLnk_NotFound();
		for(int i=0; i<getglobalheaderPageThreadLocal().getFlyoutHeadingCount(); i++) {
			flyoutHeading = getglobalheaderPageThreadLocal().getFlyoutHeadings(i);	
			reporter.softAssert(flyoutHeading, TestDataHandler.constantDataFile.getHeaderSection().getFlyout().getLst_FlyoutHeading().get(i),"Flyout is displayed for " + flyoutHeading + " department.","Flyout is not displayed for " + flyoutHeading + " department.");
			
			//Verify notfound and full url after clicking Flyout link
			lsUrl=getglobalheaderPageThreadLocal().getURLafterClickFlyoutHeading(i);		
			lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking " + flyoutHeading + "'s link", lsUrl,lsYmlNotFound);
			lsFailResult=String.format("The url of < %s > contains < %s > after clicking " + flyoutHeading + "'s link", lsUrl,lsYmlNotFound);
			reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
			reporter.softAssert(lsUrl.equals(lsBaseUrl+(TestDataHandler.constantDataFile.getHeaderSection().getFlyout().getLbl_FlyoutHeadingLandingPageLink())+(TestDataHandler.constantDataFile.getHeaderSection().getFlyout().getLnk_FlyoutHeaderLinkConstant().get(i))), flyoutHeading + "'s URL is correct", flyoutHeading + "'s URL is incorrect");

		}
	}
}
