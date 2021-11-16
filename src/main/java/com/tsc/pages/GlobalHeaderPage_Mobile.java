package com.tsc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GlobalHeaderPage_Mobile extends GlobalHeaderPage {

    public GlobalHeaderPage_Mobile(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getNameAndclickSubMenuItem(String headingName,String submenuHeading, String itemName) {
        String xpathHeading =createXPath("//li[contains(@class,'mobile__nav-items')]//span[contains(text(),'{0}')]" ,headingName);
        WebElement headingWebElement = FlyoutHeadings.findElement(By.xpath(xpathHeading));
        getReusableActionsInstance().scrollToElement(headingWebElement);

        if(headingWebElement!=null && submenuHeading==null) {
            headingWebElement.click();
            return headingWebElement.getText().trim();
        }
        if(submenuHeading!=null) {
            String xpathSubMenu =createXPath("//span[contains(@class,'mobile__categories-item__text') and contains(text(),'{0}')]" ,submenuHeading);
            List<WebElement> SubMenu = Categories.findElements(By.xpath(xpathSubMenu));
            if(SubMenu.size()>0){
                getReusableActionsInstance().scrollToElement(SubMenu.get(0));
                SubMenu.get(0).click();
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
                    String title = SubMenu.get(0).getText().trim();
                    SubMenu.get(0).click();
                    return title;
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
