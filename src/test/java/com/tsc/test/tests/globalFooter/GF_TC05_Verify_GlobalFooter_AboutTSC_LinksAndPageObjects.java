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

		List<List<String>> lstNameAndLinks=TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
		//String lsService;
		ArrayList<WebElement> elementList=new ArrayList<>();
		List<String> global_footer_items = new ArrayList<>();
		global_footer_items.add("Terms Of Use");
		global_footer_items.add("Privacy Policy");
		global_footer_items.add("Become a Vendor");
		global_footer_items.add("More About TSC");
		for(String lsService:global_footer_items) {
			
			GF_TC05_Verify_GlobalFooter_AboutTSC_LinksAndPageObjects.verifyTitle(basePage,lstNameAndLinks,lsService);
			
			if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService)) {
				reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
			}
			else {	
				GF_TC05_Verify_GlobalFooter_AboutTSC_LinksAndPageObjects.verifyExpandItemAndElementList(elementList, lsService);
				if(lsService.trim().equalsIgnoreCase("More About TSC")) {
					//Become a Vendor option
					getGlobalFooterPageThreadLocal().lstMoreAboutTSCPBecomeAVendor.click();
					GF_TC05_Verify_GlobalFooter_AboutTSC_LinksAndPageObjects.verifyExpandItemAndElementList(elementList, lsService);
					elementList.clear();
					
					// Company Overview
					getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService);
					getGlobalFooterPageThreadLocal().lstMoreAboutTSCAboutOurService.click();
					GF_TC05_Verify_GlobalFooter_AboutTSC_LinksAndPageObjects.verifyExpandItemAndElementList(elementList, lsService);
				}
			}
			elementList.clear();
			}
    }

	//Verifying the href with page link
	public static void verifyTitle(BasePage basePage,List<List<String>> lstNameAndLinks,String lsService) {
		reporter.reportLog(lsService);
		WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		String lsHref=basePage.getElementHref(selectedItem);		
		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);

	}
	//Verifying 
	public static void verifyExpandItemAndElementList(ArrayList<WebElement> elementList,String lsService) {
			getGlobalFooterPageThreadLocal().verifyPanelTitleExpanded(getGlobalFooterPageThreadLocal().lstOfExpandedTitle);
            elementList.add(getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService);

			//Add item section titles in About TSC 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstOfExpandedTitle) {
				elementList.add(item);
			}

			//Add item section contents in About TSC 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstOfExpandedContent) {
				elementList.add(item);
			}

			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);

	}
}
