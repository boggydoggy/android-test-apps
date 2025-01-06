package com.example.aidlclienttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.aidlservertest.IRemoteService;
import com.example.aidlservertest.IRemoteServiceCallback;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private IRemoteService iRemoteService = null;
    private IRemoteServiceCallback callback = null;
    private ServiceConnection connection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.aidlclienttest.R.layout.activity_main);

        // Service Connection
        if (connection == null) {
            connection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    iRemoteService = IRemoteService.Stub.asInterface(iBinder);
                    Log.i(TAG, "Service is connected");

                    try {
                        if (iRemoteService.addCallback(callback)) {
                            Log.i(TAG, "Callback was added");
                        } else {
                            Log.i(TAG, "adding Callback was failed");
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onServiceDisconnected(ComponentName componentName) {
                    iRemoteService = null;
                    Log.i(TAG, "Service is Disconnected");
                }
            };
        }

        //Callback 구현부
        callback = new IRemoteServiceCallback.Stub() {
            public void valueChanged(String value) throws RemoteException {
                Log.i(TAG, "On Time Changed:: " + value);
            }
        };

        Intent intent = new Intent("com.example.aidlservertest.MY_SERVICE");
        intent.setPackage("com.example.aidlservertest");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
}