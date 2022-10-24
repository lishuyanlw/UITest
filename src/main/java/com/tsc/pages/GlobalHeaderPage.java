package com.tsc.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

	@FindBy(xpath = "//div[contains(@class,'black-header')]//ul[contains(@class,'watch-tsc-panel-content')]//a")
	public List<WebElement> lstWatchTSCDropDown;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//*[contains(@class,'black-header__promotion-text')]")
	public WebElement lblPromotionTextBlackHeader;
	
	@FindBy(xpath = "//div[contains(@class,'black-header')]//button[contains(@class,'black-header__watch-tsc')]")
	public WebElement btnWatchTSCBlackHeader;

	@FindBy(xpath = "//div[@class='black-header__promotion']/a[contains(@id,'Promotion')]")
	public WebElement lblShopNowLink;
	
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

	@FindBy(xpath = "//*[@class='Header']//a[contains(@href, 'favourites')]//span")
	public WebElement FavouriteslnkText;

	@FindBy(xpath = "//div[@class='clearfix']//div[contains(@class,'recently-viewed-wrapper tsc-forms')]//div[contains(@class,'offset')]/div//*/span")
	public WebElement lblFavoritePageTitle;
	
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
	@FindBy(xpath = "//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]/div")
	public WebElement ShoppingCartlnk;
 
	@FindBy(xpath ="//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]/span")
	public WebElement ShoppingCartIconcont;

	@FindBy(xpath = "//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]//*[@class='secondary-navigation__rhs-bag__item-icon']")
	public WebElement CartBagIcon;
	
	@FindBy(xpath = "//*[@class='Header']//a[contains(@class, 'secondary-navigation__rhs-bag')]//div[contains(@class,'secondary-navigation__rhs-bag__item')]//span[contains(@class,'secondary-navigation__rhs-bag__item-badge')]//span[not(contains(@class,'visually-hidden'))]")
	public WebElement CartBagCounter;

	//Flyout headings menu
	@FindBy(xpath = "//ul[contains(@class,'primary-navigation__wrapper')]")
	WebElement FlyoutHeadings;

	//Categories menu
	@FindBy(xpath = "//*[contains(@class,'mega-categories mega-column')]//ul")
	WebElement Categories;

	@FindBy(xpath = "//*[contains(@class,'primary-navigation__wrapper')]//li[@class='primary-navigation__item']")
	public List<WebElement> headingMenuItem;

	@FindBy(xpath = "//div[contains(@id,'mega-navigation')]/nav/ul/li[@class='mega-categories__item']")
	public List<WebElement> headingSubMenuItems;

	@FindBy(xpath = "//*[contains(@class,'primary-navigation__wrapper')]//a//span[contains(@class,'primary-navigation__link-text')]")
	public List<WebElement> headingLinks;
	
	@FindBy(xpath = "//*[contains(@class,'mega-categories mega-column')]//a[not(contains(.,'Shop all'))]")
	public List<WebElement> CategoriesLinks;
	
	//SubMenu
	@FindBy(xpath = "//*[contains(@class,'mega-sub-items mega-column')]//a")
	public List<WebElement> subMenuLinks;
	
	@FindBy(xpath = "//*[contains(@class,'mega-sub-items mega-column')]//ul")
	public List<WebElement> subMenuSection;

	@FindBy(xpath = "//*[contains(@class,'mega-categories mega-column')]//a[(contains(.,'Shop all'))]")
	public WebElement lblShopAllEachSubMenu;

	@FindBy(xpath = "//*[contains(@class,'mega-sub-items mega-column')]//a[contains(@class,'all')]")
	public WebElement lblShopAllSubMenuItems;
	
	//Curated collection
	@FindBy(xpath = "//a[contains(@class,'mega-curated__item-link')]")
	public List<WebElement> listCuratedCollectionLinks;

	@FindAll({
		@FindBy(xpath="//div[contains(@class,'Middle')]//brand/div[contains(@class,'brand')]//*[contains(@class,'titleLink')]"),
		@FindBy(xpath="//div[contains(@class,'Middle')]//div[@class='PageTitle']//div[contains(@id,'Title')]")
	})
	public WebElement lblPageTitleForMenuItems;

	@FindBy(xpath="//div[contains(@class,'Middle')]//div[@class='PageTitle']//div[contains(@id,'Title')]|//div[contains(@class,'Middle')]//brand/div[contains(@class,'brand')]//*[contains(@class,'titleLink')]/b")
	public WebElement lblPageTitleCategorySection;

	@FindBy(xpath="//div[@class='mega-wrapper']//nav[contains(@class,'mega-categories')]")
	public WebElement lstFirstLevelCategoryMenuList;

	@FindBy(xpath="//div[@class='mega-wrapper']//nav[contains(@class,'mega-categories')]//li/a[contains(@class,'item-all')]")
	public WebElement lnkShopAllForCatgory;

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

	@FindBy(xpath="//div[contains(@class,'searchContainer')]//button[contains(@class,'aa-ClearButton')]")
	public WebElement btnMobileSearchMenuClose;

	@FindBy(xpath="//div[@class='helpButton']//span[@id='helpButtonSpan']/span[@class='message']")
	public WebElement lblTSCChatBox;

	@FindBy(xpath="//form//div[contains(@class,'pgSearchBarWrapper')]/input")
	public WebElement lblProgramGuideSearchBox;

	@FindBy(xpath="//div[@class='swiper-wrapper']//div[contains(@class,'slide-active')]")
	public List<WebElement> lstProgramGuidePageItems;

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
		 return (new GlobalFooterPage(this.getDriver())).waitForPageLoading();
	 }

	/**
	 *Method to hover on WatchTSC in Black headers  
	 * @author Wei.Li
	 */
	public void hoverOnWatchTSC() {
		//Static wait is required in below function as system behaves differently
		//for safari and clicking one time and without waits doesn't work all time
		getReusableActionsInstance().waitForPageLoad();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnWatchTSCBlackHeader);
		getReusableActionsInstance().scrollToElement(this.btnWatchTSCBlackHeader);
		getReusableActionsInstance().staticWait(2000);
		//Clicking on button twice as test is not working for Safari using scrollToElement
		getReusableActionsInstance().clickIfAvailable(this.btnWatchTSCBlackHeader);
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().clickIfAvailable(this.btnWatchTSCBlackHeader);
		getReusableActionsInstance().staticWait(1000);
	}
	 
	/**
	 *Method to verify TS header and link in Black headers  	 
	 * @param-WebElement blackItem: the header in Black headers
	 * @param-WebElement silverItem: the header in Silver headers
	 * @param-boolean bCheckUrl: to decide if check Url after clicking the header in Black headers
	 * @author Wei.Li
	 */	
	 public void verifyTSHeaderAndLinkInBlackHeader(WebElement blackItem,WebElement silverItem,boolean bCheckUrl,String endURLString) {
	 	int loopSize = this.lstWatchTSCDropDown.size();
	 	for(int i=0;i<loopSize;i++){
			getReusableActionsInstance().waitForPageLoad();
			getReusableActionsInstance().javascriptScrollByVisibleElement(lstWatchTSCDropDown.get(i));
			/*if(!System.getProperty("Device").equalsIgnoreCase("Desktop")) {
				getReusableActionsInstance().clickIfAvailable(blackItem);
			}*/
			String title=lstWatchTSCDropDown.get(i).getText().trim();
			String lsTitle=getUTFEnabledData(title);
			reporter.softAssert(getReusableActionsInstance().isElementVisible(lstWatchTSCDropDown.get(i)), "The element of "+lsTitle+" in Black headers is visible","The element of "+lsTitle+" in Black headers is not visible");
			reporter.softAssert(!lsTitle.isEmpty(), lsTitle+" text in Black headers is not empty", lsTitle+" text in Black headers is empty");
			String lsHrefInBlackHeader=this.getElementHref(lstWatchTSCDropDown.get(i));
			reporter.softAssert(!lsHrefInBlackHeader.isEmpty(), "The href of "+lsTitle+" in Black headers is not empty", "The href of "+lsTitle+" in Black headers is empty");
			lsHrefInBlackHeader=this.removeLastSlashFromUrl(lsHrefInBlackHeader);

			this.waitForPageLoadingByUrlChange(lstWatchTSCDropDown.get(i));
			//lstWatchTSCDropDown.get(i).click();
			(new GlobalFooterPage(this.getDriver())).waitForPageLoading();
			//Using static wait here as there is no other unique element where we can use waitForCondition() function here
			getReusableActionsInstance().staticWait(5000);
			String lsUrlInSilverHeader=this.removeLastSlashFromUrl(this.URL());

			//BUG-19547 - [PR Defect] Adding the Why are we adding the "&fm=top_header" query string to the URL
			if(lsUrlInSilverHeader.endsWith(endURLString))
				reporter.reportLogPass("The URL for: "+lsTitle+" end with "+endURLString+" as expected");
			else
				reporter.reportLogFailWithScreenshot("The URL for: "+lsTitle+" end with "+endURLString+" as expected");

			if(bCheckUrl) {
				//Program Guide url is appending daily in url and is not needed
				if(lsUrlInSilverHeader.contains("programguide")) {
					//This page takes time to load irrespective of using waitForCondition and hence using static wait here
					waitForCondition(driver->{return (this.lstProgramGuidePageItems.size()>0 && this.lblProgramGuideSearchBox.isEnabled());},250000);
					reporter.softAssert(lsUrlInSilverHeader.replace("/daily", "").equalsIgnoreCase(lsHrefInBlackHeader), "The Url of " + lsUrlInSilverHeader + "  after clicking " + lsTitle + " in Black headers is equal to the href of " + lsHrefInBlackHeader, "The Url of " + lsUrlInSilverHeader + "  after clicking " + lsTitle + " in Black headers is not equal to the href of " + lsHrefInBlackHeader);
				}else
					reporter.softAssert(lsUrlInSilverHeader.equalsIgnoreCase(lsHrefInBlackHeader), "The Url of " + lsUrlInSilverHeader + "  after clicking " + lsTitle + " in Black headers is equal to the href of " + lsHrefInBlackHeader, "The Url of " + lsUrlInSilverHeader + "  after clicking " + lsTitle + " in Black headers is not equal to the href of " + lsHrefInBlackHeader);
			}

			if(silverItem!=null) {
				String lsStyle=silverItem.findElement(By.xpath(".//span")).getAttribute("style");
				reporter.softAssert(lsStyle.toLowerCase().contains("color:#fff;")||lsStyle.toLowerCase().contains("color: rgb(255, 255, 255);"), lsTitle+" in Silver headers is being selected", lsTitle+" in Silver headers is not being selected");
			}
			//this.clickOnTSCLogo();
			this.hoverOnWatchTSC();
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
		if(headingName!=null){
			WebElement searchResultTitle=(new ProductResultsPage(this.getDriver())).lblSearchResultTitle;
			String xpathHeading =createXPath(".//li//a//span[contains(@class,'navigation__link-text') and contains(.,'{0}')]" ,headingName);
			WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
			getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
			getReusableActionsInstance().scrollToElement(headingWebElement);
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

			if(headingWebElement!=null && submenuHeading==null) {
				headingWebElement.click();
				waitForCondition(Driver->{return searchResultTitle.isDisplayed();},90000);
				return headingWebElement.getText().trim();
			}
			if(submenuHeading!=null) {
				String xpathSubMenu =createXPath(".//li[contains(@class,'categories__item')]//a[contains(.,'{0}')]" ,submenuHeading);
				List<WebElement> SubMenu = Categories.findElements(By.xpath(xpathSubMenu));
				if(SubMenu.size()>0){
					getReusableActionsInstance().javascriptScrollByVisibleElement(SubMenu.get(0));
					getReusableActionsInstance().scrollToElement(SubMenu.get(0));
					this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
					if(itemName!=null) {
						String xpathSubmenuItem=createXPath(".//li[contains(@class,'sub-items')]//a[contains(.,'{0}')]",itemName);
						WebElement SubMenuItem=getDriver().findElement(By.xpath(xpathSubmenuItem));
						getReusableActionsInstance().javascriptScrollByVisibleElement(SubMenuItem);
						getReusableActionsInstance().scrollToElement(SubMenuItem);
						String title = SubMenuItem.getText().trim();
						SubMenuItem.click();
						waitForCondition(Driver->{return searchResultTitle.isDisplayed();},90000);
						return title;
					}else {
						String title = SubMenu.get(0).getText().trim();
						SubMenu.get(0).click();
						waitForCondition(Driver->{return searchResultTitle.isDisplayed();},90000);
						return title;
					}
					//Adding else condition to click on first element by default if passed submenu item is not present in list
				}else{
					WebElement element = Categories.findElement(By.xpath(".//a"));
					String title = element.getText().trim();
					element.click();
					waitForCondition(Driver->{return searchResultTitle.isDisplayed();},90000);
					return title;
				}
			}
		}else{
			int headingMenuItems = this.headingMenuItem.size();
			if(headingMenuItems>0){
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.headingMenuItem.get(0));
				getReusableActionsInstance().scrollToElement(this.headingMenuItem.get(0));
				if(this.waitForCondition(Driver->{return this.headingSubMenuItems.size()>0;},8000)){
					reporter.reportLogPass("Sub Menu Item after clicking on header menu is displayed as expected");
					return this.headingMenuItem.get(0).getText();
				}
				else{
					reporter.reportLogFailWithScreenshot("Sub Menu Item after clicking on header menu is not displayed as expected");
					return null;
				}
			}else{
				reporter.reportLogFailWithScreenshot("Home Page Header Flyout menu items are not displayed on page");
				return null;
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
		String xpathHeading =createXPath(".//li//a//span[contains(@class,'navigation__link-text') and contains(.,'{0}')]" ,headingName);
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
		String xpathHeading =createXPath(".//li//a//span[contains(.,'{0}')]" ,headingName);
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
		List<WebElement> headingElements =FlyoutHeadings.findElements(By.xpath(".//li//a//span[contains(@class,'primary-navigation__link-text')]"));
		return headingElements;
	}

	/*Method to validate Flyout heading Href
	 * @author Shruti Desai
	 */
	public void validateFlyout() {
		if(System.getProperty("Device").equalsIgnoreCase("Desktop")){
			List<WebElement> headingsElement=this.getFlyoutHeadingsWebelement();
			for(WebElement lsHeading:headingsElement) {
				this.scrolltoWebElement(lsHeading);
				String flyoutHeading =lsHeading.getText();
				reporter.softAssert(this.verifyhrefFlyoutHeading(lsHeading), "Href is present for Flyout Heading "+flyoutHeading, "Href is not preset for "+flyoutHeading);
			}
		}
	}

	/*Method to scroll to desired WebElement
	 * @author Shruti Desai
	 */
	public void scrolltoWebElement(WebElement webElement) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
		getReusableActionsInstance().scrollToElement(webElement);
		waitForCondition(Driver->{return this.lstFirstLevelCategoryMenuList.isDisplayed();},5000);
	}

	public void scrollSubMenuItems(WebElement webElement) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
		getReusableActionsInstance().scrollToElement(webElement);
	}

	public void switchToEnglish(Map<String,List<String>> headerMap) {
		//switch back to english
		new GlobalFooterPage(this.getDriver()).switchlanguage();
		List<WebElement> flyoutHeadingsElement=this.getFlyoutHeadingsWebelement();
		if(System.getProperty("Device").equalsIgnoreCase("Desktop"))
			this.scrolltoWebElement(flyoutHeadingsElement.get(1));
		else
			this.scrollSubMenuItems(flyoutHeadingsElement.get(1));
		String englishNameFlyoutHeading=flyoutHeadingsElement.get(1).getText();
		reporter.softAssert((headerMap.get(englishNameFlyoutHeading).contains(englishNameFlyoutHeading)), "Language is switch back to English.", "Language is not switch back to English.");
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

	public void closeMobileMenu() {}

	public void closeMobileSearchMenu() {
		getReusableActionsInstance().clickIfAvailable(this.btnMobileSearchMenuClose);
	}

	/*Method to get url after clicking flyout heading link
	 * @return String:href
	 * @author Shruti Desai
	 */
	public String getUrlAfterClickingShopAllForCategory(String headingName) {
		String currentUrl;
		String xpathHeading =createXPath(".//li//a//span[contains(.,'{0}')]" ,headingName);
		WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
		getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
		getReusableActionsInstance().scrollToElement(headingWebElement);
		waitForCondition(Driver->{return this.lstFirstLevelCategoryMenuList.isDisplayed();},5000);
		this.waitForPageLoadingByUrlChange(this.lnkShopAllForCatgory);
		//getReusableActionsInstance().clickIfAvailable(this.lnkShopAllForCatgory);
		//waitForCondition(Driver->{return (this.lblTSCChatBox.isDisplayed() && this.lblTSCChatBox.getText().contains("Chat"));},120000);
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
		String xpathHeading =createXPath(".//li//a//span[contains(.,'{0}')]" ,headingName);
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
		waitForCondition(Driver->{return this.lstFirstLevelCategoryMenuList.isDisplayed();},5000);
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

		waitForCondition(Driver->{return (linkPopularBrand.getAttribute("href").contains(first_flyout_menu_text.get()) && linkPopularBrand.getAttribute("class").contains(section.split(" ")[0].trim().toLowerCase()));} ,30000);
		WebElement ShopAllWebElement = getWebElementShopAllPupularBrand();
		if(verifyElementProperty(ShopAllWebElement,"Link")) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(ShopAllWebElement);
			getReusableActionsInstance().scrollToElement(ShopAllWebElement);
			getReusableActionsInstance().clickIfAvailable(ShopAllWebElement);
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
	public String getHeadingForLandingPage() {
		this.waitForPageLoad();
		waitForCondition(Driver->{return (this.lblPageTitleCategorySection.isDisplayed());},60000);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblPageTitleCategorySection);
		//this static wait is necessary because even after applying wait above, page refreshes for mobile
		this.getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().scrollToElement(this.lblPageTitleCategorySection);
		String title = this.getElementInnerText(this.lblPageTitleCategorySection);
		reporter.reportLog("Title of page is: "+title);
		waitForCondition(Driver->{return !title.isEmpty();},60000);
		return title;
	}

	
	/*Method to verify href/src is empty or not before clicking sub menu link
	 * @return true/false
	 * @author Shruti Desai
	 */
	public void verifysubMenuhref(List<WebElement> webElements) {
		//if(isParentElementHasAttribute(webElements,"li")) {
		reporter.reportLog("Total Items present in sub menu are: "+this.subMenuLinks.size());
		for (WebElement element : this.subMenuLinks) {
			if (!verifyElementProperty(element, "Link")) {//href is not present
				getReporter().softAssert(false,"","Link is not present for: "+element.getText());
			}else{
				getReporter().reportLogPass("Href present for left side menu item: "+element.getText());
			}
		}
		//}else{
		//	getReporter().reportLog("No sub-menu item present");
		//}
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
						getReporter().reportLogPass("Href present for Curated Collection item: "+webElement.getText());
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
						getReporter().reportLogPass("Image present for Popular Brand item: "+altAttribute.getAttribute("alt"));
					}
				}
			break;
			case "Left Section":
				//Verifying ShopAll section in left menu
				String previousSubMenuName = "InValidValue";
				String nextSubMenuName = null;
				int counter = 0;
				if (!verifyElementProperty(this.lblShopAllEachSubMenu, "Link")) {//href is not present
					getReporter().softAssert(false,"","Shop All Link is not present for: "+this.lblShopAllEachSubMenu.getText());
				}else{
					getReporter().reportLogPass("Shop All Href present for left side menu item: "+this.lblShopAllEachSubMenu.getText());
				}

				for (WebElement category:CategoriesLinks) {
					nextSubMenuName = category.getText();
					getReusableActionsInstance().javascriptScrollByVisibleElement(category);
					this.scrollSubMenuItems(category);
					reporter.reportLog("Verifying Left Section for: "+category.getText());
					previousSubMenuName = (previousSubMenuName!= "InValidValue" && nextSubMenuName.equalsIgnoreCase(previousSubMenuName)) ? "Invalid" : previousSubMenuName;
					String finalNextSubMenuName = nextSubMenuName;
					String finalPreviousSubMenuName = previousSubMenuName;
					waitForCondition(Driver->{return (!finalNextSubMenuName.equalsIgnoreCase(finalPreviousSubMenuName));},10000);
					//Sub Menu Items are taking time to load and hence adding wait For Condition for that
					waitForCondition(Driver->{return (this.lblShopAllSubMenuItems.getText().contains(finalNextSubMenuName));},10000);
					this.verifysubMenuhref(subMenuSection);
					previousSubMenuName = category.getText();
					counter++;
				}
			break;
		}
	}

	/**Method to get heading of Sign In page after clicking the Favourites's link for anonymous user
	 * @return String:page heading
	 * @author Shruti Desai
	 */
	public String getPageHeadingSignin() {
		return getPageTitle(SigninPageHeading);
	}

	public boolean verifyFavoritePageTitle(String actualTitle){
		String pageTitle = this.getPageTitle(this.lblFavoritePageTitle);
		if(pageTitle.toLowerCase().contains(actualTitle.toLowerCase()))
			return true;
		return false;
	}

	public void verifyWatchTSCAtPageBottom(){}

	public int getShoppingCartBagCounter(){
		return this.getIntegerFromString(this.getElementInnerText(CartBagCounter));
	}

	/**
	 * This function verifies Global Header Links on Page
	 */
	public void verifyHeaderItemsOnPage(){
		this.waitForPageToLoad();
		this.scrollWindowUp(this.getDriver(),10000);
		this.waitForCondition(Driver->{return this.lnkTSBlackHeader.isEnabled();},8000);
		//Verifying ShowStopper
		this.verifyElementLink(this.lnkTSBlackHeader);
		//Verifying Shop Now
		this.verifyElementLink(this.lblShopNowLink);
		//Verifying Watch TSC Menu Links
		this.verifyWatchTSCMenuItemLinks();
		//Verifying clicking on one menu item
		this.getNameAndclickSubMenuItem(null,null,null);
	}

	/**
	 * This function verifies Watch TSC Menu Item in Global Header
	 */
	public void verifyWatchTSCMenuItemLinks(){
		this.hoverOnWatchTSC();
		int loopSize = this.lstWatchTSCDropDown.size();
		for(int counter=0;counter<loopSize;counter++){
			String title=lstWatchTSCDropDown.get(counter).getText().trim();
			String lsTitle=getUTFEnabledData(title);
			String lsHrefInBlackHeader=this.getElementHref(lstWatchTSCDropDown.get(counter));
			if(this.verifyLink(lsHrefInBlackHeader))
				reporter.reportLogPass("Url for link: "+title+" is not broken as expected");
			else
				reporter.reportLogFail("Url for link: "+title+" is broken: "+lsHrefInBlackHeader);
			if(!lsTitle.isEmpty() && !lsHrefInBlackHeader.isEmpty())
				reporter.reportLogPass("Watch TSC link for: "+lsTitle+" is present and not empty");
			else
				reporter.reportLogFailWithScreenshot("Watch TSC link for: "+lsTitle+" is not present and is empty");
		}
	}
}

