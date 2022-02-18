package com.tsc.pages;

import com.tsc.api.pojo.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ProductResultsPage_Mobile extends ProductResultsPage {

    public ProductResultsPage_Mobile(WebDriver driver) {
        super(driver);
    }

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp__count-and-shorting']//button[@class='prp__count-and-shorting__filter-button']")
	public WebElement btnFilterPopup;
	
	//For filter popup window
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp']")
	public WebElement cntFilterPopupContainer;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__header']//button[@class='prp-filter-panel__header__close']")
	public WebElement btnFilterPopupClose;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__header']//span[@class='prp-filter-panel__header__title']")
	public WebElement lblFilterPopupHeaderTitle;
    
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__header']//button[@class='prp-filter-panel__header__clear']")
	public WebElement btnFilterPopupClearAll;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__header']//span[@class='prp-filter-panel__header__title']")
	public WebElement btnFilterPopupTitle;

	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel__mobile-subpanel']//button[@class='prp-filter-panel__mobile-subpanel__title-button']")
	public WebElement btnFiltersAdded;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel__mobile-subpanel']//div[@class='prp-filter-panel__mobile-subpanel__buttons']//button")
	public List<WebElement> selectedFiltersList;
	
	@FindBy(xpath = "//section[@class='tsc-container']//div[@class='prp-filter-panel__mobile-subpanel']//button[@class='prp-filter-panel__submit-button prp-filter-panel__submit-button--panel']")
	public WebElement btnViewProductsAfterSelectingFilters;
	
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

	public By byProductOptionSizeSelectedSizeContainer=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//span[@class='product-card__size-title']");

	public By byProductOptionSizeSelectedSize=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//span[@class='product-card__size-title']//strong");

	public By byProductOptionSizeWrapper=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[@class='product-card__size-wrapper']");

	public By byProductOptionSizeDropDown=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__size__dropdown')]");

	public By byProductOptionSizeItemList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button|//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__size__dropdown')]//option");

	public By byProductOptionSizeItemEnabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[not(@disabled)]|//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__size__dropdown')]//option[not(@disabled)]");

	public By byProductOptionSizeItemDisabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[@disabled]|//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__size__dropdown')]//option[@disabled]");

	public By byProductOptionSizeSelectedItem=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__size-items')]//button[@aria-pressed='true']|//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__size__dropdown')]//option[@selected]");

	public By byProductOptionSizeViewAllSizes=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//a[@class='product-card__size-view-all']");

	public By byProductOptionSizeNiceSelectList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__size__dropdown')]/following-sibling::div[@class='niceSelect__container']//ul/li/button");

	public By byProductOptionSizeNiceSelectButton=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__size__dropdown')]/following-sibling::div[@class='niceSelect__container']//button[@id='niceSelect-nsSizeTaste-selected']");

	//For color option
	public By byProductOptionColorTitle=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//p[@class='product-card__color-and-taste-title']");

	public By byProductOptionColorSelectedColorContainer=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//p[@class='product-card__color-and-taste-title']");

	public By byProductOptionColorSelectedColor=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//p[@class='product-card__color-and-taste-title']//strong");

	public By byProductOptionColorWrapper=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[@class='product-card__color-and-taste-wrapper']");

	public By byProductOptionColorDropDown=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]");

	public By byProductOptionColorItemList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button|//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]//option");

	public By byProductOptionColorItemEnabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[not(@disabled)]|//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]//option[not(@disabled)]");

	public By byProductOptionColorItemDisabledList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@disabled]|//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]//option[@disabled]");

	public By byProductOptionColorSelectedItem=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//div[contains(@class,'product-card__color-and-taste-items')]//button[@aria-pressed='true']|//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]//option[not(@selected)]");

	public By byProductGoToDetails=By.xpath("//div[@class='product-card__mobile-modal']//button[@class='product-card__add-button product-card__add-button--modal']");

	public By byProductSizeOrColorClose=By.xpath("//div[@class='product-card__mobile-modal']//button[@class='product-card__add-button product-card__add-button--modal']");

	public By byProductOptionColorNiceSelectList=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]/following-sibling::div[@class='niceSelect__container']//ul/li/button");

	public By byProductOptionColorNiceSelectButton=By.xpath("//div[@class='product-card__mobile-modal']//fieldset//select[contains(@class,'product-card__color-and-taste__dropdown')]/following-sibling::div[@class='niceSelect__container']//button[@id='niceSelect-nsColourTaste-selected']");

	@FindBy(xpath = "//div[@class='product-card__mobile-modal']//button[@class='product-card__add-button product-card__add-button--modal']")
	//@FindBy(xpath="//div[contains(@class,'product-card')]//button[contains(@class,'product-card__add-button')]")
	public WebElement btnProductGoToDetails;
	
	@FindBy(xpath = "//div[@class='product-card__mobile-modal']//button[@class='product-card__mobile-modal__close-button']")
	public WebElement btnProductSizeOrColorClose;

	public By btnProductSizeOrColor = By.xpath(".//button[contains(@class,'product-card__add-button')]");

	@FindBy(xpath="//div[contains(@class,'modal')]//a[contains(.,'View')]")
	public WebElement lnkViewAllColors;

	@FindBy(xpath="//div[contains(@class,'-modal')]/button[contains(@class,'close')]")
	public WebElement btnPopUpMenuCloseButton;

	@FindBy(xpath="//div[contains(@class,'-modal')]//div[contains(@class,'color-and-taste')]//*[contains(@class,'title')]/strong")
	public WebElement lblSelectedColorTextLabel;

	@FindBy(xpath="//div[contains(@class,'modal')]//select")
	public WebElement lstDropDownForColorSelection;

	@FindBy(xpath="//div[contains(@class,'modal')]//select/option[not(@disabled)]")
	public List<WebElement> lblOptionEnabledColorForProduct;

	@FindBy(xpath="//div[contains(@class,'modal')]//select/option")
	public List<WebElement> lstTotalItemsOnPRPPage;
	
	public void openFilterPopupWindow() {
		this.clickElement(this.btnFilterPopup);
		this.getReusableActionsInstance().waitForElementVisibility(lblFilterPopupHeaderTitle, 20);
	}
	
	public void closeFilterPopupWindow() {
		this.clickElement(this.btnViewProductsAfterSelectingFilters);
		this.waitForCondition(Driver->{return !checkFilterPopupExisting();},5000);
	}
	
	public void closeFilterPopupWindowWithCloseButton() {
		this.clickElement(this.btnFilterPopupClose);
		this.waitForCondition(Driver->{return !checkFilterPopupExisting();},5000);
	}

	public boolean checkFilterPopupExisting(){
		return this.checkChildElementExistingByAttribute(this.cntFilterPopupContainer,"class","prp-filter-panel");
	}

	//BUG-19745-[Release Defect - P3] the filter menu in PRP iOS is covered by a panel and can't be closed /cancelled
	public void verifyFilterSection(){
		//Verification of Close button
		boolean btnCloseButton = getReusableActionsInstance().isElementVisible(this.btnFilterPopupClose);
		//Verification of ClearAll button
		boolean btnClearAll = getReusableActionsInstance().isElementVisible(this.btnFilterPopupClearAll);
		//Verification of filter text
		String filterPopupText = this.getElementInnerText(this.btnFilterPopupTitle);
		if(btnCloseButton && btnClearAll && filterPopupText.toLowerCase().equals("filter"))
			reporter.reportLogPass("Filter Section for mobile is present after selecting required filter");
		else
			reporter.reportLogFail("Filter Section is not for mobile is present after selecting required filter");
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
			final String tempHeader=lsHeader;
			//If found lsFirstLevelItem
			if(lsHeader.equalsIgnoreCase(lsFirstLevelItem)) {					
				if(!lsFirstLevelItem.equalsIgnoreCase("category")) {
					if(!checkIfFilterItemIsCollapsed(this.productFilterContainerList.get(i)) ){
						collapseFilterItemWithClickingProductTitle(this.productFilterContainerList.get(i));
					}
				}
				
				//If find a search input
				if(checkSearchInputButtonExistingInSubFilter(this.productFilterContainerList.get(i))) {						
					searchInputButton=this.productFilterContainerList.get(i).findElement(this.byProductFilterSearchInput);
					searchInputButton.sendKeys(lsSecondLevelItem);
					//Keep it to wait for search results displaying
					this.getReusableActionsInstance().staticWait(300);

					subItemList=this.productFilterContainerList.get(i).findElements(this.bySecondaryFilterAll);
					if(subItemList.size()>0) {
						subItem=subItemList.get(0).findElement(By.xpath(".//label"));
						getReusableActionsInstance().clickIfAvailable(subItem);

						final By bySelectedSecondFilter=By.xpath("//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__blocks']//button[@class='prp-filter-panel__block-title'][.='"+lsHeader+" (1)']");
						this.waitForCondition(Driver->{ return this.getDriver().findElement(bySelectedSecondFilter).isDisplayed();},8000);

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

						//Verification of BUG-19745
						reporter.reportLog("Verifying BUG-19745-[Release Defect - P3] the filter menu in PRP iOS");
						this.verifyFilterSection();

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

					//If found lsSecondLevelItem
					if(lsSubItem.equalsIgnoreCase(lsSecondLevelItem)) {							
						if(lsFirstLevelItem.equalsIgnoreCase("category")) {
							subItem=subItem.findElement(By.xpath(".//a"));
						}
						else {
							subItem=subItemList.get(j).findElement(By.xpath(".//label"));
						}
												
						if(j>4) {
							this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItemList.get(j-3));
							//Verification of BUG-19745
							reporter.reportLog("Verifying BUG-19745-[Release Defect - P3] the filter menu in PRP iOS");
							this.verifyFilterSection();
							this.getReusableActionsInstance().clickIfAvailable(subItem);
						}
						else {
							//Verification of BUG-19745
							reporter.reportLog("Verifying BUG-19745-[Release Defect - P3] the filter menu in PRP iOS");
							this.verifyFilterSection();
							this.getReusableActionsInstance().clickIfAvailable(subItem);
						}
						if(lsHeader.toLowerCase().equalsIgnoreCase("category")){
							this.waitForPageToLoad();
						}
						else{
							final By bySelectedSecondFilter=By.xpath("//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__blocks']//button[@class='prp-filter-panel__block-title'][.='"+lsHeader+" (1)']");
							this.waitForCondition(Driver->{ return this.getDriver().findElement(bySelectedSecondFilter).isDisplayed();},8000);
						}

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
							//Verification of BUG-19745
							reporter.reportLog("Verifying BUG-19745-[Release Defect - P3] the filter menu in PRP iOS");
							this.verifyFilterSection();

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
					lsHeader=this.firstLevelFilter;

					subItem=subItemList.get(j).findElement(By.xpath(".//label"));
					if(j>4) {
						this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItemList.get(j-2));
						subItem.click();
					}
					else {
						subItem.click();
					}

					final By bySelectedSecondFilter=By.xpath("//section[@class='tsc-container']//div[@class='prp-filter-panel']//div[@class='prp-filter-panel__blocks']//button[@class='prp-filter-panel__block-title'][.='"+lsHeader+" (1)']");
					this.waitForCondition(Driver->{ return this.getDriver().findElement(bySelectedSecondFilter).isDisplayed();},8000);
					
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

					//Verification of BUG-19745
					reporter.reportLog("Verifying BUG-19745-[Release Defect - P3] the filter menu in PRP iOS");
					this.verifyFilterSection();

					closeFilterPopupWindow();	
					
					verifyUrlPatternAfterSelectFilter(false);
					
					return true;
				}
			}			
		}
		//Verification of BUG-19745
		reporter.reportLog("Verifying BUG-19745-[Release Defect - P3] the filter menu in PRP iOS");
		this.verifyFilterSection();

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
				this.clickElement(element);
				this.waitForPageToLoad();
				break;
			}
		}
		
	}
	
	@Override
	public void expandFilterItem(WebElement filterContainerItem) {		
		if(checkIfFilterItemIsCollapsed(filterContainerItem)) {
			clickSeeMoreButton(filterContainerItem);
			if(!checkIfFilterItemIsCollapsed(filterContainerItem)){
				collapseFilterItemWithClickingProductTitle(filterContainerItem);
			}
			return;
		}
				
		WebElement productFilterTitle=filterContainerItem.findElement(this.byProductFilterTitle);
		this.clickElement(productFilterTitle);
		this.waitForCondition(Driver->{return checkIfFilterItemIsCollapsed(filterContainerItem);},5000);

		clickSeeMoreButton(filterContainerItem);
		if(!checkIfFilterItemIsCollapsed(filterContainerItem)){
			collapseFilterItemWithClickingProductTitle(filterContainerItem);
		}
	}
	
	@Override
	public void clickSeeMoreButton(WebElement filterContainerItem) {
		String lsButtonType=this.checkFilterItemSeeButtonExisting(filterContainerItem);
		if(lsButtonType.equalsIgnoreCase("SeeMore")) {
			WebElement seeMoreButton=filterContainerItem.findElement(this.bySecondaryFilterSeeMoreButton);
			this.clickElement(seeMoreButton);
			this.waitForCondition(Driver->{return this.checkFilterItemSeeButtonExisting(filterContainerItem).equalsIgnoreCase("SeeLess");},5000);
		}
	}
	
	@Override
	public void collapseFilterItemWithClickingProductTitle(WebElement filterContainerItem) {		
		WebElement productFilterTitle=filterContainerItem.findElement(this.byProductFilterTitle);
		this.clickElement(productFilterTitle);
		this.waitForCondition(Driver->{return checkIfFilterItemIsCollapsed(filterContainerItem);},5000);
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
		this.clickElement(this.btnFiltersAdded);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		String lsMsg="";
		List<String> lstSelectedFilterOption=new ArrayList<String>();		
		int selectedFilterSize = this.selectedFiltersList.size() - 1;
		for (int i = 0; i < selectedFilterSize; i++) {
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
		int loopSize=this.productFilterContainerList.size();
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
	public void verifySearchResultContent(List<WebElement> productList,boolean bMandatoryOnly) {
		if(bMandatoryOnly){
			verifySearchResultContentForMandatoryFields(productList);
		}
		else{
			verifySearchResultContentForMandatoryFields(productList);

			verifySearchResultContentForOptionalFields(productList);
		}
	}

	public void verifySearchResultContentForMandatoryFields(List<WebElement> productList) {
		int loopSize;
		WebElement item,element;
		String lsProductName,lsText;
		List<WebElement> reviewStarList;

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
				reporter.reportLogFail("Product Name is empty");
			}
			//Bug 19537: [QA Defect - P3] PRP: Is Price should be bold
			if(element.getCssValue("font-weight").equalsIgnoreCase("600")) {
				reporter.reportLogPass("Product name is semi bold font");
			}
			else {
				reporter.reportLogFail("Product name is not semi bold font");
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

		}
	}

	public void verifySearchResultContentForOptionalFields(List<WebElement> productList) {
		int loopSize;
		WebElement item,element;
		String lsProductName,lsText;
		List<WebElement> reviewStarList;
		List<WebElement> optionList;

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
					reporter.reportLogFail("Product title is empty");
				}
				//Bug 19683: [UAT Defect] PRP: Merchandising badges i.e. Clearance, BlockBuster etc. should be bolded
				if(element.getCssValue("font-weight").equalsIgnoreCase("800")) {
					reporter.reportLogPass("Product title is bold font");
				}
				else {
					reporter.reportLogFail("Product title is not bold font");
				}
			}

			element=item.findElement(byProductItemSelectSizeOrColor);
			optionList=item.findElements(this.byProductOptionList);
			lsText=this.getElementInnerText(optionList.get(0));
			if(this.getElementInnerText(element).equalsIgnoreCase("Go to detail page")) {
				if(lsText.isEmpty()) {
					reporter.reportLogPass("Product option is empty");
				}
				else {
					reporter.reportLogFail("Product option is not empty");
				}
			}
			else{
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

		}
	}

	@Override
	public void verifySearchResultContentWithMouseHover(List<WebElement> productList,boolean bMouseHoverOnly) {
		int loopSize;
		WebElement item,element;
		String lsText;
		loopSize=productList.size();
		loopSize=loopSize>4?4:loopSize;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(productList.get(0));
		this.getReusableActionsInstance().scrollToElement(productList.get(0));


		for(int i=0;i<loopSize;i++) {
			item=productList.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			this.getReusableActionsInstance().scrollToElement(item);

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
			this.getReusableActionsInstance().scrollToElement(element);
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
						reporter.reportLogPass("Product ViewAllSize button title is not empty");
					}
					else {
						reporter.reportLogFail("Product ViewAllSize button title is empty");
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


				if(checkViewAllColorsButtonExisting()) {
					element=item.findElement(byProductOptionColorViewAllColors);
					lsText=this.getElementInnerText(element);
					if(!lsText.isEmpty()) {
						reporter.reportLogPass("Product ViewAllColor button title is not empty");
					}
					else {
						reporter.reportLogFail("Product ViewAllColor button title is empty");
					}
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
			this.getReusableActionsInstance().scrollToElement(this.btnProductSizeOrColorClose);
			this.getReusableActionsInstance().clickIfAvailable(this.btnProductSizeOrColorClose);

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
		WebElement element,elementSelectedText;
		final WebElement tempElementSize,tempElementColor;
		
		String lsType=this.judgeProductOptionType();
		if(lsType.contains("Size")) {	
			if(checkProductSizeOptionEnabledItemAvailableWithMouseHover()) {
				elementSelectedText=this.getDriver().findElement(byProductOptionSizeSelectedSizeContainer);
				tempElementSize=elementSelectedText;

				optionList=this.getDriver().findElements(byProductOptionSizeItemEnabledList);
				//this.clickElement(optionList.get(0));
				element=optionList.get(0);
				if(element.getTagName().equalsIgnoreCase("button")) {
					this.getReusableActionsInstance().clickIfAvailable(element,5000);
					this.waitForCondition(Driver->{return !this.getElementInnerText(tempElementSize).equalsIgnoreCase("Select size:");},10000);
				}
				else {
					WebElement dropDown=element.findElement(By.xpath("./parent::select"));
					checkSizeSelectOptions(dropDown);
				}

				element=this.getDriver().findElement(byProductOptionSizeSelectedSize);
				selectedProductItem.productSelectedSize=this.getElementInnerText(element);
			}
			else {
				selectedProductItem.productSelectedSize="";
			}			
		}
		
		if(lsType.contains("Colour")) {	
			if(checkProductColorOptionEnabledItemAvailableWithMouseHover()) {
				elementSelectedText=this.getDriver().findElement(byProductOptionColorSelectedColorContainer);
				tempElementColor=elementSelectedText;

				optionList=this.getDriver().findElements(byProductOptionColorItemEnabledList);
				//this.clickElement(optionList.get(0));
				element=optionList.get(0);
				if(element.getTagName().equalsIgnoreCase("button")) {
					this.getReusableActionsInstance().clickIfAvailable(element,5000);
					this.waitForCondition(Driver->{return !this.getElementInnerText(tempElementColor).equalsIgnoreCase("Select colour:");},10000);
				}
				else {
					WebElement dropDown=element.findElement(By.xpath("./parent::select"));
					checkColorSelectOptions(dropDown);
				}

				element=this.getDriver().findElement(byProductOptionColorSelectedColor);
				selectedProductItem.productSelectedColor=this.getElementInnerText(element);
			}
			else {
				selectedProductItem.productSelectedColor="";
			}			
		}
		
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

	private String checkColorSelectOptions(WebElement dropDown){
		List<WebElement> itemList;
		WebElement niceSelectButton;
		String colorToBeSelected="";
		if(dropDown.getAttribute("class").contains("visually-hidden")){
			niceSelectButton=this.getDriver().findElement(byProductOptionColorNiceSelectButton);
			this.clickElement(niceSelectButton);
			this.applyStaticWait(1000);
			itemList=this.getDriver().findElements(this.byProductOptionColorNiceSelectList);

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
			List<WebElement> enabledColor = this.getDriver().findElements(this.byProductOptionColorItemEnabledList);
			colorToBeSelected = enabledColor.get(enabledColor.size()-1).getAttribute("value");
			select.selectByValue(colorToBeSelected);
		}
		//Unable to find explicit wait condition, so hve to use static wait
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		return colorToBeSelected;
	}

	private String checkSizeSelectOptions(WebElement dropDown){
		List<WebElement> itemList;
		WebElement niceSelectButton;
		String sizeToBeSelected="";
		if(dropDown.getAttribute("class").contains("visually-hidden")){
			niceSelectButton=this.getDriver().findElement(byProductOptionSizeNiceSelectButton);
			this.clickElement(niceSelectButton);
			this.applyStaticWait(1000);
			itemList=this.getDriver().findElements(this.byProductOptionSizeNiceSelectList);

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
			List<WebElement> enabledColor = this.getDriver().findElements(this.byProductOptionSizeItemEnabledList);
			sizeToBeSelected = enabledColor.get(enabledColor.size()-1).getAttribute("value");
			select.selectByValue(sizeToBeSelected);
		}
		//Unable to find explicit wait condition, so hve to use static wait
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		return sizeToBeSelected;
	}

	private boolean verifySizeOption(String lsType) {
		if(checkProductSizeOptionEnabledItemAvailableWithMouseHover()) {
			WebElement elementSelectedText;
			final WebElement tempElementSize;
			elementSelectedText=this.getDriver().findElement(byProductOptionSizeSelectedSizeContainer);
			tempElementSize=elementSelectedText;

			List<WebElement> optionList=this.getDriver().findElements(byProductOptionSizeItemEnabledList);
			WebElement element=optionList.get(optionList.size()-1);
			String lsText=this.getElementInnerText(element).replace("Size", "").trim();
			if(element.getTagName().equalsIgnoreCase("button")) {								
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				this.getReusableActionsInstance().clickIfAvailable(element);
				this.waitForCondition(Driver->{return !this.getElementInnerText(tempElementSize).equalsIgnoreCase("Select size:");},10000);
			}
			else {
				WebElement dropDown=element.findElement(By.xpath("./parent::select"));
				checkSizeSelectOptions(dropDown);
			}			

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
			WebElement elementSelectedText;
			final WebElement tempElementColor;
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

			elementSelectedText=this.getDriver().findElement(byProductOptionColorSelectedColorContainer);
			tempElementColor=elementSelectedText;
			//Bug 19629: [QA Defect - P3] Product card: if a product doesn't have color swatch, all color options show as plain circles
			if(element.getTagName().equalsIgnoreCase("button")) {								
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				this.getReusableActionsInstance().clickIfAvailable(element);
				this.waitForCondition(Driver->{return !this.getElementInnerText(tempElementColor).equalsIgnoreCase("Select colour:");},10000);
			}
			else {
				WebElement dropDown=element.findElement(By.xpath("./parent::select"));
				checkColorSelectOptions(dropDown);
			}
			
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
		WebElement itemContainer;
				
		if(lsProductNumber!=null) {			
			this.getSearchResultLoad(lsProductNumber, true);
			itemContainer=this.productResultList.get(0);
			
			this.selectedProductItem.init();
			
			this.selectedProductItem.productNumber=lsProductNumber;
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
		}
				
		WebElement element;
		String lsSelectedTitle,lsType;
		
		element=this.productResultList.get(0).findElement(byProductItemSelectSizeOrColor);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		this.getReusableActionsInstance().clickIfAvailable(element);
		this.getReusableActionsInstance().waitForElementVisibility(this.btnProductGoToDetails,20);
		
		lsType=this.judgeProductOptionType();	
		//If all displayed size or color are disabled
		if(!checkProductSizeOptionEnabledItemAvailableWithMouseHover()||!checkProductColorOptionEnabledItemAvailableWithMouseHover()) {
			reporter.reportLog("No enabled size/color option available");
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
			reporter.reportLogPass("The product name of "+this.selectedProductItem.productName+" in PRP is the same as the one of "+lsProductName+" displayed in PDP");
		}
		else {
			reporter.reportLogFail("The product name of "+this.selectedProductItem.productName+" in PRP is not the same as the one of "+lsProductName+" displayed in PDP");
		}

		if(!this.selectedProductItem.productBrand.isEmpty()) {
			String lsProductBrand=pdp.getElementInnerText(pdp.lnkBrandName).replace("Brand:", "").trim();
			if(lsProductBrand.toUpperCase().contains(this.selectedProductItem.productBrand.toUpperCase())) {
				reporter.reportLogPass("The product brand of "+this.selectedProductItem.productBrand+" in PRP is the same as the one of "+lsProductBrand+" displayed in PDP");
			}
			else {
				reporter.reportLogFail("The product brand of "+this.selectedProductItem.productBrand+" in PRP is not the same as the one of "+lsProductBrand+" displayed in PDP");
			}
		}

		String lsProductNowPrice=pdp.getElementInnerText(pdp.lblProductNowPrice);
		if(lsProductNowPrice.equalsIgnoreCase(this.selectedProductItem.productNowPrice)) {
			reporter.reportLogPass("The product NowPrice of "+this.selectedProductItem.productNowPrice+" in PRP is the same as the one of "+lsProductNowPrice+" displayed in PDP");
		}
		else {
			reporter.reportLogFail("The product NowPrice of "+this.selectedProductItem.productNowPrice+" in PRP is not the same as the one of "+lsProductNowPrice+" displayed in PDP");
		}

		String lsProductWasPrice=pdp.getElementInnerText(pdp.lblProductWasPrice);
		if(lsProductWasPrice.equalsIgnoreCase(this.selectedProductItem.productWasPrice)) {
			reporter.reportLogPass("The product WasPrice of "+this.selectedProductItem.productWasPrice+" in PRP is the same as the one of "+lsProductWasPrice+" displayed in PDP");
		}
		else {
			reporter.reportLogFail("The product WasPrice of "+this.selectedProductItem.productWasPrice+" in PRP is not the same as the one of "+lsProductWasPrice+" displayed in PDP");
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
		return this.getChildElementCount(sizeContainer)>2;
	}

	public boolean checkViewAllColorsButtonExisting() {
		WebElement colorContainer=this.getDriver().findElement(this.byProductOptionColorWrapper);
		return this.getChildElementCount(colorContainer)>2;
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
		WebElement elementSelectedText;
		final WebElement tempElementSize,tempElementColor;

		//Open SizeOrColor popup dialog
		WebElement element=itemContainer.findElement(byProductItemSelectSizeOrColor);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		this.getReusableActionsInstance().clickIfAvailable(element);
		this.getReusableActionsInstance().waitForElementVisibility(this.btnProductGoToDetails,20);
		
		//Choose size
		elementSelectedText=this.getDriver().findElement(byProductOptionSizeSelectedSizeContainer);
		tempElementSize=elementSelectedText;
		List<WebElement> optionList=this.getDriver().findElements(byProductOptionSizeItemEnabledList);
		element=optionList.get(optionList.size()-1);
		if(element.getTagName().equalsIgnoreCase("button")) {								
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			this.getReusableActionsInstance().clickIfAvailable(element);
			this.waitForCondition(Driver->{return !this.getElementInnerText(tempElementSize).equalsIgnoreCase("Select size:");},10000);
		}
		else {
			WebElement dropDown=element.findElement(By.xpath("./parent::select"));
			checkSizeSelectOptions(dropDown);
		}		

		//Choose color
		elementSelectedText=this.getDriver().findElement(byProductOptionColorSelectedColorContainer);
		tempElementColor=elementSelectedText;
		optionList=this.getDriver().findElements(byProductOptionColorItemEnabledList);
		element= optionList.get(optionList.size()-1);

		if(element.getTagName().equalsIgnoreCase("button")) {								
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			this.getReusableActionsInstance().clickIfAvailable(element);
			this.waitForCondition(Driver->{return !this.getElementInnerText(tempElementColor).equalsIgnoreCase("Select colour:");},10000);
		}
		else {
			WebElement dropDown=element.findElement(By.xpath("./parent::select"));
			checkColorSelectOptions(dropDown);
		}		

		//Close SizeOrColor popup dialog
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductGoToDetails);
		this.getReusableActionsInstance().clickIfAvailable(this.btnProductGoToDetails);		
		this.waitForPDPPageLoading();

		if(this.URL().toLowerCase().contains("productdetails")) {
			reporter.reportLogPass("The user is navigated to PDP page");
		}
		else {
			reporter.reportLogFail("The user is not navigated to PDP page");
		}
	}

	@Override
	public void verifyMoreAndLessButton(List<String> lstMoreButton){
		openFilterPopupWindow();
		for(String lsHeader:lstMoreButton) {
			//Get the element container corresponding to the first level filter
			WebElement element = getFilterContainerWithSpecificFirstlevelFilterInLeftPanel(lsHeader);
			if (element == null) {
				System.out.println(lsHeader+" is null");
				break;
			}

			if (!checkIfFilterItemIsCollapsed(element)) {
				collapseFilterItemWithClickingProductTitle(element);
			}
			System.out.println(checkFilterItemSeeButtonExisting(element));
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
				reporter.reportLogFail("The subitem count after clicking SeeMore button is no more than the count before clicking SeeMore button");
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
		}
		closeFilterPopupWindow();
	}

	@Override
	public void selectAndVerifyProductColor(){
		waitForCondition(driver->{return (this.getProductList().size()>0 && (new GlobalHeaderPage(this.getDriver()).lblTSCChatBox.getText().contains("Chat")));},10000);
		List<WebElement> productList = this.getProductList();
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		for(int counter=0;counter<productList.size();counter++){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(productList.get(counter));
			this.getReusableActionsInstance().scrollToElement(productList.get(counter));

			WebElement itemButton = productList.get(counter).findElement(this.btnProductSizeOrColor);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(itemButton);
			this.getReusableActionsInstance().clickIfAvailable(itemButton);
			waitForCondition(driver->{return (this.btnProductSizeOrColorClose.isDisplayed() && this.btnProductSizeOrColorClose.isEnabled());},3000);

			//Verification that only first 16 colors are displayed on screen
			if(this.lstTotalItemsOnPRPPage.size()==16)
				reporter.reportLogPass("Total items displayed om PRP page are: "+this.lstTotalItemsOnPRPPage.size());
			else
				reporter.reportLogFail("Total items displayed om PRP page are: "+this.lstTotalItemsOnPRPPage.size());

			//Click on View all colors to navigate to PDP page
			this.waitForPageLoadingByUrlChange(this.lnkViewAllColors);
			this.waitForPDPPageLoading();

			//Storing image that is displayed currently for verification
			String currentSelectedImage = productDetailPage.imgCurrentImageDisplayedForProduct.getAttribute("href");

			Select select = new Select(productDetailPage.selectProductStyle);
			List<WebElement> enabledColor = productDetailPage.lstDropdownProductStyle;
			String colorNameToBeSelected = enabledColor.get(enabledColor.size()-1).getAttribute("value");
			select.selectByValue(colorNameToBeSelected);
			//Static wait for 3 seconds is mandatory here as just image changes in DOM and rest
			//everything is same on page. Since no unique change condition exists for waitForCondition
			//function, using static wait of 2 sec below
			this.getReusableActionsInstance().staticWait(2000);
			String newSelectedImage = productDetailPage.imgCurrentImageDisplayedForProduct.getAttribute("href");

			if(!currentSelectedImage.equals(newSelectedImage))
				reporter.reportLogPass("New image is loaded after colour change as: "+currentSelectedImage+" replacing the last image: "+newSelectedImage);
			else
				reporter.reportLogFailWithScreenshot("New image is not loaded after colour change as: "+currentSelectedImage+" replacing the last image: "+newSelectedImage);
		}
	}

	public void verifyCategoryDetailsOnPRPForProduct(List<Product.DimensionStates> categoryDimensions, String searchKeyword) {
		this.getSearchResultLoad(searchKeyword, true);
		this.waitForPageLoading();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnFilterPopup);
		this.getReusableActionsInstance().scrollToElement(this.btnFilterPopup);
		this.getReusableActionsInstance().clickIfAvailable(this.btnFilterPopup);
		super.verifyCategoryDetailsOnPRPForProduct(categoryDimensions,searchKeyword);
	}

}