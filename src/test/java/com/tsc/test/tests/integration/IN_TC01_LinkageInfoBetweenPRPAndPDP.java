package com.tsc.test.tests.integration;

import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.pojo.Product;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class IN_TC01_LinkageInfoBetweenPRPAndPDP extends BaseTest {
    /*
     *CER-810
     */
    @Test(groups={"Integration","Regression"})
    public void IN_TC01_LinkageInfoBetweenPRPAndPDP() throws IOException, org.json.simple.parser.ParseException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        List<List<String>> lsKeywordDropdownList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
        Product.Products product=apiResponseThreadLocal.get().getActiveProductWithFullInfoFromKeyword(lsKeywordDropdownList.get(0).get(0));
        String lsProductName=product.getName();
        reporter.reportLog("Product name: "+lsProductName);

        reporter.reportLog("Compare the linkage information between PRP and PDP without style and size by clicking product image action");
        Map<String,String> prpMap=getProductResultsPageThreadLocal().navigateFromPRPToPDP(lsProductName, false);
        Map<String,String> pdpMap=getProductDetailPageThreadLocal().getFullInformationOnPDP(true,true,true,false,false);
        getProductDetailPageThreadLocal().verifyLinkageInfoBetweenPRPAndPDP(prpMap,pdpMap);

//        reporter.reportLog("Compare the linkage information between PRP and PDP with full coverage");
//        prpMap=getProductResultsPageThreadLocal().navigateFromPRPToPDP(lsProductName, true);
//        pdpMap=getProductDetailPageThreadLocal().getFullInformationOnPDP(true,true,true,true,true);
//        getProductDetailPageThreadLocal().verifyLinkageInfoBetweenPRPAndPDP(prpMap,pdpMap);

    }
}
