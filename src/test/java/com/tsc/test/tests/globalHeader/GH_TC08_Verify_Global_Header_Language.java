package com.tsc.test.tests.globalHeader;

import java.io.IOException;
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
		String lsBaseUrl=basePage.getBaseURL()+"/";
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");		
		reporter.reportLog("Global Header Section");		
		//List<List<String>> lstWatchUsLiveNameAndLinks= TestDataHandler.constantData.getHeaderSection().getlst_WatchUsLiveNameAndLinks();
		
		
		Map<String, List<String>> lstWatchUsLiveNameAndLinks= TestDataHandler.constantData.getHeaderSection().getLst_WatchUsLiveNameAndLinksMap();
		Map<String, List<String>> headerLinks = TestDataHandler.constantData.headerSection.getLst_HeaderNameAndLinksMap();
		Map<String, List<String>> lstFlyoutHeading_FR= TestDataHandler.constantData.headerSection.getFlyout().getLst_FlyoutHeadingAndNameMap();
		
		String nameWatchTSC, nameTodayShowstopper,showstopper_English,showstopper,watch_tsc,showstopper_French,watch_tsc_French;
		//Switch to French
		getGlobalFooterPageThreadLocal().switchlanguage();
		//List<String> lstHeaderFrenchName=getglobalheaderPageThreadLocal().getymlData(lst_ShowsTopperNameAndLinks,1);
		//List<String> lstHeaderEnglishName=getglobalheaderPageThreadLocal().getymlData(lst_ShowsTopperNameAndLinks,0);
		
		showstopper=headerLinks.get("Today's Showstopper").get(0).toLowerCase().split(" ")[1];
		watch_tsc=headerLinks.get("Watch TSC").get(0).toLowerCase().split(" ")[0];
		showstopper_French=headerLinks.get("Today's Showstopper").get(1);
		watch_tsc_French=headerLinks.get("Watch TSC").get(1);
		
		nameTodayShowstopper=getglobalheaderPageThreadLocal().getBlackHeadingWebElements(showstopper).getText();
		nameWatchTSC=getglobalheaderPageThreadLocal().getBlackHeadingWebElements(watch_tsc).getText();
		//reporter.reportLog("today's showshtopper--->:     "+ nameTodayShowstopper);
		//reporter.reportLog("WATCH TSC--->:               "+nameWatchTSC);
		getglobalheaderPageThreadLocal().hoverOnWatchTSC();	
		int sizeDpdMenu=getglobalheaderPageThreadLocal().lstWatchTSCDpdMenu.size();//
		//List<String> lstFrenchNameWatchTSCdpM=getglobalheaderPageThreadLocal().getymlData(lstWatchUsLiveNameAndLinks,1);
		List<List<String>> lstWatchTSCdpM=lstFlyoutHeading_FR.values().stream().collect(Collectors.toList());
		List<String>lstFrenchNameWatchTSCdpM =lstWatchTSCdpM.get(1);
		reporter.reportLog("list French Name:"+lstFrenchNameWatchTSCdpM);
		//List<String> lstFrenchNameWatchTSCdpM=lstFlyoutHeading_FR.getOrDefault(watch_tsc_French, null);
		
		reporter.reportLog("today's showshtopper french:     "+ showstopper_French);
		reporter.reportLog("WATCH TSC french:               "+watch_tsc_French);
		
		reporter.softAssert(lstWatchUsLiveNameAndLinks.size()==sizeDpdMenu,"Number of Watch TSC drop down menu element maches with test Data","Number of Watch TSC drop down menu elements are not maching with test Data");
		reporter.softAssert((showstopper_French.contains(nameTodayShowstopper)), "Today's Showstopper-FR text is matches with yml data file.", "Today's Showstopper-FR text is not matches with data file.");
		reporter.softAssert((watch_tsc_French.contains(nameWatchTSC)), "Watch TSC-FR text is matches with yml data file.", "Watch TSC-FR text is not matches with yml data file.");
		List<WebElement> FrenchNameWatchTSCdpMElement=getglobalheaderPageThreadLocal().getWatchTSCdDMWebelements();
		
		
		for(String frenchName:lstFrenchNameWatchTSCdpM) {
			WebElement watchTSCElement=getglobalheaderPageThreadLocal().getWatchTSCdPMElements(frenchName);
			getglobalheaderPageThreadLocal().verifyWatchTSCdpDMenu(watchTSCElement,true);
			getglobalheaderPageThreadLocal().goBackHomePage();
			getglobalheaderPageThreadLocal().hoverOnWatchTSC();	
		}
		
		List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		for(WebElement lsHeading:headingsElement) {
			getglobalheaderPageThreadLocal().scrolltoWebElement(lsHeading);
			getGlobalFooterPageThreadLocal().applyStaticWait(1000);
			String flyoutHeading =basePage.getUTFEnabledData(lsHeading.getText().trim());
			reporter.softAssert(basePage.getUTFEnabledDataList(lstFlyoutHeading_FR).contains(flyoutHeading),"Flyout displays drpartment  "+flyoutHeading+" and it's validated.","Flyout is not displaying heading properly for "+flyoutHeading);
			reporter.softAssert(getglobalheaderPageThreadLocal().verifyhrefFlyoutHeading(lsHeading), "Href is present for Flyout Heading "+flyoutHeading, "Href is not preset for "+flyoutHeading);
		}
		
		//Switch to English
		getGlobalFooterPageThreadLocal().switchlanguage();
		nameTodayShowstopper=getglobalheaderPageThreadLocal().getBlackHeadingWebElements("showstopper").getText();
		showstopper_English=headerLinks.get("Today's Showstopper").get(0);
		reporter.softAssert((showstopper_English.contains(nameTodayShowstopper)), "Language is switch back to English.", "Language is not switch back to English.");
		*/
	}	
}
