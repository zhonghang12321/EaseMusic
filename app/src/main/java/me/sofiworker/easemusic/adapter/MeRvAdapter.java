package me.sofiworker.easemusic.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

import me.sofiworker.easemusic.R;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 22:16
 * @description “我的”的页面中recyclerview的伸缩适配器
 */
public class MeRvAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    static final int TYPE_LEVEL_0 = 0;
    static final int TYPE_LEVEL_1 = 1;
    static final int TYPE_LEVEL_2 = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MeRvAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_1, R.layout.item_me_created_playlist);
        addItemType(TYPE_LEVEL_2, R.layout.item_me_rv);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()){
            case TYPE_LEVEL_1:
                break;
            case TYPE_LEVEL_2:
                break;
            default:
                break;
        }
    }
}
