package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;


public class GF_TC03_Verify_GlobalFooter_Language extends BaseTest {
	/*
	 * CER-168
	 */
	@Test(groups={"Home","Regression","GlobalFooter"})
	public void Verify_GlobalFooter_CustomerHubLinksAndAboutTSCLinks_Language() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");		
		reporter.reportLog("Global Footer Section");		

		List<List<String>> lstNameAndLinks= TestDataHandler.constantDataFile.getFooterSection().getLst_NameAndLinks();
		
		//Credit card
		String lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkCreditCard);
		String lsText_CreditCard_Fr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);

		//Gift card
		lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkGiftCard);
		String lsText_GiftCard_Fr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);

		//Send us feedback
		lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkSendUsFeedback);
		String lsText_SendUsFeedback_Fr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);

		//Language switch
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkLanguage));
		String lsText_LanguageSwitch_En=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
		
		//TSC customer hub links
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lblTSCCustomerHubText));
		String lsText_TSCCustomerHub_Fr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
		
		List<String> lstCustomerHubFr=new ArrayList<String>();
		String lsFr;
		for(WebElement item:getGlobalFooterPageThreadLocal().lnkTSCCustomerHubAllLinks) {
			lsText=basePage.getElementText(item);	
			lsFr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
			lstCustomerHubFr.add(lsFr);
		}
		
		//About TSC links
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lblAboutTSCText));
		String lsText_AboutTSC_Fr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
		
		List<String> lstAboutTSCFr=new ArrayList<String>();
		for(WebElement item:getGlobalFooterPageThreadLocal().lnkAboutTSCAllLinks) {
			lsText=basePage.getElementText(item);
			lsFr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
			lstAboutTSCFr.add(lsFr);			
		}
		
		//Rogers LOGO
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().imgRogersLogo), "Rogers Logo is existing", "Rogers Logo is not existing");		
		
		//Copyright text
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine1));
		String lsText_Copyright_Line1_Fr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine2));	
		String lsText_Copyright_Line2_Fr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
		
		//Switch to French
		getGlobalFooterPageThreadLocal().switchlanguage();
		
		//Credit card
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkCreditCard));
		reporter.softAssert(lsText.equalsIgnoreCase(lsText_CreditCard_Fr),"Credit card French transaltion is correct","Credit card French transaltion is not correct");
		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,false);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find credit card link.");
		}
		String lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkCreditCard);
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current credit card href of "+lsHref+" is equal to "+lsYmlHref,"The current credit card href of "+lsHref+" is not equal to "+lsYmlHref);
		String lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgCreditCard);
		reporter.softAssert(!lsImageSrc.isEmpty(),"The credit card image is not empty.","The credit card image is empty.");
				
		//Gift card
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkGiftCard));
		reporter.softAssert(lsText.equalsIgnoreCase(lsText_GiftCard_Fr),"Gift card French transaltion is correct","Gift card French transaltion is not correct");
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,false);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find Gift card link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkGiftCard);
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current Gift card href of "+lsHref+" is equal to "+lsYmlHref,"The current Gift card href of "+lsHref+" is not equal to "+lsYmlHref);
		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgGiftCard);
		reporter.softAssert(!lsImageSrc.isEmpty(),"The Gift card image is not empty.","The Gift card image is empty.");
		
		//Send us feedback
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkSendUsFeedback));
		reporter.softAssert(lsText.equalsIgnoreCase(lsText_SendUsFeedback_Fr),"SendUsFeedback French transaltion is correct","SendUsFeedback French transaltion is not correct");
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,false);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find Send us feedback link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkSendUsFeedback);
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current Send us feedback href of "+lsHref+" is correct","The current Send us feedback href of "+lsHref+" is not correct");
		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgSendUsFeedback);
		reporter.softAssert(!lsImageSrc.isEmpty(),"The Send us feedback image is not empty.","The Send us feedback image is empty.");
		
		//Language switch
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkLanguage));
		reporter.softAssert(lsText.equalsIgnoreCase(lsText_LanguageSwitch_En),"Language switch French transaltion is correct","Language switch French transaltion is not correct");
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,false);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find Language switch link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkLanguage);
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current Language switch href of "+lsHref+" is correct","The current Language switch href of "+lsHref+" is not correct");
				
		//TSC customer hub links
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lblTSCCustomerHubText));
		reporter.softAssert(lsText.equalsIgnoreCase(lsText_TSCCustomerHub_Fr),"Customer Hub text French transaltion is correct","Customer Hub text French transaltion is not correct");
		
		for(int i=0;i<getGlobalFooterPageThreadLocal().lnkTSCCustomerHubAllLinks.size();i++) {
			lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkTSCCustomerHubAllLinks.get(i)));	
			reporter.softAssert(lsText.equalsIgnoreCase(lstCustomerHubFr.get(i)),"The "+i+" CustomerHubLink French transaltion of "+lsText+" is the same as "+lstCustomerHubFr.get(i),"The "+i+" CustomerHubLink French transaltion of "+lsText+" is the same as "+lstCustomerHubFr.get(i));
			lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,false);			
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFail("Unable to find "+lsText+" link.");
			}
			lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkTSCCustomerHubAllLinks.get(i));	
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
		}
		
		//About TSC links
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lblAboutTSCText));
		reporter.softAssert(lsText.equalsIgnoreCase(lsText_AboutTSC_Fr),"About TSC text French transaltion is correct","About TSC French transaltion is not correct");
			
		for(int i=0;i<getGlobalFooterPageThreadLocal().lnkAboutTSCAllLinks.size();i++) {
			lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkAboutTSCAllLinks.get(i)));	
			reporter.softAssert(lsText.equalsIgnoreCase(lstAboutTSCFr.get(i)),"The "+i+" AboutTSLink French transaltion of "+lsText+" is the same as "+lstAboutTSCFr.get(i),"The "+i+" AboutTSLink French transaltion of "+lsText+" is the same as "+lstAboutTSCFr.get(i));
			lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,false);
			if(lsYmlHref.isEmpty()) {
				reporter.reportLogFail("Unable to find "+lsText+" link.");
			}
			lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkAboutTSCAllLinks.get(i));
			reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current "+lsText+" href of "+lsHref+" is correct while compared to "+lsYmlHref,"The current "+lsText+" href of "+lsHref+" is not correct while compared to "+lsYmlHref);
		}
		
		//Copyright text
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine1));
		reporter.softAssert(lsText.equalsIgnoreCase(lsText_Copyright_Line1_Fr),"Copyright line1 French transaltion is correct","Copyright line1 French transaltion is not correct");
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine2));
		reporter.softAssert(lsText.equalsIgnoreCase(lsText_Copyright_Line2_Fr),"Copyright line2 French transaltion is correct","Copyright line2 French transaltion is not correct");
		
		//Switch back to English
		getGlobalFooterPageThreadLocal().switchlanguage();
		
		//Credit card
		lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkCreditCard);
		String lsText_CreditCard_En=getGlobalFooterPageThreadLocal().getEnglishWithSpecificFrenchName(lstNameAndLinks,lsText_CreditCard_Fr);
		reporter.softAssert(lsText.equalsIgnoreCase(lsText_CreditCard_En),"The English text of "+lsText+" is correct","The English text of "+lsText+" is not correct");
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find credit card link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkCreditCard);
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current credit card href of "+lsHref+" is equal to "+lsYmlHref,"The current credit card href of "+lsHref+" is not equal to "+lsYmlHref);
		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgCreditCard);
		reporter.softAssert(!lsImageSrc.isEmpty(),"The credit card image is not empty.","The credit card image is empty.");

	}

}
