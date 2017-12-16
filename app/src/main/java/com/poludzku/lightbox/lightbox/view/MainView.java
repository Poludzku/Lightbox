package com.poludzku.lightbox.lightbox.view;

import com.poludzku.lightbox.app.model.Image;

import java.util.List;

/**
 * Created by Jacek on 17/07/2017.
 */

public interface MainView {
    void showImages(List<Image> result);

    void showError(Throwable throwable);
}
