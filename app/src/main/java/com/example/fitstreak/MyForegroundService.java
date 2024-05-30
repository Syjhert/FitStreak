package com.example.fitstreak;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyForegroundService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            Log.d("TAG", "Foreground service is running...");
                            TimeHandler.handleTime();
                            TipsHandler.showTip();
                            try{
                                Thread.sleep(2000);
                            }catch(InterruptedException e){
                                ///
                            }
                        }
                    }
                }
        ).start();

        final String CHANNEL_ID = "Fitstreak";
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_LOW);

        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notification = new Notification.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.health_icon)
                .setContentTitle("Fitstreak Foreground")
                        .setContentText("Foreground service is running...");
        startForeground(1001, notification.build());
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
