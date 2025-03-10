package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC11_VerifyProductSearchResult_SpecialOffersAndRecommendationSections extends BaseTest {
	/**
	 * This method will test Clearance in Special Offers and Recommendation sections.
	 * @author Wei.Li
	 * CER-231
	 */
	@Test(groups = { "ProductSearch", "Regression","Regression_Tablet","Regression_Mobile"})
	public void SR_TC11_VerifyProductSearchResult_SpecialOffersAndRecommendationSections() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		//String lsSearchResultPageDefaultSetting = TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
		String lnkProductResult = TestDataHandler.constantData.getSearchResultPage().getLnk_product_result();
		List<String> lst_ClearanceKeyword = TestDataHandler.constantData.getSearchResultPage().getLst_ClearanceKeyword();
		//List<String> productRecommendationTitleText = TestDataHandler.constantData.getSearchResultPage().getLbl_ProductRecommendationTitlePage();
		List<WebElement> productList;

		String subMenuItem = getglobalheaderPageThreadLocal().getNameAndclickSubMenuItem(lst_ClearanceKeyword.get(0),lst_ClearanceKeyword.get(1),lst_ClearanceKeyword.get(2));
		//String subMenuItem = getglobalheaderPageThreadLocal().getNameAndclickSubMenuItem("Clearance","Beauty",null);
		
		(new BasePage(this.getDriver())).getReusableActionsInstance().staticWait(5000);
		
		// Verifying that landing page is product results page after navigation
		reporter.softAssert(getProductResultsPageThreadLocal().getClearanceOptionURLTitle().contains(lnkProductResult),"Verified that landing page is Product Result Page", "Verified that landing page is not Product Result Page");

		// Verifying title of the page after navigation
		String value = getProductResultsPageThreadLocal().getProductResultPageTitle(getProductResultsPageThreadLocal().lblSearchResultTitle);
		boolean bFound=false;
		for(String keyWord:lst_ClearanceKeyword){
			if(keyWord.toLowerCase().contains(value.toLowerCase().trim())){
				bFound=true;
				break;
			}
		}
		if(bFound){
			reporter.reportLogPass("The Product Result Title:"+value+" can be found in Clearance Keyword list in yaml file");
		}
		else{
			reporter.reportLogFail("The Product Result Title:"+value+" can not be found in Clearance Keyword list in yaml file");
		}

        // Verifying Search Result message and default Page Number Count on Page
		reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(),"Showing text pattern in filters is correct","Showing text pattern in filters is incorrect");

		// Verifying Product List displayed for mandatory information like Product, Name, Image, Price, Code
		productList=getProductResultsPageThreadLocal().getProductList();
		if(productList.size()>0) {
			getProductResultsPageThreadLocal().verifySearchResultContent(productList,true);
//			getProductResultsPageThreadLocal().verifySearchResultContentWithMouseHover(productList);
		}
		reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(),"Product pagination is existing","Product pagination is not existing");
		/**
		reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getRecommendationContainer()),"Recommendation section is existing after choosing special offers","Recommendation section is not existing after choosing special offers");

		// Verifying title of the Product Recommendation page
		String pageTitleValue = getProductResultsPageThreadLocal().getProductResultPageTitle(getProductResultsPageThreadLocal().productRecommendationTitle);
		boolean title_Value = pageTitleValue.equalsIgnoreCase(productRecommendationTitleText.get(0)) || pageTitleValue.equalsIgnoreCase(productRecommendationTitleText.get(1));
		reporter.softAssert(title_Value,"Product Recommendation Title is Verified and title is " + pageTitleValue,"Product Recommendation Title is Verified and title is " + pageTitleValue);

		// Verifying Product Recommendation section details
		getProductResultsPageThreadLocal().verify_ProductRecommendationSection();
		 */
	}
}