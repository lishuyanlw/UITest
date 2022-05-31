package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.GlobalHeaderPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MA_TC06_OrderReturns extends BaseTest {
    /*
     *CER-792
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC06_OrderReturns() {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        getMyAccountPageThreadLocal().openSubItemWindow("Your Orders","Order Returns", getMyAccountPageThreadLocal().lblOrderServiceTitle);

        String lnk_orderReturnsURL=TestDataHandler.constantData.getMyAccount().getLnk_orderReturnsURL();
        String expectedURL=basePage.getBaseURL()+lnk_orderReturnsURL;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated URL is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogPass("The actual navigated URL:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
        }

        reporter.reportLog("Verify Order Returns Title");
        basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().lblOrderServiceTitle);
        String lsTitle=getMyAccountPageThreadLocal().lblOrderServiceTitle.getText().trim();
        String lsExpectedTitle=TestDataHandler.constantData.getMyAccount().getLbl_orderReturnsTitle().trim();
        if(lsTitle.equalsIgnoreCase(lsExpectedTitle)){
            reporter.reportLogPass("The Order Returns title is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The Order Returns title:"+lsTitle+" is not displaying correctly as the expected:"+lsExpectedTitle);
        }

        reporter.reportLog("Verify Order Returns List section");
        getMyAccountPageThreadLocal().verifyOrderModificationAndOrderReturnsContents();

    }
}
