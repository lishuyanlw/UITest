package com.tsc.pages;

import com.tsc.api.util.DataConverter;
import com.tsc.pages.base.BasePage;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.util.List;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);
	}

	//Navigation breadcrumb
	@FindBy(xpath = "//ng-component/div[not(@hidden)]//div[contains(@class,'go-back')]//ol[@class='breadcrumb']//li//a")
	public List<WebElement> lstNavigationCrumbList;

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

	@FindBy(xpath = "//ng-component//div[contains(@class,'tsc-forms')]//div[contains(text(),'No orders yet')]")
	public WebElement lblNoOrderInfo;

	@FindBy(xpath = "//ng-component//input[@id='myAccountOrderSearch']")
	public WebElement inputAccountOrderSearch;

	@FindBy(xpath = "//ng-component//div[contains(@class,'text-danger')]")
	public WebElement lblAccountOrderSearchErrorMessage;

	@FindBy(xpath = "//ng-component//button[contains(normalize-space(.),'Search Orders')]")
	public WebElement btnAccountOrderSearch;

	@FindBy(xpath = "//ng-component//div[contains(@class,'tsc-forms')]/div[@class='col-xs-12']/div")
	public WebElement cntAccountOrderItemContainer;

	@FindBy(xpath = "//ng-component//label[@for='select-period']")
	public WebElement lblSelectPeriod;

	@FindBy(xpath = "//ng-component//select[@id='select-period']")
	public WebElement selectPeriodOptions;

	@FindBy(xpath = "//ng-component//div[@class='editOrderNote']")
	public WebElement lblEditOrderNote;

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

	@FindBy(xpath = "//ng-component//*[@id='tagOrderCustomerNo']/preceding-sibling::span[contains(@class,'item-title')]/following-sibling::span")
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

	@FindBy(xpath = "//ng-component//div[@id='heading-password']")
	public WebElement cntAccountSettingPasswordHeadingContainer;

	@FindBy(xpath = "//ng-component//div[@id='heading-password']//div[contains(@class,'item-title')]")
	public WebElement lblAccountSettingPasswordTitle;

	@FindBy(xpath = "//ng-component//div[@id='heading-password']//div[contains(@class,'subPage')]")
	public WebElement lblAccountSettingPassword;

	@FindBy(xpath = "//ng-component//div[@id='heading-password']//div[contains(@class,'item-edit')]/a")
	public WebElement btnAccountSettingPasswordEdit;

	//For Change password
	@FindBy(xpath = "//ng-component//div[@id='collapse-password']")
	public WebElement cntChangePasswordPanelContainer;

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

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//a[normalize-space(text())='Cancel']")
	public WebElement btnChangePasswordCancel;

	@FindBy(xpath = "//ng-component//div[@id='panel-password']//input[@id='password']/parent::div/following-sibling::div[contains(@class,'text-danger')]")
	public List<WebElement> lstChangePasswordErrorMessage;
	////////////////////////

	@FindBy(xpath = "//ng-component//div[@id='heading-securityquestion']//div[contains(@class,'item-title')]")
	public WebElement cntAccountSettingSecurityQuestionHeadingContainer;

	@FindBy(xpath = "//ng-component//div[@id='heading-securityquestion']//div[contains(@class,'item-title')]")
	public WebElement lblAccountSettingSecurityQuestionTitle;

	@FindBy(xpath = "//ng-component//div[@id='heading-securityquestion']//div[contains(@class,'subPage')]")
	public WebElement lblAccountSettingSecurityQuestion;

	@FindBy(xpath = "//ng-component//div[@id='heading-securityquestion']//div[contains(@class,'item-edit')]/a")
	public WebElement btnAccountSettingSecurityQuestionEdit;

	//For change security question
	@FindBy(xpath = "//ng-component//div[@id='collapse-securityquestion']")
	public WebElement cntChangeSecurityQuestionPanelContainer;

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

	@FindBy(xpath = "//ng-component//div[@id='panel-securityquestion']//a[normalize-space(text())='Cancel']")
	public WebElement btnChangeSecurityQuestionCancel;

	@FindBy(xpath = "//ng-component//input[@name='answerError']")
	public WebElement lblChangeSecurityQuestionsErrorMessage;
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

	@FindBy(xpath="//input[@id='maskedPan']")
	public WebElement getLblMaskedCardNumberForNewCreditCard;

	@FindBy(xpath="//input[@id='ficard']")
	public WebElement lblTSCCreditCardInput;

	@FindBy(xpath="//input[@id='maskedPan']")
	public WebElement lblMaskedCardNumberForNewCreditCard;

	@FindBy(xpath="//select[@name='month']")
	public WebElement lblMonthForNewCreditCard;

	@FindBy(xpath="//select[@name='year']")
	public WebElement lblExpirationYearForNewCreditCard;

	@FindBy(xpath="//div[contains(@class,'text-danger')]")
	public List<WebElement> lblErrorMessageForInvalidCreditCardNumber;

	@FindBy(xpath="//button[contains(@class,'signout')]")
	public WebElement btnSignOutMyAccountPage;

	@FindBy(xpath = "//div[@id='semafoneCapturePage']/iframe")
	public WebElement iFrameForNewCreditCard;

	//PAYMENT OPTIONS - MANAGE CREDIT CARD
	@FindBy(xpath="//div[contains(@class,'desktop-divider')]")
	public List<WebElement> lstCreditCardsPresent;
	//.//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')] - Edit Button

	@FindBy(xpath="//button[@id='addCardBtn']")
	public WebElement btnAddNewCreditCard;

	@FindBy(xpath="//button[@id='addCardBtn']//div[contains(@class,'addBtnTxt')]")
	public WebElement lblAddNewCreditCardText;

	@FindBy(xpath="//span[@class='table-cell']/label")
	public WebElement lblCardNameOnRemovePopUp;

	@FindBy(xpath="//span[@class='table-cell']/span")
	public WebElement lblCardNumberOnRemovePopUp;

	@FindBy(xpath="//div[@class='modal-body']//div[contains(@class,'clearfix')]/div/button[contains(text(),'REMOVE')]")
	public WebElement btnRemoveCreditCardButton;

	@FindBy(xpath="//div[@class='modal-body']//div[contains(@class,'clearfix')]/div/button/span")
	public WebElement btnCancelRemoveCreditCardButton;

	@FindBy(xpath="//*[@class='breadcrumb']/li/a[contains(text(),'Account')]")
	public WebElement lnkBreadCrumbMyAccount;

	//GIFT CARD BALANCE - PAYMENT OPTIONS
	@FindBy(xpath="//*[contains(@id,'content')]//*[contains(@class,'titleLink')]")
	public WebElement lblGiftCardPageTitle;

	@FindBy(xpath="//input[@id='giftcardNumber']")
	public WebElement lblGiftCardNumberEntryTextBox;

	@FindBy(xpath="//input[@id='pin']")
	public WebElement lblGiftCardPinEntryTextBox;

	@FindBy(xpath="//button[contains(@class,'btnResizing')]")
	public WebElement btmCheckGiftCardBalanceButton;

	@FindBy(xpath="//form[contains(@class,'tsc-forms')]//div/strong")
	public WebElement lblGiftCardBalanceText;

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
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				this.getReusableActionsInstance().clickIfAvailable(item);
				this.waitForCondition(Driver->{
					return item.getAttribute("class").isEmpty();},5000);
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
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
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
			if(webElement.getText().contains(subMenu)){
				this.clickElement(webElement);
				flag=true;
				break;
			}
		}
		if(subMenu.toLowerCase().contains("add"))
			waitForCondition(Driver->{return this.btnCancelAddCreditCardForNewCreditCard.isEnabled() &&
				this.btnCancelAddCreditCardForNewCreditCard.isDisplayed();},12000);
		else if(subMenu.toLowerCase().contains("manage")){
			this.waitForPageToLoad();
			waitForCondition(Driver->{return this.lstCreditCardsPresent.size()>0;},6000);
		}else{
			this.waitForPageToLoad();
			this.waitForCondition(Driver->{return this.lblGiftCardPageTitle.getText().toLowerCase().contains("gift");},6000);
		}

		if(!flag)
			reporter.reportLogFailWithScreenshot("Provided sub-menu: "+subMenu+" is not present. Please verify once again!");
	}

	/**
	 * This function returns expiration data for new Credit Card
	 * @return - Map<String,String> - Expiration Month and Year Data for Card
	 * @throws ParseException
	 */
	public Map<String,String> getNewCardExpirationData(int monthsToBeAdded, int yearsToBeAdded) throws ParseException {
		Map<String,String> cardData = new HashMap<>();
		String[] date = new DataConverter().getLocalDate().split("-");
		int calculatedExpirationMonth = Integer.valueOf(date[1])+monthsToBeAdded>12 ? (Integer.parseInt(date[1])+monthsToBeAdded)-12 : Integer.valueOf(date[1])+monthsToBeAdded;
		String expirationMonth = String.valueOf(calculatedExpirationMonth);
		if(expirationMonth.length()==1)
			expirationMonth = "0"+expirationMonth;
		String expirationYear = String.valueOf(Integer.valueOf(date[0])+yearsToBeAdded);
		cardData.put("expirationMonth",expirationMonth);
		cardData.put("expirationYear",expirationYear);
		return cardData;
	}

	/**
	 * This function adds Credit Card number for new Card addition
	 */
	public void addNewCreditCardNumber(String cardNumber){
		this.waitForPageToLoad();
		getDriver().switchTo().frame(iFrameForNewCreditCard);
		waitForCondition(Driver->{return this.lblCardNumberForNewCreditCard.isEnabled() &&
				this.lblCardNumberForNewCreditCard.isDisplayed();},15000);
		//Adding Credit Card Number
		this.clickWebElementUsingJS(this.lblCardNumberForNewCreditCard);
		this.lblCardNumberForNewCreditCard.sendKeys(cardNumber);
		//Using static wait of 5 seconds here as wait for condition is throwing target frame detached error
		getReusableActionsInstance().staticWait(5000);
		//waitForCondition(Driver->{return !this.getChildElementAttribute(this.getLblMaskedCardNumberForNewCreditCard,"value").isEmpty();},10000);
		getDriver().switchTo().defaultContent();
	}

	/**
	 * This function adds Credit Card Expiration Month and Year
	 * @param -Map<String,String> - cardData
	 */
	public void addExpirationMonthAndYear(Map<String,String> cardData){
		getReusableActionsInstance().selectWhenReady(this.lblMonthForNewCreditCard,cardData.get("expirationMonth"),6000);
		getReusableActionsInstance().selectWhenReady(this.lblExpirationYearForNewCreditCard,cardData.get("expirationYear"),6000);
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
		Map<String,String> cardData = this.getNewCardExpirationData(2,0);

		waitForCondition(Driver->{return cardTypeElement.isDisplayed() && cardTypeElement.isEnabled();},5000);
		this.clickWebElementUsingJS(cardTypeElement);

		if(!cardType.equalsIgnoreCase("tsc")){
			this.addNewCreditCardNumber(cardNumber);
			//Selecting Expiration Month and Year
			this.addExpirationMonthAndYear(cardData);
		}else
			this.lblTSCCreditCardInput.sendKeys(cardNumber);

		//Click on Save Button
		if(isDefault)
			getReusableActionsInstance().clickIfAvailable(this.isDefaultCheckBoxForNewCreditCard,2000);
		this.clickElement(this.btnSaveAddCreditCardForNewCreditCard);
		return cardData;
	}

	/**
	 * This function converts input expiration data to displayed format on application
	 * @param -String - expirationMonth
	 * @param - String - expirationYear
	 * @return - String
	 */
	public String formatExpirationDateForCreditCard(String expirationMonth, String expirationYear){
		if(expirationMonth.startsWith("0"))
			expirationMonth = expirationMonth.substring(expirationMonth.length()-1);
		if(expirationYear.length()>2)
			expirationYear = expirationYear.substring(expirationYear.length()-2);
		return (expirationMonth + "/" + expirationYear).trim();
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
				inputExpirationData = this.formatExpirationDateForCreditCard(expirationMonth,expirationYear);
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
			this.removeCreditCardFromUser(cardType,cardNumber,inputExpirationData,true);
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
	 * This functions selects the credit card either for removal or for edit functionality
	 * @param - String - cardNumber
	 * @param - String - cardType
	 * @param - String - expirationMonthAndYear
	 */
	public void selectGivenCreditCard(String cardNumber, String cardType, String expirationMonthAndYear,boolean selectForRemove){
		int beforeDeleteCreditCardsPresent = lstCreditCardsPresent.size();
		WebElement expiresOnWebElement = null;
		WebElement removeButtonWebElement, editButtonWebElement;
		String expiresOnData = null;
		boolean value = false;
		for (int counter = 0; counter < beforeDeleteCreditCardsPresent; counter++) {
			WebElement cardImage = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[contains(@class,'padding-right')]/img"));
			String imageType = cardImage.getAttribute("alt");
			if(!imageType.toLowerCase().contains("tsc")){
				expiresOnWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//div[@class='table-cell']"));
				expiresOnData = expiresOnWebElement.getText().split(":")[1].trim();
				if (expiresOnData.trim().equals(expirationMonthAndYear)) {
					WebElement expiresWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/span"));
					value = this.verifyCardNumberAddedForUser(expiresWebElement,cardNumber,cardType);
					if(value){
						//Removing the matched Credit Card
						if(selectForRemove){
							removeButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallLeftPadding')]/a[contains(@class,'negative')]"));
							this.clickElement(removeButtonWebElement);
							waitForCondition(Driver->{return this.btnRemoveCreditCardButton.isDisplayed() &&
									this.btnRemoveCreditCardButton.isEnabled();},6000);
						}else{
							editButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')]"));
							this.clickElement(editButtonWebElement);
							waitForCondition(Driver->{return this.btnSaveAddCreditCardForNewCreditCard.isDisplayed() &&
									this.btnSaveAddCreditCardForNewCreditCard.isEnabled();},6000);
						}
						break;
					}
				}
			}else if(cardType.toLowerCase().contains("tsc")){
				if(selectForRemove){
					removeButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallLeftPadding')]/a[contains(@class,'negative')]"));
					this.clickElement(removeButtonWebElement);
					waitForCondition(Driver->{return this.btnRemoveCreditCardButton.isDisplayed() &&
							this.btnRemoveCreditCardButton.isEnabled();},6000);
				}else{
					editButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')]"));
					this.clickElement(editButtonWebElement);
					waitForCondition(Driver->{return this.btnSaveAddCreditCardForNewCreditCard.isDisplayed() &&
							this.btnSaveAddCreditCardForNewCreditCard.isEnabled();},6000);
				}
				break;
			}
		}
	}

	/**
	 * This function verifies card on remove popup
	 * @param - String - cardDetails
	 */
	public void verifyCardTypeAndNameOnRemove(String cardType, String cardNumber){
		String appCardDetails = this.lblCardNameOnRemovePopUp.getText().trim()+" "+this.lblCardNumberOnRemovePopUp.getText().trim();
		if(cardType.contains("amex"))
			cardType = "american express";
		if(appCardDetails.toLowerCase().contains(cardType.toLowerCase()) && appCardDetails.contains(cardNumber))
			reporter.reportLogPass("Card Number deleted is same as expected: "+appCardDetails);
		else
			reporter.reportLogFailWithScreenshot("Card Number that is deleted: "+appCardDetails+" is not as expected for type: "+cardType);
	}

	/**
	 * This functions removes provided Credit Card attached to user
	 * @param - String - cardType
	 * @param - String - cardNumber
	 * @param -String - expirationMonthAndYear
	 */
	public void removeCreditCardFromUser(String cardType, String cardNumber, String expirationMonthAndYear, boolean removeCard){
		int beforeDeleteCreditCardsPresent = lstCreditCardsPresent.size();
		this.selectGivenCreditCard(cardNumber,cardType,expirationMonthAndYear,true);
		if(removeCard){
			this.verifyCardTypeAndNameOnRemove(cardType,cardNumber.substring(cardNumber.length()-4));
			this.clickElement(this.btnRemoveCreditCardButton);
		}
		else
			this.clickElement(this.btnCancelRemoveCreditCardButton);
		//Verification that card is removed
		//Applying static wait for 5 seconds as application takes time to refresh and there is no unique element for wait for condition to be used
		getReusableActionsInstance().staticWait(5000);
		int afterDeleteCreditCardsPresent = lstCreditCardsPresent.size();
		boolean flag = removeCard == true ? afterDeleteCreditCardsPresent == beforeDeleteCreditCardsPresent-1 : afterDeleteCreditCardsPresent == beforeDeleteCreditCardsPresent;
		if(flag)
			reporter.reportLogPass("Credit Card: "+cardNumber+" of type: "+cardType+" is removed from user");
		else
			reporter.reportLogFailWithScreenshot("Credit Card: "+cardNumber+" of type: "+cardType+" is not removed from user");
	}

	/**
	 * This functions edits added Credit Card with user
	 * @param - String - cardType
	 * @param - String - cardNumber
	 * @param -String - expirationMonthAndYear
	 */
	public Map<String,String> editAndVerifyCreditCardAttachedToUser(String cardType, String cardDisplayName, String cardNumber, String expirationMonthAndYear, JSONObject creditCardsData, boolean editCard) throws ParseException {
		Map<String,String> cardData = new HashMap<>();
		if(cardType!=null){
			cardData.put("cardType",cardType);
			cardData.put("cardNumber",cardNumber);
			cardData.put("expirationMonthAndYear",expirationMonthAndYear);
			this.selectGivenCreditCard(cardNumber,cardType,expirationMonthAndYear,false);
		}else{
			cardData = this.getFirstCreditCardDetailsAndSelect();
			String cardTypeAdded = this.getCreditCardTypeName(cardData.get("cardType"));
			JSONObject creditCard = (JSONObject) creditCardsData.get(cardTypeAdded);
			cardNumber = creditCard.get("Number").toString();
			cardData.put("cardNumber",cardNumber);
		}
		this.addNewCreditCardNumber(cardNumber);

		if(expirationMonthAndYear!=null){
			String[] expirationData = expirationMonthAndYear.split("/");
			int updatedMonth = Integer.valueOf(expirationData[0])+1 > 12 ? (Integer.valueOf(expirationData[0]) + 1) - 12 : Integer.valueOf(expirationData[0])+1;
			int updatedYear = Integer.valueOf(expirationData[1])+1;
			cardData.put("expirationMonth",String.valueOf(updatedMonth));
			cardData.put("expirationYear",String.valueOf(updatedYear));
		}
		this.addExpirationMonthAndYear(cardData);
		this.waitForPageToLoad();
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSaveAddCreditCardForNewCreditCard);

		if(editCard)
			this.clickElement(this.btnSaveAddCreditCardForNewCreditCard);
		else
			this.clickElement(this.btnCancelAddCreditCardForNewCreditCard);

		//Verification of Updated Data for Credit Card
		if(cardType!=null)
			this.verifyNewAddedCreditCardForUser(cardType,cardDisplayName,cardNumber,cardData.get("expirationMonth"),cardData.get("expirationYear"),false);
		else{
			if(editCard)
				this.verifyNewAddedCreditCardForUser(cardData.get("cardType"),cardData.get("cardDisplayName"),cardNumber,cardData.get("expirationMonth"),cardData.get("expirationYear"),false);
			else
				this.verifyNewAddedCreditCardForUser(cardData.get("cardType"),cardData.get("cardDisplayName"),cardNumber,cardData.get("actualExpirationMonth"),cardData.get("actualExpirationYear"),false);
		}
		return cardData;
	}

	/**
	 * This function selects first credit card displayed on Manage Screen by default when no Credit Card is provided
	 */
	public Map<String,String> getFirstCreditCardDetailsAndSelect() throws ParseException {
		Map<String,String> creditCardDisplayedData = new HashMap<>();
		String updatedMonth=null,updatedYear = null,actualExpirationMonth=null,actualExpirationYear=null;
		//Fetching Card Details to be edited to be used for verification
		WebElement cardTypeWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
		String cardType = cardTypeWebElement.getText();
		WebElement cardDisplayTypeWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
		String cardDisplayName = cardDisplayTypeWebElement.getText();
		if(!cardType.toLowerCase().contains("tsc")) {
			WebElement expiresOnWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//div[@class='table-cell']"));
			String[] expiresOnData = expiresOnWebElement.getText().split(":")[1].split("/");

			updatedMonth = Integer.valueOf(expiresOnData[0].trim())+1 > 12 ? String.valueOf((Integer.valueOf(expiresOnData[0].trim()) + 1) - 12) : String.valueOf(Integer.valueOf(expiresOnData[0].trim())+1);
			if(updatedMonth.length()==1)
				updatedMonth = "0"+updatedMonth;
			Map<String,String> updatedYearData = getNewCardExpirationData(2,0);
			updatedYear = updatedYearData.get("expirationYear");
			actualExpirationMonth = expiresOnData[0].trim();
			actualExpirationYear = expiresOnData[1].trim();

			creditCardDisplayedData.put("cardType", cardType);
			creditCardDisplayedData.put("cardDisplayName", cardDisplayName);
			creditCardDisplayedData.put("expirationMonth", updatedMonth);
			creditCardDisplayedData.put("expirationYear", updatedYear);
			creditCardDisplayedData.put("actualExpirationMonth", actualExpirationMonth);
			creditCardDisplayedData.put("actualExpirationYear", actualExpirationYear);
			creditCardDisplayedData.put("expirationMonthAndYear",actualExpirationMonth+"/"+actualExpirationYear);
		}

		WebElement editButtonWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')]"));
		this.clickElement(editButtonWebElement);
		//Wait for page load
		this.waitForPageToLoad();

		return creditCardDisplayedData;
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
	 * This function fetches Credit Card type name on basis of displayed name on application
	 */
	public String getCreditCardTypeName(String displayName){
		if(displayName.toLowerCase().contains("visa"))
			return "visa";
		else if(displayName.toLowerCase().contains("tsc"))
			return "tsc";
		else if(displayName.toLowerCase().contains("american"))
			return "amex";
		else
			return "master";
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
		waitForCondition(Driver->{return this.lblErrorMessageForInvalidCreditCardNumber.get(0).isDisplayed();},5000);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblErrorMessageForInvalidCreditCardNumber.get(0));
		String actualErrorMessage = this.lblErrorMessageForInvalidCreditCardNumber.get(0).getText().trim();
		if(actualErrorMessage.equalsIgnoreCase(expectedErrorMessage))
			reporter.reportLogPass("Error Message on passing invalid Card Number is as expected: "+actualErrorMessage);
		else
			reporter.reportLogFailWithScreenshot("Error Message on passing invalid Card Number :"+actualErrorMessage+" is not as expected: "+expectedErrorMessage);
	}

	/**
	 * This function verifies gift card balance
	 * @param - String - giftCardNumber for balance verification
	 * @param - String - pin for card
	 * @param - String - balance for gift card
	 */
	public void getAndVerifyGiftCardBalance(String giftCardNumber, String pin, String balance){
		//Enter gift card
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblGiftCardNumberEntryTextBox);
		this.lblGiftCardNumberEntryTextBox.sendKeys(giftCardNumber);
		//Enter pin
		this.lblGiftCardPinEntryTextBox.sendKeys(pin);
		getReusableActionsInstance().clickIfAvailable(this.btmCheckGiftCardBalanceButton,2000);

		this.waitForCondition(Driver->{return this.lblGiftCardBalanceText.isDisplayed() &&
					!this.lblGiftCardBalanceText.getText().toLowerCase().trim().contains("pending");},30000);

		String balanceText = this.lblGiftCardBalanceText.getText().trim().split(":")[1];

		if(balanceText!=null && balanceText.equalsIgnoreCase(balance))
			reporter.reportLogPass("Balance for Gift Card: "+giftCardNumber+" is same as expected: "+balanceText);
		else if(balanceText.contains("$"))
			reporter.reportLogPassWithScreenshot("Balance for Gift Card: "+giftCardNumber+" is present: "+balanceText);
		else
			reporter.reportLogFailWithScreenshot("Balance for Gift Card: "+giftCardNumber+" is not as expected: "+balanceText);
	}

	/**
	 * To open the window by clicking sub item
	 * @param - lsSubItem - sub item name
	 * @param - loadingIndicator - the element to indicate window loading
	 */
	public void openSubItemWindow(String lsSubItem,WebElement loadingIndicator){
		WebElement orderStatusButton=this.getSubItem(lsSubItem);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(orderStatusButton);
		if(this.getReusableActionsInstance().isElementVisible(orderStatusButton)){
			reporter.reportLogPass("'"+lsSubItem+ "' sub item is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("'"+lsSubItem+ "' sub item is not displaying correctly");
		}
		this.getReusableActionsInstance().clickIfAvailable(orderStatusButton);

		this.waitForCondition(Driver->{return loadingIndicator.isDisplayed();},50000);

		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
	}

	/**
	 * To get a random orderNO from order item list
	 * @return - String - a random orderNO
	 */
	public String getRandomOrderNumber(){
		int optionSize=this.lstOrderItemList.size();
		Random rand = new Random();
		int randomNumber = rand.nextInt(optionSize-1);
		WebElement randomItem=this.lstOrderItemList.get(randomNumber).findElement(byOrderNo);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(randomItem);

		return randomItem.getText().trim();
	}

	/**
	 * To verify order status
	 * @param - bRecentOrder - is order status or recent order
	 */
	public void verifyOrderStatusSection(boolean bRecentOrder){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderStatusSectionTitle);
		if(!this.lblOrderStatusSectionTitle.getText().isEmpty()){
			reporter.reportLogPass("Order Status Section Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order Status Section Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputAccountOrderSearch);
		if(this.getReusableActionsInstance().isElementVisible(this.inputAccountOrderSearch)){
			reporter.reportLogPass("search order input field is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("search order input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAccountOrderSearch);
		if(this.getReusableActionsInstance().isElementVisible(this.btnAccountOrderSearch)){
			reporter.reportLogPass("Search order button field is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Search order button field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSelectPeriod);
		if(!this.lblSelectPeriod.getText().isEmpty()){
			reporter.reportLogPass("Select period static title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Select period static title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectPeriodOptions);
		if(this.getReusableActionsInstance().isElementVisible(this.selectPeriodOptions)){
			reporter.reportLogPass("Select period is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Select period is not displaying correctly");
		}

		Select select=new Select(this.selectPeriodOptions);
		String currentOption=select.getFirstSelectedOption().getText().trim();
		if(!bRecentOrder){
			if(currentOption.equalsIgnoreCase("All")){
				reporter.reportLogPass("The select period is 'All'");
			}
			else{
				reporter.reportLogFailWithScreenshot("The select period is not 'All'");
			}
		}
		else{
			if(currentOption.equalsIgnoreCase("last 30 days")){
				reporter.reportLogPass("The select period is 'last 30 days'");
			}
			else{
				reporter.reportLogFailWithScreenshot("The select period is not 'last 30 days'");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblEditOrderNote);
		if(!this.lblEditOrderNote.getText().isEmpty()){
			reporter.reportLogPass("Edit order note is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Edit order note is not displaying correctly");
		}

		reporter.reportLog("Verify order item list");
		WebElement subItem=null;
		String lsOrderNO;
		for(WebElement item:this.lstOrderItemList){
			subItem=item.findElement(byOrderNo);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			lsOrderNO=subItem.getText().trim();

			reporter.reportLog("Verify the order item "+lsOrderNO);
			if(!lsOrderNO.isEmpty()){
				reporter.reportLogPass("OrderNO is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("OrderNO is not displaying correctly");
			}

			subItem=item.findElement(byOrderNoTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().isEmpty()){
				reporter.reportLogPass("OrderNO title is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("OrderNO title is not displaying correctly");
			}

			subItem=item.findElement(byOrderNoDate);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().isEmpty()){
				reporter.reportLogPass("OrderNO date is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("OrderNO date is not displaying correctly");
			}

			subItem=item.findElement(byOrderTotalTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().isEmpty()){
				reporter.reportLogPass("Order total title is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Order total title is not displaying correctly");
			}

			subItem=item.findElement(byOrderTotal);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().isEmpty()){
				reporter.reportLogPass("Order total is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Order total is not displaying correctly");
			}

			subItem=item.findElement(byOrderStatusTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().isEmpty()){
				reporter.reportLogPass("Order status title is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Order status title is not displaying correctly");
			}

			subItem=item.findElement(byOrderStatus);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().isEmpty()){
				reporter.reportLogPass("Order status is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Order status is not displaying correctly");
			}

			subItem=item.findElement(byOrderViewDetails);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().isEmpty()){
				reporter.reportLogPass("Order view details button is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Order view details button is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntOrderStatusPaginationContainer);
		if(this.getReusableActionsInstance().isElementVisible(this.cntOrderStatusPaginationContainer)){
			reporter.reportLogPass("Pagination section is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Pagination section is not displaying correctly");
		}
	}

	/**
	 * To verify search order by given order number
	 * @param - lsOrderDetailsURL
	 */
	public void verifySearchOrderFunction(String lsOrderDetailsURL){
		String orderNumber=this.getRandomOrderNumber();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputAccountOrderSearch);
		this.inputAccountOrderSearch.clear();
		this.inputAccountOrderSearch.sendKeys(orderNumber);
		this.getReusableActionsInstance().clickIfAvailable(this.btnAccountOrderSearch);

		this.waitForCondition(Driver->{ return this.lblOrderDetailsSectionTitle.isDisplayed();},50000);

		lsOrderDetailsURL=lsOrderDetailsURL.replace("{OrderNO}",orderNumber);
		String lsExpectedURL=this.getBaseURL()+lsOrderDetailsURL;
		if(this.URL().equalsIgnoreCase(lsExpectedURL)){
			reporter.reportLogPass("The page is navigated to order details page correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The page is not navigated to order details page correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderDetailsHeaderCustomerNO);
		String lsOrderNumberInOrderDetails=this.lblOrderDetailsHeaderCustomerNO.getText().trim();
		if(lsOrderNumberInOrderDetails.equalsIgnoreCase(orderNumber)){
			reporter.reportLogPass("Order number in order details page is the same as the one in order status page");
		}
		else{
			reporter.reportLogPass("Order number:"+lsOrderNumberInOrderDetails+" in order details page is not the same as the one:"+orderNumber+" in order status page");
		}
	}

	/**
	 * To go back to upper level page
	 */
	public void goBackUpperLevel(){
		WebElement lastNavigationElement=this.lstNavigationCrumbList.get(this.lstNavigationCrumbList.size()-1);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lastNavigationElement);
		this.getReusableActionsInstance().clickIfAvailable(lastNavigationElement);

		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
	}

	public void verifyOrderSearchErrorMessage(String lsExpectedErrorMessage){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputAccountOrderSearch);
		this.inputAccountOrderSearch.clear();
		this.inputAccountOrderSearch.sendKeys("OrderNumber");
		this.getReusableActionsInstance().clickIfAvailable(this.btnAccountOrderSearch);

		this.waitForCondition(Driver->{ return this.lblAccountOrderSearchErrorMessage.isDisplayed();},50000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAccountOrderSearchErrorMessage);
		String lsErrorMessage=this.lblAccountOrderSearchErrorMessage.getText().trim();
		if(lsErrorMessage.equalsIgnoreCase(lsExpectedErrorMessage)){
			reporter.reportLogPass("The order search error message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The order search error message:'"+lsErrorMessage+"' is not displaying as the expected one:'"+lsExpectedErrorMessage+"'");
		}
	}

	/**
	 * To check Order Item Existing
	 * @return - boolean
	 */
	public boolean checkOrderItemExisting(){
		return this.checkChildElementExistingByAttribute( this.cntAccountOrderItemContainer,"class","no-breadcrumb-link");
	}

	/**
	 * To go to Order Details Page
	 * @return - selected orderNO
	 */
	public String goToOrderDetailsPage(){
		int optionSize=this.lstOrderItemList.size();
		Random rand = new Random();
		int randomNumber = rand.nextInt(optionSize-1);

		WebElement randomOrderNOItem=this.lstOrderItemList.get(randomNumber).findElement(this.byOrderNo);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(randomOrderNOItem);
		String lsOrderStatusOrderNO=randomOrderNOItem.getText().trim();

		WebElement randomOrderViewDetailsItem=this.lstOrderItemList.get(randomNumber).findElement(this.byOrderViewDetails);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(randomOrderViewDetailsItem);
		this.getReusableActionsInstance().clickIfAvailable(randomOrderViewDetailsItem);

		this.waitForCondition(Driver->{return this.lblOrderDetailsSectionTitle.isDisplayed();},40000);

		return lsOrderStatusOrderNO;
	}

	/**
	 * To verify main header section in order details
	 * @param - lsOrderNO from Order status page
	 * @param - lsCustomerNumber from Order status page
	 */
	public void verifyMainHeaderSectionInOrderDetails(String lsOrderNO,String lsCustomerNumber){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSectionTitle);
		if(!lblOrderDetailsSectionTitle.getText().isEmpty()){
			reporter.reportLogPass("Section title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Section title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderNOTitle);
		if(!lblOrderDetailsHeaderOrderNOTitle.getText().isEmpty()){
			reporter.reportLogPass("OrderNo title in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("OrderNo title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderNO);
		if(lblOrderDetailsHeaderOrderNO.getText().trim().equalsIgnoreCase(lsOrderNO)){
			reporter.reportLogPass("OrderNo in Header is the same as the one in Order status page");
		}
		else{
			reporter.reportLogFailWithScreenshot("OrderNo:"+lblOrderDetailsHeaderOrderNO.getText().trim()+" in Header is not the same as the one:"+lsOrderNO+" in Order status page");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderedDateTitle);
		if(!lblOrderDetailsHeaderOrderedDateTitle.getText().isEmpty()){
			reporter.reportLogPass("Order date title in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order date title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderedDate);
		if(!lblOrderDetailsHeaderOrderedDate.getText().isEmpty()){
			reporter.reportLogPass("Order date in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order date in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderCustomerNOTitle);
		if(!lblOrderDetailsHeaderCustomerNOTitle.getText().isEmpty()){
			reporter.reportLogPass("Customer number title in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Customer number title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderCustomerNO);
		if(lblOrderDetailsHeaderCustomerNO.getText().trim().equalsIgnoreCase(lsCustomerNumber)){
			reporter.reportLogPass("Customer number in Header is the same as the one in Order status page");
		}
		else{
			reporter.reportLogFailWithScreenshot("Customer number:"+lblOrderDetailsHeaderCustomerNO.getText().trim()+" in Header is the same as the one:"+lsCustomerNumber+" in Order status page");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderMethodTitle);
		if(!lblOrderDetailsHeaderOrderMethodTitle.getText().isEmpty()){
			reporter.reportLogPass("Order method title in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order method title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderMethod);
		if(!lblOrderDetailsHeaderOrderMethod.getText().isEmpty()){
			reporter.reportLogPass("Order method title in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order method title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderStatusTitle);
		if(!lblOrderDetailsHeaderOrderStatusTitle.getText().isEmpty()){
			reporter.reportLogPass("Order status title in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order status title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderStatus);
		if(!lblOrderDetailsHeaderOrderStatus.getText().isEmpty()){
			reporter.reportLogPass("Order status in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order status in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderTotalTitle);
		if(!lblOrderDetailsHeaderOrderTotalTitle.getText().isEmpty()){
			reporter.reportLogPass("Order total title in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order total title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderTotal);
		if(!lblOrderDetailsHeaderOrderTotal.getText().isEmpty()){
			reporter.reportLogPass("Order total in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order total in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderDetailsHeaderTrackOrder);
		if(this.getReusableActionsInstance().isElementVisible(btnOrderDetailsHeaderTrackOrder)){
			reporter.reportLogPass("Track order button in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Track order button in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderDetailsHeaderEditOrder);
		if(this.getReusableActionsInstance().isElementVisible(btnOrderDetailsHeaderEditOrder)){
			reporter.reportLogPass("Edit order button in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Edit order button in Header is not displaying correctly");
		}

		if(btnOrderDetailsHeaderEditOrder.getAttribute("class").contains("disabled")){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderNote);
			if(!lblOrderDetailsHeaderOrderNote.getText().isEmpty()){
				reporter.reportLogPass("Order note in Header is displaying correctly when Edit order button is disabled");
			}
			else{
				reporter.reportLogFailWithScreenshot("Order note in Header is not displaying correctly when Edit order button is disabled");
			}
		}
	}

	/**
	 * To verify main header section in order details for different devices
	 */
	public void verifyMainHeaderSectionInOrderDetails_DifferentDevice(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderDetailsHeaderViewInvoice);
		if(this.getReusableActionsInstance().isElementVisible(btnOrderDetailsHeaderViewInvoice)){
			reporter.reportLogPass("View invoice button in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("View invoice button in Header is not displaying correctly");
		}
	}

	/**
	 * To verify sub header section in order details
	 * @param - lsOrderNO from Order status page
	 */
	public void verifySubHeaderSectionInOrderDetails(String lsOrderNO){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderSubOrderTitle);
		if(!lblOrderDetailsSubHeaderSubOrderTitle.getText().isEmpty()){
			reporter.reportLogPass("Order title in Sub Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order title in Sub Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderCustomerNO);
		if(lblOrderDetailsSubHeaderCustomerNO.getText().trim().equalsIgnoreCase(lsOrderNO)){
			reporter.reportLogPass("OrderNO in Sub Header is the same as the one in Order status page");
		}
		else{
			reporter.reportLogFailWithScreenshot("OrderNO:+"+lblOrderDetailsSubHeaderCustomerNO.getText().trim()+" in Sub Header is the same as the one:"+lsOrderNO+" in Order status page");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingMethodTitle);
		if(!lblOrderDetailsSubHeaderShippingMethodTitle.getText().isEmpty()){
			reporter.reportLogPass("Shipping method title in Sub Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Shipping method title in Sub Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingMethod);
		if(!lblOrderDetailsSubHeaderShippingMethod.getText().isEmpty()){
			reporter.reportLogPass("Shipping method in Sub Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Shipping method in Sub Header is not displaying correctly");
		}
	}

	/**
	 * To verify sub header section in order details for different devices
	 * @param - lsOrderNO from Order status page
	 */
	public void verifySubHeaderSectionInOrderDetails_DifferentDevices(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingAddressTitle);
		if(!lblOrderDetailsSubHeaderShippingAddressTitle.getText().isEmpty()){
			reporter.reportLogPass("Shipping address title in Sub Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Shipping address title in Sub Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingAddress);
		if(!lblOrderDetailsSubHeaderShippingAddress.getText().isEmpty()){
			reporter.reportLogPass("Shipping address in Sub Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Shipping address in Sub Header is not displaying correctly");
		}
	}

	/**
	 * To verify order item list section in order details
	 */
	public void verifyOrderItemListSectionInOrderDetails(){
		WebElement subItem=null;
		String lsProductNO;
		for(WebElement item:lstOrderDetailsOrderItemList){
			subItem=item.findElement(byOrderDetailsOrderItemProductNumber);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			lsProductNO=subItem.getText().trim();
			reporter.reportLog("Verify product number: "+lsProductNO);

			if(!lsProductNO.isEmpty()){
				reporter.reportLogPass("Product number is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Product number is not displaying correctly");
			}

			subItem=item.findElement(byOrderDetailsOrderItemLink);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getAttribute("href").isEmpty()){
				reporter.reportLogPass("The product link is not empty");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product link is empty");
			}

			subItem=item.findElement(byOrderDetailsOrderItemImage);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getAttribute("src").isEmpty()){
				reporter.reportLogPass("The image src is not empty");
			}
			else{
				reporter.reportLogFailWithScreenshot("The image src is empty");
			}

			subItem=item.findElement(byOrderDetailsOrderItemPipeStyleLink);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getAttribute("href").isEmpty()){
				reporter.reportLogPass("The product pipe style link is not empty");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product pipe style link is empty");
			}

			subItem=item.findElement(byOrderDetailsOrderItemProductPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().trim().isEmpty()){
				reporter.reportLogPass("The product price is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product price is not displaying correctly");
			}

			subItem=item.findElement(byOrderDetailsOrderItemQTYTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().trim().isEmpty()){
				reporter.reportLogPass("The product order QTY title is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product order QTY title is not displaying correctly");
			}

			subItem=item.findElement(byOrderDetailsOrderItemQTY);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().trim().isEmpty()){
				reporter.reportLogPass("The product order QTY is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product order QTY is not displaying correctly");
			}

			subItem=item.findElement(byOrderDetailsOrderItemStatusTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().trim().isEmpty()){
				reporter.reportLogPass("The product order status title is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product order status title is not displaying correctly");
			}

			subItem=item.findElement(byOrderDetailsOrderItemStatus);
			String lsOrderStatus=this.getElementInnerText(subItem);
			if(!lsOrderStatus.isEmpty()){
				subItem=item.findElement(byOrderDetailsOrderItemWriteReview);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				if(!subItem.getText().trim().isEmpty()){
					reporter.reportLogPass("Write a review button is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("Write a review button is not displaying correctly");
				}
			}
		}
	}

	/**
	 * To verify summary section in order details
	 */
	public void verifySummarySectionInOrderDetails(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsBillingAddressTitle);
		if(!lblOrderDetailsBillingAddressTitle.getText().isEmpty()){
			reporter.reportLogPass("Billing address title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Billing address title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsBillingAddress);
		if(!lblOrderDetailsBillingAddress.getText().isEmpty()){
			reporter.reportLogPass("Billing address is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Billing address is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsPaymentMethodTitle);
		if(!lblOrderDetailsPaymentMethodTitle.getText().isEmpty()){
			reporter.reportLogPass("Payment method title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Payment method title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsPaymentMethod);
		if(!lblOrderDetailsPaymentMethod.getText().isEmpty()){
			reporter.reportLogPass("Payment method is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Payment method is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsOrderSummary);
		if(!lblOrderDetailsOrderSummary.getText().isEmpty()){
			reporter.reportLogPass("Order summary title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order summary title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubtotalTitle);
		if(!lblOrderDetailsSubtotalTitle.getText().isEmpty()){
			reporter.reportLogPass("SubTotal title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("SubTotal title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubtotal);
		if(!lblOrderDetailsSubtotal.getText().isEmpty()){
			reporter.reportLogPass("SubTotal is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("SubTotal is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsShippingAndHandlingTitle);
		if(!lblOrderDetailsShippingAndHandlingTitle.getText().isEmpty()){
			reporter.reportLogPass("ShippingAndHandling title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("ShippingAndHandling title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsShippingAndHandling);
		if(!lblOrderDetailsShippingAndHandling.getText().isEmpty()){
			reporter.reportLogPass("ShippingAndHandling is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("ShippingAndHandling is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsTaxesTitle);
		if(!lblOrderDetailsTaxesTitle.getText().isEmpty()){
			reporter.reportLogPass("Taxes title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Taxes title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsTaxes);
		if(!lblOrderDetailsTaxes.getText().isEmpty()){
			reporter.reportLogPass("Taxes is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Taxes is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsOrderTotalTitle);
		if(!lblOrderDetailsOrderTotalTitle.getText().isEmpty()){
			reporter.reportLogPass("Order total title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order total title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsOrderTotal);
		if(!lblOrderDetailsOrderTotal.getText().isEmpty()){
			reporter.reportLogPass("Order total is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Order total is not displaying correctly");
		}
	}

	/**
	 * To compare subTotal and order total
	 */
	public void verifySubTotalAndOrderTotal(){
		List<WebElement> lstItem=new ArrayList<>();
		lstItem.add(lblOrderDetailsSubtotal);
		lstItem.add(lblOrderDetailsShippingAndHandling);
		lstItem.add(lblOrderDetailsTaxes);

		boolean bEqual=this.checkDoubleEquation(lstItem,lblOrderDetailsOrderTotal);
		if(bEqual) {
			reporter.reportLogPass("The subTotal is equal to the order total");
		}
		else{
			reporter.reportLogFailWithScreenshot("The subTotal is not equal to the order total");
		}
	}

	/**
	 * To verify Order Modification And Order Returns Contents
	 */
	public void verifyOrderModificationAndOrderReturnsContents(){
		UnCollapsedAllOrderServiceItems();

		String lsText=null;
		WebElement item;
		for(int i=0;i<lstOrderServiceItemTitleLink.size();i++){
			item=lstOrderServiceItemTitleLink.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			if(!item.getAttribute("href").isEmpty()){
				reporter.reportLogPass("The header link of '"+lsText+"' is not empty");
			}
			else{
				reporter.reportLogFailWithScreenshot("The header link of '"+lsText+"' is empty");
			}

			item=lstOrderServiceItemContent.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The content of '"+lsText+"' is not empty");
			}
			else{
				reporter.reportLogFailWithScreenshot("The content of '"+lsText+"' is empty");
			}
		}
	}

	/**
	 * To verify Basic infomation of Account Settings section
	 * @param - lsExpectedEmail - SignIn Email address
	 */
	public void verifyBasicInfoInAccountSettingsSection(String lsExpectedEmail){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAccountSettingEmailTitle);
		if(!lblAccountSettingEmailTitle.getText().isEmpty()){
			reporter.reportLogPass("The Email title in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Email title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAccountSettingEmail);
		lsText=lblAccountSettingEmail.getText().trim();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Email in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Email in Account settings is not displaying correctly");
		}

		if(lsText.equalsIgnoreCase(lsExpectedEmail)){
			reporter.reportLogPass("The Email in Account settings is the same as the expected SignIn Email");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Email in Account settings is not the same as the expected SignIn Email");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAccountSettingPasswordTitle);
		if(!lblAccountSettingPasswordTitle.getText().isEmpty()){
			reporter.reportLogPass("The Password title in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Password title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAccountSettingPassword);
		if(!lblAccountSettingPassword.getText().isEmpty()){
			reporter.reportLogPass("The Password in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Password in Account settings is not displaying correctly");
		}

		String lsTestDevice = System.getProperty("Device").trim();
		if(lsTestDevice.equalsIgnoreCase("Mobile")) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAccountSettingPassword);
			if(!lblAccountSettingPassword.getText().isEmpty()){
				reporter.reportLogPass("The Password in Account settings is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Password in Account settings is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAccountSettingPasswordEdit);
		if(this.getReusableActionsInstance().isElementVisible(btnAccountSettingPasswordEdit)){
			reporter.reportLogPass("The Password Edit button in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Password Edit button in Account settings is not displaying correctly");
		}
	}

	/**
	 * To verify Change password content of Account Settings section
	 */
	public void verifyChangePasswordContentInAccountSettingsSection(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangePasswordSectionTitle);
		if(!lblChangePasswordSectionTitle.getText().isEmpty()){
			reporter.reportLogPass("The Change password section title in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Change password section title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangePasswordSectionTipMessage);
		if(!lblChangePasswordSectionTipMessage.getText().isEmpty()){
			reporter.reportLogPass("The Change password section tip message in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Change password section tip message in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangePasswordSectionCurrentPassword);
		if(!lblChangePasswordSectionCurrentPassword.getText().isEmpty()){
			reporter.reportLogPass("The current password title in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The current password title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionCurrentPassword);
		if(this.getReusableActionsInstance().isElementVisible(inputChangePasswordSectionCurrentPassword)){
			reporter.reportLogPass("The current password input field in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The current password input field in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordSectionCurrentPasswordShowButton);
		if(this.getReusableActionsInstance().isElementVisible(btnChangePasswordSectionCurrentPasswordShowButton)){
			reporter.reportLogPass("The current password show button in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The current password show button in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangePasswordSectionNewPassword);
		if(!lblChangePasswordSectionNewPassword.getText().isEmpty()){
			reporter.reportLogPass("The new password title in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The new password title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionNewPassword);
		if(this.getReusableActionsInstance().isElementVisible(inputChangePasswordSectionNewPassword)){
			reporter.reportLogPass("The new password input field in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The new password input field in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordSectionNewPasswordShowButton);
		if(this.getReusableActionsInstance().isElementVisible(btnChangePasswordSectionNewPasswordShowButton)){
			reporter.reportLogPass("The new password show button in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The new password show button in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangePasswordSectionReTypePassword);
		if(!lblChangePasswordSectionReTypePassword.getText().isEmpty()){
			reporter.reportLogPass("The Retype password title in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Retype password title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionReTypePassword);
		if(this.getReusableActionsInstance().isElementVisible(inputChangePasswordSectionReTypePassword)){
			reporter.reportLogPass("The Retype password input field in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Retype password input field in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordSectionReTypePasswordShowButton);
		if(this.getReusableActionsInstance().isElementVisible(btnChangePasswordSectionReTypePasswordShowButton)){
			reporter.reportLogPass("The Retype password show button in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Retype password show button in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordSubmit);
		if(this.getReusableActionsInstance().isElementVisible(btnChangePasswordSubmit)){
			reporter.reportLogPass("The Submit button for changing password is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Submit button for changing password is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordCancel);
		if(this.getReusableActionsInstance().isElementVisible(btnChangePasswordCancel)){
			reporter.reportLogPass("The Cancel button for changing password is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Cancel button for changing password is not displaying correctly");
		}
	}

	/**
	 * To change password function of Account Settings section
	 * @param - lsCurrentPassword - current password
	 * @param - bSubmit - true for clicking Submit button while false for clicking Cancel button
	 * @return - String -  changed password
	 */
	public String changePasswordFunctionInAccountSettingsSection(String lsCurrentPassword,boolean bSubmit){
		String lsChangedPassword=DataConverter.getSaltString(5,"stringType")+DataConverter.getSaltString(1,"numberType");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionCurrentPassword);
		inputChangePasswordSectionCurrentPassword.clear();
		inputChangePasswordSectionCurrentPassword.sendKeys(lsCurrentPassword);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionNewPassword);
		inputChangePasswordSectionNewPassword.clear();
		inputChangePasswordSectionNewPassword.sendKeys(lsChangedPassword);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionReTypePassword);
		inputChangePasswordSectionReTypePassword.clear();
		inputChangePasswordSectionReTypePassword.sendKeys(lsChangedPassword);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		String lsReturn;
		if(bSubmit){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordSubmit);
			this.getReusableActionsInstance().clickIfAvailable(btnChangePasswordSubmit);
			lsReturn=lsChangedPassword;
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordCancel);
			this.getReusableActionsInstance().clickIfAvailable(btnChangePasswordCancel);
			lsReturn=lsCurrentPassword;
		}

		waitForCondition(Driver->{return this.btnAccountSettingPasswordEdit.isDisplayed();},90000);

		return lsReturn;
	}

	/**
	 * To open Change Security Section
	 */
	public void openChangeSecuritySection(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAccountSettingSecurityQuestionEdit);
		this.getReusableActionsInstance().clickIfAvailable(btnAccountSettingSecurityQuestionEdit);

		this.waitForPageToLoad();
		//Keep it for scrolling window
		this.getReusableActionsInstance().staticWait(5*this.getStaticWaitForApplication());
	}

	/**
	 * To verify changing password function of Account Settings section with invalid value
	 * @param - String - lsCurrentPassword - current password
	 * @param - List<String> - lstPasswordErrorMessage
	 */
	public void VerifyChangePasswordFunctionInAccountSettingsSectionWithInvalidValue(String lsCurrentPassword,List<String> lstPasswordErrorMessage){
		String lsChangedPassword=DataConverter.getSaltString(5,"stringType")+DataConverter.getSaltString(1,"numberType");
		String lsInvalidCurrentPassword=lsCurrentPassword+"1";

		reporter.reportLog("Verify invalid current password");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionCurrentPassword);
		inputChangePasswordSectionCurrentPassword.clear();
		inputChangePasswordSectionCurrentPassword.sendKeys(lsInvalidCurrentPassword);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionNewPassword);
		inputChangePasswordSectionNewPassword.clear();
		inputChangePasswordSectionNewPassword.sendKeys(lsChangedPassword);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionReTypePassword);
		inputChangePasswordSectionReTypePassword.clear();
		inputChangePasswordSectionReTypePassword.sendKeys(lsChangedPassword);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordSubmit);
		this.getReusableActionsInstance().clickIfAvailable(btnChangePasswordSubmit);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstChangePasswordErrorMessage.get(0));
		String lsErrorMessage=this.lstChangePasswordErrorMessage.get(0).getText().trim();
		if(lsErrorMessage.equalsIgnoreCase(lstPasswordErrorMessage.get(0))){
			reporter.reportLogPass("Current password error message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Current password error message:'"+lsErrorMessage+"' is not matching the expected:'"+lstPasswordErrorMessage.get(0)+"'");
		}

		reporter.reportLog("Verify new password format error message and mismatching error message");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionCurrentPassword);
		inputChangePasswordSectionCurrentPassword.clear();
		inputChangePasswordSectionCurrentPassword.sendKeys(lsCurrentPassword);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionNewPassword);
		inputChangePasswordSectionNewPassword.clear();
		inputChangePasswordSectionNewPassword.sendKeys("11");
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionReTypePassword);
		inputChangePasswordSectionReTypePassword.click();
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstChangePasswordErrorMessage.get(0));
		lsErrorMessage=this.lstChangePasswordErrorMessage.get(0).getText().trim();
		if(lsErrorMessage.equalsIgnoreCase(lstPasswordErrorMessage.get(1))){
			reporter.reportLogPass("New password format error message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("New password format error message:'"+lsErrorMessage+"' is not matching the expected:'"+lstPasswordErrorMessage.get(1)+"'");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstChangePasswordErrorMessage.get(1));
		lsErrorMessage=this.lstChangePasswordErrorMessage.get(1).getText().trim();
		if(lsErrorMessage.equalsIgnoreCase(lstPasswordErrorMessage.get(2))){
			reporter.reportLogPass("New password mismatching error message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("New password mismatching error message:'"+lsErrorMessage+"' is not matching the expected:'"+lstPasswordErrorMessage.get(2)+"'");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstChangePasswordErrorMessage.get(2));
		lsErrorMessage=this.lstChangePasswordErrorMessage.get(2).getText().trim();
		if(lsErrorMessage.equalsIgnoreCase(lstPasswordErrorMessage.get(0))){
			reporter.reportLogPass("Incorrect password error message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Incorrect password error message:'"+lsErrorMessage+"' is not matching the expected:'"+lstPasswordErrorMessage.get(0)+"'");
		}
	}

	/**
	 * To verify Changing security question content of Account Settings section
	 */
	public void verifyChangeSecurityQuestionContentInAccountSettingsSection(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangeSecurityQuestionSectionTitle);
		if(!lblChangeSecurityQuestionSectionTitle.getText().isEmpty()){
			reporter.reportLogPass("The Change security question section title in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Change security question section title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangeSecurityQuestionSectionTipMessage);
		if(!lblChangeSecurityQuestionSectionTipMessage.getText().isEmpty()){
			reporter.reportLogPass("The Change security question section tip message in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Change security question section tip message in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangeSecurityQuestionSectionQuestionTitle);
		if(!lblChangeSecurityQuestionSectionQuestionTitle.getText().isEmpty()){
			reporter.reportLogPass("The Change Security Question Section Question Title in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Change Security Question Section Question Title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectChangeSecurityQuestionSectionQuestion);
		if(this.getReusableActionsInstance().isElementVisible(selectChangeSecurityQuestionSectionQuestion)){
			reporter.reportLogPass("The Change Security Question option list in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Change Security Question option list in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangeSecurityQuestionSectionAnswerTitle);
		if(!lblChangeSecurityQuestionSectionAnswerTitle.getText().isEmpty()){
			reporter.reportLogPass("The Change Security Question answer title in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Change Security Question answer title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangeSecurityQuestionSectionAnswer);
		if(this.getReusableActionsInstance().isElementVisible(inputChangeSecurityQuestionSectionAnswer)){
			reporter.reportLogPass("The Change Security Question answer field in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Change Security Question answer field in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeSecurityQuestionSubmit);
		if(this.getReusableActionsInstance().isElementVisible(btnChangeSecurityQuestionSubmit)){
			reporter.reportLogPass("The submit button in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The submit button in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeSecurityQuestionCancel);
		if(this.getReusableActionsInstance().isElementVisible(btnChangeSecurityQuestionCancel)){
			reporter.reportLogPass("The cancel button in Account settings is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The cancel button in Account settings is not displaying correctly");
		}
	}

	/**
	 * To changing security question function of Account Settings section
	 * @param - boolean  - bSubmit - true for clicking Submit button while false for clicking Cancel button
	 * @return - Map<String,Object> - contains selected index and answer
	 */
	public Map<String,Object> changeSecurityQuestionFunctionInAccountSettingsSection(boolean bSubmit){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectChangeSecurityQuestionSectionQuestion);
		Select select=new Select(selectChangeSecurityQuestionSectionQuestion);
		int count=select.getOptions().size();

		Random rand = new Random();
		int randomNumber = rand.nextInt(count-1)+1;

		String lsOption;
		select.selectByIndex(randomNumber);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangeSecurityQuestionSectionAnswer);
		lsOption=select.getFirstSelectedOption().getText();
		String lsAnswer;
		if(lsOption.contains("born")){
			lsAnswer="1950";
		}
		else{
			lsAnswer="Answer";
		}
		inputChangeSecurityQuestionSectionAnswer.clear();
		inputChangeSecurityQuestionSectionAnswer.sendKeys(lsAnswer);

		if(bSubmit){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeSecurityQuestionSubmit);
			this.getReusableActionsInstance().clickIfAvailable(btnChangeSecurityQuestionSubmit);
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeSecurityQuestionCancel);
			this.getReusableActionsInstance().clickIfAvailable(btnChangeSecurityQuestionCancel);
		}
		this.waitForPageToLoad();
		//Keep it for scrolling window
		this.getReusableActionsInstance().staticWait(5*this.getStaticWaitForApplication());

		Map<String,Object> map=new HashMap<>();
		if(bSubmit){
			map.put("SelectedIndex",randomNumber);
			map.put("Answer",lsAnswer);
		}
		else{
			map.put("SelectedIndex",0);
			map.put("Answer","");
		}

		return map;
	}

	/**
<<<<<<< HEAD
	 * To verify changing security question error message
	 */
	public void verifyChangeSecurityQuestionErrorMessage(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectChangeSecurityQuestionSectionQuestion);
		Select select=new Select(selectChangeSecurityQuestionSectionQuestion);
		int count=select.getOptions().size();

		String lsOption,lsErrorMessage;
		for(int i=1;i<count;i++){
			select.selectByIndex(i);
			this.getReusableActionsInstance().staticWait(300);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangeSecurityQuestionSectionAnswer);
			inputChangeSecurityQuestionSectionAnswer.clear();
			inputChangeSecurityQuestionSectionAnswer.sendKeys("aa");
			this.getReusableActionsInstance().staticWait(300);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangeSecurityQuestionsErrorMessage);
			lsErrorMessage=lblChangeSecurityQuestionsErrorMessage.getAttribute("value").trim();

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectChangeSecurityQuestionSectionQuestion);
			lsOption=select.getFirstSelectedOption().getText();

			reporter.reportLog("Verify error message for '"+lsOption+"'");
			if(!lsErrorMessage.isEmpty()){
				reporter.reportLogPass("The error message:"+lsErrorMessage+" is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The error message is not displaying correctly");
			}
		}
	}

	/**
	 * To verify landing view content
	 */
	public void verifyLandingViewContent(){
		List<WebElement> lstSubItem;
		String lsText;
		for(WebElement item:lstAccountSummaryPanelList){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			reporter.reportLog("Verify header of '"+lsText+"'");
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The Header of '"+lsText+"' is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Header of '"+lsText+"' is not displaying correctly");
			}
			lstSubItem=item.findElements(bySubList);
			for(WebElement subItem:lstSubItem){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				lsText=subItem.getText().trim();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The sub item of '"+lsText+"' is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The sub item of '"+lsText+"' is not displaying correctly");
				}
			}
		}
	}

	/**
	 * This function verifies Gift Card Error Messages
	 */
	public void verifyGiftCardErrorMessage(String giftCardNumber, String errorType, String errorMessage){
		String fetchedErrorMessage = null;
		if(errorType.toLowerCase().contains("number")){
			this.lblGiftCardNumberEntryTextBox.sendKeys("1234");
			getReusableActionsInstance().clickIfAvailable(this.lblGiftCardPinEntryTextBox);
			fetchedErrorMessage = this.lblErrorMessageForInvalidCreditCardNumber.get(0).getText().trim();
		}else if(errorType.toLowerCase().contains("pin")){
			this.lblGiftCardNumberEntryTextBox.sendKeys(giftCardNumber);
			this.lblGiftCardPinEntryTextBox.sendKeys("12");
			getReusableActionsInstance().clickIfAvailable(this.lblGiftCardNumberEntryTextBox);
			fetchedErrorMessage = this.lblErrorMessageForInvalidCreditCardNumber.get(1).getText().trim();
		}

		if(fetchedErrorMessage.equalsIgnoreCase(errorMessage))
			reporter.reportLogPassWithScreenshot("Error Message for invalid type: "+errorType+" is same as expected: "+fetchedErrorMessage);
		else
			reporter.reportLogFailWithScreenshot("Error Message for invalid type: "+errorType+" is "+fetchedErrorMessage+" and not same as expected: "+errorMessage);
	}

}

