package com.tsc.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.tsc.pages.base.BasePage;

public class GlobalFooterPage extends BasePage {
	
	public GlobalFooterPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Page loading indicator
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'blockPageWrap')]")
	WebElement pageLoadingIndicator;
	
	//Credit Card
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'creditcard')]/parent::div")
	public WebElement blkCreditCard;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'creditcard')]/img")
	public WebElement imgCreditCard;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'creditcard')]/span")
	public WebElement lblCreditCardText;
	
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'creditcard')]")
	public WebElement lnkCreditCard;
	
	//Gift Card
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'giftcard')]/parent::div")
	public WebElement blkGiftCard;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'giftcard')]/img")
	public WebElement imgGiftCard;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'giftcard')]/span")
	public WebElement lblGiftCardText;
	
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'giftcard')]")
	public WebElement lnkGiftCard;
	
	//Send us feedback
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'survey')]/parent::div")
	public WebElement blkSendUsFeedback;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'survey')]/img")
	public WebElement imgSendUsFeedback;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'survey')]/span")
	public WebElement lblSendUsFeedbackHeadingText;
	
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'survey')]")
	public WebElement lnkSendUsFeedback;
	
	//Language switch
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'switchLanguage')]")
	public WebElement lnkLanguage;
			
	//Facebook
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'facebook')]/parent::div")
	public WebElement blkFacebook;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'facebook')]/img")
	public WebElement imgFacebook;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'facebook')]")
	public WebElement lnkFacebook;
	
	//Twitter
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'twitter')]/parent::div")
	public WebElement blkTwitter;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'twitter')]/img")
	public WebElement imgTwitter;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'twitter')]")
	public WebElement lnkTwitter;
	
	//Instagram
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'instagram')]/parent::div")
	public WebElement blkInstagram;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'instagram')]/img")
	public WebElement imgInstagram;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'instagram')]")
	public WebElement lnkInstagram;
	
	//Youtube
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'youtube')]/parent::div")
	public WebElement blkYoutube;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'youtube')]/img")
	public WebElement imgYoutube;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'youtube')]")
	public WebElement lnkYoutube;
	
	//Pinterest
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'pinterest')]/parent::div")
	public WebElement blkPinterest;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'pinterest')]/img")
	public WebElement imgPinterest;
		
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'pinterest')]")
	public WebElement lnkPinterest;
	
	//TSC Customer Hub
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[1]/strong")
	public WebElement lblTSCCustomerHubText;
	
	@FindAll({@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[1]//ul[@class='lstMenu']/li//a"),
        @FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[2]//ul[@class='lstMenu-with-icon']/li//a")})
	public List<WebElement> lnkTSCCustomerHubAllLinks;

	//About TSC
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[3]/strong")
	public WebElement lblAboutTSCText;

	@FindAll({@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[3]//ul[@class='lstMenu']/li//a"),
			@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[4]//ul[@class='lstMenu']/li//a")})
	public List<WebElement> lnkAboutTSCAllLinks;

	//Rogers Logo
	@FindBy(xpath = "//div[@class='Footer']//img[contains(@src,'Rogers.png')]")
	public WebElement imgRogersLogo;
	
	//Copyright Section
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'copyright-msg')]/ancestor::div[contains(@class,'ftr-cell')]")
	public WebElement blkCopyright;
	
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'copyright-msg')][1]")
	public WebElement txtCopyrightLine1;
	
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'copyright-msg')][2]")
	public WebElement txtCopyrightLine2;
	
	//Customer service page objects
	@FindBy(xpath = "//div[@class='CustomerService']//*[contains(@class,'customer-service__title')]")
	public WebElement lblCustomerService;
	
	@FindBy(xpath = "//div[@class='CustomerService']//*[contains(@class,'customer-service__title')]/following-sibling::h2")
	public WebElement lblHowCanWeHelpYou;
	
	@FindBy(xpath = "//div[@class='CustomerService']//*[contains(@class,'customer-service__searchbox')]//input")
	public WebElement inputSearchBox;
	
	@FindBy(xpath = "//div[@class='CustomerService']//*[contains(@class,'customer-service__searchbox')]//button[contains(@class,'customer-service__search-button')]")
	public WebElement btnSearchButton;
	
	@FindBy(xpath = "//div[@class='CustomerService']//div[contains(@class,'customer-service__faq-wrap')]//h3")
	public WebElement lblFrequentlyAskedQuestions;
	
	@FindBy(xpath = "//div[@class='CustomerService']//ul[contains(@class,'customer-service__faq')]//li//a")
	public List<WebElement> lstFrequentlyAskedQuestions;
	
	@FindBy(xpath = "//div[@class='CustomerService']//div[contains(@class,'customerService__faq-wrap')]//a")
	public WebElement lnkBackToCutomerService;
	
	@FindBy(xpath = "//div[@class='CustomerService']//div[contains(@class,'customer-service__article')]")
	public WebElement blkArticle;
	
	//My Account
	@FindBy(xpath = "//*[contains(@class,'titleLink')]")
	public WebElement lblMyAccount;
	
	@FindBy(xpath = "//div[contains(@class,'singleOpenable')]//div[contains(@class,'panTitleContainer')]//a")
	public List<WebElement> lstMyAccountItemTitle;
	
	@FindBy(xpath = "//div[contains(@class,'singleOpenable')]//div[contains(@class,'panHTMLContainer')]")
	public List<WebElement> lstMyAccountItemContent;
	
	//Track Your Order
	@FindBy(xpath = "//div[contains(@class,'trackorder__wrap')]//h1")
	public WebElement lblTrackYourOrder;
	
	@FindBy(xpath = "//div[contains(@class,'trackorder__wrap')]//div[contains(@class,'required-fields')]")
	public WebElement lblRequiredFieldsInfo;
	
	//For Order number
	@FindBy(xpath = "//div[contains(@class,'order-lookup__wrap')]//h2")
	public WebElement lblOrderNumberTitle;
	
	@FindBy(xpath = "//div[contains(@class,'order-lookup__wrap')]//input[@id='OrderNumber']//ancestor::div[@class='form-group']")
	public WebElement cntOrderNumber;
	
	@FindBy(xpath = "//div[contains(@class,'order-lookup__wrap')]//label[@id='OrderNumberlbl']")
	public WebElement lblOrderNumberLable;
	
	@FindBy(xpath = "//div[contains(@class,'order-lookup__wrap')]//input[@id='OrderNumber']")
	public WebElement inputOrderNumber;
	
	@FindBy(xpath = "//div[contains(@class,'order-lookup__wrap')]//input[@id='OrderNumber']/following-sibling::div[contains(@class,'alert')]")
	public WebElement lblOrderNumberAlertMsg;
	
	@FindBy(xpath = "//div[contains(@class,'order-lookup__wrap')]//input[@id='BillingPostal']//ancestor::div[@class='form-group']")
	public WebElement cntBillingPostalCode;
	
	@FindBy(xpath = "//div[contains(@class,'order-lookup__wrap')]//label[@id='BillingPostallbl']")
	public WebElement lblBillingPostalCodeLabel;
	
	@FindBy(xpath = "//div[contains(@class,'order-lookup__wrap')]//input[@id='BillingPostal']")
	public WebElement inputBillingPostalCode;
	
	@FindBy(xpath = "//div[contains(@class,'order-lookup__wrap')]//input[@id='BillingPostal']/following-sibling::div[contains(@class,'alert')]")
	public WebElement lblBillingPostalCodeAlertMsg;
	
	@FindBy(xpath = "//div[contains(@class,'order-lookup__wrap')]//button[@type='submit']")
	public WebElement btnTrackYourOrderSubmit;
	
	//For Sign in
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//h2")
	public WebElement lblTrackYourOrderSignUpTitle;
	
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//form/preceding-sibling::div")
	public WebElement lblGetAllDetailsInfo;
	
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//input[@id='EmailAddress']//ancestor::div[@class='form-group']")
	public WebElement cntEmailAddress;
	
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//label[@id='EmailAddresslbl']")
	public WebElement lblEmailAddressLable;
	
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//input[@id='EmailAddress']")
	public WebElement inputEmailAddress;
	
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//input[@id='EmailAddress']/following-sibling::div[contains(@class,'alert')]")
	public WebElement lblEmailAddressAlertMsg;
	
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//input[@id='Password']//ancestor::div[@class='form-group']")
	public WebElement cntPassword;
	
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//label[@id='Passwordlbl']")
	public WebElement lblPasswordLabel;
	
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//input[@id='Password']")
	public WebElement inputPassword;
	
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//input[@id='Password']/following-sibling::div[contains(@class,'alert')]")
	public WebElement lblPasswordAlertMsg;
	
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//button[contains(@class,'form__button-show-password')]")
	public WebElement btnShowOrHidePassword;
	
	@FindBy(xpath = "//div[contains(@class,'signin__wrap')]//button[@type='submit']")
	public WebElement btnTrackYourOderSignIn;
	
	//Contact Us
	@FindBy(xpath = "//div[@id='contactus']//h1")
	public WebElement lblContactUS;
	
	@FindBy(xpath = "//div[@id='contactus']//h2")
	public WebElement lblWhatCanWeHelpYouWith;
	
	@FindBy(xpath = "//div[@id='contactus']//select")
	public WebElement selectContactUS;
	
	@FindBy(xpath = "//div[@id='contactus']//select/option")
	public List<WebElement> lstContactUSOption;
	
	@FindBy(xpath = "//div[@id='contactus']//div[(contains(@class,'row_below_dropdown') and not(contains(@class,'billing_or_refunds_inquiries'))) or contains(@class,'row_below_form') or @id='formHandle' ]")
	public List<WebElement> lstContactUSOptionText;
	
	@FindBy(xpath = "//div[@id='contactus']//label[contains(@class,'label_please_visit')]")
	public WebElement lblPleaseVisitUSInfo;
	
	@FindBy(xpath = "//div[@id='contactus']//label[contains(@class,'label_please_visit')]/a")
	public WebElement lnkPleaseVisitUS;
	
	//Terms of Use
	@FindBy(xpath = "//div[@class='Middle']//h2")
	public WebElement lblTermsOfUseAboutOurService;
	
	@FindBy(xpath = "//div[@class='Middle']//div[contains(@class,'singleOpenable')]//div[contains(@class,'panTitleContainer')]//a")
	public List<WebElement> lstTermsOfUseItemTitle;
	
	@FindBy(xpath = "//div[@class='Middle']//div[contains(@class,'singleOpenable')]//div[contains(@class,'panHTMLContainer')]")
	public List<WebElement> lstTermsOfUseItemContent;
	

	/**
	 * Close popup dialog through clicking close button.
	 * @author Wei.Li
	 */
	public void closePopupDialog() {		
		if(waitForCondition(Driver->{return (new HomePage(this.getDriver())).btnClose.isDisplayed();},40000)) {
			(new HomePage(this.getDriver())).btnClose.click();
		}
		getReusableActionsInstance().staticWait(500);
	}
	
	/**
	 * This method is to wait for page loading
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean waitForPageLoading() {
		this.waitForPageToLoad();
		return waitForCondition(Driver->{return !this.pageLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},60000);		
	}
	
	/**
	 * This method is to remove protocal headings(http/https)
	 * @param String lsUrl: input Url
	 * @return Url
	 * @author Wei.Li
	 */
	public String removeProtocalHeaderFromUrl(String lsUrl) {
		lsUrl=removeLastSlashFromUrl(lsUrl);
				
		if(!lsUrl.toLowerCase().contains("http")) {			
			return lsUrl;
		}
		
		String[] itemArray=lsUrl.split(":");
		String lsLeft=itemArray[1].substring(2);		
		return lsLeft;
	}
	
	/**
	 * This method is to verify the url after clicking element.
	 * @param WebElement element: input element
	 * @param String lsExpectedUrl: expected Url
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyUrlAfterClickingElement(WebElement element,String lsExpectedUrl) {
		lsExpectedUrl=removeProtocalHeaderFromUrl(lsExpectedUrl);
		String lsCurrentUrl=waitForPageLoadingByUrlChange(element);		
		lsCurrentUrl=removeProtocalHeaderFromUrl(lsCurrentUrl);
		
		return lsCurrentUrl.equalsIgnoreCase(lsExpectedUrl)||lsCurrentUrl.toLowerCase().contains(lsExpectedUrl.toLowerCase());		
	}

	/**
	 * This method is to get expected Url from yml file.
	 * @param List<String> lstSocialMedia: the Url from yml file
	 * @param String lsSpecificMediaName: input media name, i.e., "Facebook","Twitter","Instagram","Youtube","Pinterest"
	 * @return String
	 * @author Wei.Li
	 */
	public String getUrlWithSocialMediaName(List<String> lstSocialMedia, String lsSpecificMediaName) {
		for(String lsItem:lstSocialMedia) {
			if(lsItem.toLowerCase().contains(lsSpecificMediaName.toLowerCase())) {
				return removeProtocalHeaderFromUrl(lsItem);
			}
		}
		return "";
	}
	
	/**
	 * This method is to get the link from yml file.
	 * @param List<String> lstNameAndLink: the list from yml file
	 * @param String lsSpecificName: input name
	 * @param boolean bEnglish: true for English while false for French
	 * @return String: note that the empty string means not found
	 * @author Wei.Li
	 */
	public String getLinkWithSpecificName(List<List<String>> lstNameAndLink, String lsSpecificName,boolean bEnglish) {
		String lsCompare;
		for(List<String> lstItem:lstNameAndLink) {	
			if(bEnglish) {
				lsCompare=this.getUTFEnabledData(lstItem.get(0));
			}else {
				lsCompare=this.getUTFEnabledData(lstItem.get(1));
			}
			if(lsSpecificName.equalsIgnoreCase(lsCompare)) {
				if(lstItem.get(2).startsWith("/")) {
					return this.removeLastSlashFromUrl(this.getBaseURL()+lstItem.get(2).trim());
				}
				else {
					return this.removeLastSlashFromUrl(lstItem.get(2).trim());
				}
				
			}
		}
		
		return "";
	}
	
	/**
	 * This method is to verify if equal to a UTF-8 encoding text.
	 * @param List<String> lstNameAndLink: the list from yml file
	 * @param String lsSpecificName: input text
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyEqualWithEncodingText(List<List<String>> lstNameAndLink, String lsSpecificName) {
		for(List<String> lstItem:lstNameAndLink) {			
			if(lsSpecificName.trim().equalsIgnoreCase(this.getUTFEnabledData(lstItem.get(0)))) {				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * This method is to get the French name from yml file.
	 * @param List<String> lstNameAndLink: the list from yml file
	 * @param String lsSpecificName: input name
	 * @return French name: note that the empty string means not found
	 * @author Wei.Li
	 */
	public String getFrenchWithSpecificEnglishName(List<List<String>> lstNameAndLink, String lsSpecificName) {		
		for(List<String> lstItem:lstNameAndLink) {			
			if(lsSpecificName.equalsIgnoreCase(this.getUTFEnabledData(lstItem.get(0)))) {
				return this.getUTFEnabledData(lstItem.get(1).trim());
			}
		}
		
		return "";
	}
	
	/**
	 * This method is to get the English name from yml file.
	 * @param List<String> lstNameAndLink: the list from yml file
	 * @param String lsSpecificName: input name
	 * @return French name: note that the empty string means not found
	 * @author Wei.Li
	 */
	public String getEnglishWithSpecificFrenchName(List<List<String>> lstNameAndLink, String lsSpecificName) {		
		for(List<String> lstItem:lstNameAndLink) {
			String lsCompare=this.getUTFEnabledData(lstItem.get(1));						
			if(lsSpecificName.equalsIgnoreCase(lsCompare)) {				
				return this.getUTFEnabledData(lstItem.get(0).trim());
			}
		}
		
		return "";
	}
	
	/**
	 * This method is to compare the link in front page and the one in yml file.
	 * @param String lsCurrentLink: the link in front page
	 * @param String lsYmlLink: the link in yml file
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyLinks(String lsCurrentLink, String lsYmlLink) {
		lsCurrentLink=removeLastSlashFromUrl(lsCurrentLink);
		lsYmlLink=removeLastSlashFromUrl(lsYmlLink);
		
		if(lsYmlLink.startsWith("/")) {
			lsYmlLink=this.getBaseURL()+lsYmlLink;
			return lsCurrentLink.equalsIgnoreCase(lsYmlLink);
		}else {
			return lsCurrentLink.toLowerCase().contains(lsYmlLink.toLowerCase());
		}		
	}
		
	/**
	 * This method is to switch language.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean switchlanguage() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkLanguage);
		this.lnkLanguage.click();
		return this.waitForPageLoading();
	}
	
	/**
	 * This method is to get the element for specific service name.
	 * @param String lsService: the service name
	 * @return WebElement
	 * @author Wei.Li
	 */
	public WebElement getServiceWebElement(String lsService) {
		WebElement selectedItem=this.getElementFromList(this.lnkTSCCustomerHubAllLinks, lsService);		
		if(selectedItem==null) {
			selectedItem=this.getElementFromList(this.lnkAboutTSCAllLinks, lsService);
		}
		return selectedItem;
	}
	
	/**
	 * This method is to go to a specific service.
	 * @param String lsService: the service name
	 * @param WebElement lblIndicator: page loading indicator
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean goToService(String lsService,WebElement lblIndicator) {
		WebElement selectedItem=this.getServiceWebElement(lsService);		
		if(selectedItem==null) {
			return false;
		}
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(selectedItem);
		selectedItem.click();		
		return waitForCondition(Driver->{return lblIndicator.isDisplayed();},60000);		
	}
	
	/**
	 * This method is to compare the url in the new window to the expected Url.
	 * @param String lsService: the service name
	 * @param String lsExpectedUrl: expected Url
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean compareUrlInNewWindow(String lsService,String lsExpectedUrl) {
		WebElement selectedItem=this.getServiceWebElement(lsService);		
		if(selectedItem==null) {
			return false;
		}
		
		String lsMainWindowHandle=this.getDriver().getWindowHandle();
		getReusableActionsInstance().javascriptScrollByVisibleElement(selectedItem);
		selectedItem.click();	
		getReusableActionsInstance().waitForNumberOfWindowsToBe(2,30);
		Set<String> lstWindowHandle=this.getDriver().getWindowHandles();
		for(String windowHandle:lstWindowHandle) {
			if(!windowHandle.equalsIgnoreCase(lsMainWindowHandle)) {
				this.getDriver().switchTo().window(windowHandle);
				break;
			}
		}	
		String lsCurrentUrl=this.removeLastSlashFromUrl(this.getDriver().getCurrentUrl());
		lsExpectedUrl=this.removeLastSlashFromUrl(lsExpectedUrl);
		this.getDriver().switchTo().window(lsMainWindowHandle);
		
		return lsCurrentUrl.equalsIgnoreCase(lsExpectedUrl);
	}
	
	/**
	 * This method is to verify Links for FrequentlyAskedQuestions in CustomerService Page Objects.
	 * @param WebElement element: the FrequentlyAskedQuestions link	 
	 * @author Wei.Li
	 */
	public void verifyLinksForFrequentlyAskedQuestionsInCustomerServicePageObject(WebElement element) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		String lsOriginalUrl=this.URL();		
		String lsExpectedUrl=this.getElementHref(element);
		lsExpectedUrl=this.removeLastSlashFromUrl(lsExpectedUrl);
		element.click();
		this.waitForCondition(Driver->{return this.lnkBackToCutomerService.isDisplayed();},60000);	
		String lsCurrentUrl=this.URL();		
		reporter.softAssert(lsExpectedUrl.equalsIgnoreCase(lsCurrentUrl),"The navigated Url is equal to the expected Url","The navigated Url is not equal to the expected Url");
		reporter.softAssert(this.verifyElementExisting(this.lnkBackToCutomerService),"Navigation link is existing","Navigation link is not existing");
		reporter.softAssert(this.verifyElementExisting(this.blkArticle),"The details of related question is existing","The details of related question is not existing");
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkBackToCutomerService);
		this.lnkBackToCutomerService.click();
		this.waitForCondition(Driver->{return this.lblFrequentlyAskedQuestions.isDisplayed();},60000);
		reporter.softAssert(lsOriginalUrl.equalsIgnoreCase(this.URL()),"The navigation link works","The navigation link does not work");				
	}
	
	/**
	 * This method is to verify existence of element list.
	 * @param List<WebElement> elementList: input element list
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyElementListExistence(List<WebElement> elementList) {
		for(WebElement element:elementList) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			String lsTitle,lsSuccessMsg,lsFailureMsg;
			
			String lsTagName=element.getTagName().toLowerCase();
			switch(lsTagName) {
			case "select":
				lsSuccessMsg="The dropdown element is existing";
				lsFailureMsg="The dropdown element is not existing";
				reporter.softAssert(getReusableActionsInstance().isElementVisible(element),lsSuccessMsg,lsFailureMsg);
				break;
			case "input":
				lsTitle=element.getAttribute("name");
				lsSuccessMsg="The input element of '"+lsTitle+"' is existing";
				lsFailureMsg="The input element of '"+lsTitle+"' is not existing";
				reporter.softAssert(getReusableActionsInstance().isElementVisible(element),lsSuccessMsg,lsFailureMsg);
				break;
			case "a":
				lsTitle=element.getText().trim();				
				lsSuccessMsg="The href of element of '"+lsTitle+"' is not empty";
				lsFailureMsg="The href of element of '"+lsTitle+"' is empty";
				reporter.softAssert(!this.getElementHref(element).isEmpty(),lsSuccessMsg,lsFailureMsg);
				break;
			case "img":
				lsSuccessMsg="The src of image element is not empty";
				lsFailureMsg="The src of image element is empty";
				reporter.softAssert(!this.getElementImageSrc(element).isEmpty(),lsSuccessMsg,lsFailureMsg);
				break;
			default:
				lsTitle=element.getText().trim();
				if(lsTitle.length()>100) {
					lsTitle=lsTitle.substring(0,100)+"...";
				}				
				lsSuccessMsg="The element of '"+lsTitle+"' is existing";
				lsFailureMsg="The element of '"+lsTitle+"' is not existing";
				reporter.softAssert(getReusableActionsInstance().isElementVisible(element),lsSuccessMsg,lsFailureMsg);
				break;
			}
		}
	}
	
	/**
	 * This method is to make alert messages occur for order number and sign in input in Track Your Order service.
	 * @author Wei.Li
	 */
	public void displayAlertMessageForOrderNumberAndSignInInput() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputOrderNumber);
		this.inputOrderNumber.sendKeys("1");
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputBillingPostalCode);
		this.inputBillingPostalCode.sendKeys("1");
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputEmailAddress);
		this.inputEmailAddress.sendKeys("1");
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
		this.inputPassword.sendKeys("1");
		
		getReusableActionsInstance().staticWait(300);				
	}
	
	/**
	 * This method is to expand panel items.
	 * @author Wei.Li
	 */
	public void expandPanelItems(List<WebElement> lstPanelItem,List<WebElement> lstPanelItemContent) {
		getReusableActionsInstance().staticWait(3000);
		for(int i=0;i<lstPanelItem.size();i++) {			
			WebElement item=lstPanelItem.get(i);			
			String lsClass=item.getAttribute("class");
			if(lsClass.equalsIgnoreCase("collapsed")) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);				
				item.click();
				WebElement itemContent=lstPanelItemContent.get(i);
				waitForCondition(Driver->{return itemContent.getAttribute("aria-expanded").equalsIgnoreCase("true");},10000);
				getReusableActionsInstance().staticWait(1000);												
			}			
		}						
	}
	
	/**
	 * This method is to verify dropdown content in Contact US service.
	 * @author Wei.Li
	 */
	public void verifyDropdownOptionContent() {		
		String lsOption;
		Select drpOption= new Select(this.selectContactUS);		
		for(int i=1;i<this.lstContactUSOption.size();i++) {
			String lsFirstSection=this.lstContactUSOptionText.get(0).getText();			
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectContactUS);			
			drpOption.selectByIndex(i);
			lsOption=drpOption.getFirstSelectedOption().getText();	
			reporter.reportLog("Dropdown option: "+lsOption);
			waitForCondition(Driver->{return !lsFirstSection.equalsIgnoreCase(this.lstContactUSOptionText.get(0).getText());},5000);			
			for(WebElement contentSection:this.lstContactUSOptionText) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(contentSection);
				reporter.softAssert(getReusableActionsInstance().isElementVisible(contentSection),"The dropdown option of '"+lsOption+"' displays correctly","The dropdown option of '"+lsOption+"' does not display correctly");
			}			
		}						
	}
	
	/**
	 * This method is to verify Service object section titles.
	 * @param List<WebElement> lstSection: Section element list
	 * @param List<String> lstExpectedTitle: expected section title list
	 * @param boolean bFullMatch: Decide fully matched or partially matched
	 * @author Wei.Li
	 */
	public void verifyServiceObjectSectionTitle(List<WebElement> lstSection,List<String> lstExpectedTitle,boolean bFullMatch) {		
		List<String> lstSectionTitle=new ArrayList<String>();
		for(WebElement element:lstSection) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lstSectionTitle.add(element.getText().toUpperCase().trim());
		}
		
		boolean bMatch=false;
		String lsNotMatch="";
		for(String lsTitle:lstExpectedTitle) {
			bMatch=false;
			for(String lsItem:lstSectionTitle) {
				if(bFullMatch) {
					if(lsItem.equalsIgnoreCase(lsTitle)) {
						bMatch=true;
					}
				}
				else {
					if(lsItem.contains(lsTitle)) {
						bMatch=true;
					}
				}				
			}
			if(bMatch) {
				continue;
			}
			else {
				lsNotMatch=lsTitle;
				break;
			}
		}
		
		reporter.softAssert(bMatch,"All sections are displayed correctly",lsNotMatch+" is not displayed correctly");
	}
	
}
