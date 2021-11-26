package com.tsc.test.tests.globalHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC05_Verify_Global_Header_VerifyFlyoutsViewAll extends BaseTest {

	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating shop all brand links.");
		String shopAllUrl,lsYmlNotFound,lsSuccessResult, lsFailResult,pageHeading;
		lsYmlNotFound=TestDataHandler.constantData.headerSection.getLnk_NotFound();
		List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		
		Map<String, List<String>> lstFlyoutHeading_FR= TestDataHandler.constantData.headerSection.getFlyout().getLst_FlyoutHeadingAndNameMap();

		//Fetching heading name and iterating over it,because whenever trying to iterate over the WebElement it throws Stale Element exception.
		List<String> flyoutHeading = new ArrayList<String>();
		for(WebElement lsHeading:headingsElement) {
			String flHeading=lsHeading.getText();
			flyoutHeading.add(flHeading);
		}
		reporter.reportLog("Flyout header displays department: "+flyoutHeading);
		for(String lsHeading:flyoutHeading) {
			if (System.getProperty("Device").equalsIgnoreCase("Desktop")){
				getglobalheaderPageThreadLocal().scrollToHeadingElement(lsHeading);
			}
			reporter.reportLog("Flyout header displays department: "+lsHeading);
			shopAllUrl=getglobalheaderPageThreadLocal().getURLshopAllPupularBrand(lsHeading,"Popular Brand");
			pageHeading=getglobalheaderPageThreadLocal().getHeadingForLandingPage(lsHeading);
			String urlShopAllBrandYmlData=TestDataHandler.constantData.getHeaderSection().getFlyout().getlnk_ShopByBrandShopAll();
			String pageHeadingSection=TestDataHandler.constantData.getHeaderSection().getFlyout().getlbl_LandingPageBrandShopAll();
			String linkNumberYmlData= lstFlyoutHeading_FR.get(lsHeading).get(2);
			lsSuccessResult=String.format("The url [ %s ] does not contain [ %s ] after clicking shop all brands under >" + lsHeading + " > Popular Brands", shopAllUrl,lsYmlNotFound);
			lsFailResult=String.format("The url of [ %s ] contains [ %s ] after clicking shop all brands under > " + lsHeading + " > Popular Brands", shopAllUrl,lsYmlNotFound);
			reporter.softAssert(!shopAllUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
			reporter.softAssert(shopAllUrl.contains(urlShopAllBrandYmlData+linkNumberYmlData),"Landing page url is verified","Landing page url is not matching with Flyout heading > "+lsHeading +" > under Popular Brands >Shop all brands");
			reporter.reportLog("Heading of the landing page "+pageHeadingSection+" : "+pageHeading);
			reporter.softAssert(pageHeading.equalsIgnoreCase(lsHeading),"Landing page heading is verified with Flyout heading.","Landing page heading is not matching with Flyout heading > "+lsHeading +" > under Popular Brands >Shop all brands");
			
		}
	}
}	