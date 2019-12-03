package me.sofiworker.easemusic.activity.login;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import me.sofiworker.easemusic.App;
import me.sofiworker.easemusic.Constants;
import me.sofiworker.easemusic.bean.UserBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/28 20:22
 * @description login的model
 */
class LoginModel {


    private static final String TAG = "LoginModel";

    void saveLoginUserInfo(UserBean user){
        Constants.LOGIN_STATUS = true;
//        SharedPreferences sp = App.getContext().getSharedPreferences("isLogin", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putBoolean("isLogin", true).apply();
        spSave("accountBean", "account", user.getAccount());
        spSave("profileBean", "profile", user.getProfile());
        spSave("bindingBean", "bindings", user.getBindings());
    }

    private void spSave(String spName, String spKey, Object o){
        Gson gson = new Gson();
        SharedPreferences sp = App.getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(spKey, gson.toJson(o)).apply();
    }
}
