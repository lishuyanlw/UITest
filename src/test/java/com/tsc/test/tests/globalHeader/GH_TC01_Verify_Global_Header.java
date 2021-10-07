package com.tsc.test.tests.globalHeader;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC01_Verify_Global_Header extends BaseTest {
	
	@Test(groups={"Home","Regression"})	    
		public void validateGlobalHeaderLinks() throws IOException {
		
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		
		String lsUrl,lsYmlNotFound,lsYmlFullUrl,lsSuccessResult, lsFailResult;
		lsYmlNotFound=TestDataHandler.constantDataVariables.getlnk_NotFound();
		
		reporter.softAssert(getglobalheaderPageThreadLocal().DynamicEventLinkVisible(), "Dynamic Event Link is visible", "Dynamic Event Link is not visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateDynamicEventLink(), "Dynamic Event href is existing", "Dynamic Event href is not existing");
	
		//Verify headers text
		reporter.softAssert(getglobalheaderPageThreadLocal().getTSText().startsWith(TestDataHandler.constantDataVariables.getlbl_TodaysShowstopper()), "TS Link is present & Text is visible","TS Link is present & Text is not visible");
		
		validateText(getglobalheaderPageThreadLocal().getDealsText(), TestDataHandler.constantDataVariables.getlbl_Deals_English(), "Deals Link is present & Text is visible");
		
		validateText(getglobalheaderPageThreadLocal().getOnAirText(), TestDataHandler.constantDataVariables.getlbl_OnAirProducts_English(), "On Air Products Link is present & Text is visible");
		
		validateText(getglobalheaderPageThreadLocal().getProgramGuideText(), TestDataHandler.constantDataVariables.getlbl_ProgramGuide_English(), "Program Guide Link is present & Text is visible");
				
		validateText(getglobalheaderPageThreadLocal().getWatchUsLiveText(), TestDataHandler.constantDataVariables.getlbl_WatchUsLive_English(), "Watch Us Live Link is present & Text is visible");
		
		//Verify TodaysShowstopper link
		lsUrl=getglobalheaderPageThreadLocal().getTSLink();	
		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_TodaysShowstopper();
		lsSuccessResult=String.format("The TodayShowstopper url of < %s > matches < %s > in yml file", lsUrl,lsYmlFullUrl);
		lsFailResult=String.format("The TodayShowstopper url of < %s > does not match < %s > in yml file", lsUrl,lsYmlFullUrl);
		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
		
		//Verify Deals link
		lsUrl=getglobalheaderPageThreadLocal().getDealsLink();	
		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_Deals();
		lsSuccessResult=String.format("The Deals url of < %s > matches < %s > in yml file", lsUrl,lsYmlFullUrl);
		lsFailResult=String.format("The Deals url of < %s > does not match < %s > in yml file", lsUrl,lsYmlFullUrl);
		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
		
		//Verify OnAir link
		lsUrl=getglobalheaderPageThreadLocal().getOnAirLink();	
		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_OnAirProducts();
		lsSuccessResult=String.format("The OnAir url of < %s > matches < %s > in yml file", lsUrl,lsYmlFullUrl);
		lsFailResult=String.format("The OnAir url of < %s > does not match < %s > in yml file", lsUrl,lsYmlFullUrl);
		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
		
		//Verify ProgramGuide link
		lsUrl=getglobalheaderPageThreadLocal().getProgramGuideLink();	
		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_ProgramGuide();
		lsSuccessResult=String.format("The ProgramGuide url of < %s > matches < %s > in yml file", lsUrl,lsYmlFullUrl);
		lsFailResult=String.format("The ProgramGuide url of < %s > does not match < %s > in yml file", lsUrl,lsYmlFullUrl);
		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
		
		//Verify WatchUsLive link
		lsUrl=getglobalheaderPageThreadLocal().getWatchUsLiveLink();	
		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_WatchUsLive();
		lsSuccessResult=String.format("The ProgramGuide url of < %s > matches < %s > in yml file", lsUrl,lsYmlFullUrl);
		lsFailResult=String.format("The ProgramGuide url of < %s > does not match < %s > in yml file", lsUrl,lsYmlFullUrl);
		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);

		//Verify headers icon
		reporter.softAssert(getglobalheaderPageThreadLocal().validateProgramGuideIconVisible(), "Program Guide icon is visible", "Program Guide icon is not visible");
		reporter.softAssert(getglobalheaderPageThreadLocal().validateWatchUsLiveIconVisible(), "Watch Us icon is visible", "Watch Us icon is  not visible");
		
		//Verify notfound and full url after clicking TodayShowstopper link
		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingTSLink();		
		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking TodayShowstopper link", lsUrl,lsYmlNotFound);
		lsFailResult=String.format("The url of < %s > contains < %s > after clicking TodayShowstopper link", lsUrl,lsYmlNotFound);
		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
		
		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_TodaysShowstopper();
		lsSuccessResult=String.format("The url of < %s > matches < %s > after clicking TodayShowstopper link", lsUrl,lsYmlFullUrl);
		lsFailResult=String.format("The url of < %s > does not match < %s > after clicking TodayShowstopper link", lsUrl,lsYmlFullUrl);
		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
		
		getglobalheaderPageThreadLocal().waitForPageLoad();
			
		//Verify notfound and full url after clicking Deals link
		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingDealsLink();		
		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking Deals link", lsUrl,lsYmlNotFound);
		lsFailResult=String.format("The url of < %s > contains < %s > after clicking Deals link", lsUrl,lsYmlNotFound);
		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
		
		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_Deals();
		lsSuccessResult=String.format("The url of < %s > matches < %s > after clicking Deals link", lsUrl,lsYmlFullUrl);
		lsFailResult=String.format("The url of < %s > does not match < %s > after clicking Deals link", lsUrl,lsYmlFullUrl);
		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
		
		getglobalheaderPageThreadLocal().waitForPageLoad();
		
		//Verify notfound and full url after clicking OnAir link
		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingOnAirLink();		
		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking OnAir link", lsUrl,lsYmlNotFound);
		lsFailResult=String.format("The url of < %s > contains < %s > after clicking OnAir link", lsUrl,lsYmlNotFound);
		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
		
		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_OnAirProducts();
		lsSuccessResult=String.format("The url of < %s > matches < %s > after clicking OnAir link", lsUrl,lsYmlFullUrl);
		lsFailResult=String.format("The url of < %s > does not match < %s > after clicking OnAir link", lsUrl,lsYmlFullUrl);
		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
		
		getglobalheaderPageThreadLocal().waitForPageLoad();	
			
		//Verify notfound and full url after clicking ProgramGuide link
		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingProgramGuideLink();		
		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking ProgramGuide link", lsUrl,lsYmlNotFound);
		lsFailResult=String.format("The url of < %s > contains < %s > after clicking ProgramGuide link", lsUrl,lsYmlNotFound);
		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
		
		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_ProgramGuideRedirect();
		lsSuccessResult=String.format("The url of < %s > matches < %s > after clicking ProgramGuide link", lsUrl,lsYmlFullUrl);
		lsFailResult=String.format("The url of < %s > does not match < %s > after clicking ProgramGuide link", lsUrl,lsYmlFullUrl);
		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
		
		(new BasePage(this.getDriver())).navigateToURL(lsBaseUrl+"/");
			
		//Verify notfound and full url after clicking WatchUsLive link
		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingWatchUsLiveLink();		
		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking WatchUsLive link", lsUrl,lsYmlNotFound);
		lsFailResult=String.format("The url of < %s > contains < %s > after clicking WatchUsLive link", lsUrl,lsYmlNotFound);
		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
		
		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_WatchUsLive();
		lsSuccessResult=String.format("The url of < %s > matches < %s > after clicking WatchUsLive link", lsUrl,lsYmlFullUrl);
		lsFailResult=String.format("The url of < %s > does not match < %s > after clicking WatchUsLive link", lsUrl,lsYmlFullUrl);
		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
		
		getglobalheaderPageThreadLocal().waitForPageLoad();
			
		//Verify Logo section
		reporter.softAssert(getglobalheaderPageThreadLocal().validateTSCLogo(), "TSC icon is visible", "TSC icon is not visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateTSCLogoLink().trim().equalsIgnoreCase((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC link matches expected url", "TSC link does not matche expected url");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateTSCLogoNavigateToHomePage(), "TSCLogo can navigate To HomePage", "TSCLogo cannot navigate To HomePage");
		
		//Verify searchBox section
		validateText(getglobalheaderPageThreadLocal().validateSearchbox(), TestDataHandler.constantDataVariables.getlbl_SearchBoxPlaceholder(), "Search box is visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateSearchSubmitbtn(), "Search submit button is visible", "Search submit button is not visible");
		
		//Verify Sign in section
		validateText(getglobalheaderPageThreadLocal().validateSignInLink(), TestDataHandler.constantDataVariables.getlbl_SignIn(), "SignIn Link is present & Text is visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateSiginIcon(), "SignIn icon is visible", "SignIn icon is not visible");
		
		//Verify Favourites section
		validateText(getglobalheaderPageThreadLocal().validateFavouritesLink(), TestDataHandler.constantDataVariables.getlbl_Favourites(), "Favourites Link is present & Text is visible");
		
		//Verify Minicart section
		validateText(getglobalheaderPageThreadLocal().validateMinicartLinkName(), TestDataHandler.constantDataVariables.getlbl_MinicartLinkName(), "Mini cart Link is present & Text is visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateMinicartIcon(), "Mini cart icon is visible", "Mini cart icon is not visible");
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateMinicartBagCounter(), "Mini cart Bag counter is visible", "Mini cart Bag counter is not visible");
		
		//Verify Minicart href matches correct pattern
		lsUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_MinicarLink();
		lsSuccessResult=String.format("MiniCart link matches correct pattern of %s", lsUrl);
		lsFailResult=String.format("MiniCart link does not match correct pattern of %s", lsUrl);
		reporter.softAssert(getglobalheaderPageThreadLocal().verifyMiniCartLink(lsUrl), lsSuccessResult, lsFailResult);
		
		//Verify url does not contain notfound after clicking MiniCart link
		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingMiniCartLink();
		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking MiniCart link", lsUrl,lsYmlNotFound);
		lsFailResult=String.format("The url of < %s > contains < %s > after clicking MiniCart link", lsUrl,lsYmlNotFound);
		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
		
		getglobalheaderPageThreadLocal().waitForPageLoad();
				
				
	}
		
}