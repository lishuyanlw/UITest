package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.ProductResultsPage;
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

//	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));	


	//Need to add more actions for clicking Clearance and fashion in Heading menu
	//Corresponding actions (Clearance>>Fashion>>Shop all fashion)
	getglobalheaderPageThreadLocal().clickOnClearanceHeaderOption();
	getProductResultsPageThreadLocal().verifyClearanceOption();
	
	String value=getProductResultsPageThreadLocal().getProductResultPageTitle();
	
	if(value.equalsIgnoreCase(ProductResultsPage.clearancePageTitle)) {
		reporter.hardAssert(true, "Product Result Title Verified and title is "+value+"", "");
	}else {
		reporter.hardAssert(false, "Product Result Title Verified and title is "+value+"", "Result is Failed !!");
	}
	

	
	String baseUrl=getProductResultsPageThreadLocal().verifyClearanceOptionURLTitle();
	if(baseUrl.contains("productresults?nav") && baseUrl.contains("CL_FLY_ALLProducts")) {
		reporter.hardAssert(true, "Title Verified", "");
		reporter.reportLogPass("Search result message result of '"+getProductResultsPageThreadLocal().lsSearchResultMessage+"' matches the expected message");
		
	}else {
		reporter.hardAssert(false, "Failed", "");
		reporter.reportLogFail("");
	}
	
	String pageCount=getProductResultsPageThreadLocal().captureItemPaginationCount();
	if(pageCount.equalsIgnoreCase("36")) {
		reporter.hardAssert(true, "Title Verified", "");
	}else {
		reporter.hardAssert(false, "Failed", "");
	}
		
	//reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(0).get(0)), "The Url contains correct dimensions and keyword", "The Url does not contain correct dimensions and keyword");
		
	//lsMsg=getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeywordList.get(0).get(0));
	//if(lsMsg.isEmpty()) {
		//reporter.reportLogPass("Search result message result of '"+getProductResultsPageThreadLocal().lsSearchResultMessage+"' matches the expected message");
	//}else {
		//reporter.reportLogFail(lsMsg);
	//}
				
	reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
	reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
		
	productList=getProductResultsPageThreadLocal().getProductList();
	if(productList.size()>0) {
		getProductResultsPageThreadLocal().verifySearchResultContent(productList);
	}
					
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
	reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getRecommendationContainer()), "Recommendation section is existing after choosing special offers", "Recommendation section is not existing after choosing special offers");

	}
}
