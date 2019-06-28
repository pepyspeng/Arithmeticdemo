package com.arithmeticdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CameraLicesenShade shade = findViewById(R.id.shade);
        shade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }





    public String TAG = "MainActivity";
    public String TAG1 = "dispatchTouchEvent--";
    public String TAG2 = "onInterceptTouchEvent--";
    public String TAG3 = "onTouchEvent--";

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, TAG1 + "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, TAG1 + "ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, TAG1 + "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, TAG1 + "ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }



    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, TAG3 + "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, TAG3 + "ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, TAG3 + "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, TAG3 + "ACTION_CANCEL");
                break;
        }
        return super.onTouchEvent(ev);
    }
}
