package com.tsc.pages;


import com.tsc.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "//product-results//div[@class='modal-header prpModalHeader hidden-lg']")
    WebElement cancelButton;

    @FindBy(xpath = "//product-results//span[@id='clearAll' and not(contains(@class,'refineName'))]")
    WebElement clearAllFilters;

    @FindBy(xpath = "//product-results//div[@class='modalBody']//div[@class='filterTag']")
    List<WebElement> selectedFiltersList;

    @FindBy(xpath = "//product-results//div[contains(@class,'modalBody')]//form//select//option")
    List<WebElement> sortByOptionList;

    /*@FindBy(xpath = "//span[contains(text(),'Clearance')]/parent::button")
    WebElement clearanceHeaderMobile;*/

    @Override
    public boolean chooseSortOptionByVisibleText(List<String> lsOption) {
        this.sortAndFilter.click();
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSortSelect);
        Select sortOption= new Select(this.btnSortSelect);
        sortOption.selectByVisibleText(lsOption.get(0));

        return waitForCondition(Driver->{return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},60000);
    }

    @Override
    public boolean selectFilterItemInLeftPanel(String lsFirstLevelItem, String lsSecondLevelItem) {
        this.firstLevelFilter = lsFirstLevelItem;
        this.secondLevelFilter = lsSecondLevelItem;

        this.sortAndFilter.click();
        getReusableActionsInstance().staticWait(2000);

        int loopSize = this.productFilterList.size();
        for (int i = 0; i < loopSize; i++) {
            getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
            String lsHeader = this.productFilterList.get(i).getText();
            if (lsHeader.contains("(")) {
                lsHeader = lsHeader.split("\\(")[0].trim();
            }

            //If found lsFirstLevelItem
            if (lsHeader.equalsIgnoreCase(lsFirstLevelItem)) {
                    this.productFilterList.get(i).click();
                    getReusableActionsInstance().staticWait(300);

                List<WebElement> subItemList = this.productFilterContainerList.get(i).findElements(this.bySubItemListOnLeftPanel);
                for (WebElement subItem : subItemList) {
                    getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
                    String lsSubItem = subItem.getText().trim();

                    //If found lsSecondLevelItem
                    if (lsSubItem.equalsIgnoreCase(lsSecondLevelItem)) {
                        subItem.click();
                        return waitForCondition(Driver -> {
                            return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");
                        }, 60000);
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

        return waitForCondition(Driver -> {
            return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");
        }, 60000);

    }

    @Override
    public boolean getClearAllFiltersButtonStatus() {
        this.sortAndFilter.click();
        return this.selectedFiltersList.size()>=1;
    }

    @Override
    public boolean closeAllSelectedFilters() {
        //getReusableActionsInstance().staticWait(5000);
        try {
            //if (sortAndFilter.isDisplayed()) {
                if (sortAndFilter.getText().contains("(")) {
                    this.sortAndFilter.click();
                }
            //}
        }
        //this.waitForCondition(Driver->{return this.cancelButton.isDisplayed();});
        catch (Exception e) {
            if (clearAllFilters.isDisplayed()) {
                this.clearAllFilters.click();
            } else {
                this.cancelButton.click();
            }
        }
        return waitForCondition(Driver->{return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},60000);
    }

    @Override
    public boolean getSearchResultLoad(String searchKeyword) {
        //waitForPageToLoad();
        try{
            //cancelButton.isDisplayed();
            this.cancelButton.click();
        }
        catch(Exception e) {
            GlobalheaderPage globalHeader = new GlobalheaderPage(this.getDriver());
            getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeader.searchBox);
            this.clearContent(globalHeader.searchBox);
            globalHeader.searchBox.sendKeys(searchKeyword);
            //globalHeader.btnSearchSubmit.click();
            (new BasePage(this.getDriver())).pressEnterKey(globalHeader.searchBox);
        }
        return waitForCondition(Driver -> {
            return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");
        }, 90000);
    }


    @Override
    public boolean verifySortOptions(List<String> lstOptionYml) {
        this.sortAndFilter.click();
        if (!getReusableActionsInstance().isElementVisible(this.btnSortSelect)) {
            return false;
        }

        //getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSortBy);
        this.btnSortSelect.click();
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
        this.sortAndFilter.click();
        int selectedFilterSize=this.selectedFiltersList.size()-1;
        for(int i=0;i<selectedFilterSize;i++) {
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
    /*@Override
    public void clickOnClearanceHeaderOption() {
        getReusableActionsInstance().clickIfAvailable(clearanceHeaderMobile);
    }*/
}