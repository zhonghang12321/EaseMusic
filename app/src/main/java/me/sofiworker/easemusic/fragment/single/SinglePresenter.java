package me.sofiworker.easemusic.fragment.single;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.sofiworker.easemusic.base.BasePresenter;
import me.sofiworker.easemusic.bean.LocalSongBean;
import me.sofiworker.easemusic.bean.SongListBean;
import me.sofiworker.easemusic.util.ToastUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/1 22:04
 * @description single的p层
 */
public class SinglePresenter extends BasePresenter<SingleContract.View> implements SingleContract.Presenter {

    private static final String TAG = "SinglePresenter";

    private SingleModel mModel;
    private Context mContext;

    SinglePresenter(){
        mModel = new SingleModel();
    }

    @Override
    public void setContext(Context context) {
        this.mContext = context;
    }

    @Override
    public void getLocalMusicList() {
        List<LocalSongBean> songList = new ArrayList<>();
        Observable.create((ObservableOnSubscribe<LocalSongBean>) emitter -> {
            Cursor cursor = mContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    null, null, null,
                    MediaStore.Audio.AudioColumns.IS_MUSIC);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    //扫描的音乐大于50k
                    if (Integer.parseInt(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.SIZE))) / (float)(1024*1024) > (50 / 1024.0)){
                        LocalSongBean song = new LocalSongBean();
                        song.setTitle(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE)));
                        song.setArtist(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST)));
                        song.setUri(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA)));
                        song.setSize(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.SIZE)));
                        song.setTrack(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TRACK)));
                        song.setDuration(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION)));
                        song.setAlbum(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM)));
                        emitter.onNext(song);
                    }
                }
                cursor.close();
            }
            emitter.onComplete();
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<LocalSongBean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(LocalSongBean localSongBean) {
                songList.add(localSongBean);
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.showShort("发生异常了："+e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.getMusicList(songList);
            }
        });
    }
}
