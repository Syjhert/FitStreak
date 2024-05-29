package com.example.fitstreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.fitstreak.activities.SignIn;
import com.example.fitstreak.database_utils.classes.Exercise;
import com.example.fitstreak.database_utils.classes.Medicine;
import com.example.fitstreak.database_utils.classes.Sleep;
import com.example.fitstreak.database_utils.classes.Water;

import java.util.ArrayList;
import java.util.List;

public class UserSetup extends AppCompatActivity {

    Button next1;
    Button next2;
    Button next3;
    Button next4;

    Button finish;

    LinearLayout IntroLayout;
    LinearLayout WaterSetup;
    LinearLayout SleepSetup;
    LinearLayout ExerciseSetup;
    LinearLayout MedicineSetup;

    Spinner howManyGlasses;
    Spinner waterRemindMeEvery;
    Spinner waterStartingFrom;

    Spinner sleepStrive;
    Spinner sleepSchedSpan;

    CheckBox exerciseSunday;
    CheckBox exerciseMonday;
    CheckBox exerciseTuesday;
    CheckBox exerciseWednesday;
    CheckBox exerciseThursday;
    CheckBox exerciseSaturday;
    CheckBox exerciseFriday;

    EditText exerciseTitle;

    EditText routine1;
    EditText routine2;
    EditText routine3;
    EditText routine4;

    Spinner exerciseSpan;

    EditText medicineText1;
    EditText medicineText2;

    Spinner medicineTime1;
    Spinner medicineTime2;

    CheckBox medicineSunday;
    CheckBox medicineMonday;
    CheckBox medicineTuesday;
    CheckBox medicineWednesday;
    CheckBox medicineThursday;
    CheckBox medicineSaturday;
    CheckBox medicineFriday;

