package com.tsc.test.tests.homePage;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
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
			int totalTSimage = homePageThreadLocal().getTSmainimgCount();
			reporter.reportLog("Number of total TS image: "+totalTSimage);
			String lsYmlNotFound=TestDataHandler.constantDataVariables.getlnk_NotFound();
			homePageThreadLocal().clickallLinks();
			int numberOfWindows = homePageThreadLocal().getNumberOftabs();
			List<String> lsUrl=homePageThreadLocal().getTabUrlList();
			reporter.reportLog("Total number of tabs open: "+numberOfWindows);
			reporter.softAssert(totalTSimage==(numberOfWindows-1), "All TS images have been clicked", "All TS images have not been clicked");
						
			for(int i=0; i<totalTSimage; i++) {
				reporter.softAssert(!lsUrl.get(i).contains(lsYmlNotFound),("URL of tab " +(i+1)+"is"+lsUrl.get(i)+" & it does not contain notfound"),("URL of tab " +(i+1)+"is"+lsUrl.get(i)+" & does contain notfound"));
			}
			
			for(int i=0; i<lsUrl.size(); i++) {
				for (int j=0; j<lsUrl.size(); j++) {
					if(i!=j) {
						reporter.softAssert(!(lsUrl.get(i).equals(lsUrl.get(j))), "URL of tab " +(i+1)+ " is different than URL of Tab "+(j+1),"URL of Tab " +(i+1)+" is same as URL of Tab"+(j+1));
					}
				}	
			}
		}
	}

