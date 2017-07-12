package com.schoolbus.schoolbustracking.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.schoolbus.schoolbustracking.R;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = getBaseContext().getSharedPreferences("mSharedPref", Context.MODE_PRIVATE);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(500);
                    /*
                    if (sharedPreferences.getString("OTP", "").equals("")) {
                        Intent intent = new Intent(SplashPage.this, LoginPage.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(SplashPage.this, HomePage.class);
                        startActivity(intent);
                    }
                    */
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        };

        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
