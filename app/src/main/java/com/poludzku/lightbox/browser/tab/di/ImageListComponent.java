package com.poludzku.lightbox.browser.tab.di;

import com.poludzku.lightbox.browser.tab.view.ImageListFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {ImageListModule.class})
public interface ImageListComponent {
    void inject(ImageListFragment imageListFragment);
}
