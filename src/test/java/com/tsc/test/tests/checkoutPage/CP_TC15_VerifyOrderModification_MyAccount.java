package com.tsc.test.tests.checkoutPage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.pojo.CartResponse;
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

public class CP_TC15_VerifyOrderModification_MyAccount extends BaseTest {
    @Test(groups={"Regression","Checkout","CheckoutMobTab"})
    public void CP_TC15_VerifyOrderModification_MyAccount() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //Fetching test data from test data file
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();
        String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        String orderDetailsPartialURL = TestDataHandler.constantData.getMyAccount().getLblOrderDetailsPageUrl();
        List<Map<String, String>> keyword = Arrays.asList(TestDataHandler.constantData.getCheckOut().getLstOrderDetailItems().get(1));

        try{
            //Emptying Cart for test to run with right state
            getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);

            //Setting up initial test environment by deleting all cards associated with user and cart
            CartAPI cartAPI = new CartAPI();
            Response response = cartAPI.getAccountCartContentWithCustomerEDP(customerEDP,accessToken);
            CartResponse cartResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
            getRegularCheckoutThreadLocal().deleteCreditCardForUserAndFromCart(cartResponse,customerEDP,accessToken);

            //Adding TSC Credit Card to user for test
            getShoppingCartThreadLocal().addTSCCreditCardForUser(null,customerEDP,accessToken);

            //Verifying that item exists in cart and if not, create a new cart for user
            getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,false);
            //Fetching cart response again for user name
            cartResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});

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
            getRegularCheckoutThreadLocal().navigateToCheckoutPage();
            int presetInstallmentNumber=getRegularCheckoutThreadLocal().setPaymentOptionByRandomIndex();

            //Place Order and navigate to Order Confirmation Page
            getRegularCheckoutThreadLocal().goToOrderConfirmationPage();

            //Fetching details for Order Confirmation Page to be verified on Order Details Page
            List<Map<String,Object>> orderItemList = getOrderConfirmationThreadLocal().getOrderListDesc();
            Map<String,Object> shippingAndPaymentDescription = getOrderConfirmationThreadLocal().getShippingAndPaymentDesc(orderItemList.get(0));
            Map<String,Object> orderSummaryDescription = getOrderConfirmationThreadLocal().getOrderSummaryDesc();

            //Navigate to Order Details Page under My Account from Order Confirmation Page
            //On click View Details link should take user to /pages/myaccount/orderstatus?orderNo=<Order #>
            reporter.reportLog("Verification of Order Details page URL");
            Boolean orderDetailPageURL = getOrderConfirmationThreadLocal().goToOrderDetailsPage(orderDetailsPartialURL,shippingAndPaymentDescription.get("orderNumber").toString());
            if(orderDetailPageURL)
                reporter.reportLogPass("User is navigated to Order Details Page and page URL is as expected");
            else
                reporter.reportLogFailWithScreenshot("User is not navigated to Order Details Page and page URL is not as expected");

            //Verify Track Order and Edit Order Buttons
            getMyAccountPageThreadLocal().verifyOrderDetailsTrackOrderAndEditButton();

            //Verify the title display user name and customer number and Sign Out, Track Order Button
            reporter.reportLog("Verify the title display user name and customer number and Sign Out, Track Order Button");
            getMyAccountPageThreadLocal().verifyMyAccountOrderDetailPageTitle(cartResponse.getBuyer().getBillingAddress().getFirstName(),shippingAndPaymentDescription.get("customerNumber").toString());

            //Fetching data from Order Details page for verification
            Map<String,Object> orderDetailsSummary = getMyAccountPageThreadLocal().getOrderDetailsDescExceptOrderList();
            List<Map<String,Object>> orderDetailsItems = getMyAccountPageThreadLocal().getOrderListDesc();
            getMyAccountPageThreadLocal().sortOrderDetailListMap(orderItemList);
            getMyAccountPageThreadLocal().sortOrderDetailListMap(orderDetailsItems);

            getMyAccountPageThreadLocal().goToOrderModificationPage();

            getOrderModificationThreadLocal().verifyModifyOrderHeaderContents();
            getOrderModificationThreadLocal().verifyModifyOrderCancelModificationButton();
            getOrderModificationThreadLocal().verifyModifyOrderChangeModeContents();
            getOrderModificationThreadLocal().verifyExistingOrderHeaderContents();
            getOrderModificationThreadLocal().verifyOrderList(false);
            getOrderModificationThreadLocal().verifyOrderSummaryContents();
            getOrderModificationThreadLocal().verifyEasyPayContents();
            getOrderModificationThreadLocal().verifyCheckoutContents();

            List<Map<String,Object>> existingOrderMapList=getOrderModificationThreadLocal().getExistingOrderListDesc();
            Map<String,Object> calculatedCheckoutItemCountAndSubTotalMap=getOrderModificationThreadLocal().getCalculatedCheckoutItemCountAndSubTotal(existingOrderMapList);
            int itemCountForExistingOrderList= (int) calculatedCheckoutItemCountAndSubTotalMap.get("itemCount");
            float subTotalForExistingOrderList= (float) calculatedCheckoutItemCountAndSubTotalMap.get("subTotal");
            Map<String,Object> orderSummaryMap=getOrderModificationThreadLocal().getOrderSummaryDesc();
            getOrderModificationThreadLocal().verifyOrderSummaryBusinessLogic(itemCountForExistingOrderList,subTotalForExistingOrderList,orderSummaryMap,null);
            Map<String,Object> easyPaymentMap=getOrderModificationThreadLocal().getEasyPayDesc();
            getOrderModificationThreadLocal().verifyInstallmentBusinessLogic(presetInstallmentNumber,orderSummaryMap);

            String lsPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode().get(0);
            getOrderModificationThreadLocal().addPromoteCode(lsPromoteCode);

            List<String> lstKeyword = TestDataHandler.constantData.getCheckOut().getLst_SearchingKeywordForPlaceOrder();
            Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
            outputDataCriteria.put("style", "1");
            outputDataCriteria.put("size", "1");
            String lsProductName=getProductDetailPageThreadLocal().getProductWithConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria(lstKeyword,outputDataCriteria);
            getOrderModificationThreadLocal().addProductItems(lsProductName,true);
        }finally {
            //Emptying Cart for test to run with right state if test fails before placing order
            getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);
        }

    }
}
