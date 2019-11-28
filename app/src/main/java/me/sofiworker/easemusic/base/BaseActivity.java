package me.sofiworker.easemusic.base;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle2.LifecycleProvider;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.sofiworker.easemusic.UILoader;
import me.sofiworker.easemusic.util.DialogUtil;
import me.sofiworker.easemusic.util.ToastUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/25 20:37
 * @description 活动基类
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity
        implements IBaseView{

    private UILoader mUiLoader;
    protected T mPresenter;
    private Unbinder mBind;
    protected final LifecycleProvider<Lifecycle.Event> mProvider
            = AndroidLifecycle.createLifecycleProvider(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mUiLoader == null){
            mUiLoader = new UILoader(this) {
                @Override
                protected View getSuccessView(ViewGroup container) {
                    return LayoutInflater.from(getContext()).inflate(getLayoutId(), container, false);
                }
            };
        }
        mUiLoader.updateStatus(UILoader.UIStatus.SUCCESS);
        setContentView(mUiLoader);

        initEvent();
        mBind = ButterKnife.bind(this);
    }

    /**
     * 获取layout的id
     * @return layout的id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化函数
     */
    protected abstract void initEvent();

    @Override
    public void showLoading(String msg){
        DialogUtil.showProgressDialog(this, msg);
    }

    @Override
    public void dismissLoading(){
        DialogUtil.dismissProgressDialog();
    }

    @Override
    public void showToast(String msg){
        ToastUtil.showShort(msg);
    }

    @Override
    public void showNoNetwork(){
        if (mUiLoader != null) {
            mUiLoader.updateStatus(UILoader.UIStatus.NETWORK_ERROR);
        }
    }

    @Override
    public void showEmpty(){
        if (mUiLoader != null) {
            mUiLoader.updateStatus(UILoader.UIStatus.EMPTY);
        }
    }

    @Override
    protected void onDestroy() {
        if (mBind != null){
            mBind.unbind();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}
