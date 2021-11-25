package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC08_Verify_Global_Header_Language extends BaseTest {
	/*
	 * CER-557
	 */
	@Test(groups={"Home","Regression","GlobalHeader"})
	public void Verify_GlobalHeader_Language() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl,nameWatchTSC, nameTodayShowstopper,flyoutHeading;
		lsBaseUrl=basePage.getBaseURL()+"/";
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");		
		reporter.reportLog("Global Header Section");		
		Map<String, List<String>> lstWatchTSCNameAndLinks= TestDataHandler.constantData.getHeaderSection().getLst_WatchTSCNameAndLinksMap();
		Map<String, List<String>> headerLinks = TestDataHandler.constantData.headerSection.getLst_HeaderNameAndLinksMap();
		Map<String, List<String>> lstFlyoutHeading_FR= TestDataHandler.constantData.headerSection.getFlyout().getLst_FlyoutHeadingAndNameMap();
		List<List<String>> lstFrenchNameWatchTSC=lstWatchTSCNameAndLinks.values().stream().collect(Collectors.toList());
		List<List<String>> lstNameheaderLinks=headerLinks.values().stream().collect(Collectors.toList());
		//Watch TSC dropdown menu French Name
		List<String> frenchNameWatchTSC = new ArrayList<>();
		for (List<String> frenchName : lstFrenchNameWatchTSC) {
			String name=basePage.getUTFEnabledData(frenchName.get(1));
			frenchNameWatchTSC.add(name);
		}
		//French Name for Today's Showstopper & Watch TSC
		List<String> frenchNameHeaderLinks = new ArrayList<>();
		for (List<String> frenchName : lstNameheaderLinks) {
			String name=basePage.getUTFEnabledData(frenchName.get(1));
			frenchNameHeaderLinks.add(name);
		}
		//English Name for Today's Showstopper & Watch TSC
		List<String> englishNameHeaderLinks = new ArrayList<>();
		for (List<String> englishName : lstNameheaderLinks) {
			String name=englishName.get(0);
			englishNameHeaderLinks.add(name);
		}
		
		//Switch to French
		getGlobalFooterPageThreadLocal().switchlanguage();
		reporter.reportLog("Validating Today's Showstopper & Watch TSC .");
		nameTodayShowstopper=getglobalheaderPageThreadLocal().lnkTSBlackHeader.getText();
		nameWatchTSC=getglobalheaderPageThreadLocal().btnWatchTSCBlackHeader.getText();
		reporter.softAssert((frenchNameHeaderLinks.get(0).contains(nameTodayShowstopper)), "Today's Showstopper-FR text is matches with yml data file.", "Today's Showstopper-FR text is not matches with data file.");
		reporter.softAssert((frenchNameHeaderLinks.get(1).contains(nameWatchTSC)), "Watch TSC-FR text is matches with yml data file.", "Watch TSC-FR text is not matches with yml data file.");
		getglobalheaderPageThreadLocal().hoverOnWatchTSC();	
		reporter.reportLog("Validating Watch TSC drop down menu.");
		int sizeDpdMenu=getglobalheaderPageThreadLocal().lstWatchTSCDpdMenu.size();
		reporter.softAssert(lstWatchTSCNameAndLinks.size()==sizeDpdMenu,"Number of Watch TSC drop down menu element maches with test Data","Number of Watch TSC drop down menu elements are not maching with test Data");
		for(String frenchName:frenchNameWatchTSC) {
			WebElement watchTSCElement=getglobalheaderPageThreadLocal().getWatchTSCdPMElements(frenchName);
			getglobalheaderPageThreadLocal().verifyWatchTSCdpDMenu(watchTSCElement,true);
			getglobalheaderPageThreadLocal().goBackHomePage();
			getglobalheaderPageThreadLocal().hoverOnWatchTSC();	
		}
		reporter.reportLog("Validating Flyout.");
		List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		for(WebElement lsHeading:headingsElement) {
			getglobalheaderPageThreadLocal().scrolltoWebElement(lsHeading);
			getGlobalFooterPageThreadLocal().applyStaticWait(1000);
			flyoutHeading =basePage.getUTFEnabledData(lsHeading.getText().trim());
			reporter.reportLog("Heading Flyout."+lstFlyoutHeading_FR.get(flyoutHeading));
			//reporter.softAssert(lstFlyoutHeading_FR.get(flyoutHeading).contains(flyoutHeading),"Flyout displays drpartment  "+flyoutHeading+" and it's validated.","Flyout is not displaying heading properly for "+flyoutHeading);
			reporter.softAssert(getglobalheaderPageThreadLocal().verifyhrefFlyoutHeading(lsHeading), "Href is present for Flyout Heading "+flyoutHeading, "Href is not preset for "+flyoutHeading);
		}
		
		//Switch to English
		getGlobalFooterPageThreadLocal().switchlanguage();
		nameTodayShowstopper=getglobalheaderPageThreadLocal().lnkTSBlackHeader.getText();;
		reporter.softAssert((englishNameHeaderLinks.get(0).contains(nameTodayShowstopper)), "Language is switch back to English.", "Language is not switch back to English.");
		
	}	
}
