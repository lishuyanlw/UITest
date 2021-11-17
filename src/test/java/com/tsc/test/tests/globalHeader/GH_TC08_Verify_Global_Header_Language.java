package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import java.util.List;
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
		List<List<String>> lstWatchUsLiveNameAndLinks= TestDataHandler.constantData.getHeaderSection().getlst_WatchUsLiveNameAndLinks();
		List<List<String>> lst_HeaderNameAndLinks= TestDataHandler.constantData.getHeaderSection().getlst_HeaderNameAndLinks();
		List<String> lstFlyoutHeading_FR= TestDataHandler.constantData.headerSection.getFlyout().getlst_FlyoutHeading_FR();
		String nameWatchTSC, nameTodayShowstopper;
		//Switch to French
		getGlobalFooterPageThreadLocal().switchlanguage();
		
		nameTodayShowstopper=getglobalheaderPageThreadLocal().lnkTSBlackHeader.getText();
		nameWatchTSC=getglobalheaderPageThreadLocal().btnWatchTSCBlackHeader.getText();
		List<String> lstHeaderFrenchName=getglobalheaderPageThreadLocal().getFrenchNameymlData(lst_HeaderNameAndLinks);
		getglobalheaderPageThreadLocal().hoverOnWatchTSC();	
		int sizeDpdMenu=getglobalheaderPageThreadLocal().lstWatchTSCDpdMenu.size();
		List<String> lstFrenchNameWatchTSCdpM=getglobalheaderPageThreadLocal().getFrenchNameymlData(lstWatchUsLiveNameAndLinks);
		reporter.softAssert(lstWatchUsLiveNameAndLinks.size()==sizeDpdMenu,"Number of Watch TSC drop down menu element maches with test Data","Number of Watch TSC drop down menu elements are not maching with test Data");
		reporter.softAssert((lstHeaderFrenchName.contains(nameTodayShowstopper)), "Today's Showstopper-FR text is matches with yml data file.", "Today's Showstopper-FR text is not matches with data file.");
		reporter.softAssert((lstHeaderFrenchName.contains(nameWatchTSC)), "Watch TSC-FR text is matches with yml data file.", "Watch TSC-FR text is not matches with yml data file.");
		for(String frenchName:lstFrenchNameWatchTSCdpM) {
			WebElement WatchTSCelement=getglobalheaderPageThreadLocal().getWatchTSCdPMElements(frenchName);
			getglobalheaderPageThreadLocal().verifyWatchTSCdpDMenu(WatchTSCelement,true,"Watch TSC-FR");
			getglobalheaderPageThreadLocal().goBackHomePage();
			getglobalheaderPageThreadLocal().hoverOnWatchTSC();	
		}
		//reporter.reportLog("FLyout heading yml data :"+basePage.getUTFEnabledDataList(lstFlyoutHeading_FR));
		List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		for(WebElement lsHeading:headingsElement) {
			getglobalheaderPageThreadLocal().scrolltoWebElement(lsHeading);
			getGlobalFooterPageThreadLocal().applyStaticWait(1000);
			String flyoutHeading =basePage.getUTFEnabledData(lsHeading.getText().trim());
			//reporter.reportLog("Runtime flyout heading after UTF_8 :"+flyoutHeading);
			reporter.softAssert(basePage.getUTFEnabledDataList(lstFlyoutHeading_FR).contains(flyoutHeading),"Flyout displays drpartment  "+flyoutHeading+" and it's validated.","Flyout is not displaying heading properly for "+flyoutHeading);
			reporter.softAssert(getglobalheaderPageThreadLocal().verifyhrefFlyoutHeading(lsHeading), "Href is present for Flyout Heading "+flyoutHeading, "Href is not preset for "+flyoutHeading);
		}
		//Switch to English
		getGlobalFooterPageThreadLocal().switchlanguage();
	}	
}
