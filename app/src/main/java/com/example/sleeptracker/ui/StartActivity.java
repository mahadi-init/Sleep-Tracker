package com.example.sleeptracker.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sleeptracker.R;
import com.example.sleeptracker.utils.Formatter;

public class StartActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        setContentView(R.layout.activity_start);

        moveToMainActivity(Formatter.getTodayDate());
    }

    private void moveToMainActivity(String todayDate) {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("date", todayDate);
            startActivity(intent);
            finish();
        }, 2000);
    }
}