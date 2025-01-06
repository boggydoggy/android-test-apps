package com.example.servicethreadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.servicethreadtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn.setOnClickListener( view -> {
            Log.d("Btn", "Service Created.");
            Intent intent = new Intent(MainActivity.this, ServiceTest.class);
            intent.putExtra("service", 3);

            startService(intent);
        });

        binding.btn2.setOnClickListener(view -> {
            Log.d("Btn", "Service Stop Command.");
            Intent intent = new Intent(MainActivity.this, ServiceTest.class);
            stopService(intent);
        });
    }
}