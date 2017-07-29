package com.poludzku.lightbox.app.repository;

import com.poludzku.lightbox.app.model.Image;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Jacek on 29/07/2017.
 */

public class MockImageRepository implements ImageRepository {
    @Override
    public Observable<List<Image>> loadImagesByHistory() {
            List<Image> result = new ArrayList<>();
        result.add(new Image());
        result.add(new Image());
        result.add(new Image());
        return Observable.just(result);
    }

    @Override
    public Observable<List<Image>> loadImagesByUsage() {
        return null;
    }
}
