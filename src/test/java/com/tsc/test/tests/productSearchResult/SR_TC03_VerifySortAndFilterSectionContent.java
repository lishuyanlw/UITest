package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;

import com.tsc.pages.GlobalFooterPage;
import com.tsc.pages.HomePage;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC03_VerifySortAndFilterSectionContent extends BaseTest{
	/*
	 * CER-214
	 * CER-215
	 * Bug 19575: [QA Defect - P3] the implementation for Category in the left nav is wrong - covered in verifyFilterOptionsNotContainCategoryAndShopByCategorySimultaneously function
	 * Bug 19542: [QA Defect - P3] PRP: no products display in French - covered in verifyProductContentExistingAfterSwitchToFrench function
	 * Bug 19553: [QA Defect - P3] Direct search from URL doesn't make a PRP API call - covered in verifyProductLoadingThroughUrlDirectly function
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
	public void SR_TC03_VerifySortAndFilterSectionContent() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");

	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	List<String> lsSortOption=TestDataHandler.constantData.getSearchResultPage().getLst_SortOption();
	List<String> lsFilterOptionHeader=TestDataHandler.constantData.getSearchResultPage().getLst_FilterOptionHeader();
	List<String> lstBugKeyword=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_Bugs();
	
	getProductResultsPageThreadLocal().verifyProductLoadingThroughUrlDirectly(lstBugKeyword.get(2));
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0),true);

	reporter.softAssert(getProductResultsPageThreadLocal().verifySortOptions(lsSortOption), "Sort options in search result filters are correct", "Sort options in search result filters are incorrect");

	String lsMsg=getProductResultsPageThreadLocal().verifyFilterOptionsNotContainCategoryAndShopByCategorySimultaneously();	
	if(lsMsg.isEmpty()) {
		reporter.reportLogPass("The filter option headers are not containing Category and Shop By Category simultaneously");		
	}
	else {
		reporter.reportLogFail(lsMsg);
	}
	
	lsMsg=getProductResultsPageThreadLocal().verifyFilterOptions(lsFilterOptionHeader);	
	if(lsMsg.isEmpty()) {
		reporter.reportLogPass("Filter option headers in left panel are correct");		
	}
	else {
		reporter.reportLogFail(lsMsg);
	}	
	
	getProductResultsPageThreadLocal().verifyProductContentExistingAfterSwitchToFrench(getGlobalFooterPageThreadLocal());

	}
}
