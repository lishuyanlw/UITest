package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAccount_Mobile extends MyAccount {

	public MyAccount_Mobile(WebDriver driver) {
		super(driver);
	}

	//For view details
	@FindBy(xpath = "//ng-component//a[contains(@href,'orderinvoice') and contains(@class,'visible-xs')]")
	public WebElement btnOrderDetailsHeaderViewInvoice;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Shipping Address:']")
	public WebElement lblOrderDetailsSubHeaderShippingAddressTitle;

	@FindBy(xpath = "//ng-component//div[normalize-space(text())='Shipping Address:']/following-sibling::div")
	public WebElement lblOrderDetailsSubHeaderShippingAddress;

	public By byOrderDetailsOrderItemWriteReview=By.xpath(".//div[contains(@class,'product-review') and contains(@class,'visible-xs-block')]//a[contains(@href,'openreview')]");
	public By byOrderDetailsOrderItemQTYTitle=By.xpath(".//span[contains(normalize-space(.),'QTY:')]/parent::div[contains(@class,'visible-xs-block')]/span[1]");
	public By byOrderDetailsOrderItemQTY=By.xpath(".//span[contains(normalize-space(.),'QTY:')]/parent::div[contains(@class,'visible-xs-block')]/span[2]");
	public By byOrderDetailsOrderItemStatusTitle=By.xpath("./following-sibling::div//span[contains(normalize-space(.),'Status:')]/parent::div[contains(@class,'visible-xs-block')]/span[1]");
	public By byOrderDetailsOrderItemStatus=By.xpath("./following-sibling::div//span[contains(normalize-space(.),'Status:')]/parent::div[contains(@class,'visible-xs-block')]/span[2]");


	//Payment Options - Credit Card Section
	@FindBy(xpath = "//div[@class='panel']//div[contains(@data-target,'payment')]//*[@class='svgIconAccordion']")
	public WebElement lblPaymentOptionAccordion;

	@FindBy(xpath = "//div[@id='paymentOptionsLinks']")
	public WebElement lblPaymentOptionMenuItems;

	@Override
	public void verifyMainHeaderSectionInOrderDetails_DifferentDevice(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnOrderDetailsHeaderViewInvoice);
		if(this.getReusableActionsInstance().isElementVisible(btnOrderDetailsHeaderViewInvoice)){
			reporter.reportLogPass("View invoice button in Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("View invoice button in Header is not displaying correctly");
		}
	}

	@Override
	public void verifySubHeaderSectionInOrderDetails_DifferentDevices(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingAddressTitle);
		if(!lblOrderDetailsSubHeaderShippingAddressTitle.getText().isEmpty()){
			reporter.reportLogPass("Shipping address title in Sub Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Shipping address title in Sub Header is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblOrderDetailsSubHeaderShippingAddress);
		if(!lblOrderDetailsSubHeaderShippingAddress.getText().isEmpty()){
			reporter.reportLogPass("Shipping address in Sub Header is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Shipping address in Sub Header is not displaying correctly");
		}
	}

	@Override
	public void verifyOrderItemListSectionInOrderDetails(){
		WebElement subItem=null;
		String lsProductNO,lsText;
		for(WebElement item:lstOrderDetailsOrderItemList){
			if(checkProductNumberAndWriteReviewButtonExisting(item)){
				subItem=item.findElement(byOrderDetailsOrderItemProductNumber);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				lsProductNO=subItem.getText().trim();
				reporter.reportLog("Verify product number: "+lsProductNO);

				if(!lsProductNO.isEmpty()){
					reporter.reportLogPass("Product number is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("Product number is not displaying correctly");
				}
			}
			else{
				subItem=item.findElement(byOrderDetailsOrderItemPipeStyleLink);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				lsText=subItem.getText();
				reporter.reportLog("Verify donation item: "+lsText);
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The product pipe style is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The product pipe style is not displaying correctly");
				}
			}


			subItem=item.findElement(byOrderDetailsOrderItemLink);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			boolean bCheckLink=this.checkChildElementExistingByTagName(subItem,"a");
			if(bCheckLink){
				subItem=subItem.findElement(By.xpath(".//a"));
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				if(!subItem.getAttribute("href").isEmpty()){
					reporter.reportLogPass("The product link is not empty");
				}
				else{
					reporter.reportLogFailWithScreenshot("The product link is empty");
				}
			}

			subItem=item.findElement(byOrderDetailsOrderItemImage);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getAttribute("src").isEmpty()){
				reporter.reportLogPass("The image src is not empty");
			}
			else{
				reporter.reportLogFailWithScreenshot("The image src is empty");
			}

			if(checkProductNumberAndWriteReviewButtonExisting(item)){
				subItem=item.findElement(byOrderDetailsOrderItemProductPrice);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				if(!subItem.getText().trim().isEmpty()){
					reporter.reportLogPass("The product price is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The product price is not displaying correctly");
				}
			}

			subItem=item.findElement(byOrderDetailsOrderItemQTYTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().trim().isEmpty()){
				reporter.reportLogPass("The product order QTY title is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product order QTY title is not displaying correctly");
			}

			subItem=item.findElement(byOrderDetailsOrderItemQTY);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().trim().isEmpty()){
				reporter.reportLogPass("The product order QTY is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product order QTY is not displaying correctly");
			}

			subItem=item.findElement(byOrderDetailsOrderItemStatusTitle);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().trim().isEmpty()){
				reporter.reportLogPass("The product order status title is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product order status title is not displaying correctly");
			}

			if(checkProductNumberAndWriteReviewButtonExisting(item)){
				subItem=item.findElement(byOrderDetailsOrderItemWriteReview);
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
				if(!subItem.getText().trim().isEmpty()){
					reporter.reportLogPass("Write a review button is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("Write a review button is not displaying correctly");
				}
			}
		}
	}

	@Override
	public void verifyLandingViewContent() {
		List<WebElement> lstSubItem;
		String lsText;
		WebElement element;
		for (WebElement item : lstAccountSummaryPanelList) {
			element = item.findElement(By.xpath("./div[contains(@class,'panel-heading')]"));
			if (element.getAttribute("class").contains("collapsed")) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
				this.getReusableActionsInstance().clickIfAvailable(element);
				this.getReusableActionsInstance().staticWait(2 * this.getStaticWaitForApplication());
			}
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

	public void clickOnPaymentOptionSubMenuItemsOnMyAccount(String subMenu){
		//Verify if Payment Option sub-menus are open
		boolean menuStatus = Boolean.valueOf(this.getChildElementAttribute(this.lblPaymentOptionMenuItems,"aria-expanded"));
		if(!menuStatus)
			getReusableActionsInstance().clickIfAvailable(this.lblPaymentOptionAccordion,3000);
		super.clickOnPaymentOptionSubMenuItemsOnMyAccount(subMenu);
	}

	@Override
	public int openSubItemWindow(String lsHeaderItem,String lsSubItem,WebElement loadingIndicator){
		String lsTestDevice = System.getProperty("Device").trim();
		if(lsTestDevice.equalsIgnoreCase("Mobile") ||
				(System.getProperty("Device").contains("Tablet") && System.getProperty("Browser").contains("android")) ||
				(System.getProperty("Browser").equalsIgnoreCase("chromemobile") &&
						System.getProperty("Device").contains("Tablet") &&
						!System.getProperty("chromeMobileDevice").contains("iPad"))) {
			WebElement headerButton=this.getHeaderItem(lsHeaderItem);
			if(headerButton.getAttribute("class").contains("collapsed")){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(headerButton);
				this.getReusableActionsInstance().clickIfAvailable(headerButton);
				this.getReusableActionsInstance().staticWait(2*this.getStaticWaitForApplication());
			}
		}

		return super.openSubItemWindow(lsHeaderItem,lsSubItem,loadingIndicator);
	}

}
