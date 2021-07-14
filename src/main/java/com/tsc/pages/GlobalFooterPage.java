package com.tsc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.tsc.pages.base.BasePage;

public class GlobalFooterPage extends BasePage {
	
	public GlobalFooterPage(WebDriver driver) {
		super(driver);
		
	}
	
	//SIGN UP section
	@FindBy(xpath = "//div[@id='email_signup_container']/div")
	public WebElement blkSignUp;
	
	@FindBy(xpath = "//div[@id='email_signup_container']/div/div[1]/strong")
	public WebElement lblSignupHeadingText;
	
	@FindBy(xpath = "//div[@id='email_signup_container']//input[@id='email_signup_address']")
	public WebElement txtEmailSignup;
	
	@FindBy(xpath = "//div[@id='email_signup_container']//button[@id='email_signup_btn']")
	public WebElement btnEmailSignup;
	
	//JOIN THE CONVERSATION
	@FindBy(xpath = "//div[@class='join-conversation']")
	public WebElement blkJoinConversation;
	
	@FindBy(xpath = "//div[@class='join-conversation']//strong")
	public WebElement lblJoinConversationHeadingText;
	
	@FindBy(xpath = "//div[@class='smIcon-container']/a[1]")
	public WebElement icnFacebook;
	
	@FindBy(xpath = "//div[@class='smIcon-container']/a[2]")
	public WebElement icnTwitter;
	
	@FindBy(xpath = "//div[@class='smIcon-container']/a[3]")
	public WebElement icnInstagram;
	
	@FindBy(xpath = "//div[@class='smIcon-container']/a[4]")
	public WebElement icnYoutube;
	
	@FindBy(xpath = "//div[@class='smIcon-container']/a[5]")
	public WebElement icnPinterest;
	
	//Send Us Feedback
	@FindBy(xpath = "//div[contains(@class,'feedback')]")
	public WebElement lblSendUsFeedbackHeadingText;
	
	@FindBy(xpath = "//div[contains(@class,'feedback')]/a")
	public WebElement lnkSendUsFeedback;
	
	//Language
	@FindBy(xpath = "//div[contains(@class,'language-block')]/strong")
	public WebElement lblLanguageHeadingText;
	
	@FindBy(xpath = "//div[contains(@class,'language-block')]/a")
	public WebElement lnkLanguage;
	
	//TSC Customer Hub
	@FindAll({@FindBy(xpath = "//div[@class='ftr-cell col-sm-12 menu-area hidden-xs']/div[1]"),
        @FindBy(xpath = "//div[@class='ftr-cell col-sm-12 menu-area hidden-xs']/div[2]")})
	public WebElement blkTSCCustomerHub;
	
	@FindBy(xpath = "//div[@class='ftr-cell col-sm-12 menu-area hidden-xs']/div[1]/strong")
	public WebElement lblTSCCustomerHubText;
	
	@FindAll({@FindBy(xpath = "//div[@class='ftr-cell col-sm-12 menu-area hidden-xs']/div[1]/ul/li"),
        @FindBy(xpath = "//div[@class='ftr-cell col-sm-12 menu-area hidden-xs']/div[2]/ul/li")})
	List<WebElement> lnkTSCCustomerHubAllLinks;

	//About TSC
	@FindAll({@FindBy(xpath = "//div[@class='ftr-cell col-sm-12 menu-area hidden-xs']/div[3]"),
			@FindBy(xpath = "//div[@class='ftr-cell col-sm-12 menu-area hidden-xs']/div[4]")})
	public WebElement blkAboutTSC;

	@FindBy(xpath = "//div[@class='ftr-cell col-sm-12 menu-area hidden-xs']/div[3]/strong")
	public WebElement lblAboutTSCText;

	@FindAll({@FindBy(xpath = "//div[@class='ftr-cell col-sm-12 menu-area hidden-xs']/div[3]/ul/li"),
			@FindBy(xpath = "//div[@class='ftr-cell col-sm-12 menu-area hidden-xs']/div[4]/ul/li")})
	List<WebElement> lnkAboutTSCAllLinks;
	
