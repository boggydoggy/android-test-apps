package com.example.aidlservertest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RemoteService extends Service {
    public static final String TAG = "RemoteService";
    private Thread threadUpdateTime = null;

    private final RemoteCallbackList<IRemoteServiceCallback> listeners = new RemoteCallbackList<>();

    // Service 구현부
    private final Binder binder = new IRemoteService.Stub() {
        @Override
        public boolean addCallback(IRemoteServiceCallback callback) throws RemoteException {
            Log.i(TAG, "Add callback");
            listeners.register(callback);
            launchTimeUpdaterThread();
            return true;
        }

        @Override
        public boolean removeCallback(IRemoteServiceCallback callback) throws RemoteException {
            Log.i(TAG, "Remove callback");
            listeners.unregister(callback);
            return false;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    // Callback 실행
    private void launchTimeUpdaterThread() {
        threadUpdateTime = new Thread("Time Updater") {
            @Override
            public void run() {
                while (true) {
                    Log.i(TAG, "Updating Time..");
                    int cnt = listeners.beginBroadcast();
                    for(int i = 0; i < cnt; i++) {
                        IRemoteServiceCallback callback = listeners.getBroadcastItem(i);
                        long curTime = System.currentTimeMillis();
                        SimpleDateFormat dataFormat = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
                        try {
                            callback.valueChanged(dataFormat.format(new Date(curTime)));
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    listeners.finishBroadcast();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        threadUpdateTime.start();
    }
}
