package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC07_Verify_ProductSearchResult_MoreOrLessButtonTest extends BaseTest{
	
	/**
	 * This method will test the More and Less button.
	 * @author Wei.Li
	 */	
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult_MoreOrLessButtonTest() throws IOException {	
	(new HomePage(this.getDriver())).closeadd();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantDataVariables.getlst_SearchKeyword_DropDown();
	List<List<String>> lstSearchResultMessage=TestDataHandler.constantDataVariables.getlst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();	
	List<WebElement> productList;
	List<String> lstMoreButton=TestDataHandler.constantDataVariables.getlst_MoreButton();	
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(0).get(0)), "The Url contains correct dimensions and keyword", "The Url does not contain correct dimensions and keyword");
	
	String lsMsg=getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeywordList.get(0).get(0));
	if(lsMsg.isEmpty()) {
		reporter.reportLogPass("Search result message result of '"+getProductResultsPageThreadLocal().lsSearchResultMessage+"' matches the expected message");
	}else {
		reporter.reportLogFail(lsMsg);
	}
			
	reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
	reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
	
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
		int visibleElementCount1=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,true);
		int hiddenElementCount1=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,false);
		int sum=visibleElementCount1+hiddenElementCount1;
		
		//Click More button to expand hidden subfilters
		boolean bClick=getProductResultsPageThreadLocal().clickMoreOrLessButtonWithSpecificFirstlevelFilterInLeftPanel(element);
		if(!bClick) {
			break;
		}
		int visibleElementCount2=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,true);
		reporter.softAssert(visibleElementCount2==sum,"The visible subfilter count is equal to "+sum,"The visible subfilter count is not equal to "+sum);
		int hiddenElementCount2=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,false);
		reporter.softAssert(hiddenElementCount2==0,"The invisible subfilter count is equal to 0","The invisible subfilter count is not equal to 0");
		
		//Click Less button to recover to the original status
		bClick=getProductResultsPageThreadLocal().clickMoreOrLessButtonWithSpecificFirstlevelFilterInLeftPanel(element);
		if(!bClick) {
			break;
		}
		int visibleElementCount3=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,true);
		reporter.softAssert(visibleElementCount3==visibleElementCount1,"The visible subfilter count is equal to "+visibleElementCount1,"The visible subfilter count is not equal to "+visibleElementCount1);
		int hiddenElementCount3=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel(element,false);
		reporter.softAssert(hiddenElementCount3==hiddenElementCount1,"The invisible subfilter count is equal to "+hiddenElementCount1,"The invisible subfilter count is not equal to "+hiddenElementCount1);
		
	}
		
	}
}

