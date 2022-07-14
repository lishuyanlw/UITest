package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
    public Review(){}

    public Product.Paging Paging;
    public Product.Sorting Sorting;
    public ReviewSummary ReviewSummary;

    public Product.Paging getPaging() {
        return Paging;
    }

    public void setPaging(Product.Paging paging) {
        Paging = paging;
    }

    public Product.Sorting getSorting() {
        return Sorting;
    }

    public void setSorting(Product.Sorting sorting) {
        Sorting = sorting;
    }

    public Review.ReviewSummary getReviewSummary() {
        return ReviewSummary;
    }

    public void setReviewSummary(Review.ReviewSummary reviewSummary) {
        ReviewSummary = reviewSummary;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReviewSummary{
        public float AverageRatingDecimal;
        public String SnapshotConsensusValue;
        public List<DistributionHistogram> DistributionHistogram;
        public List<Reviews> Reviews;

        public float getAverageRatingDecimal() {
            return AverageRatingDecimal;
        }

        public void setAverageRatingDecimal(float averageRatingDecimal) {
            AverageRatingDecimal = averageRatingDecimal;
        }

        public String getSnapshotConsensusValue() {
            return SnapshotConsensusValue;
        }

        public void setSnapshotConsensusValue(String snapshotConsensusValue) {
            SnapshotConsensusValue = snapshotConsensusValue;
        }

        public List<Review.DistributionHistogram> getDistributionHistogram() {
            return DistributionHistogram;
        }

        public void setDistributionHistogram(List<Review.DistributionHistogram> distributionHistogram) {
            DistributionHistogram = distributionHistogram;
        }

        public List<Review.Reviews> getReviews() {
            return Reviews;
        }

        public void setReviews(List<Review.Reviews> reviews) {
            Reviews = reviews;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DistributionHistogram{
        public int Stars;
        public int BarWidth;
        public int ReviewsCount;

        public int getStars() {
            return Stars;
        }

        public void setStars(int stars) {
            Stars = stars;
        }

        public int getBarWidth() {
            return BarWidth;
        }

        public void setBarWidth(int barWidth) {
            BarWidth = barWidth;
        }

        public int getReviewsCount() {
            return ReviewsCount;
        }

        public void setReviewsCount(int reviewsCount) {
            ReviewsCount = reviewsCount;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Reviews{
        public String CreatedDate;
        public String Posted;
        public int HelpfulVotes;
        public int NotHelpfulVotes;
        public String Headline;
        public int OverallRating;
        public String BottomLine;
        public String Comments;
        public String Name;
        public String Location;
        public boolean VerifiedBuyer;
        public boolean VerifiedReviewer;
        public boolean SiteMember;
        public String BrandLogoPath;
        public List<BadgeList> BadgeList;
        public List<Media> Media;

        public String getCreatedDate() {
            return CreatedDate;
        }

        public void setCreatedDate(String createdDate) {
            CreatedDate = createdDate;
        }

        public String getPosted() {
            return Posted;
        }

        public void setPosted(String posted) {
            Posted = posted;
        }

        public int getHelpfulVotes() {
            return HelpfulVotes;
        }

        public void setHelpfulVotes(int helpfulVotes) {
            HelpfulVotes = helpfulVotes;
        }

        public int getNotHelpfulVotes() {
            return NotHelpfulVotes;
        }

        public void setNotHelpfulVotes(int notHelpfulVotes) {
            NotHelpfulVotes = notHelpfulVotes;
        }

        public String getHeadline() {
            return Headline;
        }

        public void setHeadline(String headline) {
            Headline = headline;
        }

        public int getOverallRating() {
            return OverallRating;
        }

        public void setOverallRating(int overallRating) {
            OverallRating = overallRating;
        }

        public String getBottomLine() {
            return BottomLine;
        }

        public void setBottomLine(String bottomLine) {
            BottomLine = bottomLine;
        }

        public String getComments() {
            return Comments;
        }

        public void setComments(String comments) {
            Comments = comments;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String location) {
            Location = location;
        }

        public boolean isVerifiedBuyer() {
            return VerifiedBuyer;
        }

        public void setVerifiedBuyer(boolean verifiedBuyer) {
            VerifiedBuyer = verifiedBuyer;
        }

        public boolean isVerifiedReviewer() {
            return VerifiedReviewer;
        }

        public void setVerifiedReviewer(boolean verifiedReviewer) {
            VerifiedReviewer = verifiedReviewer;
        }

        public boolean isSiteMember() {
            return SiteMember;
        }

        public void setSiteMember(boolean siteMember) {
            SiteMember = siteMember;
        }

        public String getBrandLogoPath() {
            return BrandLogoPath;
        }

        public void setBrandLogoPath(String brandLogoPath) {
            BrandLogoPath = brandLogoPath;
        }

        public List<Review.BadgeList> getBadgeList() {
            return BadgeList;
        }

        public void setBadgeList(List<Review.BadgeList> badgeList) {
            BadgeList = badgeList;
        }

        public List<Review.Media> getMedia() {
            return Media;
        }

        public void setMedia(List<Review.Media> media) {
            Media = media;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BadgeList{}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Media{
        public String Url;
        public String Type;
        public String Caption;

        public String getUrl() {            return Url;        }

        public void setUrl(String url) {            Url = url;        }

        public String getType() {            return Type;        }

        public void setType(String type) {            Type = type;        }

        public String getCaption() {            return Caption;        }

        public void setCaption(String caption) {            Caption = caption;        }
    }
}
