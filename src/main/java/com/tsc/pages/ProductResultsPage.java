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
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'itemNo')]")
	List<WebElement> productItemNOList;
		
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'badgeWrap')]")
	List<WebElement> productPriceBadgeList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'videoIcon')]")
	List<WebElement> productVideoIconList;
		
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'priceDiv')]//del")
	List<WebElement> productWasPriceList;
			
	//Pagination
	@FindBy(xpath = "//product-results//nav[contains(@aria-label,'Page')]//li[contains(@id,'pages[') and not(contains(.,'...'))]")
	List<WebElement> currentPageList;
	
	@FindBy(xpath = "//product-results//nav[contains(@aria-label,'Page')]//li[contains(@class,'previous')]")
	WebElement btnPreviousPage;
	
	By byPreviousPageButton=By.xpath("//product-results//nav[contains(@aria-label,'Page')]//li[contains(@class,'previous')]");
	
	@FindBy(xpath = "//product-results//nav[contains(@aria-label,'Page')]//li[contains(@class,'next')]//span")
	WebElement btnNextPage;
	
	By byNextPageButton=By.xpath("//product-results//nav[contains(@aria-label,'Page')]//li[contains(@class,'next')]//span");
		
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
		for(String message:expectedMessage) {			
			if(!lsMessage.contains(message)) {
				return false;
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
	 * This method will verify PriceBadge in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductPriceBadge() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		if(productPriceBadgeList.size()>0) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(productResultList.get(0));
			for(WebElement item: productPriceBadgeList) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				WebElement img=item.findElement(By.xpath(".//img"));
				if(img.getAttribute("src").isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method will return Product list on the current page.	  
	 * @author Wei.Li
	 */
	public List<WebElement> getProductList(){
		return productResultList;
	}
	
	/**
	 * This method will verify priceVideoIcon in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductVideoIcon() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		if(productVideoIconList.size()>0) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(productResultList.get(0));
			for(WebElement item: productVideoIconList) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				WebElement link=item.findElement(By.xpath(".//*[name()='use']"));
				if(!link.isDisplayed()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method will verify productWasPrice in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductWasPrice() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		if(productWasPriceList.size()>0) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(productResultList.get(0));
			for(WebElement item: productWasPriceList) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if(item.getText().isEmpty()) {
					return false;
				}
			}
		}
		return true;
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
				if(this.lblSearchResultMessage.getText().contains("We couldn")) {
					return "SpecialCharacterSearch";
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
			/*
			if(lstBannerImage.size()>0) {
				return "BannerImageSearch";
			}
			*/
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
	 * This method will verify Url of search result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifySearchResultUrl(String lsPattern, String lsKeyword) {
		String lsEncodingKeyword=getEncodingKeyword(lsKeyword);
		String lsMatchPattern=(new BasePage(this.getDriver())).getBaseURL()+lsPattern+lsEncodingKeyword;
				
		return this.URL().matches(lsMatchPattern);		
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
	 * @author Wei.Li
	 */	
	public int getBannerImageListSize() {
		return this.lstBannerImage.size();
	}
}

	
