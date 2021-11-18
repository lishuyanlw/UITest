package com.tsc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GlobalHeaderPage_Mobile extends GlobalHeaderPage {

    public GlobalHeaderPage_Mobile(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section//div[@class='secondary-navigation__rhs']//button[@id='secondary-navigation-mobile-hamburger']")
    WebElement menuButton;

    @FindBy(xpath = "//section//nav[@class='mega-nav-mobile__nav-items']//ul//li//button")
    WebElement FlyoutHeadings;

    @FindBy(xpath = "//section//nav[@class='mega-nav-mobile__wrapper']//ul//li//button")
    WebElement Categories;

    @FindBy(xpath = "//section//div[@class='mega-nav-mobile__scroll']//ul//li//a")
    List<WebElement> subHeadinds;

    @Override
    public String getNameAndclickSubMenuItem(String headingName,String submenuHeading, String itemName) {
        this.menuButton.click();
        getReusableActionsInstance().staticWait(700);
        String xpathHeading =createXPath("//li[contains(@class,'mobile__nav-items')]//span[contains(text(),'{0}')]" ,headingName);
        WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
        getReusableActionsInstance().scrollToElement(headingWebElement);

        if(headingWebElement!=null || submenuHeading==null) {
            headingWebElement.click();
            getReusableActionsInstance().staticWait(700);
            //return headingWebElement.getText().trim();
        }
        if(submenuHeading!=null) {
            String xpathSubMenu =createXPath("//span[contains(@class,'mobile__categories-item__text') and contains(text(),'{0}')]" ,submenuHeading);
            List<WebElement> SubMenu = getDriver().findElements(By.xpath(xpathSubMenu));
            if(SubMenu.size()>0){
                getReusableActionsInstance().scrollToElement(SubMenu.get(0));
                String Title = SubMenu.get(0).getText();
                SubMenu.get(0).click();
                getReusableActionsInstance().staticWait(700);
                if(itemName!=null) {
                    String title = null;
                    String xpathSubmenuItem;
                    List<WebElement> SubMenuItem;
                    xpathSubmenuItem=createXPath("//li[contains(@class,'mobile__sub-categories-item__wrapper')]/a/span[contains(text(),'{0}')]",itemName);
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
}
