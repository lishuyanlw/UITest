package com.tsc.pages;

import com.tsc.api.apiBuilder.ProductAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import java.util.*;

import org.openqa.selenium.By;
import com.tsc.api.pojo.Product;
import com.tsc.api.pojo.SelectedProduct;
import com.tsc.pages.base.BasePage;

public class ProductResultsPage extends BasePage{
	public ProductResultsPage(WebDriver driver) {
		super(driver);
	}

	//Search results return message
	@FindBy(xpath = "//section[@class='tsc-container']//*[@class='prp__showing-results']|//section[@class='tsc-container']//div[@class='prp-no-search-results__copy__heading']")
	public WebElement lblSearchResultMessage;

	@FindBy(xpath = "//span[contains(@class,'tagDimTitle')]")
	public WebElement lblSearchResultMessageKeyWordTitle;

	@FindBy(xpath = "//section[@class='tsc-container']//*[@class='prp__showing-results']")
	public WebElement lblReturnMessageWithSearchResult;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-no-search-results__copy__heading']")
	public WebElement lblReturnMessageHeadingWithoutSearchResult;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-no-search-results__icon']")
	public WebElement lblReturnMessageIconWithoutSearchResult;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-no-search-results__copy__text']")
	public WebElement lblReturnMessageTextWithoutSearchResult;

	@FindBy(xpath = "//section[@class='tsc-container']//button[@class='prp-no-search-results__copy__link']")
	public WebElement btnReturnMessageRetryLinkWithoutSearchResult;

	//Search title
	@FindBy(xpath = "//span[contains(@class,'tagDimTitle')]")
	public WebElement lblSearchResultTitle;

	@FindBy(xpath = "//div[contains(@class,'ProductResults')]//section[@class='tsc-container']//*[@class='prp__showing-results']")
	public WebElement lblSearchResultTitleMessage;

	@FindBy(xpath = "//div[contains(@class,'ProductResults')]//section[@class='tsc-container']")
	public WebElement cntSearchResultContainer;

	@FindBy(xpath = "//div[contains(@class,'ProductResults')]//section[@class='tsc-container']//div[contains(@class,'product-count')]")
	public WebElement lblProductCountOnPage;

	//Navigation list
	@FindBy(xpath = "//section[@class='tsc-container']//nav[@class='breadcrumb__nav']//li")
	public List<WebElement> lstSearchResultNavigation;

	@FindBy(xpath = "//div[@class='Header']//div[contains(@class,'Breadcrumb')]/div")
	public WebElement lblBreadcrumbNavigation;

	@FindBy(xpath="//div[@class='Header']//div[contains(@class,'Breadcrumb')]/div//li[@class='breadcrumb__nav-item']//*/span")
	public WebElement lblBreadcrumbLastProductName;

	@FindBy(xpath = "//div[@class='Middle']")
	public WebElement cntSearchResultTitleContainer;

	@FindBy(xpath = "//div[contains(@class,'showstopper-wrapper')]//div[contains(@class,'item')]//div[contains(@class,'visible')]//img")
	public List<WebElement> lstBannerImage;

	//Product message showing
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__pagination-desc']//span[@class='prp__pagination-desc__display-text']")
	public WebElement lblShowing;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__pagination-desc']//span[@class='prp__pagination-desc__product-count-text']")
	public WebElement txtShowingDynamicContent;

	//Sort part
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__count-and-shorting__product-count']")
	public WebElement lblProductCountMessage;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__count-and-shorting']//select[@class='prp__count-and-shorting__shorting']")
	public WebElement btnSortSelect;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__count-and-shorting']//select[@class='prp__count-and-shorting__shorting']//option")
	public List<WebElement> sortByOptionList;

	//For Sorting and Filtering page loading indicator
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp']")
	public WebElement cntSortingAndFilteringProductResultLoadingIndicator;

	@FindBy(xpath = "//div[@class='ProductResultsReact']//section[@class='tsc-container'][not(nav)][not(*[@class='breadcrumb'])]")
	public WebElement cntTSCContainer;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp']//div[@class='prp__wrapper']")
	public WebElement cntProductResultListContainer;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp']//div[@class='prp__product-grid']//div[contains(@class,'prp-card-grid-item')]//div[@class='product-card']")
	public List<WebElement> productResultList;

	public By byProductSizeAndColour=By.xpath(".//div[contains(@class,'product-card__option-button')]/ul");
	//Selected filters
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__wrapper']")
	public WebElement cntSelectedFilters;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__applied-filters']//button")
	public List<WebElement> selectedFiltersList;

	public By byProductHeaderTitleContainer=By.xpath(".//*[@class='product-card__header']");

	public By byProductHeaderTitle=By.xpath(".//*[@class='product-card__header-title']");

	public By byProductHeaderLike=By.xpath(".//*[contains(@class,'product-card__header-like')]");

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
	public By byProductOptionSize=By.xpath(".//fieldset[legend[.='sizes']]");

	public By byProductOptionSizeTitle=By.xpath(".//fieldset//span[@class='product-card__size-title']");

	public By byProductOptionSizeSelectedSizeContainer=By.xpath(".//fieldset//span[@class='product-card__size-title']");

	public By byProductOptionSizeSelectedSize=By.xpath(".//fieldset//span[@class='product-card__size-title']//strong");

	public By byProductOptionSizeWrapper=By.xpath(".//fieldset//div[@class='product-card__size-wrapper']");

	public By byProductOptionSizeItemList=By.xpath(".//fieldset//div[contains(@class,'product-card__size-items')]//button|.//fieldset//select[contains(@class,'product-card__size__dropdown')]//option");

	public By byProductOptionSizeItemEnabledList=By.xpath(".//fieldset//div[contains(@class,'product-card__size-items')]//button[not(@disabled)]|.//fieldset//select[contains(@class,'product-card__size__dropdown')]//option[not(@disabled)]");

	public By byProductOptionSizeItemDisabledList=By.xpath(".//fieldset//div[contains(@class,'product-card__size-items')]//button[@disabled]|.//fieldset//select[contains(@class,'product-card__size__dropdown')]//option[@disabled]");

	public By byProductOptionSizeSelectedItem=By.xpath(".//fieldset//div[contains(@class,'product-card__size-items')]//button[@aria-pressed='true']|.//fieldset//select[contains(@class,'product-card__size__dropdown')]//option[@selected]");

	public By byProductOptionSizeViewAllSizes=By.xpath(".//fieldset//a[@class='product-card__size-view-all']");

	public By byProductOptionSizeNiceSelectList=By.xpath(".//fieldset//select[contains(@class,'product-card__size__dropdown')]/following-sibling::div[@class='niceSelect__container']//ul/li/button");

	public By byProductOptionSizeNiceSelectButton=By.xpath(".//fieldset//select[contains(@class,'product-card__size__dropdown')]/following-sibling::div[@class='niceSelect__container']//button[@id='niceSelect-nsSizeTaste-selected']");

	//For color option
	public By byProductOptionColor=By.xpath(".//fieldset[legend[.='styles']]");

	public By byProductOptionColorTitle=By.xpath(".//fieldset//p[@class='product-card__color-and-taste-title']");

	public By byProductOptionColorSelectedColorContainer=By.xpath(".//fieldset//p[@class='product-card__color-and-taste-title']");

	public By byProductOptionColorSelectedColor=By.xpath(".//fieldset//p[@class='product-card__color-and-taste-title']//strong");

	public By byProductOptionColorWrapper=By.xpath(".//fieldset//div[@class='product-card__color-and-taste-wrapper']");

	public By byProductOptionColorItemList=By.xpath(".//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button|.//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]//option");

	public By byProductOptionColorDropDown=By.xpath(".//fieldset//select[@class='product-card__color-and-taste__dropdown']");

	public By byProductOptionColorItemEnabledList=By.xpath(".//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[not(@disabled)]|.//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]//option[not(@disabled)]");

	public By byProductOptionColorItemDisabledList=By.xpath(".//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@disabled]|.//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]//option[@disabled]");

	public By byProductOptionColorSelectedItem=By.xpath(".//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@aria-pressed='true']|.//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]//option[not(@selected)]");

	public By byProductOptionColorViewAllColors=By.xpath(".//fieldset//a[@class='product-card__color-view-all']");

	public By byProductOptionColorNiceSelectList=By.xpath(".//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]/following-sibling::div[@class='niceSelect__container']//ul/li/button");

	public By byProductOptionColorNiceSelectButton=By.xpath(".//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]/following-sibling::div[@class='niceSelect__container']//button[@id='niceSelect-nsColourTaste-selected']");

	//For product details
	public By byProductName=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//a[@class='product-card__info-pname']");

	public By byProductBrand=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//p[@class='product-card__info-brand']");

	public By byProductNowPrice=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//div[@class='product-card__info-price']//a[@class='product-card__info-price__is-price']/span[1]");

	public By byProductWasPrice=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//div[@class='product-card__info-price']//a[@class='product-card__info-price__is-price']/span[@class='product-card__info-price__was-price']");

	public By byJudgeProductWasPrice=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//div[@class='product-card__info-price']//a[@class='product-card__info-price__is-price']");

	public By byProductReviewContainer=By.xpath(".//div[@class='product-card__reviews']");

	public By byProductReviewRatingImage=By.xpath(".//div[@class='product-card__reviews']//span[@class='product-card__rating']//span[contains(@class,'product-card__rating__star')]");

	public By byProductReviewRatingCount=By.xpath(".//div[@class='product-card__reviews']//a[@class='product-card__reviews-count']");
	
	public By byProductFreeShipping=By.xpath(".//div[@class='product-card__free-shipping']");

	public By byProductGoToDetails=By.xpath(".//button[@class='product-card__add-button']");

	//Pagination
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__pagination']")
	public WebElement cntPagination;
	public By byPagination=By.xpath("//section[@class='tsc-container']//div[@class='prp__pagination']");

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__pagination']//div[@class='prp__pagination__pages']//a")
	public List<WebElement> PageNumberList;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__pagination']")
	public WebElement cntPreAndNextButtonPage;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__pagination']//a[@class='prp__pagination__prev-link']")
	public WebElement btnPreviousPage;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__pagination']//a[@class='prp__pagination__next-link']")
	public WebElement btnNextPage;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__pagination']//div[@class='prp__pagination__pages']//a[contains(@class,'prp__pagination__pages__page--current')]")
	public WebElement btnCurrentPage;

	//Product title and text
	@FindBy(xpath = "//div[@class='PageOneColumn']//div[@class='Middle']")
	public WebElement cntProductTitleAndTextIdentifier;

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
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__blocks']")
	public List<WebElement> productFilterContainerList;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__blocks']//button[@class='prp-filter-panel__block-title']")
	public List<WebElement> productFilterList;

	public By byProductFilterSearchContainer=By.xpath("./div");

	public By byProductFilterSearchInput=By.xpath("./div/input[@class='prp-filter-panel__search']");

	public By byProductFilterTitle=By.xpath(".//button[@class='prp-filter-panel__block-title']");

	public By bySecondaryFilterOpenOrCloseFlag=By.xpath(".//button[@class='prp-filter-panel__block-title']//div[contains(@class,'prp-filter-panel__block-title__icon')]");

	public By bySecondaryFilterAll=By.xpath(".//ul[@class='prp-filter-panel__filter-list' or @class='prp-filter-panel__back-list' or @class='prp-filter-panel__sub-categories']//li");

	public By bySecondaryFilterAllWithoutCategory=By.xpath(".//ul[@class='prp-filter-panel__filter-list' or @class='prp-filter-panel__back-list' or @class='prp-filter-panel__sub-categories']//li[button[input[@type='checkbox']]]");

	public By bySecondaryFilterUnChecked=By.xpath(".//ul[@class='prp-filter-panel__filter-list']//li[button[input[not(@checked)]]]");

	public By bySecondaryFilterChecked=By.xpath(".//ul[@class='prp-filter-panel__filter-list']//li[button[input[@checked]]]");

	public By bySecondaryFilterSeeButtonText=By.xpath(".//button[contains(@class,'prp-filter-panel__view-more')]//span");

	public By bySecondaryFilterSeeMoreButton=By.xpath(".//button[contains(@class,'prp-filter-panel__view-more')][span[normalize-space(.)='See More']]");

	public By bySecondaryFilterSeeLessButton=By.xpath(".//button[contains(@class,'prp-filter-panel__view-more')][span[normalize-space(.)='See Less']]");

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__blocks']//ul[@class='prp-filter-panel__filter-list']//li[button[input[not(@checked)]]]")
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
	@FindBy(xpath = "//div[@id='product-recommend']//h2[@class='recommend__header']")
	public WebElement productRecommendationTitle;

	@FindBy(xpath="//div[@id='product-recommend']//div[@class='recommend__products']//div[@class='recommend__products__item']")
	public List<WebElement> lstPeopleAlsoBoughtItems;

	public By byRecommendationLink = By.xpath(".//a");

	public By byRecommendationName=By.xpath(".//div[@class='recommend__products__item--name']");

	public By byRecommendationBrand=By.xpath(".//div[@class='recommend__products__item--brand']");

	public By byRecommendationPriceContainer=By.xpath(".//div[@class='recommend__products__price']");

	public By byRecommendationNowPrice=By.xpath(".//div[@class='recommend__products__price--now-price']");

	public By byRecommendationWasPrice =By.xpath(".//del[@class='recommend__products__price--was-price']");

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

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__applied-filters']/button/span")
	public List<WebElement> lstFilterApplied;

	@FindBy(xpath = "//div[@class='Middle']//div[contains(@class,'DimensionTitle')]//*[contains(@class,'DimTitle')]")
	public WebElement lstFilterApplied_Mobile;

