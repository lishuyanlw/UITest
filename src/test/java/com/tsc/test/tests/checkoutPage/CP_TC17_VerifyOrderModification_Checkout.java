package com.tsc.test.tests.checkoutPage;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CP_TC17_VerifyOrderModification_Checkout extends BaseTest {
    @Test(groups={"Regression","Checkout","CheckoutMobTab"})
    public void CP_TC17_VerifyOrderModification_Checkout() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();
/*
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
        PlaceOrderResponse placeOrderResponse = getMyAccountPageThreadLocal().placeOrderForUser(Integer.parseInt(customerEDP),accessToken,itemsToBeAdded,2,true);

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
*/
        //To empty the cart
        //Fetching test data from test data file
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
        getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

        //Delete all gift cards
        CartAPI cartAPI=new CartAPI();
        cartAPI.deleteAllGiftCardForUser(String.valueOf(customerEDP),accessToken);

        String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);

        List<String> lstKeywordList=TestDataHandler.constantData.getCheckOut().getLst_SearchingKeywordForPlaceOrder();
        Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
        outputDataCriteria.put("video", "1");
        outputDataCriteria.put("style", "1");
        outputDataCriteria.put("size", "1");
        outputDataCriteria.put("quantity", "2");
        String lsProductName=getProductDetailPageThreadLocal().getProductWithConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria(lstKeywordList,outputDataCriteria);
        Map<String,String> prpMap=getProductResultsPageThreadLocal().navigateFromPRPToPDP(lsProductName, true);
        getProductDetailPageThreadLocal().chooseGivenStyleAndSize(getProductDetailPageThreadLocal().selectedProduct.productEDPColor,getProductDetailPageThreadLocal().selectedProduct.productEDPSize);

        getProductDetailPageThreadLocal().openAddToBagPopupWindow();
        getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();
        int presetInstallmentNumber=getShoppingCartThreadLocal().setInstallmentNumberByRandomIndex();
        getShoppingCartThreadLocal().goToCheckoutPage();
        getRegularCheckoutThreadLocal().goToOrderConfirmationPage();
        getOrderConfirmationThreadLocal().goToOrderDetailsPage(null,null);
        getMyAccountPageThreadLocal().goToOrderModificationPage();

        List<Map<String,Object>> existingOrderMapList=getOrderModificationThreadLocal().getExistingOrderListDesc();
        Map<String,Object> calculatedCheckoutItemCountAndSubTotalMap=getOrderModificationThreadLocal().getCalculatedCheckoutItemCountAndSubTotal(existingOrderMapList);
        int itemCountForExistingOrderList= (int) calculatedCheckoutItemCountAndSubTotalMap.get("itemCount");
        float subTotalForExistingOrderList= (float) calculatedCheckoutItemCountAndSubTotalMap.get("subTotal");

        String lsPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode().get(0);
        getOrderModificationThreadLocal().addPromoteCode(lsPromoteCode);

        List<String> lstKeyword = TestDataHandler.constantData.getCheckOut().getLst_SearchingKeywordForPlaceOrder();
        outputDataCriteria= new HashMap<String,Object>();
        outputDataCriteria.put("style", "1");
        outputDataCriteria.put("size", "1");
        lsProductName=getProductDetailPageThreadLocal().getProductWithConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria(lstKeyword,outputDataCriteria);
        Map<String,Object> addToBagPopUpData=getOrderModificationThreadLocal().addProductItems(lsProductName,true);

//        Map<String,Object> addToBagPopUpData = getProductDetailPageThreadLocal().addItemsToModifiedOrderForUser(newItemToBeAddedKeyword);

        getOrderModificationThreadLocal().verifyOrderList(true);
        List<Map<String,Object>> newlyAddedOrderMapList=getOrderModificationThreadLocal().getNewlyAddedOrderListDesc();
        Map<String,Object> NewlyAddedCheckoutItemCountAndSubTotalMap=getOrderModificationThreadLocal().getItemCountAndSubTotalForNewlyAddedOrderList();
        int itemCountForNewlyAddedOrderList= (int) NewlyAddedCheckoutItemCountAndSubTotalMap.get("itemCount");
        float subTotalForNewlyAddedOrderList= (float) NewlyAddedCheckoutItemCountAndSubTotalMap.get("subTotal");
        Map<String,Object> orderSummaryMap=getOrderModificationThreadLocal().getOrderSummaryDesc();
        getOrderModificationThreadLocal().verifyOrderSummaryBusinessLogic(itemCountForNewlyAddedOrderList+itemCountForExistingOrderList,subTotalForNewlyAddedOrderList+subTotalForExistingOrderList,orderSummaryMap,null);
        Map<String,Object> easyPaymentMap=getOrderModificationThreadLocal().getEasyPayDesc();
        getOrderModificationThreadLocal().verifyInstallmentBusinessLogic(presetInstallmentNumber,orderSummaryMap);

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

        Map<String,Object> orderSummaryDescMapOnCheckoutPageForOrderModification =getRegularCheckoutThreadLocal().getOrderSummaryDescForOrderModification();
        getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogicForOrderModification(subTotalForItemsBeingAddedProductList+subTotalForExistingItemsProductList, orderSummaryDescMapOnCheckoutPageForOrderModification,null);

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

        List<Map<String,Object>> allOrderListMapWithNewlyAddedAndExistingItems=getRegularCheckoutThreadLocal().getAllOrderListMapWithNewlyAddedAndExistingItems(productListMapForItemsBeingAdded,productListMapForExistingItems);

        getRegularCheckoutThreadLocal().goToOrderConfirmationPage();
        List<Map<String,Object>> orderListMapOnOrderConfirmationPage=getOrderConfirmationThreadLocal().getOrderListDesc();
        getOrderConfirmationThreadLocal().verifyOrderListLinkageBetweenOrderConfirmationPageAndCheckoutPageForOrderModification(orderListMapOnOrderConfirmationPage,allOrderListMapWithNewlyAddedAndExistingItems);

        Map<String,Object> orderSummaryMapOnOrderConfirmationPage =getOrderConfirmationThreadLocal().getOrderSummaryDesc();
        getOrderConfirmationThreadLocal().verifyOrderSummaryLinkageBetweenOrderConfirmationPageAndCheckoutPageForOrderModification(orderSummaryMapOnOrderConfirmationPage, orderSummaryDescMapOnCheckoutPageForOrderModification);

        Map<String,Object> easyPaymentMapOnOrderConfirmationPage=getOrderConfirmationThreadLocal().getEasyPayDesc();
        getOrderConfirmationThreadLocal().verifyEasyPaymentLinkageBetweenOrderConfirmationPageAndCheckoutPage(easyPaymentMapOnOrderConfirmationPage,easyPaymentDescMapOnCheckoutPageForOrderModification);
    }
}
