package me.sofiworker.easemusic.base;

import android.arch.lifecycle.Lifecycle;

import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle2.LifecycleProvider;

import me.sofiworker.easemusic.Api;
import me.sofiworker.easemusic.util.RetrofitUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/26 22:22
 * @description presenter基类
 */
public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    protected T mView;
    protected final Api mApi = RetrofitUtil.getInstance();
    protected LifecycleProvider<Lifecycle.Event> mProvider;

    @Override
    public void attachView(T view, LifecycleProvider<Lifecycle.Event> provider) {
        this.mProvider = provider;
        this.mView = view;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}
