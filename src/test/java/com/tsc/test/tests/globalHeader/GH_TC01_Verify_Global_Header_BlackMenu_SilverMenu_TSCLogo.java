package com.tsc.test.tests.globalHeader;

import java.io.IOException;

import com.tsc.data.Handler.TestDataHandler;
import org.openqa.selenium.WebElement;
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
	 * BUG-19445 - [PR Defect] Adding the Why are we adding the "&fm=top_header" query string to the URL
	 */
	@Test(groups={"GlobalHeader","Regression"})
		public void GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Home Page");
		String partialURLAtEnd = TestDataHandler.constantData.getHeaderSection().getLbl_ParialURLEndWatchTSC();
		
		validateMajorNameAndLinks();
		if ((System.getProperty("Device").equalsIgnoreCase("Desktop")) ||
				(System.getProperty("Device").equalsIgnoreCase("Tablet") &&
						(System.getProperty("Browser").contains("ios") ||
								(System.getProperty("chromeMobileDevice")!=null && System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad"))))) {
			validateActionContents(partialURLAtEnd);
		}
	}
	
	public void validateActionContents(String partialURLAtEnd) {
		reporter.reportLog("Global Header Section contents for BlackMenu_SilverMenu_TSCLogoLinks");

		reporter.reportLog("Verify Black headers");
		//Verify Black headers
		if(!System.getProperty("Device").equalsIgnoreCase("Tablet"))
			getglobalheaderPageThreadLocal().hoverOnWatchTSC();
		getglobalheaderPageThreadLocal().verifyTSHeaderAndLinkInBlackHeader(null,null,true,partialURLAtEnd);
		reporter.reportLog("Verify Logo section");
		//Verify Logo section
		reporter.softAssert(getglobalheaderPageThreadLocal().validateTSCLogoNavigateToHomePage(), "TSCLogo can navigate To HomePage", "TSCLogo cannot navigate To HomePage");
	}
	
	public void validateMajorNameAndLinks() {
		reporter.reportLog("Global Header Section contents for BlackMenu_SilverMenu_TSCLogoLinks");
		
		BasePage basePage=new BasePage(this.getDriver());
		if ((System.getProperty("Device").equalsIgnoreCase("Desktop")) ||
				(System.getProperty("Device").equalsIgnoreCase("Tablet") &&
						(System.getProperty("Browser").contains("ios") ||
								(System.getProperty("chromeMobileDevice")!=null && System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad"))))) {
			reporter.reportLog("Verify Black headers");
			//Verify Black headers
			getglobalheaderPageThreadLocal().hoverOnWatchTSC();
			for(WebElement lblWatchTSC: getglobalheaderPageThreadLocal().lstWatchTSCDropDown){
				getglobalheaderPageThreadLocal().verifyElementLink(lblWatchTSC);
			}
			basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getglobalheaderPageThreadLocal().lnkTSBlackHeader);
			basePage.getReusableActionsInstance().scrollToElement(getglobalheaderPageThreadLocal().lnkTSBlackHeader);
			getglobalheaderPageThreadLocal().verifyElementLink(getglobalheaderPageThreadLocal().lnkTSBlackHeader);
		}
	}
}