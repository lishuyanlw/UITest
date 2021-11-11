package com.tsc.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.openqa.selenium.By;
import com.tsc.pages.base.BasePage;
public class GlobalheaderPage extends BasePage{
	
	
	
	public GlobalheaderPage(WebDriver driver) {
		super(driver);
	}

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

	//Top suggestions
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(.,'Top suggestions') or contains(.,'Trending')][contains(@class,'ac__section__title search-title')]")
	public WebElement lblTopSuggestions;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(.,'Top suggestions') or contains(.,'Trending')][contains(@class,'ac__section__title search-title')]/following-sibling::ul")
	public WebElement cntTopSuggestionsList;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(.,'Top suggestions') or contains(.,'Trending')][contains(@class,'ac__section__title search-title')]/following-sibling::ul//li//a")
	public List<WebElement> lstTopSuggestionsLink;
	
	public By byUnmarkedTextForTopSuggestions = By.xpath(".//span[contains(@class,'unmark-text')]");
	
	//Categories
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(.,'Categories') or contains(.,'Featured brands')][contains(@class,'ac__section__title search-title')]")
	public WebElement lblCategories;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(.,'Categories') or contains(.,'Featured brands')][contains(@class,'ac__section__title search-title')]/following-sibling::ul")
	public WebElement cntCategoriesList;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(.,'Categories') or contains(.,'Featured brands')][contains(@class,'ac__section__title search-title')]/following-sibling::ul//li//a")
	public List<WebElement> lstCategoriesLink;
	
	//Brands
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(.,'Brands') and contains(@class,'ac__section__title search-title')]")
	public WebElement lblBrands;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(.,'Brands') and contains(@class,'ac__section__title search-title')]/following-sibling::ul")
	public WebElement cntBrandsList;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(.,'Brands') and contains(@class,'ac__section__title search-title')]/following-sibling::ul//li//a")
	public List<WebElement> lstBrandsLink;
	
	//Possible item matches
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--right')]//*[contains(.,'Possible item matches') or contains(.,'Top Selling Products')][contains(@class,'search-title')]")
	public WebElement lblPossibleItemMatches;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--right')]//*[contains(.,'Possible item matches') or contains(.,'Top Selling Products')][contains(@class,'search-title')]/following-sibling::ul")
	public WebElement cntPossibleItemMatchesList;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--right')]//*[contains(.,'Possible item matches') or contains(.,'Top Selling Products')][contains(@class,'search-title')]/following-sibling::ul//li//a")
	public List<WebElement> lstPossibleItemMatchesLink;
	
	
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

	@FindBy(xpath = "//ul[contains(@class,'primary-navigation__wrapper')]//li//a")
	WebElement FlyoutHeadings;

	@FindBy(xpath="//*[@id='mega-navigation-desktop']/nav")
	List<WebElement> flyoutHeaderSections;

	By flyoutHeaderLeftSection = By.xpath("[contains(@class,'mega-categories mega-column')]//a");
	
	@FindBy(xpath = "//*[contains(@class,'mega-categories mega-column')]//a")
	WebElement Categories;
	
	@FindBy(xpath = "//*[contains(@class,'primary-navigation__wrapper')]//a//span[contains(@class,'primary-navigation__link-text')]")
	public List<WebElement> headingLinks;
	
	@FindBy(xpath = "//*[contains(@class,'mega-categories mega-column')]//a")
	public List<WebElement> CategoriesLinks;
	
	@FindBy(xpath = "//*[contains(@class,'mega-sub-items mega-column')]//a")
	public List<WebElement> subMenuLinks;
	
	@FindBy(xpath = "//*[contains(@class,'mega-sub-items mega-column')]//ul")
	public List<WebElement> subMenuSection;
	
	@FindBy(xpath = "//a[contains(@class,'mega-curated__item-link')]")
	public List<WebElement> listCuratedCollectionLinks;
	
	
	@FindBy(xpath = "//a[contains(@class,'mega-popular__brand-link')]//img")
	public List<WebElement> listPopularBrandsLinks;
	
	@FindBy(xpath = "//h2[contains(@class,'gatewayTitle xs-vw8')]")
	WebElement flyoutHeadingLandigPageHeading;
	
	@FindBy(xpath = "//h2[contains(@class,'titleLink')]//b")
	WebElement shopAllBrandsLandigPageHeading;

	@FindBy(xpath="//span[contains(text(),'Clearance')]")
	WebElement clearanceHeader;

	//Godwin
	@FindBy(xpath="//a[@class='mega-sub-items__item-link mega-sub-items__item-link-first' and contains(text(),'Shop all')]")
	WebElement shopAllFasionOption;

	@FindBy(xpath="//a[@role=\"button\" and contains(text(),'Fashion')]")
	WebElement fasionOption;

	
	public void waitForPageLoad() {
		getReusableActionsInstance().waitForPageLoad();
		(new ProductResultsPage(this.getDriver())).waitForPageLoading();	
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
	 * This method will validate clicking TSCLogo can navigate page to HomePage.
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
	 * @return true/false
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
		 getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnWatchTSCBlackHeader);
		 getReusableActionsInstance().scrollToElement(this.btnWatchTSCBlackHeader);
		 getReusableActionsInstance().staticWait(100);		 
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

	 
	/**
	 *Method to show popup window by clicking search box 	
	 * @return true/false
	 * @author Wei.Li
	 */	
	 public boolean getPopupWindowByClickingSearchBox() {
		 this.searchBox.click();
		 return waitForCondition(Driver->{return this.lblTopSuggestions.isDisplayed();},5000);
	 }
	 
	/**
	 *Method to verify TopSellingProducts existing by changing item in Trending or Featured brands list   
	 * @param List<WebElement> elementList: element list	
	 * @return void
	 * @author Wei.Li
	 */	
	 public void verifyTopSellingProductsExistingByChangingItemInTrendingOrFeaturedBrandsList(List<WebElement> elementList) {
		 String lsItem;
		 for(WebElement element:elementList) {
			 getReusableActionsInstance().scrollToElement(element);
			 getReusableActionsInstance().staticWait(300);
			 lsItem=element.getText();
			 reporter.softAssert(getReusableActionsInstance().isElementVisible(this.lblPossibleItemMatches),"The title of Top selling products is displaying correctly by selecting item of '"+lsItem+"'", "The title of Top selling products is not displaying correctly by selcting item of '"+lsItem+"'");
			 reporter.softAssert(getReusableActionsInstance().isElementVisible(this.cntPossibleItemMatchesList),"The Top selling products list is displaying correctly by selecting item of '"+lsItem+"'","The Top selling products list is not displaying correctly by selcting item of '"+lsItem+"'");			 
		 }	
	 }
	 
	 
	 /* Flyout section validation
	  * @author Shruti Desai
	  */
	 
	 public StringBuilder href_src_category  =new StringBuilder();
	 public StringBuilder href_src_submenu  =new StringBuilder();
	 public StringBuilder  href_src_section  =new StringBuilder();
	 public StringBuilder href_src_data = new StringBuilder();
	 /*Method to click on WebElement for Submenu Item by providing Flyout heading name , category and item as parameters.
	  * @author Shruti Desai
	  */
		public void clickSubMenuItem(String headingName,String submenuHeading, String itemName) {
			String xpathHeading =createXPath("//span[contains(text(),'{0}')]" ,headingName); 
			WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
			getReusableActionsInstance().scrollToElement(headingWebElement);

			if(headingWebElement!=null && submenuHeading==null) {
				headingWebElement.click();
			}
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
		}
		
		/*Method to get list of Flyout heading WebElements
		 * @return List:Flyout heading WebElements
		 * @author Shruti Desai
		 */
		public List<WebElement> getFlyoutHeadingsWebelement() {
			List<WebElement> headingElements =FlyoutHeadings.findElements(By.xpath("//span[contains(@class,'primary-navigation__link-text')]"));
			return headingElements;
		}
		
		/*Method to scroll to desired WebElement 
		 * @author Shruti Desai
		 */
		public void scrolltoWebElement(WebElement webElement) {
			getReusableActionsInstance().scrollToElement(webElement);
			}
		
		/*Method to verify Flyout heading 
		 * @return true/false
		 * @author Shruti Desai
		 */
		public boolean verifyhrefFlyoutHeading(WebElement webElement) {
			WebElement headinghref= webElement.findElement(By.xpath("./ancestor::a"));
			if(!verifyElementProperty(headinghref,"Link")) {
				return false;
			}
			return true;
		}
		
		/*Method to get url after clicking flyout heading link
		 * @return String:href
		 * @author Shruti Desai
		 */
		public String getUrlAfterclickingFlyoutHeading(String headingName) {
			 String currentUrl;
			 String xpathHeading =createXPath("//span[contains(text(),'{0}')]" ,headingName); 
			 WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
			 getReusableActionsInstance().scrollToElement(headingWebElement);
			 headingWebElement .click();
			 currentUrl = getDriver().getCurrentUrl();
			 return currentUrl;
		}
		/*Method to apply static wait  
		 * @author Shruti Desai
		 */
		public void staticwait() {
			applyStaticWait(3000);
		}
		
		/*Method to get WebElement for flyout heading  
		 * @return WebElement
		 * @author Shruti Desai
		 */	
		public WebElement getWebElementFlyoutHeading(String headingName) {
			String xpathHeading =createXPath("//span[contains(text(),'{0}')]" ,headingName); 
			WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
			return headingWebElement;
		 }
		
		/* Method for scroll to Flyout heading WebElement
		 * @author Shruti Desai
		 */
		public void scrollToHeadingElement(String headingName) {
			  WebElement headingWebElement =getWebElementFlyoutHeading(headingName);
			  getReusableActionsInstance().scrollToElement(headingWebElement);
		}
		
		
		/*Method to get WebElement for shop all brand in Popular Brand section  
		 * @return WebElement
		 * @author Shruti Desai
		 */	
		public WebElement getWebElementShopAllPupularBrand() {
			WebElement ShopAllWebElement = getDriver().findElement(By.xpath("//a[contains(@class,'mega-popular__cta')]"));
			return ShopAllWebElement;
		}

		/*Method to verify href is present or not before clicking shop all link in Popular Brand Section and get url of landing page 
		 * @return String:href(only get unique part for each heading)
		 * @author Shruti Desai
		 */
		public String getURLshopAllPupularBrand(String headingName,String section) {
			String currentUrl=null;
			AtomicReference<String> first_flyout_menu_text =new  AtomicReference<String>();
			first_flyout_menu_text.set(headingName.split(" ")[0]);
			WebElement linkPopularBrand = listPopularBrandsLinks.get(0);
			waitForCondition(Driver->{return (linkPopularBrand.getAttribute("href").contains(first_flyout_menu_text.get()) && linkPopularBrand.getAttribute("class").contains(section.split(" ")[0].trim().toLowerCase()));} ,30000);
			WebElement ShopAllWebElement = getWebElementShopAllPupularBrand();
			if(verifyElementProperty(ShopAllWebElement,"Link")) {
				if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
					getReusableActionsInstance().javascriptScrollByVisibleElement(ShopAllWebElement);
				}
				getReusableActionsInstance().scrollToElement(ShopAllWebElement);
				ShopAllWebElement.click();
				currentUrl = getDriver().getCurrentUrl();
			}
			return currentUrl;
		}
		
	/*Method to get heading of landing page
	 * @parameter : pageName
	 * @return String:Heading of the page
	 * @author Sachin Sharma
	 */
	public String getHeadingForLandingPage(String pageName) {
		WebElement webElement = getWebElementFlyoutHeading(pageName);
		return createCamelCase(getPageTitle(webElement));
	}
	
	/*Method to verify href/src is empty or not before clicking sub menu link
	 * @return true/false
	 * @author Shruti Desai
	 */
	public String verifysubMenuhref(List<WebElement> webElements) {
		if(isParentElementHasAttribute(webElements,"li")) {
			for (WebElement element:this.subMenuLinks) {
				getReusableActionsInstance().scrollToElement(element);
				if(!verifyElementProperty(element,"Link")) {//href is not present
					href_src_submenu.append(element.getText()).append('\n');
				}
			}
		}
		return  href_src_submenu.toString();
	}

	public Boolean isParentElementHasAttribute(List<WebElement> parent, String attribute) {
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		ArrayList<Integer> childSize= (ArrayList<Integer>) jse.executeScript("return arguments[0].getElementsByTagName(arguments[1]);", parent.get(0),attribute);
		if(childSize.size()>0) return true;
		return false;
	}
		
	/*Method to verify href/src is empty or not before clicking category link
	 * @return true/false
	 * @author Shruti Desai
	 */
	public String verifyCategoryhref(String headingName,List<WebElement> webElements) {
		AtomicReference<String> first_flyout_menu_text =new  AtomicReference<String>();
		first_flyout_menu_text.set(headingName.split(" ")[0]);
		waitForCondition(Driver->{return (webElements.get(0).getAttribute("href").contains(first_flyout_menu_text.get()));} ,30000);
		for (WebElement element:webElements) {
			getReusableActionsInstance().scrollToElement(element);
			if(!verifyElementProperty(element,"Link")) {
				//if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
				href_src_category.append(element.getText()).append('\n');
				//}
			}
		}
		return  href_src_category.toString(); 
	}
		
	/*Method to verify href/src is empty or not before clicking Popular Brand/Curated Collection link
	 * @return true/false
	 * @author Shruti Desai
	 */
	public String verifyFlyoutMenuItems(String heading, String section){
		AtomicReference<String> first_flyout_menu_text =new  AtomicReference<String>();
		List<WebElement> headingsElements=this.headingLinks;
		if(heading==null) {
			for(WebElement headerItem: headingsElements) {
				this.scrolltoWebElement(headerItem);
				this.staticwait();
				first_flyout_menu_text.set(headerItem.getText().split(" ")[0]);
				waitForCondition(Driver->{return (CategoriesLinks.get(0).getAttribute("href").contains(first_flyout_menu_text.get()));} ,30000);
				String headingName =headerItem.getText();
				reporter.reportLog("Flyout heading "+headingName);
				if(section==null) {
					first_flyout_menu_text.set(verifyFlyoutMenuSection(headerItem.getText(),"Left Section"));
					first_flyout_menu_text.get();
					reporter.softAssert(first_flyout_menu_text.get()=="","All elements present.",heading+ " > "+first_flyout_menu_text.get());
					href_src_data.delete(0, href_src_data.length());
					first_flyout_menu_text.set(verifyFlyoutMenuSection(headerItem.getText(),"Curated Collections"));
					first_flyout_menu_text.get();
					reporter.softAssert(first_flyout_menu_text.get()=="","All elements present.",heading+ " > "+first_flyout_menu_text.get());
					href_src_data.delete(0, href_src_data.length());
					first_flyout_menu_text.set(verifyFlyoutMenuSection(headerItem.getText(),"Popular Brands"));
					first_flyout_menu_text.get();
					reporter.softAssert(first_flyout_menu_text.get()=="","All elements present.",heading+ " > "+first_flyout_menu_text.get());
					href_src_data.delete(0, href_src_data.length());
				}else{
					first_flyout_menu_text.set(verifyFlyoutMenuSection(headingName,section));
					first_flyout_menu_text.get();
					reporter.softAssert(first_flyout_menu_text.get()=="","All elements present.",headingName+ " > "+first_flyout_menu_text.get());
					href_src_data.delete(0, href_src_data.length());
					//soft assert
				
					}
			}
		}else{
//use webelement using heading name and copy from this.scrolltowebelemetn from upper part.
		}
		return first_flyout_menu_text.toString();
	}

	public String verifyFlyoutMenuSection(String headingName,String sectionName){
		
		switch(sectionName){
			case "Curated Collections":
				reporter.reportLog("Verifying Curated Collections items for : "+headingName);
				for(WebElement webElement:listCuratedCollectionLinks){
					getReusableActionsInstance().scrollToElement(webElement);
					if(!verifyElementProperty(webElement,"Link")) {//href is not present
						href_src_data.append("Href missing for Curated Collection item: ").append(webElement.getText()).append('\n');
					}
				}
				return href_src_data.toString();
			case "Popular Brands":
				reporter.reportLog("Verifying Popular Brands items for : "+headingName);
				for(WebElement webElement:listPopularBrandsLinks){
					getReusableActionsInstance().scrollToElement(webElement);
					WebElement hrefAttribute =webElement.findElement(By.xpath("./ancestor::a"));
					if(!verifyElementProperty(hrefAttribute,"Link")) {//href not present
						href_src_data.append("Href missing for Popular Brand item: ").append(webElement.getAttribute("alt")).append('\n');
					}
					if(!verifyElementProperty(webElement,"Image")) {//href not present
						href_src_data.append("Image missing for Popular Brand item: ").append(webElement.getAttribute("alt")).append('\n');
					}
				}
				return href_src_data.toString();
			case "Left Section":
				String smHref=null;
				for (WebElement category:CategoriesLinks) {
					this.scrolltoWebElement(category);
					smHref=this.verifysubMenuhref(subMenuSection);
					reporter.softAssert(smHref=="","href is present for all elements  "+headingName+" > "+category.getText(),"href missing for "+headingName+" > "+category.getText()+" > "+smHref);
				}
				return smHref;
		}
		return href_src_data.toString();
	}

	public String verifyBrand_Curated_Section(String headingName, String section,List<WebElement> webElements) {
		AtomicReference<String> first_flyout_menu_text =new  AtomicReference<String>();
		first_flyout_menu_text.set(headingName.split(" ")[0]);
		waitForCondition(Driver->{return (CategoriesLinks.get(0).getAttribute("href").contains(first_flyout_menu_text.get()));} ,30000);
		for (WebElement element:webElements) {
			getReusableActionsInstance().scrollToElement(element);
			switch(section) {
				case "PopularBrands":
						WebElement hreffattri =element.findElement(By.xpath("./ancestor::a"));
						//href is not present
						if(!verifyElementProperty(hreffattri,"Link")) {//href not present
							href_src_section.append("Href missing for Popular Brand item: ").append(element.getAttribute("alt")).append('\n');
						}
						//src is not present
						if(!verifyElementProperty(element,"Image")) {//href not present
							href_src_section.append("Image missing for Popular Brand item: ").append(element.getAttribute("alt")).append('\n');
						}
						
				break;
				case "CuratedCollection":	
					if(!verifyElementProperty(element,"Link")) {//href is not present
						href_src_section.append(element.getText()).append('\n');
					} 
				break;
			}
		}
		return  href_src_section.toString();
	}
}
