package com.tsc.pages;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
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

	// Credit Card
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'creditcard')]/parent::div")
	public WebElement blkCreditCard;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'creditcard')]/img")
	public WebElement imgCreditCard;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'creditcard')]/span")
	public WebElement lblCreditCardText;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'creditcard')]")
	public WebElement lnkCreditCard;

	// Gift Card
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'giftcard')]/parent::div")
	public WebElement blkGiftCard;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'giftcard')]/img")
	public WebElement imgGiftCard;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'giftcard')]/span")
	public WebElement lblGiftCardText;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'giftcard')]")
	public WebElement lnkGiftCard;

	// Send us feedback
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'survey')]/parent::div")
	public WebElement blkSendUsFeedback;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'survey')]/img")
	public WebElement imgSendUsFeedback;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'survey')]/span")
	public WebElement lblSendUsFeedbackHeadingText;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'survey')]")
	public WebElement lnkSendUsFeedback;

	// Language switch
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'switchLanguage')]")
	public WebElement lnkLanguage;

	// Facebook
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'facebook')]/parent::div")
	public WebElement blkFacebook;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'facebook')]/img")
	public WebElement imgFacebook;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'facebook')]")
	public WebElement lnkFacebook;

	// Twitter
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'twitter')]/parent::div")
	public WebElement blkTwitter;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'twitter')]/img")
	public WebElement imgTwitter;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'twitter')]")
	public WebElement lnkTwitter;

	// Instagram
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'instagram')]/parent::div")
	public WebElement blkInstagram;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'instagram')]/img")
	public WebElement imgInstagram;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'instagram')]")
	public WebElement lnkInstagram;

	// Youtube
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'youtube')]/parent::div")
	public WebElement blkYoutube;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'youtube')]/img")
	public WebElement imgYoutube;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'youtube')]")
	public WebElement lnkYoutube;

	// Pinterest
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'pinterest')]/parent::div")
	public WebElement blkPinterest;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'pinterest')]/img")
	public WebElement imgPinterest;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'pinterest')]")
	public WebElement lnkPinterest;

	// TSC Customer Hub
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[1]/strong")
	public WebElement lblTSCCustomerHubText;

	@FindAll({
			@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[1]//ul[@class='lstMenu']/li//a"),
			@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[2]//ul[@class='lstMenu-with-icon']/li//a") })
	public List<WebElement> lnkTSCCustomerHubAllLinks;

	// About TSC
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[3]/strong")
	public WebElement lblAboutTSCText;

	@FindAll({
			@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[3]//ul[@class='lstMenu']/li//a"),
			@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'menu-area')]/div[4]//ul[@class='lstMenu']/li//a") })
	public List<WebElement> lnkAboutTSCAllLinks;

	// Rogers Logo
	@FindBy(xpath = "//div[@class='Footer']//img[contains(@src,'Rogers.png')]")
	public WebElement imgRogersLogo;

	// Copyright Section
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'copyright-msg')]/ancestor::div[contains(@class,'ftr-cell')]")
	public WebElement blkCopyright;

	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'copyright-msg')][1]")
	public WebElement txtCopyrightLine1;

	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'copyright-msg')][2]")
	public WebElement txtCopyrightLine2;

	// Customer service page objects
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

	// My Account not login
	@FindBy(xpath = "//*[contains(@class,'titleLink')]")
	public WebElement lblMyAccount;

	@FindBy(xpath = "//div[contains(@class,'singleOpenable')]//div[contains(@class,'panTitleContainer')]//a")
	public List<WebElement> lstMyAccountItemTitle;

	@FindBy(xpath = "//div[contains(@class,'singleOpenable')]//div[contains(@class,'panHTMLContainer')]")
	public List<WebElement> lstMyAccountItemContent;

	//My Account login
	@FindBy(xpath = "//div[@class='SuperCartridge'][@style]")
	public WebElement imgMyAccountLoginSuperCartridgeSection;
	
	@FindBy(xpath = "//ng-component//div[contains(@class,'tsc-forms')]//div[contains(@class,'form-head')]//h2")
	public WebElement lblMyAccountLoginName;
	
	@FindBy(xpath = "//ng-component//div[contains(@class,'tsc-forms')]//div[contains(@class,'form-head')]//span[contains(@class,'custNo')]/preceding-sibling::span")
	public WebElement lblCustomerNumber;
	
	@FindBy(xpath = "//ng-component//div[contains(@class,'tsc-forms')]//div[contains(@class,'form-head')]//span[contains(@class,'custNo')]")
	public WebElement lblCustomerNO;
	
	@FindBy(xpath = "//ng-component//button[contains(@class,'btn-accnt-signout')]")
	public WebElement btnMyAccountSignOut;
	
	@FindBy(xpath = "//ng-component//div[@class='my-account-summary-container']//div[contains(@class,'panel-group')]")
	public WebElement lstMyAccountSerivePanelContainer;
	
	public By byPanelHeading=By.xpath(".//div[contains(@class,'panel-heading')]");
	
	public By byPanelItemList=By.xpath(".//li[not(@class='hidden')]//a");
	
	@FindBy(xpath = "//ng-component//div[@class='my-account-summary-container']//div[contains(@class,'panel-group')]//div[contains(@class,'panel-heading')]")
	public List<WebElement> lstMyAccountSerivePanelHeading;
	
	@FindBy(xpath = "//ng-component//div[@class='my-account-summary-container']//div[contains(@class,'panel-group')]//li[not(@class='hidden')]//a")
	public List<WebElement> lstMyAccountSerivePanelItem;
	
	// Track Your Order
	@FindBy(xpath = "//div[contains(@class,'trackorder__wrap')]//h1")
	public WebElement lblTrackYourOrder;

	@FindBy(xpath = "//div[contains(@class,'trackorder__wrap')]//div[contains(@class,'required-fields')]")
	public WebElement lblRequiredFieldsInfo;

	// For Order number
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

	// For Sign in
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

	// Contact Us
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

	// Terms of Use
	@FindBy(xpath = "//div[@class='Middle']//h2")
	public WebElement lblTermsOfUseAboutOurService;

	@FindBy(xpath = "//div[@class='Middle']//div[contains(@class,'singleOpenable')]//div[contains(@class,'panTitleContainer')]//a")
	public List<WebElement> lstTermsOfUseItemTitle;

	@FindBy(xpath = "//div[@class='Middle']//div[contains(@class,'singleOpenable')]//div[contains(@class,'panHTMLContainer')]")
	public List<WebElement> lstTermsOfUseItemContent;

	// More About TSC
	@FindBy(xpath = "(//h4//span[contains(@id,'contentPlaceHolder_ctl')]//ancestor::div[@class='quickLinkPanelWrap']//ul[contains(@class,'quickLinkUL c')]//li//a)[1]")
	public WebElement lstMoreAboutTSCPBecomeAVendor;

	@FindBy(xpath = "//div[@class='quickLinkPanelWrap']//ul[@class='quickLinkUL col3Divs ']//li//a")
	public List<WebElement> lstMoreAboutTSCLinks;

	// Default page section titles and Contents
	@FindBy(xpath = "//div[@class='Middle']//div[contains(@class,'singleOpenable')]//div[contains(@class,'panTitleContaine')]//a[@class='']")
	public List<WebElement> lstOfExpandedTitle;

	@FindBy(xpath = "//div[@class='Middle']//div[contains(@class,'singleOpenable')]//div[contains(@class,'panHTMLContainer collapse')]")
	public List<WebElement> lstOfExpandedContent;

	@FindBy(xpath="//h2[contains(@class,'titleLink')]")
	public WebElement aboutUsPageTitle;

	@FindBy(xpath="//h4[contains(@class,'subTitleLink')]")
	public List<WebElement> subHeaders;

	@FindBy(xpath="//ul[contains(@class,'quickLinkUL')]//a[contains(@id,'contentPlaceHolder')]")
	public List<WebElement> subHeaderLinks;

	/**
	 * Close popup dialog through clicking close button.
	 * 
	 * @author Wei.Li
	 */
	public void closePopupDialog() {
		if (waitForCondition(Driver -> {
			return (new HomePage(this.getDriver())).btnClose.isDisplayed();
		}, 40000)) {
			(new HomePage(this.getDriver())).btnClose.click();
		}
		getReusableActionsInstance().staticWait(500);
	}

	/**
	 * This method is to wait for page loading
	 * 
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean waitForPageLoading() {
		this.waitForPageToLoad();
		
		return (new ProductResultsPage(this.getDriver())).waitForPageLoading();
	}

	/**
	 * This method is to remove protocal headings(http/https)
	 * 
	 * @param String lsUrl: input Url
	 * @return Url
	 * @author Wei.Li
	 */
	public String removeProtocalHeaderFromUrl(String lsUrl) {
		lsUrl = removeLastSlashFromUrl(lsUrl);

		if (!lsUrl.toLowerCase().contains("http")) {
			return lsUrl;
		}

		String[] itemArray = lsUrl.split(":");
		String lsLeft = itemArray[1].substring(2);
		return lsLeft;
	}

	/**
	 * This method is to verify the url after clicking element.
	 * 
	 * @param WebElement element: input element
	 * @param String     lsExpectedUrl: expected Url
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyUrlAfterClickingElement(WebElement element, String lsExpectedUrl) {
		lsExpectedUrl = removeProtocalHeaderFromUrl(lsExpectedUrl);
		String lsCurrentUrl = waitForPageLoadingByUrlChange(element);
		lsCurrentUrl = removeProtocalHeaderFromUrl(lsCurrentUrl);

		return lsCurrentUrl.equalsIgnoreCase(lsExpectedUrl)
				|| lsCurrentUrl.toLowerCase().contains(lsExpectedUrl.toLowerCase());
	}

	/**
	 * This method is to get expected Url from yml file.
	 * 
	 * @param List<String> lstSocialMedia: the Url from yml file
	 * @param String       lsSpecificMediaName: input media name, i.e.,
	 *                     "Facebook","Twitter","Instagram","Youtube","Pinterest"
	 * @return String
	 * @author Wei.Li
	 */
	public String getUrlWithSocialMediaName(List<String> lstSocialMedia, String lsSpecificMediaName) {
		for (String lsItem : lstSocialMedia) {
			if (lsItem.toLowerCase().contains(lsSpecificMediaName.toLowerCase())) {
				return removeProtocalHeaderFromUrl(lsItem);
			}
		}
		return "";
	}

	/**
	 * This method is to get the link from yml file.
	 * 
	 * @param List<String> lstNameAndLink: the list from yml file
	 * @param String       lsSpecificName: input name
	 * @param boolean      bEnglish: true for English while false for French
	 * @return String: note that the empty string means not found
	 * @author Wei.Li
	 */
	public String getLinkWithSpecificName(List<List<String>> lstNameAndLink, String lsSpecificName, boolean bEnglish) {
		String lsCompare;
		for (List<String> lstItem : lstNameAndLink) {
			if (bEnglish) {
				lsCompare = this.getUTFEnabledData(lstItem.get(0));
			} else {
				lsCompare = this.getUTFEnabledData(lstItem.get(1));
			}
			
			if (lsSpecificName.equalsIgnoreCase(lsCompare)) {
				if (lstItem.get(2).startsWith("/")) {
					return this.removeLastSlashFromUrl(this.getBaseURL() + lstItem.get(2).trim());
				} else {
					return this.removeLastSlashFromUrl(lstItem.get(2).trim());
				}

			}
		}

		return "";
	}

	public HashMap<String,String> getTestDataWithSpecificName(List<List<String>> lstNameAndLink, String lsSpecificName, boolean bEnglish) {
		HashMap<String,String> hashMap = new HashMap<>();
		String lsCompare=null;
		for (List<String> lstItem : lstNameAndLink) {
			if (bEnglish) {
				lsCompare = this.getUTFEnabledData(lstItem.get(0));
			} else {
				lsCompare = this.getUTFEnabledData(lstItem.get(1));
			}
			if (lsSpecificName.equalsIgnoreCase(lsCompare)) {
				if (lstItem.get(2).startsWith("/")) {
					hashMap.put("Link",this.removeLastSlashFromUrl(this.getBaseURL() + lstItem.get(2).trim()));
				} else {
					hashMap.put("Link",this.removeLastSlashFromUrl(lstItem.get(2).trim()));
				}
				hashMap.put("Title",lstItem.get(3));
			}
		}
		return hashMap;
	}

	/**
	 * This method is to verify if equal to a UTF-8 encoding text.
	 * 
	 * @param List<String> lstNameAndLink: the list from yml file
	 * @param String       lsSpecificName: input text
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyEqualWithEncodingText(List<List<String>> lstNameAndLink, String lsSpecificName) {
		System.out.println("lsSpecificName: "+lsSpecificName);
		for (List<String> lstItem : lstNameAndLink) {
			System.out.println("lstItem: "+lstItem);
			if (lsSpecificName.trim().contains(this.getUTFEnabledData(lstItem.get(0)))) {
				System.out.println(lsSpecificName+" : "+lstItem);
				return true;
			}
		}

		return false;
	}

	/**
	 * This method is to get the French name from yml file.
	 * 
	 * @param List<String> lstNameAndLink: the list from yml file
	 * @param String       lsSpecificName: input name
	 * @return French name: note that the empty string means not found
	 * @author Wei.Li
	 */
	public String getFrenchWithSpecificEnglishName(List<List<String>> lstNameAndLink, String lsSpecificName) {
		for (List<String> lstItem : lstNameAndLink) {
			if (lsSpecificName.equalsIgnoreCase(this.getUTFEnabledData(lstItem.get(0)))) {
				return this.getUTFEnabledData(lstItem.get(1).trim());
			}
		}

		return "";
	}

	/**
	 * This method is to get the English name from yml file.
	 * 
	 * @param List<String> lstNameAndLink: the list from yml file
	 * @param String       lsSpecificName: input name
	 * @return French name: note that the empty string means not found
	 * @author Wei.Li
	 */
	public String getEnglishWithSpecificFrenchName(List<List<String>> lstNameAndLink, String lsSpecificName) {
		for (List<String> lstItem : lstNameAndLink) {
			String lsCompare = this.getUTFEnabledData(lstItem.get(1));
			if (lsSpecificName.equalsIgnoreCase(lsCompare)) {
				return this.getUTFEnabledData(lstItem.get(0).trim());
			}
		}

		return "";
	}

	/**
	 * This method is to compare the link in front page and the one in yml file.
	 * 
	 * @param String lsCurrentLink: the link in front page
	 * @param String lsYmlLink: the link in yml file
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyLinks(String lsCurrentLink, String lsYmlLink) {
		lsCurrentLink = removeLastSlashFromUrl(lsCurrentLink);
		lsYmlLink = removeLastSlashFromUrl(lsYmlLink);

		if (lsYmlLink.startsWith("/")) {
			lsYmlLink = this.getBaseURL() + lsYmlLink;
			return lsCurrentLink.equalsIgnoreCase(lsYmlLink);
		} else {
			return lsCurrentLink.toLowerCase().contains(lsYmlLink.toLowerCase());
		}
	}

	/**
	 * This method is to switch language.
	 * 
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean switchlanguage() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkLanguage);
		waitForCondition(Driver->{return this.lnkLanguage.isDisplayed();},10000);
		String lsLanguage=this.lnkLanguage.getText().trim();
		this.lnkLanguage.click();
		this.waitForPageLoading();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkLanguage);
		
		return this.waitForCondition(Driver->{return !this.lnkLanguage.getText().trim().equalsIgnoreCase(lsLanguage);}, 30000);
	}

	/**
	 * This method is to get the element for specific service name.
	 * 
	 * @param String lsService: the service name
	 * @return WebElement
	 * @author Wei.Li
	 */
	public WebElement getServiceWebElement(String lsService) {
		WebElement selectedItem = this.getElementFromList(this.lnkTSCCustomerHubAllLinks, lsService);
		if (selectedItem == null) {
			selectedItem = this.getElementFromList(this.lnkAboutTSCAllLinks, lsService);
		}
		return selectedItem;
	}

	/**
	 * This method is to go to a specific service.
	 * 
	 * @param String     lsService: the service name
	 * @param WebElement lblIndicator: page loading indicator
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean goToService(String lsService, WebElement lblIndicator) {
		String lsUrl=this.URL();
		WebElement selectedItem = this.getServiceWebElement(lsService);
		if (selectedItem == null) {
			return false;
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(selectedItem);
		selectedItem.click();
		
		waitForCondition(Driver -> { return !lsUrl.equalsIgnoreCase(this.URL());}, 60000);		
		(new ProductResultsPage(this.getDriver())).waitForPageLoading();
		getReusableActionsInstance().staticWait(2000);
		return waitForCondition(Driver -> {return lblIndicator.isDisplayed();}, 60000);
	}

	/**
	 * This method is to compare the url in the new window to the expected Url.
	 * 
	 * @param String lsService: the service name
	 * @param String lsExpectedUrl: expected Url
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean compareUrlInNewWindow(String lsService, String lsExpectedUrl) {
		WebElement selectedItem = this.getServiceWebElement(lsService);
		if (selectedItem == null) {
			return false;
		}

		String lsMainWindowHandle = this.getDriver().getWindowHandle();
		getReusableActionsInstance().javascriptScrollByVisibleElement(selectedItem);
		selectedItem.click();
		getReusableActionsInstance().waitForNumberOfWindowsToBe(2, 30);
		Set<String> lstWindowHandle = this.getDriver().getWindowHandles();
		for (String windowHandle : lstWindowHandle) {
			if (!windowHandle.equalsIgnoreCase(lsMainWindowHandle)) {
				getReusableActionsInstance().staticWait(5000);
				this.getDriver().switchTo().window(windowHandle);
				break;
			}
		}
		String lsCurrentUrl = this.removeLastSlashFromUrl(this.getDriver().getCurrentUrl());
		lsExpectedUrl = this.removeLastSlashFromUrl(lsExpectedUrl);
		this.getDriver().switchTo().window(lsMainWindowHandle);

		return lsCurrentUrl.equalsIgnoreCase(lsExpectedUrl);
	}

	/**
	 * This method is to verify Links for FrequentlyAskedQuestions in
	 * CustomerService Page Objects.
	 * 
	 * @param WebElement element: the FrequentlyAskedQuestions link
	 * @author Wei.Li
	 */
	public void verifyLinksForFrequentlyAskedQuestionsInCustomerServicePageObject(WebElement element) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		String lsOriginalUrl = this.URL();
		String lsExpectedUrl = this.getElementHref(element);
		lsExpectedUrl = this.removeLastSlashFromUrl(lsExpectedUrl);
		element.click();
		this.waitForCondition(Driver -> {
			return this.lnkBackToCutomerService.isDisplayed();
		}, 60000);
		String lsCurrentUrl = this.URL();
		reporter.softAssert(lsExpectedUrl.equalsIgnoreCase(lsCurrentUrl),
				"The navigated Url is equal to the expected Url", "The navigated Url is not equal to the expected Url");
		reporter.softAssert(this.verifyElementExisting(this.lnkBackToCutomerService), "Navigation link is existing",
				"Navigation link is not existing");
		reporter.softAssert(this.verifyElementExisting(this.blkArticle), "The details of related question is existing",
				"The details of related question is not existing");
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkBackToCutomerService);
		this.lnkBackToCutomerService.click();
		this.waitForCondition(Driver -> {
			return this.lblFrequentlyAskedQuestions.isDisplayed();
		}, 60000);
		reporter.softAssert(lsOriginalUrl.equalsIgnoreCase(this.URL()), "The navigation link works",
				"The navigation link does not work");
	}

	/**
	 * This method is to verify existence of element list.
	 * 
	 * @param List<WebElement> elementList: input element list
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyElementListExistence(List<WebElement> elementList) {
		for (WebElement element : elementList) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			String lsTitle, lsSuccessMsg, lsFailureMsg;

			String lsTagName = element.getTagName().toLowerCase();
			switch (lsTagName) {
			case "select":
				lsSuccessMsg = "The dropdown element is existing";
				lsFailureMsg = "The dropdown element is not existing";
				reporter.softAssert(getReusableActionsInstance().isElementVisible(element), lsSuccessMsg, lsFailureMsg);
				break;
			case "input":
				lsTitle = element.getAttribute("name");
				lsSuccessMsg = "The input element of '" + lsTitle + "' is existing";
				lsFailureMsg = "The input element of '" + lsTitle + "' is not existing";
				reporter.softAssert(getReusableActionsInstance().isElementVisible(element), lsSuccessMsg, lsFailureMsg);
				break;
			case "button":
				lsTitle = element.getText().trim();;
				lsSuccessMsg = "The button element of '" + lsTitle + "' is existing";
				lsFailureMsg = "The button element of '" + lsTitle + "' is not existing";
				reporter.softAssert(getReusableActionsInstance().isElementVisible(element), lsSuccessMsg, lsFailureMsg);
				break;
			case "a":
				lsTitle = element.getText().trim();
				lsSuccessMsg = "The href of element of '" + lsTitle + "' is not empty";
				lsFailureMsg = "The href of element of '" + lsTitle + "' is empty";
				reporter.softAssert(!this.getElementHref(element).isEmpty(), lsSuccessMsg, lsFailureMsg);
				break;
			case "img":
				lsSuccessMsg = "The src of image element is not empty";
				lsFailureMsg = "The src of image element is empty";
				reporter.softAssert(!this.getElementImageSrc(element).isEmpty(), lsSuccessMsg, lsFailureMsg);
				break;
			default:
				lsTitle = element.getText().trim();
				if (lsTitle.length() > 100) {
					lsTitle = lsTitle.substring(0, 100) + "...";
				}
				lsSuccessMsg = "The element of '" + lsTitle + "' is existing";
				lsFailureMsg = "The element of '" + lsTitle + "' is not existing";
				reporter.softAssert(getReusableActionsInstance().isElementVisible(element), lsSuccessMsg, lsFailureMsg);
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

	public Boolean verifyRespectiveSectionForLinkOnPage(List<WebElement> lstPanelItem){
		getReusableActionsInstance().staticWait(3000);
		int counter = 0;
		for(int i=0;i<lstPanelItem.size();i++) {
			try{
				WebElement item=lstPanelItem.get(i);
				String lsClass=item.getAttribute("class");
				
				if(lsClass.isEmpty() || !lsClass.toLowerCase().contains("collapsed")) {
					getReusableActionsInstance().javascriptScrollByVisibleElement(item);
					counter++;
					break;
				}
			}catch (Exception exception){
				exception.printStackTrace();
			}
		}
		if (counter == 1) return true;
		else return false;
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
	
	/**
	 * This method is to verify links inside More About TSC page
	 * @author godwin.gopi
	 */
	public void clickOnTSCOptionLink(int i) {
		String linkOftheTSC=null;
			String path="(//div[@class='quickLinkPanelWrap']//ul[@class='quickLinkUL col3Divs ']//li//a)["+i+"]";
			getReusableActionsInstance().staticWait(3000);
			WebElement element=getDriver().findElement(By.xpath(path));
			linkOftheTSC=element.getText();
			reporter.reportLog("TSC Links Name is "+linkOftheTSC+"");
			element.click();
		
	}
	
	public void verifyTSCCustomerHubLlinks(List<List<String>> lstNameAndLinks) {		
		BasePage basePage=new BasePage(this.getDriver());
		String lsText,lsYmlHref,lsHref;
		for(WebElement item:this.lnkTSCCustomerHubAllLinks) {
			lsText=basePage.getElementText(item);	
			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,true);			
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFail("Unable to find "+lsText+" link.");
			}
			lsHref=basePage.getElementHref(item);	
			reporter.softAssert(this.verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
			
		}
	}
	
	public void verifyAboutTSCLinks(List<List<String>> lstNameAndLinks) {
		BasePage basePage=new BasePage(this.getDriver());
		String lsText,lsYmlHref,lsHref;
		for(WebElement item:this.lnkAboutTSCAllLinks) {
			lsText=basePage.getElementText(item);
			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,true);
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFail("Unable to find "+lsText+" link.");
			}
			lsHref=basePage.getElementHref(item);
			reporter.softAssert(this.verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);			
		}
	}
	
	public void verifyMyAccountSerivePanelItem() {		
		ArrayList<WebElement> elementList=new ArrayList<WebElement>();
		for(WebElement item:this.lstMyAccountSerivePanelItem) {
			elementList.add(item);
		}
		this.verifyElementListExistence(elementList);
	}
	
	public void verifyRogersLogo() {
		reporter.softAssert(this.verifyElementExisting(this.imgRogersLogo), "Rogers Logo is existing", "Rogers Logo is not existing");
	}
	
	public List<String> getCustomerHubSubItemFr(List<List<String>> lstNameAndLinks){
		String lsText=this.getUTFEnabledData(this.getElementText(this.lblTSCCustomerHubText));
		
		List<String> lstFr=new ArrayList<String>();
		String lsFr;
		for(WebElement item:this.lnkTSCCustomerHubAllLinks) {
			lsText=this.getElementText(item);	
			lsFr=this.getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
			lstFr.add(lsFr);
		}
		
		return lstFr;
	}
	
	public List<String> getAboutTSCSubItemFr(List<List<String>> lstNameAndLinks){
		String lsText=this.getUTFEnabledData(this.getElementText(this.lblAboutTSCText));
		
		List<String> lstFr=new ArrayList<String>();
		String lsFr;
		for(WebElement item:this.lnkAboutTSCAllLinks) {
			lsText=this.getElementText(item);	
			lsFr=this.getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
			lstFr.add(lsFr);
		}
		
		return lstFr;
	}
	
	public void verifyCustomerHubSubItemFr(List<List<String>> lstNameAndLinks, List<String> lstCustomerHubFr) {
		String lsText,lsYmlHref,lsHref;
		
		for(int i=0;i<this.lnkTSCCustomerHubAllLinks.size();i++) {
			lsText=this.getUTFEnabledData(this.getElementText(this.lnkTSCCustomerHubAllLinks.get(i)));	
			reporter.softAssert(lsText.equalsIgnoreCase(lstCustomerHubFr.get(i)),"The "+i+" CustomerHubLink French transaltion of "+lsText+" is the same as "+lstCustomerHubFr.get(i),"The "+i+" CustomerHubLink French transaltion of "+lsText+" is the same as "+lstCustomerHubFr.get(i));
			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,false);			
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFail("Unable to find "+lsText+" link.");
			}
			lsHref=this.getElementHref(this.lnkTSCCustomerHubAllLinks.get(i));	
			reporter.softAssert(this.verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
		}
	}
	
	public void verifyAboutTSCSubItemFr(List<List<String>> lstNameAndLinks, List<String> lstAboutTSCFr) {
		String lsText,lsYmlHref,lsHref;
		
		for(int i=0;i<this.lnkAboutTSCAllLinks.size();i++) {
			lsText=this.getUTFEnabledData(this.getElementText(this.lnkAboutTSCAllLinks.get(i)));	
			reporter.softAssert(lsText.equalsIgnoreCase(lstAboutTSCFr.get(i)),"The "+i+" AboutTSLink French transaltion of "+lsText+" is the same as "+lstAboutTSCFr.get(i),"The "+i+" AboutTSLink French transaltion of "+lsText+" is the same as "+lstAboutTSCFr.get(i));
			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,false);
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFail("Unable to find "+lsText+" link.");
			}
			lsHref=this.getElementHref(this.lnkAboutTSCAllLinks.get(i));
			reporter.softAssert(this.verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
		}
	}
	
	public void verifyFaceBookLink(List<String> lstSocialMediaLinks) {
		String lsUrl=this.getUrlWithSocialMediaName(lstSocialMediaLinks, "Facebook");		
		reporter.softAssert(this.verifyUrlAfterClickingElement(this.lnkFacebook,lsUrl),"The Url after clicking Facebook link is "+lsUrl,"The Url after clicking Facebook link is not "+lsUrl);
			
		String lsBaseUrl=this.getBaseURL()+"/";		
		this.navigateToURL(lsBaseUrl);
		this.waitForPageLoading();
	}
		
		
}
