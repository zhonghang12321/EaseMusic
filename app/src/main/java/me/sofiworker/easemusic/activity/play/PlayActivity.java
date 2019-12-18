package me.sofiworker.easemusic.activity.play;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import butterknife.BindView;
import butterknife.OnClick;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.base.BaseActivity;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/5 13:51
 * @description 播放活动
 */
public class PlayActivity extends BaseActivity {

    @BindView(R.id.btn_play_pre_song)
    Button mPreSongBtn;
    @BindView(R.id.btn_play_start_or_pause_play)
    Button mPauseBtn;
    @BindView(R.id.btn_play_next_song)
    Button mNextSong;
    private SimpleExoPlayer mPlayer;
    private static int PLAY_FLAG = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_play;
    }

    @Override
    protected void initEvent() {
        Intent intent = getIntent();
        String uri = intent.getStringExtra("SongUri");
        mPlayer = ExoPlayerFactory.newSimpleInstance(this);
        // Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "EaseMusic"));
        // This is the MediaSource representing the media to be played.
        MediaSource audioSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(uri));
        // Prepare the player with the source.
        mPlayer.prepare(audioSource);
        mPlayer.setPlayWhenReady(true);
    }

    @OnClick({R.id.btn_play_start_or_pause_play})
    void clickEvent(View view){
        switch (view.getId()) {
            case R.id.btn_play_start_or_pause_play:
                if (PLAY_FLAG == 0) {
                    mPlayer.setPlayWhenReady(false);
                    PLAY_FLAG = 1;
                }else if (PLAY_FLAG == 1){
                    mPlayer.setPlayWhenReady(true);
                    PLAY_FLAG = 0;
                }
                break;
            default:
                break;
        }
    }

}
