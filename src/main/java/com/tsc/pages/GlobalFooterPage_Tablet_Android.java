package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import java.util.List;

public class GlobalFooterPage_Tablet_Android extends GlobalFooterPage_Mobile{
	public GlobalFooterPage_Tablet_Android(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyFaceBookLink(List<String> lstSocialMediaLinks) {
		String lsCurrentUrl = waitForPageLoadingByUrlChange(this.lnkFacebook);
		if(lsCurrentUrl.toLowerCase().contains("facebook")){
			reporter.reportLogPass("The Url after clicking Facebook link contains facebook");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Url after clicking Facebook link does not contain facebook");
		}

		String lsBaseUrl=this.getBaseURL()+"/";
		this.navigateToURL(lsBaseUrl);
		this.waitForPageLoading();
	}

}
