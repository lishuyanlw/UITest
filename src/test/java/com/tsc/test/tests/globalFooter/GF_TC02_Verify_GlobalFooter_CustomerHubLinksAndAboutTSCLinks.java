package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;


public class GF_TC02_Verify_GlobalFooter_CustomerHubLinksAndAboutTSCLinks extends BaseTest {
	/*
	 * CER-169
	 * CER-170
	 */
	@Test(groups={"Home","Regression","GlobalFooter"})
	public void Verify_GlobalFooter_CustomerHubLinksAndAboutTSCLinks_Language() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Global Footer Section");
		
		validateContents();

	}
	
	public void validateContents() {
		reporter.reportLog("Global Footer Section contents for CustomerHubLinks_AboutTSCLinks");
		
		BasePage basePage=new BasePage(this.getDriver());		
		
		List<List<String>> lstNameAndLinks=TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
		
		//Credit card
		String lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkCreditCard);		
		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find credit card link.");
		}
		String lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkCreditCard);
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current credit card href of "+lsHref+" is equal to "+lsYmlHref,"The current credit card href of "+lsHref+" is not equal to "+lsYmlHref);
		String lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgCreditCard);
		reporter.softAssert(!lsImageSrc.isEmpty(),"The credit card image is not empty.","The credit card image is empty.");
		
		//Gift card
		lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkGiftCard);		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find Gift card link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkGiftCard);
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current Gift card href of "+lsHref+" is equal to "+lsYmlHref,"The current Gift card href of "+lsHref+" is not equal to "+lsYmlHref);
		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgGiftCard);
		reporter.softAssert(!lsImageSrc.isEmpty(),"The Gift card image is not empty.","The Gift card image is empty.");
		
		//Send us feedback
		lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkSendUsFeedback);		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find Send us feedback link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkSendUsFeedback);
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current Send us feedback href of "+lsHref+" contains "+lsYmlHref,"The current Send us feedback href of "+lsHref+" does not contain "+lsYmlHref);
		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgSendUsFeedback);
		reporter.softAssert(!lsImageSrc.isEmpty(),"The Send us feedback image is not empty.","The Send us feedback image is empty.");
		
		//Language switch
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkLanguage));		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find Language switch link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkLanguage);
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current Language switch href of "+lsHref+" contains "+lsYmlHref,"The current Language switch href of "+lsHref+" does not contain "+lsYmlHref);
				
		//TSC customer hub links
		if (System.getProperty("chromeMobileDevice")=="iPhone X"){
			for(WebElement item:getGlobalFooterPageThreadLocal().lnkTSCCustomerHubAllLinksMobile) {
				lsText=basePage.getElementText(item);
				lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
				if(lsYmlHref.isEmpty()) {
					reporter.reportLogFail("Unable to find "+lsText+" link.");
				}
				lsHref=basePage.getElementHref(item);
				reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);

			}
		}else {
			for(WebElement item:getGlobalFooterPageThreadLocal().lnkTSCCustomerHubAllLinks) {
				lsText=basePage.getElementText(item);
				lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
				if(lsYmlHref.isEmpty()) {
					reporter.reportLogFail("Unable to find "+lsText+" link.");
				}
				lsHref=basePage.getElementHref(item);
				reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);

			}
		}

		
		//About TSC links
		if (System.getProperty("chromeMobileDevice")=="iPhone X"){
			for(WebElement item:getGlobalFooterPageThreadLocal().lnkAboutTSCAllLinksMobile) {
				lsText=basePage.getElementText(item);
				lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
				if(lsYmlHref.isEmpty()) {
					reporter.reportLogFail("Unable to find "+lsText+" link.");
				}
				lsHref=basePage.getElementHref(item);
				reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
			}
		}else{
			for(WebElement item:getGlobalFooterPageThreadLocal().lnkAboutTSCAllLinks) {
				lsText=basePage.getElementText(item);
				lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
				if(lsYmlHref.isEmpty()) {
					reporter.reportLogFail("Unable to find "+lsText+" link.");
				}
				lsHref=basePage.getElementHref(item);
				reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
			}
			//Rogers LOGO
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().imgRogersLogo), "Rogers Logo is existing", "Rogers Logo is not existing");
		}


		//Copyright text
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine1));
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyEqualWithEncodingText(lstNameAndLinks, lsText),"The copyright text is correct","The copyright text is not correct");
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine2));
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyEqualWithEncodingText(lstNameAndLinks, lsText),"The copyright text is correct","The copyright text is not correct");
	}

}
