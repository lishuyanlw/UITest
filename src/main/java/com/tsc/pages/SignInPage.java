package com.tsc.pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import com.tsc.pages.base.BasePage;

public class SignInPage extends BasePage {
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[contains(@class,'tsc-container--BH')]")
	public WebElement cntBlackHeaderContainer;

	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//a//*[@class='secondary-navigation__rhs-account-icon']")
	public WebElement SignInIcon;

	//Sign in menu
	@FindBy(xpath = "//div[@class='secondary-navigation__rhs-account']//a")
	public WebElement btnSignInMainMenu;

	//DropDown menu
	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav")
	public WebElement cntSignInPopover;

	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a")
	public List<WebElement> lstSignInDropdownMenu;

	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[contains(@href,'signin')]")
	public WebElement btnSignInNav;

	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//ul//li//a[contains(@href,'createaccount')]")
	public WebElement btnCreateAccountInNav;

	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//ul//li//a[contains(@href,'createphoneaccount')]")
	public WebElement btnTransferPhoneAccountInNav;

	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//ul//li//a[contains(@href,'orderstatus')]")
	public WebElement btnOrderStatusInNav;

	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[@href='/pages/myaccount']")
	public WebElement btnYourProfileNav;

	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[@href='/pages/myaccount/orderstatus']")
	public WebElement btnYourOrdersNav;

	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[@href='/pages/myaccount/easypay']")
	public WebElement btnYourEasyPaySchedule;

	@FindBy(xpath = "//div[contains(@class,'secondary-navigation__rhs-account')]//nav//a[contains(@class,'secondary-navigation__rhs-account-panel-link--sign-out')]")
	public WebElement btnSignOutNav;

