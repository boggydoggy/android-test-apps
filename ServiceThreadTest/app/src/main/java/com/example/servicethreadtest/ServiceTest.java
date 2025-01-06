package com.example.servicethreadtest;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import java.util.HashMap;
import java.util.Random;

public class ServiceTest extends Service {
    private int extraValue;
    private BackgroundSubThread subThread;
    private final String TAG = "ServiceTest";
    private final String HANDLER = "ServiceTest_Handler";


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Start Service Callback Method.");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "Stop Service Callback Method.");
        super.onDestroy();
        /*
        if(subThread != null && subThread.isAlive()) {
            subThread.interrupt();
        }

         */
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Log.d(TAG, "on Service Started.");
        extraValue = intent.getIntExtra("service", 0);
        subThread = new BackgroundSubThread("Thread1_test");

        subThread.start();

        return START_NOT_STICKY;
    }

    class BackgroundSubThread extends Thread {
        private final Random random;

        public BackgroundSubThread(String name) {
            super(name);
            random = new Random(System.currentTimeMillis());

        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                switch(extraValue) {
                    case 0:
                        Log.d(TAG, "Service Test1");
                        break;
                    case 1:
                        Log.d(TAG, "Service Test2");
                        break;
                    case 2:
                        Log.d(TAG, "Service Test3");
                        break;
                    case 3:
                        Log.d(TAG, "Service Test4");
                        break;
                    default:
                        Log.d(TAG, "Service Test5");
                        break;
                }

                extraValue = random.nextInt(4);

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    currentThread().interrupt();
                }

                super.run();
            }
        }
    }
}
