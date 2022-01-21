package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;

import com.tsc.api.apiBuilder.ApiResponse;
import com.tsc.api.pojo.Product;
import com.tsc.api.pojo.SelectedProduct;
import com.tsc.pages.base.BasePage;

public class ProductResultsPage extends BasePage{
	public ProductResultsPage(WebDriver driver) {
		super(driver);
	}

	//Search results return message
	@FindBy(xpath = "//section[@class='tsc-container']//*[@class='plp__showing-results']|//section[@class='tsc-container']//div[@class='plp-no-search-results__copy__heading']")
	public WebElement lblSearchResultMessage;

	@FindBy(xpath = "//section[@class='tsc-container']//*[@class='plp__showing-results']")
	public WebElement lblReturnMessageWithSearchResult;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-no-search-results__copy__heading']")
	public WebElement lblReturnMessageHeadingWithoutSearchResult;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-no-search-results__icon']")
	public WebElement lblReturnMessageIconWithoutSearchResult;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-no-search-results__copy__text']")
	public WebElement lblReturnMessageTextWithoutSearchResult;

	@FindBy(xpath = "//section[@class='tsc-container']//button[@class='plp-no-search-results__copy__link']")
	public WebElement btnReturnMessageRetryLinkWithoutSearchResult;

	//Search title
	@FindBy(xpath = "//span[contains(@class,'tagDimTitle')]")
	public WebElement lblSearchResultTitle;

	//Navigation list
	@FindBy(xpath = "//section[@class='tsc-container']//nav[@class='breadcrumb__nav']//li")
	public List<WebElement> lstSearchResultNavigation;

	@FindBy(xpath = "//div[@class='Middle']")
	public WebElement cntSearchResultTitleContainer;

	@FindBy(xpath = "//div[contains(@class,'showstopper-wrapper')]//div[contains(@class,'item')]//div[contains(@class,'visible')]//img")
	public List<WebElement> lstBannerImage;

	//Product message showing
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination-desc']//span[@class='plp__pagination-desc__display-text']")
	public WebElement lblShowing;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination-desc']//span[@class='plp__pagination-desc__product-count-text']")
	public WebElement txtShowingDynamicContent;

	//Sort part
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__count-and-shorting__product-count']")
	public WebElement lblProductCountMessage;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__count-and-shorting']//select[@class='plp__count-and-shorting__shorting']")
	public WebElement btnSortSelect;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__count-and-shorting']//select[@class='plp__count-and-shorting__shorting']//option")
	public List<WebElement> sortByOptionList;

	//For Sorting and Filtering page loading indicator
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp']")
	public WebElement cntSortingAndFilteringProductResultLoadingIndicator;

	@FindBy(xpath = "//section[@class='tsc-container'][not(nav)][not(*[@class='breadcrumb'])]")
	public WebElement cntTSCContainer;


	/*@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]")
	List<WebElement> productResultList;*/
	//@FindBy(xpath = "//div[@class='plp']//div[@class='plp__product-grid']//div[contains(@class,'plp-card-grid-item')]//div[@class='product-card']")
	//List<WebElement> productResultList;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp']//div[@class='plp__wrapper']")
	public WebElement cntProductResultListContainer;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp']//div[@class='plp__product-grid']//div[contains(@class,'plp-card-grid-item')]//div[@class='product-card']")
	public List<WebElement> productResultList;

	public By byProductSizeAndColour=By.xpath(".//div[contains(@class,'product-card__option-button')]/ul");
	//Selected filters
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__applied-filters']//button")
	public List<WebElement> selectedFiltersList;

	public By byProductHeaderTitleContainer=By.xpath(".//*[@class='product-card__header']");

	public By byProductHeaderTitle=By.xpath(".//*[@class='product-card__header-title']");

	public By byProductHeaderLike=By.xpath(".//*[@class='product-card__header-like']");

	public By byProductHref=By.xpath(".//a[@data-lpos='product card image']");

	public By byProductImage=By.xpath(".//a[@data-lpos='product card image']//img");

	public By byProductOptionListContainer=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__option-button']");

	public By byProductOptionList=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__option-button']//ul//li");

	//After mouse hover
	public By byProductOptionFieldsetContainer=By.xpath(".//form");

	//For size and color
	public By byProductOptionFieldsetList=By.xpath(".//fieldset");
	public By byProductOptionTitle=By.xpath(".//fieldset//*[contains(@class,'product-card__') and contains(@class,'-title')]");

	//For size option
	public By byProductOptionSizeTitle=By.xpath(".//fieldset//span[@class='product-card__size-title']");

	public By byProductOptionSizeSelectedSize=By.xpath(".//fieldset//span[@class='product-card__size-title']//strong");

	public By byProductOptionSizeWrapper=By.xpath(".//fieldset//div[@class='product-card__size-wrapper']");

	public By byProductOptionSizeItemList=By.xpath(".//fieldset//div[contains(@class,'product-card__size-items')]//button|.//fieldset//select[@class='product-card__size__dropdown']//option");

	public By byProductOptionSizeItemEnabledList=By.xpath(".//fieldset//div[contains(@class,'product-card__size-items')]//button[not(@disabled)]|.//fieldset//select[@class='product-card__size__dropdown']//option[not(@disabled)]");

	public By byProductOptionSizeItemDisabledList=By.xpath(".//fieldset//div[contains(@class,'product-card__size-items')]//button[@disabled]|.//fieldset//select[@class='product-card__size__dropdown']//option[@disabled]");

	public By byProductOptionSizeSelectedItem=By.xpath(".//fieldset//div[contains(@class,'product-card__size-items')]//button[@aria-pressed='true']|.//fieldset//select[@class='product-card__size__dropdown']//option[@selected]");

	public By byProductOptionSizeViewAllSizes=By.xpath(".//fieldset//a[@class='product-card__size-view-all']");

	//For color option
	public By byProductOptionColorTitle=By.xpath(".//fieldset//p[@class='product-card__color-and-taste-title']");

	public By byProductOptionColorSelectedColor=By.xpath(".//fieldset//p[@class='product-card__color-and-taste-title']//strong");

	public By byProductOptionColorWrapper=By.xpath(".//fieldset//div[@class='product-card__color-and-taste-wrapper']");

	public By byProductOptionColorItemList=By.xpath(".//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option");

	public By byProductOptionColorDropDown=By.xpath(".//fieldset//select[@class='product-card__color-and-taste__dropdown']");

	public By byProductOptionColorItemEnabledList=By.xpath(".//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[not(@disabled)]|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[not(@disabled)]");

	public By byProductOptionColorItemDisabledList=By.xpath(".//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@disabled]|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[@disabled]");

	public By byProductOptionColorSelectedItem=By.xpath(".//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@aria-pressed='true']|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[not(@selected)]");

	public By byProductOptionColorViewAllColors=By.xpath(".//fieldset//a[@class='product-card__color-view-all']");

	public By byProductName=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//a[@class='product-card__info-pname']");

	public By byProductBrand=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//p[@class='product-card__info-brand']");

	public By byProductNowPrice=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//div[@class='product-card__info-price']//a[@class='product-card__info-price__is-price']/span[1]");

	public By byProductWasPrice=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//div[@class='product-card__info-price']//a[@class='product-card__info-price__is-price']/span[@class='product-card__info-price__was-price']");

	public By byJudgeProductWasPrice=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//div[@class='product-card__info-price']//a[@class='product-card__info-price__is-price']");

	public By byProductReviewContainer=By.xpath(".//div[@class='product-card__reviews']");

	public By byProductReviewRatingImage=By.xpath(".//div[@class='product-card__reviews']//span[@class='product-card__rating']//span[contains(@class,'product-card__rating__star')]");

	public By byProductReviewRatingCount=By.xpath(".//div[@class='product-card__reviews']//a[@class='product-card__reviews-count']");

	public By byProductGoToDetails=By.xpath(".//button[@class='product-card__add-button']");

	//Pagination
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']")
	public WebElement cntPagination;

	public By byPagination=By.xpath("//section[@class='tsc-container']//div[@class='plp__pagination']");

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']//div[@class='plp__pagination__pages']//a")
	public List<WebElement> PageNumberList;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']")
	public WebElement cntPreAndNextButtonPage;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']//a[@class='plp__pagination__prev-link']")
	public WebElement btnPreviousPage;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']//a[@class='plp__pagination__next-link']")
	public WebElement btnNextPage;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']//div[@class='plp__pagination__pages']//a[contains(@class,'plp__pagination__pages__page--current')]")
	public WebElement btnCurrentPage;

	//Product title and text
	@FindBy(xpath = "//div[@class='TitleAndTextSeo']")
	public WebElement cntProductTitleAndText;

	public By byProductTitleAndText=By.xpath(".//div[@class='TitleAndTextSeo']");

	@FindBy(xpath = "//div[@class='TitleAndTextSeo']//*[contains(@class,'seoTextTitle')]")
	public WebElement lblProductTitle;

	@FindBy(xpath = "//div[@class='TitleAndTextSeo']//*[contains(@class,'seoTextContent')]")
	public WebElement lblProductText;

	//@FindBy(xpath = "//div[@id='readMoreButton']//button")
	@FindBy(xpath = "//div[contains(@class,'TitleAndText')]//button[@id='readMoreButton']")
	public WebElement btnProductTitleAndTextMoreOrLess;

	//Product results filter
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__blocks']")
	public List<WebElement> productFilterContainerList;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__blocks']//button[@class='plp-filter-panel__block-title']")
	public List<WebElement> productFilterList;

	public By byProductFilterSearchContainer=By.xpath("./div");

	public By byProductFilterSearchInput=By.xpath("./div/input[@class='plp-filter-panel__search']");

	public By byProductFilterTitle=By.xpath(".//button[@class='plp-filter-panel__block-title']");

	public By bySecondaryFilterOpenOrCloseFlag=By.xpath(".//button[@class='plp-filter-panel__block-title']//div[contains(@class,'plp-filter-panel__block-title__icon')]");

	public By bySecondaryFilterAll=By.xpath(".//ul[@class='plp-filter-panel__filter-list' or @class='plp-filter-panel__back-list' or @class='plp-filter-panel__sub-categories']//li");

	public By bySecondaryFilterUnChecked=By.xpath(".//ul[@class='plp-filter-panel__filter-list']//li[button[input[not(@checked)]]]");

	public By bySecondaryFilterChecked=By.xpath(".//ul[@class='plp-filter-panel__filter-list']//li[button[input[@checked]]]");

	public By bySecondaryFilterSeeButtonText=By.xpath(".//button[contains(@class,'plp-filter-panel__view-more')]//span");

	public By bySecondaryFilterSeeMoreButton=By.xpath(".//button[contains(@class,'plp-filter-panel__view-more')][span[normalize-space(.)='See More']]");

	public By bySecondaryFilterSeeLessButton=By.xpath(".//button[contains(@class,'plp-filter-panel__view-more')][span[normalize-space(.)='See Less']]");

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__blocks']//ul[@class='plp-filter-panel__filter-list']//li[button[input[not(@checked)]]]")
	public List<WebElement> secondlevelFilterList;

	@FindBy(xpath = "//div[contains(@class,'layout--left')]")
	public WebElement searchResultSection;

	@FindBy(xpath = "//product-recommendations-endeca")
	public WebElement recommendationContainer;

	@FindBy(xpath = "//div[@class='Header']")
	public WebElement headerContainer;

	@FindBy(xpath = "//div[@class='Footer']")
	public WebElement footerContainer;

	//People Also Viewed items
	@FindBy(xpath = "//product-recommendations-endeca//h2[@class='prec-header']")
	public WebElement productRecommendationTitle;

	@FindBy(xpath="//product-recommendations-endeca//*[contains(@class,'prec-col')]")
	public List<WebElement> lstPeopleAlsoBoughtItems;

	public By byRecommendationImage = By.xpath(".//div[contains(@class,'imgEmbedContainer')]//img[@class='img-responsive pprec-img']");

	public By byRecommendationName=By.xpath(".//div[contains(@class,'prec-name')]");

	public By byRecommendationPriceContainer=By.xpath(".//div[@class='prec-price']");

	public By byRecommendationNowPrice=By.xpath(".//div[@class='prec-price']/div[contains(@class,'now-price')]//span");

	public By byRecommendationWasPrice =By.xpath(".//div[@class='prec-price']/div[@class='was-price']");

	@FindBy(xpath="//div[contains(@class,'PageTitle')]//*[contains(@class,'gatewayTitle')]")
	public WebElement pageTitle;

	//for mobile Sort&Filter
	@FindBy(xpath = "//a[contains(text(),'Sort & Filter')]")
	WebElement sortAndFilter;

	@FindBy(xpath="//product-results//div[@class='modalBody']")
	WebElement sortPanel;

	//product detail
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divItemBadge']/img")
	public WebElement imgProductBadge;

	//possible item matches
	@FindBy(xpath = "//section[contains(@class,'ac__layout-wrap')]//div[contains(@class,'ac__layout--right')]//div[@class='ac__layout-inner--left']//ul//li//a[contains(@class,'ac-productlist')]")
	public WebElement lstPossibleItemMatchesLink;

