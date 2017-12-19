package com.poludzku.lightbox.browser.main.presenter;

import android.content.Intent;

import com.poludzku.lightbox.browser.main.domain.SignInGoogleDriveUseCase;
import com.poludzku.lightbox.browser.main.domain.HandleSignInUseCase;

import javax.inject.Inject;


public class BrowsePresenterImpl implements BrowsePresenter {

    private SignInGoogleDriveUseCase signInGoogleDriveUseCase;
    private HandleSignInUseCase handleSignInUseCase;

    @Inject
    public BrowsePresenterImpl(SignInGoogleDriveUseCase signInGoogleDriveUseCase, HandleSignInUseCase handleSignInUseCase) {
        this.signInGoogleDriveUseCase = signInGoogleDriveUseCase;
        this.handleSignInUseCase = handleSignInUseCase;
    }

    @Override
    public void signIn() {
        signInGoogleDriveUseCase.execute();
    }

    @Override
    public void handleSignIn(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case SignInGoogleDriveUseCase.SIGN_IN_TO_GOOGLE_DRIVE_CODE:
                handleSignInUseCase.execute(resultCode,data);
                break;
        }

    }
}
