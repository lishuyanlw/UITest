package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderTrackingPage extends BasePage {

    public OrderTrackingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='trackorder']//h1[@class='trackorder__title']")
    public WebElement lblTrackOrderTitle;

    @FindBy(xpath = "//div[@id='trackorder']//h4[@class='order-number']")
    public WebElement lblTrackOrderNumber;

    //For track order estimate
    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='estimate']//h2[@class='box__title']")
    public WebElement lblTrackOrderEstimatedDeliveryDateTitle;

    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='estimate']//div[@class='delivery__day']")
    public WebElement lblTrackOrderEstimatedDeliveryWeekDay;

    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='estimate']//div[@class='delivery__month']")
    public WebElement lblTrackOrderEstimatesDeliveryMonth;

    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='estimate']//div[@class='delivery__date']")
    public WebElement lblTrackOrderEstimatedDeliveryDate;

    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='estimate']//div[@class='days-until']")
    public WebElement lblTrackOrderEstimatedDeliveryDaysUntil;

    //For track order status
    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='status']//h2[@class='box__title']")
    public WebElement lblTrackOrderDeliveryStatusTitle;

    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='status']//h3[@class='progressbar__title']")
    public WebElement lblTrackOrderDeliveryStatusProgressBarTitle;

    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='status']//div[@class='progressbar__container']//span[@class='progressbar__step']//img")
    public List<WebElement> lstTrackOrderDeliveryStatusProgressBar;

    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='status']//div[@class='delivery-list__label']")
    public WebElement lblTrackOrderDeliveryStatusPlaceOrderDate;

    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='status']//div[@class='delivery-list__value']")
    public WebElement lblTrackOrderDeliveryStatusPlaceOrderStatus;

    //For track order items
    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='items']//h2[@class='box__title']")
    public WebElement lblTrackOrderDeliveryItemsTitle;

    @FindBy(xpath = "//div[@id='trackorder']//div[@class='track-detail']//div[@class='items']//div[@class='productlist']")
    public List<WebElement> lstTrackOrderDeliveryItems;

    public By byProductLink=By.xpath(".//div[@class='productlist__left']//a");
    public By byProductImage=By.xpath(".//div[@class='productlist__left']//a//img");
    public By byProductDescription=By.xpath(".//div[@class='productlist__right']//div[@class='productlist__description']//a");
    public By byProductNumberContainer=By.xpath(".//div[@class='productlist__right']");
    public By byProductNumber=By.xpath(".//div[@class='productlist__right']//div[@class='productlist__itemnumber']");
    public By byProductQuantity=By.xpath(".//div[@class='productlist__left--qty']");

    /**
     * To check Product Number Existing
     * @param - WebElement - trackOrderItem
     * @return - boolean
     */
    public boolean checkProductNumberExisting(WebElement trackOrderItem){
        WebElement item=trackOrderItem.findElement(byProductNumberContainer);
        return this.checkChildElementExistingByAttribute(item,"class","productlist__itemnumber");
    }

    /**
     * To get Order Tracking Number
     * @return -String - Order Tracking Number
     */
    public String getOrderTrackingNumber(){
        return this.getElementInnerText(lblTrackOrderNumber).split(":")[1].trim();
    }

    /**
     * To check ProgressBar Item Status
     * @param - WebElement - progressBarItem
     * @return - boolean - true for checked
     */
    public boolean checkProgressBarItemStatus(WebElement progressBarItem){
        return progressBarItem.getAttribute("src").contains("checkmark.png");
    }

    /**
     * To get Order item Description
     * @param - WebElement - trackOrderItem in lstTrackOrderDeliveryItems
     * @return - Map<String,Object>
     */
    public Map<String,Object> getOrderItemDesc(WebElement trackOrderItem){
        Map<String,Object> map=new HashMap<>();
        WebElement item;
        String lsText;
        String[] splitString;

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(trackOrderItem);
        item = trackOrderItem.findElement(byProductDescription);
        lsText = this.getElementInnerText(item);
        map.put("productDescription", lsText);

        if (!lsText.contains("|")) {
            map.put("productName", lsText);
        } else {
            splitString = lsText.split("\\|");
            map.put("productName", splitString[0].trim());
            if (splitString.length == 3) {
                map.put("productStyle", splitString[1].trim());
                map.put("productSize", splitString[2].trim());
            }
            else{
                map.put("productStyle", splitString[1].trim());
                map.put("productSize", splitString[1].trim());
            }
        }

        if(this.checkProductNumberExisting(trackOrderItem)){
            item = trackOrderItem.findElement(byProductNumber);
            lsText = this.getElementInnerText(item).replace("-", "").trim();
            map.put("productNumber", lsText);
        }
        else{
            map.put("productNumber", null);
        }

        item = trackOrderItem.findElement(byProductQuantity);
        lsText = this.getElementInnerText(item);
        map.put("productQuantity", this.getIntegerFromString(lsText));

        return map;
    }

    /**
     * To get Order List Description
     * @return - List<Map<String,Object>>
     */
    public List<Map<String,Object>> getOrderListDesc(){
        List<Map<String,Object>> mapList= new ArrayList<>();
        for(WebElement trackOrderItem:lstTrackOrderDeliveryItems) {
            mapList.add(getOrderItemDesc(trackOrderItem));

        }
        return mapList;
    }

    /**
     * To get Order Item Count
     * @param - List<Map<String,Object>> - productList - order product list
     * @return - int
     */
    public int getOrderItemCount(List<Map<String,Object>> productList){
        Map<String,Object> map=new HashMap<>();

        int totalCount=0,itemQuantity;
        for(Map<String,Object> productItem:productList){
            itemQuantity= (int) productItem.get("productQuantity");
            totalCount+=itemQuantity;
        }

        return totalCount;
    }

    /**
     * To verify Order Tracking Header Section
     */
    public void verifyOrderTrackingHeaderSection() {
        String lsText;

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderTitle);
        lsText = lblTrackOrderTitle.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The order tracking header title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The order tracking header title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderNumber);
        lsText = lblTrackOrderNumber.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The order tracking number info is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The order tracking number info is not displaying correctly");
        }
    }

    /**
     * To verify Order Tracking delivery Estimate Date Section
     */
    public void verifyOrderTrackingDeliveryEstimateDateSection() {
        String lsText;

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderEstimatedDeliveryDateTitle);
        lsText = lblTrackOrderEstimatedDeliveryDateTitle.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The order tracking delivery estimate date title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The order tracking delivery estimate date title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderEstimatedDeliveryWeekDay);
        lsText = lblTrackOrderEstimatedDeliveryWeekDay.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The order tracking delivery weekday is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The order tracking delivery weekday is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderEstimatesDeliveryMonth);
        lsText = lblTrackOrderEstimatesDeliveryMonth.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The order tracking delivery month is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The order tracking delivery month is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderEstimatedDeliveryDate);
        lsText = lblTrackOrderEstimatedDeliveryDate.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The order tracking delivery date is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The order tracking delivery date is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderEstimatedDeliveryDaysUntil);
        lsText = lblTrackOrderEstimatedDeliveryDaysUntil.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The order tracking delivery day until info is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The order tracking delivery day until info is not displaying correctly");
        }
    }

    /**
     * To verify Order Tracking Status Section
     */
    public void verifyOrderTrackingStatusSection() {
        String lsText;

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderDeliveryStatusTitle);
        lsText = lblTrackOrderDeliveryStatusTitle.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The order tracking delivery status title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The order tracking delivery status title is not displaying correctly");
        }

        for(WebElement progressBar:lstTrackOrderDeliveryStatusProgressBar){
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(progressBar);
            if(!progressBar.getAttribute("src").isEmpty()){
                reporter.reportLogPass("The progress bar image source is not empty");
            }
            else{
                reporter.reportLogPassWithScreenshot("The progress bar image source is empty");
            }
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderDeliveryStatusPlaceOrderDate);
        lsText = lblTrackOrderDeliveryStatusPlaceOrderDate.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The place order date of order tracking delivery status is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The place order date of order tracking delivery status is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderDeliveryStatusPlaceOrderStatus);
        lsText = lblTrackOrderDeliveryStatusPlaceOrderStatus.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The place order status of order tracking delivery status is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The place order status of order tracking delivery status is not displaying correctly");
        }
    }

    /**
     * To verify Order Tracking items Section
     */
    public void verifyOrderTrackingItemsSection() {
        String lsText;

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderDeliveryItemsTitle);
        lsText = lblTrackOrderDeliveryItemsTitle.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The order tracking items title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The order tracking items title is not displaying correctly");
        }

        WebElement item;
        for (WebElement productItem : this.lstTrackOrderDeliveryItems) {
            item = productItem.findElement(this.byProductLink);
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            lsText=item.getAttribute("href");
            if (!lsText.isEmpty()) {
                reporter.reportLogPass("The product link is not empty");
            } else {
                reporter.reportLogFailWithScreenshot("The product link is not empty");
            }

            item = productItem.findElement(this.byProductImage);
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            lsText=item.getAttribute("src");
            if (!lsText.isEmpty()) {
                reporter.reportLogPass("The product image source is not empty");
            } else {
                reporter.reportLogFailWithScreenshot("The product image source is not empty");
            }

            item = productItem.findElement(byProductDescription);
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            lsText = item.getText().trim();
            if (!lsText.isEmpty()) {
                reporter.reportLogPass("The product description is displaying correctly");
            } else {
                reporter.reportLogFailWithScreenshot("The product description is not displaying correctly");
            }

            if(this.checkProductNumberExisting(productItem)){
                item = productItem.findElement(byProductNumber);
                this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
                lsText = item.getText().replace("-", "").trim();
                if (!lsText.isEmpty()) {
                    reporter.reportLogPass("The product number is displaying correctly");
                } else {
                    reporter.reportLogFailWithScreenshot("The product number is not displaying correctly");
                }
            }

            item = productItem.findElement(byProductQuantity);
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            lsText = item.getText().trim();
            if (!lsText.isEmpty()) {
                reporter.reportLogPass("The product quantity is displaying correctly");
            } else {
                reporter.reportLogFailWithScreenshot("The product quantity is not displaying correctly");
            }
        }
    }

    /**
     * To verify Order List Linkage Between Order details Page And order tracking Page
     * @param - List<Map<String,Object>> - orderListMapForOrderDetails
     * @param - List<Map<String,Object>> - orderListMapForOrderTracking
     */
    public void verifyOrderListLinkageBetweenOrderDetailsPageAndOrderTrackingPage(List<Map<String,Object>> orderListMapForOrderDetails,List<Map<String,Object>> orderListMapForOrderTracking){
        int findIndex;
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage(this.getDriver());
        Map<String,Object> orderDetailsItem;
        for(Map<String,Object> orderTrackingItem:orderListMapForOrderTracking){
            String lsText=(String)orderTrackingItem.get("productName");
            reporter.reportLog("Verify product:'"+lsText+"'");
            findIndex=shoppingCartPage.findGivenProductIndexInProductList(orderTrackingItem,orderListMapForOrderDetails);
            if(findIndex!=-1){
                orderDetailsItem=orderListMapForOrderDetails.get(findIndex);
                this.verifyProductItemLinkageBetweenOrderDetailsPageAndOrderTrackingPage(orderDetailsItem,orderTrackingItem);
            }
            else{
                reporter.reportLogFail("Unable to find '"+lsText+"' in orderDetails Page");
            }
        }
    }

    /**
     * To verify product list Linkage Between OrderTracking Page And orderDetails Page
     * @param - Map<String,Object> - orderTrackingItem
     * @param - Map<String,Object> - orderDetailsItem
     */
    public void verifyProductItemLinkageBetweenOrderDetailsPageAndOrderTrackingPage(Map<String,Object> orderDetailsItem,Map<String,Object> orderTrackingItem){
        String lsOrderTrackingText,lsOrderDetailsText;

        lsOrderTrackingText=(String)orderTrackingItem.get("productName");
        lsOrderDetailsText=(String)orderDetailsItem.get("productName");
        if(lsOrderTrackingText.equalsIgnoreCase(lsOrderDetailsText)){
            reporter.reportLogPass("The productName in OrderTracking Item is the same as the one in orderDetails Item");
        }
        else{
            reporter.reportLogFail("The productName:"+lsOrderTrackingText+" in OrderTracking Item is not the same as the one:"+lsOrderDetailsText+" in orderDetails Item");
        }

        lsOrderTrackingText=(String)orderTrackingItem.get("productStyle");
        lsOrderDetailsText=(String)orderDetailsItem.get("productStyle");
        if(lsOrderTrackingText==null){
            if(lsOrderDetailsText==null){
                reporter.reportLogPass("The productStyle in OrderTracking Item is the same as the one in orderDetails Item");
            }
            else{
                reporter.reportLogFail("The productStyle in OrderTracking Item is not the same as the one in orderDetails Item");
            }
        }
        else{
            if(lsOrderTrackingText.equalsIgnoreCase(lsOrderDetailsText)){
                reporter.reportLogPass("The productStyle in OrderTracking Item is the same as the one in orderDetails Item");
            }
            else{
                reporter.reportLogFail("The productStyle:"+lsOrderTrackingText+" in OrderTracking Item is not the same as the one:"+lsOrderDetailsText+" in orderDetails Item");
            }
        }

        lsOrderTrackingText=(String)orderTrackingItem.get("productSize");
        lsOrderDetailsText=(String)orderDetailsItem.get("productSize");
        if(lsOrderTrackingText==null){
            if(lsOrderDetailsText==null){
                reporter.reportLogPass("The productSize in OrderTracking Item is the same as the one in orderDetails Item");
            }
            else{
                reporter.reportLogFail("The productSize in OrderTracking Item is not the same as the one in orderDetails Item");
            }
        }
        else{
            if(lsOrderTrackingText.equalsIgnoreCase(lsOrderDetailsText)){
                reporter.reportLogPass("The productSize in OrderTracking Item is the same as the one in orderDetails Item");
            }
            else{
                reporter.reportLogFail("The productSize:"+lsOrderTrackingText+" in OrderTracking Item is not the same as the one:"+lsOrderDetailsText+" in orderDetails Item");
            }
        }

        lsOrderTrackingText=(String)orderTrackingItem.get("productNumber");
        lsOrderDetailsText=(String)orderDetailsItem.get("productNumber");
        if(lsOrderTrackingText==null){
            if(lsOrderDetailsText==null){
                reporter.reportLogPass("The productNumber in OrderTracking Item is the same as the one in orderDetails Item");
            }
            else{
                reporter.reportLogFail("The productNumber in OrderTracking Item is not the same as the one in orderDetails Item");
            }
        }
        else{
            if(lsOrderTrackingText.equalsIgnoreCase(lsOrderDetailsText)){
                reporter.reportLogPass("The productNumber in OrderTracking Item is the same as the one in orderDetails Item");
            }
            else{
                reporter.reportLogFail("The productNumber:"+lsOrderTrackingText+" in OrderTracking Item is not the same as the one:"+lsOrderDetailsText+" in orderDetails Item");
            }
        }

        int orderTrackingQuantity=(int)orderTrackingItem.get("productQuantity");
        int orderDetailsQuantity=(int)orderDetailsItem.get("productQuantity");
        if(orderTrackingQuantity==orderDetailsQuantity){
            reporter.reportLogPass("The productQuantity in OrderTracking Item is the same as the one in checkout Item");
        }
        else{
            reporter.reportLogFail("The productQuantity:"+orderTrackingQuantity+" in OrderTracking Item is not the same as the one:"+orderDetailsQuantity+" in orderDetails Item");
        }
    }



}
