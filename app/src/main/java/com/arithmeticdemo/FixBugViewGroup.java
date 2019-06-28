package com.arithmeticdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class FixBugViewGroup extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {

    public FixBugViewGroup(Context context) {
        super(context);
    }

    public FixBugViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixBugViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public String TAG = "ViewGroup";
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

    float oldDx;
    float oldDy;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, TAG2 + "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, TAG2 + "ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, TAG2 + "ACTION_MOVE");
                if (ev.getX() - oldDx > 10) {
                    Log.e(TAG, TAG2 + "move拦截");
                    return true;
                }
                oldDx = ev.getX();
                oldDy = ev.getY();
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, TAG2 + "ACTION_CANCEL");
                break;
        }
        return false;
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
        return true;
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
