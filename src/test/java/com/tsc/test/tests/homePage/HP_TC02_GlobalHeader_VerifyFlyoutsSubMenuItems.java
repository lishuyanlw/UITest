package com.tsc.test.tests.homePage;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
public class HP_TC02_GlobalHeader_VerifyFlyoutsSubMenuItems extends BaseTest {

	
	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() throws IOException {
		getglobalheaderPageThreadLocal().closeadd();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyout Sub Menu for each category");
		List<String> FOHeading=getglobalheaderPageThreadLocal().getFlyoutHeadings();
		for(String lsHeading:FOHeading) {
			List<String> subMenu= getglobalheaderPageThreadLocal().getFlyoutSubMenu(lsHeading);
			String BrandSectionHeading= getglobalheaderPageThreadLocal().getFeatureBrandSectionHeading(lsHeading);
			reporter.reportLog("Flyout displays " + lsHeading+" department.");
			reporter.reportLog("It's Sub Menu display sections: " + subMenu);
			reporter.softAssert(TestDataHandler.constantDataVariables.getlst_FlyoutsubMenu().containsAll(subMenu),lsHeading +"'s sub menu section list is correct", lsHeading +"'s sub menu section list is incorrect");
			reporter.reportLog(getglobalheaderPageThreadLocal().validateFlyoutSubMenuSRCandHREF(lsHeading,null)+" of "+lsHeading);
			reporter.softAssert(getglobalheaderPageThreadLocal().validateFeatureBrandSectionIsOnTheRight(lsHeading).equals("flyoutRow2Right"), "Brand section of the flyout "+lsHeading+ " is located on the Right side under the heading "+"'"+BrandSectionHeading+"'","Brand section of the flyout "+lsHeading+ " is not located on the Right side");
			reporter.reportLog(getglobalheaderPageThreadLocal().validateFlyoutSubMenuSRCandHREF(lsHeading,BrandSectionHeading)+" of "+lsHeading);
			}
	}	
	
}		
