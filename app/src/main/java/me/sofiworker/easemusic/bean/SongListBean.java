package me.sofiworker.easemusic.bean;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 22:33
 * @description “我的”页面中歌单列表bean
 */
public class SongListBean {

    private boolean more;
    private int code;
    private List<PlaylistBean> playlist;

    public boolean isOre() {
        return more;
    }

    public void setOre(boolean ore) {
        more = ore;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<PlaylistBean> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<PlaylistBean> playlist) {
        this.playlist = playlist;
    }

    @Override
    public String toString() {
        return "SongListBean{" +
                "more=" + more +
                ", code=" + code +
                ", playlist=" + playlist +
                '}';
    }
}
