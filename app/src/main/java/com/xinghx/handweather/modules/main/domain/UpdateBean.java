package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Xinghx on 2017/7/17.
 */
public class UpdateBean {
    @SerializedName("loc")
    String loc;
    @SerializedName("utc")
    String utc;
}
