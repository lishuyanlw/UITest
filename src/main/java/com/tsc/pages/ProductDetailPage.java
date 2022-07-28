package com.tsc.pages;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.apiBuilder.ProductAPI;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.util.JsonParser;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.tsc.api.apiBuilder.ApiResponse;
import com.tsc.api.pojo.Product;
import com.tsc.api.pojo.ProductDetailsItem;
import com.tsc.api.pojo.SelectedProduct;
import com.tsc.pages.base.BasePage;

public class ProductDetailPage extends BasePage {

	public ProductDetailPage(WebDriver driver) {
		super(driver);

	}

	//@FindBy(xpath = "//section[@class='pdp-gallery']")
	//public WebElement cntLeftContainer;

	@FindBy(xpath = "//section[@class='pdp-description']")
	public WebElement cntRightContainer;

	//Thumbnail part
	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@id='thumbGallery']")
	public WebElement cntThumbnailContainer;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@id='thumbGallery']//button[contains(@class,'gallery-button-prev')]")
	public WebElement btnThumbnailPrev;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@id='thumbGallery']//button[contains(@class,'gallery-button-next')]")
	public WebElement btnThumbnailNext;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@id='thumbGallery']//div[@id='pdp__galleryThumb']//button[contains(@class,'swiper-slide-visible')]")
	public List<WebElement> lstThumbnailImageList;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@id='thumbGallery']//div[@id='pdp__galleryThumb']//button[contains(@class,'swiper-slide-visible')][@data-styleid]")
	public List<WebElement> lstThumbnailImageButtonWithoutVideoList;

	/**
	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@id='thumbGallery']//div[@id='pdp__galleryThumb']//button[contains(@class,'swiper-slide-visible')][@data-styleid]//img")
	public List<WebElement> lstThumbnailImageWithoutVideoList;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@id='thumbGallery']//div[@id='pdp__galleryThumb']//button[contains(@class,'swiper-slide-thumb-active')][@data-styleid]//img")
	public WebElement imgCurrentThumbnail;
	*/
	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@id='thumbGallery']//div[@id='pdp__galleryThumb']//button[contains(@class,'swiper-slide-thumb-active')][@data-styleid]")
	public WebElement currentThumbnailItem;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@id='thumbGallery']//div[@id='pdp__galleryThumb']//button[contains(@class,'swiper-slide-visible')][@data-video]")
	public List<WebElement> lstThumbnailVideoLink;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@id='thumbGallery']//div[@id='pdp__galleryThumb']//button[contains(@class,'swiper-slide-visible')][@data-video]//img")
	public List<WebElement> lstThumbnailVideoImage;

	//Video part
	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@class='video-container']")
	public WebElement videoBoxControl;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@class='video-container']//div[contains(@class,'video-item__video')]")
	public WebElement lnkVideo;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@class='video-container']//p[@class='video-item__video-desc']")
	public WebElement lblVideoDisclaim;

	//@FindBy(xpath = "//section[@class='pdp-gallery']//div[@class='video-container']//label[@class='video-item__auto-play__text']")
	//public WebElement lblAutoPlayVideo;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@class='video-container']//input[@class='video-item__auto-play__checkbox']")
	public WebElement btnAutoPlayVideo;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@class='video-container']//button[@class='video-item__auto-play__info']")
	public WebElement lnkAutoPlayVideoToolTip;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@class='video-container']//span[@class='video-item__auto-play__tooltip-content__text']")
	public WebElement lblAutoPlayVideoToolTipPopupMsg;

	@FindBy(xpath = "//section[@class='pdp-gallery']//div[@class='video-container']//button[@class='video-item__auto-play__tooltip-content__close-button']")
	public WebElement btnAutoPlayVideoToolTipPopupMsgClose;

	//Zoom Image part
	@FindBy(xpath = "//section[@class='pdp-gallery']//figure[contains(@class,'swiper-slide-active')]")
	public WebElement currentZoomImageIndicator;

	@FindBy(xpath = "//section[@class='pdp-gallery']//figure[contains(@class,'swiper-slide-active')]//a[contains(@class,'gallery__image--aspect-ratio-wrap')]")
	public WebElement lnkCurrentZoomImage;

	//@FindBy(xpath = "//section[@class='pdp-gallery']//figure[contains(@class,'swiper-slide-active')]//a[contains(@class,'gallery__image--aspect-ratio-wrap')]//img")
	//public WebElement imgCurrentZoomImage;

	//Added new xpath for changes on PDP page for Integration as per new design
	//Product details
	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__brand-and-reviews']")
	public WebElement cntProductDetailsBrandAndReviewContainer;

	@FindBy(xpath = "//section[@class='pdp-description']//span[@class='pdp-description__badges--badge']")
	public WebElement imgProductBadge;

	@FindBy(xpath = "//section[@class='pdp-description']//*[@id='lblProductName']")
	public WebElement lblProductName;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__brand-and-reviews']/div[@id='divBrandName']/a")
	public WebElement lnkBrandName;

	@FindBy(xpath = "//section[@class='pdp-description']//span[@id='lblItemNo']")
	public WebElement lblProductNumber;

	//Review part
	@FindBy(xpath = "//section[@class='pdp-description']//a[@class='pr-snippet-review-count']")
	public WebElement productReviewSection;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pr-snippet-stars-container']//div[contains(@class,'pr-star-v4')]")
	public List<WebElement> lstProductReviewStar;

	@FindBy(xpath = "//section[@class='pdp-description']//section[contains(@class,'pr-review-snippet-container')]")
	public WebElement lblProductReview;

	@FindBy(xpath = "//section[@class='pdp-description']//a[@class='pr-snippet-review-count']")
	public WebElement lblProductReviewCount;

	@FindBy(xpath = "//div[@id='pr-reviewdisplay']//div[@class='pr-irlsnippet']/div")
	public WebElement lblReviewPicturesInHistogram;

	@FindBy(xpath = "//div[@class='pr-media-modal']/section[@class='modal__body']/button")
	public WebElement lblReviewImagePopUpModelCloseButton;

	@FindBy(xpath = "//section[@class='pr-media-card pr-media-card-in']//picture/img")
	public WebElement lblReviewImageOnPopUpWindow;

	@FindBy(xpath = "//section[@class='pr-media-card pr-media-card-in']//div[contains(@class,'text-stars')]//div[@class='pr-snippet-rating-decimal']")
	public WebElement lblReviewStarsOnPopUpWindow;

	@FindBy(xpath = "//section[@class='pr-media-card pr-media-card-in']//p[contains(@class,'text-headline')]")
	public WebElement lblReviewHeadlineOnPopUpWindow;

	@FindBy(xpath = "//section[@class='pr-media-card pr-media-card-in']//p[contains(@class,'text-comments')]")
	public WebElement lblReviewCommentOnPopUpWindow;

	@FindBy(xpath = "//section[@class='pr-media-card pr-media-card-in']//p[contains(@class,'text-date')]")
	public WebElement lblReviewPostedDateOnPopUpWindow;

	@FindBy(xpath = "//section[@class='pr-media-card pr-media-card-in']//button[contains(@class,'text-readreview')]")
	public WebElement btnReadReviewOnPopUpWindowBtn;

	@FindBy(xpath = "//section[@class='pr-media-card pr-media-card-in']//footer//div[@class='pr-media-card-footer-flagging']/a")
	public WebElement lnlFlagImageOnPopUpWindow;

	@FindBy(xpath = "//form[@id='pr-flag-reviews']//button[contains(@class,'cancel')]")
	public WebElement btnFlagImagePopUpWindowCancelButton;

	@FindBy(xpath = "//form[@id='pr-flag-reviews']//input[@id='pr-email-field']")
	public WebElement lblFlagImageEmailText;

	//Read Review on Review Pop-Up
	@FindBy(xpath = "//div[contains(@class,'pr-read-review pr-read-review-in pr-read-review-flagging-in')]/button")
	public WebElement btnBackToMediaBtn;

	@FindBy(xpath="//div[contains(@class,'pr-read-review pr-read-review-in pr-read-review-flagging-in')]/div[@class='pr-review']/section/p")
	public WebElement lblComment;

	@FindBy(xpath="//div[contains(@class,'pr-read-review pr-read-review-in pr-read-review-flagging-in')]/div[@class='pr-review']/section/div//p[contains(@class,'nickname')]/span")
	public WebElement lblCommentBy;

	//Price part
	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__prices--layout']")
	public WebElement cntProductPriceContainer;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__prices--is-price']")
	public WebElement lblProductNowPrice;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__prices--was-price']")
	public WebElement lblProductWasPrice;

	//EasyPay part
	@FindBy(xpath = "//section[@class='pdp-description']//div[@id='divEasyPayment']")
	public WebElement lblProductEasyPay;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@id='divEasyPayment']//button[contains(@class,'pay')]")
	public WebElement btnProductEasyPay;

	//For EasyPay popup
	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-easy-pay-popup']//button[@class='pdp-easy-pay-popup__card__close-button']")
	public WebElement btnProductEasyPayPopupClose;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-easy-pay-popup']//h2[@class='pdp-easy-pay-popup__card__copy-heading']")
	public WebElement lblProductEasyPayPopupHeading;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-easy-pay-popup']//div[@class='pdp-easy-pay-popup__content']")
	public WebElement lblProductEasyPayPopupContent;

	//Shipping part
	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__prices__saving-and-shipping']")
	public WebElement cntProductShippingAndSavingsContainer;

	@FindBy(xpath = "//section[@class='pdp-description']//span[@class='pdp-description__prices__saving-and-shipping__savings-amount']")
	public WebElement lblProductSavings;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__prices__saving-and-shipping']")
	public WebElement lblProductShipping;

	//Delivery Options
	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__auto-delivery__selections']/b")
	public WebElement lblProductDeliveryOptionsTitle;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__auto-delivery__selections']/select")
	public WebElement drpProductDeliveryOptionsMenu;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__auto-delivery__selections']/select/option")
	public List<WebElement> lstProductDeliveryOptionList;
	//All changes for new xpath as per design change are ended here

	//Style part
	@FindBy(xpath = "//section[@class='pdp-description']//form[@class='pdp-description__form']")
	public WebElement cntProductStyleAndSizeJudgeIndicator;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__form__colours__selections')]")
	public WebElement cntProductStyleSection;

	//For radio style
	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__colours__selected']")
	public WebElement lblRadioProductStyleStatic;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__colours__selected']")
	public WebElement lblRadioProductStyleTitle;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__form__colours__selections')]//button")
	public List<WebElement> lstAllStyleRadioList;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__form__colours__selections')]//button//label")
	public List<WebElement> lstAllStyleLabelRadioList;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__form__colours__selections')]//button[not(contains(@class,'pdp-description__form__colours--disabled'))]")
	public List<WebElement> lstStyleRadioList;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__form__colours__selections')]//button[not(contains(@class,'pdp-description__form__colours--disabled'))]//label")
	public List<WebElement> lstRadioStyleLabelList;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__form__colours__selections')]//button[not(contains(@class,'pdp-description__form__colours--disabled'))]//label//span")
	public List<WebElement> lstRadioStyleLabelSpanList;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__form__colours__selections')]//button[not(contains(@class,'pdp-description__form__colours--disabled'))][@aria-pressed='true']//label")
	public WebElement btnRadioProductStyleSelectedLabel;

	@FindBy(xpath = "//div[@id='product-details-page']//div[contains(@class,'pdp-description__form__colour')]/button[not(contains(@class,'option--selected'))]")
	public List<WebElement> lstRadioStyleLabelNotSelectedList;

	//For dropdown menu style
	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__colours__selected']")
	public WebElement lblDropDownProductStyleStatic;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__form__colours__selections')]//select")
	public WebElement selectProductStyle;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__form__colours__selections')]//select//option[not(@disabled)]")
	public List<WebElement> lstDropdownProductStyle;

	//TrueFit part
	//@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__size-chart-wrapper']")
	//public WebElement cntProductTrueFitAndSizingSection;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__size-chart-wrapper']//div[@class='tfc-fitrec-product']")
	public WebElement cntProductTrueFitSection;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__size-chart-wrapper']//div[@class='tfc-cfg-logo']")
	public WebElement imgProductTrueFitLogo;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__size-chart-wrapper']//a[@class='tfc-popup-click-open']")
	public WebElement lnkProductTrueFitLink;

	//TrueFit iframe part
	@FindBy(xpath = "//iframe[@title='True Fit'][@src]")
	public WebElement iframeProductTrueFit;

	@FindBy(xpath = "//div[contains(@class,'tfc-cfg-modal') and contains(@class,'tfc-popup-wrap')]")
	public WebElement iframeProductTrueFitLoadingIndicator;

	//@FindBy(xpath = "//div[contains(@class,'tfp-app')]")
	//public WebElement cntProductTrueFitIframe;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//button[contains(@aria-label,'Close True Fit')][img]")
	public WebElement btnProductTrueFitIframeClose;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//button[contains(@aria-label,'Sign in to True Fit')]")
	public WebElement lnkProductTrueFitIframeSignIn;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//button[contains(@aria-label,'Sign in to True Fit')]//img")
	public WebElement imgProductTrueFitIframeHeaderLogo;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']//img[contains(@class,'t-logo')]")
	public WebElement imgProductTrueFitIframePage;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']//div[@class='prompt-title']")
	public WebElement lblProductTrueFitIframePageTitle;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']//div[@class='prompt-subtitle']")
	public WebElement lblProductTrueFitIframePageSubTitle;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']")
	public WebElement cntProductTrueFitIframePageMainContent;

	//Brand prompt
	/**
	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']//button[@aria-label='Search all brands']")
	public WebElement btnProductTrueFitIframePageSearchAllBrands;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='suggested-brands-paged-wrapper']")
	public WebElement cntProductTrueFitIframeSuggestedBrandContainer;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']//div[@class='suggested-brands-paged']//button")
	public List<WebElement> lstProductTrueFitIframeSuggestedBrandList;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']//button[contains(@class,'prev')]")
	public WebElement btnProductTrueFitIframePagePrevButton;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']//button[contains(@class,'prev')]//img")
	public WebElement imgProductTrueFitIframePagePrevButton;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']//button[contains(@class,'next')]")
	public WebElement btnProductTrueFitIframePageNextButton;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']//button[contains(@class,'next')]//img")
	public WebElement imgProductTrueFitIframePageNextButton;

	//Height prompt
	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']//div[contains(@class,'height')]//div[@class='slider-input-box']//input[1]")
	public WebElement inputProductTrueFitIframeMeasureInput1;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='main-content']//div[contains(@class,'height')]//div[@class='slider-input-box']//input[2]")
	public WebElement inputProductTrueFitIframeMeasureInput2;
	*/

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='footer']")
	public WebElement lblProductTrueFitIframeConfirmMessage;

	@FindBy(xpath = "//div[contains(@class,'tfp-app')]//div[@class='footer']//a")
	public WebElement lnkProductTrueFitIframePrivacyPolicy;

	//Size part
	@FindBy(xpath = "//section[contains(@class,'pdp-description']//div[@class='pdp-description__form__sizes__selections')]")
	public WebElement cntProductSizeSection;

	@FindBy(xpath="//div[@id='product-details-page']//div[@class='pdp-description__form__sizes__selected']/b")
	public WebElement lblSelectedSize;

	@FindBy(xpath="//div[@id='product-details-page']//div[contains(@class,'pdp-description__form__sizes')]/button[contains(@class,'option--selected')]")
	public WebElement lblSelectedDefaultSize;

	@FindBy(xpath="//div[@id='product-details-page']//div[contains(@class,'pdp-description__form__colours')]/button[contains(@class,'option--selected')]")
	public WebElement lblSelectedDefaultColour;

	//For radio style
	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__sizes__selected']")
	public WebElement lblSizeStatic;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__sizes__selected']")
	public WebElement lblSizeTitle;

	@FindBy(xpath = "//section[contains(@class,'pdp-description')]//div[contains(@class,'pdp-description__form__sizes__selections')]//button")
	public List<WebElement> lstAllSizeRadioList;

	@FindBy(xpath = "//section[contains(@class,'pdp-description')]//div[contains(@class,'pdp-description__form__sizes__selections')]//button//label")
	public List<WebElement> lstAllSizeLabelRadioList;

	//@FindBy(xpath = "//section[contains(@class,'pdp-description')]//div[contains(@class,'pdp-description__form__sizes__selections')]//button[not(contains(@class,'pdp-description__form__sizes--disabled'))]")
	//public List<WebElement> lstSizeRadioList;

	@FindBy(xpath = "//section[contains(@class,'pdp-description')]//div[contains(@class,'pdp-description__form__sizes__selections')]//button[not(contains(@class,'pdp-description__form__sizes--disabled'))]//label")
	public List<WebElement> lstRadioSizeLabelList;

	@FindBy(xpath = "//section[contains(@class,'pdp-description')]//div[contains(@class,'pdp-description__form__sizes__selections')]//button[not(contains(@class,'pdp-description__form__sizes--disabled'))]//label//span")
	public List<WebElement> lstRadioSizeLabelSpanList;

	@FindBy(xpath="//div[@id='product-details-page']//div[contains(@class,'pdp-description__form__sizes')]/button[not(contains(@class,'option--selected')) and not(contains(@class,'sizes--disabled'))]")
	public List<WebElement> lstRadioSizeLabelNotSelectedList;

	/**@FindBy(xpath = "//section[contains(@class,'pdp-description')]//div[contains(@class,'pdp-description__form__sizes__selections')]//button[not(contains(@class,'pdp-description__form__sizes--disabled'))][input[@checked]]")
	public WebElement btnRadioProductSizeSelected;

	//For dropdown menu style
	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__sizes__selected']")
	public WebElement lblDropDownProductSizeStatic;
	*/
	@FindBy(xpath = "//section[contains(@class,'pdp-description')]//div[contains(@class,'pdp-description__form__sizes__selections')]//select")
	public WebElement selectSizeOption;
	/**
	@FindBy(xpath = "//section[contains(@class,'pdp-description')]//div[contains(@class,'pdp-description__form__sizes__selections')]//select//option[not(@disabled)]")
	public List<WebElement> lstSizeOption;
	*/
	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__form__size-chart-wrapper']//button[@class='pdp-description__form__size-chart-link']")
	public WebElement lnkSizingChart;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__add-to-bag')]//div[contains(@class,'pdp-description__add-to-bag__quantity')]//span[@class='pdp-description__out-of-stock__text']")
	public WebElement lblSoldOut;

	//Quantity part
	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__add-to-bag')]//div[@class='pdp-description__add-to-bag__quantity']/span")
	public WebElement cntQuantityTitleContainer;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__add-to-bag')]//div[contains(@class,'pdp-description__add-to-bag__quantity')]//span[@class='pdp-description__add-to-bag__quantity__self']")
	public WebElement lblQuantityStatic;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__add-to-bag')]//div[contains(@class,'pdp-description__add-to-bag__quantity')]//select")
	public WebElement selectQuantityOption;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__add-to-bag')]//div[contains(@class,'pdp-description__add-to-bag__quantity')]//select//option[last()]")
	public WebElement lblQuantityLastOption;

	@FindBy(xpath = "//section[@class='pdp-description']//div[contains(@class,'pdp-description__add-to-bag')]//div[contains(@class,'pdp-description__add-to-bag__quantity')]//span[@class='pdp-description__add-to-bag__quantity__count--critic-stock']")
	public WebElement lblQuantityLeft;

	//For new designed Add To Bag button
	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__add-to-bag']//button[@class='pdp-description__add-to-bag__add-to-bag-button']")
	public WebElement btnAddToBag;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__advance-order']")
	public WebElement lblAdvanceOrderMsg;

	@FindBy(xpath="//div[@id='product-details-page']//div[contains(@class,'add-to-bag__quantity')]/span")
	public WebElement lblAvailableQuantity;

	@FindBy(xpath = "//div[@id='product-details-page']//div[contains(@class,'add-to-bag__quantity')]//span[contains(@class,'stock')]")
	public WebElement lblAvailableQuantityNumber;

	//Add to favorites
	@FindBy(xpath = "//section[@class='pdp-description']//span[@class='pdp-description__add-to-bag__favorite__text']")
	public WebElement lblAddToFavoriteText;

	@FindBy(xpath = "//section[@class='pdp-description']//button[@class='pdp-description__add-to-bag__favorite__icon-wrapper']")
	public WebElement lnkFavIcon;

	//For popup window after clicking Fav Icon
	//@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__add-to-bag__favorite__tooltip']//span[@class='pdp-description__add-to-bag__favorite__tooltip-content__text']")
	//public WebElement lblFavIconPopupContent;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__add-to-bag__favorite__tooltip']//span[@class='pdp-description__add-to-bag__favorite__tooltip-content__text']//a[@class='pdp-description__add-to-bag__favorite__tooltip__sign-in']")
	public WebElement lnkFavIconPopupSignIn;

	@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__add-to-bag__favorite__tooltip']//span[@class='pdp-description__add-to-bag__favorite__tooltip-content__text']//a[@class='pdp-description__add-to-bag__favorite__tooltip__register']")
	public WebElement lnkFavIconPopupRegister;

	/**@FindBy(xpath = "//section[@class='pdp-description']//div[@class='pdp-description__add-to-bag__favorite__tooltip']//button[@class='pdp-description__add-to-bag__favorite__tooltip-content__close-button']")
	public WebElement btnFavIconPopupClose;

	//For Accordions
	@FindBy(xpath = "//div[@id='accordion']//div[@class='field-wrapper']")
	public List<WebElement> lstAccordionSections;
	*/
	@FindBy(xpath = "//div[@id='accordion']//div[@class='field-wrapper']//div[@class='field-wrapper__accordion-heading']//span[@class='field-wrapper__accordion-heading__text']")
	public List<WebElement> lstAccordionSectionHeadings;

	//@FindBy(xpath = "//div[@id='accordion']//div[@class='field-wrapper']//div[@class='field-wrapper__content-wrapper']")
	//public List<WebElement> lstAccordionSectionContents;

	//Product Review Tab part
	@FindBy(xpath = "//*[contains(@class,'customer-reviews')]")
	public WebElement lblReviewTabHeader;

	@FindBy(xpath = "//section[@class='pr-review-snapshot-block pr-review-snapshot-block-histogram']//ul//li")
	public List<WebElement> lstReviewTabHistogramItem;

	@FindBy(xpath = "//section[@class='pr-review-snapshot-block pr-review-snapshot-block-histogram']//ul//li//div[contains(@class,'pr-histogram-stars')]")
	public List<WebElement> lstReviewTabHistogramClickingButton;

	@FindBy(xpath = "//section[@class='pr-review-snapshot-block pr-review-snapshot-block-histogram']//ul//li//p[@class='pr-histogram-label']")
	public List<WebElement> lstReviewTabHistogramItemLabel;

	@FindBy(xpath = "//section[@class='pr-review-snapshot-block pr-review-snapshot-block-histogram']//ul//li//p[@class='pr-histogram-count']")
	public List<WebElement> lstReviewTabHistogramItemCount;
	@FindBy(xpath = "//div[@id='pr-reviewdisplay']//section[@id='pr-review-snapshot']//div[@class='pr-review-snapshot-histogram']")
	public WebElement imgReviewTabHistogram;

	@FindBy(xpath = "//div[@id='pr-reviewdisplay']//section[@id='pr-review-snapshot']//div[@class='pr-review-snapshot-histogram']//p[contains(@class,'histogram-count')]")
	public List<WebElement> lstHistogramReviewsCountForStars;

	@FindBy(xpath = "//section[@id='pr-review-snapshot']//div[@class='pr-snippet-stars-reco-stars']//div[@class='pr-snippet-rating-decimal']")
	public WebElement lblReviewTabRateDecimalText;

	@FindBy(xpath = "//section[@id='pr-review-snapshot']//div[@class='pr-snippet-stars-reco-stars']//div[@class='pr-rating-stars']")
	public List<WebElement> lstReviewTabStar;

	//@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-snapshot']//div[@class='pr-snippet-stars-reco-stars']//span[@class='pr-accessible-text']")
	//public WebElement lblReviewTabStarAccessibleText;

	@FindBy(xpath = "//section[@id='pr-review-snapshot']//div[@class='pr-snippet-read-and-write']/span")
	public WebElement lblReviewTabReviewCount;

	@FindBy(xpath = "//section[@id='pr-review-snapshot']//a[contains(@href,'writereview')]")
	public WebElement lnkReviewTabWriteReview;

	@FindBy(xpath = "//div[@id='pr-reviewdisplay']//section[@id='pr-review-display']//select[@id='pr-rd-sort-by']")
	public WebElement selectReviewTabSortBy;

	//Review list part
	@FindBy(xpath = "//div[@id='pr-reviewdisplay']//section[@id='pr-review-display']//div[@class='pr-review']")
	public List<WebElement> lstReviewTabPerReviewList;

	@FindBy(xpath = "//div[@class='pr-review-snapshot-histogram']//li[@class='pr-ratings-histogram-list-item']//div[@class='pr-histogram-cross']/span")
	public WebElement lblReviewHistogramCrossButton;

	/**public By byReviewTabHeader=By.xpath(".//header");

	public By byReviewTabDescriptionSection=By.xpath(".//section[contains(@class,'pr-rd-description')]");

	public By byReviewTabImagesSection=By.xpath(".//div[@class='pr-rating-stars']");

	public By byReviewTabRatingDecimal=By.xpath(".//div[@class='pr-snippet-rating-decimal']");

	public By byReviewTabReviewAccessibleText=By.xpath(".//span[@class='pr-accessible-text']");

	public By byReviewTabAuthorLocation=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-rd-author-location')]");
	*/
	public By byReviewRatingStarDecimal=By.xpath(".//div[@class='pr-rating-stars']/div[contains(@class,'100-filled')]");

	public By byReviewTabFooter=By.xpath(".//footer");

	public By byReviewTabStarSection=By.xpath(".//div[@class='pr-rating-stars']");

	public By byReviewTabStarList=By.xpath(".//div[@class='pr-rating-stars']//div[contains(@class,'pr-star-v4')]");

	public By byReviewTabHeadingLine=By.xpath(".//*[@class='pr-rd-review-headline']");

	public By byReviewTabRightPartSection=By.xpath(".//div[contains(@class,'pr-rd-right')]");

	public By byReviewTabSubmittedTime=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-rd-author-submission-date')]/time");

	public By byReviewTabNickName=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-rd-author-nickname')]");

	public By byReviewTabVerifiedBuyerIcon=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-verified_buyer')]//span[contains(@class,'pr-badging-icon')]");

	public By byReviewTabVerifiedBuyerText=By.xpath(".//section[contains(@class,'pr-rd-description')]//div[contains(@class,'pr-rd-right')]//p[contains(@class,'pr-verified_buyer')]//span[contains(@class,'pr-rd-badging-text')]");

	public By byReviewTabDescriptionText=By.xpath(".//p[contains(@class,'pr-rd-description-text')]");

	public By byReviewTabImage=By.xpath(".//section[contains(@class,'pr-rd-images')]");

	//Review Tab footer part
	@FindBy(xpath = "//div[@id='pr-reviewdisplay']//section[@id='pr-review-display']//footer[@class='pr-rd-main-footer']//p[@class='pr-rd-review-position']")
	public WebElement lblReviewTabDisplayingReviewMsg;

	@FindBy(xpath = "//div[@id='pr-reviewdisplay']//section[@id='pr-review-display']//footer[@class='pr-rd-main-footer']//a[contains(@class,'pr-rd-to-top')]")
	public WebElement lnkReviewTabBackToTop;

	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-display']//div[@class='pr-rd-pagination']")
	public WebElement cntReviewTabPagination;

	/**@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-display']//a[@aria-label='Previous']")
	public WebElement lnkReviewTabPrev;

	@FindBy(xpath = "//div[@id='productReviewSection']//section[@id='pr-review-display']//a[@aria-label='Next']")
	public WebElement lnkReviewTabNext;
	*/
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

	//@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-file-input-btn-group')]//input[@id='pr-media_image']")
	//public WebElement inputWriteReviewUploadImage;

	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-file-input-btn-group')]//button")
	public WebElement btnWriteReviewUploadImage;

	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-media_videourl-form-group')]//label")
	public WebElement lblWriteReviewAddVideo;

	//@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-file-input-btn-group')]//input[@id='pr-media_videourl']")
	//public WebElement inputWriteReviewUploadVideo;

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

	@FindBy(xpath = "//div[@class='pr-form-control-error-wrapper']//*[@class='pr-form-control-error-icon']")
	public List<WebElement> lstWriteReviewErrorIcon;

	//@FindBy(xpath = "//div[@role='alert'][div]")
	//public WebElement cntWriteReviewAlert;

	@FindBy(xpath = "//div[@role='alert']//*[@class='pr-alert_heading']")
	public WebElement lblWriteReviewAlertHeading;

	@FindBy(xpath = "//div[@role='alert']//ul//li")
	public List<WebElement> lstWriteReviewAlertInfo;

	//After submit review message
	@FindBy(xpath = "//div[@class='thank-you-page']//*[@class='title']")
	public WebElement lblWriteReviewAfterSubmitPageTitle;

	@FindBy(xpath = "//div[@class='thank-you-page']//*[@class='subtitle']")
	public WebElement lblWriteReviewAfterSubmitPageSubTitle;

	@FindBy(xpath = "//div[@class='thank-you-page']//a[@href]")
	public WebElement lnkWriteReviewAfterSubmitPageContinueShopping;

	//Add to Bag popup window part
	@FindBy(xpath = "//div[@class='secondary-navigation__popup-container']")
	public WebElement cntAddToBagOverlay;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//button[@class='add-to-bag__button-close']")
	public WebElement btnAddToBagPopupWindowClose;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag-title']")
	public WebElement lblAddToBagPopupWindowTitle;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']")
	public WebElement cntAddToBagPopupWindowDetailsLeftSectionImage;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']//div[@class='badgeWrap']//img")
	public WebElement imgAddToBagPopupWindowDetailsProductBadge;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']//a")
	public WebElement lnkAddToBagPopupWindowDetailsProductImage;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']//a//img")
	public WebElement imgAddToBagPopupWindowDetailsProductImage;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']")
	public WebElement lnkAddToBagPopupWindowDetailsProductInfo;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//a[@class='add-to-bag__item-link']")
	public WebElement cntAddToBagPopupWindowDetailsItemLink;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']//span[@class='add-to-bag__product-name']")
	public WebElement lblAddToBagPopupWindowDetailsProductName;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']//span[@class='add-to-bag__product-style']")
	public WebElement lblAddToBagPopupWindowDetailsProductStyle;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']//span[@class='add-to-bag__product-size']")
	public WebElement lblAddToBagPopupWindowDetailsProductSize;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//div[@class='add-to-bag__product-number']")
	public WebElement lblAddToBagPopupWindowDetailsProductNumber;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__button-wrap']//div[contains(@class,'add-to-bag__subtotal')]")
	public WebElement lblAddToBagPopupWindowButtonSectionSubtotal;

	@FindBy(xpath = "//div[@class='add-to-bag__button-wrap']//button[normalize-space(.)='Checkout']")
	public WebElement btnAddToBagPopupWindowButtonSectionCheckOut;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__button-wrap']//button[contains(@class,'btn-go-to-bag')]")
	public WebElement btnAddToBagPopupWindowButtonSectionViewShoppingBag;

	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__footer']")
	public WebElement lblAddToBagPopupWindowFooterInfo;

	//Bread Crumb Navigation
	@FindBy(xpath = "//nav[@class='breadcrumb__nav']//li//a")
	public List<WebElement> lstBreadCrumbNav;

	//Get the look
	@FindBy(xpath = "//div[@id='findMine']//*[contains(@class,'findmine__header') and not(contains(@class,'findmine__header-wrap'))]")
	public WebElement lblGetTheLookHeader;

	@FindBy(xpath = "//div[@id='findMine']//div[contains(@class,'findmine__slider')]")
	public WebElement cntGetTheLook;

	@FindBy(xpath = "//div[@id='findMine']//div[contains(@class,'findmine__slider')]//button[contains(@class,'slick-prev')]")
	public WebElement btnGetTheLookPrev;

	@FindBy(xpath = "//div[@id='findMine']//div[contains(@class,'findmine__slider')]//button[contains(@class,'slick-next')]")
	public WebElement btnGetTheLookNext;

	/**@FindBy(xpath = "//div[@id='findMine']//div[contains(@class,'findmine__slider')]//div[contains(@class,'findmine__item') and not(contains(@class,'findmine__itemid'))]")
	public List<WebElement> lstGetTheLookItem;*/

	@FindBy(xpath="//div[contains(@class,'draggable')]//figure[contains(@class,'current')]/a")
	public WebElement imgCurrentImageDisplayedForProduct;

	@FindBy(xpath = "//div[@id='findMine']//div[@class='slick-list']//div[contains(@class,'slick-current')]//div[contains(@class,'findmine__item') and not(contains(@class,'findmine__itemid'))]")
	public List<WebElement> lstGetTheLookItem;

	public By byGetTheLookProductLink=By.xpath(".//a");

	public By byGetTheLookProductName=By.xpath(".//div[@class='findine__name']");

	public By byGetTheLookProductBrand=By.xpath(".//div[@class='findmine__brand']");

	public By byGetTheLookProductPriceContainer=By.xpath(".//div[@class='findmine__price']");

	public By byGetTheLookProductNowPrice=By.xpath(".//div[@class='findmine__now-price']");

	public By byGetTheLookProductWasPrice=By.xpath(".//del[@class='findmine__was-price']");

	//Accordions Section
	@FindBy(xpath = "//div[@id='accordion']//div[@class='field-wrapper']")
	public List<WebElement> lstProductAccordions;

	//@FindBy(xpath = "//div[@id='accordion']//div[@class='field-wrapper__accordion-heading']/span[contains(text(),'Product')]")
	//public WebElement lblProductOverviewHeader;

	public By accordionHeading = By.xpath(".//span[contains(@class,'accordion-heading')]");

	public By accordionPlusMinusIcon = By.xpath(".//div[contains(@class,'accordion-heading__icon')]");

	public By accordionContents = By.xpath(".//div[@class='field-wrapper__content-wrapper']//div[@class='field-wrapper__content']");

	public By accordionReadMoreLessButton = By.xpath(".//button");

	public By accordionContentElement = By.xpath(".//div[contains(@id,'content')]");

	public ProductDetailsItem productDetailsItem = new ProductDetailsItem();
	public Product.Products product=null;
	public SelectedProduct selectedProduct= new SelectedProduct();

	/**
	 * Method to check if Video is playing
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean checkIfVideoisPlaying() {
		return this.videoBoxControl.findElement(By.xpath(".//div[contains(@class,'amp-player')]")).getAttribute("class").contains("amp-playing");
	}

	/**
	 * Method to check if AutoPlayVideoStatus is ON
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean checkIfAutoPlayVideoStatusIsON() {
		return this.btnAutoPlayVideo.isSelected();
	}

	/**
	 * Method to get AutoPlayVideo ToolTip popup Message
	 * @return String: tooltip message
	 * @author Wei.Li
	 */
	public String getAutoPlayVideoToolTipPopupMsg() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkAutoPlayVideoToolTip);
		this.clickWebElementUsingJS(this.lnkAutoPlayVideoToolTip);
		//this.getReusableActionsInstance().clickIfAvailable(this.lnkAutoPlayVideoToolTip);
		this.getReusableActionsInstance().staticWait(3*this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAutoPlayVideoToolTipPopupMsg);
		String lsText=this.lblAutoPlayVideoToolTipPopupMsg.getText().trim();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAutoPlayVideoToolTipPopupMsgClose);
		this.clickWebElementUsingJS(this.btnAutoPlayVideoToolTipPopupMsgClose);
		//this.getReusableActionsInstance().clickIfAvailable(this.btnAutoPlayVideoToolTipPopupMsgClose);
		this.getReusableActionsInstance().staticWait(3*this.getStaticWaitForApplication());

		return lsText;
	}

	/**
	 * Method to check the product style is displaying with Dropdown mode
	 * @return true	for Dropdown menu and false for Radio list
	 * @author Wei.Li
	 */
	public boolean judgeStyleDisplayModeIsDropdownMenu() {
		return this.checkChildElementExistingByTagName(cntProductStyleSection,"select");
	}

	/**
	 * Method to check the product size is displaying with Dropdown mode
	 * @return true	for Dropdown menu and false for Radio list
	 * @author Wei.Li
	 */
	public boolean judgeSizeDisplayModeIsDropdownMenu() {
		return this.checkChildElementExistingByTagName(cntProductSizeSection,"select");
	}

	/**
	 * Method to check if Style size is existing
	 * @param - boolean - bStyle - true for style while false for size
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean judgeStyleSizeAvailable(boolean bStyle) {
		if(bStyle){
			return this.checkChildElementExistingByTagNameAndAttribute(this.cntProductStyleAndSizeJudgeIndicator, "fieldset","class", "pdp-description__form__colours");
		}
		else{
			return this.checkChildElementExistingByTagNameAndAttribute(this.cntProductStyleAndSizeJudgeIndicator, "fieldset","class", "pdp-description__form__sizes");
		}
	}

	public boolean judgeQuantityDropdownAvailable() {
		return this.checkChildElementExistingByTagName(this.selectQuantityOption,"option");
	}

	public boolean checkOutOfStockForQuantityDropdown() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectQuantityOption);
		Select select=new Select(this.selectQuantityOption);
		return select.getFirstSelectedOption().getText().trim().equalsIgnoreCase("0");
	}

	public boolean judgeAddToBagButtonAvailable() {
		return !this.getElementInnerText(this.btnAddToBag).equalsIgnoreCase("Out of Stock");
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
		return this.getElementInnerText(lblRadioProductStyleTitle).split(":")[1].trim();
	}

	/**
	 * Method to get the data size of selected Swatch
	 * @return String
	 * @author Wei.Li
	 */
	public String getCurrentSize() {
		String lsTitle="";
		try{
			lsTitle=this.getElementInnerText(lblSizeTitle);
		}
		catch (Exception e){

		}

		return lsTitle.split(":")[1].trim();
	}

	/**
	 * Method to verify the linkage between Thumbnail and Zoom image
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyLinkageBetweenThumbnailAndZoomImage() {
		String lsText,lsSelectedStyle;
		for(WebElement item:this.lstThumbnailImageButtonWithoutVideoList) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			this.clickWebElementUsingJS(item);
			//item.click();
			//Keep it to wait for clicking action result
			this.getReusableActionsInstance().staticWait(500);

			String lsThumbnail=currentThumbnailItem.getAttribute("data-styleid");
			if (!(System.getProperty("Device").equalsIgnoreCase("Tablet"))) {
				String lsZoomImage = this.getImageNameFromThumbnailOrZoomImagePath(lnkCurrentZoomImage.getAttribute("href"));
				reporter.softAssert(lsThumbnail.equalsIgnoreCase(lsZoomImage), "The Thumbnail image is the same as the Zoom image with changing Swatch style", "The Thumbnail image is not the same as the Zoom image with changing Swatch style");
			}

			if(this.judgeStyleDisplayModeIsDropdownMenu()) {
				lsText=this.getElementInnerText(this.lblRadioProductStyleTitle).split(":")[1].trim();
				lsSelectedStyle=getSwatchTypeValueFromDropdownMenu(lsText);
			}
			else{
				lsText=this.btnRadioProductStyleSelectedLabel.getAttribute("style").split("url")[1];
				lsSelectedStyle=this.getImageNameFromThumbnailOrZoomImagePath(lsText);
			}
			if(lsThumbnail.equalsIgnoreCase(lsSelectedStyle)){
				reporter.reportLogPass("The Thumbnail image is the same as selected Style");
			}
			else{
				reporter.reportLogFailWithScreenshot("The Thumbnail image:"+lsThumbnail+" is the same as selected Style:"+lsSelectedStyle);
			}

		}
	}

	private String getSwatchTypeValueFromDropdownMenu(String lsSelectedStyle){
		String lsText;
		for(WebElement item:this.lstDropdownProductStyle){
			lsText=this.getElementInnerText(item).trim();
			if(lsText.equalsIgnoreCase(lsSelectedStyle)){
				return item.getAttribute("value");
			}
		}
		return null;
	}

	public boolean checkThumbnailPrevButtonExisting(){
		return this.checkChildElementExistingByAttribute(this.cntThumbnailContainer,"class","gallery-button-prev");
	}

	public boolean checkThumbnailNextButtonExisting(){
		return this.checkChildElementExistingByAttribute(this.cntThumbnailContainer,"class","gallery-button-next");
	}

	/**
	 * Method to verify the Prev button clicking of Thumbnail
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyThumbnailPrevButton() {
		if(!checkThumbnailPrevButtonExisting()){
			reporter.reportLog("There is no Thumbnail prev button");
			return;
		}

		String lsFirstImageSrcBefore=this.lstThumbnailImageList.get(0).findElement(By.xpath(".//img")).getAttribute("src");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnThumbnailPrev);
		this.clickWebElementUsingJS(this.btnThumbnailPrev);
		//this.getReusableActionsInstance().clickIfAvailable(this.btnThumbnailPrev);
		//Keep it to wait for clicking action result
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
		if(!checkThumbnailNextButtonExisting()){
			reporter.reportLog("There is no Thumbnail next button");
			return;
		}

		int imageCount=this.lstThumbnailImageList.size();
		String lsLastImageSrcBefore=this.lstThumbnailImageList.get(0).findElement(By.xpath(".//img")).getAttribute("src");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnThumbnailNext);
		this.clickWebElementUsingJS(this.btnThumbnailNext);
		//this.getReusableActionsInstance().clickIfAvailable(this.btnThumbnailNext);
		//Keep it to wait for clicking action result
		this.getReusableActionsInstance().staticWait(300);
		String lsLastIamgeSrcAfter=this.lstThumbnailImageList.get(0).findElement(By.xpath(".//img")).getAttribute("src");

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
		String lsSwatch,lsThumbnail="",lsZoomImage="",lsText;
		int loopSize;
		if(this.judgeStyleDisplayModeIsDropdownMenu()) {
			Select selectStyle= new Select(this.selectProductStyle);
			loopSize=this.lstDropdownProductStyle.size();

			for(int i=0;i<loopSize;i++) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectProductStyle);
				selectStyle.selectByIndex(i);
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				lsText=this.getElementInnerText(this.lblRadioProductStyleTitle).split(":")[1].trim();
				lsSwatch=getSwatchTypeValueFromDropdownMenu(lsText);
				lsThumbnail=currentThumbnailItem.getAttribute("data-styleid");
				lsZoomImage=this.getImageNameFromThumbnailOrZoomImagePath(lnkCurrentZoomImage.getAttribute("href"));

				reporter.softAssert(lsThumbnail.toLowerCase().contains(lsSwatch.toLowerCase()), "The Thumbnail image src contains swatch style of " +lsSwatch, "The Thumbnail image src does not contain swatch style of "+lsSwatch);
				reporter.softAssert(lsZoomImage.toLowerCase().contains(lsSwatch.toLowerCase()), "The Zoom image src contains swatch style of " +lsSwatch, "The Zoom image src does not contain swatch style of "+lsSwatch);
				reporter.softAssert(lsThumbnail.equalsIgnoreCase(lsZoomImage), "The Thumbnail image is the same as the Zoom image with changing Swatch radio of '"+lsSwatch+"'", "The Thumbnail image is not the same as the Zoom image with changing Swatch radio of '"+lsSwatch+"'");
			}
		}
		else {
			loopSize=this.lstRadioStyleLabelSpanList.size();
			WebElement labelItem;

			for(int i=0;i<loopSize;i++) {
				labelItem=this.lstRadioStyleLabelList.get(i);

				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblRadioProductStyleStatic);
				try{
					this.clickElement(labelItem);
				}
				catch(Exception e){

				}

				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				lsText=this.btnRadioProductStyleSelectedLabel.getAttribute("style").split("url")[1];
				lsSwatch=this.getImageNameFromThumbnailOrZoomImagePath(lsText);
				lsThumbnail=currentThumbnailItem.getAttribute("data-styleid");
				lsZoomImage=this.getImageNameFromThumbnailOrZoomImagePath(lnkCurrentZoomImage.getAttribute("href"));

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
		String lsSwatch,lsBeforeStyleName,lsAfterStyleName,lsInitialText,lsFirstOption;
		int loopSize,startNumber;

		lsInitialText=this.getCurrentSwatchStyle();
		if(this.judgeStyleDisplayModeIsDropdownMenu()) {
			Select selectStyle= new Select(this.selectProductStyle);
			loopSize=this.lstDropdownProductStyle.size();
			lsFirstOption=this.getElementInnerText(this.lstDropdownProductStyle.get(0)).trim();
			if(lsFirstOption.equalsIgnoreCase(lsInitialText)){
				startNumber=1;
			}
			else{
				startNumber=0;
			}

			for(int i=startNumber;i<loopSize;i++) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectProductStyle);
				lsBeforeStyleName=this.getCurrentSwatchStyle();

				selectStyle.selectByIndex(i);
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

				lsAfterStyleName=this.getCurrentSwatchStyle();
				reporter.softAssert(!lsBeforeStyleName.equalsIgnoreCase(lsAfterStyleName), "Clicking the swatch dropdown option is changing product style name", "Clicking the swatch dropdown option is not changing product style name");
			}
		}
		else {
			loopSize=this.lstRadioStyleLabelSpanList.size();
			WebElement labelItem;

			lsFirstOption=this.lstRadioStyleLabelList.get(0).getAttribute("for").trim();
			if(lsFirstOption.equalsIgnoreCase(lsInitialText)){
				startNumber=1;
			}
			else{
				startNumber=0;
			}

			for(int i=startNumber;i<loopSize;i++) {
				labelItem=this.lstRadioStyleLabelList.get(i);

				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblRadioProductStyleStatic);
				lsBeforeStyleName=this.getCurrentSwatchStyle();

				try{
					this.clickElement(labelItem);
				}
				catch(Exception e){

				}

				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				lsAfterStyleName=this.getCurrentSwatchStyle();

				reporter.softAssert(!lsBeforeStyleName.equalsIgnoreCase(lsAfterStyleName), "Clicking the swatch dropdown option is changing product style name", "Clicking the swatch dropdown option is not changing product style name");
			}
		}
	}

	/**
	 * Method to find image name in Thumbnail or Zoom image path
	 * @param-String lsPath: path String
	 * @return String
	 * @author Wei.Li
	 */
	public String getImageNameFromThumbnailOrZoomImagePath(String lsPath) {
		return lsPath.split("\\.jpg")[0].split("_")[1];
	}

	/**
	 * Method to judge if Soldout section is displaying
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean IsSoldOutExisting() {
		return this.getElementInnerText(this.btnAddToBag).equalsIgnoreCase("OUT OF STOCK");
	}

	/**
	 * Method to judge if Quantity left section is displaying
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean IsQuantityLeftExisting() {
		return this.getChildElementCount(this.cntQuantityTitleContainer)>2;
	}

	/**
	 * Method to go to Review tab
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean goToProductReviewSection() {
		this.waitForPageToLoad();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.productReviewSection);
		//this.getReusableActionsInstance().clickIfAvailable(this.productReviewSection);
		//this.getReusableActionsInstance().scrollToElementAndClick(this.productReviewSection);
		this.clickWebElementUsingJS(this.productReviewSection);
		return this.waitForCondition(Driver->{return this.lblReviewTabHeader.isDisplayed();},30000);
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
	 * @param-String lsReviewSortingOption: review option
	 * @return void
	 * @author Wei.Li
	 */
	public void chooseReviewSortingOption(String lsReviewSortingOption) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblReviewTabReviewCount);
		Select reviewSortings=new Select(this.selectReviewTabSortBy);
		reviewSortings.selectByVisibleText(lsReviewSortingOption);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
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
	 * Method to verify image for added review in review section
	 * @return - int - Number of reviews that have reviews containing images
	 */
	public HashMap<String,HashMap<String,String>> verifyReviewImageForAddedReviews(){
		HashMap<String,HashMap<String,String>> map = new HashMap<>();
		for(WebElement item:this.lstReviewTabPerReviewList) {
			WebElement reviewNickNameElement=item.findElement(this.byReviewTabNickName);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			WebElement imageReview = item.findElement(By.xpath("./section[contains(@class,'images')]"));
			List<WebElement> imageReviewList = this.getChildrenList(imageReview);
			if(imageReviewList.size()>0){
				List<WebElement> imageReviewContent = this.getChildrenList(imageReviewList.get(0));
				//Fetching image details and comments by user
				HashMap<String,String> reviewData = this.getReviewImageWithCommentsProvidedByUser(item);
				if(imageReviewContent.size()==2){
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(imageReviewContent.get(0));
					reporter.reportLog("Both image and text is present for review by: "+reviewNickNameElement.getText());
					String reviewImageLink = imageReviewContent.get(0).findElement(By.xpath("./img")).getAttribute("src").trim();
					String reviewImageComment = imageReviewContent.get(1).getText();
					reviewData.put("imageLink",reviewImageLink);
					reviewData.put("imageComment",reviewImageComment);
					if(!reviewImageLink.isEmpty() && !reviewImageComment.isEmpty())
						reporter.reportLogPassWithScreenshot("Review Image Link and Comment is present for the review");
					else
						reporter.reportLogFailWithScreenshot("Either review image link or comment is missing for review");
				}
				if(imageReviewContent.size()==1){
					this.getReusableActionsInstance().javascriptScrollByVisibleElement(imageReviewContent.get(0));
					reporter.reportLog("Only review image is present for review by: "+reviewNickNameElement.getText());
					String reviewImageLink = imageReviewContent.get(0).findElement(By.xpath("./img")).getAttribute("src").trim();
					reviewData.put("imageLink",reviewImageLink);
					if(!reviewImageLink.isEmpty())
						reporter.reportLogPassWithScreenshot("Review Image link is present for the review");
					else
						reporter.reportLogFailWithScreenshot("Review image link is missing for review");
				}
				map.put(reviewData.get("heading"),reviewData);
			}
		}
		if(map.size()>0)
			return map;
		else
			return null;
	}

	/**
	 * Function gets details of review image with comment provided by user
	 */
	public HashMap<String,String> getReviewImageWithCommentsProvidedByUser(WebElement imageElement){
		WebElement element;
		String lsHeadingLine;
		HashMap<String,String> map = new HashMap<>();

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(imageElement);
		element=imageElement.findElement(this.byReviewTabHeadingLine);
		lsHeadingLine=element.getText().trim();
		map.put("heading",lsHeadingLine);

		List<WebElement> starElement=imageElement.findElements(this.byReviewRatingStarDecimal);
		map.put("reviewStars",String.valueOf(starElement.size()));

		element=imageElement.findElement(this.byReviewTabSubmittedTime);
		String timeInMonths = element.getText().trim();
		if(timeInMonths.contains("year"))
			map.put("reviewSubmittedTime",String.valueOf(Integer.valueOf(timeInMonths.split(" ")[0])*12));
		else
			map.put("reviewSubmittedTime",timeInMonths);

		element=imageElement.findElement(this.byReviewTabNickName);
		map.put("reviewTabNickName",element.getText().trim());

		element=imageElement.findElement(this.byReviewTabDescriptionText);
		map.put("reviewTabDescription",element.getText().trim());

		element=imageElement.findElement(this.byReviewTabFooter);
		map.put("reviewTabFooterDescription",element.getText().trim());

		if(map.size()>0)
			return map;
		else
			return null;
	}
	/**
	 * Method to check Review rate sorting function
	 * @param-boolean bHighestRateFirst: true for Highest rated sorting while false for Lowest rated sorting
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
	 * Method to open TrueFit iFrame
	 * @return void
	 * @author Wei.Li
	 */
	public void openTrueFitIFrame() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkProductTrueFitLink);
		try{
			this.clickElement(this.lnkProductTrueFitLink);
		}
		catch(Exception e){

		}

		this.waitForCondition(Driver->{return this.iframeProductTrueFitLoadingIndicator.getAttribute("style").contains("display: block");}, 30000);

		this.getDriver().switchTo().frame(this.iframeProductTrueFit);
	}

	/**
	 * Method to close TrueFit iFrame
	 * @return void
	 * @author Wei.Li
	 */
	public void closeTrueFitIFrame() {
		/*this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductTrueFitIframeClose);
		this.getReusableActionsInstance().clickIfAvailable(this.btnProductTrueFitIframeClose);
		//this.btnProductTrueFitIframeClose.click();
		this.getDriver().switchTo().defaultContent();
		this.waitForCondition(Driver->{return this.iframeProductTrueFitLoadingIndicator.getAttribute("style").contains("display: none");}, 30000);*/
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		jse.executeScript("arguments[0].click();", this.btnProductTrueFitIframeClose);
		this.getDriver().switchTo().defaultContent();
		this.waitForCondition(Driver->{return this.iframeProductTrueFitLoadingIndicator.getAttribute("style").contains("display: none");}, 30000);
	}

	/**
	 * Method to check if TrueFit is existing
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductTrueFitExisting() {
		//To wait for TrueFit section displaying
		this.applyStaticWait(5*this.getStaticWaitForApplication());
		return !cntProductTrueFitSection.getCssValue("height").equalsIgnoreCase("0px");
	}

	/**
	 * Method to check if Sizing chart is existing
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductSizingChartExisting() {
		for(WebElement item:this.lstAccordionSectionHeadings) {
			if(this.getElementInnerText(item).equalsIgnoreCase("Size Chart")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to check if changing radio item action is working
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductSizingChangeAction() {
		WebElement labelItem;
		String lsFirstOption,lsInitialText,lsBeforeSizeName,lsAfterSizeName;
		int loopSize,startNumber;

		loopSize=this.lstRadioSizeLabelSpanList.size();
		lsInitialText=this.getCurrentSize();
		lsFirstOption=this.lstRadioSizeLabelList.get(0).getAttribute("for").trim();
		if(lsFirstOption.equalsIgnoreCase(lsInitialText)){
			startNumber=1;
		}
		else{
			startNumber=0;
		}

		for(int i=startNumber;i<loopSize;i++) {
			labelItem=this.lstRadioSizeLabelList.get(i);

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSizeStatic);
			lsBeforeSizeName=this.getCurrentSize();

			try {
				this.clickElement(labelItem);
			}
			catch (Exception e){

			}

			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			lsAfterSizeName=this.getCurrentSize();

			if(lsBeforeSizeName.equalsIgnoreCase(lsAfterSizeName)){
				return false;
			}
		}
		return true;
	}

	/**
	 * Method to verify product size changing action
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyProductSize() {
		if(!this.judgeStyleSizeAvailable(false)){
			reporter.reportLog("No Size available");
			return;
		}

		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblSizeStatic),"Product size title is existing","Product size title is not existing");
		reporter.softAssert(this.lstRadioSizeLabelList.size()>0,"Product size radio list is existing","Product size radio list is not existing");
		reporter.softAssert(checkProductSizingChangeAction(),"Product size changing action is working","Product size changing action is not working");
		if(IsSoldOutExisting()) {
			reporter.softAssert(!this.getElementText(this.lblSoldOut).isEmpty(),"The product Soldout message is not empty","The product Soldout message is empty");
		}

		checkProductSizingChangeAction();
	}

	/**
	 * Method to verify product size TrueFit
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyProductSizeTrueFit() {
		if(checkProductTrueFitExisting()) {
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgProductTrueFitLogo),"The product TrueFit icon is displaying correctly","The product TrueFit icon is not displaying correctly");
			reporter.softAssert(!this.getElementHref(this.lnkProductTrueFitLink).isEmpty(),"The product TrueFit link is not empty","The product TrueFit link is empty");

			openTrueFitIFrame();
			trueFitDetails();
			closeTrueFitIFrame();
		}
		else
			reporter.reportLog("True Fit Section is not present for selected item on PDP");
	}

	public void trueFitDetails(){
		if(this.getReusableActionsInstance().isElementVisible(this.btnProductTrueFitIframeClose)){
			reporter.reportLogPass("The close button on product TrueFit popup window is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The close button on product TrueFit popup window is not displaying correctly");
		}

		if(this.getReusableActionsInstance().isElementVisible(this.lnkProductTrueFitIframeSignIn)){
			reporter.reportLogPass("The SignIn button on product TrueFit popup window is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The SignIn button on product TrueFit popup window is not displaying correctly");
		}

		if(!imgProductTrueFitIframeHeaderLogo.getAttribute("src").isEmpty()){
			reporter.reportLogPass("The SignIn Logo on product TrueFit popup window is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The SignIn Logo on product TrueFit popup window is not displaying correctly");
		}

		if(!imgProductTrueFitIframePage.getAttribute("src").isEmpty()){
			reporter.reportLogPass("The TrueFit Logo on product TrueFit popup window is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The TrueFit Logo on product TrueFit popup window is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductTrueFitIframePageTitle);
		if(!this.lblProductTrueFitIframePageTitle.getText().isEmpty()){
			reporter.reportLogPass("The page title on product TrueFit popup window is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The page title on product TrueFit popup window is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductTrueFitIframePageSubTitle);
		if(!this.lblProductTrueFitIframePageSubTitle.getText().isEmpty()){
			reporter.reportLogPass("The page Subtitle on product TrueFit popup window is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The page Subtitle on product TrueFit popup window is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.cntProductTrueFitIframePageMainContent);
		if(this.getReusableActionsInstance().isElementVisible(cntProductTrueFitIframePageMainContent)){
			reporter.reportLogPass("The page main content on product TrueFit popup window is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The page main content on product TrueFit popup window is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductTrueFitIframeConfirmMessage);
		if(!this.lblProductTrueFitIframeConfirmMessage.getText().isEmpty()){
			reporter.reportLogPass("The confirm message on the footer for suggested brands on product TrueFit popup window is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The confirm message on the footer for suggested brands on product TrueFit popup window is not displaying correctly");
		}

		if(!this.lnkProductTrueFitIframePrivacyPolicy.getAttribute("href").isEmpty()){
			reporter.reportLogPass("The Privacy Policy on the footer for suggested brands on product TrueFit popup window is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Privacy Policy on the footer for suggested brands on product TrueFit popup window is not displaying correctly");
		}
	}

	/**
	 * Method to verify product quantity dropdown
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyProductQuantityDropdown(int quantityNumberToShowLeftItemInfo) {
		String lsStyle,lsMsg;
		reporter.softAssert(!this.getElementText(this.lblQuantityStatic).isEmpty(),"The product quantity label message is not empty","The product quantity label message is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.selectQuantityOption),"The product Quantity option is displaying correctly","The product Quantity option is not displaying correctly");
		int loopSize;
		if(this.judgeStyleDisplayModeIsDropdownMenu()) {
			Select selectStyle= new Select(this.selectProductStyle);
			loopSize=this.lstDropdownProductStyle.size();
			List<String> dropDownText = new ArrayList<>();
			for(WebElement element:this.lstDropdownProductStyle){
				dropDownText.add(element.getText());
			}
			//for(int i=0;i<loopSize;i++) {
			for(int i=0;i<dropDownText.size();i++){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectProductStyle);
				//selectStyle.selectByIndex(i);
				selectStyle.selectByVisibleText(dropDownText.get(i));
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				lsStyle=this.getCurrentSwatchStyle();

				if(this.judgeStyleSizeAvailable(false)) {
					verifyQuantityLeftMessageForProductSize(lsStyle, quantityNumberToShowLeftItemInfo);
				}
				else {
					lsMsg=lsStyle+" Style";
					verifySingleItemQuantityLeftMessage(lsMsg,quantityNumberToShowLeftItemInfo);
				}
			}
		}
		else {
			loopSize=this.lstRadioStyleLabelSpanList.size();
			WebElement radioItem,labelItem;
			for(int i=0;i<loopSize;i++) {
				radioItem=this.lstRadioStyleLabelSpanList.get(i);
				labelItem=this.lstRadioStyleLabelList.get(i);

				this.getReusableActionsInstance().javascriptScrollByVisibleElement(radioItem);
				try{
					this.clickElement(labelItem);
				}
				catch(Exception e){

				}

				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
				lsStyle=this.getCurrentSwatchStyle();

				if(this.judgeStyleSizeAvailable(false)) {
					verifyQuantityLeftMessageForProductSize(lsStyle, quantityNumberToShowLeftItemInfo);
				}
				else {
					lsMsg=lsStyle+" Style";
					verifySingleItemQuantityLeftMessage(lsMsg,quantityNumberToShowLeftItemInfo);
				}
			}
		}

	}

	private void verifySingleItemQuantityLeftMessage(String lsMsg,int quantityNumberToShowLeftItemInfo) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectQuantityOption);
		if(IsQuantityLeftExisting()) {
			if(this.selectQuantityOption.getText().isEmpty()) {
				reporter.reportLogFail("The product Quantity left message should not occur while selected quantity is empty for "+lsMsg);
			}
			else {
				int lastOption=Integer.parseInt(this.lblQuantityLastOption.getAttribute("value"));
				if(lastOption<quantityNumberToShowLeftItemInfo) {
					reporter.reportLogPass("The product Quantity left message is displaying correctly while quantity dropdown items amount is less than "+ quantityNumberToShowLeftItemInfo+ " for "+lsMsg);
				}
				else {
					reporter.reportLogFail("The product Quantity left message should not occur while quantity dropdown items amount is no less than "+ quantityNumberToShowLeftItemInfo+ " for "+lsMsg);
				}
			}
		}
	}

	private void verifyQuantityLeftMessageForProductSize(String lsStyle, int quantityNumberToShowLeftItemInfo) {
		String lsSize="",lsMsg;
		WebElement labelItem;
		int loopSize;

		loopSize=this.lstRadioSizeLabelSpanList.size();
		for(int i=0;i<loopSize;i++) {
			labelItem=this.lstRadioSizeLabelList.get(i);
			try{
				this.clickElement(labelItem);
			}
			catch (Exception e){

			}

			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			lsSize=this.getCurrentSize();

			lsMsg=lsStyle+" Style and "+lsSize+" Size";
			verifySingleItemQuantityLeftMessage(lsMsg,quantityNumberToShowLeftItemInfo);
		}
	}

	/**
	 * Method to verify product Add to Bag button
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyProductAddToBagButton() {
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnAddToBag),"The AddToBag button is displaying correctly","The AddToBag button is not displaying correctly");
	}

	/**
	 * Method to check if Product brand name is displaying
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductBrandNameDisplaying() {
		return this.getChildElementCount(this.cntRightContainer.findElement(By.xpath(".//div[@class='pdp-description__brand-and-reviews']")))>1;
	}

	/**
	 * Method to check if Add to Bag popup window is displaying
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkAddToBagPopupDisplaying() {
		return this.checkChildElementExistingByAttribute(this.cntAddToBagOverlay, "class", "add-to-bag__overlay");
	}

	/**
	 * Method to check if product badge information in Add to Bag popup window is displaying
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductBadgeInAddToBagPopupDisplaying() {
		return this.checkChildElementExistingByAttribute(this.cntAddToBagPopupWindowDetailsLeftSectionImage, "class", "badgeWrap");
	}

	/**
	 * Method to check if product style information in Add to Bag popup window is displaying
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductStyleInAddToBagPopupDisplaying() {
		return this.checkChildElementExistingByAttribute(this.lnkAddToBagPopupWindowDetailsProductInfo, "class", "add-to-bag__product-style");
	}

	/**
	 * Method to check if product size information in Add to Bag popup window is displaying
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean checkProductSizeInAddToBagPopupDisplaying() {
		return this.checkChildElementExistingByAttribute(this.lnkAddToBagPopupWindowDetailsProductInfo, "class", "add-to-bag__product-size");
	}

	/**
	 * Method to open AddToBag PopupWindow
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean openAddToBagPopupWindow() {
//		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBag);
//		this.getReusableActionsInstance().clickIfAvailable(this.btnAddToBag);
		//this.btnAddToBag.click();
		this.clickElement(this.btnAddToBag);

		try{
			this.waitForCondition(Drive->{return checkAddToBagPopupDisplaying();}, 30000);
		}
		catch(Exception e){
			this.applyStaticWait(10000);
		}

		return true;
	}

	/**
	 * Method to close AddToBag PopupWindow
	 * @return boolean
	 * @author Wei.Li
	 */
	public boolean closeAddToBagPopupWindow() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowClose);
		if(this.btnAddToBagPopupWindowClose.isDisplayed() && this.btnAddToBagPopupWindowClose.isEnabled()){
			reporter.reportLogPass("Close Button on Add to Bag pop-up is displayed as expected");
			this.getReusableActionsInstance().clickIfAvailable(this.btnAddToBagPopupWindowClose);
			//this.btnAddToBagPopupWindowClose.click();
			return this.waitForCondition(Drive->{return !checkAddToBagPopupDisplaying();}, 30000);
		}else{
			reporter.reportLogFail("Close Button on Add to Bag pop-up is not displayed as expected");
			return false;
		}
	}

	/**
	 * This function closes Add to Bag pop up window after clicking outside the pop-up window
	 */
	public Map<String,Object> closeAddToBagPopUpWindowAfterClickingOutsidePopUp(String lbl_AddToBagPopupWindowTitle){
		openAddToBagPopupWindow();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowTitle);
		reporter.softAssert(this.lblAddToBagPopupWindowTitle.getText().toUpperCase().matches(lbl_AddToBagPopupWindowTitle),"The title of Add to Bag popup window is matching to '"+lbl_AddToBagPopupWindowTitle+"' pattern","The title of Add to Bag popup window is not matching to '"+lbl_AddToBagPopupWindowTitle+"' pattern");
		Map<String,Object> addToBagData = this.getAddToBagDesc();
		//Clicking on TSC Home Page Link to close Pop-Up Window without clicking on close button on Pop-Up
		this.applyStaticWait(3000);
		//Clicking two times below as clicking single time is not working
		this.getReusableActionsInstance().clickIfAvailable(new HomePage(getDriver()).lblTSCLink);
		this.clickElement(new HomePage(getDriver()).lblTSCLink);
		this.waitForPageToLoad();
		this.waitForCondition(Drive->{return !checkAddToBagPopupDisplaying();}, 30000);
		return addToBagData;
	}

	/**
	 * This functions selects product that has more than one quantity available for product
	 */
	public void selectSizeAndStyleWithMoreThanOneQuantity(){
		int quantity = this.verifyAvailableQuantityGreaterThanOne();
		boolean flag = false;
		if(quantity>0){
			if(quantity==1){
				//Selecting available size
				int sizeList = this.lstRadioSizeLabelList.size();
				WebElement sizeElement;
				for(int j=0;j<sizeList;j++){
					sizeElement = this.lstRadioSizeLabelList.get(j);
					try {
						this.clickElement(sizeElement);
						WebElement finalSizeElement = sizeElement;
						waitForCondition(Driver->{return this.lblSelectedSize.getText().trim().equalsIgnoreCase(finalSizeElement.getText());},5000);
					}catch (Exception e){}

					//Selecting available Style
					int loopSize=this.lstRadioStyleLabelSpanList.size();
					WebElement labelItem;

					for(int i=0;i<loopSize;i++) {
						labelItem = this.lstRadioStyleLabelList.get(i);

						this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblRadioProductStyleStatic);
						try {
							String previousZoomImage = this.lnkCurrentZoomImage.getAttribute("href");
							this.clickElement(labelItem);
							String currentZoomImage = this.lnkCurrentZoomImage.getAttribute("href");
							waitForCondition(Driver->{return !previousZoomImage.equalsIgnoreCase(currentZoomImage);},10000);
							int newQuantity = this.verifyAvailableQuantityGreaterThanOne();
							if(newQuantity>1){
								flag = true;
								break;
							}
						} catch (Exception e) {}
					}
					if(flag)
						break;
				}
			}
		}else{
			reporter.reportLog("No Quantity text is available for this product on PDP page");
		}
	}

	/**
	 * This function verifies that select size and style for product on PDP page has more than 1 quantity selected
	 * @return - boolean - true/false
	 */
	public int verifyAvailableQuantityGreaterThanOne(){
		int quantityAvailable = 0;
		if(this.checkChildElementExistingByTagNameAndAttribute(this.lblAvailableQuantity,"span","class","pdp-description__add-to-bag__quantity__count--critic-stock")){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAvailableQuantityNumber);
			String quantityText = this.lblAvailableQuantity.getText().trim();
			if(quantityText.toLowerCase().contains("sold"))
				return quantityAvailable;
			else
				quantityAvailable = Integer.valueOf(quantityText.split(" ")[1]);
		}
		return quantityAvailable;
	}

	/**
	 * Method to verify the product details in Add to Bag popup window
	 * @param-String lbl_AddToBagPopupWindowTitle: the expected title
	 * @return - Map<String,Object> - AddToBag information
	 * @author Wei.Li
	 */
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

	//this method checks subtotal section
	public void subTotal(){
		reporter.softAssert(!this.getElementInnerText(this.lblAddToBagPopupWindowButtonSectionSubtotal).isEmpty(),"The product Subtotal in Add to Bag popup window is not empty","The product Subtotal in Add to Bag popup window is empty");
	}

	/**
	 * Method to get Shopping cart number
	 * @return int
	 * @author Wei.Li
	 */
	public int getShoppingCartNumber() {
		GlobalHeaderPage globalHeaderPage= new GlobalHeaderPage(this.getDriver());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeaderPage.CartBagCounter);

		return Integer.parseInt(globalHeaderPage.CartBagCounter.getText().trim());
	}

	/**
	 * Method to verify Shopping cart number
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyShoppingCartNumber(int cartCount) {
		reporter.softAssert(getShoppingCartNumber()>=cartCount,"The Shopping cart number is equal to "+cartCount,"The Shopping cart number is not equal to "+cartCount);
	}

	public int getOrderAmountFromSubTotalInAddToBagModel(){
		String lsText=this.getElementInnerText(lblAddToBagPopupWindowButtonSectionSubtotal);
		lsText=lsText.split(":")[0];

		return this.getIntegerFromString(lsText);
	}

	public float getOrderSubTotalInAddToBagModel(){
		String lsText=this.getElementInnerText(lblAddToBagPopupWindowButtonSectionSubtotal);
		lsText=lsText.split(":")[1];

		return this.getFloatFromString(lsText,true);
	}

	/**
	 * To go To Shopping Cart page By Clicking Shopping Cart Icon In GlobalHeader
	 */
	public void goToShoppingCartByClickingShoppingCartIconInGlobalHeader(){
		GlobalHeaderPage globalHeaderPage=new GlobalHeaderPage(this.getDriver());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(globalHeaderPage.ShoppingCartlnk);
		globalHeaderPage.ShoppingCartlnk.click();

		ShoppingCartPage shoppingCartPage=new ShoppingCartPage(this.getDriver());
		this.waitForPageToLoad();
		this.waitForCondition(Driver->{return shoppingCartPage.lblCartTitle.isDisplayed();},20000);
		this.applyStaticWait(3*this.getStaticWaitForApplication());
	}

	/**
	 * To go To Shopping Cart page by clicking ViewShoppingBag button in AddToBag Popup window with login first
	 */
	public void goToShoppingCartFromAddToBagPopupWithLoginFirst(){
		this.btnAddToBagPopupWindowButtonSectionViewShoppingBag.click();
		ShoppingCartPage shoppingCartPage=new ShoppingCartPage(this.getDriver());
		try{
			this.waitForCondition(Driver->{return shoppingCartPage.lblCartTitle.isDisplayed();},20000);
		}
		catch(Exception e){
			this.applyStaticWait(10*this.getStaticWaitForApplication());
		}
	}

	/**
	 * To go To Shopping Cart page by clicking ViewShoppingBag button in AddToBag Popup window without login first
	 * @param - String - lsUserName
	 * @param - String - lsPassword
	 */
	public void goToShoppingCartFromAddToBagPopupWithoutLoginFirst(String lsUserName,String lsPassword){
		ShoppingCartPage shoppingCartPage=new ShoppingCartPage(this.getDriver());
		this.btnAddToBagPopupWindowButtonSectionViewShoppingBag.click();
		try{
			this.waitForCondition(Driver->{return shoppingCartPage.lblCartTitle.isDisplayed();},20000);
		}
		catch(Exception e){
			this.applyStaticWait(10*this.getStaticWaitForApplication());
		}

		SignInPage signInPage=new SignInPage(this.getDriver());
		signInPage.Login(lsUserName,lsPassword);

		GlobalHeaderPage globalHeaderPage=new GlobalHeaderPage(this.getDriver());
		globalHeaderPage.ShoppingCartlnk.click();
		try{
			this.waitForCondition(Driver->{return shoppingCartPage.lblCartTitle.isDisplayed();},20000);
		}
		catch(Exception e){
			this.applyStaticWait(10*this.getStaticWaitForApplication());
		}
	}

	public boolean checkProductStyleExistingInAddToBagPopup(){
		return this.checkChildElementExistingByAttribute(cntAddToBagPopupWindowDetailsItemLink,"class","add-to-bag__product-style");
	}

	public boolean checkProductSizeExistingInAddToBagPopup(){
		return this.checkChildElementExistingByAttribute(cntAddToBagPopupWindowDetailsItemLink,"class","add-to-bag__product-size");
	}


	/**
	 * To get AddToBag description
	 * @return - Map<String,Object> - including product name/style/size, item amount and subtotal
	 */
	public Map<String,Object> getAddToBagDesc(){
		Map<String,Object> map=new HashMap<>();
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddToBagPopupWindowTitle);
		lsText= String.valueOf(this.getIntegerFromString(this.getElementInnerText(lblAddToBagPopupWindowTitle)));
		map.put("productQuantity",lsText);

		if(this.checkProductBadgeInAddToBagPopupDisplaying()){
			map.put("productBadge",true);
		}
		else{
			map.put("productBadge",false);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddToBagPopupWindowDetailsProductName);
		lsText=lblAddToBagPopupWindowDetailsProductName.getText();
		map.put("productName",lsText);

		if(checkProductStyleExistingInAddToBagPopup()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddToBagPopupWindowDetailsProductStyle);
			lsText=lblAddToBagPopupWindowDetailsProductStyle.getText();
			map.put("productStyle",lsText);
		}
		else{
			map.put("productStyle",null);
		}

		if(checkProductSizeExistingInAddToBagPopup()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddToBagPopupWindowDetailsProductSize);
			lsText=lblAddToBagPopupWindowDetailsProductSize.getText();
			lsText=lsText.split(":")[1].trim();
			map.put("productSize",lsText);
		}
		else{
			map.put("productSize",null);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblAddToBagPopupWindowDetailsProductNumber);
		lsText=lblAddToBagPopupWindowDetailsProductNumber.getText().replace("-","").trim();
		map.put("productNumber",lsText);

		map.put("itemAmount",getOrderAmountFromSubTotalInAddToBagModel());

		map.put("SubTotal",getOrderSubTotalInAddToBagModel());

		return map;
	}

	/**
	 * To get PDP description
	 * @return - Map<String,Object> - including product name/style/size
	 */
	public Map<String,Object> getPDPDesc(){
		Map<String,Object> map=new HashMap<>();
		String lsText;

		if(this.checkProductBadgeExisting()){
			map.put("productBadge",true);
		}
		else{
			map.put("productBadge",false);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblProductName);
		lsText=lblProductName.getText();
		map.put("productName",lsText);

		if(this.judgeStyleSizeAvailable(true)){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblRadioProductStyleStatic);
			lsText=lblRadioProductStyleStatic.getText();
			lsText=lsText.split(":")[1].trim();
			map.put("productStyle",lsText);
		}
		else{
			map.put("productStyle",null);
		}

		if(this.judgeStyleSizeAvailable(false)){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblSizeStatic);
			lsText=lblSizeStatic.getText();
			lsText=lsText.split(":")[1].trim();
			map.put("productSize",lsText);
		}
		else{
			map.put("productSize",null);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblProductNowPrice);
		float nowPrice=this.getFloatFromString(lblProductNowPrice.getText(),true);
		map.put("productNowPrice",nowPrice);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblProductNumber);
		lsText=lblProductNumber.getText().replace("-","").trim();
		map.put("productNumber",lsText);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(selectQuantityOption);
		Select select= new Select(selectQuantityOption);
		lsText=select.getFirstSelectedOption().getText().trim();
		map.put("productQuantity",lsText);

		if(IsQuantityLeftExisting()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblQuantityLeft);
			lsText=this.lblQuantityLeft.getText();
			map.put("productLeftNumber",this.getIntegerFromString(lsText));
		}
		else{
			map.put("productLeftNumber",null);
		}

		return map;
	}

	/**
	 * To verify contents Between PDP And AddToBag
	 * @param - mapPDP
	 * @param - mapAddToBag
	 */
	public void verifyContentsBetweenPDPAndAddToBag(Map<String,Object> mapPDP,Map<String,Object> mapAddToBag){
		boolean bPDPBadge=(boolean)mapPDP.get("productBadge");
		boolean bAddToBagBadge=(boolean)mapAddToBag.get("productBadge");
		if(bAddToBagBadge==bPDPBadge){
			reporter.reportLogPass("The Badge displaying in AddToBag is the same as PDP ");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Badge displaying in AddToBag is not the same as PDP ");
		}

		String lsPDPProductName=mapPDP.get("productName").toString();
		String lsAddToBagProductName=mapAddToBag.get("productName").toString();
		if(lsAddToBagProductName.equalsIgnoreCase(lsPDPProductName)){
			reporter.reportLogPass("The Product name displaying in AddToBag is the same as PDP ");
		}
		else{
			reporter.reportLogFail("The Product name:"+lsAddToBagProductName+" displaying in AddToBag is not the same as PDP:"+lsPDPProductName);
		}

		String lsPDPProductNumber=mapPDP.get("productNumber").toString();
		String lsAddToBagProductNumber=mapAddToBag.get("productNumber").toString();
		if(lsAddToBagProductNumber.equalsIgnoreCase(lsPDPProductNumber)){
			reporter.reportLogPass("The Product number displaying in AddToBag is the same as PDP ");
		}
		else{
			reporter.reportLogFail("The Product number:"+lsAddToBagProductNumber+" displaying in AddToBag is not the same as PDP:"+lsPDPProductNumber);
		}

		String lsPDPProductStyle=mapPDP.get("productStyle").toString();
		String lsAddToBagProductStyle=mapAddToBag.get("productStyle").toString();
		if(lsAddToBagProductStyle.equalsIgnoreCase(lsPDPProductStyle)){
			reporter.reportLogPass("The Product style displaying in AddToBag is the same as PDP ");
		}
		else{
			reporter.reportLogFail("The Product style:"+lsAddToBagProductStyle+" displaying in AddToBag is not the same as PDP:"+lsPDPProductStyle);
		}

		String lsPDPProductSize=mapPDP.get("productSize").toString();
		String lsAddToBagProductSize=mapAddToBag.get("productSize").toString();
		if(lsAddToBagProductSize.equalsIgnoreCase(lsPDPProductSize)){
			reporter.reportLogPass("The Product size displaying in AddToBag is the same as PDP ");
		}
		else{
			reporter.reportLogFail("The Product size:"+lsAddToBagProductSize+" displaying in AddToBag is not the same as PDP:"+lsPDPProductSize);
		}

		String lsPDPProductQuantity=mapPDP.get("productQuantity").toString();
		String lsAddToBagProductQuantity=mapAddToBag.get("productQuantity").toString();
		if(lsAddToBagProductQuantity.equalsIgnoreCase(lsPDPProductQuantity)){
			reporter.reportLogPass("The Product quantity displaying in AddToBag is the same as PDP ");
		}
		else{
			reporter.reportLogFail("The Product quantity:"+lsAddToBagProductQuantity+" displaying in AddToBag is not the same as PDP:"+lsPDPProductQuantity);
		}
	}

	/**
	 * Method to verify the url while clicking BreadCrumb Navigation.
	 * @param-String lsBackUrl: the expected Url
	 * @return void
	 * @author Wei.Li
	 */
	public void verifyBreadCrumbNavigationBack() {
		WebElement item=this.lstBreadCrumbNav.get(this.lstBreadCrumbNav.size()-1);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		this.getReusableActionsInstance().scrollToElement(item);
		this.clickWebElementUsingJS(item);
		//item.click();

		(new ProductResultsPage(this.getDriver())).waitForPageLoading();

		//reporter.softAssert(this.URL().toLowerCase().contains("productresults"),"The current Url of "+this.URL()+" is back to product search page","The current Url of "+this.URL()+" is not back to product search page");
		reporter.softAssert(this.URL().toLowerCase().contains("breadcrumb"),"The current Url of "+this.URL()+" is back to product search page","The current Url of "+this.URL()+" is not back to product search page");
	}

	public void verifyVideo(String lsVideoDisclaimInfo) {
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkVideo),"The product video is displaying correctly","The product video is not displaying correctly");

		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblVideoDisclaim),"The product video disclaim text is displaying correctly","The product video disclaim text is not displaying correctly");
		reporter.softAssert(this.getElementText(this.lblVideoDisclaim).equalsIgnoreCase(lsVideoDisclaimInfo),"The product video disclaim text is equal to the text of '"+lsVideoDisclaimInfo+"'","The product video disclaim text is not equal to the text of '"+lsVideoDisclaimInfo+"'");

		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
		reporter.softAssert(this.checkIfAutoPlayVideoStatusIsON(),"The product video AutoPlaying is on","The product video AutoPlaying is off");
		reporter.softAssert(this.checkIfVideoisPlaying(),"The product video is playing","The product video is not playing");

		reporter.softAssert(!getAutoPlayVideoToolTipPopupMsg().isEmpty(),"The AutoPlayVideoToolTip is not empty","The AutoPlayVideoToolTip is empty");

		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntThumbnailContainer),"The Thumbnail section is displaying correctly","The Thumbnail section is not displaying correctly");
		for(WebElement item:this.lstThumbnailVideoLink){
			reporter.softAssert(!item.getAttribute("data-video").isEmpty(),"The video src is not empty","The video src is empty");
		}

		for(WebElement item:this.lstThumbnailVideoImage){
			reporter.softAssert(item.getAttribute("src").contains("videoBtn.jpg"),"The video image is displaying correctly","The video image is not displaying correctly");
		}
	}

	public void verifyVideoOff() {
		this.getDriver().navigate().refresh();
		this.waitForPageToLoad();
		this.getReusableActionsInstance().waitForElementVisibility(this.btnAutoPlayVideo,  60);
		if(this.checkIfAutoPlayVideoStatusIsON()) {
			//Set AutoPlayVideo off
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAutoPlayVideo);
			this.clickWebElementUsingJS(this.btnAutoPlayVideo);
			//this.getReusableActionsInstance().clickIfAvailable(this.btnAutoPlayVideo);
			this.waitForCondition(Driver->{return !this.checkIfAutoPlayVideoStatusIsON();},2000);
			this.getDriver().navigate().refresh();
			this.waitForPageToLoad();
//			this.getReusableActionsInstance().waitForElementVisibility(this.lblZoomImageMessage,  60);
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkCurrentZoomImage),"The image is displaying after video off and page refreshing instead of video displaying","The image is not displaying after video off and page refreshing instead of video displaying");
		}
		else {
			//Set AutoPlayVideo on
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAutoPlayVideo);
			this.getReusableActionsInstance().clickIfAvailable(this.btnAutoPlayVideo);
			this.waitForCondition(Driver->{return this.checkIfAutoPlayVideoStatusIsON();},2000);

			//Set AutoPlayVideo off
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAutoPlayVideo);
			this.getReusableActionsInstance().clickIfAvailable(this.btnAutoPlayVideo);
			this.waitForCondition(Driver->{return !this.checkIfAutoPlayVideoStatusIsON();},2000);

			this.getDriver().navigate().refresh();
			this.waitForPageToLoad();
