package com.tsc.test.tests.orderModification;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.pojo.GetGivenOrderResponse;
import com.tsc.api.pojo.PlaceOrderResponse;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OM_TC04_VerifyOrderModification_AddPromoteCode_AddADPProductItem extends BaseTest {
    /*
     * CER-906
     */
    @Test(groups={"Regression","OrderModification"})
    public void OM_TC04_VerifyOrderModification_AddPromoteCode_AddADPProductItem() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();
        String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);
        String orderNumber = null;

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
        //PlaceOrderResponse placeOrderResponse = getMyAccountPageThreadLocal().placeOrderForUser(Integer.parseInt(customerEDP),accessToken,itemsToBeAdded,2,"1",true,517281);
        PlaceOrderResponse placeOrderResponse = null;
        GetGivenOrderResponse getGivenOrderResponse = getMyAccountPageThreadLocal().getExistingOrderInEditableMode(2,customerEDP,accessToken);
        if(getGivenOrderResponse==null){
            placeOrderResponse = getMyAccountPageThreadLocal().placeOrderForUser(Integer.parseInt(customerEDP),accessToken,itemsToBeAdded,2,"1",true,0);
            orderNumber = placeOrderResponse.getOrderedCart().getOrderSummary().getOrderNo();
        }else
            orderNumber = getGivenOrderResponse.getOrderSummary().getOrderNo();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
        try {
            getShoppingCartThreadLocal().waitForCondition(Driver -> {
                return Integer.valueOf(getglobalheaderPageThreadLocal().CartBagCounter.getText()) >= 0;
            }, 6000);
        }
        catch(Exception e){
            (new BasePage(this.getDriver())).applyStaticWait(3000);
        }
        getMyAccountPageThreadLocal().editPlacedOrderForUser(orderNumber,myAccountOrderStatusURL);

        int presetInstallmentNumber=2;
        String lsOrderNumberForOrderModification=getOrderModificationThreadLocal().getOrderNumber();

        reporter.reportLog("Verify Header Contents for Modify Order ");
        getOrderModificationThreadLocal().verifyModifyOrderHeaderContents();

        reporter.reportLog("Verify Cancel Modification Button for Modify Order");
        getOrderModificationThreadLocal().verifyModifyOrderCancelModificationButton();

        reporter.reportLog("Verify Change Mode Contents for Modify Order");
        getOrderModificationThreadLocal().verifyModifyOrderChangeModeContents();

        reporter.reportLog("Verify Header Contents for Existing Order");
        getOrderModificationThreadLocal().verifyExistingOrderHeaderContents();

        reporter.reportLog("Verify Existing Order list");
        getOrderModificationThreadLocal().verifyOrderList(false);

        reporter.reportLog("Verify Order Summary Contents before adding new order list");
        getOrderModificationThreadLocal().verifyOrderSummaryContents();

        reporter.reportLog("Verify Easy Payment Contents before adding new order list");
        getOrderModificationThreadLocal().verifyEasyPayContents();

        reporter.reportLog("Verify Checkout Contents before adding new order list");
        getOrderModificationThreadLocal().verifyCheckoutContents(false);

        List<Map<String,Object>> existingOrderMapList=getOrderModificationThreadLocal().getExistingOrderListDesc();
        Map<String,Object> calculatedCheckoutItemCountAndSubTotalMap=getOrderModificationThreadLocal().getCalculatedCheckoutItemCountAndSubTotal(existingOrderMapList);
        int itemCountForExistingOrderList= (int) calculatedCheckoutItemCountAndSubTotalMap.get("itemCount");
        float subTotalForExistingOrderList= (float) calculatedCheckoutItemCountAndSubTotalMap.get("subTotal");

        reporter.reportLog("Verify OrderSummary Business Logic");
        Map<String,Object> orderSummaryMap=getOrderModificationThreadLocal().getOrderSummaryDesc();
        getOrderModificationThreadLocal().verifyOrderSummaryBusinessLogic(itemCountForExistingOrderList,subTotalForExistingOrderList,orderSummaryMap,null);

        reporter.reportLog("Verify easy payment Business Logic");
        Map<String,Object> easyPaymentMap=getOrderModificationThreadLocal().getEasyPayDesc();
        getOrderModificationThreadLocal().verifyInstallmentBusinessLogic(presetInstallmentNumber,orderSummaryMap);

        reporter.reportLog("Add Promote Code");
        String lsPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode().get(0);
        getOrderModificationThreadLocal().addPromoteCode(lsPromoteCode);

        reporter.reportLog("Add ADP product item through UI");
        String lsADPProductNumber = TestDataHandler.constantData.getSearchResultPage().getLbl_AutoDeliverykeyword();
        Map<String,Object> addToBagPopUpData=getOrderModificationThreadLocal().addProductItems(lsADPProductNumber,true);

        String lsOrderNumberOnAddToBagWindow= (String) addToBagPopUpData.get("productOrderNumber");
        if(lsOrderNumberForOrderModification.equalsIgnoreCase(lsOrderNumberOnAddToBagWindow)){
            reporter.reportLogPass("The order number:"+lsOrderNumberForOrderModification+" for order modification is the same as the one:"+lsOrderNumberOnAddToBagWindow+" for add to bag popup window.");
        }
        else{
            reporter.reportLogFail("The order number:"+lsOrderNumberForOrderModification+" for order modification is not the same as the one:"+lsOrderNumberOnAddToBagWindow+" for add to bag popup window.");
        }

        reporter.reportLog("Verify newly added order list");
        getOrderModificationThreadLocal().verifyOrderList(true);
        List<Map<String,Object>> newlyAddedOrderMapList=getOrderModificationThreadLocal().getNewlyAddedOrderListDesc();
        Map<String,Object> NewlyAddedCheckoutItemCountAndSubTotalMap=getOrderModificationThreadLocal().getItemCountAndSubTotalForNewlyAddedOrderList();
        int itemCountForNewlyAddedOrderList= (int) NewlyAddedCheckoutItemCountAndSubTotalMap.get("itemCount");
        float subTotalForNewlyAddedOrderList= (float) NewlyAddedCheckoutItemCountAndSubTotalMap.get("subTotal");

        reporter.reportLog("Verify Item Count And SubTotal For NewlyAddedOrderList");
        Map<String,Object> calculatedNewlyAddedCheckoutItemCountAndSubTotalMap=getOrderModificationThreadLocal().getCalculatedCheckoutItemCountAndSubTotal(newlyAddedOrderMapList);
        getOrderModificationThreadLocal().verifyItemCountAndSubTotalForNewlyAddedOrderList(NewlyAddedCheckoutItemCountAndSubTotalMap, calculatedNewlyAddedCheckoutItemCountAndSubTotalMap);

        reporter.reportLog("Verify Linkage Between AddToBag Item And Newly Added Order List");
        getOrderModificationThreadLocal().verifyLinkageBetweenAddToBagItemAndNewlyAddedOrderList(newlyAddedOrderMapList,addToBagPopUpData);

        reporter.reportLog("Verify OrderSummary Business Logic after adding new order list");
        orderSummaryMap=getOrderModificationThreadLocal().getOrderSummaryDesc();
        float lsPromoteCodeDiscountForOrderModification= (float) orderSummaryMap.get("promoteCodeValue");
        if(Math.abs(lsPromoteCodeDiscountForOrderModification)>0.1f){
            reporter.reportLogPass("The applied promote code discount:"+Math.abs(lsPromoteCodeDiscountForOrderModification)+" is greater than 0");
        }
        else{
            reporter.reportLogFail("The applied promote code discount:"+Math.abs(lsPromoteCodeDiscountForOrderModification)+" is not greater than 0");
        }
        getOrderModificationThreadLocal().verifyOrderSummaryBusinessLogic(itemCountForNewlyAddedOrderList+itemCountForExistingOrderList,subTotalForNewlyAddedOrderList+subTotalForExistingOrderList,orderSummaryMap,null);

        reporter.reportLog("Verify easy payment Business Logic after adding new order list");
        easyPaymentMap=getOrderModificationThreadLocal().getEasyPayDesc();
        getOrderModificationThreadLocal().verifyInstallmentBusinessLogic(presetInstallmentNumber,orderSummaryMap);

        reporter.reportLog("Verify Checkout Contents after adding new order list");
        getOrderModificationThreadLocal().verifyCheckoutContents(true);

        reporter.reportLog("Verify Navigating to order status page After Clicking Cancel Modification Button");
        getOrderModificationThreadLocal().verifyNavigatedPageAfterClickingCancelModificationButton(myAccountOrderStatusURL);

    }
}
