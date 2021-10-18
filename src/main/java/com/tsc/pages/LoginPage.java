package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tsc.pages.base.BasePage;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Sign in menu
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//a")
	public WebElement btnSignInMainMenu;
	
	//DropDown menu
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[contains(@href,'signin')]")
	public WebElement btnSignInNav;
	
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[contains(@href,'createphoneaccount')]")
	public WebElement btnTransferaPhoneAccountNav;
	
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[contains(@href,'orderstatus')]")
	public WebElement btnTrackYourOderNav;
	
	//Sign in window
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[1]//h1")
	public WebElement lblSignIn;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[1]//input[@id='username']")
	public WebElement inputUserName;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[1]//input[@id='username']/parent::div[contains(@class,'form-group')]/following-sibling::div[contains(@class,'text-danger')]")
	public WebElement lblInvalidEmailMsg;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[1]//input[@id='password']")
	public WebElement inputPassword;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[1]//button[@id='pwdShowButton']")
	public WebElement btnShowOrHidePassword;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[1]//input[@id='keep-signed-in']")
	public WebElement ckbKeepMeSignedIn;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[1]//input[@id='keep-signed-in']/parent::div/following-sibling::span")
	public WebElement lblKeepMeSignedInLabel;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[1]//a[@id='btn-learn-more']")
	public WebElement lnkLearnMore;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[1]//button[@type='submit']")
	public WebElement btnSubmit;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[1]//a[contains(@href,'passwordrequest')]")
	public WebElement lnkForgotPassword;
	
	//New customers
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[2]//h1")
	public WebElement lblNewCustomers;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[2]//a[contains(@href,'createaccount')]")
	public WebElement btnCreateNewAccount;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[2]//a[contains(@href,'createphoneaccount')]")
	public WebElement btnTransferMyPhoneAccount;
	
	@FindBy(xpath = "//div[@class='SignIn']//div[contains(@class,'signin-bottomnote') and contains(@class,'hidden-xs')]")
	public WebElement lblPrivacyAndSecurity;
	
	@FindBy(xpath = "//div[@class='SignIn']//div[contains(@class,'signin-bottomnote') and contains(@class,'hidden-xs')]//a[contains(@href,'aboutusprivacy')]")
	public WebElement lnkPrivacyAndSecurity;
	
	//After Sign in
	@FindBy(xpath = "//ng-component//button[contains(@class,'btn-accnt-signout')]")
	public WebElement btnSignOut;
	
	//Dropdown menu after sign in
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[@href='/pages/myaccount']")
	public WebElement btnYourAccountNav;
	
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[contains(@href,'orderstatus')]")
	public WebElement btnYourOrdersNav;
	
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[contains(@href,'easypay')]")
	public WebElement btnEasyPayScheduleNav;
	
	//Will be modified later for href part
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[contains(@href,' ')]")
	public WebElement btnSignOutNav;	
	
	public boolean Login(String lsUserName, String lsPassword) {
		getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		getReusableActionsInstance().staticWait(300);
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
		
		return waitForCondition(Driver->{return lsSignInMsg.equalsIgnoreCase(this.btnSignInMainMenu.getText());},30000);
	}
	
	//Not finished
	public boolean SignOut() {
		getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		getReusableActionsInstance().staticWait(300);
		String lsUserMsg=this.btnSignInMainMenu.getText();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignOutNav);
		this.btnSignOutNav.click();
				
		return waitForCondition(Driver->{return lsUserMsg.equalsIgnoreCase(this.btnSignInMainMenu.getText());},30000);
	}
	
	
}
