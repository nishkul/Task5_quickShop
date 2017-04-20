package com.android.task.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.android.task.R;
import com.android.task.ui.base.BaseActivity;
import com.android.task.utils.MyContants;


public class SplashScreenAcitivity extends BaseActivity {

    @Override
    protected void initialingLayout() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.BLUE);
        }
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void initialingMember() {
    }

    @Override
    protected void initialingData() {
        try {
            super.onResume();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashScreenAcitivity.this, MainActivity.class));

                }
            }, MyContants.SPLASH_TIME);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initialingListener() {
    }
}
