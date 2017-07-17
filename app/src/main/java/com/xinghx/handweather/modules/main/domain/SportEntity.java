package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class SportEntity {
    /**
     * brf : 较适宜
     * txt : 天气较好，较适宜进行各种运动，但因天气热，请适当减少运动时间，降低运动强度。
     */
    @SerializedName("brf")
    public String brf;
    @SerializedName("txt")
    public String txt;
}
