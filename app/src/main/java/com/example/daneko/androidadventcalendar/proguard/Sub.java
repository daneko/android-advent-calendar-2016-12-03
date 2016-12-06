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
        new Handler().post(() -> {
            Timber.v("call super method, return : %s", super.method());
            Timber.v("call this method, return : %s", method());
            Timber.v("call wrap method, return : %s", wrap());
        });

    }
}
