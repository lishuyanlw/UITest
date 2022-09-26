package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class ShoppingCartPage_Mobile extends ShoppingCartPage {

	public ShoppingCartPage_Mobile(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'contents-head') and not(contains(@class,'hidden-xs'))]")
	public WebElement lblCartTopMessage;

	//For Shopping item section
	public By byProductDescContainer=By.xpath(".//div[contains(@class,'status-line')]");
	public By byProductRedMessage=By.xpath(".//span[contains(@class,'item-status') and contains(@class,'visible-xs-inline')][span[@class='boldRedColor']]");
	public By byProductSelectQuantity=By.xpath(".//div[contains(@class,'tsc-forms') and contains(@class,'visible-xs-inline')]//select");
	public By byProductNowPrice=By.xpath(".//div[contains(@class,'cart-desc-line') and contains(@class,'visible-xs-block')]//span[contains(@class,'now-price')]");
	public By byProductShippingDate=By.xpath(".//div[contains(@class,'estimateDate__lineItem--mobileWrapper')]");

	//For OrderSummary section
	@FindBy(xpath = "//div[@class='cartridge']//div[contains(@class,'details-box')]//div[contains(@class,'contents-head')]")
	public WebElement lblCartPricingContentHead;

	@Override
	public boolean checkSelectQuantityEnabled(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductSelectQuantity);
		return !this.hasElementAttribute(item,"disabled");
	}

	@Override
	public boolean checkRedMessageExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductDescContainer);
		return !this.getElementInnerText(item).isEmpty();
	}

	@Override
	public boolean checkRemoveButtonExisting(WebElement cartItem){
		WebElement item=cartItem.findElement(byProductSelectQuantity);
		return !this.hasElementAttribute(item,"disabled");
	}

	/**
	 * To check Contents Head Message In OrderSummary Section Existing
	 * @return - boolean
	 */
	public boolean checkContentsHeadMessageInOrderSummarySectionExisting(){
		return this.checkChildElementExistingByAttribute(this.cntCartPricingDetails,"class","contents-head");
	}

	@Override
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

	@Override
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

	@Override
	public Map<String,Object> getMandatoryShoppingItemDesc(WebElement cartItem){
		Map<String,Object> map=new HashMap<>();

		if(this.checkProductBadgeExisting(cartItem)){
			map.put("productBadge",true);
		}
		else{
			map.put("productBadge",false);
		}

		WebElement item=cartItem.findElement(byProductItemDesc);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		String lsText=item.getText().trim();
		if(lsText.contains("|")){
			String[] lsSplit=lsText.split("\\|");
			if(lsSplit.length==2){
				if(lsSplit[1].contains("Size")){
					map.put("productName",lsSplit[0].trim());
					map.put("productStyle",null);
					map.put("productSize",lsSplit[1].split(":")[1].trim());
				}
				else{
					map.put("productName",lsSplit[0].trim());
					map.put("productStyle",lsSplit[1].split(":")[1].trim());
					map.put("productSize",null);
				}
			}
			else{
				map.put("productName",lsSplit[0].trim());
				map.put("productStyle",lsSplit[2].split(":")[1].trim());
				map.put("productSize",lsSplit[1].split(":")[1].trim());
			}
		}
		else{
			map.put("productName",lsText.trim());
			map.put("productStyle",null);
			map.put("productSize",null);
		}

		if(checkProductNumberExisting(cartItem)){
			item=cartItem.findElement(byProductNumber);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().replace("-","").trim();
			map.put("productNumber",lsText);
		}

		item=cartItem.findElement(byProductNowPrice);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		lsText=item.getText().trim();
		map.put("productNowPrice",this.getFloatFromString(lsText,true));

		item=cartItem.findElement(byProductSelectQuantity);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		Select select = new Select(item);
		lsText=select.getFirstSelectedOption().getText();
		map.put("productQuantity",Integer.parseInt(lsText));

		if(this.checkSelectQuantityEnabled(cartItem)){
			map.put("productQuantityDisabled",false);
		}
		else{
			map.put("productQuantityDisabled",true);
		}

		return map;
	}

	@Override
	public Map<String,Object> getOptionalShoppingItemDesc(WebElement cartItem){
		Map<String,Object> map=new HashMap<>();

		WebElement item;
		String lsText;

		if(this.checkShippingDateExisting(cartItem)){
			item=cartItem.findElement(byProductShippingDate);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productShippingDateTitle",lsText.split(":")[0].trim());
			map.put("productShippingDate",lsText.split(":")[1].trim());
		}
		else{
			map.put("productShippingDateTitle",null);
			map.put("productShippingDate",null);
		}

		if(this.checkRedMessageExisting(cartItem)){
			item=cartItem.findElement(byProductRedMessage);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			lsText=item.getText().trim();
			map.put("productLeftNumber",this.getIntegerFromString(lsText));
		}
		else{
			map.put("productLeftNumber",-1);
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

	@Override
	public List<Map<String,Object>> getShoppingItemListDesc(String lsOption){
		List<Map<String,Object>> mapList=new ArrayList<>();

		for(WebElement cartItem:this.lstCartItems){
			mapList.add(this.getShoppingItemDesc(cartItem,lsOption));
		}

		return mapList;
	}

	@Override
	public Map<String,Object> getShoppingSectionDetails(String lsOption){
		Map<String,Object> map=new HashMap<>();

		map.put("shoppingList",this.getShoppingItemListDesc(lsOption));
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

		if(addToBagMap.get("productStyle")!=null){
			String productStyleAddToBag= addToBagMap.get("productStyle").toString();
			String productStyleShoppingCart=cartItemMap.get("productStyle").toString();
			if(productStyleAddToBag.equalsIgnoreCase(productStyleShoppingCart)){
				reporter.reportLogPass("The Product style in AddToBag displaying is the same as shopping cart");
			}
			else{
				reporter.reportLogFail("The Product style in AddToBag:"+productStyleAddToBag+" displaying is not the same as shopping cart:"+productStyleShoppingCart);
			}
		}

		if(addToBagMap.get("productSize")!=null){
			String productSizeAddToBag= addToBagMap.get("productSize").toString();
			String productSizeShoppingCart=cartItemMap.get("productSize").toString();
			if(productSizeAddToBag.equalsIgnoreCase(productSizeShoppingCart)){
				reporter.reportLogPass("The Product size in AddToBag displaying is the same as shopping cart");
			}
			else{
				reporter.reportLogFail("The Product size in AddToBag:"+productSizeAddToBag+" displaying is not the same as shopping cart:"+productSizeShoppingCart);
			}
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
	public void verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(Map<String,Object> shoppingCartMap){
		List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
		int shoppingAmount= (int) shoppingCartMap.get("shoppingAmount");
		float shoppingSubTotal= (float) shoppingCartMap.get("shoppingSubTotal");

		Map<String,Object> calculateMap=calculateItemCountAndSubTotalFromShoppingCartList(shoppingList);
		int quantityAmount= (int) calculateMap.get("itemCount");
		float priceAmount= (float) calculateMap.get("subTotal");

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
	public boolean checkProductWithSameStyleAndDifferentSizesInShoppingItemList(Map<String,Object> shoppingCartMap){
		List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
		String lsOuterName,lsInnerName;
		Object outerStyle,outerSize,innerStyle,innerSize;
		String lsOuterStyle,lsOuterSize,lsInnerStyle,lsInnerSize;
		int amount;
		int loopSize=shoppingList.size();
		Map<String,Object> shoppingItemOuter,shoppingItemInner;

		for(int i=0; i<loopSize-1;i++){
			shoppingItemOuter=shoppingList.get(i);
			if(shoppingItemOuter.get("productStyle")==null||shoppingItemOuter.get("productSize")==null){
				continue;
			}
			amount=0;
			lsOuterName= shoppingItemOuter.get("productName").toString();
			outerStyle= shoppingItemOuter.get("productStyle");
			outerSize= shoppingItemOuter.get("productSize");
			lsOuterStyle=outerStyle.toString();
			lsOuterSize=outerSize.toString();
			for(int j=i+1;j<loopSize;j++){
				shoppingItemInner=shoppingList.get(j);
				if(shoppingItemInner.get("productStyle")==null||shoppingItemInner.get("productSize")==null){
					continue;
				}
				lsInnerName= shoppingItemInner.get("productName").toString();
				innerStyle= shoppingItemInner.get("productStyle");
				innerSize= shoppingItemInner.get("productSize");
				lsInnerStyle=innerStyle.toString();
				lsInnerSize=innerSize.toString();
				if(lsOuterName.equalsIgnoreCase(lsInnerName)&&lsOuterStyle.equalsIgnoreCase(lsInnerStyle)&&!lsOuterSize.equalsIgnoreCase(lsInnerSize)){
					amount+=1;
				}
			}
			if(amount>=1){
				return true;
			}
		}

		return false;
	}

	@Override
	public void verifyShoppingCartContents(String lsOption){
		switch(lsOption){
			case "mandatory":
				verifyMandatoryOrOptionalShoppingCartContents(true);
				break;
			case "optional":
				verifyMandatoryOrOptionalShoppingCartContents(false);
				break;
			case "all":
				verifyMandatoryOrOptionalShoppingCartContents(true);
				verifyMandatoryOrOptionalShoppingCartContents(false);
				break;
			default:
				break;
		}
	}

	@Override
	public void verifyMandatoryOrOptionalShoppingCartContents(boolean bMandatory){
		String lsText;

		if(bMandatory){
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

				if(checkProductNumberExisting(cartItem)){
					element=cartItem.findElement(byProductNumber);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					lsText=element.getText();
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart item product product number is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart item product number is not displaying correctly");
					}
				}

				if(this.checkRemoveButtonExisting(cartItem)){
					element=cartItem.findElement(byProductRemoveButton);
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
					lsText=element.getText();
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart item remove button is displaying correctly");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart item remove button is not displaying correctly");
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
		else{
			if(this.checkContainPreviouslyAddedItemsMessageExisting()){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblCartContainPreviouslyAddedItemsMessage);
				lsText=this.lblCartContainPreviouslyAddedItemsMessage.getText();
				if(!lsText.isEmpty()){
					reporter.reportLogPass("The Cart Containing Previously Added Items Message is displaying correctly");
				}
				else{
					reporter.reportLogFailWithScreenshot("The Cart Containing Previously Added Items Message is not displaying correctly");
				}
			}

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
			if(lsCartNoticeMessage!=null){
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

					this.applyStaticWait(5*this.getStaticWaitForApplication());
					lsText=lnkCartNoticeTrueFit.getAttribute("href");
					if(!lsText.isEmpty()){
						reporter.reportLogPass("The cart TrueFit link is not empty");
					}
					else{
						reporter.reportLogFailWithScreenshot("The cart TrueFit link is empty");
					}
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

			WebElement element;
			int index=0;
			for(WebElement cartItem:lstCartItems){
				reporter.reportLog("Verify cart item "+index);
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
				index++;
			}
		}
	}

	@Override
	public Map<String,Object> changeShoppingItemQuantityByGivenIndex(int shoppingItemIndex) {
		WebElement shoppingItem = this.lstCartItems.get(shoppingItemIndex);
		WebElement selectQuantity = shoppingItem.findElement(this.byProductSelectQuantity);
		Select select = new Select(selectQuantity);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectQuantity);
		int quantityBeforeChange = this.getIntegerFromString(select.getFirstSelectedOption().getText());
		float price = this.getFloatFromString(this.getElementInnerText(shoppingItem.findElement(this.byProductNowPrice)), true);
		float itemTotalBeforeChange = price * quantityBeforeChange;

		int itemQuantityDifference = 0;
		List<WebElement> quantityOptionItemList = select.getOptions();
		for (WebElement option : quantityOptionItemList) {
			String optionText = this.getElementInnerText(option);
			int optionIndex = Integer.parseInt(optionText.trim());
			if (optionIndex != quantityBeforeChange) {
				itemQuantityDifference = optionIndex - quantityBeforeChange;
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectQuantity);
				select.selectByVisibleText(optionText);
				this.waitForCondition(Driver -> {
					return this.pageLoadingIndicator.getAttribute("style").contains("display: none");
				}, 20000);
				break;
			}
		}

		shoppingItem = this.lstCartItems.get(shoppingItemIndex);
		selectQuantity = shoppingItem.findElement(this.byProductSelectQuantity);
		select = new Select(selectQuantity);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectQuantity);
		int quantityAfterChange = this.getIntegerFromString(select.getFirstSelectedOption().getText());
		price = this.getFloatFromString(this.getElementInnerText(shoppingItem.findElement(this.byProductNowPrice)), true);
		float itemTotalAfterChange = price * quantityAfterChange;

		Map<String, Object> map = new HashMap<>();
		map.put("itemTotalDifference", itemTotalAfterChange - itemTotalBeforeChange);
		map.put("itemQuantityDifference", itemQuantityDifference);

		return map;
	}

	@Override
	public boolean chooseShoppingItemByGivenItemIndexAndQuantity(int shoppingItemIndex,int quantity) {
		WebElement shoppingItem = this.lstCartItems.get(shoppingItemIndex);
		WebElement selectQuantity = shoppingItem.findElement(this.byProductSelectQuantity);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectQuantity);
		Select select = new Select(selectQuantity);
		select.selectByVisibleText(String.valueOf(quantity));

		return this.waitForCondition(Driver -> {
			return this.pageLoadingIndicator.getAttribute("style").contains("display: none");
		}, 20000);
	}

	@Override
	public void verifyBlueJayDonationAdditionInCart(String jayCareAddedAmount,String jayCareFoundationMessage){
		boolean flag = false;
		if(this.lstCartItems.size()>0){
			if(!jayCareAddedAmount.contains("."))
				jayCareAddedAmount = jayCareAddedAmount+".00";
			for(WebElement element:this.lstCartItems){
				String jayCareDescription = element.findElement(this.byProductItemDesc).getText();
				if(jayCareDescription.contains(jayCareFoundationMessage)){
					flag = true;
					String donationAmount = element.findElement(this.byProductNowPrice).getText();
					if(donationAmount.equalsIgnoreCase(jayCareAddedAmount))
						reporter.reportLogPassWithScreenshot("Jay Care Foundation Donation is added with amount: "+donationAmount+" as expected");
					else
						reporter.reportLogFailWithScreenshot("Jay Care Foundation Donation is not added with amount: "+donationAmount+" as expected");
				}
				if(flag)
					break;
			}
		}else
			reporter.reportLogFailWithScreenshot("No item is present in cart for user");

		if(flag)
			reporter.reportLog("Verification for Blue Jays Foundation is done as expected");
		else
			reporter.reportLogFailWithScreenshot("Blue Jays Foundation verification is not done!!");
	}

	@Override
	public void verifyPayPalPopUpExistenceOnClick(){
		//https://sqa.stackexchange.com/questions/46791/error-with-driver-switchto-window-complaining-that-something-isnt-a-string
		boolean flag = false;
		List<String> parentWindowHandle = new ArrayList<>(this.getDriver().getWindowHandles());
		//Switch to PayPal frame
		this.getDriver().switchTo().frame(framePayPalFrameElement);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnPayPalButton);
		this.waitForCondition(Driver->{return this.btnPayPalButton.isEnabled();},6000);
		this.clickWebElementUsingJS(this.btnPayPalButton);
		this.waitForCondition(Driver->{return this.getDriver().getWindowHandles().size()>1;},5000);
		ArrayList<String> openTabs = new ArrayList<> (this.getDriver().getWindowHandles());
		if(openTabs.size()>1){
			for(String windowHandle:openTabs){
				if(!windowHandle.equalsIgnoreCase(parentWindowHandle.get(0))){
					flag = true;
					this.getDriver().switchTo().window(windowHandle);
					this.waitForCondition(Driver->{return this.getReusableActionsInstance().isElementVisible(this.inputPayPalEmailInput) && this.inputPayPalEmailInput.isEnabled();},10000);
					String payPalUrl = this.getDriver().getCurrentUrl();
					if(payPalUrl.contains("paypal.com"))
						reporter.reportLogPass("User is navigated to PayPal pop up as expected");
					else
						reporter.reportLogFail("User is not navigated to PayPal pop up as expected with url: "+payPalUrl);

					//Verification of email input box
					if(this.getReusableActionsInstance().isElementVisible(this.inputPayPalEmailInput) && this.inputPayPalEmailInput.isEnabled())
						reporter.reportLog("Email Input on Pay Pal Pop Up is enabled");
					else
						reporter.reportLogFailWithScreenshot("Email input on Pay Pal pop up is either not displayed or not enabled");

					this.getDriver().close();
				}
				if(flag){
					this.getReusableActionsInstance().switchToMainWindow(parentWindowHandle.get(0));
					break;
				}
			}
			if(flag)
				reporter.reportLogPass("Verification for pay pal pop is done");
			else
				reporter.reportLogFailWithScreenshot("Verification for pay pal pop is not done as expected!");
		}else
			reporter.reportLogFailWithScreenshot("Pay Pal pop up is not displayed as expected");
	}
}
