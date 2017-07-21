package com.xinghx.handweather.modules.main.drawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.xinghx.handweather.R;
import com.xinghx.handweather.base.BaseActivity;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public static void lauch(Context context) {
        context.startActivity(new Intent(context, SettingsActivity.class));
    }
}
