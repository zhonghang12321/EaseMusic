package me.sofiworker.easemusic.fragment.me;

import java.util.List;

import me.sofiworker.easemusic.base.IBasePresenter;
import me.sofiworker.easemusic.base.IBaseView;
import me.sofiworker.easemusic.bean.PlaylistBean;
import me.sofiworker.easemusic.bean.SongListBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 12:41
 * @description “我的”契约接口
 */
public interface MeContract {

    interface View extends IBaseView{
        void transportSongList(List<PlaylistBean> songList);
    }

    interface Presenter extends IBasePresenter<View> {
        void getPlayList();
        String loginUserName();
    }

    interface Model {
        int getUserUid();
        void savePlayList(SongListBean songListBean);
        String getUserName();
        SongListBean getCacheList();
    }
}
