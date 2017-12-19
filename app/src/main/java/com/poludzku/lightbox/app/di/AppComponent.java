package com.poludzku.lightbox.app.di;

import com.poludzku.lightbox.app.di.scope.PerApplication;
import com.poludzku.lightbox.browser.main.di.BrowserComponent;
import com.poludzku.lightbox.browser.main.di.BrowserModule;
import com.poludzku.lightbox.lightbox.di.LightboxComponent;
import com.poludzku.lightbox.lightbox.di.LightboxModule;

import dagger.Component;


@PerApplication
@Component(modules = {AppModule.class,MemoryRepositoryModule.class})
public interface AppComponent {
    LightboxComponent plus(LightboxModule lightboxModule);

    BrowserComponent plus(BrowserModule browserModule);
}
