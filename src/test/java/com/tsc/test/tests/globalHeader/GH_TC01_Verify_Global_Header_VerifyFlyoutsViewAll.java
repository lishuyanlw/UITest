package com.tsc.test.tests.globalHeader;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC01_Verify_Global_Header_VerifyFlyoutsViewAll extends BaseTest {

	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() throws IOException {
		getglobalheaderPageThreadLocal().closeadd();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		reporter.reportLog("Validating shop all brand links.");
	/*	List<String> FOHeading=getglobalheaderPageThreadLocal().getFlyoutHeadings();
		reporter.reportLog("Flyout header diplyas drpartment: "+FOHeading);
		String lsUrl,shopallUrl,lsYmlNotFound,lsSuccessResult, lsFailResult;
		lsYmlNotFound=TestDataHandler.constantDataVariables.getlnk_NotFound();
		/*for(String lsHeading:FOHeading) {
			reporter.softAssert(getglobalheaderPageThreadLocal().validateShopAllPupularBrandhref(lsHeading,"Popular Brands",null,null,"href"),lsHeading + " > Popular Brands > "+" shop all brands href is present.",lsHeading + " > Popular Brands > "+" shop all brands href is not present.");
			lsUrl = getglobalheaderPageThreadLocal().validateUrlAfterclickingFlyoutHeading(lsHeading);
			shopallUrl=getglobalheaderPageThreadLocal().getURLshopallPupularBrand(lsHeading,"Popular Brands",null,null,"href");
			lsSuccessResult=String.format("The url [ %s ] does not contain [ %s ] after clicking shop all brands under >" + lsHeading + " > Popular Brands", shopallUrl,lsYmlNotFound);
			lsFailResult=String.format("The url of [ %s ] contains [ %s ] after clicking shop all brands under > " + lsHeading + " > Popular Brands", shopallUrl,lsYmlNotFound);
			reporter.softAssert(shopallUrl.contains(TestDataHandler.constantDataVariables.getlbl_shopallbrandsLandingPageLink()+lsUrl), lsHeading +" > Popular Brands > shop all brands's URL is correct", lsHeading +" > Popular Brands > shop all brands's URL is incorrect");
			reporter.softAssert(!lsUrl.contains(lsYmlNotFound), lsSuccessResult,lsFailResult);
		}*/
	}
}	