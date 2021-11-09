package com.tsc.data.pojos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class ConstantData {
	
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
	private List<String> lst_SignInPopover;
	private String lbl_SearchBoxPlaceholder;
	private String lbl_ShoppingCartLinkName;
	private String lnk_ShoppingCartLink;
	private List<String> lst_FlyoutHeading;
	private List<String> lnk_FlyoutHeaderLinkConstant;
	private String lbl_FlyoutHeadingLandingPageLink;
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
	private List<String> lst_SearchKeyword;	
	private List<List<String>> lst_SearchKeyword_DropDown;	
	private String lbl_SearchResultPageDefaultSetting;
	private List<String>  lst_SearchResultMessage;
	private List<String> lst_SortOption;	
	private List<List<String>> lst_FilterByPrice;
	private List<String> lst_FilterOptionHeader;
	private List<List<String>> lst_GeneralTwoLevelFilterOption;
	private List<List<List<String>>> lst_FilterCombination;
	private List<String> lst_MoreButton;
	private List<List<List<String>>> lst_FilterSequentialAction;
	private List<String> lst_SocialMediaLinks;
	private List<List<String>> lst_SpecialOffers;
	private List<List<String>> lst_NameAndLinks;
	private String lbl_Username;
	private String lbl_Password;
	private String lbl_FirstName;	
	private List<String> lst_DisappearAfterSelectFilter;
	private String lnk_product_result;
	private List<String> lst_MyAccountObjectSectionTitle;
	private List<String> lst_TrackYourOrderObjectSectionTitle;

	//Header Links getter and setter method
	
	/**
	 * @return the lnk_NotFound
	 */
	public String getlnk_NotFound() {
		return lnk_NotFound;
	}
	/**
	 * @param lnk_NotFound the lnk_NotFound to set
	 */
	public void setlnk_NotFound(String lnk_NotFound) {
		this.lnk_NotFound = lnk_NotFound;
	}

	/**
	 * @return the lbl_TodaysShowstopper
	 */
	public String getlbl_TodaysShowstopper() {
		return lbl_TodaysShowstopper;
	}
	/**
	 * @param lbl_TodaysShowstopper the lbl_TodaysShowstopper to set
	 */
	public void setlbl_TodaysShowstopper(String lbl_TodaysShowstopper) {
		this.lbl_TodaysShowstopper = lbl_TodaysShowstopper;
	}

	/**
	 * @return the lnk_TodaysShowstopper
	 */
	public String getlnk_TodaysShowstopper() {
		return lnk_TodaysShowstopper;
	}
	/**
	 * @param lnk_TodaysShowstopper the lnk_TodaysShowstopper to set
	 */
	public void setlnk_TodaysShowstopper(String lnk_TodaysShowstopper) {
		this.lnk_TodaysShowstopper = lnk_TodaysShowstopper;
	}

	/**
	 * @return the lbl_Deals_English
	 */
	public String getlbl_Deals_English() {
		return lbl_Deals_English;
	}
	/**
	 * @param lbl_Deals_English the lbl_Deals_English to set
	 */
	public void setlbl_Deals_English(String lbl_Deals_English) {
		this.lbl_Deals_English = lbl_Deals_English;
	}

	/**
	 * @return the lbl_Deals_French
	 */
	public String getlbl_Deals_French() {
		return lbl_Deals_French;
	}
	/**
	 * @param lbl_Deals_French the lbl_Deals_French to set
	 */
	public void setlbl_Deals_French(String lbl_Deals_French) {
		this.lbl_Deals_French = lbl_Deals_French;
	}

	/**
	 * @return the lnk_Deals
	 */
	public String getlnk_Deals() {
		return lnk_Deals;
	}
	/**
	 * @param lnk_Deals the lnk_Deals to set
	 */
	public void setlnk_Deals(String lnk_Deals) {
		this.lnk_Deals = lnk_Deals;
	}

	/**
	 * @return the lbl_OnAirProducts_English
	 */
	public String getlbl_OnAirProducts_English() {
		return lbl_OnAirProducts_English;
	}
	/**
	 * @param lbl_OnAirProducts_English the lbl_OnAirProducts_English to set
	 */
	public void setlbl_OnAirProducts_English(String lbl_OnAirProducts_English) {
		this.lbl_OnAirProducts_English = lbl_OnAirProducts_English;
	}

	/**
	 * @return the lbl_OnAirProducts_EnglishMobile
	 */
	public String getlbl_OnAirProducts_EnglishMobile() {
		return lbl_OnAirProducts_EnglishMobile;
	}
	/**
	 * @param lbl_OnAirProducts_EnglishMobile the lbl_OnAirProducts_EnglishMobile to set
	 */
	public void setlbl_OnAirProducts_EnglishMobile(String lbl_OnAirProducts_EnglishMobile) {
		this.lbl_OnAirProducts_EnglishMobile = lbl_OnAirProducts_EnglishMobile;
	}

	/**
	 * @return the lbl_OnAirProducts_French
	 */
	public String getlbl_OnAirProducts_French() {
		return lbl_OnAirProducts_French;
	}
	/**
	 * @param lbl_OnAirProducts_French the lbl_OnAirProducts_French to set
	 */
	public void setlbl_OnAirProducts_French(String lbl_OnAirProducts_French) {
		this.lbl_OnAirProducts_French = lbl_OnAirProducts_French;
	}

	/**
	 * @return the lnk_OnAirProducts
	 */
	public String getlnk_OnAirProducts() {
		return lnk_OnAirProducts;
	}
	/**
	 * @param lnk_OnAirProducts the lnk_OnAirProducts to set
	 */
	public void setlnk_OnAirProducts(String lnk_OnAirProducts) {
		this.lnk_OnAirProducts = lnk_OnAirProducts;
	}

	/**
	 * @return the lnk_OnAirProductIcon_MOBILE
	 */
	public String getlnk_OnAirProductIcon_MOBILE() {
		return lnk_OnAirProductIcon_MOBILE;
	}
	/**
	 * @param lnk_OnAirProductIcon_MOBILE the lnk_OnAirProductIcon_MOBILE to set
	 */
	public void setlnk_OnAirProductIcon_MOBILE(String lnk_OnAirProductIcon_MOBILE) {
		this.lnk_OnAirProductIcon_MOBILE = lnk_OnAirProductIcon_MOBILE;
	}

	/**
	 * @return the lbl_ProgramGuide_English
	 */
	public String getlbl_ProgramGuide_English() {
		return lbl_ProgramGuide_English;
	}
	/**
	 * @param lbl_ProgramGuide_English the lbl_ProgramGuide_English to set
	 */
	public void setlbl_ProgramGuide_English(String lbl_ProgramGuide_English) {
		this.lbl_ProgramGuide_English = lbl_ProgramGuide_English;
	}

	/**
	 * @return the lbl_ProgramGuide_French
	 */
	public String getlbl_ProgramGuide_French() {
		return lbl_ProgramGuide_French;
	}
	/**
	 * @param lbl_ProgramGuide_French the lbl_ProgramGuide_French to set
	 */
	public void setlbl_ProgramGuide_French(String lbl_ProgramGuide_French) {
		this.lbl_ProgramGuide_French = lbl_ProgramGuide_French;
	}

	/**
	 * @return the lnk_ProgramGuide
	 */
	public String getlnk_ProgramGuide() {
		return lnk_ProgramGuide;
	}
	/**
	 * @param lnk_ProgramGuide the lnk_ProgramGuide to set
	 */
	public void setlnk_ProgramGuide(String lnk_ProgramGuide) {
		this.lnk_ProgramGuide = lnk_ProgramGuide;
	}

	/**
	 * @return the lnk_ProgramGuideRedirect
	 */
	public String getlnk_ProgramGuideRedirect() {
		return lnk_ProgramGuideRedirect;
	}
	/**
	 * @param lnk_ProgramGuideRedirect the lnk_ProgramGuideRedirect to set
	 */
	public void setlnk_ProgramGuideRedirect(String lnk_ProgramGuideRedirect) {
		this.lnk_ProgramGuideRedirect = lnk_ProgramGuideRedirect;
	}

	/**
	 * @return the lbl_WatchUsLive_English
	 */
	public String getlbl_WatchUsLive_English() {
		return lbl_WatchUsLive_English;
	}
	/**
	 * @param lbl_WatchUsLive_English the lbl_WatchUsLive_English to set
	 */
	public void setlbl_WatchUsLive_English(String lbl_WatchUsLive_English) {
		this.lbl_WatchUsLive_English = lbl_WatchUsLive_English;
	}

	/**
	 * @return the lbl_WatchUsLive_French
	 */
	public String getlbl_WatchUsLive_French() {
		return lbl_WatchUsLive_French;
	}
	/**
	 * @param lbl_WatchUsLive_French the lbl_WatchUsLive_French to set
	 */
	public void setlbl_WatchUsLive_French(String lbl_WatchUsLive_French) {
		this.lbl_WatchUsLive_French = lbl_WatchUsLive_French;
	}

	/**
	 * @return the lnk_WatchUsLive
	 */
	public String getlnk_WatchUsLive() {
		return lnk_WatchUsLive;
	}
	/**
	 * @param lnk_WatchUsLive the lnk_WatchUsLive to set
	 */
	public void setlnk_WatchUsLive(String lnk_WatchUsLive) {
		this.lnk_WatchUsLive = lnk_WatchUsLive;
	}
		
	/**
	 * @return the lbl_Favourites
	 */
	public String getlbl_Favourites() {
		return lbl_Favourites;
	}
	/**
	 * @param lbl_Favourites the lbl_Favourites to set
	 */
	public void setlbl_Favourites(String lbl_Favourites) {
		this.lbl_Favourites = lbl_Favourites;
	}
	
	/**
	 * @return the lbl_SignIn
	 */
	public String getlbl_SignIn() {
		return lbl_SignIn;
	}
	/**
	 * @param lbl_SignIn the lbl_SignIn to set
	 */
	public void setlbl_SignIn(String lbl_SignIn) {
		this.lbl_SignIn = lbl_SignIn;
	}
	
	/**
	 * @return the lst_SignInPopover
	 */
	public List<String> getlst_SignInPopover() {
		return lst_SignInPopover;
	}
	/**
	 * @param lst_SignInPopover the lst_SignInPopover to set
	 */
	public void setlst_SignInPopover(List<String> lst_SignInPopover) {
		this.lst_SignInPopover = lst_SignInPopover;
	}
	
	/**
	 * @return the lbl_SearchBoxPlaceholder
	 */
	public String getlbl_SearchBoxPlaceholder() {
		return lbl_SearchBoxPlaceholder;
	}
	/**
	 * @param lbl_SearchBoxPlaceholder the lbl_SearchBoxPlaceholder to set
	 */
	public void setlbl_SearchBoxPlaceholder(String lbl_SearchBoxPlaceholder) {
		this.lbl_SearchBoxPlaceholder = lbl_SearchBoxPlaceholder;
	}
	
	/**
	 * @return the lnk_ShoppingCartLink
	 */
	public String getlnk_ShoppingCartLink() {
		return lnk_ShoppingCartLink;
	}
	/**
	 * @param lnk_ShoppingCartLink the lnk_ShoppingCartLink to set
	 */
	public void setlnk_ShoppingCartLink(String lnk_ShoppingCartLink) {
		this.lnk_ShoppingCartLink = lnk_ShoppingCartLink;
	}
	
	/**
	 * @return the lbl_ShoppingCartLinkName
	 */
	public String getlbl_ShoppingCartLinkName() {
		return lbl_ShoppingCartLinkName;
	}
	/**
	 * @param lbl_ShoppingCartLinkName the lbl_ShoppingCartLinkName to set
	 */
	public void setlbl_ShoppingCartLinkName(String lbl_ShoppingCartLinkName) {
		this.lbl_ShoppingCartLinkName = lbl_ShoppingCartLinkName;
	}
	/**
	 * @return the lbl_MinicartLinkName
	 */
	public String getlbl_FlyoutHeadingLandingPageLink() {
		return lbl_FlyoutHeadingLandingPageLink;
	}
	/**
	 * @param lbl_FlyoutHeadingLandingPageLink the lbl_FlyoutHeadingLandingPageLink to set
	 */
	public void setlbl_FlyoutHeadingLandingPageLink(String lbl_FlyoutHeadingLandingPageLink) {
		this.lbl_FlyoutHeadingLandingPageLink = lbl_FlyoutHeadingLandingPageLink;
	}
	/**
	 * @return the lst_FlyoutHeading
	 */
	public List<String> getlst_FlyoutHeading() {
		return lst_FlyoutHeading;
	}
	/**
	 * @param lst_FlyoutHeading the lst_FlyoutHeading to set
	 */
	public void setlst_FlyoutHeading(List<String> lst_FlyoutHeading) {
		this.lst_FlyoutHeading = lst_FlyoutHeading;
	}
	
	/**
	 * @return the lnk_FlyoutHeaderLinkConstant
	 */
	public List<String> getlnk_FlyoutHeaderLinkConstant() {
		return lnk_FlyoutHeaderLinkConstant;
	}
	/**
	 * @param lnk_FlyoutHeaderLinkConstant the lnk_FlyoutHeaderLinkConstant to set
	 */
	public void setlnk_FlyoutHeaderLinkConstant(List<String> lnk_FlyoutHeaderLinkConstant) {
		this.lnk_FlyoutHeaderLinkConstant = lnk_FlyoutHeaderLinkConstant;
}
	/**
	 * @return the lbl_OnAirNow
	 */
	public String getlbl_OnAirNow() {
		return lbl_OnAirNow;
	}
	/**
	 * @param lbl_OnAirNow the lbl_OnAirNow to set
	 */
	public void setlbl_OnAirNow(String lbl_OnAirNow) {
		this.lbl_OnAirNow = lbl_OnAirNow;
	}

	/**
	 * @return the lbl_RecentlyAir
	 */
	public String getlbl_RecentlyAir() {
		return lbl_RecentlyAir;
	}
	/**
	 * @param lbl_RecentlyAir the lbl_RecentlyAir to set
	 */
	public void setlbl_RecentlyAir(String lbl_RecentlyAir) {
		this.lbl_RecentlyAir = lbl_RecentlyAir;
	}

	/**
	 * @return the lnk_RecentlyAir
	 */
	public String getlnk_RecentlyAir() {
		return lnk_RecentlyAir;
	}
	/**
	 * @param lnk_RecentlyAir the lnk_RecentlyAir to set
	 */
	public void setlnk_RecentlyAir(String lnk_RecentlyAir) {
		this.lnk_RecentlyAir = lnk_RecentlyAir;
	}

	/**
	 * @return the lnk_RecentlyAirShopAllItems
	 */
	public String getlnk_RecentlyAirShopAllItems() {
		return lnk_RecentlyAirShopAllItems;
	}
	/**
	 * @param lnk_RecentlyAirShopAllItems the lnk_RecentlyAirShopAllItems to set
	 */
	public void setlnk_RecentlyAirShopAllItems(String lnk_RecentlyAirShopAllItems) {
		this.lnk_RecentlyAirShopAllItems = lnk_RecentlyAirShopAllItems;
	}

	/**
	 * @return the txt_RecentlyAirShopAllItems
	 */
	public String gettxt_RecentlyAirShopAllItems() {
		return txt_RecentlyAirShopAllItems;
	}
	/**
	 * @param txt_RecentlyAirShopAllItems the txt_RecentlyAirShopAllItems to set
	 */
	public void settxt_RecentlyAirShopAllItems(String txt_RecentlyAirShopAllItems) {
		this.txt_RecentlyAirShopAllItems = txt_RecentlyAirShopAllItems;
	}

	/**
	 * @return the lbl_ShopByBrand
	 */
	public String getlbl_ShopByBrand() {
		return lbl_ShopByBrand;
	}
	/**
	 * @param lbl_ShopByBrand the lbl_ShopByBrand to set
	 */
	public void setlbl_ShopByBrand(String lbl_ShopByBrand) {
		this.lbl_ShopByBrand = lbl_ShopByBrand;
	}

	/**
	 * @return the lbl_ShopByBrandViewAll
	 */
	public String getlbl_ShopByBrandViewAll() {
		return lbl_ShopByBrandViewAll;
	}
	/**
	 * @param lbl_ShopByBrandViewAll the lbl_ShopByBrandViewAll to set
	 */
	public void setlbl_ShopByBrandViewAll(String lbl_ShopByBrandViewAll) {
		this.lbl_ShopByBrandViewAll = lbl_ShopByBrandViewAll;
	}

	/**
	 * @return the lnk_ShopByBrandViewAll
	 */
	public String getlnk_ShopByBrandViewAll() {
		return lnk_ShopByBrandViewAll;
	}
	/**
	 * @param lnk_ShopByBrandViewAll the lnk_ShopByBrandViewAll to set
	 */
	public void setlnk_ShopByBrandViewAll(String lnk_ShopByBrandViewAll) {
		this.lnk_ShopByBrandViewAll = lnk_ShopByBrandViewAll;
	}

	/**
	 * @return the lbl_ShopByDepartment
	 */
	public String getlbl_ShopByDepartment() {
		return lbl_ShopByDepartment;
	}
	/**
	 * @param lbl_ShopByDepartment the lbl_ShopByDepartment to set
	 */
	public void setlbl_ShopByDepartment(String lbl_ShopByDepartment) {
		this.lbl_ShopByDepartment = lbl_ShopByDepartment;
	}

	/**
	 * @return the lst_ShopByDepartmentCategories
	 */
	public List<String> getlst_ShopByDepartmentCategories() {
		return lst_ShopByDepartmentCategories;
	}
	/**
	 * @param lst_ShopByDepartmentCategories the lst_ShopByDepartmentCategories to set
	 */
	public void setlst_ShopByDepartmentCategories(List<String> lst_ShopByDepartmentCategories) {
		this.lst_ShopByDepartmentCategories = lst_ShopByDepartmentCategories;
	}
	
	/**
	 * @return the lbl_TopSellers
	 */
	public String getlbl_TopSellers() {
		return lbl_TopSellers;
	}
	/**
	 * @param lbl_TopSellers the lbl_TopSellers to set
	 */
	public void setlbl_TopSellers(String lbl_TopSellers) {
		this.lbl_TopSellers = lbl_TopSellers;
	}
	
	/**
	 * @return the lst_SearchKeyword
	 */
	public List<String> getlst_SearchKeyword() {
		return lst_SearchKeyword;
	}
	/**
	 * @param lst_SearchKeyword the lst_SearchKeyword to set
	 */
	public void setlst_SearchKeyword(List<String> lst_SearchKeyword) {
		this.lst_SearchKeyword = lst_SearchKeyword;
	}
	
	/**
	 * @return the lst_SearchKeyword_DropDown
	 */
	public List<List<String>> getlst_SearchKeyword_DropDown() {
		return lst_SearchKeyword_DropDown;
	}
	/**
	 * @param lst_SearchKeyword_DropDown the lst_SearchKeyword_DropDown to set
	 */
	public void setlst_SearchKeyword_DropDown(List<List<String>> lst_SearchKeyword_DropDown) {
		this.lst_SearchKeyword_DropDown = lst_SearchKeyword_DropDown;
	}
	
	/**
	 * @return the lbl_SearchResultPageDefaultSetting
	 */
	public String getlbl_SearchResultPageDefaultSetting() {
		return lbl_SearchResultPageDefaultSetting;
	}
	/**
	 * @param lbl_SearchResultPageDefaultSetting the lbl_SearchResultPageDefaultSetting to set
	 */
	public void setlbl_SearchResultPageDefaultSetting(String lbl_SearchResultPageDefaultSetting) {
		this.lbl_SearchResultPageDefaultSetting = lbl_SearchResultPageDefaultSetting;
	}	
	
	/**
	 * @return the lst_SearchResultMessage
	 */
	public List<String> getlst_SearchResultMessage() {
		return lst_SearchResultMessage;
	}
	/**
	 * @param lst_SearchResultMessage the lst_SearchResultMessage to set
	 */
	public void setlst_SearchResultMessage(List<String> lst_SearchResultMessage) {
		this.lst_SearchResultMessage = lst_SearchResultMessage;
	}
	
	/**
	 * @return the lst_SortOption
	 */
	public List<String> getlst_SortOption() {
		return lst_SortOption;
	}
	/**
	 * @param lst_SortOption the lst_SortOption to set
	 */
	public void setlst_SortOption(List<String> lst_SortOption) {
		this.lst_SortOption = lst_SortOption;
	}
		
	/**
	 * @return the lst_FilterOptionHeader
	 */
	public List<String> getlst_FilterOptionHeader() {
		return lst_FilterOptionHeader;
	}
	/**
	 * @param lst_FilterOptionHeader the lst_FilterOptionHeader to set
	 */
	public void setlst_FilterOptionHeader(List<String> lst_FilterOptionHeader) {
		this.lst_FilterOptionHeader = lst_FilterOptionHeader;
	}
	
	/**
	 * @return the lst_GeneralTwoLevelFilterOption
	 */
	public List<List<String>> getlst_GeneralTwoLevelFilterOption() {
		return lst_GeneralTwoLevelFilterOption;
	}
	/**
	 * @param lst_GeneralTwoLevelFilterOption the lst_GeneralTwoLevelFilterOption to set
	 */
	public void setlst_GeneralTwoLevelFilterOption(List<List<String>> lst_GeneralTwoLevelFilterOption) {
		this.lst_GeneralTwoLevelFilterOption = lst_GeneralTwoLevelFilterOption;
	}
	
	/**
	 * @return the lst_FilterByPrice
	 */
	public List<List<String>> getlst_FilterByPrice() {
		return lst_FilterByPrice;
	}
	/**
	 * @param lst_FilterByPrice the lst_FilterByPrice to set
	 */
	public void setlst_FilterByPrice(List<List<String>> lst_FilterByPrice) {
		this.lst_FilterByPrice = lst_FilterByPrice;
	}
	
	/**
	 * @return the lst_FilterCombination
	 */
	public List<List<List<String>>> getlst_FilterCombination() {
		return lst_FilterCombination;
	}
	/**
	 * @param lst_FilterCombination the lst_FilterCombination to set
	 */
	public void setlst_FilterCombination(List<List<List<String>>> lst_FilterCombination) {
		this.lst_FilterCombination = lst_FilterCombination;
	}
	
	/**
	 * @return the lst_MoreButton
	 */
	public List<String> getlst_MoreButton() {
		return lst_MoreButton;
	}
	/**
	 * @param lst_MoreButton the lst_MoreButton to set
	 */
	public void setlst_MoreButton(List<String> lst_MoreButton) {
		this.lst_MoreButton = lst_MoreButton;
	}
	
	/**
	 * @return the lst_FilterSequentialAction
	 */
	public List<List<List<String>>> getlst_FilterSequentialAction() {
		return lst_FilterSequentialAction;
	}
	/**
	 * @param lst_FilterSequentialAction the lst_FilterSequentialAction to set
	 */
	public void setlst_FilterSequentialAction(List<List<List<String>>> lst_FilterSequentialAction) {
		this.lst_FilterSequentialAction = lst_FilterSequentialAction;
	}
	
	/**

	 * @return the lst_SocialMediaLinks
	 */
	public List<String> getlst_SocialMediaLinks() {
		return lst_SocialMediaLinks;
	}
	/**
	 * @param lst_SocialMediaLinks the lst_SocialMediaLinks to set
	 */
	public void setlst_SocialMediaLinks(List<String> lst_SocialMediaLinks) {
		this.lst_SocialMediaLinks = lst_SocialMediaLinks;
	}
	
	/**
	 * @return the lst_SpecialOffers
	 */
	public List<List<String>> getlst_SpecialOffers() {
		return lst_SpecialOffers;
	}
	/**
	 * @param lst_SpecialOffers the lst_SpecialOffers to set
	 */
	public void setlst_SpecialOffers(List<List<String>> lst_SpecialOffers) {
		this.lst_SpecialOffers = lst_SpecialOffers;
	}
	
	/**
	 * @return the lst_NameAndLinks
	 */
	public List<List<String>> getlst_NameAndLinks() {
		return lst_NameAndLinks;
	}
	/**
	 * @param lst_NameAndLinks the lst_NameAndLinks to set
	 */
	public void setlst_NameAndLinks(List<List<String>> lst_NameAndLinks) {
		this.lst_NameAndLinks = lst_NameAndLinks;
	}
	
	/**
	 * @return the lbl_Username
	 */
	public String getlbl_Username() {
		return lbl_Username;
	}
	/**
	 * @param lbl_Username the lbl_Username to set
	 */
	public void setlbl_Username(String lbl_Username) {
		this.lbl_Username = lbl_Username;
	}
	
	/**
	 * @return the lbl_Password
	 */
	public String getlbl_Password() {
		return lbl_Password;
	}
	/**
	 * @param lbl_Password the lbl_Password to set
	 */
	public void setlbl_Password(String lbl_Password) {
		this.lbl_Password = lbl_Password;
	}
	
	/**
	 * @return the lbl_FirstName
	 */
	public String getlbl_FirstName() {
		return lbl_FirstName;
	}
	/**
	 * @param lbl_FirstName the lbl_FirstName to set
	 */
	public void setlbl_FirstName(String lbl_FirstName) {
		this.lbl_FirstName = lbl_FirstName;
	}

	/**
	 * @return the lst_DisappearAfterSelectFilter
	 */
	public List<String> getlst_DisappearAfterSelectFilter() {
		return lst_DisappearAfterSelectFilter;
	}
	/**
	 * @param lst_DisappearAfterSelectFilter the lst_DisappearAfterSelectFilter to set
	 */
	public void setlst_DisappearAfterSelectFilter(List<String> lst_DisappearAfterSelectFilter) {
		this.lst_DisappearAfterSelectFilter = lst_DisappearAfterSelectFilter;
	}

	public String getLnk_product_result() {		
		return lnk_product_result; 
	}

	public void setLnk_product_result(String lnk_product_result) { this.lnk_product_result = lnk_product_result; }

	/**
	 * @return the lst_MyAccountObjectSectionTitle
	 */
	public List<String> getlst_MyAccountObjectSectionTitle() {
		return lst_MyAccountObjectSectionTitle;
	}
	/**
	 * @param lst_MyAccountObjectSectionTitle the lst_MyAccountObjectSectionTitle to set
	 */
	public void setlst_MyAccountObjectSectionTitle(List<String> lst_MyAccountObjectSectionTitle) {
		this.lst_MyAccountObjectSectionTitle = lst_MyAccountObjectSectionTitle;
	}

	/**
	 * @return the lst_TrackYourOrderObjectSectionTitle
	 */
	public List<String> getlst_TrackYourOrderObjectSectionTitle() {
		return lst_TrackYourOrderObjectSectionTitle;
	}
	/**
	 * @param lst_TrackYourOrderObjectSectionTitle the lst_TrackYourOrderObjectSectionTitle to set
	 */
	public void setlst_TrackYourOrderObjectSectionTitle(List<String> lst_TrackYourOrderObjectSectionTitle) {
		this.lst_TrackYourOrderObjectSectionTitle = lst_TrackYourOrderObjectSectionTitle;
	}

}