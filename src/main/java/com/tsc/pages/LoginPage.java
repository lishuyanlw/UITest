package com.tsc.pages;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import com.tsc.pages.base.BasePage;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Sign in menu
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//a[@href='/pages/myaccount']")
	public WebElement btnSignInMainMenu;
	
	//DropDown menu
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[contains(@href,'signin')]")
	public WebElement btnSignInNav;
	
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav")
	public WebElement cntSignInPopover;
		
	//Sign in window
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//h1")
	public WebElement lblSignIn;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//input[@id='username']")
	public WebElement inputUserName;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//input[@id='password']")
	public WebElement inputPassword;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//button[@type='submit']")
	public WebElement btnSubmit;
	
	//After Sign in
	@FindBy(xpath = "//ng-component//button[contains(@class,'btn-accnt-signout')]|//ul[contains(@class,'account-panel-content')]/li/a/span[contains(text(),'out')]")
	public WebElement btnSignOut;
	
	@FindBy(xpath = "//div[@class='SuperCartridge']//div[@class='global-responsive-banner']")
	public WebElement lblSignInGlobalResponseBanner;

	@FindBy(xpath = "//ng-component//div[@class='clearfix']//*/span[contains(.,'ACCOUNT')]")
	public WebElement lblSignInPageTitle;
	
	/**
	 * Method to login
	 * @param-String lsUserName: user name
	 * @param-String lsPassword: password
	 * @param-String lsFirstName: user's first name
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean Login(String lsUserName, String lsPassword,String lsFirstName) {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		String strBrowser = System.getProperty("Browser").trim();
		if (strBrowser.toLowerCase().contains("android") || strBrowser.toLowerCase().contains("ios")
				|| strBrowser.toLowerCase().contains("mobile")) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
			this.getReusableActionsInstance().clickIfAvailable(this.btnSignInMainMenu);
			//this.btnSignInMainMenu.click();
		} else {
			this.getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		}			
		getReusableActionsInstance().staticWait(3000);
		
		this.getReusableActionsInstance().clickIfAvailable(this.btnSignInNav);
		//this.btnSignInNav.click();
		(new GlobalFooterPage(this.getDriver())).waitForPageLoading();
		waitForCondition(Driver->{return this.inputUserName.isEnabled();},10000);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
		this.inputUserName.sendKeys(lsUserName);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
		this.inputPassword.sendKeys(lsPassword);
		getReusableActionsInstance().staticWait(1000);
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
		this.getReusableActionsInstance().clickIfAvailable(this.btnSubmit);
		//this.btnSubmit.click();
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().staticWait(5000);
		
		return waitForCondition(Driver->{return lblSignInGlobalResponseBanner.isDisplayed();},90000);
				
	}
	
	/**
	 * Method to login only for DeskTop
	 * @param-String lsUserName: user name
	 * @param-String lsPassword: password
	 * @param-String lsFirstName: user's first name
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean LoginForDesktop(String lsUserName, String lsPassword,String lsFirstName) {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
		String strBrowser = System.getProperty("Browser").trim();
		if (strBrowser.toLowerCase().contains("android") || strBrowser.toLowerCase().contains("ios")
				|| strBrowser.toLowerCase().contains("mobile")) {
			this.btnSignInMainMenu.click();
		} else {
			getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		}
		getReusableActionsInstance().staticWait(1000);

		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInNav);
		this.getReusableActionsInstance().clickIfAvailable(this.btnSignInNav);
		//this.btnSignInNav.click();
		(new GlobalFooterPage(this.getDriver())).waitForPageLoading();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
		this.inputUserName.sendKeys(lsUserName);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
		this.inputPassword.sendKeys(lsPassword);
		getReusableActionsInstance().staticWait(1000);

		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
		this.getReusableActionsInstance().clickIfAvailable(this.btnSubmit);
		//this.btnSubmit.click();
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().staticWait(5000);

		return waitForCondition(Driver->{return (new GlobalHeaderPage(this.getDriver())).Signinlnk.getText().toUpperCase().contains(lsFirstName.toUpperCase());},90000);
	}

	/**
	 * Method to login without waiting time, need add explicit wait after call this function
	 * @param-String lsUserName: user name
	 * @param-String lsPassword: password
	 * @return void
	 * @author Wei.Li
	 */
	public void LoginWithoutWaitingTime(String lsUserName, String lsPassword) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
		this.inputUserName.clear();
		this.inputUserName.sendKeys(lsUserName);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
		this.inputPassword.clear();
		this.inputPassword.sendKeys(lsPassword);
		getReusableActionsInstance().staticWait(1000);

		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
		this.getReusableActionsInstance().clickIfAvailable(this.btnSubmit);
		//this.btnSubmit.click();
	}

	/**
	 * Method to logout	 
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean SignOut() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
		getReusableActionsInstance().staticWait(4000);
		getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		getReusableActionsInstance().staticWait(4000);
		String lsUserMsg=this.btnSignInMainMenu.getText();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignOut);
		this.getReusableActionsInstance().clickIfAvailable(this.btnSignOut);
		//this.btnSignOutNav.click();
				
		return waitForCondition(Driver->{return !lsUserMsg.equalsIgnoreCase(this.btnSignInMainMenu.getText());},30000);
	}
	
	
	/**
	 * Method to hover on Sign in heading menu	  
	 * @author Wei.Li
	 */
	public void hoverOnSignInHeadingMenu() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
		getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		getReusableActionsInstance().staticWait(300);
	}
	
	/**
	 * Method to get a menu item in popover
	 * @param-String lsItemTitle: menu item text
	 * @return WebElement
	 * @author Wei.Li
	 */
	public WebElement getMenuItemInPopover(String lsItemTitle) {
		String lsXpath=this.createXPath(".//a[normalize-space(.)='{0}']",lsItemTitle);
		return this.cntSignInPopover.findElement(By.xpath(lsXpath));
	}
	
	/**
	 * Method to verify menu item list in popover
	 * @param-List<String> lstMenuItemPopover: menu item list
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyMenuItemInPopover(List<String> lstMenuItemPopover) {
		/*if (!System.getProperty("Device").equalsIgnoreCase("Desktop")) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.SigninIcon);
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
			javascriptExecutor.executeScript("arguments[0].click;",this.SigninIcon);
			//this.getReusableActionsInstance().clickIfAvailable(this.SigninIcon);
			getReusableActionsInstance().staticWait(2000);
			//getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntSignInPopover);
		}*/
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
		this.getReusableActionsInstance().clickIfAvailable(this.btnSignInNav);
		//this.btnSignInNav.click();
		(new GlobalFooterPage(this.getDriver())).waitForPageLoading();
		reporter.softAssert(getReusableActionsInstance().isElementVisible(this.inputUserName),"Input field is existing","Input field is not existing");
		reporter.softAssert(getReusableActionsInstance().isElementVisible(this.inputPassword),"Password field is existing","Password field is not existing");
	}
	
	/**
	 * Method to verify user first name is showing in SignIn heading menu
	 * @param-String lsUserName: user name
	 * @param-String lsPassword: password
	 * @param-String lsFirstName: user's first name
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
		this.getReusableActionsInstance().clickIfAvailable(this.btnSubmit);
		//this.btnSubmit.click();
		this.waitForPageToLoad();
		if(System.getProperty("Device").equalsIgnoreCase("Mobile")){
			waitForCondition(Driver->{return this.lblSignInPageTitle.isDisplayed();},30000);
			//getReusableActionsInstance().staticWait(2000);
		}
		//Adding static wait here as otherwise next statement throws Stale Element Reference
		// The page is loaded after a sec and hence this wait is required
		getReusableActionsInstance().staticWait(5000);
		if(System.getProperty("Device").equalsIgnoreCase("Desktop"))
			waitForCondition(Driver->{return this.btnSignOut.isDisplayed() && this.btnSignOut.isEnabled();},30000);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
		waitForCondition(Driver->{return !lsSignInMsg.equalsIgnoreCase(this.btnSignInMainMenu.getText())&&!this.btnSignInMainMenu.getText().isEmpty();},30000);
		
		reporter.softAssert(this.btnSignInMainMenu.getText().toUpperCase().contains(lsFirstName.toUpperCase()),"The user first name of '"+lsFirstName+"' is displaying in SignIn heading menu","The user first name of '"+lsFirstName+"' is not displaying in SignIn heading menu");
	}
	
}
