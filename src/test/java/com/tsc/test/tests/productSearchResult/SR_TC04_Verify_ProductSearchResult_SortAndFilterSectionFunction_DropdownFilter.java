package com.tsc.test.tests.productSearchResult;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SR_TC04_Verify_ProductSearchResult_SortAndFilterSectionFunction_DropdownFilter extends BaseTest {
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
    public void validateProductSearchResult_FilterSectionFunction_DropdownFilter() throws IOException {
        (new HomePage(this.getDriver())).closeadd();

        reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");
        reporter.reportLog("ProductSearch Page");

        List<List<String>> lsKeywordList = TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
        List<String> lstSearchResultMessage = TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
        String lsSearchResultPageDefaultSetting = TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
        List<WebElement> productList;
        String lsMsg;
        List<String> lstSortByOptions = TestDataHandler.constantData.getSearchResultPage().getLst_Filter_Data();

        getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));

        String lsTestModel = getProductResultsPageThreadLocal().judgeTestModel();

        //Test sort
        reporter.reportLog("Price: Highest First");
        if (getProductResultsPageThreadLocal().chooseSortOptionByVisibleText(lstSortByOptions)) {
            lsMsg = getProductResultsPageThreadLocal().verifyHighestPriceFirstSort();
            if (lsMsg.isEmpty()) {
                reporter.reportLogPass("Sort option of Price: Highest First works");
            } else {
                reporter.reportLogFail(lsMsg);
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlAfterSelectSortStrategy(lsKeywordList.get(0).get(0), "HighestPrice"), "The Url contains keyword and sortKey=HighestPrice", "The Url does not contain keyword and sortKey=HighestPrice");

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
            reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getHeaderContainer()), "Header section is existing after choosing sorting options", "Header section is not existing after choosing sorting options");
            reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getFooterContainer()), "Footer section is existing after choosing sorting options", "Footer section is not existing after choosing sorting options");
        } else {
            reporter.reportLogFail("Choosing Price: Highest first option failed");
        }
    }
}
