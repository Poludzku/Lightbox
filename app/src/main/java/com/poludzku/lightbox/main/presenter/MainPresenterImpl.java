package com.poludzku.lightbox.main.presenter;

import com.poludzku.lightbox.app.model.Image;
import com.poludzku.lightbox.main.domain.LoadImagesByHistoryUseCase;
import com.poludzku.lightbox.main.domain.LoadImagesByHistoryUseCaseCallback;
import com.poludzku.lightbox.main.view.MainView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Jacek on 17/07/2017.
 */

public class MainPresenterImpl implements MainPresenter, LoadImagesByHistoryUseCaseCallback {

    private LoadImagesByHistoryUseCase loadImagesByHistoryUseCase;
    private MainView view;

    @Inject
    public MainPresenterImpl(LoadImagesByHistoryUseCase loadImagesByHistoryUseCase, MainView view) {
        this.loadImagesByHistoryUseCase = loadImagesByHistoryUseCase;
        this.loadImagesByHistoryUseCase.setCallback(this);
        this.view = view;
    }

    @Override
    public void loadImagesByHistory() {
        loadImagesByHistoryUseCase.execute();
    }

    @Override
    public void onSucces(List<Image> result) {
        view.showImages(result);
    }

    @Override
    public void onFail(Throwable throwable) {
        view.showError(throwable);
    }

    @Override
    public void cancel() {
        loadImagesByHistoryUseCase.setCallback(null);
    }
}
