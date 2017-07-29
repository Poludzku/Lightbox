package com.poludzku.lightbox.app.repository;

import com.poludzku.lightbox.app.model.Image;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Jacek on 29/07/2017.
 */

public interface ImageRepository {
    Observable<List<Image>> loadImagesByHistory();
    Observable<List<Image>> loadImagesByUsage();
}
