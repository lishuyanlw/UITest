package com.tsc.test.tests.globalFooter;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GF_TC05_Verify_GlobalFooter_AboutTSC_LinksAndPageObjects extends BaseTest {

	/*
	 * CER 184
	 * CER 185
	 * CER 186
	 * CER 187
	 * CER 188
	 * CER 189
	 * CER 190
	 */

    @Test(groups={"Home","Regression","GlobalFooter"})
    public void verify_GlobalFooter_AboutTSC() {
        getGlobalFooterPageThreadLocal().closePopupDialog();
        BasePage basePage = new BasePage(this.getDriver());
        String lsBaseUrl = basePage.getBaseURL() + "/";

        reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
        reporter.reportLog("Global Footer Section");

        List<List<String>> lstNameAndLinks = TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();

        ArrayList<WebElement> elementList = new ArrayList<WebElement>();
        List<String> global_footer_items = new ArrayList<>();
        //Adding links present in About TSC to be verified
        global_footer_items.add("Terms of Use");
        global_footer_items.add("Privacy Policy");
        global_footer_items.add("Become a Vendor");
        for (String lsService : global_footer_items) {
            reporter.reportLog(lsService);
            WebElement selectedItem = getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);
            String lsHref = basePage.getElementHref(selectedItem);
            HashMap<String, String> testData = getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
            if (testData.isEmpty()) {
                reporter.reportLogFail("Unable to find '" + lsService + "' link.");
            }
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref, testData.get("Link")), "The current '" + lsService + "' href of " + lsHref + " is equal to " + testData.get("Link"), "The current '" + lsService + "' href of " + lsHref + " is not equal to " + testData.get("Link"));

            if (!getGlobalFooterPageThreadLocal().goToService(lsService, getGlobalFooterPageThreadLocal().aboutUsPageTitle)) {
                reporter.reportLogFail("Unable to navigate to '" + lsService + "' page objects.");
            } else {
                //Verifying page title
                String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().aboutUsPageTitle);
                reporter.softAssert(pageTitle.equalsIgnoreCase(testData.get("Title")), "Page Title matches for global footer link: " + lsService + " and title is: " + pageTitle, "Page Title doesn't match for global footer link: " + lsService + " and title is: " + pageTitle);
                //Verifying that user is navigated to respective section after navigating to page
                Boolean respectiveSectionValue = getGlobalFooterPageThreadLocal().verifyRespectiveSectionForLinkOnPage(getGlobalFooterPageThreadLocal().lstMyAccountItemTitle);
                reporter.softAssert(respectiveSectionValue, "Section for " + lsService + " on page: " + pageTitle + " is open after navigating", "Section for " + lsService + " on page: " + pageTitle + " is not open after navigating");
                //Verifying Page Layout and sections
                getGlobalFooterPageThreadLocal().expandPanelItems(getGlobalFooterPageThreadLocal().lstMyAccountItemTitle, getGlobalFooterPageThreadLocal().lstMyAccountItemContent);

                //Add item section titles
                for (WebElement item : getGlobalFooterPageThreadLocal().lstMyAccountItemTitle) {
                    elementList.add(item);
                }

                //Add item section contents
                for (WebElement item : getGlobalFooterPageThreadLocal().lstMyAccountItemContent) {
                    elementList.add(item);
                }

                getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
            }
            elementList.clear();
        }
        //More About TSC
        String lsService = "More About TSC";
        reporter.reportLog(lsService);
        WebElement selectedItem = getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);
        String lsHref = basePage.getElementHref(selectedItem);
        HashMap<String, String> testData = getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
        if (testData.isEmpty()) {
            reporter.reportLogFail("Unable to find '" + lsService + "' link.");
        }
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref, testData.get("Link")), "The current '" + lsService + "' href of " + lsHref + " is equal to " + testData.get("Link"), "The current '" + lsService + "' href of " + lsHref + " is not equal to " + testData.get("Link"));

        if (!getGlobalFooterPageThreadLocal().goToService(lsService, getGlobalFooterPageThreadLocal().aboutUsPageTitle)) {
            reporter.reportLogFail("Unable to navigate to '" + lsService + "' page objects.");
        } else {
            //Add In Page sub Header values
            for (WebElement item : getGlobalFooterPageThreadLocal().subHeaders) {
                elementList.add(item);
            }

            //Add Links present under different sub Headers on page
            for (WebElement item : getGlobalFooterPageThreadLocal().subHeaderLinks) {
                elementList.add(item);
            }
            getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
        }
        elementList.clear();

        //Meet The Hosts
        String lsServiceMH = "Meet the Hosts";
        String actualPageTitle="Meet Our Hosts";
        reporter.reportLog(lsServiceMH);
        WebElement selectedItemMH=getGlobalFooterPageThreadLocal().getServiceWebElement(lsServiceMH);
        String lsHrefMH=basePage.getElementHref(selectedItemMH);
        HashMap<String,String> testDataMH=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsServiceMH,true);
        if(testDataMH.isEmpty()) {
            reporter.reportLogFail("Unable to find '"+lsServiceMH+"' link.");
        }
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHrefMH,testDataMH.get("Link")),"The current '"+lsServiceMH+"' href of "+lsHrefMH+" is equal to "+testDataMH.get("Link"),"The current '"+lsServiceMH+"' href of "+lsHrefMH+" is not equal to "+testDataMH.get("Link"));

        if(!getGlobalFooterPageThreadLocal().goToService(lsServiceMH,getGlobalFooterPageThreadLocal().aboutUsPageTitle)) {
            reporter.reportLogFail("Unable to navigate to '"+lsServiceMH+"' page objects.");
        }
        else {
            //Verifying page title
            String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().aboutUsPageTitle);
            reporter.softAssert(pageTitle.equalsIgnoreCase(actualPageTitle),"Page Title matches for global footer link: "+lsServiceMH+" and  title is: "+pageTitle,"Page Title doesn't match for global footer link: "+lsServiceMH+" and  title is: "+pageTitle);

            //Verifying Host Name, Link and Images in Meet The Host Page
            getGlobalFooterPageThreadLocal().verifyMeetTheHostInfo();
        }

        //Verifying Presence of Credit Card, Gift Card and Rogers Copyrights at the GlobalFooter Page
        //Gift Card
        String lsServiceGC = "Gift Card";
        reporter.reportLog(lsServiceGC);
        String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().lblGiftCardText);
        reporter.softAssert(pageTitle.equalsIgnoreCase(lsServiceGC),"Page Title matches for global footer link: "+lsServiceGC+" and  title is: "+pageTitle,"Page Title doesn't match for global footer link: "+lsServiceGC+" and  title is: "+pageTitle);
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lnkGiftCard),"The Gift Card section exists","The Gift Card section doesn't exists");

        //Credit Card
        String lsServiceCC = "Credit Card";
        reporter.reportLog(lsServiceCC);
        String pageTitleCC = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().blkCreditCard);
        reporter.softAssert(pageTitleCC.equalsIgnoreCase(lsServiceCC),"Page Title matches for global footer link: "+lsServiceCC+" and  title is: "+pageTitleCC,"Page Title doesn't match for global footer link: "+lsServiceCC+" and  title is: "+pageTitleCC);
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lnkCreditCard),"The Credit section exists","The Credit Card section doesn't exists");

        //Rogers Copy Rights
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().RogersMedia),"The Copyright Section of 2021 Rogers Media is displayed","The Copyright Section of 2021 Rogers Media is not displayed");
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().AllPrice),"The Copyright Section of All Price in Canadian Dollars is displayed","The Copyright Section of All Price in Canadian Dollars is not displayed");
        String lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().RogersMediaImg);
        reporter.softAssert(!lsImageSrc.isEmpty(),"The Rogers Media image is not empty.","The Rogers Media image is empty.");
    }
 }
