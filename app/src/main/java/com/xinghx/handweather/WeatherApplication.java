package com.xinghx.handweather;

import android.app.Application;
import android.content.Context;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class WeatherApplication extends Application{

    private static Context getInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        getInstance = getApplicationContext();
    }

    public static Context getInstance() {
        return getInstance;
    }
}
