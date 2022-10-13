package com.tsc.data.pojos;


import java.util.List;
import java.util.Map;

public class ConstantData {
    public HeaderSection headerSection;
    public HomePage homePage;
    public SearchResultPage searchResultPage;
    public FooterSection footerSection;
    public LoginUser loginUser;
    public APIUserSessionParams apiUserSessionParams;
    public APIAppSessionParams apiAppSessionParams;
    public ContentfulApiParams contentfulApiParams;
    public MyAccount myAccount;
    private List<String> lstTestName;
    private String lblChromeBrowserVersion;
    private ShoppingCart shoppingCart;
    private Checkout checkOut;

    public Checkout getCheckOut() {        return checkOut;    }

    public void setCheckOut(Checkout checkOut) {        this.checkOut = checkOut;    }

    public ContentfulApiParams getContentfulApiParams() {        return contentfulApiParams;    }

    public void setContentfulApiParams(ContentfulApiParams contentfulApiParams) {        this.contentfulApiParams = contentfulApiParams;    }

    public ShoppingCart getShoppingCart() {        return shoppingCart;    }

    public void setShoppingCart(ShoppingCart shoppingCart) {        this.shoppingCart = shoppingCart;    }

    public String getLblChromeBrowserVersion() {        return lblChromeBrowserVersion;    }

    public void setLblChromeBrowserVersion(String lblChromeBrowserVersion) {        this.lblChromeBrowserVersion = lblChromeBrowserVersion;    }

    public List<String> getLstTestName() {        return lstTestName;    }

    public void setLstTestName(List<String> lstTestName) {        this.lstTestName = lstTestName;    }

    public APIUserSessionParams getApiUserSessionParams() { return apiUserSessionParams; }

    public void setApiUserSessionParams(APIUserSessionParams apiUserSessionParams) { this.apiUserSessionParams = apiUserSessionParams; }

    public APIAppSessionParams getApiAppSessionParams() {        return apiAppSessionParams;    }

    public void setApiAppSessionParams(APIAppSessionParams apiAppSessionParams) {        this.apiAppSessionParams = apiAppSessionParams;    }

    public HeaderSection getHeaderSection() {
        return headerSection;
    }

