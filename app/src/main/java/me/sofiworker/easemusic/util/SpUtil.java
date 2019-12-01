package me.sofiworker.easemusic.util;

import android.content.Context;
import android.content.SharedPreferences;

import me.sofiworker.easemusic.App;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/28 20:10
 * @description SharedPreferences工具类
 */
public class SpUtil {

    public static void putStr(String spName, String spKey, String str){
        SharedPreferences sp = App.getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(spKey, str).apply();
    }

    public static String getStr(Context context, String spName, String spKey){
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getString(spKey, "");
    }
}
