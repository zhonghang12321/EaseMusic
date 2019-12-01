package me.sofiworker.easemusic.util;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.List;

import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.adapter.CommonFvAdapter;
import me.sofiworker.easemusic.adapter.IndicatorAdapter;
import me.sofiworker.easemusic.base.BaseFragment;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 17:18
 * @description MagicIndicator与viewpager组合的工具类
 */
public class IndicatorUtil {

    public static void combineFv(Context context, FragmentManager fm,
                                 MagicIndicator indicator, ViewPager vp,
                                 int titleId,
                                 List<BaseFragment> fragmentList){
        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdapter(new IndicatorAdapter(context, titleId));
        commonNavigator.setAdjustMode(true);
        indicator.setNavigator(commonNavigator);
        CommonFvAdapter adapter = new CommonFvAdapter(fm, fragmentList);
        vp.setAdapter(adapter);

        ViewPagerHelper.bind(indicator, vp);
    }
}
