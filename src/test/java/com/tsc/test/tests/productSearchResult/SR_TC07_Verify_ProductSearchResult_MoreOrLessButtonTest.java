package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
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
	List<String> lstMoreButton=TestDataHandler.constantDataVariables.getlst_MoreButton();	
		
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	
	getProductResultsPageThreadLocal().getHiddenFiltersCountInSecondLevel(getProductResultsPageThreadLocal().clickMoreButtonWithSpecificFirstlevelFilterInLeftPanel(lstMoreButton.get(0)));
	

	}
}

