package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC02_Global_Header_Verify_FlyoutSubMenuDisplay extends BaseTest {
	
	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() throws IOException {
		getglobalheaderPageThreadLocal().closeadd();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyout display all department & it's URL after Clicking each category");
		String FlyoutUrl,lsYmlNotFound,lsSuccessResult, lsFailResult;//
		lsYmlNotFound=TestDataHandler.constantDataVariables.getlnk_NotFound();
		List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		//Fetching heading name and iterating over it,because whenever trying to iterate over the WebElement it throws Stale Element exception.
		List<String> flyoutHeading = new ArrayList<String>();
		
		for(WebElement lsHeading:headingsElement) {
			
			String flHeading=lsHeading.getText();
			
			flyoutHeading.add(flHeading);
			
		}
		reporter.reportLog("Flyout displays headings: "+flyoutHeading);
		
			
			for (String lsHeading:flyoutHeading) {
			reporter.reportLog("Flyout displays heading "+lsHeading);
			FlyoutUrl = getglobalheaderPageThreadLocal().getUrlAfterclickingFlyoutHeading(lsHeading);
			lsSuccessResult=String.format("The url [ %s ] does not contain [ %s ] after clicking " + lsHeading + "'s link", FlyoutUrl,lsYmlNotFound);
			lsFailResult=String.format("The url [ %s ] contains [ %s ] after clicking " + lsHeading + "'s link", FlyoutUrl,lsYmlNotFound);
			reporter.reportLog("URL of the landing page for Flyout heading "+lsHeading+" is "+FlyoutUrl);
			reporter.softAssert(!FlyoutUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
			}
		
		}
		
}	
		/*String lsUrl,FlyoutUrl,lsYmlNotFound,lsSuccessResult, lsFailResult;
		lsYmlNotFound=TestDataHandler.constantDataVariables.getlnk_NotFound();
		List<String>flyoutHeading = getglobalheaderPageThreadLocal().getFlyoutHeadings();
		reporter.reportLog("Flyout diplyas drpartment: "+flyoutHeading+" and they all are validated.");
		for(String lsHeading:flyoutHeading) {
			FlyoutUrl = getglobalheaderPageThreadLocal().getUrlAfterclickingFlyoutHeading(lsHeading);
			lsUrl=getglobalheaderPageThreadLocal().validateUrlAfterclickingFlyoutHeading(lsHeading);
			lsSuccessResult=String.format("The url of [ %s ] does not contain [ %s ] after clicking Flyout" + lsHeading + "'s link", FlyoutUrl,lsYmlNotFound);
			lsFailResult=String.format("The url of [ %s ] contains [ %s ] after clicking Flyout " + lsHeading + "'s link", FlyoutUrl,lsYmlNotFound);
			reporter.softAssert(FlyoutUrl.contains(TestDataHandler.constantDataVariables.getlbl_FlyoutHeadingLandingPageLink()+":"+(lsUrl)), lsHeading + "'s URL is correct", lsHeading + "'s URL is incorrect");
			reporter.softAssert(!FlyoutUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
			
		}*/
	
