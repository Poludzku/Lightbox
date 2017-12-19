package com.poludzku.lightbox.lightbox.di;

import android.arch.lifecycle.MutableLiveData;
import android.content.ContentResolver;

import com.poludzku.lightbox.app.di.qualifier.ForAlbum;
import com.poludzku.lightbox.app.di.qualifier.ForHistory;
import com.poludzku.lightbox.app.di.scope.PerActivity;
import com.poludzku.lightbox.app.model.Image;
import com.poludzku.lightbox.lightbox.domain.HandleImageIntentUseCase;
import com.poludzku.lightbox.lightbox.presenter.LightboxPresenterImpl;
import com.poludzku.lightbox.lightbox.presenter.LightboxPresenter;
import com.poludzku.lightbox.lightbox.view.MainView;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class LightboxModule {

    private MainView view;

    public LightboxModule(MainView view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    MainView mainView() {
        return view;
    }

    @Provides
    @PerActivity
    CompositeDisposable compositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    LightboxPresenter lightboxPresenter(LightboxPresenterImpl lightboxPresenter) {
        return lightboxPresenter;
    }

    @Provides
    @PerActivity
    HandleImageIntentUseCase handleImageIntentUseCase(
            ContentResolver contentResolver,
            CompositeDisposable compositeDisposable,
            @ForAlbum MutableLiveData<List<Image>> albumImageLiveData,
            @ForHistory MutableLiveData<List<Image>> historyImageLiveData) {
        return new HandleImageIntentUseCase(
                contentResolver,
                compositeDisposable,
                albumImageLiveData,
                historyImageLiveData);
    }
}

