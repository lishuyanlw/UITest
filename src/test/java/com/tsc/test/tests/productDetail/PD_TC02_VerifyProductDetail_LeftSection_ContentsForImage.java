package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC02_VerifyProductDetail_LeftSection_ContentsForImage extends BaseTest{
	/*
	 * CER-567
	 * CER-570
	 * CER-598
	 * CER-599
	 * CER-604
	 * CER-819
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC02_VerifyProductDetail_LeftSection_ContentsForImage() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		String lsVideoDisclaimInfo=TestDataHandler.constantData.getSearchResultPage().getLbl_VideoDisclaimInfo();
		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();

		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("video", "-1");
		outputDataCriteria.put("style", "6");
		outputDataCriteria.put("size", "2");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify Thumbnail image list");
			getProductDetailPageThreadLocal().verifyThumbnailImageListSrc();

			reporter.reportLog("Verify Thumbnail prev button action");
			if(getProductDetailPageThreadLocal().setPrevButtonDisplayingInThumbnailList()){
				reporter.reportLogPass("Set Prev Button Displaying successfully");
			}
			else{
				reporter.reportLogFailWithScreenshot("Set Prev Button Displaying failed");
			}
			getProductDetailPageThreadLocal().verifyThumbnailPrevButton();

			reporter.reportLog("Verify Thumbnail Next button action");
			if(getProductDetailPageThreadLocal().setNextButtonDisplayingInThumbnailList()){
				reporter.reportLogPass("Set Next Button Displaying successfully");
			}
			else{
				reporter.reportLogFailWithScreenshot("Set Next Button Displaying failed");
			}
			getProductDetailPageThreadLocal().verifyThumbnailNextButton();

			reporter.reportLog("Verify Thumbnail Prev button disappear");
			if(getProductDetailPageThreadLocal().setPrevButtonDisappearInThumbnailList()){
				reporter.reportLogPass("Set Prev Button Disappear successfully");
			}
			else{
				reporter.reportLogFailWithScreenshot("Set Prev Button Disappear failed");
			}

			reporter.reportLog("Verify Thumbnail Next button disappear");
			if(getProductDetailPageThreadLocal().setNextButtonDisappearInThumbnailList()){
				reporter.reportLogPass("Set Next Button Disappear successfully");
			}
			else{
				reporter.reportLogFailWithScreenshot("Set Next Button Disappear failed");
			}

		}
		else {
			reporter.reportLogFail("Unable to find the product item with Review, EasyPay, Swatch item>=4 and Video");
		}
	}
}

