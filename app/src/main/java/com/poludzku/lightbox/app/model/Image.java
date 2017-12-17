package com.poludzku.lightbox.app.model;

import android.graphics.Bitmap;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Image {

    Transformation imageTransformation;

    public static Builder builder() {
        return new AutoValue_Image.Builder();
    }

    public abstract Bitmap getBitmap();

    public abstract Transformation getTransformation();

    public abstract Builder toBuilder();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder bitmap(Bitmap bitmap);

        public abstract Builder transformation(Transformation transformation);

        public abstract Image build();
    }

}