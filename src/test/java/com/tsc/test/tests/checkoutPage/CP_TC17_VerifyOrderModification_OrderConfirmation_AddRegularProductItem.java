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

public class CP_TC17_VerifyOrderModification_OrderConfirmation_AddRegularProductItem extends BaseTest {
    /*
     * CER-905
     */
    @Test(groups={"Regression","Checkout","CheckoutMobTab"})
    public void CP_TC17_VerifyOrderModification_OrderConfirmation_AddRegularProductItem() throws IOException {
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
        List<String> newItemToBeAddedKeyword = TestDataHandler.constantData.getCheckOut().getLst_SearchingKeywordForPlaceOrder();
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
        String lsOrderNumberForOrderModification=getOrderModificationThreadLocal().getOrderNumber();

        String lsPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode().get(0);
        getOrderModificationThreadLocal().addPromoteCode(lsPromoteCode);

        Map<String,Object> addToBagPopUpData = getProductDetailPageThreadLocal().addItemsToModifiedOrderForUser(newItemToBeAddedKeyword,getOrderModificationThreadLocal());

        reporter.reportLog("Go to checkout page");
        getOrderModificationThreadLocal().goToCheckoutPage();
        getRegularCheckoutThreadLocal().expandBothNewAndExistingOrderListSection();

        List<Map<String,Object>> productListMapForItemsBeingAdded=getRegularCheckoutThreadLocal().getCheckoutItemListDescForOrderModification("all",true);
        List<Map<String,Object>> productListMapForExistingItems=getRegularCheckoutThreadLocal().getCheckoutItemListDescForOrderModification("all",false);
        Map<String,Object> orderSummaryDescMapOnCheckoutPageForOrderModification =getRegularCheckoutThreadLocal().getOrderSummaryDescForOrderModification();
        Map<String,Object> easyPaymentDescMapOnCheckoutPageForOrderModification =getRegularCheckoutThreadLocal().getEasyPayDesc();
        List<Map<String,Object>> allOrderListMapWithNewlyAddedAndExistingItems=getRegularCheckoutThreadLocal().getAllOrderListMapWithNewlyAddedAndExistingItems(productListMapForItemsBeingAdded,productListMapForExistingItems);

        Map<String,Object> shippingAndPaymentMapOnCheckoutPage=getRegularCheckoutThreadLocal().getShippingAndPaymentDescForOrderModification();

        reporter.reportLog("Go to Order Confirmation page");
        getRegularCheckoutThreadLocal().goToOrderConfirmationPage();

        reporter.reportLog("Verify OrderConfirmation header Contents");
        getOrderConfirmationThreadLocal().verifyOrderConfirmationContents();

        reporter.reportLog("Verify Receipt Contents");
        getOrderConfirmationThreadLocal().verifyReceiptContents();

        reporter.reportLog("Verify Order List Contents");
        getOrderConfirmationThreadLocal().verifyOrderListContentsForOrderModification();

        reporter.reportLog("Verify Payment Card Contents");
        getOrderConfirmationThreadLocal().verifyPaymentCardContentsForOrderModification();

        reporter.reportLog("Verify OrderSummary Contents");
        getOrderConfirmationThreadLocal().verifyOrderSummaryContents();

        reporter.reportLog("Verify EasyPayment Contents");
        getOrderConfirmationThreadLocal().verifyEasyPayContents();

        reporter.reportLog("Verify Common Questions Contents");
        getOrderConfirmationThreadLocal().verifyCommonQuestionsContents();

        String lsOrderNumberForOrderConfirmationPage=getOrderConfirmationThreadLocal().getOrderNumber();
        if(lsOrderNumberForOrderModification.substring(0,7).equalsIgnoreCase(lsOrderNumberForOrderConfirmationPage.substring(0,7))){
            reporter.reportLogPass("The order number:"+lsOrderNumberForOrderModification+" for order modification is the same as the one:"+lsOrderNumberForOrderConfirmationPage+" for order confirmation.");
        }
        else{
            reporter.reportLogFail("The order number:"+lsOrderNumberForOrderModification+" for order modification is not the same as the one:"+lsOrderNumberForOrderConfirmationPage+" for order confirmation.");
        }

        List<Map<String,Object>> orderListMapOnOrderConfirmationPage=getOrderConfirmationThreadLocal().getOrderListDescForOrderModification();
        Map<String,Object> itemCountAndSubTotalMapOnOrderConfirmationPage=getOrderConfirmationThreadLocal().getCheckoutItemCountAndSubTotal(orderListMapOnOrderConfirmationPage);
        int itemCountForOrderConfirmationList= (int) itemCountAndSubTotalMapOnOrderConfirmationPage.get("itemCount");
        float subTotalForOrderConfirmationList= (float) itemCountAndSubTotalMapOnOrderConfirmationPage.get("subTotal");

        reporter.reportLog("Verify OrderSummary Business Logic");
        Map<String,Object> orderSummaryMapOnOrderConfirmationPage =getOrderConfirmationThreadLocal().getOrderSummaryDesc();
        getOrderConfirmationThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForOrderConfirmationList,orderSummaryMapOnOrderConfirmationPage,null);

        reporter.reportLog("Verify OrderSummary EasyPayment Business Logic");
        Map<String,Object> easyPaymentMapOnOrderConfirmationPage=getOrderConfirmationThreadLocal().getEasyPayDesc();
        getOrderConfirmationThreadLocal().verifyInstallmentBusinessLogic(orderSummaryMapOnOrderConfirmationPage);

        reporter.reportLog("Verify Order List Linkage Between OrderConfirmationPage And CheckoutPage");
        getOrderConfirmationThreadLocal().verifyOrderListLinkageBetweenOrderConfirmationPageAndCheckoutPageForOrderModification(orderListMapOnOrderConfirmationPage,allOrderListMapWithNewlyAddedAndExistingItems);

        reporter.reportLog("Verify OrderSummary Linkage Between OrderConfirmationPage And CheckoutPage");
        getOrderConfirmationThreadLocal().verifyOrderSummaryLinkageBetweenOrderConfirmationPageAndCheckoutPageForOrderModification(orderSummaryMapOnOrderConfirmationPage, orderSummaryDescMapOnCheckoutPageForOrderModification);

        reporter.reportLog("Verify EasyPayment Linkage Between OrderConfirmationPage And CheckoutPage");
        getOrderConfirmationThreadLocal().verifyEasyPaymentLinkageBetweenOrderConfirmationPageAndCheckoutPage(easyPaymentMapOnOrderConfirmationPage,easyPaymentDescMapOnCheckoutPageForOrderModification);

        reporter.reportLog("Verify Shipping And Payment Linkage Between OrderConfirmationPage And CheckoutPage");
        Map<String,Object> shippingAndPaymentMapForOrderConfirmationPage=getOrderConfirmationThreadLocal().getShippingAndPaymentDescForOrderModification();
        getOrderConfirmationThreadLocal().verifyShippingAndPaymentLinkageBetweenOrderConfirmationPageAndCheckoutPageForOrderModification(shippingAndPaymentMapForOrderConfirmationPage,shippingAndPaymentMapOnCheckoutPage);
    }
}
