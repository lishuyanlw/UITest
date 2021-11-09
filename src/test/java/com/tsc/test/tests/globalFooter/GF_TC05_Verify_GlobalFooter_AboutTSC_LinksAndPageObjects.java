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
	 * CER-184
	 * CER-185
	 * CER-186
	 * CER-187
	 * CER-188
	 * CER-189
	 * CER-190
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
		ArrayList<WebElement> elementList=new ArrayList<WebElement>();

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

			elementList.add(getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService);

			//Add item section titles in Terms of Use 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemTitle) {
				elementList.add(item);
			}

			//Add item section contents in Terms of Use 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemContent) {
				elementList.add(item);
			}

			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		}
		elementList.clear();

        //Privacy Policy
		lsService="Privacy Policy";
		reporter.reportLog(lsService);
		WebElement selectedPPItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		String lsPPHref=basePage.getElementHref(selectedPPItem);		
		String lsPPYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsPPYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsPPHref,lsPPYmlHref),"The current '"+lsService+"' href of "+lsPPHref+" is equal to "+lsPPYmlHref,"The current '"+lsService+"' href of "+lsPPHref+" is not equal to "+lsPPYmlHref);

		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {			
			getGlobalFooterPageThreadLocal().expandPanelItems(getGlobalFooterPageThreadLocal().lstTermsOfUseItemTitle,getGlobalFooterPageThreadLocal().lstTermsOfUseItemContent);

			elementList.add(getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService);

			//Add item section titles in Terms of Use 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemTitle) {
				elementList.add(item);
			}

			//Add item section contents in Terms of Use 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemContent) {
				elementList.add(item);
			}

			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		}
		elementList.clear();

        //Become a Vendor
		lsService="Become a Vendor";
		reporter.reportLog(lsService);
		WebElement selectedBVItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		String lsBVHref=basePage.getElementHref(selectedBVItem);		
		String lsBVYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsBVYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsBVHref,lsBVYmlHref),"The current '"+lsService+"' href of "+lsBVHref+" is equal to "+lsBVYmlHref,"The current '"+lsService+"' href of "+lsBVHref+" is not equal to "+lsBVYmlHref);

		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {			
			getGlobalFooterPageThreadLocal().expandPanelItems(getGlobalFooterPageThreadLocal().lstTermsOfUseItemTitle,getGlobalFooterPageThreadLocal().lstTermsOfUseItemContent);

			elementList.add(getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService);

			//Add item section titles in Terms of Use 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemTitle) {
				elementList.add(item);
			}

			//Add item section contents in Terms of Use 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemContent) {
				elementList.add(item);
			}

			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		}
		elementList.clear();

        //More about TSC
		lsService="More About TSC";
		reporter.reportLog(lsService);
		WebElement selectedMATSCItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		String lsMATSCHref=basePage.getElementHref(selectedMATSCItem);		
		String lsMATSCYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsMATSCYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsMATSCHref,lsMATSCYmlHref),"The current '"+lsService+"' href of "+lsMATSCHref+" is equal to "+lsMATSCYmlHref,"The current '"+lsService+"' href of "+lsMATSCHref+" is not equal to "+lsMATSCYmlHref);

		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {	
			
			//Become a Vendor
			getGlobalFooterPageThreadLocal().lstMoreAboutTSCPBecomeAVendor.click();

			getGlobalFooterPageThreadLocal().expandPanelItems(getGlobalFooterPageThreadLocal().lstTermsOfUseItemTitle,getGlobalFooterPageThreadLocal().lstTermsOfUseItemContent);

			elementList.add(getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService);

			//Add item section titles in Terms of Use 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemTitle) {
				elementList.add(item);
			}

			//Add item section contents in Terms of Use 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemContent) {
				elementList.add(item);
			}

			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		}
		elementList.clear();
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}else {

            // About Our Service
			getGlobalFooterPageThreadLocal().lstMoreAboutTSCAboutOurService.click();

			getGlobalFooterPageThreadLocal().expandPanelItems(getGlobalFooterPageThreadLocal().lstTermsOfUseItemTitle,getGlobalFooterPageThreadLocal().lstTermsOfUseItemContent);

			elementList.add(getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService);

			//Add item section titles in Terms of Use 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemTitle) {
				elementList.add(item);
			}

			//Add item section contents in Terms of Use 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstTermsOfUseItemContent) {
				elementList.add(item);
			}

			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
			elementList.clear();
		}
	}

}
