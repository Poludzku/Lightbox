package com.poludzku.lightbox.browser.main.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.poludzku.lightbox.R;
import com.poludzku.lightbox.app.LightboxApplication;
import com.poludzku.lightbox.browser.main.di.BrowserComponent;
import com.poludzku.lightbox.browser.main.di.BrowserModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Browser extends AppCompatActivity {

    @BindView(R.id.container)
    ViewPager mViewPager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @Inject
    SectionsPagerAdapter mSectionsPagerAdapter;

    BrowserComponent browserComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        browserComponent = ((LightboxApplication)getApplication()).getComponent()
                .plus(new BrowserModule(getSupportFragmentManager()));

        browserComponent.inject(this);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        mViewPager.addOnPageChangeListener(new FabVisibilityHandler(floatingActionButton));
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_browser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }

    public BrowserComponent getBrowserComponent() {
        return browserComponent;
    }

}
