package me.sofiworker.easemusic.base;

import android.arch.lifecycle.Lifecycle;

import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/25 20:53
 * @description presenter基接口
 */
public interface IBasePresenter<T extends IBaseView> {

    void attachView(T view, LifecycleProvider<Lifecycle.Event> provider);

    void detachView();
}
