package com.example.fitstreak;

import static androidx.core.app.NotificationCompat.PRIORITY_DEFAULT;

import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyNotificationManager {

    final private static String CHANNEL_ID = "FitStreak";

    public static void displayNotification(Context context, String channelTitle, String channelText ) {
        NotificationManagerCompat nManager = NotificationManagerCompat.from(context);
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Notification notif = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.health_icon)
                .setContentTitle(channelTitle)
                .setContentText(channelText)
                .setPriority(PRIORITY_DEFAULT)
                .build();
        nManager.notify(1, notif);
    }
}
