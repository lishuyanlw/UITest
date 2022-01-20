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
	
	public By byProductOptionFieldsetContainer=By.xpath("//div[@class='product-card__mobile-modal']//form");
	
	//For size and color
	public By byProductOptionFieldsetList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset");
	
	public By byProductOptionTitle=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//*[contains(@class,'product-card__') and contains(@class,'-title')]");
	
	//For size option	
	public By byProductOptionSizeTitle=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//span[@class='product-card__size-title']");
			
	public By byProductOptionSizeSelectedSize=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//span[@class='product-card__size-title']//strong");
	
	public By byProductOptionSizeWrapper=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[@class='product-card__size-wrapper']");
	
	public By byProductOptionSizeItemList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__size__dropdown']//option");
	
	public By byProductOptionSizeItemEnabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[not(@disabled)]|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__size__dropdown']//option[not(@disabled)]");
	
	public By byProductOptionSizeItemDisabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[@disabled]|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__size__dropdown']//option[@disabled]");
	
	public By byProductOptionSizeSelectedItem=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[@aria-pressed='true']|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__size__dropdown']//option[@selected]");
	
	public By byProductOptionSizeViewAllSizes=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//a[@class='product-card__size-view-all']");
	
	//For color option
	public By byProductOptionColorTitle=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//p[@class='product-card__color-and-taste-title']");
	
	public By byProductOptionColorSelectedColor=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//p[@class='product-card__color-and-taste-title']//strong");
	
	public By byProductOptionColorWrapper=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[@class='product-card__color-and-taste-wrapper']");
	
	public By byProductOptionColorItemList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__color-and-taste__dropdown']//option");
	
	public By byProductOptionColorItemEnabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[not(@disabled)]|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[not(@disabled)]");
	
	public By byProductOptionColorItemDisabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@disabled]|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[@disabled]");
	
	public By byProductOptionColorSelectedItem=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@aria-pressed='true']|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[not(@selected)]");
	
	public By byProductGoToDetails=By.xpath("//div[@class='product-card__mobile-modal']//button[@class='product-card__add-button product-card__add-button--modal']");
	
	public By byProductSizeOrColorClose=By.xpath("//div[@class='product-card__mobile-modal']//button[@class='product-card__add-button product-card__add-button--modal']");
	
	@FindBy(xpath = "//div[@class='product-card__mobile-modal']//button[@class='product-card__add-button product-card__add-button--modal']")
	public WebElement btnProductGoToDetails;
	
	@FindBy(xpath = "//div[@class='product-card__mobile-modal']//button[@class='product-card__mobile-modal__close-button']")
	public WebElement btnProductSizeOrColorClose;
	
	public void openFilterPopupWindow() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(btnFilterPopup);
		getReusableActionsInstance().clickIfAvailable(btnFilterPopup);
		this.getReusableActionsInstance().waitForElementVisibility(lblFilterPopupHeaderTitle, 20);
		getReusableActionsInstance().staticWait(1000);
	}
	
	public void closeFilterPopupWindow() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnViewProductsAferSelectingFilters);
		getReusableActionsInstance().clickIfAvailable(this.btnViewProductsAferSelectingFilters);	
		getReusableActionsInstance().staticWait(5000);
	}
	
	@Override
	public boolean selectFilterItemInLeftPanel(String lsFirstLevelItem,String lsSecondLevelItem) {
		openFilterPopupWindow();	
		
		this.firstLevelFilter=lsFirstLevelItem;
		this.secondLevelFilter=lsSecondLevelItem;
		
		String lsHeader,lsSubItem;
		WebElement subItem,searchInputButton;
		List<WebElement> subItemList;
			
		for(int i=0;i<this.productFilterList.size();i++) {			
			if(i>0) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			}			
			lsHeader=this.getElementInnerText(this.productFilterList.get(i));
			if(lsHeader.contains("(")) {
				lsHeader=lsHeader.split("\\(")[0].trim();
			}	
			
			//If found lsFirstLevelItem
			if(lsHeader.equalsIgnoreCase(lsFirstLevelItem)) {					
				//If find a search input
				collapseFilterItemWithClickingProductTitle(this.productFilterContainerList.get(i));
				if(checkSearchInputButtonExistingInSubFilter(this.productFilterContainerList.get(i))) {					
					searchInputButton=this.productFilterContainerList.get(i).findElement(this.byProductFilterSearchInput);
					//getReusableActionsInstance().javascriptScrollByVisibleElement(searchInputButton);
					searchInputButton.sendKeys(lsSecondLevelItem);
					getReusableActionsInstance().staticWait(1000);					
					subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);
					//getReusableActionsInstance().javascriptScrollByVisibleElement(subItemList.get(0));
					getReusableActionsInstance().clickIfAvailable(subItemList.get(0));
					getReusableActionsInstance().staticWait(3000);
					waitForSortingOrFilteringCompleted();
					getReusableActionsInstance().staticWait(3000);
					closeFilterPopupWindow();
					return true;
				}
				
				expandFilterItem(this.productFilterContainerList.get(i));				
				if(i>0) {
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i-1));
				}	
				else {
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(0));
				}
				this.getReusableActionsInstance().staticWait(1000);
				subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);				
				for(int j=0;j<subItemList.size();j++) {	
					subItem=subItemList.get(j);
					lsSubItem=this.getElementInnerText(subItem.findElement(By.xpath(".//span[@class='plp-filter-panel__filter-list__item-label-text']")));
					getReusableActionsInstance().staticWait(500);
					//If found lsSecondLevelItem
					if(lsSubItem.equalsIgnoreCase(lsSecondLevelItem)) {
						System.out.println("Selected lsSubItem: "+lsSubItem);
						getReusableActionsInstance().staticWait(500);
						if(j>4) {
							this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItemList.get(j-2));
							getReusableActionsInstance().clickIfAvailable(subItem);
						}
						else {
							getReusableActionsInstance().clickIfAvailable(subItem);
						}	
						getReusableActionsInstance().staticWait(3000);
						this.waitForSortingOrFilteringCompleted();
						getReusableActionsInstance().staticWait(3000);

						closeFilterPopupWindow();			
						return true;
					}
				}
			}
		}

		//If unable to find both lsFirstLevelItem and lsSecondLevelItem, then select the first choice
		this.bDefault=true;
		
		for(int i=0;i<this.productFilterList.size();i++) {			
			if(i>0) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			}			
			expandFilterItem(this.productFilterContainerList.get(i));
			if(i>0) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i-1));
			}	
			else {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(0));
			}			
			
			subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);	
			for(int j=0;j<subItemList.size();j++) {	
				subItem=subItemList.get(j);
				if(!this.hasElementAttribute(subItem.findElement(By.xpath(".//button//input")), "checked")) {
					this.secondLevelFilter=this.getElementInnerText(subItem);
					this.firstLevelFilter=this.getElementInnerText(subItem.findElement(By.xpath("./ancestor::div[@class='plp-filter-panel__blocks']//button[@class='plp-filter-panel__block-title']")));
					
					getReusableActionsInstance().staticWait(500);
					getReusableActionsInstance().staticWait(500);
					if(j>4) {
						this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItemList.get(j-2));
						getReusableActionsInstance().clickIfAvailable(subItem);
					}
					else {
						getReusableActionsInstance().clickIfAvailable(subItem);
					}										
					this.waitForSortingOrFilteringCompleted();
					getReusableActionsInstance().staticWait(1000);
					
					closeFilterPopupWindow();					
					return true;
				}
			}			
		}
	
		closeFilterPopupWindow();
		return false;
	}
	
	@Override
	public void expandFilterItem(WebElement filterContainerItem) {		
		if(checkIfFilterItemIsCollapsed(filterContainerItem)) {
			clickSeeMoreButton(filterContainerItem);
			return;
		}
				
		WebElement productFilterTitle=filterContainerItem.findElement(this.byProductFilterTitle);
//		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productFilterTitle);
//		this.getReusableActionsInstance().clickIfAvailable(productFilterTitle);
		this.clickElement(productFilterTitle);
		this.getReusableActionsInstance().staticWait(1000);
		
		clickSeeMoreButton(filterContainerItem);
	}
	
	@Override
	public void clickSeeMoreButton(WebElement filterContainerItem) {
		String lsButtonType=this.checkFilterItemSeeButtonExisting(filterContainerItem);
		if(lsButtonType.equalsIgnoreCase("SeeMore")) {
			WebElement seeMoreButton=filterContainerItem.findElement(this.bySecondaryFilterSeeMoreButton);
//			this.getReusableActionsInstance().javascriptScrollByVisibleElement(seeMoreButton);
//			this.getReusableActionsInstance().clickIfAvailable(seeMoreButton);
			this.clickElement(seeMoreButton);
			this.getReusableActionsInstance().staticWait(1000);
		}
	}
	
	@Override
	public void collapseFilterItemWithClickingProductTitle(WebElement filterContainerItem) {		
		WebElement productFilterTitle=filterContainerItem.findElement(this.byProductFilterTitle);
		this.clickElement(productFilterTitle);
		this.getReusableActionsInstance().staticWait(1000);		
	}
	
	@Override
	public String verifyFilterOptions(List<String> lstOptionYml) {
		openFilterPopupWindow();
		
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
		
		closeFilterPopupWindow();		
		return lsErrorMsg;
	}
	
	@Override
	public boolean closeAllSelectedFilters() {
		openFilterPopupWindow();	
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnFilterPopupClearAll);
		getReusableActionsInstance().clickIfAvailable(this.btnFilterPopupClearAll);	
		this.waitForSortingOrFilteringCompleted();
		
		closeFilterPopupWindow();		
		return true;
	}
	
	@Override
	public String verifySlectedFiltersContainSecondlevelFilter(List<String> lstFilterIncluded, List<String> lstFilterExcluded) {
		openFilterPopupWindow();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnFiltersAdded);
		getReusableActionsInstance().clickIfAvailable(this.btnFiltersAdded);
		getReusableActionsInstance().waitForElementVisibility(this.selectedFiltersList.get(this.selectedFiltersList.size()-1), 20);
		
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
				break;
			}
		}
		
		closeFilterPopupWindow();
		return lsMsg;
	}
	
	@Override
	public WebElement getFilterContainerWithSpecificFirstlevelFilterInLeftPanel(String lsFirstLevelItem) {
		openFilterPopupWindow();
		
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
	
	@Override
	public void verifySearchResultContent(List<WebElement> productList) {
		int loopSize;
		WebElement item,element;	
		String lsProductName,lsText;
		
		loopSize=productList.size();
		for(int i=0;i<loopSize;i++) {		
			item=productList.get(i);	
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			
			element=item.findElement(byProductName);			
			lsProductName=this.getElementInnerText(element);
			reporter.reportLog("Product Name: "+lsProductName);
			if(!lsProductName.isEmpty()) {
				reporter.reportLogPass("Product Name is not empty");
			}
			else {
				reporter.reportLogFail("Product Name is empty");
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
				List<WebElement> optionList=item.findElements(this.byProductOptionList);						
				lsText=this.getElementInnerText(optionList.get(0));							
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
			
			element=item.findElement(byProductItemSelectSizeOrColor);
			if(this.getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("Product select Size and Color is visible");
			}
			else {
				reporter.reportLogFail("Product select Size and Color is not visible");
			}
			
			if(this.getElementInnerText(element).equalsIgnoreCase("Go to detail page")) {
				continue;
			}
			
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			this.getReusableActionsInstance().clickIfAvailable(element);
			this.getReusableActionsInstance().waitForElementVisibility(this.btnProductGoToDetails,20);
			
			lsText=judgeProductOptionType();
			if(lsText.contains("Size")) {				
				element=this.getDriver().findElement(byProductOptionSizeTitle);
				lsText=this.getElementInnerText(element);
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product option size title is not empty");
				}
				else {
					reporter.reportLogFail("Product option size title is empty");
				}
				
				if(this.getDriver().findElements(byProductOptionSizeItemList).size()>0) {
					reporter.reportLogPass("Product option size button list is containing no less than 1 item");
				}
				else {
					reporter.reportLogFail("Product option size button list is containing 0 item");
				}
				
				if(checkViewAllSizesButtonExisting()) {
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
				element=this.getDriver().findElement(byProductOptionColorTitle);				
				lsText=this.getElementInnerText(element);				
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product option color title is not empty");
				}
				else {
					reporter.reportLogFail("Product option color title is empty");
				}
				
				if(this.getDriver().findElements(byProductOptionColorItemList).size()>0) {
					reporter.reportLogPass("Product option color button list is containing no less than 1 item");
				}
				else {
					reporter.reportLogFail("Product option color button list is containing 0 item");
				}
			}
				
			element=item.findElement(byProductGoToDetails);
			if(this.getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("Product GoTo details button is visible");
			}
			else {
				reporter.reportLogFail("Product GoTo details button is not visible");
			}
	
			verifySelectSizeOrColorOption(item);	
			
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductSizeOrColorClose);
			this.getReusableActionsInstance().clickIfAvailable(this.btnProductSizeOrColorClose);
			this.getReusableActionsInstance().staticWait(2000);
			
		}
	}

	public boolean checkSizeProductOptionIsDropdownWithMouseHover() {
		WebElement item=this.getDriver().findElement(this.byProductOptionSizeWrapper);	
		
		return this.checkChildElementExistingByTagName(item, "select");		
	}

	public boolean checkColorProductOptionIsDropdownWithMouseHover() {
		WebElement item=this.getDriver().findElement(this.byProductOptionColorWrapper);	
		
		return this.checkChildElementExistingByTagName(item, "select");		
	}

	public boolean checkProductSizeOptionDisabledItemAvailableWithMouseHover() {
		List<WebElement> itemList=this.getDriver().findElements(this.byProductOptionSizeItemList);
		for(WebElement item:itemList) {
			if(this.hasElementAttribute(item, "disabled")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkProductSizeOptionEnabledItemAvailableWithMouseHover() {
		if(!checkProductSizeOptionDisabledItemAvailableWithMouseHover()) {
			return true;
		}
				
		List<WebElement> itemAllList=this.getDriver().findElements(this.byProductOptionSizeItemList);
		List<WebElement> itemDisabledList=this.getDriver().findElements(this.byProductOptionSizeItemDisabledList);
		
		if(itemAllList.size()!=itemDisabledList.size()) {
			return true;
		}
		else {
			return false;
		}		
	}

	public boolean checkProductColorOptionDisabledItemAvailableWithMouseHover() {
		List<WebElement> itemList=this.getDriver().findElements(this.byProductOptionColorItemList);
		for(WebElement item:itemList) {
			if(this.hasElementAttribute(item, "disabled")) {
				return true;
			}
		}
		return false;
	}	
	
	public boolean checkProductColorOptionEnabledItemAvailableWithMouseHover() {
		if(!checkProductColorOptionDisabledItemAvailableWithMouseHover()) {
			return true;
		}
				
		List<WebElement> itemAllList=this.getDriver().findElements(this.byProductOptionColorItemList);
		List<WebElement> itemDisabledList=this.getDriver().findElements(this.byProductOptionColorItemDisabledList);
		this.getReusableActionsInstance().staticWait(1000);
		if(itemAllList.size()!=itemDisabledList.size()) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public boolean selectSizeOrColorOption(By BySelectSizeAndColorButton) {
		List<WebElement> optionList;
		WebElement element;
		
		String lsType=this.judgeProductOptionType();
		if(lsType.contains("Size")) {	
			if(checkProductSizeOptionEnabledItemAvailableWithMouseHover()) {				
				optionList=this.getDriver().findElements(byProductOptionSizeItemEnabledList);
				this.clickElement(optionList.get(0));
				this.getReusableActionsInstance().staticWait(3000);	
				element=this.getDriver().findElement(byProductOptionSizeSelectedSize);
				selectedProductItem.productSelectedSize=this.getElementInnerText(element);		
			}
			else {
				selectedProductItem.productSelectedSize="";
			}			
		}
		
		if(lsType.contains("Colour")) {	
			if(checkProductColorOptionEnabledItemAvailableWithMouseHover()) {	
				optionList=this.getDriver().findElements(byProductOptionColorItemEnabledList);
				this.clickElement(optionList.get(0));
				this.getReusableActionsInstance().staticWait(3000);	
				element=this.getDriver().findElement(byProductOptionColorSelectedColor);
				selectedProductItem.productSelectedColor=this.getElementInnerText(element);	
			}
			else {
				selectedProductItem.productSelectedColor="";
			}			
		}
		
		this.getReusableActionsInstance().staticWait(2000);
		element=this.getDriver().findElement(byProductGoToDetails);

		return this.getElementInnerText(element).trim().equalsIgnoreCase("Go to detail page");
	}
			
	public void verifySelectSizeOrColorOption(WebElement itemContainer) {
		WebElement element;	
		String lsText,lsType;
		boolean bSize=false,bColor=false;
			
		//To check button text
		element=this.getDriver().findElement(byProductGoToDetails);
		lsText=this.getElementInnerText(element);
		lsType=this.judgeProductOptionType();
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
		if(!checkProductSizeOptionEnabledItemAvailableWithMouseHover()||!checkProductColorOptionEnabledItemAvailableWithMouseHover()) {
			return;
		}
		
		this.selectedProductItem.productSelectedSize="";
		this.selectedProductItem.productSelectedColor="";
		
		//To check select size
		if(lsType.contains("Size")) {
			bSize=verifySizeOption(lsType);
			if(bSize) {
				element=this.getDriver().findElement(byProductGoToDetails);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText=element.getText().trim();
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
			element=this.getDriver().findElement(byProductGoToDetails);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsText=element.getText().trim();
			if(lsText.equalsIgnoreCase("Go to detail page")) {
				reporter.reportLogPass("The button text is equal to 'Go to detail page'");
			}
			else {
				reporter.reportLogFail("The button text is not equal to 'Go to detail page'");
			}
		}
	}
	
	private boolean verifySizeOption(String lsType) {
		if(checkProductSizeOptionEnabledItemAvailableWithMouseHover()) {
			List<WebElement> optionList=this.getDriver().findElements(byProductOptionSizeItemEnabledList);
			WebElement element=optionList.get(optionList.size()-1);
			String lsText=this.getElementInnerText(element).replace("Size", "").trim();
			String lsButtonTextBeforeClickingSize=this.getElementInnerText(this.getDriver().findElement(byProductGoToDetails));
			if(element.getTagName().equalsIgnoreCase("button")) {								
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				this.getReusableActionsInstance().clickIfAvailable(element);
			}
			else {
				Select sizeSelect= new Select(element.findElement(By.xpath("./parent::select")));
				sizeSelect.selectByIndex(optionList.size()-1);
			}
			
			this.getReusableActionsInstance().staticWait(2000);
			this.waitForCondition(Driver->{return !lsButtonTextBeforeClickingSize.equalsIgnoreCase(this.getElementInnerText(this.getDriver().findElement(byProductGoToDetails)));}, 20000);
			this.getReusableActionsInstance().staticWait(3000);	
			element=this.getDriver().findElement(byProductOptionSizeSelectedSize);
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
		if(checkProductColorOptionEnabledItemAvailableWithMouseHover()) {
			String lsImageSrcBeforeClickingColor=itemContainer.findElement(byProductImage).getAttribute("src");
			List<WebElement> optionList=this.getDriver().findElements(byProductOptionColorItemEnabledList);
			WebElement element=optionList.get(optionList.size()-1);
			String lsText=this.getElementInnerText(element).replace("colours", "").trim();
			String lsButtonTextBeforeClickingColor=this.getElementInnerText(this.getDriver().findElement(byProductGoToDetails));
			if(element.getTagName().equalsIgnoreCase("button")) {								
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				this.getReusableActionsInstance().clickIfAvailable(element);
			}
			else {
				Select sizeSelect= new Select(element.findElement(By.xpath("./parent::select")));
				sizeSelect.selectByIndex(optionList.size()-1);
			}
			
			this.getReusableActionsInstance().staticWait(2000);
			this.waitForCondition(Driver->{return !lsButtonTextBeforeClickingColor.equalsIgnoreCase(this.getElementInnerText(this.getDriver().findElement(byProductGoToDetails)));}, 20000);
			this.getReusableActionsInstance().staticWait(3000);
			
			String lsImageSrcAfterClickingColor=itemContainer.findElement(byProductImage).getAttribute("src");
			if(!lsImageSrcBeforeClickingColor.equalsIgnoreCase(lsImageSrcAfterClickingColor)) {
				reporter.reportLogPass("The image is changing after choosing a different style");
			}
			else {
				reporter.reportLogFail("The image is not changing after choosing a different style");
			}
						
			element=this.getDriver().findElement(byProductOptionColorSelectedColor);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			String lsSelectedTitle=element.getText().trim();
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
	
	@Override
	public void verifyInfoLinkageWithPDP(ProductDetailPage pdp) {
		WebElement element;
		String lsSelectedTitle,lsType;
		
		this.selectedProductItem.productSelectedSize="";
		this.selectedProductItem.productSelectedColor="";
		
		element=this.productResultList.get(0).findElement(byProductItemSelectSizeOrColor);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		this.getReusableActionsInstance().clickIfAvailable(element);
		this.getReusableActionsInstance().waitForElementVisibility(this.btnProductGoToDetails,20);
		
		lsType=this.judgeProductOptionType();	
		//If all displayed size or color are disabled
		if(!checkProductSizeOptionEnabledItemAvailableWithMouseHover()||!checkProductColorOptionEnabledItemAvailableWithMouseHover()) {
			reporter.reportLog("No enabled size/color opion available");
			return;
		}
		
		//To check selected size
		if(lsType.contains("Size")) {	
			verifySizeOption(lsType);					
		}
		
		//To check select color
		if(lsType.contains("Colour")) {	
			verifyColorOption(this.productResultList.get(0),lsType);						
		}
				
		element =this.getDriver().findElement(this.byProductGoToDetails);		
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		this.getReusableActionsInstance().clickIfAvailable(element);
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
	
	@Override
	public void verifySearchResultContentWithMouseHover(List<WebElement> productList) {
		
	}
	
	public String judgeProductOptionType() {
		WebElement item=this.getDriver().findElement(this.byProductGoToDetails);
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
	
	
	public boolean checkViewAllSizesButtonExisting() {
		WebElement sizeContainer=this.getDriver().findElement(this.byProductOptionSizeWrapper);
		return this.checkChildElementExistingByTagNameAndAttribute(sizeContainer, "a", "class", "product-card__size-view-all");
	}
	
}