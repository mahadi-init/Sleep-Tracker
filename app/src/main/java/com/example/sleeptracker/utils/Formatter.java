package com.example.sleeptracker.utils;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Formatter {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    public static String getTodayDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM", Locale.getDefault());
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        return dateFormat.format(date);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String nowTime(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        return dateFormat.format(date);
    }

    public static String whichMonth(@NonNull String date) {
        String day = date.substring(0,2);
        int dayInt = Integer.parseInt(day);

        String month = date.substring(3, 5);
        int monthInt = Integer.parseInt(month);

        String formattedMonth = "";
        if (monthInt == 1) {
            formattedMonth = "January";
        } else if (monthInt == 2) {
            formattedMonth = "February";
        } else if (monthInt == 3) {
            formattedMonth = "March";
        } else if (monthInt == 4) {
            formattedMonth = "April";
        } else if (monthInt == 5) {
            formattedMonth = "May";
        } else if (monthInt == 6) {
            formattedMonth = "June";
        } else if (monthInt == 7) {
            formattedMonth = "July";
        } else if (monthInt == 8) {
            formattedMonth = "August";
        } else if (monthInt == 9) {
            formattedMonth = "September";
        } else if (monthInt == 10) {
            formattedMonth = "October";
        } else if (monthInt == 11) {
            formattedMonth = "November";
        } else if (monthInt == 12) {
            formattedMonth = "December";
        }

        return dayInt + "th " + formattedMonth;
    }
}
