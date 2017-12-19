package com.poludzku.lightbox.lightbox.di;

import com.poludzku.lightbox.app.di.scope.PerActivity;
import com.poludzku.lightbox.lightbox.LightboxActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {LightboxModule.class})
public interface LightboxComponent {
    void inject(LightboxActivity mainActivity);
}
