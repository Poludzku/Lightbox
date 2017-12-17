package com.poludzku.lightbox.app.di;

import com.poludzku.lightbox.app.di.qualifier.ForAlbum;
import com.poludzku.lightbox.app.di.qualifier.ForHistory;
import com.poludzku.lightbox.app.di.scope.PerApplication;
import com.poludzku.lightbox.app.repository.ImageMemoryRepository;
import com.poludzku.lightbox.app.repository.ImageRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MemoryRepositoryModule {


    @PerApplication
    @Provides
    @ForAlbum
    public ImageRepository albumRepository(ImageMemoryRepository memoryRepository) {
        return memoryRepository;
    }

    @PerApplication
    @Provides
    @ForHistory
    public ImageRepository historyRepository(ImageMemoryRepository memoryRepository) {
        return memoryRepository;
    }
}
