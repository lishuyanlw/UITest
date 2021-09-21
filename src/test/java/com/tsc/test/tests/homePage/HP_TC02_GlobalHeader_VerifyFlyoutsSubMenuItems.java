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
		reporter.reportLog("Validating Flyout Sub Menu for each category");		String FOHeading, BrandSectionHeading;
		for(int i=0; i<getglobalheaderPageThreadLocal().getFlyoutHeadingCount(); i++) {			FOHeading = getglobalheaderPageThreadLocal().getFlyoutHeadings(i);
			
			for (FOHeading=(getglobalheaderPageThreadLocal().getFlyoutHeadings(i)){
				
			BrandSectionHeading = getglobalheaderPageThreadLocal().getFeatureBrandSectionHeading(i);
			List<String> SubMenuLinks = getglobalheaderPageThreadLocal().getFlyoutSubMenuLinks(i);			List<String> SubMenu = getglobalheaderPageThreadLocal().getListSubMenu(i);
			//reporter.reportLog("Flyout displays " + FOHeading+" department. It's Sub Menu display sections: "+SubMenu);
			//reporter.softAssert(TestDataHandler.constantDataVariables.getlst_FlyoutsubMenu().containsAll(SubMenu),FOHeading +"'s sub menu section list is correct", FOHeading +"'s sub menu section list is incorrect");
			//reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyoutSubMenuLinks(i),"All links in submenu of "+FOHeading+" department are present", "One link in submenu of "+FOHeading+" department is not present");
			
			/*for(String submenuheading : SubMenu) {
				reporter.reportLog(submenuheading+"'s links are "+SubMenuLinks);
				//reporter.reportLog(submenuheading+ "'s validation for "+FOHeading );
				//reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyoutSubMenuLinks(i),submenuheading+" all items have href present", "Href for " +SubMenuLinks+" is empty");
			}*/
			int	numberOfLinkssubMenu = SubMenu.size();
			for(String submenuheading : SubMenu) {
				reporter.reportLog(submenuheading+"'s links validation for "+FOHeading+" department start from here");

				//reporter.reportLog(submenuheading);
				for(String link : SubMenuLinks) {
					reporter.reportLog(link);
				}
				
			}
				
				
			/*
			reporter.reportLog(getglobalheaderPageThreadLocal().validateFlyoutSubMenuLinks(i));
			reporter.softAssert(getglobalheaderPageThreadLocal().validateFeatureBrandSectionIsOnTheRight(i).equals("flyoutRow2Right"), "Brand section of the flyout "+FOHeading+ " is located on the Right side under the heading "+"'"+BrandSectionHeading+"'","Brand section of the flyout "+FOHeading+ " is not located on the Right side");
			reporter.reportLog(getglobalheaderPageThreadLocal().validateFlyoutSubMenuLinks(i));
			//reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyoutSubMenuLinks(i),"All links in Brand Section of "+FOHeading+" department are present", "One link in Brand Section of "+FOHeading+" department is not present");
			for(String submenuheading : SubMenu) {
				reporter.reportLog(submenuheading+ "'s validation for "+FOHeading );
				reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyoutSubMenuLinks(i),submenuheading+" all links in Brand Section have href present", "Href for " +SubMenuLinks+" in brand section is empty");
			}*/
		
			reporter.softAssert(getglobalheaderPageThreadLocal().validateFlyoutSubMenuimages(i),"All images in Brand Section of "+FOHeading+" department are present", "One image in Brand Section of "+FOHeading+" department is not present");
			
			}
			
		}
	}
}
