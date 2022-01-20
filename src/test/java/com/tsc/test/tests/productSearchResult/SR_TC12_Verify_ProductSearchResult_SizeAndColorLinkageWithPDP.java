package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;

import com.tsc.pages.HomePage;
import com.tsc.pages.ProductDetailPage;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC12_Verify_ProductSearchResult_SizeAndColorLinkageWithPDP extends BaseTest{
   /*
   Bug-19703-PRP to PDP after selecting colour from dropdown(no swatches)
   */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet"})
	public void validateProductSearchResult_SizeAndColorLinkageWithPDP() throws IOException {
		//Closing the sign-up pop up on application landing page
		getGlobalFooterPageThreadLocal().closePopupDialog();

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductSearch Page");

		//Defining and Initializing variables to be used
		List<WebElement> productList;
		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		List<String> lst_SearchKeyword = TestDataHandler.constantData.getSearchResultPage().getLst_SearckKeyword_Bugs();

		if(getProductResultsPageThreadLocal().findProductItemWithPreConditions(lstKeywordList)) {
			getProductResultsPageThreadLocal().verifyInfoLinkageWithPDP(getProductDetailPageThreadLocal());
		}

		//Verifying Bug-19703 below
		//Searching keyword - iPads & Tablets on Home Page to load data on PRP page
		getProductResultsPageThreadLocal().getSearchResultLoad(lst_SearchKeyword.get(0));
		//Fetching count of products loaded on screen
		productList=getProductResultsPageThreadLocal().getProductList();
		for(int loop=0;loop<productList.size();loop++) {
			if(getProductResultsPageThreadLocal().findItemWithAvailableSizeAndColorDropDown(productList.get(loop))){
				//Selecting the available size and color for item from dropdown
				getProductResultsPageThreadLocal().verifyInfoLinkageWithPDPWithoutSwatch(productList.get(loop),loop);
				break;
			}
		}

	}

}

