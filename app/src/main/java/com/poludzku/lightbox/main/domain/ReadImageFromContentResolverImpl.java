package com.poludzku.lightbox.main.domain;


import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import com.poludzku.lightbox.app.model.Image;
import com.poludzku.lightbox.app.model.Transformation;

import java.io.InputStream;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class ReadImageFromContentResolverImpl implements ReadImageFromContentResolver {

    ContentResolver contentResolver;
    Disposable disposable;
    Callback callback;

    @Inject
    public ReadImageFromContentResolverImpl(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    @Override
    public void execute(Uri uri) {
        disposable = createInputStream(uri)
                .map(this::mapStreamToBitmap)
                .map(this::mapBitmapToImage)
                .subscribe(this::onResult,this::onError);
    }

    @Override
    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void clear() {
        callback = null;
        if(disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    private Single<InputStream> createInputStream(Uri uri){
        return Single.fromCallable(()-> contentResolver.openInputStream(uri));
    }

    private Bitmap mapStreamToBitmap(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    private Image mapBitmapToImage(Bitmap bitmap) {
        return Image.builder()
                .bitmap(bitmap)
                .transformation(
                    Transformation.builder().build()
                ).build();
    }

    private void onResult(Image image) {
        callback.onSuccess(image);
    }

    private void onError(Throwable throwable) {
        callback.onError(throwable);
    }

}
