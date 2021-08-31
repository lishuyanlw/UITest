package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC01_Verify_ProductSearchResult extends BaseTest{
	
	/**
	 * This method will test functions of product searching results
	 *
	 * @author Wei.Li
	 */	
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult() throws IOException {	
	(new HomePage(this.getDriver())).closeadd();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<String> lskeywordList=TestDataHandler.constantDataVariables.getlst_SearchKeyword();	
	String lsSearchResultExpectedUrl=TestDataHandler.constantDataVariables.getlbl_SearchResultExpectedUrl();
	String lsSearchResultExpectedUrlWithoutKeyword=TestDataHandler.constantDataVariables.getlbl_SearchResultExpectedUrlWithoutKeyword();
	System.out.println("Url:"+lsSearchResultExpectedUrlWithoutKeyword);
	List<List<String>> lstSearchResultMessage=TestDataHandler.constantDataVariables.getlst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();
	
	int keyWordSize=lskeywordList.size();
	for(int i=0;i<keyWordSize;i++) {
		reporter.reportLog("Search keyword:"+lskeywordList.get(i));
		getProductResultsPageThreadLocal().getSearchResultLoad(lskeywordList.get(i));
		System.out.println("Keyword:"+lskeywordList.get(i));
		String lsTestModel=getProductResultsPageThreadLocal().judgeTestModel();	
		System.out.println(lskeywordList.get(i)+":"+lsTestModel);
		switch(lsTestModel) {
		case "NormalSearch":
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrlWithRegexPattern(lsSearchResultExpectedUrl,lskeywordList.get(i)), "Url of search result matches expected url regex pattern", "Url of search result doesn't match expected url regex pattern");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrl(lsSearchResultExpectedUrlWithoutKeyword,lskeywordList.get(i)), "Url of search result matches expected url", "Url of search result doesn't match expected url");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lskeywordList.get(i)), "Search result message result matches the expected message", "Search result message result does not match the expected message");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
			reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
			verifySearchResultContent();
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
			break;
		case "SpecialCharacterSearch":
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(1),lskeywordList.get(i)), "Search result message result matches the expected message", "Search result message result does not match the expected message");
			reporter.softAssert(getProductResultsPageThreadLocal().getProductResultCount()==0, "No search results return", "Still there are search results return");
			break;
		case "ProductNumberSearch":
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrlWithRegexPattern(lsSearchResultExpectedUrl,lskeywordList.get(i)), "Url of search result matches expected url", "Url of search result doesn't match expected url");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lskeywordList.get(i)), "Search result message result matches the expected message", "Search result message result does not match the expected message");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
			reporter.softAssert(getProductResultsPageThreadLocal().VerifySearchResultWithProductItemNO(lskeywordList.get(i)), "The itemNO in search results just contains those with search product number", "the itemNO in search results don't just contain those with search product number");
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
			break;
		case "BannerImageSearch":
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrlWithRegexPattern(lsSearchResultExpectedUrl,lskeywordList.get(i)), "Url of search result matches expected url", "Url of search result doesn't match expected url");
			if(getProductResultsPageThreadLocal().getBannerImageListSize()>0) {
				reporter.softAssert(getProductResultsPageThreadLocal().verifyBannerImageContainSpecificWord(lskeywordList.get(i)), "Banner imgaes contain keyword", "Banner imgaes do not contain keyword");
			}
						
			String lsTitle=getProductResultsPageThreadLocal().getProductResultPageTitle();
			reporter.softAssert(lsTitle.equalsIgnoreCase(lskeywordList.get(i))||lsTitle.equalsIgnoreCase("NoTitle"), "Search result page title is dispalyed as search keyword", "Search result page title is not dispalyed as search keyword");
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
			reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
			verifySearchResultContent();
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
			
			if(this.getDriver().findElements(getProductResultsPageThreadLocal().byProductTitleAndText).size()==1) {
				reporter.softAssert(getProductResultsPageThreadLocal().verifyProductBrandTitleContainKeyword(lskeywordList.get(i)), "The tilte in product title and text region contains search keyword", "The tilte in product title and text region does not contain search keyword");				
			}
			break;		
		}
	}

}
	
	void verifySearchResultContent() {
		List<WebElement> productList=getProductResultsPageThreadLocal().getProductList();
		List<WebElement> elementList;
		(new BasePage(this.getDriver())).getReusableActionsInstance().javascriptScrollByVisibleElement(productList.get(0));
		for(WebElement item : productList) {
			reporter.reportLog("Product ItemNO:"+item.findElement(getProductResultsPageThreadLocal().byProductItemNO).getText());
			(new BasePage(this.getDriver())).getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			
			reporter.softAssert(!item.findElement(getProductResultsPageThreadLocal().byProductHref).getAttribute("href").isEmpty(),"ProductHref in searching result is correct", "ProductHref in searching result is incorrect");
			
			reporter.softAssert(!item.findElement(getProductResultsPageThreadLocal().byProductImage).getAttribute("src").isEmpty(), "ProductImage in searching result is correct", "ProductImage in searching result is incorrect");
			
			reporter.softAssert(!item.findElement(getProductResultsPageThreadLocal().byProductName).getText().isEmpty(), "ProductName in searching result is correct", "ProductName in searching result is incorrect");
			
			reporter.softAssert(!item.findElement(getProductResultsPageThreadLocal().byProductItemNO).getText().isEmpty(), "ProductItemNO in searching result is correct", "ProductItemNO in searching result is incorrect");
			
			reporter.softAssert(!item.findElement(getProductResultsPageThreadLocal().byProductNowPrice).getText().isEmpty(), "ProductNowPrice in searching result is correct", "ProductNowPrice in searching result is incorrect");
			
			//Use findElements to avoid test crash when the element is not existing
			elementList=item.findElements(getProductResultsPageThreadLocal().byProductEasyPay);	
			if((new BasePage(this.getDriver())).isChildElementVisible(elementList.get(0),"innerText")) {
				reporter.softAssert(true, "ProductEasyPay in searching result is correct", "ProductEasyPay in searching result is incorrect");
			}
							
			//Use findElements to avoid test crash when the element is not existing
			elementList=item.findElements(getProductResultsPageThreadLocal().byProductReview);
			if((new BasePage(this.getDriver())).isChildElementVisible(elementList.get(0),"innerText")) {
				reporter.softAssert(true, "ProductReview in searching result is correct", "ProductReview in searching result is incorrect");
			}
							
			//Use findElements to avoid test crash when the element is not existing
			elementList=item.findElements(getProductResultsPageThreadLocal().byProductSwatch);
			if((new BasePage(this.getDriver())).isChildElementVisible(elementList.get(0),"childElementCount")) {
				reporter.softAssert(true, "ProductSwatch in searching result is correct", "ProductSwatch in searching result is incorrect");
			}
							
			//Use findElements to avoid test crash when the element is not existing
			elementList=item.findElements(getProductResultsPageThreadLocal().byProductFreeShipping);
			if((new BasePage(this.getDriver())).isChildElementVisible(elementList.get(0),"innerText")) {
				reporter.softAssert(true, "ProductFreeShipping in searching result is correct", "ProductFreeShipping in searching result is incorrect");
			}
				
			String judgeMode=getProductResultsPageThreadLocal().judgeProductBadgeAndVideo(item);
			System.out.println("judgeMode:"+judgeMode);
			switch(judgeMode) {
			case "WithBadge":
				reporter.softAssert(!item.findElement(getProductResultsPageThreadLocal().byProductPriceBadge).getAttribute("src").isEmpty(), "PriceBadge in searching result is correct", "PriceBadge in searching result is incorrect");
				break;
			case "WithVideo":
				reporter.softAssert(!item.findElement(getProductResultsPageThreadLocal().byProductVideoIcon).getAttribute("xlink:href").isEmpty(), "ProductVideoIcon in searching result is correct", "ProductVideoIcon in searching result is incorrect");
				break;
			case "WithBadgeAndVideo":
				reporter.softAssert(!item.findElement(getProductResultsPageThreadLocal().byProductPriceBadge).getAttribute("src").isEmpty(), "PriceBadge in searching result is correct", "PriceBadge in searching result is incorrect");
				reporter.softAssert(!item.findElement(getProductResultsPageThreadLocal().byProductVideoIcon).getAttribute("xlink:href").isEmpty(), "ProductVideoIcon in searching result is correct", "ProductVideoIcon in searching result is incorrect");
				break;
			}
			
			judgeMode=getProductResultsPageThreadLocal().judgeProductWasPrice(item);
			System.out.println("judgeMode:"+judgeMode);
			if(judgeMode.equalsIgnoreCase("WithWasPrice")) {
				reporter.softAssert(!item.findElement(getProductResultsPageThreadLocal().byProductWasPrice).getText().isEmpty(), "ProductWasPrice in searching result is correct", "ProductWasPrice in searching result is incorrect");
			}
			
		}
	}
	
}
