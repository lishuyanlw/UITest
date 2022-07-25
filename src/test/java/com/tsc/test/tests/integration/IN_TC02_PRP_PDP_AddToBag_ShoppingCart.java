package com.tsc.test.tests.integration;

import com.tsc.api.pojo.Product;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IN_TC02_PRP_PDP_AddToBag_ShoppingCart extends BaseTest {
    /*
     *CER-845
     */
    @Test(groups={"Integration","Regression"})
    public void IN_TC02_PRP_PDP_AddToBag_ShoppingCart() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //To empty the cart
        //Fetching test data from test data file
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

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
        Map<String,String> pdpMap=getProductDetailPageThreadLocal().getFullInformationOnPDP(true,true,true,true,true);
        getProductDetailPageThreadLocal().verifyLinkageInfoBetweenPRPAndPDP(prpMap,pdpMap);

        reporter.reportLog("Compare the linkage information between PDP and AddToBag with product name: "+lsProductName);
        getProductDetailPageThreadLocal().chooseGivenStyleAndSize(getProductDetailPageThreadLocal().selectedProduct.productEDPColor,getProductDetailPageThreadLocal().selectedProduct.productEDPSize);
        Map<String,Object> PDPMap=getProductDetailPageThreadLocal().getPDPDesc();

        getProductDetailPageThreadLocal().openAddToBagPopupWindow();
        Map<String,Object> AddToBagMap=getProductDetailPageThreadLocal().getAddToBagDesc();

        getProductDetailPageThreadLocal().verifyContentsBetweenPDPAndAddToBag(PDPMap,AddToBagMap);

        getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();

        Map<String,Object> shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("all");

        //To verify Contents among PDP, AddToBag And ShoppingCartSection Details
        reporter.reportLog("Compare the linkage information between AddToBag and ShoppingCart with product name: "+lsProductName);
        getShoppingCartThreadLocal().verifyContentsOnShoppingCartSectionDetailsWithAddToBag(PDPMap,AddToBagMap,shoppingCartMap,false);

    }
}
