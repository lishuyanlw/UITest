package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class ProductResultsPage_Mobile extends ProductResultsPage {

    public ProductResultsPage_Mobile(WebDriver driver) {
        super(driver);
    }

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__count-and-shorting']//button[@class='plp__count-and-shorting__filter-button']")
	public WebElement btnFilterPopup;
	
	//For filter popup window
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__header']//button[@class='plp-filter-panel__header__close']")
	public WebElement btnFilterPopupClose;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__header']//span[@class='plp-filter-panel__header__title']")
	public WebElement lblFilterPopupHeaderTitle;
    
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__header']//button[@class='plp-filter-panel__header__clear']")
	public WebElement btnFilterPopupClearAll;
	
}