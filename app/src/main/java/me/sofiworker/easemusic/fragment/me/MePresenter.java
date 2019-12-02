package me.sofiworker.easemusic.fragment.me;

import android.util.Log;

import me.sofiworker.easemusic.base.BaseObserver;
import me.sofiworker.easemusic.base.BasePresenter;
import me.sofiworker.easemusic.bean.SongListBean;
import me.sofiworker.easemusic.util.RetrofitUtil;
import me.sofiworker.easemusic.util.RxUtil;
import me.sofiworker.easemusic.util.ToastUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/29 12:36
 * @description “我的”presenter
 */
public class MePresenter extends BasePresenter<MeContract.View> implements MeContract.Presenter {

    private static final String TAG = "MePresenter";
    private MeModel mMeModel;

    MePresenter(){
        mMeModel = new MeModel();
    }

    @Override
    public void getPlayList() {
//        SongListBean cacheList = mMeModel.getCacheList();
//        if (cacheList != null && cacheList.getPlaylist() != null) {
//            mView.transportSongList(cacheList.getPlaylist());
//        }else {
//
//
//        }

        if (mMeModel.getUserUid() != 0) {
            RetrofitUtil.getApiService().getPlayList(mMeModel.getUserUid())
                    .compose(RxUtil.transform(mProvider))
                    .subscribe(new BaseObserver<SongListBean>() {
                        @Override
                        protected void onSuccess(SongListBean songListBean) {
                            if (songListBean != null) {
                                mMeModel.savePlayList(songListBean);
                                if (songListBean.getPlaylist() != null) {
                                    mView.transportSongList(songListBean.getPlaylist());
                                }
                            }
                        }
                    });
        }
    }

    @Override
    public String loginUserName() {
        return mMeModel.getUserName();
    }
}
