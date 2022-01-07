package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    public Product(){}

    public Paging Paging;
    public List<Products> Products;
    public List<DimensionStates> DimensionStates;
    public Sorting Sorting;
    public String QueryId;
    public String SearchTerm;
    public List<QueryInfo> QueryInfo;
    public List<QueryDims> QueryDims;
    public String RedirectUrl;
    public boolean Redirected;
    public boolean DoNotRedirectPrpToNsrp;
    public String AimRequestEndpoint;
    public String AimRequestBody;
    public String AimRequestTime;
    public int AimResponseTimeInMS;
    public String AimRequestResponseLogDir;
    public String AimRequestFileName;
    public String AimResponseFileName;
    public int AimRequestResponseLogThreshold;

    public Paging getPaging() {
		return Paging;
	}

	public void setPaging(Paging paging) {
		Paging = paging;
	}

	public List<Products> getProducts() {
        return Products;
    }

    public void setProducts(List<Products> products) {
        this.Products = products;
    }

    public List<DimensionStates> getDimensionStates() {
        return DimensionStates;
    }

    public void setDimensionStates(List<DimensionStates> dimensionStates) {
        this.DimensionStates = dimensionStates;
    }

    public Sorting getSorting() {
        return Sorting;
    }

    public void setSorting(Sorting sorting) {
        this.Sorting = sorting;
    }

    public String getQueryId() {
        return QueryId;
    }

    public void setQueryId(String queryId) {
        this.QueryId = queryId;
    }

    public String getSearchTerm() {
        return SearchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.SearchTerm = searchTerm;
    }

    public List<QueryInfo> getQueryInfo() {
        return QueryInfo;
    }

    public void setQueryInfo(List<QueryInfo> queryInfo) {
        this.QueryInfo = queryInfo;
    }

    public List<QueryDims> getQueryDims() {
        return QueryDims;
    }

    public void setQueryDims(List<QueryDims> queryDims) {
        this.QueryDims = queryDims;
    }

    public String getRedirectUrl() {
        return RedirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.RedirectUrl = redirectUrl;
    }

    public boolean isRedirected() {
        return Redirected;
    }

    public void setRedirected(boolean redirected) {
        this.Redirected = redirected;
    }

    public boolean isDoNotRedirectPrpToNsrp() {
        return DoNotRedirectPrpToNsrp;
    }

    public void setDoNotRedirectPrpToNsrp(boolean doNotRedirectPrpToNsrp) {
        DoNotRedirectPrpToNsrp = doNotRedirectPrpToNsrp;
    }

    public String getAimRequestEndpoint() {
        return AimRequestEndpoint;
    }

    public void setAimRequestEndpoint(String aimRequestEndpoint) {
        AimRequestEndpoint = aimRequestEndpoint;
    }

    public String getAimRequestBody() {
        return AimRequestBody;
    }

    public void setAimRequestBody(String aimRequestBody) {
        AimRequestBody = aimRequestBody;
    }

    public String getAimRequestTime() {
        return AimRequestTime;
    }

    public void setAimRequestTime(String aimRequestTime) {
        AimRequestTime = aimRequestTime;
    }

    public int getAimResponseTimeInMS() {
        return AimResponseTimeInMS;
    }

    public void setAimResponseTimeInMS(int aimResponseTimeInMS) {
        AimResponseTimeInMS = aimResponseTimeInMS;
    }

    public String getAimRequestResponseLogDir() {
        return AimRequestResponseLogDir;
    }

    public void setAimRequestResponseLogDir(String aimRequestResponseLogDir) {
        AimRequestResponseLogDir = aimRequestResponseLogDir;
    }

    public String getAimRequestFileName() {
        return AimRequestFileName;
    }

    public void setAimRequestFileName(String aimRequestFileName) {
        AimRequestFileName = aimRequestFileName;
    }

    public String getAimResponseFileName() {
        return AimResponseFileName;
    }

    public void setAimResponseFileName(String aimResponseFileName) {
        AimResponseFileName = aimResponseFileName;
    }

    public int getAimRequestResponseLogThreshold() {
        return AimRequestResponseLogThreshold;
    }

    public void setAimRequestResponseLogThreshold(int aimRequestResponseLogThreshold) {
        AimRequestResponseLogThreshold = aimRequestResponseLogThreshold;
    }

    @Override
    public String toString(){
        return null;
    }

    
    public static class Paging {
        public int TotalRecords;
        public int TotalPages;
        public int CurrentPage;

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            TotalRecords = totalRecords;
        }

        public int getTotalPages() {
            return TotalPages;
        }

        public void setTotalPages(int totalPages) {
            TotalPages = totalPages;
        }

        public int getCurrentPage() {
            return CurrentPage;
        }

        public void setCurrentPage(int currentPage) {
            CurrentPage = currentPage;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Products {
        public String ItemNo;
        public String Name;
        public String ParentItemNo;
        public String ProductType;
        public String ProductTypeDimensionId;
        public String Brand;
        public String BrandDimensionId;
        public String CategoryPath;
        public int Installments;
        public String IsPriceRange;
        public boolean IsSearchable;
        public boolean IsShowstopper;
        public boolean IsActive;
        public boolean EnabledAddToCart;
        public String AppliedOfferMessage;
        public int ProductReviewCount;
        public int ProductReviewRating;
        public int VideosCount;
        public String WasPriceRange;
        public String LinkWithoutDomain;
        public String EasyPaymentPrice;
        public String ImageUrl;
        public boolean ShowBadgeImage;
        public OnAirInfo OnAirInfo;
        public boolean IsLive;
        public List<Styles> Styles;
        public List<Sizes> Sizes;
        public int DefaultEdp;
        public List<edps> Edps;

        public String getItemNo() {
            return ItemNo;
        }

        public void setItemNo(String itemNo) {
            ItemNo = itemNo;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getParentItemNo() {
            return ParentItemNo;
        }

        public void setParentItemNo(String parentItemNo) {
            ParentItemNo = parentItemNo;
        }

        public String getProductType() {
            return ProductType;
        }

        public void setProductType(String productType) {
            ProductType = productType;
        }

        public String getProductTypeDimensionId() {
            return ProductTypeDimensionId;
        }

        public void setProductTypeDimensionId(String productTypeDimensionId) {
            ProductTypeDimensionId = productTypeDimensionId;
        }

        public String getBrand() {
            return Brand;
        }

        public void setBrand(String brand) {
            Brand = brand;
        }

        public String getBrandDimensionId() {
            return BrandDimensionId;
        }

        public void setBrandDimensionId(String brandDimensionId) {
            BrandDimensionId = brandDimensionId;
        }

        public String getCategoryPath() {
            return CategoryPath;
        }

        public void setCategoryPath(String categoryPath) {
            CategoryPath = categoryPath;
        }

        public int getInstallments() {
            return Installments;
        }

        public void setInstallments(int installments) {
            Installments = installments;
        }

        public String getIsPriceRange() {
            return IsPriceRange;
        }

        public void setIsPriceRange(String isPriceRange) {
            IsPriceRange = isPriceRange;
        }

        public boolean isSearchable() {
            return IsSearchable;
        }

        public void setSearchable(boolean searchable) {
            IsSearchable = searchable;
        }

        public boolean isShowstopper() {
            return IsShowstopper;
        }

        public void setShowstopper(boolean showstopper) {
            IsShowstopper = showstopper;
        }

        public boolean isActive() {
            return IsActive;
        }

        public void setActive(boolean active) {
            IsActive = active;
        }

        public boolean isEnabledAddToCart() {
            return EnabledAddToCart;
        }

        public void setEnabledAddToCart(boolean enabledAddToCart) {
            EnabledAddToCart = enabledAddToCart;
        }

        public String getAppliedOfferMessage() {
            return AppliedOfferMessage;
        }

        public void setAppliedOfferMessage(String appliedOfferMessage) {
            AppliedOfferMessage = appliedOfferMessage;
        }

        public int getProductReviewCount() {
            return ProductReviewCount;
        }

        public void setProductReviewCount(int productReviewCount) {
            ProductReviewCount = productReviewCount;
        }

        public int getProductReviewRating() {
            return ProductReviewRating;
        }

        public void setProductReviewRating(int productReviewRating) {
            ProductReviewRating = productReviewRating;
        }

        public int getVideosCount() {
            return VideosCount;
        }

        public void setVideosCount(int videosCount) {
            VideosCount = videosCount;
        }

        public String getWasPriceRange() {
            return WasPriceRange;
        }

        public void setWasPriceRange(String wasPriceRange) {
            WasPriceRange = wasPriceRange;
        }

        public String getLinkWithoutDomain() {
            return LinkWithoutDomain;
        }

        public void setLinkWithoutDomain(String linkWithoutDomain) {
            LinkWithoutDomain = linkWithoutDomain;
        }

        public String getEasyPaymentPrice() {
            return EasyPaymentPrice;
        }

        public void setEasyPaymentPrice(String easyPaymentPrice) {
            EasyPaymentPrice = easyPaymentPrice;
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String imageUrl) {
            ImageUrl = imageUrl;
        }

        public boolean isShowBadgeImage() {
            return ShowBadgeImage;
        }

        public void setShowBadgeImage(boolean showBadgeImage) {
            ShowBadgeImage = showBadgeImage;
        }

        public Product.OnAirInfo getOnAirInfo() {
            return OnAirInfo;
        }

        public void setOnAirInfo(Product.OnAirInfo onAirInfo) {
            OnAirInfo = onAirInfo;
        }

        public boolean isLive() {
            return IsLive;
        }

        public void setLive(boolean live) {
            IsLive = live;
        }

        public List<Product.Styles> getStyles() {
            return Styles;
        }

        public void setStyles(List<Product.Styles> styles) {
            Styles = styles;
        }

        public List<Product.Sizes> getSizes() {
            return Sizes;
        }

        public void setSizes(List<Product.Sizes> sizes) {
            Sizes = sizes;
        }

        public int getDefaultEdp() {
            return DefaultEdp;
        }

        public void setDefaultEdp(int defaultEdp) {
            DefaultEdp = defaultEdp;
        }

        public List<edps> getEdps() {
            return Edps;
        }

        public void setEdps(List<edps> edps) {
            Edps = edps;
        }
    }

    public static class OnAirInfo {
        public String OnAirStart;
        public int DurationInSecond;

        public String getOnAirStart() {
            return OnAirStart;
        }

        public void setOnAirStart(String onAirStart) {
            OnAirStart = onAirStart;
        }

        public int getDurationInSecond() {
            return DurationInSecond;
        }

        public void setDurationInSecond(int durationInSecond) {
            DurationInSecond = durationInSecond;
        }
    }

    public static class Styles {
        public String TypeId;
        public String DimensionId;
        public String DisplayName;
        public String ParentId;
        public boolean HasChildren;
        public int ProductsCount;
        public ParentDimensions ParentDimensions;

        public String getTypeId() {
            return TypeId;
        }

        public void setTypeId(String typeId) {
            TypeId = typeId;
        }

        public String getDimensionId() {
            return DimensionId;
        }

        public void setDimensionId(String dimensionId) {
            DimensionId = dimensionId;
        }

        public String getDisplayName() {
            return DisplayName;
        }

        public void setDisplayName(String displayName) {
            DisplayName = displayName;
        }

        public String getParentId() {
            return ParentId;
        }

        public void setParentId(String parentId) {
            ParentId = parentId;
        }

        public boolean isHasChildren() {
            return HasChildren;
        }

        public void setHasChildren(boolean hasChildren) {
            HasChildren = hasChildren;
        }

        public int getProductsCount() {
            return ProductsCount;
        }

        public void setProductsCount(int productsCount) {
            ProductsCount = productsCount;
        }

        public Product.ParentDimensions getParentDimensions() {
            return ParentDimensions;
        }

        public void setParentDimensions(Product.ParentDimensions parentDimensions) {
            ParentDimensions = parentDimensions;
        }
    }

    public static class Sizes {
        public String TypeId;
        public String DimensionId;
        public String DisplayName;
        public String ParentId;
        public boolean HasChildren;
        public int ProductsCount;
        public ParentDimensions ParentDimensions;

        public String getTypeId() {
            return TypeId;
        }

        public void setTypeId(String typeId) {
            TypeId = typeId;
        }

        public String getDimensionId() {
            return DimensionId;
        }

        public void setDimensionId(String dimensionId) {
            DimensionId = dimensionId;
        }

        public String getDisplayName() {
            return DisplayName;
        }

        public void setDisplayName(String displayName) {
            DisplayName = displayName;
        }

        public String getParentId() {
            return ParentId;
        }

        public void setParentId(String parentId) {
            ParentId = parentId;
        }

        public boolean isHasChildren() {
            return HasChildren;
        }

        public void setHasChildren(boolean hasChildren) {
            HasChildren = hasChildren;
        }

        public int getProductsCount() {
            return ProductsCount;
        }

        public void setProductsCount(int productsCount) {
            ProductsCount = productsCount;
        }

        public Product.ParentDimensions getParentDimensions() {
            return ParentDimensions;
        }

        public void setParentDimensions(Product.ParentDimensions parentDimensions) {
            ParentDimensions = parentDimensions;
        }
    }

    public static class ParentDimensions {}

    public static class edps {
        public int EdpNo;
        public String UpcNo;
        public String AppliedPrice;
        public String AppliedShipping;
        public String DefaultShipping;
        public String EasyPaymentPrice;
        public int Inventory;
        public String ImageUrl;
        public String Style;
        public String StyleDimensionId;
        public String Size;
        public String SizeDimensionId;
        public int UnitsSold;

        public int getEdpNo() {
            return EdpNo;
        }

        public void setEdpNo(int edpNo) {
            EdpNo = edpNo;
        }

        public String getUpcNo() {
            return UpcNo;
        }

        public void setUpcNo(String upcNo) {
            UpcNo = upcNo;
        }

        public String getAppliedPrice() {
            return AppliedPrice;
        }

        public void setAppliedPrice(String appliedPrice) {
            AppliedPrice = appliedPrice;
        }

        public String getAppliedShipping() {
            return AppliedShipping;
        }

        public void setAppliedShipping(String appliedShipping) {
            AppliedShipping = appliedShipping;
        }

        public String getDefaultShipping() {
            return DefaultShipping;
        }

        public void setDefaultShipping(String defaultShipping) {
            DefaultShipping = defaultShipping;
        }

        public String getEasyPaymentPrice() {
            return EasyPaymentPrice;
        }

        public void setEasyPaymentPrice(String easyPaymentPrice) {
            EasyPaymentPrice = easyPaymentPrice;
        }

        public int getInventory() {
            return Inventory;
        }

        public void setInventory(int inventory) {
            Inventory = inventory;
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String imageUrl) {
            ImageUrl = imageUrl;
        }

        public String getStyle() {
            return Style;
        }

        public void setStyle(String style) {
            Style = style;
        }

        public String getStyleDimensionId() {
            return StyleDimensionId;
        }

        public void setStyleDimensionId(String styleDimensionId) {
            StyleDimensionId = styleDimensionId;
        }

        public String getSize() {
            return Size;
        }

        public void setSize(String size) {
            Size = size;
        }

        public String getSizeDimensionId() {
            return SizeDimensionId;
        }

        public void setSizeDimensionId(String sizeDimensionId) {
            SizeDimensionId = sizeDimensionId;
        }

        public int getUnitsSold() {
            return UnitsSold;
        }

        public void setUnitsSold(int unitsSold) {
            UnitsSold = unitsSold;
        }
    }

    public static class DimensionStates {
        public String ListTitle;
        public String DimensionType;
        public boolean MultiSelect;
        public int VisibleNumber;
        public int Count;
        public String SeeMoreLinkText;
        public String SeeLessLinkText;
        public List<Refinements> Refinements;

        public String getListTitle() {
            return ListTitle;
        }

        public void setListTitle(String listTitle) {
            ListTitle = listTitle;
        }

        public String getDimensionType() {
            return DimensionType;
        }

        public void setDimensionType(String dimensionType) {
            DimensionType = dimensionType;
        }

        public boolean isMultiSelect() {
            return MultiSelect;
        }

        public void setMultiSelect(boolean multiSelect) {
            MultiSelect = multiSelect;
        }

        public int getVisibleNumber() {
            return VisibleNumber;
        }

        public void setVisibleNumber(int visibleNumber) {
            VisibleNumber = visibleNumber;
        }

        public int getCount() {
            return Count;
        }

        public void setCount(int count) {
            Count = count;
        }

        public String getSeeMoreLinkText() {
            return SeeMoreLinkText;
        }

        public void setSeeMoreLinkText(String seeMoreLinkText) {
            SeeMoreLinkText = seeMoreLinkText;
        }

        public String getSeeLessLinkText() {
            return SeeLessLinkText;
        }

        public void setSeeLessLinkText(String seeLessLinkText) {
            SeeLessLinkText = seeLessLinkText;
        }

        public List<Product.Refinements> getRefinements() {
            return Refinements;
        }

        public void setRefinements(List<Product.Refinements> refinements) {
            Refinements = refinements;
        }
    }

    public static class Refinements {
        public String DimensionId;
        public String DimensionName;
        public String DimensionType;
        public boolean MultiSelect;
        public boolean Selected;
        public String Url;
        public int Count;

        public String getDimensionId() {
            return DimensionId;
        }

        public void setDimensionId(String dimensionId) {
            DimensionId = dimensionId;
        }

        public String getDimensionName() {
            return DimensionName;
        }

        public void setDimensionName(String dimensionName) {
            DimensionName = dimensionName;
        }

        public String getDimensionType() {
            return DimensionType;
        }

        public void setDimensionType(String dimensionType) {
            DimensionType = dimensionType;
        }

        public boolean isMultiSelect() {
            return MultiSelect;
        }

        public void setMultiSelect(boolean multiSelect) {
            MultiSelect = multiSelect;
        }

        public boolean isSelected() {
            return Selected;
        }

        public void setSelected(boolean selected) {
            Selected = selected;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String url) {
            Url = url;
        }

        public int getCount() {
            return Count;
        }

        public void setCount(int count) {
            Count = count;
        }
    }

    public static class Sorting {
        public SelectedSortOption SelectedSortOption;
        public List<SortOptions> SortOptions;

        public Product.SelectedSortOption getSelectedSortOption() {
            return SelectedSortOption;
        }

        public void setSelectedSortOption(Product.SelectedSortOption selectedSortOption) {
            SelectedSortOption = selectedSortOption;
        }

        public List<Product.SortOptions> getSortOptions() {
            return SortOptions;
        }

        public void setSortOptions(List<Product.SortOptions> sortOptions) {
            SortOptions = sortOptions;
        }
    }

    public static class SelectedSortOption {
        public String Key;
        public String DisplayName;

        public String getKey() {
            return Key;
        }

        public void setKey(String key) {
            Key = key;
        }

        public String getDisplayName() {
            return DisplayName;
        }

        public void setDisplayName(String displayName) {
            DisplayName = displayName;
        }
    }

    public static class SortOptions {
        public String Key;
        public String DisplayName;

        public String getKey() {
            return Key;
        }

        public void setKey(String key) {
            Key = key;
        }

        public String getDisplayName() {
            return DisplayName;
        }

        public void setDisplayName(String displayName) {
            DisplayName = displayName;
        }
    }

    public static class QueryInfo {
        public String SearchTerm;
        public String QueryFilter;

        public String getSearchTerm() {
            return SearchTerm;
        }

        public void setSearchTerm(String searchTerm) {
            SearchTerm = searchTerm;
        }

        public String getQueryFilter() {
            return QueryFilter;
        }

        public void setQueryFilter(String queryFilter) {
            QueryFilter = queryFilter;
        }
    }

    public static class QueryDims {
        public String TypeId;
        public String DimensionId;
        public String DisplayName;
        public String ParentId;
        public boolean HasChildren;
        public int ProductsCount;
        public ParentDimensions ParentDimensions;

        public String getTypeId() {
            return TypeId;
        }

        public void setTypeId(String typeId) {
            TypeId = typeId;
        }

        public String getDimensionId() {
            return DimensionId;
        }

        public void setDimensionId(String dimensionId) {
            DimensionId = dimensionId;
        }

        public String getDisplayName() {
            return DisplayName;
        }

        public void setDisplayName(String displayName) {
            DisplayName = displayName;
        }

        public String getParentId() {
            return ParentId;
        }

        public void setParentId(String parentId) {
            ParentId = parentId;
        }

        public boolean isHasChildren() {
            return HasChildren;
        }

        public void setHasChildren(boolean hasChildren) {
            HasChildren = hasChildren;
        }

        public int getProductsCount() {
            return ProductsCount;
        }

        public void setProductsCount(int productsCount) {
            ProductsCount = productsCount;
        }

        public Product.ParentDimensions getParentDimensions() {
            return ParentDimensions;
        }

        public void setParentDimensions(Product.ParentDimensions parentDimensions) {
            ParentDimensions = parentDimensions;
        }
    }
}