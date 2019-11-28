package me.sofiworker.easemusic.main;

import me.sofiworker.easemusic.base.IBasePresenter;
import me.sofiworker.easemusic.base.IBaseView;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/28 22:47
 * @description 主页面的契约接口
 */
public interface MainContract {

    interface View extends IBaseView{

    }

    interface Presenter extends IBasePresenter<View> {

    }
}
