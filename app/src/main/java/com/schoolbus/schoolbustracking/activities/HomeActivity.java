package com.schoolbus.schoolbustracking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.schoolbus.schoolbustracking.R;
import com.schoolbus.schoolbustracking.fragments.home.HomeFragment;
import com.schoolbus.schoolbustracking.fragments.home.LocationFragment;
import com.schoolbus.schoolbustracking.fragments.home.StudentsFragment;

public class HomeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        hideScrollBar();
        setActionBar();
        setDrawerToggle();
        setListener();

        // home page container to holder all fragments
        if (findViewById(R.id.home_container) != null) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.home_container, new LocationFragment()).commit();
            }
        }
    }
    //init view
    private void initViews()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }
    //setActionBar
    private void setActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void hideScrollBar() {
        mNavigationView.getChildAt(0).setVerticalScrollBarEnabled(false);
    }

    private void setDrawerToggle() {
        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    // set navigation drawer items click listener
    private void setListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new HomeFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.students:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new StudentsFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.notification:
                        break;
                    case R.id.location:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container,new LocationFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.logout:
                        Intent it = new Intent(HomeActivity.this, LoginActivity.class);
        //                sharedPreferences.edit().clear().commit();
                        startActivity(it);
                        break;
                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}
