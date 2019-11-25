package me.sofiworker.easemusic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class UILoader extends FrameLayout {

    private View mLoadingView;
    private View mSuccessView;
    private View mNoNetWorkView;
    private View mEmptyView;
    private OnRetryClickListener mOnRetryClickListener;

    public enum UIStatus {
        LOADING, SUCCESS, NETWORK_ERROR, EMPTY, NONE
    }

    public UIStatus mCurrentStatus = UIStatus.NONE;

    public UILoader(@NonNull Context context) {
        this(context, null);
    }

    public UILoader(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
    }

    public UILoader(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void updateStatus(UIStatus status){
        mCurrentStatus = status;
        App.getsHandler().post(new Runnable() {
            @Override
            public void run() {
                switchUiByCurrentStatus();
            }
        });
    }

    private void init() {
        switchUiByCurrentStatus();
    }

    private void switchUiByCurrentStatus() {
        if (mLoadingView == null) {
            mLoadingView = getLoadingView();
            addView(mLoadingView);
        }
        mLoadingView.setVisibility(mCurrentStatus == UIStatus.LOADING ? VISIBLE : GONE);

        if (mSuccessView == null) {
            mSuccessView = getSuccessView(this);
            addView(mSuccessView);
        }
        mSuccessView.setVisibility(mCurrentStatus == UIStatus.SUCCESS ? VISIBLE : GONE);

        if (mNoNetWorkView == null) {
            mNoNetWorkView = getNoNetWorkView();
            addView(mNoNetWorkView);
        }
        mNoNetWorkView.setVisibility(mCurrentStatus == UIStatus.NETWORK_ERROR ? VISIBLE : GONE);

        if (mEmptyView == null) {
            mEmptyView = getEmptyView();
            addView(mEmptyView);
        }
        mEmptyView.setVisibility(mCurrentStatus == UIStatus.EMPTY ? VISIBLE : GONE);
    }

    private View getEmptyView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_empty, this, false);
    }

    private View getNoNetWorkView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_error, this, false);
//        view.findViewById(R.id.rl_error).setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mOnRetryClickListener != null) {
//                    mOnRetryClickListener.onRetryClick();
//                }
//            }
//        });
        return view;
    }

    private View getLoadingView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_loading, this, false);
    }

    protected abstract View getSuccessView(ViewGroup container);

    public void setOnRetryClickListener(OnRetryClickListener listener){
        this.mOnRetryClickListener = listener;
    }

    public interface OnRetryClickListener {
        void onRetryClick();
    }
}
