package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class WeatherApi {
    @SerializedName("HeWeather5")
    @Expose
    public List<Weather> heWeather5 = new ArrayList<>();
}
