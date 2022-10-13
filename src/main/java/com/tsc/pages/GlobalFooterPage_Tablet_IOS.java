package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import java.util.List;

public class GlobalFooterPage_Tablet_IOS extends GlobalFooterPage{
	public GlobalFooterPage_Tablet_IOS(WebDriver driver) {
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

	@Override
	public boolean compareUrlInNewWindow(String lsService, String lsExpectedUrl,String section) {
		/*
		WebElement selectedItem = this.getServiceWebElement(lsService,section);
		if (selectedItem == null) {
			return false;
		}

		String lsCurrentUrl;
		final String lsUrl=this.URL();
		String lsMainWindowHandle = this.getDriver().getWindowHandle();
		getReusableActionsInstance().javascriptScrollByVisibleElement(selectedItem);
		getReusableActionsInstance().clickIfAvailable(selectedItem);
		this.waitForCondition(Driver->{return this.URL().contains("blog");},20000);
//		getReusableActionsInstance().waitForNumberOfWindowsToBe(2, 90);
//		Set<String> lstWindowHandle = this.getDriver().getWindowHandles();
//		System.out.println("Window size: "+lstWindowHandle.size());
//		for (String windowHandle : lstWindowHandle) {
//			System.out.println(this.getDriver().getTitle());
//			this.getDriver().switchTo().window(windowHandle);
//			System.out.println(this.getDriver().getTitle());
//			if(this.getDriver().getTitle().toLowerCase().contains("blog")){
//				System.out.println(this.getDriver().getTitle());
//				break;
//			}
//		}
		lsCurrentUrl = this.removeLastSlashFromUrl(this.getDriver().getCurrentUrl());
		lsExpectedUrl = this.removeLastSlashFromUrl(lsExpectedUrl);

		String strQaUrl=System.getProperty("QaUrl");
		this.getDriver().get(strQaUrl);
		this.waitForPageToLoad();

		return lsCurrentUrl.equalsIgnoreCase(lsExpectedUrl);
		 */
		return false;
	}

}
