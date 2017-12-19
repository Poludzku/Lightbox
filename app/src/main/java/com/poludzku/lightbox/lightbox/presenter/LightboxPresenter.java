package com.poludzku.lightbox.lightbox.presenter;

import android.content.Intent;


public interface LightboxPresenter {

    void processImageIntent(Intent intent);

    void cleanUp();
}
