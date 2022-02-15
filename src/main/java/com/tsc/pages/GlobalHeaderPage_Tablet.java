package com.tsc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GlobalHeaderPage_Tablet extends GlobalHeaderPage_Mobile{

    public GlobalHeaderPage_Tablet(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//section//nav[contains(@class,'nav-items')]//ul//li[not(contains(.,'Shop'))]")
    List<WebElement> lstMenuItemList;

    @FindBy(xpath="//section//nav[contains(@class,'nav-items')]//ul//li[contains(.,'Shop all')]/a")
    WebElement lblShopAllBrands;

    @FindBy(xpath="//section[@class='container']//nav[contains(@class,'rhs__wrapper')]/ul/li[not(contains(.,'Shop'))]/button")
    List<WebElement> lstsubMenuItemsList;

    @FindBy(xpath="//section[@class='container']//nav[contains(@class,'rhs__wrapper')]/ul/li[contains(.,'Shop all')]/a")
    WebElement lblShopAllSubMenuLink;

    @FindBy(xpath="//section[@class='container']//nav[contains(@class,'rhs__wrapper--reset')]/ul[contains(@class,'sub-items')]")
    List<WebElement> lstsubMenuDropDownList;

    @FindBy(xpath="//section[@class='container']//button[contains(@class,'curated-collections')]")
    WebElement btnCuratedCollection;

    @FindBy(xpath="//section[@class='container']//button[contains(@class,'popular')]")
    WebElement btnPopularBrand;

    @FindBy(xpath="//section[@class='container']//nav[contains(@class,'curated-collections')]/ul/li/a")
    List<WebElement> lstCuratedCollectionList;

    @FindBy(xpath="//section[@class='container']//nav[contains(@class,'popular')]/ul/li/a[not(contains(.,'See'))]")
    List<WebElement> lstPopularBrandsList;

    @FindBy(xpath="//section[@class='container']//nav[contains(@class,'popular')]/ul/li/a[contains(.,'See all')]")
    WebElement lblSeeAllPopularBrand;

    @FindBy(xpath="//section[@class='container']//div[@class='mega-nav-tablet__black-button']/button")
    WebElement btnBackButton;

    @Override
    public void verifyFlyoutMenuItems(String heading, String section) {
        //Clicking on menu item to open flyout
        this.menuButton.click();
        this.waitForPageLoad();

        if(heading == null){
            for(int parentCounter=0;parentCounter<lstMenuItemList.size();parentCounter++){
                this.getReusableActionsInstance().javascriptScrollByVisibleElement(lstMenuItemList.get(parentCounter));
                this.getReusableActionsInstance().scrollToElement(lstMenuItemList.get(parentCounter));
                String headingName = lstMenuItemList.get(parentCounter).findElement(By.xpath(".//button/span")).getText();
                reporter.reportLog("Verifying Tablet sub-menu: "+headingName);
                this.getReusableActionsInstance().clickIfAvailable(lstMenuItemList.get(parentCounter));
                //Verifying ShopAll Link for subMenu
                this.verifyElementProperty(this.lblShopAllSubMenuLink,"Link");
                for(int count=0;count<lstsubMenuItemsList.size();count++){
                    this.getReusableActionsInstance().javascriptScrollByVisibleElement(lstsubMenuItemsList.get(count));
                    this.getReusableActionsInstance().scrollToElement(lstsubMenuItemsList.get(count));
                    String subMenuHeadingName = lstsubMenuItemsList.get(count).findElement((By.xpath("./span"))).getText();
                    reporter.reportLog("Verifying Tablet for sub-menu item: "+subMenuHeadingName);
                    this.getReusableActionsInstance().clickIfAvailable(lstsubMenuItemsList.get(count));
                    for(WebElement subMenuItem: lstsubMenuDropDownList){
                        WebElement subMenuItemName = subMenuItem.findElement((By.xpath(".//li/a")));
                        this.verifyElementProperty(subMenuItemName,"Link");
                    }
                    //Clicking on Back Button
                    this.getReusableActionsInstance().clickIfAvailable(this.btnBackButton);
                    waitForCondition(Driver->{return (this.lblShopAllBrands.isEnabled() && this.lblShopAllBrands.isDisplayed());},5000);
                }
                //Verifying Curated Collections
                verifyCuratedCollection();
                //Verifying Popular Brands
                verifyPopularBrand();
                //Verifying Shop All Brands link
                this.verifyElementProperty(this.lblShopAllBrands,"Link");
            }
        }
    }

    public void verifyCuratedCollection(){
        reporter.reportLog("Verifying Curated Collection Section");
        //Opening Curated Collection Section
        this.getReusableActionsInstance().clickIfAvailable(this.btnCuratedCollection);
        waitForCondition(Driver->{return (this.lstCuratedCollectionList.size()>0);},3000);
        for(WebElement webElement : this.lstCuratedCollectionList){
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
            this.getReusableActionsInstance().scrollToElement(webElement);
            this.verifyElementLink(webElement);
        }
        //Closing Curated Collection Section
        this.getReusableActionsInstance().clickIfAvailable(this.btnCuratedCollection);
    }

    public void verifyPopularBrand(){
        reporter.reportLog("Verifying Popular Brand Section");
        //Opening Popular Brand Section
        this.getReusableActionsInstance().clickIfAvailable(this.btnPopularBrand);
        waitForCondition(Driver->{return (this.lstPopularBrandsList.size()>0);},3000);
        for(WebElement webElement : this.lstPopularBrandsList){
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
            this.getReusableActionsInstance().scrollToElement(webElement);
            this.verifyElementProperty(webElement,"Link");
            //Verifying image of Brand
            WebElement imgElement = webElement.findElement(By.xpath(".//img"));
            boolean imgValue = this.verifyElementProperty(imgElement,"Image");
            if(imgValue)
                reporter.reportLogPass("Brand Name: "+imgElement.getAttribute("alt")+" has image present");
            else
                reporter.reportLogFail("Brand Name: "+imgElement.getAttribute("alt")+" has no image present");
        }
        //Verify See All Link in Popular Brand
        this.verifyElementProperty(this.lblSeeAllPopularBrand,"Link");
        //Closing Popular Brand Section
        this.getReusableActionsInstance().clickIfAvailable(this.btnPopularBrand);
    }

}
