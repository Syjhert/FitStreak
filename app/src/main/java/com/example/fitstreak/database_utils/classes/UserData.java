package com.example.fitstreak.database_utils.classes;

public class UserData {
    private Water water;
    private Sleep sleep;
    private Exercise exercise;
    private Medicine medicine;


    public UserData() {}

    public Water getWater() { return water; }
    public void setWater(Water water) { this.water = water; }

    public Sleep getSleep() { return sleep; }
    public void setSleep(Sleep sleep) { this.sleep = sleep; }

    public Exercise getExercise() { return exercise; }
    public void setExercise(Exercise exercise) { this.exercise = exercise; }

    public Medicine getMedicine() { return medicine; }
    public void setMedicine(Medicine medicine) { this.medicine = medicine; }
}
