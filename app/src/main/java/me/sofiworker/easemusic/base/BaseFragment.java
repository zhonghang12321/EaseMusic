package me.sofiworker.easemusic.base;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle2.LifecycleProvider;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.sofiworker.easemusic.view.UiLoader;
import me.sofiworker.easemusic.util.DialogUtil;
import me.sofiworker.easemusic.util.ToastUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/25 20:40
 * @description fragment基类
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements IBaseView{

    private UiLoader mUiLoader;
    private Unbinder mBind;
    protected T mPresenter;
    protected final LifecycleProvider<Lifecycle.Event> mProvider
            = AndroidLifecycle.createLifecycleProvider(this);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mUiLoader == null) {
            mUiLoader = new UiLoader(getContext()) {
                @Override
                protected View getSuccessView(ViewGroup container) {
                    return LayoutInflater.from(container.getContext()).inflate(getLayoutId(), container, false);
                }
            };
        }
        mUiLoader.updateStatus(UiLoader.UiStatus.SUCCESS);
        return mUiLoader;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mBind = ButterKnife.bind(this, view);
        initEvent();
    }

    @Override
    public void onDetach() {
        if (mBind != null){
            mBind.unbind();
        }
        super.onDetach();
    }

    protected abstract int getLayoutId();

    protected abstract void initEvent();

    @Override
    public void showLoading(String msg){
        DialogUtil.showProgressDialog(getContext(), msg);
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
            mUiLoader.updateStatus(UiLoader.UiStatus.NETWORK_ERROR);
        }
    }

    @Override
    public void showEmpty(){
        if (mUiLoader != null) {
            mUiLoader.updateStatus(UiLoader.UiStatus.EMPTY);
        }
    }
}
