package com.poludzku.lightbox.browser.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.poludzku.lightbox.browser.tab.view.ImageListFragment;

import javax.inject.Inject;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return ImageListFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
