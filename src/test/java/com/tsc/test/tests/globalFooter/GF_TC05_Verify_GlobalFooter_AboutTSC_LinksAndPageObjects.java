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

    @Test(groups={"Home","Regression","GlobalFooter"})
    public void verify_GlobalFooter_AboutTSC() {
        getGlobalFooterPageThreadLocal().closePopupDialog();
        BasePage basePage = new BasePage(this.getDriver());
        String lsBaseUrl = basePage.getBaseURL() + "/";

        reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
        reporter.reportLog("Global Footer Section");

        List<List<String>> lstNameAndLinks = TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();

        List<String> global_footer_items = new ArrayList<>();
        //Adding links present in About TSC to be verified
        global_footer_items.add("Terms of Use");
        global_footer_items.add("Privacy Policy");
        global_footer_items.add("Become a Vendor");
        for (String lsService : global_footer_items) {
            reporter.reportLog(lsService);
            WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);
            String lsHref=basePage.getElementHref(selectedItem);
            HashMap<String,String> testData=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsService,true);
            if(testData.isEmpty()) {
                reporter.reportLogFail("Unable to find '"+lsService+"' link.");
            }
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,testData.get("Link")),"The current '"+lsService+"' href of "+lsHref+" is equal to "+testData.get("Link"),"The current '"+lsService+"' href of "+lsHref+" is not equal to "+testData.get("Link"));

            if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().aboutUsPageTitle)) {
                reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
            }
            else {
                //Verifying page title
                String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().aboutUsPageTitle);
                reporter.softAssert(pageTitle.equalsIgnoreCase(testData.get("Title")),"Page Title matches for global footer link: "+lsService+" and title is: "+pageTitle,"Page Title doesn't match for global footer link: "+lsService+" and title is: "+pageTitle);
                //Verifying that user is navigated to respective section after navigating to page
                Boolean respectiveSectionValue=getGlobalFooterPageThreadLocal().verifyRespectiveSectionForLinkOnPage(getGlobalFooterPageThreadLocal().lstMyAccountItemTitle);
                reporter.softAssert(respectiveSectionValue,"Section for "+lsService+" on page: "+pageTitle+" is open after navigating","Section for "+lsService+" on page: "+pageTitle+" is not open after navigating");
                //Verifying Page Layout and sections
                getGlobalFooterPageThreadLocal().expandPanelItems(getGlobalFooterPageThreadLocal().lstMyAccountItemTitle,getGlobalFooterPageThreadLocal().lstMyAccountItemContent);
            }
        } 

        //More About TSC
        String lsService = "More About TSC";
        ArrayList<WebElement> elementList=new ArrayList<WebElement>();
        reporter.reportLog(lsService);
        WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);
        String lsHref=basePage.getElementHref(selectedItem);
        HashMap<String,String> testData=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsService,true);
        if(testData.isEmpty()) {
            reporter.reportLogFail("Unable to find '"+lsService+"' link.");
        }
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,testData.get("Link")),"The current '"+lsService+"' href of "+lsHref+" is equal to "+testData.get("Link"),"The current '"+lsService+"' href of "+lsHref+" is not equal to "+testData.get("Link"));

        if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().aboutUsPageTitle)) {
            reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
        }
        else {
            //Add In Page sub Header values
            for(WebElement item:getGlobalFooterPageThreadLocal().subHeaders) {
                elementList.add(item);
            }

            //Add Links present under different sub Headers on page
            for(WebElement item:getGlobalFooterPageThreadLocal().subHeaderLinks) {
                elementList.add(item);
            }

            getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
        }
        
        //Shop By Brand
        String lsServiceSBB = "Shop By Brand";
        reporter.reportLog(lsServiceSBB);
        WebElement selectedItemSBB=getGlobalFooterPageThreadLocal().getServiceWebElement(lsServiceSBB);
        String lsHrefSBB=basePage.getElementHref(selectedItemSBB);
        HashMap<String,String> testDataSBB=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsServiceSBB,true);
            if(testDataSBB.isEmpty()) {
                reporter.reportLogFail("Unable to find '"+lsServiceSBB+"' link.");
            }
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHrefSBB,testData.get("Link")),"The current '"+lsServiceSBB+"' href of "+lsHrefSBB+" is equal to "+testDataSBB.get("Link"),"The current '"+lsServiceSBB+"' href of "+lsHrefSBB+" is not equal to "+testDataSBB.get("Link"));

            if(!getGlobalFooterPageThreadLocal().goToService(lsServiceSBB,getGlobalFooterPageThreadLocal().aboutUsPageTitle)) {
                reporter.reportLogFail("Unable to navigate to '"+lsServiceSBB+"' page objects.");
            }
            else {
                //Verifying page title
                String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().aboutUsPageTitle);
                reporter.softAssert(pageTitle.equalsIgnoreCase(lsServiceSBB),"Page Title matches for global footer link: "+lsServiceSBB+" and  title is: "+pageTitle,"Page Title doesn't match for global footer link: "+lsServiceSBB+" and  title is: "+pageTitle);

                //Verifying Page Elements
                reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblSearchForaBrand),"The text Search for a Brand is displayed","The text Search for a Brand is not displayed");
                reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().textBoxShopByBrandInputSearchBox),"Input Search Box is visible","Input Search Box is not visible");
                reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblShopByBrandFilterByCategory),"The text Filter By Category is displayed","The text Filter By Category is not displayed");
                reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().buttonShopByBrandInputSearchBoxSearchButton),"The Search Button is visible","The Search Button is not visible");
                reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().dropDownShopByBrandFilterByCategory),"Drop Down for Filter By Category is displayed","Drop Down for Filter By Category is not displayed");
                reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblFilterByAlphabet),"The text Filter By Alphabet is visible","The text Filter By Alphabet is not visible");
               
                //Verifying Drop Down Title matches with Page Title
                getGlobalFooterPageThreadLocal().verifyDropDownWithTitle(getGlobalFooterPageThreadLocal().dropDownShopByBrandFilterByCategory);
                
                //Verifying Find By Alphabets Links and its contents
                getGlobalFooterPageThreadLocal().verifyFindByAlphabet(getGlobalFooterPageThreadLocal().dropDownShopByBrandFilterByCategory, getGlobalFooterPageThreadLocal().linkFindByAlphabet);
                
            }
            
            //Channel Finder
            String lsServiceCF = "Channel Finder";
            reporter.reportLog(lsServiceCF);
            WebElement selectedItemCF=getGlobalFooterPageThreadLocal().getServiceWebElement(lsServiceCF);
            String lsHrefCF=basePage.getElementHref(selectedItemCF);
            HashMap<String,String> testDataCF=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsServiceCF,true);
                if(testDataCF.isEmpty()) {
                    reporter.reportLogFail("Unable to find '"+lsServiceCF+"' link.");
                }
                reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHrefCF,testDataCF.get("Link")),"The current '"+lsServiceCF+"' href of "+lsHrefCF+" is equal to "+testDataCF.get("Link"),"The current '"+lsServiceCF+"' href of "+lsHrefCF+" is not equal to "+testDataCF.get("Link"));

                if(!getGlobalFooterPageThreadLocal().goToService(lsServiceCF,getGlobalFooterPageThreadLocal().lblChannelFinderTitle)) {
                    reporter.reportLogFail("Unable to navigate to '"+lsServiceCF+"' page objects.");
                }
                else {
                	//Verifying page title
                    String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().lblChannelFinderTitle);
                    reporter.softAssert(pageTitle.equalsIgnoreCase(lsServiceCF),"Page Title matches for global footer link: "+lsServiceCF+" and  title is: "+pageTitle,"Page Title doesn't match for global footer link: "+lsServiceCF+" and  title is: "+pageTitle);
                    
                    //Verifying Page Elements
                    //Find Cable Channels
                    reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblFindCableChannelTitle),"The Title Find Cable Channel is displayed","The Title Find Cable Channel is not displayed");
                    reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().useourchannelfinder),"Page paragraph line exists","Page paragraph line doesn't exists");
                    reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblselectyour),"The text Select your: exists","The text Select your: doesn't exists");
                    reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblProvince),"The Title Province exists","The Title Province doesn't exists");
                    reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblCableProvider),"The Title Cable Provider exists","The Title Cable Provider doesn't exists");
                    reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblCity),"The Title City exists","The Title City doesn't exists");
                    
                    //Satellite Channels
                    reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblSatelliteChannels),"The Title Satellite Channels exist","The Title Satellite Channels doesn't exist");
                    reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblBellTV),"The Title Satellite Channels exist","Page paragraph line doesn't exists");
                    reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblShawDirect),"Page paragraph line exists ","Page paragraph line doesn't exists");
                    reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblChannels113),"Page paragraph line exists ","Page paragraph line doesn't exists");
                    reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblChannels418),"Page paragraph line exists ","Page paragraph line doesn't exists");
                    
                    //Verifying Province Drop Down and its respective Cable Provider and City
                    getGlobalFooterPageThreadLocal().verifyMultipleDropDownWithTitle(getGlobalFooterPageThreadLocal().dropDownProvince, getGlobalFooterPageThreadLocal().dropDownCableProvider, getGlobalFooterPageThreadLocal().dropDownCity);
                
            }
            
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
                    for(int i=0;i<getGlobalFooterPageThreadLocal().listOfMeetOurHosts.size();i++) {
                    	String hostName=getGlobalFooterPageThreadLocal().listOfMeetOurHosts.get(i).getText();
                    	reporter.reportLog("Host Name is "+hostName+"");
                    	String hostHref=getGlobalFooterPageThreadLocal().linkOfMeetOurHosts.get(i).getAttribute("href");
                    	reporter.reportLog("Host Name URL is "+hostHref+"");
                    	getGlobalFooterPageThreadLocal().linkOfMeetOurHosts.get(i).click();
                    	
                    	//Verifying Href of the clicked link matches with expected URL
                    	reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(hostHref),"The current href of "+hostHref+" is contains in Current URL","The current '"+lsServiceMH+"' href of "+lsHrefMH+" is not equal to "+testDataMH.get("Link"));

                    	//Navigate to Meet The hosts
                    	getGlobalFooterPageThreadLocal().goToService(lsServiceMH,getGlobalFooterPageThreadLocal().aboutUsPageTitle);
                    	
                    }
                    
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
      