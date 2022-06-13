package com.tsc.api.pojo;

public class SelectedProduct {
	public String productNumber;
	public String productName;
	public String productBrand;
	public String productSizeForSoldout;
	public String productColorForSoldout;
	public String productSizeForEnabledAddToBag;
	public String productColorForEnabledAddToBag;
	public String productNowPrice;
	public String productWasPrice;
	public String pdpNavigationUrl;
	public String easyPayPrice;
	
	public SelectedProduct() {
		this.productNumber="";
		this.productName="";
		this.productBrand="";
		this.productSizeForSoldout="";
		this.productColorForSoldout="";
		this.productSizeForEnabledAddToBag="";
		this.productColorForEnabledAddToBag="";
		this.productNowPrice="";
		this.productWasPrice="";
		this.pdpNavigationUrl="";
		this.easyPayPrice="";
	}
	
	public SelectedProduct(String productNumber,String productName,String productBrand,String productSizeForSoldout,
			String productColorForSoldout,String productSizeForEnabledAddToBag,String productColorForEnabledAddToBag,
			String productNowPrice,String productWasPrice,String pdpNavigationUrl,String easyPayPrice){
		this.productNumber=productNumber;
		this.productName=productName;
		this.productBrand=productBrand;
		this.productSizeForSoldout=productSizeForSoldout;
		this.productColorForSoldout=productColorForSoldout;
		this.productSizeForEnabledAddToBag=productSizeForEnabledAddToBag;
		this.productColorForEnabledAddToBag=productColorForEnabledAddToBag;
		this.productNowPrice=productNowPrice;
		this.productWasPrice=productWasPrice;
		this.pdpNavigationUrl=pdpNavigationUrl;
		this.easyPayPrice=easyPayPrice;
	}

	public SelectedProduct assignValue(SelectedProduct productItem){
		this.productNumber=productItem.productNumber;
		this.productName=productItem.productName;
		this.productBrand=productItem.productBrand;
		this.productSizeForSoldout=productItem.productSizeForSoldout;
		this.productColorForSoldout=productItem.productColorForSoldout;
		this.productSizeForEnabledAddToBag=productItem.productSizeForEnabledAddToBag;
		this.productColorForEnabledAddToBag=productItem.productColorForEnabledAddToBag;
		this.productNowPrice=productItem.productNowPrice;
		this.productWasPrice=productItem.productWasPrice;
		this.pdpNavigationUrl=productItem.pdpNavigationUrl;

		return this;
	}
	
	public void init() {
		this.productNumber="";
		this.productName="";
		this.productBrand="";
		this.productSizeForSoldout="";
		this.productColorForSoldout="";
		this.productSizeForEnabledAddToBag="";
		this.productColorForEnabledAddToBag="";
		this.productNowPrice="";
		this.productWasPrice="";
		this.pdpNavigationUrl="";
		this.easyPayPrice="";
	}
}
