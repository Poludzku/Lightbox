package com.poludzku.lightbox.browser.tab.di;

import com.poludzku.lightbox.browser.tab.view.ImageListAdapter;
import com.poludzku.lightbox.browser.tab.view.ImageListAdapterImpl;

import dagger.Module;
import dagger.Provides;


@Module
public class ImageListModule {

    @Provides
    ImageListAdapter imageListAdapter(ImageListAdapterImpl imageListAdapter) {
        return imageListAdapter;
    }
}
