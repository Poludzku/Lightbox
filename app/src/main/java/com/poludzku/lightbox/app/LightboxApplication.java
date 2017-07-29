package com.poludzku.lightbox.app;

import android.app.Application;

import com.poludzku.lightbox.app.di.DaggerLightboxComponent;
import com.poludzku.lightbox.app.di.LightboxComponent;
import com.poludzku.lightbox.app.di.LightboxModule;

public class LightboxApplication extends Application {

    private LightboxComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerLightboxComponent.builder().lightboxModule(new LightboxModule(this)).build();

    }

    public LightboxComponent getComponent() {
        return component;
    }
}
