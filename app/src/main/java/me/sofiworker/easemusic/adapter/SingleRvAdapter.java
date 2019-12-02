package me.sofiworker.easemusic.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.bean.LocalSongBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/2 13:20
 * @description 本地音乐中单曲列表适配器
 */
public class SingleRvAdapter extends BaseQuickAdapter<LocalSongBean, BaseViewHolder> {

    public SingleRvAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, LocalSongBean item) {
        helper.setText(R.id.tv_song_title, item.getTitle());
        helper.setText(R.id.tv_single_artist, item.getArtist());
        helper.setText(R.id.tv_single_album, item.getAlbum());
    }
}
