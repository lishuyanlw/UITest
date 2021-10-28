package com.tsc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tsc.pages.base.BasePage;

public class ProductDetailPage extends BasePage {
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		
	}
		
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]")
	public WebElement cntLeftContainer;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div")
	public WebElement cntRightContainer;
	
	//Thumbnail part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[@id='divThumbnail']//button[contains(@class,'slick-prev')]")
	public WebElement btnThumbnailPrev;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[@id='divThumbnail']//button[contains(@class,'slick-next')]")
	public WebElement btnThumbnailNext;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-active') and not(contains(@class,'videolink'))]")
	public List<WebElement> lstThumbnailImageList;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-active') and contains(@class,'videolink')]")
	public WebElement lnkThumbnailVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-active') and contains(@class,'videolink')]//img")
	public WebElement imgThumbnailVideo;
	
	//Video part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[@id='divItemBadge']/img")
	public WebElement imgVideoBoxControlBadge;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[@class='videoBox']")
	public WebElement videoBoxControl;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[@class='videoBox']//video")
	public WebElement lnkVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//p[contains(@class,'disclaim')]")
	public WebElement lblVideoDisclaim;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'autoplayDiv')]//label[contains(@class,'control-label')]")
	public WebElement lblAutoPlayVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'autoplayDiv')]//div[contains(@class,'checkboxSlide')]")
	public WebElement btnAutoPlayVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'tooltipClass')]//a")
	public WebElement lnkAutoPlayVideoToolTip;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'tooltipClass')]//div[contains(@class,'tooltip-inner')]")
	public WebElement lblAutoPlayVideoToolTipPopupMsg;
	
	//Product details
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']")
	public WebElement lblProductName;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='divBrandName']//a")
	public WebElement lnkBrandName;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[contains(@class,'product-name-sub')]//span[@id='lblItemNo']")
	public WebElement lblProductNumber;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']")
	public WebElement productReviewSection;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']//div[contains(@class,'pr-star-v4')]")
	public List<WebElement> lstProductReviewStar;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']//span[contains(@class,'pr-accessible-text')]")
	public List<WebElement> lblProductReviewAccessibleText;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']")
	public WebElement lblProductReview;

	
	/**
	 * Method to check if AutoPlayVideoStatus is ON
	 * @return true/false	  
	 * @author Wei.Li
	 */
	public boolean checkIfAutoPlayVideoStatusIsON() {
		String lsStyle=this.btnAutoPlayVideo.getAttribute("style");
		return lsStyle.equalsIgnoreCase("background:#000;")||lsStyle.equalsIgnoreCase("background: rgb(0, 0, 0);");		
	}
	
	/**
	 * Method to get AutoPlayVideo ToolTip popup Message
	 * @return String: tootip message	  
	 * @author Wei.Li
	 */
	public String getAutoPlayVideoToolTipPopupMsg() {
		this.getReusableActionsInstance().scrollToElement(this.lnkAutoPlayVideoToolTip);
		this.getReusableActionsInstance().staticWait(300);
		
		String lsText=this.lblAutoPlayVideoToolTipPopupMsg.getText().trim();
		this.getReusableActionsInstance().scrollToElement(this.btnAutoPlayVideo);
		
		return lsText;
	}

}
