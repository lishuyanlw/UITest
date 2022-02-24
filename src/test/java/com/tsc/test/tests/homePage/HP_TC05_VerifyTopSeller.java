package com.tsc.test.tests.homePage;

import java.io.IOException;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC05_VerifyTopSeller extends BaseTest{
	/*
	 * CER-204
	 */
	@Test(groups={"Home","Regression"})
	public void HP_TC05_VerifyTopSeller() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();
	if(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/")){
		reporter.reportLogPass("TSC url is correct");
	}
	else{
		reporter.reportLogFailWithScreenshot("TSC url is incorrect");
	}
	reporter.reportLog("Home Page");
	
	validateText(homePageThreadLocal().getTopSellerHeaderText(), TestDataHandler.constantData.getHomePage().getLbl_TopSellers(), "<Recommentdation product> text is visible and valid");

	if(homePageThreadLocal().validateTopSellerIsAboveFooter()){
		reporter.reportLogPass("The TopSeller section is above Footer section");
	}
	else{
		reporter.reportLogFailWithScreenshot("The TopSeller section isn't above Footer section");
	}

	if(homePageThreadLocal().validateTopSellerHref()){
		reporter.reportLogPass("All products in TopSeller have valid links");
	}
	else{
		reporter.reportLogFailWithScreenshot("some products in TopSeller haven't valid links");
	}

	if(homePageThreadLocal().validateTopSellerImg()){
		reporter.reportLogPass("All products in TopSeller have valid image sources");
	}
	else{
		reporter.reportLogFailWithScreenshot("some products in TopSeller haven't valid image sources");
	}

	if(homePageThreadLocal().validateTopSellerName()){
		reporter.reportLogPass("All products in TopSeller have valid names");
	}
	else{
		reporter.reportLogFailWithScreenshot("some products in TopSeller haven't valid names");
	}

	if(homePageThreadLocal().validateTopSellerNowPrice()){
		reporter.reportLogPass("All products in TopSeller have valid  NowPrice contents");
	}
	else{
		reporter.reportLogFailWithScreenshot("some products in TopSeller haven't valid NowPrice contents");
	}

	if(homePageThreadLocal().validateTopSellerWasPrice()){
		reporter.reportLogPass("All products in TopSeller have valid  WasPrice contents");
	}
	else{
		reporter.reportLogFailWithScreenshot("some products in TopSeller haven't valid WasPrice contents");
	}

	}

}