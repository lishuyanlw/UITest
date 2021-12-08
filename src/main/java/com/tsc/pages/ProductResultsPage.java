package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.tsc.pages.base.BasePage;

public class ProductResultsPage extends BasePage{
	public ProductResultsPage(WebDriver driver) {
		super(driver);
	}

	//Search results return message
	@FindBy(xpath = "//section[@class='tsc-container']//*[@class='plp__showing-results']|//section[@class='tsc-container']//div[@class='plp-no-search-results__copy__heading']")
	WebElement lblSearchResultMessage;

	@FindBy(xpath = "//section[@class='tsc-container']//*[@class='plp__showing-results']")
	WebElement lblReturnMessageWithSearchResult;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-no-search-results__copy__heading']")
	WebElement lblReturnMessageHeadingWithoutSearchResult;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-no-search-results__icon']")
	WebElement lblReturnMessageIconWithoutSearchResult;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-no-search-results__copy__text']")
	WebElement lblReturnMessageTextWithoutSearchResult;
	
	@FindBy(xpath = "//section[@class='tsc-container']//button[@class='plp-no-search-results__copy__link']")
	WebElement btnReturnMessageRetryLinkWithoutSearchResult;

	//Search title
	@FindBy(xpath = "//span[contains(@class,'tagDimTitle')]")
	WebElement lblSearchResultTitle;
	
	//Navigation list
	@FindBy(xpath = "//section[@class='tsc-container']//nav[@class='breadcrumb__nav']//li")
	List<WebElement> lstSearchResultNavigation;
	
	@FindBy(xpath = "//div[@class='Middle']")
	WebElement cntSearchResultTitleContainer;

	@FindBy(xpath = "//div[contains(@class,'showstopper-wrapper')]//div[contains(@class,'item')]//div[contains(@class,'visible')]//img")
	List<WebElement> lstBannerImage;

	//Selected filters
	//Missing
	@FindBy(xpath = "//product-results//div[contains(@class,'col-md-showing')]//div[contains(@class,'filterPrpLabel')]//b")
	WebElement lblShowing;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__count-and-shorting']//div[@class='plp__count-and-shorting__product-count']")
	WebElement txtShowingDynamicContent;

	//Missing
	@FindBy(xpath = "//product-results//div[contains(@class,'col-md-sort')]//form//div[contains(@class,'filterPrpLabel')]")
	WebElement lblSortBy;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__count-and-shorting']//select")
	WebElement btnSortSelect;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__count-and-shorting']//select//option")
	List<WebElement> sortByOptionList;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp']")
	WebElement cntSortingProductResultLoadingIndicator;

	//Missing
	@FindBy(xpath = "//product-results//div[contains(@class,'col-md-items')]//form//div[contains(@class,'filterPrpLabel')]")
	WebElement lblItemsPerPage;

	//Missing
	@FindBy(xpath = "//product-results//div[contains(@class,'search-filters-div')]//div[contains(@class,'col-md-items')]//select//option[1]|//product-results//div[contains(@class,'col-md-items')]//form//div[contains(@class,'recordsDiv')]")
	WebElement lblItemPerPageDefaultSettingNumber;

