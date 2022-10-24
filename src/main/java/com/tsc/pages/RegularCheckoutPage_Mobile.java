package com.tsc.pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegularCheckoutPage_Mobile extends RegularCheckoutPage{

	public RegularCheckoutPage_Mobile(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__title--mobile']")
	public WebElement lblReviewOrderProgressBar;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//h3[@class='promocode__title']//div[@class='promocode__tooltip--msg']")
	public WebElement btnOrderSummaryPromoteCodeTooltipClose;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'placeorder__total-wrap')]//span[@class='placeorder__total-label']")
	public WebElement lblTotalPriceTitleAbovePlaceOrderButton;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'placeorder__total-wrap')]//span[@class='placeorder__total-value']")
	public WebElement lblTotalPriceAbovePlaceOrderButton;

	@Override
	public void verifyCheckoutHeaderContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconTSCHeaderLogo);
		if (this.getReusableActionsInstance().isElementVisible(iconTSCHeaderLogo)) {
			reporter.reportLogPass("The TSC header icon is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The TSC header icon is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCheckout);
		lsText = lblCheckout.getText().trim();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The checkout header title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The checkout header title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconAddressProgressBar);
		if (this.getReusableActionsInstance().isElementVisible(iconAddressProgressBar)) {
			reporter.reportLogPass("The address icon in progress bar is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The address icon in progress bar is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconPaymentProgressBar);
		if (this.getReusableActionsInstance().isElementVisible(iconPaymentProgressBar)) {
			reporter.reportLogPass("The payment icon in progress bar is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The payment icon in progress bar is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReviewOrderProgressBar);
		lsText = lblReviewOrderProgressBar.getText().trim();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The review order title in progress bar is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The review order title in progress bar is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconReviewOrderProgressBar);
		if (this.getReusableActionsInstance().isElementVisible(iconReviewOrderProgressBar)) {
			reporter.reportLogPass("The review order icon in header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The review order icon in header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnGoToShoppingBag);
		if (this.getReusableActionsInstance().isElementVisible(btnGoToShoppingBag)) {
			reporter.reportLogPass("The GoToShoppingBag button in header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The GoToShoppingBag button in header is not displaying correctly");
		}
	}

	@Override
	public String getPromoteCodeTooltipMessage(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconOrderSummaryPromoteCodeTooltip);
		iconOrderSummaryPromoteCodeTooltip.click();
		this.waitForCondition(Driver->{return this.checkPromoteCodeTooltipMessageDisplaying();},10000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryPromoteCodeTooltipMessage);
		String lsText= this.lblOrderSummaryPromoteCodeTooltipMessage.getText().trim();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnOrderSummaryPromoteCodeTooltipClose);
		btnOrderSummaryPromoteCodeTooltipClose.click();
		this.applyStaticWait(this.getStaticWaitForApplication());

		return lsText;
	}

	@Override
	public void verifyPromoteCodeContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryPromoteCodeTitle);
		lsText = lblOrderSummaryPromoteCodeTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Promote Code Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Promote Code Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconOrderSummaryPromoteCodeTooltip);
		if(this.getReusableActionsInstance().isElementVisible(iconOrderSummaryPromoteCodeTooltip)){
			reporter.reportLogPass("The OrderSummary Promote Code icon is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The OrderSummary Promote Code icon is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryTotalPriceTitle);
		iconOrderSummaryPromoteCodeTooltip.click();
		this.waitForCondition(Driver->{return this.checkPromoteCodeTooltipMessageDisplaying();},10000);
		String lsDeviceType=System.getProperty("Device");
		String lsBrowserType=System.getProperty("Browser");
		boolean bCheck=!((lsDeviceType.equalsIgnoreCase("Mobile")||lsDeviceType.equalsIgnoreCase("Tablet"))&& lsBrowserType.toLowerCase().contains("sauce"));
		if(bCheck){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryPromoteCodeTooltipMessage);
			lsText= this.getElementInnerText(this.lblOrderSummaryPromoteCodeTooltipMessage);
		}
		else{
			lsText= this.getElementInnerText(this.cntOrderSummaryPromoteCodeTooltip);
		}
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Promote Code Tooltip Message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Promote Code Tooltip Message is not displaying correctly");
		}
		if(bCheck){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnOrderSummaryPromoteCodeTooltipClose);
			btnOrderSummaryPromoteCodeTooltipClose.click();
			this.applyStaticWait(this.getStaticWaitForApplication());
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryPromoteCode);
		if(this.getReusableActionsInstance().isElementVisible(inputOrderSummaryPromoteCode)){
			reporter.reportLogPass("The OrderSummary Promote Code input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The OrderSummary Promote Code input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderSummaryPromoteCodeApply);
		lsText = btnOrderSummaryPromoteCodeApply.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Promote Code apply button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Promote Code apply button is not displaying correctly");
		}
	}

	@Override
	public void verifyGiftCardAndPlaceOrderContents() {
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTotalPriceTitleAbovePlaceOrderButton);
		lsText = lblTotalPriceTitleAbovePlaceOrderButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Total Price Title Above PlaceOrder Button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Total Price Title Above PlaceOrder Button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTotalPriceAbovePlaceOrderButton);
		lsText = lblTotalPriceAbovePlaceOrderButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Total Price Above PlaceOrder Button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Total Price Above PlaceOrder Button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderSummaryPlaceOrder);
		lsText = btnOrderSummaryPlaceOrder.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Place Order button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Place Order button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryPlaceOrderMessage);
		lsText = lblOrderSummaryPlaceOrderMessage.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Place Order message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Place Order message is not displaying correctly");
		}
	}

	@Override
	public void verifyPayPalFunctionality(){
		ShoppingCartPage_Mobile shoppingCartPage = new ShoppingCartPage_Mobile(this.getDriver());
		this.clickWebElementUsingJS(this.labelAddOrChangePaymentMethodDialogPaypalRadio);
		this.getDriver().switchTo().frame(shoppingCartPage.framePayPalFrameElement);
		this.waitForCondition(Driver->{return this.btnPayPalButton.isEnabled();},5000);
		this.getDriver().switchTo().defaultContent();
		shoppingCartPage.verifyPayPalPopUpExistenceOnClick();
	}

}