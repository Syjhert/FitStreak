package com.example.fitstreak.database_utils.classes;

import java.util.ArrayList;
import java.util.List;

public class Medicine {

    private List<Reminder> reminders;

    public Medicine() {}

    public Medicine(String s) {
        reminders = new ArrayList<>();
        reminders.add(new Reminder("_"));
    }

    public Medicine(String name1, String take1, List<String> days1,
                    String name2, String take2, List<String> days2) {

         reminders = new ArrayList<>();
         reminders.add(new Reminder(name1, days1, take1));
         reminders.add(new Reminder(name2, days2, take2));
    }

    public void addReminder(String medicine_name, String time_to_take, List<String> days_to_take) {
        reminders.add(new Reminder(medicine_name, time_to_take, days_to_take));
    }

    public List<Reminder> getReminders() { return reminders; }

    public void setReminders(List<Reminder> reminders) { this.reminders = reminders; }

    public static class Reminder {
        String medicine_name;
        String time_to_take;

        List<String> days_to_take;

        public Reminder() {}

        public Reminder(String medicine_name, List<String> days_to_take, String time_to_take) {

            this.medicine_name = medicine_name;
            this.time_to_take = time_to_take;
            this.days_to_take = days_to_take;
        }

        public Reminder(String medicine_name, String time_to_take, List<String> days_to_take) {
            this.medicine_name = medicine_name;
            this.time_to_take = time_to_take;
            this.days_to_take = days_to_take;
        }

        public Reminder(String s) {
            medicine_name = "tambal";
            time_to_take = "10:00";
            days_to_take = new ArrayList<>();
            days_to_take.add("Monday");
            days_to_take.add("Wednesday");
        }

        public String getMedicine_name() { return medicine_name; }
        public void setMedicine_name(String medicine_name) { this.medicine_name = medicine_name; }

        public String getTime_to_take() { return time_to_take; }
        public void setTime_to_take(String time_to_take) { this.time_to_take = time_to_take; }

        public List<String> getDays_to_take() { return days_to_take; }
        public void setDays_to_take(List<String> days_to_take) { this.days_to_take = days_to_take; }
    }

}
