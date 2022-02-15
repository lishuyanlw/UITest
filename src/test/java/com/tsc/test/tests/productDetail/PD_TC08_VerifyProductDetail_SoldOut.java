package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tsc.test.tests.globalFooter.GF_TC01_VerifySocialMedia;
import com.tsc.test.tests.globalFooter.GF_TC02_VerifyCustomerHubLinksAndAboutTSCLinks;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import com.tsc.test.tests.globalHeader.GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo;
import com.tsc.test.tests.globalHeader.GH_TC02_Verify_Global_Header_SignIn_Favorite_ShoppingCartBag;

public class PD_TC08_VerifyProductDetail_SoldOut extends BaseTest{
	/*
	 * CER-603
	 * CER-605
	 *
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC08_VerifyProductDetail_SoldOut() throws IOException {
		//We need to close popup dialog while using api as otherwise sin-up popup will come as soon we navigate
		//to homepage while test execution
		getGlobalFooterPageThreadLocal().closePopupDialog();

		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");
		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		Map<String,Object> outputDataCriteria = new HashMap<>();
		outputDataCriteria.put("video", "0");
		outputDataCriteria.put("style", "2");
		outputDataCriteria.put("size", "1");

		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		//if(getProductResultsPageThreadLocal().goToFirstProductItem("485939")) {
		//if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"AllConditionsWithCheckingSoldOutCriteria")) {
		//if(getProductResultsPageThreadLocal().goToFirstProductItem("402783")) {
		//Changes made in function getProductInfoForInputParams used under below function for SoldOut with parameters
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"AllConditionsWithCheckingSoldOutCriteria",outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify Current zoom image and message");
			getProductDetailPageThreadLocal().verifyCurrentZoomImage();

			reporter.reportLog("Verify product name,brand name and product number");
			getProductDetailPageThreadLocal().verifyProductSoldOutBasicInfo();

			/*reporter.reportLog("Verify product TrueFit");
			getProductDetailPageThreadLocal().verifyProductSizeTrueFit();*/

			reporter.reportLog("Verify Sold out product messaage");
			getProductDetailPageThreadLocal().verifyProductSoldOut();

			reporter.reportLog("Verify Social media");
			getProductDetailPageThreadLocal().verifySocialMedia();

			if(System.getProperty("Device").equalsIgnoreCase("Desktop") ||
					(System.getProperty("Device").equalsIgnoreCase("Tablet")
							&& System.getProperty("Browser").contains("ios")) ||
					(!"".equals(System.getProperty("chromeMobileDevice")) &&
							System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad"))) {
				GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo headerSectionMenuAndLogoTest = new GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo();
				headerSectionMenuAndLogoTest.validateMajorNameAndLinks();
			}

			GH_TC02_Verify_Global_Header_SignIn_Favorite_ShoppingCartBag headerSectionOthersTest= new GH_TC02_Verify_Global_Header_SignIn_Favorite_ShoppingCartBag();
			headerSectionOthersTest.validateMajorNameAndLinks();

			GF_TC01_VerifySocialMedia footerSectionTest_SocialMedia=new GF_TC01_VerifySocialMedia();
			footerSectionTest_SocialMedia.validateMajorNameAndLinks();

			GF_TC02_VerifyCustomerHubLinksAndAboutTSCLinks footerSectionTest_CustomerHubLinksAndAboutTSCLinks=new GF_TC02_VerifyCustomerHubLinksAndAboutTSCLinks();
			footerSectionTest_CustomerHubLinksAndAboutTSCLinks.validateContents();

		}
		else {
			reporter.reportLogFail("Unable to find the soldout product item");
		}
	}
}

