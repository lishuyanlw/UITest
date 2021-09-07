package com.tsc.test.tests.homePage;
import java.io.IOException;
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
			String lsYmlNotFound=TestDataHandler.constantDataVariables.getlnk_NotFound();
			homePageThreadLocal().clickallLinks();
			int numberOfWindows = homePageThreadLocal().getNumberOftabs();
			int totalTSimage = homePageThreadLocal().getTSmainimgCount();
			reporter.reportLog("Total number of tabs open: "+numberOfWindows);
			reporter.reportLog("Number of total TS image: "+totalTSimage);
			for(int i=0; i<totalTSimage; i++) {
				String lsUrl=	homePageThreadLocal().getTabUrlList().get(i);
				reporter.reportLog("URL of tab " +(i+1)+" is "+ lsUrl);
				reporter.softAssert(!lsUrl.contains(lsYmlNotFound),("URL of tab " +(i+1)+" does not contain notfound"),("URL of tab " +(i+1)+" does contain notfound"));
				reporter.softAssert(homePageThreadLocal().getTabUrlList().contains(lsUrl), "URL of tab " +(i+1)+ " is different","URL of tab " +(i+1)+" is same");
			}	
			reporter.softAssert(totalTSimage==(numberOfWindows-1), "All TS images have been clicked", "All TS images have not been clicked");
		}
	}

