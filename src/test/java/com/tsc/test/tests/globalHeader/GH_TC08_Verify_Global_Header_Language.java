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
	@Test(groups={"GlobalHeader","Regression"})
	public void Verify_GlobalHeader_Language() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Home Page");
		String partialURLAtEnd = TestDataHandler.constantData.getHeaderSection().getLbl_ParialURLEndWatchTSC();

		getGlobalFooterPageThreadLocal().switchlanguage();
		GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo gh_tc01_verify_global_header_blackMenu_silverMenu_tscLogo = new GH_TC01_Verify_Global_Header_BlackMenu_SilverMenu_TSCLogo();
		//Below part will not be executed for Mobile as section is not present for mobile
		gh_tc01_verify_global_header_blackMenu_silverMenu_tscLogo.validateMajorNameAndLinks();
		if (System.getProperty("Device").equalsIgnoreCase("Desktop") ||
				(System.getProperty("Device").equalsIgnoreCase("Tablet") &&
						(System.getProperty("Browser").contains("ios") || ((System.getProperty("chromeMobileDevice")!=null && System.getProperty("chromeMobileDevice").contains("iPad")))))) {
			gh_tc01_verify_global_header_blackMenu_silverMenu_tscLogo.validateActionContents(partialURLAtEnd);
		}
		getglobalheaderPageThreadLocal().validateFlyout();
		//Closing mobile sub-menu if running for mobile
		if(!System.getProperty("Device").equalsIgnoreCase("desktop")){
			getglobalheaderPageThreadLocal().closeMobileMenu();
			getglobalheaderPageThreadLocal().waitForPageLoad();
		}
		switchToEnglish();
	}
	public void switchToEnglish() {
		Map<String,List<String>> headerMap= TestDataHandler.constantData.headerSection.getFlyout().getLst_FlyoutHeadingAndNameMap();
		//switch back to english
		getGlobalFooterPageThreadLocal().switchlanguage();
		List<WebElement> flyoutHeadingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		getglobalheaderPageThreadLocal().scrolltoWebElement(flyoutHeadingsElement.get(1));
		String englishNameFlyoutHeading=flyoutHeadingsElement.get(1).getText();
		reporter.softAssert((headerMap.get(englishNameFlyoutHeading).contains(englishNameFlyoutHeading)), "Language is switch back to English.", "Language is not switch back to English.");
	}
}