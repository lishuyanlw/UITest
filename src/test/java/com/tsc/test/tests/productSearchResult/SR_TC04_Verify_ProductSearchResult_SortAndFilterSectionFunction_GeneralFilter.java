package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;

import com.tsc.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC04_Verify_ProductSearchResult_SortAndFilterSectionFunction_GeneralFilter extends BaseTest{
	/*
	 * CER-220
	 * CER-221
	 * CER-229
	 * CER-223
	 * CER-224
	 * CER-233
	 * CER-631
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
	public void validateProductSearchResult_FilterSectionFunction_GeneralFilter() throws IOException {
		(new HomePage(this.getDriver())).closeadd();

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductSearch Page");

		List<List<String>> lsKeywordList = TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
		List<String> lstSearchResultMessage = TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
		String lsSearchResultPageDefaultSetting = TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
		List<WebElement> productList;
		String lsMsg;

		getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));

		String lsTestModel = getProductResultsPageThreadLocal().judgeTestModel();

		//Test General filter option
		reporter.reportLog("General Filters");
		List<List<String>> lstGeneralTwoLevelFilterOption = TestDataHandler.constantData.getSearchResultPage().getLst_SearchOption().get(0).getFilterOption();
		for (List<String> lstItem : lstGeneralTwoLevelFilterOption) {
			reporter.reportLog(lstItem.get(0) + " : " + lstItem.get(1));
			if (getProductResultsPageThreadLocal().selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1))) {
				reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(0).get(0)), "The Url contains correct dimensions and keyword", "The Url does not contain correct dimensions and keyword");
				if (!lsTestModel.equalsIgnoreCase("BannerImageSearch")) {
					lsMsg = getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0), lsKeywordList.get(0).get(0));
					if (lsMsg.isEmpty()) {
						reporter.reportLogPass("Search result message result of '" + getProductResultsPageThreadLocal().lsSearchResultMessage + "' matches the expected message");
					} else {
						reporter.reportLogFail(lsMsg);
					}
				}

				reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
				if (!(System.getProperty("Device").equalsIgnoreCase("Mobile"))) {
					reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is " + lsSearchResultPageDefaultSetting, "The default setting of items per page isn't " + lsSearchResultPageDefaultSetting);
				}

				productList = getProductResultsPageThreadLocal().getProductList();
				if (productList.size() > 0) {
					getProductResultsPageThreadLocal().verifySearchResultContent(productList);
				}

				reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
				reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getHeaderContainer()), "Header section is existing after choosing filters", "Header section is not existing after choosing filters");
				reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getFooterContainer()), "Footer section is existing after choosing filters", "Footer section is not existing after choosing filters");
			} else {
				reporter.reportLogFail("Choosing filter of " + "'" + lstItem.get(0) + "/" + lstItem.get(1) + "' failed");
			}

			//To recover the initial test environment
			if (getProductResultsPageThreadLocal().getClearAllFiltersButtonStatus()) {
				getProductResultsPageThreadLocal().closeAllSelectedFilters();
			} else {
				if (System.getProperty("Device").equalsIgnoreCase("Mobile")) {
					getProductResultsPage_MobileThreadLocal().cancelButton.click();
					getProductResultsPageThreadLocal().waitForPageLoading();
				}
				getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
			}
		}

	}
}

