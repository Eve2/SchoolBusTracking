package com.schoolbus.schoolbustracking.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.schoolbus.schoolbustracking.R;
import com.schoolbus.schoolbustracking.fragments.home.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        // home page container to holder all fragments
        if (findViewById(R.id.home_container) != null) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.home_container, new HomeFragment()).addToBackStack(null).commit();
            }
        }

    }
}
