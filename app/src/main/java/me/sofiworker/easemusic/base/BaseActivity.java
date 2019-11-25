package me.sofiworker.easemusic.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/25 20:37
 * @description 活动基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
    }

    /**
     * 获取layout的id
     * @return layout的id
     */
    abstract int getLayoutId();
}
