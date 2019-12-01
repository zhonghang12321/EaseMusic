package me.sofiworker.easemusic.adapter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.bean.PlaylistBean;
import me.sofiworker.easemusic.bean.PlaylistTitleBean;


/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 22:16
 * @description “我的”的页面中recyclerview的伸缩适配器
 */
public class MeRvAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_LEVEL_2 = 2;

    public MeRvAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_1, R.layout.item_me_rv_playlist_title);
        addItemType(TYPE_LEVEL_2, R.layout.item_me_rv_playlist);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()){
            case TYPE_LEVEL_1:
                PlaylistTitleBean itemBean = (PlaylistTitleBean)item;
                helper.setText(R.id.tv_playlist_title, itemBean.getTitle());
                helper.setImageResource(R.id.iv_play_list_instruction_arrow, itemBean.isExpanded()? R.drawable.ic_down_arrow : R.drawable.ic_right_arrow);
                helper.itemView.setOnClickListener(v -> {
                    int pos = helper.getAdapterPosition();
                    if (itemBean.isExpanded()) {
                        collapse(pos, true, true);
                    }else {
                        expand(pos,true, true);
                    }
                });
                break;
            case TYPE_LEVEL_2:
                PlaylistBean bean = (PlaylistBean)item;
                ImageView view = helper.getView(R.id.iv_playlist_cover);
                // TODO: 2019/11/30 待判断该方法能否解决复用问题
                view.setImageDrawable(null);
                Glide.with(mContext).load(bean.getCoverImgUrl()).into(view);
                helper.setText(R.id.tv_me_playlist_name, bean.getName());
                helper.setText(R.id.tv_me_playlist_song_count, bean.getTrackCount() +mContext.getString(R.string.num));
                helper.setText(R.id.tv_me_playlist_creator, bean.getCreator().getNickname());
                break;
            default:
                break;
        }
    }
}
