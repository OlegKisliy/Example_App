package com.example.hansolz.example_app.Task_DialogFragment;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Task3_Activity extends DialogFragment  implements View.OnClickListener {

    final String LOG_TAG = "myLogs";
import com.example.hansolz.example_app.R;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Title!");
        View v = inflater.inflate(R.layout.activity_task3_, null);
        v.findViewById(R.id.btnYes).setOnClickListener((View.OnClickListener) this);
        v.findViewById(R.id.btnNo).setOnClickListener((View.OnClickListener) this);
        v.findViewById(R.id.btnMaybe).setOnClickListener((View.OnClickListener) this);
        return v;
    }

    public void onClick(View v) {
        Log.d(LOG_TAG, "Dialog 1: " + ((Button) v).getText());
        dismiss();
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "Dialog 1: onDismiss");
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }
}

