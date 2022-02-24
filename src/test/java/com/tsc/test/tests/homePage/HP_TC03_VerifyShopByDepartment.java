package com.tsc.test.tests.homePage;

import java.io.IOException;
import org.testng.annotations.Test;
import com.tsc.test.base.BaseTest;
import com.tsc.pages.base.BasePage;

public class HP_TC03_VerifyShopByDepartment extends BaseTest{
	/*
	 * Method to verify shop by Department section and its automatic scrolling action
	 * @author Shruti Desai
	 */
	@Test(groups={"Home","Regression"})
	public void HP_TC03_VerifyShopByDepartment() throws IOException {

	getGlobalFooterPageThreadLocal().closePopupDialog();

	if(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/")){
		reporter.reportLogPass("TSC url is correct");
	}
	else{
		reporter.reportLogFailWithScreenshot("TSC url is incorrect");
	}

	reporter.reportLog("Home Page");

	if(homePageThreadLocal().validateShopByDepartmentAutomaticScrollingAction()){
		reporter.reportLogPass("The automatic scrolling function in Shop By Department section is working well");
	}
	else{
		reporter.reportLogFailWithScreenshot("The The automatic scrolling function in Shop By Department section is not working well");
	}

	validateText(homePageThreadLocal().validateShopByDepartmentIsInMiddle(),"Middle", "Shop By Department section is located in the Middle class of the webpage");

	if(homePageThreadLocal().verifySBDimgCount()){
		reporter.reportLogPass("Image Count for this section is: "+homePageThreadLocal().getSBDimgCount());
	}
	else{
		reporter.reportLogFailWithScreenshot("Image Count is: "+homePageThreadLocal().getSBDimgCount());
	}

	if(homePageThreadLocal().verifySBDactiveimgCount()){
		reporter.reportLogPass("Active Image Count for this section is: "+homePageThreadLocal().getSBDactiveimgCount());
	}
	else{
		reporter.reportLogFailWithScreenshot("Active Image Count is: "+homePageThreadLocal().getSBDactiveimgCount());
	}

	for(int i=0; i<homePageThreadLocal().getSBDimgCount(); i++) {
		if(homePageThreadLocal().validateSBDsectionImages(i)){
			reporter.reportLogPass("Image & Link is present for tile: "+(i+1));
		}
		else{
			reporter.reportLogFailWithScreenshot("Image & Link is not present for tile: "+(i+1));
		}

		if(!homePageThreadLocal().validateSBDsectionLinks(i).equalsIgnoreCase("Image link href is empty")){
			reporter.reportLogPass("Image link href is not empty");
		}
		else{
			reporter.reportLogFailWithScreenshot("Image link href is empty");
		}
	}
	if(homePageThreadLocal().validateShopByDepartmentClickPrevButton()){
		reporter.reportLogPass("The Prev button in Shop By Department section is working well");
	}
	else{
		reporter.reportLogFailWithScreenshot("The Prev button in Shop By Department section is not working well");
	}

	if(homePageThreadLocal().validateShopByDepartmentClickNextButton()){
		reporter.reportLogPass("The Next button in Shop By Department section is working well");
	}
	else{
		reporter.reportLogFailWithScreenshot("The Next button in Shop By Department section is not working well");
	}

	}
	
}
