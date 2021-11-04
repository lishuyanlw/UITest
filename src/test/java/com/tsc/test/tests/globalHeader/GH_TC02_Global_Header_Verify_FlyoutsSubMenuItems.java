package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
public class GH_TC02_Global_Header_Verify_FlyoutsSubMenuItems extends BaseTest {

	
	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() throws IOException {
		
		getglobalheaderPageThreadLocal().closeadd();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyout Sub Menu for each category");
		
		List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		reporter.reportLog("size of headingsElement--"+headingsElement.size());
		for(WebElement lsHeading:headingsElement) {
			
			String flyoutHeading=lsHeading.getText();
			
			getglobalheaderPageThreadLocal().scrollToHeadingElement(flyoutHeading);
			reporter.reportLog("Validation of Flyout heading "+flyoutHeading);
		
			List<WebElement> categoryElement=getglobalheaderPageThreadLocal().getCategoryWebelement(lsHeading,flyoutHeading);
			
			reporter.reportLog("size of categoryElement--"+categoryElement.size());
			
			for(WebElement lscategory:categoryElement) {
				String categoryHeading=lscategory.getText();
				getglobalheaderPageThreadLocal().scrollToHeadingElement(categoryHeading);
				reporter.reportLog("Validation of categories "+categoryHeading);
				String submenuItems=getglobalheaderPageThreadLocal().verify_Header_SubMenu("SubMenu",null);
				reporter.softAssert(submenuItems=="","src is present for all elements of submenu > "+categoryHeading+" >  "+flyoutHeading,"src missing for "+flyoutHeading+" > "+categoryHeading+" > "+submenuItems);
			}
		/*	reporter.softAssert(getglobalheaderPageThreadLocal().validateSubMenuHeadings("Curated Collection"), "Curated Collection Heading is present for "+flyoutHeading,"Curated Collection Heading is not present for "+flyoutHeading);
			String curatedcollectionhref=getglobalheaderPageThreadLocal().verify_Header_SubMenu("CuratedCollection",null);
			reporter.softAssert(curatedcollectionhref=="","href is present for all elements of Curated collection under flyout heading "+flyoutHeading,"href missing for "+flyoutHeading+" > Curated Collection > "+curatedcollectionhref);
			
			/*reporter.softAssert(getglobalheaderPageThreadLocal().validateSubMenuHeadings("Popular Brand"), "Popular Brand Heading is present for "+flyoutHeading,"Popular Brand Heading is not present for "+flyoutHeading);
			String popularbrandhref=getglobalheaderPageThreadLocal().verify_Header_SubMenu("PopularBrands","href");
			String popularbrandsrc=getglobalheaderPageThreadLocal().verify_Header_SubMenu("PopularBrands",null);
			
			reporter.softAssert(popularbrandhref=="","href is present for all elements of Popular Brand under flyout heading "+flyoutHeading,"href missing for "+flyoutHeading+" > Popular Brand > "+popularbrandhref);
			reporter.softAssert(popularbrandsrc=="","src is present for all elements of Popular Brand under flyout heading "+flyoutHeading,"src missing for "+flyoutHeading+" > Popular Brand > "+popularbrandsrc);
			*/
	
		
		//getglobalheaderPageThreadLocal().clickSubMenuItem("Clearance", "Dresses","Short");
	

		
		}
	}
}


		
