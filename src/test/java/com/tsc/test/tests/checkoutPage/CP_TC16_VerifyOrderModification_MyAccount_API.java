package com.tsc.test.tests.checkoutPage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.pojo.PlaceOrderResponse;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CP_TC16_VerifyOrderModification_MyAccount_API extends BaseTest {
    @Test(groups={"Regression","Checkout","CheckoutMobTab"})
    public void CP_TC16_VerifyOrderModification_MyAccount_API() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();
        String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);

        //Setting up initial test environment by deleting all cards associated with user and cart
        CartAPI cartAPI = new CartAPI();
        Response response = cartAPI.getAccountCartContentWithCustomerEDP(customerEDP,accessToken);
        CartResponse cartResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
        getRegularCheckoutThreadLocal().deleteCreditCardForUserAndFromCart(cartResponse,customerEDP,accessToken);

        //Adding TSC Credit Card to user for test
        getShoppingCartThreadLocal().addTSCCreditCardForUser(null,customerEDP,accessToken);

        String myAccountOrderStatusURL = TestDataHandler.constantData.getMyAccount().getLnk_orderStatusURL();
        List<String> newItemToBeAddedKeyword = TestDataHandler.constantData.getSearchResultPage().getLst_ShoppingCartSearchKeyword();
        List<Map<String,String>> itemsToBeAdded = TestDataHandler.constantData.getCheckOut().getLstOrderDetailItems();
        PlaceOrderResponse placeOrderResponse = getMyAccountPageThreadLocal().placeOrderForUser(Integer.parseInt(customerEDP),accessToken,itemsToBeAdded,true);
        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
        try {
            getShoppingCartThreadLocal().waitForCondition(Driver -> {
                return Integer.valueOf(getglobalheaderPageThreadLocal().CartBagCounter.getText()) > 0;
            }, 6000);
        }
        catch(Exception e){
            (new BasePage(this.getDriver())).applyStaticWait(3000);
        }
        getMyAccountPageThreadLocal().editPlacedOrderForUser(placeOrderResponse,myAccountOrderStatusURL);

        getOrderModificationThreadLocal().verifyModifyOrderHeaderContents();
        getOrderModificationThreadLocal().verifyModifyOrderCancelModificationButton();
        getOrderModificationThreadLocal().verifyModifyOrderChangeModeContents();
        getOrderModificationThreadLocal().verifyExistingOrderHeaderContents();
        getOrderModificationThreadLocal().verifyOrderList(false);
        getOrderModificationThreadLocal().verifyOrderSummaryContents();
//        getOrderModificationThreadLocal().verifyEasyPayContents();
        getOrderModificationThreadLocal().verifyCheckoutContents(false);

        List<Map<String,Object>> existingOrderMapList=getOrderModificationThreadLocal().getExistingOrderListDesc();
        Map<String,Object> calculatedCheckoutItemCountAndSubTotalMap=getOrderModificationThreadLocal().getCalculatedCheckoutItemCountAndSubTotal(existingOrderMapList);
        int itemCountForExistingOrderList= (int) calculatedCheckoutItemCountAndSubTotalMap.get("itemCount");
        float subTotalForExistingOrderList= (float) calculatedCheckoutItemCountAndSubTotalMap.get("subTotal");
        Map<String,Object> orderSummaryMap=getOrderModificationThreadLocal().getOrderSummaryDesc();
        getOrderModificationThreadLocal().verifyOrderSummaryBusinessLogic(itemCountForExistingOrderList,subTotalForExistingOrderList,orderSummaryMap,null);
//        Map<String,Object> easyPaymentMap=getOrderModificationThreadLocal().getEasyPayDesc();
//        getOrderModificationThreadLocal().verifyInstallmentBusinessLogic(presetInstallmentNumber,orderSummaryMap);

        String lsPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode().get(0);
        getOrderModificationThreadLocal().addPromoteCode(lsPromoteCode);

//        List<String> lstKeyword = TestDataHandler.constantData.getCheckOut().getLst_SearchingKeywordForPlaceOrder();
//        Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
//        outputDataCriteria.put("style", "1");
//        outputDataCriteria.put("size", "1");
//        String lsProductName=getProductDetailPageThreadLocal().getProductWithConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria(lstKeyword,outputDataCriteria);
//        getOrderModificationThreadLocal().addProductItems(lsProductName,true);

        Map<String,Object> addToBagPopUpData = getProductDetailPageThreadLocal().addItemsToModifiedOrderForUser(newItemToBeAddedKeyword);

        getOrderModificationThreadLocal().verifyOrderList(true);
        List<Map<String,Object>> newlyAddedOrderMapList=getOrderModificationThreadLocal().getNewlyAddedOrderListDesc();
        Map<String,Object> NewlyAddedCheckoutItemCountAndSubTotalMap=getOrderModificationThreadLocal().getItemCountAndSubTotalForNewlyAddedOrderList();
        int itemCountForNewlyAddedOrderList= (int) NewlyAddedCheckoutItemCountAndSubTotalMap.get("itemCount");
        float subTotalForNewlyAddedOrderList= (float) NewlyAddedCheckoutItemCountAndSubTotalMap.get("subTotal");
        orderSummaryMap=getOrderModificationThreadLocal().getOrderSummaryDesc();
        getOrderModificationThreadLocal().verifyOrderSummaryBusinessLogic(itemCountForNewlyAddedOrderList+itemCountForExistingOrderList,subTotalForNewlyAddedOrderList+subTotalForExistingOrderList,orderSummaryMap,null);
//        easyPaymentMap=getOrderModificationThreadLocal().getEasyPayDesc();
//        getOrderModificationThreadLocal().verifyInstallmentBusinessLogic(presetInstallmentNumber,orderSummaryMap);
        getOrderModificationThreadLocal().verifyCheckoutContents(true);

    }
}
