package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tsc.pages.HomePage;
import com.tsc.test.tests.globalFooter.GF_TC01_VerifySocialMedia;
import com.tsc.test.tests.globalFooter.GF_TC02_VerifyCustomerHubLinksAndAboutTSCLinks;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import com.tsc.test.tests.globalHeader.GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo;
import com.tsc.test.tests.globalHeader.GH_TC02_Verify_Global_Header_SignIn_Favorite_ShoppingCartBag;

public class SR_TC12_VerifyProductSearchResult_GlobalHeaderAndFooterAfterSortAndFilter extends BaseTest{
	/*
	 * CER-222
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
	public void SR_TC12_VerifyProductSearchResult_GlobalHeaderAndFooterAfterSortAndFilter() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	List<String> lstSearchResultMessage=TestDataHandler.constantData.getSearchResultPage().getLst_SearchResultMessage();
	//String lsSearchResultPageDefaultSetting=TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
	List<WebElement> productList;
	String lsMsg;
	List<String> lstSortByOptions=TestDataHandler.constantData.getSearchResultPage().getLst_Filter_Data();
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0),true);
	String lsTestModel=getProductResultsPageThreadLocal().judgeTestModel();
	
	//Test sort
	if(getProductResultsPageThreadLocal().chooseSortOptionByVisibleText(lstSortByOptions.get(0))) {
		reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlAfterSelectSortStrategy(lsKeywordList.get(0).get(0),"HighestPrice"), "The Url contains keyword and sortKey=HighestPrice", "The Url does not contain keyword and sortKey=HighestPrice");		
		
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
			List<WebElement> lstFirstproduct=new ArrayList<WebElement>();
			lstFirstproduct.add(productList.get(0));
			getProductResultsPageThreadLocal().verifySearchResultContent(lstFirstproduct,true);
		}	
		
		reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
		reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getHeaderContainer()), "Header section is existing after choosing sorting options", "Header section is not existing after choosing sorting options");
		reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getFooterContainer()), "Footer section is existing after choosing sorting options", "Footer section is not existing after choosing sorting options");
	}
	else {
		reporter.reportLogFail("Choosing Price: Highest first option failed");
	}
	
	//Verify header section
	if((System.getProperty("Browser").toLowerCase().contains("android") && System.getProperty("Device").toLowerCase().contains("tablet")) ||
			(System.getProperty("Browser").toLowerCase().contains("chromemobile") &&
					!System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad")))
		reporter.reportLog("Header Verification is not needed for android Tablet");
	else{
		GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo headerSectionMenuAndLogoTest= new GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo();
		headerSectionMenuAndLogoTest.validateMajorNameAndLinks();
	}

	GH_TC02_Verify_Global_Header_SignIn_Favorite_ShoppingCartBag headerSectionOthersTest= new GH_TC02_Verify_Global_Header_SignIn_Favorite_ShoppingCartBag();
	headerSectionOthersTest.validateMajorNameAndLinks();
	
	//Verify footer section
	GF_TC01_VerifySocialMedia footerSectionTest_SocialMedia=new GF_TC01_VerifySocialMedia();
	footerSectionTest_SocialMedia.validateMajorNameAndLinks();

	GF_TC02_VerifyCustomerHubLinksAndAboutTSCLinks footerSectionTest_CustomerHubLinksAndAboutTSCLinks=new GF_TC02_VerifyCustomerHubLinksAndAboutTSCLinks();
	footerSectionTest_CustomerHubLinksAndAboutTSCLinks.validateContents();
		
	//Test filter by price	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0),true);
	List<List<String>> lstFilterByPrice=TestDataHandler.constantData.getSearchResultPage().getLst_SearchOption().get(1).getFilterOption();
	if(getProductResultsPageThreadLocal().selectFilterItemInLeftPanel(lstFilterByPrice.get(0).get(0), lstFilterByPrice.get(0).get(1))) {
		reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(0).get(0)), "The Url contains correct keyword", "The Url does not contain correct keyword");
		
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
			List<WebElement> lstFirstproduct=new ArrayList<WebElement>();
			lstFirstproduct.add(productList.get(0));
			getProductResultsPageThreadLocal().verifySearchResultContent(lstFirstproduct,true);
		}	
		
		reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");		
	}
	else {
		reporter.reportLogFail("Choosing filter of "+lstFilterByPrice.get(0).get(0)+"/"+lstFilterByPrice.get(0).get(1)+" failed");
	}
	
	//Verify header section
	if((System.getProperty("Browser").toLowerCase().contains("android") && System.getProperty("Device").toLowerCase().contains("tablet")) ||
			(System.getProperty("Browser").toLowerCase().contains("chromemobile") &&
					!System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad")))
		reporter.reportLog("Header Verification is not needed for android Tablet");
	else{
		GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo headerSectionMenuAndLogoTest= new GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo();
		headerSectionMenuAndLogoTest.validateMajorNameAndLinks();
	}

	//Verify footer section
	footerSectionTest_SocialMedia.validateMajorNameAndLinks();
	getProductResultsPageThreadLocal().getReusableActionsInstance().staticWait(5000);
	footerSectionTest_CustomerHubLinksAndAboutTSCLinks.validateContents();
	

	}
}
