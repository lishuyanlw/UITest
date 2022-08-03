package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.ConfigurationAPI;
import com.tsc.api.pojo.Configuration;
import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SC_TC09_VerifyShoppingCart_Free_Gift_Item extends BaseTest {
    /*
     * CER-852 - Shopping Cart - Add item (having associate gift item) and check sub-total and order summary
     */
    @Test(groups={"Regression","ShoppingCart","SauceTunnelTest"})
    public void SC_TC09_VerifyShoppingCart_Free_Gift_Item() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //Fetching test data from test data file
        String lsUserName= TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        JSONObject creditCardData = new DataConverter().readJsonFileIntoJSONObject("test-data/CreditCard.json");

        List<Configuration> configurations = new ConfigurationAPI().getContentFulConfigurationForFreeItem();

        //Deleting all items from cart to be added again with free shipping item
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();
        getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);

        //Verifying configurations and adding necessary credit Card for user
        getShoppingCartThreadLocal().verifyAndUpdateCreditCardAsPerSystemConfiguration(configurations,creditCardData,customerEDP,accessToken);

        //Adding item to cart for user
        List<Map<String,String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
        getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP),accessToken,keyword,true);
    }
}