    public void setHeaderSection(HeaderSection headerSection) {
        this.headerSection = headerSection;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public SearchResultPage getSearchResultPage() {
        return searchResultPage;
    }

    public void setSearchResultPage(SearchResultPage searchResultPage) {
        this.searchResultPage = searchResultPage;
    }
    
    public FooterSection getFooterSection() {
        return footerSection;
    }

    public void setFooterSection(FooterSection footerSection) {
        this.footerSection = footerSection;
    }
    
    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    public MyAccount getMyAccount() {        return myAccount;    }

    public void setMyAccount(MyAccount myAccount) {        this.myAccount = myAccount;    }

    public static class HeaderSection {
        private String lnk_NotFound;
        private String lbl_TodaysShowstopper;
        private String lnk_TodaysShowstopper;
        private String lbl_Deals_English;
        private String lbl_Deals_French;
        private String lnk_Deals;
        private String lbl_OnAirProducts_English;
        private String lbl_OnAirProducts_EnglishMobile;
        private String lbl_OnAirProducts_French;
        private String lnk_OnAirProducts;
        private String lnk_OnAirProductIcon_MOBILE;
        private String lbl_ProgramGuide_English;
        private String lbl_ProgramGuide_French;
        private String lnk_ProgramGuide;
        private String lnk_ProgramGuideRedirect;
        private String lbl_WatchUsLive_English;
        private String lbl_WatchUsLive_French;
        private String lnk_WatchUsLive;
        private String lbl_Favourites;
        private List<String> lst_SignInPopover;
        private String lbl_SignIn;
        private String lbl_SignInLandingPage;
        private String lbl_SearchBoxPlaceholder;
        private String lbl_ShoppingCartLinkName;
        private String lnk_ShoppingCartLink;
        private Flyout flyout;
        private Map<String, List<String>> lst_WatchTSCNameAndLinksMap;
        private Map<String, List<String>> lst_HeaderNameAndLinksMap;
        private String lbl_ParialURLEndWatchTSC;

        public String getLbl_ParialURLEndWatchTSC() {     return lbl_ParialURLEndWatchTSC;       }

        public void setLbl_ParialURLEndWatchTSC(String lbl_ParialURLEndWatchTSC) {       this.lbl_ParialURLEndWatchTSC = lbl_ParialURLEndWatchTSC;      }

        public Map<String, List<String>> getLst_HeaderNameAndLinksMap() {
			return lst_HeaderNameAndLinksMap;
		}

		public void setLst_HeaderNameAndLinksMap(Map<String, List<String>> lst_HeaderNameAndLinksMap) {
			this.lst_HeaderNameAndLinksMap = lst_HeaderNameAndLinksMap;
		}

		public Map<String, List<String>> getLst_WatchTSCNameAndLinksMap() {
			return lst_WatchTSCNameAndLinksMap;
		}

		public void setLst_WatchTSCNameAndLinksMap(Map<String, List<String>> lst_WatchTSCNameAndLinksMap) {
			this.lst_WatchTSCNameAndLinksMap = lst_WatchTSCNameAndLinksMap;
		}

        public String getLbl_SignInLandingPage() {
        	return lbl_SignInLandingPage;
        }

        public void setLbl_SignInLandingPage(String lbl_SignInLandingPage) {
        	this.lbl_SignInLandingPage = lbl_SignInLandingPage;
        }

        public String getLbl_ShoppingCartLinkName() {
            return lbl_ShoppingCartLinkName;
        }

        public void setLbl_ShoppingCartLinkName(String lbl_ShoppingCartLinkName) {
            this.lbl_ShoppingCartLinkName = lbl_ShoppingCartLinkName;
        }

        public String getLnk_ShoppingCartLink() {
            return lnk_ShoppingCartLink;
        }

        public void setLnk_ShoppingCartLink(String lnk_ShoppingCartLink) {
            this.lnk_ShoppingCartLink = lnk_ShoppingCartLink;
        }

        public Flyout getFlyout() {
            return flyout;
        }

        public void setFlyout(Flyout flyout) {
            this.flyout = flyout;
        }

        public String getLnk_NotFound() {
            return lnk_NotFound;
        }

        public void setLnk_NotFound(String lnk_NotFound) {
            this.lnk_NotFound = lnk_NotFound;
        }

        public String getLbl_TodaysShowstopper() {
            return lbl_TodaysShowstopper;
        }

        public void setLbl_TodaysShowstopper(String lbl_TodaysShowstopper) {
            this.lbl_TodaysShowstopper = lbl_TodaysShowstopper;
        }

        public String getLnk_TodaysShowstopper() {
            return lnk_TodaysShowstopper;
        }

        public void setLnk_TodaysShowstopper(String lnk_TodaysShowstopper) {
            this.lnk_TodaysShowstopper = lnk_TodaysShowstopper;
        }

        public String getLbl_Deals_English() {
            return lbl_Deals_English;
        }

        public void setLbl_Deals_English(String lbl_Deals_English) {
            this.lbl_Deals_English = lbl_Deals_English;
        }

        public String getLbl_Deals_French() {
            return lbl_Deals_French;
        }

        public void setLbl_Deals_French(String lbl_Deals_French) {
            this.lbl_Deals_French = lbl_Deals_French;
        }

        public String getLnk_Deals() {
            return lnk_Deals;
        }

        public void setLnk_Deals(String lnk_Deals) {
            this.lnk_Deals = lnk_Deals;
        }

        public String getLbl_OnAirProducts_English() {
            return lbl_OnAirProducts_English;
        }

        public void setLbl_OnAirProducts_English(String lbl_OnAirProducts_English) {
            this.lbl_OnAirProducts_English = lbl_OnAirProducts_English;
        }

        public String getLbl_OnAirProducts_EnglishMobile() {
            return lbl_OnAirProducts_EnglishMobile;
        }

        public void setLbl_OnAirProducts_EnglishMobile(String lbl_OnAirProducts_EnglishMobile) {
            this.lbl_OnAirProducts_EnglishMobile = lbl_OnAirProducts_EnglishMobile;
        }

        public String getLbl_OnAirProducts_French() {
            return lbl_OnAirProducts_French;
        }

        public void setLbl_OnAirProducts_French(String lbl_OnAirProducts_French) {
            this.lbl_OnAirProducts_French = lbl_OnAirProducts_French;
        }

        public String getLnk_OnAirProducts() {
            return lnk_OnAirProducts;
        }

        public void setLnk_OnAirProducts(String lnk_OnAirProducts) {
            this.lnk_OnAirProducts = lnk_OnAirProducts;
        }

        public String getLnk_OnAirProductIcon_MOBILE() {
            return lnk_OnAirProductIcon_MOBILE;
        }

        public void setLnk_OnAirProductIcon_MOBILE(String lnk_OnAirProductIcon_MOBILE) {
            this.lnk_OnAirProductIcon_MOBILE = lnk_OnAirProductIcon_MOBILE;
        }

        public String getLbl_ProgramGuide_English() {
            return lbl_ProgramGuide_English;
        }

        public void setLbl_ProgramGuide_English(String lbl_ProgramGuide_English) {
            this.lbl_ProgramGuide_English = lbl_ProgramGuide_English;
        }

        public String getLbl_ProgramGuide_French() {
            return lbl_ProgramGuide_French;
        }

        public void setLbl_ProgramGuide_French(String lbl_ProgramGuide_French) {
            this.lbl_ProgramGuide_French = lbl_ProgramGuide_French;
        }

        public String getLnk_ProgramGuide() {
            return lnk_ProgramGuide;
        }

        public void setLnk_ProgramGuide(String lnk_ProgramGuide) {
            this.lnk_ProgramGuide = lnk_ProgramGuide;
        }

        public String getLnk_ProgramGuideRedirect() {
            return lnk_ProgramGuideRedirect;
        }

        public void setLnk_ProgramGuideRedirect(String lnk_ProgramGuideRedirect) {
            this.lnk_ProgramGuideRedirect = lnk_ProgramGuideRedirect;
        }

        public String getLbl_WatchUsLive_English() {
            return lbl_WatchUsLive_English;
        }

        public void setLbl_WatchUsLive_English(String lbl_WatchUsLive_English) {
            this.lbl_WatchUsLive_English = lbl_WatchUsLive_English;
        }

        public String getLbl_WatchUsLive_French() {
            return lbl_WatchUsLive_French;
        }

        public void setLbl_WatchUsLive_French(String lbl_WatchUsLive_French) {
            this.lbl_WatchUsLive_French = lbl_WatchUsLive_French;
        }

        public String getLnk_WatchUsLive() {
            return lnk_WatchUsLive;
        }

        public void setLnk_WatchUsLive(String lnk_WatchUsLive) {
            this.lnk_WatchUsLive = lnk_WatchUsLive;
        }

        public String getLbl_Favourites() {
            return lbl_Favourites;
        }

        public void setLbl_Favourites(String lbl_Favourites) {
            this.lbl_Favourites = lbl_Favourites;
        }
        
        public List<String> getLst_SignInPopover() {
            return lst_SignInPopover;
        }

        public void setLst_SignInPopover(List<String> lst_SignInPopover) {
            this.lst_SignInPopover = lst_SignInPopover;
        }
        
        public String getLbl_SignIn() {
            return lbl_SignIn;
        }

        public void setLbl_SignIn(String lbl_SignIn) {
            this.lbl_SignIn = lbl_SignIn;
        }
        
        public String getlbl_SignInLandingPage() {
            return lbl_SignInLandingPage;
        }

        public void setlbl_SignInLandingPage(String lbl_SignInLandingPage) {
            this.lbl_SignInLandingPage = lbl_SignInLandingPage;
        }

        public String getLbl_SearchBoxPlaceholder() {
            return lbl_SearchBoxPlaceholder;
        }

        public void setLbl_SearchBoxPlaceholder(String lbl_SearchBoxPlaceholder) {
            this.lbl_SearchBoxPlaceholder = lbl_SearchBoxPlaceholder;
        }
    }

    public static class HeaderNameAndLinks{
        String headerName;
        List<String> links;

        public String getHeaderName() {
            return headerName;
        }

        public void setHeaderName(String headerName) {
            this.headerName = headerName;
        }

        public List<String> getLinks() {
            return links;
        }

        public void setLinks(List<String> links) {
            this.links = links;
        }
    }

    public static class HomePage {
        private String lbl_OnAirNow;
        private String lbl_RecentlyAir;
        private String lnk_RecentlyAir;
        private String lnk_RecentlyAirShopAllItems;
        private String txt_RecentlyAirShopAllItems;
        private String lbl_ShopByBrand;
        private String lbl_ShopByBrandViewAll;
        private String lnk_ShopByBrandViewAll;
        private String lbl_ShopByDepartment;
        private List<String> lst_ShopByDepartmentCategories;
        private String lbl_TopSellers;

        public String getLbl_OnAirNow() {
            return lbl_OnAirNow;
        }

        public void setLbl_OnAirNow(String lbl_OnAirNow) {
            this.lbl_OnAirNow = lbl_OnAirNow;
        }

        public String getLbl_RecentlyAir() {
            return lbl_RecentlyAir;
        }

        public void setLbl_RecentlyAir(String lbl_RecentlyAir) {
            this.lbl_RecentlyAir = lbl_RecentlyAir;
        }

        public String getLnk_RecentlyAir() {
            return lnk_RecentlyAir;
        }

        public void setLnk_RecentlyAir(String lnk_RecentlyAir) {
            this.lnk_RecentlyAir = lnk_RecentlyAir;
        }

        public String getLnk_RecentlyAirShopAllItems() {
            return lnk_RecentlyAirShopAllItems;
        }

        public void setLnk_RecentlyAirShopAllItems(String lnk_RecentlyAirShopAllItems) {
            this.lnk_RecentlyAirShopAllItems = lnk_RecentlyAirShopAllItems;
        }

        public String getTxt_RecentlyAirShopAllItems() {
            return txt_RecentlyAirShopAllItems;
        }

        public void setTxt_RecentlyAirShopAllItems(String txt_RecentlyAirShopAllItems) {
            this.txt_RecentlyAirShopAllItems = txt_RecentlyAirShopAllItems;
        }

        public String getLbl_ShopByBrand() {
            return lbl_ShopByBrand;
        }

        public void setLbl_ShopByBrand(String lbl_ShopByBrand) {
            this.lbl_ShopByBrand = lbl_ShopByBrand;
        }

        public String getLbl_ShopByBrandViewAll() {
            return lbl_ShopByBrandViewAll;
        }

        public void setLbl_ShopByBrandViewAll(String lbl_ShopByBrandViewAll) {
            this.lbl_ShopByBrandViewAll = lbl_ShopByBrandViewAll;
        }

        public String getLnk_ShopByBrandViewAll() {
            return lnk_ShopByBrandViewAll;
        }

        public void setLnk_ShopByBrandViewAll(String lnk_ShopByBrandViewAll) {
            this.lnk_ShopByBrandViewAll = lnk_ShopByBrandViewAll;
        }

        public String getLbl_ShopByDepartment() {
            return lbl_ShopByDepartment;
        }

        public void setLbl_ShopByDepartment(String lbl_ShopByDepartment) {
            this.lbl_ShopByDepartment = lbl_ShopByDepartment;
        }

        public List<String> getLst_ShopByDepartmentCategories() {
            return lst_ShopByDepartmentCategories;
        }

        public void setLst_ShopByDepartmentCategories(List<String> lst_ShopByDepartmentCategories) {
            this.lst_ShopByDepartmentCategories = lst_ShopByDepartmentCategories;
        }

        public String getLbl_TopSellers() {
            return lbl_TopSellers;
        }

        public void setLbl_TopSellers(String lbl_TopSellers) {
            this.lbl_TopSellers = lbl_TopSellers;
        }
    }

    public static class APIUserSessionParams{
        private String lbl_username;
        private String lbl_password;
        private String lbl_grantType;
        private String lbl_apiKey;

        public String getLbl_username() { return lbl_username;  }
        public void setLbl_username(String lbl_username) { this.lbl_username = lbl_username;     }
        public String getLbl_password() {        return lbl_password;     }
        public void setLbl_password(String lbl_password) {          this.lbl_password = lbl_password;    }
        public String getLbl_grantType() {         return lbl_grantType;      }
        public void setLbl_grantType(String lbl_grantType) {       this.lbl_grantType = lbl_grantType;     }
        public String getLbl_apiKey() {         return lbl_apiKey;     }
        public void setLbl_apiKey(String lbl_apiKey) {         this.lbl_apiKey = lbl_apiKey;     }
    }

    public static class APIAppSessionParams{
        private String lbl_username;
        private String lbl_password;
        private String lbl_grantType;

        public String getLbl_username() {
            return lbl_username;
        }

        public void setLbl_username(String lbl_username) {
            this.lbl_username = lbl_username;
        }

        public String getLbl_password() {
            return lbl_password;
        }

        public void setLbl_password(String lbl_password) {
            this.lbl_password = lbl_password;
        }

        public String getLbl_grantType() {
            return lbl_grantType;
        }

        public void setLbl_grantType(String lbl_grantType) {
            this.lbl_grantType = lbl_grantType;
        }
    }

    public static class SearchResultPage {
        private List<String> lst_SearchKeyword;
        private List<List<String>> lst_SearchKeyword_DropDown;
        private List<String> lst_APISearchingKeyword;
        private String lbl_SearchResultPageDefaultSetting;
        private List<String> lst_SearchResultMessage;
        private List<String> lst_SortOption;
        private List<String> lst_FilterOptionHeader;
        private List<SearchOption> lst_SearchOption;
        private List<String> lst_MoreButton;
        private List<String> lst_DisappearAfterSelectFilter;
        private String lnk_product_result;
        private List<String> lbl_ProductRecommendationTitlePage;
        private String lbl_AddToBagPopupWindowTitle;
        private String lbl_VideoDisclaimInfo;
        private String lbl_AdvancedOrderkeyword;
        private String lbl_AdvancedOrderMessage;
        private String lbl_AutoDeliverykeyword;
        private String lbl_productTrueFitAndSizingChart;
        private String lbl_ProductDeliveryOptions;
        private String lbl_SoldOutkeyword;
        private String lbl_QuantityNumberToShowLeftItemInfo;
        private List<String> lst_WriteReviewSubmitMessage;
        private String lbl_TellYourFriendsSentMessage;
        private List<String> lst_Filter_Data;
        private List<String> lst_SortOptionMobile;
        private String lbl_ProductNumberWithBandAndReviewAndSeeMore;
        private List<String> lst_SearchKeyword_Bugs;
        private String lbl_ProductNumberToComparePRPAndPDPContent;
        private String lbl_prp_partial_url;
        private List<String> lst_ClearanceKeyword;
        private List<String> lst_ShoppingCartSearchKeyword;

        public List<String> getLst_ShoppingCartSearchKeyword() {            return lst_ShoppingCartSearchKeyword;        }

        public void setLst_ShoppingCartSearchKeyword(List<String> lst_ShoppingCartSearchKeyword) {            this.lst_ShoppingCartSearchKeyword = lst_ShoppingCartSearchKeyword;        }

        public List<String> getLst_ClearanceKeyword() {
            return lst_ClearanceKeyword;
        }

        public void setLst_ClearanceKeyword(List<String> lst_ClearanceKeyword) {
            this.lst_ClearanceKeyword = lst_ClearanceKeyword;
        }

        public String getLbl_prp_partial_url() {  return lbl_prp_partial_url;    }

        public void setLbl_prp_partial_url(String lbl_prp_partial_url) {  this.lbl_prp_partial_url = lbl_prp_partial_url;      }

        public List<String> getLst_SearchKeyword_Bugs() { return lst_SearchKeyword_Bugs; }

        public void setLst_SearchKeyword_Bugs(List<String> lst_SearchKeyword_Bugs) { this.lst_SearchKeyword_Bugs = lst_SearchKeyword_Bugs; }

        public List<String> getLst_SearchKeyword() {
            return lst_SearchKeyword;
        }

        public void setLst_SearchKeyword(List<String> lst_SearchKeyword) {
            this.lst_SearchKeyword = lst_SearchKeyword;
        }

        public List<List<String>> getLst_SearchKeyword_DropDown() {
            return lst_SearchKeyword_DropDown;
        }

        public void setLst_SearchKeyword_DropDown(List<List<String>> lst_SearchKeyword_DropDown) {
            this.lst_SearchKeyword_DropDown = lst_SearchKeyword_DropDown;
        }
        
        public List<String> getLst_APISearchingKeyword() {
			return lst_APISearchingKeyword;
		}

		public void setLst_APISearchingKeyword(List<String> lst_APISearchingKeyword) {
			this.lst_APISearchingKeyword = lst_APISearchingKeyword;
		}

        public String getLbl_SearchResultPageDefaultSetting() {
            return lbl_SearchResultPageDefaultSetting;
        }

        public void setLbl_SearchResultPageDefaultSetting(String lbl_SearchResultPageDefaultSetting) {
            this.lbl_SearchResultPageDefaultSetting = lbl_SearchResultPageDefaultSetting;
        }

        public List<String> getLst_SearchResultMessage() {
            return lst_SearchResultMessage;
        }

        public void setLst_SearchResultMessage(List<String> lst_SearchResultMessage) {
            this.lst_SearchResultMessage = lst_SearchResultMessage;
        }

        public List<String> getLst_SortOption() {
            return lst_SortOption;
        }

        public void setLst_SortOption(List<String> lst_SortOption) {
            this.lst_SortOption = lst_SortOption;
        }

        public List<String> getLst_FilterOptionHeader() {
            return lst_FilterOptionHeader;
        }

        public void setLst_FilterOptionHeader(List<String> lst_FilterOptionHeader) {
            this.lst_FilterOptionHeader = lst_FilterOptionHeader;
        }

        public List<String> getLst_Filter_Data() { return lst_Filter_Data; }

        public void setLst_Filter_Data(List<String> lst_Filter_Data) { this.lst_Filter_Data = lst_Filter_Data; }

        public List<String> getLst_SortOptionMobile() { return lst_SortOptionMobile; }

        public void setLst_SortOptionMobile(List<String> lst_SortOptionMobile) { this.lst_SortOptionMobile = lst_SortOptionMobile; }

        public List<SearchOption> getLst_SearchOption() {
            return lst_SearchOption;
        }

        public void setLst_SearchOption(List<SearchOption> lst_SearchOption) {
            this.lst_SearchOption = lst_SearchOption;
        }
        
        public List<String> getLst_MoreButton() {
            return lst_MoreButton;
        }

        public void setLst_MoreButton(List<String> lst_MoreButton) {
            this.lst_MoreButton = lst_MoreButton;
        }
        
        public List<String> getLst_DisappearAfterSelectFilter() {
            return lst_DisappearAfterSelectFilter;
        }

        public void setLst_DisappearAfterSelectFilter(List<String> lst_DisappearAfterSelectFilter) {
            this.lst_DisappearAfterSelectFilter = lst_DisappearAfterSelectFilter;
        }
        
        public String getLnk_product_result() {
            return lnk_product_result;
        }

        public void setLnk_product_result(String lnk_product_result) {
            this.lnk_product_result = lnk_product_result;
        }
        
        public List<String> getLbl_ProductRecommendationTitlePage() {
            return lbl_ProductRecommendationTitlePage;
        }

        public void setLbl_ProductRecommendationTitlePage(List<String> lbl_ProductRecommendationTitlePage) {
            this.lbl_ProductRecommendationTitlePage = lbl_ProductRecommendationTitlePage;
        }
        
        public String getLbl_AddToBagPopupWindowTitle() {
            return lbl_AddToBagPopupWindowTitle;
        }

        public void setLbl_AddToBagPopupWindowTitle(String lbl_AddToBagPopupWindowTitle) {
            this.lbl_AddToBagPopupWindowTitle = lbl_AddToBagPopupWindowTitle;
        }
        
        public String getLbl_VideoDisclaimInfo() {
            return lbl_VideoDisclaimInfo;
        }

        public void setLbl_VideoDisclaimInfo(String lbl_VideoDisclaimInfo) {
            this.lbl_VideoDisclaimInfo = lbl_VideoDisclaimInfo;
        }
        
        public String getLbl_AdvancedOrderkeyword() {
            return lbl_AdvancedOrderkeyword;
        }

        public void setLbl_AdvancedOrderkeyword(String lbl_AdvancedOrderkeyword) {
            this.lbl_AdvancedOrderkeyword = lbl_AdvancedOrderkeyword;
        }

        public String getLbl_AdvancedOrderMessage() {
            return lbl_AdvancedOrderMessage;
        }

        public void setLbl_AdvancedOrderMessage(String lbl_AdvancedOrderMessage) {
            this.lbl_AdvancedOrderMessage = lbl_AdvancedOrderMessage;
        }

        public String getLbl_AutoDeliverykeyword() {
            return lbl_AutoDeliverykeyword;
        }

        public void setLbl_AutoDeliverykeyword(String lbl_AutoDeliverykeyword) {
            this.lbl_AutoDeliverykeyword = lbl_AutoDeliverykeyword;
        }

        public String getLbl_productTrueFitAndSizingChart() {
            return lbl_productTrueFitAndSizingChart;
        }

        public void setLbl_productTrueFitAndSizingChart(String lbl_productTrueFitAndSizingChart) {
            this.lbl_productTrueFitAndSizingChart = lbl_productTrueFitAndSizingChart;
        }

        public String getLbl_ProductDeliveryOptions() {
            return lbl_ProductDeliveryOptions;
        }

        public void setLbl_ProductDeliveryOptions(String lbl_ProductDeliveryOptions) {
            this.lbl_ProductDeliveryOptions = lbl_ProductDeliveryOptions;
        }

        public String getLbl_SoldOutkeyword() {
            return lbl_SoldOutkeyword;
        }

        public void setLbl_SoldOutkeyword(String lbl_SoldOutkeyword) {
            this.lbl_SoldOutkeyword = lbl_SoldOutkeyword;
        }

        public String getLbl_QuantityNumberToShowLeftItemInfo() {
            return lbl_QuantityNumberToShowLeftItemInfo;
        }

        public void setLbl_QuantityNumberToShowLeftItemInfo(String lbl_QuantityNumberToShowLeftItemInfo) {
            this.lbl_QuantityNumberToShowLeftItemInfo = lbl_QuantityNumberToShowLeftItemInfo;
        }

        public List<String> getLst_WriteReviewSubmitMessage() {
            return lst_WriteReviewSubmitMessage;
        }

        public void setLst_WriteReviewSubmitMessage(List<String> lst_WriteReviewSubmitMessage) {
            this.lst_WriteReviewSubmitMessage = lst_WriteReviewSubmitMessage;
        }

        public String getLbl_TellYourFriendsSentMessage() {
            return lbl_TellYourFriendsSentMessage;
        }

        public void setLbl_TellYourFriendsSentMessage(String lbl_TellYourFriendsSentMessage) {
            this.lbl_TellYourFriendsSentMessage = lbl_TellYourFriendsSentMessage;
        }
        
        public String getLbl_ProductNumberWithBandAndReviewAndSeeMore() {
			return lbl_ProductNumberWithBandAndReviewAndSeeMore;
		}

		public void setLbl_ProductNumberWithBandAndReviewAndSeeMore(String lbl_ProductNumberWithBandAndReviewAndSeeMore) {
			this.lbl_ProductNumberWithBandAndReviewAndSeeMore = lbl_ProductNumberWithBandAndReviewAndSeeMore;
		}
		
        public String getLbl_ProductNumberToComparePRPAndPDPContent() {
			return lbl_ProductNumberToComparePRPAndPDPContent;
		}

		public void setLbl_ProductNumberToComparePRPAndPDPContent(String lbl_ProductNumberToComparePRPAndPDPContent) {
			this.lbl_ProductNumberToComparePRPAndPDPContent = lbl_ProductNumberToComparePRPAndPDPContent;
		}
    }

    public static class ContentfulApiParams{
        private String lbl_authorization;
        private String lbl_apiEndPoint;

        public String getLbl_authorization() {            return lbl_authorization;        }

        public void setLbl_authorization(String lbl_authorization) {            this.lbl_authorization = lbl_authorization;        }

        public String getLbl_apiEndPoint() {            return lbl_apiEndPoint;        }

        public void setLbl_apiEndPoint(String lbl_apiEndPoint) {            this.lbl_apiEndPoint = lbl_apiEndPoint;        }
    }

    public static class Flyout {
        private String lbl_FlyoutHeadingLandingPageLink;
        private String lbl_LandingPageBrandShopAll;
        private String lnk_ShopByBrandShopAll;
        private Map<String, List<String>> lst_FlyoutHeadingAndNameMap;

		public Map<String, List<String>> getLst_FlyoutHeadingAndNameMap() {
        	return lst_FlyoutHeadingAndNameMap;
        }

        public void setLst_FlyoutHeadingAndNameMap(Map<String, List<String>> lst_FlyoutHeadingAndNameMap) {
            this.lst_FlyoutHeadingAndNameMap = lst_FlyoutHeadingAndNameMap;
        }

        public String getLbl_FlyoutHeadingLandingPageLink() {
            return lbl_FlyoutHeadingLandingPageLink;
        }

        public void setLbl_FlyoutHeadingLandingPageLink(String lbl_FlyoutHeadingLandingPageLink) {
            this.lbl_FlyoutHeadingLandingPageLink = lbl_FlyoutHeadingLandingPageLink;
        }

        public String getlbl_LandingPageBrandShopAll() {
            return lbl_LandingPageBrandShopAll;
        }

        public void setlbl_LandingPageBrandShopAll(String lbl_LandingPageBrandShopAll) {
            this.lbl_LandingPageBrandShopAll = lbl_LandingPageBrandShopAll;
        }
        
        public String getlnk_ShopByBrandShopAll() {
            return lnk_ShopByBrandShopAll;
        }

        public void setlnk_ShopByBrandShopAll(String lnk_ShopByBrandShopAll) {
            this.lnk_ShopByBrandShopAll = lnk_ShopByBrandShopAll;
        }
    }

    public static class SearchOption {
        private String filterType;
        private List<List<String>> filterOption;

        public String getFilterType() {
            return filterType;
        }

        public void setFilterType(String filterType) {
            this.filterType = filterType;
        }

        public List<List<String>> getFilterOption() {
            return filterOption;
        }

        public void setFilterOption(List<List<String>> filterOption) {
            this.filterOption = filterOption;
        }
    }
    
    public static class FooterSection {
        private List<String> lst_SocialMediaLinks;
        private List<List<String>> lst_NameAndLinks;
        private List<String> lst_MyAccountObjectSectionTitle;
        private List<String> lst_TrackYourOrderObjectSectionTitle;
        public List<String> getLst_SocialMediaLinks() {
            return lst_SocialMediaLinks;
        }

        public void setLst_SocialMediaLinks(List<String> lst_SocialMediaLinks) {
            this.lst_SocialMediaLinks = lst_SocialMediaLinks;
        }
        
        public List<String> getLst_MyAccountObjectSectionTitle() {
            return lst_MyAccountObjectSectionTitle;
        }

        public void setLst_MyAccountObjectSectionTitle(List<String> lst_MyAccountObjectSectionTitle) {
            this.lst_MyAccountObjectSectionTitle = lst_MyAccountObjectSectionTitle;
        }
        
        public List<String> getLst_TrackYourOrderObjectSectionTitle() {
            return lst_TrackYourOrderObjectSectionTitle;
        }

        public void setLst_TrackYourOrderObjectSectionTitle(List<String> lst_TrackYourOrderObjectSectionTitle) {
            this.lst_TrackYourOrderObjectSectionTitle = lst_TrackYourOrderObjectSectionTitle;
        }

        public List<List<String>> getLst_NameAndLinks() {
            return lst_NameAndLinks;
        }

        public void setLst_NameAndLinks(List<List<String>> lst_NameAndLinks) {
            this.lst_NameAndLinks = lst_NameAndLinks;
        }


    }
    
    public static class LoginUser {
        private String lbl_SignOutMessage;
        private String lbl_RightSideTitleSignInPage;
        private List<String> lst_RightSideSectionSignInPage;
        private String lbl_SignInTitleFromStartPage;
        private String lbl_SignInTitleFromCheckout;
        private String lbl_SignInButtonFromStartPage;
        private String lbl_SignInButtonFromCheckout;
        private String lbl_ErrorMessageForUserName;
        private String lbl_ErrorMessageForPassword;
        private String lbl_ErrorMessageForUserNameAndPassword;

        public String getLbl_SignOutMessage() {            return lbl_SignOutMessage;        }

        public void setLbl_SignOutMessage(String lbl_SignOutMessage) {            this.lbl_SignOutMessage = lbl_SignOutMessage;        }

        public List<String> getLst_RightSideSectionSignInPage() {            return lst_RightSideSectionSignInPage;        }

        public void setLst_RightSideSectionSignInPage(List<String> lst_RightSideSectionSignInPage) {            this.lst_RightSideSectionSignInPage = lst_RightSideSectionSignInPage;        }

        public String getLbl_SignInTitleFromStartPage() {
            return lbl_SignInTitleFromStartPage;
        }

        public void setLbl_SignInTitleFromStartPage(String lbl_SignInTitleFromStartPage) {
            this.lbl_SignInTitleFromStartPage = lbl_SignInTitleFromStartPage;
        }

        public String getLbl_SignInTitleFromCheckout() {
            return lbl_SignInTitleFromCheckout;
        }

        public void setLbl_SignInTitleFromCheckout(String lbl_SignInTitleFromCheckout) {
            this.lbl_SignInTitleFromCheckout = lbl_SignInTitleFromCheckout;
        }

        public String getLbl_SignInButtonFromStartPage() {
            return lbl_SignInButtonFromStartPage;
        }

        public void setLbl_SignInButtonFromStartPage(String lbl_SignInButtonFromStartPage) {
            this.lbl_SignInButtonFromStartPage = lbl_SignInButtonFromStartPage;
        }

        public String getLbl_SignInButtonFromCheckout() {
            return lbl_SignInButtonFromCheckout;
        }

        public void setLbl_SignInButtonFromCheckout(String lbl_SignInButtonFromCheckout) {
            this.lbl_SignInButtonFromCheckout = lbl_SignInButtonFromCheckout;
        }

        public String getLbl_ErrorMessageForUserName() {
            return lbl_ErrorMessageForUserName;
        }

        public void setLbl_ErrorMessageForUserName(String lbl_ErrorMessageForUserName) {
            this.lbl_ErrorMessageForUserName = lbl_ErrorMessageForUserName;
        }

        public String getLbl_ErrorMessageForPassword() {
            return lbl_ErrorMessageForPassword;
        }

        public void setLbl_ErrorMessageForPassword(String lbl_ErrorMessageForPassword) {
            this.lbl_ErrorMessageForPassword = lbl_ErrorMessageForPassword;
        }

        public String getLbl_ErrorMessageForUserNameAndPassword() {
            return lbl_ErrorMessageForUserNameAndPassword;
        }

        public void setLbl_ErrorMessageForUserNameAndPassword(String lbl_ErrorMessageForUserNameAndPassword) {
            this.lbl_ErrorMessageForUserNameAndPassword = lbl_ErrorMessageForUserNameAndPassword;
        }

        public String getLbl_RightSideTitleSignInPage() {
            return lbl_RightSideTitleSignInPage;
        }

        public void setLbl_RightSideTitleSignInPage(String lbl_RightSideTitleSignInPage) {
            this.lbl_RightSideTitleSignInPage = lbl_RightSideTitleSignInPage;
        }
    }

    public static class MyAccount{
        public String lnk_myAccountURL;
        public String lnk_addNewCardURL;
        public List<String> lst_newCreditCardType;
        public List<String> lbl_invalidCardErrorMessage;
        public List<String> lst_giftCardDetails;
        public String lbl_invalidGiftCardNumberErrorMessage;
        public String lbl_invalidGiftCardPinErrorMessage;
        public String lnk_giftCardURL;
        public String lnk_orderStatusURL;
        public String lnk_recentOrderURL;
        public String lnk_orderDetailsURL;
        public String lnk_orderCancellationURL;
        public String lnk_orderReturnsURL;
        public String lbl_orderSearchErrorMessage;
        public String lbl_orderModificationTitle;
        public String lbl_orderReturnsTitle;
        public String lnk_accountSettingsURL;
        public String lnk_accountSettingsChangePasswordURL;
        public String lnk_accountSettingsChangeSecurityQuestionsURL;
        public String lbl_accountSettingsTitle;
        public List<String>  lst_changingPasswordErrorMessage;
        public String lnk_myAccountLandingViewURL;
        public String lnk_URLAfterSignOut;
        public String lbl_shippingAddressTitle;
        public String lnk_myAccountShippingAddressURL;
        public String lbl_addingAddressTitle;
        public String lnk_myAccountAddingAddressURL;
        public String lbl_billingAddressTitle;
        public String lnk_myAccountBillingAddressURL;
        public String lbl_addAddressExistingErrorMessage;
        public String lbl_myFavouriteTitle;
        public String lnk_myAccountFavouritesURL;
        public String lbl_recentlyViewedTitle;
        public String lnk_myAccountRecentlyViewedURL;
        public String lbl_myNewsLettersTitle;
        public String lnk_myAccountNewsLetterURL;
        public String lbl_myNewsLettersSubscriptionSuccessMessage;
        public String lbl_myNewsLettersUpdateErrorMessage;
        public String lbl_myNewsLettersUpdateAlertMessage;
        public String lbl_myNewsLettersUnSubscribeErrorMessage;
        public String lbl_myNewsLettersUnSubscribeAlertMessage;
        public String lbl_noOrderRecordsMessage;
        public String lblOrderDetailsPageUrl;
        public String lblBreadCrumbNavigationPages;

        public String getLblBreadCrumbNavigationPages() {            return lblBreadCrumbNavigationPages;        }

        public void setLblBreadCrumbNavigationPages(String lblBreadCrumbNavigationPages) {            this.lblBreadCrumbNavigationPages = lblBreadCrumbNavigationPages;        }

        public String getLblOrderDetailsPageUrl() {            return lblOrderDetailsPageUrl;        }

        public void setLblOrderDetailsPageUrl(String lblOrderDetailsPageUrl) {            this.lblOrderDetailsPageUrl = lblOrderDetailsPageUrl;        }

        public String getLnk_myAccountURL() {
            return lnk_myAccountURL;
        }

        public void setLnk_myAccountURL(String lnk_myAccountURL) {
            this.lnk_myAccountURL = lnk_myAccountURL;
        }

        public String getLbl_myNewsLettersUpdateErrorMessage() {
            return lbl_myNewsLettersUpdateErrorMessage;
        }

        public void setLbl_myNewsLettersUpdateErrorMessage(String lbl_myNewsLettersUpdateErrorMessage) {
            this.lbl_myNewsLettersUpdateErrorMessage = lbl_myNewsLettersUpdateErrorMessage;
        }

        public String getLbl_myNewsLettersUpdateAlertMessage() {
            return lbl_myNewsLettersUpdateAlertMessage;
        }

        public void setLbl_myNewsLettersUpdateAlertMessage(String lbl_myNewsLettersUpdateAlertMessage) {
            this.lbl_myNewsLettersUpdateAlertMessage = lbl_myNewsLettersUpdateAlertMessage;
        }

        public String getLbl_myNewsLettersUnSubscribeErrorMessage() {
            return lbl_myNewsLettersUnSubscribeErrorMessage;
        }

        public void setLbl_myNewsLettersUnSubscribeErrorMessage(String lbl_myNewsLettersUnSubscribeErrorMessage) {
            this.lbl_myNewsLettersUnSubscribeErrorMessage = lbl_myNewsLettersUnSubscribeErrorMessage;
        }

        public String getLbl_myNewsLettersUnSubscribeAlertMessage() {
            return lbl_myNewsLettersUnSubscribeAlertMessage;
        }

        public void setLbl_myNewsLettersUnSubscribeAlertMessage(String lbl_myNewsLettersUnSubscribeAlertMessage) {
            this.lbl_myNewsLettersUnSubscribeAlertMessage = lbl_myNewsLettersUnSubscribeAlertMessage;
        }

        public String getLnk_addNewCardURL() {            return lnk_addNewCardURL;        }

        public void setLnk_addNewCardURL(String lnk_addNewCardURL) {            this.lnk_addNewCardURL = lnk_addNewCardURL;        }

        public List<String> getLst_newCreditCardType() {            return lst_newCreditCardType;        }

        public void setLst_newCreditCardType(List<String> lst_newCreditCardType) {            this.lst_newCreditCardType = lst_newCreditCardType;        }

        public List<String> getLbl_invalidCardErrorMessage() {            return lbl_invalidCardErrorMessage;        }

        public void setLbl_invalidCardErrorMessage(List<String> lbl_invalidCardErrorMessage) {            this.lbl_invalidCardErrorMessage = lbl_invalidCardErrorMessage;        }

        public List<String> getLst_giftCardDetails() {            return lst_giftCardDetails;        }

        public void setLst_giftCardDetails(List<String> lst_giftCardDetails) {            this.lst_giftCardDetails = lst_giftCardDetails;        }

        public String getLbl_invalidGiftCardNumberErrorMessage() {            return lbl_invalidGiftCardNumberErrorMessage;        }

        public void setLbl_invalidGiftCardNumberErrorMessage(String lbl_invalidGiftCardNumberErrorMessage) {            this.lbl_invalidGiftCardNumberErrorMessage = lbl_invalidGiftCardNumberErrorMessage;        }

        public String getLbl_invalidGiftCardPinErrorMessage() {            return lbl_invalidGiftCardPinErrorMessage;        }

        public void setLbl_invalidGiftCardPinErrorMessage(String lbl_invalidGiftCardPinErrorMessage) {            this.lbl_invalidGiftCardPinErrorMessage = lbl_invalidGiftCardPinErrorMessage;        }

        public String getLnk_giftCardURL() {            return lnk_giftCardURL;        }

        public void setLnk_giftCardURL(String lnk_giftCardURL) {            this.lnk_giftCardURL = lnk_giftCardURL;        }

        public String getLnk_orderStatusURL() {
            return lnk_orderStatusURL;
        }

        public void setLnk_orderStatusURL(String lnk_orderStatusURL) {
            this.lnk_orderStatusURL = lnk_orderStatusURL;
        }

        public String getLnk_recentOrderURL() {
            return lnk_recentOrderURL;
        }

        public void setLnk_recentOrderURL(String lnk_recentOrderURL) {
            this.lnk_recentOrderURL = lnk_recentOrderURL;
        }

        public String getLnk_orderDetailsURL() {
            return lnk_orderDetailsURL;
        }

        public void setLnk_orderDetailsURL(String lnk_orderDetailsURL) {
            this.lnk_orderDetailsURL = lnk_orderDetailsURL;
        }

        public String getLnk_orderCancellationURL() {
            return lnk_orderCancellationURL;
        }

        public void setLnk_orderCancellationURL(String lnk_orderCancellationURL) {
            this.lnk_orderCancellationURL = lnk_orderCancellationURL;
        }

        public String getLnk_orderReturnsURL() {
            return lnk_orderReturnsURL;
        }

        public void setLnk_orderReturnsURL(String lnk_orderReturnsURL) {
            this.lnk_orderReturnsURL = lnk_orderReturnsURL;
        }

        public String getLbl_orderSearchErrorMessage() {
            return lbl_orderSearchErrorMessage;
        }

        public void setLbl_orderSearchErrorMessage(String lbl_orderSearchErrorMessage) {
            this.lbl_orderSearchErrorMessage = lbl_orderSearchErrorMessage;
        }

        public String getLbl_orderModificationTitle() {
            return lbl_orderModificationTitle;
        }

        public void setLbl_orderModificationTitle(String lbl_orderModificationTitle) {
            this.lbl_orderModificationTitle = lbl_orderModificationTitle;
        }

        public String getLbl_orderReturnsTitle() {
            return lbl_orderReturnsTitle;
        }

        public void setLbl_orderReturnsTitle(String lbl_orderReturnsTitle) {
            this.lbl_orderReturnsTitle = lbl_orderReturnsTitle;
        }

        public String getLnk_accountSettingsURL() {
            return lnk_accountSettingsURL;
        }

        public void setLnk_accountSettingsURL(String lnk_accountSettingsURL) {
            this.lnk_accountSettingsURL = lnk_accountSettingsURL;
        }

        public String getLnk_accountSettingsChangePasswordURL() {
            return lnk_accountSettingsChangePasswordURL;
        }

        public void setLnk_accountSettingsChangePasswordURL(String lnk_accountSettingsChangePasswordURL) {
            this.lnk_accountSettingsChangePasswordURL = lnk_accountSettingsChangePasswordURL;
        }

        public String getLnk_accountSettingsChangeSecurityQuestionsURL() {
            return lnk_accountSettingsChangeSecurityQuestionsURL;
        }

        public void setLnk_accountSettingsChangeSecurityQuestionsURL(String lnk_accountSettingsChangeSecurityQuestionsURL) {
            this.lnk_accountSettingsChangeSecurityQuestionsURL = lnk_accountSettingsChangeSecurityQuestionsURL;
        }

        public String getLbl_accountSettingsTitle() {
            return lbl_accountSettingsTitle;
        }

        public void setLbl_accountSettingsTitle(String lbl_accountSettingsTitle) {
            this.lbl_accountSettingsTitle = lbl_accountSettingsTitle;
        }

        public List<String> getLst_changingPasswordErrorMessage() {
            return lst_changingPasswordErrorMessage;
        }

        public void setLst_changingPasswordErrorMessage(List<String> lst_changingPasswordErrorMessage) {
            this.lst_changingPasswordErrorMessage = lst_changingPasswordErrorMessage;
        }

        public String getLnk_myAccountLandingViewURL() {
            return lnk_myAccountLandingViewURL;
        }

        public void setLnk_myAccountLandingViewURL(String lnk_myAccountLandingViewURL) {
            this.lnk_myAccountLandingViewURL = lnk_myAccountLandingViewURL;
        }

        public String getLnk_URLAfterSignOut() {
            return lnk_URLAfterSignOut;
        }

        public void setLnk_URLAfterSignOut(String lnk_URLAfterSignOut) {
            this.lnk_URLAfterSignOut = lnk_URLAfterSignOut;
        }

        public String getLbl_shippingAddressTitle() {
            return lbl_shippingAddressTitle;
        }

        public void setLbl_shippingAddressTitle(String lbl_shippingAddressTitle) {
            this.lbl_shippingAddressTitle = lbl_shippingAddressTitle;
        }

        public String getLnk_myAccountShippingAddressURL() {
            return lnk_myAccountShippingAddressURL;
        }

        public void setLnk_myAccountShippingAddressURL(String lnk_myAccountShippingAddressURL) {
            this.lnk_myAccountShippingAddressURL = lnk_myAccountShippingAddressURL;
        }

        public String getLbl_addingAddressTitle() {
            return lbl_addingAddressTitle;
        }

        public void setLbl_addingAddressTitle(String lbl_addingAddressTitle) {
            this.lbl_addingAddressTitle = lbl_addingAddressTitle;
        }

        public String getLnk_myAccountAddingAddressURL() {
            return lnk_myAccountAddingAddressURL;
        }

        public void setLnk_myAccountAddingAddressURL(String lnk_myAccountAddingAddressURL) {
            this.lnk_myAccountAddingAddressURL = lnk_myAccountAddingAddressURL;
        }

        public String getLbl_billingAddressTitle() {
            return lbl_billingAddressTitle;
        }

        public void setLbl_billingAddressTitle(String lbl_billingAddressTitle) {
            this.lbl_billingAddressTitle = lbl_billingAddressTitle;
        }

        public String getLnk_myAccountBillingAddressURL() {
            return lnk_myAccountBillingAddressURL;
        }

        public void setLnk_myAccountBillingAddressURL(String lnk_myAccountBillingAddressURL) {
            this.lnk_myAccountBillingAddressURL = lnk_myAccountBillingAddressURL;
        }

        public String getLbl_addAddressExistingErrorMessage() {
            return lbl_addAddressExistingErrorMessage;
        }

        public void setLbl_addAddressExistingErrorMessage(String lbl_addAddressExistingErrorMessage) {
            this.lbl_addAddressExistingErrorMessage = lbl_addAddressExistingErrorMessage;
        }

        public String getLbl_myFavouriteTitle() {
            return lbl_myFavouriteTitle;
        }

        public void setLbl_myFavouriteTitle(String lbl_myFavouriteTitle) {
            this.lbl_myFavouriteTitle = lbl_myFavouriteTitle;
        }

        public String getLnk_myAccountFavouritesURL() {
            return lnk_myAccountFavouritesURL;
        }

        public void setLnk_myAccountFavouritesURL(String lnk_myAccountFavouritesURL) {
            this.lnk_myAccountFavouritesURL = lnk_myAccountFavouritesURL;
        }

        public String getLbl_recentlyViewedTitle() {
            return lbl_recentlyViewedTitle;
        }

        public void setLbl_recentlyViewedTitle(String lbl_recentlyViewedTitle) {
            this.lbl_recentlyViewedTitle = lbl_recentlyViewedTitle;
        }

        public String getLnk_myAccountRecentlyViewedURL() {
            return lnk_myAccountRecentlyViewedURL;
        }

        public void setLnk_myAccountRecentlyViewedURL(String lnk_myAccountRecentlyViewedURL) {
            this.lnk_myAccountRecentlyViewedURL = lnk_myAccountRecentlyViewedURL;
        }

        public String getLbl_myNewsLettersTitle() {
            return lbl_myNewsLettersTitle;
        }

        public void setLbl_myNewsLettersTitle(String lbl_myNewsLettersTitle) {
            this.lbl_myNewsLettersTitle = lbl_myNewsLettersTitle;
        }

        public String getLnk_myAccountNewsLetterURL() {
            return lnk_myAccountNewsLetterURL;
        }

        public void setLnk_myAccountNewsLetterURL(String lnk_myAccountNewsLetterURL) {
            this.lnk_myAccountNewsLetterURL = lnk_myAccountNewsLetterURL;
        }

        public String getLbl_myNewsLettersSubscriptionSuccessMessage() {
            return lbl_myNewsLettersSubscriptionSuccessMessage;
        }

        public void setLbl_myNewsLettersSubscriptionSuccessMessage(String lbl_myNewsLettersSubscriptionSuccessMessage) {
            this.lbl_myNewsLettersSubscriptionSuccessMessage = lbl_myNewsLettersSubscriptionSuccessMessage;
        }

        public String getLbl_noOrderRecordsMessage() {
            return lbl_noOrderRecordsMessage;
        }

        public void setLbl_noOrderRecordsMessage(String lbl_noOrderRecordsMessage) {
            this.lbl_noOrderRecordsMessage = lbl_noOrderRecordsMessage;
        }
    }

    public static class ShoppingCart{
        List<Map<String,String>> lst_SearchKeywords;
        String lblOrderExceedingQuantityMessage;
        String lblProductNumberForOrderExceedingQuantity;
        String lblCartExceedingLimitMessage;
        String lblJayCareFoundationDonationMessage;

        public String getLblJayCareFoundationDonationMessage() {            return lblJayCareFoundationDonationMessage;        }

        public void setLblJayCareFoundationDonationMessage(String lblJayCareFoundationDonationMessage) {
            this.lblJayCareFoundationDonationMessage = lblJayCareFoundationDonationMessage;
        }

        public List<Map<String, String>> getLst_SearchKeywords() {
            return lst_SearchKeywords;
        }

        public void setLst_SearchKeywords(List<Map<String, String>> lst_SearchKeywords) {
            this.lst_SearchKeywords = lst_SearchKeywords;
        }

        public String getLblOrderExceedingQuantityMessage() {
            return lblOrderExceedingQuantityMessage;
        }

        public void setLblOrderExceedingQuantityMessage(String lblOrderExceedingQuantityMessage) {
            this.lblOrderExceedingQuantityMessage = lblOrderExceedingQuantityMessage;
        }

        public String getLblProductNumberForOrderExceedingQuantity() {
            return lblProductNumberForOrderExceedingQuantity;
        }

        public void setLblProductNumberForOrderExceedingQuantity(String lblProductNumberForOrderExceedingQuantity) {
            this.lblProductNumberForOrderExceedingQuantity = lblProductNumberForOrderExceedingQuantity;
        }

        public String getLblCartExceedingLimitMessage() {
            return lblCartExceedingLimitMessage;
        }

        public void setLblCartExceedingLimitMessage(String lblCartExceedingLimitMessage) {
            this.lblCartExceedingLimitMessage = lblCartExceedingLimitMessage;
        }
    }

    public static class Checkout{
        List<Map<String,String>> lst_SearchKeywords;
        List<Map<String,String>> lstOrderDetailItems;
        List<String> addShippingAddressErrorMessage;
        String lblProductNumberWithMultipleShippingMethods;
        List<Map<String,String>> newShippingAddressForUser;
        String lblBillingAddress;
        String lblExistingAddressErrorMessage;
        String lblGiftCardPromoteErrorMessageForEasyPayment;
        List<String> lst_PromoteCode;
        List<Map<String,String>> lst_GiftCard;
        String lblPaymentMethodErrorMessage;
        List<List<String>> lstPaymentMethodCardAdditionErrorMessage;
        String lblInvalidCreditCardNumber;
        List<String> lstInvalidPromoteCodeAndErrorMessage;
        List<String> lstInvalidGiftCardAndErrorMessage;
        String lblEmptyGiftCardPinErrorMessage;
        String lblPromoteCodeAppliedMessage;
        String lblGiftCardAppliedMessage;
        List<String> lstShippingAddressErrorMessageForGuestCheckout;
        List<String> lst_SearchingKeywordForPlaceOrder;

        public List<String> getLst_SearchingKeywordForPlaceOrder() {
            return lst_SearchingKeywordForPlaceOrder;
        }

        public void setLst_SearchingKeywordForPlaceOrder(List<String> lst_SearchingKeywordForPlaceOrder) {
            this.lst_SearchingKeywordForPlaceOrder = lst_SearchingKeywordForPlaceOrder;
        }

        public List<String> getLstShippingAddressErrorMessageForGuestCheckout() {
            return lstShippingAddressErrorMessageForGuestCheckout;
        }

        public void setLstShippingAddressErrorMessageForGuestCheckout(List<String> lstShippingAddressErrorMessageForGuestCheckout) {
            this.lstShippingAddressErrorMessageForGuestCheckout = lstShippingAddressErrorMessageForGuestCheckout;
        }

        public List<Map<String, String>> getLstOrderDetailItems() {            return lstOrderDetailItems;        }

        public void setLstOrderDetailItems(List<Map<String, String>> lstOrderDetailItems) {            this.lstOrderDetailItems = lstOrderDetailItems;        }

        public String getLblPromoteCodeAppliedMessage() {
            return lblPromoteCodeAppliedMessage;
        }

        public void setLblPromoteCodeAppliedMessage(String lblPromoteCodeAppliedMessage) {
            this.lblPromoteCodeAppliedMessage = lblPromoteCodeAppliedMessage;
        }

        public String getLblGiftCardAppliedMessage() {
            return lblGiftCardAppliedMessage;
        }

        public void setLblGiftCardAppliedMessage(String lblGiftCardAppliedMessage) {
            this.lblGiftCardAppliedMessage = lblGiftCardAppliedMessage;
        }

        public List<String> getLstInvalidPromoteCodeAndErrorMessage() {
            return lstInvalidPromoteCodeAndErrorMessage;
        }

        public void setLstInvalidPromoteCodeAndErrorMessage(List<String> lstInvalidPromoteCodeAndErrorMessage) {
            this.lstInvalidPromoteCodeAndErrorMessage = lstInvalidPromoteCodeAndErrorMessage;
        }

        public List<String> getLstInvalidGiftCardAndErrorMessage() {
            return lstInvalidGiftCardAndErrorMessage;
        }

        public void setLstInvalidGiftCardAndErrorMessage(List<String> lstInvalidGiftCardAndErrorMessage) {
            this.lstInvalidGiftCardAndErrorMessage = lstInvalidGiftCardAndErrorMessage;
        }

        public String getLblEmptyGiftCardPinErrorMessage() {
            return lblEmptyGiftCardPinErrorMessage;
        }

        public void setLblEmptyGiftCardPinErrorMessage(String lblEmptyGiftCardPinErrorMessage) {
            this.lblEmptyGiftCardPinErrorMessage = lblEmptyGiftCardPinErrorMessage;
        }

        public List<String> getLst_PromoteCode() {
            return lst_PromoteCode;
        }

        public void setLst_PromoteCode(List<String> lst_PromoteCode) {
            this.lst_PromoteCode = lst_PromoteCode;
        }

        public List<Map<String, String>> getLst_GiftCard() {
            return lst_GiftCard;
        }

        public void setLst_GiftCard(List<Map<String, String>> lst_GiftCard) {
            this.lst_GiftCard = lst_GiftCard;
        }

        public String getLblGiftCardPromoteErrorMessageForEasyPayment() {
            return lblGiftCardPromoteErrorMessageForEasyPayment;
        }

        public void setLblGiftCardPromoteErrorMessageForEasyPayment(String lblGiftCardPromoteErrorMessageForEasyPayment) {
            this.lblGiftCardPromoteErrorMessageForEasyPayment = lblGiftCardPromoteErrorMessageForEasyPayment;
        }

        public String getLblInvalidCreditCardNumber() {            return lblInvalidCreditCardNumber;        }

        public void setLblInvalidCreditCardNumber(String lblInvalidCreditCardNumber) {            this.lblInvalidCreditCardNumber = lblInvalidCreditCardNumber;        }

        public List<List<String>> getLstPaymentMethodCardAdditionErrorMessage() {            return lstPaymentMethodCardAdditionErrorMessage;        }

        public void setLstPaymentMethodCardAdditionErrorMessage(List<List<String>> lstPaymentMethodCardAdditionErrorMessage) {            this.lstPaymentMethodCardAdditionErrorMessage = lstPaymentMethodCardAdditionErrorMessage;        }

        public String getLblPaymentMethodErrorMessage() {            return lblPaymentMethodErrorMessage;        }

        public void setLblPaymentMethodErrorMessage(String lblPaymentMethodErrorMessage) {            this.lblPaymentMethodErrorMessage = lblPaymentMethodErrorMessage;        }

        public String getLblExistingAddressErrorMessage() {            return lblExistingAddressErrorMessage;        }

        public void setLblExistingAddressErrorMessage(String lblExistingAddressErrorMessage) {            this.lblExistingAddressErrorMessage = lblExistingAddressErrorMessage;        }

        public String getLblBillingAddress() {            return lblBillingAddress;        }

        public void setLblBillingAddress(String lblBillingAddress) {            this.lblBillingAddress = lblBillingAddress;        }

        public List<Map<String, String>> getLst_SearchKeywords() {            return lst_SearchKeywords;        }

        public void setLst_SearchKeywords(List<Map<String, String>> lst_SearchKeywords) {            this.lst_SearchKeywords = lst_SearchKeywords;        }

        public List<String> getAddShippingAddressErrorMessage() {            return addShippingAddressErrorMessage;        }

        public void setAddShippingAddressErrorMessage(List<String> addShippingAddressErrorMessage) {            this.addShippingAddressErrorMessage = addShippingAddressErrorMessage;        }

        public String getLblProductNumberWithMultipleShippingMethods() {
            return lblProductNumberWithMultipleShippingMethods;
        }

        public void setLblProductNumberWithMultipleShippingMethods(String lblProductNumberWithMultipleShippingMethods) {
            this.lblProductNumberWithMultipleShippingMethods = lblProductNumberWithMultipleShippingMethods;
        }

        public List<Map<String, String>> getNewShippingAddressForUser() {            return newShippingAddressForUser;        }

        public void setNewShippingAddressForUser(List<Map<String, String>> newShippingAddressForUser) {            this.newShippingAddressForUser = newShippingAddressForUser;        }
    }

}

