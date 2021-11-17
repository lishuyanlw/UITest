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

public class GlobalHeaderPage extends BasePage{

	public GlobalHeaderPage(WebDriver driver) { super(driver);	}

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

	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Trending')][contains(@class,'ac__section__title search-title')]/following-sibling::ul")
	public WebElement cntTrendingListWithoutKeyword;

	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Trending')][contains(@class,'ac__section__title search-title')]/following-sibling::ul//li//a")
	public List<WebElement> lstTrendingLinkWithoutKeyword;

	//Featured brands without keyword
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Featured brands')][contains(@class,'ac__section__title search-title')]")
	public WebElement lblFeaturedBrandsWithoutKeyword;

	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--left')]//*[contains(normalize-space(.),'Featured brands')][contains(@class,'ac__section__title search-title')]/following-sibling::ul")
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

	@FindBy(xpath = "//div[contains(@class,'signin-wrapper clearfix')]//h1//span[contains(text(),'Sign In')]")
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

	@FindBy(xpath = "//ul[contains(@class,'primary-navigation__wrapper')]//li//a")
	WebElement FlyoutHeadings;

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


	@FindBy(xpath = "//h2[contains(@class,'titleLink')]//b")
	WebElement shopAllBrandsLandigPageHeading;

	@FindBy(xpath="//span[contains(text(),'Clearance')]")
	WebElement clearanceHeader;

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

	//Search box visible
	public String validateSearchbox() {
		getReusableActionsInstance().isElementVisible(searchBox, 5);
		return searchBox.getAttribute("placeholder");
	}

	public boolean validateSearchSubmitbtn() {
		return getReusableActionsInstance().isElementVisible(btnSearchSubmit, 5);
	}


	/*
	public String validateFavouritesLink_1(WebElement webElement) {
		String emptySTAIbtn=webElement.getText();
		if(!verifyElementProperty(webElement,"Link")) {
			return emptySTAIbtn+" link href is empty";
		}else{
			getReusableActionsInstance().isElementVisible(webElement, 5);
			return emptySTAIbtn;
			}
		}
	*/
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
		return waitForCondition(Driver->{return this.lblTrendingWithoutKeyword.isDisplayed();},5000);
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
			getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			getReusableActionsInstance().scrollToElement(element);
			getReusableActionsInstance().staticWait(300);
			lsItem=element.getText();
			if (System.getProperty("Device").equalsIgnoreCase("Desktop")){
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

		String xpathHeading =createXPath("//span[contains(text(),'{0}')]" ,headingName);
		WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
		getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
		getReusableActionsInstance().scrollToElement(headingWebElement);

		if(headingWebElement!=null && submenuHeading==null) {
			headingWebElement.click();
			return headingWebElement.getText().trim();
		}
		if(submenuHeading!=null) {
			String xpathSubMenu =createXPath("//a[contains(text(),\"{0}\")]" ,submenuHeading);
			List<WebElement> SubMenu = Categories.findElements(By.xpath(xpathSubMenu));
			if(SubMenu.size()>0){
				getReusableActionsInstance().javascriptScrollByVisibleElement(SubMenu.get(0));
				getReusableActionsInstance().scrollToElement(SubMenu.get(0));
				if(itemName!=null) {
					String xpathSubmenuItem=createXPath("//a[contains(text(),'{0}')]",itemName);
					WebElement SubMenuItem=getDriver().findElement(By.xpath(xpathSubmenuItem));
					getReusableActionsInstance().javascriptScrollByVisibleElement(SubMenuItem);
					getReusableActionsInstance().scrollToElement(SubMenuItem);
					String title = SubMenuItem.getText().trim();
					SubMenuItem.click();
					return title;
				}else {
					String title = SubMenu.get(0).getText().trim();
					SubMenu.get(0).click();
					return title;
				}
				//Adding else condition to click on first element by default if passed submenu item is not present in list
			}else{
				WebElement element = Categories.findElement(By.xpath("./a"));
				String title = element.getText().trim();
				element.click();
				return title;
			}
		}
		return null;
	}

	public StringBuilder href_src_submenu  =new StringBuilder();
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

	/*Method to get url after clicking flyout heading link
	 * @return String:href
	 * @author Shruti Desai
	 */
	public String getUrlAfterclickingFlyoutHeading(String headingName) {
		String currentUrl;
		String xpathHeading =createXPath("//span[contains(text(),'{0}')]" ,headingName);
		WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
		getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
		getReusableActionsInstance().scrollToElement(headingWebElement);
		headingWebElement .click();
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
		String xpathHeading =createXPath("//span[contains(text(),'{0}')]" ,headingName);
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
		WebElement linkPopularBrand = listPopularBrandsLinks.get(0);
		waitForCondition(Driver->{return (linkPopularBrand.getAttribute("href").contains(first_flyout_menu_text.get()) && linkPopularBrand.getAttribute("class").contains(section.split(" ")[0].trim().toLowerCase()));} ,30000);
		WebElement ShopAllWebElement = getWebElementShopAllPupularBrand();
		if(verifyElementProperty(ShopAllWebElement,"Link")) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(ShopAllWebElement);
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
	public void verifysubMenuhref(List<WebElement> webElements) {
		if(isParentElementHasAttribute(webElements,"li")) {
			for (WebElement element : this.subMenuLinks) {
				/** Below section needs to be commented as it navigates back to previous element of left
				 * side section element and hence results in StaleElement Exception for firefox
				 if (System.getProperty("Browser").toLowerCase().contains("firefox")) {
				 getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				 }*/
				if (System.getProperty("Browser").toLowerCase().contains("chrome")) {
					getReusableActionsInstance().scrollToElement(element);
				}
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
				if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
					getReusableActionsInstance().javascriptScrollByVisibleElement(headerItem);
				}
				this.scrolltoWebElement(headerItem);
				this.staticwait();
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
			if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(headingsElement);
			}
			this.scrolltoWebElement(headingsElement);
			this.staticwait();
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
					if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
						getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
					}
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
				for(WebElement webElement:listPopularBrandsLinks){
					if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
						getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
					}
					getReusableActionsInstance().scrollToElement(webElement);
					WebElement hrefAttribute =webElement.findElement(By.xpath("./ancestor::a"));
					if(!verifyElementProperty(hrefAttribute,"Link")) {//href not present
						getReporter().softAssert(false,"","Href missing for Popular Brand item: "+webElement.getText());
					}
					if(!verifyElementProperty(webElement,"Image")) {//href not present
						getReporter().softAssert(false,"","Image missing for Popular Brand item: "+webElement.getText());
					}else{
						getReporter().reportLog("Image present for Popular Brand item: "+webElement.getAttribute("alt"));
					}
				}
				break;
			case "Left Section":
				for (WebElement category:CategoriesLinks) {
					if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
						getReusableActionsInstance().javascriptScrollByVisibleElement(category);
					}
					this.scrolltoWebElement(category);
					this.staticwait();
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

