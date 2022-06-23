package com.example.sleeptracker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelperImpl extends SQLiteOpenHelper implements DBHelper {

    public DBHelperImpl(@Nullable Context context) {
        super(context, "sleepDatabase.db", null, 1);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL("CREATE TABLE sleepDetails(date TEXT PRIMARY KEY, wakeup TEXT, sleep TEXT)");
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sleepDetails");
    }

    @Override
    public void insertData(@NonNull String date) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", date);
        contentValues.put("wakeup", "");
        contentValues.put("sleep", "");

        DB.insert("sleepDetails", null, contentValues);
    }

    @Override
    public void updateData(String date, String key, String wakeup) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(key, wakeup);
        Cursor cursor = DB.rawQuery("Select * from sleepDetails where date = ?", new String[]{date});

        if (cursor.getCount() > 0) {
            DB.update("sleepDetails", contentValues, "date=?", new String[]{date});
        }
        cursor.close();
    }

    @Override
    public Cursor getData() {
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("Select * from sleepDetails ORDER BY date ASC", null);
    }
}
