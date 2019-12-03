package me.sofiworker.easemusic.service;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserServiceCompat;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/3 18:42
 * @description 音乐后台播放服务
 */
public class PlayService extends MediaBrowserServiceCompat {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String s, int i, @Nullable Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadChildren(@NonNull String s, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {

    }
}
