package com.tsc.pages;

import com.tsc.api.util.DataConverter;
import com.tsc.pages.base.BasePage;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
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

	@FindBy(xpath="//input[@id='ficard']")
	public WebElement lblTSCCreditCardInput;

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

	@FindBy(xpath="//button[@id='addCardBtn']")
	public WebElement btnAddNewCreditCard;

	@FindBy(xpath="//button[@id='addCardBtn']//div[contains(@class,'addBtnTxt')]")
	public WebElement lblAddNewCreditCardText;

	@FindBy(xpath="//span[@class='table-cell']/label")
	public WebElement lblCardNameOnRemovePopUp;

	@FindBy(xpath="//span[@class='table-cell']/span")
	public WebElement lblCardNumberOnRemovePopUp;

	@FindBy(xpath="//div[@class='modal-body']//div[contains(@class,'clearfix')]/div/button[contains(text(),'REMOVE')]")
	public WebElement btnRemoveCreditCardButton;

	@FindBy(xpath="//div[@class='modal-body']//div[contains(@class,'clearfix')]/div/button/span")
	public WebElement btnCancelRemoveCreditCardButton;

	@FindBy(xpath="//*[@class='breadcrumb']/li/a[contains(text(),'Account')]")
	public WebElement lnkBreadCrumbMyAccount;

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
	 * This function clicks on sub-menu item present on My Account Page
	 */
	public void clickOnPaymentOptionSubMenuItemsOnMyAccount(String subMenu){
		this.waitForPageToLoad();
		boolean flag = false;
		for(WebElement webElement:this.lstpaymentOptions){
			if(webElement.getText().contains(subMenu)){
				this.clickElement(webElement);
				flag=true;
				break;
			}
		}
		if(subMenu.toLowerCase().contains("add"))
			waitForCondition(Driver->{return this.btnCancelAddCreditCardForNewCreditCard.isEnabled() &&
				this.btnCancelAddCreditCardForNewCreditCard.isDisplayed();},12000);
		else{
			this.waitForPageToLoad();
			waitForCondition(Driver->{return this.lstCreditCardsPresent.size()>0;},6000);
		}

		if(!flag)
			reporter.reportLogFailWithScreenshot("Provided sub-menu: "+subMenu+" is not present. Please verify once again!");
	}

	/**
	 * This function returns expiration data for new Credit Card
	 * @return - Map<String,String> - Expiration Month and Year Data for Card
	 * @throws ParseException
	 */
	public Map<String,String> getNewCardExpirationData(int monthsToBeAdded, int yearsToBeAdded) throws ParseException {
		Map<String,String> cardData = new HashMap<>();
		String[] date = new DataConverter().getLocalDate().split("-");
		int calculatedExpirationMonth = Integer.valueOf(date[1])+monthsToBeAdded>12 ? (Integer.parseInt(date[1])+monthsToBeAdded)-12 : Integer.valueOf(date[1])+monthsToBeAdded;
		String expirationMonth = String.valueOf(calculatedExpirationMonth);
		if(expirationMonth.length()==1)
			expirationMonth = "0"+expirationMonth;
		String expirationYear = String.valueOf(Integer.valueOf(date[0])+yearsToBeAdded);
		cardData.put("expirationMonth",expirationMonth);
		cardData.put("expirationYear",expirationYear);
		return cardData;
	}

	/**
	 * This function adds Credit Card number for new Card addition
	 */
	public void addNewCreditCardNumber(String cardNumber){
		this.waitForPageToLoad();
		getDriver().switchTo().frame(iFrameForNewCreditCard);
		waitForCondition(Driver->{return this.lblCardNumberForNewCreditCard.isEnabled() &&
				this.lblCardNumberForNewCreditCard.isDisplayed();},15000);
		//Adding Credit Card Number
		this.clickWebElementUsingJS(this.lblCardNumberForNewCreditCard);
		this.lblCardNumberForNewCreditCard.sendKeys(cardNumber);
		//Using static wait of 5 seconds here as wait for condition is throwing target frame detached error
		getReusableActionsInstance().staticWait(5000);
		//waitForCondition(Driver->{return !this.lblMaskedCardNumberForNewCreditCard.getAttribute("value").isEmpty();},10000);
		getDriver().switchTo().defaultContent();
	}

	/**
	 * This function adds Credit Card Expiration Month and Year
	 * @param -Map<String,String> - cardData
	 */
	public void addExpirationMonthAndYear(Map<String,String> cardData){
		getReusableActionsInstance().selectWhenReady(this.lblMonthForNewCreditCard,cardData.get("expirationMonth"),6000);
		getReusableActionsInstance().selectWhenReady(this.lblExpirationYearForNewCreditCard,cardData.get("expirationYear"),6000);
	}

	/**
	 * Adding new Credit Card for User
	 * @param- String - cardType to be added
	 * @param - String - cardNumber to be added
	 * @param - String - expirationMonth for Credit Card
	 * @param - String - expirationYear for Credit Card
	 * @param - boolean - isDefault value for Credit Card attached to user
	 */
	public Map<String,String> addNewValidCreditCardForUser(String cardType, String cardNumber, boolean isDefault) throws ParseException {
		String cardTypeToBeAdded = this.createXPath("//div[contains(@class,'editPayPad')]//ul/li/button/img[contains(@alt,'{0}')]",cardType);
		WebElement cardTypeElement = getDriver().findElement(By.xpath(cardTypeToBeAdded));

		//Calculating expiration Year And Month for Card
		Map<String,String> cardData = this.getNewCardExpirationData(2,0);

		waitForCondition(Driver->{return cardTypeElement.isDisplayed() && cardTypeElement.isEnabled();},5000);
		this.clickWebElementUsingJS(cardTypeElement);

		if(!cardType.equalsIgnoreCase("tsc")){
			this.addNewCreditCardNumber(cardNumber);
			//Selecting Expiration Month and Year
			this.addExpirationMonthAndYear(cardData);
		}else
			this.lblTSCCreditCardInput.sendKeys(cardNumber);

		//Click on Save Button
		if(isDefault)
			getReusableActionsInstance().clickIfAvailable(this.isDefaultCheckBoxForNewCreditCard,2000);
		this.clickElement(this.btnSaveAddCreditCardForNewCreditCard);
		return cardData;
	}

	/**
	 * This function converts input expiration data to displayed format on application
	 * @param -String - expirationMonth
	 * @param - String - expirationYear
	 * @return - String
	 */
	public String formatExpirationDateForCreditCard(String expirationMonth, String expirationYear){
		if(expirationMonth.startsWith("0"))
			expirationMonth = expirationMonth.substring(expirationMonth.length()-1);
		if(expirationYear.length()>2)
			expirationYear = expirationYear.substring(expirationYear.length()-2);
		return (expirationMonth + "/" + expirationYear).trim();
	}

	/**
	 * This function verifies newly added Credit Card for user
	 * @param- String - cardType that is added
	 * @param- String - cardNumber that is added
	 * @param- String - expirationMonth of card that is added
	 * @param- String - expirationYear of card that is added
	 * @return - boolean - true/false
	 */
	public void verifyNewAddedCreditCardForUser(String cardType, String cardDisplayName, String cardNumber, String expirationMonth, String expirationYear, boolean removeCard) {
		boolean value = false;
		String inputExpirationData = null;
		this.waitForPageToLoad();
		//this.waitForCondition(Driver->{return this.lstCreditCardsPresent.size()>0;},10000);
		int loopSize = lstCreditCardsPresent.size();
		for (int counter = 0; counter < loopSize; counter++) {
			//Verifying card type image that is added
			WebElement cardImage = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[contains(@class,'padding-right')]/img"));
			String imageType = cardImage.getAttribute("alt");
			if (!cardType.contains("tsc") && imageType.equalsIgnoreCase(cardType)) {
				//Checking the card expiration year now to verify it is same card that is added by user
				WebElement expiresOnWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//div[@class='table-cell']"));
				String expiresOnData = expiresOnWebElement.getText().split(":")[1];
				//Fetching input expiration month and year in required format
				inputExpirationData = this.formatExpirationDateForCreditCard(expirationMonth,expirationYear);
				if (expiresOnData.trim().equals(inputExpirationData)) {
					reporter.reportLog("Card Type: " + imageType + " and expiration year is same as added: " + expiresOnData);
					//Verifying Image Type and CardType is same that is displayed in application for user
					WebElement cardTypeWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
					String cardTypeDisplayed = cardTypeWebElement.getText();
					if (cardTypeDisplayed.equalsIgnoreCase(cardDisplayName)){
						//Verifying the card number added
						WebElement expiresWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/span"));
						value = this.verifyCardNumberAddedForUser(expiresWebElement,cardNumber,cardType);
						break;
					}
					else
						reporter.reportLogFailWithScreenshot("Card Type added is not same as expected: " + cardTypeDisplayed);
				}
			}else{
				WebElement cardTypeWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
				String cardTypeDisplayed = cardTypeWebElement.getText();
				if (cardTypeDisplayed.equalsIgnoreCase(cardDisplayName)){
					//Verifying the card number added
					WebElement expiresWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/span"));
					value = this.verifyCardNumberAddedForUser(expiresWebElement,cardNumber,cardType);
					break;
				}
			}
		}
		if(value)
			reporter.reportLogPass("Credit Card: "+cardNumber+" with type: "+cardType+" is added as expected for the user");
		else
			reporter.reportLogFailWithScreenshot("Credit Card: "+cardNumber+" with type: "+cardType+" is not added as expected for the user");

		//Remove Credit Card associated
		if(removeCard)
			this.removeCreditCardFromUser(cardType,cardNumber,inputExpirationData,true);
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
		/**
		if(cardType.equalsIgnoreCase("visa"))
			inputLastDigitsOfCard = cardNumber.substring(cardNumber.length()-3);
		else if(cardType.equalsIgnoreCase("master"))
			inputLastDigitsOfCard = cardNumber.substring(cardNumber.length()-4);
		*/
		inputLastDigitsOfCard = cardNumber.substring(cardNumber.length()-4);
		if(lastDigitsOfCard.equals(inputLastDigitsOfCard))
			return true;
		else
			return false;
	}

	/**
	 * This functions selects the credit card either for removal or for edit functionality
	 * @param - String - cardNumber
	 * @param - String - cardType
	 * @param - String - expirationMonthAndYear
	 */
	public void selectGivenCreditCard(String cardNumber, String cardType, String expirationMonthAndYear,boolean selectForRemove){
		int beforeDeleteCreditCardsPresent = lstCreditCardsPresent.size();
		WebElement expiresOnWebElement = null;
		WebElement removeButtonWebElement, editButtonWebElement;
		String expiresOnData = null;
		boolean value = false;
		for (int counter = 0; counter < beforeDeleteCreditCardsPresent; counter++) {
			WebElement cardImage = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[contains(@class,'padding-right')]/img"));
			String imageType = cardImage.getAttribute("alt");
			if(!imageType.toLowerCase().contains("tsc")){
				expiresOnWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//div[@class='table-cell']"));
				expiresOnData = expiresOnWebElement.getText().split(":")[1].trim();
				if (expiresOnData.trim().equals(expirationMonthAndYear)) {
					WebElement expiresWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/span"));
					value = this.verifyCardNumberAddedForUser(expiresWebElement,cardNumber,cardType);
					if(value){
						//Removing the matched Credit Card
						if(selectForRemove){
							removeButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallLeftPadding')]/a[contains(@class,'negative')]"));
							this.clickElement(removeButtonWebElement);
							waitForCondition(Driver->{return this.btnRemoveCreditCardButton.isDisplayed() &&
									this.btnRemoveCreditCardButton.isEnabled();},6000);
						}else{
							editButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')]"));
							this.clickElement(editButtonWebElement);
							waitForCondition(Driver->{return this.btnSaveAddCreditCardForNewCreditCard.isDisplayed() &&
									this.btnSaveAddCreditCardForNewCreditCard.isEnabled();},6000);
						}
						break;
					}
				}
			}else if(cardType.toLowerCase().contains("tsc")){
				if(selectForRemove){
					removeButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallLeftPadding')]/a[contains(@class,'negative')]"));
					this.clickElement(removeButtonWebElement);
					waitForCondition(Driver->{return this.btnRemoveCreditCardButton.isDisplayed() &&
							this.btnRemoveCreditCardButton.isEnabled();},6000);
				}else{
					editButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')]"));
					this.clickElement(editButtonWebElement);
					waitForCondition(Driver->{return this.btnSaveAddCreditCardForNewCreditCard.isDisplayed() &&
							this.btnSaveAddCreditCardForNewCreditCard.isEnabled();},6000);
				}
				break;
			}
		}
	}

	/**
	 * This function verifies card on remove popup
	 * @param - String - cardDetails
	 */
	public void verifyCardTypeAndNameOnRemove(String cardType, String cardNumber){
		String appCardDetails = this.lblCardNameOnRemovePopUp.getText().trim()+" "+this.lblCardNumberOnRemovePopUp.getText().trim();
		if(cardType.contains("amex"))
			cardType = "american express";
		if(appCardDetails.toLowerCase().contains(cardType.toLowerCase()) && appCardDetails.contains(cardNumber))
			reporter.reportLogPass("Card Number deleted is same as expected: "+appCardDetails);
		else
			reporter.reportLogFailWithScreenshot("Card Number that is deleted: "+appCardDetails+" is not as expected for type: "+cardType);
	}

	/**
	 * This functions removes provided Credit Card attached to user
	 * @param - String - cardType
	 * @param - String - cardNumber
	 * @param -String - expirationMonthAndYear
	 */
	public void removeCreditCardFromUser(String cardType, String cardNumber, String expirationMonthAndYear, boolean removeCard){
		int beforeDeleteCreditCardsPresent = lstCreditCardsPresent.size();
		this.selectGivenCreditCard(cardNumber,cardType,expirationMonthAndYear,true);
		if(removeCard){
			this.verifyCardTypeAndNameOnRemove(cardType,cardNumber.substring(cardNumber.length()-4));
			this.clickElement(this.btnRemoveCreditCardButton);
		}
		else
			this.clickElement(this.btnCancelRemoveCreditCardButton);
		//Verification that card is removed
		//Applying static wait for 5 seconds as application takes time to refresh and there is no unique element for wait for condition to be used
		getReusableActionsInstance().staticWait(5000);
		int afterDeleteCreditCardsPresent = lstCreditCardsPresent.size();
		boolean flag = removeCard == true ? afterDeleteCreditCardsPresent == beforeDeleteCreditCardsPresent-1 : afterDeleteCreditCardsPresent == beforeDeleteCreditCardsPresent;
		if(flag)
			reporter.reportLogPass("Credit Card: "+cardNumber+" of type: "+cardType+" is removed from user");
		else
			reporter.reportLogFailWithScreenshot("Credit Card: "+cardNumber+" of type: "+cardType+" is not removed from user");
	}

	/**
	 * This functions edits added Credit Card with user
	 * @param - String - cardType
	 * @param - String - cardNumber
	 * @param -String - expirationMonthAndYear
	 */
	public Map<String,String> editAndVerifyCreditCardAttachedToUser(String cardType, String cardDisplayName, String cardNumber, String expirationMonthAndYear, JSONObject creditCardsData, boolean editCard) throws ParseException {
		Map<String,String> cardData = new HashMap<>();
		if(cardType!=null){
			cardData.put("cardType",cardType);
			cardData.put("cardNumber",cardNumber);
			cardData.put("expirationMonthAndYear",expirationMonthAndYear);
			this.selectGivenCreditCard(cardNumber,cardType,expirationMonthAndYear,false);
		}else{
			cardData = this.getFirstCreditCardDetailsAndSelect();
			String cardTypeAdded = this.getCreditCardTypeName(cardData.get("cardType"));
			JSONObject creditCard = (JSONObject) creditCardsData.get(cardTypeAdded);
			cardNumber = creditCard.get("Number").toString();
			cardData.put("cardNumber",cardNumber);
		}
		this.addNewCreditCardNumber(cardNumber);

		if(expirationMonthAndYear!=null){
			String[] expirationData = expirationMonthAndYear.split("/");
			int updatedMonth = Integer.valueOf(expirationData[0])+1 > 12 ? (Integer.valueOf(expirationData[0]) + 1) - 12 : Integer.valueOf(expirationData[0])+1;
			int updatedYear = Integer.valueOf(expirationData[1])+1;
			cardData.put("expirationMonth",String.valueOf(updatedMonth));
			cardData.put("expirationYear",String.valueOf(updatedYear));
		}
		this.addExpirationMonthAndYear(cardData);

		if(editCard)
			this.clickElement(this.btnSaveAddCreditCardForNewCreditCard);
		else
			this.clickElement(this.btnCancelAddCreditCardForNewCreditCard);

		//Verification of Updated Data for Credit Card
		if(cardType!=null)
			this.verifyNewAddedCreditCardForUser(cardType,cardDisplayName,cardNumber,cardData.get("expirationMonth"),cardData.get("expirationYear"),false);
		else{
			if(editCard)
				this.verifyNewAddedCreditCardForUser(cardData.get("cardType"),cardData.get("cardDisplayName"),cardNumber,cardData.get("expirationMonth"),cardData.get("expirationYear"),false);
			else
				this.verifyNewAddedCreditCardForUser(cardData.get("cardType"),cardData.get("cardDisplayName"),cardNumber,cardData.get("actualExpirationMonth"),cardData.get("actualExpirationYear"),false);
		}
		return cardData;
	}

	/**
	 * This function selects first credit card displayed on Manage Screen by default when no Credit Card is provided
	 */
	public Map<String,String> getFirstCreditCardDetailsAndSelect() throws ParseException {
		Map<String,String> creditCardDisplayedData = new HashMap<>();
		String updatedMonth=null,updatedYear = null,actualExpirationMonth=null,actualExpirationYear=null;
		//Fetching Card Details to be edited to be used for verification
		WebElement cardTypeWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
		String cardType = cardTypeWebElement.getText();
		WebElement cardDisplayTypeWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
		String cardDisplayName = cardDisplayTypeWebElement.getText();
		if(!cardType.toLowerCase().contains("tsc")) {
			WebElement expiresOnWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//div[@class='table-cell']"));
			String[] expiresOnData = expiresOnWebElement.getText().split(":")[1].split("/");

			updatedMonth = Integer.valueOf(expiresOnData[0].trim())+1 > 12 ? String.valueOf((Integer.valueOf(expiresOnData[0].trim()) + 1) - 12) : String.valueOf(Integer.valueOf(expiresOnData[0].trim())+1);
			if(updatedMonth.length()==1)
				updatedMonth = "0"+updatedMonth;
			Map<String,String> updatedYearData = getNewCardExpirationData(2,0);
			updatedYear = updatedYearData.get("expirationYear");
			actualExpirationMonth = expiresOnData[0].trim();
			actualExpirationYear = expiresOnData[1].trim();

			creditCardDisplayedData.put("cardType", cardType);
			creditCardDisplayedData.put("cardDisplayName", cardDisplayName);
			creditCardDisplayedData.put("expirationMonth", updatedMonth);
			creditCardDisplayedData.put("expirationYear", updatedYear);
			creditCardDisplayedData.put("actualExpirationMonth", actualExpirationMonth);
			creditCardDisplayedData.put("actualExpirationYear", actualExpirationYear);
			creditCardDisplayedData.put("expirationMonthAndYear",actualExpirationMonth+"/"+actualExpirationYear);
		}

		WebElement editButtonWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')]"));
		this.clickElement(editButtonWebElement);
		//Wait for page load
		this.waitForPageToLoad();

		return creditCardDisplayedData;
	}

	/**
	 * This function clicks on Add New Credit Card section on Manage Credit Card Screen
	 */
	public void clickAddNewCreditCardOnManageCreditCardScreen(){
		this.clickElement(this.btnAddNewCreditCard);
		this.waitForPageToLoad();
		waitForCondition(Driver->{return this.btnCancelAddCreditCardForNewCreditCard.isEnabled() &&
				this.btnCancelAddCreditCardForNewCreditCard.isDisplayed();},12000);
	}

	/**
	 * This function fetches Credit Card type name on basis of displayed name on application
	 */
	public String getCreditCardTypeName(String displayName){
		if(displayName.toLowerCase().contains("visa"))
			return "visa";
		else if(displayName.toLowerCase().contains("tsc"))
			return "tsc";
		else if(displayName.toLowerCase().contains("american"))
			return "amex";
		else
			return "master";
	}

	/**
	 * This functions navigates to My Account page from breadcrumb
	 */
	public void navigateToMyAccountFromBreadCrumb(){
		this.clickElement(this.lnkBreadCrumbMyAccount);
		this.waitForPageToLoad();
		waitForCondition(Driver->{return this.lstpaymentOptions.size()>0 &&
				this.lstpaymentOptions.get(0).isEnabled();},6000);
	}

	/**
	 * This function verifies error message on passing invalid Credit Card Number
	 * @param - String - expectedErrorMessage
	 */
	public void verifyInvalidCreditCardErrorMessage(String expectedErrorMessage){
		waitForCondition(Driver->{return this.lblErrorMessageForInvalidCreditCardNumber.isDisplayed();},5000);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblErrorMessageForInvalidCreditCardNumber);
		String actualErrorMessage = this.lblErrorMessageForInvalidCreditCardNumber.getText().trim();
		if(actualErrorMessage.equalsIgnoreCase(expectedErrorMessage))
			reporter.reportLogPass("Error Message on passing invalid Card Number is as expected: "+actualErrorMessage);
		else
			reporter.reportLogFailWithScreenshot("Error Message on passing invalid Card Number :"+actualErrorMessage+" is not as expected: "+expectedErrorMessage);
	}
}
