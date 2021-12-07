package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC02_Verify_Global_Header_SignIn_Favorite_ShoppingCartBag extends BaseTest {
	/*
	 * CER-152
	 * CER-156
	 * CER-566
	 * CER-153
	 * CER-154
	 */
	@Test(groups={"Home","Regression","Regression_Mobile","GlobalHeader"})	    
		public void validateGlobalHeader_SignIn_Favorite_ShoppingCartBag() throws IOException {		
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Home Page");
		
		validateMajorNameAndLinks();
		validateActionContents();		
				
	}
	
	public void validateActionContents() {
		reporter.reportLog("Global Header Section contents for SignIn_Favorite_ShoppingCartBag");
			
		String lsUrl,lsYmlNotFound,lsSuccessResult, lsFailResult;		
		lsYmlNotFound=TestDataHandler.constantData.getHeaderSection().getLnk_NotFound();
		reporter.reportLog("Verify Sign in section");
		String lsUserName=TestDataHandler.constantData.getLoginUser().getLbl_Username();
		String lsPassword=TestDataHandler.constantData.getLoginUser().getLbl_Password();
		String lsFirstName=TestDataHandler.constantData.getLoginUser().getLbl_FirstName();
				
		//Verify Sign in Text and Icon
		getGlobalLoginPageThreadLocal().verifySignInSection();		
		getGlobalLoginPageThreadLocal().verifyShowingUserFirstNameAfterSignin(lsUserName, lsPassword,lsFirstName);		
		getGlobalLoginPageThreadLocal().SignOut();		
		reporter.reportLog("Verify Shopping Cart section");
		//Verify url does not contain notfound after clicking Shopping Cart link
		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingShoppingCartLink();
		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking MiniCart link", lsUrl,lsYmlNotFound);
		lsFailResult=String.format("The url of < %s > contains < %s > after clicking MiniCart link", lsUrl,lsYmlNotFound);
		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
		
		getglobalheaderPageThreadLocal().waitForPageLoad();
	}
	
	public void validateMajorNameAndLinks() {
		reporter.reportLog("Global Header Section contents for SignIn_Favorite_ShoppingCartBag");
		
		BasePage basePage=new BasePage(this.getDriver());
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		String lsUrl,lsSuccessResult, lsFailResult;
		
		reporter.reportLog("Verify searchBox section");
		//Verify searchBox section
		validateText(getglobalheaderPageThreadLocal().validateSearchbox(), TestDataHandler.constantData.getHeaderSection().getLbl_SearchBoxPlaceholder(), "Search box is visible");
		reporter.softAssert(getglobalheaderPageThreadLocal().validateSearchSubmitbtn(), "Search submit button is visible", "Search submit button is not visible");
		if(getglobalheaderPageThreadLocal().getPopupWindowByClickingSearchBox()) {
			reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getglobalheaderPageThreadLocal().cntTrendingListWithoutKeyword),"Trending section is displaying correctly in search popup window","Trending section is not displaying correctly in search popup window");
			reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getglobalheaderPageThreadLocal().cntFeaturedBrandsListWithoutKeyword),"Featured brands section is displaying correctly in search popup window","Featured brands section is not displaying correctly in search popup window");
			reporter.softAssert(basePage.getReusableActionsInstance().isElementVisible(getglobalheaderPageThreadLocal().cntPossibleItemMatchesList),"Top selling products section is displaying correctly in search popup window","Top selling products section is not displaying correctly in search popup window");
			
			getglobalheaderPageThreadLocal().verifyTopSellingProductsExistingByChangingItemInTrendingOrFeaturedBrandsList(getglobalheaderPageThreadLocal().lstTrendingLinkWithoutKeyword);
			getglobalheaderPageThreadLocal().verifyTopSellingProductsExistingByChangingItemInTrendingOrFeaturedBrandsList(getglobalheaderPageThreadLocal().lstFeaturedBrandsLinkWithoutKeyword);
		}else {
			reporter.reportLogFail("Unable to get popup window by clicking search box");
		}
		basePage.pressEscapeKey();
		
		reporter.reportLog("Verify Sign in section");

		List<String> lstSignInPopover=TestDataHandler.constantData.getHeaderSection().getLst_SignInPopover();
				
		//Verify Sign in Text and Icon
		validateText(getglobalheaderPageThreadLocal().validateSignInLink(), TestDataHandler.constantData.getHeaderSection().getLbl_SignIn(), "SignIn Link is present & Text is visible");
		reporter.softAssert(getglobalheaderPageThreadLocal().validateSiginIcon(), "SignIn icon is visible", "SignIn icon is not visible");
		getGlobalLoginPageThreadLocal().verifyMenuItemInPopover(lstSignInPopover);
			
		reporter.reportLog("Verify Favourites section");
		//Verify Favourites section
		validateText(getglobalheaderPageThreadLocal().validateFavouritesLink(), TestDataHandler.constantData.getHeaderSection().getLbl_Favourites(), "Favourites Link is present & Text is visible");
		
		reporter.reportLog("Verify Shopping Cart section");
		//Verify Shopping Cart section
		validateText(getglobalheaderPageThreadLocal().validateShoppingCartLinkName(), TestDataHandler.constantData.getHeaderSection().getLbl_ShoppingCartLinkName(), "Sopping cart Link is present & Text is visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateShoppingCartIcon(), "Shopping cart icon is visible", "Shopping cart icon is not visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateShoppingCartBagCounter(), "Shopping cart Bag counter is visible", "Shopping cart Bag counter is not visible");
		
		//Verify Shopping Cart href matches correct pattern
		lsUrl=basePage.removeLastSlashFromUrl(lsBaseUrl)+TestDataHandler.constantData.getHeaderSection().getLnk_ShoppingCartLink();
		lsSuccessResult=String.format("Shopping Cart link matches correct pattern of %s", lsUrl);
		lsFailResult=String.format("Shopping Cart link does not match correct pattern of %s", lsUrl);
		reporter.softAssert(getglobalheaderPageThreadLocal().verifyShoppingCartLink(lsUrl), lsSuccessResult, lsFailResult);

	}

}