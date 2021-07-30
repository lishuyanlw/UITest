package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.test.base.BaseTest;

	public class HP_TC02_Verify_TSmainImage extends BaseTest{
		@Test(groups={"Home","Regression"})

	
	public void validateTSmainImageSection() throws IOException {
		//OnAirSectionPageThreadLocal().closeadd();
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL("https://qa-tsc.tsc.ca/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLogWithScreenshot("Home Page");
	
	validateText(homePageThreadLocal().validateTSmainImagesection(),"Today's Showstopper TM Offers","TS Main Image Section");
	
	}
}