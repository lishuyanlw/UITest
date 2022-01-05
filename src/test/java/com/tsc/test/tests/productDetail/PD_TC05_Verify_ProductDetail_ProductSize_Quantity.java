package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC05_Verify_ProductDetail_ProductSize_Quantity extends BaseTest{
	/*
	 * CER-578
	 * CER-582
	 * CER-601
	 */
	@Test(groups={"ProductDetail","Regression"})
	public void validateLeftSection_ProductSize_Quantity() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	BasePage basePage=new BasePage(this.getDriver());
		
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductDetail Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	String lsQuantityNumberToShowLeftItemInfo=TestDataHandler.constantData.getSearchResultPage().getLbl_QuantityNumberToShowLeftItemInfo();
	
//	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	reporter.reportLog("Switch to ProductDetail page");
	String lsProductNumber,lsUrl;
	
	if(getProductResultsPageThreadLocal().goToProductItemWithPreConditions(lsKeywordList.get(0).get(0))) {
		reporter.reportLog("Verify URL");		
		lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productNumber;
		lsUrl=basePage.URL();
		reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
		reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);
		
		reporter.reportLog("Verify product size dropdown");
		getProductDetailPageThreadLocal().verifyProductSizeDropdown();			
						
		reporter.reportLog("Verify product quantity");	
		getProductDetailPageThreadLocal().verifyProductQuantityDropdown(Integer.parseInt(lsQuantityNumberToShowLeftItemInfo));
	}
	else {
		reporter.reportLogFail("Unable to find the product item with Size, TrueFit, Quantity and Left items info");
	}
	
}

}

