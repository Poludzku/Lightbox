package com.poludzku.lightbox.main.domain;


import android.net.Uri;

import com.poludzku.lightbox.app.model.Image;

public interface ReadImageFromContentResolver {

    void execute(Uri uri);
    void setCallback(Callback callback);
    void clear();

    interface Callback{
        void onSuccess(Image image);
        void onError(Throwable error);
    }
}
