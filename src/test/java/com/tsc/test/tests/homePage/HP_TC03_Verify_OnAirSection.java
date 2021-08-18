package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.test.base.BaseTest;

	public class HP_TC03_Verify_OnAirSection extends BaseTest {

	@Test(groups={"Home","Regression"})
    

	public void validateNowOnAirSection() throws IOException {
		//OnAirSectionPageThreadLocal().closeadd();
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL("https://qa-tsc.tsc.ca/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLogWithScreenshot("Home Page");
					
	
	reporter.softAssert(homePageThreadLocal().validateNOAimg(), "Now On Air image is visible", "Now On Air image is not visible");
	
	reporter.softAssert(homePageThreadLocal().validatelblNOAProductName(), "Now On Air Product Name is visible", "Now On Air Product Name is not visible");

	reporter.reportLog(homePageThreadLocal().validatelnkNOA());
	
	 if(homePageThreadLocal().validateNowPricetag()) {
		 if(homePageThreadLocal().validateWasPricetag()) {
			 reporter.softAssert(homePageThreadLocal().validateWasPricetag(), "Was Price tag is visible", "Was Price tag is not visible"); 
			 reporter.softAssert(homePageThreadLocal().validateNowPricetag(), "Now Price tag is visible", "Now Price tag is not visible"); 

		 }else {
			 reporter.softAssert(homePageThreadLocal().validateNowPricetag(), "Now Price tag is visible", "Now Price tag is not visible"); 
	 		}
	 	}
	
	reporter.softAssert(homePageThreadLocal().btnShopNowVisible(), "Shop Now button is visible", "Shop Now button is not visible");
	
	validateText(homePageThreadLocal().validatebtnShopNow(),"SHOP NOW","SHOP NOW Button Link is present & Text is visible");

	 validateText(homePageThreadLocal().validateROsection(),"RECENTLY AIRED","Recently Aired Section");
	 reporter.softAssert(homePageThreadLocal().verifyRAimgCount(),"Image Count is: "+homePageThreadLocal().getRAimgCount(),"Image Count is: "+homePageThreadLocal().getRAimgCount());
	 for(int i=0; i<homePageThreadLocal().getRAimgCount(); i++) {
		 
		// reporter.softAssert(OnAirSectionPageThreadLocal().validateRAsectionLinks(i),"Link is present for tile: "+(i+1),"Link is not present for tile: "+(i+1));
		 reporter.softAssert(homePageThreadLocal().validateRAsectionImages(i),"Image & Link is present for tile: "+(i+1),"Image & Link is not present for tile: "+(i+1));
		 reporter.reportLog(homePageThreadLocal().validateRAsectionLinks(i));

			//reporter.reportLog(OnAirSectionPageThreadLocal().getRAsectionImages(i));

	 }
	 reporter.softAssert(homePageThreadLocal().btnShopAllTodaysItemVisible(), "Shop All Today'S Items button is visible", "Shop All Today'S Items button is not visible");
		
	 validateText(homePageThreadLocal().validatebtnShopAllTodaysItem(),"Shop All Today'S Items","Shop All Today'S Items Button Link is present & Text is visible");

	
	}
	
}
