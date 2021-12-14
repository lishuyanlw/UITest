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
	
	public By byProductOptionSizeItemList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button|.//fieldset//select[@class='product-card__size__dropdown']//option");
	
	public By byProductOptionSizeItemEnabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[not(@disabled)]|.//fieldset//select[@class='product-card__size__dropdown']//option[not(@disabled)]");
	
	public By byProductOptionSizeItemDisabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[@disabled]|.//fieldset//select[@class='product-card__size__dropdown']//option[@disabled]");
	
	public By byProductOptionSizeSelectedItem=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[@aria-pressed='true']|.//fieldset//select[@class='product-card__size__dropdown']//option[@selected]");
	
	//For color option
	public By byProductOptionColorTitle=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//p[@class='product-card__color-and-taste-title']");
	
	public By byProductOptionColorSelectedColor=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//p[@class='product-card__color-and-taste-title']//strong");
	
	public By byProductOptionColorWrapper=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[@class='product-card__color-and-taste-wrapper']");
	
	public By byProductOptionColorItemList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option");
	
	public By byProductOptionColorItemEnabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[not(@disabled)]|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[not(@disabled)]");
	
	public By byProductOptionColorItemDisabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@disabled]|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[@disabled]");
	
	public By byProductOptionColorSelectedItem=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@aria-pressed='true']|.//fieldset//select[@class='product-card__color-and-taste__dropdown']//option[not(@selected)]");
	
	public By byProductGoToDetails=By.xpath("//div[@class='product-card__mobile-modal']//button[@class='product-card__add-button product-card__add-button--modal']");
	
	public By byProductSizeOrColorClose=By.xpath("//div[@class='product-card__mobile-modal']//button[@class='product-card__add-button product-card__add-button--modal']");
	
	@FindBy(xpath = "//div[@class='product-card__mobile-modal']//button[@class='product-card__add-button product-card__add-button--modal']")
	public WebElement btnProductGoToDetails;
	
	@FindBy(xpath = "//div[@class='product-card__mobile-modal']//button[@class='product-card__mobile-modal__close-button']")
	public WebElement btnProductSizeOrColorClose;
	
	public void openFilterPopupWindow() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnFilterPopup);
		getReusableActionsInstance().clickIfAvailable(this.btnFilterPopup);		
		getReusableActionsInstance().waitForElementVisibility(this.lblFilterPopupHeaderTitle, 20000);
	}
	
	public void closeFilterPopupWindow() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnViewProductsAferSelectingFilters);
		getReusableActionsInstance().clickIfAvailable(this.btnViewProductsAferSelectingFilters);		
		getReusableActionsInstance().staticWait(2000);
	}
	
	@Override
	public boolean selectFilterItemInLeftPanel(String lsFirstLevelItem,String lsSecondLevelItem) {
		openFilterPopupWindow();	
		
		super.selectFilterItemInLeftPanel(lsFirstLevelItem,lsSecondLevelItem);	
		
		closeFilterPopupWindow();		
		return true;
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
		getReusableActionsInstance().waitForElementVisibility(this.selectedFiltersList.get(this.selectedFiltersList.size()-1), 20000);
		
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
		int checkAmount=10,loopSize;
		WebElement item,element;	
		String lsProductName,lsText;
		if(checkAmount<=this.productResultList.size()) {
			loopSize=checkAmount;
		}
		else {
			loopSize=this.productResultList.size();
		}
		
		for(int i=0;i<loopSize;i++) {		
			item=this.productResultList.get(i);	
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
				element=item.findElement(byProductOptionListContainer);				
				lsText=this.getElementInnerText(element);				
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
			this.getReusableActionsInstance().waitForElementVisibility(this.btnProductGoToDetails);
			
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
	
			verifySelectSizeOrColorOption();			
			
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
		System.out.println(selectedProductItem.productSelectedSize+"  Size:Color  "+selectedProductItem.productSelectedColor);
		element=this.getDriver().findElement(byProductGoToDetails);

		return this.getElementInnerText(element).trim().equalsIgnoreCase("Go to detail page");
	}
			
	public void verifySelectSizeOrColorOption() {
		List<WebElement> optionList;
		WebElement element;
		String lsText,lsSelectedTitle,lsType;
			
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
		
		//To check select size
		if(lsType.contains("Size")) {	
			if(checkProductSizeOptionEnabledItemAvailableWithMouseHover()) {
				optionList=this.getDriver().findElements(byProductOptionSizeItemEnabledList);
				element=optionList.get(0);
				lsText=this.getElementInnerText(element).replace("Size", "").trim();
				this.clickElement(element);
				this.getReusableActionsInstance().staticWait(3000);	
				element=this.getDriver().findElement(byProductOptionSizeSelectedSize);
				lsSelectedTitle=this.getElementInnerText(element);
				if(lsText.equalsIgnoreCase(lsSelectedTitle)) {
					reporter.reportLogPass("The selected size title is displaying correctly");
				}
				else {
					reporter.reportLogFail("The selected size title is not displaying correctly");
				}
				
				element=this.getDriver().findElement(byProductGoToDetails);
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
			if(checkProductColorOptionEnabledItemAvailableWithMouseHover()) {				
				optionList=this.getDriver().findElements(byProductOptionColorItemEnabledList);
				element=optionList.get(0);
				lsText=this.getElementInnerText(element).replace("colours", "").trim();
				this.clickElement(element);
				this.getReusableActionsInstance().staticWait(3000);	
				element=this.getDriver().findElement(byProductOptionColorSelectedColor);
				lsSelectedTitle=this.getElementInnerText(element);
				if(lsText.equalsIgnoreCase(lsSelectedTitle)) {
					reporter.reportLogPass("The selected color title is displaying correctly");
				}
				else {
					reporter.reportLogFail("The selected color title is not displaying correctly");
				}
				
				element=this.getDriver().findElement(byProductGoToDetails);
				lsText=this.getElementInnerText(element);				
				if(lsText.equalsIgnoreCase("Go to detail page")) {
					reporter.reportLogPass("The button text is equal to 'Go to detail page'");
				}
				else {
					reporter.reportLogFail("The button text is not equal to 'Go to detail page'");
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
	
	
	
}