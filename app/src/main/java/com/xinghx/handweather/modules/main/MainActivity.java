package com.xinghx.handweather.modules.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.xinghx.handweather.R;
import com.xinghx.handweather.base.BaseActivity;
import com.xinghx.handweather.constants.utils.ToastUtil;
import com.xinghx.handweather.modules.about.AboutMeActivity;
import com.xinghx.handweather.modules.main.domain.Weather;
import com.xinghx.handweather.modules.main.drawer.SettingsActivity;
import com.xinghx.handweather.network.RetrofitSingleton;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "MainActivity";
    @BindView(R.id.drawer)
    DrawerLayout drawer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("手中天气");
        setSupportActionBar(toolbar);
        initDrawer();
        RetrofitSingleton.getInstance().weatherAll("石家庄").subscribe(new Consumer<Weather>() {
            @Override
            public void accept(@NonNull Weather weather) throws Exception {
                ToastUtil.showShort(weather.now.cond.txt);

            }
        });

    }

    private void initDrawer() {
        if (navView != null) {
            navView.setNavigationItemSelectedListener(this);
            navView.inflateHeaderView(R.layout.activity_header);
        }
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawer, toolbar,
                        R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@android.support.annotation.NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                SettingsActivity.lauch(this);
                break;
            case R.id.aboutMe:
                AboutMeActivity.lauch(this);
                break;
        }
        return false;
    }
}
