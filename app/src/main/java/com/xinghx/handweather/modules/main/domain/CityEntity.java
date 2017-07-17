package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class CityEntity {
    @SerializedName("aqi")
    String aqi;
    @SerializedName("co")
    String co;
    @SerializedName("no2")
    String no2;
    @SerializedName("o3")
    String o3;
    @SerializedName("pm10")
    String pm10;
    @SerializedName("pm25")
    String pm25;
    @SerializedName("qlty")
    String qlty;
    @SerializedName("so2")
    String so2;
}
