package com.tsc.pages;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	
	@FindBy(xpath = "//*[@class='oanHeader'][contains(text(),'On Air')]")
	WebElement NOAsection;
	
	@FindBy(xpath = "//*[@class='Middle']//*[@class='onAirNowImg']")
	WebElement imgNOA;

	@FindBy(xpath = "//*[@class='Middle']//div[@class='oanItemDesc']")
	WebElement lblNOAProductName;
	
	@FindBy(xpath = "//*[@class='Middle']//*[@class='oanSingleProduct']//a[contains(@href, 'productdetails') and not(contains(@class,'btn'))]")
	WebElement lnkNOA;
	
	@FindBy(xpath = "//*[@class='Middle']//*[@class='oanSingleProduct']//a[contains(@href, 'productdetails') and contains(@class,'btn')]")
	WebElement btnShopNow;
	
	//Recently Aired (RA) section elements
	
	@FindBy(xpath = "//*[@class='recentlyAiredWrapper']//*[@class='oanHeader']")
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

	//@FindBy(css = ".email-popup__button")
	//WebElement btnClose;
		
	//TS Main Image section
	@FindBy(xpath = "//div[contains(@class,'tsZoneHero')]//span[contains(@class,'pagination-bullet')]")
	List<WebElement> totalImageNavigateLink;

	@FindBy(xpath = "//*[@class='TsZone']//div[contains(@class,'tsZoneHero')]")
	WebElement TSimageUpperSection;
	
	@FindBy(xpath = "//div[@class='Header']/following::div[contains(@class,'swiper-pagination-bullets')][1]")
	WebElement totalTSimageUpperSection;
	
	@FindBy(xpath = "//div[@class='Header']/following::div[@class='swiper-wrapper'][1]//div[contains(@class,'swiper-slide-active')]/a[@class='slider-link--box']")
	WebElement linksTSimageUpperSection;
	
	@FindBy(xpath = "//div[@class='Header']/following::div[@class='swiper-wrapper'][1]//div[contains(@class,'swiper-slide-next') or contains(@class,'swiper-slide-active')]/a[@class='slider-link--box']")
	List<WebElement> hrefallTSimageUpperSection;
	
	@FindBy(xpath = "//div[@class='Header']/following::div[@class='swiper-wrapper'][1]//div[contains(@class,'swiper-slide-active')]")
	WebElement attriTSimageUpperSection;	
	
		
	@FindBy(xpath = "//div[@class='Header']/following::div[contains(@class,'swiper-pagination-bullets')][2]")
	WebElement totalTSimageLowerSection;
	
	@FindBy(xpath = "//div[@class='Header']/following::div[@class='swiper-wrapper'][2]//div[contains(@class,'swiper-slide-active')]/a[@class='slider-link--box']")
	WebElement linksTSimageLowerSection;
	
	@FindBy(xpath = "//div[@class='Header']/following::div[@class='swiper-wrapper'][2]//div[contains(@class,'swiper-slide-next') or contains(@class,'swiper-slide-active')]/a[@class='slider-link--box']")
	List<WebElement> hrefallTSimageLowerSection;
	
	@FindBy(xpath = "//div[@class='Header']/following::div[@class='swiper-wrapper'][2]//div[contains(@class,'swiper-slide-active')]")
	WebElement attriTSimageLowerSection;
		
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
	
	//@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-header')]")
	@FindBy(xpath="//div[@class='Footer']/preceding-sibling::div[@class='Middle']//div[@class='recommend']//*[contains(@class,'header')]")
	WebElement lblTopSeller;
	
	//@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-col')]//a")
	@FindBy(xpath="//div[@class='recommend']//*[contains(@class,'products')]/div[contains(@class,'products__item')]/a")
	List<WebElement> lnkTopSellerAllLinks;
	
	//@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-col')]//img")
	@FindBy(xpath="//div[@class='recommend']//*[contains(@class,'products')]/div[contains(@class,'products__item')]//img")
	List<WebElement> imgTopSellerAllImages;
	
	//@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-col')]//div[contains(@class,'prec-name')]")
	@FindBy(xpath="//div[@class='recommend']//*[contains(@class,'products')]/div[contains(@class,'products__item')]//div[contains(@class,'name')]")
	List<WebElement> lblTopSellerAllNames;
	
	//@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-col')]//div[contains(@class,'now-price')]")
	@FindBy(xpath="//div[@class='recommend']//*[contains(@class,'products')]/div[contains(@class,'products__item')]//div[contains(@class,'now-price')]")
	List<WebElement> lblTopSellerAllNowPrices;
	
	//@FindBy(xpath = "//product-recommendations-endeca//*[contains(@class,'prec-col')]//div[contains(@class,'was-price')]")
	@FindBy(xpath="//div[@class='recommend']//*[contains(@class,'products')]/div[contains(@class,'products__item')]//*[contains(@class,'was-price')]")
	List<WebElement> lblTopSellerAllWasPrices;
	
	//For Shop By Department by Shruti.Desai
	@FindBy(xpath = "//*[@class='Middle']//div[@class='PageTitleCentred']//descendant::*[contains(text(),'Department')]")
	WebElement lblShopByDepartment;
		
	@FindBy(xpath = "//*[@class='Middle']//div[@class='PageTitleCentred']//descendant::*[contains(text(),'Department')]/ancestor::div[@class='PageTitleCentred']/parent::div")
	WebElement locationShopByDepartment;
		
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[@class='slick-slide' or (contains(@class,'active'))]//div[a[contains(@href,'ic=HP_SBD')]]")
	List<WebElement> imgShopByDepartmentAllImages;
		
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[contains(@class,'slick-active') and not(contains(@class,'slick-cloned'))]//div[a[contains(@href,'ic=HP_SBD')]]//a")
	List<WebElement> lnkShopByDepartmentAllActiveLinks;
		
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[contains(@class,'slick-active') and not(contains(@class,'slick-cloned'))]//div[a[contains(@href,'ic=HP_SBD')]]//img")
	List<WebElement> imgShopByDepartmentAllActiveImages;
		
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[a[contains(@href,'ic=HP_SBD')]]/ancestor::div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//button[contains(@class,'slick-prev')]")
	WebElement btnShopByDepartmentPrev;
		
	@FindBy(xpath = "//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[a[contains(@href,'ic=HP_SBD')]]/ancestor::div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//button[contains(@class,'slick-next')]")
	WebElement btnShopByDepartmentNext;

	@FindBy(xpath = "//div[@class='breadcrumb']//a")
	WebElement btnHomePageBreadcrumb;
			
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
		if (lnkNOA.getAttribute("href").isEmpty())
			return emptyhref;
		else
			return lnkNOA.getAttribute("href");
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
		return getReusableActionsInstance().isElementVisible(lblitemPriceWas, 5);
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
		if(image.size() == 0)
			//Returning false if no image is present for On Air Section
			return false;
		else if (image.size() >=1 && image.size() <= 8) {
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
			if (btnShopAllTodaysItem.getAttribute("href").isEmpty())
				return emptySTAIbtn;
			else
				return btnShopAllTodaysItem.getText();
		}
		
		//Shop now button is visible
		
		public boolean btnShopAllTodaysItemVisible() {
			 getReusableActionsInstance().javascriptScrollByVisibleElement(RAsection);
			 return	getReusableActionsInstance().isElementVisible(btnShopAllTodaysItem, 10);
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
			if(!this.getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]/ancestor::div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//button[contains(@class,'slick-prev')]"),30)) {
				return true;
			}

			List<String> lnkListBefore= new ArrayList<String>();
			for(WebElement item:this.lnkShopByBrandAllActiveLinks) {
				lnkListBefore.add(item.getAttribute("href"));
			}

			String lsCurrentHref=lnkListBefore.get(0);
			this.btnShopByBrandPrev.click();
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
			if(!this.getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//div[a[contains(@href,'ic=HP_BrandsCarousel')]]/ancestor::div[contains(@class,'ImageAnchorCarousel') and not(contains(@class,'ImageAnchorCarouselData'))]//button[contains(@class,'slick-next')]"),30)) {
				return true;
			}

			List<String> lnkListBefore= new ArrayList<String>();
			for(WebElement item:this.lnkShopByBrandAllActiveLinks) {
				lnkListBefore.add(item.getAttribute("href"));
			}

			String lsCurrentHref=lnkListBefore.get(0);
			this.btnShopByBrandNext.click();
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
			//Clicking on title below to enable automatic scrolling in application while running automated test
			this.lblShopByBrand.click();
			
			//Return if all slides are no more than 5
			if(this.lnkShopByBrandAllLinks.size()<=5) {
				return true;
			}
			
			List<String> lnkListBefore= new ArrayList<String>();
			for(WebElement item:this.lnkShopByBrandAllActiveLinks) {
				lnkListBefore.add(item.getAttribute("href"));
			}
			
			String lsCurrentHref=lnkListBefore.get(0);			
			waitForCondition(Driver->{return !lsCurrentHref.equalsIgnoreCase(this.lnkShopByBrandAllActiveLinks.get(0).getAttribute("href"));},30000);
						
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
		public boolean validateShopByBrandViewAllLink(String lnkViewAll) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(btnViewAll);
			String strLink=this.btnViewAll.getAttribute("href").trim();
			
			return strLink.equalsIgnoreCase(getBaseURL()+lnkViewAll);
		}
		
		/**
		 * This method will get URL after clicking ViewAll link of ShopByBrand.
		 *
		 * @return String: changed Url
		 * @author Wei.Li
		 */	
		public String validateShopByBrandUrlAfterClickingViewAllLink() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(btnViewAll);
	        return waitForPageLoadingByUrlChange(this.btnViewAll);
	    }
	
		/**
		 * This method will get TopSeller header text
		 *
		 * @return String: TopSeller header text
		 * @author Wei.Li
		 */	    
		public String getTopSellerHeaderText() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblTopSeller);
			
			return lblTopSeller.getText().trim();
		}
		
		/**
		 * This method will validate TopSeller is above Footer
		 *
		 * @return true/false
		 * @author Wei.Li
		 */		
		public boolean validateTopSellerIsAboveFooter() {
			//String old_xpath="//div[@class='Footer']/preceding-sibling::div[@class='Middle']//product-recommendations-endeca//*[contains(@class,'prec-header')]";
			return this.getReusableActionsInstance().isElementVisible(By.xpath("//div[@class='Footer']/preceding-sibling::div[@class='Middle']//div[@class='recommend']"),30);
		}
		
		/**
		 * This method will validate TopSeller hrefs are not empty
		 * @return true/false
		 * @author Wei.Li
		 */			
		public boolean validateTopSellerHref() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblTopSeller);

			String lsHref;
			for(WebElement item: this.lnkTopSellerAllLinks) {
				lsHref=item.getAttribute("href");
				if(lsHref.isEmpty()) {
					return false;
				}
			}
			return true;
		}

	/**
	 * This method will validate TopSeller redirect url
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean validateTopSellerRedirectHref() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(lblTopSeller);

		String lsBaseUrl,lsHref;
		WebElement item=this.lnkTopSellerAllLinks.get(0);
		String lsCurrentUrl=this.URL();

		getReusableActionsInstance().clickIfAvailable(item);
		this.waitForPageLoad();
		this.waitForCondition(Driver->{return !lsCurrentUrl.equalsIgnoreCase(this.URL());},10000);


		lsBaseUrl=this.getBaseURL();

		return this.URL().toLowerCase().contains(lsBaseUrl);
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
				if(item.getAttribute("innerText").isEmpty()) {
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
				if(item.getAttribute("innerText").isEmpty()) {
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
				if(item.getText().isEmpty()) {
					return false;
				}
			}
			return true;
		}

	/*Shop By Department section
	* @author Shruti Desai
	*/
		
	/*Method to Validate Shop By Department section is in the middle of the webpage
	 * @return true/false
	 * @author Shruti Desai
	 */
	public String validateShopByDepartmentIsInMiddle() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(lblShopByDepartment);
			return locationShopByDepartment.getAttribute("class");
			}
		
	/*Method to get image count for Shop By Department section 
	 * @return number of images available in SBD section
	 * @author Shruti Desai
	 */
	public int getSBDimgCount() {
		return imgShopByDepartmentAllImages.size();
		}
		
	/*Method to get active image count for Shop By Department section 
	 * @return number of active images available in SBD section
	 * @author Shruti Desai
	 */
	public int getSBDactiveimgCount() {
		return imgShopByDepartmentAllActiveImages.size();
		}
		
	/*Method to verify image count for Shop By Department section 
	 * @return true/false
	 * @author Shruti Desai
	 */
	public boolean verifySBDactiveimgCount() {
		if (imgShopByDepartmentAllActiveImages.size() >=1) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(imgShopByDepartmentAllActiveImages.get(1));
			return true;
			}
			return false;
		}
		 
	/*Method to verify Active image count for Shop By Department section
	 * @return true/false
	 * @author Shruti Desai
	 */
	public boolean verifySBDimgCount() {
		if (imgShopByDepartmentAllImages.size() >=1) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(imgShopByDepartmentAllImages.get(1));
			return true;
			}
			return false;
		}
		
	/*Method to Validate Shop By Department section links href 
	 * @return String : href of all links in the section
	 * @author Shruti Desai
	 */
	public String validateSBDsectionLinks(int lnkNumber) {
		String emptyimglink="Image link href is empty";
		WebElement WebElement=imgShopByDepartmentAllImages.get(lnkNumber).findElement(By.xpath(".//a"));
		getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement);
			if (!WebElement.getAttribute("href").isEmpty()) {
				return WebElement.getAttribute("href");
			}else {
				return emptyimglink;
	 		}
		}
	 /*Method to Validate Shop By Department section images src is not empty
	  * @return true/false
	  * @author Shruti Desai
	  */	
		public boolean validateSBDsectionImages(int imgNumber) {
			WebElement WebElement=imgShopByDepartmentAllImages.get(imgNumber).findElement(By.xpath(".//img"));
			getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement);
				if (!WebElement.getAttribute("src").isEmpty()) {
					return true;
					}
					return false;
				}
		
	 /*Method to Validate clicking Shop By Department section Prev button
	  * @return true/false
	  * @author Shruti Desai
	  */
		public boolean validateShopByDepartmentClickPrevButton() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblShopByDepartment);
		
			List<String> lnkListBefore= new ArrayList<String>();
				for(WebElement item:this.lnkShopByDepartmentAllActiveLinks) {
					lnkListBefore.add(item.getAttribute("href"));
					}
				if(!getReusableActionsInstance().isElementVisible(btnShopByDepartmentPrev)) {
					return true;
					}
			getReusableActionsInstance().clickWhenVisible(btnShopByDepartmentPrev);
			String lsCurrentHref=lnkListBefore.get(0);
			waitForCondition(Driver->{return !lsCurrentHref.equalsIgnoreCase(this.lnkShopByDepartmentAllActiveLinks.get(0).getAttribute("href"));},10000);
			List<String> lnkListAfter= new ArrayList<String>();
				for(WebElement item:this.lnkShopByDepartmentAllActiveLinks) {
					lnkListAfter.add(item.getAttribute("href"));
				}
				
			Set<String> currentSet = new HashSet<String>(lnkListBefore);
			Set<String> afterSet = new HashSet<String>(lnkListAfter);
			currentSet.removeAll(afterSet);
				if(currentSet.isEmpty()) {
					return false;
				}else {
					return true;
				}						
			}
			
	/*Method to Validate clicking Shop By Department section Next button
	 * @return true/false
	 * @author Shruti Desai
	 */
		public boolean validateShopByDepartmentClickNextButton() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblShopByDepartment);
				
			List<String> lnkListBefore= new ArrayList<String>();
			for(WebElement item:this.lnkShopByDepartmentAllActiveLinks) {
				lnkListBefore.add(item.getAttribute("href"));
				}
			if(!getReusableActionsInstance().isElementVisible(btnShopByDepartmentNext)) {
				return true;
				}
			getReusableActionsInstance().clickWhenVisible(btnShopByDepartmentNext);
			String lsCurrentHref=lnkListBefore.get(0);
			waitForCondition(Driver->{return !lsCurrentHref.equalsIgnoreCase(this.lnkShopByDepartmentAllActiveLinks.get(0).getAttribute("href"));},10000);
			List<String> lnkListAfter= new ArrayList<String>();
				for(WebElement item:this.lnkShopByDepartmentAllActiveLinks) {
					lnkListAfter.add(item.getAttribute("href"));
				}
					
			Set<String> currentSet = new HashSet<String>(lnkListBefore);
			Set<String> afterSet = new HashSet<String>(lnkListAfter);
			currentSet.removeAll(afterSet);
				if(currentSet.isEmpty()) {
					return false;
				}else {
					return true;
				}						
			}
		
	/*Method to Validate Shop By Department section Automatic scrolling
	 * @return true/false
	 * @author Shruti Desai
	 */
		public boolean validateShopByDepartmentAutomaticScrollingAction() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(lblShopByDepartment);
			//Clicking on title below to enable automatic scrolling in application while running automated test
			this.lblShopByDepartment.click();
			List<String> lnkListBefore= new ArrayList<String>();
			for(WebElement item:this.lnkShopByDepartmentAllActiveLinks) {
				lnkListBefore.add(item.getAttribute("href"));
			}
			String lsCurrentHref=lnkListBefore.get(0);
			waitForCondition(Driver->{return !lsCurrentHref.equalsIgnoreCase(this.lnkShopByDepartmentAllActiveLinks.get(0).getAttribute("href"));},50000);
			List<String> lnkListAfter= new ArrayList<String>();
			for(WebElement item:this.lnkShopByDepartmentAllActiveLinks) {
				lnkListAfter.add(item.getAttribute("href"));
			}
					
			Set<String> currentSet = new HashSet<String>(lnkListBefore);
			Set<String> afterSet = new HashSet<String>(lnkListAfter);
			currentSet.removeAll(afterSet);
			if(currentSet.isEmpty()) {
				return false;
			}else{
				return true;
			}						
		}	
			
	/*
	 * Method to validate TS image upper section
	 * @return true/false
	 * @author Shruti Desai
	 */	
		public boolean validateTSimageUpperSection() {
			getReusableActionsInstance().javascriptScrollByVisibleElement(TSimageUpperSection);
			 return true;
		}
			
	/*
	 * Method to Get total number of images for TS upper section  
	 * @return int: number of total images
	 * @author Shruti Desai
	 */	
		public int getTSimgCount(WebElement totalImage) {
			return totalImage.findElements(By.xpath("./span")).size();
		}
		
	/*
	 * Method to Get list of href for TS images (upper section)  
	 * @return list: href of all TS images (upper section)
	 * @author Shruti Desai
	 */	
		public List<String> gethrefListTSimage(List<WebElement> hrefallTSimage){
			List<String> hrefListTsimage= new ArrayList<String>();
			for(WebElement item:hrefallTSimage) {
				hrefListTsimage.add(item.getAttribute("href"));
			}
			return hrefListTsimage;
		}
		
	
	/*
	 * Method to click on each image for all sections of TS image  
	 * @author Shruti Desai
	 */
	/**
	public void clickallTSimageLinks(WebElement totalImage,WebElement attriTSimage,WebElement linksTSimage,List<WebElement> hrefallTSimage) {
		int totalTsImage = getTSimgCount(totalImage);
		String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		AtomicReference<String> finalTempLsImageSrc = new AtomicReference<>();
		if(gethrefListTSimage(hrefallTSimage).size()!=0) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(attriTSimage.findElement(By.xpath(".//img")));
			for (int i=1;i<=totalTsImage; i++) {
				String lsImageSrc=attriTSimage.findElement(By.xpath(".//img")).getAttribute("src");
				if(this.waitForCondition(Driver->{return (!lsImageSrc.equalsIgnoreCase(finalTempLsImageSrc.get()) && !attriTSimage.findElement(By.xpath(".//img")).getAttribute("src").equalsIgnoreCase(lsImageSrc));},10000))
				//if(this.waitForCondition(Driver->{return (!lsImageSrc.equalsIgnoreCase(finalTempLsImageSrc.get()));},12000))
					linksTSimage.sendKeys(clickOnLinkTab);
				finalTempLsImageSrc.set(lsImageSrc);
			}
		}
	}
	*/
	public void clickallTSimageLinks(WebElement totalImage,WebElement attriTSimage,WebElement linksTSimage,List<WebElement> hrefallTSimage) {
		int totalNavigateLinks = this.totalImageNavigateLink.size();
		String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		AtomicReference<String> finalTempLsImageSrc = new AtomicReference<>();
		if(gethrefListTSimage(hrefallTSimage).size()!=0) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(attriTSimage.findElement(By.xpath(".//img")));
			for (int i=0;i<totalNavigateLinks; i++) {
				this.totalImageNavigateLink.get(i).click();
				String lsImageSrc=attriTSimage.findElement(By.xpath(".//img")).getAttribute("src");
				//if(this.waitForCondition(Driver->{return (!lsImageSrc.equalsIgnoreCase(finalTempLsImageSrc.get()) );},10000))
				if(!lsImageSrc.equalsIgnoreCase(finalTempLsImageSrc.get()))
					linksTSimage.sendKeys(clickOnLinkTab);
				finalTempLsImageSrc.set(lsImageSrc);
			}
		}
	}

	/*
	 * Method to verify each image for all sections of TS image for Safari
	 */
	public Set<String> getTSImageLinkForSafariPostClick(String testDevice) {
		int tempCounter = 1;
		Set<String> tsImageLinkSet = new HashSet<>();
		String clickOnLinkTab;
		int totalTsImage = getTSimgCount(totalTSimageUpperSection);
		if(testDevice.equalsIgnoreCase("Desktop"))
			clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
		else
			clickOnLinkTab = Keys.chord(Keys.COMMAND, "T");
		AtomicReference<String> finalTempLsImageSrc = new AtomicReference<>();
		if(gethrefListTSimage(hrefallTSimageUpperSection).size()!=0) {
			for (int i=1;i<=totalTsImage; i++) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(attriTSimageUpperSection.findElement(By.xpath(".//img")));
				String lsImageSrc=attriTSimageUpperSection.findElement(By.xpath(".//img")).getAttribute("src");
				if(this.waitForCondition(Driver->{return (!lsImageSrc.equalsIgnoreCase(finalTempLsImageSrc.get()) && !attriTSimageUpperSection.findElement(By.xpath(".//img")).getAttribute("src").equalsIgnoreCase(lsImageSrc));},7000)){
					linksTSimageUpperSection.sendKeys(clickOnLinkTab);
					this.waitForPageLoad();
					tsImageLinkSet.add(this.URL());
					if(tempCounter<totalTsImage && !testDevice.equalsIgnoreCase("Desktop")){
						this.waitForCondition(Driver->{return this.btnHomePageBreadcrumb.isEnabled() &&
								this.btnHomePageBreadcrumb.isDisplayed();},6000);
						this.getReusableActionsInstance().clickIfAvailable(this.btnHomePageBreadcrumb);
						this.waitForPageLoad();
						tempCounter++;
					}
				}
				//System.out.println("lsImage: "+lsImageSrc+" and finalTempLsImageSrc: "+finalTempLsImageSrc.get());
				finalTempLsImageSrc.set(lsImageSrc);
			}
		}
		return tsImageLinkSet;
	}
				
	/*
	 * Method to Get list of url for clicked TS images (upper section) open in different tabs  
	 * @return list: url of all open images
	 * @author Shruti Desai
	 */
		public List<String> getTabUrlListTSimage(){
			String getMultiTabUrl = null;
			int numberOfWindow = getNumberOftabs();
			ArrayList<String> returnList= new ArrayList<String>();
			ArrayList<String> tabList = new ArrayList<String>(getDriver().getWindowHandles());
			
			for (int i=1; i<numberOfWindow; i++) {
				getDriver().switchTo().window(tabList.get(i));
				getMultiTabUrl = getDriver().getCurrentUrl();
				getDriver().switchTo().window(tabList.get(i)).close();
				getDriver().switchTo().window(tabList.get(0));
				returnList.add(getMultiTabUrl);
			}
			return returnList;
		}
		
	/*
	 * Method to Get total number of open tabs after clicking each images of TS image  
	 * @return int: number of total open tabs after clicking all images TS image 
	 * @author Shruti Desai
	 */
		public int getNumberOftabs() {
			return getReusableActionsInstance().getNumberOfOpenWindows();
		}
		
	/*
	 * Method to click TS image for all section
	 * @author Shruti Desai
	 */	
		public void clickTSimage(String Section) throws InterruptedException {
			switch (Section){
			case "Upper" :
				clickallTSimageLinks(totalTSimageUpperSection,attriTSimageUpperSection,linksTSimageUpperSection,hrefallTSimageUpperSection);
				break;
			
			case "Lower" :
				clickallTSimageLinks(totalTSimageLowerSection,attriTSimageLowerSection,linksTSimageLowerSection,hrefallTSimageLowerSection);
				break;
			}	
		}
		
		
		
	/*
	 * Method to Get href of images in TS image all sections 
	 * @return list: href of all TS images 
	 * @author Shruti Desai
	 */	
		public List<String> gethrefListTSimage(String Section){   
			List<String> hreflist = null;
			switch (Section){
			
			case "Upper" :
				hreflist= gethrefListTSimage(hrefallTSimageUpperSection);
				return hreflist;
			case "Lower" :
				hreflist= gethrefListTSimage(hrefallTSimageLowerSection);
				return hreflist;
				
			}
			return hreflist;
		}
	
	/*
	 * Method to Get number of images in TS image all sections 
	 * @return int: number of all images in TS image all sections
	 * @author Shruti Desai
	 */
		public int totalTSimage(String Section) {
			this.waitForPageLoad();
			int TSimageCount = 0;
			switch (Section){
				case "Upper" :
					return	TSimageCount=	getTSimgCount(totalTSimageUpperSection);
										
				case "Lower" :
					return	TSimageCount=	getTSimgCount(totalTSimageLowerSection);
			}
			
			return	TSimageCount;
		}
}