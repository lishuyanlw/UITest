package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.DataConverter;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

import static com.tsc.pages.base.BasePage.reporter;

public class AccountAPI extends ApiClient {

    public AccountAPI() throws IOException { super(); }

    /**
     * To create a normal account
     * API: https://qa-tsc.tsc.ca/api/v2/en/accounts
     * @param accessToken
     * @param email - if null then generate email address automatically
     * @return Response - API calling response
     * @throws IOException
     * @throws ParseException
     */
    public Response createNormalAccount(String accessToken, String email, Map<String,Object> userData) {
        JSONObject requestParams=DataConverter.readJsonFileIntoJSONObject("test-data/NewUser.json");

        if(email==null){
            String lsEmail=DataConverter.getSaltString(8,"stringType")+"@"+DataConverter.getSaltString(5,"stringType")+".com";
            //String lsEmail=DataConverter.getSaltString(8,"stringType")+"@rogers.com";
            reporter.reportLog("Creating Normal Account with Email: "+lsEmail);
            requestParams.put("Email", lsEmail);
        }
        else{
            reporter.reportLog("Creating Normal Account with Email: "+email);
            requestParams.put("Email", email);
        }

        requestParams.put("Phone", DataConverter.getSaltString(10,"numberType"));
        requestParams.put("CustomerNumber", DataConverter.getSaltString(10,"numberType"));
        if(userData!=null){
            for(Map.Entry<String,Object> objectEntry : userData.entrySet()){
                if(objectEntry.getKey().equalsIgnoreCase("Password"))
                    requestParams.put("Password",objectEntry.getValue().toString());
                else if(objectEntry.getKey().equalsIgnoreCase("RetypedPassword"))
                    requestParams.put("RetypedPassword",objectEntry.getValue().toString());
                else if(objectEntry.getKey().equalsIgnoreCase("Province"))
                    requestParams.put("Province",objectEntry.getValue().toString());
                else if(objectEntry.getKey().equalsIgnoreCase("IsGuest"))
                    requestParams.put("IsGuest",Boolean.valueOf(objectEntry.getValue().toString()));
                else if(objectEntry.getKey().equalsIgnoreCase("IsPhoneCustomer"))
                    requestParams.put("IsPhoneCustomer",Boolean.valueOf(objectEntry.getValue().toString()));
            }
        }

        Response response = postApiCallResponseAfterAuthenticationFromJSON(requestParams, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts", accessToken);

        return response;
    }

    /**
     * To create a phone account
     * API: https://qa-tsc.tsc.ca/api/v2/en/accounts
     * @param accessToken
     * @param email - if null then generate email address automatically
     * @param phoneNumber -  if null then generate email address automatically
     * @param customerNumber -  if null then generate email address automatically
     * @return Response - API calling response
     * @throws IOException
     * @throws ParseException
     */
    public Response createPhoneAccount(String accessToken, String email,String phoneNumber,String customerNumber) throws IOException, ParseException {
        reporter.reportLog("Creating Phone Account");
        JSONObject requestParams=DataConverter.readJsonFileIntoJSONObject("test-data/NewUser.json");
        JSONObject userPassword = DataConverter.readJsonFileIntoJSONObject("results/UserPassword.json");

        requestParams.put("IsPhoneCustomer", true);

        if(email==null){
            //email= DataConverter.getSaltString(8,"stringType")+"@"+DataConverter.getSaltString(5,"stringType")+".com";
            requestParams.put("Email", DataConverter.getSaltString(8,"stringType")+"@"+DataConverter.getSaltString(5,"stringType")+".com");
        }
        else{
            requestParams.put("Email", email);
        }

        if(phoneNumber==null){
            requestParams.put("Phone", DataConverter.getSaltString(10,"numberType"));
        }
        else{
            requestParams.put("Phone", phoneNumber);
        }

        if(customerNumber==null){
            requestParams.put("CustomerNumber", DataConverter.getSaltString(5,"numberType"));
        }
        else{
            requestParams.put("CustomerNumber", customerNumber);
        }

        requestParams.put("Password",userPassword.get("password"));
        requestParams.put("RetypedPassword",userPassword.get("password"));

        return postApiCallResponseAfterAuthenticationFromJSON(requestParams, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts", accessToken);
    }

    /**
     * This method get Customer Details for a specific EDP
     * @param - String - customerEDP : customerEDP number for user
     * @param  - access_token - access_token for api
     * @return - Response - response fetched from api call
     */
    public Response getAccountDetailsFromCustomerEDP(String customerEDP, String access_token){
        return getApiCallResponseAfterAuthentication(null, propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language")+"/accounts/"+customerEDP,access_token);
    }

    /**
     * To update billing address for Street and isDefault info
     * PUT API: https://qa-tsc.tsc.ca/api/v2/en/accounts/{customerEDP}/billingaddresses
     * @param getResponse - AccountResponse
     * @param accessToken - String
     * @param customerEDP - String
     * @param bUpdateContents - boolean
     * @param isDefault - boolean
     * @param userData - Map<String,Object>
     * @return Map<String,Object> - including input values and API calling response
     * @throws IOException
     * @throws ParseException
     */
    public Map<String,Object> updatingBillingAddressForContentsAndIsDefaultInfoInAccount(AccountResponse getResponse,String customerEDP,String accessToken,boolean bUpdateContents, boolean isDefault,Map<String,Object> userData) throws IOException, ParseException {
        JSONObject requestParams= new JSONObject();

        requestParams.put("Id", getResponse.getBillingAddress().getId());
        requestParams.put("SalesForceAddressId", getResponse.getBillingAddress().getSalesForceAddressId());

        String firstName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(6,"lowerStringType");
        requestParams.put("FirstName", firstName);

        String lastName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(6,"lowerStringType");
        requestParams.put("LastName", lastName);

        String dayPhone="647"+DataConverter.getSaltString(7,"numberType");
        requestParams.put("DayPhone", dayPhone);

        String street;
        if(bUpdateContents){
            street=DataConverter.getSaltString(5,"numberType")+" "+DataConverter.getSaltString(8,"stringType")+" Road";
        }
        else{
            street=getResponse.getBillingAddress().getStreet();
        }
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

        String addressRef1=getResponse.getBillingAddress().getAddressRef1();
        requestParams.put("AddressRef1", addressRef1);

        String city=getResponse.getBillingAddress().getCity();
        requestParams.put("City", city);

        String state=getResponse.getBillingAddress().getState();
        requestParams.put("State", state);

        String zipCode=getResponse.getBillingAddress().getZipCode();
        requestParams.put("ZipCode", zipCode);

        requestParams.put("IsDefault", isDefault);

        String POBoxNumber=getResponse.getBillingAddress().getPOBoxNumber();
        requestParams.put("POBoxNumber", POBoxNumber);

        boolean isPOBox =getResponse.getBillingAddress().isPOBox();
        requestParams.put("IsPOBox", isPOBox);

        String address2Type=getResponse.getBillingAddress().getAddress2Type();
        requestParams.put("Address2Type", address2Type);

        String address2Value=getResponse.getBillingAddress().getAddress2Value();
        requestParams.put("Address2Value", address2Value);

        Response response= updateApiCallResponseAfterAuthenticationFromJSON(requestParams, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/billingaddress", accessToken);

        AddressDetails addressDetails=new AddressDetails();
        addressDetails.FirstName=firstName;
        addressDetails.LastName=lastName;
        addressDetails.DayPhone=dayPhone;
        addressDetails.Street=street;
        addressDetails.AddressRef1=addressRef1;
        addressDetails.City=city;
        addressDetails.State=state;
        addressDetails.ZipCode=zipCode;
        addressDetails.IsDefault=isDefault;
        addressDetails.POBoxNumber=POBoxNumber;
        addressDetails.IsPOBox=isPOBox;
        addressDetails.Address2Type=address2Type;
        addressDetails.Address2Value=address2Value;

        Map<String,Object> mapResult=new HashMap<>();
        mapResult.put("inputValue",addressDetails);
        mapResult.put("response",response);

        return mapResult;
    }

    /**
     * To add a shipping address into an account
     * POST API: https://qa-tsc.tsc.ca/api/v2/en/accounts/{customerEDP}/shippingaddresses
     * @param accessToken - String
     * @param customerEDP - String
     * @param isDefault - boolean
     * @param userData - Map<String,Object>
     * @return Map<String,Object> - including input values and API calling response
     * @throws IOException
     * @throws ParseException
     */
    public Map<String,Object> AddingShippingAddressIntoAccount(String customerEDP,String accessToken,boolean isDefault,Map<String,Object> userData) throws IOException, ParseException {
        JSONObject requestParams=DataConverter.readJsonFileIntoJSONObject("test-data/AccountAddingShippingAddressPost.json");

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

        Response response= postApiCallResponseAfterAuthenticationFromJSON(requestParams, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/shippingaddresses", accessToken);

        AddressDetails addressDetails=new AddressDetails();
        addressDetails.FirstName=firstName;
        addressDetails.LastName=lastName;
        addressDetails.DayPhone=dayPhone;
        addressDetails.Street=street;
        addressDetails.AddressRef1=(String)requestParams.get("AddressRef1");
        addressDetails.City=(String)requestParams.get("City");
        addressDetails.State=(String)requestParams.get("State");
        addressDetails.ZipCode=(String)requestParams.get("ZipCode");
        addressDetails.IsDefault=isDefault;
        addressDetails.POBoxNumber=(String)requestParams.get("POBoxNumber");
        addressDetails.IsPOBox=(boolean)requestParams.get("IsPOBox");
        addressDetails.Address2Type=(String)requestParams.get("Address2Type");
        addressDetails.Address2Value=(String)requestParams.get("Address2Value");

        Map<String,Object> mapResult=new HashMap<>();
        mapResult.put("inputValue",addressDetails);
        mapResult.put("response",response);

        return mapResult;
    }

    /**
     * To set Billing Address as default shipping address
     * POST API: https://qa-tsc.tsc.ca/api/v2/en/accounts/{customerEDP}/defaultshippingaddress
     * @param accessToken - String
     * @param customerEDP - String
     * @return Response - API calling response
     * @throws IOException
     * @throws ParseException
     */
    public Response setBillingAddressAsDefaultShippingAddressInAccount(String customerEDP,String accessToken) throws IOException, ParseException {
        return postApiCallResponseAfterAuthenticationFromJSON(null, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/defaultshippingaddress", accessToken);
    }

    /**
     * To update shipping address for Street and isDefault info
     * PUT API: https://qa-tsc.tsc.ca/api/v2/en/accounts/{customerEDP}/shippingaddresses/{addressid}
     * @param getResponse - AccountResponse
     * @param accessToken - String
     * @param customerEDP - String
     * @param bUpdateContents - boolean
     * @param isDefault - boolean
     * @param index - int
     * @param userData - Map<String,Object>
     * @return Map<String,Object> - including input values and API calling response
     * @throws IOException
     * @throws ParseException
     */
    public Map<String,Object> updatingShippingAddressForContentsAndIsDefaultInfoInAccount(AccountResponse getResponse,String customerEDP,String accessToken,boolean bUpdateContents, boolean isDefault,int index,Map<String,Object> userData) throws IOException, ParseException {
        JSONObject requestParams= new JSONObject();

        int addressId=getResponse.getShippingAddresses().get(index).getId();
        requestParams.put("Id", addressId);
        requestParams.put("SalesForceAddressId", getResponse.getShippingAddresses().get(index).getSalesForceAddressId());

        String firstName,lastName,dayPhone,street;
        if(bUpdateContents){
            firstName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(3,"lowerStringType");
            requestParams.put("FirstName", firstName);

            lastName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(3,"lowerStringType");
            requestParams.put("LastName", lastName);

            dayPhone="647"+DataConverter.getSaltString(7,"numberType");
            requestParams.put("DayPhone", dayPhone);

            street=DataConverter.getSaltString(5,"numberType")+" "+DataConverter.getSaltString(8,"stringType")+" Road";
            requestParams.put("Street", street);
        }
        else{
            firstName=getResponse.getShippingAddresses().get(index).getFirstName();
            requestParams.put("FirstName", firstName);

            lastName=getResponse.getShippingAddresses().get(index).getLastName();
            requestParams.put("LastName", lastName);

            dayPhone=getResponse.getShippingAddresses().get(index).getDayPhone();
            requestParams.put("DayPhone", dayPhone);

            street=getResponse.getShippingAddresses().get(index).getStreet();
            requestParams.put("Street", street);
        }

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

                if(objectEntry.getKey().equalsIgnoreCase("Id")){
                    addressId=Integer.parseInt(objectEntry.getValue().toString());
                }
            }
        }

        requestParams.put("AddressRef1", getResponse.getShippingAddresses().get(index).getAddressRef1());
        requestParams.put("City", getResponse.getShippingAddresses().get(index).getCity());
        requestParams.put("State", getResponse.getShippingAddresses().get(index).getState());
        requestParams.put("ZipCode", getResponse.getShippingAddresses().get(index).getZipCode());
        requestParams.put("IsDefault", isDefault);
        requestParams.put("POBoxNumber", getResponse.getShippingAddresses().get(index).getPOBoxNumber());
        requestParams.put("IsPOBox", getResponse.getShippingAddresses().get(index).isPOBox());
        requestParams.put("Address2Type", getResponse.getShippingAddresses().get(index).getAddress2Type());
        requestParams.put("Address2Value", getResponse.getShippingAddresses().get(index).getAddress2Value());

        Response response= updateApiCallResponseAfterAuthenticationFromJSON(requestParams, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/shippingaddresses/"+addressId, accessToken);

        AddressDetails addressDetails=new AddressDetails();
        addressDetails.FirstName=firstName;
        addressDetails.LastName=lastName;
        addressDetails.DayPhone=dayPhone;
        addressDetails.Street=street;
        addressDetails.AddressRef1=getResponse.getShippingAddresses().get(index).getAddressRef1();
        addressDetails.City=getResponse.getShippingAddresses().get(index).getCity();
        addressDetails.State=getResponse.getShippingAddresses().get(index).getState();
        addressDetails.ZipCode=getResponse.getShippingAddresses().get(index).getZipCode();
        addressDetails.IsDefault=isDefault;
        addressDetails.POBoxNumber=getResponse.getShippingAddresses().get(index).getPOBoxNumber();
        addressDetails.IsPOBox=getResponse.getShippingAddresses().get(index).isPOBox();
        addressDetails.Address2Type=getResponse.getShippingAddresses().get(index).getAddress2Type();
        addressDetails.Address2Value=getResponse.getShippingAddresses().get(index).getAddress2Value();

        Map<String,Object> mapResult=new HashMap<>();
        mapResult.put("inputValue",addressDetails);
        mapResult.put("response",response);

        return mapResult;
    }

    /**
     * To delete shipping address
     * DELETE API: https://qa-tsc.tsc.ca/api/v2/en/accounts/{customerEDP}/shippingaddresses/{addressid}
     * @param getResponse - AccountResponse
     * @param accessToken - String
     * @param customerEDP - String
     * @Param index - int
     * @return Response - API calling response
     * @throws IOException
     * @throws ParseException
     */
    public Response deletingShippingAddressInAccount(AccountResponse getResponse,String customerEDP,String accessToken,int index) throws IOException, ParseException {
        int addressId=getResponse.getShippingAddresses().get(index).getId();

        return deleteApiCallResponseAfterAuthentication(propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/shippingaddresses/"+addressId, accessToken);
     }

    /**
     * To find the matching shipping address sequential number by a given phone number
     * @param getResponse - AccountResponse
     * @param phoneNumber - String
     * @param street - String
     * @return Map<String,Object> - contains matching sequential number of list,address id, shipping body
     */
    public Map<String,Object> getMatchingShippingAddressNumberByGivenPhoneNumberAndStreet(AccountResponse getResponse, String phoneNumber,String street){
        Map<String,Object> mapReturn=new HashMap<>();
        int size=getResponse.getShippingAddresses().size();

         for(int i=0;i<size;i++){
            AccountResponse.AddressClass address=getResponse.getShippingAddresses().get(i);
            if(address.getDayPhone().equalsIgnoreCase(phoneNumber)&&address.getStreet().equalsIgnoreCase(street)){
                mapReturn.put("SN",i);
                mapReturn.put("addressId",address.getId());
                mapReturn.put("address",address);
                return mapReturn;
            }
        }
        return null;
    }

    /**
     *This method adds credit card details to user
     * @param-JSONObject jsonObject containing credit card details to be added
     * @param-String customerEDP for CC addition
     * @param-String access_token required for api call
     * @return-Response response object after api call
     */
    public Response addCreditCardToUser(JSONObject jsonObject,String customerEDP,String access_token) throws JsonProcessingException {
        return postApiCallResponseAfterAuthenticationFromJSON(jsonObject, propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language")+"/accounts/"+customerEDP+"/creditcards",access_token);
    }

    /**
     * This method fetches added credit card data from the user.
     * @param-CreditCardsClass - CreditCardsClass List containing all credit card information
     * @param-String - credit Card type that is to be fetched
     * @response - CreditCard class object for type
     */
    public AccountResponse.CreditCardsClass getCreditCardData(List<AccountResponse.CreditCardsClass> creditCardsClassList,String cardType){
        for(AccountResponse.CreditCardsClass creditCardsClass:creditCardsClassList){
            if(creditCardsClass.getType().equals(cardType))
                return creditCardsClass;
        }
        return null;
    }

    public static class AddressDetails {
        public String FirstName;
        public String LastName;
        public String DayPhone;
        public String Street;
        public String AddressRef1;
        public String City;
        public String State;
        public String ZipCode;
        public boolean IsDefault;
        public String POBoxNumber;
        public boolean IsPOBox;
        public String Address2Type;
        public String Address2Value;

        public AddressDetails() {
            init();
        }

        public void init() {
            this.FirstName = "";
            this.LastName = "";
            this.DayPhone = "";
            this.AddressRef1 = "";
            this.City = "";
            this.State = "";
            this.ZipCode = "";
            this.POBoxNumber = "";
            this.Address2Type = "";
            this.Address2Value = "";
        }
    }

    /**
     * @param-String - customerEDP for user
     * @param-String - creditCardId that is to be deleted from user account
     * @param-String - access token needed for authorization
     * @return-Response - api response after making DELETE call
     */
    public Response deleteCreditCardFromUser(String customerEDP,int creditCardId,String access_token){
        return this.deleteCreditCardFromUserAfterAuthentication(propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language")+"/accounts/"+customerEDP+"/creditcards/"+creditCardId,access_token);
    }

    /**
     * @param-String - customerEDP for user
     * @param-String - creditCardId that is to be updated for user
     * @param-String - access token needed for authorization
     * @return-Response - api response after making DELETE call
     */
    public Response updateCreditCardForUser(JSONObject config,String customerEDP,int creditCardId,String access_token){
        return this.updateCreditCardDetailsForUserAfterAuthentication(config,propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language")+"/accounts/"+customerEDP+"/creditcards/"+creditCardId,access_token);
    }

    /**
     * @param-AccountResponse.CreditCardsClass - creditCardsClass object for CC data that is to be updated
     * @param-JSONObject - jsonObject that is passed for updating value
     * @param-String - fieldToBeUpdated for CC
     * @return-JSONObject - updated JSONObject with updated CC data
     */
    public JSONObject updateCreditCardDetails(AccountResponse.CreditCardsClass creditCardsClass, JSONObject creditCardsData, JSONObject updatedCCData) throws JsonProcessingException {
        boolean flag = false;
        JSONObject updatedJSONObject = null;
        JSONObject creditCardDetails;
        Set<String> keys = creditCardsData.keySet();
        for(String key:keys){
            creditCardDetails = (JSONObject) creditCardsData.get(key);
            if(!key.contains("cart") && creditCardDetails.get("Number").equals(creditCardsClass.getNumber())){
                flag = true;
                if(updatedCCData!=null){
                    updatedJSONObject = creditCardDetails;
                    Set<String> updateKeys = updatedCCData.keySet();
                    for(String updateKey:updateKeys){
                        updatedJSONObject.put(updateKey,updatedCCData.get(updateKey));
                    }
                    updatedJSONObject.put("Id",creditCardsClass.getId());
                    updatedJSONObject.put("MaskedNumber",creditCardsClass.getMaskedNumber());
                }else{
                    ObjectMapper mapper = new ObjectMapper();
                    String creditClassDataString = mapper.writeValueAsString(creditCardsClass);
                    updatedJSONObject = new ObjectMapper().readValue(creditClassDataString, JSONObject.class);
                }
            }
            if(flag)
                break;
        }
        /**
        switch (fieldToBeUpdated.toLowerCase()){
            case "display_month":
                int creditCardDate = Integer.valueOf(creditCardsClass.getDisplayExpirationMonth());
                if(creditCardDate<30)
                    creditCardDate = creditCardDate+1;
                else
                    creditCardDate = creditCardDate-1;
                updatedJSONObject.put("DisplayExpirationMonth",String.valueOf(creditCardDate));
                break;
            default:
                reporter.reportLogFail("Please enter valid value for updating credit card details");
                break;
        }*/
        /**
         * if logic below is to return updated Credit Card Data when we have updated Credit Card Number
         * that doesn't exists in test data file
         */
        if(updatedJSONObject==null) {
            for(String key:keys){
                creditCardDetails = (JSONObject) creditCardsData.get(key);
                if(!key.contains("cart") && creditCardDetails.get("Type").equals(creditCardsClass.getType())){
                    flag = true;
                    updatedJSONObject = creditCardDetails;
                    Set<String> updateKeys = updatedCCData.keySet();
                    for(String updateKey:updateKeys){
                        updatedJSONObject.put(updateKey,updatedCCData.get(updateKey));
                    }
                    updatedJSONObject.put("Id",creditCardsClass.getId());
                    updatedJSONObject.put("MaskedNumber",creditCardsClass.getMaskedNumber());
                    updatedJSONObject.put("Number",creditCardsClass.getMaskedNumber());
                }
                if(flag)
                    break;
            }
        }
        return updatedJSONObject;
    }

    /**
     * @param-JSONObject - Body for api call
     * @param-String - customerEDP for user
     * @param-String - access token needed for authorization
     * @return-Response - api response after making DELETE call
     */
    public Response updateCartPaymentMethod(JSONObject config,String customerEDP,String access_token){
        return this.updateCreditCardDetailsForUserAfterAuthentication(config,propertyData.get("test_apiVersion")+"/"+propertyData.get("test_language")+"/accounts/"+customerEDP+"/cart/payment",access_token);
    }

}
