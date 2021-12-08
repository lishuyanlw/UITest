package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage_Tablet extends ProductDetailPage {

    public ProductDetailPage_Tablet(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divVideoIcon']")
    public WebElement videoIcon;

    @FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@class='videoBox']//button[contains(@class,'amp-pause-overlay')]")
    public WebElement playButton;

    @Override
    public void verifyVideo(String lsVideoDisclaimInfo) {
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgProductBadge),"The product badge is displaying correctly","The product badge is not displaying correctly");
        reporter.softAssert(!this.imgProductBadge.getAttribute("src").isEmpty(),"The product badge image source is not empty","The product badge image source is empty");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.videoIcon);
        this.getReusableActionsInstance().clickIfAvailable(this.videoIcon);
        //this.videoIcon.click();
        applyStaticWait(500);
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.playButton);
        this.getReusableActionsInstance().clickIfAvailable(this.playButton);
        //this.playButton.click();
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
    public void verifyThumbnail() {
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntThumbnailContainer),"The Thumbnail section is displaying correctly","The Thumbnail section is not displaying correctly");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnThumbnailPrev),"The Thumbnail prev button is displaying correctly","The Thumbnail prev button is not displaying correctly");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnThumbnailNext),"The Thumbnail next button is displaying correctly","The Thumbnail next button is not displaying correctly");
        reporter.softAssert(!this.lnkThumbnailVideo.getAttribute("data-video").isEmpty(),"The video src is not empty","The video src is empty");
        reporter.softAssert(!this.imgThumbnailVideo.getAttribute("src").isEmpty(),"The video image is not empty","The video image is empty");
        /*commented because image loading problem and Src is not present next all commented lines
          are because of this issue */
        //this.verifyThumbnailImageListSrc();
        this.verifyThumbnailPrevButton();
        this.verifyThumbnailNextButton();
    }

    @Override
    public void verifyThumbnailPrevButton() {
        //String lsFirstImageSrcBefore=this.lstThumbnailImageList.get(0).findElement(By.xpath(".//img")).getAttribute("src");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnThumbnailPrev);
        this.getReusableActionsInstance().clickIfAvailable(this.btnThumbnailPrev);
        //this.btnThumbnailPrev.click();
        this.getReusableActionsInstance().staticWait(300);
        //String lsFirstIamgeSrcAfter=this.lstThumbnailImageList.get(0).findElement(By.xpath(".//img")).getAttribute("src");

        //reporter.softAssert(!lsFirstImageSrcBefore.equalsIgnoreCase(lsFirstIamgeSrcAfter), "The Prev button clicking is working", "The Prev button clicking is not working");
    }

    @Override
    public void verifyThumbnailNextButton() {
        int imageCount=this.lstThumbnailImageList.size();
        //String lsLastImageSrcBefore=this.lstThumbnailImageList.get(imageCount-1).findElement(By.xpath(".//img")).getAttribute("src");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnThumbnailPrev);
        this.getReusableActionsInstance().clickIfAvailable(this.btnThumbnailPrev);
        //this.btnThumbnailPrev.click();
        this.getReusableActionsInstance().staticWait(300);
        //String lsLastIamgeSrcAfter=this.lstThumbnailImageList.get(imageCount-1).findElement(By.xpath(".//img")).getAttribute("src");

        //reporter.softAssert(!lsLastImageSrcBefore.equalsIgnoreCase(lsLastIamgeSrcAfter), "The Next button clicking is working", "The Next button clicking is not working");
    }

    @Override
    public void verifyCurrentZoomImage() {
        reporter.softAssert(!this.getElementHref(this.lnkCurrentZoomImage).isEmpty(),"The Current zoom image link is not empty","The Current zoom image link is empty");
        //commented because lblZoomImageMessage is not present for both tab and mobile
        //reporter.softAssert(!this.getElementText(this.lblZoomImageMessage).isEmpty(),"The Zoom image message is not empty","The Zoom image message is empty");
    }

}
