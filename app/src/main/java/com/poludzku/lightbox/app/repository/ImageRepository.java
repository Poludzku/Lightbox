package com.poludzku.lightbox.app.repository;

import com.poludzku.lightbox.app.model.Image;


public interface ImageRepository {

    void addImage(Image image);

    boolean removeImage(Image image);

    void clear();

}
