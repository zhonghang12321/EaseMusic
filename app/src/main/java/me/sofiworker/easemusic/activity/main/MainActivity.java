package me.sofiworker.easemusic.activity.main;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.adapter.IndicatorAdapter;
import me.sofiworker.easemusic.adapter.MainContentAdapter;
import me.sofiworker.easemusic.base.BaseActivity;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/26 22:30
 * @description 主活动
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.mi_main)
    MagicIndicator mIndicatorView;
    @BindView(R.id.vp_main)
    ViewPager mMainVp;
    @BindView(R.id.nav_main)
    NavigationView mMainNav;
    @BindView(R.id.iv_menu)
    ImageView mMenuIv;
    @BindView(R.id.dl_main)
    DrawerLayout mMainDl;
    @BindView(R.id.civ_head)
    CircleImageView mHeadCiv;
    @BindView(R.id.tv_nick_name)
    TextView mNickNameTv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEvent() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this, mProvider);

        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new IndicatorAdapter(this));
        commonNavigator.setAdjustMode(true);
        mIndicatorView.setNavigator(commonNavigator);

        FragmentManager fm = getSupportFragmentManager();
        MainContentAdapter contentAdapter = new MainContentAdapter(fm);
        mMainVp.setAdapter(contentAdapter);

        ViewPagerHelper.bind(mIndicatorView, mMainVp);
    }

    @OnClick(R.id.iv_menu)
    void menuClick(){
        if (!mMainDl.isDrawerOpen(Gravity.START)) {
            //加载侧边栏信息
            mPresenter.loadProfile();
            mMainDl.openDrawer(Gravity.START);
        }
    }

    @Override
    public void onBackPressed() {
        if (mMainDl.isDrawerOpen(Gravity.START)) {
            mMainDl.closeDrawer(Gravity.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public void showNavProfile(String nickName, String headImgUrl) {
        mNickNameTv.setText(nickName);
        Glide.with(this).load(headImgUrl).into(mHeadCiv);
    }
}
