package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC02_Verify_ProductSearchResult_DropDownMenu extends BaseTest{
	
	/**
	 * This method will test functions of product searching results from select searching item from dropdwon menu.
	 *
	 * @author Wei.Li
	 */	
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult_DropdownMenu() throws IOException {	
	(new HomePage(this.getDriver())).closeadd();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();
	List<String> lsKeywordDropdownList=TestDataHandler.constantDataVariables.getlst_SearchKeyword_DropDown();
	List<WebElement> productList;
	
	int keyWordDropdownSize=lsKeywordDropdownList.size();
	for(int i=0;i<keyWordDropdownSize;i++) {
		reporter.reportLog("Search keyword : "+lsKeywordDropdownList.get(i));		
		getProductResultsPageThreadLocal().selectSearchResultListInDropdownMenu(lsKeywordDropdownList.get(i),0);
		
		reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
		reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
		reporter.softAssert(getProductResultsPageThreadLocal().verifyPageTitleForDropdown(), "Search result page title is displayed as search keyword in dropdown menu", "Search result page title is not displayed as search keyword in dropdown menu");
				
		productList=getProductResultsPageThreadLocal().getProductList();
		if(productList.size()>0) {
			getProductResultsPageThreadLocal().verifySearchResultContent(productList);
		}		
		
		}	
	}

}
