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
	
	@FindBy(xpath = "//div[@id='headingOne']/parent::div//ul//li//a")
	public List<WebElement> lnkTSCCustomerHubAllLinks;
	
	// About TSC
	@FindBy(xpath = "//div[@id='headingTwo']//a")
	public WebElement lblAboutTSCText;
	
	@FindBy(xpath = "//div[@id='headingTwo']/parent::div//ul//li//a")
	public List<WebElement> lnkAboutTSCAllLinks;
	
	@FindBy(xpath = "//ng-component//div[contains(@class,'summary-logout')]//button")
	public WebElement btnMyAccountSignOut;
	
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
				reporter.reportLogFail("Unable to find "+lsText+" link.");
			}
			lsHref=this.getElementHref(item);	
			reporter.softAssert(this.verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
			
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
				reporter.reportLogFail("Unable to find "+lsText+" link.");
			}
			lsHref=this.getElementHref(item);
			reporter.softAssert(this.verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);			
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
	public void verifyMyAccountSerivePanelItem() {
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
			reporter.softAssert(lsText.equalsIgnoreCase(lstCustomerHubFr.get(i)),"The "+i+" CustomerHubLink French transaltion of "+lsText+" is the same as "+lstCustomerHubFr.get(i),"The "+i+" CustomerHubLink French transaltion of "+lsText+" is not the same as "+lstCustomerHubFr.get(i));
			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,false);			
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFail("Unable to find "+lsText+" link.");
			}
			lsHref=this.getElementHref(this.lnkTSCCustomerHubAllLinks.get(i));	
			reporter.softAssert(this.verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
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
			reporter.softAssert(lsText.equalsIgnoreCase(lstAboutTSCFr.get(i)),"The "+i+" AboutTSLink French transaltion of "+lsText+" is the same as "+lstAboutTSCFr.get(i),"The "+i+" AboutTSLink French transaltion of "+lsText+" is not the same as "+lstAboutTSCFr.get(i));
			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,false);
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFail("Unable to find "+lsText+" link.");
			}
			lsHref=this.getElementHref(this.lnkAboutTSCAllLinks.get(i));
			reporter.softAssert(this.verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
		}
	}
	
	@Override
	public void verifyFaceBookLink(List<String> lstSocialMediaLinks) {
		String lsCurrentUrl = waitForPageLoadingByUrlChange(this.lnkFacebook);		
		reporter.softAssert(lsCurrentUrl.toLowerCase().contains("facebook"),"The Url after clicking Facebook link contains facebook","The Url after clicking Facebook link does not contain facebook");
		
		String lsBaseUrl=this.getBaseURL()+"/";		
		this.navigateToURL(lsBaseUrl);
		this.waitForPageLoading();
	}

}
