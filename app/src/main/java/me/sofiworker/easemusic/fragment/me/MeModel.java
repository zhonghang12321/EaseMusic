package me.sofiworker.easemusic.fragment.me;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import me.sofiworker.easemusic.App;
import me.sofiworker.easemusic.bean.AccountBean;
import me.sofiworker.easemusic.bean.ProfileBean;
import me.sofiworker.easemusic.bean.PlaylistBean;
import me.sofiworker.easemusic.bean.SongListBean;
import me.sofiworker.easemusic.util.SpUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/30 18:33
 * @description “我的”页面的model层
 */
public class MeModel implements MeContract.Model {

    private static final String TAG = "MeModel";

    @Override
    public int getUserUid(){
        String accountStr = SpUtil.getStr(App.getContext(), "accountBean", "account");
        if (!TextUtils.isEmpty(accountStr)) {
            return new Gson().fromJson(accountStr, AccountBean.class).getId();
        }else {
            return 0;
        }
    }

    @Override
    public void savePlayList(SongListBean listBean) {
        if (listBean != null) {
            SharedPreferences sp = App.getContext().getSharedPreferences("songListBean", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("songList", new Gson().toJson(listBean)).apply();
        }
    }

    @Override
    public String getUserName() {
        String profileStr = SpUtil.getStr(App.getContext(), "profileBean", "profile");
        return new Gson().fromJson(profileStr, ProfileBean.class).getNickname();
    }

    @Override
    public SongListBean getCacheList() {
        String songListStr = SpUtil.getStr(App.getContext(), "songListBean", "songList");
        Log.d(TAG, "getCacheList: "+songListStr);
        if (!TextUtils.isEmpty(songListStr)) {
            return new Gson().fromJson(songListStr, SongListBean.class);
        }
        return null;
    }
}
