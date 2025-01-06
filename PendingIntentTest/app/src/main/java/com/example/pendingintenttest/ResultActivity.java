package com.example.pendingintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

import com.example.pendingintenttest.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {
    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String text = "Receiving ";
        int id = 0;

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            text = "Receiving data failed";
        }
        else {
            id = extras.getInt("notificationId");
        }

        binding.btnS.setText(text + " " + id);

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        nm.cancel(id);
    }
}