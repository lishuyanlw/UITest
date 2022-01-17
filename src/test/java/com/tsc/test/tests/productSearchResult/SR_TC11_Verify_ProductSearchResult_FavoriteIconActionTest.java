package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;

import com.tsc.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC11_Verify_ProductSearchResult_FavoriteIconActionTest extends BaseTest{
	/*
	 * CER-701
	 * 
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet"})
	public void validateProductSearchResult_FavoriteIconActionTest() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	List<String> lstSearchResultMessage=TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
	String lsUserName=TestDataHandler.constantData.getLoginUser().getLbl_Username();
	String lsPassword=TestDataHandler.constantData.getLoginUser().getLbl_Password();
	String lsFirstName=TestDataHandler.constantData.getLoginUser().getLbl_FirstName();
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
	
	getProductResultsPageThreadLocal().verifyFavoriteIconAction(lsUserName, lsPassword,lsFirstName,lsKeywordList.get(0).get(0));
		
	}
}

