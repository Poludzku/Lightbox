package com.poludzku.lightbox.main.di;

import com.poludzku.lightbox.app.di.scope.PerActivity;
import com.poludzku.lightbox.app.repository.ImageRepository;
import com.poludzku.lightbox.main.domain.LoadImagesByHistoryUseCase;
import com.poludzku.lightbox.main.presenter.MainPresenter;
import com.poludzku.lightbox.main.presenter.MainPresenterImpl;
import com.poludzku.lightbox.main.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jacek on 30/06/2017.
 */
@Module
public class MainModule {

    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    MainPresenter provideMainPresenter(MainPresenterImpl mainPresenter){
        return mainPresenter;
    }

    @Provides
    @PerActivity
    LoadImagesByHistoryUseCase loadImagesByHistoryUseCase(ImageRepository imageRepository){
        return new LoadImagesByHistoryUseCase(imageRepository);
    }
    @Provides
    @PerActivity
    MainView mainView(){
        return view;
    }
}

