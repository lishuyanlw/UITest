package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC04_Verify_ProductDetail_ProductStyle extends BaseTest{
	/*
	 * CER-575
	 * CER-576
	 * CER-577
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void validateLeftSection_ProductStyle() throws IOException {
		//We don't need to close popup dialog if use api to navigate to PDP page directly.
		getGlobalFooterPageThreadLocal().closePopupDialog();

		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();

		String lsProductNumber,lsUrl;
		if(getProductDetailPageThreadLocal().goToProductItemWithProductNumber("402783")){
		//if(getProductResultsPageThreadLocal().goToFirstProductItem("402783")) {
		//Below API method is giving product that has just 1 swatch that is available and 2 other are
		//sold out. Hence we are not able to verify different style as per function
		//verifyStyleNameWithDifferentStyleSelection. We need a product with multiple swatch and no sold out
		//if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"AddToBag")) {
			reporter.reportLog("Verify URL");
			//lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.reportLog("Switch to ProductDetail page");
			//reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify product style name");
			getProductDetailPageThreadLocal().verifyStyleNameWithDifferentStyleSelection();

			reporter.reportLog("Verify linkage among Swatch, Thumbnail and Zoom image");
			getProductDetailPageThreadLocal().verifyLinkageAmongSwathAndThumbnailAndZoomImage();

			reporter.reportLog("The linkage between Thumbnail and Zoom image");
			getProductDetailPageThreadLocal().verifyLinkageBetweenThumbnailAndZoomImage();
		}
		else {
			reporter.reportLogFail("Unable to find the product item with Review, EasyPay, Swatch item>=4 and Video");
		}
	}
}

