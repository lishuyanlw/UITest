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

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__count-and-shorting']//button[@class='prp__count-and-shorting__filter-button']")
	public WebElement btnFilterPopup;
	
	//For filter popup window
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__header']//button[@class='prp-filter-panel__header__close']")
	public WebElement btnFilterPopupClose;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__header']//span[@class='prp-filter-panel__header__title']")
	public WebElement lblFilterPopupHeaderTitle;
    
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__header']//button[@class='prp-filter-panel__header__clear']")
	public WebElement btnFilterPopupClearAll;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel__mobile-subpanel']//button[@class='prp-filter-panel__mobile-subpanel__title-button']")
	public WebElement btnFiltersAdded;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel__mobile-subpanel']//div[@class='prp-filter-panel__mobile-subpanel__buttons']//button")
	public List<WebElement> selectedFiltersList;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel__mobile-subpanel']//button[@class='prp-filter-panel__submit-button prp-filter-panel__submit-button--panel']")
	public WebElement btnViewProductsAferSelectingFilters;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel__mobile-subpanel']")
	public WebElement cntSubPanelforSelectedFilters;
	
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
	
	public By byProductOptionSizeDropDown=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__size__dropdown']");
	
	public By byProductOptionSizeItemList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__size__dropdown']//option");
	
	public By byProductOptionSizeItemEnabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[not(@disabled)]|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__size__dropdown']//option[not(@disabled)]");
	
	public By byProductOptionSizeItemDisabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[@disabled]|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__size__dropdown']//option[@disabled]");
	
	public By byProductOptionSizeSelectedItem=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[@aria-pressed='true']|//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__size__dropdown']//option[@selected]");
	
	public By byProductOptionSizeViewAllSizes=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//a[@class='product-card__size-view-all']");
	
	//For color option
	public By byProductOptionColorTitle=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//p[@class='product-card__color-and-taste-title']");
	
	public By byProductOptionColorSelectedColor=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//p[@class='product-card__color-and-taste-title']//strong");
	
	public By byProductOptionColorWrapper=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[@class='product-card__color-and-taste-wrapper']");
	
	public By byProductOptionColorDropDown=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//select[@class='product-card__color-and-taste__dropdown']");
	
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
//		getReusableActionsInstance().javascriptScrollByVisibleElement(btnFilterPopup);
//		getReusableActionsInstance().clickIfAvailable(btnFilterPopup);
		this.clickElement(this.btnFilterPopup);
