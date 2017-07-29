package com.poludzku.lightbox.main.di;

import com.poludzku.lightbox.app.di.scope.PerActivity;
import com.poludzku.lightbox.main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by Jacek on 30/06/2017.
 */
@PerActivity
@Subcomponent (modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
