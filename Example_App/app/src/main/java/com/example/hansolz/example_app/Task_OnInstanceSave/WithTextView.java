package com.example.hansolz.example_app.Task_OnInstanceSave;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hansolz.example_app.R;

public class WithTextView extends Fragment {
    private TextView myTextView;
    private String myData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View firstView = inflater.inflate(R.layout.activity_with_text_view,container,false);
        myTextView = (TextView)firstView.findViewById(R.id.textTestView);
        if(savedInstanceState == null){

        }else {
            myData = savedInstanceState.getString("text");
            myTextView.setText(myData);
        }
        return firstView;
    }
    public void changeText(String data){
        myData = data;
        myTextView.setText(data);
    }
}
