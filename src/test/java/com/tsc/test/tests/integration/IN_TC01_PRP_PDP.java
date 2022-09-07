package com.tsc.test.tests.integration;

import com.tsc.api.pojo.Product;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

public class IN_TC01_PRP_PDP extends BaseTest {
    /*
     *CER-810
     */
    @Test(groups={"Integration","Regression"})
    public void IN_TC01_PRP_PDP() {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        List<List<String>> lsKeywordDropdownList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
        Product.Products product=getProductAPIThreadLocal().getActiveProductWithFullInfoFromKeyword(lsKeywordDropdownList.get(0).get(0));
        String lsProductName=product.getName();
        reporter.reportLog("Product name: "+lsProductName);

        reporter.reportLog("Compare the linkage information between PRP and PDP with full coverage");
        Map<String,String> prpMap=getProductResultsPageThreadLocal().navigateFromPRPToPDP(lsProductName, true);
        Map<String,String> pdpMap=getProductDetailPageThreadLocal().getFullInformationOnPDP(prpMap.get("productBrand")!=null,prpMap.get("productReviewCount")!=null,prpMap.get("productWasPrice")!=null,prpMap.get("productStyle")!=null,prpMap.get("productSize")!=null);
        getProductDetailPageThreadLocal().verifyLinkageInfoBetweenPRPAndPDP(prpMap,pdpMap);

        reporter.reportLog("Compare the linkage information between PRP and PDP without style and size by clicking product image action");
        prpMap=getProductResultsPageThreadLocal().navigateFromPRPToPDP(lsProductName, false);
        pdpMap=getProductDetailPageThreadLocal().getFullInformationOnPDP(prpMap.get("productBrand")!=null,prpMap.get("productReviewCount")!=null,prpMap.get("productWasPrice")!=null,prpMap.get("productStyle")!=null,prpMap.get("productSize")!=null);
        getProductDetailPageThreadLocal().verifyLinkageInfoBetweenPRPAndPDP(prpMap,pdpMap);

    }
}
