package com.tsc.test.tests.productDetail;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PD_TC01_VerifyProductDetail_LeftSection_ContentsForVideo extends BaseTest{
	/*
	 * CER-567
	 * CER-570
	 * CER-598
	 * CER-599
	 * CER-604
	 * CER-819
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC01_VerifyProductDetail_LeftSection_ContentsForVideo() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		String lsVideoDisclaimInfo=TestDataHandler.constantData.getSearchResultPage().getLbl_VideoDisclaimInfo();
		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();

		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("video", "1");
		outputDataCriteria.put("style", "1");
		outputDataCriteria.put("size", "1");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			getProductDetailPageThreadLocal().setVideoAsFirstItemInThumbnailList();

			reporter.reportLog("Verify Video part");
			getProductDetailPageThreadLocal().verifyVideo(lsVideoDisclaimInfo);

			//there is no autoplay option for tablet and mobile
			reporter.reportLog("Verify Video off function");
			getProductDetailPageThreadLocal().verifyVideoOff();

			//Verification of Header Menu Items on Page
			reporter.reportLog("Verification of Global Header on Page");
			getglobalheaderPageThreadLocal().verifyHeaderItemsOnPage();

			reporter.reportLog("Verify Global Footer on Page");
			getGlobalFooterPageThreadLocal().verifyFooterItemsOnPage();
		}
		else {
			reporter.reportLogFail("Unable to find the product item with Review, EasyPay, Swatch item>=4 and Video");
		}
	}
}

