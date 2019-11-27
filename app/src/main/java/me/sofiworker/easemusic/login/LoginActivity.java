package me.sofiworker.easemusic.login;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.R2;
import me.sofiworker.easemusic.base.BaseActivity;
import me.sofiworker.easemusic.util.StrUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/27 20:27
 * @description 登录活动
 */
public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {

    private static final String TAG = "LoginActivity";

    @BindView(R.id.et_login_username)
    EditText mUserNameEt;
    @BindView(R.id.et_login_password)
    EditText mPasswordEt;
    @BindView(R.id.btn_login)
    Button mLoginBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEvent() {
        mPresenter = new LoginPresenter();
//        mLoginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickEvent();
//            }
//        });
    }

    @OnClick(R.id.btn_login)
    void clickEvent(){
        if (!StrUtil.isBlank(mUserNameEt.getText().toString(), mPasswordEt.getText().toString())){
            Map<String, String> userInfo = new HashMap<>(16);
            userInfo.put("phone", mUserNameEt.getText().toString());
            userInfo.put("password", mPasswordEt.getText().toString());
            mPresenter.postLoginInfo(userInfo);
        }
    }

    @Override
    public void showResult() {

    }
}
