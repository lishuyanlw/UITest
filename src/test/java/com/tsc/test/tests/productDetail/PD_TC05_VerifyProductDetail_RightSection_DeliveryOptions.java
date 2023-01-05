package com.tsc.test.tests.productDetail;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;
import java.io.IOException;


public class PD_TC05_VerifyProductDetail_RightSection_DeliveryOptions extends BaseTest{
	/*
	 * CER-572
	 * CER-588
	 * CER-600
	 * CER-816
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC05_VerifyProductDetail_RightSection_DeliveryOptions() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		String lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLbl_ProductDeliveryOptions();
		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		if(getProductResultsPageThreadLocal().getSearchResultLoad(lsKeyword,true)){
			lsProductNumber=lsKeyword;
			reporter.reportLog("Verify URL for Product Number: " + lsProductNumber);
			lsUrl = basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"), "The Url is containing productdetails", "The Url is not containing productdetails");

			reporter.reportLog("Verify product name,brand name and product number");
			getProductDetailPageThreadLocal().verifyProductBasicInfo();

			reporter.reportLog("Verify product review");
			getProductDetailPageThreadLocal().verifyProductReview();

			reporter.reportLog("Verify product price and shipping");
			getProductDetailPageThreadLocal().verifyProductPriceAndShipping();

			reporter.reportLog("Verify product delivery options");
			getProductDetailPageThreadLocal().verifyProductDeliveryOptions();

			reporter.reportLog("Verify product style");
			if(getProductDetailPageThreadLocal().judgeStyleSizeAvailable(true)){
				getProductDetailPageThreadLocal().verifyProductStyle();
			}
			else{
				reporter.reportLog("There is no product style available");
			}

			reporter.reportLog("Verify product size");
			if(getProductDetailPageThreadLocal().judgeStyleSizeAvailable(false)){
				getProductDetailPageThreadLocal().verifyProductSize();
			}
			else{
				reporter.reportLog("There is no product size available");
			}
		}
		else{
			reporter.reportLogFail("Test case Failed!");
		}
	}

}

