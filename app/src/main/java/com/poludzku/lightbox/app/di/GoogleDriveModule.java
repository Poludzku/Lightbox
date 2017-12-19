package com.poludzku.lightbox.app.di;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.drive.Drive;
import com.poludzku.lightbox.R;
import com.poludzku.lightbox.app.di.scope.PerApplication;
import com.poludzku.lightbox.app.repository.GoogleDriveRepository;
import com.poludzku.lightbox.app.repository.GoogleDriveRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class GoogleDriveModule {

    @PerApplication
    @Provides
    GoogleSignInClient googleSignInClient(@PerApplication Context context) {
        GoogleSignInOptions signInOptions =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(context.getString(R.string.default_web_client_id))
                        .requestEmail()
                        .requestScopes(Drive.SCOPE_FILE)
                        .requestScopes(Drive.SCOPE_APPFOLDER)
                        .build();
        return GoogleSignIn.getClient(context, signInOptions);
    }

    @PerApplication
    @Provides
    GoogleDriveRepository googleDriveRepository(GoogleDriveRepositoryImpl googleDriveRepository) {
        return googleDriveRepository;
    }

}
