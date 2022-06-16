package com.tsc.api.pojo;

public class SelectedProduct {
	public String productNumber;
	public String productName;
	public String productBrand;
	public String productEDPSize;
	public String productEDPColor;
	public String productNowPrice;
	public String productWasPrice;
	public String pdpNavigationUrl;
	public String easyPayPrice;
	public String productStyleDimensionId;
	
	public SelectedProduct() {
		this.productNumber="";
		this.productName="";
		this.productBrand="";
		this.productEDPSize="";
		this.productEDPColor="";
		this.productNowPrice="";
		this.productWasPrice="";
		this.pdpNavigationUrl="";
		this.easyPayPrice="";
		this.productStyleDimensionId="";
	}

	public SelectedProduct assignValue(SelectedProduct productItem){
		this.productNumber=productItem.productNumber;
		this.productName=productItem.productName;
		this.productBrand=productItem.productBrand;
		this.productEDPSize=productItem.productEDPSize;
		this.productEDPColor=productItem.productEDPColor;
		this.productNowPrice=productItem.productNowPrice;
		this.productWasPrice=productItem.productWasPrice;
		this.pdpNavigationUrl=productItem.pdpNavigationUrl;
		this.easyPayPrice=productItem.easyPayPrice;
		this.productStyleDimensionId=productItem.productStyleDimensionId;

		return this;
	}
	
	public void init() {
		this.productNumber="";
		this.productName="";
		this.productBrand="";
		this.productEDPSize="";
		this.productEDPColor="";
		this.productNowPrice="";
		this.productWasPrice="";
		this.pdpNavigationUrl="";
		this.easyPayPrice="";
		this.productStyleDimensionId="";
	}
}
