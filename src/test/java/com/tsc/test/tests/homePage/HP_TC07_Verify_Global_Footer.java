package com.tsc.test.tests.homePage;

import org.testng.annotations.Test;
import java.io.IOException;

import com.tsc.test.base.BaseTest;

public class HP_TC07_Verify_Global_Footer extends BaseTest {
	
	@Test(groups={"Home","Regression","GlobalFooter"})
	public void verify_Global_Footer_Section_Visibility() throws IOException {
		
		reporter.reportLogWithScreenshot("Global Footer Section");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifySignupBlockAndContentVisibility(), "Global footer Sign Up block and its content is visible","Issue in visibility of Global footer Sign Up block or its content");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyJoinConversationBlockAndContentVisibility(), "Global footer Join Conversation block and its content is visible","Issue in visibility of Global footer Join Conversation block or its content");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifySendFeedbackBlockAndContentVisibility(), "Global footer Send Feedback block and its content is visible","Issue in visibility of Global footer Send Feedback block or its content");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLanguageBlockAndContentVisibility(), "Global footer Language block and its content is visible","Issue in visibility of Global footer Language block or its content");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyCustomerHubBlockAndContentVisibility(), "Global footer Customer Hub block and its content is visible","Issue in visibility of Global footer Customer Hub block or its content");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyAboutTSCBlockAndContentVisibility(), "Global footer About TSC block and its content is visible","Issue in visibility of Global footer About TSC block or its content");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyGiftCardBlockAndContentVisibility(), "Global footer Gift Card block and its content is visible","Issue in visibility of Global footer Gift Card block or its content");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyCreditCardBlockAndContentVisibility(), "Global footer Credit Card block and its content is visible","Issue in visibility of Global footer Credit Card block or its content");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyRogersLogoBlockAndContentVisibility(), "Global footer Rogers Logo block and its content is visible","Issue in visibility of Global footer Rogers Logo block or its content");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyRogersCopyrightBlockAndContentVisibility(), "Global footer Rogers Logo block and its content is visible","Issue in visibility of Global footer Rogers Logo block or its content");
	}

}
