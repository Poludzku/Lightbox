package com.poludzku.lightbox.lightbox.domain;

import android.arch.lifecycle.MutableLiveData;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import com.poludzku.lightbox.app.di.qualifier.ForAlbum;
import com.poludzku.lightbox.app.di.qualifier.ForHistory;
import com.poludzku.lightbox.app.model.Image;
import com.poludzku.lightbox.app.model.Transformation;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public class HandleImageIntentUseCase {

    private ContentResolver contentResolver;
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<List<Image>> albumImageLiveData;
    private MutableLiveData<List<Image>> historyImageLiveData;
    @Inject
    public HandleImageIntentUseCase(
            ContentResolver contentResolver,
            CompositeDisposable compositeDisposable,
            @ForAlbum MutableLiveData<List<Image>> albumImageLiveData,
            @ForHistory MutableLiveData<List<Image>> historyImageLiveData) {
        this.contentResolver = contentResolver;
        this.compositeDisposable = compositeDisposable;
        this.albumImageLiveData = albumImageLiveData;
        this.historyImageLiveData = historyImageLiveData;
    }

    public void execute(Intent intent) {
        if (Intent.ACTION_SEND.equals(intent.getAction()) &&
                intent.getType() != null &&
                intent.getType().startsWith("image/")) {
            Timber.d("Processing image from intent");
            readUri(intent.getParcelableExtra(Intent.EXTRA_STREAM));
        } else {
            Timber.d("No image found inside intent");
        }
    }

    private void readUri(Uri uri) {
        compositeDisposable.add(createInputStream(uri)
                .map(this::mapStreamToBitmap)
                .map(bitmap -> mapBitmapToImage(bitmap,uri))
                .subscribe(this::onResult, this::onError));
    }

    private Single<InputStream> createInputStream(Uri uri) {
        return Single.fromCallable(() -> contentResolver.openInputStream(uri));
    }

    private Bitmap mapStreamToBitmap(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    private Image mapBitmapToImage(Bitmap bitmap, Uri uri) {
        return Image.builder()
                .bitmap(bitmap)
                .uri(uri)
                .transformation(
                        Transformation.builder().build()
                ).build();
    }

    private void onResult(Image image) {
        Timber.d("success creating Image");
        List<Image> album = albumImageLiveData.getValue();
        if(album == null) {
            album = new ArrayList<>();
        }
        album.add(image);
        albumImageLiveData.setValue(album);

        List<Image> history = historyImageLiveData.getValue();
        if(history == null) {
            history = new ArrayList<>();
        }
        history.add(image);
        historyImageLiveData.setValue(history);
    }

    private void onError(Throwable throwable) {
        //TODO propagate error
        Timber.e(throwable);
    }

}


