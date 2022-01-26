package com.tsc.test.tests.productSearchResult;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SR_TC04_Verify_ProductSearchResult_SortAndFilterSectionFunction_PriceFilter extends BaseTest {
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
    public void validateProductSearchResult_FilterSectionFunction_PriceFilter() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
        reporter.reportLog("ProductSearch Page");

        List<List<String>> lsKeywordList= TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
        List<String> lstSearchResultMessage=TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
//        String lsSearchResultPageDefaultSetting=TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
        List<WebElement> productList;
        String lsMsg;

        getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0),true);

        String lsTestModel=getProductResultsPageThreadLocal().judgeTestModel();

        //Test filter by price
        reporter.reportLog("Price filter");
        List<List<String>> lstFilterByPrice=TestDataHandler.constantData.getSearchResultPage().getLst_SearchOption().get(1).getFilterOption();
        for(List<String> lstItem:lstFilterByPrice) {
            reporter.reportLog(lstItem.get(0)+" : "+lstItem.get(1));
            if(getProductResultsPageThreadLocal().selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1))) {
                //To verify the first item
                lsMsg=getProductResultsPageThreadLocal().verifyFilterByPrice(lstItem.get(2),true);
                if(lsMsg.isEmpty()) {
                    reporter.reportLogPass("The first item for filter by price works");
                }else {
                    reporter.reportLogFail(lsMsg);
                }
                //To verify all items
                lsMsg=getProductResultsPageThreadLocal().verifyFilterByPrice(lstItem.get(2),false);
                if(lsMsg.isEmpty()) {
                    reporter.reportLogPass("Filter by price works");
                }else {
                    reporter.reportLogFail(lsMsg);
                }
                reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(0).get(0)), "The Url contains correct keyword", "The Url does not contain correct keyword");

                if(!lsTestModel.equalsIgnoreCase("BannerImageSearch")) {
                    lsMsg=getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeywordList.get(0).get(0));
                    if(lsMsg.isEmpty()) {
                        reporter.reportLogPass("Search result message result of '"+getProductResultsPageThreadLocal().lsSearchResultMessage+"' matches the expected message");
                    }else {
                        reporter.reportLogFail(lsMsg);
                    }
                }

                reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");

                productList=getProductResultsPageThreadLocal().getProductList();
                if(productList.size()>0) {
                    getProductResultsPageThreadLocal().verifySearchResultContent(productList);
                    getProductResultsPageThreadLocal().verifySearchResultContentWithMouseHover(productList);
                }

                reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
            }
            else {
                reporter.reportLogFail("Choosing filter of "+lstItem.get(0)+"/"+lstItem.get(1)+" failed");
            }
            getProductResultsPageThreadLocal().closeAllSelectedFilters();
        }

    }
}
