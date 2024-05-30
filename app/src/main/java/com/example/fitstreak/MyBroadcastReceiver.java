package com.example.fitstreak;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {

    //Para kung iclose sa user ang app, active gihapon siya sa background
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED) ||
                intent.getAction().equals(Intent.ACTION_SHUTDOWN)) {
            Intent serviceIntent = new Intent(context, MyForegroundService.class);
            context.startForegroundService(serviceIntent);
        }else if(intent.getAction().equals(Intent.ACTION_PACKAGE_FIRST_LAUNCH)){
            Intent serviceIntent = new Intent(context, MyForegroundService.class);
            context.stopService(serviceIntent);
        }
    }
}