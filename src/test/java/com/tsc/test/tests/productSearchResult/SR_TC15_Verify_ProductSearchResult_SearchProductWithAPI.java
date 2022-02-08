package com.tsc.test.tests.productSearchResult;

import com.tsc.api.pojo.Product;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

/**
 * BUG-19768 - [PR Defect] PRP url parameters should not be hardcoded
 * BUG-19769 - PRP shows no results when dimension is missing in the PRP page URL or when no parameters are specified
 * BUG-19789 - PRP left nav should display all available facets -- "category" facet is missing on search results.
 */
public class SR_TC15_Verify_ProductSearchResult_SearchProductWithAPI extends BaseTest {
    @Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
    public void verify_productSearchResult_ApiCall(){
        //Closing the popup appearing on screen after application launch
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //Fetching Test Data
        String prpPagePartialURL = TestDataHandler.constantData.getSearchResultPage().getLbl_prp_partial_url();
        List<List<String>> prpApiCallParameterData = TestDataHandler.constantData.getSearchResultPage().getLst_SearchOption().get(7).getFilterOption();
        HashMap<String,String> prpURL;

        //BUG-19789 - PRP left nav should display all available facets -- "category" facet is missing on search results.
        List<Product.DimensionStates> categoryDimension = getApiResponseThreadLocal().getProductCategoryCategory("casper","3000786");
        getProductResultsPageThreadLocal().verifyCategoryDetailsOnPRPForProduct(categoryDimension,"casper");

        //verification of prp page by loading url in browser
        //BUG-19768 - [PR Defect] PRP url parameters should not be hardcoded
        prpURL = getApiResponseThreadLocal().getAPIURLForInputModuleAndParameterOrDefaultValues(prpPagePartialURL,prpApiCallParameterData,"All",null);
        getProductResultsPageThreadLocal().verifyPRPPageAfterLoadingDataUsingAPIParameter(prpURL);

        //BUG-19769 - PRP shows no results when dimensions is missing in the PRP page URL or when no parameters are specified
        prpURL = getApiResponseThreadLocal().getAPIURLForInputModuleAndParameterOrDefaultValues(prpPagePartialURL,null,"None","Silver");
        getProductResultsPageThreadLocal().verifyPRPPageAfterLoadingDataUsingAPIParameter(prpURL);

    }
}
