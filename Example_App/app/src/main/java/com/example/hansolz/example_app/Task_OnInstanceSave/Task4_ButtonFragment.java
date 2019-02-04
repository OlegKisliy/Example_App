package com.example.hansolz.example_app.Task_OnInstanceSave;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hansolz.example_app.R;

public class Task4_ButtonFragment extends AppCompatActivity implements Exchange {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4__button_fragment);
    }

    @Override
    public void count(String data) {
        FragmentManager manager = getSupportFragmentManager();
        WithTextView withTextViewFragment =
                (WithTextView) manager.findFragmentById(R.id.fragment_withTextView);
        withTextViewFragment.changeText(data);
    }
}
