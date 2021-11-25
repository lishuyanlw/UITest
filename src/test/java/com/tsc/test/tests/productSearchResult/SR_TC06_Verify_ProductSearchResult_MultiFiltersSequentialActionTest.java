package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC06_Verify_ProductSearchResult_MultiFiltersSequentialActionTest extends BaseTest{
	/*
	 * CER-227
	 * CER-228
	 * CER-230
	 */
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult_MultiFiltersSequentialActionTest() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	List<String> lstSearchResultMessage=TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
	List<WebElement> productList;
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	String lsTestModel=getProductResultsPageThreadLocal().judgeTestModel();	
	
	//Test filter option for sequential actions
	List<String> lstDisappearAfterSelectFilter=TestDataHandler.constantData.getSearchResultPage().getLst_DisappearAfterSelectFilter();
	List<List<String>> lstFilterSequentialAction=TestDataHandler.constantData.getSearchResultPage().getLst_SearchOption().get(3).getFilterOption();
	String lsMsg="";
	
	getProductResultsPageThreadLocal().bDefault=false;		
	List<String> lstSelectedSecondLevelFilter=new ArrayList<String>();		
	for(List<String> lstItem:lstFilterSequentialAction) {			
		getProductResultsPageThreadLocal().selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1));
		lstSelectedSecondLevelFilter.add(getProductResultsPageThreadLocal().secondLevelFilter);			
	
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
		reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
		
		productList=getProductResultsPageThreadLocal().getProductList();
		if(productList.size()>0) {
			getProductResultsPageThreadLocal().verifySearchResultContent(productList);
		}	
	}

	}
}

