package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.ProductResultsPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC03_Verify_ProductSearchResult_SortAndFilterSection extends BaseTest{
	
	/**
	 * This method will test sort and filter sections of product searching results.
	 * @author Wei.Li
	 */	
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult_FilterSection() throws IOException {	
	(new HomePage(this.getDriver())).closeadd();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<String> lsKeywordList=TestDataHandler.constantDataVariables.getlst_SearchKeyword_DropDown();	
	List<String> lsSortOption=TestDataHandler.constantDataVariables.getlst_SortOption();
		
	int keyWordSize=lsKeywordList.size();
	for(int i=0;i<keyWordSize;i++) {		
		getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(i));
		System.out.println("Keyword:"+lsKeywordList.get(i));
		
		reporter.softAssert(getProductResultsPageThreadLocal().verifySortOptions(lsSortOption), "Sort options in search result filters are correct", "Sort options in search result filters are incorrect");
		}
	
	}
}
