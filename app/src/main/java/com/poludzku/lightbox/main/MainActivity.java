package com.poludzku.lightbox.main;

import android.animation.FloatArrayEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.poludzku.lightbox.R;
import com.poludzku.lightbox.app.LightboxApplication;
import com.poludzku.lightbox.app.model.Image;
import com.poludzku.lightbox.browser.view.Browser;
import com.poludzku.lightbox.main.di.MainModule;
import com.poludzku.lightbox.main.presenter.MainPresenter;
import com.poludzku.lightbox.main.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.image_container)
    ImageView imageContainer;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((LightboxApplication)getApplication())
                .getComponent()
                .plus(new MainModule(this))
                .inject(this);
        floatingActionButton.setOnClickListener(v -> {
            startActivity(new Intent(this,Browser.class));
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        presenter.loadImagesByHistory();
    }
    @Override
    protected void onDestroy(){
        presenter.cancel();
        super.onDestroy();
    }

    @Override
    public void showImages(List<Image> result) {
        imageContainer.setImageBitmap(result.get(0).getBitmap());
        Toast.makeText(this, "Number Of Images Loaded " + result.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(this, "ERROR " + throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}
