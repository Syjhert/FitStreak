package com.example.fitstreak;

import android.annotation.SuppressLint;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class TimeHandler {

    final static public LocalTime alarmTime = LocalTime.of(13, 48);

    public static void handleTime(){
        LocalTime currentTime = LocalTime.now();
        System.out.println("Curr: " + currentTime.getHour() + ":" + currentTime.getMinute() + " vs. Alarm: " + alarmTime);
        if(alarmTime.getHour() == currentTime.getHour() && alarmTime.getMinute() == currentTime.getMinute()){
            MyNotificationManager.displayNotification(MainActivity.getAppContext(), "Fitstreak Sleep", "It is about time for you to sleep");
        }
    }
}
