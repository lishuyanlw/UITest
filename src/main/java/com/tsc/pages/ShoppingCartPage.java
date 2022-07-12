package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-title')]")
	public WebElement lblCartTitle;

	//Hide in mobile
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart__message--top contents-head')]")
	public WebElement lblCartTopMessage;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-notices')]")
	public WebElement cntCartNotice;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-notices')]//div[@class='notice-title']")
	public WebElement lblCartNoticeTitle;

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-notices')]//div[@class='notice-group']")
	public WebElement lblCartNoticeMessage;

	@FindBy(xpath = "//div[@class='cartridge']//div[@id='tf-cart-wrapper']")
	public WebElement lblCartNoticeTrueFitMessage;

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
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'cart-pricing')]")
	public WebElement cntCartPricingSection;

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
	 * To check Product TrueFit Message Existing,
	 * 2 different size for same product will show TrueFit message
	 * @return - boolean
	 */
	public boolean checkProductTrueFitMessageExisting(){
		return this.checkChildElementExistingByAttribute(cntCartNotice,"id","tf-cart-wrapper");
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
	public void removeItemsAddedToShoppingCart(){
		GlobalHeaderPage globalHeaderPage = new GlobalHeaderPage(this.getDriver());
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeaderPage.CartBagCounter);
		this.getReusableActionsInstance().clickIfAvailable(globalHeaderPage.CartBagCounter);
		this.waitForPageToLoad();
		if(this.btnItemRemoveButtonFromCart.size()>0){
			/**for(WebElement removeButton: this.btnItemRemoveButtonFromCart){
				openRemoveDialog(removeButton);
				closeRemoveDialogWithRemoveAction();
			}*/
			for(int counter = 0;counter < this.btnItemRemoveButtonFromCart.size(); counter++){
				openRemoveDialog(this.btnItemRemoveButtonFromCart.get(counter));
				closeRemoveDialogWithRemoveAction();
			}
		}
		//Verify that all items are removed
		this.getReusableActionsInstance().staticWait(3000);
		reporter.softAssert(productDetailPage.getShoppingCartNumber()==0,"All Items are removed from shopping Cart","Items are still present in shopping Cart with no of items: "+productDetailPage.getShoppingCartNumber());
	}

	/**
	 * To get Shopping Item Description in shopping list
	 * @param - cartItem - item in lstCartItems
	 * @return - Map<String,Object> - Item detail description
	 */
	public Map<String,Object> getShoppingItemDesc(WebElement cartItem){
		Map<String,Object> map=new HashMap<>();

		if(this.checkProductBadgeExisting(cartItem)){
			map.put("productBadge",true);
		}
		else{
			map.put("productBadge",true);
		}

		WebElement item=cartItem.findElement(byProductItemDesc);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		String lsText=item.getText().trim();
		if(this.checkSelectQuantityEnabled(cartItem)){
			String[] lsSplit=lsText.split("\\|");
			map.put("productName",lsSplit[0].trim());
			map.put("productStyle",lsSplit[1].trim());
			map.put("productSize",lsSplit[2].split(":")[1].trim());
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

		if(!this.checkSelectQuantityEnabled(cartItem)){
			item=cartItem.findElement(byProductBlackMessage);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productFreeShipping",lsText);
		}
		else{
			map.put("productFreeShipping",null);
		}

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
	 * To get Shopping Item List Description
	 * @return - List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getShoppingItemListDesc(){
		List<Map<String,Object>> mapList=new ArrayList<>();

		for(WebElement cartItem:this.lstCartItems){
			mapList.add(this.getShoppingItemDesc(cartItem));
		}

		return mapList;
	}

	/**
	 * To get Shopping Section Details
	 * @return - Map<String,Object> - including shopping list,shopping amount, and shopping subtotal
	 */
	public Map<String,Object> getShoppingSectionDetails(){
		Map<String,Object> map=new HashMap<>();

		map.put("shoppingList",this.getShoppingItemListDesc());
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
		if(addToBagMap.get("productName").toString().equalsIgnoreCase(shoppingItemMap.get("productName").toString())&&
				addToBagMap.get("productStyle").toString().equalsIgnoreCase(shoppingItemMap.get("productStyle").toString())&&
				addToBagMap.get("productSize").toString().equalsIgnoreCase(shoppingItemMap.get("productSize").toString())){
			return true;
		}
		else{
			return false;
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

}
