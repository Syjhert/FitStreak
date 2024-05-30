package com.example.fitstreak;

import android.annotation.SuppressLint;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class TimeHandler {

    final static public LocalTime sleepTime = LocalTime.of(20, 39);
    final static public LocalTime medicineTime = LocalTime.of(20, 41);
    final static public LocalTime exerciseTime = LocalTime.of(20, 43);


    public static void handleTime(){
        LocalTime currentTime = LocalTime.now();
        System.out.println("Curr: " + currentTime.getHour() + ":" + currentTime.getMinute() + " vs. Alarm: " + sleepTime);
        if(sleepTime.getHour() == currentTime.getHour() && sleepTime.getMinute() == currentTime.getMinute()){
            MyNotificationManager.postNotification("Fitstreak Sleep", "It is about time for you to sleep");
        }else if(medicineTime.getHour() == currentTime.getHour() && medicineTime.getMinute() == currentTime.getMinute()){
            MyNotificationManager.postNotification("Fitstreak Medicin", "Medicine");
        }else if(exerciseTime.getHour() == currentTime.getHour() && exerciseTime.getMinute() == currentTime.getMinute()){
            MyNotificationManager.postNotification("Fitstreak Exercise", "Exercise");
        }else{
            MyNotificationManager.postNotification("Default", "Default");
        }
    }
}
