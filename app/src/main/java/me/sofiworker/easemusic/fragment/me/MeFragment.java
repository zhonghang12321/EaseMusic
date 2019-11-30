package me.sofiworker.easemusic.fragment.me;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.adapter.MeRvAdapter;
import me.sofiworker.easemusic.base.BaseFragment;
import me.sofiworker.easemusic.bean.PlaylistTitleBean;
import me.sofiworker.easemusic.bean.PlaylistBean;

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
    }

    private void initRecycler() {
        View headView = getLayoutInflater().inflate(R.layout.item_me_rv_head, null);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new MeRvAdapter(null);
        mAdapter.setHeaderView(headView);
        mMeRv.setLayoutManager(layoutManager);
        mMeRv.setAdapter(mAdapter);
    }

    @Override
    public void transportSongList(List<PlaylistBean> songList) {
        Log.d(TAG, "transportSongList: "+songList.toString());
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
        List<MultiItemEntity> expandList = new ArrayList<>();
        String[] playListTitle = getResources().getStringArray(R.array.playlist_title);
        PlaylistTitleBean title1 = new PlaylistTitleBean();
        title1.setTitle(playListTitle[0]);
        PlaylistTitleBean title2 = new PlaylistTitleBean();
        title2.setTitle(playListTitle[1]);
        for (PlaylistBean bean : createdSongList) {
            title1.addSubItem(bean);
        }
        for (PlaylistBean bean : collectionSongList) {
            title2.addSubItem(bean);
        }
        expandList.add(title1);
        expandList.add(title2);
        mAdapter.replaceData(expandList);
        mAdapter.notifyDataSetChanged();
    }
}
