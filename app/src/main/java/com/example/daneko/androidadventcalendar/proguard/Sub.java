package com.example.daneko.androidadventcalendar.proguard;

import android.os.Handler;

import timber.log.Timber;

/**
 */
public class Sub extends Super {

    @Override
    public String method() {
        return "Sub";
    }

    String wrap() {
        return super.method();
    }

    public void log() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Timber.v("call super method, return : %s", Sub.super.method()); // this is not return "Super" when using proguard5.3
                Timber.v("call this method, return : %s", method());
                Timber.v("call wrap method, return : %s", wrap());
            }
        });

    }
}
