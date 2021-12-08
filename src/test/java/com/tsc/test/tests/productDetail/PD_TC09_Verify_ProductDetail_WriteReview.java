package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC09_Verify_ProductDetail_WriteReview extends BaseTest{
	/*
	 * CER-592
	 * CER-593
	 * CER-594
	 * CER-595
	 */
	@Test(groups={"ProductDetail","Regression"})
	public void validateWriteReview() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	BasePage basePage=new BasePage(this.getDriver());
		
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductDetail Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	List<String> lstTitle=TestDataHandler.constantData.getSearchResultPage().getLst_WriteReviewSubmitMessage();

	//getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	reporter.reportLog("Switch to ProductDetail page");
	String lsProductNumber,lsUrl;
	if(getProductResultsPageThreadLocal().goToFirstProductItem("526457")) {
		reporter.reportLog("Verify URL");
		lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productConvertedNumber;
		lsUrl=basePage.URL();
		reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
		//reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);
	
		if(getProductDetailPageThreadLocal().goToProductReviewTab()) {	
			reporter.reportLog("Open Write a review window");
			getProductDetailPageThreadLocal().openWriteReview();
			
			reporter.reportLog("Check the contents of Write a review window");
			getProductDetailPageThreadLocal().verifyWriteReviewContent();
			
			reporter.reportLog("Check the alert message");
			getProductDetailPageThreadLocal().verifyWriteReviewAfterFailSubmitValidationMessage();
			
			reporter.reportLog("Verify the message after submitting");
			getProductDetailPageThreadLocal().verifyWriteReviewAfterSuccessfulSubmitMessage(lstTitle.get(0), lstTitle.get(1));
			
			reporter.reportLog("Verify continue shopping action");
			getProductDetailPageThreadLocal().verifyWriteReviewAfterSubmitContinueShoppingBackToProductDetails();
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

