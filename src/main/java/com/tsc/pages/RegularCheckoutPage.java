package com.tsc.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.api.util.JsonParser;
import com.tsc.pages.base.BasePage;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
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

	//Hide for mobile device
	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__address']//div[@class='progressbar__title']")
	public WebElement lblAddressProgressBar;

	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__address']//div[@class='progressbar__title']/following-sibling::*")
	public WebElement iconAddressProgressBar;

	//Hide for mobile device
	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__payment']//div[@class='progressbar__title']")
	public WebElement lblPaymentProgressBar;

	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__payment']//div[@class='progressbar__title']/following-sibling::*")
	public WebElement iconPaymentProgressBar;

	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__review']//div[@class='progressbar__title']")
	public WebElement lblReviewOrderProgressBar;

	@FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__review']//div[@class='progressbar__title']/following-sibling::*")
	public WebElement iconReviewOrderProgressBar;

	@FindBy(xpath = "//header//a[@data-link-title='shopping bag']")
	public WebElement btnGoToShoppingBag;

	//For checkout product list,shipping and payment
	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'alert')]")
	public WebElement lblAlertMessage;

	@FindBy(xpath = "//article[@class='leftSide']//button[@data-collapse='collapse__productlist']")
	public WebElement btnCollapseProductList;

	@FindBy(xpath = "//article[@class='leftSide']")
	public WebElement cntProductOrderSection;

	@FindBy(xpath = "//article[@class='leftSide']//div[@id='collapse__productlist']")
	public WebElement cntProductListContainer;

	@FindBy(xpath = "//article[@class='leftSide']//button[contains(normalize-space(text()),'Items Being Added')]")
	public WebElement btnItemBeingAdded;

	@FindBy(xpath = "//article[@class='leftSide']//button[contains(normalize-space(text()),'Existing Items')]/preceding-sibling::div[@id='collapse__productlist']//div[@class='productlist']")
	public List<WebElement> lstProductListForItemBeingAdded;

	@FindBy(xpath = "//article[@class='leftSide']//button[contains(normalize-space(text()),'Existing Items')]")
	public WebElement btnExistingItems;

	@FindBy(xpath = "//article[@class='leftSide']//button[contains(normalize-space(text()),'Existing Items')]/following-sibling::div[@id='collapse__productlist']//div[@class='productlist']")
	public List<WebElement> lstProductListForExistingItems;

	@FindBy(xpath = "//article[@class='leftSide']//div[@id='collapse__productlist']//div[@class='productlist']")
	public List<WebElement> lstProductList;

	public By byProductBadgeContainer=By.xpath(".//div[@class='productlist__row']//div[@class='productlist__left']");
	public By byProductBadge=By.xpath(".//div[@class='productlist__row']//div[@class='productlist__left']//img[@class='productlist__badge']");
	public By byProductImage=By.xpath(".//div[@class='productlist__row']//div[@class='productlist__left']//img[not(@class='productlist__badge')]");
	public By byProductItemDesc=By.xpath(".//div[@class='productlist__row']//div[@class='productlist__right']//div[@class='productlist__description']");
	public By byProductNumberContainer=By.xpath(".//div[@class='productlist__row']//div[@class='productlist__right']");
	public By byProductNumber=By.xpath(".//div[@class='productlist__row']//div[@class='productlist__right']//div[@class='productlist__itemnumber']");
	public By byProductSelectQuantity=By.xpath(".//div[@class='productlist__pricerow']//div[@class='productlist__left--qty']");
	public By byProductInventoryContainer=By.xpath(".//div[@class='productlist__pricerow']//div[@class='productlist__right']");
	public By byProductInventory=By.xpath(".//div[@class='productlist__pricerow']//div[@class='productlist__right']//span[@class='productlist__right--inventory']");
	public By byProductNowPrice=By.xpath(".//div[@class='productlist__pricerow']//div[@class='productlist__right']//span[@class='productlist__right--price']");
	public By byProductFreeShipping=By.xpath(".//span[@class='productlist__right--freeship']");
	public By byProductShippingDate=By.xpath(".//div[@class='estimateDateCheckout__lineItem']");

	@FindBy(xpath = "//div[@class='reviewWrap']//div[@class='estimatedlabel__left']//following-sibling::span[not(contains(.,'Get'))]")
	public WebElement lblGetItByDate;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'reviewWrap')]//div[@class='estimatedlabel__left']//span[@class='estimatedLabel__date']")
	public WebElement lblShippingDateTitle;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'reviewWrap')]//div[@class='estimatedlabel__left']/following-sibling::span")
	public WebElement lblShippingDate;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'shippingAddressWrap')]")
	public WebElement cntShippingAddressSection;

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

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//button[@class='modal__button-back']")
	public WebElement btnAddOrChangeShippingAddressDialogBackButton;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//button[@class='modal__button-close']")
	public WebElement btnAddOrChangeShippingAddressDialogCloseButton;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='card__wrap']")
	public List<WebElement> lstAddOrChangeShippingAddressDialogCardWrapSectionIncludingAddNewAddress;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='card__wrap'][not(div[@class='card__box--add'])]")
	public List<WebElement> lstAddOrChangeShippingAddressDialogAvailableShippingAddress;

	public By byAddOrChangeShippingAddressDialogSelectedStatus=By.xpath("./div");
	public By byAddOrChangeShippingAddressDialogSelectLabel=By.xpath("./div/label");
	public By byAddOrChangeShippingAddressDialogEditButton=By.xpath(".//button[normalize-space(.)='Edit']");
	public By byAddOrChangeShippingAddressDialogHeaderContent=By.xpath(".//div[@class='card__header']");
	//public By byAddOrChangeShippingAddressDialogEditButton=By.xpath("./div/label/div[@class='card__header']/button[contains(@style,'block') and normalize-space(.)='Edit']");
	public By byAddOrChangeShippingAddressDialogCardDetails=By.xpath(".//div[@class='card__address']");

	@FindBy(xpath = "//div/label/div[@class='card__header']/button[contains(@style,'block')]")
	public WebElement btnEditButtonAddChangeShippingAddressDialog;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//button[@class='card__button--add']")
	public WebElement btnAddOrChangeShippingAddressDialogAddNewAddressButton;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//button[contains(@class,'modal__button--save')]")
	public WebElement btnAddOrChangeShippingAddressDialogSaveButton;

	//For the popup window after clicking Add/Edit address button
	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//div[@class='modal__header']//h3")
	public WebElement lblAddOrEditAddressDialogTitle;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//button[@class='modal__button-close']")
	public WebElement btnAddOrEditAddressDialogCloseButton;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay--after-open')]//button[@class='modal__button-back']")
	public WebElement btnAddOrEditAddressDialogBackButton;

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

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'shippingMethodWrap')]")
	public WebElement cntShippingMethodSection;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'shippingMethodWrap')]//div[@class='shippingmethod__label']")
	public WebElement lblShippingMethodTitle;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'shippingMethodWrap')]//div[@class='shippingmethod__description']")
	public WebElement lblShippingMethod;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'shippingMethodWrap')]")
	public WebElement cntChangeShippingMethodContainer;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'shippingMethodWrap')]//button[@class='button__change']")
	public WebElement btnChangeShippingMethod;

	/////////////////////////////////////////////////////////////
	//For change shipping method popup window by clicking btnChangeShippingMethod
	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//div[@class='modal__header']//h3")
	public WebElement lblChangeShippingMethodDialogHeaderTitle;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//div[@class='modal__header']//button[@class='modal__button-back']")
	public WebElement btnChangeShippingMethodDialogBackButton;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//div[@class='modal__header']//button[@class='modal__button-close']")
	public WebElement btnChangeShippingMethodDialogCloseButton;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//div[@class='modal__body']//div[@class='shipmethod__container']")
	public List<WebElement> lstChangeShippingMethodDialogShippingMethodList;

	public By byShippingMethodInput=By.xpath(".//input");
	public By byShippingMethodLabel=By.xpath(".//label");
	public By byShippingMethodRadioButton=By.xpath(".//span[@class='shipmethod__radio-button']");
	public By byShippingMethodDescription=By.xpath(".//div[@class='shipmethod__description']");
	public By byShippingMethodPrice=By.xpath(".//div[@class='shipmethod__description']");
	public By byShippingMethodDetails=By.xpath(".//div[@class='shipmethod__detail']");
	public By byShippingMethodLearMoreLink=By.xpath(".//a[@class='shipmethod__link']");

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//div[@class='modal__footer']//button")
	public WebElement btnChangeShippingMethodDialogSaveAndContinueButton;
	/////////////////////////////////////////////////////////////
	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]")
	public WebElement cntShippingPaymentMethodSection;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//div[@class='paymentmethod__label']")
	public WebElement lblShippingPaymentMethodTitle;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//div[@class='paymentmethod__label']/following-sibling::div")
	public WebElement cntPaymentMethodContainer;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//div[@class='paymentmethod__label']/following-sibling::div//*[contains(@class,'tagCCImage')]")
	public WebElement iconPaymentMethod;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//div[@class='paymentmethod__error-wrap']")
	public WebElement lblPaymentMethodErrorMessage;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//div[@class='paymentmethod__description']")
	public WebElement lblPaymentMethod;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//button[@class='button__change']")
	public WebElement btnAddOrChangePaymentMethod;

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentMethodWrap')]//div[@class='paymentmethod__label']/following-sibling::div//*[contains(@class,'tag')]")
	public WebElement lblSelectedCardTypeForPayment;

	@FindBy(xpath = "//div[@class='ReactModalPortal']")
	public List<WebElement> lstReactModelPortalList;

	////////////////////////////////////////////////////////////
	//For popup dialog to add or change payment method by clicking btnAddOrChangePaymentMethod button
	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='modal__header']//h3")
	public WebElement lblAddOrChangePaymentMethodDialogTitle;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='modal__header']//button[@class='modal__button-close']")
	public WebElement btnAddOrChangePaymentMethodDialogCloseButton;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//div[@class='modal__header']//button[@class='modal__button-back']")
	public WebElement btnAddOrChangePaymentMethodDialogBackButton;

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

	@FindBy(xpath = "//label[@for='tscPaypal']")
	public WebElement labelAddOrChangePaymentMethodDialogPaypalRadio;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__overlay']//button[contains(@class,'modal__button--save')]")
	public WebElement btnAddOrChangePaymentMethodDialogSaveButton;

	//////////////////////////////////////////////////////////////////
	//For the popup window by clicking remove button
	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//h3")
	public WebElement lblRemoveCardDialogHeaderTitle;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//button[@class='modal__button-back']")
	public WebElement btnRemoveCardDialogGoBackButton;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//button[@class='modal__button-close']")
	public WebElement btnRemoveCardDialogCloseButton;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//div[@class='card__logo']")
	public WebElement iconRemoveCardDialogCloseCardLogo;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//div[@class='card__logo']/*")
	public WebElement lblRemoveCardDialogCardType;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//div[@class='card__detail']")
	public WebElement lblRemoveCardDialogCloseCardDetails;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//div[@class='paymentmethod__warn-wrap']")
	public WebElement lblRemoveCardDialogCloseWarningMessage;

	@FindBy(xpath = "//div[contains(@class,'ReactModal__Content')]//button[@class='modal__button--save button']")
	public WebElement btnRemoveCardDialogCloseRemoveButton;

	@FindBy(xpath = "//div[@class='card__body']//div[contains(@class,'error')]")
	public List<WebElement> lstCreditCardMandatoryErrorMessage;
	////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////
	//For the popup window by clicking using a new card button
	@FindBy(xpath = "//div[@class='modal__header']/h3")
	public WebElement lblUsingANewCardDialogTitle;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='card__header']")
	public WebElement lblUsingANewCardSelectTitle;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//button[contains(@class,'modal__button-back')]")
	public WebElement btnUsingANewCardDialogBackButton;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//button[contains(@class,'modal__button-close')]")
	public WebElement btnUsingANewCardDialogCloseButton;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='creditcard__selector-wrap']")
	public WebElement cntUsingANewCardDialogCreditCard;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='creditcard__selector--cc']//input")
	public WebElement inputUsingANewCardDialogCreditCardRadio;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='creditcard__selector--cc']//label")
	public WebElement labelUsingANewCardDialogCreditCardRadio;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='creditcard__selector--tsc']")
	public WebElement cntUsingANewCardDialogTSCCard;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='creditcard__selector--tsc']//input")
	public WebElement inputUsingANewCardDialogTSCCardRadio;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='creditcard__selector--tsc']//label")
	public WebElement labelUsingANewCardDialogTSCCardRadio;

	//For Credit card
	@FindBy(xpath = "//span[@id='semafoneResponseSpan']")
	public WebElement lblInvalidCreditCardErrorMessage;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='standardCCBlock']//h3[@class='semafone__cardnumber']")
	public WebElement lblUsingANewCardDialogCreditCardNumberTitle;

	@FindBy(xpath = "//div[@class='standardCCBlock']//iframe")
	public WebElement iframeUsingANewCardDialogCreditCardNumberInput;

	//The Credit card number input field in iframeUsingANewCardDialogCardNumberInput
	@FindBy(xpath = "//input[@id='pan']")
	public WebElement inputCreditCardNumberInIframe;

	@FindBy(xpath = "//input[@id='maskedPan']")
	public WebElement inputCreditCardMaskNumberInIframe;

	@FindBy(xpath = "//div[contains(@id,'CCNumberSemafone')]/input[@id='selectedNonTscCC']")
	public WebElement inputEditExistingCreditCard;

	@FindBy(xpath = "//div[@class='card__logo--verify']//*[contains(@class,'tagCCImage')]")
	public WebElement lblInputCreditCardNumberType;

	@FindBy(xpath = "//div[@id='CCNumberSemafoneInput']/following-sibling::div")
	public WebElement cntUsingANewCardDialogCreditExpirationContainer;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='standardCCBlock']//h3[@class='semafone__expiration-title']")
	public WebElement lblUsingANewCardDialogCreditExpirationDateTitle;

	@FindBy(xpath = "//div[@class='standardCCBlock']//input[@id='creditCardMonthId']")
	public WebElement inputUsingANewCardDialogCreditExpirationDateMonth;

	@FindBy(xpath = "//div[@class='standardCCBlock']//input[@id='creditCardYearId']")
	public WebElement inputUsingANewCardDialogCreditExpirationDateYear;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='standardCCBlock']//span[@class='semafone__expiration-title']")
	public WebElement lblUsingANewCardDialogCreditExpirationDateSlashBetweenMonthAndYear;

	@FindBy(xpath = "//div[@id='CCNumberSemafoneInput']/following-sibling::div//*[@class='semafone__cvv-title']")
	public WebElement lblUsingANewCardDialogCreditCVVTitle;

	@FindBy(xpath = "//div[@id='CCNumberSemafoneInput']/following-sibling::div//*[@class='semafone__cvv-title']/div[not(@class='cvv__tooltip--msg')]")
	public WebElement iconUsingANewCardDialogCreditCVVTooltip;

	@FindBy(xpath = "//div[@id='CCNumberSemafoneInput']/following-sibling::div//*[@class='semafone__cvv-title']/div[@class='cvv__tooltip--msg']")
	public WebElement lblUsingANewCardDialogCreditCVVTooltipMessage;

	@FindBy(xpath = "//div[@id='CCNumberSemafoneInput']/following-sibling::div//*[@class='semafone__cvv-title']/div[@class='cvv__tooltip--msg']//div[@class='cvv__tooltip--close']")
	public WebElement btnUsingANewCardDialogCreditCVVTooltipCloseButton;

	@FindBy(xpath = "//div[@id='CCNumberSemafoneInput']/following-sibling::div//input[@id='creditCardCvvId']")
	public WebElement inputUsingANewCardDialogCreditCVV;

	//For TSC card
	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='tscBlock']//h3[@class='semafone__cardnumber']")
	public WebElement lblUsingANewCardDialogTSCCardNumberTitle;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//div[@class='tscBlock']//input[@id='tscCC']")
	public WebElement inputUsingANewCardDialogTSCCardNumber;

	@FindBy(xpath = "//div[contains(@aria-label,'Use A New Card') or contains(@aria-label,'Edit Payment Card')]//button[contains(@class,'modal__button--save')]")
	public WebElement btnUsingANewCardDialogSaveButton;

	/////////////////////////////////////////////////////////

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'billingAddressWrap')]")
	public WebElement cntBillingAddressSection;

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

	@FindBy(xpath = "//article[@class='leftSide']//div[contains(@class,'paymentOptionWrap')]//div[@class='paymentoption__description']")
	public WebElement lblPaymentOptionTextForOrderModification;

	//For Order Summary section
	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//h2")
	public WebElement lblOrderSummaryTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Sub-total')]|//div[contains(@class,'summary')]//div[@class='summary__label--wide' and contains(.,'Subtotal')]")
	public WebElement lblOrderSummarySubTotalTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Sub-total')]/following-sibling::span[@class='summary__value']|//div[contains(@class,'summary')]//div[@class='summary__label--wide' and contains(.,'Subtotal')]/following-sibling::div[@class='summary__value']")
	public WebElement lblOrderSummarySubTotal;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Shipping')]|//div[contains(@class,'summary')]//div[@class='summary__label--wide' and contains(.,'Shipping')]")
	public WebElement lblOrderSummaryShippingTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Shipping')]/following-sibling::span[@class='summary__value']|//div[contains(@class,'summary')]//div[@class='summary__label--wide' and contains(.,'Shipping')]/following-sibling::div[@class='summary__value']")
	public WebElement cntOrderSummaryShippingPriceContainer;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Shipping')]/following-sibling::span[@class='summary__value']//del")
	public WebElement lblOrderSummaryShippingWasPrice;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Est Taxes')]|//div[contains(@class,'summary')]//div[@class='summary__label--wide' and contains(.,'Est. Taxes')]")
	public WebElement lblOrderSummaryTaxTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Est Taxes')]/following-sibling::span[@class='summary__value']|//div[contains(@class,'summary')]//div[@class='summary__label--wide' and contains(.,'Est. Taxes')]/following-sibling::div[@class='summary__value']")
	public WebElement lblOrderSummaryTax;

	//For applied discount items
	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__label' and contains(text(),'Est Taxes')]/parent::div/following-sibling::div[1]")
	public WebElement cntOrderSummaryAppliedDiscount;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//div[@class='summary']/div[@class='summary__row']")
	public List<WebElement> lstOrderSummaryRow;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//b[contains(text(),'Applied Discounts')]")
	public WebElement lblOrderSummaryAppliedDiscountTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//b[.='Applied Discounts']/parent::span/parent::div/following-sibling::div[@class='summary__row'][not(contains(@class,'justifyCenter'))][not(span[contains(@class,'bold')])]")
	public List<WebElement> lstOrderSummaryAppliedDiscountList;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//b[contains(text(),'Applied Discounts')]/parent::span/parent::div/following-sibling::div//span[contains(@class,'summary__label')][not(contains(.,'Gift Card'))]")
	public WebElement lblOrderSummaryPromoteCodeLabel;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//b[contains(text(),'Applied Discounts')]/parent::span/parent::div/following-sibling::div//span[contains(@class,'summary__label')][not(contains(.,'Gift Card'))]/following-sibling::span[@class='summary__value']")
	public WebElement lblOrderSummaryPromoteCodeValue;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//b[contains(text(),'Applied Discounts')]/parent::span/parent::div/following-sibling::div//span[contains(@class,'summary__label')][contains(.,'Gift Card')]")
	public WebElement lblOrderSummaryGiftCardLabel;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//b[contains(text(),'Applied Discounts')]/parent::span/parent::div/following-sibling::div//span[contains(@class,'summary__label')][contains(.,'Gift Card')]/following-sibling::span[@class='summary__value']")
	public WebElement lblOrderSummaryGiftCardValue;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[contains(@class,'summary__label') and contains(text(),'TOTAL PRICE')]|//div[contains(@class,'summary')]//div[@class='summary__label--wide' and contains(.,'Total')]")
	public WebElement lblOrderSummaryTotalPriceTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[contains(@class,'summary__label') and contains(text(),'TOTAL PRICE')]/following-sibling::span[contains(@class,'summary__value')]|//div[contains(@class,'summary')]//div[@class='summary__label--wide' and contains(.,'Total')]/following-sibling::div[@class='summary__value']")
	public WebElement lblOrderSummaryTotalPrice;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//div[@class='summary']/div[contains(@class,'summary__row')][last()]")
	public WebElement lblOrderSummaryLastItem;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[@class='summary__savingmsg']")
	public WebElement lblOrderSummarySavingPrice;

	// Changes for orderModificationPage
	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[contains(@class,'summary__label') and contains(text(),'NEW TOTAL PRICE')]")
	public WebElement lblOrderSummaryNewTotalPriceTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[contains(@class,'summary__label') and contains(text(),'NEW TOTAL PRICE')]/following-sibling::span[last()]")
	public WebElement lblOrderSummaryNewTotalPrice;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[contains(@class,'summary__label') and contains(text(),'Original Order Total')]")
	public WebElement lblOrderSummaryOriginalOrderTotalTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[contains(@class,'summary__label') and contains(text(),'Original Order Total')]/following-sibling::span[last()]")
	public WebElement lblOrderSummaryOriginalOrderTotal;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[contains(@class,'summary__label') and contains(text(),'Change to Order Total')]")
	public WebElement lblOrderSummaryChangeToOrderTotalTitle;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]//span[contains(@class,'summary__label') and contains(text(),'Change to Order Total')]/following-sibling::span[last()]")
	public WebElement lblOrderSummaryChangeToOrderTotal;

	//For Installment
	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'OrderSummaryWrap')]/div[contains(@class,'summary')]")
	public WebElement cntEasyPayContainer;

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

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//h3[@class='promocode__title']/*[contains(@class,'promocode__tooltip--msg')]")
	public WebElement lblOrderSummaryPromoteCodeTooltipMessage;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]")
	public WebElement cntOrderSummaryPromoteCodeContainer;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//input[@id='promo']")
	public WebElement inputOrderSummaryPromoteCode;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//button[@class='promocode__button--white button']")
	public WebElement btnOrderSummaryPromoteCodeApply;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//div[contains(@class,'promocode__code')]")
	public WebElement lblOrderSummaryInputPromoteCode;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//button[@class='promocode__button--remove']")
	public WebElement btnOrderSummaryRemovePromoteCode;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//b[@class='promocode__message']")
	public WebElement lblOrderSummaryPromoteCodeAppliedMessage;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'promocode__container')]//div[contains(@class,'alert-danger')]")
	public WebElement lblOrderSummaryPromoteCodeErrorMessage;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'giftcard__container')]")
	public WebElement cntOrderSummaryGiftCardContainer;

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

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'giftcard__container')]//div[contains(@class,'promocode__code')]")
	public WebElement lblOrderSummaryInputGiftCard;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'giftcard__container')]//button[@class='promocode__button--remove']")
	public WebElement btnOrderSummaryRemoveGiftCard;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'giftcard__container')]//b")
	public WebElement lblOrderSummaryGiftCardAppliedMessage;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'giftcard__container')]//div[contains(@class,'alert-danger')]")
	public WebElement lblOrderSummaryGiftCardErrorMessage;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'placeorder__wrap')]//button[contains(@class,'placeorder__button--black')]")
	public WebElement btnOrderSummaryPlaceOrder;

	@FindBy(xpath = "//aside[@class='rightSide']//div[contains(@class,'placeorder__wrap')]//div[contains(@class,'placeorder__reserve-msg')]")
	public WebElement lblOrderSummaryPlaceOrderMessage;

	@FindBy(xpath = "//div[@id='order-confirmation']//button[contains(text(),'Order Details')]")
	public WebElement btnGoToOrderDetailsFromOrderConfirmation;

	//For footer
	@FindBy(xpath = "//footer")
	public WebElement cntFooterContainer;

	@FindBy(xpath = "//footer//a[contains(@href,'aboutustandc')]")
	public WebElement lnkTermsOfUse;

	@FindBy(xpath = "//footer//a[contains(@href,'aboutusprivacy')]")
	public WebElement lnkPrivacyPolicy;

	//Error Message for Mandatory Items
	@FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay')]//div[contains(@class,'alert-danger')]")
	public List<WebElement> mandatoryFieldErrorMessage;

	//PayPal
	@FindBy(xpath = "//iframe[contains(@name,'paypal')]")
	public WebElement framePayPalFrameElement;

	@FindBy(xpath = "//div[@id='buttons-container']//div[contains(@class,'paypal-button-container')]")
	public WebElement btnPayPalButton;

	@FindBy(xpath = "//div[@id='splitEmail']//input[@id='email']")
	public WebElement inputPayPalEmailInput;

	@FindBy(xpath = "//div[@id='splitEmail']//button[@value='Next']")
	public WebElement btnPayPalNextButton;

	//For order modification, to identify

	/**
	 * To check Alert Message In Header Existing
	 * @return - boolean
	 */
	public boolean checkAlertMessageInHeaderExisting(){
		return this.checkChildElementExistingByAttribute(this.cntProductOrderSection,"class","alert");
	}

	/**
	 * To expand Product List
	 * @return - boolean
	 */
	public boolean expandProductList(){
		if(!checkProductCollapseStatus()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCollapseProductList);
			this.clickElement(btnCollapseProductList);
			this.waitForCondition(Driver->{return checkProductCollapseStatus();},10000);
		}
		return true;
	}

	/**
	 * To unCollapse Product List
	 * @return - boolean
	 */
	public boolean unCollapseProductList(){
		if(checkProductCollapseStatus()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCollapseProductList);
			this.clickElement(btnCollapseProductList);
			this.waitForCondition(Driver->{return !checkProductCollapseStatus();},10000);
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
	 * To check Item Being Added Product Section Expanded For OrderModification
	 * @return - boolean
	 */
	public boolean checkItemBeingAddedProductSectionExpandedForOrderModification(){
		boolean bFound=false;
		String[] lstClass=btnItemBeingAdded.getAttribute("class").split(" ");
		for(String lsClass:lstClass){
			if(lsClass.equalsIgnoreCase("collapse")){
				bFound=true;
				break;
			}
		}

		return bFound;
	}

	/**
	 * To check existing Items Product Section Expanded For OrderModification
	 * @return - boolean
	 */
	public boolean checkExistingItemsProductSectionExpandedForOrderModification(){
		boolean bFound=false;
		String[] lstClass=btnExistingItems.getAttribute("class").split(" ");
		for(String lsClass:lstClass){
			if(lsClass.equalsIgnoreCase("collapse")){
				bFound=true;
				break;
			}
		}

		return bFound;
	}

	/**
	 * To expand Item Being Added Product Section For OrderModification
	 */
	public void expandItemBeingAddedProductSectionForOrderModification(){
		if(!checkItemBeingAddedProductSectionExpandedForOrderModification()){
			this.clickElement(btnItemBeingAdded);
			this.waitForCondition(Driver->{return checkItemBeingAddedProductSectionExpandedForOrderModification();},10000);
		}
	}

	/**
	 * To expand existing items Product Section For OrderModification
	 */
	public void expandExistingItemsProductSectionForOrderModification(){
		if(!checkExistingItemsProductSectionExpandedForOrderModification()){
			this.clickElement(btnExistingItems);
			this.waitForCondition(Driver->{return checkExistingItemsProductSectionExpandedForOrderModification();},10000);
		}
	}

	/**
	 * To check Product number Existing
	 * @param - WebElement - productItem - the item in product list
	 * @return - boolean
	 */
	public boolean checkProductNumberExisting(WebElement productItem){
		WebElement item=productItem.findElement(this.byProductNumberContainer);
		return this.checkChildElementExistingByAttribute(item,"class","productlist__itemnumber");
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
	 * To check Product shipping date Existing
	 * @param - WebElement - productItem - the item in product list
	 * @return - boolean
	 */
	public boolean checkProductShippingDateExisting(WebElement productItem){
		return this.checkChildElementExistingByAttribute(productItem,"class","estimateDateCheckout__lineItem");
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
	 * To check Change Shipping Method Button Existing
	 * @return - boolean
	 */
	public boolean checkChangeShippingMethodButtonExisting(){
		return this.checkChildElementExistingByAttribute(cntChangeShippingMethodContainer,"class","button__change");
	}

	/**
	 * To check Payment Method Existing
	 * @return - boolean
	 */
	public boolean checkPaymentMethodTypeExisting(){
		return this.checkChildElementExistingByAttribute(cntPaymentMethodContainer,"class","paymentmethod__description");
	}

	/**
	 * To check If Payment Method Is TSC
	 * @return - boolean
	 */
	public boolean checkIfPaymentMethodIsTSC(){
		this.applyStaticWait(this.getStaticWaitForApplication());
		return this.iconPaymentMethod.getAttribute("class").contains("tagCCImageTSC");
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
		boolean bDel=this.checkChildElementExistingByTagName(cntOrderSummaryShippingPriceContainer,"del");
		if(bDel){
			return !this.getElementInnerText(lblOrderSummaryShippingWasPrice).isEmpty();
		}
		else{
			return false;
		}
	}

	/**
	 * To check Saving price Existing in OrderSummary
	 * @return - boolean
	 */
	public boolean checkOrderSummarySavingPriceExisting(){
		return this.getElementInnerText(lblOrderSummaryLastItem).toLowerCase().contains("you’re saving");
	}

	/**
	 * To check Applied Discount Existing In OrderSummary
	 * @return - boolean
	 */
	public boolean checkAppliedDiscountExistingInOrderSummary(){
		return this.lstOrderSummaryRow.size()>4;
	}

	/**
	 * To check Applied Discount Existing In OrderSummary for orderModification
	 * @return - boolean
	 */
	public boolean checkAppliedDiscountExistingInOrderSummaryForOrderModification(){
		return this.lstOrderSummaryRow.size()>6;
	}

	/**
	 * To judge Applied Discount item Type
	 * @return -String - "Both"/"GiftCard"/"PromoteCode"
	 */
	public String judgeAppliedDiscountType(){
		if(checkAppliedDiscountExistingInOrderSummary()){
			if(this.lstOrderSummaryAppliedDiscountList.size()==2){
				return "Both";
			}

			WebElement item=this.lstOrderSummaryAppliedDiscountList.get(0);
			if(this.getElementInnerText(item).toLowerCase().contains("gift card")){
				return "GiftCard";
			}
			else{
				return "PromoteCode";
			}
		}
		else{
			return null;
		}
	}

	/**
	 * To check EasyPay Section Existing
	 * @return - boolean
	 */
	public boolean checkEasyPaySectionExisting(){
		return this.checkChildElementExistingByAttribute(cntEasyPayContainer,"class","easypay__container");
	}

	/**
	 * To check Promote Code tooltip Message Displaying
	 * @return - boolean
	 */
	public boolean checkPromoteCodeTooltipMessageDisplaying(){
		return this.checkChildElementExistingByAttribute(cntOrderSummaryPromoteCodeTooltip,"class","promocode__tooltip--msg");
	}

	/**
	 * To check Promote Code remove button existing
	 * @return - boolean
	 */
	public boolean checkPromoteCodeRemoveButtonExisting(){
		return this.checkChildElementExistingByAttribute(cntOrderSummaryPromoteCodeContainer,"class","promoremove__container");
	}

	/**
	 * To check Promote Code gift card button existing
	 * @return - boolean
	 */
	public boolean checkGiftCardRemoveButtonExisting(){
		return this.checkChildElementExistingByAttribute(cntOrderSummaryGiftCardContainer,"class","promoremove__container");
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
					map.put("productSize",lsSplit[1].split(":")[1].trim());
				}
				else{
					map.put("productName",lsSplit[0].trim());
					map.put("productStyle",lsSplit[1].split(":")[1].trim());
					map.put("productSize",null);
				}
			}
			else{
				map.put("productName",lsSplit[0].trim());
				map.put("productStyle",lsSplit[2].split(":")[1].trim());
				map.put("productSize",lsSplit[1].split(":")[1].trim());
			}
		}
		else{
			map.put("productName",lsText.trim());
			map.put("productStyle",null);
			map.put("productSize",null);
		}

		if(this.checkProductNumberExisting(productItem)){
			item=productItem.findElement(byProductNumber);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().replace("-","").trim();
			map.put("productNumber",lsText);
		}
		else{
			map.put("productNumber",null);
		}

		item=productItem.findElement(byProductNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().trim();
		if(lsText.toLowerCase().contains("free")){
			map.put("productNowPrice",0.0f);
		}
		else{
			map.put("productNowPrice",this.getFloatFromString(lsText));
		}

		item=productItem.findElement(byProductSelectQuantity);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=this.getElementInnerText(item).split(":")[1].trim();
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
			map.put("productLeftNumber",-1);
		}

		if(this.checkProductFreeShippingExisting(productItem)){
			item=productItem.findElement(byProductFreeShipping);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			if(lsText.contains(":")){
				lsText=lsText.split(":")[1];
			}
			map.put("productFreeShipping",lsText);
		}
		else{
			map.put("productFreeShipping",null);
		}

		if(checkProductShippingDateExisting(productItem)){
			item=productItem.findElement(byProductShippingDate);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productShippingDate",lsText.split(":")[1].trim());
			map.put("productShippingDateForAll",false);
		}
		else{
			if(this.checkProductShippingDateExisting()){
				lsText = this.lblGetItByDate.getText();
				map.put("productShippingDate",lsText);
				map.put("productShippingDateForAll",true);
			}
			else{
				map.put("productShippingDate",null);
				map.put("productShippingDateForAll",false);
			}
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
	 * To get Shipping And Payment Description
	 * @param - Map<String,Object> - checkoutItem
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getShippingAndPaymentDesc(Map<String,Object> checkoutItem) {
		String lsText;
		Map<String, Object> map = new HashMap<>();

		if(this.checkProductShippingDateExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingDate);
			lsText=lblShippingDate.getText().trim();
			if(lsText.contains(":")){
				lsText=lsText.split(":")[1];
			}
			map.put("shippingDate",lsText);
		}
		else{
			lsText=checkoutItem.get("productShippingDate").toString();
			map.put("shippingDate",lsText);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingAddress);
		lsText=lblShippingAddress.getText().trim();
		map.put("shippingAddress",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingMethod);
		lsText=lblShippingMethod.getText().trim();
		map.put("shippingMethod", lsText.split("-")[0].trim());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentMethod);
		lsText=lblPaymentMethod.getText().trim();
		map.put("paymentMethodDescription",lsText);
		map.put("paymentMethod",getSelectedPaymentMethodFromCheckout(lblSelectedCardTypeForPayment));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblBillingAddress);
		lsText=lblBillingAddress.getText().trim();
		map.put("billingAddress",lsText);

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
				return this.getMultiFloatFromString(lsText).get(1);
			}
			else{
				return this.getMultiFloatFromString(lsText).get(0);
			}
		}
	}

	/**
	 * To get promote code value in Order Summary section
	 * @return - float
	 */
	public float getPromoteCodeValueInOrderSummary(){
		String lsText=this.getElementInnerText(this.lblOrderSummaryPromoteCodeValue);
		if(lsText.equalsIgnoreCase("-")){
			return 0.0f;
		}
		else{
			if(lsText.contains("-")){
				return -1*this.getFloatFromString(lsText,true);
			}
			else{
				return this.getFloatFromString(lsText,true);
			}
		}
	}

	/**
	 * To get gift card value in Order Summary section
	 * @return - float
	 */
	public float getGiftCardValueInOrderSummary(){
		String lsText=this.getElementInnerText(this.lblOrderSummaryGiftCardValue);
		if(lsText.equalsIgnoreCase("-")){
			return 0.0f;
		}
		else{
			if(lsText.contains("-")){
				return -1*this.getFloatFromString(lsText,true);
			}
			else{
				return this.getFloatFromString(lsText,true);
			}
		}
	}

	/**
	 * To get gift card value in promote section
	 * @return - float
	 */
	public float getGiftCardValueInPromoteSection(){
		String lsText=this.getElementInnerText(this.lblOrderSummaryGiftCardAppliedMessage);
		return this.getFloatFromString(lsText,true);
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
	 * To get Saving Price From OrderSummary
	 * @return - float
	 */
	public float getSavingPriceFromOrderSummary(){
		if(this.checkOrderSummarySavingPriceExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummarySavingPrice);
			String lsText=this.lblOrderSummarySavingPrice.getText();
			return this.getFloatFromString(lsText);
		}
		else{
			return 0.0f;
		}
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
	public Map<String,Object> addOrEditShippingAddress(Map<String,String> address,boolean addNewAddress,boolean editExistingAddress){
		String lsFirstName,lsLastName,lsPhoneNumber;
		String[] data;
		if(addNewAddress){
			if(address.size()>0){
				lsFirstName = address.get("firstName");
				lsLastName = address.get("lastName");
				lsPhoneNumber = address.get("phoneNumber");
				data = address.get("address").trim().split("");
			}else{
				lsFirstName= DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(5,"lowerStringType");
				lsLastName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(7,"lowerStringType");
				lsPhoneNumber="647"+DataConverter.getSaltString(7,"numberType");

				String lsAutoSearchKeyword = DataConverter.getSaltString(4,"numberType");
				data = lsAutoSearchKeyword.codePoints().mapToObj(cp->new String(Character.toChars(cp))).toArray(size->new String[size]);
			}
		}else{
			lsFirstName = address.get("firstName");
			lsLastName = address.get("lastName");
			lsPhoneNumber = address.get("phoneNumber");
			data = address.get("address").trim().split("");

			//Click on Edit Button for address to be updated
			this.getReusableActionsInstance().clickIfAvailable(this.btnEditButtonAddChangeShippingAddressDialog);
			this.waitForCondition(Driver->{return inputAddOrEditAddressDialogFirstName.isDisplayed() &&
					inputAddOrEditAddressDialogFirstName.isEnabled();},5000);
			this.verifyShippingAddressIsPopulatedForEdit();
		}

		this.inputAddressOnDialog(lsFirstName,lsLastName,lsPhoneNumber,data);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogAddress);
		String lsAddress=inputAddOrEditAddressDialogAddress.getAttribute("value").trim();

		Map<String,Object> map=new HashMap<>();
		map.put("firstName",lsFirstName);
		map.put("lastName",lsLastName);
		map.put("phoneNumber",lsPhoneNumber);
		map.put("address",lsAddress);
		map.put("city",this.inputAddOrEditAddressDialogCity.getAttribute("value"));
		map.put("province",this.getReusableActionsInstance().getSelectedValue(this.selectAddOrEditAddressDialogProvince));
		map.put("postalCode",this.inputAddOrEditAddressDialogPostalCode.getAttribute("value"));

		//Clicking on Save Button
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddOrEditAddressDialogSaveButton);
		this.getReusableActionsInstance().clickIfAvailable(this.btnAddOrEditAddressDialogSaveButton);
		waitForPageLoadingSpinningStatusCompleted();
		if(addNewAddress && editExistingAddress){
			//Error Message will appear as we are entering same address that is already present, hence capture error message and close the dialog box
			List<String> errorMessageList = this.getMandatoryFieldsErrorMessage(0);
			map.put("errorMessage",errorMessageList.get(0));
			if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangeShippingAddressDialogBackButton);
				btnAddOrChangeShippingAddressDialogBackButton.click();
				this.applyStaticWait(2*getStaticWaitForApplication());
			}else{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddOrChangeShippingAddressDialogCloseButton);
				this.getReusableActionsInstance().clickIfAvailable(this.btnAddOrChangeShippingAddressDialogCloseButton);
			}
			this.waitForCondition(Driver->{return this.btnAddOrChangeShippingAddressDialogAddNewAddressButton.isDisplayed() &&
			this.btnAddOrChangeShippingAddressDialogAddNewAddressButton.isEnabled();},5000);
		}else if(!addNewAddress && editExistingAddress){

		}
		return map;
	}

	public void inputAddressOnDialog(String lsFirstName,String lsLastName,String lsPhoneNumber, String[] data){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogFirstName);
		inputAddOrEditAddressDialogFirstName.clear();
		inputAddOrEditAddressDialogFirstName.sendKeys(lsFirstName);
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogLastName);
		inputAddOrEditAddressDialogLastName.clear();
		inputAddOrEditAddressDialogLastName.sendKeys(lsLastName);
		this.getReusableActionsInstance().staticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogPhoneNumber);
		inputAddOrEditAddressDialogPhoneNumber.clear();
		inputAddOrEditAddressDialogPhoneNumber.sendKeys(lsPhoneNumber);
		this.getReusableActionsInstance().staticWait(300);

		inputAddOrEditAddressDialogAddress.clear();
		int length = inputAddOrEditAddressDialogAddress.getAttribute("value").trim().length();
		if(length>1){
			inputAddOrEditAddressDialogAddress.click();
			for(int counter=0;counter<length;counter++)
				inputAddOrEditAddressDialogAddress.sendKeys(Keys.BACK_SPACE);
			this.applyStaticWait(2000);
		}
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
		this.waitForCondition(Driver->{return this.cntAddOrEditAddressDialogAddressDropDownList.getAttribute("class").contains("react-autosuggest__suggestions-container--open");},20000);
		this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());

		if(this.lstAddOrEditAddressDialogAddressDropDownList.size()>1){
			reporter.reportLogPass("Getting dropdown auto search results successfully");
		}
		else{
			reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
		}

		int optionSize=this.lstAddOrEditAddressDialogAddressDropDownList.size();
		int randomNumber=0;
		if(optionSize>2){
			Random rand = new Random();
			randomNumber = rand.nextInt(optionSize-2);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressDialogAddressDropDownList.get(randomNumber));
		this.clickWebElementUsingJS(this.lstAddOrEditAddressDialogAddressDropDownList.get(randomNumber));
		this.waitForCondition(Driver->{return !this.cntAddOrEditAddressDialogAddressDropDownList.getAttribute("class").contains("react-autosuggest__suggestions-container--open");},20000);

		//Wait for province and postal code update
		this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());
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
		this.clickElement(btnShippingAddressAddOrChange);
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
			waitForPageLoadingSpinningStatusCompleted();
		}
		else{
			if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangeShippingAddressDialogBackButton);
				btnAddOrChangeShippingAddressDialogBackButton.click();
			}
			else{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangeShippingAddressDialogCloseButton);
				btnAddOrChangeShippingAddressDialogCloseButton.click();
			}
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
			waitForPageLoadingSpinningStatusCompleted();
		}
		else{
			if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogBackButton);
				btnAddOrEditAddressDialogBackButton.click();
			}
