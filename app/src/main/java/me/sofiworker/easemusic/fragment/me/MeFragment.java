package me.sofiworker.easemusic.fragment.me;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.activity.downloadmanager.DownloadManagerActivity;
import me.sofiworker.easemusic.activity.localmusic.LocalMusicActivity;
import me.sofiworker.easemusic.activity.mycollection.MyCollectionActivity;
import me.sofiworker.easemusic.activity.myradio.MyRadioActivity;
import me.sofiworker.easemusic.activity.recentlyplay.RecentlyPlayActivity;
import me.sofiworker.easemusic.adapter.MeRvAdapter;
import me.sofiworker.easemusic.base.BaseFragment;
import me.sofiworker.easemusic.bean.PlaylistBean;
import me.sofiworker.easemusic.bean.PlaylistTitleBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 12:33
 * @description “我的”碎片
 */
public class MeFragment extends BaseFragment<MePresenter> implements MeContract.View {

    private static final String TAG = "MeFragment";
    @BindView(R.id.rv_me)
    RecyclerView mMeRv;
    private MeRvAdapter mAdapter;
    private List<MultiItemEntity> titleList;

    void onClickEvent(){
        LinearLayout linearLayout = mAdapter.getHeaderLayout();
        linearLayout.findViewById(R.id.rl_me_local_music).setOnClickListener(v -> jumpToActivity(LocalMusicActivity.class));
        linearLayout.findViewById(R.id.rl_me_recently_play).setOnClickListener(v -> jumpToActivity(RecentlyPlayActivity.class));
        linearLayout.findViewById(R.id.rl_me_download_manager).setOnClickListener(v -> jumpToActivity(DownloadManagerActivity.class));
        linearLayout.findViewById(R.id.rl_me_my_radio).setOnClickListener(v -> jumpToActivity(MyRadioActivity.class));
        linearLayout.findViewById(R.id.rl_me_my_collection).setOnClickListener(v -> jumpToActivity(MyCollectionActivity.class));
    }

    void jumpToActivity(Class<?> cls){
        startActivity(new Intent(getContext(), cls));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initEvent() {
        mPresenter = new MePresenter();
        mPresenter.attachView(this, mProvider);

        mPresenter.getPlayList();

        initRecycler();
        onClickEvent();
    }

    private void initRecycler() {
        View headView = getLayoutInflater().inflate(R.layout.item_me_rv_head, null);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        generateTitle();
        mAdapter = new MeRvAdapter(titleList);
        mAdapter.setHeaderView(headView);
        mMeRv.setLayoutManager(layoutManager);
        mMeRv.setAdapter(mAdapter);
    }

    private void generateTitle(){
        titleList = new ArrayList<>();
        String[] playListTitle = getResources().getStringArray(R.array.playlist_title);
        PlaylistTitleBean title1 = new PlaylistTitleBean();
        title1.setTitle(playListTitle[0]);
        PlaylistTitleBean title2 = new PlaylistTitleBean();
        title2.setTitle(playListTitle[1]);
        titleList.add(title1);
        titleList.add(title2);
    }

    @Override
    public void transportSongList(List<PlaylistBean> songList) {
        String userName = mPresenter.loginUserName();
        divideList(userName, songList);
    }

    private void divideList(String userName, List<PlaylistBean> songList){
        List<PlaylistBean> createdSongList = new ArrayList<>();
        List<PlaylistBean> collectionSongList = new ArrayList<>();
        for (PlaylistBean bean : songList) {
            if (userName.equals(bean.getCreator().getNickname())) {
                createdSongList.add(bean);
            }else {
                collectionSongList.add(bean);
            }
        }

        combinedList(createdSongList, collectionSongList);
    }

    private void combinedList(List<PlaylistBean> createdSongList, List<PlaylistBean> collectionSongList){
        for (PlaylistBean bean : createdSongList) {
            ((PlaylistTitleBean)titleList.get(0)).addSubItem(bean);
        }
        for (PlaylistBean bean : collectionSongList) {
            ((PlaylistTitleBean)titleList.get(1)).addSubItem(bean);
        }
        mAdapter.setNewData(titleList);
    }
}
