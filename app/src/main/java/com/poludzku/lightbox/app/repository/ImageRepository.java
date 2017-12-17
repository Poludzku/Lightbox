package com.poludzku.lightbox.app.repository;

import com.poludzku.lightbox.app.model.Image;

/**
 * Used by Album and History
 */
public interface ImageRepository {

    void addImage(Image image);

    boolean removeImage(Image image);

    void clear();

}
