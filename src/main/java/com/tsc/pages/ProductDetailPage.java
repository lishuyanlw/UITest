package com.tsc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tsc.pages.base.BasePage;

public class ProductDetailPage extends BasePage {
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Sign in menu
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//a")
	public WebElement btnSignInMainMenu;
	
	

	
	/**
	 * Method to hover on Sign in heading menu	  
	 * @author Wei.Li
	 */
	public void hoverOnSignInHeadingMenu() {
		getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		getReusableActionsInstance().staticWait(300);		
	}

	
}
