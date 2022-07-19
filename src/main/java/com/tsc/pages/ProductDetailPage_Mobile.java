package com.tsc.pages;

import com.tsc.api.pojo.SelectedProduct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class ProductDetailPage_Mobile extends ProductDetailPage{

    public ProductDetailPage_Mobile(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__inside-right']//div[contains(@class,'add-to-bag__subtotal')]")
    public WebElement lblAddToBagPopupWindowButtonSectionSubtotal;

    @Override
    public void verifyVideo(String lsVideoDisclaimInfo) {
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkVideo),"The product video is displaying correctly","The product video is not displaying correctly");

        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblVideoDisclaim),"The product video disclaim text is displaying correctly","The product video disclaim text is not displaying correctly");
        reporter.softAssert(this.getElementText(this.lblVideoDisclaim).equalsIgnoreCase(lsVideoDisclaimInfo),"The product video disclaim text is equal to the text of '"+lsVideoDisclaimInfo+"'","The product video disclaim text is not equal to the text of '"+lsVideoDisclaimInfo+"'");

        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
        reporter.softAssert(this.checkIfAutoPlayVideoStatusIsON(),"The product video AutoPlaying is on","The product video AutoPlaying is off");

        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntThumbnailContainer),"The Thumbnail section is displaying correctly","The Thumbnail section is not displaying correctly");
        for(WebElement item:this.lstThumbnailVideoLink){
            reporter.softAssert(!item.getAttribute("data-video").isEmpty(),"The video src is not empty","The video src is empty");
        }

        for(WebElement item:this.lstThumbnailVideoImage){
            reporter.softAssert(item.getAttribute("src").contains("videoBtn.jpg"),"The video image is displaying correctly","The video image is not displaying correctly");
        }
    }

    @Override
    public String getAutoPlayVideoToolTipPopupMsg() {
        return null;
    }

    @Override
    public void verifyVideoOff() {

    }

    @Override
    public int getOrderAmountFromSubTotalInAddToBagModel(){
        String lsText=this.getElementInnerText(lblAddToBagPopupWindowButtonSectionSubtotal);
        lsText=lsText.split(":")[0];

        return this.getIntegerFromString(lsText);
    }

    @Override
    public float getOrderSubTotalInAddToBagModel(){
        String lsText=this.getElementInnerText(lblAddToBagPopupWindowButtonSectionSubtotal);
        lsText=lsText.split(":")[1];

        return this.getFloatFromString(lsText,true);
    }

    @Override
    public void subTotal(){
       reporter.softAssert(!this.getElementInnerText(lblAddToBagPopupWindowButtonSectionSubtotal).isEmpty(),"The product Subtotal in Add to Bag popup window is not empty","The product Subtotal in Add to Bag popup window is empty");
    }

    @Override
    public Map<String,Object> verifyProductDetailsInAddToBagPopupWindow(String lbl_AddToBagPopupWindowTitle, SelectedProduct productItem){
        openAddToBagPopupWindow();

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowTitle);
        reporter.softAssert(this.lblAddToBagPopupWindowTitle.getText().toUpperCase().matches(lbl_AddToBagPopupWindowTitle),"The title of Add to Bag popup window is matching to '"+lbl_AddToBagPopupWindowTitle+"' pattern","The title of Add to Bag popup window is not matching to '"+lbl_AddToBagPopupWindowTitle+"' pattern");

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
        //commented below line because of the new havas changes where PRP is changed
        //reporter.softAssert(this.lblAddToBagPopupWindowDetailsProductName.getText().trim().equalsIgnoreCase(productItem.productName),"The product name in Add to Bag popup window is equal to the original product name from product search result page","The product name in Add to Bag popup window is not equal to the original product name from product search result page");

        if(checkProductStyleInAddToBagPopupDisplaying()) {
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

        //commented below line because of the havas changes where PRP is changed
        //reporter.softAssert(this.lblAddToBagPopupWindowDetailsProductNumber.getText().trim().equalsIgnoreCase(productItem.productNumber),"The product number in Add to Bag popup window is equal to the original product number from product search result page","The product number in Add to Bag popup window is not equal to the original product number from product search result page");

        subTotal();

        reporter.softAssert(this.lblAddToBagPopupWindowDetailsProductNumber.getText().trim().replace("-", "").equalsIgnoreCase(productItem.productNumber),"The product number of "+this.lblAddToBagPopupWindowDetailsProductNumber.getText().trim().replace("-", "")+" in Add to Bag popup window is equal to the original product number of "+productItem.productNumber+" from product search result page","The product number of "+this.lblAddToBagPopupWindowDetailsProductNumber.getText().trim().replace("-", "")+" in Add to Bag popup window is not equal to the original product number of "+productItem.productNumber+" from product search result page");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowButtonSectionCheckOut);
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnAddToBagPopupWindowButtonSectionCheckOut),"The CheckOut button in Add to Bag popup window is visible","The CheckOut button in Add to Bag popup window is not visible");
        reporter.softAssert(!this.btnAddToBagPopupWindowButtonSectionCheckOut.getText().isEmpty(),"The CheckOut button in Add to Bag popup window is not empty","The CheckOut button in Add to Bag popup window is empty");

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowButtonSectionViewShoppingBag);
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnAddToBagPopupWindowButtonSectionViewShoppingBag),"The ViewShoppingBag button in Add to Bag popup window is visible","The ViewShoppingBag button in Add to Bag popup window is not visible");
        reporter.softAssert(!this.btnAddToBagPopupWindowButtonSectionViewShoppingBag.getText().isEmpty(),"The ViewShoppingBag button in Add to Bag popup window is not empty","The ViewShoppingBag button in Add to Bag popup window is empty");

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowFooterInfo);
        reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowFooterInfo),"The Footer info in Add to Bag popup window is visible","The Footer info in Add to Bag popup window is not visible");
        reporter.softAssert(!this.lblAddToBagPopupWindowFooterInfo.getText().isEmpty(),"The Footer info in Add to Bag popup window is not empty","The Footer info in Add to Bag popup window is empty");

        Map<String,Object> map=this.getAddToBagDesc();

        closeAddToBagPopupWindow();
        return map;
    }

    @Override
    public void verifyZoomingImageAction(){
        if(System.getProperty("Browser").contains("ios") || System.getProperty("Browser").contains("android")) {
            reporter.reportLog("Simulator is not supporting zoom out by clicking image");
            return;
        }

        WebElement item=lstThumbnailImageButtonWithoutVideoList.get(0);
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
        item.click();
        this.applyStaticWait(2*this.getStaticWaitForApplication());

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCurrentZoomImage);
        lnkCurrentZoomImage.click();
        this.applyStaticWait(2*this.getStaticWaitForApplication());
        if(checkImageZoomingStatus()){
            reporter.reportLogPass("Zooming out action is working");
        }
        else{
            reporter.reportLogFailWithScreenshot("Zooming out action is not working");
        }

        this.getReusableActionsInstance().staticWait(3*this.getStaticWaitForApplication());

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCurrentZoomImage);
        lnkCurrentZoomImage.click();
        this.applyStaticWait(2*this.getStaticWaitForApplication());
        if(!checkImageZoomingStatus()){
            reporter.reportLogPass("Zooming in action is working");
        }
        else{
            reporter.reportLogFailWithScreenshot("Zooming in action is not working");
        }
    }

}
