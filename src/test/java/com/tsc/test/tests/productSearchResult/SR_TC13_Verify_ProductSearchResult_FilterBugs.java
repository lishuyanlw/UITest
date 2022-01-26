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

public class SR_TC13_Verify_ProductSearchResult_FilterBugs extends BaseTest{
	/*
	 * Bug 19629: [QA Defect - P3] Product card: if a product doesn't have color swatch, all color options show as plain circles - covered in selectFilterItemInLeftPanel function
	 * Bug 19658: [QA Defect - P3] PRP: Page not refreshed to previous state with browser back button with filter applied - covered in verifyProductContentNoChangesAfterNavigatingBackWithMultiFilters function 
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
	public void Verify_ProductSearchResult_FilterBugs() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();

	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLog("ProductSearch Page");
	
	String lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword().get(2);
	
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeyword,true);
	
	List<List<String>> lstFilterBugs=TestDataHandler.constantData.getSearchResultPage().getLst_SearchOption().get(4).getFilterOption();
	
	reporter.reportLog("verifyProductContentNoChangesAfterNavigatingBackWithMultiFilters");
	getProductResultsPageThreadLocal().verifyProductContentNoChangesAfterNavigatingBackWithMultiFilters(lstFilterBugs);


	}
}

