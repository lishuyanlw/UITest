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
	
	String FOHeading;
	
	for(int i=0; i<getglobalheaderPageThreadLocal().getFlyoutHeadingCount(); i++) {
		FOHeading = getglobalheaderPageThreadLocal().getFlyoutHeadings(i);
		
		reporter.reportLog(FOHeading +"'s sub menu :"+  getglobalheaderPageThreadLocal().getListSubMenu(i));
		reporter.reportLog("menu number:" + i);
		reporter.softAssert(getglobalheaderPageThreadLocal().getListSubMenu(i).retainAll(TestDataHandler.constantDataVariables.getlst_FlyoutsubMenu()),FOHeading +"'s sub menu list is correct", FOHeading +"'s sub menu list is incorrect");
		//reporter.softAssert(getglobalheaderPageThreadLocal().getListSubMenu(i).containsAll(TestDataHandler.constantDataVariables.getlst_FlyoutsubMenu()),FOHeading +"'s sub menu list is correct", FOHeading +"'s sub menu list is incorrect");
		
	}
	}
}
