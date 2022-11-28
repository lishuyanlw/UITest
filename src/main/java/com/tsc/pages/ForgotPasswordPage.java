package com.tsc.pages;

import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.SecurityQuestionResponse;
import com.tsc.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    //For input email
    @FindBy(xpath = "//ng-component//div[contains(@class,'go-back-link')]//a")
    public WebElement lnkGoBackLink;

    @FindBy(xpath = "//ng-component//div[contains(@class,'form-head')]//h2")
    public WebElement lblResetPasswordHeaderTitle;

    @FindBy(xpath = "//ng-component//div[contains(@class,'form-head')]//p")
    public WebElement lblEnterYourEmailAddress;

    @FindBy(xpath = "//ng-component//form//label[@for='email']")
    public WebElement lblInputEmailLabel;

    @FindBy(xpath = "//ng-component//form//input[@type='email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//ng-component//form//div[contains(@class,'text-danger')]")
    public WebElement lblEmailRequiredErrorMessage;

    @FindBy(xpath = "//ng-component//form//button[normalize-space(text())='Continue']")
    public WebElement btnContinue;

    @FindBy(xpath = "//ng-component//form//a[normalize-space(text())='Cancel']")
    public WebElement btnEmailInputCancel;

    //For input the unregistered email
    @FindBy(xpath = "//ng-component//div[contains(@class,'form-head')]//h2")
    public WebElement lblNotRegisteredEmailHeaderTitle;

    @FindBy(xpath = "//ng-component//div[contains(@class,'form-head')]//p")
    public WebElement lblCheckYourEmail;

    @FindBy(xpath = "//ng-component//button[normalize-space(text())='Try Again']")
    public WebElement btnTryAgain;

    @FindBy(xpath = "//ng-component//h4")
    public WebElement lblOrTitle;

    @FindBy(xpath = "//ng-component//a[normalize-space(text())='Create New Account']")
    public WebElement btnCreateNewAccount;

    @FindBy(xpath = "//ng-component//a[normalize-space(text())='Transfer my Phone Account']")
    public WebElement btnTransferMyPhoneAccount;

    //For input registered email
    @FindBy(xpath = "//ng-component//div[contains(@class,'form-head')]//h2")
    public WebElement lblAnswerSecurityQuestionsHeaderTitle;

    //For reset by answer security questions
    @FindBy(xpath = "//ng-component//h1[normalize-space(text())='Reset by Answering Questions']")
    public WebElement lblResetByAnsweringQuestions;

    @FindBy(xpath = "//ng-component//h1[normalize-space(text())='Reset by Answering Questions']/following-sibling::p")
    public WebElement lblTwoAttemptsInfo;

    @FindBy(xpath = "//ng-component//label[normalize-space(text())='Question 1']")
    public WebElement lblQuestion1Label;

    @FindBy(xpath = "//ng-component//label[normalize-space(text())='Question 1']/following-sibling::p")
    public WebElement lblQuestion1ForPhoneNumber;

    @FindBy(xpath = "//ng-component//label[normalize-space(text())='Question 1']/following-sibling::input[contains(@class,'field1')]")
    public WebElement inputQuestion1ForPhoneNumberField1;

    @FindBy(xpath = "//ng-component//label[normalize-space(text())='Question 1']/following-sibling::input[contains(@class,'field2')]")
    public WebElement inputQuestion1ForPhoneNumberField2;

    @FindBy(xpath = "//ng-component//label[normalize-space(text())='Question 1']/following-sibling::input[contains(@class,'field3')]")
    public WebElement inputQuestion1ForPhoneNumberField3;

    @FindBy(xpath = "//ng-component//label[normalize-space(text())='Question 2']")
    public WebElement lblQuestion2Label;

    @FindBy(xpath = "//ng-component//label[normalize-space(text())='Question 2']/following-sibling::p")
    public WebElement lblQuestion2ForPostalCode;

    @FindBy(xpath = "//ng-component//label[normalize-space(text())='Question 2']/following-sibling::input[@id='postalcode']")
    public WebElement inputQuestion2ForPostalCode;

    @FindBy(xpath = "//ng-component//label[normalize-space(text())='Question 3']")
    public WebElement lblQuestion3Label;

    @FindBy(xpath = "//ng-component//label[normalize-space(text())='Question 3']/following-sibling::p")
    public WebElement lblQuestion3ForSecurityQuestion;

    @FindBy(xpath = "//ng-component//label[normalize-space(text())='Question 3']/following-sibling::input[@id='securityanswer']")
    public WebElement inputQuestion3ForSecurityAnswer;

    @FindBy(xpath = "//ng-component//div[normalize-space(text())='Security question answer is required.']")
    public WebElement lblSecurityQuestionAnswerRequired;

    @FindBy(xpath = "//ng-component//button[normalize-space(text())='Reset Password']")
    public WebElement btnResetPassword;

    @FindBy(xpath = "//ng-component//button[normalize-space(text())='Reset Password']/parent::div/following-sibling::div//a[normalize-space(text())='Cancel']")
    public WebElement btnResetPasswordCancel;

    @FindBy(xpath = "//ng-component//form//div[contains(@class,'text-danger')]")
    public List<WebElement> lstAllErrorMessageForSecurityQuestions;

    //For reset by email address
    @FindBy(xpath = "//ng-component//h1[normalize-space(text())='Reset by Email Address']")
    public WebElement lblResetByEmailAddress;

    @FindBy(xpath = "//ng-component//h1[normalize-space(text())='Reset by Email Address']/following-sibling::div//p")
    public WebElement lblSendEmailInfo;

    @FindBy(xpath = "//ng-component//button[normalize-space(text())='Send Email']")
    public WebElement btnSendEmail;

    @FindBy(xpath = "//ng-component//button[normalize-space(text())='Send Email']/parent::div/following-sibling::div//a[normalize-space(text())='Cancel']")
    public WebElement btnSendEmailCancel;

    //For the window after clicking Reset Password button
    @FindBy(xpath = "//signin-app//div[contains(@class,'form-head')]//h2")
    public WebElement lblCreateNewPasswordTitle;

    @FindBy(xpath = "//signin-app//div[contains(@class,'form-head')]//p")
    public WebElement lblEnterYourNewPasswordBelowTitle;

    @FindBy(xpath = "//signin-app//form//p")
    public WebElement lblPasswordRequiredConditionMessage;

    @FindBy(xpath = "//signin-app//form//label[@for='password']")
    public WebElement labelNewPassword;

    @FindBy(xpath = "//signin-app//form//label[@for='password']/following-sibling::div/input")
    public WebElement inputNewPassword;

    @FindBy(xpath = "//signin-app//form//label[@for='password']/following-sibling::div/button")
    public WebElement btnShowNewPassword;

    @FindBy(xpath = "//signin-app//form//label[@for='password2']")
    public WebElement labelConfirmNewPassword;

    @FindBy(xpath = "//signin-app//form//label[@for='password2']/following-sibling::div/input")
    public WebElement inputConfirmNewPassword;

    @FindBy(xpath = "//signin-app//form//label[@for='password2']/following-sibling::div/button")
    public WebElement btnShowConfirmNewPassword;

    @FindBy(xpath = "//signin-app//form//button[normalize-space(text())='Create New Password']")
    public WebElement btnCreateNewPassword;

    @FindBy(xpath = "//ng-component//form//div[contains(@class,'text-danger')]")
    public List<WebElement> lstAllErrorMessageForPasswordInput;

    //For the window after clicking Create New password button
    @FindBy(xpath = "//ng-component//div[contains(@class,'form-head')]//h2")
    public WebElement lblAddSecurityQuestionTitle;

    @FindBy(xpath = "//ng-component//div[contains(@class,'form-head')]//p")
    public WebElement lblSelectSecurityQuestionBelowTitle;

    @FindBy(xpath = "//ng-component//div[contains(@class,'explain-text')]")
    public WebElement lblSelectSecurityQuestionExplainText;

    @FindBy(xpath = "//ng-component//form//label[@for='question']")
    public WebElement labelSecurityQuestion;

    @FindBy(xpath = "//ng-component//form//select")
    public WebElement selectSecurityQuestion;

    @FindBy(xpath = "//ng-component//form//label[@for='answer']")
    public WebElement labelSecurityQuestionAnswer;

    @FindBy(xpath = "//ng-component//form//input[@id='answer']")
    public WebElement inputSecurityQuestionAnswer;

    @FindBy(xpath = "//ng-component//form//button[@id='show-answer']")
    public WebElement btnShowAnswer;

    @FindBy(xpath = "//ng-component//form//div[contains(@class,'text-danger')]")
    public WebElement lblSecurityQuestionAnswerRequiredErrorMessage;

    @FindBy(xpath = "//ng-component//form//button[normalize-space(text())='Save and Continue']")
    public WebElement btnSaveAndContinue;

    //For the windows after clicking send mail button
    @FindBy(xpath = "//ng-component//div[contains(@class,'form-head')]//h2")
    public WebElement lblResetPasswordEmailHasBeenSent;

    @FindBy(xpath = "//ng-component//div[contains(@class,'form-head')]/following-sibling::div")
    public WebElement lblResetPasswordSubContents;

    @FindBy(xpath = "//ng-component//div[contains(@class,'form-head')]/following-sibling::div//a")
    public WebElement lnkResendPassword;


    /**
     * To verify Input Email Page Contents
     */
    public void verifyInputEmailPageContents() {
        String lsText;

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblResetPasswordHeaderTitle);
        lsText = lblResetPasswordHeaderTitle.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The reset password header title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The reset password header title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblEnterYourEmailAddress);
        lsText = lblEnterYourEmailAddress.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The enter your email address title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The enter your email address title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInputEmailLabel);
        lsText = lblInputEmailLabel.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The input email label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The input email label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputEmail);
        if(this.getReusableActionsInstance().isElementVisible(inputEmail)) {
            reporter.reportLogPass("The input email is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The input email is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnContinue);
        lsText = btnContinue.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The continue button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The continue button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnEmailInputCancel);
        lsText = btnEmailInputCancel.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The cancel email input button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The cancel email input button is not displaying correctly");
        }
    }

    /**
     * To verify Input Unregistered Email Page Contents
     */
    public void verifyInputNotRegisteredEmailPageContents() {
        String lsText;

        try {
            this.waitForCondition(Driver->{return lblNotRegisteredEmailHeaderTitle.isDisplayed();},120000);
        }
        catch (Exception ex){
            this.applyStaticWait(15*this.getStaticWaitForApplication());
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblNotRegisteredEmailHeaderTitle);
        lsText = lblNotRegisteredEmailHeaderTitle.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The not registered email header title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The not registered email header title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCheckYourEmail);
        lsText = lblCheckYourEmail.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The check your email info is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The check your email info is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnTryAgain);
        lsText = btnTryAgain.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The try again button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The try again button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrTitle);
        lsText = lblOrTitle.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The OR text is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The OR text is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCreateNewAccount);
        lsText = btnCreateNewAccount.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The create new account button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The create new account button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnTransferMyPhoneAccount);
        lsText = btnTransferMyPhoneAccount.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The transfer my phone account button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The transfer my phone account button is not displaying correctly");
        }
    }

    /**
     * To verify Security Questions And Reset By Email contents by Input registered Email
     */
    public void verifySecurityQuestionsAndResetByEmailContentsByInputRegisteredEmail() {
        String lsText;

        try {
            this.waitForCondition(Driver->{return lblAnswerSecurityQuestionsHeaderTitle.isDisplayed();},12000);
        }
        catch (Exception ex){
            this.applyStaticWait(8*this.getStaticWaitForApplication());
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAnswerSecurityQuestionsHeaderTitle);
        lsText = lblAnswerSecurityQuestionsHeaderTitle.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The answer security questions header title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The answer security questions header title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblResetByAnsweringQuestions);
        lsText = lblResetByAnsweringQuestions.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The reset by answering questions info is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The reset by answering questions info is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTwoAttemptsInfo);
        lsText = lblTwoAttemptsInfo.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The two attempts info is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The two attempts info is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblQuestion1Label);
        lsText = lblQuestion1Label.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The question1 label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The question1 label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblQuestion1ForPhoneNumber);
        lsText = lblQuestion1ForPhoneNumber.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The Question1 For PhoneNumber is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The Question1 For PhoneNumber is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputQuestion1ForPhoneNumberField1);
        if(this.getReusableActionsInstance().isElementVisible(inputQuestion1ForPhoneNumberField1)) {
            reporter.reportLogPass("The input Question1 For PhoneNumber Field1 is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The input Question1 For PhoneNumber Field1 is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputQuestion1ForPhoneNumberField2);
        if(this.getReusableActionsInstance().isElementVisible(inputQuestion1ForPhoneNumberField2)) {
            reporter.reportLogPass("The input Question1 For PhoneNumber Field2 is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The input Question1 For PhoneNumber Field2 is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputQuestion1ForPhoneNumberField3);
        if(this.getReusableActionsInstance().isElementVisible(inputQuestion1ForPhoneNumberField3)) {
            reporter.reportLogPass("The input Question1 For PhoneNumber Field3 is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The input Question1 For PhoneNumber Field3 is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblQuestion2Label);
        lsText = lblQuestion2Label.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The question2 label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The question2 label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblQuestion2ForPostalCode);
        lsText = lblQuestion2ForPostalCode.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The Question2 For PostalCode is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The Question2 For PostalCode is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputQuestion2ForPostalCode);
        if(this.getReusableActionsInstance().isElementVisible(inputQuestion2ForPostalCode)) {
            reporter.reportLogPass("The input Question2 For PostalCode is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The input Question2 For PostalCode is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblQuestion3Label);
        lsText = lblQuestion3Label.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The question3 label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The question3 label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblQuestion3ForSecurityQuestion);
        lsText = lblQuestion3ForSecurityQuestion.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The Question3 For Security Question is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The Question3 For Security Question is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputQuestion3ForSecurityAnswer);
        if(this.getReusableActionsInstance().isElementVisible(inputQuestion3ForSecurityAnswer)) {
            reporter.reportLogPass("The input Question3 For Security Answer is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The input Question3 For Security Answer is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnResetPassword);
        lsText = btnResetPassword.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The reset password button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The reset password button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnResetPasswordCancel);
        lsText = btnResetPasswordCancel.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The cancel reset password button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The cancel reset password button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblResetByEmailAddress);
        lsText = lblResetByEmailAddress.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The reset by email address info is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The reset by email address info is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblSendEmailInfo);
        lsText = lblSendEmailInfo.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The send email info is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The send email info is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnSendEmail);
        lsText = btnSendEmail.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The send email button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The send email button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnSendEmailCancel);
        lsText = btnSendEmailCancel.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The cancel send email button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The cancel send email button is not displaying correctly");
        }
    }

    /**
     * To verify create new password Page Contents
     */
    public void verifyCreateNewPasswordPageContents() {
        String lsText;

        try{
            this.waitForCondition(Driver->{return lblCreateNewPasswordTitle.isDisplayed();},120000);
            this.applyStaticWait(this.getStaticWaitForApplication());
        }
        catch (Exception ex){
            this.applyStaticWait(8*this.getStaticWaitForApplication());
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCreateNewPasswordTitle);
        lsText = lblCreateNewPasswordTitle.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The create new password title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The create new password title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblEnterYourNewPasswordBelowTitle);
        lsText = lblEnterYourNewPasswordBelowTitle.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The Enter Your New Password Below title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The Enter Your New Password Below title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPasswordRequiredConditionMessage);
        lsText = lblPasswordRequiredConditionMessage.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The Password Required Condition Message is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The Password Required Condition Message is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelNewPassword);
        lsText = labelNewPassword.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The new password label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The new password label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputNewPassword);
        if(this.getReusableActionsInstance().isElementVisible(inputNewPassword)) {
            reporter.reportLogPass("The input new password is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The input new password is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnShowNewPassword);
        if(this.getReusableActionsInstance().isElementVisible(btnShowNewPassword)) {
            reporter.reportLogPass("The show new password button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The show new password button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelConfirmNewPassword);
        lsText = labelConfirmNewPassword.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The Confirm new password label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The Confirm new password label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputConfirmNewPassword);
        if(this.getReusableActionsInstance().isElementVisible(inputConfirmNewPassword)) {
            reporter.reportLogPass("The input Confirm new password is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The input Confirm new password is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnShowConfirmNewPassword);
        if(this.getReusableActionsInstance().isElementVisible(btnShowConfirmNewPassword)) {
            reporter.reportLogPass("The show Confirm new password button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The show Confirm new password button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCreateNewPassword);
        lsText = btnCreateNewPassword.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The create new password button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The create new password button is not displaying correctly");
        }
    }

    /**
     * To verify add security questions Page Contents
     */
    public void verifyAddSecurityQuestionPageContents() {
        String lsText;

        try{
            this.waitForCondition(Driver->{return lblAddSecurityQuestionTitle.isDisplayed();},5000);
        }
        catch (Exception ex){
            this.applyStaticWait(15*this.getStaticWaitForApplication());
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddSecurityQuestionTitle);
        lsText = lblAddSecurityQuestionTitle.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The Add Security Question title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The Add Security Question title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblSelectSecurityQuestionBelowTitle);
        lsText = lblSelectSecurityQuestionBelowTitle.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The Select Security Question Below title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The Select Security Question Below title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblSelectSecurityQuestionExplainText);
        lsText = lblSelectSecurityQuestionExplainText.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The Select Security Question Below Explain Text is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The Select Security Question Explain Text is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelSecurityQuestion);
        lsText = labelSecurityQuestion.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The security Question label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The security Question label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectSecurityQuestion);
        if(this.getReusableActionsInstance().isElementVisible(selectSecurityQuestion)) {
            reporter.reportLogPass("The select Security Question is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The select Security Question is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelSecurityQuestionAnswer);
        lsText = labelSecurityQuestionAnswer.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The security Question answer label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The security Question answer label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputSecurityQuestionAnswer);
        if(this.getReusableActionsInstance().isElementVisible(inputSecurityQuestionAnswer)) {
            reporter.reportLogPass("The input select Security Question answer is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The input select Security Question answer is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnShowAnswer);
        if(this.getReusableActionsInstance().isElementVisible(btnShowAnswer)) {
            reporter.reportLogPass("The show answer button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The show answer button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnSaveAndContinue);
        lsText = btnSaveAndContinue.getText().trim();
        if(!lsText.isEmpty()) {
            reporter.reportLogPass("The save and continue button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The save and continue button is not displaying correctly");
        }
    }

    /**
     * To verify sent email Page Contents
     */
    public void verifySentEmailPageContents() {
        String lsText;

        try{
            this.waitForCondition(Driver->{return this.lblResetPasswordEmailHasBeenSent.isDisplayed();},120000);
        }
        catch (Exception ex){
            this.applyStaticWait(15*this.getStaticWaitForApplication());
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblResetPasswordEmailHasBeenSent);
        lsText = lblResetPasswordEmailHasBeenSent.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The sent email message is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The sent email message is not displaying correctly");
        }

//        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblResetPasswordSubContents);
        lsText = this.getElementInnerText(lblResetPasswordSubContents);
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The Reset Password Sub Contents is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The Reset Password Sub Contents is not displaying correctly");
        }
    }


    /**
     * To go To Answer Security Questions Page With Registered Email
     * @param - String - lsRegisteredEmail
     */
    public void goToAnswerSecurityQuestionsPageWithRegisteredEmail(String lsRegisteredEmail){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputEmail);
        this.inputEmail.clear();
        this.inputEmail.sendKeys(lsRegisteredEmail);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnContinue);
        this.getReusableActionsInstance().clickIfAvailable(this.btnContinue);
        try{
            this.waitForCondition(Driver->{return this.lblAnswerSecurityQuestionsHeaderTitle.isDisplayed();},120000);
        }
        catch (Exception ex){
            this.applyStaticWait(15*this.getStaticWaitForApplication());
        }
    }

    /**
     * To go To Try Again Page With Not Registered Email
     */
    public void goToTryAgainPageWithNotRegisteredEmail(){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputEmail);
        this.inputEmail.clear();
        this.inputEmail.sendKeys("InvalidEmail@invalid.com");

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnContinue);
        this.getReusableActionsInstance().clickIfAvailable(this.btnContinue);

        try{
            this.waitForCondition(Driver->{return this.lblNotRegisteredEmailHeaderTitle.isDisplayed();},120000);
        }
        catch(Exception ex){
            this.applyStaticWait(15*this.getStaticWaitForApplication());
        }
    }

    /**
     * To go To Reset password Page
     */
    public void goToResetPasswordPage(){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnResetPassword);
        this.setElementEnabled(this.btnResetPassword);
        this.applyStaticWait(3000);
        this.clickElement(this.btnResetPassword);
        //this.getReusableActionsInstance().clickIfAvailable(btnResetPassword);
        try{
            this.waitForCondition(Driver->{return this.lblCreateNewPasswordTitle.isDisplayed();},120000);
        }
        catch (Exception ex){
            this.applyStaticWait(8*this.getStaticWaitForApplication());
        }

    }

    /**
     * To go To Add Security Question For New Password Page
     */
    public void goToAddSecurityQuestionForNewPasswordPage(){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCreateNewPassword);
        this.getReusableActionsInstance().clickIfAvailable(btnCreateNewPassword);

        try{
            this.waitForCondition(Driver->{return this.lblAddSecurityQuestionTitle.isDisplayed();},120000);
        }
        catch (Exception ex){
            this.applyStaticWait(15*this.getStaticWaitForApplication());
        }

    }

    /**
     * To go To send Email Page
     */
    public void goToSendEmailPage(){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSendEmail);
        this.getReusableActionsInstance().clickIfAvailable(btnSendEmail);
        try{
            this.waitForCondition(Driver->{return this.lblResetPasswordEmailHasBeenSent.isDisplayed();},120000);
        }
        catch (Exception ex){
            this.applyStaticWait(15*this.getStaticWaitForApplication());
        }
    }

    /**
     * To verify Clicking Cancel Button On Input Email Page
     * @param - String - lsUrlForSignInFromYml
     */
    public void verifyClickingCancelButtonOnInputEmailPage(String lsUrlForSignInFromYml){
        String lsUrlBeforeClicking=this.URL();
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnEmailInputCancel);
        this.btnEmailInputCancel.click();

        this.waitForCondition(Driver->{return !this.URL().equalsIgnoreCase(lsUrlBeforeClicking);},120000);
        String lsExpectedUrl=this.getBaseURL()+lsUrlForSignInFromYml;
        String lsNavigatedUrl=this.URL();
        if(lsNavigatedUrl.equalsIgnoreCase(lsExpectedUrl)){
            reporter.reportLogPass("The navigated Url:'"+lsNavigatedUrl+"' after clicking cancel button is the same as the expected:'"+lsExpectedUrl+"'");
        }
        else{
            reporter.reportLogFail("The navigated Url:'"+lsNavigatedUrl+"' after clicking cancel button is not the same as the expected:'"+lsExpectedUrl+"'");
        }
    }

    /**
     * To verify Clicking Try again button On TryAgain Page
     */
    public void verifyClickingTryAgainButtonOnTryAgainPage(){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTryAgain);
        this.btnTryAgain.click();

        this.waitForCondition(Driver->{return this.lblResetPasswordHeaderTitle.isDisplayed();},120000);
        if(this.lblResetPasswordHeaderTitle.isDisplayed()){
            reporter.reportLogPass("To be navigated back to Forgot password page after clicking Try again button successfully");
        }
        else{
            reporter.reportLogFail("Failed to be navigated back to Forgot password page after clicking Try again button");
        }
    }

    /**
     * To verify CreateAccount Button link On TryAgain Page
     * @param - String - lsExpectedUrlFromYml
     */
    public void verifyCreateAccountButtonLinkOnTryAgainPage(String lsExpectedUrlFromYml){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCreateNewAccount);
        String lsNavigatedUrl=this.btnCreateNewAccount.getAttribute("href");
        lsExpectedUrlFromYml=this.getBaseURL()+lsExpectedUrlFromYml;
        if(lsNavigatedUrl.equalsIgnoreCase(lsExpectedUrlFromYml)){
            reporter.reportLogPass("The navigated Url:'"+lsNavigatedUrl+"' is the same as the expected:'"+lsExpectedUrlFromYml+"'");
        }
        else{
            reporter.reportLogFail("The navigated Url:'"+lsNavigatedUrl+"' is not the same as the expected:'"+lsExpectedUrlFromYml+"'");
        }
    }

    /**
     * To verify Transfer Phone Account Button On TryAgain Page
     * @param - String - lsExpectedUrlFromYml
     */
    public void verifyTransferPhoneAccountButtonLinkOnTryAgainPage(String lsExpectedUrlFromYml){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTransferMyPhoneAccount);
        String lsNavigatedUrl=this.btnTransferMyPhoneAccount.getAttribute("href");
        lsExpectedUrlFromYml=this.getBaseURL()+lsExpectedUrlFromYml;
        if(lsNavigatedUrl.equalsIgnoreCase(lsExpectedUrlFromYml)){
            reporter.reportLogPass("The navigated Url:'"+lsNavigatedUrl+"' is the same as the expected:'"+lsExpectedUrlFromYml+"'");
        }
        else{
            reporter.reportLogFail("The navigated Url:'"+lsNavigatedUrl+"' is not the same as the expected:'"+lsExpectedUrlFromYml+"'");
        }
    }


    /**
     * To verify Clicking Create new account Button On TryAgain Page
     * @param - String - lsExpectedUrlFromYml
     */
    public void verifyClickingCreateAccountButtonOnTryAgainPage(String lsExpectedUrlFromYml){
        String lsUrlBeforeClicking=this.URL();
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCreateNewAccount);
        this.btnCreateNewAccount.click();

        this.waitForCondition(Driver->{return !this.URL().equalsIgnoreCase(lsUrlBeforeClicking);},120000);
        String lsExpectedUrl=this.getBaseURL()+lsExpectedUrlFromYml;
        String lsNavigatedUrl=this.URL();
        if(lsNavigatedUrl.equalsIgnoreCase(lsExpectedUrl)){
            reporter.reportLogPass("The navigated Url:'"+lsNavigatedUrl+"' after clicking create new account button is the same as the expected:'"+lsExpectedUrl+"'");
        }
        else{
            reporter.reportLogFail("The navigated Url:'"+lsNavigatedUrl+"' after clicking create new account button is not the same as the expected:'"+lsExpectedUrl+"'");
        }
    }

    /**
     * To verify Clicking Transfer phone account Button On TryAgain Page
     * @param - String - lsExpectedUrlFromYml
     */
    public void verifyClickingTransferPhoneAccountButtonOnTryAgainPage(String lsExpectedUrlFromYml){
        String lsUrlBeforeClicking=this.URL();
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTransferMyPhoneAccount);
        this.btnTransferMyPhoneAccount.click();

        this.waitForCondition(Driver->{return !this.URL().equalsIgnoreCase(lsUrlBeforeClicking);},120000);
        String lsExpectedUrl=this.getBaseURL()+lsExpectedUrlFromYml;
        String lsNavigatedUrl=this.URL();
        if(lsNavigatedUrl.equalsIgnoreCase(lsExpectedUrl)){
            reporter.reportLogPass("The navigated Url:'"+lsNavigatedUrl+"' after clicking Transfer My Phone Account button is the same as the expected:'"+lsExpectedUrl+"'");
        }
        else{
            reporter.reportLogFail("The navigated Url:'"+lsNavigatedUrl+"' after clicking Transfer My Phone Account button is not the same as the expected:'"+lsExpectedUrl+"'");
        }
    }

    /**
     * To fill Answer Security Questions Form
     * @param - String - phoneNumber
     * @param - String - postalCode
     * @param - String - securityQuestionAnswer
     */
    public void fillAnswerSecurityQuestionsForm(String phoneNumber,String postalCode,String securityQuestionAnswer){
        String phoneNumberField1=phoneNumber.substring(0,3);
        String phoneNumberField2=phoneNumber.substring(3,6);
        String phoneNumberField3=phoneNumber.substring(6);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputQuestion1ForPhoneNumberField1);
        this.inputQuestion1ForPhoneNumberField1.clear();
        this.inputQuestion1ForPhoneNumberField1.sendKeys(phoneNumberField1);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputQuestion1ForPhoneNumberField2);
        this.inputQuestion1ForPhoneNumberField2.clear();
        this.inputQuestion1ForPhoneNumberField2.sendKeys(phoneNumberField2);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputQuestion1ForPhoneNumberField3);
        this.inputQuestion1ForPhoneNumberField3.clear();
        this.inputQuestion1ForPhoneNumberField3.sendKeys(phoneNumberField3);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputQuestion2ForPostalCode);
        this.inputQuestion2ForPostalCode.clear();
        this.inputQuestion2ForPostalCode.sendKeys(postalCode);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputQuestion3ForSecurityAnswer);
        this.inputQuestion3ForSecurityAnswer.clear();
        this.inputQuestion3ForSecurityAnswer.sendKeys(securityQuestionAnswer);
        this.applyStaticWait(300);
    }

    /**
     * To fill New Password Form
     * @param - String - newPassword
     */
    public void fillNewPasswordForm(String newPassword){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputNewPassword);
        this.inputNewPassword.clear();
        this.inputNewPassword.sendKeys(newPassword);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputConfirmNewPassword);
        this.inputConfirmNewPassword.clear();
        this.inputConfirmNewPassword.sendKeys(newPassword);
        this.applyStaticWait(300);
    }

    /**
     * To fill Add Security Question Form
     * @param - String - newSecurityQuestionAnswer
     */
    public void fillAddSecurityQuestionForm(String newSecurityQuestionAnswer){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectSecurityQuestion);
        Select select=new Select(this.selectSecurityQuestion);
        select.selectByIndex(1);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputSecurityQuestionAnswer);
        this.inputSecurityQuestionAnswer.clear();
        this.inputSecurityQuestionAnswer.sendKeys(newSecurityQuestionAnswer);
        this.applyStaticWait(300);
    }

    /**
     * To clicking Save Button On Add Security Question Page
     * @return - boolean
     */
    public boolean clickingSaveButtonOnAddSecurityQuestionPage(){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSaveAndContinue);
        this.getReusableActionsInstance().clickIfAvailable(this.btnSaveAndContinue);
        MyAccount myAccount=new MyAccount(this.getDriver());

        return this.waitForCondition(Driver->{return myAccount.lblMyAccountHeaderTitle.isDisplayed();},120000);
    }

    /**
     * To reset password
     * @param - String - email
     * @param - String - phoneNumber
     * @param - String - postalCode
     * @param - String - securityQuestionAnswer
     * @param - String - newPassword
     * @param - String - newSecurityQuestionAnswer
     */
    public void resetPassword(String email,String phoneNumber,String postalCode,String securityQuestionAnswer,String newPassword,String newSecurityQuestionAnswer){
        this.goToAnswerSecurityQuestionsPageWithRegisteredEmail(email);

        this.fillAnswerSecurityQuestionsForm(phoneNumber,postalCode,securityQuestionAnswer);
        this.goToResetPasswordPage();

        this.fillNewPasswordForm(newPassword);
        this.goToAddSecurityQuestionForNewPasswordPage();

        this.fillAddSecurityQuestionForm(newSecurityQuestionAnswer);
        this.clickingSaveButtonOnAddSecurityQuestionPage();
    }

    /**
     * To verify Clicking Cancel Button On Answer Security Question Page
     * @param - String - lsExpectedUrlFromYml
     */
    public void verifyClickingCancelButtonOnAnswerSecurityQuestionPage(String lsExpectedUrlFromYml){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnResetPasswordCancel);
        this.setElementEnabled(this.btnResetPasswordCancel);
        this.applyStaticWait(300);
        this.clickElement(this.btnResetPasswordCancel);

        SignInPage signInPage=new SignInPage(this.getDriver());
        this.waitForCondition(Driver->{return signInPage.lblSignIn.isDisplayed();},120000);
        String lsExpectedUrl=this.getBaseURL()+lsExpectedUrlFromYml;
        String lsNavigatedUrl=this.URL();
        if(lsNavigatedUrl.equalsIgnoreCase(lsExpectedUrl)){
            reporter.reportLogPass("The navigated Url:'"+lsNavigatedUrl+"' after clicking cancel button on answer security questions page is the same as the expected:'"+lsExpectedUrl+"'");
        }
        else{
            reporter.reportLogFail("The navigated Url:'"+lsNavigatedUrl+"' after clicking cancel button on answer security questions page is not the same as the expected:'"+lsExpectedUrl+"'");
        }
    }

    /**
     * To verify Invalid Email Input Error Messages
     * @param - String - expectedErrorMessageForBlankEmailCheckingFromYml
     * @param - String - expectedErrorMessageForInvalidEmailFormatCheckingFromYml
     */
    public void verifyInvalidEmailInputErrorMessages(String expectedErrorMessageForBlankEmailCheckingFromYml,String expectedErrorMessageForInvalidEmailFormatCheckingFromYml){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputEmail);
        inputEmail.clear();
        inputEmail.click();
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnContinue);
        this.btnContinue.click();
        this.waitForCondition(Driver->{return lblEmailRequiredErrorMessage.isDisplayed(); },120000);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblEmailRequiredErrorMessage);
        String lsText=lblEmailRequiredErrorMessage.getText().trim();
        if(lsText.equalsIgnoreCase(expectedErrorMessageForBlankEmailCheckingFromYml)){
            reporter.reportLogPass("The error message:'"+lsText+"' for blank email is the same as expected:'"+expectedErrorMessageForBlankEmailCheckingFromYml+"'");
        }
        else{
            reporter.reportLogFail("The error message:'"+lsText+"' for blank email is not the same as expected:'"+expectedErrorMessageForBlankEmailCheckingFromYml+"'");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputEmail);
        inputEmail.clear();
        inputEmail.sendKeys("Test");
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnContinue);
        this.btnContinue.click();
        this.waitForCondition(Driver->{return lblEmailRequiredErrorMessage.isDisplayed(); },120000);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblEmailRequiredErrorMessage);
        lsText=lblEmailRequiredErrorMessage.getText().trim();
        if(lsText.equalsIgnoreCase(expectedErrorMessageForInvalidEmailFormatCheckingFromYml)){
            reporter.reportLogPass("The error message:'"+lsText+"' for invalid email format is the same as expected:'"+expectedErrorMessageForInvalidEmailFormatCheckingFromYml+"'");
        }
        else{
            reporter.reportLogFail("The error message:'"+lsText+"' for invalid email format is not the same as expected:'"+expectedErrorMessageForInvalidEmailFormatCheckingFromYml+"'");
        }
    }

    /**
     * To verify Error Messages For Blank Answers For Security Questions
     * @param - List<String> - lstErrorMessageFromYml
     */
    public void verifyErrorMessagesForBlankAnswersForSecurityQuestions(List<String> lstErrorMessageFromYml){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnResetPassword);
        btnResetPassword.click();
        waitForCondition(Driver->{return lstAllErrorMessageForSecurityQuestions.size()>0;},120000);

        String lsActual,lsExpected;
        WebElement item;
        int loopSize=lstAllErrorMessageForSecurityQuestions.size();
        for(int i=0;i<loopSize;i++){
            item=lstAllErrorMessageForSecurityQuestions.get(i);
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
     * To verify Error Messages For Invalid Answers For Security Questions
     * @param - String - phoneNumber
     * @param - String - postalCode
     * @param - String - lsErrorMessageFromYml
     */
    public void verifyErrorMessagesForInvalidAnswersForSecurityQuestions(String phoneNumber,String postalCode,String lsErrorMessageFromYml){
        String phoneNumberField1=phoneNumber.substring(0,3);
        String phoneNumberField2=phoneNumber.substring(3,6);
        String phoneNumberField3=phoneNumber.substring(6);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputQuestion1ForPhoneNumberField1);
        this.inputQuestion1ForPhoneNumberField1.clear();
        this.inputQuestion1ForPhoneNumberField1.sendKeys(phoneNumberField1);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputQuestion1ForPhoneNumberField2);
        this.inputQuestion1ForPhoneNumberField2.clear();
        this.inputQuestion1ForPhoneNumberField2.sendKeys(phoneNumberField2);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputQuestion1ForPhoneNumberField3);
        this.inputQuestion1ForPhoneNumberField3.clear();
        this.inputQuestion1ForPhoneNumberField3.sendKeys(phoneNumberField3);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputQuestion2ForPostalCode);
        this.inputQuestion2ForPostalCode.clear();
        this.inputQuestion2ForPostalCode.sendKeys(postalCode);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputQuestion3ForSecurityAnswer);
        this.inputQuestion3ForSecurityAnswer.clear();
        this.inputQuestion3ForSecurityAnswer.sendKeys("Error");
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnResetPassword);
        setElementEnabled(btnResetPassword);
        this.applyStaticWait(3000);
        this.clickElement(btnResetPassword);
        //btnResetPassword.click();
        this.waitForCondition(Driver->{return lstAllErrorMessageForSecurityQuestions.size()>0;},120000);
        this.applyStaticWait(3*this.getStaticWaitForApplication());

        WebElement item=lstAllErrorMessageForSecurityQuestions.get(0);
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
        String lsActual=item.getText().trim();
        if(lsActual.equalsIgnoreCase(lsErrorMessageFromYml)){
            reporter.reportLogPass("The error message:'"+lsActual+"' is the same as the expected:'"+lsErrorMessageFromYml+"'");
        }
        else{
            reporter.reportLogFail("The error message:'"+lsActual+"' is not the same as the expected:'"+lsErrorMessageFromYml+"'");
        }
    }

    /**
     * To verify Error Messages For Blank Password Input
     * @param - List<String> - lstErrorMessageFromYml
     */
    public void verifyErrorMessagesForBlankPasswordInput(List<String> lstErrorMessageFromYml){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCreateNewPassword);
        this.btnCreateNewPassword.click();
        waitForCondition(Driver->{return lstAllErrorMessageForPasswordInput.size()>0;},120000);

        String lsActual,lsExpected;
        WebElement item;
        int loopSize=lstAllErrorMessageForPasswordInput.size();
        for(int i=0;i<loopSize;i++){
            item=lstAllErrorMessageForPasswordInput.get(i);
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
     * To verify Error Message For Not Matched Passwords Input
     * @param - String - lsErrorMessageFromYml
     */
    public void verifyErrorMessageForNotMatchedPasswordsInput(String lsErrorMessageFromYml){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputNewPassword);
        inputNewPassword.clear();
        inputNewPassword.sendKeys("qa1234");
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputConfirmNewPassword);
        inputConfirmNewPassword.clear();
        inputConfirmNewPassword.sendKeys("qa12345");
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCreateNewPassword);
        this.btnCreateNewPassword.click();
        waitForCondition(Driver->{return lstAllErrorMessageForPasswordInput.size()>0;},120000);
        this.applyStaticWait(this.getStaticWaitForApplication());

        WebElement item=lstAllErrorMessageForPasswordInput.get(0);
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
        String lsActual=item.getText().trim();
        if(lsActual.equalsIgnoreCase(lsErrorMessageFromYml)){
            reporter.reportLogPass("The error message:'"+lsActual+"' is the same as the expected:'"+lsErrorMessageFromYml+"'");
        }
        else{
            reporter.reportLogFail("The error message:'"+lsActual+"' is not the same as the expected:'"+lsErrorMessageFromYml+"'");
        }
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
     * To check PassWordShowBtn Status
     * @param - WebElement - showPasswordButton - for password or confirm password
     * @return - boolean - true for show and false for hide
     */
    public boolean getShowButtonStatus(WebElement showPasswordButton){
        return this.getElementInnerText(showPasswordButton).equalsIgnoreCase("Show");
    }

    /**
     * To verify Show Or Hide Password Function
     */
    public void verifyShowOrHidePasswordFunction(){
        reporter.reportLog("Check new password");
        reporter.reportLog("Check the initial status");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnShowNewPassword);
        if(getInputPasswordStatus(this.inputNewPassword)){
            reporter.reportLogPass("The input type is password");
        }
        else{
            reporter.reportLogFailWithScreenshot("The input type is not password");
        }

        if(getShowButtonStatus(this.btnShowNewPassword)){
            reporter.reportLogPass("The button text is 'show'");
        }
        else{
            reporter.reportLogFailWithScreenshot("The button text is not 'show'");
        }

        reporter.reportLog("Check the status after clicking the button");
        this.getReusableActionsInstance().clickIfAvailable(this.btnShowNewPassword);
        this.waitForCondition(Driver->{return !getShowButtonStatus(this.btnShowNewPassword);},5000);
        if(!getInputPasswordStatus(this.inputNewPassword)){
            reporter.reportLogPass("The input type is text");
        }
        else{
            reporter.reportLogFailWithScreenshot("The input type is not text");
        }

        if(!getShowButtonStatus(btnShowNewPassword)){
            reporter.reportLogPass("The button text is 'hide'");
        }
        else{
            reporter.reportLogFailWithScreenshot("The button text is not 'hide'");
        }

        reporter.reportLog("Check confirmed password");
        reporter.reportLog("Check the initial status");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnShowConfirmNewPassword);
        if(getInputPasswordStatus(this.inputConfirmNewPassword)){
            reporter.reportLogPass("The input type is password");
        }
        else{
            reporter.reportLogFailWithScreenshot("The input type is not password");
        }

        if(getShowButtonStatus(this.btnShowConfirmNewPassword)){
            reporter.reportLogPass("The button text is 'show'");
        }
        else{
            reporter.reportLogFailWithScreenshot("The button text is not 'show'");
        }

        reporter.reportLog("Check the status after clicking the button");
        this.getReusableActionsInstance().clickIfAvailable(this.btnShowConfirmNewPassword);
        this.waitForCondition(Driver->{return !getShowButtonStatus(this.btnShowConfirmNewPassword);},5000);
        if(!getInputPasswordStatus(this.inputConfirmNewPassword)){
            reporter.reportLogPass("The input type is text");
        }
        else{
            reporter.reportLogFailWithScreenshot("The input type is not text");
        }

        if(!getShowButtonStatus(this.btnShowConfirmNewPassword)){
            reporter.reportLogPass("The button text is 'hide'");
        }
        else{
            reporter.reportLogFailWithScreenshot("The button text is not 'hide'");
        }
    }

    /**
     * To verify Show Or Hide Security Question Answer Function
     */
    public void verifyShowOrHideSecurityQuestionAnswerFunction(){
        reporter.reportLog("Check the initial status");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnShowAnswer);
        if(!getInputPasswordStatus(this.inputSecurityQuestionAnswer)){
            reporter.reportLogPass("The input type is not encrypted");
        }
        else{
            reporter.reportLogFailWithScreenshot("The input type is encrypted");
        }

        if(!getShowButtonStatus(this.btnShowAnswer)){
            reporter.reportLogPass("The button text is 'hide'");
        }
        else{
            reporter.reportLogFailWithScreenshot("The button text is not 'hide'");
        }

        reporter.reportLog("Check the status after clicking the button");
        this.getReusableActionsInstance().clickIfAvailable(this.btnShowAnswer);
        this.waitForCondition(Driver->{return getShowButtonStatus(this.btnShowAnswer);},5000);
        if(getInputPasswordStatus(this.inputSecurityQuestionAnswer)){
            reporter.reportLogPass("The input type is password type");
        }
        else{
            reporter.reportLogFailWithScreenshot("The input type is text");
        }

        if(getShowButtonStatus(btnShowAnswer)){
            reporter.reportLogPass("The button text is 'show'");
        }
        else{
            reporter.reportLogFailWithScreenshot("The button text is not 'show'");
        }
    }

    /**
     * To change user security question
     * @param - String - customerEDP
     * @param - String - accessToken
     * @return - Map<String,Object> - contains selected question and answer
     */
    public Map<String,Object> changeUserSecurityQuestion(String customerEDP,String accessToken) throws IOException {
        AccountAPI accountAPI=new AccountAPI();

        List<SecurityQuestionResponse> securityQuestionList=accountAPI.getUserSecurityQuestionList(accessToken);
        int count=securityQuestionList.size();

        Random rand = new Random();
        int randomNumber = rand.nextInt(count-1);

        String lsOption=securityQuestionList.get(randomNumber).getQuestion();
        int questionId=securityQuestionList.get(randomNumber).getQuestionId();

        String lsAnswer;
        if(lsOption.contains("born")){
            lsAnswer="1950";
        }
        else{
            lsAnswer="Answer";
        }

        accountAPI.setUserSecurityQuestionAnswer(customerEDP,accessToken,questionId,lsAnswer);

        Map<String,Object> map=new HashMap<>();
        map.put("SelectText",lsOption);
        map.put("Answer",lsAnswer);

        return map;
    }

}