	//Product results
	//Does not work currently
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'blockPageWrap')]")
	WebElement productResultLoadingIndicator;

	@FindBy(xpath = "//div[@class='plp']//div[@class='plp__product-grid']//div[contains(@class,'plp-card-grid-item')]//div[@class='product-card']")
	List<WebElement> productResultList;

	//Selected filters
	//Missing
	@FindBy(xpath = "//div[contains(@class,'search-filters-div')]//div[contains(@class,'sortFilterWrap')]//div[contains(@class,'filterPrpLabel')]")
	WebElement lblSelectedFilters;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__applied-filters']//button")
	List<WebElement> selectedFiltersList;
	
	public By byProductHeaderTitle=By.xpath(".//*[@class='product-card__header-title']");
	
	public By byProductHeaderLike=By.xpath(".//*[@class='product-card__header-like']");

	public By byProductHref=By.xpath(".//a[@data-lpos='product card image']");

	public By byProductImage=By.xpath(".//a[@data-lpos='product card image']//img");
	
	public By byProductOptionListContainer=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__option-button']");
	
	public By byProductOptionList=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__option-button']//ul//li");
	
	public By byProductOptionSizeTitle=By.xpath(".//fieldset//span[@class='product-card__size-title']");
	
	public By byProductOptionSizeSelectedSize=By.xpath(".//fieldset//span[@class='product-card__size-title']//strong");
	
	public By byProductOptionSizeItemList=By.xpath(".//fieldset//div[@class='product-card__size-items']//button");

	public By byProductOptionColorTitle=By.xpath(".//fieldset//p[@class='product-card__color-and-taste-title']");
	
	public By byProductOptionColorSelectedColor=By.xpath(".//fieldset//p[@class='product-card__color-and-taste-title']//strong");
	
	public By byProductOptionColorItemList=By.xpath(".//fieldset//div[@class='product-card__color-and-taste-items']//button");
	
	public By byProductName=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//a[@class='product-card__info-pname']");
	
	public By byProductBrand=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//p[@class='product-card__info-brand']");

	//Missing
	public By byProductItemNO=By.xpath(".//div[contains(@class,'itemNo')]");

	public By byProductNowPrice=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//div[@class='product-card__info-price']//a[@class='product-card__info-price__is-price']/span[1]");

	public By byProductWasPrice=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//div[@class='product-card__info-price']//a[@class='product-card__info-price__is-price']/span[@class='product-card__info-price__was-price']");
	
	public By byJudgeProductWasPrice=By.xpath(".//form[@class='product-card__main']//div[@class='product-card__info']//div[@class='product-card__info-price']//a[@class='product-card__info-price__is-price']");
	
	//Missing
	public By byProductEasyPay=By.xpath(".//div[contains(@class,'easyPay')]");
	
	public By byProductReviewContainer=By.xpath(".//div[@class='product-card__reviews']");

	public By byProductReviewRatingImage=By.xpath(".//div[@class='product-card__reviews']//img[@class='product-card__raiting-stars']");

	public By byProductReviewRatingCount=By.xpath(".//div[@class='product-card__reviews']//a[@class='product-card__reviews-count']");

	public By byProductAddToBag=By.xpath(".//button[@class='product-card__add-button']");
	
		
	//Missing
	public By byProductReviewStarList=By.xpath(".//div[contains(@class,'reviewDiv')]//div[contains(@class,'pr-star-v4')]");

	//Missing
	public By byProductSwatch=By.xpath(".//div[@class='swatchWrapDiv']");

	//Missing
	public By byProductFreeShipping=By.xpath(".//div[contains(@class,'FreeShippingDiv')]");

	//Missing
	public By byProductPriceBadge=By.xpath(".//div[contains(@class,'badgeWrap')]//img");

	//Missing
	public By byProductVideoIcon=By.xpath(".//div[contains(@class,'videoIcon')]//*[name()='use']");

	//Missing	
	public By byJudgeProductBadgeAndVideo=By.xpath(".//div[contains(@class,'prImageWrap')]");

	
	//Missing
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'itemNo')]")
	List<WebElement> productItemNOList;

	//Pagination
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']")
	WebElement cntPagination;

	public By byPagination=By.xpath("//section[@class='tsc-container']//div[@class='plp__pagination']");

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']//div[@class='plp__pagination__pages']//a")
	List<WebElement> PageNumberList;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']")
	WebElement cntPreAndNextButtonPage;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']//a[@class='plp__pagination__prev-link']")
	WebElement btnPreviousPage;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']//a[@class='plp__pagination__next-link']")
	WebElement btnNextPage;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__pagination']//div[@class='plp__pagination__pages']//a[contains(@class,'plp__pagination__pages__page--current')]")
	WebElement btnCurrentPage;

	//Product title and text
	@FindBy(xpath = "//div[@class='TitleAndTextSeo']")
	WebElement cntProductTitleAndText;

	public By byProductTitleAndText=By.xpath(".//div[@class='TitleAndTextSeo']");

	@FindBy(xpath = "//div[@class='TitleAndTextSeo']//*[contains(@class,'seoTextTitle')]")
	WebElement lblProductTitle;

	@FindBy(xpath = "//div[@class='TitleAndTextSeo']//*[contains(@class,'seoTextContent')]")
	WebElement lblProductText;

	@FindBy(xpath = "//div[@class='TitleAndTextSeo']//button")
	WebElement btnProductTitleAndTextMoreOrLess;

	//Product results filter
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__blocks']")
	List<WebElement> productFilterContainerList;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__blocks']//button[@class='plp-filter-panel__block-title']")
	List<WebElement> productFilterList;
	
	public By byProductFilterTitle=By.xpath(".//button[@class='plp-filter-panel__block-title']");
	
	public By bySecondaryFilterOpenOrCloseFlag=By.xpath(".//button[@class='plp-filter-panel__block-title']//div[contains(@class,'plp-filter-panel__block-title__icon')]");
	
	public By bySecondaryFilterAll=By.xpath(".//ul[@class='plp-filter-panel__filter-list']//li");
	
	public By bySecondaryFilterUnChecked=By.xpath(".//ul[@class='plp-filter-panel__filter-list']//li[button[input[not(@checked)]]]");
	
	public By bySecondaryFilterChecked=By.xpath(".//ul[@class='plp-filter-panel__filter-list']//li[button[input[@checked]]]");
	
	public By bySecondaryFilterSeeButtonText=By.xpath(".//button[contains(@class,'plp-filter-panel__view-more')]//span");
	
	public By bySecondaryFilterSeeMoreButton=By.xpath(".//button[contains(@class,'plp-filter-panel__view-more')][span[normalize-space(.)='See More']]");
	
	public By bySecondaryFilterSeeLessButton=By.xpath(".//button[contains(@class,'plp-filter-panel__view-more')][span[normalize-space(.)='See Less']]");

	//Not used
	@FindBy(xpath = "//product-results//div[@class='modalBody']//div[@class='panel']//*[contains(@class,'panel-heading')]/following-sibling::div[contains(@class,'panel-collapse')]//div[contains(@class,'seeMoreDiv') and not(contains(@class,'seeMoreTitle')) and not(@style='display: none;')][@id]")
	List<WebElement> productFilterMoreButtonList;

	//Not used
	@FindBy(xpath = "//product-results//div[@class='modalBody']//div[@class='panel']//*[contains(@class,'panel-heading')]/following-sibling::div[contains(@class,'panel-collapse')]//div[contains(@class,'seeMoreDiv') and not(contains(@class,'seeMoreTitle')) and @aria-expanded='true' and not(@style='display: none;')]")
	List<WebElement> productFilterLessButtonList;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__blocks']//ul[@class='plp-filter-panel__filter-list']//li[button[input[not(@checked)]]]")
	List<WebElement> secondlevelFilterList;
	
	@FindBy(xpath = "//div[@class='plp']//div[@class='plp__product-grid']")
	WebElement searchResultSection;

	//Not used
	public By byMoreButtonOnLeftPanel=By.xpath(".//*[contains(@class,'panel-heading')]/following-sibling::div[contains(@class,'panel-collapse')]//div[contains(@class,'seeMoreDiv') and not(contains(@class,'seeMoreTitle')) and not(@style='display: none;')][@id]");
	//Not used
	public By byLessButtonOnLeftPanel=By.xpath(".//*[contains(@class,'panel-heading')]/following-sibling::div[contains(@class,'panel-collapse')]//div[contains(@class,'seeMoreDiv') and not(contains(@class,'seeMoreTitle')) and @aria-expanded='true' and not(@style='display: none;')]");
	//Not used
	public By byMoreOrLessButtonOnLeftPanel=By.xpath(".//*[contains(@class,'panel-heading')]/following-sibling::div[contains(@class,'panel-collapse')]//div[contains(@class,'seeMoreDiv') and not(contains(@class,'seeMoreTitle')) and not(@style='display: none;')][@id]|.//*[contains(@class,'panel-heading')]/following-sibling::div[contains(@class,'panel-collapse')]//div[contains(@class,'seeMoreDiv') and not(contains(@class,'seeMoreTitle')) and @aria-expanded='true' and not(@style='display: none;')]");

	//Not used
	public By bySubItemListOnLeftPanel=By.xpath(".//li");
	//Not used
	public By bySubItemPanelBodyOnLeftPanel=By.xpath(".//div[@class='panel-body']");

	@FindBy(xpath = "//product-recommendations-endeca")
	WebElement recommendationContainer;

	@FindBy(xpath = "//div[@class='Header']")
	WebElement headerContainer;

	@FindBy(xpath = "//div[@class='Footer']")
	WebElement footerContainer;

	//People Also Viewed items
	
	@FindBy(xpath = "//product-recommendations-endeca//h2[@class='prec-header']")
	public WebElement productRecommendationTitle;
	
	@FindBy(xpath="//product-recommendations-endeca//*[contains(@class,'prec-col')]")
	List<WebElement> lstPeopleAlsoBoughtItems;
	
	public By byRecommendationImage = By.xpath(".//div[contains(@class,'imgEmbedContainer')]//img[@class='img-responsive pprec-img']");
	
	public By byRecommendationName=By.xpath(".//div[contains(@class,'prec-name')]");
	
	public By byRecommendationPriceContainer=By.xpath(".//div[@class='prec-price']");
	
	public By byRecommendationNowPrice=By.xpath(".//div[@class='prec-price']/div[contains(@class,'now-price')]//span");
	
	public By byRecommendationWasPrice =By.xpath(".//div[@class='prec-price']/div[@class='was-price']");

	@FindBy(xpath="//div[contains(@class,'PageTitle')]//*[contains(@class,'gatewayTitle')]")
	public WebElement pageTitle;


	String searchkeyword;
	public boolean bVerifyTitle=true;
	public String firstLevelFilter,secondLevelFilter;
	public boolean bDefault=false;
	public String lsSearchResultMessage="";
	public ProductItem selectedProductItem= new ProductItem();	

	/**
	 * This method is to wait for not initial page loading.
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean waitForPageLoading() {	
		getReusableActionsInstance().staticWait(300);
		return waitForCondition(Driver->{
			String lsStyle=this.productResultLoadingIndicator.getAttribute("style");
			if(lsStyle==null||lsStyle.isEmpty()) {
				lsStyle="display: none;";
			}
			return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},90000);
	}

	/**
	 * This method will judge search type.
	 * @return QA return true
	 * @author Wei.Li
	 */
	public boolean isQASearch() {
		GlobalHeaderPage globalHeader=new GlobalHeaderPage(this.getDriver());
		getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeader.searchBox);

		return !this.hasElementAttribute(globalHeader.searchBox, "aria-controls");
	}

	/**
	 * This method will load product searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean getSearchResultLoad(String searchKeyword) {
		String lsUrl=this.URL();
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

		this.pressEnterKey(globalHeader.searchBox);

		this.getReusableActionsInstance().staticWait(8000);
//		waitForCondition(Driver->{
//			return this.lblShowing.isDisplayed();
//		},90000);
			
//		return waitForCondition(Driver->{
//			String lsStyle=this.productResultLoadingIndicator.getAttribute("style");
//			if(lsStyle==null||lsStyle.isEmpty()) {
//				lsStyle="display: none;";
//			}
//			return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;")&&!lsUrl.equalsIgnoreCase(this.URL());
//			},90000);
		
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

		if(this.isQASearch()) {
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
		}
		else {
			List<WebElement> elementList=getSearchDropdownResultList(lsKeyword);
			getReusableActionsInstance().javascriptScrollByVisibleElement(elementList.get(optionIndex));
			this.searchkeyword=elementList.get(optionIndex).getText().trim();
			this.bVerifyTitle=true;
			elementList.get(optionIndex).click();
		}

		getReusableActionsInstance().staticWait(300);
		return waitForCondition(Driver->{
			String lsStyle=this.productResultLoadingIndicator.getAttribute("style");
			if(lsStyle==null||lsStyle.isEmpty()) {
				lsStyle="display: none;";
			}
			return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;")&&!lsUrl.equalsIgnoreCase(this.URL());},90000);
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
	 * This method will get search result list.
	 * @param- String lsKeyword: search keyword
	 * @return List<WebElement>: search dropdown menu list
	 * @author Wei.Li
	 */
	public List<WebElement> getSearchDropdownResultList(String lsKeyword) {
		GlobalHeaderPage globalHeader=new GlobalHeaderPage(this.getDriver());
		getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeader.searchBox);
		pressEscapeKey();
		this.clearContent(globalHeader.searchBox);
		for(int i=0;i<lsKeyword.length();i++) {
			globalHeader.searchBox.sendKeys(lsKeyword.substring(i,i+1));
			getReusableActionsInstance().staticWait(300);
		}
		waitForCondition(Driver->{return globalHeader.ctnSearchResult.getAttribute("class").contains("suggestions-container--open");},60000);

		return globalHeader.searchResultList;
	}

	/**
	 * This method will verify Showing text pattern in filters.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyShowingTextPatternInFilters() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblShowing);
		String showingText=this.lblShowing.getText().toUpperCase()+" "+this.txtShowingDynamicContent.getText();
		return showingText.matches("SHOWING: (\\d+) - (\\d+) of (\\d+) Items");
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
		if(!lsMessage.contains(lsKeyword)) {
			return "Search result message result of '"+lsMessage+"' does not contain keyword of "+lsKeyword;
		}
		else {
			if(!lsMessage.contains(expectedMessage)) {
				return "Search result message result of '"+lsMessage+"' does not contain expected message of "+expectedMessage;
			}
		}
		return "";
	}

	/**
	 * This method will verify the default setting of items per page.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifySearchResultPageNumberDefaultSetting(String defaultSettingPageNumber) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblItemsPerPage);

		return lblItemPerPageDefaultSettingNumber.getText().trim().equalsIgnoreCase(defaultSettingPageNumber);
	}

	/**
	 * This method will return Product list on the current page.
	 * @author Wei.Li
	 */
	public List<WebElement> getProductList(){
		return productResultList;
	}

	/**
	 * This method will verify the itemNO in search results will just contain those with search product number.
	 * @param- String lsexpectedItemNO: expected ItemNO
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean VerifySearchResultWithProductItemNO(String lsexpectedItemNO) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.productItemNOList.get(0));
		//Wait till we have just one product present on page for running test in sauce-labs
		waitForCondition(Driver->{return this.productItemNOList.size()==1;},180000);
		for(WebElement item: this.productItemNOList) {
			String lsItem=item.getText().trim();
			List<String> list=this.getNumberFromString(lsItem);
			String lsFinal="";
			for(String lsSubItem:list) {
				lsFinal+=lsSubItem;
			}

			if(!lsFinal.equalsIgnoreCase(lsexpectedItemNO)) {
				return false;
			}
		}
		return true;
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
			getReusableActionsInstance().waitForElementVisibility(element);
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
		String lsUrl=this.URL();
		if(!lsUrl.contains("dimensions=")) {
			return "BannerImageSearch";
		}
		
		if(!lsUrl.contains("dimensions=0&")) {
			return "BannerImageSearch";
		}
		
		int totalNumber=getProductSearchResultsTotalNumber();
		if(totalNumber==0) {
			return "NoSearchResult";
		}
		else if(totalNumber==1){
			return "ProductNumberSearch";
		}
		else{
			return "NormalSearch";
		}
		
//		if(lsUrl.contains("dimensions=0&")) {
//			if(getReusableActionsInstance().isElementVisible(this.lblSearchResultMessage)) {
//				getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSearchResultMessage);
//				if(this.lblSearchResultMessage.getText().trim().contains("Please search again")) {
//					return "NoSearchResult";
//				}
//				else {
//					if(getReusableActionsInstance().isElementVisible(this.lblShowing)) {
//						if(this.productResultList.size()!=1) {
//							return "NormalSearch";
//						}
//						else {
//							return "ProductNumberSearch";
//						}
//					}
//				}
//			}
//		}
//		else {
//			return "BannerImageSearch";
//		}
//
//		return "NormalSearch";
	}
	
	public int getProductSearchResultsTotalNumber() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		String lsShowingText=this.txtShowingDynamicContent.getText().trim();
		String[] lstSplit=lsShowingText.split(" ");
		return Integer.parseInt(lstSplit[lstSplit.length-2]);
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
			return lsUrl.contains("dimensions=")&&lsUrl.contains("searchterm=")&&lsUrl.contains(this.getEncodingKeyword(lsKeyword));
		}
		else {
			return lsUrl.contains("searchterm=")&&lsUrl.contains(this.getEncodingKeyword(lsKeyword));
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
		String lsBrowser=System.getProperty("Browser");
		if(lsBrowser.trim().equalsIgnoreCase("Chrome")) {
			String lsExpectedUrl="searchterm="+this.getEncodingKeyword(lsKeyword)+"&sortKey="+lsSortKey;
			return lsUrl.toLowerCase().contains(lsExpectedUrl.toLowerCase());
		}
		else {
			return lsUrl.contains("searchterm=")&&lsUrl.contains(this.getEncodingKeyword(lsKeyword))&&lsUrl.contains("&sortKey="+lsSortKey);
		}

	}

	/**
	 * This method will verify pagination.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductPagination() {
		return this.getDriver().findElements(this.byPagination).size()==1;
	}

	/**
	 * This method will verify Brand tile/text contains keyword.
	 * @param- String lsKeyword: input keyword
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductBrandContainKeyword(String lsKeyword,String lsSection) {
		boolean bReturn=true;
		switch(lsSection) {
			case "Title":
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductTitle);
				bReturn= this.lblProductTitle.getText().toLowerCase().contains(lsKeyword.toLowerCase());
				break;
			case "Text":
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductText);
				bReturn= this.lblProductTitle.getText().toLowerCase().contains(lsKeyword.toLowerCase());
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

		if(getReusableActionsInstance().isElementVisible(this.btnProductTitleAndTextMoreOrLess)) {
			this.btnProductTitleAndTextMoreOrLess.click();
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductTitleAndTextMoreOrLess);
			if(!this.btnProductTitleAndTextMoreOrLess.getText().contains("Read Less")) {
				return false;
			}
			else {
				this.btnProductTitleAndTextMoreOrLess.click();
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductTitleAndTextMoreOrLess);
				if(!this.btnProductTitleAndTextMoreOrLess.getText().contains("Read More")) {
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
	 * This method will verify Badge or Video existence.
	 * @param- WebElement parent: parent element
	 * @return String: indicate type
	 * @author Wei.Li
	 */
	@SuppressWarnings("unchecked")
	public String judgeProductBadgeAndVideo(WebElement parent) {
		WebElement element=parent.findElement(this.byJudgeProductBadgeAndVideo);
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		List<WebElement> childList=(List<WebElement>) jse.executeScript("return arguments[0].children;", element);

		if(childList.size()==1) {
			return "WithoutBadgeAndVideo";
		}

		if(childList.size()==2) {
			if(childList.get(1).getAttribute("class").contains("badgeWrap")) {
				return "WithBadge";
			}
			else {
				return "WithVideo";
			}
		}

		return "WithBadgeAndVideo";
	}

	/**
	 * This method will judge WasPrice existence.
	 * @param- WebElement parent: parent element
	 * @return String: indicate type
	 * @author Wei.Li
	 */
	public String judgeProductWasPrice(WebElement parent) {
		WebElement element=parent.findElement(this.byJudgeProductWasPrice);
		long childSize= super.getChildElementCount(element);

		if(childSize==1) {
			return "WithoutWasPrice";
		}

		return "WithWasPrice";
	}

	/**
	 * This method will verify the item content in product list.
	 * @param- List<WebElement> productList: the input product list
	 * @author Wei.Li
	 */
	public void verifySearchResultContent(List<WebElement> productList) {
		List<WebElement> elementList;
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productList.get(0));
		for(WebElement item : productList) {
//			reporter.reportLog("Product ItemNO:"+item.findElement(byProductItemNO).getText());
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);			
			this.getReusableActionsInstance().staticWait(3000);
