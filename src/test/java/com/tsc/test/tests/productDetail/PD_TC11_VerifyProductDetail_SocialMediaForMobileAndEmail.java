package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC11_VerifyProductDetail_SocialMediaForMobileAndEmail extends BaseTest{
	/*
	 * CER-585
	 *
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC11_VerifyProductDetail_SocialMediaForMobileAndEmail() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		String lsTellYourFriendsSentMessage=TestDataHandler.constantData.getSearchResultPage().getLbl_TellYourFriendsSentMessage();
		String lsUserName=TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

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

