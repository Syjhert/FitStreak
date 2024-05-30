package com.example.fitstreak;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TipsHandler {
    private static List<String> tips = new ArrayList<String>(){
        {
            //Sleep
            add("You need 8 hours of sleep for optimal immune system and energy!");
            add("Sleep deprivation increases anxiety, depression, and mood swings :(");
            add("Having a regular sleep schedule can positively affect key areas in your life");

            //Water
            add("Drinking water brings nutrients to the cells, cleanse wastes, and maintains body temp");
            add("Drink at least 12 glasses of water to help your body circulate");
            add("Headaches, dizziness, and tiredness are some signs of dehydration!");

            //Exercise
            add("Pick exercises that are fun for you. This way you can also enjoy being fit!");
            add("Exercise boosts your energy, builds strength, reduces stress, and makes you confident");
            add("The lack of routine exercise can cause your muscles to weaken :(");

            //Medicine
            add("Prescribed medicines improves your chance of a better health outcome");
            add("Supplements can help improve your overall health and may reduce health risks");
            add("Forgetting to take your prescribed medicine can only worsen your condition :(");
        }
    };
    private static Random random = new Random();
    private static Timer timer = new Timer();
    private static boolean isTaskScheduled = false;
//    private static final TimerTask task = new TimerTask() {
//        @Override
//        public void run() {
//            Toast.makeText(MainActivity.getAppContext(), tips.get(random.nextInt(tips.size())),
//                    Toast.LENGTH_LONG).show();
//            isTaskScheduled = false;
//        }
//    };
//
//    public static void showTip(){
//        if(!isTaskScheduled){
//            timer.schedule(task, 60000);
//            isTaskScheduled = true;
//        }
//    }
    private static Handler mainHandler = new Handler(Looper.getMainLooper());

    public static void showTip() {
        if (!isTaskScheduled) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.getAppContext(), tips.get(random.nextInt(tips.size())),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                    isTaskScheduled = false;
                }
            };

            timer.schedule(task, 60000);
            isTaskScheduled = true;
        }
    }
}
