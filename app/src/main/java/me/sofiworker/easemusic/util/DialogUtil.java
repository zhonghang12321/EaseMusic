package me.sofiworker.easemusic.util;

import android.app.ProgressDialog;
import android.content.Context;

import me.sofiworker.easemusic.R;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/28 19:08
 * @description dialog工具类
 */
public class DialogUtil {

    private static ProgressDialog sProgressDialog;

    public static void showProgressDialog(Context context, String msg){
        if (sProgressDialog == null) {
            sProgressDialog = new ProgressDialog(context);
        }
        sProgressDialog.setTitle(context.getString(R.string.prompt));
        sProgressDialog.setMessage(msg == null ? context.getString(R.string.is_loading) : msg);
        sProgressDialog.show();
    }

    public static void dismissProgressDialog(){
        if (sProgressDialog != null && sProgressDialog.isShowing()) {
            sProgressDialog.dismiss();
        }
    }
}
