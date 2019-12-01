package me.sofiworker.easemusic.activity.login;

import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.activity.main.MainActivity;
import me.sofiworker.easemusic.base.BaseActivity;
import me.sofiworker.easemusic.util.StrUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/27 20:27
 * @description 登录活动
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    private static final String TAG = "LoginActivity";

    @BindView(R.id.et_login_username)
    EditText mUserNameEt;
    @BindView(R.id.et_login_password)
    EditText mPasswordEt;
    @BindView(R.id.btn_login)
    Button mLoginBtn;
    public static final int LOGIN_RESULT = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEvent() {
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this, mProvider);
    }

    @OnClick(R.id.btn_login)
    void clickEvent(){
        if (!TextUtils.isEmpty(mUserNameEt.getText().toString()) && !TextUtils.isEmpty(mPasswordEt.getText().toString())){
            Map<String, String> userInfo = new HashMap<>(16);
            userInfo.put("phone", mUserNameEt.getText().toString());
            userInfo.put("password", mPasswordEt.getText().toString());
            mPresenter.postLoginInfo(userInfo);
        }else {
            showToast("请输入正确的账号/密码");
        }
    }

    @Override
    public void isLoginSuccess(boolean isTrue) {
        if (isTrue) {
            Intent intent = new Intent();
            intent.putExtra("isLoginSuccess", "LoginSuccess");
            setResult(LOGIN_RESULT, intent);
            finish();
        }
    }
}
