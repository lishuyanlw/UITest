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
		
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]")
	public WebElement cntLeftContainer;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div")
	public WebElement cntRightContainer;
	
	//Thumbnail part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//button[contains(@class,'slick-prev')]")
	public WebElement btnThumbnailPrev;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//button[contains(@class,'slick-next')]")
	public WebElement btnThumbnailNext;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-active') and not(contains(@class,'videolink'))]")
	public List<WebElement> lstThumbnailImageList;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-current') and not(contains(@class,'videolink'))]//img")
	public WebElement imgCurrentThumbnail;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-active') and contains(@class,'videolink')]")
	public WebElement lnkThumbnailVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-active') and contains(@class,'videolink')]//img")
	public WebElement imgThumbnailVideo;
	
	//Video part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divItemBadge']/img")
	public WebElement imgVideoBoxControlBadge;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@class='videoBox']")
	public WebElement videoBoxControl;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@class='videoBox']//video")
	public WebElement lnkVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//p[contains(@class,'disclaim')]")
	public WebElement lblVideoDisclaim;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'autoplayDiv')]//label[contains(@class,'control-label')]")
	public WebElement lblAutoPlayVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'autoplayDiv')]//div[contains(@class,'checkboxSlide')]")
	public WebElement btnAutoPlayVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'tooltipClass')]//a")
	public WebElement lnkAutoPlayVideoToolTip;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'tooltipClass')]//div[contains(@class,'tooltip-inner')]")
	public WebElement lblAutoPlayVideoToolTipPopupMsg;
	
	//Image part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divImageGallery']//figure[@aria-hidden='false']//a")
	public WebElement lnkCurrentImage;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection__zoom')]//p[contains(@class,'pdImageSection__zoom--message')]")
	public WebElement lblImageZoomMessage;
	
	//Product details
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']")
	public WebElement lblProductName;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='divBrandName']//a")
	public WebElement lnkBrandName;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[contains(@class,'product-name-sub')]//span[@id='lblItemNo']")
	public WebElement lblProductNumber;
	
	//Review part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']")
	public WebElement productReviewSection;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']//div[contains(@class,'pr-star-v4')]")
	public List<WebElement> lstProductReviewStar;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']//span[contains(@class,'pr-accessible-text')]")
	public List<WebElement> lblProductReviewAccessibleText;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']")
	public WebElement lblProductReview;
	
	//Price part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//*[@class='price-div']//span[@id='lblPriceLabel']")
	public WebElement lblProductPriceLabel;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//*[@class='price-div']//span[@id='lblCurrentPrice']")
	public WebElement lblProductNowPrice;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//*[@class='price-div']//span[@id='lblShowWasPrice']")
	public WebElement lblProductWasPrice;

	//EasyPay part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='divEasyPayment']")
	public WebElement lblProductEasyPay;
	
	//Shipping part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@class='savings-shipping']//*[@id='divSavings']")
	public WebElement lblProductSavings;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@class='savings-shipping']//*[@class='shipping']")
	public WebElement lblProductShipping;
	
	//Style part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form")
	public WebElement cntProductStyleJudgeIndicator;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']")
	public WebElement cntProductStyleContainer;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatch']//span[@class='style-lbl']")
	public WebElement lblProductStyleStatic;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatch']//span[@id='lblStyle']")
	public WebElement lblProductStyleTitle;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatch']//input")
	public List<WebElement> lstStyleRadioList;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatch']//label")
	public List<WebElement> lstStyleLabelList;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatch']//label[contains(@class,'style-selected')]//span[@data-style]")
	public WebElement btnProductStyleSelected;
	
	//TrueFit part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@id='tf-wrapper']//div[@class='tfc-cfg-logo']")
	public WebElement imgProductTrueFitLogo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@id='tf-wrapper']//a[@class='tfc-popup-click-open']")
	public WebElement lnkProductTrueFitLink;
	
	//TrueFit iframe part
	@FindBy(xpath = "//iframe[contains(@src,'truefit')]")
	public WebElement iframeProductTrueFit;
	
	@FindBy(xpath = "//div[contains(@class,'tfc-iframe-loaded')]")
	public WebElement iframeProductTrueFitLoadingIndicator;
	
	@FindBy(xpath = "//button[contains(@class,'tfc-popup-click-close')][img]")
	public WebElement btnProductTrueFitIframeClose;
	
	//Size part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='divAvailableSizes']//span[contains(@class,'size-lbl')]")
	public WebElement lblSizeStatic;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='divAvailableSizes']//select")
	public WebElement selectSizeOption;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='soldoutContainer']")
	public WebElement lblSoldOut;
	
	//Quantity part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@class='qty-container']//span[contains(@class,'qty-lbl')]")
	public WebElement lblQuantityStatic;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@class='qty-container']//select")
	public WebElement selectQuantityOption;
		
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='divAddToCart']//button[@id='btnAddToCart']")
	public WebElement btnAddToBag;
	
	//Social links part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='favShare']/div[contains(@class,'mob-middle-social')]/div")
	public WebElement lnkFavShareMobile;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='favShare']/div[not(contains(@class,'mob-middle-social'))]/div")
	public WebElement lnkFavShareEmail;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//a[contains(@href,'facebook')]")
	public WebElement lnkFaceBook;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//a[contains(@href,'twitter')]")
	public WebElement lnkTwitter;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//a[contains(@href,'pinterest')]")
	public WebElement lnkPInterest;
	
	//Sticky swiper container part
	@FindBy(xpath = "//div[@class='sticky-swiper-container']//div[@class='stickyIcon']")
	public WebElement imgStickyIcon;
	
	@FindBy(xpath = "//div[@class='sticky-swiper-container']//a[@data-text='PRODUCT OVERVIEW']")
	public WebElement btnStickyTabProductOverview;
	
	@FindBy(xpath = "//div[@class='sticky-swiper-container']//a[@data-text='ABOUT THE BRAND']")
	public WebElement btnStickyTabAboutTheBrand;
	
	@FindBy(xpath = "//div[@class='sticky-swiper-container']//a[@data-href='#pr-reviewdisplay']")
	public WebElement btnStickyTabProductReview;
	
	//Product Review Tab part
	@FindBy(xpath = "//div[@id='productReviewSection']//*[@class='pr-reviewHeader']")
	public WebElement lblReviewTabHeader;
	
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-snapshot']//div[@class='pr-review-snapshot-histogram']")
	public WebElement imgReviewTabHistogram;
	
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-snapshot']//div[@class='pr-snippet-stars-reco-stars']//div[@class='pr-snippet-rating-decimal']")
	public WebElement lblReviewTabRateDecimalText;
	
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-snapshot']//div[@class='pr-snippet-stars-reco-stars']//div[@class='pr-rating-stars']//div[contains(@class,'pr-star-v4')]")
	public List<WebElement> lstReviewTabStar;
	
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-snapshot']//div[@class='pr-snippet-stars-reco-stars']//span[@class='pr-accessible-text']")
	public WebElement lblReviewTabStarAccessibleText;
	
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-snapshot']//span[@class='pr-snippet-review-count']")
	public WebElement lblReviewTabReviewCount;
	
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-snapshot']//a[contains(@href,'writereview')]")
	public WebElement lnkReviewTabWriteReview;
	
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-display']//select[@id='pr-rd-sort-by']")
	public WebElement selectReviewTabSortBy;
	
	//Review list part
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-display']//div[@class='pr-review']")
	public List<WebElement> lstReviewTabPerReviewList;
	
	public By byReviewTabStarList=By.xpath(".//div[@class='pr-rating-stars']//div[contains(@class,'pr-star-v4')]");
	
	public By byReviewTabRatingDecimal=By.xpath(".//div[@class='pr-snippet-rating-decimal']");
	
	public By byReviewTabReviewAccessibleText=By.xpath(".//span[@class='pr-accessible-text']");
	
	public By byReviewTabHeadingLine=By.xpath(".//*[@class='pr-rd-review-headline']");
	
	public By byReviewTabSubmittedTime=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-rd-author-submission-date')]");
	
	public By byReviewTabNickName=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-rd-author-nickname')]");
	
	public By byReviewAuthorLocation=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-rd-author-location')]");
	
	public By byReviewTabDescriptionText=By.xpath(".//p[contains(@class,'pr-rd-description-text')]");
	
	public By byReviewTabImage=By.xpath(".//section[contains(@class,'pr-rd-images')]");
	
	public By byReviewTabFooter=By.xpath(".//footer");
	
	//Review footer part
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-display']//p[@class='pr-rd-review-position']")
	public WebElement lblReviewTabDisplayingReviewMsg;
	
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-display']//a[contains(@class,'pr-rd-to-top')]")
	public WebElement lnkReviewTabBackToTop;
	
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-display']//div[@class='pr-rd-pagination']")
	public WebElement cntReviewTabPagination;
	
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-display']//a[@aria-label='Previous']")
	public WebElement lnkReviewTabPrev;
	
	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-display']//a[@aria-label='Next']")
	public WebElement lnkReviewTabNext;
	
	
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
	
	/**
	 * Method to check if Style size is existing
	 * @return true/false	  
	 * @author Wei.Li
	 */
	public boolean judgeStyleSizeAvailable() {
		return this.getChildElementCount(this.cntProductStyleJudgeIndicator)>9;
	}
	
	/**
	 * Method to load product true fit iframe
	 * @return true/false	  
	 * @author Wei.Li
	 */
	public boolean productTrueFitIframeLoading() {
		return waitForCondition(Driver->{return !this.iframeProductTrueFitLoadingIndicator.getAttribute("style").contains("display: block;");},60000);
	}
	
	/**
	 * Method to get Pagination count in ReviewTab
	 * @return long	  
	 * @author Wei.Li
	 */
	public long getPaginationCountInReviewTab() {
		return this.getChildElementCount(this.cntReviewTabPagination);
	}
	
	/**
	 * Method to judge if the sticky Tab is selected
	 * @return true/false	  
	 * @author Wei.Li
	 */
	public boolean getStickyTabSelectedStatus(WebElement btnTab) {
		return btnTab.getAttribute("class").equalsIgnoreCase("selected");
	}
	

	

}
