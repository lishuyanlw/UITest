package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class GlobalHeaderPage_Mobile extends GlobalHeaderPage {

    public GlobalHeaderPage_Mobile(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section//div[@class='secondary-navigation__rhs']//button[@id='secondary-navigation-mobile-hamburger']")
    public WebElement menuButton;

    @FindBy(xpath="//nav[contains(@class,'nav-items')]/ul")
    public WebElement FlyoutHeadingsMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//ul//li//a|//section//div[contains(@class,'mega-nav-tablet')]//ul//li[contains(@class,'categories')]//a")
    public WebElement FlyoutHeadingsMobileLinks;

    //@FindBy(xpath = "//section//nav[@class='mega-nav-mobile__wrapper']//ul//li//button//span")
    @FindBy(xpath = "//section//nav[@class='mega-nav-mobile__wrapper']//ul")
    public WebElement Categories;

    @FindBy(xpath="//section//nav[contains(@class,'mega-nav-tablet')]//ul")
    public WebElement Categories_Tablet;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//ul//li//a")
    List<WebElement> subHeadinds;

    @FindBy(xpath = "//section//nav[@class='mega-nav-mobile__nav-items']//ul//li//button//span")
    public List<WebElement> headingLinksMobile;

    public String headingLinksMobileStr = "//section//nav[@class='mega-nav-mobile__nav-items']//ul//li";

    String categoriesMobileStr = "//section//nav[@class='mega-nav-mobile__wrapper']//ul//li";

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//ul//li//a[contains(@class,'item__all')]")
    List<WebElement> CategoriesLinksMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//ul//li//a[contains(@class,'item__all')]")
    WebElement CateLinksMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//button//span[contains(@class,'curated-collections')]|//section//div[contains(@class,'tablet')]//button//span[contains(@class,'curated-collections')]")
    WebElement curatedCollectionMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//nav[contains(@class,'curated-collections')]//li//a|//section//div[contains(@class,'tablet__footer')]//*[contains(@class,'curated')]//ul/li/a")
    List<WebElement> listCuratedCollectionLinksMobile;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//button[@class='mega-nav-mobile__popular-brands']|//*//div[contains(@class,'tablet__footer')]//button/span[contains(.,'Brand')]")
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

    @FindBy(xpath = "//a[contains(@class,'mega-nav-mobile__popular-brands__all')]|//div[contains(@class,'tablet__main__lhs')]//ul/li/a[contains(@class,'shop-all')]")
    public WebElement shopAllPopularBrands;

    @FindBy(xpath="//div[contains(@class,'mega-nav')]//button[contains(@class,'close')]")
    public WebElement btnMenuCloseButton;

    //TSC Logo
    @FindBy(xpath = "//div[contains(@class,'secondary-navigation__logo')]/a")
    public WebElement lnkTSClogo;

    @Override
    public String getNameAndclickSubMenuItem(String headingName, String submenuHeading, String itemName) {
        this.menuButton.click();
        getReusableActionsInstance().staticWait(5000);
        String xpathHeading = null;
        if((System.getProperty("Device").toLowerCase().equals("tablet") &&
                (System.getProperty("Browser").toLowerCase().contains("ios"))) ||
                (System.getProperty("Browser").toLowerCase().contains("mobile") &&
                        System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad")))
            xpathHeading = createXPath(".//li//button//*[contains(@class,'mega-nav-tablet') and contains(.,'{0}')]", headingName);
            //xpathHeading = createXPath("//*[contains(@class,'mega-nav-tablet')]//span[contains(.,'{0}')]", headingName);
        else
            //xpathHeading = createXPath("//li[contains(@class,'mobile__nav-items')]//span[contains(.,'{0}')]", headingName);
            xpathHeading = createXPath(".//li//button//*[contains(@class,'mega-nav-mobile') and contains(.,'{0}')]", headingName);
        WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
        getReusableActionsInstance().scrollToElement(headingWebElement);

        if (headingWebElement != null || submenuHeading == null) {
            headingWebElement.click();
            getReusableActionsInstance().staticWait(700);
            //return headingWebElement.getText().trim();
        }
        if (submenuHeading != null) {
            List<WebElement> SubMenu = null;
            String xpathSubMenu = createXPath(".//li[contains(@class,'categories')]//button//span[contains(@class,'categories-item__text') and contains(.,'{0}')]", submenuHeading);
            if((System.getProperty("Device").toLowerCase().equals("tablet") &&
                    (System.getProperty("Browser").toLowerCase().contains("ios"))) ||
                    (System.getProperty("Browser").toLowerCase().contains("mobile") &&
                            System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad")))
                SubMenu = Categories_Tablet.findElements(By.xpath(xpathSubMenu));
            else
                SubMenu = Categories.findElements(By.xpath(xpathSubMenu));
            if (SubMenu.size() > 0) {
                getReusableActionsInstance().scrollToElement(SubMenu.get(0));
                String Title = SubMenu.get(0).getText();
                SubMenu.get(0).click();
                getReusableActionsInstance().staticWait(700);
                if (itemName != null) {
                    String title = null;
                    String xpathSubmenuItem;
                    List<WebElement> SubMenuItem;
                    if((System.getProperty("Device").toLowerCase().equals("tablet") &&
                            (System.getProperty("Browser").toLowerCase().contains("ios"))) ||
                            (System.getProperty("Browser").toLowerCase().contains("mobile") &&
                                    System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad")))
                        xpathSubmenuItem = createXPath(".//li[contains(@class,'categories-item__sub-item')]/a[contains(.,'{0}')]", itemName);
                    else
                        xpathSubmenuItem = createXPath(".//li[contains(@class,'mobile__sub-categories-item__wrapper')]/a[contains(.,'{0}')]", itemName);
                    SubMenuItem = getDriver().findElements(By.xpath(xpathSubmenuItem));
                    if (SubMenuItem.size() > 0) {
                        getReusableActionsInstance().scrollToElement(SubMenuItem.get(0));
                        title = SubMenuItem.get(0).getText().trim();
                        SubMenuItem.get(0).click();
                    } else {
                        SubMenuItem.clear();
                        if((System.getProperty("Device").toLowerCase().equals("tablet") &&
                                (System.getProperty("Browser").toLowerCase().contains("ios"))) ||
                                (System.getProperty("Browser").toLowerCase().contains("mobile") &&
                                        System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad")))
                            xpathSubmenuItem = createXPath(".//li[contains(@class,'categories-item__sub-item')]/a[contains(.,'{0}')]", itemName);
                        else
                            xpathSubmenuItem = createXPath(".//li[contains(@class,'mobile__sub-categories-item__wrapper')]/a[contains(.,'{0}')]", itemName);
                        SubMenuItem = getDriver().findElements(By.xpath(xpathSubmenuItem));
                        getReusableActionsInstance().scrollToElement(SubMenuItem.get(0));
                        title = SubMenuItem.get(0).getText().trim();
                        SubMenuItem.get(0).click();
                    }
                    return title;
                } else {
                    subHeadinds.get(0).click();
                    return Title;
                }
                //Adding else condition to click on first element by default if passed submenu item is not present in list
            } else {
                WebElement element = null;
                if((System.getProperty("Device").toLowerCase().equals("tablet") &&
                        (System.getProperty("Browser").toLowerCase().contains("ios"))) ||
                        (System.getProperty("Browser").toLowerCase().contains("mobile") &&
                                System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad")))
                    element = Categories_Tablet.findElement(By.xpath("./a"));
                else
                    element = Categories.findElement(By.xpath("./a"));
                String title = element.getText().trim();
                element.click();
                return title;
            }
        }
        return null;
    }
    
    @Override
	public void clickCuratedCollectionsMenuItem(String headingName,String submenuHeading) {
    	this.menuButton.click();
        String xpathHeading = null;
    	if(System.getProperty("Device").toLowerCase().equals("mobile"))
    	    xpathHeading =createXPath(".//li[contains(@class,'mobile__nav-items')]//span[contains(.,'{0}')]" ,headingName);
    	else
            xpathHeading =createXPath(".//span[contains(@class,'nav-items') and contains(.,'{0}')]" ,headingName);
		WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
		getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
		getReusableActionsInstance().clickIfAvailable(headingWebElement);
		getReusableActionsInstance().staticWait(3000);
		
		this.getReusableActionsInstance().clickIfAvailable(this.curatedCollectionMobile);
		getReusableActionsInstance().staticWait(3000);
		
		for(WebElement item:listCuratedCollectionLinksMobile) {
			if(this.getElementInnerText(item).equalsIgnoreCase(submenuHeading)) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				this.getReusableActionsInstance().clickIfAvailable(item);
				return;
			}
		}			
	}
	
	@Override
	public void clickPopularBrandsMenuItem(String headingName,int subMenuIndex) {
		this.menuButton.click();
		
		String xpathHeading =createXPath(".//li[contains(@class,'mobile__nav-items')]//span[contains(.,'{0}')]" ,headingName);
		WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
		getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
		getReusableActionsInstance().clickIfAvailable(headingWebElement);
		getReusableActionsInstance().staticWait(3000);
		
		this.getReusableActionsInstance().clickIfAvailable(this.popularBrandsMobile);
		getReusableActionsInstance().staticWait(3000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(listPopularBrandsLinksMobile.get(subMenuIndex));
		this.getReusableActionsInstance().clickIfAvailable(listPopularBrandsLinksMobile.get(subMenuIndex));				
	}

    @Override
    public void verifyFlyoutMenuItems(String heading, String section) {
        //List<WebElement> headingsElements=this.headingLinksMobile;
        this.menuButton.click();
        String[] arrOfStr;
        if (heading == null) {
            int Size = getDriver().findElements(By.xpath(headingLinksMobileStr)).size();
            for (int x = 1; x <= Size - 1; x++) {
                String headingName = getDriver().findElement(By.xpath(headingLinksMobileStr + "[" + x + "]//span")).getText();
                String xpathHeading = createXPath(".//li[contains(@class,'mobile__nav-items')]//span[contains(.,'{0}')]", headingName);
                WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
                getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
                getReusableActionsInstance().scrollToElement(headingWebElement);
                headingWebElement.click();
                //CategoriesMobile.get().click();
                //List<WebElement> CategoriesList=this.CategoriesMobileList;
                int iSize = getDriver().findElements(By.xpath(categoriesMobileStr)).size();
                for (int i = 2; i <= iSize; i++) {
                    String SubmenuName = getDriver().findElement(By.xpath(categoriesMobileStr + "[" + i + "]//span")).getText();
                    if (SubmenuName.contains("'")) {
                        arrOfStr = SubmenuName.split("'");
                        SubmenuName = arrOfStr[0];
                    }
                    String Submenuheading = createXPath(".//li[@class='mega-nav-mobile__categories-item__wrapper']//button//span[contains(.,'{0}')]", SubmenuName);
                    //WebElement SubmenuheadingWebElement = CategoriesMobile.findElement(By.xpath(Submenuheading));
                    WebElement SubmenuheadingWebElement = getDriver().findElement(By.xpath(Submenuheading));
                    getReusableActionsInstance().javascriptScrollByVisibleElement(SubmenuheadingWebElement);
                    getReusableActionsInstance().scrollToElement(SubmenuheadingWebElement);
                    SubmenuheadingWebElement.click();
                    //System.out.println(CateLinksMobile.getAttribute("href"));
                    applyStaticWait(2000);
                    reporter.softAssert(CateLinksMobile.getAttribute("href").contains(headingName.split(" ")[0]), headingName + " href is visible", headingName + " in href is not visible");
                    //waitForCondition(Driver->{return (CateLinksMobile.getAttribute("href").contains(headingName));} ,30000);
                    if (section == null) {
                        verifyFlyoutMenuSection(headingName, "Left Section");
                    }
                }

                reporter.reportLog("Flyout heading " + headingName);
                if (section == null) {
                    verifyFlyoutMenuSection(headingName, "Curated Collections");
                    verifyFlyoutMenuSection(headingName, "Popular Brands");
                } else {
                    verifyFlyoutMenuSection(headingName, section);
                }
            }
        } else {
            WebElement headingsElement = getWebElementFlyoutHeading(heading);
            if (System.getProperty("Browser").toLowerCase().contains("firefox")) {
                getReusableActionsInstance().javascriptScrollByVisibleElement(headingsElement);
            }
            this.scrolltoWebElement(headingsElement);
            headingsElement.click();
            int iSize = getDriver().findElements(By.xpath(categoriesMobileStr)).size();
            for (int i = 2; i <= iSize; i++) {
                String SubmenuName = getDriver().findElement(By.xpath(categoriesMobileStr + "[" + i + "]//span")).getText();
                if (SubmenuName.contains("'")) {
                    arrOfStr = SubmenuName.split("'");
                    SubmenuName = arrOfStr[0];
                }
                String Submenuheading = createXPath(".//li[@class='mega-nav-mobile__categories-item__wrapper']//button//span[contains(.,'{0}')]", SubmenuName);
                WebElement SubmenuheadingWebElement = getDriver().findElement(By.xpath(Submenuheading));
                getReusableActionsInstance().javascriptScrollByVisibleElement(SubmenuheadingWebElement);
                getReusableActionsInstance().scrollToElement(SubmenuheadingWebElement);
                SubmenuheadingWebElement.click();
                applyStaticWait(1000);
                reporter.softAssert(CateLinksMobile.getAttribute("href").contains(heading), heading + " in href is visible", heading + " in href is not visible");
                if (section == null) {
                    verifyFlyoutMenuSection(heading, "Left Section");
                }
            }
            reporter.reportLog("Flyout heading " + heading);
            if (section == null) {
                verifyFlyoutMenuSection(heading, "Curated Collections");
                verifyFlyoutMenuSection(heading, "Popular Brands");
            } else {
                verifyFlyoutMenuSection(heading, section);
            }
        }
    }

    @Override
    public void verifyFlyoutMenuSection(String headingName, String sectionName) {
        switch (sectionName) {
            case "Curated Collections":
                reporter.reportLog("Verifying Curated Collections items for : " + headingName);
                this.curatedCollectionMobile.click();
                for (WebElement webElement : listCuratedCollectionLinksMobile) {
                    if (System.getProperty("Browser").toLowerCase().contains("firefox")) {
                        getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
                    }
                    getReusableActionsInstance().scrollToElement(webElement);
                    if (!verifyElementProperty(webElement, "Link")) {//href is not present
                        getReporter().softAssert(false, "", "Href missing for Curated Collection item: " + webElement.getText());
                    } else {
                        getReporter().reportLog("Href present for Curated Collection item: " + webElement.getText());
                    }
                }
                break;
            case "Popular Brands":
                reporter.reportLog("Verifying Popular Brands items for : " + headingName);
                if (System.getProperty("Browser").toLowerCase().contains("firefox")) {
                    getReusableActionsInstance().javascriptScrollByVisibleElement(popularBrandsMobile);
                }
                getReusableActionsInstance().scrollToElement(popularBrandsMobile);
                this.popularBrandsMobile.click();
                for (WebElement webElement : listPopularBrandsLinksMobile) {
                    if (System.getProperty("Browser").toLowerCase().contains("firefox")) {
                        getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
                    }
                    getReusableActionsInstance().scrollToElement(webElement);
                    //WebElement hrefAttribute =webElement.findElement(By.xpath("./ancestor::a"));
                    if (!verifyElementProperty(webElement, "Link")) {//href not present
                        getReporter().softAssert(false, "", "Href missing for Popular Brand item: " + webElement.getText());
                    } else {
                        getReporter().reportLog("Href present for Popular Brand item: " + webElement.getText());
                    }
                }
                this.menuBackButton.click();
                break;
            case "Left Section":
                for (WebElement category : CategoriesLinksMobile) {
                    if (System.getProperty("Browser").toLowerCase().contains("firefox")) {
                        getReusableActionsInstance().javascriptScrollByVisibleElement(category);
                    }
                    this.scrolltoWebElement(category);
                    reporter.reportLog("Verifying Left Section for: " + category.getText());
                    this.verifysubMenuhref(subMenuSectionMobile);
                }
                this.menuBackButton.click();
                break;
        }
    }

    @Override
    public void verifysubMenuhref(List<WebElement> webElements) {
        if (isParentElementHasAttribute(webElements, "li")) {
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
                    getReporter().softAssert(false, "", "Link is not present for: " + element.getText());
                } else {
                    getReporter().reportLog("Href present for left side menu item: " + element.getText());
                }
            }
        } else {
            getReporter().reportLog("No sub-menu item present");
        }
    }

    //this method also verifies header href from GH_TC03
    @Override
    public String getUrlAfterclickingFlyoutHeading(String headingName) {
        String currentUrl;
        this.clickOnMenuButton();
        String xpathHeading = createXPath(".//li[contains(@class,'nav-items')]//span[contains(.,'{0}')]", headingName);
        WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
        getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
        getReusableActionsInstance().scrollToElement(headingWebElement);
        headingWebElement.click();
        reporter.softAssert(verifyElementProperty(FlyoutHeadingsMobileLinks, "Link"), "Href is present for Flyout Heading " + headingName, "Href is not preset for " + headingName);
        this.FlyoutHeadingsMobileLinks.click();
        currentUrl = getDriver().getCurrentUrl();
        return currentUrl;
    }

    @Override
    public void hoverOnWatchTSC() {
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnWatchTSCBlackHeader);
        this.getReusableActionsInstance().scrollToElement(this.btnWatchTSCBlackHeader);
        this.getReusableActionsInstance().staticWait(2000);
        //getReusableActionsInstance().clickIfAvailable(this.btnWatchTSCBlackHeader);
        this.clickWebElementUsingJS(this.btnWatchTSCBlackHeader);
        this.getReusableActionsInstance().staticWait(2000);
    }

    @Override
    public String getURLshopAllPupularBrand(String headingName, String section) {
        String currentUrl = null;
        AtomicReference<String> first_flyout_menu_text = new AtomicReference<String>();
        first_flyout_menu_text.set(headingName.split(" ")[0]);

        String xpathHeading = createXPath(".//li[contains(@class,'nav-items')]//span[contains(.,'{0}')]", headingName);
        WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
        getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
        getReusableActionsInstance().scrollToElement(headingWebElement);
        getReusableActionsInstance().clickIfAvailable(headingWebElement);
        waitForCondition(Driver->{return this.popularBrandsMobile.isEnabled();},60000);
        getReusableActionsInstance().clickIfAvailable(this.popularBrandsMobile);
        getReusableActionsInstance().waitForPageLoad();
        if(!(System.getProperty("Device").equalsIgnoreCase("Tablet") &&
                (System.getProperty("Browser").contains("ios") ||
                        System.getProperty("chromeMobileDevice").contains("iPad")))){
            WebElement linkPopularBrand = listPopularBrandsonlyLinks.get(0);
            waitForCondition(Driver -> {
                return (linkPopularBrand.getAttribute("href").contains(first_flyout_menu_text.get()) && linkPopularBrand.getAttribute("class").contains(section.split(" ")[0].trim().toLowerCase()));
            }, 30000);
        }

        if (verifyElementProperty(shopAllPopularBrands, "Link")) {
            getReusableActionsInstance().javascriptScrollByVisibleElement(shopAllPopularBrands);
            getReusableActionsInstance().scrollToElement(shopAllPopularBrands);
            getReusableActionsInstance().clickIfAvailable(shopAllPopularBrands);
            getReusableActionsInstance().waitForPageLoad();
            currentUrl = getDriver().getCurrentUrl();
        }
        return currentUrl;
    }

    @Override
    public List<WebElement> getFlyoutHeadingsWebelement() {
        this.clickOnMenuButton();
        List<WebElement> headingElements = FlyoutHeadingsMobile.findElements(By.xpath(".//li//button//span[contains(@class,'nav-items__item-text')]"));
        return headingElements;
    }

    public void clickOnMenuButton(){
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.menuButton);
        getReusableActionsInstance().clickIfAvailable(this.menuButton);
        getReusableActionsInstance().waitForPageLoad();
    }

    @Override
    public WebElement getWebElementFlyoutHeading(String headingName) {
        getReusableActionsInstance().clickIfAvailable(this.menuButton);
        getReusableActionsInstance().waitForPageLoad();
        String xpathHeading = createXPath(".//li[contains(@class,'mobile__nav-items')]//span[contains(.,'{0}')]", headingName);
        WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
        return headingWebElement;
    }

    @Override
    public void scrollToHeadingElement(String headingName) {
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.menuButton);
        getReusableActionsInstance().clickIfAvailable(this.menuButton);
    }

    @Override
    public boolean validateTSCLogoNavigateToHomePage() {
        String lsHomePage=new BasePage(this.getDriver()).getBaseURL()+"/";
        String currentUrl=getDriver().getCurrentUrl();
        getReusableActionsInstance().isElementVisible(this.lnkTSClogo, 10);
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkTSClogo);
        getReusableActionsInstance().scrollToElement(this.lnkTSClogo);
        this.clickWebElementUsingJS(this.lnkTSClogo);
        waitForCondition(Driver->{return !currentUrl.equalsIgnoreCase(getDriver().getCurrentUrl());},10000);
        return this.getDriver().getCurrentUrl().equalsIgnoreCase(lsHomePage);
    }

}