//			this.getReusableActionsInstance().waitForElementVisibility(this.lblZoomImageMessage,  60);
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkCurrentZoomImage),"The image is displaying after video off and page refreshing instead of video displaying","The image is not displaying after video off and page refreshing instead of video displaying");
		}
	}

	public void verifyThumbnail() {
		this.verifyThumbnailImageListSrc();

		setPrevButtonDisplayingInThumbnailList();
		this.verifyThumbnailPrevButton();

		setNextButtonDisplayingInThumbnailList();
		this.verifyThumbnailNextButton();
	}

	public boolean checkProductBadgeExisting() {
		return this.checkChildElementExistingByAttribute(this.cntRightContainer, "id", "divPriceLabel");
	}

	public boolean checkProductBrandExisting() {
		return this.checkChildElementExistingByAttribute(cntProductDetailsBrandAndReviewContainer, "id", "divBrandName");
	}

	public boolean checkProductEasyPayExisting() {
		return this.checkChildElementExistingByAttribute(this.cntRightContainer, "id", "divEasyPayment");
	}

	public void verifyProductBasicInfo() {
		if(checkProductBadgeExisting()){
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgProductBadge),"The product badge is displaying correctly","The product badge is not displaying correctly");
		}

		reporter.softAssert(!this.getElementText(this.lblProductName).isEmpty(),"The product name is not empty","The product name is empty");

		if(checkProductBrandExisting()) {
			reporter.softAssert(!this.getElementText(this.lnkBrandName).isEmpty(),"The product brand name is not empty","The product brand name is empty");
		}

		reporter.softAssert(!this.getElementText(this.lblProductNumber).isEmpty(),"The product number is not empty","The product number is empty");
	}

	public void verifyProductReview() {
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.productReviewSection),"The product review section is displaying correctly","The product review section is not displaying correctly");
		reporter.softAssert(this.lstProductReviewStar.size()>0,"The product review star count is greater than 0","The product review star count is not greater than 0");
		reporter.softAssert(!this.getElementText(this.lblProductReview).isEmpty(),"The product review text is not empty","The product review text is empty");

	}

	public void verifyProductPriceAndShipping() {
		reporter.softAssert(!this.getElementText(this.lblProductNowPrice).isEmpty(),"The product Now price is not empty","The product Now price is empty");
		if(this.getChildElementCount(this.cntProductPriceContainer)>1){
			reporter.softAssert(!this.getElementText(this.lblProductWasPrice).isEmpty(),"The product Was price is not empty","The product Was price is empty");
			reporter.softAssert(!this.getElementText(this.lblProductNowPrice).isEmpty()&&!this.getElementText(this.lblProductWasPrice).isEmpty(),"The product price range is not empty","The product price range is empty");
		}

		if(this.checkChildElementExistingByAttribute(this.cntProductShippingAndSavingsContainer,"class","pdp-description__prices__saving-and-shipping__shipping")){
			reporter.softAssert(!this.getElementText(this.lblProductShipping).isEmpty(),"The product Shipping message is not empty","The product Shipping message is empty");
		}

		if(this.checkChildElementExistingByAttribute(this.cntProductShippingAndSavingsContainer,"class","pdp-description__prices__saving-and-shipping__savings")){
			reporter.softAssert(!this.getElementText(this.lblProductSavings).isEmpty(),"The product Saving message is not empty","The product Saving message is empty");
		}
	}

	public void verifyEasyPay(){
		//Verify Easypay and popup dialog content
		if(this.checkProductEasyPayExisting()){
			reporter.softAssert(!this.getElementText(this.lblProductEasyPay).isEmpty(),"The product EasyPay message is not empty","The product EasyPay message is empty");

			//verify nowPrice and installation sum
			float nowPrice=this.getFloatFromString(this.getElementInnerText(this.lblProductNowPrice),true);
			String[] lstProductEasyPay=this.getElementInnerText(this.lblProductEasyPay).split("of");
			int installationCount=this.getIntegerFromString(lstProductEasyPay[0]);
			float intallationFee=this.getFloatFromString(lstProductEasyPay[1],true);
			if(Math.abs(nowPrice-installationCount*intallationFee)<0.1){
				reporter.reportLogPass("Installation sum is equal to nowPrice");
			}
			else{
				reporter.reportLogPass("Installation sum is not equal to nowPrice");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductEasyPay);
			//this.getReusableActionsInstance().clickIfAvailable(this.btnProductEasyPay);
			this.clickWebElementUsingJS(this.btnProductEasyPay);
			this.waitForCondition(Driver->{return this.lblProductEasyPayPopupHeading.isDisplayed();},10000);
			if(this.getReusableActionsInstance().isElementVisible(this.btnProductEasyPayPopupClose)){
				reporter.reportLogPass("The close button for easyPay popup window is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The close button for easyPay popup window is displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductEasyPayPopupHeading);
			if(!this.lblProductEasyPayPopupHeading.getText().isEmpty()){
				reporter.reportLogPass("The heading for easyPay popup window is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The heading for easyPay popup window is displaying correctly");
			}

			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductEasyPayPopupContent);
			if(!this.lblProductEasyPayPopupContent.getText().isEmpty()){
				reporter.reportLogPass("The content for easyPay popup window is displaying correctly");
			}
			else{
				reporter.reportLogFailWithScreenshot("The content for easyPay popup window is displaying correctly");
			}
			this.btnProductEasyPayPopupClose.click();
			this.getReusableActionsInstance().staticWait(300);
		}
	}

	public void verifyProductDeliveryOptions() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblProductDeliveryOptionsTitle);
		if(!lblProductDeliveryOptionsTitle.getText().isEmpty()){
			reporter.reportLogPass("Delivery options title is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("Delivery options title is not displaying correctly");
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(drpProductDeliveryOptionsMenu);
		Select select= new Select(drpProductDeliveryOptionsMenu);
		String lsMenu,lsProductName;
		for(int i=0;i<select.getOptions().size();i++){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblProductEasyPay);
			select.selectByIndex(i);
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			lsMenu=select.getFirstSelectedOption().getText().trim();
			lsProductName=this.getElementInnerText(this.lblProductName);
			if(lsMenu.equalsIgnoreCase(lsProductName)){
				reporter.reportLogPass("The product name is changed correctly with delivery option change");
			}
			else{
				reporter.reportLogFailWithScreenshot("The product name is not changed correctly with delivery option change");
			}
		}

		if(checkProductBadgeExisting()){
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgProductBadge),"The product badge is displaying correctly","The product badge is not displaying correctly");
		}

		reporter.softAssert(!this.getElementText(this.lblProductName).isEmpty(),"The product name is not empty","The product name is empty");

		if(checkProductBrandExisting()) {
			reporter.softAssert(!this.getElementText(this.lnkBrandName).isEmpty(),"The product brand name is not empty","The product brand name is empty");
		}

		reporter.softAssert(!this.getElementText(this.lblProductNumber).isEmpty(),"The product number is not empty","The product number is empty");
	}

	public void verifyProductStyle() {
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntProductStyleSection),"The product style section is displaying correctly","The product style section is not displaying correctly");

		if(this.judgeStyleDisplayModeIsDropdownMenu()) {
			reporter.softAssert(!this.getElementText(this.lblDropDownProductStyleStatic).isEmpty(),"The product style label message is not empty","The product style label message is empty");
			reporter.softAssert(!this.getElementText(this.selectProductStyle).isEmpty(),"The product style message is not empty","The product style message is empty");
			reporter.softAssert(this.lstDropdownProductStyle.size()>0,"The product style Dropdown menu count is greater than 0","The product style Dropdown menu count is not greater than 0");
		}
		else {
			reporter.softAssert(!this.getElementText(this.lblRadioProductStyleStatic).isEmpty(),"The product style label message is not empty","The product style label message is empty");
			reporter.softAssert(this.lstStyleRadioList.size()>0,"The product style radio button count is greater than 0","The product style radio button count is not greater than 0");
		}
	}

	public void verifyReviewSectionContent() {
		reporter.softAssert(!this.getElementText(this.lblReviewTabHeader).isEmpty(),"The Review tab header is not empty","The Review tab header is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgReviewTabHistogram),"The Review tab histogram is displaying correctly","The Review tab histogram is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblReviewTabRateDecimalText).isEmpty(),"The Review tab rate number is not empty","The Review tab rate number is empty");
		reporter.softAssert(this.lstReviewTabStar.size()>0,"The product review tab star count is greater than 0","The product review tab star count is not greater than 0");
		reporter.softAssert(!this.getElementText(this.lblReviewTabReviewCount).isEmpty(),"The Review count message is not empty","The Review count message is empty");
		reporter.softAssert(!this.getElementHref(this.lnkReviewTabWriteReview).isEmpty(),"The Write Review link is not empty","The Write Review link is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.selectReviewTabSortBy),"The Review sorting is displaying correctly","The Review sorting is not displaying correctly");
		//Verifying review count displayed on review stars
		this.verifyReviewStarCount();
	}

	public void verifyReviewStarCount(){
		int reviewStarCount = 0;
		int reviewCount = Integer.valueOf(this.lblReviewTabReviewCount.getText().trim().split(" Reviews")[0]);
		for(WebElement webElement:lstHistogramReviewsCountForStars)
			reviewStarCount = reviewStarCount + Integer.valueOf(webElement.getText().trim());

		if(reviewCount==reviewStarCount)
			reporter.reportLogPass("Review Counts for Reviews: "+reviewCount+" is same as count of reviews from review stars: "+reviewStarCount);
		else
			reporter.reportLogFail("Review Counts for Reviews: "+reviewCount+" is not same as count of reviews from review stars: "+reviewStarCount);
	}

	public void verifyReviewTabFooterAndBackToTopAndPagination() {
		reporter.softAssert(!this.getElementText(this.lblReviewTabDisplayingReviewMsg).isEmpty(),"The Review message in Review tab footer is not empty","The Review message in Review tab footer is empty");
		reporter.softAssert(!this.getElementHref(this.lnkReviewTabBackToTop).isEmpty(),"The BackToTop link is not empty","The BackToTop link is empty");
		/**
		 if(this.getChildElementCount(this.cntReviewTabPagination)>0) {
		 reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntReviewTabPagination),"The Review pagination section is displaying correctly","The Review pagination section is not displaying correctly");
		 }*/
	}

	public void verifyProductSoldOutBasicInfo() {
		reporter.softAssert(!this.getElementText(this.lblProductName).isEmpty(),"The product name is not empty","The product name is empty");
		reporter.softAssert(!this.getElementText(this.lblProductNumber).isEmpty(),"The product number is not empty","The product number is empty");

		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.productReviewSection),"The product review section is displaying correctly","The product review section is not displaying correctly");
		reporter.softAssert(this.lstProductReviewStar.size()>0,"The product review star count is greater than 0","The product review star count is not greater than 0");
		reporter.softAssert(!this.getElementText(this.lblProductReview).isEmpty(),"The product review text is not empty","The product review text is empty");

		reporter.softAssert(!this.getElementText(this.lblProductNowPrice).isEmpty(),"The product Now price is not empty","The product Now price is empty");
		reporter.softAssert(!this.getElementText(this.lblProductEasyPay).isEmpty(),"The product EasyPay message is not empty","The product EasyPay message is empty");
		reporter.softAssert(!this.getElementText(this.lblProductShipping).isEmpty(),"The product Shipping message is not empty","The product Shipping message is empty");
	}

	public void verifyProductSoldOut() throws IOException {
		this.chooseGivenStyleAndSize(selectedProduct.productEDPColor,selectedProduct.productEDPSize);

//		WebElement item;
//		if(this.checkChildElementExistingByTagName(this.selectQuantityOption,"option")){
//			int listSize = this.lstSizeOption.size();
//			for(int counter=0;counter<listSize;counter++){
//				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectSizeOption);
//				this.getReusableActionsInstance().clickIfAvailable(this.selectSizeOption);
//				this.getReusableActionsInstance().staticWait(100);
//				item=this.lstSizeOption.get(counter);
//				this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
//				item.click();
//				this.getReusableActionsInstance().staticWait(100);
//				if(!this.checkChildElementExistingByTagName(this.selectQuantityOption,"option"))
//					break;
//			}
//		}
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblSoldOut),"The Soldout message is displaying correctly","The Soldout message is not displaying correctly");
		reporter.softAssert(this.getElementText(this.lblSoldOut).equalsIgnoreCase("Out of Stock"),"The Soldout message is displaying correctly","The Soldout message is not displaying correctly");
		reporter.softAssert(this.checkOutOfStockForQuantityDropdown(),"The Quantity Dropdown for Soldout is displaying correctly","The Quantity Dropdown for Soldout is not displaying correctly");
		reporter.softAssert(!this.judgeAddToBagButtonAvailable(),"The Out of Stock button is displaying correctly","The Out of Stock button is not displaying correctly");

	}

	public void verifyCurrentZoomImage() {
		reporter.softAssert(!this.getElementHref(this.lnkCurrentZoomImage).isEmpty(),"The Current zoom image link is not empty","The Current zoom image link is empty");
//		reporter.softAssert(!this.getElementText(this.lblZoomImageMessage).isEmpty(),"The Zoom image message is not empty","The Zoom image message is empty");
	}

	public boolean checkIfIsRequiredFieldForWrireReview(WebElement element) {
		return this.checkChildElementExistingByTagName(element, "abbr");
	}

	public void openWriteReview() {
		this.clickElement(this.lnkReviewTabWriteReview);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblWriteReviewHeaderTitle,  60);
	}

	public void verifyWriteReviewContent() {
		reporter.softAssert(!this.getElementHref(this.lnkWriteReviewBackToProduct).isEmpty(),"The BackToProduct link is not empty","The BackToProduct link is empty");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewHeaderTitle).isEmpty(),"The Header title is not empty","The Header title is empty");
		reporter.softAssert(!this.getElementHref(this.lnkWriteReviewProductName).isEmpty(),"The Product Name link is not empty","The Product Name link is empty");
		reporter.softAssert(!this.getElementImageSrc(this.imgWriteReviewProductImage).isEmpty(),"The Product Image Source is not empty","The Product Image Source is empty");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewRequiredQuestion).isEmpty(),"The Required Question text is not empty","The Required Question text is empty");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewYourRating).isEmpty(),"The Your Rating text is not empty","The Your Rating text is empty");
		reporter.softAssert(this.lstWriteReviewYourRatingList.size()>0,"The Your Rating List is not empty","The Your Rating List is empty");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewHeadline).isEmpty(),"The Headline text is not empty","The Headline text is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.inputWriteReviewHeadline),"The Headline input is displaying correctly","The Headline input is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewComments).isEmpty(),"The Comments text is not empty","The Comments text is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.textareaWriteReviewComments),"The Comments input is displaying correctly","The Comments input is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewBottomLine).isEmpty(),"The Bottom Line text is not empty","The Bottom Line text is empty");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewSelectOne).isEmpty(),"The Select One text is not empty","The Select One text is empty");
		reporter.softAssert(this.lstWriteReviewRecommendToFriendList.size()>0,"The Recommend To Friend List is not empty","The Recommend To Friend List is empty");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewNickName).isEmpty(),"The NickName text is not empty","The NickName text is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.inputWriteReviewNickName),"The NickName input is displaying correctly","The NickName input is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewLocation).isEmpty(),"The Location text is not empty","The Location text is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.inputWriteReviewLocation),"The Location input is displaying correctly","The Location input is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewAddImage).isEmpty(),"The Add Image text is not empty","The Add Image text is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnWriteReviewUploadImage),"The Upload Image button is displaying correctly","The Upload Image button is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewAddVideo).isEmpty(),"The Add Video text is not empty","The Add Video text is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnWriteReviewUploadVideo),"The Upload Video button is displaying correctly","The Upload Video button is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewTermsAndPrivacy).isEmpty(),"The Terms And Privacy text is not empty","The Terms And Privacy text is empty");
		reporter.softAssert(!this.getElementHref(this.lnkWriteReviewTerms).isEmpty(),"The Terms link is not empty","The Terms link is empty");
		reporter.softAssert(!this.getElementHref(this.lnkWriteReviewPrivacy).isEmpty(),"The Privacy link is not empty","The Privacy link is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnWriteReviewSubmitReview),"The Submit Review button is displaying correctly","The Submit Review button is not displaying correctly");
		reporter.softAssert(!this.getElementHref(this.lnkWriteReviewPowerBy).isEmpty(),"The PowerBy link is not empty","The PowerBy link is empty");
		reporter.softAssert(!this.getElementText(this.lblWriteReviewPowerBy).isEmpty(),"The PowerBy text is not empty","The PowerBy text is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgWriteReviewPowerBy),"The PowerBy Image is displaying correctly","The PowerBy Image is not displaying correctly");
	}

	public void verifyWriteReviewAfterFailSubmitValidationMessage() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnWriteReviewSubmitReview);
		this.btnWriteReviewSubmitReview.click();
		this.getReusableActionsInstance().waitForElementVisibility(this.lblWriteReviewAlertHeading,  60);

		reporter.softAssert(!this.getElementText(this.lblWriteReviewAlertHeading).isEmpty(),"The Alert heading message is not empty","The Alert heading message is empty");
		int alertMessageNumberInHeading=this.getIntegerFromString(this.getElementText(this.lblWriteReviewAlertHeading));
		reporter.softAssert(this.lstWriteReviewAlertInfo.size()>0,"The Alert message list count is greater than 0","The Alert message list count is 0");
		int alertMessageListCount=this.lstWriteReviewAlertInfo.size();
		int alertIconListCount=this.lstWriteReviewErrorIcon.size();
		reporter.softAssert(alertMessageNumberInHeading==alertIconListCount,"The number in Alert heading meassge is equal to Alert icon list count","The number in Alert heading meassge is not equal to Alert icon list count");
		reporter.softAssert(alertMessageNumberInHeading==alertMessageListCount,"The number in Alert heading meassge is equal to Alert message list count","The number in Alert heading meassge is not equal to Alert message list count");
	}

	public void verifyWriteReviewAfterSuccessfulSubmitMessage(String lsTitle, String lsSubTitle) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstWriteReviewYourRatingList.get(0));
		this.lstWriteReviewYourRatingList.get(0).click();
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputWriteReviewHeadline);
		this.inputWriteReviewHeadline.click();
		this.inputWriteReviewHeadline.sendKeys("Test heading line");
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.textareaWriteReviewComments);
		this.textareaWriteReviewComments.click();
		this.textareaWriteReviewComments.sendKeys("Test");
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
		
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstWriteReviewRecommendToFriendList.get(0));
		this.lstWriteReviewRecommendToFriendList.get(0).click();
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputWriteReviewNickName);
		this.inputWriteReviewNickName.click();
		this.inputWriteReviewNickName.sendKeys("Cat");
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputWriteReviewLocation);
		this.inputWriteReviewLocation.click();
		this.inputWriteReviewLocation.sendKeys("Toronto");
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnWriteReviewSubmitReview);
		this.clickElement(this.btnWriteReviewSubmitReview);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblWriteReviewAfterSubmitPageTitle,  60);

		reporter.softAssert(this.getElementText(this.lblWriteReviewAfterSubmitPageTitle).equalsIgnoreCase(lsTitle),"The Title after submited WriteReview is equal to "+lsTitle,"The Title after submited WriteReview is not equal to "+lsTitle);
		reporter.softAssert(this.getElementText(this.lblWriteReviewAfterSubmitPageSubTitle).equalsIgnoreCase(lsSubTitle),"The SubTitle after submited WriteReview is equal to "+lsSubTitle,"The SubTitle after submited WriteReview is not equal to "+lsSubTitle);
	}

	public void verifyWriteReviewAfterSubmitContinueShoppingBackToProductDetails() {
		String lsUrl=this.waitForPageLoadingByUrlChange(lnkWriteReviewAfterSubmitPageContinueShopping);
		reporter.softAssert(lsUrl.toLowerCase().contains("pages/productdetails"),"Going back to product details page after clicking Continue Shopping button","Did not go back to product details page after clicking Continue Shopping button");
	}

	/**
	 * This method will verify Get the Look section and validate section.
	 * @return  void
	 * @author Wei.Li
	 */
	public void verifyGetTheLookSection() {
		reporter.softAssert(!this.getElementText(this.lblGetTheLookHeader).isEmpty(),"The Get The Look title is not empty","The Get The Look title is empty");
		if(this.getChildElementCount(this.cntGetTheLook)>2) {
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnGetTheLookPrev),"The Prev button is displaying correctly","The Prev button is not displaying correctly");
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnGetTheLookNext),"The Next button is displaying correctly","The Next button is not displaying correctly");
		}
		WebElement element;
		for(WebElement item: this.lstGetTheLookItem) {
			element=item.findElement(byGetTheLookProductLink);
			reporter.softAssert(!this.getElementHref(element).isEmpty(),"The Get the Look link is not empty","The Get the Look link is empty");

			element=item.findElement(byGetTheLookProductName);
			reporter.softAssert(!this.getElementText(element).isEmpty(),"The Product name in Get the Look section is not empty","The Product name in Get the Look section is empty");

			element=item.findElement(byGetTheLookProductBrand);
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(element),"The Product number in Get the Look section is displaying correctly","The Product number in Get the Look section is not displaying correctly");

			element=item.findElement(byGetTheLookProductNowPrice);
			reporter.softAssert(!this.getElementText(element).isEmpty(),"The Product Now price in Get the Look section is not empty","The Product Now price in Get the Look section is empty");

			element=item.findElement(byGetTheLookProductPriceContainer);
			if(this.getChildElementCount(element)>2) {
				element=item.findElement(byGetTheLookProductWasPrice);
				reporter.softAssert(!this.getElementText(element).isEmpty(),"The Product Was price in Get the Look section is not empty","The Product Was price in Get the Look section is empty");
			}
		}
	}

	/**
	 * This method will verify Prev/Next button action in Get the Look section.
	 * @return  void
	 * @author Wei.Li
	 */
	public void verifyPrevAndNextButtonActionInGetTheLookSection() {
		if(this.getChildElementCount(this.cntGetTheLook)>2) {

			String lsLinkPrevBefore=this.lstGetTheLookItem.get(0).findElement(this.byGetTheLookProductLink).getAttribute("data-link-title");
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnGetTheLookPrev);
			this.clickWebElementUsingJS(this.btnGetTheLookPrev);
			//this.btnGetTheLookPrev.click();
			this.waitForCondition(Driver->{return !this.lstGetTheLookItem.get(0).findElement(this.byGetTheLookProductLink).getAttribute("data-link-title").equalsIgnoreCase(lsLinkPrevBefore);}, 10000);

			String lsLinkAfter=this.lstGetTheLookItem.get(0).findElement(this.byGetTheLookProductLink).getAttribute("data-link-title");
			reporter.softAssert(!lsLinkPrevBefore.equalsIgnoreCase(lsLinkAfter),"The Prev button works","The Prev button does not work");

			String lsLinkNextBefore=this.lstGetTheLookItem.get(this.lstGetTheLookItem.size()-1).findElement(this.byGetTheLookProductLink).getAttribute("data-link-title");
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnGetTheLookNext);
			this.clickWebElementUsingJS(this.btnGetTheLookNext);
			//this.btnGetTheLookNext.click();
			this.waitForCondition(Driver->{return !this.lstGetTheLookItem.get(this.lstGetTheLookItem.size()-1).findElement(this.byGetTheLookProductLink).getAttribute("data-link-title").equalsIgnoreCase(lsLinkNextBefore);}, 10000);

			lsLinkAfter=this.lstGetTheLookItem.get(this.lstGetTheLookItem.size()-1).findElement(this.byGetTheLookProductLink).getAttribute("data-link-title");
			reporter.softAssert(!lsLinkNextBefore.equalsIgnoreCase(lsLinkAfter),"The Next button works","The Next button does not work");
		}
	}

	/**
	 * Function verifies all accordions displayed for a product on PDP page
	 */
	public void verifyAccordionsForProductOnPage() {
		if(this.lstProductAccordions.size()>0){
			int counter = 0;
			for(WebElement accordion:this.lstProductAccordions){
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(accordion);
				//Accordion Heading
				String accordionHeadingName = accordion.findElement(this.accordionHeading).getText();
				if(!accordionHeadingName.isEmpty())
					reporter.reportLogPass("Accordion Heading is present as expected for: "+accordionHeadingName);
				else
					reporter.reportLogFail("Accordion Heading is not present for product on page");
				//Verify Product Overview Section is open by default
				WebElement accordionDisplayIcon = accordion.findElement(this.accordionPlusMinusIcon);
				if(accordionHeadingName.equalsIgnoreCase("Product Overview")){
					if(accordionDisplayIcon.getAttribute("class").contains("minus-icon"))
						reporter.reportLogPass("Product Overview Accordion is expanded by default for product");
					else
						reporter.reportLogFail("Product Overview Accordion is not expanded by default for product");
				}
				else{
					//this.getReusableActionsInstance().clickIfAvailable(accordionDisplayIcon);
					this.clickWebElementUsingJS(accordionDisplayIcon);
				}

				//Verify Accordion Content
				this.verifyAccordionContent(this.lstProductAccordions.get(counter));
				counter++;
			}
		}else
			reporter.reportLogFail("No Accordion is present for selected product on page");
	}

	/**
	 * Function verifies accordion content for a product on PDP page
	 * @param - accordion - WebElement for accordion
	 */
	public void verifyAccordionContent(WebElement accordion) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(accordion);
		WebElement accordionContentWebElement = accordion.findElement(this.accordionContents);
		String accordionName = accordion.findElement(this.accordionHeading).getText();
		if(this.getChildElementCount(accordionContentWebElement)>0){
			String accordionData;
			reporter.reportLog("Verifying content for accordion: "+accordionName);
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(accordionContentWebElement);
			if(accordionName.contains("Chart"))
				accordionData = accordionContentWebElement.findElement(By.xpath(".//img")).getAttribute("src");
			else
				accordionData = this.getElementText(accordionContentWebElement);
			reporter.softAssert(!accordionData.isEmpty(),"The accordion content for: "+accordionName+" is not empty","The accordion content for: "+accordionName+" is empty");
			//Verifying ReadMore and ReadLess button functionality
			this.verifyReadMoreLessButtonOnPDP(accordion);
		}else
			reporter.reportLog("No content is present for accordion : "+accordionName+" on PDP page");
	}

	/**
	 * Function to verify Accordion navigation from right side of PDP page
	 */
	public void verifyAccordionNavigationForSizeGuide(){
		//Closing Size Chart Accordion section if it is open by default or by some another test
		for(WebElement accordion:this.lstProductAccordions){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(accordion);
			String accordionName = accordion.findElement(this.accordionHeading).getText();
			if(accordionName.contains("Chart")){
				WebElement accordionDisplayIcon = accordion.findElement(this.accordionPlusMinusIcon);
				if(accordionDisplayIcon.getAttribute("class").contains("minus-icon")){
					//this.getReusableActionsInstance().clickIfAvailable(accordionDisplayIcon);
					this.clickWebElementUsingJS(accordionDisplayIcon);
					this.applyStaticWait(2000);
					if(accordionDisplayIcon.getAttribute("class").contains("plus-icon"))
						reporter.reportLogPass("Sizing Chart section is closed as expected");
					else
						reporter.reportLogFail("Sizing Chart section is not closed");
				}
				break;
			}
		}
		//Navigating to Sizing Chart to click and verify if user is navigating to Sizing Chart section
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkSizingChart);
		waitForCondition(Driver->{return this.lnkSizingChart.isDisplayed();},3000);
		//this.getReusableActionsInstance().clickIfAvailable(this.lnkSizingChart);
		this.clickWebElementUsingJS(this.lnkSizingChart);

		//Verification
		for(WebElement accordion:this.lstProductAccordions){
			String accordionName = accordion.findElement(this.accordionHeading).getText();
			if(accordionName.contains("Chart")){
				WebElement accordionDisplayIcon = accordion.findElement(this.accordionPlusMinusIcon);
				if(accordionDisplayIcon.getAttribute("class").contains("minus-icon"))
					reporter.reportLogPass("User is navigated to Sizing Chart accordion");
				else
					reporter.reportLogFail("User is not navigated to Sizing Chart accordion");
				break;
			}
		}
	}

	/**
	 * Function verifies Read More and Less Button on PDP page for accordions
	 * @param - accordion - WebElement
	 */
	public void verifyReadMoreLessButtonOnPDP(WebElement accordion){
		WebElement readMoreLessButton = accordion.findElement(this.accordionContentElement);
		if(this.checkChildElementExistingByTagName(readMoreLessButton,"button")){
			//Verifying Read More is displayed
			WebElement accordionButton = accordion.findElement(this.accordionReadMoreLessButton);
			if(accordionButton.getText().equals("Read More")){
				reporter.reportLogPass("Read More for Accordion is present");
				this.getReusableActionsInstance().clickIfAvailable(accordionButton);
			}
		}
		//Verification of Read Less Button
		if(this.checkChildElementExistingByTagName(readMoreLessButton,"button")){
			//Verifying Read More is displayed
			WebElement accordionButton = accordion.findElement(this.accordionReadMoreLessButton);
			if(accordionButton.getText().equals("Read Less")){
				reporter.reportLogPass("Read Less for Accordion is present");
				this.getReusableActionsInstance().clickIfAvailable(accordionButton);
				this.getReusableActionsInstance().staticWait(3000);
				if(accordionButton.getText().equals("Read More")){
					reporter.reportLogPass("Read More for Accordion is displayed after clicking Real Less");
				}
			}
		}
	}

	public void verifyProductBrandNameRedirectAction() {
		ProductResultsPage prp=new ProductResultsPage(this.getDriver());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkBrandName);
		reporter.softAssert(!this.getElementHref(this.lnkBrandName).isEmpty(),"The Brand name link is not empty","The Brand name link is empty");
		reporter.softAssert(!this.getElementText(this.lnkBrandName).isEmpty(),"TheBrand name text is not empty","The Brand name text is empty");
		String lsBrandName=this.lnkBrandName.getText().split(":")[1].trim();
		this.clickWebElementUsingJS(this.lnkBrandName);
		//this.lnkBrandName.click();
		this.waitForPageToLoad();

		reporter.softAssert(this.URL().toLowerCase().contains("productresults"),"The page has been switched to product results page","The page has not been switched to product results page");

		//Verifying Bug-19107 - Issue navigating to brand page from PDP
		//Verifying that PRP page is displaying results for expected brand
		this.waitForPageToLoad();

		prp.verifyProductsOnPRPByBrandName(lsBrandName);
	}

	public boolean checkIfFavShareMobileHighlighted() {

		return this.getElementInnerText(this.lblAddToFavoriteText).equalsIgnoreCase("Added to favorites");
	}

	/**
	 * To verify Fav icon Action
	 * @param - lsUserName
	 * @param - lsPassword
	 */
	public void verifyFavIconAction(String lsUserName, String lsPassword) {
		SignInPage loginPage=new SignInPage(this.getDriver());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavIcon);
		this.getReusableActionsInstance().clickIfAvailable(this.lnkFavIcon);
		this.clickWebElementUsingJS(this.lnkFavIconPopupSignIn);
		this.getReusableActionsInstance().waitForElementVisibility(loginPage.lblSignIn,  60);

		reporter.softAssert(this.URL().toLowerCase().contains("signin"),"The page has been navigated to signin page while no user login","The page has not been navigated to signin page while no user login");

		loginPage.LoginWithoutWaitingTime(lsUserName,lsPassword);
		this.waitForCondition(Driver->{return this.lblProductName.isDisplayed();},2000000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavIcon);
		if(checkIfFavShareMobileHighlighted())
			this.getReusableActionsInstance().clickIfAvailable(this.lnkFavIcon);
		this.getReusableActionsInstance().clickIfAvailable(this.lnkFavIcon);
		this.waitForCondition(Driver->{return checkIfFavShareMobileHighlighted();},20000);
		reporter.softAssert(checkIfFavShareMobileHighlighted(),"The FavShareMobile icon is highlighted after clicking with user login", "The FavShareMobile icon is not highlighted after clicking with user login");
	}

	/**
	 * To verify Popup Dialog After Clicking FavIcon
	 */
	public void verifyPopupDialogAfterClickingFavIcon() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavIcon);
		this.clickElement(this.lnkFavIcon);
