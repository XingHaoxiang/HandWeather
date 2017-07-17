package com.xinghx.handweather.network;


import com.xinghx.handweather.modules.main.domain.WeatherApi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Xinghx on 2017/7/17.
 * 网络请求api
 */

public interface WeatherAllApi {
    @GET("weather")
    Observable<WeatherApi> weatherAll(
            @Query("city") String city,
            @Query("key") String key
    );
}
