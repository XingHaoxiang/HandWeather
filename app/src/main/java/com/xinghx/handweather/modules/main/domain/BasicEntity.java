package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class BasicEntity {
    @SerializedName("city")
    String city;
    @SerializedName("cnty")
    String cnty;
    @SerializedName("id")
    String id;
    @SerializedName("lat")
    String lat;
    @SerializedName("lon")
    String lon;
    @SerializedName("update")
    UpdateBean update;
}
