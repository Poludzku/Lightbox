package com.poludzku.lightbox.app.di;

import com.poludzku.lightbox.app.di.scope.PerApplication;
import com.poludzku.lightbox.browser.di.BrowserComponent;
import com.poludzku.lightbox.browser.di.BrowserModule;
import com.poludzku.lightbox.main.di.MainComponent;
import com.poludzku.lightbox.main.di.MainModule;

import dagger.Component;

/**
 * Created by Jacek on 30/06/2017.
 */
@PerApplication
@Component (modules = {LightboxModule.class})
public interface LightboxComponent {
    MainComponent plus(MainModule mainModule);
    BrowserComponent plus(BrowserModule browserModule);
}
