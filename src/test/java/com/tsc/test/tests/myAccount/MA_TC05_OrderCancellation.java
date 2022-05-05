package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.GlobalHeaderPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
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
        String lblUserName = TestDataHandler.constantData.getMyAccount().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getMyAccount().getLbl_Password();
        String lblFirstName = TestDataHandler.constantData.getMyAccount().getLbl_FirstName();
        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        String lsTestDevice = System.getProperty("Device").trim();
        if(lsTestDevice.equalsIgnoreCase("Desktop")) {
            WebElement item=(new GlobalHeaderPage(this.getDriver())).Signinlnk;
            basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            if(item.getText().trim().toUpperCase().contains(lblFirstName.trim().toUpperCase())) {
                reporter.reportLogPass("The SignIn in the header contains SignIn first name");
            }
            else{
                reporter.reportLogFailWithScreenshot("The SignIn in the header does not contain SignIn first name");
            }
        }

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
