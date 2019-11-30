package me.sofiworker.easemusic.util;

import android.widget.Toast;

import me.sofiworker.easemusic.App;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/28 19:08
 * @description toast工具类
 */
public class ToastUtil {

    private static Toast sToast;

    public static void showShort(String msg){
        if (sToast == null) {
            sToast = Toast.makeText(App.getContext(), msg, Toast.LENGTH_SHORT);
            sToast.show();
        }
        sToast.setText(msg);
        sToast.show();
    }
}
