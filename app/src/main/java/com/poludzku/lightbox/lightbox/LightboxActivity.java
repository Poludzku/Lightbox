package com.poludzku.lightbox.lightbox;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.poludzku.lightbox.R;
import com.poludzku.lightbox.app.activity.BaseActivity;
import com.poludzku.lightbox.app.di.qualifier.ForHistory;
import com.poludzku.lightbox.app.model.Image;
import com.poludzku.lightbox.lightbox.di.LightboxModule;
import com.poludzku.lightbox.lightbox.presenter.LightboxPresenter;
import com.poludzku.lightbox.lightbox.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class LightboxActivity extends BaseActivity implements MainView {

    @BindView(R.id.image_container)
    ImageView imageContainer;

    @Inject
    LightboxPresenter lightboxPresenter;

    @Inject
    @ForHistory
    MutableLiveData<List<Image>> historyLiveData;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjection() {
        getAppComponent()
                .plus(new LightboxModule((this)))
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        historyLiveData.observe(this, images -> {
            if(!images.isEmpty()){
                imageContainer.setImageBitmap(images.get(images.size()-1).bitmap());
            } else {
                imageContainer.setImageBitmap(null);
            }
        });
        lightboxPresenter.processImageIntent(getIntent());
    }

    @Override
    protected void onStop() {
        lightboxPresenter.cleanUp();
        super.onStop();
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
