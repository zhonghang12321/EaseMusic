package me.sofiworker.easemusic.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.UILoader;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/25 20:37
 * @description 活动基类
 */
public abstract class BaseActivity<T> extends AppCompatActivity implements IBaseView{

    private UILoader mUiLoader;
    private ProgressDialog mProgressDialog;
    private Toast mToast;
    protected T mPresenter;
    private Unbinder mBind;

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

    protected abstract void initEvent();

    protected void showLoading(String msg){
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
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
            mToast = new Toast(this);
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

    @Override
    protected void onDestroy() {
        if (mBind != null){
            mBind.unbind();
        }
        super.onDestroy();
    }
}
