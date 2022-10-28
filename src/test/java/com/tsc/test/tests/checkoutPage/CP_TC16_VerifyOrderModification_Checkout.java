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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CP_TC16_VerifyOrderModification_Checkout extends BaseTest {
    @Test(groups={"Regression","Checkout","CheckoutMobTab"})
    public void CP_TC16_VerifyOrderModification_Checkout() throws IOException {
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
        PlaceOrderResponse placeOrderResponse = getMyAccountPageThreadLocal().placeOrderForUser(Integer.parseInt(customerEDP),accessToken,itemsToBeAdded,2,"1",true);
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

        reporter.reportLog("Go to order modification page");
        getMyAccountPageThreadLocal().editPlacedOrderForUser(placeOrderResponse,myAccountOrderStatusURL);

        int presetInstallmentNumber=2;
        String lsOrderNumberForOrderModification=getOrderModificationThreadLocal().getOrderNumber();

        List<Map<String,Object>> existingOrderMapList=getOrderModificationThreadLocal().getExistingOrderListDesc();

        String lsPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode().get(0);
        getOrderModificationThreadLocal().addPromoteCode(lsPromoteCode);

        Map<String,Object> addToBagPopUpData = getProductDetailPageThreadLocal().addItemsToModifiedOrderForUser(newItemToBeAddedKeyword);
        String lsOrderNumberOnAddToBagWindow= (String) addToBagPopUpData.get("productOrderNumber");
        if(lsOrderNumberForOrderModification.equalsIgnoreCase(lsOrderNumberOnAddToBagWindow)){
            reporter.reportLogPass("The order number:"+lsOrderNumberForOrderModification+" for order modification is the same as the one:"+lsOrderNumberOnAddToBagWindow+" for add to bag popup window.");
        }
        else{
            reporter.reportLogFail("The order number:"+lsOrderNumberForOrderModification+" for order modification is not the same as the one:"+lsOrderNumberOnAddToBagWindow+" for add to bag popup window.");
        }

        List<Map<String,Object>> newlyAddedOrderMapList=getOrderModificationThreadLocal().getNewlyAddedOrderListDesc();

        reporter.reportLog("Verify Linkage Between AddToBag Item And Newly Added Order List");
        getOrderModificationThreadLocal().verifyLinkageBetweenAddToBagItemAndNewlyAddedOrderList(newlyAddedOrderMapList,addToBagPopUpData);

        Map<String,Object> orderSummaryMap=getOrderModificationThreadLocal().getOrderSummaryDesc();
        Map<String,Object> easyPaymentMap=getOrderModificationThreadLocal().getEasyPayDesc();

        reporter.reportLog("Go to checkout page");
        getOrderModificationThreadLocal().goToCheckoutPage();

        reporter.reportLog("Verify Initial Status for Product List Expanded Section");
        getRegularCheckoutThreadLocal().verifyProductListExpandedSectionInitialStatusThenExpanded();

        reporter.reportLog("Verify contents for items being added order list");
        getRegularCheckoutThreadLocal().verifyMandatoryContentsForCheckoutProductListForOrderModification(true);
        getRegularCheckoutThreadLocal().verifyOptionalContentsForCheckoutProductListForOrderModification(true);

        reporter.reportLog("Verify contents for existing order list");
        getRegularCheckoutThreadLocal().verifyMandatoryContentsForCheckoutProductListForOrderModification(false);
        getRegularCheckoutThreadLocal().verifyOptionalContentsForCheckoutProductListForOrderModification(false);

        reporter.reportLog("Verify contents for Address And Payment section");
        getRegularCheckoutThreadLocal().verifyAddressAndPaymentContentsForOrderModification();

        reporter.reportLog("Verify Promote Code Contents");
        getRegularCheckoutThreadLocal().verifyPromoteCodeContentsForOrderModification(lsPromoteCode);

        List<Map<String,Object>> productListMapForItemsBeingAdded=getRegularCheckoutThreadLocal().getCheckoutItemListDescForOrderModification("all",true);
        Map<String,Object> itemCountAndSubTotalMapForItemsBeingAddedProductList=getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForItemsBeingAdded);
        int itemCountForItemsBeingAddedProductList= (int) itemCountAndSubTotalMapForItemsBeingAddedProductList.get("itemCount");
        float subTotalForItemsBeingAddedProductList= (float) itemCountAndSubTotalMapForItemsBeingAddedProductList.get("subTotal");

        List<Map<String,Object>> productListMapForExistingItems=getRegularCheckoutThreadLocal().getCheckoutItemListDescForOrderModification("all",false);
        Map<String,Object> itemCountAndSubTotalMapForExistingItemsProductList=getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForExistingItems);
        int itemCountForExistingItemsProductList= (int) itemCountAndSubTotalMapForExistingItemsProductList.get("itemCount");
        float subTotalForExistingItemsProductList= (float) itemCountAndSubTotalMapForExistingItemsProductList.get("subTotal");

        reporter.reportLog("Verify Order Summary Business Logic");
        Map<String,Object> orderSummaryDescMapOnCheckoutPageForOrderModification =getRegularCheckoutThreadLocal().getOrderSummaryDescForOrderModification();
        getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogicForOrderModification(subTotalForItemsBeingAddedProductList+subTotalForExistingItemsProductList, orderSummaryDescMapOnCheckoutPageForOrderModification,null);

        reporter.reportLog("Verify easy payment Business Logic");
        Map<String,Object> easyPaymentDescMapOnCheckoutPageForOrderModification =getRegularCheckoutThreadLocal().getEasyPayDesc();
        getRegularCheckoutThreadLocal().verifyInstallmentBusinessLogic(presetInstallmentNumber, orderSummaryDescMapOnCheckoutPageForOrderModification);

        reporter.reportLog("Verify newly added Order List Linkage Between OrderModificationPage And CheckoutPage");
        getRegularCheckoutThreadLocal().verifyOrderListLinkageBetweenOrderModificationPageAndCheckoutPage(newlyAddedOrderMapList,productListMapForItemsBeingAdded);

        reporter.reportLog("Verify existing Order List Linkage Between OrderModificationPage And CheckoutPage");
        getRegularCheckoutThreadLocal().verifyOrderListLinkageBetweenOrderModificationPageAndCheckoutPage(existingOrderMapList,productListMapForExistingItems);

        reporter.reportLog("Verify orderSummary Linkage Between OrderModificationPage And CheckoutPage");
        getRegularCheckoutThreadLocal().verifyOrderSummaryLinkageBetweenOrderModificationPageAndCheckoutPage(orderSummaryMap, orderSummaryDescMapOnCheckoutPageForOrderModification);

        reporter.reportLog("Verify easyPayment Linkage Between OrderModificationPage And CheckoutPage");
        getRegularCheckoutThreadLocal().verifyEasyPaymentLinkageBetweenOrderModificationPageAndCheckoutPage(easyPaymentMap, easyPaymentDescMapOnCheckoutPageForOrderModification);

    }
}