//
//			reporter.softAssert(!item.findElement(byProductHref).getAttribute("href").isEmpty(),"ProductHref in searching result is correct", "ProductHref in searching result is incorrect");
//
//			reporter.softAssert(!item.findElement(byProductImage).getAttribute("src").isEmpty(), "ProductImage in searching result is correct", "ProductImage in searching result is incorrect");
//
//			reporter.softAssert(!item.findElement(byProductName).getText().isEmpty(), "ProductName in searching result is correct", "ProductName in searching result is incorrect");
//
//			reporter.softAssert(!item.findElement(byProductItemNO).getText().isEmpty(), "ProductItemNO in searching result is correct", "ProductItemNO in searching result is incorrect");
//
//			reporter.softAssert(!item.findElement(byProductNowPrice).getText().isEmpty(), "ProductNowPrice in searching result is correct", "ProductNowPrice in searching result is incorrect");
//
//			reporter.softAssert(!item.findElement(byProductEasyPay).getText().isEmpty(), "ProductEasyPay in searching result is correct", "ProductEasyPay in searching result is incorrect");
//
//			//Use findElements to avoid test crash when the element is not existing
//			elementList=item.findElements(byProductReview);
//			if(super.isChildElementVisible(elementList.get(0),"innerText")) {
//				reporter.softAssert(true, "ProductReview in searching result is correct", "ProductReview in searching result is incorrect");
//			}
//
//			//Use findElements to avoid test crash when the element is not existing
//			elementList=item.findElements(byProductSwatch);
//			if(super.isChildElementVisible(elementList.get(0),"childElementCount")) {
//				reporter.softAssert(true, "ProductSwatch in searching result is correct", "ProductSwatch in searching result is incorrect");
//			}
//
//			//Use findElements to avoid test crash when the element is not existing
//			elementList=item.findElements(byProductFreeShipping);
//			if(super.isChildElementVisible(elementList.get(0),"innerText")) {
//				reporter.softAssert(true, "ProductFreeShipping in searching result is correct", "ProductFreeShipping in searching result is incorrect");
//			}
//
//			String judgeMode=judgeProductBadgeAndVideo(item);
//			switch(judgeMode) {
//				case "WithBadge":
//					reporter.softAssert(!item.findElement(byProductPriceBadge).getAttribute("src").isEmpty(), "PriceBadge in searching result is correct", "PriceBadge in searching result is incorrect");
//					break;
//				case "WithVideo":
//					reporter.softAssert(!item.findElement(byProductVideoIcon).getAttribute("xlink:href").isEmpty(), "ProductVideoIcon in searching result is correct", "ProductVideoIcon in searching result is incorrect");
//					break;
//				case "WithBadgeAndVideo":
//					reporter.softAssert(!item.findElement(byProductPriceBadge).getAttribute("src").isEmpty(), "PriceBadge in searching result is correct", "PriceBadge in searching result is incorrect");
//					reporter.softAssert(!item.findElement(byProductVideoIcon).getAttribute("xlink:href").isEmpty(), "ProductVideoIcon in searching result is correct", "ProductVideoIcon in searching result is incorrect");
//					break;
//			}
//
//			judgeMode=judgeProductWasPrice(item);
//			if(judgeMode.equalsIgnoreCase("WithWasPrice")) {
//				reporter.softAssert(!item.findElement(byProductWasPrice).getText().isEmpty(), "ProductWasPrice in searching result is correct", "ProductWasPrice in searching result is incorrect");
//			}

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

		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSortBy);
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
	public boolean chooseSortOptionByVisibleText(List<String> lsOption) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSortSelect);
		Select sortOption= new Select(this.btnSortSelect);
		sortOption.selectByVisibleText(lsOption.get(1));

		return this.waitForPageLoading();
	}

	/**
	 * This method will verify Price: Highest first strategy.
	 * @return String: error message
	 * @author Wei.Li
	 */
	public String verifyHighestPriceFirstSort() {
		String lsErrorMsg="";
		if(this.productResultList.size()==0) {
			return lsErrorMsg="No product list";
		}

		List<Float> priceList=new ArrayList<Float>();
		List<String> productNOList=new ArrayList<String>();
		for(WebElement element:this.productResultList) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(element);

			String nowPriceText=element.findElement(this.byProductNowPrice).getText().trim();
			float nowPriceValue=this.getFloatFromString(nowPriceText,true);

			priceList.add(nowPriceValue);
			String productNO=element.findElement(this.byProductItemNO).getText().trim();
			productNOList.add(productNO);
		}

		int priceListSize=priceList.size();
		for(int i=0;i<priceListSize-1;i++) {
			if(priceList.get(i)<priceList.get(i+1)) {
				lsErrorMsg="Sort option of Price: Highest first does not work: the price of "+productNOList.get(i)+" is less than "+productNOList.get(i+1);
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
			return lsErrorMsg="No product list";
		}

		for(int i=0;i<listSize;i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			if(lstOptionYml.contains(this.productFilterList.get(i).getText().trim())) {
				continue;
			}else {
				return lsErrorMsg = "Filter option headers in left panel contain "+this.productFilterList.get(i).getText().trim()+" that is not present in input list";
			}
		}
		return lsErrorMsg;
	}

	/**
	 * This method will judge MoreButton in left panel existence.
	 * @param- WebElement parent: parent element
	 * @return true/false: if the childSize of this.panelItemContainerList item is 2, means no More button exists.
	 * @author Wei.Li
	 */
	public boolean judgeMoreButtonExistenceInLeftPanel(WebElement parent) {
		long childSize= super.getChildElementCount(parent);

		if(childSize==2) {
			return false;
		}

		return true;
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

		for(int i=0;i<this.productFilterList.size();i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			String lsHeader=this.productFilterList.get(i).getText().trim();
			if(lsHeader.contains("(")) {
				lsHeader=lsHeader.split("\\(")[0].trim();
			}

			//If found lsFirstLevelItem
			if(lsHeader.equalsIgnoreCase(lsFirstLevelItem)) {
				WebElement panelBody=this.productFilterContainerList.get(i).findElement(this.bySubItemPanelBodyOnLeftPanel);
				if(judgeMoreButtonExistenceInLeftPanel(panelBody)) {
					WebElement moreButton=this.productFilterContainerList.get(i).findElement(this.byMoreButtonOnLeftPanel);
					getReusableActionsInstance().javascriptScrollByVisibleElement(moreButton);
					moreButton.click();
					getReusableActionsInstance().staticWait(500);
				}

				List<WebElement> subItemList=this.productFilterContainerList.get(i).findElements(this.bySubItemListOnLeftPanel);
				System.out.println("subItemList size: "+subItemList.size());
				for(WebElement subItem : subItemList) {
					getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
					String lsSubItem=subItem.getText().trim();
					getReusableActionsInstance().staticWait(500);
					//If found lsSecondLevelItem
					if(lsSubItem.equalsIgnoreCase(lsSecondLevelItem)) {
						getReusableActionsInstance().staticWait(500);
						subItem.click();
						return this.waitForPageLoading();
					}
				}
			}
		}

		//If unable to find both lsFirstLevelItem and lsSecondLevelItem, then select the first choice
		this.bDefault=true;
		for(WebElement moreButton:this.productFilterMoreButtonList) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(moreButton);
			moreButton.click();
			getReusableActionsInstance().staticWait(500);
		}

		WebElement btnSelected=this.secondlevelFilterList.get(0);
		getReusableActionsInstance().javascriptScrollByVisibleElement(btnSelected);
		this.firstLevelFilter=btnSelected.findElement(By.xpath("./ancestor::div[@role='tabpanel']/preceding-sibling::*[contains(@class,'panel-heading')]")).getText().trim();
		if(this.firstLevelFilter.contains("(")) {
			this.firstLevelFilter=this.firstLevelFilter.split("\\(")[0].trim();
		}
		this.secondLevelFilter=btnSelected.getText().trim();
		btnSelected.click();

		return this.waitForPageLoading();
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
		if(this.productResultList.size()==0) {
			return lsErrorMsg="No product list";
		}

		for(WebElement element:this.productResultList) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			String productNO=element.findElement(this.byProductItemNO).getText().trim();

			String nowPriceText=element.findElement(this.byProductNowPrice).getText().trim();
			float nowPriceValue=this.getFloatFromString(nowPriceText,false);

			List<String> lstPrice=this.getNumberFromString(secondLevelFilter);

			switch(lsPriceMode) {
				case "Under":
					int priceOptionValue=Integer.parseInt(lstPrice.get(0));
					if(nowPriceValue>=priceOptionValue) {
						lsErrorMsg="Filter by price does not work for productNO of "+productNO;
					}
					break;
				case "Between":
					int lowPriceOptionValue=Integer.parseInt(lstPrice.get(0));
					int highPriceOptionValue=Integer.parseInt(lstPrice.get(1));
					if(nowPriceValue<lowPriceOptionValue||nowPriceValue>highPriceOptionValue) {
						lsErrorMsg="Filter by price does not work for productNO of "+productNO;
					}
					break;
				case "Over":
					priceOptionValue=Integer.parseInt(lstPrice.get(0));
					if(nowPriceValue<priceOptionValue) {
						lsErrorMsg="Filter by price does not work for productNO of "+productNO;
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
		this.selectedFiltersList.get(this.selectedFiltersList.size()-1).click();
		return this.waitForPageLoading();
	}

	/**
	 * This method will get 'clear all filters' button existence status.
	 * @return true/false: if only return 1, means there is a hidden ClearAllFiltersButton; if return more than 1, means there is a displayed ClearAllFiltersButton.
	 * @author Wei.Li
	 */
	public boolean getClearAllFiltersButtonStatus() {
		return this.selectedFiltersList.size()>1;
	}

	/**
	 * This method will verify if selected filters contain suitable search second level filters.
	 * @param- List<String> lstFilterIncluded: second level filter list
	 * @param- List<String> lstFilterExcluded: the filters should not appear in selected filters option
	 * @return String: error message
	 * @author Wei.Li
	 */
	public String verifySlectedFiltersContainSecondlevelFilter(List<String> lstFilterIncluded, List<String> lstFilterExcluded) {
		List<String> lstSelectedFilterOption=new ArrayList<String>();		
		int selectedFilterSize = this.selectedFiltersList.size() - 1;
		for (int i = 0; i < selectedFilterSize; i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectedFiltersList.get(i));
			lstSelectedFilterOption.add(this.selectedFiltersList.get(i).getText().trim());
		}
		
		for(String lsItem:lstSelectedFilterOption) {
			if(!lstFilterIncluded.contains(lsItem)) {
				return "The search second level filters do not contain the selected filter of '"+lsItem+"'";
			}
		}

		for(String lsItem:lstFilterExcluded) {
			if(lstSelectedFilterOption.contains(lsItem)) {
				return "The selected filters should not contain the excluded filter of '"+lsItem+"'";
			}
		}

		return "";
	}

	/**
	 * This method will switch page through clicking Pre/Next button.
	 * @param- boolean bNext: true for next page and false for previous page
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean switchPage(boolean bNext) {
		if(!this.verifyProductPagination()) {
			return false;
		}

		if(this.PageNumberList.size()==1) {
			return false;
		}
		
		if(!this.checkIfNextPageButtonAvailable()) {
			return false;
		}

		if(bNext) {
			WebElement lastPageButton=this.PageNumberList.get(this.PageNumberList.size()-1);
			if(lastPageButton.findElement(By.xpath("..")).getAttribute("class").contains("active")) {
				return false;
			}else {
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnNextPage);
				this.btnNextPage.click();
			}

		}else {
			WebElement firstPageButton=this.PageNumberList.get(0);
			if(firstPageButton.findElement(By.xpath("..")).getAttribute("class").contains("active")) {
				return false;
			}else {
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnPreviousPage);
				this.btnPreviousPage.click();
			}
		}

		return this.waitForPageLoading();
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
	 * @param- WebElement elementContainer: element container
	 * @param- boolean bVisible: true for visible filters while false for hidden filters.
	 * @return Hidden element count.
	 * @author Wei.Li
	 */
	public int getFiltersCountInSecondLevel(WebElement elementContainer, boolean bVisible) {
		if(elementContainer==null) {
			return 0;
		}

		getReusableActionsInstance().javascriptScrollByVisibleElement(elementContainer);
		List<WebElement> elementList=elementContainer.findElements(By.xpath(".//li"));

		int itemCount=0;
		for(WebElement element:elementList) {
			if(bVisible) {
				if(element.isDisplayed()){
					itemCount+=1;
				}
			}else {
				if(!element.isDisplayed()){
					itemCount+=1;
				}
			}
		}
		return itemCount;
	}

	/**
	 * This method will click More or Less button corresponding to the filter container.
	 * @param- WebElement elementContainer: input filter container
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean clickMoreOrLessButtonWithSpecificFirstlevelFilterInLeftPanel(WebElement elementContainer) {
		if(elementContainer==null) {
			return false;
		}

		WebElement panelBody=elementContainer.findElement(this.bySubItemPanelBodyOnLeftPanel);
		if(judgeMoreButtonExistenceInLeftPanel(panelBody)) {
			WebElement clickButton=elementContainer.findElement(this.byMoreOrLessButtonOnLeftPanel);
			getReusableActionsInstance().javascriptScrollByVisibleElement(clickButton);
			String buttonText=clickButton.getText();
			clickButton.click();
			getReusableActionsInstance().javascriptScrollByVisibleElement(clickButton);
			return this.waitForCondition(Driver->{return !buttonText.equalsIgnoreCase(clickButton.getText());},30000);
		}
		return false;
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
		int sum=0;
		for(WebElement item:lstReviewStar) {
			String[] lstClass=item.getAttribute("class").split(" ");
			String lsFilledClass="";
			for(String lsClass:lstClass) {
				if(lsClass.contains("filled")) {
					lsFilledClass=lsClass;
					break;
				}
			}
			String[] lstSubItem=lsFilledClass.split("-");
			sum=sum+Integer.parseInt(lstSubItem[3]);
		}
		return sum;
	}

	public boolean checkIfNextPageButtonAvailable() {
		return this.btnNextPage.getAttribute("style").contains("opacity: 1");
	}
	
	/**
	 * This method will go to the product with Review, EasyPay, Swatch item>=4 and Video
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean goToProductItemWithReviewAndSwatchAndVideo() {
		this.selectedProductItem.productName="";
		this.selectedProductItem.productNumber="";
		this.selectedProductItem.productNowPrice="";
		this.selectedProductItem.productEasyPay="";

		WebElement element;
		do {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productResultList.get(0));
			for(WebElement item : this.productResultList) {
				String lsMsg=judgeProductBadgeAndVideo(item);
				if(!(lsMsg.equalsIgnoreCase("WithBadgeAndVideo"))) {
					continue;
				}

				element=item.findElement(this.byProductReview);
				if(this.getChildElementCount(element)==0) {
					continue;
				}

				if(!this.judgeProductWasPrice(item).equalsIgnoreCase("WithWasPrice")) {
					continue;
				}

				element=item.findElement(this.byProductEasyPay);
				if(this.getChildElementCount(element)==0) {
					continue;
				}

				element=item.findElement(this.byProductSwatch);
				if(this.getChildElementCount(element)<4) {
					continue;
				}

				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				this.selectedProductItem.productName=item.findElement(this.byProductName).getText().trim();
				this.selectedProductItem.productNumber=item.findElement(this.byProductItemNO).getText().trim();
				List<String> list=this.getNumberFromString(this.selectedProductItem.productNumber);
				String lsFinal="";
				for(String lsSubItem:list) {
					lsFinal+=lsSubItem;
				}
				this.selectedProductItem.productConvertedNumber=lsFinal;
				this.selectedProductItem.productNowPrice=item.findElement(this.byProductNowPrice).getText().trim();
				this.selectedProductItem.productEasyPay=item.findElement(this.byProductEasyPay).getText().trim();
				this.selectedProductItem.productNavigationUrl=this.URL();
				
				item.click();
				return this.waitForPageLoading();
			}
		}
		while(this.switchPage(true));

		return false;
	}
	
	public boolean goToFirstProductItem() {
		System.out.println("Into search part");
		System.out.println("count: "+this.productResultList.size());
		WebElement item=this.productResultList.get(0).findElement(By.xpath(".//a"));
		System.out.println("link: "+this.getElementHref(item));
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		this.getReusableActionsInstance().scrollToElement(item);
//		this.selectedProductItem.productName=item.findElement(this.byProductName).getText().trim();
//		this.selectedProductItem.productNumber=item.findElement(this.byProductItemNO).getText().trim();
//		List<String> list=this.getNumberFromString(this.selectedProductItem.productNumber);
//		String lsFinal="";
//		for(String lsSubItem:list) {
//			lsFinal+=lsSubItem;
//		}
//		this.selectedProductItem.productConvertedNumber=lsFinal;
//		this.selectedProductItem.productNowPrice=item.findElement(this.byProductNowPrice).getText().trim();
//		this.selectedProductItem.productEasyPay=item.findElement(this.byProductEasyPay).getText().trim();
//		this.selectedProductItem.productNavigationUrl=this.URL();
		
		item.click();
		
		return this.waitForPageLoading();		
	}
	
	public boolean goToFirstProductItem(String lsProductNumber) {
		this.getSearchResultLoad(lsProductNumber);
		this.waitForPageLoading();
		
		WebElement item=this.productResultList.get(0);
		
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		this.selectedProductItem.productName=item.findElement(this.byProductName).getText().trim();
		this.selectedProductItem.productNumber=item.findElement(this.byProductItemNO).getText().trim();
		List<String> list=this.getNumberFromString(this.selectedProductItem.productNumber);
		String lsFinal="";
		for(String lsSubItem:list) {
			lsFinal+=lsSubItem;
		}
		this.selectedProductItem.productConvertedNumber=lsFinal;
		this.selectedProductItem.productNowPrice=item.findElement(this.byProductNowPrice).getText().trim();
		this.selectedProductItem.productEasyPay=item.findElement(this.byProductEasyPay).getText().trim();
		this.selectedProductItem.productNavigationUrl=this.URL();
		
		item.click();
		
		return this.waitForPageLoading();		
	}
	
	public boolean goToProductItemWithTrueFitAndSizeAndQuantity() {
		ProductDetailPage pdp=new ProductDetailPage(this.getDriver());
		
		this.selectedProductItem.productName="";
		this.selectedProductItem.productNumber="";
		this.selectedProductItem.productNowPrice="";
		this.selectedProductItem.productEasyPay="";
		
		WebElement item;
		do {
			this.selectedProductItem.currentProductSequenceNumber=-1;
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productResultList.get(0));
			for(int i=0;i<this.productResultList.size();i++) {
				if(i<=this.selectedProductItem.currentProductSequenceNumber) {
					continue;
				}
				
				item=this.productResultList.get(i);
								
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				this.selectedProductItem.productName=item.findElement(this.byProductName).getText().trim();
				this.selectedProductItem.productNumber=item.findElement(this.byProductItemNO).getText().trim();
				List<String> list=this.getNumberFromString(this.selectedProductItem.productNumber);
				String lsFinal="";
				for(String lsSubItem:list) {
					lsFinal+=lsSubItem;
				}
				this.selectedProductItem.productConvertedNumber=lsFinal;
				this.selectedProductItem.productNowPrice=item.findElement(this.byProductNowPrice).getText().trim();
				this.selectedProductItem.productEasyPay=item.findElement(this.byProductEasyPay).getText().trim();
				this.selectedProductItem.productNavigationUrl=this.URL();
				this.selectedProductItem.currentProductSequenceNumber=i;
				
				item.click();
				this.waitForPageLoading();
				this.getReusableActionsInstance().staticWait(1000);
				if(pdp.judgeStyleSizeAvailable()&&pdp.judgeStyleTrueFitExisting()&&pdp.judgeQuantityDropdownAvailable()&&pdp.IsQuantityLeftExisting()) {
					return true;
				}
				else {
					this.getDriver().navigate().back();
					this.waitForPageToLoad();
					this.waitForPageLoading();
					this.getReusableActionsInstance().staticWait(1000);					
				}
			}
		}
		while(this.switchPage(true));

		return false;
	}
	
	public boolean goToProductItemWithTeaserInfo() {
		ProductDetailPage pdp=new ProductDetailPage(this.getDriver());
		
		this.selectedProductItem.productName="";
		this.selectedProductItem.productNumber="";
		this.selectedProductItem.productNowPrice="";
		this.selectedProductItem.productEasyPay="";
		
		WebElement item;
		do {
			this.selectedProductItem.currentProductSequenceNumber=-1;
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productResultList.get(0));
			for(int i=0;i<this.productResultList.size();i++) {
				if(i<=this.selectedProductItem.currentProductSequenceNumber) {
					continue;
				}
				
				item=this.productResultList.get(i);
								
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				this.selectedProductItem.productName=item.findElement(this.byProductName).getText().trim();
				this.selectedProductItem.productNumber=item.findElement(this.byProductItemNO).getText().trim();
				List<String> list=this.getNumberFromString(this.selectedProductItem.productNumber);
				String lsFinal="";
				for(String lsSubItem:list) {
					lsFinal+=lsSubItem;
				}
				this.selectedProductItem.productConvertedNumber=lsFinal;
				this.selectedProductItem.productNowPrice=item.findElement(this.byProductNowPrice).getText().trim();
				this.selectedProductItem.productEasyPay=item.findElement(this.byProductEasyPay).getText().trim();
				this.selectedProductItem.productNavigationUrl=this.URL();
				this.selectedProductItem.currentProductSequenceNumber=i;
				
				item.click();
				this.waitForPageLoading();
				this.getReusableActionsInstance().staticWait(1000);
				if(pdp.judgeTeaserInfoDisplaying()) {
					return true;
				}
				else {
					this.getDriver().navigate().back();
					this.waitForPageToLoad();
					this.waitForPageLoading();
					this.getReusableActionsInstance().staticWait(1000);					
				}
			}
		}
		while(this.switchPage(true));

		return false;
	}
	
	public boolean goToProductItemWithBrandNameAndReviewAndSeeMoreInfo() {
		ProductDetailPage pdp=new ProductDetailPage(this.getDriver());
		WebElement element;
		
		this.selectedProductItem.productName="";
		this.selectedProductItem.productNumber="";
		this.selectedProductItem.productNowPrice="";
		this.selectedProductItem.productEasyPay="";

		WebElement item;
		do {
			this.selectedProductItem.currentProductSequenceNumber=-1;
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productResultList.get(0));
			for(int i=0;i<this.productResultList.size();i++) {
				if(i<=this.selectedProductItem.currentProductSequenceNumber) {
					continue;
				}
				
				item=this.productResultList.get(i);
				element=item.findElement(this.byProductReview);
				if(this.getChildElementCount(element)==0) {
					continue;
				}
												
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				this.selectedProductItem.productName=item.findElement(this.byProductName).getText().trim();
				this.selectedProductItem.productNumber=item.findElement(this.byProductItemNO).getText().trim();
				List<String> list=this.getNumberFromString(this.selectedProductItem.productNumber);
				String lsFinal="";
				for(String lsSubItem:list) {
					lsFinal+=lsSubItem;
				}
				this.selectedProductItem.productConvertedNumber=lsFinal;
				this.selectedProductItem.productNowPrice=item.findElement(this.byProductNowPrice).getText().trim();
				this.selectedProductItem.productEasyPay=item.findElement(this.byProductEasyPay).getText().trim();
				this.selectedProductItem.productNavigationUrl=this.URL();
				this.selectedProductItem.currentProductSequenceNumber=i;
				
				item.click();
				this.waitForPageLoading();
				this.getReusableActionsInstance().staticWait(1000);
				if(pdp.checkProductBrandNameDisplaying()&&pdp.judgeTeaserInfoDisplaying()) {
					return true;
				}
				else {
					this.getDriver().navigate().back();
					this.waitForPageToLoad();
					this.waitForPageLoading();
					this.getReusableActionsInstance().staticWait(1000);					
				}
			}
		}
		while(this.switchPage(true));

		return false;
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
	
	public boolean checkProductResultLoadingStatusAfterSorting() {
		return this.checkChildElementExistingByAttribute(this.cntSortingProductResultLoadingIndicator,"class","plp__loading");
	}
	
	/**
	 * This method will check Product Item Header Title Existing
	 * @param WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductItemHeaderTitleExisting(WebElement itemContainer) {
		return this.checkChildElementExistingByAttribute(itemContainer,"class","product-card__header");
	}
	
	/**
	 * This method will check Product Item colour option Existing
	 * @param WebElement itemContainer: product search result item
	 * @return String option
	 * @author Wei.Li
	 */
	public String checkProductColourOrSizeOptionExisting(WebElement itemContainer) {
		WebElement item=itemContainer.findElement(this.byProductOptionListContainer);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		String lsText=this.getElementInnerText(item).trim();
		
		if(lsText.isEmpty()){
			return "None";
		}
		
		if(lsText.toLowerCase().contains("colour")){
			return "Colour";
		}
		
		if(lsText.toLowerCase().contains("size")){
			return "Size";
		}
		
		return "None";
	}
	
	/**
	 * This method will check Product Item brand name Existing
	 * @param WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductItemBrandNameExisting(WebElement itemContainer) {
		WebElement item=itemContainer.findElement(this.byProductBrand);
		String lsText=this.getElementInnerText(item);
		
		return !lsText.isEmpty();
	}
	
	/**
	 * This method will check Product Item review Existing
	 * @param WebElement itemContainer: product search result item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductItemReviewExisting(WebElement itemContainer) {
		WebElement item=itemContainer.findElement(this.byProductReviewContainer);
				
		return this.getChildElementCount(item)>0;
	}

	/**
	 * This method will check See More button and See Less button
	 * @param WebElement filterContainerItem: filter Container Item
	 * @return String option
	 * @author Wei.Li
	 */
	public String checkFilterItemSeeButtonExisting(WebElement filterContainerItem) {
		WebElement item=filterContainerItem.findElement(this.bySecondaryFilterSeeButtonText);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		String lsText=this.getElementInnerText(item).trim();
		
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
	 * @param WebElement itemContainer: Filter title item
	 * @return int
	 * @author Wei.Li
	 */
	public int getSelectedItemAmountFromFilterTitle(WebElement filterTitle) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(filterTitle);
		String lsTitle=this.getElementInnerText(filterTitle);
		
		return this.getIntegerFromString(lsTitle);
	}
	
	/**
	 * This method will check If Filter Item Is Collapsed
	 * @param WebElement filterContainerItem: filter Container Item
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkIfFilterItemIsCollapsed(WebElement filterContainerItem) {
		WebElement item=filterContainerItem.findElement(this.bySecondaryFilterOpenOrCloseFlag);
		
		return !item.getAttribute("class").contains("plp-filter-panel__block-title__icon--plus");
	}
	
	/**
	 * This method will expand a specific Filter Item
	 * @param WebElement filterContainerItem: filter Container Item
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
	 * @param WebElement filterContainerItem: filter Container Item
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
	 * @param WebElement filterContainerItem: filter Container Item
	 * @return void
	 * @author Wei.Li
	 */
	public void clickSeeLessButton(WebElement filterContainerItem) {
		String lsButtonType=this.checkFilterItemSeeButtonExisting(filterContainerItem);
		if(lsButtonType.equalsIgnoreCase("SeeLess")) {
			WebElement seeMoreButton=filterContainerItem.findElement(this.bySecondaryFilterSeeLessButton);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(seeMoreButton);
			this.getReusableActionsInstance().clickIfAvailable(seeMoreButton);
			this.getReusableActionsInstance().staticWait(1000);
		}
	}
	
	/**
	 * This method will get Selected SubFilter Amount for a specific Filter Item
	 * @param WebElement filterContainerItem: filter Container Item
	 * @return int
	 * @author Wei.Li
	 */
	public int getSelectedSubFilterAmount(WebElement filterContainerItem) {		
		WebElement productFilterTitle=filterContainerItem.findElement(this.byProductFilterTitle);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productFilterTitle);
		String lsText=this.getElementInnerText(productFilterTitle);
		
		if(!lsText.contains("(")&&!lsText.contains(")")) {
			return 0;
		}
		else {
			return this.getIntegerFromString(lsText);	
		}			
	}
	
	

	public class ProductItem{
		public String productName;
		public String productNumber;
		public String productConvertedNumber;
		public String productNowPrice;
		public boolean bProductWasPrice;
		public String productEasyPay;
		public String productNavigationUrl;
		public int currentProductSequenceNumber;
	}
}		      	

