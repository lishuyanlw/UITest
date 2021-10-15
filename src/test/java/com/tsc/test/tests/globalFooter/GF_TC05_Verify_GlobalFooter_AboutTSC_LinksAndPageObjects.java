package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;

public class GF_TC05_Verify_GlobalFooter_AboutTSC_LinksAndPageObjects extends BaseTest {
	/*
	 * CER-183
	 */
	@Test(groups={"Home","Regression","GlobalFooter"})
	public void Verify_GlobalFooter_LinksAndPageObjects() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");		
		reporter.reportLog("Global Footer Section");		

		List<List<String>> lstNameAndLinks=TestDataHandler.constantDataVariables.getlst_NameAndLinks();
		String lsService;
		
		//Terms of Use
		lsService="Terms of Use";
		reporter.reportLog(lsService);
		WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		String lsHref=basePage.getElementHref(selectedItem);		
		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {			
			getGlobalFooterPageThreadLocal().expandPanelItems(getGlobalFooterPageThreadLocal().lstTermsOfUseItemTitle,getGlobalFooterPageThreadLocal().lstTermsOfUseItemContent);
			ArrayList<WebElement> elementList=new ArrayList<WebElement>();
			elementList.add(getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService);
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemTitle) {
				elementList.add(item);
			}
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemContent) {
				elementList.add(item);
			}
			
			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		}


		
	}

}
