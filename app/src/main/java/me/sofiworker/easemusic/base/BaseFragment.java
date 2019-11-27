package me.sofiworker.easemusic.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.sofiworker.easemusic.App;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.UILoader;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/25 20:40
 * @description fragment基类
 */
public abstract class BaseFragment extends Fragment implements IBaseView{

    private UILoader mUiLoader;
    private ProgressDialog mProgressDialog;
    private Toast mToast;
    protected IBasePresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mUiLoader == null) {
            mUiLoader = new UILoader(getContext()) {
                @Override
                protected View getSuccessView(ViewGroup container) {
                    return LayoutInflater.from(container.getContext()).inflate(getLayoutId(), container, false);
                }
            };
        }
        mUiLoader.updateStatus(UILoader.UIStatus.SUCCESS);
        return mUiLoader;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initEvent();
    }

    abstract int getLayoutId();

    protected abstract void initEvent();

    protected void showLoading(String msg){
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getContext());
        }
        mProgressDialog.setTitle(getString(R.string.prompt));
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    protected void dismissLoading(){
        if (mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    protected void showToast(String msg){
        if (mToast == null) {
            mToast = new Toast(getContext());
        }
        mToast.setText(msg);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    protected void showNoNetwork(){
        if (mUiLoader != null) {
            mUiLoader.updateStatus(UILoader.UIStatus.NETWORK_ERROR);
        }
    }

    protected void showEmpty(){
        if (mUiLoader != null) {
            mUiLoader.updateStatus(UILoader.UIStatus.EMPTY);
        }
    }
}
