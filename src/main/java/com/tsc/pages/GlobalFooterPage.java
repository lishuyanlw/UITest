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
	
	@FindBy(xpath = "//div[@class='Footer']//div[@class='custom-footer']//a[contains(@href,'switchLanguage')]/span")
	public WebElement lblLanguageHeadingText;
			
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

	/**
	 * Close popup dialog through pressing escape key.
	 * @author Wei.Li
	 */
	public void closePopupDialog() {
		this.pressEscapeKey();
	}
	
	/**
	 * This method is to wait for page loading
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean waitForPageLoading() {
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
		return lsCurrentUrl.equalsIgnoreCase(lsExpectedUrl);		
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
	 * @return String: note that the empty string means not found
	 * @author Wei.Li
	 */
	public String getLinkWithSpecificName(List<List<String>> lstNameAndLink, String lsSpecificName) {
		for(List<String> lstItem:lstNameAndLink) {			
			if(lsSpecificName.equalsIgnoreCase(lstItem.get(0))) {
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
			if(lsSpecificName.trim().equalsIgnoreCase(this.getUFTEnabledData(lstItem.get(0)))) {				
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
		System.out.println("lsSpecificName: "+lsSpecificName);
		for(List<String> lstItem:lstNameAndLink) {			
			if(lsSpecificName.equalsIgnoreCase(this.getUFTEnabledData(lstItem.get(0)))) {
				return lstItem.get(1).trim();
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
	

}
