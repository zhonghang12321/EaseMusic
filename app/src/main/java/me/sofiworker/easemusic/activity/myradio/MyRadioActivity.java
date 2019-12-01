package me.sofiworker.easemusic.activity.myradio;

import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.base.BaseActivity;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 15:45
 * @description 我的电台活动
 */
public class MyRadioActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_radio;
    }

    @Override
    protected void initEvent() {
        showEmpty();
    }
}
