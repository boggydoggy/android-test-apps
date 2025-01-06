package com.alticast.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

//import af.system.host.CabSystemInfo;
import af.cas.XCasErrorListener;
import af.cas.XCasMessageManager;

public class MainActivity extends AppCompatActivity {
    public final String TAG = "TestApplication";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XCasErrorListener listener1 = new XCasErrorListener() {
            @Override
            public void onMessage(boolean b, boolean b1, int i, int i1, int i2, String s) {
                Log.d(TAG, "Error Message Received.");
            }
        };
        XCasErrorListener listener2 = new XCasErrorListener() {
            @Override
            public void onMessage(boolean b, boolean b1, int i, int i1, int i2, String s) {
                Log.d(TAG, "Error Message Received2.");
            }
        };

        XCasMessageManager manager = XCasMessageManager.getInstance();
        manager.setXCasErrorListener(listener1);
        Log.d(TAG, "Error Listener1 added.");
        manager.setXCasErrorListener(listener2);
        Log.d(TAG, "Error Listener2 added.");
    }
}