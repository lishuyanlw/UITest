package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.test.base.BaseTest;

import com.tsc.pages.base.BasePage;

public class HP_TC05_Verify_ShopByBrand extends BaseTest{
	
	/**
	 * This method will test all verifying methods
	 *
	 * @author Wei.Li
	 */	
	@Test(groups={"Home","Regression"})
	public void validateShopByBrand() throws IOException {
				
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		
	reporter.reportLogWithScreenshot("Home Page");
	
	validateText(homePageThreadLocal().validateShopByBrandHeaderText().toLowerCase(), "shop by brand", "<Shop By Brand> text is visible and valid");
	
	reporter.softAssert(homePageThreadLocal().validateShopByBrandHref(),"All products in ShopByBrand have valid links","Some products in ShopByBrand have no valid links");
	
	reporter.softAssert(homePageThreadLocal().validateShopByBrandImg(),"All products in ShopByBrand have valid image sources","Some products in ShopByBrand have no valid image sources");
	
	reporter.softAssert(homePageThreadLocal().validateShopByBrandClickPrevButton(),"The Prev button in ShopByBrand works well","The Prev button in ShopByBrand doesn't work");
	
	reporter.softAssert(homePageThreadLocal().validateShopByBrandClickNextButton(),"The Next button in ShopByBrand works well","The Next button in ShopByBrand doesn't work");
			
	reporter.softAssert(homePageThreadLocal().validateShopByBrandViewAllLink(),"The ViewAll link matches designed pattern","The ViewAll link doesn't match designed pattern");
	
	}
	
	/**
	 * This method will test automatic scrolling action
	 *
	 * @author Wei.Li
	 */		
	@Test(groups={"Home","Regression"})
	public void validateShopByBrandAutomaticScrollingAction() throws IOException {
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLogWithScreenshot("Home Page");
				
	reporter.softAssert(homePageThreadLocal().validateShopByBrandAutomaticScrollingAction(),"The automatic scrolling function in ShopByBrand works well","The The automatic scrolling function in ShopByBrand doesn't work");
	
	}
	
	
	/**
	 * This method will test Url after clicking ViewAll link
	 *
	 * @author Wei.Li
	 */	
	@Test(groups={"Home","Regression"})
	public void validateShopByBrandUrlAfterClickingViewAllLink() throws IOException {
				
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLogWithScreenshot("Home Page");
		
	reporter.softAssert(homePageThreadLocal().validateShopByBrandUrlAfterClickingViewAllLink(),"The Url after clicking ViewAll link in ShopByBrand is valid","The Url after clicking ViewAll link in ShopByBrand is invalid");
	
	}
	
	

}
