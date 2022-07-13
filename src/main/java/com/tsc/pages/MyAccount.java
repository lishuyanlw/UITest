package com.tsc.pages;

import com.tsc.api.util.DataConverter;
import com.tsc.pages.base.BasePage;
import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
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

	@FindBy(xpath="//ng-component//*[@class='paymentPageTitle']")
	public WebElement lblPageTitle;

	//Navigation breadcrumb
	@FindBy(xpath = "//ng-component//div[contains(@class,'go-back')]//ol[@class='breadcrumb']//li//a")
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

	//PAYMENT OPTIONS - ADD NEW CREDIT CARD
	@FindBy(xpath="//div[@data-target='#paymentOptionsLinks']")
	public WebElement btnPaymentOptionsHeadingTitle;

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
	public WebElement lblCardNumberForNewTSCCreditCard;

	@FindBy(xpath="//ul[@class='list-inline']//li/button[contains(@class,'active')]/img")
	public WebElement lblSelectedNewCreditCardToBeAdded;

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

	@FindBy(xpath="//div[@class='bigPaymentDiv']/div[contains(@class,'col')]")
	public List<WebElement> lstTotalCardsPresent;

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

	//For Your Addresses
	@FindBy(xpath = "//ng-component//*[contains(@class,'paymentPageTitle')]")
	public WebElement lblYourAddressTitle;

	@FindBy(xpath = "//ng-component//div[normalize-space(.)='Shipping Address']")
	public WebElement lblShippingAddressSectionTitle;

	/**
	@FindBy(xpath = "//ng-component//div[contains(@class,'bigAddressDiv') and not(contains(@class,'billing'))]//div[contains(@class,'tab-bottom-row')]")
	public List<WebElement> lstShippingAddressContainer;
	*/

	@FindBy(xpath = "//ng-component//div[contains(@class,'bigAddressDiv') and not(contains(@class,'billing'))]//div[contains(@class,'desktop-bottom-row')]")
	public List<WebElement> lstShippingAddressContainer;

	public By byShippingAddressTitle=By.xpath(".//div[contains(@class,'defaultDiv')]");
	public By byShippingAddress=By.xpath(".//div[contains(@class,'defaultDiv')]/following-sibling::div[contains(@class,'address')]");
	public By byShippingAddressEdit=By.xpath(".//div[contains(@class,'defaultDiv')]/following-sibling::div//a");

	@FindBy(xpath = "//ng-component//button[contains(normalize-space(.),'Add An Address')]")
	public WebElement btnAddAddress;

	@FindBy(xpath = "//ng-component//span[contains(normalize-space(text()),'Billing Address')]")
	public WebElement lblBillingAddressTitle;

	@FindBy(xpath = "//ng-component//div[contains(@class,'billingAddressDesktopDiv')]//div[contains(@class,'address')]")
	public WebElement lblBillingAddress;

	@FindBy(xpath = "//ng-component//div[contains(@class,'billingAddressDesktopDiv')]//div[contains(@class,'address')]/parent::div/following-sibling::div//a")
	public WebElement lnkBillingAddressEdit;

	//Edit or Add address
	@FindBy(xpath = "//ng-component//h3[contains(@class,'paymentPageTitle')]")
	public WebElement lblAddOrEditAddressTitle;

	@FindBy(xpath = "//ng-component//div[contains(@class,'notes')]")
	public WebElement lblAddOrEditAddressRequiredInfoTitle;

	@FindBy(xpath = "//form[contains(@class,'update-address-form')]//div[@class='text-danger']")
	public WebElement lblAddOrEditAddressExistingErrorMessage;

	@FindBy(xpath = "//ng-component//label[@for='firstName']")
	public WebElement lblAddOrEditAddressFirstNameTitle;

	@FindBy(xpath = "//ng-component//input[@id='firstName']")
	public WebElement inputAddOrEditAddressFirstName;

	@FindBy(xpath = "//ng-component//label[@for='lastName']")
	public WebElement lblAddOrEditAddressLastNameTitle;

	@FindBy(xpath = "//ng-component//input[@id='lastName']")
	public WebElement inputAddOrEditAddressLastName;

	@FindBy(xpath = "//ng-component//label[contains(normalize-space(.),'Phone Number')]")
	public WebElement lblAddOrEditAddressPhoneNumberTitle;

	@FindBy(xpath = "//ng-component//input[@formcontrolname='phoneNumber1']")
	public WebElement inputAddOrEditAddressPhoneNumber1;

	@FindBy(xpath = "//ng-component//input[@formcontrolname='phoneNumber2']")
	public WebElement inputAddOrEditAddressPhoneNumber2;

	@FindBy(xpath = "//ng-component//input[@formcontrolname='phoneNumber3']")
	public WebElement inputAddOrEditAddressPhoneNumber3;

	@FindBy(xpath = "//ng-component//div[@class='tsc-checkbox']//input[@id='makeDefaultShippingAddress']")
	public WebElement ckbAddOrEditMakeDefaultShippingAddress;

	@FindBy(xpath = "//ng-component//div[@class='tsc-checkbox']//label[@for='makeDefaultShippingAddress']")
	public WebElement labelAddOrEditMakeDefaultShippingAddress;

	@FindBy(xpath = "//ng-component//div[@class='tsc-checkbox']//input[@id='makeDefaultShippingAddress']/parent::div/following-sibling::span[contains(@class,'notes')]")
	public WebElement lblAddOrEditMakeDefaultShippingAddress;

	@FindBy(xpath = "//ng-component//div[@class='tsc-checkbox']//input[@id='makeShippingAsBillingAddress']")
	public WebElement ckbAddOrEditMakeShippingAsBillingAddress;

	@FindBy(xpath = "//ng-component//div[@class='tsc-checkbox']//label[@for='makeShippingAsBillingAddress']")
	public WebElement labelAddOrEditMakeShippingAsBillingAddress;

	@FindBy(xpath = "//ng-component//div[@class='tsc-checkbox']//input[@id='makeShippingAsBillingAddress']/parent::div/following-sibling::span[contains(@class,'notes')]")
	public WebElement lblAddOrEditMakeShippingAsBillingAddress;

	@FindBy(xpath = "//ng-component//label[@for='addressLine1']")
	public WebElement lblAddOrEditAddressLine1Title;

	@FindBy(xpath = "//ng-component//p-autocomplete//input")
	public WebElement inputAddOrEditAddressLine1;

	@FindBy(xpath = "//ng-component//div[contains(@class,'ui-autocomplete-panel')]")
	public WebElement cntAddOrEditAddressAutoSearch;

	@FindBy(xpath = "//ng-component//div[contains(@class,'ui-autocomplete-panel')]//li")
	public List<WebElement> lstAddOrEditAddressAutoSearchDropdownItems;

	@FindBy(xpath = "//ng-component//label[@for='addressLine2']")
	public WebElement lblAddOrEditAddressLine2Title;

	@FindBy(xpath = "//ng-component//input[@id='addressLine2']")
	public WebElement inputAddOrEditAddressLine2;

	@FindBy(xpath = "//ng-component//label[@for='city']")
	public WebElement lblAddOrEditAddressCityTitle;

	@FindBy(xpath = "//ng-component//input[@id='city']")
	public WebElement inputAddOrEditAddressCity;

	@FindBy(xpath = "//ng-component//label[@for='province']")
	public WebElement lblAddOrEditAddressProvinceTitle;

	@FindBy(xpath = "//ng-component//select[@id='province']")
	public WebElement selectAddOrEditAddressProvince;

	@FindBy(xpath = "//ng-component//label[contains(normalize-space(.),'Postal Code')]")
	public WebElement lblAddOrEditAddressPostalCodeTitle;

	@FindBy(xpath = "//ng-component//input[@formcontrolname='postalCode1']")
	public WebElement inputAddOrEditAddressPostalCode1;

	@FindBy(xpath = "//ng-component//input[@formcontrolname='postalCode2']")
	public WebElement inputAddOrEditAddressPostalCode2;

	@FindBy(xpath = "//ng-component//button[contains(normalize-space(.),'Cancel')]")
	public WebElement btnCancel;

	@FindBy(xpath = "//ng-component//button[@type='submit']")
	public WebElement btnSave;

	//For My Easy Pay Schedule
	@FindBy(xpath = "//ng-component//h3[@class='paymentPageTitle']")
	public WebElement lblUpComingEasyPaymentTitle;

	@FindBy(xpath = "//ng-component//div[contains(@class,'easyPayRow')]//span[contains(normalize-space(text()),'No Upcoming Easy Pay Payment')]")
	public WebElement lblNoUpComingPayment;

	@FindBy(xpath = "//ng-component//div[contains(@class,'easyPayRow')]//div[contains(normalize-space(.),'Learn about EASY PAY')]")
	public WebElement lblLearnAboutEasyPayTitle;

	@FindBy(xpath = "//ng-component//div[contains(@class,'easyPayRow')]//div[contains(normalize-space(.),'Learn about EASY PAY')]/following-sibling::div")
	public WebElement lblLearnAboutEasyPay;

	//For favourite part
	@FindBy(xpath = "//ng-component//div[contains(@class,'tsc-forms')]")
	public WebElement cntMyFavouritesContainer;

	@FindBy(xpath = "//ng-component//div[@class='recently-viewed-title']")
	public WebElement lblMyFavouritesTitle;

	//Favorite history available
	@FindBy(xpath = "//ng-component//button[contains(@class,'btn-clear-viewing-history')]")
	public WebElement btnClearAllFavouriteHistory;

	@FindBy(xpath = "//ng-component//div[@class='recently-viewed-container']//div[contains(@class,'recently-viewed-item-container')]//a")
	public List<WebElement> lstFavouriteProduct;

	public By byFavoriteItemImage=By.xpath(".//div[@class='on-air-prod-img']//img");
	public By byFavoriteItemName=By.xpath(".//div[@class='on-air-prod-name']");
	public By byFavoriteItemPriceContainer=By.xpath(".//div[@class='on-air-price-blk']");
	public By byFavoriteItemNowPrice=By.xpath(".//div[@class='on-air-price-blk']//span[@class='on-air-prod-price']");
	public By byFavoriteItemWasPrice=By.xpath(".//div[@class='on-air-price-blk']//span[@class='on-air-prod-was-price']");

	//Favorite history not available
	@FindBy(xpath = "//ng-component//div[contains(@class,'no-history-container')]//div[contains(@class,'no-history-msg')]")
	public List<WebElement> lstNoHistoryMessage;

	@FindBy(xpath = "//ng-component//div[contains(@class,'no-history-container')]//div[contains(@class,'btn-shop-now')]")
	public WebElement btnShoppingNow;

	//The popup window after clicking ClearAllFavouriteHistory button
	@FindBy(xpath = "//ng-component//div[@class='modal-dialog']//div[@class='modal-header']//button[@class='close']")
	public WebElement btnCloseButtonInClearMyFavouritesPopupWindow;

	@FindBy(xpath = "//ng-component//div[@class='modal-dialog']//div[@class='modal-header']//div[@class='crv-title']")
	public WebElement lblTitleInClearMyFavouritesPopupWindow;

	@FindBy(xpath = "//ng-component//div[@class='modal-dialog']//div[@class='modal-body']//div[@class='crv-warning']")
	public WebElement lblWarningMessageInClearMyFavouritesPopupWindow;

	@FindBy(xpath = "//ng-component//div[@class='modal-dialog']//div[@class='crv-btn-block']//button[contains(@class,'btnResizing') and not(contains(@class,'btn-negative'))]")
	public WebElement btnClearInClearMyFavouritesPopupWindow;

	@FindBy(xpath = "//ng-component//div[@class='modal-dialog']//div[@class='crv-btn-block']//button[contains(@class,'btnResizing') and contains(@class,'btn-negative')]")
	public WebElement btnCancelInClearMyFavouritesPopupWindow;

	//For Recently Viewed
	@FindBy(xpath = "//ng-component//div[contains(@class,'recently-viewed-title-block')]//div[contains(@class,'form-head')]")
	public WebElement cntRecentlyViewedTitleContainer;

	@FindBy(xpath = "//ng-component//div[@class='recently-viewed-title']")
	public WebElement lblRecentlyViewedTitle;

	@FindBy(xpath = "//ng-component//div[@class='no-history-msg']")
	public List<WebElement> lstRecentlyViewedNoHistoryMessage;

	@FindBy(xpath = "//ng-component//a[contains(@class,'btn-shop-now')]")
	public WebElement lnkRecentlyViewedShopNow;

	@FindBy(xpath = "//ng-component//div[contains(@class,'recently-viewed-container')]//div[contains(@class,'recently-viewed-item-container')]")
	public List<WebElement> lstRecentlyViewedItemContainerList;

	public By byRecentlyViewedItemLink=By.xpath(".//a");
	public By byRecentlyViewedItemImage=By.xpath(".//div[@class='on-air-prod-img']//img");
	public By byRecentlyViewedItemName=By.xpath(".//div[@class='on-air-prod-name']");
	public By byRecentlyViewedItemPriceContainer=By.xpath(".//div[@class='on-air-price-blk']");
	public By byRecentlyViewedItemNowPrice=By.xpath(".//div[@class='on-air-price-blk']//span[@class='on-air-prod-price']");
	public By byRecentlyViewedItemWasPrice=By.xpath(".//div[@class='on-air-price-blk']//span[@class='on-air-prod-was-price']");
	public By byRecentlyViewedItemEasyPayment=By.xpath(".//span[@class='or-payments']");
	public By byRecentlyViewedItemReviewRateStarList=By.xpath(".//div[@class='pr-rating-stars']//div[contains(@class,'pr-star-v4')]");
	public By byRecentlyViewedItemReviewAmount=By.xpath(".//div[contains(@class,'pr-category-snippet__total')]");

	//The same popup window as clear favorite history after clicking
	@FindBy(xpath = "//ng-component//div[contains(@class,'recently-viewed-title-block')]//button[contains(@class,'btn-clear-viewing-history')]")
	public WebElement btnClearViewingHistory;

	//For My Newsletter
	@FindBy(xpath = "//label[@for='MyNewsletters']/b")
	public WebElement lblMyNewsLettersTitle;

	@FindBy(xpath = "//span[contains(normalize-space(text()),'Manage your email preferences below:')]")
	public WebElement lblMyNewsLettersManageYourEmailPreferences;

	@FindBy(xpath = "//input[@id='TSnwsl']")
	public WebElement ckbMyNewsLettersTodayShowStopperNewsLetter;

	@FindBy(xpath = "//input[@id='TSnwsl']/parent::td/following-sibling::td//label")
	public WebElement lblMyNewsLettersTodayShowStopperNewsLetterTitle;

	@FindBy(xpath = "//input[@id='SOnwsl']")
	public WebElement ckbMyNewsLettersSpecialOfferAndEventNewsLetter;

	@FindBy(xpath = "//input[@id='SOnwsl']/parent::td/following-sibling::td//label")
	public WebElement lblMyNewsLettersSpecialOfferAndEventNewsLetterTitle;

	@FindBy(xpath = "//input[@id='SAOnwsl']")
	public WebElement ckbMyNewsLettersPreferredCustomerOffer;

	@FindBy(xpath = "//input[@id='SAOnwsl']/parent::td/following-sibling::td//label")
	public WebElement lblMyNewsLettersPreferredCustomerOfferTitle;

	@FindBy(xpath = "//input[@id='AUAnwsl']")
	public WebElement ckbMyNewsLettersProductUpdatesAndAlerts;

	@FindBy(xpath = "//input[@id='AUAnwsl']/parent::td/following-sibling::td//label")
	public WebElement lblMyNewsLettersProductUpdatesAndAlertsTitle;

	@FindBy(xpath = "//input[@id='btnUpdatePrefs']")
	public WebElement btnMyNewsLettersUpdatePrefs;

	@FindBy(xpath = "//input[@id='Unsub']")
	public WebElement ckbMyNewsLettersUnsubscribe;

	@FindBy(xpath = "//td[normalize-space(.)='Unsubscribe']")
	public WebElement lblMyNewsLettersUnsubscribeTitle;

	@FindBy(xpath = "//span[contains(normalize-space(text()),'Unsubscribe from all TSC emails.')]")
	public WebElement lblMyNewsLettersUnsubscribeDescription;

	@FindBy(xpath = "//input[@id='btnUnSub']")
	public WebElement btnMyNewsLettersUnsubscribe;

	@FindBy(xpath = "//iFrame[@id='ifrmEmailSignup']")
	public WebElement iFrameEmailSignup;

	@FindBy(xpath = "//div[@id='bodycontent']")
	public WebElement lblSubscriptionSuccessMessage;


	/**
	 * To get header item web element through header item text
	 * @param - lsHeaderItem -  header item text
	 * @return header Item web element
	 */
	public WebElement getHeaderItem(String lsHeaderItem){
		String lsByHeaderItem="//div[@class='my-account-summary-container']//div[@class='panel']/div[contains(@class,'panel-heading') and contains(normalize-space(.),'"+lsHeaderItem+"')]";
		return this.getDriver().findElement(By.xpath(lsByHeaderItem));
	}

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
		for(int i=0;i<this.lstOrderServiceItemTitleLink.size();i++){
			final int tempIndex=i;
			if(!this.lstOrderServiceItemTitleLink.get(i).getAttribute("class").isEmpty()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(lstOrderServiceItemTitleLink.get(i));
				this.clickWebElementUsingJS(lstOrderServiceItemTitleLink.get(i));
				//this.getReusableActionsInstance().clickIfAvailable(lstOrderServiceItemTitleLink.get(i));
				this.waitForCondition(Driver->{
					return lstOrderServiceItemTitleLink.get(tempIndex).getAttribute("class").isEmpty();},20000);
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
		String lsTestDevice = System.getProperty("Device").trim();
		String lsTestBrowser= System.getProperty("Browser").toLowerCase().trim();
		if(lsTestDevice.equalsIgnoreCase("Mobile")||(lsTestDevice.equalsIgnoreCase("Tablet")&&lsTestBrowser.contains("android"))||System.getProperty("chromeMobileDevice").contains("iPad")) {
			if(this.btnPaymentOptionsHeadingTitle.getAttribute("class").contains("collapsed")){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnPaymentOptionsHeadingTitle);
				this.getReusableActionsInstance().clickIfAvailable(this.btnPaymentOptionsHeadingTitle);
				this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());
			}
		}

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
			String pageTitle = this.lblPageTitle.getText();
			if(pageTitle.toLowerCase().contains("manage"))
				waitForCondition(Driver->{return this.lstCreditCardsPresent.size()>=0;},6000);
			else if(pageTitle.toLowerCase().contains("add"))
				waitForCondition(Driver->{return (this.btnCancelAddCreditCardForNewCreditCard.isEnabled() &&
					this.btnCancelAddCreditCardForNewCreditCard.isDisplayed());},6000);
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
	public void addNewOrEditExistingCreditCardNumber(String cardType, String cardNumber, boolean isNewCard){
		this.waitForPageToLoad();
		String selectedCreditCardType = this.getChildElementAttribute(this.lblSelectedNewCreditCardToBeAdded,"alt");
		if(isNewCard)
			getDriver().switchTo().frame(iFrameForNewCreditCard);
		else if(!selectedCreditCardType.toLowerCase().contains("tsc"))
			getDriver().switchTo().frame(iFrameForNewCreditCard);

		if(!selectedCreditCardType.toLowerCase().contains("tsc")){
			waitForCondition(Driver->{return this.lblCardNumberForNewCreditCard.isEnabled() &&
					this.lblCardNumberForNewCreditCard.isDisplayed();},15000);
			//Adding Credit Card Number
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCardNumberForNewCreditCard);
			this.clickWebElementUsingJS(this.lblCardNumberForNewCreditCard);
			this.lblCardNumberForNewCreditCard.sendKeys(cardNumber);
		}else{
			waitForCondition(Driver->{return this.lblCardNumberForNewTSCCreditCard.isEnabled() &&
					this.lblCardNumberForNewTSCCreditCard.isDisplayed();},15000);
			//Adding Credit Card Number
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCardNumberForNewTSCCreditCard);
			this.clickWebElementUsingJS(this.lblCardNumberForNewTSCCreditCard);
			this.lblCardNumberForNewTSCCreditCard.sendKeys(cardNumber);
		}

		//Using static wait of 5 seconds here as wait for condition is throwing target frame detached error
		getReusableActionsInstance().staticWait(5000);
		//waitForCondition(Driver->{return !this.getChildElementAttribute(this.getLblMaskedCardNumberForNewCreditCard,"value").isEmpty();},10000);
		if(isNewCard)
			getDriver().switchTo().defaultContent();
		else if(!selectedCreditCardType.toLowerCase().contains("tsc"))
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
		Map<String,String> cardData = this.getNewCardExpirationData(2,2);

		waitForCondition(Driver->{return cardTypeElement.isDisplayed() && cardTypeElement.isEnabled();},5000);
		this.clickWebElementUsingJS(cardTypeElement);

		if(!cardType.equalsIgnoreCase("tsc")){
			this.addNewOrEditExistingCreditCardNumber(cardType,cardNumber,true);
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
		String lastDigitsOfCard = webElement.getText().split("\\s+")[2];
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
							this.getReusableActionsInstance().javascriptScrollByVisibleElement(removeButtonWebElement);
							this.getReusableActionsInstance().clickIfAvailable(removeButtonWebElement);
							//this.clickElement(removeButtonWebElement);
							waitForCondition(Driver->{return this.btnRemoveCreditCardButton.isDisplayed() &&
									this.btnRemoveCreditCardButton.isEnabled();},6000);
						}else{
							editButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')]"));
							this.getReusableActionsInstance().javascriptScrollByVisibleElement(editButtonWebElement);
							this.getReusableActionsInstance().clickIfAvailable(editButtonWebElement);
							//this.clickElement(editButtonWebElement);
							waitForCondition(Driver->{return this.btnSaveAddCreditCardForNewCreditCard.isDisplayed() &&
									this.btnSaveAddCreditCardForNewCreditCard.isEnabled();},6000);
						}
						break;
					}
				}
			}else if(cardType.toLowerCase().contains("tsc")){
				if(selectForRemove){
					removeButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallLeftPadding')]/a[contains(@class,'negative')]"));
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(removeButtonWebElement);
					this.getReusableActionsInstance().clickIfAvailable(removeButtonWebElement);
					//this.clickElement(removeButtonWebElement);
					waitForCondition(Driver->{return this.btnRemoveCreditCardButton.isDisplayed() &&
							this.btnRemoveCreditCardButton.isEnabled();},6000);
				}else{
					editButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')]"));
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(editButtonWebElement);
					this.getReusableActionsInstance().clickIfAvailable(editButtonWebElement);
					//this.clickElement(editButtonWebElement);
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
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnRemoveCreditCardButton);
			this.getReusableActionsInstance().clickIfAvailable(this.btnRemoveCreditCardButton);
			//this.clickElement(this.btnRemoveCreditCardButton);
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCancelRemoveCreditCardButton);
			this.getReusableActionsInstance().clickIfAvailable(this.btnCancelRemoveCreditCardButton);
			//this.clickElement(this.btnCancelRemoveCreditCardButton);
		}

		//Verification that card is removed
		//Applying static wait for 5 seconds as application takes time to refresh and there is no unique element for wait for condition to be used
		getReusableActionsInstance().staticWait(5000);
		//Subtracting 1 from size as we are including 'Add Credit Card' xpath as well for decreasing execution time
		int afterDeleteCreditCardsPresent = lstTotalCardsPresent.size()-1;
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
			//String cardTypeAdded = this.getCreditCardTypeName(cardData.get("cardType"));
			JSONObject creditCard = (JSONObject) creditCardsData.get(cardData.get("cardType"));
			cardNumber = creditCard.get("Number").toString();
			cardData.put("cardNumber",cardNumber);
		}
		this.addNewOrEditExistingCreditCardNumber(cardType,cardNumber,false);

		if(expirationMonthAndYear!=null){
			String[] expirationData = expirationMonthAndYear.split("/");
			int updatedMonth = Integer.valueOf(expirationData[0])+1 > 12 ? (Integer.valueOf(expirationData[0]) + 1) - 12 : Integer.valueOf(expirationData[0])+1;
			int updatedYear = Integer.valueOf(expirationData[1])+1;
			cardData.put("expirationMonth",String.valueOf(updatedMonth));
			cardData.put("expirationYear",String.valueOf(updatedYear));
		}
		if(!cardData.get("cardType").toLowerCase().contains("tsc")){
			this.addExpirationMonthAndYear(cardData);
			this.waitForPageToLoad();
		}
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSaveAddCreditCardForNewCreditCard);

		if(editCard){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSaveAddCreditCardForNewCreditCard);
			this.getReusableActionsInstance().clickIfAvailable(this.btnSaveAddCreditCardForNewCreditCard);
			//this.clickElement(this.btnSaveAddCreditCardForNewCreditCard);
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCancelAddCreditCardForNewCreditCard);
			this.getReusableActionsInstance().clickIfAvailable(this.btnCancelAddCreditCardForNewCreditCard);
			//this.clickElement(this.btnCancelAddCreditCardForNewCreditCard);
		}

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
		this.waitForCondition(Driver->{return lstCreditCardsPresent.size()>0;},10000);
		//Fetching Card Details to be edited to be used for verification
		WebElement cardTypeWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardTypeWebElement);
		String cardType = cardTypeWebElement.getText();
		WebElement cardDisplayTypeWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardDisplayTypeWebElement);
		String cardDisplayName = cardDisplayTypeWebElement.getText();
		if(!cardType.toLowerCase().contains("tsc")) {
			WebElement expiresOnWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//div[@class='table-cell']"));
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(expiresOnWebElement);
			String[] expiresOnData = expiresOnWebElement.getText().split(":")[1].split("/");

			updatedMonth = Integer.valueOf(expiresOnData[0].trim())+1 > 12 ? String.valueOf((Integer.valueOf(expiresOnData[0].trim()) + 1) - 12) : String.valueOf(Integer.valueOf(expiresOnData[0].trim())+1);
			if(updatedMonth.length()==1)
				updatedMonth = "0"+updatedMonth;
			Map<String,String> updatedYearData = getNewCardExpirationData(2,2);
			updatedYear = updatedYearData.get("expirationYear");
			actualExpirationMonth = expiresOnData[0].trim();
			actualExpirationYear = expiresOnData[1].trim();

			creditCardDisplayedData.put("cardType", this.getCreditCardTypeName(cardType));
			creditCardDisplayedData.put("cardDisplayName", cardDisplayName);
			creditCardDisplayedData.put("expirationMonth", updatedMonth);
			creditCardDisplayedData.put("expirationYear", updatedYear);
			creditCardDisplayedData.put("actualExpirationMonth", actualExpirationMonth);
			creditCardDisplayedData.put("actualExpirationYear", actualExpirationYear);
			creditCardDisplayedData.put("expirationMonthAndYear",actualExpirationMonth+"/"+actualExpirationYear);
		}else{
			creditCardDisplayedData.put("cardType", "tsc");
			creditCardDisplayedData.put("cardDisplayName", cardDisplayName);
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
	 * @param - lsHeaderItem - header item name
	 * @param - lsSubItem - sub item name
	 * @param - loadingIndicator - the element to indicate window loading
	 */
	public int openSubItemWindow(String lsHeaderItem,String lsSubItem,WebElement loadingIndicator){
		String lsTestDevice = System.getProperty("Device").trim();
		String lsTestBrowser= System.getProperty("Browser").toLowerCase().trim();
		if(lsTestDevice.equalsIgnoreCase("Mobile")||(lsTestDevice.equalsIgnoreCase("Tablet")&&lsTestBrowser.contains("android"))||System.getProperty("chromeMobileDevice").contains("iPad")) {
			WebElement headerButton=this.getHeaderItem(lsHeaderItem);
			if(headerButton.getAttribute("class").contains("collapsed")){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(headerButton);
				this.getReusableActionsInstance().clickIfAvailable(headerButton);
				this.getReusableActionsInstance().staticWait(6*this.getStaticWaitForApplication());
			}
		}

		WebElement subButton=this.getSubItem(lsSubItem);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(subButton);
		int count=0;
		String lsText=subButton.getText();
		if(lsText.contains("(")){
			count=this.getIntegerFromString(lsText);
		}

		if(this.getReusableActionsInstance().isElementVisible(subButton)){
			reporter.reportLogPass("'"+lsSubItem+ "' sub item is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("'"+lsSubItem+ "' sub item is not displaying correctly");
		}
		this.getReusableActionsInstance().clickIfAvailable(subButton);

		this.getReusableActionsInstance().staticWait(5*this.getStaticWaitForApplication());
		if(loadingIndicator!=null){
			this.waitForCondition(Driver->{return loadingIndicator.isDisplayed();},50000);
		}

		return count;
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
		WebElement upperNavigationElement=this.lstNavigationCrumbList.get(this.lstNavigationCrumbList.size()-2);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(upperNavigationElement);
		this.getReusableActionsInstance().clickIfAvailable(upperNavigationElement);

		this.getReusableActionsInstance().staticWait(5*this.getStaticWaitForApplication());
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
				//reporter.reportLogPass("The content of '"+lsText+"' is not empty");
				reporter.reportLogPass("The content is not empty as expected!");
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

		String lsTestDevice = System.getProperty("Device").trim();
		String lsTestBrowser= System.getProperty("Browser").toLowerCase().trim();
		if(!(lsTestDevice.equalsIgnoreCase("Mobile") ||
				(System.getProperty("Device").contains("Tablet") && System.getProperty("Browser").contains("android")) ||
				(System.getProperty("Browser").equalsIgnoreCase("chromemobile") &&
						System.getProperty("Device").contains("Tablet") &&
						!System.getProperty("chromeMobileDevice").contains("iPad")))) {
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
		this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());
		inputChangeSecurityQuestionSectionAnswer.sendKeys(lsAnswer);

		if(bSubmit){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeSecurityQuestionSubmit);
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			this.getReusableActionsInstance().clickIfAvailable(btnChangeSecurityQuestionSubmit);
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeSecurityQuestionCancel);
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			this.clickWebElementUsingJS(btnChangeSecurityQuestionCancel);
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

	public boolean verifyMinimumOneCardIsPresentForUser(){
		String titleText = this.lblPageTitle.getText();
		if(titleText.toLowerCase().contains("manage") && this.lstCreditCardsPresent.size()>0)
			return true;
		if(titleText.toLowerCase().contains("add"))
			return false;
		return true;
	}

	/**
	 * This method will check no-history-container Existing
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkNoFavoriteHistoryContainerExisting() {
		return this.checkChildElementExistingByAttribute(this.cntMyFavouritesContainer, "class", "no-history-container");
	}

	/**
	 * To clear favorite history
	 * @param - boolean - bFromFavoriteLinkOnHeaderMenu - if clicking favorite link on header menu
	 */
	public void clearFavoriteHistory(boolean bFromFavoriteLinkOnHeaderMenu) {
		if(bFromFavoriteLinkOnHeaderMenu){
			WebElement favoriteLink= (new GlobalHeaderPage(this.getDriver())).Favouriteslnk;
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(favoriteLink);
			this.getReusableActionsInstance().clickIfAvailable(favoriteLink);
			this.getReusableActionsInstance().waitForElementVisibility(this.lblMyFavouritesTitle, 20);
		}

		if(checkNoFavoriteHistoryContainerExisting()) {
			return;
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnClearAllFavouriteHistory);
		this.getReusableActionsInstance().clickIfAvailable(this.btnClearAllFavouriteHistory);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblTitleInClearMyFavouritesPopupWindow, 20);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnClearInClearMyFavouritesPopupWindow);
		this.getReusableActionsInstance().clickIfAvailable(this.btnClearInClearMyFavouritesPopupWindow);
		this.getReusableActionsInstance().waitForElementVisibility(this.btnShoppingNow, 20);
	}

	/**
	 * This method will add favorite item by clicking favorite icon on product item
	 * @param - ProductResultsPage - prp
	 */
	public void addFavoriteItem(ProductResultsPage prp) {
		if(prp.productResultList.size()==0) {
			reporter.reportLogFail("No product search result available.");
			return;
		}

		WebElement item;
		for(WebElement element:prp.productResultList){
			item=element.findElement(prp.byProductHeaderLike);
			if(item.getAttribute("aria-pressed").equalsIgnoreCase("true")){
				continue;
			}

			this.getReusableActionsInstance().clickIfAvailable(item);
			final WebElement tempItem=item;
			this.waitForCondition(Driver->{ return tempItem.getAttribute("aria-pressed").equalsIgnoreCase("true");},15000);
		}
	}

	/**
	 * To verify address content
	 * @param - boolean - bAdd - to identify it is for Add an address or edit an address
	 */
	public void verifyAddressContent(boolean bAdd){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressTitle);
		if(!lblAddOrEditAddressTitle.getText().isEmpty()){
			reporter.reportLogPass("Address title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Address title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressRequiredInfoTitle);
		if(!lblAddOrEditAddressRequiredInfoTitle.getText().isEmpty()){
			reporter.reportLogPass("Address Required Info is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Address Required Info is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressFirstNameTitle);
		if(!lblAddOrEditAddressFirstNameTitle.getText().isEmpty()){
			reporter.reportLogPass("First name title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("First name title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressFirstNameTitle);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressFirstName)){
			reporter.reportLogPass("First name input field is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("First name input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressLastNameTitle);
		if(!lblAddOrEditAddressLastNameTitle.getText().isEmpty()){
			reporter.reportLogPass("Last name title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Last name title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressLastNameTitle);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressLastName)){
			reporter.reportLogPass("Last name input field is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Last name input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressPhoneNumberTitle);
		if(!lblAddOrEditAddressPhoneNumberTitle.getText().isEmpty()){
			reporter.reportLogPass("Phone number title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Phone number title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber1);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressPhoneNumber1)){
			reporter.reportLogPass("Phone number input field 1 is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Phone number input field 1 is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber2);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressPhoneNumber2)){
			reporter.reportLogPass("Phone number input field 2 is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Phone number input field 2 is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber3);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressPhoneNumber3)){
			reporter.reportLogPass("Phone number input field 3 is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Phone number input field 3 is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditMakeDefaultShippingAddress);
		if(!lblAddOrEditMakeDefaultShippingAddress.getText().isEmpty()){
			reporter.reportLogPass("Make default shipping address label is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Make default shipping address label is not displaying correctly");
		}

		if(bAdd){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditMakeShippingAsBillingAddress);
			if(!lblAddOrEditMakeShippingAsBillingAddress.getText().isEmpty()){
				reporter.reportLogPass("Make shipping address as billing address label is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Make shipping address as billing address label is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressLine1Title);
		if(!lblAddOrEditAddressLine1Title.getText().isEmpty()){
			reporter.reportLogPass("Address line1 title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Address line1 title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressLine1)){
			reporter.reportLogPass("Address line1 input field is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Address line1 input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressLine2Title);
		if(!lblAddOrEditAddressLine2Title.getText().isEmpty()){
			reporter.reportLogPass("Address line2 title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Address line2 title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine2);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressLine2)){
			reporter.reportLogPass("Address line2 input field is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Address line2 input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressCityTitle);
		if(!lblAddOrEditAddressCityTitle.getText().isEmpty()){
			reporter.reportLogPass("City title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("City title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressCity);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressCity)){
			reporter.reportLogPass("City input field is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("City input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressProvinceTitle);
		if(!lblAddOrEditAddressProvinceTitle.getText().isEmpty()){
			reporter.reportLogPass("Province title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Province title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectAddOrEditAddressProvince);
		if(this.getReusableActionsInstance().isElementVisible(selectAddOrEditAddressProvince)){
			reporter.reportLogPass("Province option field is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Province option field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressPostalCodeTitle);
		if(!lblAddOrEditAddressPostalCodeTitle.getText().isEmpty()){
			reporter.reportLogPass("Postal code title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Postal code title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode1);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressPostalCode1)){
			reporter.reportLogPass("Postal code input field 1 is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Postal code input field 1 is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode2);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressPostalCode2)){
			reporter.reportLogPass("Postal code input field 2 is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Postal code input field 2 is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCancel);
		if(!btnCancel.getText().isEmpty()){
			reporter.reportLogPass("Cancel button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Cancel button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnSave);
		String lsText=btnSave.getText().trim();
		if(bAdd){
			if(lsText.equalsIgnoreCase("Add Address")){
				reporter.reportLogPass("Add button is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Add button is displaying correctly");
			}
		}
		else{
			if(lsText.equalsIgnoreCase("Save Address")){
				reporter.reportLogPass("Save button is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Save button is displaying correctly");
			}
		}
	}

	/**
	 * To open add or edit an address window
	 * @param - lsOption - editShippingAddress/editBillingAddress/addShippingAddress
	 * @param - WebElement - lnkShippingEdit - if not editShippingAddress type, pass null
	 * @return - void
	 */
	public void openAddOrEditAddressWindow(String lsOption,WebElement lnkShippingEdit){
		switch(lsOption){
			case "editShippingAddress":
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkShippingEdit);
				this.getReusableActionsInstance().clickIfAvailable(lnkShippingEdit);
				break;
			case "editBillingAddress":
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkBillingAddressEdit);
				this.getReusableActionsInstance().clickIfAvailable(lnkBillingAddressEdit);
				break;
			case "addShippingAddress":
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddAddress);
				this.getReusableActionsInstance().clickIfAvailable(btnAddAddress);
				break;
			default:
				break;
		}
		this.waitForCondition(Driver->{return inputAddOrEditAddressFirstName.isDisplayed();},12000);
		this.getReusableActionsInstance().staticWait(5*this.getStaticWaitForApplication());
	}

	/**
	 * To close add or edit an address window
	 * @param - boolean - bSave - clicking Save/Cancel button
	 */
	public void closeAddOrEditAddressWindow(boolean bSave){
		if(bSave){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSave);
			//btnSave.click();
			this.clickElement(this.btnSave);
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCancel);
			this.clickElement(this.btnCancel);
			//btnCancel.click();
		}
		try{
			this.waitForCondition(Driver->{return this.lblShippingAddressSectionTitle.isDisplayed();},40000);
		}
		catch (Exception e){
			this.getReusableActionsInstance().staticWait(10*getStaticWaitForApplication())
		}
		this.getReusableActionsInstance().staticWait(5*getStaticWaitForApplication());
	}

	/**
	 * To verify your address content
	 */
	public void verifyYourAddresses(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblYourAddressTitle);
		if(!lblYourAddressTitle.getText().isEmpty()){
			reporter.reportLogPass("Your address title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Your address title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingAddressSectionTitle);
		if(!lblShippingAddressSectionTitle.getText().isEmpty()){
			reporter.reportLogPass("Shipping address title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Shipping address title is not displaying correctly");
		}

		WebElement item,element;
		for(int i=0;i<this.lstShippingAddressContainer.size();i++){
			item=this.lstShippingAddressContainer.get(0);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			if(i==0){
				element=item.findElement(this.byShippingAddressTitle);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				if(!element.getText().isEmpty()){
					reporter.reportLogPass("Default Shipping address title is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("Default Shipping address title is not displaying correctly");
				}
			}

			element=item.findElement(this.byShippingAddress);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			if(!element.getText().isEmpty()){
				reporter.reportLogPass("Default Shipping address is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Default Shipping address is not displaying correctly");
			}

			element=item.findElement(this.byShippingAddressEdit);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			if(!element.getText().isEmpty()){
				reporter.reportLogPass("Edit Default Shipping address link is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("Edit Default Shipping address link is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddAddress);
		if(this.getReusableActionsInstance().isElementVisible(btnAddAddress)){
			reporter.reportLogPass("Add address button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Add address button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblBillingAddressTitle);
		if(!lblBillingAddressTitle.getText().isEmpty()){
			reporter.reportLogPass("Billing address title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Billing address title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblBillingAddress);
		if(!lblBillingAddress.getText().isEmpty()){
			reporter.reportLogPass("Billing address is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Billing address is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkBillingAddressEdit);
		if(!lnkBillingAddressEdit.getText().isEmpty()){
			reporter.reportLogPass("Edit Billing address link is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Edit Billing address link is not displaying correctly");
		}
	}

	/**
	 * To add a new address
	 * @param - String - lsAutoSearchKeyword
	 * @param - boolean - bMakeDefaultShippingAddress
	 * @param - boolean - bMakeBillingAddress
	 * @param - int - selectedIndexInAutoSearchDropdownMenu - select item from auto search dropdown menu list, if equal to -1, then will choose a random index
	 * @return - Map<String,String> - including firstName,lastName,address
	 */
	public Map<String,String> addNewAddress(String lsAutoSearchKeyword, boolean bMakeDefaultShippingAddress,boolean bMakeBillingAddress,int selectedIndexInAutoSearchDropdownMenu){
		String lsFirstName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(5,"lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressFirstName);
		inputAddOrEditAddressFirstName.clear();
		inputAddOrEditAddressFirstName.sendKeys(lsFirstName);
		this.getReusableActionsInstance().staticWait(300);

		String lsLastName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(7,"lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLastName);
		inputAddOrEditAddressLastName.clear();
		inputAddOrEditAddressLastName.sendKeys(lsLastName);
		this.getReusableActionsInstance().staticWait(300);

		String lsPhoneNumber1="647";
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber1);
		inputAddOrEditAddressPhoneNumber1.clear();
		inputAddOrEditAddressPhoneNumber1.sendKeys(lsPhoneNumber1);
		this.getReusableActionsInstance().staticWait(300);

		String lsPhoneNumber2=DataConverter.getSaltString(3,"numberType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber2);
		inputAddOrEditAddressPhoneNumber2.clear();
		inputAddOrEditAddressPhoneNumber2.sendKeys(lsPhoneNumber2);
		this.getReusableActionsInstance().staticWait(300);

		String lsPhoneNumber3=DataConverter.getSaltString(4,"numberType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber3);
		inputAddOrEditAddressPhoneNumber3.clear();
		inputAddOrEditAddressPhoneNumber3.sendKeys(lsPhoneNumber3);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		if(bMakeDefaultShippingAddress){
			if(!ckbAddOrEditMakeDefaultShippingAddress.isSelected()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrEditMakeDefaultShippingAddress);
				labelAddOrEditMakeDefaultShippingAddress.click();
			}
		}
		else{
			if(ckbAddOrEditMakeDefaultShippingAddress.isSelected()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrEditMakeDefaultShippingAddress);
				labelAddOrEditMakeDefaultShippingAddress.click();
			}
		}

		if(bMakeBillingAddress){
			if(!ckbAddOrEditMakeShippingAsBillingAddress.isSelected()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrEditMakeShippingAsBillingAddress);
				labelAddOrEditMakeShippingAsBillingAddress.click();
			}
		}
		else{
			if(ckbAddOrEditMakeShippingAsBillingAddress.isSelected()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrEditMakeShippingAsBillingAddress);
				labelAddOrEditMakeShippingAsBillingAddress.click();
			}
		}
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
		inputAddOrEditAddressLine1.clear();
		String[] data = lsAutoSearchKeyword.codePoints().mapToObj(cp->new String(Character.toChars(cp))).toArray(size->new String[size]);
		int sum=0;
		for(String inputText:data){
			if(sum>=30){
				break;
			}
			inputAddOrEditAddressLine1.sendKeys(inputText);
			//For thinking time for waiting for backend response
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			sum++;
		}
		this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: block;");},20000);
		this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());

		if(this.lstAddOrEditAddressAutoSearchDropdownItems.size()>=1){
			reporter.reportLogPass("Getting dropdown auto search results successfully");
		}
		else{
			reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
		}

		if(selectedIndexInAutoSearchDropdownMenu==-1){
			int optionSize=this.lstAddOrEditAddressAutoSearchDropdownItems.size();
			Random rand = new Random();
			int randomNumber = rand.nextInt(optionSize-2);

			//selectedIndexInAutoSearchDropdownMenu=randomNumber;
			selectedIndexInAutoSearchDropdownMenu=0;
		}

		try{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(selectedIndexInAutoSearchDropdownMenu));
			this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(selectedIndexInAutoSearchDropdownMenu));
			this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");},20000);
		}
		catch(Exception e){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(selectedIndexInAutoSearchDropdownMenu));
			this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(selectedIndexInAutoSearchDropdownMenu));
			this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");},20000);
		}
		this.getReusableActionsInstance().staticWait(3*this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
		String lsAddress=inputAddOrEditAddressLine1.getAttribute("value").trim();

		Map<String,String> map=new HashMap<>();
		map.put("firstName",lsFirstName);
		map.put("lastName",lsLastName);
		map.put("address",lsAddress);
		map.put("selectedIndex",selectedIndexInAutoSearchDropdownMenu+"");

		return map;
	}

	/**
	 * To edit an address
	 * @param - Map<String,String> map
	 * @param - String - lsAuoSearchKeyword - can be set as null
	 * @param - String - address
	 */
	public String editAddress(Map<String,String> map,String lsAuoSearchKeyword){
		for (Map.Entry<String, String> entry : map.entrySet()) {
			switch(entry.getKey()){
				case "firstName":
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressFirstName);
					inputAddOrEditAddressFirstName.clear();
					inputAddOrEditAddressFirstName.sendKeys(entry.getValue().toString());
					this.getReusableActionsInstance().staticWait(300);
					break;
				case "lastName":
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLastName);
					inputAddOrEditAddressLastName.clear();
					inputAddOrEditAddressLastName.sendKeys(entry.getValue().toString());
					this.getReusableActionsInstance().staticWait(300);
					break;
				case "phoneNumber1":
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber1);
					inputAddOrEditAddressPhoneNumber1.clear();
					inputAddOrEditAddressPhoneNumber1.sendKeys(entry.getValue().toString());
					this.getReusableActionsInstance().staticWait(300);
					break;
				case "phoneNumber2":
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber2);
					inputAddOrEditAddressPhoneNumber2.clear();
					inputAddOrEditAddressPhoneNumber2.sendKeys(entry.getValue().toString());
					this.getReusableActionsInstance().staticWait(300);
					break;
				case "phoneNumber3":
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber3);
					inputAddOrEditAddressPhoneNumber3.clear();
					inputAddOrEditAddressPhoneNumber3.sendKeys(entry.getValue().toString());
					this.getReusableActionsInstance().staticWait(300);
					break;
				case "address":
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
					inputAddOrEditAddressLine1.clear();
					String[] data = entry.getValue().toString().codePoints().mapToObj(cp->new String(Character.toChars(cp))).toArray(size->new String[size]);
					int sum=0;
					for(String inputText:data){
						if(sum>=30){
							break;
						}
						inputAddOrEditAddressLine1.sendKeys(inputText);
						//For thinking time for waiting for backend response
						this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
						sum++;
					}
					this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: block;");},20000);
					this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());

					if(this.lstAddOrEditAddressAutoSearchDropdownItems.size()>=1){
						reporter.reportLogPass("Getting dropdown auto search results successfully");
					}
					else{
						reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
					}

					try{
						this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
						this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
						this.clickWebElementUsingJS(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
						this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");},20000);
					}
					catch (Exception e){
						this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
						this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
						this.clickWebElementUsingJS(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
						this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");},20000);
					}
					this.getReusableActionsInstance().staticWait(3*this.getStaticWaitForApplication());
					break;
				default:
					break;
			}
		}

		String lsAddress=null;
		if(lsAuoSearchKeyword!=null){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
			inputAddOrEditAddressLine1.clear();
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			String[] data = lsAuoSearchKeyword.codePoints().mapToObj(cp->new String(Character.toChars(cp))).toArray(size->new String[size]);
			int sum=0;
			for(String inputText:data){
				if(sum>=30){
					break;
				}
				inputAddOrEditAddressLine1.sendKeys(inputText);
				//For thinking time for waiting for backend response
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				sum++;
			}
			this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: block;");},20000);
			this.getReusableActionsInstance().staticWait(3*this.getStaticWaitForApplication());

			if(this.lstAddOrEditAddressAutoSearchDropdownItems.size()>=1){
				reporter.reportLogPass("Getting dropdown auto search results successfully");
			}
			else{
				reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
			}
			/**
			int optionSize=this.lstAddOrEditAddressAutoSearchDropdownItems.size();
			Random rand = new Random();
			int randomNumber = rand.nextInt(optionSize-2);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(randomNumber));
			this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(randomNumber));
			 */
			try{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
				this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");},20000);
			}
			catch (Exception e){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
				this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");},20000);
			}
			this.getReusableActionsInstance().staticWait(3*this.getStaticWaitForApplication());

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
			lsAddress=inputAddOrEditAddressLine1.getAttribute("value").trim();
		}

		return lsAddress;
	}

	/**
	 * To verify Auto Search function For Address input
	 * @param - boolean - bCancel - clicking Cancel button to close Add/Edit window
	 */
	public void verifyAutoSearchForAddress(boolean bCancel){
		String lsFirstName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(5,"lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressFirstName);
		inputAddOrEditAddressFirstName.clear();
		inputAddOrEditAddressFirstName.sendKeys(lsFirstName);
		this.getReusableActionsInstance().staticWait(300);

		String lsLastName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(7,"lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLastName);
		inputAddOrEditAddressLastName.clear();
		inputAddOrEditAddressLastName.sendKeys(lsLastName);
		this.getReusableActionsInstance().staticWait(300);

		String lsPhoneNumber1="647";
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber1);
		inputAddOrEditAddressPhoneNumber1.clear();
		inputAddOrEditAddressPhoneNumber1.sendKeys(lsPhoneNumber1);
		this.getReusableActionsInstance().staticWait(1000);

		String lsPhoneNumber2=DataConverter.getSaltString(3,"numberType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber2);
		inputAddOrEditAddressPhoneNumber2.clear();
		inputAddOrEditAddressPhoneNumber2.sendKeys(lsPhoneNumber2);
		this.getReusableActionsInstance().staticWait(1000);

		String lsPhoneNumber3=DataConverter.getSaltString(4,"numberType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber3);
		inputAddOrEditAddressPhoneNumber3.clear();
		inputAddOrEditAddressPhoneNumber3.sendKeys(lsPhoneNumber3);
		this.getReusableActionsInstance().staticWait(1000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressCity);
		inputAddOrEditAddressCity.clear();
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectAddOrEditAddressProvince);
		Select selectProvince=new Select(selectAddOrEditAddressProvince);
		selectProvince.selectByIndex(0);
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode1);
		inputAddOrEditAddressPostalCode1.clear();
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode2);
		inputAddOrEditAddressPostalCode2.clear();
		this.getReusableActionsInstance().staticWait(300);

		String lsAddress1="1122";
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
		inputAddOrEditAddressLine1.clear();
		String[] data = lsAddress1.codePoints().mapToObj(cp->new String(Character.toChars(cp))).toArray(size->new String[size]);
		int sum=0;
		for(String inputText:data){
			if(sum>=30){
				break;
			}
			inputAddOrEditAddressLine1.sendKeys(inputText);
			//For thinking time for waiting for backend response
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			sum++;
		}
		this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: block;");},20000);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		if(this.lstAddOrEditAddressAutoSearchDropdownItems.size()>=1){
			reporter.reportLogPass("Getting dropdown auto search results successfully");
		}
		else{
			reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
		}

		try{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
			this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
			this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");},20000);
		}
		catch(Exception e){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
			this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
			this.waitForCondition(Driver->{return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");},20000);
		}
		this.getReusableActionsInstance().staticWait(3*this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressCity);
		String lsAddress=inputAddOrEditAddressCity.getAttribute("value").trim();
		if(!lsAddress.isEmpty()){
			reporter.reportLogPass("Auto search function is working well for City field");
		}
		else{
			reporter.reportLogFailWithScreenshot("Auto search function is not working well for City field");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectAddOrEditAddressProvince);
		String lsText=selectProvince.getFirstSelectedOption().getText().trim();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("Auto search function is working well for Province field");
		}
		else{
			reporter.reportLogFailWithScreenshot("Auto search function is not working well for Province field");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode1);
		lsText=inputAddOrEditAddressPostalCode1.getAttribute("value").trim();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("Auto search function is working well for Postal Code field 1");
		}
		else{
			reporter.reportLogFailWithScreenshot("Auto search function is not working well for Postal Code field 1");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode2);
		lsText=inputAddOrEditAddressPostalCode2.getAttribute("value").trim();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("Auto search function is working well for Postal Code field 2");
		}
		else{
			reporter.reportLogFailWithScreenshot("Auto search function is not working well for Postal Code field 2");
		}
	}

	/**
	 * To get the given shipping or billing address info(first name,last name,Address,city,province,postal code)
	 * @param - shippingAddressIndex - if equal to -1, then refer to Billing address
	 * @return - Map<String,String>
	 */
	public Map<String,String> getGivenShippingOrBillingAddress(int shippingAddressIndex){
		if(shippingAddressIndex==-1){
			this.openAddOrEditAddressWindow("editBillingAddress",null);
		}
		else{
			WebElement shippingAddressContainer=this.lstShippingAddressContainer.get(shippingAddressIndex);
			WebElement editButton=shippingAddressContainer.findElement(this.byShippingAddressEdit);
			this.openAddOrEditAddressWindow("editShippingAddress",editButton);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressFirstName);
		String lsFirstName=inputAddOrEditAddressFirstName.getAttribute("value");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLastName);
		String lsLastName=inputAddOrEditAddressLastName.getAttribute("value");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber1);
		String lsPhoneNumber1=inputAddOrEditAddressPhoneNumber1.getAttribute("value");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber2);
		String lsPhoneNumber2=inputAddOrEditAddressPhoneNumber2.getAttribute("value");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber3);
		String lsPhoneNumber3=inputAddOrEditAddressPhoneNumber3.getAttribute("value");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
		String lsAddress=inputAddOrEditAddressLine1.getAttribute("value");

		this.closeAddOrEditAddressWindow(false);

		Map<String,String> map=new HashMap<>();
		map.put("firstName",lsFirstName);
		map.put("lastName",lsLastName);
		map.put("phoneNumber1",lsPhoneNumber1);
		map.put("phoneNumber2",lsPhoneNumber2);
		map.put("phoneNumber3",lsPhoneNumber3);
		map.put("address",lsAddress);

		return map;
	}

	/**
	 * To set Default Shipping Address Or Billing Address
	 */
	public void setDefaultShippingAddress(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbAddOrEditMakeDefaultShippingAddress);
		if(!ckbAddOrEditMakeDefaultShippingAddress.isSelected()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrEditMakeDefaultShippingAddress);
			labelAddOrEditMakeDefaultShippingAddress.click();
		}
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
	}

	/**
	 * To get edit button for given shipping address
	 * @param selectedIndex
	 * @return edit button
	 */
	public WebElement getGivenShippingAddressEditButton(int selectedIndex){
		WebElement container=this.lstShippingAddressContainer.get(selectedIndex);
		return container.findElement(this.byShippingAddressEdit);
	}

	/**
	 * To verify favorite page
	 * @param - Map<String,String> - map - including productName,ProductNowPrice, ProductWasPrice
	 * @param - int - favoriteItemAmount
	 */
	public void verifyFavoritePageContent(Map<String,String> map,int favoriteItemAmount){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyFavouritesTitle);
		if(!lblMyFavouritesTitle.getText().isEmpty()){
			reporter.reportLogPass("Favorite title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Favorite title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnClearAllFavouriteHistory);
		if(!btnClearAllFavouriteHistory.getText().isEmpty()){
			reporter.reportLogPass("Clear All Favorite History button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Clear All Favorite History button is not displaying correctly");
		}

		if(favoriteItemAmount==this.lstFavouriteProduct.size()){
			reporter.reportLogPass("The favorite item list size is equal to the favorite amount under My Preference");
		}
		else{
			reporter.reportLogFailWithScreenshot("The favorite item list size is not equal to the favorite amount under My Preference");
		}

		String lsProductName=map.get("productName").toString();
		String lsProductNowPrice=map.get("productNowPrice").toString();
		String lsProductWasPrice=null;
		if(map.get("productName")!=null){
			lsProductWasPrice=map.get("productWasPrice").toString();
		}

		String lsFavoriteItemName=null,lsFavoriteItemNowPrice=null,lsFavoriteItemWasPrice=null;
		WebElement item=this.lstFavouriteProduct.get(0);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		WebElement element=item.findElement(byFavoriteItemImage);
		if(!element.getAttribute("src").isEmpty()){
			reporter.reportLogPass("The favorite item image source is not empty");
		}
		else{
			reporter.reportLogFailWithScreenshot("The favorite item image source not empty");
		}

		element=item.findElement(byFavoriteItemName);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		lsFavoriteItemName=element.getText().trim();
		if(!lsFavoriteItemName.isEmpty()){
			reporter.reportLogPass("The favorite item name is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The favorite item name is not displaying correctly");
		}

		element=item.findElement(byFavoriteItemNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		lsFavoriteItemNowPrice=element.getText().trim();
		if(!lsFavoriteItemNowPrice.isEmpty()){
			reporter.reportLogPass("The favorite item NowPrice is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The favorite item NowPrice is not displaying correctly");
		}

		if(lsProductWasPrice!=null){
			element=item.findElement(byFavoriteItemWasPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsFavoriteItemWasPrice=element.getText().trim();
			if(!lsFavoriteItemWasPrice.isEmpty()){
				reporter.reportLogPass("The favorite item WasPrice is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The favorite item WasPrice is not displaying correctly");
			}
		}
		if(lsProductName.length()>25){
			if(lsFavoriteItemName.substring(0,25).equalsIgnoreCase(lsProductName.substring(0,25))){
				reporter.reportLogPass("The product name on PRP page is equal to the favorite item name");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product name on PRP page:'"+lsProductName+"' is not equal to the favorite item name:'"+lsFavoriteItemName+"'");
			}
		}
		else{
			if(lsFavoriteItemName.equalsIgnoreCase(lsProductName)){
				reporter.reportLogPass("The product name on PRP page is equal to the favorite item name");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product name on PRP page:'"+lsProductName+"' is not equal to the favorite item name:'"+lsFavoriteItemName+"'");
			}
		}

		if(lsFavoriteItemNowPrice.equalsIgnoreCase(lsProductNowPrice)){
			reporter.reportLogPass("The product NowPrice on PRP page is equal to the favorite item NowPrice");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product NowPrice:"+lsProductNowPrice+" on PRP page is not equal to the favorite item NowPrice:"+lsFavoriteItemNowPrice);
		}

		if(lsProductWasPrice!=null){
			if(lsFavoriteItemWasPrice.equalsIgnoreCase(lsProductWasPrice)){
				reporter.reportLogPass("The product WasPrice on PRP page is equal to the favorite item WasPrice");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product WasPrice:"+lsProductWasPrice+" on PRP page is not equal to the favorite item WasPrice:"+lsFavoriteItemWasPrice);
			}
		}
	}

	/**
	 * To add Favorite Item From PRP
	 * @param - String - lsKeyword
	 * @param - ProductResultsPage - prp
	 * @return - Map<String,String> - including productName,ProductNowPrice,ProductWasPrice
	 */
	public Map<String,String> addFavoriteItemFromPRP(String lsKeyword,ProductResultsPage prp){
		Map<String,String> map=new HashMap<>();
		prp.getSearchResultLoad(lsKeyword,true);
		for(WebElement item:prp.getProductList()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			WebElement element=item.findElement(prp.byProductHeaderLike);
			final WebElement tmpElement=element;
			if(element.getAttribute("aria-pressed").equalsIgnoreCase("false")) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				this.getReusableActionsInstance().clickIfAvailable(element);
				this.waitForCondition(Driver->{return tmpElement.getAttribute("aria-pressed").equalsIgnoreCase("true");},10000);
				if(element.getAttribute("aria-pressed").equalsIgnoreCase("true")){
					reporter.reportLogPass("The favorite icon on PRP page is highlighted correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The favorite icon on PRP page is not highlighted correctly");
				}

				element=item.findElement(prp.byProductName);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				map.put("productName",element.getText().trim());

				element=item.findElement(prp.byProductNowPrice);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				map.put("productNowPrice",element.getText().trim().split(":")[1].trim());

				if(prp.checkProductItemWasPriceExisting(item)){
					element=item.findElement(prp.byProductWasPrice);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					map.put("productWasPrice",element.getText().trim().split(":")[1].trim());
				}
				else{
					map.put("productWasPrice",null);
				}
				break;
			}
		}
		return map;
	}

	/**
	 * To verify Favorite Item on PDP
	 * @param - ProductDetailPage - pdp
	 */
	public void verifyFavoriteItemOnPDP(ProductDetailPage pdp){
		WebElement item=this.lstFavouriteProduct.get(0);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);

		WebElement imageElement,element;
		imageElement=item.findElement(byFavoriteItemImage);

		element=item.findElement(byFavoriteItemName);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		String lsFavoriteItemName=element.getText().trim();

		element=item.findElement(byFavoriteItemNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		String lsFavoriteItemNowPrice=String.valueOf(this.getFloatFromString(element.getText(),true));;

		String lsFavoriteItemWasPrice=null;
		if(this.getChildElementCount(item.findElement(byFavoriteItemPriceContainer))>1){
			element=item.findElement(byFavoriteItemWasPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsFavoriteItemWasPrice= String.valueOf(this.getFloatFromString(element.getText(),true));
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imageElement);
		this.getReusableActionsInstance().clickIfAvailable(imageElement);
		this.waitForCondition(Driver->{return pdp.lblProductName.isDisplayed();},30000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(pdp.lblProductName);
		String lsPDPItemName=pdp.lblProductName.getText().trim();
		if(lsPDPItemName.length()>25){
			if(lsFavoriteItemName.substring(0,25).equalsIgnoreCase(lsPDPItemName.substring(0,25))){
				reporter.reportLogPass("The favorite name is the same as the PDP product name");
			}
			else{
				reporter.reportLogFailWithScreenshot("The favorite name:"+lsFavoriteItemName+" is not the same as the PDP product name:"+lsPDPItemName);
			}
		}
		else{
			if(lsFavoriteItemName.equalsIgnoreCase(lsPDPItemName)){
				reporter.reportLogPass("The favorite name is the same as the PDP product name");
			}
			else{
				reporter.reportLogFailWithScreenshot("The favorite name:"+lsFavoriteItemName+" is not the same as the PDP product name:"+lsPDPItemName);
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(pdp.lblProductNowPrice);
		String lsPDPItemNowPrice=String.valueOf(this.getFloatFromString(pdp.lblProductNowPrice.getText(),true));
		if(lsFavoriteItemNowPrice.equalsIgnoreCase(lsPDPItemNowPrice)){
			reporter.reportLogPass("The favorite NowPrice is the same as the PDP product NowPrice");
		}
		else{
			reporter.reportLogFailWithScreenshot("The favorite NowPrice:"+lsFavoriteItemNowPrice+" is not the same as the PDP product NowPrice:"+lsPDPItemNowPrice);
		}

		if(lsFavoriteItemWasPrice!=null){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(pdp.lblProductWasPrice);
			String lsPDPItemWasPrice=String.valueOf(this.getFloatFromString(pdp.lblProductWasPrice.getText(),true));
			if(lsFavoriteItemWasPrice.equalsIgnoreCase(lsPDPItemWasPrice)){
				reporter.reportLogPass("The favorite WasPrice is the same as the PDP product WasPrice");
			}
			else{
				reporter.reportLogFailWithScreenshot("The favorite WasPrice:"+lsFavoriteItemWasPrice+" is not the same as the PDP product WasPrice:"+lsPDPItemWasPrice);
			}
		}

		if(pdp.checkIfFavShareMobileHighlighted()) {
			reporter.reportLogPass("The FavShareMobile icon is highlighted correctly");
		}
		else {
			reporter.reportLogFailWithScreenshot("The FavShareMobile icon is not highlighted correctly");
		}
	}

	/**
	 * To cancel Favorite Item On PDP page
	 * @param - ProductDetailPage - pdp
	 * @return - String - product name
	 */
	public String cancelFavoriteItemOnPDP(ProductDetailPage pdp){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(pdp.lblProductName);
		String lsPDPProductName=pdp.lblProductName.getText().trim();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(pdp.lnkFavIcon);
		this.getReusableActionsInstance().clickIfAvailable(pdp.lnkFavIcon);
		this.waitForCondition(Driver->{return !pdp.checkIfFavShareMobileHighlighted();},5000);

		if(!pdp.checkIfFavShareMobileHighlighted()){
			reporter.reportLogPass("The cancel favorite item action is working well");
		}
		else{
			reporter.reportLogFailWithScreenshot("The cancel favorite item action is not working well");
		}

		return lsPDPProductName;
	}

	/**
	 * To verify PRP Favorite Icon After Cancel Action From PDP
	 * @param - String - lsKeyword - product name
	 * @param - ProductResultsPage - prp
	 */
	public void verifyPRPFavoriteIconAfterCancelActionFromPDP(String lsKeyword,ProductResultsPage prp){
		prp.getSearchResultLoad(lsKeyword,true);
		WebElement item=prp.getProductList().get(0).findElement(prp.byProductHeaderLike);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		if(item.getAttribute("aria-pressed").equalsIgnoreCase("false")) {
			reporter.reportLogPass("The favorite icon on PDP is not highlighted");
		}
		else{
			reporter.reportLogFailWithScreenshot("The favorite icon on PDP is highlighted wrongly");
		}
	}

	/**
	 * To clear viewing history
	 */
	public void clearViewingHistory() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnClearViewingHistory);
		this.getReusableActionsInstance().clickIfAvailable(this.btnClearViewingHistory);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblTitleInClearMyFavouritesPopupWindow, 20);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnClearInClearMyFavouritesPopupWindow);
		this.getReusableActionsInstance().clickIfAvailable(this.btnClearInClearMyFavouritesPopupWindow);
		this.getReusableActionsInstance().waitForElementVisibility(this.lnkRecentlyViewedShopNow, 20);
	}

	/**
	 * To verify Recently Viewing History Content
	 * @param - Map<String,String> - productMap
	 */
	public void verifyRecentlyViewingHistoryContent(Map<String,String> productMap){
		String lsText,lsTextMap;
		WebElement item,element;

		ProductResultsPage prp=new ProductResultsPage(this.getDriver());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRecentlyViewedTitle);
		lsText=lblRecentlyViewedTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Recently Viewing history title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Recently Viewing history title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnClearViewingHistory);
		lsText=btnClearViewingHistory.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Clear Viewing history button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Clear Viewing history button is not displaying correctly");
		}

		reporter.reportLog("verify Recently Viewing History item");
		item=this.lstRecentlyViewedItemContainerList.get(0);
		element=item.findElement(byRecentlyViewedItemLink);
		lsText=element.getAttribute("href");
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The link of recently viewing history item is not empty");
		}
		else{
			reporter.reportLogFailWithScreenshot("The link of recently viewing history item is empty");
		}

		element=item.findElement(byRecentlyViewedItemImage);
		lsText=element.getAttribute("src");
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The image source of recently viewing history item is not empty");
		}
		else{
			reporter.reportLogFailWithScreenshot("The image source of recently viewing history item is empty");
		}

		element=item.findElement(byRecentlyViewedItemName);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		lsText=element.getText().trim();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product name of recently viewing history item is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product name of recently viewing history item is not displaying correctly");
		}

		lsTextMap=productMap.get("productName");
		if(lsTextMap.length()>25){
			if(lsTextMap.substring(0,25).equalsIgnoreCase(lsText.substring(0,25))){
				reporter.reportLogPass("The product name of recently viewing history item is the same as the one on PRP page");
			}
			else{
				reporter.reportLogFail("The product name of recently viewing history item is not the same as the one on PRP page");
			}
		}
		else{
			if(lsText.equalsIgnoreCase(lsTextMap)){
				reporter.reportLogPass("The product name of recently viewing history item is the same as the one on PRP page");
			}
			else{
				reporter.reportLogFail("The product name of recently viewing history item is not the same as the one on PRP page");
			}
		}

		element=item.findElement(byRecentlyViewedItemNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		lsText= String.valueOf(this.getFloatFromString(element.getText(),true));
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product NowPrice of recently viewing history item is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product NowPrice of recently viewing history item is not displaying correctly");
		}

		lsTextMap=productMap.get("productNowPrice");
		if(lsText.equalsIgnoreCase(lsTextMap)){
			reporter.reportLogPass("The product NowPrice of recently viewing history item is the same as the one on PRP page");
		}
		else{
			reporter.reportLogFail("The product NowPrice of recently viewing history item is not the same as the one on PRP page");
		}

		lsTextMap=productMap.get("productWasPrice");
		if(lsText!=null){
			element=item.findElement(byRecentlyViewedItemWasPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsText= String.valueOf(this.getFloatFromString(element.getText(),true));
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The product WasPrice of recently viewing history item is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product WasPrice of recently viewing history item is not displaying correctly");
			}

			if(lsText.equalsIgnoreCase(lsTextMap)){
				reporter.reportLogPass("The product WasPrice of recently viewing history item is the same as the one on PRP page");
			}
			else{
				reporter.reportLogFail("The product WasPrice of recently viewing history item is not the same as the one on PRP page");
			}
		}

		lsTextMap=productMap.get("productReviewRate");
		if(lsTextMap!=null){
			List<WebElement> itemList=item.findElements(byRecentlyViewedItemReviewRateStarList);
			if(itemList.size()>0){
				reporter.reportLogPass("Review star list is not empty");
			}
			else{
				reporter.reportLogFailWithScreenshot("Review star list is empty");
			}

			int reviewRate=prp.getProductItemReviewNumberAmountFromStarImage(itemList);
			if(lsTextMap.equalsIgnoreCase(reviewRate+"")){
				reporter.reportLogPass("The product review rate of recently viewing history item is the same as the one on PRP page");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product review rate of recently viewing history item is not the same as the one on PRP page");
			}
		}

		lsTextMap=productMap.get("productReviewCount");
		if(lsTextMap!=null){
			element=item.findElement(byRecentlyViewedItemReviewAmount);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsText=element.getText().trim();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The product review rate of recently viewing history item is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product review rate of recently viewing history item is not displaying correctly");
			}

			int reviewCount=this.getIntegerFromString(lsText);
			if(lsTextMap.equalsIgnoreCase(reviewCount+"")){
				reporter.reportLogPass("The product review count of recently viewing history item is the same as the one on PRP page");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product review count of recently viewing history item is not the same as the one on PRP page");
			}
		}
	}

	/**
	 * verify Changing Subscription Success Message in NewsLetters
	 * @param - WebElement - ckbLabel
	 * @param - WebElement - ckbItem
	 * @param - boolean - bCheck - if check the related Subscription checkbox
	 * @param - String - lsExpectedMessage
	 */
	public void verifyNewsLettersChangingSubscriptionSuccessMessage(WebElement ckbLabel, WebElement ckbItem,boolean bCheck,String lsExpectedMessage){
		this.getDriver().switchTo().frame(this.iFrameEmailSignup);

		if(bCheck){
			if(!ckbItem.isSelected()){
				this.getReusableActionsInstance().clickIfAvailable(ckbLabel);
			}
		}
		else{
			if(ckbItem.isSelected()){
				this.getReusableActionsInstance().clickIfAvailable(ckbLabel);
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnMyNewsLettersUpdatePrefs);
		this.getReusableActionsInstance().clickIfAvailable(btnMyNewsLettersUpdatePrefs);

		this.waitForCondition(Driver->{return this.lblSubscriptionSuccessMessage.isDisplayed();},10000);
		this.getReusableActionsInstance().staticWait(5*this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSubscriptionSuccessMessage);
		String lsActualMessage=this.lblSubscriptionSuccessMessage.getText();
		if(lsActualMessage.toLowerCase().contains(lsExpectedMessage.toLowerCase())){
			reporter.reportLogPass("The subscription message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The subscription message is not displaying correctly");
		}

		this.navigateBack();
		this.getDriver().switchTo().defaultContent();
	}

	/**
	 * verify UnSubscription Success Message in NewsLetters
	 * @param - boolean - bCheckUnSubscription - if check the UnSubscription checkbox
	 * @param - String - lsExpectedAlertMessage
	 * @param - String - lsExpectedUnSubscriptionMessage
	 */
	public void verifyNewsLettersUnSubscriptionSuccessMessage(boolean bCheckUnSubscription,String lsExpectedAlertMessage,String lsExpectedUnSubscriptionMessage){
		this.getDriver().switchTo().frame(this.iFrameEmailSignup);

		if(!bCheckUnSubscription){
			if(this.ckbMyNewsLettersUnsubscribe.isSelected()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.ckbMyNewsLettersUnsubscribe);
				this.getReusableActionsInstance().clickIfAvailable(this.ckbMyNewsLettersUnsubscribe);
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnMyNewsLettersUnsubscribe);
			this.getReusableActionsInstance().clickIfAvailable(btnMyNewsLettersUnsubscribe);
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			Alert alert=this.getDriver().switchTo().alert();
			String lsActualAlertMessage=alert.getText().trim();
			if(lsActualAlertMessage.toLowerCase().contains(lsExpectedAlertMessage.toLowerCase())){
				reporter.reportLogPass("The Alert message for not checking UnSubscription is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Alert message for not checking UnSubscription is not displaying correctly");
			}
			alert.accept();
		}
		else{
			if(!this.ckbMyNewsLettersUnsubscribe.isSelected()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.ckbMyNewsLettersUnsubscribe);
				this.getReusableActionsInstance().clickIfAvailable(this.ckbMyNewsLettersUnsubscribe);
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnMyNewsLettersUnsubscribe);
			this.getReusableActionsInstance().clickIfAvailable(btnMyNewsLettersUnsubscribe);
			this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());
			Alert alert=this.getDriver().switchTo().alert();
			String lsActualAlertMessage=alert.getText().trim();
			if(lsActualAlertMessage.toLowerCase().contains(lsExpectedAlertMessage.toLowerCase())){
				reporter.reportLogPass("The Alert message for checking UnSubscription is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Alert message for checking UnSubscription is not displaying correctly");
			}
			alert.accept();

			waitForCondition(Driver->{return this.lblSubscriptionSuccessMessage.isDisplayed();},10000);
			this.getReusableActionsInstance().staticWait(5*this.getStaticWaitForApplication());

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSubscriptionSuccessMessage);
			String lsActualMessage=this.lblSubscriptionSuccessMessage.getText();
			if(lsActualMessage.toLowerCase().contains(lsExpectedUnSubscriptionMessage.toLowerCase())){
				reporter.reportLogPass("The UnSubscription message is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The UnSubscription message is not displaying correctly");
			}

			this.navigateBack();
			this.getDriver().switchTo().defaultContent();
		}
	}

	/**
	 * To verify My NewsLetter Content
	 */
	public void verifyMyNewsLetterContent(){
		this.getDriver().switchTo().frame(this.iFrameEmailSignup);

		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersTitle);
		lsText=lblMyNewsLettersTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("MyNewsLetter title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("MyNewsLetter title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersManageYourEmailPreferences);
		lsText=lblMyNewsLettersManageYourEmailPreferences.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("Manage Your Email Preferences static text is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Manage Your Email Preferences static text is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbMyNewsLettersTodayShowStopperNewsLetter);
		if(this.getReusableActionsInstance().isElementVisible(ckbMyNewsLettersTodayShowStopperNewsLetter)){
			reporter.reportLogPass("Today Show Stopper NewsLetter checkbox is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Today Show Stopper NewsLetter checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersTodayShowStopperNewsLetterTitle);
		lsText=lblMyNewsLettersTodayShowStopperNewsLetterTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("Today Show Stopper NewsLetter checkbox label is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Today Show Stopper NewsLetter checkbox label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbMyNewsLettersSpecialOfferAndEventNewsLetter);
		if(this.getReusableActionsInstance().isElementVisible(ckbMyNewsLettersSpecialOfferAndEventNewsLetter)){
			reporter.reportLogPass("Special Offer And Event NewsLetter checkbox is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Special Offer And Event NewsLetter checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersSpecialOfferAndEventNewsLetterTitle);
		lsText=lblMyNewsLettersSpecialOfferAndEventNewsLetterTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("Special Offer And Event NewsLetter checkbox label is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Special Offer And Event NewsLetter checkbox label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbMyNewsLettersPreferredCustomerOffer);
		if(this.getReusableActionsInstance().isElementVisible(ckbMyNewsLettersPreferredCustomerOffer)){
			reporter.reportLogPass("Preferred Customer Offer checkbox is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Preferred Customer Offer checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersPreferredCustomerOfferTitle);
		lsText=lblMyNewsLettersPreferredCustomerOfferTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("Preferred Customer Offer checkbox label is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Preferred Customer Offer checkbox label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbMyNewsLettersProductUpdatesAndAlerts);
		if(this.getReusableActionsInstance().isElementVisible(ckbMyNewsLettersProductUpdatesAndAlerts)){
			reporter.reportLogPass("Product Updates And Alerts checkbox is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Product Updates And Alerts checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersProductUpdatesAndAlertsTitle);
		lsText=lblMyNewsLettersProductUpdatesAndAlertsTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("Product Updates And Alerts checkbox label is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Product Updates And Alerts checkbox label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnMyNewsLettersUpdatePrefs);
		if(this.getReusableActionsInstance().isElementVisible(btnMyNewsLettersUpdatePrefs)){
			reporter.reportLogPass("UpdatePrefs button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("UpdatePrefs button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbMyNewsLettersUnsubscribe);
		if(this.getReusableActionsInstance().isElementVisible(ckbMyNewsLettersUnsubscribe)){
			reporter.reportLogPass("Unsubscribe checkbox is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Unsubscribe checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersUnsubscribeTitle);
		lsText=lblMyNewsLettersUnsubscribeTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("Unsubscribe checkbox label is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Unsubscribe checkbox label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersUnsubscribeDescription);
		lsText=lblMyNewsLettersUnsubscribeDescription.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("Unsubscribe Description is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Unsubscribe Description is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnMyNewsLettersUnsubscribe);
		if(this.getReusableActionsInstance().isElementVisible(btnMyNewsLettersUnsubscribe)){
			reporter.reportLogPass("Unsubscribe button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Unsubscribe button is not displaying correctly");
		}

		this.getDriver().switchTo().defaultContent();
	}

	/**
	 * To check Viewed History Existing
	 * @return - boolean
	 */
	public boolean checkViewedHistoryExisting(){
		return this.getChildElementCount(cntRecentlyViewedTitleContainer)>1;
	}


}

