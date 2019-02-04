package com.example.hansolz.example_app.Task_AlarmManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Settings_Notification  settings_notification = new Settings_Notification(context);
        NotificationCompat.Builder builder = settings_notification.getChannelNotification();
        settings_notification.getManager().notify(1, builder.build());
    }
}
