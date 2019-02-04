package com.example.hansolz.example_app.Task_AlarmManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.hansolz.example_app.R;

import java.util.Calendar;

public class Main_Alram_Class extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    public static EditText inputText = null;
    private Button installText;
    private Calendar now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__alram__class);
        inputText = (EditText) findViewById(R.id.inputText);
        installText = (Button) findViewById(R.id.installButton);



        installText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");

            }
        });
    }

        @Override
        public void onTimeSet (TimePicker view,int hourOfDay, int minute){
            now = Calendar.getInstance();
            now.set(Calendar.HOUR_OF_DAY, hourOfDay);
            now.set(Calendar.MINUTE, minute);
            now.set(Calendar.SECOND, 0);
            startAlarm(now);

        }


        private void startAlarm (Calendar now){
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(this, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

            if (now.before(Calendar.getInstance())) {
                now.add(Calendar.DATE, 1);
            }

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, now.getTimeInMillis(), pendingIntent);
        }

    }
