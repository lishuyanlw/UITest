package com.tsc.test.tests.signIn;

import com.tsc.api.apiBuilder.ProductAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.pojo.Product;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.GlobalHeaderPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SI_TC02_VerifySignInThroughCheckout extends BaseTest{
	/*
	 * CER-785
	 */
	@Test(groups={"SignIn","Regression","Regression_Mobile","Regression_Tablet"})
	public void SI_TC02_VerifySignInThroughCheckout() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		//Fetching test data from test data file
		String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		ProductAPI productAPI=new ProductAPI();
		Map<String,Object> mapEDP=productAPI.getNotSoldOutProductInfo("boots",2,false);
		String pdpNavigationUrl=mapEDP.get("pdpNavigationUrl").toString();
		reporter.reportLog(pdpNavigationUrl);
		this.getDriver().get(pdpNavigationUrl);
		basePage.waitForCondition(Driver->{return getProductDetailPageThreadLocal().lblProductName.isDisplayed();},30000);

		Product.edps edp=(Product.edps)mapEDP.get("EDP");
//		reporter.reportLog(edp.getStyle()+":"+edp.getSize());
//		getProductDetailPageThreadLocal().setProductStyleAndSize(edp.getStyle(),edp.getSize());

		getProductDetailPageThreadLocal().goToSignInByClickingCheckoutInAddToBagPopupWindow();

		String lsSignInTitle=TestDataHandler.constantData.getLoginUser().getLbl_SignInTitleFromCheckout();
		String lsSignInFromCheckout=TestDataHandler.constantData.getLoginUser().getLbl_SignInButtonFromCheckout();

		getGlobalLoginPageThreadLocal().verifySignInTitle(lsSignInTitle);
		getGlobalLoginPageThreadLocal().verifyUserNameAndPassword();
		getGlobalLoginPageThreadLocal().verifyKeepMeSignedInFunction(lsSignInFromCheckout);
		getGlobalLoginPageThreadLocal().verifyConfidence();
		getGlobalLoginPageThreadLocal().verifyOtherFieldsForLeftPart();

		String lsSectionTitle=TestDataHandler.constantData.getLoginUser().getLbl_RightSideTitleSignInPage();
		String lsAsAnGuest=TestDataHandler.constantData.getLoginUser().getLst_RightSideSectionSignInPage().get(1);
		getGlobalLoginPageThreadLocal().verifyNewCustomerSignInRightSideSection(lsSectionTitle,lsAsAnGuest);

		getGlobalLoginPageThreadLocal().signInFromCheckout(lblUserName,lblPassword);

		if(this.getDriver().getCurrentUrl().contains("expresscheckout")){
			reporter.reportLogPass("The page has been navigated to expresscheckout page");
		}
		else{
			reporter.reportLogFail("The page has not been navigated to expresscheckout page");
		}

		getGlobalLoginPageThreadLocal().verifyKeepMeSignedInFunction();

	}
}

