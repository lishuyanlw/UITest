package com.tsc.pages;

import com.tsc.api.util.DataConverter;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class GuestCheckoutPage_Mobile extends GuestCheckoutPage {

	public GuestCheckoutPage_Mobile(WebDriver driver) {
		super(driver);
	}

	//For tooltip close button of password hint message
	@FindBy(xpath = "//div[@class='create-address__wrap']//form//div[@class='password__right']//div[contains(@class,'password__tooltip--close')]")
	public WebElement btnPasswordTooltipClose;

	@Override
	public void verifyTooltipWindowForPasswordHintMessage(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.labelEmailCreateAccount);
		iconPasswordHintMessage.click();
		this.waitForCondition(Driver->{return checkPasswordTooltipMessageDisplaying();},10000);
		this.applyStaticWait(this.getStaticWaitForApplication());
		String lsDeviceType=System.getProperty("Device");
		String lsBrowserType=System.getProperty("Browser");
		boolean bCheck=!((lsDeviceType.equalsIgnoreCase("Mobile")||lsDeviceType.equalsIgnoreCase("Tablet"))&& lsBrowserType.toLowerCase().contains("sauce"));
		if(bCheck){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblPasswordTooltipMessage);
			lsText= this.getElementInnerText(this.lblPasswordTooltipMessage);
		}
		else{
			lsText= this.getElementInnerText(this.cntPasswordTooltipMessage);
		}
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The password Tooltip Message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The password Tooltip Message is not displaying correctly");
		}
		if(bCheck){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnPasswordTooltipClose);
			btnPasswordTooltipClose.click();
			this.applyStaticWait(this.getStaticWaitForApplication());
		}
	}

	@Override
	public void verifyPayPalFunctionality(){
		reporter.reportLog("Unable to switch frame on mobile device due to automation tools issue.");

	}


}
