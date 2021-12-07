package com.tsc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class GlobalHeaderPage_Mobile extends GlobalHeaderPage {

    public GlobalHeaderPage_Mobile(WebDriver driver) {
        super(driver);
    }

    /*
     * @author Viswas.reddy
     * CER_621 and CER_619
     */

    @FindBy(xpath = "//section//div[@class='secondary-navigation__rhs']//button[@id='secondary-navigation-mobile-hamburger']")
    public WebElement menuButton;

    @FindBy(xpath = "//section//nav[@class='mega-nav-mobile__nav-items']//ul//li//button")
    public WebElement FlyoutHeadingsMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//ul//li//a")
    public WebElement FlyoutHeadingsMobileLinks;

    @FindBy(xpath = "//section//nav[@class='mega-nav-mobile__wrapper']//ul//li//button//span")
    WebElement Categories;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//ul//li//a")
    List<WebElement> subHeadinds;

    @FindBy(xpath = "//section//nav[@class='mega-nav-mobile__nav-items']//ul//li//button//span")
    public List<WebElement> headingLinksMobile;

    public String headingLinksMobileStr = "//section//nav[@class='mega-nav-mobile__nav-items']//ul//li";

    @FindBy(xpath = "//section//nav[@class='mega-nav-mobile__wrapper']//ul//li//span")
    List<WebElement> CategoriesMobileList;

    @FindBy(xpath = "//section//nav[@class='mega-nav-mobile__wrapper']//ul//li")
    WebElement CategoriesMobile;

    String categoriesMobileStr = "//section//nav[@class='mega-nav-mobile__wrapper']//ul//li";

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//ul//li//a[contains(@class,'item__all')]")
    List<WebElement> CategoriesLinksMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//ul//li//a[contains(@class,'item__all')]")
    WebElement CateLinksMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//button//span[contains(@class,'curated-collections')]")
    WebElement curatedCollectionMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//nav[contains(@class,'curated-collections')]//li//a")
    List<WebElement> listCuratedCollectionLinksMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//button[@class='mega-nav-mobile__popular-brands']")
    WebElement popularBrandsMobile;

    @FindBy(xpath = "//a[contains(@class,'mega-nav-mobile__popular-brands__items')]")
    List<WebElement> listPopularBrandsLinksMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//ul")
    List<WebElement> subMenuSectionMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//a")
    List<WebElement> subMenuLinksMobile;

    @FindBy(xpath = "//section//button[@class='mega-nav-mobile__bread-crumb__back-button']")
    public WebElement menuBackButton;

    @FindBy(xpath = "//a[contains(@class,'mega-nav-mobile__popular-brands__items')]")
    public List<WebElement> listPopularBrandsonlyLinks;
    
    @FindBy(xpath = "//a[contains(@class,'mega-nav-mobile__popular-brands__all')]")//a[contains(@class,'mega-nav-mobile__popular-brands__all')]
	public WebElement shopAllPopularBrands;
	
    @Override
    public String getNameAndclickSubMenuItem(String headingName,String submenuHeading, String itemName) {
        this.menuButton.click();
        getReusableActionsInstance().staticWait(700);
        String xpathHeading =createXPath("//li[contains(@class,'mobile__nav-items')]//span[contains(text(),'{0}')]" ,headingName);
        WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
        getReusableActionsInstance().scrollToElement(headingWebElement);

        if(headingWebElement!=null || submenuHeading==null) {
            headingWebElement.click();
            getReusableActionsInstance().staticWait(700);
            //return headingWebElement.getText().trim();
        }
        if(submenuHeading!=null) {
            String xpathSubMenu =createXPath("//span[contains(@class,'mobile__categories-item__text') and contains(text(),'{0}')]" ,submenuHeading);
            List<WebElement> SubMenu = Categories.findElements(By.xpath(xpathSubMenu));
            if(SubMenu.size()>0){
                getReusableActionsInstance().scrollToElement(SubMenu.get(0));
                String Title = SubMenu.get(0).getText();
                SubMenu.get(0).click();
                getReusableActionsInstance().staticWait(700);
                if(itemName!=null) {
                    String title = null;
                    String xpathSubmenuItem;
                    List<WebElement> SubMenuItem;
                    xpathSubmenuItem=createXPath("//li[contains(@class,'mobile__sub-categories-item__wrapper')]/a[contains(text(),'{0}')]",itemName);
                    SubMenuItem=getDriver().findElements(By.xpath(xpathSubmenuItem));
                    if(SubMenuItem.size()>0){
                        getReusableActionsInstance().scrollToElement(SubMenuItem.get(0));
                        title = SubMenuItem.get(0).getText().trim();
                        SubMenuItem.get(0).click();
                    }else{
                        SubMenuItem.clear();
                        xpathSubmenuItem=createXPath("//li[contains(@class,'mobile__sub-categories-item__wrapper')]/a[contains(text(),'{0}')]","Shop");
                        SubMenuItem=getDriver().findElements(By.xpath(xpathSubmenuItem));
                        getReusableActionsInstance().scrollToElement(SubMenuItem.get(0));
                        title = SubMenuItem.get(0).getText().trim();
                        SubMenuItem.get(0).click();
                    }
                    return title;
                }else {
                    subHeadinds.get(0).click();
                    return Title;
                }
                //Adding else condition to click on first element by default if passed submenu item is not present in list
            }else{
                WebElement element = Categories.findElement(By.xpath("./a"));
                String title = element.getText().trim();
                element.click();
                return title;
            }
        }
        return null;
    }

    @Override
    public void verifyFlyoutMenuItems(String heading, String section){
        //List<WebElement> headingsElements=this.headingLinksMobile;
        this.menuButton.click();
        String[] arrOfStr;
        if(heading==null) {
            int Size = getDriver().findElements(By.xpath(headingLinksMobileStr)).size();
            for(int x=1; x<=Size-1; x++) {
                String headingName = getDriver().findElement(By.xpath(headingLinksMobileStr+"["+x+"]//span")).getText();
                String xpathHeading =createXPath("//li[contains(@class,'mobile__nav-items')]//span[contains(text(),'{0}')]" ,headingName);
                WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
                getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
                getReusableActionsInstance().scrollToElement(headingWebElement);
                headingWebElement .click();
                //CategoriesMobile.get().click();
                //List<WebElement> CategoriesList=this.CategoriesMobileList;
                int iSize = getDriver().findElements(By.xpath(categoriesMobileStr)).size();
                for (int i=2; i<=iSize; i++){
                    String SubmenuName = getDriver().findElement(By.xpath(categoriesMobileStr+"["+i+"]//span")).getText();
                    if (SubmenuName.contains("'")){
                        arrOfStr = SubmenuName.split("'");
                        SubmenuName = arrOfStr[0];
                    }
                    String Submenuheading =createXPath("//li[@class='mega-nav-mobile__categories-item__wrapper']//button//span[contains(text(),'{0}')]" ,SubmenuName);
                    //WebElement SubmenuheadingWebElement = CategoriesMobile.findElement(By.xpath(Submenuheading));
                    WebElement SubmenuheadingWebElement = getDriver().findElement(By.xpath(Submenuheading));
                    getReusableActionsInstance().javascriptScrollByVisibleElement(SubmenuheadingWebElement);
                    getReusableActionsInstance().scrollToElement(SubmenuheadingWebElement);
                    SubmenuheadingWebElement.click();
                    //System.out.println(CateLinksMobile.getAttribute("href"));
                    applyStaticWait(2000);
                    reporter.softAssert(CateLinksMobile.getAttribute("href").contains(headingName.split(" ")[0]), headingName+" href is visible", headingName+" in href is not visible");
                    //waitForCondition(Driver->{return (CateLinksMobile.getAttribute("href").contains(headingName));} ,30000);
                    if(section==null) {
                        verifyFlyoutMenuSection(headingName, "Left Section");
                    }
                }
                
                reporter.reportLog("Flyout heading "+headingName);
                if(section==null) {
                    verifyFlyoutMenuSection(headingName,"Curated Collections");
                    verifyFlyoutMenuSection(headingName,"Popular Brands");
                }else{
                    verifyFlyoutMenuSection(headingName,section);
                }
            }
        }else{
            WebElement headingsElement=getWebElementFlyoutHeading(heading);
            if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
                getReusableActionsInstance().javascriptScrollByVisibleElement(headingsElement);
            }
            this.scrolltoWebElement(headingsElement);
            headingsElement.click();
            int iSize = getDriver().findElements(By.xpath(categoriesMobileStr)).size();
            for (int i=2; i<=iSize; i++){
                String SubmenuName = getDriver().findElement(By.xpath(categoriesMobileStr+"["+i+"]//span")).getText();
                if (SubmenuName.contains("'")){
                    arrOfStr = SubmenuName.split("'");
                    SubmenuName = arrOfStr[0];
                }
                String Submenuheading =createXPath("//li[@class='mega-nav-mobile__categories-item__wrapper']//button//span[contains(text(),'{0}')]" ,SubmenuName);
                WebElement SubmenuheadingWebElement = getDriver().findElement(By.xpath(Submenuheading));
                getReusableActionsInstance().javascriptScrollByVisibleElement(SubmenuheadingWebElement);
                getReusableActionsInstance().scrollToElement(SubmenuheadingWebElement);
                SubmenuheadingWebElement.click();
                applyStaticWait(1000);
                reporter.softAssert(CateLinksMobile.getAttribute("href").contains(heading), heading+" in href is visible", heading+" in href is not visible");
                if(section==null) {
                    verifyFlyoutMenuSection(heading, "Left Section");
                }
            }
            reporter.reportLog("Flyout heading "+heading);
            if(section==null) {
                verifyFlyoutMenuSection(heading,"Curated Collections");
                verifyFlyoutMenuSection(heading,"Popular Brands");
            }else{
                verifyFlyoutMenuSection(heading,section);
            }
        }
    }

    @Override
    public void verifyFlyoutMenuSection(String headingName,String sectionName){
        switch(sectionName){
            case "Curated Collections":
                reporter.reportLog("Verifying Curated Collections items for : "+headingName);
                this.curatedCollectionMobile.click();
                for(WebElement webElement:listCuratedCollectionLinksMobile){
                    if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
                        getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
                    }
                    getReusableActionsInstance().scrollToElement(webElement);
                    if(!verifyElementProperty(webElement,"Link")) {//href is not present
                        getReporter().softAssert(false,"","Href missing for Curated Collection item: "+webElement.getText());
                    }else{
                        getReporter().reportLog("Href present for Curated Collection item: "+webElement.getText());
                    }
                }
                break;
            case "Popular Brands":
                reporter.reportLog("Verifying Popular Brands items for : "+headingName);
                if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
                    getReusableActionsInstance().javascriptScrollByVisibleElement(popularBrandsMobile);
                }
                getReusableActionsInstance().scrollToElement(popularBrandsMobile);
                this.popularBrandsMobile.click();
                for(WebElement webElement:listPopularBrandsLinksMobile){
                    if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
                        getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
                    }
                    getReusableActionsInstance().scrollToElement(webElement);
                    //WebElement hrefAttribute =webElement.findElement(By.xpath("./ancestor::a"));
                    if(!verifyElementProperty(webElement,"Link")) {//href not present
                        getReporter().softAssert(false,"","Href missing for Popular Brand item: "+webElement.getText());
                    }else{
                        getReporter().reportLog("Href present for Popular Brand item: "+webElement.getText());
                    }
                }
                this.menuBackButton.click();
                break;
            case "Left Section":
               for (WebElement category:CategoriesLinksMobile) {
                    if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
                        getReusableActionsInstance().javascriptScrollByVisibleElement(category);
                    }
                    this.scrolltoWebElement(category);
                    reporter.reportLog("Verifying Left Section for: "+category.getText());
                    this.verifysubMenuhref(subMenuSectionMobile);
                }
                this.menuBackButton.click();
                break;
        }
    }

    @Override
    public void verifysubMenuhref(List<WebElement> webElements) {
        if(isParentElementHasAttribute(webElements,"li")) {
            for (WebElement element : this.subMenuLinksMobile) {
                /** Below section needs to be commented as it navigates back to previous element of left
                 * side section element and hence results in StaleElement Exception for firefox
                 if (System.getProperty("Browser").toLowerCase().contains("firefox")) {
                 getReusableActionsInstance().javascriptScrollByVisibleElement(element);
                 }*/
                if (System.getProperty("Browser").toLowerCase().contains("chrome")) {
                    getReusableActionsInstance().scrollToElement(element);
                }
                if (!verifyElementProperty(element, "Link")) {//href is not present
                    getReporter().softAssert(false,"","Link is not present for: "+element.getText());
                }else{
                    getReporter().reportLog("Href present for left side menu item: "+element.getText());
                }
            }
        }else{
            getReporter().reportLog("No sub-menu item present");
        }
    }

    //this method also verifies header href from GH_TC03
    @Override
    public String getUrlAfterclickingFlyoutHeading(String headingName) {
        String currentUrl;

        String xpathHeading =createXPath("//li[contains(@class,'mobile__nav-items')]//span[contains(text(),'{0}')]" ,headingName);
        WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
        getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
        getReusableActionsInstance().scrollToElement(headingWebElement);
        headingWebElement .click();
        reporter.softAssert(verifyElementProperty(FlyoutHeadingsMobileLinks,"Link"),"Href is present for Flyout Heading "+headingName,"Href is not preset for " + headingName);
        this.FlyoutHeadingsMobileLinks.click();
        currentUrl = getDriver().getCurrentUrl();
        return currentUrl;
    }

    @Override
    public void hoverOnWatchTSC() {
    		super.hoverOnWatchTSC();
            this.btnWatchTSCBlackHeader.click();
            this.btnWatchTSCBlackHeader.click();
        //}
    }

    @Override
    public String getURLshopAllPupularBrand(String headingName,String section) {
        String currentUrl=null;
        AtomicReference<String> first_flyout_menu_text =new  AtomicReference<String>();
        first_flyout_menu_text.set(headingName.split(" ")[0]);

        String xpathHeading =createXPath("//li[contains(@class,'mobile__nav-items')]//span[contains(text(),'{0}')]" ,headingName);
        WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
        getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
        getReusableActionsInstance().scrollToElement(headingWebElement);
        headingWebElement .click();
        this.popularBrandsMobile.click();
        WebElement linkPopularBrand = listPopularBrandsonlyLinks.get(0);
        waitForCondition(Driver->{return (linkPopularBrand.getAttribute("href").contains(first_flyout_menu_text.get()) && linkPopularBrand.getAttribute("class").contains(section.split(" ")[0].trim().toLowerCase()));} ,30000);
       
        if(verifyElementProperty(shopAllPopularBrands,"Link")) {
            getReusableActionsInstance().javascriptScrollByVisibleElement(shopAllPopularBrands);
            getReusableActionsInstance().scrollToElement(shopAllPopularBrands);
            shopAllPopularBrands.click();
            currentUrl = getDriver().getCurrentUrl();
        }
        return currentUrl;
    }

    @Override
    public List<WebElement> getFlyoutHeadingsWebelement() {
        this.menuButton.click();
        List<WebElement> headingElements =FlyoutHeadingsMobile.findElements(By.xpath("//span[contains(@class,'mega-nav-mobile__nav-items__item-text')]"));
        return headingElements;
    }

    @Override
    public WebElement getWebElementFlyoutHeading(String headingName) {
        this.menuButton.click();
        String xpathHeading =createXPath("//li[contains(@class,'mobile__nav-items')]//span[contains(text(),'{0}')]" ,headingName);
        WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
        return headingWebElement;
    }
    
    
}
