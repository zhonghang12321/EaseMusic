package me.sofiworker.easemusic.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/3 18:42
 * @description 音乐后台播放服务
 */
public class PlayService extends Service {

    private static PlayService sPlayService;
    private SimpleExoPlayer mPlayer = getInstance();

    private PlayService(){}

//    public static PlayService getInstance(){
//        if (sPlayService == null) {
//            synchronized (PlayService.class){
//                if (sPlayService == null) {
//                    sPlayService = new PlayService();
//                }
//            }
//        }
//        return sPlayService;
//    }

    private SimpleExoPlayer getInstance(){
//        if (mPlayer == null) {
//
//        }
        return null;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
