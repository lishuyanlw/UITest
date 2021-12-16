package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;

public class GF_TC04_Verify_GlobalFooter_TSCCustomerHub_LinksAndPageObjects extends BaseTest {
	/*
	 * CER-171
	 * CER-172
	 * CER-174
	 * CER-175
	 * CER-178
	 * CER-181
	 * CER-182	 
	 */
	@Test(groups={"Home","Regression","GlobalFooter"})
	public void Verify_GlobalFooter_LinksAndPageObjects() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");		
		reporter.reportLog("Global Footer Section");		
		
		List<List<String>> lstNameAndLinks=TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
		String lsService,lsHref,lsYmlHref;
		ArrayList<WebElement> elementList=new ArrayList<WebElement>();

		//Customer service
		lsService="Customer Service";
		Map<String,String> hashMap = getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
		reporter.reportLog(lsService);
		WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService,hashMap.get("parent"));
		lsHref=basePage.getElementHref(selectedItem);		
		//lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		lsYmlHref=hashMap.get("Link");
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblCustomerService,hashMap.get("parent"))) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {			
			elementList.add(getGlobalFooterPageThreadLocal().lblCustomerService);
			elementList.add(getGlobalFooterPageThreadLocal().lblHowCanWeHelpYou);
			elementList.add(getGlobalFooterPageThreadLocal().inputSearchBox);
			elementList.add(getGlobalFooterPageThreadLocal().lblFrequentlyAskedQuestions);
			
			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
	
			int listSize=getGlobalFooterPageThreadLocal().lstFrequentlyAskedQuestions.size();
			for(int i=0;i<listSize;i++) {
				WebElement item=getGlobalFooterPageThreadLocal().lstFrequentlyAskedQuestions.get(i);
				String lsItem=item.getText().trim();
				reporter.reportLog(lsItem);
				reporter.softAssert(!lsItem.isEmpty(),"The item text is not empty","The item text is empty");
				reporter.softAssert(!basePage.getElementHref(item).isEmpty(),"The link of "+lsItem+" is not empty","The link of "+lsItem+" is empty");
				getGlobalFooterPageThreadLocal().verifyLinksForFrequentlyAskedQuestionsInCustomerServicePageObject(item);
			}
		}		
		elementList.clear();

		//Track Your Order
		lsService="Track Your Order";
		hashMap.clear();
		hashMap = getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
		reporter.reportLog(lsService);
		List<String> lstTrackYourOrderObjectSectionTitle=TestDataHandler.constantData.getFooterSection().getLst_TrackYourOrderObjectSectionTitle();
		selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService,hashMap.get("parent"));
		lsHref=basePage.getElementHref(selectedItem);
		//lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		lsYmlHref=hashMap.get("Link");
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblTrackYourOrder,hashMap.get("parent"))) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {
			List<WebElement> mandotoryFieldList=new ArrayList<WebElement>();
			mandotoryFieldList.add(getGlobalFooterPageThreadLocal().cntOrderNumber);
			mandotoryFieldList.add(getGlobalFooterPageThreadLocal().cntBillingPostalCode);
			mandotoryFieldList.add(getGlobalFooterPageThreadLocal().btnTrackYourOrderSubmit);
			getGlobalFooterPageThreadLocal().verifyServiceObjectSectionTitle(mandotoryFieldList, lstTrackYourOrderObjectSectionTitle, false);
						
			getGlobalFooterPageThreadLocal().displayAlertMessageForOrderNumberAndSignInInput();
						
			//Add The alert message into the list
			elementList.add(getGlobalFooterPageThreadLocal().lblOrderNumberAlertMsg);
			elementList.add(getGlobalFooterPageThreadLocal().lblBillingPostalCodeAlertMsg);
			elementList.add(getGlobalFooterPageThreadLocal().lblEmailAddressAlertMsg);
			elementList.add(getGlobalFooterPageThreadLocal().lblPasswordAlertMsg);
			
			//Add elements in order section
			elementList.add(getGlobalFooterPageThreadLocal().lblTrackYourOrder);
			elementList.add(getGlobalFooterPageThreadLocal().lblRequiredFieldsInfo);			
			elementList.add(getGlobalFooterPageThreadLocal().lblOrderNumberTitle);
			elementList.add(getGlobalFooterPageThreadLocal().lblOrderNumberLable);
			elementList.add(getGlobalFooterPageThreadLocal().inputOrderNumber);			
			elementList.add(getGlobalFooterPageThreadLocal().lblBillingPostalCodeLabel);
			elementList.add(getGlobalFooterPageThreadLocal().inputBillingPostalCode);		
			elementList.add(getGlobalFooterPageThreadLocal().btnTrackYourOrderSubmit);
			
			//Add elements in sign in section
			elementList.add(getGlobalFooterPageThreadLocal().lblTrackYourOrderSignUpTitle);
			elementList.add(getGlobalFooterPageThreadLocal().lblGetAllDetailsInfo);
			elementList.add(getGlobalFooterPageThreadLocal().lblEmailAddressLable);
			elementList.add(getGlobalFooterPageThreadLocal().inputEmailAddress);			
			elementList.add(getGlobalFooterPageThreadLocal().lblPasswordLabel);
			elementList.add(getGlobalFooterPageThreadLocal().inputPassword);			
			elementList.add(getGlobalFooterPageThreadLocal().btnShowOrHidePassword);
			elementList.add(getGlobalFooterPageThreadLocal().btnTrackYourOderSignIn);
			
			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		}
		elementList.clear();
		
		//Contact Us
		lsService="Contact Us";
		hashMap.clear();
		hashMap = getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
		reporter.reportLog(lsService);
		selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService,hashMap.get("parent"));
		lsHref=basePage.getElementHref(selectedItem);		
		//lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		lsYmlHref=hashMap.get("Link");
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblContactUS,hashMap.get("parent"))) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {		
			elementList.add(getGlobalFooterPageThreadLocal().lblContactUS);
			elementList.add(getGlobalFooterPageThreadLocal().lblWhatCanWeHelpYouWith);
			elementList.add(getGlobalFooterPageThreadLocal().selectContactUS);
			elementList.add(getGlobalFooterPageThreadLocal().lblPleaseVisitUSInfo);
			elementList.add(getGlobalFooterPageThreadLocal().lnkPleaseVisitUS);
			
			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
			
			getGlobalFooterPageThreadLocal().verifyDropdownOptionContent();
		}
		elementList.clear();
		
		//Blog
		lsService="Blog";
		hashMap.clear();
		hashMap = getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
		reporter.reportLog(lsService);
		selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService,hashMap.get("parent"));
		lsHref=basePage.getElementHref(selectedItem);		
		//lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		lsYmlHref=hashMap.get("Link");
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}
		reporter.softAssert(getGlobalFooterPageThreadLocal().compareUrlInNewWindow(lsService, lsYmlHref,hashMap.get("parent")),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);

		//My Account 
		lsService="My Account";
		hashMap.clear();
		hashMap = getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
		reporter.reportLog("Not login for "+lsService);
		verifyMyAccountNotLoginContents(lsService, lstNameAndLinks,hashMap.get("parent"));
		
		reporter.reportLog("Login for "+lsService);
		String lsUserName=TestDataHandler.constantData.getLoginUser().getLbl_Username();
		String lsPassword=TestDataHandler.constantData.getLoginUser().getLbl_Password();
		String lsFirstName=TestDataHandler.constantData.getLoginUser().getLbl_FirstName();
		if(getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword,lsFirstName)) {			
			verifyMyAccountLoginContents(lsService, lstNameAndLinks);
		}
		else {
			reporter.reportLogFail("Login failed");
		}

	}
	
	void verifyMyAccountNotLoginContents(String lsService, List<List<String>> lstNameAndLinks,String section) {
		BasePage basePage=new BasePage(this.getDriver());	
		ArrayList<WebElement> elementList=new ArrayList<WebElement>();

		List<String> lstMyAccountObjectSectionTitle=TestDataHandler.constantData.getFooterSection().getLst_MyAccountObjectSectionTitle();
		WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService,section);
		String lsHref=basePage.getElementHref(selectedItem);		
		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
				
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblMyAccount,section)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(basePage.URL(),lsYmlHref),"The current Url of "+basePage.URL()+" for '"+lsService+" is equal to "+lsYmlHref,"The current Url of "+basePage.URL()+" for '"+lsService+" is not equal to "+lsYmlHref);
			getGlobalFooterPageThreadLocal().expandPanelItems(getGlobalFooterPageThreadLocal().lstMyAccountItemTitle,getGlobalFooterPageThreadLocal().lstMyAccountItemContent);
			getGlobalFooterPageThreadLocal().verifyServiceObjectSectionTitle(getGlobalFooterPageThreadLocal().lstMyAccountItemTitle, lstMyAccountObjectSectionTitle, true);

			elementList.add(getGlobalFooterPageThreadLocal().lblMyAccount);
			
			//Add myaccount item section titles 
			for(WebElement item:getGlobalFooterPageThreadLocal().lstMyAccountItemTitle) {
				elementList.add(item);
			}
			
			//Add myaccount item section contents
			for(WebElement item:getGlobalFooterPageThreadLocal().lstMyAccountItemContent) {
				elementList.add(item);
			}
			
			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		}
	}
	
	void verifyMyAccountLoginContents(String lsService, List<List<String>> lstNameAndLinks) {
		BasePage basePage=new BasePage(this.getDriver());
		basePage.getReusableActionsInstance().staticWait(1000);
		
		ArrayList<WebElement> elementList=new ArrayList<WebElement>();

		elementList.add(getGlobalFooterPageThreadLocal().lblMyAccountLoginName);
		elementList.add(getGlobalFooterPageThreadLocal().lblCustomerNumber);
		elementList.add(getGlobalFooterPageThreadLocal().lblCustomerNO);
				
		//Add myaccount service panel headings 
		for(WebElement item:getGlobalFooterPageThreadLocal().lstMyAccountSerivePanelHeading) {
			elementList.add(item);
		}
		
		//Add myaccount service panel items
		for(WebElement item:getGlobalFooterPageThreadLocal().lstMyAccountSerivePanelItem) {
			elementList.add(item);
		}
		
		getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		
		//Add myaccount service panel items
		getGlobalFooterPageThreadLocal().verifyMyAccountSerivePanelItem();
		

	}

}
