package com.example.sleeptracker.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sleeptracker.databinding.ActivityMainBinding;
import com.example.sleeptracker.utils.Formatter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String todayDate = "";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTodayDate();
        buttonEventListener();
    }

    private void setTodayDate() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String date = extras.getString("date");
            todayDate = Formatter.whichMonth(date);
            binding.date.setText(Formatter.whichMonth(date));
        }
    }

    private void buttonEventListener() {
        binding.btnWakeup.setOnClickListener(v -> {
            // TODO: 6/22/2022 add wake up data
        });

        binding.btnSleep.setOnClickListener(v -> {
            // TODO: 6/22/2022 add  sleep data
            moveToTrackerActivity();
        });
    }

    private void moveToTrackerActivity() {
        Intent intent = new Intent(this, TrackerActivity.class);
        startActivity(intent);
    }
}