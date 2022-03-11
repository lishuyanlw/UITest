package com.tsc.pages;

import java.util.*;

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
	Map<String,String> hashMap = new HashMap<>();

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
	//Top customer questions
	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//*[@class='customer-service-faq__title']")
	public WebElement lblCustomerServiceWhatCanWeHelpYouWith;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//input[@class='customer-service-faq__search-input']")
	public WebElement inputCustomerServiceSearch;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//*[@class='customer-service-faq__top-questions']")
	public WebElement lblTopCustomerQuestions;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//ul[@class='customer-service-faq__faq']/li//button[@class='customer-service-faq__faq-title']")
	public List<WebElement> lstTopCustomerQuestionsTitle;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//ul[@class='customer-service-faq__faq']/li//div[@class='customer-service-faq__faq-article']")
	public WebElement lblTopCustomerQuestionsContent;

	//Browse by help topics
	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//*[@class='customer-service-faq__topics-title']")
	public WebElement lblBrowseByHelpTopics;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__topics-grid']//div[@class='customer-service-faq__topics-grid__article']//div[@class='customer-service-faq__topics-grid__article__wrapper']//div[@class='customer-service-faq__topics-grid__article__title']")
	public List<WebElement> lstBrowseByHelpTopicsTitle;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__topics-grid']//div[@class='customer-service-faq__topics-grid__article']//div[@class='customer-service-faq__topics-grid__article__title-icon']//img")
	public List<WebElement> lstBrowseByHelpTopicsIcon;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__topics-grid']//div[@class='customer-service-faq__topics-grid__article']//div[@class='customer-service-faq__topics-grid__article__wrapper']")
	public List<WebElement> cntBrowseByHelpTopics;

	public By byBrowseByHelpTopicsTitle= By.xpath(".//div[@class='customer-service-faq__topics-grid__article__title']");

	public By byBrowseByHelpTopicsSubItemList= By.xpath(".//ul/li//a");

	public By byBrowseByHelpTopicsSubItemSeeMoreButton= By.xpath(".//button[@class='customer-service-faq__topics-grid__article__expand-button']");

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__topics-grid']//div[@class='customer-service-faq__topics-grid__article']//ul/li")
	public List<WebElement> lstBrowseByHelpTopicsSubItem;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__topics-grid']//div[@class='customer-service-faq__topics-grid__article']//button[@class='customer-service-faq__topics-grid__article__expand-button']")
	public List<WebElement> lstBrowseByHelpTopicsSubItemSeeMoreButton;

	////////////////////////////////////////////////////////////////
	//The window after clicking subitem
	@FindBy(xpath = "//div[@class='customer-service-faq']//aside//nav[@class='customer-service-faq__article__side-nav__nav']//ul/li")
	public List<WebElement> lstCustomerServiceSubItemWindowSideButtonContainer;

	@FindBy(xpath = "//div[@class='customer-service-faq']//aside//nav[@class='customer-service-faq__article__side-nav__nav']//ul/li//button")
	public List<WebElement> lstCustomerServiceSubItemWindowSideButton;

	@FindBy(xpath = "//div[@class='customer-service-faq']//aside//nav[@class='customer-service-faq__article__side-nav__nav']//ul/li//ul/li")
	public List<WebElement> lstCustomerServiceSubItemWindowSideSubItemList;

	@FindBy(xpath = "//div[@class='customer-service-faq']//div[@class='customer-service-faq__article__body']")
	public WebElement lblCustomerServiceSubItemWindowContentBody;

	@FindBy(xpath = "//div[@class='customer-service-faq']//div[@class='customer-service-faq__article__body']//*[@class='customer-service-faq__article__body__title']")
	public WebElement lblCustomerServiceSubItemWindowContentTitle;

	//For Contact Info
	@FindBy(xpath = "//nav[@class='customer-service-faq__article__side-nav__nav']//a[contains(@href,'contact-info')]")
	public WebElement lnkCustomerServiceContactInfo;

	@FindBy(xpath = "//section[@class='tsc-contact-us']//*[@class='tsc-contact-us__title']")
	public WebElement lblCustomerServiceContactUsTitle;

	@FindBy(xpath = "//section[@class='tsc-contact-us']//button[@class='tsc-contact-us__livechat']/preceding-sibling::div[@class='tsc-contact-us__text']")
	public WebElement lblCustomerServiceContactUsChatDescription;

	@FindBy(xpath = "//section[@class='tsc-contact-us']//button[@class='tsc-contact-us__livechat']")
	public WebElement btnCustomerServiceContactUsLiveChat;

	@FindBy(xpath = "//section[@class='tsc-contact-us']//button[@class='tsc-contact-us__livechat']/following-sibling::div[@class='tsc-contact-us__text']")
	public WebElement lblCustomerServiceContactUsCallCustomerDescription;

	@FindBy(xpath = "//section[@class='tsc-contact-us']//button[@class='tsc-contact-us__livechat']/following-sibling::div[@class='tsc-contact-us__text tsc-contact-us__text--top-space']")
	public WebElement lblCustomerServiceContactUsCallSalesDescription;

	@FindBy(xpath = "//section[@class='tsc-contact-us']//div[@class='tsc-contact-us__inquiries-block']//span[@class='tsc-contact-us__inquiries-block__text']")
	public WebElement lblCustomerServiceContactUsCompleteEmailFormsDescription;

	@FindBy(xpath = "//section[@class='tsc-contact-us']//div[@class='tsc-contact-us__inquiries-block']//a[contains(@href,'email')]")
	public WebElement lnkCustomerServiceContactUsGeneralEmailInquiries;

	@FindBy(xpath = "//section[@class='tsc-contact-us']//div[@class='tsc-contact-us__inquiries-block']//a[contains(@href,'billing')]")
	public WebElement lnkCustomerServiceContactUsBillingOrRefundEmailInquiries;

	@FindBy(xpath = "//section[@class='tsc-contact-us']//div[@class='tsc-contact-us__inquiries-block']//span[contains(@class,'tsc-contact-us__inquiries-block__text--light')]")
	public WebElement lblCustomerServiceContactUsFeedback;

	@FindBy(xpath = "//section[@class='tsc-contact-us']//div[@class='tsc-contact-us__inquiries-block']//span[contains(@class,'tsc-contact-us__inquiries-block__text--light')]//a")
	public WebElement lnkCustomerServiceContactUsFeedback;

	//For General email inquiries
	@FindBy(xpath = "//section[@class='tsc-contact-form']//*[@class='tsc-contact-form__title']")
	public WebElement lblCustomerServiceGeneralEmailInquiriesTitle;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//div[@class='tsc-contact-form__text']")
	public WebElement lblCustomerServiceGeneralEmailInquiriesDescription;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__message']")
	public WebElement lblCustomerServiceGeneralEmailInquiriesRequiredFieldMessage;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Email address')]")
	public WebElement lblCustomerServiceGeneralEmailInquiriesRequiredFieldEmailAddress;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Email address')]/preceding-sibling::input[@class='tsc-contact-form__form__label__input']")
	public WebElement inputCustomerServiceGeneralEmailInquiriesEmailAddress;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Email address')]/following-sibling::div[@class='tsc-contact-form__form__label__validation']")
	public WebElement lblCustomerServiceGeneralEmailInquiriesEmailAddressValidationMessage;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Email address')]/following-sibling::span[@class='tsc-contact-form__form__label__text']")
	public WebElement lblCustomerServiceGeneralEmailInquiriesEmailAddressErrorMessage;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'First name')]")
	public WebElement lblCustomerServiceGeneralEmailInquiriesRequiredFieldFirstName;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'First name')]/preceding-sibling::input[@class='tsc-contact-form__form__label__input']")
	public WebElement inputCustomerServiceGeneralEmailInquiriesFirstName;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'First name')]/following-sibling::div[@class='tsc-contact-form__form__label__validation']")
	public WebElement lblCustomerServiceGeneralEmailInquiriesFirstNameValidationMessage;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Last name')]")
	public WebElement lblCustomerServiceGeneralEmailInquiriesRequiredFieldLastName;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Last name')]/preceding-sibling::input[@class='tsc-contact-form__form__label__input']")
	public WebElement inputCustomerServiceGeneralEmailInquiriesLastName;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Last name')]/following-sibling::div[@class='tsc-contact-form__form__label__validation']")
	public WebElement lblCustomerServiceGeneralEmailInquiriesLastNameValidationMessage;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Phone number')]")
	public WebElement lblCustomerServiceGeneralEmailInquiriesPhoneNumber;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Phone number')]/preceding-sibling::input[@class='tsc-contact-form__form__label__input']")
	public WebElement inputCustomerServiceGeneralEmailInquiriesRequiredFieldPhoneNumber;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Phone number')]/following-sibling::div[@class='tsc-contact-form__form__label__validation']")
	public WebElement lblCustomerServiceGeneralEmailInquiriesPhoneNumberValidationMessage;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//textarea[@class='tsc-contact-form__form__label__textarea']")
	public WebElement textCustomerServiceGeneralEmailInquiriesConcerns;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//textarea[@class='tsc-contact-form__form__label__textarea']/following-sibling::div[@class='tsc-contact-form__form__label__validation']")
	public WebElement lblCustomerServiceGeneralEmailInquiriesConcernsValidationMessage;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//button[@class='tsc-contact-form__form__submit-button']")
	public WebElement btnCustomerServiceGeneralEmailInquiriesSubmit;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//p[@class='tsc-contact-form__information']")
	public WebElement lblCustomerServiceGeneralEmailInquiriesInformation;

	//For billing/refund inquiries
	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Order Number')]")
	public WebElement lblCustomerServiceGeneralEmailInquiriesRequiredFieldOrderNumber;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Order Number')]/preceding-sibling::input[@class='tsc-contact-form__form__label__input']")
	public WebElement inputCustomerServiceGeneralEmailInquiriesOrderNumber;

	@FindBy(xpath = "//section[@class='tsc-contact-form']//span[@class='tsc-contact-form__form__label__placeholder'][contains(.,'Order Number')]/following-sibling::div[@class='tsc-contact-form__form__label__validation']")
	public WebElement lblCustomerServiceGeneralEmailInquiriesOrderNumberValidationMessage;


	///////////////////////////////////////////////////////////////

	//Still need help
	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__help']//h3/preceding-sibling::*")
	public WebElement iconStillNeedHelp;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__help']//*[@class='customer-service-faq__help__title']")
	public WebElement lblStillNeedHelpTitle;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__help']//div[@class='customer-service-faq__help__subtitle']")
	public WebElement lblStillNeedHelpSubTitle;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__help']//button[@class='customer-service-faq__help__live-chat']")
	public WebElement btnCustomerLiveChat;

	/////////////////////////////////////////////////////////
	//The popup window after clicking Live chat button
	@FindBy(xpath = "//embeddedservice-chat-header//header//h2")
	public WebElement lblCustomerLiveChatHeader;

	@FindBy(xpath = "//embeddedservice-chat-header//header//button[@title='Minimize chat']")
	public WebElement btnCustomerLiveChatMinimizeButton;

	@FindBy(xpath = "//embeddedservice-chat-header//header//button[@title='Close dialog']")
	public WebElement btnCustomerLiveChatCloseButton;

	@FindBy(xpath = "//div[@class='fieldList']//label[@for='FirstName']")
	public WebElement lblCustomerLiveChatFirstName;

	@FindBy(xpath = "//div[@class='fieldList']//input[contains(@class,'FirstName')]")
	public WebElement inputCustomerLiveChatFirstName;

	@FindBy(xpath = "//div[@class='fieldList']//label[@for='LastName']")
	public WebElement lblCustomerLiveChatLastName;

	@FindBy(xpath = "//div[@class='fieldList']//input[contains(@class,'LastName')]")
	public WebElement inputCustomerLiveChatLastName;

	@FindBy(xpath = "//div[@class='fieldList']//label[@for='Email']")
	public WebElement lblCustomerLiveChatEmail;

	@FindBy(xpath = "//div[@class='fieldList']//input[contains(@class,'Email')]")
	public WebElement inputCustomerLiveChatEmail;

	@FindBy(xpath = "//div[@class='fieldList']//label[@for='Subject']")
	public WebElement lblCustomerLiveChatSubject;

	@FindBy(xpath = "//div[@class='fieldList']//input[contains(@class,'Subject')]")
	public WebElement inputCustomerLiveChatSubject;

	@FindBy(xpath = "//button[contains(@class,'startButton')]")
	public WebElement btnCustomerLiveChatStartChatting;

	//////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__help']//div[@class='customer-service-faq__help__support']")
	public WebElement lblCustomerSupport;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__help']//div[@class='customer-service-faq__help__support']//span[@class='customer-service-faq__help__support-text']//a[contains(@href,'tel')]")
	public WebElement lnkCustomerServiceCenter;

	@FindBy(xpath = "//div[@id='customer-service']//div[@class='customer-service-faq']//div[@class='customer-service-faq__help']//div[@class='customer-service-faq__help__support']//span[@class='customer-service-faq__help__support-text']//a[contains(@href,'email')]")
	public WebElement lnkCustomerServiceSendUsAnEmail;

	// My Account not login
	@FindBy(xpath = "//*[contains(@class,'titleLink')]")
	public WebElement lblMyAccount;

	@FindBy(xpath = "//div[contains(@class,'singleOpenable')]//div[contains(@class,'panTitleContainer')]//a")
	public List<WebElement> lstMyAccountItemTitle;

	@FindBy(xpath = "//div[contains(@class,'singleOpenable')]//div[contains(@class,'panHTMLContainer')]")
	public List<WebElement> lstMyAccountItemContent;

	//My Account login, unavailable for now
	@FindBy(xpath = "//div[@class='SuperCartridge'][@style]")
	public WebElement imgMyAccountLoginSuperCartridgeSection;

	@FindBy(xpath = "//section[contains(@class,'tsc-container container')]//div[contains(@class,'rhs-account')]/a/span|//ng-component//div[contains(@class,'tsc-forms')]//div[contains(@class,'form-head')]//h2")
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

	//For Blog
	@FindBy(xpath = "//body[contains(@class,'blog')]")
	public WebElement blogLoadingIndicator;

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

	@FindBy(xpath="//div[contains(@class,'msg-text')]")
	public WebElement lblAboutUsPageMsg;

	@FindBy(xpath="//h4[contains(@class,'subTitleLink')]")
	public List<WebElement> subHeaders;

	@FindBy(xpath="//ul[contains(@class,'quickLinkUL')]//a[contains(@id,'contentPlaceHolder')]")
	public List<WebElement> subHeaderLinks;

	//Shop By Brand
	@FindBy(xpath="//div[contains(@class,'col-xs-12')]//h2")
	public WebElement lblShopbyBrandTitle;

	@FindBy(xpath="//div[@class='Middle']//*[@class='titleLink']/b")
	public WebElement lblShopByBrandTitleAfterDropDown;

	@FindBy(xpath="//div[contains(@class,'sortPrpLabel searchTi')]")
	public WebElement lblSearchForaBrand;

	@FindBy(xpath="//div[contains(@class,'findByAlphabet')]")
	public WebElement lblFilterByAlphabet;

	@FindBy(xpath="//input[contains(@id,'brandSearchBox')]")
	public WebElement textBoxShopByBrandInputSearchBox;

	@FindBy(xpath="//form//div[contains(@class,'sortPrpLabel')]")
	public WebElement lblShopByBrandFilterByCategory;

	@FindBy(xpath="//button[contains(@id,'btnSearchProduct')]")
	public WebElement buttonShopByBrandInputSearchBoxSearchButton;

	@FindBy(xpath="//select[contains(@id,'brandSelect')]")
	public WebElement dropDownShopByBrandFilterByCategory;

	@FindBy(xpath="//div[contains(@class,'lettersDiv')]//div[contains(@class,'active')]//span")
	public WebElement activeAlphabetChar;

	@FindBy(xpath="//div[contains(@class,'lettersDiv')]//div/span[not(contains(@class,'number'))]")
	public List<WebElement> linkFindByAlphabet;

	//Channel Finder
	@FindBy(xpath="//*[contains(@class,'pageHeader')]")
	public WebElement lblChannelFinderTitle;

	@FindBy(xpath="//div[@class='Middle']//div[contains(@class,'find-channel')]//*[@class='section-title']")
	public WebElement lblFindCableChannelTitle;

	@FindBy(xpath="//div[@Class='clearfix']//div/p[contains(text(),'Channel')]")
	public WebElement useourchannelfinder;

	@FindBy(xpath="//div[@class='Middle']//div[contains(@class,'find-channel')]//h4")
	public WebElement lblselectyour;

	@FindBy(xpath="//label[contains(text(),'PROVIN')]")
	public WebElement lblProvince;

	@FindBy(xpath="//label[contains(text(),'CABLE')]")
	public WebElement lblCableProvider;

	@FindBy(xpath="//label[contains(text(),'CIT')]")
	public WebElement lblCity;

	@FindBy(xpath="//div[contains(@class,'satellite')]//h1")
	public WebElement lblSatelliteChannels;

	@FindBy(xpath="//div[contains(@class,'satellite')]//h3[contains(text(),'Be')]")
	public WebElement lblBellTV;

	@FindBy(xpath="//div[contains(@class,'satellite')]//h3[contains(text(),'Sh')]")
	public WebElement lblShawDirect;

	@FindBy(xpath="//div[contains(@class,'satellite')]//h3[contains(text(),'Bell')]//following-sibling::p[contains(text(),'11')]")
	public WebElement lblChannelsBellTV;

	@FindBy(xpath="//div[contains(@class,'satellite')]//h3[contains(text(),'Shaw')]//following-sibling::p")
	public WebElement lblChannelsShawDirect;

	@FindBy(xpath="//select[contains(@class,'form-control') and contains(@id,'1')]")
	public WebElement dropDownProvince;

	@FindBy(xpath="//select[contains(@class,'form-control') and contains(@id,'2')]")
	public WebElement dropDownCableProvider;

	@FindBy(xpath="//select[contains(@class,'form-control') and contains(@id,'3')]")
	public WebElement dropDownCity;

	//Meet Our Hosts
	@FindBy(xpath="//div[contains(@class,'FullWidthContent')]//h2")
	public List<WebElement> listOfMeetOurHosts;

	@FindBy(xpath="//div[contains(@class,'FullWidthContent')]//a")
	public List<WebElement> linkOfMeetOurHosts;

	@FindBy(xpath="//div[contains(@class,'FullWidthContent')]//img")
	public List<WebElement> listOfMeetOurHostsImage;

	//Rogers Copy Rights Image
	@FindBy(xpath="//strong[contains(@id,'ftrCopyright')]")
	public WebElement RogersMedia;

	@FindBy(xpath="//div[contains(@class,'copyright-msg xs-vw2 sm-px12')]//strong[contains(text(),'All')]")
	public WebElement AllPrice;

	@FindBy(xpath="//img[contains(@src,'Rogers.png')]")
	public WebElement RogersMediaImg;

	public boolean bClickingInquiriesOrFeedback=false;


	/**
	 * Close popup dialog through clicking close button.
	 *
	 * @author Wei.Li
	 */
	public void closePopupDialog() {
		HomePage homePage = new HomePage(getDriver());
		try{
			if(waitForCondition(Driver->{return homePage.btnClose.isDisplayed();},60000)){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(homePage.btnClose);
				this.getReusableActionsInstance().clickIfAvailable(homePage.btnClose,3000);
			}
			this.waitForPageToLoad();
		}
		catch(Exception e){
			e.printStackTrace();
		}
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
	 * @param - String lsUrl: input Url
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
	 * @param- WebElement element: input element
	 * @param- String     lsExpectedUrl: expected Url
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyUrlAfterClickingElement(WebElement element, String lsExpectedUrl) {
		lsExpectedUrl = removeProtocalHeaderFromUrl(lsExpectedUrl);
		String lsCurrentUrl = waitForPageLoadingByUrlChange(element);
		lsCurrentUrl = removeProtocalHeaderFromUrl(lsCurrentUrl);

		if(lsExpectedUrl.contains("instagram.com")){
			return lsCurrentUrl.contains("instagram.com");
		}
		else{
			return lsCurrentUrl.equalsIgnoreCase(lsExpectedUrl)
					|| lsCurrentUrl.toLowerCase().contains(lsExpectedUrl.toLowerCase());
		}
	}

	/**
	 * This method is to get expected Url from yml file.
	 *
	 * @param- List<String> lstSocialMedia: the Url from yml file
	 * @param- String       lsSpecificMediaName: input media name, i.e.,
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
	 * @param- List<String> lstNameAndLink: the list from yml file
	 * @param- String       lsSpecificName: input name
	 * @param- boolean      bEnglish: true for English while false for French
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

	public Map<String,String> getTestDataWithSpecificName(List<List<String>> lstNameAndLink, String lsSpecificName, boolean bEnglish) {
		//HashMap<String,String> hashMap = new HashMap<>();
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
				hashMap.put("parent",lstItem.get(4));
			}
		}
		return hashMap;
	}

	/**
	 * This method is to verify if equal to a UTF-8 encoding text.
	 * @param- List<String> lstNameAndLink: the list from yml file
	 * @param- String       lsSpecificName: input text
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyEqualWithEncodingText(List<List<String>> lstNameAndLink, String lsSpecificName) {
		for (List<String> lstItem : lstNameAndLink) {
			if (lsSpecificName.trim().contains(this.getUTFEnabledData(lstItem.get(0)))) {
				return true;
			}
		}

		return false;
	}

	/**
	 * This method is to get the French name from yml file.
	 *
	 * @param- List<String> lstNameAndLink: the list from yml file
	 * @param- String       lsSpecificName: input name
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
	 * @param- List<String> lstNameAndLink: the list from yml file
	 * @param- String       lsSpecificName: input name
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
	 * @param- String lsCurrentLink: the link in front page
	 * @param- String lsYmlLink: the link in yml file
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
		String lsLanguage=this.lnkLanguage.getText().trim();
		this.getReusableActionsInstance().clickIfAvailable(this.lnkLanguage);
		this.waitForPageToLoad();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkLanguage);

		return this.waitForCondition(Driver->{return !this.lnkLanguage.getText().trim().equalsIgnoreCase(lsLanguage);}, 30000);
	}

	/**
	 * This method is to get the element for specific service name.
	 *
	 * @param- String lsService: the service name
	 * @return WebElement
	 * @author Wei.Li
	 */
	public WebElement getServiceWebElement(String lsService, String footerSection) {
		WebElement selectedItem = this.getElementFromList(this.lnkTSCCustomerHubAllLinks, lsService);
		if (selectedItem == null) {
			selectedItem = this.getElementFromList(this.lnkAboutTSCAllLinks, lsService);
		}
		return selectedItem;
	}

	/**
	 * This method is to go to a specific service.
	 *
	 * @param- String     lsService: the service name
	 * @param- WebElement lblIndicator: page loading indicator
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean goToService(String lsService, WebElement lblIndicator,String section) {
		String lsUrl=this.URL();
		WebElement selectedItem = this.getServiceWebElement(lsService,section);
		if (selectedItem == null) {
			return false;
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(selectedItem);
		getReusableActionsInstance().clickIfAvailable(selectedItem);

		this.waitForPageToLoad();
		return waitForCondition(Driver -> {return lblIndicator.isDisplayed();}, 60000);
	}

	/**
	 * This method is to compare the url in the new window to the expected Url.
	 *
	 * @param- String lsService: the service name
	 * @param- String lsExpectedUrl: expected Url
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean compareUrlInNewWindow(String lsService, String lsExpectedUrl,String section) {
		WebElement selectedItem = this.getServiceWebElement(lsService,section);
		if (selectedItem == null) {
			return false;
		}

		String lsCurrentUrl;
		String lsMainWindowHandle = this.getDriver().getWindowHandle();
		getReusableActionsInstance().javascriptScrollByVisibleElement(selectedItem);
		this.getReusableActionsInstance().clickIfAvailable(selectedItem);
		getReusableActionsInstance().waitForNumberOfWindowsToBe(2, 90);
		Set<String> lstWindowHandle = this.getDriver().getWindowHandles();

		for (String windowHandle : lstWindowHandle) {
			this.getDriver().switchTo().window(windowHandle);
			if(this.getDriver().getTitle().toLowerCase().contains("blog")){
				break;
			}
		}
		this.waitForCondition(Driver->{return this.blogLoadingIndicator.isDisplayed();},5000);

		lsCurrentUrl = this.removeLastSlashFromUrl(this.getDriver().getCurrentUrl());
		lsExpectedUrl = this.removeLastSlashFromUrl(lsExpectedUrl);

		String strQaUrl=System.getProperty("QaUrl");
		this.getDriver().get(strQaUrl);
		this.waitForPageToLoad();

		return lsCurrentUrl.equalsIgnoreCase(lsExpectedUrl);
	}

	/**
	 * This method is to verify SearchBox And Top Customer Questions in
	 * CustomerService Page Objects.
	 * @author Wei.Li
	 */
	public void verifySearchBoxAndTopCustomerQuestionsInCustomerServicePageObject() {
		String lsText;
		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceWhatCanWeHelpYouWith);
		lsText=lblCustomerServiceWhatCanWeHelpYouWith.getText();
		lsText=this.getShortenText(lsText,100);
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerServiceSearch);
		if(getReusableActionsInstance().isElementVisible(inputCustomerServiceSearch)){
			reporter.reportLogPass("The element of search box is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of search box is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblTopCustomerQuestions);
		lsText=lblCustomerServiceWhatCanWeHelpYouWith.getText();
		lsText=this.getShortenText(lsText,100);
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		for(WebElement item:lstTopCustomerQuestionsTitle){
			getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText();
			lsText=this.getShortenText(lsText,100);
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The element of '"+ lsText+"'"+" in Top customer questions list is displaying correctly.");
			}
			else{
				reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" in Top customer questions list is not displaying correctly.");
			}

			getReusableActionsInstance().clickIfAvailable(item);
			this.waitForCondition(Driver->{return this.getChildElementCount(item)>1;},5000);
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblTopCustomerQuestionsContent);
			lsText=lblTopCustomerQuestionsContent.getText();
			lsText=this.getShortenText(lsText,100);
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The sub element of '"+ lsText+"'"+" in Top customer questions list is displaying correctly.");
			}
			else{
				reporter.reportLogFailWithScreenshot("The sub element of '"+ lsText+"'"+" in Top customer questions list is not displaying correctly.");
			}
		}
	}

	/**
	 * This method is to verify Help Topics in
	 * CustomerService Page Objects.
	 * @author Wei.Li
	 */
	public void verifyBrowseByHelpTopicsInCustomerServicePageObject() {
		String lsText;
		getReusableActionsInstance().javascriptScrollByVisibleElement(lblBrowseByHelpTopics);
		lsText=lblBrowseByHelpTopics.getText();
		lsText=this.getShortenText(lsText,100);
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		WebElement element;
		List<WebElement> itemList;
		int subItemCountBeforeClicking,subItemCountAfterClicking;
		for(WebElement item:cntBrowseByHelpTopics){
			getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			element=item.findElement(this.byBrowseByHelpTopicsTitle);
			lsText=element.getText();
			lsText=this.getShortenText(lsText,100);
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The element of '"+ lsText+"'"+" in Help topics list is displaying correctly.");
			}
			else{
				reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" in Help topics list is not displaying correctly.");
			}
			itemList=item.findElements(this.byBrowseByHelpTopicsSubItemList);
			subItemCountBeforeClicking=itemList.size();
			if(this.checkChildElementExistingByTagNameAndAttribute(item,"button","class","customer-service-faq__topics-grid__article__expand-button")){
				element=item.findElement(this.byBrowseByHelpTopicsSubItemSeeMoreButton);
				lsText=element.getText().trim();
				if(lsText.equalsIgnoreCase("See more")){
					reporter.reportLogPass("The See more button is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The See more button is not displaying correctly");
				}
				getReusableActionsInstance().clickIfAvailable(element);
				final WebElement tempButton=element;
				this.waitForCondition(Driver->{return this.getElementInnerText(tempButton).equalsIgnoreCase("See less");},2000);

				itemList=item.findElements(this.byBrowseByHelpTopicsSubItemList);
				subItemCountAfterClicking=itemList.size();

				element=item.findElement(this.byBrowseByHelpTopicsSubItemSeeMoreButton);
				lsText=element.getText().trim();
				if(lsText.equalsIgnoreCase("See less")){
					reporter.reportLogPass("The See less button is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The See less button is not displaying correctly");
				}

				if(subItemCountAfterClicking>subItemCountBeforeClicking){
					reporter.reportLogPass("Clicking See more button works correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("Clicking See more button does not work correctly");
				}
			}

			for(int i=0;i<itemList.size();i++){
				element=itemList.get(i);
				getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText=element.getText().trim();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The element of '"+ lsText+"'"+" in Help topics Sublist is displaying correctly.");
				}
				else{
					reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" in Help topics Sublist is not displaying correctly.");
				}
			}
		}

		for(int i=0;i<this.lstBrowseByHelpTopicsIcon.size();i++){
			element=this.lstBrowseByHelpTopicsIcon.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			if(!this.getElementImageSrc(element).isEmpty()){
				reporter.reportLogPass("The icon image src of '"+ this.getElementInnerText(this.lstBrowseByHelpTopicsTitle.get(i))+"'"+" in Help topics Sublist is not empty.");
			}
			else{
				reporter.reportLogFailWithScreenshot("The icon image src of '"+ this.getElementInnerText(this.lstBrowseByHelpTopicsTitle.get(i))+"'"+" in Help topics Sublist is empty.");
			}
		}
	}

	/**
	 * This method is to verify Help Topics subitem clicking in
	 * CustomerService Page Objects.
	 * @author Wei.Li
	 */
	public void verifyWindowAfterClickingBrowseByHelpTopicsSubItemInCustomerServicePageObject() {
		String lsText,lsTitle;
		WebElement item,element,subItem;

		for(int i=0;i<this.cntBrowseByHelpTopics.size();i++){
			item=this.cntBrowseByHelpTopics.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			element=item.findElements(this.byBrowseByHelpTopicsSubItemList).get(0);
			lsTitle=element.getText().trim();

			reporter.reportLog("verify window content after clicking subitem in Browse By Help Topics");
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstBrowseByHelpTopicsTitle.get(i));
			this.getReusableActionsInstance().clickIfAvailable(element);
			this.getReusableActionsInstance().waitForElementVisibility(lblCustomerServiceSubItemWindowContentTitle);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceSubItemWindowContentTitle);
			lsText=lblCustomerServiceSubItemWindowContentTitle.getText().trim();
			if(lsTitle.equalsIgnoreCase(lsText)){
				reporter.reportLogPass("The Help topic title of '"+lsTitle+"' is the same as TSC help center title of '"+lsText+"'.");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Help topic title of '"+lsTitle+"' is not the same as TSC help center title of '"+lsText+"'.");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceSubItemWindowContentBody);
			lsText=lblCustomerServiceSubItemWindowContentBody.getText().trim();
			lsText=this.getShortenText(lsText,100);
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
			}
			else{
				reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
			}

			reporter.reportLog("verify Left aside panel of window content after clicking subitem in Browse By Help Topics");
			verifyLeftAsidePenalAfterClickingBrowseByHelpTopicsSubItemInCustomerServicePageObject();

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstCustomerServiceSubItemWindowSideButton.get(0));
			this.getReusableActionsInstance().clickIfAvailable(this.lstCustomerServiceSubItemWindowSideButton.get(0));
			this.getReusableActionsInstance().waitForElementVisibility(lblCustomerServiceWhatCanWeHelpYouWith);
		}
	}

	/**
	 * This method is to verify the left panel after clicking Help Topics subitem  in
	 * CustomerService Page Objects.
	 * @author Wei.Li
	 */
	public void verifyLeftAsidePenalAfterClickingBrowseByHelpTopicsSubItemInCustomerServicePageObject() {
		String lsText;
		WebElement subItem;

		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstCustomerServiceSubItemWindowSideButton.get(0));
		if(getReusableActionsInstance().isElementVisible(this.lstCustomerServiceSubItemWindowSideButton.get(0))){
			reporter.reportLogPass("The element of TSC Help Center button is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of TSC Help Center button is not displaying correctly.");
		}

		for(int i=1;i<this.lstCustomerServiceSubItemWindowSideButton.size();i++){
			subItem=this.lstCustomerServiceSubItemWindowSideButton.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			lsText=subItem.getText().trim();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
			}
			else{
				reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
			}

			if(this.getChildElementCount(lstCustomerServiceSubItemWindowSideButtonContainer.get(i))==1){
				this.getReusableActionsInstance().clickIfAvailable(subItem);
				final WebElement tempButton=subItem.findElement(By.xpath(".."));
				this.waitForCondition(Driver->{return this.getChildElementCount(tempButton)>1;},2000);
			}

			for(WebElement subElement:this.lstCustomerServiceSubItemWindowSideSubItemList){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subElement);
				lsText=subElement.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The sub element of '"+ lsText+"'"+" is displaying correctly.");
				}
				else{
					reporter.reportLogFailWithScreenshot("The sub element of '"+ lsText+"'"+" is not displaying correctly.");
				}
			}
		}
	}

	/**
	 * This method is to verify still need help part in
	 * CustomerService Page Objects.
	 * @author Wei.Li
	 */
	public void verifyStillNeedHelpInCustomerServicePageObject() {
		String lsText;

		getReusableActionsInstance().javascriptScrollByVisibleElement(iconStillNeedHelp);
		if(this.getReusableActionsInstance().isElementVisible(iconStillNeedHelp)){
			reporter.reportLogPass("The Still need help icon element is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Still need help icon element is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblStillNeedHelpTitle);
		lsText=lblStillNeedHelpTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblStillNeedHelpSubTitle);
		lsText=lblStillNeedHelpSubTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(btnCustomerLiveChat);
		if(getReusableActionsInstance().isElementVisible(btnCustomerLiveChat)){
			reporter.reportLogPass("The element of LiveChat is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of LiveChat is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerSupport);
		lsText=lblCustomerSupport.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCustomerServiceCenter);
		lsText=this.getElementHref(lnkCustomerServiceCenter);
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element href of '"+ lsText+"'"+" is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element href of '"+ lsText+"'"+" is empty.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCustomerServiceSendUsAnEmail);
		lsText=this.getElementHref(lnkCustomerServiceSendUsAnEmail);
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element href of '"+ lsText+"'"+" is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element href of '"+ lsText+"'"+" is empty.");
		}
	}

	/**
	 * This method is to verify Live Chat content
	 * @author Wei.Li
	 */
	public void verifyLiveChatContent() {
		String lsText;

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerLiveChatHeader);
		lsText=lblCustomerLiveChatHeader.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(btnCustomerLiveChatMinimizeButton);
		if(this.getReusableActionsInstance().isElementVisible(btnCustomerLiveChatMinimizeButton)){
			reporter.reportLogPass("The Minimize button in Live Chat dialog is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Minimize button in Live Chat dialog is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(btnCustomerLiveChatCloseButton);
		if(this.getReusableActionsInstance().isElementVisible(btnCustomerLiveChatCloseButton)){
			reporter.reportLogPass("The close button in Live Chat dialog is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The close button in Live Chat dialog is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerLiveChatFirstName);
		lsText=lblCustomerLiveChatFirstName.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerLiveChatFirstName);
		if(this.getReusableActionsInstance().isElementVisible(inputCustomerLiveChatFirstName)){
			reporter.reportLogPass("The First name input in Live Chat dialog is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The First name input in Live Chat dialog is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerLiveChatLastName);
		lsText=lblCustomerLiveChatLastName.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerLiveChatLastName);
		if(this.getReusableActionsInstance().isElementVisible(inputCustomerLiveChatLastName)){
			reporter.reportLogPass("The Last name input in Live Chat dialog is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Last name input in Live Chat dialog is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerLiveChatEmail);
		lsText=lblCustomerLiveChatEmail.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerLiveChatEmail);
		if(this.getReusableActionsInstance().isElementVisible(inputCustomerLiveChatEmail)){
			reporter.reportLogPass("The Email input in Live Chat dialog is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Email input in Live Chat dialog is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerLiveChatSubject);
		lsText=lblCustomerLiveChatSubject.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerLiveChatSubject);
		if(this.getReusableActionsInstance().isElementVisible(inputCustomerLiveChatSubject)){
			reporter.reportLogPass("The Subject input in Live Chat dialog is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Subject input in Live Chat dialog is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(btnCustomerLiveChatStartChatting);
		if(this.getReusableActionsInstance().isElementVisible(btnCustomerLiveChatStartChatting)){
			reporter.reportLogPass("The Start Chatting button in Live Chat dialog is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Start Chatting button in Live Chat dialog is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(btnCustomerLiveChatCloseButton);
		getReusableActionsInstance().clickIfAvailable(btnCustomerLiveChatCloseButton);
		getReusableActionsInstance().staticWait(300);
	}

	/**
	 * This method is to verify Live Chat popup window in CustomerService Page Objects.
	 * @param WebElement btnLiveChat: to tell it is for Customer service or Contact info
	 * @author Wei.Li
	 */
	public void verifyLiveChatPopupWindowInCustomerServicePageObject(WebElement btnLiveChat) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(btnLiveChat);
		getReusableActionsInstance().clickIfAvailable(btnLiveChat);
		getReusableActionsInstance().waitForElementVisibility(lblCustomerLiveChatFirstName);
		verifyLiveChatContent();
	}

	/**
	 * This method is to verify existence of element list.
	 *
	 * @param- List<WebElement> elementList: input element list
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
					if(getReusableActionsInstance().isElementVisible(element)){
						reporter.reportLogPass(lsSuccessMsg);
					}
					else{
						reporter.reportLogFailWithScreenshot(lsFailureMsg);
					}
					break;
				case "input":
					lsTitle = element.getAttribute("name");
					lsSuccessMsg = "The input element of '" + lsTitle + "' is existing";
					lsFailureMsg = "The input element of '" + lsTitle + "' is not existing";
					if(getReusableActionsInstance().isElementVisible(element)){
						reporter.reportLogPass(lsSuccessMsg);
					}
					else{
						reporter.reportLogFailWithScreenshot(lsFailureMsg);
					}
					break;
				case "button":
					lsTitle = element.getText().trim();;
					lsSuccessMsg = "The button element of '" + lsTitle + "' is existing";
					lsFailureMsg = "The button element of '" + lsTitle + "' is not existing";
					if(getReusableActionsInstance().isElementVisible(element)){
						reporter.reportLogPass(lsSuccessMsg);
					}
					else{
						reporter.reportLogFailWithScreenshot(lsFailureMsg);
					}
					break;
				case "a":
					lsTitle = element.getText().trim();
					lsSuccessMsg = "The href of element of '" + lsTitle + "' is not empty";
					lsFailureMsg = "The href of element of '" + lsTitle + "' is empty";
					if(!this.getElementHref(element).isEmpty()){
						reporter.reportLogPass(lsSuccessMsg);
					}
					else{
						reporter.reportLogFailWithScreenshot(lsFailureMsg);
					}
					break;
				case "img":
					lsSuccessMsg = "The src of image element is not empty";
					lsFailureMsg = "The src of image element is empty";
					if(!this.getElementImageSrc(element).isEmpty()){
						reporter.reportLogPass(lsSuccessMsg);
					}
					else{
						reporter.reportLogFailWithScreenshot(lsFailureMsg);
					}
					break;
				default:
					lsTitle = element.getText().trim();
					if (lsTitle.length() > 100) {
						lsTitle = lsTitle.substring(0, 100) + "...";
					}
					lsSuccessMsg = "The element of '" + lsTitle + "' is existing";
					lsFailureMsg = "The element of '" + lsTitle + "' is not existing";
					if(getReusableActionsInstance().isElementVisible(element)){
						reporter.reportLogPass(lsSuccessMsg);
					}
					else{
						reporter.reportLogFailWithScreenshot(lsFailureMsg);
					}
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
		this.getReusableActionsInstance().waitForElementVisibility(lblOrderNumberAlertMsg);

		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputBillingPostalCode);
		this.inputBillingPostalCode.sendKeys("1");
		this.getReusableActionsInstance().waitForElementVisibility(lblBillingPostalCodeAlertMsg);

		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputEmailAddress);
		this.inputEmailAddress.sendKeys("1");
		this.getReusableActionsInstance().waitForElementVisibility(lblEmailAddressAlertMsg);

		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
		this.inputPassword.sendKeys("1");
		this.getReusableActionsInstance().waitForElementVisibility(lblPasswordAlertMsg);
	}

	/**
	 * This method is to expand panel items.
	 * @author Wei.Li
	 */
	public void expandPanelItems(List<WebElement> lstPanelItem,List<WebElement> lstPanelItemContent) {
		for(int i=0;i<lstPanelItem.size();i++) {
			WebElement item=lstPanelItem.get(i);
			String lsClass=item.getAttribute("class");
			if(lsClass.isEmpty()){
				continue;
			}
			if( lsClass.equalsIgnoreCase("collapsed")) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				getReusableActionsInstance().clickIfAvailable(item);
				//Need it to wait a little, otherwise will cause failure
				getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				final int tempIndex=i;
				waitForCondition(Driver->{return lstPanelItem.get(tempIndex).getAttribute("class").isEmpty();},10000);
			}
		}
	}

	public Boolean verifyRespectiveSectionForLinkOnPage(List<WebElement> lstPanelItem){
		//Need to wait for one of items to be expanded
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
	 * This method is to verify right panel in Contact US service.
	 * @author Wei.Li
	 */
	public void verifyContactUsRightPanelContent() {
		String lsText;

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceContactUsTitle);
		lsText=lblCustomerServiceContactUsTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceContactUsChatDescription);
		lsText=lblCustomerServiceContactUsChatDescription.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(btnCustomerServiceContactUsLiveChat);
		if(this.getReusableActionsInstance().isElementVisible(btnCustomerServiceContactUsLiveChat)){
			reporter.reportLogPass("The Live Chat button is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Live Chat button is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceContactUsCallCustomerDescription);
		lsText=lblCustomerServiceContactUsCallCustomerDescription.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceContactUsCallSalesDescription);
		lsText=lblCustomerServiceContactUsCallSalesDescription.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceContactUsCompleteEmailFormsDescription);
		lsText=lblCustomerServiceContactUsCompleteEmailFormsDescription.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCustomerServiceContactUsGeneralEmailInquiries);
		lsText=this.getElementHref(lnkCustomerServiceContactUsGeneralEmailInquiries);
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The href of element of '"+ lsText+"'"+" is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The href of element of '"+ lsText+"'"+" is empty.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCustomerServiceContactUsBillingOrRefundEmailInquiries);
		lsText=this.getElementHref(lnkCustomerServiceContactUsBillingOrRefundEmailInquiries);
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The href of element of '"+ lsText+"'"+" is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The href of element of '"+ lsText+"'"+" is empty.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceContactUsFeedback);
		lsText=lblCustomerServiceContactUsFeedback.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCustomerServiceContactUsFeedback);
		lsText=this.getElementHref(lnkCustomerServiceContactUsFeedback);
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The href of element of '"+ lsText+"'"+" is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The href of element of '"+ lsText+"'"+" is empty.");
		}
	}

	/**
	 * This method is to verify Email inquiries/Billing or Refund/Feedback clicking action and content in Contact TSC.
	 * @param String lsType : Email/Billing/Feedback
	 * @author Wei.Li
	 */
	public void verifyClickingActionForInquiriesOrFeedback(String lsType) {
		if(!this.bClickingInquiriesOrFeedback){
			this.bClickingInquiriesOrFeedback=true;
		}
		else{
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
	}

	/**
	 * This method is to verify Email inquiries/Billing or Refund/Feedback content in Contact TSC.
	 * @param String lsType : Email/Billing/Feedback
	 * @author Wei.Li
	 */
	public void verifyInquiriesOrFeedbackContent(String lsType) {
		String lsText;

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceGeneralEmailInquiriesTitle);
		lsText=lblCustomerServiceGeneralEmailInquiriesTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceGeneralEmailInquiriesDescription);
		lsText=lblCustomerServiceGeneralEmailInquiriesDescription.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceGeneralEmailInquiriesRequiredFieldMessage);
		lsText=lblCustomerServiceGeneralEmailInquiriesRequiredFieldMessage.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceGeneralEmailInquiriesRequiredFieldEmailAddress);
		lsText=lblCustomerServiceGeneralEmailInquiriesRequiredFieldEmailAddress.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerServiceGeneralEmailInquiriesEmailAddress);
		if(this.getReusableActionsInstance().isElementVisible(inputCustomerServiceGeneralEmailInquiriesEmailAddress)){
			reporter.reportLogPass("The Email address input is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Email address input is not displaying correctly.");
		}

		if(lsType.equalsIgnoreCase("Billing")){
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceGeneralEmailInquiriesRequiredFieldOrderNumber);
			lsText=lblCustomerServiceGeneralEmailInquiriesRequiredFieldOrderNumber.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
			}
			else{
				reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
			}

			getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerServiceGeneralEmailInquiriesOrderNumber);
			if(this.getReusableActionsInstance().isElementVisible(inputCustomerServiceGeneralEmailInquiriesOrderNumber)){
				reporter.reportLogPass("The Order Number input is displaying correctly.");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Order Number input is not displaying correctly.");
			}
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceGeneralEmailInquiriesRequiredFieldFirstName);
		lsText=lblCustomerServiceGeneralEmailInquiriesRequiredFieldFirstName.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerServiceGeneralEmailInquiriesFirstName);
		if(this.getReusableActionsInstance().isElementVisible(inputCustomerServiceGeneralEmailInquiriesFirstName)){
			reporter.reportLogPass("The First name input is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The First name input is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceGeneralEmailInquiriesRequiredFieldLastName);
		lsText=lblCustomerServiceGeneralEmailInquiriesRequiredFieldLastName.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerServiceGeneralEmailInquiriesLastName);
		if(this.getReusableActionsInstance().isElementVisible(inputCustomerServiceGeneralEmailInquiriesLastName)){
			reporter.reportLogPass("The Last name input is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Last name input is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceGeneralEmailInquiriesPhoneNumber);
		lsText=lblCustomerServiceGeneralEmailInquiriesPhoneNumber.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerServiceGeneralEmailInquiriesRequiredFieldPhoneNumber);
		if(this.getReusableActionsInstance().isElementVisible(inputCustomerServiceGeneralEmailInquiriesRequiredFieldPhoneNumber)){
			reporter.reportLogPass("The Phone number input is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Phone number input is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(textCustomerServiceGeneralEmailInquiriesConcerns);
		if(this.getReusableActionsInstance().isElementVisible(textCustomerServiceGeneralEmailInquiriesConcerns)){
			reporter.reportLogPass("The Concerns input is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Concerns input is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(btnCustomerServiceGeneralEmailInquiriesSubmit);
		if(this.getReusableActionsInstance().isElementVisible(btnCustomerServiceGeneralEmailInquiriesSubmit)){
			reporter.reportLogPass("The Submit button is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Submit button is not displaying correctly.");
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerServiceGeneralEmailInquiriesInformation);
		lsText=lblCustomerServiceGeneralEmailInquiriesInformation.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The element of '"+ lsText+"'"+" is displaying correctly.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The element of '"+ lsText+"'"+" is not displaying correctly.");
		}
	}

	/**
	 * This method is to verify Service object section titles.
	 * @param- List<WebElement> lstSection: Section element list
	 * @param- List<String> lstExpectedTitle: expected section title list
	 * @param- boolean bFullMatch: Decide fully matched or partially matched
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
		if(bMatch){
			reporter.reportLogPass("All sections are displayed correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot(lsNotMatch+" is not displayed correctly");
		}
	}

	/**
	 * This method is to verify links inside More About TSC page
	 * @author godwin.gopi
	 */
	public void clickOnTSCOptionLink(int i) {
		String linkOftheTSC=null;
		String path="(//div[@class='quickLinkPanelWrap']//ul[@class='quickLinkUL col3Divs ']//li//a)["+i+"]";
		WebElement element=getDriver().findElement(By.xpath(path));
		linkOftheTSC=element.getText();
		reporter.reportLog("TSC Links Name is "+linkOftheTSC+"");
		getReusableActionsInstance().clickIfAvailable(element);
	}

	/**
	 * This method is to verify DropDown Titles is same as Page Title
	 * @author godwin.gopi
	 */

	public  void verifyDropDownWithTitle(WebElement element) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		Select select = new Select(element);
		int dropDownElementSize = select.getOptions().size();
		for (int i = 1; i < dropDownElementSize; i++) {
			select.selectByIndex(i);
			getReusableActionsInstance().waitForPageLoad();
			String title = lblShopByBrandTitleAfterDropDown.getText();
			reporter.reportLog(" Page Title After Dropdown is " + title + ", and it is correctly appeared ");
			String option = select.getFirstSelectedOption().getText();
			reporter.reportLog(" Dropdown Selected Options is " + option + ", and it is correctly appeared");
			if(title.equalsIgnoreCase(option)){
				reporter.reportLogPass("Page Title matches for both Actual " + title + " and expected " + option + "");
			}
			else{
				reporter.reportLogFailWithScreenshot("Page Title doesn't match for both Actual " + title + " and expected " + option + "");
			}
		}
	}

	public void verifyTSCCustomerHubLlinks(List<List<String>> lstNameAndLinks) {
		//BasePage basePage=new BasePage(this.getDriver());
		String lsText,lsYmlHref,lsHref;
		for(WebElement item:this.lnkTSCCustomerHubAllLinks) {
			lsText=super.getElementText(item);
			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,true);
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFailWithScreenshot("Unable to find "+lsText+" link.");
			}
			lsHref=super.getElementHref(item);
			if(this.verifyLinks(lsHref,lsYmlHref)){
				reporter.reportLogPass("The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref);
			}
			else{
				reporter.reportLogFailWithScreenshot("The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
			}
		}
	}

	public void verifyAboutTSCLinks(List<List<String>> lstNameAndLinks) {
		//BasePage basePage=new BasePage(this.getDriver());
		String lsText,lsYmlHref,lsHref;
		for(WebElement item:this.lnkAboutTSCAllLinks) {
			lsText=super.getElementText(item);
			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,true);
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFailWithScreenshot("Unable to find "+lsText+" link.");
			}
			lsHref=super.getElementHref(item);
			if(this.verifyLinks(lsHref,lsYmlHref)){
				reporter.reportLogPass("The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref);
			}
			else{
				reporter.reportLogFailWithScreenshot("The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
			}
		}
	}

	public void verifyMyAccountServicePanelItem() {
		ArrayList<WebElement> elementList=new ArrayList<WebElement>();
		for(WebElement item:this.lstMyAccountSerivePanelItem) {
			elementList.add(item);
		}
		this.verifyElementListExistence(elementList);
	}

	public void verifyRogersLogo() {
		if(this.verifyElementExisting(this.imgRogersLogo)){
			reporter.reportLogPass("Rogers Logo is existing");
		}
		else{
			reporter.reportLogFailWithScreenshot("Rogers Logo is not existing");
		}
	}

	public List<String> getCustomerHubSubItemFr(List<List<String>> lstNameAndLinks){
		String lsText;

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
		String lsText;

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

	public void verifyAboutTSCSubItemFr(List<List<String>> lstNameAndLinks, List<String> lstAboutTSCFr) {
		String lsText,lsYmlHref,lsHref;

		for(int i=0;i<this.lnkAboutTSCAllLinks.size();i++) {
			lsText=this.getUTFEnabledData(this.getElementText(this.lnkAboutTSCAllLinks.get(i)));
			if(lsText.equalsIgnoreCase(lstAboutTSCFr.get(i))){
				reporter.reportLogPass("The "+i+" AboutTSLink French transaltion of "+lsText+" is the same as "+lstAboutTSCFr.get(i));
			}
			else{
				reporter.reportLogFailWithScreenshot("The "+i+" AboutTSLink French transaltion of "+lsText+" is the same as "+lstAboutTSCFr.get(i));
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

	public void verifyFaceBookLink(List<String> lstSocialMediaLinks) {
		String lsUrl=this.getUrlWithSocialMediaName(lstSocialMediaLinks, "Facebook");
		if(this.verifyUrlAfterClickingElement(this.lnkFacebook,lsUrl)){
			reporter.reportLogPass("The Url after clicking Facebook link is "+lsUrl);
		}
		else{
			reporter.reportLogFailWithScreenshot("The Url after clicking Facebook link is not "+lsUrl);
		}

		String lsBaseUrl=this.getBaseURL()+"/";
		this.navigateToURL(lsBaseUrl);
		this.waitForPageLoading();
	}

	/**
	 * This method is to verify Find By Alphabets Links and its content links
	 * @author godwin.gopi
	 */

	public  void verifyFindByAlphabet(WebElement element, List<WebElement> elements) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		int counter=1;
		int alphabetPathElementSize;
		Select select=new Select(element);
		select.selectByIndex(0);
		for(int i=0;i<elements.size();i++) {
			String alphabetPath="(//div[contains(@class,'lettersDiv')]//div//span)["+counter+"]";
			this.clickElement(elements.get(i));
			//Need it to wait for page scrolling down to the chosen letter
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

			String alphabetLetterValue=getDriver().findElement(By.xpath(alphabetPath)).getText();
			reporter.reportLog("Selected Alphabet is "+alphabetLetterValue+"");
			String activeAlphabetLetterValue=activeAlphabetChar.getText();
			if(alphabetLetterValue.equalsIgnoreCase(activeAlphabetLetterValue)){
				reporter.reportLogPass("The Corresponding Page Title inside the Alphabet Link is same as expected");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Corresponding Page Title inside the Alphabet Link is not same as expected");
			}

			String alphabetPathElementsPath="//div[contains(@class,'brandHeader activeLetter')]//ancestor::div[contains(@class,'col')][1]//a";
			List<WebElement> alphabetPathElements=getDriver().findElements(By.xpath(alphabetPathElementsPath));
			alphabetPathElementSize=alphabetPathElements.size();
			alphabetPathElementSize=alphabetPathElementSize>3?3:alphabetPathElementSize;
			for(int j=0 ;j<alphabetPathElementSize;j++) {
				String brandName=alphabetPathElements.get(j).getText();
				String firstLetter=convertToASCII(brandName.substring(0,1)).toUpperCase();
				if(alphabetLetterValue.equalsIgnoreCase(firstLetter)){
					reporter.reportLogPass("The Brand  first alphabet is "+firstLetter+" and Brand Name is "+brandName+"  ");
				}
				else{
					reporter.reportLogFailWithScreenshot("The Brand  first alphabet is "+firstLetter+" and Brand Name is "+brandName+" is not matching.");
				}

				String brandLink=alphabetPathElements.get(j).getAttribute("href");
				if(alphabetPathElements.get(j).getAttribute("href")!=null){
					reporter.reportLogPass("The Brand URL of "+brandLink+" exists");
				}
				else{
					reporter.reportLogFailWithScreenshot("The Brand URL of "+brandLink+" doesn't exists");
				}
			}
			counter++;
		}
	}

	/**
	 * This method is to verify each Links in Meet the Hosts
	 * @author godwin.gopi
	 */
	public boolean verifyLinks(String hrefLink) {
		String currentURL=getDriver().getCurrentUrl();

		if (currentURL.contains(hrefLink)) {
			return currentURL.contains(hrefLink);
		} else {
			return currentURL.contains(hrefLink);
		}
	}

	/**
	 * This method is to verify Drop Down in Channel Finder, navigating to its corresponding Service Provider and City
	 * @author godwin.gopi
	 */
	public  void verifyMultipleDropDownWithTitle(WebElement firstDropDown, WebElement secondDropDown, WebElement thirdDropDown) {
		Select select=new Select(firstDropDown);
		int firstDropDownElementSize=select.getOptions().size();
		if(firstDropDownElementSize > 1) {
			select.selectByIndex(1); //Checking for one item
			getReusableActionsInstance().waitForPageLoad();
			String option =select.getFirstSelectedOption().getText();
			reporter.reportLog(" Dropdown Selected Province is "+option+"");
			if(option!=null){
				reporter.reportLogPass(" Dropdown Selected Province is "+option+" and not NULL");
			}
			else{
				reporter.reportLogFailWithScreenshot(" Dropdown Selected Province is "+option+" and is NULL");
			}

			Select secondSelect=new Select(secondDropDown);
			int secondDropDownElementSize=secondSelect.getOptions().size();
			if(secondDropDownElementSize>1) {
				secondSelect.selectByIndex(1); //Checking for one item
				getReusableActionsInstance().waitForPageLoad();
				String secondOption = secondSelect.getFirstSelectedOption().getText();
				reporter.reportLog(" Dropdown Selected Province is " + option + " and Dropdown Selected Cable Provider is " + secondOption + "");
				if(secondOption != null){
					reporter.reportLogPass(" Dropdown Selected Cable provider is " + secondOption + " and not NULL");
				}
				else{
					reporter.reportLogFailWithScreenshot(" Dropdown Selected Cable provider is " + secondOption + " and is NULL");
				}

				Select thirdSelect = new Select(thirdDropDown);
				int thirdDropDownElementSize = thirdSelect.getOptions().size();
				if (thirdDropDownElementSize > 1) {
					thirdSelect.selectByIndex(1); //Checking for one item
					getReusableActionsInstance().waitForPageLoad();
					String thirdOption = thirdSelect.getFirstSelectedOption().getText();
					reporter.reportLog("Dropdown Selected Province is " + option + " and Dropdown Selected Cable Provider is " + secondOption + " Dropdown Selected City is " + thirdOption + "");
					if(thirdOption != null){
						reporter.reportLogPass(" Dropdown Selected City is " + thirdOption + " and not NULL");
					}
					else{
						reporter.reportLogFailWithScreenshot(" Dropdown Selected City is " + thirdOption + " and is NULL");
					}
				}
			}
		}else{
			reporter.reportLogFailWithScreenshot("No data is present in dropdown");
		}
	}
	/**
	 * This method is to verify Images, href and Name of the Hosts in Meet the Host
	 * @author godwin.gopi
	 */
	public void verifyMeetTheHostInfo() {
		for(int i=0;i<listOfMeetOurHosts.size();i++) {
			String hostName=listOfMeetOurHosts.get(i).getText();
			reporter.reportLog("Host Name is "+hostName+"");
			String hostHref=linkOfMeetOurHosts.get(i).getAttribute("href");
			reporter.reportLog("Host Name URL is "+hostHref+"");
			String hostImgSrc=listOfMeetOurHostsImage.get(i).getAttribute("src");
			reporter.reportLog("Host Image URL is "+hostImgSrc+"");
			if(hostName!=null && hostHref!=null && hostImgSrc!=null){
				reporter.reportLogPass("Host Name "+hostName+" Host Link "+hostHref+" and Host Image "+hostImgSrc+" are not Null");
			}
			else{
				reporter.reportLogFailWithScreenshot("Host Name "+hostName+" Host Link "+hostHref+" and Host Image "+hostImgSrc+" are  Null");
			}
		}
	}
}