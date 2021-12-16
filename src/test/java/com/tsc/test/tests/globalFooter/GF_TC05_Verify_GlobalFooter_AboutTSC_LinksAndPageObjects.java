package com.tsc.test.tests.globalFooter;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,String> testData = null;
        //Adding links present in About TSC to be verified
        global_footer_items.add("Terms of Use");
        global_footer_items.add("Privacy Policy");
        global_footer_items.add("Become a Vendor");
        for (String lsService : global_footer_items) {
            if(testData!=null)
                testData.clear();
            testData = getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
            reporter.reportLog(lsService);
            WebElement selectedItem = getGlobalFooterPageThreadLocal().getServiceWebElement(lsService,testData.get("parent"));
            String lsHref = basePage.getElementHref(selectedItem);
            if (testData.isEmpty()) {
                reporter.reportLogFail("Unable to find '" + lsService + "' link.");
            }
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref, testData.get("Link")), "The current '" + lsService + "' href of " + lsHref + " is equal to " + testData.get("Link"), "The current '" + lsService + "' href of " + lsHref + " is not equal to " + testData.get("Link"));

            if (!getGlobalFooterPageThreadLocal().goToService(lsService, getGlobalFooterPageThreadLocal().aboutUsPageTitle,testData.get("parent"))) {
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
        testData.clear();
        testData = getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
        reporter.reportLog(lsService);
        WebElement selectedItem = getGlobalFooterPageThreadLocal().getServiceWebElement(lsService,testData.get("parent"));
        String lsHref = basePage.getElementHref(selectedItem);
        if (testData.isEmpty()) {
            reporter.reportLogFail("Unable to find '" + lsService + "' link.");
        }
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref, testData.get("Link")), "The current '" + lsService + "' href of " + lsHref + " is equal to " + testData.get("Link"), "The current '" + lsService + "' href of " + lsHref + " is not equal to " + testData.get("Link"));

        if (!getGlobalFooterPageThreadLocal().goToService(lsService, getGlobalFooterPageThreadLocal().aboutUsPageTitle,testData.get("parent"))) {
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

        //Channel Finder
        String lsServiceCF = "Channel Finder";
        reporter.reportLog(lsServiceCF);
        Map<String,String> testDataCF=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsServiceCF,true);
        WebElement selectedItemCF=getGlobalFooterPageThreadLocal().getServiceWebElement(lsServiceCF,testDataCF.get("parent"));
        String lsHrefCF=basePage.getElementHref(selectedItemCF);
        if(testDataCF.isEmpty()) {
            reporter.reportLogFail("Unable to find '"+lsServiceCF+"' link.");
        }
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHrefCF,testDataCF.get("Link")),"The current '"+lsServiceCF+"' href of "+lsHrefCF+" is equal to "+testDataCF.get("Link"),"The current '"+lsServiceCF+"' href of "+lsHrefCF+" is not equal to "+testDataCF.get("Link"));

        if(!getGlobalFooterPageThreadLocal().goToService(lsServiceCF,getGlobalFooterPageThreadLocal().lblChannelFinderTitle,testDataCF.get("parent"))) {
            reporter.reportLogFail("Unable to navigate to '"+lsServiceCF+"' page objects.");
        }
        else {
            //Verifying page title
            String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().lblChannelFinderTitle);
            reporter.softAssert(pageTitle.equalsIgnoreCase(lsServiceCF),"Page Title matches for global footer link: "+lsServiceCF+" and  title is: "+pageTitle,"Page Title doesn't match for global footer link: "+lsServiceCF+" and  title is: "+pageTitle);

            //Verifying Page Elements
            //Find Cable Channels
            //reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().useourchannelfinder),"Page paragraph line exists","Page paragraph line doesn't exists");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblFindCableChannelTitle),"The Title Find Cable Channel is displayed","The Title Find Cable Channel is not displayed");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblselectyour),"The text Select your: exists","The text Select your: doesn't exists");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblProvince),"The Title Province exists","The Title Province doesn't exists");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblCableProvider),"The Title Cable Provider exists","The Title Cable Provider doesn't exists");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblCity),"The Title City exists","The Title City doesn't exists");

            //Satellite Channels
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblSatelliteChannels),"The Title Satellite Channels exist","The Title Satellite Channels doesn't exist");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblBellTV),"The Title Satellite Channels exist","Page paragraph line doesn't exists");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblShawDirect),"Page paragraph line exists ","Page paragraph line doesn't exists");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblChannelsBellTV),"The line under Bell TV Column exists","The line under Bell TV Column doesn't exists");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblChannelsShawDirect),"The line under Shaw Direct Column exists","The line under Shaw Direct Column exists");

            //Verifying Province Drop Down and its respective Cable Provider and City
            getGlobalFooterPageThreadLocal().verifyMultipleDropDownWithTitle(getGlobalFooterPageThreadLocal().dropDownProvince, getGlobalFooterPageThreadLocal().dropDownCableProvider, getGlobalFooterPageThreadLocal().dropDownCity);
        }

        //Meet The Hosts
        String lsServiceMH = "Meet the Hosts";
        String actualPageTitle="Meet Our Hosts";
        Map<String,String> testDataMH=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsServiceMH,true);
        reporter.reportLog(lsServiceMH);
        WebElement selectedItemMH=getGlobalFooterPageThreadLocal().getServiceWebElement(lsServiceMH,testDataMH.get("parent"));
        String lsHrefMH=basePage.getElementHref(selectedItemMH);
        if(testDataMH.isEmpty()) {
            reporter.reportLogFail("Unable to find '"+lsServiceMH+"' link.");
        }
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHrefMH,testDataMH.get("Link")),"The current '"+lsServiceMH+"' href of "+lsHrefMH+" is equal to "+testDataMH.get("Link"),"The current '"+lsServiceMH+"' href of "+lsHrefMH+" is not equal to "+testDataMH.get("Link"));

        if(!getGlobalFooterPageThreadLocal().goToService(lsServiceMH,getGlobalFooterPageThreadLocal().aboutUsPageTitle,testDataMH.get("parent"))) {
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
