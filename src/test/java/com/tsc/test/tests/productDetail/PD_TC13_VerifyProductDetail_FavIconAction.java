package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC13_VerifyProductDetail_FavIconAction extends BaseTest{
	/*
	 * CER-585
	 * CER-818
	 */
	@Test(groups={"Regression","Regression_Mobile","Regression_Tablet","SauceTunnelTest"})
	public void PD_TC13_VerifyProductDetail_FavIconAction() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		//String lsTellYourFriendsSentMessage=TestDataHandler.constantData.getSearchResultPage().getLbl_TellYourFriendsSentMessage();
		String lsUserName=TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("video", "0");
		outputDataCriteria.put("style", "1");
		outputDataCriteria.put("size", "1");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"AddToBag",outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify FavIcon contents");
			getProductDetailPageThreadLocal().verifyPopupDialogAfterClickingFavIcon();

			reporter.reportLog("Verify FavIcon action");
			getProductDetailPageThreadLocal().verifyFavIconAction(lsUserName, lsPassword);

			if(getProductDetailPageThreadLocal().getShoppingCartNumber()>0){
				reporter.reportLog("Removing Items from shopping Cart after test");
				getShoppingCartThreadLocal().removeItemsAddedFromShoppingCart();
			}
		}
		else {
			reporter.reportLogFail("Unable to find the product item");
		}
	}
}

