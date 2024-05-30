package com.example.fitstreak;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;

import com.example.fitstreak.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MyNotificationManager {

    private static final String CHANNEL_ID = "FitStreak";
    private static final String CHANNEL_NAME = "FitStreak";
    private static final String CHANNEL_DESC = "FitStreak All in one App";
    private static final String NOTIFICATION_PREF = "notification_pref";
    private static final String NOTIFICATION_SENT_KEY = "notification_sent";
    public static NotificationManager notifManager;

    public static void setNotifManager(NotificationManager notifManager) {
        MyNotificationManager.notifManager = notifManager;
        NotificationChannel notifChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        notifManager.createNotificationChannel(notifChannel);
    }

    public static void postNotification(String channelTitle, String channelText) {
        if (!isNotificationSent(channelTitle)) {
            Notification notif = new NotificationCompat.Builder(MainActivity.getAppContext(), CHANNEL_ID)
                    .setSmallIcon(R.drawable.health_icon)
                    .setContentTitle(channelTitle)
                    .setContentText(channelText)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build();
            notifManager.notify(1, notif);
            markNotificationSent(channelTitle);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    unMarkNotification(channelTitle);
                }
            }, 60000);
        }
    }

    private static boolean isNotificationSent(String channelTitle) {
        SharedPreferences prefs = MainActivity.getAppContext().getSharedPreferences(NOTIFICATION_PREF, Context.MODE_PRIVATE);
        return prefs.getBoolean(channelTitle, false);
    }

    private static void markNotificationSent(String channelTitle) {
        SharedPreferences prefs = MainActivity.getAppContext().getSharedPreferences(NOTIFICATION_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(channelTitle, true);
        editor.apply();
    }

    public static void unMarkNotification(String channelTitle) {
        SharedPreferences prefs = MainActivity.getAppContext().getSharedPreferences(NOTIFICATION_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(channelTitle);
        editor.apply();
    }
}