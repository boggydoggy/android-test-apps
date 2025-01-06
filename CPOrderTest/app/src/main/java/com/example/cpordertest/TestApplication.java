package com.example.cpordertest;

import android.app.Application;
import android.util.Log;

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Testing", "Test Application: onCreate()");
    }
}
