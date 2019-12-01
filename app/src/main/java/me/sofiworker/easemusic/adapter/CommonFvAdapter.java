package me.sofiworker.easemusic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

import me.sofiworker.easemusic.base.BaseFragment;
import me.sofiworker.easemusic.fragment.found.FoundFragment;
import me.sofiworker.easemusic.fragment.me.MeFragment;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 17:30
 * @description viewpager的通用适配器
 */
public class CommonFvAdapter extends FragmentStatePagerAdapter {

    private SparseArray<BaseFragment> sCache = new SparseArray<>();
    private List<BaseFragment> mFragmentList;

    public CommonFvAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int pos) {
        BaseFragment baseFragment = sCache.get(pos);
        if (baseFragment != null){
            return baseFragment;
        }else {
            baseFragment = mFragmentList.get(pos);
            sCache.put(pos, baseFragment);
        }
        return baseFragment;
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }
}
