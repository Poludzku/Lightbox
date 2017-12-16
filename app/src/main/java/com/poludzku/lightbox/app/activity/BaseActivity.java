package com.poludzku.lightbox.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.poludzku.lightbox.app.LightboxApplication;
import com.poludzku.lightbox.app.di.AppComponent;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayout();

    protected abstract void initInjection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initInjection();
    }

    protected final AppComponent getAppComponent() {
        return ((LightboxApplication) getApplication())
                .getComponent();
    }

}
