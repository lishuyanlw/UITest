package com.tsc.pages;

import com.tsc.api.util.DataConverter;
import com.tsc.pages.base.BasePage;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class GuestCheckoutPage extends RegularCheckoutPage {

	public GuestCheckoutPage(WebDriver driver) {
		super(driver);
	}

	//For address
	@FindBy(xpath = "//div[@class='create-address__wrap']//form//span[@class='form__required']")
	public WebElement lblFormRequiredMessage;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@id='FirstNamelbl']")
	public WebElement lblFirstNameTitle;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='FirstName']")
	public WebElement inputFirstName;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@id='LastNamelbl']")
	public WebElement lblLastNameTitle;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='LastName']")
	public WebElement inputLastName;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@id='DayPhonelbl']")
	public WebElement lblPhoneNumberTitle;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='DayPhone']")
	public WebElement inputPhoneNumber;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@id='addresslbl']")
	public WebElement lblAddressLine1Title;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='address']")
	public WebElement inputAddressLine1;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//div[contains(@class,'react-autosuggest__suggestions-container')]")
	public WebElement cntAddressLine1DropdownMenuListContainer;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//ul//li")
	public List<WebElement> lstAddressLine1DropdownMenuList;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@id='AddressRef1lbl']")
	public WebElement lblAddressLine2Title;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='AddressRef1']")
	public WebElement inputAddressLine2;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//div[@class='hint']")
	public WebElement lblAddressLine2HintMessage;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@id='Citylbl']")
	public WebElement lblCityTitle;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='City']")
	public WebElement inputCity;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@for='State']")
	public WebElement lblProvinceTitle;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//select[@id='State']")
	public WebElement selectProvince;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@id='ZipCodelbl']")
	public WebElement lblPostalCodeTitle;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='ZipCode']")
	public WebElement inputPostalCode;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@id='Emaillbl']")
	public WebElement lblEmailTitle;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='Email']")
	public WebElement inputEmail;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//div[normalize-space(text())='We need this email to communicate to you about your order.']")
	public WebElement lblEmailHintMessage;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@for='Offers']")
	public WebElement labelEmailSignup;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='Offers']")
	public WebElement ckbEmailSignup;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@for='CreateAccount']")
	public WebElement labelEmailCreateAccount;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='CreateAccount']")
	public WebElement ckbEmailCreateAccount;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@id='Passwordlbl']")
	public WebElement lblPasswordTitle;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='Password']")
	public WebElement inputPassword;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='Password']/following-sibling::button")
	public WebElement btnPasswordShow;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//div[@class='password__right']/div[not(contains(@class,'password__tooltip--msg'))]")
	public WebElement iconPasswordHintMessage;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//div[@class='password__right']")
	public WebElement cntPasswordTooltipMessage;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//div[@class='password__right']/div[contains(@class,'password__tooltip--msg')]")
	public WebElement lblPasswordTooltipMessage;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='Password']/following-sibling::div[contains(@class,'alert-danger')]")
	public WebElement lblPasswordWarningMessage;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//label[@id='Password2lbl']")
	public WebElement lblConfirmPasswordTitle;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='Password2']")
	public WebElement inputConfirmPassword;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='Password2']/following-sibling::button")
	public WebElement btnConfirmPasswordShow;

	@FindBy(xpath = "//div[@class='create-address__wrap']//form//input[@id='Password2']/following-sibling::div[contains(@class,'alert-danger')]")
	public WebElement lblConfirmPasswordWarningMessage;

	@FindBy(xpath = "//div[@id='recaptchaId']//div[@class='grecaptcha-badge']")
	public WebElement imgRecaptchaLogo;

	//Error Message for Mandatory Items
	@FindBy(xpath = "//div[@class='create-address__wrap']//div[contains(@class,'alert-danger')]")
	public List<WebElement> mandatoryFieldErrorMessage;

	@FindBy(xpath = "//aside[@class='rightSide']//button[contains(@class,'placeorder')]")
	public WebElement btnContinueToPayment;

	//For express checkout payment
	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='card__header']")
	public WebElement lblUsingANewCardSelectTitle;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='creditcard__selector--cc']")
	public WebElement cntUsingANewCardDialogCreditCard;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='creditcard__selector--cc']//input")
	public WebElement inputUsingANewCardDialogCreditCardRadio;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='creditcard__selector--cc']//label")
	public WebElement labelUsingANewCardDialogCreditCardRadio;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='creditcard__selector--tsc']")
	public WebElement cntUsingANewCardDialogTSCCard;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='creditcard__selector--tsc']//input")
	public WebElement inputUsingANewCardDialogTSCCardRadio;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='creditcard__selector--tsc']//label")
	public WebElement labelUsingANewCardDialogTSCCardRadio;

	//For Credit card
	@FindBy(xpath = "//span[@id='semafoneResponseSpan']")
	public WebElement lblInvalidCreditCardErrorMessage;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='standardCCBlock']//h3[@class='semafone__cardnumber']")
	public WebElement lblUsingANewCardDialogCreditCardNumberTitle;

	@FindBy(xpath = "//div[@class='standardCCBlock']//iframe")
	public WebElement iframeUsingANewCardDialogCreditCardNumberInput;

	//The Credit card number input field in iframeUsingANewCardDialogCardNumberInput
	@FindBy(xpath = "//input[@id='pan']")
	public WebElement inputCreditCardNumberInIframe;

	@FindBy(xpath = "//input[@id='maskedPan']")
	public WebElement inputCreditCardMaskNumberInIframe;

	@FindBy(xpath = "//div[contains(@id,'CCNumberSemafone')]/input[@id='selectedNonTscCC']")
	public WebElement inputEditExistingCreditCard;

	@FindBy(xpath = "//div[@class='card__logo--verify']//*[contains(@class,'tagCCImage')]")
	public WebElement lblInputCreditCardNumberType;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='standardCCBlock']//h3[@class='semafone__expiration-title']")
	public WebElement lblUsingANewCardDialogCreditExpirationDateTitle;

	@FindBy(xpath = "//div[@class='standardCCBlock']//input[@id='creditCardMonthId']")
	public WebElement inputUsingANewCardDialogCreditExpirationDateMonth;

	@FindBy(xpath = "//div[@class='standardCCBlock']//input[@id='creditCardYearId']")
	public WebElement inputUsingANewCardDialogCreditExpirationDateYear;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='standardCCBlock']//span[@class='semafone__expiration-title']")
	public WebElement lblUsingANewCardDialogCreditExpirationDateSlashBetweenMonthAndYear;

	//For TSC card
	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='tscBlock']//h3[@class='semafone__cardnumber']")
	public WebElement lblUsingANewCardDialogTSCCardNumberTitle;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[@class='tscBlock']//input[@id='tscCC']")
	public WebElement inputUsingANewCardDialogTSCCardNumber;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[contains(@class,'selector__paypal')]//input[@id='tscPaypal']")
	public WebElement inputUsingANewCardDialogPaypalRadio;

	@FindBy(xpath = "//div[@class='create-payment__wrap']//div[contains(@class,'selector__paypal')]//label")
	public WebElement labelAddOrChangePaymentMethodDialogPaypalRadio;

	@FindBy(xpath = "//aside[@class='rightSide']//button[@data-link-title='continue to review']")
	public WebElement btnContinueToReview;

	//For footer
	@FindBy(xpath = "//footer")
	public WebElement cntFooterContainer;

	/**
	 * To check Password Tooltip Message Displaying
	 * @return - boolean
	 */
	public boolean checkPasswordTooltipMessageDisplaying(){
		return this.checkChildElementExistingByAttribute(this.cntPasswordTooltipMessage,"class","password__tooltip--msg");
	}

	/**
	 * To create a new account
	 * @param - String - lsEmail - generated automatically if pass null
	 * @param - String - lsPassword - generated automatically if pass null
	 * @param - boolean - bSave - true for clicking save button and false for clicking cancel button
	 * @return - Map<String,Object> - including email and password
	 */
	public Map<String,Object> createNewAccount(String lsEmail,String lsPassword,boolean bCreateAccount){
		String lsFirstName= DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(5,"lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputFirstName);
		inputFirstName.clear();
		inputFirstName.sendKeys(lsFirstName);
		this.getReusableActionsInstance().staticWait(300);

		String lsLastName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(7,"lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputLastName);
		inputLastName.clear();
		inputLastName.sendKeys(lsLastName);
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddressLine1);
		inputAddressLine1.clear();
		String lsAutoSearchKeyword = DataConverter.getSaltString(4,"numberType");
		String[] data = lsAutoSearchKeyword.codePoints().mapToObj(cp->new String(Character.toChars(cp))).toArray(size->new String[size]);
		int sum=0;
		for(String inputText:data){
			if(sum>=30){
				break;
			}
			inputAddressLine1.sendKeys(inputText);
			//For thinking time for waiting for backend response
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			sum++;
		}
		this.waitForCondition(Driver->{return this.cntAddressLine1DropdownMenuListContainer.getAttribute("class").contains("react-autosuggest__suggestions-container--open");},20000);
		this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());

		if(lstAddressLine1DropdownMenuList.size()>1){
			reporter.reportLogPass("Getting dropdown auto search results successfully");
		}
		else{
			reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
		}

		int optionSize=this.lstAddressLine1DropdownMenuList.size();
		int randomNumber;
		if(optionSize==1){
			randomNumber=0;
		}
		else{
			Random rand = new Random();
			randomNumber = rand.nextInt(optionSize-2);
		}
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddressLine1DropdownMenuList.get(randomNumber));
		this.getReusableActionsInstance().clickIfAvailable(this.lstAddressLine1DropdownMenuList.get(randomNumber));
		this.waitForCondition(Driver->{return !this.cntAddressLine1DropdownMenuListContainer.getAttribute("class").contains("react-autosuggest__suggestions-container--open");},20000);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		String lsPhoneNumber="647"+DataConverter.getSaltString(7,"numberType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPhoneNumber);
		inputPhoneNumber.clear();
		inputPhoneNumber.sendKeys(lsPhoneNumber);
		this.getReusableActionsInstance().staticWait(300);

		if(lsEmail==null){
			lsEmail=DataConverter.getSaltString(4,"lowerStringType")+DataConverter.getSaltString(4,"numberType")+"@rogers.com";
		}
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputEmail);
		inputEmail.clear();
		inputEmail.sendKeys(lsEmail);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		if(bCreateAccount){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbEmailCreateAccount);
			if(!ckbEmailCreateAccount.isSelected()){
				labelEmailCreateAccount.click();
			}
			this.getReusableActionsInstance().staticWait(300);

			if(lsPassword==null){
				lsPassword=DataConverter.getSaltString(2,"lowerStringType")+DataConverter.getSaltString(4,"numberType")+"@rogers.com";
			}
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPassword);
			inputPassword.clear();
			inputPassword.sendKeys(lsPassword);
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputConfirmPassword);
			inputConfirmPassword.clear();
			inputConfirmPassword.sendKeys(lsPassword);
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbEmailCreateAccount);
			if(ckbEmailCreateAccount.isSelected()){
				labelEmailCreateAccount.click();
			}
			this.getReusableActionsInstance().staticWait(300);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddressLine1);
		String lsAddress=inputAddressLine1.getAttribute("value").trim();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectProvince);
		Select select=new Select(this.selectProvince);
		String lsProvince=select.getFirstSelectedOption().getText().trim();
		String lsOptionAbbreviatedText="",lsOptionText;
		List<WebElement> lstProvince=select.getOptions();
		for(WebElement item:lstProvince){
			lsOptionAbbreviatedText=item.getAttribute("value").trim();
			lsOptionText=this.getElementInnerText(item).trim();
			if(lsProvince.equalsIgnoreCase(lsOptionText)){
				break;
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputCity);
		String lsCity=this.inputCity.getAttribute("value").trim();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPostalCode);
		String lsPostalCode=this.inputPostalCode.getAttribute("value").trim();

		Map<String,Object> map=new HashMap<>();
		map.put("email",lsEmail);

		if(bCreateAccount){
			map.put("password",lsPassword);
		}
		else{
			map.put("password",null);
		}

		map.put("firstName",lsFirstName);
		map.put("lastName",lsLastName);
		map.put("phoneNumber",lsPhoneNumber);
		map.put("address",lsAddress);
		map.put("city",lsCity);
		map.put("province",lsProvince);
		map.put("abbreviatedProvince",lsOptionAbbreviatedText);
		map.put("postalCode",lsPostalCode);

		return map;
	}

	@Override
	public void verifyMandatoryContentsForCheckoutProductList() {
		String lsText;
		WebElement item;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCollapseProductList);
		lsText = btnCollapseProductList.getText().trim();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The product list collapse button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The product list collapse button is not displaying correctly");
		}

		for (WebElement productItem : this.lstProductList) {
			if (this.checkProductBadgeExisting(productItem)) {
				item = productItem.findElement(this.byProductBadge);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if (this.getReusableActionsInstance().isElementVisible(item)) {
					reporter.reportLogPass("The product badge is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product badge is not displaying correctly");
				}
			}

			item = productItem.findElement(byProductItemDesc);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product description is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product description is not displaying correctly");
			}

			if(this.checkProductNumberExisting(productItem)){
				item = productItem.findElement(byProductNumber);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText = item.getText().replace("-", "").trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The product number is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product number is not displaying correctly");
				}
			}

			item = productItem.findElement(byProductNowPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product nowPrice is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product nowPrice is not displaying correctly");
			}

			item=productItem.findElement(byProductSelectQuantity);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=this.getElementInnerText(item).split(":")[1].trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product quantity is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product quantity is not displaying correctly");
			}
		}
	}

	@Override
	public void verifyOptionalContentsForCheckoutProductList() {
		String lsText;
		WebElement item;

		if(this.checkAlertMessageInHeaderExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAlertMessage);
			lsText = this.lblAlertMessage.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The alert message in header is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The alert message in header is not displaying correctly");
			}
		}

		for(WebElement productItem:this.lstProductList){
			if(this.checkProductInventoryExisting(productItem)){
				item=productItem.findElement(byProductInventory);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText=item.getText().trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The product Inventory is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product Inventory is not displaying correctly");
				}
			}

			if(this.checkProductFreeShippingExisting(productItem)){
				item=productItem.findElement(byProductFreeShipping);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText=item.getText().trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The product Free Shipping is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product Free Shipping is not displaying correctly");
				}
			}
		}
	}

	/**
	 * To verify address elements existing
	 */
	public void verifyAddressContents(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblFormRequiredMessage);
		lsText=lblFormRequiredMessage.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The required field info is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The required field info is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblFirstNameTitle);
		lsText=lblFirstNameTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The FirstName Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The FirstName Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputFirstName);
		if(this.getReusableActionsInstance().isElementVisible(inputFirstName)){
			reporter.reportLogPass("The FirstName input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The FirstName input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblLastNameTitle);
		lsText=lblLastNameTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The LastName Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The LastName Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputLastName);
		if(this.getReusableActionsInstance().isElementVisible(inputLastName)){
			reporter.reportLogPass("The LastName input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The LastName input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddressLine1Title);
		lsText=lblAddressLine1Title.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The AddressLine1 Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The AddressLine1 Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddressLine1);
		if(this.getReusableActionsInstance().isElementVisible(inputAddressLine1)){
			reporter.reportLogPass("The AddressLine1 input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The AddressLine1 input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddressLine2Title);
		lsText=lblAddressLine2Title.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The AddressLine2 Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The AddressLine2 Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddressLine2);
		if(this.getReusableActionsInstance().isElementVisible(inputAddressLine2)){
			reporter.reportLogPass("The AddressLine2 input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The AddressLine2 input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCityTitle);
		lsText=lblCityTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The City Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The City Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputCity);
		if(this.getReusableActionsInstance().isElementVisible(inputCity)){
			reporter.reportLogPass("The City input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The City input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblProvinceTitle);
		lsText=lblProvinceTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Province Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Province Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectProvince);
		if(this.getReusableActionsInstance().isElementVisible(selectProvince)){
			reporter.reportLogPass("The select Province is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The select Province is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPostalCodeTitle);
		lsText=lblPostalCodeTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The PostalCode Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The PostalCode Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPostalCode);
		if(this.getReusableActionsInstance().isElementVisible(inputPostalCode)){
			reporter.reportLogPass("The PostalCode input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The PostalCode input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPhoneNumberTitle);
		lsText=lblPhoneNumberTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The PhoneNumber Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The PhoneNumber Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPhoneNumber);
		if(this.getReusableActionsInstance().isElementVisible(inputPhoneNumber)){
			reporter.reportLogPass("The PhoneNumber input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The PhoneNumber input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblEmailTitle);
		lsText=lblEmailTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Email Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Email Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputEmail);
		if(this.getReusableActionsInstance().isElementVisible(inputEmail)){
			reporter.reportLogPass("The Email input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Email input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblEmailHintMessage);
		lsText=lblEmailHintMessage.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Email Explanation is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Email Explanation is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelEmailSignup);
		lsText=labelEmailSignup.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Email Signup info is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Email Signup info is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelEmailCreateAccount);
		lsText=labelEmailCreateAccount.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Email Create Account info is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Email Create Account info is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPasswordTitle);
		lsText=lblPasswordTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The password title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The password title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPassword);
		if(this.getReusableActionsInstance().isElementVisible(inputPassword)){
			reporter.reportLogPass("The password input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The password input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnPasswordShow);
		if(this.getReusableActionsInstance().isElementVisible(btnPasswordShow)){
			reporter.reportLogPass("The password show button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The password show button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconPasswordHintMessage);
		if(this.getReusableActionsInstance().isElementVisible(iconPasswordHintMessage)){
			reporter.reportLogPass("The icon for password hint message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The icon for password hint message is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblConfirmPasswordTitle);
		lsText=lblConfirmPasswordTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Confirm password title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Confirm password title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputConfirmPassword);
		if(this.getReusableActionsInstance().isElementVisible(inputConfirmPassword)){
			reporter.reportLogPass("The Confirm password input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Confirm password input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnConfirmPasswordShow);
		if(this.getReusableActionsInstance().isElementVisible(btnConfirmPasswordShow)){
			reporter.reportLogPass("The Confirm password show button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Confirm password show button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imgRecaptchaLogo);
		if(this.getReusableActionsInstance().isElementVisible(imgRecaptchaLogo)){
			reporter.reportLogPass("The Recaptcha Logo is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Recaptcha Logo is not displaying correctly");
		}
	}

	/**
	 * To verify Tooltip Window For Password Hint Message
	 */
	public void verifyTooltipWindowForPasswordHintMessage(){
		String lsText;

		this.getReusableActionsInstance().scrollToElement(iconPasswordHintMessage);
		this.waitForCondition(Driver->{return checkPasswordTooltipMessageDisplaying();},10000);
		this.applyStaticWait(this.getStaticWaitForApplication());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPasswordTooltipMessage);
		lsText=lblPasswordTooltipMessage.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Tooltip for password hint message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Tooltip for password hint message is not displaying correctly");
		}
	}

	/**
	 * To verify Continue To Payment Button
	 */
	public void verifyContinueToPaymentButton() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnContinueToPayment);
		lsText = this.btnContinueToPayment.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Continue To Payment button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Continue To Payment button is not displaying correctly");
		}
	}

	/**
	 * To go to payment page
	 */
	public void goToPaymentPage(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnContinueToPayment);
		this.clickElement(btnContinueToPayment);
		this.applyStaticWait(this.getStaticWaitForApplication());

		try{
			this.waitForCondition(Driver->{return !this.checkChildElementExistingByAttribute(this.cntFooterContainer,"class","loading__overlay");},120000);
		}
		catch (Exception e){
			this.applyStaticWait(10*this.getStaticWaitForApplication());
		}

		this.waitForCondition(Driver->{return lblUsingANewCardSelectTitle.isDisplayed();},120000);
		this.applyStaticWait(3*this.getStaticWaitForApplication());
	}

	/**
	 * To add a new TSC card
	 */
	public void addNewTSCCard(){
		JSONObject cardData=this.getCardDataFromYamlFile("tsc");
		String TSCCardNumber= (String) cardData.get("Number");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogTSCCardRadio);
		this.clickElement(labelUsingANewCardDialogTSCCardRadio);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogTSCCardNumber);
		inputUsingANewCardDialogTSCCardNumber.clear();
		inputUsingANewCardDialogTSCCardNumber.sendKeys(TSCCardNumber);
	}

	/**
	 * To add a new Credit card
	 * @param - String - creditCardType
	 * @return - Map<String,String> - including cardType and cardNumber
	 */
	public Map<String,Object> addNewCreditOrEditExistingCard(String creditCardType){
		JSONObject cardData=this.getCardDataFromYamlFile(creditCardType);
		String cardNumber= (String) cardData.get("Number");
		String expiredMonth=(String) cardData.get("DisplayExpirationMonth");
		String expiredYear=(String) cardData.get("DisplayExpirationYear");

		Map<String,Object> map=new HashMap<>();
		map.put("cardType",creditCardType);
		map.put("cardNumber",cardNumber);

		if(!creditCardType.equalsIgnoreCase("tsc")){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogCreditCardRadio);
			this.clickElement(labelUsingANewCardDialogCreditCardRadio);

			this.getDriver().switchTo().frame(iframeUsingANewCardDialogCreditCardNumberInput);
			try{
				this.waitForCondition(Driver->{return this.inputCreditCardNumberInIframe.isEnabled() &&
						this.inputCreditCardNumberInIframe.isDisplayed();},10000);
			}catch (Exception e){
				this.applyStaticWait(6000);
			}
			//Using static wait as Sauce Lab sometimes take time to load and behaviour is in-consistent
			this.applyStaticWait(3000);
			if(inputCreditCardNumberInIframe.getAttribute("style").contains("display: inline")){
				inputCreditCardNumberInIframe.clear();
				inputCreditCardNumberInIframe.sendKeys(cardNumber);
			}
			else{
				inputCreditCardMaskNumberInIframe.click();
				this.applyStaticWait(this.getStaticWaitForApplication());
				inputCreditCardNumberInIframe.sendKeys(cardNumber);
			}
			this.getDriver().switchTo().defaultContent();

			String cardType = this.getInputCreditCardNumberType();
			if(cardType.equalsIgnoreCase(creditCardType))
				reporter.reportLogPass("Selected Credit Card : "+creditCardType+" image is displayed as expected");
			else
				reporter.reportLogFailWithScreenshot("Selected Credit Card : "+creditCardType+" not image is displayed as expected");

			this.waitForCondition(Driver->{return !lblInputCreditCardNumberType.getAttribute("class").trim().isEmpty();},15000);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateMonth);
			inputUsingANewCardDialogCreditExpirationDateMonth.clear();
			inputUsingANewCardDialogCreditExpirationDateMonth.sendKeys(expiredMonth);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateYear);
			inputUsingANewCardDialogCreditExpirationDateYear.clear();
			inputUsingANewCardDialogCreditExpirationDateYear.sendKeys(expiredYear.substring(2));
		}else {
			this.addNewTSCCard();
		}

		return map;
	}

	/**
	 * This function verifies addition of invalid credit card error message
	 * @param - String - cardNumber - invalid credit card number
	 * @param - String - expectedErrorMessage
	 */
	public void addAndVerifyInvalidCardErrorMessage(String cardNumber,String expectedErrorMessage){
		this.clickWebElementUsingJS(this.inputUsingANewCardDialogCreditCardRadio);
		this.waitForCondition(Driver->{return this.lblUsingANewCardSelectTitle.getText().trim().toLowerCase().contains("card type");},5000);
		this.getDriver().switchTo().frame(iframeUsingANewCardDialogCreditCardNumberInput);
		inputCreditCardNumberInIframe.clear();
		inputCreditCardNumberInIframe.sendKeys(cardNumber);
		this.getDriver().switchTo().defaultContent();
		this.waitForCondition(Driver->{return !this.lblInvalidCreditCardErrorMessage.getText().isEmpty();},5000);
		String errorMessage = this.lblInvalidCreditCardErrorMessage.getText();
		if(errorMessage.equalsIgnoreCase(expectedErrorMessage))
			reporter.reportLogPass("Invalid Credit Card Error Message is as expected: "+errorMessage);
		else
			reporter.reportLogFailWithScreenshot("Invalid Credit Card Error Message is not as expected: "+errorMessage);
	}

	/**
	 * To get Input Credit Card Number Type
	 * @return - String - "Visa"/"MC"/"Amex"
	 */
	public String getInputCreditCardNumberType(){
		//Applying static wait as on repeated use, stale element exception is coming for browser
		this.applyStaticWait(2000);
		this.waitForCondition(Driver->{return !lblInputCreditCardNumberType.getAttribute("class").trim().isEmpty();},15000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInputCreditCardNumberType);
		String lsCreditCardClass=lblInputCreditCardNumberType.getAttribute("class").trim();
		if(lsCreditCardClass.contains(" ")){
			String[] lstCreditCardClass=lsCreditCardClass.split(" ");
			for(String lsClass:lstCreditCardClass){
				if(lsClass.contains("tagCCImage")){
					if(lsClass.contains("Visa")){
						return "visa";
					}

					if(lsClass.contains("MC")){
						return "master";
					}

					if(lsClass.contains("Amex")){
						return "amex";
					}
				}
			}
		}
		else{
			if(lsCreditCardClass.contains("Visa")){
				return "visa";
			}

			if(lsCreditCardClass.contains("MC")){
				return "master";
			}

			if(lsCreditCardClass.contains("Amex")){
				return "amex";
			}
		}
		return null;
	}

	/**
	 * To verify adding New card Contents
	 */
	public void verifyAddingNewCardContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblUsingANewCardSelectTitle);
		lsText = lblUsingANewCardSelectTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Select Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Select Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditCardRadio);
		if(this.inputUsingANewCardDialogCreditCardRadio.isEnabled()){
			reporter.reportLogPass("The CreditCard Radio button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The CreditCard Radio button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogCreditCardRadio);
		if(this.getReusableActionsInstance().isElementVisible(labelUsingANewCardDialogCreditCardRadio)){
			reporter.reportLogPass("The CreditCard Radio button label is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The CreditCard Radio button label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblUsingANewCardDialogCreditCardNumberTitle);
		lsText = lblUsingANewCardDialogCreditCardNumberTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The CreditCard Number Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The CreditCard Number Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iframeUsingANewCardDialogCreditCardNumberInput);
		if(this.getReusableActionsInstance().isElementVisible(iframeUsingANewCardDialogCreditCardNumberInput)){
			reporter.reportLogPass("The CreditCard Number Input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The CreditCard Number Input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblUsingANewCardDialogCreditExpirationDateTitle);
		lsText = lblUsingANewCardDialogCreditExpirationDateTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The CreditCard Expiration Date Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The CreditCard Expiration Date Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateMonth);
		if(this.getReusableActionsInstance().isElementVisible(inputUsingANewCardDialogCreditExpirationDateMonth)){
			reporter.reportLogPass("The CreditCard Expiration Date Month Input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The CreditCard Expiration Date Month Input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateYear);
		if(this.getReusableActionsInstance().isElementVisible(inputUsingANewCardDialogCreditExpirationDateYear)){
			reporter.reportLogPass("The CreditCard Expiration Date Year Input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The CreditCard Expiration Date Year Input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogTSCCardRadio);
		this.clickElement(labelUsingANewCardDialogTSCCardRadio);
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogTSCCardRadio);
		if(this.inputUsingANewCardDialogTSCCardRadio.isEnabled()){
			reporter.reportLogPass("The TSC Radio button label is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The TSC Radio button label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogTSCCardRadio);
		if(this.getReusableActionsInstance().isElementVisible(labelUsingANewCardDialogTSCCardRadio)){
			reporter.reportLogPass("The TSC Radio button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The TSC Radio button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblUsingANewCardDialogTSCCardNumberTitle);
		lsText = lblUsingANewCardDialogTSCCardNumberTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The TSCCard Number Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The TSCCard Number Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogTSCCardNumber);
		if(this.getReusableActionsInstance().isElementVisible(inputUsingANewCardDialogTSCCardNumber)){
			reporter.reportLogPass("The TSCCard Number Input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The TSCCard Number Input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogPaypalRadio);
		if(this.inputUsingANewCardDialogPaypalRadio.isEnabled()){
			reporter.reportLogPass("The Paypal Radio button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Paypal Radio button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrChangePaymentMethodDialogPaypalRadio);
		if(this.getReusableActionsInstance().isElementVisible(labelAddOrChangePaymentMethodDialogPaypalRadio)){
			reporter.reportLogPass("The Paypal Radio button label is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Paypal Radio button label is not displaying correctly");
		}
	}

	/**
	 * To verify Gift Card And Continue To Review Button Contents
	 */
	public void verifyGiftCardAndContinueToReviewButtonContents() {
		String lsText;

		this.scrollWindowDown(this.getDriver(),10000);
		this.applyStaticWait(2000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryGiftCardTitle);
		lsText = lblOrderSummaryGiftCardTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Gift Card Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Gift Card Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryGiftCardNumber);
		if(this.getReusableActionsInstance().isElementVisible(inputOrderSummaryGiftCardNumber)){
			reporter.reportLogPass("The OrderSummary GiftCard Number input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The OrderSummary GiftCard Number input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryGiftCardPinTitle);
		lsText = lblOrderSummaryGiftCardPinTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Gift Card pin Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Gift Card pin Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryGiftCardPin);
		if(this.getReusableActionsInstance().isElementVisible(inputOrderSummaryGiftCardPin)){
			reporter.reportLogPass("The OrderSummary GiftCard pin input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The OrderSummary GiftCard pin input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnContinueToReview);
		lsText = btnContinueToReview.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Continue To Review button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Continue To Review button is not displaying correctly");
		}
	}

	/**
	 * To go to review page
	 */
	public void goToReviewPage(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnContinueToReview);
		this.clickElement(btnContinueToReview);

		this.applyStaticWait(this.getStaticWaitForApplication());
		try{
			this.waitForCondition(Driver->{return !this.checkChildElementExistingByAttribute(this.cntFooterContainer,"class","loading__overlay");},120000);
		}
		catch (Exception e){
			this.applyStaticWait(5*this.getStaticWaitForApplication());
		}
		this.waitForCondition(Driver->{return btnOrderSummaryPlaceOrder.isDisplayed();},15000);
		this.applyStaticWait(3*this.getStaticWaitForApplication());
	}

	/**
	 * This function fetches error message from Shipping Address section
	 * @return - List<String> of error message displayed on screen
	 */
	public List<String> getMandatoryFieldsErrorMessage(int expectedErrorMessage){
		if(expectedErrorMessage==0)
			this.waitForCondition(Driver->{return this.mandatoryFieldErrorMessage.size()>0;},15000);
		else
			this.waitForCondition(Driver->{return this.mandatoryFieldErrorMessage.size()==expectedErrorMessage;},15000);
		int loop = this.mandatoryFieldErrorMessage.size();
		if(loop>0){
			List<String> errorMessageList = new ArrayList<>();
			for(int counter=0;counter<loop;counter++){
				errorMessageList.add(this.mandatoryFieldErrorMessage.get(counter).getText());
			}
			return errorMessageList;
		}else
			return null;
	}

	/**
	 * This function verifies error message on Shipping Address section with expected error message
	 * @param  - List<String> - expectedErrorMessageList
	 * @return - boolean
	 */
	public void verifyErrorMessageOnShippingAddressSection(List<String> expectedErrorMessageList){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnContinueToPayment);
		this.getReusableActionsInstance().clickIfAvailable(this.btnContinueToPayment);

		List<String> errorMessageList = this.getMandatoryFieldsErrorMessage(expectedErrorMessageList.size());
		if(errorMessageList.size()==expectedErrorMessageList.size()){
			for(String errorMessage:errorMessageList){
				if(expectedErrorMessageList.contains(errorMessage)){
					reporter.reportLogPass("Error message as expected is displayed : "+errorMessage);
				}else
					reporter.reportLogFailWithScreenshot("Error Message as expected is not displayed: "+errorMessage);
			}
		}else{
			reporter.reportLogFailWithScreenshot("Expected Error Message list size: "+expectedErrorMessageList.size()+" is not same as Actual Error Message list size: "+errorMessageList.size());
		}
	}

	/**
	 * To verify created shipping address linkage with checkout page
	 * @param - Map<String,Object> - shippingAddress object
	 * @return
	 */
	public void verifyCreatedShippingAddressLinkageWithCheckoutPage(Map<String,Object> shippingAddress){
		String selectedAddress = this.getElementInnerText(lblShippingAddress).replace("-","").toLowerCase();
		if(selectedAddress.contains(shippingAddress.get("address").toString().toLowerCase().replace("-","")) &&
				selectedAddress.contains(shippingAddress.get("firstName").toString().toLowerCase().replace("-","")) &&
				selectedAddress.contains(shippingAddress.get("lastName").toString().toLowerCase().replace("-","")) &&
				selectedAddress.contains(shippingAddress.get("phoneNumber").toString().toLowerCase().replace("-","")) &&
				selectedAddress.contains(shippingAddress.get("city").toString().toLowerCase().replace("-","")) &&
				selectedAddress.contains(shippingAddress.get("abbreviatedProvince").toString().toLowerCase().replace("-","")) &&
				selectedAddress.contains(shippingAddress.get("postalCode").toString().toLowerCase().replace(" ","")))
			reporter.reportLogPass("The created shipping address is same as expected one on checkout page");
		else
			reporter.reportLogFailWithScreenshot("The created shipping address is not same as the one on checkout page: "+selectedAddress);
	}

	/**
	 * To verify payment linkage With Checkout Page
	 * @param - Map<String,Object> - payment object
	 * @return
	 */
	public void verifyPaymentLinkageWithCheckoutPage(Map<String,Object> createdPaymentMap,Map<String,Object> paymentMapOnCheckout){
		String cardTypeCreated=createdPaymentMap.get("cardType").toString();
		String cardNumberCreated=createdPaymentMap.get("cardNumber").toString();
		String cardTypeCheckout=paymentMapOnCheckout.get("paymentMethod").toString();
		String cardNumberCheckout= String.valueOf(this.getIntegerFromString(paymentMapOnCheckout.get("paymentMethodDescription").toString()));
		if(cardTypeCreated.equalsIgnoreCase(cardTypeCheckout)&&cardNumberCreated.contains(cardNumberCheckout))
			reporter.reportLogPass("The created payment is same as expected one on checkout page");
		else
			reporter.reportLogFailWithScreenshot("The created payment is not same as the one on checkout page");
	}

	/**
	 * This function verifies input credit card type image on screen
	 * @param - String - creditCardType
	 */
	public void verifyInputCreditCardType(String creditCardType){
		String cardImageType = this.getInputCreditCardNumberType();
		if(cardImageType.equalsIgnoreCase(creditCardType))
			reporter.reportLogPass("Credit Card Added of type: "+creditCardType+" displays image as expected");
		else
			reporter.reportLogFailWithScreenshot("Credit Card Added of type: "+creditCardType+" doesn't display image as expected: "+cardImageType);
	}

}
