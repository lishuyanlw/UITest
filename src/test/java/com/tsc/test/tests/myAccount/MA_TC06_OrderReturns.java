package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class MA_TC06_OrderReturns extends BaseTest {
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC06_OrderReturns() throws ParseException, IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify Order status URL");
        BasePage basePage=new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getMyAccount().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getMyAccount().getLbl_Password();
        String lblFirstName = TestDataHandler.constantData.getMyAccount().getLbl_FirstName();
        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword, lblFirstName);

        getMyAccountPageThreadLocal().openSubItemWindow("Order Returns", getMyAccountPageThreadLocal().lblOrderServiceTitle);

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
            reporter.reportLogFailWithScreenshot("The Order Returns title:"+lsTitle+" is displaying correctly as the expected:"+lsExpectedTitle);
        }

        reporter.reportLog("Verify Order Returns List section");
        getMyAccountPageThreadLocal().verifyOrderModificationAndOrderReturnsContents();

    }
}
