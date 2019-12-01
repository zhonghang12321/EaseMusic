package me.sofiworker.easemusic.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import me.sofiworker.easemusic.App;
import me.sofiworker.easemusic.R;

public abstract class UiLoader extends FrameLayout {

    private static final String TAG = "UiLoader";
    private View mLoadingView;
    private View mSuccessView;
    private View mNoNetWorkView;
    private View mEmptyView;


    public enum UiStatus {
        LOADING, SUCCESS, NETWORK_ERROR, EMPTY, NONE
    }

    public UiStatus mCurrentStatus = UiStatus.NONE;

    public UiLoader(@NonNull Context context) {
        this(context, null);
    }

    public UiLoader(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
    }

    public UiLoader(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void updateStatus(UiStatus status){
        mCurrentStatus = status;
        App.getHandler().post(this::switchUiByCurrentStatus);
    }

    private void init() {
        switchUiByCurrentStatus();
    }

    private void switchUiByCurrentStatus() {
        if (mLoadingView == null) {
            mLoadingView = getLoadingView();
            addView(mLoadingView);
        }
        mLoadingView.setVisibility(mCurrentStatus == UiStatus.LOADING ? VISIBLE : GONE);

        if (mSuccessView == null) {
            mSuccessView = getSuccessView(this);
            addView(mSuccessView);
        }
        mSuccessView.setVisibility(mCurrentStatus == UiStatus.SUCCESS ? VISIBLE : GONE);

        if (mNoNetWorkView == null) {
            mNoNetWorkView = getNoNetWorkView();
            addView(mNoNetWorkView);
        }
        mNoNetWorkView.setVisibility(mCurrentStatus == UiStatus.NETWORK_ERROR ? VISIBLE : GONE);

        if (mEmptyView == null) {
            mEmptyView = getEmptyView();
            addView(mEmptyView);
        }
        mEmptyView.setVisibility(mCurrentStatus == UiStatus.EMPTY ? VISIBLE : GONE);
    }

    private View getEmptyView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_empty, this, false);
    }

    private View getNoNetWorkView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_error, this, false);
    }

    private View getLoadingView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_loading, this, false);
    }

    protected abstract View getSuccessView(ViewGroup container);
}
