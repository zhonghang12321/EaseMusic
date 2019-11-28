package me.sofiworker.easemusic.util;

import me.sofiworker.easemusic.Api;
import me.sofiworker.easemusic.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/26 22:18
 * @description retrofit工具类
 */
public class RetrofitUtil {

    public static Api getApiService(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(Api.class);
    }
}
