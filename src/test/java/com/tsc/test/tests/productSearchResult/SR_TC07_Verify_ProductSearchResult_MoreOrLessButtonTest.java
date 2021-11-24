package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;

import com.tsc.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC07_Verify_ProductSearchResult_MoreOrLessButtonTest extends BaseTest{
	/*
	 * CER-234
	 * CER-235
	 * CER-236
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet"})
	public void validateProductSearchResult_MoreOrLessButtonTest() throws IOException {
	(new HomePage(this.getDriver())).closeadd();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	List<String> lstSearchResultMessage=TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
	List<WebElement> productList;
	List<String> lstMoreButton=TestDataHandler.constantData.getSearchResultPage().getLst_MoreButton();
	String lsMsg;
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	String lsTestModel=getProductResultsPageThreadLocal().judgeTestModel();	
	
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
	if(!(System.getProperty("Device").equalsIgnoreCase("Mobile"))) {
		reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
	}
	
	productList=getProductResultsPageThreadLocal().getProductList();
	if(productList.size()>0) {
		getProductResultsPageThreadLocal().verifySearchResultContent(productList);
	}
	
	for(String lsHeader:lstMoreButton) {
		//Get the element container corresponding to the first level filter
		WebElement element=getProductResultsPageThreadLocal().getFilterContainerWithSpecificFirstlevelFilterInLeftPanel(lsHeader);
		if(element==null) {
			break;
		}
		int visibleElementCountBeforeClick=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,true);
		int hiddenElementCountBeforeClick=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,false);
		int sum= visibleElementCountBeforeClick+hiddenElementCountBeforeClick;
		
		//Click More button to expand hidden subfilters
		boolean bClick=getProductResultsPageThreadLocal().clickMoreOrLessButtonWithSpecificFirstlevelFilterInLeftPanel(element);
		if(!bClick) {
			break;
		}
		int visibleElementCountAfterClick=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,true);
		reporter.softAssert(visibleElementCountAfterClick==sum,"The visible subfilter count is equal to "+sum,"The visible subfilter count is not equal to "+sum);
		int hiddenElementCountAfterClick=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,false);
		reporter.softAssert(hiddenElementCountAfterClick==0,"The invisible subfilter count is equal to 0","The invisible subfilter count is not equal to 0");
		
		//Click Less button to recover to the original status
		bClick=getProductResultsPageThreadLocal().clickMoreOrLessButtonWithSpecificFirstlevelFilterInLeftPanel(element);
		if(!bClick) {
			break;
		}
		int visibleElementCountAfterReClick=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,true);
		reporter.softAssert(visibleElementCountAfterReClick== visibleElementCountBeforeClick,"The visible subfilter count is equal to "+ visibleElementCountBeforeClick,"The visible subfilter count is not equal to "+ visibleElementCountBeforeClick);
		int hiddenElementCountAfterReClick=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,false);
		reporter.softAssert(hiddenElementCountAfterReClick==hiddenElementCountBeforeClick,"The invisible subfilter count is equal to "+hiddenElementCountBeforeClick,"The invisible subfilter count is not equal to "+hiddenElementCountBeforeClick);
		
	}
		
	}
}

