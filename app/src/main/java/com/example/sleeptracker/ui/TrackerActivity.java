package com.example.sleeptracker.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sleeptracker.database.DBHelper;
import com.example.sleeptracker.database.DBHelperImpl;
import com.example.sleeptracker.databinding.ActivityTrackerBinding;
import com.example.sleeptracker.model.Record;

import java.util.ArrayList;

public class TrackerActivity extends AppCompatActivity {
    private ActivityTrackerBinding binding;
    private DBHelper dbHelper;
    private final ArrayList<Record> recordArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrackerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DBHelperImpl(this);
        retrieveData();
        addingRecyclerview();
    }

    private void retrieveData() {
        Cursor cursor = dbHelper.getData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No record found", Toast.LENGTH_SHORT).show();
            return;
        }

        while (cursor.moveToNext()) {
            recordArrayList.add(new Record(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2)
            ));
        }
    }

    private void addingRecyclerview() {
        binding.recyclerview.setAdapter(new Adapter(recordArrayList));
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}