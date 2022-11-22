package com.tsc.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.api.util.JsonParser;
import com.tsc.pages.base.BasePage;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//create-account-app//a[contains(@href,'signin')]")
    public WebElement lnkBackToSignIn;

    @FindBy(xpath = "//create-account-app//div[contains(@class,'form-head')]//h2")
    public WebElement lblHeaderTitle;

    @FindBy(xpath = "//create-account-app//span[@class='req']/parent::p")
    public WebElement lblRequiredFieldInfo;

    @FindBy(xpath = "//create-account-app//label[@for='firstName']")
    public WebElement lblFirstNameTitle;

    @FindBy(xpath = "//create-account-app//input[@id='firstName']")
    public WebElement inputFirstName;

    @FindBy(xpath = "//create-account-app//label[@for='lastName']")
    public WebElement lblLastNameTitle;

    @FindBy(xpath = "//create-account-app//input[@id='lastName']")
    public WebElement inputLastName;

    @FindBy(xpath = "//create-account-app//label[@for='addressLine1']")
    public WebElement lblAddressLine1Title;

    @FindBy(xpath = "//create-account-app//p-autocomplete[@formcontrolname='addressLine1']//input")
    public WebElement inputAddressLine1;

    @FindBy(xpath = "//create-account-app//p-autocomplete[@formcontrolname='addressLine1']//div[contains(@class,'ui-autocomplete-panel')]")
    public WebElement cntAddressLine1DropdownMenuListContainer;

    @FindBy(xpath = "//create-account-app//p-autocomplete[@formcontrolname='addressLine1']//div[contains(@class,'ui-autocomplete-panel')]//ul//li")
    public List<WebElement> lstAddressLine1DropdownMenuList;

    @FindBy(xpath = "//create-account-app//label[@for='addressLine2']")
    public WebElement lblAddressLine2Title;

    @FindBy(xpath = "//create-account-app//input[@id='addressLine2']")
    public WebElement inputAddressLine2;

    @FindBy(xpath = "//create-account-app//label[@for='city']")
    public WebElement lblCityTitle;

    @FindBy(xpath = "//create-account-app//input[@id='city']")
    public WebElement inputCity;

    @FindBy(xpath = "//create-account-app//label[@for='province']")
    public WebElement lblProvinceTitle;

    @FindBy(xpath = "//create-account-app//select[@id='province']")
    public WebElement selectProvince;

    @FindBy(xpath = "//create-account-app//label[contains(.,'Postal Code')]")
    public WebElement lblPostalCodeTitle;

    @FindBy(xpath = "//create-account-app//input[@id='postalCode1']")
    public WebElement inputPostalCode1;

    @FindBy(xpath = "//create-account-app//input[@id='postalCode2']")
    public WebElement inputPostalCode2;

    @FindBy(xpath = "//create-account-app//label[contains(.,'Phone Number')]")
    public WebElement lblPhoneNumberTitle;

    @FindBy(xpath = "//create-account-app//input[@formcontrolname='phoneNumber1']")
    public WebElement inputPhoneNumber1;

    @FindBy(xpath = "//create-account-app//input[@formcontrolname='phoneNumber2']")
    public WebElement inputPhoneNumber2;

    @FindBy(xpath = "//create-account-app//input[@formcontrolname='phoneNumber3']")
    public WebElement inputPhoneNumber3;

    @FindBy(xpath = "//create-account-app//label[@for='email']")
    public WebElement lblEmailTitle;

    @FindBy(xpath = "//create-account-app//input[@id='email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//create-account-app//p[@class='explain-input']")
    public WebElement lblEmailExplanation;

    @FindBy(xpath = "//create-account-app//label[@for='subscribe']")
    public WebElement labelEmailSubscribe;

    @FindBy(xpath = "//create-account-app//input[@id='subscribe']")
    public WebElement ckbEmailSubscribe;

    @FindBy(xpath = "//create-account-app//span[@class='notes']")
    public WebElement lblEmailSubscribeNotes;

    @FindBy(xpath = "//create-account-app//label[@for='password']")
    public WebElement lblPasswordTitle;

    @FindBy(xpath = "//create-account-app//input[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//create-account-app//button[@id='pwdShowBtn']")
    public WebElement btnShowOrHidePassword;

    @FindBy(xpath = "//create-account-app//label[@for='password']/parent::div/following-sibling::div[@class='text-danger'][1]")
    public WebElement lblPasswordWarningMessage;

    @FindBy(xpath = "//create-account-app//label[@for='confirmPassword']")
    public WebElement lblConfirmPasswordTitle;

    @FindBy(xpath = "//create-account-app//input[@id='confirmPassword']")
    public WebElement inputConfirmPassword;

    @FindBy(xpath = "//create-account-app//button[@id='pwdConfirmShowBtn']")
    public WebElement btnConfirmPasswordShow;

    @FindBy(xpath = "//create-account-app//label[@for='confirmPassword']/parent::div/following-sibling::div[@class='text-danger'][1]")
    public WebElement lblConfirmPasswordWarningMessage;

    @FindBy(xpath = "//create-account-app//div[@class='grecaptcha-logo']")
    public WebElement imgRecaptchaLogo;

    @FindBy(xpath = "//create-account-app//div[@class='legalTerms']")
    public WebElement lblLegalTerms;

    @FindBy(xpath = "//create-account-app//button[@type='submit']")
    public WebElement btnSave;

    @FindBy(xpath = "//create-account-app//button[normalize-space(.)='Cancel']")
    public WebElement btnCancel;

    @FindBy(xpath = "//create-account-app//div[contains(@class,'text-danger')]")
    public List<WebElement> lstAllErrorMessage;

    /**
     * To create a new account
     * @param - String - lsEmail - generated automatically if pass null
     * @param - String - lsPassword - generated automatically if pass null
     * @param - boolean - bSave - true for clicking save button and false for clicking cancel button
     * @param - boolean - bExistingEmail - if input an existing email
     * @return - Map<String,String> - including email and password
     */
    public Map<String,String> createNewAccount(String lsEmail,String lsPassword,boolean bSave,boolean bExistingEmail){
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
        this.waitForCondition(Driver->{return this.cntAddressLine1DropdownMenuListContainer.getAttribute("style").contains("display: block;");},20000);
        this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());

        if(lstAddressLine1DropdownMenuList.size()>1){
            reporter.reportLogPass("Getting dropdown auto search results successfully");
        }
        else{
            reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
        }

        int optionSize=this.lstAddressLine1DropdownMenuList.size();
        Random rand = new Random();
        int randomNumber = rand.nextInt(optionSize-2);
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddressLine1DropdownMenuList.get(randomNumber));
        this.getReusableActionsInstance().clickIfAvailable(this.lstAddressLine1DropdownMenuList.get(randomNumber));
        this.waitForCondition(Driver->{return this.cntAddressLine1DropdownMenuListContainer.getAttribute("style").contains("display: none;");},20000);

        String lsPhoneNumber1="647";
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPhoneNumber1);
        inputPhoneNumber1.clear();
        inputPhoneNumber1.sendKeys(lsPhoneNumber1);
        this.getReusableActionsInstance().staticWait(300);

        String lsPhoneNumber2=DataConverter.getSaltString(3,"numberType");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPhoneNumber2);
        inputPhoneNumber2.clear();
        inputPhoneNumber2.sendKeys(lsPhoneNumber2);
        this.getReusableActionsInstance().staticWait(300);

        String lsPhoneNumber3=DataConverter.getSaltString(4,"numberType");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPhoneNumber3);
        inputPhoneNumber3.clear();
        inputPhoneNumber3.sendKeys(lsPhoneNumber3);
        this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

        if(lsEmail==null){
            lsEmail=DataConverter.getSaltString(4,"lowerStringType")+DataConverter.getSaltString(4,"numberType")+"@rogers.com";
        }
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputEmail);
        inputEmail.clear();
        inputEmail.sendKeys(lsEmail);
        this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbEmailSubscribe);
        labelEmailSubscribe.click();
        this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

        if(lsPassword==null){
            lsPassword=DataConverter.getSaltString(5,"lowerStringType")+DataConverter.getSaltString(1,"numberType");
        }
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPassword);
        inputPassword.clear();
        inputPassword.sendKeys(lsPassword);
        this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputConfirmPassword);
        inputConfirmPassword.clear();
        inputConfirmPassword.sendKeys(lsPassword);
        this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

        if(bSave){
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSave);
            this.btnSave.click();
            if(bExistingEmail){
                this.waitForCondition(Driver->{return this.getElementInnerText(this.lstAllErrorMessage.get(0)).contains("already exist!!!");},120000);
            }
            else{
                SignInPage signInPage=new SignInPage(this.getDriver());
                this.waitForCondition(Driver->{return signInPage.lblSignInPageTitle.isDisplayed();},120000);
            }
        }
        else{
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCancel);
            this.btnCancel.click();
            this.applyStaticWait(3*this.getStaticWaitForApplication());
        }

        Map<String,String> map=new HashMap<>();
        if(bExistingEmail){
            map.put("errorMessage",this.getElementInnerText(this.lstAllErrorMessage.get(0)));
        }
        else{
            map.put("firstName",lsFirstName);
            map.put("lastName",lsLastName);
            map.put("email",lsEmail);
            map.put("password",lsPassword);
        }

        return map;
    }

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
     * To verify elements existing
     */
    public void verifyContents(){
        String lsText;

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblHeaderTitle);
        lsText=lblHeaderTitle.getText();
        if(!lsText.isEmpty()){
            reporter.reportLogPass("The header title is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The header title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRequiredFieldInfo);
        lsText=lblRequiredFieldInfo.getText();
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

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPostalCode1);
        if(this.getReusableActionsInstance().isElementVisible(inputPostalCode1)){
            reporter.reportLogPass("The PostalCode1 input is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The PostalCode1 input is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputPostalCode2);
        if(this.getReusableActionsInstance().isElementVisible(inputPostalCode2)){
            reporter.reportLogPass("The PostalCode2 input is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The PostalCode2 input is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPhoneNumberTitle);
        lsText=lblPhoneNumberTitle.getText();
        if(!lsText.isEmpty()){
            reporter.reportLogPass("The PhoneNumber Title is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The PhoneNumber Title is not displaying correctly");
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

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblEmailExplanation);
        lsText=lblEmailExplanation.getText();
        if(!lsText.isEmpty()){
            reporter.reportLogPass("The Email Explanation is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The Email Explanation is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelEmailSubscribe);
        if(this.getReusableActionsInstance().isElementVisible(labelEmailSubscribe)){
            reporter.reportLogPass("The Email Subscribe info is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The Email Subscribe info is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblEmailSubscribeNotes);
        lsText=lblEmailSubscribeNotes.getText();
        if(!lsText.isEmpty()){
            reporter.reportLogPass("The Email Subscribe notes is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The Email Subscribe notes is not displaying correctly");
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

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnShowOrHidePassword);
        if(this.getReusableActionsInstance().isElementVisible(btnShowOrHidePassword)){
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

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblLegalTerms);
        lsText=lblLegalTerms.getText();
        if(!lsText.isEmpty()){
            reporter.reportLogPass("The Legal Terms is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The Legal Terms is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnSave);
        lsText=btnSave.getText();
        if(!lsText.isEmpty()){
            reporter.reportLogPass("The save button is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The save button is not displaying correctly");
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
     * To verify Error Messages
     * @param - List<String> - lstErrorMessageFromYml
     */
    public void verifyErrorMessages(List<String> lstErrorMessageFromYml){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputFirstName);
        this.inputFirstName.clear();
        this.inputFirstName.sendKeys("test1");
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputLastName);
        this.inputLastName.clear();
        this.inputLastName.sendKeys("test1");
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPostalCode1);
        this.inputPostalCode1.clear();
        this.inputPostalCode1.sendKeys("111");
        this.inputPostalCode2.clear();
        this.inputPostalCode2.sendKeys("111");
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

        this.inputPhoneNumber1.click();
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSave);
        this.clickElement(this.btnSave);
        waitForCondition(Driver->{return lstAllErrorMessage.size()>0;},60000);
        this.applyStaticWait(3*this.getStaticWaitForApplication());
        this.clickElement(this.btnSave);
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
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnShowOrHidePassword);
        if(getInputPasswordStatus(this.inputPassword)){
            reporter.reportLogPass("The input type is password");
        }
        else{
            reporter.reportLogFailWithScreenshot("The input type is not password");
        }

        if(getShowButtonStatus(this.btnShowOrHidePassword)){
            reporter.reportLogPass("The button text is 'show'");
        }
        else{
            reporter.reportLogFailWithScreenshot("The button text is not 'show'");
        }

        reporter.reportLog("Check the status after clicking the button");
        this.getReusableActionsInstance().clickIfAvailable(this.btnShowOrHidePassword);
        this.waitForCondition(Driver->{return !getShowButtonStatus(this.btnShowOrHidePassword);},5000);
        if(!getInputPasswordStatus(this.inputPassword)){
            reporter.reportLogPass("The input type is text");
        }
        else{
            reporter.reportLogFailWithScreenshot("The input type is not text");
        }

        if(!getShowButtonStatus(btnShowOrHidePassword)){
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
        this.waitForCondition(Driver->{return !getShowButtonStatus(this.btnConfirmPasswordShow);},5000);
        if(!getInputPasswordStatus(this.inputConfirmPassword)){
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

    /**
     * This function creates a new user and returns Account Response object for newly created user
     * @param - String - accessToken
     * @return - AccountResponse Object
     * @throws - IOException
     */
    public AccountResponse getNewUserAccountDetails(String accessToken) throws IOException {
        AccountAPI accountAPI = new AccountAPI();
        Response newUserAccount = accountAPI.createNormalAccount(accessToken,null,null);
        AccountResponse accountResponse=null;
        if(newUserAccount.statusCode()==200){
            accountResponse = JsonParser.getResponseObject(newUserAccount.asString(), new TypeReference<AccountResponse>() {});
        }
        return accountResponse;
    }

}
