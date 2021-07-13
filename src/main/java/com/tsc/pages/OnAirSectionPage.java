package com.tsc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tsc.pages.base.BasePage;

public class OnAirSectionPage extends BasePage{
	
	
		public OnAirSectionPage(WebDriver driver) {
			super(driver);
			}
		//Now On Air (NOA) section elements
		
		@FindBy(xpath = "//h2[@class='oanHeader'][contains(text(),'On Air')]")
		WebElement NOAsection;
		
		@FindBy(xpath = "//*[@class='Middle']//*[@class='onAirNowImg']")
		WebElement NOAimg;

		@FindBy(xpath = "//*[@class='Middle']//div[@class='oanItemDesc']")
		WebElement NOAPrdctName;
		
		@FindBy(xpath = "//*[@class='Middle']//*[@class='oanSingleProduct']//a[contains(@href, 'productdetails')]")
		WebElement NOAlink;
		
		@FindBy(xpath = "//*[contains(@class, 'oanBtn')]")
		WebElement ShopNowbtn;
		
		//Recently Aired (RA) section elements
		
		@FindBy(xpath = "//*[@class='recentlyAiredWrapper']//h2[@class='oanHeader']")
		WebElement RAsection;
		
		@FindBy(xpath = "//*[@class='shopAllDiv']//*[contains(@class, 'oanBtn')]")
		WebElement ShopAllTodaysItembtn;
		
		//Price 
		@FindBy(xpath = "//del[@class='oanItemPrice']")
		WebElement itemPriceWas;
		
		@FindBy(xpath = "//div[@class='oanItemPrice']")
		WebElement itemPriceNow;
		
		@FindBy(xpath = "//*[@class='email-popup__button']")
		WebElement closebtn;
		
		
		public void closeadd() {
			closebtn.click();

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
		public String validateNOAlink() {
			String emptyhref="NOA href is empty";
			if (NOAlink.getAttribute("href").isEmpty()) {
								
				return emptyhref;
				
			}else{
				return NOAlink.getAttribute("href");
				}
			}
		
		
		//Now On Air(NOA) Image is visible
		
		public boolean validateNOAimg() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(NOAsection);
				return getReusableActionsInstance().isElementVisible(NOAimg, 10);
			}
		
		public boolean validateNOAprdctName() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(NOAsection);
				return getReusableActionsInstance().isElementVisible(NOAPrdctName, 10);
			}
				
		public String getNOAprdctName() {
				return NOAPrdctName.getText();
				}
		
		//Product Price
		
		public boolean validateWasPricetag() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(NOAsection);
				return getReusableActionsInstance().isElementVisible(itemPriceWas, 10);
			}
		
		public boolean validateNowPricetag() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(NOAsection);
				return getReusableActionsInstance().isElementVisible(itemPriceNow, 10);
			}
		
		
		//Shop now button is visible
		
		public boolean ShopNowbtnVisible() {
			 getReusableActionsInstance().javascriptScrollByVisibleElement(NOAsection);
			 	return	getReusableActionsInstance().isElementVisible(ShopNowbtn, 10);
			}
		// Shop Now button link is not empty and get text of button
		public String validateShopNowBtn() {
			String emptySNbtn="Shop Now Button href is empty";
			if (ShopNowbtn.getAttribute("href").isEmpty()) {
								
				return emptySNbtn;
				
			}else{
				return ShopNowbtn.getText();
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
			public String validateShopAllTodaysItemBtn() {
				String emptySTAIbtn="Shop All Today's Item href is empty";
				if (ShopAllTodaysItembtn.getAttribute("href").isEmpty()) {
									
					return emptySTAIbtn;
					
				}else{
					return ShopAllTodaysItembtn.getText();
					}
				}
			
			//Shop now button is visible
			
			public boolean ShopAllTodaysItembtnVisible() {
				 getReusableActionsInstance().javascriptScrollByVisibleElement(RAsection);
				 	return	getReusableActionsInstance().isElementVisible(ShopAllTodaysItembtn, 10);
				}


		
		 
	}
