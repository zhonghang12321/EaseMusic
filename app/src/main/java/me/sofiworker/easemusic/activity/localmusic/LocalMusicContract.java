package me.sofiworker.easemusic.activity.localmusic;

import me.sofiworker.easemusic.base.IBasePresenter;
import me.sofiworker.easemusic.base.IBaseView;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 15:58
 * @description 本地音乐契约接口
 */
public interface LocalMusicContract {

    interface View extends IBaseView{

    }

    interface Presenter extends IBasePresenter<View> {

    }
}
