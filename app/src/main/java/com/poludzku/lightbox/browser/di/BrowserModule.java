package com.poludzku.lightbox.browser.di;

import android.support.v4.app.FragmentManager;

import com.poludzku.lightbox.browser.view.SectionsPagerAdapter;

import dagger.Module;
import dagger.Provides;


@Module
public class BrowserModule {

    private FragmentManager fragmentManager;

    public BrowserModule(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Provides
    SectionsPagerAdapter sectionsPagerAdapter() {
       return new SectionsPagerAdapter(fragmentManager);
   }
}
