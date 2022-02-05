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

    @FindBy(xpath="//div[contains(@class,'secondary-navigation__rhs-account')]//a[contains(@role,'button') and contains(@class,'sign')]")
    public WebElement btnSignOutButton;

    @Override
    public boolean SignOut() {
        getReusableActionsInstance().javascriptScrollByVisibleElement(btnSignInMainMenu);
        getReusableActionsInstance().scrollToElement(btnSignInMainMenu);
        getReusableActionsInstance().clickIfAvailable(this.SigninIcon);
        getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().clickIfAvailable(this.btnSignOutButton);
        waitForPageToLoad();
        return waitForCondition(Driver->{return super.inputUserName.isDisplayed();},90000);
    }

    @Override
    public void verifyMenuItemInPopover(List<String> lstMenuItemPopover) {
        getReusableActionsInstance().javascriptScrollByVisibleElement(btnSignInMainMenu);
        getReusableActionsInstance().scrollToElement(btnSignInMainMenu);
        getReusableActionsInstance().clickIfAvailable(this.SigninIcon);
        getReusableActionsInstance().staticWait(2000);
        //getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntSignInPopover);
        //this.hoverOnSignInHeadingMenu();
        WebElement element;
        for(String lsItem:lstMenuItemPopover) {
            element=this.getMenuItemInPopover(lsItem);
            reporter.softAssert(element.getText().trim().equalsIgnoreCase(lsItem),"'"+lsItem+"' in SignIn popver is existing","'"+lsItem+"' in SignIn popver is not existing");
            reporter.softAssert(!element.getAttribute("href").isEmpty(),"The href of '"+lsItem+"' in SignIn popver is not empty","The href of '"+lsItem+"' in SignIn popver is empty");
        }
    }

   /* @Override
    public void verifySignInSection() {
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.SigninIcon);
        this.SigninIcon.click();
        getReusableActionsInstance().staticWait(2000);
        //getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntSignInPopover);
        super.verifySignInSection();
        *//*getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInNav);
        this.btnSignInNav.click();
        (new GlobalFooterPage(this.getDriver())).waitForPageLoading();
        reporter.softAssert(getReusableActionsInstance().isElementVisible(this.inputUserName),"Input field is existing","Input field is not existing");
        reporter.softAssert(getReusableActionsInstance().isElementVisible(this.inputPassword),"Password field is existing","Password field is not existing");*//*
    }*/

//    @Override
//    public boolean Login(String lsUserName, String lsPassword,String lsFirstName) {
//        getReusableActionsInstance().javascriptScrollByVisibleElement(this.SigninIcon);
//        this.SigninIcon.click();
//        getReusableActionsInstance().staticWait(2000);
//        getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
//        getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
//        getReusableActionsInstance().clickIfAvailable(this.btnSignInMainMenu);
//        getReusableActionsInstance().staticWait(300);
//        getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInNav);
//        this.btnSignInNav.click();
//        (new GlobalFooterPage(this.getDriver())).waitForPageLoading();
//        getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
//        this.inputUserName.sendKeys(lsUserName);
//        getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
//        this.inputPassword.sendKeys(lsPassword);
//
//        String lsSignInMsg=this.btnSignInMainMenu.getText();
//        getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
//        this.btnSubmit.click();
//
//        return waitForCondition(Driver->{return lblSignInGlobalResponseBanner.isDisplayed();},90000);
//        //return super.Login(String lsUserName, String lsPassword);
//    }
}
