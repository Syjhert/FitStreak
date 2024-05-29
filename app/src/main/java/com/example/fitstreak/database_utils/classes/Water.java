package com.example.fitstreak.database_utils.classes;

public class Water {

    private int glasses_count_goal;
    private int glass_drank_count;
    private long reminder_interval;
    private String remind_time_start;

    public Water() {}

    public Water(int glass_drank_count, int glasses_count_goal,
                 long reminder_interval, String remind_time_start) {
        this.glass_drank_count = glass_drank_count;
        this.glasses_count_goal = glasses_count_goal;
        this.reminder_interval = reminder_interval;
        this.remind_time_start = remind_time_start;
    }

    // Getters and setters
    public int getGlass_drank_count() { return glass_drank_count; }
    public void setGlass_drank_count(int count) {
        glass_drank_count = count;
    }

    public int getGlasses_count_goal() {
        return glasses_count_goal;
    }

    public void setGlasses_count_goal(int glasses_count_goal) {
        this.glasses_count_goal = glasses_count_goal;
    }

    public long getReminder_interval() {
        return reminder_interval;
    }

    public void setReminder_interval(long reminder_interval) {
        this.reminder_interval = reminder_interval;
    }

    public String getRemind_time_start() {
        return remind_time_start;
    }

    public void setRemind_time_start(String remind_time_start) {
        this.remind_time_start = remind_time_start;
    }
}
