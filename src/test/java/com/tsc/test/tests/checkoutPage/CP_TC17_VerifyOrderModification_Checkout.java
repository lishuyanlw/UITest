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
import java.util.List;
import java.util.Map;

public class CP_TC17_VerifyOrderModification_Checkout extends BaseTest {
    @Test(groups={"Regression","Checkout","CheckoutMobTab"})
    public void CP_TC17_VerifyOrderModification_Checkout() throws IOException {
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

        List<Map<String,Object>> existingOrderMapList=getOrderModificationThreadLocal().getExistingOrderListDesc();
        Map<String,Object> calculatedCheckoutItemCountAndSubTotalMap=getOrderModificationThreadLocal().getCalculatedCheckoutItemCountAndSubTotal(existingOrderMapList);
        int itemCountForExistingOrderList= (int) calculatedCheckoutItemCountAndSubTotalMap.get("itemCount");
        float subTotalForExistingOrderList= (float) calculatedCheckoutItemCountAndSubTotalMap.get("subTotal");

        String lsPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode().get(0);
        getOrderModificationThreadLocal().addPromoteCode(lsPromoteCode);
        Map<String,Object> addToBagPopUpData = getProductDetailPageThreadLocal().addItemsToModifiedOrderForUser(newItemToBeAddedKeyword);

        getOrderModificationThreadLocal().verifyOrderList(true);
        List<Map<String,Object>> newlyAddedOrderMapList=getOrderModificationThreadLocal().getNewlyAddedOrderListDesc();
        Map<String,Object> NewlyAddedCheckoutItemCountAndSubTotalMap=getOrderModificationThreadLocal().getItemCountAndSubTotalForNewlyAddedOrderList();
        int itemCountForNewlyAddedOrderList= (int) NewlyAddedCheckoutItemCountAndSubTotalMap.get("itemCount");
        float subTotalForNewlyAddedOrderList= (float) NewlyAddedCheckoutItemCountAndSubTotalMap.get("subTotal");
        Map<String,Object> orderSummaryMap=getOrderModificationThreadLocal().getOrderSummaryDesc();
        getOrderModificationThreadLocal().verifyOrderSummaryBusinessLogic(itemCountForNewlyAddedOrderList+itemCountForExistingOrderList,subTotalForNewlyAddedOrderList+subTotalForExistingOrderList,orderSummaryMap,null);
//        easyPaymentMap=getOrderModificationThreadLocal().getEasyPayDesc();
//        getOrderModificationThreadLocal().verifyInstallmentBusinessLogic(presetInstallmentNumber,orderSummaryMap);

        getOrderModificationThreadLocal().goToCheckoutPage();

        getRegularCheckoutThreadLocal().verifyProductListExpandedSectionInitialStatusThenExpanded();
        getRegularCheckoutThreadLocal().verifyMandatoryContentsForCheckoutProductListForOrderModification(true);
        getRegularCheckoutThreadLocal().verifyOptionalContentsForCheckoutProductListForOrderModification(true);

        getRegularCheckoutThreadLocal().verifyMandatoryContentsForCheckoutProductListForOrderModification(false);
        getRegularCheckoutThreadLocal().verifyOptionalContentsForCheckoutProductListForOrderModification(false);

        getRegularCheckoutThreadLocal().verifyAddressAndPaymentContentsForOrderModification();
        getRegularCheckoutThreadLocal().verifyPromoteCodeContentsForOrderModification(lsPromoteCode);

        List<Map<String,Object>> productListMapForItemsBeingAdded=getRegularCheckoutThreadLocal().getCheckoutItemListDescForOrderModification("all",true);
        Map<String,Object> itemCountAndSubTotalMapForItemsBeingAddedProductList=getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForItemsBeingAdded);
        int itemCountForItemsBeingAddedProductList= (int) itemCountAndSubTotalMapForItemsBeingAddedProductList.get("itemCount");
        float subTotalForItemsBeingAddedProductList= (float) itemCountAndSubTotalMapForItemsBeingAddedProductList.get("subTotal");

        List<Map<String,Object>> productListMapForExistingItems=getRegularCheckoutThreadLocal().getCheckoutItemListDescForOrderModification("all",false);
        Map<String,Object> itemCountAndSubTotalMapForExistingItemsProductList=getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForExistingItems);
        int itemCountForExistingItemsProductList= (int) itemCountAndSubTotalMapForExistingItemsProductList.get("itemCount");
        float subTotalForExistingItemsProductList= (float) itemCountAndSubTotalMapForExistingItemsProductList.get("subTotal");

        Map<String,Object> orderSummaryDescMapForOrderModification=getRegularCheckoutThreadLocal().getOrderSummaryDescForOrderModification();
        getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogicForOrderModification(itemCountForItemsBeingAddedProductList+itemCountForExistingItemsProductList,subTotalForItemsBeingAddedProductList+subTotalForExistingItemsProductList,orderSummaryDescMapForOrderModification,null);



    }
}
