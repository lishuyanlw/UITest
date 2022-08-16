package com.tsc.pages;

import com.tsc.api.util.DataConverter;
import com.tsc.pages.base.BasePage;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class RegularCheckoutPage extends BasePage {

	public RegularCheckoutPage(WebDriver driver) {
		super(driver);
	}

	//For header
	@FindBy(xpath = "//header//div[contains(@class,'header__logo')]//*[contains(@class,'svgTscLogoLg')]")
	public WebElement iconTSCHeaderLogo;

	@FindBy(xpath = "//header//div[contains(@class,'header__logo')]//*[contains(@class,'header__logo-text')]")
	public WebElement lblCheckout;

	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__address']//div[@class='progressbar__title']")
	public WebElement lblAddressProgressBar;

	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__address']//div[@class='progressbar__title']/following-sibling::*")
	public WebElement iconAddressProgressBar;

	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__payment']//div[@class='progressbar__title']")
	public WebElement lblPaymentProgressBar;

	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__payment']//div[@class='progressbar__title']/following-sibling::*")
	public WebElement iconPaymentProgressBar;

	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__review']//div[@class='progressbar__title']")
	public WebElement lblReviewOrderProgressBar;

	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__review']//div[@class='progressbar__title']/following-sibling::*")
	public WebElement iconReviewOrderProgressBar;

	//For checkout product list,shipping and payment
	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'alert')]")
	public WebElement lblAlertMessage;

	@FindBy(xpath = "//article[@class='leftSide']//button[@data-collapse='collapse__productlist']")
	public WebElement btnCollapseProductList;

	@FindBy(xpath = "//article[@class='leftSide']")
	public WebElement cntProductOrderSection;

	@FindBy(xpath = "//article[@class='leftSide']//div[@id='collapse__productlist']")
	public WebElement cntProductListContainer;

	@FindBy(xpath = "//article[@class='leftSide']//div[@id='collapse__productlist']//div[@class='productlist']")
	public List<WebElement> lstProductList;

	public By byProductBadgeContainer=By.xpath(".//div[@class='productlist__row']//div[@class='productlist__left']");
	public By byProductBadge=By.xpath(".//div[@class='productlist__row']//div[@class='productlist__left']//img[@class='productlist__badge']");
	public By byProductImage=By.xpath(".//div[@class='productlist__row']//div[@class='productlist__left']//img[not(@class='productlist__badge')]");
	public By byProductItemDesc=By.xpath(".//div[@class='productlist__row']//div[@class='productlist__right']//div[@class='productlist__description']");
	public By byProductNumber=By.xpath(".//div[@class='productlist__row']//div[@class='productlist__right']//div[@class='productlist__itemnumber']");
	public By byProductSelectQuantity=By.xpath(".//div[@class='productlist__pricerow']//div[@class='productlist__left--qty']");
	public By byProductInventoryContainer=By.xpath(".//div[@class='productlist__pricerow']//div[@class='productlist__right']");
	public By byProductInventory=By.xpath(".//div[@class='productlist__pricerow']//div[@class='productlist__right']//span[@class='productlist__right--inventory']");
	public By byProductNowPrice=By.xpath(".//div[@class='productlist__pricerow']//div[@class='productlist__right']//span[@class='productlist__right--price']");
	public By byProductFreeShipping=By.xpath(".//span[@class='productlist__right--freeship']");
	public By byProductShippingDate=By.xpath(".//div[@class='estimateDateCheckout__lineItem']");

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'shippingAddressWrap')]//div[@class='shippingaddress__label']")
	public WebElement lblShippingAddressTitle;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'shippingAddressWrap')]//div[@class='shippingaddress__description']")
	public WebElement lblShippingAddress;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'shippingAddressWrap')]//button[@class='button__change']")
	public WebElement btnShippingAddressAddOrChange;

	///////////////////////////////////////////////////
	//For popup window by clicking btnShippingAddressAddOrChange button
	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='modal__header']//h3")
	public WebElement lblAddOrChangeShippingAddressDialogTitle;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//button[@class='modal__button-close']")
	public WebElement btnAddOrChangeShippingAddressDialogCloseButton;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='card__wrap']")
	public List<WebElement> lstAddOrChangeShippingAddressDialogCardWrapSectionIncludingAddNewAddress;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='card__wrap'][not(div[@class='card__box--add'])]")
	public List<WebElement> lstAddOrChangeShippingAddressDialogAvailableShippingAddress;

	public By byAddOrChangeShippingAddressDialogSelectedStatus=By.xpath("./div");
	public By byAddOrChangeShippingAddressDialogSelectLabel=By.xpath("./div/label");
	public By byAddOrChangeShippingAddressDialogEditButton=By.xpath(".//button[normalize-space(.)='Edit']");
	public By byAddOrChangeShippingAddressDialogCardDetails=By.xpath(".//div[@class='card__address']");

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//button[@class='card__button--add']")
	public WebElement btnAddOrChangeShippingAddressDialogAddNewAddressButton;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//button[contains(@class,'modal__button--save')]")
	public WebElement btnAddOrChangeShippingAddressDialogSaveButton;

	//For the popup window after clicking Add/Edit address button
	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//div[@class='modal__header']//h3")
	public WebElement lblAddOrEditAddressDialogTitle;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//button[@class='modal__button-close']")
	public WebElement btnAddOrEditAddressDialogCloseButton;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//span[@class='form__required']")
	public WebElement lblAddOrEditAddressDialogFormRequiredMessage;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//label[@id='FirstNamelbl']")
	public WebElement lblAddOrEditAddressDialogFirstNameLabel;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//input[@id='FirstName']")
	public WebElement inputAddOrEditAddressDialogFirstName;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//label[@id='LastNamelbl']")
	public WebElement lblAddOrEditAddressDialogLastNameLabel;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//input[@id='LastName']")
	public WebElement inputAddOrEditAddressDialogLastName;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//label[@id='DayPhonelbl']")
	public WebElement lblAddOrEditAddressDialogPhoneNumberLabel;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//input[@id='DayPhone']")
	public WebElement inputAddOrEditAddressDialogPhoneNumber;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//label[@id='addresslbl']")
	public WebElement lblAddOrEditAddressDialogAddressLabel;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//input[@id='address']")
	public WebElement inputAddOrEditAddressDialogAddress;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//div[contains(@class,'react-autosuggest__suggestions-container')]")
	public WebElement cntAddOrEditAddressDialogAddressDropDownList;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//ul//li")
	public List<WebElement> lstAddOrEditAddressDialogAddressDropDownList;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//label[@id='AddressRef1lbl']")
	public WebElement lblAddOrEditAddressDialogAddressLine2Label;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//input[@id='AddressRef1']")
	public WebElement inputAddOrEditAddressDialogAddressLine2;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//div[@class='hint']")
	public WebElement lblAddOrEditAddressDialogAddressLine2HintMessage;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//label[@id='Citylbl']")
	public WebElement lblAddOrEditAddressDialogCityLabel;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//input[@id='City']")
	public WebElement inputAddOrEditAddressDialogCity;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//label[@for='State']")
	public WebElement lblAddOrEditAddressDialogProvinceLabel;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//select[@id='State']")
	public WebElement selectAddOrEditAddressDialogProvince;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//label[@id='ZipCodelbl']")
	public WebElement lblAddOrEditAddressDialogPostalCodeLabel;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//input[@id='ZipCode']")
	public WebElement inputAddOrEditAddressDialogPostalCode;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//button[contains(@class,'modal__button--save')]")
	public WebElement btnAddOrEditAddressDialogSaveButton;

	///////////////////////////////////////////////////

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'shippingMethodWrap')]//div[@class='shippingmethod__label']")
	public WebElement lblShippingMethodTitle;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'shippingMethodWrap')]//div[@class='shippingmethod__description']")
	public WebElement lblShippingMethod;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//div[@class='paymentmethod__label']")
	public WebElement lblShippingPaymentMethodTitle;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//div[@class='paymentmethod__label']/following-sibling::div")
	public WebElement cntPaymentMethodContainer;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//div[@class='paymentmethod__error-wrap']")
	public WebElement lblPaymentMethodErrorMessage;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//div[@class='paymentmethod__description']")
	public WebElement lblPaymentMethod;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//button[@class='button__change']")
	public WebElement btnAddOrChangePaymentMethod;

	////////////////////////////////////////////////////////////
	//For popup dialog to add or change payment method by clicking btnAddOrChangePaymentMethod button
	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='modal__header']//h3")
	public WebElement lblAddOrChangePaymentMethodDialogTitle;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='modal__header']//button[@class='modal__button-close']")
	public WebElement btnAddOrChangePaymentMethodDialogCloseButton;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='card__wrap']")
	public List<WebElement> lstAddOrChangePaymentMethodDialogCardWrapSectionIncludingUsingANewCard;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='card__wrap'][not(div[@class='card__box--add'])]")
	public List<WebElement> lstAddOrChangePaymentMethodDialogAvailableCardContainer;

	public By byAddOrChangePaymentMethodDialogSelectedStatus=By.xpath("./div");
	public By byAddOrChangePaymentMethodDialogSelectLabel=By.xpath("./div/label");
	public By byAddOrChangePaymentMethodDialogEditButton=By.xpath(".//div[@class='card__edit-button-container']//button[normalize-space(.)='Edit']");
	public By byAddOrChangePaymentMethodDialogRemoveButton=By.xpath(".//div[@class='card__edit-button-container']//button[normalize-space(.)='Remove']");
	public By byAddOrChangePaymentMethodDialogCardLogo=By.xpath(".//div[@class='card__payment']//div[@class='card__logo']//*[contains(@class,'tagCCImage')]");
	public By byAddOrChangePaymentMethodDialogCardDetails=By.xpath(".//div[@class='card__payment']//div[@class='card__detail']");

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//button[@class='card__button--add']")
	public WebElement btnAddOrChangePaymentMethodDialogUsingANewCardButton;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[contains(@class,'card__wrap--paypal')]//label")
	public WebElement labelAddOrChangePaymentMethodDialogPaypalRadio;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//button[contains(@class,'modal__button--save')]")
	public WebElement btnAddOrChangePaymentMethodDialogSaveButton;

	//////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////
	//For the popup window by clicking using a new card button
	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='card__header']")
	public WebElement lblUsingANewCardDialogTitle;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//button[contains(@class,'modal__button-close')]")
	public WebElement btnUsingANewCardDialogCloseButton;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='creditcard__selector--cc']")
	public WebElement cntUsingANewCardDialogCreditCard;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='creditcard__selector--cc']//input")
	public WebElement inputUsingANewCardDialogCreditCardRadio;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='creditcard__selector--cc']//label")
	public WebElement labelUsingANewCardDialogCreditCardRadio;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='creditcard__selector--tsc']")
	public WebElement cntUsingANewCardDialogTSCCard;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='creditcard__selector--tsc']//input")
	public WebElement inputUsingANewCardDialogTSCCardRadio;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='creditcard__selector--tsc']//label")
	public WebElement labelUsingANewCardDialogTSCCardRadio;

	//For Credit card
	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='standardCCBlock']//h3[@class='semafone__cardnumber']")
	public WebElement lblUsingANewCardDialogCreditCardNumberTitle;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='standardCCBlock']//iframe")
	public WebElement iframeUsingANewCardDialogCreditCardNumberInput;

	//The Credit card number input field in iframeUsingANewCardDialogCardNumberInput
	@FindBy(xpath = "//input[@id='pan']")
	public WebElement inputCreditCardNumberInIframe;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='standardCCBlock']//h3[@class='semafone__expiration-title']")
	public WebElement lblUsingANewCardDialogCreditExpirationDateTitle;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='standardCCBlock']//input[@id='creditCardMonthId']")
	public WebElement inputUsingANewCardDialogCreditExpirationDateMonth;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='standardCCBlock']//input[@id='creditCardYearId']")
	public WebElement inputUsingANewCardDialogCreditExpirationDateYear;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='standardCCBlock']//span[@class='semafone__expiration-title']")
	public WebElement lblUsingANewCardDialogCreditExpirationDateSlashBetweenMonthAndYear;

	//For TSC card
	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='tscBlock']//h3[@class='semafone__cardnumber']")
	public WebElement lblUsingANewCardDialogTSCCardNumberTitle;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//div[@class='tscBlock']//input[@id='tscCC']")
	public WebElement inputUsingANewCardDialogTSCCardNumber;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card')]//button[contains(@class,'modal__button--save')]")
	public WebElement btnUsingANewCardDialogSaveButton;

	/////////////////////////////////////////////////////////


	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'billingAddressWrap')]//div[@class='billingaddress__label']")
	public WebElement lblBillingAddressTitle;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'billingAddressWrap')]//div[@class='billingaddress__description']")
	public WebElement lblBillingAddress;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'billingAddressWrap')]//button[@class='button__change']")
	public WebElement btnBillingAddressChange;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentOptionWrap')]//div[@class='paymentoption__label']")
	public WebElement lblPaymentOptionTitle;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentOptionWrap')]//div[@class='paymentoption__text']")
	public WebElement lblPaymentOptionText;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentOptionWrap')]//div[@class='paymentoption__description']//select")
	public WebElement selectPaymentOption;

	//For Order Summary section
	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//h2")
	public WebElement lblOrderSummaryTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Sub-total')]")
	public WebElement lblOrderSummarySubTotalTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Sub-total')]/following-sibling::span[@class='summary__value']")
	public WebElement lblOrderSummarySubTotal;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Shipping')]")
	public WebElement lblOrderSummaryShippingTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Shipping')]/following-sibling::span[@class='summary__value']")
	public WebElement cntOrderSummaryShippingPriceContainer;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Shipping')]/following-sibling::span[@class='summary__value']//del")
	public WebElement lblOrderSummaryShippingWasPrice;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Est Taxes')]")
	public WebElement lblOrderSummaryTaxTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Est Taxes')]/following-sibling::span[@class='summary__value']")
	public WebElement lblOrderSummaryTax;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[contains(@class,'summary__label') and contains(text(),'TOTAL PRICE')]")
	public WebElement lblOrderSummaryTotalPriceTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[contains(@class,'summary__label') and contains(text(),'TOTAL PRICE')]/following-sibling::span[contains(@class,'summary__value')]")
	public WebElement lblOrderSummaryTotalPrice;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__savingmsg']")
	public WebElement lblOrderSummarySavingPrice;

	//For Installment
	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'easypay__container')]//h3[@class='easypay__title--border']")
	public WebElement lblInstallmentTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'easypay__container')]//span[contains(.,'Number of Installments')]")
	public WebElement lblInstallmentNumberTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'easypay__container')]//span[contains(.,'Number of Installments')]/following-sibling::span")
	public WebElement lblInstallmentNumber;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'easypay__container')]//span[contains(.,'Your Total Payment Today')]")
	public WebElement lblInstallmentTodayPaymentTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'easypay__container')]//span[contains(.,'Your Total Payment Today')]/following-sibling::span")
	public WebElement lblInstallmentTodayPayment;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'easypay__container')]//span[contains(.,'Payment Amount Left After Today')]")
	public WebElement lblInstallmentLeftPaymentTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'easypay__container')]//span[contains(.,'Payment Amount Left After Today')]/following-sibling::span")
	public WebElement lblInstallmentLeftPayment;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'easypay__container')]//span[contains(.,'Future Monthly Payments')]")
	public WebElement lblInstallmentFuturePaymentTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'easypay__container')]//span[contains(.,'Future Monthly Payments')]/following-sibling::span")
	public WebElement lblInstallmentFuturePayment;

	//For promote code
	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//h3[@class='promocode__title']")
	public WebElement lblOrderSummaryPromoteCodeTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//h3[@class='promocode__title']")
	public WebElement cntOrderSummaryPromoteCodeTooltip;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//h3[@class='promocode__title']//div[*[@class='promocode__tooltip']]")
	public WebElement iconOrderSummaryPromoteCodeTooltip;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//h3[@class='promocode__title']//div[@class='promocode__tooltip--msg']")
	public WebElement lblOrderSummaryPromoteCodeTooltipMessage;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//input[@id='promo']")
	public WebElement inputOrderSummaryPromoteCode;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//button[@class='promocode__button--white button']")
	public WebElement btnOrderSummaryPromoteCodeApply;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'giftcard__container')]//h3[@class='promocode__title']")
	public WebElement lblOrderSummaryGiftCardTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'giftcard__container')]//input[@id='giftcardNumber']")
	public WebElement inputOrderSummaryGiftCardNumber;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'giftcard__container')]//label[@class='giftcard__label']")
	public WebElement lblOrderSummaryGiftCardPinTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'giftcard__container')]//input[@id='giftcardPin']")
	public WebElement inputOrderSummaryGiftCardPin;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'giftcard__container')]//button[contains(@class,'giftcard__button--white')]")
	public WebElement btnOrderSummaryGiftCardApply;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'placeorder__wrap')]//button[contains(@class,'placeorder__button--black')]")
	public WebElement btnOrderSummaryPlaceOrder;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'placeorder__wrap')]//div[contains(@class,'placeorder__reserve-msg')]")
	public WebElement lblOrderSummaryPlaceOrderMessage;

	//For footer
	@FindBy(xpath = "//footer//a[contains(@href,'aboutustandc')]")
	public WebElement lnkTermsOfUse;

	@FindBy(xpath = "//footer//a[contains(@href,'aboutusprivacy')]")
	public WebElement lnkPrivacyPolicy;


	/**
	 * To expand Product List
	 * @return - boolean
	 */
	public boolean expandProductList(){
		if(!checkProductCollapseStatus()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCollapseProductList);
			btnCollapseProductList.click();
			this.waitForCondition(Driver->{return checkProductCollapseStatus();},10000);
		}
		return true;
	}

	/**
	 * To check Product Collapse Status
	 * @return - boolean - true for collapse and false for uncollapse
	 */
	public boolean checkProductCollapseStatus(){
		String lsClass=btnCollapseProductList.getAttribute("class");
		String[] lstSplit= lsClass.split("\\s+");
		for(String lsSplit:lstSplit){
			if(lsSplit.equalsIgnoreCase("collapse")){
				return true;
			}
		}
		return false;
	}

	/**
	 * To get Order Item Count
	 * @return -int
	 */
	public int getOrderItemCount(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCollapseProductList);
		return this.getIntegerFromString(this.getElementInnerText(btnCollapseProductList));
	}

	/**
	 * To check Product List Displaying
	 * @return - boolean
	 */
	public boolean checkProductListDisplaying(){
		String lsClass=this.cntProductListContainer.getAttribute("class");
		if(lsClass.isEmpty()){
			return true;
		}
		return !lsClass.equalsIgnoreCase("hidden");
	}

	/**
	 * To check Product Badge Existing
	 * @param - WebElement - productItem - the item in product list
	 * @return - boolean
	 */
	public boolean checkProductBadgeExisting(WebElement productItem){
		WebElement badgeItem=productItem.findElement(this.byProductBadgeContainer);
		return this.checkChildElementExistingByAttribute(badgeItem,"class","productlist__badge");
	}

	/**
	 * To check Product inventory Existing
	 * @param - WebElement - productItem - the item in product list
	 * @return - boolean
	 */
	public boolean checkProductInventoryExisting(WebElement productItem){
		WebElement badgeItem=productItem.findElement(this.byProductInventoryContainer);
		return this.checkChildElementExistingByAttribute(badgeItem,"class","productlist__right--inventory");
	}

	/**
	 * To check Product Free shipping Existing
	 * @param - WebElement - productItem - the item in product list
	 * @return - boolean
	 */
	public boolean checkProductFreeShippingExisting(WebElement productItem){
		return this.checkChildElementExistingByAttribute(productItem,"class","productlist__right--freeship");
	}

	/**
	 * To check Product GetItBy shipping date Existing
	 * @return - boolean
	 */
	public boolean checkProductShippingDateExisting(){
		return this.checkChildElementExistingByAttribute(this.cntProductOrderSection,"class","reviewWrap");
	}

	/**
	 * To check Available shipping address Existing
	 * @return - boolean
	 */
	public boolean checkAvailableShippingAddressExisting(){
		return lstAddOrChangeShippingAddressDialogCardWrapSectionIncludingAddNewAddress.size()>1;
	}

	/**
	 * To check If the given address is TSC Card
	 * @param - WebElement - cardItem - Given address item
	 * @return - boolean
	 */
	public boolean checkIfAddressSelected(WebElement addressItem){
		WebElement statusItem=addressItem.findElement(this.byAddOrChangeShippingAddressDialogSelectedStatus);
		return statusItem.getAttribute("class").equalsIgnoreCase("card__box--selected");
	}

	/**
	 * To check Payment Method Existing
	 * @return - boolean
	 */
	public boolean checkPaymentMethodExisting(){
		return this.checkChildElementExistingByAttribute(cntPaymentMethodContainer,"class","paymentmethod__description");
	}

	/**
	 * To check Payment Method Error Message Existing
	 * @return - boolean
	 */
	public boolean checkPaymentMethodErrorMessageExisting(){
		return this.checkChildElementExistingByAttribute(cntPaymentMethodContainer,"class","paymentmethod__error-wrap");
	}

	/**
	 * To check Available Payment Method Existing
	 * @return - boolean
	 */
	public boolean checkAvailablePaymentMethodExisting(){
		return lstAddOrChangePaymentMethodDialogCardWrapSectionIncludingUsingANewCard.size()>1;
	}

	/**
	 * To check If the given card is selected
	 * @param - WebElement - cardItem - Given card item
	 * @return - boolean
	 */
	public boolean checkIfCardSelected(WebElement cardItem){
		WebElement statusItem=cardItem.findElement(this.byAddOrChangePaymentMethodDialogSelectedStatus);
		return statusItem.getAttribute("class").equalsIgnoreCase("card__box--selected");
	}

	/**
	 * To check If the given card is TSC Card
	 * @param - WebElement - cardItem - Given card item
	 * @return - boolean
	 */
	public boolean checkIfTSCCard(WebElement cardItem){
		WebElement logoItem=cardItem.findElement(this.byAddOrChangePaymentMethodDialogCardLogo);
		return logoItem.getAttribute("class").contains("TSC");
	}

	/**
	 * To check WasPrice Existing in OrderSummary
	 * @return - boolean
	 */
	public boolean checkOrderSummaryWasPriceExisting(){
		return this.checkChildElementExistingByAttribute(cntOrderSummaryShippingPriceContainer,"class","del");
	}

	/**
	 * To check Saving price Existing in OrderSummary
	 * @return - boolean
	 */
	public boolean checkOrderSummarySavingPriceExisting(){
		return this.checkChildElementExistingByAttribute(cntOrderSummaryShippingPriceContainer,"class","del");
	}

	/**
	 * To check Promote Code tooltip Message Displaying
	 * @return - boolean
	 */
	public boolean checkPromoteCodeTooltipMessageDisplaying(){
		return this.checkChildElementExistingByAttribute(cntOrderSummaryPromoteCodeTooltip,"class","promocode__tooltip--msg");
	}

	/**
	 * To get checkout Item Description in product list
	 * @param - productItem - item in product list
	 * @param - lsOption - "mandatory"/"optional"/"all"
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getCheckoutItemDesc(WebElement productItem, String lsOption){
		Map<String,Object> map=null;
		switch(lsOption){
			case "mandatory":
				map=this.getMandatoryCheckoutItemDesc(productItem);
				break;
			case "optional":
				map=this.getOptionalCheckoutItemDesc(productItem);
				break;
			case "all":
				map=this.getAllCheckoutItemDesc(productItem);
				break;
			default:
				break;
		}

		return map;
	}

	/**
	 * To get all Checkout Item Description in product list
	 * @param - productItem - item in product list
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getAllCheckoutItemDesc(WebElement productItem){
		Map<String,Object> mapAll=new HashMap<>();

		Map<String,Object> mapMandatory=this.getMandatoryCheckoutItemDesc(productItem);
		for(Map.Entry<String,Object> entry:mapMandatory.entrySet()){
			mapAll.put(entry.getKey(),entry.getValue());
		}

		Map<String,Object> mapOptional=this.getOptionalCheckoutItemDesc(productItem);
		for(Map.Entry<String,Object> entry:mapOptional.entrySet()){
			mapAll.put(entry.getKey(),entry.getValue());
		}

		return mapAll;
	}

	/**
	 * To get Mandatory checkout Item Description in product list
	 * @param - productItem - item in product list
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getMandatoryCheckoutItemDesc(WebElement productItem){
		Map<String,Object> map=new HashMap<>();

		if(this.checkProductBadgeExisting(productItem)){
			map.put("productBadge",true);
		}
		else{
			map.put("productBadge",false);
		}

		WebElement item=productItem.findElement(byProductItemDesc);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		String lsText=item.getText().trim();
		if(lsText.contains("|")){
			String[] lsSplit=lsText.split("\\|");
			if(lsSplit.length==2){
				if(lsSplit[1].contains("Size")){
					map.put("productName",lsSplit[0].trim());
					map.put("productStyle",null);
					map.put("productSize",lsSplit[1].trim());
				}
				else{
					map.put("productName",lsSplit[0].trim());
					map.put("productStyle",lsSplit[1].trim());
					map.put("productSize",null);
				}
			}
			else{
				map.put("productName",lsSplit[0].trim());
				map.put("productStyle",lsSplit[1].trim());
				map.put("productSize",lsSplit[2].split(":")[1].trim());
			}
		}
		else{
			map.put("productName",lsText);
			map.put("productStyle",null);
			map.put("productSize",null);
		}

		item=productItem.findElement(byProductNumber);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().replace("-","").trim();
		map.put("productNumber",lsText);

		item=productItem.findElement(byProductNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().trim();
		map.put("productNowPrice",this.getFloatFromString(lsText,true));

		item=productItem.findElement(byProductSelectQuantity);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		Select select = new Select(item);
		lsText=select.getFirstSelectedOption().getText();
		map.put("productQuantity",Integer.parseInt(lsText));

		return map;
	}

	/**
	 * To get Optional checkout Item Description in product list
	 * @param - productItem - item in product list
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getOptionalCheckoutItemDesc(WebElement productItem){
		Map<String,Object> map=new HashMap<>();

		WebElement item;
		String lsText;

		if(this.checkProductInventoryExisting(productItem)){
			item=productItem.findElement(byProductInventory);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productLeftNumber",this.getIntegerFromString(lsText));
		}
		else{
			map.put("productLeftNumber",null);
		}

		if(this.checkProductFreeShippingExisting(productItem)){
			item=productItem.findElement(byProductFreeShipping);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productFreeShipping",lsText);
		}
		else{
			map.put("productFreeShipping",null);
		}


		if(!checkProductShippingDateExisting()){
			item=productItem.findElement(byProductShippingDate);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productShippingDate",lsText);
		}

		return map;
	}

	/**
	 * To get checkout Item List Description
	 * @param - lsOption - "mandatory"/"optional"/"all"
	 * @return - List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getCheckoutItemListDesc(String lsOption){
		List<Map<String,Object>> mapList=new ArrayList<>();

		for(WebElement cartItem:this.lstProductList){
			mapList.add(this.getCheckoutItemDesc(cartItem,lsOption));
		}

		return mapList;
	}

	/**
	 * To get Checkout Item Count And SubTotal
	 * @param - List<Map<String,Object>> - productList - Checkout product list
	 * @return - Map<String,Object> - including itemCount and subTotal
	 */
	public Map<String,Object> getCheckoutItemCountAndSubTotal(List<Map<String,Object>> productList){
		Map<String,Object> map=new HashMap<>();

		int totalCount=0,itemQuantity;
		float subTotal=0.0f,itemPrice;
		for(Map<String,Object> productItem:productList){
			itemQuantity= (int) productItem.get("productQuantity");
			itemPrice= (float) productItem.get("productNowPrice");
			totalCount+=itemQuantity;
			subTotal+=itemQuantity*itemPrice;
		}
		map.put("itemCount",totalCount);
		map.put("subTotal",subTotal);

		return map;
	}

	/**
	 * To get WasPrice From OrderSummary
	 * @return - float
	 */
	public float getWasPriceFromOrderSummary(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntOrderSummaryShippingPriceContainer);
		String lsText=this.cntOrderSummaryShippingPriceContainer.getText();
		if(lsText.equalsIgnoreCase("Free")){
			return 0.0f;
		}
		else{
			if(this.checkOrderSummaryWasPriceExisting()){
				return this.getMultiFloatFromString(lsText).get(0);
			}
			else{
				return 0.0f;
			}
		}
	}

	/**
	 * To get NowPrice From OrderSummary
	 * @return - float
	 */
	public float getNowPriceFromOrderSummary(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntOrderSummaryShippingPriceContainer);
		String lsText=this.cntOrderSummaryShippingPriceContainer.getText();
		if(lsText.equalsIgnoreCase("Free")){
			return 0.0f;
		}
		else{
			if(this.checkOrderSummaryWasPriceExisting()){
				if(this.checkOrderSummaryWasPriceExisting()){
					return this.getMultiFloatFromString(lsText).get(1);
				}
				else{
					return this.getMultiFloatFromString(lsText).get(0);
				}
			}
			else{
				return 0.0f;
			}
		}
	}

	/**
	 * To get Saving Price From OrderSummary
	 * @return - float
	 */
	public float getSavingPriceFromOrderSummary(){
		if(this.checkOrderSummarySavingPriceExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummarySavingPrice);
			String lsText=this.lblOrderSummarySavingPrice.getText();
			return this.getFloatFromString(lsText,true);
		}
		else{
			return 0.0f;
		}
	}

	/**
	 * To get Tax Province Code
	 * @return - String
	 */
	public String getTaxProvinceCode(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryTaxTitle);
		String lsText=this.lblOrderSummaryTaxTitle.getText();
		return lsText.split(":")[1].trim();
	}

	/**
	 * To get Promote Code Tooltip Message though hovering on tooltip icon
	 * @return - String
	 */
	public String getPromoteCodeTooltipMessage(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconOrderSummaryPromoteCodeTooltip);
		this.getReusableActionsInstance().scrollToElement(iconOrderSummaryPromoteCodeTooltip);
		this.waitForCondition(Driver->{return this.checkPromoteCodeTooltipMessageDisplaying();},10000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryPromoteCodeTooltipMessage);
		String lsText= this.lblOrderSummaryPromoteCodeTooltipMessage.getText().trim();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryPromoteCodeTitle);
		this.getReusableActionsInstance().scrollToElement(this.lblOrderSummaryPromoteCodeTitle);

		return lsText;
	}

	/**
	 * To add new address or edit an existing address
	 * @return - Map<String,Object> - including firstName,lastName,phoneNumber,address
	 */
	public Map<String,Object> addOrEditAddress(){
		String lsFirstName= DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(5,"lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogFirstName);
		inputAddOrEditAddressDialogFirstName.clear();
		inputAddOrEditAddressDialogFirstName.sendKeys(lsFirstName);
		this.getReusableActionsInstance().staticWait(300);

		String lsLastName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(7,"lowerStringType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogLastName);
		inputAddOrEditAddressDialogLastName.clear();
		inputAddOrEditAddressDialogLastName.sendKeys(lsLastName);
		this.getReusableActionsInstance().staticWait(300);

		String lsPhoneNumber="647"+DataConverter.getSaltString(7,"numberType");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogPhoneNumber);
		inputAddOrEditAddressDialogPhoneNumber.clear();
		inputAddOrEditAddressDialogPhoneNumber.sendKeys(lsPhoneNumber);
		this.getReusableActionsInstance().staticWait(300);

		String lsAutoSearchKeyword = DataConverter.getSaltString(4,"numberType");
		String[] data = lsAutoSearchKeyword.codePoints().mapToObj(cp->new String(Character.toChars(cp))).toArray(size->new String[size]);
		int sum=0;
		for(String inputText:data){
			if(sum>=30){
				break;
			}
			inputAddOrEditAddressDialogAddress.sendKeys(inputText);
			//For thinking time for waiting for backend response
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			sum++;
		}
		this.waitForCondition(Driver->{return this.cntAddOrEditAddressDialogAddressDropDownList.getAttribute("class").contains("react-autosuggest__container--open");},20000);
		this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());

		if(this.lstAddOrEditAddressDialogAddressDropDownList.size()>1){
			reporter.reportLogPass("Getting dropdown auto search results successfully");
		}
		else{
			reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
		}

		int optionSize=this.lstAddOrEditAddressDialogAddressDropDownList.size();
		Random rand = new Random();
		int randomNumber = rand.nextInt(optionSize-2);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressDialogAddressDropDownList.get(randomNumber));
		this.getReusableActionsInstance().clickIfAvailable(this.lstAddOrEditAddressDialogAddressDropDownList.get(randomNumber));
		this.waitForCondition(Driver->{return !this.cntAddOrEditAddressDialogAddressDropDownList.getAttribute("class").contains("react-autosuggest__container--open");},20000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogAddress);
		String lsAddress=inputAddOrEditAddressDialogAddress.getAttribute("value").trim();

		Map<String,Object> map=new HashMap<>();
		map.put("firstName",lsFirstName);
		map.put("lastName",lsLastName);
		map.put("phoneNumber",lsPhoneNumber);
		map.put("address",lsAddress);

		return map;
	}

	/**
	 * To change Shipping Address
	 * @return - int -selected shipping address index
	 */
	public int changeShippingAddress(){
		if(!this.checkAvailableShippingAddressExisting()){
			return -1;
		}

		int loopSize=this.lstAddOrChangeShippingAddressDialogAvailableShippingAddress.size();
		if(loopSize==1){
			return 0;
		}

		WebElement addressItem;
		for(int i=0;i<loopSize;i++){
			addressItem=this.lstAddOrChangeShippingAddressDialogAvailableShippingAddress.get(i);
			if(this.checkIfAddressSelected(addressItem)){
				continue;
			}
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(addressItem);
			addressItem.click();
			this.getReusableActionsInstance().staticWait(300);
			return i;
		}
		return -1;
	}

	/**
	 * To open Add/Change Address Dialog
	 * @return - boolean
	 */
	public boolean openAddOrChangeAddressDialog(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnShippingAddressAddOrChange);
		btnShippingAddressAddOrChange.click();
		return this.waitForCondition(Driver->{return this.lblAddOrChangeShippingAddressDialogTitle.isDisplayed();},10000);
	}

	/**
	 * To close Add/Change Address Dialog
	 * @param -boolean - bSave - true for save and false for close it directly
	 */
	public void closeAddOrChangeAddressDialog(boolean bSave){
		if(bSave){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangeShippingAddressDialogSaveButton);
			btnAddOrChangeShippingAddressDialogSaveButton.click();
			this.applyStaticWait(5*getStaticWaitForApplication());
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangeShippingAddressDialogCloseButton);
			btnAddOrChangeShippingAddressDialogCloseButton.click();
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}

	/**
	 * To open Add/Edit Address Dialog
	 * @param - WebElement - btnAddOrEditButton - add or edit button
	 * @return - boolean
	 */
	public boolean openAddOrEditAddressDialog(WebElement btnAddOrEditButton){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditButton);
		btnAddOrEditButton.click();
		return this.waitForCondition(Driver->{return this.lblAddOrEditAddressDialogTitle.isDisplayed();},10000);
	}

	/**
	 * To close Add/Edit Address Dialog
	 * @param - boolean - bSave - true for save and false for close it directly
	 */
	public void closeAddOrEditAddressDialog(boolean bSave){
		if(bSave){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogSaveButton);
			btnAddOrEditAddressDialogSaveButton.click();
			this.applyStaticWait(5*getStaticWaitForApplication());
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogCloseButton);
			btnAddOrEditAddressDialogCloseButton.click();
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}

	/**
	 * To get Card Data From Yaml File
	 * @param - String - cardType
	 * @return - JSONObject
	 */
	public JSONObject getCardDataFromYamlFile(String cardType){
		JSONObject creditCardData = new DataConverter().readJsonFileIntoJSONObject("test-data/CreditCard.json");
		JSONObject cardData= (JSONObject) creditCardData.get(cardType);
		return cardData;
	}

	/**
	 * To open Add/Change Payment Method Dialog
	 * @return - boolean
	 */
	public boolean openAddOrChangePaymentMethodDialog(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethod);
		btnAddOrChangePaymentMethod.click();
		return this.waitForCondition(Driver->{return this.lblAddOrChangePaymentMethodDialogTitle.isDisplayed();},10000);
	}

	/**
	 * To close Add/Change Payment Method Dialog
	 * @param -boolean - bSave - true for save and false for close it directly
	 */
	public void closeAddOrChangePaymentMethodDialog(boolean bSave){
		if(bSave){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogSaveButton);
			btnAddOrChangePaymentMethodDialogSaveButton.click();
			this.applyStaticWait(5*getStaticWaitForApplication());
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogCloseButton);
			btnAddOrChangePaymentMethodDialogCloseButton.click();
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}

	/**
	 * To open Using A New Card Dialog
	 * @return - boolean
	 */
	public boolean openUsingANewCardDialog(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogUsingANewCardButton);
		btnAddOrChangePaymentMethodDialogUsingANewCardButton.click();
		return this.waitForCondition(Driver->{return this.lblUsingANewCardDialogTitle.isDisplayed();},10000);
	}

	/**
	 * To close Using A New Card Dialog
	 * @param -boolean - bSave - true for save and false for close it directly
	 */
	public void closeUsingANewCardDialog(boolean bSave){
		if(bSave){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogSaveButton);
			btnUsingANewCardDialogSaveButton.click();
			this.applyStaticWait(5*getStaticWaitForApplication());
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogCloseButton);
			btnUsingANewCardDialogCloseButton.click();
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}

	/**
	 * To add a new TSC card
	 */
	public void addNewTSCCard(){
		JSONObject cardData=this.getCardDataFromYamlFile("TSC");
		String TSCCardNumber= (String) cardData.get("Number");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogTSCCardRadio);
		labelUsingANewCardDialogTSCCardRadio.click();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogTSCCardNumber);
		inputUsingANewCardDialogTSCCardNumber.clear();
		inputUsingANewCardDialogTSCCardNumber.sendKeys(TSCCardNumber);
	}

	/**
	 * To add a new Credit card
	 */
	public void addNewCreditCard(){
		JSONObject cardData=this.getCardDataFromYamlFile("visa");
		String cardNumber= (String) cardData.get("Number");
		String expiredMonth=(String) cardData.get("DisplayExpirationMonth");
		String expiredYear=(String) cardData.get("DisplayExpirationYear");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogCreditCardRadio);
		labelUsingANewCardDialogCreditCardRadio.click();

		this.getDriver().switchTo().frame(iframeUsingANewCardDialogCreditCardNumberInput);
		inputCreditCardNumberInIframe.clear();
		inputCreditCardNumberInIframe.sendKeys(cardNumber);
		this.getDriver().switchTo().defaultContent();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateMonth);
		inputUsingANewCardDialogCreditExpirationDateMonth.clear();
		inputUsingANewCardDialogCreditExpirationDateMonth.sendKeys(expiredMonth);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateYear);
		inputUsingANewCardDialogCreditExpirationDateYear.clear();
		inputUsingANewCardDialogCreditExpirationDateYear.sendKeys(expiredMonth);
	}

	/**
	 * To add/Change Payment Method
	 * @param - boolean - bTSC - true for TSC card and false for Credit card
	 * @return -int
	 */
	public int addOrChangePaymentMethod(boolean bTSC){
		if(!this.checkAvailablePaymentMethodExisting()){
			openUsingANewCardDialog();
			if(bTSC){
				addNewTSCCard();
			}
			else{
				addNewCreditCard();
			}
			closeUsingANewCardDialog(true);
		}

		WebElement cardItem;
		int loopSize=lstAddOrChangePaymentMethodDialogAvailableCardContainer.size();
		boolean bFind=false;
		int cartIndex=0;
		for(int i=0;i<loopSize;i++){
			cardItem=lstAddOrChangePaymentMethodDialogAvailableCardContainer.get(i);
			if(bTSC){
				if(checkIfTSCCard(cardItem)){
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardItem);
					cardItem.click();
					bFind=true;
					cartIndex=i;
				}
			}
			else{
				if(!checkIfTSCCard(cardItem)){
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardItem);
					cardItem.click();
					bFind=true;
					cartIndex=i;
				}
			}
		}

		if(!bFind){
			openUsingANewCardDialog();
			if(bTSC){
				addNewTSCCard();
			}
			else{
				addNewCreditCard();
			}
			closeUsingANewCardDialog(true);

			cardItem=lstAddOrChangePaymentMethodDialogAvailableCardContainer.get(0);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardItem);
			cardItem.click();
			cartIndex=0;
		}

		return cartIndex;
	}

	/**
	 * To open Change Billing Address Dialog
	 * @return - boolean
	 */
	public boolean openChangeBillingAddressDialog(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnBillingAddressChange);
		btnBillingAddressChange.click();
		return this.waitForCondition(Driver->{return this.lblAddOrEditAddressDialogTitle.isDisplayed();},10000);
	}

	/**
	 * To close Change Billing Address Dialog
	 * @param - boolean - bSave - true for save and false for close it directly
	 */
	public void closeChangeBillingAddressDialog(boolean bSave){
		if(bSave){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogSaveButton);
			btnAddOrEditAddressDialogSaveButton.click();
			this.applyStaticWait(5*getStaticWaitForApplication());
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogCloseButton);
			btnAddOrEditAddressDialogCloseButton.click();
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}

	/**
	 * To get Payment Option text List
	 * @return - List<String>
	 */
	public List<String> getPaymentOptionTextList(){
		List<String> list=new ArrayList<>();

		Select select=new Select(this.selectPaymentOption);
		List<WebElement> optionList=select.getOptions();
		String lsText;
		for(WebElement option:optionList){
			lsText=this.getElementInnerText(option);
			list.add(lsText);
		}
		return list;
	}

	/**
	 * To get Installment Number From PaymentOption Text
	 * @param - String - lsPaymentOptionText
	 * @return - int
	 */
	public int getInstallmentNumberFromPaymentOptionText(String lsPaymentOptionText){
		if(lsPaymentOptionText.contains("Pay In Full Now")){
			return 0;
		}
		else{
			String stringContainsInteger=this.getStringBeforeGivenIdentifier(lsPaymentOptionText,"of");
			return this.getIntegerFromString(stringContainsInteger);
		}
	}

	/**
	 * To get Installment amount From PaymentOption Text
	 * @param - String - lsPaymentOptionText
	 * @return - float
	 */
	public float getInstallmentAmountFromPaymentOptionText(String lsPaymentOptionText){
		if(lsPaymentOptionText.contains("Pay In Full Now")){
			return this.getIntegerFromString(lsPaymentOptionText);
		}
		else{
			String stringContainsFloat=this.getStringAfterGivenIdentifier(lsPaymentOptionText,"of");
			return this.getFloatFromString(stringContainsFloat,true);
		}
	}

	/**
	 * To set PaymentOption By given text
	 * @param - String - lsPaymentOptionText
	 */
	public void setPaymentOptionByGivenText(String lsPaymentOptionText){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectPaymentOption);
		Select select=new Select(this.selectPaymentOption);
		select.selectByVisibleText(lsPaymentOptionText);
		this.applyStaticWait(this.getStaticWaitForApplication());
	}

	/**
	 * To get Shipping And Payment Description
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getOrderShippingAndPaymentDesc() {
		Map<String, Object> map = new HashMap<>();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblShippingAddress);
		String lsText = this.lblShippingAddress.getText();
		map.put("shippingAddress", lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblShippingMethod);
		lsText = this.lblShippingMethod.getText();
		map.put("shippingMethod", lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblPaymentMethod);
		lsText = this.lblPaymentMethod.getText();
		map.put("paymentMethod", lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblBillingAddress);
		lsText = this.lblBillingAddress.getText();
		map.put("billingAddress", lsText);

		return map;
	}

	/**
	 * To get OrderSummary Description
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getOrderSummaryDesc(){
		Map<String,Object> map=new HashMap<>();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummarySubTotal);
		String lsText=this.lblOrderSummarySubTotal.getText();
		map.put("subTotal",this.getFloatFromString(lsText,true));

		map.put("wasPrice",getWasPriceFromOrderSummary());

		map.put("nowPrice",getNowPriceFromOrderSummary());

		map.put("province",getTaxProvinceCode());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryTax);
		lsText=this.lblOrderSummaryTax.getText();
		map.put("tax",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryTotalPrice);
		lsText=this.lblOrderSummaryTotalPrice.getText();
		map.put("totalPrice",this.getFloatFromString(lsText,true));

		map.put("savePrice",getSavingPriceFromOrderSummary());

		return map;
	}

	/**
	 * To get calculated provincial tax with given province
	 * @param - float - subTotal
	 * @param - float - shippingAmount - refer to nowprice in OrderSummary section
	 * @param - String - province
	 * @param - Map<String,Object> - provincialTaxRate
	 * @return - float - province tax
	 */
	public float getCalculatedProvinceTax(float subTotal,float shippingAmount, String province,Map<String,Object> provincialTaxRate){
		float calProvinceTax=0.0f;
		final DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.UP);
		for(Map.Entry<String,Object> entry:provincialTaxRate.entrySet()){
			if(entry.getKey().equalsIgnoreCase(province)) {
				calProvinceTax = Float.parseFloat(df.format(subTotal*Float.parseFloat(entry.getValue().toString())/100.0f));
				calProvinceTax = calProvinceTax + Float.parseFloat(df.format(shippingAmount*Float.parseFloat(entry.getValue().toString())/100.0f));
				break;
			}
		}
		return calProvinceTax;
	}

	/**
	 * To verify OrderSummary business Logic
	 * @param - itemAmountShoppingCart - int - Shopping item amount in checkout cart
	 * @param - subTotalShoppingCart - float - subTotal in checkout cart
	 * @param - orderSummaryMap - Map<String,Object>
	 * @param - Map<String,Object> - provincialTaxRate - note that if pass null, will not calculate tax for comparison
	 */
	public void verifyOrderSummaryBusinessLogic(int itemAmountShoppingCart,float subTotalShoppingCart,Map<String,Object> orderSummaryMap,Map<String,Object> provincialTaxRate){
		int itemAmountOrderSummary= (int) orderSummaryMap.get("itemAmount");
		if(itemAmountOrderSummary==itemAmountShoppingCart){
			reporter.reportLogPass("The item amount in OrderSummary section is equal to the one in Shopping Cart item section");
		}
		else{
			reporter.reportLogFail("The item amount:"+itemAmountOrderSummary+" in OrderSummary section is not equal to the one:"+itemAmountShoppingCart+" in Shopping Cart item section");
		}

		float wasPriceOrderSummary= (float) orderSummaryMap.get("wasPrice");
		float nowPriceOrderSummary=(float) orderSummaryMap.get("nowPrice");
		float calSavePriceOrderSummary;
		if(wasPriceOrderSummary<0.01){
			calSavePriceOrderSummary=0.0f;
		}
		else{
			calSavePriceOrderSummary=Math.abs(wasPriceOrderSummary-nowPriceOrderSummary);
		}

		float savePriceOrderSummary=(float) orderSummaryMap.get("savePrice");
		if(Math.abs(calSavePriceOrderSummary-savePriceOrderSummary)<0.01){
			reporter.reportLogPass("The calculated saving price in OrderSummary section is equal to the saving price in OrderSummary section");
		}
		else{
			reporter.reportLogFail("The calculated saving price:"+calSavePriceOrderSummary+" in OrderSummary section is not equal to the saving price:"+savePriceOrderSummary+" in OrderSummary section");
		}

		float subTotal=(float) orderSummaryMap.get("subTotal");
		if(Math.abs(subTotal-subTotalShoppingCart)<0.01){
			reporter.reportLogPass("The subtotal price in OrderSummary section is equal to the subtotal price in shopping cart section");
		}
		else{
			reporter.reportLogFail("The subtotal price:"+subTotal+" in OrderSummary section is not equal to the subtotal price:"+subTotalShoppingCart+" in shopping cart section");
		}

		float tax=(float) orderSummaryMap.get("tax");
		if(provincialTaxRate!=null){
			final DecimalFormat df = new DecimalFormat("0.00");
			String province=orderSummaryMap.get("province").toString();
			float calProvinceTax=getCalculatedProvinceTax(subTotal,(float) orderSummaryMap.get("nowPrice"),province,provincialTaxRate);
			if(Math.abs(Float.parseFloat(df.format(calProvinceTax-tax)))<0.02){
				reporter.reportLogPass("The calculated tax in OrderSummary section is equal to the tax in OrderSummary section");
			}
			else{
				reporter.reportLogFail("The calculated tax:"+calProvinceTax+" in OrderSummary section for province: "+province+" is not equal to the tax:"+tax+" in OrderSummary section");
			}
		}

		float calTotalPrice=subTotal+tax+nowPriceOrderSummary;
		float totalPrice=(float) orderSummaryMap.get("totalPrice");
		if(Math.abs(calTotalPrice-totalPrice)<0.01){
			reporter.reportLogPass("The calculated total price in OrderSummary section is equal to the total price in OrderSummary section");
		}
		else{
			reporter.reportLogFail("The calculated total price:"+calTotalPrice+" in OrderSummary section is not equal to the total price:"+totalPrice+" in OrderSummary section");
		}
	}

	/**
	 * To get EasyPay Description
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getEasyPayDesc(){
		Map<String,Object> map=new HashMap<>();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblInstallmentNumber);
		String lsText=this.lblInstallmentNumber.getText();
		map.put("installmentsNumber",this.getIntegerFromString(lsText));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblInstallmentTodayPayment);
		lsText=this.lblInstallmentTodayPayment.getText();
		map.put("todayPayment",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblInstallmentLeftPayment);
		lsText=this.lblInstallmentLeftPayment.getText();
		map.put("leftPayment",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblInstallmentFuturePayment);
		lsText=this.lblInstallmentFuturePayment.getText();
		map.put("futureMonthlyPayment",this.getFloatFromString(lsText,true));

		return map;
	}

	/**
	 * To get Installment business logic
	 * @param - int - totalInstallmentNumber - the installment number from presetting in payment option
	 * @param - Map<String,Object> - orderSummaryMap
	 */
	public void verifyInstallmentBusinessLogic(int totalInstallmentNumber,Map<String,Object> orderSummaryMap){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblInstallmentNumber);
		int currentTotalInstallmentNumber=this.getIntegerFromString(this.lblInstallmentNumber.getText());
		if(totalInstallmentNumber==currentTotalInstallmentNumber){
			reporter.reportLogPass("The presetting installment number is equal to the installment number in installment section");
		}
		else{
			reporter.reportLogFail("The presetting installment number:"+totalInstallmentNumber+" is equal to the installment number in installment section:"+currentTotalInstallmentNumber);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblInstallmentTodayPayment);
		float todayPayment=this.getFloatFromString(this.lblInstallmentTodayPayment.getText(),true);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblInstallmentLeftPayment);
		float leftPayment=this.getFloatFromString(this.lblInstallmentLeftPayment.getText(),true);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblInstallmentFuturePayment);
		float futureMonthlyPayment=this.getFloatFromString(this.lblInstallmentFuturePayment.getText(),true);

		float subTotalOrderSummary= (float) orderSummaryMap.get("subTotal");
		float shippingPriceOrderSummary=(float) orderSummaryMap.get("nowPrice");
		float taxOrderSummary=(float) orderSummaryMap.get("tax");
		float totalPriceOrderSummary=(float) orderSummaryMap.get("totalPrice");

		float eachInstallmentPayment=subTotalOrderSummary/totalInstallmentNumber;
		float calTodayPayment=eachInstallmentPayment+shippingPriceOrderSummary+taxOrderSummary;
		if(Math.abs(calTodayPayment-todayPayment)<0.1){
			reporter.reportLogPass("The calculated today payment is equal to the today payment in installment section: "+todayPayment);
		}
		else{
			reporter.reportLogFail("The calculated today payment:"+calTodayPayment+" is not equal to the today payment:"+todayPayment+" in installment section");
		}

		float calLeftPayment=totalPriceOrderSummary-todayPayment;
		if(Math.abs(calLeftPayment-leftPayment)<0.1){
			reporter.reportLogPass("The calculated left payment is equal to the left payment in installment section: "+leftPayment);
		}
		else{
			reporter.reportLogFail("The calculated left payment:"+calLeftPayment+" is not equal to the left payment:"+leftPayment+" in installment section");
		}

		int calFutureMonthlyPaymentNumber=totalInstallmentNumber-1;
		float calFutureMonthlyPayment=calLeftPayment/calFutureMonthlyPaymentNumber;
		if(Math.abs(calFutureMonthlyPayment-futureMonthlyPayment)<0.1){
			reporter.reportLogPass("The calculated future monthly payment is equal to the future monthly payment in installment section: "+futureMonthlyPayment);
		}
		else{
			reporter.reportLogFail("The calculated future monthly payment:"+calFutureMonthlyPayment+" is equal to the future monthly payment:"+futureMonthlyPayment+" in installment section");
		}
	}

	/**
	 * To verify Mandatory Contents For Checkout Product List
	 */
	public void verifyMandatoryContentsForCheckoutProductList() {
		String lsText;
		WebElement item;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCollapseProductList );
		lsText = btnCollapseProductList .getText().trim();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The product list collapse button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The product list collapse button is not displaying correctly");
		}

		for (WebElement productItem : this.lstProductList) {
			if (this.checkProductBadgeExisting(productItem)) {
				item = productItem.findElement(this.byProductBadge);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if (this.getReusableActionsInstance().isElementVisible(item)) {
					reporter.reportLogPass("The product badge is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product badge is not displaying correctly");
				}
			}

			item = productItem.findElement(byProductItemDesc);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product description is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product description is not displaying correctly");
			}

			item = productItem.findElement(byProductNumber);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText().replace("-", "").trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product number is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product number is not displaying correctly");
			}

			item = productItem.findElement(byProductNowPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product nowPrice is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product nowPrice is not displaying correctly");
			}

			item = productItem.findElement(byProductSelectQuantity);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			Select select = new Select(item);
			lsText = select.getFirstSelectedOption().getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product quantity is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product quantity is not displaying correctly");
			}

			item = productItem.findElement(byProductShippingDate);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product Shipping Date is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product Shipping Date is not displaying correctly");
			}
		}
	}

	/**
	 * To verify Optional Contents For Checkout Product List
	 */
	public void verifyOptionalContentsForCheckoutProductList() {
		String lsText;
		WebElement item;

		for(WebElement productItem:this.lstProductList){
			if(this.checkProductInventoryExisting(productItem)){
				item=productItem.findElement(byProductInventory);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText=item.getText().trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The product Inventory is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product Inventory is not displaying correctly");
				}
			}

			if(this.checkProductFreeShippingExisting(productItem)){
				item=productItem.findElement(byProductFreeShipping);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText=item.getText().trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The product Free Shipping is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product Free Shipping is not displaying correctly");
				}
			}
		}
	}

	/**
	 * To verify Address And Payment Contents
	 */
	public void verifyAddressAndPaymentContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingAddressTitle);
		lsText=lblShippingAddressTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Shipping Address Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Shipping Address Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingAddress);
		lsText=lblShippingAddress.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Shipping Address is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Shipping Address is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnShippingAddressAddOrChange);
		lsText=btnShippingAddressAddOrChange.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Shipping Address AddOrChange button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Shipping Address AddOrChange button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingMethodTitle);
		lsText=lblShippingMethodTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Shipping Method Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Shipping Method Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingMethod);
		lsText=lblShippingMethod.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Shipping Method is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Shipping Method is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingPaymentMethodTitle);
		lsText=lblShippingPaymentMethodTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Shipping Payment Method Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Shipping Payment Method Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentMethod);
		lsText=lblPaymentMethod.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Payment Method is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Payment Method is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethod);
		lsText=btnAddOrChangePaymentMethod.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The AddOrChange Payment Method button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The AddOrChange Payment Method button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblBillingAddressTitle);
		lsText=lblBillingAddressTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Billing Address Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Billing Address Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblBillingAddress);
		lsText=lblBillingAddress.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Billing Address is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Billing Address is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnBillingAddressChange);
		lsText=btnBillingAddressChange.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Billing Address Change button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Billing Address Change button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentOptionTitle);
		lsText=lblPaymentOptionTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Payment Option Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Payment Option Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentOptionText);
		lsText=lblPaymentOptionText.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Payment Option text is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Payment Option text is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectPaymentOption);
		if(this.getReusableActionsInstance().isElementVisible(selectPaymentOption)){
			reporter.reportLogPass("The select Payment Option is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The select Payment Option is not displaying correctly");
		}
	}

	/**
	 * To verify OrderSummary Contents
	 */
	public void verifyOrderSummaryContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryTitle);
		lsText = lblOrderSummaryTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummarySubTotalTitle);
		lsText = lblOrderSummarySubTotalTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary SubTotal Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary SubTotal Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummarySubTotal);
		lsText = lblOrderSummarySubTotal.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary SubTotal is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary SubTotal is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryShippingTitle);
		lsText = lblOrderSummaryShippingTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Shipping Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Shipping Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(cntOrderSummaryShippingPriceContainer);
		lsText = cntOrderSummaryShippingPriceContainer.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Shipping Price is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Shipping Price is not displaying correctly");
		}

		if(checkOrderSummaryWasPriceExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryShippingWasPrice);
			lsText = lblOrderSummaryShippingWasPrice.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The OrderSummary Shipping WasPrice is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The OrderSummary Shipping WasPrice is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryTaxTitle);
		lsText = lblOrderSummaryTaxTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Tax Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Tax Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryTax);
		lsText = lblOrderSummaryTax.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Tax is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Tax is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryTotalPriceTitle);
		lsText = lblOrderSummaryTotalPriceTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Total Price Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Total Price Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryTotalPrice);
		lsText = lblOrderSummaryTotalPrice.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Total Price is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Total Price is not displaying correctly");
		}

		if(checkOrderSummarySavingPriceExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummarySavingPrice);
			lsText = lblOrderSummarySavingPrice.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The OrderSummary Saving Price is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The OrderSummary Saving Price is not displaying correctly");
			}
		}
	}

	/**
	 * To verify EasyPay Contents
	 */
	public void verifyEasyPayContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInstallmentTitle);
		lsText = lblInstallmentTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Installment Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Installment Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInstallmentNumberTitle);
		lsText = lblInstallmentNumberTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Installment Number Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Installment Number Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInstallmentNumber);
		lsText = lblInstallmentNumber.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Installment Number is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Installment Number is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInstallmentTodayPaymentTitle);
		lsText = lblInstallmentTodayPaymentTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Installment Today Payment Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Installment Today Payment Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInstallmentTodayPayment);
		lsText = lblInstallmentTodayPayment.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Installment Today Payment is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Installment Today Payment is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInstallmentLeftPaymentTitle);
		lsText = lblInstallmentLeftPaymentTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Installment Left Payment Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Installment Left Payment Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInstallmentLeftPayment);
		lsText = lblInstallmentLeftPayment.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Installment Left Payment is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Installment Left Payment is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInstallmentFuturePaymentTitle);
		lsText = lblInstallmentFuturePaymentTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Installment Future Payment Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Installment Future Payment Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInstallmentFuturePayment);
		lsText = lblInstallmentFuturePayment.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Installment Future Payment is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Installment Future Payment is not displaying correctly");
		}
	}

	/**
	 * To verify Promote Code Contents
	 */
	public void verifyPromoteCodeContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryPromoteCodeTitle);
		lsText = lblOrderSummaryPromoteCodeTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Promote Code Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Promote Code Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconOrderSummaryPromoteCodeTooltip);
		if(this.getReusableActionsInstance().isElementVisible(iconOrderSummaryPromoteCodeTooltip)){
			reporter.reportLogPass("The OrderSummary Promote Code icon is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The OrderSummary Promote Code icon is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconOrderSummaryPromoteCodeTooltip);
		this.getReusableActionsInstance().scrollToElement(iconOrderSummaryPromoteCodeTooltip);
		this.waitForCondition(Driver->{return this.checkPromoteCodeTooltipMessageDisplaying();},10000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryPromoteCodeTooltipMessage);
		lsText= this.lblOrderSummaryPromoteCodeTooltipMessage.getText().trim();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Promote Code Tooltip Message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Promote Code Tooltip Message is not displaying correctly");
		}
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryPromoteCodeTitle);
		this.getReusableActionsInstance().scrollToElement(this.lblOrderSummaryPromoteCodeTitle);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryPromoteCode);
		if(this.getReusableActionsInstance().isElementVisible(inputOrderSummaryPromoteCode)){
			reporter.reportLogPass("The OrderSummary Promote Code input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The OrderSummary Promote Code input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderSummaryPromoteCodeApply);
		lsText = btnOrderSummaryPromoteCodeApply.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Promote Code apply button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Promote Code apply button is not displaying correctly");
		}
	}

	/**
	 * To verify Gift Card And Place Order Contents
	 */
	public void verifyGiftCardAndPlaceOrderContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryGiftCardTitle);
		lsText = lblOrderSummaryGiftCardTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Gift Card Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Gift Card Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryGiftCardNumber);
		if(this.getReusableActionsInstance().isElementVisible(inputOrderSummaryGiftCardNumber)){
			reporter.reportLogPass("The OrderSummary GiftCard Number input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The OrderSummary GiftCard Number input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryGiftCardPinTitle);
		lsText = lblOrderSummaryGiftCardPinTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Gift Card pin Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Gift Card pin Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryGiftCardPin);
		if(this.getReusableActionsInstance().isElementVisible(inputOrderSummaryGiftCardPin)){
			reporter.reportLogPass("The OrderSummary GiftCard pin input is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The OrderSummary GiftCard pin input is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderSummaryPlaceOrder);
		lsText = btnOrderSummaryPlaceOrder.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Place Order button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Place Order button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryPlaceOrderMessage);
		lsText = lblOrderSummaryPlaceOrderMessage.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Place Order message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Place Order message is not displaying correctly");
		}
	}

	/**
	 * To verify AddOrChange Address Dialog Contents
	 */
	public void verifyAddOrChangeAddressDialogContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrChangeShippingAddressDialogTitle);
		lsText = lblAddOrChangeShippingAddressDialogTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The title in Add Or Change Address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The title in Add Or Change Address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangeShippingAddressDialogCloseButton);
		if(this.getReusableActionsInstance().isElementVisible(btnAddOrChangeShippingAddressDialogCloseButton)){
			reporter.reportLogPass("The close button in Add Or Change Address Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The close button in Add Or Change Address Dialog is not displaying correctly");
		}

		if(this.checkAvailableShippingAddressExisting()){
			WebElement item, addressItem;
			int loopSize=lstAddOrChangeShippingAddressDialogAvailableShippingAddress.size();
			for(int i=0;i<loopSize;i++){
				reporter.reportLog("Verify address "+i);
				addressItem=lstAddOrChangeShippingAddressDialogAvailableShippingAddress.get(i);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(addressItem);
				addressItem.click();
				this.applyStaticWait(300);

				item=addressItem.findElement(byAddOrChangeShippingAddressDialogSelectLabel);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if(this.getReusableActionsInstance().isElementVisible(item)){
					reporter.reportLogPass("The select address is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The select address is not displaying correctly");
				}

				item=addressItem.findElement(byAddOrChangeShippingAddressDialogEditButton);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText=item.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The edit button is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The edit button is not displaying correctly");
				}

				item=addressItem.findElement(byAddOrChangeShippingAddressDialogCardDetails);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText=item.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The address details are displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The address details are not displaying correctly");
				}
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangeShippingAddressDialogAddNewAddressButton);
		lsText = btnAddOrChangeShippingAddressDialogAddNewAddressButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Add New Address Button in Add Or Change Address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Add New Address Button in Add Or Change Address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangeShippingAddressDialogSaveButton);
		lsText = btnAddOrChangeShippingAddressDialogSaveButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The save Button in Add Or Change Address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The save Button in Add Or Change Address Dialog is not displaying correctly");
		}
	}

	/**
	 * To verify Add or Edit Address Dialog Contents
	 */
	public void verifyAddOrEditAddressDialogContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogTitle);
		lsText = lblAddOrEditAddressDialogTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The title in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The title in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogCloseButton);
		if(this.getReusableActionsInstance().isElementVisible(btnAddOrEditAddressDialogCloseButton)){
			reporter.reportLogPass("The close button in Add or edit address Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The close button in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogFormRequiredMessage);
		lsText = lblAddOrEditAddressDialogFormRequiredMessage.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Required Message in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Required Message in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogFirstNameLabel);
		lsText = lblAddOrEditAddressDialogFirstNameLabel.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The FirstName Label in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The FirstName Label in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogFirstName);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressDialogFirstName)){
			reporter.reportLogPass("The FirstName input in Add or edit address Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The FirstName input in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogLastNameLabel);
		lsText = lblAddOrEditAddressDialogLastNameLabel.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The LastName Label in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The LastName Label in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogLastName);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressDialogLastName)){
			reporter.reportLogPass("The LastName input in Add or edit address Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The LastName input in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogPhoneNumberLabel);
		lsText = lblAddOrEditAddressDialogPhoneNumberLabel.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The PhoneNumber Label in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The PhoneNumber Label in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogPhoneNumber);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressDialogPhoneNumber)){
			reporter.reportLogPass("The PhoneNumber input in Add or edit address Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The PhoneNumber input in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogAddressLabel);
		lsText = lblAddOrEditAddressDialogAddressLabel.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Address Label in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Address Label in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogAddress);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressDialogAddress)){
			reporter.reportLogPass("The Address input in Add or edit address Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Address input in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogAddressLine2Label);
		lsText = lblAddOrEditAddressDialogAddressLine2Label.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Address Line2 Label in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Address Line2 Label in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogAddressLine2);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressDialogAddressLine2)){
			reporter.reportLogPass("The Address Line2 input in Add or edit address Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Address Line2 input in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogAddressLine2HintMessage);
		if(this.getReusableActionsInstance().isElementVisible(lblAddOrEditAddressDialogAddressLine2HintMessage)){
			reporter.reportLogPass("The Address Line2 hint message in Add or edit address Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Address Line2 hint message in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogCityLabel);
		lsText = lblAddOrEditAddressDialogCityLabel.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The City Label in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The City Label in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogCity);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressDialogCity)){
			reporter.reportLogPass("The City input in Add or edit address Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The City input in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogProvinceLabel);
		lsText = lblAddOrEditAddressDialogProvinceLabel.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Province Label in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Province Label in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectAddOrEditAddressDialogProvince);
		if(this.getReusableActionsInstance().isElementVisible(selectAddOrEditAddressDialogProvince)){
			reporter.reportLogPass("The select Province in Add or edit address Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The select Province in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogPostalCodeLabel);
		lsText = lblAddOrEditAddressDialogPostalCodeLabel.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The PostalCode Label in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The PostalCode Label in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogPostalCode);
		if(this.getReusableActionsInstance().isElementVisible(inputAddOrEditAddressDialogPostalCode)){
			reporter.reportLogPass("The PostalCode input in Add or edit address Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The PostalCode input in Add or edit address Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogSaveButton);
		lsText = btnAddOrEditAddressDialogSaveButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The save button in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The save button in Add or edit address Dialog is not displaying correctly");
		}
	}

	/**
	 * To verify Add Or Change Payment Method Dialog Contents
	 */
	public void verifyAddOrChangePaymentMethodDialogContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrChangePaymentMethodDialogTitle);
		lsText = lblAddOrChangePaymentMethodDialogTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The title in Add Or Change Payment Method Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The title in Add Or Change Payment Method Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogCloseButton);
		if(this.getReusableActionsInstance().isElementVisible(btnAddOrChangePaymentMethodDialogCloseButton)){
			reporter.reportLogPass("The close button in Add Or Change Payment Method Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The close button in Add Or Change Payment Method Dialog is not displaying correctly");
		}

		if(this.checkAvailablePaymentMethodExisting()){
			WebElement item, paymentItem;
			int loopSize=lstAddOrChangePaymentMethodDialogAvailableCardContainer.size();
			for(int i=0;i<loopSize;i++){
				reporter.reportLog("Verify payment method "+i);
				paymentItem=lstAddOrChangePaymentMethodDialogAvailableCardContainer.get(i);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(paymentItem);
				paymentItem.click();
				this.applyStaticWait(300);

				item=paymentItem.findElement(byAddOrChangePaymentMethodDialogSelectLabel);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if(this.getReusableActionsInstance().isElementVisible(item)){
					reporter.reportLogPass("The select payment is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The select payment is not displaying correctly");
				}

				item=paymentItem.findElement(byAddOrChangePaymentMethodDialogEditButton);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText=item.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The edit button is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The edit button is not displaying correctly");
				}

				item=paymentItem.findElement(byAddOrChangePaymentMethodDialogRemoveButton);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText=item.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The remove button is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The remove button is not displaying correctly");
				}

				item=paymentItem.findElement(byAddOrChangePaymentMethodDialogCardLogo);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if(this.getReusableActionsInstance().isElementVisible(item)){
					reporter.reportLogPass("The card Logo in Add Or Change Payment Method Dialog is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The card Logo in Add Or Change Payment Method Dialog is not displaying correctly");
				}

				item=paymentItem.findElement(byAddOrChangePaymentMethodDialogCardDetails);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText=item.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The payment details are displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The payment details are not displaying correctly");
				}
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogUsingANewCardButton);
		lsText = btnAddOrChangePaymentMethodDialogUsingANewCardButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Add New card Button in Add Or Change payment method Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Add New card Button in Add Or Change payment method Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelAddOrChangePaymentMethodDialogPaypalRadio);
		if(this.getReusableActionsInstance().isElementVisible(labelAddOrChangePaymentMethodDialogPaypalRadio)){
			reporter.reportLogPass("The paypal radio button in Add Or Change Payment Method Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The paypal radio button in Add Or Change Payment Method Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogSaveButton);
		lsText = btnAddOrChangePaymentMethodDialogSaveButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The save Button in Add Or Change payment method Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The save Button in Add Or Change payment method Dialog is not displaying correctly");
		}
	}

	/**
	 * To verify Using A New Card Dialog Contents
	 */
	public void verifyUsingANewCardDialogContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblUsingANewCardDialogTitle);
		lsText = lblUsingANewCardDialogTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The title in using a new card Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The title in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogCloseButton);
		if(this.getReusableActionsInstance().isElementVisible(btnUsingANewCardDialogCloseButton)){
			reporter.reportLogPass("The close button in using a new card Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The close button in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditCardRadio);
		if(this.getReusableActionsInstance().isElementVisible(inputUsingANewCardDialogCreditCardRadio)){
			reporter.reportLogPass("The CreditCard Radio button in using a new card Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The CreditCard Radio button in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogCreditCardRadio);
		if(this.getReusableActionsInstance().isElementVisible(labelUsingANewCardDialogCreditCardRadio)){
			reporter.reportLogPass("The CreditCard Radio button label in using a new card Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The CreditCard Radio button label in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogTSCCardRadio);
		if(this.getReusableActionsInstance().isElementVisible(inputUsingANewCardDialogTSCCardRadio)){
			reporter.reportLogPass("The TSC Radio button in using a new card Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The TSC Radio button in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogTSCCardRadio);
		if(this.getReusableActionsInstance().isElementVisible(labelUsingANewCardDialogTSCCardRadio)){
			reporter.reportLogPass("The TSC Radio button label in using a new card Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The TSC Radio button label in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblUsingANewCardDialogCreditCardNumberTitle);
		lsText = lblUsingANewCardDialogCreditCardNumberTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The CreditCard Number Title in using a new card Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The CreditCard Number Title in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iframeUsingANewCardDialogCreditCardNumberInput);
		if(this.getReusableActionsInstance().isElementVisible(iframeUsingANewCardDialogCreditCardNumberInput)){
			reporter.reportLogPass("The CreditCard Number Input in using a new card Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The CreditCard Number Input in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblUsingANewCardDialogCreditExpirationDateTitle);
		lsText = lblUsingANewCardDialogCreditExpirationDateTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The CreditCard Expiration Date Title in using a new card Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The CreditCard Expiration Date Title in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateMonth);
		if(this.getReusableActionsInstance().isElementVisible(inputUsingANewCardDialogCreditExpirationDateMonth)){
			reporter.reportLogPass("The CreditCard Expiration Date Month Input in using a new card Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The CreditCard Expiration Date Month Input in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateYear);
		if(this.getReusableActionsInstance().isElementVisible(inputUsingANewCardDialogCreditExpirationDateYear)){
			reporter.reportLogPass("The CreditCard Expiration Date Year Input in using a new card Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The CreditCard Expiration Date Year Input in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogTSCCardRadio);
		labelUsingANewCardDialogTSCCardRadio.click();
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblUsingANewCardDialogTSCCardNumberTitle);
		lsText = lblUsingANewCardDialogTSCCardNumberTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The TSCCard Number Title in using a new card Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The TSCCard Number Title in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogTSCCardNumber);
		if(this.getReusableActionsInstance().isElementVisible(inputUsingANewCardDialogTSCCardNumber)){
			reporter.reportLogPass("The TSCCard Number Input in using a new card Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The TSCCard Number Input in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogSaveButton);
		lsText = btnUsingANewCardDialogSaveButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The save button in using a new card Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The save button in using a new card Dialog is not displaying correctly");
		}
	}

}
