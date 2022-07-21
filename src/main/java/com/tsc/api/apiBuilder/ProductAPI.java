package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.pojo.Product;
import com.tsc.api.pojo.ProductDetailsItem;
import com.tsc.api.util.JsonParser;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ProductAPI extends ApiClient {

    public ProductAPI() throws IOException { super(); }

    /**
     * This method find Product Details for search Keyword as api call
     * @param - String - searchKeyword : search keyword for Product
     * @param - String - defaultPageItems : default items on page that you need in results
     * @param - Boolean - firstTimeFunctionCall - determines as if the call is made first time or not
     * @return - Product - Product Object from api Response
     */
    public Product getProductDetailsForKeyword(String searchKeyword,String defaultPageItems,boolean firstTimeFunctionCall) throws IOException {
        Map<String,Object> configs = null;
        int outputPage = 1,repeatNumber=0;
        String dimensionNumber=null;
        boolean bBrand=false,flag = true;
        Response response = null;
        Product product = null;
        Map<String, Object> initialConfig=new HashMap<>();

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
                        dimensionNumber = new ApiResponse().getDimensionNumberFromURL(product.getRedirectUrl());
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
                product = JsonParser.getResponseObject(response.asString(), new TypeReference<Product>() {});

                if (product.getProducts().size() >= 1) {
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
     * This method find Product Details for search Keyword as api call
     * @param - String - searchKeyword : search keyword for Product
     * @param - String - defaultPageItems : default items on page that you need in results
     * @param - Boolean - firstTimeFunctionCall - determines as if the call is made first time or not
     * @return - Map<String,Object> - Map<String,Object> Object from api Response
     */
    public Map<String,Object> getNotSoldOutProduct(String searchKeyword,String defaultPageItems,boolean firstTimeFunctionCall) throws IOException {
        Product product=getProductDetailsForKeyword(searchKeyword,defaultPageItems,firstTimeFunctionCall);
        Map<String,Object> mapResult=new HashMap<>();
        for(Product.Products data:product.getProducts()) {
            //To check if any Inventory is greater than 0, then means it is not SoldOut item
            List<Product.edps> edpsList=data.getEdps();
            for(Product.edps Edps:edpsList) {
                if(Edps.Inventory>0&&!Edps.isSoldOut()) {
                    mapResult.put("Product", data);
                    mapResult.put("Edp", Edps);
                    mapResult.put("EdpNo", Edps.EdpNo);
                    return mapResult;
                }
            }
        }
        return null;
    }

    /**
     * This method find EDPNo for not SoldOut product
     * @param - String - searchKeyword : search keyword for Product
     * @param - String - defaultPageItems : default items on page that you need in results
     * @param - Boolean - firstTimeFunctionCall - determines as if the call is made first time or not
     * @return - List<Integer> - EDPNo
     */
    public List<Product.edps> getEDPNoForNotSoldOutProduct(String searchKeyword,String defaultPageItems,boolean firstTimeFunctionCall,int returnProductCount) throws IOException {
        List<Product.edps> list = new ArrayList<>();
        Product product=getProductDetailsForKeyword(searchKeyword,defaultPageItems,firstTimeFunctionCall);
        List<Product.Products> dataList =product.Products.stream().filter(item->item.getEdps().stream().anyMatch(subItem->subItem.getInventory()>2)).collect(Collectors.toList());
        for(Product.Products data:dataList) {
            //To check if any Inventory is greater than 0, then means it is not SoldOut item
            List<Product.edps> edpsList=data.getEdps().stream().filter(item->item.getInventory()>2).collect(Collectors.toList());
            for(Product.edps Edps:edpsList) {
                if(getProductInventoryWithProductNumberAndEDPNumber(Edps.getItemNo(),Edps.getEdpNo())>2){
                    list.add(Edps);
                }
                if(returnProductCount!=0){
                    if(list.size()==returnProductCount)
                        return list;
                }
            }
        }
        return list;
    }

    /**
     * This method find EDPNo for not SoldOut product
     * @param - String - searchKeyword : search keyword for Product
     * @param - String - defaultPageItems : default items on page that you need in results
     * @param - Boolean - firstTimeFunctionCall - determines as if the call is made first time or not
     * @return - List<Integer> - EDPNo
     */
    public Map<String,Object> getNotSoldOutProductInfo(String searchKeyword,int inventoryCount,boolean bEqual) throws IOException {
        Map<String,Object> map=new HashMap<>();
        Product product=getProductDetailsForKeyword(searchKeyword,null,true);;
        List<Product.Products> dataList=null;
        if(bEqual){
            dataList =product.Products.stream().filter(item->item.getEdps().stream().anyMatch(subItem->subItem.getInventory()==inventoryCount)).collect(Collectors.toList());
        }
        else{
            dataList =product.Products.stream().filter(item->item.getEdps().stream().anyMatch(subItem->subItem.getInventory()>inventoryCount)).collect(Collectors.toList());
        }

        for(Product.Products data:dataList) {
            //To check if any Inventory is greater than 0, then means it is not SoldOut item
            List<Product.edps> edpsList=null;
            if(bEqual){
                edpsList=data.getEdps().stream().filter(item->item.getInventory()==inventoryCount).collect(Collectors.toList());
            }
            else{
                edpsList=data.getEdps().stream().filter(item->item.getInventory()>inventoryCount).collect(Collectors.toList());
            }

            for(Product.edps Edps:edpsList) {
                if(getProductInventoryWithProductNumberAndEDPNumber(Edps.getItemNo(),Edps.getEdpNo())>2){
                    map.put("productNumber",data.getItemNo());
                    map.put("productName",data.getName());
                    map.put("EDP",Edps);
                    String pdpNavigationUrl= propertyData.get("test_qaURL")+"/"+data.getName()+propertyData.get("test_partial_url_pdp")+data.getItemNo();
                    map.put("pdpNavigationUrl",pdpNavigationUrl);

                    return map;
                }
            }
        }

        return null;
    }

    /**
     * This method find EDPNo for not SoldOut product
     * @param - String - searchKeyword : search keyword for Product
     * @param - String - defaultPageItems : default items on page that you need in results
     * @param - Boolean - firstTimeFunctionCall - determines as if the call is made first time or not
     * @return - List<Integer> - EDPNo
     */
    public List<Product.edps> getEDPNoForProductContainingTenQuantity(String searchKeyword,String defaultPageItems,boolean firstTimeFunctionCall,int returnProductCount) throws IOException {
        List<Product.edps> list = new ArrayList<>();
        Product product=getProductDetailsForKeyword(searchKeyword,defaultPageItems,firstTimeFunctionCall);
        List<Product.Products> dataList =product.Products.stream().filter(item->item.getEdps().stream().anyMatch(subItem->subItem.getInventory()>=10)).collect(Collectors.toList());
        for(Product.Products data:dataList) {
            //To check if any Inventory is greater than 0, then means it is not SoldOut item
            List<Product.edps> edpsList=data.getEdps().stream().filter(item->item.getInventory()>=10 && !item.isSoldOut()).collect(Collectors.toList());
            for(Product.edps Edps:edpsList) {
                if(getProductInventoryWithProductNumberAndEDPNumber(Edps.getItemNo(),Edps.getEdpNo())>=10){
                    list.add(Edps);
                }
                if(returnProductCount!=0){
                    if(list.size()==returnProductCount)
                        return list;
                }
            }
        }
        return list;
    }

    /**
     * This method find EDPNo for free shipping product
     * @param - String - searchKeyword : search keyword for Product
     * @param - String - defaultPageItems : default items on page that you need in results
     * @param - Boolean - firstTimeFunctionCall - determines as if the call is made first time or not
     * @return - List<Integer> - EDPNo
     */
    public List getEDPNoForFreeShippingProduct(String searchKeyword,String defaultPageItems,boolean firstTimeFunctionCall,int returnProductCount) throws IOException {
        List<Product.edps> list = new ArrayList<>();
        Product product=getProductDetailsForKeyword(searchKeyword,defaultPageItems,firstTimeFunctionCall);
        List<Product.Products> dataList =product.Products.stream().filter(item->item.getEdps().stream().anyMatch(subItem->subItem.getAppliedShipping().isEmpty()&&subItem.getInventory()>2)).collect(Collectors.toList());
        for(Product.Products data:dataList) {
            //To check if any Inventory is greater than 0, then means it is not SoldOut item
            List<Product.edps> edpsList=data.getEdps().stream().filter(item->item.getInventory()>2 && item.getAppliedShipping().isEmpty()).collect(Collectors.toList());
            for(Product.edps Edps:edpsList) {
                if(getProductInventoryWithProductNumberAndEDPNumber(Edps.getItemNo(),Edps.getEdpNo())>2){
                    list.add(Edps);
                }
                if(returnProductCount!=0){
                    if(list.size()==returnProductCount){
                        return list;
                    }
                }
            }
        }
        return list;
    }

    /**
     * This method get Product Details for a specific product number as api call
     * @param - String - productNumber : product number for Product
     * @return - ProductDetailsItem - ProductDetailsItem Object from api Response
     */
    public ProductDetailsItem getProductDetailsForSpecificProductNumber(String productNumber){
        Response response = null;
        ProductDetailsItem product=new ProductDetailsItem();
        response = getApiCallResponse(null, propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language")+"/products/"+productNumber);
        if(response!=null && response.statusCode()==200) {
            product = JsonParser.getResponseObject(response.asString(), new TypeReference<ProductDetailsItem>() {});
        }

        return product;
    }

    /**
     * This method get Product inventory from product details
     * @param - String - productNumber : product number for Product
     * @param - int - productEDPNumber : product EDP number for Product
     * @return - int - inventory amount
     */
    public int getProductInventoryWithProductNumberAndEDPNumber(String productNumber,int productEDPNumber) {
        ProductDetailsItem product = getProductDetailsForSpecificProductNumber(productNumber);
        List<ProductDetailsItem.Edp> edpList = product.getEdps();
        for (ProductDetailsItem.Edp edp : edpList) {
            if (edp.getEdpNo() == productEDPNumber) {
                return edp.getInventory();
            }
        }
        return -1;
    }
    /**
     * This method find EDPNo for not SoldOut product
     * @param - String - searchKeyword : search keyword for Product
     * @param - String - defaultPageItems : default items on page that you need in results
     * @param - Boolean - firstTimeFunctionCall - determines as if the call is made first time or not
     * @return - List<Integer> - EDPNo
     */
    public List getEDPNoForNoFreeShippingProduct(String searchKeyword,String defaultPageItems,boolean firstTimeFunctionCall,int returnProductCount,double minimumItemPrice) throws IOException {
        List<Product.edps> list = new ArrayList<>();
        Product product=getProductDetailsForKeyword(searchKeyword,defaultPageItems,firstTimeFunctionCall);
        List<Product.Products> dataList =product.Products.stream().filter(item->item.getEdps().stream().anyMatch(subItem->!subItem.getAppliedShipping().isEmpty()&&subItem.getInventory()>2)).collect(Collectors.toList());
        for(Product.Products data:dataList) {
            //To check if any Inventory is greater than 0, then means it is not SoldOut item
            List<Product.edps> edpsList=data.getEdps().stream().filter(item->item.getInventory()>2).collect(Collectors.toList());
            for(Product.edps Edps:edpsList) {
                if (Edps.Inventory > 2 && !Edps.isSoldOut() && !Edps.getAppliedShipping().isEmpty()) {
                    //Fetching product number that has no Free Shipping and greater than minimum price
                    if(Double.valueOf(Edps.getAppliedPrice().replace(",","").split("\\$")[1])>minimumItemPrice)
                        list.add(Edps);
                }
                if(returnProductCount!=0){
                    if(list.size()==returnProductCount)
                        return list;
                }
            }
        }
        return list;
    }

    /**
     * This function returns a list of items that will be added to cart for a user
     * @param - List<Map<String,String>> - keywordData - items that are to be added to the cart for user
     * @return - List<Map<String,String>> - List of Map Object that are added to cart
     * @throws IOException
     */
    public List<Map<String,Object>> getProductDetailsToBeAddedToCartForUser(List<Map<String,String>> keywordData) throws IOException {
        List<Map<String,Object>> productList = new ArrayList<>();
        List<Map<String,Object>> tempDataList = null;
        boolean innerForLoop = false;
        for(Map<String,String> data:keywordData){
            boolean outerloop = false;
            Product product = this.getProductDetailsForKeyword(data.get("searchKeyword"),null,true);
            List<Product.Products> products = product.getProducts();
            Boolean badgeRequired = Boolean.valueOf(data.get("badgeRequired"));
            Boolean styleExist = Boolean.valueOf(data.get("styleExist"));
            Boolean sameSizeAndStyle = Boolean.valueOf(data.get("sameSizeAndStyle"));
            int itemToBeAdded = Integer.valueOf(data.get("itemToBeAdded"));

            for(Product.Products productsData:products){
                Map<String,Object> productMap = new HashMap<>();
                if(Boolean.valueOf(data.get("styleExist"))){
                    //Fetching item edp number for same product with badge, style and size
                    if(productsData.getVideosCount() >= 0 && productsData.getStyles().size() >= 1 && productsData.getSizes().size() >= 1&&productsData.isShowBadgeImage() && productsData.isEnabledAddToCart()){
                        if(badgeRequired && styleExist && sameSizeAndStyle){
                            for(Product.edps edpsData: productsData.getEdps()){
                                if(!productsData.getPriceIsLabel().isEmpty()){
                                    productMap = this.getEDPNumberForInputCondition(data.get("quantity"),itemToBeAdded,edpsData,productsData);
                                    if(productMap.keySet().size()>0)
                                        innerForLoop = true;
                                    else
                                        continue;
                                }
                                if(productMap.keySet().size()>0){
                                    productMap.put("itemToBeAdded",itemToBeAdded);
                                    productList.add(productMap);
                                }
                                if(innerForLoop){
                                    innerForLoop = false;
                                    outerloop = true;
                                    break;
                                }
                            }
                        }
                        //Fetching item edp numbers for same product with badge, style but with different style and size
                        //True Fit condition scenario
                        else if(badgeRequired && styleExist && !sameSizeAndStyle){
                            ProductDetailsItem productDetailsItem=null;
                            if(tempDataList==null)
                                tempDataList = new ArrayList<>();
                            if(productsData.getVideosCount() >= 0 && productsData.getStyles().size() >= 1 && productsData.getSizes().size() >= 1&&productsData.isShowBadgeImage() && productsData.isEnabledAddToCart()){
                                productDetailsItem=getProductDetailsForSpecificProductNumber(productsData.getItemNo());
                                List<ProductDetailsItem.Edp> edpsList=productDetailsItem.getEdps();
                                List<ProductDetailsItem.Edp> dataList=edpsList.stream().filter(item->item.getInventory()>0).sorted((p1,p2)->p1.getStyle().compareTo(p2.getStyle())).collect(Collectors.toList());
                                String checkStyle="FirstItem";
                                if(dataList.size()>1){
                                    int counter = 0,forLoopCounter = 0;
                                    for(ProductDetailsItem.Edp edpsData:dataList) {
                                        forLoopCounter++;
                                        Map<String,Object> productMapData = new HashMap<>();
                                        boolean secondValue = false;
                                        if(!checkStyle.equalsIgnoreCase(edpsData.getStyle()) && edpsData.getInventory()>1){
                                            if(counter==0 && productMapData.size()>0)
                                                productMapData.clear();
                                            checkStyle = edpsData.getStyle();
                                            productMapData.put("productName",productsData.getName());
                                            productMapData.put("productNumber",productsData.getItemNo());
                                            productMapData.put("edpNo",edpsData.getEdpNo());
                                            productMapData.put("edpsData",edpsData);
                                            productMapData.put("productStyle",edpsData.getStyle());
                                            productMapData.put("productStyleDimensionId",edpsData.getStyleDimensionId());
                                            productMapData.put("productSize",edpsData.getSize());
                                            productMapData.put("productSizeDimensionId",edpsData.getSizeDimensionId());
                                            secondValue = true;
                                            counter++;
                                        }
                                        if(secondValue){
                                            productMapData.put("itemToBeAdded",1);
                                            tempDataList.add(productMapData);
                                        }
                                        if(forLoopCounter == dataList.size() && counter!=itemToBeAdded)
                                            tempDataList.clear();
                                        if(counter==itemToBeAdded){
                                            tempDataList.forEach(item->{productList.add(item);});
                                            outerloop = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //Fetching item edp number for product with badge and has no style and size available
                else if(!styleExist && data.get("quantity").isEmpty()){
                    if(productsData.getVideosCount() >= 0 && productsData.getStyles().size() == 0 && productsData.getSizes().size() == 0 && productsData.isEnabledAddToCart()){
                        for(Product.edps edpsData: productsData.getEdps()){
                            if(!edpsData.isSoldOut()){
                                productMap = this.getEDPNumberForInputCondition(null,itemToBeAdded,edpsData,productsData);
                                if(productMap.keySet().size()>0)
                                    innerForLoop = true;
                                else
                                    continue;
                            }
                            if(productMap.keySet().size()>0){
                                productMap.put("itemToBeAdded",itemToBeAdded);
                                productList.add(productMap);
                            }
                            if(innerForLoop){
                                innerForLoop = false;
                                outerloop = true;
                                break;
                            }
                        }
                    }
                }
                if(outerloop)
                    break;
                else
                    continue;
            }
        }
        return productList;
    }

    /**
     * This function returns edps data for a product
     * @param - String - quantityCondition - Inventory item that will be selected
     * @param - Integer - itemToBeAddedNumber - Number of items that will be added
     * @param - Product.edps - edpsData - edps data object for product
     * @param - Product.Products - productsData - Product.Products object for product
     * @return - Map<String,Object> - Map Object
     */
    public Map<String,Object> getEDPNumberForInputCondition(String quantityCondition, int itemToBeAddedNumber, Product.edps edpsData,Product.Products productsData){
        Map<String,Object> productMap = new HashMap<>();
        if(quantityCondition!=null){
            String[] quantityConditionArray = quantityCondition.split(" ");
            if(quantityConditionArray[0].contains("more") || quantityConditionArray[0].contains("greater")){
                if(edpsData.getInventory()>Integer.valueOf(quantityConditionArray[2]))
                    productMap.put("edpsData",edpsData);
            }else if(quantityConditionArray[0].contains("less") || quantityConditionArray[0].contains("lower")){
                if(edpsData.getInventory()<Integer.valueOf(quantityConditionArray[2]))
                    productMap.put("edpsData",edpsData);
            }else if(quantityConditionArray[0].contains("equal")){
                if(edpsData.getInventory()==Integer.valueOf(quantityConditionArray[2]))
                    productMap.put("edpsData",edpsData);
            }
        }else{
            if(edpsData.getInventory()>=itemToBeAddedNumber)
                productMap.put("edpsData",edpsData);
        }

        if(productMap.keySet().contains("edpsData")){
            productMap.put("productName",productsData.getName());
            productMap.put("productNumber",productsData.getItemNo());
            productMap.put("edpNo",edpsData.getEdpNo());
            productMap.put("productStyle",edpsData.getStyle());
            productMap.put("productStyleDimensionId",edpsData.getStyleDimensionId());
            productMap.put("productSize",edpsData.getSize());
            productMap.put("productSizeDimensionId",edpsData.getSizeDimensionId());
            return productMap;
        }

        return productMap;
    }
}
