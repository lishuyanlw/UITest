package com.tsc.test.tests.homePage;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC01_Verify_Global_Header_SignIn_Favorite_ShoppingCartBag extends BaseTest {
	/*
	 * CER-152
	 * CER-156
	 * CER-566
	 * CER-153
	 * CER-154
	 */
	@Test(groups={"Home","Regression"})	    
		public void validateGlobalHeader_SignIn_Favorite_ShoppingCartBag() throws IOException {		
		getGlobalFooterPageThreadLocal().closePopupDialog();
		
		BasePage basePage=new BasePage(this.getDriver());
		String lsBaseUrl=basePage.getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Home Page");
		
		String lsUrl,lsYmlNotFound,lsSuccessResult, lsFailResult;
		lsYmlNotFound=TestDataHandler.constantDataVariables.getlnk_NotFound();
		
		reporter.reportLog("Verify searchBox section");
		//Verify searchBox section
		validateText(getglobalheaderPageThreadLocal().validateSearchbox(), TestDataHandler.constantDataVariables.getlbl_SearchBoxPlaceholder(), "Search box is visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateSearchSubmitbtn(), "Search submit button is visible", "Search submit button is not visible");
		
		reporter.reportLog("Verify Sign in section");
		String lsUserName=TestDataHandler.constantDataVariables.getlbl_Username();
		String lsPassword=TestDataHandler.constantDataVariables.getlbl_Password();
		String lsFirstName=TestDataHandler.constantDataVariables.getlbl_FirstName();
		List<String> lstSignInPopover=TestDataHandler.constantDataVariables.getlst_SignInPopover();
				
		//Verify Sign in Text and Icon
		validateText(getglobalheaderPageThreadLocal().validateSignInLink(), TestDataHandler.constantDataVariables.getlbl_SignIn(), "SignIn Link is present & Text is visible");		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateSiginIcon(), "SignIn icon is visible", "SignIn icon is not visible");
		
		getGlobalLoginPageThreadLocal().verifyMenuItemInPopover(lstSignInPopover);
		
		getGlobalLoginPageThreadLocal().verifySignInSection();
		
		getGlobalLoginPageThreadLocal().verifyShowingUserFirstNameAfterSignin(lsUserName, lsPassword,lsFirstName); 
		
		getGlobalLoginPageThreadLocal().SignOut();		
		
		reporter.reportLog("Verify Favourites section");
		//Verify Favourites section
		validateText(getglobalheaderPageThreadLocal().validateFavouritesLink(), TestDataHandler.constantDataVariables.getlbl_Favourites(), "Favourites Link is present & Text is visible");
		
		reporter.reportLog("Verify Shopping Cart section");
		//Verify Shopping Cart section
		validateText(getglobalheaderPageThreadLocal().validateShoppingCartLinkName(), TestDataHandler.constantDataVariables.getlbl_ShoppingCartLinkName(), "Sopping cart Link is present & Text is visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateShoppingCartIcon(), "Shopping cart icon is visible", "Shopping cart icon is not visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateShoppingCartBagCounter(), "Shopping cart Bag counter is visible", "Shopping cart Bag counter is not visible");
		
		//Verify Shopping Cart href matches correct pattern
		lsUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_ShoppingCartLink();
		lsSuccessResult=String.format("Shopping Cart link matches correct pattern of %s", lsUrl);
		lsFailResult=String.format("Shopping Cart link does not match correct pattern of %s", lsUrl);
		reporter.softAssert(getglobalheaderPageThreadLocal().verifyShoppingCartLink(lsUrl), lsSuccessResult, lsFailResult);
		
		//Verify url does not contain notfound after clicking Shopping Cart link
		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingShoppingCartLink();
		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking MiniCart link", lsUrl,lsYmlNotFound);
		lsFailResult=String.format("The url of < %s > contains < %s > after clicking MiniCart link", lsUrl,lsYmlNotFound);
		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
		
		getglobalheaderPageThreadLocal().waitForPageLoad();
						
				
	}
		
}