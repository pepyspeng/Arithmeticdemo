package com.arithmeticdemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class MyApplication extends Application {


    public static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        setupLeakCanary();
        myApplication = this;
    }

    public static MyApplication getInstance() {
        return myApplication;
    }

    protected void setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
