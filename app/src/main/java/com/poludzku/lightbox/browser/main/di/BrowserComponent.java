package com.poludzku.lightbox.browser.main.di;

import com.poludzku.lightbox.app.di.scope.PerActivity;
import com.poludzku.lightbox.browser.main.view.Browser;
import com.poludzku.lightbox.browser.tab.di.ImageListComponent;
import com.poludzku.lightbox.browser.tab.di.ImageListModule;

import dagger.Subcomponent;

@Subcomponent(modules = {BrowserModule.class})
@PerActivity
public interface BrowserComponent {
    void inject(Browser activity);

    ImageListComponent plus(ImageListModule imageListModule);
}
