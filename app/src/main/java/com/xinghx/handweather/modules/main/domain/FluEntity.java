package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class FluEntity {
    /**
     * brf : 少发
     * txt : 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
     */
    @SerializedName("brf")
    public String brf;
    @SerializedName("txt")
    public String txt;
}
