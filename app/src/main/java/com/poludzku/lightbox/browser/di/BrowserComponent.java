package com.poludzku.lightbox.browser.di;

import com.poludzku.lightbox.app.di.scope.PerActivity;
import com.poludzku.lightbox.browser.tab.di.ImageListComponent;
import com.poludzku.lightbox.browser.tab.di.ImageListModule;
import com.poludzku.lightbox.browser.tab.view.ImageListFragment;
import com.poludzku.lightbox.browser.view.Browser;

import dagger.Subcomponent;

@Subcomponent(modules = {BrowserModule.class})
@PerActivity
public interface BrowserComponent {
    void inject(Browser activity);
    ImageListComponent plus(ImageListModule imageListModule);
}
