package com.tsc.test.tests.homePage;

import org.testng.annotations.Test;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC02_VerifyOnAirSection extends BaseTest {

	@Test(groups={"Home","Regression"})
	public void HP_TC02_VerifyOnAirSection() {

	getGlobalFooterPageThreadLocal().closePopupDialog();

	if(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/")){
		reporter.reportLogPass("TSC url is correct");
	}
	else{
		reporter.reportLogFailWithScreenshot("TSC url is incorrect");
	}

	reporter.reportLog("Home Page");

	if(homePageThreadLocal().validateNOAimg())
		reporter.reportLogPass("Now On Air image is visible");
	else
		reporter.reportLogFailWithScreenshot("Now On Air image is not visible");

	if(homePageThreadLocal().validatelblNOAProductName())
		reporter.reportLogPass("Now On Air Product Name is visible");
	else
		reporter.reportLogFailWithScreenshot("Now On Air Product Name is not visible");

	if(!homePageThreadLocal().validatelnkNOA().equalsIgnoreCase("NOA href is empty"))
		reporter.reportLogPass("NOA href is not empty");
	else
		reporter.reportLogFailWithScreenshot("NOA href is empty");

	 if(homePageThreadLocal().validateNowPricetag()) {
		 reporter.reportLogPass("Now Price tag is visible");
		 if (homePageThreadLocal().validateWasPricetag())
		 	reporter.reportLogPass("Was Price tag is visible");
		 else
		 	reporter.reportLog("Was Price is not available for product");
	 }else
		 reporter.reportLogFailWithScreenshot("Now Price tag is not visible");

	 if(homePageThreadLocal().btnShopNowVisible())
		 reporter.reportLogPass("Shop Now button is visible");
	 else
		 reporter.reportLogFailWithScreenshot("Shop Now button is not visible");

	 if(System.getProperty("Device").equalsIgnoreCase("Desktop") &&
			 System.getProperty("Browser").contains("safari")){
		 validateText(homePageThreadLocal().validatebtnShopNow(),"Shop Now","SHOP NOW Button Link is present & Text is visible");
		 validateText(homePageThreadLocal().validateROsection(),"Recently Aired","Recently Aired Section");
	 }
	 else{
	 	validateText(homePageThreadLocal().validatebtnShopNow(),"SHOP NOW","SHOP NOW Button Link is present & Text is visible");
		validateText(homePageThreadLocal().validateROsection(),"RECENTLY AIRED","Recently Aired Section");
	 }

	 if(homePageThreadLocal().verifyRAimgCount()){
		int imageCount = homePageThreadLocal().getRAimgCount();
		 reporter.reportLogPass("Image Count in Recently Aired Section is: "+imageCount);
		 for(int i=0; i<imageCount; i++) {
			 if(homePageThreadLocal().validateRAsectionImages(i)){
				 reporter.reportLogPass("Image & Link is present for tile: "+(i+1));
			 }
			 else{
				 reporter.reportLogFailWithScreenshot("Image & Link is not present for tile: "+(i+1));
			 }
			 if(!homePageThreadLocal().validateRAsectionLinks(i).equalsIgnoreCase("Image link href is empty")){
				 reporter.reportLogPass("Image link href is not empty");
			 }
			 else{
				 reporter.reportLogFailWithScreenshot("Image link href is empty");
			 }
		 }
	 }
	 else
		 reporter.reportLogFailWithScreenshot("Image Count in Recently Aired Section is: "+homePageThreadLocal().getRAimgCount());

	 if(homePageThreadLocal().btnShopAllTodaysItemVisible())
		 reporter.reportLogPass("Shop All Today'S Items button is visible");
	 else
		 reporter.reportLogFailWithScreenshot("Shop All Today'S Items button is not visible");

	 if(System.getProperty("Device").equalsIgnoreCase("Mobile") ||
			 (System.getProperty("Device").equalsIgnoreCase("Tablet") &&
					 System.getProperty("Browser").contains("android")) ||
			 (System.getProperty("Browser").equals("chromemobile") &&
					 System.getProperty("Device").equalsIgnoreCase("Tablet") &&
					 !System.getProperty("chromeMobileDevice").contains("iPad")))
		 validateText(homePageThreadLocal().validatebtnShopAllTodaysItem(),"SHOP ALL TODAY'S ITEMS","SHOP ALL TODAY'S ITEMS Button Link is present & Text is visible");
	 else if((System.getProperty("Device").equalsIgnoreCase("Desktop") &&
			 (System.getProperty("Browser").contains("firefox") || System.getProperty("Browser").contains("safari")) ||
			 	(System.getProperty("Device").equalsIgnoreCase("Tablet") &&
					 System.getProperty("Browser").contains("ios")) ||
			 	(System.getProperty("Browser").equals("chromemobile") &&
					 System.getProperty("Device").equalsIgnoreCase("Tablet") &&
					 System.getProperty("chromeMobileDevice").contains("iPad"))))
	 	validateText(homePageThreadLocal().validatebtnShopAllTodaysItem(),"Shop All Today's Items","Shop All Today's Items Button Link is present & Text is visible");
	 else
		 validateText(homePageThreadLocal().validatebtnShopAllTodaysItem(),"Shop All Today'S Items","Shop All Today'S Items Button Link is present & Text is visible");
	}
}
