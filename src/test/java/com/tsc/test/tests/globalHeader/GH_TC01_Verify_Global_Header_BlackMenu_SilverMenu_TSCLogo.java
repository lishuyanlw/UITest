package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import org.testng.annotations.Test;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo extends BaseTest {
	/*
	 * CER-146
	 * CER-151
	 * CER-147
	 * CER-150
	 * CER-148
	 * CER-149	
	 * CER-162
	 * CER-565
	 */
	@Test(groups={"Home","Regression","GlobalHeader_Mobile","GlobalHeader"})
		public void validateGlobalHeaderBlackMenu_SilverMenu_TSCLogoLinks() throws IOException {		
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Home Page");
		
		validateMajorNameAndLinks();
		if (!(System.getProperty("Device").equalsIgnoreCase("Mobile"))) {
			validateActionContents();
		}
	}
	
	public void validateActionContents() {
		reporter.reportLog("Global Header Section contents for BlackMenu_SilverMenu_TSCLogoLinks");
		
		reporter.reportLog("Verify Black headers");
		//Verify Black headers
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkTSBlackHeader,null,true);//getglobalheaderPageThreadLocal().lnkTS
		//getglobalheaderPageThreadLocal().goBackHomePage();
		getglobalheaderPageThreadLocal().clickOnTSCLogo();

		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkWatchUsLiveDpdMenu,null,true);//getglobalheaderPageThreadLocal().lnkWatchUsLive
		//getglobalheaderPageThreadLocal().goBackHomePage();
		getglobalheaderPageThreadLocal().clickOnTSCLogo();

		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkDealsDpdMenu,null,true);//getglobalheaderPageThreadLocal().lnkDeals
		//getglobalheaderPageThreadLocal().goBackHomePage();
		getglobalheaderPageThreadLocal().clickOnTSCLogo();

		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkProgramGuideDpdMenu,null,false);//getglobalheaderPageThreadLocal().lnkProgramGuide
		//getglobalheaderPageThreadLocal().goBackHomePage();
		getglobalheaderPageThreadLocal().clickOnTSCLogo();
		//comment line #56 to 62 for staging
		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkCarGadgetsDpdMenu,null,true);
		//getglobalheaderPageThreadLocal().goBackHomePage();
		getglobalheaderPageThreadLocal().clickOnTSCLogo();

		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkDesignerFootwearDpdMenu,null,true);
		//getglobalheaderPageThreadLocal().goBackHomePage();
		getglobalheaderPageThreadLocal().clickOnTSCLogo();

		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkOnAirProductsDpdMenu,null,true);//getglobalheaderPageThreadLocal().lnkOnAir
							
