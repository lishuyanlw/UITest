package com.tsc.test.tests.productSearchResult;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * BUG-19768 - [PR Defect] PRP url parameters should not be hardcoded
 * BUG-19769 - PRP shows no results when dimensions is missing in the PRP page URL or when no parameters are specified
 */
public class SR_TC15_Verify_ProductSearchResult_SearchProductWithAPI extends BaseTest {
    @Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
    public void verify_productSearchResult_ApiCall(){
        //Closing the popup appearing on screen after application launch
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //Fetching Test Data
        String prpPagePartialURL = TestDataHandler.constantData.getSearchResultPage().getLbl_prp_partial_url();
        List<List<String>> prpApiCallParameterData = TestDataHandler.constantData.getSearchResultPage().getLst_SearchOption().get(7).getFilterOption();

        //verification of prp page by loading url in browser
        //BUG-19768 - [PR Defect] PRP url parameters should not be hardcoded
        List<String> prpURL = getApiResponseThreadLocal().getAPIURLForInputModuleAndParameter(prpPagePartialURL,prpApiCallParameterData);
        getProductResultsPageThreadLocal().verifyPRPPageAfterLoadingDataUsingAPIParameter(prpURL);
    }
}
