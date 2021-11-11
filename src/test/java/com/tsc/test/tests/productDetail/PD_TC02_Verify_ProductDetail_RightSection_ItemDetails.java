package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC02_Verify_ProductDetail_RightSection_ItemDetails extends BaseTest{
	/*
	 * CER-572	 
	 */
	@Test(groups={"ProductDetail","Regression"})
	public void validateRightSection_ItemDetails() throws IOException {	
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
		
		//Verify product name,brand name and product number
		reporter.reportLog("Verify product name,brand name and product number");	
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblProductName).isEmpty(),"The product name is not empty","The product name is empty");
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lnkBrandName).isEmpty(),"The product brand name is not empty","The product brand name is empty");
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblProductNumber).isEmpty(),"The product number is not empty","The product number is empty");
		
		//Verify product review
		reporter.reportLog("Verify product review");	
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().productReviewSection),"The product review section is displaying correctly","The product review section is not displaying correctly");
		reporter.softAssert(getProductDetailPageThreadLocal().lstProductReviewStar.size()>0,"The product review star count is greater than 0","The product review star count is not greater than 0");
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblProductReview).isEmpty(),"The product review text is not empty","The product review text is empty");
		
		//Verify product price and shipping
		reporter.reportLog("Verify product price and shipping");	
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblProductPriceLabel).isEmpty(),"The product price label is not empty","The product price label is empty");
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblProductNowPrice).isEmpty(),"The product Now price is not empty","The product Now price is empty");
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblProductWasPrice).isEmpty(),"The product Was price is not empty","The product Was price is empty");
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblProductEasyPay).isEmpty(),"The product EasyPay message is not empty","The product EasyPay message is empty");
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblProductSavings).isEmpty(),"The product Saving message is not empty","The product Saving message is empty");
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblProductShipping).isEmpty(),"The product Shipping message is not empty","The product Shipping message is empty");
		
		//Verify product style
		reporter.reportLog("Verify product style");	
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().cntProductStyleSection),"The product style section is displaying correctly","The product style section is not displaying correctly");
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblProductStyleStatic).isEmpty(),"The product style label message is not empty","The product style label message is empty");
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblProductStyleTitle).isEmpty(),"The product style title message is not empty","The product style title message is empty");
		reporter.softAssert(getProductDetailPageThreadLocal().lstStyleRadioList.size()>0,"The product style radio button count is greater than 0","The product style radio button count is not greater than 0");
		
		//Verify product TrueFit
		if(!getProductDetailPageThreadLocal().cntProductTrueFitSection.getCssValue("height").equalsIgnoreCase("0px")) {
			reporter.reportLog("Verify product TrueFit");	
			reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().imgProductTrueFitLogo),"The product TrueFit icon is displaying correctly","The product TrueFit icon is not displaying correctly");
			reporter.softAssert(!basePage.getElementHref(getProductDetailPageThreadLocal().lnkProductTrueFitLink).isEmpty(),"The product TrueFit link is not empty","The product TrueFit link is empty");
		}
		
		//Verify product size
		if(getProductDetailPageThreadLocal().judgeStyleSizeAvailable()) {
			reporter.reportLog("Verify product size");	
			reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblSizeStatic).isEmpty(),"The product size label message is not empty","The product size label message is empty");
			reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().selectSizeOption),"The product Size option is displaying correctly","The product Size option is not displaying correctly");
			if(getProductDetailPageThreadLocal().IsSoldOutExisting()) {
				reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblSoldOut).isEmpty(),"The product Soldout message is not empty","The product Soldout message is empty");
			}			
		}
		
		//Verify product quantity
		reporter.reportLog("Verify product quantity");	
		reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblQuantityStatic).isEmpty(),"The product quantity label message is not empty","The product quantity label message is empty");
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().selectQuantityOption),"The product Quantity option is displaying correctly","The product Quantity option is not displaying correctly");
		if(getProductDetailPageThreadLocal().IsQuantityLeftExisting()) {
			reporter.softAssert(!basePage.getElementText(getProductDetailPageThreadLocal().lblQuantityLeft).isEmpty(),"The product Quantity left message is not empty","The product Quantity left message is empty");
		}
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().btnAddToBag),"The AddToBag button is displaying correctly","The AddToBag button is not displaying correctly");
		
		//Verify Social media
		reporter.reportLog("Verify Social media");	
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().lnkFavShareMobile),"The FavShareMobile section is displaying correctly","The FavShareMobile section is not displaying correctly");
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().lnkFavShareEmail),"The FavShareEmail section is displaying correctly","The FavShareEmail section is not displaying correctly");
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().lnkFaceBook),"The FaceBook section is displaying correctly","The FaceBook section is not displaying correctly");
		reporter.softAssert(!basePage.getElementHref(getProductDetailPageThreadLocal().lnkFaceBook).isEmpty(),"The FaceBook link is not empty","The FaceBook link is empty");
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().lnkTwitter),"The Twitter section is displaying correctly","The Twitter section is not displaying correctly");
		reporter.softAssert(!basePage.getElementHref(getProductDetailPageThreadLocal().lnkTwitter).isEmpty(),"The Twitter link is not empty","The Twitter link is empty");
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().lnkPInterest),"The PInterest section is displaying correctly","The PInterest section is not displaying correctly");
		reporter.softAssert(!basePage.getElementHref(getProductDetailPageThreadLocal().lnkPInterest).isEmpty(),"The PInterest link is not empty","The PInterest link is empty");
		reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getProductDetailPageThreadLocal().lnkFavShareMobile),"The FavShareMobile section is displaying correctly","The FavShareMobile section is not displaying correctly");
				
	}
	else {
		reporter.reportLogFail("Unable to find the product item with Review, EasyPay, Swatch item>=4 and Video");
	}
	
}

}

