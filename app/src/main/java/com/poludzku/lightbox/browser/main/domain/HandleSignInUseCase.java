package com.poludzku.lightbox.browser.main.domain;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveClient;
import com.google.android.gms.drive.DriveResourceClient;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;
import com.google.android.gms.tasks.Task;
import com.poludzku.lightbox.app.repository.GoogleDriveRepository;

import javax.inject.Inject;

import timber.log.Timber;

public class HandleSignInUseCase {
    GoogleDriveRepository googleDriveRepository;
    GoogleSignInClient googleSignInClient;
    Context context;

    @Inject
    public HandleSignInUseCase(GoogleDriveRepository googleDriveRepository, Context context) {
        this.googleDriveRepository = googleDriveRepository;
        this.context = context;
    }

    public void execute(int resultCode, Intent data) {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            Timber.i("SUCCESS");

            DriveClient driveClient = Drive.getDriveClient(context, account);
            DriveResourceClient driveResourceClient =
                    Drive.getDriveResourceClient(context, account);
            googleDriveRepository.setClients(driveClient, driveResourceClient);
            googleDriveRepository.query(new Query.Builder().addFilter(

                            //Filters.eq(SearchableField.MIME_TYPE, "image/jpeg"),
                            //Filters.eq(SearchableField.MIME_TYPE, "image/png"),
                            Filters.sharedWithMe()
                    ).build());
        } catch (ApiException e) {
            Timber.e(e);
        }

    }
}
