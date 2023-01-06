package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC02_VerifyProductSearchResultWithDropDownMenu extends BaseTest{
	/*
	 * CER-213
	 * CER-219
	 * CER-513
	 * CER-700
	 * Bug 19683: [UAT Defect] PRP: Merchandising badges i.e. Clearance, BlockBuster etc. should be bolded - covered in verifySearchResultContent and verifySearchResultContentWithMouseHover functions
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet","Regression_Mobile"})
	public void SR_TC02_VerifyProductSearchResultWithDropDownMenu() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
		
//	String lsSearchResultPageDefaultSetting=TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
	List<List<String>> lsKeywordDropdownList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	List<WebElement> productList;

	int keyWordDropdownSize=lsKeywordDropdownList.size();	
	for(int i=0;i<keyWordDropdownSize;i++) {
		reporter.reportLog("Search keyword : "+lsKeywordDropdownList.get(i));	
		if(lsKeywordDropdownList.get(i).size()==3) {			
			getProductResultsPageThreadLocal().selectSearchResultListInDropdownMenu(lsKeywordDropdownList.get(i).get(0),lsKeywordDropdownList.get(i).get(1),lsKeywordDropdownList.get(i).get(2));
		}
		else {			
			getProductResultsPageThreadLocal().selectSearchResultListInDropdownMenu(lsKeywordDropdownList.get(i).get(0),lsKeywordDropdownList.get(i).get(1),"");
		}
				
		reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");

		if(getProductResultsPageThreadLocal().bVerifyTitle) {
			reporter.softAssert(getProductResultsPageThreadLocal().verifyPageTitleForDropdown(), "Search result page title of "+getProductResultsPageThreadLocal().getProductResultPageTitle()+" is displayed as search keyword in dropdown menu", "Search result page title of "+getProductResultsPageThreadLocal().getProductResultPageTitle()+" is not displayed as search keyword in dropdown menu");
		}
		
		productList=getProductResultsPageThreadLocal().getProductList();
		if(productList.size()>0) {
			getProductResultsPageThreadLocal().verifySearchResultContent(productList,true);
//			getProductResultsPageThreadLocal().verifySearchResultContentWithMouseHover(productList);
		}
		
		}	
	}

}
