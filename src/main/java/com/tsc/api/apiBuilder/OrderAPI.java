package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.pojo.GetOrderListResponse;
import com.tsc.api.util.JsonParser;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tsc.pages.base.BasePage.reporter;


public class OrderAPI extends ApiClient {
    public OrderAPI() throws IOException { super(); }

    /**
     * @param - GuidId - Cart Guid Id
     * @param - customerEDP - Customer EDP Number where cart is created
     * @param - access_token - access token for api authentication
     * @return - Response - API Calling Response
     */
    public Response placeOrder(String GuidId,String customerEDP,String access_token,List<Long> relatedCartIds){
        JSONObject jsonObject = new JSONObject();
        Response response = null;
        String apiEndPoint = null;

        apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language") + "/accounts/" + customerEDP + "/orders";

        //Generate Json body
        jsonObject.put("CartGuid", GuidId);
        jsonObject.put("RelatedCartIds", relatedCartIds);
        jsonObject.put("EsmUserId", "");
        jsonObject.put("DeviceInfo", "");
        jsonObject.put("TrackingCode", "");
        jsonObject.put("PaypalTransactionId", "");
        jsonObject.put("UpsLocationId", "");

        response = this.postApiCallResponseAfterAuthenticationFromJSON(jsonObject, apiEndPoint, access_token);

        return response;
    }

    /**
     * @param - customerEDP - Customer EDP Number where cart is created
     * @param - access_token - access token for api authentication
     * @return - Response - API Calling Response
     */
    public Response getOrderList(String customerEDP,String access_token){
        Response response = null;
        String apiEndPoint = null;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -100);
        String fromDate=dateFormat.format(cal.getTime());
        cal.add(Calendar.DATE, +101);
        String toDate=dateFormat.format(cal.getTime());

        apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language") + "/accounts/" + customerEDP + "/orders";
        String lsQueryParam="?page=1&pageSize=10&fromDate="+fromDate+"&toDate="+toDate+"&validate=false";
        apiEndPoint+=lsQueryParam;
//        reporter.reportLog(apiEndPoint);

        response = this.getApiCallResponseAfterAuthentication(null,apiEndPoint, access_token);

        return response;
    }

    /**
     * @param - customerEDP - Customer EDP Number where cart is created
     * @param - access_token - access token for api authentication
     * @param - orderNo - order No
     * @return - Response - API Calling Response
     */
    public Response getGivenOrder(String customerEDP,String access_token,String orderNO){
        Response response = null;
        String apiEndPoint = null;

        apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language") + "/accounts/" + customerEDP + "/orders/"+orderNO;

        response = this.getApiCallResponseAfterAuthentication(null,apiEndPoint, access_token);

        return response;
    }

    /**
     * @param - customerEDP - Customer EDP Number where cart is created
     * @param - access_token - access token for api authentication
     * @return - Response - API Calling Response
     */
    public Response getOrderReview(String customerEDP,String access_token){
        Response response = null;
        String apiEndPoint = null;

        apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language") + "/accounts/" + customerEDP + "/orderreview";

        response = this.getApiCallResponseAfterAuthentication(null,apiEndPoint, access_token);

        return response;
    }

    /**
     * @param - GetOrderListResponse - getOrderListResponse
     * @return - List<String> - orderNo List
     */
    public List<String> getOrderNoList(GetOrderListResponse getOrderListResponse){
        List<String> orderNoList=new ArrayList<>();
        for(GetOrderListResponse.OrderSummary orderSummary: getOrderListResponse.getOrderSummary()){
            orderNoList.add(orderSummary.OrderNo);
        }

        return orderNoList;
    }

    /**
     * @param - GetOrderListResponse - getOrderListResponse
     * @param - String - orderNo
     * @return - double - order Amount
     */
    public double getOrderAmountByOrderNo(GetOrderListResponse getOrderListResponse,String orderNo){
        double orderAmount=0.0;
        for(GetOrderListResponse.OrderSummary orderSummary: getOrderListResponse.getOrderSummary()){
            if(orderSummary.getOrderNo().equalsIgnoreCase(orderNo)){
                getDoubleFromString(orderSummary.getOrderTotal());
                break;
            }
        }

        return orderAmount;
    }

    /**
     * @param - GetOrderListResponse - getOrderListResponse
     * @return - double - Total order Amount in order list
     */
    public double getTotalOrderAmountInOrderList(GetOrderListResponse getOrderListResponse){
        double orderAmount=0.0;
        for(GetOrderListResponse.OrderSummary orderSummary: getOrderListResponse.getOrderSummary()){
            getDoubleFromString(orderSummary.getOrderTotal());
        }

        return orderAmount;
    }

    /**
     * @param - String - access_token
     * @param - String - CartGuid
     * @return - double - Total order Amount for given cart
     */
    public double getCartOrderAmountWithGuidId(String access_token,String CartGuid) throws IOException {
       CartAPI cartAPI=new CartAPI();
       Response cartResponse=cartAPI.getCartContentWithCartGuid(access_token,CartGuid);
       CartResponse accountCart = JsonParser.getResponseObject(cartResponse.asString(), new TypeReference<CartResponse>() {});
//       reporter.reportLog(cartResponse.asString());
       return accountCart.getOrderSummary().getTotalOrderAmount();
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
