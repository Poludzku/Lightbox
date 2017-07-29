package com.poludzku.lightbox.main.domain;

import com.poludzku.lightbox.app.model.Image;

import java.util.List;

/**
 * Created by Jacek on 17/07/2017.
 */

public interface LoadImagesByHistoryUseCaseCallback {
    void onSucces(List<Image> result);

    void onFail(Throwable throwable);
}
