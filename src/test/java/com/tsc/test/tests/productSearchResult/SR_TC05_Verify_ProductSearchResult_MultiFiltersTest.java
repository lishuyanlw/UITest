package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tsc.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC05_Verify_ProductSearchResult_MultiFiltersTest extends BaseTest{
	/*
	 * CER-225
	 * CER-226
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
	public void validateProductSearchResult_MultiFiltersFunction() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();

	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLog("ProductSearch Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	List<String> lstSearchResultMessage=TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
	List<WebElement> productList;
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));	
	String lsTestModel=getProductResultsPageThreadLocal().judgeTestModel();

	//Test filter option combination
	List<String> lstDisappearAfterSelectFilter=TestDataHandler.constantData.getSearchResultPage().getLst_DisappearAfterSelectFilter();
	List<List<String>> lstFilterCombination=TestDataHandler.constantData.getSearchResultPage().getLst_SearchOption().get(2).getFilterOption();
	String lsMsg="";

	//Save selected firstLevelFilter and secondLevelFilter
	ArrayList<ArrayList<String>> selectedFilters=new ArrayList<ArrayList<String>>();
	getProductResultsPageThreadLocal().bDefault=false;		
	List<String> lstFilter=new ArrayList<String>();
	List<String> lstSelectedSecondLevelFilter=new ArrayList<String>();		
	for(List<String> lstItem:lstFilterCombination) {	
		ArrayList<String> lstTwoLevelFilter=new ArrayList<String>();
		getProductResultsPageThreadLocal().selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1));
		lstSelectedSecondLevelFilter.add(getProductResultsPageThreadLocal().secondLevelFilter);			
		lstFilter.add(lstItem.get(1));
		
		lstTwoLevelFilter.add(getProductResultsPageThreadLocal().firstLevelFilter);
		lstTwoLevelFilter.add(getProductResultsPageThreadLocal().secondLevelFilter);
		selectedFilters.add(lstTwoLevelFilter);
	}
	
	if(getProductResultsPageThreadLocal().bDefault) {
		lsMsg=getProductResultsPageThreadLocal().verifySlectedFiltersContainSecondlevelFilter(lstSelectedSecondLevelFilter,lstDisappearAfterSelectFilter);		
	}
	else {
		lsMsg=getProductResultsPageThreadLocal().verifySlectedFiltersContainSecondlevelFilter(lstFilter,lstDisappearAfterSelectFilter);			
	}
	if(lsMsg.isEmpty()) {
		reporter.reportLogPass("The selected filters contain all search second level filters");
	}else {
		reporter.reportLogFail(lsMsg);
	}
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(0).get(0)), "The Url contains correct dimensions and keyword", "The Url does not contain correct dimensions and keyword");
	
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
	}
	
	//To uncheck the first filter in selected filter options
	getProductResultsPageThreadLocal().selectFilterItemInLeftPanel(selectedFilters.get(0).get(0), selectedFilters.get(0).get(1));
	//Remove the unchecked second level filter from saved second level filter list
	lstSelectedSecondLevelFilter.remove(0);
	lsMsg=getProductResultsPageThreadLocal().verifySlectedFiltersContainSecondlevelFilter(lstSelectedSecondLevelFilter,lstDisappearAfterSelectFilter);
	if(lsMsg.isEmpty()) {
		reporter.reportLogPass("The selected filters contain all search second level filters");
	}else {
		reporter.reportLogFail(lsMsg);
	}
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(0).get(0)), "The Url contains correct dimensions and keyword", "The Url does not contain correct dimensions and keyword");
	
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
	}


	}
}

