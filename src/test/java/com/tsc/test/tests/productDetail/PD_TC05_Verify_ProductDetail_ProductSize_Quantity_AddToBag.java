package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC05_Verify_ProductDetail_ProductSize_Quantity_AddToBag extends BaseTest{
	/*
	 * CER-576
	 * CER-570
	 * CER-583
	 */
	@Test(groups={"ProductDetail","Regression"})
	public void validateLeftSection_ProductSize_Quantity_AddToSize() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	BasePage basePage=new BasePage(this.getDriver());
		
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductDetail Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantDataOldVariables.getlst_SearchKeyword_DropDown();
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	reporter.reportLog("Switch to ProductDetail page");
	String lsProductNumber,lsUrl;
	
	if(getProductResultsPageThreadLocal().goToProductItemWithReviewAndSwatchAndVideo()) {
		reporter.reportLog("Verify URL");
		lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productConvertedNumber;
		lsUrl=basePage.URL();
		reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
		reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);
		
		if(getProductDetailPageThreadLocal().judgeStyleSizeAvailable()) {
			reporter.reportLog("Verify product size dropdown");
			getProductDetailPageThreadLocal().verifyProductSizeDropdown();			
			
			//Verify product TrueFit	
			reporter.reportLog("Verify product TrueFit");
			getProductDetailPageThreadLocal().verifyProductSizeTrueFit();
			
			//Verify product size
			reporter.reportLog("Verify product size");	
			reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblSizeStatic).isEmpty(),"The product size label message is not empty","The product size label message is empty");
			reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().selectSizeOption),"The product Size option is displaying correctly","The product Size option is not displaying correctly");
			if(getProductDetailPageThreadLocal().IsSoldOutExisting()) {
				reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblSoldOut).isEmpty(),"The product Soldout message is not empty","The product Soldout message is empty");
			}
			if(getProductDetailPageThreadLocal().checkProductSizingChartExisting()) {
				getProductDetailPageThreadLocal().verifyProductQuantitySizingChart();
			}						
		}
		else {
			reporter.reportLogFail("Product size part is not existing!");
		}
				
		//Verify product quantity
		reporter.reportLog("Verify product quantity");	
		getProductDetailPageThreadLocal().verifyProductQuantityDropdown();
		
		//Verify product Add to Bag
		reporter.reportLog("Verify product Add to Bag");	
		getProductDetailPageThreadLocal().verifyProductAddToBag();
		
	}
	else {
		reporter.reportLogFail("Unable to find the product item with Review, EasyPay, Swatch item>=4 and Video");
	}
	
}

}

