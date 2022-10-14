package com.tsc.test.tests.integration;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.pojo.Product;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IN_TC02_PRP_PDP_AddToBag_ShoppingCart_Checkout_OrderConfirmation extends BaseTest {
    /*
     * CER-845
     * CER-871
     */
    @Test(groups={"Integration","Regression"})
    public void IN_TC02_PRP_PDP_AddToBag_ShoppingCart_Checkout_OrderConfirmation() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

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

        List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
        Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
        outputDataCriteria.put("video", "1");
        outputDataCriteria.put("style", "1");
        outputDataCriteria.put("size", "1");
        outputDataCriteria.put("quantity", "2");
        String lsProductName=getProductDetailPageThreadLocal().getProductWithConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria(lstKeywordList,outputDataCriteria);

        reporter.reportLog("Compare the linkage information between PRP and PDP with product name: "+lsProductName);
        Map<String,String> prpMap=getProductResultsPageThreadLocal().navigateFromPRPToPDP(lsProductName, true);
        Map<String,String> pdpMap=getProductDetailPageThreadLocal().getFullInformationOnPDP(prpMap.get("productBrand")!=null,prpMap.get("productReviewCount")!=null,prpMap.get("productWasPrice")!=null,prpMap.get("productStyle")!=null,prpMap.get("productSize")!=null);
        getProductDetailPageThreadLocal().verifyLinkageInfoBetweenPRPAndPDP(prpMap,pdpMap);

        reporter.reportLog("Compare the linkage information between PDP and AddToBag with product name: "+lsProductName);
        getProductDetailPageThreadLocal().chooseGivenStyleAndSize(getProductDetailPageThreadLocal().selectedProduct.productEDPColor,getProductDetailPageThreadLocal().selectedProduct.productEDPSize);
        Map<String,Object> PDPMap=getProductDetailPageThreadLocal().getPDPDesc();

        getProductDetailPageThreadLocal().openAddToBagPopupWindow();
        Map<String,Object> AddToBagMap=getProductDetailPageThreadLocal().getAddToBagDesc();

        getProductDetailPageThreadLocal().verifyContentsBetweenPDPAndAddToBag(PDPMap,AddToBagMap);

        getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();

        Map<String,Object> shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("all");
        List<Map<String,Object>> shoppingCartProductListMap=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
        int shoppingCount=(int)shoppingCartMap.get("shoppingAmount");
        float shoppingSubTotal=(float)shoppingCartMap.get("shoppingSubTotal");
        Map<String,Object> orderSummaryInShoppingCartMap=getShoppingCartThreadLocal().getOrderSummaryDesc();

        //To verify Contents among PDP, AddToBag And ShoppingCartSection Details
        reporter.reportLog("Compare the linkage information between AddToBag and ShoppingCart with product name: "+lsProductName);
        getShoppingCartThreadLocal().verifyContentsOnShoppingCartSectionDetailsWithAddToBag(PDPMap,AddToBagMap,shoppingCartMap,false);

        if (getShoppingCartThreadLocal().checkIsDropdownMenuForInstallmentNumber()) {
            List<String> lstOptionText = getShoppingCartThreadLocal().getInstallmentOptions();
            getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(1));
        }
        int installmentsNumberForShoppingCart = getShoppingCartThreadLocal().getInstallmentNumber();
        Map<String,Object> easyPaymentInShoppingCartMap=getShoppingCartThreadLocal().getEasyPayDesc();

        getShoppingCartThreadLocal().goToCheckoutPage();

        BasePage basePage=new BasePage(this.getDriver());
        String lsPromoteCodeOnCheckoutPage="";
        if(!getRegularCheckoutThreadLocal().checkPromoteCodeRemoveButtonExisting()){
            List<String> lstPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode();
            lsPromoteCodeOnCheckoutPage=getRegularCheckoutThreadLocal().ApplyPromoteCodeForPositiveScenario(lstPromoteCode);
        }

        List<Map<String,Object>> checkoutProductListMap=getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
        Map<String, Object> summaryMapForCheckOutList = getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(checkoutProductListMap);
        int checkoutCount = (int) summaryMapForCheckOutList.get("itemCount");
        float checkoutSubTotal = (float) summaryMapForCheckOutList.get("subTotal");
        Map<String,Object> orderSummaryInCheckoutMap=getRegularCheckoutThreadLocal().getOrderSummaryDesc();
        Map<String,Object> easyPaymentInCheckoutMap=getRegularCheckoutThreadLocal().getEasyPayDesc();

        reporter.reportLog("Verify product list linkage between ShoppingCartPage and CheckoutPage");
        int findIndex;
        Map<String,Object> checkoutItem;
        for(Map<String,Object> shoppingCartItem:shoppingCartProductListMap){
            String lsShoppingCartText=(String)shoppingCartItem.get("productName");
            reporter.reportLog("Verify product:'"+lsShoppingCartText+"'");
            findIndex=getShoppingCartThreadLocal().findGivenProductIndexInProductList(shoppingCartItem,checkoutProductListMap);
            if(findIndex!=-1){
                checkoutItem=checkoutProductListMap.get(findIndex);
                getRegularCheckoutThreadLocal().verifyProductListLinkageBetweenShoppingCartPageAndCheckoutPage(shoppingCartItem,checkoutItem);
            }
            else{
                reporter.reportLogFail("");
            }
        }

        if(shoppingCount==checkoutCount){
            reporter.reportLogPass("The product list count in shoppingCartItem is ths same as the one in checkoutItem");
        }
        else{
            reporter.reportLogFail("The product list count in shoppingCartItem is not ths same as the one in checkoutItem");
        }

        if(Math.abs(shoppingSubTotal-checkoutSubTotal)<0.1f){
            reporter.reportLogPass("The SubTotal in shoppingCartItem is ths same as the one in checkoutItem");
        }
        else{
            reporter.reportLogFail("The SubTotal in shoppingCartItem is not ths same as the one in checkoutItem");
        }

        reporter.reportLog("verify OrderSummary Linkage Between ShoppingCartPage And CheckoutPage");
        getRegularCheckoutThreadLocal().verifyOrderSummaryLinkageBetweenShoppingCartPageAndCheckoutPage(orderSummaryInShoppingCartMap,orderSummaryInCheckoutMap);

        reporter.reportLog("verify EasyPayment Linkage Between ShoppingCartPage And CheckoutPage");
        getRegularCheckoutThreadLocal().verifyEasyPaymentLinkageBetweenShoppingCartPageAndCheckoutPage(easyPaymentInShoppingCartMap,easyPaymentInCheckoutMap);

        List<Map<String, Object>> productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
        summaryMapForCheckOutList = getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
        int itemCountForCheckOutList = (int) summaryMapForCheckOutList.get("itemCount");
        float subTotalForCheckOutList = (float) summaryMapForCheckOutList.get("subTotal");

        Map<String,Object> shippingAndPaymentMapOnCheckoutPage=getRegularCheckoutThreadLocal().getShippingAndPaymentDesc(productListMapForCheckOutPage.get(0));

        Map<String,Object> orderSummaryMapOnCheckoutPage=getRegularCheckoutThreadLocal().getOrderSummaryDesc();
        Map<String,Object> easyPaymentMapOnCheckoutPage=getRegularCheckoutThreadLocal().getEasyPayDesc();

        getRegularCheckoutThreadLocal().goToOrderConfirmationPage();
        String lsPromoteCodeOnOrderConfirmationPage=getOrderConfirmationThreadLocal().getPromoteCode();
        if(lsPromoteCodeOnCheckoutPage.equalsIgnoreCase(lsPromoteCodeOnOrderConfirmationPage)){
            reporter.reportLogPass("The promote code on OrderConfirmation page is the same as the one on Checkout page");
        }
        else{
            reporter.reportLogFail("The promote code on OrderConfirmation page is not the same as the one on Checkout page");
        }

        Map<String,Object> orderReceiptForOrderConfirmationPage=getOrderConfirmationThreadLocal().getReceiptDesc();

        List<Map<String,Object>> orderListMapForOrderConfirmationPage=getOrderConfirmationThreadLocal().getOrderListDesc();
        Map<String,Object> itemCountAndSubTotalMap=getOrderConfirmationThreadLocal().getCheckoutItemCountAndSubTotal(orderListMapForOrderConfirmationPage);
        int itemCountForOrderConfirmationList= (int) itemCountAndSubTotalMap.get("itemCount");
        float subTotalForOrderConfirmationList= (float) itemCountAndSubTotalMap.get("subTotal");

        reporter.reportLog("Verify product list linkage between OrderConfirmationPage and CheckoutPage");
        if(itemCountForOrderConfirmationList==itemCountForCheckOutList){
            reporter.reportLogPass("The order item count in OrderConfirmation Page is the same as the one in CheckOut page");
        }
        else{
            reporter.reportLogFail("The order item count:"+itemCountForOrderConfirmationList+" in OrderConfirmation Page is the same as the one:"+itemCountForCheckOutList+" in CheckOut page");
        }

        if(Math.abs(subTotalForOrderConfirmationList-subTotalForCheckOutList)<0.1f){
            reporter.reportLogPass("The order subTotal in OrderConfirmation Page is the same as the one in CheckOut page");
        }
        else{
            reporter.reportLogFail("The order subTotal:"+subTotalForOrderConfirmationList+" in OrderConfirmation Page is the same as the one:"+subTotalForCheckOutList+" in CheckOut page");
        }

        for(Map<String,Object> orderItem:orderListMapForOrderConfirmationPage){
            String lsText=(String)orderItem.get("productName");
            reporter.reportLog("Verify product:'"+lsText+"'");
            findIndex=getShoppingCartThreadLocal().findGivenProductIndexInProductList(orderItem,productListMapForCheckOutPage);
            if(findIndex!=-1){
                checkoutItem=productListMapForCheckOutPage.get(findIndex);
                getOrderConfirmationThreadLocal().verifyProductListLinkageBetweenOrderConfirmationPageAndCheckoutPage(orderItem,checkoutItem);
            }
            else{
                reporter.reportLogFail("Unable to find '"+lsText+"' in Checkout Page");
            }
        }

        Map<String,Object> shippingAndPaymentMapForOrderConfirmationPage=getOrderConfirmationThreadLocal().getShippingAndPaymentDesc(orderListMapForOrderConfirmationPage.get(0));

        reporter.reportLog("Verify OrderSummary Business Logic");
        Map<String,Object> orderSummaryForOrderConfirmationPage=getOrderConfirmationThreadLocal().getOrderSummaryDesc();
        getOrderConfirmationThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForOrderConfirmationList,orderSummaryForOrderConfirmationPage,null);

        reporter.reportLog("verify OrderSummary Linkage Between OrderConfirmationPage And CheckoutPage");
        getOrderConfirmationThreadLocal().verifyOrderSummaryLinkageBetweenOrderConfirmationPageAndCheckoutPage(orderSummaryForOrderConfirmationPage,orderSummaryMapOnCheckoutPage);
    }
}
