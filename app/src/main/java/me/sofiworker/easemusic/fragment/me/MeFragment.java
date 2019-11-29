package me.sofiworker.easemusic.fragment.me;


import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.base.BaseFragment;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 12:33
 * @description “我的”碎片
 */
public class MeFragment extends BaseFragment<MePresenter> implements MeContract.View {

    @BindView(R.id.rv_me)
    RecyclerView mMeRv;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initEvent() {
        mPresenter = new MePresenter();
        mPresenter.attachView(this, mProvider);

        initRecycler();
    }

    private void initRecycler() {

    }
}
