package com.example.fitstreak.database_utils.classes;

import java.time.LocalTime;

public class TimeStart {

    int hours;
    int minutes;

    public TimeStart() {
        LocalTime currentTime = LocalTime.now();
        hours = currentTime.getHour();
        minutes = currentTime.getMinute();
    }
}
