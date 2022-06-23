package com.example.sleeptracker.model;

public class Record {
    private String date;
    private String wakeup;
    private String sleep;

    public Record(String date, String wakeup, String sleep) {
        this.date = date;
        this.wakeup = wakeup;
        this.sleep = sleep;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWakeup() {
        return wakeup;
    }

    public void setWakeup(String wakeup) {
        this.wakeup = wakeup;
    }

    public String getSleep() {
        return sleep;
    }

    public void setSleep(String sleep) {
        this.sleep = sleep;
    }
}
