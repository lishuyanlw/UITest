package com.tsc.data.pojos;

import java.util.List;

public class ConstantDataFile {
    public HeaderSection headerSection;
    public HomePage homePage;
    public SearchResultPage searchResultPage;
    public FooterSection footerSection;

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
        private String lbl_SignIn;
        private String lbl_SearchBoxPlaceholder;
        private String lbl_MinicartLinkName;
        private String lnk_MinicarLink;
        private Flyout flyout;

        public String getLbl_MinicartLinkName() {
            return lbl_MinicartLinkName;
        }

        public void setLbl_MinicartLinkName(String lbl_MinicartLinkName) {
            this.lbl_MinicartLinkName = lbl_MinicartLinkName;
        }

        public String getLnk_MinicarLink() {
            return lnk_MinicarLink;
        }

        public void setLnk_MinicarLink(String lnk_MinicarLink) {
            this.lnk_MinicarLink = lnk_MinicarLink;
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

        public String getLbl_SignIn() {
            return lbl_SignIn;
        }

        public void setLbl_SignIn(String lbl_SignIn) {
            this.lbl_SignIn = lbl_SignIn;
        }

        public String getLbl_SearchBoxPlaceholder() {
            return lbl_SearchBoxPlaceholder;
        }

        public void setLbl_SearchBoxPlaceholder(String lbl_SearchBoxPlaceholder) {
            this.lbl_SearchBoxPlaceholder = lbl_SearchBoxPlaceholder;
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
        private String lbl_SearchResultPageDefaultSetting;
        private List<List<String>> lst_SearchResultMessage;
        private List<String> lst_SortOption;
        private List<String> lst_FilterOptionHeader;
        private List<SearchOption> lst_SearchOption;               
        private List<String> lst_MoreButton;  
        private List<String> lst_DisappearAfterSelectFilter;

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

        public String getLbl_SearchResultPageDefaultSetting() {
            return lbl_SearchResultPageDefaultSetting;
        }

        public void setLbl_SearchResultPageDefaultSetting(String lbl_SearchResultPageDefaultSetting) {
            this.lbl_SearchResultPageDefaultSetting = lbl_SearchResultPageDefaultSetting;
        }

        public List<List<String>> getLst_SearchResultMessage() {
            return lst_SearchResultMessage;
        }

        public void setLst_SearchResultMessage(List<List<String>> lst_SearchResultMessage) {
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
    }

    public static class Flyout {
        private List<String> lst_FlyoutHeading;
        private String lbl_FlyoutHeadingLandingPageLink;
        private List<String> lnk_FlyoutHeaderLinkConstant;

        public String getLbl_FlyoutHeadingLandingPageLink() {
            return lbl_FlyoutHeadingLandingPageLink;
        }

        public void setLbl_FlyoutHeadingLandingPageLink(String lbl_FlyoutHeadingLandingPageLink) {
            this.lbl_FlyoutHeadingLandingPageLink = lbl_FlyoutHeadingLandingPageLink;
        }

        public List<String> getLst_FlyoutHeading() {
            return lst_FlyoutHeading;
        }

        public void setLst_FlyoutHeading(List<String> lst_FlyoutHeading) {
            this.lst_FlyoutHeading = lst_FlyoutHeading;
        }

        public List<String> getLnk_FlyoutHeaderLinkConstant() {
            return lnk_FlyoutHeaderLinkConstant;
        }

        public void setLnk_FlyoutHeaderLinkConstant(List<String> lnk_FlyoutHeaderLinkConstant) {
            this.lnk_FlyoutHeaderLinkConstant = lnk_FlyoutHeaderLinkConstant;
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

        public List<String> getLst_SocialMediaLinks() {
            return lst_SocialMediaLinks;
        }

        public void setLst_SocialMediaLinks(List<String> lst_SocialMediaLinks) {
            this.lst_SocialMediaLinks = lst_SocialMediaLinks;
        }

        public List<List<String>> getLst_NameAndLinks() {
            return lst_NameAndLinks;
        }

        public void setLst_NameAndLinks(List<List<String>> lst_NameAndLinks) {
            this.lst_NameAndLinks = lst_NameAndLinks;
        }

    }

}


