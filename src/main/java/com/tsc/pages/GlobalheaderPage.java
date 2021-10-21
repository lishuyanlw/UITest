package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.DigiAutoCustomException;
import utils.ReusableActions;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tsc.pages.base.BasePage;

public class GlobalheaderPage extends BasePage{
	
	
	
	public GlobalheaderPage(WebDriver driver) {
		super(driver);
	}

	//Product results
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'blockPageWrap')]")
	public WebElement productResultLoadingIndicator;
	
	//Black header
	@FindBy(xpath = "//div[contains(@class,'black-header')]//a[contains(@class,'black-header__showstopper')]")
	public WebElement lnkTSBlackHeader;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//*[contains(@class,'black-header__promotion-text')]")
	public WebElement lblPromotionTextBlackHeader;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//button[contains(@class,'black-header__watch-tsc')]")
	public WebElement btnWatchTSCBlackHeader;
	
	//Watch TSC dropdown menu
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'WatchUsLive')]")
	public WebElement lnkWatchUsLiveDpdMenu;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'Deals')]")
	public WebElement lnkDealsDpdMenu;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'ProgramGuide')]")
	public WebElement lnkProgramGuideDpdMenu;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'Gadgets')]")
	public WebElement lnkCarGadgetsDpdMenu;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'Footwear')]")
	public WebElement lnkDesignerFootwearDpdMenu;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'OnAir')]")
	public WebElement lnkOnAirProductsDpdMenu;
	
	//Sliver Links [Dynamic event, TS, Deals, OnAir, Program Guide, Watch Us Live]
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'todaysshowstopper')]")
	public WebElement lnkTS;
	
	@FindBy(xpath="//*[@class='Sliver']//a[contains(@href, 'todaysshowstopper')]//span")
	public WebElement lnkTScnt;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'Deals')]")
	public WebElement lnkDeals;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'OnAir')]")
	public WebElement lnkOnAir;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'ProgramGuide')]")
	public WebElement lnkProgramGuide;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'ProgramGuide')]//div[contains(@class,'slvr-mnu-icon-container')]")
	public WebElement imgProgramGuideIcon;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'WatchUsLive')]")
	public WebElement lnkWatchUsLive;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'WatchUsLive')]//div[contains(@class,'slvr-mnu-icon-container')]")
	public WebElement imgWatchUsLiveIcon;
	
	//Dynamic Event
	@FindBy(xpath = "//*[@class='Sliver']//a[@class='slideLink']")
	public WebElement lnkdynamicEvent;
	
	By byDynamicEvent=By.xpath("//*[@class='Sliver']//a[@class='slideLink']");
		
	//TSC Logo
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__logo')]")
	public WebElement lnkTSClogo;
	
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__logo')]//a")
	public WebElement lnkTSClogolink;
	
	//SearchBox
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//input[@class='tsc-search-input']|//div[contains(@class,'searchContainer')]//input")
	public WebElement searchBox;
	
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//button[@class='submit-search-button']|//div[contains(@class,'searchContainer')]//button[@type='submit']")
	public WebElement btnSearchSubmit;
	
	@FindBy(xpath = "//div[@class='searchContainer']//button[contains(@class,'clear-search-button')]|//div[contains(@class,'searchContainer')]//button[@type='reset']")
	public WebElement btnSearchClear;
		
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container')]|//div[contains(@class,'aa-Panel--desktop')]")
	public WebElement ctnSearchResult;
	
	//For QA website
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container')]|//div[contains(@class,'aa-Panel--desktop')]//ul")
	public List<WebElement> searchQADropdwonmenuList;
	
	//For Staging website
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container--open')]//div[@class='tsc-category-title']")
	public WebElement txtSearchResultCategoryHeader;
	
	//For Staging website
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container--open')]//ul//li")
	public List<WebElement> searchResultList;
	
	By byCategoryAboveSearchResultList=By.xpath("//div[@class='searchContainer']//div[contains(@class,'suggestions-container--open')]//ul/preceding-sibling::div[@class='tsc-category-title']");
		
	//Favorite link
	@FindBy(xpath = "//*[@class='Header']//a[contains(@href, 'favourites')]")
	public WebElement Favouriteslnk;
	
	@FindBy(xpath = "//*[@class='Header']//a[contains(@href, 'favourites')]//*[@class='secondary-navigation__rhs-container__logo']")
	public WebElement FavouritesIcon;
	
	//SignIn
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//a")
	public WebElement Signinlnk;
	
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//a//*[@class='secondary-navigation__rhs-account-icon']")
	public WebElement SigninIcon;
	
	//Shopping Cart 
	@FindBy(xpath = "//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]")
	public WebElement ShoppingCartlnk;
 
	@FindBy(xpath ="//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]/span")
	public WebElement ShoppingCartIconcont;			

	@FindBy(xpath = "//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]//*[@class='secondary-navigation__rhs-bag__item-icon']")
	public WebElement CartBagIcon;
	
	@FindBy(xpath = "//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]//div[contains(@class,'secondary-navigation__rhs-bag__item')]//span[contains(@class,'secondary-navigation__rhs-bag__item-badge')]//span[not(contains(@class,'visually-hidden'))]")
	public WebElement CartBagCounter;


	/*
	 * @author Shruti.Desai
	 *Flyouts Headings
	 */
	@FindBy(xpath = "//div[contains(@class,'header-desktop')]//div[contains(@class,'megamenu')]//ul[@class='navLinkWrap']/li")
	List<WebElement> listFlyoutHeadings;
	
	@FindBy(xpath ="//*[@class='flyout']//div[@class='flyoutRow2Right']//descendant::b//ancestor::div[@class='flyoutRow2Right']")
	WebElement brandSubMenu;
	
	
	@FindBy(xpath = "//*[@class='email-popup__button']")
	WebElement btnClose;

	/*
	 * @author godwin.gopi
	 * Header Options
	 */
	@FindBy(xpath="//span[contains(text(),'Clearance')]")
	WebElement clearanceHeader;

	//Godwin
	@FindBy(xpath="//a[@class='mega-sub-items__item-link mega-sub-items__item-link-first' and contains(text(),'Shop all')]")
	WebElement shopAllFasionOption;

	@FindBy(xpath="//a[@role=\"button\" and contains(text(),'Fashion')]")
	WebElement fasionOption;

	public void clickOnClearanceHeaderOption() {
		getReusableActionsInstance().clickIfAvailable(clearanceHeader);
	}

	/**
	 * This method will verify clearance.
	 * @return  WebElement
	 * @author godwin.gopi
	 */
	public void clickSubMenuLink() {
		getReusableActionsInstance().clickIfAvailable(fasionOption);
		getReusableActionsInstance().clickIfAvailable(shopAllFasionOption);
		waitForCondition(Driver->{return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},60000);
	}

	public void waitForPageLoad() {
		getReusableActionsInstance().waitForPageLoad();
		waitForCondition(Driver->{return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},30000);
	}	
	
	public boolean validateURL(String strExpectedUrl) {
		getReusableActionsInstance().waitForPageLoad();
		if (getDriver().getCurrentUrl().equalsIgnoreCase(strExpectedUrl)) {
			return true;
		}
		return false;
	}
	
	//Sliver links are visible & Text is present
	/**
	 * This method will validate DynamicEvent  is visible.
	 *
	 * @return true/false
	 * 
	 * @author Wei.Li
	 */	
	public boolean DynamicEventLinkVisible() {
		if(!this.getReusableActionsInstance().isElementVisible(this.byDynamicEvent,30)) {
			return true;
		}
		return this.lnkdynamicEvent.isDisplayed();
	}
	
	/**
	 * This method will validate the href of DynamicEventLink is existing.
	 *
	 * @return true/false
	 * 
	 * @author Wei.Li
	 */	
	public boolean validateDynamicEventLink() {
		if(!this.getReusableActionsInstance().isElementVisible(this.byDynamicEvent,30)) {
			return true;
		}
		if (lnkdynamicEvent.getAttribute("href").isEmpty()) {							
			return false;			
		}
		
		return true;
	}
	
	/**
	 * This method will return TS text.
	 * @author Wei.Li
	 */
	public String getTSText() {
		getReusableActionsInstance().isElementVisible(lnkTS, 5);
		return lnkTS.getText();		
	}
	
	/**
	 * This method will return TS link.
	 * @author Wei.Li
	 */
	public String getTSLink() {
		String emptySTAIbtn="TS link href is empty";
		if (lnkTS.getAttribute("href").isEmpty()) {							
			return emptySTAIbtn;			
		}else{			
			return lnkTS.getAttribute("href");
		}
	}
	
	/**
	 * This method will return Deals text.
	 * @author Wei.Li
	 */
	public String getDealsText() {
		getReusableActionsInstance().isElementVisible(lnkDeals, 5);
		return lnkDeals.getText();
	}
	
	/**
	 * This method will return Deals link.
	 * @author Wei.Li
	 */
	public String getDealsLink() {
		String emptySTAIbtn="Deals link href is empty";
		if (lnkDeals.getAttribute("href").isEmpty()) {							
			return emptySTAIbtn;			
		}else{			
			return lnkDeals.getAttribute("href");
		}
	}
	
	/**
	 * This method will return OnAir text.
	 * @author Wei.Li
	 */
	public String getOnAirText() {
		getReusableActionsInstance().isElementVisible(lnkOnAir, 5);
		return lnkOnAir.getText();
	}
	
	/**
	 * This method will return OnAir link.
	 * @author Wei.Li
	 */
	public String getOnAirLink() {
		String emptySTAIbtn="On Air link href is empty";
		if (lnkOnAir.getAttribute("href").isEmpty()) {							
			return emptySTAIbtn;			
		}else{
			return lnkOnAir.getAttribute("href");
		}
	}
	
	/**
	 * This method will validate ProgramGuide icon is visible.
	 *
	 * @return true/false
	 * @author Wei.Li
	 */	
	public boolean validateProgramGuideIconVisible() {
		return getReusableActionsInstance().isElementVisible(imgProgramGuideIcon, 5);
	}
	
	/**
	 * This method will return ProgramGuide text.
	 * @author Wei.Li
	 */
	public String getProgramGuideText() {
		getReusableActionsInstance().isElementVisible(lnkProgramGuide, 5);
		return lnkProgramGuide.getText();
	}
	
	/**
	 * This method will return ProgramGuide link.
	 * @author Wei.Li
	 */
	public String getProgramGuideLink() {
		String emptySTAIbtn="Program Guide link href is empty";
		if (lnkProgramGuide.getAttribute("href").isEmpty()) {							
			return emptySTAIbtn;			
		}else{
			return lnkProgramGuide.getAttribute("href");
		}
	}
	
	/**
	 * This method will return WatchUsLive text.
	 * @author Wei.Li
	 */
	public String getWatchUsLiveText() {
		getReusableActionsInstance().isElementVisible(lnkWatchUsLive, 5);
		return lnkWatchUsLive.getText();
	}
	
	/**
	 * This method will return WatchUsLive link.
	 * @author Wei.Li
	 */
	public String getWatchUsLiveLink() {
		String emptySTAIbtn="Watch Us Live link href is empty";
		if (lnkWatchUsLive.getAttribute("href").isEmpty()) {							
			return emptySTAIbtn;			
		}else{
			return lnkWatchUsLive.getAttribute("href");
		}
	}
		
	/**
	 * This method will validate WatchUsLive icon is visible.
	 *
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean validateWatchUsLiveIconVisible() {
		return getReusableActionsInstance().isElementVisible(imgWatchUsLiveIcon, 5);
		}
	
	/**
	 * This method will validate clicking TSCLogo can navigate page to HomePage.
	 *
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean validateTSCLogoNavigateToHomePage() {
		String lsHomePage=new BasePage(this.getDriver()).getBaseURL()+"/";				
		String currentUrl=getDriver().getCurrentUrl();		        
                
		getReusableActionsInstance().isElementVisible(this.lnkTSClogo, 10);
		this.lnkTSClogo.click();	    
        waitForCondition(Driver->{return !currentUrl.equalsIgnoreCase(getDriver().getCurrentUrl());},10000);
              
        return this.getDriver().getCurrentUrl().equalsIgnoreCase(lsHomePage);		
		}
				
	//TSC Logo & Logo link is visible	
	public String validateTSCLogoLink() {
		String emptySTAIbtn="TSC logo link href is empty";
		String lsUrl=lnkTSClogolink.getAttribute("href");
		if (lsUrl.isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			return lsUrl;
		}
	}
	
	public boolean validateTSCLogo() {
		return getReusableActionsInstance().isElementVisible(lnkTSClogo, 5);				
	}
	
	//Search box visible
	public String validateSearchbox() {
			getReusableActionsInstance().isElementVisible(searchBox, 5);
				return searchBox.getAttribute("placeholder");
			}
		
	public boolean validateSearchSubmitbtn() {
		return getReusableActionsInstance().isElementVisible(btnSearchSubmit, 5);
				
			}
		
	//Favorite link visible
	public String validateFavouritesLink() {
		String emptySTAIbtn="Favourites link href is empty";
		if (Favouriteslnk.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(Favouriteslnk, 5);
			return Favouriteslnk.getText();
			}
		}

	//Sign In Link is visible
	public String validateSignInLink() {
		String emptySTAIbtn="Sign In link href is empty";
		if (Signinlnk.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(Signinlnk, 5);
			return Signinlnk.getText();
			}
		}
	
	public boolean validateSiginIcon() {
		return getReusableActionsInstance().isElementVisible(SigninIcon, 5);
	}
		
	//Shopping cart Link visible
	public String validateShoppingCartLinkName() {
		String emptySTAIbtn="Shopping cart link href is empty";
		if (ShoppingCartlnk.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(ShoppingCartlnk, 5);
			return ShoppingCartIconcont.getText();
			}
		}
	
	public boolean validateShoppingCartIcon() {
			return getReusableActionsInstance().isElementVisible(CartBagIcon, 5);
			 }
	
	public boolean validateShoppingCartBagCounter() {
		return getReusableActionsInstance().isElementVisible(CartBagCounter, 5);
		}

		
	/**
	 * This method will verify Shopping Cart link
	 *
	 * @return true/false
	 * 
	 * @author Wei.Li
	 */
	public boolean verifyShoppingCartLink(String lsExpectedShoppingCartLink) {
		String lsShoppingCartLink=this.ShoppingCartlnk.getAttribute("href");
		if(lsShoppingCartLink.isEmpty()) {
			return false;
		}
		else {			
			if(lsShoppingCartLink.equalsIgnoreCase(lsExpectedShoppingCartLink)) {
				return true;
			}
			else {
				return false;
			}
		}	
	}
	
	/**
	 * This method will get url of new windows after clicking Shopping Cart link
	 *
	 * @return String: changed Url
	 * 
	 * @author Wei.Li
	 */		
	public String getUrlAfterClickingShoppingCartLink() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.ShoppingCartlnk);		
	}
	
	/**
	 * This method will get full url after clicking TodayShowstopper link.
	 * @return String: changed Url 
	 * @author Wei.Li
	 */
	public String getUrlAfterClickingTSLink() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.lnkTS);
	}
	
	/**
	 * This method will get full url after clicking Deals link.
	 * @return String: changed Url
	 * @author Wei.Li
	 */
	public String getUrlAfterClickingDealsLink() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.lnkDeals);
	}
	
	/**
	 * This method will get full url after clicking OnAir link.
	 * @return String: changed Url
	 * @author Wei.Li
	 */
	public String getUrlAfterClickingOnAirLink() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.lnkOnAir);
	}
	
	/**
	 * This method will get full url after clicking ProgramGuide link.
	 * @return String: changed Url
	 * @author Wei.Li
	 */
	public String getUrlAfterClickingProgramGuideLink() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.lnkProgramGuide);
	}

	/**
	 * This method will get full url after clicking WatchUsLive link.
	 * @return String: changed Url
	 * @author Wei.Li
	 */
	public String getUrlAfterClickingWatchUsLiveLink() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.lnkWatchUsLive);
	}
	
	/*
	 * @author Shruti.Desai
	 *Flyouts Sub Menu
	 */

	/*Method to get Flyouts Headings count 
	 * @return number of Flyouts Headings
	 * @author Shruti Desai
	 */
	public int getFlyoutHeadingCount() {
		return listFlyoutHeadings.size();
	}
	
	/*Method to verify lable & get it for Flyout headings
	 * @return text:Flyout Headings
	 * @author Shruti Desai
	 */
	public String getFlyoutHeadings(int headingNumber) { 
		WebElement WebElement=listFlyoutHeadings.get(headingNumber).findElement(By.xpath(".//span"));
	 	getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement); 
	 		return WebElement.getText(); 
	}
	
	
	/*Method to validate href is not empty before clicking it
	 * @return true/false
	 * @author Shruti Desai
	 */
	 public boolean validateFlyouthref(int headingNumber) {
		WebElement WebElement=listFlyoutHeadings.get(headingNumber).findElement(By.xpath(".//a"));
		getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement);
			if (!WebElement.getAttribute("href").isEmpty()) {
				return true;
			}
				return false;
		}
	 
	 /*Method to validate href is not empty before clicking it
	 *@return  list:Flyout heading href
	 * @author Shruti Desai
	 */
	 public String getFlyoutLink(int headingNumber) {
		 String emptyhref="Flyout heading's href is empty";
		 WebElement WebElement=listFlyoutHeadings.get(headingNumber).findElement(By.xpath(".//a"));
			getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement);
				
		 if (WebElement.getAttribute("href").isEmpty()) {
			return emptyhref;
		 }else{
			return WebElement.getAttribute("href");
		 }
	 }
	 
	 /*Method to get URL after clicking on category of Flyout heading
	  *@return text: URL
	  * @author Shruti Desai
	  */
	 public String getURLafterClickFlyoutHeading(int headingNumber) {
		WebElement WebElement=listFlyoutHeadings.get(headingNumber).findElement(By.xpath(".//a"));
		if(getReusableActionsInstance().isElementVisible(WebElement,2)){
			getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement);  
			getReusableActionsInstance().clickWhenVisible(WebElement,5);
			return (getDriver().getCurrentUrl());
		 }else {
			return null;	
		 }
	}
	
	
