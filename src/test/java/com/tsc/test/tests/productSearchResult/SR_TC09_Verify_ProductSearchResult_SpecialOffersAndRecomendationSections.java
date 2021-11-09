package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC09_Verify_ProductSearchResult_SpecialOffersAndRecomendationSections extends BaseTest{
	/**
	 * This method will test Clearance in Special Offers and Recommendation sections.
	 * @author Wei.Li

	/*
	 * CER-231
	 */
	@Test(groups={"ProductSearchToBeFix","ToBeFixedForMenuClick"})
	public void validateProductSearchResult_SpecialOffersAndRecomendationSections() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductSearch Page");

		String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();
		String lnkProductResult=TestDataHandler.constantDataVariables.getLnk_product_result();
		List<WebElement> productList;

		//Need to add more actions for clicking Clearance and fashion in Heading menu
		//Corresponding actions (Clearance>>Fashion>>Shop all fashion)
		getglobalheaderPageThreadLocal().clickOnClearanceHeaderOption();
		getglobalheaderPageThreadLocal().clickSubMenuLink();

		//Verifying title of the page after navigating from header link as Clearance
		String value=getProductResultsPageThreadLocal().getProductResultPageTitle();
		reporter.softAssert(value.equalsIgnoreCase("Clearance"),"Product Result Title Verified and title is "+value,"Product Result Title is not as expected and title is "+value);

		//Verifying that landing page is product results page after navigation
		reporter.softAssert(getProductResultsPageThreadLocal().getClearanceOptionURLTitle().contains(lnkProductResult),"","");

		//Verifying Search Result message and default Page Number Count on Page
		reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
		if(System.getProperty("Device")=="Desktop") {
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
		}

		//Verifying Product List displayed for mandatory information like Product Name, Image, Price, Code
		productList=getProductResultsPageThreadLocal().getProductList();
		if(productList.size()>0) {
			getProductResultsPageThreadLocal().verifySearchResultContent(productList);
		}

		reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
		reporter.softAssert(getProductResultsPageThreadLocal().verifyElementExisting(getProductResultsPageThreadLocal().getRecommendationContainer()), "Recommendation section is existing after choosing special offers", "Recommendation section is not existing after choosing special offers");

	}
}
