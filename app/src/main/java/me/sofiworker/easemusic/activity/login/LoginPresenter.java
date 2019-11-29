package me.sofiworker.easemusic.activity.login;

import java.util.Map;

import me.sofiworker.easemusic.base.BaseObserver;
import me.sofiworker.easemusic.base.BasePresenter;
import me.sofiworker.easemusic.bean.UserBean;
import me.sofiworker.easemusic.util.RetrofitUtil;
import me.sofiworker.easemusic.util.RxUtil;
import me.sofiworker.easemusic.util.ToastUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/27 21:23
 * @description 登录presenter
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private static final String TAG = "LoginPresenter";
    private LoginModel mModel;

    public LoginPresenter(){
        mModel = new LoginModel();
    }

    @Override
    public void postLoginInfo(Map<String, String> userInfo) {
        mView.showLoading(null);
        RetrofitUtil.getApiService().userLogin(userInfo)
                .compose(RxUtil.transform(mProvider))
                .subscribe(new BaseObserver<UserBean>() {
                    @Override
                    protected void onSuccess(UserBean userBean) {
                        int successCode = 200;
                        if (userBean != null && userBean.getCode() == successCode) {
                            mModel.saveLoginUserInfo(userBean);
                        }else {
                            ToastUtil.showShort("登录失败！");
                        }
                    }
                });
    }
}
