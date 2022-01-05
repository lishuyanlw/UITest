package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC06_Verify_ProductDetail_AddToBag extends BaseTest{
	/*
	 * CER-583
	 * CER-606
	 * CER-608
	 * 
	 */
	@Test(groups={"ProductDetail","Regression"})
	public void validateLeftSection_AddToBag() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	BasePage basePage=new BasePage(this.getDriver());
		
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductDetail Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	
//	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	reporter.reportLog("Switch to ProductDetail page");
	String lsProductNumber,lsUrl;
	
	if(getProductResultsPageThreadLocal().goToProductItemWithPreConditions(lsKeywordList.get(0).get(0))) {
		String lbl_AddToBagPopupWindowTitle=TestDataHandler.constantData.getSearchResultPage().getLbl_AddToBagPopupWindowTitle();
		reporter.reportLog("Verify URL");
		lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productNumber;
		lsUrl=basePage.URL();
		reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
		reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);
				
		reporter.reportLog("Verify product Add to Bag button");	
		getProductDetailPageThreadLocal().verifyProductAddToBagButton();
		
		reporter.reportLog("Verify product Add to Bag title and contents");
		getProductDetailPageThreadLocal().verifyProductDetailsInAddToBagPopupWindow(lbl_AddToBagPopupWindowTitle,getProductResultsPageThreadLocal().selectedProductItem);
		
		reporter.reportLog("Verify Shopping cart number");	
		getProductDetailPageThreadLocal().verifyShoppingCartNumber();
	}
	else {
		reporter.reportLogFail("Unable to find the product item with Review, EasyPay, Swatch item>=4 and Video");
	}
	
}

}

