package com.poludzku.lightbox.app.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

/**
 * Created by Jacek on 17/07/2017.
 */

public class Image {

    File imageFile;

    Transformation imageTransformation;

    public Image(File imageFile, Transformation imageTransformation) {
        this.imageFile = imageFile;
        this.imageTransformation = imageTransformation;
    }

    public Bitmap getBitmap(){
        return BitmapFactory.decodeFile(imageFile.getAbsolutePath());
    }

    public File getImageFile() {
        return imageFile;
    }

    public Transformation getImageTransformation() {
        return imageTransformation;
    }

    public static class Transformation {
        double x;
        double y;
    }
}