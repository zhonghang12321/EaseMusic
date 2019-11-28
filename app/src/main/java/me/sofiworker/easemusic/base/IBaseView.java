package me.sofiworker.easemusic.base;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/25 20:53
 * @description view接口
 */
public interface IBaseView {

    void showLoading(String msg);
    void dismissLoading();
    void showToast(String msg);
    void showNoNetwork();
    void showEmpty();
}
