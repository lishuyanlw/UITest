package com.tsc.test.tests.homePage;

import java.io.IOException;
import org.testng.annotations.Test;
import com.tsc.test.base.BaseTest;
import com.tsc.pages.base.BasePage;
import com.tsc.data.Handler.TestDataHandler;

public class HP_TC04_VerifyShopByBrand extends BaseTest{
	/*
	 * CER-203
	 */
	@Test(groups={"Home","Regression"})
	public void HP_TC04_VerifyShopByBrand() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();
	if(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/")){
		reporter.reportLogPass("TSC url is correct");
	}
	else{
		reporter.reportLogFailWithScreenshot("TSC url is incorrect");
	}

	if(homePageThreadLocal().validateShopByBrandAutomaticScrollingAction()){
		reporter.reportLogPass("The automatic scrolling function in ShopByBrand works well");
	}
	else{
		reporter.reportLogFailWithScreenshot("The The automatic scrolling function in ShopByBrand doesn't work");
	}

	validateText(homePageThreadLocal().validateShopByBrandHeaderText().toUpperCase(), TestDataHandler.constantData.getHomePage().getLbl_ShopByBrand(), "<Shop By Brand> text is visible and valid");

	if(homePageThreadLocal().validateShopByBrandHref()){
		reporter.reportLogPass("All products in ShopByBrand have valid links");
	}
	else{
		reporter.reportLogFailWithScreenshot("Some products in ShopByBrand have no valid links");
	}

	if(homePageThreadLocal().validateShopByBrandImg()){
		reporter.reportLogPass("All products in ShopByBrand have valid image sources");
	}
	else{
		reporter.reportLogFailWithScreenshot("Some products in ShopByBrand have no valid image sources");
	}

	if(homePageThreadLocal().validateShopByBrandClickNextButton()){
		reporter.reportLogPass("The Next button in ShopByBrand works well");
	}
	else{
		reporter.reportLogFailWithScreenshot("The Next button in ShopByBrand doesn't work");
	}

	(new BasePage(this.getDriver())).getReusableActionsInstance().staticWait(2000);

	if(homePageThreadLocal().validateShopByBrandClickPrevButton()){
		reporter.reportLogPass("The Prev button in ShopByBrand works well");
	}
	else{
		reporter.reportLogFailWithScreenshot("The Prev button in ShopByBrand doesn't work");
	}

	if(homePageThreadLocal().validateShopByBrandViewAllLink(TestDataHandler.constantData.getHomePage().getLnk_ShopByBrandViewAll())){
		reporter.reportLogPass("The ViewAll link matches designed pattern");
	}
	else{
		reporter.reportLogFailWithScreenshot("The ViewAll link doesn't match designed pattern");
	}

	if(!homePageThreadLocal().validateShopByBrandUrlAfterClickingViewAllLink().contains(TestDataHandler.constantData.getHeaderSection().getLnk_NotFound())){
		reporter.reportLogPass("The Url after clicking ViewAll link in ShopByBrand is valid");
	}
	else{
		reporter.reportLogFailWithScreenshot("The Url after clicking ViewAll link in ShopByBrand is invalid");
	}

	}
}