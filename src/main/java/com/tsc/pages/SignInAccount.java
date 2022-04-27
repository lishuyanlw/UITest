package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInAccount extends BasePage {

	public SignInAccount(WebDriver driver) {
		super(driver);
	}

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

	@FindBy(xpath = "//ng-component//input[@id='myAccountOrderSearch']")
	public WebElement inputAccountOrderSearch;

	@FindBy(xpath = "//ng-component//button[contains(normalize-space(.),'Search Orders')]")
	public WebElement btnAccountOrderSearch;

	@FindBy(xpath = "//ng-component//label[@for='select-period']")
	public WebElement lblSelectPeriod;

	@FindBy(xpath = "//ng-component//select[@id='select-period']")
	public WebElement selectPeriodOptions;

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

	@FindBy(xpath = "//ng-component//*[@id='tagOrderCustomerNo']")
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

	@FindBy(xpath = "//ng-component//div[@id='heading-password']//div[contains(@class,'item-title')]")
	public WebElement lblAccountSettingPasswordTitle;

	@FindBy(xpath = "//ng-component//div[@id='heading-password']//div[contains(@class,'subPage')]")
	public WebElement lblAccountSettingPassword;

	@FindBy(xpath = "//ng-component//div[@id='heading-password']//div[contains(@class,'item-edit')]/a")
	public WebElement btnAccountSettingPasswordEdit;

	//For Change password
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

	@FindBy(xpath = "///ng-component//div[@id='panel-password']//a[normalize-space(text())='Cancel']")
	public WebElement btnChangePasswordCancel;
	////////////////////////

	@FindBy(xpath = "//ng-component//div[@id='heading-securityquestion']//div[contains(@class,'item-title')]")
	public WebElement lblAccountSettingSecurityQuestionTitle;

	@FindBy(xpath = "//ng-component//div[@id='heading-securityquestion']//div[contains(@class,'subPage')]")
	public WebElement lblAccountSettingSecurityQuestion;

	@FindBy(xpath = "//ng-component//div[@id='heading-securityquestion']//div[contains(@class,'item-edit')]/a")
	public WebElement btnAccountSettingSecurityQuestionEdit;

	//For change security question
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

	@FindBy(xpath = "///ng-component//div[@id='panel-securityquestion']//a[normalize-space(text())='Cancel']")
	public WebElement btnChangeSecurityQuestionCancel;
	////////////////////////////////

	/**
	 * To get subitem web element through sublitem text
	 * @param - lsSubItem -  sublitem text
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
		for(WebElement item:this.lstOrderServiceItemTitleLink){
			if(!item.getAttribute("class").isEmpty()){
				item.click();
				this.waitForCondition(Driver->{
					return item.getAttribute("class").isEmpty();},5000);
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
	public WebElement  getServiceWebElementWithGivenServiceName(String lsServiceItemName){
		for(WebElement item:this.lstOrderServiceItemTitleLink){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			if(item.getText().toLowerCase().trim().contains(lsServiceItemName.toLowerCase().trim())){
				return item;
			}
		}
		return null;
	}
}
