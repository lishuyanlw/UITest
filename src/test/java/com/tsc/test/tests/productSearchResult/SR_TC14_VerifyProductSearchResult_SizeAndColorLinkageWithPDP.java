package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC14_VerifyProductSearchResult_SizeAndColorLinkageWithPDP extends BaseTest{
   /*
   * Bug-19703-PRP to PDP after selecting colour from dropdown(no swatches)
   * Bug-19672-PRP showing result label getting encoded value from search
   * Bug-19544-Select a brand in SYAT should not display Search Term
   * Bug-19651-Search with space not returning any response
   */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet"})
	public void SR_TC14_VerifyProductSearchResult_SizeAndColorLinkageWithPDP() throws IOException {
		//Closing the sign-up pop up on application landing page
		getGlobalFooterPageThreadLocal().closePopupDialog();

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductSearch Page");

		//Defining and Initializing variables to be used
		List<WebElement> productList;
		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		String lsProductNumberToComparePRPAndPDPContent = TestDataHandler.constantData.getSearchResultPage().getLbl_ProductNumberToComparePRPAndPDPContent();
		List<String> lst_SearchKeyword = TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_Bugs();

		reporter.reportLog("verifyInfoLinkageWithPDP using API calling");
		if(getProductResultsPageThreadLocal().findProductItemWithPreConditions(lstKeywordList)) {
			getProductResultsPageThreadLocal().verifyInfoLinkageWithPDP(getProductDetailPageThreadLocal(),null);
		}
		
		reporter.reportLog("verifyInfoLinkageWithPDP using test data directly");
		getProductResultsPageThreadLocal().verifyInfoLinkageWithPDP(getProductDetailPageThreadLocal(),lsProductNumberToComparePRPAndPDPContent);

		reporter.reportLog("verifySearchResultMessageOnPage");
		//Verification of Bug-19544, Bug-19651 Bug-19672
		reporter.reportLog(lst_SearchKeyword.get(1));
		getProductResultsPageThreadLocal().getSearchResultLoad(lst_SearchKeyword.get(1),true);
		getProductResultsPageThreadLocal().verifySearchResultMessageOnPage(lst_SearchKeyword.get(1));

		reporter.reportLog("verifyInfoLinkageWithPDPWithoutSwatch");
		//Verification of Bug-19703
		//Searching keyword - iPads & Tablets on Home Page to load data on PRP page on QA
		getProductResultsPageThreadLocal().getSearchResultLoad(lst_SearchKeyword.get(0),true);
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

