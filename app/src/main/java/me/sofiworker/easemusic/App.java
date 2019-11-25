package me.sofiworker.easemusic;

import android.app.Application;
import android.os.Handler;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/25 21:14
 * @description application实现类
 */
public class App extends Application {

    private static Handler sHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        sHandler = new Handler();
    }

    public static Handler getsHandler() {
        return sHandler;
    }
}