	//product name
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']")
	public WebElement lblProductName;

	//The page while clicking Favorite button on header menu
	@FindBy(xpath = "//ng-component//div[contains(@class,'tsc-forms')]")
	public WebElement cntMyFavouritesContainer;

	@FindBy(xpath = "//ng-component//div[@class='recently-viewed-title']")
	public WebElement lblMyFavouritesTitle;

	//Favorite history available
	@FindBy(xpath = "//ng-component//button[contains(@class,'btn-clear-viewing-history')]")
	public WebElement btnClearAllFavouriteHistory;

	@FindBy(xpath = "//ng-component//div[@class='recently-viewed-container']//div[contains(@class,'recently-viewed-item-container')]//a")
	public List<WebElement> lstFavouriteProduct;

	//Favorite history not available
	@FindBy(xpath = "//ng-component//div[contains(@class,'no-history-container')]//div[contains(@class,'no-history-msg')]")
	public List<WebElement> lstNoHistoryMessage;

	@FindBy(xpath = "//ng-component//div[contains(@class,'no-history-container')]//div[contains(@class,'btn-shop-now')]")
	public WebElement btnShoppingNow;

	//The popup window after clicking ClearAllFavouriteHistory button
	@FindBy(xpath = "//ng-component//div[@class='modal-dialog']//div[@class='modal-header']//button[@class='close']")
	public WebElement btnCloseButtonInClearMyFavouritesPopupWindow;

	@FindBy(xpath = "//ng-component//div[@class='modal-dialog']//div[@class='modal-header']//div[@class='crv-title']")
	public WebElement lblTitleInClearMyFavouritesPopupWindow;

	@FindBy(xpath = "//ng-component//div[@class='modal-dialog']//div[@class='modal-body']//div[@class='crv-warning']")
	public WebElement lblWarningMessageInClearMyFavouritesPopupWindow;

	@FindBy(xpath = "//ng-component//div[@class='modal-dialog']//div[@class='crv-btn-block']//button[contains(@class,'btnResizing') and not(contains(@class,'btn-negative'))]")
	public WebElement btnClearInClearMyFavouritesPopupWindow;

	@FindBy(xpath = "//ng-component//div[@class='modal-dialog']//div[@class='crv-btn-block']//button[contains(@class,'btnResizing') and contains(@class,'btn-negative')]")
	public WebElement btnCancelInClearMyFavouritesPopupWindow;

	String searchkeyword;
	public boolean bVerifyTitle=true;
	public String firstLevelFilter,secondLevelFilter;
	public boolean bDefault=false;
	public String lsSearchResultMessage="";
	public ProductItem selectedProductItem= new ProductItem();


	/**
	 * This method will load search result popup after entering search keyword
	 * @return true/false
	 * @author Wei.Li
	 */
	public void getSearchResultPopUpWindowLoad(String searchKeyword) {
		GlobalHeaderPage globalHeader=new GlobalHeaderPage(this.getDriver());
		//this.getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeader.searchBox);
		//this.clearContent(globalHeader.searchBox);
		//char[] inputString = searchKeyword.toCharArray();
		waitForCondition(Driver->{
			return globalHeader.searchBox.isDisplayed();
		},90000);
		String[] data = searchKeyword.codePoints().mapToObj(cp->new String(Character.toChars(cp))).toArray(size->new String[size]);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeader.searchBox);
		this.getReusableActionsInstance().clickIfAvailable(globalHeader.searchBox,3000);
		for(String inputText:data){
			globalHeader.searchBox.sendKeys(inputText);
			this.getReusableActionsInstance().staticWait(1000);
		}
		//globalHeader.searchBox.sendKeys(searchKeyword);
		//globalHeader.btnSearchSubmit.click();
		this.getReusableActionsInstance().staticWait(3000);
		waitForCondition(Driver->{
			return this.searchResultSection.isDisplayed();
		},90000);
	}

	/**
	 * This method will load product searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean getSearchResultLoad(String searchKeyword,boolean clickEnterButtonFromKeyboard) {
		GlobalHeaderPage globalHeader=new GlobalHeaderPage(this.getDriver());
		this.getReusableActionsInstance().waitForElementVisibility(globalHeader.searchBox,120);
		String[] data = searchKeyword.codePoints().mapToObj(cp->new String(Character.toChars(cp))).toArray(size->new String[size]);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeader.searchBox);
		this.getReusableActionsInstance().clickIfAvailable(globalHeader.searchBox,3000);
		for(String inputText:data){
			globalHeader.searchBox.sendKeys(inputText);
			this.getReusableActionsInstance().staticWait(2000);
		}
		//globalHeader.searchBox.sendKeys(searchKeyword);
		//globalHeader.btnSearchSubmit.click();
		this.getReusableActionsInstance().staticWait(3000);
		waitForCondition(Driver->{
			return this.searchResultSection.isDisplayed();
		},150000);

		//Bug-19680 - Change the placeholder text in the brand section - Search Product using magnifying glass icon
		if(clickEnterButtonFromKeyboard)
			super.pressEnterKey(globalHeader.searchBox);
		else {
			globalHeader.validateSearchSubmitbtn();
			this.getReusableActionsInstance().clickIfAvailable(globalHeader.btnSearchSubmit);
		}

		this.getReusableActionsInstance().staticWait(5000);
		/*waitForCondition(Driver->{
			return this.lblShowing.isDisplayed();
		},90000);
		waitForCondition(Driver->{
			return getDriver().findElement(By.xpath("//section[@class='tsc-container']//h2")).isDisplayed();
		},90000);

		return waitForCondition(Driver->{
			String lsStyle=this.productResultLoadingIndicator.getAttribute("style");
			if(lsStyle==null||lsStyle.isEmpty()) {
				lsStyle="display: none;";
			}
			return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;")&&!lsUrl.equalsIgnoreCase(this.URL());
			},90000);*/
		this.waitForPageToLoad();
		this.getReusableActionsInstance().staticWait(2000);

		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,120);

		return true;
	}

	/**
	 * This method will get search results through dropdown menu.
	 * @param- String lsKeyword:input keyword
	 * @param- int optionIndex: selected index in dropdwon menu
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean selectSearchResultListInDropdownMenu(String lsKeyword,String lsOption,String lsOptionIndex) {
		int optionIndex=0;
		String lsUrl=this.URL();
		if(!lsOptionIndex.isEmpty()) {
			optionIndex=Integer.parseInt(lsOptionIndex);
		}
		GlobalHeaderPage globalHeader=new GlobalHeaderPage(this.getDriver());
		this.clearContent(globalHeader.searchBox);
		for(int i=0;i<lsKeyword.length();i++) {
			globalHeader.searchBox.sendKeys(lsKeyword.substring(i,i+1));
			getReusableActionsInstance().staticWait(300);
		}

		switch(lsOption) {
			case "Top suggestions":
				waitForCondition(Driver->{return globalHeader.searchQADropdwonmenuList.get(0).isDisplayed();},30000);
				WebElement element=globalHeader.searchQADropdwonmenuList.get(0).findElements(By.xpath(".//li")).get(optionIndex);
				getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				this.searchkeyword=element.getText().trim();
				this.bVerifyTitle=false;
				element.click();
				break;
			case "Categories":
				waitForCondition(Driver->{return globalHeader.searchQADropdwonmenuList.get(1).isDisplayed();},30000);
				element=globalHeader.searchQADropdwonmenuList.get(1).findElements(By.xpath(".//li")).get(optionIndex);
				getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				this.searchkeyword=element.getText().trim();
				this.bVerifyTitle=true;
				element.click();
				break;
			case "Brands":
				waitForCondition(Driver->{return globalHeader.searchQADropdwonmenuList.get(2).isDisplayed();},30000);
				List<WebElement> list=globalHeader.searchQADropdwonmenuList.get(2).findElements(By.xpath(".//li"));
				this.searchkeyword=lsKeyword;
				for(WebElement ele:list) {
					getReusableActionsInstance().javascriptScrollByVisibleElement(ele);
					if(ele.getText().trim().equalsIgnoreCase(lsKeyword)) {
						this.bVerifyTitle=true;
						ele.click();
						break;
					}
				}
				break;
		}

		this.waitForPageToLoad();
		this.getReusableActionsInstance().staticWait(2000);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,120);

		return true;
	}

	/**
	 * This method will verify page title for selecting from dropdown menu.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyPageTitleForDropdown() {
		if(!this.bVerifyTitle) {
			return true;
		}
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSearchResultTitle);
		String lsTitle=this.lblSearchResultTitle.getText().trim();

		if(this.searchkeyword.toLowerCase().contains(lsTitle.toLowerCase())) {
			return true;
		}

		String[] lstItem;
		if(this.searchkeyword.contains(">")) {
			lstItem=this.searchkeyword.trim().split(">");
		}
		else {
			lstItem=this.searchkeyword.trim().split(" ");
		}
		String lastWord=lstItem[lstItem.length-1].trim();

		return lastWord.equalsIgnoreCase(this.lblSearchResultTitle.getText().trim());
	}

	/**
	 * This method will verify Showing text pattern in filters.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyShowingTextPatternInFilters() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblShowing);
		String showingText=this.lblShowing.getText()+" "+this.txtShowingDynamicContent.getText();

		return showingText.matches("Displaying items: (\\d+) - (\\d+) out of (\\d+)");
	}

	/**
	 * This method will verify searching result message matches expected message.
	 * @return String: error message
	 * @author Wei.Li
	 */
	public String verifySearchResultMessage(String expectedMessage,String lsKeyword) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSearchResultMessage);

		String lsMessage=this.lblSearchResultMessage.getText().trim();
		this.lsSearchResultMessage=lsMessage;

		if(lsKeyword.isEmpty()) {
			if(!lsMessage.contains(expectedMessage)) {
				return "Search result message result of '"+lsMessage+"' does not contain expected message for no search results";
			}
		}
		else {
			if(!lsMessage.contains(expectedMessage)) {
				return "Search result message result of '"+lsMessage+"' does not contain expected message for returned search results";
			}

			if(!lsMessage.contains(lsKeyword)) {
				return "Search result message result of '"+lsMessage+"' does not contain keyword of "+lsKeyword;
			}
		}

		return "";
	}

