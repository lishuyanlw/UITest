package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import com.tsc.test.tests.globalFooter.GF_TC01_Verify_GlobalFooter_SocialMedia;
import com.tsc.test.tests.globalFooter.GF_TC02_Verify_GlobalFooter_CustomerHubLinksAndAboutTSCLinks;
import com.tsc.test.tests.homePage.HP_TC01_Verify_Global_Header;

public class SR_TC10_Verify_ProductSearchResult_GlobalHeaderAndFooterAfterSortAndFilter extends BaseTest{
	/*
	 * CER-222
	 */
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult_GlobalHeaderAndFooterAfterSortAndFilter() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantDataVariables.getlst_SearchKeyword_DropDown();
	List<List<String>> lstSearchResultMessage=TestDataHandler.constantDataVariables.getlst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();	
	List<WebElement> productList;
	String lsMsg;

	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	
	//Test sort
	if(getProductResultsPageThreadLocal().chooseSortOptionByVisibleText("Price: Highest first")) {
		lsMsg=getProductResultsPageThreadLocal().verifyHighestPriceFirstSort();
		if(lsMsg.isEmpty()) {
			reporter.reportLogPass("Sort option of Price: Highest first works");
		}else {
			reporter.reportLogFail(lsMsg);
		}				
		
		reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlAfterSelectSortStrategy(lsKeywordList.get(0).get(0),"HighestPrice"), "The Url contains keyword and sortKey=HighestPrice", "The Url does not contain keyword and sortKey=HighestPrice");		
		
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
		reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getHeaderContainer()), "Header section is existing after choosing sorting options", "Header section is not existing after choosing sorting options");
		reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getFooterContainer()), "Footer section is existing after choosing sorting options", "Footer section is not existing after choosing sorting options");
	}
	else {
		reporter.reportLogFail("Choosing Price: Highest first option failed");
	}
	System.out.println("Product sorting finished!");
	HP_TC01_Verify_Global_Header headerSectionTest= new HP_TC01_Verify_Global_Header();
	//headerSectionTest.validateGlobalHeaderLinks();
	
	GF_TC01_Verify_GlobalFooter_SocialMedia footerSectionTest_SocialMedia=new GF_TC01_Verify_GlobalFooter_SocialMedia();
	footerSectionTest_SocialMedia.Verify_GlobalFooter_SocialMedia();
	System.out.println("Footer1 finished!");
	GF_TC02_Verify_GlobalFooter_CustomerHubLinksAndAboutTSCLinks footerSectionTest_CustomerHubLinksAndAboutTSCLinks=new GF_TC02_Verify_GlobalFooter_CustomerHubLinksAndAboutTSCLinks();
	footerSectionTest_CustomerHubLinksAndAboutTSCLinks.Verify_GlobalFooter_CustomerHubLinksAndAboutTSCLinks_Language();
	System.out.println("Footer2 finished!");	
	//Test filter by price	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	List<List<String>> lstFilterByPrice=TestDataHandler.constantDataVariables.getlst_FilterByPrice();
	if(getProductResultsPageThreadLocal().selectFilterItemInLeftPanel(lstFilterByPrice.get(0).get(0), lstFilterByPrice.get(0).get(1))) {
		//To verify the first item
		lsMsg=getProductResultsPageThreadLocal().verifyFilterByPrice(lstFilterByPrice.get(0).get(2),true);
		if(lsMsg.isEmpty()) {
			reporter.reportLogPass("The first item for filter by price works");
		}else {
			reporter.reportLogFail(lsMsg);
		}
		//To verify all items
		lsMsg=getProductResultsPageThreadLocal().verifyFilterByPrice(lstFilterByPrice.get(0).get(2),false);
		if(lsMsg.isEmpty()) {
			reporter.reportLogPass("Filter by price works");
		}else {
			reporter.reportLogFail(lsMsg);
		}	
		reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(0).get(0)), "The Url contains correct keyword", "The Url does not contain correct keyword");
		
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
		reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getHeaderContainer()), "Header section is existing after choosing filters", "Header section is not existing after choosing filters");
		reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getFooterContainer()), "Footer section is existing after choosing filters", "Footer section is not existing after choosing filters");
	}
	else {
		reporter.reportLogFail("Choosing filter of "+lstFilterByPrice.get(0).get(0)+"/"+lstFilterByPrice.get(0).get(1)+" failed");
	}
	System.out.println("Product filter finished!");
	//headerSectionTest.validateGlobalHeaderLinks();
	footerSectionTest_SocialMedia.Verify_GlobalFooter_SocialMedia();
	System.out.println("Footer3 finished!");
	footerSectionTest_CustomerHubLinksAndAboutTSCLinks.Verify_GlobalFooter_CustomerHubLinksAndAboutTSCLinks_Language();
	System.out.println("Footer4 finished!");	

	}
}

