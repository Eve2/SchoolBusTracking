package com.schoolbus.schoolbustracking;

import android.app.Application;

/**
 * Created by Eve on 7/12/17.
 */

public class Controller extends Application {

    public static final String TAG = Controller.class.getSimpleName();

    private static Controller mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized Controller getInstance() {
        return mInstance;
    }

}
