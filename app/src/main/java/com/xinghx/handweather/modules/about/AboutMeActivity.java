package com.xinghx.handweather.modules.about;

import android.content.Context;
import android.content.Intent;

import com.xinghx.handweather.base.BaseActivity;

/**
 * Created by Xinghx on 2017/7/17.
 * 关于界面
 */

public class AboutMeActivity extends BaseActivity {



    public static void lauch(Context context) {
        context.startActivity(new Intent(context,AboutMeActivity.class));
    }
}
