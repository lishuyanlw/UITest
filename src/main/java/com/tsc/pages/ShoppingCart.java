package com.tsc.pages;

import com.tsc.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCart extends BasePage {

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//shopping-cart//div[contains(@class,'cart-items')]//div/a[contains(@class,'pull-right')]")
    public List<WebElement> btnItemRemoveButtonFromCart;

    @FindBy(xpath="//shopping-cart//div[@class='cart-details']//div[@class='details-box']")
    public WebElement sectionOrderSummaryDetails;

    @FindBy(xpath="//shopping-cart//div[@id='removeItemModal']//div[@class='modal-content']")
    public WebElement modelRemoveItemDialog;

    @FindBy(xpath = "//shopping-cart//div[@id='removeItemModal']//div[@class='modal-content']//div[contains(@class,'modal-body')]//button[contains(@class,'primary')]")
    public WebElement btnRemoveItem;

    public void removeItemsAddedToShoppingCart(){
        GlobalHeaderPage globalHeaderPage = new GlobalHeaderPage(this.getDriver());
        ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
        this.getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeaderPage.CartBagCounter);
        this.getReusableActionsInstance().clickIfAvailable(globalHeaderPage.CartBagCounter);
        this.waitForPageToLoad();
        //this.waitForCondition(Driver->{return this.sectionOrderSummaryDetails.isDisplayed();},60000);
        if(this.btnItemRemoveButtonFromCart.size()>0){
            for(WebElement removeButton: this.btnItemRemoveButtonFromCart){
                this.getReusableActionsInstance().clickIfAvailable(removeButton);
                this.waitForCondition(Driver->{return (this.btnRemoveItem.isDisplayed() && this.btnRemoveItem.isEnabled());},60000);
                this.getReusableActionsInstance().clickIfAvailable(this.btnRemoveItem);
                this.waitForPageToLoad();
            }
        }
        //Verify that all items are removed
        this.getReusableActionsInstance().staticWait(3000);
        reporter.softAssert(productDetailPage.getShoppingCartNumber()==0,"All Items are removed from shopping Cart","Items are still present in shopping Cart with no of items: "+productDetailPage.getShoppingCartNumber());
    }
}
