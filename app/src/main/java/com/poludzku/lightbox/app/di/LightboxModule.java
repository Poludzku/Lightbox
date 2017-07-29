package com.poludzku.lightbox.app.di;

import android.content.Context;

import com.poludzku.lightbox.app.di.scope.PerActivity;
import com.poludzku.lightbox.app.di.scope.PerApplication;
import com.poludzku.lightbox.app.repository.ImageRepository;
import com.poludzku.lightbox.app.repository.MockImageRepository;

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
    ImageRepository imageRepository(){
        return new MockImageRepository(context);
    }


}
