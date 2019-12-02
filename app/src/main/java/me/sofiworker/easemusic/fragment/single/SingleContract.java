package me.sofiworker.easemusic.fragment.single;

import android.content.Context;
import android.provider.MediaStore;

import java.util.List;

import me.sofiworker.easemusic.base.IBasePresenter;
import me.sofiworker.easemusic.base.IBaseView;
import me.sofiworker.easemusic.bean.LocalSongBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 22:03
 * @description single的契约接口
 */
class SingleContract {

    interface View extends IBaseView {
        void getMusicList(List<LocalSongBean> songList);
    }

    interface Presenter extends IBasePresenter<View> {
        void setContext(Context context);
        void getLocalMusicList();
    }

    interface Model {
        List<?> scanLocalAudio();
    }
}
