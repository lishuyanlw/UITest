package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.pojo.Product;
import com.tsc.api.pojo.ProductDetailsItem;
import com.tsc.api.util.JsonParser;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
//                if (Edps.Inventory > 2 && !Edps.isSoldOut()) {
//                    list.add(Edps);
//                }
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
    public List<Product.edps> getEDPNoForNotSoldOutProductContainTenQuantity(String searchKeyword,String defaultPageItems,boolean firstTimeFunctionCall,int returnProductCount) throws IOException {
        List<Product.edps> list = new ArrayList<>();
        Product product=getProductDetailsForKeyword(searchKeyword,defaultPageItems,firstTimeFunctionCall);
        List<Product.Products> dataList =product.Products.stream().filter(item->item.getEdps().stream().anyMatch(subItem->subItem.getInventory()>=10)).collect(Collectors.toList());
        for(Product.Products data:dataList) {
            //To check if any Inventory is greater than 0, then means it is not SoldOut item
            List<Product.edps> edpsList=data.getEdps().stream().filter(item->item.getInventory()>=10).collect(Collectors.toList());
            for(Product.edps Edps:edpsList) {
                if(getProductInventoryWithProductNumberAndEDPNumber(Edps.getItemNo(),Edps.getEdpNo())>=10){
                    list.add(Edps);
                }
//                if (Edps.Inventory > 2 && !Edps.isSoldOut()) {
//                    list.add(Edps);
//                }
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
            List<Product.edps> edpsList=data.getEdps().stream().filter(item->item.getInventory()>2).collect(Collectors.toList());
            for(Product.edps Edps:edpsList) {
                if(getProductInventoryWithProductNumberAndEDPNumber(Edps.getItemNo(),Edps.getEdpNo())>2){
                    list.add(Edps);
                }
//                if (Edps.Inventory > 2 && !Edps.isSoldOut()&&Edps.getAppliedShipping().isEmpty()) {
//                    list.add(Edps);
//                }
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
    public List getEDPNoForNotSoldOutAndNoFreeShippingProduct(String searchKeyword,String defaultPageItems,boolean firstTimeFunctionCall,int returnProductCount,double minimumItemPrice) throws IOException {
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
}
