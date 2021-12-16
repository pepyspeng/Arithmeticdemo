package com.arithmeticdemo.demo;

import android.content.Context;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class ScrollView2 extends ScrollView {

    public ScrollView2(Context context) {
        super(context);
    }

    public ScrollView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        final int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                return false;
        }
        return super.onInterceptTouchEvent(ev);

    }
}
