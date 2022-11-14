package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferPhoneAccountPage_Mobile extends TransferPhoneAccountPage {

	public TransferPhoneAccountPage_Mobile(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//create-phone-account-app//form//p[contains(text(),'Still don’t know your customer number?')]/preceding-sibling::img")
	public WebElement imgReceiptExample;

	@FindBy(xpath = "//create-phone-account-app//form//p[contains(text(),'Still don’t know your customer number?')]")
	public WebElement lblStillDoNotKnowYourCustomerNumberInfo;

	@FindBy(xpath = "//create-phone-account-app//form//p[contains(text(),'Still don’t know your customer number?')]/following-sibling::p")
	public WebElement lblCallPhoneNumberInfo;

	@Override
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

}
