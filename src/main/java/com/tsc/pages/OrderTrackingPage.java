package com.tsc.pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.ApiResponse;
import com.tsc.api.apiBuilder.OrderAPI;
import com.tsc.api.pojo.DetailedOrderSummary;
import com.tsc.api.pojo.OrderListResponse;
import com.tsc.api.pojo.OrderSummary;
import com.tsc.api.util.JsonParser;
import com.tsc.pages.base.BasePage;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class OrderTrackingPage extends BasePage {

    public OrderTrackingPage(WebDriver driver) {
        super(driver);
    }

    ////////////////////////////////////////
    //For order tracking portal
    @FindBy(xpath = "//div[@class='TrackOrder']//h1[@class='step1__title']")
    public WebElement lblTrackOrderPortalTitle;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='required-fields']")
    public WebElement lblTrackOrderPortalRequiredFields;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='order-lookup__wrap']//h2")
    public WebElement lblTrackOrderPortalOrderNumberTitle;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='order-lookup__wrap']//label[@id='OrderNumberlbl']")
    public WebElement labelTrackOrderPortalOrderNumber;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='order-lookup__wrap']//input[@id='OrderNumber']")
    public WebElement inputTrackOrderPortalOrderNumber;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='order-lookup__wrap']//label[@id='BillingPostallbl']")
    public WebElement labelTrackOrderPortalBillingPostal;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='order-lookup__wrap']//input[@id='BillingPostal']")
    public WebElement inputTrackOrderPortalBillingPostal;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='order-lookup__wrap']//button")
    public WebElement btnTrackOrderPortalSubmit;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='order-lookup__wrap']//div[contains(@class,'alert-danger')]")
    public List<WebElement> lstTrackOrderPortalErrorMessageForOrderNumberAndPostalCode;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='signin__wrap']//h2")
    public WebElement lblTrackOrderPortalSignInTitle;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='signin__wrap']//label[@id='EmailAddresslbl']")
    public WebElement labelTrackOrderPortalEmail;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='signin__wrap']//input[@id='EmailAddress']")
    public WebElement inputTrackOrderPortalEmail;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='signin__wrap']//label[@id='Passwordlbl']")
    public WebElement labelTrackOrderPortalPassword;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='signin__wrap']//input[@id='Password']")
    public WebElement inputTrackOrderPortalPassword;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='signin__wrap']//button[@class='form__button-show-password']")
    public WebElement btnTrackOrderPortalShowPassword;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@id='recaptchaId']")
    public WebElement cntTrackOrderPortalRecaptcha;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='signin__wrap']//button[@id='submit']")
    public WebElement btnTrackOrderPortalSignIn;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='signin__wrap']//div[contains(@class,'alert-danger')]")
    public List<WebElement> lstTrackOrderPortalErrorMessageForSignIn;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='forgot-password']//a")
    public WebElement lnkTrackOrderPortalForgotPassword;

    @FindBy(xpath = "//div[@class='TrackOrder']//div[@class='not-found__message']")
    public WebElement lblTrackOrderPortalNotFoundMessage;

    //////////////////////////////////////////
    //For order tracking page
    @FindBy(xpath = "//div[@id='trackorder']//button[@class='back-button__button']")
    public WebElement btnTrackOrderBackButton;

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
     * To get Order date
     * @return -String - Order date
     */
    public String getOrderDate(){
        return this.getElementInnerText(lblTrackOrderDeliveryStatusPlaceOrderDate);
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
     * To verify Order Track Portal contents
     */
    public void verifyOrderTrackPortalContents() {
        String lsText;

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderPortalTitle);
        lsText = lblTrackOrderPortalTitle.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderPortalRequiredFields);
        lsText = lblTrackOrderPortalRequiredFields.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal Required Fields is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal Required Fields is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderPortalOrderNumberTitle);
        lsText = lblTrackOrderPortalOrderNumberTitle.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal Order Number Title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal Order Number Title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelTrackOrderPortalOrderNumber);
        lsText = labelTrackOrderPortalOrderNumber.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal Order Number label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal Order Number label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputTrackOrderPortalOrderNumber);
        if (this.getReusableActionsInstance().isElementVisible(inputTrackOrderPortalOrderNumber)) {
            reporter.reportLogPass("The track order portal Order Number input is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal Order Number input is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelTrackOrderPortalBillingPostal);
        lsText = labelTrackOrderPortalBillingPostal.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal Billing Postal code label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal Billing Postal code label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputTrackOrderPortalBillingPostal);
        if (this.getReusableActionsInstance().isElementVisible(inputTrackOrderPortalBillingPostal)) {
            reporter.reportLogPass("The track order portal Billing Postal code input is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal Billing Postal code input is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnTrackOrderPortalSubmit);
        lsText = btnTrackOrderPortalSubmit.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal submit button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal submit button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblTrackOrderPortalSignInTitle);
        lsText = lblTrackOrderPortalSignInTitle.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal signIn Title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal signIn Title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelTrackOrderPortalEmail);
        lsText = labelTrackOrderPortalEmail.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal email label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal email label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputTrackOrderPortalEmail);
        if (this.getReusableActionsInstance().isElementVisible(inputTrackOrderPortalEmail)) {
            reporter.reportLogPass("The track order portal email input is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal email input is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelTrackOrderPortalPassword);
        lsText = labelTrackOrderPortalPassword.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal password label is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal password label is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(inputTrackOrderPortalPassword);
        if (this.getReusableActionsInstance().isElementVisible(inputTrackOrderPortalPassword)) {
            reporter.reportLogPass("The track order portal password input is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal password input is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnTrackOrderPortalShowPassword);
        lsText = btnTrackOrderPortalShowPassword.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal Show Password button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal Show Password button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(cntTrackOrderPortalRecaptcha);
        if (this.getReusableActionsInstance().isElementVisible(cntTrackOrderPortalRecaptcha)) {
            reporter.reportLogPass("The track order portal Recaptcha is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal Recaptcha is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnTrackOrderPortalSignIn);
        lsText = btnTrackOrderPortalSignIn.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal signIn button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal signIn button is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkTrackOrderPortalForgotPassword);
        lsText = lnkTrackOrderPortalForgotPassword.getAttribute("href");
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal forgot password link is not empty");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal forgot password link is empty");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkTrackOrderPortalForgotPassword);
        lsText = lnkTrackOrderPortalForgotPassword.getText();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The track order portal forgot password link is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The track order portal forgot password link is not displaying correctly");
        }
    }

    /**
     * To verify Order Track Portal Error Messages For No Input
     * @param - List<String> - lstTrackOrderPortalErrorMessageForOrderNumberAndPostalCodeFromYml
     * @param - List<String> - lstTrackOrderPortalErrorMessageForSignInFromYml
     */
    public void verifyOrderTrackPortalErrorMessagesForNoInput(List<String> lstTrackOrderPortalErrorMessageForOrderNumberAndPostalCodeFromYml,List<String> lstTrackOrderPortalErrorMessageForSignInFromYml) {
        String lsActual,lsExpected;
        WebElement item;

        reporter.reportLog("Verify error message for order number and postal code");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTrackOrderPortalSubmit);
        this.btnTrackOrderPortalSubmit.click();
        this.waitForCondition(Driver->{return lstTrackOrderPortalErrorMessageForOrderNumberAndPostalCode.size()>0;},10000);

        int loopSize=lstTrackOrderPortalErrorMessageForOrderNumberAndPostalCode.size();
        for(int i=0;i<loopSize;i++){
            item=lstTrackOrderPortalErrorMessageForOrderNumberAndPostalCode.get(i);
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            lsActual=item.getText().trim();
            lsExpected=lstTrackOrderPortalErrorMessageForOrderNumberAndPostalCodeFromYml.get(i);
            if(lsActual.equalsIgnoreCase(lsExpected)){
                reporter.reportLogPass("The actual error message:'"+lsActual+"' is the same as the expected:'"+lsExpected+"'");
            }
            else{
                reporter.reportLogFail("The actual error message:'"+lsActual+"' is the same as the expected:'"+lsExpected+"'");
            }
        }

        reporter.reportLog("Verify error message for signIn");
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTrackOrderPortalSignIn);
        this.btnTrackOrderPortalSignIn.click();
        this.waitForCondition(Driver->{return lstTrackOrderPortalErrorMessageForSignIn.size()>0;},10000);

        loopSize=lstTrackOrderPortalErrorMessageForSignIn.size();
        for(int i=0;i<loopSize;i++){
            item=lstTrackOrderPortalErrorMessageForSignIn.get(i);
            this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            lsActual=item.getText().trim();
            lsExpected=lstTrackOrderPortalErrorMessageForSignInFromYml.get(i);
            if(lsActual.equalsIgnoreCase(lsExpected)){
                reporter.reportLogPass("The actual error message:'"+lsActual+"' is the same as the expected:'"+lsExpected+"'");
            }
            else{
                reporter.reportLogFail("The actual error message:'"+lsActual+"' is the same as the expected:'"+lsExpected+"'");
            }
        }
    }

    /**
     * To goTo Track Order Portal Through Clicking TrackYourOrder Item On GlobalFooter
     * @param - GlobalFooterPage - gf
     * @param - List<List<String>> - lstNameAndLinks
     */
    public void goToTrackOrderPortalThroughClickingTrackYourOrderItemOnGlobalFooter(GlobalFooterPage gf,List<List<String>> lstNameAndLinks){
        String lsService="Track Your Order";
        Map<String,String> hashMap = gf.getTestDataWithSpecificName(lstNameAndLinks, lsService, true);
        gf.goToService(lsService,lblTrackOrderPortalTitle,hashMap.get("parent"));
    }

    /**
     * To go To Order Tracking Page By Order Number And Billing Postal
     * @param - String - orderNumber
     * @param - String - billingPostal
     */
    public void goToOrderTrackingPageByOrderNumberAndBillingPostal(String orderNumber,String billingPostal){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTrackOrderPortalOrderNumber);
        this.inputTrackOrderPortalOrderNumber.clear();
        this.inputTrackOrderPortalOrderNumber.sendKeys(orderNumber);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTrackOrderPortalBillingPostal);
        this.inputTrackOrderPortalBillingPostal.clear();
        this.inputTrackOrderPortalBillingPostal.sendKeys(billingPostal);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTrackOrderPortalSubmit);
        this.btnTrackOrderPortalSubmit.click();
        this.waitForCondition(Driver->{return lblTrackOrderTitle.isDisplayed();},120000);
    }

    /**
     * To go To Order Tracking Page By userName and password
     * @param - String - userName
     * @param - String - password
     */
    public void goToOrderStatusPageByUserNameAndPasswordInOrderTrackingPortalPage(String userName, String password){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTrackOrderPortalEmail);
        this.inputTrackOrderPortalEmail.clear();
        this.inputTrackOrderPortalEmail.sendKeys(userName);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTrackOrderPortalPassword);
        this.inputTrackOrderPortalPassword.clear();
        this.inputTrackOrderPortalPassword.sendKeys(password);
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTrackOrderPortalSignIn);
        this.btnTrackOrderPortalSignIn.click();
        this.waitForCondition(Driver->{return (new MyAccount(this.getDriver())).lblOrderStatusSectionTitle.isDisplayed();},120000);
    }

    public void verifyNotFoundMessageForTrackPortalWithWrongOrderNumber(String lsExpectedNotFoundMessage){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTrackOrderPortalOrderNumber);
        this.inputTrackOrderPortalOrderNumber.clear();
        this.inputTrackOrderPortalOrderNumber.sendKeys("WRG123456789");
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTrackOrderPortalBillingPostal);
        this.inputTrackOrderPortalBillingPostal.clear();
        this.inputTrackOrderPortalBillingPostal.sendKeys("L3P2G3");
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTrackOrderPortalSubmit);
        this.btnTrackOrderPortalSubmit.click();
        this.waitForCondition(Driver->{return lblTrackOrderPortalNotFoundMessage.isDisplayed();},120000);

        String lsText=this.getElementInnerText(lblTrackOrderPortalNotFoundMessage).toLowerCase();

        if(lsText.contains(lsExpectedNotFoundMessage.toLowerCase())){
            reporter.reportLogPass("The error message for wrong order number or billing postal is displaying as expected.");
        }
        else{
            reporter.reportLogFailWithScreenshot("The error message for wrong order number or billing postal is not displaying as expected.");
        }
    }

    /**
     * To verify Order Tracking Header Section
     */
    public void verifyOrderTrackingHeaderSection() {
        String lsText;

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnTrackOrderBackButton);
        lsText = btnTrackOrderBackButton.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The order tracking back button is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The order tracking back button is not displaying correctly");
        }

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

        if(orderTrackingItem.get("productStyle")!=null&&orderDetailsItem.get("productStyle")!=null){
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
        }

        if(orderTrackingItem.get("productSize")!=null&&orderDetailsItem.get("productSize")!=null){
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
            reporter.reportLogPass("The productQuantity in OrderTracking Item is the same as the one in orderDetails Item");
        }
        else{
            reporter.reportLogFail("The productQuantity:"+orderTrackingQuantity+" in OrderTracking Item is not the same as the one:"+orderDetailsQuantity+" in orderDetails Item");
        }
    }

    /**
     * To go To Order Tracking Page By userName and password
     * @param - String - userName
     * @param - String - password
     */
    public void verifyErrorMessageWithInvalidUserNameAndPassword(String lsErrorMessageWithInvalidUserNameAndPassword){
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTrackOrderPortalEmail);
        this.inputTrackOrderPortalEmail.clear();
        this.inputTrackOrderPortalEmail.sendKeys("InvalidEmail@invalid.com");
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTrackOrderPortalPassword);
        this.inputTrackOrderPortalPassword.clear();
        this.inputTrackOrderPortalPassword.sendKeys("invalid1");
        this.applyStaticWait(300);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTrackOrderPortalSignIn);
        this.btnTrackOrderPortalSignIn.click();
        this.waitForCondition(Driver->{return lstTrackOrderPortalErrorMessageForSignIn.size()>0;},120000);

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lstTrackOrderPortalErrorMessageForSignIn.get(0));
        String lsText=lstTrackOrderPortalErrorMessageForSignIn.get(0).getText().trim();
        if(lsText.equalsIgnoreCase(lsErrorMessageWithInvalidUserNameAndPassword)){
            reporter.reportLogPass("The error message for invalid username and password is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The error message for invalid username and password is not displaying correctly");
        }
    }

    /**
     * This function fetches order details for user
     * @param - String - userName
     * @param - String - password
     * @param - String - grantType
     * @param - String - apiKey
     * @return - List<Map<String,Object>>
     * @throws - IOException
     */
    public List<Map<String,Object>> getPlacedOrderListForUser(int noOfOrderDetailsToBeFetched, String orderNumberForFetchingDetails,String customerEDP, String accessToken, String userName, String password,String grantType, String apiKey) throws IOException, ParseException {
        List orderList = new ArrayList();
        JSONObject userSessionData = null;
        String customerEDPNumber, access_token;
        //Fetching user token details to be used
        if(customerEDP==null){
            userSessionData = new ApiResponse().getApiUserSessionData(userName,password,grantType,apiKey);
            customerEDPNumber = userSessionData.get("customerEDP").toString();
            access_token = userSessionData.get("access_token").toString();
        }else{
            customerEDPNumber = customerEDP;
            access_token = accessToken;
        }

        //Fetching list of Orders for user
        OrderAPI orderAPI = new OrderAPI();
        if(orderNumberForFetchingDetails!=null){
            List orderDetails = this.getOrderDetailsForOrderNumber(customerEDPNumber,access_token,orderNumberForFetchingDetails);
            if(orderDetails.size()>0){
                Map<String,Object> orderNumberDetailsForUser = new HashMap<>();
                orderNumberDetailsForUser.put("orderNumber",orderNumberForFetchingDetails);
                orderNumberDetailsForUser.put("orderDetails",orderDetails);
                String formatDate = this.formatDateToProvidedFormat(((HashMap)((List)orderNumberDetailsForUser.get("orderDetails")).get(0)).get("orderDateTime").toString(),"yyyy-MM-dd'T'k:m:s","MMMM dd, yyyy h:m a");
                orderNumberDetailsForUser.put("orderPlacedDateTime",this.formatInputDateAsPerApplication(formatDate));
                orderNumberDetailsForUser.put("quantity",((HashMap)((List)orderNumberDetailsForUser.get("orderDetails")).get(0)).get("orderQuantity"));
                orderNumberDetailsForUser.put("postalCode",((HashMap)orderDetails.get(0)).get("postalCode").toString());
                orderList.add(orderNumberDetailsForUser);
            }
        }else{
            Response orderLists = orderAPI.getOrderList(customerEDPNumber,access_token);
            if(orderLists.getStatusCode()==200){
                OrderListResponse orderListResponseList = JsonParser.getResponseObject(orderLists.asString(),new TypeReference<OrderListResponse>() {});
                int totalOrderToBeFetched = 0;
                //Fetching required product details from list to be used in test
                if(orderListResponseList.getOrderSummary().size()>0){
                    List<OrderSummary> orderSummaryList = orderListResponseList.getOrderSummary();
                    for(OrderSummary orderSummary:orderSummaryList){
                        Map<String,Object> orderNumberDetailsForUser = new HashMap<>();
                        if(noOfOrderDetailsToBeFetched!=0 && totalOrderToBeFetched == noOfOrderDetailsToBeFetched)
                            break;
                        else{
                            if(orderSummary.getQuantity()>1){
                                orderNumberDetailsForUser.put("orderNumber",orderSummary.getOrderNo());
                                String formatDate = this.formatDateToProvidedFormat(orderSummary.getOrderDateTime(),"yyyy-MM-dd'T'k:m:s","MMMM dd, yyyy h:m a");
                                orderNumberDetailsForUser.put("orderPlacedDateTime",this.formatInputDateAsPerApplication(formatDate));
                                orderNumberDetailsForUser.put("quantity",orderSummary.getQuantity());
                                //Fetching order details for products in Order
                                List orderDetails = this.getOrderDetailsForOrderNumber(customerEDPNumber,access_token,orderSummary.getOrderNo());
                                if(orderDetails.size()>0){
                                    orderNumberDetailsForUser.put("orderDetails",orderDetails);
                                    orderNumberDetailsForUser.put("postalCode",((HashMap)orderDetails.get(0)).get("postalCode").toString());
                                    orderList.add(orderNumberDetailsForUser);
                                    totalOrderToBeFetched++;
                                }
                            }
                        }
                    }
                }else{
                    //Placing Order for user to be used in test
                }
            }else
                reporter.reportLogFail("Order List for user :"+userName+" is not fetched with status code as: "+orderLists.getStatusCode()+" and error message as: "+orderLists.getBody().asString());
        }

        return orderList;
    }

    /**
     * This function fetches data for a particular Order Number
     * @param - String - customerEDP
     * @param - String - accessToken
     * @param - String - orderNumber
     * @return - Map<String,Object>
     * @throws - IOException
     */
    public List<Map<String,Object>> getOrderDetailsForOrderNumber(String customerEDP, String accessToken,String orderNumber) throws IOException {
        List<Map<String,Object>> productData = new ArrayList();
        Response response = new OrderAPI().getGivenOrder(customerEDP,accessToken,orderNumber);
        if(response.getStatusCode()==200){
            DetailedOrderSummary detailedOrderSummary = JsonParser.getResponseObject(response.asString(), new TypeReference<DetailedOrderSummary>() {});
            List<DetailedOrderSummary.ShipLevels> shipLevelsList = detailedOrderSummary.getShipLevels();
            for(com.tsc.api.pojo.DetailedOrderSummary.ShipLevels shipLevels:shipLevelsList){
                List<DetailedOrderSummary.Items> itemsList = shipLevels.getItems();
                if(itemsList.size()>0){
                    for(DetailedOrderSummary.Items items:itemsList){
                        Map<String,Object> productDetails = new HashMap<>();
                        productDetails.put("orderDateTime",detailedOrderSummary.getOrderSummary().getOrderDateTime());
                        productDetails.put("orderQuantity",detailedOrderSummary.getOrderSummary().getQuantity());
                        productDetails.put("productName",items.getDescription().trim());
                        if(items.getStyle()==null||items.getStyle().isEmpty()){
                            productDetails.put("productStyle",null);
                        }
                        else{
                            productDetails.put("productStyle",items.getStyle().trim());
                        }
                        if(items.getSize()==null||items.getSize().isEmpty()){
                            productDetails.put("productSize",null);
                        }
                        else{
                            productDetails.put("productSize",items.getSize().trim());
                        }
                        productDetails.put("productNumber",items.getItemNoForDisplay().replace("-","").trim());
                        productDetails.put("productQuantity",this.getIntegerFromString(items.getItemQuantity()));
                        productDetails.put("productURL",items.getItemURL());
                        productDetails.put("postalCode",this.getPostalCodeForOrder(shipLevels.getShipCityProvincePostalCode()));
                        if(!items.getStyle().isEmpty() && !items.getSize().isEmpty())
                            productDetails.put("productInfoForDisplay",(items.getDescription()+" | "+items.getStyle()+" | "+items.getSize()).trim());
                        else if(items.getStyle().isEmpty() && !items.getSize().isEmpty())
                            productDetails.put("productInfoForDisplay",(items.getDescription()+" | "+items.getSize()).trim());
                        else if(!items.getStyle().isEmpty() && items.getSize().isEmpty())
                            productDetails.put("productInfoForDisplay",(items.getDescription()+" | "+items.getStyle()).trim());
                        else
                            productDetails.put("productInfoForDisplay",(items.getDescription()).trim());

                        productData.add(productDetails);
                    }
                }
            }
        }else
            reporter.reportLogFail("Order Details for product with Order Number:" +orderNumber+" is not fetched by api with status code: "+response.getStatusCode()+ "and error message: "+response.getBody().asString());

        if(productData.size()>0){
            return productData;
        }
        else
            return null;
    }

    /**
     * This function formats date that is displayed in UI
     * @param - String - inputDate
     * @return
     */
    public String formatInputDateAsPerApplication(String inputDate){
        String formatDate = null;
        String[] formatDateArray = inputDate.split(" ");
        if(formatDateArray[1].contains("0"))
            formatDateArray[1] = formatDateArray[1].replace("0","");

        if(formatDateArray[formatDateArray.length-1].contains("."))
            formatDateArray[formatDateArray.length-1] = formatDateArray[formatDateArray.length-1].replace(".","").toUpperCase();

        for(String data:formatDateArray){
            if(formatDate==null)
                formatDate = data;
            else
                formatDate = formatDate+" "+data;
        }
        return formatDate;
    }

    /**
     * To verify Back Button in header
     * @param - String - lsUrlBeforeGoToOrderTrackingPage
     */
    public void verifyBackButton(String lsUrlBeforeGoToOrderTrackingPage) {
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTrackOrderBackButton);
        String lsUrlBeforeClickingBackButton = this.URL();
        this.btnTrackOrderBackButton.click();
        this.waitForCondition(Driver -> {
            return !this.URL().equalsIgnoreCase(lsUrlBeforeClickingBackButton);
        }, 30000);

        String lsUrlAfterClickingBackButton = this.URL();
        if (lsUrlAfterClickingBackButton.equalsIgnoreCase(lsUrlBeforeGoToOrderTrackingPage)) {
            reporter.reportLogPass("The Url:'" + lsUrlAfterClickingBackButton + "' after clicking Back button is the same as expected:'" + lsUrlBeforeGoToOrderTrackingPage + "'");
        } else {
            reporter.reportLogFail("The Url:'" + lsUrlAfterClickingBackButton + "' after clicking Back button is the same as expected:'" + lsUrlBeforeGoToOrderTrackingPage + "'");
        }
    }

    /**
     * This function formats postal code for placed order
     * @param - String - postalCodeInput
     * @return - String
     */
    public String getPostalCodeForOrder(String postalCodeInput){
        String[] postalCodeArray = postalCodeInput.split("-");
        return postalCodeArray[postalCodeArray.length-1].replace(" ","").trim();
    }
}
