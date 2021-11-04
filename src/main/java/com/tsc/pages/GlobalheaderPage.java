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
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tsc.pages.base.BasePage;

public class GlobalheaderPage extends BasePage{
	
	
	
	public GlobalheaderPage(WebDriver driver) {
		super(driver);
	}

	//Product results
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'blockPageWrap')]")
	WebElement productResultLoadingIndicator;
	
	//Sliver Links [Dynamic event, TS, Deals, OnAir, Program Guide, Watch Us Live]
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'todaysshowstopper')]")
	WebElement lnkTS;
	
	@FindBy(xpath="//*[@class='Sliver']//a[contains(@href, 'todaysshowstopper')]//span")
	WebElement lnkTScnt;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'Deals')]")
	WebElement lnkDeals;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'OnAir')]")
	WebElement lnkOnAir;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'ProgramGuide')]")
	WebElement lnkProgramGuide;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'ProgramGuide')]//div[contains(@class,'slvr-mnu-icon-container')]")
	WebElement imgProgramGuideIcon;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'WatchUsLive')]")
	WebElement lnkWatchUsLive;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'WatchUsLive')]//div[contains(@class,'slvr-mnu-icon-container')]")
	WebElement imgWatchUsLiveIcon;
	
	//Dynamic Event
	@FindBy(xpath = "//*[@class='Sliver']//a[@class='slideLink']")
	WebElement lnkdynamicEvent;
	
	By byDynamicEvent=By.xpath("//*[@class='Sliver']//a[@class='slideLink']");
		
	//TSC Logo
	@FindBy(xpath = "//*[@class='Header']//div[@class='logo']")
	WebElement lnkTSClogo;
	
	@FindBy(xpath = "//*[@class='Header']//div[@class='logo']//a")
	WebElement lnkTSClogolink;
	
	//SearchBox
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//input[@class='tsc-search-input']|//div[contains(@class,'searchContainer')]//input")
	WebElement searchBox;
	
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//button[@class='submit-search-button']|//div[contains(@class,'searchContainer')]//button[@type='submit']")
	WebElement btnSearchSubmit;
	
	@FindBy(xpath = "//div[@class='searchContainer']//button[contains(@class,'clear-search-button')]|//div[contains(@class,'searchContainer')]//button[@type='reset']")
	WebElement btnSearchClear;
		
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container')]|//div[contains(@class,'aa-Panel--desktop')]")
	WebElement ctnSearchResult;
	
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container')]|//div[contains(@class,'aa-Panel--desktop')]//ul")
	List<WebElement> searchQADropdwonmenuList;
	
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container--open')]//div[@class='tsc-category-title']")
	WebElement txtSearchResultCategoryHeader;
	
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container--open')]//ul//li")
	List<WebElement> searchResultList;
	
	By byCategoryAboveSearchResultList=By.xpath("//div[@class='searchContainer']//div[contains(@class,'suggestions-container--open')]//ul/preceding-sibling::div[@class='tsc-category-title']");
		
	//Favorite link
	@FindBy(xpath = "//*[@class='Header']//a[contains(@href, 'favourites')]")
	WebElement Favouriteslnk;
	
	//SignIn
	@FindBy(xpath = "//*[@class='Header']//a[@id='myAccountBtn']")
	WebElement Signinlnk;
	
	@FindBy(xpath = "//*[@class='Header']//div[@class='bagContainer']//*[contains(@class,'svgSigninIcon')]")
	WebElement SigninIcon;
	
	//MiniCart 
	@FindBy(xpath = "//*[@class='Header']//a[@id='tagCartButton']")
	WebElement Minicartlnk;
 
	@FindBy(xpath ="//*[@class='Header']//a[@id='tagCartButton']//span")
	WebElement MinicartIconcont;			

	@FindBy(xpath = "//*[@class='Header']//*[@class='svgBagIcon']")
	WebElement CartBagIcon;
	
	@FindBy(xpath = "//*[@class='Header']//div[@id='bagCounter']")
	WebElement CartBagCounter;


	/*
	 * @author Shruti.Desai
	 *Flyouts Headings
	 */
	/*@FindBy(xpath = "//ul[contains(@class,'primary-navigation__wrapper')]//li")
	List<WebElement> listFlyoutHeadings;
	
	@FindBy(xpath = "//nav[contains(@class,'mega-categories mega-column')]//ul/li")
	List<WebElement> listCategories;
	
	@FindBy(xpath = "//nav[contains(@class,'mega-sub-items mega-column')]//ul/li")
	List<WebElement> listSubItems;
	
	@FindBy(xpath = "//nav[contains(@class,'mega-curated mega-column')]//ul/li")
	List<WebElement> listSubItemsCuratedCollection;
	
	@FindBy(xpath = "//nav[contains(@class,'mega-popular mega-column')]//ul/li")
	List<WebElement> listSubItemsPopularBrands;
	
	*/
	@FindBy(xpath = "//*[@class='email-popup__button']")
	WebElement btnClose;
	public void closeadd() {
		btnClose.click();
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
		
	//Mini cart Link visible
	public String validateMinicartLinkName() {
		String emptySTAIbtn="Mini cart link href is empty";
		if (Minicartlnk.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(Minicartlnk, 5);
			return MinicartIconcont.getText();
			}
		}
	
	public boolean validateMinicartIcon() {
			return getReusableActionsInstance().isElementVisible(CartBagIcon, 5);
			 }
	
	public boolean validateMinicartBagCounter() {
		return getReusableActionsInstance().isElementVisible(CartBagCounter, 5);
		}

		
	/**
	 * This method will verify MiniCart link
	 *
	 * @return true/false
	 * 
	 * @author Wei.Li
	 */
	public boolean verifyMiniCartLink(String lsMinicartLink) {
		String lsMiniCartLink=this.Minicartlnk.getAttribute("href");
		if(lsMiniCartLink.isEmpty()) {
			return false;
		}
		else {			
			if(lsMiniCartLink.equalsIgnoreCase(lsMinicartLink)) {
				return true;
			}
			else {
				return false;
			}
		}	
	}
	
	/**
	 * This method will get url of new windows after clicking MiniCart link
	 *
	 * @return String: changed Url
	 * 
	 * @author Wei.Li
	 */		
	public String getUrlAfterClickingMiniCartLink() throws IOException {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.Minicartlnk);		
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
	
	@FindBy(xpath = "//ul[contains(@class,'primary-navigation__wrapper')]//li//a")
	WebElement FlyoutHeadings;
	
	@FindBy(xpath = "//nav[contains(@class,'mega-categories mega-column')]//ul/li")
	WebElement Categories;
	
	@FindBy(xpath = "//nav[contains(@class,'mega-sub-items mega-column')]//ul/li//a")
	List<WebElement> listSubItems;
	
	@FindBy(xpath = "//nav[contains(@class,'mega-curated mega-column')]//h4")
	WebElement headingCuratedCollection;
	
	@FindBy(xpath = "//nav[contains(@class,'mega-popular mega-column')]//h4")
	WebElement headingPopularBrands;
	
	
	@FindBy(xpath = "//nav[contains(@class,'mega-curated mega-column')]//ul/li//a")
	List<WebElement> listSubItemsCuratedCollection;
	
	@FindBy(xpath = "//nav[contains(@class,'mega-popular mega-column')]//ul/li//a//img")
	List<WebElement> listSubItemsPopularBrands;
	
	/*Method to to click on WebElement for Submenu Item 
	 * @author Shruti Desai
	 */
	public void clickSubMenuItem(String headingName,String submenuHeading, String itemName) {
		String xpathHeading =createXPath("//span[contains(text(),'{0}')]" ,headingName); 
		WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
		getReusableActionsInstance().scrollToElement(headingWebElement);
		
		if(submenuHeading!=null) {
			String xpathSubMenu =createXPath("//a[contains(text(),\"{0}\")]" ,submenuHeading); 
			WebElement SubMenu = Categories.findElement(By.xpath(xpathSubMenu));
			getReusableActionsInstance().scrollToElement(SubMenu);
			if(itemName!=null) {
				String xpathSubmenuItem=createXPath("//a[contains(text(),'{0}')]",itemName);
				WebElement SubMenuItem=getDriver().findElement(By.xpath(xpathSubmenuItem));
				getReusableActionsInstance().scrollToElement(SubMenuItem);
				SubMenuItem.click();
			}else {
				SubMenu.click();
			}
		}	
		headingWebElement.click();
	}
	

	
	
	/*Method to get String of XPath  
	* @return String:Xpath
	* @author Shruti Desai
	*/						
	public String createXPath(String xpathExp, Object ...args){
		for(int i=0; i<args.length; i++) {
			xpathExp = xpathExp.replace("{"+i+"}", (CharSequence) args[i]);
		}
		return xpathExp;
	}
	
	public List<WebElement> getFlyoutHeadingsWebelement() {
		List<WebElement> headingElements =FlyoutHeadings.findElements(By.xpath("//a//span[contains(@class,'primary-navigation__link-text')]"));
		return headingElements;
	}
	
	public List<WebElement> getCategoryWebelement(WebElement webElement,String headingName) {
		String xpathHeading =createXPath("//span[contains(text(),'{0}')]" ,headingName); 
		WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
		List<WebElement> categoryElements =headingWebElement.findElements(By.xpath("./ancestor::div//nav[contains(@class,'mega-categories mega-column')]//ul/li//a"));
		
		//List<WebElement> categoryElements =Categories.findElements(By.xpath("//a"));
		return categoryElements;
	}
	
	public List<WebElement> getitemWebelement(WebElement webElement,String categoryName) {
		String xpathcategory =createXPath("//a[contains(text(),\"{0}\")]" ,categoryName); 
		WebElement categoryElement = Categories.findElement(By.xpath(xpathcategory));
		List<WebElement> itemElements =categoryElement.findElements(By.xpath("/ancestor::div[contains(@class,'mega-containers')]//nav[contains(@class,'mega-sub')]/ul//li//a"));
		
		//List<WebElement> categoryElements =Categories.findElements(By.xpath("//a"));
		return itemElements;
	}
	//WebElement parentElement=categoryWebElement.findElement(By.xpath("./ancestor::div[contains(@class,'mega-containers')]//nav[contains(@class,'mega-sub')]/ul"));
	
	public void scrolltoWebElement(WebElement webElement) {
		getReusableActionsInstance().scrollToElement(webElement);
		}
	
	
	
	
	public boolean verifyhrefFlyoutHeading(WebElement webElement) {
		WebElement headinghref= webElement.findElement(By.xpath("./ancestor::a"));
		if(!verifyElementProperty(headinghref,"Link")) {
			return false;
		}
		return true;
	}
	
	
	 /*Method to verify url after clicking flyout heading link
	  * @return String:href(only get unique part for each heading)
	  * @author Shruti Desai
	  */

	public String getUrlAfterclickingFlyoutHeading(WebElement webElement) {
		String currentUrl;
		getReusableActionsInstance().scrollToElement(webElement);
		webElement.click();
		currentUrl = getDriver().getCurrentUrl();
		return currentUrl;
	}
	public String getUrlAfterclickingFlyoutHeading(String headingName) {
		 String currentUrl;
		 String xpathHeading =createXPath("//span[contains(text(),'{0}')]" ,headingName); 
			WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
			getReusableActionsInstance().scrollToElement(headingWebElement);
			headingWebElement .click();
		 currentUrl = getDriver().getCurrentUrl();
		 return currentUrl;
		 

	 }


	
	
	
	 /*Method to get part of href for flyout heading link (instead of using yaml data use run time data )
	  * @return String:href(only get unique part (number) for each Flyout heading)
	  * @author Shruti Desai
	  */
	 public String gethrefBeforclickingFlyoutHeading(String headingName) {
		 String currentUrl;
		 String xpathHeading =createXPath("//li[contains(@class,'primary-navigation__item')]//a[contains(@class,'primary-navigation__link')]//span[contains(text(),'{0}')]" ,headingName); 
		 WebElement headingWebElement = getDriver().findElement(By.xpath(xpathHeading+"//ancestor::a"));
		 getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
		 currentUrl = headingWebElement.getAttribute("href").split("n:")[1];
		 return currentUrl;
	 }
	 
//ETRA METHODS
	/* 
	 public void waitcondition(WebElement webElement) {
		  AtomicReference<String> first_flyout_menu_text =new  AtomicReference<String>();
		 first_flyout_menu_text.set(webElement.getText().split(" ")[0]);
		System.out.println(Categories.getAttribute("href"));
		 waitForCondition(Driver->{return Categories.getAttribute("href").contains(first_flyout_menu_text.get());},60000);
			 
	}
	
	public String getCategoryHeading(WebElement webElement) {
		String CategoryHeading;
		getReusableActionsInstance().scrollToElement(webElement);
		CategoryHeading=webElement.getText();
		return CategoryHeading;
	 }
	 */
	  public void scrollToHeadingElement(String headingName) {
		 String xpathHeading =createXPath("//span[contains(text(),'{0}')]" ,headingName); 
			WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
			getReusableActionsInstance().scrollToElement(headingWebElement);
			
	 }
	 
	 
		
//-------------------------------------------------------------------------------------		
//------------------------------------------------------------------------------------------------------
	 /*Method to get WebElement for flyout heading  
		 * @return WebElement
		 * @author Shruti Desai
		 */	
		 public WebElement getWebElementFlyoutHeading(String headingName) {
			String xpathHeading =createXPath("//li[contains(@class,'primary-navigation__item')]//a[contains(@class,'primary-navigation__link')]//span[contains(text(),'{0}')]" ,headingName); 
			WebElement headingWebElement = getDriver().findElement(By.xpath(xpathHeading));
			return headingWebElement;
		 }
		 /*Method to get list of Flyout Headings
			 * @return list:Flyout Heading
			 * @author Shruti Desai
			 */		
			public List<String> getFlyoutHeadings() { 
				List<String> FlyoutHeadings= new ArrayList<String>();
				String newHeading;
				List<WebElement> listFlyoutHeadings =getFlyoutHeadingsWebelement();
				for(WebElement item:listFlyoutHeadings) {
					newHeading=item.getText().trim();
					//newHeading = createCamelCase(newHeading);
					FlyoutHeadings.add(newHeading);
				}
				return FlyoutHeadings;
			}	
//Sub Menu Section and its links	 

/*Method to get WebElement for Category items(submenu)  
* @return list of WebElements
* @author Shruti Desai
*/
public List<WebElement> getWebElementCatergoryItem(String headingName,String submenu) {
	 List<WebElement> CategoriesList =null;
	 String xpathCatagories =null;
	 WebElement headingWebElement =getWebElementFlyoutHeading(headingName);
	 getReusableActionsInstance().scrollToElement(headingWebElement);
	 if(submenu==null) {
		xpathCatagories=createXPath("//nav[contains(@class,'mega-categories')]//a[contains(@href,'{0}')]",headingName.split(" ")[0]);
		CategoriesList = headingWebElement.findElements(By.xpath("./ancestor::div[contains(@id,'contentPlaceHolder')]"+xpathCatagories));
		return	CategoriesList;
	}
	 	xpathCatagories =createXPath("//nav[contains(@class,'mega-categories')]//a[contains(text(),\"{0}\")]" ,submenu); 
	 	CategoriesList = headingWebElement.findElements(By.xpath("./ancestor::div[contains(@id,'contentPlaceHolder')]"+xpathCatagories));
	 	return CategoriesList; 
}
/*Method to get list of categories(submenu) under flyout heading
* @return list:categories(submenu)
* @author Shruti Desai
*/

public List<String> getCategorieslist(String headingName,String submenu) {
	 List<WebElement> CategoriesList=getWebElementCatergoryItem(headingName,submenu);
	 List<String> Categories =new ArrayList<String>();
	 AtomicReference<String> first_flyout_menu_text =new  AtomicReference<String>();
	 first_flyout_menu_text.set(headingName.split(" ")[0]);
	 String newCategoryName;
	 for(WebElement Category:CategoriesList) {
		 waitForCondition(Driver->{return Category.getAttribute("href").contains(first_flyout_menu_text.get());},60000);
		 newCategoryName=Category.getText().trim();
		 Categories.add(newCategoryName);
	 }
	 return Categories;
}

	 
/*Method to get WebElement for Submenu Item for each category
* @return list of WebElements
* @author Shruti Desai
*/
public List<WebElement> getWebElementSubmenuItem(String headingName,String section,String submenu, String itemName, String element) {
	 List<WebElement> SubMenuiteamList =null;
	 String xpathCatagories =null;
	 WebElement categoryWebElement =null;
	 String sectionXpathSubmenuItem=null;
	 switch(section) {
	 	case "Curated Collections":
	 		xpathCatagories =createXPath("//nav[contains(@class,'mega-curated mega-column')]//div//h4[contains(text(),'{0}')]" ,section); 
	 		categoryWebElement = 	getDriver().findElement(By.xpath(xpathCatagories));
	 		if(itemName==null) {
	 			SubMenuiteamList=categoryWebElement.findElements(By.xpath("./parent::div//a[contains(@href,'HDR') or contains(@href,'productresults')]"));
	 			return SubMenuiteamList;
	 		}
	 			sectionXpathSubmenuItem=createXPath("//a[contains(text(),'{0}')]",itemName);
	 			SubMenuiteamList=categoryWebElement.findElements(By.xpath("./parent::div"+sectionXpathSubmenuItem));
	 			return SubMenuiteamList;
		 	
	 	case "Popular Brands":
	 		xpathCatagories =createXPath("//nav[contains(@class,'mega-popular mega-column')]//div//h4[contains(text(),'{0}')]" ,section); 
			categoryWebElement = getDriver().findElement(By.xpath(xpathCatagories));
			if(itemName==null) {
				if(element=="href"){
					SubMenuiteamList=categoryWebElement.findElements(By.xpath("./parent::div//a[contains(@href,'HDR')]"));
				}else {
					SubMenuiteamList=categoryWebElement.findElements(By.xpath("./parent::div//a[contains(@href,'HDR')]/span/img"));
				}
				return SubMenuiteamList;
			}	
				sectionXpathSubmenuItem=createXPath("//a[contains(@href,'HDR')]/span/img[contains(@alt,'{0}')]",itemName);
				SubMenuiteamList=categoryWebElement.findElements(By.xpath("./parent::div"+sectionXpathSubmenuItem));
				return SubMenuiteamList;
			
	 	case "":
	 		categoryWebElement =getWebElementCatergoryItem(headingName,submenu).get(0);
	 		getReusableActionsInstance().scrollToElement(categoryWebElement);
			if(itemName==null) {
				WebElement parentElement=categoryWebElement.findElement(By.xpath("./ancestor::div[contains(@class,'mega-containers')]//nav[contains(@class,'mega-sub')]/ul"));
				Long childElement =getChildElementCount(parentElement);
				if(childElement>0) {
					SubMenuiteamList=parentElement.findElements(By.xpath("./li/a"));
				}
				return SubMenuiteamList;
			}
				String xpathSubmenuItem=createXPath("//a[contains(text(),'{0}')]",itemName);
				SubMenuiteamList=categoryWebElement.findElements(By.xpath("./ancestor::div[contains(@class,'mega-containers')]//nav[contains(@class,'mega-sub')]/ul/li"+xpathSubmenuItem));
				return SubMenuiteamList;
		}
	return SubMenuiteamList; 
}

/*Method to get list of Submenu Item under each category for left hand side an for link under popular brand/ curated collection section.
* @return list:Submenu item link text
* @author Shruti Desai
*/
public List<String> getSubMenuItemlist(String headingName,String section,String submenu, String itemName, String element) {
	 List<String> SubMenuItem =new ArrayList<String>();
	 String newSubMenuItemName=null;
	 try {System.out.println(headingName+">>>>"+submenu);
		 List<WebElement> SubMenuItemList=getWebElementSubmenuItem(headingName,section,submenu,itemName,element);
		 for(WebElement Item:SubMenuItemList) {
			  switch(section) {
			 	case "Popular Brands":
			 		newSubMenuItemName=Item.getAttribute("alt");
			 		break;
			 	case "Curated Collections":
			 		newSubMenuItemName=Item.getText().trim();
			 		break;
			 	case "":
			 		getReusableActionsInstance().scrollToElement(Item);
			 		getReusableActionsInstance().waitForElementVisibility(Item);
			 		//
					System.out.println(Item.getText().trim());
				 	newSubMenuItemName=Item.getText().trim();
				 	break;
			 }
			SubMenuItem.add(newSubMenuItemName);
		 }
	}catch(Exception e){
	     e.getMessage();
	 }
	return SubMenuItem;
}

public String validateFlyoutSubMenuItemSRCandHREF_try(String headingName,String section,String submenu, String itemName, String element) {
		StringBuilder href_src  =new StringBuilder();
		 try {
			 System.out.println("left hand side ELEMENTS--->"+submenu+">>>");
			 List<WebElement> SubMenuItemList=getWebElementSubmenuItem(headingName,section,submenu,itemName,element);
				System.out.println("size of List<WebElement> SubMenuItemList------------>"+SubMenuItemList.size());	
			 for (WebElement SBlinks:SubMenuItemList) {
				 getReusableActionsInstance().scrollToElement(SBlinks);
					
				 switch(section) {
				 case "Popular Brands":	
				 		if(element =="href") {
				 			if(!verifyElementProperty(SBlinks,"Link")) {//href not present
				 				href_src.append('\n').append(SBlinks.getAttribute("href").split("FlyoutNav_")[1]);
				 			}
				 			System.out.println("Popular Brands href:------->"+href_src.toString());
				 			//return ("href present for all elements"+href_src.toString());
				 		}else{	
				 			if(!verifyElementProperty(SBlinks,"Image")) {//href present and Src not present
				 				href_src.append('\n').append(SBlinks.getAttribute("alt"));
				 			}
				 		
				 			System.out.println("Popular Brands SRC:------->"+href_src.toString());
				 			//return ("src present for all elements"+href_src.toString());
				 		}
				 		break;
				 case "Curated Collections":
		 		 if(!verifyElementProperty(SBlinks,"Link")) {//href not present
						href_src.append('\n').append(SBlinks.getText());
				}
				
				//Return All attributes are present for curated collections
		 		System.out.println("Cu+ated Collections validate href:------->"+href_src.toString());
		 		//return ("All atributes are present"+href_src.toString());
		 	break;
		 	
		 		
		 	case ""://Verification of left hand side section links under submenu headings
		 		getReusableActionsInstance().scrollToElement(SBlinks);
		 		getReusableActionsInstance().waitForElementVisibility(SBlinks);
		 		System.out.println(SBlinks.getText().trim());
		 			//System.out.println("Left hand side section-----"+SBlinks.getAttribute("href"));
		 			if(!verifyElementProperty(SBlinks,"Link")) {//href not present
		 				System.out.println("href is not present condition.................>" +verifyElementProperty( SBlinks,"Link"));
		 				//return (SBlinks.getText());//
		 				href_src.append('\n').append(SBlinks.getText());
		 			}
		 			//System.out.println("left hand side section:------->"+href_src.toString());
		 			//return ("All atributes are present"+href_src.toString());
				break; 	
		 }	
			 }
		 }catch(Exception e){
		     e.getMessage();
		}
		
		return href_src.toString();	
}
/*Method to to click on WebElement for Submenu Item 
* @author Shruti Desai
*/
public void clickSubMenuItem(String headingName,String section,String submenu, String itemName, String element) {
	List<WebElement> SubMenuItemList=getWebElementSubmenuItem(headingName,section,submenu,itemName,element);
	WebElement SubMenuItem=SubMenuItemList.get(0);
	SubMenuItem.click();
}

/*Method to verify href is empty or not before submenu iteam in left hand side Section
* @return String
* @author Shruti Desai
*/
public String validateFlyoutSubMenuItemSRCandHREF(String headingName,String section,String submenu, String itemName, String element) {
		StringBuilder href_src  =new StringBuilder();
		//String elempresent ="All atributes are present";
		List<WebElement> SubMenuItemList=getWebElementSubmenuItem(headingName,section,submenu,itemName,element);
		switch(section) {
		 	case "Curated Collections":
		 		for (WebElement SBlinks:SubMenuItemList) {
					if(!verifyElementProperty(SBlinks,"Link")) {//href not present
						href_src.append('\n').append(SBlinks.getText());
					}
				}
				//Return All attributes are present for curated collections
		 		System.out.println("Cu+ated Collections validate href:------->"+href_src.toString());
		 		return href_src.toString();
		 	
		 	case "Popular Brands":	
		 		if(element =="href") {
		 			for (int i=0; i<SubMenuItemList.size(); i++) {
		 				if(!verifyElementProperty(SubMenuItemList.get(i),"Link")) {//href not present
		 					href_src.append('\n').append(SubMenuItemList.get(i).getAttribute("href").split("FlyoutNav_")[1]);
		 				}
		 			}
		 			System.out.println("Popular Brands href:------->"+href_src.toString());
		 			return href_src.toString();
		 		}else{	
		 			for (int i=0; i<SubMenuItemList.size(); i++) {
		 				if(!verifyElementProperty(SubMenuItemList.get(i),"Image")) {//href present and Src not present
		 					//System.out.println(verifyElementProperty(SubMenuItemList.get(i),"Link"));
							href_src.append('\n').append(SubMenuItemList.get(i).getAttribute("alt"));
		 				}
		 			}
		 			System.out.println("Popular Brands SRC:------->"+href_src.toString());
		 			return href_src.toString();
		 		}
		 		
		 	case ""://Verification of left hand side section links under submenu headings
		 		for (WebElement SBlinks:SubMenuItemList) {
		 			if(!verifyElementProperty(SBlinks,"Link")) {//href not present
		 				System.out.println("href is not present condition.................>" +verifyElementProperty( SBlinks,"Link"));
		 				//return (SBlinks.getText());//
		 				href_src.append('\n').append(SBlinks.getText());
		 			}
		 		}
		 		//System.out.println("left hand side section:------->"+href_src.toString());
		 		return href_src.toString();
		 		
		 }	
		return href_src.toString();	
}
	

		 
		 
		 

}	 