	//Gift Card
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][1]")
	public WebElement blkGiftCard;
	
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][1]/div[@class='offrImg']")
	public WebElement imgGiftCard;
	
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][1]/div[@class='hidden-xs offr-msg-block']/div[1]/strong")
	public WebElement lblGiftCardText;
	
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][1]/div[@class='hidden-xs offr-msg-block']/div[2]")
	public WebElement lblGiftCardDetailText;
	
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][1]/div[@class='hidden-xs offr-msg-block']/div[3]//strong")
	public WebElement lblGiftCardGetNowText;
	
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][1]/div[@class='hidden-xs offr-msg-block']/div[3]//a")
	public WebElement lnkGiftCardGetNow;
	
	//Credit Card
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][2]")
	public WebElement blkCreditCard;
		
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][2]/div[@class='offrImg']")
	public WebElement imgCreditCard;
		
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][2]/div[@class='hidden-xs offr-msg-block']/div[1]/strong")
	public WebElement lblCreditCardText;
		
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][2]/div[@class='hidden-xs offr-msg-block']/div[2]")
	public WebElement lblCreditCardDetailText;
		
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][2]/div[@class='hidden-xs offr-msg-block']/div[3]//strong")
	public WebElement lblCreditCardApplyText;
		
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 ftr-cell'][2]/div[@class='hidden-xs offr-msg-block']/div[3]//a")
	public WebElement lnkCreditCardApplyNow;
	
	//Rogers Logo
	@FindBy(xpath = "//div[@class='col-xs-12 hidden-xs col-sm-5 ftr-cell']")
	public WebElement blkRogersLogo;
	
	@FindBy(xpath = "//div[@class='col-xs-12 hidden-xs col-sm-5 ftr-cell']/img")
	public WebElement imgRogersLogo;
	
	//Copyright Section
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-7 ftr-cell last-cell']")
	public WebElement blkCopyright;
	
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-7 ftr-cell last-cell']//div[@class='copyright-msg xs-vw2 sm-px12'][1]/strong")
	WebElement txtCopyrightLine1;
	
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-7 ftr-cell last-cell']//div[@class='copyright-msg xs-vw2 sm-px12'][2]/strong")
	WebElement txtCopyrightLine2;

	/**
	 * Scroll to and Verify visibility of Join Conversation Section block
	 * @author Waji.Abbas
	 */
	public boolean verifySignupBlockAndContentVisibility() {
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(blkSignUp);
		if (getReusableActionsInstance().isElementVisible(blkSignUp, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lblSignupHeadingText, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(txtEmailSignup, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(btnEmailSignup, 30) == false) {
			return false;
		}
		else return true;
	}
	
	/**
	 * Scroll to and Verify visibility of Sign Up Section block
	 * @author Waji.Abbas
	 */
	public boolean verifyJoinConversationBlockAndContentVisibility() {
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(blkJoinConversation);
		if (getReusableActionsInstance().isElementVisible(icnFacebook, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(icnTwitter, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(icnInstagram, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(icnYoutube, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(icnPinterest, 30) == false) {
			return false;
		}
		else return true;
	}

	/**
	 * Scroll to and Verify visibility of Send Us Feedback Section block
	 * @author Waji.Abbas
	 */
	public boolean verifySendFeedbackBlockAndContentVisibility() {
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(lblSendUsFeedbackHeadingText);
		if (getReusableActionsInstance().isElementVisible(lblSendUsFeedbackHeadingText, 30) == false) {
			return false;
		}
		else return true;
	}

	/**
	 * Scroll to and Verify visibility of Language Section block
	 * @author Waji.Abbas
	 */
	public boolean verifyLanguageBlockAndContentVisibility() {
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(lblLanguageHeadingText);
		if (getReusableActionsInstance().isElementVisible(lblLanguageHeadingText, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lnkLanguage, 30) == false) {
			return false;
		}
		else return true;
	}

	/**
	 * Scroll to and Verify visibility of TSC Customer Hub Section block
	 * @author Waji.Abbas
	 */
	public boolean verifyCustomerHubBlockAndContentVisibility() {
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(blkTSCCustomerHub);
		if (getReusableActionsInstance().isElementVisible(blkTSCCustomerHub, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lblTSCCustomerHubText, 30) == false) {
			return false;
		}
		for (WebElement lnkCustomerHub: lnkTSCCustomerHubAllLinks) {
			if (getReusableActionsInstance().isElementVisible(lnkCustomerHub, 30) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Scroll to and Verify visibility of About TSC Section block
	 * @author Waji.Abbas
	 */
	public boolean verifyAboutTSCBlockAndContentVisibility() {
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(blkAboutTSC);
		if (getReusableActionsInstance().isElementVisible(blkAboutTSC, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lblAboutTSCText, 30) == false) {
			return false;
		}
		for (WebElement lnkAboutTSC: lnkAboutTSCAllLinks) {
			if (getReusableActionsInstance().isElementVisible(lnkAboutTSC, 30) == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Scroll to and Verify visibility of Gift Card Section block
	 * @author Waji.Abbas
	 */
	public boolean verifyGiftCardBlockAndContentVisibility() {
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(blkGiftCard);
		if (getReusableActionsInstance().isElementVisible(blkGiftCard, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(imgGiftCard, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lblGiftCardText, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lblGiftCardDetailText, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lblGiftCardGetNowText, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lnkGiftCardGetNow, 30) == false) {
			return false;
		}
		else return true;
	}
	
	/**
	 * Scroll to and Verify visibility of Credit Card Section block
	 * @author Waji.Abbas
	 */
	public boolean verifyCreditCardBlockAndContentVisibility() {
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(blkCreditCard);
		if (getReusableActionsInstance().isElementVisible(blkCreditCard, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(imgCreditCard, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lblCreditCardText, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lblCreditCardDetailText, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lblCreditCardApplyText, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(lnkCreditCardApplyNow, 30) == false) {
			return false;
		}
		else return true;
	}
	
	/**
	 * Scroll to and Verify visibility of Rogers Logo Section block
	 * @author Waji.Abbas
	 */
	public boolean verifyRogersLogoBlockAndContentVisibility() {
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(blkRogersLogo);
		if (getReusableActionsInstance().isElementVisible(blkRogersLogo, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(imgRogersLogo, 30) == false) {
			return false;
		}
		else return true;
	}
	
	/**
	 * Scroll to and Verify visibility of Rogers Copyright Section block
	 * @author Waji.Abbas
	 */
	public boolean verifyRogersCopyrightBlockAndContentVisibility() {
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(blkCopyright);
		if (getReusableActionsInstance().isElementVisible(blkCopyright, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(txtCopyrightLine1, 30) == false) {
			return false;
		}
		else if (getReusableActionsInstance().isElementVisible(txtCopyrightLine2, 30) == false) {
			return false;
		}
		else return true;
	}

}
