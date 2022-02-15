package com.tsc.test.tests.productSearchResult;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class SR_TC04_VerifyProductSearchResultWithSortAndFilter extends BaseTest {
    /*
     * CER-220
     * CER-221
     * CER-229
     * CER-223
     * CER-224
     * CER-233
     * CER-631
     * Bug 19117: PRP - Sorting Brand A-Z, not working
     * Bug 19734: PRP: Sorting filter is not retained when going past page 1
     * Bug 19628: [QA Defect - P3] PRP: no products display if user is on the last page and select a faucet from the left nav - covered in selectFilterItemInLeftPanel() function
     */
    @Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
    public void SR_TC04_VerifyProductSearchResultWithSortAndFilter() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");
        reporter.reportLog("ProductSearch Page");

        String lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword().get(2);
        List<String> lstSearchResultMessage = TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
//        String lsSearchResultPageDefaultSetting = TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
        List<WebElement> productList;
        String lsMsg;
        List<String> lstSortByOptions = TestDataHandler.constantData.getSearchResultPage().getLst_Filter_Data();

        getProductResultsPageThreadLocal().getSearchResultLoad(lsKeyword,false);

        String lsTestModel = getProductResultsPageThreadLocal().judgeTestModel();

        //Test sort
        reporter.reportLog("Price: Highest First");
        if (getProductResultsPageThreadLocal().chooseSortOptionByVisibleText(lstSortByOptions.get(0))) {        	
            lsMsg = getProductResultsPageThreadLocal().verifyPriceFirstSort(true);
          
            if (lsMsg.isEmpty()) {
                reporter.reportLogPass("Sort option of Price: Highest First works for the first page");
                
                getProductResultsPageThreadLocal().switchPage(true);
                lsMsg = getProductResultsPageThreadLocal().verifyPriceFirstSort(true);
                if (lsMsg.isEmpty()) {
                    reporter.reportLogPass("Sort option of Price: Highest First works for the second page");   
                } else {
                    reporter.reportLogFail(lsMsg);
                }
            } else {
                reporter.reportLogFail(lsMsg);
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlAfterSelectSortStrategy(lsKeyword, "HighestPrice"), "The Url contains keyword and sortKey=HighestPrice", "The Url does not contain keyword and sortKey=HighestPrice");

            if (!lsTestModel.equalsIgnoreCase("BannerImageSearch")) {
                lsMsg = getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0), lsKeyword);
                if (lsMsg.isEmpty()) {
                    reporter.reportLogPass("Search result message result of '" + getProductResultsPageThreadLocal().lsSearchResultMessage + "' matches the expected message");
                } else {
                    reporter.reportLogFail(lsMsg);
                }
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
            /*
            productList = getProductResultsPageThreadLocal().getProductList();
            if (productList.size() > 0) {
               getProductResultsPageThreadLocal().verifySearchResultContent(productList);
               getProductResultsPageThreadLocal().verifySearchResultContentWithMouseHover(productList);
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
            reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getHeaderContainer()), "Header section is existing after choosing sorting options", "Header section is not existing after choosing sorting options");
            reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getFooterContainer()), "Footer section is existing after choosing sorting options", "Footer section is not existing after choosing sorting options");
            */
        } else {
            reporter.reportLogFail("Choosing Price: Highest first option failed");
        }
        
        //Test sort
        reporter.reportLog("Price: Lowest First");
        if (getProductResultsPageThreadLocal().chooseSortOptionByVisibleText(lstSortByOptions.get(1))) {        	
            lsMsg = getProductResultsPageThreadLocal().verifyPriceFirstSort(false);
          
            if (lsMsg.isEmpty()) {
                reporter.reportLogPass("Sort option of Price: Lowest First works for the first page");
                getProductResultsPageThreadLocal().switchPage(true);
                lsMsg = getProductResultsPageThreadLocal().verifyPriceFirstSort(false);
                if (lsMsg.isEmpty()) {
                    reporter.reportLogPass("Sort option of Price: Lowest First works for the second page");   
                } else {
                    reporter.reportLogFail(lsMsg);
                }
            } else {
                reporter.reportLogFail(lsMsg);
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlAfterSelectSortStrategy(lsKeyword, "LowestPrice"), "The Url contains keyword and sortKey=HighestPrice", "The Url does not contain keyword and sortKey=HighestPrice");

            if (!lsTestModel.equalsIgnoreCase("BannerImageSearch")) {
                lsMsg = getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0), lsKeyword);
                if (lsMsg.isEmpty()) {
                    reporter.reportLogPass("Search result message result of '" + getProductResultsPageThreadLocal().lsSearchResultMessage + "' matches the expected message");
                } else {
                    reporter.reportLogFail(lsMsg);
                }
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
            /*
            productList = getProductResultsPageThreadLocal().getProductList();
            if (productList.size() > 0) {
               getProductResultsPageThreadLocal().verifySearchResultContent(productList);
               getProductResultsPageThreadLocal().verifySearchResultContentWithMouseHover(productList);
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
            reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getHeaderContainer()), "Header section is existing after choosing sorting options", "Header section is not existing after choosing sorting options");
            reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getFooterContainer()), "Footer section is existing after choosing sorting options", "Footer section is not existing after choosing sorting options");
            */
        } else {
            reporter.reportLogFail("Choosing Price: Lowest first option failed");
        }
        
        //Test sort
        reporter.reportLog("Reviews: Highest First");
        if (getProductResultsPageThreadLocal().chooseSortOptionByVisibleText(lstSortByOptions.get(2))) {        	
            lsMsg = getProductResultsPageThreadLocal().verifyHighestReviewFirstSort();
          
            if (lsMsg.isEmpty()) {
                reporter.reportLogPass("Sort option of Reviews: Highest First works for the first page");
                getProductResultsPageThreadLocal().switchPage(true);
                lsMsg = getProductResultsPageThreadLocal().verifyHighestReviewFirstSort();
                if (lsMsg.isEmpty()) {
                    reporter.reportLogPass("Sort option of Reviews: Highest First works for the second page");                    
                } else {
                    reporter.reportLogFail(lsMsg);
                }
            } else {
                reporter.reportLogFail(lsMsg);
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlAfterSelectSortStrategy(lsKeyword, "HighestReviews"), "The Url contains keyword and sortKey=HighestPrice", "The Url does not contain keyword and sortKey=HighestPrice");

            if (!lsTestModel.equalsIgnoreCase("BannerImageSearch")) {
                lsMsg = getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0), lsKeyword);
                if (lsMsg.isEmpty()) {
                    reporter.reportLogPass("Search result message result of '" + getProductResultsPageThreadLocal().lsSearchResultMessage + "' matches the expected message");
                } else {
                    reporter.reportLogFail(lsMsg);
                }
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
            /*
            productList = getProductResultsPageThreadLocal().getProductList();
            if (productList.size() > 0) {
               getProductResultsPageThreadLocal().verifySearchResultContent(productList);
               getProductResultsPageThreadLocal().verifySearchResultContentWithMouseHover(productList);
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
            reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getHeaderContainer()), "Header section is existing after choosing sorting options", "Header section is not existing after choosing sorting options");
            reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getFooterContainer()), "Footer section is existing after choosing sorting options", "Footer section is not existing after choosing sorting options");
            */
        } else {
            reporter.reportLogFail("Choosing Reviews: Highest first option failed");
        }
        
        //Test sort
        reporter.reportLog("Brand Name: A to Z");
        if (getProductResultsPageThreadLocal().chooseSortOptionByVisibleText(lstSortByOptions.get(3))) {        	
            lsMsg = getProductResultsPageThreadLocal().verifyBrandNameOrderByAlphabet();
          
            if (lsMsg.isEmpty()) {
                reporter.reportLogPass("Sort option of Brand Name: A to Z works for the first page");
                getProductResultsPageThreadLocal().switchPage(true);
                lsMsg = getProductResultsPageThreadLocal().verifyBrandNameOrderByAlphabet();
                if (lsMsg.isEmpty()) {
                    reporter.reportLogPass("Sort option of Brand Name: A to Z works for the second page");                    
                } else {
                    reporter.reportLogFail(lsMsg);
                }
            } else {
                reporter.reportLogFail(lsMsg);
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlAfterSelectSortStrategy(lsKeyword, "BrandNameAtoZ"), "The Url contains keyword and sortKey=HighestPrice", "The Url does not contain keyword and sortKey=HighestPrice");

            if (!lsTestModel.equalsIgnoreCase("BannerImageSearch")) {
                lsMsg = getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0), lsKeyword);
                if (lsMsg.isEmpty()) {
                    reporter.reportLogPass("Search result message result of '" + getProductResultsPageThreadLocal().lsSearchResultMessage + "' matches the expected message");
                } else {
                    reporter.reportLogFail(lsMsg);
                }
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");

            /*
            productList = getProductResultsPageThreadLocal().getProductList();
            if (productList.size() > 0) {
               getProductResultsPageThreadLocal().verifySearchResultContent(productList);
               getProductResultsPageThreadLocal().verifySearchResultContentWithMouseHover(productList);
            }

            reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
            reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getHeaderContainer()), "Header section is existing after choosing sorting options", "Header section is not existing after choosing sorting options");
            reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getFooterContainer()), "Footer section is existing after choosing sorting options", "Footer section is not existing after choosing sorting options");
            */
        } else {
            reporter.reportLogFail("Choosing Brand Name: A to Z option failed");
        }
    }
}
