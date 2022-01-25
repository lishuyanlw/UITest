package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tsc.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC14_Verify_ProductSearchResult_BreadCrumbBugs extends BaseTest{
	/*
	 * Bug 19659: [QA Defect] PRP Breadcrumb: Not keeping the past filters applied - covered in 
	 * Bug 19690: [UAT Defect] The breadcumb breaks non category/brand PRPs and a server error is triggered - covered in 
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
	public void Verify_ProductSearchResult_BreadCrumbBugs() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();

	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLog("ProductSearch Page");
	
	String lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword().get(2);
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeyword,true);

	List<List<String>> lstFilterBugs=TestDataHandler.constantData.getSearchResultPage().getLst_SearchOption().get(4).getFilterOption();
	
	getProductResultsPageThreadLocal().verifyProductContentNoChangesAfterNavigatingBackWithMultiFilters(lstFilterBugs);


	}
}

