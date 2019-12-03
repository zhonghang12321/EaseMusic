package me.sofiworker.easemusic;

import android.content.Intent;

import java.io.IOException;

import me.sofiworker.easemusic.activity.login.LoginActivity;
import me.sofiworker.easemusic.util.SpUtil;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/3 22:25
 * @description Retrofit2共有拦截器
 */
public class CommonInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        return chain.proceed(chain.request());
    }
}
