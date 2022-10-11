package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;


public class GF_TC03_VerifyLanguageForCustomerHubLinksAndAboutTSCLinks extends BaseTest {
	/*
	 * CER-168
	 */
	@Test(groups={"Regression","GlobalFooter"})
	public void GF_TC03_VerifyLanguageForCustomerHubLinksAndAboutTSCLinks() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		if(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl)){
			reporter.reportLogPass("TSC url is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("TSC url is incorrect");
		}
		reporter.reportLog("Global Footer Section");

		List<List<String>> lstNameAndLinks= TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
		
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
		List<String> lstCustomerHubFr=getGlobalFooterPageThreadLocal().getCustomerHubSubItemFr(lstNameAndLinks);
			
		//About TSC links
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lblAboutTSCText));
		String lsText_AboutTSC_Fr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
		List<String> lstAboutTSCFr=getGlobalFooterPageThreadLocal().getAboutTSCSubItemFr(lstNameAndLinks);
			
		//Rogers LOGO
		getGlobalFooterPageThreadLocal().verifyRogersLogo();		
		
		//Copyright text
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine1));
		String lsText_Copyright_Line1_Fr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine2));	
		String lsText_Copyright_Line2_Fr=getGlobalFooterPageThreadLocal().getFrenchWithSpecificEnglishName(lstNameAndLinks,lsText);
		
		//Switch to French
		getGlobalFooterPageThreadLocal().switchlanguage();
		
		//Credit card
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkCreditCard));
		if(lsText.equalsIgnoreCase(lsText_CreditCard_Fr)){
			reporter.reportLogPass("Credit card French translation is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("Credit card French translation is not correct");
		}

		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,false);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFailWithScreenshot("Unable to find credit card link.");
		}
		String lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkCreditCard);
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current credit card href of "+lsHref+" is equal to "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current credit card href of "+lsHref+" is not equal to "+lsYmlHref);
		}

		String lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgCreditCard);
		if(!lsImageSrc.isEmpty()){
			reporter.reportLogPass("The credit card image is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The credit card image is empty.");
		}

		//Gift card
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkGiftCard));
		if(lsText.equalsIgnoreCase(lsText_GiftCard_Fr)){
			reporter.reportLogPass("Gift card French translation is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("Gift card French translation is not correct");
		}

		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,false);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFailWithScreenshot("Unable to find Gift card link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkGiftCard);
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current Gift card href of "+lsHref+" is equal to "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current Gift card href of "+lsHref+" is not equal to "+lsYmlHref);
		}
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current Gift card href of "+lsHref+" is equal to "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current Gift card href of "+lsHref+" is not equal to "+lsYmlHref);
		}

		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgGiftCard);
		if(!lsImageSrc.isEmpty()){
			reporter.reportLogPass("The Gift card image is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Gift card image is empty.");
		}

		//Send us feedback
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkSendUsFeedback));
		if(lsText.equalsIgnoreCase(lsText_SendUsFeedback_Fr)){
			reporter.reportLogPass("SendUsFeedback French translation is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("SendUsFeedback French translation is not correct");
		}

		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,false);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFailWithScreenshot("Unable to find Send us feedback link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkSendUsFeedback);
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current Send us feedback href of "+lsHref+" is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("The current Send us feedback href of "+lsHref+" is not correct");
		}

		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgSendUsFeedback);
		if(!lsImageSrc.isEmpty()){
			reporter.reportLogPass("The Send us feedback image is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Send us feedback image is empty.");
		}

		//Language switch
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkLanguage));
		reporter.reportLog(lsText);
		reporter.reportLog(lsText_LanguageSwitch_En);
		if(lsText.equalsIgnoreCase(lsText_LanguageSwitch_En)){
			reporter.reportLogPass("Language switch French translation is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("Language switch French translation is not correct");
		}

		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,false);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFailWithScreenshot("Unable to find Language switch link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkLanguage);
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current Language switch href of "+lsHref+" is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("The current Language switch href of "+lsHref+" is not correct");
		}

		//TSC customer hub links
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lblTSCCustomerHubText));
		if(lsText.equalsIgnoreCase(lsText_TSCCustomerHub_Fr)){
			reporter.reportLogPass("Customer Hub text French translation is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("Customer Hub text French translation is not correct");
		}
		getGlobalFooterPageThreadLocal().verifyCustomerHubSubItemFr(lstNameAndLinks, lstCustomerHubFr);
		
		//About TSC links
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lblAboutTSCText));
		if(lsText.equalsIgnoreCase(lsText_AboutTSC_Fr)){
			reporter.reportLogPass("About TSC text French translation is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("About TSC French translation is not correct");
		}
		getGlobalFooterPageThreadLocal().verifyAboutTSCSubItemFr(lstNameAndLinks, lstAboutTSCFr);
		
		//Copyright text
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine1));
		reporter.reportLog(lsText);
		reporter.reportLog(lsText_Copyright_Line1_Fr);
		if(lsText.contains(lsText_Copyright_Line1_Fr)){
			reporter.reportLogPass("Copyright line1 French translation is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("Copyright line1 French translation is not correct");
		}

		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine2));
		reporter.reportLog(lsText);
		reporter.reportLog(lsText_Copyright_Line2_Fr);
		if(lsText.equalsIgnoreCase(lsText_Copyright_Line2_Fr)){
			reporter.reportLogPass("Copyright line2 French translation is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("Copyright line2 French translation is not correct");
		}

		//Switch back to English
		getGlobalFooterPageThreadLocal().switchlanguage();
		
		//Credit card
		lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkCreditCard);
		String lsText_CreditCard_En=getGlobalFooterPageThreadLocal().getEnglishWithSpecificFrenchName(lstNameAndLinks,lsText_CreditCard_Fr);
		if(lsText.equalsIgnoreCase(lsText_CreditCard_En)){
			reporter.reportLogPass("The English text of "+lsText+" is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("The English text of "+lsText+" is not correct");
		}

		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFailWithScreenshot("Unable to find credit card link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkCreditCard);
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current credit card href of "+lsHref+" is equal to "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current credit card href of "+lsHref+" is not equal to "+lsYmlHref);
		}

		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgCreditCard);
		if(!lsImageSrc.isEmpty()){
			reporter.reportLogPass("The credit card image is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The credit card image is empty.");
		}

	}

}