//	/**
//	 * This method will verify the default setting of items per page.
//	 * @return true/false
//	 * @author Wei.Li
//	 */
//	public boolean verifySearchResultPageNumberDefaultSetting(String defaultSettingPageNumber) {
//		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblItemsPerPage);
//
//		return lblItemPerPageDefaultSettingNumber.getText().trim().equalsIgnoreCase(defaultSettingPageNumber);
//	}

	/**
	 * This method will verify the search results are not existing.
	 * @return void
	 * @author Wei.Li
	 */
	public void verifySearchResultNotExisting() {
		if(this.checkProductResultExisting()) {
			reporter.reportLogFail("The product results are existing");
		}
		else {
			reporter.reportLogPass("The product results are not existing");
		}
	}

	/**
	 * This method will return Product list on the current page.
	 * @author Wei.Li
	 */
	public List<WebElement> getProductList(){
		return productResultList;
	}

	/**
	 * This method will verify if Banner image src is search keyword related.
	 * @author Wei.Li
	 */
	public boolean verifyBannerImageContainSpecificWord(String lsSpecificWord) {
		if(lsSpecificWord.trim().contains(" ")) {
			String[] lsList=this.splitSearchKeyword(lsSpecificWord);
			for(WebElement element : this.lstBannerImage) {
				String lsSrc=element.getAttribute("src").toLowerCase();
				for(String item:lsList) {
					if(lsSrc.contains(item.toLowerCase())) {
						return true;
					}
				}
			}
		}
		else {
			for(WebElement element : this.lstBannerImage) {
				String lsSrc=element.getAttribute("src").toLowerCase();
				if(lsSrc.contains(lsSpecificWord.toLowerCase())) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * This method will return search result page title.
	 * @author Wei.Li
	 */
	public String getProductResultPageTitle() {
		if(this.checkChildElementExistingByAttribute(this.cntSearchResultTitleContainer, "class", "DimensionTitle2")) {
			WebElement dimensionTitle=this.cntSearchResultTitleContainer.findElement(By.xpath("./div[@class='DimensionTitle2']"));
			if(!dimensionTitle.getCssValue("height").equalsIgnoreCase("0px")) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSearchResultTitle);
				return this.lblSearchResultTitle.getText().trim();			}

		}
		return "NoTitle";
	}

	/**
	 * This method will return search result page title.
	 * @author godwin.gopi
	 */
	public String getProductResultPageTitle(WebElement element) {
		if(getReusableActionsInstance().isElementVisible(element)) {
			getReusableActionsInstance().waitForElementVisibility(element,120);
			getReusableActionsInstance().getElementText(element);
			return element.getText().trim();
		}
		return "NoTitle";
	}

	/**
	 * This method will judge test model for different scenarios.
	 * @return String: test model
	 * @author Wei.Li
	 */
	public String judgeTestModel() {
		if(!this.checkProductResultExisting()) {
			return "NoSearchResult";
		}

		String lsUrl=this.URL();
		if(!lsUrl.contains("dimensions=")) {
			return "BannerImageSearch";
		}

		if(!lsUrl.contains("dimensions=0&")) {
			return "BannerImageSearch";
		}

		int totalNumber=getProductSearchResultsTotalNumber();
		if(totalNumber==1){
			return "ProductNumberSearch";
		}
		else{
			return "NormalSearch";
		}
	}

	public int getProductSearchResultsTotalNumber() {
		return this.getIntegerFromString(this.getElementInnerText(this.lblProductCountMessage));
	}

	/**
	 * This method will get encoding keyword.
	 * @param- String lsKeyword: input keyword
	 * @return encoded keyword
	 * @author Wei.Li
	 */
	public String getEncodingKeyword(String lsKeyword) {
		if(!lsKeyword.trim().contains(" ")) {
			return lsKeyword.trim();
		}
		return lsKeyword.trim().replace(" ","%20");

	/*	String lsUrl=this.URL();
		if(lsUrl.contains("dimensions=0&")) {
			return lsKeyword.trim().replace(" ","%20");
		}
		else {
			return lsKeyword.trim().replace(" ","%2B");
		}*/
	}

	/**
	 * This method will verify Url after selecting filter in left panel.
	 * @param- String lsKeyword: search keyword
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyUrlContainDimensionAndKeyword(String lsKeyword) {
		String lsUrl=this.URL();
		getReporter().reportLog("Url for browser: "+this.getExecutionBrowserName()+ " is: "+lsUrl);
		if(lsUrl.toLowerCase().contains("dimensions=")) {
			return lsUrl.toLowerCase().contains("dimensions=")&&lsUrl.toLowerCase().contains("searchterm=")&&lsUrl.contains(this.getEncodingKeyword(lsKeyword));
		}
		else {
			return lsUrl.toLowerCase().contains("searchterm=")&&lsUrl.contains(this.getEncodingKeyword(lsKeyword));
		}
	}

	/**
	 * This method will get BannerImage list size.
	 * @return true/false
	 * @author Wei.Li
	 */
	public int getBannerImageListSize() {
		return this.lstBannerImage.size();
	}

	/**
	 * This method will verify Url after selecting sort strategy.
	 * @param- String lsKeyword: search keyword
	 * @param- String lsSortKey: sort key in dropdown menu
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyUrlAfterSelectSortStrategy(String lsKeyword,String lsSortKey) {
		String lsUrl=this.URL();
		return lsUrl.toLowerCase().contains("searchterm=")&&lsUrl.contains(this.getEncodingKeyword(lsKeyword))&&lsUrl.toLowerCase().contains("&sortkey="+lsSortKey.toLowerCase());
	}

	/**
	 * This method will get pagination.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean checkProductPagination() {
		return this.getDriver().findElements(this.byPagination).size()==1;
	}

	/**
	 * This method will verify Brand title/text contains keyword.
	 * @param- String lsSection: title/text
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductBrandTitleOrText(String lsSection) {
		boolean bReturn=true;
		switch(lsSection) {
			case "Title":
				bReturn=!this.getElementInnerText(this.lblProductTitle).isEmpty();
				break;
			case "Text":
				bReturn=!this.getElementInnerText(this.lblProductText).isEmpty();
				break;
		}
		return bReturn;
	}

	/**
	 * This method will verify More/Less button.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductBrandMoreOrLessButton() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductText);

		String[] lstText= new String[1];
		if(getReusableActionsInstance().isElementVisible(this.btnProductTitleAndTextMoreOrLess)) {
			lstText[0]=this.getElementInnerText(this.btnProductTitleAndTextMoreOrLess);
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductTitleAndTextMoreOrLess);
			getReusableActionsInstance().clickIfAvailable(this.btnProductTitleAndTextMoreOrLess);
			getReusableActionsInstance().staticWait(2000);
			this.waitForCondition(Driver->{return !this.getElementInnerText(this.btnProductTitleAndTextMoreOrLess).equalsIgnoreCase(lstText[0]);}, 20000);

			if(!this.getElementInnerText(this.btnProductTitleAndTextMoreOrLess).contains("Read Less")) {
				return false;
			}
			else {
				lstText[0]=this.getElementInnerText(this.btnProductTitleAndTextMoreOrLess);
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductTitleAndTextMoreOrLess);
				getReusableActionsInstance().clickIfAvailable(this.btnProductTitleAndTextMoreOrLess);
				getReusableActionsInstance().staticWait(2000);
				this.waitForCondition(Driver->{return !this.getElementInnerText(this.btnProductTitleAndTextMoreOrLess).equalsIgnoreCase(lstText[0]);}, 20000);

				if(!this.getElementInnerText(this.btnProductTitleAndTextMoreOrLess).contains("Read More")) {
					return false;
				}
				else {
					return true;
				}
			}
		}
		return true;
	}

	/**
	 * This method will verify pagination.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductPagination() {
		return checkProductResultPaginationExisting();
	}

	/**
	 * This method will get Recommendation container.
	 * @return  WebElement
	 * @author Wei.Li
	 */
	public WebElement getRecommendationContainer() {
		return this.recommendationContainer;
	}

	/**
	 * This method will get Header container.
	 * @return  WebElement
	 * @author Wei.Li
	 */
	public WebElement getHeaderContainer() {
		return this.headerContainer;
	}

	/**
	 * This method will get Footer container.
	 * @return  WebElement
	 * @author Wei.Li
	 */
	public WebElement getFooterContainer() {
		return this.footerContainer;
	}

	/**
	 * This method will verify the item content in product list without mouse hover.
	 * @param-List<WebElement> productList: the input product list
	 * @author Wei.Li
	 */
	public void verifySearchResultContent(List<WebElement> productList) {
		int loopSize;
		WebElement item,element;
		String lsProductName,lsText;

		loopSize=productList.size();
		for(int i=0;i<loopSize;i++) {
			item=productList.get(i);
			element=item.findElement(byProductName);
			lsProductName=this.getElementInnerText(element);
			reporter.reportLog("Product Name: "+lsProductName);
			if(!lsProductName.isEmpty()) {
				reporter.reportLogPass("Product Name is not empty");
			}
			else {
				reporter.reportLogFail("Product Name is empty");
			}
			//Bug 19537: [QA Defect - P3] PRP: Is Price should be bold
			if(element.getCssValue("font-weight").equalsIgnoreCase("600")) {
				reporter.reportLogPass("Product name is semi bold font");
			}
			else {
				reporter.reportLogFail("Product name is not semi bold font");
			}

			if(this.checkProductItemHeaderTitleExisting(item)) {
				element=item.findElement(byProductHeaderTitle);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product title is not empty");
				}
				else {
					reporter.reportLogFail("Product title is empty");
				}
				//Bug 19537: [QA Defect - P3] PRP: Is Price should be bold
				if(element.getCssValue("font-weight").equalsIgnoreCase("800")) {
					reporter.reportLogPass("Product title is bold font");
				}
				else {
					reporter.reportLogFail("Product title is not bold font");
				}
			}

			element=item.findElement(byProductHeaderLike);
			if(this.getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("Product like icon is visible");
			}
			else {
				reporter.reportLogFail("Product like icon is not visible");
			}

			element=item.findElement(byProductHref);
			if(!this.getElementHref(element).isEmpty()) {
				reporter.reportLogPass("Product link is not empty");
			}
			else {
				reporter.reportLogFail("Product link is empty");
			}

			element=item.findElement(byProductImage);
			if(!this.getElementImageSrc(element).isEmpty()) {
				reporter.reportLogPass("Product image source is not empty");
			}
			else {
				reporter.reportLogFail("Product image source is not empty");
			}

			if(!this.getProductOptionTypeWithoutMouseHover(item).equalsIgnoreCase("None")) {
				element=item.findElement(byProductOptionListContainer);				
				lsText=this.getElementInnerText(element);	
				this.getReusableActionsInstance().staticWait(1000);

				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product option is not empty");
				}
				else {
					reporter.reportLogFail("Product option is empty");
				}
			}

			if(this.checkProductItemBrandNameExisting(item)) {
				element=item.findElement(byProductBrand);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product brand name is not empty");
				}
				else {
					reporter.reportLogFail("Product brand name is empty");
				}
			}

			element=item.findElement(byProductNowPrice);
			lsText=this.getElementInnerText(element);
			if(!lsText.isEmpty()) {
				reporter.reportLogPass("Product Now Price is not empty");
			}
			else {
				reporter.reportLogFail("Product Now Price is not empty");
			}
			//Bug 19537: [QA Defect - P3] PRP: Is Price should be bold
			if(element.getCssValue("font-weight").equalsIgnoreCase("600")) {
				reporter.reportLogPass("Product NowPrice is semi bold font");
			}
			else {
				reporter.reportLogFail("Product NowPrice is not semi bold font");
			}

			if(this.checkProductItemWasPriceExisting(item)) {
				element=item.findElement(byProductWasPrice);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product Was Price is not empty");
				}
				else {
					reporter.reportLogFail("Product Was Price is empty");
				}
			}

			if(this.checkProductItemReviewExisting(item)) {
				element=item.findElement(byProductReviewContainer);
				if(this.getReusableActionsInstance().isElementVisible(element)) {
					reporter.reportLogPass("Product review is visible");
				}
				else {
					reporter.reportLogFail("Product review is not visible");
				}
			}
		}
	}

	/**
	 * This method will verify the item content in product list with mouse hover.
	 * @param-List<WebElement> productList: the input product list
	 * @author Wei.Li
	 */
	public void verifySearchResultContentWithMouseHover(List<WebElement> productList) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productList.get(0));
		this.getReusableActionsInstance().scrollToElement(productList.get(0));

		int checkAmount=5,loopSize;
		WebElement item,element;
		String lsProductName,lsText;
		if(checkAmount<=productList.size()) {
			loopSize=checkAmount;
		}
		else {
			loopSize=productList.size();
		}

		for(int i=0;i<loopSize;i++) {
			item=productList.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			this.getReusableActionsInstance().scrollToElement(item);

			element=item.findElement(byProductName);
			lsProductName=this.getElementInnerText(element);
			reporter.reportLog("Product Name: "+lsProductName);
			if(!lsProductName.isEmpty()) {
				reporter.reportLogPass("Product Name is not empty");
			}
			else {
				reporter.reportLogFail("Product Name is empty");
			}
			//Bug 19537: [QA Defect - P3] PRP: Is Price should be bold
			if(element.getCssValue("font-weight").equalsIgnoreCase("600")) {
				reporter.reportLogPass("Product Name is semi bold font");
			}
			else {
				reporter.reportLogFail("Product Nanme is not semi bold font");
			}

			if(this.checkProductItemHeaderTitleExisting(item)) {
				element=item.findElement(byProductHeaderTitle);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product title is not empty");
				}
				else {
					reporter.reportLogFail("Product title is empty");
				}
				//Bug 19537: [QA Defect - P3] PRP: Is Price should be bold
				if(element.getCssValue("font-weight").equalsIgnoreCase("800")) {
					reporter.reportLogPass("Product title is bold font");
				}
				else {
					reporter.reportLogFail("Product title is not bold font");
				}
			}

			element=item.findElement(byProductHeaderLike);
			if(this.getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("Product like icon is visible");
			}
			else {
				reporter.reportLogFail("Product like icon is not visible");
			}

			element=item.findElement(byProductHref);
			if(!this.getElementHref(element).isEmpty()) {
				reporter.reportLogPass("Product link is not empty");
			}
			else {
				reporter.reportLogFail("Product link is empty");
			}

			element=item.findElement(byProductImage);
			if(!this.getElementImageSrc(element).isEmpty()) {
				reporter.reportLogPass("Product image source is not empty");
			}
			else {
				reporter.reportLogFail("Product image source is not empty");
			}

			lsText=judgeProductOptionType(item);
			if(lsText.contains("Size")) {
				element=item.findElement(byProductOptionSizeTitle);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product option size title is not empty");
				}
				else {
					reporter.reportLogFail("Product option size title is empty");
				}

				if(item.findElements(byProductOptionSizeItemList).size()>0) {
					reporter.reportLogPass("Product option size button list is containing no less than 1 item");
				}
				else {
					reporter.reportLogFail("Product option size button list is containing 0 item");
				}

				if(checkViewAllSizesButtonExisting(item)) {
					element=item.findElement(byProductOptionSizeViewAllSizes);
					lsText=this.getElementInnerText(element);
					if(!lsText.isEmpty()) {
						reporter.reportLogPass("Product ViewAlllSize button title is not empty");
					}
					else {
						reporter.reportLogFail("Product ViewAlllSize button title is empty");
					}
				}
			}

			if(lsText.contains("Colour")) {
				element=item.findElement(byProductOptionColorTitle);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product option color title is not empty");
				}
				else {
					reporter.reportLogFail("Product option color title is empty");
				}

				if(item.findElements(byProductOptionColorItemList).size()>0) {
					reporter.reportLogPass("Product option color button list is containing no less than 1 item");
				}
				else {
					reporter.reportLogFail("Product option color button list is containing 0 item");
				}
			}

			if(this.checkProductItemBrandNameExisting(item)) {
				element=item.findElement(byProductBrand);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product brand name is not empty");
				}
				else {
					reporter.reportLogFail("Product brand name is empty");
				}
			}

			element=item.findElement(byProductNowPrice);
			lsText=this.getElementInnerText(element);
			if(!lsText.isEmpty()) {
				reporter.reportLogPass("Product Now Price is not empty");
			}
			else {
				reporter.reportLogFail("Product Now Price is not empty");
			}
			//Bug 19537: [QA Defect - P3] PRP: Is Price should be bold
			if(element.getCssValue("font-weight").equalsIgnoreCase("600")) {
				reporter.reportLogPass("Product NowPrice is semi bold font");
			}
			else {
				reporter.reportLogFail("Product NowPrice is not semi bold font");
			}

			if(this.checkProductItemWasPriceExisting(item)) {
				element=item.findElement(byProductWasPrice);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product Was Price is not empty");
				}
				else {
					reporter.reportLogFail("Product Was Price is empty");
				}
			}

			if(this.checkProductItemReviewExisting(item)) {
				element=item.findElement(byProductReviewContainer);
				if(this.getReusableActionsInstance().isElementVisible(element)) {
					reporter.reportLogPass("Product review is visible");
				}
				else {
					reporter.reportLogFail("Product review is not visible");
				}
			}

			element=item.findElement(byProductGoToDetails);
			this.getReusableActionsInstance().staticWait(1000);
			if(this.getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("Product GoTo Details is visible");
			}
			else {
				reporter.reportLogFail("Product GoTo Details is not visible");
			}

			if(this.getElementInnerText(element).equalsIgnoreCase("Go to detail page")) {
				continue;
			}

			verifySelectSizeOrColorOption(item, byProductGoToDetails);
		}
	}

	/**
	 * This method will verify sort options.
	 * @param- List<String> lstOption: input option list
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifySortOptions(List<String> lstOptionYml) {
		if(!getReusableActionsInstance().isElementVisible(this.btnSortSelect)) {
			return false;
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSortSelect);
		this.btnSortSelect.click();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.sortByOptionList.get(0));

		int listSize=this.sortByOptionList.size();
		if(listSize!=lstOptionYml.size()) {
			return false;
		}

		List<String> lstOption=new ArrayList<String>();
		for(int i=0;i<listSize;i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.sortByOptionList.get(i));
			lstOption.add(this.sortByOptionList.get(i).getText().trim());
		}

		Set<String> setOption=new HashSet<String>(lstOption);
		Set<String> setOptionYml=new HashSet<String>(lstOptionYml);

		return setOption.containsAll(setOptionYml)&&setOptionYml.containsAll(setOption);
	}

	/**
	 * This method will choose sort option by visible text.
	 * @param- String lsOption: visible option text
	 * @return true/false
	 * @author Wei.Li
	 */
	//Bug 19734: [UAT Defect]: PRP: Sorting filter is not retained when going past page 1
	public boolean chooseSortOptionByVisibleText(String lsOption) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSortSelect);
		Select sortOption= new Select(this.btnSortSelect);
		sortOption.selectByVisibleText(lsOption);
		
		this.getReusableActionsInstance().staticWait(2000);		
		if(!this.URL().contains("page=")) {
			reporter.reportLogPass("The Url does not contain page term.");
		}
		else {
			reporter.reportLogFail("The Url contains page term.");
		}
		
		if(this.getElementInnerText(btnCurrentPage).equalsIgnoreCase("1")) {
			reporter.reportLogPass("The current page is 1st page.");
		}
		else {
			reporter.reportLogFail("The current page is not 1st page.");
		}

		return this.waitForSortingOrFilteringCompleted();
	}

	/**
	 * This method will verify Price: Highest first strategy.
	 * @param-boolean bHighest: true for Highest while false for Lowest
	 * @return String: error message
	 * @author Wei.Li
	 */
	//Bug 19117: PRP - Sorting Brand A-Z, not working.
	public String verifyPriceFirstSort(boolean bHighest) {
		String lsErrorMsg="";
		if(this.productResultList.size()==0) {
			return lsErrorMsg="No product list";
		}

		List<Float> priceList=new ArrayList<Float>();
		List<String> productNameList=new ArrayList<String>();
		for(WebElement element:this.productResultList) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(element);

			String nowPriceText=element.findElement(this.byProductNowPrice).getText().trim();
			float nowPriceValue=this.getFloatFromString(nowPriceText,true);

			priceList.add(nowPriceValue);
			String productName=element.findElement(this.byProductName).getText().trim();
			productNameList.add(productName);
		}

		int priceListSize=priceList.size();
		for(int i=0;i<priceListSize-1;i++) {
			if(bHighest) {
				if(priceList.get(i)<priceList.get(i+1)) {
					lsErrorMsg="Sort option of Price: Highest first does not work: the price of "+productNameList.get(i)+" is less than "+productNameList.get(i+1);
					return lsErrorMsg;
				}
			}
			else {
				if(priceList.get(i)>priceList.get(i+1)) {
					lsErrorMsg="Sort option of Price: Lowest first does not work: the price of "+productNameList.get(i)+" is greater than "+productNameList.get(i+1);
					return lsErrorMsg;
				}
			}			
		}

		return lsErrorMsg;
	}
	
	/**
	 * This method will verify Reviews: Highest first strategy.
	 * @return String: error message
	 * @author Wei.Li
	 */
	//Bug 19117: PRP - Sorting Brand A-Z, not working.
	public String verifyHighestReviewFirstSort() {
		String lsErrorMsg="";
		if(this.productResultList.size()==0) {
			return lsErrorMsg="No product list";
		}

		List<Integer> reviewList=new ArrayList<Integer>();
		List<String> productNameList=new ArrayList<String>();
		for(WebElement element:this.productResultList) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(element);

			if(this.checkProductItemReviewExisting(element)) {
				List<WebElement> reviewStarList=element.findElements(this.byProductReviewRatingImage);
				int reviewCount=getProductItemReviewNumberAmountFromStarImage(reviewStarList);
				
				reviewList.add(reviewCount);
			}
			else {
				reviewList.add(0);
			}
			
			String productName=element.findElement(this.byProductName).getText().trim();
			productNameList.add(productName);
		}

		int reviewListSize=reviewList.size();
		for(int i=0;i<reviewListSize-1;i++) {
			if(reviewList.get(i)<reviewList.get(i+1)) {
				lsErrorMsg="Sort option of Reviews: Highest first does not work: the review of "+productNameList.get(i)+" is less than "+productNameList.get(i+1);
				return lsErrorMsg;
			}						
		}

		return lsErrorMsg;
	}
	
	/**
	 * This method will verify Brand Name: A to Z strategy.
	 * @return String: error message
	 * @author Wei.Li
	 */
	//Bug 19117: PRP - Sorting Brand A-Z, not working.
	public String verifyBrandNameOrderByAlphabet() {
		String lsErrorMsg="";
		if(this.productResultList.size()==0) {
			return lsErrorMsg="No product list";
		}

		WebElement item;
		String lsText;
		List<String> brandList=new ArrayList<String>();
		List<String> productNameList=new ArrayList<String>();
		for(WebElement element:this.productResultList) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(element);

			if(this.checkProductItemBrandNameExisting(element)) {
				item=element.findElement(byProductBrand);
				lsText=this.getElementInnerText(item);
				brandList.add(lsText);
			}
			else {
				brandList.add("Z");
			}

			String productName=element.findElement(this.byProductName).getText().trim();
			productNameList.add(productName);
		}

		int brandListSize=brandList.size();
		for(int i=0;i<brandListSize-1;i++) {
			if(brandList.get(i).compareTo(brandList.get(i+1))>0) {
				lsErrorMsg="Sort option of Brand Name: A to Z does not work: the BrandName of "+productNameList.get(i)+" is greater than "+productNameList.get(i+1)+" with alphabet order";
				return lsErrorMsg;
			}						
		}

		return lsErrorMsg;
	}

	/**
	 * This method will verify filter option headers.
	 * @param- List<String> lstOption: input option list in yml file
	 * @return String: error message
	 * @author Wei.Li
	 */
	public String verifyFilterOptions(List<String> lstOptionYml) {
		String lsErrorMsg="";
		int listSize=this.productFilterList.size();
		if(listSize==0) {
			return lsErrorMsg="No product filter list";
		}

		for(int i=0;i<listSize;i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			if(lstOptionYml.contains(this.productFilterList.get(i).getText().trim())) {
				continue;
			}else {
				lsErrorMsg = "Filter option headers in left panel contain "+this.productFilterList.get(i).getText().trim()+" that is not present in input list";
				break;
			}
		}
		return lsErrorMsg;
	}

	/**
	 * This method will select filter from left panel.
	 * @param- String lsFirstLevelItem: header filter keyword
	 * @param- String lsSecondLevelItem: subFilter keyword
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean selectFilterItemInLeftPanel(String lsFirstLevelItem,String lsSecondLevelItem) {
		this.firstLevelFilter=lsFirstLevelItem;
		this.secondLevelFilter=lsSecondLevelItem;

		WebElement searchInputButton;
		List<WebElement> subItemList;
		for(int i=0;i<this.productFilterList.size();i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			String lsHeader=this.productFilterList.get(i).getText().trim();
			if(lsHeader.contains("(")) {
				lsHeader=lsHeader.split("\\(")[0].trim();
			}
			//If found lsFirstLevelItem
			if(lsHeader.equalsIgnoreCase(lsFirstLevelItem)) {
				//If find a search input
				collapseFilterItemWithClickingProductTitle(this.productFilterContainerList.get(i));
				if(checkSearchInputButtonExistingInSubFilter(this.productFilterContainerList.get(i))) {
					searchInputButton=this.productFilterContainerList.get(i).findElement(this.byProductFilterSearchInput);
					getReusableActionsInstance().javascriptScrollByVisibleElement(searchInputButton);
					searchInputButton.sendKeys(lsSecondLevelItem);
					getReusableActionsInstance().staticWait(3000);
					subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);
					if(subItemList.size()>0) {
						getReusableActionsInstance().javascriptScrollByVisibleElement(subItemList.get(0));
						getReusableActionsInstance().clickIfAvailable(subItemList.get(0));
						
						this.getReusableActionsInstance().staticWait(2000);
						//Bug 19628: [QA Defect - P3] PRP: no products display if user is on the last page and select a faucet from the left nav
						if(!this.URL().contains("page=")) {
							reporter.reportLogPass("The Url does not contain page term.");
						}
						else {
							reporter.reportLogFail("The Url contains page term.");
						}
						
						if(this.getElementInnerText(btnCurrentPage).equalsIgnoreCase("1")) {
							reporter.reportLogPass("The current page is 1st page.");
						}
						else {
							reporter.reportLogFail("The current page is not 1st page.");
						}
						
						return waitForSortingOrFilteringCompleted();
					}
					else {
						break;
					}
				}

				expandFilterItem(this.productFilterContainerList.get(i));
				String lsSubItem=null;
				subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);
				for(WebElement subItem : subItemList) {
					getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
					getReusableActionsInstance().staticWait(2000);
					//if statement to test Bug-19685 - Review filter
					if(lsSecondLevelItem.toLowerCase().contains("star")){
						lsSubItem = subItem.findElement(By.xpath(".//span[@class='plp-filter-panel__filter-list__item-label-text visually-hidden']")).getText().trim();
						subItem = subItem.findElement(By.xpath("//span[@class='plp-filter-panel__filter-list__item-label-text visually-hidden']/preceding-sibling::span"));
					}
					else
						lsSubItem = subItem.findElement(By.xpath(".//span[@class='plp-filter-panel__filter-list__item-label-text']")).getText().trim();
					getReusableActionsInstance().staticWait(2000);
					//If found lsSecondLevelItem
					if(lsSubItem.equalsIgnoreCase(lsSecondLevelItem)) {
						getReusableActionsInstance().staticWait(2000);
						getReusableActionsInstance().clickIfAvailable(subItem);
						
						this.getReusableActionsInstance().staticWait(2000);
						
						//Bug 19628: [QA Defect - P3] PRP: no products display if user is on the last page and select a faucet from the left nav
						if(!this.URL().contains("page=")) {
							reporter.reportLogPass("The Url does not contain page term.");
						}
						else {
							reporter.reportLogFail("The Url contains page term.");
						}
						
						if(this.getElementInnerText(btnCurrentPage).equalsIgnoreCase("1")) {
							reporter.reportLogPass("The current page is 1st page.");
						}
						else {
							reporter.reportLogFail("The current page is not 1st page.");
						}
						
						return waitForSortingOrFilteringCompleted();
					}
				}
			}
		}

		//If unable to find both lsFirstLevelItem and lsSecondLevelItem, then select the first choice
		this.bDefault=true;

		for(int i=0;i<this.productFilterList.size();i++) {
			expandFilterItem(this.productFilterContainerList.get(i));

			subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);
			for(WebElement subItem : subItemList) {
				if(!this.hasElementAttribute(subItem.findElement(By.xpath(".//button//input")), "checked")) {
					this.secondLevelFilter=this.getElementInnerText(subItem);
					this.firstLevelFilter=this.getElementInnerText(subItem.findElement(By.xpath("./ancestor::div[@class='plp-filter-panel__blocks']//button[@class='plp-filter-panel__block-title']")));

					getReusableActionsInstance().staticWait(3000);
					getReusableActionsInstance().clickIfAvailable(subItem);
					
					this.getReusableActionsInstance().staticWait(2000);
					
					//Bug 19628: [QA Defect - P3] PRP: no products display if user is on the last page and select a faucet from the left nav
					if(!this.URL().contains("page=")) {
						reporter.reportLogPass("The Url does not contain page term.");
					}
					else {
						reporter.reportLogFail("The Url contains page term.");
					}
					
					if(this.getElementInnerText(btnCurrentPage).equalsIgnoreCase("1")) {
						reporter.reportLogPass("The current page is 1st page.");
					}
					else {
						reporter.reportLogFail("The current page is not 1st page.");
					}
					
					return waitForSortingOrFilteringCompleted();
				}
			}
		}
		return false;
	}

	/**
	 * This method will verify filter by price.
	 * @param- String lsPriceMode: Under/Between/Over
	 * @param- boolean bFirst: true for first item and false for not first item
	 * @return String: error message
	 * @author Wei.Li
	 */
	public String verifyFilterByPrice(String lsPriceMode,boolean bFirst) {
		String lsErrorMsg="";

		if(!this.checkProductResultExisting()) {
			return lsErrorMsg="No product list";
		}

		for(WebElement element:this.productResultList) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			String productName=element.findElement(this.byProductName).getText().trim();

			String nowPriceText=element.findElement(this.byProductNowPrice).getText().trim();
			float nowPriceValue=this.getFloatFromString(nowPriceText,false);
			List<String> lstPrice=this.getNumberFromString(secondLevelFilter);

			switch(lsPriceMode) {
				case "Under":
					int priceOptionValue=Integer.parseInt(lstPrice.get(0));
					if(nowPriceValue>=priceOptionValue) {
						lsErrorMsg="Filter by price does not work for productName of "+productName;
					}
					break;
				case "Between":
					int lowPriceOptionValue=Integer.parseInt(lstPrice.get(0));
					int highPriceOptionValue=Integer.parseInt(lstPrice.get(1));
					if(nowPriceValue<lowPriceOptionValue||nowPriceValue>highPriceOptionValue) {
						lsErrorMsg="Filter by price does not work for productName of "+productName;
					}
					break;
				case "Over":
					priceOptionValue=Integer.parseInt(lstPrice.get(0));
					if(nowPriceValue<priceOptionValue) {
						lsErrorMsg="Filter by price does not work for productName of "+productName;
					}
					break;
			}

			if(bFirst) {
				return lsErrorMsg;
			}

			if(!lsErrorMsg.isEmpty()) {
				return lsErrorMsg;
			}
		}

		return lsErrorMsg;
	}

	/**
	 * This method will close all selected filters.
	 * @return true/false: The last one is ClearAllFiltersButton.
	 * @author Wei.Li
	 */
	public boolean closeAllSelectedFilters() {
		WebElement element=this.selectedFiltersList.get(this.selectedFiltersList.size()-1);
		getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		getReusableActionsInstance().clickIfAvailable(element);
		return this.waitForSortingOrFilteringCompleted();
	}

	/**
	 * This method will verify if selected filters contain suitable search second level filters.
	 * @param- List<String> lstFilterIncluded: second level filter list
	 * @param- List<String> lstFilterExcluded: the filters should not appear in selected filters option
	 * @return String: error message
	 * @author Wei.Li
	 */
	public String verifySlectedFiltersContainSecondlevelFilter(List<String> lstFilterIncluded, List<String> lstFilterExcluded) {
		String lsMsg="";
		List<String> lstSelectedFilterOption=new ArrayList<String>();
		int selectedFilterSize = this.selectedFiltersList.size() - 1;
		for (int i = 0; i < selectedFilterSize; i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectedFiltersList.get(i));
			lstSelectedFilterOption.add(this.selectedFiltersList.get(i).getText().trim());
		}

		for(String lsItem:lstSelectedFilterOption) {
			if(!lstFilterIncluded.contains(lsItem)) {
				lsMsg= "The search second level filters do not contain the selected filter of '"+lsItem+"'";
				break;
			}
		}

		for(String lsItem:lstFilterExcluded) {
			if(lstSelectedFilterOption.contains(lsItem)) {
				lsMsg=lsMsg+ "The selected filters should not contain the excluded filter of '"+lsItem+"'";
			}
		}

		return lsMsg;
	}

	/**
	 * This method will switch page through clicking Pre/Next button.
	 * @param- boolean bNext: true for next page and false for previous page
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean switchPage(boolean bNext) {
		if(!this.checkProductPagination()) {
			return false;
		}

		if(this.PageNumberList.size()==1) {
			return false;
		}

		String lsFirstProductName=this.getElementInnerText(this.getProductList().get(0).findElement(byProductName));
		
		if(bNext) {
			if(!this.checkIfNextPageButtonAvailable()) {
				return false;
			}

			WebElement lastPageButton=this.PageNumberList.get(this.PageNumberList.size()-1);
			if(lastPageButton.getAttribute("class").contains("plp__pagination__pages__page--current")) {
				return false;
			}else {
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnNextPage);
				this.btnNextPage.click();
			}

		}else {
			if(!this.checkIfPrevPageButtonAvailable()) {
				return false;
			}

			WebElement firstPageButton=this.PageNumberList.get(0);
			if(firstPageButton.getAttribute("class").contains("plp__pagination__pages__page--current")) {
				return false;
			}else {
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnPreviousPage);
				this.btnPreviousPage.click();
			}
		}

		this.waitForPageToLoad();

		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,120);
		
		this.getReusableActionsInstance().staticWait(2000);
		
		this.waitForCondition(Driver->{return !lsFirstProductName.equalsIgnoreCase(this.getElementInnerText(this.getProductList().get(0).findElement(byProductName)));}, 20000);

		return true;
	}

	/**
	 * This method will get the first product name.
	 * @return String
	 * @author Wei.Li
	 */
	public String getFirstProductName() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.productResultList.get(0));
		WebElement item=this.productResultList.get(0).findElement(this.byProductName);
		return this.getElementInnerText(item);
	}

	/**
	 * This method will get the filter container corresponding to the specific first level filter.
	 * @param- String lsFirstLevelItem: header filter keyword
	 * @return WebElement: the element container corresponding to the specific first level filter.
	 * @author Wei.Li
	 */
	public WebElement getFilterContainerWithSpecificFirstlevelFilterInLeftPanel(String lsFirstLevelItem) {
		int loopSize=this.productFilterList.size();
		for(int i=0;i<loopSize;i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			String lsHeader=this.productFilterList.get(i).getText().trim();
			if(lsHeader.contains("(")) {
				lsHeader=lsHeader.split("\\(")[0].trim();
			}
			//If found lsFirstLevelItem
			if(lsHeader.equalsIgnoreCase(lsFirstLevelItem)) {
				return this.productFilterContainerList.get(i);
			}
		}
		return null;
	}

	/**
	 * This method will get hidden element corresponding to an element container.
	 * @return sub element count.
	 * @author Wei.Li
	 */
	public int getFiltersCountInSecondLevel() {
		return secondlevelFilterList.size();
	}

	/**
	 * This method will contain clearance title .
	 * @return  WebElement
	 * @author godwin.gopi
	 */
	public String getClearanceOptionURLTitle() {
		String clearanceURLTitleText = getDriver().getCurrentUrl();
		return clearanceURLTitleText;
	}

	/**
	 * This method will get the review number amount of product item
	 * @param- List<WebElement> lstReviewStar: review star list
	 * @return  int: review number amount
	 * @author Wei.Li
	 */
	public int getProductItemReviewNumberAmountFromStarImage(List<WebElement> lstReviewStar) {
		int sum=0,starNumber;
		for(WebElement item:lstReviewStar) {
			String[] lstClass=item.getAttribute("class").split(" ");
			String lsFilledClass="";
			for(String lsClass:lstClass) {
				if(lsClass.contains("filled")) {
					lsFilledClass=lsClass;
					break;
				}
			}
			starNumber=this.getIntegerFromString(lsFilledClass);			
			sum=sum+starNumber;
		}
		return sum;
	}

	public boolean checkIfNextPageButtonAvailable() {
		return this.btnNextPage.getAttribute("style").contains("opacity: 1");
	}

	public boolean checkIfPrevPageButtonAvailable() {
		return this.btnPreviousPage.getAttribute("style").contains("opacity: 1");
	}

	public boolean waitForPDPPageLoading() {
		this.getReusableActionsInstance().waitForElementVisibility((new ProductDetailPage(this.getDriver())).lblProductName,120);
		return true;
	}

	//Fake methods for compiling temporally
	public boolean waitForPageLoading() {
		return true;
	}

	/**
	 * This method will go to the product with with Vedio,Size,Style,Badge image, Review,EasyPay,Nowprice and WasPrice
	 * @return true/false
	 * @author Wei.Li
	 * @throws IOException
	 */
	public boolean goToProductItemWithPreConditions(List<String> lstKeyword) throws IOException {
		ApiResponse apiResponse=new ApiResponse();
		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("video", "1");
		outputDataCriteria.put("style", "3");
		outputDataCriteria.put("size", "3");

		SelectedProduct selectedProduct=null;
		Product.Products product=null;

		String productNumber="";
		for(String lsKeyword:lstKeyword) {
			product=apiResponse.getProductInfoFromKeyword(lsKeyword, outputDataCriteria,true);
			if(product!=null) {
				break;
			}
		}

		while(this.switchPage(true));
		/*getDriver().findElement(By.xpath("//div[contains(@class,'plp-card-grid-item')]")).click();
		return waitForCondition(Driver->{
			return this.imgProductBadge.isDisplayed();
		},90000);
		//return this.waitForPageLoading();*/
		return false;
	}

	/*public boolean goToFirstProductItem(String lsProductNumber) {
		this.getSearchResultLoad(lsProductNumber);
		this.waitForPageLoading();
		WebElement item=this.productResultList.get(0).findElement(By.xpath(".//a"));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		item.click();
		waitForCondition(Driver->{
			return this.lblProductName.isDisplayed();
		},90000);
		this.waitForPageToLoad();

		return true;
	}*/

	/*public boolean goToFirstProductItem() {

		if(product==null){
			reporter.reportLogFail("Unable to find the product with Vedio,Size,Style,Badge image, Review,EasyPay,Nowprice and WasPrice");
			return false;
		}

		selectedProduct=apiResponse.selectedProduct;

		productNumber=selectedProduct.productNumber;

		this.selectedProductItem.init();

		this.getSearchResultLoad(productNumber);
		WebElement item=this.productResultList.get(0);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		this.getReusableActionsInstance().scrollToElement(item);

		this.selectedProductItem.productNumber=productNumber;
		this.selectedProductItem.productName=this.getElementInnerText(item.findElement(this.byProductName));
		if(this.checkProductItemBrandNameExisting(item)) {
			this.selectedProductItem.productBrand=this.getElementInnerText(item.findElement(this.byProductBrand));
		}
		this.selectedProductItem.productNowPrice=this.getElementInnerText(item.findElement(this.byProductNowPrice)).replace("Current price:", "").trim();
		this.selectedProductItem.productWasPrice=this.getElementInnerText(item.findElement(this.byProductWasPrice)).replace("Previous price:", "").trim();
		this.selectedProductItem.productNavigationUrl=this.URL();

		this.clickElement(item.findElement(this.byProductHref));

		return this.waitForPDPPageLoading();
	}*/

	/**
	 * This method will go to the product with with Vedio,Size,Style,Badge image, Review,EasyPay,Nowprice and WasPrice
	 * @return true/false
	 * @author Wei.Li
	 * @throws IOException
	 */
	public boolean findProductItemWithPreConditions(List<String> lstKeyword) throws IOException {
		ApiResponse apiResponse=new ApiResponse();
		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("video", "1");
		outputDataCriteria.put("style", "3");
		outputDataCriteria.put("size", "3");

		SelectedProduct selectedProduct= null;
		Product.Products product=null;
		String productNumber="";
		for(String lsKeyword:lstKeyword) {
			product=apiResponse.getProductInfoFromKeyword(lsKeyword, outputDataCriteria,true);
			if(product!=null) {
				break;
			}
		}

		if(product==null){
			reporter.reportLogFail("Unable to find the product with Vedio,Size,Style,Badge image, Review,EasyPay,Nowprice and WasPrice");
			return false;
		}

		selectedProduct=apiResponse.selectedProduct;
		productNumber=selectedProduct.productNumber;

		this.selectedProductItem.init();

		this.getSearchResultLoad(productNumber,true);

		WebElement item=this.productResultList.get(0);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		this.getReusableActionsInstance().scrollToElement(item);

		this.selectedProductItem.productNumber=productNumber;
		this.selectedProductItem.productName=product.getName();
		this.selectedProductItem.productBrand=product.getBrand();
		this.selectedProductItem.productNowPrice=product.getIsPriceRange();
		this.selectedProductItem.productWasPrice=product.getWasPriceRange();

		return true;
	}

	public boolean goToFirstProductItem(String lsProductNumber) {
		this.selectedProductItem.init();

		getSearchResultLoad(lsProductNumber,true);
		WebElement item=this.productResultList.get(0);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);

		this.selectedProductItem.productNumber=lsProductNumber;
		this.selectedProductItem.productName=this.getElementInnerText(item.findElement(this.byProductName));
		if(this.checkProductItemBrandNameExisting(item)) {
			this.selectedProductItem.productBrand=this.getElementInnerText(item.findElement(this.byProductBrand));
		}
		this.selectedProductItem.productNowPrice=this.getElementInnerText(item.findElement(this.byProductNowPrice)).replace("Current price:", "").trim();

		if(this.checkProductItemWasPriceExisting(item)) {
			this.selectedProductItem.productWasPrice=this.getElementInnerText(item.findElement(this.byProductWasPrice)).replace("Previous price:", "").trim();
		}
		this.selectedProductItem.productNavigationUrl=this.URL();

		item.findElement(this.byProductHref).click();

		return this.waitForPDPPageLoading();
	}



	/**
	 * This method will verify Product Recommendation section and validate section Images, and Prices .
	 * @return  void
	 * @author godwin.gopi
	 */
	public void verify_ProductRecommendationSection() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productRecommendationTitle);
		for(WebElement item: this.lstPeopleAlsoBoughtItems) {
			//Verifying Image of the Product
			reporter.softAssert(!item.findElement(byRecommendationImage).getAttribute("src").isEmpty(), "ProductImage in Recommendation result is correct", "ProductImage in Recommendation result is incorrect");

			//Verifying Name of the Product
			reporter.softAssert(!item.findElement(byRecommendationName).getText().isEmpty(), "ProductName in Recommendation result is correct", "ProductName in Recommendation result is incorrect");

			//Verifying Price of the Product
			reporter.softAssert(!item.findElement(byRecommendationNowPrice).getText().isEmpty(), "ProductNowPrice in Recommendation result is correct", "ProductNowPrice in Recommendation result is incorrect");

			//Verifying Was Price is Displayed
			if(this.getChildElementCount(item.findElement(this.byRecommendationPriceContainer))>1) {
				reporter.softAssert(!item.findElement(byRecommendationWasPrice).getText().isEmpty(), "ProductWasPrice in Recommendation result is correct", "ProductWasPrice in Recommendation result is incorrect");
			}
		}
	}

	/**
	 * This method will check if page loading completed after choose sorting/filtering
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductResultLoadingStatusAfterSorting() {
		return this.checkChildElementExistingByAttribute(this.cntSortingAndFilteringProductResultLoadingIndicator,"class","plp__loading");
	}

	/**
	 * This method will wait until page loading completed after choose sorting/filtering
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean waitForSortingOrFilteringCompleted() {
		this.waitForCondition(Driver->{return !checkProductResultLoadingStatusAfterSorting();}, 30000);
		this.getReusableActionsInstance().staticWait(10000);

		return true;
	}

	/**
	 * This method will check Product result existence
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductResultExisting() {
		return this.checkChildElementExistingByAttribute(this.cntTSCContainer,"class","plp");
	}

	/**
	 * This method will check Product result existence
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductResultPaginationExisting() {
		return this.checkChildElementExistingByAttribute(this.cntTSCContainer,"class","plp__pagination");
	}

	/**
	 * This method will check Product Item Header Title Existing
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductItemHeaderTitleExisting(WebElement itemContainer) {
		return this.getChildElementCount(itemContainer.findElement(this.byProductHeaderTitleContainer))>1;
	}

	/**
	 * This method will judge Product Item option type
	 * @param-WebElement itemContainer: product search result item
	 * @return String
	 * @author Wei.Li
	 */
	public String getProductOptionTypeWithoutMouseHover(WebElement itemContainer) {
		List<WebElement> optionList=itemContainer.findElements(this.byProductOptionList);
		WebElement item=optionList.get(0);
		String lsText=this.getElementInnerText(item);

		if(lsText.isEmpty()) {
			return "None";
		}

		if(item.getAttribute("class").contains("product-card__options-count__item--critical-stock")) {
			return "LeftOver";
		}

		if(item.getAttribute("class").contains("product-card__options-count__item--out-of-stock")) {
			return "SoldOut";
		}

		if(item.getAttribute("class").equalsIgnoreCase("product-card__options-count__item")) {
			return "OptionList";
		}

		return "Other";
	}

	/**
	 * This method will get Product Item option type number without mouse hover
	 * @param-WebElement itemContainer: product search result item
	 * @param-String lsOption: "size"/"colour"
	 * @return boolean
	 * @author Wei.Li
	 */
	public int getProductOptionTypeNumberWithoutMouseHover(WebElement itemContainer,String lsOption) {
		if(!getProductOptionTypeWithoutMouseHover(itemContainer).equalsIgnoreCase("OptionList")) {
			return -1;
		}

		String lsText;
		List<WebElement> optionList=itemContainer.findElement(this.byProductOptionList);
		for(WebElement item:optionList) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim().toLowerCase();
			if(lsText.contains(lsOption.toLowerCase())) {
				return this.getIntegerFromString(lsText);
			}
		}

		return 0;
	}

	/**
	 * This method will check Product Item colour option Existing with mouse hover
	 * @param-WebElement itemContainer: product search result item
	 * @param-String lsOption: "size"/"colour"
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductOptionTypeExistingWithMouseHover(WebElement itemContainer,String lsOption) {
		List<WebElement> itemList=itemContainer.findElements(this.byProductOptionTitle);
		for(WebElement item:itemList) {
			String lsText=this.getElementInnerText(item);
			if(lsText.toLowerCase().contains(lsOption.toLowerCase())){
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will judge Product Item option type through button text
	 * @param-WebElement itemContainer: product search result item
	 * @return String
	 * @author Wei.Li
	 */
	public String judgeProductOptionType(WebElement itemContainer) {
		WebElement item=itemContainer.findElement(this.byProductGoToDetails);
		String lsText=this.getElementInnerText(item);
		if(lsText.equalsIgnoreCase("Go to detail page")) {
			return "GoToDetailPage";
		}

		if(lsText.toLowerCase().contains("size")&&lsText.toLowerCase().contains("colour")) {
			return "SizeAndColour";
		}

		if(lsText.toLowerCase().contains("size")&&!lsText.toLowerCase().contains("colour")) {
			return "Size";
		}

		if(!lsText.toLowerCase().contains("size")&&lsText.toLowerCase().contains("colour")) {
			return "Colour";
		}

		return "Other";
	}

	/**
	 * This method will check Size Product Option Is Dropdown with mouse hover
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkSizeProductOptionIsDropdownWithMouseHover(WebElement itemContainer) {
		WebElement item=itemContainer.findElement(this.byProductOptionSizeWrapper);

		return this.checkChildElementExistingByTagName(item, "select");
	}

	/**
	 * This method will check Color Product Option Is Dropdown with mouse hover
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkColorProductOptionIsDropdownWithMouseHover(WebElement itemContainer) {
		WebElement item=itemContainer.findElement(this.byProductOptionColorWrapper);

		return this.checkChildElementExistingByTagName(item, "select");
	}

	/**
	 * This method will check Product size disabled option Item available while mouse hover
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductSizeOptionDisabledItemAvailableWithMouseHover(WebElement itemContainer) {
		List<WebElement> itemList=itemContainer.findElements(this.byProductOptionSizeItemList);
		for(WebElement item:itemList) {
			if(this.hasElementAttribute(item, "disabled")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will check Product size enabled option Item available while mouse hover
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductSizeOptionEnabledItemAvailableWithMouseHover(WebElement itemContainer) {
		if(!checkProductSizeOptionDisabledItemAvailableWithMouseHover(itemContainer)) {
			return true;
		}

		List<WebElement> itemAllList=itemContainer.findElements(this.byProductOptionSizeItemList);
		List<WebElement> itemDisabledList=itemContainer.findElements(this.byProductOptionSizeItemDisabledList);

		if(itemAllList.size()!=itemDisabledList.size()) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method will check Product color disabled option Item available while mouse hover
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductColorOptionDisabledItemAvailableWithMouseHover(WebElement itemContainer) {
		List<WebElement> itemList=itemContainer.findElements(this.byProductOptionColorItemList);
		for(WebElement item:itemList) {
			if(this.hasElementAttribute(item, "disabled")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will check Product color enabled option Item available while mouse hover
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductColorOptionEnabledItemAvailableWithMouseHover(WebElement itemContainer) {
		if(!checkProductColorOptionDisabledItemAvailableWithMouseHover(itemContainer)) {
			return true;
		}

		List<WebElement> itemAllList=itemContainer.findElements(this.byProductOptionColorItemList);
		List<WebElement> itemDisabledList=itemContainer.findElements(this.byProductOptionColorItemDisabledList);

		if(itemAllList.size()!=itemDisabledList.size()) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method will select size/color option
	 * @param-WebElement itemContainer: product search result item
	 * @param-WebElement selectSizeAndColorButton: the button for selecting size and color
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean selectSizeOrColorOption(WebElement itemContainer, By BySelectSizeAndColorButton) {
		List<WebElement> optionList;
		WebElement element;

		if(this.checkProductOptionTypeExistingWithMouseHover(itemContainer, "size")) {
			if(checkProductSizeOptionEnabledItemAvailableWithMouseHover(itemContainer)) {
				optionList=itemContainer.findElements(byProductOptionSizeItemEnabledList);
				this.clickElement(optionList.get(optionList.size()-1));
				this.getReusableActionsInstance().staticWait(3000);
				element=itemContainer.findElement(byProductOptionSizeSelectedSize);
				selectedProductItem.productSelectedSize=this.getElementInnerText(element);
			}
			else {
				selectedProductItem.productSelectedSize="";
			}
		}

		if(this.checkProductOptionTypeExistingWithMouseHover(itemContainer, "colour")) {
			if(checkProductColorOptionEnabledItemAvailableWithMouseHover(itemContainer)) {
				optionList=itemContainer.findElements(byProductOptionColorItemEnabledList);
				this.clickElement(optionList.get(optionList.size()-1));
				this.getReusableActionsInstance().staticWait(3000);
				element=itemContainer.findElement(byProductOptionColorSelectedColor);
				selectedProductItem.productSelectedColor=this.getElementInnerText(element);
			}
			else {
				selectedProductItem.productSelectedColor="";
			}
		}

		element=itemContainer.findElement(BySelectSizeAndColorButton);
		return this.getElementInnerText(element).trim().equalsIgnoreCase("Go to detail page");
	}

	/**
	 * This method will verify selecting size/color option
	 * @param-WebElement itemContainer: product search result item
	 * @param-WebElement selectSizeAndColorButton: the button for selecting size and color
	 * @return void
	 * @author Wei.Li
	 */
	public void verifySelectSizeOrColorOption(WebElement itemContainer, By BySelectSizeAndColorButton) {
		WebElement element;
		String lsText,lsType;
		boolean bSize=false,bColor=false;

		//To check button text
		element=itemContainer.findElement(BySelectSizeAndColorButton);
		lsText=this.getElementInnerText(element);
		lsType=this.judgeProductOptionType(itemContainer);
		if(lsType.equalsIgnoreCase("SizeAndColour")) {
			if(lsText.equalsIgnoreCase("Select size & colour")) {
				reporter.reportLogPass("The button text is equal to 'Select size & colour'");
			}
			else {
				reporter.reportLogFail("The button text is not equal to 'Select size & colour'");
			}
		}

		if(lsType.equalsIgnoreCase("Size")) {
			if(lsText.equalsIgnoreCase("Select size")) {
				reporter.reportLogPass("The button text is equal to 'Select size'");
			}
			else {
				reporter.reportLogFail("The button text is not equal to 'Select size'");
			}
		}

		if(lsType.equalsIgnoreCase("Colour")) {
			if(lsText.equalsIgnoreCase("Select colour")) {
				reporter.reportLogPass("The button text is equal to 'Select colour'");
			}
			else {
				reporter.reportLogFail("The button text is not equal to 'Select colour'");
			}
		}

		//If all displayed size or color are disabled
		if(!checkProductSizeOptionEnabledItemAvailableWithMouseHover(itemContainer)||!checkProductColorOptionEnabledItemAvailableWithMouseHover(itemContainer)) {
			return;
		}

		this.selectedProductItem.productSelectedSize="";
		this.selectedProductItem.productSelectedColor="";
		
		//To check select size
		if(lsType.contains("Size")) {
			bSize=verifySizeOption(itemContainer,lsType);
			if(bSize) {
				element=itemContainer.findElement(BySelectSizeAndColorButton);
				lsText=this.getElementInnerText(element);
				if(lsType.contains("Colour")) {
					if(lsText.equalsIgnoreCase("Select colour")) {
						reporter.reportLogPass("The button text is equal to 'Select colour'");
					}
					else {
						reporter.reportLogFail("The button text is not equal to 'Select colour'");
					}
				}else {
					if(lsText.equalsIgnoreCase("Go to detail page")) {
						reporter.reportLogPass("The button text is equal to 'Go to detail page'");
					}
					else {
						reporter.reportLogFail("The button text is not equal to 'Go to detail page'");
					}
				}
			}			
		}

		//To check select color
		if(lsType.contains("Colour")) {
			bColor=verifyColorOption(itemContainer,lsType);
		}

		if(!bSize||!bColor) {
			return;
		}
		else {
			element=itemContainer.findElement(BySelectSizeAndColorButton);
			lsText=this.getElementInnerText(element);
			if(lsText.equalsIgnoreCase("Go to detail page")) {
				reporter.reportLogPass("The button text is equal to 'Go to detail page'");
			}
			else {
				reporter.reportLogFail("The button text is not equal to 'Go to detail page'");
			}
		}

	}

	private boolean verifySizeOption(WebElement itemContainer,String lsType) {
		if(checkProductSizeOptionEnabledItemAvailableWithMouseHover(itemContainer)) {			
			List<WebElement> optionList=itemContainer.findElements(byProductOptionSizeItemEnabledList);
			WebElement element=optionList.get(optionList.size()-1);
			String lsButtonTextBeforeClickingSize=this.getElementInnerText(itemContainer.findElement(byProductGoToDetails));
			String lsText=this.getElementInnerText(element).replace("Size", "").trim();
			if(element.getTagName().equalsIgnoreCase("button")) {								
				this.clickElement(element);
			}
			else {
				Select sizeSelect= new Select(element.findElement(By.xpath("./parent::select")));
				sizeSelect.selectByIndex(optionList.size()-1);
			}
			
			this.getReusableActionsInstance().staticWait(2000);
			this.waitForCondition(Driver->{return !lsButtonTextBeforeClickingSize.equalsIgnoreCase(this.getElementInnerText(itemContainer.findElement(byProductGoToDetails)));}, 20000);
			this.getReusableActionsInstance().staticWait(3000);
			element=itemContainer.findElement(byProductOptionSizeSelectedSize);
			String lsSelectedTitle=this.getElementInnerText(element);
			this.selectedProductItem.productSelectedSize=lsSelectedTitle;
			if(lsText.equalsIgnoreCase(lsSelectedTitle)) {
				reporter.reportLogPass("The selected size title is displaying correctly");
			}
			else {
				reporter.reportLogFail("The selected size title is not displaying correctly");
			}

			return true;
		}
		return false;
	}
	
	private boolean verifyColorOption(WebElement itemContainer,String lsType) {
		if(checkProductColorOptionEnabledItemAvailableWithMouseHover(itemContainer)) {	
			String lsColor,lsText;
			WebElement element=null;
			int selectNumber=0;
			
			//Bug 19285: Product image not updating when colour is chosen on smartphone or tablet
			String lsImageSrcBeforeClickingColor=itemContainer.findElement(byProductImage).getAttribute("src");
			List<WebElement> optionList=itemContainer.findElements(byProductOptionColorItemEnabledList);
			if(optionList.size()>1) {
				for(WebElement item:optionList) {
					if(item.getTagName().equalsIgnoreCase("button")) {
						String[] itemColorId=item.findElement(By.xpath("./input")).getAttribute("id").split("-");
						lsColor=item.findElement(By.xpath("./input")).getAttribute("id").split("-")[itemColorId.length-1];
					}
					else {
						lsColor=item.getAttribute("value");
					}
					if(!lsImageSrcBeforeClickingColor.contains(lsColor)) {
						element=item;
						break;
					}
					selectNumber++;
				}
			}
			else {
				element=optionList.get(0);
			}
				
			if(element.getTagName().equalsIgnoreCase("button")) {
				lsText=this.getElementInnerText(element).replace("colours", "").trim();
			}
			else {
				element=this.getDriver().findElement(byProductOptionColorSelectedColor);
				lsText=this.getElementInnerText(element);
			}
						
			String lsButtonTextBeforeClickingColor=this.getElementInnerText(itemContainer.findElement(byProductGoToDetails));
			if(element.getTagName().equalsIgnoreCase("button")) {								
				this.clickElement(element);
			}
			else {
				Select sizeSelect= new Select(element.findElement(By.xpath("./parent::select")));
				sizeSelect.selectByIndex(selectNumber);
			}	
			this.getReusableActionsInstance().staticWait(2000);
			this.waitForCondition(Driver->{return !lsButtonTextBeforeClickingColor.equalsIgnoreCase(this.getElementInnerText(itemContainer.findElement(byProductGoToDetails)));}, 20000);
			this.getReusableActionsInstance().staticWait(3000);
			
			if(optionList.size()>1) {
				String lsImageSrcAfterClickingColor=itemContainer.findElement(byProductImage).getAttribute("src");
				if(!lsImageSrcBeforeClickingColor.equalsIgnoreCase(lsImageSrcAfterClickingColor)) {
					reporter.reportLogPass("The image is changing after choosing a different style");
				}
				else {
					reporter.reportLogFail("The image is not changing after choosing a different style");
				}
			}
						
			element=itemContainer.findElement(byProductOptionColorSelectedColor);
			String lsSelectedTitle=this.getElementInnerText(element);
			this.selectedProductItem.productSelectedColor=lsSelectedTitle;
			if(lsText.equalsIgnoreCase(lsSelectedTitle)) {
				reporter.reportLogPass("The selected color title is displaying correctly");
			}
			else {
				reporter.reportLogFail("The selected color title is not displaying correctly");
			}
			return true;
		}
		return false;
	}
	
	/**
	 * This method will verify information linkage between selected PRP and PDP
	 * @param-ProductDetailPage pdp: the related PDP to adapt to different devices
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyInfoLinkageWithPDP(ProductDetailPage pdp) {
		WebElement itemContainer=this.productResultList.get(0);
		String lsSelectedTitle,lsType;

		this.selectedProductItem.productSelectedSize="";
		this.selectedProductItem.productSelectedColor="";

		lsType=this.judgeProductOptionType(itemContainer);

		//If all displayed size or color are disabled
		if(!checkProductSizeOptionEnabledItemAvailableWithMouseHover(itemContainer)||!checkProductColorOptionEnabledItemAvailableWithMouseHover(itemContainer)) {
			reporter.reportLog("No enabled size/color opion available");
			return;
		}

		//To check selected size
		if(lsType.contains("Size")) {
			verifySizeOption(itemContainer,lsType);			
		}

		//To check selected color
		if(lsType.contains("Colour")) {
			verifyColorOption(itemContainer,lsType);			
		}

		itemContainer.findElement(this.byProductGoToDetails).click();
		this.waitForPDPPageLoading();

		String lsProductName=pdp.getElementInnerText(pdp.lblProductName);
		if(lsProductName.equalsIgnoreCase(this.selectedProductItem.productName)) {
			reporter.reportLogPass("The product name in PRP is the same as the one displayed in PDP");
		}
		else {
			reporter.reportLogFail("The product name in PRP is not the same as the one displayed in PDP");
		}

		if(!this.selectedProductItem.productBrand.isEmpty()) {
			String lsProductBrand=pdp.getElementInnerText(pdp.lnkBrandName);
			if(lsProductBrand.toUpperCase().contains(this.selectedProductItem.productBrand.toUpperCase())) {
				reporter.reportLogPass("The product brand in PRP is the same as the one displayed in PDP");
			}
			else {
				reporter.reportLogFail("The product brand of "+this.selectedProductItem.productBrand+" in PRP is not the same as "+lsProductBrand+" displayed in PDP");
			}
		}

		String lsProductNowPrice=pdp.getElementInnerText(pdp.lblProductNowPrice);
		if(lsProductNowPrice.equalsIgnoreCase(this.selectedProductItem.productNowPrice)) {
			reporter.reportLogPass("The product NowPrice in PRP is the same as the one displayed in PDP");
		}
		else {
			reporter.reportLogFail("The product NowPrice in PRP is not the same as the one displayed in PDP");
		}

		String lsProductWasPrice=pdp.getElementInnerText(pdp.lblProductWasPrice);
		if(lsProductWasPrice.equalsIgnoreCase(this.selectedProductItem.productWasPrice)) {
			reporter.reportLogPass("The product WasPrice in PRP is the same as the one displayed in PDP");
		}
		else {
			reporter.reportLogFail("The product WasPrice in PRP is not the same as the one displayed in PDP");
		}

		if(!this.selectedProductItem.productSelectedSize.isEmpty()) {
			Select sizeOption=new Select(pdp.selectSizeOption);
			lsSelectedTitle=sizeOption.getFirstSelectedOption().getText().trim();
			if(lsSelectedTitle.equalsIgnoreCase(this.selectedProductItem.productSelectedSize)) {
				reporter.reportLogPass("The selected size in PRP is the same as the one displayed in PDP");
			}
			else {
				reporter.reportLogFail("The selected size in PRP is not the same as the one displayed in PDP");
			}
		}

		if(!this.selectedProductItem.productSelectedColor.isEmpty()) {
			if(pdp.judgeStyleDisplayModeIsDropdownMenu()) {
				if(this.getElementText(pdp.selectProductStyle).equalsIgnoreCase(this.selectedProductItem.productSelectedColor)) {
					reporter.reportLogPass("The selected color in PRP is the same as the one displayed in PDP");
				}
				else {
					reporter.reportLogFail("The selected color in PRP is not the same as the one displayed in PDP");
				}
			}
			else {
				if(this.getElementText(pdp.lblRadioProductStyleTitle).equalsIgnoreCase(this.selectedProductItem.productSelectedColor)) {
					reporter.reportLogPass("The selected color in PRP is the same as the one displayed in PDP");
				}
				else {
					reporter.reportLogFail("The selected color in PRP is not the same as the one displayed in PDP");
				}
			}
		}
	}

	/**
	 * This method will verify information linkage between selected PRP without swatch and PDP
	 * @param-ProductDetailPage pdp: the related PDP to adapt to different devices
	 * @return void
	 */
	public void verifyInfoLinkageWithPDPWithoutSwatch(WebElement webElement,int index){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
		this.getReusableActionsInstance().scrollToElement(webElement);

		WebElement itemContainer=webElement;

		List<WebElement> optionList;
		WebElement element;
		String lsButtonTextBeforeClickingSize;

		//Selecting size for webElement
		optionList=itemContainer.findElements(byProductOptionSizeItemEnabledList);
		element=optionList.get(optionList.size()-1);
		lsButtonTextBeforeClickingSize=this.getElementInnerText(itemContainer.findElement(byProductGoToDetails));
		this.clickElement(element);
		String finalLsButtonTextBeforeClickingSize = lsButtonTextBeforeClickingSize;
		this.waitForCondition(Driver->{return !finalLsButtonTextBeforeClickingSize.equalsIgnoreCase(this.getElementInnerText(itemContainer.findElement(byProductGoToDetails)));}, 20000);
		this.getReusableActionsInstance().staticWait(3000);

		//Selecting color for webElement from Dropdown
		optionList=itemContainer.findElements(byProductOptionColorItemEnabledList);
		element=optionList.get(optionList.size()-1);
		List<WebElement> colorList = getDriver().findElements(this.byProductOptionColorDropDown);
		Select select = new Select(colorList.get(index));
		select.selectByVisibleText(element.getText());
		this.getReusableActionsInstance().staticWait(3000);

		itemContainer.findElement(this.byProductGoToDetails).click();
		this.waitForPDPPageLoading();
		if(this.URL().toLowerCase().contains("productdetails")) {
			reporter.reportLogPass("The user is navigated to PDP page");
		}
		else {
			reporter.reportLogFail("The user is not navigated to PDP page");
		}
	}

	/**
	 * This method will verify Favorite Icon clicking Action
	 * @param-String lsUserName: user name
	 * @param-String lsPassword: password
	 * @param-String lsFirstName: user's first name
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyFavoriteIconAction(String lsUserName, String lsPassword,String lsFirstName,String lsKeyword) {
		if(this.productResultList.size()==0) {
			reporter.reportLog("No product search result available.");
			return;
		}

		LoginPage loginPage=new LoginPage(this.getDriver());
		WebElement item=this.productResultList.get(0).findElement(this.byProductHeaderLike);
		String lsFirstProductName=this.getElementInnerText(this.productResultList.get(0).findElement(this.byProductName));

		if(item.getAttribute("aria-pressed").equalsIgnoreCase("false")) {
			reporter.reportLogPass("The favorite icon is displaying not clicking status correctly");
		}
		else {
			reporter.reportLogFail("The favorite icon is not displaying not clicking status correctly");
		}

		this.getReusableActionsInstance().clickIfAvailable(item);
		this.getReusableActionsInstance().waitForElementVisibility(loginPage.lblSignIn, 20);

		loginPage.LoginWithoutWaitingTime(lsUserName, lsPassword);
		this.getReusableActionsInstance().waitForElementVisibility(loginPage.lblSignInGlobalResponseBanner);

		this.getSearchResultLoad(lsFirstProductName,true);
		item=this.productResultList.get(0).findElement(this.byProductHeaderLike);

		if(item.getAttribute("aria-pressed").equalsIgnoreCase("true")) {
			clearFavoriteHistory();
			this.getSearchResultLoad(lsKeyword,true);
			item=this.productResultList.get(0).findElement(this.byProductHeaderLike);
		}

		this.getReusableActionsInstance().clickIfAvailable(item);
		this.getReusableActionsInstance().staticWait(3000);

		if(item.getAttribute("aria-pressed").equalsIgnoreCase("true")) {
			reporter.reportLogPass("The favorite icon is displaying clicking status correctly");
		}
		else {
			reporter.reportLogFail("The favorite icon is not displaying clicking status correctly");
		}
	}

	/**
	 * This method will check Product Item brand name Existing
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductItemBrandNameExisting(WebElement itemContainer) {
		WebElement item=itemContainer.findElement(this.byProductBrand);
		String lsText=item.getText().trim();

		return !lsText.isEmpty();
	}

	/**
	 * This method will check Product Item review Existing
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductItemReviewExisting(WebElement itemContainer) {
		WebElement item=itemContainer.findElement(this.byProductReviewContainer);

		return this.getChildElementCount(item)>0;
	}

	/**
	 * This method will check Product Item review Existing
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductItemWasPriceExisting(WebElement itemContainer) {
		WebElement priceContainer=itemContainer.findElement(this.byJudgeProductWasPrice);

		return this.getChildElementCount(priceContainer)>1;
	}



	/**
	 * This method will check See More button and See Less button
	 * @param-WebElement filterContainerItem: filter Container Item
	 * @return String option
	 * @author Wei.Li
	 */
	public String checkFilterItemSeeButtonExisting(WebElement filterContainerItem) {
		WebElement item=filterContainerItem.findElement(this.bySecondaryFilterSeeButtonText);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		String lsText=item.getText().trim();

		if(lsText.isEmpty()){
			return "None";
		}

		if(lsText.toLowerCase().contains("see more")){
			return "SeeMore";
		}

		if(lsText.toLowerCase().contains("see less")){
			return "SeeLess";
		}

		return "None";
	}

	/**
	 * This method will get Selected Item Amount From the Filter Title
	 * @param-WebElement itemContainer: Filter title item
	 * @return int
	 * @author Wei.Li
	 */
	public int getSelectedItemAmountFromFilterTitle(WebElement filterTitle) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(filterTitle);
		String lsTitle=filterTitle.getText().trim();

		return this.getIntegerFromString(lsTitle);
	}

	/**
	 * This method will check If Filter Item Is Collapsed
	 * @param-WebElement filterContainerItem: filter Container Item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkIfFilterItemIsCollapsed(WebElement filterContainerItem) {
		WebElement item=filterContainerItem.findElement(this.bySecondaryFilterOpenOrCloseFlag);
		return !item.getAttribute("class").contains("plp-filter-panel__block-title__icon--plus");
	}

	/**
	 * This method will expand a specific Filter Item
	 * @param-WebElement filterContainerItem: filter Container Item
	 * @return void
	 * @author Wei.Li
	 */
	public void expandFilterItem(WebElement filterContainerItem) {
		if(checkIfFilterItemIsCollapsed(filterContainerItem)) {
			clickSeeMoreButton(filterContainerItem);
			return;
		}

		WebElement productFilterTitle=filterContainerItem.findElement(this.byProductFilterTitle);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productFilterTitle);
		this.getReusableActionsInstance().clickIfAvailable(productFilterTitle);
		this.getReusableActionsInstance().staticWait(1000);

		clickSeeMoreButton(filterContainerItem);
	}

	/**
	 * This method will uncollapse a specific Filter Item through clicking product title
	 * @param-WebElement filterContainerItem: filter Container Item
	 * @return void
	 * @author Wei.Li
	 */
	public void uncollapseFilterItemWithClickingProductTitle(WebElement filterContainerItem) {
		if(!checkIfFilterItemIsCollapsed(filterContainerItem)) {
			return;
		}

		WebElement productFilterTitle=filterContainerItem.findElement(this.byProductFilterTitle);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productFilterTitle);
		this.getReusableActionsInstance().clickIfAvailable(productFilterTitle);
		this.getReusableActionsInstance().staticWait(1000);
	}

	/**
	 * This method will collapse a specific Filter Item through clicking product title
	 * @param-WebElement filterContainerItem: filter Container Item
	 * @return void
	 * @author Wei.Li
	 */
	public void collapseFilterItemWithClickingProductTitle(WebElement filterContainerItem) {
		if(checkIfFilterItemIsCollapsed(filterContainerItem)) {
			return;
		}

		WebElement productFilterTitle=filterContainerItem.findElement(this.byProductFilterTitle);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productFilterTitle);
		this.getReusableActionsInstance().clickIfAvailable(productFilterTitle);
		this.getReusableActionsInstance().staticWait(1000);
	}

	/**
	 * This method will expand all Filters
	 * @return void
	 * @author Wei.Li
	 */
	public void expandAllFilters() {
		for(WebElement item:this.productFilterContainerList) {
			expandFilterItem(item);
		}
	}

	/**
	 * This method will click the See More button for a specific Filter Item
	 * @param-WebElement filterContainerItem: filter Container Item
	 * @return void
	 * @author Wei.Li
	 */
	public void clickSeeMoreButton(WebElement filterContainerItem) {
		String lsButtonType=this.checkFilterItemSeeButtonExisting(filterContainerItem);
		if(lsButtonType.equalsIgnoreCase("SeeMore")) {
			WebElement seeMoreButton=filterContainerItem.findElement(this.bySecondaryFilterSeeMoreButton);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(seeMoreButton);
			this.getReusableActionsInstance().clickIfAvailable(seeMoreButton);
			this.getReusableActionsInstance().staticWait(1000);
		}
	}

	/**
	 * This method will click the See Less button for a specific Filter Item
	 * @param-WebElement filterContainerItem: filter Container Item
	 * @return void
	 * @author Wei.Li
	 */
	public void clickSeeLessButton(WebElement filterContainerItem) {
		String lsButtonType=this.checkFilterItemSeeButtonExisting(filterContainerItem);
		if(lsButtonType.equalsIgnoreCase("SeeLess")) {
			WebElement seeLessButton=filterContainerItem.findElement(this.bySecondaryFilterSeeLessButton);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(seeLessButton);
			this.getReusableActionsInstance().clickIfAvailable(seeLessButton);
			this.getReusableActionsInstance().staticWait(1000);
		}
	}

	/**
	 * This method will get Selected SubFilter Amount for a specific Filter Item
	 * @param-WebElement filterContainerItem: filter Container Item
	 * @return int
	 * @author Wei.Li
	 */
	public int getSelectedSubFilterAmount(WebElement filterContainerItem) {
		WebElement productFilterTitle=filterContainerItem.findElement(this.byProductFilterTitle);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productFilterTitle);
		String lsText=productFilterTitle.getText().trim();

		if(!lsText.contains("(")&&!lsText.contains(")")) {
			return 0;
		}
		else {
			return this.getIntegerFromString(lsText);
		}
	}

	/**
	 * This method will check Search Input Button Existing In SubFilter for a specific Filter Item
	 * @param-WebElement filterContainerItem: filter Container Item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkSearchInputButtonExistingInSubFilter(WebElement filterContainerItem) {
		WebElement searchInputContainer=filterContainerItem.findElement(this.byProductFilterSearchContainer);
		return this.checkChildElementExistingByTagNameAndAttribute(searchInputContainer, "input", "class", "plp-filter-panel__search");
	}

	/**
	 * This method will check ViewAllSizes Button Existing
	 * @param-WebElement filterContainerItem: filter Container Item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkViewAllSizesButtonExisting(WebElement filterContainerItem) {
		WebElement sizeContainer=filterContainerItem.findElement(this.byProductOptionSizeWrapper);
		return this.checkChildElementExistingByTagNameAndAttribute(sizeContainer, "a", "class", "product-card__size-view-all");
	}

	/**
	 * This method will check no-history-container Existing
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkNoFavoriteHistoryContainerExisting() {
		return this.checkChildElementExistingByAttribute(cntMyFavouritesContainer, "class", "no-history-container");
	}

	public void clearFavoriteHistory() {
		WebElement favoriteLink= (new GlobalHeaderPage(this.getDriver())).Favouriteslnk;
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(favoriteLink);
		this.getReusableActionsInstance().clickIfAvailable(favoriteLink);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblMyFavouritesTitle, 20);

		if(checkNoFavoriteHistoryContainerExisting()) {
			return;
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnClearAllFavouriteHistory);
		this.getReusableActionsInstance().clickIfAvailable(this.btnClearAllFavouriteHistory);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblTitleInClearMyFavouritesPopupWindow, 20);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnClearInClearMyFavouritesPopupWindow);
		this.getReusableActionsInstance().clickIfAvailable(this.btnClearInClearMyFavouritesPopupWindow);
		this.getReusableActionsInstance().waitForElementVisibility(this.btnShoppingNow, 20);
	}

	/**
	 * This method will check with element has both size and colour available
	 * @param-WebElement webElement - parent webElement
	 * @return boolean
	*/
	public boolean findItemWithAvailableSizeAndColorDropDown(WebElement webElement){
		WebElement expectedWebElement = webElement.findElement(this.byProductSizeAndColour);
		if(this.checkChildElementExistingByTagName(expectedWebElement,"li")){
			long childElementCount = this.getChildElementCount(expectedWebElement);
			if(childElementCount==Long.valueOf(2)){
				WebElement dropDownItemList = webElement.findElement(this.byProductOptionColorDropDown);
				if(this.checkChildElementExistingByTagName(dropDownItemList,"option"))
					return true;
			}
		}
		return false;
	}

	/**
	 * This method will check all elements present on page is of particular brand
	 * @param-String - brand name to search on PRP page
	 * @return boolean
	 */
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__applied-filters']/button/span")
	public List<WebElement> lstFilterApplied;

	public void verifyProductsOnPRPByBrandName(String brandName){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lstFilterApplied.get(0));

		//Defining and initializing variables
		boolean filterBrandNameFlag = false;
		String filterName = null,lsBrandName;
		List<WebElement> productList;
		WebElement item,element;

		for(int counter=0;counter<lstFilterApplied.size();counter++){
			filterName = lstFilterApplied.get(counter).getText();
			if(brandName.toLowerCase().trim().equals(filterName.toLowerCase().trim())){
				filterBrandNameFlag = true;
				break;
			}
		}
		//Verifying brand name in filter
		if(filterBrandNameFlag)
			reporter.reportLogPass("Brand Name on PDP page i.e. "+brandName+" is same as in filter on PRP page: "+filterName);
		else
			reporter.reportLogFail("Brand Name on PDP page i.e. "+brandName+" is not same as in filter on PRP page: "+filterName);

		//Verifying product on page are of same selected brand
		productList=this.getProductList();
		for(int brandNameCounter=0;brandNameCounter<productList.size();brandNameCounter++) {
			item=productList.get(brandNameCounter);
			element=item.findElement(byProductBrand);
			lsBrandName=this.getElementInnerText(element).split("By ")[1];
			if(lsBrandName.toLowerCase().trim().equals(brandName.toLowerCase().trim()))
				reporter.reportLogPass("Brand name of product on PRP page: "+lsBrandName+" is same as on PDP page: "+brandName);
			else
				reporter.reportLogFail("Brand name of product on PRP page: "+lsBrandName+" is not same as on PDP page: "+brandName);
		}
	}


	public class ProductItem{
		public String productNumber;
		public String productName;
		public String productBrand;
		public String productSelectedSize;
		public String productSelectedColor;
		public String productNowPrice;
		public String productWasPrice;
		public String productNavigationUrl;
		public int currentProductSequenceNumber;

		public ProductItem() {
			this.productNumber="";
			this.productName="";
			this.productBrand="";
			this.productSelectedSize="";
			this.productSelectedColor="";
			this.productNowPrice="";
			this.productWasPrice="";
			this.productNavigationUrl="";
			this.currentProductSequenceNumber=0;
		}

		public void init() {
			this.productNumber="";
			this.productName="";
			this.productBrand="";
			this.productSelectedSize="";
			this.productSelectedColor="";
			this.productNowPrice="";
			this.productWasPrice="";
			this.productNavigationUrl="";
			this.currentProductSequenceNumber=0;
		}
	}
}

