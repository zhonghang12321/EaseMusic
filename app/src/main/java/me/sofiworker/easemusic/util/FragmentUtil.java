package me.sofiworker.easemusic.util;

import android.util.SparseArray;

import me.sofiworker.easemusic.base.BaseFragment;
import me.sofiworker.easemusic.fragment.found.FoundFragment;
import me.sofiworker.easemusic.fragment.me.MeFragment;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 12:30
 * @description 碎片工具，负责切换viewpager中的碎片
 */
public class FragmentUtil {

    private final static int INDEX_ME = 0;
    private final static int INDEX_FOUND = 1;

    public final static int PAGE_COUNT = 2;

    private static SparseArray<BaseFragment> sCache = new SparseArray<>();


    public static BaseFragment getFragment(int index){
        BaseFragment baseFragment = sCache.get(index);
        if (baseFragment != null){
            return baseFragment;
        }
        switch (index){
            case INDEX_ME:
                baseFragment = new MeFragment();
                break;
            case INDEX_FOUND:
                baseFragment = new FoundFragment();
                break;
            default:
                break;
        }
        sCache.put(index, baseFragment);
        return baseFragment;
    }
}
