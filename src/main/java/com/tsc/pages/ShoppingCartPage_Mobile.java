package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage_Mobile extends ShoppingCartPage {

	public ShoppingCartPage_Mobile(WebDriver driver) {
		super(driver);
	}

	public By byProductRedMessage=By.xpath(".//span[contains(@class,'item-status') and contains(@class,'visible-xs-inline')][span[@class='boldRedColor']]");
	public By byProductSelectQuantity=By.xpath(".//div[contains(@class,'tsc-forms') and contains(@class,'visible-xs-inline')]//select");

	/**
	 * To check Select Quantity Enabled for cart item
	 * @param - cartItem - item in lstCartItems
	 * @return - boolean
	 */
	public boolean checkSelectQuantityEnabled(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductSelectQuantity);
		return !this.hasElementAttribute(item,"disabled");
	}

	/**
	 * To check Red message existing for cart item
	 * @param - cartItem - item in lstCartItems
	 * @return - boolean
	 */
	public boolean checkRedMessageExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductDescContainer);
		return this.checkChildElementExistingByAttribute(item,"class","item-status");
	}

	/**
	 * To check Remove button existing for cart item
	 * @param - cartItem - item in lstCartItems
	 * @return - boolean
	 */
	public boolean checkRemoveButtonExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductSelectQuantity);
		return !this.hasElementAttribute(item,"disabled");
	}

}
