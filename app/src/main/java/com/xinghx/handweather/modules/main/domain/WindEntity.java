package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class WindEntity {
    @SerializedName("deg")
    public String deg;
    @SerializedName("dir")
    public String dir;
    @SerializedName("sc")
    public String sc;
    @SerializedName("spd")
    public String spd;
}
