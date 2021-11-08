package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.test.base.BaseTest;

import com.tsc.pages.base.BasePage;

public class HP_TC04_Verify_ShopByDepartment extends BaseTest{
	/*
	 * Method to verify shop by Department section and its automatic scrolling action
	 * @author Shruti Desai
	 */
	@Test(groups={"Home","Regression"})
	public void validateShopByDepartmentSection() throws IOException {

	getGlobalFooterPageThreadLocal().closePopupDialog();

	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
	reporter.reportLogWithScreenshot("Home Page");
	
	reporter.softAssert(homePageThreadLocal().validateShopByDepartmentAutomaticScrollingAction(),"The automatic scrolling function in Shop By Department section is working well","The The automatic scrolling function in Shop By Department section is not working well");
	
	validateText(homePageThreadLocal().validateShopByDepartmentIsInMiddle(),"Middle", "Shop By Department section is located in the Middle class of the webpage");
	
	reporter.softAssert(homePageThreadLocal().verifySBDimgCount(),"Image Count for this section is: "+homePageThreadLocal().getSBDimgCount(),"Image Count is: "+homePageThreadLocal().getSBDimgCount());
	reporter.softAssert(homePageThreadLocal().verifySBDactiveimgCount(),"Active Image Count for this section is: "+homePageThreadLocal().getSBDactiveimgCount(),"Active Image Count is: "+homePageThreadLocal().getSBDactiveimgCount());
		for(int i=0; i<homePageThreadLocal().getSBDimgCount(); i++) {
			reporter.softAssert(homePageThreadLocal().validateSBDsectionImages(i),"Image & Link is present for tile: "+(i+1),"Image & Link is not present for tile: "+(i+1));
			reporter.reportLog(homePageThreadLocal().validateSBDsectionLinks(i));
		}
			
	reporter.softAssert(homePageThreadLocal().validateShopByDepartmentClickPrevButton(),"The Prev button in Shop By Department section is working well","The Prev button in Shop By Department section is not working well");
	reporter.softAssert(homePageThreadLocal().validateShopByDepartmentClickNextButton(),"The Next button in Shop By Department section is working well","The Next button in Shop By Department section is not working well");
	
	}
	
}
