package com.poludzku.lightbox.app.di;

import android.content.ContentResolver;
import android.content.Context;

import com.poludzku.lightbox.app.di.scope.PerApplication;
import com.poludzku.lightbox.main.domain.ReadImageFromContentResolver;
import com.poludzku.lightbox.main.domain.ReadImageFromContentResolverImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jacek on 30/06/2017.
 */
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


    @Provides
    @PerApplication
    ReadImageFromContentResolver readImageFromContentResolver(ReadImageFromContentResolverImpl readImageFromContentResolver) {
        return readImageFromContentResolver;
    }

}