//			if(System.getProperty("Device").equalsIgnoreCase("Mobile") ||
//					(System.getProperty("Device").equalsIgnoreCase("Tablet") &&
//							System.getProperty("Browser").contains("android")) ||
//					(System.getProperty("Browser").equalsIgnoreCase("chromemobile") &&
//							!System.getProperty("chromeMobileDevice").contains("iPad"))){
//				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogBackButton);
//				btnAddOrEditAddressDialogBackButton.click();
//			}
			else{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogCloseButton);
				this.clickWebElementUsingJS(btnAddOrEditAddressDialogCloseButton);
				//btnAddOrEditAddressDialogCloseButton.click();
			}
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}

	/**
	 * To open Change Shipping Method Dialog
	 * @return - boolean
	 */
	public boolean openChangeShippingMethodDialog(){
		this.waitForCondition(Driver->{return this.btnChangeShippingMethod.isDisplayed();},10000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeShippingMethod);
		this.clickElement(btnChangeShippingMethod);
		return this.waitForCondition(Driver->{return this.lblChangeShippingMethodDialogHeaderTitle.isDisplayed();},10000);
	}

	/**
	 * To close Change Shipping Method Dialog
	 * @param -boolean - bSave - true for save and false for close it directly
	 */
	public void closeChangeShippingMethodDialog(boolean bSave){
		if(bSave){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeShippingMethodDialogSaveAndContinueButton);
			btnChangeShippingMethodDialogSaveAndContinueButton.click();
			waitForPageLoadingSpinningStatusCompleted();
		}
		else{
			if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeShippingMethodDialogBackButton);
				btnChangeShippingMethodDialogBackButton.click();
			}else{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeShippingMethodDialogCloseButton);
				btnChangeShippingMethodDialogCloseButton.click();
			}
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}

	/**
	 * To get Shipping Price From Shipping Method Section
	 * @return - float
	 */
	public float getShippingPriceFromShippingMethodSection(){
		String lsText=this.getElementInnerText(lblShippingMethod).replace("-","");
		if(lsText.toLowerCase().contains("free")){
			return 0.0f;
		}
		else{
			return this.getFloatFromString(lsText);
		}
	}

	/**
	 * To change Shipping Method In Change Shipping Method Dialog
	 * @return - float - shipping price, note that return -1.0 represents no returning value
	 */
	public float changeShippingMethodInChangeShippingMethodDialog(){
		WebElement item;
		for(WebElement shippingMethodItem:lstChangeShippingMethodDialogShippingMethodList){
			item=shippingMethodItem.findElement(byShippingMethodInput);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			if(!item.isSelected()){
				item=shippingMethodItem.findElement(byShippingMethodPrice);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				String lsText=this.getElementInnerText(item).replace("-","");
				float shippingPrice=this.getFloatFromString(lsText,true);
				item.click();
				this.applyStaticWait(300);
				return shippingPrice;
			}
		}
		return -1.0f;
	}

	/**
	 * To choose Shipping Method In Change Shipping Method Dialog with given index
	 * @param - int - selectedIndex - given index
	 */
	public void chooseShippingMethodInChangeShippingMethodDialogWithGivenIndex(int selectedIndex){
		WebElement item=lstChangeShippingMethodDialogShippingMethodList.get(selectedIndex);
		WebElement itemLabel=item.findElement(byShippingMethodPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(itemLabel);
		itemLabel.click();
		this.applyStaticWait(300);
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
		this.clickElement(btnAddOrChangePaymentMethod);
		return this.waitForCondition(Driver->{return this.lblAddOrChangePaymentMethodDialogTitle.isDisplayed();},10000);
	}

	/**
	 * To close Add/Change Payment Method Dialog
	 * @param -boolean - bSave - true for save and false for close it directly
	 */
	public void closeAddOrChangePaymentMethodDialog(boolean bSave){
		this.waitForCondition(Driver->{return this.btnAddOrChangePaymentMethodDialogSaveButton.isEnabled();},5000);
		if(bSave){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogSaveButton);
			btnAddOrChangePaymentMethodDialogSaveButton.click();
			waitForPageLoadingSpinningStatusCompleted();
		}
		else{
			if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogBackButton);
				btnAddOrChangePaymentMethodDialogBackButton.click();
			}
			else{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogCloseButton);
				btnAddOrChangePaymentMethodDialogCloseButton.click();
			}
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}

	/**
	 * To get edit Button With Given Index in Add/Change payment method list
	 * @param - int - selectedIndex
	 * @return - edit button
	 */
	public WebElement getPaymentMethodEditButtonWithGivenIndex(int selectedIndex){
		WebElement itemContainer=this.lstAddOrChangePaymentMethodDialogAvailableCardContainer.get(selectedIndex);
		return itemContainer.findElement(this.byAddOrChangePaymentMethodDialogEditButton);
	}

	/**
	 * To get Remove Button With Given Index in Add/Change payment method list
	 * @param - int - selectedIndex
	 * @return - remove button
	 */
	public WebElement getPaymentMethodRemoveButtonWithGivenIndex(int selectedIndex){
		WebElement itemContainer=this.lstAddOrChangePaymentMethodDialogAvailableCardContainer.get(selectedIndex);
		return itemContainer.findElement(this.byAddOrChangePaymentMethodDialogRemoveButton);
	}

	/**
	 * To open Remove Payment Method Dialog
	 * @return - boolean
	 */
	public boolean openRemovePaymentMethodDialog(WebElement removeButton){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(removeButton);
		removeButton.click();
		return this.waitForCondition(Driver->{return this.getElementInnerText(lblRemoveCardDialogHeaderTitle).equalsIgnoreCase("REMOVE PAYMENT CARD");},10000);
	}

	/**
	 * To close remove Payment Method Dialog
	 * @param -boolean - bSave - true for save and false for close it directly
	 */
	public void closeRemovePaymentMethodDialog(boolean bSave){
		if(bSave){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveCardDialogCloseRemoveButton);
			btnRemoveCardDialogCloseRemoveButton.click();
			waitForPageLoadingSpinningStatusCompleted();
			this.applyStaticWait(5*getStaticWaitForApplication());
		}
		else{
			if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveCardDialogGoBackButton);
				btnRemoveCardDialogGoBackButton.click();
			}
			else{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveCardDialogCloseButton);
				btnRemoveCardDialogCloseButton.click();
			}
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}

	/**
	 * This function verifies remove payment method for Payment Type
	 * @param - boolean - removeCard
	 */
	public void verifyRemovePaymentMethodForUser(boolean removeCard){
		int totalCardAfterRemove = 0;
		int totalCardWebElements = this.lstAddOrChangePaymentMethodDialogAvailableCardContainer.size();
		Map<String,Object> paymentMethodSelectedCard = this.getSelectedCardDetailsFromPaymentDialog();
		WebElement removeButton = ((WebElement) paymentMethodSelectedCard.get("webElement")).findElement(this.byAddOrChangePaymentMethodDialogRemoveButton);
		this.clickWebElementUsingJS(removeButton);
		this.verifyRemovePaymentMethodDialogContents();
		boolean flag = this.verifyPaymentMethodRemoveDialogData(paymentMethodSelectedCard.get("cardLogo").toString(),paymentMethodSelectedCard.get("cardDetails").toString());
		if(removeCard){
			this.closeRemovePaymentMethodDialog(true);
			this.waitForPageLoadingSpinningStatusCompleted();
			//Verify that no of cards now is one less
			totalCardAfterRemove = this.lstAddOrChangePaymentMethodDialogAvailableCardContainer.size();
			if(totalCardAfterRemove == totalCardWebElements-1)
				reporter.reportLogPass("Credit Card is removed from Payment Dialog pop up for user as expected");
			else
				reporter.reportLogFailWithScreenshot("Credit Card is not removed from Payment Dialog for user");

			//Verify selected card on payment dialog with checkout page
			Map<String,Object> selectedPaymentMethodAfterDelete = this.getSelectedCardDetailsFromPaymentDialog();
			this.closeRemovePaymentMethodDialog(false);
			//Fetching Data from checkout page for selected payment method
			String cardType = this.getSelectedPaymentMethodFromCheckout(this.lblSelectedCardTypeForPayment);
			if(cardType.equalsIgnoreCase(selectedPaymentMethodAfterDelete.get("cardLogo").toString()))
				reporter.reportLogPass("Card Logo selected on checkout is same as expected");
			else
				reporter.reportLogFailWithScreenshot("Card Logo selected on checkout: "+cardType+" is not as expected: "+selectedPaymentMethodAfterDelete.get("cardLogo").toString());
			String cardNumber = this.lblSelectedCardTypeForPayment.getText();
			if(selectedPaymentMethodAfterDelete.get("cardDetails").toString().contains(cardNumber))
				reporter.reportLog("Card Number on checkout for Payment Type is same as expected");
			else
				reporter.reportLogFailWithScreenshot("Card Number on checkout for Payment Type is not same as expected");
		}else{
			this.closeRemovePaymentMethodDialog(false);
			totalCardAfterRemove = this.lstAddOrChangePaymentMethodDialogAvailableCardContainer.size();
			if(totalCardAfterRemove == totalCardWebElements)
				reporter.reportLogPass("Credit Card is same as expected on Payment Dialog for user without delete");
			else
				reporter.reportLogFailWithScreenshot("Credit Card is removed from Payment Dialog for user");
		}

		if(flag)
			reporter.reportLog("Remove pop up data is verified as expected");
		else
			reporter.reportLogFail("Remove pop up data is not verified..");
	}

	/**
	 * This function to remove all payment methods for user
	 */
	public void removeAllPaymentMethodsForUser(){
		int totalCardWebElements = this.lstAddOrChangePaymentMethodDialogAvailableCardContainer.size();
		for(int i=0;i<totalCardWebElements-1;i++){
			Map<String,Object> paymentMethodSelectedCard = this.getSelectedCardDetailsFromPaymentDialog();
			WebElement removeButton = ((WebElement) paymentMethodSelectedCard.get("webElement")).findElement(this.byAddOrChangePaymentMethodDialogRemoveButton);
			this.clickWebElementUsingJS(removeButton);
			this.closeRemovePaymentMethodDialog(true);
			this.waitForPageLoadingSpinningStatusCompleted();
		}
	}

	public Map<String,Object> getSelectedCardDetailsFromPaymentDialog(){
		WebElement cardType;
		String selectedText;
		Boolean flag = false;
		Map<String,Object> object = new HashMap<>();
		int totalCardWebElements = this.lstAddOrChangePaymentMethodDialogAvailableCardContainer.size();
		for(int counter=0;counter<totalCardWebElements;counter++){
			cardType=lstAddOrChangePaymentMethodDialogAvailableCardContainer.get(counter);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardType);
			selectedText = cardType.getText().trim().toLowerCase();
			if(this.getFormatStringFromPaymentAddDialogForSelectedCard(selectedText,"selectededitremove")) {
				flag = true;
				String cardLogo = this.getSelectedPaymentMethodFromCheckout(cardType.findElement(this.byAddOrChangePaymentMethodDialogCardLogo));
				String cardDetails = cardType.findElement(this.byAddOrChangePaymentMethodDialogCardDetails).getText();
				object.put("cardLogo",cardLogo);
				object.put("cardDetails",cardDetails);
				object.put("webElement",cardType);
			}
			if(flag)
				break;
		}
		return object;
	}

	/**
	 * This function verifies data on Remove Dialog with Add/Change Payment Method Dialog
	 * @param - String - cardData
	 */
	public boolean verifyPaymentMethodRemoveDialogData(String cardLogo, String cardData){
		boolean flag = false;
		//Fetching remove dialog data to be verified
		String cardType = this.getSelectedPaymentMethodFromCheckout(this.lblRemoveCardDialogCardType);
		if(cardLogo.equalsIgnoreCase(cardType))
			reporter.reportLogPass("Card Type on Remove Diaolog: "+cardType+" is same as expected");
		else
			reporter.reportLogFailWithScreenshot("Card Type on Remove Dialog is not same as expected: "+cardType);

		String cardNumber = lblRemoveCardDialogCloseCardDetails.getText();
		if(cardData.contains(cardNumber)){
			flag = true;
			reporter.reportLogPass("Card Number and Expiry on Remove Dialog is same as expected: "+cardNumber);
		}
		else
			reporter.reportLogFailWithScreenshot("Card Number and Expiry on Remove Dialog is not same as expected");

		return flag;
	}

	/**
	 * To open edit Card Dialog
	 * @param - WebElement - editButton
	 * @return - boolean
	 */
	public boolean openUsingNewCardDialog(WebElement editButton){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(editButton);
		editButton.click();
		return this.waitForCondition(Driver->{return this.getElementInnerText(lblUsingANewCardSelectTitle).equalsIgnoreCase("EDIT PAYMENT CARD");},10000);
	}

	/**
	 * To open Using A New Card Dialog
	 * @return - boolean
	 */
	public boolean openUsingNewCardDialog(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogUsingANewCardButton);
		btnAddOrChangePaymentMethodDialogUsingANewCardButton.click();
		return this.waitForCondition(Driver->{return this.getElementInnerText(lblUsingANewCardDialogTitle).equalsIgnoreCase("USE A NEW CARD");},10000);
	}

	/**
	 * To close Using A New Card Dialog
	 * @param -boolean - bSave - true for save and false for close it directly
	 */
	public void closeUsingANewCardDialog(boolean bSave){
		if(bSave){
			boolean bClickSaveButtonSuccess=false;
			for(int i=0;i<5;i++){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogSaveButton);
				btnUsingANewCardDialogSaveButton.click();
				waitForPageLoadingSpinningStatusCompleted();
				this.applyStaticWait(5*this.getStaticWaitForApplication());
				if(this.lstReactModelPortalList.size()==6){
					continue;
				}
				else{
					bClickSaveButtonSuccess=true;
					break;
				}
			}
			if(!bClickSaveButtonSuccess){
				reporter.reportLogFail("Adding a new card failed due to API issue after 5 times try, so close the dialog directly!");
				if (this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"), System.getProperty("chromeMobileDevice"))) {
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogBackButton);
					btnUsingANewCardDialogBackButton.click();
				}
				else{
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogCloseButton);
					btnUsingANewCardDialogCloseButton.click();
				}
				this.applyStaticWait(3*this.getStaticWaitForApplication());

				if (this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"), System.getProperty("chromeMobileDevice"))) {
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogBackButton);
					btnAddOrChangePaymentMethodDialogBackButton.click();
				}
				else{
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogCloseButton);
					btnAddOrChangePaymentMethodDialogCloseButton.click();
				}
				this.applyStaticWait(3*this.getStaticWaitForApplication());
			}

		}
		else{
			if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogBackButton);
				btnUsingANewCardDialogBackButton.click();
			}
			else{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogCloseButton);
				btnUsingANewCardDialogCloseButton.click();
			}
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}

	/*
	public void closeUsingANewCardDialog(boolean bSave){
		if(bSave){
			boolean bClickSaveButtonSuccess=false;
			for(int i=0;i<5;i++){
				reporter.reportLog("i="+i);
				try{
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogSaveButton);
					btnUsingANewCardDialogSaveButton.click();
					this.waitForPageLoadingSpinningStatusCompleted();
				}
				catch(Exception ex){
					bClickSaveButtonSuccess=true;
				}
			}
			if(!bClickSaveButtonSuccess){
				reporter.reportLogFail("Adding a new card failed, so close the dialog directly!");
				if (this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"), System.getProperty("chromeMobileDevice"))) {
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogBackButton);
					btnUsingANewCardDialogBackButton.click();
				}
				else{
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogCloseButton);
					btnUsingANewCardDialogCloseButton.click();
				}
				this.applyStaticWait(3*this.getStaticWaitForApplication());

				if (this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"), System.getProperty("chromeMobileDevice"))) {
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogBackButton);
					btnAddOrChangePaymentMethodDialogBackButton.click();
				}
				else{
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogCloseButton);
					btnAddOrChangePaymentMethodDialogCloseButton.click();
				}
				this.applyStaticWait(3*this.getStaticWaitForApplication());
			}

			try {
				waitForPageLoadingSpinningStatusCompleted();
				this.applyStaticWait(5*getStaticWaitForApplication());
			}
			catch (Exception e){
				this.applyStaticWait(5*getStaticWaitForApplication());
			}
		}
		else{
			if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogBackButton);
				btnUsingANewCardDialogBackButton.click();
			}
			else{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogCloseButton);
				btnUsingANewCardDialogCloseButton.click();
			}
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}
	*/

	/**
	 * To add a new TSC card
	 */
	public void addNewTSCCard(){
		JSONObject cardData=this.getCardDataFromYamlFile("tsc");
		String TSCCardNumber= (String) cardData.get("Number");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogTSCCardRadio);
		labelUsingANewCardDialogTSCCardRadio.click();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogTSCCardNumber);
		inputUsingANewCardDialogTSCCardNumber.clear();
		inputUsingANewCardDialogTSCCardNumber.sendKeys(TSCCardNumber);
	}

	/**
	 * To add a new Credit card
	 * @param - String - creditCardType
	 */
	public void addNewCreditOrEditExistingCard(String creditCardType,boolean validCreditCard,Boolean editExistingCreditCard){
		JSONObject cardData=this.getCardDataFromYamlFile(creditCardType);
		String cardNumber= (String) cardData.get("Number");
		String expiredMonth=(String) cardData.get("DisplayExpirationMonth");
		String expiredYear=(String) cardData.get("DisplayExpirationYear");
		String cardCVV=(String) cardData.get("CVV");

		if(!creditCardType.equalsIgnoreCase("tsc")){
			if(!editExistingCreditCard){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogCreditCardRadio);
				labelUsingANewCardDialogCreditCardRadio.click();
			}else{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputEditExistingCreditCard);
				this.inputEditExistingCreditCard.click();
				this.inputEditExistingCreditCard.sendKeys(Keys.BACK_SPACE);
				this.applyStaticWait(2000);
				//Verification that for Edit - Year and month are pre-populated
				if(!this.inputUsingANewCardDialogCreditExpirationDateMonth.getAttribute("value").isEmpty())
					reporter.reportLogPass("Month is pre-populated for Credit Card");
				else
					reporter.reportLogFailWithScreenshot("Month is not pre-populated for Credit Card");

				if(!this.inputUsingANewCardDialogCreditExpirationDateYear.getAttribute("value").isEmpty())
					reporter.reportLogPass("Year is pre-populated for Credit Card");
				else
					reporter.reportLogFailWithScreenshot("Year is not pre-populated for Credit Card");

				if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice")))
					this.applyStaticWait(5000);
			}

			this.getDriver().switchTo().frame(iframeUsingANewCardDialogCreditCardNumberInput);
			try{
				this.waitForCondition(Driver->{return this.inputCreditCardNumberInIframe.isEnabled() &&
						this.inputCreditCardNumberInIframe.isDisplayed();},10000);
			}catch (Exception e){
				this.applyStaticWait(3000);
			}
			//Using static wait as Sauce Lab sometimes take time to load and behaviour is in-consistent
			this.applyStaticWait(3000);
			if(inputCreditCardNumberInIframe.getAttribute("style").contains("display: inline")){
				inputCreditCardNumberInIframe.click();
				inputCreditCardNumberInIframe.clear();
				this.applyStaticWait(this.getStaticWaitForApplication());
				inputCreditCardNumberInIframe.sendKeys(cardNumber);
			}
			else{
				inputCreditCardMaskNumberInIframe.click();
				this.applyStaticWait(this.getStaticWaitForApplication());
				inputCreditCardNumberInIframe.sendKeys(cardNumber);
			}
			this.getDriver().switchTo().defaultContent();
			this.applyStaticWait(5*this.getStaticWaitForApplication());

			//Verify display of icon just after entering CC number
			if(!creditCardType.equalsIgnoreCase("expired") && validCreditCard){
				String cardType = this.getInputCreditCardNumberType();
				if(cardType.equalsIgnoreCase(creditCardType))
					reporter.reportLogPass("Selected Credit Card : "+creditCardType+" image is displayed as expected");
				else
					reporter.reportLogFailWithScreenshot("Selected Credit Card : "+creditCardType+" not image is displayed as expected");
			}

			this.applyStaticWait(5*this.getStaticWaitForApplication());
			//this.waitForCondition(Driver->{return !lblInputCreditCardNumberType.getAttribute("class").trim().isEmpty();},15000);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateMonth);
			inputUsingANewCardDialogCreditExpirationDateMonth.clear();
			inputUsingANewCardDialogCreditExpirationDateMonth.sendKeys(expiredMonth);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateYear);
			inputUsingANewCardDialogCreditExpirationDateYear.clear();
			inputUsingANewCardDialogCreditExpirationDateYear.sendKeys(expiredYear.substring(2));

			if(this.checkCVVSectionExisting()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditCVV);
				inputUsingANewCardDialogCreditCVV.clear();
				inputUsingANewCardDialogCreditCVV.sendKeys(cardCVV);
			}
		}else
			this.addNewTSCCard();
	}

	/**
	 * This function verifies addition of invalid credit card error message
	 * @param - String - cardNumber - invalid credit card number
	 * @param - String - expectedErrorMessage
	 */
	public void addAndVerifyInvalidCardErrorMessage(String cardNumber,String expectedErrorMessage){
		this.clickWebElementUsingJS(this.inputUsingANewCardDialogCreditCardRadio);
		this.waitForCondition(Driver->{return this.lblUsingANewCardSelectTitle.getText().trim().toLowerCase().contains("card type");},5000);
		this.getDriver().switchTo().frame(iframeUsingANewCardDialogCreditCardNumberInput);
		inputCreditCardNumberInIframe.clear();
		inputCreditCardNumberInIframe.sendKeys(cardNumber);
		this.getDriver().switchTo().defaultContent();
		this.waitForCondition(Driver->{return !this.lblInvalidCreditCardErrorMessage.getText().isEmpty();},5000);
		String errorMessage = this.lblInvalidCreditCardErrorMessage.getText();
		if(errorMessage.equalsIgnoreCase(expectedErrorMessage))
			reporter.reportLogPass("Invalid Credit Card Error Message is as expected: "+errorMessage);
		else
			reporter.reportLogFailWithScreenshot("Invalid Credit Card Error Message is not as expected: "+errorMessage);
	}

	/**
	 * To check Payment Method Existing
	 * @return - boolean
	 */
	public boolean checkPaymentMethodExisting(){
		return this.checkChildElementExistingByAttribute(cntPaymentMethodContainer,"class","paymentmethod__description");
	}

	/**
	 * To get Input Credit Card Number Type
	 * @return - String - "Visa"/"MC"/"Amex"
	 */
	public String getInputCreditCardNumberType(){
		//Applying static wait as on repeated use, stale element exception is coming for browser
		this.applyStaticWait(5*this.getStaticWaitForApplication());
		//this.waitForCondition(Driver->{return !lblInputCreditCardNumberType.getAttribute("class").trim().isEmpty();},15000);
//		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblInputCreditCardNumberType);
		String lsCreditCardClass=lblInputCreditCardNumberType.getAttribute("class").trim();
		if(lsCreditCardClass.contains(" ")){
			String[] lstCreditCardClass=lsCreditCardClass.split(" ");
			for(String lsClass:lstCreditCardClass){
				if(lsClass.contains("tagCCImage")){
					if(lsClass.contains("Visa")){
						return "visa";
					}

					if(lsClass.contains("MC")){
						return "master";
					}

					if(lsClass.contains("Amex")){
						return "amex";
					}
				}
			}
		}
		else{
			if(lsCreditCardClass.contains("Visa")){
				return "visa";
			}

			if(lsCreditCardClass.contains("MC")){
				return "master";
			}

			if(lsCreditCardClass.contains("Amex")){
				return "amex";
			}
		}
		return null;
	}

	/**
	 * To add/Change Payment Method
	 * @param - String - cardType - "tsc"/"visa"/"master"/"amex"
	 * @return -int
	 */
	public int addOrChangePaymentMethod(String cardType){
		if(!this.checkAvailablePaymentMethodExisting()){
			openUsingNewCardDialog();
			if(cardType.equalsIgnoreCase("tsc")){
				addNewTSCCard();
			}
			else{
				addNewCreditOrEditExistingCard(cardType,true,false);
			}
			closeUsingANewCardDialog(true);
		}

		WebElement cardItem;
		int loopSize=lstAddOrChangePaymentMethodDialogAvailableCardContainer.size();
		boolean bFind=false;
		int cartIndex=0;
		for(int i=0;i<loopSize;i++){
			cardItem=lstAddOrChangePaymentMethodDialogAvailableCardContainer.get(i);
			if(cardType.equalsIgnoreCase("tsc")){
				if(checkIfTSCCard(cardItem)){
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardItem);
					cardItem.click();
					bFind=true;
					cartIndex=i;
					closeAddOrChangePaymentMethodDialog(true);
				}
			}
			else{
				if(!checkIfTSCCard(cardItem)){
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardItem);
					cardItem.click();
					bFind=true;
					cartIndex=i;
					closeAddOrChangePaymentMethodDialog(true);
				}
			}
		}

		if(!bFind){
			openUsingNewCardDialog();
			if(cardType.equalsIgnoreCase("tsc")){
				addNewTSCCard();
			}
			else{
				addNewCreditOrEditExistingCard(cardType,true,false);
			}
			closeUsingANewCardDialog(true);
		}

		return cartIndex;
	}

	/**
	 * To open Change Billing Address Dialog
	 * @return - boolean
	 */
	public boolean openChangeBillingAddressDialog(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnBillingAddressChange);
		this.clickElement(btnBillingAddressChange);
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
			waitForPageLoadingSpinningStatusCompleted();
		}
		else{
			if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogBackButton);
				btnAddOrEditAddressDialogBackButton.click();
			}
			else{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogCloseButton);
				btnAddOrEditAddressDialogCloseButton.click();
			}
			this.applyStaticWait(2*getStaticWaitForApplication());
		}
	}

	/**
	 * To get current Billing Address on Checkout page
	 * @return - String
	 */
	public String getCurrentBillingAddress(){
		return this.getElementInnerText(lblBillingAddress);
	}

	/**
	 * To get current shipping Address on Checkout page
	 * @return - String
	 */
	public String getCurrentShippingAddress(){
		return this.getElementInnerText(this.lblShippingAddress);
	}

	/**
	 * To add new address or edit an existing address With Random Values
	 * @return - Map<String,String> - including firstName,lastName,phoneNumber,address
	 */
	public Map<String,String> addOrEditAddressWithRandomValues(){
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogAddress);
		inputAddOrEditAddressDialogAddress.clear();
		int length = inputAddOrEditAddressDialogAddress.getAttribute("value").trim().length();
		if(length>1){
			inputAddOrEditAddressDialogAddress.click();
			for(int counter=0;counter<length;counter++)
				inputAddOrEditAddressDialogAddress.sendKeys(Keys.BACK_SPACE);
			this.applyStaticWait(2000);
		}
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
		this.waitForCondition(Driver->{return this.cntAddOrEditAddressDialogAddressDropDownList.getAttribute("class").contains("react-autosuggest__suggestions-container--open");},20000);
		this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());

		if(this.lstAddOrEditAddressDialogAddressDropDownList.size()>1){
			reporter.reportLogPass("Getting dropdown auto search results successfully");
		}
		else{
			reporter.reportLogPassWithScreenshot("Unable to get dropdown auto search results");
		}

		int optionSize=this.lstAddOrEditAddressDialogAddressDropDownList.size();
		int randomNumber=0;
		if(optionSize>2){
			Random rand = new Random();
			randomNumber = rand.nextInt(optionSize-2);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstAddOrEditAddressDialogAddressDropDownList.get(randomNumber));
		this.clickWebElementUsingJS(this.lstAddOrEditAddressDialogAddressDropDownList.get(randomNumber));
		this.waitForCondition(Driver->{return !this.cntAddOrEditAddressDialogAddressDropDownList.getAttribute("class").contains("react-autosuggest__suggestions-container--open");},20000);

		//Wait for province and postal code update
		this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogAddress);
		String lsAddress=inputAddOrEditAddressDialogAddress.getAttribute("value").trim();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogCity);
		String lsCity=inputAddOrEditAddressDialogCity.getAttribute("value").trim();

		Select select=new Select(selectAddOrEditAddressDialogProvince);
		String lsSelectedProvince=select.getFirstSelectedOption().getText().trim();
		String lsProvinceValue="",lsProvinceText;
		List<WebElement> lstProvinceOption=select.getOptions();
		for(WebElement provinceOption:lstProvinceOption){
			lsProvinceText=this.getElementInnerText(provinceOption);
			if(lsProvinceText.isEmpty()){
				continue;
			}

			if(lsProvinceText.equalsIgnoreCase(lsSelectedProvince)){
				lsProvinceValue=provinceOption.getAttribute("value");
				break;
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogPostalCode);
		String lsPostalCode=inputAddOrEditAddressDialogPostalCode.getAttribute("value").trim();

		Map<String,String> map=new HashMap<>();
		map.put("firstName",lsFirstName);
		map.put("lastName",lsLastName);
		map.put("phoneNumber",lsPhoneNumber);
		map.put("address",lsAddress);
		map.put("city",lsCity);
		map.put("province",lsProvinceValue);
		map.put("postalCode",lsPostalCode);

		return map;
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
	 * @return - int
	 */
	public int getInstallmentNumberFromPaymentOptionText(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectPaymentOption);
		Select select=new Select(this.selectPaymentOption);
		String lsPaymentOptionText=select.getFirstSelectedOption().getText();
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
	 * @return - float
	 */
	public float getInstallmentAmountFromPaymentOptionText(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectPaymentOption);
		Select select=new Select(this.selectPaymentOption);
		String lsPaymentOptionText=select.getFirstSelectedOption().getText();
		if(lsPaymentOptionText.contains("Pay In Full Now")){
			return this.getFloatFromString(lsPaymentOptionText,true);
		}
		else{
			String stringContainsFloat=this.getStringAfterGivenIdentifier(lsPaymentOptionText,"of");
			return this.getFloatFromString(stringContainsFloat,true);
		}
	}

	/**
	 * To set Payment Option By Given installment Number
	 * @param - int - installmentNumber - given installment Number
	 * @return - String - selected text
	 */
	public String setPaymentOptionByGivenInstallmentNumber(int installmentNumber){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectPaymentOption);
		Select select=new Select(this.selectPaymentOption);
		String lsPaymentOption=select.getFirstSelectedOption().getText().trim();
		if(!lsPaymentOption.contains("Pay In Full Now")){
			String stringContainsInteger=this.getStringBeforeGivenIdentifier(lsPaymentOption,"of");
			if(this.getIntegerFromString(stringContainsInteger)==installmentNumber){
				return lsPaymentOption;
			}
		}

		List<String> lstPaymentOption=getPaymentOptionTextList();
		for(int i=0;i<lstPaymentOption.size();i++){
			lsPaymentOption=lstPaymentOption.get(i);
			if(!lsPaymentOption.contains("Pay In Full Now")){
				String stringContainsInteger=this.getStringBeforeGivenIdentifier(lsPaymentOption,"of");
				if(this.getIntegerFromString(stringContainsInteger)==installmentNumber){
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectPaymentOption);
					select=new Select(this.selectPaymentOption);
					select.selectByIndex(i);
					try{
						this.waitForPageLoadingSpinningStatusCompleted();
					}
					catch (Exception e){
						this.applyStaticWait(3*this.getStaticWaitForApplication());
					}
					return lsPaymentOption;
				}
			}
		}
		return null;
	}

	/**
	 * To get Installment Options
	 * @return - List<String>
	 */
	public List<String> getInstallmentOptions(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectPaymentOption);
		Select select = new Select(this.selectPaymentOption);
		List<WebElement> lstOptions=select.getOptions();
		List<String> lstOptionText=new ArrayList<>();
		for(WebElement option:lstOptions){
			lstOptionText.add(this.getElementInnerText(option));
		}
		return lstOptionText;
	}

	/**
	 * To set PaymentOption By given text
	 * @param - String - lsPaymentOptionText
	 */
	public void setPaymentOptionByGivenText(String lsPaymentOptionText){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectPaymentOption);
		Select select=new Select(this.selectPaymentOption);
		select.selectByVisibleText(lsPaymentOptionText);
		try{
			this.waitForPageLoadingSpinningStatusCompleted();
		}
		catch (Exception e){
			this.applyStaticWait(3*this.getStaticWaitForApplication());
		}
	}

	/**
	 * To set PaymentOption By given index
	 * @param - int - index - given index
	 */
	public void setPaymentOptionByGivenIndex(int index){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectPaymentOption);
		Select select=new Select(this.selectPaymentOption);
		select.selectByIndex(index);
		try{
			this.waitForPageLoadingSpinningStatusCompleted();
		}
		catch (Exception e){
			this.applyStaticWait(3*this.getStaticWaitForApplication());
		}
	}

	/**
	 * To set PaymentOption By Random Index
	 */
	public int setPaymentOptionByRandomIndex(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectPaymentOption);
		Select select=new Select(this.selectPaymentOption);

		List<WebElement> lstOptions=select.getOptions();
		int optionSize=lstOptions.size();
		if(optionSize==1){
			this.getInstallmentNumberFromPaymentOptionText();
		}

		if(optionSize==2){
			select.selectByIndex(1);
		}

		int randomNumber=getRandomNumber(1, optionSize);
		select.selectByIndex(randomNumber);
		try{
			this.waitForPageLoadingSpinningStatusCompleted();
		}
		catch (Exception e){
			this.applyStaticWait(3*this.getStaticWaitForApplication());
		}

		return this.getInstallmentNumberFromPaymentOptionText();
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
		map.put("subTotal",this.getFloatFromString(lsText));

		map.put("wasPrice",getWasPriceFromOrderSummary());

		map.put("nowPrice",getNowPriceFromOrderSummary());

		map.put("province",getTaxProvinceCode());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryTax);
		lsText=this.lblOrderSummaryTax.getText();
		map.put("tax",this.getFloatFromString(lsText,true));

		WebElement item,subItem;
		float floatValue=0.0f;
		if(this.checkAppliedDiscountExistingInOrderSummary()){
			String lsAppliedDiscountType=this.judgeAppliedDiscountType();
			switch(lsAppliedDiscountType){
				case "Both":
					item=lstOrderSummaryAppliedDiscountList.get(0);
					subItem=item.findElement(By.xpath("./span[1]"));
					lsText=this.getElementInnerText(subItem).replace(":","");
					map.put("promoteCodeTitle",lsText);
					subItem=item.findElement(By.xpath("./span[2]"));
					lsText=this.getElementInnerText(subItem);
					if(lsText.contains("-")){
						if(lsText.equalsIgnoreCase("-")){
							map.put("promoteCodeValue",0.0f);
						}
						else{
							floatValue=-1*this.getFloatFromString(lsText,true);
							map.put("promoteCodeValue",floatValue);
						}
					}
					else{
						floatValue=this.getFloatFromString(lsText,true);
						map.put("promoteCodeValue",floatValue);
					}

					item=lstOrderSummaryAppliedDiscountList.get(1);
					subItem=item.findElement(By.xpath("./span[1]"));
					lsText=this.getElementInnerText(subItem).replace(":","");
					map.put("giftCardTitle",lsText);
					subItem=item.findElement(By.xpath("./span[2]"));
					lsText=this.getElementInnerText(subItem);
					if(lsText.contains("-")){
						map.put("giftCardValue",-1*this.getFloatFromString(lsText,true));
					}
					else{
						map.put("giftCardValue",this.getFloatFromString(lsText,true));
					}
					break;
				case "PromoteCode":
					item=lstOrderSummaryAppliedDiscountList.get(0);
					subItem=item.findElement(By.xpath("./span[1]"));
					lsText=this.getElementInnerText(subItem).replace(":","");
					map.put("promoteCodeTitle",lsText);
					subItem=item.findElement(By.xpath("./span[2]"));
					lsText=this.getElementInnerText(subItem);
					if(lsText.contains("-")){
						if(lsText.equalsIgnoreCase("-")){
							map.put("promoteCodeValue",0.0f);
						}
						else{
							floatValue=-1*this.getFloatFromString(lsText,true);
							map.put("promoteCodeValue",floatValue);
						}
					}
					else{
						floatValue=this.getFloatFromString(lsText,true);
						map.put("promoteCodeValue",floatValue);
					}

					map.put("giftCardTitle",null);
					map.put("giftCardValue",0.0f);
					break;
				case "GiftCard":
					item=lstOrderSummaryAppliedDiscountList.get(0);
					subItem=item.findElement(By.xpath("./span[1]"));
					lsText=this.getElementInnerText(subItem).replace(":","");
					map.put("giftCardTitle",lsText);
					subItem=item.findElement(By.xpath("./span[2]"));
					lsText=this.getElementInnerText(subItem);
					if(lsText.contains("-")){
						map.put("giftCardValue",-1*this.getFloatFromString(lsText,true));
					}
					else{
						map.put("giftCardValue",this.getFloatFromString(lsText,true));
					}

					map.put("promoteCodeTitle",null);
					map.put("promoteCodeValue",0.0f);
					break;
				default:
					break;
			}
		}
		else{
			map.put("promoteCodeTitle",null);
			map.put("promoteCodeValue",0.0f);

			map.put("giftCardTitle",null);
			map.put("giftCardValue",0.0f);
		}

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
	public void verifyOrderSummaryBusinessLogic(float subTotalShoppingCart,Map<String,Object> orderSummaryMap,Map<String,Object> provincialTaxRate){
		float wasPriceOrderSummary= (float) orderSummaryMap.get("wasPrice");
		float nowPriceOrderSummary=(float) orderSummaryMap.get("nowPrice");

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

		float promoteCodeValue=(float) orderSummaryMap.get("promoteCodeValue");
		float giftCardValue=(float) orderSummaryMap.get("giftCardValue");
		float calTotalPrice=subTotal+tax+nowPriceOrderSummary+promoteCodeValue+giftCardValue;
		float totalPrice=(float) orderSummaryMap.get("totalPrice");
		if(Math.abs(calTotalPrice-totalPrice)<0.01){
			reporter.reportLogPass("The calculated total price in OrderSummary section is equal to the total price in OrderSummary section");
		}
		else{
			reporter.reportLogFail("The calculated total price:"+calTotalPrice+" in OrderSummary section is not equal to the total price:"+totalPrice+" in OrderSummary section");
		}

		float calSavePriceOrderSummary;
		if(wasPriceOrderSummary<0.01){
			calSavePriceOrderSummary=0.0f;
		}
		else{
			calSavePriceOrderSummary=Math.abs(wasPriceOrderSummary-nowPriceOrderSummary);
		}
		calSavePriceOrderSummary=calSavePriceOrderSummary+Math.abs(promoteCodeValue);

		float savePriceOrderSummary=(float) orderSummaryMap.get("savePrice");
		if(Math.abs(calSavePriceOrderSummary-savePriceOrderSummary)<0.01){
			reporter.reportLogPass("The calculated saving price in OrderSummary section is equal to the saving price in OrderSummary section");
		}
		else{
			reporter.reportLogFail("The calculated saving price:"+calSavePriceOrderSummary+" in OrderSummary section is not equal to the saving price:"+savePriceOrderSummary+" in OrderSummary section");
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
			reporter.reportLogFail("The presetting installment number:"+totalInstallmentNumber+" is not equal to the installment number in installment section:"+currentTotalInstallmentNumber);
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

		float totalPriceOrderSummary=0.0f;
		for(Map.Entry<String,Object> entry:orderSummaryMap.entrySet()){
			if(entry.getKey().toLowerCase().contains("totalprice")){
				totalPriceOrderSummary= (float) entry.getValue();
				break;
			}
		}

		float promoteCodeValue=(float) orderSummaryMap.get("promoteCodeValue");
		float giftCardValue=(float) orderSummaryMap.get("giftCardValue");

		float eachInstallmentPayment=subTotalOrderSummary/totalInstallmentNumber;
		float calTodayPayment=eachInstallmentPayment+shippingPriceOrderSummary+taxOrderSummary+(promoteCodeValue+giftCardValue)/totalInstallmentNumber;
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
			reporter.reportLogFail("The calculated future monthly payment:"+calFutureMonthlyPayment+" is not equal to the future monthly payment:"+futureMonthlyPayment+" in installment section");
		}
	}

	/**
	 * To verify Checkout Header Contents
	 */
	public void verifyCheckoutHeaderContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconTSCHeaderLogo);
		if (this.getReusableActionsInstance().isElementVisible(iconTSCHeaderLogo)) {
			reporter.reportLogPass("The TSC header icon is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The TSC header icon is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCheckout);
		lsText = lblCheckout.getText().trim();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The checkout header title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The checkout header title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconAddressProgressBar);
		if (this.getReusableActionsInstance().isElementVisible(iconAddressProgressBar)) {
			reporter.reportLogPass("The address icon in progress bar is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The address icon in progress bar is not displaying correctly");
		}

		if(!(System.getProperty("Device").equalsIgnoreCase("Tablet") && System.getProperty("Browser").contains("android"))){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddressProgressBar);
			lsText = lblAddressProgressBar.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The address title in progress bar is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The address title in progress bar is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReviewOrderProgressBar);
			lsText = lblReviewOrderProgressBar.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The review order title in progress bar is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The review order title in progress bar is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentProgressBar);
			lsText = lblPaymentProgressBar.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The payment title in progress bar is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The payment title in progress bar is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconPaymentProgressBar);
		if (this.getReusableActionsInstance().isElementVisible(iconPaymentProgressBar)) {
			reporter.reportLogPass("The payment icon in progress bar is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The payment icon in progress bar is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconReviewOrderProgressBar);
		if (this.getReusableActionsInstance().isElementVisible(iconReviewOrderProgressBar)) {
			reporter.reportLogPass("The review order icon in header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The review order icon in header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnGoToShoppingBag);
		if (this.getReusableActionsInstance().isElementVisible(btnGoToShoppingBag)) {
			reporter.reportLogPass("The GoToShoppingBag button in header is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The GoToShoppingBag button in header is not displaying correctly");
		}
	}

	/**
	 * To verify Mandatory Contents For Checkout Product List
	 */
	public void verifyMandatoryContentsForCheckoutProductList() {
		String lsText;
		WebElement item;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCollapseProductList);
		lsText = btnCollapseProductList.getText().trim();
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

			if(this.checkProductNumberExisting(productItem)){
				item = productItem.findElement(byProductNumber);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText = item.getText().replace("-", "").trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The product number is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product number is not displaying correctly");
				}
			}

			item = productItem.findElement(byProductNowPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product nowPrice is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product nowPrice is not displaying correctly");
			}

			item=productItem.findElement(byProductSelectQuantity);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=this.getElementInnerText(item).split(":")[1].trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product quantity is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product quantity is not displaying correctly");
			}

			if(!this.checkProductShippingDateExisting()){
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
	}

	/**
	 * To verify Optional Contents For Checkout Product List
	 */
	public void verifyOptionalContentsForCheckoutProductList() {
		String lsText;
		WebElement item;

		if(this.checkAlertMessageInHeaderExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAlertMessage);
			lsText = this.lblAlertMessage.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The alert message in header is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The alert message in header is not displaying correctly");
			}
		}

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

		if(this.checkProductShippingDateExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblShippingDateTitle);
			lsText = this.lblShippingDateTitle.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The GetItBy date title is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The GetItBy date title is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblShippingDate);
			lsText = this.lblShippingDate.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The GetItBy date is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The GetItBy date is not displaying correctly");
			}
		}
	}

	/**
	 * To verify Address And Payment Contents
	 */
	public void verifyAddressAndPaymentContents() {
		String lsText;

		reporter.reportLog("Verify shipping address contents");
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

		reporter.reportLog("Verify shipping method contents");
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

		if(this.checkChangeShippingMethodButtonExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeShippingMethod);
			lsText=btnChangeShippingMethod.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The change Shipping Method button is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The change Shipping Method button is not displaying correctly");
			}
		}

		reporter.reportLog("Verify shipping payment method contents");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingPaymentMethodTitle);
		lsText=lblShippingPaymentMethodTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Shipping Payment Method Title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Shipping Payment Method Title is not displaying correctly");
		}

		if(!this.checkAlertMessageInHeaderExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentMethod);
			lsText=lblPaymentMethod.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The Payment Method is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Payment Method is not displaying correctly");
			}
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentMethodErrorMessage);
			lsText=lblPaymentMethodErrorMessage.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The Payment Method error message is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Payment Method error message is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethod);
		lsText=btnAddOrChangePaymentMethod.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The AddOrChange Payment Method button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The AddOrChange Payment Method button is not displaying correctly");
		}

		reporter.reportLog("Verify billing address contents");
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

		reporter.reportLog("Verify payment option contents");
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

		if(this.checkAppliedDiscountExistingInOrderSummary()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryAppliedDiscountTitle);
			lsText=this.lblOrderSummaryAppliedDiscountTitle.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The Applied Discount Title in OrderSummary is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Applied Discount Title in OrderSummary is not displaying correctly");
			}

			WebElement subItem;
			for(WebElement item:this.lstOrderSummaryAppliedDiscountList){
				subItem=item.findElement(By.xpath("./span[1]"));
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				lsText=subItem.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The Applied Discount item title:"+lsText+" in OrderSummary is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The Applied Discount item Title in OrderSummary is not displaying correctly");
				}

				subItem=item.findElement(By.xpath("./span[2]"));
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				lsText=subItem.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The Applied Discount item value:"+lsText+" in OrderSummary is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The Applied Discount item value in OrderSummary is not displaying correctly");
				}
			}
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

		this.scrollWindowDown(this.getDriver(),10000);
		this.applyStaticWait(2000);

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

		if(System.getProperty("Device").equalsIgnoreCase("Desktop") ||
				(System.getProperty("Device").equalsIgnoreCase("Tablet") &&
						System.getProperty("Browser").contains("ios")) ||
				(System.getProperty("Browser").equalsIgnoreCase("chromemobile") &&
						System.getProperty("chromeMobileDevice").contains("iPad"))){
			this.waitForCondition(Driver->{return this.btnAddOrChangeShippingAddressDialogCloseButton.isEnabled() &&
					this.btnAddOrChangeShippingAddressDialogCloseButton.isDisplayed();},6000);
		}else
			this.waitForCondition(Driver->{return this.btnAddOrChangeShippingAddressDialogBackButton.isEnabled() &&
					this.btnAddOrChangeShippingAddressDialogBackButton.isDisplayed();},6000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrChangeShippingAddressDialogTitle);
		lsText = lblAddOrChangeShippingAddressDialogTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The title in Add Or Change Address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The title in Add Or Change Address Dialog is not displaying correctly");
		}

		if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangeShippingAddressDialogBackButton);
			if(this.getReusableActionsInstance().isElementVisible(btnAddOrChangeShippingAddressDialogBackButton)){
				reporter.reportLogPass("The Back button in Add Or Change Address Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Back button in Add Or Change Address Dialog is not displaying correctly");
			}
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangeShippingAddressDialogCloseButton);
			if(this.getReusableActionsInstance().isElementVisible(btnAddOrChangeShippingAddressDialogCloseButton)){
				reporter.reportLogPass("The Close button in Add Or Change Address Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Close button in Add Or Change Address Dialog is not displaying correctly");
			}
		}

		this.verifyAddressOnAddChangeShippingAddressDialogAndReturnSelectedAddress(true);

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
	 * This function verifies all address on Add/Change Dialog Box and returns selected address
	 * @return - String
	 */
	public String verifyAddressOnAddChangeShippingAddressDialogAndReturnSelectedAddress(boolean verifyContentsflag){
		String lsText;
		boolean editButtonVerificationFlag = false;
		String selectedAddress = null;

		if(this.checkAvailableShippingAddressExisting()){
			WebElement item, addressItem;
			int loopSize=lstAddOrChangeShippingAddressDialogAvailableShippingAddress.size();
			for(int i=0;i<loopSize;i++){
				addressItem=lstAddOrChangeShippingAddressDialogAvailableShippingAddress.get(i);
				if(verifyContentsflag){
					reporter.reportLog("Verify address "+i);
					//this.getReusableActionsInstance().javascriptScrollByVisibleElement(addressItem);
					//addressItem.click();
					//this.applyStaticWait(300);

					item=addressItem.findElement(byAddOrChangeShippingAddressDialogHeaderContent);
					String headerText = this.getElementText(item);
					if(getFormatStringFromPaymentAddDialogForSelectedCard(headerText,"selected")){
					//if(headerText.toLowerCase().replace("\n","").contains("selecteded")){
						item=addressItem.findElement(byAddOrChangeShippingAddressDialogEditButton);
						this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
						lsText=item.getText();
						if(!lsText.isEmpty()){
							editButtonVerificationFlag = true;
							reporter.reportLogPass("The edit button is displaying correctly");
						}
						else{
							reporter.reportLogFailWithScreenshot("The edit button is not displaying correctly");
						}
						selectedAddress = addressItem.findElement(byAddOrChangeShippingAddressDialogCardDetails).getText();
					}

					item=addressItem.findElement(byAddOrChangeShippingAddressDialogSelectLabel);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
					if(this.getReusableActionsInstance().isElementVisible(item)){
						reporter.reportLogPass("The select address is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The select address is not displaying correctly");
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

					if(editButtonVerificationFlag)
						reporter.reportLogPass("Edit Button verification is done as expected");
					else
						reporter.reportLogFail("Edit Button verification is not done as expected");
				}else{
					item=addressItem.findElement(byAddOrChangeShippingAddressDialogHeaderContent);
					String headerText = this.getElementText(item);
					if(getFormatStringFromPaymentAddDialogForSelectedCard(headerText,"selected")){
					//if(headerText.toLowerCase().replace("\n","").contains("selecteded")){
						selectedAddress = addressItem.findElement(byAddOrChangeShippingAddressDialogCardDetails).getText();
						break;
					}
				}
			}
		}
		return selectedAddress;
	}

	/**
	 * To verify Add or Edit Address Dialog Contents
	 */
	public void verifyAddOrEditAddressDialogContents() {
		String lsText;

		if(System.getProperty("Device").equalsIgnoreCase("Desktop") ||
				(System.getProperty("Device").equalsIgnoreCase("Tablet") &&
						System.getProperty("Browser").contains("ios")) ||
				(System.getProperty("Browser").equalsIgnoreCase("chromemobile") &&
						System.getProperty("chromeMobileDevice").contains("iPad"))){
			this.waitForCondition(Driver->{return this.btnAddOrChangeShippingAddressDialogCloseButton.isEnabled() &&
					this.btnAddOrChangeShippingAddressDialogCloseButton.isDisplayed();},6000);
		}else
			this.waitForCondition(Driver->{return this.btnAddOrChangeShippingAddressDialogBackButton.isEnabled() &&
					this.btnAddOrChangeShippingAddressDialogBackButton.isDisplayed();},6000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddOrEditAddressDialogTitle);
		lsText = lblAddOrEditAddressDialogTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The title in Add or edit address Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The title in Add or edit address Dialog is not displaying correctly");
		}

		if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogBackButton);
			if(this.getReusableActionsInstance().isElementVisible(btnAddOrEditAddressDialogBackButton)){
				reporter.reportLogPass("The Back button in Add or edit address Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Back button in Add or edit address Dialog is not displaying correctly");
			}
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogCloseButton);
			if(this.getReusableActionsInstance().isElementVisible(btnAddOrEditAddressDialogCloseButton)){
				reporter.reportLogPass("The close button in Add or edit address Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The close button in Add or edit address Dialog is not displaying correctly");
			}
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
	 * To verify Change Shipping Method Dialog Contents
	 */
	public void verifyChangeShippingMethodDialogContents() {
		String lsText;
		WebElement item;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblChangeShippingMethodDialogHeaderTitle);
		lsText = lblChangeShippingMethodDialogHeaderTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The title in Change shipping method Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The title in Change shipping method Dialog is not displaying correctly");
		}

		if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeShippingMethodDialogBackButton);
			lsText = btnChangeShippingMethodDialogBackButton.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The Back button in Change shipping method Dialog is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Back button in Change shipping method Dialog is not displaying correctly");
			}
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnChangeShippingMethodDialogCloseButton);
			lsText = btnChangeShippingMethodDialogCloseButton.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The Close button in Change shipping method Dialog is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Close button in Change shipping method Dialog is not displaying correctly");
			}
		}

		for(WebElement shippingMethodItem:lstChangeShippingMethodDialogShippingMethodList){
			item=shippingMethodItem.findElement(byShippingMethodDescription);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText();
			reporter.reportLog("Verify '"+lsText+"'");
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The shipping method item description in Change shipping method Dialog is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The shipping method item description in Change shipping method Dialog is not displaying correctly");
			}

			item=shippingMethodItem.findElement(byShippingMethodLabel);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The shipping method item label in Change shipping method Dialog is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The shipping method item label in Change shipping method Dialog is not displaying correctly");
			}

			item=shippingMethodItem.findElement(byShippingMethodRadioButton);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			if (this.getReusableActionsInstance().isElementVisible(item)) {
				reporter.reportLogPass("The shipping method item radio button in Change shipping method Dialog is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The shipping method item radio button in Change shipping method Dialog is not displaying correctly");
			}

			item=shippingMethodItem.findElement(byShippingMethodPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The shipping method item price info in Change shipping method Dialog is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The shipping method item price info in Change shipping method Dialog is not displaying correctly");
			}

			item=shippingMethodItem.findElement(byShippingMethodDetails);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The shipping method item details info in Change shipping method Dialog is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The shipping method item details info in Change shipping method Dialog is not displaying correctly");
			}

			item=shippingMethodItem.findElement(byShippingMethodLearMoreLink);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getAttribute("href");
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The shipping method item learn more link in Change shipping method Dialog is not empty");
			} else {
				reporter.reportLogFailWithScreenshot("The shipping method item learn more link in Change shipping method Dialog is empty");
			}
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

		if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogBackButton);
			if(this.getReusableActionsInstance().isElementVisible(btnAddOrChangePaymentMethodDialogBackButton)){
				reporter.reportLogPass("The Back button in Add Or Change Payment Method Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Back button in Add Or Change Payment Method Dialog is not displaying correctly");
			}
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrChangePaymentMethodDialogCloseButton);
			if(this.getReusableActionsInstance().isElementVisible(btnAddOrChangePaymentMethodDialogCloseButton)){
				reporter.reportLogPass("The close button in Add Or Change Payment Method Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The close button in Add Or Change Payment Method Dialog is not displaying correctly");
			}
		}

		if(this.checkAvailablePaymentMethodExisting()){
			this.verfiyAddedCardsForUserInPaymentMethod(null);
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
	 * This function verifies added cards for user
	 */
	public void verfiyAddedCardsForUserInPaymentMethod(String creditCardType){
		boolean flag = false;
		Boolean selectedCard = false;
		String lsText,selectedText;
		WebElement item, paymentItem;
		int loopSize=lstAddOrChangePaymentMethodDialogAvailableCardContainer.size();
		for(int i=0;i<loopSize;i++){
			reporter.reportLog("Verify payment method "+i);
			paymentItem=lstAddOrChangePaymentMethodDialogAvailableCardContainer.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(paymentItem);
			selectedText = paymentItem.getText().trim().toLowerCase();
			selectedCard = this.getFormatStringFromPaymentAddDialogForSelectedCard(selectedText,"selectededitremove");

			if(selectedCard){
				flag = true;
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
			}

			item=paymentItem.findElement(byAddOrChangePaymentMethodDialogSelectLabel);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			if(this.getReusableActionsInstance().isElementVisible(item)){
				reporter.reportLogPass("The select payment is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The select payment is not displaying correctly");
			}

			item=paymentItem.findElement(byAddOrChangePaymentMethodDialogCardLogo);
			String cardlogo = item.getAttribute("class").toLowerCase();
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			if(this.getReusableActionsInstance().isElementVisible(item)){
				reporter.reportLogPass("The card Logo in Add Or Change Payment Method Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The card Logo in Add Or Change Payment Method Dialog is not displaying correctly");
			}

			if(creditCardType!=null && cardlogo.contains(creditCardType.toLowerCase())){
				String cardType = item.getAttribute("class");
				if(cardType.toLowerCase().contains(creditCardType.toLowerCase()))
					reporter.reportLogPass("Credit Card is added as expected");
				else
					reporter.reportLogFailWithScreenshot("Credit Card added is not as expected: "+cardType);
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
		if(flag)
			reporter.reportLog("Selected Card verification done as expected!");
		else
			reporter.reportLogFailWithScreenshot("Selected Card verification is not done as expected..");
	}

	/**
	 * This function verifies checkout payment method with Payment Add/Change Dialog
	 * @param - String - checkoutPaymentCardType
	 * @param -JSONObject - cardDetails
	 */
	public void verifyPaymentMethodOnCheckoutWithCardOnAddChangeDialog(String checkoutPaymentCardType,JSONObject cardDetails,String expiryMonth, String expiryYear){
		WebElement cardType;
		Boolean creditCardText = false;
		String selectedText;
		String cardExpiry;
		int loopSize=lstAddOrChangePaymentMethodDialogAvailableCardContainer.size();
		for(int i=0;i<loopSize;i++){
			cardType=lstAddOrChangePaymentMethodDialogAvailableCardContainer.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardType);
			selectedText = cardType.getText();
			creditCardText = this.getFormatStringFromPaymentAddDialogForSelectedCard(selectedText,"selectededitremove");
			if(creditCardText){
				if(checkoutPaymentCardType!=null){
					if(checkoutPaymentCardType.equalsIgnoreCase(cardDetails.get("CardType").toString()))
						reporter.reportLogPass("Credit Card on checkout page is same that is selected");
					else
						reporter.reportLogFailWithScreenshot("Credit Card on checkout page is not same as on Payment Dialog");
				}

				String inputCardNumber = cardDetails.get("Number").toString();
				String displayCardNumber = inputCardNumber.substring(inputCardNumber.length()-4);
				if(selectedText.trim().contains(displayCardNumber))
					reporter.reportLogPass("Correct Card is added as on checkout page");
				else
					reporter.reportLogFailWithScreenshot("Card Number is not same as expected: "+inputCardNumber);

				String cardLogo = this.getSelectedPaymentMethodFromCheckout(cardType.findElement(this.byAddOrChangePaymentMethodDialogCardLogo));
				if(!cardLogo.contains("tsc")){
					if(expiryMonth!=null && expiryYear!=null)
						cardExpiry = expiryMonth+"/"+expiryYear.substring(2);
					else
						cardExpiry = cardDetails.get("DisplayExpirationMonth")+"/"+cardDetails.get("DisplayExpirationYear").toString().substring(2);
					if(selectedText.contains(cardExpiry))
						reporter.reportLogPass("Credit Card expiry is same as expected: "+cardExpiry);
					else
						reporter.reportLogFailWithScreenshot("Credit Card expiry: "+cardExpiry+" is not same as expected: "+selectedText);
				}

				break;
			}
		}
		if(creditCardText)
			reporter.reportLogPass("Payment method on checkout page is selected on Add/Change Payment Method Dialog as expected!");
		else
			reporter.reportLogFailWithScreenshot("Payment method on checkout page is not selected on Add/Change Payment Method Dialog as expected..");
	}

	/**
	 * To verify remove Payment Method Dialog Contents
	 */
	public void verifyRemovePaymentMethodDialogContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveCardDialogHeaderTitle);
		lsText = lblRemoveCardDialogHeaderTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The title in remove Payment Method Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The title in remove Payment Method Dialog is not displaying correctly");
		}

		if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveCardDialogGoBackButton);
			if(this.getReusableActionsInstance().isElementVisible(btnRemoveCardDialogGoBackButton)){
				reporter.reportLogPass("The Back button in remove Payment Method Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Back button in remove Payment Method Dialog is not displaying correctly");
			}
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveCardDialogCloseButton);
			if(this.getReusableActionsInstance().isElementVisible(btnRemoveCardDialogCloseButton)){
				reporter.reportLogPass("The close button in remove Payment Method Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The close button in remove Payment Method Dialog is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconRemoveCardDialogCloseCardLogo);
		if(this.getReusableActionsInstance().isElementVisible(iconRemoveCardDialogCloseCardLogo)){
			reporter.reportLogPass("The card icon in remove Payment Method Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The card icon in remove Payment Method Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveCardDialogCloseCardDetails);
		lsText = lblRemoveCardDialogCloseCardDetails.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The card details info in remove Payment Method Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The card details info in remove Payment Method Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveCardDialogCloseWarningMessage);
		lsText = lblRemoveCardDialogCloseWarningMessage.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The remove warning message in remove Payment Method Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The remove warning message in remove Payment Method Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveCardDialogCloseRemoveButton);
		lsText = btnRemoveCardDialogCloseRemoveButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The remove button in remove Payment Method Dialog is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The remove button in remove Payment Method Dialog is not displaying correctly");
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

		if(this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogBackButton);
			if(this.getReusableActionsInstance().isElementVisible(btnUsingANewCardDialogBackButton)){
				reporter.reportLogPass("The Back button in using a new card Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Back button in using a new card Dialog is not displaying correctly");
			}
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnUsingANewCardDialogCloseButton);
			if(this.getReusableActionsInstance().isElementVisible(btnUsingANewCardDialogCloseButton)){
				reporter.reportLogPass("The close button in using a new card Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The close button in using a new card Dialog is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditCardRadio);
		if(this.inputUsingANewCardDialogCreditCardRadio.isEnabled()){
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

		if(this.checkCVVSectionExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblUsingANewCardDialogCreditCVVTitle);
			lsText = lblUsingANewCardDialogCreditCVVTitle.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The CreditCard CVV Title in using a new card Dialog is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The CreditCard CVV Title in using a new card Dialog is not displaying correctly");
			}

			String lsTestDevice = System.getProperty("Device").trim();
			if(lsTestDevice.equalsIgnoreCase("Mobile")) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconUsingANewCardDialogCreditCVVTooltip);
				iconUsingANewCardDialogCreditCVVTooltip.click();
				reporter.reportLogWithScreenshot("Tooltip");
				this.waitForCondition(Driver->{return this.checkCVVTooltipDisplaying();},10000);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblUsingANewCardDialogCreditCVVTooltipMessage);
				lsText=lblUsingANewCardDialogCreditCVVTooltipMessage.getText();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The CreditCard CVV tooltip message in using a new card Dialog is displaying correctly after hovering on CVV icon");
				}
				else{
					reporter.reportLogFailWithScreenshot("The CreditCard CVV tooltip message in using a new card Dialog is not displaying correctly after hovering on CVV icon");
				}
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnUsingANewCardDialogCreditCVVTooltipCloseButton);
				this.clickElement(this.btnUsingANewCardDialogCreditCVVTooltipCloseButton);
				this.applyStaticWait(this.getStaticWaitForApplication());
			}
			else{
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconUsingANewCardDialogCreditCVVTooltip);
				this.getReusableActionsInstance().scrollToElement(iconUsingANewCardDialogCreditCVVTooltip);
				reporter.reportLogWithScreenshot("Tooltip");
				this.waitForCondition(Driver->{return this.checkCVVTooltipDisplaying();},10000);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblUsingANewCardDialogCreditCVVTooltipMessage);
				lsText=lblUsingANewCardDialogCreditCVVTooltipMessage.getText();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The CreditCard CVV tooltip message in using a new card Dialog is displaying correctly after hovering on CVV icon");
				}
				else{
					reporter.reportLogFailWithScreenshot("The CreditCard CVV tooltip message in using a new card Dialog is not displaying correctly after hovering on CVV icon");
				}
				this.getReusableActionsInstance().scrollToElement(lblUsingANewCardDialogCreditCVVTitle);
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditCVV);
			if(this.getReusableActionsInstance().isElementVisible(inputUsingANewCardDialogCreditCVV)){
				reporter.reportLogPass("The CreditCard CVV input in using a new card Dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The CreditCard CVV input in using a new card Dialog is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogTSCCardRadio);
		labelUsingANewCardDialogTSCCardRadio.click();
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogTSCCardRadio);
		if(this.inputUsingANewCardDialogTSCCardRadio.isEnabled()){
			reporter.reportLogPass("The TSC Radio button label in using a new card Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The TSC Radio button label in using a new card Dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelUsingANewCardDialogTSCCardRadio);
		if(this.getReusableActionsInstance().isElementVisible(labelUsingANewCardDialogTSCCardRadio)){
			reporter.reportLogPass("The TSC Radio button in using a new card Dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The TSC Radio button in using a new card Dialog is not displaying correctly");
		}

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

	/**
	 * This function return card type from payment method selected on checkout page
	 * @return - String
	 */
	public String getSelectedPaymentMethodFromCheckout(WebElement webElement){
		this.waitForPageToLoad();
		this.applyStaticWait(3000);
		String cardType = webElement.getAttribute("class").trim().toLowerCase();
		//reporter.reportLog("Card Type selected on page: "+cardType);
		if(cardType.contains("visa"))
			return "visa";
		else if(cardType.contains("mc"))
			return "master";
		else if(cardType.contains("amex"))
			return "amex";
		else if(cardType.contains("tsc"))
			return "tsc";
		return null;
	}

	/**
	 * To Go To Shopping Bag by clicking btnGoToShoppingBag button in header
	 * @return - boolean
	 */
	public boolean GoToShoppingBag(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnGoToShoppingBag);
		this.clickElement(btnGoToShoppingBag);
		ShoppingCartPage shoppingCartPage=new ShoppingCartPage(this.getDriver());
		return this.waitForCondition(Driver->{return shoppingCartPage.lblCartPricingOrderSummaryTitle.isDisplayed();},120000);
	}

	/**
	 * To wait For Page Loading Spinning Status Completed
	 * @return - boolean
	 */
	public boolean waitForPageLoadingSpinningStatusCompleted(){
		try{
			this.waitForCondition(Driver->{return !this.checkChildElementExistingByAttribute(this.cntFooterContainer,"class","loading__overlay");},120000);
		}
		catch(Exception e){
			this.applyStaticWait(30*this.getStaticWaitForApplication());
		}
		return true;
	}

	/**
	 * To get Shipping Date In Header
	 * @return - String
	 */
	public String getShippingDateInHeader() {
		if (this.checkProductShippingDateExisting()) {
			return this.getElementInnerText(this.lblShippingDate);
		}
		else{
			return null;
		}
	}

	/**
	 * To verify Shipping Address on Checkout Page
	 */
	public String verifyShippingAddressDisplayOnCheckout() {
		String lsText;

		reporter.reportLog("Verify shipping address contents");
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
		return lblShippingAddress.getText();
	}

	/**
	 * This function navigates to checkout page
	 */
	public void navigateToCheckoutPage(){
		String checkoutUrl = System.getProperty("QaUrl")+"/pages/expresscheckout";
		getDriver().navigate().to(checkoutUrl);
		waitForPageToLoad();
		waitForCondition(Driver->{return this.btnGoToShoppingBag.isDisplayed()
				&& this.btnGoToShoppingBag.isEnabled();},6000);
	}

	/**
	 * This function fetches error message from Add New Shipping Address Dialog
	 * @return - List<String> of error message displayed on screen
	 */
	public List<String> getMandatoryFieldsErrorMessage(int expectedErrorMessage){
		if(expectedErrorMessage==0)
			this.waitForCondition(Driver->{return this.mandatoryFieldErrorMessage.size()>0;},15000);
		else
			this.waitForCondition(Driver->{return this.mandatoryFieldErrorMessage.size()==expectedErrorMessage;},15000);
		int loop = this.mandatoryFieldErrorMessage.size();
		if(loop>0){
			List<String> errorMessageList = new ArrayList<>();
			for(int counter=0;counter<loop;counter++){
				errorMessageList.add(this.mandatoryFieldErrorMessage.get(counter).getText());
			}
			return errorMessageList;
		}else
			return null;
	}

	/**
	 * This function verifies error message on add new Shipping Address dialog with expected error message
	 * @param  - List<String> - expectedErrorMessageList
	 * @return - boolean
	 */
	public void verifyErrorMessageOnAddNewShippingAddressDialog(List<String> expectedErrorMessageList){
		if(System.getProperty("Device").equalsIgnoreCase("Desktop") ||
				(System.getProperty("Device").equalsIgnoreCase("Tablet") &&
						System.getProperty("Browser").contains("ios")) ||
				(System.getProperty("Browser").equalsIgnoreCase("chromemobile") &&
						System.getProperty("chromeMobileDevice").contains("iPad"))){
			this.waitForCondition(Driver->{return this.btnAddOrChangeShippingAddressDialogCloseButton.isEnabled() &&
					this.btnAddOrChangeShippingAddressDialogCloseButton.isDisplayed();},6000);
		}else
			this.waitForCondition(Driver->{return this.btnAddOrChangeShippingAddressDialogBackButton.isEnabled() &&
					this.btnAddOrChangeShippingAddressDialogBackButton.isDisplayed();},6000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddOrEditAddressDialogSaveButton);
		this.getReusableActionsInstance().clickIfAvailable(this.btnAddOrEditAddressDialogSaveButton);

		List<String> errorMessageList = this.getMandatoryFieldsErrorMessage(expectedErrorMessageList.size());
		if(errorMessageList.size()==expectedErrorMessageList.size()){
			for(String errorMessage:errorMessageList){
				if(expectedErrorMessageList.contains(errorMessage)){
					reporter.reportLogPass("Error message as expected is displayed : "+errorMessage);
				}else
					reporter.reportLogFailWithScreenshot("Error Message as expected is not displayed: "+errorMessage);
			}
		}else{
			reporter.reportLogFailWithScreenshot("Expected Error Message list size: "+expectedErrorMessageList.size()+" is not same as Actual Error Message list size: "+errorMessageList.size());
		}
	}

	/**
	 * This function verifies shipping address on checkout page with selected address on Add/Change Shipping Dialog
	 * @param - String - checkoutPageShippingAddress
	 * @param -String - addChangeDialogPageSelectedAddress
	 */
	public <T> void verifyShippingAddressOnCheckoutWithSelectedAddressOnAddChangeDialog(String checkoutPageShippingAddress,T addChangeDialogPageSelectedAddress){
		boolean flag = false;
		if(checkoutPageShippingAddress!=null && addChangeDialogPageSelectedAddress==null){
			String selectedAddress = this.verifyAddressOnAddChangeShippingAddressDialogAndReturnSelectedAddress(false);
			if(checkoutPageShippingAddress.trim().equalsIgnoreCase(selectedAddress.trim())){
				reporter.reportLogPass("Selected Address on Add/Change Dialog box is same as on checkout page");
				flag = true;
			}
			else
				reporter.reportLogFailWithScreenshot("Selected Address on Add/Change Dialog box: "+selectedAddress+" is not same as on checkout page: "+checkoutPageShippingAddress);
		}else if(checkoutPageShippingAddress==null && addChangeDialogPageSelectedAddress!=null && addChangeDialogPageSelectedAddress.getClass() == HashMap.class){
			//Fetching displayed address from checkout page
			String checkoutPageAddress = this.getAddressFromCheckoutPage("shipping");
			Map<String,Object> newAddress = (Map<String, Object>) addChangeDialogPageSelectedAddress;
			if(checkoutPageAddress.trim().contains(newAddress.get("address").toString())){
				reporter.reportLogPass("Address displayed on checkout page is new added address as expected");
				flag = true;
			}
			else
				reporter.reportLogFailWithScreenshot("Address displayed on checkout page: "+checkoutPageAddress+" is not same as new added address: "+newAddress.get("address").toString());
		}
		if(flag)
			reporter.reportLog("Verification of address on checkout page is done!");
		else
			reporter.reportLogFailWithScreenshot("Verification of address on checkout page is not done as expected");
	}

	/**
	 * This function deletes address from particular user
	 * @param - Map<String,Object> - newAddedAddress object
	 * @param -String - customerEDP
	 * @param -String - accessToken
	 * @throws - IOException
	 * @throws - ParseException
	 */
	public <T> void deleteNewAddedAddressFromUser(Map<String,T> newAddedAddress,String customerEDP,String accessToken) throws IOException, ParseException {
		if(newAddedAddress!=null && newAddedAddress.size()>0){
			CartAPI cartAPI = new CartAPI();
			Response response = cartAPI.getAccountCartContentWithCustomerEDP(customerEDP,accessToken);
			CartResponse cartResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
			CartResponse.AddressClass addressClass = cartResponse.getShippingAddress();
			Response shippingAddressDeleteResponse = null;

			//Verifying that address added was successful and there was no api call error while adding new address
			if(newAddedAddress.get("address").toString().toLowerCase().equalsIgnoreCase(addressClass.getStreet())){
				//Verifying that address to be deleted is same that was added
				if(this.verifyAddedAddressObject(newAddedAddress,addressClass)){
					shippingAddressDeleteResponse = new AccountAPI().deleteShippingAddressForUser(addressClass.getId(),customerEDP,accessToken);
					if(shippingAddressDeleteResponse.getStatusCode()==200)
						reporter.reportLog("Added address is deleted for user!");
					else
						reporter.reportLogFail("Added address is not deleted for user with status code from api: "+shippingAddressDeleteResponse.getStatusCode());
				}
			}else{
				//Verifying that address is not present in shippingAddresses object due to api error above
				List<CartResponse.AddressClass> shippingAddresses = cartResponse.getBuyer().getShippingAddresses();
				for(CartResponse.AddressClass loopAddressClass:shippingAddresses){
					//Verifying that address to be deleted is same that was added
					if(this.verifyAddedAddressObject(newAddedAddress,loopAddressClass)){
						shippingAddressDeleteResponse = new AccountAPI().deleteShippingAddressForUser(loopAddressClass.getId(),customerEDP,accessToken);
						if(shippingAddressDeleteResponse.getStatusCode()==200)
							reporter.reportLog("Added address is deleted for user from Shipping Addresses Object");
						else
							reporter.reportLogFail("Added address is not deleted for user from Shipping Addresses Object with status code from api: "+shippingAddressDeleteResponse.getStatusCode());
					}
				}
			}
		}else{
			AccountAPI accountAPI = new AccountAPI();
			reporter.reportLog("Deleting all shipping address for user");
			List<CartResponse.AddressClass> addressClass = new CartAPI().addShippingAddressForUser(customerEDP,accessToken,true,null);
			if(addressClass.size()>0){
				//Making shipping address as default shipping address
				Response response = accountAPI.updatingBillingAddressForUserInCart(customerEDP,accessToken,null);
				if(response.getStatusCode()==200)
					reporter.reportLog("Billing address is updated as shipping address");
				else
					reporter.reportLogFail("Billing address is not updated as shipping address while env. cleanup..");
			}

			for(CartResponse.AddressClass address : addressClass){
				accountAPI.deleteShippingAddressForUser(address.getId(),customerEDP,accessToken);
			}
		}
	}

	/**
	 *
	 * @param - Map<String,Object> - newAddedAddress object
	 * @param - CartResponse addressClass object
	 * @return - boolean
	 */
	public <T> boolean verifyAddedAddressObject(Map<String,T> newAddedAddress,CartResponse.AddressClass addressClass){
		String state = null;
		switch (newAddedAddress.get("province").toString().toLowerCase()){
			case "ontario":
				state = "ON";
				break;
			default:
				state = "Invalid";
				break;
		}

		if(newAddedAddress.get("address").toString().toLowerCase().equalsIgnoreCase(addressClass.getStreet()) &&
				newAddedAddress.get("city").toString().toLowerCase().equalsIgnoreCase(addressClass.getCity()) &&
				state.equalsIgnoreCase(addressClass.getState()) &&
				newAddedAddress.get("postalCode").toString().trim().replace(" ","").toLowerCase().equalsIgnoreCase(addressClass.getZipCode()) &&
				newAddedAddress.get("firstName").toString().toLowerCase().equalsIgnoreCase(addressClass.getFirstName()) &&
				newAddedAddress.get("lastName").toString().toLowerCase().equalsIgnoreCase(addressClass.getLastName()) &&
				newAddedAddress.get("phoneNumber").toString().toLowerCase().equalsIgnoreCase(addressClass.getDayPhone()))
			return true;
		else
			return false;
	}

	/**
	 * This function returns billing address from checkout page
	 * @param - billing address to be verifies
	 * @return - String
	 */
	public String verifyUserBillingAddress(String billingAddress){
		String pageBillingAddress = null;
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblBillingAddress);
		pageBillingAddress = this.getAddressFromCheckoutPage("billing");
		if(pageBillingAddress.trim().equalsIgnoreCase(billingAddress))
			reporter.reportLogPass("Billing Address for user is same as expected");
		else
			reporter.reportLogPass("Billing Address for user: "+pageBillingAddress+" is not as expected: "+billingAddress);

		return pageBillingAddress;
	}

	/**
	 * This function verifies that Edit Address Dialog box is pre populated
	 * @return - Map Object
	 */
	public Map<String,Object> verifyShippingAddressIsPopulatedForEdit(){
		this.waitForCondition(Driver->{return inputAddOrEditAddressDialogFirstName.isEnabled();},5000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogFirstName);
		String firstName = this.inputAddOrEditAddressDialogFirstName.getAttribute("value").trim();
		if(!firstName.isEmpty())
			reporter.reportLogPass("First Name for user is pre filled as expected: "+firstName);
		else
			reporter.reportLogFail("First Name for user is empty: "+firstName);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogLastName);
		String lastName = this.inputAddOrEditAddressDialogLastName.getAttribute("value").trim();
		if(!lastName.isEmpty())
			reporter.reportLogPass("Last Name for user is pre filled as expected: "+lastName);
		else
			reporter.reportLogFail("Last Name for user is empty: "+lastName);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogPhoneNumber);
		String phoneNumber = this.inputAddOrEditAddressDialogPhoneNumber.getAttribute("value").trim();
		if(!phoneNumber.isEmpty())
			reporter.reportLogPass("Phone Number for user is pre filled as expected: "+phoneNumber);
		else
			reporter.reportLogFail("Phone Number for user is empty: "+phoneNumber);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogAddress);
		String lsAddress=inputAddOrEditAddressDialogAddress.getAttribute("value").trim();
		if(!lsAddress.isEmpty())
			reporter.reportLogPass("Address for user is pre filled as expected: "+lsAddress);
		else
			reporter.reportLogFail("Address for user is empty: "+lsAddress);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogCity);
		String city=inputAddOrEditAddressDialogCity.getAttribute("value").trim();
		if(!city.isEmpty())
			reporter.reportLogPass("City for user is pre filled as expected: "+city);
		else
			reporter.reportLogFail("City for user is empty: "+city);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectAddOrEditAddressDialogProvince);
		String province=this.getReusableActionsInstance().getSelectedValue(this.selectAddOrEditAddressDialogProvince).trim();
		if(!province.isEmpty())
			reporter.reportLogPass("Province for user is pre filled as expected: "+province);
		else
			reporter.reportLogFail("Province for user is empty: "+province);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputAddOrEditAddressDialogPostalCode);
		String postalCode=inputAddOrEditAddressDialogPostalCode.getAttribute("value").trim();
		if(!postalCode.isEmpty())
			reporter.reportLogPass("Postal Code for user is pre filled as expected: "+postalCode);
		else
			reporter.reportLogFail("Postal Code for user is empty: "+postalCode);

		Map<String,Object> map=new HashMap<>();
		map.put("firstName",firstName);
		map.put("lastName",lastName);
		map.put("phoneNumber",phoneNumber);
		map.put("address",lsAddress);
		map.put("city",city);
		map.put("province",province);
		map.put("postalCode",postalCode);

		return map;
	}

	/**
	 * This function returns shipping or billing address from checkout page
	 * @param  - addressType - type of address
	 * @return - String Object
	 */
	public String getAddressFromCheckoutPage(String addressType){
		if(addressType.toLowerCase().contains("billing"))
			return this.lblBillingAddress.getText();
		else if(addressType.toLowerCase().contains("shipping"))
			return this.lblShippingAddress.getText();
		return null;
    }

    /**
     * This function verifies and return address from Add/Change Dialog Box
     * @param - Map<String,Object> - addEditAddress object
     * @return - String
     */
    public String verifyAndReturnShippingAddressFromAddEditDialogOnAddChangeDialog(Map<String,Object> addEditAddress){
		String selectedAddress = this.verifyAddressOnAddChangeShippingAddressDialogAndReturnSelectedAddress(false);
		if(selectedAddress.toLowerCase().contains(addEditAddress.get("address").toString().toLowerCase()) &&
				selectedAddress.toLowerCase().contains(addEditAddress.get("firstName").toString().toLowerCase()) &&
				selectedAddress.toLowerCase().contains(addEditAddress.get("lastName").toString().toLowerCase()) &&
				selectedAddress.toLowerCase().contains(addEditAddress.get("city").toString().toLowerCase()) &&
				selectedAddress.toLowerCase().contains(addEditAddress.get("postalCode").toString().toLowerCase().replace(" ","")))
			reporter.reportLogPass("New address added or address edited is same as expected");
		else
			reporter.reportLogFailWithScreenshot("New address added or address edited: "+selectedAddress+" is not same");

		return selectedAddress;
	}

    /**
     * This function updates shipping address for user
     * @param - Map<String,String> - selectedShippingAddress object to be updated
     */
	public void updateAddressForUserOnCheckout(List<Map<String,String>> selectedAddress,String addressType,String customerEDP,String accessToken) throws IOException {
		boolean flag;
		//Verify current shipping address
		if(addressType.equalsIgnoreCase("shipping")){
			flag = this.verifyAddressOnCheckoutPage(selectedAddress,"shipping");
			if(flag){
				WebElement addressItem,item;
				this.openAddOrChangeAddressDialog();
				int loopSize=lstAddOrChangeShippingAddressDialogAvailableShippingAddress.size();
				for(int i=0;i<loopSize;i++){
					addressItem=lstAddOrChangeShippingAddressDialogAvailableShippingAddress.get(i);
					item=addressItem.findElement(byAddOrChangeShippingAddressDialogHeaderContent);
					String headerText = this.getElementText(item);
					if(headerText.toLowerCase().contains("selected")){
						continue;
					}else{
						this.getReusableActionsInstance().clickIfAvailable(item);
						this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddOrEditAddressDialogSaveButton);
						this.getReusableActionsInstance().clickIfAvailable(this.btnAddOrEditAddressDialogSaveButton);
						this.waitForPageLoadingSpinningStatusCompleted();
						break;
					}
				}
			}
		}else if(addressType.equalsIgnoreCase("billing")){
			flag = this.verifyAddressOnCheckoutPage(selectedAddress,"billing");
			if(flag){
				//Getting Shipping Address to be updated as Billing Address
				CartAPI cartAPI = new CartAPI();
				Response response = cartAPI.getAccountCartContentWithCustomerEDP(customerEDP,accessToken);
				CartResponse cartResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
				CartResponse.AddressClass addressClass = cartResponse.getShippingAddress();
				//Click on Change Button to update Billing Address
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnBillingAddressChange);
				this.getReusableActionsInstance().clickIfAvailable(this.btnBillingAddressChange);
				waitForCondition(Driver->{return this.btnAddOrEditAddressDialogSaveButton.isEnabled();},4000);
				this.inputAddressOnDialog(addressClass.getFirstName(),addressClass.getLastName(),
						addressClass.getDayPhone(),new String[] {addressClass.getStreet()});
				//Clicking on Save Button
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddOrEditAddressDialogSaveButton);
				this.getReusableActionsInstance().clickIfAvailable(this.btnAddOrEditAddressDialogSaveButton);
				waitForPageLoadingSpinningStatusCompleted();
			}
		}
	}

	/**
	 * This function deletes input address for clean environment
	 * @param - List<Map<String,String>>- inputAddress List Object
	 * @param - String - customerEDP
	 * @param - String - accessToken
	 * @throws IOException
	 * @throws ParseException
	 */
	public void deleteInputAddressForNextTestRunForUser(List<Map<String,String>> inputAddress,String customerEDP,String accessToken) throws IOException, ParseException {
		List<Integer> addressId = new ArrayList<>();

		//Update shipping address for user
		this.updateAddressForUserOnCheckout(inputAddress,"shipping",customerEDP,accessToken);

		//Update billing address for user
		this.updateAddressForUserOnCheckout(inputAddress,"billing",customerEDP,accessToken);

		//Fetching account details for user
		AccountAPI accountAPI = new AccountAPI();
		CartAPI cartAPI = new CartAPI();
		Response response = accountAPI.getAccountDetailsFromCustomerEDP(customerEDP,accessToken);
		AccountResponse accountCartResponse = JsonParser.getResponseObject(response.asString(), new TypeReference<AccountResponse>() {});
		//Verifying if billing address contains input address and if so, fetching address if for deletion
		for(Map<String,String> address:inputAddress){
			if(address.get("firstName").equalsIgnoreCase(accountCartResponse.getBillingAddress().getFirstName()) &&
					address.get("lastName").equalsIgnoreCase(accountCartResponse.getBillingAddress().getLastName()) &&
					address.get("address").equalsIgnoreCase(accountCartResponse.getBillingAddress().getStreet())){
				addressId.add(accountCartResponse.getBillingAddress().getId());
				//Setting billingAddressFlag to update billing address later
				break;
			}
		}
		//Verifying if shipping address contains input address and if so, fetching address if for deletion
		for(Map<String,String> address:inputAddress){
			List<AccountResponse.AddressClass> shippingAddressList = accountCartResponse.getShippingAddresses();
			for(AccountResponse.AddressClass addressClass:shippingAddressList){
				if(address.get("firstName").equalsIgnoreCase(addressClass.getFirstName()) &&
						address.get("lastName").equalsIgnoreCase(addressClass.getLastName()) &&
						address.get("address").equalsIgnoreCase(addressClass.getStreet())){
					addressId.add(addressClass.getId());
				}
			}
		}
		//Deleting the added input address from user
		for(Integer addressIdDeleted:addressId){
			accountAPI.deleteShippingAddressForUser(addressIdDeleted,customerEDP,accessToken);
		}
    }

	/**
	 * This function verifies input address is present on checkout page
	 * @param - List<Map<String,String>> - inputAddress List Object
	 * @param - String - addressType
	 * @return - boolean value
	 */
    public boolean verifyAddressOnCheckoutPage(List<Map<String,String>> inputAddress,String addressType){
		String screenAddress = this.getAddressFromCheckoutPage(addressType);
		for(Map<String,String> address:inputAddress){
			if(screenAddress.contains(address.get("address")))
				return true;
		}
		return false;
	}

	/**
	 * To Apply Promote Code For Positive Scenario
	 * @param - List<String> - promoteCodeList
	 * @return - String
	 */
	public String applyPromoteCodeForPositiveScenario(List<String> promoteCodeList){
		String lsFindPromoteCode="";
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryPromoteCode);
		for(String promoteCode:promoteCodeList){
			inputOrderSummaryPromoteCode.clear();
			inputOrderSummaryPromoteCode.sendKeys(promoteCode);
			this.applyStaticWait(300);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderSummaryPromoteCodeApply);
			this.clickWebElementUsingJS(btnOrderSummaryPromoteCodeApply);
			try{
				this.waitForPageLoadingSpinningStatusCompleted();
			}
			catch (Exception e){

			}

			try{
				this.waitForCondition(Driver->{return lblOrderSummaryPromoteCodeAppliedMessage.isDisplayed();},15000);
				lsFindPromoteCode=promoteCode;
				break;
			}
			catch(Exception e){

			}
		}

		return lsFindPromoteCode;
	}

	/**
	 * To Apply Promote Code For negative Scenario
	 * @param - String - promoteCode
	 * @return - boolean
	 */
	public boolean applyPromoteCodeForNegativeScenario(String promoteCode){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryPromoteCode);
		inputOrderSummaryPromoteCode.clear();
		inputOrderSummaryPromoteCode.sendKeys(promoteCode);
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderSummaryPromoteCodeApply);
		this.clickElement(btnOrderSummaryPromoteCodeApply);

		return this.waitForCondition(Driver->{return lblOrderSummaryPromoteCodeErrorMessage.isDisplayed();},15000);
	}

	/**
	 * To remove promote code
	 * @return - boolean
	 */
	public boolean removePromoteCode(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnOrderSummaryRemovePromoteCode);
		this.btnOrderSummaryRemovePromoteCode.click();

		return this.waitForCondition(Driver->{return this.btnOrderSummaryPromoteCodeApply.isDisplayed();},15000);
	}

	/**
	 * To Apply Gift Card for positive scenario
	 * @param - List<Map<String,String>> - giftCardList
	 * @param - int - initialGiftCardNumberLength
	 * @return - boolean
	 */
	public boolean applyGiftCardForPositiveScenario(List<Map<String,String>> giftCardList, int initialGiftCardNumberLength){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryGiftCardNumber);
		String giftCardNumber,giftCardPin;
		this.applyStaticWait(3*this.getStaticWaitForApplication());
		for(Map<String,String> giftCard:giftCardList){
			giftCardNumber=giftCard.get("GiftCardNumber");
			giftCardPin=giftCard.get("GiftCardPin");

			if(initialGiftCardNumberLength>0){
				giftCardNumber=giftCardNumber.substring(initialGiftCardNumberLength);
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryGiftCardNumber);
			inputOrderSummaryGiftCardNumber.clear();
			inputOrderSummaryGiftCardNumber.sendKeys(giftCardNumber);
			this.applyStaticWait(300);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryGiftCardPin);
			inputOrderSummaryGiftCardPin.clear();
			inputOrderSummaryGiftCardPin.sendKeys(giftCardPin);
			this.applyStaticWait(300);
			
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderSummaryGiftCardApply);
			this.clickElement(btnOrderSummaryGiftCardApply);
			try{
				this.waitForPageLoadingSpinningStatusCompleted();
			}
			catch (Exception e){
				this.applyStaticWait(3*this.getStaticWaitForApplication());
			}

			try{
				this.waitForCondition(Driver->{return this.checkGiftCardRemoveButtonExisting();},15000);
				return true;
			}
			catch (Exception e){
				continue;
			}
		}
		return false;
	}

	/**
	 * To Apply Gift Card
	 * @param - String - giftCardNumber
	 * @param - String - giftCardPin
	 * @param - int - initialGiftCardNumberLength
	 * @param - boolean - bPositive
	 * @return - boolean
	 */
	public boolean applyGiftCard(String giftCardNumber, String giftCardPin, int initialGiftCardNumberLength, boolean bPositive){
		if(initialGiftCardNumberLength>0){
			giftCardNumber=giftCardNumber.substring(initialGiftCardNumberLength);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryGiftCardNumber);
		inputOrderSummaryGiftCardNumber.clear();
		inputOrderSummaryGiftCardNumber.sendKeys(giftCardNumber);
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryGiftCardPin);
		inputOrderSummaryGiftCardPin.clear();
		inputOrderSummaryGiftCardPin.sendKeys(giftCardPin);
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderSummaryGiftCardApply);
		this.clickElement(btnOrderSummaryGiftCardApply);

		if(bPositive){
			return this.waitForCondition(Driver->{return lblOrderSummaryGiftCardAppliedMessage.isDisplayed();},15000);
		}
		else{
			return this.waitForCondition(Driver->{return lblOrderSummaryGiftCardErrorMessage.isDisplayed();},15000);
		}
	}

	/**
	 * To Apply Gift Card for negative scenario
	 * @param - String - giftCardNumber
	 * @param - String - giftCardPin
	 * @param - int - initialGiftCardNumberLength
	 * @return - boolean
	 */
	public boolean applyGiftCardForNegativeScenario(String giftCardNumber, String giftCardPin, int initialGiftCardNumberLength){
		if(initialGiftCardNumberLength>0){
			giftCardNumber=giftCardNumber.substring(initialGiftCardNumberLength);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryGiftCardNumber);
		inputOrderSummaryGiftCardNumber.clear();
		inputOrderSummaryGiftCardNumber.sendKeys(giftCardNumber);
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputOrderSummaryGiftCardPin);
		inputOrderSummaryGiftCardPin.clear();
		inputOrderSummaryGiftCardPin.sendKeys(giftCardPin);
		this.applyStaticWait(300);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderSummaryGiftCardApply);
		this.clickWebElementUsingJS(btnOrderSummaryGiftCardApply);

		return this.waitForCondition(Driver->{return lblOrderSummaryGiftCardErrorMessage.isDisplayed();},15000);
	}

	/**
	 * To remove gift card
	 * @return - boolean
	 */
	public boolean removeGiftCard(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnOrderSummaryRemoveGiftCard);
		this.btnOrderSummaryRemoveGiftCard.click();

		return this.waitForCondition(Driver->{return this.btnOrderSummaryGiftCardApply.isDisplayed();},15000);
	}

	/**
	 * To verify product list Linkage Between ShoppingCart Page And Checkout Page
	 * @param - Map<String,Object> - shoppingCartItem
	 * @param - Map<String,Object> - checkoutItem
	 */
	public void verifyProductListLinkageBetweenShoppingCartPageAndCheckoutPage(Map<String,Object> shoppingCartItem,Map<String,Object> checkoutItem){
		String lsShoppingCartText,lsCheckoutText;

		lsShoppingCartText=(String)shoppingCartItem.get("productName");
		lsCheckoutText=(String)checkoutItem.get("productName");
		if(lsShoppingCartText.equalsIgnoreCase(lsCheckoutText)){
			reporter.reportLogPass("The productName in shoppingCart Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The productName:"+lsShoppingCartText+" in shoppingCart Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
		}

		lsShoppingCartText=(String)shoppingCartItem.get("productStyle");
		lsCheckoutText=(String)checkoutItem.get("productStyle");
		if(lsShoppingCartText==null){
			if(lsCheckoutText==null){
				reporter.reportLogPass("The productStyle in shoppingCart Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productStyle in shoppingCart Item is not the same as the one in checkout Item");
			}
		}
		else{
			if(lsShoppingCartText.equalsIgnoreCase(lsCheckoutText)){
				reporter.reportLogPass("The productStyle in shoppingCart Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productStyle:"+lsShoppingCartText+" in shoppingCart Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}
		}

		lsShoppingCartText=(String)shoppingCartItem.get("productSize");
		lsCheckoutText=(String)checkoutItem.get("productSize");
		if(lsShoppingCartText==null){
			if(lsCheckoutText==null){
				reporter.reportLogPass("The productSize in shoppingCart Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productSize in shoppingCart Item is not the same as the one in checkout Item");
			}
		}
		else{
			if(lsShoppingCartText.equalsIgnoreCase(lsCheckoutText)){
				reporter.reportLogPass("The productSize in shoppingCart Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productSize:"+lsShoppingCartText+" in shoppingCart Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}
		}

		if((boolean)shoppingCartItem.get("productBadge")==(boolean)checkoutItem.get("productBadge")){
			reporter.reportLogPass("The productBadge in shoppingCart Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The productBadge in shoppingCart Item is not the same as the one in checkout Item");
		}

		/*
		lsShoppingCartText=(String)shoppingCartItem.get("productNumber");
		lsCheckoutText=(String)checkoutItem.get("productNumber");
		if(lsShoppingCartText==null){
			if(lsCheckoutText==null){
				reporter.reportLogPass("The productNumber in shoppingCart Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productNumber in shoppingCart Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}
		}
		else{
			if(lsShoppingCartText.equalsIgnoreCase(lsCheckoutText)){
				reporter.reportLogPass("The productNumber in shoppingCartItem is the same as the one in checkoutItem");
			}
			else{
				reporter.reportLogFail("The productNumber:"+lsShoppingCartText+" in shoppingCart Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}
		}

		lsShoppingCartText=(String)shoppingCartItem.get("productShippingDate");
		lsCheckoutText=(String)checkoutItem.get("productShippingDate");
		if(lsShoppingCartText==null){
			if(lsCheckoutText==null){
				reporter.reportLogPass("The productShippingDate in shoppingCart Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productShippingDate in shoppingCart Item is not the same as the one in checkout Item:'"+lsCheckoutText+"'");
			}
		}
		else{
			if(lsShoppingCartText.equalsIgnoreCase(lsCheckoutText)){
				reporter.reportLogPass("The productShippingDate in shoppingCart Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productShippingDate:"+lsShoppingCartText+" in shoppingCart Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}
		}
		*/

		int shoppingCartLeftNumber=(int)shoppingCartItem.get("productLeftNumber");
		int checkoutLeftNumber=(int)checkoutItem.get("productLeftNumber");
		if(shoppingCartLeftNumber==checkoutLeftNumber){
			reporter.reportLogPass("The productLeftNumber in shoppingCart Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The productLeftNumber:"+shoppingCartLeftNumber+" in shoppingCart Item is not the same as the one:"+checkoutLeftNumber+" in checkout Item");
		}

		if(!this.checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
			lsShoppingCartText=(String)shoppingCartItem.get("productFreeShipping");
			lsCheckoutText=(String)checkoutItem.get("productFreeShipping");
			if(lsShoppingCartText==null){
				if(lsCheckoutText==null){
					reporter.reportLogPass("The productFreeShipping in shoppingCart Item is the same as the one in checkout Item");
				}
				else{
					reporter.reportLogFail("The productFreeShipping in shoppingCart Item is not the same as the one in checkout Item");
				}
			}
			else{
				if(lsShoppingCartText.equalsIgnoreCase(lsCheckoutText)){
					reporter.reportLogPass("The productFreeShipping in shoppingCart Item is the same as the one in checkout Item");
				}
				else{
					reporter.reportLogFail("The productFreeShipping:"+lsShoppingCartText+" in shoppingCart Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
				}
			}
		}
	}

	/**
	 * To verify OrderSummary Linkage Between ShoppingCart Page And Checkout Page
	 * @param - Map<String,Object> - shoppingCartItem
	 * @param - Map<String,Object> - checkoutItem
	 */
	public void verifyOrderSummaryLinkageBetweenShoppingCartPageAndCheckoutPage(Map<String,Object> shoppingCartItem,Map<String,Object> checkoutItem) {
		float shoppingCartValue, checkoutValue;
		String lsShoppingCartText,lsCheckoutText;

		shoppingCartValue = (float) shoppingCartItem.get("subTotal");
		checkoutValue = (float) checkoutItem.get("subTotal");
		if (Math.abs(shoppingCartValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The subTotal in shoppingCart Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The subTotal:"+shoppingCartValue+" in shoppingCart Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		if(this.checkOrderSummaryWasPriceExisting()){
			shoppingCartValue = (float) shoppingCartItem.get("wasPrice");
			checkoutValue = (float) checkoutItem.get("wasPrice");
			if (Math.abs(shoppingCartValue-checkoutValue)<0.1f) {
				reporter.reportLogPass("The wasPrice in shoppingCart Item is the same as the one in checkout Item");
			} else {
				reporter.reportLogFail("The wasPrice:"+shoppingCartValue+" in shoppingCart Item is not the same as the one:"+checkoutValue+" in checkout Item");
			}
		}

		shoppingCartValue = (float) shoppingCartItem.get("nowPrice");
		checkoutValue = (float) checkoutItem.get("nowPrice");
		if (Math.abs(shoppingCartValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The nowPrice in shoppingCart Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The nowPrice:"+shoppingCartValue+" in shoppingCart Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		lsShoppingCartText = (String) shoppingCartItem.get("province");
		lsCheckoutText = (String) checkoutItem.get("province");
		if (lsShoppingCartText.equalsIgnoreCase(lsCheckoutText)) {
			reporter.reportLogPass("The province in shoppingCart Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The province:"+lsShoppingCartText+" in shoppingCart Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
		}

		shoppingCartValue = (float) shoppingCartItem.get("tax");
		checkoutValue = (float) checkoutItem.get("tax");
		if (Math.abs(shoppingCartValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The tax in shoppingCart Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The tax:"+shoppingCartValue+" in shoppingCart Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		String lsType=this.judgeAppliedDiscountType();
		if(lsType!=null){
			if((lsType.equalsIgnoreCase("Both")||lsType.equalsIgnoreCase("PromoteCode"))){
				shoppingCartValue = (float) shoppingCartItem.get("promoteCodeValue");
				checkoutValue = (float) checkoutItem.get("promoteCodeValue");
				if (Math.abs(shoppingCartValue-checkoutValue)<0.1f) {
					reporter.reportLogPass("The promoteCode Value in shoppingCart Item is the same as the one in checkout Item");
				} else {
					reporter.reportLogFail("The promoteCode Value:"+shoppingCartValue+" in shoppingCart Item is not the same as the one:"+checkoutValue+" in checkout Item");
				}
			}

			if(lsType.equalsIgnoreCase("Both")||lsType.equalsIgnoreCase("GiftCard")){
				shoppingCartValue = (float) shoppingCartItem.get("giftCardValue");
				checkoutValue = (float) checkoutItem.get("giftCardValue");
				if (Math.abs(shoppingCartValue-checkoutValue)<0.1f) {
					reporter.reportLogPass("The giftCard Value in shoppingCart Item is the same as the one in checkout Item");
				} else {
					reporter.reportLogFail("The giftCard Value:"+shoppingCartValue+" in shoppingCart Item is not the same as the one:"+checkoutValue+" in checkout Item");
				}
			}
		}

		shoppingCartValue = (float) shoppingCartItem.get("totalPrice");
		checkoutValue = (float) checkoutItem.get("totalPrice");
		if (Math.abs(shoppingCartValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The totalPrice in shoppingCart Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The totalPrice:"+shoppingCartValue+" in shoppingCart Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}
	}

	/**
	 * To verify EasyPayment Linkage Between ShoppingCart Page And Checkout Page
	 * @param - Map<String,Object> - shoppingCartItem
	 * @param - Map<String,Object> - checkoutItem
	 */
	public void verifyEasyPaymentLinkageBetweenShoppingCartPageAndCheckoutPage(Map<String,Object> shoppingCartItem,Map<String,Object> checkoutItem) {
		float shoppingCartValue, checkoutValue;

		int shoppingCartInstallmentsNumber = (int) shoppingCartItem.get("installmentsNumber");
		int checkoutInstallmentsNumber = (int) checkoutItem.get("installmentsNumber");
		if (shoppingCartInstallmentsNumber==checkoutInstallmentsNumber) {
			reporter.reportLogPass("The installmentsNumber in shoppingCart Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The installmentsNumber:"+shoppingCartInstallmentsNumber+" in shoppingCart Item is not the same as the one:"+checkoutInstallmentsNumber+" in checkout Item");
		}

		shoppingCartValue = (float) shoppingCartItem.get("todayPayment");
		checkoutValue = (float) checkoutItem.get("todayPayment");
		if (Math.abs(shoppingCartValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The todayPayment in shoppingCart Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The todayPayment:"+shoppingCartValue+" in shoppingCart Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		shoppingCartValue = (float) shoppingCartItem.get("leftPayment");
		checkoutValue = (float) checkoutItem.get("leftPayment");
		if (Math.abs(shoppingCartValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The leftPayment in shoppingCart Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The leftPayment:"+shoppingCartValue+" in shoppingCart Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		shoppingCartValue = (float) shoppingCartItem.get("futureMonthlyPayment");
		checkoutValue = (float) checkoutItem.get("futureMonthlyPayment");
		if (Math.abs(shoppingCartValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The futureMonthlyPayment in shoppingCart Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The futureMonthlyPayment:"+shoppingCartValue+" in shoppingCart Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}
	}

	/**
	 * This function deletes credit card associated with cart and with user
	 * @param - String - customerEDP
	 * @param - String - accessToken
	 * @return - Boolean
	 * @throws - IOException
	 */
	public Boolean deleteCreditCardForUserAndFromCart(CartResponse cartResponse, String customerEDP, String accessToken) throws IOException {
		CartAPI cartAPI = new CartAPI();
		AccountAPI accountAPI = new AccountAPI();
		if(cartResponse!=null) {
			List<CartResponse.CreditCardsClass> creditCardsClassList = cartResponse.getBuyer().getCreditCards();
			if(creditCardsClassList.size()>0){
				for(CartResponse.CreditCardsClass creditCardsClass:creditCardsClassList){
					Response creditCardDeleteResponse = null;
					creditCardDeleteResponse = accountAPI.deleteCreditCardFromUser(creditCardsClass.getId(),customerEDP,accessToken);
					if(creditCardDeleteResponse!=null && creditCardDeleteResponse.getStatusCode()==200)
						continue;
					else{
						reporter.reportLog("Credit Card is not deleted as expected..");
						return false;
					}
				}
			}
			CartResponse.CreditCardsClass cartCreditCard = cartResponse.getCreditCard();
			if(cartCreditCard!=null){
				int cartCreditCardId = cartResponse.getCreditCard().getId();
				Response cartCreditCardDeleteResponse = cartAPI.deletePaymentDetailsForUserFromCart(customerEDP,String.valueOf(cartCreditCardId),accessToken);
				if(cartCreditCardDeleteResponse.statusCode()==200)
					return true;
				else{
					reporter.reportLog("Credit Card for cart payment is not deleted as expected..");
					return false;
				}
			}else
				return true;
		}
		return false;
	}

	/**
	 * This function verifies error message on screen
	 * @param - webElement
	 * @param - expectedMessage
	 * @return - Boolean value
	 */
	public Boolean verifyErrorMessage(WebElement webElement, String expectedMessage){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(webElement);
		String errorMessage = webElement.getText().trim();
		if(errorMessage.equalsIgnoreCase(expectedMessage)){
			reporter.reportLogPass("Error Message is as expected: "+errorMessage);
			return true;
		}else
			reporter.reportLogFail("Error Message on screen: "+errorMessage+ " is not as expected: "+expectedMessage);
		return false;
	}

	/**
	 * This function verifies mandatory error message on Payment Type Dialog
	 * @param - expectedErrorMessageList list Object of error message
	 */
	public void verifyErrorMessageOnAddPaymentMethodDialog(List<String> expectedErrorMessageList){
		List<String> errorMessage = new ArrayList<>();
		String expectedErrorMessage = this.formatStringForDelimiter(expectedErrorMessageList.get(0),".");
		this.waitForCondition(Driver->{return this.lblUsingANewCardSelectTitle.getText().trim().toLowerCase().contains("card type");},5000);
		List<WebElement> errorMessageWebElementList = this.lstCreditCardMandatoryErrorMessage;
		for(WebElement webElement:errorMessageWebElementList){
			errorMessage.add(webElement.getText());
		}
		if(errorMessage.size() == expectedErrorMessageList.size()){
			reporter.reportLogPass("Actual and Expected Error Message are same as expected");
			for(String message:errorMessage){
				String actualErrorMessage = this.formatStringForDelimiter(message,".");
				if(expectedErrorMessage.equalsIgnoreCase(actualErrorMessage))
					reporter.reportLogPass("Error Message is as expected: "+message);
				else
					reporter.reportLogFailWithScreenshot("Error Message is not as expected: "+message);
			}
		}else
			reporter.reportLogFail("Expected Error Message size: "+expectedErrorMessageList.size()+" is not same as actual error message size: "+errorMessage.size());
	}

	/**
	 * This function verifies expected card type
	 * @param - String - selectedCardText
	 * @param - String - expectedText
	 * @return
	 */
	public Boolean getFormatStringFromPaymentAddDialogForSelectedCard(String selectedCardText, String expectedText){
		if(selectedCardText.trim().toLowerCase().replace("\n","").contains(expectedText.toLowerCase()))
			return true;
		else
			return false;
	}

	/**
	 * This function formats string on the basis of a delimiter
	 * @param - String - inputString
	 * @param - String - delimiter
	 * @return
	 */
	public String formatStringForDelimiter(String inputString,String delimiter){
		String formatString = null;
		String[] formatStringArray = new String[0];
		if(delimiter.equalsIgnoreCase("."))
			formatStringArray = inputString.split("\\.");
		for(String string:formatStringArray) {
			if (formatString == null)
				formatString = string.trim();
			else
				formatString = string.trim() + formatString;
		}
		return formatString;
	}

	/**
	 * This function verifies pay pal functionality
	 */
	public void verifyPayPalFunctionality(){
		this.clickWebElementUsingJS(this.labelAddOrChangePaymentMethodDialogPaypalRadio);
		this.applyStaticWait(5*this.getStaticWaitForApplication());
		this.getDriver().switchTo().frame(this.framePayPalFrameElement);
		this.waitForCondition(Driver->{return this.btnPayPalButton.isEnabled();},5000);
		this.clickElement(this.btnPayPalButton);
		this.getDriver().switchTo().defaultContent();
		this.verifyPayPalPopUpExistenceOnClick();
	}

	/**
	 * This function verifies that Pay Pal pop up appears from checkout page
	 */
	public void verifyPayPalPopUpExistenceOnClick(){
		boolean flag = false;
		String parentWindowHandle = this.getDriver().getWindowHandle();
		//Switch to PayPal frame
		this.getDriver().switchTo().frame(framePayPalFrameElement);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnPayPalButton);
		this.waitForCondition(Driver->{return this.btnPayPalButton.isEnabled();},6000);
		this.getReusableActionsInstance().clickIfAvailable(this.btnPayPalButton);
		try{
			this.waitForCondition(Driver->{return this.getDriver().getWindowHandles().size()>1;},15000);
		}
		catch (Exception ex){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnPayPalButton);
			this.waitForCondition(Driver->{return this.btnPayPalButton.isEnabled();},6000);
			this.getReusableActionsInstance().clickIfAvailable(this.btnPayPalButton);
		}

		Set<String> windowHandles = this.getDriver().getWindowHandles();
		if(windowHandles.size()>1){
			for(String windowHandle:windowHandles){
				if(!windowHandle.equalsIgnoreCase(parentWindowHandle)){
					flag = true;
					this.getDriver().switchTo().window(windowHandle);
					this.waitForCondition(Driver->{return this.getReusableActionsInstance().isElementVisible(this.inputPayPalEmailInput) && this.inputPayPalEmailInput.isEnabled();},10000);
					String payPalUrl = this.getDriver().getCurrentUrl();
					if(payPalUrl.contains("paypal.com"))
						reporter.reportLogPass("User is navigated to PayPal pop up as expected");
					else
						reporter.reportLogFail("User is not navigated to PayPal pop up as expected with url: "+payPalUrl);

					//Verification of email input box
					if(this.getReusableActionsInstance().isElementVisible(this.inputPayPalEmailInput) && this.inputPayPalEmailInput.isEnabled())
						reporter.reportLog("Email Input on Pay Pal Pop Up is enabled");
					else
						reporter.reportLogFailWithScreenshot("Email input on Pay Pal pop up is either not displayed or not enabled");

					this.getDriver().close();
				}
				if(flag){
					this.getReusableActionsInstance().switchToMainWindow(parentWindowHandle);
					//Applying static wait as page takes time to load and all elements are already available in dom, hence applying waitForCondition will not help
					this.applyStaticWait(3000);
					break;
				}
			}
			if(flag)
				reporter.reportLogPass("Verification for pay pal pop is done");
			else
				reporter.reportLogFailWithScreenshot("Verification for pay pal pop is not done as expected!");
		}else
			reporter.reportLogFailWithScreenshot("Pay Pal pop up is not displayed as expected");
	}

	/**
	 * This function gets selected credit card type from payment option dialog box
	 * @return - String
	 */
	public String getSelectedCardTypeOnPaymentMethodDialog(){
		WebElement cardType;
		String selectedText,cardLogo = null;
		Boolean creditCardText;
		this.waitForCondition(Driver->{return this.lstAddOrChangePaymentMethodDialogAvailableCardContainer.size()>0;},5000);
		int loopSize=lstAddOrChangePaymentMethodDialogAvailableCardContainer.size();
		for(int i=0;i<loopSize;i++) {
			cardType = lstAddOrChangePaymentMethodDialogAvailableCardContainer.get(i);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(cardType);
			selectedText = cardType.getText();
			creditCardText = this.getFormatStringFromPaymentAddDialogForSelectedCard(selectedText,"selectededitremove");
			if(creditCardText){
				cardLogo = this.getSelectedPaymentMethodFromCheckout(cardType.findElement(this.byAddOrChangePaymentMethodDialogCardLogo));
				break;
			}
		}
		return cardLogo;
	}

	/**
	 * This function edits and verifies added card for new expiry
	 * @param - String - cardType
	 * @param - String - expiredMonth
	 * @param - String - expiredYear
	 * @param - JSONObject - creditCardData
	 * @param - Boolean - validCard
	 */
	public void editAndVerifyAddedCreditCardInPaymentMethodForUser(String cardType, String expiredMonth, String expiredYear,JSONObject creditCardData, Boolean validCard){
		this.addNewCreditOrEditExistingCard(cardType,validCard,true);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateMonth);
		inputUsingANewCardDialogCreditExpirationDateMonth.clear();
		inputUsingANewCardDialogCreditExpirationDateMonth.sendKeys(expiredMonth);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditExpirationDateYear);
		inputUsingANewCardDialogCreditExpirationDateYear.clear();
		inputUsingANewCardDialogCreditExpirationDateYear.sendKeys(expiredYear.substring(2));

		if(this.checkCVVSectionExisting()){
			String cardCVV= (String) creditCardData.get("CVV");
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputUsingANewCardDialogCreditCVV);
			inputUsingANewCardDialogCreditCVV.clear();
			inputUsingANewCardDialogCreditCVV.sendKeys(cardCVV);
		}

		this.closeUsingANewCardDialog(true);
		//Applying static wait as UI takes some time for new expiry to be updated and there is no other condition to wait for
		this.applyStaticWait(3000);
		this.verifyPaymentMethodOnCheckoutWithCardOnAddChangeDialog(null, creditCardData,expiredMonth,expiredYear);
	}

	public void refreshPageForMobileTablet(){
		if(!System.getProperty("Device").equalsIgnoreCase("Desktop")){
			this.getDriver().navigate().refresh();
			this.waitForPageToLoad();
			this.waitForCondition(Driver->{return this.btnAddOrChangePaymentMethod.isDisplayed() &&
					this.btnAddOrChangePaymentMethod.isEnabled();},12000);
			this.openAddOrChangePaymentMethodDialog();
		}
	}

	/**
	 * To get Gift Card Discount info From Applied Message
	 * @return - float
	 */
	public float getGiftCardDiscountFromAppliedMessage(){
		return this.getFloatFromString(this.getElementInnerText(this.lblOrderSummaryGiftCardAppliedMessage));
	}

	/**
	 * To go to Order confirmation page
	 */
	public void goToOrderConfirmationPage(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement( btnOrderSummaryPlaceOrder);
		this.clickElement( btnOrderSummaryPlaceOrder);

		try{
			this.waitForPageLoadingSpinningStatusCompleted();
		}
		catch (Exception e){
			this.applyStaticWait(20*this.getStaticWaitForApplication());
		}

		try{
			OrderConfirmationPage orderConfirmationPage=new OrderConfirmationPage(this.getDriver());
			this.waitForCondition(Driver->{return orderConfirmationPage.lblOrderSuccessTitle.isDisplayed();},15000);
		}
		catch (Exception e){
			this.applyStaticWait(8*this.getStaticWaitForApplication());
		}
	}

	/**
	 * To verify OrderSummary Contents For OrderModification
	 */
	public void verifyOrderSummaryContentsForOrderModification() {
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
			reporter.reportLogPass("The OrderSummary Shipping NowPrice is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Shipping NowPrice is not displaying correctly");
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryNewTotalPriceTitle);
		lsText = lblOrderSummaryNewTotalPriceTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary new Total Price Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary new Total Price Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryNewTotalPrice);
		lsText = lblOrderSummaryNewTotalPrice.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary new Total Price is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary new Total Price is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryOriginalOrderTotalTitle);
		lsText = lblOrderSummaryOriginalOrderTotalTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Original Order Total title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Original Order Total title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryOriginalOrderTotal);
		lsText = lblOrderSummaryOriginalOrderTotal.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Original Order Total is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Original Order Total is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryChangeToOrderTotalTitle);
		lsText = lblOrderSummaryChangeToOrderTotalTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Change To Order Total title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Change To Order Total title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryChangeToOrderTotal);
		lsText = lblOrderSummaryChangeToOrderTotal.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Change To Order Total is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Change To Order Total is not displaying correctly");
		}
	}

	/**
	 * To get OrderSummary Description for order modification
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getOrderSummaryDescForOrderModification(){
		String lsText;
		Map<String,Object> map=new HashMap<>();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummarySubTotal);
		lsText=this.lblOrderSummarySubTotal.getText();
		map.put("subTotal",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryShippingWasPrice);
		lsText=this.lblOrderSummaryShippingWasPrice.getText();
		if(lsText.isEmpty()){
			map.put("wasPrice",0.0f);
		}
		else{
			map.put("wasPrice",this.getFloatFromString(lsText,true));
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(cntOrderSummaryShippingPriceContainer);
		lsText=this.cntOrderSummaryShippingPriceContainer.getText();
		if(lsText.toLowerCase().contains("free")){
			map.put("nowPrice",0.0f);
		}
		else{
			map.put("nowPrice",this.getNowPriceFromOrderSummary());
		}

		map.put("province",getTaxProvinceCode());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryTax);
		lsText=this.lblOrderSummaryTax.getText();
		map.put("tax",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryNewTotalPrice);
		lsText=this.lblOrderSummaryNewTotalPrice.getText();
		map.put("newTotalPrice",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryOriginalOrderTotal);
		lsText=this.lblOrderSummaryOriginalOrderTotal.getText();
		map.put("originalOrderTotal",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryChangeToOrderTotal);
		lsText=this.lblOrderSummaryChangeToOrderTotal.getText();
		if(lsText.contains("-")){
			map.put("changeToOrderTotal",-1.0f*this.getFloatFromString(lsText));
		}
		else{
			map.put("changeToOrderTotal",this.getFloatFromString(lsText));
		}

		WebElement item,subItem;
		float floatValue=0.0f;
		if(this.checkAppliedDiscountExistingInOrderSummaryForOrderModification()){
			String lsAppliedDiscountType=this.judgeAppliedDiscountType();
			switch(lsAppliedDiscountType){
				case "Both":
					item=lstOrderSummaryAppliedDiscountList.get(0);
					subItem=item.findElement(By.xpath("./span[1]"));
					lsText=this.getElementInnerText(subItem).replace(":","");
					map.put("promoteCodeTitle",lsText);
					subItem=item.findElement(By.xpath("./span[2]"));
					lsText=this.getElementInnerText(subItem);
					if(lsText.contains("-")){
						if(lsText.equalsIgnoreCase("-")){
							map.put("promoteCodeValue",0.0f);
						}
						else{
							floatValue=-1*this.getFloatFromString(lsText,true);
							map.put("promoteCodeValue",floatValue);
						}
					}
					else{
						floatValue=this.getFloatFromString(lsText,true);
						map.put("promoteCodeValue",floatValue);
					}

					item=lstOrderSummaryAppliedDiscountList.get(1);
					subItem=item.findElement(By.xpath("./span[1]"));
					lsText=this.getElementInnerText(subItem).replace(":","");
					map.put("giftCardTitle",lsText);
					subItem=item.findElement(By.xpath("./span[2]"));
					lsText=this.getElementInnerText(subItem);
					if(lsText.contains("-")){
						map.put("giftCardValue",-1*this.getFloatFromString(lsText,true));
					}
					else{
						map.put("giftCardValue",this.getFloatFromString(lsText,true));
					}
					break;
				case "PromoteCode":
					item=lstOrderSummaryAppliedDiscountList.get(0);
					subItem=item.findElement(By.xpath("./span[1]"));
					lsText=this.getElementInnerText(subItem).replace(":","");
					map.put("promoteCodeTitle",lsText);
					subItem=item.findElement(By.xpath("./span[2]"));
					lsText=this.getElementInnerText(subItem);
					if(lsText.contains("-")){
						if(lsText.equalsIgnoreCase("-")){
							map.put("promoteCodeValue",0.0f);
						}
						else{
							floatValue=-1*this.getFloatFromString(lsText,true);
							map.put("promoteCodeValue",floatValue);
						}
					}
					else{
						floatValue=this.getFloatFromString(lsText,true);
						map.put("promoteCodeValue",floatValue);
					}

					map.put("giftCardTitle",null);
					map.put("giftCardValue",0.0f);
					break;
				case "GiftCard":
					item=lstOrderSummaryAppliedDiscountList.get(0);
					subItem=item.findElement(By.xpath("./span[1]"));
					lsText=this.getElementInnerText(subItem).replace(":","");
					map.put("giftCardTitle",lsText);
					subItem=item.findElement(By.xpath("./span[2]"));
					lsText=this.getElementInnerText(subItem);
					if(lsText.contains("-")){
						map.put("giftCardValue",-1*this.getFloatFromString(lsText,true));
					}
					else{
						map.put("giftCardValue",this.getFloatFromString(lsText,true));
					}

					map.put("promoteCodeTitle",null);
					map.put("promoteCodeValue",0.0f);
					break;
				default:
					break;
			}
		}
		else{
			map.put("promoteCodeTitle",null);
			map.put("promoteCodeValue",0.0f);

			map.put("giftCardTitle",null);
			map.put("giftCardValue",0.0f);
		}

		return map;
	}

	/**
	 * To verify OrderSummary business Logic for order modification
	 * @param - subTotalShoppingCart - float - subTotal in checkout cart
	 * @param - orderSummaryMap - Map<String,Object>
	 * @param - Map<String,Object> - provincialTaxRate - note that if pass null, will not calculate tax for comparison
	 */
	public void verifyOrderSummaryBusinessLogicForOrderModification(float subTotalShoppingCart,Map<String,Object> orderSummaryMap,Map<String,Object> provincialTaxRate){
		float nowPriceOrderSummary=(float) orderSummaryMap.get("nowPrice");

		float subTotal=(float) orderSummaryMap.get("subTotal");
		if(Math.abs(subTotal-subTotalShoppingCart)<0.01){
			reporter.reportLogPass("The subtotal price in OrderSummary section is equal to the subtotal price for order list");
		}
		else{
			reporter.reportLogFail("The subtotal price:"+subTotal+" in OrderSummary section is not equal to the subtotal price:"+subTotalShoppingCart+" for order list");
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

		float promoteCodePrice=(float) orderSummaryMap.get("promoteCodeValue");
		float giftCardPrice=(float) orderSummaryMap.get("giftCardValue");

		float calTotalPrice=subTotal+tax+nowPriceOrderSummary+promoteCodePrice+giftCardPrice;
		float newTotalPrice=(float) orderSummaryMap.get("newTotalPrice");
		if(Math.abs(calTotalPrice-newTotalPrice)<0.01){
			reporter.reportLogPass("The calculated total price in OrderSummary section is equal to the new total price in OrderSummary section");
		}
		else{
			reporter.reportLogFail("The calculated total price:"+calTotalPrice+" in OrderSummary section is not equal to the new total price:"+newTotalPrice+" in OrderSummary section");
		}

		float originalOrderTotalPrice=(float) orderSummaryMap.get("originalOrderTotal");
		float changeToOrderTotalPrice=(float) orderSummaryMap.get("changeToOrderTotal");
		if(Math.abs(Math.abs(originalOrderTotalPrice+changeToOrderTotalPrice)-newTotalPrice)<0.1f){
			reporter.reportLogPass("The originalOrder total price plus change To Order Total Price in OrderSummary section is equal to the new total price in OrderSummary section");
		}
		else{
			reporter.reportLogFail("The originalOrder total price plus change To Order Total Price in OrderSummary section is not equal to the new total price in OrderSummary section");
		}
	}

	/**
	 * To get applied promote code
	 * @return -String
	 */
	public String getAppliedPromoteCode(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryInputPromoteCode);
		return lblOrderSummaryInputPromoteCode.getText().trim();
	}

	/**
	 * To verify Mandatory Contents For Checkout Product List For Order Modification
	 * @param - boolean - bItemsBeingAdded
	 */
	public void verifyMandatoryContentsForCheckoutProductListForOrderModification(boolean bItemsBeingAdded) {
		String lsText;
		WebElement item;
		List<WebElement> lstCheckoutOrderList;
		if(bItemsBeingAdded){
			lstCheckoutOrderList=this.lstProductListForItemBeingAdded;
		}
		else{
			lstCheckoutOrderList=this.lstProductListForExistingItems;
		}

		for (WebElement productItem : lstCheckoutOrderList) {
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

			if(this.checkProductNumberExisting(productItem)){
				item = productItem.findElement(byProductNumber);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText = item.getText().replace("-", "").trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The product number is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product number is not displaying correctly");
				}
			}

			item = productItem.findElement(byProductNowPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product nowPrice is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product nowPrice is not displaying correctly");
			}

			item=productItem.findElement(byProductSelectQuantity);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=this.getElementInnerText(item).split(":")[1].trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product quantity is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product quantity is not displaying correctly");
			}
		}
	}

	/**
	 * To verify Optional Contents For Checkout Product List For Order Modification
	 * @param - boolean - bItemsBeingAdded
	 */
	public void verifyOptionalContentsForCheckoutProductListForOrderModification(boolean bItemsBeingAdded) {
		String lsText;
		WebElement item;

		List<WebElement> lstCheckoutOrderList;
		if(bItemsBeingAdded){
			expandItemBeingAddedProductSectionForOrderModification();
			lstCheckoutOrderList=this.lstProductListForItemBeingAdded;
		}
		else{
			expandExistingItemsProductSectionForOrderModification();
			lstCheckoutOrderList=this.lstProductListForExistingItems;
		}

		for (WebElement productItem : lstCheckoutOrderList) {
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

		if(this.checkProductShippingDateExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblShippingDateTitle);
			lsText = this.lblShippingDateTitle.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The GetItBy date title is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The GetItBy date title is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblShippingDate);
			lsText = this.lblShippingDate.getText().trim();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The GetItBy date is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The GetItBy date is not displaying correctly");
			}
		}
	}

	/**
	 * To verify Address And Payment Contents for order modification
	 */
	public void verifyAddressAndPaymentContentsForOrderModification() {
		String lsText;

		reporter.reportLog("Verify shipping address contents");
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

		if(!this.checkChildElementExistingByTagName(cntShippingAddressSection,"button")){
			reporter.reportLogPass("The Shipping Address AddOrChange button is not found");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Shipping Address AddOrChange button is found");
		}

		reporter.reportLog("Verify shipping method contents");
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

		if(!this.checkChildElementExistingByTagName(cntShippingMethodSection,"button")){
			reporter.reportLogPass("The change Shipping Method button is not found");
		}
		else{
			reporter.reportLogFailWithScreenshot("The change Shipping Method button is found");
		}

		reporter.reportLog("Verify shipping payment method contents");
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

		if(!this.checkChildElementExistingByTagName(cntShippingPaymentMethodSection,"button")){
			reporter.reportLogPass("The AddOrChange Payment Method button is not found");
		}
		else{
			reporter.reportLogFailWithScreenshot("The AddOrChange Payment Method button is found");
		}

		reporter.reportLog("Verify billing address contents");
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

		if(!this.checkChildElementExistingByTagName(cntBillingAddressSection,"button")){
			reporter.reportLogPass("The Billing Address Change button is not found");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Billing Address Change button is found");
		}

		reporter.reportLog("Verify payment option contents");
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

		if(!this.checkChildElementExistingByAttribute(lblPaymentOptionTextForOrderModification,"class","form__select")){
			reporter.reportLogPass("The select Payment Option is not found");
		}
		else{
			reporter.reportLogFailWithScreenshot("The select Payment Option is found");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentOptionTextForOrderModification);
		lsText=lblPaymentOptionTextForOrderModification.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Payment Option is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Payment Option is not displaying correctly");
		}
	}

	/**
	 * To verify Promote Code Contents for order modification
	 * @param - String - lsExpectedPromoteCode
	 */
	public void verifyPromoteCodeContentsForOrderModification(String lsExpectedPromoteCode) {
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryInputPromoteCode);
		lsText=this.getAppliedPromoteCode();
		if(lsText.equalsIgnoreCase(lsExpectedPromoteCode)){
			reporter.reportLogPass("The applied promote code:"+lsText+" is the same as expected:"+lsExpectedPromoteCode);
		}
		else{
			reporter.reportLogFail("The applied promote code:"+lsText+" is not the same as expected:"+lsExpectedPromoteCode);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnOrderSummaryRemovePromoteCode);
		lsText=this.btnOrderSummaryRemovePromoteCode.getText().trim();
		if(lsText.equalsIgnoreCase("Edit")){
			reporter.reportLogPass("The edit promote code button is displaying correctly");
		}
		else{
			reporter.reportLogFail("The edit promote code button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryPromoteCodeAppliedMessage);
		lsText = lblOrderSummaryPromoteCodeAppliedMessage.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Promote Code Applied Message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Promote Code Applied Message is not displaying correctly");
		}
	}

	/**
	 * To get checkout Item Description in product list For Order Modification
	 * @param - productItem - item in product list
	 * @param - lsOption - "mandatory"/"optional"/"all"
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getCheckoutItemDescForOrderModification(WebElement productItem, String lsOption,boolean bItemsBeingAdded){
		Map<String,Object> map=null;
		switch(lsOption){
			case "mandatory":
				map=this.getMandatoryCheckoutItemDescForOrderModification(productItem,bItemsBeingAdded);
				break;
			case "optional":
				map=this.getOptionalCheckoutItemDescForOrderModification(productItem);
				break;
			case "all":
				map=this.getAllCheckoutItemDescForOrderModification(productItem,bItemsBeingAdded);
				break;
			default:
				break;
		}

		return map;
	}

	/**
	 * To get all Checkout Item Description in product list For Order Modification
	 * @param - productItem - item in product list
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getAllCheckoutItemDescForOrderModification(WebElement productItem,boolean bItemsBeingAdded){
		Map<String,Object> mapAll=new HashMap<>();

		Map<String,Object> mapMandatory=this.getMandatoryCheckoutItemDescForOrderModification(productItem,bItemsBeingAdded);
		for(Map.Entry<String,Object> entry:mapMandatory.entrySet()){
			mapAll.put(entry.getKey(),entry.getValue());
		}

		Map<String,Object> mapOptional=this.getOptionalCheckoutItemDescForOrderModification(productItem);
		for(Map.Entry<String,Object> entry:mapOptional.entrySet()){
			mapAll.put(entry.getKey(),entry.getValue());
		}

		return mapAll;
	}

	/**
	 * To get Mandatory checkout Item Description in product list For Order Modification
	 * @param - productItem - item in product list
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getMandatoryCheckoutItemDescForOrderModification(WebElement productItem,boolean bItemsBeingAdded){
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
		if(bItemsBeingAdded){
			if(lsText.contains("|")){
				String[] lsSplit=lsText.split("\\|");
				if(lsSplit.length==2){
					if(lsSplit[1].contains("Size")){
						map.put("productName",lsSplit[0].trim());
						map.put("productStyle",null);
						map.put("productSize",lsSplit[1].split(":")[1].trim());
					}
					else{
						map.put("productName",lsSplit[0].trim());
						map.put("productStyle",lsSplit[1].split(":")[1].trim());
						map.put("productSize",null);
					}
				}
				else{
					map.put("productName",lsSplit[0].trim());
					map.put("productStyle",lsSplit[2].split(":")[1].trim());
					map.put("productSize",lsSplit[1].split(":")[1].trim());
				}
			}
			else{
				map.put("productName",lsText.trim());
				map.put("productStyle",null);
				map.put("productSize",null);
			}
		}
		else{
			if(lsText.contains("|")){
				String[] lsSplit=lsText.split("\\|");
				if(lsSplit.length==2){
					if(lsSplit[1].contains("Size")){
						map.put("productName",lsSplit[0].trim());
						map.put("productStyle",null);
						map.put("productSize",lsSplit[1].split(":")[1].trim());
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
				map.put("productName",lsText.trim());
				map.put("productStyle",null);
				map.put("productSize",null);
			}
		}


		if(this.checkProductNumberExisting(productItem)){
			item=productItem.findElement(byProductNumber);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().replace("-","").trim();
			map.put("productNumber",lsText);
		}
		else{
			map.put("productNumber",null);
		}

		item=productItem.findElement(byProductNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().trim();
		if(lsText.toLowerCase().contains("free")){
			map.put("productNowPrice",0.0f);
		}
		else{
			map.put("productNowPrice",this.getFloatFromString(lsText));
		}

		item=productItem.findElement(byProductSelectQuantity);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=this.getElementInnerText(item).split(":")[1].trim();
		map.put("productQuantity",Integer.parseInt(lsText));

		return map;
	}

	/**
	 * To get Optional checkout Item Description in product list For Order Modification
	 * @param - productItem - item in product list
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getOptionalCheckoutItemDescForOrderModification(WebElement productItem){
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
			map.put("productLeftNumber",-1);
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

		return map;
	}

	/**
	 * To get checkout Item List Description
	 * @param - lsOption - "mandatory"/"optional"/"all"
	 * @return - List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getCheckoutItemListDescForOrderModification(String lsOption,boolean bItemsBeingAdded){
		List<Map<String,Object>> mapList=new ArrayList<>();

		List<WebElement> lstCheckoutOrderList;
		if(bItemsBeingAdded){
			lstCheckoutOrderList=this.lstProductListForItemBeingAdded;
		}
		else{
			lstCheckoutOrderList=this.lstProductListForExistingItems;
		}

		for(WebElement cartItem:lstCheckoutOrderList){
			mapList.add(this.getCheckoutItemDescForOrderModification(cartItem,lsOption,bItemsBeingAdded));
		}

		return mapList;
	}

	/**
	 * To verify Product List Expanded Section Initial Status,Then Expanded it.
	 */
	public void verifyProductListExpandedSectionInitialStatusThenExpanded(){
		if(checkItemBeingAddedProductSectionExpandedForOrderModification()){
			reporter.reportLogPass("The Item Being Added Product Section is Expanded");
		}
		else{
			reporter.reportLogFail("The Item Being Added Product Section is not Expanded");
		}

		if(!checkExistingItemsProductSectionExpandedForOrderModification()){
			reporter.reportLogPass("The existing Item Product Section is not Expanded");
		}
		else{
			reporter.reportLogFail("The existing Item Product Section is Expanded");
		}

		reporter.reportLog("btnExistingItems class:"+btnExistingItems.getAttribute("class"));

		this.clickElement(btnExistingItems);
		this.applyStaticWait(2*this.getStaticWaitForApplication());
	}

	/**
	 * To verify expand Both New And Existing Order List Section
	 */
	public void expandBothNewAndExistingOrderListSection(){
		if(!checkItemBeingAddedProductSectionExpandedForOrderModification()){
			this.clickElement(btnItemBeingAdded);
			this.applyStaticWait(2*this.getStaticWaitForApplication());
		}

		if(!checkExistingItemsProductSectionExpandedForOrderModification()){
			this.clickElement(btnExistingItems);
			this.applyStaticWait(2*this.getStaticWaitForApplication());
		}
	}

	/**
	 * To verify Order List Linkage Between Order Modification Page And Checkout Page
	 * @param - List<Map<String,Object>> - orderListMapForOrderModification
	 * @param - List<Map<String,Object>> - orderListMapForCheckout
	 */
	public void verifyOrderListLinkageBetweenOrderModificationPageAndCheckoutPage(List<Map<String,Object>> orderListMapForOrderModification,List<Map<String,Object>> orderListMapForCheckout){
		int findIndex;
		ShoppingCartPage shoppingCartPage=new ShoppingCartPage(this.getDriver());
		Map<String,Object> checkoutItem;
		for(Map<String,Object> orderItem:orderListMapForOrderModification){
			String lsText=(String)orderItem.get("productName");
			reporter.reportLog("Verify product:'"+lsText+"'");
			findIndex=shoppingCartPage.findGivenProductIndexInProductList(orderItem,orderListMapForCheckout);
			if(findIndex!=-1){
				checkoutItem=orderListMapForCheckout.get(findIndex);
				this.verifyOrderItemLinkageBetweenOrderModificationPageAndCheckoutPage(orderItem,checkoutItem);
			}
			else{
				reporter.reportLogFail("Unable to find '"+lsText+"' in Checkout Page");
			}
		}
	}

	/**
	 * To verify Order Item Linkage Between Order Modification Page And Checkout Page
	 * @param - Map<String,Object> - orderItem
	 * @param - Map<String,Object> - checkoutItem
	 */
	public void verifyOrderItemLinkageBetweenOrderModificationPageAndCheckoutPage(Map<String,Object> orderItem,Map<String,Object> checkoutItem){
		String lsOrderText,lsCheckoutText;

		lsOrderText=(String)orderItem.get("productName");
		lsCheckoutText=(String)checkoutItem.get("productName");
		if(lsOrderText.equalsIgnoreCase(lsCheckoutText)){
			reporter.reportLogPass("The productName in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The productName:"+lsOrderText+" in Order Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
		}

		lsOrderText=(String)orderItem.get("productStyle");
		lsCheckoutText=(String)checkoutItem.get("productStyle");
		if(lsOrderText==null){
			if(lsCheckoutText==null){
				reporter.reportLogPass("The productStyle in Order Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productStyle in Order Item is not the same as the one in checkout Item");
			}
		}
		else{
			if(lsOrderText.equalsIgnoreCase(lsCheckoutText)){
				reporter.reportLogPass("The productStyle in Order Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productStyle:"+lsOrderText+" in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}
		}

		lsOrderText=(String)orderItem.get("productSize");
		lsCheckoutText=(String)checkoutItem.get("productSize");
		if(lsOrderText==null){
			if(lsCheckoutText==null){
				reporter.reportLogPass("The productSize in Order Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productSize in Order Item is not the same as the one in checkout Item");
			}
		}
		else{
			if(lsOrderText.equalsIgnoreCase(lsCheckoutText)){
				reporter.reportLogPass("The productSize in Order Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productSize:"+lsOrderText+" in Order Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}
		}

		lsOrderText=(String)orderItem.get("productNumber");
		lsCheckoutText=(String)checkoutItem.get("productNumber");
		if(lsOrderText==null){
			if(lsCheckoutText==null){
				reporter.reportLogPass("The productNumber in Order Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productNumber in Order Item is not the same as the one in checkout Item");
			}
		}
		else{
			if(lsOrderText.equalsIgnoreCase(lsCheckoutText)){
				reporter.reportLogPass("The productNumber in Order item is the same as the one in checkoutItem");
			}
			else{
				reporter.reportLogFail("The productNumber:"+lsOrderText+" in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}
		}

		float orderNowPrice=(float)orderItem.get("productNowPrice");
		float checkoutNowPrice=(float)checkoutItem.get("productNowPrice");
		if(Math.abs(orderNowPrice-checkoutNowPrice)<0.1f){
			reporter.reportLogPass("The productNowPrice in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The productNowPrice:"+orderNowPrice+" in Order Item is not the same as the one:"+checkoutNowPrice+" in checkout Item");
		}

		int orderQuantity=(int)orderItem.get("productQuantity");
		int checkoutQuantity=(int)checkoutItem.get("productQuantity");
		if(orderQuantity==checkoutQuantity){
			reporter.reportLogPass("The productQuantity in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The productQuantity:"+orderQuantity+" in Order Item is not the same as the one:"+checkoutQuantity+" in checkout Item");
		}
	}

	/**
	 * To verify Order summary Linkage Between Order Modification Page And Checkout Page
	 * @param - Map<String,Object> - orderItem
	 * @param - Map<String,Object> - checkoutItem
	 */
	public void verifyOrderSummaryLinkageBetweenOrderModificationPageAndCheckoutPage(Map<String,Object> orderItem,Map<String,Object> checkoutItem){
		float orderValue,checkoutValue;
		String lsOrderText,lsCheckoutText;

		orderValue= (float) orderItem.get("subTotal");
		checkoutValue= (float) checkoutItem.get("subTotal");
		if(Math.abs(orderValue-checkoutValue)<0.1f){
			reporter.reportLogPass("The subtotal in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The subtotal:"+orderValue+" in Order Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		orderValue= (float) orderItem.get("nowPrice");
		checkoutValue= (float) checkoutItem.get("nowPrice");
		if(Math.abs(orderValue-checkoutValue)<0.1f){
			reporter.reportLogPass("The nowPrice in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The nowPrice:"+orderValue+" in Order Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		lsOrderText= (String) orderItem.get("province");
		lsCheckoutText= (String) checkoutItem.get("province");
		if(lsOrderText.equalsIgnoreCase(lsCheckoutText)){
			reporter.reportLogPass("The province code in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The provice code:"+lsOrderText+" in Order Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
		}

		orderValue= (float) orderItem.get("tax");
		checkoutValue= (float) checkoutItem.get("tax");
		if(Math.abs(orderValue-checkoutValue)<0.1f){
			reporter.reportLogPass("The tax in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The tax:"+orderValue+" in Order Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		orderValue= (float) orderItem.get("newTotalPrice");
		checkoutValue= (float) checkoutItem.get("newTotalPrice");
		if(Math.abs(orderValue-checkoutValue)<0.1f){
			reporter.reportLogPass("The newTotalPrice in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The newTotalPrice:"+orderValue+" in Order Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		orderValue= (float) orderItem.get("changeToOrderTotal");
		checkoutValue= (float) checkoutItem.get("changeToOrderTotal");
		if(Math.abs(orderValue-checkoutValue)<0.1f){
			reporter.reportLogPass("The changeToOrderTotal in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The changeToOrderTotal:"+orderValue+" in Order Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		orderValue= (float) orderItem.get("promoteCodeValue");
		checkoutValue= (float) checkoutItem.get("promoteCodeValue");
		if(Math.abs(orderValue-checkoutValue)<0.1f){
			reporter.reportLogPass("The promoteCodeValue in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The promoteCodeValue:"+orderValue+" in Order Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}
	}

	/**
	 * To verify easyPayment Linkage Between Order Modification Page And Checkout Page
	 * @param - Map<String,Object> - orderItem
	 * @param - Map<String,Object> - checkoutItem
	 */
	public void verifyEasyPaymentLinkageBetweenOrderModificationPageAndCheckoutPage(Map<String,Object> orderItem,Map<String,Object> checkoutItem){
		float orderValue,checkoutValue;
		int lsOrderText,lsCheckoutText;

		lsOrderText= (int) orderItem.get("installmentsNumber");
		lsCheckoutText= (int) checkoutItem.get("installmentsNumber");
		if(lsOrderText==lsCheckoutText){
			reporter.reportLogPass("The installmentsNumber in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The installmentsNumber:"+lsOrderText+" in Order Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
		}

		orderValue= (float) orderItem.get("todayPayment");
		checkoutValue= (float) checkoutItem.get("todayPayment");
		if(Math.abs(orderValue-checkoutValue)<0.1f){
			reporter.reportLogPass("The todayPayment in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The todayPayment:"+orderValue+" in Order Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		orderValue= (float) orderItem.get("leftPayment");
		checkoutValue= (float) checkoutItem.get("leftPayment");
		if(Math.abs(orderValue-checkoutValue)<0.1f){
			reporter.reportLogPass("The leftPayment in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The leftPayment:"+orderValue+" in Order Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		orderValue= (float) orderItem.get("futureMonthlyPayment");
		checkoutValue= (float) checkoutItem.get("futureMonthlyPayment");
		if(Math.abs(orderValue-checkoutValue)<0.1f){
			reporter.reportLogPass("The futureMonthlyPayment in Order Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The futureMonthlyPayment:"+orderValue+" in Order Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}
	}

	/**
	 * To get All Order List Map With NewlyAdded And Existing Items
	 * @param - List<Map<String,Object>> - productListMapForItemsBeingAdded
	 * @param - List<Map<String,Object>> - productListMapForExistingItems
	 * @return - List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getAllOrderListMapWithNewlyAddedAndExistingItems(List<Map<String,Object>> productListMapForItemsBeingAdded,List<Map<String,Object>> productListMapForExistingItems){
		List<Map<String,Object>> allProductListMap=new ArrayList<>();
		for(Map<String,Object> productListMap:productListMapForItemsBeingAdded){
			allProductListMap.add(productListMap);
		}

		for(Map<String,Object> productListMap:productListMapForExistingItems){
			allProductListMap.add(productListMap);
		}

		return allProductListMap;
	}

	/**
	 * To get Shipping And Payment Description for order modification
	 * @param - Map<String,Object> - checkoutItem
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getShippingAndPaymentDescForOrderModification() {
		String lsText;
		Map<String, Object> map = new HashMap<>();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingAddress);
		lsText=lblShippingAddress.getText().trim();
		map.put("shippingAddress",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblShippingMethod);
		lsText=lblShippingMethod.getText().trim();
		map.put("shippingMethod", lsText.split("-")[0].trim());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentMethod);
		lsText=lblPaymentMethod.getText().trim();
		map.put("paymentMethodDescription",lsText);
		map.put("paymentMethod",getSelectedPaymentMethodFromCheckout(lblSelectedCardTypeForPayment));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblBillingAddress);
		lsText=lblBillingAddress.getText().trim();
		map.put("billingAddress",lsText);

		return map;
	}

	/**
	 * This function checks if easy payment is there and if not, sets it to given installment number
	 * @param installmentNumber
	 */
	public void setEasyPayForProduct(int installmentNumber){
		if(!this.checkEasyPaySectionExisting()){
			this.setPaymentOptionByGivenInstallmentNumber(installmentNumber);
		}
	}

	/**
	 * To calculate Line Item Price By Given Promote Code Discount
	 * @param - List<Map<String,Object>> - checkoutListMap
	 * @param - Map<String,Object> - orderSummaryMap
	 * @return - List<Map<String,Object>>
	 */
	public List<Map<String,Object>> calculateLineItemPriceByGivenPromoteCodeDiscount(List<Map<String,Object>> checkoutListMap,Map<String,Object> orderSummaryMap){
		List<Map<String,Object>> mapList=new ArrayList<>();
		float promoteCodeValue= Math.abs((float) orderSummaryMap.get("promoteCodeValue"));
		Map<String,Object> checkoutItemCountAndSubTotal=this.getCheckoutItemCountAndSubTotal(checkoutListMap);
		float subTotal= (float) checkoutItemCountAndSubTotal.get("subTotal");

		for(Map<String,Object> itemMap:checkoutListMap){
			Map<String,Object> mapItem=new HashMap<>();
			String productName= (String) itemMap.get("productName");
			String productStyle= (String) itemMap.get("productStyle");
			String productSize= (String) itemMap.get("productSize");
			float productNowPrice= (float) itemMap.get("productNowPrice");
			int productQuantity= (int) itemMap.get("productQuantity");
			float subTotalForItem=productNowPrice*productQuantity;
			float productPriceForPromoteCodeDiscount=productNowPrice-subTotalForItem/subTotal*promoteCodeValue/productQuantity;

			mapItem.put("productName",productName);
			mapItem.put("productStyle",productStyle);
			mapItem.put("productSize",productSize);
			mapItem.put("productPriceForPromoteCodeDiscount",productPriceForPromoteCodeDiscount);
			mapList.add(mapItem);
		}

		return mapList;
	}

	/**
	 * To check CVV Section Existing
	 * @return - boolean
	 */
	public boolean checkCVVSectionExisting(){
		return this.checkChildElementExistingByAttribute(cntUsingANewCardDialogCreditExpirationContainer,"class","creditcard__cvv-wrap");
	}

	/**
	 * To check CVV Tooltip Displaying
	 * @return - boolean
	 */
	public boolean checkCVVTooltipDisplaying(){
		return this.checkChildElementExistingByAttribute(lblUsingANewCardDialogCreditCVVTitle,"class","cvv__tooltip--msg");
	}

	/**
	 * To check Error Message Existing For Adding New CreditCard
	 * @return - boolean
	 */
	public boolean checkErrorMessageExistingForAddingNewCreditCard(){
		return this.checkChildElementExistingByAttribute(cntUsingANewCardDialogCreditCard,"class","creditcard__error-wrap");
	}

}