//		reporter.reportLog("Verify Silver headers");
//		//Verify Silver headers
//		String lsUrl,lsYmlNotFound,lsYmlFullUrl,lsSuccessResult, lsFailResult;
//		lsYmlNotFound=TestDataHandler.constantDataVariables.getlnk_NotFound();
//				
//		reporter.softAssert(getglobalheaderPageThreadLocal().DynamicEventLinkVisible(), "Dynamic Event Link is visible", "Dynamic Event Link is not visible");
//		
//		reporter.softAssert(getglobalheaderPageThreadLocal().validateDynamicEventLink(), "Dynamic Event href is existing", "Dynamic Event href is not existing");
//	
//		reporter.reportLog("Sliver headers text");
//		//Verify headers text
//		reporter.softAssert(getglobalheaderPageThreadLocal().getTSText().startsWith(TestDataHandler.constantDataVariables.getlbl_TodaysShowstopper()), "TS Link is present & Text is visible","TS Link is present & Text is not visible");
//		
//		validateText(getglobalheaderPageThreadLocal().getDealsText(), TestDataHandler.constantDataVariables.getlbl_Deals_English(), "Deals Link is present & Text is visible");
//		
//		validateText(getglobalheaderPageThreadLocal().getOnAirText(), TestDataHandler.constantDataVariables.getlbl_OnAirProducts_English(), "On Air Products Link is present & Text is visible");
//		
//		validateText(getglobalheaderPageThreadLocal().getProgramGuideText(), TestDataHandler.constantDataVariables.getlbl_ProgramGuide_English(), "Program Guide Link is present & Text is visible");
//				
//		validateText(getglobalheaderPageThreadLocal().getWatchUsLiveText(), TestDataHandler.constantDataVariables.getlbl_WatchUsLive_English(), "Watch Us Live Link is present & Text is visible");
//		
//		reporter.reportLog("Verify TodaysShowstopper link");
//		//Verify TodaysShowstopper link
//		lsUrl=getglobalheaderPageThreadLocal().getTSLink();	
//		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_TodaysShowstopper();
//		lsSuccessResult=String.format("The TodayShowstopper url of < %s > matches < %s > in yml file", lsUrl,lsYmlFullUrl);
//		lsFailResult=String.format("The TodayShowstopper url of < %s > does not match < %s > in yml file", lsUrl,lsYmlFullUrl);
//		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
//		
//		//Verify Deals link
//		lsUrl=getglobalheaderPageThreadLocal().getDealsLink();	
//		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_Deals();
//		lsSuccessResult=String.format("The Deals url of < %s > matches < %s > in yml file", lsUrl,lsYmlFullUrl);
//		lsFailResult=String.format("The Deals url of < %s > does not match < %s > in yml file", lsUrl,lsYmlFullUrl);
//		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
//		
//		//Verify OnAir link
//		lsUrl=getglobalheaderPageThreadLocal().getOnAirLink();	
//		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_OnAirProducts();
//		lsSuccessResult=String.format("The OnAir url of < %s > matches < %s > in yml file", lsUrl,lsYmlFullUrl);
//		lsFailResult=String.format("The OnAir url of < %s > does not match < %s > in yml file", lsUrl,lsYmlFullUrl);
//		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
//		
//		//Verify ProgramGuide link
//		lsUrl=getglobalheaderPageThreadLocal().getProgramGuideLink();	
//		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_ProgramGuide();
//		lsSuccessResult=String.format("The ProgramGuide url of < %s > matches < %s > in yml file", lsUrl,lsYmlFullUrl);
//		lsFailResult=String.format("The ProgramGuide url of < %s > does not match < %s > in yml file", lsUrl,lsYmlFullUrl);
//		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
//		
//		//Verify WatchUsLive link
//		lsUrl=getglobalheaderPageThreadLocal().getWatchUsLiveLink();	
//		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_WatchUsLive();
//		lsSuccessResult=String.format("The ProgramGuide url of < %s > matches < %s > in yml file", lsUrl,lsYmlFullUrl);
//		lsFailResult=String.format("The ProgramGuide url of < %s > does not match < %s > in yml file", lsUrl,lsYmlFullUrl);
//		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
//
//		//Verify headers icon
//		reporter.softAssert(getglobalheaderPageThreadLocal().validateProgramGuideIconVisible(), "Program Guide icon is visible", "Program Guide icon is not visible");
//		reporter.softAssert(getglobalheaderPageThreadLocal().validateWatchUsLiveIconVisible(), "Watch Us icon is visible", "Watch Us icon is  not visible");
//		
//		reporter.reportLog("Verify notfound and full url after clicking TodayShowstopper link");
//		//Verify notfound and full url after clicking TodayShowstopper link
//		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingTSLink();		
//		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking TodayShowstopper link", lsUrl,lsYmlNotFound);
//		lsFailResult=String.format("The url of < %s > contains < %s > after clicking TodayShowstopper link", lsUrl,lsYmlNotFound);
//		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
//		
//		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_TodaysShowstopper();
//		lsSuccessResult=String.format("The url of < %s > matches < %s > after clicking TodayShowstopper link", lsUrl,lsYmlFullUrl);
//		lsFailResult=String.format("The url of < %s > does not match < %s > after clicking TodayShowstopper link", lsUrl,lsYmlFullUrl);
//		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
//		
//		getglobalheaderPageThreadLocal().waitForPageLoad();
//			
//		//Verify notfound and full url after clicking Deals link
//		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingDealsLink();		
//		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking Deals link", lsUrl,lsYmlNotFound);
//		lsFailResult=String.format("The url of < %s > contains < %s > after clicking Deals link", lsUrl,lsYmlNotFound);
//		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
//		
//		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_Deals();
//		lsSuccessResult=String.format("The url of < %s > matches < %s > after clicking Deals link", lsUrl,lsYmlFullUrl);
//		lsFailResult=String.format("The url of < %s > does not match < %s > after clicking Deals link", lsUrl,lsYmlFullUrl);
//		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
//		
//		getglobalheaderPageThreadLocal().waitForPageLoad();
//		
//		//Verify notfound and full url after clicking OnAir link
//		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingOnAirLink();		
//		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking OnAir link", lsUrl,lsYmlNotFound);
//		lsFailResult=String.format("The url of < %s > contains < %s > after clicking OnAir link", lsUrl,lsYmlNotFound);
//		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
//		
//		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_OnAirProducts();
//		lsSuccessResult=String.format("The url of < %s > matches < %s > after clicking OnAir link", lsUrl,lsYmlFullUrl);
//		lsFailResult=String.format("The url of < %s > does not match < %s > after clicking OnAir link", lsUrl,lsYmlFullUrl);
//		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
//		
//		getglobalheaderPageThreadLocal().waitForPageLoad();	
//			
//		//Verify notfound and full url after clicking ProgramGuide link
//		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingProgramGuideLink();		
//		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking ProgramGuide link", lsUrl,lsYmlNotFound);
//		lsFailResult=String.format("The url of < %s > contains < %s > after clicking ProgramGuide link", lsUrl,lsYmlNotFound);
//		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
//		
//		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_ProgramGuideRedirect();
//		lsSuccessResult=String.format("The url of < %s > matches < %s > after clicking ProgramGuide link", lsUrl,lsYmlFullUrl);
//		lsFailResult=String.format("The url of < %s > does not match < %s > after clicking ProgramGuide link", lsUrl,lsYmlFullUrl);
//		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
//		
//		(new BasePage(this.getDriver())).navigateToURL(lsBaseUrl+"/");
//		getglobalheaderPageThreadLocal().waitForPageLoad();
//		getglobalheaderPageThreadLocal().switchWatchTSCDropdownOption(getglobalheaderPageThreadLocal().lnkCarGadgetsDpdMenu);
//			
//		//Verify notfound and full url after clicking WatchUsLive link
//		lsUrl=getglobalheaderPageThreadLocal().getUrlAfterClickingWatchUsLiveLink();		
//		lsSuccessResult=String.format("The url of < %s > does not contain < %s > after clicking WatchUsLive link", lsUrl,lsYmlNotFound);
//		lsFailResult=String.format("The url of < %s > contains < %s > after clicking WatchUsLive link", lsUrl,lsYmlNotFound);
//		reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
//		
//		lsYmlFullUrl=lsBaseUrl+TestDataHandler.constantDataVariables.getlnk_WatchUsLive();
//		lsSuccessResult=String.format("The url of < %s > matches < %s > after clicking WatchUsLive link", lsUrl,lsYmlFullUrl);
//		lsFailResult=String.format("The url of < %s > does not match < %s > after clicking WatchUsLive link", lsUrl,lsYmlFullUrl);
//		reporter.softAssert(lsUrl.equalsIgnoreCase(lsYmlFullUrl), lsSuccessResult,lsFailResult);
//		
//		getglobalheaderPageThreadLocal().waitForPageLoad();
		
		reporter.reportLog("Verify Logo section");
		//Verify Logo section
		reporter.softAssert(getglobalheaderPageThreadLocal().validateTSCLogoNavigateToHomePage(), "TSCLogo can navigate To HomePage", "TSCLogo cannot navigate To HomePage");

	}
	
	public void validateMajorNameAndLinks() {
		reporter.reportLog("Global Header Section contents for BlackMenu_SilverMenu_TSCLogoLinks");
		
		BasePage basePage=new BasePage(this.getDriver());
		if (!(System.getProperty("Device").equalsIgnoreCase("Mobile"))) {
			reporter.reportLog("Verify Black headers");
			//Verify Black headers
			getglobalheaderPageThreadLocal().hoverOnWatchTSC();
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkWatchUsLiveDpdMenu);
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkDealsDpdMenu);
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkProgramGuideDpdMenu);
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkCarGadgetsDpdMenu);
			//comment line #215 &216 for staging
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkDesignerFootwearDpdMenu);
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkOnAirProductsDpdMenu);
			getglobalheaderPageThreadLocal().hoverOnWatchTSC();
			getglobalheaderPageThreadLocal().staticwait();
			basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getglobalheaderPageThreadLocal().lnkTSBlackHeader);
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkTSBlackHeader);
		}

	}
		
}