package com.example.fitstreak;

import static androidx.core.app.NotificationCompat.PRIORITY_DEFAULT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitstreak.activities.SignIn;
import com.example.fitstreak.database_utils.callbacks.UpdateCallback;
import com.example.fitstreak.database_utils.callbacks.WaterCallback;
import com.example.fitstreak.database_utils.classes.Water;
import com.google.firebase.firestore.auth.User;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSIONS_CODE = 1;
    private static final int FOREGROUND_PERMISSION_CODE = 2;

    LinearLayout WaterLayout;
    LinearLayout WaterButton;
    LinearLayout CustomLayout;

    private static final String CHANNEL_ID = "FitStreak";
    private static final String CHANNEL_NAME = "FitStreak";
    private static final String CHANNEL_DESC = "FitStreak All in one App";
    TextView txtDrankWaterCount;

    public static MainActivity instance;

    public static Context getAppContext() {
        return instance.getApplicationContext();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;

        MyNotificationManager.setNotifManager((NotificationManager) getSystemService(NotificationManager.class));

        requestNecessaryPermissions();


        txtDrankWaterCount = findViewById(R.id.txtDrankWaterCount);

        String UID = SignIn.auth.getCurrentUser().getUid();

        SignIn.fireStore.getData(UID, data -> {
            Water water = data.getWater();
            txtDrankWaterCount.setText(water.getGlass_drank_count() + "");

        });

        WaterLayout = (LinearLayout) findViewById(R.id.WaterLayout);
        WaterButton = (LinearLayout) findViewById(R.id.WaterButton);
        WaterButton.setOnClickListener(new View.OnClickListener() {
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
        CustomLayout = (LinearLayout) findViewById(R.id.CustomLayout);
        CustomLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        UserSetup.class
                );
                startActivity(intent);
            }
        });
    }

    private void requestNecessaryPermissions() {
        if (checkSelfPermission(Manifest.permission.ACTIVITY_RECOGNITION) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(Manifest.permission.BODY_SENSORS) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(new String[]{
                    Manifest.permission.ACTIVITY_RECOGNITION,
                    Manifest.permission.BODY_SENSORS,
                    Manifest.permission.FOREGROUND_SERVICE_HEALTH,
                    Manifest.permission.POST_NOTIFICATIONS
            }, REQUEST_PERMISSIONS_CODE);
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // Handle the case where no activity is found to handle the intent
                Toast.makeText(this, "Battery optimization settings not available on this device", Toast.LENGTH_SHORT).show();
            }
        }else{
            Intent intent = new Intent(
                    MainActivity.this,
                    MyForegroundService.class
            );
            startForegroundService(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_PERMISSIONS_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(
                        MainActivity.this,
                        MyForegroundService.class
                );
                startForegroundService(intent);
            }
        }
    }

}