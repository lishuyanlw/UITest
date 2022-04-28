package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccount_Mobile extends BasePage {

	public MyAccount_Mobile(WebDriver driver) {
		super(driver);
	}

	//For view details
	@FindBy(xpath = "//ng-component//a[contains(@href,'orderinvoice') and contains(@class,'visible-xs')]")
	public WebElement btnOrderDetailsHeaderViewInvoice;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Shipping Address:']")
	public WebElement lblOrderDetailsSubHeaderShippingAddressTitle;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Shipping Address:']/following-sibling::div")
	public WebElement lblOrderDetailsSubHeaderShippingAddress;

	public By byOrderDetailsOrderItemWriteReview=By.xpath(".//div[contains(@class,'product-review') and contains(@class,'visible-xs-block')]//a[contains(@href,'openreview')]");
	public By byOrderDetailsOrderItemQTYTitle=By.xpath(".//span[contains(normalize-space(.),'QTY:')]/parent::div[contains(@class,'visible-xs-block')]/span[1]");
	public By byOrderDetailsOrderItemQTY=By.xpath(".//span[contains(normalize-space(.),'QTY:')]/parent::div[contains(@class,'visible-xs-block')]/span[2]");
	public By byOrderDetailsOrderItemStatusTitle=By.xpath(".//span[contains(normalize-space(.),'Status:')]/parent::div[contains(@class,'visible-xs-block')]/span[1]");
	public By byOrderDetailsOrderItemStatus=By.xpath(".//span[contains(normalize-space(.),'Status:')]/parent::div[contains(@class,'visible-xs-block')]/span[2]");


}
