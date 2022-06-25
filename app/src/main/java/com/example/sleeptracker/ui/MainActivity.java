package com.example.sleeptracker.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sleeptracker.database.DBHelper;
import com.example.sleeptracker.database.DBHelperImpl;
import com.example.sleeptracker.databinding.ActivityMainBinding;
import com.example.sleeptracker.utils.Formatter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String todayDate = "";
    private DBHelper dbHelper;
    private boolean isDelete = false;

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

    @SuppressLint("SetTextI18n")
    private void buttonEventListener() {
        binding.analogClock.setOnClickListener(v -> moveToTrackerActivity());

        binding.alarm.setOnClickListener(view -> {
            if (!isDelete) {
                alarm();
            } else {
                showAlert();
            }
        });

        binding.alarm.setOnLongClickListener(view -> {
            binding.alarm.setBackgroundColor(Color.RED);
            binding.alarm.setText("Delete DB");
            isDelete = !isDelete;

            return true;
        });

        binding.btnWakeup.setOnClickListener(v -> dbHelper.updateData(todayDate, "wakeup", Formatter.nowTime()));

        binding.btnSleep.setOnClickListener(v -> dbHelper.updateData(todayDate, "sleep", Formatter.nowTime()));
    }

    private void showAlert() {
        new AlertDialog.Builder(this)
                .setTitle("Delete entry")
                .setMessage("Are you sure you want to delete")
                .setPositiveButton(android.R.string.yes, (dialog, which) -> dbHelper.deleteData(todayDate))
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void alarm() {
        Intent intent = new Intent();
        intent.setAction(AlarmClock.ACTION_SET_ALARM);
        startActivity(intent);
    }

    private void moveToTrackerActivity() {
        Intent intent = new Intent(this, TrackerActivity.class);
        startActivity(intent);
    }
}