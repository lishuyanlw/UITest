package com.tsc.test.tests.productDetail;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class PD_TC10_VerifyProductDetail_AutoDelivery extends BaseTest{
	/*
	 * CER-602
	 *
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC10_VerifyProductDetail_AutoDelivery() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		String lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLbl_AutoDeliverykeyword();
		String lsQuantityNumberToShowLeftItemInfo=TestDataHandler.constantData.getSearchResultPage().getLbl_QuantityNumberToShowLeftItemInfo();

		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		if(getProductResultsPageThreadLocal().getSearchResultLoad(lsKeyword,true)){
			reporter.reportLog("Switch to ProductDetail page");
			lsProductNumber=lsKeyword;
			reporter.reportLog("Verify URL for Product Number: " + lsProductNumber);
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			//reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify product name,brand name and product number");
			getProductDetailPageThreadLocal().verifyProductBasicInfo();

			reporter.reportLog("Verify product price and shipping");
			getProductDetailPageThreadLocal().verifyProductPriceAndShipping();

			reporter.reportLog("Verify product style");
			getProductDetailPageThreadLocal().verifyProductStyle();

			reporter.reportLog("Verify product size");
			getProductDetailPageThreadLocal().verifyProductSize();

			reporter.reportLog("Verify product Add to Bag button");
			getProductDetailPageThreadLocal().verifyProductAddToBagButton();

			reporter.reportLog("Verify product quantity");
			getProductDetailPageThreadLocal().verifyProductQuantityDropdown(Integer.parseInt(lsQuantityNumberToShowLeftItemInfo));

		}
		else {
			reporter.reportLogFail("Unable to find the auto delivery product item");
		}
	}
}

