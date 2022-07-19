package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.pojo.Product;
import com.tsc.api.util.DataConverter;
import com.tsc.api.util.JsonParser;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tsc.pages.base.BasePage.reporter;

public class CartAPI extends ApiClient {
    public CartAPI() throws IOException { super(); }
    private double cartTotalAmount = 0.0;

    /**
     * @param - customerEDP - Customer EDP Number where cart is created
     * @param - access_token - access token for api authentication
     * @return - Response - API Response after AccountCart GET calling
     */
    public Response getAccountCartContentWithCustomerEDP(String customerEDP, String access_token) {
        return getApiCallResponseAfterAuthentication(null, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/" + customerEDP + "/cart", access_token);
    }

    /**
     * @param - access_token - access token for api authentication
     * @param - CartGuid - Cart Guid
     * @return - Response - API Response after Cart GET calling
     */
    public Response getCartContentWithCartGuid(String access_token, String CartGuid) {
        return getApiCallResponseAfterAuthentication(null, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/carts/" + CartGuid, access_token);
    }

    /**
     * @param - access_token - access token for api authentication
     * @param - CartGuid - Cart Guid
     * @param - LineId- Cart Lines Id
     * @return - Response - API Response after Cart DELETE calling
     */
    public Response deleteCartItemWithCartGuidAndLineId(String access_token, String CartGuid, int LineId) {
        return deleteApiCallResponseAfterAuthentication(propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/carts/" + CartGuid + "/cartLines/" + LineId, access_token);
    }

    /**
     * @param - access_token - access token for api authentication
     * @param - CartGuid - Cart Guid
     * @return - Response - API Response
     */
    public Response emptyCartWithGuid(String access_token, String CartGuid) {
        Response getResponse=this.getCartContentWithCartGuid(access_token, CartGuid);
        if(getResponse.jsonPath().getList("CartLines").isEmpty()){
            return getResponse;
        }
        
        CartResponse accountCartGet= JsonParser.getResponseObject(getResponse.asString(), new TypeReference<CartResponse>() {});
        List<CartResponse.CartLinesClass> cartLines=accountCartGet.getCartLines();
        Response response=null;
        int cartLinesSize=cartLines.size();
        CartResponse.CartLinesClass lines=null;
        if(cartLinesSize>0){
            for(int i=0;i<cartLinesSize;i++){
                lines= cartLines.get(i);
                response=deleteApiCallResponseAfterAuthentication(propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/carts/" + CartGuid + "/cartLines/" + lines.getId(), access_token);
            }
        }

        return response;
    }

    /**
     * @param - access_token - access token for api authentication
     * @param - CartGuid - Cart Guid
     * @param - int - keepingNumber
     * @return - Response - API Response
     */
    public Response deleteCartItemWithGuid(String access_token, String CartGuid,int keepingNumber) {
        Response getResponse=this.getCartContentWithCartGuid(access_token, CartGuid);
        if(getResponse.jsonPath().getList("CartLines").size()<=keepingNumber){
            return getResponse;
        }

        CartResponse accountCartGet= JsonParser.getResponseObject(getResponse.asString(), new TypeReference<CartResponse>() {});
        List<CartResponse.CartLinesClass> cartLines=accountCartGet.getCartLines();
        Response response=null;
        int cartLinesSize=cartLines.size();
        CartResponse.CartLinesClass lines=null;
        if(cartLinesSize>0){
            for(int i=0;i<cartLinesSize-keepingNumber;i++){
                lines= cartLines.get(i);
                response=deleteApiCallResponseAfterAuthentication(propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/carts/" + CartGuid + "/cartLines/" + lines.getId(), access_token);
            }
        }

        return response;
    }

    /**
     * @param - itemEDP - Item EDP Number to be added
     * @param - quantity - Quantity of item to be added
     * @param - customerEDP - Customer EDP Number where cart is created
     * @param - access_token - access token for api authentication
     * @return - Response - API Response after creating and adding items to cart for user
     */
    public Response createNewCartOrAddItems(List<Integer> itemEDP, int quantity, int customerEDP, String access_token, String cartGuidId) {
        JSONObject jsonObject = new JSONObject();
        Response response = null;
        String apiEndPoint = null;
        if (cartGuidId == null) {
//            reporter.reportLog("Creating a new cart and adding item to cart");
            apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language") + "/carts";
        } else {
//            reporter.reportLog("Adding items to existing cart for customerEDP: " + customerEDP + " and cartGuid Id: " + cartGuidId);
            apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language") + "/carts/" + cartGuidId + "/cartlines";
        }
        for (int itemEDPNo : itemEDP) {
            jsonObject.clear();
//            reporter.reportLog("Adding itemEDPNo: " + itemEDPNo + " to cart for customerEDP: " + customerEDP);
            jsonObject.put("ItemEDP", itemEDPNo);
            jsonObject.put("Quantity", quantity);
            jsonObject.put("Customization", "Test");
            if(customerEDP==-1)
                jsonObject.put("CustomerEDP", null);
            else
                jsonObject.put("CustomerEDP", customerEDP);

            response = this.postApiCallResponseAfterAuthenticationFromJSON(jsonObject, apiEndPoint, access_token);

        }

        return response;
    }

    /**
     * @param - itemEDP - Item EDP Number to be added
     * @param - customerEDP - Customer EDP Number where cart is created
     * @param - access_token - access token for api authentication
     * @param - String - cartGuidId - existing cart GuidId
     * @param - String - itemEDPNo - Existing product EDPNo, if set it as null get it from Product
     * @return - Map<String,Object> - including:
     *     - itemEDPNo
     *     - appliedPrice
     *     - Response - API Response after adding items to cart for user
     */
    public Map<String,Object> addItemsInExistingCart(int customerEDP, String access_token, String cartGuidId,String itemEDPNo) throws IOException {
        ProductAPI productAPI=new ProductAPI();
        JSONObject jsonObject = new JSONObject();
        Response response = null;
        String apiEndPoint = null;

//        reporter.reportLog("Adding items to existing cart for customerEDP: " + customerEDP + " and cartGuid Id: " + cartGuidId);
        apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language") + "/carts/" + cartGuidId + "/cartlines";
//        reporter.reportLog("apiEndPoint: "+apiEndPoint);
        int selectedEdpNo=-1;
        double appliedPrice=0.0;
        if(itemEDPNo==null){
            Response responseExisting=getAccountCartContentWithCustomerEDP(String.valueOf(customerEDP), access_token);
            CartResponse accountCart = JsonParser.getResponseObject(responseExisting.asString(), new TypeReference<CartResponse>() {});

            //Get the EdpNo list in the current CartLines
            List<Integer> existingEdpNoList=getEdpNoListInCartLines(accountCart);

            //ProductEDP Number that will be added to cart for user
            List<Product.edps> products = productAPI.getEDPNoForNotSoldOutProduct("boots",null,true,12);

            //Choose one EdpNo is not the same as those in the current CartLines
            if(existingEdpNoList!=null){
                for(int i=0;i<products.size();i++){
                    boolean bMatch=false;
                    for(int j=0;j<existingEdpNoList.size();j++){
                        if(products.get(i).getEdpNo()==existingEdpNoList.get(j)){
                            bMatch=true;
                            break;
                        }
                    }
                    if(!bMatch){
                        selectedEdpNo=products.get(i).getEdpNo();
                        appliedPrice= getDoubleFromString(products.get(i).getAppliedPrice());
//                        reporter.reportLog("Product number: "+products.get(i).getItemNo());
//                        reporter.reportLog("EDP number: "+products.get(i).getEdpNo());
//                        reporter.reportLog("Inventory: "+products.get(i).getInventory());
//                        reporter.reportLog("IsSoldout: "+products.get(i).isSoldOut());
                        break;
                    }
                }
            }
            else{
                selectedEdpNo=products.get(0).getEdpNo();
                appliedPrice= getDoubleFromString(products.get(0).getAppliedPrice());
//                reporter.reportLog("Product number: "+products.get(0).getItemNo());
//                reporter.reportLog("EDP number: "+products.get(0).getEdpNo());
//                reporter.reportLog("Inventory: "+products.get(0).getInventory());
//                reporter.reportLog("IsSoldout: "+products.get(0).isSoldOut());
            }
        }
        else{
            selectedEdpNo= Integer.parseInt(itemEDPNo);
        }

        //Generate Json body
        jsonObject.put("ItemEDP", selectedEdpNo);
        jsonObject.put("Quantity", 1);
        jsonObject.put("Customization", "Test");
        jsonObject.put("CustomerEDP", customerEDP);

        response = this.postApiCallResponseAfterAuthenticationFromJSON(jsonObject, apiEndPoint, access_token);

        Map<String,Object> map=new HashMap<>();
        map.put("itemEDPNo", selectedEdpNo);
        map.put("appliedPrice", appliedPrice);
        map.put("Response", response);

        return map;
    }

    /**
     * To get Cart MerchandiseSubTotalAmount In OrderSummary
     */
    public double getCartMerchandiseSubTotalAmountInOrderSummary(CartResponse cartResponse){
        return cartResponse.getOrderSummary().getMerchandiseSubTotalAmount();
    }

    /**
     * To get Cart ShippingHandling Fee In OrderSummary
     */
    public double getCartShippingHandlingFeeInOrderSummary(CartResponse cartResponse){
        return cartResponse.getOrderSummary().getShippingHandlingAmount();
    }

    /**
     * To get total price in CartLines
     */
    public double getCartTotalPriceInCartLines(CartResponse cartResponse){
       List<CartResponse.CartLinesClass> cartLinesClasses=cartResponse.getCartLines();
       double totalAmount=0.0;
       for(CartResponse.CartLinesClass cartLinesClass:cartLinesClasses){
           totalAmount = totalAmount + cartLinesClass.getInCart().getQuantity()*cartLinesClass.getInCart().getPriceUnit();
       }
       return totalAmount;
    }

    /**
     * To get item price in CartLines
     * @param - AccountCartResponse - cartResponse
     * @param - int - lineId
     * @return - double - totalAmount
     */
    public double getCartItemPriceInCartLinesWithLineId(CartResponse cartResponse, int lineId){
        List<CartResponse.CartLinesClass> cartLinesClasses=cartResponse.getCartLines();
        double totalAmount=0.0;
        for(CartResponse.CartLinesClass cartLinesClass:cartLinesClasses){
            if(cartLinesClass.getId()==lineId){
                totalAmount = totalAmount + cartLinesClass.getInCart().getQuantity()*cartLinesClass.getInCart().getPriceUnit();
                return totalAmount;
            }
        }
        return totalAmount;
    }

    /**
     * To get shippingHandling fee in CartLines
     */
    public double getCartShippingHandlingFeeInCartLines(CartResponse cartResponse){
        List<CartResponse.CartLinesClass> cartLinesClasses=cartResponse.getCartLines();
        double totalAmount=0.0;
        for(CartResponse.CartLinesClass cartLinesClass:cartLinesClasses){
            if(cartLinesClass.getInCart().getShippingHandling().equalsIgnoreCase("FREE")){
                continue;
            }
           totalAmount= totalAmount+getDoubleFromString(cartLinesClass.getInCart().getShippingHandling());
        }
        totalAmount=Math.floor(totalAmount * 100) / 100;
        return totalAmount;
    }

    /**
     * To get shippingHandling fee From Available Ship Methods
     */
    public double getCartShippingCostFromAvailableShipMethods(CartResponse cartResponse, String shipCode){
        List<CartResponse.AvailableShipMethodsClass> cartAvailableShipMethods=cartResponse.getAvailableShipMethods();
        double shippingCost=0.0;
        for(CartResponse.AvailableShipMethodsClass cartAvailableShipMethod:cartAvailableShipMethods){
            if(cartAvailableShipMethod.getMethod().equalsIgnoreCase(shipCode)){
                shippingCost= getDoubleFromString(cartAvailableShipMethod.getShippingCost());
                break;
            }
        }
        return shippingCost;
    }

    /**
     * @param - AccountCartResponse - accountCar
     * @return - List<String> - Shipping method list
     */
    public List<String> getAvailableShipMethodList(CartResponse accountCart) {
        List<String> lstMethod = new ArrayList<>();
        for (CartResponse.AvailableShipMethodsClass item : accountCart.getAvailableShipMethods()) {
            lstMethod.add(item.getMethod());
        }
        return lstMethod;
    }

    /**
     * @param - AccountCartResponse - accountCart
     * @return - List<String> - Standard Ship code in available shipping method list
     */
    public String getStandardShipCodeFromAvailableShipMethodList(CartResponse accountCart) {
        String lsStandardCode=null;
        for (CartResponse.AvailableShipMethodsClass item : accountCart.getAvailableShipMethods()) {
            if(item.getLabel().equalsIgnoreCase("Standard")){
                lsStandardCode=item.getMethod();
                break;
            }
        }
        return lsStandardCode;
    }

    /**
     * @param - AccountCartResponse - accountCart
     * @return - List<Integer> - Cart linesId list
     */
    public List<Integer> getCartLinesIdList(CartResponse accountCart) {
        List<Integer> lstCartLinesId = new ArrayList<>();
        for (CartResponse.CartLinesClass item : accountCart.getCartLines()) {
            lstCartLinesId.add(item.getId());
        }

        return lstCartLinesId;
    }

    /**
     * To get LineId From CartLines Id List With EDPNo
     * @param - AccountCartResponse - accountCart
     * @param - int - EDPNo
     * @return - Integer - Cart LinesId
     */
    public Integer getLineIdFromCartLinesIdListWithEDPNo(CartResponse accountCart, int EDPNo) {
        for (CartResponse.CartLinesClass item : accountCart.getCartLines()) {
            if(item.getCartLineItem().EdpNo==EDPNo){
                return item.getId();
            }
        }

        return -1;
    }

    /**
     * @param - AccountCartResponse - accountCart
     * @return - List<Integer> - EdpNo list in CartLines
     */
    public List<Integer> getEdpNoListInCartLines(CartResponse accountCart) {
        List<Integer> lstEdpNo = new ArrayList<>();
        List<CartResponse.CartLinesClass> lstCartLines=accountCart.getCartLines();
        if(!lstCartLines.isEmpty()){
            int itemLoopSize=lstCartLines.size();
            for (int i=0;i<itemLoopSize;i++) {
                lstEdpNo.add(accountCart.getCartLines().get(i).getCartLineItem().getEdpNo());
            }
        }
        else{
            lstEdpNo=null;
        }
        return lstEdpNo;
    }

    /**
     * @param - AccountCartResponse - accountCart
     * @return - Item quantity amount in CartLines
     */
    public int getQuantityAmountInCartLines(CartResponse accountCart) {
        List<CartResponse.CartLinesClass> lstCartLines=accountCart.getCartLines();
        int totalQuantity=0;
        if(!lstCartLines.isEmpty()){
            int itemLoopSize=lstCartLines.size();
            for (int i=0;i<itemLoopSize;i++) {
                totalQuantity=totalQuantity+lstCartLines.get(i).getInCart().getQuantity();
            }
        }

        return totalQuantity;
    }

    /**
     * To get Item Content With EdpNo In CartLines
     * @param - AccountCartResponse - accountCart
     * @param -int - itemEDPNo
     * @return - Map<String,Object> - including item Quantity and item PriceUnit
     */
    public Map<String,Object> getItemContentWithEdpNoInCartLines(CartResponse accountCart, int itemEDPNo) {
        List<CartResponse.CartLinesClass> lstCartLines=accountCart.getCartLines();

        Map<String,Object> map=new HashMap<>();
        int itemLoopSize=lstCartLines.size();
        for (int i=0;i<itemLoopSize;i++) {
            if(accountCart.getCartLines().get(i).getCartLineItem().getEdpNo()==itemEDPNo){
                map.put("itemQuantity",accountCart.getCartLines().get(i).getInCart().getQuantity());
                map.put("itemPriceUnit",accountCart.getCartLines().get(i).getInCart().getPriceUnit());
                break;
            }

        }
        return map;
    }

    /**
     * To create a shipping address into an account cart
     * POST API: https://qa-tsc.tsc.ca/api/v2/en/accounts/{customerEDP}/cart/shippingaddress
     * @param customerEDP - String
     * @param access_token - String
     * @param isDefault - boolean
     * @param userData - Map<String,Object>
     * @return Map<String,Object> - including shippingIdBefore and shippingIdAfter, API calling response
     * @throws IOException
     * @throws ParseException
     */
    public Map<String,Object> createShippingAddressIntoAccountCart(String customerEDP,String access_token,boolean isDefault,Map<String,Object> userData) throws IOException, ParseException {
        Response getCartResponse=getAccountCartContentWithCustomerEDP(customerEDP, access_token);
        CartResponse accountCartGet= JsonParser.getResponseObject(getCartResponse.asString(), new TypeReference<CartResponse>() {});
        int shippingIdBeforeAdd=accountCartGet.getShippingAddress().getId();

        JSONObject requestParams= DataConverter.readJsonFileIntoJSONObject("test-data/AccountAddingShippingAddressPost.json");

        requestParams.put("Id", DataConverter.getSaltString(8,"numberType"));
        requestParams.put("SalesForceAddressId", DataConverter.getSaltString(18,"mixType"));

        String firstName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(3,"lowerStringType");
        requestParams.put("FirstName", firstName);

        String lastName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(3,"lowerStringType");
        requestParams.put("LastName", lastName);

        String dayPhone="647"+DataConverter.getSaltString(7,"numberType");
        requestParams.put("DayPhone", dayPhone);

        String street=DataConverter.getSaltString(5,"numberType")+" "+DataConverter.getSaltString(8,"stringType")+" Road";
        requestParams.put("Street", street);

        if(userData!=null){
            for(Map.Entry<String,Object> objectEntry : userData.entrySet()){
                if(objectEntry.getKey().equalsIgnoreCase("FirstName")){
                    firstName=objectEntry.getValue().toString();
                    requestParams.put("FirstName",firstName);
                }

                if(objectEntry.getKey().equalsIgnoreCase("LastName")){
                    lastName=objectEntry.getValue().toString();
                    requestParams.put("LastName",lastName);
                }

                if(objectEntry.getKey().equalsIgnoreCase("DayPhone")){
                    dayPhone=objectEntry.getValue().toString();
                    requestParams.put("DayPhone",dayPhone);
                }

                if(objectEntry.getKey().equalsIgnoreCase("Street")){
                    street=objectEntry.getValue().toString();
                    requestParams.put("Street",street);
                }
            }
        }

        requestParams.put("IsDefault", isDefault);

        Response response= postApiCallResponseAfterAuthenticationFromJSON(requestParams, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/cart/shippingaddress", access_token);
        Map<String,Object> map=new HashMap<>();
        if(response.statusCode()!=200){
            map.put("Response",response);
            return map;
        }

        accountCartGet= JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
        int shippingIdAfterAdd=accountCartGet.getShippingAddress().getId();

        map.put("shippingIdBefore",shippingIdBeforeAdd);
        map.put("shippingIdAfter",shippingIdAfterAdd);
        map.put("Response",response);

        return map;
    }

    /**
     * To create a shipping address for an account cart with an existing shipping address
     * POST API: https://qa-tsc.tsc.ca/api/v2/en/accounts/{customerEDP}/cart/shippingaddress
     * @param customerEDP - String
     * @param access_token - String
     * @param bSameAsCurrent - boolean - true for using current shipping address while false for using the one from Buyer's shipping address
     * @return Map<String,Object> - including shippingIdBefore and shippingIdAfter, API calling response
     * @throws IOException
     * @throws ParseException
     */
    public Map<String,Object> createShippingAddressIntoAccountCartWithExistingShippingAddress(String customerEDP,String access_token,boolean bSameAsCurrent) throws IOException, ParseException {
        Response getCartResponse=getAccountCartContentWithCustomerEDP(customerEDP, access_token);
        CartResponse accountCartGet= JsonParser.getResponseObject(getCartResponse.asString(), new TypeReference<CartResponse>() {});
        int shippingIdBeforeAdd=accountCartGet.getShippingAddress().getId();
        CartResponse.AddressClass lsBody;
        if(bSameAsCurrent){
            lsBody=accountCartGet.getShippingAddress();
        }
        else{
            int currentId=accountCartGet.getShippingAddress().getId();
            List<Integer> lstBuyerId=this.getBuyerShippingAddressId(accountCartGet);
            int selectedIndex=0;
            for(int i=0;i<lstBuyerId.size();i++){
                int buyerId=lstBuyerId.get(i);
                if(buyerId!=currentId){
                    selectedIndex=i;
                    break;
                }
            }
            lsBody=accountCartGet.getBuyer().getShippingAddresses().get(selectedIndex);
        }

        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(lsBody);

        reporter.reportLog(jsonString);
        JSONParser parser = new JSONParser();
        JSONObject requestParams = (JSONObject) parser.parse(jsonString);

        Response response= postApiCallResponseAfterAuthenticationFromJSON(requestParams, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/cart/shippingaddress", access_token);
        Map<String,Object> map=new HashMap<>();
        if(bSameAsCurrent){
            map.put("shippingIdBefore",shippingIdBeforeAdd);
            map.put("shippingIdAfter",-1);
            map.put("Response",response);
        }
        else{
            accountCartGet= JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
            int shippingIdAfterAdd=accountCartGet.getShippingAddress().getId();
            map.put("shippingIdBefore",shippingIdBeforeAdd);
            map.put("shippingIdAfter",shippingIdAfterAdd);
            map.put("Response",response);
        }

        return map;
    }

    /**
     * To get Info From Existing Cart Json File
     * @return Map<String,Object> - including cartGuidId, CustomerEDP and email
     */
    public Map<String,Object> getInfoFromExistingCartJsonFile() throws IOException, ParseException {
        JSONObject cartResponse = DataConverter.readJsonFileIntoJSONObject("results/UserCartResponse.json");
        Map<String,Object> map=new HashMap<>();
        if(cartResponse!=null){
            CartResponse accountCartData = JsonParser.getResponseObject(cartResponse.toString(), new TypeReference<CartResponse>() {});
            map.put("cartGuidId",accountCartData.getCartGuid());
            map.put("customerEDP",accountCartData.getBuyer().getCustomerEDP());
            map.put("email",accountCartData.getBuyer().getEmail());
        }
        else{
            map=null;
        }
        return map;
    }

    /**
     * To get Info From Existing Cart Json File
     * @return Map<String,Object> - including cartGuidId, CustomerEDP and email
     */
    public CartResponse getAccountInfoFromExistingCartJsonFile() throws IOException, ParseException {
        CartResponse accountCartData = null;
        JSONObject cartResponse = DataConverter.readJsonFileIntoJSONObject("results/UserCartResponse.json");
        if(cartResponse!=null)
            accountCartData = JsonParser.getResponseObject(cartResponse.toString(), new TypeReference<CartResponse>() {});
        else
            return null;
        return accountCartData;
    }

    /**
     * To get Buyer's shipping address Id list
     */
    public List<Integer> getBuyerShippingAddressId(CartResponse accountCart){
        List<Integer> lstId=new ArrayList<>();
        List<CartResponse.AddressClass> lstAddressId=accountCart.getBuyer().getShippingAddresses();
        for(CartResponse.AddressClass address:lstAddressId){
            lstId.add(address.Id);
        }
        return lstId;
    }

    /**
     * To update cart shipping address
     * @param - customerEDP - String
     * @param - access_token - String
     * @param - LsType - String
     *        - Same - using the same as current shipping address
     *        - Different - using different one from Buyer's shipping addresses
     *        - Invalid - invalid shipping address
     * @return - Map<String,Object> - including current cart shipping address Id, expected cart shipping address Id, and UPDATE API calling response
     */
    public Map<String,Object> updateCartShippingAddress(String customerEDP,String access_token,String lsType){
        Response getCartResponse=getAccountCartContentWithCustomerEDP(customerEDP, access_token);
        CartResponse accountCartGet= JsonParser.getResponseObject(getCartResponse.asString(), new TypeReference<CartResponse>() {});

        int lsCurrentCartShippingAddressId=accountCartGet.getShippingAddress().getId();
        int selectedId=lsCurrentCartShippingAddressId;

        switch(lsType){
            case "Same":
                selectedId=lsCurrentCartShippingAddressId;
                break;
            case "Different":
                List<Integer> lstId=getBuyerShippingAddressId(accountCartGet);
                for(int id:lstId){
                    if(id!=lsCurrentCartShippingAddressId){
                        selectedId=id;
                    }
                }
                break;
            case "Invalid":
                selectedId= Integer.parseInt(DataConverter.getSaltString(8,"numberType"));
                break;
        }

        JSONObject requestParams=new JSONObject();
        requestParams.put("ShippingAddressId",selectedId);
        Response response= updateApiCallResponseAfterAuthenticationFromJSON(requestParams, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/cart/shippingaddress", access_token);

        Map<String,Object> map=new HashMap<>();
        map.put("shippingIdBefore",lsCurrentCartShippingAddressId);
        map.put("shippingIdAfter",selectedId);
        map.put("Response",response);

        return map;
    }

    /**
     * To update cart shipping code
     * @param - customerEDP - String
     * @param - access_token - String
     * @param - LsType - String
     *        - Same - using the same as current ship code
     *        - Different - using different one from Available ship code
     *        - Invalid - invalid ship code
     * @return - Map<String,Object> - including current cart code, expected cart shipping code, and UPDATE API calling response
     */
    public Map<String,Object> updateCartShippingCode(String customerEDP,String access_token,String lsType){
        Response getCartResponse=getAccountCartContentWithCustomerEDP(customerEDP, access_token);
        CartResponse accountCartGet= JsonParser.getResponseObject(getCartResponse.asString(), new TypeReference<CartResponse>() {});

        String lsCurrentCartShippingCode=accountCartGet.getShipCode();
        String selectedCode=lsCurrentCartShippingCode;

        switch(lsType){
            case "Same":
                selectedCode=lsCurrentCartShippingCode;
                break;
            case "Different":
                List<String> lstCode=getAvailableShipMethodList(accountCartGet);
                for(String code:lstCode){
                    if(!code.equalsIgnoreCase(lsCurrentCartShippingCode)){
                        selectedCode=code;
                    }
                }
                break;
            case "Invalid":
                selectedCode= DataConverter.getSaltString(2,"mixType");
                break;
        }

        JSONObject requestParams=new JSONObject();
        requestParams.put("ShipCode",selectedCode);
        Response response= updateApiCallResponseAfterAuthenticationFromJSON(requestParams, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/cart/shipmethod", access_token);

        Map<String,Object> map=new HashMap<>();
        map.put("shipCodeBefore",lsCurrentCartShippingCode);
        map.put("shipCodeAfter",selectedCode);
        map.put("Response",response);

        return map;
    }

    /**
     * @param - customerEDP - Customer EDP Number where cart is created
     * @param - access_token_User - User access token for api authentication
     * @param - appGuidId - App cart GuidId
     * @return - Response - API Response after cart merging
     */
    public Response mergeUserCartWithAppCart(String customerEDP, String access_token_user,String appCartGuidId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("CartGuid", appCartGuidId);

        String apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/" + customerEDP + "/cart";

        return updateApiCallResponseAfterAuthenticationFromJSON(jsonObject, apiEndPoint, access_token_user);
    }

    /**
     * @param - access_token - access token for api authentication
     * @param - customerEDP - customerEDP number
     * @return - Response - API Response after Cart GET calling
     */
    public Response deletePaymentDetailsForUserFromCart(String customerEDP,String creditCardId,String access_token) {
        return deleteApiCallResponseAfterAuthentication(propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/cart/payment/"+creditCardId, access_token);
    }

    /**
     * This functions checks if any CC is default and returns it. If no CC is default, it returns random CC
     */
    public AccountResponse.CreditCardsClass getCreditCardInfoDefault(List<AccountResponse.CreditCardsClass> creditCardsClassList){
        AccountResponse.CreditCardsClass creditCardsClass = null;
        for(AccountResponse.CreditCardsClass creditCard : creditCardsClassList){
            if(creditCard.isDefault()){
                creditCardsClass = creditCard;
                return creditCardsClass;
            }
        }
        if(creditCardsClass==null)
            return creditCardsClassList.get(0);
        return creditCardsClass;
    }

    /**
     * @param - JSONObject -config or body for input request
     * @param - String - cartGuidId on which promo will be applied
     * @param - access_token - access token for api authentication
     * @return - Response - API Response after AccountCart GET calling
     */
    public Response addPromoCodeToCartForUser(JSONObject config, String cartGuidId, String access_token) {
        String apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/carts/"+cartGuidId+"/promocode";
        return updateApiCallResponseAfterAuthenticationFromJSON(config,apiEndPoint,access_token);
    }

    /**
     * @param - access_token - access token for api authentication
     * @param - CartGuid - Cart Guid
     * @param - LineId- Cart Lines Id
     * @return - Response - API Response after Cart DELETE calling
     */
    public Response deletePromoCodeAppliedOnCart(String access_token, String cartGuidId) {
        String apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language") + "/carts/"+cartGuidId+"/promocode";
        return deleteApiCallResponseAfterAuthentication(apiEndPoint, access_token);
    }

    /**
     * This method will get double from string.
     * @param-String lsTarget: target string
     * @return double value
     */
    public double getDoubleFromString(String lsTarget) {
        lsTarget=lsTarget.replace(",", "").trim();

        String regex="\\d+\\.\\d+";
        String lsReturn="";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(lsTarget);
        while(matcher.find())
        {
            lsReturn=matcher.group();
        }

        return Double.parseDouble(lsReturn);
    }


}
