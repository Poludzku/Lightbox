package com.poludzku.lightbox.browser.main.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.poludzku.lightbox.R;
import com.poludzku.lightbox.browser.tab.view.ImageListFragment;

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