//		this.applyStaticWait(300);
//		this.waitForCondition(Driver->{return this.lnkFavIconPopupSignIn.isDisplayed();},1000);

//		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavIconPopupSignIn);

		String favIconPopUpSignInText,favIconPopUpRegisterText;
		try{
			favIconPopUpSignInText = this.getElementInnerText(this.lnkFavIconPopupSignIn);
			favIconPopUpRegisterText = this.getElementInnerText(this.lnkFavIconPopupRegister);
		}
		catch (Exception e){
			this.clickElement(this.lnkFavIcon);
			this.applyStaticWait(100);
			favIconPopUpSignInText = this.lnkFavIconPopupSignIn.getText();
			favIconPopUpRegisterText = this.lnkFavIconPopupRegister.getText();
		}

		if(!favIconPopUpSignInText.isEmpty() &&
				!favIconPopUpRegisterText.isEmpty()) {
			reporter.reportLogPass("SignIn Link with text: " + favIconPopUpSignInText + " and Register link with text: " + favIconPopUpRegisterText + " on FavoIcon popup dialog is displaying correctly");
			//Applying static wait for Safari and browser execution
			this.applyStaticWait(3000);
		}else {
			reporter.reportLogFailWithScreenshot("SignIn Link with text: " + favIconPopUpSignInText + " and Register link with text: " + favIconPopUpRegisterText + " on FavoIcon popup dialog is not displaying correctly");
		}
		/**
		if(!this.lnkFavIconPopupSignIn.isDisplayed()){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavIcon);
		}
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavIconPopupRegister);
		if(!this.lnkFavIconPopupRegister.getText().isEmpty()){
			reporter.reportLogPass("Register link on FavoIcon popup dialog is displaying correctly");
			//Applying static wait here as fav sign in pop up closes
			this.applyStaticWait(3000);
		}
		else{
			reporter.reportLogFailWithScreenshot("Register link on FavoIcon popup dialog is not displaying correctly");
		}
		*/
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavIcon);
		this.clickElement(this.lnkFavIcon);
