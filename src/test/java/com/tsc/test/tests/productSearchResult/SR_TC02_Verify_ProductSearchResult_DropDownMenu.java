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

public class SR_TC02_Verify_ProductSearchResult_DropDownMenu extends BaseTest{
	
	/**
	 * This method will test functions of product searching results from select searching item from dropdwon menu.
	 *
	 * @author Wei.Li
	 */	
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult_DropdownMenu() throws IOException {	
	(new HomePage(this.getDriver())).closeadd();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();
	List<String> lskeywordDropdownList=TestDataHandler.constantDataVariables.getlst_SearchKeyword_DropDown();
	int keyWordDropdownSize=lskeywordDropdownList.size();
	for(int i=0;i<keyWordDropdownSize;i++) {
		getProductResultsPageThreadLocal().selectSearchResultListInDropdownMenu(lskeywordDropdownList.get(i),0);
		System.out.println(lskeywordDropdownList.get(i));
		reporter.reportLog("Search keyword : "+lskeywordDropdownList.get(i));
		
		reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
		reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
		reporter.softAssert(getProductResultsPageThreadLocal().verifyPageTitleForDropdown(), "Search result page title is dispalyed as search keyword in dropdown menu", "Search result page title is not dispalyed as search keyword in dropdown menu");
		verifySearchResultContent();
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
