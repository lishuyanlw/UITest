package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
		Map<String, List<String>> lstFlyoutHeading= TestDataHandler.constantData.headerSection.getFlyout().getLst_FlyoutHeadingAndNameMap();
		List<List<String>> lstNameWatchTSC=lstWatchTSCNameAndLinks.values().stream().collect(Collectors.toList());
		List<List<String>> lstNameHeaderLinks=headerLinks.values().stream().collect(Collectors.toList());
		//Watch TSC dropdown menu French & English Name
		List<String> frenchNameWatchTSC = new ArrayList<>();
		Map<String,Map<String, String>> linkMap = new HashMap<>();
		
		for (List<String> linkName : lstNameWatchTSC) {
			String name=basePage.getUTFEnabledData(linkName.get(1));
			frenchNameWatchTSC.add(name);
			
			if(Boolean.valueOf(linkName.get(3))) {
				linkMap.put(linkName.get(1),(HashMap)new HashMap<String,String>(){{put(linkName.get(0),linkName.get(2));}});
			}

		}
		//French & English Name for Today's Showstopper & Watch TSC
		List<String> frenchNameHeaderLinks = new ArrayList<>();
		List<String> englishNameHeaderLinks = new ArrayList<>();
		for (List<String> headerName : lstNameHeaderLinks) {
			String frenchName=basePage.getUTFEnabledData(headerName.get(1));
			frenchNameHeaderLinks.add(frenchName);
			englishNameHeaderLinks.add(headerName.get(0));
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
			getglobalheaderPageThreadLocal().verifyWatchTSCdpDMenu(watchTSCElement,linkMap.get(frenchName));
			getglobalheaderPageThreadLocal().goBackHomePage();
			getglobalheaderPageThreadLocal().hoverOnWatchTSC();	
		}
		reporter.reportLog("Validating Flyout.");
		List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		for(WebElement lsHeading:headingsElement) {
			getglobalheaderPageThreadLocal().scrolltoWebElement(lsHeading);
			getGlobalFooterPageThreadLocal().applyStaticWait(1000);
			flyoutHeading =basePage.getUTFEnabledData(lsHeading.getText().trim());
			reporter.reportLog("Heading Flyout."+lstFlyoutHeading.get(flyoutHeading));
			reporter.softAssert(getglobalheaderPageThreadLocal().verifyhrefFlyoutHeading(lsHeading), "Href is present for Flyout Heading "+flyoutHeading, "Href is not preset for "+flyoutHeading);
		}
		
		//Switch to English
		getGlobalFooterPageThreadLocal().switchlanguage();
		nameTodayShowstopper=getglobalheaderPageThreadLocal().lnkTSBlackHeader.getText();;
		reporter.softAssert((englishNameHeaderLinks.get(0).contains(nameTodayShowstopper)), "Language is switch back to English.", "Language is not switch back to English.");
		
	}	
}
