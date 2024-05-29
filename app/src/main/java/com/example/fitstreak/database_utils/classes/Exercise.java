package com.example.fitstreak.database_utils.classes;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
//    private List<Routine> routines;

    private List<String> routines;
    private List<String> exercise_days;
    private String exercise_time_start;

    public Exercise() {}

    public Exercise(String exercise_time_start,
                    List<String> exercise_days,
                    List<String> routines) {

        this.exercise_time_start = exercise_time_start;
        this.exercise_days = exercise_days;
        this.routines = routines;
    }

    public Exercise(String s) {
        routines = new ArrayList<>();
        routines.add("Routine 1");
        exercise_days = new ArrayList<>();
        exercise_days.add("Monday");
        exercise_days.add("Tuesday");
        exercise_time_start = "6:30";
    }

    public List<String> getRoutines() { return routines; }
    public void setRoutines(List<String> routines) { this.routines = routines; }

    public List<String> getExercise_days() { return exercise_days; }
    public void setExercise_days(List<String> exercise_days) { this.exercise_days = exercise_days; }

    public String getExercise_time_start() { return exercise_time_start; }
    public void setExercise_time_start(String exercise_time_start) { this.exercise_time_start = exercise_time_start; }

    //    public String getExercise_time_start() { return exercise_time_start; }
//    public void setExercise_time_start(String exercise_time_start) { this.exercise_time_start = exercise_time_start; }
//
//    public List<Routine> getRoutines() { return routines; }
//
//    public void addRoutine(String name, List<String> days, List<String> exercises) {
//        routines.add(new Routine(name, days, exercises));
//    }
//
//    public void setRoutines(List<Routine> routines) { this.routines = routines; }
//
//    public static class Routine {
//        private String name;
//        private List<String> days;
//        private List<String> exercises;
//
//        public Routine() {}
//
//        public Routine(String name, List<String> days, List<String> exercises) {
//            this.name = name;
//            this.days = days;
//            this.exercises = exercises;
//        }
//
//        public Routine(String s) {
//            days = new ArrayList<>();
//            days.add("Monday");
//
//            exercises = new ArrayList<>();
//            exercises.add("Push ups");
//        }
//
//        // Getters and setters
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public List<String> getDays() {
//            return days;
//        }
//
//        public void setDays(List<String> days) {
//            this.days = days;
//        }
//
//        public List<String> getExercises() {
//            return exercises;
//        }
//
//        public void setExercises(List<String> exercises) {
//            this.exercises = exercises;
//        }
//    }
}
