package com.tsc.test.tests.checkoutPage;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CP_TC06_VerifyReguLarCheckout_LowInventory extends BaseTest{
    /*
     * CER-874
     */
    @Test(groups={"Regression","Checkout","CheckoutMobTab"})
    public void CP_TC06_VerifyReguLarCheckout_LowInventory() throws IOException {
        String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        //Fetching test data from test data file
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
        getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

        getGlobalFooterPageThreadLocal().closePopupDialog();
        List<Map<String, String>> keywordList = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
        List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keywordList, "all",true,0);

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
        BasePage basePage = new BasePage(this.getDriver());
        try {
            getShoppingCartThreadLocal().waitForCondition(Driver -> {
                return Integer.valueOf(getglobalheaderPageThreadLocal().CartBagCounter.getText()) > 0;
            }, 6000);
        } catch (Exception e) {
            (new BasePage(this.getDriver())).applyStaticWait(3000);
        }

        List<String> lstKeywordList = TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
        Map<String, Object> outputDataCriteria = new HashMap<String, Object>();
        outputDataCriteria.put("style", "1");
        outputDataCriteria.put("size", "1");
        outputDataCriteria.put("quantity", "-10");
        if (getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList, "ConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria", outputDataCriteria)) {
            String lsProductName = getProductDetailPageThreadLocal().selectedProduct.productName;
            String lsStyle = getProductDetailPageThreadLocal().selectedProduct.productEDPColor;
            String lsSize = getProductDetailPageThreadLocal().selectedProduct.productEDPSize;
            Map<String,Object> mapProduct=new HashMap<>();
            mapProduct.put("productName",lsProductName);
            mapProduct.put("productStyle",lsStyle);
            mapProduct.put("productSize",lsSize);

            getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lsStyle, lsSize, 1);
            Map<String,Object> PDPMap=getProductDetailPageThreadLocal().getPDPDesc();
            int leftNumberInPDP=(int) PDPMap.get("productLeftNumber");

            basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
            basePage.waitForCondition(Driver -> {
                return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
            }, 30000);

            getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();
            if (getShoppingCartThreadLocal().checkIsDropdownMenuForInstallmentNumber()) {
                List<String> lstOptionText = getShoppingCartThreadLocal().getInstallmentOptions();
                getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(1));
            }
            int installmentsNumberForShoppingCart = getShoppingCartThreadLocal().getInstallmentNumber();
            getShoppingCartThreadLocal().goToCheckoutPage();

            reporter.reportLog("Verify unCollapsing checkout item list function");
            getRegularCheckoutThreadLocal().unCollapseProductList();
            String lsProductListClass=getRegularCheckoutThreadLocal().cntProductListContainer.getAttribute("class");
            if(lsProductListClass.equalsIgnoreCase("hidden")){
                reporter.reportLogPass("The product list is hidden after unCollapsing ProductList");
            }
            else{
                reporter.reportLogFail("The product list is still displaying after unCollapsing ProductList");
            }

            reporter.reportLog("Verify expanding checkout item list function");
            getRegularCheckoutThreadLocal().expandProductList();
            lsProductListClass=getRegularCheckoutThreadLocal().cntProductListContainer.getAttribute("class");
            if(lsProductListClass==null||lsProductListClass.isEmpty()){
                reporter.reportLogPass("The product list is expanded after expanding ProductList");
            }
            else{
                reporter.reportLogFail("The product list is still hidden after expanding ProductList");
            }

            List<Map<String, Object>> productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
            int findIndex=getShoppingCartThreadLocal().findGivenProductIndexInProductList(mapProduct,productListMapForCheckOutPage);
            if(findIndex!=-1){
                if(productListMapForCheckOutPage.get(findIndex).get("productLeftNumber")!=null){
                    reporter.reportLogPass("The left inventory info for product: '"+lsProductName+"' is displaying on checkout page");
                    int leftNumberInCheckOutPage=(int) productListMapForCheckOutPage.get(findIndex).get("productLeftNumber");
                    if(leftNumberInPDP==leftNumberInCheckOutPage){
                        reporter.reportLogPass("The low inventory number on CheckOut page is the same as the one on PDP");
                    }
                    else{
                        reporter.reportLogFail("The low inventory number: "+leftNumberInCheckOutPage+" on CheckOut page is the same as the one: "+leftNumberInPDP+" on PDP");
                    }
                }
                else{
                    reporter.reportLogFail("The left inventory info for product: '"+lsProductName+"' is not displaying on checkout page");
                }

                if(productListMapForCheckOutPage.get(0).get("productFreeShipping")!=null&&
                        (float)productListMapForCheckOutPage.get(0).get("productNowPrice")<0.1f){
                    if(findIndex==1){
                        reporter.reportLogPass("newly added item of the product: '"+lsProductName+"' with low inventory is shown on top of list of checkout items on CheckOut page.");
                    }
                    else{
                        reporter.reportLogFail("newly added item of the product: '"+lsProductName+"' with low inventory is not shown on top of list of checkout items on CheckOut page.");
                    }
                }
                else{
                    if(findIndex==0){
                        reporter.reportLogPass("newly added item of the product: '"+lsProductName+"' with low inventory is shown on top of list of checkout items on CheckOut page.");
                    }
                    else{
                        reporter.reportLogFail("newly added item of the product: '"+lsProductName+"' with low inventory is not shown on top of list of checkout items on CheckOut page.");
                    }
                }
            }
            else{
                reporter.reportLogFail("The product: '"+lsProductName+"' with low inventory cannot be found on CheckOut page!");
            }

            reporter.reportLog("Verify Mandatory Contents For Checkout ProductList");
            getRegularCheckoutThreadLocal().verifyMandatoryContentsForCheckoutProductList();

            reporter.reportLog("Verify optional Contents For Checkout ProductList");
            getRegularCheckoutThreadLocal().verifyOptionalContentsForCheckoutProductList();

            Map<String, Object> summaryMapForCheckOutList = getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
            int itemCountForCheckOutList = (int) summaryMapForCheckOutList.get("itemCount");
            float subTotalForCheckOutList = (float) summaryMapForCheckOutList.get("subTotal");

            int itemCountInHeader=getRegularCheckoutThreadLocal().getOrderItemCount();
            if(itemCountForCheckOutList==itemCountInHeader){
                reporter.reportLogPass("The item count: "+itemCountForCheckOutList+" in checkout item list is equal to the one: "+itemCountInHeader+" in the header");
            }
            else{
                reporter.reportLogFail("The item count: "+itemCountForCheckOutList+" in checkout item list is not equal to the one: "+itemCountInHeader+" in the header");
            }

            reporter.reportLog("Verify orderSummary business logic");
            Map<String, Object> orderSummaryMapForCheckOutPage = getRegularCheckoutThreadLocal().getOrderSummaryDesc();
            getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForCheckOutList, orderSummaryMapForCheckOutPage, null);

            reporter.reportLog("Verify installment business logic");
            Map<String, Object> easyPaymentMapForCheckOutPage = getRegularCheckoutThreadLocal().getEasyPayDesc();
            getRegularCheckoutThreadLocal().verifyInstallmentBusinessLogic(installmentsNumberForShoppingCart, orderSummaryMapForCheckOutPage);

            reporter.reportLog("Verify checkout header contents");
            getRegularCheckoutThreadLocal().verifyCheckoutHeaderContents();

            reporter.reportLog("Verify checkout product list contents");
            getRegularCheckoutThreadLocal().verifyMandatoryContentsForCheckoutProductList();
            getRegularCheckoutThreadLocal().verifyOptionalContentsForCheckoutProductList();

            reporter.reportLog("Verify order summary contents");
            getRegularCheckoutThreadLocal().verifyOrderSummaryContents();

            reporter.reportLog("Verify easyPayment contents");
            getRegularCheckoutThreadLocal().verifyEasyPayContents();

            reporter.reportLog("Verify Promote Code contents");
            getRegularCheckoutThreadLocal().verifyPromoteCodeContents();

            reporter.reportLog("Verify GiftCard And PlaceOrder contents");
            getRegularCheckoutThreadLocal().verifyGiftCardAndPlaceOrderContents();
        }
        else{
            reporter.reportLogFail("Unable to find the product with low inventory!");
        }
    }
}

