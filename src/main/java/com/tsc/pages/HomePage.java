package com.tsc.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

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
	
	//For Shop by brand by Wei.Li
	
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]/ancestor::div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//*[contains(@class,'anchor-carousel__title')]")
	WebElement lblShopByBrand;
	
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[contains(@class,'slick-slide') and not(contains(@class,'slick-cloned'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]//a")
	List<WebElement> lnkShopByBrandAllLinks;
	
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[contains(@class,'slick-slide') and not(contains(@class,'slick-cloned'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]//img")
	List<WebElement> imgShopByBrandAllImages;
	
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[contains(@class,'slick-active') and not(contains(@class,'slick-cloned'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]//a")
	List<WebElement> lnkShopByBrandAllActiveLinks;
	
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[contains(@class,'slick-active') and not(contains(@class,'slick-cloned'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]//img")
	List<WebElement> imgShopByBrandAllActiveImages;
	
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]/ancestor::div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//button[contains(@class,'slick-prev')]")
	WebElement btnShopByBrandPrev;
	
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]/ancestor::div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//button[contains(@class,'slick-next')]")
	WebElement btnShopByBrandNext;
	
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]/ancestor::div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//a[contains(@class,'anchor-carousel__link')]")
	WebElement btnViewAll;
		
	//TOP SELLERS by Wei.Li	
	
	@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-header')]")
	WebElement lblTopSeller;
	
	@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-col')]//a")
	List<WebElement> lnkTopSellerAllLinks;
	
	@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-col')]//img")
	List<WebElement> imgTopSellerAllImages;
	
	@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-col')]//div[contains(@class,'prec-name')]")
	List<WebElement> lblTopSellerAllNames;
	
	@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-col')]//div[contains(@class,'now-price')]")
	List<WebElement> lblTopSellerAllNowPrices;
	
	@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-col')]//div[contains(@class,'was-price')]")
	List<WebElement> lblTopSellerAllWasPrices;
			
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
		
		/**
		 * This method will validate ShopByBrand header text
		 *
		 * @return String: ShopByBrand text
		 * @author Wei.Li
		 */			
		public String validateShopByBrandHeaderText() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblShopByBrand);
			return lblShopByBrand.getText().trim();
		}
		
		/**
		 * This method will validate ShopByBrand hrefs are not empty
		 *
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateShopByBrandHref() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblShopByBrand);
			for(WebElement item: this.lnkShopByBrandAllLinks) {
				if(item.getAttribute("href").isEmpty()) {
					return false;
				}
			}
			return true;
		}
		
		/**
		 * This method will validate ShopByBrand Imgs are not empty
		 *
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateShopByBrandImg() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblShopByBrand);
			for(WebElement item: this.imgShopByBrandAllImages) {
				if(item.getAttribute("src").isEmpty()) {
					return false;
				}
			}
			return true;
		}
		
		/**
		 * This method will validate clicking ShopByBrand Prev button
		 *
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateShopByBrandClickPrevButton() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblShopByBrand);
			
			List<String> lnkListBefore= new ArrayList<String>();
			for(WebElement item:this.lnkShopByBrandAllActiveLinks) {
				lnkListBefore.add(item.getAttribute("href"));
			}
			if(!this.getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]/ancestor::div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//button[contains(@class,'slick-prev')]"),30)) {
				return true;
			}
			
			this.btnShopByBrandPrev.click();
			
			String lsCurrentHref=lnkListBefore.get(0);
			
			waitForCondition(Driver->{return !lsCurrentHref.equalsIgnoreCase(this.lnkShopByBrandAllActiveLinks.get(0).getAttribute("href"));},10000);
						
			List<String> lnkListAfter= new ArrayList<String>();
			for(WebElement item:this.lnkShopByBrandAllActiveLinks) {
				lnkListAfter.add(item.getAttribute("href"));
			}
			
			Set<String> currentSet = new HashSet<String>(lnkListBefore);
			Set<String> afterSet = new HashSet<String>(lnkListAfter);
			currentSet.removeAll(afterSet);
			if(currentSet.isEmpty()) {
				return false;
			}
			else {
				return true;
			}						
		}
		
		/**
		 * This method will validate clicking ShopByBrand Next button
		 *
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateShopByBrandClickNextButton() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblShopByBrand);
			
			List<String> lnkListBefore= new ArrayList<String>();
			for(WebElement item:this.lnkShopByBrandAllActiveLinks) {
				lnkListBefore.add(item.getAttribute("href"));
			}
			if(!this.getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]/ancestor::div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//button[contains(@class,'slick-next')]"),30)) {
				return true;
			}
			this.btnShopByBrandNext.click();
			
			String lsCurrentHref=lnkListBefore.get(0);
			
			waitForCondition(Driver->{return !lsCurrentHref.equalsIgnoreCase(this.lnkShopByBrandAllActiveLinks.get(0).getAttribute("href"));},10000);
				
			List<String> lnkListAfter= new ArrayList<String>();
			for(WebElement item:this.lnkShopByBrandAllActiveLinks) {
				lnkListAfter.add(item.getAttribute("href"));
			}
			
			Set<String> currentSet = new HashSet<String>(lnkListBefore);
			Set<String> afterSet = new HashSet<String>(lnkListAfter);
			currentSet.removeAll(afterSet);
			if(currentSet.isEmpty()) {
				return false;
			}
			else {
				return true;
			}						
		}
		
		/**
		 * This method will validate automatic scrolling action
		 *
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateShopByBrandAutomaticScrollingAction() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblShopByBrand);
			
			//Return if all slides are no more than 5
			if(this.lnkShopByBrandAllLinks.size()<=5) {
				return true;
			}
			
			List<String> lnkListBefore= new ArrayList<String>();
			for(WebElement item:this.lnkShopByBrandAllActiveLinks) {
				lnkListBefore.add(item.getAttribute("href"));
			}
			
			String lsCurrentHref=lnkListBefore.get(0);
			System.out.println("Current href:"+lsCurrentHref);
			waitForCondition(Driver->{return !lsCurrentHref.equalsIgnoreCase(this.lnkShopByBrandAllActiveLinks.get(0).getAttribute("href"));},30000);
			System.out.println("Change href:"+this.lnkShopByBrandAllActiveLinks.get(0).getAttribute("href"));
			
			List<String> lnkListAfter= new ArrayList<String>();
			for(WebElement item:this.lnkShopByBrandAllActiveLinks) {
				lnkListAfter.add(item.getAttribute("href"));
			}
			
			Set<String> currentSet = new HashSet<String>(lnkListBefore);
			Set<String> afterSet = new HashSet<String>(lnkListAfter);
			currentSet.removeAll(afterSet);
			if(currentSet.isEmpty()) {
				return false;
			}
			else {
				return true;
			}						
		}
		
		/**
		 * This method will validate ShopByBrand ViewAll link
		 *
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateShopByBrandViewAllLink() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(btnViewAll);
			String strLink=this.btnViewAll.getAttribute("href").trim();
			System.out.println(strLink);
			System.out.println(getBaseURL()+"/pages/brand");
			return strLink.equalsIgnoreCase(getBaseURL()+"/pages/brand");					
		}
		
		/**
		 * This method will validate URL after clicking ViewAll link of ShopByBrand.
		 *
		 * @return true/false
		 * @author Wei.Li
		 */	
		public boolean validateShopByBrandUrlAfterClickingViewAllLink() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(btnViewAll);
	        return verifyURLNotContainsNotFoundAfterClickingElement(this.btnViewAll);
	    }
	
		/**
		 * This method will get TopSeller header text
		 *
		 * @return String: TopSeller header text
		 * @author Wei.Li
		 */	    
		public String getTopSellerHeaderText() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblTopSeller);
			System.out.println("Top seller header:"+lblTopSeller.getText().trim());
			return lblTopSeller.getText().trim();
		}
		
		/**
		 * This method will validate TopSeller is above Footer
		 *
		 * @return true/false
		 * @author Wei.Li
		 */		
		public boolean validateTopSellerIsAboveFooter() {
			return this.getReusableActionsInstance().isElementVisible(By.xpath("//div[@class='Footer']/preceding-sibling::div[@class='Middle']//product-recommendations-endeca//*[contains(@class,'prec-header')]"),30);
		}
		
		/**
		 * This method will validate TopSeller hrefs are not empty
		 *
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateTopSellerHref() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblTopSeller);
			for(WebElement item: this.lnkTopSellerAllLinks) {
				System.out.println(item.getAttribute("href"));
				if(item.getAttribute("href").isEmpty()) {
					return false;
				}
			}
			return true;
		}
		
		/**
		 * This method will validate TopSeller Images are not empty
		 *
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateTopSellerImg() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblTopSeller);
			for(WebElement item: this.imgTopSellerAllImages) {
				System.out.println(item.getAttribute("src"));
				if(item.getAttribute("src").isEmpty()) {
					return false;
				}
			}
			return true;
		}
		
		/**
		 * This method will validate TopSeller Names are not empty
		 *
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateTopSellerName() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblTopSeller);
			for(WebElement item: this.lblTopSellerAllNames) {
				System.out.println(item.getText());
				if(item.getText().isEmpty()) {
					return false;
				}
			}
			return true;
		}
		
		/**
		 * This method will validate TopSeller Current prices are not empty
		 *
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateTopSellerNowPrice() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblTopSeller);
			for(WebElement item: this.lblTopSellerAllNowPrices) {
				System.out.println(item.getText());
				if(item.getText().isEmpty()) {
					return false;
				}
			}
			return true;
		}
		
		/**
		 * This method will validate TopSeller past prices are not empty
		 *
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateTopSellerWasPrice() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblTopSeller);
			if(!this.getReusableActionsInstance().isElementVisible(By.xpath("//product-recommendations-endeca//*[contains(@class,'prec-col')]//div[contains(@class,'was-price')]"),30)) {
				return true;
			}
			for(WebElement item: this.lblTopSellerAllWasPrices) {
				System.out.println(item.getText());
				if(item.getText().isEmpty()) {
					return false;
				}
			}
			return true;
		}
		

}


