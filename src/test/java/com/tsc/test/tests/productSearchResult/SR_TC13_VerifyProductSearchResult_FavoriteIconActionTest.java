package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC13_VerifyProductSearchResult_FavoriteIconActionTest extends BaseTest{
	/*
	 * CER-701
	 * Bug 19539: [QA Defect - P3] Favorite an item in PRP doesn't sync up to PDP - covered in verifyFavoriteIconAction function
	 * Bug 19559: [QA Defect - P3] Products show different ratings in PRP vs. PDP - covered in verifyFavoriteIconAction function
	 * Bug 19538: [QA Defect - P3] PRP: missing Free Shipping label - covered in verifySearchResultContent and verifySearchResultContentWithMouseHover functions
	 * Bug 19538: [QA Defect - P3] PRP: missing Free Shipping label - covered in verifyFavoriteIconAction function
	 * 
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet"})
	public void SR_TC13_VerifyProductSearchResult_FavoriteIconActionTest() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
		
	List<String> lstSearchResultMessage=TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
//	String lsSearchResultPageDefaultSetting=TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
	String lsUserName=TestDataHandler.constantData.getLoginUser().getLbl_Username();
	String lsPassword=TestDataHandler.constantData.getLoginUser().getLbl_Password();
	String lsFirstName=TestDataHandler.constantData.getLoginUser().getLbl_FirstName();
	List<String> lst_SearchKeyword = TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_Bugs();
	String lsMsg;
	List<WebElement> productList;

	reporter.reportLog("Search keyword: "+lst_SearchKeyword.get(3));
	getProductResultsPageThreadLocal().getSearchResultLoad(lst_SearchKeyword.get(3),true);
	String lsTestModel=getProductResultsPageThreadLocal().judgeTestModel();	
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lst_SearchKeyword.get(3)), "The Url contains correct dimensions and keyword", "The Url does not contain correct dimensions and keyword");
	
	if(!lsTestModel.equalsIgnoreCase("BannerImageSearch")) {
		lsMsg=getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lst_SearchKeyword.get(3));
		if(lsMsg.isEmpty()) {
			reporter.reportLogPass("Search result message result of '"+getProductResultsPageThreadLocal().lsSearchResultMessage+"' matches the expected message");
		}else {
			reporter.reportLogFail(lsMsg);
		}
	}	
			
	reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
	
	productList=getProductResultsPageThreadLocal().getProductList();
	if(productList.size()>0) {
//		getProductResultsPageThreadLocal().verifySearchResultContent(productList);
		getProductResultsPageThreadLocal().verifyFavoriteIconAction(lsUserName, lsPassword,lsFirstName,lst_SearchKeyword.get(3),getProductDetailPageThreadLocal(),getMyAccountPageThreadLocal());
	}
	else {
		reporter.reportLogFail("No product results available");
	}
			
	}
}

