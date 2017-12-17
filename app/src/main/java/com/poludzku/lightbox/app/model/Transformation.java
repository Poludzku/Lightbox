package com.poludzku.lightbox.app.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Transformation {

    public static Builder builder() {
        return new AutoValue_Transformation.Builder().x(0).y(0).sx(1.0).sy(1.0);
    }

    public abstract double x();

    public abstract double y();

    public abstract double sx();

    public abstract double sy();

    public abstract Builder toBuilder();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder x(double x);

        public abstract Builder y(double y);

        public abstract Builder sx(double sx);

        public abstract Builder sy(double sy);

        public abstract Transformation build();
    }

}
