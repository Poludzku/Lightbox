package com.poludzku.lightbox.lightbox.di;

import com.poludzku.lightbox.app.di.scope.PerActivity;
import com.poludzku.lightbox.lightbox.view.MainView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }


    @Provides
    @PerActivity
    MainView mainView(){
        return view;
    }
}

