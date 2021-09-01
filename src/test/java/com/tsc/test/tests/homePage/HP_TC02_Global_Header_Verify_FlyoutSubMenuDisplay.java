package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC02_Global_Header_Verify_FlyoutSubMenuDisplay extends BaseTest {

	
	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() throws IOException {
		
	String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLogWithScreenshot("Home Page");
	reporter.reportLog("Validating Flyout diplays all department & it's URL after Clicking each category");
	
	String FOHeading,lsUrl,lsYmlNotFound,lsYmlFullUrl,lsSuccessResult, lsFailResult;
	lsYmlNotFound=TestDataHandler.constantDataVariables.getlnk_NotFound();

	for(int i=0; i<getglobalheaderPageThreadLocal().getFlyoutHeadingCount(); i++) {
		FOHeading = getglobalheaderPageThreadLocal().getFlyoutHeadings(i);
		
		reporter.softAssert(getglobalheaderPageThreadLocal().velidateFlyoutHeadings(i), "Flyout is displayed for" + FOHeading + " department.","Flyout is not displayed for " + FOHeading + " department.");
		
		//Verify notfound and full url after clicking Flyout link
		lsUrl=getglobalheaderPageThreadLocal().getURLafterClickFlyoutHeading(i);		
		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking " + FOHeading + "'s link", lsUrl,lsYmlNotFound);
		lsFailResult=String.format("The url of < %s > contains < %s > after clicking " + FOHeading + "'s link", lsUrl,lsYmlNotFound);
		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
		reporter.softAssert(lsUrl.contains(TestDataHandler.constantDataVariables.getlnk_FlyoutLinks().get(i)), FOHeading + "'s URL is correct", FOHeading + "'s URL is incorrect");
		
		}
	}
}
