package com.poludzku.lightbox.lightbox.presenter;

import android.content.Intent;

import com.poludzku.lightbox.lightbox.domain.HandleImageIntentUseCase;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LightboxPresenterImpl implements LightboxPresenter {

    private HandleImageIntentUseCase handleImageIntentUseCase;

    private CompositeDisposable compositeDisposable;



    @Inject
    public LightboxPresenterImpl(HandleImageIntentUseCase handleImageIntentUseCase, CompositeDisposable compositeDisposable) {
        this.handleImageIntentUseCase = handleImageIntentUseCase;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void processImageIntent(Intent intent) {
        handleImageIntentUseCase.execute(intent);
    }

    @Override
    public void cleanUp() {
        compositeDisposable.clear();
    }
}
