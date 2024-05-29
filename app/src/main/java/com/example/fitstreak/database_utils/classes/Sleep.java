package com.example.fitstreak.database_utils.classes;

public class Sleep {

    int sleep_hours_goal;
    String sleep_time_start;

    public Sleep() {}

    public Sleep(String s) {
        sleep_hours_goal = 8;
        sleep_time_start = "16:30";
    }

    public int getSleep_hours_goal() {
        return sleep_hours_goal;
    }

    public void setSleep_hours_goal(int sleep_hours_goal) {
        this.sleep_hours_goal = sleep_hours_goal;
    }

    public String getSleep_time_start() {
        return sleep_time_start;
    }

    public void setSleep_time_start(String sleep_time_start) {
        this.sleep_time_start = sleep_time_start;
    }
}
