package me.sofiworker.easemusic.activity.downloadmanager;

import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.base.BaseActivity;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 15:43
 * @description 下载管理活动
 */
public class DownloadManagerActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_download_manager;
    }

    @Override
    protected void initEvent() {
        showEmpty();
    }
}
