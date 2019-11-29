package me.sofiworker.easemusic.bean;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 22:30
 * @description TODO
 */
public class ListBean {


    /**
     * more : false
     * playlist : [{"subscribers":[],"subscribed":false,"creator":{"defaultAvatar":false,"province":510000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/D8Dx-lTIJgSggLHXO8qODA==/109951164514223745.jpg","accountStatus":0,"gender":0,"city":510100,"birthday":-2209017600000,"userId":2057827929,"userType":0,"nickname":"CK哈哈哈hh","signature":"","description":"","detailDescription":"","avatarImgId":109951164514223740,"backgroundImgId":109951162868128400,"backgroundUrl":"http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164514223745","backgroundImgIdStr":"109951162868128395","avatarImgId_str":"109951164514223745"},"artists":null,"tracks":null,"updateFrequency":null,"backgroundCoverId":0,"backgroundCoverUrl":null,"titleImage":0,"titleImageUrl":null,"englishTitle":null,"opRecommend":false,"recommendInfo":null,"trackNumberUpdateTime":1575037753992,"adType":0,"subscribedCount":0,"cloudTrackCount":0,"createTime":1574859296756,"highQuality":false,"privacy":0,"trackUpdateTime":1575037753992,"userId":2057827929,"coverImgId":18898405858720120,"updateTime":1575037753992,"newImported":false,"anonimous":false,"totalDuration":0,"coverImgUrl":"https://p1.music.126.net/0o_XoKHVRPRYHtbsIYA3tw==/18898405858720122.jpg","specialType":5,"trackCount":2,"commentThreadId":"A_PL_0_3093882280","playCount":0,"tags":[],"ordered":false,"description":null,"status":0,"name":"CK哈哈哈hh喜欢的音乐","id":3093882280,"coverImgId_str":"18898405858720122"},{"subscribers":[],"subscribed":true,"creator":{"defaultAvatar":false,"province":110000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/tP-qlzlcEUAIMCGKwTJatQ==/109951163454220704.jpg","accountStatus":0,"gender":2,"city":110101,"birthday":781632000000,"userId":1430992951,"userType":200,"nickname":"献给莉莉的玫瑰","signature":"夏の名前おしえて","description":"","detailDescription":"","avatarImgId":109951163454220700,"backgroundImgId":109951163455988510,"backgroundUrl":"http://p1.music.126.net/27Jj-JaPlE7sU7t9kGRRqw==/109951163455988509.jpg","authority":0,"mutual":false,"expertTags":["华语","流行"],"experts":null,"djStatus":0,"vipType":11,"remarkName":null,"avatarImgIdStr":"109951163454220704","backgroundImgIdStr":"109951163455988509","avatarImgId_str":"109951163454220704"},"artists":null,"tracks":null,"updateFrequency":null,"backgroundCoverId":0,"backgroundCoverUrl":null,"titleImage":0,"titleImageUrl":null,"englishTitle":null,"opRecommend":false,"recommendInfo":null,"trackNumberUpdateTime":1574910251039,"adType":0,"subscribedCount":40271,"cloudTrackCount":0,"createTime":1571897575929,"highQuality":false,"privacy":0,"trackUpdateTime":1574983497586,"userId":1430992951,"coverImgId":109951164512282130,"updateTime":1574910251039,"newImported":false,"anonimous":false,"totalDuration":0,"coverImgUrl":"https://p1.music.126.net/5QFcjI4QFjDhsTQ70De5DQ==/109951164512282125.jpg","specialType":0,"trackCount":33,"commentThreadId":"A_PL_0_3042852466","playCount":3132277,"tags":["华语","清新","治愈"],"ordered":true,"description":"电影里说\n诗，美，浪漫，爱\n这些才是我们生存的原因\n\n正因为这样\n我们才会孜孜不倦地赞美爱吧\n才会说\n爱你不是两三天\n爱你三千次也不嫌累\n\n原来爱和浪漫\n是我们的本能啊\n\n封面来自网络","status":0,"name":"温柔止痛剂 | 浪漫才是我们的本能","id":3042852466,"coverImgId_str":"109951164512282125"}]
     * code : 200
     */

    private boolean more;
    private int code;
    private List<PlaylistBean> playlist;

    public static class PlaylistBean {

        private boolean subscribed;
        private CreatorBean creator;
        private Object artists;
        private Object tracks;
        private Object updateFrequency;
        private int backgroundCoverId;
        private Object backgroundCoverUrl;
        private int titleImage;
        private Object titleImageUrl;
        private Object englishTitle;
        private boolean opRecommend;
        private Object recommendInfo;
        private long trackNumberUpdateTime;
        private int adType;
        private int subscribedCount;
        private int cloudTrackCount;
        private long createTime;
        private boolean highQuality;
        private int privacy;
        private long trackUpdateTime;
        private int userId;
        private long coverImgId;
        private long updateTime;
        private boolean newImported;
        private boolean anonimous;
        private int totalDuration;
        private String coverImgUrl;
        private int specialType;
        private int trackCount;
        private String commentThreadId;
        private int playCount;
        private boolean ordered;
        private Object description;
        private int status;
        private String name;
        private long id;
        private String coverImgId_str;
        private List<?> subscribers;
        private List<?> tags;

        public static class CreatorBean {

            private boolean defaultAvatar;
            private int province;
            private int authStatus;
            private boolean followed;
            private String avatarUrl;
            private int accountStatus;
            private int gender;
            private int city;
            private long birthday;
            private int userId;
            private int userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private int authority;
            private boolean mutual;
            private Object expertTags;
            private Object experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private String avatarImgIdStr;
            private String backgroundImgIdStr;
            private String avatarImgId_str;
        }
    }
}
