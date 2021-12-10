package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
		
		List<List<String>> lstNameAndLinks=TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
		String lsService,lsHref,lsYmlHref;
		ArrayList<WebElement> elementList=new ArrayList<WebElement>();

		//Customer service
		lsService="Customer Service";
		reporter.reportLog(lsService);
		WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		lsHref=basePage.getElementHref(selectedItem);		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblCustomerService)) {
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
		reporter.reportLog(lsService);
		List<String> lstTrackYourOrderObjectSectionTitle=TestDataHandler.constantData.getFooterSection().getLst_TrackYourOrderObjectSectionTitle();
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
			elementList.add(getGlobalFooterPageThreadLocal().lblContactUS);
			elementList.add(getGlobalFooterPageThreadLocal().lblWhatCanWeHelpYouWith);
			elementList.add(getGlobalFooterPageThreadLocal().selectContactUS);
			elementList.add(getGlobalFooterPageThreadLocal().lblPleaseVisitUSInfo);
			elementList.add(getGlobalFooterPageThreadLocal().lnkPleaseVisitUS);
			
			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
			
			getGlobalFooterPageThreadLocal().verifyDropdownOptionContent();
		}
		elementList.clear();

		//Channel Finder
		String lsServiceCF = "Channel Finder";
		reporter.reportLog(lsServiceCF);
		WebElement selectedItemCF=getGlobalFooterPageThreadLocal().getServiceWebElement(lsServiceCF);
		String lsHrefCF=basePage.getElementHref(selectedItemCF);
		HashMap<String,String> testDataCF=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsServiceCF,true);
		if(testDataCF.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsServiceCF+"' link.");
		}
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHrefCF,testDataCF.get("Link")),"The current '"+lsServiceCF+"' href of "+lsHrefCF+" is equal to "+testDataCF.get("Link"),"The current '"+lsServiceCF+"' href of "+lsHrefCF+" is not equal to "+testDataCF.get("Link"));

		if(!getGlobalFooterPageThreadLocal().goToService(lsServiceCF,getGlobalFooterPageThreadLocal().lblChannelFinderTitle)) {
			reporter.reportLogFail("Unable to navigate to '"+lsServiceCF+"' page objects.");
		}
		else {
			//Verifying page title
			String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().lblChannelFinderTitle);
			reporter.softAssert(pageTitle.equalsIgnoreCase(lsServiceCF),"Page Title matches for global footer link: "+lsServiceCF+" and  title is: "+pageTitle,"Page Title doesn't match for global footer link: "+lsServiceCF+" and  title is: "+pageTitle);

			//Verifying Page Elements
			//Find Cable Channels
			//reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().useourchannelfinder),"Page paragraph line exists","Page paragraph line doesn't exists");
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblFindCableChannelTitle),"The Title Find Cable Channel is displayed","The Title Find Cable Channel is not displayed");
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblselectyour),"The text Select your: exists","The text Select your: doesn't exists");
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblProvince),"The Title Province exists","The Title Province doesn't exists");
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblCableProvider),"The Title Cable Provider exists","The Title Cable Provider doesn't exists");
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblCity),"The Title City exists","The Title City doesn't exists");

			//Satellite Channels
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblSatelliteChannels),"The Title Satellite Channels exist","The Title Satellite Channels doesn't exist");
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblBellTV),"The Title Satellite Channels exist","Page paragraph line doesn't exists");
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblShawDirect),"Page paragraph line exists ","Page paragraph line doesn't exists");
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblChannelsBellTV),"The line under Bell TV Column exists","The line under Bell TV Column doesn't exists");
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblChannelsShawDirect),"The line under Shaw Direct Column exists","The line under Shaw Direct Column exists");

			//Verifying Province Drop Down and its respective Cable Provider and City
			getGlobalFooterPageThreadLocal().verifyMultipleDropDownWithTitle(getGlobalFooterPageThreadLocal().dropDownProvince, getGlobalFooterPageThreadLocal().dropDownCableProvider, getGlobalFooterPageThreadLocal().dropDownCity);
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
		verifyMyAccountNotLoginContents(lsService, lstNameAndLinks); 
		
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
	
	void verifyMyAccountNotLoginContents(String lsService, List<List<String>> lstNameAndLinks) {
		BasePage basePage=new BasePage(this.getDriver());	
		ArrayList<WebElement> elementList=new ArrayList<WebElement>();

		List<String> lstMyAccountObjectSectionTitle=TestDataHandler.constantData.getFooterSection().getLst_MyAccountObjectSectionTitle();
		WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);		
		String lsHref=basePage.getElementHref(selectedItem);		
		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find '"+lsService+"' link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref,"The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
				
		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblMyAccount)) {
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
