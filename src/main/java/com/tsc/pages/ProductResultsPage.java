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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(xpath = "//product-results//div[contains(@class,'col-md-items')]//form//div[contains(@class,'recordsDiv')]")
	WebElement lblItemPerPageDefaultSettingNumber;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'col-md-items')]//form//select//option")
	List<WebElement> itemPerPageOptionList;
	
	//Product results
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'blockPageWrap')]")
	WebElement productResultLoadingIndicator;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]")
	List<WebElement> productResultList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'badgeWrap')]")
	List<WebElement> productPriceBadgeList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//a")
	List<WebElement> productHrefList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'imgEmbedContainer')]//img[@class='productImg']")
	List<WebElement> productImageList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'videoIcon')]")
	List<WebElement> productVedioIconList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'nameDiv')]")
	List<WebElement> productNameList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'itemNo')]")
	List<WebElement> productItemNOList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'priceDiv')]//span")
	List<WebElement> productNowPriceList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'priceDiv')]//del")
	List<WebElement> productWasPriceList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'easyPay')]")
	List<WebElement> productEasyPayList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'reviewDiv')]")
	List<WebElement> productReviewList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[@class='swatchWrapDiv']")
	List<WebElement> productColorSwatchList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[@class='swatchWrapDiv']//div[contains(@class,'swatchWrap')]//img")
	List<WebElement> productColorSwatchImageList;
	
	@FindBy(xpath = "//product-results//div[contains(@class,'productItems')]//div[contains(@class,'productItemWrap')]//div[contains(@class,'FreeShippingDiv')]")
	List<WebElement> productFreeShippingList;
	
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
				
		this.clearContent(globalHeader.searchBox);	
		globalHeader.searchBox.sendKeys(searchKeyword);
		globalHeader.btnSearchSubmit.click();
		
		return waitForCondition(Driver->{return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},30000);
		
	}
	
	/**
	 * This method will verify Url of search result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifySearchResultUrl(String expectedURL) {				
		return this.getDriver().getCurrentUrl().equalsIgnoreCase(expectedURL);		
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
	public boolean verifySearchResultMessage(List<String> expectedMessage) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSearchResultMessage);
		String lsMessage=this.lblSearchResultMessage.getText().trim();	
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
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSearchResultMessage);
						
		return this.lblItemPerPageDefaultSettingNumber.getText().trim().equalsIgnoreCase(defaultSettingPageNumber);		
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
	 * This method will verify productHref in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductHref() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		int pageSize=this.productResultList.size();
		if(productHrefList.size()!=pageSize) {
			return false;
		}
		else {
			getReusableActionsInstance().javascriptScrollByVisibleElement(productResultList.get(0));
			for(WebElement item: productHrefList) {	
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if(item.getAttribute("href").isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method will verify productImage in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductImage() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		int pageSize=this.productResultList.size();
		if(productImageList.size()!=pageSize) {
			return false;
		}
		else {
			getReusableActionsInstance().javascriptScrollByVisibleElement(productResultList.get(0));
			for(WebElement item: productImageList) {	
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if(item.getAttribute("src").isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method will verify priceVedioIcon in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductVedioIcon() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		if(productVedioIconList.size()>0) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(productResultList.get(0));
			for(WebElement item: productVedioIconList) {
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
	 * This method will verify productName in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductName() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		int pageSize=this.productResultList.size();
		if(productNameList.size()!=pageSize) {
			return false;
		}
		else {
			getReusableActionsInstance().javascriptScrollByVisibleElement(productResultList.get(0));
			for(WebElement item: productNameList) {	
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if(item.getText().isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method will verify productItemNO in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductItemNO() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		int pageSize=this.productResultList.size();
		if(productItemNOList.size()!=pageSize) {
			return false;
		}
		else {
			getReusableActionsInstance().javascriptScrollByVisibleElement(productResultList.get(0));
			for(WebElement item: productItemNOList) {
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if(item.getText().isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method will verify productNowPrice in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductNowPrice() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		int pageSize=this.productResultList.size();
		if(productNowPriceList.size()!=pageSize) {
			return false;
		}
		else {
			getReusableActionsInstance().javascriptScrollByVisibleElement(productResultList.get(0));
			for(WebElement item: productNowPriceList) {	
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if(item.getText().isEmpty()) {
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
	 * This method will verify productEasyPay in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductEasyPay() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		int pageSize=this.productResultList.size();
		if(productEasyPayList.size()!=pageSize) {
			return false;
		}
		else {
			getReusableActionsInstance().javascriptScrollByVisibleElement(productResultList.get(0));
			for(WebElement item: productEasyPayList) {	
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if(item.getText().isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method will verify productReview in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductReview() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		int pageSize=this.productResultList.size();
		if(productReviewList.size()!=pageSize) {
			return false;
		}
		else {
			getReusableActionsInstance().javascriptScrollByVisibleElement(productResultList.get(0));
			for(WebElement item: productReviewList) {	
				getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if(item.getText().isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method will verify productSwatch in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductSwatch() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		int pageSize=this.productResultList.size();
		if(productColorSwatchList.size()!=pageSize) {
			return false;
		}
		return true;
	}
	
	/**
	 * This method will verify productFreeShipping in searching result.
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyProductFreeShipping() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.txtShowingDynamicContent);
		int pageSize=this.productResultList.size();
		if(productFreeShippingList.size()!=pageSize) {
			return false;
		}
		return true;
	}

	/**
	 * This method will return <items per page> value when there is a dropdown menu.
	 * @return int: the value of items per page
	 * @author Wei.Li
	 */
	public int getItemsPerPageValue() {
		Select select = new Select(this.getDriver().findElement(By. xpath("//product-results//div[contains(@class,'col-md-items')]//form//select")));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println(defaultItem);
		
		return Integer.parseInt(defaultItem);
	}
	
	public int getProductResultCount() {
		return this.productResultList.size();
	}
	
}