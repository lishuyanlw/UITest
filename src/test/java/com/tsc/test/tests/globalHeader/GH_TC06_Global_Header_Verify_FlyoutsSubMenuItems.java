package com.tsc.test.tests.globalHeader;

import org.testng.annotations.Test;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC06_Global_Header_Verify_FlyoutsSubMenuItems extends BaseTest {

	@Test(groups={"Home","Regression","GlobalHeader","GlobalHeader_Mobile","GlobalHeader_Tablet"})
	public void verifyFlyoutHeadings() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		getglobalheaderPageThreadLocal().verifyFlyoutMenuItems(null,null);
	}
}	
