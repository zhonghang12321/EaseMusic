package me.sofiworker.easemusic.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/28 20:10
 * @description SharedPreferences工具类
 */
public class SpUtil {


    public static String getStr(Context context, String spName, String spKey){
        SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getString(spKey, "");
    }
}
