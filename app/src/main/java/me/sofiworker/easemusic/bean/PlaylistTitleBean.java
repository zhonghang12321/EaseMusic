package me.sofiworker.easemusic.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import me.sofiworker.easemusic.adapter.MeRvAdapter;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/30 14:37
 * @description “我的”页面标题bean
 */
public class PlaylistTitleBean extends AbstractExpandableItem<PlaylistBean> implements MultiItemEntity {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getLevel() {
        return MeRvAdapter.TYPE_LEVEL_1;
    }

    @Override
    public int getItemType() {
        return 1;
    }
}
