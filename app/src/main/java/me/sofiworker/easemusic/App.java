package me.sofiworker.easemusic;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Handler;

import me.sofiworker.easemusic.util.SpUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/25 21:14
 * @description application实现类
 */
public class App extends Application {

    private static Handler sHandler;
    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    @Override
    public void onCreate() {
        sHandler = new Handler();
        sContext = getApplicationContext();
        super.onCreate();
    }

    public static Handler getHandler() {
        return sHandler;
    }

    public static Context getContext(){
        return sContext;
    }
}