//Sub Menu Section
	
	/*Method to get list of Flyout Headings
	 * @return list:Flyout Heading
	 * @author Shruti Desai
	 */		
	public List<String> getFlyoutHeadings() { 
		List<String> FlyoutHeadings= new ArrayList<String>();
		String newHeading;
		for(WebElement item:listFlyoutHeadings) {
			newHeading=item.getText().trim();
			newHeading = createCamelCase(newHeading);
			FlyoutHeadings.add(newHeading);
		}
		return FlyoutHeadings;
	}		
		
	 /*Method to get list of Flyout submenu heding in camel case 
	  * @return list:Flyout sub menu camel case
	  * @author Shruti Desai
	  */
	 public List<String> getFlyoutSubMenu(String headingName) { 
			String xpathHeading =createXPath("//li[@class='navLinkItem']//span[contains(text(),'{0}')]" ,headingName); 
			WebElement headingWebElement = getDriver().findElement(By.xpath(xpathHeading));
			getReusableActionsInstance().scrollToElement(headingWebElement);
			getReusableActionsInstance().waitForElementVisibility(headingWebElement, 2);
			getReusableActionsInstance().staticWait(3000);
			List<WebElement> SubMenu=headingWebElement.findElements(By.xpath("./ancestor::li//div[@class='flyout']//div[@class='flyoutRow2Left']//ul//li[1]//b"));
			List<String> SubMenulist =new ArrayList<String>();
			String newSubmenu;
			for(WebElement e:SubMenu) {
				newSubmenu=e.getText().trim();
				newSubmenu = createCamelCase(newSubmenu);
				SubMenulist.add(newSubmenu);
			}
			return SubMenulist;
		}				 
			 
		
	/* Method to Validate FEATURED BRANDS section is displayed on right side by extracting its class
	  * @return text: class of Feature Brand section heading
	  * @author Shruti Desai
	  */
	 public String validateFeatureBrandSectionIsOnTheRight(String headingName) {
		return brandSubMenu.getAttribute("class");
	}
	 
	 /*Method to get list of Flyout submenu Headings in the Brand Section
	  * @return list:Flyout sub menu Headings in the Brand Section
	  * @author Shruti Desai
	  */
	 public String getFeatureBrandSectionHeading(String headingName) {
		 String xpathHeading =createXPath("//div[contains(@class,'header-desktop')]//div[contains(@class,'megamenu')]//ul[@class='navLinkWrap']/li/a[contains(.,'{0}')]" ,headingName); 
		 WebElement headingWebElement = getDriver().findElement(By.xpath(xpathHeading));
		 getReusableActionsInstance().scrollToElement(headingWebElement);
		 WebElement SubMenuHeadings=headingWebElement.findElement(By.xpath("./ancestor::li//div[@class='flyout']//div[@class='flyoutRow2Right']//li//b[not(a)]"));
		 return SubMenuHeadings.getText();
	 }	 
		
	 /* Method to validate all href & src for Flyout submenu links in both right hand side and Brand Section are not empty.
	  * @return : true/false
	  * @author Shruti Desai
	  */
	 public String validateFlyoutSubMenuSRCandHREF(String headingName,String section) {
			List<WebElement> SubMenuLinks =null;
			List<WebElement> SubMenuLinkImages =null;
			WebElement brandSectionViewAlllink =null;
			StringBuilder href_src  =new StringBuilder("All atributes are present ");
			
			if(section==null) {//Xpath for links in the Left hand side section
				String xpathHeading =createXPath("//*[@id='megamenu']//span[contains(text(),'{0}')]/parent::a/following-sibling::div//div[@class='flyoutRow2Container']/div[1]//li//a[(text())]" ,headingName); 
				SubMenuLinks =getDriver().findElements(By.xpath(xpathHeading));
			}else{//Xpath for links in the Brand Section
				String xpathlinks =createXPath("//*[@id='megamenu']//span[contains(text(),'{0}')]/parent::a/following-sibling::div//div[@class='flyoutRow2Container']/div[2]//div//a[contains(@href,'HDR')]" ,headingName); 
				String xpathimages =createXPath("//*[@id='megamenu']//span[contains(text(),'{0}')]/parent::a/following-sibling::div//div[@class='flyoutRow2Container']/div[2]//div//img" ,headingName); 
				String xpathViewAlllink =createXPath("//*[@id='megamenu']//span[contains(text(),'{0}')]/parent::a/following-sibling::div//div[@class='flyoutRow2Container']/div[2]//div//a[contains(text(),'View All >')]" ,headingName); 
				SubMenuLinks=getDriver().findElements(By.xpath(xpathlinks));
				SubMenuLinkImages=getDriver().findElements(By.xpath(xpathimages));
				brandSectionViewAlllink = getDriver().findElement(By.xpath(xpathViewAlllink));
			}
			if(section==null) {//Verification of left hand side section links under submenu headings
				for (WebElement SBlinks:SubMenuLinks) {
					if(!verifyElementProperty(SBlinks,"Link")) {//href not present
						href_src.append('\n').append(SBlinks.getText());
					}
				}
				//Return All attributes are present
				return href_src.toString();
			
			}else {//verification of links in the Brand Section.
				String viewAlllinkText =brandSectionViewAlllink.getText();
				for (int i=0; i<SubMenuLinkImages.size(); i++) {
					if(!verifyElementProperty(SubMenuLinks.get(i),"Link")) {//href not present
						//String: src of missing href 
						href_src.append('\n').append(SubMenuLinks.get(i).getAttribute("src"));
					}if(!verifyElementProperty(SubMenuLinkImages.get(i),"Image")) {//href present and Src not present
						href_src.append('\n').append(SubMenuLinks.get(i).getAttribute("href"));
					}
				}	//verification of View All link in Brand section	
				if(!verifyElementProperty(brandSectionViewAlllink,"Link")) {//href not present of View All link
					//String: text of missing href for View All link in brand section
					href_src.append('\n').append(viewAlllinkText);
				}
			}
			//Return All attributes are present
			return href_src.toString();
	}
	 
	/**
	 *Method to go to home page  
	 * @return true/false
	 * @author Wei.Li
	 */	
	 public boolean goBackHomePage() {
		 getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkTSClogo);
		 this.lnkTSClogo.click();
		 return (new GlobalFooterPage(this.getDriver())).waitForPageLoading();
	 }

	/**
	 *Method to hover on WatchTSC in Black headers  
	 * @author Wei.Li
	 */	
	 public void hoverOnWatchTSC() {
		 getReusableActionsInstance().scrollToElement(this.btnWatchTSCBlackHeader);
		 getReusableActionsInstance().staticWait(100);		 
	 }	
	 
	/**
	 *Method to go to Black headers  
	 * @param WebElement element: dropdown menu option	
	 * @return true/false
	 * @author Wei.Li
	 */	
	 public boolean switchWatchTSCDropdownOption(WebElement element) {
		 getReusableActionsInstance().scrollToElement(this.btnWatchTSCBlackHeader);
		 getReusableActionsInstance().staticWait(100);
		 getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		 element.click();
		 return (new GlobalFooterPage(this.getDriver())).waitForPageLoading();
	 }	 
		
	/**
	 *Method to verify TS header and link in Black headers  	 
	 * @param WebElement blackItem: the header in Black headers
	 * @param WebElement silverItem: the header in Silver headers 
	 * @param boolean bCheckUrl: to decide if check Url after clicking the header in Black headers 
	 * @author Wei.Li
	 */	
	 public void verifyTSHeaderAndLinkInBlackHeader(WebElement blackItem,WebElement silverItem,boolean bCheckUrl) {
		 getReusableActionsInstance().javascriptScrollByVisibleElement(blackItem);
		 String lsTitle=blackItem.getText().trim();
		 reporter.softAssert(getReusableActionsInstance().isElementVisible(blackItem), "The element of "+lsTitle+" in Black headers is visible","The element of "+lsTitle+" in Black headers is not visible");
		 reporter.softAssert(!lsTitle.isEmpty(), lsTitle+" text in Black headers is not empty", lsTitle+" text in Black headers is empty");
		 String lsHrefInBlackHeader=this.getElementHref(blackItem);	
		 reporter.softAssert(!lsHrefInBlackHeader.isEmpty(), "The href of "+lsTitle+" in Black headers is not empty", "The href of "+lsTitle+" in Black headers is empty");
		 lsHrefInBlackHeader=this.removeLastSlashFromUrl(lsHrefInBlackHeader);
		 
		 blackItem.click();
		 this.waitForPageToLoad();
		 (new GlobalFooterPage(this.getDriver())).waitForPageLoading();
		 
		 String lsUrlInSilverHeader=this.removeLastSlashFromUrl(this.URL());
		 if(bCheckUrl) {
			 reporter.softAssert(lsUrlInSilverHeader.equalsIgnoreCase(lsHrefInBlackHeader), "The Url of "+lsUrlInSilverHeader+"  after clicking "+lsTitle+" in Black headers is equal to the href of "+lsHrefInBlackHeader, "The Url of "+lsUrlInSilverHeader+"  after clicking "+lsTitle+" in Black headers is not equal to the href of "+lsHrefInBlackHeader);
		 }

//		 if(silverItem!=null) {
//			 String lsStyle=silverItem.findElement(By.xpath(".//span")).getAttribute("style");			
//			 reporter.softAssert(lsStyle.equalsIgnoreCase("color:#fff;")||lsStyle.equalsIgnoreCase("color: rgb(255, 255, 255);"), lsTitle+" in Silver headers is being selected", lsTitle+" in Silver headers is not being selected");		 		 
//		 }

	 }
	 
	 
}

