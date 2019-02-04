package com.example.hansolz.example_app.Task_FireBase_Notifications;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFireBaseInstanceIDService extends FirebaseInstanceIdService {
private static final String TAG = "MyFireBaseIdTag";

    @Override
    public void onTokenRefresh() {
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "NEw Token:"+ refreshToken);

    }
}
