package com.example.hansolz.example_app.Task_OnInstanceSave;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hansolz.example_app.R;

public class WithButton extends Fragment implements View.OnClickListener {
    private int myCounter = 0;
    private  Exchange exchange;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View firstView = inflater.inflate(R.layout.activity_with_button,container,false);

        Button button = (Button)firstView.findViewById(R.id.buttonTestView);
        button.setOnClickListener(this);
        if (savedInstanceState == null) {
            myCounter = 0;
        } else {
            myCounter = savedInstanceState.getInt("counter", 0);
        }
        return firstView;
    }

    @Override
    public void onClick(View v) {
        myCounter++;
        exchange.count("Ви нажали" + myCounter + "раз");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        exchange = (Exchange)getActivity();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", myCounter);
    }
}
