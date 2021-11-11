package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.ProductResultsPage;
import com.tsc.test.base.BaseTest;

public class SR_TC09_Verify_ProductSearchResult_SpecialOffersAndRecomendationSections extends BaseTest {
	/**
	 * This method will test Clearance in Special Offers and Recommendation sections.
	 * @author Wei.Li
	 * CER-231
	 */
	@Test(groups = { "ProductSearch", "Regression" })
	public void validateProductSearchResult_SpecialOffersAndRecomendationSections() throws IOException {
		(new HomePage(this.getDriver())).closeadd();
		String lsSearchResultPageDefaultSetting = TestDataHandler.constantData.getSearchResultPage().getLbl_SearchResultPageDefaultSetting();
		String lnkProductResult = TestDataHandler.constantData.getSearchResultPage().getLnk_product_result();
		List<String> productRecommendationTitleText = TestDataHandler.constantData.getSearchResultPage().getLbl_ProductRecommendationTitlePage();
		List<WebElement> productList;

		// Corresponding actions (Clearance>>Fashion)
		getglobalheaderPageThreadLocal().clickSubMenuItem("Clearance","Fashion",null);

		// Verifying that landing page is product results page after navigation
		reporter.softAssert(getProductResultsPageThreadLocal().getClearanceOptionURLTitle().contains(lnkProductResult),"Verified that landing page is Product Result Page", "Verified that landing page is not Product Result Page");

		// Verifying title of the page after navigation
		String value = getProductResultsPageThreadLocal().getProductResultPageTitle();
		reporter.softAssert(value.equalsIgnoreCase("FASHION"), "Product Result Title Verified and title is " + value,"Product Result Title is not as expected and title is " + value);

        // Verifying Search Result message and default Page Number Count on Page
		reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(),"Showing text pattern in filters is correct","Showing text pattern in filters is incorrect");
		if(System.getProperty("Device")=="Desktop") {
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
		}

		// Verifying Product List displayed for mandatory information like Product, Name, Image, Price, Code
		productList=getProductResultsPageThreadLocal().getProductList();
		if(productList.size()>0) {
		getProductResultsPageThreadLocal().verifySearchResultContent(productList); }
		reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(),"Product pagination is existing","Product pagination is not existing");
		reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getRecommendationContainer()),"Recommendation section is existing after choosing special offers","Recommendation section is not existing after choosing special offers");

		// Verifying title of the Product Recommendation page
		String pageTitleValue = getProductResultsPageThreadLocal().getProductResultPageTitle(ProductResultsPage.productRecommendationTitle);
		boolean title_Value = pageTitleValue.equalsIgnoreCase(productRecommendationTitleText.get(0)) || pageTitleValue.equalsIgnoreCase(productRecommendationTitleText.get(1));
		reporter.softAssert(title_Value,"Product Recommendation Title is Verified and title is " + pageTitleValue,"Product Recommendation Title is Verified and title is " + pageTitleValue);

		// Verifying Product Recommendation section details
		getProductResultsPageThreadLocal().verify_ProductRecommendationSection();
	}
}