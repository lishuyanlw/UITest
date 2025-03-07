package com.tsc.test.tests.signIn;

import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class SI_TC03_VerifyInvalidUserNameOrPassword extends BaseTest{
	/*
	 * CER-782
	 */
	@Test(groups={"SignIn","Regression","Regression_Mobile","Regression_Tablet"})
	public void SI_TC03_VerifyInvalidUserNameOrPassword() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");

		getGlobalLoginPageThreadLocal().goToSignInPage();

		String lsErrorMessageForUserName=TestDataHandler.constantData.getLoginUser().getLbl_ErrorMessageForUserName();
		String lsErrorMessageForPassword=TestDataHandler.constantData.getLoginUser().getLbl_ErrorMessageForPassword();
		String lsErrorMessageForUserNameAndPassword=TestDataHandler.constantData.getLoginUser().getLbl_ErrorMessageForUserNameAndPassword();

		reporter.reportLog("Test without inputting UserName and Password");
		getGlobalLoginPageThreadLocal().verifyErrorMessageForUserNameAndPassword("","",lsErrorMessageForUserName,lsErrorMessageForPassword,lsErrorMessageForUserNameAndPassword,false);

		reporter.reportLog("Test with invalid UserName and without Password");
		getGlobalLoginPageThreadLocal().verifyErrorMessageForUserNameAndPassword("1","",lsErrorMessageForUserName,lsErrorMessageForPassword,lsErrorMessageForUserNameAndPassword,false);

		reporter.reportLog("Test with valid UserName and invalid Password");
		String lsEmail=DataConverter.getSaltString(6,"mixType")+"@"+DataConverter.getSaltString(6,"stringType")+".com";
		getGlobalLoginPageThreadLocal().verifyErrorMessageForUserNameAndPassword(lsEmail,"",lsErrorMessageForUserName,lsErrorMessageForPassword,lsErrorMessageForUserNameAndPassword,true);

	}
}

