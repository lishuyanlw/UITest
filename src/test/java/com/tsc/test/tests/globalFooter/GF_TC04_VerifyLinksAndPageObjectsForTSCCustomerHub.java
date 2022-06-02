package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;

public class GF_TC04_VerifyLinksAndPageObjectsForTSCCustomerHub extends BaseTest {
	/*
	 * CER-171
	 * CER-172
	 * CER-174
	 * CER-175
	 * CER-178
	 * CER-181
	 * CER-182	 
	 */
	@Test(groups={"Regression","GlobalFooter"})
	public void GF_TC04_VerifyLinksAndPageObjectsForTSCCustomerHub() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";

		if(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl)){
			reporter.reportLogPass("TSC url is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("TSC url is incorrect");
		}

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
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		}

		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblCustomerServiceWhatCanWeHelpYouWith,hashMap.get("parent"))) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {
			reporter.reportLog("verifySearchBoxAndTopCustomerQuestionsInCustomerServicePageObject");
			getGlobalFooterPageThreadLocal().verifySearchBoxAndTopCustomerQuestionsInCustomerServicePageObject();

			reporter.reportLog("verifyBrowseByHelpTopicsInCustomerServicePageObject");
			getGlobalFooterPageThreadLocal().verifyBrowseByHelpTopicsInCustomerServicePageObject();

			reporter.reportLog("verifyWindowAfterClickingBrowseByHelpTopicsSubItemInCustomerServicePageObject");
			getGlobalFooterPageThreadLocal().verifyWindowAfterClickingBrowseByHelpTopicsSubItemInCustomerServicePageObject();

			reporter.reportLog("verifyStillNeedHelpInCustomerServicePageObject");
			getGlobalFooterPageThreadLocal().verifyStillNeedHelpInCustomerServicePageObject();

			reporter.reportLog("verifyLiveChatPopupWindowInCustomerServicePageObject");
			getGlobalFooterPageThreadLocal().verifyLiveChatPopupWindowInCustomerServicePageObject(getGlobalFooterPageThreadLocal().btnCustomerLiveChat);
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
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		}

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
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		}

		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblCustomerServiceContactUsTitle,hashMap.get("parent"))) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {
			getGlobalFooterPageThreadLocal().verifyLeftAsidePenalAfterClickingBrowseByHelpTopicsSubItemInCustomerServicePageObject();

			getGlobalFooterPageThreadLocal().verifyContactUsRightPanelContent();

			getGlobalFooterPageThreadLocal().verifyLiveChatPopupWindowInCustomerServicePageObject(getGlobalFooterPageThreadLocal().btnCustomerServiceContactUsLiveChat);

			getGlobalFooterPageThreadLocal().verifyClickingActionForInquiriesOrFeedback("Email");

			getGlobalFooterPageThreadLocal().verifyClickingActionForInquiriesOrFeedback("Billing");

			getGlobalFooterPageThreadLocal().verifyClickingActionForInquiriesOrFeedback("Feedback");
		}

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
		if(getGlobalFooterPageThreadLocal().compareUrlInNewWindow(lsService, lsYmlHref,hashMap.get("parent"))){
			reporter.reportLogPass("The Blog page is being navigated correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Blog page is not being navigated correctly");
		}

		//My Account
		lsService="My Account";
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
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		}

		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblCustomerServiceSubItemWindowContentTitle,hashMap.get("parent"))) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {
			getGlobalFooterPageThreadLocal().verifyLeftAsidePenalAfterClickingBrowseByHelpTopicsSubItemInCustomerServicePageObject();

			elementList.add(getGlobalFooterPageThreadLocal().lblCustomerServiceSubItemWindowContentTitle);
			elementList.add(getGlobalFooterPageThreadLocal().lblCustomerServiceSubItemWindowContentBody);
			getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
		}
		elementList.clear();
		/*
		hashMap = getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
		reporter.reportLog("Not login for "+lsService);


		verifyMyAccountNotLoginContents(lsService, lstNameAndLinks,hashMap.get("parent"));
		
		reporter.reportLog("Login for "+lsService);
		String lsUserName=TestDataHandler.constantData.getLoginUser().getLbl_Username();
		String lsPassword=TestDataHandler.constantData.getLoginUser().getLbl_Password();
		String lsFirstName=TestDataHandler.constantData.getLoginUser().getLbl_FirstName();
		if(getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword,lsFirstName)) {			
//			verifyMyAccountLoginContents(lsService, lstNameAndLinks);
			hashMap = getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
			verifyMyAccountNotLoginContents(lsService, lstNameAndLinks,hashMap.get("parent"));
		}
		else {
			reporter.reportLogFail("Login failed");
		}
	*/
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
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current '"+lsService+"' href of "+lsHref+" is equal to "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current '"+lsService+"' href of "+lsHref+" is not equal to "+lsYmlHref);
		}

		if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().lblMyAccount,section)) {
			reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
		}
		else {
			if(getGlobalFooterPageThreadLocal().verifyLinks(basePage.URL(),lsYmlHref)){
				reporter.reportLogPass("The current Url of "+basePage.URL()+" for '"+lsService+" is equal to "+lsYmlHref);
			}
			else{
				reporter.reportLogFailWithScreenshot("The current Url of "+basePage.URL()+" for '"+lsService+" is not equal to "+lsYmlHref);
			}

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
		getGlobalFooterPageThreadLocal().verifyMyAccountServicePanelItem();


	}

}
