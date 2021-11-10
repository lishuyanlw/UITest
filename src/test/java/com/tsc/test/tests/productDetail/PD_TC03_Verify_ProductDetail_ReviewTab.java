package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC03_Verify_ProductDetail_ReviewTab extends BaseTest{
	/*
	 * CER-573
	 * CER-574
	 */
	@Test(groups={"ProductDetail","Regression"})
	public void validateReviewTab() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	BasePage basePage=new BasePage(this.getDriver());
		
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductDetail Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantDataOldVariables.getlst_SearchKeyword_DropDown();
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	reporter.reportLog("Switch to ProductDetail page");
	String lsProductNumber,lsUrl;
	if(getProductResultsPageThreadLocal().goToProductItemWithReviewAndSwatchAndVideo()) {
		reporter.reportLog("Verify URL");
		lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productConvertedNumber;
		lsUrl=basePage.URL();
		reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
		reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);
		
		if(getProductDetailPageThreadLocal().goToProductReviewTab()) {
			reporter.softAssert(getProductDetailPageThreadLocal().getStickyTabSelectedStatus(getProductDetailPageThreadLocal().btnStickyTabProductReview),"The Review tab has been selected correctly","The Review tab has not been selected correctly");
			
			reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblReviewTabHeader).isEmpty(),"The Review tab header is not empty","The Review tab header is empty");
			reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().imgReviewTabHistogram),"The Review tab histogram is displaying correctly","The Review tab histogram is not displaying correctly");
			reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblReviewTabRateDecimalText).isEmpty(),"The Review tab rate number is not empty","The Review tab rate number is empty");
			reporter.softAssert(getProductDetailPageThreadLocal().lstReviewTabStar.size()>0,"The product review tab star count is greater than 0","The product review tab star count is not greater than 0");
			reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblReviewTabReviewCount).isEmpty(),"The Review count message is not empty","The Review count message is empty");
			reporter.softAssert(!basePage.getElementHref(getProductDetailPageThreadLocal().lnkReviewTabWriteReview).isEmpty(),"The Write Review link is not empty","The Write Review link is empty");			
			reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblReviewTabRateDecimalText).isEmpty(),"The Review tab rate number is not empty","The Review tab rate number is empty");
			
			reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().selectReviewTabSortBy),"The Review sorting is displaying correctly","The Review sorting is not displaying correctly");
			getProductDetailPageThreadLocal().verifyReviewTabPerReviewListContents();
			String lsMsg=getProductDetailPageThreadLocal().checkReviewRateSortingBy(true);
			if(lsMsg.isEmpty()) {
				reporter.reportLogPass("Sorting by Highest rated passed!");
			}
			else {
				reporter.reportLogFail("Sorting by Highest rated Failed due to "+lsMsg);
			}
			
			getProductDetailPageThreadLocal().chooseReviewSortingOption("Lowest Rated");
			lsMsg=getProductDetailPageThreadLocal().checkReviewRateSortingBy(false);
			if(lsMsg.isEmpty()) {
				reporter.reportLogPass("Sorting by Lowest rated passed!");
			}
			else {
				reporter.reportLogFail("Sorting by Lowest rated Failed due to "+lsMsg);
			}
			
			reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblReviewTabDisplayingReviewMsg).isEmpty(),"The Review message in Review tab footer is not empty","The Review message in Review tab footer is empty");
			reporter.softAssert(!basePage.getElementHref(getProductDetailPageThreadLocal().lnkReviewTabBackToTop).isEmpty(),"The BackToTop link is not empty","The BackToTop link is empty");
			reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().cntReviewTabPagination),"The Review pagination section is displaying correctly","The Review pagination section is not displaying correctly");
						
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

