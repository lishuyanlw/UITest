package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.ConfigurationAPI;
import com.tsc.api.pojo.Configuration;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SC_TC09_VerifyShoppingCart_Free_Gift_Item extends BaseTest {
    /*
     * CER-852 - Shopping Cart - Add item (having associate gift item) and check sub-total and order summary
     */
    @Test(groups={"Regression","ShoppingCart","SauceTunnelTest"})
    public void SC_TC09_VerifyShoppingCart_Free_Gift_Item() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        List<Configuration> configurations = new ConfigurationAPI().getContentFulConfigurationForFreeItem();

    }
}
