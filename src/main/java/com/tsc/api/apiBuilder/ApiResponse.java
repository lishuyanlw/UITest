package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.pojo.*;
import com.tsc.api.pojo.Product.edps;
import com.tsc.api.util.DataConverter;
import com.tsc.api.util.JsonParser;
import extentreport.ExtentTestManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ApiResponse extends ApiConfigs {

    private Map<String,Object> configs = null;
    private int outputPage = 1;
    private int totalPage;
    private String dimensionNumber;
    public SelectedProduct selectedProduct= new SelectedProduct();
    boolean bBrand=false;
	public static Map<String, String> apiProperty;
	public static String lsUrlType="";


    public ApiResponse() throws IOException {
		apiProperty = this.getApiInfo();
	}

	/**
	 * This method get api User session token for authenticated api calls
	 * @param - String - userName for getting session key that is present in application
	 * @param - String - password for username provided above
	 * @param - String - apiKey value that is constant value provided
	 * @param - String - grant_type that is set as password
	 * @return - JSONObject that contains session key and other info
	 */
	public org.json.JSONObject getApiUserSessionData(String userName, String password, String grant_type, String apiKey) throws IOException {
		setApiClient(apiProperty.get("test_qaURL"));
		//Api Call to get access token
		Response response = given().
				contentType("application/x-www-form-urlencoded").
				header("cache-control","no-cache").
				formParam("userName",userName).
				formParam("password",password).
				formParam("grant_type",grant_type).
				formParam("AppKey",apiKey).
				formParam("recaptchaRequired","false").
				when().post("/api/token").
				then().extract().response();

		org.json.JSONObject apiSessionInfo = new org.json.JSONObject();
		if(response.statusCode()==200){
			//Return object containing api access token and expiration time
			apiSessionInfo.put("access_token",response.jsonPath().get("access_token").toString());
			apiSessionInfo.put("refresh_token",response.jsonPath().get("refresh_token").toString());
			apiSessionInfo.put("customerEDP",response.jsonPath().get("customerEDP").toString());
			apiSessionInfo.put("refreshExpireInSeconds",response.jsonPath().get("refreshExpireInSeconds").toString());
			apiSessionInfo.put("expiration_time",response.jsonPath().get("'.expires'").toString());
		}else{
			System.out.println("User status code: "+response.statusCode());
			new ExtentTestManager().reportLogFail("Session Info for api is not fetched as expected..Run again!!");
		}

		return apiSessionInfo;
	}

	/**
	 * This method get api App session token for authenticated api calls
	 * @param - String - userName for getting session key that is present in application
	 * @param - String - password for username provided above
	 * @param - String - grant_type that is set as password
	 * @param - String - access token from user authentication
	 * @return - JSONObject that contains session key and other info
	 */
	public org.json.JSONObject getApiAppSessionData(String userName, String password, String grant_type,String access_token) throws IOException {
		setApiClient(apiProperty.get("test_qaURL"));
		//Api Call to get access token
		Response response = given().
				contentType("application/x-www-form-urlencoded").
				header("Authorization",
						"Bearer " + access_token).
				formParam("userName",userName).
				formParam("password",password).
				formParam("grant_type",grant_type).
				when().post("/api/token").
				then().extract().response();

		org.json.JSONObject apiSessionInfo = new org.json.JSONObject();
		if(response.statusCode()==200){
			//Return object containing api access token and expiration time
			apiSessionInfo.put("access_token",response.jsonPath().get("access_token").toString());
			apiSessionInfo.put("refresh_token",response.jsonPath().get("refresh_token").toString());
			apiSessionInfo.put("customerEDP",response.jsonPath().get("customerEDP").toString());
			apiSessionInfo.put("refreshExpireInSeconds",response.jsonPath().get("refreshExpireInSeconds").toString());
			apiSessionInfo.put("expiration_time",response.jsonPath().get("'.expires'").toString());
		}else{
			System.out.println("App Status code: "+response.statusCode());
			new ExtentTestManager().reportLogFail("Session Info for api is not fetched as expected..Run again!!");
		}

		return apiSessionInfo;
	}

	/**
	 *This method adds credit card details to user
	 * @param-JSONObject jsonObject containing credit card details to be added
	 * @param-String customerEDP for CC addition
	 * @param-String access_token required for api call
	 * @return-Response response object after api call
	 */
	public Response addCreditCardToUser(org.json.simple.JSONObject jsonObject, String customerEDP, String access_token) throws JsonProcessingException {
		return postApiCallResponseAfterAuthenticationFromJSON(jsonObject, propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language")+"/accounts/"+customerEDP+"/creditcards",access_token);
	}

	/**
	 * @param - customerEDP - Customer EDP Number where cart is created
	 * @param - access_token - access token for api authentication
	 * @return - Response - API Response after AccountCart GET calling
	 */
	public Response getAccountCartContentWithCustomerEDP(String customerEDP, String access_token) {
		return getApiCallResponseAfterAuthentication(null, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/" + customerEDP + "/cart", access_token);
	}

    /**
     * This method finds product info on the basis of input search keyword with preconditions(video,style,size,brand,badgeImage,review,easyPay,WasPrice,and AddToBag)
     * @param - String - searchKeyword : search keyword for Product
     * @param - Map<String,Object> - outputDataCriteria : criteria for searching a particular product
     * @param - boolean - isSoldOut - true for including soldout criteria and false for not checking soldout criteria
	 * @param - boolean - basicCheck - Check default settings
	 * @param - boolean - isMultiStyleAndSize
     * @return - Product.Products - product for search keyword
     */
    public Product.Products getProductInfoFromKeyword(String searchKeyword,Map<String,Object> outputDataCriteria,boolean isSoldOut,boolean basicCheck,boolean isMultiStyleAndSize){
        boolean flag = true;
        String lsNowPrice,lsWasPrice;
        Product.Products productItem=null;

        Product product = getProductDetailsForKeyword(searchKeyword,null,true);
        if(product==null) {
        	return null;
        }

		ProductDetailsItem productDetailsItem=null;
    	selectedProduct.init();
        do{
            if(outputDataCriteria==null){
                for(Product.Products data:product.getProducts()) {
                	lsNowPrice=data.getIsPriceRange();
                	lsWasPrice=data.getWasPriceRange();
                    if (data.getVideosCount() >= 1 && data.getStyles().size() >= 1 && data.getSizes().size() >= 1&&data.isShowBadgeImage()&&data.getProductReviewRating()>0&&data.getProductReviewCount()>0&&!lsNowPrice.equalsIgnoreCase(lsWasPrice)&&data.isEnabledAddToCart()) {
                    	if(data.getBrand()!=null) {
                    		if(data.getBrand().isEmpty()) {
                    			continue;
                    		}                    		
                    	}
                    	else {
                    		continue;
                    	}

						productDetailsItem=getProductDetailsForSpecificProductNumber(data.getItemNo());
						List<ProductDetailsItem.Edp> edpsList=productDetailsItem.getEdps();
						if(isSoldOut) {
							//To check if any Inventory is equal to 0, then get the related Style and Size,
							//which we will use in PDP to select the style and size in order to get soldout information
							for(ProductDetailsItem.Edp Edps:edpsList) {
								if(Edps.Inventory==0) {
									selectedProduct.productEDPColor=Edps.getStyle();
									selectedProduct.productEDPSize=Edps.getSize();
									break;
								}
							}
						}
						else {
							//To check if any Inventory is greater than 0, then get the related Style and Size,
							//which we will use in PDP to select the style and size in order to get Enabled AddToBag information
							List<ProductDetailsItem.Edp> dataList=edpsList.stream().filter(item->item.getInventory()>0).sorted((p1,p2)->p1.getStyle().compareTo(p2.getStyle())).collect(Collectors.toList());
							String checkStyle="NoStyle";
							int count=-1,amount=-1;
							for(ProductDetailsItem.Edp Edps:dataList) {
								if(isMultiStyleAndSize){
									if(checkStyle.equalsIgnoreCase(Edps.getStyle())){
										count+=1;
									}
									else{
										if(count>0){
											selectedProduct.productEDPSize=selectedProduct.productEDPSize+checkStyle+"|";
											selectedProduct.productEDPColor=selectedProduct.productEDPColor+checkStyle+"|";
											amount+=1;
										}
										checkStyle=Edps.getStyle();
										count=0;
									}

									if(amount>0){
										break;
									}
								}
								else{
									selectedProduct.productEDPSize=Edps.getSize();
									selectedProduct.productEDPColor=Edps.getStyle();
									break;
								}

//								if(Edps.Inventory>0) {
//									selectedProduct.productEDPSize=Edps.getSize();
////								selectedProduct.productEDPColor=Edps.getStyle();
////								break;
//								}
							}
						}

						productItem=data;
                        flag = false;
                        selectedProduct.productNumber=data.getItemNo();
                		selectedProduct.productName=data.getName();
                		selectedProduct.productBrand=data.getBrand();
                		selectedProduct.productNowPrice=data.getIsPriceRange();
                		selectedProduct.productWasPrice=data.getWasPriceRange();
						if(!lsUrlType.isEmpty()){
							selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim().replace(".","").replace(" ","-")+propertyData.get("test_partial_url_pdp")+data.getItemNo();
						}
						else{
							selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim()+propertyData.get("test_partial_url_pdp")+data.getItemNo();
						}

                        break;
                    }
                }
                if(flag) {
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }
                    product = getProductDetailsForKeyword(searchKeyword,null,false);
                }
            }else{
            	productItem = getProductInfoForInputParams(product,outputDataCriteria,isSoldOut,basicCheck,isMultiStyleAndSize);
                if(productItem==null){
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }
                    String defaultItemCount = null;
                    if(outputDataCriteria.get("pageSize")!=null)
                    	defaultItemCount = outputDataCriteria.get("pageSize").toString();
                    product = getProductDetailsForKeyword(searchKeyword,defaultItemCount,false);
                 }else{
                	selectedProduct.productNumber=productItem.getItemNo();
             		selectedProduct.productName=productItem.getName();
             		selectedProduct.productBrand=productItem.getBrand();
             		selectedProduct.productNowPrice=productItem.getIsPriceRange();
             		selectedProduct.productWasPrice=productItem.getWasPriceRange();
					if(!lsUrlType.isEmpty()){
						selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+productItem.getName().trim().replace(".","").replace(" ","-")+propertyData.get("test_partial_url_pdp")+productItem.getItemNo();
					}
					else{
						selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+productItem.getName().trim()+propertyData.get("test_partial_url_pdp")+productItem.getItemNo();
					}

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
    private Product getProductDetailsForKeyword(String searchKeyword,String defaultPageItems,boolean firstTimeFunctionCall){
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
        	bBrand=false;
        	initialConfig.put("searchTerm", searchKeyword);        	
        	
            do {
    	        try{
    	            response = getApiCallResponse(initialConfig,propertyData.get("test_apiVersion3")+"/"+propertyData.get("test_language")+"/products");
    	        }catch (Exception exception){
    	            exception.printStackTrace();
    	        }

    	        product = JsonParser.getResponseObject(response.asString(), new TypeReference<Product>() {});
    	        if(product.getProducts()==null) {
    	        	if(product.getRedirectUrl()!=null) {
       	        	 	 dimensionNumber = getDimensionNumberFromURL(product.getRedirectUrl());
       	        	 	 bBrand=false;
        	             break;
	       	        }	       	        
    	        }
    	        else {
    	        	bBrand=true;
    	        	return product;
    	        }
    	        repeatNumber++;
       	        if(repeatNumber==5) {
       	        	return null;
       	        }
    	        
            }while(true);
        }
        
        if(bBrand) {
        	configs = super.getProductSearchByKeywordInputConfig(searchKeyword, null, outputPage, defaultPageItems,super.getApiPropertyData().get("test_apiVersion3"));
        }
        else {
        	configs = super.getProductSearchByKeywordInputConfig(searchKeyword, dimensionNumber, outputPage, defaultPageItems,super.getApiPropertyData().get("test_apiVersion3"));
        }
        
        
        repeatNumber=0;
        do{
        	response = getApiCallResponse(configs, propertyData.get("test_apiVersion3")+"/"+propertyData.get("test_language")+"/products");
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
        //boolean flag = true;
        //int repeatNumber=0;
        ProductDetailsItem product=new ProductDetailsItem();
  
        selectedProduct.init();
        //do{
		response = getApiCallResponse(null, propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language")+"/products/"+productNumber);
		if(response!=null && response.statusCode()==200) {
			product = JsonParser.getResponseObject(response.asString(), new TypeReference<ProductDetailsItem>() {
			});
		selectedProduct.productNumber=product.getItemNo();
		selectedProduct.productName=product.getName();
		selectedProduct.productBrand=product.getBrand();
		selectedProduct.productNowPrice=product.getIsPriceRange();
		selectedProduct.productWasPrice=product.getWasPriceRange();
		if(!lsUrlType.isEmpty()){
			selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+product.getName().trim().replace(".","").replace(" ","-")+propertyData.get("test_partial_url_pdp")+product.getItemNo();
		}
		else{
			selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+product.getName().trim()+propertyData.get("test_partial_url_pdp")+product.getItemNo();
		}

		//flag=false;
        }
          /*  else {
            	repeatNumber++;
                if(repeatNumber==5) {
                	return null;
                }
            }
        }while(flag);*/
        
        return product;
    }

    /**
     * This method makes GET call to api
     * @param - Map<String,Object> - config : input params that are needed for GET call
     * @param - String - apiEndPoint : api endpoint after base URI where call will be made
     * @return - Response - Response from api
     */
    public Response getApiCallResponse(Map<String,Object> config,String apiEndPoint){
    	if(config!=null) {
    		return RestAssured.given().
                    when().params(config).header("Content-Type","application/json").
                    get(apiEndPoint);
    	}
    	else {
    		return RestAssured.given().
                    when().header("Content-Type","application/json").
                    get(apiEndPoint);
    	}
    }

    /**
     * This method fetches Dimension Number from returned url
     * @param - String - url : url that contains dimension number
     * @return - String - Dimension Number
     */
    public String getDimensionNumberFromURL(String url){
    	String lsDimension;
    	String lsVersion= super.getApiPropertyData().get("test_apiVersion3");

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
	 * @param - boolean - basicCheck - check with default settings
     * @return - Product.Products - product for search keyword
     */
    private Product.Products getProductInfoForInputParams(Product product,Map<String,Object> configs,boolean isSoldOut,boolean basicCheck,boolean isMultiStyleAndSize){
    	if(product==null) {
        	return null;
        }
    	
        int videoCount=-1,styleCount=3,sizeCount=3,quantity=0;
		String lsNowPrice,lsWasPrice;

        if(configs!=null) {
        	for(Map.Entry<String,Object> entry:configs.entrySet()){
                if(entry.getKey().toLowerCase().contains("video"))
                    videoCount = Integer.valueOf(entry.getValue().toString());
                if(entry.getKey().toLowerCase().contains("style")){
                    styleCount = Integer.valueOf(entry.getValue().toString());
                }
                if(entry.getKey().equalsIgnoreCase("size")){
                    sizeCount = Integer.valueOf(entry.getValue().toString());
                }
                if(entry.getKey().toLowerCase().contains("quantity")){
                	quantity = Integer.valueOf(entry.getValue().toString());
				}
            }
         }
 
        Product.Products productItem=null;
		ProductDetailsItem productDetailsItem=null;
        for(Product.Products data:product.getProducts()) {
        	lsNowPrice=data.getIsPriceRange();
        	lsWasPrice=data.getWasPriceRange();
            boolean flag = false;
			if(basicCheck) {
				if(videoCount!=-1){
					flag = (videoCount==0 ? data.getVideosCount()==videoCount : data.getVideosCount()>=videoCount)&&data.getStyles().size() >= styleCount && data.getSizes().size() >= sizeCount;
				}
				else{
					flag = data.getStyles().size() >= styleCount && data.getSizes().size() >= sizeCount;
				}
			}
			else {
				if(videoCount!=-1){
					flag = (videoCount==0 ? data.getVideosCount()==videoCount : data.getVideosCount()>=videoCount) && data.getStyles().size() >= styleCount && data.getSizes().size() >= sizeCount && data.isShowBadgeImage() && data.getProductReviewRating() > 0 &&data.getProductReviewCount()>0&& !lsNowPrice.equalsIgnoreCase(lsWasPrice) && data.isEnabledAddToCart();
				}
				else{
					flag = data.getStyles().size() >= styleCount && data.getSizes().size() >= sizeCount && data.isShowBadgeImage() && data.getProductReviewRating() > 0 &&data.getProductReviewCount()>0&& !lsNowPrice.equalsIgnoreCase(lsWasPrice) && data.isEnabledAddToCart();
				}
			}
			if(flag) {
				if(!basicCheck){
					if(data.getBrand()!=null) {
						if(data.getBrand().isEmpty()) {
							continue;
						}
					}
					else {
						continue;
					}
				}

				productDetailsItem=getProductDetailsForSpecificProductNumber(data.getItemNo());
            	List<ProductDetailsItem.Edp> edpsList=productDetailsItem.getEdps();
            	if(isSoldOut) {
                	//To check if any Inventory is equal to 0, then get the related Style and Size, 
                	//which we will use in PDP to select the style and size in order to get soldout information
                	for(ProductDetailsItem.Edp Edps:edpsList) {
                		if(Edps.Inventory==0) {
                			selectedProduct.productEDPColor=Edps.getStyle();
                			selectedProduct.productEDPSize=Edps.getSize();
                			break;
                		}
                	}
            	}
            	else {
            		//To check if any Inventory is greater than 0, then get the related Style and Size, 
                	//which we will use in PDP to select the style and size in order to get Enabled AddToBag information
					final int tmpInt=quantity;
					List<ProductDetailsItem.Edp> dataList=edpsList.stream().filter(item->item.getInventory()>tmpInt).sorted((p1,p2)->p1.getStyle().compareTo(p2.getStyle())).collect(Collectors.toList());
					String checkStyle="NoStyle";
					int count=-1,amount=-1;
					for(ProductDetailsItem.Edp Edps:dataList) {
						if (isMultiStyleAndSize) {
							if (checkStyle.equalsIgnoreCase(Edps.getStyle())) {
								count += 1;
							} else {
								if (count > 0) {
									selectedProduct.productEDPSize = selectedProduct.productEDPSize + checkStyle + "|";
									selectedProduct.productEDPColor = selectedProduct.productEDPColor + checkStyle + "|";
									amount += 1;
								}
								checkStyle = Edps.getStyle();
								count = 0;
							}

							if (amount > 0) {
								break;
							}
						} else {
							selectedProduct.productEDPSize = Edps.getSize();
							selectedProduct.productEDPColor = Edps.getStyle();
							break;
						}

//            		for(ProductDetailsItem.Edp Edps:edpsList) {
//                		if(Edps.Inventory>quantity) {
//                			selectedProduct.productEDPSize=Edps.getSize();
//                			selectedProduct.productEDPColor=Edps.getStyle();
//                			break;
//                		}
//                	}
					}
            	}            	
            	
            	productItem=data;
            	            	            	
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
            			selectedProduct.productEDPSize=Edps.getSize();
            			selectedProduct.productEDPColor=Edps.getStyle();
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
				if(!lsUrlType.isEmpty()){
					selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim().replace(".","").replace(" ","-")+propertyData.get("test_partial_url_pdp")+data.getItemNo();
				}
				else{
					selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim()+propertyData.get("test_partial_url_pdp")+data.getItemNo();
				}

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
        
        Product product = getProductDetailsForKeyword(searchKeyword,null,true);
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
                product = getProductDetailsForKeyword(searchKeyword,null,false);
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
            			selectedProduct.productEDPSize=Edps.getSize();
            			selectedProduct.productEDPColor=Edps.getStyle();
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
				if(!lsUrlType.isEmpty()){
					selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim().replace(".","").replace(" ","-")+propertyData.get("test_partial_url_pdp")+data.getItemNo();
				}
				else{
					selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim()+propertyData.get("test_partial_url_pdp")+data.getItemNo();
				}

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
                
        Product product = getProductDetailsForKeyword(searchKeyword,null,true);
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
                    			selectedProduct.productEDPSize=Edps.getSize();
                    			selectedProduct.productEDPColor=Edps.getStyle();
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
						if(!lsUrlType.isEmpty()){
							selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim().replace(".","").replace(" ","-")+propertyData.get("test_partial_url_pdp")+data.getItemNo();
						}
						else{
							selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim()+propertyData.get("test_partial_url_pdp")+data.getItemNo();
						}

                		productItem=data;
                        break;
                    }
                }
                if(flag) {
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }
                    product = getProductDetailsForKeyword(searchKeyword,null,false);
                }
            }else{
            	productItem = getProductInfoForInputParamsWithSoldOutInfo(product,outputDataCriteria);
                if(selectedProduct==null){
                    outputPage++;
                    if(outputPage>totalPage||outputPage>=10) {
                    	flag = false;
                    }                    
                    product = getProductDetailsForKeyword(searchKeyword,null,false);
                 }else{
                    flag = false;
                }
            }
            
        }while(flag);

        if(bSoldout) {
        	return productItem;
        }
        else {
        	return null;
        }
        
    }

	/**
	 * This method finds product info on the basis of input search keyword that contains Easy Pay, Reviews, True Fit and Size Chart
	 * @param - String - searchKeyword : search keyword for Product
	 * @param - Map<String,Object> - outputDataCriteria : criteria for searching a particular product with precondition
	 * @return - Product.Products - product for search keyword
	 */
	public Product.Products getProductInfoFromKeywordWithEasyPayReviewsTrueFitAndSizeChart(String searchKeyword,Map<String,Object> outputDataCriteria){
		boolean flag = true, loopBreakFlag=false;

		Product product = getProductDetailsForKeyword(searchKeyword,null,true);
		if(product==null) {
			return null;
		}

		Product.Products productItem=null;
		do{
			if(outputDataCriteria==null){
				productItem = getProductInfoWithEasyPayReviewTrueFitSizeChartForConfig(product,null);
				if(productItem!=null)
					flag = false;
				if(flag) {
					outputPage++;
					if(outputPage>totalPage||outputPage>=10) {
						flag = false;
					}
					product = getProductDetailsForKeyword(searchKeyword,null,false);
				}
			}else{
				productItem = getProductInfoWithEasyPayReviewTrueFitSizeChartForConfig(product,outputDataCriteria);
				if(productItem==null){
					outputPage++;
					if(outputPage>totalPage||outputPage>=10) {
						flag = false;
					}
					product = getProductDetailsForKeyword(searchKeyword,null,false);
				}else{
					flag = false;
				}
			}

		}while(flag);

		return productItem;


	}

	/**
	 * This method finds product info on the basis of input conditions
	 * @param - Product - product : Product class object
	 * @param - Map<String,Object> - configs : configs on basis of which product info will be fetched
	 * @return - Product.Products - product for search keyword
	 */
	private Product.Products getProductInfoWithEasyPayReviewTrueFitSizeChartForConfig(Product product,Map<String,Object> config){
		if(product==null) {
			return null;
		}

		int styleCount=1,sizeCount=1;
		boolean loopBreakFlag=false;

		if(config!=null) {
			for(Map.Entry<String,Object> entry:config.entrySet()){
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
			if(data.getStyles().size()>=styleCount && data.getSizes().size()>=sizeCount && data.getProductReviewCount()>=3 && data.isEnabledAddToCart()){
				List<edps> edpsList = data.getEdps();
				loopBreakFlag = false;
				for (edps Edps : edpsList) {
					if (!Edps.isSoldOut() == true && Edps.Inventory > 0 && data.getInstallments() > 1) {
						if (data.getInstallments() > 1) {
							List<Sections> sections = this.getSectionDetailsFromProductNumber(data.getItemNo());
							if (sections.size() > 0) {
								for (int counter = 0; counter < sections.size(); counter++) {
									if (sections.get(counter).getName().contains("Size")) {
										selectedProduct.productNumber = data.getItemNo();
										selectedProduct.productName = data.getName();
										selectedProduct.productBrand = data.getBrand();
										selectedProduct.productNowPrice = data.getIsPriceRange();
										selectedProduct.productWasPrice = data.getWasPriceRange();
										selectedProduct.easyPayPrice=Edps.getEasyPaymentPrice();
										if(!lsUrlType.isEmpty()){
											selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim().replace(".","").replace(" ","-")+propertyData.get("test_partial_url_pdp")+data.getItemNo();
										}
										else{
											selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim()+propertyData.get("test_partial_url_pdp")+data.getItemNo();
										}

										return data;
									}
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
    
    /**
     * This method find Product info while search keyword is product number
     * @param - String - searchKeyword : search keyword for Product
     * @return - Product.Products - product for search keyword
     */
    public Product.Products getProductInfoWithProductNumberAsSearchKeyword(String searchKeyword, String defaultPageItems){
        Response response = null;
        Product product = null;
        boolean flag = true;
        int repeatNumber=0;
        
        //Clearing config data before start of function if this function call was made previously in test
        if(configs!=null)
            configs.clear();
 
        configs = super.getProductSearchByKeywordInputConfig(searchKeyword, null, 1, defaultPageItems, super.getApiPropertyData().get("test_apiVersion3"));
        
        repeatNumber=0;
        do{
        	response = getApiCallResponse(configs, propertyData.get("test_apiVersion3")+"/"+propertyData.get("test_language")+"/products");
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
			if(!lsUrlType.isEmpty()){
				selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim().replace(".","").replace(" ","-")+propertyData.get("test_partial_url_pdp")+data.getItemNo();
			}
			else{
				selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName().trim()+propertyData.get("test_partial_url_pdp")+data.getItemNo();
			}

        }

        return product.getProducts().get(0);
    }
    
    /**
     * This method finds product info with AdvanceOrder info
     * @param - String - searchKeyword : search keyword for Product
     * @return - ProductDetailsItem - product details item for search keyword
     */
    public ProductDetailsItem getProductInfoFromKeywordWithAdvanceOrderInfo(String searchKeyword){
        boolean flag = true, bSelected=false; 
        ProductDetailsItem productDetailsItem=new ProductDetailsItem();
        String productNumber;
        
        Product product = getProductDetailsForKeyword(searchKeyword,null,true);
        if(product==null) {
        	return null;
        }

        do{
        	for(Product.Products data:product.getProducts()) {
            	selectedProduct.init();
            	productNumber=data.getItemNo();
            	productDetailsItem=getProductDetailsForSpecificProductNumber(productNumber);
            	bSelected=false;
            	for( ProductDetailsItem.Edp edp: productDetailsItem.Edps) {
            		if(edp.IsAdvanceOrBackOrder) {
            			bSelected=true;            			
            			selectedProduct.productNumber=productDetailsItem.getItemNo();
                		selectedProduct.productName=productDetailsItem.getName();
                		selectedProduct.productBrand=productDetailsItem.getBrand();
                		selectedProduct.productNowPrice=productDetailsItem.getIsPriceRange();
                		selectedProduct.productWasPrice=productDetailsItem.getWasPriceRange();
                		selectedProduct.productEDPSize=edp.Size;
                		selectedProduct.productEDPColor=edp.Style;
						if(!lsUrlType.isEmpty()){
							selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+productDetailsItem.getName().trim().replace(".","").replace(" ","-")+propertyData.get("test_partial_url_pdp")+productDetailsItem.getItemNo();
						}
						else{
							selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+productDetailsItem.getName().trim()+propertyData.get("test_partial_url_pdp")+productDetailsItem.getItemNo();
						}

                		break;
            		}
            	}
            	if(bSelected) {
            		flag = false;
                    break;
            	}                	                
            }
            if(flag) {
                outputPage++;
                if(outputPage>totalPage||outputPage>=10) {
                	flag = false;
                }
                product = getProductDetailsForKeyword(searchKeyword,null,false);
            }
        }while(flag);

        if(bSelected) {
        	return productDetailsItem;
        }
        else {
        	return null;
        }
        
    }

	/**
	 * This method finds DimensionStates for a product
	 * @param - String - searchKeyword : search keyword for Product
	 * @param - String - dimension : Dimension No of a particular product
	 * @return - List<Product.DimensionStates> - List of DimensionStates for searched product
	 */
    public List<Product.DimensionStates> getProductCategoryCategory(String searchKeyword, String dimension){
		Map<String,Object> configs = new HashMap<>();
		configs.put("dimensions",dimension);
		configs.put("searchterm",searchKeyword);
		try{
			String apiEndpoint = propertyData.get("test_apiVersion3")+"/"+propertyData.get("test_language")+"/products/";
			Response response = this.getApiCallResponse(configs,apiEndpoint);
			Product product = JsonParser.getResponseObject(response.asString(), new TypeReference<Product>() {});
			return product.getDimensionStates();

		}catch (Exception e){
			e.printStackTrace();
		}
    	return null;
	}

	/**
	 * This method finds product info on the basis of input search keyword with preconditions(video,style,size,brand,badgeImage,review,easyPay,WasPrice,and AddToBag)
	 * @param - String - searchKeyword : search keyword for Product
	 * @param - Map<String,Object> - outputDataCriteria : criteria for searching a particular product
	 * @param - boolean - isSoldOut :true for including soldout criteria and false for not checking soldout criteria
	 * @return - Product.Products - product for search keyword
	 */
	public Map<String,String> getProductLastPageWhenPagesMoreThanOne(List<String> searchKeyword,Map<String,Object> mandatoryParameters, int totalPage, String defaultPageItems,String basePRPPageURL){
		String pageURL = null;
		Map<String,String> map = new HashMap<>();
		Product product = null;

		for(String searchProduct:searchKeyword){
			product = getProductDetailsForKeyword(searchProduct,defaultPageItems,true);
			if(product==null)
				continue;
			else if(product.getPaging().getTotalPages()>=totalPage){
				if(mandatoryParameters!=null){
					map.put("searchTerm",searchProduct);
					String partialURL=null;
					for(Map.Entry<String,Object> entry:mandatoryParameters.entrySet()){
						partialURL = partialURL==null ? entry.getKey()+"="+entry.getValue() : partialURL+"&"+entry.getKey()+"="+entry.getValue();
						pageURL = basePRPPageURL+partialURL+"&searchterm="+searchProduct;
					}
					break;
				}else
					map.put("searchTerm",searchProduct);
					pageURL = basePRPPageURL+"&rd=1&searchterm="+searchProduct;
				break;
			}else if(product.getPaging().getTotalPages()<totalPage)
				continue;
		}
		if(pageURL!=null) {
			//Getting last page for product on PRP page
			double totalItems = product.getPaging().getTotalRecords();
			long totalPages = product.getPaging().getTotalPages();
			long lastPage = (long) Math.ceil(totalItems / Long.valueOf(defaultPageItems));
			map.put("pageURL", pageURL + "&page=" + lastPage);
			map.put("totalPages", String.valueOf(totalPages));
			map.put("totalItems", String.valueOf(totalItems));
			map.put("lastPage",String.valueOf(lastPage));
			return map;
		}
		return null;
	}

	/**
	 * This method is for placing oder for given user so that oder end on My Account page
	 */
	public void placeOrderForUser(String customerEDP, String accessToken) throws JsonProcessingException {
		//Verifying that user has tsc credit card associated for placing order
		Response userCartResponse = this.getAccountCartContentWithCustomerEDP(customerEDP,accessToken);
		CartResponse cartResponseForUser = JsonParser.getResponseObject(userCartResponse.asString(), new TypeReference<CartResponse>() {});
		if(cartResponseForUser.getCreditCard()!=null){
			if(!cartResponseForUser.getCreditCard().getType().equalsIgnoreCase("FI")){
				org.json.simple.JSONObject creditCardDetails = DataConverter.readJsonFileIntoJSONObject("test-data/CreditCard.json");
				this.addCreditCardToUser( (org.json.simple.JSONObject)creditCardDetails.get("tscCard"),customerEDP,accessToken);
			}
		}
	}

	/**
	 * This method is to fetch account details for a user using EDP
	 * @param - String - customerEDP
	 */
	public AccountResponse getUserDetailsFromCustomerEDP(String customerEDP, String accessToken){
		String apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/" + customerEDP;
		Response response = getApiCallResponseAfterAuthentication(null,apiEndPoint,accessToken);
		if(response.getStatusCode()==200)
			return JsonParser.getResponseObject(response.asString(), new TypeReference<AccountResponse>() {});
		else
			return null;
	}

	/**
	 * This method finds an active product with full info(badgeImage,product name,brand,style,size,NowPrice,WasPrice,review) on the basis of input search keyword
	 * @param - String - searchKeyword : search keyword for Product
	 * @return - Product.Products - product for search keyword
	 */
	public Product.Products getActiveProductWithFullInfoFromKeyword(String searchKeyword){
		boolean flag = true;
		String lsNowPrice,lsWasPrice;
		Product.Products productItem=null;

		Product product = getProductDetailsForKeyword(searchKeyword,null,true);
		if(product==null) {
			return null;
		}

		List<Product.Products> dataList;
		do{
			dataList =product.Products.stream().filter(item->item.getEdps().stream().anyMatch(subItem->subItem.getAppliedShipping().isEmpty()&&subItem.getInventory()>2)).collect(Collectors.toList());
			for(Product.Products data:dataList) {
				lsNowPrice=data.getIsPriceRange();
				lsWasPrice=data.getWasPriceRange();
				if (data.isActive()&&data.getStyles().size() >= 0 && data.getSizes().size() >= 0&&data.isShowBadgeImage()&&data.getProductReviewRating()>0&&data.getProductReviewCount()>0&&!lsNowPrice.equalsIgnoreCase(lsWasPrice)) {
					if(data.getBrand()!=null) {
						if(data.getBrand().isEmpty()) {
							continue;
						}
					}
					else {
						continue;
					}
					productItem=data;
					flag = false;
					break;
				}
			}
			if(flag) {
				outputPage++;
				if(outputPage>totalPage||outputPage>=10) {
					flag = false;
				}
				product = getProductDetailsForKeyword(searchKeyword,null,false);
			}
		}while(flag);

		return productItem;
	}

	/**
	 * This method returns section details i.e. Product Review, Size Chart etc. for a product number
	 * @param - String - productNumber : item no of a product
	 * @return - Sections - Sections object for product
	 */
	public List<Sections> getSectionDetailsFromProductNumber(String productNumber){
		String apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/products/" + productNumber+"/sections";
		Response response = getApiCallResponse(null,apiEndPoint);
		if(response.getStatusCode()==200)
			return JsonParser.getResponseObject(response.asString(), new TypeReference<List<Sections>>() {});
		else
			return null;
	}

	/**
	 * This method finds product info with Delivery options info
	 * @param - String - searchKeyword : search keyword for Product
	 * @return - ProductDetailsItem - product details item for search keyword
	 */
	public ProductDetailsItem getProductInfoFromKeywordWithDeliveryOptionsInfo(String searchKeyword){
		boolean flag = true, bSelected=false;
		ProductDetailsItem productDetailsItem=new ProductDetailsItem();
		String productNumber;

		Product product = getProductDetailsForKeyword(searchKeyword,null,true);
		if(product==null) {
			return null;
		}

		do{
			for(Product.Products data:product.getProducts()) {
				selectedProduct.init();
				productNumber=data.getItemNo();
				productDetailsItem=getProductDetailsForSpecificProductNumber(productNumber);
				bSelected=false;
				if(!productDetailsItem.getDeliveryOptions().isEmpty()){
					bSelected=true;
					selectedProduct.productNumber=productDetailsItem.getItemNo();
					selectedProduct.productName=productDetailsItem.getName();
					selectedProduct.productBrand=productDetailsItem.getBrand();
					selectedProduct.productNowPrice=productDetailsItem.getIsPriceRange();
					selectedProduct.productWasPrice=productDetailsItem.getWasPriceRange();
					if(!lsUrlType.isEmpty()){
						selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+productDetailsItem.getName().trim().replace(".","").replace(" ","-")+propertyData.get("test_partial_url_pdp")+productDetailsItem.getItemNo();
					}
					else{
						selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+productDetailsItem.getName().trim()+propertyData.get("test_partial_url_pdp")+productDetailsItem.getItemNo();
					}

					break;
				}

				if(bSelected) {
					flag = false;
					break;
				}
			}
			if(flag) {
				outputPage++;
				if(outputPage>totalPage||outputPage>=10) {
					flag = false;
				}
				product = getProductDetailsForKeyword(searchKeyword,null,false);
			}
		}while(flag);

		if(bSelected) {
			return productDetailsItem;
		}
		else {
			return null;
		}
	}

	/**
	 * This method finds product info with Get The Look info
	 * @param - String - searchKeyword : search keyword for Product
	 * @return - ProductDetailsItem - product details item for search keyword
	 */
	public ProductDetailsItem getProductInfoFromKeywordWithGetTheLookInfo(String searchKeyword){
		boolean flag = true, bSelected=false;
		ProductDetailsItem productDetailsItem=new ProductDetailsItem();
		String productNumber;

		Product product = getProductDetailsForKeyword(searchKeyword,null,true);
		if(product==null) {
			return null;
		}

		List<ProductDetailsItem.Edp> dataList;
		Response response;
		String lsUrl;
		do{
			for(Product.Products data:product.getProducts()) {
				selectedProduct.init();
				productNumber=data.getItemNo();
				productDetailsItem=getProductDetailsForSpecificProductNumber(productNumber);
				bSelected=false;
				dataList =productDetailsItem.Edps.stream().filter(item->item.getStyleDimensionId()!=null&&!item.getStyleDimensionId().isEmpty()).collect(Collectors.toList());
				if(!dataList.isEmpty()){
					String savedBaseURI=RestAssured.baseURI;
					RestAssured.baseURI="https://api.findmine.com/api/v2/";
					lsUrl="complete-the-look?application=964F141E3FA264316345&product_id="+productDetailsItem.getItemNo()+"&product_color_id="+dataList.get(0).getStyleDimensionId()+"&product_in_stock=true";
					System.out.println("lsUrl: "+lsUrl);
					response=getApiCallResponse(null, lsUrl);
					RestAssured.baseURI=savedBaseURI;
					System.out.println("response: "+response.asString());
					if(response.asString().contains("\"featured\": 1")){
						bSelected=true;
					}

					if(bSelected){
						System.out.println("product number: "+productDetailsItem.getItemNo());

						return productDetailsItem;
					}
				}
/*
				for( ProductDetailsItem.Edp edp: productDetailsItem.Edps) {
					if(edp.IsAdvanceOrBackOrder) {
						bSelected=true;
						selectedProduct.productNumber=productDetailsItem.getItemNo();
						selectedProduct.productName=productDetailsItem.getName();
						selectedProduct.productBrand=productDetailsItem.getBrand();
						selectedProduct.productNowPrice=productDetailsItem.getIsPriceRange();
						selectedProduct.productWasPrice=productDetailsItem.getWasPriceRange();
						selectedProduct.productEDPSize=edp.Size;
						selectedProduct.productEDPColor=edp.Style;
						if(!lsUrlType.isEmpty()){
							selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+productDetailsItem.getName().trim().replace(".","").replace(" ","-")+propertyData.get("test_partial_url_pdp")+productDetailsItem.getItemNo();
						}
						else{
							selectedProduct.pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+productDetailsItem.getName().trim()+propertyData.get("test_partial_url_pdp")+productDetailsItem.getItemNo();
						}

						break;
					}
				}
				*/

				if(bSelected) {
					flag = false;
					break;
				}
			}
			if(flag) {
				outputPage++;
				if(outputPage>totalPage||outputPage>=10) {
					flag = false;
				}
				product = getProductDetailsForKeyword(searchKeyword,null,false);
			}
		}while(flag);

		if(bSelected) {
			return productDetailsItem;
		}
		else {
			return null;
		}

	}

}
