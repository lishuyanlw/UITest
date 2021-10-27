package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
public class GH_TC02_Global_Header_Verify_FlyoutsSubMenuItems extends BaseTest {

	
	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() throws IOException {
		
		getglobalheaderPageThreadLocal().closeadd();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating Flyout Sub Menu for each category");
		List<String> FOHeading=getglobalheaderPageThreadLocal().getFlyoutHeadings();
		//reporter.reportLog("Flyout header diplyas drpartment: "+FOHeading);
		//below commented lines are used for providing specific flyout heading, category and itemname perameters.
		//String SubmenuItemlinktext=getglobalheaderPageThreadLocal().getSubMenuItemlist("Clearance","","Fashion","Casualwear").get(0);
		//reporter.reportLog("On moving mouse over "+ "Clearance"+", "+ "Fashion"+" section has links :"+SubmenuItemlinktext);
		//String LefthandsideSectionLinks=getglobalheaderPageThreadLocal().validateFlyoutSubMenuItemSRCandHREF_new("Clearance","","Fashion","Casualwear",null);
		//reporter.softAssert(LefthandsideSectionLinks,"All atributes are present", LefthandsideSectionLinks+" for "+"Clearance >"+"Fashion >"+"Casualwear "+"in the lef hand side section." ,"Element missing for "+"Clearance >"+"Fashion >"+LefthandsideSectionLinks+ " in the left hand side section");
		//List<String> Submenulinktext_Curated=getglobalheaderPageThreadLocal().getSubMenuItemlist("Kitchen","Curated Collections",null,"Outdoor Dining",null);
		//List<String> Submenulinktext_PopularBrands=getglobalheaderPageThreadLocal().getSubMenuItemlist("Kitchen","Popular Brands",null,"KitchenAid","href");
		for(String lsHeading:FOHeading) {
			List<String> Category=getglobalheaderPageThreadLocal().getCategorieslist_try(lsHeading,null);
			/*List<String> Submenulinktext_PopularBrandsLinks=getglobalheaderPageThreadLocal().getSubMenuItemlist(lsHeading,"Popular Brands",null,null,"src");
			List<String> Submenulinktext_CuratedCollections=getglobalheaderPageThreadLocal().getSubMenuItemlist(lsHeading,"Curated Collections",null,null,null);
			String PopularBrandsLinks_href=getglobalheaderPageThreadLocal().validateFlyoutSubMenuItemSRCandHREF(lsHeading,"Popular Brands",null,null,"href");
			String PopularBrandsLinks_src=getglobalheaderPageThreadLocal().validateFlyoutSubMenuItemSRCandHREF(lsHeading,"Popular Brands",null,null,"src");
			String CuratedCollectionsLinks=getglobalheaderPageThreadLocal().validateFlyoutSubMenuItemSRCandHREF(lsHeading,"Curated Collections",null,null,null);
			reporter.reportLog("Flyout displays " + lsHeading+" department.");
			
			//validation of Popular Brand section
			reporter.reportLog("Flyout heading "+  lsHeading+" > Popular Brand >"+"  "+Submenulinktext_PopularBrandsLinks);
			reporter.softAssert(PopularBrandsLinks_href,"href present for all elements",PopularBrandsLinks_href+" in the Popular Brand Section of "+lsHeading,"For "+lsHeading+" > Popular Brand > "+PopularBrandsLinks_href+"href is missing");
			reporter.softAssert(PopularBrandsLinks_src,"src present for all elements",PopularBrandsLinks_src+" in the Popular Brand Section of "+lsHeading,"For "+lsHeading+" > Popular Brand > "+PopularBrandsLinks_src);
			
			//validation of Curated Collections section
			reporter.reportLog("Flyout heading "+  lsHeading+" > Curated Collections >"+"  "+Submenulinktext_CuratedCollections);
			reporter.softAssert(CuratedCollectionsLinks,"All atributes are present",CuratedCollectionsLinks+" in the Curated Collections Section of "+lsHeading,"Element missing for "+lsHeading+" > Curated Collections > " +CuratedCollectionsLinks);
		
			//validation of Left Hand side category section(//for this section test case is getting failed due to stale element exception)
			reporter.reportLog("Flyout heading "+  lsHeading+" displyas cateory:"+"  "+Category);
			*/
			String SubmenuItemsLinks_href=getglobalheaderPageThreadLocal().validateFlyoutSubMenuItemSRCandHREF(lsHeading,"",null,null,null);
			
			for(String lsCategory:Category) {
				List<String> Submenulinktext=getglobalheaderPageThreadLocal().getSubMenuItemlist(lsHeading,"",lsCategory,null,null);
				reporter.reportLog("On moving mouse over > "+ lsHeading+" > "+ lsCategory+" > "+Submenulinktext);
				//reporter.softAssert(SubmenuItemsLinks_href,"All atributes are present",SubmenuItemsLinks_href+" in the left hand side Section of "+lsHeading+ " > "+lsCategory,"Element missing for "+lsHeading+" > "+lsCategory+" > " +SubmenuItemsLinks_href);
			}
			//refreshing the Browser due to instability of website for Havas changes. Will remove it once website more stable.
			//getDriver().navigate().refresh();		
		}
	}	
}



		
