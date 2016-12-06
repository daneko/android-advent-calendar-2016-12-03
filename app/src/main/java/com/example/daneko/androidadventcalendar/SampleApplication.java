package com.example.daneko.androidadventcalendar;

import android.app.Application;

import timber.log.Timber;

/**
 */
public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
