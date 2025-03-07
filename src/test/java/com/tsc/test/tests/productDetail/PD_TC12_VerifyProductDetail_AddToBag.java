package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC12_VerifyProductDetail_AddToBag extends BaseTest{
	/*
	 * CER-583
	 * CER-606
	 * CER-608
	 * CER-818
	 * CER-839
	 * CER-838
	 * CER-847
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC12_VerifyProductDetail_AddToBag() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		String lsProductNumber,lsUrl;

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		//outputDataCriteria.put("video", "0");
		outputDataCriteria.put("style", "2");
		outputDataCriteria.put("size", "2");
		outputDataCriteria.put("quantity", "2");
		//if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"AllConditionsWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForMultipleStyleAndSize",outputDataCriteria)) {
			String lbl_AddToBagPopupWindowTitle=TestDataHandler.constantData.getSearchResultPage().getLbl_AddToBagPopupWindowTitle();
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.reportLog("Switch to ProductDetail page");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify product Add to Bag button");
			getProductDetailPageThreadLocal().verifyProductAddToBagButton();

			reporter.reportLog("Verify product Add to Bag title and contents");
			Map<String,Object> mapPDP=getProductDetailPageThreadLocal().getPDPDesc();
			Map<String,Object> mapAddToBag=getProductDetailPageThreadLocal().verifyProductDetailsInAddToBagPopupWindow(lbl_AddToBagPopupWindowTitle,getProductDetailPageThreadLocal().selectedProduct);
			reporter.reportLog("Verify contents between PDP and AddToBag");
			getProductDetailPageThreadLocal().verifyContentsBetweenPDPAndAddToBag(mapPDP,mapAddToBag);

			//Selecting product again that has more than one quantity to test close Add to Bag pop-up functionality
			//https://reqcentral.com/browse/CER-838 - Verifying close button is present and clickable
			mapPDP=null;
			mapAddToBag = null;
			reporter.reportLog("Verify contents between PDP and AddToBag after closing Pop-Up window");
			getProductDetailPageThreadLocal().selectSizeAndStyleWithMoreThanOneQuantity();
			mapPDP = getProductDetailPageThreadLocal().getPDPDesc();
			mapAddToBag = getProductDetailPageThreadLocal().closeAddToBagPopUpWindowAfterClickingOutsidePopUp(lbl_AddToBagPopupWindowTitle);
			getProductDetailPageThreadLocal().verifyContentsBetweenPDPAndAddToBag(mapPDP,mapAddToBag);

			//Navigate back to PDP page
			reporter.reportLog("Verify contents between PDP and AddToBag after selecting size and colour other than default values on PDP");
			getDriver().navigate().to(lsUrl);
			Map<String,String> defaultSelectedValues = getProductDetailPageThreadLocal().fetchDefaultSizeAndStyleSelectedForUserOnPDP();
			String[] lstStyle=getProductDetailPageThreadLocal().getStyleList();
			//https://reqcentral.com/browse/CER-847
			getProductDetailPageThreadLocal().selectSizeAndColourOtherThanDefaultOnPDP(defaultSelectedValues,lstStyle);
			mapPDP=null;
			mapAddToBag = null;
			mapPDP=getProductDetailPageThreadLocal().getPDPDesc();
			mapAddToBag=getProductDetailPageThreadLocal().verifyProductDetailsInAddToBagPopupWindow(lbl_AddToBagPopupWindowTitle,getProductDetailPageThreadLocal().selectedProduct);
			getProductDetailPageThreadLocal().verifyContentsBetweenPDPAndAddToBag(mapPDP,mapAddToBag);

			reporter.reportLog("Verify Shopping cart number");
			//int shoppingCartCount = getProductDetailPageThreadLocal().getShoppingCartNumber();
			getProductDetailPageThreadLocal().verifyShoppingCartNumber(3);
		}
		else {
			reporter.reportLogFail("Unable to find the product item with given search criteria");
		}
	}
}

