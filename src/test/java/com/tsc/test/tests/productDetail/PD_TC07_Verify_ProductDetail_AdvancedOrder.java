package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC07_Verify_ProductDetail_AdvancedOrder extends BaseTest{
	/*
	 * CER-602
	 * 
	 */
	@Test(groups={"ProductDetail","Regression"})
	public void validateLeftSection_AdvancedOrder() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	BasePage basePage=new BasePage(this.getDriver());
		
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductDetail Page");
	
	String lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLbl_AdvancedOrderkeyword();
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeyword);
	reporter.reportLog("Switch to ProductDetail page");
	String lsProductNumber,lsUrl;
	
	if(getProductResultsPageThreadLocal().goToFirstProductItem()) {
		reporter.reportLog("Verify URL");		
		lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productConvertedNumber;
		lsUrl=basePage.URL();
		reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
		reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);
				
		reporter.reportLog("Verify Advanced order message");	
		getProductDetailPageThreadLocal().verifyProductAdvancedOrderMessage();
		
		reporter.reportLog("Verify Thumbnail");
		getProductDetailPageThreadLocal().verifyThumbnail();
	
		//Verify product name,brand name and product number
		reporter.reportLog("Verify product name,brand name and product number");	
		getProductDetailPageThreadLocal().verifyProductBasicInfo();
		
		//Verify product review
		reporter.reportLog("Verify product review");	
		getProductDetailPageThreadLocal().verifyProductReview();
		
		//Verify product price and shipping
		reporter.reportLog("Verify product price and shipping");	
		getProductDetailPageThreadLocal().verifyProductPriceAndShipping();
		
		//Verify product style
		reporter.reportLog("Verify product style");	
		getProductDetailPageThreadLocal().verifyProductStyle();
		
		//Verify product TrueFit	
		reporter.reportLog("Verify product TrueFit");
		getProductDetailPageThreadLocal().verifyProductSizeTrueFit();
		
		reporter.reportLog("Verify product size dropdown");
		getProductDetailPageThreadLocal().verifyProductSizeDropdown();			
		
		//Verify product Add to Bag
		reporter.reportLog("Verify product Add to Bag button");	
		getProductDetailPageThreadLocal().verifyProductAddToBagButton();
				
		//Verify Social media
		reporter.reportLog("Verify Social media");	
		getProductDetailPageThreadLocal().verifySocialMedia();		
		
		reporter.reportLog("Verify product style name");
		getProductDetailPageThreadLocal().verifyStyleNameWithDifferentStyleSelection();
		
		reporter.reportLog("Verify linkage among Swatch, Thumbnail and Zoom image");
		getProductDetailPageThreadLocal().verifyLinkageAmongSwathAndThumbnailAndZoomImage();
		
		reporter.reportLog("The linkage between Thumbnail and Zoom image");
		getProductDetailPageThreadLocal().verifyLinkageBetweenThumbnailAndZoomImage();
		
		//Verify product quantity
		reporter.reportLog("Verify product quantity");	
		getProductDetailPageThreadLocal().verifyProductQuantityDropdown();
		
		//Verify Navigation Back button
		reporter.reportLog("Verify Navigation Back button");	
		getProductDetailPageThreadLocal().verifyBreadCrumbNavigationBack();
		
	}
	else {
		reporter.reportLogFail("Unable to find the advanced order product item");
	}
	
}

}

