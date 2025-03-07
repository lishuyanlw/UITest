package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC16_VerifyProductDetail_WriteReview extends BaseTest{
	/*
	 * CER-592
	 * CER-593
	 * CER-594
	 * CER-595
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC16_VerifyProductDetail_WriteReview() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstTitle=TestDataHandler.constantData.getSearchResultPage().getLst_WriteReviewSubmitMessage();
		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		//List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_BackUpSearchingKeyword();

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("video", "-1");
		outputDataCriteria.put("style", "1");
		outputDataCriteria.put("size", "1");
		outputDataCriteria.put("quantity", "2");
		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"AllConditionsWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			if(getProductDetailPageThreadLocal().goToProductReviewSection()) {
				reporter.reportLog("Open Write a review window");
				getProductDetailPageThreadLocal().openWriteReview();

				reporter.reportLog("Check the contents of Write a review window");
				getProductDetailPageThreadLocal().verifyWriteReviewContent();

				reporter.reportLog("Check the alert message");
				getProductDetailPageThreadLocal().verifyWriteReviewAfterFailSubmitValidationMessage();

				if(!System.getProperty("Browser").equalsIgnoreCase("sauceioschrome")){
					reporter.reportLog("Verify the message after submitting");
					getProductDetailPageThreadLocal().verifyWriteReviewAfterSuccessfulSubmitMessage(lstTitle.get(0), lstTitle.get(1));

					reporter.reportLog("Verify continue shopping action");
					getProductDetailPageThreadLocal().verifyWriteReviewAfterSubmitContinueShoppingBackToProductDetails();
				}else
					reporter.reportLog("Write Review functionality is not tested for ios Mobile and Tablet as Review Comment are not accepted via automation");
			}
			else {
				reporter.reportLogFail("Unable to go to Review Tab");
			}
		}
		else {
			reporter.reportLogFail("Unable to find the product item with Review, EasyPay, Swatch item>=4 and Video");
		}
	}
}

