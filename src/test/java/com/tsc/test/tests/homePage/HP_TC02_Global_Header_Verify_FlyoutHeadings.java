package com.tsc.test.tests.homePage;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC02_Global_Header_Verify_FlyoutHeadings extends BaseTest {

	
		@Test(groups={"Home","Regression"})	    
		public void verifyFlyoutHeadings() throws IOException {
			getglobalheaderPageThreadLocal().closeadd();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLogWithScreenshot("Home Page");
		
		for(int i=0; i<getglobalheaderPageThreadLocal().getFlyoutHeadingCount(); i++) {
			//validateText(getglobalheaderPageThreadLocal().getFlyoutHeadings(i), TestDataHandler.constantDataVariables.getlst_lst_FlyoutHeading(), "Flyout Heading text is visible and valid");
			 reporter.reportLog("Flyout Heading " + (i+1) +":" + getglobalheaderPageThreadLocal().getFlyoutHeadings(i));	 	
			 System.out.println("value of i " + i);
				System.out.println("get heading " +getglobalheaderPageThreadLocal().getFlyoutHeadings(i));
				//System.out.println("get heading from yml "+TestDataHandler.constantDataVariables.getlbl_SearchKeyword_SpecialCharacters());
				System.out.println(TestDataHandler.constantDataVariables.getlbl_ShopByDepartment());
				//validateText(getglobalheaderPageThreadLocal().getFlyoutHeadings(i), TestDataHandler.constantDataVariables.getlst_FlyoutHeading().get(i), "Flyout Heading text is visible and valid");			
			// reporter.reportLog("Flyout Heading " + (i+1) +":" + getglobalheaderPageThreadLocal().getFlyoutHeadings(i));	 	
				 	
		}
	//	reporter.softAssert(getglobalheaderPageThreadLocal().verifyFlyoutHeading1(TestDataHandler.constantDataVariables.getlst_FlyoutHeading()), "Flyout heading matches the expected result", "Flyout heading does not match the expected result");
		
	}

		

}
