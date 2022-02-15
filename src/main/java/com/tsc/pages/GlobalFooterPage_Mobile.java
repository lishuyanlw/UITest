package com.tsc.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlobalFooterPage_Mobile extends GlobalFooterPage{

	public GlobalFooterPage_Mobile(WebDriver driver) {
		super(driver);		
	}
	
	// TSC Customer Hub
	@FindBy(xpath = "//div[@id='headingOne']//a")
	public WebElement lblTSCCustomerHubText;
	
	@FindBy(xpath = "//div[@id='headingOne']/parent::div//ul/li//a")
	public List<WebElement> lnkTSCCustomerHubAllLinks;
	
	// About TSC
	@FindBy(xpath = "//div[@id='headingTwo']//a")
	public WebElement lblAboutTSCText;
	
	@FindBy(xpath = "//div[@id='headingTwo']/parent::div//ul/li//a")
	public List<WebElement> lnkAboutTSCAllLinks;
	
	@FindBy(xpath = "//ng-component//div[contains(@class,'summary-logout')]//button")
	public WebElement btnMyAccountSignOut;

	//Browse Help Topics in Customer service
	@FindBy(xpath="//div[@id='customer-service']//div[@class='customer-service-faq']//ul[@class='customer-service-faq__topics-accordion']/li")
	List<WebElement> lstCustomerServiceHelpTopics;

	@FindBy(xpath="//div[@id='customer-service']//div[@class='customer-service-faq']//ul[@class='customer-service-faq__topics-accordion']/li//*[@class='customer-service-faq__topics-accordion__item-title__lhs__text']")
	List<WebElement> lstCustomerServiceHelpTopicsTitle;

	@FindBy(xpath="//div[@id='customer-service']//div[@class='customer-service-faq']//ul[@class='customer-service-faq__topics-accordion']/li//ul/li")
	List<WebElement> lstCustomerServiceHelpTopicsSubItem;

	@FindBy(xpath="//div[@id='customer-service']//div[@class='customer-service-faq']//ul[@class='customer-service-faq__topics-accordion']/li//div[@class='customer-service-faq__topics-accordion__item-title__lhs__icon']")
	List<WebElement> lstCustomerServiceHelpTopicsIcon;

	//For contact us in Help Topics
	@FindBy(xpath="//div[@id='customer-service']//div[@class='customer-service-faq']//ul[@class='customer-service-faq__topics-accordion']/li//a[contains(@href,'contact-info')]/ancestor::li[@class='customer-service-faq__topics-accordion__item']")
	WebElement lnkCustomerServiceContactTSC;

	@FindBy(xpath="//div[@id='customer-service']//div[@class='customer-service-faq']//ul[@class='customer-service-faq__topics-accordion']/li//a[contains(@href,'contact-info')]")
	WebElement lnkCustomerServiceContactInfo;

	@FindBy(xpath="//div[@id='customer-service']//div[@class='customer-service-faq']//ul[@class='customer-service-faq__topics-accordion']/li//a[contains(@href,'email')]")
	WebElement lnkCustomerServiceGeneralEmailInquiries;

	@FindBy(xpath="//div[@id='customer-service']//div[@class='customer-service-faq']//ul[@class='customer-service-faq__topics-accordion']/li//a[contains(@href,'billing')]")
	WebElement lnkCustomerServiceBillingOrRefundInquiries;

	@FindBy(xpath="//div[@id='customer-service']//div[@class='customer-service-faq']//ul[@class='customer-service-faq__topics-accordion']/li//a[contains(@href,'feedback')]")
	WebElement lnkCustomerServiceSendFeedback;

	//For the right panel of window after clicking Help Topics subitem
	@FindBy(xpath="//div[@id='customer-service']//div[@class='customer-service-faq']//button[@class='customer-service-faq__article__body__nav']")
	WebElement btnCustomerServiceBackToHelpCenter;

	@Override
	public void verifyTSCCustomerHubLlinks(List<List<String>> lstNameAndLinks) {		
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblTSCCustomerHubText);
		this.getReusableActionsInstance().clickIfAvailable(this.lblTSCCustomerHubText);
		//this.lblTSCCustomerHubText.click();
		this.waitForCondition(Driver->{return this.lblTSCCustomerHubText.getAttribute("class").isEmpty();}, 30000);
		getReusableActionsInstance().staticWait(5000);
				
		String lsText,lsYmlHref,lsHref;
		for(WebElement item:this.lnkTSCCustomerHubAllLinks) {
			lsText=this.getElementText(item);			
			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,true);			
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFailWithScreenshot("Unable to find "+lsText+" link.");
			}
			lsHref=this.getElementHref(item);
			if(this.verifyLinks(lsHref,lsYmlHref)){
				reporter.reportLogPass("The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref);
			}
			else{
				reporter.reportLogFailWithScreenshot("The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
			}

		}
	}
	
	@Override
	public void verifyAboutTSCLinks(List<List<String>> lstNameAndLinks) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAboutTSCText);
		this.getReusableActionsInstance().clickIfAvailable(this.lblAboutTSCText);
		//this.lblAboutTSCText.click();
		this.waitForCondition(Driver->{return this.lblAboutTSCText.getAttribute("class").isEmpty();}, 30000);
		getReusableActionsInstance().staticWait(5000);
		
		String lsText,lsYmlHref,lsHref;
		for(WebElement item:this.lnkAboutTSCAllLinks) {
			lsText=this.getElementText(item);
			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,true);
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFailWithScreenshot("Unable to find "+lsText+" link.");
			}
			lsHref=this.getElementHref(item);
			if(this.verifyLinks(lsHref,lsYmlHref)){
				reporter.reportLogPass("The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref);
			}
			else{
				reporter.reportLogFailWithScreenshot("The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
			}
		}
	}
	
	@Override
	public WebElement getServiceWebElement(String lsService,String footerSection) {
		if(!this.lblTSCCustomerHubText.getAttribute("class").isEmpty()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblTSCCustomerHubText);
			this.getReusableActionsInstance().clickIfAvailable(this.lblTSCCustomerHubText);
			//this.lblTSCCustomerHubText.click();
			this.waitForCondition(Driver->{return this.lblTSCCustomerHubText.getAttribute("class").isEmpty();}, 30000);
			getReusableActionsInstance().staticWait(5000);
		}
			
		WebElement selectedItem = this.getElementFromList(this.lnkTSCCustomerHubAllLinks, lsService);
		if (selectedItem == null) {
			if(!this.lblAboutTSCText.getAttribute("class").isEmpty()) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAboutTSCText);
				this.getReusableActionsInstance().clickIfAvailable(this.lblAboutTSCText);
				//this.lblAboutTSCText.click();
				this.waitForCondition(Driver->{return this.lblAboutTSCText.getAttribute("class").isEmpty();}, 30000);				
			}
			
			selectedItem = this.getElementFromList(this.lnkAboutTSCAllLinks, lsService);
		}
		return selectedItem;
	}
	
	@Override
	public void verifyMyAccountServicePanelItem() {
		for(WebElement item: this.lstMyAccountSerivePanelHeading) {
			if(item.getAttribute("class").contains("collapsed")) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				getReusableActionsInstance().clickIfAvailable(item);
				//item.click();
				this.waitForCondition(Driver->{return !item.getAttribute("class").contains("collapsed");}, 30000);
				getReusableActionsInstance().staticWait(5000);
			}
		}
			
		ArrayList<WebElement> elementList=new ArrayList<WebElement>();
		for(WebElement item:this.lstMyAccountSerivePanelItem) {
			elementList.add(item);
		}
		elementList.add(this.btnMyAccountSignOut);
		
		this.verifyElementListExistence(elementList);
	}
	
	@Override
	public void verifyRogersLogo() {
		
	}
	
	@Override
	public List<String> getCustomerHubSubItemFr(List<List<String>> lstNameAndLinks){
		String lsText=this.getUTFEnabledData(this.getElementText(this.lblTSCCustomerHubText));
		
		if(!this.lblTSCCustomerHubText.getAttribute("class").isEmpty()) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblTSCCustomerHubText);
			getReusableActionsInstance().clickIfAvailable(this.lblTSCCustomerHubText);
			//this.lblTSCCustomerHubText.click();
			this.waitForCondition(Driver->{return this.lblTSCCustomerHubText.getAttribute("class").isEmpty();}, 30000);
			getReusableActionsInstance().staticWait(5000);
		}
		
		List<String> lstFr=new ArrayList<String>();
		String lsFr;
		for(WebElement item:this.lnkTSCCustomerHubAllLinks) {
			lsText=this.getElementText(item);	
			lsFr=this.getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
			lstFr.add(lsFr);
		}
		
		return lstFr;
	}
	
	@Override
	public List<String> getAboutTSCSubItemFr(List<List<String>> lstNameAndLinks){
		String lsText=this.getUTFEnabledData(this.getElementText(this.lblAboutTSCText));
		
		if(!this.lblAboutTSCText.getAttribute("class").isEmpty()) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAboutTSCText);
			getReusableActionsInstance().clickIfAvailable(this.lblAboutTSCText);
			//this.lblAboutTSCText.click();
			this.waitForCondition(Driver->{return this.lblAboutTSCText.getAttribute("class").isEmpty();}, 30000);
			getReusableActionsInstance().staticWait(5000);
		}
		
		List<String> lstFr=new ArrayList<String>();
		String lsFr;
		for(WebElement item:this.lnkAboutTSCAllLinks) {
			lsText=this.getElementText(item);	
			lsFr=this.getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
			lstFr.add(lsFr);
		}
		
		return lstFr;
	}
	
	@Override
	public void verifyCustomerHubSubItemFr(List<List<String>> lstNameAndLinks, List<String> lstCustomerHubFr) {
		String lsText,lsYmlHref,lsHref;
		
		if(!this.lblTSCCustomerHubText.getAttribute("class").isEmpty()) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblTSCCustomerHubText);
			getReusableActionsInstance().clickIfAvailable(this.lblTSCCustomerHubText);
			//this.lblTSCCustomerHubText.click();
			this.waitForCondition(Driver->{return this.lblTSCCustomerHubText.getAttribute("class").isEmpty();}, 30000);
			getReusableActionsInstance().staticWait(5000);
		}
		
		for(int i=0;i<this.lnkTSCCustomerHubAllLinks.size();i++) {
			lsText=this.getUTFEnabledData(this.getElementText(this.lnkTSCCustomerHubAllLinks.get(i)));	
			if(lsText.equalsIgnoreCase(lstCustomerHubFr.get(i))){
				reporter.reportLogPass("The "+i+" CustomerHubLink French transaltion of "+lsText+" is the same as "+lstCustomerHubFr.get(i));
			}
			else{
				reporter.reportLogFailWithScreenshot("The "+i+" CustomerHubLink French transaltion of "+lsText+" is not the same as "+lstCustomerHubFr.get(i));
			}

			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,false);			
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFailWithScreenshot("Unable to find "+lsText+" link.");
			}
			lsHref=this.getElementHref(this.lnkTSCCustomerHubAllLinks.get(i));
			if(this.verifyLinks(lsHref,lsYmlHref)){
				reporter.reportLogPass("The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref);
			}
			else{
				reporter.reportLogFailWithScreenshot("The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
			}
		}
	}
	
	@Override
	public void verifyAboutTSCSubItemFr(List<List<String>> lstNameAndLinks, List<String> lstAboutTSCFr) {
		String lsText,lsYmlHref,lsHref;
		
		if(!this.lblAboutTSCText.getAttribute("class").isEmpty()) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAboutTSCText);
			getReusableActionsInstance().clickIfAvailable(this.lblAboutTSCText);
			//this.lblAboutTSCText.click();
			this.waitForCondition(Driver->{return this.lblAboutTSCText.getAttribute("class").isEmpty();}, 30000);
			getReusableActionsInstance().staticWait(5000);
		}
		
		for(int i=0;i<this.lnkAboutTSCAllLinks.size();i++) {
			lsText=this.getUTFEnabledData(this.getElementText(this.lnkAboutTSCAllLinks.get(i)));
			if(lsText.equalsIgnoreCase(lstAboutTSCFr.get(i))){
				reporter.reportLogPass("The "+i+" AboutTSLink French transaltion of "+lsText+" is the same as "+lstAboutTSCFr.get(i));
			}
			else{
				reporter.reportLogFailWithScreenshot("The "+i+" AboutTSLink French transaltion of "+lsText+" is not the same as "+lstAboutTSCFr.get(i));
			}

			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,false);
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFailWithScreenshot("Unable to find "+lsText+" link.");
			}
			lsHref=this.getElementHref(this.lnkAboutTSCAllLinks.get(i));
			if(this.verifyLinks(lsHref,lsYmlHref)){
				reporter.reportLogPass("The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref);
			}
			else{
				reporter.reportLogFailWithScreenshot("The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
			}
		}
	}
	
	@Override
	public void verifyFaceBookLink(List<String> lstSocialMediaLinks) {
		String lsCurrentUrl = waitForPageLoadingByUrlChange(this.lnkFacebook);
		if(lsCurrentUrl.toLowerCase().contains("facebook")){
			reporter.reportLogPass("The Url after clicking Facebook link contains facebook");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Url after clicking Facebook link does not contain facebook");
		}

		String lsBaseUrl=this.getBaseURL()+"/";		
		this.navigateToURL(lsBaseUrl);
		this.waitForPageLoading();
	}

	@Override
	public void verifyBrowseByHelpTopicsInCustomerServicePageObject() {
		String lsText;
		getReusableActionsInstance().javascriptScrollByVisibleElement(lblBrowseByHelpTopics);
		lsText=lblBrowseByHelpTopics.getText();
		lsText=this.getShortenText(lsText,100);
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is displaying correctly.");
		}

		WebElement element,item;
		List<WebElement> itemList;
		int loopSize=lstCustomerServiceHelpTopics.size();
		for(int i=0;i<loopSize;i++) {
			item = lstCustomerServiceHelpTopics.get(i);
			getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			element = lstCustomerServiceHelpTopicsTitle.get(i);
			lsText = element.getText();
			lsText = this.getShortenText(lsText, 100);
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The element of '" + lsText + "'" + " in Help topics list is displaying correctly.");
			} else {
				reporter.reportLogFailWithScreenshot("The element of '" + lsText + "'" + " in Help topics list is displaying correctly.");
			}

			element = lstCustomerServiceHelpTopicsIcon.get(i);
			if (getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("The icon of Help Topics item is displaying correctly.");
			} else {
				reporter.reportLogFailWithScreenshot("The icon of Help Topics item is not displaying correctly.");
			}

			getReusableActionsInstance().clickIfAvailable(item);
			getReusableActionsInstance().staticWait(2000);
			for (WebElement subItem : lstCustomerServiceHelpTopicsSubItem) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				lsText = subItem.getText();
				lsText = this.getShortenText(lsText, 100);
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The element of '" + lsText + "'" + " in Help topics list is displaying correctly.");
				} else {
					reporter.reportLogFailWithScreenshot("The element of '" + lsText + "'" + " in Help topics list is displaying correctly.");
				}
			}
		}
	}

	@Override
	public void verifyStillNeedHelpInCustomerServicePageObject(){

	}

	@Override
	public void verifyLiveChatPopupWindowInCustomerServicePageObject(WebElement btnLiveChat){

	}

	@Override
	public void verifyLeftAsidePenalAfterClickingBrowseByHelpTopicsSubItemInCustomerServicePageObject(){

	}

	@Override
	public void verifyClickingActionForInquiriesOrFeedback(String lsType) {
		if(!this.bClickingInquiriesOrFeedback){
			this.bClickingInquiriesOrFeedback=true;
		}
		else{
			WebElement item=lstCustomerServiceHelpTopics.get(lstCustomerServiceHelpTopics.size()-1);
			getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			getReusableActionsInstance().clickIfAvailable(item);
			getReusableActionsInstance().staticWait(2000);

			getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCustomerServiceContactInfo);
			getReusableActionsInstance().clickIfAvailable(lnkCustomerServiceContactInfo);
			getReusableActionsInstance().waitForElementVisibility(lblCustomerServiceContactUsTitle);
		}

		switch(lsType){
			case "Email":
				getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCustomerServiceContactUsGeneralEmailInquiries);
				getReusableActionsInstance().clickIfAvailable(lnkCustomerServiceContactUsGeneralEmailInquiries);
				break;
			case "Billing":
				getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCustomerServiceContactUsBillingOrRefundEmailInquiries);
				getReusableActionsInstance().clickIfAvailable(lnkCustomerServiceContactUsBillingOrRefundEmailInquiries);
				break;
			case "Feedback":
				getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCustomerServiceContactUsFeedback);
				getReusableActionsInstance().clickIfAvailable(lnkCustomerServiceContactUsFeedback);
				break;
			default:
				break;
		}
		getReusableActionsInstance().waitForElementVisibility(lblCustomerServiceGeneralEmailInquiriesTitle);

		verifyInquiriesOrFeedbackContent(lsType);

		getReusableActionsInstance().javascriptScrollByVisibleElement(btnCustomerServiceBackToHelpCenter);
		getReusableActionsInstance().clickIfAvailable(btnCustomerServiceBackToHelpCenter);
		getReusableActionsInstance().waitForElementVisibility(lblCustomerServiceWhatCanWeHelpYouWith);
	}


}
