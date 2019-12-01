package me.sofiworker.easemusic.fragment.found;

import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.base.BaseFragment;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 12:34
 * @description 发现碎片
 */
public class FoundFragment extends BaseFragment<FoundPresenter> implements FoundContract.View{

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_found;
    }

    @Override
    protected void initEvent() {
        showEmpty();
    }
}
