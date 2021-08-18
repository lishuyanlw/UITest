package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC06_Verify_TopSeller extends BaseTest{
	/**
	 * This method will test all verifying methods
	 *
	 * @author Wei.Li
	 */
	@Test(groups={"Home","Regression"})
	public void validateTopSeller() throws IOException {
		//OnAirSectionPageThreadLocal().closeadd();
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLogWithScreenshot("Home Page");
	
	validateText(homePageThreadLocal().getTopSellerHeaderText(), TestDataHandler.constantDataVariables.getlbl_TopSellers(), "<Recommentdation product> text is visible and valid");
	
	reporter.softAssert(homePageThreadLocal().validateTopSellerIsAboveFooter(),"The TopSeller section is above Footer section","The TopSeller section isn't above Footer section");
	
	reporter.softAssert(homePageThreadLocal().validateTopSellerHref(),"All products in TopSeller have valid links","some products in TopSeller haven't valid links");
	
	reporter.softAssert(homePageThreadLocal().validateTopSellerImg(),"All products in TopSeller have valid image sources","some products in TopSeller haven't valid image sources");
	
	reporter.softAssert(homePageThreadLocal().validateTopSellerName(),"All products in TopSeller have valid names","some products in TopSeller haven't valid names");
	
	reporter.softAssert(homePageThreadLocal().validateTopSellerNowPrice(),"All products in TopSeller have valid  NowPrice contents","some products in TopSeller haven't valid NowPrice contents");
	
	reporter.softAssert(homePageThreadLocal().validateTopSellerWasPrice(),"All products in TopSeller have valid  WasPrice contents","some products in TopSeller haven't valid WasPrice contents");
		
	
	}

}