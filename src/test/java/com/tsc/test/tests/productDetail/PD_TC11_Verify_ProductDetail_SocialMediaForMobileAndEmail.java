package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC11_Verify_ProductDetail_SocialMediaForMobileAndEmail extends BaseTest{
	/*
	 * CER-602
	 * 
	 */
	@Test(groups={"ProductDetail","Regression"})
	public void validateLeftSection_SocialMediaForMobileAndEmail() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	BasePage basePage=new BasePage(this.getDriver());
		
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductDetail Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	String lsTellYourFriendsSentMessage=TestDataHandler.constantData.getSearchResultPage().getLbl_TellYourFriendsSentMessage();
	String lsUserName=TestDataHandler.constantData.getLoginUser().getLbl_Username();
	String lsPassword=TestDataHandler.constantData.getLoginUser().getLbl_Password();
		
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	reporter.reportLog("Switch to ProductDetail page");
	String lsProductNumber,lsUrl;
	
	if(getProductResultsPageThreadLocal().goToFirstProductItem()) {
		reporter.reportLog("Verify URL");		
		lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productConvertedNumber;
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
	
	}
	else {
		reporter.reportLogFail("Unable to find the product item");
	}
	
}

}