	//Sign in window on the left section
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//h1")
	public WebElement lblSignIn;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//input[@id='username']")
	public WebElement inputUserName;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//input[@id='username']/parent::div[contains(@class,'has-labels')]/following-sibling::div[@class='text-danger' and contains(.,'valid email')]")
	public WebElement lblUserNameErrorMessage;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//input[@id='password']")
	public WebElement inputPassword;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//input[@id='password']/parent::div[contains(@class,'has-labels')]/following-sibling::div[@class='text-danger' and contains(.,'Password is required!')]")
	public WebElement lblPasswordErrorMessage;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//input[@id='password']/parent::div[contains(@class,'has-labels')]/following-sibling::div[@class='text-danger' and contains(.,'email and password combination')]")
	public WebElement lblUserNameAndPasswordCombinationErrorMessage;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//button[@id='pwdShowButton']")
	public WebElement btnShowOrHidePassword;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//div[@class='tsc-checkbox']//input")
	public WebElement ckbKeepMeSignedIn;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//div[@class='tsc-checkbox']//span")
	public WebElement lblKeepMeSignedIn;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//a[@id='btn-learn-more']")
	public WebElement lnkLearnMore;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//div[@id='recaptcha']")
	public WebElement imgRecaptcha;
	
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//button[@type='submit']")
	public WebElement btnSubmit;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][1]//a[contains(@href,'passwordrequest')]")
	public WebElement lnkForgotPassword;

	@FindBy(xpath = "//div[contains(@class,'signin-bottomnote') and contains(@class,'hidden-xs')]")
	public WebElement lblConfidence;

	@FindBy(xpath = "//div[contains(@class,'signin-bottomnote') and contains(@class,'hidden-xs')]//a[contains(@href,'aboutusprivacy')]")
	public WebElement lnkPrivacyAndSecurity;

	//For Right section
	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][2]//h1[@class='section-title']")
	public WebElement lblRightSectionTitle;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][2]//*[not(contains(@class,'tagTransfer')) and contains(@class,'btn')]")
	public WebElement btnCreateAccountOrContinueAsGuest;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][2]//div[@class='signin-subtitle-checkoutguest']")
	public WebElement lblCheckoutWithoutCreatingAnAccount;

	@FindBy(xpath = "//ng-component/div[@class='tsc-forms']/div[not(contains(@class,'signin-message'))][2]//a[contains(@class,'tagTransfer')]")
	public WebElement btnTransferMyPhoneAccount;

	@FindBy(xpath = "//div[not(contains(@class,'divider-right'))]/div[@class='two-columns']//*[@class='section-title']/span")
	public WebElement lblSignInRightSideTitle;

	//After Normal Sign in
	@FindBy(xpath = "//ng-component//button[contains(@class,'btn-accnt-signout')]|//ul[contains(@class,'account-panel-content')]/li/a/span[contains(text(),'out')]")
	public WebElement btnSignOut;
	
	@FindBy(xpath = "//div[@class='SuperCartridge']//div[@class='global-responsive-banner']")
	public WebElement lblSignInGlobalResponseBanner;

	@FindBy(xpath = "//ng-component//span[contains(.,'ACCOUNT')]")
	public WebElement lblSignInPageTitle;

	@FindBy(xpath = "//ng-component//span[@class='custNo']/preceding-sibling::span")
	public WebElement lblCustomerNOText;

	@FindBy(xpath = "//ng-component//span[@class='custNo']")
	public WebElement lblCustomerNO;

	@FindBy(xpath = "//ng-component//div[@class='my-account-summary-container']")
	public WebElement cntMyAccountSummary;

	//Checkout page
	@FindBy(xpath = "//div[@id='expressCheckout']//div[@class='header__progressbar']")
	public WebElement cntCheckoutPaymentFlow;

	//SignOut message
	@FindBy(xpath = "//ng-component//div[contains(@class,'signin-message')]")
	public WebElement lblSignOut;

	/**
	 *To get ShowButton Status: true for Show while false for Hide
	 */
	public boolean getShowButtonStatus(){
		return !btnShowOrHidePassword.findElement(By.xpath("./span[normalize-space(.)='Show']")).getAttribute("class").contains("hidden");
	}

	/**
	 *To get input password input status: true for Showing asterisks while false for text directly
	 */
	public boolean getInputPasswordStatus(){
		return inputPassword.getAttribute("type").equalsIgnoreCase("password");
	}

	/**
	 *To get Keep Me Signed In Status: true for checked while false for unchecked
	 */
	public boolean getKeepMeSignedInStatus(){
		return ckbKeepMeSignedIn.isSelected();
	}

	/**
	 * To check if cookies exist
	 */
	public boolean checkCookieExisting(){
		return this.getDriver().manage().getCookies().size()>0;
	}
	
	/**
	 * Method to login
	 * @param-String lsUserName: user name
	 * @param-String lsPassword: password
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean Login(String lsUserName, String lsPassword) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntBlackHeaderContainer);
		getReusableActionsInstance().staticWait(2000);

		this.clickElement(this.btnSignInMainMenu);
		getReusableActionsInstance().staticWait(3000);

		this.btnSignInNav.click();
		(new GlobalFooterPage(this.getDriver())).waitForPageLoading();
		this.waitForCondition(Driver->{return this.lblSignIn.isDisplayed();},300000);
		getReusableActionsInstance().staticWait(3000);

		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
		this.inputUserName.sendKeys(lsUserName);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
		this.inputPassword.sendKeys(lsPassword);

		try{
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
			this.btnSubmit.click();
			waitForCondition(Driver->{return lblSignInGlobalResponseBanner.isDisplayed();},300000);
			this.waitForPageToLoad();
		}
		catch(Exception e){
			try{
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
				this.btnSubmit.click();
				waitForCondition(Driver->{return lblSignInGlobalResponseBanner.isDisplayed();},300000);
				this.waitForPageToLoad();
			}
			catch (Exception ex){
				getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
				this.btnSubmit.click();
				waitForCondition(Driver->{return lblSignInGlobalResponseBanner.isDisplayed();},300000);
				this.waitForPageToLoad();
			}
		}

		return true;
	}

	/**
	 * Go to Your Profile page
	 */
	public void goToYourProfilePage() {
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

		this.btnYourProfileNav.click();
		(new GlobalFooterPage(this.getDriver())).waitForPageLoading();
		MyAccount myAccount=new MyAccount(this.getDriver());
		this.waitForCondition(Driver->{return (new MyAccount(this.getDriver())).lblCustomerNumber.isDisplayed();},300000);
		getReusableActionsInstance().staticWait(3000);
	}

	/**
	 * Go to Your Orders page through header
	 */
	public void goToYourOrdersPageThroughHeader() {
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

		this.btnYourOrdersNav.click();
		(new GlobalFooterPage(this.getDriver())).waitForPageLoading();
		MyAccount myAccount=new MyAccount(this.getDriver());
		this.waitForCondition(Driver->{return (new MyAccount(this.getDriver())).lblCustomerNumber.isDisplayed();},300000);
		getReusableActionsInstance().staticWait(3000);
	}

	/**
	 * Go to SignIn page
	 * @return
	 */
	public boolean goToSignInPage() {
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

		return waitForCondition(Driver->{return this.lblSignIn.isDisplayed();},300000);
	}

	/**
	 * Go to track order page Through Header
	 * @return
	 */
	public boolean goToTrackOrderPageThroughHeader() {
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

		this.getReusableActionsInstance().clickIfAvailable(this.btnOrderStatusInNav);

		return waitForCondition(Driver->{return (new OrderTrackingPage(this.getDriver())).lblTrackOrderPortalTitle.isDisplayed();},300000);
	}

	/**
	 * Go to Create Account page through header
	 * @return
	 */
	public boolean goToCreateAccountPageThroughHeader() {
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

		this.getReusableActionsInstance().clickIfAvailable(this.btnCreateAccountInNav);

		return waitForCondition(Driver->{return (new CreateAccountPage(this.getDriver())).lblHeaderTitle.isDisplayed();},300000);
	}

	/**
	 * To Sign out
	 * @return - boolean
	 */
	public boolean signOut() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		String strBrowser = System.getProperty("Browser").trim();
		if (strBrowser.toLowerCase().contains("android") || strBrowser.toLowerCase().contains("ios")
				|| strBrowser.toLowerCase().contains("mobile")) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
			this.clickElement(this.btnSignInMainMenu);
		} else {
			this.getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		}
		getReusableActionsInstance().staticWait(3000);

		this.getReusableActionsInstance().clickIfAvailable(this.btnSignOutNav);

		return waitForCondition(Driver->{return this.lblSignOut.isDisplayed();},300000);
	}

	/**
	 * Go to Transfer phone Account page through header
	 * @return - boolean
	 */
	public boolean goToTransferPhoneAccountPageThroughHeader() {
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

		this.getReusableActionsInstance().clickIfAvailable(this.btnTransferPhoneAccountInNav);

		return waitForCondition(Driver->{return (new TransferPhoneAccountPage(this.getDriver())).lblHeaderTitle.isDisplayed();},300000);
	}

	/**
	 * Go to Create Account Page through signIn page
	 * @return
	 */
	public boolean goToCreateAccountPageThroughSignInPage() {
		this.goToSignInPage();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCreateAccountOrContinueAsGuest);
		this.getReusableActionsInstance().clickIfAvailable(this.btnCreateAccountOrContinueAsGuest);

		return waitForCondition(Driver->{return (new CreateAccountPage(this.getDriver())).lblHeaderTitle.isDisplayed();},300000);
	}

	/**
	 * Go to Transfer Phone Account Page through signIn page
	 */
	public void goToTransferPhoneAccountPageThroughSignInPage() {
		this.goToSignInPage();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTransferMyPhoneAccount);
		this.getReusableActionsInstance().clickIfAvailable(this.btnTransferMyPhoneAccount);

		try{
			waitForCondition(Driver->{return (new TransferPhoneAccountPage(this.getDriver())).lblHeaderTitle.isDisplayed();},60000);
		}
		catch (Exception ex){
			this.applyStaticWait(8*this.getStaticWaitForApplication());
		}
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
		this.waitForPageToLoad();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
		getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		String lsUserMsg=this.btnSignInMainMenu.getText().trim();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignOut);
		this.getReusableActionsInstance().clickIfAvailable(this.btnSignOut);
		//this.btnSignOutNav.click();

		return waitForCondition(Driver->{return (this.btnSignInMainMenu.isDisplayed() && !lsUserMsg.equalsIgnoreCase(this.btnSignInMainMenu.getText().trim()));},30000);
	}

	/**
	 * Method to hover on Sign in heading menu	  
	 * @author Wei.Li
	 */
	public void hoverOnSignInHeadingMenu() {
		/*
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
		if(System.getProperty("Browser").contains("ios") ||
				(System.getProperty("chromeMobileDevice")!=null
						&& System.getProperty("chromeMobileDevice").contains("iPad"))) {
			this.clickWebElementUsingJS(this.btnSignInMainMenu);
		}else
			getReusableActionsInstance().scrollToElement(this.btnSignInMainMenu);
		getReusableActionsInstance().staticWait(300);
		 */
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntBlackHeaderContainer);
		getReusableActionsInstance().staticWait(2000);

		this.clickElement(this.btnSignInMainMenu);
		getReusableActionsInstance().staticWait(3000);
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
			reporter.softAssert(element.getText().trim().equalsIgnoreCase(lsItem.trim()),"'"+lsItem+"' in SignIn popver is existing","'"+lsItem+"' in SignIn popver is not existing");
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
	public void verifyShowingUserFirstNameAfterSignin(String lsUserName, String lsPassword) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
		this.inputUserName.sendKeys(lsUserName);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
		this.inputPassword.sendKeys(lsPassword);

		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
		String lsSignInMsg=this.btnSignInMainMenu.getText().trim();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
		this.getReusableActionsInstance().clickIfAvailable(this.btnSubmit);
		waitForCondition(Driver->{return lblSignInGlobalResponseBanner.isDisplayed();},300000);

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
		waitForCondition(Driver->{return !lsSignInMsg.trim().equalsIgnoreCase(this.btnSignInMainMenu.getText().trim())&&!this.btnSignInMainMenu.getText().isEmpty();},30000);
		
		reporter.softAssert(!this.btnSignInMainMenu.getText().isEmpty(),"The user name is displaying in SignIn heading menu","The user name is not displaying in SignIn heading menu");
	}

	/**
	 * This function returns customer no for logged user
	 * @return - String - customer no from UI
	 */
	public String getCustomerNumberForLoggedInUser(){
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
		this.waitForCondition(Driver->{return this.lblCustomerNO.isDisplayed();},10000);
		return this.getElementText(this.lblCustomerNO);
	}

	/**
	 * This function verifies that user is signed out successfully
	 * @param - String sign out message on UI
	 */
	public void verifySignOutMessage(String signOutMessage){
		this.waitForCondition(Driver->{return !this.lblSignOut.getText().isEmpty();},10000);
		String actualSignOutMessage = this.getElementText(this.lblSignOut);
		if(actualSignOutMessage.equalsIgnoreCase(signOutMessage))
			reporter.reportLogPass("User is successfully logged out with message as expected: "+actualSignOutMessage);
		else
			reporter.reportLogFailWithScreenshot("User is not logged out with actual message: "+actualSignOutMessage+" whereas expected message was: "+signOutMessage);
	}

	/**
	 * This function verifies right side section on Sign In page
	 * @param - String - sectionTitle i.e. SignIn or Checkout from where we are navigated to Sign In Page
	 * @param - String - createAccountOrGuestAccountButtonText - button text that is being displayed
	 */
	public void verifyRightSideSignInPageSection(String sectionTitle,String createAccountOrGuestAccountButtonText){
		String currentPageURL = null;
		if(this.getElementText(this.lblSignIn).toUpperCase().contains("SIGN"))
			verifyNewCustomerSignInRightSideSection(sectionTitle,createAccountOrGuestAccountButtonText);
	}

	/**
	 * This function verifies New Customer at right side section of page after navigating from sign in page
	 * @param - String - sectionTitle i.e. SignIn or Checkout from where we are navigated to Sign In Page
	 * @param - String - createAccountOrGuestAccountButtonText - button text that is being displayed
	 */
	public void verifyNewCustomerSignInRightSideSection(String sectionTitle,String createAccountOrGuestAccountButtonText){
		String sectionTitleText = this.getElementText(this.lblSignInRightSideTitle);
		if(sectionTitleText.equalsIgnoreCase(sectionTitle))
			reporter.reportLogPass("Sign In Page Right Section title is as expected: "+sectionTitleText);
		else
			reporter.reportLogFailWithScreenshot("Sign In Page Right Section title: "+sectionTitleText+" is not as expected: "+sectionTitle);

		//Create New Account Button
		this.createNewAccountOrGuestAccountButton(createAccountOrGuestAccountButtonText);

		//Transfer My Phone Account Button
		this.verifyCommonSignInRightSideSectionControls();
	}

	/**
	 * This section verifies common buttons on right side section of Sign In Page
	 */
	public void verifyCommonSignInRightSideSectionControls(){
		//Transfer My Phone Account
		String transferPhoneAccountButtonText = this.getElementText(this.btnTransferMyPhoneAccount);
		if(transferPhoneAccountButtonText.trim().equalsIgnoreCase("Transfer my Phone Account") &&
		this.btnTransferMyPhoneAccount.isDisplayed() && this.btnTransferMyPhoneAccount.isEnabled())
			reporter.reportLogPass("Transfer my Phone Account button is displayed as expected");
		else
			reporter.reportLogFailWithScreenshot("Transfer my Phone Account Button is not as expected");
	}

	public void verifySignInTitle(String lsSignInTitle){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSignIn);
		if(this.lblSignIn.getText().trim().equalsIgnoreCase(lsSignInTitle.trim())){
			reporter.reportLogPass("SignIn title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("SignIn title is not displaying correctly");
		}
	}

	public void verifyUserNameAndPassword(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
		if(this.getReusableActionsInstance().isElementVisible(this.inputUserName)){
			reporter.reportLogPass("Input username is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Input username is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
		if(this.getReusableActionsInstance().isElementVisible(this.inputPassword)){
			reporter.reportLogPass("Input password is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Input password is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnShowOrHidePassword);
		if(this.getReusableActionsInstance().isElementVisible(this.btnShowOrHidePassword)){
			reporter.reportLogPass("ShowOrHide button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("ShowOrHide button is not displaying correctly");
		}
	}

	public void verifyErrorMessageForUserNameAndPassword(String lsUserName, String lsPassword, String lsErrorMessageForUserName,String lsErrorMessageForPassword,String lsErrorMessageForCombination,boolean bUserValid){
		boolean bUserEmpty=true,bPasswordEmpty=true;
		if(!lsUserName.isEmpty()){
			bUserEmpty=false;
		}

		if(!lsPassword.isEmpty()){
			bPasswordEmpty=false;
		}

		if(bUserEmpty&&bPasswordEmpty){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
			this.getReusableActionsInstance().clickIfAvailable(this.btnSubmit);
			this.waitForCondition(Driver->{return this.lblUserNameAndPasswordCombinationErrorMessage.isDisplayed();},15000);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblUserNameErrorMessage);
			if(this.lblUserNameErrorMessage.getText().trim().equalsIgnoreCase(lsErrorMessageForUserName.trim())){
				reporter.reportLogPass("Error message for username is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Error message for username is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblPasswordErrorMessage);
			if(this.lblPasswordErrorMessage.getText().trim().equalsIgnoreCase(lsErrorMessageForPassword.trim())){
				reporter.reportLogPass("Error message for password is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Error message for password is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblUserNameAndPasswordCombinationErrorMessage);
			if(this.lblUserNameAndPasswordCombinationErrorMessage.getText().trim().equalsIgnoreCase(lsErrorMessageForCombination.trim())){
				reporter.reportLogPass("Error message for combination is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Error message for combination is not displaying correctly");
			}
		}

		if(!bUserEmpty&&!bUserValid){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
			this.inputUserName.clear();
			this.inputUserName.sendKeys(lsUserName);
			this.getReusableActionsInstance().staticWait(300);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
			this.inputPassword.click();
			this.waitForCondition(Driver->{return this.lblUserNameErrorMessage.isDisplayed();},15000);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblUserNameErrorMessage);
			if(this.lblUserNameErrorMessage.getText().trim().equalsIgnoreCase(lsErrorMessageForUserName.trim())){
				reporter.reportLogPass("Error message for username is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Error message for username is not displaying correctly");
			}
		}

		if(bUserValid&&bPasswordEmpty){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
			this.inputUserName.clear();
			this.inputUserName.sendKeys(lsUserName);
			this.getReusableActionsInstance().staticWait(300);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
			this.getReusableActionsInstance().clickIfAvailable(this.btnSubmit);
			this.waitForCondition(Driver->{return this.lblUserNameAndPasswordCombinationErrorMessage.isDisplayed();},15000);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblPasswordErrorMessage);
			if(this.lblPasswordErrorMessage.getText().trim().equalsIgnoreCase(lsErrorMessageForPassword.trim())){
				reporter.reportLogPass("Error message for password is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Error message for password is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblUserNameAndPasswordCombinationErrorMessage);
			if(this.lblUserNameAndPasswordCombinationErrorMessage.getText().trim().equalsIgnoreCase(lsErrorMessageForCombination.trim())){
				reporter.reportLogPass("Error message for combination is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Error message for combination is not displaying correctly");
			}
		}

		if(bUserValid&&!bPasswordEmpty){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
			this.inputUserName.clear();
			this.inputUserName.sendKeys(lsUserName);
			this.getReusableActionsInstance().staticWait(300);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
			this.inputPassword.clear();
			this.inputPassword.sendKeys(lsPassword);
			this.getReusableActionsInstance().staticWait(300);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
			this.getReusableActionsInstance().clickIfAvailable(this.btnSubmit);
			this.waitForCondition(Driver->{return this.lblUserNameAndPasswordCombinationErrorMessage.isDisplayed();},15000);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblUserNameAndPasswordCombinationErrorMessage);
			if(this.lblUserNameAndPasswordCombinationErrorMessage.getText().trim().equalsIgnoreCase(lsErrorMessageForCombination.trim())){
				reporter.reportLogPass("Error message for combination is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Error message for combination is not displaying correctly");
			}
		}
	}

	public void verifyShowOrHidePasswordFunction(){
		reporter.reportLog("Check the initial status");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnShowOrHidePassword);
		if(getInputPasswordStatus()){
			reporter.reportLogPass("The input type is password");
		}
		else{
			reporter.reportLogFailWithScreenshot("The input type is not password");
		}

		if(getShowButtonStatus()){
			reporter.reportLogPass("The button text is 'show'");
		}
		else{
			reporter.reportLogFailWithScreenshot("The button text is not 'show'");
		}

		reporter.reportLog("Check the status after clicking the button");
		this.getReusableActionsInstance().clickIfAvailable(this.btnShowOrHidePassword);
		this.waitForCondition(Driver->{return !getShowButtonStatus();},5000);
		if(!getInputPasswordStatus()){
			reporter.reportLogPass("The input type is text");
		}
		else{
			reporter.reportLogFailWithScreenshot("The input type is not text");
		}

		if(!getShowButtonStatus()){
			reporter.reportLogPass("The button text is 'hide'");
		}
		else{
			reporter.reportLogFailWithScreenshot("The button text is not 'hide'");
		}
	}

	public void verifyKeepMeSignedInFunction(){
		if(checkCookieExisting()){
			reporter.reportLogPass("Cookie has been found when KeepMeSignedIn checked");
		}
		else{
			reporter.reportLogFailWithScreenshot("No Cookie has been found when KeepMeSignedIn checked");
		}
	}

	public void verifyKeepMeSignedInFunction(String lsButtonText){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
		if(this.btnSubmit.getText().trim().equalsIgnoreCase(lsButtonText.trim())){
			reporter.reportLogPass("The button text is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The button text is not displaying correctly");
		}
	}

	public void verifyOtherFieldsForLeftPart(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkLearnMore);
		if(!this.lnkLearnMore.getAttribute("href").isEmpty()){
			reporter.reportLogPass("Learn more link is not empty");
		}
		else{
			reporter.reportLogFail("Learn more link is empty");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.imgRecaptcha);
		if(this.getReusableActionsInstance().isElementVisible(this.imgRecaptcha)){
			reporter.reportLogPass("The Recaptcha image is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Recaptcha image is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkForgotPassword);
		if(!this.lnkForgotPassword.getAttribute("href").isEmpty()){
			reporter.reportLogPass("Forgot password link is not empty");
		}
		else{
			reporter.reportLogFail("Forgot password link is empty");
		}
	}

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

	public void signInFromCheckout(String lsUserName, String lsPassword) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputUserName);
		this.inputUserName.clear();
		this.inputUserName.sendKeys(lsUserName);
		this.applyStaticWait(1000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputPassword);
		this.inputPassword.clear();
		this.inputPassword.sendKeys(lsPassword);
		this.applyStaticWait(1000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSubmit);
		this.getReusableActionsInstance().clickIfAvailable(this.btnSubmit);
//		this.clickElement(this.btnSubmit);

		this.waitForCondition(Driver -> {
			return this.cntCheckoutPaymentFlow.isDisplayed();
		}, 120000);
	}

	/**
	 * This function verifies text on button displayed on Sign in page after navigating from different screens
	 * @param - String - sectionTitle i.e. SignIn or Checkout from where we are navigated to Sign In Page
	 * @param - String - buttonText that is displayed on screen
	 */
	public void createNewAccountOrGuestAccountButton(String buttonText){
		String appButtonText = this.getElementText(this.btnCreateAccountOrContinueAsGuest);
		if(appButtonText.equalsIgnoreCase(buttonText))
			reporter.reportLogPass("Button Text is as expected: "+appButtonText);
		else
			reporter.reportLogFailWithScreenshot("Button Text displayed: "+appButtonText+" is not as expected: "+buttonText);

		if(buttonText.contains("GUEST")){
			String staticText = this.getElementText(this.lblCheckoutWithoutCreatingAnAccount);
			if(staticText.equalsIgnoreCase("Checkout without creating an account"))
				reporter.reportLogPass("Static Text displayed for Guest Checkout is as expected: "+staticText);
			else
				reporter.reportLogFailWithScreenshot("Static Text displayed: "+staticText+" is not as expected: Checkout without creating an account");
		}
	}

	/**
	 * This function verifies SignOut Button visibility on page
	 */
	public boolean verifySignOutButtonVisibilityOnPage(){
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignOut);
		return getReusableActionsInstance().isElementVisible(this.btnSignOut);
	}

	/**
	 * To goTo Guest Checkout Page
	 * @return - boolean
	 */
	public boolean goToGuestCheckoutPage(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCreateAccountOrContinueAsGuest);
		this.btnCreateAccountOrContinueAsGuest.click();

		GuestCheckoutPage guestCheckoutPage=new GuestCheckoutPage(this.getDriver());
		return this.waitForCondition(Driver->{return guestCheckoutPage.btnCollapseProductList.isDisplayed();},60000);
	}

	/**
	 * To check SignIn Status
	 * @return - boolean
	 */
	public boolean checkSignInStatus() {
		String lsText;
		boolean bSignIn=false;
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		String strBrowser = System.getProperty("Browser").trim();
		if (strBrowser.toLowerCase().contains("android") || strBrowser.toLowerCase().contains("ios")
				|| strBrowser.toLowerCase().contains("mobile")) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignInMainMenu);
			this.clickElement(this.btnSignInMainMenu);

			getReusableActionsInstance().staticWait(3000);
			lsText=this.getElementInnerText(lstSignInDropdownMenu.get(0));
			if(lsText.equalsIgnoreCase("Sign In")){
				bSignIn=false;
			}
			else{
				bSignIn=true;
			}
			this.btnSignInMainMenu.click();
			getReusableActionsInstance().staticWait(3000);
		} else {
			lsText=this.getElementInnerText(this.btnSignInMainMenu);
			if(lsText.equalsIgnoreCase("Sign in")){
				bSignIn=false;
			}
			else{
				bSignIn=true;
			}
		}
		return bSignIn;
	}

	/**
	 * To go To Forgot Password Page
	 * @param - String - lsExpectedUrlFromYml
	 * @return - boolean
	 */
	public boolean goToForgotPasswordPage(String lsExpectedUrlFromYml){
		String lsUrlBeforeClicking=this.URL();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkForgotPassword);
		this.lnkForgotPassword.click();

		if(lsExpectedUrlFromYml!=null){
			this.waitForCondition(Driver->{return !this.URL().equalsIgnoreCase(lsUrlBeforeClicking);},20000);
			String lsExpectedUrl=this.getBaseURL()+lsExpectedUrlFromYml;
			String lsUrlAfterClicking=this.URL();
			if(lsUrlAfterClicking.equalsIgnoreCase(lsExpectedUrl)){
				reporter.reportLogPass("The navigated URL:'"+lsUrlAfterClicking+" ' is the same as expected:'"+lsExpectedUrl+"'");
			}
			else{
				reporter.reportLogFail("The navigated URL:'"+lsUrlAfterClicking+" ' is not the same as expected:'"+lsExpectedUrl+"'");
			}
		}
		ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage(this.getDriver());
		return this.waitForCondition(Driver->{return forgotPasswordPage.lblResetPasswordHeaderTitle.isDisplayed();},120000);
	}

}
