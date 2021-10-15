package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.test.base.BaseTest;

import com.tsc.pages.base.BasePage;
import com.tsc.data.Handler.TestDataHandler;

public class HP_TC05_Verify_ShopByBrand extends BaseTest{
	/*
	 * CER-203
	 */
	@Test(groups={"Home","Regression"})
	public void validateShopByBrand() throws IOException {
				
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
	
	reporter.softAssert(homePageThreadLocal().validateShopByBrandAutomaticScrollingAction(),"The automatic scrolling function in ShopByBrand works well","The The automatic scrolling function in ShopByBrand doesn't work");
	validateText(homePageThreadLocal().validateShopByBrandHeaderText().toUpperCase(), TestDataHandler.constantDataVariables.getlbl_ShopByBrand(), "<Shop By Brand> text is visible and valid");
	reporter.softAssert(homePageThreadLocal().validateShopByBrandHref(),"All products in ShopByBrand have valid links","Some products in ShopByBrand have no valid links");
	reporter.softAssert(homePageThreadLocal().validateShopByBrandImg(),"All products in ShopByBrand have valid image sources","Some products in ShopByBrand have no valid image sources");
	reporter.softAssert(homePageThreadLocal().validateShopByBrandClickPrevButton(),"The Prev button in ShopByBrand works well","The Prev button in ShopByBrand doesn't work");
	reporter.softAssert(homePageThreadLocal().validateShopByBrandClickNextButton(),"The Next button in ShopByBrand works well","The Next button in ShopByBrand doesn't work");
	reporter.softAssert(homePageThreadLocal().validateShopByBrandViewAllLink(TestDataHandler.constantDataVariables.getlnk_ShopByBrandViewAll()),"The ViewAll link matches designed pattern","The ViewAll link doesn't match designed pattern");
	reporter.softAssert(!homePageThreadLocal().validateShopByBrandUrlAfterClickingViewAllLink().contains(TestDataHandler.constantDataVariables.getlnk_NotFound()),"The Url after clicking ViewAll link in ShopByBrand is valid","The Url after clicking ViewAll link in ShopByBrand is invalid");
	
	}
}