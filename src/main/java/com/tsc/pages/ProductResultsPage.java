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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tsc.pages.base.BasePage;
import java.util.List;

public class ProductResultsPage extends BasePage{
	public ProductResultsPage(WebDriver driver) {
		super(driver);
	}
		
	//Search result page title
	@FindBy(xpath = "//product-results//div[contains(@class,'searchDiv')]")
	WebElement lblSearchResultMessage;
	
	@FindBy(xpath = "//span[contains(@class,'tagDimTitle')]")
	WebElement lblSearchResultTitle;
	
	@FindBy(xpath = "//div[contains(@class,'showstopper-wrapper')]//div[contains(@class,'item')]//div[contains(@class,'visible')]//img")
	List<WebElement> lstBannerImage;
	
	//Selected filters
	@FindBy(xpath = "//product-results//div[contains(@class,'col-md-showing')]//div[contains(@class,'filterPrpLabel')]//b")
	WebElement lblShowing;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'col-md-showing')]//div[contains(@style,'display:inline-block')]")
	WebElement txtShowingDynamicContent;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'col-md-sort')]//form//div[contains(@class,'filterPrpLabel')]")
	WebElement lblSortBy;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'col-md-sort')]//form//select")
	WebElement btnSortSelect;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'col-md-sort')]//form//select//option")
	List<WebElement> sortByOptionList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'col-md-items')]//form//div[contains(@class,'filterPrpLabel')]")
	WebElement lblItemsPerPage;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'search-filters-div')]//div[contains(@class,'col-md-items')]//select//option[1]|//product-results//div[contains(@class,'col-md-items')]//form//div[contains(@class,'recordsDiv')]")
	WebElement lblItemPerPageDefaultSettingNumber;
			
	//Product results
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'blockPageWrap')]")
	WebElement productResultLoadingIndicator;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]")
	List<WebElement> productResultList;
				
	public By byProductHref=By.xpath(".//a");
	
	public By byProductImage=By.xpath(".//div[contains(@class,'imgEmbedContainer')]//img[@class='productImg']");
	
	public By byProductName=By.xpath(".//div[contains(@class,'nameDiv')]");
	
	public By byProductItemNO=By.xpath(".//div[contains(@class,'itemNo')]");
	
	public By byProductNowPrice=By.xpath(".//div[contains(@class,'priceDiv')]//span");
	
	public By byProductEasyPay=By.xpath(".//div[contains(@class,'easyPay')]");
	
	public By byProductReview=By.xpath(".//div[contains(@class,'reviewDiv')]");
	
	public By byProductSwatch=By.xpath(".//div[@class='swatchWrapDiv']");
	
	public By byProductFreeShipping=By.xpath(".//div[contains(@class,'FreeShippingDiv')]");
	
	public By byProductPriceBadge=By.xpath(".//div[contains(@class,'badgeWrap')]//img");
	
	public By byProductVideoIcon=By.xpath(".//div[contains(@class,'videoIcon')]//*[name()='use']");
	
	public By byProductWasPrice=By.xpath(".//div[contains(@class,'priceDiv')]//del");
	
	public By byJudgeProductBadgeAndVideo=By.xpath(".//div[contains(@class,'prImageWrap')]");
	
	public By byJudgeProductWasPrice=By.xpath(".//div[contains(@class,'priceDiv')]");
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'itemNo')]")
	List<WebElement> productItemNOList;
					
	//Pagination
	@FindBy(xpath = "//product-results//nav[contains(@aria-label,'Page')]//ul[@class='pagination']")
	WebElement cntPagination;
	
	public By byPagination=By.xpath("//product-results//nav[contains(@aria-label,'Page')]//ul[@class='pagination']");
	
	@FindBy(xpath = "//product-results//nav[contains(@aria-label,'Page')]//li[contains(@id,'pages[') and not(contains(.,'...'))]")
	List<WebElement> currentPageList;
	
	@FindBy(xpath = "//product-results//nav[contains(@aria-label,'Page')]//li[contains(@class,'previous')]")
	WebElement btnPreviousPage;
	
	public By byPreviousPageButton=By.xpath("//product-results//nav[contains(@aria-label,'Page')]//li[contains(@class,'previous')]");
	
	@FindBy(xpath = "//product-results//nav[contains(@aria-label,'Page')]//li[contains(@class,'next')]//span")
	WebElement btnNextPage;
	
	public By byNextPageButton=By.xpath("//product-results//nav[contains(@aria-label,'Page')]//li[contains(@class,'next')]//span");
	
	//Product title and text
	@FindBy(xpath = "//div[@class='TitleAndTextSeo']")
	WebElement cntProductTitleAndText;
	
	public By byProductTitleAndText=By.xpath("//div[@class='TitleAndTextSeo']");
	
	@FindBy(xpath = "//div[@class='TitleAndTextSeo']//*[contains(@class,'seoTextTitle')]")
	WebElement lblProductTitle;
	
	@FindBy(xpath = "//div[@class='TitleAndTextSeo']//*[contains(@class,'seoTextContent')]")
	WebElement lblProductText;
	
	@FindBy(xpath = "//div[@class='TitleAndTextSeo']//button")
	WebElement btnProductTitleAndTextMoreOrLess;
	
	@FindBy(xpath = "//product-results//div[@class='modalBody']//div[@class='panel']//span[contains(@class,'section-header')]")
	List<WebElement> productFilterList;
	
	String searchkeyword;
		
	/**
	 * This method will load product searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean getSearchResultLoad(String searchKeyword) {		
		GlobalheaderPage globalHeader=new GlobalheaderPage(this.getDriver());
		getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeader.searchBox);		
		this.clearContent(globalHeader.searchBox);	
		globalHeader.searchBox.sendKeys(searchKeyword);
		globalHeader.btnSearchSubmit.click();
		
		return waitForCondition(Driver->{return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},30000);
	}
	
	/**
	 * This method will get search results through dropdown menu.
	 * @param String lsKeyword:input keyword
	 * @param int optionIndex: selected index in dropdwon menu
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean selectSearchResultListInDropdownMenu(String lsKeyword,int optionIndex) {
		List<WebElement> elementList=getSearchDropdownResultList(lsKeyword);
		this.searchkeyword=elementList.get(optionIndex).getText();
		elementList.get(optionIndex).click(); 			
		
		return waitForCondition(Driver->{return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},30000);
	}
	
	public boolean verifyPageTitleForDropdown() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSearchResultTitle);
		String[] lstItem=this.searchkeyword.trim().split(" ");
		String lastWord=lstItem[lstItem.length-1];
		return lastWord.toUpperCase().equalsIgnoreCase(this.lblSearchResultTitle.getText().trim().toUpperCase());
	}

	/**
	 * This method will get search result list.
	 * @param String lsKeyword: search keyword
	 * @return List<WebElement>: search dropdown menu list
	 * @author Wei.Li
	 */
	public List<WebElement> getSearchDropdownResultList(String lsKeyword) {
		GlobalheaderPage globalHeader=new GlobalheaderPage(this.getDriver());
		getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeader.searchBox);
		pressEscapeKey();		
		this.clearContent(globalHeader.searchBox);		
		globalHeader.searchBox.sendKeys(lsKeyword);		
		waitForCondition(Driver->{return globalHeader.ctnSearchResult.getAttribute("class").contains("suggestions-container--open");},30000);
		
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
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifySearchResultMessage(List<String> expectedMessage,String lsKeyword) {		
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSearchResultMessage);
		
		String lsMessage=this.lblSearchResultMessage.getText().trim();		
		if(!lsMessage.contains(lsKeyword)) {
			return false;		
		}
		else {
			for(String message:expectedMessage) {				
				if(!lsMessage.contains(message)) {
					return false;
				}
			}
		}
		
		return true;		
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
	 * This method will return search result account.	  
	 * @author Wei.Li
	 */
	public int getProductResultCount() {
		return this.productResultList.size();
	}
	
	/**
	 * This method will verify the itemNO in search results will just contain those with search product number.
	 * @param String lsexpectedItemNO: expected ItemNO
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean VerifySearchResultWithProductItemNO(String lsexpectedItemNO) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.productItemNOList.get(0));
		for(WebElement item: this.productItemNOList) {
			String lsItem=item.getText();
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
		String[] lsList=this.splitSearchKeyword(lsSpecificWord);
		for(WebElement element : this.lstBannerImage) {
			String lsSrc=element.getAttribute("src").toLowerCase();
			for(String item:lsList) {
				if(lsSrc.contains(item.toLowerCase())) {
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
		if(getReusableActionsInstance().isElementVisible(this.lblSearchResultTitle)) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSearchResultTitle);
			return this.lblSearchResultTitle.getText().trim();
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
		if(lsUrl.contains("dimensions=0&")) {
			if(getReusableActionsInstance().isElementVisible(this.lblSearchResultMessage)) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSearchResultMessage);
				if(this.lblSearchResultMessage.getText().contains("Please search again")) {
					   return "NoSearchResult";
				}
				else {					
					if(getReusableActionsInstance().isElementVisible(this.lblShowing)) {
						if(this.getProductResultCount()!=1) {
							return "NormalSearch";
						}
						else {
							return "ProductNumberSearch";
						}
					}				
				}
			}
		}
		else {			
			return "BannerImageSearch";
		}
				
		return "NormalSearch";		
	}
		
	/**
	 * This method will get encoding keyword.
	 * @param String lsKeyword: input keyword
	 * @return encoded keyword 
	 * @author Wei.Li
	 */
	public String getEncodingKeyword(String lsKeyword) {
		if(!lsKeyword.trim().contains(" ")) {
			return lsKeyword.trim();
		}
		
		String lsUrl=this.URL();
		if(lsUrl.contains("dimensions=0&")) {
			return lsKeyword.trim().replace(" ","%20");
		}
		else {
			return lsKeyword.trim().replace(" ","%2B");
		}
	}
	
	/**
	 * This method will verify Url of search result with Regex pattern.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifySearchResultUrlWithRegexPattern(String lsPattern, String lsKeyword) {
		String lsEncodingKeyword=getEncodingKeyword(lsKeyword);
		String lsMatchPattern=(new BasePage(this.getDriver())).getBaseURL()+lsPattern+lsEncodingKeyword;
				
		return this.URL().matches(lsMatchPattern);		
	}
	
	/**
	 * This method will verify Url of search result without Regex pattern.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifySearchResultUrl(String lsPattern, String lsKeyword) {
		String lsEncodingKeyword=getEncodingKeyword(lsKeyword);
		String lsMatchUrl=(new BasePage(this.getDriver())).getBaseURL()+lsPattern+lsEncodingKeyword;
			
		return this.URL().equalsIgnoreCase(lsMatchUrl);		
	}
	
	/**
	 * This method will split keyword using space.
	 * @param String lsKeyword: input keyword
	 * @return split array
	 * @author Wei.Li
	 */	
	public String[] splitSearchKeyword(String lsKeyword) {
		return lsKeyword.trim().split(" ");
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
	 * This method will verify pagination.
	 * @return true/false
	 * @author Wei.Li
	 */	
	public boolean verifyProductPagination() {
		return this.getDriver().findElements(this.byPagination).size()==1;
	}
	
	/**
	 * This method will verify Brand tile contains keyword.
	 * @param String lsKeyword: input keyword
	 * @return true/false
	 * @author Wei.Li
	 */	
	public boolean verifyProductBrandTitleContainKeyword(String lsKeyword) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductTitle);
		return this.lblProductTitle.getText().toLowerCase().contains(lsKeyword.toLowerCase());
	}
	
	/**
	 * This method will verify Brand text contains keyword.
	 * @param String lsKeyword: input keyword
	 * @return true/false
	 * @author Wei.Li
	 */	
	public boolean verifyProductBrandTextContainKeyword(String lsKeyword) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductText);
		return this.lblProductTitle.getText().toLowerCase().contains(lsKeyword.toLowerCase());
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
	 * @param WebElement parent: parent element
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
	 * This method will verify WasPrice existence.
	 * @param WebElement parent: parent element
	 * @return String: indicate type
	 * @author Wei.Li
	 */	
	@SuppressWarnings("unchecked")
	public String judgeProductWasPrice(WebElement parent) {
		WebElement element=parent.findElement(this.byJudgeProductWasPrice);
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		List<WebElement> childList=(List<WebElement>) jse.executeScript("return arguments[0].children;", element);
				
		if(childList.size()==1) {
			return "WithoutWasPrice";
		}
		
		return "WithWasPrice";		
	}
	
	/**
	 * This method will verify the item content in product list.
	 * @param List<WebElement> productList: the input product list 
	 * @author Wei.Li
	 */
	public void verifySearchResultContent(List<WebElement> productList) {		
		List<WebElement> elementList;
		(new BasePage(this.getDriver())).getReusableActionsInstance().javascriptScrollByVisibleElement(productList.get(0));
		for(WebElement item : productList) {
			reporter.reportLog("Product ItemNO:"+item.findElement(byProductItemNO).getText());
			(new BasePage(this.getDriver())).getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			
			reporter.softAssert(!item.findElement(byProductHref).getAttribute("href").isEmpty(),"ProductHref in searching result is correct", "ProductHref in searching result is incorrect");
			
			reporter.softAssert(!item.findElement(byProductImage).getAttribute("src").isEmpty(), "ProductImage in searching result is correct", "ProductImage in searching result is incorrect");
			
			reporter.softAssert(!item.findElement(byProductName).getText().isEmpty(), "ProductName in searching result is correct", "ProductName in searching result is incorrect");
			
			reporter.softAssert(!item.findElement(byProductItemNO).getText().isEmpty(), "ProductItemNO in searching result is correct", "ProductItemNO in searching result is incorrect");
			
			reporter.softAssert(!item.findElement(byProductNowPrice).getText().isEmpty(), "ProductNowPrice in searching result is correct", "ProductNowPrice in searching result is incorrect");
			
			//Use findElements to avoid test crash when the element is not existing
			elementList=item.findElements(byProductEasyPay);	
			if((new BasePage(this.getDriver())).isChildElementVisible(elementList.get(0),"innerText")) {
				reporter.softAssert(true, "ProductEasyPay in searching result is correct", "ProductEasyPay in searching result is incorrect");
			}
							
			//Use findElements to avoid test crash when the element is not existing
			elementList=item.findElements(byProductReview);
			if((new BasePage(this.getDriver())).isChildElementVisible(elementList.get(0),"innerText")) {
				reporter.softAssert(true, "ProductReview in searching result is correct", "ProductReview in searching result is incorrect");
			}
							
			//Use findElements to avoid test crash when the element is not existing
			elementList=item.findElements(byProductSwatch);
			if((new BasePage(this.getDriver())).isChildElementVisible(elementList.get(0),"childElementCount")) {
				reporter.softAssert(true, "ProductSwatch in searching result is correct", "ProductSwatch in searching result is incorrect");
			}
							
			//Use findElements to avoid test crash when the element is not existing
			elementList=item.findElements(byProductFreeShipping);
			if((new BasePage(this.getDriver())).isChildElementVisible(elementList.get(0),"innerText")) {
				reporter.softAssert(true, "ProductFreeShipping in searching result is correct", "ProductFreeShipping in searching result is incorrect");
			}
				
			String judgeMode=judgeProductBadgeAndVideo(item);			
			switch(judgeMode) {
			case "WithBadge":
				reporter.softAssert(!item.findElement(byProductPriceBadge).getAttribute("src").isEmpty(), "PriceBadge in searching result is correct", "PriceBadge in searching result is incorrect");
				break;
			case "WithVideo":
				reporter.softAssert(!item.findElement(byProductVideoIcon).getAttribute("xlink:href").isEmpty(), "ProductVideoIcon in searching result is correct", "ProductVideoIcon in searching result is incorrect");
				break;
			case "WithBadgeAndVideo":
				reporter.softAssert(!item.findElement(byProductPriceBadge).getAttribute("src").isEmpty(), "PriceBadge in searching result is correct", "PriceBadge in searching result is incorrect");
				reporter.softAssert(!item.findElement(byProductVideoIcon).getAttribute("xlink:href").isEmpty(), "ProductVideoIcon in searching result is correct", "ProductVideoIcon in searching result is incorrect");
				break;
			}
			
			judgeMode=judgeProductWasPrice(item);			
			if(judgeMode.equalsIgnoreCase("WithWasPrice")) {
				reporter.softAssert(!item.findElement(byProductWasPrice).getText().isEmpty(), "ProductWasPrice in searching result is correct", "ProductWasPrice in searching result is incorrect");
			}
			
		}
	}
	
	/**
	 * This method will verify sort options.
	 * @param List<String> lstOption: input option list
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
			lstOption.add(this.sortByOptionList.get(i).getText());
		}
		
		Set<String> setOption=new HashSet<String>(lstOption);
		Set<String> setOptionYml=new HashSet<String>(lstOptionYml);
		
		return setOption.containsAll(setOptionYml)&&setOptionYml.containsAll(setOption);
	}	

    /**
	 * This method will choose sort option by visible text.
	 * @param String lsOption: visible option text
	 * @return true/false
	 * @author Wei.Li
	 */	
    public boolean chooseSortOptionByVisibleText(String lsOption) {  
    	getReusableActionsInstance().isElementVisible(this.btnSortSelect);
    	getReusableActionsInstance().selectWhenReadyByVisibleText(this.btnSortSelect,lsOption);
		return waitForCondition(Driver->{return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},30000);		
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
			String nowPriceText=element.findElement(this.byProductNowPrice).getText();			
			float nowPriceValue=this.getFloatFromString(nowPriceText);			
			priceList.add(nowPriceValue);
			String productNO=element.findElement(this.byProductItemNO).getText();
			productNOList.add(productNO);
		}
		
		String lsItem="";
		int priceListSize=priceList.size();
		for(int i=0;i<priceListSize-1;i++) {
			if(priceList.get(i)<priceList.get(i+1)) {
				lsItem=lsItem+productNOList.get(i)+" is less than "+productNOList.get(i+1)+";";
			}
		}
		
		if(!lsItem.isEmpty()) {
			lsErrorMsg="Sort option of Price: Highest first does not work: "+lsItem;			
		}
		
		return lsErrorMsg;
	}
	
    /**
	 * This method will get float from string.
	 * @param String lsTarget: target string
	 * @return float value
	 * @author Wei.Li
	 */	
    public float getFloatFromString(String lsTarget) {  
    	lsTarget=lsTarget.replace(",", "").trim();
    	
    	String regex="\\d+\\.\\d+";
    	String lsReturn="";
    	Pattern pattern=Pattern.compile(regex);
    	Matcher matcher=pattern.matcher(lsTarget);
    	while(matcher.find())
    	{
    	    lsReturn=matcher.group();    	        	   
    	}
    	    			
    	return Float.parseFloat(lsReturn);
    }
    
    /**
	 * This method will verify Url after selecting sort strategy.
	 * @param String lsKeyword: search keyword
	 * @param String lsSortKey: sort key in dropdown menu
	 * @return true/false
	 * @author Wei.Li
	 */	
    public boolean verifyUrlAfterSelectSortStrategy(String lsKeyword,String lsSortKey) {  
    	String lsUrl=this.URL();
    	String lsExpectedUrl="searchterm="+this.getEncodingKeyword(lsKeyword)+"&sortKey="+lsSortKey;
    	
    	return lsUrl.toLowerCase().contains(lsExpectedUrl.toLowerCase());
    }   	

	/**
	 * This method will verify filter option headers.
	 * @param List<String> lstOption: input option list in yml file
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
	         if(lstOptionYml.contains(this.productFilterList.get(i).getText())) {
	            continue;
	         }else {
	            return lsErrorMsg = "Filter option headers in left panel contain "+this.productFilterList.get(i).getText()+" that is not present in input list";
	         }
	      }      
	      return lsErrorMsg;
	}
}

	
