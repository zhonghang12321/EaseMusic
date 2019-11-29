package me.sofiworker.easemusic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import me.sofiworker.easemusic.util.FragmentUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 12:30
 * @description 主活动中viewpager的适配器
 */
public class MainContentAdapter extends FragmentStatePagerAdapter {

    public MainContentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return FragmentUtil.getFragment(i);
    }

    @Override
    public int getCount() {
        return FragmentUtil.PAGE_COUNT;
    }
}
