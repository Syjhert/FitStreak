package com.example.fitstreak.database_utils.classes;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private String exercise_time_start;
    private List<Routine> routines;

    public Exercise() {}

    public Exercise(String s) {
        routines = new ArrayList<>();
        routines.add(new Routine("_"));
        exercise_time_start = "6:30";
    }

    public String getExercise_time_start() { return exercise_time_start; }
    public void setExercise_time_start(String exercise_time_start) { this.exercise_time_start = exercise_time_start; }

    public List<Routine> getRoutines() { return routines; }
    public void setRoutines(List<Routine> routines) { this.routines = routines; }

    public static class Routine {
        private String name;
        private List<String> days;
        private List<String> exercises;

        public Routine() {}

        public Routine(String s) {
            days = new ArrayList<>();
            days.add("Monday");

            exercises = new ArrayList<>();
            exercises.add("Push ups");
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getDays() {
            return days;
        }

        public void setDays(List<String> days) {
            this.days = days;
        }

        public List<String> getExercises() {
            return exercises;
        }

        public void setExercises(List<String> exercises) {
            this.exercises = exercises;
        }
    }
}
