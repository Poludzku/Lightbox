package com.poludzku.lightbox.browser.main.di;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import com.poludzku.lightbox.app.di.scope.PerActivity;
import com.poludzku.lightbox.browser.main.view.SectionsPagerAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class BrowserModule {

    private FragmentManager fragmentManager;
    private Activity activity;

    public BrowserModule(FragmentManager fragmentManager, Activity activity) {
        this.fragmentManager = fragmentManager;
        this.activity = activity;
    }

    @Provides
    @PerActivity
    SectionsPagerAdapter sectionsPagerAdapter() {
        return new SectionsPagerAdapter(fragmentManager);
    }

    @PerActivity
    @Provides
    Activity activity() {
        return activity;
    }

}
