package me.sofiworker.easemusic.activity.main;

import com.google.gson.Gson;

import me.sofiworker.easemusic.App;
import me.sofiworker.easemusic.bean.ProfileBean;
import me.sofiworker.easemusic.util.SpUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 20:24
 * @description 主活动的model层
 */
public class MainModel {

    public ProfileBean getProfile(){
        String str = SpUtil.getStr(App.getContext(), "profileBean", "profile");
        if (!"".equals(str)) {
            Gson gson = new Gson();
            return gson.fromJson(str, ProfileBean.class);
        }else {
            return null;
        }
    }
}
