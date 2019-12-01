package me.sofiworker.easemusic.activity.localmusic;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.adapter.IndicatorAdapter;
import me.sofiworker.easemusic.base.BaseActivity;
import me.sofiworker.easemusic.base.BaseFragment;
import me.sofiworker.easemusic.fragment.found.FoundFragment;
import me.sofiworker.easemusic.fragment.me.MeFragment;
import me.sofiworker.easemusic.fragment.single.SingleFragment;
import me.sofiworker.easemusic.util.IndicatorUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 15:15
 * @description 本地音乐活动
 */
public class LocalMusicActivity extends BaseActivity<LocalMusicPresenter> implements LocalMusicContract.View {

    @BindView(R.id.mi_common)
    MagicIndicator mLocalMusicMi;
    @BindView(R.id.vp_common)
    ViewPager mCommonVp;
    @BindView(R.id.iv_toolbar_back)
    ImageView mBackIv;

    @OnClick(R.id.iv_toolbar_back)
    void click(){
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_local_music;
    }

    @Override
    protected void initEvent() {
        mPresenter = new LocalMusicPresenter();
        mPresenter.attachView(this, mProvider);

        List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(new SingleFragment());
        IndicatorUtil.combineFv(this, getSupportFragmentManager(), mLocalMusicMi,
                mCommonVp, R.array.local_music_mi_title, fragmentList);
    }
}
