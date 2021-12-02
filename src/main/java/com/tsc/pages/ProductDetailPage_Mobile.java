package com.tsc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
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
    @FindBy(xpath = "//div[@class='modal-dialog']//div[@class='modal-header']")
    public WebElement backButton;

    //TrueFitFrame
    @FindBy(xpath = "//button[contains(@class,'tfc-cfg-close-button')][img]")
    public WebElement btnProductTrueFitIframeClose;

    //Sub total
    @FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[contains(@class,'add-to-bag__subtotal')]")
    public WebElement lblAddToBagPopupWindowButtonSectionSubtotal;

    //Sold out message
    @FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='soldoutContainerMobile']")
    public WebElement lblSoldOutMessage;

    @Override
    public void verifyVideo(String lsVideoDisclaimInfo) {
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgProductBadge),"The product badge is displaying correctly","The product badge is not displaying correctly");
        reporter.softAssert(!this.imgProductBadge.getAttribute("src").isEmpty(),"The product badge image source is not empty","The product badge image source is empty");
        this.videoIcon.click();
        applyStaticWait(500);
        this.playButton.click();
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
        reporter.softAssert(!this.lnkVideo.getAttribute("src").isEmpty(),"The product video source is not empty","The product video source is empty");

        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblVideoDisclaim),"The product video disclaim text is displaying correctly","The product video disclaim text is not displaying correctly");
        reporter.softAssert(this.getElementText(this.lblVideoDisclaim).equalsIgnoreCase(lsVideoDisclaimInfo),"The product video disclaim text is equal to the text of '"+lsVideoDisclaimInfo+"'","The product video disclaim text is not equal to the text of '"+lsVideoDisclaimInfo+"'");

        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
        //commented because autoplay is not present for both tab and mobile
        //reporter.softAssert(this.checkIfAutoPlayVideoStatusIsON(),"The product video AutoPlaying is on","The product video AutoPlaying is off");
        reporter.softAssert(this.checkIfVideoisPlaying(),"The product video is playing","The product video is not playing");

        //reporter.softAssert(!getAutoPlayVideoToolTipPopupMsg().isEmpty(),"The AutoPlayVideoToolTip is not empty","The AutoPlayVideoToolTip is empty");

    }

    @Override
    public void verifyThumbnailPrevButton() {
        String lsFirstImageSrcBefore=this.lstThumbnailImageList.get(0).findElement(By.xpath(".//img")).getAttribute("src");
        this.btnThumbnailPrev.click();
        this.getReusableActionsInstance().staticWait(300);
        String lsFirstIamgeSrcAfter=this.lstThumbnailImageList.get(0).findElement(By.xpath(".//img")).getAttribute("src");

        reporter.softAssert(!lsFirstImageSrcBefore.equalsIgnoreCase(lsFirstIamgeSrcAfter), "The Prev button clicking is working", "The Prev button clicking is not working");
    }

    @Override
    public void verifyThumbnail() {
        this.getDriver().navigate().refresh();
        this.waitForPageToLoad();
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntThumbnailContainer),"The Thumbnail section is displaying correctly","The Thumbnail section is not displaying correctly");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnThumbnailPrev),"The Thumbnail prev button is displaying correctly","The Thumbnail prev button is not displaying correctly");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnThumbnailNext),"The Thumbnail next button is displaying correctly","The Thumbnail next button is not displaying correctly");
        this.videoIcon.click();
        reporter.softAssert(!this.lnkThumbnailVideo.getAttribute("data-video").isEmpty(),"The video src is not empty","The video src is empty");
        reporter.softAssert(!this.imgThumbnailVideo.getAttribute("src").isEmpty(),"The video image is not empty","The video image is empty");
        this.verifyThumbnailImageListSrc();
        this.verifyThumbnailPrevButton();
        this.verifyThumbnailNextButton();
    }

    @Override
    public void verifyThumbnailNextButton() {
        int imageCount=this.lstThumbnailImageList.size();
        String lsLastImageSrcBefore=this.lstThumbnailImageList.get(imageCount-1).findElement(By.xpath(".//img")).getAttribute("src");
        this.btnThumbnailPrev.click();
        this.getReusableActionsInstance().staticWait(300);
        String lsLastIamgeSrcAfter=this.lstThumbnailImageList.get(imageCount-1).findElement(By.xpath(".//img")).getAttribute("src");

        reporter.softAssert(!lsLastImageSrcBefore.equalsIgnoreCase(lsLastIamgeSrcAfter), "The Next button clicking is working", "The Next button clicking is not working");
    }

    @Override
    public boolean goToProductReviewTab() {
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productReviewSection);
        this.productReviewSection.click();
        return this.waitForCondition(Driver->{return this.btnStickyTabProductReview.getAttribute("class").contains("scrolling");},30000);
    }

    @Override
    public boolean getStickyTabSelectedStatus(WebElement btnTab) {
        return btnTab.getAttribute("class").contains("scrolling");
    }

    @Override
    public void verifyReviewTabContent() {
        //super.verifyReviewTabContent();
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
        //super.verifyReviewTabPerReviewListContents();
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
        //return super.checkReviewRateSortingBy(bHighesttRatedFirst);
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
        //super.chooseReviewSortingOption(lsReviewSortingOption);
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblReviewTabReviewCount);
        Select reviewSortings=new Select(this.selectReviewTabSortBy);
        reviewSortings.selectByVisibleText(lsReviewSortingOption);
        this.getReusableActionsInstance().staticWait(1000);
    }

    @Override
    public void verifyReviewTabFooterAndBackToTopAndPagination() {
        //super.verifyReviewTabFooterAndBackToTopAndPagination();
        reporter.softAssert(!this.getElementText(this.lblReviewTabDisplayingReviewMsg).isEmpty(),"The Review message in Review tab footer is not empty","The Review message in Review tab footer is empty");
        reporter.softAssert(!this.getElementHref(this.lnkReviewTabBackToTop).isEmpty(),"The BackToTop link is not empty","The BackToTop link is empty");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntReviewTabPagination),"The Review pagination section is displaying correctly","The Review pagination section is not displaying correctly");
    }

    @Override
    public boolean IsSoldOutExisting() {
        return !this.lblSoldOut.findElement(By.xpath("./span")).getAttribute("class").contains("hidden");
    }

    @Override
    public void verifyProductSizeDropdown() {
        //super.verifyProductSizeDropdown();
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblSizeStatic),"Product size title is existing","Product size title is not existing");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.selectSizeOption),"Product size dropdown is existing","Product size dropdown is not existing");
        reporter.softAssert(checkProductSizingDrodownOptionChangeAction(),"Product size dropdown action is working","Product size dropdown action is not working");
        if(IsSoldOutExisting()) {
            reporter.softAssert(!this.getElementText(this.lblSoldOut).isEmpty(),"The product Soldout message is not empty","The product Soldout message is empty");
        }

        if(checkProductSizingChartExisting()) {
            verifyProductQuantitySizingChart();
        }
    }

    @Override
    public boolean checkProductSizingChartExisting() {
        //return super.checkProductSizingChartExisting();
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
        //super.verifyProductQuantitySizingChart();
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkSizingChart),"The product Sizing Chart is existing","The product Sizing Chart is not existing");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkSizingChart);
        this.lnkSizingChart.click();
        this.waitForCondition(Driver->{return this.btnStickyTabSizeChart.getAttribute("class").contains("scrolling");},5000);
        reporter.softAssert(this.getStickyTabSelectedStatus(this.btnStickyTabSizeChart),"The SIZE CHART tab has been selected correctly","The SIZE CHART tab has not been selected correctly");
        this.backButton.click();
    }

    @Override
    public void closeTrueFitIFrame() {
        //super.closeTrueFitIFrame();
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductTrueFitIframeClose);
        this.btnProductTrueFitIframeClose.click();
        this.getDriver().switchTo().defaultContent();
        this.waitForCondition(Driver->{return this.iframeProductTrueFitLoadingIndicator.getAttribute("style").contains("display: none");}, 30000);
    }

    /*@Override
    public void verifyProductDetailsInAddToBagPopupWindow(String lbl_AddToBagPopupWindowTitle){
        super.verifyProductDetailsInAddToBagPopupWindow(lbl_AddToBagPopupWindowTitle);
        *//*openAddToBagPopupWindow();

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowTitle);
        reporter.softAssert(this.lblAddToBagPopupWindowTitle.getText().equalsIgnoreCase(lbl_AddToBagPopupWindowTitle),"The title of Add to Bag popup window is equal to '"+lbl_AddToBagPopupWindowTitle+"'","The title of Add to Bag popup window is not equal to '"+lbl_AddToBagPopupWindowTitle+"'");

        if(checkProductBadgeInAddToBagPopupDisplaying()) {
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.imgAddToBagPopupWindowDetailsProductBadge);
            reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgAddToBagPopupWindowDetailsProductBadge),"The Badge in Add to Bag popup window is visible","The Badge in Add to Bag popup window is not visible");
            reporter.softAssert(!this.imgAddToBagPopupWindowDetailsProductBadge.getAttribute("src").isEmpty(),"The Badge image src in Add to Bag popup window is not empty","The Badge image src in Add to Bag popup window is empty");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkAddToBagPopupWindowDetailsProductImage);
        reporter.softAssert(!this.lnkAddToBagPopupWindowDetailsProductImage.getAttribute("href").isEmpty(),"The product image link in Add to Bag popup window is not empty","The product image link in Add to Bag popup window is empty");
        reporter.softAssert(!this.imgAddToBagPopupWindowDetailsProductImage.getAttribute("src").isEmpty(),"The product image src in Add to Bag popup window is not empty","The product image src in Add to Bag popup window is empty");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgAddToBagPopupWindowDetailsProductImage),"The product image in Add to Bag popup window is visible","The product image in Add to Bag popup window is not visible");

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowDetailsProductName);
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowDetailsProductName),"The product name in Add to Bag popup window is visible","The product name in Add to Bag popup window is not visible");
        reporter.softAssert(!this.lblAddToBagPopupWindowDetailsProductName.getText().isEmpty(),"The product name in Add to Bag popup window is not empty","The product name in Add to Bag popup window is empty");

        if(checkProductSyleInAddToBagPopupDisplaying()) {
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowDetailsProductStyle);
            reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowDetailsProductStyle),"The product Style in Add to Bag popup window is visible","The product Style in Add to Bag popup window is not visible");
            reporter.softAssert(!this.lblAddToBagPopupWindowDetailsProductStyle.getText().isEmpty(),"The product Style in Add to Bag popup window is not empty","The product Style in Add to Bag popup window is empty");
        }

        if(checkProductSizeInAddToBagPopupDisplaying()) {
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowDetailsProductSize);
            reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowDetailsProductSize),"The product Size in Add to Bag popup window is visible","The product Size in Add to Bag popup window is not visible");
            reporter.softAssert(!this.lblAddToBagPopupWindowDetailsProductSize.getText().isEmpty(),"The product Size in Add to Bag popup window is not empty","The product Size in Add to Bag popup window is empty");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowDetailsProductNumber);
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowDetailsProductNumber),"The product Number in Add to Bag popup window is visible","The product Number in Add to Bag popup window is not visible");
        reporter.softAssert(!this.lblAddToBagPopupWindowDetailsProductNumber.getText().isEmpty(),"The product Number in Add to Bag popup window is not empty","The product Number in Add to Bag popup window is empty");

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowButtonSectionSubtotal);
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowButtonSectionSubtotal),"The product Subtotal in Add to Bag popup window is visible","The product Subtotal in Add to Bag popup window is not visible");
        reporter.softAssert(!this.lblAddToBagPopupWindowButtonSectionSubtotal.getText().isEmpty(),"The product Subtotal in Add to Bag popup window is not empty","The product Subtotal in Add to Bag popup window is empty");

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowButtonSectionCheckOut);
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnAddToBagPopupWindowButtonSectionCheckOut),"The CheckOut button in Add to Bag popup window is visible","The CheckOut button in Add to Bag popup window is not visible");
        reporter.softAssert(!this.btnAddToBagPopupWindowButtonSectionCheckOut.getText().isEmpty(),"The CheckOut button in Add to Bag popup window is not empty","The CheckOut button in Add to Bag popup window is empty");

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowButtonSectionViewShoppingBag);
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnAddToBagPopupWindowButtonSectionViewShoppingBag),"The ViewShoppingBag button in Add to Bag popup window is visible","The ViewShoppingBag button in Add to Bag popup window is not visible");
        reporter.softAssert(!this.btnAddToBagPopupWindowButtonSectionViewShoppingBag.getText().isEmpty(),"The ViewShoppingBag button in Add to Bag popup window is not empty","The ViewShoppingBag button in Add to Bag popup window is empty");

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowFooterInfo);
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowFooterInfo),"The Footer info in Add to Bag popup window is visible","The Footer info in Add to Bag popup window is not visible");
        reporter.softAssert(!this.lblAddToBagPopupWindowFooterInfo.getText().isEmpty(),"The Footer info in Add to Bag popup window is not empty","The Footer info in Add to Bag popup window is empty");

        closeAddToBagPopupWindow();*//*
    }*/
    @Override
    public void addToBagPopupWindowSubtotal(){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowButtonSectionSubtotal);
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowButtonSectionSubtotal),"The product Subtotal in Add to Bag popup window is visible","The product Subtotal in Add to Bag popup window is not visible");
        reporter.softAssert(!this.lblAddToBagPopupWindowButtonSectionSubtotal.getText().isEmpty(),"The product Subtotal in Add to Bag popup window is not empty","The product Subtotal in Add to Bag popup window is empty");
    }

    @Override
    public void verifyProductSoldOut() {
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblSoldOutMessage),"The Soldout message is displaying correctly","The Soldout message is not displaying correctly");
        reporter.softAssert(!this.getElementText(this.lblSoldOutMessage).isEmpty(),"The Soldout message is not empty","The Soldout message is empty");
        reporter.softAssert(this.judgeQuantityDropdownAvailable(),"The Quantity Dropdown is not displaying","The Quantity Dropdown is still displaying");
        reporter.softAssert(!this.judgeAddToBagButtonAvailable(),"The Add to Bag button is not displaying","The Add to Bag button is still displaying");
    }

    @Override
    public void verifyCurrentZoomImage() {
        reporter.softAssert(!this.getElementHref(this.lnkCurrentZoomImage).isEmpty(),"The Current zoom image link is not empty","The Current zoom image link is empty");
        //commented because lblZoomImageMessage is not present for both tab and mobile
        //reporter.softAssert(!this.getElementText(this.lblZoomImageMessage).isEmpty(),"The Zoom image message is not empty","The Zoom image message is empty");
    }

}
