package com.arithmeticdemo.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ScrollView1 extends android.widget.ScrollView {

    private int maxY;
    private float mDownPosX;
    private float mDownPosY;

    public ScrollView1(Context context) {
        super(context);
    }

    public ScrollView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        maxY = getChildAt(0).getMeasuredHeight() - getMeasuredHeight();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        final float x = ev.getX();
        final float y = ev.getY();

        final int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                getParent().getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("getScrollY():" + getScrollY() + "--maxY:" + maxY + "-result:" + ((getScrollY() > 0 && getScrollY() < maxY)));
                if (getScrollY() > 0 && getScrollY() < maxY)
                    getParent().requestDisallowInterceptTouchEvent(true);
                else
                    getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case MotionEvent.ACTION_UP:
//                getParent().getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }

        return super.dispatchTouchEvent(ev);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        final float x = ev.getX();
//        final float y = ev.getY();
//
//        final int action = ev.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                mDownPosX = x;
//                mDownPosY = y;
//                getParent().getParent().requestDisallowInterceptTouchEvent(true);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                System.out.println("getScrollY():" + getScrollY() + "--maxY:" + maxY + "-result:" + ((getScrollY() > 0 && getScrollY() < maxY)));
//                if (getScrollY() > 0 && getScrollY() < maxY)
//                    getParent().requestDisallowInterceptTouchEvent(true);
//                else
//                    getParent().requestDisallowInterceptTouchEvent(false);
////                final float deltaX = Math.abs(x - mDownPosX);
////                final float deltaY = Math.abs(y - mDownPosY);
////                // 这里是够拦截的判断依据是左右滑动，读者可根据自己的逻辑进行是否拦截
////                System.out.println("deltaX：" + deltaX + "---deltaY:" + deltaY + "-result:" + (deltaX > deltaY));
////                if (deltaX > deltaY) {
////                    return false;
////                }
//                break;
//            case MotionEvent.ACTION_UP:
//                getParent().getParent().requestDisallowInterceptTouchEvent(false);
//                break;
//        }
//
//        return super.onInterceptTouchEvent(ev);
//    }
}
