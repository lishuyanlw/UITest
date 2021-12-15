package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC08_Verify_Global_Header_Language extends BaseTest {
	/*
	 * CER-557
	 */
	@Test(groups={"Home","Regression","GlobalHeader","GlobalHeader_Mobile","GlobalHeader_Tablet"})
	public void Verify_GlobalHeader_Language() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Home Page");
		getGlobalFooterPageThreadLocal().switchlanguage();
		validateMajorNameAndLinks();
		if (!(System.getProperty("Device").equalsIgnoreCase("Mobile"))) {
			validateActionContents();
		}
		GH_TC03_Global_Header_Verify_FlyoutHeadings GH_TC03_Global_Header_Verify_FlyoutHeadings = new GH_TC03_Global_Header_Verify_FlyoutHeadings();
		GH_TC03_Global_Header_Verify_FlyoutHeadings.validateFlyout();
		//Closing mobile sub-menu if running for mobile
		if(!System.getProperty("Device").equalsIgnoreCase("desktop")){
			getglobalheaderPageThreadLocal().closeMobileMenu();
			getglobalheaderPageThreadLocal().waitForPageLoad();
		}
		switchToEnglish();
	}
	
	public void validateActionContents() {
		reporter.reportLog("Global Header Section contents for BlackMenu_SilverMenu_TSCLogoLinks");
		BasePage basePage=new BasePage(this.getDriver());
		reporter.reportLog("Verify Black headers");
		//Verify Black headers
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkTSBlackHeader,null,true);//getglobalheaderPageThreadLocal().lnkTS
		getglobalheaderPageThreadLocal().goBackHomePage();
		
		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkWatchUsLiveDpdMenu,null,true);//getglobalheaderPageThreadLocal().lnkWatchUsLive
		getglobalheaderPageThreadLocal().goBackHomePage();
		//line #47-49 commented as its already been tested in TC01. Deals link is getting failed as its under maintains.
		/*
		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkDealsDpdMenu,null,true);//getglobalheaderPageThreadLocal().lnkDeals
		getglobalheaderPageThreadLocal().goBackHomePage();
		*/
		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkProgramGuideDpdMenu,null,false);//getglobalheaderPageThreadLocal().lnkProgramGuide
		getglobalheaderPageThreadLocal().goBackHomePage();
		//comment line # 54 to 60 for staging.
		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkCarGadgetsDpdMenu,null,true);
		getglobalheaderPageThreadLocal().goBackHomePage();
		
		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkDesignerFootwearDpdMenu,null,true);
		getglobalheaderPageThreadLocal().goBackHomePage();
		
		getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(getglobalheaderPageThreadLocal().lnkOnAirProductsDpdMenu,null,true);//getglobalheaderPageThreadLocal().lnkOnAir
		
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
			//comment line # 79 & 80 for staging.
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkCarGadgetsDpdMenu);
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkDesignerFootwearDpdMenu);
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkOnAirProductsDpdMenu);

			basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getglobalheaderPageThreadLocal().lnkTSBlackHeader);
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkTSBlackHeader);
		}
	}

	public void switchToEnglish() {
		Map<String,List<String>> headerMap= TestDataHandler.constantData.headerSection.getFlyout().getLst_FlyoutHeadingAndNameMap();
		//switch back to english
		getGlobalFooterPageThreadLocal().switchlanguage();
		List<WebElement> flyoutHeadingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		getglobalheaderPageThreadLocal().scrolltoWebElement(flyoutHeadingsElement.get(1));
		getGlobalFooterPageThreadLocal().applyStaticWait(3000);
		String nenglisNameFlyoutHeading=flyoutHeadingsElement.get(1).getText();
		reporter.softAssert((headerMap.get(nenglisNameFlyoutHeading).contains(nenglisNameFlyoutHeading)), "Language is switch back to English.", "Language is not switch back to English.");
	}
}