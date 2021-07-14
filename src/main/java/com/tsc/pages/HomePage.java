package com.tsc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tsc.pages.base.BasePage;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		}
	
	//On Air Section 
	//Now On Air (NOA) section elements
	
	@FindBy(xpath = "//h2[@class='oanHeader'][contains(text(),'On Air')]")
	WebElement NOAsection;
	
	@FindBy(xpath = "//*[@class='Middle']//*[@class='onAirNowImg']")
	WebElement imgNOA;

	@FindBy(xpath = "//*[@class='Middle']//div[@class='oanItemDesc']")
	WebElement lblNOAProductName;
	
	@FindBy(xpath = "//*[@class='Middle']//*[@class='oanSingleProduct']//a[contains(@href, 'productdetails')]")
	WebElement lnkNOA;
	
	@FindBy(xpath = "//*[contains(@class, 'oanBtn')]")
	WebElement btnShopNow;
	
	//Recently Aired (RA) section elements
	
	@FindBy(xpath = "//*[@class='recentlyAiredWrapper']//h2[@class='oanHeader']")
	WebElement RAsection;
	
	@FindBy(xpath = "//*[@class='shopAllDiv']//*[contains(@class, 'oanBtn')]")
	WebElement btnShopAllTodaysItem;
	
	//Price 
	@FindBy(xpath = "//del[@class='oanItemPrice']")
	WebElement lblitemPriceWas;
	
	@FindBy(xpath = "//div[@class='oanItemPrice']")
	WebElement lblitemPriceNow;
	
	@FindBy(xpath = "//*[@class='email-popup__button']")
	WebElement btnClose;
	
	
	//TS Main Image section 
	
	@FindBy(xpath = "//*[@class='tsZoneBottom']//h3")
	WebElement TSmainImagesection;
	
	
	public void closeadd() {
		btnClose.click();

	}

	
	public void waitForPageLoad() {
		new WebDriverWait(getDriver(), 1000).until(
				driver -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete"));
		}
	
	public boolean validateURL(String strExpectedUrl) {
		waitForPageLoad();
		if (getDriver().getCurrentUrl().equalsIgnoreCase(strExpectedUrl)) {
			return true;
			}
		return false;
		}
	//Validate Now On Air link
	public String validatelnkNOA() {
		String emptyhref="NOA href is empty";
		if (lnkNOA.getAttribute("href").isEmpty()) {
							
			return emptyhref;
			
		}else{
			return lnkNOA.getAttribute("href");
			}
		}
	
	
	//Now On Air(NOA) Image is visible
	
	public boolean validateNOAimg() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(NOAsection);
			return getReusableActionsInstance().isElementVisible(imgNOA, 10);
		}
	
	public boolean validatelblNOAProductName() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(NOAsection);
			return getReusableActionsInstance().isElementVisible(lblNOAProductName, 10);
		}
			
	public String getlblNOAProductName() {
			return lblNOAProductName.getText();
			}
	
	//Product Price
	
	public boolean validateWasPricetag() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(NOAsection);
			return getReusableActionsInstance().isElementVisible(lblitemPriceWas, 10);
		}
	
	public boolean validateNowPricetag() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(NOAsection);
			return getReusableActionsInstance().isElementVisible(lblitemPriceNow, 10);
		}
	
	
	//Shop now button is visible
	
	public boolean btnShopNowVisible() {
		 getReusableActionsInstance().javascriptScrollByVisibleElement(NOAsection);
		 	return	getReusableActionsInstance().isElementVisible(btnShopNow, 10);
		}
	// Shop Now button link is not empty and get text of button
	public String validatebtnShopNow() {
		String emptySNbtn="Shop Now Button href is empty";
		if (btnShopNow.getAttribute("href").isEmpty()) {
							
			return emptySNbtn;
			
		}else{
			return btnShopNow.getText();
			}
		}
	
//Recently Aired (RA) Section images and shop all Today's items button
	
	public String validateROsection() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(RAsection);
		return RAsection.getText();
		}
	
	public boolean verifyRAimgCount() {
		List<WebElement> image = getAllRAimg();
		if (image.size() >=1 && image.size() <= 8) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(image.get(1));
				return true;
		}
		return false;
		}
	
	 public int getRAimgCount() {
			List<WebElement> image = getAllRAimg();
				return image.size();
		}
	
	 public List<WebElement> getAllRAimg() { 
		List<WebElement> RAimage = getDriver().findElements(By.xpath(
				"//*[@class='recentlyAiredWrapper']//*[@class='oanItem']//img"));
		  return RAimage; }
		 
	 public List<WebElement> getAllRAlinks()	{
			List<WebElement> RAlinks = getDriver().findElements(By.xpath(
				"//*[@class='recentlyAiredWrapper']//*[@class='oanItem']"));
			 return RAlinks;
		}
	 
	 //validate RA section images 
	 public String validateRAsectionLinks(int lnkNumber) {
			List<WebElement> RAlinks = getAllRAlinks();
			String emptyimglink="Image link href is empty";

			WebElement WebElement=RAlinks.get(lnkNumber).findElement(By.xpath(".//a[contains(@href, 'productdetails')]"));
			getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement);

					if (!WebElement.getAttribute("href").isEmpty()) {
						return WebElement.getAttribute("href");
					}else {
						return emptyimglink;
	 				}
	 
	 			}
	 public boolean validateRAsectionImages(int imgNumber) {
			List<WebElement> RAimgs = getAllRAlinks();
			//
			WebElement WebElement=RAimgs.get(imgNumber).findElement(By.xpath(".//img"));
			getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement);

					if (!WebElement.getAttribute("src").isEmpty()) {
						return true;
					}
						return false;
	 				}
	
		// Shop All Today's Items button link is not empty and get text of button
		public String validatebtnShopAllTodaysItem() {
			String emptySTAIbtn="Shop All Today's Item href is empty";
			if (btnShopAllTodaysItem.getAttribute("href").isEmpty()) {
								
				return emptySTAIbtn;
				
			}else{
				return btnShopAllTodaysItem.getText();
				}
			}
		
		//Shop now button is visible
		
		public boolean btnShopAllTodaysItemVisible() {
			 getReusableActionsInstance().javascriptScrollByVisibleElement(RAsection);
			 	return	getReusableActionsInstance().isElementVisible(btnShopAllTodaysItem, 10);
			}

		//TS main Image Section 
		
		public String validateTSmainImagesection() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(TSmainImagesection);
			return TSmainImagesection.getText();
			}
		
	
	

}
