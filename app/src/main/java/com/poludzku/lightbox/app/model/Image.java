package com.poludzku.lightbox.app.model;

import java.io.File;

/**
 * Created by Jacek on 17/07/2017.
 */

public class Image {

    File imageFile;

    Transformation imageTransformation;

    public static class Transformation {
        double x;
        double y;
    }
}
