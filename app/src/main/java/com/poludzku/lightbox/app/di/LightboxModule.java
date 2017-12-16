package com.poludzku.lightbox.app.di;

import android.content.ContentResolver;
import android.content.Context;

import com.poludzku.lightbox.app.di.scope.PerApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class LightboxModule {

    Context context;

    public LightboxModule(Context context) {
        this.context = context;
    }

    @Provides
    @PerApplication
    ContentResolver provideContentResolver() {
        return context.getContentResolver();
    }

}
