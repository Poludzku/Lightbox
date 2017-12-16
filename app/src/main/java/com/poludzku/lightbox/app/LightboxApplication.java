package com.poludzku.lightbox.app;

import android.app.Application;

import com.poludzku.lightbox.app.di.AppComponent;
import com.poludzku.lightbox.app.di.DaggerAppComponent;
import com.poludzku.lightbox.app.di.LightboxModule;

public class LightboxApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().lightboxModule(new LightboxModule(this)).build();

    }

    public AppComponent getComponent() {
        return component;
    }
}
