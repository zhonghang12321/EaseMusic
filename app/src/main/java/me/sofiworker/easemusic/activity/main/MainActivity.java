package me.sofiworker.easemusic.activity.main;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.lucode.hackware.magicindicator.MagicIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.activity.login.LoginActivity;
import me.sofiworker.easemusic.base.BaseActivity;
import me.sofiworker.easemusic.base.BaseFragment;
import me.sofiworker.easemusic.fragment.found.FoundFragment;
import me.sofiworker.easemusic.fragment.me.MeFragment;
import me.sofiworker.easemusic.util.IndicatorUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/26 22:30
 * @description 主活动
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    private static final String TAG = "MainActivity";
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
    @BindView(R.id.tv_main_lv)
    TextView mLvTv;
    @BindView(R.id.tv_main_sign)
    TextView mSignTv;
    public static final int LOGIN_REQUEST = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEvent() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this, mProvider);

        List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MeFragment());
        fragmentList.add(new FoundFragment());

        IndicatorUtil.combineFv(this, getSupportFragmentManager(),
                mIndicatorView, mMainVp, R.array.main_mi_title, fragmentList);
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == LoginActivity.LOGIN_RESULT && requestCode == LOGIN_REQUEST && data != null) {
            String result = data.getStringExtra("isLoginSuccess");
            String str = "LoginSuccess";
            if (str.equals(result)) {
                mPresenter.loadProfile();
                mLvTv.setVisibility(View.VISIBLE);
                mSignTv.setVisibility(View.VISIBLE);
            }
        }
    }

    @OnClick(R.id.civ_head)
    void login(){
        startActivityForResult(new Intent(this, LoginActivity.class), LOGIN_REQUEST);
//        if (mPresenter.isLogin()) {
//        }else {
//            ToastUtil.showShort("已经登录过了，别再点人家了＞﹏＜");
//        }
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
        if (!TextUtils.isEmpty(nickName)) {
            mNickNameTv.setText(nickName);
        }
        if (!TextUtils.isEmpty(headImgUrl)) {
            Glide.with(this).load(headImgUrl).into(mHeadCiv);
        }
    }
}
