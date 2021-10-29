package com.tsc.pages;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav")
	public WebElement cntSignInPopover;
		
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
		
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[contains(@class,'secondary-navigation__rhs-account-panel-link--sign-out')]")
	public WebElement btnSignOutNav;	
	
	
	/**
	 * Method to login
	 * @param String lsUserName: user name
	 * @param String lsPassword: password  
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean Login(String lsUserName, String lsPassword) {
		if(System.getProperty("Browser").toLowerCase().contains("firefox")) {
			getReusableActionsInstance().javascriptScrollToTopOfPage();
		}
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
		
		return waitForCondition(Driver->{return !lsSignInMsg.equalsIgnoreCase(this.btnSignInMainMenu.getText());},30000);
	}
	
	/**
	 * Method to logout	 
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean SignOut() {
		getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		getReusableActionsInstance().staticWait(300);
		String lsUserMsg=this.btnSignInMainMenu.getText();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignOutNav);
		this.btnSignOutNav.click();
				
		return waitForCondition(Driver->{return !lsUserMsg.equalsIgnoreCase(this.btnSignInMainMenu.getText());},30000);
	}
	
	/**
	 * Method to hover on Sign in heading menu	  
	 * @author Wei.Li
	 */
	public void hoverOnSignInHeadingMenu() {
		getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		getReusableActionsInstance().staticWait(300);		
	}
	
	/**
	 * Method to get a menu item in popover
	 * @param String lsItemTitle: menu item text	 
	 * @return WebElement
	 * @author Wei.Li
	 */
	public WebElement getMenuItemInPopover(String lsItemTitle) {
		String lsXpath=this.createXPath(".//a[normalize-space(.)='{0}']",lsItemTitle);
		return this.cntSignInPopover.findElement(By.xpath(lsXpath));		
	}
	
	/**
	 * Method to verify menu item list in popover
	 * @param List<String> lstMenuItemPopover: menu item list	 
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyMenuItemInPopover(List<String> lstMenuItemPopover) {
		this.hoverOnSignInHeadingMenu();
		WebElement element;
		for(String lsItem:lstMenuItemPopover) {			
			element=this.getMenuItemInPopover(lsItem);			
			reporter.softAssert(element.getText().trim().equalsIgnoreCase(lsItem),"'"+lsItem+"' in SignIn popver is existing","'"+lsItem+"' in SignIn popver is not existing");
			reporter.softAssert(!element.getAttribute("href").isEmpty(),"The href of '"+lsItem+"' in SignIn popver is not empty","The href of '"+lsItem+"' in SignIn popver is empty");
		}			
	}
	
	/**
	 * Method to verify Username and Password sections are existing 	 
	 * @return void
	 * @author Wei.Li
	 */
	public void verifySignInSection() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInNav);
		this.btnSignInNav.click();
		(new GlobalFooterPage(this.getDriver())).waitForPageLoading();
		reporter.softAssert(getReusableActionsInstance().isElementVisible(this.inputUserName),"Input field is existing","Input field is not existing");
		reporter.softAssert(getReusableActionsInstance().isElementVisible(this.inputPassword),"Password field is existing","Password field is not existing");
	}
	
	/**
	 * Method to verify user first name is showing in SignIn heading menu
	 * @param String lsUserName: user name 
	 * @param String lsPassword: password 
	 * @param String lsFirstName: user's first name	 
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyShowingUserFirstNameAfterSignin(String lsUserName, String lsPassword,String lsFirstName) {		
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
		this.inputUserName.sendKeys(lsUserName);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
		this.inputPassword.sendKeys(lsPassword);
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
		String lsSignInMsg=this.btnSignInMainMenu.getText();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
		this.btnSubmit.click();
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
		waitForCondition(Driver->{return !lsSignInMsg.equalsIgnoreCase(this.btnSignInMainMenu.getText())&&!this.btnSignInMainMenu.getText().isEmpty();},30000);
		
		reporter.softAssert(this.btnSignInMainMenu.getText().toUpperCase().contains(lsFirstName.toUpperCase()),"The user first name of '"+lsFirstName+"' is displaying in SignIn heading menu","The user first name of '"+lsFirstName+"' is not displaying in SignIn heading menu");
	}
	
}
