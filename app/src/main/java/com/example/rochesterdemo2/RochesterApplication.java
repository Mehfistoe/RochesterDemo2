package com.example.rochesterdemo2;

import android.app.Application;

import com.example.rochesterdemo2.util.UtilLog;

public class RochesterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }


}