	public By sizeSelected = By.xpath(".//form[contains(@class,'product-card__main')]//span[contains(@class,'size-title')]");

	public By lstColourDropdown = By.xpath(".//form//div//select[@id='nsColourTaste']");

	public By btnColorSelectionDropdown = By.xpath(".//form//div//button[contains(@id,'nsColourTaste-selected')]");

	public By btnEnabledColorInDropdown = By.xpath(".//form//div//ul[contains(@id,'nsColourTaste-ul')]/li/button[not(@disabled)]");

	String searchkeyword;
	public boolean bVerifyTitle=true;
	public String firstLevelFilter,secondLevelFilter;
	public boolean bDefault=false,bCategoryExpand=false;
	public String lsSearchResultMessage="";
	public ProductItem selectedProductItem= new ProductItem();


	/**
	 * This method will load search result popup after entering search keyword
	 * @return true/false
	 * @author Wei.Li
	 */
	public void getSearchResultPopUpWindowLoad(String searchKeyword) {
		GlobalHeaderPage globalHeader=new GlobalHeaderPage(this.getDriver());
		waitForCondition(Driver->{
			return globalHeader.searchBox.isDisplayed();
		},90000);
		String[] data = searchKeyword.codePoints().mapToObj(cp->new String(Character.toChars(cp))).toArray(size->new String[size]);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeader.searchBox);
		this.getReusableActionsInstance().clickIfAvailable(globalHeader.searchBox,3000);
		for(String inputText:data){
			globalHeader.searchBox.sendKeys(inputText);
			//For thinking time to wait for backend response
			this.getReusableActionsInstance().staticWait(100);
		}

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
			//For thinking time for waiting for backend response
			this.getReusableActionsInstance().staticWait(100);
		}

		waitForCondition(Driver->{
			return this.searchResultSection.isDisplayed();
		},150000);

		//Bug-19680 - Change the placeholder text in the brand section - Search Product using magnifying glass icon
		if(clickEnterButtonFromKeyboard) {
			try{
				super.pressEnterKey(globalHeader.searchBox);
			}
			catch(Exception e){

			}
		}
		else {
			globalHeader.validateSearchSubmitbtn();
			try{
				this.getReusableActionsInstance().clickIfAvailable(globalHeader.btnSearchSubmit);
			}
			catch (Exception e){

			}
		}
		this.waitForPageToLoad();

		if(searchKeyword.matches("\\d+")){
			ProductDetailPage pdp= new ProductDetailPage(this.getDriver());
			try{
				this.getReusableActionsInstance().waitForElementVisibility(pdp.lblProductName,120);
			}
			catch(Exception e){

			}
		}
		else{
			this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,120);
		}

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
			//For thinking time to wait for backend response
			getReusableActionsInstance().staticWait(100);
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
		getReusableActionsInstance().scrollToElement(this.lblShowing);
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
		getReusableActionsInstance().scrollToElement(this.lblSearchResultMessage);

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
			reporter.reportLogFailWithScreenshot("The product results are existing");
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
		if(this.URL().toLowerCase().contains("productdetails")){
			return "ProductNumberSearch";
		}

		if(!this.checkProductResultExisting()) {
			return "NoSearchResult";
		}

		if(!this.lblBreadcrumbNavigation.getCssValue("height").equalsIgnoreCase("0px")){
			return "BannerImageSearch";
		}

		return "NormalSearch";
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
			if(lsUrl.toLowerCase().contains("searchterm=")) {
				return lsUrl.toLowerCase().contains("dimensions=")&&lsUrl.toLowerCase().contains("searchterm=")&&lsUrl.contains(this.getEncodingKeyword(lsKeyword));
			}
			else {
				return lsUrl.toLowerCase().contains("dimensions=");
			}			
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
		String lsUrl=this.URL().toLowerCase();
		return lsUrl.contains("searchterm=")&&lsUrl.contains(this.getEncodingKeyword(lsKeyword.toLowerCase()))&&lsUrl.contains("sortkey="+lsSortKey.toLowerCase());
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
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductTitleAndTextMoreOrLess);
			getReusableActionsInstance().clickIfAvailable(this.btnProductTitleAndTextMoreOrLess);
			this.waitForCondition(Driver->{return this.btnProductTitleAndTextMoreOrLess.getAttribute("class").isEmpty();}, 20000);

			if(!this.getElementInnerText(this.btnProductTitleAndTextMoreOrLess).contains("Read Less")) {
				return false;
			}
			else {
				//This wait is for button text changes in DOM, need to be kept.
				getReusableActionsInstance().staticWait(2000);
				this.clickElement(this.btnProductTitleAndTextMoreOrLess);
				this.waitForCondition(Driver->{return this.btnProductTitleAndTextMoreOrLess.getAttribute("class").equalsIgnoreCase("more");}, 20000);

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
	 * @param-boolean bMandatoryOnly: true/false
	 * @author Wei.Li
	 */
	public void verifySearchResultContent(List<WebElement> productList,boolean bMandatoryOnly) {
		if(bMandatoryOnly){
			reporter.reportLog("Verify Search Result Content For Mandatory Fields");
			verifySearchResultContentForMandatoryFields(productList,false);
		}
		else{
			reporter.reportLog("Verify Search Result Content For Mandatory Fields");
			verifySearchResultContentForMandatoryFields(productList,false);
			reporter.reportLog("Verify Search Result Content For Optional Fields");
			verifySearchResultContentForOptionalFields(productList);
		}
	}

	/**
	 * This method will verify the optional item content in product list without mouse hover.
	 * @param-List<WebElement> productList: the input product list
	 * @param-boolean bMouseHover: true/false
	 * @author Wei.Li
	 */
	public void verifySearchResultContentForMandatoryFields(List<WebElement> productList,boolean bMouseHover) {
		int loopSize;
		WebElement item,element;
		List<WebElement> reviewStarList;
		String lsProductName,lsText;

		loopSize=productList.size();
		loopSize=loopSize>15?15:loopSize;
		for(int i=0;i<loopSize;i++) {
			item=productList.get(i);

			element=item.findElement(byProductName);
			lsProductName=this.getElementInnerText(element);
			reporter.reportLog("Product Name: "+lsProductName);
			if(!lsProductName.isEmpty()) {
				reporter.reportLogPass("Product Name is not empty");
			}
			else {
				reporter.reportLogFailWithScreenshot("Product Name is empty");
			}
			//Bug 19537: [QA Defect - P3] PRP: Is Price should be bold
			if(element.getCssValue("font-weight").equalsIgnoreCase("600")) {
				reporter.reportLogPass("Product name is semi bold font");
			}
			else {
				reporter.reportLogFailWithScreenshot("Product name is not semi bold font");
			}

			element=item.findElement(byProductHeaderLike);
			if(this.getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("Product like icon is visible");
			}
			else {
				reporter.reportLogFailWithScreenshot("Product like icon is not visible");
			}

			element=item.findElement(byProductHref);
			if(!this.getElementHref(element).isEmpty()) {
				reporter.reportLogPass("Product link is not empty");
			}
			else {
				reporter.reportLogFailWithScreenshot("Product link is empty");
			}

			element=item.findElement(byProductImage);
			if(!this.getElementImageSrc(element).isEmpty()) {
				reporter.reportLogPass("Product image source is not empty");
			}
			else {
				reporter.reportLogFailWithScreenshot("Product image source is not empty");
			}

			if(!bMouseHover){
				if(!this.getProductOptionTypeWithoutMouseHover(item).equalsIgnoreCase("None")){
					reporter.reportLogPass("Product option is not empty");
				}
			}

			element=item.findElement(byProductNowPrice);
			lsText=this.getElementInnerText(element);
			if(!lsText.isEmpty()) {
				reporter.reportLogPass("Product Now Price is not empty");
			}
			else {
				reporter.reportLogFailWithScreenshot("Product Now Price is not empty");
			}
			//Bug 19537: [QA Defect - P3] PRP: Is Price should be bold
			if(element.getCssValue("font-weight").equalsIgnoreCase("600")) {
				reporter.reportLogPass("Product NowPrice is semi bold font");
			}
			else {
				reporter.reportLogFailWithScreenshot("Product NowPrice is not semi bold font");
			}

		}
	}

	/**
	 * This method will verify the optional item content in product list without mouse hover.
	 * @param-List<WebElement> productList: the input product list
	 * @author Wei.Li
	 */
	public void verifySearchResultContentForOptionalFields(List<WebElement> productList) {
		int loopSize;
		WebElement item,element;
		List<WebElement> reviewStarList;
		String lsProductName,lsText;

		loopSize=productList.size();
		loopSize=loopSize>15?15:loopSize;
		for(int i=0;i<loopSize;i++) {
			item=productList.get(i);

			if(this.checkProductItemHeaderTitleExisting(item)) {
				element=item.findElement(byProductHeaderTitle);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product title is not empty");
				}
				else {
					reporter.reportLogFailWithScreenshot("Product title is empty");
				}
				//Bug 19683: [UAT Defect] PRP: Merchandising badges i.e. Clearance, BlockBuster etc. should be bolded
				if(element.getCssValue("font-weight").equalsIgnoreCase("800")) {
					reporter.reportLogPass("Product title is bold font");
				}
				else {
					reporter.reportLogFailWithScreenshot("Product title is not bold font");
				}
			}

			if(this.checkProductItemBrandNameExisting(item)) {
				element=item.findElement(byProductBrand);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product brand name is not empty");
				}
				else {
					reporter.reportLogFailWithScreenshot("Product brand name is empty");
				}
			}

			if(this.checkProductItemWasPriceExisting(item)) {
				element=item.findElement(byProductWasPrice);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product Was Price is not empty");
				}
				else {
					reporter.reportLogFailWithScreenshot("Product Was Price is empty");
				}
			}

			if(this.checkProductItemReviewExisting(item)) {
				element=item.findElement(byProductReviewContainer);
				if(this.getReusableActionsInstance().isElementVisible(element)) {
					reporter.reportLogPass("Product review is visible");
				}
				else {
					reporter.reportLogFailWithScreenshot("Product review is not visible");
				}

				//Bug 19536: [QA Defect - P3] PRP: Rating and Review not showing properly
				reviewStarList=item.findElements(this.byProductReviewRatingImage);
				if(reviewStarList.size()>0) {
					reporter.reportLogPass("Product review stars are displaying correctly");
				}
				else {
					reporter.reportLogFailWithScreenshot("Product review stars are not displaying correctly");
				}

				lsText=this.getElementInnerText(item.findElement(this.byProductReviewRatingCount));
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product review count info is displaying correctly");
				}
				else {
					reporter.reportLogFailWithScreenshot("Product review count info is not displaying correctly");
				}
			}
		}
	}

	/**
	 * This method will verify the item content in product list with mouse hover.
	 * @param-List<WebElement> productList: the input product list
	 * @param-boolean bMouseHoverOnly: true/false
	 * @author Wei.Li
	 */
	public void verifySearchResultContentWithMouseHover(List<WebElement> productList,boolean bMouseHoverOnly) {
		if(bMouseHoverOnly){
			reporter.reportLog("Verify Search Result Content With Mouse Hover For Style And Size");
			verifySearchResultContentWithMouseHoverForStyleAndSize(productList);
		}
		else{
			reporter.reportLog("Verify Search Result Content For Mandatory Fields");
			verifySearchResultContentForMandatoryFields(productList,true);
			reporter.reportLog("Verify Search Result Content For Optional Fields");
			verifySearchResultContentForOptionalFields(productList);
			reporter.reportLog("Verify Search Result Content With Mouse Hover For Style And Size");
			verifySearchResultContentWithMouseHoverForStyleAndSize(productList);
		}

	}

	/**
	 * This method will verify the Style/Size content in product list with mouse hover.
	 * @param-List<WebElement> productList: the input product list
	 * @author Wei.Li
	 */
	public void verifySearchResultContentWithMouseHoverForStyleAndSize(List<WebElement> productList) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productList.get(0));
		this.getReusableActionsInstance().scrollToElement(productList.get(0));

		int checkAmount=5,loopSize;
		WebElement item,element;
		String lsProductName,lsText;
		List<WebElement> reviewStarList;

		if(checkAmount<=productList.size()) {
			loopSize=checkAmount;
		}
		else {
			loopSize=productList.size();
		}

		for(int i=0;i<loopSize;i++) {
			item=productList.get(i);
			lsProductName=this.getElementInnerText(item.findElement(this.byProductName));
			reporter.reportLog("Product name: "+lsProductName);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			this.getReusableActionsInstance().scrollToElement(item);

			lsText=judgeProductOptionType(item);
			if(lsText.contains("Size")) {
				element=item.findElement(byProductOptionSizeTitle);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product option size title is not empty");
				}
				else {
					reporter.reportLogFailWithScreenshot("Product option size title is empty");
				}

				if(item.findElements(byProductOptionSizeItemList).size()>0) {
					reporter.reportLogPass("Product option size button list is containing no less than 1 item");
				}
				else {
					reporter.reportLogFailWithScreenshot("Product option size button list is containing 0 item");
				}

				if(checkViewAllSizesButtonExisting(item)) {
					element=item.findElement(byProductOptionSizeViewAllSizes);
					lsText=this.getElementInnerText(element);
					if(!lsText.isEmpty()) {
						reporter.reportLogPass("Product ViewAlllSize button title is not empty");
					}
					else {
						reporter.reportLogFailWithScreenshot("Product ViewAlllSize button title is empty");
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
					reporter.reportLogFailWithScreenshot("Product option color title is empty");
				}

				if(item.findElements(byProductOptionColorItemList).size()>0) {
					reporter.reportLogPass("Product option color button list is containing no less than 1 item");
				}
				else {
					reporter.reportLogFailWithScreenshot("Product option color button list is containing 0 item");
				}

				if(checkViewAllColorsButtonExisting(item)) {
					element=item.findElement(byProductOptionColorViewAllColors);
					lsText=this.getElementInnerText(element);
					if(!lsText.isEmpty()) {
						reporter.reportLogPass("Product ViewAllColor button title is not empty");
					}
					else {
						reporter.reportLogFailWithScreenshot("Product ViewAllColor button title is empty");
					}
				}
			}

			element=item.findElement(byProductGoToDetails);
			if(this.getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("Product GoTo Details is visible");
			}
			else {
				reporter.reportLogFailWithScreenshot("Product GoTo Details is not visible");
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
		String lsUrl=this.URL();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSortSelect);
		getReusableActionsInstance().scrollToElement(this.btnSortSelect);
		Select sortOption= new Select(this.btnSortSelect);
		sortOption.selectByVisibleText(lsOption);

		this.waitForCondition(Driver->{return !lsUrl.equalsIgnoreCase(this.URL());},18000);

		if(!this.URL().contains("page=")) {
			reporter.reportLogPass("The Url does not contain page term.");
		}
		else {
			reporter.reportLogFailWithScreenshot("The Url contains page term.");
		}
		
		if(this.getElementInnerText(btnCurrentPage).equalsIgnoreCase("1")) {
			reporter.reportLogPass("The current page is 1st page.");
		}
		else {
			reporter.reportLogFailWithScreenshot("The current page is not 1st page.");
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
			String nowPriceText=this.getElementInnerText(element.findElement(this.byProductNowPrice));

			float nowPriceValue=this.getFloatFromString(nowPriceText,bHighest);

			priceList.add(nowPriceValue);
			String productName=this.getElementInnerText(element.findElement(this.byProductName));
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
			if(this.checkProductItemReviewExisting(element)) {
				List<WebElement> reviewStarList=element.findElements(this.byProductReviewRatingImage);
				int reviewCount=getProductItemReviewNumberAmountFromStarImage(reviewStarList);
				
				reviewList.add(reviewCount);
			}
			else {
				reviewList.add(0);
			}

			String productName=this.getElementInnerText(element.findElement(this.byProductName));
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
			if(this.checkProductItemBrandNameExisting(element)) {
				item=element.findElement(byProductBrand);
				lsText=this.getElementInnerText(item).toUpperCase();
				brandList.add(lsText);
			}
			else {
				brandList.add("Z");
			}

			String productName=this.getElementInnerText(element.findElement(this.byProductName));
			productNameList.add(productName);
		}

		int brandListSize=brandList.size();
		for(int i=0;i<brandListSize-1;i++) {
			if(brandList.get(i).compareTo(brandList.get(i+1))>0) {
				System.out.println(brandList.get(i));
				System.out.println(brandList.get(i+1));
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
	 * This method will verify filter option headers are not containing Category and Shop By Category simultaneously
	 * @return String: error message
	 * @author Wei.Li
	 */
	//Bug 19575: [QA Defect - P3] the implementation for Category in the left nav is wrong
	public String verifyFilterOptionsNotContainCategoryAndShopByCategorySimultaneously() {
		String lsErrorMsg="";
		int listSize=this.productFilterList.size();
		if(listSize==0) {
			return lsErrorMsg="No product filter list";
		}
		
		boolean bCategory=false,bShopByCategory=false;
		String lsFilterHeader;
		for(int i=0;i<listSize;i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			lsFilterHeader=this.productFilterList.get(i).getText().trim();
			if(lsFilterHeader.equalsIgnoreCase("category")) {
				bCategory=true;
			}
			
			if(lsFilterHeader.equalsIgnoreCase("shop by category")) {
				bShopByCategory=true;
			}
		}
		
		if(bCategory&&bShopByCategory) {
			lsErrorMsg="The filter option headers are containing Category and Shop By Category simultaneously";
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

		WebElement searchInputButton,item;
		List<WebElement> subItemList;
		String lsHeader;
		boolean bCategory=lsFirstLevelItem.equalsIgnoreCase("category");
		
		if(bCategory&&this.bCategoryExpand) {
			ExpandSubExpandableItemInCategoryFilterSection();
			this.bCategoryExpand=false;
		}
				
		for(int i=0;i<this.productFilterList.size();i++) {
			final int tempIndex=i;
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			lsHeader=this.productFilterList.get(i).getText().trim();
			if(lsHeader.contains("(")) {
				lsHeader=lsHeader.split("\\(")[0].trim();
			}
			//If found lsFirstLevelItem
			if(lsHeader.equalsIgnoreCase(lsFirstLevelItem)) {				
				//If find a search input
				if(!checkIfFilterItemIsCollapsed(this.productFilterContainerList.get(i))){
					collapseFilterItemWithClickingProductTitle(this.productFilterContainerList.get(i));
				}

				if(checkSearchInputButtonExistingInSubFilter(this.productFilterContainerList.get(i))) {
					searchInputButton=this.productFilterContainerList.get(i).findElement(this.byProductFilterSearchInput);
					getReusableActionsInstance().javascriptScrollByVisibleElement(searchInputButton);
					searchInputButton.sendKeys(lsSecondLevelItem);
					//keep it to wait for search results
					this.getReusableActionsInstance().staticWait(300);
					subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAllWithoutCategory);
					if(subItemList.size()>0) {
						getReusableActionsInstance().javascriptScrollByVisibleElement(subItemList.get(0));
						subItemList.get(0).click();;

						if(lsHeader.contains("(")) {
							final By bySelectedSecondFilter=By.xpath("//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__blocks']//button[@class='prp-filter-panel__block-title'][.='"+lsHeader+" (2)']");
							this.waitForCondition(Driver->{ return this.getDriver().findElement(bySelectedSecondFilter).isDisplayed();},8000);
						}
						else{
							final By bySelectedSecondFilter=By.xpath("//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__blocks']//button[@class='prp-filter-panel__block-title'][.='"+lsHeader+" (1)']");
							this.waitForCondition(Driver->{ return this.getDriver().findElement(bySelectedSecondFilter).isDisplayed();},8000);
						}

						this.productFilterList.get(i).getText().trim();
						
						//Bug 19628: [QA Defect - P3] PRP: no products display if user is on the last page and select a faucet from the left nav
						if(!this.URL().contains("page=")) {
							reporter.reportLogPass("The Url does not contain page term.");
						}
						else {
							reporter.reportLogFailWithScreenshot("The Url contains page term.");
						}
						
						if(this.getElementInnerText(btnCurrentPage).equalsIgnoreCase("1")) {
							reporter.reportLogPass("The current page is 1st page.");
						}
						else {
							reporter.reportLogFailWithScreenshot("The current page is not 1st page.");
						}
						
						verifyUrlPatternAfterSelectFilter(false);
						
						return true;
					}
					else {
						reporter.reportLogFailWithScreenshot("Unable to find "+lsSecondLevelItem);
						break;
					}
				}

				if(!lsFirstLevelItem.equalsIgnoreCase("category")) {
					expandFilterItem(this.productFilterContainerList.get(i));
				}
				
				String lsSubItem=null;
				subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);
				
				for(WebElement subItem : subItemList) {
					getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);

					//if statement to test Bug-19685 - Review filter
					if(lsSecondLevelItem.toLowerCase().contains("star")){
						lsSubItem =this.getElementInnerText(subItem.findElement(By.xpath(".//span[@class='prp-filter-panel__filter-list__item-label-text visually-hidden']")));
					}
					else {	
						if(lsFirstLevelItem.equalsIgnoreCase("category")) {
							item=subItem.findElement(By.xpath(".//a"));								
							if(!this.hasElementAttribute(item, "class")) {
								lsSubItem = item.getText().trim();
							}
							else {
								continue;
							}
						}
						else {
							lsSubItem=subItem.findElement(By.xpath(".//span[@class='prp-filter-panel__filter-list__item-label-text']")).getText().trim();
						}
												 
					}

					//If found lsSecondLevelItem
					if(lsSubItem.equalsIgnoreCase(lsSecondLevelItem)) {
						subItem.click();
						if(lsHeader.toLowerCase().equalsIgnoreCase("category")){
							this.waitForPageToLoad();
						}
						else{
							final By bySelectedSecondFilter=By.xpath("//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__blocks']//button[@class='prp-filter-panel__block-title'][.='"+lsHeader+" (1)']");
							this.waitForCondition(Driver->{ return this.getDriver().findElement(bySelectedSecondFilter).isDisplayed();},8000);
						}
//
						//Bug 19628: [QA Defect - P3] PRP: no products display if user is on the last page and select a faucet from the left nav
						//Bug 19556: [QA Defect - P3] PRP: when selecting a subcategory from Shop by category, the dimension in the URL should start over not appending
						if(!this.URL().contains("page=")) {
							reporter.reportLogPass("The Url does not contain page term.");
						}
						else {
							reporter.reportLogFailWithScreenshot("The Url contains page term.");
						}
						
						if(this.getElementInnerText(btnCurrentPage).equalsIgnoreCase("1")) {
							reporter.reportLogPass("The current page is 1st page.");
						}
						else {
							reporter.reportLogFailWithScreenshot("The current page is not 1st page.");
						}
						
						//Bug 19389: PRP Filter Panel - Shop by Category selection does not work as intended						
						verifyUrlPatternAfterSelectFilter(bCategory);
						
						return true;
					}
				}
			}
		}

		//If unable to find both lsFirstLevelItem and lsSecondLevelItem, then select the first choice
		this.bDefault=true;

		for(int i=0;i<this.productFilterList.size();i++) {
			final int tempIndex=i;
			expandFilterItem(this.productFilterContainerList.get(i));

			subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);
			for(WebElement subItem : subItemList) {
				if(!this.hasElementAttribute(subItem.findElement(By.xpath(".//button//input")), "checked")) {
					this.secondLevelFilter=this.getElementInnerText(subItem);
					this.firstLevelFilter=this.getElementInnerText(subItem.findElement(By.xpath("./ancestor::div[@class='prp-filter-panel__blocks']//button[@class='prp-filter-panel__block-title']")));
					lsHeader=this.firstLevelFilter;
					subItem.click();
					final By bySelectedSecondFilter=By.xpath("//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__blocks']//button[@class='prp-filter-panel__block-title'][.='"+lsHeader+" (1)']");
					this.waitForCondition(Driver->{ return this.getDriver().findElement(bySelectedSecondFilter).isDisplayed();},8000);
					
					//Bug 19628: [QA Defect - P3] PRP: no products display if user is on the last page and select a faucet from the left nav
					if(!this.URL().contains("page=")) {
						reporter.reportLogPass("The Url does not contain page term.");
					}
					else {
						reporter.reportLogFailWithScreenshot("The Url contains page term.");
					}
					
					if(this.getElementInnerText(btnCurrentPage).equalsIgnoreCase("1")) {
						reporter.reportLogPass("The current page is 1st page.");
					}
					else {
						reporter.reportLogFailWithScreenshot("The current page is not 1st page.");
					}
					
					verifyUrlPatternAfterSelectFilter(false);
					
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkFilterAddedStatus(String lsFilter){
		for(WebElement item:this.productFilterList){
			if(this.getElementInnerText(item).equalsIgnoreCase(lsFilter+" (1)")){
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will Expand Sub Expandable Item In Category Filter Section
	 * @return void
	 * @author Wei.Li
	 */
	public void ExpandSubExpandableItemInCategoryFilterSection() {
		int listSize=this.productFilterList.size();
				
		boolean bCategory=false;
		String lsFilterHeader;
		int selectedIndex=0;
		
		for(int i=0;i<listSize;i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			lsFilterHeader=this.productFilterList.get(i).getText().trim();
			
			if(lsFilterHeader.equalsIgnoreCase("category")) {
				bCategory=true;
				selectedIndex=i;
				break;
			}
		}

		if(!bCategory) {
			return;
		}

		List<WebElement> subItemList=this.productFilterContainerList.get(selectedIndex).findElements(this.bySecondaryFilterAll);
		WebElement element;
		WebElement subItem;
		for(int i=0;i<subItemList.size()-1;i++) {
			subItem=subItemList.get(i);
			element=subItem.findElement(By.xpath(".//a"));			
			if(this.hasElementAttribute(element, "class")) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				this.getReusableActionsInstance().clickIfAvailable(element);
				this.waitForPageToLoad();
				break;
			}
		}
		
	}
	
	/**
	 * This method will verify Url after selecting filters.
	 * @param-boolean bCategory: true for Category filter while false for others filter
	 * @return void
	 * @author Wei.Li
	 */
	//Bug 19389: PRP Filter Panel - Shop by Category selection does not work as intended
	//Bug 19557: [QA Defect - P3] when selecting the checkbox options in the left nav, the dimension IDs in the URL should use pipe character not... - Boards (azure.com)
	public void verifyUrlPatternAfterSelectFilter(boolean bCategory) {		
		String lsUrl=this.URL();
		
		boolean bVerify;
		if(bCategory) {
			bVerify=lsUrl.matches(".*dimensions=\\d+.*");
			if(bVerify) {
				reporter.reportLogPass("The Url for Category filter is displaying correctly.");
			}
			else {
				reporter.reportLogFailWithScreenshot("The Url for Category filter is not displaying correctly.");
			}					
		}
		else {
			bVerify= lsUrl.matches(".*dimensions=\\d+%7C\\d+.*");
			if(bVerify) {
				reporter.reportLogPass("The Url for the filters except Category filter is displaying correctly.");
			}
			else {
				reporter.reportLogFailWithScreenshot("The Url for the filters except Category filter is not displaying correctly.");
			}						
		}		
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
	 * This method will check if selected filter list is existing.
	 * @return boolean.
	 * @author Wei.Li
	 */
	public boolean checkSelectedFilterListExisting() {
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
		if(this.checkChildElementExistingByAttribute(this.cntSelectedFilters, "class", "prp__applied-filters")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This method will close all selected filters.
	 * @return true/false: The last one is ClearAllFiltersButton.
	 * @author Wei.Li
	 */
	public boolean closeAllSelectedFilters() {
		if(!checkSelectedFilterListExisting()) {
			return true;
		}

		WebElement element=this.selectedFiltersList.get(this.selectedFiltersList.size()-1);
		getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		getReusableActionsInstance().clickIfAvailable(element);

		//To keep it to wait for DOM change
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
		return this.waitForSortingOrFilteringCompleted();
	}

	/**
	 * This method will verify if selected filters contain suitable search second level filters.
	 * @param- List<String> lstFilterIncluded: second level filter list
	 * @param- List<String> lstFilterExcluded: the filters should not appear in selected filters option
	 * @return String: error message
	 * @author Wei.Li
	 */
	public String verifySelectedFiltersContainSecondlevelFilter(List<String> lstFilterIncluded, List<String> lstFilterExcluded) {
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
			if(lastPageButton.getAttribute("class").contains("prp__pagination__pages__page--current")) {
				return false;
			}else {
				this.clickElement(this.btnNextPage);
			}

		}else {
			if(!this.checkIfPrevPageButtonAvailable()) {
				return false;
			}

			WebElement firstPageButton=this.PageNumberList.get(0);
			if(firstPageButton.getAttribute("class").contains("prp__pagination__pages__page--current")) {
				return false;
			}else {
				this.clickElement(this.btnPreviousPage);
			}
		}

		this.waitForPageToLoad();

		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,5000);

		this.waitForCondition(Driver->{return !lsFirstProductName.equalsIgnoreCase(this.getElementInnerText(this.getProductList().get(0).findElement(byProductName)));}, 120000);

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
		this.getReusableActionsInstance().waitForElementVisibility((new ProductDetailPage(this.getDriver())).lblProductName,200);
		return true;
	}
	
	public boolean waitForPageLoading() {
		this.waitForPageToLoad();
		return true;
	}

	/**
	 * This method will go to the product with with Vedio,Size,Style,Badge image, Review,EasyPay,Nowprice and WasPrice
	 * @return true/false
	 * @author Wei.Li
	 * @throws IOException
	 */
	public boolean goToProductItemWithPreConditions(List<String> lstKeyword) throws IOException {
		ProductAPI productAPI=new ProductAPI();
		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("video", "1");
		outputDataCriteria.put("style", "3");
		outputDataCriteria.put("size", "3");

		SelectedProduct selectedProduct=null;
		Product.Products product=null;

		String productNumber="";
		for(String lsKeyword:lstKeyword) {
			product=productAPI.getProductInfoFromKeyword(lsKeyword, outputDataCriteria,true,false,false);
			if(product!=null) {
				break;
			}
		}

		while(this.switchPage(true));
		return false;
	}

	/**
	 * This method will go to the product with with Vedio,Size,Style,Badge image, Review,EasyPay,Nowprice and WasPrice
	 * @return true/false
	 * @author Wei.Li
	 * @throws IOException
	 */
	public boolean findProductItemWithPreConditions(List<String> lstKeyword) throws IOException {
		ProductAPI productAPI=new ProductAPI();
		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("video", "1");
		outputDataCriteria.put("style", "1");
		outputDataCriteria.put("size", "1");

		SelectedProduct selectedProduct= null;
		Product.Products product=null;
		String productName="";
		for(String lsKeyword:lstKeyword) {
			product=productAPI.getProductInfoFromKeyword(lsKeyword, outputDataCriteria,false,true,false);
			if(product!=null) {
				break;
			}
		}

		if(product==null){
			reporter.reportLogFailWithScreenshot("Unable to find the product with Vedio,Size,Style,Badge image, Review,EasyPay,Nowprice and WasPrice");
			return false;
		}

		selectedProduct=productAPI.selectedProduct;
		productName=selectedProduct.productName;

		this.selectedProductItem.init();
		reporter.reportLog("Product Name fetched from API call is: "+productName);
		this.getSearchResultLoad(productName,true);

		this.selectedProductItem.productNumber=selectedProduct.productNumber;
		this.selectedProductItem.productName=selectedProduct.productName;
		this.selectedProductItem.productBrand=selectedProduct.productBrand;
		this.selectedProductItem.productNowPrice=selectedProduct.productNowPrice;
		this.selectedProductItem.productWasPrice=selectedProduct.productWasPrice;

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
		if(!this.getElementInnerText(productRecommendationTitle).isEmpty()){
			reporter.reportLogPass("Product recommendation title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Product recommendation title is not displaying correctly");
		}

		WebElement element;
		for(WebElement item: this.lstPeopleAlsoBoughtItems) {
			//Verifying Image of the Product
			element=item.findElement(byRecommendationLink);
			reporter.softAssert(!element.getAttribute("href").isEmpty(), "Product link in Recommendation result is not empty", "Product link in Recommendation result is empty");

			//Verifying Name of the Product
			element=item.findElement(byRecommendationName);
			reporter.softAssert(!this.getElementInnerText(element).isEmpty(), "ProductName in Recommendation result is correct", "ProductName in Recommendation result is incorrect");

			//Verifying brand of the Product
			reporter.softAssert(this.checkChildElementExistingByAttribute(item,"class","recommend__products__item--brand"), "ProductBrand in Recommendation result is correct", "ProductBrand in Recommendation result is incorrect");

			//Verifying Price of the Product
			element=item.findElement(byRecommendationNowPrice);
			reporter.softAssert(!this.getElementInnerText(element).isEmpty(), "ProductNowPrice in Recommendation result is correct", "ProductNowPrice in Recommendation result is incorrect");

			//Verifying Was Price is Displayed
			if(this.getChildElementCount(item.findElement(this.byRecommendationPriceContainer))>1) {
				element=item.findElement(byRecommendationWasPrice);
				reporter.softAssert(!this.getElementInnerText(element).isEmpty(), "ProductWasPrice in Recommendation result is correct", "ProductWasPrice in Recommendation result is incorrect");
			}
		}
	}

	/**
	 * This method will check if page loading completed after choose sorting/filtering
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductResultLoadingStatusAfterSorting() {
		return this.checkChildElementExistingByAttribute(this.cntSortingAndFilteringProductResultLoadingIndicator,"class","prp__loading");
	}

	/**
	 * This method will wait until page loading completed after choose sorting/filtering
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean waitForSortingOrFilteringCompleted() {
		this.waitForCondition(Driver->{return !checkProductResultLoadingStatusAfterSorting();}, 30000);
		return true;
	}

	/**
	 * This method will check Product result existence
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductResultExisting() {
		//To keep it for product result section loading, otherwise sometimes will cause failure
		this.getReusableActionsInstance().staticWait(3*this.getStaticWaitForApplication());
		return this.checkChildElementExistingByAttribute(this.cntTSCContainer,"class","prp");
	}

	/**
	 * This method will check Product result existence
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductResultPaginationExisting() {
		return this.checkChildElementExistingByAttribute(this.cntTSCContainer,"class","prp__pagination");
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
	 * @param-String lsOption: "size"/"style"
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

		if(lsText.toLowerCase().contains("size")&&lsText.toLowerCase().contains("style")) {
			return "SizeAndColour";
		}

		if(lsText.toLowerCase().contains("size")&&!lsText.toLowerCase().contains("style")) {
			return "Size";
		}

		if(!lsText.toLowerCase().contains("size")&&lsText.toLowerCase().contains("style")) {
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

		return this.checkChildElementExistingByAttribute(item, "class","niceSelect");
	}

	/**
	 * This method will check Color Product Option Is Dropdown with mouse hover
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkColorProductOptionIsDropdownWithMouseHover(WebElement itemContainer) {
		WebElement item=itemContainer.findElement(this.byProductOptionColorWrapper);

		return this.checkChildElementExistingByAttribute(item, "class","niceSelect");
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
		WebElement element,elementSelectedText;
		final WebElement tempElementSize,tempElementColor;

		if(this.checkProductOptionTypeExistingWithMouseHover(itemContainer, "size")) {
			if(checkProductSizeOptionEnabledItemAvailableWithMouseHover(itemContainer)) {
				elementSelectedText=itemContainer.findElement(byProductOptionSizeSelectedSizeContainer);
				tempElementSize=elementSelectedText;

				optionList=itemContainer.findElements(byProductOptionSizeItemEnabledList);
				element=optionList.get(optionList.size()-1);
				if(element.getTagName().equalsIgnoreCase("button")) {
					this.getReusableActionsInstance().clickIfAvailable(element,5000);
					this.waitForCondition(Driver->{return !this.getElementInnerText(tempElementSize).equalsIgnoreCase("Select size:");},10000);
				}
				else {
					WebElement dropDown=element.findElement(By.xpath("./parent::select"));
					checkSizeSelectOptions(itemContainer,dropDown);
				}

				element=itemContainer.findElement(byProductOptionSizeSelectedSize);
				selectedProductItem.productSelectedSize=this.getElementInnerText(element);
			}
			else {
				selectedProductItem.productSelectedSize="";
			}
		}

		if(this.checkProductOptionTypeExistingWithMouseHover(itemContainer, "style")) {
			if(checkProductColorOptionEnabledItemAvailableWithMouseHover(itemContainer)) {
				elementSelectedText=itemContainer.findElement(byProductOptionColorSelectedColorContainer);
				tempElementColor=elementSelectedText;

				optionList=itemContainer.findElements(byProductOptionColorItemEnabledList);
				element=optionList.get(optionList.size()-1);
				if(element.getTagName().equalsIgnoreCase("button")) {
					this.getReusableActionsInstance().clickIfAvailable(element,5000);
					this.waitForCondition(Driver->{return !this.getElementInnerText(tempElementColor).equalsIgnoreCase("Select colour:");},10000);
				}
				else {
					WebElement dropDown=element.findElement(By.xpath("./parent::select"));
					checkColorSelectOptions(itemContainer,dropDown);
				}

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
		
		boolean bSizeDropdown,bColorDoprdown;
				
		if(lsType.equalsIgnoreCase("SizeAndColour")) {
			bSizeDropdown=checkSizeOrColorOptionIsDropDown(itemContainer,true);
			bColorDoprdown=checkSizeOrColorOptionIsDropDown(itemContainer,false);
			if(bSizeDropdown&&bColorDoprdown) {
				if(lsText.equalsIgnoreCase("Go to detail page")) {
					reporter.reportLogPass("The button text is equal to 'Go to detail page'");
				}
				else {
					reporter.reportLogFailWithScreenshot("The button text is not equal to 'Go to detail page'");
				}
			}
			
			if(bSizeDropdown&&!bColorDoprdown) {
				if(lsText.equalsIgnoreCase("Select style")) {
					reporter.reportLogPass("The button text is equal to 'Select style'");
				}
				else {
					reporter.reportLogFailWithScreenshot("The button text is not equal to 'Select style'");
				}
			}
			
			if(!bSizeDropdown&&bColorDoprdown) {
				if(lsText.equalsIgnoreCase("Select size")) {
					reporter.reportLogPass("The button text is equal to 'Select size'");
				}
				else {
					reporter.reportLogFailWithScreenshot("The button text is not equal to 'Select size'");
				}
			}
			
			if(!bSizeDropdown&&!bColorDoprdown) {
				if(lsText.equalsIgnoreCase("Select size & style")) {
					reporter.reportLogPass("The button text is equal to 'Select size & style'");
				}
				else {
					reporter.reportLogFailWithScreenshot("The button text is not equal to 'Select size & style'");
				}
			}			
		}

		if(lsType.equalsIgnoreCase("Size")) {
			bSizeDropdown=checkSizeOrColorOptionIsDropDown(itemContainer,true);
			if(bSizeDropdown) {
				if(lsText.equalsIgnoreCase("Select size & style")) {
					reporter.reportLogPass("The button text is equal to 'Select size & style'");
				}
				else {
					reporter.reportLogFailWithScreenshot("The button text is not equal to 'Select size & style'");
				}
			}
			else {
				if(lsText.equalsIgnoreCase("Select size")) {
					reporter.reportLogPass("The button text is equal to 'Select size'");
				}
				else {
					reporter.reportLogFailWithScreenshot("The button text is not equal to 'Select size'");
				}
			}			
		}

		if(lsType.equalsIgnoreCase("Colour")) {
			bColorDoprdown=checkSizeOrColorOptionIsDropDown(itemContainer,false);
			if(bColorDoprdown) {
				if(lsText.equalsIgnoreCase("Select size & style")) {
					reporter.reportLogPass("The button text is equal to 'Select size & style'");
				}
				else {
					reporter.reportLogFailWithScreenshot("The button text is not equal to 'Select size & style'");
				}
			}
			else {
				if(lsText.equalsIgnoreCase("Select style")) {
					reporter.reportLogPass("The button text is equal to 'Select style'");
				}
				else {
					reporter.reportLogFailWithScreenshot("The button text is not equal to 'Select style'");
				}
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
					bColorDoprdown=checkSizeOrColorOptionIsDropDown(itemContainer,false);
					if(bColorDoprdown) {
						if(lsText.equalsIgnoreCase("Go to detail page")) {
							reporter.reportLogPass("The button text is equal to 'Go to detail page'");
						}
						else {
							reporter.reportLogFailWithScreenshot("The button text is not equal to 'Go to detail page'");
						}
					}
					else {
						if(lsText.equalsIgnoreCase("Select style")) {
							reporter.reportLogPass("The button text is equal to 'Select style'");
						}
						else {
							reporter.reportLogFailWithScreenshot("The button text is not equal to 'Select style'");
						}
					}
					
				}else {
					if(lsText.equalsIgnoreCase("Go to detail page")) {
						reporter.reportLogPass("The button text is equal to 'Go to detail page'");
					}
					else {
						reporter.reportLogFailWithScreenshot("The button text is not equal to 'Go to detail page'");
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
				reporter.reportLogFailWithScreenshot("The button text is not equal to 'Go to detail page'");
			}
		}

	}
	
	private boolean checkSizeOrColorOptionIsDropDown(WebElement itemContainer,boolean bSize) {
		List<WebElement> optionList;
		if(bSize) {
			optionList=itemContainer.findElements(byProductOptionSizeItemList);
		}
		else {
			optionList=itemContainer.findElements(byProductOptionColorItemList);
		}
				
		WebElement element=optionList.get(optionList.size()-1);
		if(!element.getTagName().equalsIgnoreCase("button")) {								
			return true;
		}
		return false;		
	}

	private String checkColorSelectOptions(WebElement itemContainer,WebElement dropDown){
		List<WebElement> itemList;
		WebElement niceSelectButton;
		String colorToBeSelected="";
		if(dropDown.getAttribute("class").contains("visually-hidden")){
			niceSelectButton=itemContainer.findElement(byProductOptionColorNiceSelectButton);
			this.clickElement(niceSelectButton);
			//Wait for dopdown menu expanded
			this.applyStaticWait(300);
			itemList=itemContainer.findElements(this.byProductOptionColorNiceSelectList);

			for(int j=itemList.size()-1;j>=0;j--) {
				if (!hasElementAttribute(itemList.get(j), "disabled")) {
					colorToBeSelected=this.getElementInnerText(itemList.get(j));
					this.clickElement(itemList.get(j));
					break;
				}
			}
		}
		else{
			Select select = new Select(dropDown);
			List<WebElement> enabledColor = itemContainer.findElements(this.byProductOptionColorItemEnabledList);
			colorToBeSelected = enabledColor.get(enabledColor.size()-1).getAttribute("value");
			select.selectByValue(colorToBeSelected);
		}
		//Unable to find explicit wait condition, so have to use static wait
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		return colorToBeSelected;
	}

	private String checkSizeSelectOptions(WebElement itemContainer,WebElement dropDown){
		List<WebElement> itemList;
		WebElement niceSelectButton;
		String sizeToBeSelected="";
		if(dropDown.getAttribute("class").contains("visually-hidden")){
			niceSelectButton=itemContainer.findElement(byProductOptionSizeNiceSelectButton);
			this.clickElement(niceSelectButton);
			//Wait for dropdown menu expanded
			this.applyStaticWait(300);
			itemList=itemContainer.findElements(this.byProductOptionSizeNiceSelectList);

			for(int j=itemList.size()-1;j>=0;j--) {
				if (!hasElementAttribute(itemList.get(j), "disabled")) {
					sizeToBeSelected=this.getElementInnerText(itemList.get(j));
					this.clickElement(itemList.get(j));
					break;
				}
			}
		}
		else{
			Select select = new Select(dropDown);
			List<WebElement> enabledColor = itemContainer.findElements(this.byProductOptionSizeItemEnabledList);
			sizeToBeSelected = enabledColor.get(enabledColor.size()-1).getAttribute("value");
			select.selectByValue(sizeToBeSelected);
		}
		//Unable to find explicit wait condition, so hve to use static wait
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		return sizeToBeSelected;
	}

	/**
	 * This method will verify selecting size/color option
	 * @param-WebElement-itemContainer: product search result item
	 * @param-String-lsType:size that is selected
	 * @return-boolean
	 * @author Wei.Li
	 */
	private boolean verifySizeOption(WebElement itemContainer,String lsType) {
		if(checkProductSizeOptionEnabledItemAvailableWithMouseHover(itemContainer)) {
			WebElement elementSelectedText;
			final WebElement tempElementSize;

			elementSelectedText=itemContainer.findElement(byProductOptionSizeSelectedSizeContainer);
			tempElementSize=elementSelectedText;

			List<WebElement> optionList=itemContainer.findElements(byProductOptionSizeItemEnabledList);
			WebElement element=optionList.get(optionList.size()-1);
			String lsText=this.getElementInnerText(element).replace("Size", "").trim();
			if(element.getTagName().equalsIgnoreCase("button")) {								
				this.clickElement(element);
				this.waitForCondition(Driver->{return !this.getElementInnerText(tempElementSize).equalsIgnoreCase("Select size:");},10000);
			}
			else {
				WebElement dropDown=element.findElement(By.xpath("./parent::select"));
				checkSizeSelectOptions(itemContainer,dropDown);
			}			

			WebElement selectedSize = itemContainer.findElement(this.sizeSelected);
			String lsSelectedTitle=this.getElementInnerText(selectedSize).split(":")[1].trim();
			this.selectedProductItem.productSelectedSize=lsSelectedTitle;			

			if(lsText.equalsIgnoreCase(lsSelectedTitle)) {
				reporter.reportLogPass("The selected size title is displaying correctly");
			}
			else {
				reporter.reportLogFailWithScreenshot("The selected size title is not displaying correctly");
			}

			return true;
		}
		return false;
	}
	
	private boolean verifyColorOption(WebElement itemContainer,String lsType) {
		if(checkProductColorOptionEnabledItemAvailableWithMouseHover(itemContainer)) {	
			String lsColor,lsText;
			WebElement element=null;
			WebElement elementSelectedText;
			final WebElement tempElementColor;
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

			elementSelectedText=itemContainer.findElement(byProductOptionColorSelectedColorContainer);
			tempElementColor=elementSelectedText;
			//Bug 19629: [QA Defect - P3] Product card: if a product doesn't have color swatch, all color options show as plain circles
			if(element.getTagName().equalsIgnoreCase("button")) {
				this.clickElement(element);
				this.waitForCondition(Driver->{return !this.getElementInnerText(tempElementColor).equalsIgnoreCase("Select colour:");},10000);
			}
			else {
				WebElement dropDown=element.findElement(By.xpath("./parent::select"));
				checkColorSelectOptions(itemContainer,dropDown);
			}	

			if(optionList.size()>1) {
				String lsImageSrcAfterClickingColor=itemContainer.findElement(byProductImage).getAttribute("src");
				if(!lsImageSrcBeforeClickingColor.equalsIgnoreCase(lsImageSrcAfterClickingColor)) {
					reporter.reportLogPass("The image is changing after choosing a different style");
				}
				else {
					reporter.reportLogFailWithScreenshot("The image is not changing after choosing a different style");
				}
			}

			element=itemContainer.findElement(byProductOptionColorSelectedColor);
			String lsSelectedTitle=this.getElementInnerText(element);
			this.selectedProductItem.productSelectedColor=lsSelectedTitle;
			lsText=lsText.replace("styles","").trim();
			if(lsText.equalsIgnoreCase(lsSelectedTitle)) {
				reporter.reportLogPass("The selected color title is displaying correctly");
			}
			else {
				reporter.reportLogFailWithScreenshot("The selected color title is not displaying correctly");
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
	public void verifyInfoLinkageWithPDP(ProductDetailPage pdp,String lsProductName) {
		WebElement itemContainer=null;
		String lsText;
				
		if(lsProductName!=null) {
			this.getSearchResultLoad(lsProductName, true);
			for(WebElement item:this.productResultList){
				lsText=this.getElementInnerText(item.findElement(this.byProductName));
				if(lsText.equalsIgnoreCase(lsProductName)){
					itemContainer=item;
					break;
				}
			}

			this.selectedProductItem.init();
			this.selectedProductItem.productName=this.getElementInnerText(itemContainer.findElement(this.byProductName));
			
			if(this.checkProductItemBrandNameExisting(itemContainer)) {
				this.selectedProductItem.productBrand=this.getElementInnerText(itemContainer.findElement(this.byProductBrand)).replace("By", "").trim();
			}
			
			this.selectedProductItem.productNowPrice=this.getElementInnerText(itemContainer.findElement(this.byProductNowPrice)).replace("Current price:", "").trim();

			if(this.checkProductItemWasPriceExisting(itemContainer)) {
				this.selectedProductItem.productWasPrice=this.getElementInnerText(itemContainer.findElement(this.byProductWasPrice)).replace("Previous price:", "").trim();
			}
		}
		else {
			itemContainer=this.productResultList.get(0);
			this.selectedProductItem.init();
			this.selectedProductItem.productName=this.getElementInnerText(itemContainer.findElement(this.byProductName));

			if(this.checkProductItemBrandNameExisting(itemContainer)) {
				this.selectedProductItem.productBrand=this.getElementInnerText(itemContainer.findElement(this.byProductBrand)).replace("By", "").trim();
			}

			this.selectedProductItem.productNowPrice=this.getElementInnerText(itemContainer.findElement(this.byProductNowPrice)).replace("Current price:", "").trim();

			if(this.checkProductItemWasPriceExisting(itemContainer)) {
				this.selectedProductItem.productWasPrice=this.getElementInnerText(itemContainer.findElement(this.byProductWasPrice)).replace("Previous price:", "").trim();
			}
		}
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(itemContainer);
		this.getReusableActionsInstance().scrollToElement(itemContainer);
									
		String lsSelectedTitle,lsType;

		this.selectedProductItem.productSelectedSize="";
		this.selectedProductItem.productSelectedColor="";

		lsType=this.judgeProductOptionType(itemContainer);

		//If all displayed size or color are disabled
		if(!checkProductSizeOptionEnabledItemAvailableWithMouseHover(itemContainer)||!checkProductColorOptionEnabledItemAvailableWithMouseHover(itemContainer)) {
			reporter.reportLog("No enabled size/color option available");
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

		lsProductName=pdp.getElementInnerText(pdp.lblProductName);
		if(lsProductName.equalsIgnoreCase(this.selectedProductItem.productName)) {
			reporter.reportLogPass("The product name of "+this.selectedProductItem.productName+" in PRP is the same as the one of "+lsProductName+" displayed in PDP");
		}
		else {
			reporter.reportLogFailWithScreenshot("The product name of "+this.selectedProductItem.productName+" in PRP is not the same as the one of "+lsProductName+" displayed in PDP");
		}

		if(!this.selectedProductItem.productBrand.isEmpty()) {
			String lsProductBrand=pdp.getElementInnerText(pdp.lnkBrandName).replace("Brand:", "").trim();
			if(lsProductBrand.toUpperCase().contains(this.selectedProductItem.productBrand.toUpperCase())) {
				reporter.reportLogPass("The product brand of "+this.selectedProductItem.productBrand+" in PRP is the same as the one of "+lsProductBrand+" displayed in PDP");
			}
			else {
				reporter.reportLogFailWithScreenshot("The product brand of "+this.selectedProductItem.productBrand+" in PRP is not the same as the one of "+lsProductBrand+" displayed in PDP");
			}
		}

		String lsProductNowPrice=pdp.getElementInnerText(pdp.lblProductNowPrice);
		if(lsProductNowPrice.equalsIgnoreCase(this.selectedProductItem.productNowPrice)) {
			reporter.reportLogPass("The product NowPrice of "+this.selectedProductItem.productNowPrice+" in PRP is the same as the one of "+lsProductNowPrice+" displayed in PDP");
		}
		else {
			reporter.reportLogFailWithScreenshot("The product NowPrice of "+this.selectedProductItem.productNowPrice+" in PRP is not the same as the one of "+lsProductNowPrice+" displayed in PDP");
		}

		if(!this.selectedProductItem.productWasPrice.isEmpty()){
			String lsProductWasPrice=pdp.getElementInnerText(pdp.lblProductWasPrice).replace("Was","").trim();
			if(lsProductWasPrice.equalsIgnoreCase(this.selectedProductItem.productWasPrice)) {
				reporter.reportLogPass("The product WasPrice of "+this.selectedProductItem.productWasPrice+" in PRP is the same as the one of "+lsProductWasPrice+" displayed in PDP");
			}
			else {
				reporter.reportLogFailWithScreenshot("The product WasPrice of "+this.selectedProductItem.productWasPrice+" in PRP is not the same as the one of "+lsProductWasPrice+" displayed in PDP");
			}
		}

		if(!this.selectedProductItem.productSelectedSize.isEmpty()) {
			lsSelectedTitle=this.getElementInnerText(pdp.lblSizeTitle).split(":")[1].trim();
			if(lsSelectedTitle.equalsIgnoreCase(this.selectedProductItem.productSelectedSize)) {
				reporter.reportLogPass("The selected size in PRP is the same as the one displayed in PDP");
			}
			else {
				reporter.reportLogFailWithScreenshot("The selected size in PRP is not the same as the one displayed in PDP");
			}
		}

		if(!this.selectedProductItem.productSelectedColor.isEmpty()) {
			lsSelectedTitle=this.getElementInnerText(pdp.lblRadioProductStyleTitle).split(":")[1].trim();
			if(lsSelectedTitle.equalsIgnoreCase(this.selectedProductItem.productSelectedColor)) {
				reporter.reportLogPass("The selected color in PRP is the same as the one displayed in PDP");
			}
			else {
				reporter.reportLogFailWithScreenshot("The selected color in PRP is not the same as the one displayed in PDP");
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

		//Choose size
		optionList=itemContainer.findElements(byProductOptionSizeItemEnabledList);
		element=optionList.get(optionList.size()-1);
		if(element.getTagName().equalsIgnoreCase("button")) {								
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			this.getReusableActionsInstance().clickIfAvailable(element);
		}
		else {
			WebElement dropDown=element.findElement(By.xpath("./parent::select"));
			checkSizeSelectOptions(itemContainer,dropDown);
		}		

		//Choose color
		optionList=itemContainer.findElements(byProductOptionColorItemEnabledList);
		element= optionList.get(optionList.size()-1);

		if(element.getTagName().equalsIgnoreCase("button")) {								
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			this.getReusableActionsInstance().clickIfAvailable(element);
		}
		else {
			WebElement dropDown=element.findElement(By.xpath("./parent::select"));
			checkColorSelectOptions(itemContainer,dropDown);
		}		

		//Storing size and color for verification on PDP page


		itemContainer.findElement(this.byProductGoToDetails).click();
		this.waitForPDPPageLoading();
		if(this.URL().toLowerCase().contains("productdetails")) {
			reporter.reportLogPass("The user is navigated to PDP page");
		}
		else {
			reporter.reportLogFailWithScreenshot("The user is not navigated to PDP page");
		}
	}

	/**
	 * This method will verify Favorite Icon clicking Action
	 * @param-String lsUserName: user name
	 * @param-String lsPassword: password
	 * @param-String lsFirstName: user's first name
	 * @param-ProductDetailPage pdp: ProductDetailPag pageobject
	 * @param - MyAccount - myAccount
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyFavoriteIconAction(String lsUserName, String lsPassword,String lsKeyword,ProductDetailPage pdp,MyAccount myAccount) {
		if(this.productResultList.size()==0) {
			reporter.reportLog("No product search result available.");
			return;
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productResultList.get(0));
		String prpProductName=this.getElementInnerText(this.productResultList.get(0).findElement(this.byProductName));
		String prpProductNowPrice=this.getElementInnerText(this.productResultList.get(0).findElement(this.byProductNowPrice)).split(":")[1].trim();
		int prpReviewRateStarCount=this.getProductItemReviewNumberAmountFromStarImage(this.productResultList.get(0).findElements(this.byProductReviewRatingImage));
		String prpReviewCountInfo=this.getElementInnerText(this.productResultList.get(0).findElement(this.byProductReviewRatingCount));
		String prpProductFreeShipping=this.getElementInnerText(this.productResultList.get(0).findElement(this.byProductFreeShipping));

		SignInPage loginPage=new SignInPage(this.getDriver());
	
		WebElement item=this.productResultList.get(0).findElement(this.byProductHeaderLike);

		if(!item.getAttribute("class").contains("product-card__header-like--liked")) {
			reporter.reportLogPass("The favorite icon is displaying not clicking status correctly");
		}
		else {
			reporter.reportLogFailWithScreenshot("The favorite icon is not displaying not clicking status correctly");
		}

		this.getReusableActionsInstance().clickIfAvailable(item);
		this.getReusableActionsInstance().waitForElementVisibility(loginPage.lblSignIn, 60);

		loginPage.LoginWithoutWaitingTime(lsUserName, lsPassword);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,180);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		item=this.productResultList.get(0).findElement(this.byProductHeaderLike);

		if(item.getAttribute("class").contains("product-card__header-like--liked")) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productResultList.get(0));
			this.getReusableActionsInstance().clickIfAvailable(item);
			this.getReusableActionsInstance().staticWait(5*this.getStaticWaitForApplication());
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productResultList.get(0));
		this.getReusableActionsInstance().clickIfAvailable(item);
		this.getReusableActionsInstance().staticWait(5*this.getStaticWaitForApplication());

		if(item.getAttribute("class").contains("product-card__header-like--liked")) {
			reporter.reportLogPass("The favorite icon is displaying clicking status correctly");
		}
		else {
			reporter.reportLogFailWithScreenshot("The favorite icon is not displaying clicking status correctly");			
		}
				
		//Bug 19538: [QA Defect - P3] PRP: missing Free Shipping label
		if(!prpProductFreeShipping.isEmpty()) {
			reporter.reportLogPass("Product free shipping is not empty");
		}
		else {
			reporter.reportLogFailWithScreenshot("Product free shipping is empty");
		}
				
		item=this.productResultList.get(0).findElement(byProductHref);
		this.getReusableActionsInstance().clickIfAvailable(item);
		this.waitForPDPPageLoading();
		
		//Bug 19559: [QA Defect - P3] Products show different ratings in PRP vs. PDP
		String pdpProductName=this.getElementInnerText(pdp.lblProductName);
		String pdpProductNowPrice=this.getElementInnerText(pdp.lblProductNowPrice);
		int pdpReviewRateStarCount=this.getProductItemReviewNumberAmountFromStarImage(pdp.lstProductReviewStar);
		String pdpReviewCountInfo=this.getElementInnerText(pdp.lblProductReviewCount);
		
		if( prpProductName.equalsIgnoreCase( pdpProductName)) {
			reporter.reportLogPass("The Product name in PRP is the same as the one in PDP");
		}
		else {
			reporter.reportLogFailWithScreenshot("The Product name in PRP is not the same as the one in PDP");
		}

		if( this.getFloatFromString(prpProductNowPrice,true)==this.getFloatFromString( pdpProductNowPrice,true)) {
			reporter.reportLogPass("The Product NowPrice in PRP is the same as the one in PDP");
		}
		else {
			reporter.reportLogFailWithScreenshot("The Product NowPrice in PRP is not the same as the one in PDP");
		}
		
		if(prpReviewRateStarCount==pdpReviewRateStarCount) {
			reporter.reportLogPass("The review rate star count in PRP is equal to the count in PDP");
		}
		else {
			reporter.reportLogFailWithScreenshot("The review rate star count in PRP is not equal to the count in PDP");
		}
				
		if(pdpReviewCountInfo.equalsIgnoreCase(prpReviewCountInfo)) {
			reporter.reportLogPass("The review count info in PRP is the same as count info in PDP");
		}
		else {
			reporter.reportLogFailWithScreenshot("The review count info in PRP is not the same as count info in PDP");
		}
	
		//Bug 19539: [QA Defect - P3] Favorite an item in PRP doesn't sync up to PDP
		if(pdp.checkIfFavShareMobileHighlighted()) {
			reporter.reportLogPass("The FavShareMobile icon is highlighted correctly");
		}
		else {
			reporter.reportLogFailWithScreenshot("The FavShareMobile icon is not highlighted correctly");
		}		
	}
	
	/**
	 * This method will verify product content existing after switching to French language
	 * @param-GlobalFooterPage globalFooterPage: GlobalFooterPage pageobject
	 * @return void
	 * @author Wei.Li
	 */
	//Bug 19542: [QA Defect - P3] PRP: no products display in French
	public void verifyProductContentExistingAfterSwitchToFrench(GlobalFooterPage globalFooterPage) {
		globalFooterPage.switchlanguage();
		this.waitForPageToLoad();
		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,120);

		if(productResultList.size()>0) {
			reporter.reportLogPass("The product list is displaying correctly after switching to French language");
		}
		else {
			reporter.reportLogFailWithScreenshot("The product list is not displaying correctly after switching to French language");
		}
	}
	
	/**
	 * This method will verify product loading through Url directly
	 * @param-String lsUrl: the Url that will be inputted in Browser directly
	 * @return void
	 * @author Wei.Li
	 */
	//Bug 19553: [QA Defect - P3] Direct search from URL doesn't make a PRP API call
	public void verifyProductLoadingThroughUrlDirectly(String lsUrl) {
		this.getDriver().get(lsUrl);
		this.waitForPageToLoad();
		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,120);

		if(productResultList.size()>0) {
			reporter.reportLogPass("The product list is loading correctly through inputting Url directly");
		}
		else {
			reporter.reportLogFailWithScreenshot("The product list is not loading correctly through inputting Url directly");
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
		String lsText=this.getElementInnerText(item);
		return lsText.length()>1;
	}

	/**
	 * This method will check Product Item review Existing
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductItemReviewExisting(WebElement itemContainer) {
		return this.checkChildElementExistingByTagName(itemContainer.findElement(this.byProductReviewContainer),"span");
	}

	/**
	 * This method will check Product Item Free Shipping Existing
	 * @param-WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductItemFreeShippingExisting(WebElement itemContainer) {
		return this.checkChildElementExistingByAttribute(itemContainer, "class", "product-card__free-shipping");
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
		String lsText=this.getElementInnerText(item);

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
		return !item.getAttribute("class").contains("prp-filter-panel__block-title__icon--plus");
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
			if(!checkIfFilterItemIsCollapsed(filterContainerItem)){
				collapseFilterItemWithClickingProductTitle(filterContainerItem);
			}
			return;
		}

		WebElement productFilterTitle=filterContainerItem.findElement(this.byProductFilterTitle);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productFilterTitle);
		this.getReusableActionsInstance().clickIfAvailable(productFilterTitle);
		this.waitForCondition(Driver->{return checkIfFilterItemIsCollapsed(filterContainerItem);},5000);

		clickSeeMoreButton(filterContainerItem);
		if(!checkIfFilterItemIsCollapsed(filterContainerItem)){
			collapseFilterItemWithClickingProductTitle(filterContainerItem);
		}
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
		this.clickElement(productFilterTitle);
		this.waitForCondition(Driver->{return !checkIfFilterItemIsCollapsed(filterContainerItem);},15000);
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
		this.waitForCondition(Driver->{return checkIfFilterItemIsCollapsed(filterContainerItem);},5000);
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
			this.clickElement(seeMoreButton);
			this.waitForCondition(Driver->{return this.checkFilterItemSeeButtonExisting(filterContainerItem).equalsIgnoreCase("SeeLess");},5000);
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
			this.clickElement(seeLessButton);
			this.waitForCondition(Driver->{return this.checkFilterItemSeeButtonExisting(filterContainerItem).equalsIgnoreCase("SeeMore");},5000);
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
		return this.checkChildElementExistingByTagNameAndAttribute(searchInputContainer, "input", "class", "prp-filter-panel__search");
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
	 * This method will check ViewAllColors Button Existing
	 * @param-WebElement filterContainerItem: filter Container Item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkViewAllColorsButtonExisting(WebElement filterContainerItem) {
		WebElement colorContainer=filterContainerItem.findElement(this.byProductOptionColorWrapper);
		return this.checkChildElementExistingByTagNameAndAttribute(colorContainer, "a", "class", "product-card__size-view-all");
	}

	/**
	 * This method will check with element has both size and colour available
	 * @param-WebElement webElement - parent webElement
	 * @return boolean
	*/
	public boolean findItemWithAvailableSizeAndColorDropDown(WebElement webElement){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
		this.getReusableActionsInstance().scrollToElement(webElement);

		WebElement itemSize=webElement.findElement(this.byProductOptionSize);
		WebElement itemColor=webElement.findElement(this.byProductOptionColor);

		if(!(!itemSize.getCssValue("height").equalsIgnoreCase("0px")&&
				!itemColor.getCssValue("height").equalsIgnoreCase("0px"))){
			return false;
		}

		if(checkColorProductOptionIsDropdownWithMouseHover(webElement)){
			return true;
		}

		return false;
	}

	/**
	 * This method will check all elements present on page is of particular brand
	 * @param-String - brand name to search on PRP page
	 * @return boolean
	 */
	public void verifyProductsOnPRPByBrandName(String brandName){
		//Defining and initializing variables
		boolean filterBrandNameFlag = false;
		String filterName = null,lsBrandName;
		List<WebElement> productList;
		WebElement item,element;

		if(System.getProperty("Device").equalsIgnoreCase("Desktop")){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstFilterApplied.get(0));
			for(int counter=0;counter<lstFilterApplied.size();counter++){
				filterName = lstFilterApplied.get(counter).getText();
				if(brandName.toLowerCase().trim().equals(filterName.toLowerCase().trim())){
					filterBrandNameFlag = true;
					break;
				}
			}
		}else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstFilterApplied_Mobile);
			filterName=this.lstFilterApplied_Mobile.getText();
			if(brandName.toLowerCase().trim().equals(filterName.toLowerCase().trim()))
				filterBrandNameFlag = true;
		}

		//Verifying brand name in filter
		if(filterBrandNameFlag)
			reporter.reportLogPass("Brand Name on PDP page i.e. "+brandName+" is same as in filter on PRP page: "+filterName);
		else
			reporter.reportLogFailWithScreenshot("Brand Name on PDP page i.e. "+brandName+" is not same as in filter on PRP page: "+filterName);

		//Verifying product on page are of same selected brand
		productList=this.getProductList();
		for(int brandNameCounter=0;brandNameCounter<productList.size();brandNameCounter++) {
			item=productList.get(brandNameCounter);
			element=item.findElement(byProductBrand);
			lsBrandName=this.getElementInnerText(element).split("By ")[1];
			if(lsBrandName.toLowerCase().trim().equals(brandName.toLowerCase().trim()))
				reporter.reportLogPass("Brand name of product on PRP page: "+lsBrandName+" is same as on PDP page: "+brandName);
			else
				reporter.reportLogFailWithScreenshot("Brand name of product on PRP page: "+lsBrandName+" is not same as on PDP page: "+brandName);
		}
	}

	/**
	 * This method will verify search result message on PRP page for input keyword
	 * @param-String - searchkeyword to search on PRP page
	 * @return boolean
	 */
	//Bug-19544-Select a brand in SYAT should not display Search Term
	//Bug-19672-PRP showing result label getting encoded from search
	public void verifySearchResultMessageOnPage(String searchKeyword){
		this.waitForCondition(Driver->{return this.lblProductCountOnPage.isDisplayed();},12000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductCountOnPage);
		this.getReusableActionsInstance().scrollToElement(this.lblProductCountOnPage);
		String searchTitleMessage = null;

		//if block is for Bug-19544 and else block is for Bug-19772
		//Verifying below if keyword is a brand or normal search. If it is brand, no message should be displayed
//		String searchModel = this.judgeTestModel();
//		if(searchModel.toLowerCase().contains("banner")){
//			boolean itemExistenceFlag = this.checkChildElementExistingByTagName(cntSearchResultContainer,"h2");
//			if(!itemExistenceFlag)
//				reporter.reportLogPass("Search Result Text is not present for search keyword which is a brand");
//			else
//				reporter.reportLogFailWithScreenshot("Search Result Text is present for search keyword which is a brand");
//		}else{
			this.waitForCondition(Driver->{return this.lblSearchResultTitleMessage.isDisplayed();},5000);
			if(System.getProperty("Browser").toLowerCase().contains("safari"))
				//For safari, one more space is inserted in between due to way inner text is coming in html
				//and hence removing that extra space
				searchTitleMessage = this.lblSearchResultTitleMessage.getText().split("\"")[1].trim()+" ";
			else
				searchTitleMessage = this.lblSearchResultTitleMessage.getText().split("\"")[1];
			this.searchkeyword = searchKeyword.trim()+" ";
			if(this.searchkeyword.equals(searchTitleMessage))
				reporter.reportLogPass("Search Result message on page: "+searchTitleMessage+ " is same as input search keyword: "+searchKeyword);
			else
				reporter.reportLogFailWithScreenshot("Search Result message on page: "+searchTitleMessage+ " is not same as input search keyword: "+searchKeyword);
//		}
	}
	
	/**
	 * This method will verify Product Contents have No Changes After Navigating Back With MultiFilters
	 * @param-List<List<String>> lstFilter: filter list
	 * @return void
	 */
	//Bug 19658: [QA Defect - P3] PRP: Page not refreshed to previous state with browser back button with filter applied
	public void verifyProductContentNoChangesAfterNavigatingBackWithMultiFilters(List<List<String>> lstFilter){	
		switchPage(true);
		
		List<String> lstItem=lstFilter.get(0);
		selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1));
		String lsFirstProductNameForFirstFilter=this.getElementInnerText(this.productResultList.get(0).findElement(byProductName));
		int productCount=this.productResultList.size();
		
		lstItem=lstFilter.get(1);
		selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1));

		this.getDriver().navigate().back();
		this.waitForPageToLoad();
		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,120);
		
		String lsFirstProductNameForNavigateBackFilter=this.getElementInnerText(this.productResultList.get(0).findElement(byProductName));
		int productCountForNavigateBack=this.productResultList.size();
		
		if(lsFirstProductNameForNavigateBackFilter.equalsIgnoreCase(lsFirstProductNameForFirstFilter)&&(productCountForNavigateBack==productCount)) {
			reporter.reportLogPass("The product search results are keeping the same status as just first filter applied"); 
		}
		else {
			reporter.reportLogFailWithScreenshot("The product search results are not keeping the same status as just first filter applied"); 
		}	
	}
	
	/**
	 * This method will verify Applied Product SubFilter Remains After Multi Categories Selection Through BreadCrumb Navigation
	 * @param-List<List<String>> lstFilter: filter list
	 * @return void
	 */
	//Bug 19659: [QA Defect] PRP Breadcrumb: Not keeping the past filters applied
	public void verifyAppliedProductSubFilterRemainsAfterMultiCategoriesSelectionThroughBreadCrumbNavigation(List<List<String>> lstFilter){	
		//Select first category item
		this.bCategoryExpand=true;
		List<String> lstItem=lstFilter.get(0);
		selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1));
		
		if(!checkSelectedFilterListExisting()) {
			reporter.reportLogPass("The selected filter list for first Category filter is not displaying"); 
		}
		else {
			reporter.reportLogFailWithScreenshot("The selected filter list for first Category filter is displaying wrongly"); 
		}		
		
		//Apply a subfilter
		lstItem=lstFilter.get(1);
		selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1));
				
		//Check if selected list existing
		if(checkSelectedFilterListExisting()) {
			reporter.reportLogPass("The selected filter list after selecting filters is displaying correctly"); 
		}
		else {
			reporter.reportLogFailWithScreenshot("The selected filter list after selecting filters is not displaying correctly"); 
		}

		//Select first category item
		this.bCategoryExpand=false;
		lstItem=lstFilter.get(2);
		selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1));
		
		WebElement item=this.lstSearchResultNavigation.get(this.lstSearchResultNavigation.size()-2);
		item=item.findElement(By.xpath(".//a"));
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		this.getReusableActionsInstance().clickIfAvailable(item);
		this.waitForPageToLoad();
		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,120);
		
		//Check if selected list existing
		if(checkSelectedFilterListExisting()) {
			reporter.reportLogPass("The selected filter list after navigating from BreadCrumb is displaying correctly"); 
		}
		else {
			reporter.reportLogFailWithScreenshot("The selected filter list after navigating from BreadCrumb is not displaying correctly"); 
		}
	}
	
	/**
	 * This method will verify BreadCrumb After Selecting CuratedCollections Item
	 * @param-List<List<String>> lstFilter: filter list
	 * @return void
	 */
	//Bug 19690: [UAT Defect] The breadcumb breaks non category/brand PRPs and a server error is triggered
	public void verifyBreadCrumbAfterSelectCuratedCollectionsItem(List<List<String>> lstFilter,GlobalHeaderPage ghp){	
		//Select first category item
		List<String> lstItem=lstFilter.get(0);
		ghp.clickCuratedCollectionsMenuItem(lstItem.get(0), lstItem.get(1));
		this.waitForPageToLoad();
		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessageKeyWordTitle,120);
		
		int navigateItemCount=this.lstSearchResultNavigation.size();
		if(navigateItemCount==2) {
			reporter.reportLogPass("The Navigation Breadcrumb list is containing 2 items correctly"); 
		}
		else {
			reporter.reportLogFailWithScreenshot("The Navigation Breadcrumb list is not containing 2 items correctly"); 
		}
		
		WebElement item=this.lstSearchResultNavigation.get(this.lstSearchResultNavigation.size()-1);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		String lsText=item.getText().trim();
		if(lstItem.get(1).equalsIgnoreCase(lsText)) {
			reporter.reportLogPass("The displaying pattern is Home>"+lstItem.get(1)); 
		}
		else {
			reporter.reportLogFailWithScreenshot("The displaying pattern is not Home>"+lstItem.get(1)); 
		}
	}

	public void verifyMoreAndLessButton(List<String> lstMoreButton) {
		for (String lsHeader : lstMoreButton) {
			//Get the element container corresponding to the first level filter
			WebElement element = getFilterContainerWithSpecificFirstlevelFilterInLeftPanel(lsHeader);
			if (element == null) {
				break;
			}

			if (!checkIfFilterItemIsCollapsed(element)) {
				collapseFilterItemWithClickingProductTitle(element);
			}

			if (checkFilterItemSeeButtonExisting(element).equalsIgnoreCase("None")) {
				uncollapseFilterItemWithClickingProductTitle(element);
				continue;
			}
			int elementCountBeforeClickingSeeMoreButton = getFiltersCountInSecondLevel();

			clickSeeMoreButton(element);
			if (!checkIfFilterItemIsCollapsed(element)) {
				collapseFilterItemWithClickingProductTitle(element);
			}

			int elementCountAfterClickingSeeMoreButton = getFiltersCountInSecondLevel();

			if (elementCountAfterClickingSeeMoreButton > elementCountBeforeClickingSeeMoreButton) {
				reporter.reportLogPass("The subitem count after clicking SeeMore button is more than the count before clicking SeeMore button");
			} else {
				reporter.reportLogFailWithScreenshot("The subitem count after clicking SeeMore button is no more than the count before clicking SeeMore button");
			}

			clickSeeLessButton(element);
			if (!checkIfFilterItemIsCollapsed(element)) {
				collapseFilterItemWithClickingProductTitle(element);
			}

			int elementCountAfterClickingSeeLessButton = getFiltersCountInSecondLevel();

			if (elementCountBeforeClickingSeeMoreButton == elementCountAfterClickingSeeLessButton) {
				reporter.reportLogPass("The subitem count after clicking SeeLess button is equal to the count before clicking SeeMore button");
			} else {
				reporter.reportLogPass("The subitem count after clicking SeeLess button is not equal to the count before clicking SeeMore button");
			}

			uncollapseFilterItemWithClickingProductTitle(element);
		}
	}

	/**
	 * This method verifies PRP page after loading url directly in browser
	 * @param-HashMap<String,String> pageData Loaded page data that will be used
	 */
	public void verifyPRPPageAfterLoadingDataUsingAPIParameter(HashMap<String,String> pageData){
		this.getDriver().get(pageData.get("url"));

		this.waitForPageLoading();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntPagination);
		this.getReusableActionsInstance().scrollToElement(this.cntPagination);
		verifyShowingTextPatternInFilters();
		this.verifySelectedFilterAndItemsOnPage(pageData);
	}

	/**
	 * This method verifies PRP page after loading url directly in browser
	 * @param-HashMap<String,String> pageData Loaded page data that will be used for verification
	 */
	public void verifySelectedFilterAndItemsOnPage(HashMap<String,String> pageData){
		//Verification of selected sort filter on page
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSortSelect);
		getReusableActionsInstance().scrollToElement(this.btnSortSelect);
		Select sortOption= new Select(this.btnSortSelect);
		String selectedFilter = sortOption.getFirstSelectedOption().getText();
		if(selectedFilter.equalsIgnoreCase(pageData.get("sortKey")))
			reporter.reportLogPass("Filter selected in dropdown: "+selectedFilter+" is as expected: "+pageData.get("sortKey"));
		else
			reporter.reportLogFailWithScreenshot("Filter selected in dropdown: "+selectedFilter+" is not as expected: "+pageData.get("sortKey"));

		//Verification of number of items displayed on page
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntPagination);
		this.getReusableActionsInstance().scrollToElement(this.cntPagination);

		int itemsOnPage;
		if(pageData.get("page").equalsIgnoreCase("1"))
			itemsOnPage = Integer.valueOf(this.txtShowingDynamicContent.getText().split(" ")[2]);
		else
			itemsOnPage = Integer.valueOf(this.txtShowingDynamicContent.getText().split(" ")[0])-1;
		if(itemsOnPage > 0 && itemsOnPage<=Integer.valueOf(pageData.get("pageSize")))
			reporter.reportLogPass("Items displayed on page are: "+itemsOnPage+" and is as expected: "+pageData.get("pageSize"));
		else
			reporter.reportLogFailWithScreenshot("Items displayed on page are: "+itemsOnPage+" and is not as expected: "+pageData.get("pageSize"));

		//Verification that title is as expected
		String pageTitleType = this.judgeTestModel();
		if(pageTitleType.contains("Banner")){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblBreadcrumbLastProductName);
			this.getReusableActionsInstance().scrollToElement(this.lblBreadcrumbLastProductName);

			String bannerProductName = this.lblBreadcrumbLastProductName.getText();
			if(pageData.get("searchTerm").toLowerCase().contains(bannerProductName))
				reporter.reportLogPass("Search Term on page for Banner Search: "+bannerProductName+" is same as in api call: "+pageData.get("searchTerm"));
			else
				reporter.reportLogFailWithScreenshot("Search Term on page for Banner Search: "+bannerProductName+" is not same as in api call: "+pageData.get("searchTerm"));
		}else if(pageTitleType.contains("Normal")){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSearchResultMessage);
			this.getReusableActionsInstance().scrollToElement(this.lblSearchResultMessage);

			String titleMessage = this.lblSearchResultMessage.getText().split("\"")[1];
			if(titleMessage.equalsIgnoreCase(pageData.get("searchTerm")))
				reporter.reportLogPass("Search Term on page for Normal Search: "+titleMessage+" is same as in api call: "+pageData.get("searchTerm"));
			else
				reporter.reportLogFailWithScreenshot("Search Term on page for Normal Search: "+titleMessage+" is not same as in api call: "+pageData.get("searchTerm"));
		}else
			reporter.reportLogFailWithScreenshot("Not a valid search criteria");
	}

	/**
	 * @param - String - searchkeyword to search Product
	 */
	//BUG-19789 - PRP left nav should display all available facets
	public void verifyCategoryDetailsOnPRPForProduct(List<Product.DimensionStates> categoryDimensions,String searchKeyword) {
		List<String> categoryItemsOnPage = new ArrayList<>();
		if(System.getProperty("Device").equalsIgnoreCase("Desktop")){
			this.getSearchResultLoad(searchKeyword, true);
			this.waitForPageLoading();
		}
		for (WebElement webElement : productFilterContainerList) {
			boolean breakFlag = false;
			String filterTitle = this.getElementInnerText(webElement.findElement(By.xpath(".//button/span")));
			if (filterTitle.equalsIgnoreCase("Category")) {
				breakFlag = true;
				//Enter code here to check if Category is open

				List<WebElement> lstCategoryItems = webElement.findElements(this.bySecondaryFilterAll);
				for (WebElement categoryItem : lstCategoryItems) {
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(categoryItem);
					categoryItemsOnPage.add(categoryItem.findElement(By.xpath("./a")).getText());
				}
			}
			//Verification of categories displayed on UI
			List<Product.Refinements> refinements = null;
			List<String> refinementListfromAPI = new ArrayList<>();
			for (Product.DimensionStates dimensionStates : categoryDimensions) {
				if (dimensionStates.getDimensionType().equalsIgnoreCase("Category")) {
					refinements = dimensionStates.getRefinements();
					for (Product.Refinements data : refinements) {
						refinementListfromAPI.add(data.getDimensionName());
					}
					break;
				}
			}

			if (refinementListfromAPI.size() > 0) {
				for (String refinementItem : refinementListfromAPI) {
					boolean flag = false;
					String categoryItemNameOnPage = null;
					for (String categoryItemOnPage : categoryItemsOnPage) {
						categoryItemNameOnPage = categoryItemOnPage;
						if (refinementItem.equalsIgnoreCase(categoryItemOnPage)) {
							flag = true;
							break;
						}
					}
					if (flag)
						reporter.reportLogPass("Category displayed on PRP page: " + categoryItemNameOnPage + " is same as in api call: " + refinementItem);
					else
						reporter.reportLogFailWithScreenshot("Category displayed on PRP page: " + categoryItemNameOnPage + " is not same as in api call: " + refinementItem);
				}
				if (breakFlag)
					break;
			} else
				reporter.reportLog("Category items are not checked as refinement is null");
		}
	}
	/**
	 * This method fetches the total count of pages on PRP page for searched product
	 * @param-void
	 * @return-int- total number of pages for searched product
	 */
	public int getTotalProductPageCountAfterSearch(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntPagination);
		this.getReusableActionsInstance().scrollToElement(this.cntPagination);
		return this.PageNumberList.size();
	}

	/**
	 * This method verifies PRP page pagination after loading url directly in browser
	 * @param-HashMap<String,String> prpPagePaginationData Loaded page data that will be used for verification
	 */
	public void verifyPaginationCountOnLastPage(Map<String,String> prpPagePaginationData){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductCountOnPage);
		int itemCount = Integer.valueOf(this.lblProductCountOnPage.getText().split(" ")[0]);
		//int totalPagesOnPRPForItem = this.getTotalProductPageCountAfterSearch();
		getDriver().get(prpPagePaginationData.get("pageURL"));
		waitForCondition(driver->{return (this.lblSearchResultMessage.isDisplayed() && !this.lblSearchResultMessage.getText().isEmpty() && this.getProductList().size()>0);},10000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntPagination);
		this.getReusableActionsInstance().scrollToElement(this.cntPagination);
		/**
		//Verifying total page count for searched product
		if(totalPagesOnPRPForItem==Integer.valueOf(prpPagePaginationData.get("totalPages")))
			reporter.reportLogPass("Page Count on PRP page for no if items is: "+totalPagesOnPRPForItem+" and are same as fetched from API: "+Integer.valueOf(prpPagePaginationData.get("totalPages")));
		else
			reporter.reportLogFailWithScreenshot("Page Count on PRP page for no if items is: "+totalPagesOnPRPForItem+" and are same as fetched from API: "+Integer.valueOf(prpPagePaginationData.get("pageCount")));
		*/
		//Verifying total items on page count
		String[] dynamicPaginationContent = this.txtShowingDynamicContent.getText().split(" ");
		int startItemCountInDynamicText = Integer.valueOf(dynamicPaginationContent[0]);
		int finalItemCountInDynamicText = Integer.valueOf(dynamicPaginationContent[2]);
		int itemCountInPaginationSection = Integer.valueOf(dynamicPaginationContent[dynamicPaginationContent.length-1]);
		if(itemCount==itemCountInPaginationSection)
			reporter.reportLogPass("Item Count on PRP page displayed at top: "+itemCount+" is same as in pagination: "+itemCountInPaginationSection);
		else
			reporter.reportLogFailWithScreenshot("Item Count on PRP page displayed at top: "+itemCount+" is not same as in pagination: "+itemCountInPaginationSection);
		//Verifying page items in Dynamic Text in Pagination
		if(finalItemCountInDynamicText==itemCountInPaginationSection)
			reporter.reportLogPass("Item Count on PRP page displayed in pagination: "+finalItemCountInDynamicText+" is same as in pagination: "+itemCountInPaginationSection);
		else
			reporter.reportLogFailWithScreenshot("Item Count on PRP page displayed in pagination:: "+finalItemCountInDynamicText+" is not same as in pagination: "+itemCountInPaginationSection);
		//Verifying beginning page items in Dynamic Text is less than final Item Dynamic Text in Pagination
		if(startItemCountInDynamicText<=finalItemCountInDynamicText)
			reporter.reportLogPass("Starting item Count on PRP page displayed in pagination: "+startItemCountInDynamicText+" is less than final dynamic item count: "+finalItemCountInDynamicText);
		else
			reporter.reportLogFailWithScreenshot("Starting item Count on PRP page displayed in pagination:: "+startItemCountInDynamicText+" is not less than final dynamic item count: "+finalItemCountInDynamicText);
	}

	/**
	 * This method verifies that PRP page loads and display items for item that have no swatch and more than 16 items
	 * @param-List<String> - inputParams containing properties of Product to look for
	 */
	public boolean loadProductOnPRPPageForItemWithMoreThanSixteenVariantsAndNoSwatch(List<String> inputParams,String defaultItemsCountOnPRP) throws IOException {
		ProductAPI productAPI=new ProductAPI();
		Map<String,Object> inputParamMap = new HashMap<>();
		inputParamMap.put("size",0);
		inputParamMap.put("style",inputParams.get(1));
		inputParamMap.put("pageSize",defaultItemsCountOnPRP);
		inputParamMap.put("video",0);
		Product.Products product = productAPI.getProductInfoFromKeyword(inputParams.get(0),inputParamMap,false,true,false);

		if(product!=null){
			reporter.reportLog("Searching product: "+product.getName());
			this.getSearchResultLoad(product.getName(),true);
			return true;
		}
		return false;
	}

	/**
	 * This method verifies product on PRP that has more than sixteen color and no size by selecting color
	 * @param-void
	 */
	public void verifyProductWithMoreThanSixteenVariant(){
		waitForCondition(driver->{return (this.getProductList().size()>0);},10000);
		List<WebElement> product = this.getProductList();
		for(int counter=0;counter<product.size();counter++){
			//Mouseover on product list displayed on PRP page
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(product.get(counter));
			this.getReusableActionsInstance().scrollToElement(product.get(counter));

			final int finalCounterFirst = counter;
			waitForCondition(driver->{return (product.get(finalCounterFirst).findElement(this.lstColourDropdown).isDisplayed() && product.get(finalCounterFirst).findElement(this.lstColourDropdown).isEnabled());},5000);
			//Fetching all colors that are enabled and selecting last enabled color

			//Selecting color from dropdown
			WebElement dropDown = product.get(counter).findElement(this.lstColourDropdown);
			List<WebElement> itemList;
			WebElement niceSelectButton;
			String colorToBeSelected="";
			if(dropDown.getAttribute("class").contains("visually-hidden")){
				niceSelectButton=product.get(counter).findElement(byProductOptionColorNiceSelectButton);
				this.clickElement(niceSelectButton);
				this.applyStaticWait(1000);
				itemList=product.get(counter).findElements(this.byProductOptionColorNiceSelectList);

				for(int j=itemList.size()-1;j>=0;j--) {
					if (!hasElementAttribute(itemList.get(j), "disabled")) {
						colorToBeSelected=this.getElementInnerText(itemList.get(j));
						this.clickElement(itemList.get(j));
						break;
					}
				}
			}
			else{
				Select select = new Select(dropDown);
				List<WebElement> enabledColor = product.get(counter).findElements(this.byProductOptionColorItemEnabledList);
				colorToBeSelected = enabledColor.get(enabledColor.size()-1).getAttribute("value");
				select.selectByValue(colorToBeSelected);
			}

			//Storing the value of selected color for verification
			int finalCounterSecond = counter;
			waitForCondition(driver->{return (!product.get(finalCounterSecond).findElement(this.byProductOptionColorSelectedColor).getText().isEmpty());},5000);
			String selectedColor = product.get(counter).findElement(this.byProductOptionColorSelectedColor).getText();
			if(selectedColor.equalsIgnoreCase(colorToBeSelected))
				reporter.reportLogPass("Color selected for product with more than 16 swatch:"+selectedColor+" is same as selected from dropdown: "+colorToBeSelected);
			else
				reporter.reportLogFailWithScreenshot("Color selected for product with more than 16 swatch:"+selectedColor+" is not same as selected from dropdown: "+colorToBeSelected);
		}
	}

	/**
	 * This method verifies product on PRP that has more than sixteen color and no size by selecting color
	 * @param-void
	 */
	public void selectAndVerifyProductColor(){
		waitForCondition(driver->{return (this.getProductList().size()>0 && (new GlobalHeaderPage(this.getDriver()).lblTSCChatBox.getText().contains("Chat")));},10000);
		List<WebElement> productList = this.getProductList();
		String colorToBeSelected = null;
		for(int counter=0;counter<productList.size();counter++){
			WebElement dropDown = productList.get(counter).findElement(this.lstColourDropdown);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(productList.get(counter));
			this.getReusableActionsInstance().scrollToElement(productList.get(counter));
			if(dropDown.getAttribute("class").contains("visually-hidden")){
				WebElement dropDownButtonElement = productList.get(counter).findElement(this.btnColorSelectionDropdown);
				this.getReusableActionsInstance().clickIfAvailable(dropDownButtonElement,2000);
				List<WebElement> enabledColors = productList.get(counter).findElements(this.btnEnabledColorInDropdown);
				colorToBeSelected=this.getElementInnerText(enabledColors.get(enabledColors.size()-1));
				this.clickElement(enabledColors.get(enabledColors.size()-1));
			}else{
				Select select = new Select(dropDown);
				List<WebElement> enabledColor = productList.get(counter).findElements(this.byProductOptionColorItemEnabledList);
				colorToBeSelected = enabledColor.get(enabledColor.size()-1).getAttribute("value");
				select.selectByValue(colorToBeSelected);
			}
			String selectedColor = productList.get(counter).findElement(this.byProductOptionColorSelectedColor).getText();
			if(colorToBeSelected.equalsIgnoreCase(selectedColor))
				reporter.reportLogPass("Selected color from dropdown: "+colorToBeSelected+" is same as displayed after selection: "+selectedColor);
			else
				reporter.reportLogFailWithScreenshot("Selected color from dropdown: "+colorToBeSelected+" is not same as displayed after selection: "+selectedColor);
		}
	}

	public boolean checkTitleAndTextSectionExisting(){
		return this.checkChildElementExistingByAttribute(this.cntProductTitleAndTextIdentifier,"class","TitleAndTextSeo");
	}

	/**
	 * To navigate from PRP to PDP
	 * @param - String - lsKeyword
	 * @param - boolean - bStyleAndSize - if check Style and Size
	 * @return - Map<String,String> - including productName,productBrand,productNowPrice,
	 * 			productWasPrice,productReviewRate,productReviewCount, productStyle, productSize
	 */
	public Map<String,String> navigateFromPRPToPDP(String lsKeyword, boolean bStyleAndSize){
		Map<String,String> map=new HashMap<>();
		WebElement element;
		String lsText;

		ProductDetailPage pdp=new ProductDetailPage(this.getDriver());

		reporter.reportLog("Search keyword: "+lsKeyword);
		this.getSearchResultLoad(lsKeyword,false);
		List<WebElement> productList=this.getProductList();
		WebElement item=productList.get(0);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		this.getReusableActionsInstance().scrollToElement(item);

		element=item.findElement(this.byProductName);
		lsText=this.getElementInnerText(element);
		map.put("productName",lsText);

		if(this.checkProductItemBrandNameExisting(item)){
			element=item.findElement(this.byProductBrand);
			lsText=this.getElementInnerText(element).replace("By","").trim();
			map.put("productBrand",lsText);
		}
		else{
			map.put("productBrand",null);
		}

		element=item.findElement(this.byProductNowPrice);
		lsText= String.valueOf(this.getFloatFromString(this.getElementInnerText(element),true));
		map.put("productNowPrice",lsText);

		if(this.checkProductItemWasPriceExisting(item)){
			element=item.findElement(this.byProductWasPrice);
			lsText= String.valueOf(this.getFloatFromString(this.getElementInnerText(element),true));
			map.put("productWasPrice",lsText);
		}
		else{
			map.put("productWasPrice",null);
		}

		if(this.checkProductItemReviewExisting(item)){
			List<WebElement> reviewStarList=item.findElements(this.byProductReviewRatingImage);
			int reviewRate=this.getProductItemReviewNumberAmountFromStarImage(reviewStarList);
			map.put("productReviewRate",reviewRate+"");

			element=item.findElement(this.byProductReviewRatingCount);
			lsText=this.getElementInnerText(element);
			int reviewCount=this.getIntegerFromString(lsText);
			map.put("productReviewCount",reviewCount+"");
		}
		else{
			map.put("productReviewRate",null);
			map.put("productReviewCount",null);
		}

		if(bStyleAndSize){
			this.selectSizeOrColorOption(item, this.byProductGoToDetails);
			if(!this.selectedProductItem.productSelectedSize.isEmpty()){
				map.put("productSize",this.selectedProductItem.productSelectedSize);
			}
			else{
				map.put("productSize",null);
			}

			if(!this.selectedProductItem.productSelectedColor.isEmpty()){
				map.put("productStyle",this.selectedProductItem.productSelectedColor);
			}
			else{
				map.put("productStyle",null);
			}

			element=item.findElement(this.byProductGoToDetails);
			this.clickElement(element);
		}
		else{
			element=item.findElement(this.byProductImage);
			this.clickElement(element);
		}
		this.waitForCondition(Driver->{return pdp.lblProductName.isDisplayed();},20000);

		return map;
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

	/**
	 * To check Product Search Result Existing
	 * @return - boolean
	 */
	public boolean checkProductSearchResultExisting(){
		return !this.checkChildElementExistingByTagName(cntSearchResultContainer,"section");
	}
}

