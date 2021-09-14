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
	

	reporter.reportLog("Validating Flyout Sub Menu for each category");
	
	String FOHeading;
	
	
	for(int i=0; i<getglobalheaderPageThreadLocal().getFlyoutHeadingCount(); i++) {
		FOHeading = getglobalheaderPageThreadLocal().getFlyoutHeadings(i);
		List<String> SubMenu = getglobalheaderPageThreadLocal().getListSubMenu(i);
		List<String> SubMenuLinks = getglobalheaderPageThreadLocal().getFlyoutSubMenuLinks(i);
			reporter.reportLog("menu number:" + (i+1)+ " is "+ FOHeading);
			reporter.reportLog("submenu for " +FOHeading+" is"+getglobalheaderPageThreadLocal().getListSubMenu(i));
			reporter.reportLog("Submenu list : "+ TestDataHandler.constantDataVariables.getlst_FlyoutsubMenu());
			reporter.softAssert(getglobalheaderPageThreadLocal().getListSubMenu(i).containsAll(TestDataHandler.constantDataVariables.getlst_FlyoutsubMenu()),FOHeading +"'s sub menu list is correct", FOHeading +"'s sub menu list is incorrect");
	}
		
	}
}
/*
int	numberOfLinkssubMenu = SubMenu.size();
for(String submenuheading : SubMenu) {
	reporter.reportLog(submenuheading);
	for(String link : SubMenuLinks) {
		reporter.reportLog(link);
	}
	
}*/
//reporter.softAssert(getglobalheaderPageThreadLocal().getListSubMenu(i).retainAll(TestDataHandler.constantDataVariables.getlst_FlyoutsubMenu()),FOHeading +"'s sub menu list is correct", FOHeading +"'s sub menu list is incorrect");
//reporter.softAssert(getglobalheaderPageThreadLocal().getListSubMenu(i).containsAll(TestDataHandler.constantDataVariables.getlst_FlyoutsubMenu()),FOHeading +"'s sub menu list is correct", FOHeading +"'s sub menu list is incorrect");


/*for(String submenuheading : SubMenu) {
reporter.reportLog(FOHeading +"'s sub menu heading "+submenuheading);
reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyoutSubMenuLinks(i),"href of all links in "+submenuheading+" are not empty", "href of one link in "+submenuheading+" is emapty");

}*/
