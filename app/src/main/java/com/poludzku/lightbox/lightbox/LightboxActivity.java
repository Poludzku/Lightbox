package com.poludzku.lightbox.lightbox;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.widget.ImageView;

import com.poludzku.lightbox.R;
import com.poludzku.lightbox.app.activity.BaseActivity;
import com.poludzku.lightbox.app.model.Image;
import com.poludzku.lightbox.browser.main.view.Browser;
import com.poludzku.lightbox.lightbox.di.MainModule;
import com.poludzku.lightbox.lightbox.view.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class LightboxActivity extends BaseActivity implements MainView {

    @BindView(R.id.image_container)
    ImageView imageContainer;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjection() {
        getAppComponent()
                .plus(new MainModule((this)))
                .inject(this);
    }

    @OnClick(R.id.fab)
    public void onFabClick() {
        startActivity(new Intent(this, Browser.class));
    }

    @Override
    public void showImages(List<Image> result) {
        //TODO
    }

    @Override
    public void showError(Throwable throwable) {
        //TODO
    }
}
