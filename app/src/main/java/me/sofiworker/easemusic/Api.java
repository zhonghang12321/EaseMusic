package me.sofiworker.easemusic;

import java.util.Map;

import io.reactivex.Observable;
import me.sofiworker.easemusic.model.User;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/27 18:09
 * @description retrofit服务接口
 */
public interface Api {

    @POST("login/cellphone")
    Observable<User> userLogin(@QueryMap Map<String, String> userInfo);
}
