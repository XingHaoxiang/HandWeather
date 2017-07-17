package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class CondBeanXEntity {
    /**
     * code_d : 101
     * code_n : 101
     * txt_d : 多云
     * txt_n : 多云
     */
    @SerializedName("code_d")
    public String code_d;
    public String code_n;
    public String txt_d;
    public String txt_n;
}
