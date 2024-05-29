package com.example.fitstreak;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fitstreak.activities.SignIn;
import com.example.fitstreak.database_utils.callbacks.UpdateCallback;
import com.example.fitstreak.database_utils.callbacks.WaterCallback;
import com.example.fitstreak.database_utils.classes.Water;

public class MainActivity extends AppCompatActivity {
    LinearLayout WaterLayout;

    private static final String CHANNEL_ID = "FitStreak";
    private static final String CHANNEL_NAME = "FitStreak";
    private static final String CHANNEL_DESC = "FitStreak All in one App";


    private MyNotificationManager myNotificationManager;

    TextView txtDrankWaterCount;

    private static AppCompatActivity instance;
    public static Context getAppContext() {
        return instance.getApplicationContext();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;

        txtDrankWaterCount = findViewById(R.id.txtDrankWaterCount);

        String UID = SignIn.auth.getCurrentUser().getUid();

        SignIn.fireStore.getData(UID, data -> {
            Water water = data.getWater();
            txtDrankWaterCount.setText(water.getGlass_drank_count() + "");

        });

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

                SignIn.fireStore.getData(UID, data -> {

                    Water water = data.getWater();
                    int currentCount = water.getGlass_drank_count();
                    currentCount++;
                    water.setGlass_drank_count(currentCount);

                    txtDrankWaterCount.setText(String.valueOf(currentCount));

                    data.setWater(water);

                    txtDrankWaterCount.setText(water.getGlass_drank_count() + "");
                    SignIn.fireStore.updateUserData(UID, data, new UpdateCallback() {
                        @Override
                        public void onUpdate() {
                            Log.d("MainActivity", "Glass count updated in Firestore");
                        }
                    });
                });

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