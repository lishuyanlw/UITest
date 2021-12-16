package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GlobalFooterPage_Tablet extends GlobalFooterPage{
	public GlobalFooterPage_Tablet(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[@class='Footer']//div[contains(@id,'accordionfooter')]//ul/li/a")
	List<WebElement> lnkTSCCustomerHubAllLinks;

	@Override
	public void verifyRogersLogo() {
		if(System.getProperty("browser").contains("android"))
			reporter.reportLog("Rogers Logo is not present for android tablet");
		else
			reporter.softAssert(this.verifyElementExisting(this.imgRogersLogo), "Rogers Logo is existing", "Rogers Logo is not existing");
	}

	@Override
	public void verifyFaceBookLink(List<String> lstSocialMediaLinks) {
		String lsCurrentUrl = waitForPageLoadingByUrlChange(this.lnkFacebook);
		reporter.softAssert(lsCurrentUrl.toLowerCase().contains("facebook"),"The Url after clicking Facebook link contains facebook","The Url after clicking Facebook link does not contain facebook");

		String lsBaseUrl=this.getBaseURL()+"/";
		this.navigateToURL(lsBaseUrl);
		this.waitForPageLoading();
	}

	@Override
	public void verifyTSCCustomerHubLlinks(List<List<String>> lstNameAndLinks) {
		//BasePage basePage=new BasePage(this.getDriver());
		String lsText,lsYmlHref,lsHref;
		for(WebElement item:this.lnkTSCCustomerHubAllLinks) {
			lsText=super.getElementText(item);
			lsYmlHref=this.getLinkWithSpecificName(lstNameAndLinks,lsText,true);
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFail("Unable to find "+lsText+" link.");
			}
			lsHref=super.getElementHref(item);
			reporter.softAssert(this.verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);

		}
	}
}
