package me.sofiworker.easemusic.base;

import io.reactivex.observers.ResourceObserver;
import me.sofiworker.easemusic.App;
import me.sofiworker.easemusic.R;
import me.sofiworker.easemusic.util.DialogUtil;
import me.sofiworker.easemusic.util.ToastUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/25 21:12
 * @description observer封装
 */
public abstract class BaseObserver<T> extends ResourceObserver<T> {


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onNext(T t) {
        if (t == null) {
            ToastUtil.showShort(App.getContext().getString(R.string.there_has_nothing));
            DialogUtil.dismissProgressDialog();
        }else {
            onSuccess(t);
            DialogUtil.dismissProgressDialog();
        }
    }

    @Override
    public void onError(Throwable e) {
        ToastUtil.showShort(e.getMessage());
        onFail(e);
    }

    @Override
    public void onComplete() {

    }

    protected abstract void onSuccess(T t);

    public void onFail(Throwable e){
        DialogUtil.dismissProgressDialog();
    }
}
