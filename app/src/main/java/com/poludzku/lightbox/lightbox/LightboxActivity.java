package com.poludzku.lightbox.lightbox;

import android.widget.ImageView;

import com.poludzku.lightbox.R;
import com.poludzku.lightbox.app.activity.BaseActivity;
import com.poludzku.lightbox.app.model.Image;
import com.poludzku.lightbox.lightbox.di.MainModule;
import com.poludzku.lightbox.lightbox.view.MainView;

import java.util.List;

import butterknife.BindView;

public class LightboxActivity extends BaseActivity implements MainView {

    @BindView(R.id.image_container)
    ImageView imageContainer;

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

    @Override
    public void showImages(List<Image> result) {
        //TODO
    }

    @Override
    public void showError(Throwable throwable) {
        //TODO
    }
}
