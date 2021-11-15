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
				
				//verifying More About TSC Module
				if(lsService.trim().equalsIgnoreCase(("More About TSC").trim())) {
					List<WebElement> elements=getGlobalFooterPageThreadLocal().lstMoreAboutTSCLinks;
					for(int i=1;i<=elements.size();i++) {
						getGlobalFooterPageThreadLocal().clickOnTSCOptionLink(i);
						GF_TC05_Verify_GlobalFooter_AboutTSC_LinksAndPageObjects.verifyExpandItemAndElementList(elementList, lsService);
						elementList.clear();
						getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService);
					}
				}
			}
			elementList.clear();
		}
	}

	//Verifying the Href with page link
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
	//Verifying Default page section titles and contents
	public static void verifyExpandItemAndElementList(ArrayList<WebElement> elementList,String lsService) {
        elementList.add(getGlobalFooterPageThreadLocal().lblTermsOfUseAboutOurService);
        //Add item section titles in Default Page Section
		for(WebElement item:getGlobalFooterPageThreadLocal().lstOfExpandedTitle) {
			elementList.add(item);
		}
        //Add item section contents in Default Page Section 
		for(WebElement item:getGlobalFooterPageThreadLocal().lstOfExpandedContent) {
			elementList.add(item);
		}
        getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);

	}
}
