package com.tsc.test.tests.globalHeader;

import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC08_Verify_Global_Header_Language extends BaseTest {
	/*
	 * CER-557
	 */
	@Test(groups={"GlobalHeader","Regression"})
	public void GH_TC08_Verify_Global_Header_Language() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";

		Map<String,List<String>> headerMap= TestDataHandler.constantData.headerSection.getFlyout().getLst_FlyoutHeadingAndNameMap();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Home Page");
		String partialURLAtEnd = TestDataHandler.constantData.getHeaderSection().getLbl_ParialURLEndWatchTSC();

		//Verification of Header Menu Items on Page
		reporter.reportLog("Verification of Global Header on Page");
		getglobalheaderPageThreadLocal().verifyHeaderItemsOnPage();

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
		if(System.getProperty("Device").equalsIgnoreCase("Mobile") ||
				System.getProperty("Device").equalsIgnoreCase("Tablet") &&
						(System.getProperty("Browser").contains("android") || ((System.getProperty("chromeMobileDevice")!=null && !System.getProperty("chromeMobileDevice").contains("iPad"))))){
			getglobalheaderPageThreadLocal().closeMobileMenu();
			getglobalheaderPageThreadLocal().waitForPageLoad();
		}
		getglobalheaderPageThreadLocal().switchToEnglish(headerMap);

		reporter.reportLog("Verify Global Footer on Page");
		getGlobalFooterPageThreadLocal().verifyFooterItemsOnPage();
	}
}