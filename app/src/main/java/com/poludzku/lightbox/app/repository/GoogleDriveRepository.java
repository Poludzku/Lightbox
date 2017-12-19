package com.poludzku.lightbox.app.repository;

import com.google.android.gms.drive.DriveClient;
import com.google.android.gms.drive.DriveResourceClient;
import com.google.android.gms.drive.query.Query;

public interface GoogleDriveRepository {
    void setClients(DriveClient driveClient, DriveResourceClient driveResourceClient);
    void query(Query query);

}
