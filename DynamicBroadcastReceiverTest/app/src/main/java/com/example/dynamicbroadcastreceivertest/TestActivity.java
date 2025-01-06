package com.example.dynamicbroadcastreceivertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import com.example.dynamicbroadcastreceivertest.databinding.ActivityTestBinding;

public class TestActivity extends AppCompatActivity {
    private myBroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestBinding binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d("TestActivity","onCreate()");

        binding.btnBroadcast2.setOnClickListener( view -> {
            Intent intent = new Intent();
            intent.setAction("com.example.dynamicbroadcastreceivertest.MY_ACTION");
            sendBroadcast(intent);
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.d("TestActivity", "onResume()");

        receiver = new myBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.dynamicbroadcastreceivertest.MY_ACTION");
        registerReceiver(receiver, filter);

        Log.d("TestActivity", "Register Receiver");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TestActivity", "onStop()");
        //unregisterReceiver(receiver);
        //Log.d("TestActivity", "Unregister Receiver");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("TestActivity", "onDestroy()");
    }

    private class myBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("com.example.dynamicbroadcastreceivertest.MY_ACTION")) {
                Log.d("Boradcast Receiver", "Broadcast Received.");
            }
        }
    }
}