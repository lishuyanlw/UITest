package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC01_Verify_ProductSearchResult extends BaseTest{
	
	/**
	 * This method will test functions of product searching results
	 *
	 * @author Wei.Li
	 */	
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult() throws IOException {				
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLogWithScreenshot("ProductSearch Page");
	
	List<String> lskeywordList=TestDataHandler.constantDataVariables.getlst_SearchKeyword();
	String lsSearchResultExpectedUrl=TestDataHandler.constantDataVariables.getlbl_SearchResultExpectedUrl();
	List<List<String>> lstSearchResultMessage=TestDataHandler.constantDataVariables.getlst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();
	
	int keyWordSize=lskeywordList.size();
	for(int i=0;i<keyWordSize;i++) {
		getProductResultsPageThreadLocal().getSearchResultLoad(lskeywordList.get(i));
		
		String lsTestModel=getProductResultsPageThreadLocal().judgeTestModel();
				
		if(!lsTestModel.equalsIgnoreCase("BannerImageSearch")) {
			if(lsTestModel.equalsIgnoreCase("SpecialCharacterSearch")) {
				reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(1),lskeywordList.get(i)), "Search result message result matches the expected message", "Search result message result does not match the expected message");
			}
			else {
				reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lskeywordList.get(i)), "Search result message result matches the expected message", "Search result message result does not match the expected message");
			}			
		}
						
		if(!lsTestModel.equalsIgnoreCase("SpecialCharacterSearch")) {			
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrl(lsSearchResultExpectedUrl,lskeywordList.get(i)), "Url of search result matches expected url", "Url of search result doesn't match expected url");			
		}
								
		if(!lsTestModel.equalsIgnoreCase("SpecialCharacterSearch")&&!lsTestModel.equalsIgnoreCase("ProductNumberSearch")) {
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
			
			List<WebElement> productList=getProductResultsPageThreadLocal().getProductList();
			(new BasePage(this.getDriver())).getReusableActionsInstance().javascriptScrollByVisibleElement(productList.get(0));
			for(WebElement item : productList) {
				
				(new BasePage(this.getDriver())).getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				
				reporter.softAssert(!item.findElement(By.xpath(".//a")).getAttribute("href").isEmpty(),"ProductHref in searching result is correct", "ProductHref in searching result is incorrect");
				
				reporter.softAssert(!item.findElement(By.xpath(".//div[contains(@class,'imgEmbedContainer')]//img[@class='productImg']")).getAttribute("src").isEmpty(), "ProductImage in searching result is correct", "ProductImage in searching result is incorrect");
				
				reporter.softAssert(!item.findElement(By.xpath(".//div[contains(@class,'nameDiv')]")).getText().isEmpty(), "ProductName in searching result is correct", "ProductName in searching result is incorrect");
				
				reporter.softAssert(!item.findElement(By.xpath(".//div[contains(@class,'itemNo')]")).getText().isEmpty(), "ProductItemNO in searching result is correct", "ProductItemNO in searching result is incorrect");
				
				reporter.softAssert(!item.findElement(By.xpath(".//div[contains(@class,'priceDiv')]//span")).getText().isEmpty(), "ProductNowPrice in searching result is correct", "ProductNowPrice in searching result is incorrect");			
			}
								
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPriceBadge(), "PriceBadge in searching result is correct", "PriceBadge in searching result is incorrect");
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductVideoIcon(), "ProductVideoIcon in searching result is correct", "ProductVideoIcon in searching result is incorrect");
						
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductWasPrice(), "ProductWasPrice in searching result is correct", "ProductWasPrice in searching result is incorrect");
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductEasyPay(), "ProductEasyPay in searching result is correct", "ProductEasyPay in searching result is incorrect");
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductReview(), "ProductReview in searching result is correct", "ProductReview in searching result is incorrect");
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductSwatch(), "ProductSwatch in searching result is correct", "ProductSwatch in searching result is incorrect");
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductFreeShipping(), "ProductFreeShipping in searching result is correct", "ProductFreeShipping in searching result is incorrect");
			
		}
				
		//Verify "!@#$%^&*()_+" special keyword search
		if(lsTestModel.equalsIgnoreCase("SpecialCharacterSearch")) {
			reporter.softAssert(getProductResultsPageThreadLocal().getProductResultCount()==0, "No search results return", "Still there are search results return");
		}
			
		//Verify "100501" product number keyword search
		if(lsTestModel.equalsIgnoreCase("ProductNumberSearch")) {
			reporter.softAssert(getProductResultsPageThreadLocal().VerifySearchResultWithProductItemNO(lskeywordList.get(i)), "The itemNO in search results just contains those with search product number", "the itemNO in search results don't just contain those with search product number");
		}
		
		//Verify "joan rivers" Banner image keyword search
		if(lsTestModel.equalsIgnoreCase("BannerImageSearch")) {
			reporter.softAssert(getProductResultsPageThreadLocal().verifyBannerImageContainSpecificWord(lskeywordList.get(i)), "Banner imgaes contain Joan Rivers related word", "Banner imgaes do not contain Joan Rivers related word");
			
			String lsTitle=getProductResultsPageThreadLocal().getProductResultPageTitle();
			reporter.softAssert(lsTitle.equalsIgnoreCase(lskeywordList.get(i))||lsTitle.equalsIgnoreCase("NoTitle"), "Search result page title is dispalyed as search keyword", "Search result page title is not dispalyed as search keyword");
		}
				
	}
	
	
	}
	
}
