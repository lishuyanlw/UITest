package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC11_Verify_ProductDetail_SocialMediaForMobileAndEmail extends BaseTest{
	/*
	 * CER-585
	 *
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void validateLeftSection_SocialMediaForMobileAndEmail() throws IOException {
		//We don't need to close popup dialog if use api to navigate to PDP page directly.
		//getGlobalFooterPageThreadLocal().closePopupDialog();

		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		//List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		String lsTellYourFriendsSentMessage=TestDataHandler.constantData.getSearchResultPage().getLbl_TellYourFriendsSentMessage();
		String lsUserName=TestDataHandler.constantData.getLoginUser().getLbl_Username();
		String lsPassword=TestDataHandler.constantData.getLoginUser().getLbl_Password();

		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		//if(getProductResultsPageThreadLocal().goToFirstProductItem("402783")) {
			//if(getProductResultsPageThreadLocal().goToFirstProductItem(lsKeywordList.get(0).get(0))) {
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"AddToBag",null)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify FavShareMobile action");
			getProductDetailPageThreadLocal().verifyFavShareMobileAction(lsUserName, lsPassword);

			reporter.reportLog("Verify TellYourFriends Window Content");
			getProductDetailPageThreadLocal().verifyTellYourFriendsWindowContent();

			reporter.reportLog("Verify TellYourFriends Preview Window Content");
			getProductDetailPageThreadLocal().verifyTellYourFriendsPreviewWindowContent();

			reporter.reportLog("Verify TellYourFriends Sent Window Content");
			getProductDetailPageThreadLocal().verifyTellYourFriendsSentWindowContent(lsTellYourFriendsSentMessage);
			getProductDetailPageThreadLocal().closeEmailPopUpWindow();

			if(getProductDetailPageThreadLocal().getShoppingCartNumber()>0){
				reporter.reportLog("Removing Items from shopping Cart after test");
				getShoppingCartThreadLocal().removeItemsAddedToShoppingCart();
			}
		}
		else {
			reporter.reportLogFail("Unable to find the product item");
		}
	}
}

