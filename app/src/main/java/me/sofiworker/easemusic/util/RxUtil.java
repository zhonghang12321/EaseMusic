package me.sofiworker.easemusic.util;

import android.arch.lifecycle.Lifecycle;

import com.trello.rxlifecycle2.LifecycleProvider;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/28 13:32
 * @description RxJava工具类，线程转换与RxLifecycle封装
 */
public class RxUtil {

    public static <T> ObservableTransformer<T, T> transform(LifecycleProvider<Lifecycle.Event> provider) {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(provider.bindToLifecycle());
    }

}
