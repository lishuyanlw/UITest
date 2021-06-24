package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tsc.pages.GlobalheaderPage;
import com.tsc.test.base.BaseTest;

public class HP_TC01_Verify_Global_Header extends BaseTest {
	
	@Test(groups={"Home","Regression"})
    
	/*
	 * public void validateTSCurl() throws IOException {
	 * 
	 * reporter.softAssert(getglobalheaderPageThreadLocal(), "link loaded Properly",
	 * "Link is broken"); reporter.reportLogWithScreenshot("Business Tools Page"); }
	 */
		
	//public void validateGloalheaderSliverLinks() throws IOException {
		public void validateTSCurl() throws IOException{
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL("https://qa-tsc.tsc.ca/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		}
	
}
