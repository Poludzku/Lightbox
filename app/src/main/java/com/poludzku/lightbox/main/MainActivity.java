package com.poludzku.lightbox.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.poludzku.lightbox.R;
import com.poludzku.lightbox.app.LightboxApplication;
import com.poludzku.lightbox.app.model.Image;
import com.poludzku.lightbox.main.di.MainModule;
import com.poludzku.lightbox.main.presenter.MainPresenter;
import com.poludzku.lightbox.main.view.MainView;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {


    @Inject
    MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((LightboxApplication)getApplication())
                .getComponent()
                .plus(new MainModule(this))
                .inject(this);
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
        Toast.makeText(this, "Number Of Images Loaded " + result.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(this, "ERROR " + throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}
