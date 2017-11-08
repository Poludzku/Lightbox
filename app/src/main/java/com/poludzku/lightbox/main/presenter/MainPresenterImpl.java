package com.poludzku.lightbox.main.presenter;

import android.net.Uri;
import android.util.Log;

import com.poludzku.lightbox.app.model.Image;
import com.poludzku.lightbox.main.domain.ReadImageFromContentResolver;
import com.poludzku.lightbox.main.view.MainView;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter, ReadImageFromContentResolver.Callback {

    private ReadImageFromContentResolver readImageFromContentResolver;
    private MainView view;

    @Inject
    public MainPresenterImpl(ReadImageFromContentResolver readImageFromContentResolver,
                             MainView view) {
        this.readImageFromContentResolver = readImageFromContentResolver;
        this.readImageFromContentResolver.setCallback(this);
        this.view = view;
    }

    @Override
    public void handleViewImageIntent(Uri uri) {
        Log.d("uri:",uri.getPath());
        readImageFromContentResolver.execute(uri);

    }

    @Override
    public void onSuccess(Image image) {
        Log.d("image:",image.toString());
    }

    @Override
    public void onError(Throwable error) {
        view.showError(error);
    }
}
