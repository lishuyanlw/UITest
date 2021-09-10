package com.tsc.test.tests.homePage;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

	public class HP_TC02_Verify_TSmainImage extends BaseTest{
		@Test(groups={"Home","Regression"})
	
		public void validateTSmainImageSection() throws IOException, InterruptedException {
			homePageThreadLocal().closeadd();	
			reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
			reporter.reportLogWithScreenshot("Home Page");
			int totalTSimageUpperSection = homePageThreadLocal().getTSimgUpperSectionCount();
			reporter.reportLog("Number of total TS image in the upper section: "+totalTSimageUpperSection);
			List<String> lshref_UpperSection=homePageThreadLocal().gethrefListTSimageUpperSection();
			for(int i=0; i<totalTSimageUpperSection; i++) {
			}
			
			String lsYmlNotFound=TestDataHandler.constantDataVariables.getlnk_NotFound();
			homePageThreadLocal().clickallTSimageUpperSectionLinks();
			int numberOfWindows_UpperSection = homePageThreadLocal().getNumberOftabs();
			List<String> lsUrl_UpperSection=homePageThreadLocal().getTabUrlListTSimageUpperSection();
			
			//Method to validate TS image in the upper section			
			reporter.reportLog("Total number of tabs open for TS image Upper Section: "+numberOfWindows_UpperSection);
			reporter.softAssert(totalTSimageUpperSection==(numberOfWindows_UpperSection-1), "All TS images in upper section have been clicked", "All TS images in upper section have not been clicked");
		
			for(int i=0; i<totalTSimageUpperSection; i++) {
				reporter.softAssert(!lsUrl_UpperSection.get(i).contains(lsYmlNotFound),("URL of tab " +(i+1)+" is "+lsUrl_UpperSection.get(i)+" & it does not contain not found"),("URL of tab " +(i+1)+" is "+lsUrl_UpperSection.get(i)+" & does contain not found"));
					if(i<lsUrl_UpperSection.size()-1) {
						reporter.softAssert(!lsUrl_UpperSection.get(i).equals(lsUrl_UpperSection.get(i+1)), "URL of tab " +(i+1)+ " is different than URL of Tab "+((i+1)+1)+" for TS image upper section.","URL of Tab " +(i+1)+" is same as URL of Tab"+((i+1)+1)+" for TS image upper section.");
					}
					
			}
			
			
		}
	}

