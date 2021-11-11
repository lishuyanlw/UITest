package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC01_Verify_ProductDetail_LeftSection_ContentsForImageAndVideo extends BaseTest{
	/*
	 * CER-576
	 * CER-570
	 * CER-577
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
				
		reporter.reportLog("Verify Video");		
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().imgProductBadge),"The product badge is displaying correctly","The product badge is not displaying correctly");
		reporter.softAssert(!getProductDetailPageThreadLocal().imgProductBadge.getAttribute("src").isEmpty(),"The product badge image source is not empty","The product badge image source is empty");
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
		reporter.softAssert(!getProductDetailPageThreadLocal().lnkVideo.getAttribute("src").isEmpty(),"The product video source is not empty","The product video source is empty");
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblVideoDisclaim).isEmpty(),"The product video disclaim text is not empty","The product video disclaim text is empty");
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
		reporter.softAssert(getProductDetailPageThreadLocal().checkIfAutoPlayVideoStatusIsON(),"The product video AutoPlaying is on","The product video AutoPlaying is off");
		reporter.softAssert(getProductDetailPageThreadLocal().checkIfVideoisPlaying(),"The product video is playing","The product video is not playing");
		
		reporter.reportLog("Verify Thumbnail");
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().cntThumbnailContainer),"The Thumbnail section is displaying correctly","The Thumbnail section is not displaying correctly");
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().btnThumbnailPrev),"The Thumbnail prev button is displaying correctly","The Thumbnail prev button is not displaying correctly");
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().btnThumbnailNext),"The Thumbnail next button is displaying correctly","The Thumbnail next button is not displaying correctly");
		reporter.softAssert(!getProductDetailPageThreadLocal().lnkThumbnailVideo.getAttribute("data-video").isEmpty(),"The video src is not empty","The video src is empty");
		reporter.softAssert(!getProductDetailPageThreadLocal().imgThumbnailVideo.getAttribute("src").isEmpty(),"The video image is not empty","The video image is empty");
		getProductDetailPageThreadLocal().verifyThumbnailImageListSrc();
		getProductDetailPageThreadLocal().verifyThumbnailPrevButton();
		getProductDetailPageThreadLocal().verifyThumbnailNextButton();
	}
	else {
		reporter.reportLogFail("Unable to find the product item with Review, EasyPay, Swatch item>=4 and Video");
	}
	
}

}

