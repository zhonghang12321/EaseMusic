package me.sofiworker.easemusic.bean;

import java.io.Serializable;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/28 20:33
 * @description userBean中的子类
 */
public class ProfileBean implements Serializable {

    private static final long serialVersionUID = -1115722585286878762L;
    private String avatarImgIdStr;
    private String backgroundImgIdStr;
    private boolean followed;
    private String backgroundUrl;
    private String detailDescription;
    private String description;
    private int djStatus;
    private ExpertBean experts;
    private boolean mutual;
    private Object remarkName;
    private Object expertTags;
    private int authStatus;
    private long avatarImgId;
    private long birthday;
    private String nickname;
    private int city;
    private int userType;
    private long backgroundImgId;
    private int province;
    private boolean defaultAvatar;
    private String avatarUrl;
    private int userId;
    private int vipType;
    private int gender;
    private int accountStatus;
    private String signature;
    private int authority;
    private String avatarImgId_str;
    private int followeds;
    private int follows;
    private int eventCount;
    private int playlistCount;
    private int playlistBeSubscribedCount;

    public String getAvatarImgIdStr() {
        return avatarImgIdStr;
    }

    public void setAvatarImgIdStr(String avatarImgIdStr) {
        this.avatarImgIdStr = avatarImgIdStr;
    }

    public String getBackgroundImgIdStr() {
        return backgroundImgIdStr;
    }

    public void setBackgroundImgIdStr(String backgroundImgIdStr) {
        this.backgroundImgIdStr = backgroundImgIdStr;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDjStatus() {
        return djStatus;
    }

    public void setDjStatus(int djStatus) {
        this.djStatus = djStatus;
    }

    public ExpertBean getExperts() {
        return experts;
    }

    public void setExperts(ExpertBean experts) {
        this.experts = experts;
    }

    public boolean isUtual() {
        return mutual;
    }

    public void setUtual(boolean utual) {
        mutual = utual;
    }

    public Object getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(Object remarkName) {
        this.remarkName = remarkName;
    }

    public Object getExpertTags() {
        return expertTags;
    }

    public void setExpertTags(Object expertTags) {
        this.expertTags = expertTags;
    }

    public int getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }

    public long getAvatarImgId() {
        return avatarImgId;
    }

    public void setAvatarImgId(long avatarImgId) {
        this.avatarImgId = avatarImgId;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public long getBackgroundImgId() {
        return backgroundImgId;
    }

    public void setBackgroundImgId(long backgroundImgId) {
        this.backgroundImgId = backgroundImgId;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public boolean isDefaultAvatar() {
        return defaultAvatar;
    }

    public void setDefaultAvatar(boolean defaultAvatar) {
        this.defaultAvatar = defaultAvatar;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVipType() {
        return vipType;
    }

    public void setVipType(int vipType) {
        this.vipType = vipType;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getAvatarImgId_str() {
        return avatarImgId_str;
    }

    public void setAvatarImgId_str(String avatarImgId_str) {
        this.avatarImgId_str = avatarImgId_str;
    }

    public int getFolloweds() {
        return followeds;
    }

    public void setFolloweds(int followeds) {
        this.followeds = followeds;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public int getPlaylistCount() {
        return playlistCount;
    }

    public void setPlaylistCount(int playlistCount) {
        this.playlistCount = playlistCount;
    }

    public int getPlaylistBeSubscribedCount() {
        return playlistBeSubscribedCount;
    }

    public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
        this.playlistBeSubscribedCount = playlistBeSubscribedCount;
    }

    @Override
    public String toString() {
        return "ProfileBean{" +
                "avatarImgIdStr='" + avatarImgIdStr + '\'' +
                ", backgroundImgIdStr='" + backgroundImgIdStr + '\'' +
                ", followed=" + followed +
                ", backgroundUrl='" + backgroundUrl + '\'' +
                ", detailDescription='" + detailDescription + '\'' +
                ", description='" + description + '\'' +
                ", djStatus=" + djStatus +
                ", experts=" + experts +
                ", mutual=" + mutual +
                ", remarkName=" + remarkName +
                ", expertTags=" + expertTags +
                ", authStatus=" + authStatus +
                ", avatarImgId=" + avatarImgId +
                ", birthday=" + birthday +
                ", nickname='" + nickname + '\'' +
                ", city=" + city +
                ", userType=" + userType +
                ", backgroundImgId=" + backgroundImgId +
                ", province=" + province +
                ", defaultAvatar=" + defaultAvatar +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", userId=" + userId +
                ", vipType=" + vipType +
                ", gender=" + gender +
                ", accountStatus=" + accountStatus +
                ", signature='" + signature + '\'' +
                ", authority=" + authority +
                ", avatarImgId_str='" + avatarImgId_str + '\'' +
                ", followeds=" + followeds +
                ", follows=" + follows +
                ", eventCount=" + eventCount +
                ", playlistCount=" + playlistCount +
                ", playlistBeSubscribedCount=" + playlistBeSubscribedCount +
                '}';
    }
}
