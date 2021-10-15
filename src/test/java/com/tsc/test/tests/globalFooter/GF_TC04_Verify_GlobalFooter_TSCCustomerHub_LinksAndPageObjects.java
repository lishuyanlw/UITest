package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		List<List<String>> lstNameAndLinks=TestDataHandler.constantDataVariables.getlst_NameAndLinks();
		String lsService;
		
		//Customer service
		lsService="Customer Service";
		reporter.reportLog(lsService);
		WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		String lsHref=basePage.getElementHref(selectedItem);		
		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblCustomerService)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {
			ArrayList<WebElement> elementList=new ArrayList<WebElement>();
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
		
		//Track Your Order
		lsService="Track Your Order";
		reporter.reportLog(lsService);
		selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		lsHref=basePage.getElementHref(selectedItem);		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblTrackYourOrder)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {
			getGlobalFooterPageThreadLocal().displayAlertMessageForOrderNumberAndSignInInput();;
			ArrayList<WebElement> elementList=new ArrayList<WebElement>();
			elementList.add(getGlobalFooterPageThreadLocal().lblTrackYourOrder);
			elementList.add(getGlobalFooterPageThreadLocal().lblRequiredFieldsInfo);
			elementList.add(getGlobalFooterPageThreadLocal().lblOrderNumberTitle);
			elementList.add(getGlobalFooterPageThreadLocal().lblOrderNumberLable);
			elementList.add(getGlobalFooterPageThreadLocal().inputOrderNumber);
			elementList.add(getGlobalFooterPageThreadLocal().lblOrderNumberAlertMsg);
			elementList.add(getGlobalFooterPageThreadLocal().lblBillingPostalCodeLabel);
			elementList.add(getGlobalFooterPageThreadLocal().inputBillingPostalCode);
			elementList.add(getGlobalFooterPageThreadLocal().lblBillingPostalCodeAlertMsg);
			elementList.add(getGlobalFooterPageThreadLocal().btnTrackYourOrderSubmit);
			elementList.add(getGlobalFooterPageThreadLocal().lblTrackYourOrderSignUpTitle);
			elementList.add(getGlobalFooterPageThreadLocal().lblGetAllDetailsInfo);
			elementList.add(getGlobalFooterPageThreadLocal().lblEmailAddressLable);
			elementList.add(getGlobalFooterPageThreadLocal().inputEmailAddress);
			elementList.add(getGlobalFooterPageThreadLocal().lblEmailAddressAlertMsg);
			elementList.add(getGlobalFooterPageThreadLocal().lblPasswordLabel);
			elementList.add(getGlobalFooterPageThreadLocal().inputPassword);
			elementList.add(getGlobalFooterPageThreadLocal().lblPasswordAlertMsg);
			elementList.add(getGlobalFooterPageThreadLocal().btnShowOrHidePassword);
			elementList.add(getGlobalFooterPageThreadLocal().btnTrackYourOderSignIn);
			
			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		}
		
		//Contact Us
		lsService="Contact Us";
		reporter.reportLog(lsService);
		selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		lsHref=basePage.getElementHref(selectedItem);		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblContactUS)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {			
			ArrayList<WebElement> elementList=new ArrayList<WebElement>();
			elementList.add(getGlobalFooterPageThreadLocal().lblContactUS);
			elementList.add(getGlobalFooterPageThreadLocal().lblWhatCanWeHelpYouWith);
			elementList.add(getGlobalFooterPageThreadLocal().selectContactUS);
			elementList.add(getGlobalFooterPageThreadLocal().lblPleaseVisitUSInfo);
			elementList.add(getGlobalFooterPageThreadLocal().lnkPleaseVisitUS);
			
			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
			
			getGlobalFooterPageThreadLocal().verifyDropdownOptionContent();
		}
		
		//Blog
		lsService="Blog";
		reporter.reportLog(lsService);
		selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		lsHref=basePage.getElementHref(selectedItem);		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}
		reporter.softAssert(getGlobalFooterPageThreadLocal().compareUrlInNewWindow(lsService, lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		
		//My Account 
		lsService="My Account";
		reporter.reportLog("Not login for "+lsService);
		selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		lsHref=basePage.getElementHref(selectedItem);		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblMyAccount)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {
			getGlobalFooterPageThreadLocal().expandPanelItems(getGlobalFooterPageThreadLocal().lstMyAccountItemTitle,getGlobalFooterPageThreadLocal().lstMyAccountItemContent);
			ArrayList<WebElement> elementList=new ArrayList<WebElement>();
			elementList.add(getGlobalFooterPageThreadLocal().lblMyAccount);
			for(WebElement item:getGlobalFooterPageThreadLocal().lstMyAccountItemTitle) {
				elementList.add(item);
			}
			for(WebElement item:getGlobalFooterPageThreadLocal().lstMyAccountItemContent) {
				elementList.add(item);
			}
			
			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		}
		
		reporter.reportLog("Login for "+lsService);
		String lsUserName=TestDataHandler.constantDataVariables.getlbl_Username();
		String lsPassword=TestDataHandler.constantDataVariables.getlbl_Password();
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
		
		selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		lsHref=basePage.getElementHref(selectedItem);		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblMyAccount)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {
			getGlobalFooterPageThreadLocal().expandPanelItems(getGlobalFooterPageThreadLocal().lstMyAccountItemTitle,getGlobalFooterPageThreadLocal().lstMyAccountItemContent);
			ArrayList<WebElement> elementList=new ArrayList<WebElement>();
			elementList.add(getGlobalFooterPageThreadLocal().lblMyAccount);
			for(WebElement item:getGlobalFooterPageThreadLocal().lstMyAccountItemTitle) {
				elementList.add(item);
			}
			for(WebElement item:getGlobalFooterPageThreadLocal().lstMyAccountItemContent) {
				elementList.add(item);
			}
			
			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		}
	}

}
