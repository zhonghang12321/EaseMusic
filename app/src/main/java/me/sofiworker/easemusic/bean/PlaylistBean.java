package me.sofiworker.easemusic.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import me.sofiworker.easemusic.adapter.MeRvAdapter;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/30 18:22
 * @description “我的”页面中歌单列表中的歌单bean
 */
public class PlaylistBean extends AbstractExpandableItem implements MultiItemEntity {

    private boolean subscribed;
    private CreatorBean creator;
    private Object artists;
    private Object tracks;
    private Object updateFrequency;
    private String backgroundCoverId;
    private Object backgroundCoverUrl;
    private String titleImage;
    private Object titleImageUrl;
    private Object englishTitle;
    private boolean opRecommend;
    private Object recommendInfo;
    private int userId;
    private int status;
    private boolean ordered;
    private long createTime;
    private boolean highQuality;
    private int specialType;
    private long updateTime;
    private String commentThreadId;
    private long coverImgId;
    private boolean newImported;
    private boolean anonimous;
    private int privacy;
    private long trackUpdateTime;
    private int trackCount;
    private String coverImgUrl;
    private int totalDuration;
    private long trackNumberUpdateTime;
    private String playCount;
    private int adType;
    private int subscribedCount;
    private int cloudTrackCount;
    private Object description;
    private String name;
    private long id;
    private String coverImgId_str;
    private List<?> subscribers;
    private List<?> tags;

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public Object getArtists() {
        return artists;
    }

    public void setArtists(Object artists) {
        this.artists = artists;
    }

    public Object getTracks() {
        return tracks;
    }

    public void setTracks(Object tracks) {
        this.tracks = tracks;
    }

    public Object getUpdateFrequency() {
        return updateFrequency;
    }

    public void setUpdateFrequency(Object updateFrequency) {
        this.updateFrequency = updateFrequency;
    }

    public String getBackgroundCoverId() {
        return backgroundCoverId;
    }

    public void setBackgroundCoverId(String backgroundCoverId) {
        this.backgroundCoverId = backgroundCoverId;
    }

    public Object getBackgroundCoverUrl() {
        return backgroundCoverUrl;
    }

    public void setBackgroundCoverUrl(Object backgroundCoverUrl) {
        this.backgroundCoverUrl = backgroundCoverUrl;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public Object getTitleImageUrl() {
        return titleImageUrl;
    }

    public void setTitleImageUrl(Object titleImageUrl) {
        this.titleImageUrl = titleImageUrl;
    }

    public Object getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(Object englishTitle) {
        this.englishTitle = englishTitle;
    }

    public boolean isOpRecommend() {
        return opRecommend;
    }

    public void setOpRecommend(boolean opRecommend) {
        this.opRecommend = opRecommend;
    }

    public Object getRecommendInfo() {
        return recommendInfo;
    }

    public void setRecommendInfo(Object recommendInfo) {
        this.recommendInfo = recommendInfo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public boolean isHighQuality() {
        return highQuality;
    }

    public void setHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
    }

    public int getSpecialType() {
        return specialType;
    }

    public void setSpecialType(int specialType) {
        this.specialType = specialType;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public long getCoverImgId() {
        return coverImgId;
    }

    public void setCoverImgId(long coverImgId) {
        this.coverImgId = coverImgId;
    }

    public boolean isNewImported() {
        return newImported;
    }

    public void setNewImported(boolean newImported) {
        this.newImported = newImported;
    }

    public boolean isAnonimous() {
        return anonimous;
    }

    public void setAnonimous(boolean anonimous) {
        this.anonimous = anonimous;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public long getTrackUpdateTime() {
        return trackUpdateTime;
    }

    public void setTrackUpdateTime(long trackUpdateTime) {
        this.trackUpdateTime = trackUpdateTime;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public long getTrackNumberUpdateTime() {
        return trackNumberUpdateTime;
    }

    public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
        this.trackNumberUpdateTime = trackNumberUpdateTime;
    }

    public String getPlayCount() {
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public int getSubscribedCount() {
        return subscribedCount;
    }

    public void setSubscribedCount(int subscribedCount) {
        this.subscribedCount = subscribedCount;
    }

    public int getCloudTrackCount() {
        return cloudTrackCount;
    }

    public void setCloudTrackCount(int cloudTrackCount) {
        this.cloudTrackCount = cloudTrackCount;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoverImgId_str() {
        return coverImgId_str;
    }

    public void setCoverImgId_str(String coverImgId_str) {
        this.coverImgId_str = coverImgId_str;
    }

    public List<?> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<?> subscribers) {
        this.subscribers = subscribers;
    }

    public List<?> getTags() {
        return tags;
    }

    public void setTags(List<?> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "PlaylistBean{" +
                "subscribed=" + subscribed +
                ", creator=" + creator +
                ", artists=" + artists +
                ", tracks=" + tracks +
                ", updateFrequency=" + updateFrequency +
                ", backgroundCoverId='" + backgroundCoverId + '\'' +
                ", backgroundCoverUrl=" + backgroundCoverUrl +
                ", titleImage='" + titleImage + '\'' +
                ", titleImageUrl=" + titleImageUrl +
                ", englishTitle=" + englishTitle +
                ", opRecommend=" + opRecommend +
                ", recommendInfo=" + recommendInfo +
                ", userId=" + userId +
                ", status=" + status +
                ", ordered=" + ordered +
                ", createTime=" + createTime +
                ", highQuality=" + highQuality +
                ", specialType=" + specialType +
                ", updateTime=" + updateTime +
                ", commentThreadId='" + commentThreadId + '\'' +
                ", coverImgId=" + coverImgId +
                ", newImported=" + newImported +
                ", anonimous=" + anonimous +
                ", privacy=" + privacy +
                ", trackUpdateTime=" + trackUpdateTime +
                ", trackCount=" + trackCount +
                ", coverImgUrl='" + coverImgUrl + '\'' +
                ", totalDuration=" + totalDuration +
                ", trackNumberUpdateTime=" + trackNumberUpdateTime +
                ", playCount='" + playCount + '\'' +
                ", adType=" + adType +
                ", subscribedCount=" + subscribedCount +
                ", cloudTrackCount=" + cloudTrackCount +
                ", description=" + description +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", coverImgId_str='" + coverImgId_str + '\'' +
                ", subscribers=" + subscribers +
                ", tags=" + tags +
                '}';
    }

    @Override
    public int getLevel() {
        return MeRvAdapter.TYPE_LEVEL_2;
    }

    @Override
    public int getItemType() {
        return 2;
    }
}
