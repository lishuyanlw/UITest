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
	@Test(groups={"Home","Regression"})
	public void Verify_GlobalHeader_Language() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl;//,nameWatchTSC, nameTodayShowstopper,flyoutHeading
		lsBaseUrl=basePage.getBaseURL()+"/";
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");		
		reporter.reportLog("Global Header Section");
		swichToFrench();
		if ((System.getProperty("Device").equalsIgnoreCase("Tablet"))) {
			
			validateShowstopper();
		}
		validateFlyout();
	}

	public void swichToFrench() {
		getGlobalFooterPageThreadLocal().switchlanguage();
		
	}
	public Map<String, List<String>> getheaderLinks(){
		Map<String, List<String>> headerLinks= TestDataHandler.constantData.headerSection.getLst_HeaderNameAndLinksMap();
		return  headerLinks;
	}
	public List<List<String>> getlstNameHeaderLinks(){
		List<List<String>> lstNameHeaderLinks=getheaderLinks().values().stream().collect(Collectors.toList());
		return lstNameHeaderLinks;
	}	
	
		public List<String> getEnglishName(){
		//English Name for Today's Showstopper & Watch TSC
			BasePage basePage=new BasePage(this.getDriver());		
			List<String> englishNameHeaderLinks = new ArrayList<>();
			for (List<String> headerName : getlstNameHeaderLinks()) {
				String frenchName=basePage.getUTFEnabledData(headerName.get(1));
				englishNameHeaderLinks.add(headerName.get(0));
			}
			return englishNameHeaderLinks;
		}
		
		public List<String> getFrenchName(){
			//French Name for Today's Showstopper & Watch TSC
				BasePage basePage=new BasePage(this.getDriver());		
				List<String> frenchNameHeaderLinks = new ArrayList<>();
				for (List<String> headerName : getlstNameHeaderLinks()) {
					String frenchName=basePage.getUTFEnabledData(headerName.get(1));
					frenchNameHeaderLinks.add(frenchName);
				}
				return frenchNameHeaderLinks;
			}
		//Switch to French
		
		public void validateWatchTSC(){
			BasePage basePage=new BasePage(this.getDriver());		
			Map<String, List<String>> lstWatchTSCNameAndLinks= TestDataHandler.constantData.getHeaderSection().getLst_WatchTSCNameAndLinksMap();
			List<List<String>> lstNameWatchTSC=lstWatchTSCNameAndLinks.values().stream().collect(Collectors.toList());
			List<String> frenchNameWatchTSC = new ArrayList<>();
			Map<String,Map<String, String>> linkMap = new HashMap<>();
		
			for (List<String> linkName : lstNameWatchTSC) {
				String name=basePage.getUTFEnabledData(linkName.get(1));
				frenchNameWatchTSC.add(name);
				if(Boolean.valueOf(linkName.get(3))) {
					linkMap.put(linkName.get(1),(HashMap)new HashMap<String,String>(){{put(linkName.get(0),linkName.get(2));}});
				}
			}
			
			reporter.reportLog("Validating Watch TSC.");
			String nameWatchTSC=getglobalheaderPageThreadLocal().btnWatchTSCBlackHeader.getText();
			reporter.softAssert((getFrenchName().get(1).contains(nameWatchTSC)), "Watch TSC-FR text is matches with yml data file.", "Watch TSC-FR text is not matches with yml data file.");
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
		}
		
		
		public void validateShowstopper(){
			reporter.reportLog("Validating Today's Showstopper.");
			String nameTodayShowstopper=getglobalheaderPageThreadLocal().lnkTSBlackHeader.getText();
			reporter.softAssert((getFrenchName().get(0).contains(nameTodayShowstopper)), "Today's Showstopper-FR text is matches with yml data file.", "Today's Showstopper-FR text is not matches with data file.");
		}
		
		public void validateFlyout(){
			
			BasePage basePage=new BasePage(this.getDriver());		
			Map<String, List<String>> lstFlyoutHeading= TestDataHandler.constantData.headerSection.getFlyout().getLst_FlyoutHeadingAndNameMap();
			reporter.reportLog("Validating Flyout.");
			List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
			for(WebElement lsHeading:headingsElement) {
				getglobalheaderPageThreadLocal().scrolltoWebElement(lsHeading);
				getGlobalFooterPageThreadLocal().applyStaticWait(1000);
				String flyoutHeading =basePage.getUTFEnabledData(lsHeading.getText().trim());
				reporter.reportLog("Heading Flyout."+lstFlyoutHeading.get(flyoutHeading));
				reporter.softAssert(getglobalheaderPageThreadLocal().verifyhrefFlyoutHeading(lsHeading), "Href is present for Flyout Heading "+flyoutHeading, "Href is not preset for "+flyoutHeading);
			}
		}
		
		public void swichToEnglish() {//Switch to English
			getGlobalFooterPageThreadLocal().switchlanguage();
			String nameTodayShowstopper=getglobalheaderPageThreadLocal().lnkTSBlackHeader.getText();;
			reporter.softAssert((getFrenchName().get(0).contains(nameTodayShowstopper)), "Language is switch back to English.", "Language is not switch back to English.");

		}
}		
	
