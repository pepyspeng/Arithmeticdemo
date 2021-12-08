package com.arithmeticdemo;

import android.animation.ObjectAnimator;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.arithmeticdemo.demo.ChangeActivity;
import com.arithmeticdemo.service.DownJobService;

import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate");
//        TextView mButton = findViewById(R.id.tv1);
//        ObjectAnimator oaY=ObjectAnimator.ofFloat(mButton, "rotationY", 0,360);
//        oaY.setStartDelay(2000);
//        oaY.setDuration(5000);
//        oaY.start();
//        // 步骤1:创建 需要设置动画的 视图View
//        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.view_animation_rotate);
//        // 步骤2:创建 动画对象 并传入设置的动画效果xml文件
//        mButton.startAnimation(translateAnimation);
//        // 步骤3:播放动画
//
//        Handler handler = new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(Message msg) {
//                return false;
//            }
//        });
    }

    public void OnTv1Click(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                ChangeActivity.callActivity(this);
                break;
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    private void JobService() {
        JobScheduler mJobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(getPackageName(),
                DownJobService.class.getName()))
                .setPersisted(true)
//                .setMinimumLatency(1000*3)//这个函数能让你设置任务的延迟执行时间(单位是毫秒),这个函数与setPeriodic(long time)方法不兼容，如果这两个方法同时调用了就会引起异常；
                .setPeriodic(1000 * 5);//每隔三秒运行一次
        mJobScheduler.schedule(builder.build());
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
