package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.test.base.BaseTest;

public class HP_TC01_Verify_HomePage extends BaseTest {

	@Test(groups={"Home","Regression"})
    

	public void validateNowOnAirSection() throws IOException {
		//OnAirSectionPageThreadLocal().closeadd();
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL("https://qa-tsc.tsc.ca/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLogWithScreenshot("Home Page");
					
	
	reporter.softAssert(HomePageThreadLocal().validateNOAimg(), "Now On Air image is visible", "Now On Air image is not visible");
	
	reporter.softAssert(HomePageThreadLocal().validatelblNOAProductName(), "Now On Air Product Name is visible", "Now On Air Product Name is not visible");

	reporter.reportLog(HomePageThreadLocal().validatelnkNOA());
	
	 if(HomePageThreadLocal().validateNowPricetag()) {
		 if(HomePageThreadLocal().validateWasPricetag()) {
			 reporter.softAssert(HomePageThreadLocal().validateWasPricetag(), "Was Price tag is visible", "Was Price tag is not visible"); 
			 reporter.softAssert(HomePageThreadLocal().validateNowPricetag(), "Now Price tag is visible", "Now Price tag is not visible"); 

		 }else {
			 reporter.softAssert(HomePageThreadLocal().validateNowPricetag(), "Now Price tag is visible", "Now Price tag is not visible"); 
	 		}
	 	}
	
	reporter.softAssert(HomePageThreadLocal().btnShopNowVisible(), "Shop Now button is visible", "Shop Now button is not visible");
	
	validateText(HomePageThreadLocal().validatebtnShopNow(),"SHOP NOW","SHOP NOW Button Link is present & Text is visible");

	 validateText(HomePageThreadLocal().validateROsection(),"RECENTLY AIRED","Recently Aired Section");
	 reporter.softAssert(HomePageThreadLocal().verifyRAimgCount(),"Image Count is: "+HomePageThreadLocal().getRAimgCount(),"Image Count is: "+HomePageThreadLocal().getRAimgCount());
	 for(int i=0; i<HomePageThreadLocal().getRAimgCount(); i++) {
		 
		// reporter.softAssert(OnAirSectionPageThreadLocal().validateRAsectionLinks(i),"Link is present for tile: "+(i+1),"Link is not present for tile: "+(i+1));
		 reporter.softAssert(HomePageThreadLocal().validateRAsectionImages(i),"Image & Link is present for tile: "+(i+1),"Image & Link is not present for tile: "+(i+1));
		 reporter.reportLog(HomePageThreadLocal().validateRAsectionLinks(i));

			//reporter.reportLog(OnAirSectionPageThreadLocal().getRAsectionImages(i));

	 }
	 reporter.softAssert(HomePageThreadLocal().btnShopAllTodaysItemVisible(), "Shop All Today'S Items button is visible", "Shop All Today'S Items button is not visible");
		
	 validateText(HomePageThreadLocal().validatebtnShopAllTodaysItem(),"Shop All Today'S Items","Shop All Today'S Items Button Link is present & Text is visible");

	
	}
	@Test(groups={"Home","Regression"})

	
	public void validateTSmainImageSection() throws IOException {
		//OnAirSectionPageThreadLocal().closeadd();
	//reporter.softAssert(getglobalheaderPageThreadLocal().validateURL("https://qa-tsc.tsc.ca/"), "TSC url is correct", "TSC url is incorrect");
	//reporter.reportLogWithScreenshot("Home Page");
	
	validateText(HomePageThreadLocal().validateTSmainImagesection(),"Today's Showstopper TM Offers","TS Main Image Section");
	
	}
}







