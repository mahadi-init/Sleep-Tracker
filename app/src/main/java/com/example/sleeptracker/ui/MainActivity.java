package com.example.sleeptracker.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sleeptracker.database.DBHelper;
import com.example.sleeptracker.database.DBHelperImpl;
import com.example.sleeptracker.databinding.ActivityMainBinding;
import com.example.sleeptracker.utils.Formatter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String todayDate = "";
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTodayDate();
        buttonEventListener();

        dbHelper = new DBHelperImpl(this);
        dbHelper.insertData(todayDate);
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
        binding.analogClock.setOnClickListener(v -> moveToTrackerActivity());

        binding.btnWakeup.setOnClickListener(v -> {
            dbHelper.updateData(todayDate,"wakeup",Formatter.nowTime());
        });

        binding.btnSleep.setOnClickListener(v -> dbHelper.updateData(todayDate,"sleep",Formatter.nowTime()));
    }

    private void moveToTrackerActivity() {
        Intent intent = new Intent(this, TrackerActivity.class);
        startActivity(intent);
    }
}