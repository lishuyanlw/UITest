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
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
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
		getProductResultsPageThreadLocal().collapseFilterItemWithClickingProductTitle(element);
		if(getProductResultsPageThreadLocal().checkFilterItemSeeButtonExisting(element).equalsIgnoreCase("None")) {
			getProductResultsPageThreadLocal().uncollapseFilterItemWithClickingProductTitle(element);
			continue;			
		}
		int elementCountBeforeClickingSeeMoreButton=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel();
				
		getProductResultsPageThreadLocal().clickSeeMoreButton(element);		
		int elementCountAfterClickingSeeMoreButton=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel();
		
		if(elementCountAfterClickingSeeMoreButton>elementCountBeforeClickingSeeMoreButton) {
			reporter.reportLogPass("The subitem count after clicking SeeMore button is more than the count before clicking SeeMore button");
		}
		else {
			reporter.reportLogFail("The subitem count after clicking SeeMore button is no more than the count before clicking SeeMore button");
		}
		
		getProductResultsPageThreadLocal().clickSeeLessButton(element);		
		int elementCountAfterClickingSeeLessButton=getProductResultsPageThreadLocal().getFiltersCountInSecondLevel();
		
		if(elementCountBeforeClickingSeeMoreButton==elementCountAfterClickingSeeLessButton) {
			reporter.reportLogPass("The subitem count after clicking SeeLess button is equal to the count before clicking SeeMore button");
		}
		else {
			reporter.reportLogPass("The subitem count after clicking SeeLess button is not equal to the count before clicking SeeMore button");
		}
		
		getProductResultsPageThreadLocal().uncollapseFilterItemWithClickingProductTitle(element);
	}
		
	}
}

