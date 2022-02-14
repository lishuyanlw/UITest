package com.tsc.test.tests.globalHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC05_Verify_Global_Header_VerifyFlyoutsViewAll extends BaseTest {

	@Test(groups={"GlobalHeader","Regression"})
	public void GH_TC05_Verify_Global_Header_VerifyFlyoutsViewAll() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating shop all brand links.");
		String shopAllUrl,lsYmlNotFound,lsSuccessResult, lsFailResult,pageHeading;
		lsYmlNotFound=TestDataHandler.constantData.headerSection.getLnk_NotFound();
		List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();

		//Fetching heading name and iterating over it,because whenever trying to iterate over the WebElement it throws Stale Element exception.
		List<String> flyoutHeading = new ArrayList<String>();
		for(WebElement lsHeading:headingsElement) {
			String flHeading=lsHeading.getText();
			flyoutHeading.add(flHeading);
		}
		if(!System.getProperty("Device").equalsIgnoreCase("desktop")){
			getglobalheaderPageThreadLocal().closeMobileMenu();
		}
		reporter.reportLog("Flyout header displays department: "+flyoutHeading);
		for(String lsHeading:flyoutHeading) {
			getglobalheaderPageThreadLocal().scrollToHeadingElement(lsHeading);
			getglobalheaderPageThreadLocal().getReusableActionsInstance().staticWait(3000);
			reporter.reportLog("Flyout header displays department: "+lsHeading);
			shopAllUrl=getglobalheaderPageThreadLocal().getURLshopAllPupularBrand(lsHeading,"Popular Brand");
			String pageHeadingSection=TestDataHandler.constantData.getHeaderSection().getFlyout().getlbl_LandingPageBrandShopAll();
			lsSuccessResult=String.format("The url [ %s ] does not contain [ %s ] after clicking shop all brands under >" + lsHeading + " > Popular Brands", shopAllUrl,lsYmlNotFound);
			lsFailResult=String.format("The url of [ %s ] contains [ %s ] after clicking shop all brands under > " + lsHeading + " > Popular Brands", shopAllUrl,lsYmlNotFound);
			reporter.softAssert(!shopAllUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
			pageHeading=getglobalheaderPageThreadLocal().getHeadingForLandingPage();
			reporter.reportLog("Heading of the landing page "+pageHeadingSection+" : "+pageHeading);
			reporter.softAssert(pageHeading.toLowerCase().contains(lsHeading.toLowerCase()),"Landing page heading "+pageHeading+" is verified with Flyout heading "+lsHeading,"Landing page heading "+pageHeading+" is not matching with Flyout heading > "+lsHeading +" > under Popular Brands >Shop all brands");
		}
	}
}	