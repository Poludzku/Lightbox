package com.poludzku.lightbox.main.domain;

import android.widget.ImageView;

import com.poludzku.lightbox.app.model.Image;
import com.poludzku.lightbox.app.repository.ImageRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jacek on 17/07/2017.
 */

public class LoadImagesByHistoryUseCase {

    LoadImagesByHistoryUseCaseCallback callback;

    ImageRepository imageRepository;

    public LoadImagesByHistoryUseCase(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void setCallback(LoadImagesByHistoryUseCaseCallback callback){
        this.callback = callback;
    }

    public void execute() {
       loadImages()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(this::onSuccess, this::onFail);
    }

    private void onSuccess(List<Image> images){
        if(callback != null){
            callback.onSucces(images);
        }
    }

    private void onFail(Throwable throwable){
        if (callback != null){
            callback.onFail(throwable);
        }
    }
// this is my repository model
    private Observable<List<Image>> loadImages(){
        return imageRepository.loadImagesByHistory();
    }
}
