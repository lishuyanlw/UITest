package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;

import com.tsc.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC08_Verify_ProductSearchResult_PaginationTest extends BaseTest{
	/*
	 * CER-232
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
	public void validateProductSearchResult_PaginationFunction() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	String lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword().get(1);
	List<String> lstSearchResultMessage=TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
	List<WebElement> productList;
	String lsMsg;
	String lsCurrentPageFirstProductName,lsPreviousPageFirstProductName,lsNextPageFirstProductName;
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeyword);
	lsCurrentPageFirstProductName=getProductResultsPageThreadLocal().getFirstProductName();
	String lsTestModel=getProductResultsPageThreadLocal().judgeTestModel();	
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeyword), "The Url contains correct dimensions and keyword", "The Url does not contain correct dimensions and keyword");
	
	if(!lsTestModel.equalsIgnoreCase("BannerImageSearch")) {
		lsMsg=getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeyword);
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
	
	boolean bNextPage=getProductResultsPageThreadLocal().switchPage(true);
	if(!bNextPage) {
		reporter.reportLogFail("There is no next page available.");
	}
	else {
		lsNextPageFirstProductName=getProductResultsPageThreadLocal().getFirstProductName();
		if(!lsCurrentPageFirstProductName.equalsIgnoreCase(lsNextPageFirstProductName)) {
			reporter.reportLogPass("The next button is working correctly");
		}
		else {
			reporter.reportLogPass("The next button is not working correctly");
		}		
	}
	
	boolean bPrevPage=getProductResultsPageThreadLocal().switchPage(false);
	if(!bPrevPage) {
		reporter.reportLogFail("The prev button is not working correctly.");
	}
	else {
		lsPreviousPageFirstProductName=getProductResultsPageThreadLocal().getFirstProductName();
		if(lsCurrentPageFirstProductName.equalsIgnoreCase(lsPreviousPageFirstProductName)) {
			reporter.reportLogPass("The prev button is working correctly");
		}
		else {
			reporter.reportLogPass("The prev button is not working correctly");
		}		
	}
		
	}
}

