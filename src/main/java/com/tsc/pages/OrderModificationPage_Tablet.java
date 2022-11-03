package com.tsc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderModificationPage_Tablet extends OrderModificationPage {

	public OrderModificationPage_Tablet(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//shopping-cart//button[normalize-space(text())='CANCEL MODIFICATION'][contains(@class,'cancelModButton')]")
	public WebElement btnModifyOrderCancelModificationButton;

	@Override
	public void verifyModifyOrderCancelModificationButton() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderCancelModificationButton);
		lsText = btnModifyOrderCancelModificationButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The modify order Cancel Modification Button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The modify order Cancel Modification Button is not displaying correctly");
		}
	}

	@Override
	public void verifyNavigatedPageAfterClickingCancelModificationButton(String lsURL){
		String lsExpectedUrl=this.getBaseURL();
		lsExpectedUrl=lsExpectedUrl+lsURL;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderCancelModificationButton);
		btnModifyOrderCancelModificationButton.click();
		this.waitForCondition(Driver->{return (new MyAccount(this.getDriver())).inputAccountOrderSearch.isDisplayed();},60000);

		if(this.URL().equalsIgnoreCase(lsExpectedUrl)){
			reporter.reportLogPass("Navigated to order status page after clicking cancel modification button.");
		}
		else{
			reporter.reportLogFail("Failed to be navigated to order status page after clicking cancel modification button.");
		}
	}

}
