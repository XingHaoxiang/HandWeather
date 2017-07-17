package com.xinghx.handweather.modules.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xinghx.handweather.R;
import com.xinghx.handweather.base.BaseActivity;
import com.xinghx.handweather.constants.utils.ToastUtil;
import com.xinghx.handweather.modules.main.domain.Weather;
import com.xinghx.handweather.network.RetrofitSingleton;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


public class MainActivity extends BaseActivity {

    @BindView(R.id.fab)
    FloatingActionButton fab;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RetrofitSingleton.getInstance().weatherAll("石家庄").subscribe(new Consumer<Weather>() {
            @Override
            public void accept(@NonNull Weather weather) throws Exception {
                ToastUtil.showShort(weather.now.cond.txt);

            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}