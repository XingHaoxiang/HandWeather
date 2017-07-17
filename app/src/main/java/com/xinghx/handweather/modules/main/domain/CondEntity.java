package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class CondEntity {
    /**
     * code : 101
     * txt : 多云
     */
    @SerializedName("code")
    public String code;
    @SerializedName("txt")
    public String txt;
}
