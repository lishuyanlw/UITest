package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class ProductResultsPage_Mobile extends ProductResultsPage {

    public ProductResultsPage_Mobile(WebDriver driver) {
        super(driver);
    }

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp__count-and-shorting']//button[@class='plp__count-and-shorting__filter-button']")
	public WebElement btnFilterPopup;
	
	//For filter popup window
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__header']//button[@class='plp-filter-panel__header__close']")
	public WebElement btnFilterPopupClose;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__header']//span[@class='plp-filter-panel__header__title']")
	public WebElement lblFilterPopupHeaderTitle;
    
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel']//div[@class='plp-filter-panel__header']//button[@class='plp-filter-panel__header__clear']")
	public WebElement btnFilterPopupClearAll;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel__mobile-subpanel']//button[@class='plp-filter-panel__mobile-subpanel__title-button']")
	public WebElement btnFiltersAdded;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel__mobile-subpanel']//div[@class='plp-filter-panel__mobile-subpanel__buttons']//button")
	public List<WebElement> selectedFiltersList;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='plp-filter-panel__mobile-subpanel']//button[@class='plp-filter-panel__submit-button plp-filter-panel__submit-button--panel']")
	public WebElement btnViewProductsAferSelectingFilters;
	
	//For product options(Size/Color)
	public By byProductItemSelectSizeOrColor=By.xpath(".//button[@class='product-card__add-button']");
	
	public By byProductOptionFieldsetContainer=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//form");
	
	//For size and color
	public By byProductOptionFieldsetList=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset");
	public By byProductOptionTitle=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//*[contains(@class,'product-card__') and contains(@class,'-title')]");
	
	//For size option	
	public By byProductOptionSizeTitle=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//span[@class='product-card__size-title']");
			
	public By byProductOptionSizeSelectedSize=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//span[@class='product-card__size-title']//strong");
	
	public By byProductOptionSizeWrapper=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//div[@class='product-card__size-wrapper']");
	
	public By byProductOptionSizeItemList=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button|.//fieldset//select[@class='product-card__size__dropdown']//option");
	
	public By byProductOptionSizeItemEnabledList=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[not(@disabled)]|.//fieldset//select[@class='product-card__size__dropdown']//option[not(@disabled)]");
	
	public By byProductOptionSizeItemDisabledList=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[@disabled]|.//fieldset//select[@class='product-card__size__dropdown']//option[@disabled]");
	
	public By byProductOptionSizeSelectedItem=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[@aria-pressed='true']|.//fieldset//select[@class='product-card__size__dropdown']//option[@selected]");
	
	//For color option
	public By byProductOptionColorTitle=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//p[@class='product-card__color-and-taste-title']");
	
	public By byProductOptionColorSelectedColor=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//p[@class='product-card__color-and-taste-title']//strong");
	
	public By byProductOptionColorWrapper=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//div[@class='product-card__color-and-taste-wrapper']");
	
	public By byProductOptionColorItemList=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option");
	
	public By byProductOptionColorItemEnabledList=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[not(@disabled)]|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[not(@disabled)]");
	
	public By byProductOptionColorItemDisabledList=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@disabled]|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[@disabled]");
	
	public By byProductOptionColorSelectedItem=By.xpath("./parent::div/div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@aria-pressed='true']|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[not(@selected)]");
	
	@Override
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
				expandFilterItem(this.productFilterContainerList.get(i));
				
				List<WebElement> subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);				
				for(WebElement subItem : subItemList) {
					getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
					String lsSubItem=subItem.findElement(By.xpath(".//span[@class='plp-filter-panel__filter-list__item-label-text']")).getText().trim();
					
					getReusableActionsInstance().staticWait(500);
					//If found lsSecondLevelItem
					if(lsSubItem.equalsIgnoreCase(lsSecondLevelItem)) {						
						getReusableActionsInstance().staticWait(500);
						getReusableActionsInstance().clickIfAvailable(subItem);
						return waitForSortingOrFilteringCompleted();
					}
				}
			}
		}

		//If unable to find both lsFirstLevelItem and lsSecondLevelItem, then select the first choice
		this.bDefault=true;
		
		for(int i=0;i<this.productFilterList.size();i++) {
			expandFilterItem(this.productFilterContainerList.get(i));
			
			List<WebElement> subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);	
			for(WebElement subItem : subItemList) {
				if(!this.hasElementAttribute(subItem.findElement(By.xpath(".//button//input")), "checked")) {
					this.secondLevelFilter=this.getElementInnerText(subItem);
					this.firstLevelFilter=this.getElementInnerText(subItem.findElement(By.xpath("./ancestor::div[@class='plp-filter-panel__blocks']//button[@class='plp-filter-panel__block-title']")));
					System.out.println(this.firstLevelFilter+" : "+this.secondLevelFilter);
					getReusableActionsInstance().staticWait(500);
					getReusableActionsInstance().clickIfAvailable(subItem);
					return waitForSortingOrFilteringCompleted();
				}
			}			
		}
		return false;
	}
}