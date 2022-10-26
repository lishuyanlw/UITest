package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderConfirmationPage extends BasePage {

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	//For confirmation message
	@FindBy(xpath = "//order-confirmation//div[@class='svg-tick-container']")
	public WebElement iconOrderSuccess;

	@FindBy(xpath = "//order-confirmation//div[@class='order-cnf-title']")
	public WebElement lblOrderSuccessTitle;

	@FindBy(xpath = "//order-confirmation//div[@class='order-number']")
	public WebElement lblOrderNumber;

	@FindBy(xpath = "//order-confirmation//div[@class='order-cnf-msg-row']")
	public List<WebElement> lstOrderMessage;

	@FindBy(xpath = "//order-confirmation//button[normalize-space(.)='Go To Order Details']")
	public WebElement btnGoToOrderDetails;

	@FindBy(xpath = "//order-confirmation//button[normalize-space(.)='Go To My Account']")
	public WebElement btnGoToMyAccount;

	//For receipt
	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//div[contains(@class,'order-receipt-title')]")
	public WebElement lblReceiptHeaderTitle;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//span[contains(normalize-space(text()),'Date:')]")
	public WebElement lblReceiptDateTitle;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//span[contains(normalize-space(text()),'Date:')]/following-sibling::span")
	public WebElement lblReceiptDate;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//span[contains(normalize-space(text()),'Order number:')]")
	public WebElement lblReceiptOrderNumberTitle;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//span[contains(normalize-space(text()),'Order number:')]/following-sibling::span")
	public WebElement lblReceiptOrderNumber;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//span[contains(normalize-space(text()),'Customer Number:')]")
	public WebElement lblReceiptCustomerNumberTitle;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//span[contains(normalize-space(text()),'Customer Number:')]/following-sibling::span")
	public WebElement lblReceiptCustomerNumber;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//span[contains(normalize-space(text()),'Order Method:')]")
	public WebElement lblReceiptOrderMethodTitle;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//span[contains(normalize-space(text()),'Order Method:')]/following-sibling::span")
	public WebElement lblReceiptOrderMethod;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//div[contains(@class,'order-shipping-address-section')]//div[@class='order-shipping-address-title']")
	public WebElement lblReceiptOrderShippingAddressTitle;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//div[contains(@class,'order-shipping-address-section')]//div[not(@class='order-shipping-address-title')]")
	public List<WebElement> lstReceiptOrderShippingAddressDetails;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//div[contains(@class,'order-shipping-method-section')]//div[@class='order-shipping-method-title']")
	public WebElement lblReceiptOrderShippingMethodTitle;

	@FindBy(xpath = "//order-confirmation//div[@class='order-recpt-section']//div[contains(@class,'order-shipping-method-section')]//div[not(@class='order-shipping-method-title')]")
	public WebElement lblReceiptOrderShippingMethod;

	//For order confirmation cart
	@FindBy(xpath = "//order-confirmation-cart//div[@class='review-items-table']/parent::div")
	public WebElement cntReviewShoppingCartShippingDateContainer;

	@FindBy(xpath = "//order-confirmation-cart//div[contains(@class,'col-headings') and (contains(.,'Get it by:') or contains(.,'Ship Date:'))]")
	public WebElement lblReviewShoppingCartShippingDate;

	//Will not display on mobile device
	@FindBy(xpath = "//order-confirmation-cart//div[@class='review-items-table']//div[contains(@class,'review-table-header')]//div[@class='review-table-cell']")
	public List<WebElement> lstShoppingCartTableHeader;

	@FindBy(xpath = "//order-confirmation-cart//div[@class='review-items-table']//div[contains(@class,'review-table-row')]")
	public List<WebElement> lstOrderList;

	public By byProductBadgeContainer=By.xpath(".//div[@class='review-item-img']");
	public By byProductImage=By.xpath(".//div[@class='review-item-img']//a//img");
	public By byProductImageLink=By.xpath(".//div[@class='review-item-img']//a");
	public By byProductDescriptionLink=By.xpath(".//div[@class='review-item-desc']//*[@class='review-item-name']");
	public By byProductNumberContainer=By.xpath(".//div[@class='review-item-desc']");
	public By byProductNumber=By.xpath(".//div[@class='review-item-desc']//a/following-sibling::div[not(contains(@class,'estimateDate__lineItem--desktopWrapper'))]");
	public By byProductPriceContainer=By.xpath(".//div[@class='price-cell']");
	public By byProductNowPrice=By.xpath(".//div[@class='price-cell']//span[@class='applied-price']");
	public By byProductWasPrice=By.xpath(".//div[@class='price-cell']//del");
	public By byProductFreeShipping=By.xpath(".//div[@class='price-cell']//div[@class='itemwise-shipping']");
	public By byProductQuantity=By.xpath(".//div[contains(@class,'review-item-qty')]//span[not(@class='qty-lbl-mob')]");
	public By byProductShippingDate=By.xpath(".//div[contains(@class,'estimateDate')]");

	@FindBy(xpath = "//order-confirmation-cart//div[@class='billing-address-blk']//div[@class='billing-address-title']")
	public WebElement lblBillingAddressTitle;

	@FindBy(xpath = "//order-confirmation-cart//div[@class='billing-address-blk']//div[@class='billing-address-title']/following-sibling::*")
	public List<WebElement> lstBillingAddressDetails;

	//For payment section
	@FindBy(xpath = "//order-confirmation-cart//div[contains(@class,'payment-info-section')]")
	public WebElement cntPaymentCardContainer;

	@FindBy(xpath = "//order-confirmation-cart//div[@class='payment-card-blk']//div[@class='payment-card-title']")
	public WebElement lblPaymentCardTitle;

	@FindBy(xpath = "//order-confirmation-cart//div[@class='payment-card-blk']//span[@class='orderSummaryCCLogo']")
	public WebElement iconPaymentCardLogo;

	@FindBy(xpath = "//order-confirmation-cart//div[@class='payment-card-blk']/div[not(@class='payment-card-title')]")
	public WebElement lblPaymentCard;

	@FindBy(xpath = "//order-confirmation-cart//div[contains(@class,'payment-info-section')]//div[@class='gift-card-blk']//div[@class='gift-card-title']")
	public WebElement lblGiftCardTitle;

	@FindBy(xpath = "//order-confirmation-cart//div[contains(@class,'payment-info-section')]//div[@class='gift-card-blk']//div[not(@class='gift-card-title')][1]")
	public WebElement lblGiftCardNumber;

	@FindBy(xpath = "//order-confirmation-cart//div[contains(@class,'payment-info-section')]//div[@class='gift-card-blk']//div[not(@class='gift-card-title')][2]")
	public WebElement lblGiftCardSavingMessage;

	@FindBy(xpath = "//order-confirmation-cart//div[contains(@class,'payment-info-section')]//div[@class='promo-card-blk']//div[@class='promo-card-title']")
	public WebElement lblPromoteCodeTitle;

	@FindBy(xpath = "//order-confirmation-cart//div[contains(@class,'payment-info-section')]//div[@class='promo-card-blk']//div[@class='gift-tick']")
	public WebElement iconPromoteCodeTick;

	@FindBy(xpath = "//order-confirmation-cart//div[contains(@class,'payment-info-section')]//div[@class='promo-card-blk']//strong")
	public WebElement lblPromoteCode;

	//For order summary
	@FindBy(xpath = "//div[@class='order-conf-summary-section']")
	public WebElement cntOrderSummaryContainer;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[@class='order-conf-summary-title']")
	public WebElement lblOrderSummaryTitle;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(@class,'order-conf-summary-row')]")
	public List<WebElement> lstOrderSummaryItems;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Subtotal:')]")
	public WebElement lblOrderSummarySubTotalTitle;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Subtotal:')]/following-sibling::div[@class='order-conf-summary-val']")
	public WebElement lblOrderSummarySubTotal;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Shipping & Handling:')]")
	public WebElement lblOrderSummaryShippingAndHandlingTitle;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Shipping & Handling:')]/following-sibling::div[@class='order-conf-summary-val-prev']//del")
	public WebElement lblOrderSummaryShippingAndHandlingWasPrice;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Shipping & Handling:')]/following-sibling::div[@class='order-conf-summary-val']")
	public WebElement lblOrderSummaryShippingAndHandlingNowPrice;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Taxes:')]")
	public WebElement lblOrderSummaryTaxTitle;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Taxes:')]/following-sibling::div[@class='order-conf-summary-tax-state']")
	public WebElement lblOrderSummaryTaxProvince;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Taxes:')]/following-sibling::div[@class='order-conf-summary-val']")
	public WebElement lblOrderSummaryTax;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Discount:')]")
	public WebElement lblOrderSummaryAppliedDiscountTitle;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Discount:')]/following-sibling::div[@class='order-conf-summary-val']")
	public WebElement lblOrderSummaryAppliedDiscount;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Total Price:')]")
	public WebElement lblOrderSummaryTotalPriceTitle;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[contains(normalize-space(text()),'Total Price:')]/following-sibling::div[@class='order-conf-summary-val']")
	public WebElement lblOrderSummaryTotalPrice;

	//For Installment
	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[@class='easy-pay-section']//div[@class='easy-pay-title']")
	public WebElement lblInstallmentTitle;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[@class='easy-pay-section']//div[contains(text(),'Number of Installments:')]")
	public WebElement lblInstallmentNumberTitle;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[@class='easy-pay-section']//div[contains(text(),'Number of Installments:')]/following-sibling::div[last()]")
	public WebElement lblInstallmentNumber;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[@class='easy-pay-section']//div[contains(text(),'Your Total Payment Today:')]")
	public WebElement lblInstallmentTodayPaymentTitle;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[@class='easy-pay-section']//div[contains(text(),'Your Total Payment Today:')]/following-sibling::div[last()]")
	public WebElement lblInstallmentTodayPayment;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[@class='easy-pay-section']//div[contains(text(),'Payment Amount Left After Today:')]")
	public WebElement lblInstallmentLeftPaymentTitle;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[@class='easy-pay-section']//div[contains(text(),'Payment Amount Left After Today:')]/following-sibling::div[last()]")
	public WebElement lblInstallmentLeftPayment;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[@class='easy-pay-section']//div[contains(text(),'Future Monthly Payments')]")
	public WebElement lblInstallmentFuturePaymentTitle;

	@FindBy(xpath = "//div[@class='order-conf-summary-section']//div[@class='easy-pay-section']//div[contains(text(),'Future Monthly Payments')]/following-sibling::div[last()]")
	public WebElement lblInstallmentFuturePayment;

	//For common questions
	@FindBy(xpath = "//div[@class='faq-section']//div[@class='faq-title']")
	public WebElement lblCommonQuestionsTitle;

	@FindBy(xpath = "//div[@class='faq-section']//div[contains(@class,'faq-blk')]//a")
	public List<WebElement> lstCommonQuestionsList;

	@FindBy(xpath = "//div[@class='faq-section']//div[contains(@class,'faq-blk')]//a[contains(@href,'ordertracking')]")
	public WebElement lnkCommonQuestionsOrderTracking;

	@FindBy(xpath = "//div[@class='faq-section']//div[contains(@class,'faq-blk')]//a[contains(@href,'ordermodification')]")
	public WebElement lnkCommonQuestionsOrderModification;

	@FindBy(xpath = "//div[@class='faq-section']//div[contains(@class,'faq-blk')]//a[contains(@href,'returnspage')]")
	public WebElement lnkCommonQuestionsReturnsPage;

	@FindBy(xpath = "//ng-component//div[@class='loading']/div")
	public WebElement lblLoadingPageStatus;


	/**
	 * To get order number
	 * @return - String - order number
	 */
	public String getOrderNumber(){
		String lsText=this.getElementInnerText(lblOrderNumber);
		return lsText.split(":")[1].trim();
	}

	/**
	 * To check Product Shipping Date Existing
	 * @return - boolean
	 */
	public boolean checkProductShippingDateExisting(){
		return this.checkChildElementExistingByAttribute(this.cntReviewShoppingCartShippingDateContainer,"class","estimateDate");
	}

	/**
	 * To check Product Badge Existing
	 * @param - WebElement - productItem - the item in product list
	 * @return - boolean
	 */
	public boolean checkProductBadgeExisting(WebElement productItem){
		WebElement badgeItem=productItem.findElement(this.byProductBadgeContainer);
		return this.checkChildElementExistingByAttribute(badgeItem,"class","badgeWrap");
	}

	/**
	 * To check Free Shipping existing in order list
	 * @param - WebElement - orderItem - item in lstOrderList
	 * @return - boolean
	 */
	public boolean checkFreeShippingExistingInOrderList(WebElement orderItem){
		WebElement itemContainer=orderItem.findElement(byProductPriceContainer);
		return this.checkChildElementExistingByAttribute(itemContainer,"class","itemwise-shipping");
	}

	/**
	 * To check wasPrice existing in order list
	 * @param - WebElement - orderItem - item in lstOrderList
	 * @return - boolean
	 */
	public boolean checkWasPriceExistingInOrderList(WebElement orderItem){
		WebElement item=orderItem.findElement(byProductWasPrice);
		return !this.getElementInnerText(item).isEmpty();
	}

	/**
	 * To check wasPrice existing in orderSummary
	 * @return - boolean
	 */
	public boolean checkWasPriceExistingInOrderSummary(){
		return !this.getElementInnerText(lblOrderSummaryShippingAndHandlingWasPrice).isEmpty();
	}

	/**
	 * To check Gift Card Existing In Payment Section
	 * @return
	 */
	public boolean checkGiftCardExistingInPaymentSection(){
		return this.checkChildElementExistingByAttribute(cntPaymentCardContainer,"class","gift-card-blk");
	}

	/**
	 * To check promote code Existing In Payment Section
	 * @return
	 */
	public boolean checkPromoteCodeExistingInPaymentSection(){
		return this.checkChildElementExistingByAttribute(cntPaymentCardContainer,"class","promo-card-blk");
	}

	/**
	 * To check applied discount Existing In Payment Section
	 * @return
	 */
	public boolean checkAppliedDiscountExistingInOrderSummarySection(){
		return this.getChildElementCount(cntOrderSummaryContainer)>=6;
	}

	/**
	 * To go to OrderDetails Page
	 * @param - String - lsURLFromYamlFile
	 * @param - String - lsOrderNumber
	 * @return - boolean
	 */
	public boolean goToOrderDetailsPage(String lsURLFromYamlFile,String lsOrderNumber){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnGoToOrderDetails);
		this.btnGoToOrderDetails.click();

		String lsBaseURL=this.getBaseURL();
		String lsExpectedURL=lsBaseURL+lsURLFromYamlFile+lsOrderNumber;
		String lsCurrentURL=this.URL();
		this.waitForCondition(Driver->{return lsCurrentURL.equalsIgnoreCase(lsExpectedURL);},20000);
		if(lsCurrentURL.equalsIgnoreCase(lsExpectedURL)){
			reporter.reportLogPass("Navigate to order details page successfully and url is: "+lsExpectedURL);
		}
		else{
			reporter.reportLogFail("Fail to navigate to order details page with actual url: "+lsCurrentURL+" but expected url is: "+lsExpectedURL);
		}

		MyAccount myAccount=new MyAccount(this.getDriver());
		try{
			this.waitForCondition(Driver->{return myAccount.lblOrderDetailsSectionTitle.isDisplayed();},15000);
		}
		catch(Exception e){
			for(int refreshCounter=0;refreshCounter<100;refreshCounter++){
				this.getDriver().navigate().refresh();
				this.waitForPageToLoad();
				boolean value = this.waitForCondition(Driver->{return myAccount.lblOrderDetailsSectionTitle.isDisplayed();},15000);
				if(value)
					break;
				else
					continue;
			}
		}
		return true;
	}

	/**
	 * To go to myAccount Page
	 * @param - String - lsURLFromYamlFile
	 * @return - boolean
	 */
	public boolean goToMyAccountPage(String lsURLFromYamlFile){
		String lsCurrentURL=this.URL();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnGoToMyAccount);
		this.clickWebElementUsingJS(this.btnGoToMyAccount);

		String lsBaseURL=this.getBaseURL();
		String lsExpectedURL=lsBaseURL+lsURLFromYamlFile;
		this.waitForCondition(Driver->{return !this.URL().equalsIgnoreCase(lsCurrentURL);},20000);
		if(this.URL().equalsIgnoreCase(lsExpectedURL)){
			reporter.reportLogPass("Navigate to myAccount page successfully");
		}
		else{
			reporter.reportLogFail("Fail to navigate to myAccount page");
		}

		MyAccount myAccount=new MyAccount(this.getDriver());
		return this.waitForCondition(Driver->{return myAccount.lblMyAccountHeaderTitle.isDisplayed();},120000);
	}

	/**
	 * To get receipt Description
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getReceiptDesc() {
		Map<String, Object> map = new HashMap<>();
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptDate);
		lsText=lblReceiptDate.getText().trim();
		map.put("orderDate",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderNumber);
		lsText=lblReceiptOrderNumber.getText().trim();
		map.put("orderNumber",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptCustomerNumber);
		lsText=lblReceiptCustomerNumber.getText().trim();
		map.put("customerNumber",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderMethod);
		lsText=lblReceiptOrderMethod.getText().trim();
		map.put("orderMethod",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderShippingMethod);
		lsText=lblReceiptOrderShippingMethod.getText().trim();
		map.put("shippingMethod",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderShippingMethod);
		lsText=lblReceiptOrderShippingMethod.getText().trim();
		map.put("shippingMethod",lsText);

		return map;
	}

	/**
	 * To get Order item Description
	 * @param - WebElement - orderItem in lstOrderList
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getOrderItemDesc(WebElement orderItem){
		Map<String,Object> map=new HashMap<>();
		WebElement item,subItem,styleItem,sizeItem;
		String lsText;

		if(this.checkProductBadgeExisting(orderItem)){
			map.put("productBadge",true);
		}
		else{
			map.put("productBadge",false);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(orderItem);
		item = orderItem.findElement(byProductDescriptionLink);
		lsText = this.getElementInnerText(item);
		map.put("productDescription", lsText);

		subItem=item.findElement(By.xpath("./div[1]"));
		map.put("productName",subItem.getText().trim());

		subItem=item.findElement(By.xpath("./div[2]"));
		if(this.checkChildElementExistingByAttribute(subItem,"class","spn-style")){
			styleItem=subItem.findElement(By.xpath("./span[@class='spn-style']"));
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(styleItem);
			map.put("productStyle",styleItem.getText().trim());
		}
		else{
			map.put("productStyle",null);
		}

		if(this.checkChildElementExistingByAttribute(subItem,"class","spn-size")){
			sizeItem=subItem.findElement(By.xpath("./span[@class='spn-size']"));
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(sizeItem);
			map.put("productSize",sizeItem.getText().trim().split(":")[1].trim());
		}
		else{
			map.put("productSize",null);
		}

		item = orderItem.findElement(byProductWasPrice);
		lsText = this.getElementInnerText(item);
		if(lsText.isEmpty()){
			map.put("productWasPrice",0.0f);
		}
		else{
			map.put("productWasPrice", this.getFloatFromString(lsText,true));
		}

		item = orderItem.findElement(byProductNowPrice);
		lsText = this.getElementInnerText(item);
		map.put("productNowPrice", this.getFloatFromString(lsText,true));

		item = orderItem.findElement(byProductNumber);
		lsText = this.getElementInnerText(item).replace("-", "").trim();
		map.put("productNumber", lsText);

		item = orderItem.findElement(byProductQuantity);
		lsText = this.getElementInnerText(item);
		map.put("productQuantity", this.getIntegerFromString(lsText));

		if(!this.checkProductShippingDateExisting()){
			item = orderItem.findElement(byProductShippingDate);
			lsText = this.getElementInnerText(item);
			map.put("productShippingDate", lsText.split(":")[1].trim());
		}
		else{
			lsText = this.getElementInnerText(getDriver().findElement(byProductShippingDate));
			map.put("productShippingDate", lsText.split(":")[1].trim());
		}

		return map;
	}

	/**
	 * To get Order List Description
	 * @return - List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getOrderListDesc(){
		List<Map<String,Object>> mapList= new ArrayList<>();
		for(WebElement orderItem:lstOrderList) {
			mapList.add(getOrderItemDesc(orderItem));

		}
		return mapList;
	}

	/**
	 * To get Payment Card Type
	 * @return - String
	 */
	public String getPaymentCardType(){
		String cardType = this.getElementInnerText(lblPaymentCard).toLowerCase();
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
	 * To get promote code
	 * @return - String
	 */
	public String getPromoteCode(){
		return this.getElementInnerText(lblPromoteCode).trim();
	}

	/**
	 * To get Shipping And Payment Description
	 * @return - Map<String,Object>
	 */
	public Map<String,Object> getShippingAndPaymentDesc(Map<String,Object> orderConfirmationItem) {
		String lsText;
		Map<String, Object> map = new HashMap<>();

		if(this.checkProductShippingDateExisting()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReviewShoppingCartShippingDate);
			lsText=lblReviewShoppingCartShippingDate.getText().trim();
			map.put("shippingDate",lsText.split(":")[1].trim());
		}
		else{
			lsText=orderConfirmationItem.get("productShippingDate").toString();
			map.put("shippingDate",lsText);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderShippingAddressTitle);
		String lsSubItem;
		List<String> lstShippingAddress=new ArrayList<>();
		for(WebElement item:lstReceiptOrderShippingAddressDetails){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsSubItem=item.getText().trim();
			lstShippingAddress.add(lsSubItem);
		}
		map.put("shippingAddress",lstShippingAddress);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderShippingMethod);
		lsText=lblReceiptOrderShippingMethod.getText().trim();
		map.put("shippingMethod", lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblReceiptOrderNumber);
		lsText = this.lblReceiptOrderNumber.getText();
		map.put("orderNumber",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblReceiptCustomerNumber);
		lsText = this.lblReceiptCustomerNumber.getText();
		map.put("customerNumber",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblReceiptOrderMethod);
		lsText = this.lblReceiptOrderMethod.getText();
		map.put("orderMethod",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentCard);
		lsText=lblPaymentCard.getText().trim();
		map.put("paymentMethodDescription",lsText);
		map.put("paymentMethod", getPaymentCardType());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblBillingAddressTitle);
		List<String> lstBillingAddress=new ArrayList<>();
		for(WebElement item:lstBillingAddressDetails){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsSubItem=item.getText().trim();
			lstBillingAddress.add(lsSubItem);
		}
		map.put("billingAddress",lstBillingAddress);

		return map;
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
	 * To get Tax Province Code
	 * @return - String
	 */
	public String getTaxProvinceCode(){
		return this.getElementInnerText(this.lblOrderSummaryTaxProvince);
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryShippingAndHandlingWasPrice);
		lsText=this.lblOrderSummaryShippingAndHandlingWasPrice.getText();
		if(lsText.isEmpty()){
			map.put("wasPrice",0.0f);
		}
		else{
			map.put("wasPrice",this.getFloatFromString(lsText,true));
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryShippingAndHandlingNowPrice);
		lsText=this.lblOrderSummaryShippingAndHandlingNowPrice.getText().trim();
		if(!lsText.equalsIgnoreCase("Free")){
			map.put("nowPrice",this.getFloatFromString(lsText));
		}
		else{
			map.put("nowPrice",0.0f);
		}

		map.put("province",getTaxProvinceCode());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryTax);
		lsText=this.lblOrderSummaryTax.getText();
		map.put("tax",this.getFloatFromString(lsText,true));

		map.put("promoteCodeTitle",null);
		map.put("promoteCodeValue",0.0f);
		map.put("giftCardTitle",null);
		map.put("giftCardValue",0.0f);

		if(checkAppliedDiscountExistingInOrderSummarySection()) {
			WebElement subItem;
			String lsSubText;
			for (WebElement item : lstOrderSummaryItems) {
				lsText = this.getElementInnerText(item).toLowerCase();
				if (lsText.contains("discount")) {
					subItem = item.findElement(By.xpath("./div[1]"));
					lsSubText = this.getElementInnerText(subItem);
					map.put("promoteCodeTitle", lsSubText);

					subItem = item.findElement(By.xpath("./div[2]"));
					lsSubText = this.getElementInnerText(subItem);
					map.put("promoteCodeValue", this.getFloatFromString(lsSubText));
				}

				if (lsText.contains("gift card")) {
					subItem = item.findElement(By.xpath("./div[1]"));
					lsSubText = this.getElementInnerText(subItem);
					map.put("giftCardTitle", lsSubText);

					subItem = item.findElement(By.xpath("./div[2]"));
					lsSubText = this.getElementInnerText(subItem);
					map.put("giftCardValue", this.getFloatFromString(lsSubText));
				}
			}
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblOrderSummaryTotalPrice);
		lsText=this.lblOrderSummaryTotalPrice.getText();
		map.put("totalPrice",this.getFloatFromString(lsText,true));

		return map;
	}

	/**
	 * To get calculated provincial tax with given province
	 * @param - float - subTotal
	 * @param - float - shippingAmount - refer to nowPrice in OrderSummary section
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
		float calTotalPrice=subTotal+tax+nowPriceOrderSummary-promoteCodeValue;
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
	 * @param - Map<String,Object> - orderSummaryMap
	 */
	public void verifyInstallmentBusinessLogic(Map<String,Object> orderSummaryMap){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblInstallmentNumber);
		int totalInstallmentNumber=this.getIntegerFromString(this.lblInstallmentNumber.getText());

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
		float promoteCodeValue=(float) orderSummaryMap.get("promoteCodeValue");

		float eachInstallmentPayment=subTotalOrderSummary/totalInstallmentNumber;
		float calTodayPayment=eachInstallmentPayment+shippingPriceOrderSummary+taxOrderSummary-promoteCodeValue/totalInstallmentNumber;
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
	 * To verify order confirmation Contents
	 */
	public void verifyOrderConfirmationContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconOrderSuccess);
		if (this.getReusableActionsInstance().isElementVisible(iconOrderSuccess)) {
			reporter.reportLogPass("The order success icon is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The order success icon is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSuccessTitle);
		lsText = lblOrderSuccessTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The order success title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The order success title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderNumber);
		lsText = lblOrderNumber.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The order number is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The order number is not displaying correctly");
		}

		if (lstOrderMessage.size()>0) {
			reporter.reportLogPass("The order messages are displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The order messages are not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnGoToOrderDetails);
		lsText = btnGoToOrderDetails.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The GoToOrderDetails button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The GoToOrderDetails button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnGoToMyAccount);
		lsText = btnGoToMyAccount.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The GoToMyAccount button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The GoToMyAccount button is not displaying correctly");
		}
	}

	/**
	 * To verify receipt Contents
	 */
	public void verifyReceiptContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptHeaderTitle);
		lsText = lblReceiptHeaderTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt header Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt header Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptDateTitle);
		lsText = lblReceiptDateTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt date Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt date Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptDate);
		lsText = lblReceiptDate.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt date is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt date is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderNumberTitle);
		lsText = lblReceiptOrderNumberTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt order number title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt order number title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderNumber);
		lsText = lblReceiptOrderNumber.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt order number is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt order number is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptCustomerNumberTitle);
		lsText = lblReceiptCustomerNumberTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt customer number title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt customer number title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptCustomerNumber);
		lsText = lblReceiptCustomerNumber.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt customer number is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt customer number is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderMethodTitle);
		lsText = lblReceiptOrderMethodTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt order method title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt order method title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderMethod);
		lsText = lblReceiptOrderMethod.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt order method is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt order method is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderShippingAddressTitle);
		lsText = lblReceiptOrderShippingAddressTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt order shipping address title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt order shipping address title is not displaying correctly");
		}

		if (lstReceiptOrderShippingAddressDetails.size()>0) {
			reporter.reportLogPass("The receipt order shipping address details are displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt order shipping address details are not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderShippingMethodTitle);
		lsText = lblReceiptOrderShippingMethodTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt order shipping method title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt order shipping method title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReceiptOrderShippingMethod);
		lsText = lblReceiptOrderShippingMethod.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The receipt order shipping method is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The receipt order shipping method is not displaying correctly");
		}
	}

	/**
	 * To verify Existing order List contents
	 */
	public void verifyOrderListContents() {
		String lsText;
		WebElement item;
		for (WebElement productItem : this.lstOrderList) {
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

			item = productItem.findElement(byProductDescriptionLink);
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

			item = productItem.findElement(byProductQuantity);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText = item.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The product quantity is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The product quantity is not displaying correctly");
			}

			if(this.checkFreeShippingExistingInOrderList(productItem)){
				item = productItem.findElement(byProductFreeShipping);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText = item.getText();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The product free shipping is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product free shipping is not displaying correctly");
				}
			}

			if(!this.checkProductShippingDateExisting()){
				item = productItem.findElement(byProductShippingDate);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				lsText = item.getText();
				if (!lsText.isEmpty()) {
					reporter.reportLogPass("The product shipping date is displaying correctly");
				} else {
					reporter.reportLogFailWithScreenshot("The product shipping date is not displaying correctly");
				}
			}
		}
	}

	/**
	 * To verify payment card Contents
	 */
	public void verifyPaymentCardContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentCardTitle);
		lsText = lblPaymentCardTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The payment card title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The payment card title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconPaymentCardLogo);
		if (this.getReusableActionsInstance().isElementVisible(iconPaymentCardLogo)) {
			reporter.reportLogPass("The payment card Logo is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The payment card Logo is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPaymentCard);
		lsText = lblPaymentCard.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The payment card is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The payment card is not displaying correctly");
		}

		if(this.checkGiftCardExistingInPaymentSection()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblGiftCardTitle);
			lsText = lblGiftCardTitle.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The Gift Card Title is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Gift Card Title is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblGiftCardNumber);
			lsText = lblGiftCardNumber.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The Gift Card number is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Gift Card number is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblGiftCardSavingMessage);
			lsText = lblGiftCardSavingMessage.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The Gift Card Saving Message is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Gift Card Saving Message is not displaying correctly");
			}
		}

		if(this.checkPromoteCodeExistingInPaymentSection()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPromoteCodeTitle);
			lsText = lblPromoteCodeTitle.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The Promote Code Title is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Promote Code Title is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconPromoteCodeTick);
			if (this.getReusableActionsInstance().isElementVisible(iconPromoteCodeTick)) {
				reporter.reportLogPass("The Promote Code Tick icon is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Promote Code Tick icon is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblPromoteCode);
			lsText = lblPromoteCode.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The Promote Code is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The Promote Code is not displaying correctly");
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryShippingAndHandlingTitle);
		lsText = lblOrderSummaryShippingAndHandlingTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary Shipping Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary Shipping Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryShippingAndHandlingNowPrice);
		lsText = lblOrderSummaryShippingAndHandlingNowPrice.getText();
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

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryTotalPriceTitle);
		lsText = lblOrderSummaryTotalPriceTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary new Total Price Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary new Total Price Title is not displaying correctly");
		}

		if(this.checkAppliedDiscountExistingInOrderSummarySection()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryAppliedDiscountTitle);
			lsText=lblOrderSummaryAppliedDiscountTitle.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The OrderSummary Applied Discount Title is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The OrderSummary Applied Discount Title is not displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryAppliedDiscount);
			lsText=lblOrderSummaryAppliedDiscount.getText();
			if (!lsText.isEmpty()) {
				reporter.reportLogPass("The OrderSummary Applied Discount is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The OrderSummary Applied Discount is not displaying correctly");
			}

		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderSummaryTotalPrice);
		lsText = lblOrderSummaryTotalPrice.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The OrderSummary new Total Price is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The OrderSummary new Total Price is not displaying correctly");
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
	 * To verify common questions Contents
	 */
	public void verifyCommonQuestionsContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCommonQuestionsTitle);
		lsText = lblCommonQuestionsTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The common questions Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The common questions Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCommonQuestionsOrderTracking);
		lsText = lnkCommonQuestionsOrderTracking.getAttribute("href");
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The common questions Order Tracking link is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The common questions Order Tracking link is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCommonQuestionsOrderModification);
		lsText = lnkCommonQuestionsOrderModification.getAttribute("href");
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The common questions Order Modification link is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The common questions Order Modification link is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCommonQuestionsReturnsPage);
		lsText = lnkCommonQuestionsReturnsPage.getAttribute("href");
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The common questions Returns Page link is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The common questions Returns Page link is not displaying correctly");
		}
	}

	/**
	 * To verify product list Linkage Between OrderConfirmation Page And Checkout Page
	 * @param - Map<String,Object> - orderConfirmationItem
	 * @param - Map<String,Object> - checkoutItem
	 */
	public void verifyProductListLinkageBetweenOrderConfirmationPageAndCheckoutPage(Map<String,Object> orderConfirmationItem,Map<String,Object> checkoutItem){
		String lsOrderConfirmationText,lsCheckoutText;

		lsOrderConfirmationText=(String)orderConfirmationItem.get("productName");
		lsCheckoutText=(String)checkoutItem.get("productName");
		if(lsOrderConfirmationText.equalsIgnoreCase(lsCheckoutText)){
			reporter.reportLogPass("The productName in OrderConfirmation Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The productName:"+lsOrderConfirmationText+" in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
		}

		lsOrderConfirmationText=(String)orderConfirmationItem.get("productStyle");
		lsCheckoutText=(String)checkoutItem.get("productStyle");
		if(lsOrderConfirmationText==null){
			if(lsCheckoutText==null){
				reporter.reportLogPass("The productStyle in OrderConfirmation Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productStyle in OrderConfirmation Item is not the same as the one in checkout Item");
			}
		}
		else{
			if(lsOrderConfirmationText.equalsIgnoreCase(lsCheckoutText)){
				reporter.reportLogPass("The productStyle in OrderConfirmation Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productStyle:"+lsOrderConfirmationText+" in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}
		}

		lsOrderConfirmationText=(String)orderConfirmationItem.get("productSize");
		lsCheckoutText=(String)checkoutItem.get("productSize");
		if(lsOrderConfirmationText==null){
			if(lsCheckoutText==null){
				reporter.reportLogPass("The productSize in OrderConfirmation Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productSize in OrderConfirmation Item is not the same as the one in checkout Item");
			}
		}
		else{
			if(lsOrderConfirmationText.equalsIgnoreCase(lsCheckoutText)){
				reporter.reportLogPass("The productSize in OrderConfirmation Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productSize:"+lsOrderConfirmationText+" in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}
		}

		if((boolean)orderConfirmationItem.get("productBadge")==(boolean)checkoutItem.get("productBadge")){
			reporter.reportLogPass("The productBadge in OrderConfirmation Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The productBadge in OrderConfirmation Item is not the same as the one in checkout Item");
		}

		lsOrderConfirmationText=(String)orderConfirmationItem.get("productNumber");
		lsCheckoutText=(String)checkoutItem.get("productNumber");
		if(lsOrderConfirmationText==null){
			if(lsCheckoutText==null){
				reporter.reportLogPass("The productNumber in OrderConfirmation Item is the same as the one in checkout Item");
			}
			else{
				reporter.reportLogFail("The productNumber in OrderConfirmation Item is not the same as the one in checkout Item");
			}
		}
		else{
			if(lsOrderConfirmationText.equalsIgnoreCase(lsCheckoutText)){
				reporter.reportLogPass("The productNumber in OrderConfirmation item is the same as the one in checkoutItem");
			}
			else{
				reporter.reportLogFail("The productNumber:"+lsOrderConfirmationText+" in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}
		}

		float orderConfirmationNowPrice=(float)orderConfirmationItem.get("productNowPrice");
		float checkoutNowPrice=(float)checkoutItem.get("productNowPrice");
		if(Math.abs(orderConfirmationNowPrice-checkoutNowPrice)<0.1f){
			reporter.reportLogPass("The productNowPrice in OrderConfirmation Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The productNowPrice:"+orderConfirmationNowPrice+" in OrderConfirmation Item is not the same as the one:"+checkoutNowPrice+" in checkout Item");
		}

		int orderConfirmationQuantity=(int)orderConfirmationItem.get("productQuantity");
		int checkoutQuantity=(int)checkoutItem.get("productQuantity");
		if(orderConfirmationQuantity==checkoutQuantity){
			reporter.reportLogPass("The productQuantity in OrderConfirmation Item is the same as the one in checkout Item");
		}
		else{
			reporter.reportLogFail("The productQuantity:"+orderConfirmationQuantity+" in OrderConfirmation Item is not the same as the one:"+checkoutQuantity+" in checkout Item");
		}

		lsCheckoutText=(String)checkoutItem.get("productShippingDate");
		if(lsCheckoutText!=null){
			lsOrderConfirmationText=(String)orderConfirmationItem.get("productShippingDate");
			if(lsOrderConfirmationText!=null){
				if(lsOrderConfirmationText.equalsIgnoreCase(lsCheckoutText)){
					reporter.reportLogPass("The productShippingDate in OrderConfirmation Item is the same as the one in checkout Item");
				}
				else{
					reporter.reportLogFail("The productShippingDate:'"+lsOrderConfirmationText+"' in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
				}
			}
			else{
				reporter.reportLogFailWithScreenshot("The productShippingDate in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
			}

		}

	}

	/**
	 * To verify OrderSummary Linkage Between OrderConfirmation Page And Checkout Page
	 * @param - Map<String,Object> - OrderConfirmation
	 * @param - Map<String,Object> - checkoutItem
	 */
	public void verifyOrderSummaryLinkageBetweenOrderConfirmationPageAndCheckoutPage(Map<String,Object> OrderConfirmationItem,Map<String,Object> checkoutItem) {
		float OrderConfirmationValue, checkoutValue;
		String lsOrderConfirmationText,lsCheckoutText;

		OrderConfirmationValue = (float) OrderConfirmationItem.get("subTotal");
		checkoutValue = (float) checkoutItem.get("subTotal");
		if (Math.abs(OrderConfirmationValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The subTotal in OrderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The subTotal:"+OrderConfirmationValue+" in OrderConfirmation Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		OrderConfirmationValue = (float) OrderConfirmationItem.get("wasPrice");
		checkoutValue = (float) checkoutItem.get("wasPrice");
		if (Math.abs(OrderConfirmationValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The wasPrice in OrderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The wasPrice:"+OrderConfirmationValue+" in OrderConfirmation Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		OrderConfirmationValue = (float) OrderConfirmationItem.get("nowPrice");
		checkoutValue = (float) checkoutItem.get("nowPrice");
		if (Math.abs(OrderConfirmationValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The nowPrice in OrderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The nowPrice:"+OrderConfirmationValue+" in OrderConfirmation Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		lsOrderConfirmationText = (String) OrderConfirmationItem.get("province");
		lsCheckoutText = (String) checkoutItem.get("province");
		if (lsOrderConfirmationText.equalsIgnoreCase(lsCheckoutText)) {
			reporter.reportLogPass("The province in OrderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The province:"+lsOrderConfirmationText+" in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
		}

		OrderConfirmationValue = (float) OrderConfirmationItem.get("tax");
		checkoutValue = (float) checkoutItem.get("tax");
		if (Math.abs(OrderConfirmationValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The tax in OrderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The tax:"+OrderConfirmationValue+" in OrderConfirmation Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		OrderConfirmationValue = (float) OrderConfirmationItem.get("promoteCodeValue");
		checkoutValue = (float) checkoutItem.get("promoteCodeValue");
		if (Math.abs(Math.abs(OrderConfirmationValue)-Math.abs(checkoutValue))<0.1f) {
			reporter.reportLogPass("The promoteCode Value in OrderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The promoteCode Value:"+OrderConfirmationValue+" in OrderConfirmation Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		OrderConfirmationValue = (float) OrderConfirmationItem.get("totalPrice");
		checkoutValue = (float) checkoutItem.get("totalPrice");
		if (Math.abs(OrderConfirmationValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The totalPrice in OrderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFailWithScreenshot("The totalPrice:"+OrderConfirmationValue+" in OrderConfirmation Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}
	}

	/**
	 * To verify Shipping and Payment Linkage Between OrderConfirmation Page And Checkout Page
	 * @param - Map<String,Object> - OrderConfirmation
	 * @param - Map<String,Object> - checkoutItem
	 */
	public void verifyShippingAndPaymentLinkageBetweenOrderConfirmationPageAndCheckoutPage(Map<String,Object> OrderConfirmationItem,Map<String,Object> checkoutItem) {
		String lsOrderConfirmationText,lsCheckoutText;

		lsOrderConfirmationText = (String) OrderConfirmationItem.get("shippingDate");
		lsCheckoutText = (String) checkoutItem.get("shippingDate");
		if (lsOrderConfirmationText.equalsIgnoreCase(lsCheckoutText)) {
			reporter.reportLogPass("The shippingDate in OrderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The shippingDate:"+lsOrderConfirmationText+" in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
		}

		List<String> lstShippingAddress = (List<String>) OrderConfirmationItem.get("shippingAddress");
		lsCheckoutText = (String) checkoutItem.get("shippingAddress");
		lsCheckoutText=lsCheckoutText.replace(",","").toLowerCase();
		for(String item:lstShippingAddress){
			if (lsCheckoutText.contains(item.trim().replace(",","").toLowerCase())) {
				reporter.reportLogPass("The shippingAddress part:'"+item+"' in OrderConfirmation Item has been contained in checkout shipping address:'"+lsCheckoutText+"'");
			} else {
				reporter.reportLogFail("The shippingAddress part:'"+item+"' in OrderConfirmation Item has not been contained in checkout shipping address:'"+lsCheckoutText+"'");
			}
		}

		lsOrderConfirmationText = (String) OrderConfirmationItem.get("shippingMethod");
		lsCheckoutText = (String) checkoutItem.get("shippingMethod");
		if (lsOrderConfirmationText.equalsIgnoreCase(lsCheckoutText)) {
			reporter.reportLogPass("The shippingMethod in OrderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The shippingMethod:"+lsOrderConfirmationText+" in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
		}

		lsOrderConfirmationText = (String) OrderConfirmationItem.get("paymentMethod");
		lsCheckoutText = (String) checkoutItem.get("paymentMethod");
		if (lsOrderConfirmationText.equalsIgnoreCase(lsCheckoutText)) {
			reporter.reportLogPass("The paymentMethod in OrderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The paymentMethod:"+lsOrderConfirmationText+" in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
		}

		lsOrderConfirmationText = (String) OrderConfirmationItem.get("paymentMethodDescription");
		lsCheckoutText = (String) checkoutItem.get("paymentMethodDescription");
		if (lsOrderConfirmationText.toLowerCase().contains(lsCheckoutText.toLowerCase())) {
			reporter.reportLogPass("The paymentMethodDescription in OrderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The paymentMethodDescription:"+lsOrderConfirmationText+" in OrderConfirmation Item is not the same as the one:"+lsCheckoutText+" in checkout Item");
		}

		List<String> lstBillingAddress = (List<String>) OrderConfirmationItem.get("billingAddress");
		lsCheckoutText = (String) checkoutItem.get("billingAddress");
		lsCheckoutText=lsCheckoutText.replace(",","").toLowerCase();
		for(String item:lstBillingAddress){
			if (lsCheckoutText.contains(item.trim().replace(",","").toLowerCase())){
				reporter.reportLogPass("The billingAddress part:'"+item+"' in OrderConfirmation Item has been contained in checkout billing address:'"+lsCheckoutText+"'");
			} else {
				reporter.reportLogFail("The billingAddress part:'"+item+"' in OrderConfirmation Item has not been contained in checkout billing address:'"+lsCheckoutText+"'");
			}
		}
	}

	/**
	 * To verify EasyPayment Linkage Between OrderConfirmation Page And Checkout Page
	 * @param - Map<String,Object> - orderConfirmationItem
	 * @param - Map<String,Object> - checkoutItem
	 */
	public void verifyEasyPaymentLinkageBetweenOrderConfirmationPageAndCheckoutPage(Map<String,Object> orderConfirmationItem,Map<String,Object> checkoutItem) {
		float orderConfirmationValue, checkoutValue;

		int orderConfirmationInstallmentsNumber = (int) orderConfirmationItem.get("installmentsNumber");
		int checkoutInstallmentsNumber = (int) checkoutItem.get("installmentsNumber");
		if (orderConfirmationInstallmentsNumber==checkoutInstallmentsNumber) {
			reporter.reportLogPass("The installmentsNumber in orderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The installmentsNumber:"+orderConfirmationInstallmentsNumber+" in orderConfirmation Item is not the same as the one:"+checkoutInstallmentsNumber+" in checkout Item");
		}

		orderConfirmationValue = (float) orderConfirmationItem.get("todayPayment");
		checkoutValue = (float) checkoutItem.get("todayPayment");
		if (Math.abs(orderConfirmationValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The todayPayment in orderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The todayPayment:"+orderConfirmationValue+" in orderConfirmation Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		orderConfirmationValue = (float) orderConfirmationItem.get("leftPayment");
		checkoutValue = (float) checkoutItem.get("leftPayment");
		if (Math.abs(orderConfirmationValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The leftPayment in orderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The leftPayment:"+orderConfirmationValue+" in orderConfirmation Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}

		orderConfirmationValue = (float) orderConfirmationItem.get("futureMonthlyPayment");
		checkoutValue = (float) checkoutItem.get("futureMonthlyPayment");
		if (Math.abs(orderConfirmationValue-checkoutValue)<0.1f) {
			reporter.reportLogPass("The futureMonthlyPayment in orderConfirmation Item is the same as the one in checkout Item");
		} else {
			reporter.reportLogFail("The futureMonthlyPayment:"+orderConfirmationValue+" in orderConfirmation Item is not the same as the one:"+checkoutValue+" in checkout Item");
		}
	}

	/**
	 * This function navigates to Order Details page under My Account
	 */
	public void navigateToOrderDetailsUnderMyAccountFromOrderConfirmationPage(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnGoToOrderDetails);
		this.getReusableActionsInstance().clickIfAvailable(this.btnGoToOrderDetails);

		//Applying static wait as page takes time to get Order after placing it
		this.applyStaticWait(6000);
	}

	/**
	 * To check Email in order message Is the Same As the one in GuestCheckoutPage
	 * @param - String - lsEmail - the email input in GuestCheckoutPage
	 * @return - boolean
	 */
	public boolean checkEmailIsSameAsGuestCheckoutPage(String lsEmail){
		return this.getElementInnerText(lstOrderMessage.get(0)).toLowerCase().contains(lsEmail.toLowerCase());
	}

	/**
	 * This function verifies Order Confirmation Data from checkout page
	 * @param - List<Map<String, Object>> - productListMapForCheckOutPage
	 * @param - Map<String,Object> - orderSummaryMapOnCheckoutPage
	 * @param - Map<String,Object> - easyPaymentMapOnCheckoutPage
	 * @param - Map<String,Object> - shippingAndPaymentMapOnCheckoutPage
	 * @param - ShoppingCartPage - shoppingCartPage
	 * @param - String - lsPromoteCodeOnCheckoutPage
	 * @param - int - itemCountForCheckOutList
	 * @param - float - subTotalForCheckOutList
	 */
	public void verifyOrderConfirmationPageContents(List<Map<String, Object>> productListMapForCheckOutPage,Map<String,Object> orderSummaryMapOnCheckoutPage,Map<String,Object> easyPaymentMapOnCheckoutPage, Map<String,Object> shippingAndPaymentMapOnCheckoutPage, ShoppingCartPage shoppingCartPage,String lsPromoteCodeOnCheckoutPage,int itemCountForCheckOutList,float subTotalForCheckOutList){
		if(lsPromoteCodeOnCheckoutPage!=null && lsPromoteCodeOnCheckoutPage.length()>0){
			String lsPromoteCodeOnOrderConfirmationPage=this.getPromoteCode();
			if(lsPromoteCodeOnCheckoutPage.equalsIgnoreCase(lsPromoteCodeOnOrderConfirmationPage)){
				reporter.reportLogPass("The promote code on OrderConfirmation page is the same as the one on Checkout page");
			}
			else{
				reporter.reportLogFail("The promote code on OrderConfirmation page is not the same as the one on Checkout page");
			}
		}

		//Map<String,Object> orderReceiptForOrderConfirmationPage=this.getReceiptDesc();

		List<Map<String,Object>> orderListMapForOrderConfirmationPage=this.getOrderListDesc();
		Map<String,Object> itemCountAndSubTotalMap=this.getCheckoutItemCountAndSubTotal(orderListMapForOrderConfirmationPage);
		int itemCountForOrderConfirmationList= (int) itemCountAndSubTotalMap.get("itemCount");
		float subTotalForOrderConfirmationList= (float) itemCountAndSubTotalMap.get("subTotal");

		reporter.reportLog("Verify product list linkage between OrderConfirmationPage and CheckoutPage");
		if(itemCountForOrderConfirmationList==itemCountForCheckOutList){
			reporter.reportLogPass("The order item count in OrderConfirmation Page is the same as the one in CheckOut page");
		}
		else{
			reporter.reportLogFail("The order item count:"+itemCountForOrderConfirmationList+" in OrderConfirmation Page is the same as the one:"+itemCountForCheckOutList+" in CheckOut page");
		}

		if(Math.abs(subTotalForOrderConfirmationList-subTotalForCheckOutList)<0.1f){
			reporter.reportLogPass("The order subTotal in OrderConfirmation Page is the same as the one in CheckOut page");
		}
		else{
			reporter.reportLogFail("The order subTotal:"+subTotalForOrderConfirmationList+" in OrderConfirmation Page is the same as the one:"+subTotalForCheckOutList+" in CheckOut page");
		}

		int findIndex;
		Map<String,Object> checkoutItem;
		for(Map<String,Object> orderItem:orderListMapForOrderConfirmationPage){
			String lsText=(String)orderItem.get("productName");
			reporter.reportLog("Verify product:'"+lsText+"'");
			findIndex=shoppingCartPage.findGivenProductIndexInProductList(orderItem,productListMapForCheckOutPage);
			if(findIndex!=-1){
				checkoutItem=productListMapForCheckOutPage.get(findIndex);
				this.verifyProductListLinkageBetweenOrderConfirmationPageAndCheckoutPage(orderItem,checkoutItem);
			}
			else{
				reporter.reportLogFail("Unable to find '"+lsText+"' in Checkout Page");
			}
		}

		Map<String,Object> shippingAndPaymentMapForOrderConfirmationPage=this.getShippingAndPaymentDesc(orderListMapForOrderConfirmationPage.get(0));

		reporter.reportLog("Verify OrderSummary Business Logic");
		Map<String,Object> orderSummaryForOrderConfirmationPage=this.getOrderSummaryDesc();
		this.verifyOrderSummaryBusinessLogic(subTotalForOrderConfirmationList,orderSummaryForOrderConfirmationPage,null);

		reporter.reportLog("verify OrderSummary Linkage Between OrderConfirmationPage And CheckoutPage");
		this.verifyOrderSummaryLinkageBetweenOrderConfirmationPageAndCheckoutPage(orderSummaryForOrderConfirmationPage,orderSummaryMapOnCheckoutPage);

		reporter.reportLog("Verify OrderSummary EasyPayment Business Logic");
		Map<String,Object> easyPaymentForOrderConfirmationPage=this.getEasyPayDesc();
		this.verifyInstallmentBusinessLogic(orderSummaryForOrderConfirmationPage);

		reporter.reportLog("verify EasyPayment Linkage Between OrderConfirmationPage And CheckoutPage");
		this.verifyEasyPaymentLinkageBetweenOrderConfirmationPageAndCheckoutPage(easyPaymentForOrderConfirmationPage,easyPaymentMapOnCheckoutPage);

		reporter.reportLog("verify Shipping and Payment Linkage Between OrderConfirmationPage And CheckoutPage");
		this.verifyShippingAndPaymentLinkageBetweenOrderConfirmationPageAndCheckoutPage(shippingAndPaymentMapForOrderConfirmationPage,shippingAndPaymentMapOnCheckoutPage);

		reporter.reportLog("Verify OrderConfirmation header Contents");
		this.verifyOrderConfirmationContents();

		reporter.reportLog("Verify Receipt Contents");
		this.verifyReceiptContents();

		reporter.reportLog("Verify Order List Contents");
		this.verifyOrderListContents();

		reporter.reportLog("Verify Payment Card Contents");
		this.verifyPaymentCardContents();

		reporter.reportLog("Verify OrderSummary Contents");
		this.verifyOrderSummaryContents();

		reporter.reportLog("Verify EasyPayment Contents");
		this.verifyEasyPayContents();

		reporter.reportLog("Verify Common Questions Contents");
		this.verifyCommonQuestionsContents();
	}
}
