package com.tsc.api.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDetailsItem {
	public String ItemNo;
	public String Name;
	public String Overview;
	public int Installments;
	public int DefaultDimensionId;
	public int DefaultEdp;
	public List<Video> Videos;
	public List<String> RelatedItemNos;
	public boolean IsShowstopper;
	public boolean IsDonation;
	public boolean IsWebOnly;
	public boolean IsSoldOut;
	public boolean IsSearchable;
	public String ParentItemNo;
	public boolean EnabledAddToCart;
	public String NoReturnsMessage;
	public String PriceIsLabel;
	public String SavePriceLabel;
	public String IsPriceRange;
	public String WasPriceRange;
	public boolean ShowPriceIs;
	public boolean ShowPriceWas;
	public ProductLinkItem ProductLink;
	public ProductTypeLinkItem ProductTypeLink;
	public List<String> ProductTypes;
	public BrandLinkItem BrandLink;
	public int ProductReviewCount;
	public int ProductReviewRating;
	public List<StyleOrSize> Styles;
	public List<StyleOrSize> Sizes;
	public List<DeliveryOption> DeliveryOptions;
	public List<String> AvailableSwatches;
	public List<String> AlternateImageUrls;
	public List<Edp> Edps;
	public String ProductType;
	public List<ProductTypePath> ProductTypePath;
	public String Brand;
	public String BrandDimensionId;
	public boolean ShowBadgeImage;
	public String BadgeImagePath;
	public boolean IsLive;
	public OnAirInfo OnAirInfo;
	public ProductMessages ProductMessages;
	public List<CustomField> CustomFields;
	public boolean IsRestricted;
	public List<String> RestrictedProvinces;
	public String ValidationMessage;
	public String VendorNo;
	public String VendorName;
	public String ShipMethod;
	public List<EsmScript> EsmScripts;
	
    @Override
    public String toString(){
        return null;
    }
	
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

	public String getOverview() {
		return Overview;
	}

	public void setOverview(String overview) {
		Overview = overview;
	}

	public int getInstallments() {
		return Installments;
	}

	public void setInstallments(int installments) {
		Installments = installments;
	}

	public int getDefaultDimensionId() {
		return DefaultDimensionId;
	}

	public void setDefaultDimensionId(int defaultDimensionId) {
		DefaultDimensionId = defaultDimensionId;
	}

	public int getDefaultEdp() {
		return DefaultEdp;
	}

	public void setDefaultEdp(int defaultEdp) {
		DefaultEdp = defaultEdp;
	}

	public List<Video> getVideos() {
		return Videos;
	}

	public void setVideos(List<Video> videos) {
		Videos = videos;
	}

	public List<String> getRelatedItemNos() {
		return RelatedItemNos;
	}

	public void setRelatedItemNos(List<String> relatedItemNos) {
		RelatedItemNos = relatedItemNos;
	}

	public boolean isIsShowstopper() {
		return IsShowstopper;
	}

	public void setIsShowstopper(boolean isShowstopper) {
		IsShowstopper = isShowstopper;
	}

	public boolean isIsDonation() {
		return IsDonation;
	}

	public void setIsDonation(boolean isDonation) {
		IsDonation = isDonation;
	}

	public boolean isIsWebOnly() {
		return IsWebOnly;
	}

	public void setIsWebOnly(boolean isWebOnly) {
		IsWebOnly = isWebOnly;
	}

	public boolean isIsSoldOut() {
		return IsSoldOut;
	}

	public void setIsSoldOut(boolean isSoldOut) {
		IsSoldOut = isSoldOut;
	}

	public boolean isIsSearchable() {
		return IsSearchable;
	}

	public void setIsSearchable(boolean isSearchable) {
		IsSearchable = isSearchable;
	}

	public String getParentItemNo() {
		return ParentItemNo;
	}

	public void setParentItemNo(String parentItemNo) {
		ParentItemNo = parentItemNo;
	}

	public boolean isEnabledAddToCart() {
		return EnabledAddToCart;
	}

	public void setEnabledAddToCart(boolean enabledAddToCart) {
		EnabledAddToCart = enabledAddToCart;
	}

	public String getNoReturnsMessage() {
		return NoReturnsMessage;
	}

	public void setNoReturnsMessage(String noReturnsMessage) {
		NoReturnsMessage = noReturnsMessage;
	}

	public String getPriceIsLabel() {
		return PriceIsLabel;
	}

	public void setPriceIsLabel(String priceIsLabel) {
		PriceIsLabel = priceIsLabel;
	}

	public String getSavePriceLabel() {
		return SavePriceLabel;
	}

	public void setSavePriceLabel(String savePriceLabel) {
		SavePriceLabel = savePriceLabel;
	}

	public String getIsPriceRange() {
		return IsPriceRange;
	}

	public void setIsPriceRange(String isPriceRange) {
		IsPriceRange = isPriceRange;
	}

	public String getWasPriceRange() {
		return WasPriceRange;
	}

	public void setWasPriceRange(String wasPriceRange) {
		WasPriceRange = wasPriceRange;
	}

	public boolean isShowPriceIs() {
		return ShowPriceIs;
	}

	public void setShowPriceIs(boolean showPriceIs) {
		ShowPriceIs = showPriceIs;
	}

	public boolean isShowPriceWas() {
		return ShowPriceWas;
	}

	public void setShowPriceWas(boolean showPriceWas) {
		ShowPriceWas = showPriceWas;
	}

	public ProductLinkItem getProductLink() {
		return ProductLink;
	}

	public void setProductLink(ProductLinkItem productLink) {
		ProductLink = productLink;
	}

	public ProductTypeLinkItem getProductTypeLink() {
		return ProductTypeLink;
	}

	public void setProductTypeLink(ProductTypeLinkItem productTypeLink) {
		ProductTypeLink = productTypeLink;
	}

	public List<String> getProductTypes() {
		return ProductTypes;
	}

	public void setProductTypes(List<String> productTypes) {
		ProductTypes = productTypes;
	}

	public BrandLinkItem getBrandLink() {
		return BrandLink;
	}

	public void setBrandLink(BrandLinkItem brandLink) {
		BrandLink = brandLink;
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

	public List<StyleOrSize> getStyles() {
		return Styles;
	}

	public void setStyles(List<StyleOrSize> styles) {
		Styles = styles;
	}

	public List<StyleOrSize> getSizes() {
		return Sizes;
	}

	public void setSizes(List<StyleOrSize> sizes) {
		Sizes = sizes;
	}

	public List<DeliveryOption> getDeliveryOptions() {
		return DeliveryOptions;
	}

	public void setDeliveryOptions(List<DeliveryOption> deliveryOptions) {
		DeliveryOptions = deliveryOptions;
	}

	public List<String> getAvailableSwatches() {
		return AvailableSwatches;
	}

	public void setAvailableSwatches(List<String> availableSwatches) {
		AvailableSwatches = availableSwatches;
	}

	public List<String> getAlternateImageUrls() {
		return AlternateImageUrls;
	}

	public void setAlternateImageUrls(List<String> alternateImageUrls) {
		AlternateImageUrls = alternateImageUrls;
	}

	public List<Edp> getEdps() {
		return Edps;
	}

	public void setEdps(List<Edp> edps) {
		Edps = edps;
	}

	public String getProductType() {
		return ProductType;
	}

	public void setProductType(String productType) {
		ProductType = productType;
	}

	public List<ProductTypePath> getProductTypePath() {
		return ProductTypePath;
	}

	public void setProductTypePath(List<ProductTypePath> productTypePath) {
		ProductTypePath = productTypePath;
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

	public boolean isShowBadgeImage() {
		return ShowBadgeImage;
	}

	public void setShowBadgeImage(boolean showBadgeImage) {
		ShowBadgeImage = showBadgeImage;
	}

	public String getBadgeImagePath() {
		return BadgeImagePath;
	}

	public void setBadgeImagePath(String badgeImagePath) {
		BadgeImagePath = badgeImagePath;
	}

	public boolean isIsLive() {
		return IsLive;
	}

	public void setIsLive(boolean isLive) {
		IsLive = isLive;
	}

	public OnAirInfo getOnAirInfo() {
		return OnAirInfo;
	}

	public void setOnAirInfo(OnAirInfo onAirInfo) {
		OnAirInfo = onAirInfo;
	}

	public ProductMessages getProductMessages() {
		return ProductMessages;
	}

	public void setProductMessages(ProductMessages productMessages) {
		ProductMessages = productMessages;
	}

	public List<CustomField> getCustomFields() {
		return CustomFields;
	}

	public void setCustomFields(List<CustomField> customFields) {
		CustomFields = customFields;
	}

	public boolean isIsRestricted() {
		return IsRestricted;
	}

	public void setIsRestricted(boolean isRestricted) {
		IsRestricted = isRestricted;
	}

	public List<String> getRestrictedProvinces() {
		return RestrictedProvinces;
	}

	public void setRestrictedProvinces(List<String> restrictedProvinces) {
		RestrictedProvinces = restrictedProvinces;
	}

	public String getValidationMessage() {
		return ValidationMessage;
	}

	public void setValidationMessage(String validationMessage) {
		ValidationMessage = validationMessage;
	}

	public String getVendorNo() {
		return VendorNo;
	}

	public void setVendorNo(String vendorNo) {
		VendorNo = vendorNo;
	}

	public String getVendorName() {
		return VendorName;
	}

	public void setVendorName(String vendorName) {
		VendorName = vendorName;
	}

	public String getShipMethod() {
		return ShipMethod;
	}

	public void setShipMethod(String shipMethod) {
		ShipMethod = shipMethod;
	}

	public List<EsmScript> getEsmScripts() {
		return EsmScripts;
	}

	public void setEsmScripts(List<EsmScript> esmScripts) {
		EsmScripts = esmScripts;
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Video{
		public String Description;
		public String Thumbnail;
		public String Filename;
		public String Format;
		
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getThumbnail() {
			return Thumbnail;
		}
		public void setThumbnail(String thumbnail) {
			Thumbnail = thumbnail;
		}
		public String getFilename() {
			return Filename;
		}
		public void setFilename(String filename) {
			Filename = filename;
		}
		public String getFormat() {
			return Format;
		}
		public void setFormat(String format) {
			Format = format;
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ProductLinkItem{
		public String ShortLinkText;
		public String LinkText;
		public String LinkWithoutDomain;
		
		public String getShortLinkText() {
			return ShortLinkText;
		}
		public void setShortLinkText(String shortLinkText) {
			ShortLinkText = shortLinkText;
		}
		public String getLinkText() {
			return LinkText;
		}
		public void setLinkText(String linkText) {
			LinkText = linkText;
		}
		public String getLinkWithoutDomain() {
			return LinkWithoutDomain;
		}
		public void setLinkWithoutDomain(String linkWithoutDomain) {
			LinkWithoutDomain = linkWithoutDomain;
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ProductTypeLinkItem{
		public String ShortLinkText;
		public String LinkText;
		public String LinkWithoutDomain;
		
		public String getShortLinkText() {
			return ShortLinkText;
		}
		public void setShortLinkText(String shortLinkText) {
			ShortLinkText = shortLinkText;
		}
		public String getLinkText() {
			return LinkText;
		}
		public void setLinkText(String linkText) {
			LinkText = linkText;
		}
		public String getLinkWithoutDomain() {
			return LinkWithoutDomain;
		}
		public void setLinkWithoutDomain(String linkWithoutDomain) {
			LinkWithoutDomain = linkWithoutDomain;
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class BrandLinkItem{
		public String ShortLinkText;
		public String LinkText;
		public String LinkWithoutDomain;
		
		public String getShortLinkText() {
			return ShortLinkText;
		}
		public void setShortLinkText(String shortLinkText) {
			ShortLinkText = shortLinkText;
		}
		public String getLinkText() {
			return LinkText;
		}
		public void setLinkText(String linkText) {
			LinkText = linkText;
		}
		public String getLinkWithoutDomain() {
			return LinkWithoutDomain;
		}
		public void setLinkWithoutDomain(String linkWithoutDomain) {
			LinkWithoutDomain = linkWithoutDomain;
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class StyleOrSize{
		public String TypeId;
		public String DimensionId;
		public String DisplayName;
		public String ParentId;
		public boolean HasChildren;
		public int ProductsCount;
		public List<ParentDimension> ParentDimensions;
		
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
		public List<ParentDimension> getParentDimensions() {
			return ParentDimensions;
		}
		public void setParentDimensions(List<ParentDimension> parentDimensions) {
			ParentDimensions = parentDimensions;
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ParentDimension {}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DeliveryOption{
		public int EdpNo;
		public String DisplayName;
		
		public int getEdpNo() {
			return EdpNo;
		}
		public void setEdpNo(int edpNo) {
			EdpNo = edpNo;
		}
		public String getDisplayName() {
			return DisplayName;
		}
		public void setDisplayName(String displayName) {
			DisplayName = displayName;
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Edp{
		public String ItemNo;
		public int EdpNo;
		public String UpcNo;
		public int Inventory;
		public String Style;
		public String StyleDimensionId;
		public String Size;
		public String SizeDimensionId;
		public int SkuAvailabilityType;
		public String SkuAvailabilityMessage;
		public String AppliedShipping;
		public String DefaultShipping;
		public String DefaultPrice;
		public String AppliedPrice;
		public String WasPrice;
		public String SavePrice;
		public String EasyPaymentPrice;
		public boolean IsSoldOut;
		public boolean IsDonation;
		public boolean IsAdp;
		public boolean IsAdvanceOrBackOrder;
		public String ImageUrl;
		public int Weight;
		public int StandingOrderIntervalInDays;
		
		public String getItemNo() {
			return ItemNo;
		}
		public void setItemNo(String itemNo) {
			ItemNo = itemNo;
		}
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
		public int getInventory() {
			return Inventory;
		}
		public void setInventory(int inventory) {
			Inventory = inventory;
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
		public int getSkuAvailabilityType() {
			return SkuAvailabilityType;
		}
		public void setSkuAvailabilityType(int skuAvailabilityType) {
			SkuAvailabilityType = skuAvailabilityType;
		}
		public String getSkuAvailabilityMessage() {
			return SkuAvailabilityMessage;
		}
		public void setSkuAvailabilityMessage(String skuAvailabilityMessage) {
			SkuAvailabilityMessage = skuAvailabilityMessage;
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
		public String getDefaultPrice() {
			return DefaultPrice;
		}
		public void setDefaultPrice(String defaultPrice) {
			DefaultPrice = defaultPrice;
		}
		public String getAppliedPrice() {
			return AppliedPrice;
		}
		public void setAppliedPrice(String appliedPrice) {
			AppliedPrice = appliedPrice;
		}
		public String getWasPrice() {
			return WasPrice;
		}
		public void setWasPrice(String wasPrice) {
			WasPrice = wasPrice;
		}
		public String getSavePrice() {
			return SavePrice;
		}
		public void setSavePrice(String savePrice) {
			SavePrice = savePrice;
		}
		public String getEasyPaymentPrice() {
			return EasyPaymentPrice;
		}
		public void setEasyPaymentPrice(String easyPaymentPrice) {
			EasyPaymentPrice = easyPaymentPrice;
		}
		public boolean isIsSoldOut() {
			return IsSoldOut;
		}
		public void setIsSoldOut(boolean isSoldOut) {
			IsSoldOut = isSoldOut;
		}
		public boolean isIsDonation() {
			return IsDonation;
		}
		public void setIsDonation(boolean isDonation) {
			IsDonation = isDonation;
		}
		public boolean isIsAdp() {
			return IsAdp;
		}
		public void setIsAdp(boolean isAdp) {
			IsAdp = isAdp;
		}
		public boolean isIsAdvanceOrBackOrder() {
			return IsAdvanceOrBackOrder;
		}
		public void setIsAdvanceOrBackOrder(boolean isAdvanceOrBackOrder) {
			IsAdvanceOrBackOrder = isAdvanceOrBackOrder;
		}
		public String getImageUrl() {
			return ImageUrl;
		}
		public void setImageUrl(String imageUrl) {
			ImageUrl = imageUrl;
		}
		public int getWeight() {
			return Weight;
		}
		public void setWeight(int weight) {
			Weight = weight;
		}
		public int getStandingOrderIntervalInDays() {
			return StandingOrderIntervalInDays;
		}
		public void setStandingOrderIntervalInDays(int standingOrderIntervalInDays) {
			StandingOrderIntervalInDays = standingOrderIntervalInDays;
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ProductTypePath{
		public String FacetTypeId;
		public String FacetValueId;
		public String FacetValueNameEn;
		public String FacetValueNameFr;
		public String FacetValueDisplayName;
		public String FacetValueParentId;
		public int FacetValueDisplayOrder;
		
		public String getFacetTypeId() {
			return FacetTypeId;
		}
		public void setFacetTypeId(String facetTypeId) {
			FacetTypeId = facetTypeId;
		}
		public String getFacetValueId() {
			return FacetValueId;
		}
		public void setFacetValueId(String facetValueId) {
			FacetValueId = facetValueId;
		}
		public String getFacetValueNameEn() {
			return FacetValueNameEn;
		}
		public void setFacetValueNameEn(String facetValueNameEn) {
			FacetValueNameEn = facetValueNameEn;
		}
		public String getFacetValueNameFr() {
			return FacetValueNameFr;
		}
		public void setFacetValueNameFr(String facetValueNameFr) {
			FacetValueNameFr = facetValueNameFr;
		}
		public String getFacetValueDisplayName() {
			return FacetValueDisplayName;
		}
		public void setFacetValueDisplayName(String facetValueDisplayName) {
			FacetValueDisplayName = facetValueDisplayName;
		}
		public String getFacetValueParentId() {
			return FacetValueParentId;
		}
		public void setFacetValueParentId(String facetValueParentId) {
			FacetValueParentId = facetValueParentId;
		}
		public int getFacetValueDisplayOrder() {
			return FacetValueDisplayOrder;
		}
		public void setFacetValueDisplayOrder(int facetValueDisplayOrder) {
			FacetValueDisplayOrder = facetValueDisplayOrder;
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class OnAirInfo{
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
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ProductMessages{
		public String AppliedOfferMessage;

		public String getAppliedOfferMessage() {
			return AppliedOfferMessage;
		}

		public void setAppliedOfferMessage(String appliedOfferMessage) {
			AppliedOfferMessage = appliedOfferMessage;
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class CustomField{
		public int Sequence;
		public String DisplayName;
		public int MaxLength;
		public String DisplayValue;
		
		public int getSequence() {
			return Sequence;
		}
		public void setSequence(int sequence) {
			Sequence = sequence;
		}
		public String getDisplayName() {
			return DisplayName;
		}
		public void setDisplayName(String displayName) {
			DisplayName = displayName;
		}
		public int getMaxLength() {
			return MaxLength;
		}
		public void setMaxLength(int maxLength) {
			MaxLength = maxLength;
		}
		public String getDisplayValue() {
			return DisplayValue;
		}
		public void setDisplayValue(String displayValue) {
			DisplayValue = displayValue;
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class EsmScript{
		public String ScriptTypeCode;
		public String ScriptType;
		public List<String> ScriptInfo;
		
		public String getScriptTypeCode() {
			return ScriptTypeCode;
		}
		public void setScriptTypeCode(String scriptTypeCode) {
			ScriptTypeCode = scriptTypeCode;
		}
		public String getScriptType() {
			return ScriptType;
		}
		public void setScriptType(String scriptType) {
			ScriptType = scriptType;
		}
		public List<String> getScriptInfo() {
			return ScriptInfo;
		}
		public void setScriptInfo(List<String> scriptInfo) {
			ScriptInfo = scriptInfo;
		}
	}


	
}
