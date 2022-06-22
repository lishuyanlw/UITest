package com.tsc.test.tests.productDetail;

import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC15_VerifyProductDetail_Accordions extends BaseTest {
	/*
	 * CER-573
	 * CER-574
	 * CER-580
	 * CER-589
	 * CER-590
	 * CER-591
	 * CER-607
	 * Bug-19717 - Issue navigating to brand page from PDP
	 * CER-821 - Havas Change R4 Product Overview and other PDP Accordions
	 */
	@Test(groups = {"ProductDetail", "Regression", "Regression_Mobile", "Regression_Tablet"})
	public void PD_TC15_VerifyProductDetail_Accordions() {
		/**if ((System.getProperty("Device").toLowerCase().contains("mobile") &&
				(System.getProperty("Browser").toLowerCase().contains("android"))) ||
				System.getProperty("Device").toLowerCase().contains("tablet") ||
				System.getProperty("Device").toLowerCase().contains("desktop") ||
				(!"".equals(System.getProperty("chromeMobileDevice")) && System.getProperty("chromeMobileDevice").toLowerCase().contains("iphone"))) {*/
			getGlobalFooterPageThreadLocal().closePopupDialog();
			BasePage basePage = new BasePage(this.getDriver());
			reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");
			reporter.reportLog("ProductDetail Page");

			String lsKeyword = TestDataHandler.constantData.getSearchResultPage().getLbl_ProductNumberWithBandAndReviewAndSeeMore();
			reporter.reportLog("Switch to ProductDetail page");
			String lsProductNumber, lsUrl;

			if(getProductResultsPageThreadLocal().getSearchResultLoad(lsKeyword,true)) {
				reporter.reportLog("Verify URL");
				lsProductNumber=lsKeyword;
				lsUrl = basePage.URL();
				reporter.softAssert(lsUrl.contains("productdetails"), "The Url is containing productdetails", "The Url is not containing productdetails");
				reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

				if (getProductDetailPageThreadLocal().goToProductReviewSection()) {
					reporter.reportLog("Review Histogram");
					getProductDetailPageThreadLocal().verifyReviewHistogramItemClickingAction();

					reporter.reportLog("Review tab content");
					getProductDetailPageThreadLocal().verifyReviewSectionContent();

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
				reporter.reportLog("See More button action and Accordion content");
				//getProductDetailPageThreadLocal().verifyProductOverviewContent();
				getProductDetailPageThreadLocal().verifyAccordionsForProductOnPage();

				reporter.reportLog("Verifying Sizing Chart Navigation");
				getProductDetailPageThreadLocal().verifyAccordionNavigationForSizeGuide();

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
//}