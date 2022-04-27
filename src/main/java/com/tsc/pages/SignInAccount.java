package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SignInAccount extends BasePage {

	public SignInAccount(WebDriver driver) {
		super(driver);
	}

	//Account summary container
	@FindBy(xpath = "//div[@class='my-account-summary-container']")
	public WebElement cntAccountSummaryContainer;

	@FindBy(xpath = "//div[@class='my-account-summary-container']//div[@class='panel']")
	public List<WebElement> lstAccountSummaryPanelList;

	public By bySubList=By.xpath(".//ul//li[not(contains(@class,'hidden'))]//a");

	//For order part
	//For Order status
	//For Recent orders
	//For Order cancellation
	//For Order returns

	//PAYMENT OPTIONS - ADD NEW CREDIT CARD
	@FindBy(xpath="//div[@id='paymentOptionsLinks']//li/a")
	public List<WebElement> lstpaymentOptions;

	@FindBy(xpath="//span[@class='custNo']")
	public WebElement lblCustomerNumber;

	@FindBy(xpath="//div[contains(@class,'editPayPad')]//ul/li/button/img")
	public List<WebElement> lstCardTypesForNewCreditCard;

	@FindBy(xpath="//label//input[@name='isdefault']")
	public WebElement isDefaultCheckBoxForNewCreditCard;

	@FindBy(xpath="//div[contains(@class,'form-group')]/button[contains(@class,'btn-default')]")
	public WebElement btnCancelAddCreditCardForNewCreditCard;

	@FindBy(xpath="//div[contains(@class,'form-group')]/button[contains(@class,'btn-primary')]")
	public WebElement btnSaveAddCreditCardForNewCreditCard;

	@FindBy(xpath="//*[@class='paymentPageTitle']")
	public WebElement lblAddCreditCardPageTitleForNewCreditCard;

	@FindBy(xpath="//input[@id='pan']")
	public WebElement lblCardNumberForNewCreditCard;

	@FindBy(xpath="//input[@id='maskedPan']")
	public WebElement lblMaskedCardNumberForNewCreditCard;

	@FindBy(xpath="//select[@name='month']")
	public WebElement lblMonthForNewCreditCard;

	@FindBy(xpath="//select[@name='year']")
	public WebElement lblExpirationYearForNewCreditCard;

	@FindBy(xpath="//div[contains(@class,'text-danger')]")
	public WebElement lblErrorMessageForInvalidCreditCardNumber;

	@FindBy(xpath="//button[contains(@class,'signout')]")
	public WebElement btnSignOutMyAccountPage;

	@FindBy(xpath = "//div[@id='semafoneCapturePage']/iframe")
	public WebElement iFrameForNewCreditCard;

	//PAYMENT OPTIONS - MANAGE CREDIT CARD
	@FindBy(xpath="//div[contains(@class,'desktop-divider')]")
	public List<WebElement> lstCreditCardsPresent;
	//.//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')] - Edit Button
	//.//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallLeftPadding')]/a[contains(@class,'negative')] - Remove Button

	@FindBy(xpath="//button[@id='addCardBtn']//*[@class='svgIconPlus']")
	public WebElement btnAddNewCreditCard;

	@FindBy(xpath="//button[@id='addCardBtn']//div[contains(@class,'addBtnTxt')]")
	public WebElement lblAddNewCreditCardText;


	/**
	 * To get subitem web element through sublitem text
	 * @param lsSubItem -  sublitem text
	 * @return subitem web element
	 */
	public WebElement getSubItem(String lsSubItem){
		if(lsSubItem.contains("(")&&lsSubItem.contains(")")){
			lsSubItem=lsSubItem.trim();
			lsSubItem=lsSubItem.substring(0,lsSubItem.indexOf("("));
		}

		String lsBySubItem="//div[@class='my-account-summary-container']//div[@class='panel']//ul//li[not(contains(@class,'hidden'))]//a[contains(normalize-space(.),'"+lsSubItem+"')]";
		return this.getDriver().findElement(By.xpath(lsBySubItem));
	}

	/**
	 * To verify different card types available on application for addition
	 * @param- String - page Title
	 */
	public void verifyNewCardTypesAvailable(String pageTitle){
		//Verifying page title for new Credit Card addition
		waitForCondition(Driver->{return this.lblAddCreditCardPageTitleForNewCreditCard.isDisplayed();},5000);
		String pageTitleOnApp = this.lblAddCreditCardPageTitleForNewCreditCard.getText();
		if(pageTitleOnApp.equalsIgnoreCase(pageTitle))
			reporter.reportLogPass("Page Title for adding New Credit Card is as expected: "+pageTitleOnApp);
		else
			reporter.reportLogFailWithScreenshot("Page Title for adding New Credit Card on application: "+pageTitleOnApp+ " is not same as expected: "+pageTitle);

		//Verifying four Card Types
		List<String> cardTypesOnApp = new ArrayList<>();
		int cardCounter = 0;
		for(WebElement cardType:this.lstCardTypesForNewCreditCard) {
			String cardTypeFetched = cardType.getAttribute("alt");
			cardTypesOnApp.add(cardTypeFetched);
			if(cardTypeFetched.equalsIgnoreCase("visa") ||
				cardTypeFetched.equalsIgnoreCase("master") ||
					cardTypeFetched.equalsIgnoreCase("amex") ||
						cardTypeFetched.equalsIgnoreCase("tsc"))
				cardCounter++;
		}

		if(cardCounter==4)
			reporter.reportLogPass("All four Credit Card Types are present on application to add as expected");
		else
			reporter.reportLogFailWithScreenshot("All expected credit card are not present on application: "+cardTypesOnApp);
	}

	/**
	 * Adding new Credit Card for User
	 * @param- String - cardType to be added
	 * @param - String - cardNumber to be added
	 * @param - String - expirationMonth for Credit Card
	 * @param - String - expirationYear for Credit Card
	 * @param - boolean - isDefault value for Credit Card attached to user
	 */
	public void addNewValidCreditCardForUser(String cardType, String cardNumber, String expirationMonth, String expirationYear, boolean isDefault ){
		String cardTypeToBeAdded = this.createXPath("//div[contains(@class,'editPayPad')]//ul/li/button/img[contains(@alt,'{0}')]",cardType);
		WebElement cardTypeElement = getDriver().findElement(By.xpath(cardTypeToBeAdded));

		waitForCondition(Driver->{return cardTypeElement.isDisplayed() && cardTypeElement.isEnabled();},5000);
		this.clickWebElementUsingJS(cardTypeElement);

		String mainWindowHandle = getDriver().getWindowHandle();
		getDriver().switchTo().frame(iFrameForNewCreditCard);
		waitForCondition(Driver->{return this.lblCardNumberForNewCreditCard.isEnabled() &&
				this.lblCardNumberForNewCreditCard.isDisplayed();},6000);
		//Adding Credit Card Number
		this.clickWebElementUsingJS(this.lblCardNumberForNewCreditCard);
		this.lblCardNumberForNewCreditCard.sendKeys(cardNumber);
		waitForCondition(Driver->{return !this.lblMaskedCardNumberForNewCreditCard.getAttribute("value").isEmpty();},10000);
		getDriver().switchTo().window(mainWindowHandle);

		//Selecting Expiration Month and Year
		getReusableActionsInstance().selectWhenReady(this.lblExpirationYearForNewCreditCard,expirationMonth,6000);
		getReusableActionsInstance().selectWhenReady(this.lblMonthForNewCreditCard,expirationYear,6000);

		//Click on Save Button
		this.clickElement(this.btnSaveAddCreditCardForNewCreditCard);
	}

	/**
	 * This function verifies newly added Credit Card for user
	 * @param- String - cardType that is added
	 * @param- String - cardNumber that is added
	 * @param- String - expirationMonth of card that is added
	 * @param- String - expirationYear of card that is added
	 * @return - boolean - true/false
	 */
	public boolean verifyNewAddedCreditCardForUser(String cardType, String cardNumber, String expirationMonth, String expirationYear) {
		int loopSize = lstCreditCardsPresent.size();
		for (int counter = 0; counter < loopSize; counter++) {
			//Verifying card type image that is added
			WebElement cardImage = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[contains(@class,'padding-right')]/img"));
			String imageType = cardImage.getText();
			if (imageType.equalsIgnoreCase(cardType)) {
				//Checking the card expiration year now to verify it is same card that is added by user
				WebElement expiresOnWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//div[@class='table-cell']"));
				String expiresOnData = expiresOnWebElement.getText().split(":")[1];
				if (expiresOnData.equals(expirationMonth + "/" + expirationYear)) {
					reporter.reportLog("Card Type: " + imageType + " and expiration year is same as added: " + expiresOnData);
					//Verifying Image Type and CardType is same that is displayed in application for user
					WebElement cardTypeWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
					String cardTypeDisplayed = cardTypeWebElement.getText();
					if (cardTypeDisplayed.equalsIgnoreCase(cardType)){
						//Verifying the card number added
						WebElement expiresWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/span"));
						boolean value = this.verifyCardNumberAddedForUser(expiresWebElement,cardNumber,cardType);
						if(value)
							return true;
						else
							return false;
					}
					else {
						reporter.reportLogFailWithScreenshot("Card Type added is not same as expected: " + cardTypeDisplayed);
						return false;
					}
				}
			}
		}
		return false;
	}

	/**
	 * This function verifies the displayed last digits of Credit Card Number
	 * @param - String - cardNumber that is added
	 * @param - String - cardType that is added
	 * @return - boolean - true/false
	 */
	public boolean verifyCardNumberAddedForUser(WebElement webElement, String cardNumber, String cardType){
		String inputLastDigitsOfCard = null;
		String lastDigitsOfCard = webElement.getText().split(" ")[2];
		if(cardType.equalsIgnoreCase("visa"))
			inputLastDigitsOfCard = cardNumber.substring(cardNumber.length()-3);
		else if(cardType.equalsIgnoreCase("master"))
			inputLastDigitsOfCard = cardNumber.substring(cardNumber.length()-4);

		if(lastDigitsOfCard.equals(inputLastDigitsOfCard))
			return true;
		else
			return false;
	}
}
