package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

public class MA_TC05_OrderCancellation extends BaseTest {
    /*
     *CER-791
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC05_OrderCancellation() {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);
        getMyAccountPageThreadLocal().openSubItemWindow("Your Orders","Order Cancellation", getMyAccountPageThreadLocal().lblOrderServiceTitle);

        String lnk_orderCancellationURL=TestDataHandler.constantData.getMyAccount().getLnk_orderCancellationURL();
        String expectedURL=basePage.getBaseURL()+lnk_orderCancellationURL;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated URL is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogPass("The actual navigated URL:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
        }

        reporter.reportLog("Verify Order Modification Title");
        basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().lblOrderServiceTitle);
        String lsTitle=getMyAccountPageThreadLocal().lblOrderServiceTitle.getText().trim();
        String lsExpectedTitle=TestDataHandler.constantData.getMyAccount().getLbl_orderModificationTitle().trim();
        if(lsTitle.equalsIgnoreCase(lsExpectedTitle)){
            reporter.reportLogPass("The Order Modification title is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The Order Modification title:"+lsTitle+" is not displaying correctly as the expected:"+lsExpectedTitle);
        }

        reporter.reportLog("Verify Order Modification List section");
        getMyAccountPageThreadLocal().verifyOrderModificationAndOrderReturnsContents();
    }
}