    CheckBox medicineSunday2;
    CheckBox medicineMonday2;
    CheckBox medicineTuesday2;
    CheckBox medicineWednesday2;
    CheckBox medicineThursday2;
    CheckBox medicineSaturday2;
    CheckBox medicineFriday2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setup);

        IntroLayout = findViewById(R.id.IntroLayout);
        WaterSetup = findViewById(R.id.WaterSetup);
        SleepSetup = findViewById(R.id.SleepSetup);
        ExerciseSetup=findViewById(R.id.ExerciseSetup);
        MedicineSetup=findViewById(R.id.MedicineSetup);

        IntroLayout.setVisibility(View.VISIBLE);
        WaterSetup.setVisibility(View.GONE);
        SleepSetup.setVisibility(View.GONE);
        ExerciseSetup.setVisibility(View.GONE);
        MedicineSetup.setVisibility(View.GONE);

        next1 = findViewById(R.id.next1);
        next2 = findViewById(R.id.next2);
        next3 = findViewById(R.id.next3);
        next4 = findViewById(R.id.next4);

        finish = findViewById(R.id.finish);

        next1.setOnClickListener(view -> {
            IntroLayout.setVisibility(View.GONE);
            WaterSetup.setVisibility(View.VISIBLE);
        });

        next2.setOnClickListener(view -> {
            WaterSetup.setVisibility(View.GONE);
            SleepSetup.setVisibility(View.VISIBLE);
        });


        next3.setOnClickListener(view -> {
            SleepSetup.setVisibility(View.GONE);
            ExerciseSetup.setVisibility(View.VISIBLE);
        });

        next4.setOnClickListener(view -> {
            ExerciseSetup.setVisibility(View.GONE);
            MedicineSetup.setVisibility(View.VISIBLE);
        });

        howManyGlasses = findViewById(R.id.howManyGlasses);
        waterRemindMeEvery = findViewById(R.id.waterRemindMeEvery);
        waterStartingFrom = findViewById(R.id.waterStartingFrom);

        ArrayAdapter<Integer> howManyGlassesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
        howManyGlasses.setAdapter(howManyGlassesAdapter);

        ArrayAdapter<Integer> waterRemindMeEveryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
        waterRemindMeEvery.setAdapter(waterRemindMeEveryAdapter);

        ArrayAdapter<String> waterStartingFromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                new String[]{"5:00","5:30", "6:00", "6:30", "7:00","07:30", "9:30", "12:30", "16:30", "20:30"});
        waterStartingFrom.setAdapter(waterStartingFromAdapter);

        sleepStrive = findViewById(R.id.sleepGoalSpan);
        sleepSchedSpan = findViewById(R.id.sleepSchedSpan);

        ArrayAdapter<Integer> sleepStriveAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
        sleepStrive.setAdapter(sleepStriveAdapter);

        ArrayAdapter<String> sleepSchedSpanAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                new String[]{"5:00","5:30", "6:00", "6:30", "7:00","07:30", "9:30", "12:30", "16:30", "20:30"});
        sleepSchedSpan.setAdapter(sleepSchedSpanAdapter);

        exerciseSunday = findViewById(R.id.exerciseSunday);
        exerciseMonday = findViewById(R.id.exerciseMonday);
        exerciseWednesday = findViewById(R.id.exerciseWednesday);
        exerciseThursday = findViewById(R.id.exerciseThursday);
        exerciseFriday = findViewById(R.id.exerciseFriday);
        exerciseSaturday = findViewById(R.id.exerciseSaturday);
        exerciseTuesday = findViewById(R.id.exerciseSunday);

        routine1 = findViewById(R.id.routine1);
        routine2 = findViewById(R.id.routine2);
        routine3 = findViewById(R.id.routine3);
        routine4 = findViewById(R.id.routine4);

        exerciseTitle = findViewById(R.id.exerciseName);
        exerciseSpan = findViewById(R.id.exerciseSpan);

        ArrayAdapter<String> exerciseSpanAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                new String[]{"5:00","5:30", "6:00", "6:30", "7:00","07:30", "9:30", "12:30", "16:30", "20:30"});
        exerciseSpan.setAdapter(exerciseSpanAdapter);

        medicineText1 = findViewById(R.id.medicineName1);
        medicineText2 = findViewById(R.id.medicineName2);

        medicineSunday = findViewById(R.id.medicineSunday);
        medicineMonday = findViewById(R.id.medicineMonday);
        medicineTuesday = findViewById(R.id.medicineTuesday);
        medicineWednesday = findViewById(R.id.medicineWednesday);
        medicineThursday = findViewById(R.id.medicineThursday);
        medicineFriday = findViewById(R.id.medicineFriday);
        medicineSaturday = findViewById(R.id.medicineSaturday);

        medicineSunday2 = findViewById(R.id.medicineSunday2);
        medicineMonday2 = findViewById(R.id.medicineMonday2);
        medicineTuesday2 = findViewById(R.id.medicineTuesday2);
        medicineWednesday2 = findViewById(R.id.medicineWednesday2);
        medicineThursday2 = findViewById(R.id.medicineThursday2);
        medicineFriday2 = findViewById(R.id.medicineFriday2);
        medicineSaturday2 = findViewById(R.id.medicineSaturday2);

        medicineTime1 = findViewById(R.id.medicineTime1);
        medicineTime2 = findViewById(R.id.medicineTime2);

        ArrayAdapter<String> medicineTime1Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                new String[]{"5:00","5:30", "6:00", "6:30", "7:00","07:30", "9:30", "12:30", "16:30", "20:30"});
        medicineTime1.setAdapter(medicineTime1Adapter);

        ArrayAdapter<String> medicineTime2Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                new String[]{"5:00","5:30", "6:00", "6:30", "7:00","07:30", "9:30", "12:30", "16:30", "20:30"});
        medicineTime2.setAdapter(medicineTime2Adapter);

        finish = findViewById(R.id.finish);

        finish.setOnClickListener(view -> {
            setAllData();
        });

        exerciseDays = new ArrayList<>();
        routines = new ArrayList<>();
        medicine1Days = new ArrayList<>();
        medicine2Days = new ArrayList<>();
    }

    List<String> exerciseDays;
    List<String> routines;
    List<String> medicine1Days;
    List<String> medicine2Days;

    void setAllData(){
        //Water
        Integer glasses_count_goal = (Integer) howManyGlasses.getSelectedItem();
//        String reminder_interval = waterRemindMeEvery.getSelectedItem().toString();
        long reminder_interval = Long.parseLong(waterRemindMeEvery.getSelectedItem().toString());
        String remind_time_start = waterStartingFrom.getSelectedItem().toString();

        //Sleep
        Integer sleep_hours_goal = (Integer) sleepStrive.getSelectedItem();
        String sleep_time_start = sleepSchedSpan.getSelectedItem().toString();

        //Exerise
        String exerciseName = exerciseTitle.getText().toString();
        String exercise_time_start = exerciseSpan.getSelectedItem().toString();

        if(exerciseSunday.isChecked()) exerciseDays.add("Sunday");
        if(exerciseMonday.isChecked()) exerciseDays.add("Monday");
        if(exerciseTuesday.isChecked()) exerciseDays.add("Tuesday");
        if(exerciseWednesday.isChecked()) exerciseDays.add("Wednesday");
        if(exerciseThursday.isChecked()) exerciseDays.add("Thursday");
        if(exerciseFriday.isChecked()) exerciseDays.add("Friday");
        if(exerciseSaturday.isChecked()) exerciseDays.add("Saturday");

        routines.add(routine1.getText().toString());
        routines.add(routine2.getText().toString());
        routines.add(routine3.getText().toString());
        routines.add(routine4.getText().toString());

//        List<String> exerciseDays = new ArrayList<>();
//        List<String> routines = new ArrayList<>();



        //Medicine
        String medicine1Name = medicineText1.getText().toString();
        String time_to_take1 = medicineTime1.getSelectedItem().toString();

        if(medicineSunday.isChecked()) medicine1Days.add("Sunday");
        if(medicineMonday.isChecked()) medicine1Days.add("Monday");
        if(medicineTuesday.isChecked()) medicine1Days.add("Tuesday");
        if(medicineWednesday.isChecked()) medicine1Days.add("Wednesday");
        if(medicineThursday.isChecked()) medicine1Days.add("Thursday");
        if(medicineFriday.isChecked()) medicine1Days.add("Friday");
        if(medicineSaturday.isChecked()) medicine1Days.add("Saturday");

        String medicine2Name = medicineText2.getText().toString();
        String time_to_take2 = medicineTime2.getSelectedItem().toString();

        if(medicineSunday2.isChecked()) medicine2Days.add("Sunday");
        if(medicineMonday2.isChecked()) medicine2Days.add("Monday");
        if(medicineTuesday2.isChecked()) medicine2Days.add("Tuesday");
        if(medicineWednesday2.isChecked()) medicine2Days.add("Wednesday");
        if(medicineThursday2.isChecked()) medicine2Days.add("Thursday");
        if(medicineFriday2.isChecked()) medicine2Days.add("Friday");
        if(medicineSaturday2.isChecked()) medicine2Days.add("Saturday");

        System.out.println("Glasses Count Goal: " + glasses_count_goal);
        System.out.println("Reminder Interval: " + reminder_interval);
        System.out.println("Remind Time Start: " + remind_time_start);
        System.out.println("Sleep hours Start: " + sleep_time_start);
        System.out.println("Exercise Name: " + exerciseName);
        System.out.println("Exercise Days: "+ exerciseDays);
        System.out.println("Routines: " + routines);
        System.out.println("Exercise Time Start: " + exercise_time_start);
        System.out.println("Medicine Name 1: " + medicine1Name);
        System.out.println("Time to take 1: " + time_to_take1);
        System.out.println("Medicine Days: " + medicine1Days);
        System.out.println("Medicine Name 2: " + medicine2Name);
        System.out.println("Time to take 2: " + time_to_take2);
        System.out.println("Medicine Days 2: " + medicine2Days);



        Water water = new Water(glasses_count_goal, reminder_interval, remind_time_start);
        Sleep sleep = new Sleep(sleep_hours_goal, sleep_time_start);
        Exercise exercise = new Exercise(exercise_time_start, exerciseDays, routines);
        Medicine medicine = new Medicine(
                medicine1Name, time_to_take1, medicine1Days,
                medicine2Name, time_to_take2, medicine2Days);

        SignIn.fireStore.setUpUser(water, sleep, exercise, medicine);

        Intent intent = new Intent(UserSetup.this, MainActivity.class);
        startActivity(intent);

//        List<String> medicine1Days = new ArrayList<>();
//        List<String> medicine2Days = new ArrayList<>();
    }
}