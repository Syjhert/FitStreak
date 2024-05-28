package com.example.fitstreak;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout WaterLayout;

    private static final String CHANNEL_ID = "FitStreak";
    private static final String CHANNEL_NAME = "FitStreak";
    private static final String CHANNEL_DESC = "FitStreak All in one App";

    private MyNotificationManager myNotificationManager;

    private static AppCompatActivity instance;
    public static Context getAppContext() {
        return instance.getApplicationContext();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;

        Intent intent = new Intent(
                MainActivity.this,
                MyForegroundService.class
        );
        startForegroundService(intent);

//        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
//        channel.setDescription(CHANNEL_DESC);
//        NotificationManager manager = getSystemService(NotificationManager.class);
//        manager.createNotificationChannel(channel);

//        myNotificationManager = new MyNotificationManager(this, CHANNEL_ID);

        WaterLayout = (LinearLayout) findViewById(R.id.WaterLayout);
        WaterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToWaterActivity = new Intent(
                        MainActivity.this, WaterActivity.class
                );
                startActivity(intentToWaterActivity);
            }
        });
    }

    public boolean foregroundServiceRunning(){
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        for(ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)){
            if(MyForegroundService.class.getName().equals(service.service.getClassName())){
                return true;
            }
        }
        return false;
    }

}