package com.example.hansolz.example_app.Task_AlarmManager;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.hansolz.example_app.R;

public class Settings_Notification extends ContextWrapper {

    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";

    private NotificationManager mManager;

    public Settings_Notification(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return mManager;
    }

    public NotificationCompat.Builder getChannelNotification() {
        Main_Alram_Class main_alram_class = new Main_Alram_Class();
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle("Information!!")
                .setContentText(main_alram_class.inputText.getText())
                .setSmallIcon(R.mipmap.ic_launcher);
    }
}
