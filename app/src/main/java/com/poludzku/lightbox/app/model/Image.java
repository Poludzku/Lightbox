package com.poludzku.lightbox.app.model;

import android.graphics.Bitmap;

import com.google.auto.value.AutoValue;

/**
 * Created by Jacek on 17/07/2017.
 */
@AutoValue
public abstract class Image {

    public abstract Bitmap getBitmap();
    public abstract Transformation getTransformation();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_Image.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder{
        public abstract Builder bitmap(Bitmap bitmap);
        public abstract Builder transformation(Transformation transformation);
        public abstract Image build();
    }

    Transformation imageTransformation;

}