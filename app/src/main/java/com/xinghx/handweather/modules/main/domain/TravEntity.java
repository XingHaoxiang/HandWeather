package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class TravEntity {
    /**
     * brf : 较适宜
     * txt : 天气较好，温度较高，天气较热，但有微风相伴，还是比较适宜旅游的，不过外出时要注意防暑防晒哦！
     */
    @SerializedName("brf")
    public String brf;
    @SerializedName("txt")
    public String txt;
}
