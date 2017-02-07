package com.example.dinesh.viraldemo.util;

import android.util.Log;

/**
 * Created by Dinesh on 2/6/2017.
 */

public class UtilLog {

    private static boolean Debug = false;

    public static void setDebug(boolean b){

        Debug = b;

    }
    public static void logd(String key, String value) {

        if(Debug) {

            Log.d(key,value);
        }

    }

    public static void logD(String testD, String toast) {
    }

    public static void logV(String testD, String toast) {
    }

    public static void logW(String testD, String toast) {
    }

    public static void logI(String testD, String toast) {
    }
}
