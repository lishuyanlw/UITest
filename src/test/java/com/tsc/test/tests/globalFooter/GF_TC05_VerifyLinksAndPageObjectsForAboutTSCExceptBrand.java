package com.tsc.test.tests.globalFooter;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GF_TC05_VerifyLinksAndPageObjectsForAboutTSCExceptBrand extends BaseTest {

    /*
     * CER 184
     * CER 185
     * CER 186
     * CER 187
     * CER 188
     * CER 189
     * CER 190
     */

    @Test(groups={"Regression","GlobalFooter"})
    public void GF_TC05_VerifyLinksAndPageObjectsForAboutTSCExceptBrand() {
        getGlobalFooterPageThreadLocal().closePopupDialog();
        BasePage basePage = new BasePage(this.getDriver());
        String lsBaseUrl = basePage.getBaseURL() + "/";

        if(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl)){
            reporter.reportLogPass("TSC url is correct");
        }
        else{
            reporter.reportLogFailWithScreenshot("TSC url is incorrect");
        }

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
            if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref, testData.get("Link"))){
                reporter.reportLogPass("The current '" + lsService + "' href of " + lsHref + " is equal to " + testData.get("Link"));
            }
            else{
                reporter.reportLogFailWithScreenshot("The current '" + lsService + "' href of " + lsHref + " is not equal to " + testData.get("Link"));
            }

            if (!getGlobalFooterPageThreadLocal().goToService(lsService, getGlobalFooterPageThreadLocal().aboutUsPageTitle,testData.get("parent"))) {
                reporter.reportLogFail("Unable to navigate to '" + lsService + "' page objects.");
            } else {
                //Verifying page title
                String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().aboutUsPageTitle);
                if(pageTitle.equalsIgnoreCase(testData.get("Title"))){
                    reporter.reportLogPass("Page Title matches for global footer link: " + lsService + " and title is: " + pageTitle);
                }
                else{
                    reporter.reportLogFailWithScreenshot("Page Title doesn't match for global footer link: " + lsService + " and title is: " + pageTitle);
                }

                //Verifying that user is navigated to respective section after navigating to page
                Boolean respectiveSectionValue = getGlobalFooterPageThreadLocal().verifyRespectiveSectionForLinkOnPage(getGlobalFooterPageThreadLocal().lstMyAccountItemTitle);
                if(respectiveSectionValue){
                    reporter.reportLogPass("Section for " + lsService + " on page: " + pageTitle + " is open after navigating");
                }
                else{
                    reporter.reportLogFailWithScreenshot("Section for " + lsService + " on page: " + pageTitle + " is not open after navigating");
                }

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
        if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref, testData.get("Link"))){
            reporter.reportLogPass("The current '" + lsService + "' href of " + lsHref + " is equal to " + testData.get("Link"));
        }
        else{
            reporter.reportLogFailWithScreenshot("The current '" + lsService + "' href of " + lsHref + " is not equal to " + testData.get("Link"));
        }

        if (!getGlobalFooterPageThreadLocal().goToService(lsService, getGlobalFooterPageThreadLocal().lblAboutUsPageMsg,testData.get("parent"))) {
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
        if(getGlobalFooterPageThreadLocal().verifyLinks(lsHrefCF,testDataCF.get("Link"))){
            reporter.reportLogPass("The current '"+lsServiceCF+"' href of "+lsHrefCF+" is equal to "+testDataCF.get("Link"));
        }
        else{
            reporter.reportLogFailWithScreenshot("The current '"+lsServiceCF+"' href of "+lsHrefCF+" is not equal to "+testDataCF.get("Link"));
        }

        if(!getGlobalFooterPageThreadLocal().goToService(lsServiceCF,getGlobalFooterPageThreadLocal().lblChannelFinderTitle,testDataCF.get("parent"))) {
            reporter.reportLogFail("Unable to navigate to '"+lsServiceCF+"' page objects.");
        }
        else {
            //Verifying page title
            String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().lblChannelFinderTitle);
            if(pageTitle.equalsIgnoreCase(lsServiceCF)){
                reporter.reportLogPass("Page Title matches for global footer link: "+lsServiceCF+" and  title is: "+pageTitle);
            }
            else{
                reporter.reportLogFailWithScreenshot("Page Title doesn't match for global footer link: "+lsServiceCF+" and  title is: "+pageTitle);
            }

            //Verifying Page Elements
            //Find Cable Channels
            //reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().useourchannelfinder),"Page paragraph line exists","Page paragraph line doesn't exists");
            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblFindCableChannelTitle)){
                reporter.reportLogPass("The Title Find Cable Channel is displayed");
            }
            else{
                reporter.reportLogFailWithScreenshot("The Title Find Cable Channel is not displayed");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblselectyour)){
                reporter.reportLogPass("The text Select your: exists");
            }
            else{
                reporter.reportLogFailWithScreenshot("The text Select your: doesn't exist");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblProvince)){
                reporter.reportLogPass("The Title Province exists");
            }
            else{
                reporter.reportLogFailWithScreenshot("The Title Province doesn't exist");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblCableProvider)){
                reporter.reportLogPass("The Title Cable Provider exists");
            }
            else{
                reporter.reportLogFailWithScreenshot("The Title Cable Provider doesn't exist");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblCity)){
                reporter.reportLogPass("The Title City exists");
            }
            else{
                reporter.reportLogFailWithScreenshot("The Title City doesn't exist");
            }

            //Satellite Channels
            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblSatelliteChannels)){
                reporter.reportLogPass("The Title Satellite Channels exist");
            }
            else{
                reporter.reportLogFailWithScreenshot("The Title Satellite Channels doesn't exist");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblBellTV)){
                reporter.reportLogPass("The Title Satellite Channels exist");
            }
            else{
                reporter.reportLogFailWithScreenshot("Page paragraph line doesn't exist");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblShawDirect)){
                reporter.reportLogPass("Page paragraph line exists");
            }
            else{
                reporter.reportLogFailWithScreenshot("Page paragraph line doesn't exist");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblChannelsBellTV)){
                reporter.reportLogPass("The line under Bell TV Column exists");
            }
            else{
                reporter.reportLogFailWithScreenshot("The line under Bell TV Column doesn't exist");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblChannelsShawDirect)){
                reporter.reportLogPass("The line under Shaw Direct Column exists");
            }
            else{
                reporter.reportLogFailWithScreenshot("The line under Shaw Direct Column exist");
            }

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
        if(getGlobalFooterPageThreadLocal().verifyLinks(lsHrefMH,testDataMH.get("Link"))){
            reporter.reportLogPass("The current '"+lsServiceMH+"' href of "+lsHrefMH+" is equal to "+testDataMH.get("Link"));
        }
        else{
            reporter.reportLogFailWithScreenshot("The current '"+lsServiceMH+"' href of "+lsHrefMH+" is not equal to "+testDataMH.get("Link"));
        }

        if(!getGlobalFooterPageThreadLocal().goToService(lsServiceMH,getGlobalFooterPageThreadLocal().aboutUsPageTitle,testDataMH.get("parent"))) {
            reporter.reportLogFail("Unable to navigate to '"+lsServiceMH+"' page objects.");
        }
        else {
            //Verifying page title
            String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().aboutUsPageTitle);
            if(pageTitle.equalsIgnoreCase(actualPageTitle)){
                reporter.reportLogPass("Page Title matches for global footer link: "+lsServiceMH+" and  title is: "+pageTitle);
            }
            else{
                reporter.reportLogFailWithScreenshot("Page Title doesn't match for global footer link: "+lsServiceMH+" and  title is: "+pageTitle);
            }

            //Verifying Host Name, Link and Images in Meet The Host Page
            getGlobalFooterPageThreadLocal().verifyMeetTheHostInfo();
        }

        //Verifying Presence of Credit Card, Gift Card and Rogers Copyrights at the GlobalFooter Page
        //Gift Card
        String lsServiceGC = "Gift Card";
        reporter.reportLog(lsServiceGC);
        String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().lblGiftCardText);
        if(pageTitle.equalsIgnoreCase(lsServiceGC)){
            reporter.reportLogPass("Page Title matches for global footer link: "+lsServiceGC+" and  title is: "+pageTitle);
        }
        else{
            reporter.reportLogFailWithScreenshot("Page Title doesn't match for global footer link: "+lsServiceGC+" and  title is: "+pageTitle);
        }
        if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lnkGiftCard)){
            reporter.reportLogPass("The Gift Card section exists");
        }
        else{
            reporter.reportLogFailWithScreenshot("The Gift Card section doesn't exist");
        }

        //Credit Card
        String lsServiceCC = "Credit Card";
        reporter.reportLog(lsServiceCC);
        String pageTitleCC = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().blkCreditCard);
        if(pageTitleCC.equalsIgnoreCase(lsServiceCC)){
            reporter.reportLogPass("Page Title matches for global footer link: "+lsServiceCC+" and  title is: "+pageTitleCC);
        }
        else{
            reporter.reportLogFailWithScreenshot("Page Title doesn't match for global footer link: "+lsServiceCC+" and  title is: "+pageTitleCC);
        }
        if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lnkCreditCard)){
            reporter.reportLogPass("The Credit section exists");
        }
        else{
            reporter.reportLogFailWithScreenshot("The Credit Card section doesn't exist");
        }

        //Rogers Copy Rights
        String lsTestDevice = System.getProperty("Device").trim();
        if(!lsTestDevice.equalsIgnoreCase("Mobile")) {
            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().RogersMedia)){
                reporter.reportLogPass("The Copyright Section of Rogers Media is displayed");
            }
            else{
                reporter.reportLogFailWithScreenshot("The Copyright Section of Rogers Media is not displayed");
            }
        }

        if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().AllPrice)){
            reporter.reportLogPass("The Copyright Section of All Price in Canadian Dollars is displayed");
        }
        else{
            reporter.reportLogFailWithScreenshot("The Copyright Section of All Price in Canadian Dollars is not displayed");
        }

        String lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().RogersMediaImg);
        if(!lsImageSrc.isEmpty()){
            reporter.reportLogPass("The Rogers Media image is not empty.");
        }
        else{
            reporter.reportLogFailWithScreenshot("The Rogers Media image is empty.");
        }

    }
}
