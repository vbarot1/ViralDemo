package com.example.dinesh.viraldemo;

import android.app.Application;

import com.example.dinesh.viraldemo.util.UtilLog;

/**
 * Created by Dinesh on 2/6/2017.
 */

public class ViralApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}
