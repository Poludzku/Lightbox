package com.poludzku.lightbox.browser.main.domain;


import android.app.Activity;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import javax.inject.Inject;

public class SignInGoogleDriveUseCase {

    public static final int SIGN_IN_TO_GOOGLE_DRIVE_CODE = 1001;

    private Activity activity;
    private GoogleSignInClient signInClient;

    @Inject
    public SignInGoogleDriveUseCase(Activity context, GoogleSignInClient signInClient) {
        this.activity = context;
        this.signInClient = signInClient;
    }

    public void execute() {
        activity.startActivityForResult(signInClient.getSignInIntent(), SIGN_IN_TO_GOOGLE_DRIVE_CODE);
    }

}

