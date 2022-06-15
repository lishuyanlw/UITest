package com.tsc.test.tests.productDetail;

import java.io.IOException;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC14_VerifyProductDetail_GetTheLookSectionAndRecommendationSection extends BaseTest{
	/*
	 * CER-596
	 * CER-597
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC14_VerifyProductDetail_GetTheLookSectionAndRecommendationSection() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		String lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLbl_ProductNumberWithBandAndReviewAndSeeMore();

		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		//if(getProductResultsPageThreadLocal().goToFirstProductItem("402783")) {

		if(getProductResultsPageThreadLocal().getSearchResultLoad(lsKeyword,true)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=lsKeyword;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify Get the look contents");
			getProductDetailPageThreadLocal().verifyGetTheLookSection();

			reporter.reportLog("Verify Prev and Next buttons in Get the look section");
			getProductDetailPageThreadLocal().verifyPrevAndNextButtonActionInGetTheLookSection();

			reporter.reportLog("Verifying Product Recommendation section details");
			getProductResultsPageThreadLocal().verify_ProductRecommendationSection();
		}
		else {
			reporter.reportLogFail("Unable to find the product item with SeeMore info");
		}
	}
}

