package com.tsc.test.tests.signIn;

import com.tsc.api.apiBuilder.ProductAPI;
import com.tsc.api.pojo.Product;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class SI_TC04_VerifyShowPasswordButton extends BaseTest{
	/*
	 * CER-783
	 */
	@Test(groups={"SignIn","Regression","Regression_Mobile","Regression_Tablet"})
	public void SI_TC04_VerifyShowPasswordButton() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		getGlobalLoginPageThreadLocal().goToSignInPage();

		getGlobalLoginPageThreadLocal().verifyShowOrHidePasswordFunction();
	}
}

