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
	public By byProductNowPrice=By.xpath(".//div[contains(@class,'cart-desc-line') and contains(@class,'visible-xs-block')]//span[contains(@class,'now-price')]");

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

		map.put("productFreeShipping",null);

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

	@Override
	public Map<String,Object> getShoppingSectionDetails(){
		Map<String,Object> map=new HashMap<>();

		map.put("shoppingList",this.getShoppingItemListDesc());
		map.put("shoppingAmount",this.getShoppingAmount());
		map.put("shoppingSubTotal",this.getShoppingSubTotal());

		return map;
	}

	@Override
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

	@Override
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

	@Override
	public void verifyQuantityAndPriceBetweenShoppingItemListAndSubTotalSection(Map<String,Object> shoppingCartMap){
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

	@Override
	public boolean checkDuplicatedStyleAndSizeInShoppingItemList(Map<String,Object> shoppingCartMap){
		List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
		String outerName,outerStyle,outerSize,innerName,innerStyle,innerSize;
		int amount;

		for(Map<String,Object> shoppingItemOuter:shoppingList){
			if(shoppingItemOuter.get("productStyle")==null&&shoppingItemOuter.get("productSize")==null){
				continue;
			}
			amount=0;
			outerName= shoppingItemOuter.get("productName").toString();
			outerStyle= shoppingItemOuter.get("productStyle").toString();
			outerSize= shoppingItemOuter.get("productSize").toString();
			for(Map<String,Object> shoppingItemInner:shoppingList){
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

}
