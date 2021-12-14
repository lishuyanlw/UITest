package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC03_Verify_ProductDetail_StickyTab extends BaseTest{
	/*
	 * CER-573
	 * CER-574
	 * CER-589
	 * CER-590
	 * CER-591
	 */
	@Test(groups={"ProductDetail","Regression"})
	public void validateStickyTab() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	BasePage basePage=new BasePage(this.getDriver());
		
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductDetail Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	
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
			//reporter.softAssert(getProductDetailPageThreadLocal().getStickyTabSelectedStatus(getProductDetailPageThreadLocal().btnStickyTabProductReview),"The Review tab has been selected and undrlined correctly","The Review tab has not been selected and underlined correctly");
						
			reporter.reportLog("Review tab content");
			getProductDetailPageThreadLocal().verifyReviewTabContent();
			
			reporter.reportLog("Review tab review list contents");
			getProductDetailPageThreadLocal().verifyReviewTabPerReviewListContents();
			String lsMsg=getProductDetailPageThreadLocal().checkReviewRateSortingBy(true);
			if(lsMsg.isEmpty()||lsMsg.contains("less than 2")) {
				reporter.reportLogPass("Sorting by Highest rated passed!");
			}
			else {
				reporter.reportLogFail("Sorting by Highest rated Failed due to "+lsMsg);
			}
			
			getProductDetailPageThreadLocal().chooseReviewSortingOption("Lowest Rated");
			lsMsg=getProductDetailPageThreadLocal().checkReviewRateSortingBy(false);
			if(lsMsg.isEmpty()||lsMsg.contains("less than 2")) {
				reporter.reportLogPass("Sorting by Lowest rated passed!");
			}
			else {
				reporter.reportLogFail("Sorting by Lowest rated Failed due to "+lsMsg);
			}
			
			reporter.reportLog("Review tab Footer, Back to Top, Pagination");
			getProductDetailPageThreadLocal().verifyReviewTabFooterAndBackToTopAndPagination();		
		}
		else {
			reporter.reportLogFail("Unable to go to Review Tab");
		}
		
		reporter.reportLog("See More button action and Product overview content");
		getProductDetailPageThreadLocal().verifyClickingSeeMoreButtonAction();
		getProductDetailPageThreadLocal().verifyProductOverviewContent();
		
		reporter.reportLog("Verify sticky tab clicking actions");
		getProductDetailPageThreadLocal().verifyStickyTabClickingAction();
		
		reporter.reportLog("Verify product brand name link");
		getProductDetailPageThreadLocal().verifyProductBrandNameRedirectAction();
	}
	else {
		reporter.reportLogFail("Unable to find the product item with Brand name, Review, and See More info");
	}
	
}

}

