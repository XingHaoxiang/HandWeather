package com.xinghx.handweather.network;

import com.xinghx.handweather.constants.Const;
import com.xinghx.handweather.constants.utils.RxUtil;
import com.xinghx.handweather.constants.utils.ToastUtil;
import com.xinghx.handweather.modules.main.domain.Weather;
import com.xinghx.handweather.modules.main.domain.WeatherApi;
import com.xinghx.handweather.network.constant.Url;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class RetrofitSingleton {
    private WeatherAllApi sWeatherAllApi = null;
    private Retrofit sRetrofit = null;
    private OkHttpClient sOkHttpClient = null;

    private void init() {
        initOkhttp();
        initRetrofit();
        sWeatherAllApi = sRetrofit.create(WeatherAllApi.class);
    }

    private RetrofitSingleton() {
        init();
    }

    public static RetrofitSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        private static final RetrofitSingleton INSTANCE = new RetrofitSingleton();
    }

    private void initOkhttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);

        sOkHttpClient = builder.addInterceptor(loggingInterceptor).build();
    }

    private void initRetrofit() {
        sRetrofit = new Retrofit.Builder()
                .baseUrl(Url.HOST)
                .client(sOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Observable<Weather> weatherAll(final String city) {
        return sWeatherAllApi.weatherAll(city, Const.WEATHERKEY).flatMap(new Function<WeatherApi, ObservableSource<WeatherApi>>() {

            @Override
            public ObservableSource<WeatherApi> apply(@NonNull WeatherApi weatherApi) throws Exception {
                String status = weatherApi.heWeather5.get(0).status;
                if ("no more requests".equals(status)) {
                    return Observable.error(new RuntimeException("次数已经用完了"));
                } else if ("unknown city".equals(status)) {
                    return Observable.error(new RuntimeException(String.format("没有找到%s",city)));
                }
                return Observable.just(weatherApi);
            }
        }).map(new Function<WeatherApi, Weather>() {
            @Override
            public Weather apply(@NonNull WeatherApi weatherApi) throws Exception {
                return weatherApi.heWeather5.get(0);
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                disposeFailureInfo(throwable);
            }
        }).compose(RxUtil.<Weather>io());
    }

    private static Consumer<Throwable> disposeFailureInfo(final Throwable t) {
        return new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                if (t.toString().contains("GaiException") || t.toString().contains("SocketTimeoutException")
                        || t.toString().contains("UnknownHostException")) {
                    ToastUtil.showShort("网络异常");
                }
            }
        };
    }
}
