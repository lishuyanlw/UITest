package com.tsc.pages;

import com.tsc.api.util.DataConverter;
import com.tsc.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TransferPhoneAccountPage extends BasePage {

	public TransferPhoneAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//create-phone-account-app//a[contains(@href,'signin')]")
	public WebElement lblBackToSignIn;

	@FindBy(xpath = "//create-phone-account-app//div[@class='form-head']//h2")
	public WebElement lblHeaderTitle;

	@FindBy(xpath = "//create-phone-account-app//div[@class='form-head']//span")
	public WebElement lblSubHeaderTitle;

	@FindBy(xpath = "//create-phone-account-app//div[@class='form-head']//span")
	public WebElement lblCustomerNumberTitle;

	@FindBy(xpath = "//create-phone-account-app//form//label[@for='customerNumber']/following-sibling::p[@class='about-input']")
	public WebElement lblCustomerNumberInputDescription;

	@FindBy(xpath = "//create-phone-account-app//form//input[@id='customerNumber']")
	public WebElement inputCustomerNumber;

	@FindBy(xpath = "//create-phone-account-app//form//label[normalize-space(text())='Phone Number']")
	public WebElement lblPhoneNumberTitle;

	@FindBy(xpath = "//create-phone-account-app//form//input[@formcontrolname='phoneNumber1']/preceding-sibling::p[@class='about-input']")
	public WebElement lblPhoneNumberInputDescription;

	@FindBy(xpath = "//create-phone-account-app//form//input[@formcontrolname='phoneNumber1']")
	public WebElement inputPhoneNumber1;

	@FindBy(xpath = "//create-phone-account-app//form//input[@formcontrolname='phoneNumber2']")
	public WebElement inputPhoneNumber2;

	@FindBy(xpath = "//create-phone-account-app//form//input[@formcontrolname='phoneNumber3']")
	public WebElement inputPhoneNumber3;

	@FindBy(xpath = "//create-phone-account-app//form//label[normalize-space(text())='Email Address']")
	public WebElement lblEmailTitle;

	@FindBy(xpath = "//create-phone-account-app//form//input[@id='email']")
	public WebElement inputEmail;

	@FindBy(xpath = "//create-phone-account-app//form//input[@id='isAgreeForSignup']")
	public WebElement ckbAgreeForSignupInput;

	@FindBy(xpath = "//create-phone-account-app//form//label[@for='isAgreeForSignup']")
	public WebElement LabelAgreeForSignupCheckbox;

	@FindBy(xpath = "//create-phone-account-app//form//div[@class='tsc-checkbox']//span")
	public WebElement lblAgreeForSignupCheckboxDescription;

	@FindBy(xpath = "//create-phone-account-app//form//div[@class='tsc-checkbox']//span//a")
	public WebElement lnkOurPrivacyPolicy;

	@FindBy(xpath = "//create-phone-account-app//form//label[@for='password']")
	public WebElement lblPasswordTitle;

	@FindBy(xpath = "//create-phone-account-app//form//input[@id='password']")
	public WebElement inputPassword;

	@FindBy(xpath = "//create-phone-account-app//form//button[@id='pwdShowBtn']")
	public WebElement btnPasswordShow;

	@FindBy(xpath = "//create-phone-account-app//form//label[@for='confirmPassword']")
	public WebElement lblConfirmPasswordTitle;

	@FindBy(xpath = "//create-phone-account-app//form//input[@id='confirmPassword']")
	public WebElement inputConfirmPassword;

	@FindBy(xpath = "//create-phone-account-app//form//button[@id='pwdConfirmShowBtn']")
	public WebElement btnConfirmPasswordShow;

	@FindBy(xpath = "//create-phone-account-app//form//div[@id='recaptcha']")
	public WebElement imgRecaptchaLogo;

	@FindBy(xpath = "//create-phone-account-app//form//div[contains(text(),'By clicking “Save” below')]")
	public WebElement lblAcknowledgeDescription;

	@FindBy(xpath = "//create-phone-account-app//form//button[normalize-space(.)='Create Account']")
	public WebElement btnCreateAccount;

	@FindBy(xpath = "//create-phone-account-app//form//button[normalize-space(.)='Cancel']")
	public WebElement btnCancel;

	@FindBy(xpath = "//create-phone-account-app//div[contains(@class,'text-danger')]")
	public List<WebElement> lstAllErrorMessage;

	//this part will change for mobile device
	@FindBy(xpath = "//create-phone-account-app//p[contains(text(),'Still don’t know your customer number?')]/parent::div[contains(@class,'hidden-xs')]/p[contains(text(),'Still don’t know your customer number?')]/preceding-sibling::img")
	public WebElement imgReceiptExample;

	@FindBy(xpath = "//create-phone-account-app//p[contains(text(),'Still don’t know your customer number?')]/parent::div[contains(@class,'hidden-xs')]/p[contains(text(),'Still don’t know your customer number?')]")
	public WebElement lblStillDoNotKnowYourCustomerNumberInfo;

	@FindBy(xpath = "//create-phone-account-app//p[contains(text(),'Still don’t know your customer number?')]/parent::div[contains(@class,'hidden-xs')]/p[contains(text(),'Still don’t know your customer number?')]/following-sibling::p")
	public WebElement lblCallPhoneNumberInfo;

	/**
	 * To check PassWordShowBtn Status
	 * @param - WebElement - showPasswordButton - for password or confirm password
	 * @return - boolean - true for show and false for hide
	 */
	public boolean getShowButtonStatus(WebElement showPasswordButton){
		return this.getElementInnerText(showPasswordButton).equalsIgnoreCase("Show");
	}

	/**
	 * To check Input PassWord Field Status
	 * @param - WebElement - inputPasswordForBothNewAndConfirm - for password or confirm password
	 * @return - boolean - true for password and false for text
	 */
	public boolean getInputPasswordStatus(WebElement inputPasswordForBothNewAndConfirm){
		return inputPasswordForBothNewAndConfirm.getAttribute("type").equalsIgnoreCase("password");
	}

	/**
	 * To create a new account
	 * @param - String - lsCustomerNumber
	 * @param - String - lsPhoneNumber
	 * @param - String - lsEmail
	 * @param - String - lsPassword
	 * @param - boolean - bAgreeForSignup - true for clicking Agree For Signup checkbox
	 * @param - boolean - bCreateAccount - true for clicking create account button and false for clicking cancel button
	 * @return
	 */
	public void createNewAccount(String lsCustomerNumber,String lsPhoneNumber,String lsEmail,String lsPassword,boolean bAgreeForSignup,boolean bCreateAccount){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerNumber);
		inputCustomerNumber.clear();
		inputCustomerNumber.sendKeys(lsCustomerNumber);
		this.getReusableActionsInstance().staticWait(300);

		String lsPhoneNumber1=lsPhoneNumber.substring(0,3);
		String lsPhoneNumber2=lsPhoneNumber.substring(3,6);
		String lsPhoneNumber3=lsPhoneNumber.substring(6);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPhoneNumber1);
		inputPhoneNumber1.clear();
		inputPhoneNumber1.sendKeys(lsPhoneNumber1);
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPhoneNumber2);
		inputPhoneNumber2.clear();
		inputPhoneNumber2.sendKeys(lsPhoneNumber2);
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPhoneNumber3);
		inputPhoneNumber3.clear();
		inputPhoneNumber3.sendKeys(lsPhoneNumber3);
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputEmail);
		inputEmail.clear();
		inputEmail.sendKeys(lsEmail);
		this.getReusableActionsInstance().staticWait(300);

		if(bAgreeForSignup){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(LabelAgreeForSignupCheckbox);
			LabelAgreeForSignupCheckbox.click();
			this.getReusableActionsInstance().staticWait(300);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPassword);
		inputPassword.clear();
		inputPassword.sendKeys(lsPassword);
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputConfirmPassword);
		inputConfirmPassword.clear();
		inputConfirmPassword.sendKeys(lsPassword);
		this.getReusableActionsInstance().staticWait(300);

		if(bCreateAccount){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCreateAccount);
			this.btnCreateAccount.click();
			MyAccount myAccount=new MyAccount(this.getDriver());
			this.waitForCondition(Driver->{return myAccount.lblMyAccountHeaderTitle.isDisplayed();},120000);
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCancel);
			this.btnCancel.click();
			SignInPage signInPage=new SignInPage(this.getDriver());
			this.waitForCondition(Driver->{return signInPage.lblSignInPageTitle.isDisplayed();},120000);
		}
	}

	/**
	 * To check PassWordShowBtn Status
	 * @param - WebElement - showPasswordButton - for password or confirm password
	 * @return - boolean - true for show and false for hide
	 */
	public boolean checkPassWordShowBtnStatus(WebElement showPasswordButton){
		return this.getElementInnerText(showPasswordButton).equalsIgnoreCase("Show");
	}

	/**
	 * To check Input PassWord Field Status
	 * @param - WebElement - inputPassword - for password or confirm password
	 * @return - boolean - true for password and false for text
	 */
	public boolean checkInputPassWordFieldStatus(WebElement inputPassword){
		return inputPassword.getAttribute("type").equalsIgnoreCase("password");
	}

	/**
	 * To verify form elements existing
	 */
	public void verifyFormContents(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblHeaderTitle);
		lsText=lblHeaderTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The header title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The header title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblSubHeaderTitle);
		lsText=lblSubHeaderTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The sub header title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The sub header title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerNumberTitle);
		lsText=lblCustomerNumberTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The customer Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The customer Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCustomerNumberInputDescription);
		lsText=lblCustomerNumberInputDescription.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Customer Number Input Description is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Customer Number Input Description is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputCustomerNumber);
		if(this.getReusableActionsInstance().isElementVisible(inputCustomerNumber)){
			reporter.reportLogPass("The Customer input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Customer input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPhoneNumberTitle);
		lsText=lblPhoneNumberTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The PhoneNumber Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The PhoneNumber Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPhoneNumberInputDescription);
		lsText=lblPhoneNumberInputDescription.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The PhoneNumber Input Description is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The PhoneNumber Input Description is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPhoneNumber1);
		if(this.getReusableActionsInstance().isElementVisible(inputPhoneNumber1)){
			reporter.reportLogPass("The PhoneNumber1 input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The PhoneNumber1 input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPhoneNumber2);
		if(this.getReusableActionsInstance().isElementVisible(inputPhoneNumber2)){
			reporter.reportLogPass("The PhoneNumber2 input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The PhoneNumber2 input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPhoneNumber3);
		if(this.getReusableActionsInstance().isElementVisible(inputPhoneNumber3)){
			reporter.reportLogPass("The PhoneNumber3 input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The PhoneNumber3 input is not displaying correctly");
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(LabelAgreeForSignupCheckbox);
		if(this.getReusableActionsInstance().isElementVisible(LabelAgreeForSignupCheckbox)){
			reporter.reportLogPass("The Agree For Signup checkbox is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Agree For Signup checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkOurPrivacyPolicy);
		lsText=lnkOurPrivacyPolicy.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Our Privacy Policy title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Our Privacy Policy title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkOurPrivacyPolicy);
		lsText=lnkOurPrivacyPolicy.getAttribute("href");
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Our Privacy Policy link is not empty");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Our Privacy Policy link is empty");
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAcknowledgeDescription);
		lsText=lblAcknowledgeDescription.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Acknowledge Description is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Acknowledge Description is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCreateAccount);
		lsText=btnCreateAccount.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The create account button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The create account button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCancel);
		lsText=btnCancel.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Cancel button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Cancel button is not displaying correctly");
		}
	}

	/**
	 * To verify elements existing for forgot customer part
	 */
	public void verifyForgotCustomerPartContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imgReceiptExample);
		if (this.getReusableActionsInstance().isElementVisible(imgReceiptExample)) {
			reporter.reportLogPass("The Receipt Example image is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Receipt Example image is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imgReceiptExample);
		lsText = imgReceiptExample.getAttribute("src");
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Receipt Example image source is not empty");
		} else {
			reporter.reportLogFailWithScreenshot("The header title is empty");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblStillDoNotKnowYourCustomerNumberInfo);
		lsText = lblStillDoNotKnowYourCustomerNumberInfo.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Still Do Not Know Your Customer Number info is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Still Do Not Know Your Customer Number info is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCallPhoneNumberInfo);
		lsText = lblCallPhoneNumberInfo.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Call Phone Number info is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Call Phone Number info is not displaying correctly");
		}
	}

	/**
	 * To verify Error Messages
	 * @param - List<String> - lstErrorMessageFromYml
	 */
	public void verifyErrorMessages(List<String> lstErrorMessageFromYml){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputCustomerNumber);
		this.inputCustomerNumber.clear();
		this.inputCustomerNumber.sendKeys("test");
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPhoneNumber1);
		this.inputPhoneNumber1.clear();
		this.inputPhoneNumber1.sendKeys("test");
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputEmail);
		this.inputEmail.clear();
		this.inputEmail.sendKeys("test");
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
		this.inputPassword.clear();
		this.inputPassword.sendKeys("testMail123");
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputConfirmPassword);
		this.inputConfirmPassword.clear();
		this.inputConfirmPassword.sendKeys("testMail112");
		this.applyStaticWait(300);

		this.inputPhoneNumber2.click();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCreateAccount);
		this.clickElement(this.btnCreateAccount);
		waitForCondition(Driver->{return lstAllErrorMessage.size()>0;},60000);
		this.applyStaticWait(3*this.getStaticWaitForApplication());
		this.clickElement(this.btnCreateAccount);
		this.applyStaticWait(this.getStaticWaitForApplication());

		String lsActual,lsExpected;
		WebElement item;
		int loopSize=lstAllErrorMessage.size();
		for(int i=0;i<loopSize;i++){
			item=lstAllErrorMessage.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsActual=item.getText().trim();
			lsExpected=lstErrorMessageFromYml.get(i);
			if(lsActual.equalsIgnoreCase(lsExpected)){
				reporter.reportLogPass("The error message:'"+lsActual+"' is the same as the expected:'"+lsExpected+"'");
			}
			else{
				reporter.reportLogFail("The error message:'"+lsActual+"' is not the same as the expected:'"+lsExpected+"'");
			}
		}
	}

	/**
	 * To verify Show Or Hide Password Function
	 */
	public void verifyShowOrHidePasswordFunction(){
		reporter.reportLog("Check new password");
		reporter.reportLog("Check the initial status");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnPasswordShow);
		if(getInputPasswordStatus(this.inputPassword)){
			reporter.reportLogPass("The input type is password");
		}
		else{
			reporter.reportLogFailWithScreenshot("The input type is not password");
		}

		if(getShowButtonStatus(this.btnPasswordShow)){
			reporter.reportLogPass("The button text is 'show'");
		}
		else{
			reporter.reportLogFailWithScreenshot("The button text is not 'show'");
		}

		reporter.reportLog("Check the status after clicking the button");
		this.getReusableActionsInstance().clickIfAvailable(this.btnPasswordShow);
		this.waitForCondition(Driver->{return !getShowButtonStatus(this.inputPassword);},5000);
		if(!getInputPasswordStatus(this.btnPasswordShow)){
			reporter.reportLogPass("The input type is text");
		}
		else{
			reporter.reportLogFailWithScreenshot("The input type is not text");
		}

		if(!getShowButtonStatus(btnPasswordShow)){
			reporter.reportLogPass("The button text is 'hide'");
		}
		else{
			reporter.reportLogFailWithScreenshot("The button text is not 'hide'");
		}

		reporter.reportLog("Check confirmed password");
		reporter.reportLog("Check the initial status");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnConfirmPasswordShow);
		if(getInputPasswordStatus(this.inputConfirmPassword)){
			reporter.reportLogPass("The input type is password");
		}
		else{
			reporter.reportLogFailWithScreenshot("The input type is not password");
		}

		if(getShowButtonStatus(this.btnConfirmPasswordShow)){
			reporter.reportLogPass("The button text is 'show'");
		}
		else{
			reporter.reportLogFailWithScreenshot("The button text is not 'show'");
		}

		reporter.reportLog("Check the status after clicking the button");
		this.getReusableActionsInstance().clickIfAvailable(this.btnConfirmPasswordShow);
		this.waitForCondition(Driver->{return !getShowButtonStatus(this.inputConfirmPassword);},5000);
		if(!getInputPasswordStatus(this.btnConfirmPasswordShow)){
			reporter.reportLogPass("The input type is text");
		}
		else{
			reporter.reportLogFailWithScreenshot("The input type is not text");
		}

		if(!getShowButtonStatus(btnConfirmPasswordShow)){
			reporter.reportLogPass("The button text is 'hide'");
		}
		else{
			reporter.reportLogFailWithScreenshot("The button text is not 'hide'");
		}
	}

}
