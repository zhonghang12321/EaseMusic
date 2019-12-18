package me.sofiworker.easemusic.fragment.single;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.activity.play.PlayActivity;
import me.sofiworker.easemusic.adapter.SingleRvAdapter;
import me.sofiworker.easemusic.base.BaseFragment;
import me.sofiworker.easemusic.bean.LocalSongBean;
import me.sofiworker.easemusic.service.PlayService;
import me.sofiworker.easemusic.util.ToastUtil;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 19:34
 * @description 本地音乐中单曲碎片
 */
public class SingleFragment extends BaseFragment<SinglePresenter> implements SingleContract.View {

    private static final String TAG = "SingleFragment";


    @BindView(R.id.rv_single)
    RecyclerView mSingleRv;
    private SingleRvAdapter mAdapter;
    private List<LocalSongBean> mSongList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_single;
    }

    @Override
    protected void initEvent() {
        mPresenter = new SinglePresenter();
        mPresenter.attachView(this, mProvider);

        mPresenter.setContext(getContext());

        String[] per = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(getContext(), per)) {
            mPresenter.getLocalMusicList();
        }else {
            showEmpty();
            ToastUtil.showShort("请授予应用读写储存权限！");
        }

        initRecycler();
    }

    private void initRecycler() {
        mSingleRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new SingleRvAdapter(R.layout.item_single_rv);
        mSingleRv.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LocalSongBean song = mSongList.get(position);
                Intent intent = new Intent(getContext(), PlayActivity.class);
                intent.putExtra("SongUri", song.getUri());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getMusicList(List<LocalSongBean> songList) {
        if (songList == null || songList.isEmpty()) {
            showEmpty();
        }else {
            mSongList = songList;
            mAdapter.setNewData(mSongList);
        }
    }
}
