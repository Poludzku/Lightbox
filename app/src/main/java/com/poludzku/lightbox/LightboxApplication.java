package com.poludzku.lightbox;

import android.app.Application;

import com.google.firebase.crash.FirebaseCrash;

public class LightboxApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseCrash.report(new Exception("My first Android non-fatal error"));
    }
}
