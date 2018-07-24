package com.hi.gpsmaps.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hi.gpsmaps.R;

public class SplashActivity extends AppCompatActivity {

    private final int M_SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the app main activity
                Intent intent = new Intent(SplashActivity.this, SecondActivity.class);
                startActivity(intent);
                // close this activity
                finish();
            }
        }, M_SPLASH_TIME_OUT);

    }
}
