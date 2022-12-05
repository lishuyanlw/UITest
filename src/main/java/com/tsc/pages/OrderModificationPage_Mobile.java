package com.tsc.pages;

import com.tsc.api.pojo.SelectedProduct;
import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderModificationPage_Mobile extends OrderModificationPage {

	public OrderModificationPage_Mobile(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//shopping-cart//button[normalize-space(text())='CANCEL MODIFICATION'][contains(@class,'cancelModButton')]")
	public WebElement btnModifyOrderCancelModificationButton;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']//div[@id='collapseTwo']//form//div[contains(@class,'visible-xs-block')]//button[@type='submit']")
	public WebElement btnModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyButton;

	@FindBy(xpath = "//shopping-cart//div[@class='cart-contents']//div[@id='mod-options']//div[@class='panel']//div[@id='collapseTwo']//form//div[contains(@class,'visible-xs-block') and contains(@class,'promoNoteDiv')]")
	public WebElement lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyNoteMessage;

	//For newly added order items
	public By byProductQuantityTitleForNewlyAdded=By.xpath(".//div[contains(@class,'visible-xs-inline')]//select/preceding-sibling::strong");
	public By byProductQuantityForNewlyAdded=By.xpath(".//div[contains(@class,'visible-xs-inline')]//select");
	public By byProductNowPrice=By.xpath(".//div[contains(@class,'cart-desc-line') and contains(@class,'visible-xs-block')]//span[contains(@class,'now-price')]");
	public By byProductItemStatusForFreeShipping=By.xpath(".//div[contains(@class,'cart-desc')]//div[contains(@class,'item-status') and not(contains(@class,'hidden-xs'))]|//div[contains(@class,'status-line')]//span[contains(@class,'item-status') and not(contains(@class,'hidden-xs'))]/span[@class='boldBlackColor']");
	public By byProductItemStatusForLowInventoryContainer=By.xpath(".//*[contains(@class,'status-line')]");
	public By byProductItemStatusLowForInventory=By.xpath(".//*[contains(@class,'status-line')]/span[@class='boldRedColor']");

	//For existing order item
	public By byProductQuantity=By.xpath(".//div[contains(@class,'visible-xs-inline') and contains(@class,' tsc-forms')]");

	//Add to Bag popup window part
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__inside-right']//div[contains(@class,'add-to-bag__subtotal')]")
	public WebElement lblAddToBagPopupWindowButtonSectionSubtotal;

	@Override
	public boolean checkProductItemStatusForLowInventoryExisting(WebElement orderItem){
		WebElement itemContainer=orderItem.findElement(byProductItemStatusForLowInventoryContainer);
		return this.checkChildElementExistingByAttribute(itemContainer,"class","boldRedColor");
	}

	@Override
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

	@Override
	public List<Map<String,Object>> getExistingOrderListDesc(){
		List<Map<String,Object>> mapList= new ArrayList<>();
		for(WebElement orderItem:lstExistingOrderList) {
			mapList.add(getOrderItemDesc(orderItem,false));

		}
		return mapList;
	}

	@Override
	public List<Map<String,Object>> getNewlyAddedOrderListDesc(){
		List<Map<String,Object>> mapList= new ArrayList<>();
		for(WebElement orderItem:lstNewlyAddedOrderList) {
			mapList.add(getOrderItemDesc(orderItem,true));

		}
		return mapList;
	}

	@Override
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

				if(new ShoppingCartPage_Mobile(this.getDriver()).checkSelectQuantityEnabled(productItem)){
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

	@Override
	public void subTotal(){
		reporter.softAssert(!this.getElementInnerText(this.lblAddToBagPopupWindowButtonSectionSubtotal).isEmpty(),"The product Subtotal in Add to Bag popup window is not empty","The product Subtotal in Add to Bag popup window is empty");
	}

	@Override
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

	@Override
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
	}

	@Override
	public void verifyModifyOrderChangeModeContents() {
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsAddItemsHeadingTitle);
		this.clickWebElementUsingJS(lblModifyOrderChangeModOptionsAddItemsHeadingTitle);
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
		this.clickWebElementUsingJS(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle);
		this.waitForCondition(Driver->{return this.checkChangeModOptionExpanded(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle);},10000);
		lsText = lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeHeadingTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The AddOrUpdate PromoCode Heading Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The AddOrUpdate PromoCode Heading Title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeLabel);
		lsText = lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeLabel.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The AddOrUpdate PromoCode label is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The AddOrUpdate PromoCode label is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputModifyOrderChangeModOptionsAddOrUpdatePromoCode);
		if (this.getReusableActionsInstance().isElementVisible(inputModifyOrderChangeModOptionsAddOrUpdatePromoCode)) {
			reporter.reportLogPass("The input AddOrUpdate PromoCode is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The input AddOrUpdate PromoCode is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyButton);
		lsText = btnModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyButton.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The AddOrUpdate PromoCode apply button is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The AddOrUpdate PromoCode apply button is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyNoteMessage);
		lsText = lblModifyOrderChangeModOptionsAddOrUpdatePromoCodeApplyNoteMessage.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The AddOrUpdate PromoCode apply note message is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The AddOrUpdate PromoCode apply note message is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblModifyOrderChangeModOptionsOtherChangesHeadingTitle);
		this.clickWebElementUsingJS(lblModifyOrderChangeModOptionsOtherChangesHeadingTitle);
		this.waitForCondition(Driver->{return this.checkChangeModOptionExpanded(lblModifyOrderChangeModOptionsOtherChangesHeadingTitle);},10000);
		lsText = lblModifyOrderChangeModOptionsOtherChangesHeadingTitle.getText();
		if (!lsText.isEmpty()) {
			reporter.reportLogPass("The Other Changes Heading Title is displaying correctly");
		} else {
			reporter.reportLogFailWithScreenshot("The Other Changes Heading Title is not displaying correctly");
		}

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

	@Override
	public void verifyNavigatedPageAfterClickingCancelModificationButton(String lsURL){
		String lsExpectedUrl=this.getBaseURL();
		lsExpectedUrl=lsExpectedUrl+lsURL;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnModifyOrderCancelModificationButton);
		this.clickWebElementUsingJS(btnModifyOrderCancelModificationButton);
		this.waitForCondition(Driver->{return (new MyAccount(this.getDriver())).inputAccountOrderSearch.isDisplayed();},60000);

		if(this.URL().equalsIgnoreCase(lsExpectedUrl)){
			reporter.reportLogPass("Navigated to order status page after clicking cancel modification button.");
		}
		else{
			reporter.reportLogFail("Failed to be navigated to order status page after clicking cancel modification button.");
		}
	}

	@Override
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
	}

	@Override
	public int getOrderAmountFromSubTotalInAddToBagModel(){
		String lsText=this.getElementInnerText(lblAddToBagPopupWindowButtonSectionSubtotal);
		lsText=lsText.split(":")[0];

		return this.getIntegerFromString(lsText);
	}

	@Override
	public float getOrderSubTotalInAddToBagModel(){
		String lsText=this.getElementInnerText(lblAddToBagPopupWindowButtonSectionSubtotal);
		lsText=lsText.split(":")[1];

		return this.getFloatFromString(lsText,true);
	}

	@Override
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

}
