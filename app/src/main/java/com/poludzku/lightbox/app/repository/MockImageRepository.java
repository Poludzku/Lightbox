package com.poludzku.lightbox.app.repository;

import android.content.Context;

import com.poludzku.lightbox.app.model.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Jacek on 29/07/2017.
 */

public class MockImageRepository implements ImageRepository {

    Context context;

    public MockImageRepository(Context context) {
        this.context = context;
    }

    @Override
    public Observable<List<Image>> loadImagesByHistory() {
            List<Image> result = new ArrayList<>();
            Image image = new Image(
                    new File(
                            context.getExternalFilesDir("."),
                            "historia.jpg"
                    ),
                    new Image.Transformation()
            );
        result.add(image);
        //throw new IllegalArgumentException(context.getExternalFilesDir(".").getAbsolutePath());
        return Observable.just(result);
    }

    @Override
    public Observable<List<Image>> loadImagesByUsage() {
        return null;
    }
}
