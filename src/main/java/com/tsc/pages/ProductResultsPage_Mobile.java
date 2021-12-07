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

    /*
     * This methods will select filter from Sort&Filter section.
     *
     * @param String lsFirstLevelItem: header filter keyword
     * @param String lsSecondLevelItem: subFilter keyword
     * @return true/false
     * @author Viswas.reddy
     * CER_619
     */

    @FindBy(xpath = "//product-results//div[contains(@class,'hidden-md hidden-sm')]")
    WebElement sortAndFilter;

    @FindBy(xpath = "//product-results//div[contains(@class,'modalBody')]//form//select")
    WebElement btnSortSelect;
    
	@FindBy(xpath = "//product-results//div[@class='modalBody']//div[@class='filterTag']/span")
	List<WebElement> selectedFiltersListMobile;

    @FindBy(xpath = "//product-results//div[@class='modal-header prpModalHeader hidden-lg']/div/h4[@id='cancel-model']")
    public WebElement cancelButton;

    @FindBy(xpath = "//product-results//span[@id='clearAll' and not(contains(@class,'refineName'))]")
    WebElement clearAllFilters;

    @FindBy(xpath = "//product-results//div[contains(@class,'modalBody')]//form//select//option")
    List<WebElement> sortByOptionList;

    @FindBy(xpath="//div[contains(@class,'searchDiv')]")
    WebElement lblSearchResultTitle;
    

    @Override
    public boolean chooseSortOptionByVisibleText(List<String> lsOption) {
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.sortAndFilter);
        getReusableActionsInstance().clickIfAvailable(this.sortAndFilter,3000);
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSortSelect);
        Select sortOption= new Select(this.btnSortSelect);
        sortOption.selectByVisibleText(lsOption.get(0));

        return this.waitForPageLoading();
    }

    @Override
    public boolean selectFilterItemInLeftPanel(String lsFirstLevelItem, String lsSecondLevelItem) {
        this.firstLevelFilter = lsFirstLevelItem;
        this.secondLevelFilter = lsSecondLevelItem;
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.sortAndFilter);
        getReusableActionsInstance().clickIfAvailable(this.sortAndFilter,3000);
        getReusableActionsInstance().staticWait(2000);

        for(int i=0;i<this.productFilterList.size();i++) {
            int iFlag=0;
            getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
            String lsHeader = this.productFilterList.get(i).getText().trim();
            if (lsHeader.contains("(")) {
                iFlag=iFlag+1;
                lsHeader = lsHeader.split("\\(")[0].trim();
            }

            //If found lsFirstLevelItem
            if (lsHeader.equalsIgnoreCase(lsFirstLevelItem)) {
                if (iFlag==0) {
                    this.productFilterList.get(i).click();
                }

                getReusableActionsInstance().staticWait(300);

                List<WebElement> subItemList = this.productFilterContainerList.get(i).findElements(this.bySubItemListOnLeftPanel);
                System.out.println("subItemList size: "+subItemList.size());
                for (WebElement subItem : subItemList) {
                    getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
                    String lsSubItem = subItem.getText().trim();
                    getReusableActionsInstance().staticWait(500);

                    //If found lsSecondLevelItem
                    if (lsSubItem.equalsIgnoreCase(lsSecondLevelItem)) {
                        getReusableActionsInstance().staticWait(500);
                        subItem.click();
                        return this.waitForPageLoading();
                    }
                }
            }
        }

        //If unable to find both lsFirstLevelItem and lsSecondLevelItem, then select the first choice
        this.bDefault=true;
        WebElement btnSecondlevelSelected=this.secondlevelFilterList.get(0);
        WebElement btnFirstlevelSelected=btnSecondlevelSelected.findElement(By.xpath("./ancestor::div[@role='tabpanel']/preceding-sibling::*[contains(@class,'panel-heading')]"));
        getReusableActionsInstance().javascriptScrollByVisibleElement(btnFirstlevelSelected);
        this.firstLevelFilter=btnFirstlevelSelected.getText().trim();
        if(this.firstLevelFilter.contains("(")) {
            this.firstLevelFilter=this.firstLevelFilter.split("\\(")[0].trim();
        }

        btnFirstlevelSelected.click();
        getReusableActionsInstance().staticWait(300);

        getReusableActionsInstance().javascriptScrollByVisibleElement(btnSecondlevelSelected);
        this.secondLevelFilter=btnSecondlevelSelected.getText().trim();
        btnSecondlevelSelected.click();

        return this.waitForPageLoading();

    }

    @Override
    public boolean getClearAllFiltersButtonStatus() {
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.sortAndFilter);
        getReusableActionsInstance().clickIfAvailable(this.sortAndFilter,3000);
        return super.getClearAllFiltersButtonStatus();
    }

    @Override
    public boolean closeAllSelectedFilters() {

        try {
            if (sortAndFilter.getText().contains("(")) {
                getReusableActionsInstance().javascriptScrollByVisibleElement(this.sortAndFilter);
                getReusableActionsInstance().clickIfAvailable(this.sortAndFilter,3000);
                getReusableActionsInstance().clickIfAvailable(this.clearAllFilters,3000);
            }
        }
        catch (Exception e) {
            if (clearAllFilters.isDisplayed()) {
                getReusableActionsInstance().clickIfAvailable(this.clearAllFilters,3000);
            } else {
                getReusableActionsInstance().clickIfAvailable(this.cancelButton,3000);
             }
        }
        return this.waitForPageLoading();
    }

    @Override
    public boolean verifySortOptions(List<String> lstOptionYml) {
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.sortAndFilter);
        getReusableActionsInstance().clickIfAvailable(this.sortAndFilter,3000);
        if (!getReusableActionsInstance().isElementVisible(this.btnSortSelect)) {
            return false;
        }

        getReusableActionsInstance().javascriptScrollByVisibleElement(this.sortByOptionList.get(0));

        int listSize = this.sortByOptionList.size();
        if (listSize != lstOptionYml.size()) {
            return false;
        }

        List<String> lstOption = new ArrayList<String>();
        for (int i = 0; i < listSize; i++) {
            getReusableActionsInstance().javascriptScrollByVisibleElement(this.sortByOptionList.get(i));
            lstOption.add(this.sortByOptionList.get(i).getText().trim());
        }

        Set<String> setOption = new HashSet<String>(lstOption);
        Set<String> setOptionYml = new HashSet<String>(lstOptionYml);

        return setOption.containsAll(setOptionYml) && setOptionYml.containsAll(setOption);
    }

    @Override
	public String verifySlectedFiltersContainSecondlevelFilter(List<String> lstFilterIncluded, List<String> lstFilterExcluded) {
		List<String> lstSelectedFilterOption=new ArrayList<String>();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.sortAndFilter);
		getReusableActionsInstance().clickIfAvailable(this.sortAndFilter,3000);
		getReusableActionsInstance().staticWait(1000);
		int selectedFilterSize=this.selectedFiltersListMobile.size();
		for(int i=0;i<selectedFilterSize;i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectedFiltersListMobile.get(i));
			lstSelectedFilterOption.add(this.selectedFiltersListMobile.get(i).getText().trim());
		}
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.cancelButton);
		getReusableActionsInstance().clickIfAvailable(this.cancelButton,3000);
		//this.cancelButton.click();

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
}