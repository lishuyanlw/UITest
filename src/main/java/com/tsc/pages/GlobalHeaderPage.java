package com.tsc.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.openqa.selenium.By;
import com.tsc.pages.base.BasePage;

public class GlobalHeaderPage extends BasePage{

	public GlobalHeaderPage(WebDriver driver) {
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
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a")
	public List<WebElement> lstWatchTSCDpdMenu;

	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'WatchUsLive')]")
	public WebElement lnkWatchUsLiveDpdMenu;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'Deals')]")
	public WebElement lnkDealsDpdMenu;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'ProgramGuide')]")
	public WebElement lnkProgramGuideDpdMenu;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'Gadgets')]")
	public WebElement lnkCarGadgetsDpdMenu;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'Today')]")
	public WebElement lnkDesignerFootwearDpdMenu;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//nav//li//a[contains(@href,'OnAir')]")
	public WebElement lnkOnAirProductsDpdMenu;
	
	@FindBy(xpath = "//h1")
	public WebElement headingWatchTSCDpdMenuLinkLandingPage;

	@FindBy(xpath = "//h2")
	public WebElement headingTSLinkLandingPage;


	//Sliver Links [Dynamic event, TS, Deals, OnAir, Program Guide, Watch Us Live]
	@FindBy(xpath = "//*[@class='BlackHeader']//a[contains(@href, 'todaysshowstopper')]")
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
	
	//Trending without keyword
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Trending')][contains(@class,'ac__section__title search-title')]")
	public WebElement lblTrendingWithoutKeyword;

	@FindBy(xpath="//div[contains(@class,'searchContainer')]//div[contains(@class,'inner--left')]")
	public WebElement lblSearchBoxPopUpWindow;

	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Top')][contains(@class,'ac__section__title search-title')]/following-sibling::ul")
	public WebElement cntTrendingListWithoutKeyword;
		
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Trending')][contains(@class,'ac__section__title search-title')]/following-sibling::ul//li//a")
	public List<WebElement> lstTrendingLinkWithoutKeyword;
		
	//Featured brands without keyword
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Featured brands')][contains(@class,'ac__section__title search-title')]")
	public WebElement lblFeaturedBrandsWithoutKeyword;
		
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Categories')][contains(@class,'ac__section__title search-title')]/following-sibling::ul")
	public WebElement cntFeaturedBrandsListWithoutKeyword;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Featured brands')][contains(@class,'ac__section__title search-title')]/following-sibling::ul//li//a")
	public List<WebElement> lstFeaturedBrandsLinkWithoutKeyword;

	//Top suggestions with keyword
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Top suggestions')][contains(@class,'ac__section__title search-title')]")
	public WebElement lblTopSuggestionsWithKeyword;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Top suggestions')][contains(@class,'ac__section__title search-title')]/following-sibling::ul")
	public WebElement cntTopSuggestionsListWithKeyword;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Top suggestions')][contains(@class,'ac__section__title search-title')]/following-sibling::ul//li//a")
	public List<WebElement> lstTopSuggestionsLinkWithKeyword;
	
	public By byUnmarkedTextForTopSuggestions = By.xpath(".//span[contains(@class,'unmark-text')]");
	
	//Categories with keyword
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Categories')][contains(@class,'ac__section__title search-title')]")
	public WebElement lblCategoriesWithKeyword;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Categories')][contains(@class,'ac__section__title search-title')]/following-sibling::ul")
	public WebElement cntCategoriesListWithKeyword;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Categories')][contains(@class,'ac__section__title search-title')]/following-sibling::ul//li//a")
	public List<WebElement> lstCategoriesLinkWithKeyword;
	
	//Brands with keyword
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Brands')][contains(@class,'ac__section__title search-title')]")
	public WebElement lblBrandsWithKeyword;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Brands')][contains(@class,'ac__section__title search-title')]/following-sibling::ul")
	public WebElement cntBrandsListWithKeyword;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Brands')][contains(@class,'ac__section__title search-title')]/following-sibling::ul//li//a")
	public List<WebElement> lstBrandsLinkWithKeyword;
	
	//Possible item matches or Top Selling Products
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--right')]//div[@class='ac__layout-inner--left']//*[contains(normalize-space(.),'Possible item matches') or contains(normalize-space(.),'Top Selling Products')]")
	public WebElement lblPossibleItemMatches;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--right')]//div[@class='ac__layout-inner--left']")
	public WebElement cntPossibleItemMatchesList;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--right')]//div[@class='ac__layout-inner--left']//ul//li//a")
	public List<WebElement> lstPossibleItemMatchesLink;
	
	//More to Explore
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--right')]//div[@class='ac__layout-inner--right']//*[contains(@class,'search-title')]")
	public WebElement lblMoreToExplore;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--right')]//div[@class='ac__layout-inner--right']")
	public WebElement cntMoreToExploreList;
	
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--right')]//div[@class='ac__layout-inner--right']//ul//li")
	public List<WebElement> lstMoreToExplore;
	
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
	
	@FindBy(xpath = "//div[contains(@class,'signin-wrapper clearfix')]//h1//span[contains(.,'Sign In')]")
	public WebElement SigninPageHeading;
	
	//Shopping Cart 
	@FindBy(xpath = "//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]")
	public WebElement ShoppingCartlnk;
 
	@FindBy(xpath ="//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]/span")
	public WebElement ShoppingCartIconcont;

	@FindBy(xpath = "//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]//*[@class='secondary-navigation__rhs-bag__item-icon']")
	public WebElement CartBagIcon;
	
	@FindBy(xpath = "//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]//div[contains(@class,'secondary-navigation__rhs-bag__item')]//span[contains(@class,'secondary-navigation__rhs-bag__item-badge')]//span[not(contains(@class,'visually-hidden'))]")
	public WebElement CartBagCounter;

	//Flyout headings menu
	@FindBy(xpath = "//ul[contains(@class,'primary-navigation__wrapper')]//li//a")
	WebElement FlyoutHeadings;

	//Categories menu
	@FindBy(xpath = "//*[contains(@class,'mega-categories mega-column')]//a")
	WebElement Categories;
	
	@FindBy(xpath = "//*[contains(@class,'primary-navigation__wrapper')]//a//span[contains(@class,'primary-navigation__link-text')]")
	public List<WebElement> headingLinks;
	
	@FindBy(xpath = "//*[contains(@class,'mega-categories mega-column')]//a")
	public List<WebElement> CategoriesLinks;
	
	//SubMenu
	@FindBy(xpath = "//*[contains(@class,'mega-sub-items mega-column')]//a")
	public List<WebElement> subMenuLinks;
	
	@FindBy(xpath = "//*[contains(@class,'mega-sub-items mega-column')]//ul")
	public List<WebElement> subMenuSection;
	
	//Curated collection
	@FindBy(xpath = "//a[contains(@class,'mega-curated__item-link')]")
	public List<WebElement> listCuratedCollectionLinks;

	@FindAll({
		@FindBy(xpath="//div[contains(@class,'Middle')]//brand/div[contains(@class,'brand')]//*[contains(@class,'titleLink')]"),
		@FindBy(xpath="//div[contains(@class,'Middle')]//div[contains(@class,'PageTitle')]//*[contains(@class,'gatewayTitle')]")
	})
	public WebElement lblPageTitleForMenuItems;

	//Popular brand
	@FindBy(xpath = "//a[contains(@class,'mega-popular__brand-link')]//img")
	public List<WebElement> listPopularBrandsImg;

	@FindBy(xpath = "//a[contains(@class,'mega-popular__brand-link')]")
	public List<WebElement> listPopularBrandsLink;

	@FindBy(xpath = "//a[contains(@class,'mega-popular__cta')]")
	public WebElement shopAllPopularBrands;

	@FindBy(xpath = "//h2[contains(@class,'titleLink')]")
	public WebElement shopAllBrandsLandigPageHeading;

	@FindBy(xpath="//span[contains(.,'Clearance')]")
	WebElement clearanceHeader;

	@FindBy(xpath="//span[contains(@id,'_ctlSpanTitle')]")
	public WebElement landingPageTitle;

	@FindBy(xpath="//div[contains(@class,'__heading')]/button")
	public WebElement btnMobileMenuCloseButton;

	@FindBy(xpath="//div[contains(@class,'searchContainer')]//button[contains(@class,'aa-ClearButton')]")
	public WebElement btnMobileSearchMenuClose;

	@FindBy(xpath="//div[@class='helpButton']//span[@id='helpButtonSpan']/span[@class='message']")
	public WebElement lblTSCChatBox;

	public void clickOnClearanceHeaderOption() {
		getReusableActionsInstance().clickIfAvailable(clearanceHeader);
	}

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

	public void clickOnTSCLogo() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkTSClogo);
		getReusableActionsInstance().clickIfAvailable(lnkTSClogo);
		getReusableActionsInstance().waitForPageLoad();
		waitForCondition(Driver->{return this.searchBox.isEnabled() && this.searchBox.isDisplayed();},60000);
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
	
	
	public boolean validateSiginIcon() {
		return getReusableActionsInstance().isElementVisible(SigninIcon, 5);
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
		 waitForCondition(Driver->{return this.FlyoutHeadings.isEnabled();},50000);
		 getReusableActionsInstance().staticWait(4000);
		 return (new GlobalFooterPage(this.getDriver())).waitForPageLoading();
	 }

	/**
	 *Method to hover on WatchTSC in Black headers  
	 * @author Wei.Li
	 */	
	 public void hoverOnWatchTSC() {
	 	getReusableActionsInstance().waitForPageLoad();
	 	getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnWatchTSCBlackHeader);
		getReusableActionsInstance().staticWait(2000);
		//Clicking on button twice as test is not working for Safari using scrollToElement
		getReusableActionsInstance().clickIfAvailable(this.btnWatchTSCBlackHeader);
		getReusableActionsInstance().staticWait(3000);
		 if(!(System.getProperty("Browser").toLowerCase().contains("ios") && System.getProperty("Device").toLowerCase().contains("tablet"))){
			 getReusableActionsInstance().clickIfAvailable(this.btnWatchTSCBlackHeader);
			 getReusableActionsInstance().staticWait(1000);
		 }
	 }	
	 
	/**
	 *Method to verify TS header and link in Black headers  	 
	 * @param-WebElement blackItem: the header in Black headers
	 * @param-WebElement silverItem: the header in Silver headers
	 * @param-boolean bCheckUrl: to decide if check Url after clicking the header in Black headers
	 * @author Wei.Li
	 */	
	 public void verifyTSHeaderAndLinkInBlackHeader(WebElement blackItem,WebElement silverItem,boolean bCheckUrl) {
	 	getReusableActionsInstance().waitForPageLoad();
	 	getReusableActionsInstance().javascriptScrollByVisibleElement(blackItem);
		/*if(!System.getProperty("Device").equalsIgnoreCase("Desktop")) {
			getReusableActionsInstance().clickIfAvailable(blackItem);
		}*/
		String title=blackItem.getText().trim();
		String lsTitle=getUTFEnabledData(title);
		reporter.softAssert(getReusableActionsInstance().isElementVisible(blackItem), "The element of "+lsTitle+" in Black headers is visible","The element of "+lsTitle+" in Black headers is not visible");
		reporter.softAssert(!lsTitle.isEmpty(), lsTitle+" text in Black headers is not empty", lsTitle+" text in Black headers is empty");
		String lsHrefInBlackHeader=this.getElementHref(blackItem);
		reporter.softAssert(!lsHrefInBlackHeader.isEmpty(), "The href of "+lsTitle+" in Black headers is not empty", "The href of "+lsTitle+" in Black headers is empty");
		lsHrefInBlackHeader=this.removeLastSlashFromUrl(lsHrefInBlackHeader);

		blackItem.click();
		(new GlobalFooterPage(this.getDriver())).waitForPageLoading();
		//Using static wait here as there is no other unique element where we can use waitForCondition() function here
		getReusableActionsInstance().staticWait(5000);
		String lsUrlInSilverHeader=this.removeLastSlashFromUrl(this.URL());

		if(bCheckUrl) {
			reporter.softAssert(lsUrlInSilverHeader.equalsIgnoreCase(lsHrefInBlackHeader), "The Url of " + lsUrlInSilverHeader + "  after clicking " + lsTitle + " in Black headers is equal to the href of " + lsHrefInBlackHeader, "The Url of " + lsUrlInSilverHeader + "  after clicking " + lsTitle + " in Black headers is not equal to the href of " + lsHrefInBlackHeader);
		}

		if(silverItem!=null) {
			String lsStyle=silverItem.findElement(By.xpath(".//span")).getAttribute("style");
			reporter.softAssert(lsStyle.toLowerCase().contains("color:#fff;")||lsStyle.toLowerCase().contains("color: rgb(255, 255, 255);"), lsTitle+" in Silver headers is being selected", lsTitle+" in Silver headers is not being selected");
		}
	 }

	 
	/**
	 *Method to show popup window by clicking search box 	
	 * @return true/false
	 * @author Wei.Li
	 */	
	 public boolean getPopupWindowByClickingSearchBox() {
		 //this.searchBox.click();
		 return waitForCondition(Driver->{return this.lblSearchBoxPopUpWindow.isDisplayed();},90000);
	 }
	 
	/**
	 *Method to verify TopSellingProducts existing by changing item in Trending or Featured brands list   
	 * @param-List<WebElement> elementList: element list
	 * @return void
	 * @author Wei.Li
	 */
	 public void verifyTopSellingProductsExistingByChangingItemInTrendingOrFeaturedBrandsList(List<WebElement> elementList) {
		 String lsItem;
		 for(WebElement element:elementList) {
			 getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			 getReusableActionsInstance().scrollToElement(element);
			 getReusableActionsInstance().staticWait(300);
			 lsItem=element.getText();
			 if(System.getProperty("Device").equalsIgnoreCase("Desktop")) {

				 reporter.softAssert(getReusableActionsInstance().isElementVisible(this.lblPossibleItemMatches),"The title of Top selling products is displaying correctly by selecting item of '"+lsItem+"'", "The title of Top selling products is not displaying correctly by selcting item of '"+lsItem+"'");
			 }
			 reporter.softAssert(getReusableActionsInstance().isElementVisible(this.cntPossibleItemMatchesList),"The Top selling products list is displaying correctly by selecting item of '"+lsItem+"'","The Top selling products list is not displaying correctly by selcting item of '"+lsItem+"'");
		}
	 }


	/**
	 /*Method to click on WebElement for Submenu Item by providing Flyout heading name , category and item as parameters.
	 * @author Shruti Desai
	 */
	public String getNameAndclickSubMenuItem(String headingName,String submenuHeading, String itemName) {
		WebElement searchResultTitle=(new ProductResultsPage(this.getDriver())).lblSearchResultTitle;
		String xpathHeading =createXPath("//span[contains(@class,'navigation__link-text') and contains(.,'{0}')]" ,headingName);
		WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
		getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
		getReusableActionsInstance().scrollToElement(headingWebElement);

		if(headingWebElement!=null && submenuHeading==null) {
			headingWebElement.click();
			waitForCondition(Driver->{return searchResultTitle.isDisplayed();},90000);
			return headingWebElement.getText().trim();
		}
		if(submenuHeading!=null) {
			String xpathSubMenu =createXPath("//li[contains(@class,'categories__item')]//a[contains(.,'{0}')]" ,submenuHeading);
			List<WebElement> SubMenu = Categories.findElements(By.xpath(xpathSubMenu));
			if(SubMenu.size()>0){
				getReusableActionsInstance().javascriptScrollByVisibleElement(SubMenu.get(0));
				getReusableActionsInstance().scrollToElement(SubMenu.get(0));
				if(itemName!=null) {
					String title = null;
					String xpathSubmenuItem=createXPath("//li[contains(@class,'sub-items')]//a[contains(.,'{0}')]",itemName);
					List<WebElement> SubMenuItem=getDriver().findElements(By.xpath(xpathSubmenuItem));
					if(SubMenuItem.size()>0){
						getReusableActionsInstance().javascriptScrollByVisibleElement(SubMenuItem.get(0));
						getReusableActionsInstance().scrollToElement(SubMenuItem.get(0));
						title = SubMenuItem.get(0).getText().trim();
						SubMenuItem.get(0).click();
						waitForCondition(Driver->{return searchResultTitle.isDisplayed();},90000);
					}else{
						SubMenuItem.clear();
						xpathSubmenuItem = createXPath("//li[contains(@class,'categories-item__sub-item')]/a[contains(.,'{0}')]", "Shop");
						SubMenuItem = getDriver().findElements(By.xpath(xpathSubmenuItem));
						getReusableActionsInstance().scrollToElement(SubMenuItem.get(0));
						title = SubMenuItem.get(0).getText().trim();
						SubMenuItem.get(0).click();
					}
					return title;
				}else {
					String title = SubMenu.get(0).getText().trim();
					SubMenu.get(0).click();
					waitForCondition(Driver->{return searchResultTitle.isDisplayed();},90000);
					return title;
				}
				//Adding else condition to click on first element by default if passed submenu item is not present in list
			}else{
				WebElement element = Categories.findElement(By.xpath("./a"));
				String title = element.getText().trim();
				element.click();
				waitForCondition(Driver->{return searchResultTitle.isDisplayed();},90000);
				return title;
			}
		}
		return null;
	}
	
	/**Method to click on WebElement for CuratedCollections SubMenu Item by providing Flyout heading name ,CuratedCollections SubMenu Item name as parameters.
	 * @param-String headingName: flyout menu item name
	 * @param-String submenuHeading: Curated Collections Menu Item name
	 * @author Wei.Li
	 */
	public void clickCuratedCollectionsMenuItem(String headingName,String submenuHeading) {
		String xpathHeading =createXPath("//span[contains(@class,'navigation__link-text') and contains(.,'{0}')]" ,headingName);
		WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
		getReusableActionsInstance().scrollToElement(headingWebElement);

		for(WebElement item:listCuratedCollectionLinks) {
			if(this.getElementInnerText(item).equalsIgnoreCase(submenuHeading)) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				this.getReusableActionsInstance().clickIfAvailable(item);
				return;
			}
		}			
	}
	
	/**Method to click on WebElement for CuratedCollections SubMenu Item by providing Flyout heading name ,CuratedCollections SubMenu Item name as parameters.
	 * @param-String headingName: flyout menu item name
	 * @param-int subMenuIndex: popular brand list index
	 * @author Wei.Li
	 */
	public void clickPopularBrandsMenuItem(String headingName,int subMenuIndex) {
		String xpathHeading =createXPath("//span[contains(.,'{0}')]" ,headingName);
		WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
		getReusableActionsInstance().scrollToElement(headingWebElement);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(listPopularBrandsLink.get(subMenuIndex));
		this.getReusableActionsInstance().clickIfAvailable(listPopularBrandsLink.get(subMenuIndex));				
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
		getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
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

	/**
	 * This method is to close mobile menu
	 *
	 * @return true/false
	 */
	public void closeMobileMenu() {
		getReusableActionsInstance().clickIfAvailable(this.btnMobileMenuCloseButton);
	}

	public void closeMobileSearchMenu() {
		getReusableActionsInstance().clickIfAvailable(this.btnMobileSearchMenuClose);
	}

	/*Method to get url after clicking flyout heading link
	 * @return String:href
	 * @author Shruti Desai
	 */
	public String getUrlAfterclickingFlyoutHeading(String headingName) {
		AtomicReference<String> pageTitle=new AtomicReference<>();
		String currentPageUrl = getDriver().getCurrentUrl();
		if(!(currentPageUrl.substring(0,currentPageUrl.length()-1)).equalsIgnoreCase(getBaseURL()))
			pageTitle.getAndSet(lblPageTitleForMenuItems.getText());
		String currentUrl;
		String xpathHeading =createXPath("//span[contains(.,'{0}')]" ,headingName);
		WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
		getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
		getReusableActionsInstance().scrollToElement(headingWebElement);
		getReusableActionsInstance().clickIfAvailable(headingWebElement);
		//(new GlobalFooterPage(this.getDriver())).waitForPageLoading();
		waitForCondition(Driver->{return (this.lblPageTitleForMenuItems.getText()!=pageTitle.get());},90000);
		currentUrl = getDriver().getCurrentUrl();
		return currentUrl;
	}

	/*Method to apply static wait
	 * @author Shruti Desai
	 */
	public void staticwait() {
		applyStaticWait(2000);
	}

	/*Method to get WebElement for flyout heading
	 * @return WebElement
	 * @author Shruti Desai
	 */
	public WebElement getWebElementFlyoutHeading(String headingName) {
		String xpathHeading =createXPath("//span[contains(.,'{0}')]" ,headingName);
		WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
		return headingWebElement;
	}

	/* Method for scroll to Flyout heading WebElement
	 * @author Shruti Desai
	 */
	public void scrollToHeadingElement(String headingName) {
		WebElement headingWebElement =getWebElementFlyoutHeading(headingName);
		getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
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
		WebElement linkPopularBrand = listPopularBrandsLink.get(0);

		//waitForCondition(Driver->{return (linkPopularBrand.isDisplayed());} ,30000);

		waitForCondition(Driver->{return (linkPopularBrand.getAttribute("href").contains(first_flyout_menu_text.get()) && linkPopularBrand.getAttribute("class").contains(section.split(" ")[0].trim().toLowerCase()));} ,30000);
		WebElement ShopAllWebElement = getWebElementShopAllPupularBrand();
		if(verifyElementProperty(ShopAllWebElement,"Link")) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(ShopAllWebElement);
			getReusableActionsInstance().scrollToElement(ShopAllWebElement);
			ShopAllWebElement.click();
			(new GlobalFooterPage(this.getDriver())).waitForPageLoading();
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
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblPageTitleForMenuItems);
		getReusableActionsInstance().scrollToElement(this.lblPageTitleForMenuItems);
		String title = getPageTitle(this.lblPageTitleForMenuItems).toUpperCase();
		reporter.reportLog("Title of page is: "+title);
		waitForCondition(Driver->{return (title.toLowerCase().contains(pageName.toLowerCase()));} ,60000);
		return (title);
	}

	
	/*Method to verify href/src is empty or not before clicking sub menu link
	 * @return true/false
	 * @author Shruti Desai
	 */
	public void verifysubMenuhref(List<WebElement> webElements) {
		if(isParentElementHasAttribute(webElements,"li")) {
			for (WebElement element : this.subMenuLinks) {
				if (!verifyElementProperty(element, "Link")) {//href is not present
					getReporter().softAssert(false,"","Link is not present for: "+element.getText());
				}else{
					getReporter().reportLog("Href present for left side menu item: "+element.getText());
				}
			}
		}else{
			getReporter().reportLog("No sub-menu item present");
		}
	}

	public Boolean isParentElementHasAttribute(List<WebElement> parent, String attribute) {
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		ArrayList<Integer> childSize= (ArrayList<Integer>) jse.executeScript("return arguments[0].getElementsByTagName(arguments[1]);", parent.get(0),attribute);
		if(childSize.size()>0) return true;
		return false;
	}
		
	/*Method to verify href/src is empty or not before clicking Popular Brand/Curated Collection link
	 * @return true/false
	 * @author Shruti Desai
	 */
	public void verifyFlyoutMenuItems(String heading, String section){
		List<WebElement> headingsElements=this.headingLinks;
		if(heading==null) {
			for(WebElement headerItem: headingsElements) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(headerItem);
				this.scrolltoWebElement(headerItem);
				getReusableActionsInstance().staticWait(3000);
				waitForCondition(Driver->{return (CategoriesLinks.get(0).getAttribute("href").contains(headerItem.getText().split(" ")[0]));} ,30000);
				String headingName =headerItem.getText();
				reporter.reportLog("Flyout heading "+headingName);
				if(section==null) {
					verifyFlyoutMenuSection(headingName,"Left Section");
					verifyFlyoutMenuSection(headingName,"Curated Collections");
					verifyFlyoutMenuSection(headingName,"Popular Brands");
				}else{
					verifyFlyoutMenuSection(headingName,section);
				}
			}
		}else{
			WebElement headingsElement=getWebElementFlyoutHeading(heading);
			getReusableActionsInstance().javascriptScrollByVisibleElement(headingsElement);
			this.scrolltoWebElement(headingsElement);
			getReusableActionsInstance().staticWait(3000);
			waitForCondition(Driver->{return (CategoriesLinks.get(0).getAttribute("href").contains(headingsElement.getText().split(" ")[0]));} ,30000);
			String headingName =headingsElement.getText();
			reporter.reportLog("Flyout heading "+headingName);
			if(section==null) {
				verifyFlyoutMenuSection(headingName,"Left Section");
				verifyFlyoutMenuSection(headingName,"Curated Collections");
				verifyFlyoutMenuSection(headingName,"Popular Brands");
			}else{
				verifyFlyoutMenuSection(headingName,section);
			}
		}
	}

	public void verifyFlyoutMenuSection(String headingName,String sectionName){
		switch(sectionName){
			case "Curated Collections":
				reporter.reportLog("Verifying Curated Collections items for : "+headingName);
				for(WebElement webElement:listCuratedCollectionLinks){
					getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
					getReusableActionsInstance().scrollToElement(webElement);
					if(!verifyElementProperty(webElement,"Link")) {//href is not present
						getReporter().softAssert(false,"","Href missing for Curated Collection item: "+webElement.getText());
					}else{
						getReporter().reportLog("Href present for Curated Collection item: "+webElement.getText());
					}
				}
			break;
			case "Popular Brands":
				reporter.reportLog("Verifying Popular Brands items for : "+headingName);
				for(WebElement webElement:listPopularBrandsLink){
					getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
					getReusableActionsInstance().scrollToElement(webElement);
					WebElement altAttribute =webElement.findElement(By.xpath(".//img"));
					if(!verifyElementProperty(webElement,"Link")) {//href not present
						getReporter().softAssert(false,"","Href missing for Popular Brand item: "+webElement.getText());
					}
					if(!verifyElementProperty(altAttribute,"Image")) {//img not present
						getReporter().softAssert(false,"","Image missing for Popular Brand item: "+altAttribute.getText());
					}else{
						getReporter().reportLog("Image present for Popular Brand item: "+altAttribute.getAttribute("alt"));
					}
				}
			break;
			case "Left Section":
				for (WebElement category:CategoriesLinks) {
					getReusableActionsInstance().javascriptScrollByVisibleElement(category);
					this.scrolltoWebElement(category);
					getReusableActionsInstance().staticWait(3000);
					reporter.reportLog("Verifying Left Section for: "+category.getText());
					this.verifysubMenuhref(subMenuSection);
				}
			break;
		}
	}

	/**Method to get get heading of Sign In page after clicking the Favourites's link for anonymous user
	 * @return String:page heading
	 * @author Shruti Desai
	 */
	public String getPageHeadingSignin() {

		return getPageTitle(SigninPageHeading);
	}



}

