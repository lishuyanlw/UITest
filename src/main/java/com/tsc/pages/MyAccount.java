package com.tsc.pages;

import com.tsc.api.util.DataConverter;
import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);
	}

	//Account summary container
	@FindBy(xpath = "//div[@class='my-account-summary-container']")
	public WebElement cntAccountSummaryContainer;

	@FindBy(xpath = "//div[@class='my-account-summary-container']//div[@class='panel']")
	public List<WebElement> lstAccountSummaryPanelList;

	public By bySubList=By.xpath(".//ul//li[not(contains(@class,'hidden'))]//a");

	//For order part
	//For Order status and recent order
	@FindBy(xpath = "//ng-component//p[@class='section-title']")
	public WebElement lblOrderStatusSectionTitle;

	@FindBy(xpath = "//ng-component//input[@id='myAccountOrderSearch']")
	public WebElement inputAccountOrderSearch;

	@FindBy(xpath = "//ng-component//button[contains(normalize-space(.),'Search Orders')]")
	public WebElement btnAccountOrderSearch;

	@FindBy(xpath = "//ng-component//label[@for='select-period']")
	public WebElement lblSelectPeriod;

	@FindBy(xpath = "//ng-component//select[@id='select-period']")
	public WebElement selectPeriodOptions;

	@FindBy(xpath = "//ng-component//div[contains(@class,'order-item-list')]/div/div[contains(@class,'tab-row')]")
	public List<WebElement> lstOrderItemList;

	public By byOrderNoTitle=By.xpath(".//*[@id='tagOrderNo']/preceding-sibling::span[@class='item-title']");
	public By byOrderNo=By.xpath(".//*[@id='tagOrderNo']");
	public By byOrderNoDate=By.xpath(".//*[@id='tagOrderNo']/following-sibling::div");

	public By byOrderTotalTitle=By.xpath(".//*[@id='tagOrderTotal']/preceding-sibling::span[@class='item-title']");
	public By byOrderTotal=By.xpath(".//*[@id='tagOrderTotal']");

	public By byOrderStatusTitle=By.xpath(".//*[@id='tagOrderStatus']/preceding-sibling::span[@class='item-title']");
	public By byOrderStatus=By.xpath(".//*[@id='tagOrderStatus']");

	public By byOrderViewDetails=By.xpath(".//a[contains(@href,'orderstatus')]");

	@FindBy(xpath = "//ng-component//ul[@class='pagination']")
	public WebElement cntOrderStatusPaginationContainer;

	@FindBy(xpath = "//ng-component//ul[@class='pagination']//li[not(@class='previous') and not(@id='nextPage')]")
	public List<WebElement> lstOrderStatusPageList;

	@FindBy(xpath = "//ng-component//ul[@class='pagination']//li[@class='previous')]")
	public WebElement btnOrderStatusPreviousPage;

	@FindBy(xpath = "//ng-component//ul[@class='pagination']//li[@id='nextPage']")
	public WebElement btnOrderStatusNextPage;

	@FindBy(xpath = "//ng-component//ul[@class='pagination']//li[contains(@class,'active')]")
	public WebElement btnOrderStatusCurrentPage;

	//For view details
	@FindBy(xpath = "//ng-component//div[@class='section-title']/ancestor::div[@class='tsc-forms']")
	public WebElement cntOrderDetailsContainer;

	@FindBy(xpath = "//ng-component//div[@class='section-title']")
	public WebElement lblOrderDetailsSectionTitle;

	@FindBy(xpath = "//ng-component//div[@class='section-title']/ancestor::div[@class='tsc-forms']//div[@class='tab-row']")
	public WebElement cntOrderDetailsHeaderSection;

	@FindBy(xpath = "//ng-component//*[@id='tagOrderNo']/preceding-sibling::span[contains(@class,'item-title')]")
	public WebElement lblOrderDetailsHeaderOrderNOTitle;

	@FindBy(xpath = "//ng-component//*[@id='tagOrderNo']")
	public WebElement lblOrderDetailsHeaderOrderNO;

	@FindBy(xpath = "//ng-component//*[@id='tagOrderDate']/preceding-sibling::span[contains(@class,'item-title')]")
	public WebElement lblOrderDetailsHeaderOrderedDateTitle;

	@FindBy(xpath = "//ng-component//*[@id='tagOrderDate']")
	public WebElement lblOrderDetailsHeaderOrderedDate;

	@FindBy(xpath = "//ng-component//*[@id='tagOrderCustomerNo']/preceding-sibling::span[contains(@class,'item-title')]")
	public WebElement lblOrderDetailsHeaderCustomerNOTitle;

	@FindBy(xpath = "//ng-component//*[@id='tagOrderCustomerNo']")
	public WebElement lblOrderDetailsHeaderCustomerNO;

	@FindBy(xpath = "//ng-component//div[contains(@class,'viewInvoice')]//a[contains(@href,'orderinvoice')]")
	public WebElement btnOrderDetailsHeaderViewInvoice;

	@FindBy(xpath = "//ng-component//span[@id='tagOrderMethod']/parent::div/preceding-sibling::div//span[contains(@class,'item-title')]")
	public WebElement lblOrderDetailsHeaderOrderMethodTitle;

	@FindBy(xpath = "//ng-component//span[@id='tagOrderMethod']")
	public WebElement lblOrderDetailsHeaderOrderMethod;

	@FindBy(xpath = "//ng-component//span[@id='tagOrderStatus']/parent::div/preceding-sibling::div//span[contains(@class,'item-title')]")
	public WebElement lblOrderDetailsHeaderOrderStatusTitle;

	@FindBy(xpath = "//ng-component//span[@id='tagOrderStatus']")
	public WebElement lblOrderDetailsHeaderOrderStatus;

	@FindBy(xpath = "//ng-component//span[@id='tagOrderTotal']/parent::div/preceding-sibling::div//span[contains(@class,'item-title')]")
	public WebElement lblOrderDetailsHeaderOrderTotalTitle;

	@FindBy(xpath = "//ng-component//span[@id='tagOrderTotal']")
	public WebElement lblOrderDetailsHeaderOrderTotal;

	@FindBy(xpath = "//ng-component//button[@data-link-title='Track Order']")
	public WebElement btnOrderDetailsHeaderTrackOrder;

	@FindBy(xpath = "//ng-component//button[normalize-space(.)='Edit Order']")
	public WebElement btnOrderDetailsHeaderEditOrder;

	@FindBy(xpath = "//ng-component//div[@class='detailOrderNote']")
	public WebElement lblOrderDetailsHeaderOrderNote;

	@FindBy(xpath = "//ng-component//*[normalize-space(text())='Sub-order:']/ancestor::div[contains(@class,'tab-row')]")
	public WebElement cntOrderDetailsSubHeaderContainer;

	@FindBy(xpath = "//ng-component//*[normalize-space(text())='Sub-order:']")
	public WebElement lblOrderDetailsSubHeaderSubOrderTitle;

	@FindBy(xpath = "//ng-component//*[normalize-space(text())='Sub-order:']/parent::div/following-sibling::div//span")
	public WebElement lblOrderDetailsSubHeaderCustomerNO;

	@FindBy(xpath = "//ng-component//*[normalize-space(text())='Shipping Method:']")
	public WebElement lblOrderDetailsSubHeaderShippingMethodTitle;

	@FindBy(xpath = "//ng-component//*[normalize-space(text())='Shipping Method:']/parent::div/following-sibling::div//span")
	public WebElement lblOrderDetailsSubHeaderShippingMethod;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='Shipping Address:']")
	public WebElement lblOrderDetailsSubHeaderShippingAddressTitle;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='Shipping Address:']/parent::div/following-sibling::div//span")
	public WebElement lblOrderDetailsSubHeaderShippingAddress;

	@FindBy(xpath = "//ng-component//div[contains(@class,'order-items') and not(contains(@class,'sub-order-section'))]")
	public List<WebElement> lstOrderDetailsOrderItemList;

	public By byOrderDetailsOrderItemLink=By.xpath(".//a[contains(@href,'productdetails')][img]");
	public By byOrderDetailsOrderItemImage=By.xpath(".//a[contains(@href,'productdetails')]//img");
	public By byOrderDetailsOrderItemPipeStyleLink=By.xpath(".//a[contains(@href,'productdetails')][not(img)]");
	public By byOrderDetailsOrderItemProductNumber=By.xpath(".//a[contains(@href,'productdetails')][not(img)]/following-sibling::div/span[not(contains(@class,'item-title'))]");
	public By byOrderDetailsOrderItemProductPrice=By.xpath(".//a[contains(@href,'productdetails')][not(img)]/following-sibling::div/span[contains(@class,'item-title')]");
	public By byOrderDetailsOrderItemWriteReview=By.xpath(".//div[contains(@class,'product-review') and contains(@class,'hidden-xs')]//a[contains(@href,'openreview')]");
	public By byOrderDetailsOrderItemQTYTitle=By.xpath(".//span[contains(normalize-space(.),'QTY:')]/parent::div[contains(@class,'hidden-xs')]/span[1]");
	public By byOrderDetailsOrderItemQTY=By.xpath(".//span[contains(normalize-space(.),'QTY:')]/parent::div[contains(@class,'hidden-xs')]/span[2]");
	public By byOrderDetailsOrderItemStatusTitle=By.xpath(".//span[contains(normalize-space(.),'Status:')]/parent::div[contains(@class,'hidden-xs')]/span[1]");
	public By byOrderDetailsOrderItemStatus=By.xpath(".//span[contains(normalize-space(.),'Status:')]/parent::div[contains(@class,'hidden-xs')]/span[2]");

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Billing Address']")
	public WebElement lblOrderDetailsBillingAddressTitle;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Payment Method']/preceding-sibling::div[contains(@class,'order-summary')]")
	public WebElement lblOrderDetailsBillingAddress;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Payment Method']")
	public WebElement lblOrderDetailsPaymentMethodTitle;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Payment Method']/following-sibling::div[contains(@class,'order-summary')]")
	public WebElement lblOrderDetailsPaymentMethod;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Order Summary']")
	public WebElement lblOrderDetailsOrderSummary;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='Subtotal:']")
	public WebElement lblOrderDetailsSubtotalTitle;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='Subtotal:']/following-sibling::span")
	public WebElement lblOrderDetailsSubtotal;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='Shipping & Handling:']")
	public WebElement lblOrderDetailsShippingAndHandlingTitle;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='Shipping & Handling:']/following-sibling::span")
	public WebElement lblOrderDetailsShippingAndHandling;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='Taxes:']")
	public WebElement lblOrderDetailsTaxesTitle;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='Taxes:']/following-sibling::span")
	public WebElement lblOrderDetailsTaxes;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='Order Total :']")
	public WebElement lblOrderDetailsOrderTotalTitle;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='Order Total :']/following-sibling::span")
	public WebElement lblOrderDetailsOrderTotal;

	//For Order cancellation and Order returns
	@FindBy(xpath = "//div[@class='Middle']//*[contains(@class,'titleLink')]")
	public WebElement lblOrderServiceTitle;

	@FindBy(xpath = "//div[@class='Middle']//div[contains(@class,'panTitleContainer')]//a")
	public List<WebElement> lstOrderServiceItemTitleLink;

	@FindBy(xpath = "//div[@class='Middle']//div[contains(@class,'panHTMLContainer')]")
	public List<WebElement> lstOrderServiceItemContent;

	@FindBy(xpath = "//div[@class='Middle']//a[contains(@href,'customerservice')]")
	public WebElement lnkBackToCustomerService;

	//For Account settings
	@FindBy(xpath = "//ng-component//p[contains(@class,'section-title')]")
	public WebElement lblAccountSettingSectionTitle;

	@FindBy(xpath = "//ng-component//div[@id='heading-email']//div[contains(@class,'item-title')]")
	public WebElement lblAccountSettingEmailTitle;

	@FindBy(xpath = "//ng-component//div[@id='heading-email']//div[contains(@class,'subPage')]")
	public WebElement lblAccountSettingEmail;

	@FindBy(xpath = "//ng-component//div[@id='heading-password']//div[contains(@class,'item-title')]")
	public WebElement lblAccountSettingPasswordTitle;

	@FindBy(xpath = "//ng-component//div[@id='heading-password']//div[contains(@class,'subPage')]")
	public WebElement lblAccountSettingPassword;

	@FindBy(xpath = "//ng-component//div[@id='heading-password']//div[contains(@class,'item-edit')]/a")
	public WebElement btnAccountSettingPasswordEdit;

	//For Change password
	@FindBy(xpath = "//ng-component//div[@id='panel-password']//div[@class='section-title']")
	public WebElement lblChangePasswordSectionTitle;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//div[@class='tip']")
	public WebElement lblChangePasswordSectionTipMessage;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//label[normalize-space(text())='Current Password']")
	public WebElement lblChangePasswordSectionCurrentPassword;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//input[@id='currentPassword']")
	public WebElement inputChangePasswordSectionCurrentPassword;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//button[@id='pwdCurrentShowBtn']")
	public WebElement btnChangePasswordSectionCurrentPasswordShowButton;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//label[normalize-space(text())='New Password']")
	public WebElement lblChangePasswordSectionNewPassword;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//input[@id='password']")
	public WebElement inputChangePasswordSectionNewPassword;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//button[@id='pwdShowBtn']")
	public WebElement btnChangePasswordSectionNewPasswordShowButton;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//label[normalize-space(text())='Re-type Password']")
	public WebElement lblChangePasswordSectionReTypePassword;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//input[@id='confirmPassword']")
	public WebElement inputChangePasswordSectionReTypePassword;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//button[@id='pwdConfirmShowBtn']")
	public WebElement btnChangePasswordSectionReTypePasswordShowButton;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//button[@type='submit']")
	public WebElement btnChangePasswordSubmit;

	@FindBy(xpath = "///ng-component//div[@id='panel-password']//a[normalize-space(text())='Cancel']")
	public WebElement btnChangePasswordCancel;
	////////////////////////

	@FindBy(xpath = "//ng-component//div[@id='heading-securityquestion']//div[contains(@class,'item-title')]")
	public WebElement lblAccountSettingSecurityQuestionTitle;

	@FindBy(xpath = "//ng-component//div[@id='heading-securityquestion']//div[contains(@class,'subPage')]")
	public WebElement lblAccountSettingSecurityQuestion;

	@FindBy(xpath = "//ng-component//div[@id='heading-securityquestion']//div[contains(@class,'item-edit')]/a")
	public WebElement btnAccountSettingSecurityQuestionEdit;

	//For change security question
	@FindBy(xpath = "//ng-component//div[@id='panel-securityquestion']//div[@class='section-title']")
	public WebElement lblChangeSecurityQuestionSectionTitle;

	@FindBy(xpath = "//ng-component//div[@id='panel-securityquestion']//div[@class='tip']")
	public WebElement lblChangeSecurityQuestionSectionTipMessage;

	@FindBy(xpath = "//ng-component//div[@id='panel-securityquestion']//label[normalize-space(text())='Question']")
	public WebElement lblChangeSecurityQuestionSectionQuestionTitle;

	@FindBy(xpath = "//ng-component//div[@id='panel-securityquestion']//select")
	public WebElement selectChangeSecurityQuestionSectionQuestion;

	@FindBy(xpath = "//ng-component//div[@id='panel-securityquestion']//label[normalize-space(text())='Answer']")
	public WebElement lblChangeSecurityQuestionSectionAnswerTitle;

	@FindBy(xpath = "//ng-component//div[@id='panel-securityquestion']//input[@name='answer']")
	public WebElement inputChangeSecurityQuestionSectionAnswer;

	@FindBy(xpath = "//ng-component//div[@id='panel-securityquestion']//button[@type='submit']")
	public WebElement btnChangeSecurityQuestionSubmit;

	@FindBy(xpath = "///ng-component//div[@id='panel-securityquestion']//a[normalize-space(text())='Cancel']")
	public WebElement btnChangeSecurityQuestionCancel;
	////////////////////////////////

	//PAYMENT OPTIONS - ADD NEW CREDIT CARD
	@FindBy(xpath="//div[@id='paymentOptionsLinks']//li/a")
	public List<WebElement> lstpaymentOptions;

	@FindBy(xpath="//span[@class='custNo']")
	public WebElement lblCustomerNumber;

	@FindBy(xpath="//div[contains(@class,'editPayPad')]//ul/li/button/img")
	public List<WebElement> lstCardTypesForNewCreditCard;

	@FindBy(xpath="//label//input[@name='isdefault']")
	public WebElement isDefaultCheckBoxForNewCreditCard;

	@FindBy(xpath="//div[contains(@class,'form-group')]/button[contains(@class,'btn-default')]")
	public WebElement btnCancelAddCreditCardForNewCreditCard;

	@FindBy(xpath="//div[contains(@class,'form-group')]/button[contains(@class,'btn-primary')]")
	public WebElement btnSaveAddCreditCardForNewCreditCard;

	@FindBy(xpath="//*[@class='paymentPageTitle']")
	public WebElement lblAddCreditCardPageTitleForNewCreditCard;

	@FindBy(xpath="//input[@id='pan']")
	public WebElement lblCardNumberForNewCreditCard;

	@FindBy(xpath="//input[@id='ficard']")
	public WebElement lblTSCCreditCardInput;

	@FindBy(xpath="//input[@id='maskedPan']")
	public WebElement lblMaskedCardNumberForNewCreditCard;

	@FindBy(xpath="//select[@name='month']")
	public WebElement lblMonthForNewCreditCard;

	@FindBy(xpath="//select[@name='year']")
	public WebElement lblExpirationYearForNewCreditCard;

	@FindBy(xpath="//div[contains(@class,'text-danger')]")
	public WebElement lblErrorMessageForInvalidCreditCardNumber;

	@FindBy(xpath="//button[contains(@class,'signout')]")
	public WebElement btnSignOutMyAccountPage;

	@FindBy(xpath = "//div[@id='semafoneCapturePage']/iframe")
	public WebElement iFrameForNewCreditCard;

	//PAYMENT OPTIONS - MANAGE CREDIT CARD
	@FindBy(xpath="//div[contains(@class,'desktop-divider')]")
	public List<WebElement> lstCreditCardsPresent;
	//.//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')] - Edit Button
	//.//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallLeftPadding')]/a[contains(@class,'negative')] - Remove Button

	@FindBy(xpath="//button[@id='addCardBtn']")
	public WebElement btnAddNewCreditCard;

	@FindBy(xpath="//button[@id='addCardBtn']//div[contains(@class,'addBtnTxt')]")
	public WebElement lblAddNewCreditCardText;

	@FindBy(xpath="//div[@class='modal-body']//div[contains(@class,'clearfix')]/div/button[contains(text(),'REMOVE')]")
	public WebElement btnRemoveCreditCardButton;

	@FindBy(xpath="//div[@class='modal-body']//div[contains(@class,'clearfix')]/div/button/span")
	public WebElement btnCancelRemoveCreditCardButton;

	@FindBy(xpath="//*[@class='breadcrumb']/li/a[contains(text(),'Account')]")
	public WebElement lnkBreadCrumbMyAccount;


	/**
	 * To get subitem web element through sublitem text
	 * @param lsSubItem -  sublitem text
	 * @return subitem web element
	 */
	public WebElement getSubItem(String lsSubItem){
		if(lsSubItem.contains("(")&&lsSubItem.contains(")")){
			lsSubItem=lsSubItem.trim();
			lsSubItem=lsSubItem.substring(0,lsSubItem.indexOf("("));
		}

		String lsBySubItem="//div[@class='my-account-summary-container']//div[@class='panel']//ul//li[not(contains(@class,'hidden'))]//a[contains(normalize-space(.),'"+lsSubItem+"')]";
		return this.getDriver().findElement(By.xpath(lsBySubItem));
	}

	/**
	 * To uncollapse all order service items
	 */
	public void UnCollapsedAllOrderServiceItems(){
		for(WebElement item:this.lstOrderServiceItemTitleLink){
			if(!item.getAttribute("class").isEmpty()){
				item.click();
				this.waitForCondition(Driver->{
					return item.getAttribute("class").isEmpty();},5000);
			}
		}
	}

	/**
	 * To check if a given order service item is uncollapsed
	 * @param - orderServiceItem - WebElement
	 * @return true/false
	 */
	public boolean IsUnCollapsedForGivenOrderServiceItem(WebElement orderServiceItem){
		return orderServiceItem.getAttribute("class").isEmpty();
	}

	/**
	 * To get Service WebElement With Given Service item Name
	 * @param - lsServiceItemName - given Given Service item Name
	 * @return - WebElement
	 */
	public WebElement  getServiceWebElementWithGivenServiceName(String lsServiceItemName) {
		for (WebElement item : this.lstOrderServiceItemTitleLink) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			if (item.getText().toLowerCase().trim().contains(lsServiceItemName.toLowerCase().trim())) {
				return item;
			}
		}
		return null;
	}

	/**
	 * To verify different card types available on application for addition
	 * @param- String - page Title
	 */
	public void verifyNewCardTypesAvailable(String pageTitle){
		//Verifying page title for new Credit Card addition
		waitForCondition(Driver->{return this.lblAddCreditCardPageTitleForNewCreditCard.isDisplayed();},5000);
		String pageTitleOnApp = this.lblAddCreditCardPageTitleForNewCreditCard.getText();
		if(pageTitleOnApp.equalsIgnoreCase(pageTitle))
			reporter.reportLogPass("Page Title for adding New Credit Card is as expected: "+pageTitleOnApp);
		else
			reporter.reportLogFailWithScreenshot("Page Title for adding New Credit Card on application: "+pageTitleOnApp+ " is not same as expected: "+pageTitle);

		//Verifying four Card Types
		List<String> cardTypesOnApp = new ArrayList<>();
		int cardCounter = 0;
		for(WebElement cardType:this.lstCardTypesForNewCreditCard) {
			String cardTypeFetched = cardType.getAttribute("alt");
			cardTypesOnApp.add(cardTypeFetched);
			if(cardTypeFetched.equalsIgnoreCase("visa") ||
				cardTypeFetched.equalsIgnoreCase("master") ||
					cardTypeFetched.equalsIgnoreCase("amex") ||
						cardTypeFetched.equalsIgnoreCase("tsc"))
				cardCounter++;
		}

		if(cardCounter==4)
			reporter.reportLogPass("All four Credit Card Types are present on application to add as expected");
		else
			reporter.reportLogFailWithScreenshot("All expected credit card are not present on application: "+cardTypesOnApp);
	}

	/**
	 * This function clicks on sub-menu item present on My Account Page
	 */
	public void clickOnPaymentOptionSubMenuItemsOnMyAccount(String subMenu){
		this.waitForPageToLoad();
		boolean flag = false;
		for(WebElement webElement:this.lstpaymentOptions){
			if(webElement.getText().contains(subMenu)){
				this.clickElement(webElement);
				flag=true;
				break;
			}
		}
		waitForCondition(Driver->{return this.btnCancelAddCreditCardForNewCreditCard.isEnabled() &&
				this.btnCancelAddCreditCardForNewCreditCard.isDisplayed();},12000);
		if(!flag)
			reporter.reportLogFailWithScreenshot("Provided sub-menu: "+subMenu+" is not present. Please verify once again!");
	}

	/**
	 * This function returns expiration data for new Credit Card
	 * @return - Map<String,String> - Expiration Month and Year Data for Card
	 * @throws ParseException
	 */
	public Map<String,String> getNewCardExpirationData() throws ParseException {
		Map<String,String> cardData = new HashMap<>();
		String[] date = new DataConverter().getLocalDate().split("-");
		int calculatedExpirationMonth = Integer.valueOf(date[1])+2>12 ? (Integer.parseInt(date[1])+2)-12 : Integer.valueOf(date[1])+2;
		String expirationMonth = String.valueOf(calculatedExpirationMonth);
		if(expirationMonth.length()==1)
			expirationMonth = "0"+expirationMonth;
		String expirationYear = String.valueOf(Integer.valueOf(date[0])+3);
		cardData.put("expirationMonth",expirationMonth);
		cardData.put("expirationYear",expirationYear);
		return cardData;
	}

	/**
	 * Adding new Credit Card for User
	 * @param- String - cardType to be added
	 * @param - String - cardNumber to be added
	 * @param - String - expirationMonth for Credit Card
	 * @param - String - expirationYear for Credit Card
	 * @param - boolean - isDefault value for Credit Card attached to user
	 */
	public Map<String,String> addNewValidCreditCardForUser(String cardType, String cardNumber, boolean isDefault) throws ParseException {
		String cardTypeToBeAdded = this.createXPath("//div[contains(@class,'editPayPad')]//ul/li/button/img[contains(@alt,'{0}')]",cardType);
		WebElement cardTypeElement = getDriver().findElement(By.xpath(cardTypeToBeAdded));

		//Calculating expiration Year And Month for Card
		Map<String,String> cardData = this.getNewCardExpirationData();

		waitForCondition(Driver->{return cardTypeElement.isDisplayed() && cardTypeElement.isEnabled();},5000);
		this.clickWebElementUsingJS(cardTypeElement);

		if(!cardType.equalsIgnoreCase("tsc")){
			getDriver().switchTo().frame(iFrameForNewCreditCard);
			waitForCondition(Driver->{return this.lblCardNumberForNewCreditCard.isEnabled() &&
					this.lblCardNumberForNewCreditCard.isDisplayed();},6000);
			//Adding Credit Card Number
			this.clickWebElementUsingJS(this.lblCardNumberForNewCreditCard);
			this.lblCardNumberForNewCreditCard.sendKeys(cardNumber);
			//Using static wait of 5 seconds here as wait for condition is throwing target frame detached error
			getReusableActionsInstance().staticWait(5000);
			//waitForCondition(Driver->{return !this.lblMaskedCardNumberForNewCreditCard.getAttribute("value").isEmpty();},10000);
			getDriver().switchTo().defaultContent();

			//Selecting Expiration Month and Year
			getReusableActionsInstance().selectWhenReady(this.lblMonthForNewCreditCard,cardData.get("expirationMonth"),6000);
			getReusableActionsInstance().selectWhenReady(this.lblExpirationYearForNewCreditCard,cardData.get("expirationYear"),6000);
		}else
			this.lblTSCCreditCardInput.sendKeys(cardNumber);

		//Click on Save Button
		this.clickElement(this.btnSaveAddCreditCardForNewCreditCard);
		return cardData;
	}

	/**
	 * This function converts input expiration data to displayed format on application
	 * @param -String - expirationMonth
	 * @param - String - expirationYear
	 * @return - String
	 */
	public String getExpirationDateDisplayedForCreditCard(String expirationMonth, String expirationYear){
		if(expirationMonth.startsWith("0"))
			expirationMonth = expirationMonth.substring(expirationMonth.length()-1);
		if(expirationYear.length()>2)
			expirationYear = expirationYear.substring(expirationYear.length()-2);
		return expirationMonth + "/" + expirationYear;
	}

	/**
	 * This function verifies newly added Credit Card for user
	 * @param- String - cardType that is added
	 * @param- String - cardNumber that is added
	 * @param- String - expirationMonth of card that is added
	 * @param- String - expirationYear of card that is added
	 * @return - boolean - true/false
	 */
	public void verifyNewAddedCreditCardForUser(String cardType, String cardDisplayName, String cardNumber, String expirationMonth, String expirationYear, boolean removeCard) {
		boolean value = false;
		String inputExpirationData = null;
		this.waitForPageToLoad();
		//this.waitForCondition(Driver->{return this.lstCreditCardsPresent.size()>0;},10000);
		int loopSize = lstCreditCardsPresent.size();
		for (int counter = 0; counter < loopSize; counter++) {
			//Verifying card type image that is added
			WebElement cardImage = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[contains(@class,'padding-right')]/img"));
			String imageType = cardImage.getAttribute("alt");
			if (!cardType.contains("tsc") && imageType.equalsIgnoreCase(cardType)) {
				//Checking the card expiration year now to verify it is same card that is added by user
				WebElement expiresOnWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//div[@class='table-cell']"));
				String expiresOnData = expiresOnWebElement.getText().split(":")[1];
				//Fetching input expiration month and year in required format
				inputExpirationData = this.getExpirationDateDisplayedForCreditCard(expirationMonth,expirationYear);
				if (expiresOnData.trim().equals(inputExpirationData)) {
					reporter.reportLog("Card Type: " + imageType + " and expiration year is same as added: " + expiresOnData);
					//Verifying Image Type and CardType is same that is displayed in application for user
					WebElement cardTypeWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
					String cardTypeDisplayed = cardTypeWebElement.getText();
					if (cardTypeDisplayed.equalsIgnoreCase(cardDisplayName)){
						//Verifying the card number added
						WebElement expiresWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/span"));
						value = this.verifyCardNumberAddedForUser(expiresWebElement,cardNumber,cardType);
						break;
					}
					else
						reporter.reportLogFailWithScreenshot("Card Type added is not same as expected: " + cardTypeDisplayed);
				}
			}else{
				WebElement cardTypeWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
				String cardTypeDisplayed = cardTypeWebElement.getText();
				if (cardTypeDisplayed.equalsIgnoreCase(cardDisplayName)){
					//Verifying the card number added
					WebElement expiresWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/span"));
					value = this.verifyCardNumberAddedForUser(expiresWebElement,cardNumber,cardType);
					break;
				}
			}
		}
		if(value)
			reporter.reportLogPass("Credit Card: "+cardNumber+" with type: "+cardType+" is added as expected for the user");
		else
			reporter.reportLogFailWithScreenshot("Credit Card: "+cardNumber+" with type: "+cardType+" is not added as expected for the user");

		//Remove Credit Card associated
		if(removeCard)
			this.removeCreditCardFromUser(cardType,cardNumber,inputExpirationData);
	}

	/**
	 * This function verifies the displayed last digits of Credit Card Number
	 * @param - String - cardNumber that is added
	 * @param - String - cardType that is added
	 * @return - boolean - true/false
	 */
	public boolean verifyCardNumberAddedForUser(WebElement webElement, String cardNumber, String cardType){
		String inputLastDigitsOfCard = null;
		String lastDigitsOfCard = webElement.getText().split(" ")[2];
		/**
		if(cardType.equalsIgnoreCase("visa"))
			inputLastDigitsOfCard = cardNumber.substring(cardNumber.length()-3);
		else if(cardType.equalsIgnoreCase("master"))
			inputLastDigitsOfCard = cardNumber.substring(cardNumber.length()-4);
		*/
		inputLastDigitsOfCard = cardNumber.substring(cardNumber.length()-4);
		if(lastDigitsOfCard.equals(inputLastDigitsOfCard))
			return true;
		else
			return false;
	}

	/**
	 * This functions removes provided Credit Card attached to user
	 * @param - String - cardType
	 * @param - String - cardNumber
	 * @param -String - expirationMonthAndYear
	 */
	public void removeCreditCardFromUser(String cardType, String cardNumber, String expirationMonthAndYear){
		int beforeDeleteCreditCardsPresent = lstCreditCardsPresent.size();
		WebElement expiresOnWebElement = null;
		String expiresOnData = null;
		boolean value = false;
		for (int counter = 0; counter < beforeDeleteCreditCardsPresent; counter++) {
			WebElement cardImage = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[contains(@class,'padding-right')]/img"));
			String imageType = cardImage.getAttribute("alt");
			if(!imageType.toLowerCase().contains("tsc")){
				expiresOnWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//div[@class='table-cell']"));
				expiresOnData = expiresOnWebElement.getText().split(":")[1];
				if (expiresOnData.trim().equals(expirationMonthAndYear)) {
					WebElement expiresWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/span"));
					value = this.verifyCardNumberAddedForUser(expiresWebElement,cardNumber,cardType);
					if(value){
						//Removing the matched Credit Card
						WebElement removeButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallLeftPadding')]/a[contains(@class,'negative')]"));
						this.clickElement(removeButtonWebElement);
						waitForCondition(Driver->{return this.btnRemoveCreditCardButton.isDisplayed() &&
								this.btnRemoveCreditCardButton.isEnabled();},6000);
						this.clickElement(this.btnRemoveCreditCardButton);
						break;
					}
				}
			}else if(cardType.toLowerCase().contains("tsc")){
				WebElement removeButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallLeftPadding')]/a[contains(@class,'negative')]"));
				this.clickElement(removeButtonWebElement);
				waitForCondition(Driver->{return this.btnRemoveCreditCardButton.isDisplayed() &&
						this.btnRemoveCreditCardButton.isEnabled();},6000);
				this.clickElement(this.btnRemoveCreditCardButton);
				break;
			}
		}
		//Verification that card is removed
		//Applying static wait for 5 seconds as application takes time to refresh and there is no unique element for wait for condition to be used
		getReusableActionsInstance().staticWait(5000);
		int afterDeleteCreditCardsPresent = lstCreditCardsPresent.size();
		if(afterDeleteCreditCardsPresent == beforeDeleteCreditCardsPresent-1)
			reporter.reportLogPass("Credit Card: "+cardNumber+" of type: "+cardType+" is removed from user");
		else
			reporter.reportLogFailWithScreenshot("Credit Card: "+cardNumber+" of type: "+cardType+" is not removed from user");
	}

	/**
	 * This function clicks on Add New Credit Card section on Manage Credit Card Screen
	 */
	public void clickAddNewCreditCardOnManageCreditCardScreen(){
		this.clickElement(this.btnAddNewCreditCard);
		this.waitForPageToLoad();
		waitForCondition(Driver->{return this.btnCancelAddCreditCardForNewCreditCard.isEnabled() &&
				this.btnCancelAddCreditCardForNewCreditCard.isDisplayed();},12000);
	}

	/**
	 * This functions navigates to My Account page from breadcrumb
	 */
	public void navigateToMyAccountFromBreadCrumb(){
		this.clickElement(this.lnkBreadCrumbMyAccount);
		this.waitForPageToLoad();
		waitForCondition(Driver->{return this.lstpaymentOptions.size()>0 &&
				this.lstpaymentOptions.get(0).isEnabled();},6000);
	}

	/**
	 * This function verifies error message on passing invalid Credit Card Number
	 * @param - String - expectedErrorMessage
	 */
	public void verifyInvalidCreditCardErrorMessage(String expectedErrorMessage){
		waitForCondition(Driver->{return this.lblErrorMessageForInvalidCreditCardNumber.isDisplayed();},5000);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblErrorMessageForInvalidCreditCardNumber);
		String actualErrorMessage = this.lblErrorMessageForInvalidCreditCardNumber.getText().trim();
		if(actualErrorMessage.equalsIgnoreCase(expectedErrorMessage))
			reporter.reportLogPass("Error Message on passing invalid Card Number is as expected: "+actualErrorMessage);
		else
			reporter.reportLogFailWithScreenshot("Error Message on passing invalid Card Number :"+actualErrorMessage+" is not as expected: "+expectedErrorMessage);
	}
}
