package com.arithmeticdemo.demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate: ");
        super.onCreate();
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: ");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}