package com.tsc.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.apiBuilder.OrderAPI;
import com.tsc.api.pojo.*;
import com.tsc.api.util.CustomComparator;
import com.tsc.api.util.DataConverter;
import com.tsc.api.util.JsonParser;
import com.tsc.pages.base.BasePage;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.util.List;



public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ng-component//*[@class='paymentPageTitle']")
	public WebElement lblPageTitle;

	@FindBy(xpath = "//div[contains(@class,'tsc-forms')]//div[contains(@class,'form-head')]//h2/span")
	public WebElement lblOrderDetailsHeaderUserName;

	@FindBy(xpath = "//div[contains(@class,'tsc-forms')]//div[contains(@class,'form-head')]//span[contains(normalize-space(text()),'Customer Number:')]/following-sibling::span")
	public WebElement lblOrderDetailsHeaderCustomerNumber;

	@FindBy(xpath = "//ng-component//div[contains(@class,'form-head')]//h2")
	public WebElement lblMyAccountHeaderTitle;

	//Navigation breadcrumb
	@FindBy(xpath = "//ng-component//div[contains(@class,'go-back')]//ol[@class='breadcrumb']//li//a")
	public List<WebElement> lstNavigationCrumbList;

	//Account summary container
	@FindBy(xpath = "//div[@class='my-account-summary-container']")
	public WebElement cntAccountSummaryContainer;

	@FindBy(xpath = "//div[@class='my-account-summary-container']//div[@class='panel']")
	public List<WebElement> lstAccountSummaryPanelList;

	public By bySubHeader = By.xpath(".//div[contains(@class,'panel-heading')]");
	public By bySubList = By.xpath(".//ul//li[not(contains(@class,'hidden'))]//a");

	//For order part
	//For Order status and recent order
	@FindBy(xpath = "//ng-component//p[@class='section-title']")
	public WebElement lblOrderStatusSectionTitle;

	@FindBy(xpath = "//ng-component//div[@class='tsc-forms']/div[last()]/div")
	public WebElement cntOrderListContainer;

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

	public By byOrderNoTitle = By.xpath(".//*[@id='tagOrderNo']/preceding-sibling::span[@class='item-title']");
	public By byOrderNo = By.xpath(".//*[@id='tagOrderNo']");
	public By byOrderNoDate = By.xpath(".//*[@id='tagOrderNo']/following-sibling::div");

	public By byOrderTotalTitle = By.xpath(".//*[@id='tagOrderTotal']/preceding-sibling::span[@class='item-title']");
	public By byOrderTotal = By.xpath(".//*[@id='tagOrderTotal']");

	public By byOrderStatusTitle = By.xpath(".//*[@id='tagOrderStatus']/preceding-sibling::span[@class='item-title']");
	public By byOrderStatus = By.xpath(".//*[@id='tagOrderStatus']");

	public By byOrderViewDetails = By.xpath(".//a[contains(@href,'orderstatus')]");

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

	@FindBy(xpath = "//div[@class='tsc-forms']//div[contains(@class,'buttons')]")
	public WebElement cntOrderDetailsHeaderButtons;

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

	@FindBy(xpath = "//div[@class='tsc-forms']//div[contains(@class,'sub-order-section')]//div[contains(text(),'Shipping')]/following-sibling::div")
	public WebElement lblOrderDetailsSubHeaderShippingAddressMobile;

	@FindBy(xpath = "//ng-component//div[contains(@class,'order-items') and not(contains(@class,'sub-order-section'))]")
	public List<WebElement> lstOrderDetailsOrderItemList;

	public By byOrderDetailsOrderItemLink = By.xpath(".//div[contains(@class,'product-pic')]");
	public By byOrderDetailsOrderItemImage = By.xpath(".//div[contains(@class,'product-pic')]//img");

	public By byOrderDetailsOrderItemDescriptionContainer = By.xpath(".//div[contains(@class,'product-pic')]//img");
	public By byOrderDetailsOrderItemPipeStyleLink = By.xpath(".//div[contains(@class,'no-pad-col')]//div[contains(@class,'item-title')]");
	public By byOrderDetailsOrderItemProductNumber = By.xpath(".//a[contains(@href,'productdetails')][not(img)]/following-sibling::div/span[not(contains(@class,'item-title'))]|.//div[contains(@class,'no-pad-col')]//div[contains(@class,'item-title')]/following-sibling::div/span[not(contains(@class,'item-title'))]");
	public By byOrderDetailsOrderItemProductPrice = By.xpath(".//a[contains(@href,'productdetails')][not(img)]/following-sibling::div/span[contains(@class,'item-title')]|.//div[contains(@class,'no-pad-col')]//div[contains(@class,'item-title')]/following-sibling::div/span[contains(@class,'item-title')]");
	public By byOrderDetailsOrderItemWriteReview = By.xpath(".//div[contains(@class,'product-review') and contains(@class,'hidden-xs')]//a[contains(@href,'openreview')]");

	public By byOrderDetailsOrderItemQTYTitle = By.xpath(".//span[contains(normalize-space(.),'QTY:')]/parent::div[contains(@class,'hidden-xs')]/span[1]");
	public By byOrderDetailsOrderItemQTY = By.xpath(".//span[contains(normalize-space(.),'QTY:')]/parent::div[contains(@class,'hidden-xs')]/span[2]");
	public By byOrderDetailsOrderItemStatusTitle = By.xpath(".//span[contains(normalize-space(.),'Status:')]/parent::div[contains(@class,'hidden-xs')]/span[1]");
	public By byOrderDetailsOrderItemStatus = By.xpath(".//span[contains(normalize-space(.),'Status:')]/parent::div[contains(@class,'hidden-xs')]/span[2]");

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Billing Address']")
	public WebElement lblOrderDetailsBillingAddressTitle;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Payment Method']/preceding-sibling::div[contains(@class,'order-summary')]")
	public WebElement lblOrderDetailsBillingAddress;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Payment Method']")
	public WebElement lblOrderDetailsPaymentMethodTitle;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Payment Method']/following-sibling::div[contains(@class,'order-summary')]")
	public WebElement lblOrderDetailsPaymentMethod;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Order Summary']/following-sibling::div[contains(@class,'order-summary')]/div")
	public List<WebElement> lstOrderSummaryDetails;

	@FindBy(xpath = "//ng-component//div[contains(normalize-space(text()),'Billing Address')]/parent::div")
	public WebElement cntOrderDetailsPromotionalCodeContainer;

	@FindBy(xpath = "//ng-component//div[contains(normalize-space(text()),'Promotional Code:')]")
	public WebElement lblOrderDetailsPromotionalCodeTitle;

	@FindBy(xpath = "//ng-component//div[contains(normalize-space(text()),'Promotional Code:')]/following-sibling::div[contains(@class,'order-summary')]//*[@class='svgIconCheck']")
	public WebElement iconOrderDetailsPromotionalCodeCheck;

	@FindBy(xpath = "//ng-component//div[contains(normalize-space(text()),'Promotional Code:')]/following-sibling::div[contains(@class,'order-summary')]//span")
	public WebElement lblOrderDetailsPromotionalCode;

	//For Order Summary
	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Order Summary']/parent::div")
	public WebElement cntOrderDetailsOrderSummaryContainer;

	@FindBy(xpath = "//ng-component//div[contains(@class,'easy-pay')]")
	public WebElement cntOrderDetailsEasyPaySection;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Order Summary']/following-sibling::div[contains(@class,'tab-row') and contains(@class,'order-summary')]/div")
	public List<WebElement> lstOrderDetailsOrderSummaryItems;

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

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Monthly Payments with Easy Pay']")
	public WebElement lblOrderDetailsMonthlyPaymentsWithEasyPayTitle;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='No. of Easy Pays:']")
	public WebElement lblOrderDetailsEasyPaymentNumberTitle;

	@FindBy(xpath = "//ng-component//span[normalize-space(text())='No. of Easy Pays:']/following-sibling::span")
	public WebElement lblOrderDetailsEasyPaymentNumber;

	@FindBy(xpath = "//ng-component//a[contains(normalize-space(text()),'View Details')]")
	public WebElement lnkOrderDetailsViewDetails;

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
	@FindBy(xpath = "//div[@data-target='#paymentOptionsLinks']")
	public WebElement btnPaymentOptionsHeadingTitle;

	@FindBy(xpath = "//div[@id='paymentOptionsLinks']//li/a")
	public List<WebElement> lstpaymentOptions;

	@FindBy(xpath = "//span[@class='custNo']")
	public WebElement lblCustomerNumber;

	@FindBy(xpath = "//div[contains(@class,'editPayPad')]//ul/li/button/img")
	public List<WebElement> lstCardTypesForNewCreditCard;

	@FindBy(xpath = "//label//input[@name='isdefault']")
	public WebElement isDefaultCheckBoxForNewCreditCard;

	@FindBy(xpath = "//div[contains(@class,'form-group')]/button[contains(@class,'btn-default')]")
	public WebElement btnCancelAddCreditCardForNewCreditCard;

	@FindBy(xpath = "//div[contains(@class,'form-group')]/button[contains(@class,'btn-primary')]")
	public WebElement btnSaveAddCreditCardForNewCreditCard;

	@FindBy(xpath = "//*[@class='paymentPageTitle']")
	public WebElement lblAddCreditCardPageTitleForNewCreditCard;

	@FindBy(xpath = "//input[@id='pan']")
	public WebElement lblCardNumberForNewCreditCard;

	@FindBy(xpath = "//input[@id='ficard']")
	public WebElement lblCardNumberForNewTSCCreditCard;

	@FindBy(xpath = "//ul[@class='list-inline']//li/button[contains(@class,'active')]/img")
	public WebElement lblSelectedNewCreditCardToBeAdded;

	@FindBy(xpath = "//input[@id='maskedPan']")
	public WebElement getLblMaskedCardNumberForNewCreditCard;

	@FindBy(xpath = "//input[@id='ficard']")
	public WebElement lblTSCCreditCardInput;

	@FindBy(xpath = "//input[@id='maskedPan']")
	public WebElement lblMaskedCardNumberForNewCreditCard;

	@FindBy(xpath = "//div[@id='panExpirationDate']")
	public WebElement cntExpirationDateContainerForNewCreditCard;

	@FindBy(xpath = "//select[@name='month']")
	public WebElement lblExpirationMonthForNewCreditCard;

	@FindBy(xpath = "//select[@name='year']")
	public WebElement lblExpirationYearForNewCreditCard;

	@FindBy(xpath = "//div[@id='panExpirationDate']//div[contains(@class,'cvvFormGroup')]")
	public WebElement cntCVVContainerForNewCreditCard;

	@FindBy(xpath = "//div[@id='panExpirationDate']//label[contains(@class,'cvvLabel')]")
	public WebElement labelCVVForNewCreditCard;

	@FindBy(xpath = "//div[@id='panExpirationDate']//div[contains(@class,'cvvToolTip')]")
	public WebElement iconCVVTooltipForNewCreditCard;

	@FindBy(xpath = "//div[@id='panExpirationDate']//div[contains(@role,'tooltip')]")
	public WebElement lblCVVTooltipMessageForNewCreditCard;

	@FindBy(xpath = "//div[@id='panExpirationDate']/div[contains(@class,'cvvFormGroup')]//input")
	public WebElement inputCVVForNewCreditCard;

	@FindBy(xpath = "//div[contains(@class,'text-danger')]")
	public List<WebElement> lblErrorMessageForInvalidCreditCardNumber;

	@FindBy(xpath = "//button[contains(@class,'signout')]")
	public WebElement btnSignOutMyAccountPage;

	@FindBy(xpath = "//div[@id='semafoneCapturePage']/iframe")
	public WebElement iFrameForNewCreditCard;

	//PAYMENT OPTIONS - MANAGE CREDIT CARD
	@FindBy(xpath = "//div[contains(@class,'desktop-divider')]")
	public List<WebElement> lstCreditCardsPresent;
	//.//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')] - Edit Button

	@FindBy(xpath = "//div[@class='bigPaymentDiv']/div[contains(@class,'col')]")
	public List<WebElement> lstTotalCardsPresent;

	@FindBy(xpath = "//button[@id='addCardBtn']")
	public WebElement btnAddNewCreditCard;

	@FindBy(xpath = "//button[@id='addCardBtn']//div[contains(@class,'addBtnTxt')]")
	public WebElement lblAddNewCreditCardText;

	@FindBy(xpath = "//span[@class='table-cell']/label")
	public WebElement lblCardNameOnRemovePopUp;

	@FindBy(xpath = "//span[@class='table-cell']/span")
	public WebElement lblCardNumberOnRemovePopUp;

	@FindBy(xpath = "//div[@class='modal-body']//div[contains(@class,'clearfix')]/div/button[contains(text(),'REMOVE')]")
	public WebElement btnRemoveCreditCardButton;

	@FindBy(xpath = "//div[@class='modal-body']//div[contains(@class,'clearfix')]/div/button/span")
	public WebElement btnCancelRemoveCreditCardButton;

	@FindBy(xpath = "//*[@class='breadcrumb']/li/a[contains(text(),'Account')]")
	public WebElement lnkBreadCrumbMyAccount;

	//GIFT CARD BALANCE - PAYMENT OPTIONS
	@FindBy(xpath = "//*[contains(@id,'content')]//*[contains(@class,'titleLink')]")
	public WebElement lblGiftCardPageTitle;

	@FindBy(xpath = "//input[@id='giftcardNumber']")
	public WebElement lblGiftCardNumberEntryTextBox;

	@FindBy(xpath = "//input[@id='pin']")
	public WebElement lblGiftCardPinEntryTextBox;

	@FindBy(xpath = "//button[contains(@class,'btnResizing')]")
	public WebElement btmCheckGiftCardBalanceButton;

	@FindBy(xpath = "//form[contains(@class,'tsc-forms')]//div/strong")
	public WebElement lblGiftCardBalanceText;

	//For Your Addresses
	@FindBy(xpath = "//ng-component//*[contains(@class,'paymentPageTitle')]")
	public WebElement lblYourAddressTitle;

	@FindBy(xpath = "//ng-component//div[normalize-space(.)='Shipping Address']")
	public WebElement lblShippingAddressSectionTitle;

	/**
	 * @FindBy(xpath = "//ng-component//div[contains(@class,'bigAddressDiv') and not(contains(@class,'billing'))]//div[contains(@class,'tab-bottom-row')]")
	 * public List<WebElement> lstShippingAddressContainer;
	 */

	@FindBy(xpath = "//ng-component//div[contains(@class,'bigAddressDiv') and not(contains(@class,'billing'))]//div[contains(@class,'desktop-bottom-row')]")
	public List<WebElement> lstShippingAddressContainer;

	public By byShippingAddressTitle = By.xpath(".//div[contains(@class,'defaultDiv')]");
	public By byShippingAddress = By.xpath(".//div[contains(@class,'defaultDiv')]/following-sibling::div[contains(@class,'address')]");
	public By byShippingAddressEdit = By.xpath(".//div[contains(@class,'defaultDiv')]/following-sibling::div//a");

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

	@FindBy(xpath = "//div[contains(text(),'Address Line 1 cannot be more than 30')]")
	public WebElement lblAddressLin1ErrorMessage;

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

	public By byFavoriteItemImage = By.xpath(".//div[@class='on-air-prod-img']//img");
	public By byFavoriteItemName = By.xpath(".//div[@class='on-air-prod-name']");
	public By byFavoriteItemPriceContainer = By.xpath(".//div[@class='on-air-price-blk']");
	public By byFavoriteItemNowPrice = By.xpath(".//div[@class='on-air-price-blk']//span[@class='on-air-prod-price']");
	public By byFavoriteItemWasPrice = By.xpath(".//div[@class='on-air-price-blk']//span[@class='on-air-prod-was-price']");

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

	public By byRecentlyViewedItemLink = By.xpath(".//a");
	public By byRecentlyViewedItemImage = By.xpath(".//div[@class='on-air-prod-img']//img");
	public By byRecentlyViewedItemName = By.xpath(".//div[@class='on-air-prod-name']");
	public By byRecentlyViewedItemPriceContainer = By.xpath(".//div[@class='on-air-price-blk']");
	public By byRecentlyViewedItemNowPrice = By.xpath(".//div[@class='on-air-price-blk']//span[@class='on-air-prod-price']");
	public By byRecentlyViewedItemWasPrice = By.xpath(".//div[@class='on-air-price-blk']//span[@class='on-air-prod-was-price']");
	public By byRecentlyViewedItemEasyPayment = By.xpath(".//span[@class='or-payments']");
	public By byRecentlyViewedItemReviewRateStarList = By.xpath(".//div[@class='pr-rating-stars']//div[contains(@class,'pr-star-v4')]");
	public By byRecentlyViewedItemReviewAmount = By.xpath(".//div[contains(@class,'pr-category-snippet__total')]");

	//The same popup window as clear favorite history after clicking
	@FindBy(xpath = "//ng-component//div[contains(@class,'recently-viewed-title-block')]//button[contains(@class,'btn-clear-viewing-history')]")
	public WebElement btnClearViewingHistory;

	//For My Newsletter
	@FindBy(xpath = "//label[@for='MyNewsletters']/b")
	public WebElement lblMyNewsLettersTitle;

	@FindBy(xpath = "//span[contains(normalize-space(text()),'Manage your email preferences below:')]")
	public WebElement lblMyNewsLettersManageYourEmailPreferences;

	@FindBy(xpath = "//input[@id='Opt1']")
	public WebElement ckbMyNewsLettersTodayShowStopperNewsLetter;

	@FindBy(xpath = "//input[@id='Opt1']/following-sibling::b")
	public WebElement lblMyNewsLettersTodayShowStopperNewsLetterTitle;

	@FindBy(xpath = "//input[@id='Opt1']/parent::td/parent::tr/following-sibling::tr[td[span]][1]")
	public WebElement lblMyNewsLettersTodayShowStopperNewsLetterExplanationInfo;

	@FindBy(xpath = "//input[@id='Opt2']")
	public WebElement ckbMyNewsLettersSpecialOfferAndEventNewsLetter;

	@FindBy(xpath = "//input[@id='Opt2']/following-sibling::label")
	public WebElement lblMyNewsLettersSpecialOfferAndEventNewsLetterTitle;

	@FindBy(xpath = "//input[@id='Opt2']/parent::td/parent::tr/following-sibling::tr[td[span]][1]")
	public WebElement lblMyNewsLettersSpecialOfferAndEventNewsLetterExplanationInfo;

	@FindBy(xpath = "//input[@id='Opt3']")
	public WebElement ckbMyNewsLettersPreferredCustomerOffer;

	@FindBy(xpath = "//input[@id='Opt3']/following-sibling::label")
	public WebElement lblMyNewsLettersPreferredCustomerOfferTitle;

	@FindBy(xpath = "//input[@id='Opt3']/parent::td/parent::tr/following-sibling::tr[td[span]][1]")
	public WebElement lblMyNewsLettersPreferredCustomerOfferExplanationInfo;

	@FindBy(xpath = "//input[@id='Opt4']")
	public WebElement ckbMyNewsLettersProductUpdatesAndAlerts;

	@FindBy(xpath = "//input[@id='Opt4']/following-sibling::label")
	public WebElement lblMyNewsLettersProductUpdatesAndAlertsTitle;

	@FindBy(xpath = "//input[@id='Opt4']/parent::td/parent::tr/following-sibling::tr[td[span]][1]")
	public WebElement lblMyNewsLettersProductUpdatesAndAlertsExplanationInfo;

	@FindBy(xpath = "//button[@id='myButton1']")
	public WebElement btnMyNewsLettersUpdatePrefs;

	@FindBy(xpath = "//div[@id='preferenceNotificationErrorMsg']")
	public WebElement lblMyNewsLettersUpdateErrorMessage;

	@FindBy(xpath = "//div[@id='preferenceNotificationAlert']")
	public WebElement lblMyNewsLettersUpdateAlertMessage;

	@FindBy(xpath = "//input[@id='parent-6']")
	public WebElement ckbMyNewsLettersUnsubscribe;

	@FindBy(xpath = "//input[@id='parent-6']/following-sibling::b")
	public WebElement lblMyNewsLettersUnsubscribeTitle;

	@FindBy(xpath = "//input[@id='parent-6']/parent::td/parent::tr/following-sibling::tr[td[span]][1]")
	public WebElement lblMyNewsLettersUnsubscribeDescription;

	@FindBy(xpath = "//button[@id='myButton2']")
	public WebElement btnMyNewsLettersUnsubscribe;

	@FindBy(xpath = "//div[@id='unsubscribeNotificationErrorMsg']")
	public WebElement lblMyNewsLettersUnSubscribeErrorMessage;

	@FindBy(xpath = "//div[@id='unsubscribeNotificationAlert']")
	public WebElement lblMyNewsLettersUnSubscribeAlertMessage;

	@FindBy(xpath = "//iFrame[@id='ifrmEmailSignup']")
	public WebElement iFrameEmailSignup;

	@FindBy(xpath = "//p[contains(text(),'Thank you for your changes.')]")
	public WebElement lblSubscriptionSuccessMessage;

	@FindBy(xpath = "//ng-component//*[@class='breadcrumb']/li/a")
	public List<WebElement> lblBreadCrumbList;

	/**
	 * To get first name in header
	 *
	 * @return - String
	 */
	public String getFirstNameInHeader() {
		this.waitForCondition(Driver -> {
			return this.lblOrderDetailsHeaderUserName.isDisplayed();
		}, 120000);
		return this.getElementInnerText(this.lblOrderDetailsHeaderUserName).split("’")[0];
	}

	/**
	 * To get Customer Number in header
	 *
	 * @return - String
	 */
	public String getCustomerNumberInHeader() {
		this.waitForCondition(Driver -> {
			return this.lblOrderDetailsHeaderCustomerNumber.isDisplayed();
		}, 120000);
		return this.getElementInnerText(this.lblOrderDetailsHeaderCustomerNumber);
	}

	/**
	 * To check Collapse Status For Account Summary Panel
	 *
	 * @param - webelement - AccountSummaryPanel
	 * @return - boolean - true for expanded
	 */
	public boolean checkCollapseStatusForAccountSummaryPanel(WebElement AccountSummaryPanel) {
		WebElement item = AccountSummaryPanel.findElement(bySubHeader);
		if (this.hasElementAttribute(item, "aria-expanded")) {
			return item.getAttribute("aria-expanded").equalsIgnoreCase("true");
		} else {
			return false;
		}
	}

	/**
	 * To check MyNewsLetters Update Error Message Visible
	 *
	 * @return - boolean
	 */
	public boolean checkMyNewsLettersUpdateErrorMessageVisible() {
		return !lblMyNewsLettersUpdateErrorMessage.getAttribute("style").contains("display: none");
	}

	/**
	 * To check MyNewsLetters Update Alert Message Visible
	 *
	 * @return - boolean
	 */
	public boolean checkMyNewsLettersUpdateAlertMessageVisible() {
		return !lblMyNewsLettersUpdateAlertMessage.getAttribute("style").contains("display: none");
	}

	/**
	 * To check MyNewsLetters UnSubscribe Error Message Visible
	 *
	 * @return- boolean
	 */
	public boolean checkMyNewsLettersUnSubscribeErrorMessageVisible() {
		return !lblMyNewsLettersUnSubscribeErrorMessage.getAttribute("style").contains("display: none");
	}

	/**
	 * To check MyNewsLetters UnSubscribe Alert Message Visible
	 *
	 * @return- boolean
	 */
	public boolean checkMyNewsLettersUnSubscribeAlertMessageVisible() {
		return !lblMyNewsLettersUnSubscribeAlertMessage.getAttribute("style").contains("display: none");
	}

	/**
	 * To check OrderList Existing
	 *
	 * @return - boolean
	 */
	public boolean checkOrderListExisting() {
		this.applyStaticWait(3 * this.getStaticWaitForApplication());
		return !this.getElementInnerText(cntOrderListContainer).trim().contains("No orders yet");
	}

	/**
	 * To check Product Number And Write Review Button Existing
	 *
	 * @param - boolean
	 */
	public boolean checkProductNumberAndWriteReviewButtonExisting(WebElement orderItem) {
		WebElement item = orderItem.findElement(this.byOrderDetailsOrderItemDescriptionContainer);
		return this.checkChildElementExistingByAttribute(item, "class", "product-review");
	}

	/**
	 * To check Track Order Button Existing
	 *
	 * @param - boolean
	 */
	public boolean checkTrackOrderButtonExisting() {
		return this.getChildElementCount(this.cntOrderDetailsHeaderButtons) > 1;
	}

	/**
	 * To check Promotional Code Section Existing
	 *
	 * @param - boolean
	 */
	public boolean checkPromotionalCodeSectionExisting() {
		return this.getChildElementCount(this.cntOrderDetailsPromotionalCodeContainer) > 4;
	}

	/**
	 * To check EasyPayment Section Existing
	 *
	 * @param - boolean
	 */
	public boolean checkEasyPaymentSectionExisting() {
		int childCount = this.getChildrenList(cntOrderDetailsEasyPaySection).size();
		if (childCount > 0)
			return true;
		else
			return false;
		//return this.checkChildElementExistingByAttribute(cntOrderDetailsOrderSummaryContainer,"class","easy-pay");
	}

	/**
	 * To get header item web element through header item text
	 *
	 * @param - lsHeaderItem -  header item text
	 * @return header Item web element
	 */
	public WebElement getHeaderItem(String lsHeaderItem) {
		String lsByHeaderItem = "//div[@class='my-account-summary-container']//div[@class='panel']/div[contains(@class,'panel-heading') and contains(normalize-space(.),'" + lsHeaderItem + "')]";
		return this.getDriver().findElement(By.xpath(lsByHeaderItem));
	}

	/**
	 * To get subitem web element through sublitem text
	 *
	 * @param - lsSubItem -  sublitem text
	 * @return subitem web element
	 */
	public WebElement getSubItem(String lsSubItem) {
		if (lsSubItem.contains("(") && lsSubItem.contains(")")) {
			lsSubItem = lsSubItem.trim();
			lsSubItem = lsSubItem.substring(0, lsSubItem.indexOf("("));
		}

		String lsBySubItem = "//div[@class='my-account-summary-container']//div[@class='panel']//ul//li[not(contains(@class,'hidden'))]//a[contains(normalize-space(.),'" + lsSubItem + "')]";
		return this.getDriver().findElement(By.xpath(lsBySubItem));
	}

	/**
	 * To uncollapse all order service items
	 */
	public void UnCollapsedAllOrderServiceItems() {
		for (int i = 0; i < this.lstOrderServiceItemTitleLink.size(); i++) {
			final int tempIndex = i;
			if (!this.lstOrderServiceItemTitleLink.get(i).getAttribute("class").isEmpty()) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(lstOrderServiceItemTitleLink.get(i));
				this.clickWebElementUsingJS(lstOrderServiceItemTitleLink.get(i));
				//this.getReusableActionsInstance().clickIfAvailable(lstOrderServiceItemTitleLink.get(i));
				this.waitForCondition(Driver -> {
					return lstOrderServiceItemTitleLink.get(tempIndex).getAttribute("class").isEmpty();
				}, 20000);
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			}
		}
	}

	/**
	 * To check if a given order service item is uncollapsed
	 *
	 * @param - orderServiceItem - WebElement
	 * @return true/false
	 */
	public boolean IsUnCollapsedForGivenOrderServiceItem(WebElement orderServiceItem) {
		return orderServiceItem.getAttribute("class").isEmpty();
	}

	/**
	 * To get Service WebElement With Given Service item Name
	 *
	 * @param - lsServiceItemName - given Given Service item Name
	 * @return - WebElement
	 */
	public WebElement getServiceWebElementWithGivenServiceName(String lsServiceItemName) {
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
	 *
	 * @param- String - page Title
	 */
	public void verifyNewCardTypesAvailable(String pageTitle) {
		//Verifying page title for new Credit Card addition
		waitForCondition(Driver -> {
			return this.lblAddCreditCardPageTitleForNewCreditCard.isDisplayed();
		}, 5000);
		String pageTitleOnApp = this.lblAddCreditCardPageTitleForNewCreditCard.getText();
		if (pageTitleOnApp.equalsIgnoreCase(pageTitle))
			reporter.reportLogPass("Page Title for adding New Credit Card is as expected: " + pageTitleOnApp);
		else
			reporter.reportLogFailWithScreenshot("Page Title for adding New Credit Card on application: " + pageTitleOnApp + " is not same as expected: " + pageTitle);

		//Verifying four Card Types
		List<String> cardTypesOnApp = new ArrayList<>();
		int cardCounter = 0;
		for (WebElement cardType : this.lstCardTypesForNewCreditCard) {
			String cardTypeFetched = cardType.getAttribute("alt");
			cardTypesOnApp.add(cardTypeFetched);
			if (cardTypeFetched.equalsIgnoreCase("visa") ||
					cardTypeFetched.equalsIgnoreCase("master") ||
					cardTypeFetched.equalsIgnoreCase("amex") ||
					cardTypeFetched.equalsIgnoreCase("tsc"))
				cardCounter++;
		}

		if (cardCounter == 4)
			reporter.reportLogPass("All four Credit Card Types are present on application to add as expected");
		else
			reporter.reportLogFailWithScreenshot("All expected credit card are not present on application: " + cardTypesOnApp);
	}

	/**
	 * This function clicks on sub-menu item present on My Account Page
	 */
	public void clickOnPaymentOptionSubMenuItemsOnMyAccount(String subMenu) {
		this.waitForPageToLoad();
		String lsTestDevice = System.getProperty("Device").trim();
		String lsTestBrowser = System.getProperty("Browser").toLowerCase().trim();
		if (lsTestDevice.equalsIgnoreCase("Mobile") || (lsTestDevice.equalsIgnoreCase("Tablet") && lsTestBrowser.contains("android")) || System.getProperty("chromeMobileDevice").contains("iPad")) {
			if (this.btnPaymentOptionsHeadingTitle.getAttribute("class").contains("collapsed")) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnPaymentOptionsHeadingTitle);
				this.getReusableActionsInstance().clickIfAvailable(this.btnPaymentOptionsHeadingTitle);
				this.getReusableActionsInstance().staticWait(2 * this.getStaticWaitForApplication());
			}
		}

		boolean flag = false;
		for (WebElement webElement : this.lstpaymentOptions) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
			if (webElement.getText().contains(subMenu)) {
				this.clickElement(webElement);
				flag = true;
				break;
			}
		}
		if (subMenu.toLowerCase().contains("add"))
			waitForCondition(Driver -> {
				return this.btnCancelAddCreditCardForNewCreditCard.isEnabled() &&
						this.btnCancelAddCreditCardForNewCreditCard.isDisplayed();
			}, 12000);
		else if (subMenu.toLowerCase().contains("manage")) {
			this.waitForPageToLoad();
			String pageTitle = this.lblPageTitle.getText();
			if (pageTitle.toLowerCase().contains("manage"))
				waitForCondition(Driver -> {
					return this.lstCreditCardsPresent.size() >= 0;
				}, 6000);
			else if (pageTitle.toLowerCase().contains("add"))
				waitForCondition(Driver -> {
					return (this.btnCancelAddCreditCardForNewCreditCard.isEnabled() &&
							this.btnCancelAddCreditCardForNewCreditCard.isDisplayed());
				}, 6000);
		} else {
			this.waitForPageToLoad();
			this.waitForCondition(Driver -> {
				return this.lblGiftCardPageTitle.getText().toLowerCase().contains("gift");
			}, 6000);
		}

		if (!flag)
			reporter.reportLogFailWithScreenshot("Provided sub-menu: " + subMenu + " is not present. Please verify once again!");
	}

	/**
	 * This function returns expiration data for new Credit Card
	 *
	 * @return - Map<String,String> - Expiration Month and Year Data for Card
	 * @throws ParseException
	 */
	public Map<String, String> getNewCardExpirationData(int monthsToBeAdded, int yearsToBeAdded) throws ParseException {
		Map<String, String> cardData = new HashMap<>();
		String[] date = new DataConverter().getLocalDate().split("-");
		int calculatedExpirationMonth = Integer.valueOf(date[1]) + monthsToBeAdded > 12 ? (Integer.parseInt(date[1]) + monthsToBeAdded) - 12 : Integer.valueOf(date[1]) + monthsToBeAdded;
		String expirationMonth = String.valueOf(calculatedExpirationMonth);
		if (expirationMonth.length() == 1)
			expirationMonth = "0" + expirationMonth;
		String expirationYear = String.valueOf(Integer.valueOf(date[0]) + yearsToBeAdded);
		cardData.put("expirationMonth", expirationMonth);
		cardData.put("expirationYear", expirationYear);
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
			getDriver().switchTo().parentFrame();
		else if(!selectedCreditCardType.toLowerCase().contains("tsc"))
			getDriver().switchTo().parentFrame();
	}

	/**
	 * This function adds Credit Card Expiration Month and Year
	 *
	 * @param -Map<String,String> - cardData
	 */
	public void addExpirationMonthAndYear(Map<String, String> cardData) {
		getReusableActionsInstance().selectWhenReady(this.lblExpirationMonthForNewCreditCard, cardData.get("expirationMonth"), 6000);
		getReusableActionsInstance().selectWhenReady(this.lblExpirationYearForNewCreditCard, cardData.get("expirationYear"), 6000);
	}

	/**
	 * Adding new Credit Card for User
	 *
	 * @param - String - cardNumber to be added
	 * @param - String - expirationMonth for Credit Card
	 * @param - String - expirationYear for Credit Card
	 * @param - boolean - isDefault value for Credit Card attached to user
	 * @param- String - cardType to be added
	 */
	public Map<String, String> addNewValidCreditCardForUser(String cardType, String cardNumber, String cardCVV, boolean isDefault) throws ParseException {
		String cardTypeToBeAdded = this.createXPath("//div[contains(@class,'editPayPad')]//ul/li/button/img[contains(@alt,'{0}')]", cardType);
		WebElement cardTypeElement = getDriver().findElement(By.xpath(cardTypeToBeAdded));

		//Calculating expiration Year And Month for Card
		Map<String, String> cardData = this.getNewCardExpirationData(2, 2);

		waitForCondition(Driver -> {
			return cardTypeElement.isDisplayed() && cardTypeElement.isEnabled();
		}, 5000);
		this.clickWebElementUsingJS(cardTypeElement);

		if (!cardType.equalsIgnoreCase("tsc")) {
			this.addNewOrEditExistingCreditCardNumber(cardType, cardNumber, true);
			//Selecting Expiration Month and Year
			this.addExpirationMonthAndYear(cardData);
			if(this.checkCVVSectionExisting()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputCVVForNewCreditCard);
				inputCVVForNewCreditCard.clear();
				inputCVVForNewCreditCard.sendKeys(cardCVV);
			}
		} else
			this.lblTSCCreditCardInput.sendKeys(cardNumber);

		//Click on Save Button
		if (isDefault)
			getReusableActionsInstance().clickIfAvailable(this.isDefaultCheckBoxForNewCreditCard, 2000);
		this.clickElement(this.btnSaveAddCreditCardForNewCreditCard);
		return cardData;
	}

	/**
	 * This function converts input expiration data to displayed format on application
	 *
	 * @param -String - expirationMonth
	 * @param -       String - expirationYear
	 * @return - String
	 */
	public String formatExpirationDateForCreditCard(String expirationMonth, String expirationYear) {
		if (expirationMonth.startsWith("0"))
			expirationMonth = expirationMonth.substring(expirationMonth.length() - 1);
		if (expirationYear.length() > 2)
			expirationYear = expirationYear.substring(expirationYear.length() - 2);
		return (expirationMonth + "/" + expirationYear).trim();
	}

	/**
	 * This function verifies newly added Credit Card for user
	 *
	 * @return - boolean - true/false
	 * @param- String - cardType that is added
	 * @param- String - cardNumber that is added
	 * @param- String - expirationMonth of card that is added
	 * @param- String - expirationYear of card that is added
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
				inputExpirationData = this.formatExpirationDateForCreditCard(expirationMonth, expirationYear);
				if (expiresOnData.trim().equals(inputExpirationData)) {
					reporter.reportLog("Card Type: " + imageType + " and expiration year is same as added: " + expiresOnData);
					//Verifying Image Type and CardType is same that is displayed in application for user
					WebElement cardTypeWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
					String cardTypeDisplayed = cardTypeWebElement.getText();
					if (cardTypeDisplayed.equalsIgnoreCase(cardDisplayName)) {
						//Verifying the card number added
						WebElement expiresWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/span"));
						value = this.verifyCardNumberAddedForUser(expiresWebElement, cardNumber, cardType);
						break;
					} else
						reporter.reportLogFailWithScreenshot("Card Type added is not same as expected: " + cardTypeDisplayed);
				}
			} else {
				WebElement cardTypeWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
				String cardTypeDisplayed = cardTypeWebElement.getText();
				if (cardTypeDisplayed.equalsIgnoreCase(cardDisplayName)) {
					//Verifying the card number added
					WebElement expiresWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/span"));
					value = this.verifyCardNumberAddedForUser(expiresWebElement, cardNumber, cardType);
					break;
				}
			}
		}
		if (value)
			reporter.reportLogPass("Credit Card: " + cardNumber + " with type: " + cardType + " is added as expected for the user");
		else
			reporter.reportLogFailWithScreenshot("Credit Card: " + cardNumber + " with type: " + cardType + " is not added as expected for the user");

		//Remove Credit Card associated
		if (removeCard)
			this.removeCreditCardFromUser(cardType, cardNumber, inputExpirationData, true);
	}

	/**
	 * This function verifies the displayed last digits of Credit Card Number
	 *
	 * @param - String - cardNumber that is added
	 * @param - String - cardType that is added
	 * @return - boolean - true/false
	 */
	public boolean verifyCardNumberAddedForUser(WebElement webElement, String cardNumber, String cardType) {
		String inputLastDigitsOfCard = null;
		String lastDigitsOfCard = webElement.getText().split("\\s+")[2];
		/**
		 if(cardType.equalsIgnoreCase("visa"))
		 inputLastDigitsOfCard = cardNumber.substring(cardNumber.length()-3);
		 else if(cardType.equalsIgnoreCase("master"))
		 inputLastDigitsOfCard = cardNumber.substring(cardNumber.length()-4);
		 */
		inputLastDigitsOfCard = cardNumber.substring(cardNumber.length() - 4);
		if (lastDigitsOfCard.equals(inputLastDigitsOfCard))
			return true;
		else
			return false;
	}

	/**
	 * This functions selects the credit card either for removal or for edit functionality
	 *
	 * @param - String - cardNumber
	 * @param - String - cardType
	 * @param - String - expirationMonthAndYear
	 */
	public void selectGivenCreditCard(String cardNumber, String cardType, String expirationMonthAndYear, boolean selectForRemove) {
		int beforeDeleteCreditCardsPresent = lstCreditCardsPresent.size();
		WebElement expiresOnWebElement = null;
		WebElement removeButtonWebElement, editButtonWebElement;
		String expiresOnData = null;
		boolean value = false;
		for (int counter = 0; counter < beforeDeleteCreditCardsPresent; counter++) {
			WebElement cardImage = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[contains(@class,'padding-right')]/img"));
			String imageType = cardImage.getAttribute("alt");
			if (!imageType.toLowerCase().contains("tsc")) {
				expiresOnWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//div[@class='table-cell']"));
				expiresOnData = expiresOnWebElement.getText().split(":")[1].trim();
				if (expiresOnData.trim().equals(expirationMonthAndYear)) {
					WebElement expiresWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/span"));
					value = this.verifyCardNumberAddedForUser(expiresWebElement, cardNumber, cardType);
					if (value) {
						//Removing the matched Credit Card
						if (selectForRemove) {
							removeButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallLeftPadding')]/a[contains(@class,'negative')]"));
							this.getReusableActionsInstance().javascriptScrollByVisibleElement(removeButtonWebElement);
							this.getReusableActionsInstance().clickIfAvailable(removeButtonWebElement);
							//this.clickElement(removeButtonWebElement);
							waitForCondition(Driver -> {
								return this.btnRemoveCreditCardButton.isDisplayed() &&
										this.btnRemoveCreditCardButton.isEnabled();
							}, 6000);
						} else {
							editButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')]"));
							this.getReusableActionsInstance().javascriptScrollByVisibleElement(editButtonWebElement);
							this.getReusableActionsInstance().clickIfAvailable(editButtonWebElement);
							//this.clickElement(editButtonWebElement);
							waitForCondition(Driver -> {
								return this.btnSaveAddCreditCardForNewCreditCard.isDisplayed() &&
										this.btnSaveAddCreditCardForNewCreditCard.isEnabled();
							}, 6000);
						}
						break;
					}
				}
			} else if (cardType.toLowerCase().contains("tsc")) {
				if (selectForRemove) {
					removeButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallLeftPadding')]/a[contains(@class,'negative')]"));
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(removeButtonWebElement);
					this.getReusableActionsInstance().clickIfAvailable(removeButtonWebElement);
					//this.clickElement(removeButtonWebElement);
					waitForCondition(Driver -> {
						return this.btnRemoveCreditCardButton.isDisplayed() &&
								this.btnRemoveCreditCardButton.isEnabled();
					}, 6000);
				} else {
					editButtonWebElement = lstCreditCardsPresent.get(counter).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'smallRightPadding')]/a[contains(@class,'negative')]"));
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(editButtonWebElement);
					this.getReusableActionsInstance().clickIfAvailable(editButtonWebElement);
					//this.clickElement(editButtonWebElement);
					waitForCondition(Driver -> {
						return this.btnSaveAddCreditCardForNewCreditCard.isDisplayed() &&
								this.btnSaveAddCreditCardForNewCreditCard.isEnabled();
					}, 6000);
				}
				break;
			}
		}
	}

	/**
	 * This function verifies card on remove popup
	 *
	 * @param - String - cardDetails
	 */
	public void verifyCardTypeAndNameOnRemove(String cardType, String cardNumber) {
		String appCardDetails = this.lblCardNameOnRemovePopUp.getText().trim() + " " + this.lblCardNumberOnRemovePopUp.getText().trim();
		if (cardType.contains("amex"))
			cardType = "american express";
		if (appCardDetails.toLowerCase().contains(cardType.toLowerCase()) && appCardDetails.contains(cardNumber))
			reporter.reportLogPass("Card Number deleted is same as expected: " + appCardDetails);
		else
			reporter.reportLogFailWithScreenshot("Card Number that is deleted: " + appCardDetails + " is not as expected for type: " + cardType);
	}

	/**
	 * This functions removes provided Credit Card attached to user
	 *
	 * @param -       String - cardType
	 * @param -       String - cardNumber
	 * @param -String - expirationMonthAndYear
	 */
	public void removeCreditCardFromUser(String cardType, String cardNumber, String expirationMonthAndYear, boolean removeCard) {
		int beforeDeleteCreditCardsPresent = lstCreditCardsPresent.size();
		this.selectGivenCreditCard(cardNumber, cardType, expirationMonthAndYear, true);
		if (removeCard) {
			this.verifyCardTypeAndNameOnRemove(cardType, cardNumber.substring(cardNumber.length() - 4));
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnRemoveCreditCardButton);
			this.getReusableActionsInstance().clickIfAvailable(this.btnRemoveCreditCardButton);
			//this.clickElement(this.btnRemoveCreditCardButton);
		} else {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCancelRemoveCreditCardButton);
			this.getReusableActionsInstance().clickIfAvailable(this.btnCancelRemoveCreditCardButton);
			//this.clickElement(this.btnCancelRemoveCreditCardButton);
		}

		//Verification that card is removed
		//Applying static wait for 5 seconds as application takes time to refresh and there is no unique element for wait for condition to be used
		getReusableActionsInstance().staticWait(5000);
		//Subtracting 1 from size as we are including 'Add Credit Card' xpath as well for decreasing execution time
		int afterDeleteCreditCardsPresent = lstTotalCardsPresent.size() - 1;
		boolean flag = removeCard == true ? afterDeleteCreditCardsPresent == beforeDeleteCreditCardsPresent - 1 : afterDeleteCreditCardsPresent == beforeDeleteCreditCardsPresent;
		if (flag)
			reporter.reportLogPass("Credit Card: " + cardNumber + " of type: " + cardType + " is removed from user");
		else
			reporter.reportLogFailWithScreenshot("Credit Card: " + cardNumber + " of type: " + cardType + " is not removed from user");
	}

	/**
	 * This functions edits added Credit Card with user
	 *
	 * @param -       String - cardType
	 * @param -       String - cardNumber
	 * @param -String - expirationMonthAndYear
	 */
	public Map<String, String> editAndVerifyCreditCardAttachedToUser(String cardType, String cardDisplayName, String cardNumber, String expirationMonthAndYear, JSONObject creditCardsData, boolean editCard) throws ParseException {
		Map<String, String> cardData = new HashMap<>();
		if (cardType != null) {
			cardData.put("cardType", cardType);
			cardData.put("cardNumber", cardNumber);
			cardData.put("expirationMonthAndYear", expirationMonthAndYear);
			this.selectGivenCreditCard(cardNumber, cardType, expirationMonthAndYear, false);
		} else {
			cardData = this.getFirstCreditCardDetailsAndSelect();
			//String cardTypeAdded = this.getCreditCardTypeName(cardData.get("cardType"));
			JSONObject creditCard = (JSONObject) creditCardsData.get(cardData.get("cardType"));
			cardNumber = creditCard.get("Number").toString();
			cardData.put("cardNumber", cardNumber);
				}
		this.addNewOrEditExistingCreditCardNumber(cardType, cardNumber, false);

		if (expirationMonthAndYear != null) {
			String[] expirationData = expirationMonthAndYear.split("/");
			int updatedMonth = Integer.valueOf(expirationData[0]) + 1 > 12 ? (Integer.valueOf(expirationData[0]) + 1) - 12 : Integer.valueOf(expirationData[0]) + 1;
			int updatedYear = Integer.valueOf(expirationData[1]) + 1;
			cardData.put("expirationMonth", String.valueOf(updatedMonth));
			cardData.put("expirationYear", String.valueOf(updatedYear));
		}
		if (!cardData.get("cardType").toLowerCase().contains("tsc")) {
			this.addExpirationMonthAndYear(cardData);
			this.waitForPageToLoad();
			}
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSaveAddCreditCardForNewCreditCard);

		if (editCard) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSaveAddCreditCardForNewCreditCard);
			this.getReusableActionsInstance().clickIfAvailable(this.btnSaveAddCreditCardForNewCreditCard);
			//this.clickElement(this.btnSaveAddCreditCardForNewCreditCard);
		} else {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCancelAddCreditCardForNewCreditCard);
			this.getReusableActionsInstance().clickIfAvailable(this.btnCancelAddCreditCardForNewCreditCard);
			//this.clickElement(this.btnCancelAddCreditCardForNewCreditCard);
		}

		//Verification of Updated Data for Credit Card
		if (cardType != null)
			this.verifyNewAddedCreditCardForUser(cardType, cardDisplayName, cardNumber, cardData.get("expirationMonth"), cardData.get("expirationYear"), false);
		else {
			if (editCard)
				this.verifyNewAddedCreditCardForUser(cardData.get("cardType"), cardData.get("cardDisplayName"), cardNumber, cardData.get("expirationMonth"), cardData.get("expirationYear"), false);
			else
				this.verifyNewAddedCreditCardForUser(cardData.get("cardType"), cardData.get("cardDisplayName"), cardNumber, cardData.get("actualExpirationMonth"), cardData.get("actualExpirationYear"), false);
		}
		return cardData;
	}

	/**
	 * This function selects first credit card displayed on Manage Screen by default when no Credit Card is provided
	 */
	public Map<String, String> getFirstCreditCardDetailsAndSelect() throws ParseException {
		Map<String, String> creditCardDisplayedData = new HashMap<>();
		String updatedMonth = null, updatedYear = null, actualExpirationMonth = null, actualExpirationYear = null;
		this.waitForCondition(Driver -> {
			return lstCreditCardsPresent.size() > 0;
		}, 10000);
		//Fetching Card Details to be edited to be used for verification
		WebElement cardTypeWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardTypeWebElement);
		String cardType = cardTypeWebElement.getText();
		WebElement cardDisplayTypeWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//span[@class='table-cell ']/label"));
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardDisplayTypeWebElement);
		String cardDisplayName = cardDisplayTypeWebElement.getText();
		if (!cardType.toLowerCase().contains("tsc")) {
			WebElement expiresOnWebElement = lstCreditCardsPresent.get(0).findElement(By.xpath(".//div[contains(@class,'margin-top-md')]//div[contains(@class,'zeroRightPadding')]//div[@class='table-cell']"));
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(expiresOnWebElement);
			String[] expiresOnData = expiresOnWebElement.getText().split(":")[1].split("/");

			updatedMonth = Integer.valueOf(expiresOnData[0].trim()) + 1 > 12 ? String.valueOf((Integer.valueOf(expiresOnData[0].trim()) + 1) - 12) : String.valueOf(Integer.valueOf(expiresOnData[0].trim()) + 1);
			if (updatedMonth.length() == 1)
				updatedMonth = "0" + updatedMonth;
			Map<String, String> updatedYearData = getNewCardExpirationData(2, 2);
			updatedYear = updatedYearData.get("expirationYear");
			actualExpirationMonth = expiresOnData[0].trim();
			actualExpirationYear = expiresOnData[1].trim();

			creditCardDisplayedData.put("cardType", this.getCreditCardTypeName(cardType));
			creditCardDisplayedData.put("cardDisplayName", cardDisplayName);
			creditCardDisplayedData.put("expirationMonth", updatedMonth);
			creditCardDisplayedData.put("expirationYear", updatedYear);
			creditCardDisplayedData.put("actualExpirationMonth", actualExpirationMonth);
			creditCardDisplayedData.put("actualExpirationYear", actualExpirationYear);
			creditCardDisplayedData.put("expirationMonthAndYear", actualExpirationMonth + "/" + actualExpirationYear);
		} else {
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
	public void clickAddNewCreditCardOnManageCreditCardScreen() {
		this.clickElement(this.btnAddNewCreditCard);
		this.waitForPageToLoad();
		waitForCondition(Driver -> {
			return this.btnCancelAddCreditCardForNewCreditCard.isEnabled() &&
					this.btnCancelAddCreditCardForNewCreditCard.isDisplayed();
		}, 12000);
	}

	/**
	 * This function fetches Credit Card type name on basis of displayed name on application
	 */
	public String getCreditCardTypeName(String displayName) {
		if (displayName.toLowerCase().contains("visa"))
			return "visa";
		else if (displayName.toLowerCase().contains("tsc"))
			return "tsc";
		else if (displayName.toLowerCase().contains("american"))
			return "amex";
		else
			return "master";
	}

	/**
	 * This functions navigates to My Account page from breadcrumb
	 */
	public void navigateToMyAccountFromBreadCrumb() {
		this.clickElement(this.lnkBreadCrumbMyAccount);
		this.waitForPageToLoad();
		waitForCondition(Driver -> {
			return this.lstpaymentOptions.size() > 0 &&
					this.lstpaymentOptions.get(0).isEnabled();
		}, 6000);
	}

	/**
	 * This function verifies error message on passing invalid Credit Card Number
	 *
	 * @param - String - expectedErrorMessage
	 */
	public void verifyInvalidCreditCardErrorMessage(String expectedErrorMessage) {
		waitForCondition(Driver -> {
			return this.lblErrorMessageForInvalidCreditCardNumber.get(0).isDisplayed();
		}, 5000);
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblErrorMessageForInvalidCreditCardNumber.get(0));
		String actualErrorMessage = this.lblErrorMessageForInvalidCreditCardNumber.get(0).getText().trim();
		if (actualErrorMessage.equalsIgnoreCase(expectedErrorMessage))
			reporter.reportLogPass("Error Message on passing invalid Card Number is as expected: " + actualErrorMessage);
		else
			reporter.reportLogFailWithScreenshot("Error Message on passing invalid Card Number :" + actualErrorMessage + " is not as expected: " + expectedErrorMessage);
	}

	/**
	 * This function verifies gift card balance
	 *
	 * @param - String - giftCardNumber for balance verification
	 * @param - String - pin for card
	 * @param - String - balance for gift card
	 */
	public void getAndVerifyGiftCardBalance(String giftCardNumber, String pin, String balance) {
		//Enter gift card
		getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblGiftCardNumberEntryTextBox);
		this.lblGiftCardNumberEntryTextBox.sendKeys(giftCardNumber);
		//Enter pin
		this.lblGiftCardPinEntryTextBox.sendKeys(pin);
		getReusableActionsInstance().clickIfAvailable(this.btmCheckGiftCardBalanceButton, 2000);

		this.waitForCondition(Driver -> {
			return this.lblGiftCardBalanceText.isDisplayed() &&
					!this.lblGiftCardBalanceText.getText().toLowerCase().trim().contains("pending");
		}, 30000);

		String balanceText = this.lblGiftCardBalanceText.getText().trim().split(":")[1];

		if (balanceText != null && balanceText.equalsIgnoreCase(balance))
			reporter.reportLogPass("Balance for Gift Card: " + giftCardNumber + " is same as expected: " + balanceText);
		else if (balanceText.contains("$"))
			reporter.reportLogPassWithScreenshot("Balance for Gift Card: " + giftCardNumber + " is present: " + balanceText);
		else
			reporter.reportLogFailWithScreenshot("Balance for Gift Card: " + giftCardNumber + " is not as expected: " + balanceText);
	}

	/**
	 * To open the window by clicking sub item
	 *
	 * @param - lsHeaderItem - header item name
	 * @param - lsSubItem - sub item name
	 * @param - loadingIndicator - the element to indicate window loading
	 */
	public int openSubItemWindow(String lsHeaderItem, String lsSubItem, WebElement loadingIndicator) {
		String lsTestDevice = System.getProperty("Device").trim();
		String lsTestBrowser = System.getProperty("Browser").toLowerCase().trim();
		if (lsTestDevice.equalsIgnoreCase("Mobile") || (lsTestDevice.equalsIgnoreCase("Tablet") && lsTestBrowser.contains("android")) || System.getProperty("chromeMobileDevice").contains("iPad")) {
			WebElement headerButton = this.getHeaderItem(lsHeaderItem);
			if (headerButton.getAttribute("class").contains("collapsed")) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(headerButton);
				this.getReusableActionsInstance().clickIfAvailable(headerButton);
				this.getReusableActionsInstance().staticWait(6 * this.getStaticWaitForApplication());
			}
		}

		WebElement subButton = this.getSubItem(lsSubItem);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(subButton);
		int count = 0;
		String lsText = subButton.getText();
		if (lsText.contains("(")) {
			count = this.getIntegerFromString(lsText);
		}

		if (this.getReusableActionsInstance().isElementVisible(subButton)) {
			reporter.reportLogPass("'" + lsSubItem + "' sub item is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("'" + lsSubItem + "' sub item is not displaying correctly");
		}
		this.getReusableActionsInstance().clickIfAvailable(subButton);

		this.getReusableActionsInstance().staticWait(5 * this.getStaticWaitForApplication());
		if (loadingIndicator != null) {
			this.waitForCondition(Driver -> {
				return loadingIndicator.isDisplayed();
			}, 50000);
		}

		return count;
	}

	/**
	 * To get a random orderNO from order item list
	 *
	 * @return - String - a random orderNO
	 */
	public String getRandomOrderNumber() {
		int optionSize = this.lstOrderItemList.size();
		if (optionSize == 0) {
			return null;
		}

		int randomNumber = 0;
		if (optionSize > 2) {
			Random rand = new Random();
			randomNumber = rand.nextInt(optionSize - 2);
		}

		WebElement randomItem = this.lstOrderItemList.get(randomNumber).findElement(byOrderNo);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(randomItem);

		return randomItem.getText().trim();
	}

	/**
	 * To verify order status
	 *
	 * @param - bRecentOrder - is order status or recent order
	 */
	public void verifyOrderStatusSection(boolean bRecentOrder, String expectedNoOrderRecorderMessage) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderStatusSectionTitle);
		if (!this.lblOrderStatusSectionTitle.getText().isEmpty()) {
			reporter.reportLogPass("Order Status Section Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order Status Section Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputAccountOrderSearch);
		if (this.getReusableActionsInstance().isElementVisible(this.inputAccountOrderSearch)) {
			reporter.reportLogPass("search order input field is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("search order input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAccountOrderSearch);
		if (this.getReusableActionsInstance().isElementVisible(this.btnAccountOrderSearch)) {
			reporter.reportLogPass("Search order button field is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Search order button field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSelectPeriod);
		if (!this.lblSelectPeriod.getText().isEmpty()) {
			reporter.reportLogPass("Select period static title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Select period static title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectPeriodOptions);
		if (this.getReusableActionsInstance().isElementVisible(this.selectPeriodOptions)) {
			reporter.reportLogPass("Select period is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Select period is not displaying correctly");
		}

		Select select = new Select(this.selectPeriodOptions);
		String currentOption = select.getFirstSelectedOption().getText().trim();
		if (!bRecentOrder) {
			if (currentOption.equalsIgnoreCase("All")) {
				reporter.reportLogPass("The select period is 'All'");
			} else {
				reporter.reportLogFailWithScreenshot("The select period is not 'All'");
			}
		} else {
			if (currentOption.equalsIgnoreCase("last 30 days")) {
				reporter.reportLogPass("The select period is 'last 30 days'");
			} else {
				reporter.reportLogFailWithScreenshot("The select period is not 'last 30 days'");
			}
		}

		if (!this.checkOrderListExisting()) {
			verifyNoOrderRecordsMessage(expectedNoOrderRecorderMessage);
			return;
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblEditOrderNote);
		if (!this.lblEditOrderNote.getText().isEmpty()) {
			reporter.reportLogPass("Edit order note is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Edit order note is not displaying correctly");
		}

		reporter.reportLog("Verify order item list");
		WebElement subItem = null;
		String lsOrderNO;
		for (WebElement item : this.lstOrderItemList) {
			subItem = item.findElement(byOrderNo);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			lsOrderNO = subItem.getText().trim();

			reporter.reportLog("Verify the order item " + lsOrderNO);
			if (!lsOrderNO.isEmpty()) {
				reporter.reportLogPass("OrderNO is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("OrderNO is not displaying correctly");
			}

			subItem = item.findElement(byOrderNoTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if (!subItem.getText().isEmpty()) {
				reporter.reportLogPass("OrderNO title is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("OrderNO title is not displaying correctly");
			}

			subItem = item.findElement(byOrderNoDate);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if (!subItem.getText().isEmpty()) {
				reporter.reportLogPass("OrderNO date is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("OrderNO date is not displaying correctly");
			}

			subItem = item.findElement(byOrderTotalTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if (!subItem.getText().isEmpty()) {
				reporter.reportLogPass("Order total title is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Order total title is not displaying correctly");
			}

			subItem = item.findElement(byOrderTotal);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if (!subItem.getText().isEmpty()) {
				reporter.reportLogPass("Order total is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Order total is not displaying correctly");
			}

			subItem = item.findElement(byOrderStatusTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if (!subItem.getText().isEmpty()) {
				reporter.reportLogPass("Order status title is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Order status title is not displaying correctly");
			}

			subItem = item.findElement(byOrderStatus);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if (!subItem.getText().isEmpty()) {
				reporter.reportLogPass("Order status is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Order status is not displaying correctly");
			}

			subItem = item.findElement(byOrderViewDetails);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if (!subItem.getText().isEmpty()) {
				reporter.reportLogPass("Order view details button is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Order view details button is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntOrderStatusPaginationContainer);
		if (this.getReusableActionsInstance().isElementVisible(this.cntOrderStatusPaginationContainer)) {
			reporter.reportLogPass("Pagination section is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Pagination section is not displaying correctly");
		}
	}

	/**
	 * To verify search order by given order number
	 *
	 * @param - lsOrderDetailsURL
	 */
	public void verifySearchOrderFunction(String lsOrderDetailsURL) {
		String orderNumber = this.getRandomOrderNumber();
		if (orderNumber == null) {
			reporter.reportLog("No order items existing,and showing 'No orders yet. TSC has tons of deals to offer' message!");
			return;
		}
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputAccountOrderSearch);
		this.inputAccountOrderSearch.clear();
		this.inputAccountOrderSearch.sendKeys(orderNumber);
		this.getReusableActionsInstance().clickIfAvailable(this.btnAccountOrderSearch);

		this.waitForCondition(Driver -> {
			return this.lblOrderDetailsSectionTitle.isDisplayed();
		}, 50000);

		lsOrderDetailsURL = lsOrderDetailsURL.replace("{OrderNO}", orderNumber);
		String lsExpectedURL = this.getBaseURL() + lsOrderDetailsURL;
		if (this.URL().equalsIgnoreCase(lsExpectedURL)) {
			reporter.reportLogPass("The page is navigated to order details page correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The page is not navigated to order details page correctly");
		}
	}

	/**
	 * To go back to upper level page
	 */
	public void goBackUpperLevel() {
		WebElement upperNavigationElement = this.lstNavigationCrumbList.get(this.lstNavigationCrumbList.size() - 2);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(upperNavigationElement);
		this.getReusableActionsInstance().clickIfAvailable(upperNavigationElement);

		this.getReusableActionsInstance().staticWait(5 * this.getStaticWaitForApplication());
	}

	public void verifyOrderSearchErrorMessage(String lsExpectedErrorMessage) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputAccountOrderSearch);
		this.inputAccountOrderSearch.clear();
		this.inputAccountOrderSearch.sendKeys("OrderNumber");
		this.getReusableActionsInstance().clickIfAvailable(this.btnAccountOrderSearch);

		this.waitForCondition(Driver -> {
			return this.lblAccountOrderSearchErrorMessage.isDisplayed();
		}, 50000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAccountOrderSearchErrorMessage);
		String lsErrorMessage = this.lblAccountOrderSearchErrorMessage.getText().trim();
		if (lsErrorMessage.equalsIgnoreCase(lsExpectedErrorMessage)) {
			reporter.reportLogPass("The order search error message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The order search error message:'" + lsErrorMessage + "' is not displaying as the expected one:'" + lsExpectedErrorMessage + "'");
		}
	}

	/**
	 * To check Order Item Existing
	 *
	 * @return - boolean
	 */
	public boolean checkOrderItemExisting() {
		return this.checkChildElementExistingByAttribute(this.cntAccountOrderItemContainer, "class", "no-breadcrumb-link");
	}

	/**
	 * To go to Order Details Page
	 *
	 * @return - selected orderNO
	 */
	public String goToOrderDetailsPage() {
		if (!this.checkOrderListExisting()) {
			return null;
		}

		int optionSize = this.lstOrderItemList.size();
		int randomNumber = 0;
		if (optionSize > 2) {
			Random rand = new Random();
			randomNumber = rand.nextInt(optionSize - 2);
		}

		WebElement randomOrderNOItem = this.lstOrderItemList.get(randomNumber).findElement(this.byOrderNo);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(randomOrderNOItem);
		String lsOrderStatusOrderNO = randomOrderNOItem.getText().trim();

		WebElement randomOrderViewDetailsItem = this.lstOrderItemList.get(randomNumber).findElement(this.byOrderViewDetails);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(randomOrderViewDetailsItem);
		this.getReusableActionsInstance().clickIfAvailable(randomOrderViewDetailsItem);

		this.waitForCondition(Driver -> {
			return this.lblOrderDetailsSectionTitle.isDisplayed();
		}, 40000);

		return lsOrderStatusOrderNO;
	}

	/**
	 * To verify main header section in order details
	 *
	 * @param - lsOrderNO from Order status page
	 * @param - lsCustomerNumber from Order status page
	 */
	public void verifyMainHeaderSectionInOrderDetails(String lsOrderNO, String lsCustomerNumber) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSectionTitle);
		if (!lblOrderDetailsSectionTitle.getText().isEmpty()) {
			reporter.reportLogPass("Section title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Section title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderNOTitle);
		if (!lblOrderDetailsHeaderOrderNOTitle.getText().isEmpty()) {
			reporter.reportLogPass("OrderNo title in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("OrderNo title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderNO);
		if (lblOrderDetailsHeaderOrderNO.getText().trim().equalsIgnoreCase(lsOrderNO)) {
			reporter.reportLogPass("OrderNo in Header is the same as the one in Order status page");
		} else {
			reporter.reportLogFailWithScreenshot("OrderNo:" + lblOrderDetailsHeaderOrderNO.getText().trim() + " in Header is not the same as the one:" + lsOrderNO + " in Order status page");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderedDateTitle);
		if (!lblOrderDetailsHeaderOrderedDateTitle.getText().isEmpty()) {
			reporter.reportLogPass("Order date title in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order date title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderedDate);
		if (!lblOrderDetailsHeaderOrderedDate.getText().isEmpty()) {
			reporter.reportLogPass("Order date in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order date in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderCustomerNOTitle);
		if (!lblOrderDetailsHeaderCustomerNOTitle.getText().isEmpty()) {
			reporter.reportLogPass("Customer number title in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Customer number title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderCustomerNO);
		if (lblOrderDetailsHeaderCustomerNO.getText().trim().equalsIgnoreCase(lsCustomerNumber)) {
			reporter.reportLogPass("Customer number in Header is the same as the one in Order status page");
		} else {
			reporter.reportLogFailWithScreenshot("Customer number:" + lblOrderDetailsHeaderCustomerNO.getText().trim() + " in Header is the same as the one:" + lsCustomerNumber + " in Order status page");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderMethodTitle);
		if (!lblOrderDetailsHeaderOrderMethodTitle.getText().isEmpty()) {
			reporter.reportLogPass("Order method title in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order method title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderMethod);
		if (!lblOrderDetailsHeaderOrderMethod.getText().isEmpty()) {
			reporter.reportLogPass("Order method title in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order method title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderStatusTitle);
		if (!lblOrderDetailsHeaderOrderStatusTitle.getText().isEmpty()) {
			reporter.reportLogPass("Order status title in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order status title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderStatus);
		if (!lblOrderDetailsHeaderOrderStatus.getText().isEmpty()) {
			reporter.reportLogPass("Order status in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order status in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderTotalTitle);
		if (!lblOrderDetailsHeaderOrderTotalTitle.getText().isEmpty()) {
			reporter.reportLogPass("Order total title in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order total title in Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderTotal);
		if (!lblOrderDetailsHeaderOrderTotal.getText().isEmpty()) {
			reporter.reportLogPass("Order total in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order total in Header is not displaying correctly");
		}

		if (this.checkTrackOrderButtonExisting()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderDetailsHeaderTrackOrder);
			if (this.getReusableActionsInstance().isElementVisible(btnOrderDetailsHeaderTrackOrder)) {
				reporter.reportLogPass("Track order button in Header is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Track order button in Header is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderDetailsHeaderEditOrder);
		if (this.getReusableActionsInstance().isElementVisible(btnOrderDetailsHeaderEditOrder)) {
			reporter.reportLogPass("Edit order button in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Edit order button in Header is not displaying correctly");
		}

		if (btnOrderDetailsHeaderEditOrder.getAttribute("class").contains("disabled")) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderNote);
			if (!lblOrderDetailsHeaderOrderNote.getText().isEmpty()) {
				reporter.reportLogPass("Order note in Header is displaying correctly when Edit order button is disabled");
			} else {
				reporter.reportLogFailWithScreenshot("Order note in Header is not displaying correctly when Edit order button is disabled");
			}
		}
	}

	/**
	 * To verify main header section in order details for different devices
	 */
	public void verifyMainHeaderSectionInOrderDetails_DifferentDevice() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderDetailsHeaderViewInvoice);
		if (this.getReusableActionsInstance().isElementVisible(btnOrderDetailsHeaderViewInvoice)) {
			reporter.reportLogPass("View invoice button in Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("View invoice button in Header is not displaying correctly");
		}
	}

	/**
	 * To verify sub header section in order details
	 *
	 * @param - lsOrderNO from Order status page
	 */
	public void verifySubHeaderSectionInOrderDetails(String lsOrderNO) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderSubOrderTitle);
		if (!lblOrderDetailsSubHeaderSubOrderTitle.getText().isEmpty()) {
			reporter.reportLogPass("Order title in Sub Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order title in Sub Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderCustomerNO);
		if (lblOrderDetailsSubHeaderCustomerNO.getText().trim().equalsIgnoreCase(lsOrderNO)) {
			reporter.reportLogPass("OrderNO in Sub Header is the same as the one in Order status page");
		} else {
			reporter.reportLogFailWithScreenshot("OrderNO:+" + lblOrderDetailsSubHeaderCustomerNO.getText().trim() + " in Sub Header is the same as the one:" + lsOrderNO + " in Order status page");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingMethodTitle);
		if (!lblOrderDetailsSubHeaderShippingMethodTitle.getText().isEmpty()) {
			reporter.reportLogPass("Shipping method title in Sub Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Shipping method title in Sub Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingMethod);
		if (!lblOrderDetailsSubHeaderShippingMethod.getText().isEmpty()) {
			reporter.reportLogPass("Shipping method in Sub Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Shipping method in Sub Header is not displaying correctly");
		}
	}

	/**
	 * To verify sub header section in order details for different devices
	 *
	 * @param - lsOrderNO from Order status page
	 */
	public void verifySubHeaderSectionInOrderDetails_DifferentDevices() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingAddressTitle);
		if (!lblOrderDetailsSubHeaderShippingAddressTitle.getText().isEmpty()) {
			reporter.reportLogPass("Shipping address title in Sub Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Shipping address title in Sub Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingAddress);
		if (!lblOrderDetailsSubHeaderShippingAddress.getText().isEmpty()) {
			reporter.reportLogPass("Shipping address in Sub Header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Shipping address in Sub Header is not displaying correctly");
		}
	}

	/**
	 * To verify order item list section in order details
	 */
	public void verifyOrderItemListSectionInOrderDetails() {
		WebElement subItem = null;
		String lsProductNO, lsText;
		for (WebElement item : lstOrderDetailsOrderItemList) {
			if (checkProductNumberAndWriteReviewButtonExisting(item)) {
				subItem = item.findElement(byOrderDetailsOrderItemProductNumber);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				lsProductNO = subItem.getText().trim();
				reporter.reportLog("Verify product number: " + lsProductNO);

				if (!lsProductNO.isEmpty()) {
					reporter.reportLogPass("Product number is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("Product number is not displaying correctly");
				}
			} else {
				subItem = item.findElement(byOrderDetailsOrderItemPipeStyleLink);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				lsText = subItem.getText();
				reporter.reportLog("Verify donation item: " + lsText);
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The product pipe style is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product pipe style is not displaying correctly");
				}
			}

			subItem = item.findElement(byOrderDetailsOrderItemLink);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			boolean bCheckLink = this.checkChildElementExistingByTagName(subItem, "a");
			if (bCheckLink) {
				subItem = subItem.findElement(By.xpath(".//a"));
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				if (!subItem.getAttribute("href").isEmpty()) {
					reporter.reportLogPass("The product link is not empty");
				} else {
					reporter.reportLogFailWithScreenshot("The product link is empty");
				}
			}

			subItem = item.findElement(byOrderDetailsOrderItemImage);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if (!subItem.getAttribute("src").isEmpty()) {
				reporter.reportLogPass("The image src is not empty");
			} else {
				reporter.reportLogFailWithScreenshot("The image src is empty");
			}

			if (checkProductNumberAndWriteReviewButtonExisting(item)) {
				subItem = item.findElement(byOrderDetailsOrderItemProductPrice);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				if (!subItem.getText().trim().isEmpty()) {
					reporter.reportLogPass("The product price is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product price is not displaying correctly");
				}
			}

			subItem = item.findElement(byOrderDetailsOrderItemQTYTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if (!subItem.getText().trim().isEmpty()) {
				reporter.reportLogPass("The product order QTY title is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product order QTY title is not displaying correctly");
			}

			subItem = item.findElement(byOrderDetailsOrderItemQTY);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if (!subItem.getText().trim().isEmpty()) {
				reporter.reportLogPass("The product order QTY is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product order QTY is not displaying correctly");
			}

			subItem = item.findElement(byOrderDetailsOrderItemStatusTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if (!subItem.getText().trim().isEmpty()) {
				reporter.reportLogPass("The product order status title is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product order status title is not displaying correctly");
			}

			if (checkProductNumberAndWriteReviewButtonExisting(item)) {
				subItem = item.findElement(byOrderDetailsOrderItemWriteReview);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				if (!subItem.getText().trim().isEmpty()) {
					reporter.reportLogPass("Write a review button is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("Write a review button is not displaying correctly");
				}
			}
		}
	}

	/**
	 * To verify summary section in order details
	 */
	public void verifySummarySectionInOrderDetails() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsBillingAddressTitle);
		if (!lblOrderDetailsBillingAddressTitle.getText().isEmpty()) {
			reporter.reportLogPass("Billing address title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Billing address title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsBillingAddress);
		if (!lblOrderDetailsBillingAddress.getText().isEmpty()) {
			reporter.reportLogPass("Billing address is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Billing address is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsPaymentMethodTitle);
		if (!lblOrderDetailsPaymentMethodTitle.getText().isEmpty()) {
			reporter.reportLogPass("Payment method title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Payment method title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsPaymentMethod);
		if (!lblOrderDetailsPaymentMethod.getText().isEmpty()) {
			reporter.reportLogPass("Payment method is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Payment method is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsOrderSummary);
		if (!lblOrderDetailsOrderSummary.getText().isEmpty()) {
			reporter.reportLogPass("Order summary title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order summary title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubtotalTitle);
		if (!lblOrderDetailsSubtotalTitle.getText().isEmpty()) {
			reporter.reportLogPass("SubTotal title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("SubTotal title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubtotal);
		if (!lblOrderDetailsSubtotal.getText().isEmpty()) {
			reporter.reportLogPass("SubTotal is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("SubTotal is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsShippingAndHandlingTitle);
		if (!lblOrderDetailsShippingAndHandlingTitle.getText().isEmpty()) {
			reporter.reportLogPass("ShippingAndHandling title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("ShippingAndHandling title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsShippingAndHandling);
		if (!lblOrderDetailsShippingAndHandling.getText().isEmpty()) {
			reporter.reportLogPass("ShippingAndHandling is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("ShippingAndHandling is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsTaxesTitle);
		if (!lblOrderDetailsTaxesTitle.getText().isEmpty()) {
			reporter.reportLogPass("Taxes title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Taxes title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsTaxes);
		if (!lblOrderDetailsTaxes.getText().isEmpty()) {
			reporter.reportLogPass("Taxes is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Taxes is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsOrderTotalTitle);
		if (!lblOrderDetailsOrderTotalTitle.getText().isEmpty()) {
			reporter.reportLogPass("Order total title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order total title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsOrderTotal);
		if (!lblOrderDetailsOrderTotal.getText().isEmpty()) {
			reporter.reportLogPass("Order total is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Order total is not displaying correctly");
		}
	}

	/**
	 * To compare subTotal and order total
	 */
	public void verifySubTotalAndOrderTotal(Map<String, Object> orderSummaryMap) {
		float subTotal = (float) orderSummaryMap.get("subTotal");
		float nowPrice = (float) orderSummaryMap.get("nowPrice");
		float tax = (float) orderSummaryMap.get("tax");
		float promoteCodeValue = (float) orderSummaryMap.get("promoteCodeValue");
		float giftCardValue = (float) orderSummaryMap.get("giftCardValue");
		float totalPrice = (float) orderSummaryMap.get("totalPrice");

		float calculateTotalPrice = subTotal + nowPrice + tax - promoteCodeValue - giftCardValue;

		if (Math.abs(calculateTotalPrice - totalPrice) < 0.1f) {
			reporter.reportLogPass("The subTotal is equal to the order total");
		} else {
			reporter.reportLogFailWithScreenshot("The subTotal is not equal to the order total");
		}
	}

	/**
	 * To verify Order Modification And Order Returns Contents
	 */
	public void verifyOrderModificationAndOrderReturnsContents() {
		UnCollapsedAllOrderServiceItems();

		String lsText = null;
		WebElement item;
		for (int i = 0; i < lstOrderServiceItemTitleLink.size(); i++) {
			item = lstOrderServiceItemTitleLink.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText().trim();
			if (!item.getAttribute("href").isEmpty()) {
				reporter.reportLogPass("The header link of '" + lsText + "' is not empty");
			} else {
				reporter.reportLogFailWithScreenshot("The header link of '" + lsText + "' is empty");
			}

			item = lstOrderServiceItemContent.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText().trim();
			if (!lsText.isEmpty()) {
				//reporter.reportLogPass("The content of '"+lsText+"' is not empty");
				reporter.reportLogPass("The content is not empty as expected!");
			} else {
				reporter.reportLogFailWithScreenshot("The content of '" + lsText + "' is empty");
			}
		}
	}

	/**
	 * To verify Basic infomation of Account Settings section
	 *
	 * @param - lsExpectedEmail - SignIn Email address
	 */
	public void verifyBasicInfoInAccountSettingsSection(String lsExpectedEmail) {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAccountSettingEmailTitle);
		if (!lblAccountSettingEmailTitle.getText().isEmpty()) {
			reporter.reportLogPass("The Email title in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Email title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAccountSettingEmail);
		lsText = lblAccountSettingEmail.getText().trim();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Email in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Email in Account settings is not displaying correctly");
		}

		if (lsText.equalsIgnoreCase(lsExpectedEmail)) {
			reporter.reportLogPass("The Email in Account settings is the same as the expected SignIn Email");
		} else {
			reporter.reportLogFailWithScreenshot("The Email in Account settings is not the same as the expected SignIn Email");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAccountSettingPasswordTitle);
		if (!lblAccountSettingPasswordTitle.getText().isEmpty()) {
			reporter.reportLogPass("The Password title in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Password title in Account settings is not displaying correctly");
		}

		String lsTestDevice = System.getProperty("Device").trim();
		String lsTestBrowser = System.getProperty("Browser").toLowerCase().trim();
		if (!(lsTestDevice.equalsIgnoreCase("Mobile") ||
				(System.getProperty("Device").contains("Tablet") && System.getProperty("Browser").contains("android")) ||
				(System.getProperty("Browser").equalsIgnoreCase("chromemobile") &&
						System.getProperty("Device").contains("Tablet") &&
						!System.getProperty("chromeMobileDevice").contains("iPad")))) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAccountSettingPassword);
			if (!lblAccountSettingPassword.getText().isEmpty()) {
				reporter.reportLogPass("The Password in Account settings is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Password in Account settings is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAccountSettingPasswordEdit);
		if (this.getReusableActionsInstance().isElementVisible(btnAccountSettingPasswordEdit)) {
			reporter.reportLogPass("The Password Edit button in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Password Edit button in Account settings is not displaying correctly");
		}
	}

	/**
	 * To verify Change password content of Account Settings section
	 */
	public void verifyChangePasswordContentInAccountSettingsSection() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangePasswordSectionTitle);
		if (!lblChangePasswordSectionTitle.getText().isEmpty()) {
			reporter.reportLogPass("The Change password section title in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Change password section title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangePasswordSectionTipMessage);
		if (!lblChangePasswordSectionTipMessage.getText().isEmpty()) {
			reporter.reportLogPass("The Change password section tip message in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Change password section tip message in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangePasswordSectionCurrentPassword);
		if (!lblChangePasswordSectionCurrentPassword.getText().isEmpty()) {
			reporter.reportLogPass("The current password title in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The current password title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionCurrentPassword);
		if (this.getReusableActionsInstance().isElementVisible(inputChangePasswordSectionCurrentPassword)) {
			reporter.reportLogPass("The current password input field in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The current password input field in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordSectionCurrentPasswordShowButton);
		if (this.getReusableActionsInstance().isElementVisible(btnChangePasswordSectionCurrentPasswordShowButton)) {
			reporter.reportLogPass("The current password show button in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The current password show button in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangePasswordSectionNewPassword);
		if (!lblChangePasswordSectionNewPassword.getText().isEmpty()) {
			reporter.reportLogPass("The new password title in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The new password title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionNewPassword);
		if (this.getReusableActionsInstance().isElementVisible(inputChangePasswordSectionNewPassword)) {
			reporter.reportLogPass("The new password input field in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The new password input field in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordSectionNewPasswordShowButton);
		if (this.getReusableActionsInstance().isElementVisible(btnChangePasswordSectionNewPasswordShowButton)) {
			reporter.reportLogPass("The new password show button in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The new password show button in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangePasswordSectionReTypePassword);
		if (!lblChangePasswordSectionReTypePassword.getText().isEmpty()) {
			reporter.reportLogPass("The Retype password title in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Retype password title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangePasswordSectionReTypePassword);
		if (this.getReusableActionsInstance().isElementVisible(inputChangePasswordSectionReTypePassword)) {
			reporter.reportLogPass("The Retype password input field in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Retype password input field in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordSectionReTypePasswordShowButton);
		if (this.getReusableActionsInstance().isElementVisible(btnChangePasswordSectionReTypePasswordShowButton)) {
			reporter.reportLogPass("The Retype password show button in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Retype password show button in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordSubmit);
		if (this.getReusableActionsInstance().isElementVisible(btnChangePasswordSubmit)) {
			reporter.reportLogPass("The Submit button for changing password is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Submit button for changing password is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordCancel);
		if (this.getReusableActionsInstance().isElementVisible(btnChangePasswordCancel)) {
			reporter.reportLogPass("The Cancel button for changing password is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Cancel button for changing password is not displaying correctly");
		}
	}

	/**
	 * To change password function of Account Settings section
	 *
	 * @param - lsCurrentPassword - current password
	 * @param - bSubmit - true for clicking Submit button while false for clicking Cancel button
	 * @return - String -  changed password
	 */
	public String changePasswordFunctionInAccountSettingsSection(String lsCurrentPassword, boolean bSubmit) {
		String lsChangedPassword = DataConverter.getSaltString(5, "stringType") + DataConverter.getSaltString(1, "numberType");

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
		if (bSubmit) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordSubmit);
			this.getReusableActionsInstance().clickIfAvailable(btnChangePasswordSubmit);
			lsReturn = lsChangedPassword;
		} else {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangePasswordCancel);
			this.getReusableActionsInstance().clickIfAvailable(btnChangePasswordCancel);
			lsReturn = lsCurrentPassword;
		}

		waitForCondition(Driver -> {
			return this.btnAccountSettingPasswordEdit.isDisplayed();
		}, 90000);

		return lsReturn;
	}

	/**
	 * To open Change Security Section
	 */
	public void openChangeSecuritySection() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAccountSettingSecurityQuestionEdit);
		this.getReusableActionsInstance().clickIfAvailable(btnAccountSettingSecurityQuestionEdit);

		this.waitForPageToLoad();
		//Keep it for scrolling window
		this.getReusableActionsInstance().staticWait(5 * this.getStaticWaitForApplication());
	}

	/**
	 * To verify changing password function of Account Settings section with invalid value
	 *
	 * @param - String - lsCurrentPassword - current password
	 * @param - List<String> - lstPasswordErrorMessage
	 */
	public void VerifyChangePasswordFunctionInAccountSettingsSectionWithInvalidValue(String lsCurrentPassword, List<String> lstPasswordErrorMessage) {
		String lsChangedPassword = DataConverter.getSaltString(5, "stringType") + DataConverter.getSaltString(1, "numberType");
		String lsInvalidCurrentPassword = lsCurrentPassword + "1";

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
		String lsErrorMessage = this.lstChangePasswordErrorMessage.get(0).getText().trim();
		if (lsErrorMessage.equalsIgnoreCase(lstPasswordErrorMessage.get(0))) {
			reporter.reportLogPass("Current password error message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Current password error message:'" + lsErrorMessage + "' is not matching the expected:'" + lstPasswordErrorMessage.get(0) + "'");
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
		lsErrorMessage = this.lstChangePasswordErrorMessage.get(0).getText().trim();
		if (lsErrorMessage.equalsIgnoreCase(lstPasswordErrorMessage.get(1))) {
			reporter.reportLogPass("New password format error message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("New password format error message:'" + lsErrorMessage + "' is not matching the expected:'" + lstPasswordErrorMessage.get(1) + "'");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstChangePasswordErrorMessage.get(1));
		lsErrorMessage = this.lstChangePasswordErrorMessage.get(1).getText().trim();
		if (lsErrorMessage.equalsIgnoreCase(lstPasswordErrorMessage.get(2))) {
			reporter.reportLogPass("New password mismatching error message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("New password mismatching error message:'" + lsErrorMessage + "' is not matching the expected:'" + lstPasswordErrorMessage.get(2) + "'");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstChangePasswordErrorMessage.get(2));
		lsErrorMessage = this.lstChangePasswordErrorMessage.get(2).getText().trim();
		if (lsErrorMessage.equalsIgnoreCase(lstPasswordErrorMessage.get(0))) {
			reporter.reportLogPass("Incorrect password error message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Incorrect password error message:'" + lsErrorMessage + "' is not matching the expected:'" + lstPasswordErrorMessage.get(0) + "'");
		}
	}

	/**
	 * To verify Changing security question content of Account Settings section
	 */
	public void verifyChangeSecurityQuestionContentInAccountSettingsSection() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangeSecurityQuestionSectionTitle);
		if (!lblChangeSecurityQuestionSectionTitle.getText().isEmpty()) {
			reporter.reportLogPass("The Change security question section title in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Change security question section title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangeSecurityQuestionSectionTipMessage);
		if (!lblChangeSecurityQuestionSectionTipMessage.getText().isEmpty()) {
			reporter.reportLogPass("The Change security question section tip message in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Change security question section tip message in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangeSecurityQuestionSectionQuestionTitle);
		if (!lblChangeSecurityQuestionSectionQuestionTitle.getText().isEmpty()) {
			reporter.reportLogPass("The Change Security Question Section Question Title in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Change Security Question Section Question Title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectChangeSecurityQuestionSectionQuestion);
		if (this.getReusableActionsInstance().isElementVisible(selectChangeSecurityQuestionSectionQuestion)) {
			reporter.reportLogPass("The Change Security Question option list in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Change Security Question option list in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangeSecurityQuestionSectionAnswerTitle);
		if (!lblChangeSecurityQuestionSectionAnswerTitle.getText().isEmpty()) {
			reporter.reportLogPass("The Change Security Question answer title in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Change Security Question answer title in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangeSecurityQuestionSectionAnswer);
		if (this.getReusableActionsInstance().isElementVisible(inputChangeSecurityQuestionSectionAnswer)) {
			reporter.reportLogPass("The Change Security Question answer field in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Change Security Question answer field in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeSecurityQuestionSubmit);
		if (this.getReusableActionsInstance().isElementVisible(btnChangeSecurityQuestionSubmit)) {
			reporter.reportLogPass("The submit button in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The submit button in Account settings is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeSecurityQuestionCancel);
		if (this.getReusableActionsInstance().isElementVisible(btnChangeSecurityQuestionCancel)) {
			reporter.reportLogPass("The cancel button in Account settings is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The cancel button in Account settings is not displaying correctly");
		}
	}

	/**
	 * To changing security question function of Account Settings section
	 *
	 * @param - boolean  - bSubmit - true for clicking Submit button while false for clicking Cancel button
	 * @return - Map<String,Object> - contains selected index and answer
	 */
	public Map<String, Object> changeSecurityQuestionFunctionInAccountSettingsSection(boolean bSubmit) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectChangeSecurityQuestionSectionQuestion);
		Select select = new Select(selectChangeSecurityQuestionSectionQuestion);
		int count = select.getOptions().size();

		Random rand = new Random();
		int randomNumber = rand.nextInt(count - 1) + 1;

		String lsOption;
		select.selectByIndex(randomNumber);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangeSecurityQuestionSectionAnswer);
		lsOption = select.getFirstSelectedOption().getText();
		String lsAnswer;
		if (lsOption.contains("born")) {
			lsAnswer = "1950";
		} else {
			lsAnswer = "Answer";
		}
		inputChangeSecurityQuestionSectionAnswer.clear();
		this.getReusableActionsInstance().staticWait(2 * this.getStaticWaitForApplication());
		inputChangeSecurityQuestionSectionAnswer.sendKeys(lsAnswer);

		if (bSubmit) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeSecurityQuestionSubmit);
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			this.getReusableActionsInstance().clickIfAvailable(btnChangeSecurityQuestionSubmit);
		} else {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeSecurityQuestionCancel);
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			this.clickWebElementUsingJS(btnChangeSecurityQuestionCancel);
		}
		this.waitForPageToLoad();
		//Keep it for scrolling window
		this.getReusableActionsInstance().staticWait(5 * this.getStaticWaitForApplication());

		Map<String, Object> map = new HashMap<>();
		if (bSubmit) {
			map.put("SelectedIndex", randomNumber);
			map.put("SelectText", lsOption);
			map.put("Answer", lsAnswer);
		} else {
			map.put("SelectedIndex", 0);
			map.put("SelectText", lsOption);
			map.put("Answer", "");
		}

		return map;
	}

	/**
	 * To verify changing security question error message
	 */
	public void verifyChangeSecurityQuestionErrorMessage() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectChangeSecurityQuestionSectionQuestion);
		Select select = new Select(selectChangeSecurityQuestionSectionQuestion);
		int count = select.getOptions().size();

		String lsOption, lsErrorMessage;
		for (int i = 1; i < count; i++) {
			select.selectByIndex(i);
			this.getReusableActionsInstance().staticWait(300);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputChangeSecurityQuestionSectionAnswer);
			inputChangeSecurityQuestionSectionAnswer.clear();
			inputChangeSecurityQuestionSectionAnswer.sendKeys("aa");
			this.getReusableActionsInstance().staticWait(300);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangeSecurityQuestionsErrorMessage);
			lsErrorMessage = lblChangeSecurityQuestionsErrorMessage.getAttribute("value").trim();

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectChangeSecurityQuestionSectionQuestion);
			lsOption = select.getFirstSelectedOption().getText();

			reporter.reportLog("Verify error message for '" + lsOption + "'");
			if (!lsErrorMessage.isEmpty()) {
				reporter.reportLogPass("The error message:" + lsErrorMessage + " is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The error message is not displaying correctly");
			}
		}
	}

	/**
	 * To verify landing view content
	 */
	public void verifyLandingViewContent() {
		List<WebElement> lstSubItem;
		String lsText;
		for (WebElement item : lstAccountSummaryPanelList) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText().trim();
			reporter.reportLog("Verify header of '" + lsText + "'");
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The Header of '" + lsText + "' is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Header of '" + lsText + "' is not displaying correctly");
			}
			lstSubItem = item.findElements(bySubList);
			for (WebElement subItem : lstSubItem) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				lsText = subItem.getText().trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The sub item of '" + lsText + "' is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The sub item of '" + lsText + "' is not displaying correctly");
				}
			}
		}
	}

	/**
	 * This function verifies Gift Card Error Messages
	 */
	public void verifyGiftCardErrorMessage(String giftCardNumber, String errorType, String errorMessage) {
		String fetchedErrorMessage = null;
		if (errorType.toLowerCase().contains("number")) {
			this.lblGiftCardNumberEntryTextBox.sendKeys("1234");
			getReusableActionsInstance().clickIfAvailable(this.lblGiftCardPinEntryTextBox);
			fetchedErrorMessage = this.lblErrorMessageForInvalidCreditCardNumber.get(0).getText().trim();
		} else if (errorType.toLowerCase().contains("pin")) {
			this.lblGiftCardNumberEntryTextBox.sendKeys(giftCardNumber);
			this.lblGiftCardPinEntryTextBox.sendKeys("12");
			getReusableActionsInstance().clickIfAvailable(this.lblGiftCardNumberEntryTextBox);
			fetchedErrorMessage = this.lblErrorMessageForInvalidCreditCardNumber.get(1).getText().trim();
		}

		if (fetchedErrorMessage.equalsIgnoreCase(errorMessage))
			reporter.reportLogPassWithScreenshot("Error Message for invalid type: " + errorType + " is same as expected: " + fetchedErrorMessage);
		else
			reporter.reportLogFailWithScreenshot("Error Message for invalid type: " + errorType + " is " + fetchedErrorMessage + " and not same as expected: " + errorMessage);
	}

	public boolean verifyMinimumOneCardIsPresentForUser() {
		String titleText = this.lblPageTitle.getText();
		if (titleText.toLowerCase().contains("manage") && this.lstCreditCardsPresent.size() > 0)
			return true;
		if (titleText.toLowerCase().contains("add"))
			return false;
		return true;
	}

	/**
	 * This method will check no-history-container Existing
	 *
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkNoFavoriteHistoryContainerExisting() {
		return this.checkChildElementExistingByAttribute(this.cntMyFavouritesContainer, "class", "no-history-container");
	}

	/**
	 * To clear favorite history
	 *
	 * @param - boolean - bFromFavoriteLinkOnHeaderMenu - if clicking favorite link on header menu
	 */
	public void clearFavoriteHistory(boolean bFromFavoriteLinkOnHeaderMenu) {
		if (bFromFavoriteLinkOnHeaderMenu) {
			WebElement favoriteLink = (new GlobalHeaderPage(this.getDriver())).Favouriteslnk;
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(favoriteLink);
			this.getReusableActionsInstance().clickIfAvailable(favoriteLink);
			this.getReusableActionsInstance().waitForElementVisibility(this.lblMyFavouritesTitle, 20);
		}

		if (checkNoFavoriteHistoryContainerExisting()) {
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
	 *
	 * @param - ProductResultsPage - prp
	 */
	public void addFavoriteItem(ProductResultsPage prp) {
		if (prp.productResultList.size() == 0) {
			reporter.reportLogFail("No product search result available.");
			return;
		}

		WebElement item;
		for (WebElement element : prp.productResultList) {
			item = element.findElement(prp.byProductHeaderLike);
			if (item.getAttribute("aria-pressed").equalsIgnoreCase("true")) {
				continue;
			}

			this.getReusableActionsInstance().clickIfAvailable(item);
			final WebElement tempItem = item;
			this.waitForCondition(Driver -> {
				return tempItem.getAttribute("aria-pressed").equalsIgnoreCase("true");
			}, 15000);
		}
	}

	/**
	 * To verify address content
	 *
	 * @param - boolean - bAdd - to identify it is for Add an address or edit an address
	 */
	public void verifyAddressContent(boolean bAdd) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressTitle);
		if (!lblAddOrEditAddressTitle.getText().isEmpty()) {
			reporter.reportLogPass("Address title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Address title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressRequiredInfoTitle);
		if (!lblAddOrEditAddressRequiredInfoTitle.getText().isEmpty()) {
			reporter.reportLogPass("Address Required Info is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Address Required Info is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressFirstNameTitle);
		if (!lblAddOrEditAddressFirstNameTitle.getText().isEmpty()) {
			reporter.reportLogPass("First name title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("First name title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressFirstNameTitle);
		if (this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressFirstName)) {
			reporter.reportLogPass("First name input field is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("First name input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressLastNameTitle);
		if (!lblAddOrEditAddressLastNameTitle.getText().isEmpty()) {
			reporter.reportLogPass("Last name title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Last name title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressLastNameTitle);
		if (this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressLastName)) {
			reporter.reportLogPass("Last name input field is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Last name input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressPhoneNumberTitle);
		if (!lblAddOrEditAddressPhoneNumberTitle.getText().isEmpty()) {
			reporter.reportLogPass("Phone number title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Phone number title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber1);
		if (this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressPhoneNumber1)) {
			reporter.reportLogPass("Phone number input field 1 is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Phone number input field 1 is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber2);
		if (this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressPhoneNumber2)) {
			reporter.reportLogPass("Phone number input field 2 is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Phone number input field 2 is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber3);
		if (this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressPhoneNumber3)) {
			reporter.reportLogPass("Phone number input field 3 is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Phone number input field 3 is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditMakeDefaultShippingAddress);
		if (!lblAddOrEditMakeDefaultShippingAddress.getText().isEmpty()) {
			reporter.reportLogPass("Make default shipping address label is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Make default shipping address label is not displaying correctly");
		}

		if (bAdd) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditMakeShippingAsBillingAddress);
			if (!lblAddOrEditMakeShippingAsBillingAddress.getText().isEmpty()) {
				reporter.reportLogPass("Make shipping address as billing address label is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Make shipping address as billing address label is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressLine1Title);
		if (!lblAddOrEditAddressLine1Title.getText().isEmpty()) {
			reporter.reportLogPass("Address line1 title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Address line1 title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
		if (this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressLine1)) {
			reporter.reportLogPass("Address line1 input field is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Address line1 input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressLine2Title);
		if (!lblAddOrEditAddressLine2Title.getText().isEmpty()) {
			reporter.reportLogPass("Address line2 title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Address line2 title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine2);
		if (this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressLine2)) {
			reporter.reportLogPass("Address line2 input field is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Address line2 input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressCityTitle);
		if (!lblAddOrEditAddressCityTitle.getText().isEmpty()) {
			reporter.reportLogPass("City title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("City title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressCity);
		if (this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressCity)) {
			reporter.reportLogPass("City input field is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("City input field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressProvinceTitle);
		if (!lblAddOrEditAddressProvinceTitle.getText().isEmpty()) {
			reporter.reportLogPass("Province title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Province title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectAddOrEditAddressProvince);
		if (this.getReusableActionsInstance().isElementVisible(selectAddOrEditAddressProvince)) {
			reporter.reportLogPass("Province option field is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Province option field is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressPostalCodeTitle);
		if (!lblAddOrEditAddressPostalCodeTitle.getText().isEmpty()) {
			reporter.reportLogPass("Postal code title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Postal code title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode1);
		if (this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressPostalCode1)) {
			reporter.reportLogPass("Postal code input field 1 is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Postal code input field 1 is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode2);
		if (this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressPostalCode2)) {
			reporter.reportLogPass("Postal code input field 2 is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Postal code input field 2 is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCancel);
		if (!btnCancel.getText().isEmpty()) {
			reporter.reportLogPass("Cancel button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Cancel button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnSave);
		String lsText = btnSave.getText().trim();
		if (bAdd) {
			if (lsText.equalsIgnoreCase("Add Address")) {
				reporter.reportLogPass("Add button is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Add button is displaying correctly");
			}
		} else {
			if (lsText.equalsIgnoreCase("Save Address")) {
				reporter.reportLogPass("Save button is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Save button is displaying correctly");
			}
		}
	}

	/**
	 * To open add or edit an address window
	 *
	 * @param - lsOption - editShippingAddress/editBillingAddress/addShippingAddress
	 * @param - WebElement - lnkShippingEdit - if not editShippingAddress type, pass null
	 * @return - void
	 */
	public void openAddOrEditAddressWindow(String lsOption, WebElement lnkShippingEdit) {
		switch (lsOption) {
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
		this.waitForCondition(Driver -> {
			return inputAddOrEditAddressFirstName.isDisplayed();
		}, 12000);
		this.getReusableActionsInstance().staticWait(5 * this.getStaticWaitForApplication());
	}

	/**
	 * To close add or edit an address window
	 *
	 * @param - boolean - bSave - clicking Save/Cancel button
	 */
	public void closeAddOrEditAddressWindow(boolean bSave) {
		if (bSave) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSave);
			this.clickElement(this.btnSave);

			try {
				this.waitForCondition(Driver -> {
					return this.lblShippingAddressSectionTitle.isDisplayed();
				}, 40000);

			}
			catch (Exception e) {
				this.getReusableActionsInstance().staticWait(10 * getStaticWaitForApplication());

				String lsErrorMessage=this.getElementInnerText(this.lblAddOrEditAddressExistingErrorMessage).toLowerCase();
				if(lsErrorMessage.contains("you have one or more missing or invalid entries") ||
						lsErrorMessage.contains("address Line 1 cannot be more than 30 characters long")) {
					String lsAutoSearchKeywordAdd = DataConverter.getSaltString(4, "numberType");
					this.editAddress(null, lsAutoSearchKeywordAdd);

					this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSave);
					this.clickElement(this.btnSave);

					try {
						this.waitForCondition(Driver -> {
							return this.lblShippingAddressSectionTitle.isDisplayed();
						}, 40000);

					} catch (Exception e1) {
						this.getReusableActionsInstance().staticWait(10 * getStaticWaitForApplication());
						lsErrorMessage=this.getElementInnerText(lblAddOrEditAddressExistingErrorMessage).toLowerCase();
						if (lsErrorMessage.contains("account.addshippingaddresserror")) {
							this.handleAddShippingAddressErrorIssue();
							return;
						}
					}
				}

				if (lsErrorMessage.contains("account.addshippingaddresserror")) {
					this.handleAddShippingAddressErrorIssue();
					return;
				}
			}
		}
		else {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCancel);
			this.clickElement(this.btnCancel);
			this.waitForCondition(Driver -> {
				return this.lblShippingAddressSectionTitle.isDisplayed();
			}, 40000);
		}

		this.getReusableActionsInstance().staticWait(5 * getStaticWaitForApplication());
	}

	/**
	 * To handle Account.AddShippingAddressError Issue
	 */
	public void handleAddShippingAddressErrorIssue(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSave);
		this.clickElement(this.btnSave);

		try {
			this.waitForCondition(Driver -> {
				return this.lblShippingAddressSectionTitle.isDisplayed();
			}, 40000);

		} catch(Exception ex) {
			this.getReusableActionsInstance().staticWait(10 * getStaticWaitForApplication());
			String lsErrorMessage = this.getElementInnerText(this.lblAddOrEditAddressExistingErrorMessage).toLowerCase();
			if(lsErrorMessage.contains("the shipping address you are trying to add already exists")) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCancel);
				this.clickElement(this.btnCancel);
				this.waitForCondition(Driver -> {
					return this.lblShippingAddressSectionTitle.isDisplayed();
				}, 40000);
			}
		}
	}

	/**
	 * To verify your address content
	 */
	public void verifyYourAddresses() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblYourAddressTitle);
		if (!lblYourAddressTitle.getText().isEmpty()) {
			reporter.reportLogPass("Your address title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Your address title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingAddressSectionTitle);
		if (!lblShippingAddressSectionTitle.getText().isEmpty()) {
			reporter.reportLogPass("Shipping address title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Shipping address title is not displaying correctly");
		}

		WebElement item, element;
		for (int i = 0; i < this.lstShippingAddressContainer.size(); i++) {
			item = this.lstShippingAddressContainer.get(0);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			if (i == 0) {
				element = item.findElement(this.byShippingAddressTitle);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				if (!element.getText().isEmpty()) {
					reporter.reportLogPass("Default Shipping address title is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("Default Shipping address title is not displaying correctly");
				}
			}

			element = item.findElement(this.byShippingAddress);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			if (!element.getText().isEmpty()) {
				reporter.reportLogPass("Default Shipping address is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Default Shipping address is not displaying correctly");
			}

			element = item.findElement(this.byShippingAddressEdit);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			if (!element.getText().isEmpty()) {
				reporter.reportLogPass("Edit Default Shipping address link is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Edit Default Shipping address link is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddAddress);
		if (this.getReusableActionsInstance().isElementVisible(btnAddAddress)) {
			reporter.reportLogPass("Add address button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Add address button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblBillingAddressTitle);
		if (!lblBillingAddressTitle.getText().isEmpty()) {
			reporter.reportLogPass("Billing address title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Billing address title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblBillingAddress);
		if (!lblBillingAddress.getText().isEmpty()) {
			reporter.reportLogPass("Billing address is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Billing address is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkBillingAddressEdit);
		if (!lnkBillingAddressEdit.getText().isEmpty()) {
			reporter.reportLogPass("Edit Billing address link is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Edit Billing address link is not displaying correctly");
		}
	}

	/**
	 * To add a new address
	 *
	 * @param - String - lsAutoSearchKeyword
	 * @param - boolean - bMakeDefaultShippingAddress
	 * @param - boolean - bMakeBillingAddress
	 * @param - int - selectedIndexInAutoSearchDropdownMenu - select item from auto search dropdown menu list, if equal to -1, then will choose a random index
	 * @return - Map<String,String> - including firstName,lastName,address
	 */
	public Map<String, String> addNewAddress(String lsAutoSearchKeyword, boolean bMakeDefaultShippingAddress, boolean bMakeBillingAddress, int selectedIndexInAutoSearchDropdownMenu) {
		String lsFirstName = DataConverter.getSaltString(1, "upperStringType") + DataConverter.getSaltString(5, "lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressFirstName);
		inputAddOrEditAddressFirstName.clear();
		inputAddOrEditAddressFirstName.sendKeys(lsFirstName);
		this.getReusableActionsInstance().staticWait(300);

		String lsLastName = DataConverter.getSaltString(1, "upperStringType") + DataConverter.getSaltString(7, "lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLastName);
		inputAddOrEditAddressLastName.clear();
		inputAddOrEditAddressLastName.sendKeys(lsLastName);
		this.getReusableActionsInstance().staticWait(300);

		String lsPhoneNumber1 = "647";
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber1);
		inputAddOrEditAddressPhoneNumber1.clear();
		inputAddOrEditAddressPhoneNumber1.sendKeys(lsPhoneNumber1);
		this.getReusableActionsInstance().staticWait(300);

		String lsPhoneNumber2 = DataConverter.getSaltString(3, "numberType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber2);
		inputAddOrEditAddressPhoneNumber2.clear();
		inputAddOrEditAddressPhoneNumber2.sendKeys(lsPhoneNumber2);
		this.getReusableActionsInstance().staticWait(300);

		String lsPhoneNumber3 = DataConverter.getSaltString(4, "numberType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber3);
		inputAddOrEditAddressPhoneNumber3.clear();
		inputAddOrEditAddressPhoneNumber3.sendKeys(lsPhoneNumber3);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		if (bMakeDefaultShippingAddress) {
			if (!ckbAddOrEditMakeDefaultShippingAddress.isSelected()) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrEditMakeDefaultShippingAddress);
				labelAddOrEditMakeDefaultShippingAddress.click();
			}
		} else {
			if (ckbAddOrEditMakeDefaultShippingAddress.isSelected()) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrEditMakeDefaultShippingAddress);
				labelAddOrEditMakeDefaultShippingAddress.click();
			}
		}

		if (bMakeBillingAddress) {
			if (!ckbAddOrEditMakeShippingAsBillingAddress.isSelected()) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrEditMakeShippingAsBillingAddress);
				labelAddOrEditMakeShippingAsBillingAddress.click();
			}
		} else {
			if (ckbAddOrEditMakeShippingAsBillingAddress.isSelected()) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrEditMakeShippingAsBillingAddress);
				labelAddOrEditMakeShippingAsBillingAddress.click();
			}
		}
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
		inputAddOrEditAddressLine1.clear();
		String[] data = lsAutoSearchKeyword.codePoints().mapToObj(cp -> new String(Character.toChars(cp))).toArray(size -> new String[size]);
		int sum = 0;
		for (String inputText : data) {
			if (sum >= 30) {
				break;
			}
			inputAddOrEditAddressLine1.sendKeys(inputText);
			//For thinking time for waiting for backend response
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			sum++;
		}
		this.waitForCondition(Driver -> {
			return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: block;");
		}, 40000);
		this.getReusableActionsInstance().staticWait(2 * this.getStaticWaitForApplication());

		if (this.lstAddOrEditAddressAutoSearchDropdownItems.size() > 1) {
			reporter.reportLogPass("Getting dropdown auto search results successfully");
		} else {
			reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
		}

		if (selectedIndexInAutoSearchDropdownMenu == -1) {
			int optionSize = this.lstAddOrEditAddressAutoSearchDropdownItems.size();
			int randomNumber = 0;
			if (optionSize > 2) {
				Random rand = new Random();
				randomNumber = rand.nextInt(optionSize - 2);
			}

			//selectedIndexInAutoSearchDropdownMenu=randomNumber;
			selectedIndexInAutoSearchDropdownMenu = 0;
		}

		try {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(selectedIndexInAutoSearchDropdownMenu));
			if (this.lstAddOrEditAddressAutoSearchDropdownItems.get(selectedIndexInAutoSearchDropdownMenu).getText().length() >= 30) {
				selectedIndexInAutoSearchDropdownMenu = 2;
			}
			this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(selectedIndexInAutoSearchDropdownMenu));
			this.waitForCondition(Driver -> {
				return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");
			}, 20000);
		} catch (Exception e) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(selectedIndexInAutoSearchDropdownMenu));
			if (this.lstAddOrEditAddressAutoSearchDropdownItems.get(selectedIndexInAutoSearchDropdownMenu).getText().length() >= 30) {
				selectedIndexInAutoSearchDropdownMenu = 2;
			}
			this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(selectedIndexInAutoSearchDropdownMenu));
			this.waitForCondition(Driver -> {
				return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");
			}, 20000);
		}
		this.getReusableActionsInstance().staticWait(3 * this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
		String lsAddress = inputAddOrEditAddressLine1.getAttribute("value").trim();

		Map<String, String> map = new HashMap<>();
		map.put("firstName", lsFirstName);
		map.put("lastName", lsLastName);
		map.put("address", lsAddress);
		map.put("selectedIndex", selectedIndexInAutoSearchDropdownMenu + "");

		return map;
	}

	/**
	 * To edit an address
	 *
	 * @param - Map<String,String> map
	 * @param - String - lsAuoSearchKeyword - can be set as null
	 * @param - String - address
	 */
	public String editAddress(Map<String, String> map, String lsAuoSearchKeyword) {
		if(map!=null){
			for (Map.Entry<String, String> entry : map.entrySet()) {
				switch (entry.getKey()) {
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
						String[] data = entry.getValue().toString().codePoints().mapToObj(cp -> new String(Character.toChars(cp))).toArray(size -> new String[size]);
						int sum = 0;
						for (String inputText : data) {
							if (sum >= 30) {
								break;
							}
							inputAddOrEditAddressLine1.sendKeys(inputText);
							//For thinking time for waiting for backend response
							this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
							sum++;
						}
						this.waitForCondition(Driver -> {
							return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: block;");
						}, 20000);
						this.getReusableActionsInstance().staticWait(2 * this.getStaticWaitForApplication());

						if (this.lstAddOrEditAddressAutoSearchDropdownItems.size() >= 1) {
							reporter.reportLogPass("Getting dropdown auto search results successfully");
						} else {
							reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
						}

						try {
							this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
							this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
							this.clickWebElementUsingJS(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
							this.waitForCondition(Driver -> {
								return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");
							}, 20000);
						} catch (Exception e) {
							this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
							this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
							this.clickWebElementUsingJS(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
							this.waitForCondition(Driver -> {
								return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");
							}, 20000);
						}
						this.getReusableActionsInstance().staticWait(3 * this.getStaticWaitForApplication());
						break;
					default:
						break;
				}
			}
		}

		String lsAddress = null;
		if (lsAuoSearchKeyword != null) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
			inputAddOrEditAddressLine1.clear();
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			String[] data = lsAuoSearchKeyword.codePoints().mapToObj(cp -> new String(Character.toChars(cp))).toArray(size -> new String[size]);
			int sum = 0;
			for (String inputText : data) {
				if (sum >= 30) {
					break;
				}
				inputAddOrEditAddressLine1.sendKeys(inputText);
				//For thinking time for waiting for backend response
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				sum++;
			}
			this.waitForCondition(Driver -> {
				return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: block;");
			}, 20000);
			this.getReusableActionsInstance().staticWait(3 * this.getStaticWaitForApplication());

			if (this.lstAddOrEditAddressAutoSearchDropdownItems.size() >= 1) {
				reporter.reportLogPass("Getting dropdown auto search results successfully");
			} else {
				reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
			}
			/**
			 int optionSize=this.lstAddOrEditAddressAutoSearchDropdownItems.size();
			 Random rand = new Random();
			 int randomNumber = rand.nextInt(optionSize-2);

			 this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(randomNumber));
			 this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(randomNumber));
			 */
			try {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
				this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				this.waitForCondition(Driver -> {
					return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");
				}, 20000);
			} catch (Exception e) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
				this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				this.waitForCondition(Driver -> {
					return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");
				}, 20000);
			}
			this.getReusableActionsInstance().staticWait(3 * this.getStaticWaitForApplication());

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
			lsAddress = inputAddOrEditAddressLine1.getAttribute("value").trim();
		}

		return lsAddress;
	}

	/**
	 * To verify Auto Search function For Address input
	 *
	 * @param - boolean - bCancel - clicking Cancel button to close Add/Edit window
	 */
	public void verifyAutoSearchForAddress(boolean bCancel) {
		String lsFirstName = DataConverter.getSaltString(1, "upperStringType") + DataConverter.getSaltString(5, "lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressFirstName);
		inputAddOrEditAddressFirstName.clear();
		inputAddOrEditAddressFirstName.sendKeys(lsFirstName);
		this.getReusableActionsInstance().staticWait(300);

		String lsLastName = DataConverter.getSaltString(1, "upperStringType") + DataConverter.getSaltString(7, "lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLastName);
		inputAddOrEditAddressLastName.clear();
		inputAddOrEditAddressLastName.sendKeys(lsLastName);
		this.getReusableActionsInstance().staticWait(300);

		String lsPhoneNumber1 = "647";
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber1);
		inputAddOrEditAddressPhoneNumber1.clear();
		inputAddOrEditAddressPhoneNumber1.sendKeys(lsPhoneNumber1);
		this.getReusableActionsInstance().staticWait(1000);

		String lsPhoneNumber2 = DataConverter.getSaltString(3, "numberType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber2);
		inputAddOrEditAddressPhoneNumber2.clear();
		inputAddOrEditAddressPhoneNumber2.sendKeys(lsPhoneNumber2);
		this.getReusableActionsInstance().staticWait(1000);

		String lsPhoneNumber3 = DataConverter.getSaltString(4, "numberType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber3);
		inputAddOrEditAddressPhoneNumber3.clear();
		inputAddOrEditAddressPhoneNumber3.sendKeys(lsPhoneNumber3);
		this.getReusableActionsInstance().staticWait(1000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressCity);
		inputAddOrEditAddressCity.clear();
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectAddOrEditAddressProvince);
		Select selectProvince = new Select(selectAddOrEditAddressProvince);
		selectProvince.selectByIndex(0);
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode1);
		inputAddOrEditAddressPostalCode1.clear();
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode2);
		inputAddOrEditAddressPostalCode2.clear();
		this.getReusableActionsInstance().staticWait(300);

		String lsAddress1 = "1122";
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
		inputAddOrEditAddressLine1.clear();
		String[] data = lsAddress1.codePoints().mapToObj(cp -> new String(Character.toChars(cp))).toArray(size -> new String[size]);
		int sum = 0;
		for (String inputText : data) {
			if (sum >= 30) {
				break;
			}
			inputAddOrEditAddressLine1.sendKeys(inputText);
			//For thinking time for waiting for backend response
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			sum++;
		}
		this.waitForCondition(Driver -> {
			return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: block;");
		}, 20000);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		if (this.lstAddOrEditAddressAutoSearchDropdownItems.size() >= 1) {
			reporter.reportLogPass("Getting dropdown auto search results successfully");
		} else {
			reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
		}

		try {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
			this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
			this.waitForCondition(Driver -> {
				return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");
			}, 20000);
		} catch (Exception e) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
			this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressAutoSearchDropdownItems.get(0));
			this.waitForCondition(Driver -> {
				return this.cntAddOrEditAddressAutoSearch.getAttribute("style").contains("display: none;");
			}, 20000);
		}
		this.getReusableActionsInstance().staticWait(3 * this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressCity);
		String lsAddress = inputAddOrEditAddressCity.getAttribute("value").trim();
		if (!lsAddress.isEmpty()) {
			reporter.reportLogPass("Auto search function is working well for City field");
		} else {
			reporter.reportLogFailWithScreenshot("Auto search function is not working well for City field");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectAddOrEditAddressProvince);
		String lsText = selectProvince.getFirstSelectedOption().getText().trim();
		if (!lsText.isEmpty() && !lsText.equalsIgnoreCase("Select Province")) {
			reporter.reportLogPass("Auto search function is working well for Province field");
		} else {
			reporter.reportLogFailWithScreenshot("Auto search function is not working well for Province field");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode1);
		lsText = inputAddOrEditAddressPostalCode1.getAttribute("value").trim();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Auto search function is working well for Postal Code field 1");
		} else {
			reporter.reportLogFailWithScreenshot("Auto search function is not working well for Postal Code field 1");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPostalCode2);
		lsText = inputAddOrEditAddressPostalCode2.getAttribute("value").trim();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Auto search function is working well for Postal Code field 2");
		} else {
			reporter.reportLogFailWithScreenshot("Auto search function is not working well for Postal Code field 2");
		}
	}

	/**
	 * To get the given shipping or billing address info(first name,last name,Address,city,province,postal code)
	 *
	 * @param - shippingAddressIndex - if equal to -1, then refer to Billing address
	 * @return - Map<String,String>
	 */
	public Map<String, String> getGivenShippingOrBillingAddress(int shippingAddressIndex) {
		if (shippingAddressIndex == -1) {
			this.openAddOrEditAddressWindow("editBillingAddress", null);
		} else {
			try {
				this.waitForCondition(Driver -> {
					return this.lblShippingAddressSectionTitle.isDisplayed();
				}, 40000);
			} catch (Exception Error) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCancel);
				this.clickElement(this.btnCancel);
			}
			WebElement shippingAddressContainer = this.lstShippingAddressContainer.get(shippingAddressIndex);
			WebElement editButton = shippingAddressContainer.findElement(this.byShippingAddressEdit);
			this.openAddOrEditAddressWindow("editShippingAddress", editButton);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressFirstName);
		String lsFirstName = inputAddOrEditAddressFirstName.getAttribute("value");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLastName);
		String lsLastName = inputAddOrEditAddressLastName.getAttribute("value");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber1);
		String lsPhoneNumber1 = inputAddOrEditAddressPhoneNumber1.getAttribute("value");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber2);
		String lsPhoneNumber2 = inputAddOrEditAddressPhoneNumber2.getAttribute("value");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressPhoneNumber3);
		String lsPhoneNumber3 = inputAddOrEditAddressPhoneNumber3.getAttribute("value");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressLine1);
		String lsAddress = inputAddOrEditAddressLine1.getAttribute("value");

		this.closeAddOrEditAddressWindow(false);

		Map<String, String> map = new HashMap<>();
		map.put("firstName", lsFirstName);
		map.put("lastName", lsLastName);
		map.put("phoneNumber1", lsPhoneNumber1);
		map.put("phoneNumber2", lsPhoneNumber2);
		map.put("phoneNumber3", lsPhoneNumber3);
		map.put("address", lsAddress);

		return map;
	}

	/**
	 * To set Default Shipping Address Or Billing Address
	 */
	public void setDefaultShippingAddress() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbAddOrEditMakeDefaultShippingAddress);
		if (!ckbAddOrEditMakeDefaultShippingAddress.isSelected()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrEditMakeDefaultShippingAddress);
			labelAddOrEditMakeDefaultShippingAddress.click();
		}
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
	}

	/**
	 * To get edit button for given shipping address
	 *
	 * @param selectedIndex
	 * @return edit button
	 */
	public WebElement getGivenShippingAddressEditButton(int selectedIndex) {
		WebElement container = this.lstShippingAddressContainer.get(selectedIndex);
		return container.findElement(this.byShippingAddressEdit);
	}

	/**
	 * To verify favorite page
	 *
	 * @param - Map<String,String> - map - including productName,ProductNowPrice, ProductWasPrice
	 * @param - int - favoriteItemAmount
	 */
	public void verifyFavoritePageContent(Map<String, String> map, int favoriteItemAmount) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyFavouritesTitle);
		if (!lblMyFavouritesTitle.getText().isEmpty()) {
			reporter.reportLogPass("Favorite title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Favorite title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnClearAllFavouriteHistory);
		if (!btnClearAllFavouriteHistory.getText().isEmpty()) {
			reporter.reportLogPass("Clear All Favorite History button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Clear All Favorite History button is not displaying correctly");
		}

		if (favoriteItemAmount == this.lstFavouriteProduct.size()) {
			reporter.reportLogPass("The favorite item list size is equal to the favorite amount under My Preference");
		} else {
			reporter.reportLogFailWithScreenshot("The favorite item list size is not equal to the favorite amount under My Preference");
		}

		String lsProductName = map.get("productName").toString();
		String lsProductNowPrice = map.get("productNowPrice").toString();
		String lsProductWasPrice = null;
		if (map.get("productName") != null) {
			lsProductWasPrice = map.get("productWasPrice").toString();
		}

		String lsFavoriteItemName = null, lsFavoriteItemNowPrice = null, lsFavoriteItemWasPrice = null;
		WebElement item = this.lstFavouriteProduct.get(0);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		WebElement element = item.findElement(byFavoriteItemImage);
		if (!element.getAttribute("src").isEmpty()) {
			reporter.reportLogPass("The favorite item image source is not empty");
		} else {
			reporter.reportLogFailWithScreenshot("The favorite item image source not empty");
		}

		element = item.findElement(byFavoriteItemName);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		lsFavoriteItemName = element.getText().trim();
		if (!lsFavoriteItemName.isEmpty()) {
			reporter.reportLogPass("The favorite item name is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The favorite item name is not displaying correctly");
		}

		element = item.findElement(byFavoriteItemNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		lsFavoriteItemNowPrice = element.getText().trim();
		if (!lsFavoriteItemNowPrice.isEmpty()) {
			reporter.reportLogPass("The favorite item NowPrice is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The favorite item NowPrice is not displaying correctly");
		}

		if (lsProductWasPrice != null) {
			element = item.findElement(byFavoriteItemWasPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsFavoriteItemWasPrice = element.getText().trim();
			if (!lsFavoriteItemWasPrice.isEmpty()) {
				reporter.reportLogPass("The favorite item WasPrice is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The favorite item WasPrice is not displaying correctly");
			}
		}

		if (lsProductName.equalsIgnoreCase(lsFavoriteItemName) || lsProductName.toLowerCase().contains(lsFavoriteItemName.toLowerCase()) || lsFavoriteItemName.toLowerCase().contains(lsProductName.toLowerCase())) {
			reporter.reportLogPass("The product name on PRP page is equal to the favorite item name");
		} else {
			reporter.reportLogFailWithScreenshot("The product name on PRP page:'" + lsProductName + "' is not equal to the favorite item name:'" + lsFavoriteItemName + "'");
		}

		if (lsFavoriteItemNowPrice.equalsIgnoreCase(lsProductNowPrice)) {
			reporter.reportLogPass("The product NowPrice on PRP page is equal to the favorite item NowPrice");
		} else {
			reporter.reportLogFailWithScreenshot("The product NowPrice:" + lsProductNowPrice + " on PRP page is not equal to the favorite item NowPrice:" + lsFavoriteItemNowPrice);
		}

		if (lsProductWasPrice != null) {
			if (lsFavoriteItemWasPrice.equalsIgnoreCase(lsProductWasPrice)) {
				reporter.reportLogPass("The product WasPrice on PRP page is equal to the favorite item WasPrice");
			} else {
				reporter.reportLogFailWithScreenshot("The product WasPrice:" + lsProductWasPrice + " on PRP page is not equal to the favorite item WasPrice:" + lsFavoriteItemWasPrice);
			}
		}
	}

	/**
	 * To add Favorite Item From PRP
	 *
	 * @param - String - lsKeyword
	 * @param - ProductResultsPage - prp
	 * @return - Map<String,String> - including productName,ProductNowPrice,ProductWasPrice
	 */
	public Map<String, String> addFavoriteItemFromPRP(String lsKeyword, ProductResultsPage prp) {
		Map<String, String> map = new HashMap<>();
		prp.getSearchResultLoad(lsKeyword, true);
		for (WebElement item : prp.getProductList()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			WebElement element = item.findElement(prp.byProductHeaderLike);
			final WebElement tmpElement = element;
			if (element.getAttribute("aria-pressed").equalsIgnoreCase("false")) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				this.getReusableActionsInstance().clickIfAvailable(element);
				this.waitForCondition(Driver -> {
					return tmpElement.getAttribute("aria-pressed").equalsIgnoreCase("true");
				}, 10000);
				if (element.getAttribute("aria-pressed").equalsIgnoreCase("true")) {
					reporter.reportLogPass("The favorite icon on PRP page is highlighted correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The favorite icon on PRP page is not highlighted correctly");
				}

				element = item.findElement(prp.byProductName);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				map.put("productName", element.getText().trim());

				element = item.findElement(prp.byProductNowPrice);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				map.put("productNowPrice", element.getText().trim().split(":")[1].trim());

				if (prp.checkProductItemWasPriceExisting(item)) {
					element = item.findElement(prp.byProductWasPrice);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					map.put("productWasPrice", element.getText().trim().split(":")[1].trim());
				} else {
					map.put("productWasPrice", null);
				}
				break;
			}
		}
		return map;
	}

	/**
	 * To verify Favorite Item on PDP
	 *
	 * @param - ProductDetailPage - pdp
	 */
	public void verifyFavoriteItemOnPDP(ProductDetailPage pdp) {
		WebElement item = this.lstFavouriteProduct.get(0);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);

		WebElement imageElement, element;
		imageElement = item.findElement(byFavoriteItemImage);

		element = item.findElement(byFavoriteItemName);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		String lsFavoriteItemName = element.getText().trim();

		element = item.findElement(byFavoriteItemNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		String lsFavoriteItemNowPrice = String.valueOf(this.getFloatFromString(element.getText(), true));
		;

		String lsFavoriteItemWasPrice = null;
		if (this.getChildElementCount(item.findElement(byFavoriteItemPriceContainer)) > 1) {
			element = item.findElement(byFavoriteItemWasPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsFavoriteItemWasPrice = String.valueOf(this.getFloatFromString(element.getText(), true));
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imageElement);
		this.getReusableActionsInstance().clickIfAvailable(imageElement);
		this.waitForCondition(Driver -> {
			return pdp.lblProductName.isDisplayed();
		}, 30000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(pdp.lblProductName);
		String lsPDPItemName = pdp.lblProductName.getText().trim();
		if (lsFavoriteItemName.equalsIgnoreCase(lsPDPItemName) || lsFavoriteItemName.toLowerCase().contains(lsPDPItemName.toLowerCase()) || lsPDPItemName.toLowerCase().contains(lsFavoriteItemName.toLowerCase())) {
			reporter.reportLogPass("The favorite name is the same as the PDP product name");
		} else {
			reporter.reportLogFailWithScreenshot("The favorite name:" + lsFavoriteItemName + " is not the same as the PDP product name:" + lsPDPItemName);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(pdp.lblProductNowPrice);
		String lsPDPItemNowPrice = String.valueOf(this.getFloatFromString(pdp.lblProductNowPrice.getText(), true));
		if (lsFavoriteItemNowPrice.equalsIgnoreCase(lsPDPItemNowPrice)) {
			reporter.reportLogPass("The favorite NowPrice is the same as the PDP product NowPrice");
		} else {
			reporter.reportLogFailWithScreenshot("The favorite NowPrice:" + lsFavoriteItemNowPrice + " is not the same as the PDP product NowPrice:" + lsPDPItemNowPrice);
		}

		if (lsFavoriteItemWasPrice != null) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(pdp.lblProductWasPrice);
			String lsPDPItemWasPrice = String.valueOf(this.getFloatFromString(pdp.lblProductWasPrice.getText(), true));
			if (lsFavoriteItemWasPrice.equalsIgnoreCase(lsPDPItemWasPrice)) {
				reporter.reportLogPass("The favorite WasPrice is the same as the PDP product WasPrice");
			} else {
				reporter.reportLogFailWithScreenshot("The favorite WasPrice:" + lsFavoriteItemWasPrice + " is not the same as the PDP product WasPrice:" + lsPDPItemWasPrice);
			}
		}

		if (pdp.checkIfFavShareMobileHighlighted()) {
			reporter.reportLogPass("The FavShareMobile icon is highlighted correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The FavShareMobile icon is not highlighted correctly");
		}
	}

	/**
	 * To cancel Favorite Item On PDP page
	 *
	 * @param - ProductDetailPage - pdp
	 * @return - String - product name
	 */
	public String cancelFavoriteItemOnPDP(ProductDetailPage pdp) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(pdp.lblProductName);
		String lsPDPProductName = pdp.lblProductName.getText().trim();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(pdp.lnkFavIcon);
		this.clickElement(pdp.lnkFavIcon);
		this.waitForCondition(Driver -> {
			return !pdp.checkIfFavShareMobileHighlighted();
		}, 5000);

		if (!pdp.checkIfFavShareMobileHighlighted()) {
			reporter.reportLogPass("The cancel favorite item action is working well");
		} else {
			reporter.reportLogFailWithScreenshot("The cancel favorite item action is not working well");
		}

		return lsPDPProductName;
	}

	/**
	 * To verify PRP Favorite Icon After Cancel Action From PDP
	 *
	 * @param - String - lsKeyword - product name
	 * @param - ProductResultsPage - prp
	 */
	public void verifyPRPFavoriteIconAfterCancelActionFromPDP(String lsKeyword, ProductResultsPage prp) {
		prp.getSearchResultLoad(lsKeyword, true);
		WebElement item = prp.getProductList().get(0).findElement(prp.byProductHeaderLike);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		if (item.getAttribute("aria-pressed").equalsIgnoreCase("false")) {
			reporter.reportLogPass("The favorite icon on PDP is not highlighted");
		} else {
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
	 *
	 * @param - Map<String,String> - productMap
	 */
	public void verifyRecentlyViewingHistoryContent(Map<String, String> productMap) {
		String lsText, lsTextMap;
		WebElement item, element;

		ProductResultsPage prp = new ProductResultsPage(this.getDriver());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRecentlyViewedTitle);
		lsText = lblRecentlyViewedTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Recently Viewing history title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Recently Viewing history title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnClearViewingHistory);
		lsText = btnClearViewingHistory.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Clear Viewing history button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Clear Viewing history button is not displaying correctly");
		}

		reporter.reportLog("verify Recently Viewing History item");
		item = this.lstRecentlyViewedItemContainerList.get(0);
		element = item.findElement(byRecentlyViewedItemLink);
		lsText = element.getAttribute("href");
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The link of recently viewing history item is not empty");
		} else {
			reporter.reportLogFailWithScreenshot("The link of recently viewing history item is empty");
		}

		element = item.findElement(byRecentlyViewedItemImage);
		lsText = element.getAttribute("src");
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The image source of recently viewing history item is not empty");
		} else {
			reporter.reportLogFailWithScreenshot("The image source of recently viewing history item is empty");
		}

		element = item.findElement(byRecentlyViewedItemName);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		lsText = element.getText().trim();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The product name of recently viewing history item is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The product name of recently viewing history item is not displaying correctly");
		}

		lsTextMap = productMap.get("productName");
		if (lsTextMap.equalsIgnoreCase(lsText) || lsTextMap.toLowerCase().contains(lsText.toLowerCase()) || lsText.toLowerCase().contains(lsTextMap.toLowerCase())) {
			reporter.reportLogPass("The favorite name is the same as the PDP product name");
		} else {
			reporter.reportLogFailWithScreenshot("The favorite name:" + lsText + " is not the same as the PDP product name:" + lsTextMap);
		}

		element = item.findElement(byRecentlyViewedItemNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		lsText = String.valueOf(this.getFloatFromString(element.getText(), true));
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The product NowPrice of recently viewing history item is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The product NowPrice of recently viewing history item is not displaying correctly");
		}

		lsTextMap = productMap.get("productNowPrice");
		if (lsText.equalsIgnoreCase(lsTextMap)) {
			reporter.reportLogPass("The product NowPrice of recently viewing history item is the same as the one on PRP page");
		} else {
			reporter.reportLogFail("The product NowPrice of recently viewing history item is not the same as the one on PRP page");
		}

		lsTextMap = productMap.get("productWasPrice");
		if (lsText != null) {
			element = item.findElement(byRecentlyViewedItemWasPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsText = String.valueOf(this.getFloatFromString(element.getText(), true));
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product WasPrice of recently viewing history item is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product WasPrice of recently viewing history item is not displaying correctly");
			}

			if (lsText.equalsIgnoreCase(lsTextMap)) {
				reporter.reportLogPass("The product WasPrice of recently viewing history item is the same as the one on PRP page");
			} else {
				reporter.reportLogFail("The product WasPrice of recently viewing history item is not the same as the one on PRP page");
			}
		}

		lsTextMap = productMap.get("productReviewRate");
		if (lsTextMap != null) {
			List<WebElement> itemList = item.findElements(byRecentlyViewedItemReviewRateStarList);
			if (itemList.size() > 0) {
				reporter.reportLogPass("Review star list is not empty");
			} else {
				reporter.reportLogFailWithScreenshot("Review star list is empty");
			}

			int reviewRate = prp.getProductItemReviewNumberAmountFromStarImage(itemList);
			if (lsTextMap.equalsIgnoreCase(reviewRate + "")) {
				reporter.reportLogPass("The product review rate of recently viewing history item is the same as the one on PRP page");
			} else {
				reporter.reportLogFailWithScreenshot("The product review rate: " + reviewRate + " of recently viewing history item is not the same as the one: " + reviewRate + " on PRP page");
			}
		}

		lsTextMap = productMap.get("productReviewCount");
		if (lsTextMap != null) {
			element = item.findElement(byRecentlyViewedItemReviewAmount);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsText = element.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product review rate of recently viewing history item is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product review rate of recently viewing history item is not displaying correctly");
			}

			int reviewCount = this.getIntegerFromString(lsText);
			if (lsTextMap.equalsIgnoreCase(reviewCount + "")) {
				reporter.reportLogPass("The product review count of recently viewing history item is the same as the one on PRP page");
			} else {
				reporter.reportLogFailWithScreenshot("The product review count: " + reviewCount + " of recently viewing history item is not the same as the one: " + lsTextMap + " on PRP page");
			}
		}
	}

	/**
	 * To get Into MyNewsLetters iFrame
	 */
	public void getIntoMyNewsLettersIFrame() {
		this.getDriver().switchTo().frame(this.iFrameEmailSignup);
	}

	/**
	 * To get out of MyNewsLetters iFrame
	 */
	public void getOutMyNewsLettersIFrame() {
		this.getDriver().switchTo().defaultContent();
	}

	/**
	 * verify Changing Subscription Success Message in NewsLetters
	 *
	 * @param - WebElement - ckbItem
	 * @param - boolean - bCheck - if check the related Subscription checkbox
	 * @param - String - lsExpectedMessage
	 */
	public void verifyNewsLettersChangingSubscriptionSuccessMessage(WebElement ckbItem, boolean bCheck, String lsExpectedMessage) {
		this.getIntoMyNewsLettersIFrame();
		clearUnSubscribeOption();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbItem);
		if (bCheck) {
			if (!ckbItem.isSelected()) {
				this.getReusableActionsInstance().clickIfAvailable(ckbItem);
			}
		} else {
			if (ckbItem.isSelected()) {
				this.getReusableActionsInstance().clickIfAvailable(ckbItem);
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnMyNewsLettersUpdatePrefs);
		this.getReusableActionsInstance().clickIfAvailable(btnMyNewsLettersUpdatePrefs);

		try {
			this.waitForCondition(Driver -> {
				return this.lblSubscriptionSuccessMessage.isDisplayed();
			}, 30000);
		} catch (Exception e) {
			this.getReusableActionsInstance().staticWait(5 * this.getStaticWaitForApplication());
		}
		this.getReusableActionsInstance().staticWait(5 * this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSubscriptionSuccessMessage);
		String lsActualMessage = this.lblSubscriptionSuccessMessage.getText();
		if (lsActualMessage.toLowerCase().contains(lsExpectedMessage.toLowerCase())) {
			reporter.reportLogPass("The subscription message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The subscription message is not displaying correctly");
		}
		this.getOutMyNewsLettersIFrame();
	}

	/**
	 * verify UnSubscription Success Message in NewsLetters
	 *
	 * @param - String - lsExpectedMessage
	 */
	public void verifyNewsLettersUnSubscriptionSuccessMessage(String lsExpectedMessage) {
		this.getIntoMyNewsLettersIFrame();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersUnsubscribeTitle);
		if (!ckbMyNewsLettersUnsubscribe.isSelected()) {
			ckbMyNewsLettersUnsubscribe.click();
		}
		this.applyStaticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnMyNewsLettersUnsubscribe);
		btnMyNewsLettersUnsubscribe.click();
		try {
			this.waitForCondition(Driver -> {
				return this.lblSubscriptionSuccessMessage.isDisplayed();
			}, 30000);
		} catch (Exception e) {
			this.getReusableActionsInstance().staticWait(5 * this.getStaticWaitForApplication());
		}
		this.getReusableActionsInstance().staticWait(5 * this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSubscriptionSuccessMessage);
		String lsActualMessage = this.lblSubscriptionSuccessMessage.getText();
		if (lsActualMessage.toLowerCase().contains(lsExpectedMessage.toLowerCase())) {
			reporter.reportLogPass("The subscription message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The subscription message is not displaying correctly");
		}
		this.getOutMyNewsLettersIFrame();
	}

	/**
	 * verify UnSubscription Success Message in NewsLetters
	 *
	 * @param - boolean - bCheckUnSubscription - if check the UnSubscription checkbox
	 * @param - String - lsExpectedAlertMessage
	 * @param - String - lsExpectedUnSubscriptionMessage
	 */
	public void verifyNewsLettersUnSubscriptionSuccessMessage(boolean bCheckUnSubscription, String lsExpectedAlertMessage, String lsExpectedUnSubscriptionMessage) {
		this.getDriver().switchTo().frame(this.iFrameEmailSignup);

		if (!bCheckUnSubscription) {
			if (this.ckbMyNewsLettersUnsubscribe.isSelected()) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.ckbMyNewsLettersUnsubscribe);
				this.getReusableActionsInstance().clickIfAvailable(this.ckbMyNewsLettersUnsubscribe);
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnMyNewsLettersUnsubscribe);
			this.getReusableActionsInstance().clickIfAvailable(btnMyNewsLettersUnsubscribe);
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			Alert alert = this.getDriver().switchTo().alert();
			String lsActualAlertMessage = alert.getText().trim();
			if (lsActualAlertMessage.toLowerCase().contains(lsExpectedAlertMessage.toLowerCase())) {
				reporter.reportLogPass("The Alert message for not checking UnSubscription is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Alert message for not checking UnSubscription is not displaying correctly");
			}
			alert.accept();
		} else {
			if (!this.ckbMyNewsLettersUnsubscribe.isSelected()) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.ckbMyNewsLettersUnsubscribe);
				this.getReusableActionsInstance().clickIfAvailable(this.ckbMyNewsLettersUnsubscribe);
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnMyNewsLettersUnsubscribe);
			this.getReusableActionsInstance().clickIfAvailable(btnMyNewsLettersUnsubscribe);
			this.getReusableActionsInstance().staticWait(2 * this.getStaticWaitForApplication());
			Alert alert = this.getDriver().switchTo().alert();
			String lsActualAlertMessage = alert.getText().trim();
			if (lsActualAlertMessage.toLowerCase().contains(lsExpectedAlertMessage.toLowerCase())) {
				reporter.reportLogPass("The Alert message for checking UnSubscription is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Alert message for checking UnSubscription is not displaying correctly");
			}
			alert.accept();

			waitForCondition(Driver -> {
				return this.lblSubscriptionSuccessMessage.isDisplayed();
			}, 10000);
			this.getReusableActionsInstance().staticWait(5 * this.getStaticWaitForApplication());

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSubscriptionSuccessMessage);
			String lsActualMessage = this.lblSubscriptionSuccessMessage.getText();
			if (lsActualMessage.toLowerCase().contains(lsExpectedUnSubscriptionMessage.toLowerCase())) {
				reporter.reportLogPass("The UnSubscription message is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The UnSubscription message is not displaying correctly");
			}

			this.navigateBack();
			this.getDriver().switchTo().defaultContent();
		}
	}

	/**
	 * To verify My NewsLetter Content
	 */
	public void verifyMyNewsLetterContent() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersTitle);
		lsText = lblMyNewsLettersTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("MyNewsLetter title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("MyNewsLetter title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersManageYourEmailPreferences);
		lsText = lblMyNewsLettersManageYourEmailPreferences.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Manage Your Email Preferences static text is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Manage Your Email Preferences static text is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbMyNewsLettersTodayShowStopperNewsLetter);
		if (this.getReusableActionsInstance().isElementVisible(ckbMyNewsLettersTodayShowStopperNewsLetter)) {
			reporter.reportLogPass("Today Show Stopper NewsLetter checkbox is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Today Show Stopper NewsLetter checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersTodayShowStopperNewsLetterTitle);
		lsText = lblMyNewsLettersTodayShowStopperNewsLetterTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Today Show Stopper NewsLetter checkbox label is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Today Show Stopper NewsLetter checkbox label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersTodayShowStopperNewsLetterExplanationInfo);
		lsText = lblMyNewsLettersTodayShowStopperNewsLetterExplanationInfo.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Today Show Stopper NewsLetter checkbox Explanation Info is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Today Show Stopper NewsLetter checkbox Explanation Info is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbMyNewsLettersSpecialOfferAndEventNewsLetter);
		if (this.getReusableActionsInstance().isElementVisible(ckbMyNewsLettersSpecialOfferAndEventNewsLetter)) {
			reporter.reportLogPass("Special Offer And Event NewsLetter checkbox is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Special Offer And Event NewsLetter checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersSpecialOfferAndEventNewsLetterTitle);
		lsText = lblMyNewsLettersSpecialOfferAndEventNewsLetterTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Special Offer And Event NewsLetter checkbox label is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Special Offer And Event NewsLetter checkbox label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersSpecialOfferAndEventNewsLetterExplanationInfo);
		lsText = lblMyNewsLettersSpecialOfferAndEventNewsLetterExplanationInfo.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Special Offer And Event NewsLetter checkbox Explanation Info is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Special Offer And Event NewsLetter checkbox Explanation Info is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbMyNewsLettersPreferredCustomerOffer);
		if (this.getReusableActionsInstance().isElementVisible(ckbMyNewsLettersPreferredCustomerOffer)) {
			reporter.reportLogPass("Preferred Customer Offer checkbox is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Preferred Customer Offer checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersPreferredCustomerOfferTitle);
		lsText = lblMyNewsLettersPreferredCustomerOfferTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Preferred Customer Offer checkbox label is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Preferred Customer Offer checkbox label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersPreferredCustomerOfferExplanationInfo);
		lsText = lblMyNewsLettersPreferredCustomerOfferExplanationInfo.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Preferred Customer Offer checkbox Explanation Info is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Preferred Customer Offer checkbox Explanation Info is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbMyNewsLettersProductUpdatesAndAlerts);
		if (this.getReusableActionsInstance().isElementVisible(ckbMyNewsLettersProductUpdatesAndAlerts)) {
			reporter.reportLogPass("Product Updates And Alerts checkbox is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Product Updates And Alerts checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersProductUpdatesAndAlertsTitle);
		lsText = lblMyNewsLettersProductUpdatesAndAlertsTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Product Updates And Alerts checkbox label is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Product Updates And Alerts checkbox label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersProductUpdatesAndAlertsExplanationInfo);
		lsText = lblMyNewsLettersProductUpdatesAndAlertsExplanationInfo.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Product Updates And Alerts checkbox Explanation Info is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Product Updates And Alerts checkbox Explanation Info is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnMyNewsLettersUpdatePrefs);
		if (this.getReusableActionsInstance().isElementVisible(btnMyNewsLettersUpdatePrefs)) {
			reporter.reportLogPass("UpdatePrefs button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("UpdatePrefs button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbMyNewsLettersUnsubscribe);
		if (this.getReusableActionsInstance().isElementVisible(ckbMyNewsLettersUnsubscribe)) {
			reporter.reportLogPass("Unsubscribe checkbox is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Unsubscribe checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersUnsubscribeTitle);
		lsText = lblMyNewsLettersUnsubscribeTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Unsubscribe checkbox label is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Unsubscribe checkbox label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersUnsubscribeDescription);
		lsText = lblMyNewsLettersUnsubscribeDescription.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("Unsubscribe Description is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Unsubscribe Description is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnMyNewsLettersUnsubscribe);
		if (this.getReusableActionsInstance().isElementVisible(btnMyNewsLettersUnsubscribe)) {
			reporter.reportLogPass("Unsubscribe button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("Unsubscribe button is not displaying correctly");
		}
	}

	/**
	 * To check Viewed History Existing
	 *
	 * @return - boolean
	 */
	public boolean checkViewedHistoryExisting() {
		return this.getChildElementCount(cntRecentlyViewedTitleContainer) > 1;
	}

	/**
	 * To verify No Order Records Message
	 *
	 * @param - String - expectedNoOrderRecorderMessage
	 */
	public void verifyNoOrderRecordsMessage(String expectedNoOrderRecorderMessage) {
		reporter.reportLog("No order item existing");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblNoOrderInfo);
		String lsText = lblNoOrderInfo.getText().trim();
		if (lsText.equalsIgnoreCase(expectedNoOrderRecorderMessage)) {
			reporter.reportLogPass("The no order record message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The no order record message is not displaying as expected: '" + expectedNoOrderRecorderMessage + "'");
		}
	}

	/**
	 * To clear All MyNewsLetter Subscribe Options
	 */
	public void clearAllMyNewsLetterSubscribeOptions() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersTodayShowStopperNewsLetterTitle);
		if (ckbMyNewsLettersTodayShowStopperNewsLetter.isSelected()) {
			ckbMyNewsLettersTodayShowStopperNewsLetter.click();
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersSpecialOfferAndEventNewsLetterTitle);
		if (ckbMyNewsLettersSpecialOfferAndEventNewsLetter.isSelected()) {
			ckbMyNewsLettersSpecialOfferAndEventNewsLetter.click();
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersPreferredCustomerOfferTitle);
		if (ckbMyNewsLettersPreferredCustomerOffer.isSelected()) {
			ckbMyNewsLettersPreferredCustomerOffer.click();
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersProductUpdatesAndAlertsTitle);
		if (ckbMyNewsLettersProductUpdatesAndAlerts.isSelected()) {
			ckbMyNewsLettersProductUpdatesAndAlerts.click();
		}
		this.applyStaticWait(this.getStaticWaitForApplication());
	}

	/**
	 * To clear UnSubscribe Option
	 */
	public void clearUnSubscribeOption() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersUnsubscribeTitle);
		if (ckbMyNewsLettersUnsubscribe.isSelected()) {
			ckbMyNewsLettersUnsubscribe.click();
		}
		this.applyStaticWait(this.getStaticWaitForApplication());
	}

	/**
	 * To verify Subscribe Message
	 *
	 * @param - String - lsExpectedAlertMessage
	 * @param - String - lsExpectedErrorMessage
	 */
	public void verifySubscribeMessage(String lsExpectedAlertMessage, String lsExpectedErrorMessage) {
		clearUnSubscribeOption();
		clearAllMyNewsLetterSubscribeOptions();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnMyNewsLettersUpdatePrefs);
		btnMyNewsLettersUpdatePrefs.click();
		this.applyStaticWait(this.getStaticWaitForApplication());
		if (checkMyNewsLettersUpdateErrorMessageVisible()) {
			reporter.reportLogPass("MyNewsLetters Update Error Message is Visible");
		} else {
			reporter.reportLogFail("MyNewsLetters Update Error Message is not Visible");
		}

		if (!checkMyNewsLettersUpdateAlertMessageVisible()) {
			reporter.reportLogPass("MyNewsLetters Update alert Message is not Visible");
		} else {
			reporter.reportLogFail("MyNewsLetters Update alert Message is Visible");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersUpdateErrorMessage);
		String lsActualErrorMessage = lblMyNewsLettersUpdateErrorMessage.getText().trim();
		if (lsActualErrorMessage.equalsIgnoreCase(lsExpectedErrorMessage)) {
			reporter.reportLogPass("The actual MyNewsLetters Update Error Message is same as the expected one");
		} else {
			reporter.reportLogFail("The actual MyNewsLetters Update Error Message: '" + lsActualErrorMessage + "' is same as the expected one: '" + lsExpectedErrorMessage + "'");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersTodayShowStopperNewsLetterTitle);
		ckbMyNewsLettersSpecialOfferAndEventNewsLetter.click();
		this.waitForCondition(Driver -> {
			return checkMyNewsLettersUpdateAlertMessageVisible();
		}, 10000);

		if (!checkMyNewsLettersUpdateErrorMessageVisible()) {
			reporter.reportLogPass("MyNewsLetters Update Error Message is not Visible");
		} else {
			reporter.reportLogFail("MyNewsLetters Update Error Message is Visible");
		}

		if (checkMyNewsLettersUpdateAlertMessageVisible()) {
			reporter.reportLogPass("MyNewsLetters Update alert Message is Visible");
		} else {
			reporter.reportLogFail("MyNewsLetters Update alert Message is not Visible");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersUpdateAlertMessage);
		String lsActualAlertMessage = lblMyNewsLettersUpdateAlertMessage.getText().trim();
		if (lsActualAlertMessage.equalsIgnoreCase(lsExpectedAlertMessage)) {
			reporter.reportLogPass("The actual MyNewsLetters Update alert Message is same as the expected one");
		} else {
			reporter.reportLogFail("The actual MyNewsLetters Update alert Message: '" + lsActualAlertMessage + "' is same as the expected one: '" + lsExpectedAlertMessage + "'");
		}
	}

	/**
	 * To verify UnSubscribe Message
	 *
	 * @param - String - lsExpectedAlertMessage
	 * @param - String - lsExpectedErrorMessage
	 */
	public void verifyUnSubscribeMessage(String lsExpectedAlertMessage, String lsExpectedErrorMessage) {
		clearUnSubscribeOption();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnMyNewsLettersUnsubscribe);
		btnMyNewsLettersUnsubscribe.click();
		this.applyStaticWait(this.getStaticWaitForApplication());
		if (checkMyNewsLettersUnSubscribeErrorMessageVisible()) {
			reporter.reportLogPass("MyNewsLetters UnSubscribe Error Message is Visible");
		} else {
			reporter.reportLogFail("MyNewsLetters UnSubscribe Error Message is not Visible");
		}

		if (!checkMyNewsLettersUnSubscribeAlertMessageVisible()) {
			reporter.reportLogPass("MyNewsLetters UnSubscribe alert Message is not Visible");
		} else {
			reporter.reportLogFail("MyNewsLetters UnSubscribe alert Message is Visible");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersUnSubscribeErrorMessage);
		String lsActualErrorMessage = lblMyNewsLettersUnSubscribeErrorMessage.getText().trim();
		if (lsActualErrorMessage.equalsIgnoreCase(lsExpectedErrorMessage)) {
			reporter.reportLogPass("The actual MyNewsLetters UnSubscribe Error Message is same as the expected one");
		} else {
			reporter.reportLogFail("The actual MyNewsLetters UnSubscribe Error Message: '" + lsActualErrorMessage + "' is same as the expected one: '" + lsExpectedErrorMessage + "'");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersUnsubscribeTitle);
		this.clickElement(ckbMyNewsLettersUnsubscribe);
		this.waitForCondition(Driver -> {
			return checkMyNewsLettersUnSubscribeAlertMessageVisible();
		}, 10000);

		if (!checkMyNewsLettersUnSubscribeErrorMessageVisible()) {
			reporter.reportLogPass("MyNewsLetters UnSubscribe Error Message is not Visible");
		} else {
			reporter.reportLogFail("MyNewsLetters UnSubscribe Error Message is Visible");
		}

		if (checkMyNewsLettersUnSubscribeAlertMessageVisible()) {
			reporter.reportLogPass("MyNewsLetters UnSubscribe alert Message is Visible");
		} else {
			reporter.reportLogFail("MyNewsLetters UnSubscribe alert Message is not Visible");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyNewsLettersUnSubscribeAlertMessage);
		String lsActualAlertMessage = lblMyNewsLettersUnSubscribeAlertMessage.getText().trim();
		if (lsActualAlertMessage.equalsIgnoreCase(lsExpectedAlertMessage)) {
			reporter.reportLogPass("The actual MyNewsLetters UnSubscribe alert Message is same as the expected one");
		} else {
			reporter.reportLogFail("The actual MyNewsLetters UnSubscribe alert Message: '" + lsActualAlertMessage + "' is same as the expected one: '" + lsExpectedAlertMessage + "'");
		}
	}

	/**
	 * To get Order Details Desc Except Order List
	 *
	 * @return - Map<String,Object>
	 */
	public Map<String, Object> getOrderDetailsDescExceptOrderList() {
		Map<String, Object> map = new HashMap<>();
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderNO);
		lsText = lblOrderDetailsHeaderOrderNO.getText().trim();
		map.put("orderNumber", lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderDetailsHeaderOrderedDate);
		lsText = this.lblOrderDetailsHeaderOrderedDate.getText();
		map.put("orderDate", lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderCustomerNO);
		lsText = lblOrderDetailsHeaderCustomerNO.getText().trim();
		map.put("customerNumber", lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderDetailsHeaderOrderMethod);
		lsText = this.lblOrderDetailsHeaderOrderMethod.getText();
		map.put("orderMethod", lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderDetailsHeaderOrderStatus);
		lsText = this.lblOrderDetailsHeaderOrderStatus.getText();
		map.put("orderStatus", lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsHeaderOrderTotal);
		lsText = lblOrderDetailsHeaderOrderTotal.getText().trim();
		map.put("orderTotal", this.getFloatFromString(lsText));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderDetailsSubHeaderCustomerNO);
		lsText = this.lblOrderDetailsSubHeaderCustomerNO.getText();
		map.put("subOrderNumber", lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingMethod);
		lsText = lblOrderDetailsSubHeaderShippingMethod.getText().trim();
		map.put("shippingMethod", lsText);

		if (this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"), System.getProperty("chromeMobileDevice"))) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingAddressMobile);
			lsText = lblOrderDetailsSubHeaderShippingAddressMobile.getText().trim();
		} else {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingAddress);
			lsText = lblOrderDetailsSubHeaderShippingAddress.getText().trim();
		}
		map.put("shippingAddress", this.convertToASCII(lsText));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsBillingAddress);
		lsText = lblOrderDetailsBillingAddress.getText().trim();
		map.put("billingAddress", this.convertToASCII(lsText));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsPaymentMethod);
		lsText = lblOrderDetailsPaymentMethod.getText().trim();
		map.put("paymentMethod", lsText);

		Map<String, String> orderSummaryMap = new HashMap<>();
		for (int counter = 0; counter < this.lstOrderSummaryDetails.size(); counter++) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lstOrderSummaryDetails.get(counter));
			lsText = lstOrderSummaryDetails.get(counter).getText().trim();
			String[] data = lsText.split(":");
			orderSummaryMap.put(data[0].trim(), String.valueOf(this.getFloatFromString(data[1], true)));
		}

		map.put("orderSummary", orderSummaryMap);

		if (this.checkEasyPaymentSectionExisting()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsEasyPaymentNumber);
			lsText = lblOrderDetailsEasyPaymentNumber.getText().trim();
			map.put("installmentNumber", this.getIntegerFromString(lsText));
		} else {
			map.put("installmentNumber", null);
		}

		return map;
	}

	/**
	 * To get Order item Description
	 *
	 * @param - WebElement - orderItem in lstOrderDetailsOrderItemList
	 * @return - Map<String,Object>
	 */
	public Map<String, Object> getOrderItemDesc(WebElement orderItem) {
		Map<String, Object> map = new HashMap<>();
		WebElement item;
		String lsText;
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(orderItem);
		item = orderItem.findElement(byOrderDetailsOrderItemPipeStyleLink);
		lsText = this.getElementInnerText(item);
		map.put("productDescription", lsText);
		if (lsText.contains("|")) {
			String[] lsSplit = lsText.split("\\|");
			if (lsSplit.length == 2) {
				map.put("productName", lsSplit[0].trim());
				if (lsSplit[1].toLowerCase().contains("size")) {
					map.put("productSize", lsSplit[1].split(":")[1].trim());
					map.put("productStyle", null);
				} else {
					map.put("productStyle", lsSplit[1].split(":")[1].trim());
					map.put("productSize", null);
				}
			} else {
				map.put("productName", lsSplit[0].trim());
				map.put("productSize", lsSplit[1].split(":")[1].trim());
				map.put("productStyle", lsSplit[2].split(":")[1].trim());
			}
		} else {
			map.put("productName", lsText);
			map.put("productStyle", null);
			map.put("productSize", null);
		}

		item = orderItem.findElement(byOrderDetailsOrderItemProductPrice);
		lsText = this.getElementInnerText(item);
		map.put("productNowPrice", this.getFloatFromString(lsText));
		item = orderItem.findElement(byOrderDetailsOrderItemProductNumber);
		lsText = this.getElementInnerText(item).replace("-", "").trim();
		if (!lsText.isEmpty()) {
			map.put("productNumber", lsText);
		} else {
			map.put("productNumber", null);
		}

		item = orderItem.findElement(byOrderDetailsOrderItemQTY);
		lsText = this.getElementInnerText(item);
		map.put("productQuantity", this.getIntegerFromString(lsText));
		return map;
	}

	/**
	 * To get Order List Description
	 *
	 * @return - List<Map<String,Object>>
	 */
	public List<Map<String, Object>> getOrderListDesc() {
		List<Map<String, Object>> mapList = new ArrayList<>();
		for (WebElement orderItem : lstOrderDetailsOrderItemList) {
			mapList.add(getOrderItemDesc(orderItem));

		}
		return mapList;
	}

	/**
	 * To get Checkout Item Count And SubTotal
	 *
	 * @param - List<Map<String,Object>> - productList - Checkout product list
	 * @return - Map<String,Object> - including itemCount and subTotal
	 */
	public Map<String, Object> getCheckoutItemCountAndSubTotal(List<Map<String, Object>> productList) {
		Map<String, Object> map = new HashMap<>();

		int totalCount = 0, itemQuantity;
		float subTotal = 0.0f, itemPrice;
		for (Map<String, Object> productItem : productList) {
			itemQuantity = (int) productItem.get("productQuantity");
			itemPrice = (float) productItem.get("productNowPrice");
			totalCount += itemQuantity;
			subTotal += itemQuantity * itemPrice;
		}
		map.put("itemCount", totalCount);
		map.put("subTotal", subTotal);

		return map;
	}

	/**
	 * To check applied discount Existing In Payment Section
	 *
	 * @return
	 */
	public boolean checkAppliedDiscountExistingInOrderSummarySection() {
		return lstOrderDetailsOrderSummaryItems.size() > 4;
	}

	/**
	 * To get OrderSummary Description
	 *
	 * @return - Map<String,Object>
	 */
	public Map<String, Object> getOrderSummaryDesc() {
		Map<String, Object> map = new HashMap<>();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderDetailsSubtotal);
		String lsText = this.lblOrderDetailsSubtotal.getText();
		map.put("subTotal", this.getFloatFromString(lsText));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderDetailsShippingAndHandling);
		lsText = this.lblOrderDetailsShippingAndHandling.getText();
		if (!lsText.toLowerCase().contains("free")) {
			map.put("nowPrice", this.getFloatFromString(lsText));
		} else {
			map.put("nowPrice", 0.0f);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderDetailsTaxes);
		lsText = this.lblOrderDetailsTaxes.getText();
		map.put("tax", this.getFloatFromString(lsText));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderDetailsOrderTotal);
		lsText = this.lblOrderDetailsOrderTotal.getText();
		map.put("totalPrice", this.getFloatFromString(lsText));

		map.put("promoteCodeTitle", null);
		map.put("promoteCodeValue", 0.0f);
		map.put("giftCardTitle", null);
		map.put("giftCardValue", 0.0f);

		if (checkAppliedDiscountExistingInOrderSummarySection()) {
			WebElement subItem;
			String lsSubText;
			for (WebElement item : lstOrderDetailsOrderSummaryItems) {
				lsText = this.getElementInnerText(item).toLowerCase();
				if (lsText.contains("discount")) {
					subItem = item.findElement(By.xpath("./span[1]"));
					lsSubText = this.getElementInnerText(subItem);
					map.put("promoteCodeTitle", lsSubText);

					subItem = item.findElement(By.xpath("./span[2]"));
					lsSubText = this.getElementInnerText(subItem);
					map.put("promoteCodeValue", this.getFloatFromString(lsSubText));
				}

				if (lsText.contains("gift card")) {
					subItem = item.findElement(By.xpath("./span[1]"));
					lsSubText = this.getElementInnerText(subItem);
					map.put("giftCardTitle", lsSubText);

					subItem = item.findElement(By.xpath("./span[2]"));
					lsSubText = this.getElementInnerText(subItem);
					map.put("giftCardValue", this.getFloatFromString(lsSubText));
				}
			}
		}

		return map;
	}

	/**
	 * This function verifies breadcrumb navigation pages
	 *
	 * @param - String
	 * @return - String
	 */
	public void verifyBreadCrumbNavigationLink(String expectedBreadCrumbPages) {
		String navigation = null;
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblBreadCrumbList.get(0));
		for (int counter = 0; counter < this.lblBreadCrumbList.size(); counter++) {
			if (navigation == null)
				navigation = this.lblBreadCrumbList.get(counter).getText();
			else
				navigation = navigation + ":" + this.lblBreadCrumbList.get(counter).getText();
		}

		if (expectedBreadCrumbPages.equalsIgnoreCase(navigation))
			reporter.reportLogPass("Actual Breadcrumb page navigation list is as expected: " + navigation);
		else
			reporter.reportLogFailWithScreenshot("Actual Breadcrumb page navigation: " + navigation + " is not as expected: " + expectedBreadCrumbPages);
	}

	/**
	 * This function verifies that user is navigated to Order Details page
	 *
	 * @param - String - pagePartialURL
	 * @param - String - orderNumber
	 */
	public void verifyUserIsNavigatedToOrderDetailsPage(String pagePartialURL, String orderNumber) {
		String currentPageURL = this.getDriver().getCurrentUrl();
		String expectedURL = System.getProperty("QaUrl") + pagePartialURL + orderNumber;
		if (currentPageURL.equalsIgnoreCase(expectedURL))
			reporter.reportLogPass("Actual URL for Order Details page is same as expected: " + expectedURL);
		else
			reporter.reportLogFailWithScreenshot("Actual URL for Order Details page: " + currentPageURL + " is not as expected: " + expectedURL);
	}

	/**
	 * This function verifies My Account Order Details Page Title
	 * @param - String - userName
	 * @param - String - customerNumber
	 */
	public void verifyMyAccountOrderDetailPageTitle(String userName, String customerNumber) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderDetailsHeaderUserName);
		String orderDetailTitleUserName = this.lblOrderDetailsHeaderUserName.getText().trim();
		String orderDetailTitleCustomerNumber = this.lblOrderDetailsHeaderCustomerNumber.getText().trim();
		String pageTitle = this.convertToASCII(orderDetailTitleUserName);
		if(!pageTitle.toLowerCase().contains(userName.toLowerCase())){
			this.refresh();
			this.waitForPageToLoad();
			this.waitForCondition(Driver->{return this.lblOrderDetailsHeaderUserName.isDisplayed();},120000);
		}
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderDetailsHeaderUserName);
		orderDetailTitleUserName = this.lblOrderDetailsHeaderUserName.getText().trim();
		orderDetailTitleCustomerNumber = this.lblOrderDetailsHeaderCustomerNumber.getText().trim();
		pageTitle = this.convertToASCII(orderDetailTitleUserName);
		String expectedTitle = userName.toUpperCase() + "’S ACCOUNT";
		if (pageTitle.equalsIgnoreCase(expectedTitle))
			reporter.reportLogPass("User Name appears in title as expected");
		else
			reporter.reportLogFailWithScreenshot("User Name do not appears in title as expected: " + pageTitle);

		if (orderDetailTitleCustomerNumber.equalsIgnoreCase(customerNumber))
			reporter.reportLogPass("Customer Number appears in title as expected");
		else
			reporter.reportLogFailWithScreenshot("Customer Number do not appears in title as expected: " + customerNumber + "actual: " + orderDetailTitleCustomerNumber);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnSignOutMyAccountPage);
		if (this.btnSignOutMyAccountPage.isDisplayed() && this.btnSignOutMyAccountPage.isEnabled())
			reporter.reportLogPass("Sign Out Button on Order Details for My Account is enabled as expected");
		else
			reporter.reportLogFailWithScreenshot("Sign Out Button on Order Details for My Account is not enabled as expected");

		if (this.checkTrackOrderButtonExisting()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderDetailsHeaderTrackOrder);
			if (this.getReusableActionsInstance().isElementVisible(btnOrderDetailsHeaderTrackOrder)) {
				reporter.reportLogPass("Track order button in Header is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("Track order button in Header is not displaying correctly");
			}
		}
	}

	/**
	 * This function sorts list by name, style and then size
	 *
	 * @param sortObject
	 */
	public void sortOrderDetailListMap(List<Map<String, Object>> sortObject) {
		if (sortObject instanceof List) {
			Collections.sort(sortObject, CustomComparator.nameComparator);
			Collections.sort(sortObject, CustomComparator.styleComparator);
			Collections.sort(sortObject, CustomComparator.sizeComparator);
		}
	}

	/**
	 * This function verifies Order Details Summary Details on Order Details page from Order Confirmation page
	 *
	 * @param - Map<String,Object> - orderDetailsSummary
	 * @param - Map<String,Object> - orderConfirmationSummary
	 */
	public void verifyOrderDetailsSummary(Map<String, Object> orderDetailsSummary, Map<String, Object> orderConfirmationSummary) {
		//Verifying Order Number
		reporter.reportLog("Verifying Order Number on Order Details page");
		String orderDetailsPageData = orderDetailsSummary.get("orderNumber").toString();
		String orderConfirmationPageData = orderConfirmationSummary.get("orderNumber").toString();
		if (orderDetailsPageData.length() > orderConfirmationPageData.length()) {
			int length = orderDetailsPageData.length() - orderConfirmationPageData.length();
			for (int counter = 0; counter < length; counter++)
				orderConfirmationPageData = orderConfirmationPageData + "0";
		}
		if (orderDetailsPageData.equalsIgnoreCase(orderConfirmationPageData))
			reporter.reportLogPass("Order Number is same as expected");
		else
			reporter.reportLogFailWithScreenshot("Order Number on Details page: " + orderDetailsPageData + " is not as expected on Order Confirmation: " + orderConfirmationPageData);

		//Verifying Order Number and sub-order Number on Order Details page are same
		reporter.reportLog("Verifying Sub-Order Number on Order Details page");
		if (orderDetailsPageData.equalsIgnoreCase(orderDetailsSummary.get("subOrderNumber").toString()))
			reporter.reportLogPass("Order Number and sub order number on Order Details page are same as expected");
		else
			reporter.reportLogFailWithScreenshot("Order Number and sub order number on Order Details page are not same");

		//Verifying Order Method
		reporter.reportLog("Verifying Order Method on Order Details page");
		orderDetailsPageData = orderDetailsSummary.get("orderMethod").toString();
		orderConfirmationPageData = orderConfirmationSummary.get("orderMethod").toString();
		if (orderDetailsPageData.equalsIgnoreCase(orderConfirmationPageData))
			reporter.reportLogPass("Order Method is same as expected");
		else
			reporter.reportLogFailWithScreenshot("Order Method on Details page: " + orderDetailsPageData + " is not as expected on Order Confirmation: " + orderConfirmationPageData);

		//Verifying Order Date
		reporter.reportLog("Verifying Order Date on Order Details page");
		orderDetailsPageData = orderDetailsSummary.get("orderDate").toString();
		String orderDate = this.formatCurrentDateForProvidedFormat("MMMMM dd, yyyy").replaceFirst("\\s0", " ");
		if (orderDetailsPageData.contains(orderDate))
			reporter.reportLogPass("Order Date is same as expected");
		else
			reporter.reportLogFailWithScreenshot("Order Date on Order Details page: " + orderDetailsPageData + " is not same as expected: " + orderDate);
		//Verifying Customer Number
		reporter.reportLog("Verifying Customer Number on Order Details page");
		orderDetailsPageData = orderDetailsSummary.get("customerNumber").toString();
		orderConfirmationPageData = orderConfirmationSummary.get("customerNumber").toString();
		if (orderDetailsPageData.equalsIgnoreCase(orderConfirmationPageData))
			reporter.reportLogPass("Customer Number is same as expected");
		else
			reporter.reportLogFailWithScreenshot("Customer Number on Details page: " + orderDetailsPageData + " is not as expected on Order Confirmation: " + orderConfirmationPageData);

		//Verifying Shipping Method
		reporter.reportLog("Verifying Shipping Method on Order Details page");
		orderDetailsPageData = orderDetailsSummary.get("shippingMethod").toString();
		orderConfirmationPageData = orderConfirmationSummary.get("shippingMethod").toString();
		if (orderDetailsPageData.equalsIgnoreCase(orderConfirmationPageData))
			reporter.reportLogPass("Shipping Method is same as expected");
		else
			reporter.reportLogFailWithScreenshot("Shipping Method on Details page: " + orderDetailsPageData + " is not as expected on Order Confirmation: " + orderConfirmationPageData);

		//Verifying Payment Card
		reporter.reportLog("Verifying Payment Card on Order Details page");
		orderDetailsPageData = orderDetailsSummary.get("paymentMethod").toString();
		orderConfirmationPageData = orderConfirmationSummary.get("paymentMethodDescription").toString();
		if (orderConfirmationPageData.contains(orderDetailsPageData))
			reporter.reportLogPass("Payment Card is same as expected");
		else
			reporter.reportLogFailWithScreenshot("Payment Card on Details page: " + orderDetailsPageData + " is not as expected on Order Confirmation: " + orderConfirmationPageData);

		//Verifying shipping details
		reporter.reportLog("Verifying Shipping Address on Order Details page");
		this.verifyAddressDetails(orderDetailsSummary, orderConfirmationSummary, "Shipping");

		//Verifying billing details
		reporter.reportLog("Verifying Billing Address on Order Details page");
		this.verifyAddressDetails(orderDetailsSummary, orderConfirmationSummary, "Billing");
	}

	/**
	 * This function verifies order items on Order Details page from Order Confirmation page
	 *
	 * @param - List<Map<String,Object>> - orderItemList
	 * @param - List<Map<String,Object>> - orderDetailsItems
	 */
	public void verifyOrderDetailsItems(List<Map<String, Object>> orderItemList, List<Map<String, Object>> orderDetailsItems) {
		if (orderItemList.size() > 0 && orderDetailsItems.size() > 0) {
			for (int counter = 0; counter < orderItemList.size(); counter++) {
				reporter.reportLog("Verifying item on Order Details: " + Integer.valueOf(counter + 1));
				//Verifying product Name
				reporter.reportLog("Verifying product name on Order Details page");
				if (orderItemList.get(counter).get("productName").toString().equalsIgnoreCase(orderDetailsItems.get(counter).get("productName").toString()))
					reporter.reportLogPass("Product name of item is as expected: " + orderDetailsItems.get(counter).get("productName").toString());
				else
					reporter.reportLogFailWithScreenshot("Product name of item on order details: " + orderDetailsItems.get(counter).get("productName").toString() + " is not as expected: " + orderItemList.get(counter).get("productName").toString());

				//Verifying product Size
				reporter.reportLog("Verifying product size on Order Details page");
				if (orderDetailsItems.get(counter).get("productSize") != null) {
					if (orderItemList.get(counter).get("productSize").toString().equalsIgnoreCase(orderDetailsItems.get(counter).get("productSize").toString()))
						reporter.reportLogPass("Product size of item is as expected: " + orderDetailsItems.get(counter).get("productSize").toString());
					else
						reporter.reportLogFailWithScreenshot("Product size of item on order details: " + orderDetailsItems.get(counter).get("productSize").toString() + " is not as expected: " + orderItemList.get(counter).get("productSize").toString());
				} else
					reporter.reportLogPass("Product Size is not present for item");

				//Verifying product Style
				reporter.reportLog("Verifying product style on Order Details page");
				if (orderDetailsItems.get(counter).get("productStyle") != null) {
					if (orderItemList.get(counter).get("productStyle").toString().equalsIgnoreCase(orderDetailsItems.get(counter).get("productStyle").toString()))
						reporter.reportLogPass("Product style of item is as expected: " + orderDetailsItems.get(counter).get("productStyle").toString());
					else
						reporter.reportLogFailWithScreenshot("Product style of item on order details: " + orderDetailsItems.get(counter).get("productStyle").toString() + " is not as expected: " + orderItemList.get(counter).get("productStyle").toString());
				} else
					reporter.reportLogPass("Product style is not present for item");

				//Verifying product Number
				reporter.reportLog("Verifying product number on Order Details page");
				if (orderItemList.get(counter).get("productNumber").toString().equalsIgnoreCase(orderDetailsItems.get(counter).get("productNumber").toString()))
					reporter.reportLogPass("Product Number of item is as expected: " + orderDetailsItems.get(counter).get("productNumber").toString());
				else
					reporter.reportLogFailWithScreenshot("Product Number of item on order details: " + orderDetailsItems.get(counter).get("productNumber").toString() + " is not as expected: " + orderItemList.get(counter).get("productNumber").toString());

				//Verifying product Price
				reporter.reportLog("Verifying product price on Order Details page");
				if (orderItemList.get(counter).get("productNowPrice").toString().equalsIgnoreCase(orderDetailsItems.get(counter).get("productNowPrice").toString()))
					reporter.reportLogPass("Product Price of item is as expected: " + orderDetailsItems.get(counter).get("productNowPrice").toString());
				else
					reporter.reportLogFailWithScreenshot("Product Price of item on order details: " + orderDetailsItems.get(counter).get("productNowPrice").toString() + " is not as expected: " + orderItemList.get(counter).get("productNowPrice").toString());

				//Verifying product Quantity
				reporter.reportLog("Verifying product quantity on Order Details page");
				if (orderItemList.get(counter).get("productQuantity").toString().equalsIgnoreCase(orderDetailsItems.get(counter).get("productQuantity").toString()))
					reporter.reportLogPass("Product Quantity of item is as expected: " + orderDetailsItems.get(counter).get("productQuantity").toString());
				else
					reporter.reportLogFailWithScreenshot("Product Quantity of item on order details: " + orderDetailsItems.get(counter).get("productQuantity").toString() + " is not as expected: " + orderItemList.get(counter).get("productQuantity").toString());
			}
		}
	}

	/**
	 * To verify Account Summary Pane lList
	 */
	public void verifyAccountSummaryPanelList() {
		String lsText;
		if (this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"), System.getProperty("chromeMobileDevice"))) {
			for (WebElement item : lstAccountSummaryPanelList) {
				if (!this.checkCollapseStatusForAccountSummaryPanel(item)) {
					WebElement subItem = item.findElement(bySubHeader);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
					subItem.click();
					this.applyStaticWait(2 * this.getStaticWaitForApplication());
				}
			}
		}

		WebElement item, subItemHeader, subItemContent;
		int loopSize = lstAccountSummaryPanelList.size();
		for (int i = 0; i < loopSize; i++) {
			reporter.reportLog("Verify " + i + " Account Summary Pane header");
			item = lstAccountSummaryPanelList.get(i);
			subItemHeader = item.findElement(bySubHeader);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItemHeader);
			lsText = subItemHeader.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The header of '" + lsText + "' is displaying correctly");
			} else {
				reporter.reportLogFail("The header is not displaying correctly");
			}

			List<WebElement> lstSubItem = item.findElements(bySubList);
			int loopSizeForSubItemList = lstSubItem.size();
			for (int j = 0; j < loopSizeForSubItemList; j++) {
				reporter.reportLog("Verify " + j + " subItem in Account Summary Pane list");
				subItemContent = lstSubItem.get(j);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItemContent);
				lsText = subItemHeader.getText();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The content of '" + lsText + "' is displaying correctly");
				} else {
					reporter.reportLogFail("The content is not displaying correctly");
				}
			}
		}
	}

	/**
	 * This function verifies Order Summary Price data from Order Confirmation Page
	 *
	 * @param - Map<String,Object> - orderDetailsPriceSummary
	 * @param - Map<String,Object> - orderConfirmationPriceSummary
	 */
	public void verifyOrderDetailsOrderSummary(Map<String, Object> orderDetailsPriceSummary, Map<String, Object> orderConfirmationPriceSummary) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstOrderSummaryDetails.get(0));
		//Verify Sub Total
		reporter.reportLog("Verification of order sub total");
		Map<String, String> orderDetailPageDataMap = (Map<String, String>) orderDetailsPriceSummary.get("orderSummary");
		String orderDetailPageData = orderDetailPageDataMap.get("Subtotal");
		String orderConfirmationPageData = orderConfirmationPriceSummary.get("subTotal").toString();
		if (orderDetailPageData.equalsIgnoreCase(orderConfirmationPageData))
			reporter.reportLogPass("Order Details Price is same as expected: " + orderDetailPageData);
		else
			reporter.reportLogFailWithScreenshot("Order Details Price: " + orderDetailPageData + " is not as on order confirmation page: " + orderConfirmationPageData);

		//Verify Shipping and Handling
		reporter.reportLog("Verification of Shipping and Handling Data");
		orderDetailPageData = orderDetailPageDataMap.get("Shipping & Handling");
		orderConfirmationPageData = orderConfirmationPriceSummary.get("nowPrice").toString();
		if (orderDetailPageData.equalsIgnoreCase(orderConfirmationPageData))
			reporter.reportLogPass("Order Details Shipping and Handling price is same as expected: " + orderDetailPageData);
		else
			reporter.reportLogFailWithScreenshot("Order Details Shipping and Handling price: " + orderDetailPageData + " is not as on order confirmation page: " + orderConfirmationPageData);

		//Verify Taxes
		reporter.reportLog("Verification of Taxes");
		orderDetailPageData = orderDetailPageDataMap.get("Taxes");
		orderConfirmationPageData = orderConfirmationPriceSummary.get("tax").toString();
		if (orderDetailPageData.equalsIgnoreCase(orderConfirmationPageData))
			reporter.reportLogPass("Order Details Taxes is same as expected: " + orderDetailPageData);
		else
			reporter.reportLogFailWithScreenshot("Order Details Taxes: " + orderDetailPageData + " is not as on order confirmation page: " + orderConfirmationPageData);

		//Verify Order Total
		reporter.reportLog("Verification of Order Total");
		orderDetailPageData = orderDetailPageDataMap.get("Order Total");
		orderConfirmationPageData = orderConfirmationPriceSummary.get("totalPrice").toString();
		if (orderDetailPageData.equalsIgnoreCase(orderConfirmationPageData))
			reporter.reportLogPass("Order Details Total Price is same as expected: " + orderDetailPageData);
		else
			reporter.reportLogFailWithScreenshot("Order Details Total Price: " + orderDetailPageData + " is not as on order confirmation page: " + orderConfirmationPageData);
	}

	/**
	 * This function verifies billing or shipping address on Order Details with Order Confirmation page
	 *
	 * @param - Map<String,Object> - orderDetailsAddress
	 * @param - Map<String,Object> - orderConfirmationAddress
	 * @param - String - addressType
	 */
	public void verifyAddressDetails(Map<String, Object> orderDetailsAddress, Map<String, Object> orderConfirmationAddress, String addressType) {
		List<String> orderConfirmationShippingAddress = null;
		String orderDetailShippingAddress = orderDetailsAddress.get("shippingAddress").toString().replace(",", "").replace("-", " ").trim();
		orderConfirmationShippingAddress = Collections.singletonList(((ArrayList) orderConfirmationAddress.get("shippingAddress"))).get(0);
		if (addressType.equalsIgnoreCase("Shipping")) {
			reporter.reportLog("Verifying Shipping Address");
			//Verifying shipping details
			if (orderConfirmationAddress.containsKey("shippingAddress")) {
				Boolean flag = this.verifyAddress(orderConfirmationShippingAddress, orderDetailShippingAddress, "Shipping");
				if (flag)
					reporter.reportLogPass("Shipping Address on Order Details page is same as on Order Confirmation page");
				else
					reporter.reportLogFailWithScreenshot("Shipping Address on Order Details page: " + orderDetailShippingAddress + " is not same as on Order Confirmation page: " + orderConfirmationShippingAddress);
			} else
				reporter.reportLogFailWithScreenshot("Shipping Address is not present in orderConfirmationSummary object");
		} else if (addressType.equalsIgnoreCase("Billing")) {
			reporter.reportLog("Verifying Billing Address");
			//Verifying billing details
			if (orderConfirmationAddress.containsKey("billingAddress")) {
				List<String> orderConfirmationBillingAddress = Collections.singletonList(((ArrayList) orderConfirmationAddress.get("billingAddress"))).get(0);
				String orderDetailBillingAddress = orderDetailsAddress.get("billingAddress").toString().replace(",", "").replace("-", " ").trim();
				;
				if (orderConfirmationBillingAddress.get(0).contains("Same as shipping address")) {
					Boolean flag = this.verifyAddress(orderConfirmationShippingAddress, orderDetailBillingAddress, "Billing");
					if (flag)
						reporter.reportLogPass("Billing Address on Order Details page is same as on Order Confirmation page");
					else
						reporter.reportLogFailWithScreenshot("Billing Address on Order Details page: " + orderDetailBillingAddress + " is not same as on Order Confirmation page: " + orderConfirmationBillingAddress);
				} else {
					Boolean flag = this.verifyAddress(orderConfirmationShippingAddress, orderDetailShippingAddress, "Billing");
					if (flag)
						reporter.reportLogPass("Billing Address on Order Details page is same as on Order Confirmation page");
					else
						reporter.reportLogFailWithScreenshot("Billing Address on Order Details page: " + orderDetailBillingAddress + " is not same as on Order Confirmation page: " + orderConfirmationBillingAddress);
				}
			} else
				reporter.reportLogFailWithScreenshot("Billing Address is not present in orderConfirmationSummary object");
		}
	}

	/**
	 * This function verifies address
	 *
	 * @param - List<String> - orderConfirmationShippingAddress
	 * @param - String - orderDetailShippingAddress
	 * @return - Boolean
	 */
	public Boolean verifyAddress(List<String> orderConfirmationShippingAddress, String orderDetailShippingAddress, String addressType) {
		String address = null, orderDetailAddress;
		Boolean flag = false;
		int flagCounter = 0;
		for (int counter = 1; counter < orderConfirmationShippingAddress.size() - 1; counter++) {
			if (this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"), System.getProperty("chromeMobileDevice")) && addressType.equalsIgnoreCase("Shipping"))
				address = orderConfirmationShippingAddress.get(counter).replace(",", "").replace("-", " ").replace(" ", "").trim();
			else
				address = orderConfirmationShippingAddress.get(counter - 1).replace(",", "").replace("-", " ").replace(" ", "").trim();
			orderDetailAddress = orderDetailShippingAddress.replace(" ", "").trim();
			if (orderDetailAddress.toLowerCase().contains(address.toLowerCase())) {
				if (flagCounter == 0 && flag == false) {
					flag = true;
				}
			} else {
				flag = false;
				flagCounter++;
				reporter.reportLogFailWithScreenshot("Address: " + orderConfirmationShippingAddress.get(counter) + " is not present on Order Details page as expected");
			}
		}
		return flag;
	}

	/**
	 * This function verifies Track Order and Edit Order Button on Order Details page
	 */
	public void verifyOrderDetailsTrackOrderAndEditButton() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnOrderDetailsHeaderTrackOrder);
		if (this.btnOrderDetailsHeaderTrackOrder.isEnabled() && this.btnOrderDetailsHeaderTrackOrder.isDisplayed())
			reporter.reportLogPass("Track Order Button on Order Details page is displayed");
		else
			reporter.reportLogFailWithScreenshot("Track Order Button on Order Details page is not displayed");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnOrderDetailsHeaderEditOrder);
		if (this.btnOrderDetailsHeaderEditOrder.isDisplayed())
			reporter.reportLogPass("Edit Order Button on Order Details page is displayed");
		else
			reporter.reportLogFailWithScreenshot("Edit Order Button on Order Details page is not displayed");
	}

	/**
	 * To goto OrderModification Page
	 *
	 * @return - boolean
	 */
	public boolean goToOrderModificationPage() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderDetailsHeaderEditOrder);
		String lsClass = btnOrderDetailsHeaderEditOrder.getAttribute("class");
		if (!lsClass.contains("disabled")) {
			reporter.reportLogPass("Edit order button is enabled");
		} else {
			reporter.reportLogFail("Edit order button is disabled");
			return false;
		}
		btnOrderDetailsHeaderEditOrder.click();
		return this.waitForCondition(Driver -> {
			return (new OrderModificationPage(this.getDriver())).lblModifyOrderHeaderTitle.isDisplayed();
		}, 120000);
	}

	/**
	 * This function fetches if any order is there that is editable and required info for that order
	 * @param - String - customerEDP
	 * @param -String - access_token
	 * @throws - IOException
	 */
	public GetGivenOrderResponse getExistingOrderInEditableMode(int noOfInstallments, String customerEDP, String access_token) throws IOException {
		OrderAPI orderAPI = new OrderAPI();
		Response response = orderAPI.getOrderList(customerEDP,access_token,true);
		if(response.getStatusCode() == 200){
			String orderNumber = null;
			OrderListResponse orderListResponse = JsonParser.getResponseObject(response.getBody().asString(), new TypeReference<OrderListResponse>() {});
			List<OrderSummary> orderSummaries = orderListResponse.getOrderSummary();
			if(orderSummaries.size()>0){
				for(OrderSummary orderSummary:orderSummaries){
					orderNumber = orderSummary.getOrderNo();
					Response orderInfoResponse = orderAPI.getGivenOrder(customerEDP,access_token,orderNumber);
					if(orderInfoResponse.getStatusCode()==200){
						GetGivenOrderResponse getGivenOrderResponse = JsonParser.getResponseObject(orderInfoResponse.getBody().asString(), new TypeReference<GetGivenOrderResponse>() {});
						if(getGivenOrderResponse.getNoOfEasyPays().equals(String.valueOf(noOfInstallments)) && getGivenOrderResponse.getOrderSummary().isEditable()==true){
							return getGivenOrderResponse;
						}
					}else
						reporter.reportLogFail("Response is not returned for order number: "+orderNumber+" from api with status code as: "+orderInfoResponse.getStatusCode());
				}
			}
		}else
			reporter.reportLogFail("No Order Details are fetched by api for customer: "+customerEDP+" with status code as: "+response.getStatusCode());

		return null;
	}

	/**
	 * @param - int - customerEDP
	 * @param - String - access token
	 * @param - List<Map<String,Object> - itemsToBeAdded
	 * @param - int - easyPayInstallment
	 * @param - boolean - bCheckExisting
	 * @return - PlaceOrderResponse
	 */
	public PlaceOrderResponse placeOrderForUser(int customerEDP, String accessToken, List<Map<String, String>> itemsToBeAdded, int easyPayInstallment, String noOfItemsToBeAdded, boolean bCheckExisting, int itemToBeAdded) throws IOException {
		List<Map<String, Object>> shoppingCartObject = (new ShoppingCartPage(this.getDriver())).verifyCartExistsForUser(customerEDP, accessToken, itemsToBeAdded, noOfItemsToBeAdded, bCheckExisting, itemToBeAdded);
		Response response;
		PlaceOrderResponse placeOrderResponse;

		if (easyPayInstallment == 0) {
			response = new OrderAPI().placeOrder(shoppingCartObject.get(0).get("cartGuid").toString(), String.valueOf(customerEDP), accessToken, null);
			placeOrderResponse = JsonParser.getResponseObject(response.asString(), new TypeReference<PlaceOrderResponse>() {
			});
			return placeOrderResponse;
		} else {
			//Add easy pay installment for user
			CartResponse cartResponse = new CartAPI().putInstallmentNumberInCartForUser(shoppingCartObject.get(0).get("cartGuid").toString(), easyPayInstallment, accessToken);
			if (cartResponse.getOrderSummary().getEasyPay().getNoOfInstallments() == easyPayInstallment && shoppingCartObject.size() > 0) {
				response = new OrderAPI().placeOrder(shoppingCartObject.get(0).get("cartGuid").toString(), String.valueOf(customerEDP), accessToken, null);
				placeOrderResponse = JsonParser.getResponseObject(response.asString(), new TypeReference<PlaceOrderResponse>() {
				});
				return placeOrderResponse;
			} else
				return null;
		}
	}

	/**
	 * This function selects specific order and clicks on View Details for that order
	 *
	 * @param - String - orderNumber
	 * @return - Boolean
	 */
	public boolean selectOrderNumberFromPlacedOrders(String orderNumber) {
		int totalOrderList = this.lstOrderItemList.size();
		boolean flag = false;
		if (totalOrderList > 0) {
			WebElement orderNumberElement;
			String applicationOrderNumber;
			for (WebElement order : lstOrderItemList) {
				orderNumberElement = order.findElement(this.byOrderNo);
				applicationOrderNumber = this.getElementInnerText(orderNumberElement);
				if (applicationOrderNumber.equalsIgnoreCase(orderNumber)) {
					WebElement viewDetailsButton = order.findElement(this.byOrderViewDetails);
					this.clickWebElementUsingJS(viewDetailsButton);
					//Wait for page to load
					this.waitForPageToLoad();
					this.waitForCondition(Driver -> {
						return this.btnOrderDetailsHeaderEditOrder.isDisplayed() &&
								this.btnOrderDetailsHeaderEditOrder.isEnabled();
					}, 20000);
					flag = true;
				}
				if (flag)
					break;
			}
			if (flag)
				return true;
			else
				return false;
		} else
			return false;
	}

	/**
	 * This function navigates to placed order and Edit that order
	 * @param - String - orderNumber
	 * @param - String - myAccountOrderStatusURL
	 */
	public String editPlacedOrderForUser(String orderNumber, String myAccountOrderStatusURL) {
		//https://qa-tsc.tsc.ca/pages/myaccount/orderstatus?orderNo=Z405840120000
		int orderNumberLength = orderNumber.length();
		if (orderNumberLength < 12) {
			for (int counter = orderNumberLength; counter < 12; counter++) {
				orderNumber = orderNumber + "0";
			}
		}
		String orderURL = System.getProperty("QaUrl") + myAccountOrderStatusURL + "?orderNo=" + orderNumber;
		this.getDriver().navigate().to(orderURL);
		this.waitForPageToLoad();
		this.waitForCondition(Driver -> {
			return this.btnOrderDetailsHeaderEditOrder.isDisplayed();
		}, 20000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnOrderDetailsHeaderEditOrder);
		//******************************************//
		//Need to remove this condition as we are enabling Edit Button for test if not enabled
		if (!this.btnOrderDetailsHeaderEditOrder.isEnabled()) {
			this.setElementEnabled(btnOrderDetailsHeaderEditOrder);
		}
		//******************************************//
		this.waitForCondition(Driver -> {
			return this.btnOrderDetailsHeaderEditOrder.isEnabled();
		}, 120000);
		//Click on Edit Order Button
		this.clickWebElementUsingJS(this.btnOrderDetailsHeaderEditOrder);

		//Need to update below code once new xpath for shopping cart are added by removing SpinningMehtod below
		try {
			new RegularCheckoutPage(this.getDriver()).waitForPageLoadingSpinningStatusCompleted();
		} catch (Exception e) {
			this.applyStaticWait(10 * this.getStaticWaitForApplication());
		}

		//Verifying that user is navigated to shopping cart page
		String currentPageURL = this.URL();
		if (currentPageURL.contains("shoppingbag"))
			reporter.reportLogPass("User is navigated to Shopping Cart Page as expected with url as: " + currentPageURL);
		else
			reporter.reportLogFailWithScreenshot("User is not navigated to Shopping Cart Page: " + currentPageURL);

		return orderNumber;
	}

	/**
	 * To go To Order Tracking Page
	 *
	 * @return - boolean
	 */
	public boolean goToOrderTrackingPage() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnOrderDetailsHeaderTrackOrder);
		this.btnOrderDetailsHeaderTrackOrder.click();
		return this.waitForCondition(Driver -> {
			return (new OrderTrackingPage(this.getDriver())).lblTrackOrderTitle.isDisplayed();
		}, 120000);
	}

	/**
	 * To goTo Order Details Page By Given Order Number Searching
	 *
	 * @param - String - orderNumber
	 * @param - String - lsOrderDetailsURL - the order details url from yaml file
	 */
	public void goToOrderDetailsPageByGivenOrderNumberSearching(String orderNumber, String lsOrderDetailsURL) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputAccountOrderSearch);
		this.inputAccountOrderSearch.clear();
		this.inputAccountOrderSearch.sendKeys(orderNumber);
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAccountOrderSearch);
		this.btnAccountOrderSearch.click();

		this.waitForCondition(Driver -> {
			return this.lblOrderDetailsSectionTitle.isDisplayed();
		}, 50000);

		lsOrderDetailsURL = lsOrderDetailsURL.replace("{OrderNO}", orderNumber);
		String lsExpectedURL = this.getBaseURL() + lsOrderDetailsURL;
		if (this.URL().equalsIgnoreCase(lsExpectedURL)) {
			reporter.reportLogPass("The page is navigated to order details page correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The page is not navigated to order details page correctly");
		}
	}

	/**
	 * To check CVV Section Existing
	 * @return - boolean
	 */
	public boolean checkCVVSectionExisting(){
		return this.checkChildElementExistingByAttribute(cntExpirationDateContainerForNewCreditCard,"class","cvvFormGroup");
	}

	/**
	 * To check CVV Tooltip Displaying
	 * @return - boolean
	 */
	public boolean checkCVVTooltipDisplaying(){
		return this.checkChildElementExistingByAttribute(cntCVVContainerForNewCreditCard,"class","popover");
	}

	/**
	 * To wait For Spinning Status Completed For Save Action
	 * @param - WebElement - save Button
	 * @return - boolean
	 */
	public boolean waitForSpinningStatusCompletedForSaveAction(WebElement saveButton){
		return this.waitForCondition(Driver->{return this.getChildElementCount(saveButton)==1;},120000);
	}
}

