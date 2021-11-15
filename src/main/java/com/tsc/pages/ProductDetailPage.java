package com.tsc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]")
	public WebElement cntThumbnailContainer;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//button[contains(@class,'slick-prev')]")
	public WebElement btnThumbnailPrev;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//button[contains(@class,'slick-next')]")
	public WebElement btnThumbnailNext;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-active') and not(contains(@class,'videolink'))]")
	public List<WebElement> lstThumbnailImageList;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-active') and not(contains(@class,'videolink'))][@data-styleid]")
	public List<WebElement> lstThumbnailImageListForDropdownMenu;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-current') and not(contains(@class,'videolink'))]//img")
	public WebElement imgCurrentThumbnail;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-current')]")
	public WebElement currentThumbnailItem;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-active') and contains(@class,'videolink')]")
	public WebElement lnkThumbnailVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divThumbnail']//div[contains(@class,'slick-list')]//div[contains(@class,'slick-active') and contains(@class,'videolink')]//img")
	public WebElement imgThumbnailVideo;
	
	//Video part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divImageBox']")
	public WebElement cntJudgeVideoBoxControlBadgeExisting;	
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divItemBadge']/img")
	public WebElement imgProductBadge;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@class='videoBox']")
	public WebElement videoBoxControl;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@class='videoBox']//video")
	public WebElement lnkVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//p[contains(@class,'disclaim')]")
	public WebElement lblVideoDisclaim;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//p[contains(@class,'pdImageSection__zoom--message')]")
	public WebElement lblImageDisclaim;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'autoplayDiv')]//label[contains(@class,'control-label')]")
	public WebElement lblAutoPlayVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'autoplayDiv')]//div[contains(@class,'checkboxSlide')]")
	public WebElement btnAutoPlayVideo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'tooltipClass')]//a")
	public WebElement lnkAutoPlayVideoToolTip;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[contains(@class,'videoCustomControls')]//div[contains(@class,'tooltipClass')]//div[contains(@class,'tooltip-inner')]")
	public WebElement lblAutoPlayVideoToolTipPopupMsg;
	
	//Zoom Image part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]//div[@id='divImageGallery']//figure[@aria-hidden='false']//a")
	public WebElement lnkCurrentZoomImage;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection__zoom')]//p[contains(@class,'pdImageSection__zoom--message')]")
	public WebElement lblZoomImageMessage;
	
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
	public List<WebElement> lstProductReviewAccessibleText;
	
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
	public WebElement cntProductSizeJudgeIndicator;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']")
	public WebElement cntProductStyleSection;
	
	//For radio style	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatch']//span[@class='style-lbl']")
	public WebElement lblRadioProductStyleStatic;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatch']//span[@id='lblStyle']")
	public WebElement lblRadioProductStyleTitle;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatch']//input")
	public List<WebElement> lstStyleRadioList;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatch']//label")
	public List<WebElement> lstRadioStyleLabelList;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatch']//label//span")
	public List<WebElement> lstRadioStyleLabelSpanList;
		
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatch']//label[contains(@class,'style-selected')]/preceding-sibling::input[1]")
	public WebElement btnRadioProductStyleSelected;
	
	//For dropdown menu style		
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatchDdl']//span[@class='style-lbl']")
	public WebElement lblDropDownProductStyleStatic;
		
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatchDdl']//select")
	public WebElement selectProductStyle;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@class='style-container']//div[@id='divStyleSwatchDdl']//select//option")
	public List<WebElement> lstDropdownProductStyle;
	
	//TrueFit part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@id='tf-wrapper']")
	public WebElement cntProductTrueFitSection;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@id='tf-wrapper']//div[@class='tfc-cfg-logo']")
	public WebElement imgProductTrueFitLogo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//form//div[@id='tf-wrapper']//a[@class='tfc-popup-click-open']")
	public WebElement lnkProductTrueFitLink;
	
	//TrueFit iframe part
	@FindBy(xpath = "//iframe[contains(@src,'truefit')]")
	public WebElement iframeProductTrueFit;
	
	@FindBy(xpath = "//div[@aria-label='True Fit']")
	public WebElement iframeProductTrueFitLoadingIndicator;
	
	@FindBy(xpath = "//button[contains(@class,'tfc-popup-click-close')][img]")
	public WebElement btnProductTrueFitIframeClose;
	
	//Size part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='divAvailableSizes']//span[contains(@class,'size-lbl')]")
	public WebElement lblSizeStatic;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='divAvailableSizes']//select")
	public WebElement selectSizeOption;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='divAvailableSizes']//div[@id='divSizeChart']")
	public WebElement lnkSizingChart;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@id='soldoutContainer']")
	public WebElement lblSoldOut;
	
	//Quantity part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@class='qty-container']//span[contains(@class,'qty-lbl')]")
	public WebElement lblQuantityStatic;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@class='qty-container']//select")
	public WebElement selectQuantityOption;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']/parent::div//div[@class='qty-container']//div[@class='qty-left']")
	public WebElement lblQuantityLeft;
		
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
	
	//product teaser part
	@FindBy(xpath = "//div[@id='pdpMainDiv']//div[@id='divProductTeaser']")
	public WebElement lblProductTeaser;
	
	@FindBy(xpath = "//div[@id='pdpMainDiv']//a[@class='pdpSeeMoreLnk']")
	public WebElement lnkProductTeaserSeeMore;
	
	//Sticky swiper container part
	@FindBy(xpath = "//div[@class='sticky-swiper-container']//div[@class='stickyIcon']")
	public WebElement imgStickyIcon;
	
	@FindBy(xpath = "//div[@class='sticky-swiper-container']//a[@data-text='PRODUCT OVERVIEW']")
	public WebElement btnStickyTabProductOverview;
	
	@FindBy(xpath = "//div[@class='sticky-swiper-container']//a[@data-text='ABOUT THE BRAND']")
	public WebElement btnStickyTabAboutTheBrand;
	
	@FindBy(xpath = "//div[@class='sticky-swiper-container']//a[@data-href='#pr-reviewdisplay']")
	public WebElement btnStickyTabProductReview;
	
	//Product Overview Tab part
	@FindBy(xpath = "//div[contains(@class,'tabs')]//div[@id='infoTabContent']//div[@id='tab0']")
	public WebElement lblProductOverviewTabContent;
	
	//Product About the Brand Tab part
	@FindBy(xpath = "//div[contains(@class,'tabs')]//div[@id='infoTabContent']//div[@id='tab1']//*[@class='tabHeader']")
	public WebElement lblProductAboutTheBrandTabHeader;
	
	@FindBy(xpath = "//div[contains(@class,'tabs')]//div[@id='infoTabContent']//div[@id='tab1']//p")
	public List<WebElement> lstProductAboutTheBrandTabContentList;
	
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
	
	public By byReviewTabHeader=By.xpath(".//header");
	
	public By byReviewTabDescriptionSection=By.xpath(".//section[contains(@class,'pr-rd-description')]");
	
	public By byReviewTabImagesSection=By.xpath(".//div[@class='pr-rating-stars']");	
	
	public By byReviewTabFooter=By.xpath(".//footer");
		
	public By byReviewTabStarSection=By.xpath(".//div[@class='pr-rating-stars']//div[contains(@class,'pr-star-v4')]");
	
	public By byReviewTabStarList=By.xpath(".//div[@class='pr-rating-stars']//div[contains(@class,'pr-star-v4')]");
	
	public By byReviewTabRatingDecimal=By.xpath(".//div[@class='pr-snippet-rating-decimal']");
	
	public By byReviewTabReviewAccessibleText=By.xpath(".//span[@class='pr-accessible-text']");
	
	public By byReviewTabHeadingLine=By.xpath(".//*[@class='pr-rd-review-headline']");
	
	public By byReviewTabRightPartSection=By.xpath(".//div[contains(@class,'pr-rd-right')]");
		
	public By byReviewTabSubmittedTime=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-rd-author-submission-date')]");
	
	public By byReviewTabNickName=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-rd-author-nickname')]");
	
	public By byReviewTabAuthorLocation=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-rd-author-location')]");
	
	public By byReviewTabVerifiedBuyerIcon=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-verified_buyer')]//span[contains(@class,'pr-badging-icon')]");
	
	public By byReviewTabVerifiedBuyerText=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-verified_buyer')]//span[contains(@class,'pr-rd-badging-text')]");
	
	public By byReviewTabDescriptionText=By.xpath(".//p[contains(@class,'pr-rd-description-text')]");
	
	public By byReviewTabImage=By.xpath(".//section[contains(@class,'pr-rd-images')]");
	
	//Review Tab footer part
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
	
	//Write a review part
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//a[@id='backToProduct']")
	public WebElement lnkWriteReviewBackToProduct;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//*[@class='pr-header-title']")
	public WebElement lblWriteReviewHeaderTitle;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//*[@class='pr-header-product-name']//a")
	public WebElement lnkWriteReviewProductName;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//*[contains(@class,'pr-header-product-img')]//img")
	public WebElement imgWriteReviewProductImage;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//p[@class='pr-header-required']")
	public WebElement lblWriteReviewRequiredQuestion;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//fieldset[contains(@class,'pr-rating-form-group')]//legend")
	public WebElement lblWriteReviewYourRating;

	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//fieldset[contains(@class,'pr-rating-form-group')]//div[@id='pr-rating']//label")
	public List<WebElement> lstWriteReviewYourRatingList;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-headline-form-group')]//label")
	public WebElement lblWriteReviewHeadline;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-headline-form-group')]//input")
	public WebElement inputWriteReviewHeadline;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-comments-form-group')]//label")
	public WebElement lblWriteReviewComments;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-comments-form-group')]//textarea")
	public WebElement textareaWriteReviewComments;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//fieldset[contains(@class,'pr-bottomline-form-group')]//legend//div[@class='pr-form-control-error-wrapper']")
	public WebElement lblWriteReviewBottomLine;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//fieldset[contains(@class,'pr-bottomline-form-group')]//legend//div[@class='pr-helper-text']")
	public WebElement lblWriteReviewSelectOne;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//fieldset[contains(@class,'pr-bottomline-form-group')]//div[@role='radiogroup']//label")
	public List<WebElement> lstWriteReviewRecommendToFriendList;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//fieldset[contains(@class,'pr-bottomline-form-group')]//button[@class='pr-clear-all-radios']")
	public WebElement btnWriteReviewClearSelection;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-name-form-group')]//label")
	public WebElement lblWriteReviewNickName;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-name-form-group')]//input")
	public WebElement inputWriteReviewNickName;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-location-form-group')]//label")
	public WebElement lblWriteReviewLocation;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-location-form-group')]//input")
	public WebElement inputWriteReviewLocation;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-media_image-form-group')]//label")
	public WebElement lblWriteReviewAddImage;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-file-input-btn-group')]//input")
	public WebElement inputWriteReviewUploadImage;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-file-input-btn-group')]//button")
	public WebElement btnWriteReviewUploadImage;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-media_videourl-form-group')]//label")
	public WebElement lblWriteReviewAddVideo;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-media_videourl-form-group')]//input")
	public WebElement inputWriteReviewUploadVideo;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-media_videourl-form-group')]//button")
	public WebElement btnWriteReviewUploadVideo;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@class='pr-submit']//p[@class='pr-subscript']")
	public WebElement lblWriteReviewTermsAndPrivacy;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@class='pr-submit']//p[@class='pr-subscript']//a[contains(@href,'termsconditions')]")
	public WebElement lnkWriteReviewTerms;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@class='pr-submit']//p[@class='pr-subscript']//a[contains(@href,'privacypolicy')]")
	public WebElement lnkWriteReviewPrivacy;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@class='pr-submit']//button[contains(@class,'pr-btn-review')]")
	public WebElement btnWriteReviewSubmitReview;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@class='pr-submit']//a[contains(@href,'powerreviews')]")
	public WebElement lnkWriteReviewPowerBy;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@class='pr-submit']//div[contains(@class,'pr-powered')]")
	public WebElement lblWriteReviewPowerBy;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@class='pr-submit']//div[contains(@class,'pr-logo-container')]//div[contains(@class,'pr-logo')]")
	public WebElement imgWriteReviewPowerBy;
	
	/**
	 * Method to check if Video is playing
	 * @return true/false	  
	 * @author Wei.Li
	 */
	public boolean checkIfVideoisPlaying() {		
		return this.videoBoxControl.findElement(By.xpath(".//div[contains(@class,'jwVidContainer')]")).getAttribute("class").contains("amp-playing");	
	}
	
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
	 * @return String: tooltip message	  
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
	 * Method to check the product style is displaying with Dropdown mode
	 * @return true	for Dropdown menu and false for Radio list  
	 * @author Wei.Li
	 */
	public boolean judgeStyleDisplayModeIsDropdownMenu() {		
		return !this.cntProductStyleSection.findElement(By.xpath(".//div[@id='divStyleSwatchDdl']")).getCssValue("height").equalsIgnoreCase("auto");		
	}
	
	/**
	 * Method to check if Style size is existing
	 * @return true/false	  
	 * @author Wei.Li
	 */
	public boolean judgeStyleSizeAvailable() {
		return this.checkChildElementExistingByAttribute(this.cntProductSizeJudgeIndicator, "id", "divAvailableSizes");		
	}
	
	/**
	 * Method to check if TrueFit part is existing
	 * @return true/false	  
	 * @author Wei.Li
	 */
	public boolean judgeStyleTrueFitExisting() {
		return !this.cntProductTrueFitSection.getCssValue("height").equalsIgnoreCase("0px");
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
	 * Method to get the data style of selected Swatch
	 * @return String	  
	 * @author Wei.Li
	 */
	public String getCurrentSwatchStyle() {
		boolean bDropdownMenuMode=this.judgeStyleDisplayModeIsDropdownMenu();
		if(bDropdownMenuMode) {
			Select dropdownMenuOption=new Select(this.selectProductStyle);
			return dropdownMenuOption.getFirstSelectedOption().getAttribute("value").trim();
		}
		else {
			return this.btnRadioProductStyleSelected.getAttribute("value").trim();
		}		
	}
	
	/**
	 * Method to verify the linkage between Thumbnail and Zoom image
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyLinkageBetweenThumbnailAndZoomImage() {	
		if(this.judgeStyleDisplayModeIsDropdownMenu()) {
			String lsSwatchType;
			boolean bDisabled;
			WebElement element;
			for(WebElement item:this.lstThumbnailImageListForDropdownMenu) {
				bDisabled=false;
				lsSwatchType=item.getAttribute("data-styleid");				
				for(WebElement itemOption:this.lstDropdownProductStyle) {										
					if(itemOption.getAttribute("value").equalsIgnoreCase(lsSwatchType)) {						
						if(this.hasElementAttribute(itemOption, "selected")||itemOption.getAttribute("class").contains("disable")) {
							bDisabled=true;
							break;
						}						
					}
				}
				
				if(!bDisabled) {
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
					element=item.findElement(By.xpath(".//img"));
					element.click();
					this.getReusableActionsInstance().staticWait(500);
					
					String lsThumbnail=this.getImageNameFromThumbnailOrZoomImagePath(lnkCurrentZoomImage.getAttribute("href"));
					String lsZoomImage=this.getImageNameFromThumbnailOrZoomImagePath(imgCurrentThumbnail.getAttribute("src"));
								
					reporter.softAssert(lsThumbnail.equalsIgnoreCase(lsZoomImage), "The Thumbnail image is the same as the Zoom image with changing Swatch style", "The Thumbnail image is not the same as the Zoom image with changing Swatch style");
					reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblImageDisclaim),"The Image disclaim message section is displaying correctly","The Image disclaim message section is not displaying correctly");
				}
			}
		}
		else {
			for(WebElement item:this.lstThumbnailImageList) {			
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
				item.click();
				this.getReusableActionsInstance().staticWait(500);
				
				String lsThumbnail=this.getImageNameFromThumbnailOrZoomImagePath(lnkCurrentZoomImage.getAttribute("href"));
				String lsZoomImage=this.getImageNameFromThumbnailOrZoomImagePath(imgCurrentThumbnail.getAttribute("src"));
							
				reporter.softAssert(lsThumbnail.equalsIgnoreCase(lsZoomImage), "The Thumbnail image is the same as the Zoom image with changing Swatch style", "The Thumbnail image is not the same as the Zoom image with changing Swatch style");
				reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblImageDisclaim),"The Image disclaim message section is displaying correctly","The Image disclaim message section is not displaying correctly");
			}
		}						
	}
	
	/**
	 * Method to verify the Prev button clicking of Thumbnail
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyThumbnailPrevButton() {		
		String lsFirstImageSrcBefore=this.lstThumbnailImageList.get(0).findElement(By.xpath(".//img")).getAttribute("src");
		this.btnThumbnailPrev.click();
		this.getReusableActionsInstance().staticWait(300);
		String lsFirstIamgeSrcAfter=this.lstThumbnailImageList.get(0).findElement(By.xpath(".//img")).getAttribute("src");
		
		reporter.softAssert(!lsFirstImageSrcBefore.equalsIgnoreCase(lsFirstIamgeSrcAfter), "The Prev button clicking is working", "The Prev button clicking is not working");					
	}
	
	/**
	 * Method to verify the Next button clicking of Thumbnail
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyThumbnailNextButton() {
		int imageCount=this.lstThumbnailImageList.size();
		String lsLastImageSrcBefore=this.lstThumbnailImageList.get(imageCount-1).findElement(By.xpath(".//img")).getAttribute("src");
		this.btnThumbnailPrev.click();
		this.getReusableActionsInstance().staticWait(300);
		String lsLastIamgeSrcAfter=this.lstThumbnailImageList.get(imageCount-1).findElement(By.xpath(".//img")).getAttribute("src");
		
		reporter.softAssert(!lsLastImageSrcBefore.equalsIgnoreCase(lsLastIamgeSrcAfter), "The Next button clicking is working", "The Next button clicking is not working");					
	}
	
	/**
	 * Method to verify Thumbnail image list source
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyThumbnailImageListSrc() {
		boolean bEmpty=false;
		for(WebElement item:this.lstThumbnailImageList) {
			if(item.findElement(By.xpath(".//img")).getAttribute("src").isEmpty()) {
				bEmpty=true;
				break;
			}
		}
		reporter.softAssert(!bEmpty,"The Thumbnail image is not empty","The Thumbnail image is empty");
	}
	
	/**
	 * Method to verify the linkage among Swatch style, Thumbnail image and Zoom image
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyLinkageAmongSwathAndThumbnailAndZoomImage() {
		String lsSwatch,lsThumbnail="",lsZoomImage="";
		boolean bDisable=false;		
		int loopSize;		
		if(this.judgeStyleDisplayModeIsDropdownMenu()) {
			Select selectStyle= new Select(this.selectProductStyle);
			loopSize=this.lstDropdownProductStyle.size();	
			String[] lstImageSrc= new String[1];
			for(int i=0;i<loopSize;i++) {
				if(this.hasElementAttribute(this.lstDropdownProductStyle.get(i),"selected")) {
					continue;
				}				
				lstImageSrc[0]="";
				if(!this.hasElementAttribute(this.currentThumbnailItem,"data-video")) {
					lstImageSrc[0]=this.getElementImageSrc(this.imgCurrentThumbnail);
				}	
				
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectProductStyle);
				selectStyle.selectByIndex(i);
								
				this.waitForCondition(Driver->{return !this.getElementImageSrc(this.imgCurrentThumbnail).equalsIgnoreCase(lstImageSrc[0]);}, 30000);
				lsSwatch=this.getCurrentSwatchStyle();	
				
				if(this.lstDropdownProductStyle.get(i).getAttribute("class").contains("disable")) {
					bDisable=true;
				}
				else {
					bDisable=false;
				}
				
				lsZoomImage=this.getImageNameFromThumbnailOrZoomImagePath(lnkCurrentZoomImage.getAttribute("href"));
				lsThumbnail=this.getImageNameFromThumbnailOrZoomImagePath(imgCurrentThumbnail.getAttribute("src"));
				reporter.softAssert(lsThumbnail.toLowerCase().contains(lsSwatch.toLowerCase()), "The Thumbnail image src contains swatch style of " +lsSwatch, "The Thumbnail image src does not contain swatch style of "+lsSwatch);
				if(!bDisable) {
					reporter.softAssert(lsZoomImage.toLowerCase().contains(lsSwatch.toLowerCase()), "The Zoom image src contains swatch style of " +lsSwatch, "The Zoom image src does not contain swatch style of "+lsSwatch);
					reporter.softAssert(lsThumbnail.equalsIgnoreCase(lsZoomImage), "The Thumbnail image is the same as the Zoom image with changing Swatch radio of '"+lsSwatch+"'", "The Thumbnail image is not the same as the Zoom image with changing Swatch radio of '"+lsSwatch+"'");
				}				
			}
		}
		else {
			loopSize=this.lstRadioStyleLabelSpanList.size();
			WebElement radioItem;	
			String[] lstImageSrc= new String[1];
			for(int i=0;i<loopSize;i++) {								
				if(this.hasElementAttribute(this.lstStyleRadioList.get(i),"checked")) {
					continue;
				}
				radioItem=this.lstRadioStyleLabelSpanList.get(i);				
				if(!this.hasElementAttribute(this.currentThumbnailItem,"data-video")) {
					lstImageSrc[0]=this.getElementImageSrc(this.imgCurrentThumbnail);
				}
				
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(radioItem);
				radioItem.click();
				this.waitForCondition(Driver->{return !this.getElementImageSrc(this.imgCurrentThumbnail).equalsIgnoreCase(lstImageSrc[0]);}, 30000);
							
				lsSwatch=this.getCurrentSwatchStyle();			
				lsThumbnail=this.getImageNameFromThumbnailOrZoomImagePath(lnkCurrentZoomImage.getAttribute("href"));
				lsZoomImage=this.getImageNameFromThumbnailOrZoomImagePath(imgCurrentThumbnail.getAttribute("src"));
				
				reporter.softAssert(lsThumbnail.toLowerCase().contains(lsSwatch.toLowerCase()), "The Thumbnail image src contains swatch style of " +lsSwatch, "The Thumbnail image src does not contain swatch style of "+lsSwatch);
				reporter.softAssert(lsZoomImage.toLowerCase().contains(lsSwatch.toLowerCase()), "The Zoom image src contains swatch style of " +lsSwatch, "The Zoom image src does not contain swatch style of "+lsSwatch);
				reporter.softAssert(lsThumbnail.equalsIgnoreCase(lsZoomImage), "The Thumbnail image is the same as the Zoom image with changing Swatch radio of '"+lsSwatch+"'", "The Thumbnail image is not the same as the Zoom image with changing Swatch radio of '"+lsSwatch+"'");
			}
		}		
	}
	
	/**
	 * Method to verify the linkage among Swatch style, Thumbnail image and Zoom image
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyStyleNameWithDifferentStyleSelection() {
		String lsSwatch,lsBeforeStyleName,lsAfterStyleName;
		int loopSize;
		if(this.judgeStyleDisplayModeIsDropdownMenu()) {			
			Select selectStyle= new Select(this.selectProductStyle);			
			loopSize=this.lstDropdownProductStyle.size();	
			String[] lstImageSrc= new String[1];
			for(int i=0;i<loopSize;i++) {
				if(this.hasElementAttribute(this.lstDropdownProductStyle.get(i),"selected")) {
					continue;
				}				
				if(!this.hasElementAttribute(this.currentThumbnailItem,"data-video")) {
					lstImageSrc[0]=this.getElementImageSrc(this.imgCurrentThumbnail);
				}
								
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectProductStyle);
				lsBeforeStyleName=selectStyle.getFirstSelectedOption().getText();
				selectStyle.selectByIndex(i);
				this.waitForCondition(Driver->{return !this.getElementImageSrc(this.imgCurrentThumbnail).equalsIgnoreCase(lstImageSrc[0]);}, 30000);
				lsAfterStyleName=selectStyle.getFirstSelectedOption().getText();			
				lsSwatch=this.getCurrentSwatchStyle();				
				reporter.softAssert(!lsBeforeStyleName.equalsIgnoreCase(lsAfterStyleName), "Clicking the swatch dropdown option of '"+lsSwatch+"' is changing product style name", "Clicking the swatch dropdown option of '"+lsSwatch+"' is not changing product style name");
			}
		}
		else {			
			loopSize=this.lstRadioStyleLabelSpanList.size();
			WebElement radioItem,labelItem;
			String lsLabelTitle;	
			String[] lstImageSrc= new String[1];
			for(int i=0;i<loopSize;i++) {
				if(this.hasElementAttribute(this.lstStyleRadioList.get(i),"checked")) {
					continue;
				}
				radioItem=this.lstRadioStyleLabelSpanList.get(i);
				labelItem=this.lstRadioStyleLabelList.get(i);				
				if(!this.hasElementAttribute(this.currentThumbnailItem,"data-video")) {
					lstImageSrc[0]=this.getElementImageSrc(this.imgCurrentThumbnail);
				}				
				
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(labelItem);
				lsBeforeStyleName=this.lblRadioProductStyleTitle.getText().trim();				
				radioItem.click();
				this.waitForCondition(Driver->{return !this.getElementImageSrc(this.imgCurrentThumbnail).equalsIgnoreCase(lstImageSrc[0]);}, 30000);
				lsAfterStyleName=this.lblRadioProductStyleTitle.getText().trim();				
				lsLabelTitle=labelItem.getAttribute("title").trim();
				lsSwatch=this.getCurrentSwatchStyle();	
								
				reporter.softAssert(!lsBeforeStyleName.equalsIgnoreCase(lsAfterStyleName), "Clicking the swatch radio option of '"+lsSwatch+"' is changing product style name", "Clicking the swatch radio option of '"+lsSwatch+"' is not changing product style name");
				reporter.softAssert(lsLabelTitle.equalsIgnoreCase(lsAfterStyleName), "The label title is equal to product style name of '"+lsAfterStyleName+"'", "The label title is not equal to product style name of '"+lsAfterStyleName+"'");	
			}
		}		
	}
	
	/**
	 * Method to find image name in Thumbnail or Zoom image path
	 * @param String lsPath: path String
	 * @return String	  
	 * @author Wei.Li
	 */
	public String getImageNameFromThumbnailOrZoomImagePath(String lsPath) {
		String[] lstSubItem=lsPath.split("/");		
		return lstSubItem[lstSubItem.length-1].split("\\?")[0];
	}
	
	
	
	/**
	 * Method to judge if Soldout section is displaying	 
	 * @return boolean	  
	 * @author Wei.Li
	 */
	public boolean IsSoldOutExisting() {		
		return !this.lblSoldOut.findElement(By.xpath("./span")).getAttribute("class").contains("hidden");
	}
	
	/**
	 * Method to judge if Quantity left section is displaying	 
	 * @return boolean	  
	 * @author Wei.Li
	 */
	public boolean IsQuantityLeftExisting() {	
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectQuantityOption);
		return !this.lblQuantityLeft.findElement(By.xpath("./span")).getText().isEmpty();
	}

	/**
	 * Method to go to Review tab
	 * @return true/false	  
	 * @author Wei.Li
	 */
	public boolean goToProductReviewTab() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productReviewSection);
		this.productReviewSection.click();
		return this.waitForCondition(Driver->{return this.btnStickyTabProductReview.getAttribute("class").contains("selected");},5000);		
	}
	
	/**
	 * Method to judge if the sticky Tab is selected
	 * @return true/false	  
	 * @author Wei.Li
	 */
	public boolean getStickyTabSelectedStatus(WebElement btnTab) {		
		return btnTab.getAttribute("class").contains("selected");
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
	 * Method to choose review sorting option
	 * @param String lsReviewSortingOption: review option
	 * @return void
	 * @author Wei.Li
	 */
	public void chooseReviewSortingOption(String lsReviewSortingOption) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectReviewTabSortBy);
		Select reviewSortings=new Select(this.selectReviewTabSortBy); 
		reviewSortings.selectByVisibleText(lsReviewSortingOption);
		this.getReusableActionsInstance().staticWait(1000);
	}
	
	/**
	 * Method to verify Review Tab list related contents
	 * @return void	  
	 * @author Wei.Li
	 */
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
	
	/**
	 * Method to check Review rate sorting function
	 * @param boolean bHighestRateFirst: true for Highest rated sorting while false for Lowest rated sorting
	 * @return String	  
	 * @author Wei.Li
	 */
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

	/**
	 * Method to switch to TrueFit iFrame
	 * @return void	  
	 * @author Wei.Li
	 */
	public void switchToTrueFitIFrame() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkProductTrueFitLink);
		this.lnkProductTrueFitLink.click();
		this.waitForCondition(Driver->{return this.iframeProductTrueFitLoadingIndicator.getAttribute("style").contains("display: block");}, 30000);
		this.getDriver().switchTo().frame(this.iframeProductTrueFit);
	}
	

}
