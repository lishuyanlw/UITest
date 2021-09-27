package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC09_Verify_ProductSearchResult_SpecialOffersAndRecomendationSections extends BaseTest{
	
	/**
	 * This method will test Clearance in Special Offers and Recommendation sections.
	 * @author Wei.Li
	 */	
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult_SpecialOffersAndRecomendationSections() throws IOException {	
	(new HomePage(this.getDriver())).closeadd();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantDataVariables.getlst_SearchKeyword_DropDown();
	List<List<String>> lstSearchResultMessage=TestDataHandler.constantDataVariables.getlst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();	
	List<WebElement> productList;
	String lsMsg;		

	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));	

	//Test General filter option
	List<List<String>> lstSpecialOffers=TestDataHandler.constantDataVariables.getlst_SpecialOffers();
	getProductResultsPageThreadLocal().bDefault=false;		
	List<String> lstSelectedSecondLevelFilter=new ArrayList<String>();
	for(List<String> lstItem:lstSpecialOffers) {
		if(getProductResultsPageThreadLocal().selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1))) {
			lstSelectedSecondLevelFilter.add(getProductResultsPageThreadLocal().secondLevelFilter);
			lsMsg=getProductResultsPageThreadLocal().verifySlectedFiltersContainSecondlevelFilter(lstSelectedSecondLevelFilter);
			if(lsMsg.isEmpty()) {
				reporter.reportLogPass("The selected filters contain all search second level filters");
			}else {
				reporter.reportLogFail(lsMsg);
			}
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(0).get(0)), "The Url contains correct dimensions and keyword", "The Url does not contain correct dimensions and keyword");
			
			lsMsg=getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeywordList.get(0).get(0));
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
						
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySectionExisting(getProductResultsPageThreadLocal().getRecommendationContainer()), "Recommendation section is existing after choosing special offers", "Recommendation section is not existing after choosing special offers");
		}
		else {
			reporter.reportLogFail("Choosing filter of "+"'"+lstItem.get(0)+"/"+lstItem.get(1)+"' failed");
		}
		
		//To recover the initial test environment
		if(getProductResultsPageThreadLocal().getClearAllFiltersButtonStatus()) {
			getProductResultsPageThreadLocal().closeAllSelectedFilters();
		}
		else {
			getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
		}		
	}	

	}
}

