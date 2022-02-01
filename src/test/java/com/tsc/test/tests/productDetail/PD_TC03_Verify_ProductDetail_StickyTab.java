package com.tsc.test.tests.productDetail;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC03_Verify_ProductDetail_StickyTab extends BaseTest {
	/*
	 * CER-573
	 * CER-574
	 * CER-580
	 * CER-589
	 * CER-590
	 * CER-591
	 * CER-607
	 * Bug-19717 - Issue navigating to brand page from PDP
	 */
	@Test(groups = {"ProductDetail", "Regression", "Regression_Mobile", "Regression_Tablet"})
	public void validateStickyTab() throws IOException {
		if ((System.getProperty("Device").toLowerCase().contains("mobile") &&
				(System.getProperty("Browser").toLowerCase().contains("android"))) ||
				System.getProperty("Device").toLowerCase().contains("tablet") ||
				System.getProperty("Device").toLowerCase().contains("desktop") ||
				(!"".equals(System.getProperty("chromeMobileDevice")) && System.getProperty("chromeMobileDevice").toLowerCase().contains("iphone"))) {
			getGlobalFooterPageThreadLocal().closePopupDialog();
			BasePage basePage = new BasePage(this.getDriver());
			reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");
			reporter.reportLog("ProductDetail Page");

			String lsKeyword = TestDataHandler.constantData.getSearchResultPage().getLbl_ProductNumberWithBandAndReviewAndSeeMore();
			reporter.reportLog("Switch to ProductDetail page");
			String lsProductNumber, lsUrl;
			/*
			"Have to look as how to get product no that has See More Button available as nothing I can find in response from api that can be used
			e.g. 402783 - this has See More button present on screen. ProductReviewCount is also to be considered for this test
			404791 - See More Text in response but not screen
			 */
			/*if(getProductResultsPageThreadLocal().goToFirstProductItem(lsKeyword)) {
				reporter.reportLog("Verify URL");
				lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productNumber;*/
			if(getProductDetailPageThreadLocal().goToProductItemWithProductNumber("402783")){
			//if (getProductResultsPageThreadLocal().goToFirstProductItem("402783")) {
				reporter.reportLog("Verify URL");
				//lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productConvertedNumber;
				lsUrl = basePage.URL();
				reporter.softAssert(lsUrl.contains("productdetails"), "The Url is containing productdetails", "The Url is not containing productdetails");
				//reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

				if (getProductDetailPageThreadLocal().goToProductReviewTab()) {
					if (System.getProperty("Device").equalsIgnoreCase("Desktop")) {
						reporter.softAssert(getProductDetailPageThreadLocal().getStickyTabSelectedStatus(getProductDetailPageThreadLocal().btnStickyTabProductReview), "The Review tab has been selected and undrlined correctly", "The Review tab has not been selected and underlined correctly");
					}

					reporter.reportLog("Review tab content");
					getProductDetailPageThreadLocal().verifyReviewTabContent();

					reporter.reportLog("Review tab review list contents");
					getProductDetailPageThreadLocal().verifyReviewTabPerReviewListContents();
					String lsMsg = getProductDetailPageThreadLocal().checkReviewRateSortingBy(true);
					if (lsMsg.isEmpty() || lsMsg.contains("less than 2")) {
						reporter.reportLogPass("Sorting by Highest rated passed!");
					} else {
						reporter.reportLogFail("Sorting by Highest rated Failed due to " + lsMsg);
					}

					getProductDetailPageThreadLocal().chooseReviewSortingOption("Lowest Rated");
					lsMsg = getProductDetailPageThreadLocal().checkReviewRateSortingBy(false);
					if (lsMsg.isEmpty() || lsMsg.contains("less than 2")) {
						reporter.reportLogPass("Sorting by Lowest rated passed!");
					} else {
						reporter.reportLogFail("Sorting by Lowest rated Failed due to " + lsMsg);
					}

					reporter.reportLog("Review tab Footer, Back to Top, Pagination");
					getProductDetailPageThreadLocal().verifyReviewTabFooterAndBackToTopAndPagination();
				} else {
					reporter.reportLogFail("Unable to go to Review Tab");
				}
				reporter.reportLog("See More button action and Product overview content");
				getProductDetailPageThreadLocal().verifyClickingSeeMoreButtonAction();
				getProductDetailPageThreadLocal().verifyProductOverviewContent();

				reporter.reportLog("Verify sticky tab clicking actions");
				getProductDetailPageThreadLocal().verifyStickyTabClickingAction();

				//Verifying Bug-19717 - Issue navigating to brand page from PDP
				reporter.reportLog("Verify product brand name link");
				getProductDetailPageThreadLocal().verifyProductBrandNameRedirectAction();

				reporter.reportLog("Verify Navigation Back button");
				getProductDetailPageThreadLocal().verifyBreadCrumbNavigationBack();
			} else {
				reporter.reportLogFail("Unable to find the product item with Brand name, Review, and See More info");
			}
		}
	}
}