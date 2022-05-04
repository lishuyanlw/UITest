package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
		String lsProductNO;
		for(WebElement item:lstOrderDetailsOrderItemList){
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

			subItem=item.findElement(byOrderDetailsOrderItemLink);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getAttribute("href").isEmpty()){
				reporter.reportLogPass("The product link is not empty");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product link is empty");
			}

			subItem=item.findElement(byOrderDetailsOrderItemImage);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getAttribute("src").isEmpty()){
				reporter.reportLogPass("The image src is not empty");
			}
			else{
				reporter.reportLogFailWithScreenshot("The image src is empty");
			}

			subItem=item.findElement(byOrderDetailsOrderItemPipeStyleLink);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getAttribute("href").isEmpty()){
				reporter.reportLogPass("The product pipe style link is not empty");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product pipe style link is empty");
			}

			subItem=item.findElement(byOrderDetailsOrderItemProductPrice);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
			if(!subItem.getText().trim().isEmpty()){
				reporter.reportLogPass("The product price is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product price is not displaying correctly");
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

			subItem=item.findElement(byOrderDetailsOrderItemStatus);
			String lsOrderStatus=this.getElementInnerText(subItem);
			if(!lsOrderStatus.isEmpty()){
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

}
