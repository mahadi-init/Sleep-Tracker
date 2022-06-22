package com.example.sleeptracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sleeptracker.databinding.ActivityMainBinding;
import com.example.sleeptracker.databinding.ActivityTrackerBinding;

public class TrackerActivity extends AppCompatActivity {
    private ActivityTrackerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrackerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}