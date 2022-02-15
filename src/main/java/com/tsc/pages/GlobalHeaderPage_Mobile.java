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
import java.util.Map;
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

    @FindBy(xpath="//section//nav[contains(@class,'mega-nav-tablet__main__lhs__primary-nav-items')]//ul")
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

    //@FindBy(xpath = "//a[contains(@class,'mega-nav-mobile__popular-brands__all')]|//div[contains(@class,'tablet__main__lhs')]//ul/li/a[contains(@class,'shop-all')]")
    @FindBy(xpath="//a[contains(@class,'mega-nav-mobile__popular-brands__all')]|//section[@class='container']//nav[contains(@class,'popular')]/ul/li/a[contains(.,'See all')]")
    public WebElement shopAllPopularBrands;

    @FindBy(xpath="//div[contains(@class,'mega-nav')]//button[contains(@class,'close')]")
    public WebElement btnMenuCloseButton;

    //TSC Logo
    @FindBy(xpath = "//div[contains(@class,'secondary-navigation__logo')]/a")
    public WebElement lnkTSClogo;

    @FindBy(xpath="//div[contains(@class,'__heading')]/button")
    public WebElement btnMobileMenuCloseButton;

    @FindBy(xpath="//section//nav[contains(@class,'__watch-tsc')]/ul/li[contains(@class,'showstopper')]/a")
    public WebElement lblTodayShowstopper;

    @FindBy(xpath="//section//nav[contains(@class,'__watch-tsc')]/ul//div[contains(@class,'watch-lhs')]//button")
    public WebElement lblWatchTSCSection;

    /**
     * This method is to close mobile menu
     *
     * @return true/false
     */
    @Override
    public void closeMobileMenu() {
        getReusableActionsInstance().clickIfAvailable(this.btnMobileMenuCloseButton);
        waitForCondition(Driver->{return (this.menuButton.isDisplayed() && this.menuButton.isEnabled());},5000);
    }

    @Override
    public String getNameAndclickSubMenuItem(String headingName, String submenuHeading, String itemName) {
        this.menuButton.click();
        waitForCondition(Driver->{return (this.btnMobileMenuCloseButton.isEnabled() && this.btnMobileMenuCloseButton.isDisplayed());},5000);

        //For first level
        String xpathHeading = null;
        if((System.getProperty("Device").toLowerCase().equals("tablet") &&
                (System.getProperty("Browser").toLowerCase().contains("ios"))) ||
                (System.getProperty("Browser").toLowerCase().contains("mobile") &&
                        System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad"))){
            xpathHeading = createXPath("//li[button[span[contains(@class,'mega-nav-tablet') and contains(.,'{0}')]]]", headingName);
        }
        else{
            xpathHeading = createXPath("//li[button[span[contains(@class,'mega-nav-mobile') and contains(.,'{0}')]]]", headingName);
        }

        WebElement headingWebElement = this.getDriver().findElement(By.xpath(xpathHeading));
        getReusableActionsInstance().scrollToElement(headingWebElement);
        headingWebElement.click();
        getReusableActionsInstance().staticWait(700);

        //For second level
        WebElement SubMenu = null;
        String xpathSubMenu = createXPath("//li[contains(@class,'mega-nav-tablet__main__rhs__categories-item__wrapper') or contains(@class,'mega-nav-mobile__categories-item__wrapper')]//button//span[(contains(@class,'mega-nav-tablet__main__rhs__categories-item__text') or contains(@class,'mega-nav-mobile__categories-item__text')) and contains(.,'{0}')]", submenuHeading);
        System.out.println("xpathSubMenu: "+xpathSubMenu);
        SubMenu = this.getDriver().findElement(By.xpath(xpathSubMenu));
        getReusableActionsInstance().scrollToElement(SubMenu);
        String Title = SubMenu.getText();
        SubMenu.click();
        getReusableActionsInstance().staticWait(700);

        //For third level
        String title = null;
        String xpathSubmenuItem;
        WebElement SubMenuItem=null;
        if((System.getProperty("Device").toLowerCase().equals("tablet") &&
                (System.getProperty("Browser").toLowerCase().contains("ios"))) ||
                (System.getProperty("Browser").toLowerCase().contains("mobile") &&
                        System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad"))){
            xpathSubmenuItem = createXPath("//li[contains(@class,'mega-nav-tablet__main__rhs__categories-item__sub-items__item')]/a[contains(.,'{0}')]", itemName);
        }
        else{
            xpathSubmenuItem = createXPath("//li[contains(@class,'mobile__sub-categories-item__wrapper')]/a[contains(.,'{0}')]", itemName);
        }

        SubMenuItem = getDriver().findElement(By.xpath(xpathSubmenuItem));
        getReusableActionsInstance().scrollToElement(SubMenuItem);
        title = SubMenuItem.getText().trim();
        SubMenuItem.click();

        return title;
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

		this.getReusableActionsInstance().clickIfAvailable(this.curatedCollectionMobile);

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

		this.getReusableActionsInstance().clickIfAvailable(this.popularBrandsMobile);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(listPopularBrandsLinksMobile.get(subMenuIndex));
		this.getReusableActionsInstance().clickIfAvailable(listPopularBrandsLinksMobile.get(subMenuIndex));				
	}

    @Override
    public void verifyFlyoutMenuItems(String heading, String section) {
        this.menuButton.click();
        waitForCondition(Driver->{return (this.btnMobileMenuCloseButton.isDisplayed() && this.btnMobileMenuCloseButton.isEnabled());},5000);
        String[] arrOfStr;
        if (heading == null) {
            int Size = getDriver().findElements(By.xpath(headingLinksMobileStr)).size();
            for (int x = 1; x <= Size - 1; x++) {
                String headingName = getDriver().findElement(By.xpath(headingLinksMobileStr + "[" + x + "]//span")).getText();
                String xpathHeading = createXPath(".//li[contains(@class,'mobile__nav-items')]//span[contains(.,'{0}')]", headingName);
                WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
                getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
                getReusableActionsInstance().scrollToElement(headingWebElement);
                getReusableActionsInstance().clickIfAvailable(headingWebElement,2000);
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
                    getReusableActionsInstance().clickIfAvailable(SubmenuheadingWebElement,2000);
                    reporter.softAssert(CateLinksMobile.getAttribute("href").contains(headingName.split(" ")[0]), headingName + " href is visible", headingName + " in href is not visible");
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
                this.getReusableActionsInstance().clickIfAvailable(SubmenuheadingWebElement);
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
                this.getReusableActionsInstance().clickIfAvailable(this.curatedCollectionMobile,2000);
                waitForCondition(driver->{return (this.listCuratedCollectionLinksMobile.size()>0);},5000);
                for (WebElement webElement : listCuratedCollectionLinksMobile) {
                    getReusableActionsInstance().scrollToElement(webElement);
                    if (!verifyElementProperty(webElement, "Link")) {//href is not present
                        getReporter().softAssert(false, "", "Href missing for Curated Collection item: " + webElement.getText());
                    } else {
                        getReporter().reportLogPass("Href present for Curated Collection item: " + webElement.getText());
                    }
                }
                break;
            case "Popular Brands":
                reporter.reportLog("Verifying Popular Brands items for : " + headingName);
                getReusableActionsInstance().javascriptScrollByVisibleElement(popularBrandsMobile);
                getReusableActionsInstance().scrollToElement(popularBrandsMobile);
                this.getReusableActionsInstance().clickIfAvailable(this.popularBrandsMobile,2000);
                waitForCondition(driver->{return (this.listPopularBrandsLinksMobile.size()>0);},5000);
                for (WebElement webElement : listPopularBrandsLinksMobile) {
                    getReusableActionsInstance().scrollToElement(webElement);
                    //WebElement hrefAttribute =webElement.findElement(By.xpath("./ancestor::a"));
                    if (!verifyElementProperty(webElement, "Link")) {//href not present
                        getReporter().softAssert(false, "", "Href missing for Popular Brand item: " + webElement.getText());
                    } else {
                        getReporter().reportLogPass("Href present for Popular Brand item: " + webElement.getText());
                    }
                }
                this.menuBackButton.click();
                break;
            case "Left Section":
                reporter.reportLog("Verifying Main Menu items for : " + headingName);
                waitForCondition(Driver->{return (this.menuBackButton.isDisplayed() && this.menuBackButton.isEnabled());},5000);
                //for (WebElement category : CategoriesLinksMobile) {
                //    getReusableActionsInstance().javascriptScrollByVisibleElement(category);
                //    this.scrollSubMenuItems(category);
                //    reporter.reportLog("Verifying Left Section for: " + category.getText());
                //    this.verifysubMenuhref(subMenuSectionMobile);
                //}
                this.verifysubMenuhref(subMenuSectionMobile);
                this.getReusableActionsInstance().clickIfAvailable(this.menuBackButton);
                break;
        }
    }

    @Override
    public void verifysubMenuhref(List<WebElement> webElements) {
        //if (isParentElementHasAttribute(webElements, "li")) {
        //Static wait is required here as there in no unique element on screen and
        //page loads after a second. Page Sync issue
        this.getReusableActionsInstance().staticWait(2000);
        for (WebElement element : this.subMenuLinksMobile) {
            getReusableActionsInstance().scrollToElement(element);
            if (!verifyElementProperty(element, "Link")) {//href is not present
                getReporter().softAssert(false, "", "Link is not present for: " + element.getText());
            } else {
                getReporter().reportLogPass("Href present for left side menu item: " + element.getText());
            }
        }
        //} else {
        //    getReporter().reportLog("No sub-menu item present");
        //}
    }

    //this method also verifies header href from GH_TC03
    @Override
    public String getUrlAfterClickingShopAllForCategory(String headingName) {
        String currentUrl;
        this.clickOnMenuButton();
        String xpathHeading = createXPath(".//li[contains(@class,'nav-items')]//span[contains(.,'{0}')]", headingName);
        WebElement headingWebElement = FlyoutHeadingsMobile.findElement(By.xpath(xpathHeading));
        getReusableActionsInstance().javascriptScrollByVisibleElement(headingWebElement);
        getReusableActionsInstance().scrollToElement(headingWebElement);
        getReusableActionsInstance().clickIfAvailable(headingWebElement);
        reporter.softAssert(verifyElementProperty(FlyoutHeadingsMobileLinks, "Link"), "Href is present for Flyout Heading " + headingName, "Href is not preset for " + headingName);
        getReusableActionsInstance().clickIfAvailable(this.FlyoutHeadingsMobileLinks);
        this.getReusableActionsInstance().waitForPageLoad();
        currentUrl = getDriver().getCurrentUrl();
        return currentUrl;
    }

    @Override
    public void hoverOnWatchTSC() {
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnWatchTSCBlackHeader);
        this.getReusableActionsInstance().scrollToElement(this.btnWatchTSCBlackHeader);
        this.clickWebElementUsingJS(this.btnWatchTSCBlackHeader);
        this.waitForPageLoad();
    }

    @Override
    public void validateFlyout() {
       //this.verifyFlyoutMenuItems(null,null);
        if (System.getProperty("Device").equalsIgnoreCase("Tablet") &&
                        (System.getProperty("Browser").contains("ios") || ((System.getProperty("chromeMobileDevice")!=null && System.getProperty("chromeMobileDevice").contains("iPad")))))
            reporter.reportLog("WatchTSC is not present at bottom for iPad");
        else
            this.verifyWatchTSCAtPageBottom();
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

    public void verifyFlyoutMenuItemClickingThenHoverAnotherItemAction(){

    }

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

    @Override
    public void verifyWatchTSCAtPageBottom(){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.menuButton);
        this.getReusableActionsInstance().clickIfAvailable(this.menuButton);
        waitForCondition(Driver->{return (this.btnMobileMenuCloseButton.isEnabled());},5000);

        //Scroll to bottom of page
        this.getReusableActionsInstance().javascriptScrollToBottomOfPage();

        reporter.softAssert(this.lblTodayShowstopper.isDisplayed(),"Today's Showstopper is displayed","Today's ShowStopper is not displayed");
        reporter.softAssert(this.lblWatchTSCSection.isDisplayed(),"Watch TSC is displayed","Watch TSC is not displayed");

        //Verifying Today's Showstopper
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblTodayShowstopper);
        this.getReusableActionsInstance().scrollToElement(this.lblTodayShowstopper);
        String currentURL=this.waitForPageLoadingByUrlChange(this.lblTodayShowstopper);
        waitForCondition(Driver->{return (new ProductResultsPage(this.getDriver()).getProductList().size()>0);},10000);
        if(currentURL.contains("showstopper"))
            reporter.reportLogPass("Page is navigated to Today's Showstopper Page");
        else
            reporter.reportLogFailWithScreenshot("Page is not navigated to Today's showstopper and utl is: "+currentURL);

        //Verification of WatchTSC section
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.menuButton);
        this.getReusableActionsInstance().clickIfAvailable(this.menuButton);
        waitForCondition(Driver->{return (this.btnMobileMenuCloseButton.isDisplayed() && this.btnMobileMenuCloseButton.isEnabled());},5000);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblWatchTSCSection);
        this.getReusableActionsInstance().clickIfAvailable(this.lblWatchTSCSection);
        waitForCondition(Driver->{return (this.subMenuLinksMobile.size()>0);},5000);

        for(WebElement link:subMenuLinksMobile){
            if(verifyElementProperty(link, "Link"))
                reporter.reportLogPass("Href is present for WatchTSC item: "+link.getText());
            else
                reporter.reportLogFailWithScreenshot("Href is not present for WatchTSC item: "+link.getText());
        }
    }

    @Override
    public void switchToEnglish(Map<String,List<String>> headerMap) {
        boolean language = new GlobalFooterPage(this.getDriver()).switchlanguage();
        if(language)
            reporter.reportLogPass("Language is switched as expected back to English");
        else
            reporter.reportLogFailWithScreenshot("Language is not switched back to English from French");
    }

}
