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
	String lsVideoDisclaimInfo=TestDataHandler.constantData.getSearchResultPage().getLbl_VideoDisclaimInfo();
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeyword);
	reporter.reportLog("Switch to ProductDetail page");
	String lsProductNumber,lsUrl;
	
	if(getProductResultsPageThreadLocal().goToFirstProductItem()) {
		reporter.reportLog("Verify URL");		
		lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productConvertedNumber;
		lsUrl=basePage.URL();
		reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
		reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);
			
		reporter.reportLog("Verify Video info");
		getProductDetailPageThreadLocal().verifyVideo(lsVideoDisclaimInfo);
		
		reporter.reportLog("Verify Advanced order message");	
		getProductDetailPageThreadLocal().verifyProductAdvancedOrderMessage();
		
		reporter.reportLog("Verify Thumbnail");
		getProductDetailPageThreadLocal().verifyThumbnail();
					
		reporter.reportLog("Verify product name,brand name and product number");	
		getProductDetailPageThreadLocal().verifyProductBasicInfo();
				
		reporter.reportLog("Verify product review");	
		getProductDetailPageThreadLocal().verifyProductReview();
				
		reporter.reportLog("Verify product price and shipping");	
		getProductDetailPageThreadLocal().verifyProductPriceAndShipping();
				
		reporter.reportLog("Verify product style");	
		getProductDetailPageThreadLocal().verifyProductStyle();
				
		reporter.reportLog("Verify product TrueFit");
		getProductDetailPageThreadLocal().verifyProductSizeTrueFit();
		
		reporter.reportLog("Verify product size dropdown");
		getProductDetailPageThreadLocal().verifyProductSizeDropdown();			
				
		reporter.reportLog("Verify product Add to Bag button");	
		getProductDetailPageThreadLocal().verifyProductAddToBagButton();
		
		reporter.reportLog("Verify product style name");
		getProductDetailPageThreadLocal().verifyStyleNameWithDifferentStyleSelection();
		
		reporter.reportLog("Verify linkage among Swatch, Thumbnail and Zoom image");
		getProductDetailPageThreadLocal().verifyLinkageAmongSwathAndThumbnailAndZoomImage();
		
		reporter.reportLog("The linkage between Thumbnail and Zoom image");
		getProductDetailPageThreadLocal().verifyLinkageBetweenThumbnailAndZoomImage();
				
		reporter.reportLog("Verify product quantity");	
		getProductDetailPageThreadLocal().verifyProductQuantityDropdown();
		
	}
	else {
		reporter.reportLogFail("Unable to find the advanced order product item");
	}
	
}

}

