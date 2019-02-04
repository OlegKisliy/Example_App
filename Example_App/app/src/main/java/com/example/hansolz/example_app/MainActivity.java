package com.example.hansolz.example_app;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hansolz.example_app.Task_AlarmManager.Main_Alram_Class;
import com.example.hansolz.example_app.Task_Api.Task5_Activity;
import com.example.hansolz.example_app.Task_Api.Task5_MAin;
import com.example.hansolz.example_app.Task_Camera.Task2_Activity;
import com.example.hansolz.example_app.Task_DialogFragment.Task3_Activity;
import com.example.hansolz.example_app.Task_FireBase_Notifications.FireBase_Notifications;
import com.example.hansolz.example_app.Task_OnInstanceSave.Task4_ButtonFragment;
import com.example.hansolz.example_app.Task_Preferences_SaveFileBitmap.Task1_Activity;

public class MainActivity extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5,button6,button7,button8;
    DialogFragment dialog;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        dialog = new Task3_Activity();
        fragment = new Task5_Activity();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Task1_Activity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Task2_Activity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show(getSupportFragmentManager(),"dlg1");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Task4_ButtonFragment.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Task5_MAin.class);
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , FireBase_Notifications.class);
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Main_Alram_Class.class);
                startActivity(intent);
            }
        });

    }
}