//		this.applyStaticWait(300);
//		this.waitForCondition(Driver->{return this.lnkFavIconPopupSignIn.isDisplayed();},1000);

		try{
			this.clickElement(this.lnkFavIconPopupSignIn);
		}
		catch (Exception e){

		}

		this.waitForCondition(Driver->{return this.URL().contains("signin");},20000);
		if(this.URL().contains("signin")){
			reporter.reportLogPass("The URL has been navigated to SignIn page correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The URL has not been navigated to SignIn page correctly");
		}

		try{
			this.navigateBack();
		}
		catch (Exception e){

		}

		this.waitForCondition(Driver->{return this.lblProductName.isDisplayed();},60000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavIcon);
		this.clickElement(this.lnkFavIcon);
//		this.applyStaticWait(300);
//		this.waitForCondition(Driver->{return this.lnkFavIconPopupSignIn.isDisplayed();},1000);

//		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavIconPopupRegister);

		try{
			this.clickElement(this.lnkFavIconPopupRegister);
		}
		catch(Exception e){

		}

		this.waitForCondition(Driver->{return this.URL().contains("createaccount");},20000);
		if(this.URL().contains("createaccount")){
			reporter.reportLogPass("The URL has been navigated to Register page correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The URL has not been navigated to Register page correctly");
		}

		try{
			this.navigateBack();
		}
		catch (Exception e){

		}

		this.waitForCondition(Driver->{return this.lblProductName.isDisplayed();},60000);
	}

	/**
	 * This method will go to PDP page with the matched product
	 * @param-List<String> lstKeyword: keyword list
	 * @param-String lsType: method type with "AllConditionsWithoutCheckingSoldOutCriteria"/"AllConditionsWithCheckingSoldOutCriteria"/"SoldOut"/"AddToBag"/"AdvanceOrder"
	 * @return true/false
	 * @author Wei.Li
	 * @throws IOException
	 */
	public boolean goToProductItemWithPreConditions(List<String> lstKeyword,String lsType,Map<String,Object> dataCriteria) throws IOException {
		ProductResultsPage prp=new ProductResultsPage(this.getDriver());
		ApiResponse apiResponse=new ApiResponse();
		ApiResponse.lsUrlType="-";

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		if(dataCriteria==null){
			outputDataCriteria.put("video", "1");
			outputDataCriteria.put("style", "1");
			outputDataCriteria.put("size", "1");
		}else{
			outputDataCriteria = dataCriteria;
		}

		switch(lsType) {
			case "AllConditionsWithoutCheckingSoldOutCriteria":
				for(String lsKeyword:lstKeyword) {
					product=apiResponse.getProductInfoFromKeyword(lsKeyword, outputDataCriteria,false,false,false);
					if(product!=null) {
						break;
					}
				}
				break;
			case "ConditionsForMultipleStyleAndSize":
				for(String lsKeyword:lstKeyword) {
					product=apiResponse.getProductInfoFromKeyword(lsKeyword, outputDataCriteria,false,false,true);
					if(product!=null) {
						break;
					}
				}
				break;
			case "ConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria":
				for(String lsKeyword:lstKeyword) {
					product=apiResponse.getProductInfoFromKeyword(lsKeyword, outputDataCriteria,false,true,false);
					if(product!=null) {
						break;
					}
				}
				break;
			case "AllConditionsWithCheckingSoldOutCriteria":
				for(String lsKeyword:lstKeyword) {
					product=apiResponse.getProductInfoFromKeyword(lsKeyword, outputDataCriteria,true,false,false);
					if(product!=null) {
						break;
					}
				}
				break;
			case "ConditionsForVideoAndStyleAndSizeWithCheckingSoldOutCriteria":
				for(String lsKeyword:lstKeyword) {
					product=apiResponse.getProductInfoFromKeyword(lsKeyword, outputDataCriteria,true,true,false);
					if(product!=null) {
						break;
					}
				}
				break;
			case "SoldOut":
				for(String lsKeyword:lstKeyword) {
					product=apiResponse.getProductInfoFromKeywordWithSoldOutInfo(lsKeyword, outputDataCriteria);
					if(product!=null) {
						break;
					}
				}
				break;
			case "AddToBag":
				for(String lsKeyword:lstKeyword) {
					product=apiResponse.getProductOfPDPForAddToBagFromKeyword(lsKeyword);
					if(product!=null) {
						break;
					}
				}
				break;
			case "AdvanceOrder":
				for(String lsKeyword:lstKeyword) {
					productDetailsItem=apiResponse.getProductInfoFromKeywordWithAdvanceOrderInfo(lsKeyword);
					if(productDetailsItem!=null) {
						break;
					}
				}
				break;
			case "ProductWithEasyPaySizeChartAndReviews":
				for(String lsKeyword:lstKeyword) {
					product=apiResponse.getProductInfoFromKeywordWithEasyPayReviewsTrueFitAndSizeChart(lsKeyword,dataCriteria,false);
					if(product!=null) {
						break;
					}
				}
				break;
			case "ProductWithEasyPaySizeChartAndReviewWithImage":
				for(String lsKeyword:lstKeyword) {
					product=apiResponse.getProductInfoFromKeywordWithEasyPayReviewsTrueFitAndSizeChart(lsKeyword,dataCriteria,true);
					if(product!=null) {
						break;
					}
				}
				break;
			case "DeliveryOptions":
				for(String lsKeyword:lstKeyword) {
					productDetailsItem=apiResponse.getProductInfoFromKeywordWithDeliveryOptionsInfo(lsKeyword);
					if(productDetailsItem!=null) {
						break;
					}
				}
				break;
			default:
				break;
		}

		selectedProduct=selectedProduct.assignValue(apiResponse.selectedProduct);
		if(!lsType.equalsIgnoreCase("AdvanceOrder")&&!lsType.equalsIgnoreCase("DeliveryOptions")) {
			if(product==null){
				reporter.reportLogFail("Unable to find the matched product");
				return false;
			}
			productDetailsItem=apiResponse.getProductDetailsForSpecificProductNumber(selectedProduct.productNumber);
		}
		else {
			if(productDetailsItem==null){
				reporter.reportLogFail("Unable to find the matched product");
				return false;
			}
		}

		reporter.reportLog(apiResponse.selectedProduct.pdpNavigationUrl);

		try{
			this.getDriver().get(apiResponse.selectedProduct.pdpNavigationUrl);
		}
		catch (Exception e){

		}

		this.waitForPageToLoad();
		return prp.waitForPDPPageLoading();
	}

	/**
	 * To get Product With Conditions For Video And Style And Size Without CheckingSoldOutCriteria
	 * @param-List<String> lstKeyword: keyword list
	 * @return true/false
	 * @author Wei.Li
	 * @throws IOException
	 */
	public String getProductWithConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria(List<String> lstKeyword,Map<String,Object> dataCriteria) throws IOException {
		ProductResultsPage prp=new ProductResultsPage(this.getDriver());
		ApiResponse apiResponse=new ApiResponse();
		ApiResponse.lsUrlType="-";

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		if(dataCriteria==null){
			outputDataCriteria.put("video", "1");
			outputDataCriteria.put("style", "1");
			outputDataCriteria.put("size", "1");
		}else{
			outputDataCriteria = dataCriteria;
		}

		for(String lsKeyword:lstKeyword) {
			product=apiResponse.getProductInfoFromKeyword(lsKeyword, outputDataCriteria,false,true,false);
			if(product!=null) {
				break;
			}
		}
		selectedProduct=selectedProduct.assignValue(apiResponse.selectedProduct);

		return selectedProduct.productName;
	}

	/**
	 * This method will go to PDP page with the matched product
	 * @param-int productNumber : Product Number
	 * @return true/false
	 * @author Wei.Li
	 * @throws IOException
	 */
	public boolean goToProductItemWithProductNumber(String productNumber) throws IOException {
		ProductResultsPage prp=new ProductResultsPage(this.getDriver());
		ApiResponse apiResponse=new ApiResponse();

		productDetailsItem=apiResponse.getProductDetailsForSpecificProductNumber(productNumber);

		if(selectedProduct.productName==null){
			reporter.reportLogFail("Unable to find the matched product");
			return false;
		}

		this.getDriver().get(apiResponse.selectedProduct.pdpNavigationUrl);

		return prp.waitForPDPPageLoading();
	}

	/**
	 * Method to set specific Style and Size
	 * @return void
	 * @author Wei.Li
	 */
	public void setProductStyleAndSize(String lsStyle,String lsSize) {
		int loopSize;
		if(this.judgeStyleDisplayModeIsDropdownMenu()) {
			Select selectStyle= new Select(this.selectProductStyle);
			selectStyle.selectByVisibleText(lsStyle);
		}
		else {
			loopSize=this.lstRadioStyleLabelSpanList.size();
			WebElement radioItem,labelItem;
			for(int i=0;i<loopSize;i++) {
				radioItem=this.lstRadioStyleLabelSpanList.get(i);
				labelItem=this.lstRadioStyleLabelList.get(i);
				if(labelItem.getAttribute("title").equalsIgnoreCase(lsStyle)){
//					this.getReusableActionsInstance().javascriptScrollByVisibleElement(radioItem);
//					labelItem.click();
					this.clickElement(labelItem);
					this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
					break;
				}
			}
		}
		Select selectSize= new Select(this.selectSizeOption);
		selectSize.selectByVisibleText(lsSize);
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
	}

	/**
	 * Method to go To SignIn By Clicking Checkout button In AddToBag Popup Window
	 * @return void
	 * @author Wei.Li
	 */
	public void goToSignInByClickingCheckoutInAddToBagPopupWindow(){
		openAddToBagPopupWindow();
//		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowButtonSectionCheckOut);
//		this.getReusableActionsInstance().clickIfAvailable(this.btnAddToBagPopupWindowButtonSectionCheckOut);
		this.clickElement(this.btnAddToBagPopupWindowButtonSectionCheckOut);
		SignInPage signInPage=new SignInPage(this.getDriver());
		this.getReusableActionsInstance().waitForElementVisibility(signInPage.lblSignIn,120);
	}

	/**
	 * To get Full Information On PDP
	 * @param - boolean - bBrand
	 * @param - boolean - bReview
	 * @param - boolean - bWasPrice
	 * @param - boolean - bStyle
	 * @param - boolean - bSize
	 * @return - Map<String,String> - including productName,productBrand,productNowPrice,
	 * 	  			productWasPrice,productReviewRate,productReviewCount, productStyle, productSize
	 */
	public Map<String,String> getFullInformationOnPDP(boolean bBrand,boolean bReview,boolean bWasPrice,boolean bStyle,boolean bSize){
		Map<String,String> map=new HashMap<>();
		String lsText;

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblProductName);
		lsText=lblProductName.getText().trim();
		map.put("productName",lsText);

		if(bBrand){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkBrandName);
			lsText=lnkBrandName.getAttribute("Title").trim();
			map.put("productBrand",lsText);
		}
		else{
			map.put("productBrand",null);
		}

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblProductNowPrice);
		lsText= String.valueOf(this.getFloatFromString(lblProductNowPrice.getText(),true));
		map.put("productNowPrice",lsText);

		if(bWasPrice){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblProductWasPrice);
			lsText=String.valueOf(this.getFloatFromString(lblProductWasPrice.getText(),true));
			map.put("productWasPrice",lsText);
		}
		else{
			map.put("productWasPrice",null);
		}

		if(bReview){
			ProductResultsPage prp=new ProductResultsPage(this.getDriver());
			int reviewRate=prp.getProductItemReviewNumberAmountFromStarImage(lstProductReviewStar);
			map.put("productReviewRate",reviewRate+"");

			lsText=this.getElementInnerText(lblProductReviewCount);
			int reviewCount=this.getIntegerFromString(lsText);
			map.put("productReviewCount",reviewCount+"");
		}
		else{
			map.put("productReviewRate",null);
			map.put("productReviewCount",null);
		}

		if(bStyle){
			lsText=this.getElementInnerText(lblRadioProductStyleTitle).split(":")[1].trim();
			map.put("productStyle",lsText);
		}
		else{
			map.put("productStyle",null);
		}

		if(bSize){
			lsText=this.getElementInnerText(lblSizeTitle).split(":")[1].trim();
			map.put("productSize",lsText);
		}
		else{
			map.put("productSize",null);
		}

		return map;
	}

	/**
	 * To verify Linkage Info Between PRP And PDP
	 * @param - Map<String,String> - prpMap
	 * @param - Map<String,String> - pdpMap
	 */
	public void verifyLinkageInfoBetweenPRPAndPDP(Map<String,String> prpMap,Map<String,String> pdpMap){
		String lsTextPRP,lsTextPDP;

		lsTextPRP=prpMap.get("productName");
		lsTextPDP=pdpMap.get("productName");
		if(lsTextPRP.equalsIgnoreCase(lsTextPDP)){
			reporter.reportLogPass("The product name:'"+lsTextPRP+"' on PRP is the same as the one:'"+lsTextPDP+"' on PDP");
		}
		else{
			reporter.reportLogFail("The product name:'"+lsTextPRP+"' on PRP is not the same as the one:'"+lsTextPDP+"' on PDP");
		}

		lsTextPRP=prpMap.get("productBrand");
		if(lsTextPRP!=null){
			lsTextPDP=pdpMap.get("productBrand");
			if(lsTextPRP.equalsIgnoreCase(lsTextPDP)){
				reporter.reportLogPass("The product brand:'"+lsTextPRP+"' on PRP is the same as the one:'"+lsTextPDP+"' on PDP");
			}
			else{
				reporter.reportLogFail("The product brand:'"+lsTextPRP+"' on PRP is not the same as the one:'"+lsTextPDP+"' on PDP");
			}
		}

		lsTextPRP=prpMap.get("productReviewRate");
		if(lsTextPRP!=null){
			lsTextPDP=pdpMap.get("productReviewRate");
			if(lsTextPRP.equalsIgnoreCase(lsTextPDP)){
				reporter.reportLogPass("The product review rate:'"+lsTextPRP+"' on PRP is the same as the one:'"+lsTextPDP+"' on PDP");
			}
			else{
				reporter.reportLogFail("The product review rate:'"+lsTextPRP+"' on PRP is not the same as the one:'"+lsTextPDP+"' on PDP");
			}
		}

		lsTextPRP=prpMap.get("productReviewCount");
		if(lsTextPRP!=null){
			lsTextPDP=pdpMap.get("productReviewCount");
			if(lsTextPRP.equalsIgnoreCase(lsTextPDP)){
				reporter.reportLogPass("The product review count:'"+lsTextPRP+"' on PRP is the same as the one:'"+lsTextPDP+"' on PDP");
			}
			else{
				reporter.reportLogFail("The product review count:'"+lsTextPRP+"' on PRP is not the same as the one:'"+lsTextPDP+"' on PDP");
			}
		}

		lsTextPRP=prpMap.get("productNowPrice");
		lsTextPDP=pdpMap.get("productNowPrice");
		if(lsTextPRP.equalsIgnoreCase(lsTextPDP)){
			reporter.reportLogPass("The product NowPrice:'"+lsTextPRP+"' on PRP is the same as the one:'"+lsTextPDP+"' on PDP");
		}
		else{
			reporter.reportLogFail("The product NowPrice:'"+lsTextPRP+"' on PRP is not the same as the one:'"+lsTextPDP+"' on PDP");
		}

		lsTextPRP=prpMap.get("productWasPrice");
		if(lsTextPRP!=null){
			lsTextPDP=pdpMap.get("productWasPrice");
			if(lsTextPRP.equalsIgnoreCase(lsTextPDP)){
				reporter.reportLogPass("The product WasPrice:'"+lsTextPRP+"' on PRP is the same as the one:'"+lsTextPDP+"' on PDP");
			}
			else{
				reporter.reportLogFail("The product WasPrice:'"+lsTextPRP+"' on PRP is not the same as the one:'"+lsTextPDP+"' on PDP");
			}
		}

		lsTextPRP=prpMap.get("productStyle");
		if(lsTextPRP!=null){
			lsTextPDP=pdpMap.get("productStyle");
			if(lsTextPRP.equalsIgnoreCase(lsTextPDP)){
				reporter.reportLogPass("The product style:'"+lsTextPRP+"' on PRP is the same as the one:'"+lsTextPDP+"' on PDP");
			}
			else{
				reporter.reportLogFail("The product style:'"+lsTextPRP+"' on PRP is not the same as the one:'"+lsTextPDP+"' on PDP");
			}
		}

		lsTextPRP=prpMap.get("productSize");
		if(lsTextPRP!=null){
			lsTextPDP=pdpMap.get("productSize");
			if(lsTextPRP.equalsIgnoreCase(lsTextPDP)){
				reporter.reportLogPass("The product size:'"+lsTextPRP+"' on PRP is the same as the one:'"+lsTextPDP+"' on PDP");
			}
			else{
				reporter.reportLogFail("The product size:'"+lsTextPRP+"' on PRP is not the same as the one:'"+lsTextPDP+"' on PDP");
			}
		}
	}

	/**
	 * Method to choose given Style and Size
	 * @param - lsStyle - given Style
	 * @param - lsSize - given Size
	 * @return void
	 * @author Wei.Li
	 */
	public void chooseGivenStyleAndSize(String lsStyle,String lsSize) {
		int loopSize;
		WebElement labelItem;

		//To choose Size
		loopSize=this.lstAllSizeRadioList.size();
		for(int i=0;i<loopSize;i++) {
			labelItem=this.lstAllSizeLabelRadioList.get(i);
			if(labelItem.getAttribute("for").equalsIgnoreCase(lsSize)){
				try{
					this.clickElement(this.lstAllSizeRadioList.get(i));
				}
				catch(Exception e){

				}

				break;
			}
		}
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		//To choose Style
		if(this.judgeStyleDisplayModeIsDropdownMenu()) {
			Select selectStyle= new Select(this.selectProductStyle);
			selectStyle.selectByVisibleText(lsStyle);
		}
		else {
			loopSize=this.lstAllStyleRadioList.size();
			for(int i=0;i<loopSize;i++) {
				labelItem=this.lstAllStyleLabelRadioList.get(i);
				if(labelItem.getAttribute("for").equalsIgnoreCase(lsStyle)){
					this.clickElement(labelItem);
					break;
				}
			}
		}
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
	}

	/**
	 * Method to choose given Style, Size and quantity
	 * @param - String - lsStyle - given Style
	 * @param - String - lsSize - given Size
	 * @param - int - quantity - given quantity
	 * @return void
	 * @author Wei.Li
	 */
	public void chooseGivenStyleAndSizeAndQuantity(String lsStyle,String lsSize,int quantity) {
		int loopSize;
		WebElement labelItem;

		//To choose Style
		if(this.judgeStyleDisplayModeIsDropdownMenu()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectProductStyle);
			Select selectStyle= new Select(this.selectProductStyle);
			selectStyle.selectByVisibleText(lsStyle);
		}
		else {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblRadioProductStyleTitle);
			loopSize=this.lstAllStyleRadioList.size();
			for(int i=0;i<loopSize;i++) {
				labelItem=this.lstAllStyleLabelRadioList.get(i);
				if(labelItem.getAttribute("for").equalsIgnoreCase(lsStyle)){
					this.clickElement(labelItem);
					break;
				}
			}
		}
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		//To choose Size
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblSizeTitle);
		loopSize=this.lstAllSizeRadioList.size();
		for(int i=0;i<loopSize;i++) {
			labelItem=this.lstAllSizeLabelRadioList.get(i);
			if(labelItem.getAttribute("for").equalsIgnoreCase(lsSize)){
				try{
					this.clickElement(this.lstAllSizeRadioList.get(i));
				}
				catch(Exception e){

				}

				break;
			}
		}
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());

		//To choose quantity
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectQuantityOption);
		Select selectQuantity= new Select(this.selectQuantityOption);
		selectQuantity.selectByVisibleText(String.valueOf(quantity));
		this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
	}

	/**
	 * To check Image Zooming Status
	 * @return true/false
	 */
	public boolean checkImageZoomingStatus(){
		return this.currentZoomImageIndicator.getAttribute("class").contains("swiper-slide-zoomed");
	}

	/**
	 * To verify zooming image action
	 */
	public void verifyZoomingImageAction(){
		WebElement item=lstThumbnailImageButtonWithoutVideoList.get(0);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		this.clickWebElementUsingJS(item);
		//item.click();
		this.applyStaticWait(2*this.getStaticWaitForApplication());

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(lnkCurrentZoomImage);
		lnkCurrentZoomImage.click();
		//this.applyStaticWait(2*this.getStaticWaitForApplication());
		this.waitForCondition(Driver->{return this.currentZoomImageIndicator.getAttribute("class").contains("swiper-slide-zoomed");},7000);
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

	/**
	 * Function verifies Easy Pay pop up after clicking
	 */
	public void verifyEasyPayPopUp(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductEasyPay);
		this.getReusableActionsInstance().clickIfAvailable(this.btnProductEasyPay);
		if(this.waitForCondition(Driver->{return this.lblProductEasyPayPopupHeading.isDisplayed();},20000)){
			//Verifying the content
			if(this.waitForCondition(Driver->{return this.lblProductEasyPayPopupContent.isDisplayed() && !this.lblProductEasyPayPopupContent.getText().isEmpty();},7000)) {
				reporter.reportLogPass("Easy Pay pop up contains text as expected after clicking on Easy Pay on PDP");
				//Closing Easy Pay pop up
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductEasyPayPopupClose);
				this.getReusableActionsInstance().clickIfAvailable(this.btnProductEasyPayPopupClose);
				this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			}else
				reporter.reportLogFailWithScreenshot("Easy Pay pop up contains text as expected after clicking on Easy Pay on PDP");
		}else
			reporter.reportLogFailWithScreenshot("Easy Pay pop up is not displayed as expected after clicking on Easy Pay on PDP");
	}

	/**
	 * To set Video As First Item In ThumbnailList, which is to handle mobile device
	 * @return true/false
	 */
	public boolean setVideoAsFirstItemInThumbnailList(){
		WebElement firstItem=this.lstThumbnailImageList.get(0);
		if(this.hasElementAttribute(firstItem,"data-video")){
			return true;
		}

		int sum=0;
		do{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnThumbnailPrev);
			this.getReusableActionsInstance().clickIfAvailable(this.btnThumbnailPrev);
			//Keep it to wait for clicking action result
			this.getReusableActionsInstance().staticWait(5*this.getStaticWaitForApplication());
			firstItem=this.lstThumbnailImageList.get(0);
			sum++;
			if(sum>10){
				return false;
			}
		}
		while(!this.hasElementAttribute(firstItem,"data-video"));

		return true;
	}

	/**
	 * To set Prev button displayed In ThumbnailList
	 * @return true/false
	 */
	public boolean setPrevButtonDisplayingInThumbnailList(){
		WebElement firstItem=this.lstThumbnailImageList.get(0);
		if(checkThumbnailPrevButtonExisting()){
			return true;
		}

		int sum=0;
		do{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnThumbnailNext);
			this.getReusableActionsInstance().clickIfAvailable(this.btnThumbnailNext);
			//Keep it to wait for clicking action result
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			sum++;
			if(sum>10){
				return false;
			}
		}
		while(checkThumbnailPrevButtonExisting());

		return true;
	}

	/**
	 * To set Next button displayed In ThumbnailList
	 * @return true/false
	 */
	public boolean setNextButtonDisplayingInThumbnailList(){
		WebElement firstItem=this.lstThumbnailImageList.get(0);
		if(checkThumbnailNextButtonExisting()){
			return true;
		}

		int sum=0;
		do{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnThumbnailPrev);
			this.getReusableActionsInstance().clickIfAvailable(this.btnThumbnailPrev);
			//Keep it to wait for clicking action result
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			sum++;
			if(sum>10){
				return false;
			}
		}
		while(checkThumbnailNextButtonExisting());

		return true;
	}

	/**
	 * To set Next button disappear In ThumbnailList
	 * @return true/false
	 */
	public boolean setNextButtonDisappearInThumbnailList(){
		setNextButtonDisplayingInThumbnailList();

		int sum=0;
		do{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnThumbnailNext);
			this.getReusableActionsInstance().clickIfAvailable(this.btnThumbnailNext);
			//Keep it to wait for clicking action result
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			sum++;
			if(sum>10){
				return false;
			}
		}
		while(!checkThumbnailNextButtonExisting());

		return true;
	}

	/**
	 * To set Prev button disappear In ThumbnailList
	 * @return true/false
	 */
	public boolean setPrevButtonDisappearInThumbnailList(){
		setPrevButtonDisplayingInThumbnailList();

		int sum=0;
		do{
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnThumbnailPrev);
			this.getReusableActionsInstance().clickIfAvailable(this.btnThumbnailPrev);
			//Keep it to wait for clicking action result
			this.getReusableActionsInstance().staticWait(this.getStaticWaitForApplication());
			sum++;
			if(sum>10){
				return false;
			}
		}
		while(!checkThumbnailPrevButtonExisting());

		return true;
	}

	/**
	 * To verify Product AdvancedOrder Message
	 */
	public void verifyProductAdvancedOrderMessage(String lsAdvancedOrderMessage) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAdvanceOrderMsg);
		String lsMsg=this.lblAdvanceOrderMsg.getText();
		reporter.softAssert(!lsMsg.isEmpty(),"The Advanced order message is not empty","The Advanced order message is empty");
		if(lsMsg.toLowerCase().contains(lsAdvancedOrderMessage.trim().toLowerCase())){
			reporter.reportLogPass("The Advanced Order message is displaying correctly");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Advanced Order message is not containing '"+lsAdvancedOrderMessage+"' correctly");
		}
	}

	/**
	 * To verify Review Histogram Item Clicking Action
	 */
	public void verifyReviewHistogramItemClickingAction(){
		int reviewHisRate,reviewHisItemCount,reviewRate;
		ProductResultsPage prp=new ProductResultsPage(this.getDriver());

		int loopSize=this.lstReviewTabHistogramItem.size();
		for(int i=0;i<loopSize;i++){
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstReviewTabHistogramItem.get(i));
			reviewHisRate=this.getIntegerFromString(this.getElementInnerText(this.lstReviewTabHistogramItemLabel.get(i)));
			reviewHisItemCount=this.getIntegerFromString(this.getElementInnerText(this.lstReviewTabHistogramItemCount.get(i)));
			if(reviewHisItemCount==0){
				continue;
			}

			this.clickElement(this.lstReviewTabHistogramClickingButton.get(i));
			this.getReusableActionsInstance().staticWait(10*this.getStaticWaitForApplication());

			int reviewListAmount=lstReviewTabPerReviewList.size();
			if(reviewHisItemCount==reviewListAmount){
				reporter.reportLogPass("The filtering review amount: "+reviewHisItemCount+" is equal to the related review histogram item count: "+reviewListAmount);
			}
			else{
				reporter.reportLogFailWithScreenshot("The filtering review amount: "+reviewHisItemCount+" is not equal to the related review histogram item count: "+reviewListAmount);
			}

			for(WebElement element:this.lstReviewTabPerReviewList){
				List<WebElement> lstReviewStar=element.findElements(byReviewTabStarList);
				reviewRate=prp.getProductItemReviewNumberAmountFromStarImage(lstReviewStar)/100;
				if(reviewRate==reviewHisRate){
					reporter.reportLogPass("The review rate: "+reviewRate+" of filtering item is equal to the related review histogram item review rate: "+reviewHisRate);
				}
				else{
					reporter.reportLogFailWithScreenshot("The review rate of filtering item:"+reviewRate+" is not equal to the related review histogram item review rate: "+reviewHisRate);
				}
			}
		}

		//Removing selected histogram stars for further verification
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblReviewHistogramCrossButton);
		this.getReusableActionsInstance().scrollToElement(this.lblReviewHistogramCrossButton);
		//this.getReusableActionsInstance().clickIfAvailable(this.lblReviewHistogramCrossButton);
		this.clickWebElementUsingJS(this.lblReviewHistogramCrossButton);

		this.waitForPageToLoad();
	}

	/**
	 * This functions add items to shopping cart page for logged-in user
	 * @param - List<String> searchKeyword - search keyword list for items to be added to shopping cart
	 * @param - String customerEDP - customerEDP number for user
	 * @param - String accessToken - access token for api
	 * @return - CartResponse - CartResponse class object
	 */
	public CartResponse addItemsToShoppingCartForUser(List<String> searchKeyword,String customerEDP, String accessToken) throws IOException {
		//Fetching item to be added for a new cart
		ProductAPI productAPI=new ProductAPI();
		CartAPI cartAPI=new CartAPI();
		Response response = null;
		List<Product.edps> products = productAPI.getEDPNoForNotSoldOutProduct(searchKeyword.get(0),null,true,5);
		List<Integer> edpsList = products.stream().map(Product.edps::getEdpNo).collect(Collectors.toList());

		if(products.size()>0){
			//Creating a new cart and adding an item to created cart
			response = cartAPI.createNewCartOrAddItems(edpsList,1,Integer.valueOf(customerEDP),accessToken,null);
		}else
			return null;

		//Adding second item to cart created for the user
		CartResponse cartResponse = JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
		if(cartResponse!=null){
			products = productAPI.getEDPNoForNotSoldOutProduct(searchKeyword.get(1),null,true,1);
			edpsList.clear();
			edpsList = products.stream().map(Product.edps::getEdpNo).collect(Collectors.toList());
			response = cartAPI.createNewCartOrAddItems(edpsList,1,Integer.valueOf(customerEDP),accessToken,cartResponse.getCartGuid());
			return JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
		}else
			return null;
	}

	/**
	 * To open shopping page through clicking ViewShoppingBag button on AddToBag popup window
	 * @return
	 */
	public boolean goToShoppingCartPage() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowButtonSectionViewShoppingBag);
		this.btnAddToBagPopupWindowButtonSectionViewShoppingBag.click();
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(this.getDriver());
		return this.waitForCondition(Driver -> {
			return shoppingCartPage.lblCartTitle.isDisplayed();
		}, 20000);
	}

	/**
	 * This function returns shopping bag items details for a user
	 * @param - CartResponse object fetched from api containing shopping bag details object
	 * @return - Map<String,Map<String,Object> - Map object containing item details
	 */
	public Map<String,Map<String,Object>> getShoppingBagItemsDetailAddedForUser(CartResponse cartResponse){
		Map<String,Map<String,Object>> cartItemDetails = null;
		if(cartResponse!=null){
			cartItemDetails = new HashMap<>();
			List<CartResponse.CartLinesClass> cartLinesClass = cartResponse.getCartLines();
			List<CartResponse.ProductsClass> productsClasses = cartResponse.getProducts();
			for(CartResponse.CartLinesClass cartLines : cartLinesClass){
				Map<String,Object> itemDetails = new HashMap<>();
				itemDetails.put("productNumber",this.getIntegerFromString(cartLines.getCartLineItem().getItemNo()));
				itemDetails.put("productStyle",cartLines.getCartLineItem().getStyle());
				itemDetails.put("productStyleDimension",cartLines.getCartLineItem().getStyleDimensionId());
				itemDetails.put("productSize",cartLines.getCartLineItem().getSize());
				itemDetails.put("productNowPrice",this.getFloatFromString(cartLines.getCartLineItem().getAppliedPrice(),true));
				for(CartResponse.ProductsClass products : productsClasses){
					if(products.getItemNo().equalsIgnoreCase(itemDetails.get("productNumber").toString())){
						itemDetails.put("productName",products.getName());
						break;
					}
				}
				cartItemDetails.put(itemDetails.get("productNumber").toString(),itemDetails);
			}
		}
		return cartItemDetails;
	}

	/**
	 * To get style list related togoToProductItemWithPreConditions(lstKeywordList,"ConditionsForMultipleStyleAndSize",outputDataCriteria)
	 * @return - String[]
	 */
	public String[] getStyleList(){
		return this.selectedProduct.productEDPColor.split("\\|");
	}

	/**
	 * To get size list for given style related to goToProductItemWithPreConditions(lstKeywordList,"ConditionsForMultipleStyleAndSize",outputDataCriteria)
	 * @param - int - styleIndex - the given style index
	 * @return - String[]
	 */
	public String[] getSizeListForGivenStyle(int styleIndex){
		return selectedProduct.productEDPSize.split("\\|")[styleIndex].split(":");
	}

	/**
	 * This function returns default values for product selected on PDP page for user
	 * @return - Map<String,Object> - map object of default size and style selected for user
	 */
	public Map<String,String> fetchDefaultSizeAndStyleSelectedForUserOnPDP(){
		ProductResultsPage prp=new ProductResultsPage(this.getDriver());
		Map<String,String> defaultValueMap = new HashMap<>();
		this.waitForPageToLoad();
		prp.waitForPDPPageLoading();
		//Fetching default selected size
		this.getReusableActionsInstance().scrollToElement(this.lblSelectedDefaultSize);
		defaultValueMap.put("size",this.lblSelectedDefaultSize.findElement(By.xpath("./input")).getAttribute("id"));
		//Fetching default selected colour
		defaultValueMap.put("colour",this.lblSelectedDefaultColour.findElement(By.xpath("./input")).getAttribute("id"));
		return defaultValueMap;
	}

	/**
	 * This function selects size and colour other than default one selected on PDP
	 * @param - Map<String,String> - map object with default values for product
	 * @param - String[] - list of string for all styles that are available for product
	 */
	public void selectSizeAndColourOtherThanDefaultOnPDP(Map<String,String> defaultSelectedValues,String[] lstStyle){
		boolean flag = false;
		if(lstStyle.length>0){
			//Selecting the colour other than default colour on PDP page
			for(int counter=0;counter<lstStyle.length;counter++){
				if(!lstStyle[counter].equalsIgnoreCase(defaultSelectedValues.get("colour"))){
					String[] lstSize=this.getSizeListForGivenStyle(counter);
					//Selecting the size
					for(int i = 0; i< this.lstRadioStyleLabelNotSelectedList.size();i++){
						if(this.lstRadioStyleLabelNotSelectedList.get(i).findElement(By.xpath("./input")).getAttribute("id").equalsIgnoreCase(lstStyle[counter])){
							this.getReusableActionsInstance().clickIfAvailable(this.lstRadioStyleLabelNotSelectedList.get(i));
							flag = true;
							break;
						}
					}
					if(flag){
						boolean sizeFlag = false;
						//Selecting the size
						for(String size:lstSize){
							if(!size.equalsIgnoreCase(defaultSelectedValues.get("size"))){
								for(int i = 0; i< this.lstRadioSizeLabelNotSelectedList.size();i++){
									if(this.lstRadioSizeLabelNotSelectedList.get(i).findElement(By.xpath("./input")).getAttribute("id").equalsIgnoreCase(size)){
										sizeFlag = true;
										this.getReusableActionsInstance().clickIfAvailable(this.lstRadioSizeLabelNotSelectedList.get(i));
										break;
									}
								}
							}
							if(sizeFlag)
								break;
						}
						break;
					}
				}
			}
		}
	}

	/**
	 * Function verifies that uploaded images in review is displayed in review histogram section
	 */
	public void verifyReviewImagesInHistogram(HashMap<String,HashMap<String,String>> reviewDataMap){
		this.waitForPageToLoad();
		//Navigating to Histogram section
		//if(System.getProperty("Browser").contains("safari"))
		this.getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		//this.getReusableActionsInstance().clickIfAvailable(this.lnkReviewTabBackToTop);
		this.getReusableActionsInstance().scrollToElement(this.lblReviewPicturesInHistogram);
		if(waitForCondition(Driver->{return lblReviewPicturesInHistogram.isDisplayed();},5000)){
			reporter.reportLogPassWithScreenshot("Review Images are displayed in Histogram section of reviews");
			//Verifying click functionality for image
			//this.lblReviewPicturesInHistogram.findElement(By.xpath("./button")).click();
			this.clickWebElementUsingJS(this.lblReviewPicturesInHistogram.findElement(By.xpath("./button")));
			waitForCondition(Driver->{return this.lblReviewImagePopUpModelCloseButton.isDisplayed() &&
							this.lblReviewImagePopUpModelCloseButton.isEnabled();},6000);

			//Verifying data on image window for user comments
			//Fetching map data to be used for verification
			this.getReusableActionsInstance().scrollToElement(this.lblReviewHeadlineOnPopUpWindow);
			String headingForReviewFromWindow = this.lblReviewHeadlineOnPopUpWindow.getText().trim();
			Map<String,String> reviewDataByUser = reviewDataMap.get(headingForReviewFromWindow);

			reporter.reportLog("Verifying image source on review image pop-up");
			this.getReusableActionsInstance().scrollToElement(this.lblReviewImageOnPopUpWindow);
			String[] imageURLSplit = this.lblReviewImageOnPopUpWindow.getAttribute("src").split(Pattern.quote("/"));
			String[] imageURLFromReviewSplit = reviewDataByUser.get("imageLink").split(Pattern.quote("/"));
			if(imageURLSplit[imageURLSplit.length-1].equalsIgnoreCase(imageURLFromReviewSplit[imageURLFromReviewSplit.length-1]))
				reporter.reportLogPass("Image URL is same as expected on review pop-up window");
			else
				reporter.reportLogFailWithScreenshot("Image URL is not same as expected on window");

			reporter.reportLog("Verifying stars count on review image pop-up");
			this.getReusableActionsInstance().scrollToElement(this.lblReviewStarsOnPopUpWindow);
			String reviewPopUpStarsCount = this.lblReviewStarsOnPopUpWindow.getText().trim();
			if(reviewPopUpStarsCount.equalsIgnoreCase(reviewDataByUser.get("reviewStars")))
				reporter.reportLogPass("Review Stars are same as expected on review pop-up window");
			else
				reporter.reportLogFailWithScreenshot("Review Stars are not same as expected on window");

			reporter.reportLog("Verifying review submitted time on review image pop-up");
			this.getReusableActionsInstance().scrollToElement(this.lblReviewPostedDateOnPopUpWindow);
			String reviewPopUpReviewSubmittedTime = this.lblReviewPostedDateOnPopUpWindow.getText().trim().split(" ")[0];
			if(Integer.valueOf(reviewPopUpReviewSubmittedTime)>=Integer.valueOf(reviewDataByUser.get("reviewSubmittedTime")))
				reporter.reportLogPass("Review Submitted Time is same as expected on review pop-up window");
			else
				reporter.reportLogFailWithScreenshot("Review Submitted Time is not same as expected on window");

			reporter.reportLog("Verifying Flag Image is a link on review image pop-up");
			this.getReusableActionsInstance().scrollToElement(this.lnlFlagImageOnPopUpWindow);
			if(this.lnlFlagImageOnPopUpWindow.isEnabled()){
				//this.lnlFlagImageOnPopUpWindow.click();
				this.clickWebElementUsingJS(this.lnlFlagImageOnPopUpWindow);
				waitForCondition(Driver->{return this.lblFlagImageEmailText.isEnabled() &&
								this.lblFlagImageEmailText.isDisplayed();},5000);
				reporter.reportLogPassWithScreenshot("Flag Image is a link and navigates to pop-up window on clicking as expected");
				this.getReusableActionsInstance().scrollToElement(this.btnFlagImagePopUpWindowCancelButton);
				//this.getReusableActionsInstance().clickIfAvailable(this.btnFlagImagePopUpWindowCancelButton);
				this.clickWebElementUsingJS(this.btnFlagImagePopUpWindowCancelButton);
				waitForCondition(Driver -> {return this.lnlFlagImageOnPopUpWindow.isDisplayed() &&
								this.lnlFlagImageOnPopUpWindow.isEnabled();},6000);

			}else
				reporter.reportLogFailWithScreenshot("Flag Image Link is not displayed on review window");

			reporter.reportLog("Verifying Read Review is a link on review image pop-up");
			this.getReusableActionsInstance().scrollToElement(this.btnReadReviewOnPopUpWindowBtn);
			//this.getReusableActionsInstance().clickIfAvailable(this.btnReadReviewOnPopUpWindowBtn);
			this.clickWebElementUsingJS(this.btnReadReviewOnPopUpWindowBtn);
			if(waitForCondition(Driver->{return this.btnBackToMediaBtn.isEnabled() &&
				this.btnBackToMediaBtn.isDisplayed();},6000)){
				reporter.reportLogPassWithScreenshot("Read Review pop up window is displayed as expected");
				//Verifying comment provided
				this.getReusableActionsInstance().scrollToElement(this.lblComment);
				String comments = this.lblComment.getText().trim();
				if(comments.equalsIgnoreCase(reviewDataByUser.get("reviewTabDescription")))
					reporter.reportLogPass("Comments displayed matches with comments by user");
				else
					reporter.reportLogFail("Comments displayed are not same as that by user");

				//Verifying comment By
				this.getReusableActionsInstance().scrollToElement(this.lblCommentBy);
				String commentsBy = this.lblCommentBy.getText().trim();
				if(commentsBy.equalsIgnoreCase(reviewDataByUser.get("reviewTabNickName")))
					reporter.reportLogPass("Comments Nick Name displayed matches with that of user");
				else
					reporter.reportLogFail("Comments Nick Name displayed are not same as that as of user");

				//Navigating back to pop-up window
				this.getReusableActionsInstance().scrollToElement(this.btnBackToMediaBtn);
				//this.getReusableActionsInstance().clickIfAvailable(this.btnBackToMediaBtn);
				this.clickWebElementUsingJS(this.btnBackToMediaBtn);
				waitForCondition(Driver->{return this.lblReviewImagePopUpModelCloseButton.isDisplayed() &&
						this.lblReviewImagePopUpModelCloseButton.isEnabled();},6000);
			}else
				reporter.reportLogFailWithScreenshot("Read Review pop up window is not displayed");

			//Closing pop-up window
			this.getReusableActionsInstance().scrollToElement(this.lblReviewImagePopUpModelCloseButton);
			//this.getReusableActionsInstance().clickIfAvailable(this.lblReviewImagePopUpModelCloseButton);
			this.clickWebElementUsingJS(this.lblReviewImagePopUpModelCloseButton);
			waitForCondition(Driver->{return this.lstReviewTabHistogramItem.get(0).isDisplayed() &&
					this.lstReviewTabHistogramItem.get(0).isEnabled();},5000);
		}
		else
			reporter.reportLogFailWithScreenshot("Review Images are not displayed in Histogram section of review");
	}

}
