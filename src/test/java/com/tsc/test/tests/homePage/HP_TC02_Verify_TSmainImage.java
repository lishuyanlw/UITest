package com.tsc.test.tests.homePage;

import java.io.IOException;
import org.testng.annotations.Test;

import com.tsc.pages.base.BasePage;

import com.tsc.test.base.BaseTest;

	public class HP_TC02_Verify_TSmainImage extends BaseTest{
		@Test(groups={"Home","Regression"})

	public void validateTSmainImageSection() throws IOException, InterruptedException {
		homePageThreadLocal().closeadd();

	//reporter.softAssert(getglobalheaderPageThreadLocal().validateURL("https://qa-tsc.tsc.ca/"), "TSC url is correct", "TSC url is incorrect");
	//reporter.reportLogWithScreenshot("Home Page");


	/*	
	reporter.softAssert(homePageThreadLocal().verifyTSmainimglinkCount(),"TS main section link & image Count is: "+homePageThreadLocal().getTSmainimgCount(),"TS main section link & image Count is: "+homePageThreadLocal().getTSmainimgCount());
	 for(int i=0; i<homePageThreadLocal().getTSmainimgCount(); i++) {
		
		 reporter.softAssert(homePageThreadLocal().validateTSmainimage(i),"TS main image is present for tile: "+(i+1),"TS main image is not present for tile: "+(i+1));
		 reporter.reportLog(homePageThreadLocal().validateTSmainimageLinks(i));
	/*
	validateText(homePageThreadLocal().validateTSimagesection(),"Today's Showstopper TM Offers","TS Main image bottom Section");

	reporter.softAssert(homePageThreadLocal().verifyTSimglinkCount(),"TS image bottom section link & image Count is: "+homePageThreadLocal().getTSimgCount(),"TS image bottom section link & image Count is: "+homePageThreadLocal().getTSimgCount());
		for(int i=0; i<homePageThreadLocal().getTSimgCount(); i++) {
			reporter.softAssert(homePageThreadLocal().validateTSimage(i),"TS image is present for tile: "+(i+1),"TS image is not present for tile: "+(i+1));
			reporter.reportLog(homePageThreadLocal().validateTSimageLinks(i));
		}*/
	}
}

