package com.poludzku.lightbox.app.repository;

import com.poludzku.lightbox.app.model.Image;

import java.util.ArrayList;
import java.util.List;


public class ImageMemoryRepository implements ImageRepository {

    private List<Image> album = new ArrayList<>();

    @Override
    public void addImage(Image image) {
        if(!album.contains(image)){
            album.add(image);
        }
    }

    @Override
    public boolean removeImage(Image image) {
        return album.remove(image);
    }

    @Override
    public void clear() {
        album.clear();
    }
}
