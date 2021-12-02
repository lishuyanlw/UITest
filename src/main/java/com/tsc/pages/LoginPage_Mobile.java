package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage_Mobile extends LoginPage{

    public LoginPage_Mobile(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//a//*[@class='secondary-navigation__rhs-account-icon']")
    public WebElement SigninIcon;

    @Override
    public void verifyMenuItemInPopover(List<String> lstMenuItemPopover) {
        this.SigninIcon.click();
        getReusableActionsInstance().staticWait(1000);
        super.verifyMenuItemInPopover(lstMenuItemPopover);
    }

}
