package me.sofiworker.easemusic.fragment.me;

import me.sofiworker.easemusic.base.IBasePresenter;
import me.sofiworker.easemusic.base.IBaseView;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 12:41
 * @description “我的”契约接口
 */
public interface MeContract {

    interface View extends IBaseView{

    }

    interface Presenter extends IBasePresenter<View> {

    }
}
