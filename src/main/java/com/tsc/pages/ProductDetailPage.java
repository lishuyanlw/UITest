package com.tsc.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.tsc.pages.ProductResultsPage.ProductItem;
import com.tsc.pages.base.BasePage;

public class ProductDetailPage extends BasePage {
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		
	}
		
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection') and not(contains(@class,'pdImageSection__zoom')) and not(@style='display: none;')]")
	public WebElement cntLeftContainer;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//*[@id='lblProductName']/parent::div")
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
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='divVideoIcon']")
	public WebElement lnkVideoInZoomImage;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'pdImageSection__zoom')]//p[contains(@class,'pdImageSection__zoom--message')]")
	public WebElement lblZoomImageMessage;
	
	//Product details
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@id='lblProductName']")
	public WebElement lblProductName;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='divBrandName']//a")
	public WebElement lnkBrandName;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'product-name-sub')]//span[@id='lblItemNo']")
	public WebElement lblProductNumber;
	
	//Review part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']//div[@class='p-w-r'][last()]//section")
	public WebElement productReviewSection;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']//div[@class='p-w-r'][last()]//section//div[contains(@class,'pr-star-v4')]")
	public List<WebElement> lstProductReviewStar;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']//div[@class='p-w-r'][last()]//section//span[contains(@class,'pr-accessible-text')]")
	public List<WebElement> lstProductReviewAccessibleText;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[contains(@class,'product-name-sub')]//div[@id='panReviewSnippet']//div[@class='p-w-r'][last()]//section")
	public WebElement lblProductReview;
	
	//Price part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@class='price-div']//span[@id='lblPriceLabel']")
	public WebElement lblProductPriceLabel;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@class='price-div']//span[@id='lblCurrentPrice']")
	public WebElement lblProductNowPrice;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//*[@class='price-div']//span[@id='lblShowWasPrice']")
	public WebElement lblProductWasPrice;

	//EasyPay part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='divEasyPayment']")
	public WebElement lblProductEasyPay;
	
	//Shipping part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='savings-shipping']//*[@id='divSavings']")
	public WebElement lblProductSavings;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='savings-shipping']//*[@class='shipping']")
	public WebElement lblProductShipping;
	
	//Style part
	@FindBy(xpath = "//form[@id='pdpForm']")
	public WebElement cntProductSizeJudgeIndicator;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='style-container']")
	public WebElement cntProductStyleSection;
	
	//For radio style	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='style-container']//div[@id='divStyleSwatch']//span[@class='style-lbl']")
	public WebElement lblRadioProductStyleStatic;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='style-container']//div[@id='divStyleSwatch']//span[@id='lblStyle']")
	public WebElement lblRadioProductStyleTitle;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='style-container']//div[@id='divStyleSwatch']//input")
	public List<WebElement> lstStyleRadioList;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='style-container']//div[@id='divStyleSwatch']//label[not(div[contains(@class,'disable')])]")
	public List<WebElement> lstRadioStyleLabelList;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='style-container']//div[@id='divStyleSwatch']//label[not(div[contains(@class,'disable')])]//span")
	public List<WebElement> lstRadioStyleLabelSpanList;
		
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='style-container']//div[@id='divStyleSwatch']//label[contains(@class,'style-selected')]/preceding-sibling::input[1]")
	public WebElement btnRadioProductStyleSelected;
	
	//For dropdown menu style		
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='style-container']//div[@id='divStyleSwatchDdl']//span[@class='style-lbl']")
	public WebElement lblDropDownProductStyleStatic;
		
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='style-container']//div[@id='divStyleSwatchDdl']//select")
	public WebElement selectProductStyle;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='style-container']//div[@id='divStyleSwatchDdl']//select//option")
	public List<WebElement> lstDropdownProductStyle;
	
	//TrueFit part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='tf-wrapper']")
	public WebElement cntProductTrueFitSection;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='tf-wrapper']//div[@class='tfc-cfg-logo']")
	public WebElement imgProductTrueFitLogo;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='tf-wrapper']//a[@class='tfc-popup-click-open']")
	public WebElement lnkProductTrueFitLink;
	
	//TrueFit iframe part
	@FindBy(xpath = "//iframe[contains(@src,'truefit')]")
	public WebElement iframeProductTrueFit;
	
	@FindBy(xpath = "//div[@aria-label='True Fit']")
	public WebElement iframeProductTrueFitLoadingIndicator;

	@FindBy(xpath = "//div[@tfc-popup]")
	public WebElement cntProductTrueFitIframe;
	
	@FindBy(xpath = "//button[contains(@class,'tfc-popup-click-close')][img]")
	public WebElement btnProductTrueFitIframeClose;
	
	@FindBy(xpath = "//div[@class='tfc-popup-contents']//div[@ui-view='header']//div[@class='tfc-logo-wrapper']//img")
	public WebElement imgProductTrueFitIframeHeaderLogo;
	
	@FindBy(xpath = "//div[@class='tfc-popup-contents']//div[@ui-view='page']//div[contains(@class,'tfc-cfg-splash-page-image')]")
	public WebElement imgProductTrueFitIframePage;
	
	@FindBy(xpath = "//div[@class='tfc-popup-contents']//div[@ui-view='page']//div[contains(@class,'tfc-page')]//div[@class='tfc-cfg-title-container']//*[contains(@class,'tfc-page-title')]")
	public WebElement lblProductTrueFitIframePageTitle;
	
	@FindBy(xpath = "//div[@class='tfc-popup-contents']//div[@ui-view='page']//div[contains(@class,'tfc-page')]//div[@class='tfc-cfg-title-container']//*[contains(@class,'tfc-cfg-subtitle-container')]")
	public WebElement lblProductTrueFitIframePageSubTitle;
	
	@FindBy(xpath = "//div[@class='tfc-popup-contents']//tfc-footer-content//tfc-button-bar//button")
	public WebElement btnProductTrueFitIframeFooterGetStarted;
	
	@FindBy(xpath = "//div[@class='tfc-popup-contents']//div[contains(@class,'tfc-cfg-gdpr-message')]")
	public WebElement lblProductTrueFitIframeConfirmMessage;
	
	@FindBy(xpath = "//div[@class='tfc-popup-contents']//div[contains(@class,'tfc-cfg-gdpr-message')]//a[contains(@class,'tfc-cfg-page-link')]")
	public WebElement lnkProductTrueFitIframePrivacyPolicy;
	
	@FindBy(xpath = "//div[@class='tfc-popup-contents']//a[contains(@class,'sign-in')]")
	public WebElement lnkProductTrueFitIframeSignIn;
	
	@FindBy(xpath = "//div[@class='tfc-popup-contents']//button[contains(@class,'tfc-cfg-info-button')]")
	public WebElement btnProductTrueFitIframeInfo;
	
	//Size part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='divAvailableSizes']//span[contains(@class,'size-lbl')]")
	public WebElement lblSizeStatic;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='divAvailableSizes']//select")
	public WebElement selectSizeOption;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='divAvailableSizes']//select//option")
	public List<WebElement> lstSizeOption;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='divAvailableSizes']//div[@id='divSizeChart']")
	public WebElement lnkSizingChart;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='soldoutContainer']")
	public WebElement lblSoldOut;
	
	//Quantity part
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='qty-container']//span[contains(@class,'qty-lbl')]")
	public WebElement lblQuantityStatic;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='qty-container']//select")
	public WebElement selectQuantityOption;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='qty-container']//select//option[last()]")
	public WebElement lblQuantityLastOption;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@class='qty-container']//div[@class='qty-left']")
	public WebElement lblQuantityLeft;
	
	//Add to Bag button section
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='divAddToCart']//button[@id='btnAddToCart']")
	public WebElement btnAddToBag;
	
	@FindBy(xpath = "//div[@class='ProductDetailWithFindmine']//div[@id='pdpMainDiv']//div[@id='divAddToCart']//div[@id='divAdvanceOrder']")
	public WebElement lblAdvanceOrderMsg;
	
	//Social links part
	@FindBy(xpath = "//div[@id='pdpMainDiv']//div[@id='favShare']/div[contains(@class,'mob-middle-social')]/div")
	public WebElement lnkFavShareMobile;
	
	@FindBy(xpath = "//div[@id='pdpMainDiv']//div[@id='favShare']/div[not(contains(@class,'mob-middle-social'))]/div")
	public WebElement lnkFavShareEmail;
	
	@FindBy(xpath = "//div[@id='pdpMainDiv']//a[contains(@href,'facebook')]")
	public WebElement lnkFaceBook;
	
	@FindBy(xpath = "//div[@id='pdpMainDiv']//a[contains(@href,'twitter')]")
	public WebElement lnkTwitter;
	
	@FindBy(xpath = "//div[@id='pdpMainDiv']//a[contains(@href,'pinterest')]")
	public WebElement lnkPInterest;
	
	@FindBy(xpath = "//iframe[contains(@style,'display: block')]")
	public WebElement iframePin;

	//Tell your friends window
	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__header']//button[@class='modal__button-back']")
	public WebElement btnTellYourFriendsWindowBack;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__header']//h3")
	public WebElement lblTellYourFriendsWindowTitle;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__header']//button[@class='modal__button-close']")
	public WebElement btnTellYourFriendsWindowClose;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//span[@class='form__required']")
	public WebElement lblTellYourFriendsWindowRequiredInfo;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__left']//h3")
	public WebElement lblTellYourFriendsWindowFrom;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__left']//label[@id='Name1lbl']")
	public WebElement lblTellYourFriendsWindowFromName;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__left']//input[@id='Name1']")
	public WebElement inputTellYourFriendsWindowFromName;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__left']//label[@id='Email1lbl']")
	public WebElement lblTellYourFriendsWindowFromEmail;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__left']//input[@id='Email1']")
	public WebElement inputTellYourFriendsWindowFromEmail;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__right']//h3")
	public WebElement lblTellYourFriendsWindowSendTo;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__right']//label[@id='NameTo1lbl']")
	public WebElement lblTellYourFriendsWindowSendToName;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__right']//input[@id='NameTo1']")
	public WebElement inputTellYourFriendsWindowSendToName;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__right']//label[@id='EmailTo1lbl']")
	public WebElement lblTellYourFriendsWindowSendToEmail;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__right']//input[@id='EmailTo1']")
	public WebElement inputTellYourFriendsWindowSendToEmail;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__right']//button[@class='modal__show-more--button']")
	public WebElement btnTellYourFriendsWindowAddRecipient;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__center']//b/parent::div")
	public WebElement lblTellYourFriendsWindowAddMessage;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//form//div[@class='form__center']//textarea")
	public WebElement inputTellYourFriendsWindowAddMessage;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__footer']//button[contains(@class,'modal__button--save')]")
	public WebElement btnTellYourFriendsWindowSend;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__footer']//button[contains(@class,'modal__button--preview')]")
	public WebElement btnTellYourFriendsWindowPreview;

	// Tell your friends Preview window
	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__header']//button[@class='modal__button-back']")
	public WebElement btnTellYourFriendsPreviewWindowBack;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__header']//h3")
	public WebElement lblTellYourFriendsPreviewWindowTitle;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__header']//button[@class='modal__button-close']")
	public WebElement btnTellYourFriendsPreviewWindowClose;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//div[@class='preview__row--wrap'][1]//div[@class='preview__row--left']//h3")
	public WebElement lblTellYourFriendsPreviewWindowFrom;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//div[@class='preview__row--wrap'][1]//div[@class='preview__row--right']")
	public WebElement lblTellYourFriendsPreviewWindowFromNameAndEmail;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//div[@class='preview__row--wrap'][2]//div[@class='preview__row--left']//h3")
	public WebElement lblTellYourFriendsPreviewWindowSendTo;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//div[@class='preview__row--wrap'][2]//div[@class='preview__row--right']")
	public WebElement lblTellYourFriendsPreviewWindowSendToNameAndEmail;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//div[@class='preview__row--wrap'][3]//div[@class='preview__row--left']//h3")
	public WebElement lblTellYourFriendsPreviewWindowYourMessage;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//div[@class='preview__row--wrap'][3]//div[@class='preview__row--right']")
	public WebElement lblTellYourFriendsPreviewWindowYourMessageContent;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__footer']//button[contains(@class,'modal__button--save')]")
	public WebElement btnTellYourFriendsPreviewWindowSend;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__footer']//button[contains(@class,'modal__button--preview')]")
	public WebElement btnTellYourFriendsPreviewWindowBackToEditEmail;

	//Sent window for Tell your friends
	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__header']//button[@class='modal__button-back']")
	public WebElement btnTellYourFriendsSentWindowBack;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__header']//h3")
	public WebElement lblTellYourFriendsSentWindowTitle;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__header']//button[@class='modal__button-close']")
	public WebElement btnTellYourFriendsSentWindowClose;

	@FindBy(xpath = "//div[contains(@class,'ReactModalPortal')]//div[@class='modal__body']//*[@class='modal__thanks--h3']")
	public WebElement lblTellYourFriendsSentWindowSentMessage;

	//product teaser part
	@FindBy(xpath = "//div[@id='pdpMainDiv']//div[@id='divProductTeaser']")
	public WebElement lblProductTeaser;
	
	@FindBy(xpath = "//div[@id='pdpMainDiv']//a[@class='pdpSeeMoreLnk']")
	public WebElement lnkProductTeaserSeeMore;
	
	//Sticky swiper container part
	@FindBy(xpath = "//div[@class='sticky-swiper-container']")
	public WebElement cntStickyContainner;

	@FindBy(xpath = "//div[@class='sticky-swiper-container']//div[@class='stickyIcon']")
	public WebElement imgStickyIcon;
	
	@FindBy(xpath = "//div[@class='stickyHeader']//div[@id='divProductDetailTab']//div[contains(@class,'swiper-slide')]")
	public List<WebElement> lstStickyTabProductTabList;
	
	@FindBy(xpath = "//div[@class='sticky-swiper-container']//a[@data-text='PRODUCT OVERVIEW']")
	public WebElement btnStickyTabProductOverview;
	
	@FindBy(xpath = "//div[@class='sticky-swiper-container']//a[@data-text='SIZE CHART']")
	public WebElement btnStickyTabSizeChart;
	
	@FindBy(xpath = "//div[@class='sticky-swiper-container']//a[@data-href='#pr-reviewdisplay']")
	public WebElement btnStickyTabProductReview;
	
	//Product Overview Tab part
	@FindBy(xpath = "//div[contains(@class,'tabs')]//div[@id='infoTabContent']//div[@id='tab0']")
	public WebElement lblProductOverviewTabContent;
	
	//Product Size Chart Tab part
	@FindBy(xpath = "//div[contains(@class,'tabs')]//div[@id='infoTabContent']//img[contains(@src,'SIZE') and contains(@src,'CHART')]/ancestor::div[contains(@id,'tab')]")
	public WebElement cntProductSizeChartTabContent;

	@FindBy(xpath = "//div[contains(@class,'tabs')]//div[@id='infoTabContent']//img[contains(@src,'SIZE') and contains(@src,'CHART')]/ancestor::div[contains(@id,'tab')]//*[@class='tabHeader']")
	public WebElement lblProductSizeChartTabHeader;
	
	@FindBy(xpath = "//div[contains(@class,'tabs')]//div[@id='infoTabContent']//img[contains(@src,'SIZE') and contains(@src,'CHART')]")
	public List<WebElement> lstProductSizeChartTabContentList;
	
	//Product Review Tab part
	@FindBy(xpath = "//div[@id='productReviewSection']")
	public WebElement cntReviewTabContent;

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
	
	@FindBy(xpath = "//div[@id='productReviewSection']//a[contains(@href,'writereview')]")
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
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-file-input-btn-group')]//input[@id='pr-media_image']")
	public WebElement inputWriteReviewUploadImage;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-file-input-btn-group')]//button")
	public WebElement btnWriteReviewUploadImage;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-media_videourl-form-group')]//label")
	public WebElement lblWriteReviewAddVideo;
	
	@FindBy(xpath = "//div[contains(@class,'WriteReview')]//div[@role='form']//div[@id='pr-war-form']//div[contains(@class,'pr-file-input-btn-group')]//input[@id='pr-media_videourl']")
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
	
	@FindBy(xpath = "//div[@class='pr-form-control-error-wrapper']//*[@class='pr-form-control-error-icon']")
	public List<WebElement> lstWriteReviewErrorIcon;

	@FindBy(xpath = "//div[@role='alert'][div]")
	public WebElement cntWriteReviewAlert;

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
	@FindBy(xpath = "//div[@id='tagCartContainer']")
	public WebElement cntAddToBagOoverlay;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]")
	public WebElement cntAddToBagPopupWindow;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//button[@class='add-to-bag__button-close']")
	public WebElement btnAddToBagPopupWindowClose;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag-title']")
	public WebElement lblAddToBagPopupWindowTitle;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']")
	public WebElement cntAddToBagPopupWindowDetailsSection;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']")
	public WebElement cntAddToBagPopupWindowDetailsLeftSection;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']")
	public WebElement cntAddToBagPopupWindowDetailsLeftSectionImage;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']//div[@class='badgeWrap']//img")
	public WebElement imgAddToBagPopupWindowDetailsProductBadge;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']//a")
	public WebElement lnkAddToBagPopupWindowDetailsProductImage;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-left']//div[@class='add-to-bag__img']//a//img")
	public WebElement imgAddToBagPopupWindowDetailsProductImage;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']")
	public WebElement cntAddToBagPopupWindowDetailsRightSection;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']")
	public WebElement lnkAddToBagPopupWindowDetailsProductInfo;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']//span[@class='add-to-bag__product-name']")
	public WebElement lblAddToBagPopupWindowDetailsProductName;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']//span[@class='add-to-bag__product-style']")
	public WebElement lblAddToBagPopupWindowDetailsProductStyle;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//a[@class='add-to-bag__item-link']//span[@class='add-to-bag__product-size']")
	public WebElement lblAddToBagPopupWindowDetailsProductSize;
	
	public By byAddToBagPopupWindowDetailProductName = By.xpath(".//span[@class='add-to-bag__product-name']");
	
	public By byAddToBagPopupWindowDetailProductStyle = By.xpath(".//span[@class='add-to-bag__product-style']");
	
	public By byAddToBagPopupWindowDetailProductSize = By.xpath(".//span[@class='add-to-bag__product-size']");
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__details']//div[@class='add-to-bag__inside-right']//div[@class='add-to-bag-style-size-div']//a[@class='add-to-bag__item-link']")
	public WebElement lblAddToBagPopupWindowDetailsProductNumber;
		
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__button-wrap']")
	public WebElement cntAddToBagPopupWindowButtonSection;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__button-wrap']//div[contains(@class,'add-to-bag__subtotal')]")
	public WebElement lblAddToBagPopupWindowButtonSectionSubtotal;
	
	@FindBy(xpath = "//div[contains(@class,'cart-section')]//div[@class='add-to-bag__content-wrap']//div[@class='add-to-bag__button-wrap']//button[not(contains(@class,'btn-go-to-bag'))]")
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

	@FindBy(xpath = "//div[@id='findMine']//div[contains(@class,'findmine__slider')]//div[contains(@class,'findmine__item') and not(contains(@class,'findmine__itemid'))]")
	public List<WebElement> lstGetTheLookItem;

	public By byGetTheLookProductLink=By.xpath(".//a");

	public By byGetTheLookProductImage=By.xpath(".//img");

	public By byGetTheLookProductName=By.xpath(".//div[@class='findine__name']");

	public By byGetTheLookProductNumber=By.xpath(".//div[@class='findmine__itemid']");

	public By byGetTheLookProductPriceContainer=By.xpath(".//div[@class='prec-price']");

	public By byGetTheLookProductNowPrice=By.xpath(".//div[@class='findmine__now-price']");

	public By byGetTheLookProductWasPrice=By.xpath(".//del[@class='findmine__was-price']");

	public By byGetTheLookProductEasyPay=By.xpath(".//div[@class='findmine__easypay']");


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
		return lsStyle.contains("background:#000")||lsStyle.contains("background: rgb(0, 0, 0)");		
	}
	
	/**
	 * Method to get AutoPlayVideo ToolTip popup Message
	 * @return String: tooltip message	  
	 * @author Wei.Li
	 */
	public String getAutoPlayVideoToolTipPopupMsg() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkAutoPlayVideoToolTip);
		this.getReusableActionsInstance().scrollToElement(this.lnkAutoPlayVideoToolTip);
		this.getReusableActionsInstance().staticWait(300);
		
		String lsText=this.lblAutoPlayVideoToolTipPopupMsg.getText().trim();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAutoPlayVideo);
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
	
	public boolean judgeQuantityDropdownAvailable() {
		return !this.getElementText(this.cntProductSizeJudgeIndicator.findElement(By.xpath(".//div[@class='qty-container']"))).isEmpty();		
	}
	
	public boolean judgeAddToBagButtonAvailable() {
		return this.checkChildElementExistingByAttribute(this.cntProductSizeJudgeIndicator, "id", "divAddToCart");		
	}
	
	public boolean judgeTeaserInfoDisplaying() {
		return this.hasElementAttribute(this.lblProductTeaser,"style");
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
					element=item.findElement(By.xpath(".//img"));
					verifySingleItemLinkageBetweenThumbnailAndZoomImage(element);
				}
			}
		}
		else {
			for(WebElement item:this.lstThumbnailImageList) {			
				verifySingleItemLinkageBetweenThumbnailAndZoomImage(item);
			}
		}
	}

	private void verifySingleItemLinkageBetweenThumbnailAndZoomImage(WebElement item) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		item.click();
		this.getReusableActionsInstance().staticWait(500);

		String lsThumbnail=this.getImageNameFromThumbnailOrZoomImagePath(lnkCurrentZoomImage.getAttribute("href"));
		String lsZoomImage=this.getImageNameFromThumbnailOrZoomImagePath(imgCurrentThumbnail.getAttribute("src"));

		reporter.softAssert(lsThumbnail.equalsIgnoreCase(lsZoomImage), "The Thumbnail image is the same as the Zoom image with changing Swatch style", "The Thumbnail image is not the same as the Zoom image with changing Swatch style");
		//reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblImageDisclaim),"The Image disclaim message section is displaying correctly","The Image disclaim message section is not displaying correctly");
	}
	
	/**
	 * Method to verify the Prev button clicking of Thumbnail
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyThumbnailPrevButton() {		
		String lsFirstImageSrcBefore=this.lstThumbnailImageList.get(0).findElement(By.xpath(".//img")).getAttribute("src");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnThumbnailPrev);
		this.getReusableActionsInstance().clickIfAvailable(this.btnThumbnailPrev);
		//this.btnThumbnailPrev.click();
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
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnThumbnailPrev);
		this.getReusableActionsInstance().clickIfAvailable(this.btnThumbnailPrev);
		//this.btnThumbnailPrev.click();
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
		String lsSwatch,lsThumbnail="",lsZoomImage="",lsBeforeStyleName;
		boolean bDisable=false;		
		int loopSize;		
		if(this.judgeStyleDisplayModeIsDropdownMenu()) {
			Select selectStyle= new Select(this.selectProductStyle);
			loopSize=this.lstDropdownProductStyle.size();	
			
			for(int i=0;i<loopSize;i++) {
				if(this.hasElementAttribute(this.lstDropdownProductStyle.get(i),"selected")) {
					continue;
				}	
				
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectProductStyle);
				lsBeforeStyleName=selectStyle.getFirstSelectedOption().getText().trim();
				
				selectStyle.selectByIndex(i);
				this.getReusableActionsInstance().staticWait(3000);				
				lsSwatch=this.getCurrentSwatchStyle();	
				
				if(this.lstDropdownProductStyle.get(i).getAttribute("class").contains("disable")) {
					bDisable=true;
				}
				else {
					bDisable=false;
				}
				
				lsZoomImage=this.getImageNameFromThumbnailOrZoomImagePath(lnkCurrentZoomImage.getAttribute("href"));
				//next line for Tablet image loading problem, there is no src
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
				
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblRadioProductStyleStatic);
				lsBeforeStyleName=this.lblRadioProductStyleTitle.getText().trim();	
				
				radioItem.click();	
				this.getReusableActionsInstance().staticWait(3000);
								
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
			
			for(int i=0;i<loopSize;i++) {
				if(this.hasElementAttribute(this.lstDropdownProductStyle.get(i),"selected")) {
					continue;
				}				
				
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectProductStyle);
				lsBeforeStyleName=selectStyle.getFirstSelectedOption().getText().trim();
				
				selectStyle.selectByIndex(i);
				this.getReusableActionsInstance().staticWait(3000);
								
				lsAfterStyleName=selectStyle.getFirstSelectedOption().getText();			
				lsSwatch=this.getCurrentSwatchStyle();				
				reporter.softAssert(!lsBeforeStyleName.equalsIgnoreCase(lsAfterStyleName), "Clicking the swatch dropdown option of '"+lsSwatch+"' is changing product style name", "Clicking the swatch dropdown option of '"+lsSwatch+"' is not changing product style name");
			}
		}
		else {			
			loopSize=this.lstRadioStyleLabelSpanList.size();
			WebElement radioItem,labelItem;
			String lsLabelTitle;	
						
			for(int i=0;i<loopSize;i++) {
				if(this.hasElementAttribute(this.lstStyleRadioList.get(i),"checked")) {
					continue;
				}
				radioItem=this.lstRadioStyleLabelSpanList.get(i);
				labelItem=this.lstRadioStyleLabelList.get(i);				
								
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblRadioProductStyleStatic);
				lsBeforeStyleName=this.lblRadioProductStyleTitle.getText().trim();	
				
				radioItem.click();	
				this.getReusableActionsInstance().staticWait(3000);
								
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
		this.getReusableActionsInstance().clickIfAvailable(this.productReviewSection);
		//this.productReviewSection.click();
		return this.waitForCondition(Driver->{return this.btnStickyTabProductReview.getAttribute("class").contains("selected");},30000);		
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
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblReviewTabReviewCount);
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
	 * Method to open TrueFit iFrame
	 * @return void	  
	 * @author Wei.Li
	 */
	public void openTrueFitIFrame() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkProductTrueFitLink);
		this.getReusableActionsInstance().clickIfAvailable(this.lnkProductTrueFitLink);
		//this.lnkProductTrueFitLink.click();
		this.waitForCondition(Driver->{return this.iframeProductTrueFitLoadingIndicator.getAttribute("style").contains("display: block");}, 30000);
		this.getDriver().switchTo().frame(this.iframeProductTrueFit);
	}
	
	/**
	 * Method to close TrueFit iFrame
	 * @return void	  
	 * @author Wei.Li
	 */
	public void closeTrueFitIFrame() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnProductTrueFitIframeClose);
		this.getReusableActionsInstance().clickIfAvailable(this.btnProductTrueFitIframeClose);
		//this.btnProductTrueFitIframeClose.click();
		this.getDriver().switchTo().defaultContent();
		this.waitForCondition(Driver->{return this.iframeProductTrueFitLoadingIndicator.getAttribute("style").contains("display: none");}, 30000);
	}

	/**
	 * Method to check if Sizing chart is existing
	 * @return boolean	  
	 * @author Wei.Li
	 */
	public boolean checkProductSizingChartExisting() {		
		for(WebElement item:this.lstStickyTabProductTabList) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);			
			if(item.getText().trim().equalsIgnoreCase("SIZE CHART")) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to check if dropdown action is working
	 * @return boolean	  
	 * @author Wei.Li
	 */
	public boolean checkProductSizingDrodownOptionChangeAction() {	
		String lsSelected,lsOption;
		WebElement item;
		Select sizeOption=new Select(this.selectSizeOption);		
		int loopSize=this.lstSizeOption.size();
		for(int i=0;i<loopSize;i++) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectSizeOption);
			this.getReusableActionsInstance().clickIfAvailable(this.selectSizeOption);
			//this.selectSizeOption.click();
			this.getReusableActionsInstance().staticWait(100);
			item=this.lstSizeOption.get(i);
			lsOption=item.getText().trim();
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
			item.click();
			this.getReusableActionsInstance().staticWait(100);
			lsSelected=sizeOption.getFirstSelectedOption().getText().trim();
			if(!lsSelected.equalsIgnoreCase(lsOption)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method to verify product size dropdown
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyProductSizeDropdown() {
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
	
	/**
	 * Method to verify product size TrueFit
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyProductSizeTrueFit() {
		if(judgeStyleTrueFitExisting()) {				
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgProductTrueFitLogo),"The product TrueFit icon is displaying correctly","The product TrueFit icon is not displaying correctly");
			reporter.softAssert(!this.getElementHref(this.lnkProductTrueFitLink).isEmpty(),"The product TrueFit link is not empty","The product TrueFit link is empty");
			
			openTrueFitIFrame();
			trueFitDetails();
			closeTrueFitIFrame();
		}		
	}

	public void trueFitDetails(){
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntProductTrueFitIframe),"The product TrueFit popup window is displaying","The product TrueFit popup window is not displaying");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgProductTrueFitIframeHeaderLogo),"The header icon in product TrueFit popup window is displaying","The header icon in product TrueFit popup window is not displaying");
		reporter.softAssert(!this.getElementImageSrc(this.imgProductTrueFitIframeHeaderLogo).isEmpty(),"The header icon src in product TrueFit popup window is not empty","The header icon src in product TrueFit popup window is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnProductTrueFitIframeFooterGetStarted),"The GetStarted button in product TrueFit popup window is displaying","The GetStarted button in product TrueFit popup window is not displaying");
		reporter.softAssert(this.btnProductTrueFitIframeFooterGetStarted.isEnabled(),"The GetStarted button in product TrueFit popup window is enabled","The GetStarted button in product TrueFit popup window is not enabled");
	}
	
	/**
	 * Method to verify product Sizing chart
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyProductQuantitySizingChart() {
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkSizingChart),"The product Sizing Chart is existing","The product Sizing Chart is not existing");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkSizingChart);
		this.getReusableActionsInstance().clickIfAvailable(this.lnkSizingChart);
		//this.lnkSizingChart.click();
		this.waitForCondition(Driver->{return this.btnStickyTabSizeChart.getAttribute("class").contains("selected");},5000);
		reporter.softAssert(this.getStickyTabSelectedStatus(this.btnStickyTabSizeChart),"The SIZE CHART tab has been selected correctly","The SIZE CHART tab has not been selected correctly");				
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
			for(int i=0;i<loopSize;i++) {
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectProductStyle);
				selectStyle.selectByIndex(i);
				this.getReusableActionsInstance().staticWait(1000);
				lsStyle=this.selectProductStyle.getText();
				
				if(this.judgeStyleSizeAvailable()) {					
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
			WebElement radioItem;		
			for(int i=0;i<loopSize;i++) {								
				radioItem=this.lstRadioStyleLabelSpanList.get(i);				
				
				this.getReusableActionsInstance().javascriptScrollByVisibleElement(radioItem);
				radioItem.click();
				this.getReusableActionsInstance().staticWait(1000);
				lsStyle=this.lstRadioStyleLabelList.get(i).getAttribute("title");
				
				if(this.judgeStyleSizeAvailable()) {					
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
		if(!this.getElementText(this.lblQuantityLeft).isEmpty()) {
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
		Select sizeOption=new Select(this.selectSizeOption);
		int subLoopSize=this.lstSizeOption.size();
		for(int j=0;j<subLoopSize;j++) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.selectSizeOption);
			sizeOption.selectByIndex(j);
			this.getReusableActionsInstance().staticWait(1000);
			lsSize=this.selectSizeOption.getText();

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
		return this.checkChildElementExistingByAttribute(this.cntRightContainer, "id", "divBrandName");
	}

	/**
	 * Method to check if Add to Bag popup window is displaying
	 * @return boolean	  
	 * @author Wei.Li
	 */
	public boolean checkAddToBagPopupDisplaying() {
		return this.checkChildElementExistingByAttribute(this.cntAddToBagOoverlay, "class", "add-to-bag__overlay");
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
	public boolean checkProductSyleInAddToBagPopupDisplaying() {
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
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBag);
		this.getReusableActionsInstance().clickIfAvailable(this.btnAddToBag);
		//this.btnAddToBag.click();
		return this.waitForCondition(Drive->{return checkAddToBagPopupDisplaying();}, 30000);
	}
	
	/**
	 * Method to close AddToBag PopupWindow
	 * @return boolean	  
	 * @author Wei.Li
	 */
	public boolean closeAddToBagPopupWindow() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowClose);
		this.getReusableActionsInstance().clickIfAvailable(this.btnAddToBagPopupWindowClose);
		//this.btnAddToBagPopupWindowClose.click();
		return this.waitForCondition(Drive->{return !checkAddToBagPopupDisplaying();}, 30000);
	}
	
	/**
	 * Method to verify the product details in Add to Bag popup window	
	 * @param String lbl_AddToBagPopupWindowTitle: the expected title
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyProductDetailsInAddToBagPopupWindow(String lbl_AddToBagPopupWindowTitle, ProductItem productItem){
		openAddToBagPopupWindow();
		
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowTitle);
		reporter.softAssert(this.lblAddToBagPopupWindowTitle.getText().matches(lbl_AddToBagPopupWindowTitle),"The title of Add to Bag popup window is matching to '"+lbl_AddToBagPopupWindowTitle+"' pattern","The title of Add to Bag popup window is not matching to '"+lbl_AddToBagPopupWindowTitle+"' pattern");
		
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
		//reporter.softAssert(this.lblAddToBagPopupWindowDetailsProductName.getText().trim().equalsIgnoreCase(productItem.productName),"The product name in Add to Bag popup window is equal to the original product name from product search result page","The product name in Add to Bag popup window is not equal to the original product name from product search result page");

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
		//reporter.softAssert(this.lblAddToBagPopupWindowDetailsProductNumber.getText().trim().equalsIgnoreCase(productItem.productNumber),"The product number in Add to Bag popup window is equal to the original product number from product search result page","The product number in Add to Bag popup window is not equal to the original product number from product search result page");

		subTotal();
	
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowButtonSectionCheckOut);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnAddToBagPopupWindowButtonSectionCheckOut),"The CheckOut button in Add to Bag popup window is visible","The CheckOut button in Add to Bag popup window is not visible");
		reporter.softAssert(!this.btnAddToBagPopupWindowButtonSectionCheckOut.getText().isEmpty(),"The CheckOut button in Add to Bag popup window is not empty","The CheckOut button in Add to Bag popup window is empty");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAddToBagPopupWindowButtonSectionViewShoppingBag);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnAddToBagPopupWindowButtonSectionViewShoppingBag),"The ViewShoppingBag button in Add to Bag popup window is visible","The ViewShoppingBag button in Add to Bag popup window is not visible");
		reporter.softAssert(!this.btnAddToBagPopupWindowButtonSectionViewShoppingBag.getText().isEmpty(),"The ViewShoppingBag button in Add to Bag popup window is not empty","The ViewShoppingBag button in Add to Bag popup window is empty");
		
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowFooterInfo);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowFooterInfo),"The Footer info in Add to Bag popup window is visible","The Footer info in Add to Bag popup window is not visible");
		reporter.softAssert(!this.lblAddToBagPopupWindowFooterInfo.getText().isEmpty(),"The Footer info in Add to Bag popup window is not empty","The Footer info in Add to Bag popup window is empty");
	
		closeAddToBagPopupWindow();
	}

	//this method checks subtotal section
	public void subTotal(){
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lblAddToBagPopupWindowButtonSectionSubtotal);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAddToBagPopupWindowButtonSectionSubtotal),"The product Subtotal in Add to Bag popup window is visible","The product Subtotal in Add to Bag popup window is not visible");
		reporter.softAssert(!this.lblAddToBagPopupWindowButtonSectionSubtotal.getText().isEmpty(),"The product Subtotal in Add to Bag popup window is not empty","The product Subtotal in Add to Bag popup window is empty");
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
	public void verifyShoppingCartNumber() {		
		reporter.softAssert(getShoppingCartNumber()==1,"The Shopping cart number is equal to 1","The Shopping cart number is not equal to 1");
	}	
	
	/**
	 * Method to verify the url while clicking BreadCrumb Navigation.
	 * @param String lsBackUrl: the expected Url
	 * @return void	  
	 * @author Wei.Li
	 */
	public void verifyBreadCrumbNavigationBack() {		
		WebElement item=this.lstBreadCrumbNav.get(this.lstBreadCrumbNav.size()-1);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
		this.getReusableActionsInstance().scrollToElement(item);
		item.click();

		(new ProductResultsPage(this.getDriver())).waitForPageLoading();
		
		reporter.softAssert(this.URL().toLowerCase().contains("productresults"),"The current Url of "+this.URL()+" is back to product search page","The current Url of "+this.URL()+" is not back to product search page");
	}
	
	public void verifyVideo(String lsVideoDisclaimInfo) {
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgProductBadge),"The product badge is displaying correctly","The product badge is not displaying correctly");
		reporter.softAssert(!this.imgProductBadge.getAttribute("src").isEmpty(),"The product badge image source is not empty","The product badge image source is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
		reporter.softAssert(!this.lnkVideo.getAttribute("src").isEmpty(),"The product video source is not empty","The product video source is empty");
		
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblVideoDisclaim),"The product video disclaim text is displaying correctly","The product video disclaim text is not displaying correctly");
		reporter.softAssert(this.getElementText(this.lblVideoDisclaim).equalsIgnoreCase(lsVideoDisclaimInfo),"The product video disclaim text is equal to the text of '"+lsVideoDisclaimInfo+"'","The product video disclaim text is not equal to the text of '"+lsVideoDisclaimInfo+"'");
		
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.videoBoxControl),"The video control section is displaying correctly","The video control section is not displaying correctly");
		reporter.softAssert(this.checkIfAutoPlayVideoStatusIsON(),"The product video AutoPlaying is on","The product video AutoPlaying is off");
		reporter.softAssert(this.checkIfVideoisPlaying(),"The product video is playing","The product video is not playing");
		
		reporter.softAssert(!getAutoPlayVideoToolTipPopupMsg().isEmpty(),"The AutoPlayVideoToolTip is not empty","The AutoPlayVideoToolTip is empty");
		
	}
	
	public void verifyVideoOff() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkVideoInZoomImage);
		this.getReusableActionsInstance().clickIfAvailable(this.lnkVideoInZoomImage);
		//this.lnkVideoInZoomImage.click();
		this.getReusableActionsInstance().waitForElementVisibility(this.btnAutoPlayVideo,  60);
		if(this.checkIfAutoPlayVideoStatusIsON()) {
			//Set AutoPlayVideo off
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAutoPlayVideo);
			this.getReusableActionsInstance().clickIfAvailable(this.btnAutoPlayVideo);
			//this.btnAutoPlayVideo.click();
			this.getReusableActionsInstance().staticWait(1000);
			this.getDriver().navigate().refresh();
			this.waitForPageToLoad();
			this.getReusableActionsInstance().waitForElementVisibility(this.lblZoomImageMessage,  60);
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkCurrentZoomImage),"The image is displaying after video off and page refreshing instead of video displaying","The image is not displaying after video off and page refreshing instead of video displaying");
		}
		else {
			//Set AutoPlayVideo on
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAutoPlayVideo);
			this.getReusableActionsInstance().clickIfAvailable(this.btnAutoPlayVideo);
			this.getReusableActionsInstance().staticWait(1000);

			//Set AutoPlayVideo off
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnAutoPlayVideo);
			this.getReusableActionsInstance().clickIfAvailable(this.btnAutoPlayVideo);
			//this.btnAutoPlayVideo.click();
			this.getReusableActionsInstance().staticWait(1000);
			this.getDriver().navigate().refresh();
			this.waitForPageToLoad();
			this.getReusableActionsInstance().waitForElementVisibility(this.lblZoomImageMessage,  60);
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkCurrentZoomImage),"The image is displaying after video off and page refreshing instead of video displaying","The image is not displaying after video off and page refreshing instead of video displaying");
		}
	}
	
	public void verifyThumbnail() {
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntThumbnailContainer),"The Thumbnail section is displaying correctly","The Thumbnail section is not displaying correctly");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnThumbnailPrev),"The Thumbnail prev button is displaying correctly","The Thumbnail prev button is not displaying correctly");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnThumbnailNext),"The Thumbnail next button is displaying correctly","The Thumbnail next button is not displaying correctly");
		reporter.softAssert(!this.lnkThumbnailVideo.getAttribute("data-video").isEmpty(),"The video src is not empty","The video src is empty");
		reporter.softAssert(!this.imgThumbnailVideo.getAttribute("src").isEmpty(),"The video image is not empty","The video image is empty");
		this.verifyThumbnailImageListSrc();
		this.verifyThumbnailPrevButton();
		this.verifyThumbnailNextButton();
	}
	
	public void verifyProductBasicInfo() {
		reporter.softAssert(!this.getElementText(this.lblProductName).isEmpty(),"The product name is not empty","The product name is empty");
		reporter.softAssert(!this.getElementText(this.lnkBrandName).isEmpty(),"The product brand name is not empty","The product brand name is empty");
		reporter.softAssert(!this.getElementText(this.lblProductNumber).isEmpty(),"The product number is not empty","The product number is empty");		
	}
	
	public void verifyProductReview() {
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.productReviewSection),"The product review section is displaying correctly","The product review section is not displaying correctly");
		reporter.softAssert(this.lstProductReviewStar.size()>0,"The product review star count is greater than 0","The product review star count is not greater than 0");
		reporter.softAssert(!this.getElementText(this.lblProductReview).isEmpty(),"The product review text is not empty","The product review text is empty");
		
	}
	
	public void verifyProductPriceAndShipping() {
		reporter.softAssert(!this.getElementText(this.lblProductPriceLabel).isEmpty(),"The product price label is not empty","The product price label is empty");
		reporter.softAssert(!this.getElementText(this.lblProductNowPrice).isEmpty(),"The product Now price is not empty","The product Now price is empty");
		reporter.softAssert(!this.getElementText(this.lblProductWasPrice).isEmpty(),"The product Was price is not empty","The product Was price is empty");
		reporter.softAssert(!this.getElementText(this.lblProductNowPrice).isEmpty()&&!this.getElementText(this.lblProductWasPrice).isEmpty(),"The product price range is not empty","The product price range is empty");
		reporter.softAssert(!this.getElementText(this.lblProductEasyPay).isEmpty(),"The product EasyPay message is not empty","The product EasyPay message is empty");
		reporter.softAssert(!this.getElementText(this.lblProductSavings).isEmpty(),"The product Saving message is not empty","The product Saving message is empty");
		reporter.softAssert(!this.getElementText(this.lblProductShipping).isEmpty(),"The product Shipping message is not empty","The product Shipping message is empty");		
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
			reporter.softAssert(!this.getElementText(this.lblRadioProductStyleTitle).isEmpty(),"The product style title message is not empty","The product style title message is empty");
			reporter.softAssert(this.lstStyleRadioList.size()>0,"The product style radio button count is greater than 0","The product style radio button count is not greater than 0");
		}
	}
	
	public void verifySocialMedia() {
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkFavShareMobile),"The FavShareMobile section is displaying correctly","The FavShareMobile section is not displaying correctly");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkFavShareEmail),"The FavShareEmail section is displaying correctly","The FavShareEmail section is not displaying correctly");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkFaceBook),"The FaceBook section is displaying correctly","The FaceBook section is not displaying correctly");
		reporter.softAssert(!this.getElementHref(this.lnkFaceBook).isEmpty(),"The FaceBook link is not empty","The FaceBook link is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkTwitter),"The Twitter section is displaying correctly","The Twitter section is not displaying correctly");
		reporter.softAssert(!this.getElementHref(this.lnkTwitter).isEmpty(),"The Twitter link is not empty","The Twitter link is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkPInterest),"The PInterest section is displaying correctly","The PInterest section is not displaying correctly");
		reporter.softAssert(!this.getElementHref(this.lnkPInterest).isEmpty(),"The PInterest link is not empty","The PInterest link is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lnkFavShareMobile),"The FavShareMobile section is displaying correctly","The FavShareMobile section is not displaying correctly");

		ProductResultsPage prp=new ProductResultsPage(this.getDriver());
		String lsUrl=this.waitForPageLoadingByUrlChange(this.lnkTwitter);
		reporter.softAssert(lsUrl.contains("twitter"),"The page has been switched to twitter related page","The page has not been switched to twitter related page");
		this.getDriver().navigate().back();
		this.waitForPageToLoad();
		prp.waitForPageLoading();
		this.getReusableActionsInstance().staticWait(3000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFaceBook);
		String lsMainHandle=this.getDriver().getWindowHandle();
		this.getReusableActionsInstance().clickIfAvailable(this.lnkFaceBook);
		//this.lnkFaceBook.click();
		this.waitForCondition(Driver->{return this.getReusableActionsInstance().getNumberOfOpenWindows()>1;}, 20000);
		this.getReusableActionsInstance().staticWait(3000);
		Set<String> lstHandles=this.getDriver().getWindowHandles();
		for(String handle:lstHandles) {
			this.getDriver().switchTo().window(handle);
			if(this.getDriver().getCurrentUrl().toLowerCase().contains("facebook")) {
				break;
			}
		}
		reporter.softAssert(lstHandles.size()>1&&this.getDriver().getCurrentUrl().toLowerCase().contains("facebook"),"The page has been switched to facebook page","The page has not been switched to facebook related page");
		this.getDriver().switchTo().window(lsMainHandle);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkPInterest);
		this.getReusableActionsInstance().clickIfAvailable(this.lnkPInterest);
		//this.lnkPInterest.click();
		this.waitForCondition(Driver->{return this.getReusableActionsInstance().isElementVisible(this.iframePin);}, 10000);
		this.getReusableActionsInstance().staticWait(3000);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.iframePin),"The page has been switched to PInterest related page","The page has not been switched to PInterest related page");
		this.getDriver().navigate().back();
		this.waitForPageToLoad();
		prp.waitForPageLoading();
		this.getReusableActionsInstance().staticWait(3000);
	}
	
	public void verifyReviewTabContent() {
		reporter.softAssert(!this.getElementText(this.lblReviewTabHeader).isEmpty(),"The Review tab header is not empty","The Review tab header is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.imgReviewTabHistogram),"The Review tab histogram is displaying correctly","The Review tab histogram is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblReviewTabRateDecimalText).isEmpty(),"The Review tab rate number is not empty","The Review tab rate number is empty");
		reporter.softAssert(this.lstReviewTabStar.size()>0,"The product review tab star count is greater than 0","The product review tab star count is not greater than 0");
		reporter.softAssert(!this.getElementText(this.lblReviewTabReviewCount).isEmpty(),"The Review count message is not empty","The Review count message is empty");
		reporter.softAssert(!this.getElementHref(this.lnkReviewTabWriteReview).isEmpty(),"The Write Review link is not empty","The Write Review link is empty");			
		reporter.softAssert(!this.getElementText(this.lblReviewTabRateDecimalText).isEmpty(),"The Review tab rate number is not empty","The Review tab rate number is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.selectReviewTabSortBy),"The Review sorting is displaying correctly","The Review sorting is not displaying correctly");
	}
	
	public void verifyReviewTabFooterAndBackToTopAndPagination() {
		reporter.softAssert(!this.getElementText(this.lblReviewTabDisplayingReviewMsg).isEmpty(),"The Review message in Review tab footer is not empty","The Review message in Review tab footer is empty");
		reporter.softAssert(!this.getElementHref(this.lnkReviewTabBackToTop).isEmpty(),"The BackToTop link is not empty","The BackToTop link is empty");
		if(this.getChildElementCount(this.cntReviewTabPagination)>0) {
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntReviewTabPagination),"The Review pagination section is displaying correctly","The Review pagination section is not displaying correctly");
		}
	}
	
	public void verifyProductAdvancedOrderMessage() {
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblAdvanceOrderMsg),"The Advanced order message is displaying correctly","The Advanced order message is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblAdvanceOrderMsg).isEmpty(),"The Advanced order message is not empty","The Advanced order message is empty");
	}
	
	public void verifyProductSoldOutBasicInfo() {
		reporter.softAssert(!this.getElementText(this.lblProductName).isEmpty(),"The product name is not empty","The product name is empty");
		reporter.softAssert(!this.getElementText(this.lblProductNumber).isEmpty(),"The product number is not empty","The product number is empty");		
		
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.productReviewSection),"The product review section is displaying correctly","The product review section is not displaying correctly");
		reporter.softAssert(this.lstProductReviewStar.size()>0,"The product review star count is greater than 0","The product review star count is not greater than 0");
		reporter.softAssert(!this.getElementText(this.lblProductReview).isEmpty(),"The product review text is not empty","The product review text is empty");
		
		reporter.softAssert(!this.getElementText(this.lblProductPriceLabel).isEmpty(),"The product price label is not empty","The product price label is empty");
		reporter.softAssert(!this.getElementText(this.lblProductNowPrice).isEmpty(),"The product Now price is not empty","The product Now price is empty");
		reporter.softAssert(!this.getElementText(this.lblProductEasyPay).isEmpty(),"The product EasyPay message is not empty","The product EasyPay message is empty");
		reporter.softAssert(!this.getElementText(this.lblProductShipping).isEmpty(),"The product Shipping message is not empty","The product Shipping message is empty");		
	}
	
	public void verifyProductSoldOut() {
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblSoldOut),"The Soldout message is displaying correctly","The Soldout message is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblSoldOut).isEmpty(),"The Soldout message is not empty","The Soldout message is empty");
		reporter.softAssert(!this.judgeQuantityDropdownAvailable(),"The Quantity Dropdown is not displaying","The Quantity Dropdown is still displaying");
		reporter.softAssert(!this.judgeAddToBagButtonAvailable(),"The Add to Bag button is not displaying","The Add to Bag button is still displaying");
	}
	
	public void verifyCurrentZoomImage() {
		reporter.softAssert(!this.getElementHref(this.lnkCurrentZoomImage).isEmpty(),"The Current zoom image link is not empty","The Current zoom image link is empty");
		reporter.softAssert(!this.getElementText(this.lblZoomImageMessage).isEmpty(),"The Zoom image message is not empty","The Zoom image message is empty");
	}

	public boolean checkIfIsRequiredFieldForWrireReview(WebElement element) {
		return this.checkChildElementExistingByTagName(element, "abbr");
	}

	public void openWriteReview() {
		this.lnkReviewTabWriteReview.click();
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
		this.getReusableActionsInstance().staticWait(1000);

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
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputWriteReviewHeadline);
		this.inputWriteReviewHeadline.sendKeys("Test heading line");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.textareaWriteReviewComments);
		this.textareaWriteReviewComments.sendKeys("Test write a review");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lstWriteReviewRecommendToFriendList.get(0));
		this.lstWriteReviewRecommendToFriendList.get(0).click();
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputWriteReviewNickName);
		this.inputWriteReviewNickName.sendKeys("Cat");
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputWriteReviewLocation);
		this.inputWriteReviewLocation.sendKeys("Toronto");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnWriteReviewSubmitReview);
		this.btnWriteReviewSubmitReview.click();
		this.getReusableActionsInstance().waitForElementVisibility(this.lblWriteReviewAfterSubmitPageTitle,  60);
		this.getReusableActionsInstance().staticWait(1000);

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
			element=item.findElement(byGetTheLookProductImage);
			reporter.softAssert(!this.getElementImageSrc(element).isEmpty(),"The Get the Look image source is not empty","The Get the Look image source is empty");

			element=item.findElement(byGetTheLookProductName);
			reporter.softAssert(!this.getElementText(element).isEmpty(),"The Product name in Get the Look section is not empty","The Product name in Get the Look section is empty");

			element=item.findElement(byGetTheLookProductNumber);
			reporter.softAssert(!this.getElementText(element).isEmpty(),"The Product number in Get the Look section is not empty","The Product number in Get the Look section is empty");

			element=item.findElement(byGetTheLookProductNowPrice);
			reporter.softAssert(!this.getElementText(element).isEmpty(),"The Product Now price in Get the Look section is not empty","The Product Now price in Get the Look section is empty");

			element=item.findElement(byGetTheLookProductPriceContainer);
			if(this.getChildElementCount(element)>2) {
				element=item.findElement(byGetTheLookProductWasPrice);
				reporter.softAssert(!this.getElementText(element).isEmpty(),"The Product Was price in Get the Look section is not empty","The Product Was price in Get the Look section is empty");
			}

			element=item.findElement(byGetTheLookProductEasyPay);
			reporter.softAssert(!this.getElementText(element).isEmpty(),"The Product EasyPay in Get the Look section is not empty","The Product EasyPay in Get the Look section is empty");
		}
	}

	/**
	 * This method will verify Prev/Next button action in Get the Look section.
	 * @return  void
	 * @author Wei.Li
	 */
	public void verifyPrevAndNextButtonActionInGetTheLookSection() {
		if(this.getChildElementCount(this.cntGetTheLook)>2) {
			String lsLinkPrevBefore=this.getElementHref(this.lstGetTheLookItem.get(0));
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnGetTheLookPrev);
			this.btnGetTheLookPrev.click();
			this.waitForCondition(Driver->{return !this.getElementHref(this.lstGetTheLookItem.get(0)).equalsIgnoreCase(lsLinkPrevBefore);}, 10000);

			String lsLinkAfter=this.getElementHref(this.lstGetTheLookItem.get(0));
			reporter.softAssert(!lsLinkPrevBefore.equalsIgnoreCase(lsLinkAfter),"The Prev button works","The Prev button does not work");

			String lsLinkNextBefore=this.getElementHref(this.lstGetTheLookItem.get(this.lstGetTheLookItem.size()-1));
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnGetTheLookNext);
			this.btnGetTheLookNext.click();
			this.waitForCondition(Driver->{return !this.getElementHref(this.lstGetTheLookItem.get(this.lstGetTheLookItem.size()-1)).equalsIgnoreCase(lsLinkNextBefore);}, 10000);

			lsLinkAfter=this.getElementHref(this.lstGetTheLookItem.get(this.lstGetTheLookItem.size()-1));
			reporter.softAssert(!lsLinkNextBefore.equalsIgnoreCase(lsLinkAfter),"The Next button works","The Next button does not work");
		}
	}

	public void verifyClickingSeeMoreButtonAction() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkProductTeaserSeeMore);
		this.lnkProductTeaserSeeMore.click();
		this.getReusableActionsInstance().waitForElementVisibility(this.imgStickyIcon,  60);

		reporter.softAssert(getStickyTabSelectedStatus(this.btnStickyTabProductOverview),"The Product Overview tab is being selected","The Product Overview tab is not being selected");
	}

	public void verifyProductOverviewContent() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnStickyTabProductOverview);
		this.btnStickyTabProductOverview.click();
		this.getReusableActionsInstance().staticWait(1000);

		reporter.softAssert(!this.getElementText(this.lblProductOverviewTabContent).isEmpty(),"The Product Overview contents is not empty","The Product Overview contents is empty");
	}

	public void verifyStickyTabClickingAction() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnStickyTabProductOverview);
		this.btnStickyTabProductOverview.click();
		this.getReusableActionsInstance().staticWait(1000);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.lblProductOverviewTabContent),"The Product Overview contents is displaying correctly","The Product Overview contents is not displaying correctly");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnStickyTabProductReview);
		this.btnStickyTabProductReview.click();
		this.getReusableActionsInstance().staticWait(1000);
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntReviewTabContent),"The Product Overview contents is displaying correctly","The Product Overview contents is not displaying correctly");

		if(this.checkProductSizingChartExisting()) {
			this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnStickyTabSizeChart);
			this.btnStickyTabSizeChart.click();
			this.getReusableActionsInstance().staticWait(1000);
			reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.cntProductSizeChartTabContent),"The Product Overview contents is displaying correctly","The Product Overview contents is not displaying correctly");
		}
	}

	public void verifyProductBrandNameRedirectAction() {
		ProductResultsPage prp=new ProductResultsPage(this.getDriver());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkBrandName);
		reporter.softAssert(!this.getElementHref(this.lnkBrandName).isEmpty(),"The Brand name link is not empty","The Brand name link is empty");
		reporter.softAssert(!this.getElementText(this.lnkBrandName).isEmpty(),"TheBrand name text is not empty","The Brand name text is empty");
		String lsBrandName=this.lnkBrandName.getText().split(":")[1].trim();
		this.lnkBrandName.click();

		this.waitForPageToLoad();
		prp.waitForPageLoading();
		this.getReusableActionsInstance().staticWait(1000);

		reporter.softAssert(this.URL().toLowerCase().contains("productresults"),"The page has been switched to product results page","The page has not been switched to product results page");

		/*this.getReusableActionsInstance().javascriptScrollByVisibleElement(prp.lblSelectedFilters);
		String lsSelectedFilter=prp.selectedFiltersList.get(0).getText().trim();
		reporter.softAssert(lsBrandName.equalsIgnoreCase(lsSelectedFilter),"The selected filter item text is equal to Product brand name","The selected filter item text is not equal to Product brand name");

		this.getDriver().navigate().back();
		this.waitForPageToLoad();
		prp.waitForPageLoading();
		this.getReusableActionsInstance().staticWait(3000);*/
	}

	public void openTellYourFriendsWindow() {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavShareEmail);
		this.getReusableActionsInstance().clickIfAvailable(this.lnkFavShareEmail);
		//this.lnkFavShareEmail.click();
		this.getReusableActionsInstance().waitForElementVisibility(this.lblTellYourFriendsWindowTitle,  60);
	}

	public void tellYourFriendsWindowClose(){
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnTellYourFriendsWindowClose),"The close button of TellYourFriends Window is displaying correctly","The close button of TellYourFriends Window is not displaying correctly");
	}

	public void verifyTellYourFriendsWindowContent() {
		openTellYourFriendsWindow();

		tellYourFriendsWindowClose();
		reporter.softAssert(!this.getElementText(this.lblTellYourFriendsWindowTitle).isEmpty(),"The TellYourFriends Window title is not empty","The TellYourFriends Window title is empty");
		reporter.softAssert(!this.getElementText(this.lblTellYourFriendsWindowRequiredInfo).isEmpty(),"The required info of TellYourFriends Window is not empty","The required info of TellYourFriends Window is empty");

		reporter.softAssert(!this.getElementText(this.lblTellYourFriendsWindowFrom).isEmpty(),"The From text of TellYourFriends Window is not empty","The From text of TellYourFriends Window is empty");
		reporter.softAssert(!this.getElementText(this.lblTellYourFriendsWindowFromName).isEmpty(),"The From name text of TellYourFriends Window is not empty","The From name text of TellYourFriends Window is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.inputTellYourFriendsWindowFromName),"The From name input of TellYourFriends Window is displaying correctly","The From name input of TellYourFriends Window is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblTellYourFriendsWindowFromEmail).isEmpty(),"The From email text of TellYourFriends Window is not empty","The From email text of TellYourFriends Window is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.inputTellYourFriendsWindowFromEmail),"The From email input of TellYourFriends Window is displaying correctly","The From email input of TellYourFriends Window is not displaying correctly");

		reporter.softAssert(!this.getElementText(this.lblTellYourFriendsWindowSendTo).isEmpty(),"The SendTo text of TellYourFriends Window is not empty","The SendTo text of TellYourFriends Window is empty");
		reporter.softAssert(!this.getElementText(this.lblTellYourFriendsWindowSendToName).isEmpty(),"The SendTo name text of TellYourFriends Window is not empty","The SendTo name text of TellYourFriends Window is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.inputTellYourFriendsWindowSendToName),"The SendTo name input of TellYourFriends Window is displaying correctly","The SendTo name input of TellYourFriends Window is not displaying correctly");
		reporter.softAssert(!this.getElementText(this.lblTellYourFriendsWindowSendToEmail).isEmpty(),"The SendTo email text of TellYourFriends Window is not empty","The SendTo email text of TellYourFriends Window is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.inputTellYourFriendsWindowSendToEmail),"The SendTo email input of TellYourFriends Window is displaying correctly","The SendTo email input of TellYourFriends Window is not displaying correctly");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnTellYourFriendsWindowAddRecipient),"The AddRecipient button of TellYourFriends Window is displaying correctly","The AddRecipient button of TellYourFriends Window is not displaying correctly");

		reporter.softAssert(!this.getElementText(this.lblTellYourFriendsWindowAddMessage).isEmpty(),"The AddMessage text of TellYourFriends Window is not empty","The AddMessage text of TellYourFriends Window is empty");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.inputTellYourFriendsWindowAddMessage),"The AddMessage input of TellYourFriends Window is displaying correctly","The AddMessage input of TellYourFriends Window is not displaying correctly");

		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnTellYourFriendsWindowSend),"The send button of TellYourFriends Window is displaying correctly","The send button of TellYourFriends Window is not displaying correctly");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnTellYourFriendsWindowPreview),"The preview button of TellYourFriends Window is displaying correctly","The preview button of TellYourFriends Window is not displaying correctly");
	}

	public void verifyTellYourFriendsPreviewWindowContent() {
		String lsFromName="fromPerson",lsFromEmail="testFrom@test.com";
		String lsSendToName="sendToPerson",lsSendToEmail="testTo@test.com";
		String lsAddMessage="Addional test message";

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTellYourFriendsWindowFromName);
		this.inputTellYourFriendsWindowFromName.sendKeys(lsFromName);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTellYourFriendsWindowFromEmail);
		this.inputTellYourFriendsWindowFromEmail.sendKeys(lsFromEmail);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTellYourFriendsWindowSendToName);
		this.inputTellYourFriendsWindowSendToName.sendKeys(lsSendToName);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTellYourFriendsWindowSendToEmail);
		this.inputTellYourFriendsWindowSendToEmail.sendKeys(lsSendToEmail);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.inputTellYourFriendsWindowAddMessage);
		this.inputTellYourFriendsWindowAddMessage.sendKeys(lsAddMessage);

		this.getReusableActionsInstance().staticWait(1000);
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTellYourFriendsWindowPreview);
		this.getReusableActionsInstance().clickIfAvailable(this.btnTellYourFriendsWindowPreview);
		//this.btnTellYourFriendsWindowPreview.click();
		this.getReusableActionsInstance().waitForElementVisibility(this.lblTellYourFriendsPreviewWindowTitle,  60);
		this.getReusableActionsInstance().staticWait(1000);

		String lsPreviewFromNameAndEmail=this.getElementText(this.lblTellYourFriendsPreviewWindowFromNameAndEmail);
		reporter.softAssert(lsPreviewFromNameAndEmail.contains(lsFromName),"The preview From message is containing input From name","The preview From message is not containing input From name");
		reporter.softAssert(lsPreviewFromNameAndEmail.contains(lsFromEmail),"The preview From message is containing input From email","The preview From message is not containing input From email");

		String lsPreviewSendToNameAndEmail=this.getElementText(this.lblTellYourFriendsPreviewWindowSendToNameAndEmail);
		reporter.softAssert(lsPreviewSendToNameAndEmail.contains(lsSendToName),"The preview SendTo message is containing input SendTo name","The preview SendTo message is not containing input SendTo name");
		reporter.softAssert(lsPreviewSendToNameAndEmail.contains(lsSendToEmail),"The preview SendTo message is containing input SendTo email","The preview SendTo message is not containing input SendTo email");

		String lsPreviewYourMessage=this.getElementText(this.lblTellYourFriendsPreviewWindowYourMessageContent);
		reporter.softAssert(lsPreviewYourMessage.equalsIgnoreCase(lsAddMessage),"The preview Your message is equal to input Adding Messge","The preview Your message is not equal to input Adding Messge");

		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnTellYourFriendsPreviewWindowSend),"The Preview send button is displaying correctly","The Preview send button is not displaying correctly");
		reporter.softAssert(this.getReusableActionsInstance().isElementVisible(this.btnTellYourFriendsPreviewWindowBackToEditEmail),"The Preview BackToEditEmail button is displaying correctly","The Preview BackToEditEmail button is not displaying correctly");

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTellYourFriendsPreviewWindowBackToEditEmail);
		this.getReusableActionsInstance().clickIfAvailable(this.btnTellYourFriendsPreviewWindowBackToEditEmail);
		//this.btnTellYourFriendsPreviewWindowBackToEditEmail.click();
		this.getReusableActionsInstance().waitForElementVisibility(this.lblTellYourFriendsWindowTitle,  60);
		this.getReusableActionsInstance().staticWait(1000);
	}

	public void verifyTellYourFriendsSentWindowContent(String lsTellYourFriendsSentMessage) {
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.btnTellYourFriendsWindowSend);
		this.btnTellYourFriendsWindowSend.click();
		this.getReusableActionsInstance().waitForElementVisibility(this.lblTellYourFriendsSentWindowTitle,  60);
		this.getReusableActionsInstance().staticWait(1000);

		String lsMessage=this.getElementText(this.lblTellYourFriendsSentWindowSentMessage).trim();
		reporter.softAssert(lsMessage.equalsIgnoreCase(lsTellYourFriendsSentMessage),"The confirmation message in sent window is equal to '"+lsTellYourFriendsSentMessage+"'","The confirmation message in sent window is not equal to '"+lsTellYourFriendsSentMessage+"'");

		//this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavShareMobile);
		this.getReusableActionsInstance().clickIfAvailable(this.btnTellYourFriendsWindowClose);
		//this.btnTellYourFriendsWindowClose.click();
		this.getReusableActionsInstance().staticWait(1000);
	}

	public boolean checkIfFavShareMobileHighlighted() {
		return !this.hasElementAttribute(this.lnkFavShareMobile, "class");
	}

	public void verifyFavShareMobileAction(String lsUserName, String lsPassword) {
		LoginPage loginPage=new LoginPage(this.getDriver());
		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavShareMobile);
		this.getReusableActionsInstance().clickIfAvailable(this.lnkFavShareMobile);
		//this.lnkFavShareMobile.click();
		this.getReusableActionsInstance().waitForElementVisibility(loginPage.lblSignIn,  60);
		this.getReusableActionsInstance().staticWait(1000);

		reporter.softAssert(this.URL().toLowerCase().contains("signin"),"The page has been navigated to signin page while no user login","The page has not been navigated to signin page while no user login");

		loginPage.LoginWithoutWaitingTime(lsUserName,lsPassword);
		this.getReusableActionsInstance().waitForElementVisibility(this.lblProductName,  60);
		this.getReusableActionsInstance().staticWait(1000);

		this.getReusableActionsInstance().javascriptScrollByVisibleElement(this.lnkFavShareMobile);
		this.getReusableActionsInstance().clickIfAvailable(this.lnkFavShareMobile);
		//this.lnkFavShareMobile.click();
		this.getReusableActionsInstance().staticWait(5000);
		reporter.softAssert(checkIfFavShareMobileHighlighted(),"The FavShareMobile icon is highlighted after clicking with user login", "The FavShareMobile icon is not highlighted after clicking with user login");
	}


}
