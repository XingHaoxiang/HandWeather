package com.xinghx.handweather.modules.main.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Xinghx on 2017/7/17.
 */

public class SuggestionEntity {
    @SerializedName("comf")
    public ComfEntity comf;
    @SerializedName("cw")
    public CwEntity cw;
    @SerializedName("drsg")
    public DrsgEntity drsg;
    @SerializedName("flu")
    public FluEntity flu;
    @SerializedName("sport")
    public SportEntity sport;
    @SerializedName("trav")
    public TravEntity trav;
    @SerializedName("uv")
    public UvEntity uv;
}
