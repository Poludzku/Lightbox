package com.poludzku.lightbox.app.repository;

import com.poludzku.lightbox.app.model.Image;


public interface LightboxRepository {

    void addImage(Image image);

    boolean removeImage(Image image);


}
