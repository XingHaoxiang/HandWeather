package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class Weather {
    @SerializedName("aqi")
    public AqiEntity aqi;
    @SerializedName("basic")
    public BasicEntity basic;
    @SerializedName("now")
    public NowEntity now;
    @SerializedName("status")
    public String status;
    @SerializedName("suggestion")
    public SuggestionEntity suggestion;
    @SerializedName("daily_forecast")
    public List<DailyForecastEntity> daily_forecast;
    @SerializedName("hourly_forecast")
    public List<HourlyForecastEntity> hourly_forecast;
}
