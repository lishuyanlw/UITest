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
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[contains(@class,'go-back')]//a")
	public WebElement lnkBackToShopping;

	////////////////For Shopping bag section////////////////////////////

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='bag__wrapper']")
	public WebElement cntCart;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='bag__wrapper']/div[@class='blockPageWrap']")
	public WebElement loadingIndicator;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='bag__details']")
	public WebElement cntCartContents;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='bag__details']//*[@class='bag__title']")
	public WebElement lblCartTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='bag__details']//p[@class='bag__para--full']")
	public WebElement lblCartParaMessage;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='bag__details']//p[@class='bag__para']")
	public List<WebElement> lblCartParaMessageForEmptyCart;

	//For mobile device
//	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='bag__details']//button[contains(@class,'button__black mobileOnly')]")
//	public WebElement btnCartCheckoutButton;

	//For shopping item
	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='bag__details']//div[@class='bag__fulfilled--title']")
	public List<WebElement> lstShoppingBagFulfilledTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'bag__itemlist')]//div[contains(@class,'item__container')]")
	public List<WebElement> lstCartItems;

	public By byProductPicBadgeContainer=By.xpath(".//div[@class='item__image']");
	public By byProductPicBadge=By.xpath(".//div[@class='item__description']//div[@class='item__badge']");
	public By byProductPicLink=By.xpath(".//div[@class='item__image']//a");
	public By byProductPicImage=By.xpath(".//div[@class='item__image']//img");

	public By byProductDescContainer=By.xpath(".//div[@class='item__description']");
	public By byProductItemDesc=By.xpath(".//div[@class='item__description']//h3");
	public By byProductNumber=By.xpath(".//div[@class='item__description']//div[@class='item__number']");
	public By byProductStyleAndSize=By.xpath(".//div[@class='item__description']//div[@class='item__style']");
	public By byProductStockUrgentMessage=By.xpath(".//div[@class='item__description']//div[@class='item__stock-level--urgent']");

	public By byProductFavButton=By.xpath(".//div[@class='item__fav']//div[@class='bag-items__favorite']//button");
	public By byProductFavText=By.xpath(".//div[@class='item__fav']//div[@class='bag-items__favorite']//span");

	public By byProductQuantityMinusButton=By.xpath(".//div[@class='item__qty']//div[@class='quantity__container']//button[@class='quantity__minus']");
	public By byProductQuantityPlusButton=By.xpath(".//div[@class='item__qty']//div[@class='quantity__container']//button[@class='quantity__plus']");
	public By byProductQuantityDisplayText=By.xpath(".//div[@class='item__qty']//div[@class='quantity__container']//div[@class='quantity__display']");
	public By byProductQuantityRemoveButton=By.xpath(".//div[@class='item__qty']//button[@class='item__remove']");

	public By byProductPriceContainer=By.xpath(".//div[@class='item__price']/div");
	public By byProductNowPrice=By.xpath(".//div[@class='item__price']//span[@class='item__is-price']");
	public By byProductWasPrice=By.xpath(".//div[@class='item__price']//span[@class='item__was-price']");
	public By byProductFreeShipping=By.xpath(".//div[@class='item__price']//span[@class='item__free-shipping']");
	public By byProductEstimatedShippingDate=By.xpath(".//div[@class='item__price']//button[@class='item__estimated-date']");
	public By byProductShippingIcon=By.xpath(".//div[@class='item__price']//button[@class='item__estimated-date']//div[contains(@class,'shipping__icon')]");
	public By byProductShippingPriceLabel=By.xpath(".//div[@class='item__price']//span[@class='item__estimated-shipping--label']");
	public By byProductShippingPrice=By.xpath(".//div[@class='item__price']//span[@class='item__estimated-shipping--is']");
	public By byProductFreeShippingUnderEstimatedShippingDate=By.xpath(".//div[@class='item__price']//div[@class='item__free-shipping--text']");

	//Remove popup window after clicking remove button
	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//button[@class='dialog__card__close-button']")
	public WebElement btnRemoveDialogClose;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//*[@class='dialog__card__copy-heading']")
	public WebElement lblRemoveDialogTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__image']//img")
	public WebElement imgRemoveDialogProductImage;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__image']//a")
	public WebElement lnkRemoveDialogProductImageLink;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__description']")
	public WebElement cntRemoveDialogDescriptionContainer;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__description']//div[@class='item__badge']")
	public WebElement imgRemoveDialogProductBadge;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__description']//a")
	public WebElement lnkRemoveDialogProductItemDesc;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__description']//div[@class='item__number']")
	public WebElement lblRemoveDialogProductItemNumber;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__description']//div[@class='item__style'][span]")
	public WebElement lblRemoveDialogProductStyleAndSize;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__description']//div[@class='item__style'][not(span)]")
	public WebElement lblRemoveDialogProductQuantity;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__description']//div[@class='item__style']")
	public List<WebElement> lstRemoveDialogProductStyleAndSizeAndQuantity;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__price']/div")
	public WebElement cntRemoveDialogProductPriceContainer;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__price']/div/div[1]/span[@class='item__is-price']")
	public WebElement lblRemoveDialogProductNowPrice;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__price']/div/div[1]/span[@class='item__was-price']")
	public WebElement lblRemoveDialogProductWasPrice;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='item__price']/div/div[last()]")
	public WebElement lblRemoveDialogProductFreeShipping;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='dialog__buttons--container']//button[contains(@class,'remove')]")
	public WebElement btnRemoveDialogRemove;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[contains(@class,'removeDialog')]//div[@class='dialog__buttons--container']//button[contains(@class,'cancel')]")
	public WebElement btnRemoveDialogCancel;

	@FindBy(xpath="//div[@id='shopping-bag']//div[contains(@class,'bag__itemlist')]//div[contains(@class,'item__container')]//div[@class='item__qty']//button[@class='item__remove']")
	public List<WebElement> lstItemRemoveButtonFromCart;

	////////////////For Order summary section////////////////////////////
	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']")
	public WebElement cntOrderSummaryContainer;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='donation__wrap']//button[@class='donation__card']")
	public WebElement btnJaysCareDonationButton;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='donation__wrap']//div[@class='donation__image']//img")
	public WebElement imgJaysCareDonation;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='donation__wrap']//div[contains(@class,'donation__icon')]")
	public WebElement iconJaysCareDonationForExpansionStatus;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='donation__wrap']//div[contains(@class,'donation__message')]")
	public WebElement lblJaysCareDonationMessage;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='donation__wrap']//div[contains(@class,'donation__selector')]//input")
	public List<WebElement> lstJaysCareDonationCheckbox;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='donation__wrap']//div[contains(@class,'donation__selector')]//label")
	public List<WebElement> lstJaysCareDonationCheckboxLabel;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='donation__wrap']//div[contains(@class,'donation__sub-message')]")
	public WebElement lblJaysCareDonationSubMessage;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__easypay--wrap']/preceding-sibling::div[@class='summary__row']")
	public List<WebElement> lstOrderSummaryRow;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//div[contains(normalize-space(text()),'Jays Care Donation')]")
	public WebElement lblCartPricingJaysCareDonationTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//div[contains(normalize-space(text()),'Jays Care Donation')]//button")
	public WebElement btnCartPricingJaysCareDonationRemoveButton;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//div[contains(normalize-space(text()),'Jays Care Donation')]/following-sibling::div[last()]")
	public WebElement lblCartPricingJaysCareDonation;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//*[@class='summary__title']")
	public WebElement lblCartPricingOrderSummaryTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Subtotal')]/parent::div")
	public WebElement lblCartPricingSubTotalTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Subtotal')]/parent::div/following-sibling::div[last()]")
	public WebElement lblCartPricingSubTotal;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Shipping')]/parent::div")
	public WebElement lblCartPricingShippingTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Shipping')]/parent::div/following-sibling::div[last()]")
	public WebElement lblCartPricingShippingNowPrice;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Est. Taxes')]/parent::div")
	public WebElement lblCartPricingEstimateTaxTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Est. Taxes')]/following-sibling::select")
	public WebElement selectCartPricingShippingEstimateTaxProvince;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Est. Taxes')]/parent::div/following-sibling::div[last()]")
	public WebElement lblCartPricingShippingEstimateTax;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Multipack shipping discount')]/parent::div")
	public WebElement lblMultiPackShippingDiscountTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Multipack shipping discount')]/parent::div/following-sibling::div[last()]")
	public WebElement lblMultiPackShippingDiscount;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Gift Card')]/parent::div")
	public WebElement lblGiftCardRedeemTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Gift Card')]/parent::div/following-sibling::div[last()]")
	public WebElement lblGiftCardRedeemValue;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Total')]/parent::div")
	public WebElement lblCartPricingTotalPriceTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Total')]/parent::div/following-sibling::div[last()]")
	public WebElement lblCartPricingTotalPrice;

	//EasyPay
	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__easypay--wrap']//input[@id='easyPayCheckbox']")
	public WebElement ckbEasyPayCheckbox;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__easypay--wrap']//label")
	public WebElement labelEasyPayCheckbox;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__easypay--wrap']//button")
	public WebElement btnEasyPayLink;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//select[@class='summary__easypay--select']")
	public WebElement selectCartEasyPayInstallmentNumber;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//select[@class='summary__easypay--select']/option")
	public List<WebElement> lstEasyPayInstallmentNumberOptions;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Your total payment today')]")
	public WebElement lblCartEasyPayTodayPaymentTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Your total payment today')]/parent::div/following-sibling::div[last()]//span")
	public WebElement lblCartEasyPayTodayPayment;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Payment amount left after today')]")
	public WebElement lblCartEasyPayLeftPaymentTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'Payment amount left after today')]/parent::div/following-sibling::div[last()]//span")
	public WebElement lblCartEasyPayLeftPayment;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'future monthly payments')]/parent::div")
	public WebElement lblCartEasyPayFutureMonthlyPaymentTitle;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'future monthly payments')]/parent::div/following-sibling::div[last()]//span")
	public WebElement lblCartEasyPayFutureMonthlyPayment;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='summary']//div[@class='summary__row']//span[contains(normalize-space(text()),'*Shipping and taxes have been added to your first payment.')]")
	public WebElement lblCartEasyPayCommentsForShippingAndTax;

	//Checkout
	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='bag__summary']//button[contains(@class,'summary__button') and not(contains(@class,'button__black mobileOnly'))]")
	public WebElement btnCartCheckoutButton;

	@FindBy(xpath = "//div[@id='shopping-bag']//div[@class='bag__summary']//div[@class='summary__have-giftcard']")
	public WebElement lblCartTipMessageForDiscountAndGiftCard;

