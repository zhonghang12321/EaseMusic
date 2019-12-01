package me.sofiworker.easemusic.activity.mycollection;

import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.base.BaseActivity;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 15:44
 * @description 我的收藏活动
 */
public class MyCollectionActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_collection;
    }

    @Override
    protected void initEvent() {
        showEmpty();
    }
}
