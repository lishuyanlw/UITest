package com.tsc.test.tests.globalHeader;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
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
		List<WebElement> headingsElement=getglobalheaderPageThreadLocal().getFlyoutHeadingsWebelement();
		for(WebElement lsHeading:headingsElement) {
			
			String flyoutHeading=lsHeading.getText();
			reporter.reportLog("Validation of Flyout heading "+flyoutHeading);
			
			reporter.softAssert(getglobalheaderPageThreadLocal().validateSubMenuHeadings(lsHeading,"Curated Collection"), "Curated Collection Heading is present for "+flyoutHeading,"Curated Collection Heading is not present for "+flyoutHeading);
			String curatedcollectionhref=getglobalheaderPageThreadLocal().verify_Header_SubMenu("CuratedCollection");
			reporter.softAssert(curatedcollectionhref=="","href is present for all elements of Curated collection under flyout heading "+flyoutHeading,"href missing for "+flyoutHeading+" > Curated Collection > "+curatedcollectionhref);
			
			reporter.softAssert(getglobalheaderPageThreadLocal().validateSubMenuHeadings(lsHeading,"Popular Brand"), "Popular Brand Heading is present for "+flyoutHeading,"Popular Brand Heading is not present for "+flyoutHeading);
			String popularbrandhref=getglobalheaderPageThreadLocal().verify_Header_SubMenu("PopularBrands");
			reporter.softAssert(popularbrandhref=="","href is present for all elements of Curated collection under flyout heading "+flyoutHeading,"href missing for "+flyoutHeading+" > Popular Brand > "+popularbrandhref);
			
		}	
		
		
		
		
		
		
		
		
		
	
		//below commented lines are used for providing specific flyout heading, category and itemname perameters.
		
		//List<String> SubmenuItemlinktext=getglobalheaderPageThreadLocal().getSubMenuItemlist("Clearance","","Fashion","Casualwear",null);//"Casualwear"
		//reporter.reportLog("On moving mouse over "+ "Clearance"+" > "+ "Fashion"+" section has links :"+SubmenuItemlinktext);
		
		//String LefthandsideSectionLinks=getglobalheaderPageThreadLocal().validateFlyoutSubMenuItemSRCandHREF_new("Clearance","","Fashion","Casualwear",null);
		//reporter.softAssert(LefthandsideSectionLinks,"All atributes are present", LefthandsideSectionLinks+" for "+"Clearance >"+"Fashion >"+"Casualwear "+"in the lef hand side section." ,"Element missing for "+"Clearance >"+"Fashion >"+LefthandsideSectionLinks+ " in the left hand side section");
		//List<String> Submenulinktext_Curated=getglobalheaderPageThreadLocal().getSubMenuItemlist("Kitchen","Curated Collections",null,"Outdoor Dining",null);
		//List<String> Submenulinktext_PopularBrands=getglobalheaderPageThreadLocal().getSubMenuItemlist("Kitchen","Popular Brands",null,"KitchenAid","href");
		/*for(String lsHeading:FOHeading) {
			List<String> Category=getglobalheaderPageThreadLocal().getCategorieslist(lsHeading,null);
			List<String> Submenulinktext_PopularBrandsLinks=getglobalheaderPageThreadLocal().getSubMenuItemlist(lsHeading,"Popular Brands",null,null,"src");
			List<String> Submenulinktext_CuratedCollections=getglobalheaderPageThreadLocal().getSubMenuItemlist(lsHeading,"Curated Collections",null,null,null);
			String PopularBrandsLinks_href=getglobalheaderPageThreadLocal().validateFlyoutSubMenuItemSRCandHREF_try(lsHeading,"Popular Brands",null,null,"href");
			String PopularBrandsLinks_src=getglobalheaderPageThreadLocal().validateFlyoutSubMenuItemSRCandHREF_try(lsHeading,"Popular Brands",null,null,"src");
			String CuratedCollectionsLinks=getglobalheaderPageThreadLocal().validateFlyoutSubMenuItemSRCandHREF_try(lsHeading,"Curated Collections",null,null,null);
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
			
			
			/*for(String lsCategory:Category) {
				List<String> Submenulinktext=getglobalheaderPageThreadLocal().getSubMenuItemlist(lsHeading,"",lsCategory,null,null);
				String SubmenuItemsLinks_href=getglobalheaderPageThreadLocal().validateFlyoutSubMenuItemSRCandHREF_try(lsHeading,"",lsCategory,null,null);
				
				reporter.reportLog("On moving mouse over > "+ lsHeading+" > "+ lsCategory+" > "+Submenulinktext);
				reporter.softAssert(SubmenuItemsLinks_href,"All atributes are present",SubmenuItemsLinks_href+" in the left hand side Section of "+lsHeading+ " > "+lsCategory,"Element missing for "+lsHeading+" > "+lsCategory+" > " +SubmenuItemsLinks_href);
			}*/
		
	}	
}



		
