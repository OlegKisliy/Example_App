package com.example.hansolz.example_app.Task_FireBase_Notifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hansolz.example_app.R;
import com.google.firebase.iid.FirebaseInstanceId;

public class FireBase_Notifications extends AppCompatActivity {
    private  static final String TAG = "myLogs";
    private Button buttonShowToken;
    private TextView textView;
    private  String token = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base__notifications);
        buttonShowToken = (Button)findViewById(R.id.buttonFireBase);
        textView = (TextView)findViewById(R.id.TextTOKEN);
        buttonShowToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 token = FirebaseInstanceId.getInstance().getToken();
                Log.d(TAG, "Token: " + token);
                Toast.makeText(FireBase_Notifications.this, token, Toast.LENGTH_LONG).show();
                textView.setText(token);
            }
        });

    }
}
