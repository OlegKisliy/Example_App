package com.example.hansolz.example_app.Task_Api;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hansolz.example_app.R;

public class Task5_MAin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5__main);
        FragmentManager manager = getSupportFragmentManager();
        Task5_Activity task5_activity =
                (Task5_Activity) manager.findFragmentById(R.id.fragment_withWebView);

    }
}
