package com.tsc.test.tests.productSearchResult;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * BUG-20633 - PRP Page - Pagination on PRP page incorrect
 * BUG-20719 - [POST PROD] PRP breaks when products have more than 16 variants and no swatches
 */
public class SR_TC18_VerifyProductSearchResult_ItemCountMoreThanSixteen extends BaseTest {

    @Test(groups={"ProductSearch","Regression"})
    public void SR_TC18_VerifyProductSearchResult_ItemCountMoreThanSixteen() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");
        reporter.reportLog("ProductSearch Page");

        //Arrange - Getting Test Data
        List<String> searchKeywordList = TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
        String basePRPPageURL = System.getProperty("QaUrl")+TestDataHandler.constantData.getSearchResultPage().getLbl_prp_partial_url();
        String defaultPageSetting = TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
        List<String> productWithMoreThanSixteenSize = TestDataHandler.constantData.getSearchResultPage().getLst_SearchOption().get(8).getFilterOption().get(1);

        //Act & Assert - Verification of BUG-20633 - PRP Page - Pagination on PRP page incorrect
        Map<String,String> pageData = getApiResponseThreadLocal().getProductLastPageWhenPagesMoreThanOne(searchKeywordList,null,5,defaultPageSetting,basePRPPageURL);
        getProductResultsPageThreadLocal().getSearchResultLoad(pageData.get("searchTerm"),true);
        reporter.reportLog("Search keyword: "+pageData.get("searchTerm"));
        getProductResultsPageThreadLocal().verifyPaginationCountOnLastPage(pageData);

        //Act - BUG-20719 - [POST PROD] PRP breaks when products have more than 16 variants and no swatches
        boolean productFound = getProductResultsPageThreadLocal().loadProductOnPRPPageForItemWithMoreThanSixteenVariantsAndNoSwatch(productWithMoreThanSixteenSize,defaultPageSetting);
        //Assert
        if(productFound)
            getProductResultsPageThreadLocal().selectAndVerifyProductColor();
        else
            //reporter.reportLogFail("No Product Found to test!!");
            reporter.reportLog("No Product Found to test for Prod Bug 20719 (PRP breaks when products have more than 16 variants and no swatches)");
    }
}
