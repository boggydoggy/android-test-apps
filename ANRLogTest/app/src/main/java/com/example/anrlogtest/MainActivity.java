package com.example.anrlogtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.anrlogtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MyBroadcastReceiver receiver = new MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.anrlogtest.action");
        registerReceiver(receiver, filter);
        
        binding.btn.setOnClickListener(v -> {
            Log.d("Test","Button Clicked.");
            Intent intent = new Intent("com.example.anrlogtest.action");
            sendBroadcast(intent);
        });
    }
}

class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.example.anrlogtest.action")){
            Log.d("Broadcast Receiver","Start Blocking.");
            try {
                Thread.sleep(62000);
                Log.d("Broadcast Receiver", "Wake.");
            } catch (InterruptedException e) {
                Log.e("ERROR", e.getMessage());
            }
        }
    }
}