package com.poludzku.lightbox.app.di;

import android.arch.lifecycle.MutableLiveData;

import com.poludzku.lightbox.app.di.qualifier.ForAlbum;
import com.poludzku.lightbox.app.di.qualifier.ForHistory;
import com.poludzku.lightbox.app.di.scope.PerApplication;
import com.poludzku.lightbox.app.model.Image;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class MemoryRepositoryModule {


    @PerApplication
    @Provides
    @ForAlbum
    public MutableLiveData<List<Image>> albumRepository() {
        return new MutableLiveData<>();
    }

    @PerApplication
    @Provides
    @ForHistory
    public MutableLiveData<List<Image>> historyRepository() {
        return new MutableLiveData<>();
    }
}
