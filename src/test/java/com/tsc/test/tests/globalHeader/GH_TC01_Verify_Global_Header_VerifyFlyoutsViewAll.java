package com.tsc.test.tests.globalHeader;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC01_Verify_Global_Header_VerifyFlyoutsViewAll extends BaseTest {

	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() throws IOException {
		getglobalheaderPageThreadLocal().closeadd();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating View All links for each category");
		List<String> FOHeading=getglobalheaderPageThreadLocal().getFlyoutHeadings();
		for(String lsHeading:FOHeading) {
			String BrandSectionHeading= getglobalheaderPageThreadLocal().getFeatureBrandSectionHeading(lsHeading);
			
				String VielwAll=getglobalheaderPageThreadLocal().validateViewAllLinks(lsHeading,null);
				String brandSectionViewAll=getglobalheaderPageThreadLocal().validateViewAllLinks(lsHeading,BrandSectionHeading);
				reporter.reportLog("Flyout displays " + lsHeading+" department.");
				reporter.softAssert(VielwAll,"View All link present ", VielwAll+" for "+lsHeading+" in the left hand side section.",VielwAll+" for "+VielwAll+" in the left hand side section.");
				reporter.softAssert(brandSectionViewAll,"View All link present ",brandSectionViewAll+" for "+lsHeading+" in the Brand Section.",brandSectionViewAll+" for "+lsHeading+" in the Brand Section.");
				getglobalheaderPageThreadLocal().clickViewAllLinks(lsHeading);
				int numberOfWindows = getglobalheaderPageThreadLocal().getNumberOftabs();
				System.out.println("number of tabs open:  "+numberOfWindows);
				List<String> lsTitle=getglobalheaderPageThreadLocal().getTitleofViewAllLink();
				//System.out.println("size of list of title:   "+lsTitle);
				reporter.reportLog("Total number of tabs open: "+numberOfWindows);
				reporter.softAssert(lsTitle.size()==(numberOfWindows-1), "All View All links have been clicked", "All View All links have not been clicked");
				for(int i=0; i<numberOfWindows-1; i++) {
					reporter.softAssert(lsTitle.get(i).contains(lsHeading), "Title of View All link page is correct for "+lsHeading, "Title of View All link page is incorrect for "+lsHeading);
				}
			}
	}

}
