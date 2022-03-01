package com.tsc.test.tests.homePage;

import java.io.IOException;
import org.testng.annotations.Test;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

	public class HP_TC02_VerifyOnAirSection extends BaseTest {

	@Test(groups={"Home","Regression"})
    

	public void HP_TC02_VerifyOnAirSection() throws IOException {

	getGlobalFooterPageThreadLocal().closePopupDialog();

	if(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/")){
		reporter.reportLogPass("TSC url is correct");
	}
	else{
		reporter.reportLogFailWithScreenshot("TSC url is incorrect");
	}

	reporter.reportLog("Home Page");
					
	if(homePageThreadLocal().validateNOAimg()){
		reporter.reportLogPass("Now On Air image is visible");
	}
	else{
		reporter.reportLogFailWithScreenshot("Now On Air image is not visible");
	}

	if(homePageThreadLocal().validatelblNOAProductName()){
		reporter.reportLogPass("Now On Air Product Name is visible");
	}
	else{
		reporter.reportLogFailWithScreenshot("Now On Air Product Name is not visible");
	}

	if(!homePageThreadLocal().validatelnkNOA().equalsIgnoreCase("NOA href is empty")){
		reporter.reportLogPass("NOA href is not empty");
	}
	else{
		reporter.reportLogFailWithScreenshot("NOA href is empty");
	}

	 if(homePageThreadLocal().validateNowPricetag()) {
		 if(homePageThreadLocal().validateWasPricetag()) {
			 if(homePageThreadLocal().validateWasPricetag()){
				 reporter.reportLogPass("Was Price tag is visible");
			 }
			 else{
				 reporter.reportLogFailWithScreenshot("Was Price tag is not visible");
			 }

			 if(homePageThreadLocal().validateNowPricetag()){
				 reporter.reportLogPass("Now Price tag is visible");
			 }
			 else{
				 reporter.reportLogFailWithScreenshot("Now Price tag is not visible");
			 }

		 }else {
			 if(homePageThreadLocal().validateNowPricetag()){
				 reporter.reportLogPass("Now Price tag is visible");
			 }
			 else{
				 reporter.reportLogFailWithScreenshot("Now Price tag is not visible");
			 }
	 		}
	 	}

	 if(homePageThreadLocal().btnShopNowVisible()){
		 reporter.reportLogPass("Shop Now button is visible");
	 }
	 else{
		 reporter.reportLogFailWithScreenshot("Shop Now button is not visible");
	 }

	validateText(homePageThreadLocal().validatebtnShopNow(),"SHOP NOW","SHOP NOW Button Link is present & Text is visible");

	 validateText(homePageThreadLocal().validateROsection(),"RECENTLY AIRED","Recently Aired Section");
	 if(homePageThreadLocal().verifyRAimgCount()){
		 reporter.reportLogPass("Image Count is: "+homePageThreadLocal().getRAimgCount());
	 }
	 else{
		 reporter.reportLogFailWithScreenshot("Image Count is: "+homePageThreadLocal().getRAimgCount());
	 }

	 for(int i=0; i<homePageThreadLocal().getRAimgCount(); i++) {
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
	 if(homePageThreadLocal().btnShopAllTodaysItemVisible()){
		 reporter.reportLogPass("Shop All Today'S Items button is visible");
	 }
	 else{
		 reporter.reportLogFailWithScreenshot("Shop All Today'S Items button is not visible");
	 }

	 validateText(homePageThreadLocal().validatebtnShopAllTodaysItem(),"Shop All Today'S Items","Shop All Today'S Items Button Link is present & Text is visible");

	
	}
	
}
