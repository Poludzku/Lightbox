package com.poludzku.lightbox.app.di;

import com.poludzku.lightbox.app.di.scope.PerApplication;
import com.poludzku.lightbox.browser.main.di.BrowserComponent;
import com.poludzku.lightbox.browser.main.di.BrowserModule;
import com.poludzku.lightbox.lightbox.di.MainComponent;
import com.poludzku.lightbox.lightbox.di.MainModule;

import dagger.Component;


@PerApplication
@Component(modules = {AppModule.class})
public interface AppComponent {
    MainComponent plus(MainModule mainModule);

    BrowserComponent plus(BrowserModule browserModule);
}
