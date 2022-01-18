package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.pojo.Product;
import com.tsc.api.pojo.Product.edps;
import com.tsc.api.pojo.ProductDetailsItem;
import com.tsc.api.pojo.SelectedProduct;
import com.tsc.api.util.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiResponse extends ApiConfigs {

    private Map<String,Object> configs = null;
    private int outputPage = 1;
    private int totalPage;
    private String dimensionNumber;
    public SelectedProduct selectedProduct= new SelectedProduct();

    public ApiResponse() throws IOException {}

    /**
     * This method finds product info on the basis of input search keyword with preconditions(video,style,size,brand,badgeImage,review,easyPay,WasPrice,and AddToBag)
     * @param - String - searchKeyword : search keyword for Product
     * @param - Map<String,Object> - outputDataCriteria : criteria for searching a particular product
     * @param - boolean - isSoldOut :true for including soldout criteria and false for not checking soldout criteria 
     * @return - Product.Products - product for search keyword
     */
    public Product.Products getProductInfoFromKeyword(String searchKeyword,Map<String,Object> outputDataCriteria,boolean isSoldOut){
        boolean flag = true;
        String lsNowPrice,lsWasPrice;
        Product.Products productItem=null;
        boolean bSoldout=false;
        
        Product product = getProductDetailsForKeyword(searchKeyword,true);
        if(product==null) {
        	return null;
        }

        do{
            if(outputDataCriteria==null){
                for(Product.Products data:product.getProducts()) {
                	selectedProduct.init();
                	            		
                	lsNowPrice=data.getIsPriceRange();
                	lsWasPrice=data.getWasPriceRange();
                    if (data.getVideosCount() >= 1 && data.getStyles().size() >= 3 && data.getSizes().size() >= 3&&data.isShowBadgeImage()&&data.getProductReviewRating()>0&&!data.getEasyPaymentPrice().isEmpty()&&!lsNowPrice.equalsIgnoreCase(lsWasPrice)&&data.isEnabledAddToCart()) {
                    	if(data.getBrand()!=null) {
                    		if(data.getBrand().isEmpty()) {
                    			continue;
                    		}                    		
                    	}
                    	else {
                    		continue;
                    	}
                    	
                    	List<edps> edpsList=data.getEdps(); 
                    	if(isSoldOut) {
                        	//To check if any Inventory is equal to 0, then get the related Style and Size, 
                        	//which we will use in PDP to select the style and size in order to get soldout information
                        	bSoldout=false;
                        	for(edps Edps:edpsList) {
                        		if(Edps.Inventory==0) {
                        			bSoldout=true;
                        			selectedProduct.productColorForSoldout=Edps.getStyle();
                        			selectedProduct.productSizeForSoldout=Edps.getSize();
                        			break;
                        		}
                        	}
                        	if(!bSoldout) {
                        		continue;
                        	}
                        	else {
                        		//To check if any Inventory is greater than 0, then get the related Style and Size, 
                            	//which we will use in PDP to select the style and size in order to get Enabled AddToBag information
                        		for(edps Edps:edpsList) {
                            		if(Edps.Inventory>0) {                			
                            			selectedProduct.productSizeForEnabledAddToBag=Edps.getStyle();
                            			selectedProduct.productColorForEnabledAddToBag=Edps.getSize();
                            			break;
                            		}
                            	}
                        	}
                    	}
                    	else {
                    		//To check if any Inventory is greater than 0, then get the related Style and Size, 
                        	//which we will use in PDP to select the style and size in order to get Enabled AddToBag information
                    		for(edps Edps:edpsList) {
                        		if(Edps.Inventory>0) {                			
                        			selectedProduct.productSizeForEnabledAddToBag=Edps.getStyle();
                        			selectedProduct.productColorForEnabledAddToBag=Edps.getSize();
                        			break;
                        		}
                        	}
                    	}
                     	
                    	productItem=data;
                        flag = false;
                        selectedProduct.productNumber=data.getItemNo();
                		selectedProduct.productName=data.getName();
                		selectedProduct.productBrand=data.getBrand();
                		selectedProduct.productNowPrice=data.getIsPriceRange();
                		selectedProduct.productWasPrice=data.getWasPriceRange();
                		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+propertyData.get("test_partial_url_pdp")+data.getItemNo();            	
                        break;
                    }
                }
                if(flag) {
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }
                    product = getProductDetailsForKeyword(searchKeyword,false);
                }
            }else{
            	productItem = getProductInfoForInputParams(product,outputDataCriteria,isSoldOut);
                if(productItem==null){
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }                    
                    product = getProductDetailsForKeyword(searchKeyword,false);
                 }else{
                    flag = false;
                }
            }
            
        }while(flag);

        return productItem;
    }

    /**
     * This method find Product Details for search Keyword as api call
     * @param - String - searchKeyword : search keyword for Product
     * @param - boolean - firstTimeFunctionCall : since this method is call multiple times, this parameter
     * determines as if the call is made first time or not
     * @return - Product - Product Object from api Response
     */
    private Product getProductDetailsForKeyword(String searchKeyword,boolean firstTimeFunctionCall){
        Response response = null;
        Product product = null;
        boolean flag = true;
        Map<String, Object> initialConfig=new HashMap<>();
        int repeatNumber=0;
        
        //Clearing config data before start of function if this function call was made previously in test
        if(configs!=null)
            configs.clear();
        if(firstTimeFunctionCall) {
        	outputPage = 1;
        }
    
        if(firstTimeFunctionCall) {
        	initialConfig.put("searchTerm", searchKeyword);        	
        	
            do {
    	        try{
    	            response = getApiCallResponse(initialConfig,propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language")+"/products");    	            
    	        }catch (Exception exception){
    	            exception.printStackTrace();
    	        }

    	        product = JsonParser.getResponseObject(response.asString(), new TypeReference<Product>() {});	       
    	        if(product.getRedirectUrl()!=null) {
    	        	 dimensionNumber = getDimensionNumberFromURL(product.getRedirectUrl());
     	             break;
    	        }
    	        repeatNumber++;
    	        if(repeatNumber==5) {
    	        	return null;
    	        }
            }while(true);
        }

        configs = super.getProductSearchByKeywordInputConfig(searchKeyword, dimensionNumber, outputPage, super.getApiPropertyData().get("test_apiVersion"));
        
        repeatNumber=0;
        do{
        	response = getApiCallResponse(configs, propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language")+"/products");
            if(response!=null && response.statusCode()==200) {
            	product = JsonParser.getResponseObject(response.asString(), new TypeReference<Product>() {
                });

                if (product.getProducts().size() >= 1) {
                	totalPage=product.getPaging().getTotalPages();
                    flag = false;
                } 

                repeatNumber++;
                if(repeatNumber==5) {
                	return null;
                }
            }
        }while(flag);
        
        return product;
    }
    
    /**
     * This method get Product Details for a specific product number as api call
     * @param - String - productNumber : product number for Product
     * @return - ProductDetailsItem - ProductDetailsItem Object from api Response
     */
    public ProductDetailsItem getProductDetailsForSpecificProductNumber(String productNumber){
        Response response = null;
        boolean flag = true;
        int repeatNumber=0;
        ProductDetailsItem product=new ProductDetailsItem();
  
        selectedProduct.init();
        do{
        	response = getApiCallResponse(null, propertyData.get("test_apiVersion2")+"/"+propertyData.get("test_language")+"/products/"+productNumber);
            if(response!=null && response.statusCode()==200) {
            	product = JsonParser.getResponseObject(response.asString(), new TypeReference<ProductDetailsItem>() {
                });
            	
            	selectedProduct.productNumber=product.getItemNo();
        		selectedProduct.productName=product.getName();
        		selectedProduct.productBrand=product.getBrand();
        		selectedProduct.productNowPrice=product.getIsPriceRange();
        		selectedProduct.productWasPrice=product.getWasPriceRange();        	
        		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+product.getName()+propertyData.get("test_partial_url_pdp")+product.getItemNo();
                flag=false;
            }
            else {
            	repeatNumber++;
                if(repeatNumber==5) {
                	return null;
                }
            }
        }while(flag);
        
        return product;
    }

    /**
     * This method makes GET call to api
     * @param - Map<String,Object> - config : input params that are needed for GET call
     * @param - String - apiEndPoint : api endpoint after base URI where call will be made
     * @return - Response - Response from api
     */
    private Response getApiCallResponse(Map<String,Object> config,String apiEndPoint){
    	if(config!=null) {
    		return RestAssured.given().
                    when().params(config).header("Content-Type","application/json").log().all().
                    get(apiEndPoint);
    	}
    	else {
    		return RestAssured.given().
                    when().header("Content-Type","application/json").log().all().
                    get(apiEndPoint);
    	}
    }

    /**
     * This method fetches Dimension Number from returned url
     * @param - String - url : url that contains dimension number
     * @return - String - Dimension Number
     */
    private String getDimensionNumberFromURL(String url){
    	String lsDimension;
    	String lsVersion= super.getApiPropertyData().get("test_apiVersion");

    	if(lsVersion.equalsIgnoreCase("v2")) {
    		lsDimension=url.split(":")[1];    		
    	}
    	else {
    		lsDimension=url.split("=")[1];
    		if(lsDimension.contains(":")) {
    			lsDimension=url.split(":")[1];
    		}
    	}
        return lsDimension;
    }

    /**
     * This method finds product number on the basis of input conditions(video,style,size,brand,badgeImage,review,easyPay,WasPrice,and AddToBag)
     * @param - Product - product : Product class object
     * @param - Map<String,Object> - configs : configs on basis of which product info will be fetched
     * @param - boolean - isSoldOut :true for including soldout criteria and false for not checking soldout criteria 
     * @return - Product.Products - product for search keyword
     */
    private Product.Products getProductInfoForInputParams(Product product,Map<String,Object> configs,boolean isSoldOut){
    	if(product==null) {
        	return null;
        }
    	
        //int videoCount=1,styleCount=3,sizeCount=3;
		int videoCount=0,styleCount=0,sizeCount=0;
        String lsNowPrice,lsWasPrice;
        boolean bSoldout=false;

        if(configs!=null) {
        	for(Map.Entry<String,Object> entry:configs.entrySet()){
                if(entry.getKey().toLowerCase().contains("video"))
                    videoCount = Integer.valueOf(entry.getValue().toString());
                if(entry.getKey().toLowerCase().contains("style")){
                    styleCount = Integer.valueOf(entry.getValue().toString());
                }
                if(entry.getKey().toLowerCase().contains("size")){
                    sizeCount = Integer.valueOf(entry.getValue().toString());
                }                       
            }
         }
        
        selectedProduct.init();
        Product.Products productItem=null;
        for(Product.Products data:product.getProducts()) {
        	lsNowPrice=data.getIsPriceRange();
        	lsWasPrice=data.getWasPriceRange();
            //if(data.getVideosCount()>=videoCount && data.getStyles().size()>=styleCount && data.getSizes().size()>=sizeCount &&data.isShowBadgeImage()&&data.getProductReviewRating()>0&&!data.getEasyPaymentPrice().isEmpty()&&!lsNowPrice.equalsIgnoreCase(lsWasPrice)&&data.isEnabledAddToCart()) {
			if(data.getVideosCount()==videoCount && data.getStyles().size()>=styleCount && data.getSizes().size()>=sizeCount &&data.isShowBadgeImage()&&data.getProductReviewRating()>0&&!data.getEasyPaymentPrice().isEmpty()&&!lsNowPrice.equalsIgnoreCase(lsWasPrice)&&data.isEnabledAddToCart()) {
            	if(data.getBrand()!=null) {
            		if(data.getBrand().isEmpty()) {
            			continue;
            		}            		
            	}
            	else {
            		continue;
            	}
            	
            	List<edps> edpsList=data.getEdps(); 
            	if(isSoldOut) {
                	//To check if any Inventory is equal to 0, then get the related Style and Size, 
                	//which we will use in PDP to select the style and size in order to get soldout information
                	bSoldout=false;
                	for(edps Edps:edpsList) {
                		if(Edps.Inventory==0) {
                			bSoldout=true;
                			selectedProduct.productColorForSoldout=Edps.getStyle();
                			selectedProduct.productSizeForSoldout=Edps.getSize();
                			break;
                		}
                	}
                	if(!bSoldout) {
                		continue;
                	}
                	else {
                		//To check if any Inventory is greater than 0, then get the related Style and Size, 
                    	//which we will use in PDP to select the style and size in order to get Enabled AddToBag information
                		for(edps Edps:edpsList) {
                    		if(Edps.Inventory>0) {                			
                    			selectedProduct.productSizeForEnabledAddToBag=Edps.getStyle();
                    			selectedProduct.productColorForEnabledAddToBag=Edps.getSize();
                    			break;
                    		}
                    	}
                	}
            	}
            	else {
            		//To check if any Inventory is greater than 0, then get the related Style and Size, 
                	//which we will use in PDP to select the style and size in order to get Enabled AddToBag information
            		for(edps Edps:edpsList) {
                		if(Edps.Inventory>0) {                			
                			selectedProduct.productSizeForEnabledAddToBag=Edps.getStyle();
                			selectedProduct.productColorForEnabledAddToBag=Edps.getSize();
                			break;
                		}
                	}
            	}            	
            	
            	productItem=data;
            	selectedProduct.productNumber=data.getItemNo();
        		selectedProduct.productName=data.getName();
        		selectedProduct.productBrand=data.getBrand();
        		selectedProduct.productNowPrice=data.getIsPriceRange();
        		selectedProduct.productWasPrice=data.getWasPriceRange();
        		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+propertyData.get("test_partial_url_pdp")+data.getItemNo();            	
                return productItem;
            }
        }
        return null;
    }
    
    /**
     * This method finds PDP url for Add To Bag enabled product
     * @param - Product - product : Product class object
     * @return - Product.Products - product for search keyword
     */
    private Product.Products getProductOfPDPForAddToBag(Product product){
    	if(product==null) {
        	return null;
        }
        boolean bAddToBag=false;
        
    	selectedProduct.init();
        for(Product.Products data:product.getProducts()) {
        	//To get enabled AddToBag information, we will use to test enabled AddToBag button clicking 
        	if(data.isEnabledAddToCart()) {
        		//To check if any Inventory is greater than 0, then get the related Style and Size, 
            	//which we will use in PDP to select the style and size in order to get Enabled AddToBag information
        		List<edps> edpsList=data.getEdps(); 
        		bAddToBag=false;
        		for(edps Edps:edpsList) {
            		if(Edps.Inventory>0) {  
            			bAddToBag=true;
            			selectedProduct.productSizeForEnabledAddToBag=Edps.getStyle();
            			selectedProduct.productColorForEnabledAddToBag=Edps.getSize();
            			break;
            		}
            	}
        		if(!bAddToBag) {
        			continue;
        		}
        		
        		selectedProduct.productNumber=data.getItemNo();
        		selectedProduct.productName=data.getName();
        		selectedProduct.productBrand=data.getBrand();
        		selectedProduct.productNowPrice=data.getIsPriceRange();
        		selectedProduct.productWasPrice=data.getWasPriceRange();
        		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+propertyData.get("test_partial_url_pdp")+data.getItemNo();
        		
        		return data;        		
        	}
        }
        return null;
    }
    
    /**
     * This method finds PDP url for Add To Bag enabled product on the basis of input search keyword
     * @param - String - searchKeyword : search keyword for Product just for AddToBag
      * @return - Product.Products - product for search keyword
     */
    public Product.Products getProductOfPDPForAddToBagFromKeyword(String searchKeyword){
        boolean flag = true;
        
        Product product = getProductDetailsForKeyword(searchKeyword,true);
        if(product==null) {
        	return null;
        }
  
        Product.Products productItem=null;
        do{
     		productItem = getProductOfPDPForAddToBag(product);
            if(productItem==null){
                outputPage++;
                if(outputPage>totalPage||outputPage>=10) {
                	flag = false;
                }                    
                product = getProductDetailsForKeyword(searchKeyword,false);
             }else{
                flag = false;
            }
            
        }while(flag);

        return productItem;
    }
    
    /**
     * This method finds product info on the basis of input conditions(style,size, and soldout)
     * @param - Product - product : Product class object
     * @param - Map<String,Object> - configs : configs on basis of which product info will be fetched
     * @return - Product.Products - product for search keyword
     */
    private Product.Products getProductInfoForInputParamsWithSoldOutInfo(Product product,Map<String,Object> configs){
    	if(product==null) {
        	return null;
        }
    	
        int styleCount=3,sizeCount=3;
        boolean bSoldout=false;

        if(configs!=null) {
        	for(Map.Entry<String,Object> entry:configs.entrySet()){
                if(entry.getKey().toLowerCase().contains("style")){
                    styleCount = Integer.valueOf(entry.getValue().toString());
                }
                if(entry.getKey().toLowerCase().contains("size")){
                    sizeCount = Integer.valueOf(entry.getValue().toString());
                }                       
            }
         }
  
        selectedProduct.init();
        for(Product.Products data:product.getProducts()) {        	
            if(data.getStyles().size()>=styleCount && data.getSizes().size()>=sizeCount) {
            	
            	//To check if any Inventory is equal to 0, then get the related Style and Size, 
            	//which we will use in PDP to select the style and size in order to get soldout information
            	List<edps> edpsList=data.getEdps(); 
            	bSoldout=false;
            	for(edps Edps:edpsList) {
            		if(Edps.Inventory==0) {
            			bSoldout=true;
            			selectedProduct.productSizeForSoldout=Edps.getStyle();
            			selectedProduct.productColorForSoldout=Edps.getSize();
            			break;
            		}
            	}
            	if(!bSoldout) {
            		continue;
            	}
             	
            	selectedProduct.productNumber=data.getItemNo();
        		selectedProduct.productName=data.getName();
        		selectedProduct.productBrand=data.getBrand();
        		selectedProduct.productNowPrice=data.getIsPriceRange();
        		selectedProduct.productWasPrice=data.getWasPriceRange();        		
        		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+propertyData.get("test_partial_url_pdp")+data.getItemNo();            	
                return data;
            }
        }
        return null;
    }
    
    /**
     * This method finds product info on the basis of input search keyword
     * @param - String - searchKeyword : search keyword for Product
     * @param - Map<String,Object> - outputDataCriteria : criteria for searching a particular product with precondition and soldout condition
     * @return - Product.Products - product for search keyword
     */
    public Product.Products getProductInfoFromKeywordWithSoldOutInfo(String searchKeyword,Map<String,Object> outputDataCriteria){
        boolean flag = true,bSoldout=false;
                
        Product product = getProductDetailsForKeyword(searchKeyword,true);
        if(product==null) {
        	return null;
        }
 
        Product.Products productItem=null;
        do{
            if(outputDataCriteria==null){
            	selectedProduct.init();
                for(Product.Products data:product.getProducts()) {
                	if(data.getStyles().size()>=3 && data.getSizes().size()>=3) {
                    	
                    	//To check if any Inventory is equal to 0, then get the related Style and Size, 
                    	//which we will use in PDP to select the style and size in order to get soldout information
                    	List<edps> edpsList=data.getEdps(); 
                    	bSoldout=false;
                    	for(edps Edps:edpsList) {
                    		if(Edps.Inventory==0) {
                    			bSoldout=true;
                    			selectedProduct.productSizeForSoldout=Edps.getStyle();
                    			selectedProduct.productColorForSoldout=Edps.getSize();
                    			break;
                    		}
                    	}
                    	if(!bSoldout) {
                    		continue;
                    	}
                    	
                        flag = false;
                        selectedProduct.productNumber=data.getItemNo();
                		selectedProduct.productName=data.getName();
                		selectedProduct.productBrand=data.getBrand();
                		selectedProduct.productNowPrice=data.getIsPriceRange();
                		selectedProduct.productWasPrice=data.getWasPriceRange();
                		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+propertyData.get("test_partial_url_pdp")+data.getItemNo();
                		
                		productItem=data;
                        break;
                    }
                }
                if(flag) {
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }
                    product = getProductDetailsForKeyword(searchKeyword,false);
                }
            }else{
            	productItem = getProductInfoForInputParamsWithSoldOutInfo(product,outputDataCriteria);
                if(selectedProduct==null){
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }                    
                    product = getProductDetailsForKeyword(searchKeyword,false);
                 }else{
                    flag = false;
                }
            }
            
        }while(flag);

        return productItem;
    }
    
    /**
     * This method find Product info while search keyword is product number
     * @param - String - searchKeyword : search keyword for Product
     * @return - Product.Products - product for search keyword
     */
    public Product.Products getProductInfoWithProductNumberAsSearchKeyword(String searchKeyword){
        Response response = null;
        Product product = null;
        boolean flag = true;
        int repeatNumber=0;
        
        //Clearing config data before start of function if this function call was made previously in test
        if(configs!=null)
            configs.clear();
 
        configs = super.getProductSearchByKeywordInputConfig(searchKeyword, null, 1, super.getApiPropertyData().get("test_apiVersion"));
        
        repeatNumber=0;
        do{
        	response = getApiCallResponse(configs, propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language")+"/products");
            if(response!=null && response.statusCode()==200) {
            	product = JsonParser.getResponseObject(response.asString(), new TypeReference<Product>() {
                });

                if (product.getProducts().size() >= 1) {
                	totalPage=product.getPaging().getTotalPages();
                    flag = false;
                } 

                repeatNumber++;
                if(repeatNumber==5) {
                	return null;
                }
            }
        }while(flag);

        selectedProduct.init();
		
        if(product!=null) {
        	Product.Products data=product.getProducts().get(0);
        	selectedProduct.productNumber=data.getItemNo();
    		selectedProduct.productName=data.getName();
    		selectedProduct.productBrand=data.getBrand();
    		selectedProduct.productNowPrice=data.getIsPriceRange();
    		selectedProduct.productWasPrice=data.getWasPriceRange();
    		selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+propertyData.get("test_partial_url_pdp")+data.getItemNo();
        }

        return product.getProducts().get(0);
    }
}
