package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC04_Verify_ProductDetail_ProductStyle extends BaseTest{
	/*
	 * CER-576
	 * CER-570
	 */
	@Test(groups={"ProductDetail","Regression"})
	public void validateLeftSection_ContentsForImageAndVideo() throws IOException {	
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

		reporter.reportLog("Verify product style name");
		getProductDetailPageThreadLocal().verifyStyleNameWithDifferentStyleSelection();
		
		reporter.reportLog("Verify linkage among Swatch, Thumbnail and Zoom image");
		getProductDetailPageThreadLocal().verifyLinkageAmongSwathAndThumbnailAndZoomImage();
		
		reporter.reportLog("The linkage between Thumbnail and Zoom image");
		getProductDetailPageThreadLocal().verifyLinkageBetweenThumbnailAndZoomImage();
	}
	else {
		reporter.reportLogFail("Unable to find the product item with Review, EasyPay, Swatch item>=4 and Video");
	}
	
}

}

