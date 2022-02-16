package com.tsc.test.tests.productSearchResult;

import com.tsc.api.apiBuilder.ApiResponse;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BUG-20633 - PRP Page - Pagination on PRP page incorrect
 */
public class SR_TC17_VerifyProductSearchResult_ItemCountMoreThanSixteen extends BaseTest {

    @Test(groups={"ProductSearch","Regression"})
    public void SR_TC17_VerifyProductSearchResult_ItemCountMoreThanSixteen() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");
        reporter.reportLog("ProductSearch Page");

        //Arrange - Getting Test Data
        List<String> searchKeywordList = TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
        String basePRPPageURL = System.getProperty("QaUrl")+TestDataHandler.constantData.getSearchResultPage().getLbl_prp_partial_url();
        Map<String,Object> map = new HashMap<>();
        map.put("rd",1);

        //Act & Assert - Verification of BUG-20633 - PRP Page - Pagination on PRP page incorrect
        Map<String,String> pageData = getApiResponseThreadLocal().getProductLastPageWhenPagesMoreThanOne(searchKeywordList,map,5,"36",basePRPPageURL);
        getProductResultsPageThreadLocal().getSearchResultLoad(pageData.get("searchTerm"),true);
        getProductResultsPageThreadLocal().verifyPaginationCountOnLastPage(pageData);
    }
}