//		this.getReusableActionsInstance().waitForElementVisibility(lblFilterPopupHeaderTitle, 20);
		getReusableActionsInstance().staticWait(5000);
	}
	
	public void closeFilterPopupWindow() {
		this.clickElement(this.btnViewProductsAferSelectingFilters);
//		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnViewProductsAferSelectingFilters);
//		getReusableActionsInstance().clickIfAvailable(this.btnViewProductsAferSelectingFilters);	
		getReusableActionsInstance().staticWait(5000);
	}
	
	public void closeFilterPopupWindowWithCloseButton() {
//		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnFilterPopupClose);
//		getReusableActionsInstance().clickIfAvailable(this.btnFilterPopupClose);	
		this.clickElement(this.btnFilterPopupClose);
		getReusableActionsInstance().staticWait(5000);
	}
	
	@Override
	public boolean selectFilterItemInLeftPanel(String lsFirstLevelItem,String lsSecondLevelItem) {
		openFilterPopupWindow();	
		
		this.firstLevelFilter=lsFirstLevelItem;
		this.secondLevelFilter=lsSecondLevelItem;
		
		String lsHeader,lsSubItem;
		WebElement subItem,searchInputButton,item;
		List<WebElement> subItemList;
		boolean bCategory=lsFirstLevelItem.equalsIgnoreCase("category");
	
		if(bCategory&&this.bCategoryExpand) {			
			ExpandSubExpandableItemInCategoryFilterSection();
			this.bCategoryExpand=false;
			getReusableActionsInstance().staticWait(3000);
			openFilterPopupWindow();
		}
		
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
				if(!lsFirstLevelItem.equalsIgnoreCase("category")) {
					collapseFilterItemWithClickingProductTitle(this.productFilterContainerList.get(i));
				}
				
				//If find a search input
				if(checkSearchInputButtonExistingInSubFilter(this.productFilterContainerList.get(i))) {						
					searchInputButton=this.productFilterContainerList.get(i).findElement(this.byProductFilterSearchInput);
					//getReusableActionsInstance().javascriptScrollByVisibleElement(searchInputButton);
					searchInputButton.sendKeys(lsSecondLevelItem);
					getReusableActionsInstance().staticWait(1000);					
					subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);
					if(subItemList.size()>0) {
						//getReusableActionsInstance().javascriptScrollByVisibleElement(subItemList.get(0));
						subItem=subItemList.get(0).findElement(By.xpath("./button"));
						getReusableActionsInstance().clickIfAvailable(subItem);
//						waitForSortingOrFilteringCompleted();
						getReusableActionsInstance().staticWait(3000);
												
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
												
						closeFilterPopupWindow();
						
						verifyUrlPatternAfterSelectFilter(false);

						return true;
					}
					break;
				}
				
				if(!lsFirstLevelItem.equalsIgnoreCase("category")) {
					expandFilterItem(this.productFilterContainerList.get(i));	
				}
							
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
					
					//if statement to test Bug-19685 - Review filter
					if(lsSecondLevelItem.toLowerCase().contains("star")){
						lsSubItem = subItem.findElement(By.xpath(".//span[@class='prp-filter-panel__filter-list__item-label-text visually-hidden']")).getText().trim();
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
					
//					lsSubItem=this.getElementInnerText(subItem.findElement(By.xpath(".//span[@class='prp-filter-panel__filter-list__item-label-text']")));
					getReusableActionsInstance().staticWait(500);
					
					//If found lsSecondLevelItem
					if(lsSubItem.equalsIgnoreCase(lsSecondLevelItem)) {						
						getReusableActionsInstance().staticWait(500);
						if(lsFirstLevelItem.equalsIgnoreCase("category")) {
							subItem=subItem.findElement(By.xpath(".//a"));
						}
						else {
							subItem=subItem.findElement(By.xpath(".//button"));
						}
						
						if(j>4) {
							this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItemList.get(j-3));
							getReusableActionsInstance().clickIfAvailable(subItem);
						}
						else {
							getReusableActionsInstance().clickIfAvailable(subItem);
						}	
											
//						this.waitForSortingOrFilteringCompleted();
						getReusableActionsInstance().staticWait(5000);
						
						//Bug 19628: [QA Defect - P3] PRP: no products display if user is on the last page and select a faucet from the left nav
						//Bug 19556: [QA Defect - P3] PRP: when selecting a subcategory from Shop by category, the dimension in the URL should start over not appending
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
						
						//Bug 19389: PRP Filter Panel - Shop by Category selection does not work as intended						
						if(!lsFirstLevelItem.equalsIgnoreCase("category")) {
							closeFilterPopupWindow();
							verifyUrlPatternAfterSelectFilter(false);
						}	
						else {
							verifyUrlPatternAfterSelectFilter(true);
						}
						
						return true;
					}
				}
			}
		}

		//If unable to find both lsFirstLevelItem and lsSecondLevelItem, then select the first choice
		this.bDefault=true;
		
		for(int i=1;i<this.productFilterList.size();i++) {			
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			expandFilterItem(this.productFilterContainerList.get(i));
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i-1));
						
			subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);	
			for(int j=0;j<subItemList.size();j++) {	
				subItem=subItemList.get(j);
				if(!this.hasElementAttribute(subItem.findElement(By.xpath(".//button//input")), "checked")) {
					this.secondLevelFilter=this.getElementInnerText(subItem);
					this.firstLevelFilter=this.getElementInnerText(subItem.findElement(By.xpath("./ancestor::div[@class='prp-filter-panel__blocks']//button[@class='prp-filter-panel__block-title']")));
					
					getReusableActionsInstance().staticWait(500);
					getReusableActionsInstance().staticWait(500);
					if(j>4) {
						this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItemList.get(j-2));
						getReusableActionsInstance().clickIfAvailable(subItem);
					}
					else {
						getReusableActionsInstance().clickIfAvailable(subItem);
					}										
//					this.waitForSortingOrFilteringCompleted();
					getReusableActionsInstance().staticWait(3000);
					
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
					
					closeFilterPopupWindow();	
					
					verifyUrlPatternAfterSelectFilter(false);
					
					return true;
				}
			}			
		}
	
		closeFilterPopupWindow();
		return false;
	}
	
	@Override
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
		
		WebElement subItem,element;
		for(int i=0;i<subItemList.size()-1;i++) {
			subItem=subItemList.get(i);
			element=subItem.findElement(By.xpath(".//a"));			
			if(this.hasElementAttribute(element, "class")) {				
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				//this.getReusableActionsInstance().clickIfAvailable(element);
				this.clickElement(element);
				this.waitForPageToLoad();
				this.getReusableActionsInstance().staticWait(3000);
				break;
			}
		}
		
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
		
		closeFilterPopupWindowWithCloseButton();		
		return lsErrorMsg;
	}
	
	@Override
	public boolean closeAllSelectedFilters() {
		openFilterPopupWindow();	
		
		if(!this.checkChildElementExistingByAttribute(this.cntSubPanelforSelectedFilters, "class", "prp__applied-filters")) {
			closeFilterPopupWindowWithCloseButton();
			return true;
		}
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnFilterPopupClearAll);
		getReusableActionsInstance().clickIfAvailable(this.btnFilterPopupClearAll);	
		this.waitForSortingOrFilteringCompleted();
		
		closeFilterPopupWindow();		
		return true;
	}
	
	@Override
	public String verifySelectedFiltersContainSecondlevelFilter(List<String> lstFilterIncluded, List<String> lstFilterExcluded) {
		openFilterPopupWindow();
//		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnFiltersAdded);
//		getReusableActionsInstance().clickIfAvailable(this.btnFiltersAdded);
		this.clickElement(this.btnFiltersAdded);
		getReusableActionsInstance().staticWait(5000);
//		getReusableActionsInstance().waitForElementVisibility(this.selectedFiltersList.get(this.selectedFiltersList.size()-1), 20);
		
		String lsMsg="";
		List<String> lstSelectedFilterOption=new ArrayList<String>();		
		int selectedFilterSize = this.selectedFiltersList.size() - 1;
		System.out.println("selectedFilterSize: "+selectedFilterSize);
		for (int i = 0; i < selectedFilterSize; i++) {
//			getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectedFiltersList.get(i));
//			lstSelectedFilterOption.add(this.selectedFiltersList.get(i).getText().trim());
			lstSelectedFilterOption.add(this.getElementInnerText(this.selectedFiltersList.get(i)));
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
		List<WebElement> reviewStarList;
		
		loopSize=productList.size();
		loopSize=loopSize>15?15:loopSize;
		
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
				
				//Bug 19536: [QA Defect - P3] PRP: Rating and Review not showing properly
				reviewStarList=item.findElements(this.byProductReviewRatingImage);
				if(reviewStarList.size()>0) {
					reporter.reportLogPass("Product review stars are displaying correctly");
				}
				else {
					reporter.reportLogFail("Product review stars are not displaying correctly");
				}
				
				lsText=this.getElementInnerText(item.findElement(this.byProductReviewRatingCount));
				if(!lsText.isEmpty()) {
					reporter.reportLogPass("Product review count info is displaying correctly");
				}
				else {
					reporter.reportLogFail("Product review count info is not displaying correctly");
				}
			}
			
//			//Bug 19538: [QA Defect - P3] PRP: missing Free Shipping label
//			if(this.checkProductItemFreeShippingExisting(item)) {
//				element=item.findElement(byProductFreeShipping);
//				lsText=this.getElementInnerText(element);
//				if(!lsText.isEmpty()) {
//					reporter.reportLogPass("Product free shipping is not empty");
//				}
//				else {
//					reporter.reportLogFail("Product free shipping is empty");
//				}
//			}			
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
		
		boolean bSizeDropdown,bColorDoprdown;
		
		if(lsType.equalsIgnoreCase("SizeAndColour")) {
			bSizeDropdown=checkSizeOrColorOptionIsDropDown(true);
			bColorDoprdown=checkSizeOrColorOptionIsDropDown(false);
			if(bSizeDropdown&&bColorDoprdown) {
				if(lsText.equalsIgnoreCase("Go to detail page")) {
					reporter.reportLogPass("The button text is equal to 'Go to detail page'");
				}
				else {
					reporter.reportLogFail("The button text is not equal to 'Go to detail page'");
				}
			}
			
			if(bSizeDropdown&&!bColorDoprdown) {
				if(lsText.equalsIgnoreCase("Select colour")) {
					reporter.reportLogPass("The button text is equal to 'Select colour'");
				}
				else {
					reporter.reportLogFail("The button text is not equal to 'Select colour'");
				}
			}
			
			if(!bSizeDropdown&&bColorDoprdown) {
				if(lsText.equalsIgnoreCase("Select size")) {
					reporter.reportLogPass("The button text is equal to 'Select size'");
				}
				else {
					reporter.reportLogFail("The button text is not equal to 'Select size'");
				}
			}
			
			if(!bSizeDropdown&&!bColorDoprdown) {
				if(lsText.equalsIgnoreCase("Select size & colour")) {
					reporter.reportLogPass("The button text is equal to 'Select size & colour'");
				}
				else {
					reporter.reportLogFail("The button text is not equal to 'Select size & colour'");
				}
			}			
		}

		if(lsType.equalsIgnoreCase("Size")) {
			bSizeDropdown=checkSizeOrColorOptionIsDropDown(true);
			if(bSizeDropdown) {
				if(lsText.equalsIgnoreCase("Select size & colour")) {
					reporter.reportLogPass("The button text is equal to 'Select size & colour'");
				}
				else {
					reporter.reportLogFail("The button text is not equal to 'Select size & colour'");
				}
			}
			else {
				if(lsText.equalsIgnoreCase("Select size")) {
					reporter.reportLogPass("The button text is equal to 'Select size'");
				}
				else {
					reporter.reportLogFail("The button text is not equal to 'Select size'");
				}
			}			
		}

		if(lsType.equalsIgnoreCase("Colour")) {
			bColorDoprdown=checkSizeOrColorOptionIsDropDown(false);
			if(bColorDoprdown) {
				if(lsText.equalsIgnoreCase("Select size & colour")) {
					reporter.reportLogPass("The button text is equal to 'Select size & colour'");
				}
				else {
					reporter.reportLogFail("The button text is not equal to 'Select size & colour'");
				}
			}
			else {
				if(lsText.equalsIgnoreCase("Select colour")) {
					reporter.reportLogPass("The button text is equal to 'Select colour'");
				}
				else {
					reporter.reportLogFail("The button text is not equal to 'Select colour'");
				}
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
					bColorDoprdown=checkSizeOrColorOptionIsDropDown(false);
					if(bColorDoprdown) {
						if(lsText.equalsIgnoreCase("Go to detail page")) {
							reporter.reportLogPass("The button text is equal to 'Go to detail page'");
						}
						else {
							reporter.reportLogFail("The button text is not equal to 'Go to detail page'");
						}
					}
					else {
						if(lsText.equalsIgnoreCase("Select colour")) {
							reporter.reportLogPass("The button text is equal to 'Select colour'");
						}
						else {
							reporter.reportLogFail("The button text is not equal to 'Select colour'");
						}
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
	
	private boolean checkSizeOrColorOptionIsDropDown(boolean bSize) {
		List<WebElement> optionList;
		if(bSize) {
			optionList=this.getDriver().findElements(byProductOptionSizeItemList);
		}
		else {
			optionList=this.getDriver().findElements(byProductOptionColorItemList);
		}
				
		WebElement element=optionList.get(optionList.size()-1);
		if(!element.getTagName().equalsIgnoreCase("button")) {								
			return true;
		}
		return false;		
	}
	
	private boolean verifySizeOption(String lsType) {
		if(checkProductSizeOptionEnabledItemAvailableWithMouseHover()) {
			List<WebElement> optionList=this.getDriver().findElements(byProductOptionSizeItemEnabledList);
			WebElement element=optionList.get(optionList.size()-1);
			String lsText=this.getElementInnerText(element).replace("Size", "").trim();
			if(element.getTagName().equalsIgnoreCase("button")) {								
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				this.getReusableActionsInstance().clickIfAvailable(element);
			}
			else {
				Select sizeSelect= new Select(element.findElement(By.xpath("./parent::select")));
				sizeSelect.selectByIndex(optionList.size()-1);
			}			
			this.getReusableActionsInstance().staticWait(7000);

			element=this.getDriver().findElement(byProductOptionSizeSelectedSize);
			String lsSelectedTitle=this.getElementInnerText(element).replace("Size", "").trim();
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
			String lsColor,lsText;
			WebElement element=null;
			int selectNumber=0;
			
			//Bug 19285: Product image not updating when colour is chosen on smartphone or tablet
			String lsImageSrcBeforeClickingColor=itemContainer.findElement(byProductImage).getAttribute("src");			
			List<WebElement> optionList=this.getDriver().findElements(byProductOptionColorItemEnabledList);
			if(optionList.size()>1) {
				for(WebElement item:optionList) {
					if(item.getTagName().equalsIgnoreCase("button")) {
						lsColor=item.findElement(By.xpath("./input")).getAttribute("id").split("-")[4];
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
			
			//Bug 19629: [QA Defect - P3] Product card: if a product doesn't have color swatch, all color options show as plain circles
			if(element.getTagName().equalsIgnoreCase("button")) {								
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				this.getReusableActionsInstance().clickIfAvailable(element);
			}
			else {
				Select sizeSelect= new Select(element.findElement(By.xpath("./parent::select")));
				sizeSelect.selectByIndex(selectNumber);
			}
			this.getReusableActionsInstance().staticWait(3000);
			
			if(optionList.size()>1) {
				String lsImageSrcAfterClickingColor=itemContainer.findElement(byProductImage).getAttribute("src");
				if(!lsImageSrcBeforeClickingColor.equalsIgnoreCase(lsImageSrcAfterClickingColor)) {
					reporter.reportLogPass("The image is changing after choosing a different style correctly");
				}
				else {
					reporter.reportLogFail("The image is not changing after choosing a different style correctly");
				}
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
	public void verifyInfoLinkageWithPDP(ProductDetailPage pdp,String lsProductNumber) {
		if(lsProductNumber!=null) {
			this.getSearchResultLoad(lsProductNumber, true);
		}
		
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
		int loopSize;
		WebElement item,element;	
		String lsText;
		loopSize=productList.size();
		loopSize=loopSize>5?5:loopSize;
		
		for(int i=0;i<loopSize;i++) {		
			item=productList.get(i);	
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			
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
	
	/**
	 * This method will verify Product Contents have No Changes After Navigating Back With MultiFilters
	 * @param-List<List<String>> lstFilter: filter list
	 * @return void
	 */
	//Bug 19658: [QA Defect - P3] PRP: Page not refreshed to previous state with browser back button with filter applied
	@Override
	public void verifyProductContentNoChangesAfterNavigatingBackWithMultiFilters(List<List<String>> lstFilter){	
		switchPage(true);
		
		List<String> lstItem=lstFilter.get(0);
		selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1));
		String lsFirstProductNameForFirstFilter=this.getElementInnerText(this.productResultList.get(0).findElement(byProductName));
		int productCount=this.productResultList.size();
		
		lstItem=lstFilter.get(1);
		selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1));
		String lsFirstProductNameForSecondFilter=this.getElementInnerText(this.productResultList.get(0).findElement(byProductName));
		
		if(lsFirstProductNameForSecondFilter.equalsIgnoreCase(lsFirstProductNameForFirstFilter)) {
			reporter.reportLogPass("The product search results are changing after adding one more filter correctly"); 
		}
		else {
			reporter.reportLogFail("The product search results are not changing after adding one more filter correctly"); 
		}
		
		this.getDriver().navigate().back();
		this.waitForPageToLoad();
		this.getReusableActionsInstance().staticWait(3000);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,120);
		
		String lsFirstProductNameForNavigateBackFilter=this.getElementInnerText(this.productResultList.get(0).findElement(byProductName));
		int productCountForNavigateBack=this.productResultList.size();
		
		if(lsFirstProductNameForNavigateBackFilter.equalsIgnoreCase(lsFirstProductNameForFirstFilter)&&(productCountForNavigateBack==productCount)) {
			reporter.reportLogPass("The product search results are keeping the same status as just first filter applied"); 
		}
		else {
			reporter.reportLogFail("The product search results are not keeping the same status as just first filter applied"); 
		}	
	}

	//Bug 19659: [QA Defect] PRP Breadcrumb: Not keeping the past filters applied
	@Override
	public void verifyAppliedProductSubFilterRemainsAfterMultiCategoriesSelectionThroughBreadCrumbNavigation(List<List<String>> lstFilter){	
		//Select first category item
		this.bCategoryExpand=true;
		List<String> lstItem=lstFilter.get(0);
		selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1));
		
		//Check if selected list existing
		if(!checkSubPanelForSelectedFiltersExisting()) {
			reporter.reportLogPass("The selected filter list for first Category filter is not displaying"); 
		}
		else {
			reporter.reportLogFail("The selected filter list for first Category filter is displaying wrongly"); 
		}
		
		//Apply a subfilter
		lstItem=lstFilter.get(1);
		selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1));
				
		//Check if selected list existing
		if(checkSubPanelForSelectedFiltersExisting()) {
			reporter.reportLogPass("The selected filter list after selecting filters is displaying correctly"); 
		}
		else {
			reporter.reportLogFail("The selected filter list after selecting filters is not displaying correctly"); 
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
		this.getReusableActionsInstance().staticWait(3000);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,120);
		
		//Check if selected list existing
		if(checkSubPanelForSelectedFiltersExisting()) {
			reporter.reportLogPass("The selected filter list after navigating from BreadCrumb is displaying correctly"); 
		}
		else {
			reporter.reportLogFail("The selected filter list after navigating from BreadCrumb is not displaying correctly"); 
		}
	}
		
	public boolean checkSubPanelForSelectedFiltersExisting() {
		this.openFilterPopupWindow();
		boolean bReturn=this.checkChildElementExistingByTagNameAndAttribute(this.cntSubPanelforSelectedFilters, "button","class", "prp-filter-panel__mobile-subpanel__title-button");
		this.closeFilterPopupWindowWithCloseButton();
		
		return bReturn;
	}

	public void verifyBreadCrumbAfterSelectCuratedCollectionsItem(List<List<String>> lstFilter,GlobalHeaderPage ghp){	
		//Select first category item
		List<String> lstItem=lstFilter.get(0);
		ghp.clickCuratedCollectionsMenuItem(lstItem.get(0), lstItem.get(1));
		this.waitForPageToLoad();
		this.getReusableActionsInstance().staticWait(3000);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblSearchResultMessage,120);
		
		int navigateItemCount=this.lstSearchResultNavigation.size();
		if(navigateItemCount==2) {
			reporter.reportLogPass("The Navigation Breadcrumb list is containing 2 items correctly"); 
		}
		else {
			reporter.reportLogFail("The Navigation Breadcrumb list is not containing 2 items correctly"); 
		}
		
		WebElement item=this.lstSearchResultNavigation.get(this.lstSearchResultNavigation.size()-1);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		String lsText=item.getText().trim();
		if(lstItem.get(1).equalsIgnoreCase(lsText)) {
			reporter.reportLogPass("The displaying pattern is Home>"+lstItem.get(1)); 
		}
		else {
			reporter.reportLogFail("The displaying pattern is not Home>"+lstItem.get(1)); 
		}
	}
	
	//Bug 19575: [QA Defect - P3] the implementation for Category in the left nav is wrong
	@Override
	public String verifyFilterOptionsNotContainCategoryAndShopByCategorySimultaneously() {
		this.openFilterPopupWindow();
		
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
		
		this.closeFilterPopupWindowWithCloseButton();
		
		return lsErrorMsg;
	}
	
	@Override
	public void verifyInfoLinkageWithPDPWithoutSwatch(WebElement webElement,int index){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
		this.getReusableActionsInstance().scrollToElement(webElement);

		WebElement itemContainer=webElement;

		//Open SizeOrColor popup dialog
		WebElement element=itemContainer.findElement(byProductItemSelectSizeOrColor);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		this.getReusableActionsInstance().clickIfAvailable(element);
		this.getReusableActionsInstance().waitForElementVisibility(this.btnProductGoToDetails,20);
		
		//Choose size
		List<WebElement> optionList=this.getDriver().findElements(byProductOptionSizeItemEnabledList);
		element=optionList.get(optionList.size()-1);
		if(element.getTagName().equalsIgnoreCase("button")) {								
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			this.getReusableActionsInstance().clickIfAvailable(element);
		}
		else {
			Select sizeSelect= new Select(element.findElement(By.xpath("./parent::select")));
			sizeSelect.selectByIndex(optionList.size()-1);
		}		
		this.getReusableActionsInstance().staticWait(3000);

		//Choose color
		optionList=this.getDriver().findElements(byProductOptionColorItemEnabledList);
		element= optionList.get(optionList.size()-1);

		if(element.getTagName().equalsIgnoreCase("button")) {								
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			this.getReusableActionsInstance().clickIfAvailable(element);
		}
		else {
			Select sizeSelect= new Select(element.findElement(By.xpath("./parent::select")));
			sizeSelect.selectByIndex(optionList.size()-1);
		}		
		this.getReusableActionsInstance().staticWait(3000);
		
		//Close SizeOrColor popup dialog
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductGoToDetails);
		this.getReusableActionsInstance().clickIfAvailable(this.btnProductGoToDetails);		
		this.waitForPDPPageLoading();
		this.getReusableActionsInstance().staticWait(2000);
		if(this.URL().toLowerCase().contains("productdetails")) {
			reporter.reportLogPass("The user is navigated to PDP page");
		}
		else {
			reporter.reportLogFail("The user is not navigated to PDP page");
		}
	}
	
}