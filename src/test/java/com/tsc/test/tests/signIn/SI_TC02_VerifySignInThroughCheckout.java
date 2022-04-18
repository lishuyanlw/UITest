package com.tsc.test.tests.signIn;

import com.tsc.api.apiBuilder.ProductAPI;
import com.tsc.api.pojo.Product;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
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
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		ProductAPI productAPI=new ProductAPI();
		Map<String,Object> mapEDP=productAPI.getNotSoldOutProductInfo("boots",2,false);
		String pdpNavigationUrl=mapEDP.get("pdpNavigationUrl").toString();
		this.getDriver().get(pdpNavigationUrl);
		basePage.waitForCondition(Driver->{return getProductDetailPageThreadLocal().lblProductName.isDisplayed();},10000);

		Product.edps edp=(Product.edps)mapEDP.get("EDP");
		getProductDetailPageThreadLocal().setProductStyleAndSize(edp.getStyle(),edp.getSize());

		basePage.getReusableActionsInstance().staticWait(5000);
	}
}

