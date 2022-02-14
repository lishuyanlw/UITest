package com.tsc.data.pojos;


import java.util.List;
import java.util.Map;

public class ConstantData {
    public HeaderSection headerSection;
    public HomePage homePage;
    public SearchResultPage searchResultPage;
    public FooterSection footerSection;
    public LoginUser loginUser;

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
        private String lbl_SoldOutkeyword;
        private String lbl_QuantityNumberToShowLeftItemInfo;
        private List<String> lst_WriteReviewSubmitMessage;
        private String lbl_TellYourFriendsSentMessage;
        private List<String> lst_Filter_Data;
        private List<String> lst_SortOptionMobile;
        private String lbl_ProductNumberWithBandAndReviewAndSeeMore;
        private List<String> lst_SearchKeyword_Bugs;
        private String lbl_ProductNumberToComparePRPAndPDPContent;

        public List<String> getLst_ClearanceKeyword() {
            return lst_ClearanceKeyword;
        }

        public void setLst_ClearanceKeyword(List<String> lst_ClearanceKeyword) {
            this.lst_ClearanceKeyword = lst_ClearanceKeyword;
        }

        private List<String> lst_ClearanceKeyword;


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
        private String lbl_Username;
        private String lbl_Password;
        private String lbl_FirstName;
        
        public String getLbl_Username() {
            return lbl_Username;
        }

        public void setLbl_Username(String lbl_Username) {
            this.lbl_Username = lbl_Username;
        }
        
        public String getLbl_Password() {
            return lbl_Password;
        }

        public void setLbl_Password(String lbl_Password) {
            this.lbl_Password = lbl_Password;
        }
        
        public String getLbl_FirstName() {
            return lbl_FirstName;
        }

        public void setLbl_FirstName(String lbl_FirstName) {
            this.lbl_FirstName = lbl_FirstName;
        }

    }

}

