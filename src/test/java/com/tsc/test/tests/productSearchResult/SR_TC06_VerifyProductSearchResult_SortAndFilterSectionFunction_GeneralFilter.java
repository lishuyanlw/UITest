package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC06_VerifyProductSearchResult_SortAndFilterSectionFunction_GeneralFilter extends BaseTest{
	/*
	 * CER-220
	 * CER-221
	 * CER-229
	 * CER-223
	 * CER-224
	 * CER-233
	 * CER-631
	 * Bug-19680 - Change the placeholder text in the brand section - Search Product using magnifying glass icon
	 * Bug 19389: PRP Filter Panel - Shop by Category selection does not work as intended - covered in verifyUrlPatternAfterSelectFilter function
	 * Bug 19556: [QA Defect - P3] PRP: when selecting a subcategory from Shop by category, the dimension in the URL should start over not appending - covered in verifyUrlPatternAfterSelectFilter function
	 * Bug 19557: [QA Defect - P3] when selecting the checkbox options in the left nav, the dimension IDs in the URL should use pipe character not... - covered in verifyUrlPatternAfterSelectFilter function
	 * Bug 19745: [Release Defect - P3] the filter menu in PRP iOS is covered by a panel and can't be closed /cancelled
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile","FixedTestData"})
	public void SR_TC06_VerifyProductSearchResult_SortAndFilterSectionFunction_GeneralFilter() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductSearch Page");

		List<List<String>> lsKeywordList = TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
		List<String> lstSearchResultMessage = TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
//		String lsSearchResultPageDefaultSetting = TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
		List<WebElement> productList;
		String lsMsg;

		getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0),false);

		String lsTestModel = getProductResultsPageThreadLocal().judgeTestModel();

		//Test General filter option
		reporter.reportLog("General Filters");
		List<List<String>> lstGeneralTwoLevelFilterOption = TestDataHandler.constantData.getSearchResultPage().getLst_SearchOption().get(0).getFilterOption();
		for (List<String> lstItem : lstGeneralTwoLevelFilterOption) {
			reporter.reportLog(lstItem.get(0) + " : " + lstItem.get(1));
			if(lstItem.get(0).equalsIgnoreCase("category")) {
				getProductResultsPageThreadLocal().bCategoryExpand=true;
			}
			
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

				productList = getProductResultsPageThreadLocal().getProductList();
				if (productList.size() > 0) {
					getProductResultsPageThreadLocal().verifySearchResultContent(productList,true);
//					getProductResultsPageThreadLocal().verifySearchResultContentWithMouseHover(productList);
				}

				reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
			} else {
				reporter.reportLogFail("Choosing filter of " + "'" + lstItem.get(0) + "/" + lstItem.get(1) + "' failed");
			}

			//To recover the initial test environment
			getProductResultsPageThreadLocal().closeAllSelectedFilters();
		}

	}
}

