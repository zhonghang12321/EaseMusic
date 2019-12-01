package me.sofiworker.easemusic.activity.main;

import me.sofiworker.easemusic.base.BasePresenter;
import me.sofiworker.easemusic.bean.ProfileBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/28 22:48
 * @description 主页面的presenter
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainModel mModel;

    MainPresenter(){
        mModel = new MainModel();
    }

    @Override
    public void loadProfile() {
        ProfileBean profileBean = mModel.getProfile();
        if (profileBean != null){
            mView.showNavProfile(profileBean.getNickname(), profileBean.getAvatarUrl());
        }else {
            mView.showNavProfile("", "");
        }
    }

    @Override
    public boolean isLogin() {
        return mModel.getProfile() != null;
    }
}
