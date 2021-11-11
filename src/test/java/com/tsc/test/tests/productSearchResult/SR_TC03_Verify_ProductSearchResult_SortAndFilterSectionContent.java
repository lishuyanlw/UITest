package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC03_Verify_ProductSearchResult_SortAndFilterSectionContent extends BaseTest{
	/*
	 * CER-214
	 * CER-215
	 */
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult_FilterSectionContent() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");

	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	List<String> lsSortOption=TestDataHandler.constantData.getSearchResultPage().getLst_SortOption();
	List<String> lsFilterOptionHeader=TestDataHandler.constantData.getSearchResultPage().getLst_FilterOptionHeader();
	List<String> lsSortOptionMobile=TestDataHandler.constantDataVariables.getLst_SortOptionMobile();
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));

	if (System.getProperty("Device")=="Mobile"){
		reporter.softAssert(getProductResultsPageThreadLocal().verifySortOptions(lsSortOptionMobile), "Sort options in search result filters are correct", "Sort options in search result filters are incorrect");
	}else {
		reporter.softAssert(getProductResultsPageThreadLocal().verifySortOptions(lsSortOption), "Sort options in search result filters are correct", "Sort options in search result filters are incorrect");
	}

	String lsMsg=getProductResultsPageThreadLocal().verifyFilterOptions(lsFilterOptionHeader);	
	if(lsMsg.isEmpty()) {
		reporter.reportLogPass("Filter option headers in left panel are correct");		
	}
	else {
		reporter.reportLogFail(lsMsg);
	}	

	}
}
