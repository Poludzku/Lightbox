package com.poludzku.lightbox.browser.main.view;

import android.support.v4.view.ViewPager;
import android.view.View;

public class FabVisibilityHandler implements ViewPager.OnPageChangeListener {

    private final View fab;

    FabVisibilityHandler(View fab) {
        this.fab = fab;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            fab.setVisibility(View.VISIBLE);
        } else {
            fab.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}