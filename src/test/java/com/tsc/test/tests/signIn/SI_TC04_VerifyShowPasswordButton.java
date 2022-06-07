package com.tsc.test.tests.signIn;

import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SI_TC04_VerifyShowPasswordButton extends BaseTest{
	/*
	 * CER-783
	 */
	@Test(groups={"SignIn","Regression","Regression_Mobile","Regression_Tablet"})
	public void SI_TC04_VerifyShowPasswordButton() {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		reporter.reportLog("Go to SignIn page");

		getGlobalLoginPageThreadLocal().goToSignInPage();

		getGlobalLoginPageThreadLocal().verifyShowOrHidePasswordFunction();
	}
}

