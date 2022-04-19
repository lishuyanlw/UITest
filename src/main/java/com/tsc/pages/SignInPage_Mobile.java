package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SignInPage_Mobile extends SignInPage{

    public SignInPage_Mobile(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[contains(@class,'summary-logout')]")
    public WebElement btnSignOutSummary;

    @FindBy(xpath = "//div[contains(@class,'signin-bottomnote') and contains(@class,'visible-xs')]")
    public WebElement lblConfidence;

    @FindBy(xpath = "//div[contains(@class,'signin-bottomnote') and contains(@class,'visible-xs')]//a[contains(@href,'aboutusprivacy')]")
    public WebElement lnkPrivacyAndSecurity;

    @Override
    public boolean SignOut() {
        getReusableActionsInstance().javascriptScrollByVisibleElement(btnSignInMainMenu);
        getReusableActionsInstance().clickIfAvailable(this.btnSignInMainMenu);
        getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().clickIfAvailable(this.btnSignOut);
        waitForPageToLoad();
        return waitForCondition(Driver->{return super.inputUserName.isDisplayed();},90000);
    }

    @Override
    public void verifyMenuItemInPopover(List<String> lstMenuItemPopover) {
        getReusableActionsInstance().javascriptScrollByVisibleElement(btnSignInMainMenu);
        getReusableActionsInstance().scrollToElement(btnSignInMainMenu);
        getReusableActionsInstance().clickIfAvailable(this.SignInIcon);
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

    @Override
    public boolean Login(String lsUserName, String lsPassword,String lsFirstName) {
        getReusableActionsInstance().clickIfAvailable(this.btnSignInMainMenu);
        getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInNav);
        this.btnSignInNav.click();
        (new GlobalFooterPage(this.getDriver())).waitForPageLoading();
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
        this.inputUserName.sendKeys(lsUserName);
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
        this.inputPassword.sendKeys(lsPassword);

        String lsSignInMsg=this.btnSignInMainMenu.getText();
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
        this.btnSubmit.click();

        waitForCondition(Driver->{return this.lblSignInPageTitle.isDisplayed();},30000);
        getReusableActionsInstance().staticWait(2000);

        return waitForCondition(Driver->{return !lsSignInMsg.equalsIgnoreCase(this.btnSignInMainMenu.getText());},30000);
    }

    @Override
    public void verifyConfidence(){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblConfidence);
        if(!this.lblConfidence.getText().isEmpty()){
            reporter.reportLogPass("The confidence text is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The confidence text is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkPrivacyAndSecurity);
        if(!this.lnkPrivacyAndSecurity.getAttribute("href").isEmpty()){
            reporter.reportLogPass("Privacy And Security link is not empty");
        }
        else{
            reporter.reportLogFail("Privacy And Security link is empty");
        }
    }

    @Override
    public boolean goToSignInPage() {
        getReusableActionsInstance().clickIfAvailable(this.btnSignInMainMenu);
        getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInNav);
        this.btnSignInNav.click();

        return waitForCondition(Driver->{return this.lblSignIn.isDisplayed();},30000);
    }

}
