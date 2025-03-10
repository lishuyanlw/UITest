package com.tsc.api.apiBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.pojo.ErrorResponse;
import com.tsc.api.pojo.SecurityQuestionResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.api.util.JsonParser;
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
     * @param accessToken - String
     * @param customerEDP - String
     * @param userData - Map<String,Object>
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public Response updatingBillingAddressForUserInCart(String customerEDP,String accessToken,Map<String,Object> userData) {
        JSONObject requestParams=DataConverter.readJsonFileIntoJSONObject("test-data/DefaultShippingAddress.json");
        String firstName = null,lastName = null,dayPhone = null,street = null;
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

        Response response= updateApiCallResponseAfterAuthenticationFromJSON(requestParams, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/billingaddress", accessToken);
        if(response.statusCode()==200)
            return response;
        else
            return null;
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
    public List<AccountResponse.AddressClass> addShippingAddressForUser(String customerEDP,String accessToken,boolean isDefault,Map<String,Object> userData) throws IOException, ParseException {
        JSONObject requestParams=DataConverter.readJsonFileIntoJSONObject("test-data/DefaultShippingAddress.json");
        String firstName = null,lastName = null,dayPhone = null,street = null;
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
        }else{
            requestParams.put("Id", DataConverter.getSaltString(8,"numberType"));
            requestParams.put("SalesForceAddressId", DataConverter.getSaltString(18,"mixType"));

            firstName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(3,"lowerStringType");
            requestParams.put("FirstName", firstName);

            lastName=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(3,"lowerStringType");
            requestParams.put("LastName", lastName);

            dayPhone="647"+DataConverter.getSaltString(7,"numberType");
            requestParams.put("DayPhone", dayPhone);

            street=DataConverter.getSaltString(5,"numberType")+" "+DataConverter.getSaltString(8,"stringType")+" Road";
            requestParams.put("Street", street);
        }

        requestParams.put("IsDefault", isDefault);

        Response response= postApiCallResponseAfterAuthenticationFromJSON(requestParams, propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/shippingaddresses", accessToken);
        if(response.statusCode()==200){
            AccountResponse accountResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<AccountResponse>() {});
            return accountResponse.getShippingAddresses();
        }else
            return null;
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
    public Response deleteCreditCardFromUser(int creditCardId,String customerEDP,String access_token){
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
     * This function returns the Shipping Address associated for a user
     * @param  - accountResponse - AccountResponse object returned from api
     * @return - AccountResponse.AddressClass object returned for Shipping Address
     */
    public List<AccountResponse.AddressClass> getShippingAddressForUser(AccountResponse accountResponse,String customerEdp,String accessToken) throws IOException, ParseException {
        if(accountResponse!=null){
            return Arrays.asList(accountResponse.getBillingAddress());
        }else
            return this.addShippingAddressForUser(customerEdp,accessToken,true,null);
    }

    /**
     * This function deletes shipping address for a user
     * @param - addressId - id to be deleted
     * @param - customerEDP - edp number
     * @param - accessToken - access token
     * @return - Response Object from api
     */
    public Response deleteShippingAddressForUser(int addressId,String customerEDP,String accessToken){
        return deleteApiCallResponseAfterAuthentication(propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/shippingaddresses/"+addressId, accessToken);
    }

    /**
     * To get User Security Question List
     * @param - accessToken
     * @return
     */
    public List<SecurityQuestionResponse> getUserSecurityQuestionList(String accessToken){
        String apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/securityquestions";
        Response response=getApiCallResponseAfterAuthentication(null, apiEndPoint, accessToken);
        return JsonParser.getResponseObject(response.asString(), new TypeReference<List<SecurityQuestionResponse>>() {});
    }

    /**
     * To set User Security Question Answer
     * @param - String - customerEDP
     * @param - String - accessToken
     * @param - int - QuestionId
     * @param - -String - Answer
     * @return - Response
     */
    public Response setUserSecurityQuestionAnswer(String customerEDP,String accessToken, int QuestionId, String Answer){
        String apiEndPoint = propertyData.get("test_apiVersion") + "/" + propertyData.get("test_language")+"/accounts/"+customerEDP+"/securityquestion";
        JSONObject requestParams=new JSONObject();
        requestParams.put("QuestionId",QuestionId);
        requestParams.put("Answer",Answer);
        return postApiCallResponseAfterAuthenticationFromJSON(requestParams,apiEndPoint,accessToken);
    }

    /**
     * To remove all credit cards
     * @param customerEDP
     * @param access_token
     */
    public void removeAllCreditCard(String customerEDP, String access_token){
        Response response=getAccountDetailsFromCustomerEDP(customerEDP, access_token);
        AccountResponse accountResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<AccountResponse>() {});
        if(!accountResponse.getCreditCards().isEmpty()){
            List<AccountResponse.CreditCardsClass> creditCardList=accountResponse.getCreditCards();
            for(AccountResponse.CreditCardsClass creditCard:creditCardList){
                int creditCardId=creditCard.getId();
                deleteCreditCardFromUser(creditCardId,customerEDP,access_token);
            }
        }
    }
}
