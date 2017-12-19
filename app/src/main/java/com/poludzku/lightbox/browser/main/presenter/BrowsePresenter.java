package com.poludzku.lightbox.browser.main.presenter;

import android.content.Intent;

public interface BrowsePresenter {

    void signIn();

    void handleSignIn(int requestCode, int resultCode, Intent data);
}
