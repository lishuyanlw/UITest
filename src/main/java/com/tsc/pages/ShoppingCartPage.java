package com.tsc.pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsc.api.pojo.AccountCartResponse;
import com.tsc.api.pojo.Product;
import com.tsc.api.pojo.ProductDetailsItem;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.*;
import com.tsc.api.util.DataConverter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.apiBuilder.ProductAPI;
import com.tsc.api.util.JsonParser;
import com.tsc.pages.base.BasePage;
import org.json.simple.JSONObject;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[contains(@class,'go-back')]//a")
	public WebElement lnkBackToShopping;

	////////////////For Shopping bag section////////////////////////////

	@FindBy(xpath = "//div[@class='cartridge']")
	public WebElement cntCart;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-contents')]")
	public WebElement cntCartContents;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-contents')]//div[@class='emptyContents']")
	public WebElement lblEmptyCartMessage;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-title')]/parent::div")
	public WebElement cntCartContainPreviouslyAddedItemsMessage;

	@FindBy(xpath = "//shopping-cart//span[normalize-space(text())='Shopping Bag contains previously added items.']")
	public WebElement lblCartContainPreviouslyAddedItemsMessage;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-title')]")
	public WebElement lblCartTitle;

	//Hide in mobile
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'contents-head') and contains(@class,'hidden-xs')]")
	public WebElement lblCartTopMessage;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-notices')]")
	public WebElement cntCartNotice;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-notices')]//div[@class='notice-title']")
	public WebElement lblCartNoticeTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-notices')]//div[@class='notice-group'][div[strong]]")
	public WebElement lblCartNoticeMultiPackMessage;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-notices')]//div[@class='notice-group']")
	public List<WebElement> lstCartNoticeMessage;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-notices')]//div[@class='notice-group'][div[span]]")
	public WebElement lblCartNoticeQuantityExceedingMessage;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='tf-cart-wrapper']")
	public WebElement lblCartNoticeTrueFitMessage;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='tf-cart-wrapper']//a[contains(@class,'tfc-popup-click-open')]")
	public WebElement lnkCartNoticeTrueFit;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'estimateDate__wrapper')]")
	public WebElement lblCartGetItByDate;

	//Hide in mobile
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart__table--heading')]//div[contains(normalize-space(.),'ITEM')]")
	public WebElement lblCartTableHeadingITEM;

	//Hide in mobile
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart__table--heading')]//div[contains(normalize-space(.),'PRICE')]")
	public WebElement lblCartTableHeadingPRICE;

	//Hide in mobile
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart__table--heading')]//div[contains(normalize-space(.),'QUANTITY')]")
	public WebElement lblCartTableHeadingQUANTITY;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-items')]")
	public List<WebElement> lstCartItems;

	public By byProductPicBadgeContainer=By.xpath(".//div[contains(@class,'product-pic')]");
	public By byProductPicBadge=By.xpath(".//div[contains(@class,'product-pic')]//div[@class='badgeWrap']//img");
	public By byProductPicLink=By.xpath(".//div[contains(@class,'product-pic')]//a");
	public By byProductPicImage=By.xpath(".//div[contains(@class,'product-pic')]//a//img");
	public By byBlueJaysCareFoundationImage=By.xpath(".//div[@class='cartridge']//div[contains(@class,'cart-items')]//div[contains(@class,'product-pic')]/div/img[contains(@class,'responsive')]");

	public By byProductDescContainer=By.xpath(".//div[contains(@class,'cart-desc') and not(contains(@class,'cart-desc-line'))]");
	public By byProductItemDesc=By.xpath(".//div[contains(@class,'cart-desc') and not(contains(@class,'cart-desc-line'))]//div[@class='item-desc']");
	public By byProductNumberContainer=By.xpath(".//div[contains(@class,'cart-desc') and not(contains(@class,'cart-desc-line'))]");
	public By byProductNumber=By.xpath(".//div[contains(@class,'item-num')]");
	public By byProductShippingDate=By.xpath(".//div[contains(@class,'cart-desc') and not(contains(@class,'cart-desc-line'))]//div[contains(@class,'estimateDate')]");
	public By byProductRedMessage=By.xpath(".//div[contains(@class,'item-status')][span[@class='boldRedColor']]");

	//Hide in mobile
	public By byProductBlackMessageContainer=By.xpath(".//div[contains(@class,'cart-desc-line') and not(contains(@class,'visible-xs-block'))][div[span[@class='now-price']]]/..");
	public By byProductBlackMessage=By.xpath(".//div[contains(@class,'item-status')][span[@class='boldBlackColor']]");

	public By byProductNowPrice=By.xpath(".//div[contains(@class,'cart-desc-line') and not(contains(@class,'visible-xs-block'))]//span[contains(@class,'now-price')]");
	public By byProductSelectQuantity=By.xpath(".//div[@class='tsc-forms']//select");
	public By byProductRemoveButton=By.xpath(".//a[contains(@class,'cta-remove')]");

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-subtotal')]")
	public WebElement lblCartTableSubTotal;

	//Remove popup window after clicking remove button
	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']")
	public WebElement removeDialogLoadingIndicator;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//button[@class='close']")
	public WebElement btnRemoveDialogClose;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//*[@class='modal-title']")
	public WebElement lblRemoveDialogTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//img[contains(@class,'img-responsive')]/parent::div")
	public WebElement cntRemoveDialogImageContainer;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//div[@class='badgeWrap']//img")
	public WebElement imgRemoveDialogProductBadge;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//img[contains(@class,'img-responsive')]")
	public WebElement imgRemoveDialogProductImage;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//div[@class='item-desc']")
	public WebElement lblRemoveDialogProductItemDesc;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//div[contains(@class,'item-num')]")
	public WebElement lblRemoveDialogProductItemNumber;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//*[contains(normalize-space(text()),'PRICE:')]")
	public WebElement lblRemoveDialogProductItemPriceTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//*[contains(normalize-space(text()),'PRICE:')]/following-sibling::span")
	public WebElement lblRemoveDialogProductItemPrice;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//*[contains(normalize-space(text()),'QUANTITY:')]")
	public WebElement lblRemoveDialogProductItemQuantityTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//*[contains(normalize-space(text()),'QUANTITY:')]/following-sibling::span")
	public WebElement lblRemoveDialogProductItemQuantity;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//button[contains(normalize-space(text()),'REMOVE')]")
	public WebElement btnRemoveDialogRemove;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='removeItemModal']//button[@aria-label='Cancel']")
	public WebElement btnRemoveDialogCancel;

	@FindBy(xpath="//shopping-cart//div[contains(@class,'cart-items')]//div/a[contains(@class,'pull-right')]")
	public List<WebElement> lstItemRemoveButtonFromCart;

	////////////////For Order summary section////////////////////////////

	//Pricing
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'details-box')]")
	public WebElement cntCartPricingMultiPack;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-details')]")
	public WebElement cntCartPricingDetails;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'details-box')]/*[contains(@class,'multipack')]")
	public WebElement lblCartPricingMultiPackMessage;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//div[contains(@class,'details-title')]")
	public WebElement lblCartPricingOrderSummaryTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//div[contains(normalize-space(text()),'Subtotal:')]")
	public WebElement lblCartPricingSubTotalTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//div[contains(normalize-space(text()),'Subtotal:')]/following-sibling::div[last()]")
	public WebElement lblCartPricingSubTotal;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//div[contains(normalize-space(text()),'Shipping:')]")
	public WebElement lblCartPricingShippingTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//div[contains(normalize-space(text()),'Shipping:')]/following-sibling::div[del]")
	public WebElement lblCartPricingShippingWasPrice;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//div[contains(normalize-space(text()),'Shipping:')]/following-sibling::div[last()]")
	public WebElement lblCartPricingShippingNowPrice;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//div[contains(normalize-space(text()),'Est. Taxes:')]")
	public WebElement lblCartPricingEstimateTaxTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//div[contains(normalize-space(text()),'Est. Taxes:')]//select")
	public WebElement selectCartPricingShippingEstimateTaxProvince;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//div[contains(normalize-space(text()),'Est. Taxes:')]/following-sibling::div[last()]")
	public WebElement lblCartPricingShippingEstimateTax;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//div[contains(normalize-space(text()),'TOTAL PRICE:')]")
	public WebElement lblCartPricingTotalPriceTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//div[contains(normalize-space(text()),'TOTAL PRICE:')]/following-sibling::div[last()]")
	public WebElement lblCartPricingTotalPrice;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]//span[contains(normalize-space(text()),'You’re saving')]")
	public WebElement lblCartPricingYouAreSaving;

	//EasyPay
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//div[contains(@class,'cart-installment-more')]")
	public WebElement cntEasyPayContainer;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//strong")
	public WebElement lblCartEasyPayTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//div[contains(normalize-space(text()),'Number of Installments:')]")
	public WebElement lblCartEasyPayInstallmentNumberTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//div[contains(normalize-space(text()),'Number of Installments:')]//following-sibling::div[contains(@class,'tsc-forms')]//select")
	public WebElement selectCartEasyPayInstallmentNumber;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//div[contains(normalize-space(text()),'Your Total Payment Today:')]")
	public WebElement lblCartEasyPayTodayPaymentTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//div[contains(normalize-space(text()),'Your Total Payment Today:')]/following-sibling::div[last()]")
	public WebElement lblCartEasyPayTodayPayment;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//div[contains(normalize-space(text()),'Payment Amount Left After Today:')]")
	public WebElement lblCartEasyPayLeftPaymentTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//div[contains(normalize-space(text()),'Payment Amount Left After Today:')]/following-sibling::div[last()]")
	public WebElement lblCartEasyPayLeftPayment;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//div[contains(normalize-space(text()),'Future Monthly Payments:')]")
	public WebElement lblCartEasyPayFutureMonthlyPaymentTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//div[contains(normalize-space(text()),'Future Monthly Payments:')]/following-sibling::div[last()]")
	public WebElement lblCartEasyPayFutureMonthlyPayment;

	//Checkout
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'checkout')]//div[@class='cart-info']")
	public WebElement lblCartCheckoutRedeemMessage;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'donationWrap')]//div[contains(@class,'donationLogo')]//img")
	public WebElement imgCartCheckoutDonationLogo;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'donationWrap')]//div[contains(@class,'donationDesc')]")
	public WebElement imgCartCheckoutDonationDesc;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'donationWrap')]//div[contains(@class,'donationButtonWrap')]//a")
	public List<WebElement> lstCartCheckoutDonationButton;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'donationWrap')]//div[contains(@class,'donationButtonWrap')]//a[contains(@class,'active')]/div")
	public WebElement lblBlueJaySelectedDonation;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'donationWrap')]//div[contains(@class,'donationButtonWrap')]")
	public WebElement lblBlueJayDonation;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'donationWrap')]//div[contains(@class,'donationRecieptMsg')]")
	public WebElement lblCartCheckoutDonationReceiptMessage;

	@FindBy(xpath = "//div[@class='cartridge']//button[contains(@class,'checkoutColorBtn')]")
	public WebElement btnCartCheckoutButton;

	@FindBy(xpath = "//div[@class='cartridge']//shopping-cart-privacy")
	public WebElement lblCartPrivacy;

	@FindBy(xpath = "//div[@class='cartridge']//shopping-cart-privacy//a[@id='btn-learn-more']")
	public WebElement lnkCartPrivacy;

	@FindBy(xpath = "//div[@class='Footer']//div[@class='blockPageWrap']")
	public WebElement pageLoadingIndicator;

	//PayPal
	@FindBy(how = How.XPATH, using = "//div[@id='buttons-container']//div[contains(@class,'paypal-button') and @role]")
	//@FindBy(xpath = "//div[@id='buttons-container']//div[contains(@class,'paypal-button') and @role]")
	public WebElement btnPayPalButton;

	@FindBy(xpath = "//iframe[contains(@name,'paypal')]")
	public WebElement framePayPalFrameElement;

	@FindBy(xpath = "//div[@id='splitEmail']//input[@id='email']")
	public WebElement inputPayPalEmailInput;

	@FindBy(xpath = "//div[@id='splitEmail']//button[@value='Next']")
	public WebElement btnPayPalNextButton;

	/**
	 * To get added item amount
	 */
	public int GetAddedItemAmount(){
		return this.getIntegerFromString(this.getElementInnerText(this.lblCartTitle));
	}

	/**
	 * To check Contain Previously Added Items Message Existing
	 * @return
	 */
	public boolean checkContainPreviouslyAddedItemsMessageExisting(){
		return this.checkChildElementExistingByAttribute(this.cntCartContainPreviouslyAddedItemsMessage,"class","cart-merge");
	}


	/**
	 * To check empty cart message Existing
	 * @return -boolean
	 */
	public boolean checkEmptyCartMessageExisting() {
		return this.checkChildElementExistingByAttribute(this.cntCartContents, "class", "emptyContents");
	}

	/**
	 * To check Cart Notice Title Existing
	 * @return -boolean
	 */
	public boolean checkCartNoticeTitleExisting(){
		return this.checkChildElementExistingByAttribute(this.cntCartNotice,"class","notice-title");
	}

	/**
	 * To check Cart Notice Message Existing
	 * @return -String
	 */
	public String checkCartNoticeMessageExisting(){
		this.applyStaticWait(3*this.getStaticWaitForApplication());
		if(this.checkChildElementExistingByAttribute(this.cntCartNotice,"class","notice-group")){
			if(this.lstCartNoticeMessage.size()==2){
				return "both";
			}
			else{
				if(this.checkChildElementExistingByAttribute(this.lstCartNoticeMessage.get(0),"class","clearfix")){
					return "errorMessage";
				}
				else{
					return "multiPackMessage";
				}
			}
		}
		return null;
	}

	/**
	 * To check Product TrueFit Message Existing, note that 2 different size for same product will show TrueFit message
	 * @return - boolean
	 */
	public boolean checkProductTrueFitMessageExisting(){
		this.applyStaticWait(5*this.getStaticWaitForApplication());
		return !this.getElementInnerText(this.lblCartNoticeTrueFitMessage).isEmpty();
	}

	/**
	 * To check GetItBy Shipping Message Existing, note that false means advanced order
	 * @return - boolean
	 */
	public boolean checkGetItByShippingMessageExisting(){
		return this.checkChildElementExistingByAttribute(cntCartContents,"class","estimateDate__wrapper");
	}

	/**
	 * To check Product Badge Existing for cart item in shopping item list
	 * @param - cartItem - item in lstCartItems
	 * @return - boolean
	 */
	public boolean checkProductBadgeExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductPicBadgeContainer);
		return this.checkChildElementExistingByAttribute(item,"class","badgeWrap");
	}

	/**
	 * To check Product number Existing for cart item in shopping item list
	 * @param - cartItem - item in lstCartItems
	 * @return - boolean
	 */
	public boolean checkProductNumberExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductNumberContainer);
		return this.checkChildElementExistingByAttribute(item,"class","item-num");
	}

	/**
	 * To check Select Quantity Enabled for cart item
	 * @param - cartItem - item in lstCartItems
	 * @return - boolean
	 */
	public boolean checkSelectQuantityEnabled(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductSelectQuantity);
		return !this.hasElementAttribute(item,"disabled");
	}

	/**
	 * To check Shipping date message existing for cart item in the shopping item list
	 * @param - cartItem - item in lstCartItems
	 * @return - boolean
	 */
	public boolean checkShippingDateExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductDescContainer);
		return this.checkChildElementExistingByAttribute(item,"class","estimateDate");
	}

	/**
	 * To check Red message existing for cart item in the shopping item list
	 * @param - cartItem - item in lstCartItems
	 * @return - boolean
	 */
	public boolean checkRedMessageExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductDescContainer);
		if(this.checkChildElementExistingByAttribute(item,"class","item-status")){
			item=item.findElement(By.xpath("./div[contains(@class,'item-status')]"));
			if(!this.getElementInnerText(item).isEmpty()){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	/**
	 * To check Free Shipping message existing for cart item in the shopping item list
	 * @param - cartItem - item in lstCartItems
	 * @return - boolean
	 */
	public boolean checkFreeShippingMessageExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(this.byProductBlackMessageContainer);
		return this.checkChildElementExistingByAttribute(item,"class","item-status");
	}

	/**
	 * To check Remove button existing for cart item in the shopping item list, for example, for free shipping scenario
	 * @param - cartItem - item in lstCartItems
	 * @return - boolean
	 */
	public boolean checkRemoveButtonExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductSelectQuantity);
		return !this.hasElementAttribute(item,"disabled");
	}

	/**
	 * To check Badge existing in remove dialog
	 * @return - boolean
	 */
	public boolean checkRemoveDialogBadgeExisting(){
		return this.checkChildElementExistingByAttribute(cntRemoveDialogImageContainer,"class","badgeWrap");
	}

	/**
	 * To check OrderSummary And EasyPayment Sections Existing
	 * @return - boolean
	 */
	public boolean checkOrderSummaryAndEasyPaymentSectionsExisting(){
		return this.checkChildElementExistingByAttribute(this.cntCartPricingDetails,"class","details-box");
	}

	/**
	 * To check MultiPack Message In OrderSummary Section Existing
	 * @return - boolean
	 */
	public boolean checkMultiPackMessageInOrderSummarySectionExisting(){
		return this.checkChildElementExistingByAttribute(this.cntCartPricingMultiPack,"class","multipack");
	}

	/**
	 * To check ShippingWasPrice in orderSummary section Existing
	 * @return - boolean
	 */
	public boolean checkShippingWasPriceExisting(){
		return !this.getElementInnerText(lblCartPricingShippingWasPrice).isEmpty();
	}

	/**
	 * To check Shipping saving in orderSummary section Existing
	 * @return - boolean
	 */
	public boolean checkShippingSavingExistingFromOrderSummary(){
		return checkShippingWasPriceExisting();
	}

	/**
	 * To get saving price from Shopping Cart Header
	 * @return - float
	 */
	public float getSavingPriceFromShoppingCartHeader(){
		if(this.checkCartNoticeMessageExisting()==null){
			return 0.0f;
		}

		if(!this.checkCartNoticeMessageExisting().equalsIgnoreCase("errorMessage")){
			return this.getFloatFromString(this.getElementInnerText(lblCartNoticeMultiPackMessage),true);
		}
		else{
			return 0.0f;
		}
	}

	/**
	 * To get Shopping amount
	 * @return - int - shopping amount
	 */
	public int getShoppingAmount(){
		String lsText=this.getElementInnerText(lblCartTableSubTotal);
		lsText=lsText.split(":")[0];

		return this.getIntegerFromString(lsText);
	}

	/**
	 * To get subtotal from OrderSummary section
	 * @return - float - Subtotal
	 */
	public float getOrderSummarySubTotal(){
		String lsText=this.getElementInnerText(lblCartPricingSubTotal);
		return this.getFloatFromString(lsText,true);
	}

	/**
	 * To get Shopping subtotal
	 * @return - float - shopping subtotal
	 */
	public float getShoppingSubTotal(){
		String lsText=this.getElementInnerText(lblCartTableSubTotal);
		lsText=lsText.split(":")[1];

		return this.getFloatFromString(lsText,true);
	}

	/**
	 * To get Item count from Shopping cart List
	 * @return - int
	 */
	public int getItemCountFromShoppingList(List<Map<String,Object>> mapShoppingCartList){
		int sum=0;
		for(Map<String,Object> cartItem:mapShoppingCartList){
			sum+=(int)cartItem.get("productQuantity");
		}
		return sum;
	}

	/**
	 * To get First Cart Item With Available Remove Button
	 * @return - Map<String,WebElement> - including cartItem and removeButton
	 */
	public Map<String,WebElement> getFirstCartItemWithAvailableRemoveButton(){
		Map<String,WebElement> map=new HashMap<>();

		for(WebElement cartItem:this.lstCartItems){
			if(this.checkRemoveButtonExisting(cartItem)){
				map.put("cartItem",cartItem);
				WebElement removeButton=cartItem.findElement(this.byProductRemoveButton);
				map.put("removeButton",removeButton);
				return map;
			}
		}
		return null;
	}

	/**
	 * To open remove dialog
	 * @param - removeButtonInOrderList - the given remove button in order list
	 * @return - boolean
	 */
	public boolean openRemoveDialog(WebElement removeButtonInOrderList){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(removeButtonInOrderList);
		removeButtonInOrderList.click();
		return this.waitForCondition(Driver->{return removeDialogLoadingIndicator.getAttribute("style").contains("display: block;");},15000);
	}

	/**
	 * To close remove dialog Without Remove Action
	 * @param - boolean - bCancel - true for clicking Cancel button while false for clicking close button
	 * @return - boolean
	 */
	public boolean closeRemoveDialogWithoutRemoveAction(boolean bCancel){
		if(bCancel){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveDialogCancel);
			btnRemoveDialogCancel.click();
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveDialogClose);
			btnRemoveDialogClose.click();
		}
		return this.waitForCondition(Driver->{return removeDialogLoadingIndicator.getAttribute("style").contains("display: none;");},15000);
	}

	/**
	 * To close remove dialog with remove action
	 * @return - boolean
	 */
	public boolean closeRemoveDialogWithRemoveAction(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveDialogRemove);
		btnRemoveDialogRemove.click();
		return this.waitForCondition(Driver->{return removeDialogLoadingIndicator.getAttribute("style").contains("display: none;");},15000);
	}

	/**
	 * To remove Items from Shopping cart
	 */
	public void removeItemsAddedFromShoppingCart(){
		GlobalHeaderPage globalHeaderPage = new GlobalHeaderPage(this.getDriver());
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeaderPage.CartBagCounter);
		this.getReusableActionsInstance().clickIfAvailable(globalHeaderPage.CartBagCounter);
		this.waitForPageToLoad();
		if(this.lstItemRemoveButtonFromCart.size()>0){
			for(int i=this.lstItemRemoveButtonFromCart.size()-1;i>=0;i--){
				WebElement removeButton=this.lstItemRemoveButtonFromCart.get(i);
				openRemoveDialog(removeButton);
				closeRemoveDialogWithRemoveAction();
				this.waitForPageToLoad();
				//Applying static wait here after wait for page load function again
				//as sometimes page loads but DOM is still getting refreshed and hence Stale Element Exception is thrown
				this.applyStaticWait(3000);
			}
		}
		//Verify that all items are removed
		this.getReusableActionsInstance().staticWait(3000);
		reporter.softAssert(productDetailPage.getShoppingCartNumber()==0,"All Items are removed from shopping Cart","Items are still present in shopping Cart with no of items: "+productDetailPage.getShoppingCartNumber());
	}

	/**
	 * To remove All Items From ShoppingCart List
	 */
	public void removeAllItemsFromShoppingCartList(){
		if(this.lstItemRemoveButtonFromCart.size()>0){
			for(int i=this.lstItemRemoveButtonFromCart.size()-1;i>=0;i--){
				WebElement removeButton=this.lstItemRemoveButtonFromCart.get(i);
				openRemoveDialog(removeButton);
				closeRemoveDialogWithRemoveAction();
				this.waitForPageToLoad();
				//Applying static wait here after wait for page load function again
				//as sometimes page loads but DOM is still getting refreshed and hence Stale Element Exception is thrown
				this.applyStaticWait(3000);
			}
		}
	}

	/**
	 * To get Shopping Item Description in shopping list
	 * @param - cartItem - item in lstCartItems
	 * @param - lsOption - "mandatory"/"optional"/"all"
	 *        -
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getShoppingItemDesc(WebElement cartItem,String lsOption){
		Map<String,Object> map=null;
		switch(lsOption){
			case "mandatory":
				map=this.getMandatoryShoppingItemDesc(cartItem);
				break;
			case "optional":
				map=this.getOptionalShoppingItemDesc(cartItem);
				break;
			case "all":
				map=this.getAllShoppingItemDesc(cartItem);
				break;
			default:
				break;
		}

		return map;
	}

	/**
	 * To get all Shopping Item Description in shopping list
	 * @param - cartItem - item in lstCartItems
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getAllShoppingItemDesc(WebElement cartItem){
		Map<String,Object> mapAll=new HashMap<>();

		Map<String,Object> mapMandatory=this.getMandatoryShoppingItemDesc(cartItem);
		for(Map.Entry<String,Object> entry:mapMandatory.entrySet()){
			mapAll.put(entry.getKey(),entry.getValue());
		}

		Map<String,Object> mapOptional=this.getOptionalShoppingItemDesc(cartItem);
		for(Map.Entry<String,Object> entry:mapOptional.entrySet()){
			mapAll.put(entry.getKey(),entry.getValue());
		}

		return mapAll;
	}

	/**
	 * To get Mandatory Shopping Item Description in shopping list
	 * @param - cartItem - item in lstCartItems
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getMandatoryShoppingItemDesc(WebElement cartItem){
		Map<String,Object> map=new HashMap<>();

		if(this.checkProductBadgeExisting(cartItem)){
			map.put("productBadge",true);
		}
		else{
			map.put("productBadge",false);
		}

		WebElement item=cartItem.findElement(byProductItemDesc);
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

		if(this.checkProductNumberExisting(cartItem)){
			item=cartItem.findElement(byProductNumber);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().replace("-","").trim();
			map.put("productNumber",lsText);
		}
		else{
			map.put("productNumber",null);
		}

		item=cartItem.findElement(byProductNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().trim();
		map.put("productNowPrice",this.getFloatFromString(lsText,true));

		item=cartItem.findElement(byProductSelectQuantity);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		Select select = new Select(item);
		lsText=select.getFirstSelectedOption().getText();
		map.put("productQuantity",Integer.parseInt(lsText));

		if(this.checkSelectQuantityEnabled(cartItem)){
			map.put("productQuantityDisabled",false);
		}
		else{
			map.put("productQuantityDisabled",true);
		}

		return map;
	}

	/**
	 * To get Optional Shopping Item Description in shopping list
	 * @param - cartItem - item in lstCartItems
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getOptionalShoppingItemDesc(WebElement cartItem){
		Map<String,Object> map=new HashMap<>();

		WebElement item;
		String lsText;

		if(this.checkShippingDateExisting(cartItem)){
			item=cartItem.findElement(byProductShippingDate);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productShippingDate",lsText);
		}
		else{
			map.put("productShippingDate",null);
		}

		if(this.checkRedMessageExisting(cartItem)){
			item=cartItem.findElement(byProductRedMessage);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productLeftNumber",this.getIntegerFromString(lsText));
		}
		else{
			map.put("productLeftNumber",null);
		}

		if(this.checkFreeShippingMessageExisting(cartItem)){
			item=cartItem.findElement(byProductBlackMessage);
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
	 * To get Shopping Item List Description
	 * @param - lsOption - "mandatory"/"optional"/"all"
	 * @return - List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getShoppingItemListDesc(String lsOption){
		List<Map<String,Object>> mapList=new ArrayList<>();

		for(WebElement cartItem:this.lstCartItems){
			mapList.add(this.getShoppingItemDesc(cartItem,lsOption));
		}

		return mapList;
	}

	/**
	 * To get Shopping Section Details
	 * @param - lsOption - "mandatory"/"optional"/"all"
	 * @return - Map<String,Object> - including shopping list,shopping amount, and shopping subtotal
	 */
	public Map<String,Object> getShoppingSectionDetails(String lsOption){
		Map<String,Object> map=new HashMap<>();

		map.put("shoppingList",this.getShoppingItemListDesc(lsOption));
		map.put("shoppingAmount",this.getShoppingAmount());
		map.put("shoppingSubTotal",this.getShoppingSubTotal());

		return map;
	}

	/**
	 * To get Product Name, Style and Size through splitting product description string with pipeline separator
	 * @param - lsProductDesc - the given product description string with pipeline separator
	 * @return - map<String,Object> - including Product Name, Style and Size
	 */
	public Map<String,Object> getProductNameAndStyleAndSize(String lsProductDesc){
		Map<String,Object> map=new HashMap<>();

		String[] lsSplit=lsProductDesc.split("|");
		map.put("productName",lsSplit[0].trim());
		map.put("productStyle",lsSplit[1].trim());
		map.put("productSize",lsSplit[2].split(":")[1].trim());

		return map;
	}

	/**
	 * To check if the AddToBag item match the given cart item
	 * @param - Map<String,Object> - addToBagMap
	 * @param - Map<String,Object> - shoppingItemMap
	 * @return - boolean
	 */
	public boolean checkIfMatchGivenAddToBagItem(Map<String,Object> addToBagMap,Map<String,Object> shoppingItemMap){
		if(shoppingItemMap.get("productStyle")!=null&&shoppingItemMap.get("productSize")!=null){
			if(addToBagMap.get("productName").toString().equalsIgnoreCase(shoppingItemMap.get("productName").toString())&&
					addToBagMap.get("productStyle").toString().equalsIgnoreCase(shoppingItemMap.get("productStyle").toString())&&
					addToBagMap.get("productSize").toString().equalsIgnoreCase(shoppingItemMap.get("productSize").toString())){
				return true;
			}
			else{
				return false;
			}
		}

		if(shoppingItemMap.get("productStyle")!=null&&shoppingItemMap.get("productSize")==null){
			if(addToBagMap.get("productName").toString().equalsIgnoreCase(shoppingItemMap.get("productName").toString())&&
					addToBagMap.get("productStyle").toString().equalsIgnoreCase(shoppingItemMap.get("productStyle").toString())){
				return true;
			}
			else{
				return false;
			}
		}

		if(shoppingItemMap.get("productStyle")==null&&shoppingItemMap.get("productSize")!=null){
			if(addToBagMap.get("productName").toString().equalsIgnoreCase(shoppingItemMap.get("productName").toString())&&
					addToBagMap.get("productSize").toString().equalsIgnoreCase(shoppingItemMap.get("productSize").toString())){
				return true;
			}
			else{
				return false;
			}
		}

		if(shoppingItemMap.get("productStyle")==null&&shoppingItemMap.get("productSize")==null){
			if(addToBagMap.get("productName").toString().equalsIgnoreCase(shoppingItemMap.get("productName").toString())){
				return true;
			}
			else{
				return false;
			}
		}

		return false;
	}

	/**
	 * To get Shopping Cart Quantity With Given AddToBag Information
	 * @param - Map<String,Object> - addToBagMap
	 * @param - Map<String,Object> - shoppingSectionDetailsMap
	 * @return - int - the product quantity, note that -1 represents not found
	 */
	public int getShoppingCartQuantityWithGivenAddToBagInfo(Map<String,Object> addToBagMap,Map<String,Object> shoppingSectionDetailsMap){
		List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingSectionDetailsMap.get("shoppingList");
		for(Map<String,Object> cartItemMap:shoppingList){
			if(this.checkIfMatchGivenAddToBagItem(addToBagMap,cartItemMap)){
				return (int)cartItemMap.get("productQuantity");
			}
		}
		return -1;
	}

	/**
	 * To get remove dialog description
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getRemoveDialogDesc(){
		String lsText;
		Map<String,Object> map=new HashMap<>();

		if(checkRemoveDialogBadgeExisting()){
			map.put("productBadge",true);
		}
		else{
			map.put("productBadge",false);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemDesc);
		lsText=lblRemoveDialogProductItemDesc.getText();
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
			map.put("productName",lsText.trim());
			map.put("productStyle",null);
			map.put("productSize",null);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemNumber);
		lsText=lblRemoveDialogProductItemNumber.getText().trim();
		map.put("productNumber",lsText.replace("-",""));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemPrice);
		lsText=lblRemoveDialogProductItemPrice.getText();
		map.put("productNowPrice",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemQuantity);
		lsText=lblRemoveDialogProductItemQuantity.getText();
		map.put("productQuantity",Integer.parseInt(lsText));

		return map;
	}

	/**
	 * To verify Contents Between CartItem And Remove Dialog
	 * @param - Map<String,Object> - cartItemMap - the cart item in shopping cart list
	 * @param - Map<String,Object> - removeDialogMap - the contents in remove dialog
	 */
	public void verifyContentsBetweenCartItemAndRemoveDialog(Map<String,Object> cartItemMap,Map<String,Object> removeDialogMap){
		boolean bCartItemProductBadge= (boolean) cartItemMap.get("productBadge");
		boolean bRemoveDialogProductBadge= (boolean) removeDialogMap.get("productBadge");
		if(bCartItemProductBadge==bRemoveDialogProductBadge){
			reporter.reportLogPass("The product badge in cart item is the same as the one in remove dialog");
		}
		else{
			reporter.reportLogFail("The product badge:"+bCartItemProductBadge+" in cart item is not the same as the one:"+bRemoveDialogProductBadge+" in remove dialog");
		}

		String cartItemProductName= cartItemMap.get("productName").toString();
		String removeDialogProductName= removeDialogMap.get("productName").toString();
		if(cartItemProductName.equalsIgnoreCase(removeDialogProductName)){
			reporter.reportLogPass("The product name in cart item is the same as the one in remove dialog");
		}
		else{
			reporter.reportLogFail("The product name:"+cartItemProductName+" in cart item is not the same as the one:"+removeDialogProductName+" in remove dialog");
		}

		if(cartItemMap.get("productStyle")!=null){
			String cartItemProductStyle= cartItemMap.get("productStyle").toString();
			String removeDialogProductStyle= removeDialogMap.get("productStyle").toString();
			if(cartItemProductStyle.equalsIgnoreCase(removeDialogProductStyle)){
				reporter.reportLogPass("The product style in cart item is the same as the one in remove dialog");
			}
			else{
				reporter.reportLogFail("The product style:"+cartItemProductStyle+" in cart item is not the same as the one:"+removeDialogProductStyle+" in remove dialog");
			}
		}

		if(cartItemMap.get("productSize")!=null){
			String cartItemProductSize= cartItemMap.get("productSize").toString();
			String removeDialogProductSize= removeDialogMap.get("productSize").toString();
			if(cartItemProductSize.equalsIgnoreCase(removeDialogProductSize)){
				reporter.reportLogPass("The product size in cart item is the same as the one in remove dialog");
			}
			else{
				reporter.reportLogFail("The product size:"+cartItemProductSize+" in cart item is not the same as the one:"+removeDialogProductSize+" in remove dialog");
			}
		}

		String cartItemProductNumber= cartItemMap.get("productNumber").toString();
		String removeDialogProductNumber= removeDialogMap.get("productNumber").toString();
		if(cartItemProductNumber.equalsIgnoreCase(removeDialogProductNumber)){
			reporter.reportLogPass("The product number in cart item is the same as the one in remove dialog");
		}
		else{
			reporter.reportLogFail("The product number:"+cartItemProductNumber+" in cart item is not the same as the one:"+removeDialogProductNumber+" in remove dialog");
		}

		float cartItemProductNowPrice= (float) cartItemMap.get("productNowPrice");
		float removeDialogProductNowPrice= (float) removeDialogMap.get("productNowPrice");
		if(Math.abs(cartItemProductNowPrice-removeDialogProductNowPrice)<0.1){
			reporter.reportLogPass("The product now price in cart item is equal to the one in remove dialog");
		}
		else{
			reporter.reportLogFail("The product now price:"+cartItemProductNowPrice+" in cart item is not equal to the one:"+removeDialogProductNowPrice+" in remove dialog");
		}

		int cartItemProductQuantity= (int) cartItemMap.get("productQuantity");
		int removeDialogProductQuantity= (int) removeDialogMap.get("productQuantity");
		if(cartItemProductQuantity==removeDialogProductQuantity){
			reporter.reportLogPass("The product Quantity in cart item is equal to the one in remove dialog");
		}
		else{
			reporter.reportLogFail("The product Quantity:"+cartItemProductQuantity+" in cart item is not equal to the one:"+removeDialogProductQuantity+" in remove dialog");
		}
	}

	/**
	 * To verify Contents on ShoppingCartItem in shopping item list with AddToBag
	 * @param - Map<String,Object> - PDPMap
	 * @param - Map<String,Object> - addToBagMap
	 * @param - Map<String,Object> - cartItemMap
	 * @param - boolean - bAPI - true represents addToBagMap from API while false represents for addToBagMap from UI
	 */
	public void verifyContentsOnShoppingCartItemWithAddToBag(Map<String,Object> PDPMap, Map<String,Object> addToBagMap,Map<String,Object> cartItemMap,boolean bAPI){
		if(!bAPI){
			boolean bAddToBagBadge= (boolean) addToBagMap.get("productBadge");
			boolean bShoppingCartBadge=(boolean) cartItemMap.get("productBadge");
			if(bAddToBagBadge==bShoppingCartBadge){
				reporter.reportLogPass("The Badge in AddToBag displaying is the same as shopping cart");
			}
			else{
				reporter.reportLogFail("The Badge in AddToBag:"+bAddToBagBadge+" displaying is not the same as shopping cart:"+bShoppingCartBadge);
			}
		}

		String productNameAddToBag= addToBagMap.get("productName").toString();
		String productNameShoppingCart=cartItemMap.get("productName").toString();
		if(productNameAddToBag.equalsIgnoreCase(productNameShoppingCart)){
			reporter.reportLogPass("The Product name in AddToBag displaying is the same as shopping cart");
		}
		else{
			reporter.reportLogFail("The Product name in AddToBag:"+productNameAddToBag+" displaying is not the same as shopping cart:"+productNameShoppingCart);
		}

		if(addToBagMap.get("productStyle")!=null){
			String productStyleAddToBag= addToBagMap.get("productStyle").toString();
			String productStyleShoppingCart=cartItemMap.get("productStyle").toString();
			if(productStyleAddToBag.equalsIgnoreCase(productStyleShoppingCart)){
				reporter.reportLogPass("The Product style in AddToBag displaying is the same as shopping cart");
			}
			else{
				reporter.reportLogFail("The Product style in AddToBag:"+productStyleAddToBag+" displaying is not the same as shopping cart:"+productStyleShoppingCart);
			}
		}

		if(addToBagMap.get("productSize")!=null){
			String productSizeAddToBag= addToBagMap.get("productSize").toString();
			String productSizeShoppingCart=cartItemMap.get("productSize").toString();
			if(productSizeAddToBag.equalsIgnoreCase(productSizeShoppingCart)){
				reporter.reportLogPass("The Product size in AddToBag displaying is the same as shopping cart");
			}
			else{
				reporter.reportLogFail("The Product size in AddToBag:"+productSizeAddToBag+" displaying is not the same as shopping cart:"+productSizeShoppingCart);
			}
		}

		String productNumberAddToBag= addToBagMap.get("productNumber").toString();
		String productNumberShoppingCart=cartItemMap.get("productNumber").toString();
		if(productNumberAddToBag.equalsIgnoreCase(productNumberShoppingCart)){
			reporter.reportLogPass("The Product number in AddToBag displaying is the same as shopping cart");
		}
		else{
			reporter.reportLogFail("The Product number in AddToBag:"+productNumberAddToBag+" displaying is not the same as shopping cart:"+productNumberShoppingCart);
		}

		if(!bAPI){
			int productQuantityAddToBag= Integer.parseInt(addToBagMap.get("productQuantity").toString());
			int productQuantityShoppingCart= Integer.parseInt(cartItemMap.get("productQuantity").toString());
			if(productQuantityAddToBag<=productQuantityShoppingCart){
				reporter.reportLogPass("The Product Quantity in AddToBag displaying is no more than the one in shopping cart");
			}
			else{
				reporter.reportLogFail("The Product Quantity in AddToBag:"+productQuantityAddToBag+" displaying is more than the one in shopping cart:"+productQuantityShoppingCart);
			}

			if(PDPMap.get("productLeftNumber")!=null){
				int productLeftNumberPDP= Integer.parseInt(PDPMap.get("productLeftNumber").toString());
				int productLeftNumberShoppingCart= Integer.parseInt(cartItemMap.get("productLeftNumber").toString());

				if(productLeftNumberPDP==productLeftNumberShoppingCart){
					reporter.reportLogPass("The Product left number in PDP displaying is the same as shopping cart");
				}
				else{
					reporter.reportLogFail("The Product left number:"+productLeftNumberPDP+" in PDP displaying is not the same as shopping cart:"+productLeftNumberShoppingCart);
				}
			}

			if(!bAPI){
				float nowPricePDP=(float)PDPMap.get("productNowPrice");
				float appliedPriceShoppingCart=(float)cartItemMap.get("productNowPrice");
				if(Math.abs(nowPricePDP-appliedPriceShoppingCart)<0.1){
					reporter.reportLogPass("The Product nowPrice in PDP displaying is the same as shopping cart");
				}
				else{
					reporter.reportLogFail("The Product nowPrice:"+nowPricePDP+" in PDP displaying is not the same as shopping cart:"+appliedPriceShoppingCart);
				}
			}
			else{
				float nowPricePDP= (float) addToBagMap.get("productNowPrice");
				float appliedPriceShoppingCart=Float.parseFloat(cartItemMap.get("productNowPrice").toString());
				if(Math.abs(nowPricePDP-appliedPriceShoppingCart)<0.1){
					reporter.reportLogPass("The Product nowPrice in API call results is the same as shopping cart");
				}
				else{
					reporter.reportLogFail("The Product nowPrice:"+nowPricePDP+" in API call results is not the same as shopping cart:"+appliedPriceShoppingCart);
				}
			}

		}
	}

	/**
	 * To find Given Product index In Shopping Cart Item List
	 * @param - addToBagMap - given product map data
	 * @param - shoppingSectionDetailsMap
	 * @return - int - note that -1 represents not found
	 */
	public int findGivenProductIndexInShoppingCartItemList(Map<String,Object> addToBagMap,Map<String,Object> shoppingSectionDetailsMap) {
		List<Map<String, Object>> shoppingList = (List<Map<String, Object>>) shoppingSectionDetailsMap.get("shoppingList");
		Map<String, Object> cartItemMap=null;
		int loopSize=shoppingList.size();
		for (int i=0;i<loopSize;i++) {
			cartItemMap = shoppingList.get(i);
			if (this.checkIfMatchGivenAddToBagItem(addToBagMap, cartItemMap)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * To find Given Product index In product List
	 * @param - Map<String,Object> - expectedProductItemMap - given product item map data
	 * @param - List<Map<String,Object>> - productListMap
	 * @return - int - note that -1 represents not found
	 */
	public int findGivenProductIndexInProductList(Map<String,Object> expectedProductItemMap,List<Map<String,Object>> productListMap) {
		Map<String, Object> productItemMap=null;
		int loopSize=productListMap.size();
		for (int i=0;i<loopSize;i++) {
			productItemMap = productListMap.get(i);
			if (this.checkIfMatchGivenAddToBagItem(expectedProductItemMap, productItemMap)) {
				return i;
			}
		}
		return -1;
	}


	/**
	 * To verify Contents Contents On ShoppingCart Section Details With AddToBag
	 * @param - Map<String,Object> - PDPMap,
	 * @param - Map<String,Object> - addToBagMap
	 * @param - Map<String,Object> - shoppingSectionDetailsMap
	 * @param - boolean - bAPI - true represents addToBagMap from API while false represents for addToBagMap from UI
	 */
	public void verifyContentsOnShoppingCartSectionDetailsWithAddToBag(Map<String,Object> PDPMap, Map<String,Object> addToBagMap,Map<String,Object> shoppingSectionDetailsMap, boolean bAPI){
		List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingSectionDetailsMap.get("shoppingList");
		int shoppingAmount= (int) shoppingSectionDetailsMap.get("shoppingAmount");
		float shoppingSubTotal= (float) shoppingSectionDetailsMap.get("shoppingSubTotal");

		for(Map<String,Object> cartItemMap:shoppingList){
			if(this.checkIfMatchGivenAddToBagItem(addToBagMap,cartItemMap)){
				this.verifyContentsOnShoppingCartItemWithAddToBag(PDPMap,addToBagMap,cartItemMap,bAPI);
				break;
			}
		}

		if(!bAPI){
			int itemAmountAddToBag= Integer.parseInt(addToBagMap.get("itemAmount").toString());
			if(itemAmountAddToBag==shoppingAmount){
				reporter.reportLogPass("The Item amount in AddToBag is equal to shopping amount in Shopping cart");
			}
			else{
				reporter.reportLogFail("The Item amount:"+itemAmountAddToBag+" in AddToBag is not equal to shopping amount:"+shoppingAmount+" in Shopping cart");
			}

			float subTotalAddToBag= Float.parseFloat(addToBagMap.get("SubTotal").toString());
			if(Math.abs(subTotalAddToBag-shoppingSubTotal)<0.1){
				reporter.reportLogPass("The SubTotal in AddToBag is equal to SubTotal in Shopping cart");
			}
			else{
				reporter.reportLogFail("The SubTotal:"+subTotalAddToBag+" in AddToBag is not equal to SubTotal:"+shoppingSubTotal+" in Shopping cart");
			}
		}
	}

	/**
	 * To calculate Item Count And SubTotal From ShoppingCart List
	 * @param - List<Map<String,Object>> - shoppingList
	 * @return - Map<String,Object> - including itemCount and subTotal
	 */
	public Map<String,Object> calculateItemCountAndSubTotalFromShoppingCartList(List<Map<String,Object>> shoppingList){
		float priceAmount=0.0f;
		int quantityAmount=0,itemQuantity;
		for(Map<String,Object> shoppingItem:shoppingList){
			if(shoppingItem.get("productQuantity")==null){
				continue;
			}
			itemQuantity= (int) shoppingItem.get("productQuantity");
			quantityAmount+=itemQuantity;
			priceAmount=priceAmount+itemQuantity*(float)shoppingItem.get("productNowPrice");
		}

		Map<String,Object> map=new HashMap<>();
		map.put("itemCount",quantityAmount);
		map.put("subTotal",priceAmount);

		return map;
	}

	/**
	 * To verify business logic Between ShoppingItem List And SubTotalSection
	 * @param - Map<String,Object> - shoppingCartMap
	 */
	public void verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(Map<String,Object> shoppingCartMap){
		List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
		int shoppingAmount= (int) shoppingCartMap.get("shoppingAmount");
		float shoppingSubTotal= (float) shoppingCartMap.get("shoppingSubTotal");

		Map<String,Object> calculateMap=calculateItemCountAndSubTotalFromShoppingCartList(shoppingList);
		int quantityAmount= (int) calculateMap.get("itemCount");
		float priceAmount= (float) calculateMap.get("subTotal");

		if(shoppingAmount==quantityAmount){
			reporter.reportLogPass("The quantity amount in shopping item list is equal to item amount in subtotal section");
		}
		else{
			reporter.reportLogFail("The quantity amount:"+quantityAmount+" in shopping item list is equal to item amount:"+shoppingAmount+" in subtotal section");
		}

		if(Math.abs(shoppingSubTotal-priceAmount)<0.1){
			reporter.reportLogPass("The total price*quantity amount in shopping item list is equal to subtotal amount in subtotal section");
		}
		else{
			reporter.reportLogFail("The total price*quantity amount:"+priceAmount+" in shopping item list is equal to subtotal amount:"+shoppingSubTotal+" in subtotal section");
		}
	}

	/**
	 * To check Product With Same Style And Different Sizes In ShoppingItem List, note that the function is for TrueFit size
	 * @param - Map<String,Object> - shoppingCartMap
	 * @return - boolean
	 */
	public boolean checkProductWithSameStyleAndDifferentSizesInShoppingItemList(Map<String,Object> shoppingCartMap){
		List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
		String lsOuterName,lsInnerName;
		Object outerStyle,outerSize,innerStyle,innerSize;
		String lsOuterStyle,lsOuterSize,lsInnerStyle,lsInnerSize;
		int amount;
		int loopSize=shoppingList.size();
		Map<String,Object> shoppingItemOuter,shoppingItemInner;

		for(int i=0; i<loopSize-1;i++){
			shoppingItemOuter=shoppingList.get(i);
			if(shoppingItemOuter.get("productStyle")==null||shoppingItemOuter.get("productSize")==null){
				continue;
			}
			amount=0;
			lsOuterName= shoppingItemOuter.get("productName").toString();
			outerStyle= shoppingItemOuter.get("productStyle");
			outerSize= shoppingItemOuter.get("productSize");
			lsOuterStyle=outerStyle.toString();
			lsOuterSize=outerSize.toString();
			for(int j=i+1;j<loopSize;j++){
				shoppingItemInner=shoppingList.get(j);
				if(shoppingItemInner.get("productStyle")==null||shoppingItemInner.get("productSize")==null){
					continue;
				}
				lsInnerName= shoppingItemInner.get("productName").toString();
				innerStyle= shoppingItemInner.get("productStyle");
				innerSize= shoppingItemInner.get("productSize");
				lsInnerStyle=innerStyle.toString();
				lsInnerSize=innerSize.toString();
				if(lsOuterName.equalsIgnoreCase(lsInnerName)&&lsOuterStyle.equalsIgnoreCase(lsInnerStyle)&&!lsOuterSize.equalsIgnoreCase(lsInnerSize)){
					amount+=1;
				}
			}
			if(amount>=1){
				return true;
			}
		}

		return false;
	}

	/**
	 * To get Shopping Item Amount From OrderSummary Section
	 * @return - int
	 */
	public int getShoppingItemAmountFromOrderSummarySection(){
		return this.getIntegerFromString(this.getElementInnerText(this.lblCartPricingOrderSummaryTitle));
	}

	/**
	 * To get OrderSummary Description
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getOrderSummaryDesc(){
		Map<String,Object> map=new HashMap<>();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartPricingOrderSummaryTitle);
		String lsText=this.lblCartPricingOrderSummaryTitle.getText();
		map.put("itemAmount",this.getIntegerFromString(lsText));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartPricingSubTotal);
		lsText=this.lblCartPricingSubTotal.getText();
		map.put("subTotal",this.getFloatFromString(lsText,true));

		if(this.checkShippingWasPriceExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartPricingShippingWasPrice);
			lsText=this.lblCartPricingShippingWasPrice.getText();
			map.put("wasPrice",this.getFloatFromString(lsText,true));
		}
		else{
			map.put("wasPrice",0.0f);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartPricingShippingNowPrice);
		lsText=this.lblCartPricingShippingNowPrice.getText().trim();
		if(!lsText.equalsIgnoreCase("Free")){
			map.put("nowPrice",this.getFloatFromString(lsText,true));
		}
		else{
			map.put("nowPrice",0.0f);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartPricingShippingEstimateTaxProvince);
		Select select=new Select(selectCartPricingShippingEstimateTaxProvince);
		lsText=select.getFirstSelectedOption().getText();
		map.put("province",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartPricingShippingEstimateTax);
		lsText=this.lblCartPricingShippingEstimateTax.getText();
		map.put("tax",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartPricingTotalPrice);
		lsText=this.lblCartPricingTotalPrice.getText();
		map.put("totalPrice",this.getFloatFromString(lsText,true));

		if(this.checkShippingSavingExistingFromOrderSummary()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartPricingYouAreSaving);
			lsText=this.lblCartPricingYouAreSaving.getText();
			map.put("savePrice",this.getFloatFromString(lsText,true));
		}
		else{
			map.put("savePrice",0.0f);
		}
		return map;
	}

	/**
	 * To get Province Tax Rate Map
	 * @return - Map<String,Float> - province as key and tax rate as value
	 * @throws IOException
	 */
	public Map<String,Object> getProvinceTaxRateMap() throws IOException {
		String fileName = "test-data/ProvinceRate.json";
		JSONObject jsonObject = DataConverter.readJsonFileIntoJSONObject(fileName);
		ObjectMapper objectMapper=new ObjectMapper();
		Map<String,Object> map = objectMapper.readValue(jsonObject.toJSONString(),Map.class);

		return map;
	}

	/**
	 * To verify OrderSummary business Logic
	 * @param - itemAmountShoppingCart - int - Shopping item amount in shopping cart
	 * @param - savePriceShoppingCart - float - saving price in shopping cart, note that if pass 0.0, means no saving message
	 * @param - subTotalShoppingCart - float - subTotal in shopping cart
	 * @param - orderSummaryMap - Map<String,Object>
	 * @param - Map<String,Object> - provincialTaxRate - note that if pass null, will not calculate tax for comparison
	 */
	public void verifyOrderSummaryBusinessLogic(int itemAmountShoppingCart,float savePriceShoppingCart,float subTotalShoppingCart,Map<String,Object> orderSummaryMap,Map<String,Object> provincialTaxRate){
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
			if(Math.abs(calSavePriceOrderSummary-savePriceShoppingCart)<0.01){
				reporter.reportLogPass("The calculated saving price in OrderSummary section is equal to the one in Shopping Cart item section");
			}
			else{
				reporter.reportLogFail("The calculated saving price:"+calSavePriceOrderSummary+" in OrderSummary section is not equal to the one:"+savePriceShoppingCart+" in Shopping Cart item section");
			}
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
	 * To get calculated provincial tax with given province
	 * @param - float - subTotal
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
	 * To set province code for estimated tax
	 * @param - String - provinceCode
	 */
	public void setProvinceCodeForEstimatedTax(String provinceCode){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartPricingShippingEstimateTaxProvince);
		Select select = new Select(this.selectCartPricingShippingEstimateTaxProvince);
		String lsTextSelectedOptionBefore=select.getFirstSelectedOption().getText();
		select.selectByVisibleText(provinceCode);
		String lsTextSelectedOptionAfter=select.getFirstSelectedOption().getText();
		//Checking this condition and applying static wait as there is no other check for waitForConditoin
		//method. Since two province can have same tax rate and since sub-total is same, tax will also be same
		if(!lsTextSelectedOptionBefore.equalsIgnoreCase(lsTextSelectedOptionAfter)){
			this.waitForPageToLoad();
			this.applyStaticWait(5*this.getStaticWaitForApplication());
		}
	}

	/**
	 * To set Installment Setting
	 * @param - String - optionText - option text for dropdown menu options for select installment
	 */
	public void setInstallmentSetting(String optionText){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select = new Select(this.selectCartEasyPayInstallmentNumber);
		select.selectByVisibleText(optionText);
		this.waitForEasyPaySectionLoadingFromNonInstallmentState();
	}

	/**
	 * To get Installment Options
 	 * @return - List<String>
	 */
	public List<String> getInstallmentOptions(){
		Select select = new Select(this.selectCartEasyPayInstallmentNumber);
		List<WebElement> lstOptions=select.getOptions();
		List<String> lstOptionText=new ArrayList<>();
		for(WebElement option:lstOptions){
			lstOptionText.add(this.getElementInnerText(option));
		}
		return lstOptionText;
	}

	/**
	 * To get EasyPay Description
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getEasyPayDesc(){
		Map<String,Object> map=new HashMap<>();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select=new Select(selectCartEasyPayInstallmentNumber);
		String lsText=select.getFirstSelectedOption().getText();
		map.put("installmentsNumber",this.getIntegerFromString(lsText));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartEasyPayTodayPayment);
		lsText=this.lblCartEasyPayTodayPayment.getText();
		map.put("todayPayment",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartEasyPayLeftPayment);
		lsText=this.lblCartEasyPayLeftPayment.getText();
		map.put("leftPayment",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartEasyPayFutureMonthlyPayment);
		lsText=this.lblCartEasyPayFutureMonthlyPayment.getText();
		map.put("futureMonthlyPayment",this.getFloatFromString(lsText,true));

		return map;
	}

	/**
	 * To get Installment business logic
	 * @param - Map<String,Object> - orderSummaryMap
	 */
	public void verifyInstallmentBusinessLogic(Map<String,Object> orderSummaryMap){
		String lsText;
		int totalInstallmentNumber;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select = new Select(this.selectCartEasyPayInstallmentNumber);
		String lsInstallmentNumber=select.getFirstSelectedOption().getText().trim();
		if(lsInstallmentNumber.equalsIgnoreCase("-")){
			//Selecting 2 as installment number by default for test
			if(select.getOptions().size()>=2)
				select.selectByValue("2");
			totalInstallmentNumber = 2;
		}
		else{
			totalInstallmentNumber= Integer.parseInt(lsInstallmentNumber);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartEasyPayTodayPayment);
		float todayPayment=this.getFloatFromString(this.lblCartEasyPayTodayPayment.getText(),true);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartEasyPayLeftPayment);
		float leftPayment=this.getFloatFromString(this.lblCartEasyPayLeftPayment.getText(),true);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartEasyPayFutureMonthlyPayment);
		float futureMonthlyPayment=this.getFloatFromString(this.lblCartEasyPayFutureMonthlyPayment.getText(),true);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartEasyPayFutureMonthlyPaymentTitle);
		int futureMonthlyPaymentNumber=this.getIntegerFromString(this.lblCartEasyPayFutureMonthlyPaymentTitle.getText());

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
		if(calFutureMonthlyPaymentNumber==futureMonthlyPaymentNumber){
			reporter.reportLogPass("The calculated future monthly payment number is equal to the future monthly payment number in installment section: "+futureMonthlyPaymentNumber);
		}
		else{
			reporter.reportLogFail("The calculated future monthly payment number:"+calFutureMonthlyPaymentNumber+" is not equal to the future monthly payment number:"+futureMonthlyPaymentNumber+" in installment section");
		}

		float calFutureMonthlyPayment=calLeftPayment/futureMonthlyPaymentNumber;
		if(Math.abs(calFutureMonthlyPayment-futureMonthlyPayment)<0.1){
			reporter.reportLogPass("The calculated future monthly payment is equal to the future monthly payment in installment section: "+futureMonthlyPayment);
		}
		else{
			reporter.reportLogFail("The calculated future monthly payment:"+calFutureMonthlyPayment+" is equal to the future monthly payment:"+futureMonthlyPayment+" in installment section");
		}
	}

	/**
	 * To verify Shopping Cart Contents
	 * @param - String - lsOption - "mandatory"/"Optional"/"all"
	 */
	public void verifyShoppingCartContents(String lsOption){
		switch(lsOption){
			case "mandatory":
				verifyMandatoryOrOptionalShoppingCartContents(true);
				break;
			case "optional":
				verifyMandatoryOrOptionalShoppingCartContents(false);
				break;
			case "all":
				verifyMandatoryOrOptionalShoppingCartContents(true);
				verifyMandatoryOrOptionalShoppingCartContents(false);
				break;
			default:
				break;
		}
	}

	/**
	 * To verify Mandatory/Optional Shopping Cart Contents
	 * @param - boolean - bMandatory
	 */
	public void verifyMandatoryOrOptionalShoppingCartContents(boolean bMandatory){
		String lsText;

		if(bMandatory){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTitle);
			lsText=lblCartTitle.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The cart title is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The cart title is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTopMessage);
			lsText=lblCartTopMessage.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The cart top message is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The cart top message is not displaying correctly");
			}


			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTableHeadingITEM);
			lsText=lblCartTableHeadingITEM.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The cart table heading ITEM title is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The cart table heading ITEM title is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTableHeadingPRICE);
			lsText=lblCartTableHeadingPRICE.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The cart table heading PRICE title is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The cart table heading PRICE title is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTableHeadingQUANTITY);
			lsText=lblCartTableHeadingQUANTITY.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The cart table heading QUANTITY title is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The cart table heading QUANTITY title is not displaying correctly");
			}

			WebElement element;
			int index=0;
			for(WebElement cartItem:lstCartItems){
				reporter.reportLog("Verify cart item "+index);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(cartItem);
				if(checkProductBadgeExisting(cartItem)){
					element=cartItem.findElement(byProductPicBadge);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					lsText=element.getAttribute("src");
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart item badge is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart item badge is not displaying correctly");
					}
				}

				element=cartItem.findElement(byProductPicLink);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText=element.getAttribute("href");
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The cart item pic link is not empty");
				}
				else{
					reporter.reportLogFailWithScreenshot("The cart item pic link is empty");
				}

				element=cartItem.findElement(byProductPicImage);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText=element.getAttribute("src");
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The cart item pic src is not empty");
				}
				else{
					reporter.reportLogFailWithScreenshot("The cart item pic src is empty");
				}

				element=cartItem.findElement(byProductItemDesc);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText=element.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The cart item product description is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The cart item product description is not displaying correctly");
				}

				if(this.checkProductNumberExisting(cartItem)){
					element=cartItem.findElement(byProductNumber);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					lsText=element.getText();
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart item product product number is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart item product number is not displaying correctly");
					}
				}

				if(this.checkRemoveButtonExisting(cartItem)){
					element=cartItem.findElement(byProductRemoveButton);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					lsText=element.getText();
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart item remove button is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart item remove button is not displaying correctly");
					}
				}

				element=cartItem.findElement(byProductSelectQuantity);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				if(this.getReusableActionsInstance().isElementVisible(element)){
					reporter.reportLogPass("The cart item shopping quantity is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The cart item shopping quantity is not displaying correctly");
				}
				index++;
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTableSubTotal);
			lsText=lblCartTableSubTotal.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The cart table subtotal is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The cart table subtotal is not displaying correctly");
			}
		}
		else{
			if(this.checkContainPreviouslyAddedItemsMessageExisting()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartContainPreviouslyAddedItemsMessage);
				lsText=this.lblCartContainPreviouslyAddedItemsMessage.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The Cart Containing Previously Added Items Message is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The Cart Containing Previously Added Items Message is not displaying correctly");
				}
			}

			if(this.checkCartNoticeTitleExisting()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartNoticeTitle);
				lsText=lblCartNoticeTitle.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The cart notice title is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The cart notice title is not displaying correctly");
				}
			}

			String lsCartNoticeMessage=this.checkCartNoticeMessageExisting();
			switch(lsCartNoticeMessage){
				case "both":
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartNoticeMultiPackMessage);
					lsText=lblCartNoticeMultiPackMessage.getText();
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart notice MultiPack message is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart notice MultiPack message is not displaying correctly");
					}

					this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartNoticeQuantityExceedingMessage);
					lsText=lblCartNoticeQuantityExceedingMessage.getText();
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart notice quantity exceeding message is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart notice quantity exceeding message is not displaying correctly");
					}
					break;
				case "errorMessage":
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartNoticeQuantityExceedingMessage);
					lsText=lblCartNoticeQuantityExceedingMessage.getText();
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart notice quantity exceeding message is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart notice quantity exceeding message is not displaying correctly");
					}
					break;
				case "multiPackMessage":
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartNoticeMultiPackMessage);
					lsText=lblCartNoticeMultiPackMessage.getText();
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart notice MultiPack message is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart notice MultiPack message is not displaying correctly");
					}
					break;
				default:
					break;
			}

			if(this.checkProductTrueFitMessageExisting()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartNoticeTrueFitMessage);
				lsText=lblCartNoticeTrueFitMessage.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The cart TrueFit message is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The cart TrueFit message is not displaying correctly");
				}

				this.applyStaticWait(5*this.getStaticWaitForApplication());
				lsText=lnkCartNoticeTrueFit.getAttribute("href");
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The cart TrueFit link is not empty");
				}
				else{
					reporter.reportLogFailWithScreenshot("The cart TrueFit link is empty");
				}
			}

			if(this.checkGetItByShippingMessageExisting()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartGetItByDate);
				lsText=lblCartGetItByDate.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The cart GetByDate message is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The cart GetByDate message is not displaying correctly");
				}
			}

			WebElement element;
			int index=0;
			for(WebElement cartItem:lstCartItems){
				reporter.reportLog("Verify cart item "+index);
				if(this.checkShippingDateExisting(cartItem)){
					element=cartItem.findElement(byProductShippingDate);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					lsText=element.getText();
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart item product shipping date is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart item product shipping date is not displaying correctly");
					}
				}

				if(this.checkRedMessageExisting(cartItem)){
					element=cartItem.findElement(byProductRedMessage);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					lsText=element.getText();
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart item red message is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart item red message is not displaying correctly");
					}
				}

				if(this.checkFreeShippingMessageExisting(cartItem)){
					element=cartItem.findElement(byProductBlackMessage);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					lsText=element.getText();
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart item free shipping message is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart item free shipping message is not displaying correctly");
					}
				}
				index++;
			}
		}
	}

	/**
	 * To verify OrderSummary Contents
	 */
	public void verifyOrderSummaryContents(){
		String lsText;

		if(this.checkMultiPackMessageInOrderSummarySectionExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingMultiPackMessage);
			lsText=lblCartPricingMultiPackMessage.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The MultiPack Message in OrderSummary is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The MultiPack Message in OrderSummary is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingOrderSummaryTitle);
		lsText=lblCartPricingOrderSummaryTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The cart pricing title in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The cart pricing title in OrderSummary is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingSubTotalTitle);
		lsText=lblCartPricingSubTotalTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The subtotal title in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The subtotal title in OrderSummary is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingSubTotal);
		lsText=lblCartPricingSubTotal.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The subtotal in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The subtotal in OrderSummary is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingShippingTitle);
		lsText=lblCartPricingShippingTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The shipping price title in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The shipping price title in OrderSummary is not displaying correctly");
		}

		if(checkShippingWasPriceExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingShippingWasPrice);
			lsText=lblCartPricingShippingWasPrice.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The shipping Was price in OrderSummary is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The shipping Was price in OrderSummary is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingShippingNowPrice);
		lsText=lblCartPricingShippingNowPrice.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The shipping Now price in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The shipping Now price in OrderSummary is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingEstimateTaxTitle);
		lsText=lblCartPricingEstimateTaxTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The estimated tax title in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The estimated tax title in OrderSummary is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectCartPricingShippingEstimateTaxProvince);
		if(this.getReusableActionsInstance().isElementVisible(selectCartPricingShippingEstimateTaxProvince)){
			reporter.reportLogPass("The estimated tax province in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The estimated tax province in OrderSummary is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingShippingEstimateTax);
		lsText=lblCartPricingShippingEstimateTax.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The estimated tax in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The estimated tax in OrderSummary is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingTotalPriceTitle);
		lsText=lblCartPricingTotalPriceTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The total price title in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The total price title in OrderSummary is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingTotalPrice);
		lsText=lblCartPricingTotalPrice.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The total price in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The total price in OrderSummary is not displaying correctly");
		}

		if(checkShippingSavingExistingFromOrderSummary()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingYouAreSaving);
			lsText=lblCartPricingYouAreSaving.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The saving price in OrderSummary is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The saving price in OrderSummary is not displaying correctly");
			}
		}
	}

	/**
	 * To verify Easy Payment Contents
	 */
	public void verifyEasyPaymentContents(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartEasyPayTitle);
		lsText=lblCartEasyPayTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The EasyPay title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The EasyPay title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartEasyPayInstallmentNumberTitle);
		lsText=lblCartEasyPayInstallmentNumberTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The EasyPay installment number title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The EasyPay installment number title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectCartEasyPayInstallmentNumber);
		if(this.getReusableActionsInstance().isElementVisible(selectCartEasyPayInstallmentNumber)){
			reporter.reportLogPass("The EasyPay installment options is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The EasyPay installment options is not displaying correctly");
		}

		Select select=new Select(selectCartEasyPayInstallmentNumber);
		if(select.getFirstSelectedOption().getText().trim().equalsIgnoreCase("-")){
			return;
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartEasyPayTodayPaymentTitle);
		lsText=lblCartEasyPayTodayPaymentTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Today payment title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Today payment title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartEasyPayTodayPayment);
		lsText=lblCartEasyPayTodayPayment.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Today payment is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Today payment is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartEasyPayLeftPaymentTitle);
		lsText=lblCartEasyPayLeftPaymentTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Left payment title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Left payment title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartEasyPayLeftPayment);
		lsText=lblCartEasyPayLeftPayment.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Left payment is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Left payment is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartEasyPayFutureMonthlyPaymentTitle);
		lsText=lblCartEasyPayFutureMonthlyPaymentTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Future monthly payment title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Future monthly payment title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartEasyPayFutureMonthlyPayment);
		lsText=lblCartEasyPayFutureMonthlyPayment.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Future monthly payment is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Future monthly payment is not displaying correctly");
		}
	}

	/**
	 * To verify Remove Dialog Contents
	 */
	public void verifyRemoveDialogContents(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveDialogClose);
		if(this.getReusableActionsInstance().isElementVisible(btnRemoveDialogClose)){
			reporter.reportLogPass("The Close button in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Close button in Remove dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogTitle);
		lsText=lblRemoveDialogTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The title in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The title in Remove dialog is not displaying correctly");
		}

		if(checkRemoveDialogBadgeExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(imgRemoveDialogProductBadge);
			lsText=imgRemoveDialogProductBadge.getAttribute("src");
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The product badge in Remove dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product badge in Remove dialog is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imgRemoveDialogProductImage);
		lsText=imgRemoveDialogProductImage.getAttribute("src");
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product image in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product image in Remove dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemDesc);
		lsText=lblRemoveDialogProductItemDesc.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product description in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product description in Remove dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemNumber);
		lsText=lblRemoveDialogProductItemNumber.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product item number in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product item number in Remove dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemPriceTitle);
		lsText=lblRemoveDialogProductItemPriceTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product item price title in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product item price title in Remove dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemPrice);
		lsText=lblRemoveDialogProductItemPrice.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product item price in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product item price in Remove dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemQuantityTitle);
		lsText=lblRemoveDialogProductItemQuantityTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product item quantity title in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product item quantity title in Remove dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemQuantity);
		lsText=lblRemoveDialogProductItemQuantity.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product item quantity in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product item quantity in Remove dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveDialogRemove);
		lsText=btnRemoveDialogRemove.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The remove button in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The remove button in Remove dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveDialogCancel);
		lsText=btnRemoveDialogCancel.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The cancel button in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The cancel button in Remove dialog is not displaying correctly");
		}
	}

	/**
	 * This function adds items to cart for a user
	 * @param - List<Map<String,Object>> - productData - list of map containing items data
	 * @param - String - customerEDP of user
	 * @param -String - access_token
	 * @param - String - cartGuidId for cart
	 * @return - Response - Response object from api
	 */
	public Response addItemsToCartForUser(List<Map<String,Object>> productData, int customerEDP, String access_token, String cartGuidId) throws IOException {
		Response cartResponse = null;
		if(productData.size()>0){
			String cartGuidIdValue = cartGuidId;
			CartAPI cartAPI = new CartAPI();
			for(Map<String,Object> cartData:productData){
				if(cartGuidIdValue==null){
					cartResponse = cartAPI.createNewCartOrAddItems(Arrays.asList(Integer.valueOf(cartData.get("edpNo").toString())),Integer.valueOf(cartData.get("itemToBeAdded").toString()),customerEDP,access_token,null);
					cartGuidIdValue = cartResponse.jsonPath().get("CartGuid");
				}else
					cartResponse = cartAPI.createNewCartOrAddItems(Arrays.asList(Integer.valueOf(cartData.get("edpNo").toString())),Integer.valueOf(cartData.get("itemToBeAdded").toString()),customerEDP,access_token,cartGuidIdValue);
			}
		}
		return cartResponse;
	}

	/**
	 * This function checks the cart if it exists or not and creates accordingly
	 * @param - Integer - customerEDP - edp for user to create cart
	 * @param - String - accessToken - accessToken for api
	 * @param - List<Map<String,Object> - itemsToBeAdded - List of Map Object for items in cart for user
	 * @param - boolean - bCheckExisting - if check the cart existing
	 * @return - List<Map<String,Object> - List of map object for all items in cart for user
	 * @throws IOException
	 */
	public List<Map<String,Object>> verifyCartExistsForUser(int customerEDP, String accessToken,List<Map<String,String>> itemsToBeAdded,boolean bCheckExisting) throws IOException {
		CartAPI cartApi = new CartAPI();
		CartResponse accountCart = null;
		Response responseExisting=cartApi.getAccountCartContentWithCustomerEDP(String.valueOf(customerEDP), accessToken);
		if(responseExisting.statusCode()==200)
			accountCart = JsonParser.getResponseObject(responseExisting.asString(), new TypeReference<CartResponse>() {});
		else
			return null;

		//If there is cart present for user, returning the data in cart
		if(bCheckExisting&&accountCart.getProducts().size()>0){
			List<Map<String,Object>> data = new ArrayList<>();
			/**String cartGuidId = accountCart.getCartGuid();
			Response response = cartApi.getCartContentWithCartGuid(cartGuidId,accessToken);
			CartResponse cartResponse = JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
			*/List<CartResponse.ProductsClass> productsClassList = accountCart.getProducts();
			List<CartResponse.CartLinesClass> cartLinesClassList = accountCart.getCartLines();

			for(CartResponse.CartLinesClass cartLinesClass:cartLinesClassList){
				CartResponse.CartLinesClass.CartLineItemClass cartLineItemClass = cartLinesClass.getCartLineItem();
				CartResponse.CartLinesClass.InCartClass inCartClass = cartLinesClass.getInCart();
				Map<String,Object> map = new HashMap<>();
				map.put("productNumber",cartLineItemClass.getItemNo());
				map.put("edpNo",cartLineItemClass.getEdpNo());
				map.put("itemToBeAdded",inCartClass.getQuantity());
				map.put("productStyle",cartLineItemClass.getStyle());
				map.put("productStyleDimensionId",cartLineItemClass.getStyleDimensionId());
				map.put("productSize",cartLineItemClass.getSize());
				map.put("productSizeDimensionId",cartLineItemClass.getSizeDimensionId());
				map.put("productNowPrice",this.getFloatFromString(cartLineItemClass.getAppliedPrice(),true));
				map.put("productWasPrice",cartLineItemClass.getWasPrice());
				map.put("productSavePrice",cartLineItemClass.getSavePrice());
				map.put("productAppliedShipping",cartLineItemClass.getAppliedShipping());
				map.put("advanceOrderMessage",cartLineItemClass.getSkuAvailabilityMessage());

				for(CartResponse.ProductsClass productsClass:productsClassList){
					boolean outerForLoop = false;
					if(productsClass.getItemNo().equalsIgnoreCase(map.get("productNumber").toString())){
						map.put("productName",productsClass.getName());
						map.put("productBadge",productsClass.isShowBadgeImage());
						for(CartResponse.ProductsClass.EdpsClass edps:productsClass.getEdps()){
							if(edps.getEdpNo()==Integer.valueOf(map.get("edpNo").toString())){
								map.put("edpsData",edps);
								outerForLoop = true;
								break;
							}
						}
						if(outerForLoop)
							break;
					}
				}
				data.add(map);
			}
			return data;
		}
		//If there is no cart present fo user, creating the cart for user and returning data
		else{
			List<Map<String,Object>> data = new ProductAPI().getProductDetailsToBeAddedToCartForUser(itemsToBeAdded);
			Response response = this.addItemsToCartForUser(data,customerEDP,accessToken,null);
			if(response.statusCode()==200)
				return data;
			else
				return null;
		}
	}

	/**
	 * To empty cart
	 * @param - int - customerEDP
	 * @param - String - accessToken
	 * @throws IOException
	 */
	public void emptyCart(int customerEDP,String accessToken) throws IOException {
		CartAPI cartAPI=new CartAPI();
		Response responseGet=cartAPI.getAccountCartContentWithCustomerEDP(String.valueOf(customerEDP),accessToken);
		AccountCartResponse accountCartResponseGet = JsonParser.getResponseObject(responseGet.asString(), new TypeReference<AccountCartResponse>() {});
		String cartGuidId=accountCartResponseGet.getCartGuid();
		cartAPI.emptyCartWithGuid(accessToken,cartGuidId);
	}

	/**
	 * To get Item Count And Price Information
	 * @param - Map<String,Object> - shoppingCartMap
	 * @param - boolean - bItemCountOnly
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getItemCountAndPriceInfo(Map<String,Object> shoppingCartMap,boolean bItemCountOnly){
		Map<String,Object> map=new HashMap<>();

		int itemCountInShoppingCartHeader=this.GetAddedItemAmount();
		map.put("itemCountInShoppingCartHeader",itemCountInShoppingCartHeader);

		int shoppingItemListCount=this.getItemCountFromShoppingList((List<Map<String,Object>>)shoppingCartMap.get("shoppingList"));
		map.put("shoppingItemCount",shoppingItemListCount);

		int shoppingItemCountInSubtotal=(int)shoppingCartMap.get("shoppingAmount");
		map.put("shoppingItemCountInSubtotal",shoppingItemCountInSubtotal);

		int itemCountInOrderSummary=this.getShoppingItemAmountFromOrderSummarySection();
		map.put("itemCountInOrderSummary",itemCountInOrderSummary);

		if(!bItemCountOnly){
			float subTotalShoppingCart=this.getShoppingSubTotal();
			map.put("subTotalShoppingCart",subTotalShoppingCart);

			float subTotalOrderSummary=this.getOrderSummarySubTotal();
			map.put("subTotalOrderSummary",subTotalOrderSummary);
		}

		return map;
	}

	/**
	 * To verify CheckOut section Contents
	 * @param - boolean - bBlueJaysOnly
	 */
	public void verifyCheckOutContents(boolean bBlueJaysOnly){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imgCartCheckoutDonationLogo);
		if(this.getReusableActionsInstance().isElementVisible(imgCartCheckoutDonationLogo)){
			reporter.reportLogPass("The checkout donation logo is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The checkout donation logo is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imgCartCheckoutDonationLogo);
		lsText=imgCartCheckoutDonationLogo.getAttribute("src");
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The image source of checkout donation logo is not empty");
		}
		else{
			reporter.reportLogFailWithScreenshot("The image source of checkout donation logo is empty");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imgCartCheckoutDonationDesc);
		lsText=imgCartCheckoutDonationDesc.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The checkout donation description is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The checkout donation description is not displaying correctly");
		}

		for(WebElement button:lstCartCheckoutDonationButton){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(button);
			lsText=button.getText().trim();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The "+lsText+" button is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The "+lsText+" button is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartCheckoutDonationReceiptMessage);
		lsText=lblCartCheckoutDonationReceiptMessage.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The checkout donation receipt message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The checkout donation receipt message is not displaying correctly");
		}

		if(bBlueJaysOnly){
			return;
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartCheckoutRedeemMessage);
		lsText=lblCartCheckoutRedeemMessage.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The checkout redeem message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The checkout redeem message is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCartCheckoutButton);
		lsText=btnCartCheckoutButton.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The checkout button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The checkout button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPrivacy);
		lsText=lblCartPrivacy.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The cart privacy message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The cart privacy message is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCartPrivacy);
		lsText=lnkCartPrivacy.getAttribute("href");
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The link of cart privacy is not empty");
		}
		else{
			reporter.reportLogFailWithScreenshot("The link of cart privacy is empty");
		}

	}

	/**
	 * This function returns the future monthly payment number left
	 * @return - int - future monthly payment number
	 */
	public int getFutureMonthlyPaymentNumber(){
		return Integer.valueOf(this.lblCartEasyPayFutureMonthlyPaymentTitle.getText().trim().split(" ")[0]);
	}


	/**
	 * To change Shopping Item Quantity by given shopping item index
	 * @param - int - given shopping Item Index
	 * @return - Map<String,Object> - including itemTotalDifference and itemQuantityDifference
	 */
	public Map<String,Object> changeShoppingItemQuantityByGivenIndex(int shoppingItemIndex) {
		WebElement shoppingItem = this.lstCartItems.get(shoppingItemIndex);
		WebElement selectQuantity = shoppingItem.findElement(this.byProductSelectQuantity);
		Select select = new Select(selectQuantity);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectQuantity);
		int quantityBeforeChange = this.getIntegerFromString(select.getFirstSelectedOption().getText());
		float price = this.getFloatFromString(this.getElementInnerText(shoppingItem.findElement(this.byProductNowPrice)), true);
		float itemTotalBeforeChange = price * quantityBeforeChange;

		int itemQuantityDifference = 0;
		List<WebElement> quantityOptionItemList = select.getOptions();
		for (WebElement option : quantityOptionItemList) {
			String optionText = this.getElementInnerText(option);
			int optionIndex = Integer.parseInt(optionText.trim());
			if (optionIndex != quantityBeforeChange) {
				itemQuantityDifference = optionIndex - quantityBeforeChange;
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectQuantity);
				select.selectByVisibleText(optionText);
				this.waitForCondition(Driver -> {
					return this.pageLoadingIndicator.getAttribute("style").contains("display: none");
				}, 20000);
				break;
			}
		}

		shoppingItem = this.lstCartItems.get(shoppingItemIndex);
		selectQuantity = shoppingItem.findElement(this.byProductSelectQuantity);
		select = new Select(selectQuantity);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectQuantity);
		int quantityAfterChange = this.getIntegerFromString(select.getFirstSelectedOption().getText());
		price = this.getFloatFromString(this.getElementInnerText(shoppingItem.findElement(this.byProductNowPrice)), true);
		float itemTotalAfterChange = price * quantityAfterChange;

		Map<String, Object> map = new HashMap<>();
		map.put("itemTotalDifference", itemTotalAfterChange - itemTotalBeforeChange);
		map.put("itemQuantityDifference", itemQuantityDifference);

		return map;
	}

	/**
	 * To choose Shopping Item By Given Item Index And Quantity
	 * @param - int - given shopping Item Index
	 * @param - int - given item quantity
	 * @return - boolean
	 */
	public boolean chooseShoppingItemByGivenItemIndexAndQuantity(int shoppingItemIndex,int quantity) {
		WebElement shoppingItem = this.lstCartItems.get(shoppingItemIndex);
		WebElement selectQuantity = shoppingItem.findElement(this.byProductSelectQuantity);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectQuantity);
		Select select = new Select(selectQuantity);
		select.selectByVisibleText(String.valueOf(quantity));

		return this.waitForCondition(Driver -> {
			return this.pageLoadingIndicator.getAttribute("style").contains("display: none");
		}, 20000);
	}

	/**
	 * This function adds Single Product With Conditions
	 * @param - String - productNumber
	 * @param - int - expectedQuantity
	 * @param - int - addQuantity
	 * @param - String - customerEDP
	 * @param - String - accessToken
	 * @param - boolean - bAdvancedOrder
	 * @return - Map<String,Object> - Map containing advance order info for a product
	 * @throws IOException
	 */
	public Map<String,Object> addSingleProductWithConditions(String productNumber, int expectedQuantity, int addQuantity, String customerEDP, String accessToken, boolean bAdvancedOrder) throws IOException {
		Map<String,Object> shoppingInfo = new HashMap<>();
		boolean flag = false;
		ProductDetailsItem productItem = new ProductAPI().getProductDetailsForSpecificProductNumber(productNumber);
		if(productItem==null)
			return null;
		else{
			for(ProductDetailsItem.Edp edps : productItem.getEdps()){
				if(bAdvancedOrder){
					if(edps.isIsAdvanceOrBackOrder()==true){
						shoppingInfo.put("edpNo",edps.getEdpNo());
						shoppingInfo.put("productNumber",edps.getItemNo());
						shoppingInfo.put("advanceOrderMessage",edps.getSkuAvailabilityMessage());
						shoppingInfo.put("productStyle",edps.getStyle());
						shoppingInfo.put("productSize",edps.getSize());
						shoppingInfo.put("productNowPrice",edps.getAppliedPrice());
						shoppingInfo.put("productName",productItem.getName());
						shoppingInfo.put("itemToBeAdded",addQuantity);
						flag = true;
					}
				}
				else{
					if(edps.getInventory()>=expectedQuantity){
						shoppingInfo.put("edpNo",edps.getEdpNo());
						shoppingInfo.put("productNumber",edps.getItemNo());
						shoppingInfo.put("advanceOrderMessage",edps.getSkuAvailabilityMessage());
						shoppingInfo.put("productStyle",edps.getStyle());
						shoppingInfo.put("productSize",edps.getSize());
						shoppingInfo.put("productNowPrice",edps.getAppliedPrice());
						shoppingInfo.put("productName",productItem.getName());
						shoppingInfo.put("itemToBeAdded",addQuantity);
						flag = true;
					}
				}

				if(flag){
					CartAPI cartApi = new CartAPI();
					CartResponse accountCart = null;
					Response responseExisting=cartApi.getAccountCartContentWithCustomerEDP(customerEDP, accessToken);
					if(responseExisting.statusCode()==200){
						accountCart = JsonParser.getResponseObject(responseExisting.asString(), new TypeReference<CartResponse>() {});
						Response response = this.addItemsToCartForUser(Arrays.asList(shoppingInfo),Integer.valueOf(customerEDP),accessToken,accountCart.getCartGuid());
						if(response.statusCode()==200)
							break;
					}
					else
						return null;
				}
			}
			return shoppingInfo;
		}
	}

	/**
	 * To add Multiple Product EDP No
	 * @param - String - productName
	 * @param - String - customerEDP
	 * @param - String - accessToken
	 * @param - int - expectedInventory - the expected inventory for each EDP NO
	 * @param - int - addCountEDPNo - added EDP NO count
	 * @param - int - addCountPerEDPNO - added quantity for every EDP NO
	 * @return - Response
	 * @throws IOException
	 */
	public Response addMultiProductEDPNo(String productName,String customerEDP, String accessToken,int expectedInventory, int addCountEDPNo,int addCountPerEDPNO) throws IOException {
		ProductAPI productAPI=new ProductAPI();
		List<Product.edps> products = productAPI.getEDPNoListWithGivenExpectedInventory(productName, expectedInventory, addCountEDPNo);
		List<Integer> productEDP = new ArrayList<>();
		for (Product.edps productEDPS : products) {
			productEDP.add(productEDPS.getEdpNo());
		}

		CartAPI cartApi = new CartAPI();
		CartResponse accountCart = null;
		Response responseAdd = null;
		Response responseExisting = cartApi.getAccountCartContentWithCustomerEDP(customerEDP, accessToken);
		if (responseExisting.statusCode() == 200) {
			accountCart = JsonParser.getResponseObject(responseExisting.asString(), new TypeReference<CartResponse>() {
			});
			responseAdd = cartApi.createNewCartOrAddItems(productEDP, addCountPerEDPNO, Integer.parseInt(customerEDP), accessToken, accountCart.getCartGuid());
		}

		return responseAdd;
	}
	/**
	 * This function verifies if configuration needs TSC as default Credit Card and adds it if necessary
	 * @param - List<Configuration> - Configuration from contentful present in system
	 * @param -JSONObject - creditCardData
	 * @param - String - customerEDP
	 * @param - String - accessToken
	 * @throws IOException
	 */
	public void verifyAndUpdateCreditCardAsPerSystemConfiguration(List<Configuration> configuration,JSONObject creditCardData,String customerEDP,String accessToken) throws IOException {
		if(configuration.size()>0){
			AccountAPI accountAPI = new AccountAPI();
			boolean outerFlag = false;
			boolean innerFlag = false;
			for(Configuration configurations:configuration){
				if(configurations.getKey().equalsIgnoreCase("GWPTscCCPaymentEnabled")){
					Boolean configValue = Boolean.valueOf(configurations.getValue());
					//Verifying if configValue is true, CC associated with user is TSC Card, else any other card will do
					if(configValue){
						Response response = accountAPI.getAccountDetailsFromCustomerEDP(customerEDP,accessToken);
						AccountResponse accountCartResponse = JsonParser.getResponseObject(response.asString(), new TypeReference<AccountResponse>() {});
						if(response.statusCode()==200){
							List<AccountResponse.CreditCardsClass> creditCardsClassList = accountCartResponse.getCreditCards();
							for(AccountResponse.CreditCardsClass creditCardsClass:creditCardsClassList){
								if(creditCardsClass.getType().equalsIgnoreCase("FI")){
									JSONObject jsonObject = new JSONObject();
									//Check if Credit Card is default
									boolean isDefault = creditCardsClass.isDefault();
									if(isDefault){
										jsonObject.clear();
										jsonObject.put("CardType",creditCardsClass.getType());
										jsonObject.put("CardNumber",creditCardsClass.getNumber());
										jsonObject.put("CardExpiryMonth",creditCardsClass.getDisplayExpirationMonth());
										jsonObject.put("CardExpiryYear",creditCardsClass.getDisplayExpirationYear());
										jsonObject.put("RememberCard",false);
										jsonObject.put("MakeDefaultCard",true);

										Response updatePaymentMethodResponse = accountAPI.updateCartPaymentMethod(jsonObject,customerEDP,accessToken);
										if(updatePaymentMethodResponse.getStatusCode()==200){
											outerFlag = true;
											break;
										}else
											reporter.reportLogFail("Payment Method for user is not updated to TSC Card");
									}else{
										//Updating Default Credit Card for user to be TSC
										int creditCardId = creditCardsClass.getId();

										jsonObject.clear();
										jsonObject.put("Id",creditCardId);
										jsonObject.put("ExpirationDate",creditCardsClass.getExpirationDate());
										jsonObject.put("Expired",creditCardsClass.isExpired());
										jsonObject.put("Number",creditCardsClass.getNumber());
										jsonObject.put("MaskedNumber",creditCardsClass.getMaskedNumber());
										jsonObject.put("IsDefault",true);
										jsonObject.put("Type",creditCardsClass.getType());
										jsonObject.put("DisplayExpirationMonth",creditCardsClass.getDisplayExpirationMonth());
										jsonObject.put("DisplayExpirationYear",creditCardsClass.getDisplayExpirationYear());
										jsonObject.put("CVV",null);

										Response updateResponse = accountAPI.updateCreditCardForUser(jsonObject,customerEDP,creditCardId,accessToken);
										if(updateResponse.statusCode()==200){
											reporter.reportLog("Default Credit Card is updated to be TSC for user");
											outerFlag = true;
											break;
										}
										else
											reporter.reportLogFail("Default Credit Card is not updated to be TSC for user");
									}
									innerFlag = true;
								}
							}
						if(!innerFlag){
							//Adding TSC card to user as configuration for TSC is set to true and no TSC card is present for user
							JSONObject tscCardObject = (JSONObject) creditCardData.get("tsc");
							tscCardObject.put("IsDefault",true);
							tscCardObject.put("CVV",null);
							tscCardObject.remove("CardType");
							tscCardObject.remove("CardDisplayName");
							Response tscCardResponse = accountAPI.addCreditCardToUser((org.json.simple.JSONObject) creditCardData.get("tsc"),customerEDP,accessToken);
							if(tscCardResponse.statusCode()==200)
								reporter.reportLog("New TSC Credit Card is added for user as default Card");
							else
								reporter.reportLogFail("New TSC Credit Card is not added for user as default Card");
							outerFlag = true;
						}
						}else{
							reporter.reportLogFail("Account Cart Response is not fetched as expected for Credit Card!");
							outerFlag = true;
						}
					}
				}
				if(outerFlag)
					break;
			}
		}else
			reporter.reportLogFail("Configuration object passed to function is null. Please verify api response!");
	}

	/**
	 * This function adds advance Order Info to a cart for user
	 * @param - String - productNumber
	 * @param - int - quantity
	 * @param - String - customerEDP
	 * @param - String - accessToken
	 * @return - Map<String,Object> - Map containing advance order info for a product
	 * @throws IOException
	 */
	public Map<String,Object> addAdvanceOrderOrSingleProductToCartForUser(String productNumber, int quantity, boolean isAdvanceOrder, String customerEDP, String accessToken) throws IOException {
		Map<String,Object> addedProductInfo = new HashMap<>();
		ProductDetailsItem productItem = new ProductAPI().getProductDetailsForSpecificProductNumber(productNumber);
		if(productItem==null)
			return null;
		else{
			for(ProductDetailsItem.Edp edps : productItem.getEdps()){
				if(isAdvanceOrder){
					if(!edps.isIsAdvanceOrBackOrder()==true)
						continue;
				}else{
					if(edps.isIsSoldOut()==true)
						continue;
				}

				addedProductInfo.put("edpNo",edps.getEdpNo());
				addedProductInfo.put("productNumber",edps.getItemNo());
				addedProductInfo.put("advanceOrderMessage",edps.getSkuAvailabilityMessage());
				addedProductInfo.put("productStyle",edps.getStyle());
				addedProductInfo.put("productSize",edps.getSize());
				addedProductInfo.put("productNowPrice",edps.getAppliedPrice());
				addedProductInfo.put("productName",productItem.getName());
				addedProductInfo.put("itemToBeAdded",quantity);

				CartAPI cartApi = new CartAPI();
				CartResponse accountCart = null;
				Response responseExisting=cartApi.getAccountCartContentWithCustomerEDP(customerEDP, accessToken);
				if(responseExisting.statusCode()==200){
					accountCart = JsonParser.getResponseObject(responseExisting.asString(), new TypeReference<CartResponse>() {});
					Response response = this.addItemsToCartForUser(Arrays.asList(addedProductInfo),Integer.valueOf(customerEDP),accessToken,accountCart.getCartGuid());
					if(response.statusCode()==200)
						break;
				}
				else
					return null;
			}
			return addedProductInfo;
		}
	}

	/**
	 * This function verifies that free shipping item is present in cart
	 */
	public void verifyFreeShippingItemPresentInCart(){
		boolean flag = false;
		for(WebElement webElement:lstCartItems){
			if(checkFreeShippingMessageExisting(webElement)){
				if(!checkSelectQuantityEnabled(webElement)){
					flag = true;
					break;
				}
			}
		}
		if(flag)
			reporter.reportLogPassWithScreenshot("Free Shipping item is added to cart as expected for user");
		else
			reporter.reportLogFailWithScreenshot("Free Shipping item is not added to cart as expected for user");
	}

	/**
	 * This function returns key:value pair for specified key for contentful configurations
	 * @param - List<Configuration> - Configuration Object
	 * @param - List<String> - ConfigKeys for fetching values
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getRequiredDetailsFromContentFulConfiguration(List<Configuration> configuration,List<String> configKeys){
		Map<String,Object> map = new HashMap<>();
		for(String key:configKeys){
			for(Configuration config:configuration){
				if(config.getKey().equalsIgnoreCase(key)){
					map.put(key,config.getValue());
					break;
				}
			}
		}
		return map;
	}

	/**
	 * To check If CheckOut Button Disabled
	 * @return - boolean - true for disabled and false for enabled
	 */
	public boolean checkIfCheckOutButtonDisabled(){
		return this.hasElementAttribute(this.btnCartCheckoutButton,"disabled");
	}

	/**
	 * To go To checkout page by clicking checkout button
	 */
	public void goToCheckoutPage(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCartCheckoutButton);
		this.btnCartCheckoutButton.click();
		RegularCheckoutPage checkoutPage= new RegularCheckoutPage(this.getDriver());
		this.waitForCondition(Driver->{return checkoutPage.lblCheckout.isDisplayed();},30000);
	}

	/**
	 * To wait For EasyPay Section Loading From NonInstallment State
	 * @return- boolean
	 */
	public boolean waitForEasyPaySectionLoadingFromNonInstallmentState(){
		return this.waitForCondition(Driver->{return this.getChildElementCount(this.cntEasyPayContainer)>1;},30000);
	}

	/**
	 * @return - String - selected button data to be used for verification
	 */
	public String selectAndGetTextForBlueJayCare(){
		int size = this.lstCartCheckoutDonationButton.size();
		if (size>0){
			getReusableActionsInstance().clickIfAvailable(this.lstCartCheckoutDonationButton.get(0));
			try{
				this.waitForCondition(Driver->{return this.checkChildElementExistingByTagNameAndAttribute(lblBlueJayDonation,"a","class","donationButton active");},10000);
			}catch (Exception exception){
				this.applyStaticWait(5000);
			}
			String selectedDonation = getReusableActionsInstance().getElementText(this.lblBlueJaySelectedDonation).trim();
			return selectedDonation;
		}
		return null;
	}

	/**
	 * @param - String - jayCareAddedAmount added by user
	 * @param - String - jayCareFoundationMessage message added in cart for user
	 */
	public void verifyBlueJayDonationAdditionInCart(String jayCareAddedAmount,String jayCareFoundationMessage){
		boolean flag = false;
		if(this.lstCartItems.size()>0){
			if(!jayCareAddedAmount.contains("."))
				jayCareAddedAmount = jayCareAddedAmount+".00";
			for(WebElement element:this.lstCartItems){
				String jayCareDescription = element.findElement(this.byProductItemDesc).getText();
				if(jayCareDescription.contains(jayCareFoundationMessage)){
					flag = true;
					String donationAmount = element.findElement(this.byProductNowPrice).getText();
					if(donationAmount.equalsIgnoreCase(jayCareAddedAmount))
						reporter.reportLogPassWithScreenshot("Jay Care Foundation Donation is added with amount: "+donationAmount+" as expected");
					else
						reporter.reportLogFailWithScreenshot("Jay Care Foundation Donation is not added with amount: "+donationAmount+" as expected");
				}
				if(flag)
					break;
			}
		}else
			reporter.reportLogFailWithScreenshot("No item is present in cart for user");

		if(flag)
			reporter.reportLog("Verification for Blue Jays Foundation is done as expected");
		else
			reporter.reportLogFailWithScreenshot("Blue Jays Foundation verification is not done!!");
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
		this.getReusableActionsInstance().clickIfAvailable(this.btnPayPalButton);
		this.waitForCondition(Driver->{return this.getDriver().getWindowHandles().size()>1;},5000);
		Set<String> windowHandles = this.getDriver().getWindowHandles();
		if(windowHandles.size()>1){
			for(String windowHandle:windowHandles){
				if(!windowHandle.equalsIgnoreCase(parentWindowHandle)){
					flag = true;
					this.getDriver().switchTo().window(windowHandle);
					this.waitForCondition(Driver->{return this.getReusableActionsInstance().isElementVisible(this.inputPayPalEmailInput) && this.inputPayPalEmailInput.isEnabled();},10000);
					String payPalUrl = this.getDriver().getCurrentUrl();
					if(payPalUrl.contains("paypal.com"))
						reporter.reportLogPass("User is navigated to PayPal pop up as expected with url: "+payPalUrl);
					else
						reporter.reportLogFail("User is not navigated to PayPal pop up as expected with url: "+payPalUrl);

					//Verification of email input box
					if(this.getReusableActionsInstance().isElementVisible(this.inputPayPalEmailInput) && this.inputPayPalEmailInput.isEnabled())
						reporter.reportLog("Email Input on Pay Pal Pop Up is enabled");
					else
						reporter.reportLogFailWithScreenshot("Email input on Pay Pal pop up is either not displayed or not enabled");

					this.getDriver().close();
					this.getReusableActionsInstance().switchToMainWindow(parentWindowHandle);
				}
				if(flag){
					this.getDriver().switchTo().defaultContent();
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
}
