package com.tsc.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsc.api.util.DataConverter;
import com.tsc.pages.base.BasePage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	////////////////For Shopping bag section////////////////////////////

	@FindBy(xpath = "//div[@class='cartridge']")
	public WebElement cntCart;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-contents')]")
	public WebElement cntCartContents;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-title')]")
	public WebElement lblCartTitle;

	//Hide in mobile
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart__message--top contents-head')]")
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

	public By byProductDescContainer=By.xpath(".//div[contains(@class,'cart-desc') and not(contains(@class,'cart-desc-line'))]");
	public By byProductItemDesc=By.xpath(".//div[contains(@class,'cart-desc') and not(contains(@class,'cart-desc-line'))]//div[@class='item-desc']");
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
	public List<WebElement> btnItemRemoveButtonFromCart;

	////////////////For Order summary section////////////////////////////

	//Pricing
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'details-box')]")
	public WebElement cntCartPricingDetails;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]")
	public WebElement cntCartPricingSection;

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

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//div[contains(normalize-space(text()),'5 Future Monthly Payments:')]")
	public WebElement lblCartEasyPayFutureMonthlyPaymentTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'easypay')]//div[contains(normalize-space(text()),'5 Future Monthly Payments:')]/following-sibling::div[last()]")
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

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'donationWrap')]//div[contains(@class,'donationRecieptMsg')]")
	public WebElement lblCartCheckoutDonationReceiptMessage;

	@FindBy(xpath = "//div[@class='cartridge']//button[contains(@class,'checkoutColorBtn')]")
	public WebElement btnCartCheckoutButton;

	@FindBy(xpath = "//div[@class='cartridge']//shopping-cart-privacy")
	public WebElement lblCartPrivacy;

	@FindBy(xpath = "//div[@class='cartridge']//shopping-cart-privacy//a[@id='btn-learn-more']")
	public WebElement lnkCartPrivacy;

	/**
	 * To get added item amount
	 */
	public int GetAddedItemAmount(){
		return this.getIntegerFromString(this.getElementInnerText(this.lblCartTitle));
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
		if(!this.cntCartNotice.getAttribute("class").contains("hidden")){
			return !this.getElementInnerText(this.lblCartNoticeTrueFitMessage).isEmpty();
		}
		else{
			return false;
		}
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
		return this.checkChildElementExistingByAttribute(item,"class","item-status");
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
	 * To check MultiPack Message In OrderSummary Section Existing
	 * @return - boolean
	 */
	public boolean checkMultiPackMessageInOrderSummarySectionExisting(){
		return this.checkChildElementExistingByAttribute(this.cntCartPricingDetails,"class","multipack");
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
	public boolean checkShippingSavingExisting(){
		return checkShippingWasPriceExisting();
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
	 * To get Shopping subtotal
	 * @return - float - shopping subtotal
	 */
	public float getShoppingSubTotal(){
		String lsText=this.getElementInnerText(lblCartTableSubTotal);
		lsText=lsText.split(":")[1];

		return this.getFloatFromString(lsText,true);
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
		if(this.btnItemRemoveButtonFromCart.size()>0){
			for(WebElement removeButton: this.btnItemRemoveButtonFromCart){
				openRemoveDialog(removeButton);
				closeRemoveDialogWithRemoveAction();
				this.waitForPageToLoad();
				//Applying static wait here after wait for page load function again
				//as sometimes page loads but DOM is still getting refreshed and hence Stale Element Exception is thrown
				this.applyStaticWait(3000);
			}
			/**for(int counter = 0;counter < this.btnItemRemoveButtonFromCart.size(); counter++){
				openRemoveDialog(this.btnItemRemoveButtonFromCart.get(counter));
				closeRemoveDialogWithRemoveAction();
			}*/
		}
		//Verify that all items are removed
		this.getReusableActionsInstance().staticWait(3000);
		reporter.softAssert(productDetailPage.getShoppingCartNumber()==0,"All Items are removed from shopping Cart","Items are still present in shopping Cart with no of items: "+productDetailPage.getShoppingCartNumber());
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

		item=cartItem.findElement(byProductNumber);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().replace("-","").trim();
		map.put("productNumber",lsText);

		item=cartItem.findElement(byProductNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().trim();
		map.put("productNowPrice",this.getFloatFromString(lsText,true));

		if(this.checkSelectQuantityEnabled(cartItem)){
			item=cartItem.findElement(byProductSelectQuantity);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			Select select = new Select(item);
			lsText=select.getFirstSelectedOption().getText();
			map.put("productQuantity",Integer.parseInt(lsText));
		}
		else{
			map.put("productQuantity",null);
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

		if(this.checkProductBadgeExisting(cartItem)){
			map.put("productBadge",true);
		}
		else{
			map.put("productBadge",true);
		}

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
			map.put("productName",lsText);
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

		String cartItemProductStyle= cartItemMap.get("productStyle").toString();
		String removeDialogProductStyle= removeDialogMap.get("productStyle").toString();
		if(cartItemProductStyle.equalsIgnoreCase(removeDialogProductStyle)){
			reporter.reportLogPass("The product style in cart item is the same as the one in remove dialog");
		}
		else{
			reporter.reportLogFail("The product style:"+cartItemProductStyle+" in cart item is not the same as the one:"+removeDialogProductStyle+" in remove dialog");
		}

		String cartItemProductSize= cartItemMap.get("productSize").toString();
		String removeDialogProductSize= removeDialogMap.get("productSize").toString();
		if(cartItemProductSize.equalsIgnoreCase(removeDialogProductSize)){
			reporter.reportLogPass("The product size in cart item is the same as the one in remove dialog");
		}
		else{
			reporter.reportLogFail("The product size:"+cartItemProductSize+" in cart item is not the same as the one:"+removeDialogProductSize+" in remove dialog");
		}

		String cartItemProductNumber= cartItemMap.get("productNumber").toString();
		String removeDialogProductNumber= removeDialogMap.get("productNumber").toString();
		if(cartItemProductNumber.equalsIgnoreCase(removeDialogProductNumber)){
			reporter.reportLogPass("The product number in cart item is the same as the one in remove dialog");
		}
		else{
			reporter.reportLogFail("The product number:"+cartItemProductSize+" in cart item is not the same as the one:"+removeDialogProductSize+" in remove dialog");
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

		String productStyleAddToBag= addToBagMap.get("productStyle").toString();
		String productStyleShoppingCart=cartItemMap.get("productStyle").toString();
		if(productStyleAddToBag.equalsIgnoreCase(productStyleShoppingCart)){
			reporter.reportLogPass("The Product style in AddToBag displaying is the same as shopping cart");
		}
		else{
			reporter.reportLogFail("The Product style in AddToBag:"+productStyleAddToBag+" displaying is not the same as shopping cart:"+productStyleShoppingCart);
		}

		String productSizeAddToBag= addToBagMap.get("productSize").toString();
		String productSizeShoppingCart=cartItemMap.get("productSize").toString();
		if(productSizeAddToBag.equalsIgnoreCase(productSizeShoppingCart)){
			reporter.reportLogPass("The Product size in AddToBag displaying is the same as shopping cart");
		}
		else{
			reporter.reportLogFail("The Product size in AddToBag:"+productSizeAddToBag+" displaying is not the same as shopping cart:"+productSizeShoppingCart);
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
	 * To verify business logic Between ShoppingItem List And SubTotalSection
	 * @param - Map<String,Object> - shoppingCartMap
	 */
	public void verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(Map<String,Object> shoppingCartMap){
		List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
		int shoppingAmount= (int) shoppingCartMap.get("shoppingCartMap");
		float shoppingSubTotal= (float) shoppingCartMap.get("shoppingSubTotal");

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
	 * To check Duplicated Style And Size In ShoppingItem List, note that the function is for TrueFit size
	 * @param - Map<String,Object> - shoppingCartMap
	 * @return - boolean
	 */
	public boolean checkDuplicatedStyleAndSizeInShoppingItemList(Map<String,Object> shoppingCartMap){
		List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
		String outerName,outerStyle,outerSize,innerName,innerStyle,innerSize;
		int amount;
		int loopSize=shoppingList.size();
		Map<String,Object> shoppingItemOuter,shoppingItemInner;

		for(int i=0; i<loopSize-1;i++){
			shoppingItemOuter=shoppingList.get(i);
			if(shoppingItemOuter.get("productStyle")==null&&shoppingItemOuter.get("productSize")==null){
				continue;
			}
			amount=0;
			outerName= shoppingItemOuter.get("productName").toString();
			outerStyle= shoppingItemOuter.get("productStyle").toString();
			outerSize= shoppingItemOuter.get("productSize").toString();
			for(int j=i+1;j<loopSize;j++){
				shoppingItemInner=shoppingList.get(j);
				if(shoppingItemInner.get("productStyle")==null&&shoppingItemInner.get("productSize")==null){
					continue;
				}
				innerName= shoppingItemInner.get("productName").toString();
				innerStyle= shoppingItemInner.get("productStyle").toString();
				innerSize= shoppingItemInner.get("productSize").toString();
				if(outerName.equalsIgnoreCase(innerName)&&outerStyle.equalsIgnoreCase(innerStyle)&&outerSize.equalsIgnoreCase(innerSize)){
					amount+=1;
				}
			}
			if(amount>1){
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
			map.put("wasPrice",0.0);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartPricingShippingNowPrice);
		lsText=this.lblCartPricingShippingNowPrice.getText().trim();
		if(!lsText.equalsIgnoreCase("Free")){
			map.put("nowPrice",this.getFloatFromString(lsText,true));
		}
		else{
			map.put("nowPrice",0.0);
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

		if(this.checkShippingSavingExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartPricingYouAreSaving);
			lsText=this.lblCartPricingYouAreSaving.getText();
			map.put("savePrice",this.getFloatFromString(lsText,true));
		}
		else{
			map.put("savePrice",0.0);
		}
		return map;
	}

	/**
	 * To get Province Tax Rate Map
	 * @return - Map<String,Float> - province as key and tax rate as value
	 * @throws IOException
	 */
	public Map<String,Float> getProvinceTaxRateMap() throws IOException {
		String fileName = ".//src//test//resources//test-data//ProvinceRate.json";
		JSONObject jsonObject = DataConverter.readJsonFileIntoJSONObject(fileName);
		ObjectMapper objectMapper=new ObjectMapper();
		Map<String,Float> map = objectMapper.readValue(jsonObject.toJSONString(),Map.class);

		return map;
	}

	/**
	 * To verify OrderSummary business Logic
	 * @param - itemAmountShoppingCart - int - Shopping item amount in shopping cart
	 * @param - savePriceShoppingCart - float - saving price in shopping cart, note that if pass 0.0, means no saving message
	 * @param - subTotalShoppingCart - float - subTotal in shopping cart
	 * @param - orderSummaryMap - Map<String,Object>
	 * @param - Map<String,Float> - provincialTaxRate
	 */
	public void verifyOrderSummaryBusinessLogic(int itemAmountShoppingCart,float savePriceShoppingCart,float subTotalShoppingCart,Map<String,Object> orderSummaryMap,Map<String,Float> provincialTaxRate){
		int itemAmountOrderSummary= (int) orderSummaryMap.get("orderSummary");
		if(itemAmountOrderSummary==itemAmountShoppingCart){
			reporter.reportLogPass("The item amount in OrderSummary section is equal to the one in Shopping Cart item section");
		}
		else{
			reporter.reportLogFail("The item amount:"+itemAmountOrderSummary+" in OrderSummary section is equal to the one:"+itemAmountShoppingCart+" in Shopping Cart item section");
		}

		float wasPriceOrderSummary= (float) orderSummaryMap.get("wasPrice");
		float nowPriceOrderSummary=(float) orderSummaryMap.get("nowPrice");
		float calSavePriceOrderSummary=Math.abs(wasPriceOrderSummary-nowPriceOrderSummary);
		if(Math.abs(calSavePriceOrderSummary-savePriceShoppingCart)<0.01){
			reporter.reportLogPass("The calculated saving price in OrderSummary section is equal to the one in Shopping Cart item section");
		}
		else{
			reporter.reportLogFail("The calculated saving price:"+calSavePriceOrderSummary+" in OrderSummary section is equal to the one:"+savePriceShoppingCart+" in Shopping Cart item section");
		}

		float savePriceOrderSummary=(float) orderSummaryMap.get("savePrice");
		if(Math.abs(calSavePriceOrderSummary-savePriceOrderSummary)<0.01){
			reporter.reportLogPass("The calculated saving price in OrderSummary section is equal to the saving price in OrderSummary section");
		}
		else{
			reporter.reportLogFail("The calculated saving price:"+calSavePriceOrderSummary+" in OrderSummary section is equal to the saving price:"+savePriceOrderSummary+" in OrderSummary section");
		}

		float subTotal=(float) orderSummaryMap.get("subTotal");
		if(Math.abs(subTotal-subTotalShoppingCart)<0.01){
			reporter.reportLogPass("The subtotal price in OrderSummary section is equal to the subtotal price in shopping cart section");
		}
		else{
			reporter.reportLogFail("The subtotal price:"+subTotal+" in OrderSummary section is equal to the subtotal price:"+subTotalShoppingCart+" in shopping cart section");
		}

		String province=orderSummaryMap.get("province").toString();
		float calProvinceTax=getProvinceTax(province,provincialTaxRate);
		float tax=(float) orderSummaryMap.get("tax");
		if(Math.abs(calProvinceTax-tax)<0.01){
			reporter.reportLogPass("The calculated tax in OrderSummary section is equal to the tax in OrderSummary section");
		}
		else{
			reporter.reportLogFail("The calculated tax:"+calProvinceTax+" in OrderSummary section is equal to the tax:"+tax+" in OrderSummary section");
		}

		float calTotalPrice=subTotal+tax+nowPriceOrderSummary;
		float totalPrice=(float) orderSummaryMap.get("totalPrice");
		if(Math.abs(calTotalPrice-totalPrice)<0.01){
			reporter.reportLogPass("The calculated total price in OrderSummary section is equal to the total price in OrderSummary section");
		}
		else{
			reporter.reportLogFail("The calculated total price:"+calTotalPrice+" in OrderSummary section is equal to the total price:"+totalPrice+" in OrderSummary section");
		}
	}

	/**
	 * To get provincial tax with given province
	 * @param - String - province
	 * @param - Map<String,Float> -provincialTaxRate
	 * @return - float province tax
	 */
	public float getProvinceTax(String province,Map<String,Float> provincialTaxRate){
		float calProvinceTax=0.0f;
		for(Map.Entry<String,Float> entry:provincialTaxRate.entrySet()){
			if(entry.getKey().equalsIgnoreCase(province)) {
				calProvinceTax = entry.getValue();
				break;
			}
		}
		return calProvinceTax;
	}

	/**
	 * To set Installment Setting
	 * @param -int - optionIndex - option index for dropdown menu options for select installment
	 */
	public void setInstallmentSetting(int optionIndex){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectCartEasyPayInstallmentNumber);
		Select select = new Select(this.selectCartEasyPayInstallmentNumber);
		if(optionIndex==0){
			select.selectByVisibleText("-");
		}
		else{
			select.selectByVisibleText(String.valueOf(optionIndex));
		}
		this.applyStaticWait(10*this.getStaticWaitForApplication());
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
			reporter.reportLogFail("Need choose correct installment option to verify it");
			return;
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
			reporter.reportLogPass("The calculated today payment is equal to the today payment in installment section");
		}
		else{
			reporter.reportLogFail("The calculated today payment:"+calTodayPayment+" is equal to the today payment:"+todayPayment+" in installment section");
		}

		float calLeftPayment=totalPriceOrderSummary-todayPayment;
		if(Math.abs(calLeftPayment-leftPayment)<0.1){
			reporter.reportLogPass("The calculated left payment is equal to the left payment in installment section");
		}
		else{
			reporter.reportLogFail("The calculated left payment:"+calLeftPayment+" is equal to the left payment:"+leftPayment+" in installment section");
		}

		int calFutureMonthlyPaymentNumber=totalInstallmentNumber-1;
		if(calFutureMonthlyPaymentNumber==futureMonthlyPaymentNumber){
			reporter.reportLogPass("The calculated future monthly payment number is equal to the future monthly payment number in installment section");
		}
		else{
			reporter.reportLogFail("The calculated future monthly payment number:"+calFutureMonthlyPaymentNumber+" is equal to the future monthly payment number:"+futureMonthlyPaymentNumber+" in installment section");
		}

		float calFutureMonthlyPayment=calLeftPayment/futureMonthlyPaymentNumber;
		if(Math.abs(calFutureMonthlyPayment-futureMonthlyPayment)<0.1){
			reporter.reportLogPass("The calculated future monthly payment is equal to the future monthly payment in installment section");
		}
		else{
			reporter.reportLogFail("The calculated future monthly payment:"+calFutureMonthlyPayment+" is equal to the future monthly payment:"+futureMonthlyPayment+" in installment section");
		}
	}

	/**
	 * To verify Shopping Cart Contents
	 * @param - boolean - bUnKnown - with unknown status
	 * @param - boolean - bTrueFit - known as TrueFit existing
	 * @param - boolean - bProductNameOnly - only show product name
	 */
	public void verifyShoppingCartContents(boolean bUnKnown,boolean bTrueFit,boolean bProductNameOnly){
		String lsText;

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

		if(bUnKnown){
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
		}
		else{
			if(bTrueFit){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartNoticeTrueFitMessage);
				lsText=lblCartNoticeTrueFitMessage.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The cart TrueFit message is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The cart TrueFit message is not displaying correctly");
				}

				lsText=lnkCartNoticeTrueFit.getAttribute("href");
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The cart TrueFit link is not empty");
				}
				else{
					reporter.reportLogFailWithScreenshot("The cart TrueFit link is empty");
				}
			}

			if(bProductNameOnly){
				if(!this.checkGetItByShippingMessageExisting()){
					reporter.reportLogPass("The cart GetByDate message is not displaying");
				}
				else{
					reporter.reportLogPass("The cart GetByDate message is displaying incorrectly");
				}
			}
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

			element=cartItem.findElement(byProductNumber);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			lsText=element.getText();
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The cart item product product number is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The cart item product number is not displaying correctly");
			}

			if(bUnKnown){
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
			}
			else{
				if(bProductNameOnly){
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

			if(this.checkRemoveButtonExisting(cartItem)){
				element=cartItem.findElement(byProductRemoveButton);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				lsText=element.getAttribute("href");
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The cart item remove button link is not empty");
				}
				else{
					reporter.reportLogFailWithScreenshot("The cart item remove button link is empty");
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

		if(checkShippingSavingExisting()){
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


}
