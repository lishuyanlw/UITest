package com.tsc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SignInPage_Mobile extends SignInPage{

    public SignInPage_Mobile(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'signin-bottomnote') and contains(@class,'visible-xs')]")
    public WebElement lblConfidence;

    @FindBy(xpath = "//div[contains(@class,'signin-bottomnote') and contains(@class,'visible-xs')]//a[contains(@href,'aboutusprivacy')]")
    public WebElement lnkPrivacyAndSecurity;

    @FindBy(xpath="//div[contains(@class,'summary-logout')]/button|//a/span[contains(@class,'rhs-account-panel-link__text') and contains(text(),'Sign')]")
    public WebElement btnSignOut;

    @Override
    public boolean SignOut() {
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntBlackHeaderContainer);
        //getReusableActionsInstance().staticWait(2000);

        this.clickElement(this.btnSignInMainMenu);
        //getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().clickIfAvailable(this.btnSignOut);
        //getReusableActionsInstance().staticWait(5000);

        return waitForCondition(Driver->{return this.lblSignOut.isDisplayed();},20000);
    }

    @Override
    public void verifyMenuItemInPopover(List<String> lstMenuItemPopover) {
        getReusableActionsInstance().javascriptScrollByVisibleElement(cntBlackHeaderContainer);
        //this.getReusableActionsInstance().staticWait(2000);

        getReusableActionsInstance().scrollToElement(btnSignInMainMenu);
        getReusableActionsInstance().clickIfAvailable(this.SignInIcon);
        //getReusableActionsInstance().staticWait(2000);
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
        this.clickElement(this.btnSignInMainMenu);
        //getReusableActionsInstance().clickIfAvailable(this.SignInIcon);
        //getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInNav);
        this.btnSignInNav.click();
        (new GlobalFooterPage(this.getDriver())).waitForPageLoading();

        return waitForCondition(Driver->{return this.lblSignIn.isDisplayed();},30000);
    }

    //@Override
    public boolean verifySignOutButtonVisibilityOnPage(){
        getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignOut);
        return getReusableActionsInstance().isElementVisible(this.btnSignOut);
    }

}
