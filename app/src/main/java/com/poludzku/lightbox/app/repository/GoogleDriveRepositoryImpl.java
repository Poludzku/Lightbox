package com.poludzku.lightbox.app.repository;

import android.support.annotation.NonNull;

import com.google.android.gms.drive.DriveClient;
import com.google.android.gms.drive.DriveResourceClient;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.Iterator;

import javax.inject.Inject;

import timber.log.Timber;

public class GoogleDriveRepositoryImpl implements GoogleDriveRepository,
        OnFailureListener,
        OnSuccessListener<MetadataBuffer>
{

    private DriveResourceClient driveResourceClient;

    @Inject
    public GoogleDriveRepositoryImpl() {}

    @Override
    public void setClients(DriveClient driveClient, DriveResourceClient driveResourceClient) {
        this.driveResourceClient = driveResourceClient;
    }

    @Override
    public void query(Query query) {
        driveResourceClient.query(query)
                .addOnFailureListener(this)
                .continueWith((Continuation<MetadataBuffer, Void>) task -> {
                    MetadataBuffer metadataBuffer = task.getResult();
                    Timber.i("onSuccess:"+metadataBuffer.getCount());

                return null;
                });
    }

    @Override
    public void onFailure(@NonNull Exception e) {
        Timber.e(e);
    }

    @Override
    public void onSuccess(MetadataBuffer metadata) {

    }
}
