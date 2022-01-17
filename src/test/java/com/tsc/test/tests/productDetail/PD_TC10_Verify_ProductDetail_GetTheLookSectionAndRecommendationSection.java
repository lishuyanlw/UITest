package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import com.tsc.test.tests.globalFooter.GF_TC01_Verify_GlobalFooter_SocialMedia;
import com.tsc.test.tests.globalFooter.GF_TC02_Verify_GlobalFooter_CustomerHubLinksAndAboutTSCLinks;
import com.tsc.test.tests.globalHeader.GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo;
import com.tsc.test.tests.globalHeader.GH_TC02_Verify_Global_Header_SignIn_Favorite_ShoppingCartBag;

public class PD_TC10_Verify_ProductDetail_GetTheLookSectionAndRecommendationSection extends BaseTest{
	/*
	 * CER-596
	 * CER-597 
	 */
	@Test(groups={"ProductDetail","Regression"})
	public void validateLeftSection_GetTheLookSectionAndRecommendationSection() throws IOException {	
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	BasePage basePage=new BasePage(this.getDriver());
		
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductDetail Page");
	
//	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	String lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLbl_ProductNumberWithBandAndReviewAndSeeMore();
	
//	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
	reporter.reportLog("Switch to ProductDetail page");
	String lsProductNumber,lsUrl;
	
	if(getProductResultsPageThreadLocal().goToFirstProductItem(lsKeyword)) {
		reporter.reportLog("Verify URL");		
		lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productNumber;
		lsUrl=basePage.URL();
		reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
		reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);
				
		reporter.reportLog("Verify Get the look contents");
		getProductDetailPageThreadLocal().verifyGetTheLookSection();
		
		reporter.reportLog("Verify Prev and Next buttons in Get the look section");
		getProductDetailPageThreadLocal().verifyPrevAndNextButtonActionInGetTheLookSection();
			
		reporter.reportLog("Verifying Product Recommendation section details");
		getProductResultsPageThreadLocal().verify_ProductRecommendationSection();		
	}
	else {
		reporter.reportLogFail("Unable to find the product item with SeeMore info");
	}
	
}

}

