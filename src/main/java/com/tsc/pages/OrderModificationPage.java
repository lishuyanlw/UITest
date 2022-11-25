package com.tsc.pages;

import com.tsc.api.pojo.SelectedProduct;
import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.math.RoundingMode;
import java.sql.Driver;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderModificationPage extends BasePage {

	public OrderModificationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-title')]")
	public WebElement lblModifyOrderHeaderTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'orderModCartBox')]//strong[normalize-space(text())='ORDERED:']")
	public WebElement lblModifyOrderOrderedDateTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'orderModCartBox')]//strong[normalize-space(text())='ORDERED:']/parent::span/following-sibling::span")
	public WebElement lblModifyOrderOrderedDate;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'orderModCartBox')]//strong[normalize-space(text())='ORDER NUMBER:']")
	public WebElement lblModifyOrderOrderNumberTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'orderModCartBox')]//strong[normalize-space(text())='ORDER NUMBER:']/parent::span/following-sibling::span")
	public WebElement lblModifyOrderOrderNumber;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'orderModCartBox')]//strong[normalize-space(text())='ORDER Method:']")
	public WebElement lblModifyOrderOrderMethodTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'orderModCartBox')]//strong[normalize-space(text())='ORDER Method:']/parent::span/following-sibling::span")
	public WebElement lblModifyOrderOrderMethod;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'orderModCartBox')]//strong[normalize-space(text())='STATUS:']")
	public WebElement lblModifyOrderOrderStatusTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'orderModCartBox')]//strong[normalize-space(text())='STATUS:']/parent::span/following-sibling::span")
	public WebElement lblModifyOrderOrderStatus;

	//Changed for mobile device
	@FindBy(xpath = "//shopping-cart//button[normalize-space(text())='CANCEL MODIFICATION'][not(contains(@class,'cancelModButton'))]")
	public WebElement btnModifyOrderCancelModificationButton;

	//Not occurs for mobile device
	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[contains(@class,'cart__message--top--ordermod')]")
	public WebElement lblModifyOrderCartMessage;

	//For change mod options
	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']")
	public List<WebElement> lstModifyOrderChangeModOptions;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']//div[@id='headingOne']//a")
	public WebElement lblModifyOrderChangeModOptionsAddItemsHeadingTitle;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']//div[@id='collapseOne']//button")
	public WebElement btnModifyOrderChangeModOptionsAddItemsButton;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']//div[@id='headingTwo']//a")
	public WebElement lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']//div[@id='collapseTwo']//form//label")
	public WebElement lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeLabel;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']//div[@id='collapseTwo']//form//input")
	public WebElement inputModifyOrderChangeModOptionsAddOrUpdatePromoCode;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']//div[@id='collapseTwo']//form//div[contains(@class,'hidden-xs') and contains(@class,'promoBtnDiv')]//button[@type='submit']")
	public WebElement btnModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyButton;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']//div[@id='collapseTwo']//form//div[contains(@class,'hidden-xs') and contains(@class,'promoBtnDiv')]//div[@class='promoNoteDiv']")
	public WebElement lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyNoteMessage;

	@FindBy(xpath = "//shopping-cart//div[@class='promoMsg']/div[@class='table-cell'][not(*[@class='errorLogo'])]/b")
	public WebElement lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeAppliedPromoteCode;

	@FindBy(xpath = "//shopping-cart//div[@class='promoMsg']/div[@class='table-cell'][not(*[@class='errorLogo'])]")
	public WebElement lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeAppliedPromoteMessage;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']//div[@id='headingThree']//a")
	public WebElement lblModifyOrderChangeModOptionsOtherChangesHeadingTitle;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']//div[@id='collapseThree']")
	public WebElement lblModifyOrderChangeModOptionsOtherChanges;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//strong[contains(text(),'Your additional items will be combined')]")
	public WebElement lblModifyOrderCombinedMessage;

	//For newly added order items
	@FindBy(xpath = "//shopping-cart//*[normalize-space(text())='NEWLY ADDED ITEMS']")
	public WebElement lblModifyOrderNewlyAddedOrderHeaderTitle;

	@FindBy(xpath = "//shopping-cart//*[normalize-space(text())='NEWLY ADDED ITEMS']/parent::div[contains(@class,'page-header')]/following-sibling::div[@class='panel-items']/div[contains(@class,'cart-items')]")
	public List<WebElement> lstNewlyAddedOrderList;

	public By byProductQuantityForNewlyAdded=By.xpath(".//div[contains(@class,'hidden-xs')]//select");
	public By byProductRemoveButton=By.xpath(".//a[contains(@class,'cta-remove')]");
	public By byProductItemStatusContainer=By.xpath(".//div[@class='clearfix']/div[contains(@class,'cart-desc')]");
	//Note that it is a list for byProductItemStatus
	public By byProductItemStatus=By.xpath(".//div[contains(@class,'item-status')]");
	public By byProductItemStatusForFreeShipping=By.xpath(".//span[@class='boldBlackColor']");
	public By byProductItemStatusForLowInventory=By.xpath(".//span[@class='boldRedColor']");

	//Not display for mobile device
	public By byProductFreeShippingContainer=By.xpath(".//div[contains(@class,'cart-desc-line') and not(contains(@class,'visible-xs-block'))]//span[contains(@class,'now-price')]/ancestor::div[contains(@class,'col-sm-3')]");
	public By byProductFreeShipping=By.xpath(".//div[contains(@class,'hidden-xs')]//div[contains(@class,'item-status')]");
	//////The other sub xpath are same as Existing part////////

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-subtotal')]")
	public WebElement lblNewlyAddedSubTotal;

	//Hide in mobile
	@FindBy(xpath = "//shopping-cart//*[normalize-space(text())='NEWLY ADDED ITEMS']/parent::div[contains(@class,'page-header')]/following-sibling::div[@class='panel-items']/div[contains(@class,'col-headings')]//strong[normalize-space(text())='ITEM']")
	public WebElement lblCartTableHeadingITEMForNewlyAddedOrderList;

	//Hide in mobile
	@FindBy(xpath = "//shopping-cart//*[normalize-space(text())='NEWLY ADDED ITEMS']/parent::div[contains(@class,'page-header')]/following-sibling::div[@class='panel-items']/div[contains(@class,'col-headings')]//strong[normalize-space(text())='PRICE']")
	public WebElement lblCartTableHeadingPRICEForNewlyAddedOrderList;

	//Hide in mobile
	@FindBy(xpath = "//shopping-cart//*[normalize-space(text())='NEWLY ADDED ITEMS']/parent::div[contains(@class,'page-header')]/following-sibling::div[@class='panel-items']/div[contains(@class,'col-headings')]//strong[normalize-space(text())='QUANTITY']")
	public WebElement lblCartTableHeadingQUANTITYForNewlyAddedOrderList;

	//For existing order
	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//h3[contains(text(),'EXISTING ORDER')]")
	public WebElement lblModifyOrderExistingOrderHeaderTitle;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//p[contains(text(),'If you want to')]")
	public WebElement lblModifyOrderExistingOrderSubHeaderTitle;

	//Hide in mobile
	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//strong[contains(normalize-space(text()),'ITEM')]")
	public WebElement lblCartTableHeadingITEMForExistingOrderList;

	//Hide in mobile
	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//strong[contains(normalize-space(text()),'PRICE')]")
	public WebElement lblCartTableHeadingPRICEForExistingOrderList;

	//Hide in mobile
	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//strong[contains(normalize-space(text()),'QUANTITY')]")
	public WebElement lblCartTableHeadingQUANTITYForExistingOrderList;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[contains(@class,'existing-order')]//div[contains(@class,'cart-items')]")
	public List<WebElement> lstExistingOrderList;

	public By byProductImage=By.xpath(".//div[contains(@class,'product-pic')]//a//img");
	public By byProductImageLink=By.xpath(".//div[contains(@class,'product-pic')]//a");
	public By byProductDescription=By.xpath(".//div[contains(@class,'cart-desc')]//a");
	public By byProductNumberContainer=By.xpath(".//div[contains(@class,'cart-desc')]");
	public By byProductNumber=By.xpath(".//div[contains(@class,'item-num')]");
	public By byProductNowPrice=By.xpath(".//div[contains(@class,'cart-desc-line') and not(contains(@class,'visible-xs-block'))]//span[contains(@class,'now-price')]");
	public By byProductQuantity=By.xpath(".//div[contains(@class,'cart-desc-line') and not(contains(@class,'visible-xs-block'))]//span[contains(@class,'now-price')]/ancestor::div[contains(@class,'hidden-xs')]/following-sibling::div[contains(@class,'hidden-xs') and not(contains(@class,'col-halfspace'))]");

	//For Order Summary section
	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-pricing')]/div[@class='clearfix']")
	public List<WebElement> lstOrderSummaryItemList;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(@class,'cart-details-title')]")
	public WebElement lblOrderSummaryTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'Subtotal:')]")
	public WebElement lblOrderSummarySubTotalTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'Subtotal:')]/following-sibling::div[last()]")
	public WebElement lblOrderSummarySubTotal;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'Shipping:')]")
	public WebElement lblOrderSummaryShippingTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'Shipping:')]/following-sibling::div[del]")
	public WebElement lblOrderSummaryShippingWasPrice;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'Shipping:')]/following-sibling::div[last()]")
	public WebElement lblOrderSummaryShippingNowPrice;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'Est. Taxes')]")
	public WebElement lblOrderSummaryTaxTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'Est. Taxes')]/following-sibling::div[last()]")
	public WebElement lblOrderSummaryTax;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-pricing')]/div[@class='clearfix']//strong[normalize-space(text())='APPLIED DISCOUNTS']")
	public WebElement lblOrderSummaryAppliedDiscountTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-pricing')]/div[@class='clearfix']//div[normalize-space(text())='Discount:']")
	public WebElement lblOrderSummaryDiscountTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-pricing')]/div[@class='clearfix']//div[normalize-space(text())='Discount:']/following-sibling::div")
	public WebElement lblOrderSummaryDiscount;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'NEW TOTAL PRICE:')]")
	public WebElement lblOrderSummaryNewTotalPriceTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'NEW TOTAL PRICE:')]/following-sibling::div[last()]")
	public WebElement lblOrderSummaryNewTotalPrice;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'Original Order Total:')]")
	public WebElement lblOrderSummaryOriginalOrderTotalTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'Original Order Total:')]/following-sibling::div[last()]")
	public WebElement lblOrderSummaryOriginalOrderTotal;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'Change to order total:')]")
	public WebElement lblOrderSummaryChangeToOrderTotalTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'modOrderCartDetails')]//div[contains(text(),'Change to order total:')]/following-sibling::div[last()]")
	public WebElement lblOrderSummaryChangeToOrderTotal;

	//For Installment
	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-installment')]//span[contains(text(),'MONTHLY PAYMENTS WITH EASY PAY')]")
	public WebElement lblInstallmentTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-installment-more')]//div[contains(text(),'Number of Installments:')]")
	public WebElement lblInstallmentNumberTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-installment-more')]//div[contains(text(),'Number of Installments:')]/following-sibling::div[last()]")
	public WebElement lblInstallmentNumber;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-installment-more')]//div[contains(text(),'Your Total Payment Today:')]")
	public WebElement lblInstallmentTodayPaymentTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-installment-more')]//div[contains(text(),'Your Total Payment Today:')]/following-sibling::div[last()]")
	public WebElement lblInstallmentTodayPayment;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-installment-more')]//div[contains(text(),'Payment Amount Left After Today:')]")
	public WebElement lblInstallmentLeftPaymentTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-installment-more')]//div[contains(text(),'Payment Amount Left After Today:')]/following-sibling::div[last()]")
	public WebElement lblInstallmentLeftPayment;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-installment-more')]//div[contains(text(),'Future Monthly Payments:')]")
	public WebElement lblInstallmentFuturePaymentTitle;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'cart-installment-more')]//div[contains(text(),'Future Monthly Payments:')]/following-sibling::div[last()]")
	public WebElement lblInstallmentFuturePayment;

	@FindBy(xpath = "//shopping-cart//div[contains(@class,'checkout')]//button[normalize-space(text())='CHECKOUT']")
	public WebElement btnModifyOrderCheckoutButton;

	@FindBy(xpath = "//shopping-cart-privacy//div[@class='cart-privacy']")
	public WebElement lblModifyOrderShoppingPrivacy;

	@FindBy(xpath = "//shopping-cart-privacy//div[@class='cart-privacy']//a")
	public WebElement lnkModifyOrderShoppingPrivacy;

	//Add to Bag popup window part
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//button[@class='add-to-bag__button-close']")
	public WebElement btnAddToBagPopupWindowClose;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag-title']")
	public WebElement lblAddToBagPopupWindowTitle;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag-order-number']")
	public WebElement lblAddToBagPopupWindowOrderNumber;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']")
	public WebElement cntAddToBagPopupWindowDetailsLeftSectionImage;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']//div[@class='badgeWrap']//img")
	public WebElement imgAddToBagPopupWindowDetailsProductBadge;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']//a")
	public WebElement lnkAddToBagPopupWindowDetailsProductImage;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']//a//img")
	public WebElement imgAddToBagPopupWindowDetailsProductImage;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']")
	public WebElement lnkAddToBagPopupWindowDetailsProductInfo;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//a[@class='add-to-bag__item-link']")
	public WebElement cntAddToBagPopupWindowDetailsItemLink;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']//span[@class='add-to-bag__product-name']")
	public WebElement lblAddToBagPopupWindowDetailsProductName;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']//span[@class='add-to-bag__product-style']")
	public WebElement lblAddToBagPopupWindowDetailsProductStyle;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']//span[@class='add-to-bag__product-size']")
	public WebElement lblAddToBagPopupWindowDetailsProductSize;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//div[@class='add-to-bag__product-number']")
	public WebElement lblAddToBagPopupWindowDetailsProductNumber;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__button-wrap']//div[contains(@class,'add-to-bag__subtotal')]")
	public WebElement lblAddToBagPopupWindowButtonSectionSubtotal;

	@FindBy(xpath = "//div[@class='add-to-bag__button-wrap']//button[normalize-space(.)='Checkout']")
	public WebElement btnAddToBagPopupWindowButtonSectionCheckOut;

	@FindBy(xpath = "//div[@class='add-to-bag__button-wrap']//button[normalize-space(.)='Review Changes']")
	public WebElement btnAddToBagPopupWindowButtonSectionReviewChanges;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__footer']")
	public WebElement lblAddToBagPopupWindowFooterInfo;

	/**
	 * To get order number
	 * @return
	 */
	public String getOrderNumber(){
		return this.getElementInnerText(lblModifyOrderOrderNumber);
	}

	/**
	 * To check ChangeModOption Expanded status
	 * @param - WebElement - changeModOptionHeadingTitle
	 * @return - boolean - true for expanded status
	 */
	public boolean checkChangeModOptionExpanded(WebElement changeModOptionHeadingTitle){
		return changeModOptionHeadingTitle.getAttribute("aria-expanded").equalsIgnoreCase("true");
	}

	/**
	 * To add product items
	 * @param - String - lsProductName
	 * @param - boolean - bReviewChanges
	 * @return - Map<String,Object> - the data map for add to bag window
	 */
	public Map<String,Object> addProductItems(String lsProductName,boolean bReviewChanges){
		if(lblModifyOrderChangeModOptionsAddItemsHeadingTitle.getAttribute("aria-expanded").equalsIgnoreCase("false")){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsAddItemsHeadingTitle);
			lblModifyOrderChangeModOptionsAddItemsHeadingTitle.click();
			this.waitForCondition(Driver->{return lblModifyOrderChangeModOptionsAddItemsHeadingTitle.getAttribute("aria-expanded").equalsIgnoreCase("true");},10000);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderChangeModOptionsAddItemsButton);
		btnModifyOrderChangeModOptionsAddItemsButton.click();
		this.waitForCondition(Driver->{return (new GlobalHeaderPage(this.getDriver())).searchBox.isDisplayed();},120000);

		ProductResultsPage prp=new ProductResultsPage(this.getDriver());
		ProductDetailPage pdp=new ProductDetailPage(this.getDriver());
		if(lsProductName.matches("\\d+")){
			prp.getSearchResultLoad(lsProductName,true);
		}
		else{
			Map<String,String> prpMap=prp.navigateFromPRPToPDP(lsProductName, false);
		}

		this.clickElement(pdp.btnAddToBag);
		this.waitForCondition(Driver->{return this.lblAddToBagPopupWindowTitle.isDisplayed();},120000);

		Map<String,Object> addToBagMap=this.getAddToBagDesc();

		if(bReviewChanges){
			this.goToOrderModificationPageForReviewChangesFromAddToBagWindow();
			String lsText=this.getElementInnerText(btnModifyOrderChangeModOptionsAddItemsButton);
			if(lsText.equalsIgnoreCase("CONTINUE ADDING ITEM(S)")){
				reporter.reportLogPass("The AddItems button text changed to expected:'CONTINUE ADDING ITEM(S)'");
			}
			else{
				reporter.reportLogFail("The AddItems button text did not change to expected:'CONTINUE ADDING ITEM(S)'");
			}
		}
		else{
			this.goToCheckoutPageFromAddToBagWindow();
		}

		return addToBagMap;
	}

	/**
	 * To add Promote Code
	 * @param - String - lsPromoteCode
	 */
	public void addPromoteCode(String lsPromoteCode){
		if(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle.getAttribute("aria-expanded").equalsIgnoreCase("false")){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle);
			lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle.click();
			this.waitForCondition(Driver->{return lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle.getAttribute("aria-expanded").equalsIgnoreCase("true");},10000);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputModifyOrderChangeModOptionsAddOrUpdatePromoCode);
		inputModifyOrderChangeModOptionsAddOrUpdatePromoCode.sendKeys(lsPromoteCode);
		this.applyStaticWait(300);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyButton);
		btnModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyButton.click();
		this.waitForCondition(Driver->{return lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeAppliedPromoteMessage.isDisplayed();},120000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeAppliedPromoteCode);
		String lsText=lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeAppliedPromoteCode.getText().trim();
		if(lsText.equalsIgnoreCase(lsPromoteCode)){
			reporter.reportLogPass("The applied promote code:"+lsText+" is the same as inputting promote code:"+lsPromoteCode);
		}
		else{
			reporter.reportLogFail("The applied promote code:"+lsText+" is not the same as inputting promote code:"+lsPromoteCode);
		}
	}

	/**
	 * To check Product Number Existing
	 * @param - WebElement - orderItem
	 * @return - boolean
	 */
	public boolean checkProductNumberExisting(WebElement orderItem){
		WebElement item=orderItem.findElement(byProductNumberContainer);
		return this.checkChildElementExistingByAttribute(item,"class","item-num");
	}

	/**
	 * To check Product item status message Existing
	 * @param - WebElement - orderItem
	 * @return - boolean
	 */
	public boolean checkProductItemStatusExisting(WebElement orderItem){
		WebElement item=orderItem.findElement(byProductItemStatusContainer);
		return this.getChildElementCount(item)>5;
	}

	/**
	 * To check Product item status for free shipping message Existing
	 * @param - WebElement - orderItem
	 * @return - boolean
	 */
	public boolean checkProductItemStatusForFreeShippingExisting(WebElement orderItem){
		WebElement itemContainer=orderItem.findElement(byProductItemStatusContainer);
		List<WebElement> itemList=itemContainer.findElements(byProductItemStatus);
		if(itemList.size()==0){
			return false;
		}

		boolean bFind=false;
		for(WebElement item:itemList){
			if(this.checkChildElementExistingByAttribute(item,"class","boldBlackColor")){
				bFind=true;
				break;
			}
		}
		return bFind;
	}

	/**
	 * To check Product item status for low inventory message Existing
	 * @param - WebElement - orderItem
	 * @return - boolean
	 */
	public boolean checkProductItemStatusForLowInventoryExisting(WebElement orderItem){
		WebElement itemContainer=orderItem.findElement(byProductItemStatusContainer);
		List<WebElement> itemList=itemContainer.findElements(byProductItemStatus);
		boolean bFind=false;
		for(WebElement item:itemList){
			if(this.checkChildElementExistingByAttribute(item,"class","boldRedColor")){
				bFind=true;
				break;
			}
		}
		return bFind;
	}

	/**
	 * To check Product Free Shipping message Existing
	 * @param - WebElement - orderItem
	 * @return - boolean
	 */
	public boolean checkProductFreeShippingExisting(WebElement orderItem){
		WebElement item=orderItem.findElement(byProductFreeShippingContainer);
		return this.getChildElementCount(item)>1;
	}

	/**
	 * To check Applied Discount In OrderSummary Existing
	 * @return - boolean
	 */
	public boolean checkAppliedDiscountInOrderSummaryExisting(){
		return this.lstOrderSummaryItemList.size()>5;
	}

	/**
	 * To get Order item Description
	 * @param - WebElement - orderItem in lstOrderList
	 * @param - boolean - bNewlyAdded
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getOrderItemDesc(WebElement orderItem,boolean bNewlyAdded){
		Map<String,Object> map=new HashMap<>();
		WebElement item;
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(orderItem);
		item = orderItem.findElement(byProductDescription);
		lsText = this.getElementInnerText(item);
		map.put("productDescription", lsText);
		if(lsText.contains("|")){
			String[] lsSplit=lsText.split("\\|");
			if(lsSplit.length==2){
				if(lsSplit[1].contains("Size")){
					map.put("productName",lsSplit[0].trim());
					map.put("productStyle",null);
					map.put("productSize",lsSplit[1].trim().split(":")[1].trim());
				}
				else{
					map.put("productName",lsSplit[0].trim());
					map.put("productStyle",lsSplit[1].trim().split(":")[1].trim());
					map.put("productSize",null);
				}
			}
			else{
				map.put("productName",lsSplit[0].trim());
				map.put("productStyle",lsSplit[2].trim().split(":")[1].trim());
				map.put("productSize",lsSplit[1].split(":")[1].trim());
			}
		}
		else{
			map.put("productName",lsText);
			map.put("productStyle",null);
			map.put("productSize",null);
		}

		item = orderItem.findElement(byProductNowPrice);
		lsText = this.getElementInnerText(item);
		map.put("productNowPrice", this.getFloatFromString(lsText,true));

		if(this.checkProductNumberExisting(orderItem)){
			item = orderItem.findElement(byProductNumber);
			lsText = this.getElementInnerText(item).replace("-", "").trim();
			map.put("productNumber", lsText);
		}
		else{
			map.put("productNumber", null);
		}

		if(bNewlyAdded){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			item = orderItem.findElement(byProductQuantityForNewlyAdded);
			Select select=new Select(item);
			lsText = select.getFirstSelectedOption().getText();
		}
		else{
			item = orderItem.findElement(byProductQuantity);
			lsText = this.getElementInnerText(item);
		}
		map.put("productQuantity", this.getIntegerFromString(lsText));

		return map;
	}

	/**
	 * To get existing Order List Description
	 * @return - List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getExistingOrderListDesc(){
		List<Map<String,Object>> mapList= new ArrayList<>();
		for(WebElement orderItem:lstExistingOrderList) {
			mapList.add(getOrderItemDesc(orderItem,false));

		}
		return mapList;
	}

	/**
	 * To get newly added Order List Description
	 * @return - List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getNewlyAddedOrderListDesc(){
		List<Map<String,Object>> mapList= new ArrayList<>();
		for(WebElement orderItem:lstNewlyAddedOrderList) {
			mapList.add(getOrderItemDesc(orderItem,true));

		}
		return mapList;
	}

	/**
	 * To get Item Count And SubTotal For Newly Added Order List
	 * @return - Map<String,Object> - including itemCount and subTotal
	 */
	public Map<String,Object> getItemCountAndSubTotalForNewlyAddedOrderList(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblNewlyAddedSubTotal);
		String lsText=lblNewlyAddedSubTotal.getText();
		String[] lstSplit=lsText.split(":");

		Map<String,Object> map=new HashMap<>();
		map.put("itemCount",this.getIntegerFromString(lstSplit[0]));
		map.put("subTotal",this.getFloatFromString(lstSplit[1]));

		return map;
	}

	/**
	 * To get Checkout Item Count And SubTotal
	 * @param - List<Map<String,Object>> - productList - Checkout product list
	 * @return - Map<String,Object> - including itemCount and subTotal
	 */
	public Map<String,Object> getCalculatedCheckoutItemCountAndSubTotal(List<Map<String,Object>> productList){
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
	 * To get Tax Province Code
	 * @return - String
	 */
	public String getTaxProvinceCode(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryTaxTitle);
		String lsText=this.lblOrderSummaryTaxTitle.getText();
		return lsText.split(":")[1].trim();
	}

	/**
	 * To get OrderSummary Description
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getOrderSummaryDesc(){
		Map<String,Object> map=new HashMap<>();

		this.waitForCondition(Driver->{return lblOrderSummaryTitle.isDisplayed();},120000);
		this.applyStaticWait(2*this.getStaticWaitForApplication());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryTitle);
		String lsText=this.getElementInnerText(lblOrderSummaryTitle);
		map.put("itemCount",this.getIntegerFromString(lsText));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummarySubTotal);
		lsText=this.getElementInnerText(this.lblOrderSummarySubTotal);
		map.put("subTotal",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryShippingWasPrice);
		lsText=this.getElementInnerText(this.lblOrderSummaryShippingWasPrice);
		if(lsText.isEmpty()){
			map.put("wasPrice",0.0f);
		}
		else{
			map.put("wasPrice",this.getFloatFromString(lsText,true));
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryShippingNowPrice);
		lsText=this.getElementInnerText(this.lblOrderSummaryShippingNowPrice);
		if(lsText.toLowerCase().contains("free")){
			map.put("nowPrice",0.0f);
		}
		else{
			map.put("nowPrice",this.getFloatFromString(lsText));
		}

		map.put("province",getTaxProvinceCode());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryTax);
		lsText=this.getElementInnerText(this.lblOrderSummaryTax);
		map.put("tax",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryNewTotalPrice);
		lsText=this.getElementInnerText(this.lblOrderSummaryNewTotalPrice);
		map.put("newTotalPrice",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryOriginalOrderTotal);
		lsText=this.getElementInnerText(this.lblOrderSummaryOriginalOrderTotal);
		map.put("originalOrderTotal",this.getFloatFromString(lsText,true));

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryChangeToOrderTotal);
		lsText=this.getElementInnerText(this.lblOrderSummaryChangeToOrderTotal);
		if(lsText.contains("-")){
			map.put("changeToOrderTotal",-1.0f*this.getFloatFromString(lsText));
		}
		else{
			map.put("changeToOrderTotal",this.getFloatFromString(lsText));
		}

		map.put("promoteCodeValue",0.0f);
		map.put("giftCardValue",0.0f);
		if(this.checkAppliedDiscountInOrderSummaryExisting()){
			lsText=this.getElementInnerText(this.lblOrderSummaryDiscount);
			if(lsText.contains("-")){
				map.put("promoteCodeValue",-1.0f*this.getFloatFromString(lsText));
			}
			else{
				map.put("promoteCodeValue",this.getFloatFromString(lsText));
			}
		}

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
		int itemAmountOrderSummary= (int) orderSummaryMap.get("itemCount");
		if(itemAmountOrderSummary==itemAmountShoppingCart){
			reporter.reportLogPass("The item count in OrderSummary section is equal to the one for order list");
		}
		else{
			reporter.reportLogFail("The item count:"+itemAmountOrderSummary+" in OrderSummary section is not equal to the one:"+itemAmountShoppingCart+" for order list");
		}

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
		float totalPriceOrderSummary=(float) orderSummaryMap.get("newTotalPrice");
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
	 * To verify modify order header contents
	 */
	public void verifyModifyOrderHeaderContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderHeaderTitle);
		lsText = lblModifyOrderHeaderTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The modify order header Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The modify order header Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderOrderedDateTitle);
		lsText = lblModifyOrderOrderedDateTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The modify order date Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The modify order date Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderOrderedDate);
		lsText = lblModifyOrderOrderedDate.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The modify order date is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The modify order date is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderOrderNumberTitle);
		lsText = lblModifyOrderOrderNumberTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The modify order number title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The modify order number title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderOrderNumber);
		lsText = lblModifyOrderOrderNumber.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The modify order number is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The modify order number is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderOrderMethodTitle);
		lsText = lblModifyOrderOrderMethodTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The modify order method title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The modify order method title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderOrderMethod);
		lsText = lblModifyOrderOrderMethod.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The modify order method is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The modify order method is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderOrderStatusTitle);
		lsText = lblModifyOrderOrderStatusTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The modify order status title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The modify order status title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderOrderStatus);
		lsText = lblModifyOrderOrderStatus.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The modify order status is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The modify order status is not displaying correctly");
		}
	}

	/**
	 * To verify modify order Cancel Modification Button
	 */
	public void verifyModifyOrderCancelModificationButton() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderCancelModificationButton);
		lsText = btnModifyOrderCancelModificationButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The modify order Cancel Modification Button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The modify order Cancel Modification Button is not displaying correctly");
		}
	}

	/**
	 * To verify modify order Change Mode contents
	 */
	public void verifyModifyOrderChangeModeContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsAddItemsHeadingTitle);
		if(!this.checkChangeModOptionExpanded(lblModifyOrderChangeModOptionsAddItemsHeadingTitle)){
			reporter.reportLogPass("The Adding Items section is not expanded");
		}
		else{
			reporter.reportLogFail("The Adding Items section is expanded");
		}
		lblModifyOrderChangeModOptionsAddItemsHeadingTitle.click();
		this.waitForCondition(Driver->{return this.checkChangeModOptionExpanded(lblModifyOrderChangeModOptionsAddItemsHeadingTitle);},10000);
		lsText = lblModifyOrderChangeModOptionsAddItemsHeadingTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Adding Items Heading Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Adding Items Heading Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderChangeModOptionsAddItemsButton);
		lsText = btnModifyOrderChangeModOptionsAddItemsButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Adding Items button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Adding Items button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle);
		if(!this.checkChangeModOptionExpanded(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle)){
			reporter.reportLogPass("The Add Or Update PromoCode section is not expanded");
		}
		else{
			reporter.reportLogFail("The Add Or Update PromoCode section is expanded");
		}
		lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle.click();
		this.waitForCondition(Driver->{return this.checkChangeModOptionExpanded(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle);},10000);
		lsText = lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Add Or Update PromoCode Heading Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Add Or Update PromoCode Heading Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeLabel);
		lsText = lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeLabel.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Add Or Update PromoCode label is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Add Or Update PromoCode label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputModifyOrderChangeModOptionsAddOrUpdatePromoCode);
		if (this.getReusableActionsInstance().isElementVisible(inputModifyOrderChangeModOptionsAddOrUpdatePromoCode)) {
			reporter.reportLogPass("The input Add Or Update PromoCode is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The input Add Or Update PromoCode is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyButton);
		lsText = btnModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Add Or Update PromoCode apply button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Add Or Update PromoCode apply button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyNoteMessage);
		lsText = lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyNoteMessage.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Add Or Update PromoCode apply note message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Add Or Update PromoCode apply note message is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsOtherChangesHeadingTitle);
		lsText = lblModifyOrderChangeModOptionsOtherChangesHeadingTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Other Changes Heading Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Other Changes Heading Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsOtherChangesHeadingTitle);
		if(!this.checkChangeModOptionExpanded(lblModifyOrderChangeModOptionsOtherChangesHeadingTitle)){
			reporter.reportLogPass("The Other Changes section is not expanded");
		}
		else{
			reporter.reportLogFail("The Other Changes section is expanded");
		}

		lblModifyOrderChangeModOptionsOtherChangesHeadingTitle.click();
		this.waitForCondition(Driver->{return this.checkChangeModOptionExpanded(lblModifyOrderChangeModOptionsOtherChangesHeadingTitle);},10000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsOtherChanges);
		lsText = lblModifyOrderChangeModOptionsOtherChanges.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Other Changes is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Other Changes is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderCombinedMessage);
		lsText = lblModifyOrderCombinedMessage.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Combined Message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Combined Message is not displaying correctly");
		}
	}

	/**
	 * To verify newly added order header contents
	 */
	public void verifyNewlyAddedOrderHeaderContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderNewlyAddedOrderHeaderTitle);
		lsText = lblModifyOrderNewlyAddedOrderHeaderTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The header Title in Newly Added order section is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The header Title in Newly Added order section is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTableHeadingITEMForNewlyAddedOrderList);
		lsText = lblCartTableHeadingITEMForNewlyAddedOrderList.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The order table ITEM title in Newly Added order section is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The order table ITEM title in Newly Added order section is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTableHeadingPRICEForNewlyAddedOrderList);
		lsText = lblCartTableHeadingPRICEForNewlyAddedOrderList.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The order table PRICE title in Newly Added order section is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The order table PRICE title in Newly Added order section is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTableHeadingQUANTITYForNewlyAddedOrderList);
		lsText = lblCartTableHeadingQUANTITYForNewlyAddedOrderList.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The order table QUANTITY title in Newly Added order section is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The order table QUANTITY title in Newly Added order section is not displaying correctly");
		}
	}

	/**
	 * To verify existing order header contents
	 */
	public void verifyExistingOrderHeaderContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderExistingOrderHeaderTitle);
		lsText = lblModifyOrderExistingOrderHeaderTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The header Title in existing order section is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The header Title in existing order section is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderExistingOrderSubHeaderTitle);
		lsText = lblModifyOrderExistingOrderSubHeaderTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The subheader Title in existing order section is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The subheader Title in existing order section is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTableHeadingITEMForExistingOrderList);
		lsText = lblCartTableHeadingITEMForExistingOrderList.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The order table ITEM title in existing order section is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The order table ITEM title in existing order section is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTableHeadingPRICEForExistingOrderList);
		lsText = lblCartTableHeadingPRICEForExistingOrderList.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The order table PRICE title in existing order section is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The order table PRICE title in existing order section is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCartTableHeadingQUANTITYForExistingOrderList);
		lsText = lblCartTableHeadingQUANTITYForExistingOrderList.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The order table QUANTITY title in existing order section is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The order table QUANTITY title in existing order section is not displaying correctly");
		}
	}

	/**
	 * @param - boolean - bNewlyAdde
	 * To verify order List
	 */
	public void verifyOrderList(boolean bNewlyAdded) {
		String lsText;
		WebElement item;
		List<WebElement> lstOrderList;
		if(bNewlyAdded){
			lstOrderList=this.lstNewlyAddedOrderList;
		}
		else{
			lstOrderList=this.lstExistingOrderList;
		}

		for (WebElement productItem : lstOrderList) {
			item = productItem.findElement(byProductImage);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getAttribute("src");
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product image source is not empty");
			} else {
				reporter.reportLogFailWithScreenshot("The product image source is empty");
			}

			item = productItem.findElement(byProductImageLink);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getAttribute("href");
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product link is not empty");
			} else {
				reporter.reportLogFailWithScreenshot("The product link is empty");
			}

			item = productItem.findElement(byProductDescription);
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

			if(bNewlyAdded){
				if(checkProductFreeShippingExisting(productItem)){
					item = productItem.findElement(byProductFreeShipping);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
					if (this.getReusableActionsInstance().isElementVisible(item)) {
						reporter.reportLogPass("The product free shipping is displaying correctly");
					} else {
						reporter.reportLogFailWithScreenshot("The product free shipping is not displaying correctly");
					}
				}

				item = productItem.findElement(byProductQuantityForNewlyAdded);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if (this.getReusableActionsInstance().isElementVisible(item)) {
					reporter.reportLogPass("The product quantity is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product quantity is not displaying correctly");
				}

				if(checkProductItemStatusExisting(productItem)){
					if(checkProductItemStatusForFreeShippingExisting(productItem)){
						item = productItem.findElement(byProductItemStatusContainer).findElement(byProductItemStatusForFreeShipping);
						this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
						lsText = item.getText();
						if (!lsText.isEmpty()) {
							reporter.reportLogPass("The product free shipping for item status is displaying correctly");
						} else {
							reporter.reportLogFailWithScreenshot("The product free shipping for item status is not displaying correctly");
						}
					}

					if(checkProductItemStatusForLowInventoryExisting(productItem)){
						item = productItem.findElement(byProductItemStatusForLowInventory);
						this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
						lsText = item.getText();
						if (!lsText.isEmpty()) {
							reporter.reportLogPass("The product low inventory for item status is displaying correctly");
						} else {
							reporter.reportLogFailWithScreenshot("The product low inventory for item status is not displaying correctly");
						}
					}
				}

				item = productItem.findElement(byProductQuantityForNewlyAdded);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				if (this.getReusableActionsInstance().isElementVisible(item)) {
					reporter.reportLogPass("The product quantity dropdown menu is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product quantity dropdown menu is not displaying correctly");
				}

				if(!this.hasElementAttribute(item,"disabled")){
					item = productItem.findElement(byProductRemoveButton);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
					lsText = item.getText();
					if (!lsText.isEmpty()) {
						reporter.reportLogPass("The product remove button is displaying correctly");
					} else {
						reporter.reportLogFailWithScreenshot("The product remove button is not displaying correctly");
					}
				}
			}
			else{
				item = productItem.findElement(byProductQuantity);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText = item.getText();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The product quantity is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product quantity is not displaying correctly");
				}
			}
		}

		if(bNewlyAdded){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblNewlyAddedSubTotal);
			lsText=lblNewlyAddedSubTotal.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The subtotal for newly added items is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The subtotal for newly added items is not displaying correctly");
			}
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryShippingNowPrice);
		lsText = lblOrderSummaryShippingNowPrice.getText();
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
	 * To verify checkout Contents
	 * @param - boolean - bHasChanges
	 */
	public void verifyCheckoutContents(boolean bHasChanges) {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderCheckoutButton);
		lsText = btnModifyOrderCheckoutButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The checkout button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The checkout button is not displaying correctly");
		}

		boolean bDisabled=this.hasElementAttribute(btnModifyOrderCheckoutButton,"disabled");
		if(bHasChanges){
			if(!bDisabled){
				reporter.reportLogPass("Checkout button is enabled");
			}
			else{
				reporter.reportLogFail("Checkout button is disabled");
			}
		}
		else{
			if(bDisabled){
				reporter.reportLogPass("Checkout button is disabled");
			}
			else{
				reporter.reportLogFail("Checkout button is enabled");
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderShoppingPrivacy);
		if (this.getReusableActionsInstance().isElementVisible(lblModifyOrderShoppingPrivacy)) {
			reporter.reportLogPass("The shopping privacy message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The shopping privacy message is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkModifyOrderShoppingPrivacy);
		lsText = lnkModifyOrderShoppingPrivacy.getAttribute("href");
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The shopping privacy link is not empty");
		} else {
			reporter.reportLogFailWithScreenshot("The shopping privacy link is empty");
		}
	}

	public boolean checkProductBadgeInAddToBagPopupDisplaying() {
		return this.checkChildElementExistingByAttribute(this.cntAddToBagPopupWindowDetailsLeftSectionImage, "class", "badgeWrap");
	}

	public boolean checkProductStyleExistingInAddToBagPopup(){
		return this.checkChildElementExistingByAttribute(cntAddToBagPopupWindowDetailsItemLink,"class","add-to-bag__product-style");
	}

	public boolean checkProductSizeExistingInAddToBagPopup(){
		return this.checkChildElementExistingByAttribute(cntAddToBagPopupWindowDetailsItemLink,"class","add-to-bag__product-size");
	}

	public int getOrderAmountFromSubTotalInAddToBagModel(){
		String lsText=this.getElementInnerText(lblAddToBagPopupWindowButtonSectionSubtotal);
		lsText=lsText.split(":")[0];

		return this.getIntegerFromString(lsText);
	}

	public float getOrderSubTotalInAddToBagModel(){
		String lsText=this.getElementInnerText(lblAddToBagPopupWindowButtonSectionSubtotal);
		lsText=lsText.split(":")[1];

		return this.getFloatFromString(lsText);
	}

	/**
	 * To get AddToBag description
	 * @return - Map<String,Object> - including product name/style/size, item amount and subtotal
	 */
	public Map<String,Object> getAddToBagDesc(){
		Map<String,Object> map=new HashMap<>();
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddToBagPopupWindowTitle);
		lsText= String.valueOf(this.getIntegerFromString(this.getElementInnerText(lblAddToBagPopupWindowTitle)));
		map.put("productQuantity",lsText);

		if(this.checkProductBadgeInAddToBagPopupDisplaying()){
			map.put("productBadge",true);
		}
		else{
			map.put("productBadge",false);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowOrderNumber);
		lsText=this.lblAddToBagPopupWindowOrderNumber.getText();
		map.put("productOrderNumber",lsText.split("-")[1].trim());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddToBagPopupWindowDetailsProductName);
		lsText=lblAddToBagPopupWindowDetailsProductName.getText().trim();
		map.put("productName",lsText);

		if(checkProductStyleExistingInAddToBagPopup()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddToBagPopupWindowDetailsProductStyle);
			lsText=lblAddToBagPopupWindowDetailsProductStyle.getText().trim();
			map.put("productStyle",lsText);
		}
		else{
			map.put("productStyle",null);
		}

		if(checkProductSizeExistingInAddToBagPopup()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddToBagPopupWindowDetailsProductSize);
			lsText=lblAddToBagPopupWindowDetailsProductSize.getText();
			lsText=lsText.split(":")[1].trim();
			map.put("productSize",lsText);
		}
		else{
			map.put("productSize",null);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddToBagPopupWindowDetailsProductNumber);
		lsText=lblAddToBagPopupWindowDetailsProductNumber.getText().replace("-","").trim();
		map.put("productNumber",lsText);

		map.put("itemAmount",getOrderAmountFromSubTotalInAddToBagModel());

		map.put("SubTotal",getOrderSubTotalInAddToBagModel());

		return map;
	}

	/**
	 * Method to check if product style information in Add to Bag popup window is displaying
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductStyleInAddToBagPopupDisplaying() {
		return this.checkChildElementExistingByAttribute(this.lnkAddToBagPopupWindowDetailsProductInfo, "class", "add-to-bag__product-style");
	}

	/**
	 * Method to check if product size information in Add to Bag popup window is displaying
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductSizeInAddToBagPopupDisplaying() {
		return this.checkChildElementExistingByAttribute(this.lnkAddToBagPopupWindowDetailsProductInfo, "class", "add-to-bag__product-size");
	}

	/**
	 * Method to verify the product details in Add to Bag popup window
	 * @param-String lbl_AddToBagPopupWindowTitle: the expected title
	 */
	public void verifyProductDetailsInAddToBagPopupWindow(String lbl_AddToBagPopupWindowTitle, SelectedProduct productItem){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowTitle);
		reporter.softAssert(this.lblAddToBagPopupWindowTitle.getText().toUpperCase().matches(lbl_AddToBagPopupWindowTitle),"The title of Add to Bag popup window is matching to '"+lbl_AddToBagPopupWindowTitle+"' pattern","The title of Add to Bag popup window is not matching to '"+lbl_AddToBagPopupWindowTitle+"' pattern");

		if(checkProductBadgeInAddToBagPopupDisplaying()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.imgAddToBagPopupWindowDetailsProductBadge);
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgAddToBagPopupWindowDetailsProductBadge),"The Badge in Add to Bag popup window is visible","The Badge in Add to Bag popup window is not visible");
			reporter.softAssert(!this.imgAddToBagPopupWindowDetailsProductBadge.getAttribute("src").isEmpty(),"The Badge image src in Add to Bag popup window is not empty","The Badge image src in Add to Bag popup window is empty");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkAddToBagPopupWindowDetailsProductImage);
		reporter.softAssert(!this.lnkAddToBagPopupWindowDetailsProductImage.getAttribute("href").isEmpty(),"The product image link in Add to Bag popup window is not empty","The product image link in Add to Bag popup window is empty");
		reporter.softAssert(!this.imgAddToBagPopupWindowDetailsProductImage.getAttribute("src").isEmpty(),"The product image src in Add to Bag popup window is not empty","The product image src in Add to Bag popup window is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgAddToBagPopupWindowDetailsProductImage),"The product image in Add to Bag popup window is visible","The product image in Add to Bag popup window is not visible");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowDetailsProductName);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowDetailsProductName),"The product name in Add to Bag popup window is visible","The product name in Add to Bag popup window is not visible");
		reporter.softAssert(!this.lblAddToBagPopupWindowDetailsProductName.getText().isEmpty(),"The product name in Add to Bag popup window is not empty","The product name in Add to Bag popup window is empty");

		if(checkProductStyleInAddToBagPopupDisplaying()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowDetailsProductStyle);
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowDetailsProductStyle),"The product Style in Add to Bag popup window is visible","The product Style in Add to Bag popup window is not visible");
			reporter.softAssert(!this.lblAddToBagPopupWindowDetailsProductStyle.getText().isEmpty(),"The product Style in Add to Bag popup window is not empty","The product Style in Add to Bag popup window is empty");
		}

		if(checkProductSizeInAddToBagPopupDisplaying()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowDetailsProductSize);
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowDetailsProductSize),"The product Size in Add to Bag popup window is visible","The product Size in Add to Bag popup window is not visible");
			reporter.softAssert(!this.lblAddToBagPopupWindowDetailsProductSize.getText().isEmpty(),"The product Size in Add to Bag popup window is not empty","The product Size in Add to Bag popup window is empty");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowDetailsProductNumber);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowDetailsProductNumber),"The product Number in Add to Bag popup window is visible","The product Number in Add to Bag popup window is not visible");
		reporter.softAssert(!this.lblAddToBagPopupWindowDetailsProductNumber.getText().isEmpty(),"The product Number in Add to Bag popup window is not empty","The product Number in Add to Bag popup window is empty");

		subTotal();

		reporter.softAssert(this.lblAddToBagPopupWindowDetailsProductNumber.getText().trim().replace("-", "").equalsIgnoreCase(productItem.productNumber),"The product number of "+this.lblAddToBagPopupWindowDetailsProductNumber.getText().trim().replace("-", "")+" in Add to Bag popup window is equal to the original product number of "+productItem.productNumber+" from product search result page","The product number of "+this.lblAddToBagPopupWindowDetailsProductNumber.getText().trim().replace("-", "")+" in Add to Bag popup window is not equal to the original product number of "+productItem.productNumber+" from product search result page");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowButtonSectionCheckOut);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnAddToBagPopupWindowButtonSectionCheckOut),"The CheckOut button in Add to Bag popup window is visible","The CheckOut button in Add to Bag popup window is not visible");
		reporter.softAssert(!this.btnAddToBagPopupWindowButtonSectionCheckOut.getText().isEmpty(),"The CheckOut button in Add to Bag popup window is not empty","The CheckOut button in Add to Bag popup window is empty");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowButtonSectionReviewChanges);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnAddToBagPopupWindowButtonSectionReviewChanges),"The ReviewChanges button in Add to Bag popup window is visible","The ViewShoppingBag button in Add to Bag popup window is not visible");
		reporter.softAssert(!this.btnAddToBagPopupWindowButtonSectionReviewChanges.getText().isEmpty(),"The ReviewChanges button in Add to Bag popup window is not empty","The ViewShoppingBag button in Add to Bag popup window is empty");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowFooterInfo);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowFooterInfo),"The Footer info in Add to Bag popup window is visible","The Footer info in Add to Bag popup window is not visible");
		reporter.softAssert(!this.lblAddToBagPopupWindowFooterInfo.getText().isEmpty(),"The Footer info in Add to Bag popup window is not empty","The Footer info in Add to Bag popup window is empty");
	}

	//this method checks subtotal section
	public void subTotal(){
		reporter.softAssert(!this.getElementInnerText(this.lblAddToBagPopupWindowButtonSectionSubtotal).isEmpty(),"The product Subtotal in Add to Bag popup window is not empty","The product Subtotal in Add to Bag popup window is empty");
	}

	/**
	 * To goto CheckoutPage From AddToBag Window
	 * @return - boolean
	 */
	public boolean goToCheckoutPageFromAddToBagWindow(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddToBagPopupWindowButtonSectionCheckOut);
		btnAddToBagPopupWindowButtonSectionCheckOut.click();
		return this.waitForCondition(Driver->{return (new RegularCheckoutPage(this.getDriver())).btnCollapseProductList.isDisplayed();},120000);
	}

	/**
	 * To goTo OrderModificationPage For Reviewing Changes From AddToBag Window
	 * @return - boolean
	 */
	public boolean goToOrderModificationPageForReviewChangesFromAddToBagWindow(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnAddToBagPopupWindowButtonSectionReviewChanges);
		String lsText=this.getElementInnerText(btnAddToBagPopupWindowButtonSectionReviewChanges);
		if(lsText.equalsIgnoreCase("Review Changes")){
			reporter.reportLogPass("Review Changes button is displaying correctly");
		}
		else{
			reporter.reportLogFail("Review Changes button is not displaying correctly");
		}
		btnAddToBagPopupWindowButtonSectionReviewChanges.click();
		return this.waitForCondition(Driver->{return this.lblModifyOrderHeaderTitle.isDisplayed();},120000);
	}

	/**
	 * To verify Navigated Page After Clicking Cancel Modification Button
	 * @param - String - lsURL
	 */
	public void verifyNavigatedPageAfterClickingCancelModificationButton(String lsURL){
		String lsExpectedUrl=this.getBaseURL();
		lsExpectedUrl=lsExpectedUrl+lsURL;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderCancelModificationButton);
		btnModifyOrderCancelModificationButton.click();
		this.waitForCondition(Driver->{return (new MyAccount(this.getDriver())).inputAccountOrderSearch.isDisplayed();},120000);

		if(this.URL().equalsIgnoreCase(lsExpectedUrl)){
			reporter.reportLogPass("Navigated to order status page after clicking cancel modification button.");
		}
		else{
			reporter.reportLogFail("Failed to be navigated to order status page after clicking cancel modification button.");
		}
	}

	/**
	 * To go to Checkout page
	 */
	public void goToCheckoutPage(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderCheckoutButton);
		btnModifyOrderCheckoutButton.click();
		this.waitForCondition(Driver->{return (new RegularCheckoutPage(this.getDriver())).btnItemBeingAdded.isDisplayed();},120000);

		try{
			new RegularCheckoutPage(this.getDriver()).waitForPageLoadingSpinningStatusCompleted();
		}
		catch (Exception e){
			this.applyStaticWait(30*this.getStaticWaitForApplication());
		}
		this.applyStaticWait(30*this.getStaticWaitForApplication());
	}


	/**
	 * To verify Linkage Between AddToBag Item And Newly Added Order List
	 * @param - List<Map<String,Object>> - orderListMapForOrderModification
	 * @param - Map<String,Object> - addToBagItem
	 */
	public void verifyLinkageBetweenAddToBagItemAndNewlyAddedOrderList(List<Map<String,Object>> orderListMapForOrderModification,Map<String,Object> addToBagItem){
		ShoppingCartPage shoppingCartPage=new ShoppingCartPage(this.getDriver());
		String lsProductName= (String) addToBagItem.get("productName");
		int findIndex=shoppingCartPage.findGivenProductIndexInProductList(addToBagItem,orderListMapForOrderModification);
		if(findIndex!=-1){
			reporter.reportLogPass("The AddToBag product:'"+lsProductName+" ' can be found in newly added order list on orderModificationPage");
		}
		else{
			reporter.reportLogFail("The AddToBag product:'"+lsProductName+" ' cannot be found in newly added order list on orderModificationPage");
		}
	}

	/**
	 * To verify Item Count And SubTotal For NewlyAddedOrderList
	 * @param - Map<String,Object> - subTotalAndItemCountOnOrderModificationPage
	 * @param - Map<String,Object> - calculatedSubTotalAndItemCount
	 */
	public void verifyItemCountAndSubTotalForNewlyAddedOrderList(Map<String,Object> subTotalAndItemCountOnOrderModificationPage, Map<String,Object> calculatedSubTotalAndItemCount){
		int itemCountOnOrderModificationPage= (int) subTotalAndItemCountOnOrderModificationPage.get("itemCount");
		float subTotalOnOrderModificationPage= (float) subTotalAndItemCountOnOrderModificationPage.get("subTotal");

		int calculatedItemCount= (int) calculatedSubTotalAndItemCount.get("itemCount");
		float calculatedSubTotal= (float) calculatedSubTotalAndItemCount.get("subTotal");

		if(itemCountOnOrderModificationPage==calculatedItemCount){
			reporter.reportLogPass("The item count:"+itemCountOnOrderModificationPage+" in subtotal section is the same as calculated one:"+calculatedItemCount+" from newly added order list.");
		}
		else{
			reporter.reportLogFail("The item count:"+itemCountOnOrderModificationPage+" in subtotal section is not the same as calculated one:"+calculatedItemCount+" from newly added order list.");
		}

		if(Math.abs(subTotalOnOrderModificationPage-calculatedSubTotal)<0.1f){
			reporter.reportLogPass("The subtotal:"+subTotalOnOrderModificationPage+" in subtotal section is the same as calculated one:"+calculatedSubTotal+" from newly added order list.");
		}
		else{
			reporter.reportLogFail("The subtotal:"+subTotalOnOrderModificationPage+" in subtotal section is not the same as calculated one:"+calculatedSubTotal+" from newly added order list.");
		}
	}


}
