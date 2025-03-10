package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC01_VerifyProductSearchResultWithMultiKeywords extends BaseTest{
	/*
	 * CER-211
	 * CER-212
	 * CER-217
	 * CER-216
	 * CER-218
	 * Bug 19285: Product image not updating when colour is chosen on smartphone or tablet - covered in verifyColorOption function
	 * Bug 19537: [QA Defect - P3] PRP: Is Price should be bold - covered in verifySearchResultContent and verifySearchResultContentWithMouseHover functions
	 * Bug 19536: [QA Defect - P3] PRP: Rating and Review not showing properly - covered in verifySearchResultContent and verifySearchResultContentWithMouseHover functions
	 * Bug 19629: [QA Defect - P3] Product card: if a product doesn't have color swatch, all color options show as plain circles - covered in verifyColorOption function
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
	public void SR_TC01_VerifyProductSearchResultWithMultiKeywords() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();

	BasePage basePage=new BasePage(this.getDriver());
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLog("ProductSearch Page");
	
	List<String> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword();
	List<String> lstSearchResultMessage=TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
//	String lsSearchResultPageDefaultSetting=TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
	List<WebElement> productList;
	String lsMsg="";

	int keyWordSize=lsKeywordList.size();
	for(int i=0;i<keyWordSize;i++) {
		reporter.reportLog("Search keyword : "+lsKeywordList.get(i)+ " for browser: "+getProductResultsPageThreadLocal().getExecutionBrowserName());
		getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(i).trim(),true);
		String lsTestModel=getProductResultsPageThreadLocal().judgeTestModel();	
		reporter.reportLog("Search Model : "+lsTestModel+" : "+lsKeywordList.get(i)+ " for browser: "+getProductResultsPageThreadLocal().getExecutionBrowserName());
		
		switch(lsTestModel) {
		case "NormalSearch":
			reporter.reportLog("NormalSearch");
			reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(i)), "Url of search result matches expected url regex pattern", "Url of search result doesn't match expected url regex pattern");			
			
			lsMsg=getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeywordList.get(i));
			if(lsMsg.isEmpty()) {
				reporter.reportLogPass("Search result message result of '"+getProductResultsPageThreadLocal().lsSearchResultMessage+"' matches the expected message");
			}else {
				reporter.reportLogFail(lsMsg);
			}
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
			
			productList=getProductResultsPageThreadLocal().getProductList();
			if(productList.size()>0) {
				getProductResultsPageThreadLocal().verifySearchResultContent(productList,false);
				getProductResultsPageThreadLocal().verifySearchResultContentWithMouseHover(productList,false);
			}
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
			break;
		case "NoSearchResult":
			reporter.reportLog("NoSearchResult");
			lsMsg=getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(1),"");
			if(lsMsg.isEmpty()) {
				reporter.reportLogPass("Search result message result of '"+getProductResultsPageThreadLocal().lsSearchResultMessage+"' matches the expected message");
			}else {
				reporter.reportLogFail(lsMsg);
			}
			
			getProductResultsPageThreadLocal().verifySearchResultNotExisting();
			break;
		case "ProductNumberSearch":
			reporter.reportLog("ProductNumberSearch");
			if(basePage.URL().toLowerCase().contains("productdetails")){
				reporter.reportLogPass("It goes to PDP page directly if using product number as keyword");
			}
			else{
				reporter.reportLogFail("It does not go to PDP page directly if using product number as keyword");
			}
			break;
		case "BannerImageSearch":
			reporter.reportLog("BannerImageSearch");
			reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(i)), "Url of search result matches expected url", "Url of search result doesn't match expected url");
			if(getProductResultsPageThreadLocal().getBannerImageListSize()>0) {
				reporter.softAssert(getProductResultsPageThreadLocal().verifyBannerImageContainSpecificWord(lsKeywordList.get(i)), "Banner imgaes contain keyword", "Banner imgaes do not contain keyword");
			}

			String lsTitle=getProductResultsPageThreadLocal().getProductResultPageTitle();
			reporter.softAssert(lsTitle.equalsIgnoreCase(lsKeywordList.get(i))||lsTitle.equalsIgnoreCase("NoTitle")||lsTitle.toLowerCase().contains(lsKeywordList.get(i).toLowerCase())||lsKeywordList.get(i).toLowerCase().contains(lsTitle.toLowerCase()), "Search result page title is dispalyed as search keyword", "Search result page title is not dispalyed as search keyword");

			reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");

			productList=getProductResultsPageThreadLocal().getProductList();
			if(productList.size()>0) {
				reporter.reportLog("Verify search content without mouse over");
				getProductResultsPageThreadLocal().verifySearchResultContent(productList,false);
				reporter.reportLog("Verify search content with mouse over");
				getProductResultsPageThreadLocal().verifySearchResultContentWithMouseHover(productList,false);
			}

			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
			
			if(getProductResultsPageThreadLocal().checkTitleAndTextSectionExisting()) {
				reporter.softAssert(getProductResultsPageThreadLocal().verifyProductBrandTitleOrText("Title"), "The tilte in product title and text region is not empty", "The tilte in product title and text region is empty");
				reporter.softAssert(getProductResultsPageThreadLocal().verifyProductBrandTitleOrText("Text"), "The content in product title and text region is not empty", "The content in product title and text region is empty");
				reporter.softAssert(getProductResultsPageThreadLocal().verifyProductBrandMoreOrLessButton(), "The More/Less button works", "The More/Less button does not work");
			}
			break;		
		}
	}

}

}
