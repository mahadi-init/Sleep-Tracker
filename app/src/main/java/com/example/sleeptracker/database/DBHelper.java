package com.example.sleeptracker.database;

import android.database.Cursor;

public interface DBHelper {
    void insertData(String date);
    void updateData(String date,String key, String wakeup);
    void deleteData(String date);
    Cursor getData();
}
