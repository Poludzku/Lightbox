package com.poludzku.lightbox.app;

import android.app.Application;

import com.poludzku.lightbox.app.di.AppComponent;
import com.poludzku.lightbox.app.di.AppModule;
import com.poludzku.lightbox.app.di.DaggerAppComponent;

public class LightboxApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

    }

    public AppComponent getComponent() {
        return component;
    }
}
