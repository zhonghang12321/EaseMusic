package me.sofiworker.easemusic.util;

import me.sofiworker.easemusic.Api;
import me.sofiworker.easemusic.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/26 22:18
 * @description retrofit工具类
 */
public class RetrofitUtil {

    private static Retrofit sRetrofit;
    private static Api sApi;

    private static void createRetrofit(){
        sRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static Api getApiService(){
        if (sRetrofit == null){
            createRetrofit();
        }else {
            if (sApi == null) {
                sApi = sRetrofit.create(Api.class);
            }else {
                return sApi;
            }
        }
        return null;
    }
}
