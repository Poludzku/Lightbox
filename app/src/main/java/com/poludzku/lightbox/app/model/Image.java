package com.poludzku.lightbox.app.model;

import android.net.Uri;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class Image {

    Transformation imageTransformation;

    public static Builder builder() {
        return new AutoValue_Image.Builder();
    }

    public abstract Uri uri();

    public abstract Transformation transformation();

    @Nullable
    public abstract List<String> tags();

    public abstract Builder toBuilder();

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder uri(Uri uri);

        public abstract Builder transformation(Transformation transformation);

        public abstract Builder tags(List<String> tags);

        public abstract Image build();
    }

    /**
     * We recognise images by {@link #uri()}
     *
     * @param o
     * @return true when Uri matches
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        return image.uri().equals(uri());
    }


}