package com.tsc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class ProductDetailPage_Mobile extends ProductDetailPage{

    public ProductDetailPage_Mobile(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divVideoIcon']")
    public WebElement videoIcon;

    @FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@class='videoBox']//button[contains(@class,'amp-pause-overlay')]")
    public WebElement playButton;

    //Review Section
    @FindBy(xpath = "//div[@class='scrolling']//*[@class='pr-reviewHeader']")
    public WebElement lblReviewTabHeader;

    @FindBy(xpath = "//section[@id='pr-review-snapshot']//div[@class='pr-review-snapshot-histogram']")
    public WebElement imgReviewTabHistogram;

    @FindBy(xpath = "//section[@id='pr-review-snapshot']//div[@class='pr-snippet-stars-reco-stars']//div[@class='pr-snippet-rating-decimal']")
    public WebElement lblReviewTabRateDecimalText;

    @FindBy(xpath = "//section[@id='pr-review-snapshot']//div[@class='pr-snippet-stars-reco-stars']//div[@class='pr-rating-stars']//div[contains(@class,'pr-star-v4')]")
    public List<WebElement> lstReviewTabStar;

    @FindBy(xpath = "//section[@id='pr-review-snapshot']//div[@class='pr-snippet-stars-reco-stars']//span[@class='pr-accessible-text']")
    public WebElement lblReviewTabStarAccessibleText;

    @FindBy(xpath = "//section[@id='pr-review-snapshot']//span[@class='pr-snippet-review-count']")
    public WebElement lblReviewTabReviewCount;

    @FindBy(xpath = "//section[@class='pr-review-snapshot-snippets']//a[contains(@href,'writereview')]")
    public WebElement lnkReviewTabWriteReview;

    @FindBy(xpath = "//section[@id='pr-review-display']//select[@id='pr-rd-sort-by']")
    public WebElement selectReviewTabSortBy;

    //Review list part
    @FindBy(xpath = "//section[@id='pr-review-display']//div[@class='pr-review']")
    public List<WebElement> lstReviewTabPerReviewList;

    //Review Tab footer part
    @FindBy(xpath = "//section[@id='pr-review-display']//p[@class='pr-rd-review-position']")
    public WebElement lblReviewTabDisplayingReviewMsg;

    @FindBy(xpath = "//section[@id='pr-review-display']//a[contains(@class,'pr-rd-to-top')]")
    public WebElement lnkReviewTabBackToTop;

    @FindBy(xpath = "//section[@id='pr-review-display']//div[@class='pr-rd-pagination']")
    public WebElement cntReviewTabPagination;

    //Thumbnail part
    @FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//button[contains(@class,'slick-prev')]")
    public WebElement btnThumbnailPrev;

    @FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//button[contains(@class,'slick-next')]")
    public WebElement btnThumbnailNext;

    //Sticky swiper container part
    @FindBy(xpath = "//div[@class='modal-content']//div[@class='scrolling']")
    public WebElement btnStickyTabProductReview;

    //Sold out
    @FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='soldoutContainerMobile']")
    public WebElement lblSoldOut;

    //Sticky swiper container part
    @FindBy(xpath = "//div[@id='divProductTab']//div[contains(@class,'panel-default')]//div[contains(@class,'panel-heading')]")
    public List<WebElement> lstStickyTabProductTabList;

    @FindBy(xpath = "//div[@class='modal-dialog']//div[@class='modal-body scrolling-content']//div[@class='scrolling']")
    public WebElement btnStickyTabSizeChart;

    //Back button
    @FindBy(xpath = "//div[contains(@class,'modalFull')]//div[@class='modal-dialog']//div[@class='modal-header']")
    public WebElement backButton;

    //tell your friends Window close
    @FindBy(xpath = "//div[contains(@class,'ReactModal__Overlay')]//button[@class='modal__button-back']")
    public WebElement btnTellYourFriendsWindowClose;

    //TrueFitFrame
    @FindBy(xpath = "//div[@class='tfc-popup-contents']//tfc-window-footer//tfc-button-bar//button")
    public WebElement btnProductTrueFitIframeFooterGetStarted;

    @FindBy(xpath = "//button[contains(@class,'tfc-cfg-close-button') and not(contains(@class,'tfc-desktop-only'))][img]")
    public WebElement btnProductTrueFitIframeClose;

    //Sub total
    @FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[contains(@class,'add-to-bag__subtotal')]")
    public WebElement lblAddToBagPopupWindowButtonSectionSubtotal;

    //Sold out message
    @FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='soldoutContainerMobile']")
    public WebElement lblSoldOutMessage;

    //product overview
    @FindBy(xpath = "//div[@id='pdpMainDiv']//div[@id='divProductTab']//div[contains(@class,'panel-heading')]//a[@data-text='PRODUCT OVERVIEW']")
    public WebElement productOverview;

    //Size chart
    @FindBy(xpath = "//div[@id='pdpMainDiv']//div[@id='divProductTab']//div[contains(@class,'panel-heading')]//a[@data-text='SIZE CHART']")
    public WebElement sizeChart;

    //product review
    @FindBy(xpath = "//div[@id='divProductTab']//div[contains(@class,'panel-default')]//div[@id='btnCustomerReviewPopup']")
    public WebElement productReview;

    @Override
    public void verifyVideo(String lsVideoDisclaimInfo) {
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgProductBadge),"The product badge is displaying correctly","The product badge is not displaying correctly");
        reporter.softAssert(!this.imgProductBadge.getAttribute("src").isEmpty(),"The product badge image source is not empty","The product badge image source is empty");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.videoIcon);
        this.getReusableActionsInstance().clickIfAvailable(this.videoIcon);
        applyStaticWait(this.getStaticWaitForApplication());
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.playButton);
        this.getReusableActionsInstance().scrollToElement(this.playButton);
        this.getReusableActionsInstance().clickIfAvailable(this.playButton);
        applyStaticWait(this.getStaticWaitForApplication());

        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
        reporter.softAssert(!this.lnkVideo.getAttribute("src").isEmpty(),"The product video source is not empty","The product video source is empty");

        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblVideoDisclaim),"The product video disclaim text is displaying correctly","The product video disclaim text is not displaying correctly");
        reporter.softAssert(this.getElementText(this.lblVideoDisclaim).equalsIgnoreCase(lsVideoDisclaimInfo),"The product video disclaim text is equal to the text of '"+lsVideoDisclaimInfo+"'","The product video disclaim text is not equal to the text of '"+lsVideoDisclaimInfo+"'");

        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
        //commented because autoplay is not present for both tab and mobile
        if(!System.getProperty("Browser").toLowerCase().contains("ios")){
            reporter.softAssert(this.checkIfVideoisPlaying(),"The product video is playing","The product video is not playing");
        }
    }

    @Override
    public void verifyThumbnailPrevButton() {

    }

    @Override
    public void verifyThumbnail() {
        this.getDriver().navigate().refresh();
        this.waitForPageToLoad();
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntThumbnailContainer),"The Thumbnail section is displaying correctly","The Thumbnail section is not displaying correctly");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnThumbnailPrev),"The Thumbnail prev button is displaying correctly","The Thumbnail prev button is not displaying correctly");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnThumbnailNext),"The Thumbnail next button is displaying correctly","The Thumbnail next button is not displaying correctly");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.videoIcon);
        this.getReusableActionsInstance().clickIfAvailable(this.videoIcon);
        //this.videoIcon.click();
        reporter.softAssert(!this.lnkThumbnailVideo.getAttribute("data-video").isEmpty(),"The video src is not empty","The video src is empty");
        reporter.softAssert(!this.imgThumbnailVideo.getAttribute("src").isEmpty(),"The video image is not empty","The video image is empty");
        this.verifyThumbnailImageListSrc();
        this.verifyThumbnailPrevButton();
        this.verifyThumbnailNextButton();
    }

    @Override
    public void verifyThumbnailNextButton() {

    }

    @Override
    public void verifyVideoOff() {

    }

    @Override
    public boolean goToProductReviewTab() {
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productReviewSection);
        this.getReusableActionsInstance().scrollToElement(this.productReviewSection);
        this.getReusableActionsInstance().clickIfAvailable(this.productReviewSection);
        //added if condition because in jenkins ios it is not clicking on first time so,
        //I added second click with condition but still it is not clicking
        /*if (!this.backButton.isDisplayed()){
            JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
            jse.executeScript("arguments[0].click();", this.backButton);
        }*/
        //this.productReviewSection.click();
        return this.waitForCondition(Driver->{return this.btnStickyTabProductReview.getAttribute("class").contains("scrolling");},30000);
    }

    @Override
    public boolean getStickyTabSelectedStatus(WebElement btnTab) {
        return btnTab.getAttribute("class").contains("scrolling");
    }

    @Override
    public void verifyReviewTabContent() {
        reporter.softAssert(!this.getElementText(this.lblReviewTabHeader).isEmpty(),"The Review tab header is not empty","The Review tab header is empty");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgReviewTabHistogram),"The Review tab histogram is displaying correctly","The Review tab histogram is not displaying correctly");
        reporter.softAssert(!this.getElementText(this.lblReviewTabRateDecimalText).isEmpty(),"The Review tab rate number is not empty","The Review tab rate number is empty");
        reporter.softAssert(this.lstReviewTabStar.size()>0,"The product review tab star count is greater than 0","The product review tab star count is not greater than 0");
        reporter.softAssert(!this.getElementText(this.lblReviewTabReviewCount).isEmpty(),"The Review count message is not empty","The Review count message is empty");
        reporter.softAssert(!this.getElementHref(this.lnkReviewTabWriteReview).isEmpty(),"The Write Review link is not empty","The Write Review link is empty");
        reporter.softAssert(!this.getElementText(this.lblReviewTabRateDecimalText).isEmpty(),"The Review tab rate number is not empty","The Review tab rate number is empty");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.selectReviewTabSortBy),"The Review sorting is displaying correctly","The Review sorting is not displaying correctly");
    }

    @Override
    public void verifyReviewTabPerReviewListContents() {
        WebElement element;
        String lsHeadingLine;
        for(WebElement item:this.lstReviewTabPerReviewList) {
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            element=item.findElement(this.byReviewTabHeadingLine);
            lsHeadingLine=element.getText().trim();
            reporter.reportLog("Review of '"+lsHeadingLine+"'");
            reporter.softAssert(!lsHeadingLine.isEmpty(), "The Headingline is not empty", "The Headingline is empty");

            element=item.findElement(this.byReviewTabStarSection);
            reporter.softAssert(this.getReusableActionsInstance().isElementVisible(element), "The Review star section is existing", "The Review star section is not existing");

            element=item.findElement(this.byReviewTabSubmittedTime);
            reporter.softAssert(this.getReusableActionsInstance().isElementVisible(element), "The Submitted time section is existing", "The Submitted time section is not existing");

            element=item.findElement(this.byReviewTabNickName);
            reporter.softAssert(this.getReusableActionsInstance().isElementVisible(element), "The Nickname section is existing", "The Nickname section is not existing");

            element=item.findElement(this.byReviewTabRightPartSection);
            if(this.getChildElementCount(element)>1) {
                element=item.findElement(this.byReviewTabVerifiedBuyerIcon);
                reporter.softAssert(this.getReusableActionsInstance().isElementVisible(element), "The Verified buyer icon is existing", "The Verified buyer icon is not existing");

                element=item.findElement(this.byReviewTabVerifiedBuyerText);
                reporter.softAssert(this.getReusableActionsInstance().isElementVisible(element), "The Verified buyer text section is existing", "The Verified buyer text section is not existing");
            }

            element=item.findElement(this.byReviewTabDescriptionText);
            reporter.softAssert(this.getReusableActionsInstance().isElementVisible(element), "The Description text section is existing", "The Description text section is not existing");

            element=item.findElement(this.byReviewTabImage);
            if(!element.getCssValue("height").equalsIgnoreCase("0px")) {
                reporter.softAssert(this.getReusableActionsInstance().isElementVisible(element), "The Image section is existing", "The Image section is not existing");
            }

            element=item.findElement(this.byReviewTabFooter);
            reporter.softAssert(this.getReusableActionsInstance().isElementVisible(element), "The Footer section is existing", "The Footer section is not existing");
        }
    }

    @Override
    public String checkReviewRateSortingBy(boolean bHighesttRatedFirst) {
        List<WebElement> elementList;
        String lsHeadingLinePrev,lsHeadingLineNext;
        int ratingPrev,ratingNext;
        String lsMsg="";
        int reviewCount=this.lstReviewTabPerReviewList.size();
        if(reviewCount<=1) {
            lsMsg="The review list count is less than 2, so don't need to do the sorting!";
            return lsMsg;
        }

        ProductResultsPage productResultsPage=new ProductResultsPage(this.getDriver());
        for(int i=0;i<reviewCount-1;i++) {
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstReviewTabPerReviewList.get(i));
            elementList=this.lstReviewTabPerReviewList.get(i).findElements(this.byReviewTabStarList);
            ratingPrev=productResultsPage.getProductItemReviewNumberAmountFromStarImage(elementList);
            lsHeadingLinePrev=this.lstReviewTabPerReviewList.get(i).findElement(this.byReviewTabHeadingLine).getText().trim();

            this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstReviewTabPerReviewList.get(i+1));
            elementList=this.lstReviewTabPerReviewList.get(i+1).findElements(this.byReviewTabStarList);
            ratingNext=productResultsPage.getProductItemReviewNumberAmountFromStarImage(elementList);
            lsHeadingLineNext=this.lstReviewTabPerReviewList.get(i+1).findElement(this.byReviewTabHeadingLine).getText().trim();

            if(bHighesttRatedFirst) {
                if(ratingPrev<ratingNext) {
                    lsMsg="The Review rate of '"+lsHeadingLinePrev+"' is lower than '"+lsHeadingLineNext+"'";
                    return lsMsg;
                }
            }
            else {
                if(ratingPrev>ratingNext) {
                    lsMsg="The Review rate of '"+lsHeadingLinePrev+"' is greater than '"+lsHeadingLineNext+"'";
                    return lsMsg;
                }
            }
        }

        return lsMsg;
    }

    @Override
    public void chooseReviewSortingOption(String lsReviewSortingOption) {
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblReviewTabReviewCount);
        Select reviewSortings=new Select(this.selectReviewTabSortBy);
        reviewSortings.selectByVisibleText(lsReviewSortingOption);
        this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
    }

    @Override
    public void verifyReviewTabFooterAndBackToTopAndPagination() {
        reporter.softAssert(!this.getElementText(this.lblReviewTabDisplayingReviewMsg).isEmpty(),"The Review message in Review tab footer is not empty","The Review message in Review tab footer is empty");
        reporter.softAssert(!this.getElementHref(this.lnkReviewTabBackToTop).isEmpty(),"The BackToTop link is not empty","The BackToTop link is empty");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntReviewTabPagination),"The Review pagination section is displaying correctly","The Review pagination section is not displaying correctly");
        this.goBack();
    }

    @Override
    public void openWriteReview() {
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkReviewTabWriteReview);
        this.getReusableActionsInstance().clickIfAvailable(this.lnkReviewTabWriteReview);
        //this.lnkReviewTabWriteReview.click();
        this.getReusableActionsInstance().waitForElementVisibility(this.lblWriteReviewHeaderTitle,  60);
    }

    @Override
    public boolean IsSoldOutExisting() {
        return !this.lblSoldOut.findElement(By.xpath("./span")).getAttribute("class").contains("hidden");
    }

    @Override
    public void verifyProductSizeChangingAction() {
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblSizeStatic),"Product size title is existing","Product size title is not existing");
        reporter.softAssert(this.lstRadioSizeLabelList.size()>0,"Product size radio list is existing","Product size radio list is not existing");
        reporter.softAssert(checkProductSizingChangeAction(),"Product size changing action is working","Product size changing action is not working");
        if(IsSoldOutExisting()) {
            reporter.softAssert(!this.getElementText(this.lblSoldOut).isEmpty(),"The product Soldout message is not empty","The product Soldout message is empty");
        }

        if(checkProductSizingChartExisting()) {
            if((System.getProperty("Device").toLowerCase().contains("mobile") &&
                    System.getProperty("Browser").toLowerCase().contains("android")) ||
                    System.getProperty("Device").toLowerCase().contains("desktop") ||
                    System.getProperty("Device").toLowerCase().contains("tablet")){
                verifyProductQuantitySizingChart();
            }
        }
    }

    @Override
    public boolean checkProductSizingChartExisting() {
        for(WebElement item:this.lstStickyTabProductTabList) {
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            if(item.getText().trim().equalsIgnoreCase("SIZE CHART")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void verifyProductQuantitySizingChart() {
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkSizingChart),"The product Sizing Chart is existing","The product Sizing Chart is not existing");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkSizingChart);
        this.getReusableActionsInstance().clickIfAvailable(this.lnkSizingChart);
        //this.lnkSizingChart.click();
        this.waitForCondition(Driver->{return this.btnStickyTabSizeChart.getAttribute("class").contains("scrolling");},5000);
        reporter.softAssert(this.getStickyTabSelectedStatus(this.btnStickyTabSizeChart),"The SIZE CHART tab has been selected correctly","The SIZE CHART tab has not been selected correctly");
        this.goBack();
    }

    @Override
    public void trueFitDetails(){
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntProductTrueFitIframe),"The product TrueFit popup window is displaying","The product TrueFit popup window is not displaying");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgProductTrueFitIframeHeaderLogo),"The header icon in product TrueFit popup window is displaying","The header icon in product TrueFit popup window is not displaying");
        reporter.softAssert(!this.getElementImageSrc(this.imgProductTrueFitIframeHeaderLogo).isEmpty(),"The header icon src in product TrueFit popup window is not empty","The header icon src in product TrueFit popup window is empty");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnProductTrueFitIframeFooterGetStarted),"The GetStarted button in product TrueFit popup window is displaying","The GetStarted button in product TrueFit popup window is not displaying");
        reporter.softAssert(this.btnProductTrueFitIframeFooterGetStarted.isEnabled(),"The GetStarted button in product TrueFit popup window is enabled","The GetStarted button in product TrueFit popup window is not enabled");
    }

    @Override
    public void closeTrueFitIFrame() {
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductTrueFitIframeClose);
        this.getReusableActionsInstance().scrollToElement(this.btnProductTrueFitIframeClose);
        this.getReusableActionsInstance().clickIfAvailable(this.btnProductTrueFitIframeClose);
        //this.btnProductTrueFitIframeClose.click();
        this.getDriver().switchTo().defaultContent();
        this.waitForCondition(Driver->{return this.iframeProductTrueFitLoadingIndicator.getAttribute("style").contains("display: none");}, 30000);
    }

    @Override
    public void subTotal(){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowButtonSectionSubtotal);
        this.getReusableActionsInstance().scrollToElement(this.lblAddToBagPopupWindowButtonSectionSubtotal);
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowButtonSectionSubtotal),"The product Subtotal in Add to Bag popup window is visible","The product Subtotal in Add to Bag popup window is not visible");
        reporter.softAssert(!this.lblAddToBagPopupWindowButtonSectionSubtotal.getText().isEmpty(),"The product Subtotal in Add to Bag popup window is not empty","The product Subtotal in Add to Bag popup window is empty");
    }

    @Override
    public void verifyProductOverviewContent() {
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productOverview);
        this.getReusableActionsInstance().clickIfAvailable(this.productOverview);
        this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

        reporter.softAssert(!this.getElementText(this.btnStickyTabProductReview).isEmpty(),"The Product Overview contents is not empty","The Product Overview contents is empty");
        this.goBack();
    }

    /**
     * Method to click on back button for mobile
     * @return void
     * @author viswas.reddy
     */
    public void goBack(){
        //Due to xpath,Back button is not being clicked for ios mobile and hence using ESC key
        if(System.getProperty("Device").toLowerCase().contains("mobile") &&
                (System.getProperty("Browser").toLowerCase().contains("android") ||
                        (!"".equals(System.getProperty("chromeMobileDevice")) && !System.getProperty("chromeMobileDevice").toLowerCase().contains("iphone")))){

            this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.backButton);
            this.getReusableActionsInstance().scrollToElement(this.backButton);
            this.getReusableActionsInstance().clickIfAvailable(this.backButton);
            applyStaticWait(500);
        }else{
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.backButton);
            this.getReusableActionsInstance().scrollToElement(this.backButton);
            this.getReusableActionsInstance().clickIfAvailable(this.backButton);
            waitForCondition(Driver->{
                return this.lblProductName.isDisplayed();
            },150000);
            this.waitForPageToLoad();
        }
    }

    @Override
    public void verifyStickyTabClickingAction() {
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productOverview);
        this.getReusableActionsInstance().clickIfAvailable(this.productOverview);
        this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnStickyTabProductReview),"The Product Overview contents is displaying correctly","The Product Overview contents is not displaying correctly");
        this.goBack();

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productReview);
        this.getReusableActionsInstance().clickIfAvailable(this.productReview);
        this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnStickyTabProductReview),"The Product Overview contents is displaying correctly","The Product Overview contents is not displaying correctly");
        goBack();

        if(this.checkProductSizingChartExisting()) {
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.sizeChart);
            this.getReusableActionsInstance().clickIfAvailable(this.sizeChart);
            this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
            reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnStickyTabProductReview),"The Product Overview contents is displaying correctly","The Product Overview contents is not displaying correctly");
            goBack();
        }
    }

    @Override
    public void verifyProductSoldOut() {
        WebElement item;
        if((System.getProperty("Device").toLowerCase().contains("tablet") &&
                !System.getProperty("Browser").toLowerCase().contains("ios")) ||
                !System.getProperty("Device").toLowerCase().contains("tablet")){
            if(this.checkChildElementExistingByTagName(this.selectQuantityOption,"option")){
                int listSize = this.lstSizeOption.size();
                for(int counter=0;counter<listSize;counter++){
                    this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectSizeOption);
                    this.getReusableActionsInstance().clickIfAvailable(this.selectSizeOption);
                    this.getReusableActionsInstance().staticWait(100);
                    item=this.lstSizeOption.get(counter);
                    this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
                    item.click();
                    this.getReusableActionsInstance().staticWait(100);
                    if(!this.checkChildElementExistingByTagName(this.selectQuantityOption,"option"))
                        break;
                }
            }
            reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblSoldOut),"The Soldout message is displaying correctly","The Soldout message is not displaying correctly");
            reporter.softAssert(!this.getElementText(this.lblSoldOut).isEmpty(),"The Soldout message is not empty","The Soldout message is empty");
            reporter.softAssert(!this.judgeQuantityDropdownAvailable(),"The Quantity Dropdown is not displaying","The Quantity Dropdown is still displaying");
            reporter.softAssert(this.judgeAddToBagButtonAvailable(),"The Add to Bag button is not displaying","The Add to Bag button is still displaying");
        }
    }

    @Override
    public void verifyCurrentZoomImage() {
        reporter.softAssert(!this.getElementHref(this.lnkCurrentZoomImage).isEmpty(),"The Current zoom image link is not empty","The Current zoom image link is empty");
    }

}