//	/**
//	 * To check empty cart message Existing
//	 * @return -boolean
//	 */
//	public boolean checkEmptyCartMessageExisting() {
//		return this.checkChildElementExistingByAttribute(this.cntCartContents, "class", "emptyContents");
//	}

	/**
	 * To check If OrderSummary And EasyPayment Not Existing
	 * @return - boolean
	 */
	public boolean checkIfOrderSummaryAndEasyPaymentNotExisting(){
		return this.getChildElementCount(cntOrderSummaryContainer)<2;
	}

	/**
	 * To check If it Is a FreeShipping Item
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkIfIsFreeShippingItem(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductItemDesc);
		WebElement parentItem=item.findElement(By.xpath("./parent::*"));
		if(parentItem.getTagName().equalsIgnoreCase("a")){
			return false;
		}
		return true;
	}

	/**
	 * To check Product Badge Existing
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkProductBadgeExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductDescContainer);
		return this.checkChildElementExistingByAttribute(item,"class","item__badge");
	}

	/**
	 * To check Product Style And Size section Existing
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkProductStyleAndSizeSectionExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductDescContainer);
		return this.checkChildElementExistingByAttribute(item,"class","item__style");
	}

	/**
	 * To check Product Stock Urgent Message Existing
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkProductStockUrgentMessageExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductDescContainer);
		return this.checkChildElementExistingByAttribute(item,"class","item__stock-level--urgent");
	}

	/**
	 * To check Product WasPrice Existing
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkProductWasPriceExisting(WebElement cartItem){
		WebElement itemPriceContainer=cartItem.findElement(byProductPriceContainer);
		WebElement item=itemPriceContainer.findElement(By.xpath("./div[1]"));
		return this.getChildElementCount(item)>1;
	}

	/**
	 * To check Product Free Shipping Message Existing
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkProductFreeShippingMessageExisting(WebElement cartItem){
		WebElement itemPriceContainer=cartItem.findElement(byProductPriceContainer);
		WebElement item=itemPriceContainer.findElement(By.xpath("./div[2]"));
		return this.getElementInnerText(item).equalsIgnoreCase("Free shipping");
	}

	/**
	 * To check Product Estimated Shipping Date Existing
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkProductEstimatedShippingDateExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductPriceContainer);
		return this.checkChildElementExistingByTagName(item,"button");
	}

	/**
	 * To check Product Shipping Price section expanded
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkProductShippingPriceSectionExpanded(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductShippingIcon);
		return item.getAttribute("class").contains("icon-minus");
	}

	/**
	 * To check Product Shipping Price existing
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkProductShippingPriceExisting(WebElement cartItem){
		WebElement itemPriceContainer=cartItem.findElement(byProductPriceContainer);
		return this.checkChildElementExistingByAttribute(itemPriceContainer,"class","item__estimated-shipping--is");
	}

	/**
	 * To check Product Free Shipping Existing In Shipping Price Section
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkProductFreeShippingExistingInShippingPriceSection(WebElement cartItem){
		WebElement itemPriceContainer=cartItem.findElement(byProductPriceContainer);
		return this.checkChildElementExistingByAttribute(itemPriceContainer,"class","item__free-shipping--text");
	}

	/**
	 * To check Product Quantity Plus Button Enabled
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkProductQuantityPlusButtonEnabled(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductQuantityPlusButton);
		return !this.hasElementAttribute(item,"disabled");
	}

	/**
	 * To check Product Quantity Minus Button Enabled
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkProductQuantityMinusButtonEnabled(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductQuantityMinusButton);
		return !this.hasElementAttribute(item,"disabled");
	}

	/**
	 * To check If Product FavIcon has been Clicked
	 * @param - WebElement - cartItem
	 * @return - boolean
	 */
	public boolean checkIfProductFavIconHighLighted(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductFavText);
		return this.getElementInnerText(item).contains("addedToFavourite");
	}

	/**
	 * To check if Jays Care Donation section Expanded
	 * @return - boolean
	 */
	public boolean checkJaysCareDonationExpanded(){
		return this.iconJaysCareDonationForExpansionStatus.getAttribute("class").contains("icon-minus");
	}

	/**
	 * To wait For Shopping Card Page Loading Completed
	 */
	public void  waitForShoppingCardPageLoadingCompleted(){
		try{
			this.waitForCondition(Driver->{return !this.checkChildElementExistingByAttribute(cntCart,"class","blockPageWrap");},60000);
		}
		catch(Exception ex){
			this.applyStaticWait(5*this.getStaticWaitForApplication());
		}
	}

	/**
	 * To check Badge existing in remove dialog
	 * @return - boolean
	 */
	public boolean checkRemoveDialogBadgeExisting(){
		return this.checkChildElementExistingByAttribute(cntRemoveDialogDescriptionContainer,"class","item__badge");
	}

	/**
	 * To check Style And Size Section existing in remove dialog
	 * @return - boolean
	 */
	public boolean checkRemoveDialogStyleAndSizeSectionExisting(){
		return this.lstRemoveDialogProductStyleAndSizeAndQuantity.size()>1;
	}

	/**
	 * To check WasPrice existing in remove dialog
	 * @return - boolean
	 */
	public boolean checkRemoveDialogWasPriceExisting(){
		WebElement priceContainer=cntRemoveDialogProductPriceContainer.findElement(By.xpath("./div[1]"));
		return this.getChildElementCount(priceContainer)>1;
	}

	/**
	 * To check Free Shipping Message existing in remove dialog
	 * @return - boolean
	 */
	public boolean checkRemoveDialogFreeShippingMessageExisting(){
		WebElement freeShippingContainer=cntRemoveDialogProductPriceContainer.findElement(By.xpath("./div[last()]"));
		return !this.getElementInnerText(freeShippingContainer).isEmpty();
	}

	/**
	 * To check EasyPayment Sections Existing
	 * @return - boolean
	 */
	public boolean checkEasyPaymentSectionsExisting(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.labelEasyPayCheckbox);
		if(!this.ckbEasyPayCheckbox.isSelected()){
			return false;
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select=new Select(this.selectCartEasyPayInstallmentNumber);
		String lsSelectedOption=select.getFirstSelectedOption().getText().trim();
		if(!lsSelectedOption.contains("Easy Pays")){
			return true;
		}

		return true;
	}

	/**
	 * To check Jays Care Donation Existing In OrderSummary()
	 * @return - boolean
	 */
	public boolean checkJaysCareDonationExistingInOrderSummary(){
		boolean bFind=false;
		for(WebElement item:this.lstOrderSummaryRow){
			WebElement subItem=item.findElement(By.xpath("./div[1]"));
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			String lsTitle=this.getElementInnerText(subItem);
			if(lsTitle.contains("Jays Care Donation")){
				bFind=true;
				break;
			}
		}
		return bFind;
	}

	/**
	 * To get Jays Care Donation Value In OrderSummary section
	 * @return - float
	 */
	public float getJaysCareDonationValueInOrderSummary(){
		if(this.checkJaysCareDonationExistingInOrderSummary()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingJaysCareDonation);
			String lsText=lblCartPricingJaysCareDonation.getText();

			return this.getFloatFromString(lsText);
		}
		return 0.0f;
	}

	/**
	 * To check MultiPackShipping Discount Existing In OrderSummary()
	 * @return - boolean
	 */
	public boolean checkMultiPackShippingDiscountExistingInOrderSummary(){
		boolean bFind=false;
		for(WebElement item:this.lstOrderSummaryRow){
			WebElement subItem=item.findElement(By.xpath("./div[1]"));
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			String lsTitle=subItem.getText().toLowerCase().trim();
			if(lsTitle.contains("multipack shipping discount")){
				bFind=true;
				break;
			}
		}
		return bFind;
	}

	/**
	 * To check promote code Discount Existing In OrderSummary()
	 * @return - boolean
	 */
	public boolean checkPromoteCodeDiscountExistingInOrderSummary(){
		boolean bFind=false;
		for(WebElement item:this.lstOrderSummaryRow){
			WebElement subItemTitle=item.findElement(By.xpath("./div[1]"));
			WebElement subItemValue=item.findElement(By.xpath("./div[last()]"));
			if(this.getElementInnerText(subItemValue).contains("-")){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItemTitle);
				String lsTitle=this.getElementInnerText(subItemTitle).toLowerCase();
				if(!lsTitle.contains("multipack shipping discount")&&!lsTitle.contains("gift card")){
					bFind=true;
					break;
				}
			}
		}
		return bFind;
	}

	/**
	 * To check Gift Card Existing In OrderSummary()
	 * @return - boolean
	 */
	public boolean checkGiftCardExistingInOrderSummary(){
		boolean bFind=false;
		for(WebElement item:this.lstOrderSummaryRow){
			WebElement subItem=item.findElement(By.xpath("./div[1]"));
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			String lsTitle=this.getElementInnerText(subItem).toLowerCase().trim();
			if(lsTitle.contains("gift card")){
				bFind=true;
				break;
			}
		}
		return bFind;
	}

	/**
	 * To check if it Is Dropdown Menu For Installment Number
	 * @return - boolean
	 */
	public boolean checkIsDropdownMenuForInstallmentNumber(){
		return this.checkChildElementExistingByTagName(this.cntOrderSummaryContainer,"select");
	}

	/**
	 * To get Shopping amount
	 * @return - int - shopping amount
	 */
	public int getShoppingAmount(){
		String lsText=this.getElementInnerText(lblCartPricingOrderSummaryTitle);
		return this.getIntegerFromString(lsText);
	}

	/**
	 * To get subtotal from OrderSummary section
	 * @return - float - Subtotal
	 */
	public float getOrderSummarySubTotal(){
		String lsText=this.getElementInnerText(lblCartPricingSubTotal);
		return this.getFloatFromString(lsText);
	}

	/**
	 * To get shipping price from OrderSummary section
	 * @return - float - Subtotal
	 */
	public float getOrderSummaryShippingPrice(){
		String lsText=this.getElementInnerText(lblCartPricingShippingNowPrice);
		return this.getFloatFromString(lsText);
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
	 * To get SubTotal from Shopping cart List
	 * @return - int
	 */
	public float getSubTotalFromShoppingList(List<Map<String,Object>> mapShoppingCartList){
		float sum=0.0f;
		for(Map<String,Object> cartItem:mapShoppingCartList){
			sum+=(float)cartItem.get("productNowPrice")*(int)cartItem.get("productQuantity");
		}

		return sum;
	}

	/**
	 * To get Shipping price Total from Shopping cart List
	 * @return - int
	 */
	public float getShippingPriceTotalFromShoppingList(List<Map<String,Object>> mapShoppingCartList){
		float sum=0.0f;
		for(Map<String,Object> cartItem:mapShoppingCartList){
			sum+=(float)cartItem.get("productShippingPrice");
		}

		return sum;
	}

	/**
	 * To check Free Shipping Item Existing In Shopping List
	 * @return - int
	 */
	public int checkFreeShippingItemExistingInShoppingList(){
		int loopSize=this.lstCartItems.size();
		for(int i=0;i<loopSize;i++){
			WebElement cartItem=this.lstCartItems.get(i);
			if(this.checkIfIsFreeShippingItem(cartItem)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * To get First Not Free Shipping Cart Item In Shopping List
	 * @return - int
	 */
	public int getFirstNotFreeShippingCartItemInShoppingList(){
		int loopSize=this.lstCartItems.size();
		for(int i=0;i<loopSize;i++){
			WebElement cartItem=this.lstCartItems.get(i);
			if(!this.checkIfIsFreeShippingItem(cartItem)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * To get First Cart Item With Available Remove Button
	 * @return - Map<String,WebElement> - including cartItem and removeButton
	 */
	public Map<String,WebElement> getFirstCartItemWithAvailableRemoveButton(){
		Map<String,WebElement> map=new HashMap<>();

		for(WebElement cartItem:this.lstCartItems){
			if(!this.checkIfIsFreeShippingItem(cartItem)){
				map.put("cartItem",cartItem);
				WebElement removeButton=cartItem.findElement(this.byProductQuantityRemoveButton);
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
		return this.waitForCondition(Driver->{return lblRemoveDialogTitle.isDisplayed();},15000);
	}

	/**
	 * To close remove dialog Without Remove Action
	 * @param - boolean - bCancel - true for clicking Cancel button while false for clicking close button
	 * @return - boolean
	 */
	public void closeRemoveDialogWithoutRemoveAction(boolean bCancel){
		if(bCancel){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveDialogCancel);
			btnRemoveDialogCancel.click();
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveDialogClose);
			btnRemoveDialogClose.click();
		}
		this.applyStaticWait(3*this.getStaticWaitForApplication());
	}

	/**
	 * To close remove dialog with remove action
	 */
	public void closeRemoveDialogWithRemoveAction(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnRemoveDialogRemove);
		btnRemoveDialogRemove.click();
		try{
			this.waitForShoppingCardPageLoadingCompleted();
		}
		catch (Exception ex){
			this.applyStaticWait(3*this.getStaticWaitForApplication());
		}
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

		WebElement item=cartItem.findElement(byProductItemDesc);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		String lsText=item.getText().trim();
		map.put("productName",lsText);

		if(this.checkIfIsFreeShippingItem(cartItem)){
			map.put("productBadge",false);
			map.put("productStyle",null);
			map.put("productSize",null);
			map.put("productNumber",null);
			map.put("productNowPrice",0.0f);
			map.put("productNowPrice",0.0f);
			map.put("productQuantity",1);
			map.put("productQuantityDisabled",true);
			map.put("freeShippingItem",true);

			return map;
		}

		if(this.checkProductBadgeExisting(cartItem)){
			map.put("productBadge",true);
		}
		else{
			map.put("productBadge",false);
		}

		if(!this.checkProductStyleAndSizeSectionExisting(cartItem)){
			map.put("productStyle",null);
			map.put("productSize",null);
		}
		else{
			item=cartItem.findElement(byProductStyleAndSize);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			if(lsText.contains("|")){
				String[] lsSplit=lsText.split("\\|");
				map.put("productSize",lsSplit[0].split(":")[1].trim());
				map.put("productStyle",lsSplit[1].split(":")[1].trim());
			}
			else{
				if(lsText.contains("Style")){
					map.put("productStyle",lsText.split(":")[1].trim());
					map.put("productSize",null);
				}
				else{
					map.put("productSize",lsText.split(":")[1].trim());
					map.put("productStyle",null);
				}
			}
		}

		item=cartItem.findElement(byProductNumber);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().replace("-","").trim();
		map.put("productNumber",lsText);

		item=cartItem.findElement(byProductNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().trim();
		map.put("productNowPrice",this.getFloatFromString(lsText));

		if(this.checkProductWasPriceExisting(cartItem)){
			item=cartItem.findElement(byProductWasPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productWasPrice",this.getFloatFromString(lsText));
		}
		else{
			map.put("productWasPrice",0.0f);
		}

		item=cartItem.findElement(byProductQuantityDisplayText);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText();
		map.put("productQuantity",Integer.parseInt(lsText));

		if(this.checkProductQuantityPlusButtonEnabled(cartItem)){
			map.put("productQuantityDisabled",false);
		}
		else{
			map.put("productQuantityDisabled",true);
		}

		if(checkProductEstimatedShippingDateExisting(cartItem)){
			item=cartItem.findElement(byProductEstimatedShippingDate);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productShippingDateTitle",lsText.split(":")[0].trim());
			map.put("productShippingDate",lsText.split(":")[1].trim());

			if(!this.checkProductShippingPriceSectionExpanded(cartItem)){
				this.clickElement(item);
				this.waitForCondition(Driver->{return this.checkProductShippingPriceSectionExpanded(cartItem);},10000);
			}

			if(checkProductShippingPriceExisting(cartItem)){
				WebElement subItem=cartItem.findElement(byProductShippingPrice);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				lsText=subItem.getText().trim();
				map.put("productShippingPrice",this.getFloatFromString(lsText));
			}
			else{
				map.put("productShippingPrice",0.0f);
			}
		}
		else{
			map.put("productShippingDateTitle",null);
			map.put("productShippingDate",null);
			map.put("productShippingPrice",0.0f);
		}

		map.put("freeShippingItem",false);

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

		if(this.checkProductStockUrgentMessageExisting(cartItem)){
			item=cartItem.findElement(byProductStockUrgentMessage);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productLeftNumber",this.getIntegerFromString(lsText));
		}
		else{
			map.put("productLeftNumber",-1);
		}

		if(this.checkProductFreeShippingMessageExisting(cartItem)){
			item=cartItem.findElement(byProductFreeShipping);
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

		List<Map<String,Object>> shoppingList=this.getShoppingItemListDesc(lsOption);
		map.put("shoppingList",shoppingList);
		map.put("shoppingAmount",this.getItemCountFromShoppingList(shoppingList));
		map.put("shoppingSubTotal",this.getSubTotalFromShoppingList(shoppingList));

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
			if(addToBagMap.get("productStyle")!=null&&addToBagMap.get("productSize")!=null){
				if(addToBagMap.get("productName").toString().equalsIgnoreCase(shoppingItemMap.get("productName").toString())&&
						addToBagMap.get("productStyle").toString().equalsIgnoreCase(shoppingItemMap.get("productStyle").toString())&&
						addToBagMap.get("productSize").toString().equalsIgnoreCase(shoppingItemMap.get("productSize").toString())){
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

		if(shoppingItemMap.get("productStyle")!=null&&shoppingItemMap.get("productSize")==null){
			if(addToBagMap.get("productStyle")!=null){
				if(addToBagMap.get("productName").toString().equalsIgnoreCase(shoppingItemMap.get("productName").toString())&&
						addToBagMap.get("productStyle").toString().equalsIgnoreCase(shoppingItemMap.get("productStyle").toString())){
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

		if(shoppingItemMap.get("productStyle")==null&&shoppingItemMap.get("productSize")!=null){
			if(addToBagMap.get("productSize")!=null){
				if(addToBagMap.get("productName").toString().equalsIgnoreCase(shoppingItemMap.get("productName").toString())&&
						addToBagMap.get("productSize").toString().equalsIgnoreCase(shoppingItemMap.get("productSize").toString())){
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkRemoveDialogProductItemDesc);
		lsText=lnkRemoveDialogProductItemDesc.getText().trim();
		map.put("productName",lsText);

		if(!checkRemoveDialogStyleAndSizeSectionExisting()){
			map.put("productStyle",null);
			map.put("productSize",null);
		}
		else{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductStyleAndSize);
			lsText=lblRemoveDialogProductStyleAndSize.getText().trim();
			if(lsText.contains("|")){
				String[] lsSplit=lsText.split("\\|");
				map.put("productSize",lsSplit[0].split(":")[1].trim());
				map.put("productStyle",lsSplit[1].split(":")[1].trim());
			}
			else{
				if(lsText.contains("Style")){
					map.put("productStyle",lsText.split(":")[1].trim());
					map.put("productSize",null);
				}
				else{
					map.put("productSize",lsText.split(":")[1].trim());
					map.put("productStyle",null);
				}
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemNumber);
		lsText=lblRemoveDialogProductItemNumber.getText().trim();
		map.put("productNumber",lsText.replace("-",""));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductNowPrice);
		lsText=lblRemoveDialogProductNowPrice.getText();
		map.put("productNowPrice",this.getFloatFromString(lsText));

		if(this.checkRemoveDialogWasPriceExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductWasPrice);
			lsText=lblRemoveDialogProductWasPrice.getText();
			map.put("productWasPrice",this.getFloatFromString(lsText));
		}
		else{
			map.put("productWasPrice",0.0f);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductQuantity);
		lsText=lblRemoveDialogProductQuantity.getText();
		map.put("productQuantity",this.getIntegerFromString(lsText));

		if(this.checkRemoveDialogFreeShippingMessageExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductFreeShipping);
			lsText=lblRemoveDialogProductFreeShipping.getText().trim();
			map.put("productFreeShipping",lsText);
		}
		else{
			map.put("productFreeShipping",null);
		}

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

		if((float)cartItemMap.get("productWasPrice")>0.1f){
			float cartItemProductWasPrice= (float) cartItemMap.get("productWasPrice");
			float removeDialogProductWasPrice= (float) removeDialogMap.get("productWasPrice");
			if(Math.abs(cartItemProductWasPrice-removeDialogProductWasPrice)<0.1){
				reporter.reportLogPass("The product was price in cart item is equal to the one in remove dialog");
			}
			else{
				reporter.reportLogFail("The product was price:"+cartItemProductWasPrice+" in cart item is not equal to the one:"+removeDialogProductWasPrice+" in remove dialog");
			}
		}

		int cartItemProductQuantity= (int) cartItemMap.get("productQuantity");
		int removeDialogProductQuantity= (int) removeDialogMap.get("productQuantity");
		if(cartItemProductQuantity==removeDialogProductQuantity){
			reporter.reportLogPass("The product Quantity in cart item is equal to the one in remove dialog");
		}
		else{
			reporter.reportLogFail("The product Quantity:"+cartItemProductQuantity+" in cart item is not equal to the one:"+removeDialogProductQuantity+" in remove dialog");
		}

		if(cartItemMap.get("productFreeShipping")!=null){
			String cartItemProductFreeShipping= cartItemMap.get("productFreeShipping").toString();
			String removeDialogProductFreeShipping= removeDialogMap.get("productFreeShipping").toString();
			if(cartItemProductFreeShipping.equalsIgnoreCase(removeDialogProductFreeShipping)){
				reporter.reportLogPass("The product FreeShipping in cart item is the same as the one in remove dialog");
			}
			else{
				reporter.reportLogFail("The product FreeShipping:"+cartItemProductFreeShipping+" in cart item is not the same as the one:"+removeDialogProductFreeShipping+" in remove dialog");
			}
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
	 * @param - Map<String,Object> - orderSummaryMap
	 */
	public void verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(Map<String,Object> shoppingCartMap,Map<String,Object> orderSummaryMap){
		List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
		int shoppingAmount= (int) shoppingCartMap.get("shoppingAmount");
		float shoppingSubTotal= (float) shoppingCartMap.get("shoppingSubTotal");

		Map<String,Object> calculateMap=calculateItemCountAndSubTotalFromShoppingCartList(shoppingList);
		int quantityAmount= (int) calculateMap.get("itemCount");
		float priceAmount= (float) calculateMap.get("subTotal");

		if(this.checkJaysCareDonationExistingInOrderSummary()){
			quantityAmount+=1;
			priceAmount+=(float)orderSummaryMap.get("donationValue");
		}

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
	 * To get Shopping Item Amount on checkout button
	 * @return - int
	 */
	public int getShoppingItemAmountOnCheckoutButton(){
		return this.getIntegerFromString(this.getElementInnerText(this.btnCartCheckoutButton));
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartPricingShippingNowPrice);
		lsText=this.lblCartPricingShippingNowPrice.getText().trim();
		if(!lsText.equalsIgnoreCase("Free")){
			map.put("nowPrice",this.getFloatFromString(lsText));
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

		if(this.checkJaysCareDonationExistingInOrderSummary()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingJaysCareDonation);
			lsText=lblCartPricingJaysCareDonation.getText();
			map.put("donationValue",this.getFloatFromString(lsText));
		}
		else{
			map.put("donationValue",0.0f);
		}

		float floatValue=0.0f;
		if(this.checkMultiPackShippingDiscountExistingInOrderSummary()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMultiPackShippingDiscount);
			lsText= lblMultiPackShippingDiscount.getText();
			if(lsText.contains("-")){
				if(lsText.equalsIgnoreCase("-")){
					map.put("multiPackShippingDiscountValue",0.0f);
				}
				else{
					floatValue=-1*this.getFloatFromString(lsText);
					map.put("multiPackShippingDiscountValue",floatValue);
				}
			}
			else{
				floatValue=this.getFloatFromString(lsText);
				map.put("multiPackShippingDiscountValue",floatValue);
			}
		}
		else{
			map.put("multiPackShippingDiscountValue",0.0f);
		}

		if(this.checkPromoteCodeDiscountExistingInOrderSummary()) {
			map.put("promoteCodeValue", 0.0f);
			for (WebElement item : this.lstOrderSummaryRow) {
				WebElement subItemTitle = item.findElement(By.xpath("./div[1]"));
				WebElement subItemValue = item.findElement(By.xpath("./div[last()]"));
				if (this.getElementInnerText(subItemValue).contains("-")) {
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItemTitle);
					String lsTitle = this.getElementInnerText(subItemTitle).toLowerCase();
					if (!lsTitle.contains("multipack shipping discount") && !lsTitle.contains("gift card")) {
						String lsValue=this.getElementInnerText(subItemValue);
						if (lsValue.contains("-")) {
							floatValue = -1*this.getFloatFromString(lsValue);
						}
						else{
							floatValue = this.getFloatFromString(lsValue);
						}
						map.put("promoteCodeValue", floatValue);
						break;
					}
				}
			}
		}
		else{
			map.put("promoteCodeValue",0.0f);
		}

		if(this.checkGiftCardExistingInOrderSummary()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblGiftCardRedeemValue);
			lsText=lblGiftCardRedeemValue.getText();
			if(lsText.contains("-")){
				map.put("giftCardValue",-1*this.getFloatFromString(lsText));
			}
			else{
				map.put("giftCardValue",this.getFloatFromString(lsText));
			}
		}
		else{
			map.put("giftCardValue",0.0f);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartPricingTotalPrice);
		lsText=this.lblCartPricingTotalPrice.getText();
		map.put("totalPrice",this.getFloatFromString(lsText,true));

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
	public void verifyOrderSummaryBusinessLogic(float subTotalShoppingCart,Map<String,Object> orderSummaryMap,Map<String,Object> provincialTaxRate){
		float nowPriceOrderSummary=(float) orderSummaryMap.get("nowPrice");

		float subTotal=(float) orderSummaryMap.get("subTotal");
		float donationValue=0.0f;
		if(this.checkJaysCareDonationExistingInOrderSummary()){
			donationValue=(float) orderSummaryMap.get("donationValue");
		}
		if(Math.abs(subTotal-subTotalShoppingCart-donationValue)<0.01){
			reporter.reportLogPass("The (subtotal price - donation value) in OrderSummary section is matching the subtotal price in shopping cart section");
		}
		else{
			reporter.reportLogFail("The (subtotal price - donation value):"+(subTotal-donationValue)+" in OrderSummary section is not matching the subtotal price:"+subTotalShoppingCart+" in shopping cart section");
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
		this.waitForShoppingCardPageLoadingCompleted();
	}

	/**
	 * To set Installment Setting
	 * @param - String - optionText - option text for dropdown menu options for select installment
	 */
	public void setInstallmentSetting(String optionText){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select = new Select(this.selectCartEasyPayInstallmentNumber);
		select.selectByVisibleText(optionText);
		this.waitForShoppingCardPageLoadingCompleted();
	}

	/**
	 * To set Installment Number By Random Index
	 * @return - int - the setting of installment number
	 */
	public int setInstallmentNumberByRandomIndex(){
		this.expandEasyPaymentSection();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select=new Select(this.selectCartEasyPayInstallmentNumber);

		List<WebElement> lstOptions=select.getOptions();
		int optionSize=lstOptions.size();
		if(optionSize==1){
			return 0;
		}

		if(optionSize==2){
			select.selectByIndex(1);
		}

		int randomNumber=getRandomNumber(1, optionSize);
		select.selectByIndex(randomNumber);
		try{
			this.waitForShoppingCardPageLoadingCompleted();
		}
		catch (Exception e){
			this.applyStaticWait(3*this.getStaticWaitForApplication());
		}

		return this.getIntegerFromString(select.getFirstSelectedOption().getText());
	}

	/**
	 * To get Installment Options
	 * @return - List<String>
	 */
	public List<String> getInstallmentOptions(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
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
		String lsText;
		map.put("installmentsNumber",this.getInstallmentNumberFromPaymentOptionText());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartEasyPayTodayPayment);
		lsText=this.lblCartEasyPayTodayPayment.getText();
		map.put("todayPayment",this.getFloatFromString(lsText));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartEasyPayLeftPayment);
		lsText=this.lblCartEasyPayLeftPayment.getText();
		map.put("leftPayment",this.getFloatFromString(lsText));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartEasyPayFutureMonthlyPayment);
		lsText=this.lblCartEasyPayFutureMonthlyPayment.getText();
		map.put("futureMonthlyPayment",this.getFloatFromString(lsText));

		return map;
	}

	/**
	 * To get Installment business logic
	 * @param - Map<String,Object> - orderSummaryMap
	 */
	public void verifyInstallmentBusinessLogic(Map<String,Object> orderSummaryMap){
		int totalInstallmentNumber = getInstallmentNumberFromPaymentOptionText();

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
	 */
	public void verifyShoppingCartContents(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTitle);
		lsText=lblCartTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The cart title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The cart title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartParaMessage);
		lsText=lblCartParaMessage.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The cart top message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The cart top message is not displaying correctly");
		}

		if(lstShoppingBagFulfilledTitle.size()>0){
			reporter.reportLogPass("The Shopping Bag Fulfilled Titles containing no less than 1 title");
		}
		else{
			reporter.reportLogFail("The Shopping Bag Fulfilled Titles do not contain any title");
		}

		WebElement element;
		int index=0;
		for(WebElement cartItem:lstCartItems) {
			reporter.reportLog("Verify cart item " + index);
			element = cartItem.findElement(byProductPicImage);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsText = element.getAttribute("src");
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The cart item pic src is not empty");
			} else {
				reporter.reportLogFailWithScreenshot("The cart item pic src is empty");
			}

			element = cartItem.findElement(byProductItemDesc);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsText = element.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The cart item product description is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The cart item product description is not displaying correctly");
			}

			element = cartItem.findElement(byProductNowPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsText = element.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The cart item product NowPrice is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The cart item product NowPrice is not displaying correctly");
			}

			if (this.checkIfIsFreeShippingItem(cartItem)) {
				element = cartItem.findElement(byProductFreeShipping);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText = element.getText();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The cart item product FreeShipping message is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The cart item product FreeShipping message is not displaying correctly");
				}
				continue;
			}

			if (this.checkProductStyleAndSizeSectionExisting(cartItem)) {
				element = cartItem.findElement(byProductStyleAndSize);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText = element.getText().trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The cart item product Size&Style is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The cart item product Size&Style is not displaying correctly");
				}
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(cartItem);
			if (checkProductBadgeExisting(cartItem)) {
				element = cartItem.findElement(byProductPicBadge);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				if (this.getReusableActionsInstance().isElementVisible(element)) {
					reporter.reportLogPass("The cart item badge is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The cart item badge is not displaying correctly");
				}
			}

			element = cartItem.findElement(byProductPicLink);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsText = element.getAttribute("href");
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The cart item pic link is not empty");
			} else {
				reporter.reportLogFailWithScreenshot("The cart item pic link is empty");
			}

			element = cartItem.findElement(byProductNumber);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsText = element.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The cart item product product number is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The cart item product number is not displaying correctly");
			}

			if (this.checkProductStockUrgentMessageExisting(cartItem)) {
				element = cartItem.findElement(byProductStockUrgentMessage);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText = element.getText().trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The cart item product product inventory is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The cart item product inventory is not displaying correctly");
				}
			}

			element = cartItem.findElement(byProductQuantityMinusButton);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			if (this.getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("The cart item product product quantity minus button is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The cart item product quantity minus button is not displaying correctly");
			}

			element = cartItem.findElement(byProductQuantityPlusButton);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			if (this.getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("The cart item product product quantity plus button is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The cart item product quantity plus button is not displaying correctly");
			}

			element = cartItem.findElement(byProductQuantityRemoveButton);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			if (this.getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("The cart item product product quantity remove button is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The cart item product quantity remove button is not displaying correctly");
			}

			element = cartItem.findElement(byProductQuantityDisplayText);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The cart item product product quantity is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The cart item product quantity is not displaying correctly");
			}

			element = cartItem.findElement(byProductFavButton);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			if (this.getReusableActionsInstance().isElementVisible(element)) {
				reporter.reportLogPass("The cart item product product Favorite Button is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The cart item product quantity Favorite Button is not displaying correctly");
			}

			if (this.checkProductWasPriceExisting(cartItem)) {
				element = cartItem.findElement(byProductWasPrice);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText = element.getText();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The cart item product WasPrice is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The cart item product WasPrice is not displaying correctly");
				}
			}

			if (this.checkProductFreeShippingMessageExisting(cartItem)) {
				element = cartItem.findElement(byProductFreeShipping);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText = element.getText().trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The cart item product FreeShipping message is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The cart item product FreeShipping message is not displaying correctly");
				}
			}

			if(checkProductEstimatedShippingDateExisting(cartItem)){
				element = cartItem.findElement(byProductEstimatedShippingDate);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText = element.getText().trim();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The cart item product estimated shipping date is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The cart item product estimated shipping date is not displaying correctly");
				}

				if(!this.checkProductShippingPriceSectionExpanded(cartItem)){
					this.clickElement(element);
					this.waitForCondition(Driver -> {
						return this.checkProductShippingPriceSectionExpanded(cartItem);
					}, 10000);
				}

				if(checkProductShippingPriceExisting(cartItem)){
					element = cartItem.findElement(byProductShippingPriceLabel);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					lsText = element.getText().trim();
					if (!lsText.isEmpty()) {
						reporter.reportLogPass("The cart item product price label is displaying correctly");
					} else {
						reporter.reportLogFailWithScreenshot("The cart item product price label is not displaying correctly");
					}

					element = cartItem.findElement(byProductShippingPrice);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					lsText = element.getText().trim();
					if (!lsText.isEmpty()) {
						reporter.reportLogPass("The cart item product price is displaying correctly");
					} else {
						reporter.reportLogFailWithScreenshot("The cart item product price is not displaying correctly");
					}
				}

				if(checkProductFreeShippingExistingInShippingPriceSection(cartItem)){
					element = cartItem.findElement(byProductFreeShippingUnderEstimatedShippingDate);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					lsText = element.getText().trim();
					if (!lsText.isEmpty()) {
						reporter.reportLogPass("The cart item product Free Shipping Under EstimatedShipping Date section is displaying correctly");
					} else {
						reporter.reportLogFailWithScreenshot("The cart item product Free Shipping Under EstimatedShipping Date section is not displaying correctly");
					}
				}
			}
		}
	}

	/**
	 * To verify OrderSummary Contents
	 */
	public void verifyOrderSummaryContents(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingOrderSummaryTitle);
		lsText=lblCartPricingOrderSummaryTitle.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The cart pricing title in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The cart pricing title in OrderSummary is not displaying correctly");
		}

		if(this.checkJaysCareDonationExistingInOrderSummary()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingJaysCareDonationTitle);
			lsText=lblCartPricingJaysCareDonationTitle.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The Jays Care Donation title in OrderSummary is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Jays Care Donation title in OrderSummary is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCartPricingJaysCareDonationRemoveButton);
			if(this.getReusableActionsInstance().isElementVisible(btnCartPricingJaysCareDonationRemoveButton)){
				reporter.reportLogPass("The Jays Care Donation remove button in OrderSummary is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Jays Care Donation remove button in OrderSummary is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingJaysCareDonation);
			lsText=lblCartPricingJaysCareDonation.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The Jays Care Donation value in OrderSummary is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Jays Care Donation value in OrderSummary is not displaying correctly");
			}
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartPricingShippingNowPrice);
		lsText=lblCartPricingShippingNowPrice.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The shipping Now price in OrderSummary is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The shipping Now price in OrderSummary is not displaying correctly");
		}

		if(this.checkPromoteCodeDiscountExistingInOrderSummary()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMultiPackShippingDiscountTitle);
			lsText = lblMultiPackShippingDiscountTitle.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The promote code Title in OrderSummary is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The promote code Title in OrderSummary is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblMultiPackShippingDiscount);
			lsText = lblMultiPackShippingDiscount.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The promote code value in OrderSummary is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The promote code value in OrderSummary is not displaying correctly");
			}
		}

		if(this.checkGiftCardExistingInOrderSummary()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblGiftCardRedeemTitle);
			lsText = lblGiftCardRedeemTitle.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The gift card title in OrderSummary is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The gift card title in OrderSummary is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblGiftCardRedeemValue);
			lsText = lblGiftCardRedeemValue.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The gift card value in OrderSummary is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The gift card value in OrderSummary is not displaying correctly");
			}
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
	}

	/**
	 * To verify Easy Payment Contents
	 */
	public void verifyEasyPaymentContents(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(ckbEasyPayCheckbox);
		if(this.getReusableActionsInstance().isElementVisible(ckbEasyPayCheckbox)){
			reporter.reportLogPass("The EasyPay checkbox is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The EasyPay checkbox is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelEasyPayCheckbox);
		lsText=labelEasyPayCheckbox.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The EasyPay checkbox label is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The EasyPay checkbox label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnEasyPayLink);
		lsText=btnEasyPayLink.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The EasyPay link button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The EasyPay link button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectCartEasyPayInstallmentNumber);
		if(this.getReusableActionsInstance().isElementVisible(selectCartEasyPayInstallmentNumber)){
			reporter.reportLogPass("The EasyPay installment options is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The EasyPay installment options is not displaying correctly");
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartEasyPayCommentsForShippingAndTax);
		lsText=lblCartEasyPayCommentsForShippingAndTax.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The EasyPayment comments is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The EasyPayment comments is not displaying correctly");
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
			if(this.getReusableActionsInstance().isElementVisible(imgRemoveDialogProductBadge)){
				reporter.reportLogPass("The product badge in Remove dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product badge in Remove dialog is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imgRemoveDialogProductImage);
		lsText=imgRemoveDialogProductImage.getAttribute("src");
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product image src in Remove dialog is not empty");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product image src in Remove dialog is empty");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkRemoveDialogProductImageLink);
		lsText=lnkRemoveDialogProductImageLink.getAttribute("href");
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product link in Remove dialog is not empty");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product link in Remove dialog is empty");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkRemoveDialogProductItemDesc);
		lsText=lnkRemoveDialogProductItemDesc.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product description in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product description in Remove dialog is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkRemoveDialogProductItemDesc);
		lsText=lnkRemoveDialogProductItemDesc.getAttribute("href");
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product description link in Remove dialog is not empty");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product description link in Remove dialog is empty");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductItemNumber);
		lsText=lblRemoveDialogProductItemNumber.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product item number in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product item number in Remove dialog is not displaying correctly");
		}

		if(checkRemoveDialogStyleAndSizeSectionExisting()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductStyleAndSize);
			lsText = lblRemoveDialogProductStyleAndSize.getText().trim();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The product item Size&Style in Remove dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product item Size&Style in Remove dialog is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductNowPrice);
		lsText=lblRemoveDialogProductNowPrice.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product item NowPrice in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product item NowPrice in Remove dialog is not displaying correctly");
		}

		if(this.checkRemoveDialogWasPriceExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductWasPrice);
			lsText=lblRemoveDialogProductWasPrice.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The product item WasPrice in Remove dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product item WasPrice in Remove dialog is not displaying correctly");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductQuantity);
		lsText=lblRemoveDialogProductQuantity.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The product item quantity in Remove dialog is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The product item quantity in Remove dialog is not displaying correctly");
		}

		if(this.checkRemoveDialogFreeShippingMessageExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRemoveDialogProductFreeShipping);
			lsText=lblRemoveDialogProductFreeShipping.getText().trim();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The product item Free Shipping message in Remove dialog is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product item Free Shipping message in Remove dialog is not displaying correctly");
			}
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
					if(cartResponse.getStatusCode()==200)
						cartGuidIdValue = cartResponse.jsonPath().get("CartGuid");
				}else {
					cartResponse = cartAPI.createNewCartOrAddItems(Arrays.asList(Integer.valueOf(cartData.get("edpNo").toString())), Integer.valueOf(cartData.get("itemToBeAdded").toString()), customerEDP, access_token, cartGuidIdValue);
				}
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
	public List<Map<String,Object>> verifyCartExistsForUser(int customerEDP, String accessToken,List<Map<String,String>> itemsToBeAdded,String noOfItemsToBeAdded,boolean bCheckExisting,int itemNoToBeAdded) throws IOException {
		CartAPI cartApi = new CartAPI();
		CartResponse accountCart = null;
		Response responseExisting=cartApi.getAccountCartContentWithCustomerEDP(String.valueOf(customerEDP), accessToken);
		if(responseExisting.statusCode()==200) {
			accountCart = JsonParser.getResponseObject(responseExisting.asString(), new TypeReference<CartResponse>() {});
		}
		else{
			return null;
		}

		//If there is cart present for user, returning the data in cart
		if(bCheckExisting&&accountCart.getProducts().size()>0){
			List<Map<String,Object>> data = new ArrayList<>();
			/**String cartGuidId = accountCart.getCartGuid();
			 Response response = cartApi.getCartContentWithCartGuid(cartGuidId,accessToken);
			 CartResponse cartResponse = JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
			 */
			List<CartResponse.ProductsClass> productsClassList = accountCart.getProducts();
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
				map.put("cartGuid",accountCart.getCartGuid());

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
			List<Map<String,Object>> data = new ProductAPI().getProductDetailsToBeAddedToCartForUser(itemsToBeAdded,noOfItemsToBeAdded,itemNoToBeAdded);
			System.out.println(data.toString());
			this.addItemsToCartForUser(data,customerEDP,accessToken,null);

			responseExisting=cartApi.getAccountCartContentWithCustomerEDP(String.valueOf(customerEDP), accessToken);
			if(responseExisting.statusCode()==200) {
				accountCart = JsonParser.getResponseObject(responseExisting.asString(), new TypeReference<CartResponse>() {});
			}
			else{
				return null;
			}

			data = new ArrayList<>();
			/**String cartGuidId = accountCart.getCartGuid();
			 Response response = cartApi.getCartContentWithCartGuid(cartGuidId,accessToken);
			 CartResponse cartResponse = JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
			 */
			List<CartResponse.ProductsClass> productsClassList = accountCart.getProducts();
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
				map.put("cartGuid",accountCart.getCartGuid());

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

		int shoppingItemListCount=this.getItemCountFromShoppingList((List<Map<String,Object>>)shoppingCartMap.get("shoppingList"));
		map.put("shoppingItemCount",shoppingItemListCount);

		int itemCountInOrderSummary=this.getShoppingItemAmountFromOrderSummarySection();
		map.put("itemCountInOrderSummary",itemCountInOrderSummary);

		int itemCountOnCheckoutButton=this.getShoppingItemAmountOnCheckoutButton();
		map.put("itemCountOnCheckoutButton",itemCountOnCheckoutButton);

		if(!bItemCountOnly){
			float subTotalShoppingCart=this.getSubTotalFromShoppingList((List<Map<String,Object>>)shoppingCartMap.get("shoppingList"));
			map.put("subTotalShoppingCart",subTotalShoppingCart);

			float subTotalShippingPriceShoppingCart=this.getShippingPriceTotalFromShoppingList((List<Map<String,Object>>)shoppingCartMap.get("shoppingList"));
			map.put("subTotalShippingPriceShoppingCart",subTotalShippingPriceShoppingCart);

			float subTotalOrderSummary=this.getOrderSummarySubTotal();
			map.put("subTotalOrderSummary",subTotalOrderSummary);

			float subTotalShippingPriceOrderSummary=this.getOrderSummaryShippingPrice();
			map.put("subTotalShippingPriceOrderSummary",subTotalShippingPriceOrderSummary);
		}

		return map;
	}

	/**
	 * To expand Jays Care Donation Section
	 */
	public void expandJaysCareDonationSection(){
		if(!this.checkJaysCareDonationExpanded()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnJaysCareDonationButton);
			btnJaysCareDonationButton.click();
			this.waitForCondition(Driver->{return this.checkJaysCareDonationExpanded();},10000);
		}
	}

	/**
	 * To set Random Jays Care Donation Item
	 * @return - float - donation value
	 */
	public float setRandomJaysCareDonationItem(){
		expandJaysCareDonationSection();

		int optionSize= lstJaysCareDonationCheckboxLabel.size();
		int randomNumber=getRandomNumber(0, optionSize);
		WebElement selectItem= lstJaysCareDonationCheckboxLabel.get(randomNumber);
		int donationValue=this.getIntegerFromString(this.getElementInnerText(selectItem));
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectItem);
		selectItem.click();
		this.waitForShoppingCardPageLoadingCompleted();
		this.applyStaticWait(this.getStaticWaitForApplication());

		return donationValue*1.0f;
	}

	/**
	 * To remove Jays Care Donation Item From OrderSummary
	 */
	public void removeJaysCareDonationItemFromOrderSummary(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCartPricingJaysCareDonationRemoveButton);
		this.btnCartPricingJaysCareDonationRemoveButton.click();
		this.waitForShoppingCardPageLoadingCompleted();
		this.applyStaticWait(this.getStaticWaitForApplication());
	}

	/**
	 * To get Selected Jays Care Donation Item Index
	 * @return - int
	 */
	public int getSelectedJaysCareDonationItemIndex(){
		int loopSize=this.lstJaysCareDonationCheckbox.size();
		for(int i=0;i<loopSize;i++){
			WebElement item=this.lstJaysCareDonationCheckbox.get(i);
			if(item.isSelected()){
				return i;
			}
		}
		return -1;
	}

	/**
	 * To verify Jays Care Donation section Contents
	 */
	public void verifyJaysCareDonationContents(){
		expandJaysCareDonationSection();

		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnJaysCareDonationButton);
		lsText=btnJaysCareDonationButton.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Jays Care Donation button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Jays Care Donation button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imgJaysCareDonation);
		lsText=imgJaysCareDonation.getAttribute("src");
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The image source of Jays Cars Donation logo is not empty");
		}
		else{
			reporter.reportLogFailWithScreenshot("The image source of Jays Cars Donation logo is empty");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconJaysCareDonationForExpansionStatus);
		if(this.getReusableActionsInstance().isElementVisible(iconJaysCareDonationForExpansionStatus)){
			reporter.reportLogPass("The Jays Care Donation icon is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Jays Care Donation icon is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblJaysCareDonationMessage);
		lsText=lblJaysCareDonationMessage.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Jays Care Donation message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Jays Care Donation message is not displaying correctly");
		}

		if(lstJaysCareDonationCheckbox.size()>0){
			reporter.reportLogPass("The Jays Care Donation checkbox list is containing no less than 1 item");
		}
		else{
			reporter.reportLogFail("The Jays Care Donation checkbox list does not contain any items");
		}

		if(lstJaysCareDonationCheckboxLabel.size()>0){
			reporter.reportLogPass("The Jays Care Donation checkbox label list is containing no less than 1 item");
		}
		else{
			reporter.reportLogFail("The Jays Care Donation checkbox label list does not contain any items");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblJaysCareDonationSubMessage);
		lsText=lblJaysCareDonationSubMessage.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The Jays Care Donation sub message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Jays Care Donation sub message is not displaying correctly");
		}
	}

	/**
	 * To verify Checkout Section Contents
	 */
	public void verifyCheckoutSectionContents(){
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnCartCheckoutButton);
		lsText=btnCartCheckoutButton.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The checkout button is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The checkout button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTipMessageForDiscountAndGiftCard);
		lsText=lblCartTipMessageForDiscountAndGiftCard.getText();
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The tip message for promote and gift card is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The tip message for promote and gift card is not displaying correctly");
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
		WebElement selectQuantity = shoppingItem.findElement(this.byProductQuantityDisplayText);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectQuantity);
		float price = this.getFloatFromString(this.getElementInnerText(shoppingItem.findElement(this.byProductNowPrice)));

		WebElement plusButton = shoppingItem.findElement(this.byProductQuantityPlusButton);
		plusButton.click();
		this.waitForShoppingCardPageLoadingCompleted();
		this.applyStaticWait(this.getStaticWaitForApplication());

		Map<String, Object> map = new HashMap<>();
		map.put("itemTotalDifference", price);
		map.put("itemQuantityDifference", 1);

		return map;
	}

	/**
	 * To choose Shopping Item By Given Item Index And Quantity
	 * @param - int - given shopping Item Index
	 * @param - int - given item quantity
	 */
	public void chooseShoppingItemByGivenItemIndexAndQuantity(int shoppingItemIndex,int quantity) {
		WebElement shoppingItem = this.lstCartItems.get(shoppingItemIndex);
		WebElement selectQuantity = shoppingItem.findElement(this.byProductQuantityDisplayText);
		int quantityBeforeChange=this.getIntegerFromString(this.getElementInnerText(selectQuantity));
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectQuantity);
		float price = this.getFloatFromString(this.getElementInnerText(shoppingItem.findElement(this.byProductNowPrice)));

		int loopClicking=quantity-quantityBeforeChange;
		if(loopClicking==0){
			return;
		}

		if(loopClicking>0){
			WebElement plusButton = shoppingItem.findElement(this.byProductQuantityPlusButton);
			for(int i=0;i<loopClicking;i++){
				plusButton.click();
				this.waitForShoppingCardPageLoadingCompleted();
				this.applyStaticWait(this.getStaticWaitForApplication());
			}
		}
		else{
			WebElement minusButton = shoppingItem.findElement(this.byProductQuantityMinusButton);
			loopClicking=-loopClicking;
			for(int i=0;i<loopClicking;i++){
				minusButton.click();
				this.waitForShoppingCardPageLoadingCompleted();
				this.applyStaticWait(this.getStaticWaitForApplication());
			}
		}
	}

	/**
	 * To get Maximum product Quantity By Given Shopping Cart Item Index
	 * @param - int - shoppingCartItemIndex
	 * @return - int
	 */
	public int getMaximumQuantityByGivenShoppingCartItemIndex(int shoppingCartItemIndex){
		WebElement item=this.lstCartItems.get(shoppingCartItemIndex);
		if(this.checkProductStockUrgentMessageExisting(item)){
			WebElement subItem=item.findElement(byProductStockUrgentMessage);
			return this.getIntegerFromString(this.getElementInnerText(subItem));
		}
		return 10;
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
								//this.addTSCCreditCardForUser((JSONObject) creditCardData.get("tsc"),customerEDP,accessToken);
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
	 * @param - Map<String,Object> - shopping cart map object
	 * @param - int - edp number for free gift item
	 */
	public void verifyFreeGiftItemPresentInCart(Map<String,Object> shoppingCartMap) throws IOException {
		boolean flag = false;
		//Fetching product edp number and name from product item number
		if(shoppingCartMap.size()>0){
			List<Map<String,Object>> shoppingCartItemList = (List<Map<String, Object>>) shoppingCartMap.get("shoppingList");
			for(Map<String,Object> map:shoppingCartItemList){
				if(map.get("productNumber")==null){
					continue;
				}

				if(!Boolean.valueOf(map.get("productQuantityDisabled").toString())){
					flag = true;
					ProductDetailsItem productDetailsItem = new ProductAPI().getProductDetailsForSpecificProductNumber(map.get("productNumber").toString());
					//Verifying free gift product name
					if(productDetailsItem.getName().equalsIgnoreCase(map.get("productName").toString()))
						reporter.reportLogPass("Product Name for free gift item is as expected: "+productDetailsItem.getName());
					else
						reporter.reportLogFailWithScreenshot("Product Name for free gift item is not as expected: "+productDetailsItem.getName());

					break;
				}
			}
			if(flag)
				reporter.reportLogPassWithScreenshot("Free Shipping item is added to cart as expected for user");
			else
				reporter.reportLogFailWithScreenshot("Free Shipping item is not added to cart as expected for user");
		}else
			reporter.reportLogFailWithScreenshot("No item is present in shopping cart!");
	}

	/**
	 * This function returns particular config key value provided by user
	 * @param - configurations - configuration List from contentful
	 * @param - keyName - keyName whose value is to be fetched
	 * @return - Object
	 */
	public Object getKeyValueFromContentfulConfiguration(List<Configuration> configurations, String keyName){
		for(Configuration configuration:configurations){
			if(configuration.getKey().equalsIgnoreCase(keyName)){
				return configuration.getValue();
			}
		}
		return null;
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
	 * @param - float - presetDonationValue
	 */
	public void verifyBlueJayDonationAdditionInCart(float presetDonationValue){
		if(this.checkJaysCareDonationExistingInOrderSummary()){
			reporter.reportLogPass("The Jays Care Donation item can be found in orderSummary section");
		}
		else{
			reporter.reportLogFail("The Jays Care Donation item cannot be found in orderSummary section");
		}

		float donationValue=this.getJaysCareDonationValueInOrderSummary();
		if(Math.abs(presetDonationValue-donationValue)<0.1f){
			reporter.reportLogPass("The Jays Care Donation value: "+donationValue+ " in orderSummary section is equal to the preset donation value: "+presetDonationValue);
		}
		else{
			reporter.reportLogFail("The Jays Care Donation value: "+donationValue+ " in orderSummary section is not equal to the preset donation value: "+presetDonationValue);
		}
	}

	/**
	 * To go To checkout page by clicking checkout button
	 */
	public void goToCheckoutPage(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnCartCheckoutButton);
		this.clickWebElementUsingJS(this.btnCartCheckoutButton);
		RegularCheckoutPage checkoutPage= new RegularCheckoutPage(this.getDriver());
		this.waitForCondition(Driver->{return checkoutPage.lblCheckout.isDisplayed();},30000);
	}

	/**
	 * This function adds TSC Credit Card to user
	 * @param - tscCardObject
	 * @param - customerEDP
	 * @param - accessToken
	 * @throws - IOException
	 */
	public void addTSCCreditCardForUser(JSONObject tscCardObject, String customerEDP,String accessToken) throws IOException {
		if (tscCardObject == null) {
			JSONObject creditCardData = new DataConverter().readJsonFileIntoJSONObject("test-data/CreditCard.json");
			tscCardObject = (JSONObject) creditCardData.get("tsc");
		}
		tscCardObject.put("IsDefault", true);
		tscCardObject.put("CVV", null);
		tscCardObject.remove("CardType");
		tscCardObject.remove("CardDisplayName");
		Response tscCardResponse = new AccountAPI().addCreditCardToUser(tscCardObject, customerEDP, accessToken);
		if (tscCardResponse.statusCode() == 200)
			reporter.reportLog("New TSC Credit Card is added for user as default Card");
		else
			reporter.reportLogFail("New TSC Credit Card is not added for user as default Card");
	}

	/**
	 * To expand EasyPayment Section
	 */
	public void expandEasyPaymentSection(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.labelEasyPayCheckbox);
		if(!this.ckbEasyPayCheckbox.isSelected()){
			this.labelEasyPayCheckbox.click();
			this.applyStaticWait(this.getStaticWaitForApplication());
		}
	}

	/**
	 * To get Payment Option text List
	 * @return - List<String>
	 */
	public List<String> getPaymentOptionTextList(){
		expandEasyPaymentSection();
		List<String> list=new ArrayList<>();

		Select select=new Select(this.selectCartEasyPayInstallmentNumber);
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
		expandEasyPaymentSection();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select=new Select(this.selectCartEasyPayInstallmentNumber);
		String lsPaymentOptionText=select.getFirstSelectedOption().getText();
		if(lsPaymentOptionText.contains("Number of Installments")){
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
		expandEasyPaymentSection();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select=new Select(this.selectCartEasyPayInstallmentNumber);
		String lsPaymentOptionText=select.getFirstSelectedOption().getText();
		if(lsPaymentOptionText.contains("Number of Installments")){
			return -1*0.0f;
		}
		else{
			String stringContainsFloat=this.getStringAfterGivenIdentifier(lsPaymentOptionText,"of");
			return this.getFloatFromString(stringContainsFloat);
		}
	}

	/**
	 * To set Payment Option By Given installment Number
	 * @param - int - installmentNumber - given installment Number
	 * @return - String - selected text
	 */
	public String setPaymentOptionByGivenInstallmentNumber(int installmentNumber){
		expandEasyPaymentSection();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select=new Select(this.selectCartEasyPayInstallmentNumber);
		String lsPaymentOption=select.getFirstSelectedOption().getText().trim();
		if(!lsPaymentOption.contains("Number of Installments")){
			String stringContainsInteger=this.getStringBeforeGivenIdentifier(lsPaymentOption,"of");
			if(this.getIntegerFromString(stringContainsInteger)==installmentNumber){
				return lsPaymentOption;
			}
		}

		List<String> lstPaymentOption=getPaymentOptionTextList();
		for(int i=0;i<lstPaymentOption.size();i++){
			lsPaymentOption=lstPaymentOption.get(i);
			if(!lsPaymentOption.contains("Number of Installments")){
				String stringContainsInteger=this.getStringBeforeGivenIdentifier(lsPaymentOption,"of");
				if(this.getIntegerFromString(stringContainsInteger)==installmentNumber){
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
					select=new Select(this.selectCartEasyPayInstallmentNumber);
					select.selectByIndex(i);
					try{
						this.waitForShoppingCardPageLoadingCompleted();
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
	 * To set PaymentOption By given text
	 * @param - String - lsPaymentOptionText
	 */
	public void setPaymentOptionByGivenText(String lsPaymentOptionText){
		expandEasyPaymentSection();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select=new Select(this.selectCartEasyPayInstallmentNumber);
		select.selectByVisibleText(lsPaymentOptionText);
		try{
			this.waitForShoppingCardPageLoadingCompleted();
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
		expandEasyPaymentSection();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select=new Select(this.selectCartEasyPayInstallmentNumber);
		select.selectByIndex(index);
		try{
			this.waitForShoppingCardPageLoadingCompleted();
		}
		catch (Exception e){
			this.applyStaticWait(3*this.getStaticWaitForApplication());
		}
	}

	/**
	 * To set PaymentOption By Random Index
	 */
	public int setPaymentOptionByRandomIndex(){
		expandEasyPaymentSection();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select=new Select(this.selectCartEasyPayInstallmentNumber);

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
			this.waitForShoppingCardPageLoadingCompleted();
		}
		catch (Exception e){
			this.applyStaticWait(3*this.getStaticWaitForApplication());
		}

		return this.getInstallmentNumberFromPaymentOptionText();
	}

	/**
	 * To get Installment Number
	 * @return - int
	 */
	public int getInstallmentNumber(){
		return this.getInstallmentNumberFromPaymentOptionText();
	}

	/**
	 * To verify Linkage Between Shopping Cart List And OrderSummary
	 * @param - Map<String,Object> - shoppingCartMap
	 */
	public void verifyLinkageBetweenShoppingCartListAndOrderSummary(Map<String,Object> shoppingCartMap){
		Map<String,Object> map=this.getItemCountAndPriceInfo(shoppingCartMap,false);
		int shoppingItemCount= (int) map.get("shoppingItemCount");
		int itemCountInOrderSummary= (int) map.get("itemCountInOrderSummary");
		int shoppingItemCountOnCheckoutButton= (int) map.get("itemCountOnCheckoutButton");
		float subTotalShoppingCart= (float) map.get("subTotalShoppingCart");
		float subTotalOrderSummary= (float) map.get("subTotalOrderSummary");
		float subTotalShippingPriceShoppingCart= (float) map.get("subTotalShippingPriceShoppingCart");
		float subTotalShippingPriceOrderSummary= (float) map.get("subTotalShippingPriceOrderSummary");

		float donationValue=0.0f;
		int donationCount=0;
		if(this.checkJaysCareDonationExistingInOrderSummary()){
			donationValue=this.getJaysCareDonationValueInOrderSummary();
			donationCount=1;
		}
		if((itemCountInOrderSummary-shoppingItemCount)==donationCount){
			reporter.reportLogPass("The item count in Shopping cart list plus donation count is equal to then one in OrderSummary");
		}
		else{
			reporter.reportLogFail("The item count:"+shoppingItemCount+" in Shopping cart list plus donation count:"+donationCount+" is not equal to then one:"+itemCountInOrderSummary+" in OrderSummary");
		}

		if(itemCountInOrderSummary==shoppingItemCountOnCheckoutButton){
			reporter.reportLogPass("The item count in orderSummary is equal to then one on checkout button");
		}
		else{
			reporter.reportLogFail("The item count:"+itemCountInOrderSummary+" in orderSummary is equal to then one:"+shoppingItemCountOnCheckoutButton+" on checkout button");
		}

		if(Math.abs(Math.abs(subTotalOrderSummary-subTotalShoppingCart)-donationValue)<0.1f){
			reporter.reportLogPass("The subTotal in orderSummary minus donation value is equal to the one in shopping cart list");
		}
		else{
			reporter.reportLogFail("The subTotal:"+subTotalOrderSummary+" in orderSummary minus donation value:"+donationValue+" is not equal to the one:"+subTotalShoppingCart+" in shopping cart list");
		}

		if(Math.abs(subTotalShippingPriceShoppingCart-subTotalShippingPriceOrderSummary)<0.1f){
			reporter.reportLogPass("The shipping price in orderSummary is equal to the one in shopping cart list");
		}
		else{
			reporter.reportLogFail("The shipping price:"+subTotalShippingPriceShoppingCart+" in orderSummary is not equal to the one:"+subTotalShippingPriceShoppingCart+" in shopping cart list");
		}
	}

	/**
	 * To highLighted Favorite Icon
	 */
	public void highLightedFavoriteIcon(){
		int firstNotFreeShippingItemIndex=this.getFirstNotFreeShippingCartItemInShoppingList();
		WebElement item=this.lstCartItems.get(firstNotFreeShippingItemIndex);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		WebElement subItem=item.findElement(byProductFavButton);
		if(!checkIfProductFavIconHighLighted(item)){
			this.clickElement(subItem);
			this.waitForCondition(Driver->{return checkIfProductFavIconHighLighted(item);},20000);
		}
	}

	/**
	 * To unhighLighted Favorite Icon
	 */
	public void unHighLightedFavoriteIcon(){
		int firstNotFreeShippingItemIndex=this.getFirstNotFreeShippingCartItemInShoppingList();
		WebElement item=this.lstCartItems.get(firstNotFreeShippingItemIndex);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		WebElement subItem=item.findElement(byProductFavButton);
		if(checkIfProductFavIconHighLighted(item)){
			this.clickElement(subItem);
			this.waitForCondition(Driver->{return !checkIfProductFavIconHighLighted(item);},20000);
		}
	}
}
