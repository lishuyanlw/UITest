package com.tsc.test.tests.homePage;

import java.util.List;
import java.util.Set;

import org.testng.ITest;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC01_VerifyTSMainImage_123 extends BaseTest  implements ITest {
	@Test(groups={"Home","Regression"})
	public void HP_TC01_VerifyTSMainImage() throws InterruptedException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		if(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/")){
			reporter.reportLogPass("TSC url is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("TSC url is incorrect");
		}

		reporter.reportLog("Home Page");
		String lsYmlNotFound=TestDataHandler.constantData.getHeaderSection().getLnk_NotFound();

		//Verification of Header Menu Items on Page
		reporter.reportLog("Verification of Global Header on Page");
		getglobalheaderPageThreadLocal().verifyHeaderItemsOnPage();

		//Method to validate TS image in the upper section
		int totalTSImageUpperSection = homePageThreadLocal().totalTSimage("Upper");
		reporter.reportLog("Number of total TS image in the upper section: "+totalTSImageUpperSection);
		if(System.getProperty("Browser").contains("safari") || System.getProperty("Browser").contains("ios") ||
				(System.getProperty("Browser").equalsIgnoreCase("chromemobile") &&
						(System.getProperty("Device").contains("iPad") || System.getProperty("Device").contains("iPhone")))){
			Set<String> totalTSImageLink = homePageThreadLocal().getTSImageLinkForSafariPostClick(System.getProperty("Device"));
			if(totalTSImageUpperSection==totalTSImageLink.size())
				reporter.reportLogPass("All TS images in upper section for Safari are clicked");
			else
				reporter.reportLogFailWithScreenshot("All TS images in upper section for Safari are not clicked. Expected Image: "+totalTSImageUpperSection+" : Actual Image clicked: "+totalTSImageLink.size());
		}
		else{
			homePageThreadLocal().clickTSimage("Upper");
			int numberOfWindows_UpperSection = homePageThreadLocal().getNumberOftabs();
			List<String> lsUrl_UpperSection=homePageThreadLocal().getTabUrlListTSimage();
			homePageThreadLocal().verifyImageTabsAndURL(numberOfWindows_UpperSection,totalTSImageUpperSection,lsUrl_UpperSection,lsYmlNotFound);
		}

		reporter.reportLog("Verify Global Footer on Page");
		getGlobalFooterPageThreadLocal().verifyFooterItemsOnPage();

		/*
		//Method to validate TS image in the Lower Section
		int totalTSimageLowerSection = homePageThreadLocal().totalTSimage("Lower");
		reporter.reportLog("Number of total TS image in the Lower Section: "+totalTSimageLowerSection);
		homePageThreadLocal().clickTSimage("Lower");
		int numberOfWindows_LowerSection = homePageThreadLocal().getNumberOftabs();
		List<String> lsUrl_LowerSection=homePageThreadLocal().getTabUrlListTSimage();
		reporter.reportLog("Total number of tabs open for TS image Lower Section: "+numberOfWindows_LowerSection);
		if(totalTSimageLowerSection==(numberOfWindows_LowerSection-1)){
			reporter.reportLogPass("All TS images in Lower Section have been clicked");
		}
		else{
			reporter.reportLogFailWithScreenshot("All TS images in Lower Section have not been clicked");
		}

		for(int i=0; i<totalTSimageLowerSection; i++) {
			reporter.softAssert(!lsUrl_LowerSection.get(i).contains(lsYmlNotFound),("URL of tab " +(i+1)+" for TS image Lower Section is "+lsUrl_LowerSection.get(i)+" & it does not contain not found"),("URL of tab " +(i+1)+" for TS image Lower Section is "+lsUrl_LowerSection.get(i)+" & does contain not found"));
				if(i<lsUrl_LowerSection.size()-1) {
					if(!lsUrl_LowerSection.get(i).equals(lsUrl_LowerSection.get(i+1))){
						reporter.reportLogPass("URL of tab " +(i+1)+ " is different than URL of Tab "+((i+1)+1)+" for TS image Lower Section.");
					}
					else{
						reporter.reportLogFailWithScreenshot("URL of Tab " +(i+1)+" is same as URL of Tab"+((i+1)+1)+" for TS image Lower Section.");
					}
				}
		}
		*/
	}

	@Override
	public String getTestName() {
		return "David Test";
	}
}
