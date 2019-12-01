package me.sofiworker.easemusic.activity.recentlyplay;

import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.base.BaseActivity;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 15:46
 * @description 最近播放活动
 */
public class RecentlyPlayActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_recently_play;
    }

    @Override
    protected void initEvent() {
        showEmpty();
    }
}
