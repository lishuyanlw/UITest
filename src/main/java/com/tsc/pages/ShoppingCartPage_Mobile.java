package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartPage_Mobile extends ShoppingCartPage {

	public ShoppingCartPage_Mobile(WebDriver driver) {
		super(driver);
	}

	public By byProductRedMessage=By.xpath(".//span[contains(@class,'item-status') and contains(@class,'visible-xs-inline')][span[@class='boldRedColor']]");
	public By byProductSelectQuantity=By.xpath(".//div[contains(@class,'tsc-forms') and contains(@class,'visible-xs-inline')]//select");

	@Override
	public boolean checkSelectQuantityEnabled(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductSelectQuantity);
		return !this.hasElementAttribute(item,"disabled");
	}

	@Override
	public boolean checkRedMessageExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductDescContainer);
		return this.checkChildElementExistingByAttribute(item,"class","item-status");
	}

	@Override
	public boolean checkRemoveButtonExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductSelectQuantity);
		return !this.hasElementAttribute(item,"disabled");
	}

	@Override
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
		String[] lsSplit=lsText.split("|");
		map.put("productName",lsSplit[0].trim());
		map.put("productStyle",lsSplit[1].trim());
		map.put("productSize",lsSplit[2].split(":")[1].trim());

		item=cartItem.findElement(byProductNumber);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().trim();
		map.put("productNumber",lsText);

		item=cartItem.findElement(byProductNumber);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().trim();
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
		map.put("productNowPrice",lsText);

		if(!this.checkSelectQuantityEnabled(cartItem)){
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

	@Override
	public Map<String,Object> getShoppingSectionDetails(){
		Map<String,Object> map=new HashMap<>();

		map.put("shoppingList",this.getShoppingItemListDesc());
		map.put("shoppingAmount",this.getShoppingAmount());
		map.put("shoppingSubTotal",this.getShoppingSubTotal());

		return map;
	}

	@Override
	public void verifyContentsBetweenAddToBagAndShoppingCartItem(Map<String,Object> addToBagMap,Map<String,Object> cartItemMap){
		boolean bAddToBagBadge= (boolean) addToBagMap.get("productBadge");
		boolean bShoppingCartBadge=(boolean) cartItemMap.get("productBadge");
		if(bAddToBagBadge==bShoppingCartBadge){
			reporter.reportLogPass("The Badge in AddToBag displaying is the same as shopping cart");
		}
		else{
			reporter.reportLogFail("The Badge in AddToBag:"+bAddToBagBadge+" displaying is not the same as shopping cart:"+bShoppingCartBadge);
		}

		String productNameAddToBag= addToBagMap.get("productName").toString();
		String productNameShoppingCart=cartItemMap.get("productName").toString();
		if(productNameAddToBag==productNameShoppingCart){
			reporter.reportLogPass("The Product name in AddToBag displaying is the same as shopping cart");
		}
		else{
			reporter.reportLogFail("The Product name in AddToBag:"+productNameAddToBag+" displaying is not the same as shopping cart:"+productNameShoppingCart);
		}

		String productStyleAddToBag= addToBagMap.get("productStyle").toString();
		String productStyleShoppingCart=cartItemMap.get("productStyle").toString();
		if(productStyleAddToBag==productStyleShoppingCart){
			reporter.reportLogPass("The Product style in AddToBag displaying is the same as shopping cart");
		}
		else{
			reporter.reportLogFail("The Product style in AddToBag:"+productStyleAddToBag+" displaying is not the same as shopping cart:"+productStyleShoppingCart);
		}

		String productSizeAddToBag= addToBagMap.get("productSize").toString();
		String productSizeShoppingCart=cartItemMap.get("productSize").toString();
		if(productSizeAddToBag==productSizeShoppingCart){
			reporter.reportLogPass("The Product size in AddToBag displaying is the same as shopping cart");
		}
		else{
			reporter.reportLogFail("The Product size in AddToBag:"+productSizeAddToBag+" displaying is not the same as shopping cart:"+productSizeShoppingCart);
		}

		String productNumberAddToBag= addToBagMap.get("productNumber").toString();
		String productNumberShoppingCart=cartItemMap.get("productNumber").toString();
		if(productNumberAddToBag==productNumberShoppingCart){
			reporter.reportLogPass("The Product number in AddToBag displaying is the same as shopping cart");
		}
		else{
			reporter.reportLogFail("The Product number in AddToBag:"+productNumberAddToBag+" displaying is not the same as shopping cart:"+productNumberShoppingCart);
		}

		int productQuantityAddToBag= Integer.parseInt(addToBagMap.get("productQuantity").toString());
		int productQuantityShoppingCart= Integer.parseInt(cartItemMap.get("productQuantity").toString());
		if(productQuantityAddToBag<=productQuantityShoppingCart){
			reporter.reportLogPass("The Product Quantity in AddToBag displaying is no more than the one in shopping cart");
		}
		else{
			reporter.reportLogFail("The Product Quantity in AddToBag:"+productQuantityAddToBag+" displaying is more than the one in shopping cart:"+productQuantityShoppingCart);
		}
	}

	@Override
	public void verifyContentsBetweenAddToBagAndShoppingCartSectionDetails(Map<String,Object> addToBagMap,Map<String,Object> shoppingSectionDetailsMap){
		List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingSectionDetailsMap.get("shoppingList");
		int shoppingAmount= (int) shoppingSectionDetailsMap.get("shoppingAmount");
		float shoppingSubTotal= (float) shoppingSectionDetailsMap.get("shoppingSubTotal");

		for(Map<String,Object> cartItemMap:shoppingList){
			if(this.checkIfMatchGivenAddToBagItem(addToBagMap,cartItemMap)){
				this.verifyContentsBetweenAddToBagAndShoppingCartItem(addToBagMap,cartItemMap);
				break;
			}
		}

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
