package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC07_VerifyProductDetail_ProductStyle extends BaseTest{
	/*
	 * CER-575
	 * CER-576
	 * CER-577
	 * CER-817
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC07_VerifyProductDetail_ProductStyle() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		//List<String> lstKeywordList=TestDataHandler.constantData.getCheckOut().getLst_SearchingKeywordForPlaceOrder();
		String lsProductNumber,lsUrl;
		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("video", "0");
		outputDataCriteria.put("style", "3");
		outputDataCriteria.put("size", "2");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.reportLog("Switch to ProductDetail page");
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

